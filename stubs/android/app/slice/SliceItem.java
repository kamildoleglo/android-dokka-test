/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.app.slice;

import android.graphics.drawable.Icon;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.os.Bundle;

/**
 * A SliceItem is a single unit in the tree structure of a {@link android.app.slice.Slice Slice}.
 *
 * A SliceItem a piece of content and some hints about what that content
 * means or how it should be displayed. The types of content can be:
 * <li>{@link #FORMAT_SLICE}</li>
 * <li>{@link #FORMAT_TEXT}</li>
 * <li>{@link #FORMAT_IMAGE}</li>
 * <li>{@link #FORMAT_ACTION}</li>
 * <li>{@link #FORMAT_INT}</li>
 * <li>{@link #FORMAT_LONG}</li>
 * <li>{@link #FORMAT_REMOTE_INPUT}</li>
 * <li>{@link #FORMAT_BUNDLE}</li>
 *
 * The hints that a {@link android.app.slice.SliceItem SliceItem} are a set of strings which annotate
 * the content. The hints that are guaranteed to be understood by the system
 * are defined on {@link android.app.slice.Slice Slice}.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SliceItem implements android.os.Parcelable {

SliceItem() { throw new RuntimeException("Stub!"); }

/**
 * Gets all hints associated with this SliceItem.
 * @return Array of hints.
 
 * This value will never be {@code null}.
 
 * Value is {@link android.app.slice.Slice#HINT_TITLE}, {@link android.app.slice.Slice#HINT_LIST}, {@link android.app.slice.Slice#HINT_LIST_ITEM}, {@link android.app.slice.Slice#HINT_LARGE}, {@link android.app.slice.Slice#HINT_ACTIONS}, {@link android.app.slice.Slice#HINT_SELECTED}, {@link android.app.slice.Slice#HINT_NO_TINT}, {@link android.app.slice.Slice#HINT_SHORTCUT}, android.app.slice.Slice.HINT_TOGGLE, {@link android.app.slice.Slice#HINT_HORIZONTAL}, {@link android.app.slice.Slice#HINT_PARTIAL}, {@link android.app.slice.Slice#HINT_SEE_MORE}, {@link android.app.slice.Slice#HINT_KEYWORDS}, {@link android.app.slice.Slice#HINT_ERROR}, {@link android.app.slice.Slice#HINT_TTL}, {@link android.app.slice.Slice#HINT_LAST_UPDATED}, or {@link android.app.slice.Slice#HINT_PERMISSION_REQUEST}
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.String> getHints() { throw new RuntimeException("Stub!"); }

/**
 * Get the format of this SliceItem.
 * <p>
 * The format will be one of the following types supported by the platform:
 * <li>{@link #FORMAT_SLICE}</li>
 * <li>{@link #FORMAT_TEXT}</li>
 * <li>{@link #FORMAT_IMAGE}</li>
 * <li>{@link #FORMAT_ACTION}</li>
 * <li>{@link #FORMAT_INT}</li>
 * <li>{@link #FORMAT_LONG}</li>
 * <li>{@link #FORMAT_REMOTE_INPUT}</li>
 * <li>{@link #FORMAT_BUNDLE}</li>
 * @see #getSubType() ()
 * @apiSince 28
 */

public java.lang.String getFormat() { throw new RuntimeException("Stub!"); }

/**
 * Get the sub-type of this SliceItem.
 * <p>
 * Subtypes provide additional information about the type of this information beyond basic
 * interpretations inferred by {@link #getFormat()}. For example a slice may contain
 * many {@link #FORMAT_TEXT} items, but only some of them may be {@link android.app.slice.Slice#SUBTYPE_MESSAGE Slice#SUBTYPE_MESSAGE}.
 * @see #getFormat()
 * @apiSince 28
 */

public java.lang.String getSubType() { throw new RuntimeException("Stub!"); }

/**
 * @return The text held by this {@link #FORMAT_TEXT} SliceItem
 * @apiSince 28
 */

public java.lang.CharSequence getText() { throw new RuntimeException("Stub!"); }

/**
 * @return The parcelable held by this {@link #FORMAT_BUNDLE} SliceItem
 * @apiSince 28
 */

public android.os.Bundle getBundle() { throw new RuntimeException("Stub!"); }

/**
 * @return The icon held by this {@link #FORMAT_IMAGE} SliceItem
 * @apiSince 28
 */

