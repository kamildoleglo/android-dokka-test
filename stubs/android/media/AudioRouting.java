/*
 * Copyright (C) 2016 The Android Open Source Project
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

import android.os.Looper;
import android.os.Handler;

/**
 * AudioRouting defines an interface for controlling routing and routing notifications in
 * AudioTrack and AudioRecord objects.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface AudioRouting {

/**
 * Specifies an audio device (via an {@link android.media.AudioDeviceInfo AudioDeviceInfo} object) to route
 * the output/input to/from.
 * @param deviceInfo The {@link android.media.AudioDeviceInfo AudioDeviceInfo} specifying the audio sink or source.
 *  If deviceInfo is null, default routing is restored.
 * @return true if succesful, false if the specified {@link android.media.AudioDeviceInfo AudioDeviceInfo} is non-null and
 * does not correspond to a valid audio device.
 * @apiSince 24
 */

public boolean setPreferredDevice(android.media.AudioDeviceInfo deviceInfo);

/**
 * Returns the selected output/input specified by {@link #setPreferredDevice}. Note that this
 * is not guaranteed to correspond to the actual device being used for playback/recording.
 * @apiSince 24
 */

public android.media.AudioDeviceInfo getPreferredDevice();

/**
 * Returns an {@link android.media.AudioDeviceInfo AudioDeviceInfo} identifying the current routing of this
 * AudioTrack/AudioRecord.
 * Note: The query is only valid if the AudioTrack/AudioRecord is currently playing.
 * If it is not, <code>getRoutedDevice()</code> will return null.
 * @apiSince 24
 */

public android.media.AudioDeviceInfo getRoutedDevice();

/**
 * Adds an {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} to receive notifications of routing
 * changes on this AudioTrack/AudioRecord.
 * @param listener The {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} interface to receive
 * notifications of rerouting events.
 * @param handler  Specifies the {@link android.os.Handler Handler} object for the thread on which to execute
 * the callback. If <code>null</code>, the {@link android.os.Handler Handler} associated with the main
 * {@link android.os.Looper Looper} will be used.
 * @apiSince 24
 */

public void addOnRoutingChangedListener(android.media.AudioRouting.OnRoutingChangedListener listener, android.os.Handler handler);

/**
 * Removes an {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} which has been previously added
 * to receive rerouting notifications.
 * @param listener The previously added {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} interface
 * to remove.
 * @apiSince 24
 */

public void removeOnRoutingChangedListener(android.media.AudioRouting.OnRoutingChangedListener listener);
/**
 * Defines the interface by which applications can receive notifications of routing
 * changes for the associated {@link android.media.AudioRouting AudioRouting}.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnRoutingChangedListener {

/** @apiSince 24 */

public void onRoutingChanged(android.media.AudioRouting router);
}

}

