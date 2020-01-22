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


/**
 * Defines error codes returned during SIP actions. For example, during
 * {@link android.net.sip.SipRegistrationListener#onRegistrationFailed SipRegistrationListener#onRegistrationFailed},
 * {@link android.net.sip.SipSession.Listener#onError SipSession.Listener#onError},
 * {@link android.net.sip.SipSession.Listener#onCallChangeFailed SipSession.Listener#onCallChangeFailed} and
 * {@link android.net.sip.SipSession.Listener#onRegistrationFailed SipSession.Listener#onRegistrationFailed}.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SipErrorCode {

private SipErrorCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public static java.lang.String toString(int errorCode) { throw new RuntimeException("Stub!"); }

/**
 * When some error occurs on the device, possibly due to a bug.
 * @apiSince 9
 */

public static final int CLIENT_ERROR = -4; // 0xfffffffc

/**
 * Cross-domain authentication required.
 * @apiSince 9
 */

public static final int CROSS_DOMAIN_AUTHENTICATION = -11; // 0xfffffff5

/**
 * When data connection is lost.
 * @apiSince 9
 */

public static final int DATA_CONNECTION_LOST = -10; // 0xfffffff6

/**
 * When invalid credentials are provided.
 * @apiSince 9
 */

public static final int INVALID_CREDENTIALS = -8; // 0xfffffff8

/**
 * When the remote URI is not valid.
 * @apiSince 9
 */

public static final int INVALID_REMOTE_URI = -6; // 0xfffffffa

/**
 * The client is in a transaction and cannot initiate a new one.
 * @apiSince 9
 */

public static final int IN_PROGRESS = -9; // 0xfffffff7

/**
 * Not an error.
 * @apiSince 9
 */

public static final int NO_ERROR = 0; // 0x0

/**
 * When the peer is not reachable.
 * @apiSince 9
 */

public static final int PEER_NOT_REACHABLE = -7; // 0xfffffff9

/**
 * When server responds with an error.
 * @apiSince 9
 */

public static final int SERVER_ERROR = -2; // 0xfffffffe

/**
 * When the server is not reachable.
 * @apiSince 9
 */

public static final int SERVER_UNREACHABLE = -12; // 0xfffffff4

/**
 * When some socket error occurs.
 * @apiSince 9
 */

public static final int SOCKET_ERROR = -1; // 0xffffffff

/**
 * When the transaction gets timed out.
 * @apiSince 9
 */

public static final int TIME_OUT = -5; // 0xfffffffb

/**
 * When transaction is terminated unexpectedly.
 * @apiSince 9
 */

public static final int TRANSACTION_TERMINTED = -3; // 0xfffffffd
}

