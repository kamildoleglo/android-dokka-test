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

import android.nfc.NdefMessage;
import android.nfc.Tag;
import java.io.IOException;
import android.nfc.FormatException;
import android.nfc.TagLostException;

/**
 * Provides access to NDEF content and operations on a {@link android.nfc.Tag Tag}.
 *
 * <p>Acquire a {@link android.nfc.tech.Ndef Ndef} object using {@link #get}.
 *
 * <p>NDEF is an NFC Forum data format. The data formats are implemented in
 * {@link android.nfc.NdefMessage} and
 * {@link android.nfc.NdefRecord}. This class provides methods to
 * retrieve and modify the {@link android.nfc.NdefMessage}
 * on a tag.
 *
 * <p>There are currently four NFC Forum standardized tag types that can be
 * formatted to contain NDEF data.
 * <ul>
 * <li>NFC Forum Type 1 Tag ({@link #NFC_FORUM_TYPE_1}), such as the Innovision Topaz
 * <li>NFC Forum Type 2 Tag ({@link #NFC_FORUM_TYPE_2}), such as the NXP MIFARE Ultralight
 * <li>NFC Forum Type 3 Tag ({@link #NFC_FORUM_TYPE_3}), such as Sony Felica
 * <li>NFC Forum Type 4 Tag ({@link #NFC_FORUM_TYPE_4}), such as NXP MIFARE Desfire
 * </ul>
 * It is mandatory for all Android devices with NFC to correctly enumerate
 * {@link android.nfc.tech.Ndef Ndef} on NFC Forum Tag Types 1-4, and implement all NDEF operations
 * as defined in this class.
 *
 * <p>Some vendors have their own well defined specifications for storing NDEF data
 * on tags that do not fall into the above categories. Android devices with NFC
 * should enumerate and implement {@link android.nfc.tech.Ndef Ndef} under these vendor specifications
 * where possible, but it is not mandatory. {@link #getType} returns a String
 * describing this specification, for example {@link #MIFARE_CLASSIC} is
 * <code>com.nxp.ndef.mifareclassic</code>.
 *
 * <p>Android devices that support MIFARE Classic must also correctly
 * implement {@link android.nfc.tech.Ndef Ndef} on MIFARE Classic tags formatted to NDEF.
 *
 * <p>For guaranteed compatibility across all Android devices with NFC, it is
 * recommended to use NFC Forum Types 1-4 in new deployments of NFC tags
 * with NDEF payload. Vendor NDEF formats will not work on all Android devices.
 *
 * <p class="note"><strong>Note:</strong> Methods that perform I/O operations
 * require the {@link android.Manifest.permission#NFC} permission.
 * @apiSince 10
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Ndef implements android.nfc.tech.TagTechnology {

Ndef() { throw new RuntimeException("Stub!"); }

/**
 * Get an instance of {@link android.nfc.tech.Ndef Ndef} for the given tag.
 *
 * <p>Returns null if {@link android.nfc.tech.Ndef Ndef} was not enumerated in {@link android.nfc.Tag#getTechList Tag#getTechList}.
 * This indicates the tag is not NDEF formatted, or that this tag
 * is NDEF formatted but under a vendor specification that this Android
 * device does not implement.
 *
 * <p>Does not cause any RF activity and does not block.
 *
 * @param tag an NDEF compatible tag
 * @return Ndef object
 * @apiSince 10
 */

public static android.nfc.tech.Ndef get(android.nfc.Tag tag) { throw new RuntimeException("Stub!"); }

/**
 * Get the {@link android.nfc.NdefMessage NdefMessage} that was read from the tag at discovery time.
 *
 * <p>If the NDEF Message is modified by an I/O operation then it
 * will not be updated here, this function only returns what was discovered
 * when the tag entered the field.
 * <p>Note that this method may return null if the tag was in the
 * INITIALIZED state as defined by NFC Forum, as in this state the
 * tag is formatted to support NDEF but does not contain a message yet.
 * <p>Does not cause any RF activity and does not block.
 * @return NDEF Message read from the tag at discovery time, can be null
 * @apiSince 10
 */

public android.nfc.NdefMessage getCachedNdefMessage() { throw new RuntimeException("Stub!"); }

