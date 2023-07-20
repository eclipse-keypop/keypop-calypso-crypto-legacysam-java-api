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
package org.eclipse.keypop.calypso.crypto.legacysam.sam;

import java.util.SortedMap;
import org.eclipse.keypop.calypso.crypto.legacysam.CounterIncrementAccess;
import org.eclipse.keypop.calypso.crypto.legacysam.SystemKeyType;
import org.eclipse.keypop.reader.selection.spi.SmartCard;

/**
 * Extends the {@link SmartCard} interface of the "Keypop Reader API" to provide additional
 * functionality specific to Calypso legacy SAMs.
 *
 * <p>An instance of {@code LegacySam} is obtained by casting the {@link SmartCard} object from the
 * selection process defined by the "Keypop Reader API".
 *
 * <p>It is a dynamic view of the SAM's content, regularly updated from the selection stage to the
 * end of the transaction.
 *
 * @since 0.1.0
 */
public interface LegacySam extends SmartCard {

  /**
   * Returns the SAM product type.
   *
   * @return The identified product type.
   * @since 0.1.0
   */
  ProductType getProductType();

  /**
   * Returns a text description of the SAM.
   *
   * @return A non-null string.
   * @since 0.1.0
   */
  String getProductInfo();

  /**
   * Returns the SAM serial number as a byte array.
   *
   * @return A non-null byte array.
   * @since 0.1.0
   */
  byte[] getSerialNumber();

  /**
   * Returns the platform identifier.
   *
   * @return A byte.
   * @since 0.1.0
   */
  byte getPlatform();

  /**
   * Returns the application type.
   *
   * @return A byte.
   * @since 0.1.0
   */
  byte getApplicationType();

  /**
   * Returns the application subtype.
   *
   * @return A byte.
   * @since 0.1.0
   */
  byte getApplicationSubType();

  /**
   * Returns the software issuer identifier.
   *
   * @return A byte.
   * @since 0.1.0
   */
  byte getSoftwareIssuer();

  /**
   * Returns the software version number.
   *
   * @return A byte.
   * @since 0.1.0
   */
  byte getSoftwareVersion();

  /**
   * Returns the software revision number.
   *
   * @return A byte.
   * @since 0.1.0
   */
  byte getSoftwareRevision();

  /**
   * Returns the value of a counter.
   *
   * @param counterNumber The number of the counter (in range [0..26]).
   * @return Null if the counter value is not set.
   * @since 0.1.0
   */
  Integer getCounter(int counterNumber);

  /**
   * Returns the value of known counters in a sorted map where {@code key} is the counter number and
   * {@code value} is the counter value.
   *
   * @return A non-null map.
   * @since 0.1.0
   */
  SortedMap<Integer, Integer> getCounters();

  /**
   * Returns the counter increment access mode.
   *
   * @param counterNumber The number of the counter being checked.
   * @return Null if the counter increment access is unknown.
   * @since 0.2.0
   */
  CounterIncrementAccess getCounterIncrementAccess(int counterNumber);

  /**
   * Returns the value of a counter ceiling.
   *
   * @param counterNumber The number of the counter ceiling (in range [0..26]).
   * @return Null if the counter ceiling value is not set.
   * @since 0.1.0
   */
  Integer getCounterCeiling(int counterNumber);

  /**
   * Returns the value of known counter ceilings in a sorted map where {@code key} is the ceiling
   * number and {@code value} is the ceiling value.
   *
   * @return A non-null map.
   * @since 0.1.0
   */
  SortedMap<Integer, Integer> getCounterCeilings();

  /**
   * Returns the parameters of the system key whose type is provided.
   *
   * @param systemKeyType The type of system key.
   * @return Null if there is no parameter available for the specified key type.
   * @since 0.2.0
   */
  KeyParameter getSystemKeyParameter(SystemKeyType systemKeyType);

  /**
   * All Calypso SAM products supported by this API.
   *
   * @since 0.1.0
   */
  enum ProductType {

    /**
     * SAM C1
     *
     * @since 0.1.0
     */
    SAM_C1,

    /**
     * SAM C1 HSM
     *
     * @since 0.1.0
     */
    HSM_C1,

    /**
     * SAM S1E1
     *
     * @since 0.1.0
     */
    SAM_S1E1,

    /**
     * SAM S1Dx
     *
     * @since 0.1.0
     */
    SAM_S1DX,

    /**
     * Unidentified smart card.
     *
     * @since 0.1.0
     */
    UNKNOWN
  }
}
