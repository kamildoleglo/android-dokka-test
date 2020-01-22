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


package android.media.tv;

import android.os.Parcel;

/**
 * Encapsulates the format of tracks played in {@link android.media.tv.TvInputService TvInputService}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TvTrackInfo implements android.os.Parcelable {

private TvTrackInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of the track. The type should be one of the followings:
 * {@link #TYPE_AUDIO}, {@link #TYPE_VIDEO} and {@link #TYPE_SUBTITLE}.
 
 * @return Value is {@link android.media.tv.TvTrackInfo#TYPE_AUDIO}, {@link android.media.tv.TvTrackInfo#TYPE_VIDEO}, or {@link android.media.tv.TvTrackInfo#TYPE_SUBTITLE}
 * @apiSince 21
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the ID of the track.
 * @apiSince 21
 */

public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the language information encoded by either ISO 639-1 or ISO 639-2/T. If the language
 * is unknown or could not be determined, the corresponding value will be {@code null}.
 * @apiSince 21
 */

public java.lang.String getLanguage() { throw new RuntimeException("Stub!"); }

/**
 * Returns a user readable description for the current track.
 * @apiSince 23
 */

public java.lang.CharSequence getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the track is encrypted, {@code false} otherwise. If the encryption
 * status is unknown or could not be determined, the corresponding value will be {@code false}.
 *
 * <p>For example: ISO/IEC 13818-1 defines a CA descriptor that can be used to determine the
 * encryption status of some broadcast streams.
 * @apiSince R
 */

