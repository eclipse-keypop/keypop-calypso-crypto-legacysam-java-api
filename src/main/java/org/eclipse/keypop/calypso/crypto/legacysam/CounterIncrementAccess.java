/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.crypto.legacysam;

/**
 * Enumeration of the different possible access rights for incrementing event counters.
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
