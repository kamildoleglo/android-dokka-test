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
 * limitations under the License.
 */


package android.content;

import android.app.admin.DevicePolicyManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.service.restrictions.RestrictionsReceiver;
import android.app.Activity;

/**
 * Provides a mechanism for apps to query restrictions imposed by an entity that
 * manages the user. Apps can also send permission requests to a local or remote
 * device administrator to override default app-specific restrictions or any other
 * operation that needs explicit authorization from the administrator.
 * <p>
 * Apps can expose a set of restrictions via an XML file specified in the manifest.
 * <p>
 * If the user has an active Restrictions Provider, dynamic requests can be made in
 * addition to the statically imposed restrictions. Dynamic requests are app-specific
 * and can be expressed via a predefined set of request types.
 * <p>
 * The RestrictionsManager forwards the dynamic requests to the active
 * Restrictions Provider. The Restrictions Provider can respond back to requests by calling
 * {@link #notifyPermissionResponse(java.lang.String,android.os.PersistableBundle)}, when
 * a response is received from the administrator of the device or user.
 * The response is relayed back to the application via a protected broadcast,
 * {@link #ACTION_PERMISSION_RESPONSE_RECEIVED}.
 * <p>
 * Static restrictions are specified by an XML file referenced by a meta-data attribute
 * in the manifest. This enables applications as well as any web administration consoles
 * to be able to read the list of available restrictions from the apk.
 * <p>
 * The syntax of the XML format is as follows:
 * <pre>
 * &lt;?xml version="1.0" encoding="utf-8"?&gt;
 * &lt;restrictions xmlns:android="http://schemas.android.com/apk/res/android" &gt;
 *     &lt;restriction
 *         android:key="string"
 *         android:title="string resource"
 *         android:restrictionType=["bool" | "string" | "integer"
 *                                         | "choice" | "multi-select" | "hidden"
 *                                         | "bundle" | "bundle_array"]
 *         android:description="string resource"
 *         android:entries="string-array resource"
 *         android:entryValues="string-array resource"
 *         android:defaultValue="reference" &gt;
 *             &lt;restriction ... /&gt;
 *             ...
 *     &lt;/restriction&gt;
 *     &lt;restriction ... /&gt;
 *     ...
 * &lt;/restrictions&gt;
 * </pre>
 * <p>
 * The attributes for each restriction depend on the restriction type.
 * <p>
 * <ul>
 * <li><code>key</code>, <code>title</code> and <code>restrictionType</code> are mandatory.</li>
 * <li><code>entries</code> and <code>entryValues</code> are required if <code>restrictionType
 * </code> is <code>choice</code> or <code>multi-select</code>.</li>
 * <li><code>defaultValue</code> is optional and its type depends on the
 * <code>restrictionType</code></li>
 * <li><code>hidden</code> type must have a <code>defaultValue</code> and will
 * not be shown to the administrator. It can be used to pass along data that cannot be modified,
 * such as a version code.</li>
 * <li><code>description</code> is meant to describe the restriction in more detail to the
 * administrator controlling the values, if the title is not sufficient.</li>
 * </ul>
 * <p>
 * Only restrictions of type {@code bundle} and {@code bundle_array} can have one or multiple nested
 * restriction elements.
 * <p>
 * In your manifest's <code>application</code> section, add the meta-data tag to point to
 * the restrictions XML file as shown below:
 * <pre>
 * &lt;application ... &gt;
 *     &lt;meta-data android:name="android.content.APP_RESTRICTIONS"
 *                   android:resource="@xml/app_restrictions" /&gt;
 *     ...
 * &lt;/application&gt;
 * </pre>
 *
 * @see android.content.RestrictionEntry
 * @see android.service.restrictions.RestrictionsReceiver
 * @see android.app.admin.DevicePolicyManager#setRestrictionsProvider(ComponentName, ComponentName)
 * @see android.app.admin.DevicePolicyManager#setApplicationRestrictions(ComponentName, String, Bundle)
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RestrictionsManager {

RestrictionsManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns any available set of application-specific restrictions applicable
 * to this application.
 * @return the application restrictions as a Bundle. Returns null if there
 * are no restrictions.
 * @apiSince 21
 */

