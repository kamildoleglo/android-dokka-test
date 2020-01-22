/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.net.wifi;


/**
 * From <code>defs.h</code> in <code>wpa_supplicant</code>.
 * <p/>
 * These enumeration values are used to indicate the current wpa_supplicant
 * state. This is more fine-grained than most users will be interested in.
 * In general, it is better to use
 * {@link android.net.NetworkInfo.State NetworkInfo.State}.
 * <p/>
 * Note, the order of these enum constants must match the numerical values of the
 * state constants in <code>defs.h</code> in <code>wpa_supplicant</code>.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum SupplicantState implements android.os.Parcelable {
/**
 * This state indicates that client is not associated, but is likely to
 * start looking for an access point. This state is entered when a
 * connection is lost.
 * @apiSince 1
 */

DISCONNECTED,
/**
 * Interface is disabled
 * <p/>
 * This state is entered if the network interface is disabled.
 * wpa_supplicant refuses any new operations that would
 * use the radio until the interface has been enabled.
 * @apiSince 14
 */

INTERFACE_DISABLED,
/**
 * Inactive state (wpa_supplicant disabled).
 * <p/>
 * This state is entered if there are no enabled networks in the
 * configuration. wpa_supplicant is not trying to associate with a new
 * network and external interaction (e.g., ctrl_iface call to add or
 * enable a network) is needed to start association.
 * @apiSince 1
 */

INACTIVE,
/**
 * Scanning for a network.
 * <p/>
 * This state is entered when wpa_supplicant starts scanning for a
 * network.
 * @apiSince 1
 */

SCANNING,
/**
 * Trying to authenticate with a BSS/SSID
 * <p/>
 * This state is entered when wpa_supplicant has found a suitable BSS
 * to authenticate with and the driver is configured to try to
 * authenticate with this BSS.
 * @apiSince 14
 */

AUTHENTICATING,
/**
 * Trying to associate with a BSS/SSID.
 * <p/>
 * This state is entered when wpa_supplicant has found a suitable BSS
 * to associate with and the driver is configured to try to associate
 * with this BSS in ap_scan=1 mode. When using ap_scan=2 mode, this
 * state is entered when the driver is configured to try to associate
 * with a network using the configured SSID and security policy.
 * @apiSince 1
 */

ASSOCIATING,
/**
 * Association completed.
 * <p/>
 * This state is entered when the driver reports that association has
 * been successfully completed with an AP. If IEEE 802.1X is used
 * (with or without WPA/WPA2), wpa_supplicant remains in this state
 * until the IEEE 802.1X/EAPOL authentication has been completed.
 * @apiSince 1
 */

ASSOCIATED,
/**
 * WPA 4-Way Key Handshake in progress.
 * <p/>
 * This state is entered when WPA/WPA2 4-Way Handshake is started. In
 * case of WPA-PSK, this happens when receiving the first EAPOL-Key
 * frame after association. In case of WPA-EAP, this state is entered
 * when the IEEE 802.1X/EAPOL authentication has been completed.
 * @apiSince 1
 */

FOUR_WAY_HANDSHAKE,
/**
 * WPA Group Key Handshake in progress.
 * <p/>
 * This state is entered when 4-Way Key Handshake has been completed
 * (i.e., when the supplicant sends out message 4/4) and when Group
 * Key rekeying is started by the AP (i.e., when supplicant receives
 * message 1/2).
 * @apiSince 1
 */

GROUP_HANDSHAKE,
/**
 * All authentication completed.
 * <p/>
 * This state is entered when the full authentication process is
 * completed. In case of WPA2, this happens when the 4-Way Handshake is
 * successfully completed. With WPA, this state is entered after the
 * Group Key Handshake; with IEEE 802.1X (non-WPA) connection is
 * completed after dynamic keys are received (or if not used, after
 * the EAP authentication has been completed). With static WEP keys and
 * plaintext connections, this state is entered when an association
 * has been completed.
 * <p/>
 * This state indicates that the supplicant has completed its
 * processing for the association phase and that data connection is
 * fully configured. Note, however, that there may not be any IP
 * address associated with the connection yet. Typically, a DHCP
 * request needs to be sent at this point to obtain an address.
 * @apiSince 1
 */

COMPLETED,
/**
 * An Android-added state that is reported when a client issues an
 * explicit DISCONNECT command. In such a case, the supplicant is
 * not only dissociated from the current access point (as for the
 * DISCONNECTED state above), but it also does not attempt to connect
 * to any access point until a RECONNECT or REASSOCIATE command
 * is issued by the client.
 * @apiSince 1
 */

DORMANT,
/**
 * No connection to wpa_supplicant.
 * <p/>
 * This is an additional pseudo-state to handle the case where
 * wpa_supplicant is not running and/or we have not been able
 * to establish a connection to it.
 * @apiSince 1
 */

UNINITIALIZED,
/**
 * A pseudo-state that should normally never be seen.
 * @apiSince 1
 */

INVALID;

/**
 * Returns {@code true} if the supplicant state is valid and {@code false}
 * otherwise.
 * @param state The supplicant state
 * @return {@code true} if the supplicant state is valid and {@code false}
 * otherwise.
 * @apiSince 1
 */

public static boolean isValidState(android.net.wifi.SupplicantState state) { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }
}