public boolean isEncrypted() { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio channel count. Valid only for {@link #TYPE_AUDIO} tracks.
 *
 * @throws java.lang.IllegalStateException if not called on an audio track
 * @apiSince 21
 */

public int getAudioChannelCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio sample rate, in the unit of Hz. Valid only for {@link #TYPE_AUDIO} tracks.
 *
 * @throws java.lang.IllegalStateException if not called on an audio track
 * @apiSince 21
 */

public int getAudioSampleRate() { throw new RuntimeException("Stub!"); }

/**
 * Returns the width of the video, in the unit of pixels. Valid only for {@link #TYPE_VIDEO}
 * tracks.
 *
 * @throws java.lang.IllegalStateException if not called on a video track
 * @apiSince 21
 */

public int getVideoWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the height of the video, in the unit of pixels. Valid only for {@link #TYPE_VIDEO}
 * tracks.
 *
 * @throws java.lang.IllegalStateException if not called on a video track
 * @apiSince 21
 */

public int getVideoHeight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the frame rate of the video, in the unit of fps (frames per second). Valid only for
 * {@link #TYPE_VIDEO} tracks.
 *
 * @throws java.lang.IllegalStateException if not called on a video track
 * @apiSince 21
 */

public float getVideoFrameRate() { throw new RuntimeException("Stub!"); }

/**
 * Returns the pixel aspect ratio (the ratio of a pixel's width to its height) of the video.
 * Valid only for {@link #TYPE_VIDEO} tracks.
 *
 * @throws java.lang.IllegalStateException if not called on a video track
 * @apiSince 23
 */

public float getVideoPixelAspectRatio() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Active Format Description (AFD) code of the video.
 * Valid only for {@link #TYPE_VIDEO} tracks.
 *
 * <p>The complete list of values are defined in ETSI TS 101 154 V1.7.1 Annex B, ATSC A/53 Part
 * 4 and SMPTE 2016-1-2007.
 *
 * @throws java.lang.IllegalStateException if not called on a video track
 * @apiSince 24
 */

public byte getVideoActiveFormatDescription() { throw new RuntimeException("Stub!"); }

/**
 * Returns the extra information about the current track.
 * @apiSince 21
 */

public android.os.Bundle getExtra() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link android.os.Parcel Parcel}.
 *
 * @param dest The {@link android.os.Parcel Parcel} to be written.
 * @param flags The flags used for parceling.
 * @apiSince 21
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.tv.TvTrackInfo> CREATOR;
static { CREATOR = null; }

/**
 * The type value for audio tracks.
 * @apiSince 21
 */

public static final int TYPE_AUDIO = 0; // 0x0

/**
 * The type value for subtitle tracks.
 * @apiSince 21
 */

public static final int TYPE_SUBTITLE = 2; // 0x2

/**
 * The type value for video tracks.
 * @apiSince 21
 */

public static final int TYPE_VIDEO = 1; // 0x1
/**
 * A builder class for creating {@link android.media.tv.TvTrackInfo TvTrackInfo} objects.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Create a {@link android.media.tv.TvTrackInfo.Builder Builder}. Any field that should be included in the {@link android.media.tv.TvTrackInfo TvTrackInfo}
 * must be added.
 *
 * @param type The type of the track.
 * Value is {@link android.media.tv.TvTrackInfo#TYPE_AUDIO}, {@link android.media.tv.TvTrackInfo#TYPE_VIDEO}, or {@link android.media.tv.TvTrackInfo#TYPE_SUBTITLE}
 * @param id The ID of the track that uniquely identifies the current track among all the
 *            other tracks in the same TV program.
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the type is not any of {@link #TYPE_AUDIO},
 *                                  {@link #TYPE_VIDEO} and {@link #TYPE_SUBTITLE}
 * @apiSince 21
 */

public Builder(int type, @androidx.annotation.NonNull java.lang.String id) { throw new RuntimeException("Stub!"); }

/**
 * Sets the language information of the current track.
 *
 * @param language The language string encoded by either ISO 639-1 or ISO 639-2/T.
 * @apiSince 21
 */

public android.media.tv.TvTrackInfo.Builder setLanguage(java.lang.String language) { throw new RuntimeException("Stub!"); }

/**
 * Sets a user readable description for the current track.
 *
 * @param description The user readable description.
 * @apiSince 23
 */

public android.media.tv.TvTrackInfo.Builder setDescription(java.lang.CharSequence description) { throw new RuntimeException("Stub!"); }

/**
 * Sets the encryption status of the track.
 *
 * <p>For example: ISO/IEC 13818-1 defines a CA descriptor that can be used to determine the
 * encryption status of some broadcast streams.
 *
 * @param encrypted The encryption status of the track.
 
 * @return This value will never be {@code null}.
 * @apiSince R
 */

@androidx.annotation.NonNull
public android.media.tv.TvTrackInfo.Builder setEncrypted(boolean encrypted) { throw new RuntimeException("Stub!"); }

/**
 * Sets the audio channel count. Valid only for {@link #TYPE_AUDIO} tracks.
 *
 * @param audioChannelCount The audio channel count.
 * @throws java.lang.IllegalStateException if not called on an audio track
 * @apiSince 21
 */

public android.media.tv.TvTrackInfo.Builder setAudioChannelCount(int audioChannelCount) { throw new RuntimeException("Stub!"); }

/**
 * Sets the audio sample rate, in the unit of Hz. Valid only for {@link #TYPE_AUDIO}
 * tracks.
 *
 * @param audioSampleRate The audio sample rate.
 * @throws java.lang.IllegalStateException if not called on an audio track
 * @apiSince 21
 */

public android.media.tv.TvTrackInfo.Builder setAudioSampleRate(int audioSampleRate) { throw new RuntimeException("Stub!"); }

/**
 * Sets the width of the video, in the unit of pixels. Valid only for {@link #TYPE_VIDEO}
 * tracks.
 *
 * @param videoWidth The width of the video.
 * @throws java.lang.IllegalStateException if not called on a video track
 * @apiSince 21
 */

public android.media.tv.TvTrackInfo.Builder setVideoWidth(int videoWidth) { throw new RuntimeException("Stub!"); }

/**
 * Sets the height of the video, in the unit of pixels. Valid only for {@link #TYPE_VIDEO}
 * tracks.
 *
 * @param videoHeight The height of the video.
 * @throws java.lang.IllegalStateException if not called on a video track
 * @apiSince 21
 */

public android.media.tv.TvTrackInfo.Builder setVideoHeight(int videoHeight) { throw new RuntimeException("Stub!"); }

/**
 * Sets the frame rate of the video, in the unit fps (frames per rate). Valid only for
 * {@link #TYPE_VIDEO} tracks.
 *
 * @param videoFrameRate The frame rate of the video.
 * @throws java.lang.IllegalStateException if not called on a video track
 * @apiSince 21
 */

public android.media.tv.TvTrackInfo.Builder setVideoFrameRate(float videoFrameRate) { throw new RuntimeException("Stub!"); }

/**
 * Sets the pixel aspect ratio (the ratio of a pixel's width to its height) of the video.
 * Valid only for {@link #TYPE_VIDEO} tracks.
 *
 * <p>This is needed for applications to be able to scale the video properly for some video
 * formats such as 720x576 4:3 and 720x576 16:9 where pixels are not square. By default,
 * applications assume the value of 1.0 (square pixels), so it is not necessary to set the
 * pixel aspect ratio for most video formats.
 *
 * @param videoPixelAspectRatio The pixel aspect ratio of the video.
 * @throws java.lang.IllegalStateException if not called on a video track
 * @apiSince 23
 */

public android.media.tv.TvTrackInfo.Builder setVideoPixelAspectRatio(float videoPixelAspectRatio) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Active Format Description (AFD) code of the video.
 * Valid only for {@link #TYPE_VIDEO} tracks.
 *
 * <p>This is needed for applications to be able to scale the video properly based on the
 * information about where in the coded picture the active video is.
 * The complete list of values are defined in ETSI TS 101 154 V1.7.1 Annex B, ATSC A/53 Part
 * 4 and SMPTE 2016-1-2007.
 *
 * @param videoActiveFormatDescription The AFD code of the video.
 * @throws java.lang.IllegalStateException if not called on a video track
 * @apiSince 24
 */

public android.media.tv.TvTrackInfo.Builder setVideoActiveFormatDescription(byte videoActiveFormatDescription) { throw new RuntimeException("Stub!"); }

/**
 * Sets the extra information about the current track.
 *
 * @param extra The extra information.
 * @apiSince 21
 */

public android.media.tv.TvTrackInfo.Builder setExtra(android.os.Bundle extra) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.media.tv.TvTrackInfo TvTrackInfo} instance with the specified fields.
 *
 * @return The new {@link android.media.tv.TvTrackInfo TvTrackInfo} instance
 * @apiSince 21
 */

public android.media.tv.TvTrackInfo build() { throw new RuntimeException("Stub!"); }
}

}

