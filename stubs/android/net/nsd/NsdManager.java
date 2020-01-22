/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.net.nsd;


/**
 * The Network Service Discovery Manager class provides the API to discover services
 * on a network. As an example, if device A and device B are connected over a Wi-Fi
 * network, a game registered on device A can be discovered by a game on device
 * B. Another example use case is an application discovering printers on the network.
 *
 * <p> The API currently supports DNS based service discovery and discovery is currently
 * limited to a local network over Multicast DNS. DNS service discovery is described at
 * http://files.dns-sd.org/draft-cheshire-dnsext-dns-sd.txt
 *
 * <p> The API is asynchronous and responses to requests from an application are on listener
 * callbacks on a seperate internal thread.
 *
 * <p> There are three main operations the API supports - registration, discovery and resolution.
 * <pre>
 *                          Application start
 *                                 |
 *                                 |
 *                                 |                  onServiceRegistered()
 *                     Register any local services  /
 *                      to be advertised with       \
 *                       registerService()            onRegistrationFailed()
 *                                 |
 *                                 |
 *                          discoverServices()
 *                                 |
 *                      Maintain a list to track
 *                        discovered services
 *                                 |
 *                                 |--------->
 *                                 |          |
 *                                 |      onServiceFound()
 *                                 |          |
 *                                 |     add service to list
 *                                 |          |
 *                                 |<----------
 *                                 |
 *                                 |--------->
 *                                 |          |
 *                                 |      onServiceLost()
 *                                 |          |
 *                                 |   remove service from list
 *                                 |          |
 *                                 |<----------
 *                                 |
 *                                 |
 *                                 | Connect to a service
 *                                 | from list ?
 *                                 |
 *                          resolveService()
 *                                 |
 *                         onServiceResolved()
 *                                 |
 *                     Establish connection to service
 *                     with the host and port information
 *
 * </pre>
 * An application that needs to advertise itself over a network for other applications to
 * discover it can do so with a call to {@link #registerService}. If Example is a http based
 * application that can provide HTML data to peer services, it can register a name "Example"
 * with service type "_http._tcp". A successful registration is notified with a callback to
 * {@link android.net.nsd.NsdManager.RegistrationListener#onServiceRegistered RegistrationListener#onServiceRegistered} and a failure to register is notified
 * over {@link android.net.nsd.NsdManager.RegistrationListener#onRegistrationFailed RegistrationListener#onRegistrationFailed}
 *
 * <p> A peer application looking for http services can initiate a discovery for "_http._tcp"
 * with a call to {@link #discoverServices}. A service found is notified with a callback
 * to {@link android.net.nsd.NsdManager.DiscoveryListener#onServiceFound DiscoveryListener#onServiceFound} and a service lost is notified on
 * {@link android.net.nsd.NsdManager.DiscoveryListener#onServiceLost DiscoveryListener#onServiceLost}.
 *
 * <p> Once the peer application discovers the "Example" http service, and either needs to read the
 * attributes of the service or wants to receive data from the "Example" application, it can
 * initiate a resolve with {@link #resolveService} to resolve the attributes, host, and port
 * details. A successful resolve is notified on {@link android.net.nsd.NsdManager.ResolveListener#onServiceResolved ResolveListener#onServiceResolved} and a
 * failure is notified on {@link android.net.nsd.NsdManager.ResolveListener#onResolveFailed ResolveListener#onResolveFailed}.
 *
 * Applications can reserve for a service type at
 * http://www.iana.org/form/ports-service. Existing services can be found at
 * http://www.iana.org/assignments/service-names-port-numbers/service-names-port-numbers.xml
 *
 * {@see NsdServiceInfo}
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NsdManager {

NsdManager() { throw new RuntimeException("Stub!"); }

/**
 * Register a service to be discovered by other services.
 *
 * <p> The function call immediately returns after sending a request to register service
 * to the framework. The application is notified of a successful registration
 * through the callback {@link android.net.nsd.NsdManager.RegistrationListener#onServiceRegistered RegistrationListener#onServiceRegistered} or a failure
 * through {@link android.net.nsd.NsdManager.RegistrationListener#onRegistrationFailed RegistrationListener#onRegistrationFailed}.
 *
 * <p> The application should call {@link #unregisterService} when the service
 * registration is no longer required, and/or whenever the application is stopped.
 *
 * @param serviceInfo The service being registered
 * @param protocolType The service discovery protocol
 * @param listener The listener notifies of a successful registration and is used to
 * unregister this service through a call on {@link #unregisterService}. Cannot be null.
 * Cannot be in use for an active service registration.
 * @apiSince 16
 */

