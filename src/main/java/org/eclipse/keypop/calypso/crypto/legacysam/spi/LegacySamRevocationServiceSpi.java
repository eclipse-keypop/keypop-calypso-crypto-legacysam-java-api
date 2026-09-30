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
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#type_LegacySamRevocationServiceSpi">LegacySamRevocationServiceSpi</a>
 * for the normative contract.
 *
 * @since 0.1.0
 */
public interface LegacySamRevocationServiceSpi {

  /**
   * Checks if the SAM with the provided serial number is revoked or not.
   *
   * <p>Note: the provided SAM serial number can be complete (4 bytes) or partial (3 LSBytes).
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySamRevocationServiceSpi_isSamRevoked">LegacySamRevocationServiceSpi.isSamRevoked</a>
   * for the normative contract.
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
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySamRevocationServiceSpi_isSamRevoked_withCounter">LegacySamRevocationServiceSpi.isSamRevoked</a>
   * for the normative contract.
   *
   * @param serialNumber The complete or partial SAM serial number to check.
   * @param counterValue The SAM counter value.
   * @return True if the SAM is revoked, otherwise false.
   * @since 0.1.0
   */
  boolean isSamRevoked(byte[] serialNumber, int counterValue);
}
