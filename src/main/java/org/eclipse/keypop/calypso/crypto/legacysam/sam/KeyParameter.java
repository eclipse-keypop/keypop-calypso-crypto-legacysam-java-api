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
package org.eclipse.keypop.calypso.crypto.legacysam.sam;

/**
 * POJO containing the parameters for a key managed by SAM, whether it's a system key or a work key.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#type_KeyParameter">KeyParameter</a>
 * for the normative contract.
 *
 * @since 0.2.0
 */
public interface KeyParameter {

  /**
   * Retrieves the raw data of the key's parameters.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_KeyParameter_getRawData">KeyParameter.getRawData</a>
   * for the normative contract.
   *
   * @return a byte array of 13 bytes representing the key's parameters, including KIF, KVC,
   *     algorithm, and PAR1 to PAR10.
   * @since 0.2.0
   */
  byte[] getRawData();

  /**
   * Returns the key identifier (KIF).
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_KeyParameter_getKif">KeyParameter.getKif</a>
   * for the normative contract.
   *
   * @return The KIF value.
   * @since 0.2.0
   */
  byte getKif();

  /**
   * Returns the key version (KVC).
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_KeyParameter_getKvc">KeyParameter.getKvc</a>
   * for the normative contract.
   *
   * @return The KVC value.
   * @since 0.2.0
   */
  byte getKvc();

  /**
   * Returns the key algorithm.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_KeyParameter_getAlgorithm">KeyParameter.getAlgorithm</a>
   * for the normative contract.
   *
   * @return The algorithm identification byte.
   * @since 0.2.0
   */
  byte getAlgorithm();

  /**
   * Returns the value of the parameter whose number is provided.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_KeyParameter_getParameterValue">KeyParameter.getParameterValue</a>
   * for the normative contract.
   *
   * @param parameterNumber The number of the parameter to get (in range [1..10]).
   * @return The parameter value.
   * @throws IllegalArgumentException If the argument is out of range.
   * @since 0.2.0
   */
  byte getParameterValue(int parameterNumber);
}