public void registerService(android.net.nsd.NsdServiceInfo serviceInfo, int protocolType, android.net.nsd.NsdManager.RegistrationListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Unregister a service registered through {@link #registerService}. A successful
 * unregister is notified to the application with a call to
 * {@link android.net.nsd.NsdManager.RegistrationListener#onServiceUnregistered RegistrationListener#onServiceUnregistered}.
 *
 * @param listener This should be the listener object that was passed to
 * {@link #registerService}. It identifies the service that should be unregistered
 * and notifies of a successful or unsuccessful unregistration via the listener
 * callbacks.  In API versions 20 and above, the listener object may be used for
 * another service registration once the callback has been called.  In API versions <= 19,
 * there is no entirely reliable way to know when a listener may be re-used, and a new
 * listener should be created for each service registration request.
 * @apiSince 16
 */

public void unregisterService(android.net.nsd.NsdManager.RegistrationListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Initiate service discovery to browse for instances of a service type. Service discovery
 * consumes network bandwidth and will continue until the application calls
 * {@link #stopServiceDiscovery}.
 *
 * <p> The function call immediately returns after sending a request to start service
 * discovery to the framework. The application is notified of a success to initiate
 * discovery through the callback {@link android.net.nsd.NsdManager.DiscoveryListener#onDiscoveryStarted DiscoveryListener#onDiscoveryStarted} or a failure
 * through {@link android.net.nsd.NsdManager.DiscoveryListener#onStartDiscoveryFailed DiscoveryListener#onStartDiscoveryFailed}.
 *
 * <p> Upon successful start, application is notified when a service is found with
 * {@link android.net.nsd.NsdManager.DiscoveryListener#onServiceFound DiscoveryListener#onServiceFound} or when a service is lost with
 * {@link android.net.nsd.NsdManager.DiscoveryListener#onServiceLost DiscoveryListener#onServiceLost}.
 *
 * <p> Upon failure to start, service discovery is not active and application does
 * not need to invoke {@link #stopServiceDiscovery}
 *
 * <p> The application should call {@link #stopServiceDiscovery} when discovery of this
 * service type is no longer required, and/or whenever the application is paused or
 * stopped.
 *
 * @param serviceType The service type being discovered. Examples include "_http._tcp" for
 * http services or "_ipp._tcp" for printers
 * @param protocolType The service discovery protocol
 * @param listener  The listener notifies of a successful discovery and is used
 * to stop discovery on this serviceType through a call on {@link #stopServiceDiscovery}.
 * Cannot be null. Cannot be in use for an active service discovery.
 * @apiSince 16
 */

public void discoverServices(java.lang.String serviceType, int protocolType, android.net.nsd.NsdManager.DiscoveryListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Stop service discovery initiated with {@link #discoverServices}.  An active service
 * discovery is notified to the application with {@link android.net.nsd.NsdManager.DiscoveryListener#onDiscoveryStarted DiscoveryListener#onDiscoveryStarted}
 * and it stays active until the application invokes a stop service discovery. A successful
 * stop is notified to with a call to {@link android.net.nsd.NsdManager.DiscoveryListener#onDiscoveryStopped DiscoveryListener#onDiscoveryStopped}.
 *
 * <p> Upon failure to stop service discovery, application is notified through
 * {@link android.net.nsd.NsdManager.DiscoveryListener#onStopDiscoveryFailed DiscoveryListener#onStopDiscoveryFailed}.
 *
 * @param listener This should be the listener object that was passed to {@link #discoverServices}.
 * It identifies the discovery that should be stopped and notifies of a successful or
 * unsuccessful stop.  In API versions 20 and above, the listener object may be used for
 * another service discovery once the callback has been called.  In API versions <= 19,
 * there is no entirely reliable way to know when a listener may be re-used, and a new
 * listener should be created for each service discovery request.
 * @apiSince 16
 */

public void stopServiceDiscovery(android.net.nsd.NsdManager.DiscoveryListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Resolve a discovered service. An application can resolve a service right before
 * establishing a connection to fetch the IP and port details on which to setup
 * the connection.
 *
 * @param serviceInfo service to be resolved
 * @param listener to receive callback upon success or failure. Cannot be null.
 * Cannot be in use for an active service resolution.
 * @apiSince 16
 */

public void resolveService(android.net.nsd.NsdServiceInfo serviceInfo, android.net.nsd.NsdManager.ResolveListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Broadcast intent action to indicate whether network service discovery is
 * enabled or disabled. An extra {@link #EXTRA_NSD_STATE} provides the state
 * information as int.
 *
 * @see #EXTRA_NSD_STATE
 * @apiSince 16
 */

public static final java.lang.String ACTION_NSD_STATE_CHANGED = "android.net.nsd.STATE_CHANGED";

/**
 * The lookup key for an int that indicates whether network service discovery is enabled
 * or disabled. Retrieve it with {@link android.content.Intent#getIntExtra(String,int)}.
 *
 * @see #NSD_STATE_DISABLED
 * @see #NSD_STATE_ENABLED
 * @apiSince 16
 */

public static final java.lang.String EXTRA_NSD_STATE = "nsd_state";

/**
 * Indicates that the operation failed because it is already active.
 * @apiSince 16
 */

public static final int FAILURE_ALREADY_ACTIVE = 3; // 0x3

/**
 * Failures are passed with {@link android.net.nsd.NsdManager.RegistrationListener#onRegistrationFailed RegistrationListener#onRegistrationFailed},
 * {@link android.net.nsd.NsdManager.RegistrationListener#onUnregistrationFailed RegistrationListener#onUnregistrationFailed},
 * {@link android.net.nsd.NsdManager.DiscoveryListener#onStartDiscoveryFailed DiscoveryListener#onStartDiscoveryFailed},
 * {@link android.net.nsd.NsdManager.DiscoveryListener#onStopDiscoveryFailed DiscoveryListener#onStopDiscoveryFailed} or {@link android.net.nsd.NsdManager.ResolveListener#onResolveFailed ResolveListener#onResolveFailed}.
 *
 * Indicates that the operation failed due to an internal error.
 * @apiSince 16
 */

public static final int FAILURE_INTERNAL_ERROR = 0; // 0x0

/**
 * Indicates that the operation failed because the maximum outstanding
 * requests from the applications have reached.
 * @apiSince 16
 */

public static final int FAILURE_MAX_LIMIT = 4; // 0x4

/**
 * Network service discovery is disabled
 *
 * @see #ACTION_NSD_STATE_CHANGED
 * @apiSince 16
 */

public static final int NSD_STATE_DISABLED = 1; // 0x1

/**
 * Network service discovery is enabled
 *
 * @see #ACTION_NSD_STATE_CHANGED
 * @apiSince 16
 */

public static final int NSD_STATE_ENABLED = 2; // 0x2

/**
 * Dns based service discovery protocol
 * @apiSince 16
 */

public static final int PROTOCOL_DNS_SD = 1; // 0x1
/**
 * Interface for callback invocation for service discovery
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface DiscoveryListener {

/** @apiSince 16 */

public void onStartDiscoveryFailed(java.lang.String serviceType, int errorCode);

/** @apiSince 16 */

public void onStopDiscoveryFailed(java.lang.String serviceType, int errorCode);

/** @apiSince 16 */

public void onDiscoveryStarted(java.lang.String serviceType);

/** @apiSince 16 */

public void onDiscoveryStopped(java.lang.String serviceType);

/** @apiSince 16 */

public void onServiceFound(android.net.nsd.NsdServiceInfo serviceInfo);

/** @apiSince 16 */

public void onServiceLost(android.net.nsd.NsdServiceInfo serviceInfo);
}

/**
 * Interface for callback invocation for service registration
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface RegistrationListener {

/** @apiSince 16 */

public void onRegistrationFailed(android.net.nsd.NsdServiceInfo serviceInfo, int errorCode);

/** @apiSince 16 */

public void onUnregistrationFailed(android.net.nsd.NsdServiceInfo serviceInfo, int errorCode);

/** @apiSince 16 */

public void onServiceRegistered(android.net.nsd.NsdServiceInfo serviceInfo);

/** @apiSince 16 */

public void onServiceUnregistered(android.net.nsd.NsdServiceInfo serviceInfo);
}

/**
 * Interface for callback invocation for service resolution
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ResolveListener {

/** @apiSince 16 */

public void onResolveFailed(android.net.nsd.NsdServiceInfo serviceInfo, int errorCode);

/** @apiSince 16 */

public void onServiceResolved(android.net.nsd.NsdServiceInfo serviceInfo);
}

}

