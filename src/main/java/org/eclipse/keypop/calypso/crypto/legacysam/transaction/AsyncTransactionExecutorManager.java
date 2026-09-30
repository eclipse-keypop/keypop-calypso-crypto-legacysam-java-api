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

import org.eclipse.keypop.calypso.crypto.legacysam.sam.LegacySam;
import org.eclipse.keypop.reader.CardReader;

/**
 * Transaction manager dedicated to execute commands prepared asynchronously using {@link
 * AsyncTransactionCreatorManager#exportCommands()}.
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * org.eclipse.keypop.calypso.crypto.legacysam.LegacySamApiFactory#createAsyncTransactionExecutorManager(CardReader,
 * LegacySam, String)}.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#type_AsyncTransactionExecutorManager">AsyncTransactionExecutorManager</a>
 * for the normative contract.
 *
 * @see AsyncTransactionCreatorManager
 * @since 0.2.0
 */
public interface AsyncTransactionExecutorManager extends TransactionManager {}
