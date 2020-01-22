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
import android.bluetooth.le.ScanRecord;

/**
 * A filter for Bluetooth LE devices
 *
 * @see android.bluetooth.le.ScanFilter
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothLeDeviceFilter implements android.companion.DeviceFilter<android.bluetooth.le.ScanResult> {

private BluetoothLeDeviceFilter() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public static int getRenamePrefixLengthLimit() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.companion.BluetoothLeDeviceFilter> CREATOR;
static { CREATOR = null; }
/**
 * Builder for {@link android.companion.BluetoothLeDeviceFilter BluetoothLeDeviceFilter}
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

public android.companion.BluetoothLeDeviceFilter.Builder setNamePattern(@androidx.annotation.Nullable java.util.regex.Pattern regex) { throw new RuntimeException("Stub!"); }

/**
 * @param scanFilter a {@link android.bluetooth.le.ScanFilter ScanFilter} to filter devices by
 *
 * This value may be {@code null}.
 * @return self for chaining
 * This value will never be {@code null}.
 * @see android.bluetooth.le.ScanFilter for specific details on its various fields
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.companion.BluetoothLeDeviceFilter.Builder setScanFilter(@androidx.annotation.Nullable android.bluetooth.le.ScanFilter scanFilter) { throw new RuntimeException("Stub!"); }

/**
 * Filter devices by raw advertisement data, as obtained by {@link android.bluetooth.le.ScanRecord#getBytes ScanRecord#getBytes}
 *
 * @param rawDataFilter bit values that have to match against advertized data
 * This value must never be {@code null}.
 * @param rawDataFilterMask bits that have to be matched
 * This value may be {@code null}.
 * @return self for chaining
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.companion.BluetoothLeDeviceFilter.Builder setRawDataFilter(@androidx.annotation.NonNull byte[] rawDataFilter, @androidx.annotation.Nullable byte[] rawDataFilterMask) { throw new RuntimeException("Stub!"); }

/**
 * Rename the devices shown in the list, using specific bytes from the raw advertisement
 * data ({@link android.bluetooth.le.ScanRecord#getBytes ScanRecord#getBytes}) in hexadecimal format, as well as a custom
 * prefix/suffix around them
 *
 * Note that the prefix length is limited to {@link #getRenamePrefixLengthLimit} characters
 * to ensure that there's enough space to display the byte data
 *
 * The range of bytes to be displayed cannot be empty
 *
 * @param prefix to be displayed before the byte data
 * This value must never be {@code null}.
 * @param suffix to be displayed after the byte data
 * This value must never be {@code null}.
 * @param bytesFrom the start byte index to be displayed (inclusive)
 * @param bytesLength the number of bytes to be displayed from the given index
 * @param byteOrder whether the given range of bytes is big endian (will be displayed
 *                   in same order) or little endian (will be flipped before displaying)
 * @return self for chaining
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.companion.BluetoothLeDeviceFilter.Builder setRenameFromBytes(@androidx.annotation.NonNull java.lang.String prefix, @androidx.annotation.NonNull java.lang.String suffix, int bytesFrom, int bytesLength, java.nio.ByteOrder byteOrder) { throw new RuntimeException("Stub!"); }

/**
 * Rename the devices shown in the list, using specific characters from the advertised name,
 * as well as a custom prefix/suffix around them
 *
 * Note that the prefix length is limited to {@link #getRenamePrefixLengthLimit} characters
 * to ensure that there's enough space to display the byte data
 *
 * The range of name characters to be displayed cannot be empty
 *
 * @param prefix to be displayed before the byte data
 * This value must never be {@code null}.
 * @param suffix to be displayed after the byte data
 * This value must never be {@code null}.
 * @param nameFrom the start name character index to be displayed (inclusive)
 * @param nameLength the number of characters to be displayed from the given index
 * @return self for chaining
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.companion.BluetoothLeDeviceFilter.Builder setRenameFromName(@androidx.annotation.NonNull java.lang.String prefix, @androidx.annotation.NonNull java.lang.String suffix, int nameFrom, int nameLength) { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.companion.BluetoothLeDeviceFilter build() { throw new RuntimeException("Stub!"); }
}

}

