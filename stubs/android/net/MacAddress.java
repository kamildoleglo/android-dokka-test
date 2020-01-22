/*
 * Copyright 2017 The Android Open Source Project
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


package android.net;

import java.net.Inet6Address;

/**
 * Representation of a MAC address.
 *
 * This class only supports 48 bits long addresses and does not support 64 bits long addresses.
 * Instances of this class are immutable.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MacAddress implements android.os.Parcelable {

private MacAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of this address.
 *
 * @return the int constant representing the MAC address type of this MacAddress.
 
 * Value is android.net.MacAddress.TYPE_UNKNOWN, {@link android.net.MacAddress#TYPE_UNICAST}, {@link android.net.MacAddress#TYPE_MULTICAST}, or {@link android.net.MacAddress#TYPE_BROADCAST}
 * @apiSince 28
 */

public int getAddressType() { throw new RuntimeException("Stub!"); }

/**
 * @return true if this MacAddress is a locally assigned address.
 * @apiSince 28
 */

public boolean isLocallyAssigned() { throw new RuntimeException("Stub!"); }

/**
 * @return a byte array representation of this MacAddress.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public byte[] toByteArray() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * @return a String representation of the OUI part of this MacAddress made of 3 hexadecimal
 * numbers in [0,ff] joined by ':' characters.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.lang.String toOuiString() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Creates a MacAddress from the given String representation. A valid String representation
 * for a MacAddress is a series of 6 values in the range [0,ff] printed in hexadecimal
 * and joined by ':' characters.
 *
 * @param addr a String representation of a MAC address.
 * This value must never be {@code null}.
 * @return the MacAddress corresponding to the given String representation.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the given String is not a valid representation.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.net.MacAddress fromString(@androidx.annotation.NonNull java.lang.String addr) { throw new RuntimeException("Stub!"); }

/**
 * Creates a MacAddress from the given byte array representation.
 * A valid byte array representation for a MacAddress is a non-null array of length 6.
 *
 * @param addr a byte array representation of a MAC address.
 * This value must never be {@code null}.
 * @return the MacAddress corresponding to the given byte array representation.
 * @throws java.lang.IllegalArgumentException if the given byte array is not a valid representation.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.net.MacAddress fromBytes(@androidx.annotation.NonNull byte[] addr) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this MAC Address matches the provided range.
 *
 * @param baseAddress MacAddress representing the base address to compare with.
 * This value must never be {@code null}.
 * @param mask MacAddress representing the mask to use during comparison.
 * This value must never be {@code null}.
 * @return true if this MAC Address matches the given range.
 *
 * @apiSince R
 */

public boolean matches(@androidx.annotation.NonNull android.net.MacAddress baseAddress, @androidx.annotation.NonNull android.net.MacAddress mask) { throw new RuntimeException("Stub!"); }

/**
 * Create a link-local Inet6Address from the MAC address. The EUI-48 MAC address is converted
 * to an EUI-64 MAC address per RFC 4291. The resulting EUI-64 is used to construct a link-local
 * IPv6 address per RFC 4862.
 *
 * @return A link-local Inet6Address constructed from the MAC address.
 
 * This value may be {@code null}.
 * @apiSince R
 */

@androidx.annotation.Nullable
public java.net.Inet6Address getLinkLocalIpv6FromEui48Mac() { throw new RuntimeException("Stub!"); }

/**
 * The MacAddress representing the unique broadcast MAC address.
 * @apiSince 28
 */

public static final android.net.MacAddress BROADCAST_ADDRESS;
static { BROADCAST_ADDRESS = null; }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.MacAddress> CREATOR;
static { CREATOR = null; }

/**
 * Indicates a MAC address is the broadcast address.
 * @apiSince 28
 */

public static final int TYPE_BROADCAST = 3; // 0x3

/**
 * Indicates a MAC address is a multicast address.
 * @apiSince 28
 */

public static final int TYPE_MULTICAST = 2; // 0x2

/**
 * Indicates a MAC address is a unicast address.
 * @apiSince 28
 */

public static final int TYPE_UNICAST = 1; // 0x1
}

