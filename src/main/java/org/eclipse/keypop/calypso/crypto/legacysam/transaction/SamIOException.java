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
 * Indicates a communication error with the SAM (e.g. timeout, network error, etc.).
 *
 * @since 0.1.0
 */
public final class SamIOException extends RuntimeException {

  /**
   * @param message The message to identify the exception context.
   * @since 0.1.0
   */
  public SamIOException(String message) {
    super(message);
  }

  /**
   * Encapsulates a lower level exception.
   *
   * @param message Message to identify the exception context.
   * @param cause The cause.
   * @since 0.1.0
   */
  public SamIOException(String message, Throwable cause) {
    super(message, cause);
  }
}
