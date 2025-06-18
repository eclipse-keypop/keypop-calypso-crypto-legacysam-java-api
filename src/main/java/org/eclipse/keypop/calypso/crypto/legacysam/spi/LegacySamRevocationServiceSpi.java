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
