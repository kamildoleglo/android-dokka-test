/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.nfc.tech;

import android.nfc.Tag;
import java.io.IOException;

/**
 * Provides access to NFC-A (ISO 14443-3A) properties and I/O operations on a {@link android.nfc.Tag Tag}.
 *
 * <p>Acquire a {@link android.nfc.tech.NfcA NfcA} object using {@link #get}.
 * <p>The primary NFC-A I/O operation is {@link #transceive}. Applications must
 * implement their own protocol stack on top of {@link #transceive}.
 *
 * <p class="note"><strong>Note:</strong> Methods that perform I/O operations
 * require the {@link android.Manifest.permission#NFC} permission.
 * @apiSince 10
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NfcA implements android.nfc.tech.TagTechnology {

NfcA() { throw new RuntimeException("Stub!"); }

/**
 * Get an instance of {@link android.nfc.tech.NfcA NfcA} for the given tag.
 * <p>Returns null if {@link android.nfc.tech.NfcA NfcA} was not enumerated in {@link android.nfc.Tag#getTechList Tag#getTechList}.
 * This indicates the tag does not support NFC-A.
 * <p>Does not cause any RF activity and does not block.
 *
 * @param tag an NFC-A compatible tag
 * @return NFC-A object
 * @apiSince 10
 */

public static android.nfc.tech.NfcA get(android.nfc.Tag tag) { throw new RuntimeException("Stub!"); }

/**
 * Return the ATQA/SENS_RES bytes from tag discovery.
 *
 * <p>Does not cause any RF activity and does not block.
 *
 * @return ATQA/SENS_RES bytes
 * @apiSince 10
 */

public byte[] getAtqa() { throw new RuntimeException("Stub!"); }

/**
 * Return the SAK/SEL_RES bytes from tag discovery.
 *
 * <p>Does not cause any RF activity and does not block.
 *
 * @return SAK bytes
 * @apiSince 10
 */

public short getSak() { throw new RuntimeException("Stub!"); }

/**
 * Send raw NFC-A commands to the tag and receive the response.
 *
 * <p>Applications must not append the EoD (CRC) to the payload,
 * it will be automatically calculated.
 * <p>Applications must only send commands that are complete bytes,
 * for example a SENS_REQ is not possible (these are used to
 * manage tag polling and initialization).
 *
 * <p>Use {@link #getMaxTransceiveLength} to retrieve the maximum number of bytes
 * that can be sent with {@link #transceive}.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param data bytes to send
 * @return bytes received in response
 * @throws TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or this operation is canceled
 * @apiSince 10
 */

public byte[] transceive(byte[] data) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return the maximum number of bytes that can be sent with {@link #transceive}.
 * @return the maximum number of bytes that can be sent with {@link #transceive}.
 * @apiSince 14
 */

public int getMaxTransceiveLength() { throw new RuntimeException("Stub!"); }

/**
 * Set the {@link #transceive} timeout in milliseconds.
 *
 * <p>The timeout only applies to {@link #transceive} on this object,
 * and is reset to a default value when {@link #close} is called.
 *
 * <p>Setting a longer timeout may be useful when performing
 * transactions that require a long processing time on the tag
 * such as key generation.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param timeout timeout value in milliseconds
 * @apiSince 14
 */

public void setTimeout(int timeout) { throw new RuntimeException("Stub!"); }

/**
 * Get the current {@link #transceive} timeout in milliseconds.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @return timeout value in milliseconds
 * @apiSince 14
 */

public int getTimeout() { throw new RuntimeException("Stub!"); }

public boolean isConnected() { throw new RuntimeException("Stub!"); }

public android.nfc.Tag getTag() { throw new RuntimeException("Stub!"); }

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public void connect() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

