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
package org.eclipse.keypop.calypso.crypto.legacysam.sam;

import java.util.SortedMap;
import org.eclipse.keypop.calypso.crypto.legacysam.CounterIncrementAccess;
import org.eclipse.keypop.calypso.crypto.legacysam.GetDataTag;
import org.eclipse.keypop.calypso.crypto.legacysam.SystemKeyType;
import org.eclipse.keypop.calypso.crypto.legacysam.transaction.FreeTransactionManager;
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
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#type_LegacySam">LegacySam</a>
 * for the normative contract.
 *
 * @since 0.1.0
 */
public interface LegacySam extends SmartCard {

  /**
   * Returns the SAM product type.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getProductType">LegacySam.getProductType</a>
   * for the normative contract.
   *
   * @return The identified product type.
   * @since 0.1.0
   */
  ProductType getProductType();

  /**
   * Returns a text description of the SAM.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getProductInfo">LegacySam.getProductInfo</a>
   * for the normative contract.
   *
   * @return A non-null string.
   * @since 0.1.0
   */
  String getProductInfo();

  /**
   * Returns the SAM serial number as a byte array.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getSerialNumber">LegacySam.getSerialNumber</a>
   * for the normative contract.
   *
   * @return A non-null byte array.
   * @since 0.1.0
   */
  byte[] getSerialNumber();

  /**
   * Returns the platform identifier.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getPlatform">LegacySam.getPlatform</a>
   * for the normative contract.
   *
   * @return A byte.
   * @since 0.1.0
   */
  byte getPlatform();

  /**
   * Returns the application type.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getApplicationType">LegacySam.getApplicationType</a>
   * for the normative contract.
   *
   * @return A byte.
   * @since 0.1.0
   */
  byte getApplicationType();

  /**
   * Returns the application subtype.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getApplicationSubType">LegacySam.getApplicationSubType</a>
   * for the normative contract.
   *
   * @return A byte.
   * @since 0.1.0
   */
  byte getApplicationSubType();

  /**
   * Returns the software issuer identifier.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getSoftwareIssuer">LegacySam.getSoftwareIssuer</a>
   * for the normative contract.
   *
   * @return A byte.
   * @since 0.1.0
   */
  byte getSoftwareIssuer();

  /**
   * Returns the software version number.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getSoftwareVersion">LegacySam.getSoftwareVersion</a>
   * for the normative contract.
   *
   * @return A byte.
   * @since 0.1.0
   */
  byte getSoftwareVersion();

  /**
   * Returns the software revision number.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getSoftwareRevision">LegacySam.getSoftwareRevision</a>
   * for the normative contract.
   *
   * @return A byte.
   * @since 0.1.0
   */
  byte getSoftwareRevision();

  /**
   * Returns the value of a counter.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getCounter">LegacySam.getCounter</a>
   * for the normative contract.
   *
   * @param counterNumber The number of the counter (in range [0..26]).
   * @return Null if the counter value is not set.
   * @see LegacySamSelectionExtension#prepareReadCounterStatus(int)
   * @see FreeTransactionManager#prepareReadCounterStatus(int)
   * @since 0.1.0
   */
  Integer getCounter(int counterNumber);

  /**
   * Returns the value of known counters in a sorted map where {@code key} is the counter number and
   * {@code value} is the counter value.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getCounters">LegacySam.getCounters</a>
   * for the normative contract.
   *
   * @return A non-null map.
   * @see LegacySamSelectionExtension#prepareReadAllCountersStatus()
   * @see FreeTransactionManager#prepareReadAllCountersStatus()
   * @since 0.1.0
   */
  SortedMap<Integer, Integer> getCounters();

  /**
   * Returns the counter increment access mode.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getCounterIncrementAccess">LegacySam.getCounterIncrementAccess</a>
   * for the normative contract.
   *
   * @param counterNumber The number of the counter being checked.
   * @return Null if the counter increment access is unknown.
   * @see LegacySamSelectionExtension#prepareReadCounterStatus(int)
   * @see FreeTransactionManager#prepareReadCounterStatus(int)
   * @since 0.2.0
   */
  CounterIncrementAccess getCounterIncrementAccess(int counterNumber);

