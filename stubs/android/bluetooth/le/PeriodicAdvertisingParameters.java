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


package android.bluetooth.le;


/**
 * The {@link android.bluetooth.le.PeriodicAdvertisingParameters PeriodicAdvertisingParameters} provide a way to adjust periodic
 * advertising preferences for each Bluetooth LE advertising set. Use {@link android.bluetooth.le.AdvertisingSetParameters.Builder AdvertisingSetParameters.Builder} to create an instance of this class.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PeriodicAdvertisingParameters implements android.os.Parcelable {

private PeriodicAdvertisingParameters() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the TX Power will be included.
 * @apiSince 26
 */

public boolean getIncludeTxPower() { throw new RuntimeException("Stub!"); }

/**
 * Returns the periodic advertising interval, in 1.25ms unit.
 * Valid values are from 80 (100ms) to 65519 (81.89875s).
 * @apiSince 26
 */

public int getInterval() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public static final android.os.Parcelable.Creator<android.bluetooth.le.PeriodicAdvertisingParameters> CREATOR;
static { CREATOR = null; }
/** @apiSince 26 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Whether the transmission power level should be included in the periodic
 * packet.
 * @apiSince 26
 */

public android.bluetooth.le.PeriodicAdvertisingParameters.Builder setIncludeTxPower(boolean includeTxPower) { throw new RuntimeException("Stub!"); }

/**
 * Set advertising interval for periodic advertising, in 1.25ms unit.
 * Valid values are from 80 (100ms) to 65519 (81.89875s).
 * Value from range [interval, interval+20ms] will be picked as the actual value.
 *
 * @throws java.lang.IllegalArgumentException If the interval is invalid.
 * @apiSince 26
 */

public android.bluetooth.le.PeriodicAdvertisingParameters.Builder setInterval(int interval) { throw new RuntimeException("Stub!"); }

/**
 * Build the {@link android.bluetooth.le.AdvertisingSetParameters AdvertisingSetParameters} object.
 * @apiSince 26
 */

public android.bluetooth.le.PeriodicAdvertisingParameters build() { throw new RuntimeException("Stub!"); }
}

}