public android.os.Bundle getApplicationRestrictions() { throw new RuntimeException("Stub!"); }

/**
 * Called by an application to check if there is an active Restrictions Provider. If
 * there isn't, {@link #requestPermission(java.lang.String,java.lang.String,android.os.PersistableBundle)} is not available.
 *
 * @return whether there is an active Restrictions Provider.
 * @apiSince 21
 */

public boolean hasRestrictionsProvider() { throw new RuntimeException("Stub!"); }

/**
 * Called by an application to request permission for an operation. The contents of the
 * request are passed in a Bundle that contains several pieces of data depending on the
 * chosen request type.
 *
 * @param requestType The type of request. The type could be one of the
 * predefined types specified here or a custom type that the specific
 * Restrictions Provider might understand. For custom types, the type name should be
 * namespaced to avoid collisions with predefined types and types specified by
 * other Restrictions Providers.
 * @param requestId A unique id generated by the app that contains sufficient information
 * to identify the parameters of the request when it receives the id in the response.
 * @param request A PersistableBundle containing the data corresponding to the specified request
 * type. The keys for the data in the bundle depend on the request type.
 *
 * @throws java.lang.IllegalArgumentException if any of the required parameters are missing.
 * @apiSince 21
 */

public void requestPermission(java.lang.String requestType, java.lang.String requestId, android.os.PersistableBundle request) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.content.Intent createLocalApprovalIntent() { throw new RuntimeException("Stub!"); }

/**
 * Called by the Restrictions Provider to deliver a response to an application.
 *
 * @param packageName the application to deliver the response to. Cannot be null.
 * @param response the bundle containing the response status, request ID and other information.
 *                 Cannot be null.
 *
 * @throws java.lang.IllegalArgumentException if any of the required parameters are missing.
 * @apiSince 21
 */

public void notifyPermissionResponse(java.lang.String packageName, android.os.PersistableBundle response) { throw new RuntimeException("Stub!"); }

/**
 * Parse and return the list of restrictions defined in the manifest for the specified
 * package, if any.
 *
 * @param packageName The application for which to fetch the restrictions list.
 * @return The list of RestrictionEntry objects created from the XML file specified
 * in the manifest, or null if none was specified.
 * @apiSince 21
 */

