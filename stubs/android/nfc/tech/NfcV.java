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
 * Provides access to NFC-V (ISO 15693) properties and I/O operations on a {@link android.nfc.Tag Tag}.
 *
 * <p>Acquire a {@link android.nfc.tech.NfcV NfcV} object using {@link #get}.
 * <p>The primary NFC-V I/O operation is {@link #transceive}. Applications must
 * implement their own protocol stack on top of {@link #transceive}.
 *
 * <p class="note"><strong>Note:</strong> Methods that perform I/O operations
 * require the {@link android.Manifest.permission#NFC} permission.
 * @apiSince 10
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NfcV implements android.nfc.tech.TagTechnology {

NfcV() { throw new RuntimeException("Stub!"); }

/**
 * Get an instance of {@link android.nfc.tech.NfcV NfcV} for the given tag.
 * <p>Returns null if {@link android.nfc.tech.NfcV NfcV} was not enumerated in {@link android.nfc.Tag#getTechList Tag#getTechList}.
 * This indicates the tag does not support NFC-V.
 * <p>Does not cause any RF activity and does not block.
 *
 * @param tag an NFC-V compatible tag
 * @return NFC-V object
 * @apiSince 10
 */

public static android.nfc.tech.NfcV get(android.nfc.Tag tag) { throw new RuntimeException("Stub!"); }

/**
 * Return the Response Flag bytes from tag discovery.
 *
 * <p>Does not cause any RF activity and does not block.
 *
 * @return Response Flag bytes
 * @apiSince 10
 */

public byte getResponseFlags() { throw new RuntimeException("Stub!"); }

/**
 * Return the DSF ID bytes from tag discovery.
 *
 * <p>Does not cause any RF activity and does not block.
 *
 * @return DSF ID bytes
 * @apiSince 10
 */

public byte getDsfId() { throw new RuntimeException("Stub!"); }

/**
 * Send raw NFC-V commands to the tag and receive the response.
 *
 * <p>Applications must not append the CRC to the payload,
 * it will be automatically calculated. The application does
 * provide FLAGS, CMD and PARAMETER bytes.
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

public boolean isConnected() { throw new RuntimeException("Stub!"); }

public android.nfc.Tag getTag() { throw new RuntimeException("Stub!"); }

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public void connect() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

