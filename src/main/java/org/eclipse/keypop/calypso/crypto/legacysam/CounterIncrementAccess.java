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
package org.eclipse.keypop.calypso.crypto.legacysam;

/**
 * Enumeration of the different possible access rights for incrementing event counters.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#type_CounterIncrementAccess">CounterIncrementAccess</a>
 * for the normative contract.
 *
 * @since 0.3.0
 */
public enum CounterIncrementAccess {
  /**
   * Enables to increment the value of an event counter using the "Increment Counter" command.
   *
   * @since 0.3.0
   */
  FREE_COUNTING_ENABLED,
  /**
   * Forbids to increment the value of an event counter using the "Increment Counter" command.
   *
   * @since 0.3.0
   */
  FREE_COUNTING_DISABLED
}
