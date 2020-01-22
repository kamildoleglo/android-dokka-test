/*
 * Copyright (C) 2015 The Android Open Source Project
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

package android.service.quicksettings;


/**
 * A Tile holds the state of a tile that will be displayed
 * in Quick Settings.
 *
 * A tile in Quick Settings exists as an icon with an accompanied label.
 * It also may have content description for accessibility usability.
 * The style and layout of the tile may change to match a given
 * device.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Tile implements android.os.Parcelable {

Tile() { throw new RuntimeException("Stub!"); }

/**
 * The current state of the tile.
 *
 * @see #STATE_UNAVAILABLE
 * @see #STATE_INACTIVE
 * @see #STATE_ACTIVE
 * @apiSince 24
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Sets the current state for the tile.
 *
 * Does not take effect until {@link #updateTile()} is called.
 *
 * @param state One of {@link #STATE_UNAVAILABLE}, {@link #STATE_INACTIVE},
 * {@link #STATE_ACTIVE}
 * @apiSince 24
 */

public void setState(int state) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current icon for the tile.
 * @apiSince 24
 */

public android.graphics.drawable.Icon getIcon() { throw new RuntimeException("Stub!"); }

/**
 * Sets the current icon for the tile.
 *
 * This icon is expected to be white on alpha, and may be
 * tinted by the system to match it's theme.
 *
 * Does not take effect until {@link #updateTile()} is called.
 *
 * @param icon New icon to show.
 * @apiSince 24
 */

public void setIcon(android.graphics.drawable.Icon icon) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current label for the tile.
 * @apiSince 24
 */

public java.lang.CharSequence getLabel() { throw new RuntimeException("Stub!"); }

/**
 * Sets the current label for the tile.
 *
 * Does not take effect until {@link #updateTile()} is called.
 *
 * @param label New label to show.
 * @apiSince 24
 */

public void setLabel(java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current subtitle for the tile.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getSubtitle() { throw new RuntimeException("Stub!"); }

/**
 * Set the subtitle for the tile. Will be displayed as the secondary label.
 * @param subtitle the subtitle to show.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public void setSubtitle(@androidx.annotation.Nullable java.lang.CharSequence subtitle) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current content description for the tile.
 * @apiSince 24
 */

public java.lang.CharSequence getContentDescription() { throw new RuntimeException("Stub!"); }

/**
 * Sets the current content description for the tile.
 *
 * Does not take effect until {@link #updateTile()} is called.
 *
 * @param contentDescription New content description to use.
 * @apiSince 24
 */

public void setContentDescription(java.lang.CharSequence contentDescription) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Pushes the state of the Tile to Quick Settings to be displayed.
 * @apiSince 24
 */

public void updateTile() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.quicksettings.Tile> CREATOR;
static { CREATOR = null; }

/**
 * This represents a tile that is currently active. (e.g. wifi is connected, bluetooth is on,
 * cast is casting).  This is the default state.
 * @apiSince 24
 */

public static final int STATE_ACTIVE = 2; // 0x2

/**
 * This represents a tile that is currently in a disabled state but is still interactable.
 *
 * A disabled state indicates that the tile is not currently active (e.g. wifi disconnected or
 * bluetooth disabled), but is still interactable by the user to modify this state.  Tiles
 * that have boolean states should use this to represent one of their states.  The tile's
 * icon will be tinted differently to reflect this state, but still be distinct from unavailable.
 * @apiSince 24
 */

public static final int STATE_INACTIVE = 1; // 0x1

/**
 * An unavailable state indicates that for some reason this tile is not currently
 * available to the user for some reason, and will have no click action.  The tile's
 * icon will be tinted differently to reflect this state.
 * @apiSince 24
 */

public static final int STATE_UNAVAILABLE = 0; // 0x0
}

