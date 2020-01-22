/**
 * Copyright (c) 2015, The Android Open Source Project
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


package android.service.carrier;

import android.telephony.TelephonyManager;
import android.os.Parcel;

/**
 * Used to pass info to CarrierConfigService implementations so they can decide what values to
 * return. Instead of passing mcc, mnc, gid1, gid2, spn, imsi to locate carrier information,
 * CarrierIdentifier also include carrier id {@link android.telephony.TelephonyManager#getSimCarrierId() TelephonyManager#getSimCarrierId()},
 * a platform-wide unique identifier for each carrier. CarrierConfigService can directly use
 * carrier id as the key to look up the carrier info.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CarrierIdentifier implements android.os.Parcelable {

/**
 * @param spn This value may be {@code null}.
 
 * @param imsi This value may be {@code null}.
 
 * @param gid1 This value may be {@code null}.
 
 * @param gid2 This value may be {@code null}.
 * @apiSince 23
 */

public CarrierIdentifier(java.lang.String mcc, java.lang.String mnc, @androidx.annotation.Nullable java.lang.String spn, @androidx.annotation.Nullable java.lang.String imsi, @androidx.annotation.Nullable java.lang.String gid1, @androidx.annotation.Nullable java.lang.String gid2) { throw new RuntimeException("Stub!"); }

/**
 * @param mcc mobile country code
 * This value must never be {@code null}.
 * @param mnc mobile network code
 * This value must never be {@code null}.
 * @param spn service provider name
 * This value may be {@code null}.
 * @param imsi International Mobile Subscriber Identity {@link android.telephony.TelephonyManager#getSubscriberId() TelephonyManager#getSubscriberId()}
 * This value may be {@code null}.
 * @param gid1 group id level 1 {@link android.telephony.TelephonyManager#getGroupIdLevel1() TelephonyManager#getGroupIdLevel1()}
 * This value may be {@code null}.
 * @param gid2 group id level 2
 * This value may be {@code null}.
 * @param carrierid carrier unique identifier {@link android.telephony.TelephonyManager#getSimCarrierId() TelephonyManager#getSimCarrierId()}, used
 *                  to uniquely identify the carrier and look up the carrier configurations.
 * @param specificCarrierId specific carrier identifier
 * {@link android.telephony.TelephonyManager#getSimSpecificCarrierId() TelephonyManager#getSimSpecificCarrierId()}
 * @apiSince 29
 */

public CarrierIdentifier(@androidx.annotation.NonNull java.lang.String mcc, @androidx.annotation.NonNull java.lang.String mnc, @androidx.annotation.Nullable java.lang.String spn, @androidx.annotation.Nullable java.lang.String imsi, @androidx.annotation.Nullable java.lang.String gid1, @androidx.annotation.Nullable java.lang.String gid2, int carrierid, int specificCarrierId) { throw new RuntimeException("Stub!"); }

/**
 * Creates a carrier identifier instance.
 *
 * @param mccMnc A 3-byte array as defined by 3GPP TS 24.008.
 * @param gid1 The group identifier level 1.
 * This value may be {@code null}.
 * @param gid2 The group identifier level 2.
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException If the length of {@code mccMnc} is not 3.
 * @apiSince 28
 */

public CarrierIdentifier(byte[] mccMnc, @androidx.annotation.Nullable java.lang.String gid1, @androidx.annotation.Nullable java.lang.String gid2) { throw new RuntimeException("Stub!"); }

/**
 * Get the mobile country code.
 * @apiSince 23
 */

public java.lang.String getMcc() { throw new RuntimeException("Stub!"); }

/**
 * Get the mobile network code.
 * @apiSince 23
 */

public java.lang.String getMnc() { throw new RuntimeException("Stub!"); }

/**
 * Get the service provider name.
 * @return This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public java.lang.String getSpn() { throw new RuntimeException("Stub!"); }

/**
 * Get the international mobile subscriber identity.
 * @return This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public java.lang.String getImsi() { throw new RuntimeException("Stub!"); }

/**
 * Get the group identifier level 1.
 * @return This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public java.lang.String getGid1() { throw new RuntimeException("Stub!"); }

/**
 * Get the group identifier level 2.
 * @return This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public java.lang.String getGid2() { throw new RuntimeException("Stub!"); }

/**
 * Returns the carrier id.
 * @see android.telephony.TelephonyManager#getSimCarrierId()
 * @apiSince 29
 */

public int getCarrierId() { throw new RuntimeException("Stub!"); }

/**
 * A specific carrier ID returns the fine-grained carrier ID of the current subscription.
 * It can represent the fact that a carrier may be in effect an aggregation of other carriers
 * (ie in an MVNO type scenario) where each of these specific carriers which are used to make
 * up the actual carrier service may have different carrier configurations.
 * A specific carrier ID could also be used, for example, in a scenario where a carrier requires
 * different carrier configuration for different service offering such as a prepaid plan.
 *
 * @see android.telephony.TelephonyManager#getSimSpecificCarrierId()
 * @apiSince 29
 */

public int getSpecificCarrierId() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Used to create a {@link android.service.carrier.CarrierIdentifier CarrierIdentifier} from a {@link android.os.Parcel Parcel}.
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.carrier.CarrierIdentifier> CREATOR;
static { CREATOR = null; }
}

