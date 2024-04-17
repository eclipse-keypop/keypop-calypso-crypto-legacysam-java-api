/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.crypto.legacysam.transaction;

import org.eclipse.keypop.calypso.crypto.legacysam.GetDataTag;
import org.eclipse.keypop.calypso.crypto.legacysam.LegacySamApiFactory;
import org.eclipse.keypop.calypso.crypto.legacysam.sam.LegacySam;
import org.eclipse.keypop.reader.CardReader;

/**
 * Transaction manager dedicated to operations performed without control SAM.
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * org.eclipse.keypop.calypso.crypto.legacysam.LegacySamApiFactory#createFreeTransactionManager(CardReader,
 * LegacySam)}.
 *
 * @since 0.1.0
 */
public interface FreeTransactionManager extends ReadTransactionManager<FreeTransactionManager> {

  /**
   * Schedules the execution of a "Get Data" command for the specified tag.
   *
   * <p>Once this command is processed, data is accessible using dedicated getter methods, like
   * {@link LegacySam#getCaCertificate()}.
   *
   * @param tag The tag to retrieve the data for.
   * @return The current instance.
   * @throws IllegalArgumentException If tag is null.
   * @since 0.5.0
   */
  FreeTransactionManager prepareGetData(GetDataTag tag);

  /**
   * Schedules the execution of "Card Generate Asymmetric Key Pair" command.
   *
   * <p>Once this command is processed, the key pair data will be available in the provided output
   * {@link KeyPairContainer} objects.
   *
   * @param keyPairContainer The container for the output data.
   * @return The current instance.
   * @throws IllegalArgumentException If keyPairContainer is null.
   * @see KeyPairContainer
   * @see LegacySamApiFactory#createKeyPairContainer()
   * @since 0.5.0
   */
  FreeTransactionManager prepareGenerateCardAsymmetricKeyPair(KeyPairContainer keyPairContainer);

  /**
   * Schedules the execution of a "PSO Compute Certificate" command.
   *
   * <p>Once the command is processed, the result will be available in the provided input/output
   * {@link LegacyCardCertificateComputationData} object.
   *
   * @param data The input/output data containing the parameters of the command.
   * @return The current instance.
   * @throws IllegalArgumentException If data is null.
   * @see LegacyCardCertificateComputationData
   * @see LegacySamApiFactory#createLegacyCardCertificateComputationData()
   * @since 0.5.0
   */
  FreeTransactionManager prepareComputeCardCertificate(LegacyCardCertificateComputationData data);

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
   * @see LegacySamApiFactory#createBasicSignatureComputationData()
   * @since 0.1.0
   */
  FreeTransactionManager prepareComputeSignature(SignatureComputationData<?> data);

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
   * @see LegacySamApiFactory#createBasicSignatureVerificationData()
   * @since 0.1.0
   */
  FreeTransactionManager prepareVerifySignature(SignatureVerificationData<?> data);

  /**
   * Executes the required commands to obtain the security context, which will be used for future
   * asynchronous write operations.
   *
   * <p>The exported target SAM context must be provided when creating an {@link
   * AsyncTransactionCreatorManager} with the method {@link
   * LegacySamApiFactory#createAsyncTransactionCreatorManager(String, SecuritySetting)}.
   *
   * @return A not empty string containing the context.
   * @since 0.2.0
   */
  String exportTargetSamContextForAsyncTransaction();
}
