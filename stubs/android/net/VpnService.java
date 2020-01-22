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


package android.net;

import android.content.Context;
import android.app.Activity;
import android.content.Intent;
import java.net.Socket;
import java.net.DatagramSocket;
import android.app.admin.DevicePolicyManager;
import java.util.Set;
import android.content.ComponentName;
import android.app.Service;
import android.app.PendingIntent;
import java.net.InetAddress;
import android.content.pm.PackageManager;
import android.os.ParcelFileDescriptor;

/**
 * VpnService is a base class for applications to extend and build their
 * own VPN solutions. In general, it creates a virtual network interface,
 * configures addresses and routing rules, and returns a file descriptor
 * to the application. Each read from the descriptor retrieves an outgoing
 * packet which was routed to the interface. Each write to the descriptor
 * injects an incoming packet just like it was received from the interface.
 * The interface is running on Internet Protocol (IP), so packets are
 * always started with IP headers. The application then completes a VPN
 * connection by processing and exchanging packets with the remote server
 * over a tunnel.
 *
 * <p>Letting applications intercept packets raises huge security concerns.
 * A VPN application can easily break the network. Besides, two of them may
 * conflict with each other. The system takes several actions to address
 * these issues. Here are some key points:
 * <ul>
 *   <li>User action is required the first time an application creates a VPN
 *       connection.</li>
 *   <li>There can be only one VPN connection running at the same time. The
 *       existing interface is deactivated when a new one is created.</li>
 *   <li>A system-managed notification is shown during the lifetime of a
 *       VPN connection.</li>
 *   <li>A system-managed dialog gives the information of the current VPN
 *       connection. It also provides a button to disconnect.</li>
 *   <li>The network is restored automatically when the file descriptor is
 *       closed. It also covers the cases when a VPN application is crashed
 *       or killed by the system.</li>
 * </ul>
 *
 * <p>There are two primary methods in this class: {@link #prepare} and
 * {@link android.net.VpnService.Builder#establish Builder#establish}. The former deals with user action and stops
 * the VPN connection created by another application. The latter creates
 * a VPN interface using the parameters supplied to the {@link android.net.VpnService.Builder Builder}.
 * An application must call {@link #prepare} to grant the right to use
 * other methods in this class, and the right can be revoked at any time.
 * Here are the general steps to create a VPN connection:
 * <ol>
 *   <li>When the user presses the button to connect, call {@link #prepare}
 *       and launch the returned intent, if non-null.</li>
 *   <li>When the application becomes prepared, start the service.</li>
 *   <li>Create a tunnel to the remote server and negotiate the network
 *       parameters for the VPN connection.</li>
 *   <li>Supply those parameters to a {@link android.net.VpnService.Builder Builder} and create a VPN
 *       interface by calling {@link android.net.VpnService.Builder#establish Builder#establish}.</li>
 *   <li>Process and exchange packets between the tunnel and the returned
 *       file descriptor.</li>
 *   <li>When {@link #onRevoke} is invoked, close the file descriptor and
 *       shut down the tunnel gracefully.</li>
 * </ol>
 *
 * <p>Services extending this class need to be declared with an appropriate
 * permission and intent filter. Their access must be secured by
 * {@link android.Manifest.permission#BIND_VPN_SERVICE} permission, and
 * their intent filter must match {@link #SERVICE_INTERFACE} action. Here
 * is an example of declaring a VPN service in {@code AndroidManifest.xml}:
 * <pre>
 * &lt;service android:name=".ExampleVpnService"
 *         android:permission="android.permission.BIND_VPN_SERVICE"&gt;
 *     &lt;intent-filter&gt;
 *         &lt;action android:name="android.net.VpnService"/&gt;
 *     &lt;/intent-filter&gt;
 * &lt;/service&gt;</pre>
 *
 * <p> The Android system starts a VPN in the background by calling
 * {@link android.content.Context#startService startService()}. In Android 8.0
 * (API level 26) and higher, the system places VPN apps on the temporary
 * whitelist for a short period so the app can start in the background. The VPN
 * app must promote itself to the foreground after it's launched or the system
 * will shut down the app.
 *
 * <h3>Developer's guide</h3>
 *
 * <p>To learn more about developing VPN apps, read the
 * <a href="{@docRoot}guide/topics/connectivity/vpn">VPN developer's guide</a>.
 *
 * @see android.net.VpnService.Builder
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class VpnService extends android.app.Service {

public VpnService() { throw new RuntimeException("Stub!"); }

/**
 * Prepare to establish a VPN connection. This method returns {@code null}
 * if the VPN application is already prepared or if the user has previously
 * consented to the VPN application. Otherwise, it returns an
 * {@link android.content.Intent Intent} to a system activity. The application should launch the
 * activity using {@link android.app.Activity#startActivityForResult Activity#startActivityForResult} to get itself
 * prepared. The activity may pop up a dialog to require user action, and
 * the result will come back via its {@link android.app.Activity#onActivityResult Activity#onActivityResult}.
 * If the result is {@link android.app.Activity#RESULT_OK Activity#RESULT_OK}, the application becomes
 * prepared and is granted to use other methods in this class.
 *
 * <p>Only one application can be granted at the same time. The right
 * is revoked when another application is granted. The application
 * losing the right will be notified via its {@link #onRevoke}. Unless
 * it becomes prepared again, subsequent calls to other methods in this
 * class will fail.
 *
 * <p>The user may disable the VPN at any time while it is activated, in
 * which case this method will return an intent the next time it is
 * executed to obtain the user's consent again.
 *
 * @see #onRevoke
 * @apiSince 14
 */

