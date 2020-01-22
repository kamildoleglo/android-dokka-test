/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.view.accessibility;


/**
 * This class represents a state snapshot of a window for accessibility
 * purposes. The screen content contains one or more windows where some
 * windows can be descendants of other windows, which is the windows are
 * hierarchically ordered. Note that there is no root window. Hence, the
 * screen content can be seen as a collection of window trees.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AccessibilityWindowInfo implements android.os.Parcelable {

AccessibilityWindowInfo() { throw new RuntimeException("Stub!"); }

/**
 * Gets the title of the window.
 *
 * @return The title of the window, or {@code null} if none is available.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getTitle() { throw new RuntimeException("Stub!"); }

/**
 * Gets the type of the window.
 *
 * @return The type.
 *
 * @see #TYPE_APPLICATION
 * @see #TYPE_INPUT_METHOD
 * @see #TYPE_SYSTEM
 * @see #TYPE_ACCESSIBILITY_OVERLAY
 * @apiSince 21
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Gets the layer which determines the Z-order of the window. Windows
 * with greater layer appear on top of windows with lesser layer.
 *
 * @return The window layer.
 * @apiSince 21
 */

public int getLayer() { throw new RuntimeException("Stub!"); }

/**
 * Gets the root node in the window's hierarchy.
 *
 * @return The root node.
 * @apiSince 21
 */

public android.view.accessibility.AccessibilityNodeInfo getRoot() { throw new RuntimeException("Stub!"); }

/**
 * Gets the node that anchors this window to another.
 *
 * @return The anchor node, or {@code null} if none exists.
 * @apiSince 24
 */

public android.view.accessibility.AccessibilityNodeInfo getAnchor() { throw new RuntimeException("Stub!"); }

/**
 * Check if the window is in picture-in-picture mode.
 *
 * @return {@code true} if the window is in picture-in-picture mode, {@code false} otherwise.
 * @apiSince 26
 */

public boolean isInPictureInPictureMode() { throw new RuntimeException("Stub!"); }

/**
 * Gets the parent window.
 *
 * @return The parent window, or {@code null} if none exists.
 * @apiSince 21
 */

public android.view.accessibility.AccessibilityWindowInfo getParent() { throw new RuntimeException("Stub!"); }

/**
 * Gets the unique window id.
 *
 * @return windowId The window id.
 * @apiSince 21
 */

public int getId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the bounds of this window in the screen.
 *
 * @param outBounds The out window bounds.
 * @apiSince 21
 */

public void getBoundsInScreen(android.graphics.Rect outBounds) { throw new RuntimeException("Stub!"); }

/**
 * Gets if this window is active. An active window is the one
 * the user is currently touching or the window has input focus
 * and the user is not touching any window.
 *
 * @return Whether this is the active window.
 * @apiSince 21
 */

public boolean isActive() { throw new RuntimeException("Stub!"); }

/**
 * Gets if this window has input focus.
 *
 * @return Whether has input focus.
 * @apiSince 21
 */

public boolean isFocused() { throw new RuntimeException("Stub!"); }

/**
 * Gets if this window has accessibility focus.
 *
 * @return Whether has accessibility focus.
 * @apiSince 21
 */

public boolean isAccessibilityFocused() { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of child windows.
 *
 * @return The child count.
 * @apiSince 21
 */

public int getChildCount() { throw new RuntimeException("Stub!"); }

/**
 * Gets the child window at a given index.
 *
 * @param index The index.
 * @return The child.
 * @apiSince 21
 */

public android.view.accessibility.AccessibilityWindowInfo getChild(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns a cached instance if such is available or a new one is
 * created.
 *
 * @return An instance.
 * @apiSince 21
 */

public static android.view.accessibility.AccessibilityWindowInfo obtain() { throw new RuntimeException("Stub!"); }

/**
 * Returns a cached instance if such is available or a new one is
 * created. The returned instance is initialized from the given
 * <code>info</code>.
 *
 * @param info The other info.
 * @return An instance.
 * @apiSince 21
 */

public static android.view.accessibility.AccessibilityWindowInfo obtain(android.view.accessibility.AccessibilityWindowInfo info) { throw new RuntimeException("Stub!"); }

/**
 * Return an instance back to be reused.
 * <p>
 * <strong>Note:</strong> You must not touch the object after calling this function.
 * </p>
 *
 * @throws java.lang.IllegalStateException If the info is already recycled.
 * @apiSince 21
 */

public void recycle() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.accessibility.AccessibilityWindowInfo> CREATOR;
static { CREATOR = null; }

/**
 * Window type: Windows that are overlaid <em>only</em> by an {@link
 * android.accessibilityservice.AccessibilityService} for interception of
 * user interactions without changing the windows an accessibility service
 * can introspect. In particular, an accessibility service can introspect
 * only windows that a sighted user can interact with which they can touch
 * these windows or can type into these windows. For example, if there
 * is a full screen accessibility overlay that is touchable, the windows
 * below it will be introspectable by an accessibility service regardless
 * they are covered by a touchable window.
 * @apiSince 22
 */

public static final int TYPE_ACCESSIBILITY_OVERLAY = 4; // 0x4

/**
 * Window type: This is an application window. Such a window shows UI for
 * interacting with an application.
 * @apiSince 21
 */

public static final int TYPE_APPLICATION = 1; // 0x1

/**
 * Window type: This is an input method window. Such a window shows UI for
 * inputting text such as keyboard, suggestions, etc.
 * @apiSince 21
 */

public static final int TYPE_INPUT_METHOD = 2; // 0x2

/**
 * Window type: A system window used to divide the screen in split-screen mode.
 * This type of window is present only in split-screen mode.
 * @apiSince 24
 */

public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5; // 0x5

/**
 * Window type: This is an system window. Such a window shows UI for
 * interacting with the system.
 * @apiSince 21
 */

public static final int TYPE_SYSTEM = 3; // 0x3
}

