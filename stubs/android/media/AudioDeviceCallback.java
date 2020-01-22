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


package android.media;


/**
 * AudioDeviceCallback defines the mechanism by which applications can receive notifications
 * of audio device connection and disconnection events.
 * @see android.media.AudioManager#registerAudioDeviceCallback(AudioDeviceCallback, android.os.Handler handler).
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AudioDeviceCallback {

public AudioDeviceCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called by the {@link android.media.AudioManager AudioManager} to indicate that one or more audio devices have been
 * connected.
 * @param addedDevices  An array of {@link android.media.AudioDeviceInfo AudioDeviceInfo} objects corresponding to any
 * newly added audio devices.
 * @apiSince 23
 */

public void onAudioDevicesAdded(android.media.AudioDeviceInfo[] addedDevices) { throw new RuntimeException("Stub!"); }

/**
 * Called by the {@link android.media.AudioManager AudioManager} to indicate that one or more audio devices have been
 * disconnected.
 * @param removedDevices  An array of {@link android.media.AudioDeviceInfo AudioDeviceInfo} objects corresponding to any
 * newly removed audio devices.
 * @apiSince 23
 */

public void onAudioDevicesRemoved(android.media.AudioDeviceInfo[] removedDevices) { throw new RuntimeException("Stub!"); }
}

