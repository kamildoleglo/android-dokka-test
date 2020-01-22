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
import android.nfc.NdefMessage;
import java.io.IOException;
import android.nfc.FormatException;
import android.nfc.TagLostException;

/**
 * Provide access to NDEF format operations on a {@link android.nfc.Tag Tag}.
 *
 * <p>Acquire a {@link android.nfc.tech.NdefFormatable NdefFormatable} object using {@link #get}.
 *
 * <p>Android devices with NFC must only enumerate and implement this
 * class for tags for which it can format to NDEF.
 *
 * <p>Unfortunately the procedures to convert unformated tags to NDEF formatted
 * tags are not specified by NFC Forum, and are not generally well-known. So
 * there is no mandatory set of tags for which all Android devices with NFC
 * must support {@link android.nfc.tech.NdefFormatable NdefFormatable}.
 *
 * <p class="note"><strong>Note:</strong> Methods that perform I/O operations
 * require the {@link android.Manifest.permission#NFC} permission.
 * @apiSince 10
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NdefFormatable implements android.nfc.tech.TagTechnology {

NdefFormatable() { throw new RuntimeException("Stub!"); }

/**
 * Get an instance of {@link android.nfc.tech.NdefFormatable NdefFormatable} for the given tag.
 * <p>Does not cause any RF activity and does not block.
 * <p>Returns null if {@link android.nfc.tech.NdefFormatable NdefFormatable} was not enumerated in {@link android.nfc.Tag#getTechList Tag#getTechList}.
 * This indicates the tag is not NDEF formatable by this Android device.
 *
 * @param tag an NDEF formatable tag
 * @return NDEF formatable object
 * @apiSince 10
 */

public static android.nfc.tech.NdefFormatable get(android.nfc.Tag tag) { throw new RuntimeException("Stub!"); }

/**
 * Format a tag as NDEF, and write a {@link android.nfc.NdefMessage NdefMessage}.
 *
 * <p>This is a multi-step process, an IOException is thrown
 * if any one step fails.
 * <p>The card is left in a read-write state after this operation.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param firstMessage the NDEF message to write after formatting, can be null
 * @throws android.nfc.TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or the operation is canceled
 * @throws android.nfc.FormatException if the NDEF Message to write is malformed
 * @apiSince 10
 */

public void format(android.nfc.NdefMessage firstMessage) throws android.nfc.FormatException, java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Formats a tag as NDEF, write a {@link android.nfc.NdefMessage NdefMessage}, and make read-only.
 *
 * <p>This is a multi-step process, an IOException is thrown
 * if any one step fails.
 * <p>The card is left in a read-only state if this method returns successfully.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param firstMessage the NDEF message to write after formatting
 * @throws android.nfc.TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or the operation is canceled
 * @throws android.nfc.FormatException if the NDEF Message to write is malformed
 * @apiSince 10
 */

public void formatReadOnly(android.nfc.NdefMessage firstMessage) throws android.nfc.FormatException, java.io.IOException { throw new RuntimeException("Stub!"); }

public boolean isConnected() { throw new RuntimeException("Stub!"); }

public android.nfc.Tag getTag() { throw new RuntimeException("Stub!"); }

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public void connect() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

