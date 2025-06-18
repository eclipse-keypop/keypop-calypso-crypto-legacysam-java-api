/* **************************************************************************************
 * Copyright (c) 2024 Calypso Networks Association https://calypsonet.org/
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
 * Service to be implemented in order to compute the dynamic unlock data expected by the SAM.
 *
 * @since 0.4.0
 */
public interface LegacySamDynamicUnlockDataProviderSpi {

  /**
   * Returns the dynamic unlock data computed by an origin SAM.
   *
   * <p>Note: the serial number and the challenge are required in the preparation of the SAM
   * Generate Unlock command.
   *
   * @param samSerialNumber The target SAM serial number.
   * @param samChallenge The challenge provided by the target SAM.
   * @return An 8-byte byte array.
   * @since 0.4.0
   */
  byte[] getUnlockData(byte[] samSerialNumber, byte[] samChallenge);
}
