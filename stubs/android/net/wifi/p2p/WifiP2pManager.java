/*
 * Copyright (C) 2011 The Android Open Source Project
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


package android.net.wifi.p2p;

import android.net.wifi.WpsInfo;
import android.os.Looper;
import android.net.wifi.p2p.nsd.WifiP2pServiceInfo;
import android.net.wifi.p2p.nsd.WifiP2pUpnpServiceInfo;
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceInfo;
import android.net.wifi.p2p.nsd.WifiP2pServiceRequest;
import android.net.NetworkInfo;
import android.content.Context;
import java.util.List;

/**
 * This class provides the API for managing Wi-Fi peer-to-peer connectivity. This lets an
 * application discover available peers, setup connection to peers and query for the list of peers.
 * When a p2p connection is formed over wifi, the device continues to maintain the uplink
 * connection over mobile or any other available network for internet connectivity on the device.
 *
 * <p> The API is asynchronous and responses to requests from an application are on listener
 * callbacks provided by the application. The application needs to do an initialization with
 * {@link #initialize} before doing any p2p operation.
 *
 * <p> Most application calls need a {@link android.net.wifi.p2p.WifiP2pManager.ActionListener ActionListener} instance for receiving callbacks
 * {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onSuccess ActionListener#onSuccess} or {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}. Action callbacks
 * indicate whether the initiation of the action was a success or a failure.
 * Upon failure, the reason of failure can be one of {@link #ERROR}, {@link #P2P_UNSUPPORTED}
 * or {@link #BUSY}.
 *
 * <p> An application can initiate discovery of peers with {@link #discoverPeers}. An initiated
 * discovery request from an application stays active until the device starts connecting to a peer
 * ,forms a p2p group or there is an explicit {@link #stopPeerDiscovery}.
 * Applications can listen to {@link #WIFI_P2P_DISCOVERY_CHANGED_ACTION} to know if a peer-to-peer
 * discovery is running or stopped. Additionally, {@link #WIFI_P2P_PEERS_CHANGED_ACTION} indicates
 * if the peer list has changed.
 *
 * <p> When an application needs to fetch the current list of peers, it can request the list
 * of peers with {@link #requestPeers}. When the peer list is available
 * {@link android.net.wifi.p2p.WifiP2pManager.PeerListListener#onPeersAvailable PeerListListener#onPeersAvailable} is called with the device list.
 *
 * <p> An application can initiate a connection request to a peer through {@link #connect}. See
 * {@link android.net.wifi.p2p.WifiP2pConfig WifiP2pConfig} for details on setting up the configuration. For communication with legacy
 * Wi-Fi devices that do not support p2p, an app can create a group using {@link #createGroup}
 * which creates an access point whose details can be fetched with {@link #requestGroupInfo}.
 *
 * <p> After a successful group formation through {@link #createGroup} or through {@link #connect},
 * use {@link #requestConnectionInfo} to fetch the connection details. The connection info
 * {@link android.net.wifi.p2p.WifiP2pInfo WifiP2pInfo} contains the address of the group owner
 * {@link android.net.wifi.p2p.WifiP2pInfo#groupOwnerAddress WifiP2pInfo#groupOwnerAddress} and a flag {@link android.net.wifi.p2p.WifiP2pInfo#isGroupOwner WifiP2pInfo#isGroupOwner} to indicate
 * if the current device is a p2p group owner. A p2p client can thus communicate with
 * the p2p group owner through a socket connection. If the current device is the p2p group owner,
 * {@link android.net.wifi.p2p.WifiP2pInfo#groupOwnerAddress WifiP2pInfo#groupOwnerAddress} is anonymized unless the caller holds the
 * {@code android.Manifest.permission#LOCAL_MAC_ADDRESS} permission.
 *
 * <p> With peer discovery using {@link  #discoverPeers}, an application discovers the neighboring
 * peers, but has no good way to figure out which peer to establish a connection with. For example,
 * if a game application is interested in finding all the neighboring peers that are also running
 * the same game, it has no way to find out until after the connection is setup. Pre-association
 * service discovery is meant to address this issue of filtering the peers based on the running
 * services.
 *
 * <p>With pre-association service discovery, an application can advertise a service for a
 * application on a peer device prior to a connection setup between the devices.
 * Currently, DNS based service discovery (Bonjour) and Upnp are the higher layer protocols
 * supported. Get Bonjour resources at dns-sd.org and Upnp resources at upnp.org
 * As an example, a video application can discover a Upnp capable media renderer
 * prior to setting up a Wi-fi p2p connection with the device.
 *
 * <p> An application can advertise a Upnp or a Bonjour service with a call to
 * {@link #addLocalService}. After a local service is added,
 * the framework automatically responds to a peer application discovering the service prior
 * to establishing a p2p connection. A call to {@link #removeLocalService} removes a local
 * service and {@link #clearLocalServices} can be used to clear all local services.
 *
 * <p> An application that is looking for peer devices that support certain services
 * can do so with a call to  {@link #discoverServices}. Prior to initiating the discovery,
 * application can add service discovery request with a call to {@link #addServiceRequest},
 * remove a service discovery request with a call to {@link #removeServiceRequest} or clear
 * all requests with a call to {@link #clearServiceRequests}. When no service requests remain,
 * a previously running service discovery will stop.
 *
 * The application is notified of a result of service discovery request through listener callbacks
 * set through {@link #setDnsSdResponseListeners} for Bonjour or
 * {@link #setUpnpServiceResponseListener} for Upnp.
 *
 * <p class="note"><strong>Note:</strong>
 * Registering an application handler with {@link #initialize} requires the permissions
 * {@link android.Manifest.permission#ACCESS_WIFI_STATE} and
 * {@link android.Manifest.permission#CHANGE_WIFI_STATE} to perform any further peer-to-peer
 * operations.
 *
 * {@see WifiP2pConfig}
 * {@see WifiP2pInfo}
 * {@see WifiP2pGroup}
 * {@see WifiP2pDevice}
 * {@see WifiP2pDeviceList}
 * {@see android.net.wifi.WpsInfo}
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiP2pManager {

WifiP2pManager() { throw new RuntimeException("Stub!"); }

/**
 * Registers the application with the Wi-Fi framework. This function
 * must be the first to be called before any p2p operations are performed.
 *
 * @param srcContext is the context of the source
 * @param srcLooper is the Looper on which the callbacks are receivied
 * @param listener for callback at loss of framework communication. Can be null.
 * @return Channel instance that is necessary for performing any further p2p operations
 * @apiSince 14
 */

