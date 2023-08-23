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
package org.eclipse.keypop.calypso.crypto.legacysam;

/**
 * Enumeration of the different possible access rights for incrementing event counters.
 *
 * @since 1.0.0
 */
public enum CounterIncrementAccess {
  /**
   * Enables to increment the value of an event counter using the "Increment Counter" command.
   *
   * @since 1.0.0
   */
  FREE_COUNTING_ENABLED,
  /**
   * Forbids to increment the value of an event counter using the "Increment Counter" command.
   *
   * @since 1.0.0
   */
  FREE_COUNTING_DISABLED
}
