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
 * @see AsyncTransactionCreatorManager
 * @since 0.2.0
 */
public interface AsyncTransactionExecutorManager
    extends TransactionManager<AsyncTransactionExecutorManager> {}
