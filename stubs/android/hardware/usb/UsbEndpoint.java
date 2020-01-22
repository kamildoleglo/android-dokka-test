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


package android.hardware.usb;


/**
 * A class representing an endpoint on a {@link android.hardware.usb.UsbInterface UsbInterface}.
 * Endpoints are the channels for sending and receiving data over USB.
 * Typically bulk endpoints are used for sending non-trivial amounts of data.
 * Interrupt endpoints are used for sending small amounts of data, typically events,
 * separately from the main data streams.
 * The endpoint zero is a special endpoint for control messages sent from the host
 * to device.
 * Isochronous endpoints are currently unsupported.
 * @apiSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UsbEndpoint implements android.os.Parcelable {

UsbEndpoint() { throw new RuntimeException("Stub!"); }

/**
 * Returns the endpoint's address field.
 * The address is a bitfield containing both the endpoint number
 * as well as the data direction of the endpoint.
 * the endpoint number and direction can also be accessed via
 * {@link #getEndpointNumber} and {@link #getDirection}.
 *
 * @return the endpoint's address
 * @apiSince 12
 */

public int getAddress() { throw new RuntimeException("Stub!"); }

/**
 * Extracts the endpoint's endpoint number from its address
 *
 * @return the endpoint's endpoint number
 * @apiSince 12
 */

public int getEndpointNumber() { throw new RuntimeException("Stub!"); }

/**
 * Returns the endpoint's direction.
 * Returns {@link android.hardware.usb.UsbConstants#USB_DIR_OUT UsbConstants#USB_DIR_OUT}
 * if the direction is host to device, and
 * {@link android.hardware.usb.UsbConstants#USB_DIR_IN UsbConstants#USB_DIR_IN} if the
 * direction is device to host.
 * @see android.hardware.usb.UsbConstants#USB_DIR_IN
 * @see android.hardware.usb.UsbConstants#USB_DIR_OUT
 *
 * @return the endpoint's direction
 * @apiSince 12
 */

public int getDirection() { throw new RuntimeException("Stub!"); }

/**
 * Returns the endpoint's attributes field.
 *
 * @return the endpoint's attributes
 * @apiSince 12
 */

public int getAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Returns the endpoint's type.
 * Possible results are:
 * <ul>
 * <li>{@link android.hardware.usb.UsbConstants#USB_ENDPOINT_XFER_CONTROL UsbConstants#USB_ENDPOINT_XFER_CONTROL} (endpoint zero)
 * <li>{@link android.hardware.usb.UsbConstants#USB_ENDPOINT_XFER_ISOC UsbConstants#USB_ENDPOINT_XFER_ISOC} (isochronous endpoint)
 * <li>{@link android.hardware.usb.UsbConstants#USB_ENDPOINT_XFER_BULK UsbConstants#USB_ENDPOINT_XFER_BULK} (bulk endpoint)
 * <li>{@link android.hardware.usb.UsbConstants#USB_ENDPOINT_XFER_INT UsbConstants#USB_ENDPOINT_XFER_INT} (interrupt endpoint)
 * </ul>
 *
 * @return the endpoint's type
 * @apiSince 12
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the endpoint's maximum packet size.
 *
 * @return the endpoint's maximum packet size
 * @apiSince 12
 */

public int getMaxPacketSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the endpoint's interval field.
 *
 * @return the endpoint's interval
 * @apiSince 12
 */

public int getInterval() { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.hardware.usb.UsbEndpoint> CREATOR;
static { CREATOR = null; }
}

