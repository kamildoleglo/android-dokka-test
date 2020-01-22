/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.os;


/**
 * A VibrationEffect describes a haptic effect to be performed by a {@link android.os.Vibrator Vibrator}.
 *
 * These effects may be any number of things, from single shot vibrations to complex waveforms.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class VibrationEffect implements android.os.Parcelable {

VibrationEffect() { throw new RuntimeException("Stub!"); }

/**
 * Create a one shot vibration.
 *
 * One shot vibrations will vibrate constantly for the specified period of time at the
 * specified amplitude, and then stop.
 *
 * @param milliseconds The number of milliseconds to vibrate. This must be a positive number.
 * @param amplitude The strength of the vibration. This must be a value between 1 and 255, or
 * {@link #DEFAULT_AMPLITUDE}.
 *
 * @return The desired effect.
 * @apiSince 26
 */

public static android.os.VibrationEffect createOneShot(long milliseconds, int amplitude) { throw new RuntimeException("Stub!"); }

/**
 * Create a waveform vibration.
 *
 * Waveform vibrations are a potentially repeating series of timing and amplitude pairs. For
 * each pair, the value in the amplitude array determines the strength of the vibration and the
 * value in the timing array determines how long it vibrates for. An amplitude of 0 implies no
 * vibration (i.e. off), and any pairs with a timing value of 0 will be ignored.
 * <p>
 * The amplitude array of the generated waveform will be the same size as the given
 * timing array with alternating values of 0 (i.e. off) and {@link #DEFAULT_AMPLITUDE},
 * starting with 0. Therefore the first timing value will be the period to wait before turning
 * the vibrator on, the second value will be how long to vibrate at {@link #DEFAULT_AMPLITUDE}
 * strength, etc.
 * </p><p>
 * To cause the pattern to repeat, pass the index into the timings array at which to start the
 * repetition, or -1 to disable repeating.
 * </p>
 *
 * @param timings The pattern of alternating on-off timings, starting with off. Timing values
 *                of 0 will cause the timing / amplitude pair to be ignored.
 * @param repeat The index into the timings array at which to repeat, or -1 if you you don't
 *               want to repeat.
 *
 * @return The desired effect.
 * @apiSince 26
 */

public static android.os.VibrationEffect createWaveform(long[] timings, int repeat) { throw new RuntimeException("Stub!"); }

/**
 * Create a waveform vibration.
 *
 * Waveform vibrations are a potentially repeating series of timing and amplitude pairs. For
 * each pair, the value in the amplitude array determines the strength of the vibration and the
 * value in the timing array determines how long it vibrates for. An amplitude of 0 implies no
 * vibration (i.e. off), and any pairs with a timing value of 0 will be ignored.
 * </p><p>
 * To cause the pattern to repeat, pass the index into the timings array at which to start the
 * repetition, or -1 to disable repeating.
 * </p>
 *
 * @param timings The timing values of the timing / amplitude pairs. Timing values of 0
 *                will cause the pair to be ignored.
 * @param amplitudes The amplitude values of the timing / amplitude pairs. Amplitude values
 *                   must be between 0 and 255, or equal to {@link #DEFAULT_AMPLITUDE}. An
 *                   amplitude value of 0 implies the motor is off.
 * @param repeat The index into the timings array at which to repeat, or -1 if you you don't
 *               want to repeat.
 *
 * @return The desired effect.
 * @apiSince 26
 */

public static android.os.VibrationEffect createWaveform(long[] timings, int[] amplitudes, int repeat) { throw new RuntimeException("Stub!"); }

/**
 * Create a predefined vibration effect.
 *
 * Predefined effects are a set of common vibration effects that should be identical, regardless
 * of the app they come from, in order to provide a cohesive experience for users across
 * the entire device. They also may be custom tailored to the device hardware in order to
 * provide a better experience than you could otherwise build using the generic building
 * blocks.
 *
 * This will fallback to a generic pattern if one exists and there does not exist a
 * hardware-specific implementation of the effect.
 *
 * @param effectId The ID of the effect to perform:
 *                 {@link #EFFECT_CLICK}, {@link #EFFECT_DOUBLE_CLICK}, {@link #EFFECT_TICK}
 *
 * Value is {@link android.os.VibrationEffect#EFFECT_TICK}, {@link android.os.VibrationEffect#EFFECT_CLICK}, {@link android.os.VibrationEffect#EFFECT_HEAVY_CLICK}, or {@link android.os.VibrationEffect#EFFECT_DOUBLE_CLICK}
 * @return The desired effect.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.os.VibrationEffect createPredefined(int effectId) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.os.VibrationEffect> CREATOR;
static { CREATOR = null; }

/**
 * The default vibration strength of the device.
 * @apiSince 26
 */

public static final int DEFAULT_AMPLITUDE = -1; // 0xffffffff

/**
 * A click effect. Use this effect as a baseline, as it's the most common type of click effect.
 *
 * @see #get(int)
 * @apiSince 29
 */

public static final int EFFECT_CLICK = 0; // 0x0

/**
 * A double click effect.
 *
 * @see #get(int)
 * @apiSince 29
 */

public static final int EFFECT_DOUBLE_CLICK = 1; // 0x1

/**
 * A heavy click effect. This effect is stronger than {@link #EFFECT_CLICK}.
 * @see #get(int)
 * @apiSince 29
 */

public static final int EFFECT_HEAVY_CLICK = 5; // 0x5

/**
 * A tick effect. This effect is less strong compared to {@link #EFFECT_CLICK}.
 * @see #get(int)
 * @apiSince 29
 */

public static final int EFFECT_TICK = 2; // 0x2
}

