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


package android.bluetooth.le;

import android.bluetooth.BluetoothDevice;

/**
 * Bluetooth LE scan settings are passed to {@link android.bluetooth.le.BluetoothLeScanner#startScan BluetoothLeScanner#startScan} to define the
 * parameters for the scan.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ScanSettings implements android.os.Parcelable {

private ScanSettings() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int getScanMode() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int getCallbackType() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int getScanResultType() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether only legacy advertisements will be returned.
 * Legacy advertisements include advertisements as specified
 * by the Bluetooth core specification 4.2 and below.
 * @apiSince 26
 */

public boolean getLegacy() { throw new RuntimeException("Stub!"); }

/**
 * Returns the physical layer used during a scan.
 * @apiSince 26
 */

public int getPhy() { throw new RuntimeException("Stub!"); }

/**
 * Returns report delay timestamp based on the device clock.
 * @apiSince 21
 */

public long getReportDelayMillis() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Trigger a callback for every Bluetooth advertisement found that matches the filter criteria.
 * If no filter is active, all advertisement packets are reported.
 * @apiSince 21
 */

public static final int CALLBACK_TYPE_ALL_MATCHES = 1; // 0x1

/**
 * A result callback is only triggered for the first advertisement packet received that matches
 * the filter criteria.
 * @apiSince 23
 */

public static final int CALLBACK_TYPE_FIRST_MATCH = 2; // 0x2

/**
 * Receive a callback when advertisements are no longer received from a device that has been
 * previously reported by a first match callback.
 * @apiSince 23
 */

public static final int CALLBACK_TYPE_MATCH_LOST = 4; // 0x4

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.bluetooth.le.ScanSettings> CREATOR;
static { CREATOR = null; }

/**
 * In Aggressive mode, hw will determine a match sooner even with feeble signal strength
 * and few number of sightings/match in a duration.
 * @apiSince 23
 */

public static final int MATCH_MODE_AGGRESSIVE = 1; // 0x1

/**
 * For sticky mode, higher threshold of signal strength and sightings is required
 * before reporting by hw
 * @apiSince 23
 */

public static final int MATCH_MODE_STICKY = 2; // 0x2

/**
 * Match few advertisement per filter, depends on current capability and availibility of
 * the resources in hw
 * @apiSince 23
 */

public static final int MATCH_NUM_FEW_ADVERTISEMENT = 2; // 0x2

/**
 * Match as many advertisement per filter as hw could allow, depends on current
 * capability and availibility of the resources in hw
 * @apiSince 23
 */

public static final int MATCH_NUM_MAX_ADVERTISEMENT = 3; // 0x3

/**
 * Match one advertisement per filter
 * @apiSince 23
 */

public static final int MATCH_NUM_ONE_ADVERTISEMENT = 1; // 0x1

/**
 * Use all supported PHYs for scanning.
 * This will check the controller capabilities, and start
 * the scan on 1Mbit and LE Coded PHYs if supported, or on
 * the 1Mbit PHY only.
 * @apiSince 26
 */

public static final int PHY_LE_ALL_SUPPORTED = 255; // 0xff

/**
 * Perform Bluetooth LE scan in balanced power mode. Scan results are returned at a rate that
 * provides a good trade-off between scan frequency and power consumption.
 * @apiSince 21
 */

public static final int SCAN_MODE_BALANCED = 1; // 0x1

/**
 * Scan using highest duty cycle. It's recommended to only use this mode when the application is
 * running in the foreground.
 * @apiSince 21
 */

public static final int SCAN_MODE_LOW_LATENCY = 2; // 0x2

/**
 * Perform Bluetooth LE scan in low power mode. This is the default scan mode as it consumes the
 * least power. This mode is enforced if the scanning application is not in foreground.
 * @apiSince 21
 */

public static final int SCAN_MODE_LOW_POWER = 0; // 0x0

/**
 * A special Bluetooth LE scan mode. Applications using this scan mode will passively listen for
 * other scan results without starting BLE scans themselves.
 * @apiSince 23
 */

public static final int SCAN_MODE_OPPORTUNISTIC = -1; // 0xffffffff
/**
 * Builder for {@link android.bluetooth.le.ScanSettings ScanSettings}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Set scan mode for Bluetooth LE scan.
 *
 * @param scanMode The scan mode can be one of {@link android.bluetooth.le.ScanSettings#SCAN_MODE_LOW_POWER ScanSettings#SCAN_MODE_LOW_POWER},
 * {@link android.bluetooth.le.ScanSettings#SCAN_MODE_BALANCED ScanSettings#SCAN_MODE_BALANCED} or {@link android.bluetooth.le.ScanSettings#SCAN_MODE_LOW_LATENCY ScanSettings#SCAN_MODE_LOW_LATENCY}.
 * @throws java.lang.IllegalArgumentException If the {@code scanMode} is invalid.
 * @apiSince 21
 */