  /**
   * Returns the value of a counter ceiling.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getCounterCeiling">LegacySam.getCounterCeiling</a>
   * for the normative contract.
   *
   * @param counterNumber The number of the counter ceiling (in range [0..26]).
   * @return Null if the counter ceiling value is not set.
   * @see LegacySamSelectionExtension#prepareReadCounterStatus(int)
   * @see FreeTransactionManager#prepareReadCounterStatus(int)
   * @since 0.1.0
   */
  Integer getCounterCeiling(int counterNumber);

  /**
   * Returns the value of known counter ceilings in a sorted map where {@code key} is the ceiling
   * number and {@code value} is the ceiling value.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getCounterCeilings">LegacySam.getCounterCeilings</a>
   * for the normative contract.
   *
   * @return A non-null map.
   * @see LegacySamSelectionExtension#prepareReadAllCountersStatus()
   * @see FreeTransactionManager#prepareReadAllCountersStatus()
   * @since 0.1.0
   */
  SortedMap<Integer, Integer> getCounterCeilings();

  /**
   * Returns the CA certificate retrieved from the SAM as a 384-byte byte array.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getCaCertificate">LegacySam.getCaCertificate</a>
   * for the normative contract.
   *
   * @return null if the CA certificate is not available.
   * @see LegacySamSelectionExtension#prepareGetData(GetDataTag)
   * @see FreeTransactionManager#prepareGetData(GetDataTag)
   * @since 0.5.0
   */
  byte[] getCaCertificate();

  /**
   * Returns the SAM parameters retrieved from the SAM.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getSamParameters">LegacySam.getSamParameters</a>
   * for the normative contract.
   *
   * @return null if the SAM parameters are not available.
   * @see LegacySamSelectionExtension#prepareReadSamParameters()
   * @see FreeTransactionManager#prepareReadSamParameters()
   * @since 0.7.0
   */
  SamParameters getSamParameters();

  /**
   * Returns the parameters of the system key for the specified key type.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getSystemKeyParameter">LegacySam.getSystemKeyParameter</a>
   * for the normative contract.
   *
   * @param systemKeyType The type of system key.
   * @return Null if there is no parameter available for the specified key type.
   * @throws IllegalArgumentException If the provided argument is null.
   * @see LegacySamSelectionExtension#prepareReadSystemKeyParameters(SystemKeyType)
   * @see FreeTransactionManager#prepareReadSystemKeyParameters(SystemKeyType)
   * @since 0.2.0
   */
  KeyParameter getSystemKeyParameter(SystemKeyType systemKeyType);

  /**
   * Returns the parameters of the work key referenced by its record number.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getWorkKeyParameter_byRecord">LegacySam.getWorkKeyParameter</a>
   * for the normative contract.
   *
   * @param recordNumber The key record number (in range [1..126]).
   * @return Null if there is no parameter available for the specified key record number.
   * @throws IllegalArgumentException If the provided record number is out of range.
   * @see LegacySamSelectionExtension#prepareReadWorkKeyParameters(int)
   * @see FreeTransactionManager#prepareReadWorkKeyParameters(int)
   * @since 0.7.0
   */
  KeyParameter getWorkKeyParameter(int recordNumber);

  /**
   * Returns the parameters of the work key referenced by its KIF and KVC.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#op_LegacySam_getWorkKeyParameter_byKifKvc">LegacySam.getWorkKeyParameter</a>
   * for the normative contract.
   *
   * @param kif The key KIF.
   * @param kvc The key KVC.
   * @return Null if there is no parameter available for the specified KIF/KVC.
   * @see LegacySamSelectionExtension#prepareReadWorkKeyParameters(byte, byte)
   * @see FreeTransactionManager#prepareReadWorkKeyParameters(byte, byte)
   * @since 0.7.0
   */
  KeyParameter getWorkKeyParameter(byte kif, byte kvc);

  /**
   * All Calypso SAM products supported by this API.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-legacysam-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoLegacySAM_v2.0.0-SNAPSHOT.html#type_ProductType">LegacySam.ProductType</a>
   * for the normative contract.
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
