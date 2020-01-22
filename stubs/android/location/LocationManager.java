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

import android.content.Intent;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;

/**
 * This class provides access to the system location services.  These
 * services allow applications to obtain periodic updates of the
 * device's geographical location, or to fire an application-specified
 * {@link android.content.Intent Intent} when the device enters the proximity of a given
 * geographical location.
 *
 * <p class="note">Unless noted, all Location API methods require
 * the {@link android.Manifest.permission#ACCESS_COARSE_LOCATION} or
 * {@link android.Manifest.permission#ACCESS_FINE_LOCATION} permissions.
 * If your application only has the coarse permission then it will not have
 * access to the GPS or passive location providers. Other providers will still
 * return location results, but the update rate will be throttled and the exact
 * location will be obfuscated to a coarse level of accuracy.
 
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_LOCATION PackageManager#FEATURE_LOCATION} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LocationManager {

LocationManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of the names of all known location providers.
 * <p>All providers are returned, including ones that are not permitted to
 * be accessed by the calling activity or are currently disabled.
 *
 * @return list of Strings containing names of the provider
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.String> getAllProviders() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of the names of location providers.
 *
 * @param enabledOnly if true then only the providers which are currently
 * enabled are returned.
 * @return list of Strings containing names of the providers
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.String> getProviders(boolean enabledOnly) { throw new RuntimeException("Stub!"); }

/**
 * Returns the information associated with the location provider of the
 * given name, or null if no provider exists by that name.
 *
 * @param name the provider name
 * This value must never be {@code null}.
 * @return a LocationProvider, or null
 *
 * @throws java.lang.IllegalArgumentException if name is null or does not exist
 * @throws java.lang.SecurityException if the caller is not permitted to access the
 * given provider.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.location.LocationProvider getProvider(@androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of the names of LocationProviders that satisfy the given
 * criteria, or null if none do.  Only providers that are permitted to be
 * accessed by the calling activity will be returned.
 *
 * @param criteria the criteria that the returned providers must match
 * This value must never be {@code null}.
 * @param enabledOnly if true then only the providers which are currently
 * enabled are returned.
 * @return list of Strings containing names of the providers
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.String> getProviders(@androidx.annotation.NonNull android.location.Criteria criteria, boolean enabledOnly) { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the provider that best meets the given criteria. Only providers
 * that are permitted to be accessed by the calling activity will be
 * returned.  If several providers meet the criteria, the one with the best
 * accuracy is returned.  If no provider meets the criteria,
 * the criteria are loosened in the following sequence:
 *
 * <ul>
 * <li> power requirement
 * <li> accuracy
 * <li> bearing
 * <li> speed
 * <li> altitude
 * </ul>
 *
 * <p> Note that the requirement on monetary cost is not removed
 * in this process.
 *
 * @param criteria the criteria that need to be matched
 * This value must never be {@code null}.
 * @param enabledOnly if true then only a provider that is currently enabled is returned
 * @return name of the provider that best matches the requirements
 
 * This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String getBestProvider(@androidx.annotation.NonNull android.location.Criteria criteria, boolean enabledOnly) { throw new RuntimeException("Stub!"); }

/**
 * Register for location updates using the named provider, and a
 * pending intent.
 *
 * <p>See {@link #requestLocationUpdates(long,float,android.location.Criteria,android.app.PendingIntent)}
 * for more detail on how to use this method.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_COARSE_LOCATION} or {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param provider the name of the provider with which to register
 * This value must never be {@code null}.
 * @param minTime minimum time interval between location updates, in milliseconds
 * @param minDistance minimum distance between location updates, in meters
 * @param listener a {@link android.location.LocationListener LocationListener} whose
 * {@link android.location.LocationListener#onLocationChanged LocationListener#onLocationChanged} method will be called for
 * each location update
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if provider is null or doesn't exist
 * on this device
 * @throws java.lang.IllegalArgumentException if listener is null
 * @throws java.lang.RuntimeException if the calling thread has no Looper
 * @throws java.lang.SecurityException if no suitable permission is present
 * @apiSince 1
 */

