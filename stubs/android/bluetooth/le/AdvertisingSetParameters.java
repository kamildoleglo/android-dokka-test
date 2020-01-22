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

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothAdapter;

/**
 * The {@link android.bluetooth.le.AdvertisingSetParameters AdvertisingSetParameters} provide a way to adjust advertising
 * preferences for each
 * Bluetooth LE advertising set. Use {@link android.bluetooth.le.AdvertisingSetParameters.Builder AdvertisingSetParameters.Builder} to
 * create an
 * instance of this class.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AdvertisingSetParameters implements android.os.Parcelable {

private AdvertisingSetParameters() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the advertisement will be connectable.
 * @apiSince 26
 */

public boolean isConnectable() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the advertisement will be scannable.
 * @apiSince 26
 */

public boolean isScannable() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the legacy advertisement will be used.
 * @apiSince 26
 */

public boolean isLegacy() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the advertisement will be anonymous.
 * @apiSince 26
 */

public boolean isAnonymous() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the TX Power will be included.
 * @apiSince 26
 */

public boolean includeTxPower() { throw new RuntimeException("Stub!"); }

/**
 * Returns the primary advertising phy.
 * @apiSince 26
 */

public int getPrimaryPhy() { throw new RuntimeException("Stub!"); }

/**
 * Returns the secondary advertising phy.
 * @apiSince 26
 */

public int getSecondaryPhy() { throw new RuntimeException("Stub!"); }

/**
 * Returns the advertising interval.
 * @apiSince 26
 */

public int getInterval() { throw new RuntimeException("Stub!"); }

/**
 * Returns the TX power level for advertising.
 * @apiSince 26
 */

public int getTxPowerLevel() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.bluetooth.le.AdvertisingSetParameters> CREATOR;
static { CREATOR = null; }

/**
 * Advertise on low frequency, around every 1000ms. This is the default and
 * preferred advertising mode as it consumes the least power.
 * @apiSince 26
 */

public static final int INTERVAL_HIGH = 1600; // 0x640

/**
 * Perform high frequency, low latency advertising, around every 100ms. This
 * has the highest power consumption and should not be used for continuous
 * background advertising.
 * @apiSince 26
 */

public static final int INTERVAL_LOW = 160; // 0xa0

/**
 * Maximum value for advertising interval.
 * @apiSince 26
 */

public static final int INTERVAL_MAX = 16777215; // 0xffffff

/**
 * Advertise on medium frequency, around every 250ms. This is balanced
 * between advertising frequency and power consumption.
 * @apiSince 26
 */

public static final int INTERVAL_MEDIUM = 400; // 0x190

/**
 * Minimum value for advertising interval.
 * @apiSince 26
 */

public static final int INTERVAL_MIN = 160; // 0xa0

/**
 * Advertise using high TX power level. This corresponds to largest visibility
 * range of the advertising packet.
 * @apiSince 26
 */

public static final int TX_POWER_HIGH = 1; // 0x1

/**
 * Advertise using low TX power level.
 * @apiSince 26
 */

public static final int TX_POWER_LOW = -15; // 0xfffffff1

/**
 * Maximum value for TX power.
 * @apiSince 26
 */

public static final int TX_POWER_MAX = 1; // 0x1

/**
 * Advertise using medium TX power level.
 * @apiSince 26
 */

public static final int TX_POWER_MEDIUM = -7; // 0xfffffff9

/**
 * Minimum value for TX power.
 * @apiSince 26
 */

public static final int TX_POWER_MIN = -127; // 0xffffff81

/**
 * Advertise using the lowest transmission (TX) power level. Low transmission
 * power can be used to restrict the visibility range of advertising packets.
 * @apiSince 26
 */

public static final int TX_POWER_ULTRA_LOW = -21; // 0xffffffeb
/**
 * Builder class for {@link android.bluetooth.le.AdvertisingSetParameters AdvertisingSetParameters}.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Set whether the advertisement type should be connectable or
 * non-connectable.
 * Legacy advertisements can be both connectable and scannable. Non-legacy
 * advertisements can be only scannable or only connectable.
 *
 * @param connectable Controls whether the advertisement type will be connectable (true) or
 * non-connectable (false).
 * @apiSince 26
 */

public android.bluetooth.le.AdvertisingSetParameters.Builder setConnectable(boolean connectable) { throw new RuntimeException("Stub!"); }

/**
 * Set whether the advertisement type should be scannable.
 * Legacy advertisements can be both connectable and scannable. Non-legacy
 * advertisements can be only scannable or only connectable.
 *
 * @param scannable Controls whether the advertisement type will be scannable (true) or
 * non-scannable (false).
 * @apiSince 26
 */

public android.bluetooth.le.AdvertisingSetParameters.Builder setScannable(boolean scannable) { throw new RuntimeException("Stub!"); }

/**
 * When set to true, advertising set will advertise 4.x Spec compliant
 * advertisements.
 *
 * @param isLegacy whether legacy advertising mode should be used.
 * @apiSince 26
 */

public android.bluetooth.le.AdvertisingSetParameters.Builder setLegacyMode(boolean isLegacy) { throw new RuntimeException("Stub!"); }

