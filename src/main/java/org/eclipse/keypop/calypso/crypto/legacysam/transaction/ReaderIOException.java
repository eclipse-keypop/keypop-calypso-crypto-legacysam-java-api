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
 * Indicates a communication error with the reader of the card or SAM.
 *
 * @since 0.1.0
 * @deprecated This exception is replaced by {@link
 *     org.eclipse.keypop.reader.ReaderCommunicationException} from Keypop Reader API 2.1+. It will
 *     be removed in a future version.
 */
@Deprecated
public final class ReaderIOException extends RuntimeException {

  /**
   * @param message The message to identify the exception context.
   * @since 0.1.0
   */
  public ReaderIOException(String message) {
    super(message);
  }

  /**
   * Encapsulates a lower level exception.
   *
   * @param message Message to identify the exception context.
   * @param cause The cause.
   * @since 0.1.0
   */
  public ReaderIOException(String message, Throwable cause) {
    super(message, cause);
  }
}
