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
 * FreeTransactionManager#prepareComputeSignature(SignatureComputationData)} method for common
 * signature computation modes.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#type_SignatureComputationData">SignatureComputationData</a>
 * for the normative contract.
 *
 * @param <T> The type of the lowest level child object.
 * @since 0.1.0
 */
public interface SignatureComputationData<T extends SignatureComputationData<T>> {

  /**
   * Sets the data to be signed and the KIF/KVC of the key to be used for the signature computation.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_SignatureComputationData_setData">SignatureComputationData.setData</a>
   * for the normative contract.
   *
   * @param data The data to be signed.
   * @param kif The KIF of the key to be used for the signature computation.
   * @param kvc The KVC of the key to be used for the signature computation.
   * @return The current instance.
   * @since 0.1.0
   */
  T setData(byte[] data, byte kif, byte kvc);

  /**
   * Sets the expected size of the signature in bytes, which can be between 1 and 8 bytes
   * (optional).
   *
   * <p>By default, the signature will be generated on 8 bytes.
   *
   * <p>Note: the longer the signature, the more secure it is.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_SignatureComputationData_setSignatureSize">SignatureComputationData.setSignatureSize</a>
   * for the normative contract.
   *
   * @param size The expected size [1..8]
   * @return The current instance.
   * @since 0.1.0
   */
  T setSignatureSize(int size);

  /**
   * Sets a specific key diversifier to use before signing (optional).
   *
   * <p>By default, the key diversification is performed with the full serial number of the target
   * card or SAM depending on the transaction context (Card or SAM transaction).
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_SignatureComputationData_setKeyDiversifier">SignatureComputationData.setKeyDiversifier</a>
   * for the normative contract.
   *
   * @param diversifier The diversifier to be used (from 1 to 8 bytes long).
   * @return The current instance.
   * @since 0.1.0
   */
  T setKeyDiversifier(byte[] diversifier);

  /**
   * Returns the computed signature.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_SignatureComputationData_getSignature">SignatureComputationData.getSignature</a>
   * for the normative contract.
   *
   * @return A byte array of 1 to 8 bytes.
   * @throws IllegalStateException If the command has not yet been processed.
   * @since 0.1.0
   */
  byte[] getSignature();
}
