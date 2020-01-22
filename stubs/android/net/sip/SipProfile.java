/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.net.sip;

import java.text.ParseException;

/**
 * Defines a SIP profile, including a SIP account, domain and server information.
 * <p>You can create a {@link android.net.sip.SipProfile SipProfile} using {@link android.net.sip.SipProfile.Builder SipProfile.Builder}. You can also retrieve one from a {@link android.net.sip.SipSession SipSession}, using {@link android.net.sip.SipSession#getLocalProfile SipSession#getLocalProfile} and {@link android.net.sip.SipSession#getPeerProfile SipSession#getPeerProfile}.</p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using SIP, read the
 * <a href="{@docRoot}guide/topics/network/sip.html">Session Initiation Protocol</a>
 * developer guide.</p>
 * </div>
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SipProfile implements android.os.Parcelable, java.io.Serializable, java.lang.Cloneable {

private SipProfile() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Gets the SIP URI string of this profile.
 *
 * @return the SIP URI string of this profile
 * @apiSince 9
 */

public java.lang.String getUriString() { throw new RuntimeException("Stub!"); }

/**
 * Gets the display name of the user.
 *
 * @return the display name of the user
 * @apiSince 9
 */

public java.lang.String getDisplayName() { throw new RuntimeException("Stub!"); }

/**
 * Gets the username.
 *
 * @return the username
 * @apiSince 9
 */

public java.lang.String getUserName() { throw new RuntimeException("Stub!"); }

/**
 * Gets the username for authentication. If it is null, then the username
 * is used in authentication instead.
 *
 * @return the authentication username
 * @see #getUserName
 * @apiSince 12
 */

public java.lang.String getAuthUserName() { throw new RuntimeException("Stub!"); }

/**
 * Gets the password.
 *
 * @return the password
 * @apiSince 9
 */

public java.lang.String getPassword() { throw new RuntimeException("Stub!"); }

/**
 * Gets the SIP domain.
 *
 * @return the SIP domain
 * @apiSince 9
 */

public java.lang.String getSipDomain() { throw new RuntimeException("Stub!"); }

/**
 * Gets the port number of the SIP server.
 *
 * @return the port number of the SIP server
 * @apiSince 9
 */

public int getPort() { throw new RuntimeException("Stub!"); }

/**
 * Gets the protocol used to connect to the server.
 *
 * @return the protocol
 * @apiSince 9
 */

public java.lang.String getProtocol() { throw new RuntimeException("Stub!"); }

/**
 * Gets the network address of the server outbound proxy.
 *
 * @return the network address of the server outbound proxy
 * @apiSince 9
 */

public java.lang.String getProxyAddress() { throw new RuntimeException("Stub!"); }

/**
 * Gets the (user-defined) name of the profile.
 *
 * @return name of the profile
 * @apiSince 9
 */

public java.lang.String getProfileName() { throw new RuntimeException("Stub!"); }

/**
 * Gets the flag of 'Sending keep-alive'.
 *
 * @return the flag of sending SIP keep-alive messages.
 * @apiSince 9
 */

public boolean getSendKeepAlive() { throw new RuntimeException("Stub!"); }

/**
 * Gets the flag of 'Auto Registration'.
 *
 * @return the flag of registering the profile automatically.
 * @apiSince 9
 */

public boolean getAutoRegistration() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public static final android.os.Parcelable.Creator<android.net.sip.SipProfile> CREATOR;
static { CREATOR = null; }
/**
 * Helper class for creating a {@link android.net.sip.SipProfile SipProfile}.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Creates a builder based on the given profile.
 * @apiSince 9
 */

public Builder(android.net.sip.SipProfile profile) { throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 *
 * @param uriString the URI string as "sip:<user_name>@<domain>"
 * @throws java.text.ParseException if the string is not a valid URI
 * @apiSince 9
 */

public Builder(java.lang.String uriString) throws java.text.ParseException { throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 *
 * @param username username of the SIP account
 * @param serverDomain the SIP server domain; if the network address
 *      is different from the domain, use {@link #setOutboundProxy} to
 *      set server address
 * @throws java.text.ParseException if the parameters are not valid
 * @apiSince 9
 */

public Builder(java.lang.String username, java.lang.String serverDomain) throws java.text.ParseException { throw new RuntimeException("Stub!"); }

/**
 * Sets the username used for authentication.
 *
 * @param name authentication username of the profile
 * @return this builder object
 * @apiSince 12
 */

public android.net.sip.SipProfile.Builder setAuthUserName(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Sets the name of the profile. This name is given by user.
 *
 * @param name name of the profile
 * @return this builder object
 * @apiSince 9
 */

public android.net.sip.SipProfile.Builder setProfileName(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Sets the password of the SIP account
 *
 * @param password password of the SIP account
 * @return this builder object
 * @apiSince 9
 */

public android.net.sip.SipProfile.Builder setPassword(java.lang.String password) { throw new RuntimeException("Stub!"); }

/**
 * Sets the port number of the server. By default, it is 5060.
 *
 * @param port port number of the server
 * @return this builder object
 * @throws java.lang.IllegalArgumentException if the port number is out of range
 * @apiSince 9
 */

public android.net.sip.SipProfile.Builder setPort(int port) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the protocol used to connect to the SIP server. Currently,
 * only "UDP" and "TCP" are supported.
 *
 * @param protocol the protocol string
 * @return this builder object
 * @throws java.lang.IllegalArgumentException if the protocol is not recognized
 * @apiSince 9
 */

public android.net.sip.SipProfile.Builder setProtocol(java.lang.String protocol) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the outbound proxy of the SIP server.
 *
 * @param outboundProxy the network address of the outbound proxy
 * @return this builder object
 * @apiSince 9
 */

public android.net.sip.SipProfile.Builder setOutboundProxy(java.lang.String outboundProxy) { throw new RuntimeException("Stub!"); }

/**
 * Sets the display name of the user.
 *
 * @param displayName display name of the user
 * @return this builder object
 * @apiSince 9
 */

public android.net.sip.SipProfile.Builder setDisplayName(java.lang.String displayName) { throw new RuntimeException("Stub!"); }

/**
 * Sets the send keep-alive flag.
 *
 * @param flag true if sending keep-alive message is required,
 *      false otherwise
 * @return this builder object
 * @apiSince 9
 */

public android.net.sip.SipProfile.Builder setSendKeepAlive(boolean flag) { throw new RuntimeException("Stub!"); }

/**
 * Sets the auto. registration flag.
 *
 * @param flag true if the profile will be registered automatically,
 *      false otherwise
 * @return this builder object
 * @apiSince 9
 */

public android.net.sip.SipProfile.Builder setAutoRegistration(boolean flag) { throw new RuntimeException("Stub!"); }

/**
 * Builds and returns the SIP profile object.
 *
 * @return the profile object created
 * @apiSince 9
 */

public android.net.sip.SipProfile build() { throw new RuntimeException("Stub!"); }
}

}

