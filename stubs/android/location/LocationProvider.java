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


/**
 * An abstract superclass for location providers.  A location provider
 * provides periodic reports on the geographical location of the
 * device.
 *
 * <p> Each provider has a set of criteria under which it may be used;
 * for example, some providers require GPS hardware and visibility to
 * a number of satellites; others require the use of the cellular
 * radio, or access to a specific carrier's network, or to the
 * internet.  They may also have different battery consumption
 * characteristics or monetary costs to the user.  The {@link android.location.Criteria Criteria} class allows providers to be selected based on
 * user-specified criteria.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LocationProvider {

LocationProvider() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of this provider.
 * @apiSince 1
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this provider meets the given criteria,
 * false otherwise.
 * @apiSince 1
 */

public boolean meetsCriteria(android.location.Criteria criteria) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the provider requires access to a
 * data network (e.g., the Internet), false otherwise.
 * @apiSince 1
 */

public boolean requiresNetwork() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the provider requires access to a
 * satellite-based positioning system (e.g., GPS), false
 * otherwise.
 * @apiSince 1
 */

public boolean requiresSatellite() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the provider requires access to an appropriate
 * cellular network (e.g., to make use of cell tower IDs), false
 * otherwise.
 * @apiSince 1
 */

public boolean requiresCell() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the use of this provider may result in a
 * monetary charge to the user, false if use is free.  It is up to
 * each provider to give accurate information.
 * @apiSince 1
 */

public boolean hasMonetaryCost() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the provider is able to provide altitude
 * information, false otherwise.  A provider that reports altitude
 * under most circumstances but may occassionally not report it
 * should return true.
 * @apiSince 1
 */

public boolean supportsAltitude() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the provider is able to provide speed
 * information, false otherwise.  A provider that reports speed
 * under most circumstances but may occassionally not report it
 * should return true.
 * @apiSince 1
 */

public boolean supportsSpeed() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the provider is able to provide bearing
 * information, false otherwise.  A provider that reports bearing
 * under most circumstances but may occassionally not report it
 * should return true.
 * @apiSince 1
 */

public boolean supportsBearing() { throw new RuntimeException("Stub!"); }

/**
 * Returns the power requirement for this provider.
 *
 * @return the power requirement for this provider, as one of the
 * constants Criteria.POWER_REQUIREMENT_*.
 * @apiSince 1
 */

public int getPowerRequirement() { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant describing horizontal accuracy of this provider.
 * If the provider returns finer grain or exact location,
 * {@link android.location.Criteria#ACCURACY_FINE Criteria#ACCURACY_FINE} is returned, otherwise if the
 * location is only approximate then {@link android.location.Criteria#ACCURACY_COARSE Criteria#ACCURACY_COARSE}
 * is returned.
 * @apiSince 1
 */

public int getAccuracy() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Location provider statuses are no longer supported.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int AVAILABLE = 2; // 0x2

/**
 * @deprecated Location provider statuses are no longer supported.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int OUT_OF_SERVICE = 0; // 0x0

/**
 * @deprecated Location provider statuses are no longer supported.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int TEMPORARILY_UNAVAILABLE = 1; // 0x1
}

