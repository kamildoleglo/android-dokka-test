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

import android.app.Dialog;
import android.Manifest;
import android.content.Intent;
import android.content.ComponentName;
import android.app.Service;

/**
 * A TileService provides the user a tile that can be added to Quick Settings.
 * Quick Settings is a space provided that allows the user to change settings and
 * take quick actions without leaving the context of their current app.
 *
 * <p>The lifecycle of a TileService is different from some other services in
 * that it may be unbound during parts of its lifecycle.  Any of the following
 * lifecycle events can happen indepently in a separate binding/creation of the
 * service.</p>
 *
 * <ul>
 * <li>When a tile is added by the user its TileService will be bound to and
 * {@link #onTileAdded()} will be called.</li>
 *
 * <li>When a tile should be up to date and listing will be indicated by
 * {@link #onStartListening()} and {@link #onStopListening()}.</li>
 *
 * <li>When the user removes a tile from Quick Settings {@link #onTileRemoved()}
 * will be called.</li>
 * </ul>
 * <p>TileService will be detected by tiles that match the {@value #ACTION_QS_TILE}
 * and require the permission "android.permission.BIND_QUICK_SETTINGS_TILE".
 * The label and icon for the service will be used as the default label and
 * icon for the tile. Here is an example TileService declaration.</p>
 * <pre class="prettyprint">
 * {@literal
 * <service
 *     android:name=".MyQSTileService"
 *     android:label="@string/my_default_tile_label"
 *     android:icon="@drawable/my_default_icon_label"
 *     android:permission="android.permission.BIND_QUICK_SETTINGS_TILE">
 *     <intent-filter>
 *         <action android:name="android.service.quicksettings.action.QS_TILE" />
 *     </intent-filter>
 * </service>}
 * </pre>
 *
 * @see android.service.quicksettings.Tile Tile for details about the UI of a Quick Settings Tile.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TileService extends android.app.Service {

public TileService() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void onDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Called when the user adds this tile to Quick Settings.
 * <p/>
 * Note that this is not guaranteed to be called between {@link #onCreate()}
 * and {@link #onStartListening()}, it will only be called when the tile is added
 * and not on subsequent binds.
 * @apiSince 24
 */

public void onTileAdded() { throw new RuntimeException("Stub!"); }

/**
 * Called when the user removes this tile from Quick Settings.
 * @apiSince 24
 */

public void onTileRemoved() { throw new RuntimeException("Stub!"); }

/**
 * Called when this tile moves into a listening state.
 * <p/>
 * When this tile is in a listening state it is expected to keep the
 * UI up to date.  Any listeners or callbacks needed to keep this tile
 * up to date should be registered here and unregistered in {@link #onStopListening()}.
 *
 * @see #getQsTile()
 * @see android.service.quicksettings.Tile#updateTile()
 * @apiSince 24
 */

public void onStartListening() { throw new RuntimeException("Stub!"); }

/**
 * Called when this tile moves out of the listening state.
 * @apiSince 24
 */

public void onStopListening() { throw new RuntimeException("Stub!"); }

/**
 * Called when the user clicks on this tile.
 * @apiSince 24
 */

public void onClick() { throw new RuntimeException("Stub!"); }

/**
 * Used to show a dialog.
 *
 * This will collapse the Quick Settings panel and show the dialog.
 *
 * @param dialog Dialog to show.
 *
 * @see #isLocked()
 * @apiSince 24
 */

public final void showDialog(android.app.Dialog dialog) { throw new RuntimeException("Stub!"); }

/**
 * Prompts the user to unlock the device before executing the Runnable.
 * <p>
 * The user will be prompted for their current security method if applicable
 * and if successful, runnable will be executed.  The Runnable will not be
 * executed if the user fails to unlock the device or cancels the operation.
 * @apiSince 24
 */

public final void unlockAndRun(java.lang.Runnable runnable) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the device is in a secure state.
 *
 * TileServices should detect when the device is secure and change their behavior
 * accordingly.
 *
 * @return true if the device is secure.
 * @apiSince 24
 */

public final boolean isSecure() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the lock screen is showing.
 *
 * When a device is locked, then {@link #showDialog} will not present a dialog, as it will
 * be under the lock screen. If the behavior of the Tile is safe to do while locked,
 * then the user should use {@link #startActivity} to launch an activity on top of the lock
 * screen, otherwise the tile should use {@link #unlockAndRun(java.lang.Runnable)} to give the
 * user their security challenge.
 *
 * @return true if the device is locked.
 * @apiSince 24
 */

public final boolean isLocked() { throw new RuntimeException("Stub!"); }

/**
 * Start an activity while collapsing the panel.
 * @apiSince 24
 */

public final void startActivityAndCollapse(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.service.quicksettings.Tile Tile} for this service.
 * <p/>
 * This tile may be used to get or set the current state for this
 * tile. This tile is only valid for updates between {@link #onStartListening()}
 * and {@link #onStopListening()}.
 * @apiSince 24
 */

public final android.service.quicksettings.Tile getQsTile() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Requests that a tile be put in the listening state so it can send an update.
 *
 * This method is only applicable to tiles that have {@link #META_DATA_ACTIVE_TILE} defined
 * as true on their TileService Manifest declaration, and will do nothing otherwise.
 * @apiSince 24
 */

public static final void requestListeningState(android.content.Context context, android.content.ComponentName component) { throw new RuntimeException("Stub!"); }

/**
 * Action that identifies a Service as being a TileService.
 * @apiSince 24
 */

public static final java.lang.String ACTION_QS_TILE = "android.service.quicksettings.action.QS_TILE";

/**
 * An activity that provides a user interface for adjusting TileService
 * preferences. Optional but recommended for apps that implement a
 * TileService.
 * <p>
 * This intent may also define a {@link android.content.Intent#EXTRA_COMPONENT_NAME Intent#EXTRA_COMPONENT_NAME} value
 * to indicate the {@link android.content.ComponentName ComponentName} that caused the preferences to be
 * opened.
 * <p>
 * To ensure that the activity can only be launched through quick settings
 * UI provided by this service, apps can protect it with the
 * BIND_QUICK_SETTINGS_TILE permission.
 * @apiSince 24
 */

public static final java.lang.String ACTION_QS_TILE_PREFERENCES = "android.service.quicksettings.action.QS_TILE_PREFERENCES";

/**
 * Meta-data for tile definition to set a tile into active mode.
 * <p>
 * Active mode is for tiles which already listen and keep track of their state in their
 * own process.  These tiles may request to send an update to the System while their process
 * is alive using {@link #requestListeningState}.  The System will only bind these tiles
 * on its own when a click needs to occur.
 *
 * To make a TileService an active tile, set this meta-data to true on the TileService's
 * manifest declaration.
 * <pre class="prettyprint">
 * {@literal
 * <meta-data android:name="android.service.quicksettings.ACTIVE_TILE"
 *      android:value="true" />
 * }
 * </pre>
 * @apiSince 24
 */

public static final java.lang.String META_DATA_ACTIVE_TILE = "android.service.quicksettings.ACTIVE_TILE";
}

