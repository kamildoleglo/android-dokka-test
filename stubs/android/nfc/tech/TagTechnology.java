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
 * {@link android.nfc.tech.TagTechnology TagTechnology} is an interface to a technology in a {@link android.nfc.Tag Tag}.
 * <p>
 * Obtain a {@link android.nfc.tech.TagTechnology TagTechnology} implementation by calling the static method <code>get()</code>
 * on the implementation class.
 * <p>
 * NFC tags are based on a number of independently developed technologies and offer a
 * wide range of capabilities. The
 * {@link android.nfc.tech.TagTechnology TagTechnology} implementations provide access to these different
 * technologies and capabilities. Some sub-classes map to technology
 * specification (for example {@link android.nfc.tech.NfcA NfcA}, {@link android.nfc.tech.IsoDep IsoDep}, others map to
 * pseudo-technologies or capabilities (for example {@link android.nfc.tech.Ndef Ndef}, {@link android.nfc.tech.NdefFormatable NdefFormatable}).
 * <p>
 * It is mandatory for all Android NFC devices to provide the following
 * {@link android.nfc.tech.TagTechnology TagTechnology} implementations.
 * <ul>
 * <li>{@link android.nfc.tech.NfcA NfcA} (also known as ISO 14443-3A)
 * <li>{@link android.nfc.tech.NfcB NfcB} (also known as ISO 14443-3B)
 * <li>{@link android.nfc.tech.NfcF NfcF} (also known as JIS 6319-4)
 * <li>{@link android.nfc.tech.NfcV NfcV} (also known as ISO 15693)
 * <li>{@link android.nfc.tech.IsoDep IsoDep}
 * <li>{@link android.nfc.tech.Ndef Ndef} on NFC Forum Type 1, Type 2, Type 3 or Type 4 compliant tags
 * </ul>
 * It is optional for Android NFC devices to provide the following
 * {@link android.nfc.tech.TagTechnology TagTechnology} implementations. If it is not provided, the
 * Android device will never enumerate that class via {@link android.nfc.Tag#getTechList Tag#getTechList}.
 * <ul>
 * <li>{@link android.nfc.tech.MifareClassic MifareClassic}
 * <li>{@link android.nfc.tech.MifareUltralight MifareUltralight}
 * <li>{@link android.nfc.tech.NfcBarcode NfcBarcode}
 * <li>{@link android.nfc.tech.NdefFormatable NdefFormatable} must only be enumerated on tags for which this Android device
 * is capable of formatting. Proprietary knowledge is often required to format a tag
 * to make it NDEF compatible.
 * </ul>
 * <p>
 * {@link android.nfc.tech.TagTechnology TagTechnology} implementations provide methods that fall into two classes:
 * <em>cached getters</em> and <em>I/O operations</em>.
 * <h4>Cached getters</h4>
 * These methods (usually prefixed by <code>get</code> or <code>is</code>) return
 * properties of the tag, as determined at discovery time. These methods will never
 * block or cause RF activity, and do not require {@link #connect} to have been called.
 * They also never update, for example if a property is changed by an I/O operation with a tag
 * then the cached getter will still return the result from tag discovery time.
 * <h4>I/O operations</h4>
 * I/O operations may require RF activity, and may block. They have the following semantics.
 * <ul>
 * <li>{@link #connect} must be called before using any other I/O operation.
 * <li>{@link #close} must be called after completing I/O operations with a
 * {@link android.nfc.tech.TagTechnology TagTechnology}, and it will cancel all other blocked I/O operations on other threads
 * (including {@link #connect} with {@link java.io.IOException IOException}.
 * <li>Only one {@link android.nfc.tech.TagTechnology TagTechnology} can be connected at a time. Other calls to
 * {@link #connect} will return {@link java.io.IOException IOException}.
 * <li>I/O operations may block, and should never be called on the main application
 * thread.
 * </ul>
 *
 * <p class="note"><strong>Note:</strong> Methods that perform I/O operations
 * require the {@link android.Manifest.permission#NFC} permission.
 * @apiSince 10
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface TagTechnology extends java.io.Closeable {

/**
 * Get the {@link android.nfc.Tag Tag} object backing this {@link android.nfc.tech.TagTechnology TagTechnology} object.
 * @return the {@link android.nfc.Tag Tag} backing this {@link android.nfc.tech.TagTechnology TagTechnology} object.
 * @apiSince 10
 */

public android.nfc.Tag getTag();

/**
 * Enable I/O operations to the tag from this {@link android.nfc.tech.TagTechnology TagTechnology} object.
 * <p>May cause RF activity and may block. Must not be called
 * from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} by calling {@link #close} from another thread.
 * <p>Only one {@link android.nfc.tech.TagTechnology TagTechnology} object can be connected to a {@link android.nfc.Tag Tag} at a time.
 * <p>Applications must call {@link #close} when I/O operations are complete.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @see #close()
 * @throws TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or connect is canceled
 * @apiSince 10
 */

public void connect() throws java.io.IOException;

/**
 * Disable I/O operations to the tag from this {@link android.nfc.tech.TagTechnology TagTechnology} object, and release resources.
 * <p>Also causes all blocked I/O operations on other thread to be canceled and
 * return with {@link java.io.IOException IOException}.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @see #connect()
 * @apiSince 10
 */

public void close() throws java.io.IOException;

/**
 * Helper to indicate if I/O operations should be possible.
 *
 * <p>Returns true if {@link #connect} has completed, and {@link #close} has not been
 * called, and the {@link android.nfc.Tag Tag} is not known to be out of range.
 * <p>Does not cause RF activity, and does not block.
 *
 * @return true if I/O operations should be possible
 * @apiSince 10
 */

public boolean isConnected();
}

