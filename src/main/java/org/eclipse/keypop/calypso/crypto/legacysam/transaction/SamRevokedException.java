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
package org.eclipse.keypop.calypso.crypto.legacysam.transaction;

/**
 * Indicates that the SAM is revoked.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#type_SamRevokedException">SamRevokedException</a>
 * for the normative contract.
 *
 * @since 0.1.0
 */
public final class SamRevokedException extends RuntimeException {

  /**
   * @param message The message to identify the exception context.
   * @since 0.1.0
   */
  public SamRevokedException(String message) {
    super(message);
  }
}
