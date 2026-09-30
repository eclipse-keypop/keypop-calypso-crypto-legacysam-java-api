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
 * Contains the input/output data of the {@link
 * FreeTransactionManager#prepareVerifySignature(SignatureVerificationData)} method for common
 * signature verification modes.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#type_SignatureVerificationData">SignatureVerificationData</a>
 * for the normative contract.
 *
 * @param <T> The type of the lowest level child object.
 * @since 0.1.0
 */
public interface SignatureVerificationData<T extends SignatureVerificationData<T>> {

  /**
   * Sets the signed data, the associated signature and the KIF/KVC of the key to be used for the
   * signature verification.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_SignatureVerificationData_setData">SignatureVerificationData.setData</a>
   * for the normative contract.
   *
   * @param data The signed data.
   * @param signature The associated signature.
   * @param kif The KIF of the key to be used for the signature verification.
   * @param kvc The KVC of the key to be used for the signature verification.
   * @return The current instance.
   * @since 0.1.0
   */
  T setData(byte[] data, byte[] signature, byte kif, byte kvc);

  /**
   * Sets a specific key diversifier to use before verifying the signature (optional).
   *
   * <p>By default, the key diversification is performed with the full serial number of the target
   * card or SAM depending on the transaction context (Card or SAM transaction).
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_SignatureVerificationData_setKeyDiversifier">SignatureVerificationData.setKeyDiversifier</a>
   * for the normative contract.
   *
   * @param diversifier The diversifier to be used (from 1 to 8 bytes long).
   * @return The current instance.
   * @since 0.1.0
   */
  T setKeyDiversifier(byte[] diversifier);

  /**
   * Returns the result of the signature verification process by indicating if the signature is
   * valid or not.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_SignatureVerificationData_isSignatureValid">SignatureVerificationData.isSignatureValid</a>
   * for the normative contract.
   *
   * @return True if the signature is valid.
   * @throws IllegalStateException If the command has not yet been processed.
   * @since 0.1.0
   */
  boolean isSignatureValid();
}
