# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
### Fixed
- Fixed JUnit configuration.

## [0.7.0] - 2024-11-29
### Added
- New interface `SamParameters` to contains the SAM parameters.
- New method added to `LegacySam`:
    - `getSamParameters()` to retrieve the parameters read from the SAM.
    - `getWorkKeyParameter(int recordNumber)` to retrieve a read work key from its record number.
    - `getWorkKeyParameter(byte kif, byte kvc)` to retrieve a read work key from its KIF and KVC.
- New method added to `ReadTransactionManager`:
    - `prepareReadSamParameters()` to schedule the execution of "Read Parameters" command.
    - `prepareReadWorkKeyParameters(int recordNumber)` to schedule the execution of "Read Key Parameters" command.
    - `prepareReadWorkKeyParameters(byte kif, byte kvc)` to schedule the execution of "Read Key Parameters" command.
- New method added to `FreeTransactionManager`:
    - `preparePlainWriteLock(byte lockIndex, byte lockParameters, byte[] lockValue)` to schedule the execution of "Write Key" command to write a lock in plain mode.
- New methods added to `LegacySamApiFactory`:
    - `createSecureWriteTransactionManager(CardReader samReader, LegacySam sam, SecuritySetting securitySetting)` to manage secure SAM write transactions.
- New interface added `SecureWriteTransactionManager`:
    - `prepareWriteSamParameters(byte[] parameters)` to schedule the execution of "Write Parameters" command.
    - `prepareTransferSystemKey(SystemKeyType systemKeyType, byte kvc, byte[] systemKeyParameters)` to schedule the execution of "Write Key" command.
    - `prepareTransferSystemKeyDiversified(SystemKeyType systemKeyType, byte kvc, byte[] systemKeyParameters)` to schedule the execution of "Write Key" command (the key is diversified by the SAM serial number).
    - `prepareTransferWorkKey(byte kif, byte kvc, byte[] workKeyParameters, int targetRecordNumber)` to schedule the execution of "Write Key" command.
    - `prepareTransferWorkKeyDiversified(byte kif, byte kvc, byte[] workKeyParameters, int targetRecordNumber)` to schedule the execution of "Write Key" command (the key is diversified by the SAM serial number).
    - `prepareTransferWorkKeyDiversified(byte kif, byte kvc, byte[] workKeyParameters, int targetRecordNumber, byte[] diversifier)` to schedule the execution of "Write Key" command (the key is diversified by the provided diversifier).
    - `prepareTransferLock(byte lockIndex, byte lockParameters)` to schedule the execution of "Write Key" command to write a lock in ciphered mode.
    - `prepareTransferLockDiversified(byte lockIndex, byte lockParameters)` to schedule the execution of "Write Key" command to write a lock in ciphered mode (the lock value is diversified by the SAM serial number).
    - `preparePlainWriteLock(byte lockIndex, byte lockParameters, byte[] lockValue)` to schedule the execution of "Write Key" command to write a lock in plain mode.

## [0.6.0] - 2024-04-17
### Added
- New method added to `LegacySamSelectionExtension`:
  - `prepareGetData(GetDataTag tag)` to schedule the execution of a "Get Data" command for
    the specified tag.
### Changed
- `CardCertificateComputationData` renamed to `LegacyCardCertificateComputationData`

## [0.5.0] - 2024-04-12
### Changed
- Java source and target levels `1.6` -> `1.8`
### Upgraded
- Gradle `6.8.3` -> `7.6.4`
### Added
- `GetDataTag` to enumerate all output data types.
- `KeyPairContainer` interface to contain a key pair.
- `CardCertificateComputationData` interface to contain input/output data for the "PSO Compute Certificate" command.
- New methods added to `FreeTransactionManager`:
  - `prepareGetData(GetDataTag tag)` to schedule the execution of a "Get Data" command for
    the specified tag.
  - `prepareGenerateCardAsymmetricKeyPair(KeyPairContainer keyPairContainer)` to schedule the execution of "Card
    Generate Asymmetric Key Pair" command.
  - `prepareComputeCardCertificate(CardCertificateComputationData data)` to schedule the execution of a "PSO Compute
    Certificate" command.
- New methods added to `LegacySamApiFactory`:
  - `createKeyPairContainer()` to create a new instance of `KeyPairContainer`.
  - `createCardCertificateComputationData()` to create a new instance of `CardCertificateComputationData`.
