/*
 * Copyright (C) 2011 The Android Open Source Project
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


package android.view;

import android.content.res.Resources;

/**
 * Represents an icon that can be used as a mouse pointer.
 * <p>
 * Pointer icons can be provided either by the system using system types,
 * or by applications using bitmaps or application resources.
 * </p>
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PointerIcon implements android.os.Parcelable {

private PointerIcon() { throw new RuntimeException("Stub!"); }

/**
 * Gets a system pointer icon for the given type.
 * If typeis not recognized, returns the default pointer icon.
 *
 * @param context The context.
 * This value must never be {@code null}.
 * @param type The pointer icon type.
 * @return The pointer icon.
 *
 * @throws java.lang.IllegalArgumentException if context is null.
 * @apiSince 24
 */

public static android.view.PointerIcon getSystemIcon(@androidx.annotation.NonNull android.content.Context context, int type) { throw new RuntimeException("Stub!"); }

/**
 * Creates a custom pointer icon from the given bitmap and hotspot information.
 *
 * @param bitmap The bitmap for the icon.
 * This value must never be {@code null}.
 * @param hotSpotX The X offset of the pointer icon hotspot in the bitmap.
 *        Must be within the [0, bitmap.getWidth()) range.
 * @param hotSpotY The Y offset of the pointer icon hotspot in the bitmap.
 *        Must be within the [0, bitmap.getHeight()) range.
 * @return A pointer icon for this bitmap.
 *
 * @throws java.lang.IllegalArgumentException if bitmap is null, or if the x/y hotspot
 *         parameters are invalid.
 * @apiSince 24
 */

public static android.view.PointerIcon create(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, float hotSpotX, float hotSpotY) { throw new RuntimeException("Stub!"); }

/**
 * Loads a custom pointer icon from an XML resource.
 * <p>
 * The XML resource should have the following form:
 * <code>
 * &lt;?xml version="1.0" encoding="utf-8"?&gt;
 * &lt;pointer-icon xmlns:android="http://schemas.android.com/apk/res/android"
 *   android:bitmap="@drawable/my_pointer_bitmap"
 *   android:hotSpotX="24"
 *   android:hotSpotY="24" /&gt;
 * </code>
 * </p>
 *
 * @param resources The resources object.
 * This value must never be {@code null}.
 * @param resourceId The resource id.
 * @return The pointer icon.
 *
 * @throws java.lang.IllegalArgumentException if resources is null.
 * @throws android.content.res.Resources.NotFoundException if the resource was not found or the drawable
 * linked in the resource was not found.
 * @apiSince 24
 */

public static android.view.PointerIcon load(@androidx.annotation.NonNull android.content.res.Resources resources, int resourceId) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.PointerIcon> CREATOR;
static { CREATOR = null; }

/** Type constant: alias (indicating an alias of/shortcut to something is
 * to be created.      * @apiSince 24
 */

public static final int TYPE_ALIAS = 1010; // 0x3f2

/**
 * Type constant: all-scroll.
 * @apiSince 24
 */

public static final int TYPE_ALL_SCROLL = 1013; // 0x3f5

/**
 * Type constant: Arrow icon.  (Default mouse pointer)
 * @apiSince 24
 */

public static final int TYPE_ARROW = 1000; // 0x3e8

/**
 * Type constant: cell.
 * @apiSince 24
 */

public static final int TYPE_CELL = 1006; // 0x3ee

/**
 * Type constant: context-menu.
 * @apiSince 24
 */

public static final int TYPE_CONTEXT_MENU = 1001; // 0x3e9

/**
 * Type constant: copy.
 * @apiSince 24
 */

public static final int TYPE_COPY = 1011; // 0x3f3

/**
 * Type constant: crosshair.
 * @apiSince 24
 */

public static final int TYPE_CROSSHAIR = 1007; // 0x3ef

/**
 * The default pointer icon.
 * @apiSince 24
 */

public static final int TYPE_DEFAULT = 1000; // 0x3e8

/**
 * Type constant: grab.
 * @apiSince 24
 */

public static final int TYPE_GRAB = 1020; // 0x3fc

/**
 * Type constant: grabbing.
 * @apiSince 24
 */

public static final int TYPE_GRABBING = 1021; // 0x3fd

/**
 * Type constant: hand.
 * @apiSince 24
 */

public static final int TYPE_HAND = 1002; // 0x3ea

/**
 * Type constant: help.
 * @apiSince 24
 */

public static final int TYPE_HELP = 1003; // 0x3eb

/**
 * Type constant: horizontal double arrow mainly for resizing.
 * @apiSince 24
 */

public static final int TYPE_HORIZONTAL_DOUBLE_ARROW = 1014; // 0x3f6

/**
 * Type constant: no-drop.
 * @apiSince 24
 */

public static final int TYPE_NO_DROP = 1012; // 0x3f4

/**
 * Type constant: Null icon.  It has no bitmap.
 * @apiSince 24
 */

public static final int TYPE_NULL = 0; // 0x0

/**
 * Type constant: text.
 * @apiSince 24
 */

public static final int TYPE_TEXT = 1008; // 0x3f0

/**
 * Type constant: diagonal double arrow -- top-left to bottom-right.
 * @apiSince 24
 */

public static final int TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW = 1017; // 0x3f9

/**
 * Type constant: diagonal double arrow -- top-right to bottom-left.
 * @apiSince 24
 */

public static final int TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW = 1016; // 0x3f8

/**
 * Type constant: vertical double arrow mainly for resizing.
 * @apiSince 24
 */

public static final int TYPE_VERTICAL_DOUBLE_ARROW = 1015; // 0x3f7

/**
 * Type constant: vertical-text.
 * @apiSince 24
 */

public static final int TYPE_VERTICAL_TEXT = 1009; // 0x3f1

/**
 * Type constant: wait.
 * @apiSince 24
 */

public static final int TYPE_WAIT = 1004; // 0x3ec

/**
 * Type constant: zoom-in.
 * @apiSince 24
 */

public static final int TYPE_ZOOM_IN = 1018; // 0x3fa

/**
 * Type constant: zoom-out.
 * @apiSince 24
 */

public static final int TYPE_ZOOM_OUT = 1019; // 0x3fb
}

