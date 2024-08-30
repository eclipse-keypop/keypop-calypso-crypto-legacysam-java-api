/* ******************************************************************************
 * Copyright (c) 2024 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.crypto.legacysam.sam;

/**
 * POJO containing the parameters of the SAM.
 *
 * @since 0.7.0
 */
public interface SamParameters {

  /**
   * Retrieves the raw data of the SAM's parameters.
   *
   * @return a byte array of 29 bytes representing the SAM's parameters.
   * @since 0.7.0
   */
  byte[] getRawData();
}
