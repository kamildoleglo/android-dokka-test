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


package android.bluetooth;


/**
 * This abstract class is used to implement {@link android.bluetooth.BluetoothGattServer BluetoothGattServer} callbacks.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class BluetoothGattServerCallback {

public BluetoothGattServerCallback() { throw new RuntimeException("Stub!"); }

/**
 * Callback indicating when a remote device has been connected or disconnected.
 *
 * @param device Remote device that has been connected or disconnected.
 * @param status Status of the connect or disconnect operation.
 * @param newState Returns the new connection state. Can be one of {@link android.bluetooth.BluetoothProfile#STATE_DISCONNECTED BluetoothProfile#STATE_DISCONNECTED} or {@link android.bluetooth.BluetoothProfile#STATE_CONNECTED BluetoothProfile#STATE_CONNECTED}
 * @apiSince 18
 */

public void onConnectionStateChange(android.bluetooth.BluetoothDevice device, int status, int newState) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether a local service has been added successfully.
 *
 * @param status Returns {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS BluetoothGatt#GATT_SUCCESS} if the service was added
 * successfully.
 * @param service The service that has been added
 * @apiSince 18
 */

public void onServiceAdded(int status, android.bluetooth.BluetoothGattService service) { throw new RuntimeException("Stub!"); }

/**
 * A remote client has requested to read a local characteristic.
 *
 * <p>An application must call {@link android.bluetooth.BluetoothGattServer#sendResponse BluetoothGattServer#sendResponse}
 * to complete the request.
 *
 * @param device The remote device that has requested the read operation
 * @param requestId The Id of the request
 * @param offset Offset into the value of the characteristic
 * @param characteristic Characteristic to be read
 * @apiSince 18
 */

public void onCharacteristicReadRequest(android.bluetooth.BluetoothDevice device, int requestId, int offset, android.bluetooth.BluetoothGattCharacteristic characteristic) { throw new RuntimeException("Stub!"); }

/**
 * A remote client has requested to write to a local characteristic.
 *
 * <p>An application must call {@link android.bluetooth.BluetoothGattServer#sendResponse BluetoothGattServer#sendResponse}
 * to complete the request.
 *
 * @param device The remote device that has requested the write operation
 * @param requestId The Id of the request
 * @param characteristic Characteristic to be written to.
 * @param preparedWrite true, if this write operation should be queued for later execution.
 * @param responseNeeded true, if the remote device requires a response
 * @param offset The offset given for the value
 * @param value The value the client wants to assign to the characteristic
 * @apiSince 18
 */

public void onCharacteristicWriteRequest(android.bluetooth.BluetoothDevice device, int requestId, android.bluetooth.BluetoothGattCharacteristic characteristic, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) { throw new RuntimeException("Stub!"); }

/**
 * A remote client has requested to read a local descriptor.
 *
 * <p>An application must call {@link android.bluetooth.BluetoothGattServer#sendResponse BluetoothGattServer#sendResponse}
 * to complete the request.
 *
 * @param device The remote device that has requested the read operation
 * @param requestId The Id of the request
 * @param offset Offset into the value of the characteristic
 * @param descriptor Descriptor to be read
 * @apiSince 18
 */

public void onDescriptorReadRequest(android.bluetooth.BluetoothDevice device, int requestId, int offset, android.bluetooth.BluetoothGattDescriptor descriptor) { throw new RuntimeException("Stub!"); }

/**
 * A remote client has requested to write to a local descriptor.
 *
 * <p>An application must call {@link android.bluetooth.BluetoothGattServer#sendResponse BluetoothGattServer#sendResponse}
 * to complete the request.
 *
 * @param device The remote device that has requested the write operation
 * @param requestId The Id of the request
 * @param descriptor Descriptor to be written to.
 * @param preparedWrite true, if this write operation should be queued for later execution.
 * @param responseNeeded true, if the remote device requires a response
 * @param offset The offset given for the value
 * @param value The value the client wants to assign to the descriptor
 * @apiSince 18
 */

public void onDescriptorWriteRequest(android.bluetooth.BluetoothDevice device, int requestId, android.bluetooth.BluetoothGattDescriptor descriptor, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) { throw new RuntimeException("Stub!"); }

/**
 * Execute all pending write operations for this device.
 *
 * <p>An application must call {@link android.bluetooth.BluetoothGattServer#sendResponse BluetoothGattServer#sendResponse}
 * to complete the request.
 *
 * @param device The remote device that has requested the write operations
 * @param requestId The Id of the request
 * @param execute Whether the pending writes should be executed (true) or cancelled (false)
 * @apiSince 18
 */

public void onExecuteWrite(android.bluetooth.BluetoothDevice device, int requestId, boolean execute) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when a notification or indication has been sent to
 * a remote device.
 *
 * <p>When multiple notifications are to be sent, an application must
 * wait for this callback to be received before sending additional
 * notifications.
 *
 * @param device The remote device the notification has been sent to
 * @param status {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS BluetoothGatt#GATT_SUCCESS} if the operation was successful
 * @apiSince 21
 */

public void onNotificationSent(android.bluetooth.BluetoothDevice device, int status) { throw new RuntimeException("Stub!"); }

/**
 * Callback indicating the MTU for a given device connection has changed.
 *
 * <p>This callback will be invoked if a remote client has requested to change
 * the MTU for a given connection.
 *
 * @param device The remote device that requested the MTU change
 * @param mtu The new MTU size
 * @apiSince 22
 */

public void onMtuChanged(android.bluetooth.BluetoothDevice device, int mtu) { throw new RuntimeException("Stub!"); }

/**
 * Callback triggered as result of {@link android.bluetooth.BluetoothGattServer#setPreferredPhy BluetoothGattServer#setPreferredPhy}, or as a result
 * of remote device changing the PHY.
 *
 * @param device The remote device
 * @param txPhy the transmitter PHY in use. One of {@link android.bluetooth.BluetoothDevice#PHY_LE_1M BluetoothDevice#PHY_LE_1M}, {@link android.bluetooth.BluetoothDevice#PHY_LE_2M BluetoothDevice#PHY_LE_2M}, and {@link android.bluetooth.BluetoothDevice#PHY_LE_CODED BluetoothDevice#PHY_LE_CODED}
 * @param rxPhy the receiver PHY in use. One of {@link android.bluetooth.BluetoothDevice#PHY_LE_1M BluetoothDevice#PHY_LE_1M}, {@link android.bluetooth.BluetoothDevice#PHY_LE_2M BluetoothDevice#PHY_LE_2M}, and {@link android.bluetooth.BluetoothDevice#PHY_LE_CODED BluetoothDevice#PHY_LE_CODED}
 * @param status Status of the PHY update operation. {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS BluetoothGatt#GATT_SUCCESS} if the
 * operation succeeds.
 * @apiSince 26
 */

public void onPhyUpdate(android.bluetooth.BluetoothDevice device, int txPhy, int rxPhy, int status) { throw new RuntimeException("Stub!"); }

/**
 * Callback triggered as result of {@link android.bluetooth.BluetoothGattServer#readPhy BluetoothGattServer#readPhy}
 *
 * @param device The remote device that requested the PHY read
 * @param txPhy the transmitter PHY in use. One of {@link android.bluetooth.BluetoothDevice#PHY_LE_1M BluetoothDevice#PHY_LE_1M}, {@link android.bluetooth.BluetoothDevice#PHY_LE_2M BluetoothDevice#PHY_LE_2M}, and {@link android.bluetooth.BluetoothDevice#PHY_LE_CODED BluetoothDevice#PHY_LE_CODED}
 * @param rxPhy the receiver PHY in use. One of {@link android.bluetooth.BluetoothDevice#PHY_LE_1M BluetoothDevice#PHY_LE_1M}, {@link android.bluetooth.BluetoothDevice#PHY_LE_2M BluetoothDevice#PHY_LE_2M}, and {@link android.bluetooth.BluetoothDevice#PHY_LE_CODED BluetoothDevice#PHY_LE_CODED}
 * @param status Status of the PHY read operation. {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS BluetoothGatt#GATT_SUCCESS} if the
 * operation succeeds.
 * @apiSince 26
 */

public void onPhyRead(android.bluetooth.BluetoothDevice device, int txPhy, int rxPhy, int status) { throw new RuntimeException("Stub!"); }
}