public static android.content.Intent prepare(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Protect a socket from VPN connections. After protecting, data sent
 * through this socket will go directly to the underlying network,
 * so its traffic will not be forwarded through the VPN.
 * This method is useful if some connections need to be kept
 * outside of VPN. For example, a VPN tunnel should protect itself if its
 * destination is covered by VPN routes. Otherwise its outgoing packets
 * will be sent back to the VPN interface and cause an infinite loop. This
 * method will fail if the application is not prepared or is revoked.
 *
 * <p class="note">The socket is NOT closed by this method.
 *
 * @return {@code true} on success.
 * @apiSince 14
 */

public boolean protect(int socket) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to protect a {@link java.net.Socket Socket} from VPN connections.
 *
 * @return {@code true} on success.
 * @see #protect(int)
 * @apiSince 14
 */

public boolean protect(java.net.Socket socket) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to protect a {@link java.net.DatagramSocket DatagramSocket} from VPN
 * connections.
 *
 * @return {@code true} on success.
 * @see #protect(int)
 * @apiSince 14
 */

public boolean protect(java.net.DatagramSocket socket) { throw new RuntimeException("Stub!"); }

/**
 * Sets the underlying networks used by the VPN for its upstream connections.
 *
 * <p>Used by the system to know the actual networks that carry traffic for apps affected by
 * this VPN in order to present this information to the user (e.g., via status bar icons).
 *
 * <p>This method only needs to be called if the VPN has explicitly bound its underlying
 * communications channels &mdash; such as the socket(s) passed to {@link #protect(int)} &mdash;
 * to a {@code Network} using APIs such as {@link android.net.Network#bindSocket(java.net.Socket) Network#bindSocket(Socket)} or
 * {@link android.net.Network#bindSocket(java.net.DatagramSocket) Network#bindSocket(DatagramSocket)}. The VPN should call this method every time
 * the set of {@code Network}s it is using changes.
 *
 * <p>{@code networks} is one of the following:
 * <ul>
 * <li><strong>a non-empty array</strong>: an array of one or more {@link android.net.Network Network}s, in
 * decreasing preference order. For example, if this VPN uses both wifi and mobile (cellular)
 * networks to carry app traffic, but prefers or uses wifi more than mobile, wifi should appear
 * first in the array.</li>
 * <li><strong>an empty array</strong>: a zero-element array, meaning that the VPN has no
 * underlying network connection, and thus, app traffic will not be sent or received.</li>
 * <li><strong>null</strong>: (default) signifies that the VPN uses whatever is the system's
 * default network. I.e., it doesn't use the {@code bindSocket} or {@code bindDatagramSocket}
 * APIs mentioned above to send traffic over specific channels.</li>
 * </ul>
 *
 * <p>This call will succeed only if the VPN is currently established. For setting this value
 * when the VPN has not yet been established, see {@link android.net.VpnService.Builder#setUnderlyingNetworks Builder#setUnderlyingNetworks}.
 *
 * @param networks An array of networks the VPN uses to tunnel traffic to/from its servers.
 *
 * @return {@code true} on success.
 * @apiSince 22
 */

public boolean setUnderlyingNetworks(android.net.Network[] networks) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the service is running in always-on VPN mode. In this mode the system ensures
 * that the service is always running by restarting it when necessary, e.g. after reboot.
 *
 * @see android.app.admin.DevicePolicyManager#setAlwaysOnVpnPackage(ComponentName, String, boolean, Set)
 * @apiSince 29
 */

public final boolean isAlwaysOn() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the service is running in always-on VPN lockdown mode. In this mode the
 * system ensures that the service is always running and that the apps aren't allowed to bypass
 * the VPN.
 *
 * @see android.app.admin.DevicePolicyManager#setAlwaysOnVpnPackage(ComponentName, String, boolean, Set)
 * @apiSince 29
 */

public final boolean isLockdownEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Return the communication interface to the service. This method returns
 * {@code null} on {@link android.content.Intent Intent}s other than {@link #SERVICE_INTERFACE}
 * action. Applications overriding this method must identify the intent
 * and return the corresponding interface accordingly.
 *
 * @see android.app.Service#onBind
 * @apiSince 14
 */

public android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the application is revoked. At this moment, the VPN
 * interface is already deactivated by the system. The application should
 * close the file descriptor and shut down gracefully. The default
 * implementation of this method is calling {@link android.app.Service#stopSelf() Service#stopSelf()}.
 *
 * <p class="note">Calls to this method may not happen on the main thread
 * of the process.
 *
 * @see #prepare
 * @apiSince 14
 */

public void onRevoke() { throw new RuntimeException("Stub!"); }

/**
 * The action must be matched by the intent filter of this service. It also
 * needs to require {@link android.Manifest.permission#BIND_VPN_SERVICE}
 * permission so that other applications cannot abuse it.
 * @apiSince 14
 */

public static final java.lang.String SERVICE_INTERFACE = "android.net.VpnService";

/**
 * Key for boolean meta-data field indicating whether this VpnService supports always-on mode.
 *
 * <p>For a VPN app targeting {@link android.os.Build.VERSION_CODES#N API 24} or above, Android
 * provides users with the ability to set it as always-on, so that VPN connection is
 * persisted after device reboot and app upgrade. Always-on VPN can also be enabled by device
 * owner and profile owner apps through
 * {@link android.app.admin.DevicePolicyManager#setAlwaysOnVpnPackage DevicePolicyManager#setAlwaysOnVpnPackage}.
 *
 * <p>VPN apps not supporting this feature should opt out by adding this meta-data field to the
 * {@code VpnService} component of {@code AndroidManifest.xml}. In case there is more than one
 * {@code VpnService} component defined in {@code AndroidManifest.xml}, opting out any one of
 * them will opt out the entire app. For example,
 * <pre> {@code
 * <service android:name=".ExampleVpnService"
 *         android:permission="android.permission.BIND_VPN_SERVICE">
 *     <intent-filter>
 *         <action android:name="android.net.VpnService"/>
 *     </intent-filter>
 *     <meta-data android:name="android.net.VpnService.SUPPORTS_ALWAYS_ON"
 *             android:value=false/>
 * </service>
 * } </pre>
 *
 * <p>This meta-data field defaults to {@code true} if absent. It will only have effect on
 * {@link android.os.Build.VERSION_CODES#O_MR1} or higher.
 * @apiSince 27
 */

public static final java.lang.String SERVICE_META_DATA_SUPPORTS_ALWAYS_ON = "android.net.VpnService.SUPPORTS_ALWAYS_ON";
/**
 * Helper class to create a VPN interface. This class should be always
 * used within the scope of the outer {@link android.net.VpnService VpnService}.
 *
 * @see android.net.VpnService
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Set the name of this session. It will be displayed in
 * system-managed dialogs and notifications. This is recommended
 * not required.
 
 * @param session This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder setSession(@androidx.annotation.NonNull java.lang.String session) { throw new RuntimeException("Stub!"); }

/**
 * Set the {@link android.app.PendingIntent PendingIntent} to an activity for users to
 * configure the VPN connection. If it is not set, the button
 * to configure will not be shown in system-managed dialogs.
 
 * @param intent This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder setConfigureIntent(@androidx.annotation.NonNull android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Set the maximum transmission unit (MTU) of the VPN interface. If
 * it is not set, the default value in the operating system will be
 * used.
 *
 * @throws java.lang.IllegalArgumentException if the value is not positive.
 
 * @return This value will never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder setMtu(int mtu) { throw new RuntimeException("Stub!"); }

/**
 * Sets an HTTP proxy for the VPN network. This proxy is only a recommendation
 * and it is possible that some apps will ignore it.
 
 * @param proxyInfo This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder setHttpProxy(@androidx.annotation.NonNull android.net.ProxyInfo proxyInfo) { throw new RuntimeException("Stub!"); }

/**
 * Add a network address to the VPN interface. Both IPv4 and IPv6
 * addresses are supported. At least one address must be set before
 * calling {@link #establish}.
 *
 * Adding an address implicitly allows traffic from that address family
 * (i.e., IPv4 or IPv6) to be routed over the VPN. @see #allowFamily
 *
 * @throws java.lang.IllegalArgumentException if the address is invalid.
 
 * @param address This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder addAddress(@androidx.annotation.NonNull java.net.InetAddress address, int prefixLength) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to add a network address to the VPN interface
 * using a numeric address string. See {@link java.net.InetAddress InetAddress} for the
 * definitions of numeric address formats.
 *
 * Adding an address implicitly allows traffic from that address family
 * (i.e., IPv4 or IPv6) to be routed over the VPN. @see #allowFamily
 *
 * @throws java.lang.IllegalArgumentException if the address is invalid.
 * @see #addAddress(InetAddress, int)
 
 * @param address This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder addAddress(@androidx.annotation.NonNull java.lang.String address, int prefixLength) { throw new RuntimeException("Stub!"); }

/**
 * Add a network route to the VPN interface. Both IPv4 and IPv6
 * routes are supported.
 *
 * Adding a route implicitly allows traffic from that address family
 * (i.e., IPv4 or IPv6) to be routed over the VPN. @see #allowFamily
 *
 * @throws java.lang.IllegalArgumentException if the route is invalid.
 
 * @param address This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder addRoute(@androidx.annotation.NonNull java.net.InetAddress address, int prefixLength) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to add a network route to the VPN interface
 * using a numeric address string. See {@link java.net.InetAddress InetAddress} for the
 * definitions of numeric address formats.
 *
 * Adding a route implicitly allows traffic from that address family
 * (i.e., IPv4 or IPv6) to be routed over the VPN. @see #allowFamily
 *
 * @throws java.lang.IllegalArgumentException if the route is invalid.
 * @see #addRoute(InetAddress, int)
 
 * @param address This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder addRoute(@androidx.annotation.NonNull java.lang.String address, int prefixLength) { throw new RuntimeException("Stub!"); }

/**
 * Add a DNS server to the VPN connection. Both IPv4 and IPv6
 * addresses are supported. If none is set, the DNS servers of
 * the default network will be used.
 *
 * Adding a server implicitly allows traffic from that address family
 * (i.e., IPv4 or IPv6) to be routed over the VPN. @see #allowFamily
 *
 * @throws java.lang.IllegalArgumentException if the address is invalid.
 
 * @param address This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder addDnsServer(@androidx.annotation.NonNull java.net.InetAddress address) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to add a DNS server to the VPN connection
 * using a numeric address string. See {@link java.net.InetAddress InetAddress} for the
 * definitions of numeric address formats.
 *
 * Adding a server implicitly allows traffic from that address family
 * (i.e., IPv4 or IPv6) to be routed over the VPN. @see #allowFamily
 *
 * @throws java.lang.IllegalArgumentException if the address is invalid.
 * @see #addDnsServer(InetAddress)
 
 * @param address This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder addDnsServer(@androidx.annotation.NonNull java.lang.String address) { throw new RuntimeException("Stub!"); }

/**
 * Add a search domain to the DNS resolver.
 
 * @param domain This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder addSearchDomain(@androidx.annotation.NonNull java.lang.String domain) { throw new RuntimeException("Stub!"); }

/**
 * Allows traffic from the specified address family.
 *
 * By default, if no address, route or DNS server of a specific family (IPv4 or IPv6) is
 * added to this VPN, then all outgoing traffic of that family is blocked. If any address,
 * route or DNS server is added, that family is allowed.
 *
 * This method allows an address family to be unblocked even without adding an address,
 * route or DNS server of that family. Traffic of that family will then typically
 * fall-through to the underlying network if it's supported.
 *
 * {@code family} must be either {@code AF_INET} (for IPv4) or {@code AF_INET6} (for IPv6).
 * {@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown if it's neither.
 *
 * @param family The address family ({@code AF_INET} or {@code AF_INET6}) to allow.
 *
 * @return this {@link android.net.VpnService.Builder Builder} object to facilitate chaining of method calls.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder allowFamily(int family) { throw new RuntimeException("Stub!"); }

/**
 * Adds an application that's allowed to access the VPN connection.
 *
 * If this method is called at least once, only applications added through this method (and
 * no others) are allowed access. Else (if this method is never called), all applications
 * are allowed by default.  If some applications are added, other, un-added applications
 * will use networking as if the VPN wasn't running.
 *
 * A {@link android.net.VpnService.Builder Builder} may have only a set of allowed applications OR a set of disallowed
 * ones, but not both. Calling this method after {@link #addDisallowedApplication} has
 * already been called, or vice versa, will throw an {@link java.lang.UnsupportedOperationException UnsupportedOperationException}.
 *
 * {@code packageName} must be the canonical name of a currently installed application.
 * {@link android.content.pm.PackageManager.NameNotFoundException PackageManager.NameNotFoundException} is thrown if there's no such application.
 *
 * @throws android.content.pm.PackageManager.NameNotFoundException If the application isn't installed.
 *
 * @param packageName The full name (e.g.: "com.google.apps.contacts") of an application.
 *
 * This value must never be {@code null}.
 * @return this {@link android.net.VpnService.Builder Builder} object to facilitate chaining method calls.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder addAllowedApplication(@androidx.annotation.NonNull java.lang.String packageName) throws android.content.pm.PackageManager.NameNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Adds an application that's denied access to the VPN connection.
 *
 * By default, all applications are allowed access, except for those denied through this
 * method.  Denied applications will use networking as if the VPN wasn't running.
 *
 * A {@link android.net.VpnService.Builder Builder} may have only a set of allowed applications OR a set of disallowed
 * ones, but not both. Calling this method after {@link #addAllowedApplication} has already
 * been called, or vice versa, will throw an {@link java.lang.UnsupportedOperationException UnsupportedOperationException}.
 *
 * {@code packageName} must be the canonical name of a currently installed application.
 * {@link android.content.pm.PackageManager.NameNotFoundException PackageManager.NameNotFoundException} is thrown if there's no such application.
 *
 * @throws android.content.pm.PackageManager.NameNotFoundException If the application isn't installed.
 *
 * @param packageName The full name (e.g.: "com.google.apps.contacts") of an application.
 *
 * This value must never be {@code null}.
 * @return this {@link android.net.VpnService.Builder Builder} object to facilitate chaining method calls.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder addDisallowedApplication(@androidx.annotation.NonNull java.lang.String packageName) throws android.content.pm.PackageManager.NameNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Allows all apps to bypass this VPN connection.
 *
 * By default, all traffic from apps is forwarded through the VPN interface and it is not
 * possible for apps to side-step the VPN. If this method is called, apps may use methods
 * such as {@link android.net.ConnectivityManager#bindProcessToNetwork ConnectivityManager#bindProcessToNetwork} to instead send/receive
 * directly over the underlying network or any other network they have permissions for.
 *
 * @return this {@link android.net.VpnService.Builder Builder} object to facilitate chaining of method calls.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder allowBypass() { throw new RuntimeException("Stub!"); }

/**
 * Sets the VPN interface's file descriptor to be in blocking/non-blocking mode.
 *
 * By default, the file descriptor returned by {@link #establish} is non-blocking.
 *
 * @param blocking True to put the descriptor into blocking mode; false for non-blocking.
 *
 * @return this {@link android.net.VpnService.Builder Builder} object to facilitate chaining method calls.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder setBlocking(boolean blocking) { throw new RuntimeException("Stub!"); }

/**
 * Sets the underlying networks used by the VPN for its upstream connections.
 *
 * @see android.net.VpnService#setUnderlyingNetworks
 *
 * @param networks An array of networks the VPN uses to tunnel traffic to/from its servers.
 *
 * This value may be {@code null}.
 * @return this {@link android.net.VpnService.Builder Builder} object to facilitate chaining method calls.
 
 * This value will never be {@code null}.
 * @apiSince 22
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder setUnderlyingNetworks(@androidx.annotation.Nullable android.net.Network[] networks) { throw new RuntimeException("Stub!"); }

/**
 * Marks the VPN network as metered. A VPN network is classified as metered when the user is
 * sensitive to heavy data usage due to monetary costs and/or data limitations. In such
 * cases, you should set this to {@code true} so that apps on the system can avoid doing
 * large data transfers. Otherwise, set this to {@code false}. Doing so would cause VPN
 * network to inherit its meteredness from its underlying networks.
 *
 * <p>VPN apps targeting {@link android.os.Build.VERSION_CODES#Q} or above will be
 * considered metered by default.
 *
 * @param isMetered {@code true} if VPN network should be treated as metered regardless of
 *     underlying network meteredness
 * @return this {@link android.net.VpnService.Builder Builder} object to facilitate chaining method calls
 * This value will never be {@code null}.
 * @see #setUnderlyingNetworks(Networks[])
 * @see android.net.ConnectivityManager#isActiveNetworkMetered()
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.VpnService.Builder setMetered(boolean isMetered) { throw new RuntimeException("Stub!"); }

/**
 * Create a VPN interface using the parameters supplied to this
 * builder. The interface works on IP packets, and a file descriptor
 * is returned for the application to access them. Each read
 * retrieves an outgoing packet which was routed to the interface.
 * Each write injects an incoming packet just like it was received
 * from the interface. The file descriptor is put into non-blocking
 * mode by default to avoid blocking Java threads. To use the file
 * descriptor completely in native space, see
 * {@link android.os.ParcelFileDescriptor#detachFd() ParcelFileDescriptor#detachFd()}. The application MUST
 * close the file descriptor when the VPN connection is terminated.
 * The VPN interface will be removed and the network will be
 * restored by the system automatically.
 *
 * <p>To avoid conflicts, there can be only one active VPN interface
 * at the same time. Usually network parameters are never changed
 * during the lifetime of a VPN connection. It is also common for an
 * application to create a new file descriptor after closing the
 * previous one. However, it is rare but not impossible to have two
 * interfaces while performing a seamless handover. In this case, the
 * old interface will be deactivated when the new one is created
 * successfully. Both file descriptors are valid but now outgoing
 * packets will be routed to the new interface. Therefore, after
 * draining the old file descriptor, the application MUST close it
 * and start using the new file descriptor. If the new interface
 * cannot be created, the existing interface and its file descriptor
 * remain untouched.
 *
 * <p>An exception will be thrown if the interface cannot be created
 * for any reason. However, this method returns {@code null} if the
 * application is not prepared or is revoked. This helps solve
 * possible race conditions between other VPN applications.
 *
 * @return {@link android.os.ParcelFileDescriptor ParcelFileDescriptor} of the VPN interface, or
 *         {@code null} if the application is not prepared.
 * @throws java.lang.IllegalArgumentException if a parameter is not accepted
 *         by the operating system.
 * @throws java.lang.IllegalStateException if a parameter cannot be applied
 *         by the operating system.
 * @throws java.lang.SecurityException if the service is not properly declared
 *         in {@code AndroidManifest.xml}.
 * @see android.net.VpnService
 * @apiSince 14
 */

@androidx.annotation.Nullable
public android.os.ParcelFileDescriptor establish() { throw new RuntimeException("Stub!"); }
}

}

