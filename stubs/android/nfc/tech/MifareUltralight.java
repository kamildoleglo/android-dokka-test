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
import android.nfc.TagLostException;

/**
 * Provides access to MIFARE Ultralight properties and I/O operations on a {@link android.nfc.Tag Tag}.
 *
 * <p>Acquire a {@link android.nfc.tech.MifareUltralight MifareUltralight} object using {@link #get}.
 *
 * <p>MIFARE Ultralight compatible tags have 4 byte pages {@link #PAGE_SIZE}.
 * The primary operations on an Ultralight tag are {@link #readPages} and
 * {@link #writePage}.
 *
 * <p>The original MIFARE Ultralight consists of a 64 byte EEPROM. The first
 * 4 pages are for the OTP area, manufacturer data, and locking bits. They are
 * readable and some bits are writable. The final 12 pages are the user
 * read/write area. For more information see the NXP data sheet MF0ICU1.
 *
 * <p>The MIFARE Ultralight C consists of a 192 byte EEPROM. The first 4 pages
 * are for OTP, manufacturer data, and locking bits. The next 36 pages are the
 * user read/write area. The next 4 pages are additional locking bits, counters
 * and authentication configuration and are readable. The final 4 pages are for
 * the authentication key and are not readable. For more information see the
 * NXP data sheet MF0ICU2.
 *
 * <p>Implementation of this class on a Android NFC device is optional.
 * If it is not implemented, then
 * {@link android.nfc.tech.MifareUltralight MifareUltralight} will never be enumerated in {@link android.nfc.Tag#getTechList Tag#getTechList}.
 * If it is enumerated, then all {@link android.nfc.tech.MifareUltralight MifareUltralight} I/O operations will be supported.
 * In either case, {@link android.nfc.tech.NfcA NfcA} will also be enumerated on the tag,
 * because all MIFARE Ultralight tags are also {@link android.nfc.tech.NfcA NfcA} tags.
 *
 * <p class="note"><strong>Note:</strong> Methods that perform I/O operations
 * require the {@link android.Manifest.permission#NFC} permission.
 * @apiSince 10
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MifareUltralight implements android.nfc.tech.TagTechnology {

MifareUltralight() { throw new RuntimeException("Stub!"); }

/**
 * Get an instance of {@link android.nfc.tech.MifareUltralight MifareUltralight} for the given tag.
 * <p>Returns null if {@link android.nfc.tech.MifareUltralight MifareUltralight} was not enumerated in
 * {@link android.nfc.Tag#getTechList Tag#getTechList} - this indicates the tag is not MIFARE
 * Ultralight compatible, or that this Android
 * device does not implement MIFARE Ultralight.
 * <p>Does not cause any RF activity and does not block.
 *
 * @param tag an MIFARE Ultralight compatible tag
 * @return MIFARE Ultralight object
 * @apiSince 10
 */

public static android.nfc.tech.MifareUltralight get(android.nfc.Tag tag) { throw new RuntimeException("Stub!"); }

/**
 * Return the MIFARE Ultralight type of the tag.
 * <p>One of {@link #TYPE_ULTRALIGHT} or {@link #TYPE_ULTRALIGHT_C} or
 * {@link #TYPE_UNKNOWN}.
 * <p>Depending on how the tag has been formatted, it can be impossible
 * to accurately classify between original MIFARE Ultralight and
 * Ultralight C. So treat this method as a hint.
 * <p>Does not cause any RF activity and does not block.
 *
 * @return the type
 * @apiSince 10
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Read 4 pages (16 bytes).
 *
 * <p>The MIFARE Ultralight protocol always reads 4 pages at a time, to
 * reduce the number of commands required to read an entire tag.
 * <p>If a read spans past the last readable block, then the tag will
 * return pages that have been wrapped back to the first blocks. MIFARE
 * Ultralight tags have readable blocks 0x00 through 0x0F. So a read to
 * block offset 0x0E would return blocks 0x0E, 0x0F, 0x00, 0x01. MIFARE
 * Ultralight C tags have readable blocks 0x00 through 0x2B. So a read to
 * block 0x2A would return blocks 0x2A, 0x2B, 0x00, 0x01.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param pageOffset index of first page to read, starting from 0
 * @return 4 pages (16 bytes)
 * @throws android.nfc.TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or the operation is canceled
 * @apiSince 10
 */

public byte[] readPages(int pageOffset) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Write 1 page (4 bytes).
 *
 * <p>The MIFARE Ultralight protocol always writes 1 page at a time, to
 * minimize EEPROM write cycles.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param pageOffset index of page to write, starting from 0
 * @param data 4 bytes to write
 * @throws android.nfc.TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or the operation is canceled
 * @apiSince 10
 */

public void writePage(int pageOffset, byte[] data) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Send raw NfcA data to a tag and receive the response.
 *
 * <p>This is equivalent to connecting to this tag via {@link android.nfc.tech.NfcA NfcA}
 * and calling {@link android.nfc.tech.NfcA#transceive NfcA#transceive}. Note that all MIFARE Classic
 * tags are based on {@link android.nfc.tech.NfcA NfcA} technology.
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
 * @see NfcA#transceive
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

/**
 * Size of a MIFARE Ultralight page in bytes
 * @apiSince 10
 */

public static final int PAGE_SIZE = 4; // 0x4

/**
 * A MIFARE Ultralight tag
 * @apiSince 10
 */

public static final int TYPE_ULTRALIGHT = 1; // 0x1

/**
 * A MIFARE Ultralight C tag
 * @apiSince 10
 */

public static final int TYPE_ULTRALIGHT_C = 2; // 0x2

/**
 * A MIFARE Ultralight compatible tag of unknown type
 * @apiSince 10
 */

public static final int TYPE_UNKNOWN = -1; // 0xffffffff
}

