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

/**
 * Transaction manager dedicated to operations performed asynchronously. This manager prepares
 * commands using a control SAM, and the result is available as a string to be imported and
 * processed by a {@link AsyncTransactionExecutorManager}.
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * org.eclipse.keypop.calypso.crypto.legacysam.LegacySamApiFactory#createAsyncTransactionCreatorManager(String,
 * SecuritySetting)}.
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
   * @return A not empty string.
   * @since 0.2.0
   */
  String exportCommands();
}