/**
 * Get the NDEF tag type.
 *
 * <p>Returns one of {@link #NFC_FORUM_TYPE_1}, {@link #NFC_FORUM_TYPE_2},
 * {@link #NFC_FORUM_TYPE_3}, {@link #NFC_FORUM_TYPE_4},
 * {@link #MIFARE_CLASSIC} or another NDEF tag type that has not yet been
 * formalized in this Android API.
 *
 * <p>Does not cause any RF activity and does not block.
 *
 * @return a string representing the NDEF tag type
 * @apiSince 10
 */

public java.lang.String getType() { throw new RuntimeException("Stub!"); }

/**
 * Get the maximum NDEF message size in bytes.
 *
 * <p>Does not cause any RF activity and does not block.
 *
 * @return size in bytes
 * @apiSince 10
 */

public int getMaxSize() { throw new RuntimeException("Stub!"); }

/**
 * Determine if the tag is writable.
 *
 * <p>NFC Forum tags can be in read-only or read-write states.
 *
 * <p>Does not cause any RF activity and does not block.
 *
 * <p>Requires {@link android.Manifest.permission#NFC} permission.
 *
 * @return true if the tag is writable
 * @apiSince 10
 */

public boolean isWritable() { throw new RuntimeException("Stub!"); }

/**
 * Read the current {@link android.nfc.NdefMessage} on this tag.
 *
 * <p>This always reads the current NDEF Message stored on the tag.
 *
 * <p>Note that this method may return null if the tag was in the
 * INITIALIZED state as defined by NFC Forum, as in that state the
 * tag is formatted to support NDEF but does not contain a message yet.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @return the NDEF Message, can be null
 * @throws android.nfc.TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or the operation is canceled
 * @throws android.nfc.FormatException if the NDEF Message on the tag is malformed
 * @apiSince 10
 */

public android.nfc.NdefMessage getNdefMessage() throws android.nfc.FormatException, java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Overwrite the {@link android.nfc.NdefMessage NdefMessage} on this tag.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param msg the NDEF Message to write, must not be null
 * @throws android.nfc.TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or the operation is canceled
 * @throws android.nfc.FormatException if the NDEF Message to write is malformed
 * @apiSince 10
 */

public void writeNdefMessage(android.nfc.NdefMessage msg) throws android.nfc.FormatException, java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether a tag can be made read-only with {@link #makeReadOnly()}.
 *
 * <p>Does not cause any RF activity and does not block.
 *
 * @return true if it is possible to make this tag read-only
 * @apiSince 10
 */

public boolean canMakeReadOnly() { throw new RuntimeException("Stub!"); }

/**
 * Make a tag read-only.
 *
 * <p>This sets the CC field to indicate the tag is read-only,
 * and where possible permanently sets the lock bits to prevent
 * any further modification of the memory.
 * <p>This is a one-way process and cannot be reverted!
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @return true on success, false if it is not possible to make this tag read-only
 * @throws android.nfc.TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or the operation is canceled
 * @apiSince 10
 */

public boolean makeReadOnly() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public boolean isConnected() { throw new RuntimeException("Stub!"); }

public android.nfc.Tag getTag() { throw new RuntimeException("Stub!"); }

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public void connect() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * NDEF on MIFARE Classic
 * @apiSince 10
 */

public static final java.lang.String MIFARE_CLASSIC = "com.nxp.ndef.mifareclassic";

/**
 * NFC Forum Tag Type 1
 * @apiSince 10
 */

public static final java.lang.String NFC_FORUM_TYPE_1 = "org.nfcforum.ndef.type1";

/**
 * NFC Forum Tag Type 2
 * @apiSince 10
 */

public static final java.lang.String NFC_FORUM_TYPE_2 = "org.nfcforum.ndef.type2";

/**
 * NFC Forum Tag Type 4
 * @apiSince 10
 */

public static final java.lang.String NFC_FORUM_TYPE_3 = "org.nfcforum.ndef.type3";

/**
 * NFC Forum Tag Type 4
 * @apiSince 10
 */

public static final java.lang.String NFC_FORUM_TYPE_4 = "org.nfcforum.ndef.type4";
}

