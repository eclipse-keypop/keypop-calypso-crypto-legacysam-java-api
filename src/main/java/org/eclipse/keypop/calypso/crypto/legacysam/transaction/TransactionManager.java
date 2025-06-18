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

/**
 * Common API for all legacy SAM transaction managers.
 *
 * @param <T> The type of the lowest level child object.
 * @since 0.1.0
 */
public interface TransactionManager<T extends TransactionManager<T>> {

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
   */
  T processCommands();
}