public android.bluetooth.le.ScanSettings.Builder setScanMode(int scanMode) { throw new RuntimeException("Stub!"); }

/**
 * Set callback type for Bluetooth LE scan.
 *
 * @param callbackType The callback type flags for the scan.
 * @throws java.lang.IllegalArgumentException If the {@code callbackType} is invalid.
 * @apiSince 23
 */

public android.bluetooth.le.ScanSettings.Builder setCallbackType(int callbackType) { throw new RuntimeException("Stub!"); }

/**
 * Set report delay timestamp for Bluetooth LE scan.
 *
 * @param reportDelayMillis Delay of report in milliseconds. Set to 0 to be notified of
 * results immediately. Values &gt; 0 causes the scan results to be queued up and delivered
 * after the requested delay or when the internal buffers fill up.
 * @throws java.lang.IllegalArgumentException If {@code reportDelayMillis} &lt; 0.
 * @apiSince 21
 */

public android.bluetooth.le.ScanSettings.Builder setReportDelay(long reportDelayMillis) { throw new RuntimeException("Stub!"); }

/**
 * Set the number of matches for Bluetooth LE scan filters hardware match
 *
 * @param numOfMatches The num of matches can be one of
 * {@link android.bluetooth.le.ScanSettings#MATCH_NUM_ONE_ADVERTISEMENT ScanSettings#MATCH_NUM_ONE_ADVERTISEMENT}
 * or {@link android.bluetooth.le.ScanSettings#MATCH_NUM_FEW_ADVERTISEMENT ScanSettings#MATCH_NUM_FEW_ADVERTISEMENT} or {@link android.bluetooth.le.ScanSettings#MATCH_NUM_MAX_ADVERTISEMENT ScanSettings#MATCH_NUM_MAX_ADVERTISEMENT}
 * @throws java.lang.IllegalArgumentException If the {@code matchMode} is invalid.
 * @apiSince 23
 */

public android.bluetooth.le.ScanSettings.Builder setNumOfMatches(int numOfMatches) { throw new RuntimeException("Stub!"); }

/**
 * Set match mode for Bluetooth LE scan filters hardware match
 *
 * @param matchMode The match mode can be one of {@link android.bluetooth.le.ScanSettings#MATCH_MODE_AGGRESSIVE ScanSettings#MATCH_MODE_AGGRESSIVE}
 * or {@link android.bluetooth.le.ScanSettings#MATCH_MODE_STICKY ScanSettings#MATCH_MODE_STICKY}
 * @throws java.lang.IllegalArgumentException If the {@code matchMode} is invalid.
 * @apiSince 23
 */

public android.bluetooth.le.ScanSettings.Builder setMatchMode(int matchMode) { throw new RuntimeException("Stub!"); }

/**
 * Set whether only legacy advertisments should be returned in scan results.
 * Legacy advertisements include advertisements as specified by the
 * Bluetooth core specification 4.2 and below. This is true by default
 * for compatibility with older apps.
 *
 * @param legacy true if only legacy advertisements will be returned
 * @apiSince 26
 */

public android.bluetooth.le.ScanSettings.Builder setLegacy(boolean legacy) { throw new RuntimeException("Stub!"); }

/**
 * Set the Physical Layer to use during this scan.
 * This is used only if {@link android.bluetooth.le.ScanSettings.Builder#setLegacy ScanSettings.Builder#setLegacy}
 * is set to false.
 * {@link android.bluetooth.BluetoothAdapter#isLeCodedPhySupported}
 * may be used to check whether LE Coded phy is supported by calling
 * {@link android.bluetooth.BluetoothAdapter#isLeCodedPhySupported}.
 * Selecting an unsupported phy will result in failure to start scan.
 *
 * @param phy Can be one of {@link android.bluetooth.BluetoothDevice#PHY_LE_1M BluetoothDevice#PHY_LE_1M}, {@link android.bluetooth.BluetoothDevice#PHY_LE_CODED BluetoothDevice#PHY_LE_CODED} or {@link android.bluetooth.le.ScanSettings#PHY_LE_ALL_SUPPORTED ScanSettings#PHY_LE_ALL_SUPPORTED}
 * @apiSince 26
 */

public android.bluetooth.le.ScanSettings.Builder setPhy(int phy) { throw new RuntimeException("Stub!"); }

/**
 * Build {@link android.bluetooth.le.ScanSettings ScanSettings}.
 * @apiSince 21
 */

public android.bluetooth.le.ScanSettings build() { throw new RuntimeException("Stub!"); }
}

}

