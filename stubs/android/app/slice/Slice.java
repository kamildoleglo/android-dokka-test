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

import android.net.Uri;

/**
 * A slice is a piece of app content and actions that can be surfaced outside of the app.
 *
 * <p>They are constructed using {@link android.app.slice.Slice.Builder Builder} in a tree structure
 * that provides the OS some information about how the content should be displayed.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Slice implements android.os.Parcelable {

/** @apiSince 28 */

protected Slice(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * @return The spec for this slice
 
 * This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.app.slice.SliceSpec getSpec() { throw new RuntimeException("Stub!"); }

/**
 * @return The Uri that this Slice represents.
 * @apiSince 28
 */

public android.net.Uri getUri() { throw new RuntimeException("Stub!"); }

/**
 * @return All child {@link android.app.slice.SliceItem SliceItem}s that this Slice contains.
 * @apiSince 28
 */

public java.util.List<android.app.slice.SliceItem> getItems() { throw new RuntimeException("Stub!"); }

/**
 * @return All hints associated with this Slice.
 
 * Value is {@link android.app.slice.Slice#HINT_TITLE}, {@link android.app.slice.Slice#HINT_LIST}, {@link android.app.slice.Slice#HINT_LIST_ITEM}, {@link android.app.slice.Slice#HINT_LARGE}, {@link android.app.slice.Slice#HINT_ACTIONS}, {@link android.app.slice.Slice#HINT_SELECTED}, {@link android.app.slice.Slice#HINT_NO_TINT}, {@link android.app.slice.Slice#HINT_SHORTCUT}, android.app.slice.Slice.HINT_TOGGLE, {@link android.app.slice.Slice#HINT_HORIZONTAL}, {@link android.app.slice.Slice#HINT_PARTIAL}, {@link android.app.slice.Slice#HINT_SEE_MORE}, {@link android.app.slice.Slice#HINT_KEYWORDS}, {@link android.app.slice.Slice#HINT_ERROR}, {@link android.app.slice.Slice#HINT_TTL}, {@link android.app.slice.Slice#HINT_LAST_UPDATED}, or {@link android.app.slice.Slice#HINT_PERMISSION_REQUEST}
 * @apiSince 28
 */

public java.util.List<java.lang.String> getHints() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the caller for this slice matters.
 * @see android.app.slice.Slice.Builder#setCallerNeeded
 * @apiSince 28
 */

public boolean isCallerNeeded() { throw new RuntimeException("Stub!"); }

/**
 * @hide
 * @return A string representation of this slice.
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.slice.Slice> CREATOR;
static { CREATOR = null; }

/**
 * Key to retrieve an extra added to an intent when the value of an input range is changed.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_RANGE_VALUE = "android.app.slice.extra.RANGE_VALUE";

/**
 * Key to retrieve an extra added to an intent when a control is changed.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_TOGGLE_STATE = "android.app.slice.extra.TOGGLE_STATE";

/**
 * Hint that this slice contains a number of actions that can be grouped together
 * in a sort of controls area of the UI.
 * @apiSince 28
 */

public static final java.lang.String HINT_ACTIONS = "actions";

/**
 * A hint to indicate that this slice represents an error.
 * @apiSince 28
 */

public static final java.lang.String HINT_ERROR = "error";

/**
 * Hint that list items within this slice or subslice would appear better
 * if organized horizontally.
 * @apiSince 28
 */

public static final java.lang.String HINT_HORIZONTAL = "horizontal";

/**
 * A hint to indicate that the contents of this subslice represent a list of keywords
 * related to the parent slice.
 * Expected to be on an item of format {@link android.app.slice.SliceItem#FORMAT_SLICE SliceItem#FORMAT_SLICE}.
 * @apiSince 28
 */

public static final java.lang.String HINT_KEYWORDS = "keywords";

/**
 * Hint that this content is important and should be larger when displayed if
 * possible.
 * @apiSince 28
 */

public static final java.lang.String HINT_LARGE = "large";

/**
 * Hint indicating an item representing when the content was created or last updated.
 * @apiSince 28
 */

public static final java.lang.String HINT_LAST_UPDATED = "last_updated";

/**
 * Hint that all sub-items/sub-slices within this content should be considered
 * to have {@link #HINT_LIST_ITEM}.
 * @apiSince 28
 */

public static final java.lang.String HINT_LIST = "list";

/**
 * Hint that this item is part of a list and should be formatted as if is part
 * of a list.
 * @apiSince 28
 */

public static final java.lang.String HINT_LIST_ITEM = "list_item";

/**
 * Hint to indicate that this content should not be tinted.
 * @apiSince 28
 */

public static final java.lang.String HINT_NO_TINT = "no_tint";

/**
 * Hint to indicate that this slice is incomplete and an update will be sent once
 * loading is complete. Slices which contain HINT_PARTIAL will not be cached by the
 * OS and should not be cached by apps.
 * @apiSince 28
 */

public static final java.lang.String HINT_PARTIAL = "partial";

/**
 * A hint to indicate that this slice represents a permission request for showing
 * slices.
 * @apiSince 28
 */

public static final java.lang.String HINT_PERMISSION_REQUEST = "permission_request";

/**
 * A hint representing that this item should be used to indicate that there's more
 * content associated with this slice.
 * @apiSince 28
 */

public static final java.lang.String HINT_SEE_MORE = "see_more";

/**
 * Hint indicating that this item (and its sub-items) are the current selection.
 * @apiSince 28
 */

public static final java.lang.String HINT_SELECTED = "selected";

/**
 * Hint to indicate that this content should only be displayed if the slice is presented
 * as a shortcut.
 * @apiSince 28
 */

public static final java.lang.String HINT_SHORTCUT = "shortcut";

/**
 * Hint indicating this content should be shown instead of the normal content when the slice
 * is in small format.
 * @apiSince 28
 */

public static final java.lang.String HINT_SUMMARY = "summary";

/**
 * Hint that this content is a title of other content in the slice. This can also indicate that
 * the content should be used in the shortcut representation of the slice (icon, label, action),
 * normally this should be indicated by adding the hint on the action containing that content.
 *
 * @see android.app.slice.SliceItem#FORMAT_ACTION
 * @apiSince 28
 */

public static final java.lang.String HINT_TITLE = "title";

/**
 * Hint indicating an item representing a time-to-live for the content.
 * @apiSince 28
 */

public static final java.lang.String HINT_TTL = "ttl";

/**
 * Subtype to tag an item as representing a color.
 * Expected to be on an item of format {@link android.app.slice.SliceItem#FORMAT_INT SliceItem#FORMAT_INT}.
 * @apiSince 28
 */

public static final java.lang.String SUBTYPE_COLOR = "color";

/**
 * Subtype to tag an item to use as a content description.
 * Expected to be on an item of format {@link android.app.slice.SliceItem#FORMAT_TEXT SliceItem#FORMAT_TEXT}.
 * @apiSince 28
 */

public static final java.lang.String SUBTYPE_CONTENT_DESCRIPTION = "content_description";

/**
 * Subtype to indicate that this item indicates the layout direction for content
 * in the slice.
 * Expected to be an item of format {@link android.app.slice.SliceItem#FORMAT_INT SliceItem#FORMAT_INT}.
 * @apiSince 28
 */

public static final java.lang.String SUBTYPE_LAYOUT_DIRECTION = "layout_direction";

/**
 * Subtype to tag an item as representing the max int value for a {@link #SUBTYPE_RANGE}.
 * Expected to be on an item of format {@link android.app.slice.SliceItem#FORMAT_INT SliceItem#FORMAT_INT}.
 * @apiSince 28
 */

public static final java.lang.String SUBTYPE_MAX = "max";

/**
 * Subtype to indicate that this is a message as part of a communication
 * sequence in this slice.
 * Expected to be on an item of format {@link android.app.slice.SliceItem#FORMAT_SLICE SliceItem#FORMAT_SLICE}.
 * @apiSince 28
 */

public static final java.lang.String SUBTYPE_MESSAGE = "message";

/**
 * Subtype to tag an item as representing a time in milliseconds since midnight,
 * January 1, 1970 UTC.
 * @apiSince 28
 */

public static final java.lang.String SUBTYPE_MILLIS = "millis";

/**
 * Subtype to tag an item representing priority.
 * Expected to be on an item of format {@link android.app.slice.SliceItem#FORMAT_INT SliceItem#FORMAT_INT}.
 * @apiSince 28
 */

public static final java.lang.String SUBTYPE_PRIORITY = "priority";

/**
 * Subtype to tag an item as representing a range.
 * Expected to be on an item of format {@link android.app.slice.SliceItem#FORMAT_SLICE SliceItem#FORMAT_SLICE} containing
 * a {@link #SUBTYPE_VALUE} and possibly a {@link #SUBTYPE_MAX}.
 * @apiSince 28
 */

public static final java.lang.String SUBTYPE_RANGE = "range";

/**
 * Subtype to tag the source (i.e. sender) of a {@link #SUBTYPE_MESSAGE}.
 * Expected to be on an item of format {@link android.app.slice.SliceItem#FORMAT_TEXT SliceItem#FORMAT_TEXT},
 * {@link android.app.slice.SliceItem#FORMAT_IMAGE SliceItem#FORMAT_IMAGE} or an {@link android.app.slice.SliceItem#FORMAT_SLICE SliceItem#FORMAT_SLICE} containing them.
 * @apiSince 28
 */

public static final java.lang.String SUBTYPE_SOURCE = "source";

/**
 * Subtype to indicate that this content has a toggle action associated with it. To indicate
 * that the toggle is on, use {@link #HINT_SELECTED}. When the toggle state changes, the
 * intent associated with it will be sent along with an extra {@link #EXTRA_TOGGLE_STATE}
 * which can be retrieved to see the new state of the toggle.
 * @apiSince 28
 */

public static final java.lang.String SUBTYPE_TOGGLE = "toggle";

/**
 * Subtype to tag an item as representing the current int value for a {@link #SUBTYPE_RANGE}.
 * Expected to be on an item of format {@link android.app.slice.SliceItem#FORMAT_INT SliceItem#FORMAT_INT}.
 * @apiSince 28
 */

public static final java.lang.String SUBTYPE_VALUE = "value";
/**
 * A Builder used to construct {@link android.app.slice.Slice Slice}s
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Create a builder which will construct a {@link android.app.slice.Slice Slice} for the given Uri.
 * @param uri Uri to tag for this slice.
 * This value must never be {@code null}.
 * @param spec the spec for this slice.
 * @apiSince 28
 */

public Builder(@androidx.annotation.NonNull android.net.Uri uri, android.app.slice.SliceSpec spec) { throw new RuntimeException("Stub!"); }

/**
 * Create a builder for a {@link android.app.slice.Slice Slice} that is a sub-slice of the slice
 * being constructed by the provided builder.
 * @param parent The builder constructing the parent slice
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public Builder(@androidx.annotation.NonNull android.app.slice.Slice.Builder parent) { throw new RuntimeException("Stub!"); }

/**
 * Tells the system whether for this slice the return value of
 * {@link android.app.slice.SliceProvider#onBindSlice(android.net.Uri,java.util.Set) SliceProvider#onBindSlice(Uri, java.util.Set)} may be different depending on
 * {@link android.app.slice.SliceProvider#getCallingPackage() SliceProvider#getCallingPackage()} and should not be cached for multiple
 * apps.
 * @apiSince 28
 */

public android.app.slice.Slice.Builder setCallerNeeded(boolean callerNeeded) { throw new RuntimeException("Stub!"); }

/**
 * Add hints to the Slice being constructed
 
 * @param hints Value is {@link android.app.slice.Slice#HINT_TITLE}, {@link android.app.slice.Slice#HINT_LIST}, {@link android.app.slice.Slice#HINT_LIST_ITEM}, {@link android.app.slice.Slice#HINT_LARGE}, {@link android.app.slice.Slice#HINT_ACTIONS}, {@link android.app.slice.Slice#HINT_SELECTED}, {@link android.app.slice.Slice#HINT_NO_TINT}, {@link android.app.slice.Slice#HINT_SHORTCUT}, android.app.slice.Slice.HINT_TOGGLE, {@link android.app.slice.Slice#HINT_HORIZONTAL}, {@link android.app.slice.Slice#HINT_PARTIAL}, {@link android.app.slice.Slice#HINT_SEE_MORE}, {@link android.app.slice.Slice#HINT_KEYWORDS}, {@link android.app.slice.Slice#HINT_ERROR}, {@link android.app.slice.Slice#HINT_TTL}, {@link android.app.slice.Slice#HINT_LAST_UPDATED}, or {@link android.app.slice.Slice#HINT_PERMISSION_REQUEST}
 * @apiSince 28
 */

public android.app.slice.Slice.Builder addHints(java.util.List<java.lang.String> hints) { throw new RuntimeException("Stub!"); }

/**
 * Add a sub-slice to the slice being constructed
 * @param subType Optional template-specific type information
 * This value may be {@code null}.
 * Value is {@link android.app.slice.Slice#SUBTYPE_COLOR}, {@link android.app.slice.Slice#SUBTYPE_CONTENT_DESCRIPTION}, {@link android.app.slice.Slice#SUBTYPE_MAX}, {@link android.app.slice.Slice#SUBTYPE_MESSAGE}, {@link android.app.slice.Slice#SUBTYPE_PRIORITY}, {@link android.app.slice.Slice#SUBTYPE_RANGE}, {@link android.app.slice.Slice#SUBTYPE_SOURCE}, {@link android.app.slice.Slice#SUBTYPE_TOGGLE}, {@link android.app.slice.Slice#SUBTYPE_VALUE}, or {@link android.app.slice.Slice#SUBTYPE_LAYOUT_DIRECTION}
 * @see android.app.slice.SliceItem#getSubType()
 
 * @param slice This value must never be {@code null}.
 * @apiSince 28
 */

public android.app.slice.Slice.Builder addSubSlice(@androidx.annotation.NonNull android.app.slice.Slice slice, @androidx.annotation.Nullable java.lang.String subType) { throw new RuntimeException("Stub!"); }

/**
 * Add an action to the slice being constructed
 * @param subType Optional template-specific type information
 * This value may be {@code null}.
 * Value is {@link android.app.slice.Slice#SUBTYPE_COLOR}, {@link android.app.slice.Slice#SUBTYPE_CONTENT_DESCRIPTION}, {@link android.app.slice.Slice#SUBTYPE_MAX}, {@link android.app.slice.Slice#SUBTYPE_MESSAGE}, {@link android.app.slice.Slice#SUBTYPE_PRIORITY}, {@link android.app.slice.Slice#SUBTYPE_RANGE}, {@link android.app.slice.Slice#SUBTYPE_SOURCE}, {@link android.app.slice.Slice#SUBTYPE_TOGGLE}, {@link android.app.slice.Slice#SUBTYPE_VALUE}, or {@link android.app.slice.Slice#SUBTYPE_LAYOUT_DIRECTION}
 * @see android.app.slice.SliceItem#getSubType()
 
 * @param action This value must never be {@code null}.
 
 * @param s This value must never be {@code null}.
 * @apiSince 28
 */

public android.app.slice.Slice.Builder addAction(@androidx.annotation.NonNull android.app.PendingIntent action, @androidx.annotation.NonNull android.app.slice.Slice s, @androidx.annotation.Nullable java.lang.String subType) { throw new RuntimeException("Stub!"); }

/**
 * Add text to the slice being constructed
 * @param subType Optional template-specific type information
 * This value may be {@code null}.
 * Value is {@link android.app.slice.Slice#SUBTYPE_COLOR}, {@link android.app.slice.Slice#SUBTYPE_CONTENT_DESCRIPTION}, {@link android.app.slice.Slice#SUBTYPE_MAX}, {@link android.app.slice.Slice#SUBTYPE_MESSAGE}, {@link android.app.slice.Slice#SUBTYPE_PRIORITY}, {@link android.app.slice.Slice#SUBTYPE_RANGE}, {@link android.app.slice.Slice#SUBTYPE_SOURCE}, {@link android.app.slice.Slice#SUBTYPE_TOGGLE}, {@link android.app.slice.Slice#SUBTYPE_VALUE}, or {@link android.app.slice.Slice#SUBTYPE_LAYOUT_DIRECTION}
 * @see android.app.slice.SliceItem#getSubType()
 
 * @param hints Value is {@link android.app.slice.Slice#HINT_TITLE}, {@link android.app.slice.Slice#HINT_LIST}, {@link android.app.slice.Slice#HINT_LIST_ITEM}, {@link android.app.slice.Slice#HINT_LARGE}, {@link android.app.slice.Slice#HINT_ACTIONS}, {@link android.app.slice.Slice#HINT_SELECTED}, {@link android.app.slice.Slice#HINT_NO_TINT}, {@link android.app.slice.Slice#HINT_SHORTCUT}, android.app.slice.Slice.HINT_TOGGLE, {@link android.app.slice.Slice#HINT_HORIZONTAL}, {@link android.app.slice.Slice#HINT_PARTIAL}, {@link android.app.slice.Slice#HINT_SEE_MORE}, {@link android.app.slice.Slice#HINT_KEYWORDS}, {@link android.app.slice.Slice#HINT_ERROR}, {@link android.app.slice.Slice#HINT_TTL}, {@link android.app.slice.Slice#HINT_LAST_UPDATED}, or {@link android.app.slice.Slice#HINT_PERMISSION_REQUEST}
 * @apiSince 28
 */

public android.app.slice.Slice.Builder addText(java.lang.CharSequence text, @androidx.annotation.Nullable java.lang.String subType, java.util.List<java.lang.String> hints) { throw new RuntimeException("Stub!"); }

/**
 * Add an image to the slice being constructed
 * @param subType Optional template-specific type information
 * This value may be {@code null}.
 * Value is {@link android.app.slice.Slice#SUBTYPE_COLOR}, {@link android.app.slice.Slice#SUBTYPE_CONTENT_DESCRIPTION}, {@link android.app.slice.Slice#SUBTYPE_MAX}, {@link android.app.slice.Slice#SUBTYPE_MESSAGE}, {@link android.app.slice.Slice#SUBTYPE_PRIORITY}, {@link android.app.slice.Slice#SUBTYPE_RANGE}, {@link android.app.slice.Slice#SUBTYPE_SOURCE}, {@link android.app.slice.Slice#SUBTYPE_TOGGLE}, {@link android.app.slice.Slice#SUBTYPE_VALUE}, or {@link android.app.slice.Slice#SUBTYPE_LAYOUT_DIRECTION}
 * @see android.app.slice.SliceItem#getSubType()
 
 * @param hints Value is {@link android.app.slice.Slice#HINT_TITLE}, {@link android.app.slice.Slice#HINT_LIST}, {@link android.app.slice.Slice#HINT_LIST_ITEM}, {@link android.app.slice.Slice#HINT_LARGE}, {@link android.app.slice.Slice#HINT_ACTIONS}, {@link android.app.slice.Slice#HINT_SELECTED}, {@link android.app.slice.Slice#HINT_NO_TINT}, {@link android.app.slice.Slice#HINT_SHORTCUT}, android.app.slice.Slice.HINT_TOGGLE, {@link android.app.slice.Slice#HINT_HORIZONTAL}, {@link android.app.slice.Slice#HINT_PARTIAL}, {@link android.app.slice.Slice#HINT_SEE_MORE}, {@link android.app.slice.Slice#HINT_KEYWORDS}, {@link android.app.slice.Slice#HINT_ERROR}, {@link android.app.slice.Slice#HINT_TTL}, {@link android.app.slice.Slice#HINT_LAST_UPDATED}, or {@link android.app.slice.Slice#HINT_PERMISSION_REQUEST}
 * @apiSince 28
 */

public android.app.slice.Slice.Builder addIcon(android.graphics.drawable.Icon icon, @androidx.annotation.Nullable java.lang.String subType, java.util.List<java.lang.String> hints) { throw new RuntimeException("Stub!"); }

/**
 * Add remote input to the slice being constructed
 * @param subType Optional template-specific type information
 * This value may be {@code null}.
 * Value is {@link android.app.slice.Slice#SUBTYPE_COLOR}, {@link android.app.slice.Slice#SUBTYPE_CONTENT_DESCRIPTION}, {@link android.app.slice.Slice#SUBTYPE_MAX}, {@link android.app.slice.Slice#SUBTYPE_MESSAGE}, {@link android.app.slice.Slice#SUBTYPE_PRIORITY}, {@link android.app.slice.Slice#SUBTYPE_RANGE}, {@link android.app.slice.Slice#SUBTYPE_SOURCE}, {@link android.app.slice.Slice#SUBTYPE_TOGGLE}, {@link android.app.slice.Slice#SUBTYPE_VALUE}, or {@link android.app.slice.Slice#SUBTYPE_LAYOUT_DIRECTION}
 * @see android.app.slice.SliceItem#getSubType()
 
 * @param hints Value is {@link android.app.slice.Slice#HINT_TITLE}, {@link android.app.slice.Slice#HINT_LIST}, {@link android.app.slice.Slice#HINT_LIST_ITEM}, {@link android.app.slice.Slice#HINT_LARGE}, {@link android.app.slice.Slice#HINT_ACTIONS}, {@link android.app.slice.Slice#HINT_SELECTED}, {@link android.app.slice.Slice#HINT_NO_TINT}, {@link android.app.slice.Slice#HINT_SHORTCUT}, android.app.slice.Slice.HINT_TOGGLE, {@link android.app.slice.Slice#HINT_HORIZONTAL}, {@link android.app.slice.Slice#HINT_PARTIAL}, {@link android.app.slice.Slice#HINT_SEE_MORE}, {@link android.app.slice.Slice#HINT_KEYWORDS}, {@link android.app.slice.Slice#HINT_ERROR}, {@link android.app.slice.Slice#HINT_TTL}, {@link android.app.slice.Slice#HINT_LAST_UPDATED}, or {@link android.app.slice.Slice#HINT_PERMISSION_REQUEST}
 * @apiSince 28
 */

public android.app.slice.Slice.Builder addRemoteInput(android.app.RemoteInput remoteInput, @androidx.annotation.Nullable java.lang.String subType, java.util.List<java.lang.String> hints) { throw new RuntimeException("Stub!"); }

/**
 * Add an integer to the slice being constructed
 * @param subType Optional template-specific type information
 * This value may be {@code null}.
 * Value is {@link android.app.slice.Slice#SUBTYPE_COLOR}, {@link android.app.slice.Slice#SUBTYPE_CONTENT_DESCRIPTION}, {@link android.app.slice.Slice#SUBTYPE_MAX}, {@link android.app.slice.Slice#SUBTYPE_MESSAGE}, {@link android.app.slice.Slice#SUBTYPE_PRIORITY}, {@link android.app.slice.Slice#SUBTYPE_RANGE}, {@link android.app.slice.Slice#SUBTYPE_SOURCE}, {@link android.app.slice.Slice#SUBTYPE_TOGGLE}, {@link android.app.slice.Slice#SUBTYPE_VALUE}, or {@link android.app.slice.Slice#SUBTYPE_LAYOUT_DIRECTION}
 * @see android.app.slice.SliceItem#getSubType()
 
 * @param hints Value is {@link android.app.slice.Slice#HINT_TITLE}, {@link android.app.slice.Slice#HINT_LIST}, {@link android.app.slice.Slice#HINT_LIST_ITEM}, {@link android.app.slice.Slice#HINT_LARGE}, {@link android.app.slice.Slice#HINT_ACTIONS}, {@link android.app.slice.Slice#HINT_SELECTED}, {@link android.app.slice.Slice#HINT_NO_TINT}, {@link android.app.slice.Slice#HINT_SHORTCUT}, android.app.slice.Slice.HINT_TOGGLE, {@link android.app.slice.Slice#HINT_HORIZONTAL}, {@link android.app.slice.Slice#HINT_PARTIAL}, {@link android.app.slice.Slice#HINT_SEE_MORE}, {@link android.app.slice.Slice#HINT_KEYWORDS}, {@link android.app.slice.Slice#HINT_ERROR}, {@link android.app.slice.Slice#HINT_TTL}, {@link android.app.slice.Slice#HINT_LAST_UPDATED}, or {@link android.app.slice.Slice#HINT_PERMISSION_REQUEST}
 * @apiSince 28
 */

public android.app.slice.Slice.Builder addInt(int value, @androidx.annotation.Nullable java.lang.String subType, java.util.List<java.lang.String> hints) { throw new RuntimeException("Stub!"); }

/**
 * Add a long to the slice being constructed
 * @param subType Optional template-specific type information
 * This value may be {@code null}.
 * Value is {@link android.app.slice.Slice#SUBTYPE_COLOR}, {@link android.app.slice.Slice#SUBTYPE_CONTENT_DESCRIPTION}, {@link android.app.slice.Slice#SUBTYPE_MAX}, {@link android.app.slice.Slice#SUBTYPE_MESSAGE}, {@link android.app.slice.Slice#SUBTYPE_PRIORITY}, {@link android.app.slice.Slice#SUBTYPE_RANGE}, {@link android.app.slice.Slice#SUBTYPE_SOURCE}, {@link android.app.slice.Slice#SUBTYPE_TOGGLE}, {@link android.app.slice.Slice#SUBTYPE_VALUE}, or {@link android.app.slice.Slice#SUBTYPE_LAYOUT_DIRECTION}
 * @see android.app.slice.SliceItem#getSubType()
 
 * @param hints Value is {@link android.app.slice.Slice#HINT_TITLE}, {@link android.app.slice.Slice#HINT_LIST}, {@link android.app.slice.Slice#HINT_LIST_ITEM}, {@link android.app.slice.Slice#HINT_LARGE}, {@link android.app.slice.Slice#HINT_ACTIONS}, {@link android.app.slice.Slice#HINT_SELECTED}, {@link android.app.slice.Slice#HINT_NO_TINT}, {@link android.app.slice.Slice#HINT_SHORTCUT}, android.app.slice.Slice.HINT_TOGGLE, {@link android.app.slice.Slice#HINT_HORIZONTAL}, {@link android.app.slice.Slice#HINT_PARTIAL}, {@link android.app.slice.Slice#HINT_SEE_MORE}, {@link android.app.slice.Slice#HINT_KEYWORDS}, {@link android.app.slice.Slice#HINT_ERROR}, {@link android.app.slice.Slice#HINT_TTL}, {@link android.app.slice.Slice#HINT_LAST_UPDATED}, or {@link android.app.slice.Slice#HINT_PERMISSION_REQUEST}
 * @apiSince 28
 */

public android.app.slice.Slice.Builder addLong(long value, @androidx.annotation.Nullable java.lang.String subType, java.util.List<java.lang.String> hints) { throw new RuntimeException("Stub!"); }

/**
 * Add a bundle to the slice being constructed.
 * <p>Expected to be used for support library extension, should not be used for general
 * development
 * @param subType Optional template-specific type information
 * This value may be {@code null}.
 * Value is {@link android.app.slice.Slice#SUBTYPE_COLOR}, {@link android.app.slice.Slice#SUBTYPE_CONTENT_DESCRIPTION}, {@link android.app.slice.Slice#SUBTYPE_MAX}, {@link android.app.slice.Slice#SUBTYPE_MESSAGE}, {@link android.app.slice.Slice#SUBTYPE_PRIORITY}, {@link android.app.slice.Slice#SUBTYPE_RANGE}, {@link android.app.slice.Slice#SUBTYPE_SOURCE}, {@link android.app.slice.Slice#SUBTYPE_TOGGLE}, {@link android.app.slice.Slice#SUBTYPE_VALUE}, or {@link android.app.slice.Slice#SUBTYPE_LAYOUT_DIRECTION}
 * @see android.app.slice.SliceItem#getSubType()
 
 * @param hints Value is {@link android.app.slice.Slice#HINT_TITLE}, {@link android.app.slice.Slice#HINT_LIST}, {@link android.app.slice.Slice#HINT_LIST_ITEM}, {@link android.app.slice.Slice#HINT_LARGE}, {@link android.app.slice.Slice#HINT_ACTIONS}, {@link android.app.slice.Slice#HINT_SELECTED}, {@link android.app.slice.Slice#HINT_NO_TINT}, {@link android.app.slice.Slice#HINT_SHORTCUT}, android.app.slice.Slice.HINT_TOGGLE, {@link android.app.slice.Slice#HINT_HORIZONTAL}, {@link android.app.slice.Slice#HINT_PARTIAL}, {@link android.app.slice.Slice#HINT_SEE_MORE}, {@link android.app.slice.Slice#HINT_KEYWORDS}, {@link android.app.slice.Slice#HINT_ERROR}, {@link android.app.slice.Slice#HINT_TTL}, {@link android.app.slice.Slice#HINT_LAST_UPDATED}, or {@link android.app.slice.Slice#HINT_PERMISSION_REQUEST}
 * @apiSince 28
 */

public android.app.slice.Slice.Builder addBundle(android.os.Bundle bundle, @androidx.annotation.Nullable java.lang.String subType, java.util.List<java.lang.String> hints) { throw new RuntimeException("Stub!"); }

/**
 * Construct the slice.
 * @apiSince 28
 */

public android.app.slice.Slice build() { throw new RuntimeException("Stub!"); }
}

}

