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

import org.eclipse.keypop.calypso.card.transaction.spi.SymmetricCryptoCardTransactionManagerFactory;
import org.eclipse.keypop.calypso.crypto.legacysam.sam.LegacySam;
import org.eclipse.keypop.calypso.crypto.legacysam.sam.LegacySamSelectionExtension;
import org.eclipse.keypop.calypso.crypto.legacysam.transaction.*;
import org.eclipse.keypop.reader.CardReader;

/**
 * Legacy SAM API Factory.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#type_LegacySamApiFactory">LegacySamApiFactory</a>
 * for the normative contract.
 *
 * @since 0.3.0
 */
public interface LegacySamApiFactory {

  /**
   * Returns a new instance of {@link LegacySamSelectionExtension}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySamApiFactory_createLegacySamSelectionExtension">LegacySamApiFactory.createLegacySamSelectionExtension</a>
   * for the normative contract.
   *
   * @return A new instance of {@link LegacySamSelectionExtension}.
   * @since 0.3.0
   */
  LegacySamSelectionExtension createLegacySamSelectionExtension();

  /**
   * Returns a new instance of {@link SymmetricCryptoCardTransactionManagerFactory} to be used to
   * secure a card transaction.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySamApiFactory_createSymmetricCryptoCardTransactionManagerFactory">LegacySamApiFactory.createSymmetricCryptoCardTransactionManagerFactory</a>
   * for the normative contract.
   *
   * @param samReader The reader to use to communicate with the SAM.
   * @param sam The associated control SAM to be used with the card transaction.
   * @return A new instance of {@link SymmetricCryptoCardTransactionManagerFactory} to be used to
   *     secure a card transaction.
   * @throws IllegalArgumentException If an argument is null or invalid.
   * @since 0.3.0
   */
  SymmetricCryptoCardTransactionManagerFactory createSymmetricCryptoCardTransactionManagerFactory(
      CardReader samReader, LegacySam sam);

  /**
   * Returns a new instance of {@link SecuritySetting}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySamApiFactory_createSecuritySetting">LegacySamApiFactory.createSecuritySetting</a>
   * for the normative contract.
   *
   * @return A new instance of {@link SecuritySetting}.
   * @since 0.3.0
   */
  SecuritySetting createSecuritySetting();

  /**
   * Returns a new instance of {@link FreeTransactionManager}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySamApiFactory_createFreeTransactionManager">LegacySamApiFactory.createFreeTransactionManager</a>
   * for the normative contract.
   *
   * @param samReader The reader to use to communicate with the SAM.
   * @param sam The SAM image.
   * @return A new instance of {@link FreeTransactionManager}.
   * @throws IllegalArgumentException If an argument is null or invalid.
   * @since 0.3.0
   */
  FreeTransactionManager createFreeTransactionManager(CardReader samReader, LegacySam sam);

  /**
   * Returns a new instance of {@link SecureWriteTransactionManager}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySamApiFactory_createSecureWriteTransactionManager">LegacySamApiFactory.createSecureWriteTransactionManager</a>
   * for the normative contract.
   *
   * @param samReader The reader to use to communicate with the SAM.
   * @param sam The SAM image.
   * @param securitySetting The security settings.
   * @return A new instance of {@link SecureWriteTransactionManager}.
   * @throws IllegalArgumentException If an argument is null or invalid.
   * @since 0.7.0
   */
  SecureWriteTransactionManager createSecureWriteTransactionManager(
      CardReader samReader, LegacySam sam, SecuritySetting securitySetting);

  /**
   * Returns a new instance of {@link AsyncTransactionCreatorManager}.
   *
   * <p>The target SAM context can be retrieved with the method {@link
   * FreeTransactionManager#exportTargetSamContextForAsyncTransaction()}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySamApiFactory_createAsyncTransactionCreatorManager">LegacySamApiFactory.createAsyncTransactionCreatorManager</a>
   * for the normative contract.
   *
   * @param targetSamContext The target SAM context.
   * @param securitySetting The security settings.
   * @return A new instance of {@link AsyncTransactionCreatorManager}.
   * @throws IllegalArgumentException If an argument is null or invalid.
   * @since 0.3.0
   */
  AsyncTransactionCreatorManager createAsyncTransactionCreatorManager(
      String targetSamContext, SecuritySetting securitySetting);

  /**
   * Returns a new instance of {@link AsyncTransactionExecutorManager}.
   *
   * <p>The commands must be prepared using a {@link AsyncTransactionCreatorManager}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySamApiFactory_createAsyncTransactionExecutorManager">LegacySamApiFactory.createAsyncTransactionExecutorManager</a>
   * for the normative contract.
   *
   * @param samReader The reader to use to communicate with the SAM.
   * @param sam The SAM image.
   * @param samCommands A string containing the prepared commands.
   * @return A new instance of {@link AsyncTransactionExecutorManager}.
   * @throws IllegalArgumentException If an argument is null or invalid.
   * @since 0.3.0
   */
  AsyncTransactionExecutorManager createAsyncTransactionExecutorManager(
      CardReader samReader, LegacySam sam, String samCommands);

  /**
   * Returns a new instance of {@link KeyPairContainer}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySamApiFactory_createKeyPairContainer">LegacySamApiFactory.createKeyPairContainer</a>
   * for the normative contract.
   *
   * @return A new instance of {@link KeyPairContainer}.
   * @since 0.5.0
   */
  KeyPairContainer createKeyPairContainer();

  /**
   * Returns a new instance of {@link LegacyCardCertificateComputationData}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySamApiFactory_createLegacyCardCertificateComputationData">LegacySamApiFactory.createLegacyCardCertificateComputationData</a>
   * for the normative contract.
   *
   * @return A new instance of {@link LegacyCardCertificateComputationData}.
   * @since 0.5.0
   */
  LegacyCardCertificateComputationData createLegacyCardCertificateComputationData();

  /**
   * Returns a new instance of {@link BasicSignatureComputationData}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySamApiFactory_createBasicSignatureComputationData">LegacySamApiFactory.createBasicSignatureComputationData</a>
   * for the normative contract.
   *
   * @return A new instance of {@link BasicSignatureComputationData}.
   * @since 0.3.0
   */
  BasicSignatureComputationData createBasicSignatureComputationData();

  /**
   * Returns a new instance of {@link TraceableSignatureComputationData}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySamApiFactory_createTraceableSignatureComputationData">LegacySamApiFactory.createTraceableSignatureComputationData</a>
   * for the normative contract.
   *
   * @return A new instance of {@link TraceableSignatureComputationData}.
   * @since 0.3.0
   */
  TraceableSignatureComputationData createTraceableSignatureComputationData();

  /**
   * Returns a new instance of {@link BasicSignatureVerificationData}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySamApiFactory_createBasicSignatureVerificationData">LegacySamApiFactory.createBasicSignatureVerificationData</a>
   * for the normative contract.
   *
   * @return A new instance of {@link BasicSignatureVerificationData}.
   * @since 0.3.0
   */
  BasicSignatureVerificationData createBasicSignatureVerificationData();

  /**
   * Returns a new instance of {@link TraceableSignatureVerificationData}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySamApiFactory_createTraceableSignatureVerificationData">LegacySamApiFactory.createTraceableSignatureVerificationData</a>
   * for the normative contract.
   *
   * @return A new instance of {@link TraceableSignatureVerificationData}.
   * @since 0.3.0
   */
  TraceableSignatureVerificationData createTraceableSignatureVerificationData();
}
