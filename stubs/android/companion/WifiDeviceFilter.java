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


package android.companion;

import android.bluetooth.le.ScanFilter;
import android.bluetooth.BluetoothDevice;

/**
 * A filter for Wifi devices
 *
 * @see android.bluetooth.le.ScanFilter
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class WifiDeviceFilter implements android.companion.DeviceFilter<android.net.wifi.ScanResult> {

private WifiDeviceFilter() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.companion.WifiDeviceFilter> CREATOR;
static { CREATOR = null; }
/**
 * Builder for {@link android.companion.WifiDeviceFilter WifiDeviceFilter}
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * @param regex if set, only devices with {@link android.bluetooth.BluetoothDevice#getName BluetoothDevice#getName} matching the
 *              given regular expression will be shown
 * This value may be {@code null}.
 * @return self for chaining
 * @apiSince 26
 */

public android.companion.WifiDeviceFilter.Builder setNamePattern(@androidx.annotation.Nullable java.util.regex.Pattern regex) { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.companion.WifiDeviceFilter build() { throw new RuntimeException("Stub!"); }
}

}

