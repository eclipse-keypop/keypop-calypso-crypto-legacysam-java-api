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

import org.eclipse.keypop.reader.transaction.spi.CardTransactionManager;

/**
 * Common base of every legacy SAM transaction manager, providing command processing for the SAM.
 *
 * <p>Processing of prepared commands is inherited from {@link
 * CardTransactionManager#processCommands()} and is not redefined here.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#type_TransactionManager">TransactionManager</a>
 * for the normative contract.
 *
 * @since 0.1.0
 */
public interface TransactionManager extends CardTransactionManager {}
