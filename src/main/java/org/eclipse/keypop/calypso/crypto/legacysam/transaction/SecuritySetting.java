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

import org.eclipse.keypop.calypso.crypto.legacysam.LegacySamApiFactory;
import org.eclipse.keypop.calypso.crypto.legacysam.sam.LegacySam;
import org.eclipse.keypop.reader.CardReader;

/**
 * Security setting to manage operations of a legacy SAM transaction secured by a control SAM.
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * LegacySamApiFactory#createSecuritySetting()}.
 *
 * @since 0.2.0
 */
public interface SecuritySetting {

  /**
   * Sets the control SAM and the reader through which it can be accessed. It will be used to
   * perform all necessary cryptographic operations.
   *
   * @param samReader The reader to use to communicate with the SAM.
   * @param controlSam The control Legacy SAM.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the arguments is null or if the product type of
   *     {@link LegacySam} is equal to {@link LegacySam.ProductType#UNKNOWN}.
   * @since 0.2.0
   */
  SecuritySetting setControlSamResource(CardReader samReader, LegacySam controlSam);
}
