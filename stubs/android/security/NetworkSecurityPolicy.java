/**
 * Copyright (c) 2015, The Android Open Source Project
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


package android.security;


/**
 * Network security policy.
 *
 * <p>Network stacks/components should honor this policy to make it possible to centrally control
 * the relevant aspects of network security behavior.
 *
 * <p>The policy currently consists of a single flag: whether cleartext network traffic is
 * permitted. See {@link #isCleartextTrafficPermitted()}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class NetworkSecurityPolicy {

private NetworkSecurityPolicy() { throw new RuntimeException("Stub!"); }

/**
 * Gets the policy for this process.
 *
 * <p>It's fine to cache this reference. Any changes to the policy will be immediately visible
 * through the reference.
 * @apiSince 23
 */

public static android.security.NetworkSecurityPolicy getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether cleartext network traffic (e.g.&nbsp;HTTP, FTP, WebSockets, XMPP, IMAP, SMTP --
 * without TLS or STARTTLS) is permitted for all network communication from this process.
 *
 * <p>When cleartext network traffic is not permitted, the platform's components (e.g. HTTP and
 * FTP stacks, {@link android.app.DownloadManager}, {@link android.media.MediaPlayer}) will
 * refuse this process's requests to use cleartext traffic. Third-party libraries are strongly
 * encouraged to honor this setting as well.
 *
 * <p>This flag is honored on a best effort basis because it's impossible to prevent all
 * cleartext traffic from Android applications given the level of access provided to them. For
 * example, there's no expectation that the {@link java.net.Socket} API will honor this flag
 * because it cannot determine whether its traffic is in cleartext. However, most network
 * traffic from applications is handled by higher-level network stacks/components which can
 * honor this aspect of the policy.
 *
 * <p>NOTE: {@link android.webkit.WebView} honors this flag for applications targeting API level
 * 26 and up.
 * @apiSince 23
 */

public boolean isCleartextTrafficPermitted() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether cleartext network traffic (e.g.&nbsp;HTTP, FTP, XMPP, IMAP, SMTP -- without
 * TLS or STARTTLS) is permitted for communicating with {@code hostname} for this process.
 *
 * @see #isCleartextTrafficPermitted()
 * @apiSince 24
 */

public boolean isCleartextTrafficPermitted(java.lang.String hostname) { throw new RuntimeException("Stub!"); }
}

