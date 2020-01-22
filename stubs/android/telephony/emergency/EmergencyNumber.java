/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.telephony.emergency;

import android.telephony.CarrierConfigManager;

/**
 * A parcelable class that wraps and retrieves the information of number, service category(s) and
 * country code for a specific emergency number.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class EmergencyNumber implements android.os.Parcelable, java.lang.Comparable<android.telephony.emergency.EmergencyNumber> {

EmergencyNumber() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Get the dialing number of the emergency number.
 *
 * The character in the number string is only the dial pad
 * character('0'-'9', '*', '+', or '#'). For example: 911.
 *
 * If the number starts with carrier prefix, the carrier prefix is configured in
 * {@link android.telephony.CarrierConfigManager#KEY_EMERGENCY_NUMBER_PREFIX_STRING_ARRAY CarrierConfigManager#KEY_EMERGENCY_NUMBER_PREFIX_STRING_ARRAY}.
 *
 * @return the dialing number.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String getNumber() { throw new RuntimeException("Stub!"); }

/**
 * Get the country code string (lowercase character) in ISO 3166 format of the emergency number.
 *
 * @return the country code string (lowercase character) in ISO 3166 format.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String getCountryIso() { throw new RuntimeException("Stub!"); }

/**
 * Get the Mobile Network Code of the emergency number.
 *
 * @return the Mobile Network Code of the emergency number.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String getMnc() { throw new RuntimeException("Stub!"); }

/**
 * Returns the emergency service categories of the emergency number.
 *
 * Note: if the emergency number is in {@link #EMERGENCY_SERVICE_CATEGORY_UNSPECIFIED}, only
 * {@link #EMERGENCY_SERVICE_CATEGORY_UNSPECIFIED} is returned and it means the number is in
 * all categories.
 *
 * @return a list of the emergency service categories
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.Integer> getEmergencyServiceCategories() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of emergency Uniform Resources Names (URN) of the emergency number.
 *
 * For example, {@code urn:service:sos} is the generic URN for contacting emergency services
 * of all type.
 *
 * Reference: 3gpp 24.503, Section 5.1.6.8.1 - General;
 *            RFC 5031
 *
 * @return list of emergency Uniform Resources Names (URN) or an empty list if the emergency
 *         number does not have a specified emergency Uniform Resource Name.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.String> getEmergencyUrns() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the emergency number is in the supplied emergency service category(s).
 *
 * @param categories - the supplied emergency service categories
 *
 * Value is either <code>0</code> or a combination of {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_UNSPECIFIED}, {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_POLICE}, {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_AMBULANCE}, {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_FIRE_BRIGADE}, {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_MARINE_GUARD}, {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_MOUNTAIN_RESCUE}, {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_MIEC}, and {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_AIEC}
 * @return {@code true} if the emergency number is in the specified emergency service
 * category(s) or if its emergency service category is
 * {@link #EMERGENCY_SERVICE_CATEGORY_UNSPECIFIED}; {@code false} otherwise.
 * @apiSince 29
 */

public boolean isInEmergencyServiceCategories(int categories) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of sources of the emergency number.
 *
 * @return a list of emergency number sources
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.Integer> getEmergencyNumberSources() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the emergency number is from the specified emergency number source(s).
 *
 * @return {@code true} if the emergency number is from the specified emergency number
 * source(s); {@code false} otherwise.
 *
 * @param sources - the supplied emergency number sources
 
 * Value is either <code>0</code> or a combination of {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_NUMBER_SOURCE_NETWORK_SIGNALING}, {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_NUMBER_SOURCE_SIM}, {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_NUMBER_SOURCE_DATABASE}, {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_NUMBER_SOURCE_MODEM_CONFIG}, and {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_NUMBER_SOURCE_DEFAULT}
 * @apiSince 29
 */

public boolean isFromSources(int sources) { throw new RuntimeException("Stub!"); }

/**
 * Returns the emergency call routing information.
 *
 * <p>Some regions require some emergency numbers which are not routed using typical emergency
 * call processing, but are instead placed as regular phone calls. The emergency call routing
 * field provides information about how an emergency call will be routed when it is placed.
 *
 * @return the emergency call routing requirement
 
 * Value is {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_CALL_ROUTING_UNKNOWN}, {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_CALL_ROUTING_EMERGENCY}, or {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_CALL_ROUTING_NORMAL}
 * @apiSince 29
 */

public int getEmergencyCallRouting() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Compare the display priority for this emergency number and the supplied emergency number.
 *
 * @param emergencyNumber the supplied emergency number
 * This value must never be {@code null}.
 * @return a negative value if the supplied emergency number has a lower display priority;
 *         a positive value if the supplied emergency number has a higher display priority;
 *         0 if both have equal display priority.
 * @apiSince 29
 */