public void requestLocationUpdates(@androidx.annotation.NonNull java.lang.String provider, long minTime, float minDistance, @androidx.annotation.NonNull android.location.LocationListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Register for location updates using the named provider, and a callback on
 * the specified looper thread.
 *
 * <p>See {@link #requestLocationUpdates(long,float,android.location.Criteria,android.app.PendingIntent)}
 * for more detail on how to use this method.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_COARSE_LOCATION} or {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param provider the name of the provider with which to register
 * This value must never be {@code null}.
 * @param minTime minimum time interval between location updates, in milliseconds
 * @param minDistance minimum distance between location updates, in meters
 * @param listener a {@link android.location.LocationListener LocationListener} whose
 * {@link android.location.LocationListener#onLocationChanged LocationListener#onLocationChanged} method will be called for
 * each location update
 * This value must never be {@code null}.
 * @param looper a Looper object whose message queue will be used to
 * implement the callback mechanism, or null to make callbacks on the calling
 * thread
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if provider is null or doesn't exist
 * @throws java.lang.IllegalArgumentException if listener is null
 * @throws java.lang.SecurityException if no suitable permission is present
 * @apiSince 1
 */

public void requestLocationUpdates(@androidx.annotation.NonNull java.lang.String provider, long minTime, float minDistance, @androidx.annotation.NonNull android.location.LocationListener listener, @androidx.annotation.Nullable android.os.Looper looper) { throw new RuntimeException("Stub!"); }

/**
 * Register for location updates using a Criteria, and a callback
 * on the specified looper thread.
 *
 * <p>See {@link #requestLocationUpdates(long,float,android.location.Criteria,android.app.PendingIntent)}
 * for more detail on how to use this method.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_COARSE_LOCATION} or {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param minTime minimum time interval between location updates, in milliseconds
 * @param minDistance minimum distance between location updates, in meters
 * @param criteria contains parameters for the location manager to choose the
 * appropriate provider and parameters to compute the location
 * This value must never be {@code null}.
 * @param listener a {@link android.location.LocationListener LocationListener} whose
 * {@link android.location.LocationListener#onLocationChanged LocationListener#onLocationChanged} method will be called for
 * each location update
 * This value must never be {@code null}.
 * @param looper a Looper object whose message queue will be used to
 * implement the callback mechanism, or null to make callbacks on the calling
 * thread
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if criteria is null
 * @throws java.lang.IllegalArgumentException if listener is null
 * @throws java.lang.SecurityException if no suitable permission is present
 * @apiSince 9
 */

public void requestLocationUpdates(long minTime, float minDistance, @androidx.annotation.NonNull android.location.Criteria criteria, @androidx.annotation.NonNull android.location.LocationListener listener, @androidx.annotation.Nullable android.os.Looper looper) { throw new RuntimeException("Stub!"); }

/**
 * Register for location updates using the named provider, and a
 * pending intent.
 *
 * <p>See {@link #requestLocationUpdates(long,float,android.location.Criteria,android.app.PendingIntent)}
 * for more detail on how to use this method.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_COARSE_LOCATION} or {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param provider the name of the provider with which to register
 * This value must never be {@code null}.
 * @param minTime minimum time interval between location updates, in milliseconds
 * @param minDistance minimum distance between location updates, in meters
 * @param intent a {@link android.app.PendingIntent PendingIntent} to be sent for each location update
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if provider is null or doesn't exist
 * on this device
 * @throws java.lang.IllegalArgumentException if intent is null
 * @throws java.lang.SecurityException if no suitable permission is present
 * @apiSince 3
 */

public void requestLocationUpdates(@androidx.annotation.NonNull java.lang.String provider, long minTime, float minDistance, @androidx.annotation.NonNull android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Register for location updates using a Criteria and pending intent.
 *
 * <p>The <code>requestLocationUpdates()</code> and
 * <code>requestSingleUpdate()</code> register the current activity to be
 * updated periodically by the named provider, or by the provider matching
 * the specified {@link android.location.Criteria Criteria}, with location and status updates.
 *
 * <p> It may take a while to receive the first location update. If
 * an immediate location is required, applications may use the
 * {@link #getLastKnownLocation(java.lang.String)} method.
 *
 * <p> Location updates are received either by {@link android.location.LocationListener LocationListener}
 * callbacks, or by broadcast intents to a supplied {@link android.app.PendingIntent PendingIntent}.
 *
 * <p> If the caller supplied a pending intent, then location updates
 * are sent with a key of {@link #KEY_LOCATION_CHANGED} and a
 * {@link android.location.Location} value.
 *
 * <p> The location update interval can be controlled using the minTime parameter.
 * The elapsed time between location updates will never be less than
 * minTime, although it can be more depending on the Location Provider
 * implementation and the update interval requested by other applications.
 *
 * <p> Choosing a sensible value for minTime is important to conserve
 * battery life. Each location update requires power from
 * GPS, WIFI, Cell and other radios. Select a minTime value as high as
 * possible while still providing a reasonable user experience.
 * If your application is not in the foreground and showing
 * location to the user then your application should avoid using an active
 * provider (such as {@link #NETWORK_PROVIDER} or {@link #GPS_PROVIDER}),
 * but if you insist then select a minTime of 5 * 60 * 1000 (5 minutes)
 * or greater. If your application is in the foreground and showing
 * location to the user then it is appropriate to select a faster
 * update interval.
 *
 * <p> The minDistance parameter can also be used to control the
 * frequency of location updates. If it is greater than 0 then the
 * location provider will only send your application an update when
 * the location has changed by at least minDistance meters, AND
 * at least minTime milliseconds have passed. However it is more
 * difficult for location providers to save power using the minDistance
 * parameter, so minTime should be the primary tool to conserving battery
 * life.
 *
 * <p> If your application wants to passively observe location
 * updates triggered by other applications, but not consume
 * any additional power otherwise, then use the {@link #PASSIVE_PROVIDER}
 * This provider does not actively turn on or modify active location
 * providers, so you do not need to be as careful about minTime and
 * minDistance. However if your application performs heavy work
 * on a location update (such as network activity) then you should
 * select non-zero values for minTime and/or minDistance to rate-limit
 * your update frequency in the case another application enables a
 * location provider with extremely fast updates.
 *
 * <p>In case the provider is disabled by the user, updates will stop,
 * and a provider availability update will be sent.
 * As soon as the provider is enabled again,
 * location updates will immediately resume and a provider availability
 * update sent. Providers can also send status updates, at any time,
 * with extra's specific to the provider. If a callback was supplied
 * then status and availability updates are via
 * {@link android.location.LocationListener#onProviderDisabled LocationListener#onProviderDisabled},
 * {@link android.location.LocationListener#onProviderEnabled LocationListener#onProviderEnabled} or
 * {@link android.location.LocationListener#onStatusChanged LocationListener#onStatusChanged}. Alternately, if a
 * pending intent was supplied then status and availability updates
 * are broadcast intents with extra keys of
 * {@link #KEY_PROVIDER_ENABLED} or {@link #KEY_STATUS_CHANGED}.
 *
 * <p> If a {@link android.location.LocationListener LocationListener} is used but with no Looper specified
 * then the calling thread must already
 * be a {@link android.os.Looper} thread such as the main thread of the
 * calling Activity. If a Looper is specified with a {@link android.location.LocationListener LocationListener}
 * then callbacks are made on the supplied Looper thread.
 *
 * <p> When location callbacks are invoked, the system will hold a wakelock
 * on your application's behalf for some period of time, but not
 * indefinitely. If your application requires a long running wakelock
 * within the location callback, you should acquire it yourself.
 *
 * <p class="note"> Prior to Jellybean, the minTime parameter was
 * only a hint, and some location provider implementations ignored it.
 * From Jellybean and onwards it is mandatory for Android compatible
 * devices to observe both the minTime and minDistance parameters.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_COARSE_LOCATION} or {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param minTime minimum time interval between location updates, in milliseconds
 * @param minDistance minimum distance between location updates, in meters
 * @param criteria contains parameters for the location manager to choose the
 * appropriate provider and parameters to compute the location
 * This value must never be {@code null}.
 * @param intent a {@link android.app.PendingIntent PendingIntent} to be sent for each location update
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if criteria is null
 * @throws java.lang.IllegalArgumentException if intent is null
 * @throws java.lang.SecurityException if no suitable permission is present
 * @apiSince 9
 */

public void requestLocationUpdates(long minTime, float minDistance, @androidx.annotation.NonNull android.location.Criteria criteria, @androidx.annotation.NonNull android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Register for a single location update using the named provider and
 * a callback.
 *
 * <p>See {@link #requestLocationUpdates(long,float,android.location.Criteria,android.app.PendingIntent)}
 * for more detail on how to use this method.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_COARSE_LOCATION} or {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param provider the name of the provider with which to register
 * This value must never be {@code null}.
 * @param listener a {@link android.location.LocationListener LocationListener} whose
 * {@link android.location.LocationListener#onLocationChanged LocationListener#onLocationChanged} method will be called when
 * the location update is available
 * This value must never be {@code null}.
 * @param looper a Looper object whose message queue will be used to
 * implement the callback mechanism, or null to make callbacks on the calling
 * thread
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if provider is null or doesn't exist
 * @throws java.lang.IllegalArgumentException if listener is null
 * @throws java.lang.SecurityException if no suitable permission is present
 * @apiSince 9
 */

public void requestSingleUpdate(@androidx.annotation.NonNull java.lang.String provider, @androidx.annotation.NonNull android.location.LocationListener listener, @androidx.annotation.Nullable android.os.Looper looper) { throw new RuntimeException("Stub!"); }

/**
 * Register for a single location update using a Criteria and
 * a callback.
 *
 * <p>See {@link #requestLocationUpdates(long,float,android.location.Criteria,android.app.PendingIntent)}
 * for more detail on how to use this method.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_COARSE_LOCATION} or {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param criteria contains parameters for the location manager to choose the
 * appropriate provider and parameters to compute the location
 * This value must never be {@code null}.
 * @param listener a {@link android.location.LocationListener LocationListener} whose
 * {@link android.location.LocationListener#onLocationChanged LocationListener#onLocationChanged} method will be called when
 * the location update is available
 * This value must never be {@code null}.
 * @param looper a Looper object whose message queue will be used to
 * implement the callback mechanism, or null to make callbacks on the calling
 * thread
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if criteria is null
 * @throws java.lang.IllegalArgumentException if listener is null
 * @throws java.lang.SecurityException if no suitable permission is present
 * @apiSince 9
 */

public void requestSingleUpdate(@androidx.annotation.NonNull android.location.Criteria criteria, @androidx.annotation.NonNull android.location.LocationListener listener, @androidx.annotation.Nullable android.os.Looper looper) { throw new RuntimeException("Stub!"); }

/**
 * Register for a single location update using a named provider and pending intent.
 *
 * <p>See {@link #requestLocationUpdates(long,float,android.location.Criteria,android.app.PendingIntent)}
 * for more detail on how to use this method.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_COARSE_LOCATION} or {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param provider the name of the provider with which to register
 * This value must never be {@code null}.
 * @param intent a {@link android.app.PendingIntent PendingIntent} to be sent for the location update
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if provider is null or doesn't exist
 * @throws java.lang.IllegalArgumentException if intent is null
 * @throws java.lang.SecurityException if no suitable permission is present
 * @apiSince 9
 */

public void requestSingleUpdate(@androidx.annotation.NonNull java.lang.String provider, @androidx.annotation.NonNull android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Register for a single location update using a Criteria and pending intent.
 *
 * <p>See {@link #requestLocationUpdates(long,float,android.location.Criteria,android.app.PendingIntent)}
 * for more detail on how to use this method.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_COARSE_LOCATION} or {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param criteria contains parameters for the location manager to choose the
 * appropriate provider and parameters to compute the location
 * This value must never be {@code null}.
 * @param intent a {@link android.app.PendingIntent PendingIntent} to be sent for the location update
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if provider is null or doesn't exist
 * @throws java.lang.IllegalArgumentException if intent is null
 * @throws java.lang.SecurityException if no suitable permission is present
 * @apiSince 9
 */

public void requestSingleUpdate(@androidx.annotation.NonNull android.location.Criteria criteria, @androidx.annotation.NonNull android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Removes all location updates for the specified LocationListener.
 *
 * <p>Following this call, updates will no longer
 * occur for this listener.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_COARSE_LOCATION} or {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param listener listener object that no longer needs location updates
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if listener is null
 * @apiSince 1
 */

public void removeUpdates(@androidx.annotation.NonNull android.location.LocationListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Removes all location updates for the specified pending intent.
 *
 * <p>Following this call, updates will no longer for this pending intent.
 *
 * @param intent pending intent object that no longer needs location updates
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if intent is null
 * @apiSince 3
 */

public void removeUpdates(@androidx.annotation.NonNull android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Set a proximity alert for the location given by the position
 * (latitude, longitude) and the given radius.
 *
 * <p> When the device
 * detects that it has entered or exited the area surrounding the
 * location, the given PendingIntent will be used to create an Intent
 * to be fired.
 *
 * <p> The fired Intent will have a boolean extra added with key
 * {@link #KEY_PROXIMITY_ENTERING}. If the value is true, the device is
 * entering the proximity region; if false, it is exiting.
 *
 * <p> Due to the approximate nature of position estimation, if the
 * device passes through the given area briefly, it is possible
 * that no Intent will be fired.  Similarly, an Intent could be
 * fired if the device passes very close to the given area but
 * does not actually enter it.
 *
 * <p> After the number of milliseconds given by the expiration
 * parameter, the location manager will delete this proximity
 * alert and no longer monitor it.  A value of -1 indicates that
 * there should be no expiration time.
 *
 * <p> Internally, this method uses both {@link #NETWORK_PROVIDER}
 * and {@link #GPS_PROVIDER}.
 *
 * <p>Before API version 17, this method could be used with
 * {@link android.Manifest.permission#ACCESS_FINE_LOCATION} or
 * {@link android.Manifest.permission#ACCESS_COARSE_LOCATION}.
 * From API version 17 and onwards, this method requires
 * {@link android.Manifest.permission#ACCESS_FINE_LOCATION} permission.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_COARSE_LOCATION} or {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param latitude the latitude of the central point of the
 * alert region
 * @param longitude the longitude of the central point of the
 * alert region
 * @param radius the radius of the central point of the
 * alert region, in meters
 * @param expiration time for this proximity alert, in milliseconds,
 * or -1 to indicate no expiration
 * @param intent a PendingIntent that will be used to generate an Intent to
 * fire when entry to or exit from the alert region is detected
 *
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * permission is not present
 * @apiSince 1
 */

public void addProximityAlert(double latitude, double longitude, float radius, long expiration, @androidx.annotation.NonNull android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Removes the proximity alert with the given PendingIntent.
 *
 * <p>Before API version 17, this method could be used with
 * {@link android.Manifest.permission#ACCESS_FINE_LOCATION} or
 * {@link android.Manifest.permission#ACCESS_COARSE_LOCATION}.
 * From API version 17 and onwards, this method requires
 * {@link android.Manifest.permission#ACCESS_FINE_LOCATION} permission.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_COARSE_LOCATION} or {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param intent the PendingIntent that no longer needs to be notified of
 * proximity alerts
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if intent is null
 * @throws java.lang.SecurityException if {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * permission is not present
 * @apiSince 1
 */

public void removeProximityAlert(@androidx.annotation.NonNull android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current enabled/disabled state of location. To listen for changes, see
 * {@link #MODE_CHANGED_ACTION}.
 *
 * @return true if location is enabled and false if location is disabled.
 * @apiSince 28
 */

public boolean isLocationEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current enabled/disabled status of the given provider. To listen for changes, see
 * {@link #PROVIDERS_CHANGED_ACTION}.
 *
 * Before API version {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this method would throw
 * {@link java.lang.SecurityException SecurityException} if the location permissions were not sufficient to use the
 * specified provider.
 *
 * @param provider the name of the provider
 * This value must never be {@code null}.
 * @return true if the provider exists and is enabled
 *
 * @throws java.lang.IllegalArgumentException if provider is null
 * @apiSince 1
 */

public boolean isProviderEnabled(@androidx.annotation.NonNull java.lang.String provider) { throw new RuntimeException("Stub!"); }

/**
 * Returns a Location indicating the data from the last known
 * location fix obtained from the given provider.
 *
 * <p> This can be done
 * without starting the provider.  Note that this location could
 * be out-of-date, for example if the device was turned off and
 * moved to another location.
 *
 * <p> If the provider is currently disabled, null is returned.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_COARSE_LOCATION} or {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param provider the name of the provider
 * This value must never be {@code null}.
 * @return the last known location for the provider, or null
 *
 * @throws java.lang.SecurityException if no suitable permission is present
 * @throws java.lang.IllegalArgumentException if provider is null or doesn't exist
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.location.Location getLastKnownLocation(@androidx.annotation.NonNull java.lang.String provider) { throw new RuntimeException("Stub!"); }

/**
 * Creates a mock location provider and adds it to the set of active providers.
 *
 * @param name the provider name
 *
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@link android.app.AppOpsManager#OPSTR_MOCK_LOCATION
 * mock location app op} is not set to {@link android.app.AppOpsManager#MODE_ALLOWED
 * allowed} for your app.
 * @throws java.lang.IllegalArgumentException if a provider with the given name already exists
 * @apiSince 3
 */

public void addTestProvider(@androidx.annotation.NonNull java.lang.String name, boolean requiresNetwork, boolean requiresSatellite, boolean requiresCell, boolean hasMonetaryCost, boolean supportsAltitude, boolean supportsSpeed, boolean supportsBearing, int powerRequirement, int accuracy) { throw new RuntimeException("Stub!"); }

/**
 * Removes the mock location provider with the given name.
 *
 * @param provider the provider name
 *
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@link android.app.AppOpsManager#OPSTR_MOCK_LOCATION
 * mock location app op} is not set to {@link android.app.AppOpsManager#MODE_ALLOWED
 * allowed} for your app.
 * @throws java.lang.IllegalArgumentException if no provider with the given name exists
 * @apiSince 3
 */

public void removeTestProvider(@androidx.annotation.NonNull java.lang.String provider) { throw new RuntimeException("Stub!"); }

/**
 * Sets a mock location for the given provider.
 * <p>This location will be used in place of any actual location from the provider.
 * The location object must have a minimum number of fields set to be
 * considered a valid LocationProvider Location, as per documentation
 * on {@link android.location.Location Location} class.
 *
 * @param provider the provider name
 * This value must never be {@code null}.
 * @param loc the mock location
 *
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@link android.app.AppOpsManager#OPSTR_MOCK_LOCATION
 * mock location app op} is not set to {@link android.app.AppOpsManager#MODE_ALLOWED
 * allowed} for your app.
 * @throws java.lang.IllegalArgumentException if no provider with the given name exists
 * @throws java.lang.IllegalArgumentException if the location is incomplete
 * @apiSince 3
 */

public void setTestProviderLocation(@androidx.annotation.NonNull java.lang.String provider, @androidx.annotation.NonNull android.location.Location loc) { throw new RuntimeException("Stub!"); }

/**
 * Removes any mock location associated with the given provider.
 *
 * @param provider the provider name
 *
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@link android.app.AppOpsManager#OPSTR_MOCK_LOCATION
 * mock location app op} is not set to {@link android.app.AppOpsManager#MODE_ALLOWED
 * allowed} for your app.
 * @throws java.lang.IllegalArgumentException if no provider with the given name exists
 *
 * @deprecated This function has always been a no-op, and may be removed in the future.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public void clearTestProviderLocation(@androidx.annotation.NonNull java.lang.String provider) { throw new RuntimeException("Stub!"); }

/**
 * Sets a mock enabled value for the given provider.  This value will be used in place
 * of any actual value from the provider.
 *
 * @param provider the provider name
 * This value must never be {@code null}.
 * @param enabled the mock enabled value
 *
 * @throws java.lang.SecurityException if {@link android.app.AppOpsManager#OPSTR_MOCK_LOCATION
 * mock location app op} is not set to {@link android.app.AppOpsManager#MODE_ALLOWED
 * allowed} for your app.
 * @throws java.lang.IllegalArgumentException if no provider with the given name exists
 * @apiSince 3
 */

public void setTestProviderEnabled(@androidx.annotation.NonNull java.lang.String provider, boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Removes any mock enabled value associated with the given provider.
 *
 * @param provider the provider name
 *
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@link android.app.AppOpsManager#OPSTR_MOCK_LOCATION
 * mock location app op} is not set to {@link android.app.AppOpsManager#MODE_ALLOWED
 * allowed} for your app.
 * @throws java.lang.IllegalArgumentException if no provider with the given name exists
 *
 * @deprecated Use {@link #setTestProviderEnabled(java.lang.String,boolean)} instead.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public void clearTestProviderEnabled(@androidx.annotation.NonNull java.lang.String provider) { throw new RuntimeException("Stub!"); }

/**
 * This method has no effect as provider status has been deprecated and is no longer supported.
 *
 * @param provider the provider name
 * This value must never be {@code null}.
 * @param status the mock status
 * @param extras a Bundle containing mock extras
 * This value may be {@code null}.
 * @param updateTime the mock update time
 *
 * @throws java.lang.SecurityException if {@link android.app.AppOpsManager#OPSTR_MOCK_LOCATION
 * mock location app op} is not set to {@link android.app.AppOpsManager#MODE_ALLOWED
 * allowed} for your app.
 * @throws java.lang.IllegalArgumentException if no provider with the given name exists
 *
 * @deprecated This method has no effect.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public void setTestProviderStatus(@androidx.annotation.NonNull java.lang.String provider, int status, @androidx.annotation.Nullable android.os.Bundle extras, long updateTime) { throw new RuntimeException("Stub!"); }

/**
 * This method has no effect as provider status has been deprecated and is no longer supported.
 *
 * @param provider the provider name
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@link android.app.AppOpsManager#OPSTR_MOCK_LOCATION
 * mock location app op} is not set to {@link android.app.AppOpsManager#MODE_ALLOWED
 * allowed} for your app.
 * @throws java.lang.IllegalArgumentException if no provider with the given name exists
 *
 * @deprecated This method has no effect.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public void clearTestProviderStatus(@androidx.annotation.NonNull java.lang.String provider) { throw new RuntimeException("Stub!"); }

/**
 * Adds a GPS status listener.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param listener GPS status listener object to register
 *
 * @return true if the listener was successfully added
 *
 * @throws java.lang.SecurityException if the ACCESS_FINE_LOCATION permission is not present
 * @deprecated use {@link #registerGnssStatusCallback(android.location.GnssStatus.Callback)} instead.
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public boolean addGpsStatusListener(android.location.GpsStatus.Listener listener) { throw new RuntimeException("Stub!"); }

/**
 * Removes a GPS status listener.
 *
 * @param listener GPS status listener object to remove
 * @deprecated use {@link #unregisterGnssStatusCallback(android.location.GnssStatus.Callback)} instead.
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public void removeGpsStatusListener(android.location.GpsStatus.Listener listener) { throw new RuntimeException("Stub!"); }

/**
 * Registers a GNSS status callback.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param callback GNSS status callback object to register
 *
 * This value must never be {@code null}.
 * @return true if the listener was successfully added
 *
 * @throws java.lang.SecurityException if the ACCESS_FINE_LOCATION permission is not present
 * @apiSince 24
 */

public boolean registerGnssStatusCallback(@androidx.annotation.NonNull android.location.GnssStatus.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Registers a GNSS status callback.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param callback GNSS status callback object to register
 * This value must never be {@code null}.
 * @param handler the handler that the callback runs on.
 *
 * This value may be {@code null}.
 * @return true if the listener was successfully added
 *
 * @throws java.lang.SecurityException if the ACCESS_FINE_LOCATION permission is not present
 * @apiSince 24
 */

public boolean registerGnssStatusCallback(@androidx.annotation.NonNull android.location.GnssStatus.Callback callback, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Removes a GNSS status callback.
 *
 * @param callback GNSS status callback object to remove
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public void unregisterGnssStatusCallback(@androidx.annotation.NonNull android.location.GnssStatus.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Adds an NMEA listener.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param listener a {@link android.location.OnNmeaMessageListener OnNmeaMessageListener} object to register
 *
 * This value must never be {@code null}.
 * @return true if the listener was successfully added
 *
 * @throws java.lang.SecurityException if the ACCESS_FINE_LOCATION permission is not present
 * @apiSince 24
 */

public boolean addNmeaListener(@androidx.annotation.NonNull android.location.OnNmeaMessageListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Adds an NMEA listener.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param listener a {@link android.location.OnNmeaMessageListener OnNmeaMessageListener} object to register
 * This value must never be {@code null}.
 * @param handler the handler that the listener runs on.
 *
 * This value may be {@code null}.
 * @return true if the listener was successfully added
 *
 * @throws java.lang.SecurityException if the ACCESS_FINE_LOCATION permission is not present
 * @apiSince 24
 */

public boolean addNmeaListener(@androidx.annotation.NonNull android.location.OnNmeaMessageListener listener, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Removes an NMEA listener.
 *
 * @param listener a {@link android.location.OnNmeaMessageListener OnNmeaMessageListener} object to remove
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public void removeNmeaListener(@androidx.annotation.NonNull android.location.OnNmeaMessageListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Registers a GPS Measurement callback.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param callback a {@link android.location.GnssMeasurementsEvent.Callback GnssMeasurementsEvent.Callback} object to register.
 * This value must never be {@code null}.
 * @return {@code true} if the callback was added successfully, {@code false} otherwise.
 * @apiSince 24
 */

public boolean registerGnssMeasurementsCallback(@androidx.annotation.NonNull android.location.GnssMeasurementsEvent.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Registers a GPS Measurement callback.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param callback a {@link android.location.GnssMeasurementsEvent.Callback GnssMeasurementsEvent.Callback} object to register.
 * This value must never be {@code null}.
 * @param handler the handler that the callback runs on.
 * This value may be {@code null}.
 * @return {@code true} if the callback was added successfully, {@code false} otherwise.
 * @apiSince 24
 */

public boolean registerGnssMeasurementsCallback(@androidx.annotation.NonNull android.location.GnssMeasurementsEvent.Callback callback, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a GPS Measurement callback.
 *
 * @param callback a {@link android.location.GnssMeasurementsEvent.Callback GnssMeasurementsEvent.Callback} object to remove.
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public void unregisterGnssMeasurementsCallback(@androidx.annotation.NonNull android.location.GnssMeasurementsEvent.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Registers a GNSS Navigation Message callback.
 *
 * @param callback a {@link android.location.GnssNavigationMessage.Callback GnssNavigationMessage.Callback} object to register.
 * This value must never be {@code null}.
 * @return {@code true} if the callback was added successfully, {@code false} otherwise.
 * @apiSince 24
 */

public boolean registerGnssNavigationMessageCallback(@androidx.annotation.NonNull android.location.GnssNavigationMessage.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Registers a GNSS Navigation Message callback.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param callback a {@link android.location.GnssNavigationMessage.Callback GnssNavigationMessage.Callback} object to register.
 * This value must never be {@code null}.
 * @param handler the handler that the callback runs on.
 * This value may be {@code null}.
 * @return {@code true} if the callback was added successfully, {@code false} otherwise.
 * @apiSince 24
 */

public boolean registerGnssNavigationMessageCallback(@androidx.annotation.NonNull android.location.GnssNavigationMessage.Callback callback, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a GNSS Navigation Message callback.
 *
 * @param callback a {@link android.location.GnssNavigationMessage.Callback GnssNavigationMessage.Callback} object to remove.
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public void unregisterGnssNavigationMessageCallback(@androidx.annotation.NonNull android.location.GnssNavigationMessage.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves information about the current status of the GPS engine.
 * This should only be called from the {@link android.location.GpsStatus.Listener#onGpsStatusChanged GpsStatus.Listener#onGpsStatusChanged}
 * callback to ensure that the data is copied atomically.
 *
 * The caller may either pass in a {@link android.location.GpsStatus GpsStatus} object to set with the latest
 * status information, or pass null to create a new {@link android.location.GpsStatus GpsStatus} object.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param status object containing GPS status details, or null.
 * This value may be {@code null}.
 * @return status object containing updated GPS status.
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
@androidx.annotation.Nullable
public android.location.GpsStatus getGpsStatus(@androidx.annotation.Nullable android.location.GpsStatus status) { throw new RuntimeException("Stub!"); }

/**
 * Returns the model year of the GNSS hardware and software build.
 *
 * <p> More details, such as build date, may be available in {@link #getGnssHardwareModelName()}.
 *
 * <p> May return 0 if the model year is less than 2016.
 * @apiSince 28
 */

public int getGnssYearOfHardware() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Model Name (including Vendor and Hardware/Software Version) of the GNSS hardware
 * driver.
 *
 * <p> No device-specific serial number or ID is returned from this API.
 *
 * <p> Will return null when the GNSS hardware abstraction layer does not support providing
 * this value.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getGnssHardwareModelName() { throw new RuntimeException("Stub!"); }

/**
 * Sends additional commands to a location provider.
 * Can be used to support provider specific extensions to the Location Manager API
 *
 * @param provider name of the location provider.
 * This value must never be {@code null}.
 * @param command name of the command to send to the provider.
 * This value must never be {@code null}.
 * @param extras optional arguments for the command (or null).
 * The provider may optionally fill the extras Bundle with results from the command.
 *
 * This value may be {@code null}.
 * @return true if the command succeeds.
 * @apiSince 3
 */

public boolean sendExtraCommand(@androidx.annotation.NonNull java.lang.String provider, @androidx.annotation.NonNull java.lang.String command, @androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Intent extra included with {@link #PROVIDERS_CHANGED_ACTION} broadcasts, containing the name
 * of the location provider that has changed, to be used with location provider APIs.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_PROVIDER_NAME = "android.location.extra.PROVIDER_NAME";

/**
 * Name of the GPS location provider.
 *
 * <p>This provider determines location using
 * satellites. Depending on conditions, this provider may take a while to return
 * a location fix. Requires the permission
 * {@link android.Manifest.permission#ACCESS_FINE_LOCATION}.
 *
 * <p> The extras Bundle for the GPS location provider can contain the
 * following key/value pairs:
 * <ul>
 * <li> satellites - the number of satellites used to derive the fix
 * </ul>
 * @apiSince 1
 */

public static final java.lang.String GPS_PROVIDER = "gps";

/**
 * Key used for a Bundle extra holding a Location value
 * when a location change is broadcast using a PendingIntent.
 * @apiSince 3
 */

public static final java.lang.String KEY_LOCATION_CHANGED = "location";

/**
 * Key used for a Bundle extra holding an Boolean status value
 * when a provider enabled/disabled event is broadcast using a PendingIntent.
 * @apiSince 3
 */

public static final java.lang.String KEY_PROVIDER_ENABLED = "providerEnabled";

/**
 * Key used for the Bundle extra holding a boolean indicating whether
 * a proximity alert is entering (true) or exiting (false)..
 * @apiSince 1
 */

public static final java.lang.String KEY_PROXIMITY_ENTERING = "entering";

/**
 * This key is no longer in use.
 *
 * Key used for a Bundle extra holding an Integer status value
 * when a status change is broadcast using a PendingIntent.
 *
 * @deprecated Status changes are deprecated and no longer broadcast.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String KEY_STATUS_CHANGED = "status";

/**
 * Broadcast intent action when the device location mode changes. To check the location mode,
 * use {@link #isLocationEnabled()}.
 * @apiSince 19
 */

public static final java.lang.String MODE_CHANGED_ACTION = "android.location.MODE_CHANGED";

/**
 * Name of the network location provider.
 * <p>This provider determines location based on
 * availability of cell tower and WiFi access points. Results are retrieved
 * by means of a network lookup.
 * @apiSince 1
 */

public static final java.lang.String NETWORK_PROVIDER = "network";

/**
 * A special location provider for receiving locations without actually initiating
 * a location fix.
 *
 * <p>This provider can be used to passively receive location updates
 * when other applications or services request them without actually requesting
 * the locations yourself.  This provider will return locations generated by other
 * providers.  You can query the {@link android.location.Location#getProvider() Location#getProvider()} method to determine
 * the origin of the location update. Requires the permission
 * {@link android.Manifest.permission#ACCESS_FINE_LOCATION}, although if the GPS is
 * not enabled this provider might only return coarse fixes.
 * @apiSince 8
 */

public static final java.lang.String PASSIVE_PROVIDER = "passive";

/**
 * Broadcast intent action when the set of enabled location providers changes. To check the
 * status of a provider, use {@link #isProviderEnabled(java.lang.String)}. From Android Q and above, will
 * include a string intent extra, {@link #EXTRA_PROVIDER_NAME}, with the name of the provider
 * whose state has changed.
 *
 * @see #EXTRA_PROVIDER_NAME
 * @apiSince 9
 */

public static final java.lang.String PROVIDERS_CHANGED_ACTION = "android.location.PROVIDERS_CHANGED";
}

