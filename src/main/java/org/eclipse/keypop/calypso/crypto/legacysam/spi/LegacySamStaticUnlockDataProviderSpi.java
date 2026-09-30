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
 * Service to be implemented in order to compute the static unlock data expected by the SAM.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#type_LegacySamStaticUnlockDataProviderSpi">LegacySamStaticUnlockDataProviderSpi</a>
 * for the normative contract.
 *
 * @since 0.4.0
 */
public interface LegacySamStaticUnlockDataProviderSpi {

  /**
   * Returns the static unlock data expected by the target SAM.
   *
   * <p>Note: the serial number can be used as diversifier in the computation of the unlock data.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySamStaticUnlockDataProviderSpi_getUnlockData">LegacySamStaticUnlockDataProviderSpi.getUnlockData</a>
   * for the normative contract.
   *
   * @param samSerialNumber The target SAM serial number.
   * @return A 16-byte byte array.
   * @since 0.4.0
   */
  byte[] getUnlockData(byte[] samSerialNumber);
}
