/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.net.nsd;

import android.os.Parcelable;

/**
 * A class representing service information for network service discovery
 * {@see NsdManager}
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NsdServiceInfo implements android.os.Parcelable {

/** @apiSince 16 */

public NsdServiceInfo() { throw new RuntimeException("Stub!"); }

/**
 * Get the service name
 * @apiSince 16
 */

public java.lang.String getServiceName() { throw new RuntimeException("Stub!"); }

/**
 * Set the service name
 * @apiSince 16
 */

public void setServiceName(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Get the service type
 * @apiSince 16
 */

public java.lang.String getServiceType() { throw new RuntimeException("Stub!"); }

/**
 * Set the service type
 * @apiSince 16
 */

public void setServiceType(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Get the host address. The host address is valid for a resolved service.
 * @apiSince 16
 */

public java.net.InetAddress getHost() { throw new RuntimeException("Stub!"); }

/**
 * Set the host address
 * @apiSince 16
 */

public void setHost(java.net.InetAddress s) { throw new RuntimeException("Stub!"); }

/**
 * Get port number. The port number is valid for a resolved service.
 * @apiSince 16
 */

public int getPort() { throw new RuntimeException("Stub!"); }

/**
 * Set port number
 * @apiSince 16
 */

public void setPort(int p) { throw new RuntimeException("Stub!"); }

/**
 * Add a service attribute as a key/value pair.
 *
 * <p> Service attributes are included as DNS-SD TXT record pairs.
 *
 * <p> The key must be US-ASCII printable characters, excluding the '=' character.  Values may
 * be UTF-8 strings or null.  The total length of key + value must be less than 255 bytes.
 *
 * <p> Keys should be short, ideally no more than 9 characters, and unique per instance of
 * {@link android.net.nsd.NsdServiceInfo NsdServiceInfo}.  Calling {@link #setAttribute} twice with the same key will overwrite
 * first value.
 * @apiSince 21
 */

public void setAttribute(java.lang.String key, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Remove an attribute by key
 * @apiSince 21
 */

public void removeAttribute(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve attributes as a map of String keys to byte[] values. The attributes map is only
 * valid for a resolved service.
 *
 * <p> The returned map is unmodifiable; changes must be made through {@link #setAttribute} and
 * {@link #removeAttribute}.
 * @apiSince 21
 */

public java.util.Map<java.lang.String,byte[]> getAttributes() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 16
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 16
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 16
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.nsd.NsdServiceInfo> CREATOR;
static { CREATOR = null; }
}

