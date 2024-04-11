/* ******************************************************************************
 * Copyright (c) 2024 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.crypto.legacysam.transaction;

import java.time.LocalDate;

/**
 * Contains the input/output data of the {@link
 * FreeTransactionManager#prepareComputeCardCertificate(CardCertificateComputationData)} method.
 *
 * @since 0.5.0
 */
public interface CardCertificateComputationData {

  /**
   * Sets the public key of the card, provided as a 64-byte array.
   *
   * <p>This key is expected to be on the <strong>secp256r1</strong> elliptic curve. It will be used
   * for the verification of card signatures.
   *
   * @param cardPublicKey The 64-byte array representing the public key on the
   *     <strong>secp256r1</strong> curve.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided key is null or out of range.
   * @since 0.5.0
   */
  CardCertificateComputationData setCardPublicKey(byte[] cardPublicKey);

  /**
   * Sets the start date of the validity period of the certificate's public key.
   *
   * <p>The start date is optional. If it is not defined, the certificate is not subject to a start
   * date constraint.
   *
   * @param startDate The start date.
   * @return The current instance.
   * @throws IllegalArgumentException If date is null.
   * @since 0.5.0
   */
  CardCertificateComputationData setStartDate(LocalDate startDate);

  /**
   * Sets the end date of the validity period of the certificate's public key.
   *
   * <p>The end date is optional. If it is not defined, the certificate is not subject to an end
   * date constraint.
   *
   * @param endDate The end date.
   * @return The current instance.
   * @throws IllegalArgumentException If date is null.
   * @since 0.5.0
   */
  CardCertificateComputationData setEndDate(LocalDate endDate);

  /**
   * Sets the AID of the autonomous PKI application of the target card.
   *
   * <p>The <b>aid</b> field cannot contain only zero bytes.
   *
   * @param aid The AID value as a 5 to 16 bytes byte array. Must not contain only zero bytes.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided AID is null, out of range, or contains only
   *     zero bytes.
   * @since 0.5.0
   */
  CardCertificateComputationData setCardAid(byte[] aid);

  /**
   * Sets the serial number of the card for which the certificate is being generated.
   *
   * @param serialNumber The serial number of the card as an 8-byte byte array.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided argument is null or out of range.
   * @since 0.5.0
   */
  CardCertificateComputationData setCardSerialNumber(byte[] serialNumber);

  /**
   * Sets the startup info of the card for which the certificate is being generated.
   *
   * @param startupInfo The 7-byte byte array representing the startup info for the card
   *     certificate.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided argument is null or out of range.
   * @since 0.5.0
   */
  CardCertificateComputationData setCardStartupInfo(byte[] startupInfo);

  /**
   * Returns the certificate generated by the SAM after the execution of the "PSO Compute
   * Certificate" command.
   *
   * @return A 316-byte byte array or null if the computation has not been performed.
   * @since 0.5.0
   */
  byte[] getCertificate();
}
