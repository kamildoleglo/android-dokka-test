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


package android.net.wifi.aware;


/**
 * The characteristics of the Wi-Fi Aware implementation.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Characteristics implements android.os.Parcelable {

Characteristics() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum string length that can be used to specify a Aware service name. Restricts
 * the parameters of the {@link android.net.wifi.aware.PublishConfig.Builder#setServiceName(java.lang.String) PublishConfig.Builder#setServiceName(String)} and
 * {@link android.net.wifi.aware.SubscribeConfig.Builder#setServiceName(java.lang.String) SubscribeConfig.Builder#setServiceName(String)}.
 *
 * @return A positive integer, maximum string length of Aware service name.
 * @apiSince 26
 */

public int getMaxServiceNameLength() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum length of byte array that can be used to specify a Aware service specific
 * information field: the arbitrary load used in discovery or the message length of Aware
 * message exchange. Restricts the parameters of the
 * {@link android.net.wifi.aware.PublishConfig.Builder#setServiceSpecificInfo(byte[]) PublishConfig.Builder#setServiceSpecificInfo(byte[])},
 * {@link android.net.wifi.aware.SubscribeConfig.Builder#setServiceSpecificInfo(byte[]) SubscribeConfig.Builder#setServiceSpecificInfo(byte[])}, and
 * {@link android.net.wifi.aware.DiscoverySession#sendMessage(android.net.wifi.aware.PeerHandle,int,byte[]) DiscoverySession#sendMessage(PeerHandle, int, byte[])}
 * variants.
 *
 * @return A positive integer, maximum length of byte array for Aware messaging.
 * @apiSince 26
 */

public int getMaxServiceSpecificInfoLength() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum length of byte array that can be used to specify a Aware match filter.
 * Restricts the parameters of the
 * {@link android.net.wifi.aware.PublishConfig.Builder#setMatchFilter(java.util.List) PublishConfig.Builder#setMatchFilter(java.util.List)} and
 * {@link android.net.wifi.aware.SubscribeConfig.Builder#setMatchFilter(java.util.List) SubscribeConfig.Builder#setMatchFilter(java.util.List)}.
 *
 * @return A positive integer, maximum legngth of byte array for Aware discovery match filter.
 * @apiSince 26
 */

public int getMaxMatchFilterLength() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.aware.Characteristics> CREATOR;
static { CREATOR = null; }
}

