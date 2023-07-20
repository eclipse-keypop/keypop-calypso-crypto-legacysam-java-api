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
package org.eclipse.keypop.calypso.crypto.legacysam.transaction;

/**
 * Contains the input/output data of the {@link
 * FreeTransactionManager#prepareVerifySignature(SignatureVerificationData)} method for basic
 * signature verification using the "Data Cipher" command.
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * org.eclipse.keypop.calypso.crypto.legacysam.LegacySamApiFactory#createBasicSignatureVerificationData()}.
 *
 * @since 0.1.0
 */
public interface BasicSignatureVerificationData
    extends SignatureVerificationData<BasicSignatureVerificationData> {}