public android.net.wifi.p2p.WifiP2pManager.Channel initialize(android.content.Context srcContext, android.os.Looper srcLooper, android.net.wifi.p2p.WifiP2pManager.ChannelListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Initiate peer discovery. A discovery process involves scanning for available Wi-Fi peers
 * for the purpose of establishing a connection.
 *
 * <p> The function call immediately returns after sending a discovery request
 * to the framework. The application is notified of a success or failure to initiate
 * discovery through listener callbacks {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onSuccess ActionListener#onSuccess} or
 * {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 *
 * <p> The discovery remains active until a connection is initiated or
 * a p2p group is formed. Register for {@link #WIFI_P2P_PEERS_CHANGED_ACTION} intent to
 * determine when the framework notifies of a change as peers are discovered.
 *
 * <p> Upon receiving a {@link #WIFI_P2P_PEERS_CHANGED_ACTION} intent, an application
 * can request for the list of peers using {@link #requestPeers}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param c is the channel created at {@link #initialize}
 * @param listener for callbacks on success or failure. Can be null.
 * @apiSince 14
 */

public void discoverPeers(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.WifiP2pManager.ActionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Stop an ongoing peer discovery
 *
 * <p> The function call immediately returns after sending a stop request
 * to the framework. The application is notified of a success or failure to initiate
 * stop through listener callbacks {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onSuccess ActionListener#onSuccess} or
 * {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 *
 * @param c is the channel created at {@link #initialize}
 * @param listener for callbacks on success or failure. Can be null.
 * @apiSince 16
 */

public void stopPeerDiscovery(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.WifiP2pManager.ActionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Start a p2p connection to a device with the specified configuration.
 *
 * <p> The function call immediately returns after sending a connection request
 * to the framework. The application is notified of a success or failure to initiate
 * connect through listener callbacks {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onSuccess ActionListener#onSuccess} or
 * {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 *
 * <p> Register for {@link #WIFI_P2P_CONNECTION_CHANGED_ACTION} intent to
 * determine when the framework notifies of a change in connectivity.
 *
 * <p> If the current device is not part of a p2p group, a connect request initiates
 * a group negotiation with the peer.
 *
 * <p> If the current device is part of an existing p2p group or has created
 * a p2p group with {@link #createGroup}, an invitation to join the group is sent to
 * the peer device.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param c is the channel created at {@link #initialize}
 * @param config options as described in {@link android.net.wifi.p2p.WifiP2pConfig WifiP2pConfig} class
 * @param listener for callbacks on success or failure. Can be null.
 * @apiSince 14
 */

public void connect(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.WifiP2pConfig config, android.net.wifi.p2p.WifiP2pManager.ActionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Cancel any ongoing p2p group negotiation
 *
 * <p> The function call immediately returns after sending a connection cancellation request
 * to the framework. The application is notified of a success or failure to initiate
 * cancellation through listener callbacks {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onSuccess ActionListener#onSuccess} or
 * {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 *
 * @param c is the channel created at {@link #initialize}
 * @param listener for callbacks on success or failure. Can be null.
 * @apiSince 14
 */

public void cancelConnect(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.WifiP2pManager.ActionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Create a p2p group with the current device as the group owner. This essentially creates
 * an access point that can accept connections from legacy clients as well as other p2p
 * devices.
 *
 * <p class="note"><strong>Note:</strong>
 * This function would normally not be used unless the current device needs
 * to form a p2p connection with a legacy client
 *
 * <p> The function call immediately returns after sending a group creation request
 * to the framework. The application is notified of a success or failure to initiate
 * group creation through listener callbacks {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onSuccess ActionListener#onSuccess} or
 * {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 *
 * <p> Application can request for the group details with {@link #requestGroupInfo}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param c is the channel created at {@link #initialize}
 * @param listener for callbacks on success or failure. Can be null.
 * @apiSince 14
 */

public void createGroup(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.WifiP2pManager.ActionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Create a p2p group with the current device as the group owner. This essentially creates
 * an access point that can accept connections from legacy clients as well as other p2p
 * devices.
 *
 * <p> An app should use {@link android.net.wifi.p2p.WifiP2pConfig.Builder WifiP2pConfig.Builder} to build the configuration
 * for a group.
 *
 * <p class="note"><strong>Note:</strong>
 * This function would normally not be used unless the current device needs
 * to form a p2p group as a Group Owner and allow peers to join it as either
 * Group Clients or legacy Wi-Fi STAs.
 *
 * <p> The function call immediately returns after sending a group creation request
 * to the framework. The application is notified of a success or failure to initiate
 * group creation through listener callbacks {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onSuccess ActionListener#onSuccess} or
 * {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 *
 * <p> Application can request for the group details with {@link #requestGroupInfo}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param c is the channel created at {@link #initialize}.
 * This value must never be {@code null}.
 * @param config the configuration of a p2p group.
 * This value may be {@code null}.
 * @param listener for callbacks on success or failure. Can be null.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public void createGroup(@androidx.annotation.NonNull android.net.wifi.p2p.WifiP2pManager.Channel c, @androidx.annotation.Nullable android.net.wifi.p2p.WifiP2pConfig config, @androidx.annotation.Nullable android.net.wifi.p2p.WifiP2pManager.ActionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Remove the current p2p group.
 *
 * <p> The function call immediately returns after sending a group removal request
 * to the framework. The application is notified of a success or failure to initiate
 * group removal through listener callbacks {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onSuccess ActionListener#onSuccess} or
 * {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 *
 * @param c is the channel created at {@link #initialize}
 * @param listener for callbacks on success or failure. Can be null.
 * @apiSince 14
 */

public void removeGroup(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.WifiP2pManager.ActionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Register a local service for service discovery. If a local service is registered,
 * the framework automatically responds to a service discovery request from a peer.
 *
 * <p> The function call immediately returns after sending a request to add a local
 * service to the framework. The application is notified of a success or failure to
 * add service through listener callbacks {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onSuccess ActionListener#onSuccess} or
 * {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 *
 * <p>The service information is set through {@link android.net.wifi.p2p.nsd.WifiP2pServiceInfo WifiP2pServiceInfo}.<br>
 * or its subclass calls  {@link android.net.wifi.p2p.nsd.WifiP2pUpnpServiceInfo#newInstance WifiP2pUpnpServiceInfo#newInstance} or
 *  {@link android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceInfo#newInstance WifiP2pDnsSdServiceInfo#newInstance} for a Upnp or Bonjour service
 * respectively
 *
 * <p>The service information can be cleared with calls to
 *  {@link #removeLocalService} or {@link #clearLocalServices}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param c is the channel created at {@link #initialize}
 * @param servInfo is a local service information.
 * @param listener for callbacks on success or failure. Can be null.
 * @apiSince 16
 */

public void addLocalService(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.nsd.WifiP2pServiceInfo servInfo, android.net.wifi.p2p.WifiP2pManager.ActionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Remove a registered local service added with {@link #addLocalService}
 *
 * <p> The function call immediately returns after sending a request to remove a
 * local service to the framework. The application is notified of a success or failure to
 * add service through listener callbacks {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onSuccess ActionListener#onSuccess} or
 * {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 *
 * @param c is the channel created at {@link #initialize}
 * @param servInfo is the local service information.
 * @param listener for callbacks on success or failure. Can be null.
 * @apiSince 16
 */

public void removeLocalService(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.nsd.WifiP2pServiceInfo servInfo, android.net.wifi.p2p.WifiP2pManager.ActionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Clear all registered local services of service discovery.
 *
 * <p> The function call immediately returns after sending a request to clear all
 * local services to the framework. The application is notified of a success or failure to
 * add service through listener callbacks {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onSuccess ActionListener#onSuccess} or
 * {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 *
 * @param c is the channel created at {@link #initialize}
 * @param listener for callbacks on success or failure. Can be null.
 * @apiSince 16
 */

public void clearLocalServices(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.WifiP2pManager.ActionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked on receiving service discovery response.
 * Used only for vendor specific protocol right now. For Bonjour or Upnp, use
 * {@link #setDnsSdResponseListeners} or {@link #setUpnpServiceResponseListener}
 * respectively.
 *
 * <p> see {@link #discoverServices} for the detail.
 *
 * @param c is the channel created at {@link #initialize}
 * @param listener for callbacks on receiving service discovery response.
 * @apiSince 16
 */

public void setServiceResponseListener(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.WifiP2pManager.ServiceResponseListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked on receiving Bonjour service discovery
 * response.
 *
 * <p> see {@link #discoverServices} for the detail.
 *
 * @param c
 * @param servListener is for listening to a Bonjour service response
 * @param txtListener is for listening to a Bonjour TXT record response
 * @apiSince 16
 */

public void setDnsSdResponseListeners(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.WifiP2pManager.DnsSdServiceResponseListener servListener, android.net.wifi.p2p.WifiP2pManager.DnsSdTxtRecordListener txtListener) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked on receiving upnp service discovery
 * response.
 *
 * <p> see {@link #discoverServices} for the detail.
 *
 * @param c is the channel created at {@link #initialize}
 * @param listener for callbacks on receiving service discovery response.
 * @apiSince 16
 */

public void setUpnpServiceResponseListener(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.WifiP2pManager.UpnpServiceResponseListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Initiate service discovery. A discovery process involves scanning for
 * requested services for the purpose of establishing a connection to a peer
 * that supports an available service.
 *
 * <p> The function call immediately returns after sending a request to start service
 * discovery to the framework. The application is notified of a success or failure to initiate
 * discovery through listener callbacks {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onSuccess ActionListener#onSuccess} or
 * {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 *
 * <p> The services to be discovered are specified with calls to {@link #addServiceRequest}.
 *
 * <p>The application is notified of the response against the service discovery request
 * through listener callbacks registered by {@link #setServiceResponseListener} or
 * {@link #setDnsSdResponseListeners}, or {@link #setUpnpServiceResponseListener}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param c is the channel created at {@link #initialize}
 * @param listener for callbacks on success or failure. Can be null.
 * @apiSince 16
 */

public void discoverServices(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.WifiP2pManager.ActionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Add a service discovery request.
 *
 * <p> The function call immediately returns after sending a request to add service
 * discovery request to the framework. The application is notified of a success or failure to
 * add service through listener callbacks {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onSuccess ActionListener#onSuccess} or
 * {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 *
 * <p>After service discovery request is added, you can initiate service discovery by
 * {@link #discoverServices}.
 *
 * <p>The added service requests can be cleared with calls to
 * {@link #removeServiceRequest(android.net.wifi.p2p.WifiP2pManager.Channel,android.net.wifi.p2p.nsd.WifiP2pServiceRequest,android.net.wifi.p2p.WifiP2pManager.ActionListener)} or
 * {@link #clearServiceRequests(android.net.wifi.p2p.WifiP2pManager.Channel,android.net.wifi.p2p.WifiP2pManager.ActionListener)}.
 *
 * @param c is the channel created at {@link #initialize}
 * @param req is the service discovery request.
 * @param listener for callbacks on success or failure. Can be null.
 * @apiSince 16
 */

public void addServiceRequest(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.nsd.WifiP2pServiceRequest req, android.net.wifi.p2p.WifiP2pManager.ActionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Remove a specified service discovery request added with {@link #addServiceRequest}
 *
 * <p> The function call immediately returns after sending a request to remove service
 * discovery request to the framework. The application is notified of a success or failure to
 * add service through listener callbacks {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onSuccess ActionListener#onSuccess} or
 * {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 *
 * @param c is the channel created at {@link #initialize}
 * @param req is the service discovery request.
 * @param listener for callbacks on success or failure. Can be null.
 * @apiSince 16
 */

public void removeServiceRequest(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.nsd.WifiP2pServiceRequest req, android.net.wifi.p2p.WifiP2pManager.ActionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Clear all registered service discovery requests.
 *
 * <p> The function call immediately returns after sending a request to clear all
 * service discovery requests to the framework. The application is notified of a success
 * or failure to add service through listener callbacks {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onSuccess ActionListener#onSuccess} or
 * {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 *
 * @param c is the channel created at {@link #initialize}
 * @param listener for callbacks on success or failure. Can be null.
 * @apiSince 16
 */

public void clearServiceRequests(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.WifiP2pManager.ActionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Request the current list of peers.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param c is the channel created at {@link #initialize}
 * @param listener for callback when peer list is available. Can be null.
 * @apiSince 14
 */

public void requestPeers(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.WifiP2pManager.PeerListListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Request device connection info.
 *
 * @param c is the channel created at {@link #initialize}
 * @param listener for callback when connection info is available. Can be null.
 * @apiSince 14
 */

public void requestConnectionInfo(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Request p2p group info.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param c is the channel created at {@link #initialize}
 * @param listener for callback when group info is available. Can be null.
 * @apiSince 14
 */

public void requestGroupInfo(android.net.wifi.p2p.WifiP2pManager.Channel c, android.net.wifi.p2p.WifiP2pManager.GroupInfoListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Request p2p enabled state.
 *
 * <p> This state indicates whether Wi-Fi p2p is enabled or disabled.
 * The valid value is one of {@link #WIFI_P2P_STATE_DISABLED} or
 * {@link #WIFI_P2P_STATE_ENABLED}. The state is returned using the
 * {@link android.net.wifi.p2p.WifiP2pManager.P2pStateListener P2pStateListener} listener.
 *
 * <p> This state is also included in the {@link #WIFI_P2P_STATE_CHANGED_ACTION}
 * broadcast event with extra {@link #EXTRA_WIFI_STATE}.
 *
 * @param c is the channel created at {@link #initialize}.
 * This value must never be {@code null}.
 * @param listener for callback when p2p state is available..
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void requestP2pState(@androidx.annotation.NonNull android.net.wifi.p2p.WifiP2pManager.Channel c, @androidx.annotation.NonNull android.net.wifi.p2p.WifiP2pManager.P2pStateListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Request p2p discovery state.
 *
 * <p> This state indicates whether p2p discovery has started or stopped.
 * The valid value is one of {@link #WIFI_P2P_DISCOVERY_STARTED} or
 * {@link #WIFI_P2P_DISCOVERY_STOPPED}. The state is returned using the
 * {@link android.net.wifi.p2p.WifiP2pManager.DiscoveryStateListener DiscoveryStateListener} listener.
 *
 * <p> This state is also included in the {@link #WIFI_P2P_DISCOVERY_CHANGED_ACTION}
 * broadcast event with extra {@link #EXTRA_DISCOVERY_STATE}.
 *
 * @param c is the channel created at {@link #initialize}.
 * This value must never be {@code null}.
 * @param listener for callback when discovery state is available..
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void requestDiscoveryState(@androidx.annotation.NonNull android.net.wifi.p2p.WifiP2pManager.Channel c, @androidx.annotation.NonNull android.net.wifi.p2p.WifiP2pManager.DiscoveryStateListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Request network info.
 *
 * <p> This method provides the network info in the form of a {@link android.net.NetworkInfo}.
 * {@link android.net.NetworkInfo#isAvailable()} indicates the p2p availability and
 * {@link android.net.NetworkInfo#getDetailedState()} reports the current fine-grained state
 * of the network. This {@link android.net.NetworkInfo} is returned using the
 * {@link android.net.wifi.p2p.WifiP2pManager.NetworkInfoListener NetworkInfoListener} listener.
 *
 * <p> This information is also included in the {@link #WIFI_P2P_CONNECTION_CHANGED_ACTION}
 * broadcast event with extra {@link #EXTRA_NETWORK_INFO}.
 *
 * @param c is the channel created at {@link #initialize}.
 * This value must never be {@code null}.
 * @param listener for callback when network info is available..
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void requestNetworkInfo(@androidx.annotation.NonNull android.net.wifi.p2p.WifiP2pManager.Channel c, @androidx.annotation.NonNull android.net.wifi.p2p.WifiP2pManager.NetworkInfoListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Request Device Info
 *
 * <p> This method provides the device info
 * in the form of a {@link android.net.wifi.p2p.WifiP2pDevice}.
 * Valid {@link android.net.wifi.p2p.WifiP2pDevice} is returned when p2p is enabled.
 * To get information notifications on P2P getting enabled refers
 * {@link #WIFI_P2P_STATE_ENABLED}.
 *
 * <p> This {@link android.net.wifi.p2p.WifiP2pDevice} is returned using the
 * {@link android.net.wifi.p2p.WifiP2pManager.DeviceInfoListener DeviceInfoListener} listener.
 *
 * <p> {@link android.net.wifi.p2p.WifiP2pDevice#deviceAddress} is only available if the caller
 * holds the {@code android.Manifest.permission#LOCAL_MAC_ADDRESS} permission, and holds the
 * anonymized MAC address (02:00:00:00:00:00) otherwise.
 *
 * <p> This information is also included in the {@link #WIFI_P2P_THIS_DEVICE_CHANGED_ACTION}
 * broadcast event with extra {@link #EXTRA_WIFI_P2P_DEVICE}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param c is the channel created at {@link #initialize(android.content.Context,android.os.Looper,android.net.wifi.p2p.WifiP2pManager.ChannelListener)}.
 * This value must never be {@code null}.
 * @param listener for callback when network info is available.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void requestDeviceInfo(@androidx.annotation.NonNull android.net.wifi.p2p.WifiP2pManager.Channel c, @androidx.annotation.NonNull android.net.wifi.p2p.WifiP2pManager.DeviceInfoListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Passed with {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 * Indicates that the operation failed because the framework is busy and
 * unable to service the request
 * @apiSince 14
 */

public static final int BUSY = 2; // 0x2

/**
 * Passed with {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 * Indicates that the operation failed due to an internal error.
 * @apiSince 14
 */

public static final int ERROR = 0; // 0x0

/**
 * The lookup key for an int that indicates whether p2p discovery has started or stopped.
 * Retrieve it with {@link android.content.Intent#getIntExtra(String,int)}.
 *
 * @see #WIFI_P2P_DISCOVERY_STARTED
 * @see #WIFI_P2P_DISCOVERY_STOPPED
 * @apiSince 16
 */

public static final java.lang.String EXTRA_DISCOVERY_STATE = "discoveryState";

/**
 * The lookup key for a {@link android.net.NetworkInfo} object associated with the
 * p2p network. Retrieve with
 * {@link android.content.Intent#getParcelableExtra(String)}.
 * @apiSince 14
 */

public static final java.lang.String EXTRA_NETWORK_INFO = "networkInfo";

/**
 * The lookup key for a {@link android.net.wifi.p2p.WifiP2pDeviceList} object representing
 * the new peer list when {@link #WIFI_P2P_PEERS_CHANGED_ACTION} broadcast is sent.
 *
 * <p>Retrieve with {@link android.content.Intent#getParcelableExtra(String)}.
 * @apiSince 18
 */

public static final java.lang.String EXTRA_P2P_DEVICE_LIST = "wifiP2pDeviceList";

/**
 * The lookup key for a {@link android.net.wifi.p2p.WifiP2pDevice} object
 * Retrieve with {@link android.content.Intent#getParcelableExtra(String)}.
 * @apiSince 14
 */

public static final java.lang.String EXTRA_WIFI_P2P_DEVICE = "wifiP2pDevice";

/**
 * The lookup key for a {@link android.net.wifi.p2p.WifiP2pGroup} object
 * associated with the p2p network. Retrieve with
 * {@link android.content.Intent#getParcelableExtra(String)}.
 * @apiSince 18
 */

public static final java.lang.String EXTRA_WIFI_P2P_GROUP = "p2pGroupInfo";

/**
 * The lookup key for a {@link android.net.wifi.p2p.WifiP2pInfo} object
 * Retrieve with {@link android.content.Intent#getParcelableExtra(String)}.
 * @apiSince 14
 */

public static final java.lang.String EXTRA_WIFI_P2P_INFO = "wifiP2pInfo";

/**
 * The lookup key for an int that indicates whether Wi-Fi p2p is enabled or disabled.
 * Retrieve it with {@link android.content.Intent#getIntExtra(String,int)}.
 *
 * @see #WIFI_P2P_STATE_DISABLED
 * @see #WIFI_P2P_STATE_ENABLED
 * @apiSince 14
 */

public static final java.lang.String EXTRA_WIFI_STATE = "wifi_p2p_state";

/**
 * Passed with {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 * Indicates that the {@link #discoverServices} failed because no service
 * requests are added. Use {@link #addServiceRequest} to add a service
 * request.
 * @apiSince 16
 */

public static final int NO_SERVICE_REQUESTS = 3; // 0x3

/**
 * Passed with {@link android.net.wifi.p2p.WifiP2pManager.ActionListener#onFailure ActionListener#onFailure}.
 * Indicates that the operation failed because p2p is unsupported on the device.
 * @apiSince 14
 */

public static final int P2P_UNSUPPORTED = 1; // 0x1

/**
 * Broadcast intent action indicating that the state of Wi-Fi p2p connectivity
 * has changed. One extra {@link #EXTRA_WIFI_P2P_INFO} provides the p2p connection info in
 * the form of a {@link android.net.wifi.p2p.WifiP2pInfo WifiP2pInfo} object. Another extra {@link #EXTRA_NETWORK_INFO} provides
 * the network info in the form of a {@link android.net.NetworkInfo}. A third extra provides
 * the details of the group and may contain a {@code null}.
 *
 * All of these permissions are required to receive this broadcast:
 * {@link android.Manifest.permission#ACCESS_FINE_LOCATION} and
 * {@link android.Manifest.permission#ACCESS_WIFI_STATE}
 *
 * @see #EXTRA_WIFI_P2P_INFO
 * @see #EXTRA_NETWORK_INFO
 * @see #EXTRA_WIFI_P2P_GROUP
 * @apiSince 14
 */

public static final java.lang.String WIFI_P2P_CONNECTION_CHANGED_ACTION = "android.net.wifi.p2p.CONNECTION_STATE_CHANGE";

/**
 * Broadcast intent action indicating that peer discovery has either started or stopped.
 * One extra {@link #EXTRA_DISCOVERY_STATE} indicates whether discovery has started
 * or stopped.
 *
 * <p>Note that discovery will be stopped during a connection setup. If the application tries
 * to re-initiate discovery during this time, it can fail.
 * @apiSince 16
 */

public static final java.lang.String WIFI_P2P_DISCOVERY_CHANGED_ACTION = "android.net.wifi.p2p.DISCOVERY_STATE_CHANGE";

/**
 * p2p discovery has started
 *
 * @see #WIFI_P2P_DISCOVERY_CHANGED_ACTION
 * @apiSince 16
 */

public static final int WIFI_P2P_DISCOVERY_STARTED = 2; // 0x2

/**
 * p2p discovery has stopped
 *
 * @see #WIFI_P2P_DISCOVERY_CHANGED_ACTION
 * @apiSince 16
 */

public static final int WIFI_P2P_DISCOVERY_STOPPED = 1; // 0x1

/**
 * Broadcast intent action indicating that the available peer list has changed. This
 * can be sent as a result of peers being found, lost or updated.
 *
 * All of these permissions are required to receive this broadcast:
 * {@link android.Manifest.permission#ACCESS_FINE_LOCATION} and
 * {@link android.Manifest.permission#ACCESS_WIFI_STATE}
 *
 * <p> An extra {@link #EXTRA_P2P_DEVICE_LIST} provides the full list of
 * current peers. The full list of peers can also be obtained any time with
 * {@link #requestPeers}.
 *
 * @see #EXTRA_P2P_DEVICE_LIST
 * @apiSince 14
 */

public static final java.lang.String WIFI_P2P_PEERS_CHANGED_ACTION = "android.net.wifi.p2p.PEERS_CHANGED";

/**
 * Broadcast intent action to indicate whether Wi-Fi p2p is enabled or disabled. An
 * extra {@link #EXTRA_WIFI_STATE} provides the state information as int.
 *
 * @see #EXTRA_WIFI_STATE
 * @apiSince 14
 */

public static final java.lang.String WIFI_P2P_STATE_CHANGED_ACTION = "android.net.wifi.p2p.STATE_CHANGED";

/**
 * Wi-Fi p2p is disabled.
 *
 * @see #WIFI_P2P_STATE_CHANGED_ACTION
 * @apiSince 14
 */

public static final int WIFI_P2P_STATE_DISABLED = 1; // 0x1

/**
 * Wi-Fi p2p is enabled.
 *
 * @see #WIFI_P2P_STATE_CHANGED_ACTION
 * @apiSince 14
 */

public static final int WIFI_P2P_STATE_ENABLED = 2; // 0x2

/**
 * Broadcast intent action indicating that this device details have changed.
 *
 * <p> An extra {@link #EXTRA_WIFI_P2P_DEVICE} provides this device details.
 * The valid device details can also be obtained with
 * {@link #requestDeviceInfo(android.net.wifi.p2p.WifiP2pManager.Channel,android.net.wifi.p2p.WifiP2pManager.DeviceInfoListener)} when p2p is enabled.
 * To get information notifications on P2P getting enabled refers
 * {@link #WIFI_P2P_STATE_ENABLED}.
 *
 * <p> The {@link #EXTRA_WIFI_P2P_DEVICE} extra contains an anonymized version of the device's
 * MAC address. Callers holding the {@code android.Manifest.permission#LOCAL_MAC_ADDRESS}
 * permission can use {@link #requestDeviceInfo} to obtain the actual MAC address of this
 * device.
 *
 * All of these permissions are required to receive this broadcast:
 * {@link android.Manifest.permission#ACCESS_FINE_LOCATION} and
 * {@link android.Manifest.permission#ACCESS_WIFI_STATE}
 *
 * @see #EXTRA_WIFI_P2P_DEVICE
 * @apiSince 14
 */

public static final java.lang.String WIFI_P2P_THIS_DEVICE_CHANGED_ACTION = "android.net.wifi.p2p.THIS_DEVICE_CHANGED";
/**
 * Interface for callback invocation on an application action
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ActionListener {

/**
 * The operation succeeded
 * @apiSince 14
 */

public void onSuccess();

/**
 * The operation failed
 * @param reason The reason for failure could be one of {@link #P2P_UNSUPPORTED},
 * {@link #ERROR} or {@link #BUSY}
 * @apiSince 14
 */

public void onFailure(int reason);
}

/**
 * A channel that connects the application to the Wifi p2p framework.
 * Most p2p operations require a Channel as an argument. An instance of Channel is obtained
 * by doing a call on {@link #initialize}
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Channel implements java.lang.AutoCloseable {

Channel() { throw new RuntimeException("Stub!"); }

/**
 * Close the current P2P connection and indicate to the P2P service that connections
 * created by the app can be removed.
 * @apiSince 27
 */

public void close() { throw new RuntimeException("Stub!"); }

/** @hide */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
}

/**
 * Interface for callback invocation when framework channel is lost
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ChannelListener {

/**
 * The channel to the framework has been disconnected.
 * Application could try re-initializing using {@link #initialize}
 * @apiSince 14
 */

public void onChannelDisconnected();
}

/**
 * Interface for callback invocation when connection info is available
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ConnectionInfoListener {

/**
 * The requested connection info is available
 * @param info Wi-Fi p2p connection info
 * @apiSince 14
 */

public void onConnectionInfoAvailable(android.net.wifi.p2p.WifiP2pInfo info);
}

/** Interface for callback invocation when {@link android.net.wifi.p2p.WifiP2pDevice}
 *  is available in response to {@link #requestDeviceInfo(android.net.wifi.p2p.WifiP2pManager.Channel,android.net.wifi.p2p.WifiP2pManager.DeviceInfoListener)}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface DeviceInfoListener {

/**
 * The requested {@link android.net.wifi.p2p.WifiP2pDevice} is available.
 * @param wifiP2pDevice Wi-Fi p2p {@link android.net.wifi.p2p.WifiP2pDevice}
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public void onDeviceInfoAvailable(@androidx.annotation.Nullable android.net.wifi.p2p.WifiP2pDevice wifiP2pDevice);
}

/** Interface for callback invocation when p2p state is available
 *  in response to {@link #requestDiscoveryState}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface DiscoveryStateListener {

/**
 * The requested p2p discovery state is available.
 * @param state Wi-Fi p2p discovery state
 *
 * Value is {@link android.net.wifi.p2p.WifiP2pManager#WIFI_P2P_DISCOVERY_STOPPED}, or {@link android.net.wifi.p2p.WifiP2pManager#WIFI_P2P_DISCOVERY_STARTED}
 * @see #WIFI_P2P_DISCOVERY_STARTED
 *        @see #WIFI_P2P_DISCOVERY_STOPPED
 * @apiSince 29
 */

public void onDiscoveryStateAvailable(int state);
}

/**
 * Interface for callback invocation when Bonjour service discovery response
 * is received
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface DnsSdServiceResponseListener {

/**
 * The requested Bonjour service response is available.
 *
 * <p>This function is invoked when the device with the specified Bonjour
 * registration type returned the instance name.
 * @param instanceName instance name.<br>
 *  e.g) "MyPrinter".
 * @param registrationType <br>
 * e.g) "_ipp._tcp.local."
 * @param srcDevice source device.
 * @apiSince 16
 */

public void onDnsSdServiceAvailable(java.lang.String instanceName, java.lang.String registrationType, android.net.wifi.p2p.WifiP2pDevice srcDevice);
}

/**
 * Interface for callback invocation when Bonjour TXT record is available
 * for a service
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface DnsSdTxtRecordListener {

/**
 * The requested Bonjour service response is available.
 *
 * <p>This function is invoked when the device with the specified full
 * service domain service returned TXT record.
 *
 * @param fullDomainName full domain name. <br>
 * e.g) "MyPrinter._ipp._tcp.local.".
 * @param txtRecordMap TXT record data as a map of key/value pairs
 * @param srcDevice source device.
 * @apiSince 16
 */

public void onDnsSdTxtRecordAvailable(java.lang.String fullDomainName, java.util.Map<java.lang.String,java.lang.String> txtRecordMap, android.net.wifi.p2p.WifiP2pDevice srcDevice);
}

/**
 * Interface for callback invocation when group info is available
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface GroupInfoListener {

/**
 * The requested p2p group info is available
 * @param group Wi-Fi p2p group info
 * @apiSince 14
 */

public void onGroupInfoAvailable(android.net.wifi.p2p.WifiP2pGroup group);
}

/** Interface for callback invocation when {@link android.net.NetworkInfo} is available
 *  in response to {@link #requestNetworkInfo}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface NetworkInfoListener {

/**
 * The requested {@link android.net.NetworkInfo} is available
 * @param networkInfo Wi-Fi p2p {@link android.net.NetworkInfo}
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void onNetworkInfoAvailable(@androidx.annotation.NonNull android.net.NetworkInfo networkInfo);
}

/** Interface for callback invocation when p2p state is available
 *  in response to {@link #requestP2pState}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface P2pStateListener {

/**
 * The requested p2p state is available.
 * @param state Wi-Fi p2p state
 *
 * Value is {@link android.net.wifi.p2p.WifiP2pManager#WIFI_P2P_STATE_DISABLED}, or {@link android.net.wifi.p2p.WifiP2pManager#WIFI_P2P_STATE_ENABLED}
 * @see #WIFI_P2P_STATE_DISABLED
 *        @see #WIFI_P2P_STATE_ENABLED
 * @apiSince 29
 */

public void onP2pStateAvailable(int state);
}

/**
 * Interface for callback invocation when peer list is available
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface PeerListListener {

/**
 * The requested peer list is available
 * @param peers List of available peers
 * @apiSince 14
 */

public void onPeersAvailable(android.net.wifi.p2p.WifiP2pDeviceList peers);
}

/**
 * Interface for callback invocation when service discovery response other than
 * Upnp or Bonjour is received
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ServiceResponseListener {

/**
 * The requested service response is available.
 *
 * @param protocolType protocol type. currently only
 * {@link android.net.wifi.p2p.nsd.WifiP2pServiceInfo#SERVICE_TYPE_VENDOR_SPECIFIC WifiP2pServiceInfo#SERVICE_TYPE_VENDOR_SPECIFIC}.
 * @param responseData service discovery response data based on the requested
 *  service protocol type. The format depends on the service type.
 * @param srcDevice source device.
 * @apiSince 16
 */

public void onServiceAvailable(int protocolType, byte[] responseData, android.net.wifi.p2p.WifiP2pDevice srcDevice);
}

/**
 * Interface for callback invocation when upnp service discovery response
 * is received
 *     * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface UpnpServiceResponseListener {

/**
 * The requested upnp service response is available.
 *
 * <p>This function is invoked when the specified device or service is found.
 *
 * @param uniqueServiceNames The list of unique service names.<br>
 * e.g) uuid:6859dede-8574-59ab-9332-123456789012::urn:schemas-upnp-org:device:
 * MediaServer:1
 * @param srcDevice source device.
 * @apiSince 16
 */

public void onUpnpServiceAvailable(java.util.List<java.lang.String> uniqueServiceNames, android.net.wifi.p2p.WifiP2pDevice srcDevice);
}

}

