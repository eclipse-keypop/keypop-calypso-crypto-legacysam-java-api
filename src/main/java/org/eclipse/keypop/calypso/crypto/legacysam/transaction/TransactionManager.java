/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keypop.calypso.crypto.legacysam.transaction;

import org.eclipse.keypop.reader.ChannelControl;
import org.eclipse.keypop.reader.transaction.spi.CardTransactionManager;

/**
 * Common API for all legacy SAM transaction managers.
 *
 * <p>Extends {@link CardTransactionManager} to provide common card transaction operations.
 *
 * @param <T> The type of the lowest level child object.
 * @since 0.1.0
 */
public interface TransactionManager<T extends TransactionManager<T>>
    extends CardTransactionManager<T> {

  /**
   * Process all previously prepared commands.
   *
   * @return The current instance.
   * @throws ReaderIOException If a communication error with the card reader or SAM reader occurs.
   * @throws SamIOException If a communication error with the SAM occurs.
   * @throws InvalidSignatureException If a signature associated to a prepared signature
   *     verification command is invalid.
   * @throws UnexpectedCommandStatusException If a command returns an unexpected status.
   * @throws InconsistentDataException If inconsistent data have been detected.
   * @since 0.1.0
   * @deprecated Use {@link #processCommands(ChannelControl)} instead.
   */
  @Deprecated
  T processCommands();

  /**
   * {@inheritDoc}
   *
   * @throws InvalidSignatureException If a signature associated to a prepared signature
   *     verification command is invalid.
   * @throws InconsistentDataException If inconsistent data have been detected.
   * @since 0.8.0
   */
  @Override
  T processCommands(ChannelControl channelControl);
}