- New method added to `LegacySam`:
  - `getCaCertificate()` to get the CA certificate retrieved from the SAM as a 384-byte byte array.

## [0.4.0] - 2024-01-10
### Added
- `LegacySamStaticUnlockDataProviderSpi`, an SPI to provide SAM unlock data in static mode.
- `LegacySamDynamicUnlockDataProviderSpi`, an SPI to provide SAM unlock data in dynamic mode.
- New methods added to `LegacySamSelectionExtension`:
  - `setStaticUnlockDataProvider(LegacySamStaticUnlockDataProviderSpi unlockDataProvider)` sets the unlock data provider
  for the static mode when the card reader becomes available at a later stage.
  - `setStaticUnlockDataProvider(LegacySamStaticUnlockDataProviderSpi unlockDataProvider, CardReader targetSamReader)` 
  sets the unlock data provider and the target SAM reader for the static mode when the target SAM reader is initially 
  available.
  - `setDynamicUnlockDataProvider(LegacySamDynamicUnlockDataProviderSpi unlockDataProvider)` sets the unlock data 
  provider for the dynamic mode when the card reader becomes available at a later stage.
  - `setDynamicUnlockDataProvider(LegacySamDynamicUnlockDataProviderSpi unlockDataProvider, CardReader targetSamReader)` 
  sets the unlock data provider and the target SAM reader for the dynamic mode when the target SAM reader is initially 
  available.
### Fixed
- The allowed length for unlocking data in static mode is 16 bytes only as expected by the SAM (`setUnlockData` method).

