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


/**
 * The {@code VolumeShaper} class is used to automatically control audio volume during media
 * playback, allowing simple implementation of transition effects and ducking.
 * It is created from implementations of {@code VolumeAutomation},
 * such as {@code MediaPlayer} and {@code AudioTrack} (referred to as "players" below),
 * by {@link android.media.MediaPlayer#createVolumeShaper MediaPlayer#createVolumeShaper} or {@link android.media.AudioTrack#createVolumeShaper AudioTrack#createVolumeShaper}.
 *
 * A {@code VolumeShaper} is intended for short volume changes.
 * If the audio output sink changes during
 * a {@code VolumeShaper} transition, the precise curve position may be lost, and the
 * {@code VolumeShaper} may advance to the end of the curve for the new audio output sink.
 *
 * The {@code VolumeShaper} appears as an additional scaling on the audio output,
 * and adjusts independently of track or stream volume controls.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class VolumeShaper implements java.lang.AutoCloseable {

VolumeShaper() { throw new RuntimeException("Stub!"); }

/**
 * Applies the {@link android.media.VolumeShaper.Operation VolumeShaper.Operation} to the {@code VolumeShaper}.
 *
 * Applying {@link android.media.VolumeShaper.Operation#PLAY VolumeShaper.Operation#PLAY} after {@code PLAY}
 * or {@link android.media.VolumeShaper.Operation#REVERSE VolumeShaper.Operation#REVERSE} after
 * {@code REVERSE} has no effect.
 *
 * Applying {@link android.media.VolumeShaper.Operation#PLAY VolumeShaper.Operation#PLAY} when the player
 * hasn't started will synchronously start the {@code VolumeShaper} when
 * playback begins.
 *
 * @param operation the {@code operation} to apply.
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if the player is uninitialized or if there
 *         is a critical failure. In that case, the {@code VolumeShaper} should be
 *         recreated.
 * @apiSince 26
 */

public void apply(@androidx.annotation.NonNull android.media.VolumeShaper.Operation operation) { throw new RuntimeException("Stub!"); }

/**
 * Replaces the current {@code VolumeShaper}
 * {@code configuration} with a new {@code configuration}.
 *
 * This allows the user to change the volume shape
 * while the existing {@code VolumeShaper} is in effect.
 *
 * The effect of {@code replace()} is similar to an atomic close of
 * the existing {@code VolumeShaper} and creation of a new {@code VolumeShaper}.
 *
 * If the {@code operation} is {@link android.media.VolumeShaper.Operation#PLAY VolumeShaper.Operation#PLAY} then the
 * new curve starts immediately.
 *
 * If the {@code operation} is
 * {@link android.media.VolumeShaper.Operation#REVERSE VolumeShaper.Operation#REVERSE}, then the new curve will
 * be delayed until {@code PLAY} is applied.
 *
 * @param configuration the new {@code configuration} to use.
 * This value must never be {@code null}.
 * @param operation the {@code operation} to apply to the {@code VolumeShaper}
 * This value must never be {@code null}.
 * @param join if true, match the start volume of the
 *             new {@code configuration} to the current volume of the existing
 *             {@code VolumeShaper}, to avoid discontinuity.
 * @throws java.lang.IllegalStateException if the player is uninitialized or if there
 *         is a critical failure. In that case, the {@code VolumeShaper} should be
 *         recreated.
 * @apiSince 26
 */

