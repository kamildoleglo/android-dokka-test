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

package android.media;

import android.media.session.MediaSession;

/**
 * Handles requests to adjust or set the volume on a session. This is also used
 * to push volume updates back to the session. The provider must call
 * {@link #setCurrentVolume(int)} each time the volume being provided changes.
 * <p>
 * You can set a volume provider on a session by calling
 * {@link android.media.session.MediaSession#setPlaybackToRemote MediaSession#setPlaybackToRemote}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class VolumeProvider {

/**
 * Create a new volume provider for handling volume events. You must specify
 * the type of volume control, the maximum volume that can be used, and the
 * current volume on the output.
 *
 * @param volumeControl The method for controlling volume that is used by
 *            this provider.
 * Value is {@link android.media.VolumeProvider#VOLUME_CONTROL_FIXED}, {@link android.media.VolumeProvider#VOLUME_CONTROL_RELATIVE}, or {@link android.media.VolumeProvider#VOLUME_CONTROL_ABSOLUTE}
 * @param maxVolume The maximum allowed volume.
 * @param currentVolume The current volume on the output.
 * @apiSince 21
 */

public VolumeProvider(int volumeControl, int maxVolume, int currentVolume) { throw new RuntimeException("Stub!"); }

/**
 * Get the volume control type that this volume provider uses.
 *
 * @return The volume control type for this volume provider
 
 * Value is {@link android.media.VolumeProvider#VOLUME_CONTROL_FIXED}, {@link android.media.VolumeProvider#VOLUME_CONTROL_RELATIVE}, or {@link android.media.VolumeProvider#VOLUME_CONTROL_ABSOLUTE}
 * @apiSince 21
 */

public final int getVolumeControl() { throw new RuntimeException("Stub!"); }

/**
 * Get the maximum volume this provider allows.
 *
 * @return The max allowed volume.
 * @apiSince 21
 */

public final int getMaxVolume() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current volume. This will be the last value set by
 * {@link #setCurrentVolume(int)}.
 *
 * @return The current volume.
 * @apiSince 21
 */

public final int getCurrentVolume() { throw new RuntimeException("Stub!"); }

/**
 * Notify the system that the current volume has been changed. This must be
 * called every time the volume changes to ensure it is displayed properly.
 *
 * @param currentVolume The current volume on the output.
 * @apiSince 21
 */

public final void setCurrentVolume(int currentVolume) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to set the volume of the current output.
 * After the volume has been modified {@link #setCurrentVolume} must be
 * called to notify the system.
 *
 * @param volume The volume to set the output to.
 * @apiSince 21
 */

public void onSetVolumeTo(int volume) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to adjust the volume of the current output.
 * Direction will be one of {@link android.media.AudioManager#ADJUST_LOWER AudioManager#ADJUST_LOWER},
 * {@link android.media.AudioManager#ADJUST_RAISE AudioManager#ADJUST_RAISE}, {@link android.media.AudioManager#ADJUST_SAME AudioManager#ADJUST_SAME}.
 * After the volume has been modified {@link #setCurrentVolume} must be
 * called to notify the system.
 *
 * @param direction The direction to change the volume in.
 * @apiSince 21
 */

public void onAdjustVolume(int direction) { throw new RuntimeException("Stub!"); }

/**
 * The volume control uses an absolute value. It may be adjusted using
 * {@link #onAdjustVolume(int)} or set directly using
 * {@link #onSetVolumeTo(int)}.
 * @apiSince 21
 */

public static final int VOLUME_CONTROL_ABSOLUTE = 2; // 0x2

/**
 * The volume is fixed and can not be modified. Requests to change volume
 * should be ignored.
 * @apiSince 21
 */

public static final int VOLUME_CONTROL_FIXED = 0; // 0x0

/**
 * The volume control uses relative adjustment via
 * {@link #onAdjustVolume(int)}. Attempts to set the volume to a specific
 * value should be ignored.
 * @apiSince 21
 */

public static final int VOLUME_CONTROL_RELATIVE = 1; // 0x1
}

