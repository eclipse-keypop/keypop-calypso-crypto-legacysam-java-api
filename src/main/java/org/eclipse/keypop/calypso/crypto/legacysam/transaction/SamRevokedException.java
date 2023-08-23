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
 * Indicates that the SAM is revoked.
 *
 * @since 0.1.0
 */
public final class SamRevokedException extends RuntimeException {

  /**
   * @param message The message to identify the exception context.
   * @since 0.1.0
   */
  public SamRevokedException(String message) {
    super(message);
  }
}
