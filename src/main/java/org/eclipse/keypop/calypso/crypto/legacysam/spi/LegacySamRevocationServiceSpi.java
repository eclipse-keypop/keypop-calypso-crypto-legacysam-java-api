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
package org.eclipse.keypop.calypso.crypto.legacysam.spi;

/**
 * Service to be implemented in order to check dynamically if a SAM is revoked.
 *
 * @since 0.1.0
 */
public interface LegacySamRevocationServiceSpi {

  /**
   * Checks if the SAM with the provided serial number is revoked or not.
   *
   * <p>Note: the provided SAM serial number can be complete (4 bytes) or partial (3 LSBytes).
   *
   * @param serialNumber The complete or partial SAM serial number to check.
   * @return True if the SAM is revoked, otherwise false.
   * @since 0.1.0
   */
  boolean isSamRevoked(byte[] serialNumber);

  /**
   * Checks if the SAM with the provided serial number and the associated counter value is revoked
   * or not.
   *
   * <p>Note: the provided SAM serial number can be complete (4 bytes) or partial (3 LSBytes).
   *
   * @param serialNumber The complete or partial SAM serial number to check.
   * @param counterValue The SAM counter value.
   * @return True if the SAM is revoked, otherwise false.
   * @since 0.1.0
   */
  boolean isSamRevoked(byte[] serialNumber, int counterValue);
}
