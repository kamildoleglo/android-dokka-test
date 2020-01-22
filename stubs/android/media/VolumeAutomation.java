/*
 * Copyright 2017 The Android Open Source Project
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

import android.media.VolumeShaper.Configuration;

/**
 * {@code VolumeAutomation} defines an interface for automatic volume control
 * of {@link android.media.AudioTrack AudioTrack} and {@link android.media.MediaPlayer MediaPlayer} objects.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface VolumeAutomation {

/**
 * Returns a {@link android.media.VolumeShaper VolumeShaper} object that can be used modify the volume envelope
 * of the player or track.
 *
 * @param configuration the {@link android.media.VolumeShaper.Configuration VolumeShaper.Configuration}
 *        that specifies the curve and duration to use.
 * This value must never be {@code null}.
 * @return a {@code VolumeShaper} object
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the {@code configuration} is not allowed by the player.
 * @throws java.lang.IllegalStateException if too many {@code VolumeShaper}s are requested
 *         or the state of the player does not permit its creation (e.g. player is released).
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.media.VolumeShaper createVolumeShaper(@androidx.annotation.NonNull android.media.VolumeShaper.Configuration configuration);
}

