/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 ************************************************************************************** */
package org.eclipse.keypop.calypso.crypto.legacysam.sam;

import org.eclipse.keypop.calypso.crypto.legacysam.LegacySamApiFactory;
import org.eclipse.keypop.calypso.crypto.legacysam.SystemKeyType;
import org.eclipse.keypop.reader.selection.spi.CardSelectionExtension;

/**
 * Extends the {@link CardSelectionExtension} interface of the "Keypop Reader API" to provide means
 * to define optional commands to be executed during the selection phase such as the "Unlock"
 * command.
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * LegacySamApiFactory#createLegacySamSelectionExtension()}.
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
   * @param unlockData Unlock data as a 16- or 32-character hexadecimal string.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided unlock data is null, malformed or out of
   *     range.
   * @since 0.1.0
   */
  LegacySamSelectionExtension setUnlockData(String unlockData);

  /**
   * Sets the unlock data to be used to unlock a SAM (8 or 16 bytes) and schedules the execution of
   * the "Unlock data" command in the first position.
   *
   * <p>The "Unlock" command will be executed only after a successful filtering.
   *
   * @param unlockData Unlock data as a 16- or 32-character hexadecimal string.
   * @param productType The targeted product type.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided unlock data or product type is null, malformed
   *     or out of range.
   * @since 0.3.0
   */
  LegacySamSelectionExtension setUnlockData(String unlockData, LegacySam.ProductType productType);

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