public void replace(@androidx.annotation.NonNull android.media.VolumeShaper.Configuration configuration, @androidx.annotation.NonNull android.media.VolumeShaper.Operation operation, boolean join) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current volume scale attributable to the {@code VolumeShaper}.
 *
 * This is the last volume from the {@code VolumeShaper} used for the player,
 * or the initial volume if the {@code VolumeShaper} hasn't been started with
 * {@link android.media.VolumeShaper.Operation#PLAY VolumeShaper.Operation#PLAY}.
 *
 * @return the volume, linearly represented as a value between 0.f and 1.f.
 * @throws java.lang.IllegalStateException if the player is uninitialized or if there
 *         is a critical failure.  In that case, the {@code VolumeShaper} should be
 *         recreated.
 * @apiSince 26
 */

public float getVolume() { throw new RuntimeException("Stub!"); }

/**
 * Releases the {@code VolumeShaper} object; any volume scale due to the
 * {@code VolumeShaper} is removed after closing.
 *
 * If the volume does not reach 1.f when the {@code VolumeShaper} is closed
 * (or finalized), there may be an abrupt change of volume.
 *
 * {@code close()} may be safely called after a prior {@code close()}.
 * This class implements the Java {@code AutoClosable} interface and
 * may be used with try-with-resources.
 * @apiSince 26
 */

public void close() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

protected void finalize() { throw new RuntimeException("Stub!"); }
/**
 * The {@code VolumeShaper.Configuration} class contains curve
 * and duration information.
 * It is constructed by the {@link android.media.VolumeShaper.Configuration.Builder VolumeShaper.Configuration.Builder}.
 * <p>
 * A {@code VolumeShaper.Configuration} is used by
 * {@link android.media.VolumeAutomation#createVolumeShaper(android.media.VolumeShaper.Configuration) VolumeAutomation#createVolumeShaper(Configuration)} to create
 * a {@code VolumeShaper} and
 * by {@link android.media.VolumeShaper#replace(android.media.VolumeShaper.Configuration,android.media.VolumeShaper.Operation,boolean) VolumeShaper#replace(Configuration, Operation, boolean)}
 * to replace an existing {@code configuration}.
 * <p>
 * The {@link android.media.AudioTrack AudioTrack} and {@link android.media.MediaPlayer MediaPlayer} classes implement
 * the {@link android.media.VolumeAutomation VolumeAutomation} interface.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Configuration implements android.os.Parcelable {

Configuration() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum number of curve points allowed for
 * {@link VolumeShaper.Builder#setCurve(float[], float[])}.
 * @apiSince 26
 */

public static int getMaximumCurvePoints() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns the interpolator type.
 
 * @return Value is {@link android.media.VolumeShaper.Configuration#INTERPOLATOR_TYPE_STEP}, {@link android.media.VolumeShaper.Configuration#INTERPOLATOR_TYPE_LINEAR}, {@link android.media.VolumeShaper.Configuration#INTERPOLATOR_TYPE_CUBIC}, or {@link android.media.VolumeShaper.Configuration#INTERPOLATOR_TYPE_CUBIC_MONOTONIC}
 * @apiSince 26
 */

public int getInterpolatorType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the duration of the volume shape in milliseconds.
 * @apiSince 26
 */

public long getDuration() { throw new RuntimeException("Stub!"); }

/**
 * Returns the times (x) coordinate array of the volume curve points.
 * @apiSince 26
 */

public float[] getTimes() { throw new RuntimeException("Stub!"); }

/**
 * Returns the volumes (y) coordinate array of the volume curve points.
 * @apiSince 26
 */

public float[] getVolumes() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.VolumeShaper.Configuration> CREATOR;
static { CREATOR = null; }

/**
 * A one second cubic ramp from silence to full volume.
 * Use {@link VolumeShaper.Builder#reflectTimes()}
 * or {@link VolumeShaper.Builder#invertVolumes()} to generate
 * the matching cubic duck.
 * @apiSince 26
 */

public static final android.media.VolumeShaper.Configuration CUBIC_RAMP;
static { CUBIC_RAMP = null; }

/**
 * Cubic interpolated volume curve.
 * This is default if unspecified.
 * @apiSince 26
 */

public static final int INTERPOLATOR_TYPE_CUBIC = 2; // 0x2

/**
 * Cubic interpolated volume curve
 * that preserves local monotonicity.
 * So long as the control points are locally monotonic,
 * the curve interpolation between those points are monotonic.
 * This is useful for cubic spline interpolated
 * volume ramps and ducks.
 * @apiSince 26
 */

public static final int INTERPOLATOR_TYPE_CUBIC_MONOTONIC = 3; // 0x3

/**
 * Linear interpolated volume curve.
 * @apiSince 26
 */

public static final int INTERPOLATOR_TYPE_LINEAR = 1; // 0x1

/**
 * Stepwise volume curve.
 * @apiSince 26
 */

public static final int INTERPOLATOR_TYPE_STEP = 0; // 0x0

/**
 * A one second linear ramp from silence to full volume.
 * Use {@link VolumeShaper.Builder#reflectTimes()}
 * or {@link VolumeShaper.Builder#invertVolumes()} to generate
 * the matching linear duck.
 * @apiSince 26
 */

public static final android.media.VolumeShaper.Configuration LINEAR_RAMP;
static { LINEAR_RAMP = null; }

/**
 * A one second sine-squared s-curve ramp
 * from silence to full volume.
 * Use {@link VolumeShaper.Builder#reflectTimes()}
 * or {@link VolumeShaper.Builder#invertVolumes()} to generate
 * the matching sine-squared s-curve duck.
 * @apiSince 26
 */

public static final android.media.VolumeShaper.Configuration SCURVE_RAMP;
static { SCURVE_RAMP = null; }

/**
 * A one second sine curve
 * from silence to full volume for energy preserving cross fades.
 * Use {@link VolumeShaper.Builder#reflectTimes()} to generate
 * the matching cosine duck.
 * @apiSince 26
 */

public static final android.media.VolumeShaper.Configuration SINE_RAMP;
static { SINE_RAMP = null; }
/**
 * Builder class for a {@link android.media.VolumeShaper.Configuration VolumeShaper.Configuration} object.
 * <p> Here is an example where {@code Builder} is used to define the
 * {@link android.media.VolumeShaper.Configuration VolumeShaper.Configuration}.
 *
 * <pre class="prettyprint">
 * VolumeShaper.Configuration LINEAR_RAMP =
 *         new VolumeShaper.Configuration.Builder()
 *             .setInterpolatorType(VolumeShaper.Configuration.INTERPOLATOR_TYPE_LINEAR)
 *             .setCurve(new float[] { 0.f, 1.f }, // times
 *                       new float[] { 0.f, 1.f }) // volumes
 *             .setDuration(1000)
 *             .build();
 * </pre>
 * <p>
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Constructs a new {@code Builder} with the defaults.
 * @apiSince 26
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code Builder} with settings
 * copied from a given {@code VolumeShaper.Configuration}.
 * @param configuration prototypical configuration
 *        which will be reused in the new {@code Builder}.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public Builder(@androidx.annotation.NonNull android.media.VolumeShaper.Configuration configuration) { throw new RuntimeException("Stub!"); }

/**
 * Sets the interpolator type.
 *
 * If omitted the default interpolator type is {@link #INTERPOLATOR_TYPE_CUBIC}.
 *
 * @param interpolatorType method of interpolation used for the volume curve.
 *        One of {@link #INTERPOLATOR_TYPE_STEP},
 *        {@link #INTERPOLATOR_TYPE_LINEAR},
 *        {@link #INTERPOLATOR_TYPE_CUBIC},
 *        {@link #INTERPOLATOR_TYPE_CUBIC_MONOTONIC}.
 * Value is {@link android.media.VolumeShaper.Configuration#INTERPOLATOR_TYPE_STEP}, {@link android.media.VolumeShaper.Configuration#INTERPOLATOR_TYPE_LINEAR}, {@link android.media.VolumeShaper.Configuration#INTERPOLATOR_TYPE_CUBIC}, or {@link android.media.VolumeShaper.Configuration#INTERPOLATOR_TYPE_CUBIC_MONOTONIC}
 * @return the same {@code Builder} instance.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if {@code interpolatorType} is not valid.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.media.VolumeShaper.Configuration.Builder setInterpolatorType(int interpolatorType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@code VolumeShaper} duration in milliseconds.
 *
 * If omitted, the default duration is 1 second.
 *
 * @param durationMillis
 * @return the same {@code Builder} instance.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if {@code durationMillis}
 *         is not strictly positive.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.media.VolumeShaper.Configuration.Builder setDuration(long durationMillis) { throw new RuntimeException("Stub!"); }

/**
 * Sets the volume curve.
 *
 * The volume curve is represented by a set of control points given by
 * two float arrays of equal length,
 * one representing the time (x) coordinates
 * and one corresponding to the volume (y) coordinates.
 * The length must be at least 2
 * and no greater than {@link android.media.VolumeShaper.Configuration#getMaximumCurvePoints() VolumeShaper.Configuration#getMaximumCurvePoints()}.
 * <p>
 * The volume curve is normalized as follows:
 * time (x) coordinates should be monotonically increasing, from 0.f to 1.f;
 * volume (y) coordinates must be within 0.f to 1.f.
 * <p>
 * The time scale is set by {@link #setDuration}.
 * <p>
 * @param times an array of float values representing
 *        the time line of the volume curve.
 * This value must never be {@code null}.
 * @param volumes an array of float values representing
 *        the amplitude of the volume curve.
 * This value must never be {@code null}.
 * @return the same {@code Builder} instance.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if {@code times} or {@code volumes} is invalid.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.media.VolumeShaper.Configuration.Builder setCurve(@androidx.annotation.NonNull float[] times, @androidx.annotation.NonNull float[] volumes) { throw new RuntimeException("Stub!"); }

/**
 * Reflects the volume curve so that
 * the shaper changes volume from the end
 * to the start.
 *
 * @return the same {@code Builder} instance.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException if curve has not been set.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.media.VolumeShaper.Configuration.Builder reflectTimes() { throw new RuntimeException("Stub!"); }

/**
 * Inverts the volume curve so that the max volume
 * becomes the min volume and vice versa.
 *
 * @return the same {@code Builder} instance.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException if curve has not been set.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.media.VolumeShaper.Configuration.Builder invertVolumes() { throw new RuntimeException("Stub!"); }

/**
 * Scale the curve end volume to a target value.
 *
 * Keeps the start volume the same.
 * This works best if the volume curve is monotonic.
 *
 * @param volume the target end volume to use.
 * @return the same {@code Builder} instance.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if {@code volume} is not valid.
 * @throws java.lang.IllegalStateException if curve has not been set.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.media.VolumeShaper.Configuration.Builder scaleToEndVolume(float volume) { throw new RuntimeException("Stub!"); }

/**
 * Scale the curve start volume to a target value.
 *
 * Keeps the end volume the same.
 * This works best if the volume curve is monotonic.
 *
 * @param volume the target start volume to use.
 * @return the same {@code Builder} instance.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if {@code volume} is not valid.
 * @throws java.lang.IllegalStateException if curve has not been set.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.media.VolumeShaper.Configuration.Builder scaleToStartVolume(float volume) { throw new RuntimeException("Stub!"); }

/**
 * Builds a new {@link android.media.VolumeShaper VolumeShaper} object.
 *
 * @return a new {@link android.media.VolumeShaper VolumeShaper} object.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException if curve is not properly set.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.media.VolumeShaper.Configuration build() { throw new RuntimeException("Stub!"); }
}

}

/**
 * The {@code VolumeShaper.Operation} class is used to specify operations
 * to the {@code VolumeShaper} that affect the volume change.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Operation implements android.os.Parcelable {

private Operation() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.VolumeShaper.Operation> CREATOR;
static { CREATOR = null; }

/**
 * Forward playback from current volume time position.
 * At the end of the {@code VolumeShaper} curve,
 * the last volume value persists.
 * @apiSince 26
 */

public static final android.media.VolumeShaper.Operation PLAY;
static { PLAY = null; }

/**
 * Reverse playback from current volume time position.
 * When the position reaches the start of the {@code VolumeShaper} curve,
 * the first volume value persists.
 * @apiSince 26
 */

public static final android.media.VolumeShaper.Operation REVERSE;
static { REVERSE = null; }
}

}

