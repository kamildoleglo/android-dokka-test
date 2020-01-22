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
 * limitations under the License
 */


package android.location;


/**
 * A class containing a GPS clock timestamp.
 *
 * <p>It represents a measurement of the GPS receiver's clock.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class GnssClock implements android.os.Parcelable {

GnssClock() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getLeapSecond()} is available, {@code false} otherwise.
 * @apiSince 24
 */

public boolean hasLeapSecond() { throw new RuntimeException("Stub!"); }

/**
 * Gets the leap second associated with the clock's time.
 *
 * <p>The sign of the value is defined by the following equation:
 * <pre>
 *     UtcTimeNanos = TimeNanos - (FullBiasNanos + BiasNanos) - LeapSecond * 1,000,000,000</pre>
 *
 * <p>The value is only available if {@link #hasLeapSecond()} is {@code true}.
 * @apiSince 24
 */

public int getLeapSecond() { throw new RuntimeException("Stub!"); }

/**
 * Gets the GNSS receiver internal hardware clock value in nanoseconds.
 *
 * <p>This value is expected to be monotonically increasing while the hardware clock remains
 * powered on. For the case of a hardware clock that is not continuously on, see the
 * {@link #getHardwareClockDiscontinuityCount} field. The GPS time can be derived by subtracting
 * the sum of {@link #getFullBiasNanos()} and {@link #getBiasNanos()} (when they are available)
 * from this value. Sub-nanosecond accuracy can be provided by means of {@link #getBiasNanos()}.
 *
 * <p>The error estimate for this value (if applicable) is {@link #getTimeUncertaintyNanos()}.
 * @apiSince 24
 */

public long getTimeNanos() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getTimeUncertaintyNanos()} is available, {@code false}
 * otherwise.
 * @apiSince 24
 */

public boolean hasTimeUncertaintyNanos() { throw new RuntimeException("Stub!"); }

/**
 * Gets the clock's time Uncertainty (1-Sigma) in nanoseconds.
 *
 * <p>The uncertainty is represented as an absolute (single sided) value.
 *
 * <p>The value is only available if {@link #hasTimeUncertaintyNanos()} is {@code true}.
 *
 * <p>This value is often effectively zero (it is the reference clock by which all other times
 * and time uncertainties are measured), and thus this field may often be 0, or not provided.
 
 * @return Value is 0.0f or greater
 * @apiSince 24
 */

public double getTimeUncertaintyNanos() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getFullBiasNanos()} is available, {@code false} otherwise.
 * @apiSince 24
 */

public boolean hasFullBiasNanos() { throw new RuntimeException("Stub!"); }

/**
 * Gets the difference between hardware clock ({@link #getTimeNanos()}) inside GPS receiver and
 * the true GPS time since 0000Z, January 6, 1980, in nanoseconds.
 *
 * <p>This value is available if the receiver has estimated GPS time. If the computed time is
 * for a non-GPS constellation, the time offset of that constellation to GPS has to be applied
 * to fill this value. The value is only available if {@link #hasFullBiasNanos()} is
 * {@code true}.
 *
 * <p>The error estimate for the sum of this field and {@link #getBiasNanos} is
 * {@link #getBiasUncertaintyNanos()}.
 *
 * <p>The sign of the value is defined by the following equation:
 *
 * <pre>
 *     local estimate of GPS time = TimeNanos - (FullBiasNanos + BiasNanos)</pre>
 * @apiSince 24
 */

public long getFullBiasNanos() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getBiasNanos()} is available, {@code false} otherwise.
 * @apiSince 24
 */

public boolean hasBiasNanos() { throw new RuntimeException("Stub!"); }

/**
 * Gets the clock's sub-nanosecond bias.
 *
 * <p>See the description of how this field is part of converting from hardware clock time, to
 * GPS time, in {@link #getFullBiasNanos()}.
 *
 * <p>The error estimate for the sum of this field and {@link #getFullBiasNanos} is
 * {@link #getBiasUncertaintyNanos()}.
 *
 * <p>The value is only available if {@link #hasBiasNanos()} is {@code true}.
 * @apiSince 24
 */

public double getBiasNanos() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getBiasUncertaintyNanos()} is available, {@code false}
 * otherwise.
 * @apiSince 24
 */

