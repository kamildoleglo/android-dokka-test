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
 * A class that represents a TCP connect event initiated through the standard network stack.
 *
 * <p>It contains information about the originating app as well as the remote TCP endpoint.
 *
 * <p>Support both IPv4 and IPv6 connections.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ConnectEvent extends android.app.admin.NetworkEvent implements android.os.Parcelable {

ConnectEvent() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.net.InetAddress getInetAddress() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int getPort() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.admin.ConnectEvent> CREATOR;
static { CREATOR = null; }
}

