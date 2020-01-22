/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.mtp;


/**
 * This class encapsulates information about an MTP device.
 * This corresponds to the DeviceInfo Dataset described in
 * section 5.1.1 of the MTP specification.
 * @apiSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MtpDeviceInfo {

private MtpDeviceInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the manufacturer's name for the MTP device
 *
 * @return the manufacturer name
 
 * This value will never be {@code null}.
 * @apiSince 12
 */

@androidx.annotation.NonNull
public final java.lang.String getManufacturer() { throw new RuntimeException("Stub!"); }

/**
 * Returns the model name for the MTP device
 *
 * @return the model name
 
 * This value will never be {@code null}.
 * @apiSince 12
 */

@androidx.annotation.NonNull
public final java.lang.String getModel() { throw new RuntimeException("Stub!"); }

/**
 * Returns the version string the MTP device
 *
 * @return the device version
 
 * This value will never be {@code null}.
 * @apiSince 12
 */

@androidx.annotation.NonNull
public final java.lang.String getVersion() { throw new RuntimeException("Stub!"); }

/**
 * Returns the unique serial number for the MTP device
 *
 * @return the serial number
 
 * This value will never be {@code null}.
 * @apiSince 12
 */

@androidx.annotation.NonNull
public final java.lang.String getSerialNumber() { throw new RuntimeException("Stub!"); }

/**
 * Returns operation code supported by the device.
 *
 * @return supported operation code. Can be null if device does not provide the property.
 * @see android.mtp.MtpConstants#OPERATION_GET_DEVICE_INFO
 * @see android.mtp.MtpConstants#OPERATION_OPEN_SESSION
 * @see android.mtp.MtpConstants#OPERATION_CLOSE_SESSION
 * @see android.mtp.MtpConstants#OPERATION_GET_STORAGE_I_DS
 * @see android.mtp.MtpConstants#OPERATION_GET_STORAGE_INFO
 * @see android.mtp.MtpConstants#OPERATION_GET_NUM_OBJECTS
 * @see android.mtp.MtpConstants#OPERATION_GET_OBJECT_HANDLES
 * @see android.mtp.MtpConstants#OPERATION_GET_OBJECT_INFO
 * @see android.mtp.MtpConstants#OPERATION_GET_OBJECT
 * @see android.mtp.MtpConstants#OPERATION_GET_THUMB
 * @see android.mtp.MtpConstants#OPERATION_DELETE_OBJECT
 * @see android.mtp.MtpConstants#OPERATION_SEND_OBJECT_INFO
 * @see android.mtp.MtpConstants#OPERATION_SEND_OBJECT
 * @see android.mtp.MtpConstants#OPERATION_INITIATE_CAPTURE
 * @see android.mtp.MtpConstants#OPERATION_FORMAT_STORE
 * @see android.mtp.MtpConstants#OPERATION_RESET_DEVICE
 * @see android.mtp.MtpConstants#OPERATION_SELF_TEST
 * @see android.mtp.MtpConstants#OPERATION_SET_OBJECT_PROTECTION
 * @see android.mtp.MtpConstants#OPERATION_POWER_DOWN
 * @see android.mtp.MtpConstants#OPERATION_GET_DEVICE_PROP_DESC
 * @see android.mtp.MtpConstants#OPERATION_GET_DEVICE_PROP_VALUE
 * @see android.mtp.MtpConstants#OPERATION_SET_DEVICE_PROP_VALUE
 * @see android.mtp.MtpConstants#OPERATION_RESET_DEVICE_PROP_VALUE
 * @see android.mtp.MtpConstants#OPERATION_TERMINATE_OPEN_CAPTURE
 * @see android.mtp.MtpConstants#OPERATION_MOVE_OBJECT
 * @see android.mtp.MtpConstants#OPERATION_COPY_OBJECT
 * @see android.mtp.MtpConstants#OPERATION_GET_PARTIAL_OBJECT
 * @see android.mtp.MtpConstants#OPERATION_INITIATE_OPEN_CAPTURE
 * @see android.mtp.MtpConstants#OPERATION_GET_OBJECT_PROPS_SUPPORTED
 * @see android.mtp.MtpConstants#OPERATION_GET_OBJECT_PROP_DESC
 * @see android.mtp.MtpConstants#OPERATION_GET_OBJECT_PROP_VALUE
 * @see android.mtp.MtpConstants#OPERATION_SET_OBJECT_PROP_VALUE
 * @see android.mtp.MtpConstants#OPERATION_GET_OBJECT_REFERENCES
 * @see android.mtp.MtpConstants#OPERATION_SET_OBJECT_REFERENCES
 * @see android.mtp.MtpConstants#OPERATION_SKIP
 * @apiSince 24
 */

@androidx.annotation.NonNull
public final int[] getOperationsSupported() { throw new RuntimeException("Stub!"); }

/**
 * Returns event code supported by the device.
 *
 * @return supported event code. Can be null if device does not provide the property.
 * @see android.mtp.MtpEvent#EVENT_UNDEFINED
 * @see android.mtp.MtpEvent#EVENT_CANCEL_TRANSACTION
 * @see android.mtp.MtpEvent#EVENT_OBJECT_ADDED
 * @see android.mtp.MtpEvent#EVENT_OBJECT_REMOVED
 * @see android.mtp.MtpEvent#EVENT_STORE_ADDED
 * @see android.mtp.MtpEvent#EVENT_STORE_REMOVED
 * @see android.mtp.MtpEvent#EVENT_DEVICE_PROP_CHANGED
 * @see android.mtp.MtpEvent#EVENT_OBJECT_INFO_CHANGED
 * @see android.mtp.MtpEvent#EVENT_DEVICE_INFO_CHANGED
 * @see android.mtp.MtpEvent#EVENT_REQUEST_OBJECT_TRANSFER
 * @see android.mtp.MtpEvent#EVENT_STORE_FULL
 * @see android.mtp.MtpEvent#EVENT_DEVICE_RESET
 * @see android.mtp.MtpEvent#EVENT_STORAGE_INFO_CHANGED
 * @see android.mtp.MtpEvent#EVENT_CAPTURE_COMPLETE
 * @see android.mtp.MtpEvent#EVENT_UNREPORTED_STATUS
 * @see android.mtp.MtpEvent#EVENT_OBJECT_PROP_CHANGED
 * @see android.mtp.MtpEvent#EVENT_OBJECT_PROP_DESC_CHANGED
 * @see android.mtp.MtpEvent#EVENT_OBJECT_REFERENCES_CHANGED
 * @apiSince 24
 */

@androidx.annotation.NonNull
public final int[] getEventsSupported() { throw new RuntimeException("Stub!"); }

/**
 * Returns if the given operation is supported by the device or not.
 * @param code Operation code.
 * @return If the given operation is supported by the device or not.
 * @apiSince 24
 */

public boolean isOperationSupported(int code) { throw new RuntimeException("Stub!"); }

/**
 * Returns if the given event is supported by the device or not.
 * @param code Event code.
 * @return If the given event is supported by the device or not.
 * @apiSince 24
 */

public boolean isEventSupported(int code) { throw new RuntimeException("Stub!"); }
}

