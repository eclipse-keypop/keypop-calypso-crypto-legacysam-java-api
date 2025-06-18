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
 * The SAM traceability mode to use with traceable signature operations.
 *
 * @since 0.3.0
 */
public enum SamTraceabilityMode {
  /**
   * Full SAM serial number (4 Bytes).
   *
   * @since 0.3.0
   */
  FULL_SERIAL_NUMBER,
  /**
   * Truncated SAM serial number (3 LSBytes)
   *
   * @since 0.3.0
   */
  TRUNCATED_SERIAL_NUMBER
}