public java.util.List<android.content.RestrictionEntry> getManifestRestrictions(java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Converts a list of restrictions to the corresponding bundle, using the following mapping:
 * <table>
 *     <tr><th>RestrictionEntry</th><th>Bundle</th></tr>
 *     <tr><td>{@link android.content.RestrictionEntry#TYPE_BOOLEAN RestrictionEntry#TYPE_BOOLEAN}</td><td>{@link android.os.Bundle#putBoolean Bundle#putBoolean}</td></tr>
 *     <tr><td>{@link android.content.RestrictionEntry#TYPE_CHOICE RestrictionEntry#TYPE_CHOICE},
 *     {@link android.content.RestrictionEntry#TYPE_MULTI_SELECT RestrictionEntry#TYPE_MULTI_SELECT}</td>
 *     <td>{@link android.os.Bundle#putStringArray Bundle#putStringArray}</td></tr>
 *     <tr><td>{@link android.content.RestrictionEntry#TYPE_INTEGER RestrictionEntry#TYPE_INTEGER}</td><td>{@link android.os.Bundle#putInt Bundle#putInt}</td></tr>
 *     <tr><td>{@link android.content.RestrictionEntry#TYPE_STRING RestrictionEntry#TYPE_STRING}</td><td>{@link android.os.Bundle#putString Bundle#putString}</td></tr>
 *     <tr><td>{@link android.content.RestrictionEntry#TYPE_BUNDLE RestrictionEntry#TYPE_BUNDLE}</td><td>{@link android.os.Bundle#putBundle Bundle#putBundle}</td></tr>
 *     <tr><td>{@link android.content.RestrictionEntry#TYPE_BUNDLE_ARRAY RestrictionEntry#TYPE_BUNDLE_ARRAY}</td>
 *     <td>{@link android.os.Bundle#putParcelableArray Bundle#putParcelableArray}</td></tr>
 * </table>
 * @param entries list of restrictions
 * @apiSince 23
 */

public static android.os.Bundle convertRestrictionsToBundle(java.util.List<android.content.RestrictionEntry> entries) { throw new RuntimeException("Stub!"); }

/**
 * Broadcast intent delivered when a response is received for a permission request. The
 * application should not interrupt the user by coming to the foreground if it isn't
 * currently in the foreground. It can either post a notification informing
 * the user of the response or wait until the next time the user launches the app.
 * <p>
 * For instance, if the user requested permission to make an in-app purchase,
 * the app can post a notification that the request had been approved or denied.
 * <p>
 * The broadcast Intent carries the following extra:
 * {@link #EXTRA_RESPONSE_BUNDLE}.
 * @apiSince 21
 */

public static final java.lang.String ACTION_PERMISSION_RESPONSE_RECEIVED = "android.content.action.PERMISSION_RESPONSE_RECEIVED";

/**
 * Activity intent that is optionally implemented by the Restrictions Provider package
 * to challenge for an administrator PIN or password locally on the device. Apps will
 * call this intent using {@link android.app.Activity#startActivityForResult Activity#startActivityForResult}. On a successful
 * response, {@link android.app.Activity#onActivityResult Activity#onActivityResult} will return a resultCode of
 * {@link android.app.Activity#RESULT_OK Activity#RESULT_OK}.
 * <p>
 * The intent must contain {@link #EXTRA_REQUEST_BUNDLE} as an extra and the bundle must
 * contain at least {@link #REQUEST_KEY_MESSAGE} for the activity to display.
 * <p>
 * @see #createLocalApprovalIntent()
 * @apiSince 21
 */

public static final java.lang.String ACTION_REQUEST_LOCAL_APPROVAL = "android.content.action.REQUEST_LOCAL_APPROVAL";

/**
 * Broadcast intent sent to the Restrictions Provider to handle a permission request from
 * an app. It will have the following extras: {@link #EXTRA_PACKAGE_NAME},
 * {@link #EXTRA_REQUEST_TYPE}, {@link #EXTRA_REQUEST_ID} and {@link #EXTRA_REQUEST_BUNDLE}.
 * The Restrictions Provider will handle the request and respond back to the
 * RestrictionsManager, when a response is available, by calling
 * {@link #notifyPermissionResponse}.
 * <p>
 * The BroadcastReceiver must require the {@link android.Manifest.permission#BIND_DEVICE_ADMIN}
 * permission to ensure that only the system can send the broadcast.
 * @apiSince 21
 */

public static final java.lang.String ACTION_REQUEST_PERMISSION = "android.content.action.REQUEST_PERMISSION";

/**
 * The package name of the application making the request.
 * <p>
 * Type: String
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PACKAGE_NAME = "android.content.extra.PACKAGE_NAME";

/**
 * The request bundle passed in the {@link #ACTION_REQUEST_PERMISSION} broadcast.
 * <p>
 * Type: {@link android.os.PersistableBundle PersistableBundle}
 * @apiSince 21
 */

public static final java.lang.String EXTRA_REQUEST_BUNDLE = "android.content.extra.REQUEST_BUNDLE";

/**
 * The request ID passed in the {@link #ACTION_REQUEST_PERMISSION} broadcast.
 * <p>
 * Type: String
 * @apiSince 21
 */

public static final java.lang.String EXTRA_REQUEST_ID = "android.content.extra.REQUEST_ID";

/**
 * The request type passed in the {@link #ACTION_REQUEST_PERMISSION} broadcast.
 * <p>
 * Type: String
 * @apiSince 21
 */

public static final java.lang.String EXTRA_REQUEST_TYPE = "android.content.extra.REQUEST_TYPE";

/**
 * Contains a response from the administrator for specific request.
 * The bundle contains the following information, at least:
 * <ul>
 * <li>{@link #REQUEST_KEY_ID}: The request ID.</li>
 * <li>{@link #RESPONSE_KEY_RESULT}: The response result.</li>
 * </ul>
 * <p>
 * Type: {@link android.os.PersistableBundle PersistableBundle}
 * @apiSince 21
 */

public static final java.lang.String EXTRA_RESPONSE_BUNDLE = "android.content.extra.RESPONSE_BUNDLE";

/**
 * Name of the meta-data entry in the manifest that points to the XML file containing the
 * application's available restrictions.
 * @see #getManifestRestrictions(String)
 * @apiSince 21
 */

public static final java.lang.String META_DATA_APP_RESTRICTIONS = "android.content.APP_RESTRICTIONS";

/**
 * Key for request approval button label contained in the request bundle.
 * <p>
 * Optional, may be shown as a label on the positive button in a dialog or
 * notification presented to the administrator who approves the request.
 * <p>
 * Type: String
 * @apiSince 21
 */

public static final java.lang.String REQUEST_KEY_APPROVE_LABEL = "android.request.approve_label";

/**
 * Key for request data contained in the request bundle.
 * <p>
 * Optional, typically used to identify the specific data that is being referred to,
 * such as the unique identifier for a movie or book. This is not used for display
 * purposes and is more like a cookie. This value is returned in the
 * {@link #EXTRA_RESPONSE_BUNDLE}.
 * <p>
 * Type: String
 * @apiSince 21
 */

public static final java.lang.String REQUEST_KEY_DATA = "android.request.data";

/**
 * Key for request rejection button label contained in the request bundle.
 * <p>
 * Optional, may be shown as a label on the negative button in a dialog or
 * notification presented to the administrator who approves the request.
 * <p>
 * Type: String
 * @apiSince 21
 */

public static final java.lang.String REQUEST_KEY_DENY_LABEL = "android.request.deny_label";

/**
 * Key for request icon contained in the request bundle.
 * <p>
 * Optional, shown alongside the request message presented to the administrator
 * who approves the request. The content must be a compressed image such as a
 * PNG or JPEG, as a byte array.
 * <p>
 * Type: byte[]
 * @apiSince 21
 */

public static final java.lang.String REQUEST_KEY_ICON = "android.request.icon";

/**
 * Key for request ID contained in the request bundle.
 * <p>
 * App-generated request ID to identify the specific request when receiving
 * a response. This value is returned in the {@link #EXTRA_RESPONSE_BUNDLE}.
 * <p>
 * Type: String
 * @apiSince 21
 */

public static final java.lang.String REQUEST_KEY_ID = "android.request.id";

/**
 * Key for request message contained in the request bundle.
 * <p>
 * Required, shown as the actual message in a notification or dialog presented
 * to the administrator who approves the request.
 * <p>
 * Type: String
 * @apiSince 21
 */

public static final java.lang.String REQUEST_KEY_MESSAGE = "android.request.mesg";

/**
 * Key for issuing a new request, contained in the request bundle. If this is set to true,
 * the Restrictions Provider must make a new request. If it is false or not specified, then
 * the Restrictions Provider can return a cached response that has the same requestId, if
 * available. If there's no cached response, it will issue a new one to the administrator.
 * <p>
 * Type: boolean
 * @apiSince 21
 */

public static final java.lang.String REQUEST_KEY_NEW_REQUEST = "android.request.new_request";

/**
 * Key for request title contained in the request bundle.
 * <p>
 * Optional, typically used as the title of any notification or dialog presented
 * to the administrator who approves the request.
 * <p>
 * Type: String
 * @apiSince 21
 */

public static final java.lang.String REQUEST_KEY_TITLE = "android.request.title";

/**
 * Request type for a simple question, with a possible title and icon.
 * <p>
 * Required keys are: {@link #REQUEST_KEY_MESSAGE}
 * <p>
 * Optional keys are
 * {@link #REQUEST_KEY_DATA}, {@link #REQUEST_KEY_ICON}, {@link #REQUEST_KEY_TITLE},
 * {@link #REQUEST_KEY_APPROVE_LABEL} and {@link #REQUEST_KEY_DENY_LABEL}.
 * @apiSince 21
 */

public static final java.lang.String REQUEST_TYPE_APPROVAL = "android.request.type.approval";

/**
 * Key for the optional error code in the response bundle sent to the application.
 * <p>
 * Type: int
 * <p>
 * Possible values: {@link #RESULT_ERROR_BAD_REQUEST}, {@link #RESULT_ERROR_NETWORK} or
 * {@link #RESULT_ERROR_INTERNAL}.
 * @apiSince 21
 */

public static final java.lang.String RESPONSE_KEY_ERROR_CODE = "android.response.errorcode";

/**
 * Key for the optional message in the response bundle sent to the application.
 * <p>
 * Type: String
 * @apiSince 21
 */

public static final java.lang.String RESPONSE_KEY_MESSAGE = "android.response.msg";

/**
 * Key for the optional timestamp of when the administrator responded to the permission
 * request. It is an represented in milliseconds since January 1, 1970 00:00:00.0 UTC.
 * <p>
 * Type: long
 * @apiSince 21
 */

public static final java.lang.String RESPONSE_KEY_RESPONSE_TIMESTAMP = "android.response.timestamp";

/**
 * Key for the response result in the response bundle sent to the application, for a permission
 * request. It indicates the status of the request. In some cases an additional message might
 * be available in {@link #RESPONSE_KEY_MESSAGE}, to be displayed to the user.
 * <p>
 * Type: int
 * <p>
 * Possible values: {@link #RESULT_APPROVED}, {@link #RESULT_DENIED},
 * {@link #RESULT_NO_RESPONSE}, {@link #RESULT_UNKNOWN_REQUEST} or
 * {@link #RESULT_ERROR}.
 * @apiSince 21
 */

public static final java.lang.String RESPONSE_KEY_RESULT = "android.response.result";

/**
 * Response result value indicating that the request was approved.
 * @apiSince 21
 */

public static final int RESULT_APPROVED = 1; // 0x1

/**
 * Response result value indicating that the request was denied.
 * @apiSince 21
 */

public static final int RESULT_DENIED = 2; // 0x2

/**
 * Response result value indicating an error condition. Additional error code might be available
 * in the response bundle, for the key {@link #RESPONSE_KEY_ERROR_CODE}. There might also be
 * an associated error message in the response bundle, for the key
 * {@link #RESPONSE_KEY_MESSAGE}.
 * @apiSince 21
 */

public static final int RESULT_ERROR = 5; // 0x5

/**
 * Error code indicating that there was a problem with the request.
 * <p>
 * Stored in {@link #RESPONSE_KEY_ERROR_CODE} field in the response bundle.
 * @apiSince 21
 */

public static final int RESULT_ERROR_BAD_REQUEST = 1; // 0x1

/**
 * Error code indicating that there was an internal error.
 * <p>
 * Stored in {@link #RESPONSE_KEY_ERROR_CODE} field in the response bundle.
 * @apiSince 21
 */

public static final int RESULT_ERROR_INTERNAL = 3; // 0x3

/**
 * Error code indicating that there was a problem with the network.
 * <p>
 * Stored in {@link #RESPONSE_KEY_ERROR_CODE} field in the response bundle.
 * @apiSince 21
 */

public static final int RESULT_ERROR_NETWORK = 2; // 0x2

/**
 * Response result value indicating that the request has not received a response yet.
 * @apiSince 21
 */

public static final int RESULT_NO_RESPONSE = 3; // 0x3

/**
 * Response result value indicating that the request is unknown, when it's not a new
 * request.
 * @apiSince 21
 */

public static final int RESULT_UNKNOWN_REQUEST = 4; // 0x4
}