public int compareTo(@androidx.annotation.NonNull android.telephony.emergency.EmergencyNumber emergencyNumber) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.emergency.EmergencyNumber> CREATOR;
static { CREATOR = null; }

/**
 * Indicates the radio or IMS implementation must handle the call through emergency routing.
 * @apiSince 29
 */

public static final int EMERGENCY_CALL_ROUTING_EMERGENCY = 1; // 0x1

/**
 * Indicates the radio or IMS implementation must handle the call through normal call routing.
 * @apiSince 29
 */

public static final int EMERGENCY_CALL_ROUTING_NORMAL = 2; // 0x2

/**
 * Indicated the framework does not know whether an emergency call should be placed using
 * emergency or normal call routing. This means the underlying radio or IMS implementation is
 * free to determine for itself how to route the call.
 * @apiSince 29
 */

public static final int EMERGENCY_CALL_ROUTING_UNKNOWN = 0; // 0x0

/**
 * Bit-field which indicates the number is from the platform-maintained database.
 * @apiSince 29
 */

public static final int EMERGENCY_NUMBER_SOURCE_DATABASE = 16; // 0x10

/**
 * Bit-field which indicates the number is available as default.
 *
 * 112, 911 must always be available; additionally, 000, 08, 110, 999, 118 and 119 must be
 * available when sim is not present.
 *
 * Reference: 3gpp 22.101, Section 10 - Emergency Calls
 * @apiSince 29
 */

public static final int EMERGENCY_NUMBER_SOURCE_DEFAULT = 8; // 0x8

/**
 * Bit-field which indicates the number is from the modem config.
 * @apiSince 29
 */

public static final int EMERGENCY_NUMBER_SOURCE_MODEM_CONFIG = 4; // 0x4

/**
 * Bit-field which indicates the number is from the network signaling.
 *
 * Reference: 3gpp 22.101, Section 10 - Emergency Calls
 * @apiSince 29
 */

public static final int EMERGENCY_NUMBER_SOURCE_NETWORK_SIGNALING = 1; // 0x1

/**
 * Bit-field which indicates the number is from the sim.
 *
 * Reference: 3gpp 22.101, Section 10 - Emergency Calls
 * @apiSince 29
 */

public static final int EMERGENCY_NUMBER_SOURCE_SIM = 2; // 0x2

/**
 * Bit-field that indicates Emergency Service Category for Automatically Initiated eCall (AIeC)
 *
 * Reference: 3gpp 22.101, Section 10 - Emergency Calls
 * @apiSince 29
 */

public static final int EMERGENCY_SERVICE_CATEGORY_AIEC = 64; // 0x40

/**
 * Bit-field that indicates Emergency Service Category for Ambulance.
 *
 * Reference: 3gpp 22.101, Section 10 - Emergency Calls
 * @apiSince 29
 */

public static final int EMERGENCY_SERVICE_CATEGORY_AMBULANCE = 2; // 0x2

/**
 * Bit-field that indicates Emergency Service Category for Fire Brigade.
 *
 * Reference: 3gpp 22.101, Section 10 - Emergency Calls
 * @apiSince 29
 */

public static final int EMERGENCY_SERVICE_CATEGORY_FIRE_BRIGADE = 4; // 0x4

/**
 * Bit-field that indicates Emergency Service Category for Marine Guard.
 *
 * Reference: 3gpp 22.101, Section 10 - Emergency Calls
 * @apiSince 29
 */

public static final int EMERGENCY_SERVICE_CATEGORY_MARINE_GUARD = 8; // 0x8

/**
 * Bit-field that indicates Emergency Service Category for Manually Initiated eCall (MIeC)
 *
 * Reference: 3gpp 22.101, Section 10 - Emergency Calls
 * @apiSince 29
 */

public static final int EMERGENCY_SERVICE_CATEGORY_MIEC = 32; // 0x20

/**
 * Bit-field that indicates Emergency Service Category for Mountain Rescue.
 *
 * Reference: 3gpp 22.101, Section 10 - Emergency Calls
 * @apiSince 29
 */

public static final int EMERGENCY_SERVICE_CATEGORY_MOUNTAIN_RESCUE = 16; // 0x10

/**
 * Bit-field that indicates Emergency Service Category for Police.
 *
 * Reference: 3gpp 22.101, Section 10 - Emergency Calls
 * @apiSince 29
 */

public static final int EMERGENCY_SERVICE_CATEGORY_POLICE = 1; // 0x1

/**
 * Emergency Service Category UNSPECIFIED (General emergency call, all categories) bit-field
 * indicates that no specific services are associated with this emergency number; if the
 * emergency number is specified, it has one or more defined emergency service categories.
 *
 * Reference: 3gpp 22.101, Section 10 - Emergency Calls
 * @apiSince 29
 */

public static final int EMERGENCY_SERVICE_CATEGORY_UNSPECIFIED = 0; // 0x0
}

