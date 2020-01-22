/*
 * Copyright (C) 2008 The Android Open Source Project
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


/**
 * A simple object for retrieving the results of a DHCP request.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DhcpInfo implements android.os.Parcelable {

/** @apiSince 1 */

public DhcpInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int dns1;

/** @apiSince 1 */

public int dns2;

/** @apiSince 1 */

public int gateway;

/** @apiSince 1 */

public int ipAddress;

/** @apiSince 1 */

public int leaseDuration;

/** @apiSince 1 */

public int netmask;

/** @apiSince 1 */

public int serverAddress;
}

