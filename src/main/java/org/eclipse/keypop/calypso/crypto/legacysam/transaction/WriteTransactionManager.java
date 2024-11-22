/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.crypto.legacysam.transaction;

import org.eclipse.keypop.calypso.crypto.legacysam.CounterIncrementAccess;
import org.eclipse.keypop.calypso.crypto.legacysam.sam.LegacySam;

/**
 * Transaction manager dedicated to "WRITE" operations.
 *
 * <p>The write operations defined here can be executed synchronously or asynchronously.
 *
 * @param <T> The type of the lowest level child object.
 * @since 0.2.0
 */
public interface WriteTransactionManager<T extends WriteTransactionManager<T>>
    extends TransactionManager<T> {

  /**
   * Schedules the execution of a "Write Ceilings" command to write a single counter ceiling.
   *
   * <p>Warning: in the case of an asynchronous transaction the content of the {@link LegacySam}
   * object will not be updated.
   *
   * @param counterNumber The number of the counter whose ceiling is to be written (in range
   *     [0..26]).
   * @param ceilingValue The desired value for the ceiling. The ceiling value is defined as a
   *     positive integer less than or equal to 16777210 (in hexadecimal: FFFFFAh).
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @since 0.2.0
   */
  T prepareWriteCounterCeiling(int counterNumber, int ceilingValue);

  /**
   * Schedules the execution of a "Write Ceilings" command to write a counter ceiling and its free
   * incrementation configuration.
   *
   * <p>Note: as this command generates the writing of a full record corresponding to 9 counters, it
   * is necessary either to have read the status of the counters beforehand, or to have called this
   * method for each of the 8 other counters of the same record. Otherwise, an exception will be
   * raised when processing the command.
   *
   * <p>Warning: in the case of an asynchronous transaction the content of the {@link LegacySam}
   * object will not be updated.
   *
   * @param counterNumber The number of the counter whose ceiling is to be written (in range
   *     [0..26]).
   * @param ceilingValue The desired value for the ceiling. The ceiling value is defined as a
   *     positive integer less than or equal to 16777210 (in hexadecimal: FFFFFAh).
   * @param counterIncrementAccess The counter increment access mode.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @since 0.2.0
   */
  T prepareWriteCounterConfiguration(
      int counterNumber, int ceilingValue, CounterIncrementAccess counterIncrementAccess);
}
