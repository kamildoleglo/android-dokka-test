/**
 * Copyright (c) 2010, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.content;

import android.os.PersistableBundle;

/**
 * Meta-data describing the contents of a {@link android.content.ClipData ClipData}.  Provides enough
 * information to know if you can handle the ClipData, but not the data
 * itself.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using the clipboard framework, read the
 * <a href="{@docRoot}guide/topics/clipboard/copy-paste.html">Copy and Paste</a>
 * developer guide.</p>
 * </div>
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ClipDescription implements android.os.Parcelable {

/**
 * Create a new clip.
 *
 * @param label Label to show to the user describing this clip.
 * @param mimeTypes An array of MIME types this data is available as.
 * @apiSince 11
 */

public ClipDescription(java.lang.CharSequence label, java.lang.String[] mimeTypes) { throw new RuntimeException("Stub!"); }

/**
 * Create a copy of a ClipDescription.
 * @apiSince 11
 */

public ClipDescription(android.content.ClipDescription o) { throw new RuntimeException("Stub!"); }

/**
 * Helper to compare two MIME types, where one may be a pattern.
 * @param concreteType A fully-specified MIME type.
 * @param desiredType A desired MIME type that may be a pattern such as *&#47;*.
 * @return Returns true if the two MIME types match.
 * @apiSince 11
 */

public static boolean compareMimeTypes(java.lang.String concreteType, java.lang.String desiredType) { throw new RuntimeException("Stub!"); }

/**
 * Return the timestamp at which the associated {@link android.content.ClipData ClipData} is copied to global clipboard
 * in the {@link java.lang.System#currentTimeMillis() System#currentTimeMillis()} time base.
 *
 * @return timestamp at which the associated {@link android.content.ClipData ClipData} is copied to global clipboard
 *         or {@code 0} if it is not copied to clipboard.
 * @apiSince 26
 */

public long getTimestamp() { throw new RuntimeException("Stub!"); }

/**
 * Return the label for this clip.
 * @apiSince 11
 */

public java.lang.CharSequence getLabel() { throw new RuntimeException("Stub!"); }

/**
 * Check whether the clip description contains the given MIME type.
 *
 * @param mimeType The desired MIME type.  May be a pattern.
 * @return Returns true if one of the MIME types in the clip description
 * matches the desired MIME type, else false.
 * @apiSince 11
 */

public boolean hasMimeType(java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Filter the clip description MIME types by the given MIME type.  Returns
 * all MIME types in the clip that match the given MIME type.
 *
 * @param mimeType The desired MIME type.  May be a pattern.
 * @return Returns an array of all matching MIME types.  If there are no
 * matching MIME types, null is returned.
 * @apiSince 11
 */

public java.lang.String[] filterMimeTypes(java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of MIME types the clip is available in.
 * @apiSince 11
 */

public int getMimeTypeCount() { throw new RuntimeException("Stub!"); }

/**
 * Return one of the possible clip MIME types.
 * @apiSince 11
 */

public java.lang.String getMimeType(int index) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve extended data from the clip description.
 *
 * @return the bundle containing extended data previously set with
 * {@link #setExtras(android.os.PersistableBundle)}, or null if no extras have been set.
 *
 * @see #setExtras(PersistableBundle)
 * @apiSince 24
 */

public android.os.PersistableBundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Add extended data to the clip description.
 *
 * @see #getExtras()
 * @apiSince 24
 */

public void setExtras(android.os.PersistableBundle extras) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.ClipDescription> CREATOR;
static { CREATOR = null; }

/**
 * The MIME type for a clip holding HTML text.
 * @apiSince 16
 */

public static final java.lang.String MIMETYPE_TEXT_HTML = "text/html";

/**
 * The MIME type for a clip holding an Intent.
 * @apiSince 11
 */

public static final java.lang.String MIMETYPE_TEXT_INTENT = "text/vnd.android.intent";

/**
 * The MIME type for a clip holding plain text.
 * @apiSince 11
 */

public static final java.lang.String MIMETYPE_TEXT_PLAIN = "text/plain";

/**
 * The MIME type for a clip holding one or more URIs.  This should be
 * used for URIs that are meaningful to a user (such as an http: URI).
 * It should <em>not</em> be used for a content: URI that references some
 * other piece of data; in that case the MIME type should be the type
 * of the referenced data.
 * @apiSince 11
 */

public static final java.lang.String MIMETYPE_TEXT_URILIST = "text/uri-list";
}