## [0.3.0] - 2023-11-27
:warning: The project has been migrated from the [Calypsonet Terminal Calypso Crypto Legacy SAM API](https://github.com/calypsonet/calypsonet-terminal-calypso-crypto-legacysam-java-api)
GitHub repository.
### Added
- `LegacySamApiFactory` centralizes the methods used to create instances of the various interfaces of
  the API.
- `CardTransactionLegacySamExtension` extends the SPI `CardTransactionCryptoExtension` provided by
  "Keypop Calypso Card API" to extends a card transaction with specific SAM features (e.g. signature computation, etc.).
- New methods added to `LegacySamSelectionExtension`:
  - `setUnlockData(String unlockData, LegacySam.ProductType productType)` sets the unlock data to be used to unlock a 
    SAM C1 (8 or 16 bytes) and schedules the execution of the "Unlock data" command in the first position.
  - `prepareReadSystemKeyParameters(SystemKeyType systemKeyType)` schedules the execution of a "Read Key Parameters" 
    command for a system key.
  - `prepareReadCounterStatus(int counterNumber)` schedules the execution of a "Read Event Counter" and "Read Ceiling" 
    commands to read the status of a counter.
  - `prepareReadAllCountersStatus()` schedules the execution of a "Read Event Counter" and "Read Ceiling" commands to 
    read the status of all counters.
- New method added to `LegacySam`:
  - `getCounterIncrementAccess(int counterNumber)` returns the counter increment access mode.
### Changed
- The project license is now "MIT License" (previously "Eclipse Public License 2.0").
- CI: The Gradle plugin `org.eclipse.keyple:keyple-gradle:0.2.+` has been replaced
  by `org.eclipse.keypop:keypop-gradle:0.1.+`.
- Renamed:
  - Artifact `org.calypsonet.terminal:calypsonet-terminal-calypso-crypto-legacysam-java-api` -> `org.eclipse.keypop:keypop-calypso-crypto-legacysam-java-api`
  - Package `org.eclipse.keypop.calypso.card.crypto.legacysam` -> `org.eclipse.keypop.calypso.crypto.legacysam`
  - Interface `LegacySamSelection` -> `LegacySamSelectionExtension`
  - Interface `LSSecuritySetting` -> `SecuritySetting`
  - Interface `LSFreeTransactionManager` -> `FreeTransactionManager`
  - Interface `LSAsyncTransactionCreatorManager` -> `AsyncTransactionCreatorManager`
  - Interface `LSAsyncTransactionExecutorManager` -> `AsyncTransactionExecutorManager`
  - Interface `LSRevocationServiceSpi` -> `LegacySamRevocationServiceSpi`
- All legacy factories were merged into a single factory `LegacySamApiFactory`:
  - `LegacySamSelectionFactory`
  - `LSTransactionManagerFactory`
  - `LSSecuritySettingFactory`
  - `LSCardTransactionCryptoExtensionFactory`
  - `LSCommandDataFactory`
- Method signature refactored:
  - `LSWriteTransactionManager.prepareWriteCounterConfiguration(int counterNumber, int ceilingValue, boolean isManualCounterIncrementAuthorized)`
    -> `WriteTransactionManager.prepareWriteCounterConfiguration(int counterNumber, int ceilingValue, CounterIncrementAccess counterIncrementAccess)`.
    The enum `CounterIncrementAccess` has been created for this purpose.
  - `TraceableSignatureComputationData.withSamTraceabilityMode(int offset, boolean usePartialSamSerialNumber)` 
    -> `TraceableSignatureComputationData.withSamTraceabilityMode(int offset, SamTraceabilityMode samTraceabilityMode)`.
    The enum `SamTraceabilityMode` has been created for this purpose.
  - `TraceableSignatureVerificationData.withSamTraceabilityMode(int offset, boolean isPartialSamSerialNumber, LSRevocationServiceSpi samRevocationService)`
    -> `TraceableSignatureComputationData.withSamTraceabilityMode(int offset, SamTraceabilityMode samTraceabilityMode, LegacySamRevocationServiceSpi samRevocationService)`.
    The enum `SamTraceabilityMode` has been created for this purpose.
### Removed
- The `filterByProductType(LegacySam.ProductType productType)` and `filterBySerialNumber(String serialNumberRegex)` 
  methods of `LegacySamSelection` have been removed following the introduction of generic selection filters in the 
  "Keypop Reader API". Indeed, these two methods implemented filtering on power-on data, and it is now up to the 
  implementation libraries to propose utility methods to recreate the regexes to be used for power-on data based on 
  product type and/or serial number.

## [0.2.0] - 2023-02-27
### Added
- `SystemKeyType` API.
- `KeyParameter` API.
- `LSSecuritySetting` API.
- `LSWriteTransactionManager` API.
- `LSAsyncTransactionCreatorManager` API.
- `LSAsyncTransactionExecutorManager` API.
- `LSSecuritySettingFactory` API.
- `LegacySam.getSystemKeyParameter` method.
- `LegacySam.isManualCounterIncrementAuthorized` method.
- `LSTransactionManagerFactory.createAsyncTransactionCreatorManager` method.
- `LSTransactionManagerFactory.createAsyncTransactionExecutorManager` method.
- `LSFreeTransactionManager.exportTargetSamContextForAsyncTransaction` method.
- `LSReadTransactionManager.prepareReadSystemKeyParameters` method.
- `LSReadTransactionManager.prepareReadCounterStatus` method.
- `LSReadTransactionManager.prepareReadAllCountersStatus` method.
- `LSWriteTransactionManager.prepareWriteCounterCeiling` method.
- `LSWriteTransactionManager.prepareWriteCounterConfiguration` method.
### Upgraded
- "Calypsonet Terminal Reader API" to version `1.2.0`.

## [0.1.0] - 2022-12-12
### Added
- APIs of the SAM image and SAM selection.
- APIs related to signature computation and verification as well as counter and ceiling reading.
  
[unreleased]: https://github.com/eclipse-keypop/keypop-calypso-crypto-legacysam-java-api/compare/0.7.0...HEAD
[0.7.0]: https://github.com/eclipse-keypop/keypop-calypso-crypto-legacysam-java-api/compare/0.6.0...0.7.0
[0.6.0]: https://github.com/eclipse-keypop/keypop-calypso-crypto-legacysam-java-api/compare/0.5.0...0.6.0
[0.5.0]: https://github.com/eclipse-keypop/keypop-calypso-crypto-legacysam-java-api/compare/0.4.0...0.5.0
[0.4.0]: https://github.com/eclipse-keypop/keypop-calypso-crypto-legacysam-java-api/compare/0.3.0...0.4.0
[0.3.0]: https://github.com/eclipse-keypop/keypop-calypso-crypto-legacysam-java-api/releases/tag/0.3.0
[0.2.0]: https://github.com/calypsonet/calypsonet-terminal-calypso-crypto-legacysam-java-api/compare/0.1.0...0.2.0
[0.1.0]: https://github.com/calypsonet/calypsonet-terminal-calypso-crypto-legacysam-java-api/releases/tag/0.1.0