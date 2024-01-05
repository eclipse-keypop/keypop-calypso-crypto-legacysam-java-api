/* ******************************************************************************
 * Copyright (c) 2024 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.crypto.legacysam.spi;
/**
 * Service to be implemented in order to compute the static unlock data expected by the SAM.
 *
 * @since 0.4.0
 */
public interface LegacySamStaticUnlockDataProviderSpi {

  /**
   * Returns the static unlock data expected by the target SAM.
   *
   * <p>Note: the serial number can be used as diversifier in the computation of the unlock data.
   *
   * @param samSerialNumber The target SAM serial number.
   * @return A 16-byte byte array.
   * @since 0.4.0
   */
  byte[] getUnlockData(byte[] samSerialNumber);
}
