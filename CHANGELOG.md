# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

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
  
[unreleased]: https://github.com/calypsonet/calypsonet-terminal-calypso-crypto-legacysam-java-api/compare/0.2.0...HEAD
[0.2.0]: https://github.com/calypsonet/calypsonet-terminal-calypso-crypto-legacysam-java-api/compare/0.1.0...0.2.0
[0.1.0]: https://github.com/calypsonet/calypsonet-terminal-calypso-crypto-legacysam-java-api/releases/tag/0.1.0