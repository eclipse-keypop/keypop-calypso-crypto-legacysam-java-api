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
package org.eclipse.keypop.calypso.crypto.legacysam.transaction;

/**
 * Contains the input/output data of the {@link
 * FreeTransactionManager#prepareGenerateCardAsymmetricKeyPair(KeyPairContainer)} method.
 *
 * <p>A key pair consists of a byte array containing the public key and a private key values.
 *
 * @since 0.5.0
 */
public interface KeyPairContainer {

  /**
   * Returns the key pair.
   *
   * @return The key pair as a 96-byte byte array.
   * @since 0.5.0
   */
  byte[] getKeyPair();
}
