/*
 * Copyright (C) 2011 The Android Open Source Project
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



package android.bluetooth;


/**
 * The Bluetooth Health Application Configuration that is used in conjunction with
 * the {@link android.bluetooth.BluetoothHealth BluetoothHealth} class. This class represents an application configuration
 * that the Bluetooth Health third party application will register to communicate with the
 * remote Bluetooth health device.
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 * @apiSince 14
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public final class BluetoothHealthAppConfiguration implements android.os.Parcelable {

BluetoothHealthAppConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Return the data type associated with this application configuration.
 *
 * @return dataType
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public int getDataType() { throw new RuntimeException("Stub!"); }

/**
 * Return the name of the application configuration.
 *
 * @return String name
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Return the role associated with this application configuration.
 *
 * @return One of {@link android.bluetooth.BluetoothHealth#SOURCE_ROLE BluetoothHealth#SOURCE_ROLE} or {@link android.bluetooth.BluetoothHealth#SINK_ROLE BluetoothHealth#SINK_ROLE}
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public int getRole() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated @androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.bluetooth.BluetoothHealthAppConfiguration> CREATOR;
static { CREATOR = null; }
}

