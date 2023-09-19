/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 ************************************************************************************** */
package org.eclipse.keypop.calypso.crypto.legacysam.transaction;

import org.eclipse.keypop.calypso.card.transaction.spi.CardTransactionCryptoExtension;

/**
 * Extends the {@link CardTransactionCryptoExtension} interface of the "Keypop Calypso Card API" to
 * enrich the card transaction command set with specific crypto commands such as for example
 * computation and signature verification operations.
 *
 * <p>An instance of this interface can be obtained via the methods {@link
 * org.eclipse.keypop.calypso.card.transaction.SecureRegularModeTransactionManager#getCryptoExtension(Class)}
 * or {@link
 * org.eclipse.keypop.calypso.card.transaction.SecureExtendedModeTransactionManager#getCryptoExtension(Class)}.
 *
 * @since 0.3.0
 */
public interface CardTransactionLegacySamExtension extends CardTransactionCryptoExtension {

  /**
   * Schedules the execution of a "Data Cipher" or "PSO Compute Signature" command.
   *
   * <p>Once the command is processed, the result will be available in the provided input/output
   * {@link BasicSignatureComputationData} or {@link TraceableSignatureComputationData} objects.
   *
   * <p>The signature may be used for many purposes, for example:
   *
   * <ul>
   *   <li>To add a signature to data recorded in a contactless card or ticket.<br>
   *       <u>Remark</u>: to speed up processing, it is recommended to use a constant signing key
   *       (which is not diversified before ciphering). Instead, the serial number of the card or
   *       ticket should be inserted at the beginning of the data to sign.
   *   <li>To sign some data reported from a terminal to a central system.<br>
   *       <u>Remark</u>: in this case, the terminal SAM contains a signing work key diversified
   *       with its own serial number, guarantying that the data has indeed been signed by this SAM.
   *       The central system SAM uses the master signing key, diversified before signing with the
   *       diversifier set previously by "Select Diversifier" command.
   * </ul>
   *
   * @param data The input/output data containing the parameters of the command.
   * @return The current instance.
   * @throws IllegalArgumentException If the input data is inconsistent.
   * @see SignatureComputationData
   * @see BasicSignatureComputationData
   * @see TraceableSignatureComputationData
   * @since 0.3.0
   */
  CardTransactionLegacySamExtension prepareComputeSignature(SignatureComputationData<?> data);

  /**
   * Schedules the execution of a "Data Cipher" or "PSO Verify Signature" command.
   *
   * <p>Once the command is processed, the result will be available in the provided input/output
   * {@link BasicSignatureVerificationData} or {@link TraceableSignatureVerificationData} objects.
   *
   * @param data The input/output data containing the parameters of the command.
   * @return The current instance.
   * @throws IllegalArgumentException If the input data is inconsistent.
   * @throws SamRevokedException If the signature has been computed in "SAM traceability" mode and
   *     the SAM revocation status check has been requested and the SAM is revoked (for traceable
   *     signature only).
   * @see SignatureVerificationData
   * @see BasicSignatureVerificationData
   * @see TraceableSignatureVerificationData
   * @since 0.3.0
   */
  CardTransactionLegacySamExtension prepareVerifySignature(SignatureVerificationData<?> data);
}
