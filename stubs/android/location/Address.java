/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.location;

import java.util.Locale;
import android.os.Bundle;

/**
 * A class representing an Address, i.e, a set of Strings describing a location.
 *
 * The address format is a simplified version of xAL (eXtensible Address Language)
 * http://www.oasis-open.org/committees/ciq/ciq.html#6
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Address implements android.os.Parcelable {

/**
 * Constructs a new Address object set to the given Locale and with all
 * other fields initialized to null or false.
 * @apiSince 1
 */

public Address(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Locale associated with this address.
 * @apiSince 1
 */

public java.util.Locale getLocale() { throw new RuntimeException("Stub!"); }

/**
 * Returns the largest index currently in use to specify an address line.
 * If no address lines are specified, -1 is returned.
 * @apiSince 1
 */

public int getMaxAddressLineIndex() { throw new RuntimeException("Stub!"); }

/**
 * Returns a line of the address numbered by the given index
 * (starting at 0), or null if no such line is present.
 *
 * @throws java.lang.IllegalArgumentException if index < 0
 * @apiSince 1
 */

public java.lang.String getAddressLine(int index) { throw new RuntimeException("Stub!"); }

/**
 * Sets the line of the address numbered by index (starting at 0) to the
 * given String, which may be null.
 *
 * @throws java.lang.IllegalArgumentException if index < 0
 * @apiSince 1
 */

public void setAddressLine(int index, java.lang.String line) { throw new RuntimeException("Stub!"); }

/**
 * Returns the feature name of the address, for example, "Golden Gate Bridge", or null
 * if it is unknown
 * @apiSince 1
 */

public java.lang.String getFeatureName() { throw new RuntimeException("Stub!"); }

/**
 * Sets the feature name of the address to the given String, which may be null
 * @apiSince 1
 */

public void setFeatureName(java.lang.String featureName) { throw new RuntimeException("Stub!"); }

/**
 * Returns the administrative area name of the address, for example, "CA", or null if
 * it is unknown
 * @apiSince 1
 */

public java.lang.String getAdminArea() { throw new RuntimeException("Stub!"); }

/**
 * Sets the administrative area name of the address to the given String, which may be null
 * @apiSince 1
 */

public void setAdminArea(java.lang.String adminArea) { throw new RuntimeException("Stub!"); }

/**
 * Returns the sub-administrative area name of the address, for example, "Santa Clara County",
 * or null if it is unknown
 * @apiSince 1
 */

public java.lang.String getSubAdminArea() { throw new RuntimeException("Stub!"); }

/**
 * Sets the sub-administrative area name of the address to the given String, which may be null
 * @apiSince 1
 */

public void setSubAdminArea(java.lang.String subAdminArea) { throw new RuntimeException("Stub!"); }

/**
 * Returns the locality of the address, for example "Mountain View", or null if it is unknown.
 * @apiSince 1
 */

public java.lang.String getLocality() { throw new RuntimeException("Stub!"); }

/**
 * Sets the locality of the address to the given String, which may be null.
 * @apiSince 1
 */

public void setLocality(java.lang.String locality) { throw new RuntimeException("Stub!"); }

/**
 * Returns the sub-locality of the address, or null if it is unknown.
 * For example, this may correspond to the neighborhood of the locality.
 * @apiSince 4
 */

public java.lang.String getSubLocality() { throw new RuntimeException("Stub!"); }

/**
 * Sets the sub-locality of the address to the given String, which may be null.
 * @apiSince 4
 */

public void setSubLocality(java.lang.String sublocality) { throw new RuntimeException("Stub!"); }

/**
 * Returns the thoroughfare name of the address, for example, "1600 Ampitheater Parkway",
 * which may be null
 * @apiSince 1
 */

public java.lang.String getThoroughfare() { throw new RuntimeException("Stub!"); }

/**
 * Sets the thoroughfare name of the address, which may be null.
 * @apiSince 1
 */

public void setThoroughfare(java.lang.String thoroughfare) { throw new RuntimeException("Stub!"); }

/**
 * Returns the sub-thoroughfare name of the address, which may be null.
 * This may correspond to the street number of the address.
 * @apiSince 4
 */

public java.lang.String getSubThoroughfare() { throw new RuntimeException("Stub!"); }

/**
 * Sets the sub-thoroughfare name of the address, which may be null.
 * @apiSince 4
 */

public void setSubThoroughfare(java.lang.String subthoroughfare) { throw new RuntimeException("Stub!"); }

/**
 * Returns the premises of the address, or null if it is unknown.
 * @apiSince 4
 */

public java.lang.String getPremises() { throw new RuntimeException("Stub!"); }

/**
 * Sets the premises of the address to the given String, which may be null.
 * @apiSince 4
 */

public void setPremises(java.lang.String premises) { throw new RuntimeException("Stub!"); }

/**
 * Returns the postal code of the address, for example "94110",
 * or null if it is unknown.
 * @apiSince 1
 */

public java.lang.String getPostalCode() { throw new RuntimeException("Stub!"); }

/**
 * Sets the postal code of the address to the given String, which may
 * be null.
 * @apiSince 1
 */

public void setPostalCode(java.lang.String postalCode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the country code of the address, for example "US",
 * or null if it is unknown.
 * @apiSince 1
 */

public java.lang.String getCountryCode() { throw new RuntimeException("Stub!"); }

/**
 * Sets the country code of the address to the given String, which may
 * be null.
 * @apiSince 1
 */

public void setCountryCode(java.lang.String countryCode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the localized country name of the address, for example "Iceland",
 * or null if it is unknown.
 * @apiSince 1
 */

public java.lang.String getCountryName() { throw new RuntimeException("Stub!"); }

/**
 * Sets the country name of the address to the given String, which may
 * be null.
 * @apiSince 1
 */

public void setCountryName(java.lang.String countryName) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if a latitude has been assigned to this Address,
 * false otherwise.
 * @apiSince 1
 */

public boolean hasLatitude() { throw new RuntimeException("Stub!"); }

/**
 * Returns the latitude of the address if known.
 *
 * @throws java.lang.IllegalStateException if this Address has not been assigned
 * a latitude.
 * @apiSince 1
 */

public double getLatitude() { throw new RuntimeException("Stub!"); }

/**
 * Sets the latitude associated with this address.
 * @apiSince 1
 */

public void setLatitude(double latitude) { throw new RuntimeException("Stub!"); }

/**
 * Removes any latitude associated with this address.
 * @apiSince 1
 */

public void clearLatitude() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if a longitude has been assigned to this Address,
 * false otherwise.
 * @apiSince 1
 */

public boolean hasLongitude() { throw new RuntimeException("Stub!"); }

/**
 * Returns the longitude of the address if known.
 *
 * @throws java.lang.IllegalStateException if this Address has not been assigned
 * a longitude.
 * @apiSince 1
 */

public double getLongitude() { throw new RuntimeException("Stub!"); }

/**
 * Sets the longitude associated with this address.
 * @apiSince 1
 */

public void setLongitude(double longitude) { throw new RuntimeException("Stub!"); }

/**
 * Removes any longitude associated with this address.
 * @apiSince 1
 */

public void clearLongitude() { throw new RuntimeException("Stub!"); }

/**
 * Returns the phone number of the address if known,
 * or null if it is unknown.
 *
 * @throws java.lang.IllegalStateException if this Address has not been assigned
 * a phone number.
 * @apiSince 1
 */

public java.lang.String getPhone() { throw new RuntimeException("Stub!"); }

/**
 * Sets the phone number associated with this address.
 * @apiSince 1
 */

public void setPhone(java.lang.String phone) { throw new RuntimeException("Stub!"); }

/**
 * Returns the public URL for the address if known,
 * or null if it is unknown.
 * @apiSince 1
 */

public java.lang.String getUrl() { throw new RuntimeException("Stub!"); }

/**
 * Sets the public URL associated with this address.
 * @apiSince 1
 */

public void setUrl(java.lang.String Url) { throw new RuntimeException("Stub!"); }

/**
 * Returns additional provider-specific information about the
 * address as a Bundle.  The keys and values are determined
 * by the provider.  If no additional information is available,
 * null is returned.
 *
 * <!--
 * <p> A number of common key/value pairs are listed
 * below. Providers that use any of the keys on this list must
 * provide the corresponding value as described below.
 *
 * <ul>
 * </ul>
 * -->
 * @apiSince 1
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Sets the extra information associated with this fix to the
 * given Bundle.
 * @apiSince 1
 */

public void setExtras(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.location.Address> CREATOR;
static { CREATOR = null; }
}

