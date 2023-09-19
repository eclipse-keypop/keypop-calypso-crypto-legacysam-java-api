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