public android.graphics.drawable.Icon getIcon() { throw new RuntimeException("Stub!"); }

/**
 * @return The pending intent held by this {@link #FORMAT_ACTION} SliceItem
 * @apiSince 28
 */

public android.app.PendingIntent getAction() { throw new RuntimeException("Stub!"); }

/**
 * @return The remote input held by this {@link #FORMAT_REMOTE_INPUT} SliceItem
 * @apiSince 28
 */

public android.app.RemoteInput getRemoteInput() { throw new RuntimeException("Stub!"); }

/**
 * @return The color held by this {@link #FORMAT_INT} SliceItem
 * @apiSince 28
 */

public int getInt() { throw new RuntimeException("Stub!"); }

/**
 * @return The slice held by this {@link #FORMAT_ACTION} or {@link #FORMAT_SLICE} SliceItem
 * @apiSince 28
 */

public android.app.slice.Slice getSlice() { throw new RuntimeException("Stub!"); }

/**
 * @return The long held by this {@link #FORMAT_LONG} SliceItem
 * @apiSince 28
 */

public long getLong() { throw new RuntimeException("Stub!"); }

/**
 * @param hint The hint to check for
 * Value is {@link android.app.slice.Slice#HINT_TITLE}, {@link android.app.slice.Slice#HINT_LIST}, {@link android.app.slice.Slice#HINT_LIST_ITEM}, {@link android.app.slice.Slice#HINT_LARGE}, {@link android.app.slice.Slice#HINT_ACTIONS}, {@link android.app.slice.Slice#HINT_SELECTED}, {@link android.app.slice.Slice#HINT_NO_TINT}, {@link android.app.slice.Slice#HINT_SHORTCUT}, android.app.slice.Slice.HINT_TOGGLE, {@link android.app.slice.Slice#HINT_HORIZONTAL}, {@link android.app.slice.Slice#HINT_PARTIAL}, {@link android.app.slice.Slice#HINT_SEE_MORE}, {@link android.app.slice.Slice#HINT_KEYWORDS}, {@link android.app.slice.Slice#HINT_ERROR}, {@link android.app.slice.Slice#HINT_TTL}, {@link android.app.slice.Slice#HINT_LAST_UPDATED}, or {@link android.app.slice.Slice#HINT_PERMISSION_REQUEST}
 * @return true if this item contains the given hint
 * @apiSince 28
 */

public boolean hasHint(java.lang.String hint) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.slice.SliceItem> CREATOR;
static { CREATOR = null; }

/**
 * A {@link android.app.slice.SliceItem SliceItem} that contains a {@link android.app.PendingIntent PendingIntent}
 *
 * Note: Actions contain 2 pieces of data, In addition to the pending intent, the
 * item contains a {@link android.app.slice.Slice Slice} that the action applies to.
 * @apiSince 28
 */

public static final java.lang.String FORMAT_ACTION = "action";

/**
 * A {@link android.app.slice.SliceItem SliceItem} that contains a {@link android.os.Bundle Bundle}.
 * @apiSince 28
 */

public static final java.lang.String FORMAT_BUNDLE = "bundle";

/**
 * A {@link android.app.slice.SliceItem SliceItem} that contains an {@link android.graphics.drawable.Icon Icon}
 * @apiSince 28
 */

public static final java.lang.String FORMAT_IMAGE = "image";

/**
 * A {@link android.app.slice.SliceItem SliceItem} that contains an int.
 * @apiSince 28
 */

public static final java.lang.String FORMAT_INT = "int";

/**
 * A {@link android.app.slice.SliceItem SliceItem} that contains a long.
 * @apiSince 28
 */

public static final java.lang.String FORMAT_LONG = "long";

/**
 * A {@link android.app.slice.SliceItem SliceItem} that contains a {@link android.app.RemoteInput RemoteInput}.
 * @apiSince 28
 */

public static final java.lang.String FORMAT_REMOTE_INPUT = "input";

/**
 * A {@link android.app.slice.SliceItem SliceItem} that contains a {@link android.app.slice.Slice Slice}
 * @apiSince 28
 */

public static final java.lang.String FORMAT_SLICE = "slice";

/**
 * A {@link android.app.slice.SliceItem SliceItem} that contains a {@link java.lang.CharSequence CharSequence}
 * @apiSince 28
 */

public static final java.lang.String FORMAT_TEXT = "text";
}