/**
 * Set whether advertiser address should be ommited from all packets. If this
 * mode is used, periodic advertising can't be enabled for this set.
 *
 * This is used only if legacy mode is not used.
 *
 * @param isAnonymous whether anonymous advertising should be used.
 * @apiSince 26
 */

public android.bluetooth.le.AdvertisingSetParameters.Builder setAnonymous(boolean isAnonymous) { throw new RuntimeException("Stub!"); }

/**
 * Set whether TX power should be included in the extended header.
 *
 * This is used only if legacy mode is not used.
 *
 * @param includeTxPower whether TX power should be included in extended header
 * @apiSince 26
 */

public android.bluetooth.le.AdvertisingSetParameters.Builder setIncludeTxPower(boolean includeTxPower) { throw new RuntimeException("Stub!"); }

/**
 * Set the primary physical channel used for this advertising set.
 *
 * This is used only if legacy mode is not used.
 *
 * Use {@link android.bluetooth.BluetoothAdapter#isLeCodedPhySupported BluetoothAdapter#isLeCodedPhySupported} to determine if LE Coded PHY is
 * supported on this device.
 *
 * @param primaryPhy Primary advertising physical channel, can only be {@link android.bluetooth.BluetoothDevice#PHY_LE_1M BluetoothDevice#PHY_LE_1M} or {@link android.bluetooth.BluetoothDevice#PHY_LE_CODED BluetoothDevice#PHY_LE_CODED}.
 * @throws java.lang.IllegalArgumentException If the primaryPhy is invalid.
 * @apiSince 26
 */

public android.bluetooth.le.AdvertisingSetParameters.Builder setPrimaryPhy(int primaryPhy) { throw new RuntimeException("Stub!"); }

/**
 * Set the secondary physical channel used for this advertising set.
 *
 * This is used only if legacy mode is not used.
 *
 * Use {@link android.bluetooth.BluetoothAdapter#isLeCodedPhySupported BluetoothAdapter#isLeCodedPhySupported} and
 * {@link android.bluetooth.BluetoothAdapter#isLe2MPhySupported BluetoothAdapter#isLe2MPhySupported} to determine if LE Coded PHY or 2M PHY is
 * supported on this device.
 *
 * @param secondaryPhy Secondary advertising physical channel, can only be one of {@link android.bluetooth.BluetoothDevice#PHY_LE_1M BluetoothDevice#PHY_LE_1M}, {@link android.bluetooth.BluetoothDevice#PHY_LE_2M BluetoothDevice#PHY_LE_2M} or {@link android.bluetooth.BluetoothDevice#PHY_LE_CODED BluetoothDevice#PHY_LE_CODED}.
 * @throws java.lang.IllegalArgumentException If the secondaryPhy is invalid.
 * @apiSince 26
 */

public android.bluetooth.le.AdvertisingSetParameters.Builder setSecondaryPhy(int secondaryPhy) { throw new RuntimeException("Stub!"); }

/**
 * Set advertising interval.
 *
 * @param interval Bluetooth LE Advertising interval, in 0.625ms unit. Valid range is from
 * 160 (100ms) to 16777215 (10,485.759375 s). Recommended values are: {@link android.bluetooth.le.AdvertisingSetParameters#INTERVAL_LOW AdvertisingSetParameters#INTERVAL_LOW}, {@link android.bluetooth.le.AdvertisingSetParameters#INTERVAL_MEDIUM AdvertisingSetParameters#INTERVAL_MEDIUM},
 * or {@link android.bluetooth.le.AdvertisingSetParameters#INTERVAL_HIGH AdvertisingSetParameters#INTERVAL_HIGH}.
 * @throws java.lang.IllegalArgumentException If the interval is invalid.
 * @apiSince 26
 */

public android.bluetooth.le.AdvertisingSetParameters.Builder setInterval(int interval) { throw new RuntimeException("Stub!"); }

/**
 * Set the transmission power level for the advertising.
 *
 * @param txPowerLevel Transmission power of Bluetooth LE Advertising, in dBm. The valid
 * range is [-127, 1] Recommended values are:
 * {@link android.bluetooth.le.AdvertisingSetParameters#TX_POWER_ULTRA_LOW AdvertisingSetParameters#TX_POWER_ULTRA_LOW},
 * {@link android.bluetooth.le.AdvertisingSetParameters#TX_POWER_LOW AdvertisingSetParameters#TX_POWER_LOW},
 * {@link android.bluetooth.le.AdvertisingSetParameters#TX_POWER_MEDIUM AdvertisingSetParameters#TX_POWER_MEDIUM},
 * or {@link android.bluetooth.le.AdvertisingSetParameters#TX_POWER_HIGH AdvertisingSetParameters#TX_POWER_HIGH}.
 * @throws java.lang.IllegalArgumentException If the {@code txPowerLevel} is invalid.
 * @apiSince 26
 */

public android.bluetooth.le.AdvertisingSetParameters.Builder setTxPowerLevel(int txPowerLevel) { throw new RuntimeException("Stub!"); }

/**
 * Build the {@link android.bluetooth.le.AdvertisingSetParameters AdvertisingSetParameters} object.
 *
 * @throws java.lang.IllegalStateException if invalid combination of parameters is used.
 * @apiSince 26
 */

public android.bluetooth.le.AdvertisingSetParameters build() { throw new RuntimeException("Stub!"); }
}

}

