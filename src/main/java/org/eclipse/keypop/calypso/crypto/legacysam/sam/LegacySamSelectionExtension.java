/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.crypto.legacysam.sam;

import org.eclipse.keypop.calypso.crypto.legacysam.LegacySamApiFactory;
import org.eclipse.keypop.calypso.crypto.legacysam.SystemKeyType;
import org.eclipse.keypop.calypso.crypto.legacysam.spi.LegacySamDynamicUnlockDataProviderSpi;
import org.eclipse.keypop.calypso.crypto.legacysam.spi.LegacySamStaticUnlockDataProviderSpi;
import org.eclipse.keypop.reader.CardReader;
import org.eclipse.keypop.reader.selection.spi.CardSelectionExtension;

/**
 * Extends the {@link CardSelectionExtension} interface of the "Keypop Reader API" to provide means
 * to define optional commands to be executed during the selection phase such as the "Unlock"
 * command.
 *
 * <p>An instance of this interface can be obtained by using either the {@link
 * LegacySamApiFactory#createLegacySamSelectionExtension()} method or the {@link
 * LegacySamApiFactory#createLegacySamSelectionExtension(CardReader)} method.
 *
 * <p>In the case where the SAM is locked, three options are proposed:
 *
 * <ul>
 *   <li>The application provides directly the 16-byte unlock value expected by the SAM in static
 *       mode ({@link #setUnlockData(String)} and {@link #setUnlockData(String,
 *       LegacySam.ProductType)}).
 *   <li>The application implements a {@link LegacySamStaticUnlockDataProviderSpi} used to compute
 *       the 16-byte value expected byte the SAM in static mode (may diversified with the SAM serial
 *       number) ({@link #setStaticUnlockDataProvider(LegacySamStaticUnlockDataProviderSpi)}).
 *   <li>The application implements a {@link LegacySamDynamicUnlockDataProviderSpi} used to have the
 *       8-byte value expected by the SAM in dynamic mode computed by an origin SAM ({@link
 *       #setDynamicUnlockDataProvider(LegacySamDynamicUnlockDataProviderSpi)}).
 * </ul>
 *
 * All three methods are exclusive.
 *
 * @since 0.3.0
 */
public interface LegacySamSelectionExtension extends CardSelectionExtension {

  /**
   * Sets the unlock data to be used to unlock a SAM C1 (8 or 16 bytes) and schedules the execution
   * of the "Unlock data" command in the first position.
   *
   * <p>The "Unlock" command will be executed only after a successful filtering.
   *
   * @param unlockData Unlock data as a 32-character hexadecimal string.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided unlock data is null, malformed or out of
   *     range.
   * @throws IllegalStateException If an unlocking setting has already been set.
   * @since 0.1.0
   */
  LegacySamSelectionExtension setUnlockData(String unlockData);

  /**
   * Sets the unlock data to be used to unlock a SAM (8 or 16 bytes) and schedules the execution of
   * the "Unlock data" command in the first position.
   *
   * <p>The "Unlock" command will be executed only after a successful filtering.
   *
   * @param unlockData Unlock data as a 32-character hexadecimal string.
   * @param productType The targeted product type.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided unlock data or product type is null, malformed
   *     or out of range.
   * @throws IllegalStateException If an unlocking setting has already been set.
   * @since 0.3.0
   */
  LegacySamSelectionExtension setUnlockData(String unlockData, LegacySam.ProductType productType);

  /**
   * Sets the unlock data provider to use for unlocking the SAM in static mode.
   *
   * <p>When using this method, a non-null SAM {@link CardReader} must be provided to the SAM
   * selection extension.
   *
   * <p>The "Unlock" command is initiated once the filtering is successfully completed, followed by
   * a request to the provider to obtain the needed unlocking data.
   *
   * @param unlockDataProvider An implementation of {@link LegacySamStaticUnlockDataProviderSpi}.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided argument is null.
   * @throws IllegalStateException If an unlocking setting has already been set.
   * @see LegacySamApiFactory#createLegacySamSelectionExtension(CardReader)
   * @since 0.4.0
   */
  LegacySamSelectionExtension setStaticUnlockDataProvider(
      LegacySamStaticUnlockDataProviderSpi unlockDataProvider);

  /**
   * Sets the unlock data provider to use for unlocking the SAM in dynamic mode.
   *
   * <p>When using this method, a non-null SAM {@link CardReader} must be provided to the SAM
   * selection extension.
   *
   * <p>The "Unlock" command is initiated once the filtering is successfully completed, followed by
   * a request to the provider to obtain the needed unlocking data.
   *
   * @param unlockDataProvider An implementation of {@link LegacySamDynamicUnlockDataProviderSpi}.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided argument is null.
   * @throws IllegalStateException If an unlocking setting has already been set.
   * @see LegacySamApiFactory#createLegacySamSelectionExtension(CardReader)
   * @since 0.4.0
   */
  LegacySamSelectionExtension setDynamicUnlockDataProvider(
      LegacySamDynamicUnlockDataProviderSpi unlockDataProvider);

  /**
   * Schedules the execution of a "Read Key Parameters" command for a system key.
   *
   * <p>Once this command is processed, the result is accessible with {@link
   * LegacySam#getSystemKeyParameter(SystemKeyType)}.
   *
   * @param systemKeyType The type of system key.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided argument is null.
   * @since 0.3.0
   */
  LegacySamSelectionExtension prepareReadSystemKeyParameters(SystemKeyType systemKeyType);

  /**
   * Schedules the execution of a "Read Event Counter" and "Read Ceiling" commands to read the
   * status of a counter.
   *
   * <p>Note: the status of each counter of the record to which the targeted counter belongs will be
   * read. The number of commands actually transmitted to the SAM will be optimized before to be
   * transmitted.
   *
   * @param counterNumber The number of the counter whose status is to be read (in range [0..26]).
   * @return The current instance.
   * @throws IllegalArgumentException If the provided argument is out of range.
   * @since 0.3.0
   */
  LegacySamSelectionExtension prepareReadCounterStatus(int counterNumber);

  /**
   * Schedules the execution of a "Read Event Counter" and "Read Ceiling" commands to read the
   * status of all counters.
   *
   * @return The current instance.
   * @since 0.3.0
   */
  LegacySamSelectionExtension prepareReadAllCountersStatus();
}
