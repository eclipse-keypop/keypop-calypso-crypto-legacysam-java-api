/*
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 */
package org.eclipse.keypop.calypso.crypto.legacysam.transaction;

import org.eclipse.keypop.calypso.crypto.legacysam.SystemKeyType;
import org.eclipse.keypop.calypso.crypto.legacysam.sam.LegacySam;

/**
 * Transaction manager dedicated to "READ" operations.
 *
 * @param <T> The type of the lowest level child object.
 * @since 0.1.0
 */
public interface ReadTransactionManager<T extends ReadTransactionManager<T>>
    extends TransactionManager<T> {

  /**
   * Schedules the execution of a "Read Key Parameters" command for a system key.
   *
   * <p>Once this command is processed, the result is accessible with {@link
   * LegacySam#getSystemKeyParameter(SystemKeyType)}.
   *
   * @param systemKeyType The type of system key.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided argument is null.
   * @since 0.2.0
   */
  T prepareReadSystemKeyParameters(SystemKeyType systemKeyType);

  /**
   * Schedules the execution of a "Read Event Counter" and "Read Ceiling" commands to read the
   * status of a counter.
   *
   * <p>Note: the status of each counter of the record to which the targeted counter belongs will be
   * read. The number of commands actually transmitted to the SAM will be optimized when the {@link
   * #processCommands()} method is executed.
   *
   * @param counterNumber The number of the counter whose status is to be read (in range [0..26]).
   * @return The current instance.
   * @throws IllegalArgumentException If the provided argument is out of range.
   * @since 0.2.0
   */
  T prepareReadCounterStatus(int counterNumber);

  /**
   * Schedules the execution of a "Read Event Counter" and "Read Ceiling" commands to read the
   * status of all counters.
   *
   * @return The current instance.
   * @since 0.2.0
   */
  T prepareReadAllCountersStatus();
}