public boolean hasBiasUncertaintyNanos() { throw new RuntimeException("Stub!"); }

/**
 * Gets the clock's Bias Uncertainty (1-Sigma) in nanoseconds.
 *
 * <p>See the description of how this field provides the error estimate in the conversion from
 * hardware clock time, to GPS time, in {@link #getFullBiasNanos()}.
 *
 * <p>The value is only available if {@link #hasBiasUncertaintyNanos()} is {@code true}.
 
 * @return Value is 0.0f or greater
 * @apiSince 24
 */

public double getBiasUncertaintyNanos() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getDriftNanosPerSecond()} is available, {@code false}
 * otherwise.
 * @apiSince 24
 */

public boolean hasDriftNanosPerSecond() { throw new RuntimeException("Stub!"); }

/**
 * Gets the clock's Drift in nanoseconds per second.
 *
 * <p>This value is the instantaneous time-derivative of the value provided by
 * {@link #getBiasNanos()}.
 *
 * <p>A positive value indicates that the frequency is higher than the nominal (e.g. GPS master
 * clock) frequency. The error estimate for this reported drift is
 * {@link #getDriftUncertaintyNanosPerSecond()}.
 *
 * <p>The value is only available if {@link #hasDriftNanosPerSecond()} is {@code true}.
 * @apiSince 24
 */

public double getDriftNanosPerSecond() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getDriftUncertaintyNanosPerSecond()} is available,
 * {@code false} otherwise.
 * @apiSince 24
 */

public boolean hasDriftUncertaintyNanosPerSecond() { throw new RuntimeException("Stub!"); }

/**
 * Gets the clock's Drift Uncertainty (1-Sigma) in nanoseconds per second.
 *
 * <p>The value is only available if {@link #hasDriftUncertaintyNanosPerSecond()} is
 * {@code true}.
 
 * @return Value is 0.0f or greater
 * @apiSince 24
 */

public double getDriftUncertaintyNanosPerSecond() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getElapsedRealtimeNanos()} is available, {@code false}
 * otherwise.
 * @apiSince 29
 */

public boolean hasElapsedRealtimeNanos() { throw new RuntimeException("Stub!"); }

/**
 * Returns the elapsed real-time of this clock since system boot, in nanoseconds.
 *
 * <p>The value is only available if {@link #hasElapsedRealtimeNanos()} is
 * {@code true}.
 * @apiSince 29
 */

public long getElapsedRealtimeNanos() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getElapsedRealtimeUncertaintyNanos()} is available, {@code
 * false} otherwise.
 * @apiSince 29
 */

public boolean hasElapsedRealtimeUncertaintyNanos() { throw new RuntimeException("Stub!"); }

/**
 * Gets the estimate of the relative precision of the alignment of the
 * {@link #getElapsedRealtimeNanos()} timestamp, with the reported measurements in
 * nanoseconds (68% confidence).
 *
 * <p>The value is only available if {@link #hasElapsedRealtimeUncertaintyNanos()} is
 * {@code true}.
 
 * @return Value is 0.0f or greater
 * @apiSince 29
 */

public double getElapsedRealtimeUncertaintyNanos() { throw new RuntimeException("Stub!"); }

/**
 * Gets count of hardware clock discontinuities.
 *
 * <p>When this value stays the same, vs. a value in a previously reported {@link android.location.GnssClock GnssClock}, it
 * can be safely assumed that the {@code TimeNanos} value has been derived from a clock that has
 * been running continuously - e.g. a single continuously powered crystal oscillator, and thus
 * the {@code (FullBiasNanos + BiasNanos)} offset can be modelled with traditional clock bias
 * &amp; drift models.
 *
 * <p>Each time this value changes, vs. the value in a previously reported {@link android.location.GnssClock GnssClock},
 * that suggests the hardware clock may have experienced a discontinuity (e.g. a power cycle or
 * other anomaly), so that any assumptions about modelling a smoothly changing
 * {@code (FullBiasNanos + BiasNanos)} offset, and a smoothly growing {@code (TimeNanos)}
 * between this and the previously reported {@code GnssClock}, should be reset.
 * @apiSince 24
 */

public int getHardwareClockDiscontinuityCount() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.location.GnssClock> CREATOR;
static { CREATOR = null; }
}

