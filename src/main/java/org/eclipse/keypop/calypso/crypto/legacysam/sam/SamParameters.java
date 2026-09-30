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
package org.eclipse.keypop.calypso.crypto.legacysam.sam;

/**
 * POJO containing the parameters of the SAM.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#type_SamParameters">SamParameters</a>
 * for the normative contract.
 *
 * @since 0.7.0
 */
public interface SamParameters {

  /**
   * Retrieves the raw data of the SAM's parameters.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_SamParameters_getRawData">SamParameters.getRawData</a>
   * for the normative contract.
   *
   * @return a byte array of 29 bytes representing the SAM's parameters.
   * @since 0.7.0
   */
  byte[] getRawData();
}
