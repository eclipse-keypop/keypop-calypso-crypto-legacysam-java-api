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

import org.eclipse.keypop.calypso.crypto.legacysam.SystemKeyType;

/**
 * Transaction manager dedicated to "WRITE" operations secured by a control SAM.
 *
 * <p>The write operations defined here can only be executed synchronously.
 *
 * @since 0.7.0
 */
public interface SecureWriteTransactionManager
    extends WriteTransactionManager<SecureWriteTransactionManager> {

  /**
   * Schedules the execution of a "Write Parameters" command to write the SAM parameters file.
   *
   * @param parameters A 29-byte byte array representing the content of the SAM parameters file.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided argument is null or out of range.
   * @since 0.7.0
   */
  SecureWriteTransactionManager prepareWriteSamParameters(byte[] parameters);

  /**
   * Schedules the execution of a "Write Key" command to realize the transfer of a system key from
   * the control SAM to the target SAM.
   *
   * @param systemKeyType The type of system key.
   * @param systemKeyParameters A 29-byte byte array containing the key parameter data.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is null or out of range.
   * @since 0.7.0
   */
  SecureWriteTransactionManager prepareTransferSystemKey(
      SystemKeyType systemKeyType, byte[] systemKeyParameters);

  /**
   * Schedules the execution of a "Write Key" command to realize the transfer of a work key from the
   * control SAM to the target SAM.
   *
   * @param kif The KIF of the key.
   * @param kvc The KVC of the key.
   * @param workKeyParameters A 29-byte byte array containing the key parameter data.
   * @param recordNumber The number of record where to store the key.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is null or out of range.
   * @since 0.7.0
   */
  SecureWriteTransactionManager prepareTransferWorkKey(
      byte kif, byte kvc, byte[] workKeyParameters, int recordNumber);
}
