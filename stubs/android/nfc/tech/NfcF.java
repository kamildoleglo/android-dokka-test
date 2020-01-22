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
 * Provides access to NFC-F (JIS 6319-4) properties and I/O operations on a {@link android.nfc.Tag Tag}.
 *
 * <p>Acquire a {@link android.nfc.tech.NfcF NfcF} object using {@link #get}.
 * <p>The primary NFC-F I/O operation is {@link #transceive}. Applications must
 * implement their own protocol stack on top of {@link #transceive}.
 *
 * <p class="note"><strong>Note:</strong> Methods that perform I/O operations
 * require the {@link android.Manifest.permission#NFC} permission.
 * @apiSince 10
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NfcF implements android.nfc.tech.TagTechnology {

NfcF() { throw new RuntimeException("Stub!"); }

/**
 * Get an instance of {@link android.nfc.tech.NfcF NfcF} for the given tag.
 * <p>Returns null if {@link android.nfc.tech.NfcF NfcF} was not enumerated in {@link android.nfc.Tag#getTechList Tag#getTechList}.
 * This indicates the tag does not support NFC-F.
 * <p>Does not cause any RF activity and does not block.
 *
 * @param tag an NFC-F compatible tag
 * @return NFC-F object
 * @apiSince 10
 */

public static android.nfc.tech.NfcF get(android.nfc.Tag tag) { throw new RuntimeException("Stub!"); }

/**
 * Return the System Code bytes from tag discovery.
 *
 * <p>Does not cause any RF activity and does not block.
 *
 * @return System Code bytes
 * @apiSince 10
 */

public byte[] getSystemCode() { throw new RuntimeException("Stub!"); }

/**
 * Return the Manufacturer bytes from tag discovery.
 *
 * <p>Does not cause any RF activity and does not block.
 *
 * @return Manufacturer bytes
 * @apiSince 10
 */

public byte[] getManufacturer() { throw new RuntimeException("Stub!"); }

/**
 * Send raw NFC-F commands to the tag and receive the response.
 *
 * <p>Applications must not prefix the SoD (preamble and sync code)
 * and/or append the EoD (CRC) to the payload, it will be automatically calculated.
 *
 * <p>A typical NFC-F frame for this method looks like:
 * <pre>
 * LENGTH (1 byte) --- CMD (1 byte) -- IDm (8 bytes) -- PARAMS (LENGTH - 10 bytes)
 * </pre>
 *
 * <p>Use {@link #getMaxTransceiveLength} to retrieve the maximum amount of bytes
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

