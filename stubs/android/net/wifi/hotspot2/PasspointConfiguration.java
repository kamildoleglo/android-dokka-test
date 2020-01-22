/**
 * Copyright (c) 2016, The Android Open Source Project
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


package android.net.wifi.hotspot2;


/**
 * Class representing Passpoint configuration.  This contains configurations specified in
 * PerProviderSubscription (PPS) Management Object (MO) tree.
 *
 * For more info, refer to Hotspot 2.0 PPS MO defined in section 9.1 of the Hotspot 2.0
 * Release 2 Technical Specification.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PasspointConfiguration implements android.os.Parcelable {

/**
 * Constructor for creating PasspointConfiguration with default values.
 * @apiSince 26
 */

public PasspointConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * Copy constructor.
 *
 * @param source The source to copy from
 * @apiSince 26
 */

public PasspointConfiguration(android.net.wifi.hotspot2.PasspointConfiguration source) { throw new RuntimeException("Stub!"); }

/**
 * Set the Home SP (Service Provider) information.
 *
 * @param homeSp The Home SP information to set to
 * @apiSince 26
 */

public void setHomeSp(android.net.wifi.hotspot2.pps.HomeSp homeSp) { throw new RuntimeException("Stub!"); }

/**
 * Get the Home SP (Service Provider) information.
 *
 * @return Home SP information
 * @apiSince 26
 */

public android.net.wifi.hotspot2.pps.HomeSp getHomeSp() { throw new RuntimeException("Stub!"); }

/**
 * Set the credential information.
 *
 * @param credential The credential information to set to
 * @apiSince 26
 */

public void setCredential(android.net.wifi.hotspot2.pps.Credential credential) { throw new RuntimeException("Stub!"); }

/**
 * Get the credential information.
 *
 * @return credential information
 * @apiSince 26
 */

public android.net.wifi.hotspot2.pps.Credential getCredential() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object thatObject) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.hotspot2.PasspointConfiguration> CREATOR;
static { CREATOR = null; }
}

