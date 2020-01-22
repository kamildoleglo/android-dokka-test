/*
 * Copyright 2014, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.telecom;

import android.os.Parcelable;

/**
 * Encapsulated gateway address information for outgoing call. When calls are made, the system
 * provides a facility to specify two addresses for the call: one to display as the address being
 * dialed and a separate (gateway) address to actually dial. Telecom provides this information to
 * {@link android.telecom.ConnectionService ConnectionService}s when placing the call as an instance of {@code GatewayInfo}.
 * <p>
 * The data consists of an address to call, an address to display and the package name of the
 * service. This data is used in two ways:
 * <ol>
 * <li> Call the appropriate gateway address.
 * <li> Display information about how the call is being routed to the user.
 * </ol>
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GatewayInfo implements android.os.Parcelable {

/** @apiSince 23 */

public GatewayInfo(java.lang.String packageName, android.net.Uri gatewayUri, android.net.Uri originalAddress) { throw new RuntimeException("Stub!"); }

/**
 * Package name of the gateway provider service that provided the gateway information.
 * This can be used to identify the gateway address source and to load an appropriate icon when
 * displaying gateway information in the in-call UI.
 * @apiSince 23
 */

public java.lang.String getGatewayProviderPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the gateway address to dial when placing the call.
 * @apiSince 23
 */

public android.net.Uri getGatewayAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the address that the user is trying to connect to via the gateway.
 * @apiSince 23
 */

public android.net.Uri getOriginalAddress() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this {@code GatewayInfo} instance contains any data. A returned value of
 * false indicates that no gateway number is being used for the call.
 * @apiSince 23
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 23
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 23
 */

public void writeToParcel(android.os.Parcel destination, int flags) { throw new RuntimeException("Stub!"); }

/**
 * The Parcelable interface.
 *     * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telecom.GatewayInfo> CREATOR;
static { CREATOR = null; }
}

