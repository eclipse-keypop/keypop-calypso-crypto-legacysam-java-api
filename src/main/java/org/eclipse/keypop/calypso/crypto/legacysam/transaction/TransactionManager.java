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
