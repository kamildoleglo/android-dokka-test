/*
 * Copyright (C) 2016 The Android Open Source Project
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


package android.app.admin;


/**
 * A class that represents a DNS lookup event initiated through the standard network stack.
 *
 * <p>It contains information about the originating app as well as the DNS hostname and resolved
 * IP addresses.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DnsEvent extends android.app.admin.NetworkEvent implements android.os.Parcelable {

DnsEvent() { throw new RuntimeException("Stub!"); }

/**
 * Returns the hostname that was looked up.
 * @apiSince 26
 */

public java.lang.String getHostname() { throw new RuntimeException("Stub!"); }

/**
 * Returns (possibly a subset of) the IP addresses returned.
 * @apiSince 26
 */

public java.util.List<java.net.InetAddress> getInetAddresses() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of IP addresses returned from the DNS lookup event. May be different from
 * the length of the list returned by {@link #getInetAddresses()} if there were too many
 * addresses to log.
 * @apiSince 26
 */

public int getTotalResolvedAddressCount() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.admin.DnsEvent> CREATOR;
static { CREATOR = null; }
}

