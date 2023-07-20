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
package org.eclipse.keypop.calypso.crypto.legacysam;

/**
 * Enumeration of the system key types of a Legacy Sam.
 *
 * <p>Each type corresponds to a specific use.
 *
 * @since 0.2.0
 */
public enum SystemKeyType {
  /**
   * Personalization key, to decipher and authorize the writing of parameters and system keys.
   *
   * @since 0.2.0
   */
  PERSONALIZATION,
  /**
   * Work file key, to decipher and authorize the writing of work keys.
   *
   * @since 0.2.0
   */
  KEY_MANAGEMENT,
  /**
   * Reloading key, to decipher and authorize the writing of counter ceilings.
   *
   * @since 0.2.0
   */
  RELOADING,
  /**
   * Authentication key, to generate the signature of data read from the SAM.
   *
   * @since 0.2.0
   */
  AUTHENTICATION,
}
