/*
 * Copyright (C) 2014 The Android Open Source Project
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
 * limitations under the License
 */


package android.location;


/**
 * A class implementing a container for data associated with a measurement event.
 * Events are delivered to registered instances of {@link android.location.GnssMeasurementsEvent.Callback Callback}.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class GnssMeasurementsEvent implements android.os.Parcelable {

GnssMeasurementsEvent() { throw new RuntimeException("Stub!"); }

/**
 * Gets the GNSS receiver clock information associated with the measurements for the current
 * event.
 
 * @return This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.location.GnssClock getClock() { throw new RuntimeException("Stub!"); }

/**
 * Gets a read-only collection of measurements associated with the current event.
 
 * @return This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public java.util.Collection<android.location.GnssMeasurement> getMeasurements() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.location.GnssMeasurementsEvent> CREATOR;
static { CREATOR = null; }
/**
 * Used for receiving GNSS satellite measurements from the GNSS engine.
 * Each measurement contains raw and computed data identifying a satellite.
 * You can implement this interface and call
 * {@link android.location.LocationManager#registerGnssMeasurementsCallback LocationManager#registerGnssMeasurementsCallback}.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Reports the latest collected GNSS Measurements.
 * @apiSince 24
 */

public void onGnssMeasurementsReceived(android.location.GnssMeasurementsEvent eventArgs) { throw new RuntimeException("Stub!"); }

/**
 * Reports the latest status of the GNSS Measurements sub-system.
 
 * @param status Value is {@link android.location.GnssMeasurementsEvent.Callback#STATUS_NOT_SUPPORTED}, {@link android.location.GnssMeasurementsEvent.Callback#STATUS_READY}, {@link android.location.GnssMeasurementsEvent.Callback#STATUS_LOCATION_DISABLED}, or {@link android.location.GnssMeasurementsEvent.Callback#STATUS_NOT_ALLOWED}
 * @apiSince 24
 */

public void onStatusChanged(int status) { throw new RuntimeException("Stub!"); }

/**
 * GPS provider or Location is disabled, updates will not be received until they are
 * enabled.
 * @apiSince 24
 */

public static final int STATUS_LOCATION_DISABLED = 2; // 0x2

/**
 * The client is not allowed to register for GNSS Measurements in general or in the
 * requested mode.
 *
 * <p>Such a status is returned when a client tries to request a functionality from the GNSS
 * chipset while another client has an ongoing request that does not allow such
 * functionality to be performed.
 *
 * <p>If such a status is received, one would try again at a later time point where no
 * other client is having a conflicting request.
 * @apiSince 28
 */

public static final int STATUS_NOT_ALLOWED = 3; // 0x3

/**
 * The system does not support tracking of GNSS Measurements.
 *
 * <p>This status will not change in the future.
 * @apiSince 24
 */

public static final int STATUS_NOT_SUPPORTED = 0; // 0x0

/**
 * GNSS Measurements are successfully being tracked, it will receive updates once they are
 * available.
 * @apiSince 24
 */

public static final int STATUS_READY = 1; // 0x1
}

}

