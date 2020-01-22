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


package android.nfc;

import android.content.Context;
import android.nfc.tech.TagTechnology;
import java.util.Arrays;

/**
 * Represents an NFC tag that has been discovered.
 * <p>
 * {@link android.nfc.Tag Tag} is an immutable object that represents the state of a NFC tag at
 * the time of discovery. It can be used as a handle to {@link android.nfc.tech.TagTechnology TagTechnology} classes
 * to perform advanced operations, or directly queried for its ID via {@link #getId} and the
 * set of technologies it contains via {@link #getTechList}. Arrays passed to and
 * returned by this class are <em>not</em> cloned, so be careful not to modify them.
 * <p>
 * A new tag object is created every time a tag is discovered (comes into range), even
 * if it is the same physical tag. If a tag is removed and then returned into range, then
 * only the most recent tag object can be successfully used to create a {@link android.nfc.tech.TagTechnology TagTechnology}.
 *
 * <h3>Tag Dispatch</h3>
 * When a tag is discovered, a {@link android.nfc.Tag Tag} object is created and passed to a
 * single activity via the {@link android.nfc.NfcAdapter#EXTRA_TAG NfcAdapter#EXTRA_TAG} extra in an
 * {@link android.content.Intent} via {@link android.content.Context#startActivity Context#startActivity}. A four stage dispatch is used
 * to select the
 * most appropriate activity to handle the tag. The Android OS executes each stage in order,
 * and completes dispatch as soon as a single matching activity is found. If there are multiple
 * matching activities found at any one stage then the Android activity chooser dialog is shown
 * to allow the user to select the activity to receive the tag.
 *
 * <p>The Tag dispatch mechanism was designed to give a high probability of dispatching
 * a tag to the correct activity without showing the user an activity chooser dialog.
 * This is important for NFC interactions because they are very transient -- if a user has to
 * move the Android device to choose an application then the connection will likely be broken.
 *
 * <h4>1. Foreground activity dispatch</h4>
 * A foreground activity that has called
 * {@link android.nfc.NfcAdapter#enableForegroundDispatch NfcAdapter#enableForegroundDispatch} is
 * given priority. See the documentation on
 * {@link android.nfc.NfcAdapter#enableForegroundDispatch NfcAdapter#enableForegroundDispatch} for
 * its usage.
 * <h4>2. NDEF data dispatch</h4>
 * If the tag contains NDEF data the system inspects the first {@link android.nfc.NdefRecord NdefRecord} in the first
 * {@link android.nfc.NdefMessage NdefMessage}. If the record is a URI, SmartPoster, or MIME data
 * {@link android.content.Context#startActivity Context#startActivity} is called with {@link android.nfc.NfcAdapter#ACTION_NDEF_DISCOVERED NfcAdapter#ACTION_NDEF_DISCOVERED}. For URI
 * and SmartPoster records the URI is put into the intent's data field. For MIME records the MIME
 * type is put in the intent's type field. This allows activities to register to be launched only
 * when data they know how to handle is present on a tag. This is the preferred method of handling
 * data on a tag since NDEF data can be stored on many types of tags and doesn't depend on a
 * specific tag technology.
 * See {@link android.nfc.NfcAdapter#ACTION_NDEF_DISCOVERED NfcAdapter#ACTION_NDEF_DISCOVERED} for more detail. If the tag does not contain
 * NDEF data, or if no activity is registered
 * for {@link android.nfc.NfcAdapter#ACTION_NDEF_DISCOVERED NfcAdapter#ACTION_NDEF_DISCOVERED} with a matching data URI or MIME type then dispatch
 * moves to stage 3.
 * <h4>3. Tag Technology dispatch</h4>
 * {@link android.content.Context#startActivity Context#startActivity} is called with {@link android.nfc.NfcAdapter#ACTION_TECH_DISCOVERED NfcAdapter#ACTION_TECH_DISCOVERED} to
 * dispatch the tag to an activity that can handle the technologies present on the tag.
 * Technologies are defined as sub-classes of {@link android.nfc.tech.TagTechnology TagTechnology}, see the package
 * {@link android.nfc.tech}. The Android OS looks for an activity that can handle one or
 * more technologies in the tag. See {@link android.nfc.NfcAdapter#ACTION_TECH_DISCOVERED NfcAdapter#ACTION_TECH_DISCOVERED} for more detail.
 * <h4>4. Fall-back dispatch</h4>
 * If no activity has been matched then {@link android.content.Context#startActivity Context#startActivity} is called with
 * {@link android.nfc.NfcAdapter#ACTION_TAG_DISCOVERED NfcAdapter#ACTION_TAG_DISCOVERED}. This is intended as a fall-back mechanism.
 * See {@link android.nfc.NfcAdapter#ACTION_TAG_DISCOVERED NfcAdapter#ACTION_TAG_DISCOVERED}.
 *
 * <h3>NFC Tag Background</h3>
 * An NFC tag is a passive NFC device, powered by the NFC field of this Android device while
 * it is in range. Tag's can come in many forms, such as stickers, cards, key fobs, or
 * even embedded in a more sophisticated device.
 * <p>
 * Tags can have a wide range of capabilities. Simple tags just offer read/write semantics,
 * and contain some one time
 * programmable areas to make read-only. More complex tags offer math operations
 * and per-sector access control and authentication. The most sophisticated tags
 * contain operating environments allowing complex interactions with the
 * code executing on the tag. Use {@link android.nfc.tech.TagTechnology TagTechnology} classes to access a broad
 * range of capabilities available in NFC tags.
 * <p>
 * @apiSince 10
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Tag implements android.os.Parcelable {

Tag() { throw new RuntimeException("Stub!"); }

/**
 * Get the Tag Identifier (if it has one).
 * <p>The tag identifier is a low level serial number, used for anti-collision
 * and identification.
 * <p> Most tags have a stable unique identifier
 * (UID), but some tags will generate a random ID every time they are discovered
 * (RID), and there are some tags with no ID at all (the byte array will be zero-sized).
 * <p> The size and format of an ID is specific to the RF technology used by the tag.
 * <p> This function retrieves the ID as determined at discovery time, and does not
 * perform any further RF communication or block.
 * @return ID as byte array, never null
 * @apiSince 10
 */

public byte[] getId() { throw new RuntimeException("Stub!"); }

/**
 * Get the technologies available in this tag, as fully qualified class names.
 * <p>
 * A technology is an implementation of the {@link android.nfc.tech.TagTechnology TagTechnology} interface,
 * and can be instantiated by calling the static <code>get(Tag)</code>
 * method on the implementation with this Tag. The {@link android.nfc.tech.TagTechnology TagTechnology}
 * object can then be used to perform advanced, technology-specific operations on a tag.
 * <p>
 * Android defines a mandatory set of technologies that must be correctly
 * enumerated by all Android NFC devices, and an optional
 * set of proprietary technologies.
 * See {@link android.nfc.tech.TagTechnology TagTechnology} for more details.
 * <p>
 * The ordering of the returned array is undefined and should not be relied upon.
 * @return an array of fully-qualified {@link android.nfc.tech.TagTechnology TagTechnology} class-names.
 * @apiSince 10
 */

public java.lang.String[] getTechList() { throw new RuntimeException("Stub!"); }

/**
 * Human-readable description of the tag, for debugging.
 * @apiSince 10
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 10 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 10 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 10 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.nfc.Tag> CREATOR;
static { CREATOR = null; }
}

