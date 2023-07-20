/*
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 */
package org.eclipse.keypop.calypso.crypto.legacysam;

import org.eclipse.keypop.calypso.crypto.legacysam.sam.LegacySam;
import org.eclipse.keypop.calypso.crypto.legacysam.sam.LegacySamSelectionExtension;
import org.eclipse.keypop.calypso.crypto.legacysam.transaction.AsyncTransactionCreatorManager;
import org.eclipse.keypop.calypso.crypto.legacysam.transaction.AsyncTransactionExecutorManager;
import org.eclipse.keypop.calypso.crypto.legacysam.transaction.BasicSignatureComputationData;
import org.eclipse.keypop.calypso.crypto.legacysam.transaction.BasicSignatureVerificationData;
import org.eclipse.keypop.calypso.crypto.legacysam.transaction.FreeTransactionManager;
import org.eclipse.keypop.calypso.crypto.legacysam.transaction.SecuritySetting;
import org.eclipse.keypop.calypso.crypto.legacysam.transaction.TraceableSignatureComputationData;
import org.eclipse.keypop.calypso.crypto.legacysam.transaction.TraceableSignatureVerificationData;
import org.eclipse.keypop.reader.CardReader;

/**
 * Legacy SAM API Factory.
 *
 * @since 1.0.0
 */
public interface LegacySamApiFactory {

  /**
   * Returns a new instance of {@link LegacySamSelectionExtension}.
   *
   * @return A new instance of {@link LegacySamSelectionExtension}.
   * @since 1.0.0
   */
  LegacySamSelectionExtension createLegacySamSelectionExtension();

  /**
   * Returns a new instance of {@link SecuritySetting}.
   *
   * @return A new instance of {@link SecuritySetting}.
   * @since 1.0.0
   */
  SecuritySetting createSecuritySetting();

  /**
   * Returns a new instance of {@link FreeTransactionManager}.
   *
   * @param samReader The reader to use to communicate with the SAM.
   * @param sam The SAM image.
   * @return A new instance of {@link FreeTransactionManager}.
   * @throws IllegalArgumentException If an argument is null.
   * @since 1.0.0
   */
  FreeTransactionManager createFreeTransactionManager(CardReader samReader, LegacySam sam);

  /**
   * Returns a new instance of {@link AsyncTransactionCreatorManager}.
   *
   * <p>The target SAM context can be retrieved with the method {@link
   * FreeTransactionManager#exportTargetSamContextForAsyncTransaction()}.
   *
   * @param targetSamContext The target SAM context.
   * @param securitySetting The security settings.
   * @return A new instance of {@link AsyncTransactionCreatorManager}.
   * @throws IllegalArgumentException If an argument is null.
   * @since 1.0.0
   */
  AsyncTransactionCreatorManager createAsyncTransactionCreatorManager(
      String targetSamContext, SecuritySetting securitySetting);

  /**
   * Returns a new instance of {@link AsyncTransactionExecutorManager}.
   *
   * <p>The commands must be prepared using a {@link AsyncTransactionCreatorManager}.
   *
   * @param samReader The reader to use to communicate with the SAM.
   * @param sam The SAM image.
   * @param samCommands A string containing the prepared commands.
   * @return A new instance of {@link AsyncTransactionExecutorManager}.
   * @throws IllegalArgumentException If an argument is null.
   * @since 1.0.0
   */
  AsyncTransactionExecutorManager createAsyncTransactionExecutorManager(
      CardReader samReader, LegacySam sam, String samCommands);

  /**
   * Returns a new instance of {@link BasicSignatureComputationData}.
   *
   * @return A new instance of {@link BasicSignatureComputationData}.
   * @since 1.0.0
   */
  BasicSignatureComputationData createBasicSignatureComputationData();

  /**
   * Returns a new instance of {@link TraceableSignatureComputationData}.
   *
   * @return A new instance of {@link TraceableSignatureComputationData}.
   * @since 1.0.0
   */
  TraceableSignatureComputationData createTraceableSignatureComputationData();

  /**
   * Returns a new instance of {@link BasicSignatureVerificationData}.
   *
   * @return A new instance of {@link BasicSignatureVerificationData}.
   * @since 1.0.0
   */
  BasicSignatureVerificationData createBasicSignatureVerificationData();

  /**
   * Returns a new instance of {@link TraceableSignatureVerificationData}.
   *
   * @return A new instance of {@link TraceableSignatureVerificationData}.
   * @since 1.0.0
   */
  TraceableSignatureVerificationData createTraceableSignatureVerificationData();
}
