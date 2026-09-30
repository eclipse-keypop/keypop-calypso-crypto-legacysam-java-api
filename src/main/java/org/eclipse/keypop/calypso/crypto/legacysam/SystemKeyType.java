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
package org.eclipse.keypop.calypso.crypto.legacysam;

/**
 * Enumeration of the system key types of a Legacy Sam.
 *
 * <p>Each type corresponds to a specific use.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#type_SystemKeyType">SystemKeyType</a>
 * for the normative contract.
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
