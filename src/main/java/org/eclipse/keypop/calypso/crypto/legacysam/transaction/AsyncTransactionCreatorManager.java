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
 * Transaction manager dedicated to operations performed asynchronously. This manager prepares
 * commands using a control SAM, and the result is available as a string to be imported and
 * processed by a {@link AsyncTransactionExecutorManager}.
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * org.eclipse.keypop.calypso.crypto.legacysam.LegacySamApiFactory#createAsyncTransactionCreatorManager(String,
 * SecuritySetting)}.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#type_AsyncTransactionCreatorManager">AsyncTransactionCreatorManager</a>
 * for the normative contract.
 *
 * @see AsyncTransactionExecutorManager
 * @since 0.2.0
 */
public interface AsyncTransactionCreatorManager
    extends WriteTransactionManager<AsyncTransactionCreatorManager> {

  /**
   * Returns a string containing the prepared commands to be executed by a target SAM.
   *
   * <p>These commands can later be imported and processed by a {@link
   * AsyncTransactionExecutorManager}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_AsyncTransactionCreatorManager_exportCommands">AsyncTransactionCreatorManager.exportCommands</a>
   * for the normative contract.
   *
   * @return A not empty string.
   * @since 0.2.0
   */
  String exportCommands();
}
