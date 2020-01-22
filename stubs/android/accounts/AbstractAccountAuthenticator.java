/*
 * Copyright (C) 2009 The Android Open Source Project
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


package android.accounts;

import android.os.Bundle;
import android.content.Intent;
import android.os.IBinder;

/**
 * Abstract base class for creating AccountAuthenticators.
 * In order to be an authenticator one must extend this class, provide implementations for the
 * abstract methods, and write a service that returns the result of {@link #getIBinder()}
 * in the service's {@link android.app.Service#onBind(android.content.Intent)} when invoked
 * with an intent with action {@link android.accounts.AccountManager#ACTION_AUTHENTICATOR_INTENT AccountManager#ACTION_AUTHENTICATOR_INTENT}. This service
 * must specify the following intent filter and metadata tags in its AndroidManifest.xml file
 * <pre>
 *   &lt;intent-filter&gt;
 *     &lt;action android:name="android.accounts.AccountAuthenticator" /&gt;
 *   &lt;/intent-filter&gt;
 *   &lt;meta-data android:name="android.accounts.AccountAuthenticator"
 *             android:resource="@xml/authenticator" /&gt;
 * </pre>
 * The <code>android:resource</code> attribute must point to a resource that looks like:
 * <pre>
 * &lt;account-authenticator xmlns:android="http://schemas.android.com/apk/res/android"
 *    android:accountType="typeOfAuthenticator"
 *    android:icon="@drawable/icon"
 *    android:smallIcon="@drawable/miniIcon"
 *    android:label="@string/label"
 *    android:accountPreferences="@xml/account_preferences"
 * /&gt;
 * </pre>
 * Replace the icons and labels with your own resources. The <code>android:accountType</code>
 * attribute must be a string that uniquely identifies your authenticator and will be the same
 * string that user will use when making calls on the {@link android.accounts.AccountManager AccountManager} and it also
 * corresponds to {@link android.accounts.Account#type Account#type} for your accounts. One user of the android:icon is the
 * "Account & Sync" settings page and one user of the android:smallIcon is the Contact Application's
 * tab panels.
 * <p>
 * The preferences attribute points to a PreferenceScreen xml hierarchy that contains
 * a list of PreferenceScreens that can be invoked to manage the authenticator. An example is:
 * <pre>
 * &lt;PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android"&gt;
 *    &lt;PreferenceCategory android:title="@string/title_fmt" /&gt;
 *    &lt;PreferenceScreen
 *         android:key="key1"
 *         android:title="@string/key1_action"
 *         android:summary="@string/key1_summary"&gt;
 *         &lt;intent
 *             android:action="key1.ACTION"
 *             android:targetPackage="key1.package"
 *             android:targetClass="key1.class" /&gt;
 *     &lt;/PreferenceScreen&gt;
 * &lt;/PreferenceScreen&gt;
 * </pre>
 *
 * <p>
 * The standard pattern for implementing any of the abstract methods is the following:
 * <ul>
 * <li> If the supplied arguments are enough for the authenticator to fully satisfy the request
 * then it will do so and return a {@link android.os.Bundle Bundle} that contains the results.
 * <li> If the authenticator needs information from the user to satisfy the request then it
 * will create an {@link android.content.Intent Intent} to an activity that will prompt the user for the information
 * and then carry out the request. This intent must be returned in a Bundle as key
 * {@link android.accounts.AccountManager#KEY_INTENT AccountManager#KEY_INTENT}.
 * <p>
 * The activity needs to return the final result when it is complete so the Intent should contain
 * the {@link android.accounts.AccountAuthenticatorResponse AccountAuthenticatorResponse} as {@link android.accounts.AccountManager#KEY_ACCOUNT_MANAGER_RESPONSE AccountManager#KEY_ACCOUNT_MANAGER_RESPONSE}.
 * The activity must then call {@link android.accounts.AccountAuthenticatorResponse#onResult AccountAuthenticatorResponse#onResult} or
 * {@link android.accounts.AccountAuthenticatorResponse#onError AccountAuthenticatorResponse#onError} when it is complete.
 * <li> If the authenticator cannot synchronously process the request and return a result then it
 * may choose to return null and then use the AccountManagerResponse to send the result
 * when it has completed the request.
 * </ul>
 * <p>
 * The following descriptions of each of the abstract authenticator methods will not describe the
 * possible asynchronous nature of the request handling and will instead just describe the input
 * parameters and the expected result.
 * <p>
 * When writing an activity to satisfy these requests one must pass in the AccountManagerResponse
 * and return the result via that response when the activity finishes (or whenever else  the
 * activity author deems it is the correct time to respond).
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbstractAccountAuthenticator {

/** @apiSince 5 */

public AbstractAccountAuthenticator(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * @return the IBinder for the AccountAuthenticator
 * @apiSince 5
 */

public final android.os.IBinder getIBinder() { throw new RuntimeException("Stub!"); }

/**
 * Returns a Bundle that contains the Intent of the activity that can be used to edit the
 * properties. In order to indicate success the activity should call response.setResult()
 * with a non-null Bundle.
 * @param response used to set the result for the request. If the Constants.INTENT_KEY
 *   is set in the bundle then this response field is to be used for sending future
 *   results if and when the Intent is started.
 * @param accountType the AccountType whose properties are to be edited.
 * @return a Bundle containing the result or the Intent to start to continue the request.
 *   If this is null then the request is considered to still be active and the result should
 *   sent later using response.
 * @apiSince 5
 */

public abstract android.os.Bundle editProperties(android.accounts.AccountAuthenticatorResponse response, java.lang.String accountType);

/**
 * Adds an account of the specified accountType.
 * @param response to send the result back to the AccountManager, will never be null
 * @param accountType the type of account to add, will never be null
 * @param authTokenType the type of auth token to retrieve after adding the account, may be null
 * @param requiredFeatures a String array of authenticator-specific features that the added
 * account must support, may be null
 * @param options a Bundle of authenticator-specific options. It always contains
 * {@link android.accounts.AccountManager#KEY_CALLER_PID AccountManager#KEY_CALLER_PID} and {@link android.accounts.AccountManager#KEY_CALLER_UID AccountManager#KEY_CALLER_UID}
 * fields which will let authenticator know the identity of the caller.
 * @return a Bundle result or null if the result is to be returned via the response. The result
 * will contain either:
 * <ul>
 * <li> {@link android.accounts.AccountManager#KEY_INTENT AccountManager#KEY_INTENT}, or
 * <li> {@link android.accounts.AccountManager#KEY_ACCOUNT_NAME AccountManager#KEY_ACCOUNT_NAME} and {@link android.accounts.AccountManager#KEY_ACCOUNT_TYPE AccountManager#KEY_ACCOUNT_TYPE} of
 * the account that was added, or
 * <li> {@link android.accounts.AccountManager#KEY_ERROR_CODE AccountManager#KEY_ERROR_CODE} and {@link android.accounts.AccountManager#KEY_ERROR_MESSAGE AccountManager#KEY_ERROR_MESSAGE} to
 * indicate an error
 * </ul>
 * @throws android.accounts.NetworkErrorException if the authenticator could not honor the request due to a
 * network error
 * @apiSince 5
 */

public abstract android.os.Bundle addAccount(android.accounts.AccountAuthenticatorResponse response, java.lang.String accountType, java.lang.String authTokenType, java.lang.String[] requiredFeatures, android.os.Bundle options) throws android.accounts.NetworkErrorException;

/**
 * Checks that the user knows the credentials of an account.
 * @param response to send the result back to the AccountManager, will never be null
 * @param account the account whose credentials are to be checked, will never be null
 * @param options a Bundle of authenticator-specific options, may be null
 * @return a Bundle result or null if the result is to be returned via the response. The result
 * will contain either:
 * <ul>
 * <li> {@link android.accounts.AccountManager#KEY_INTENT AccountManager#KEY_INTENT}, or
 * <li> {@link android.accounts.AccountManager#KEY_BOOLEAN_RESULT AccountManager#KEY_BOOLEAN_RESULT}, true if the check succeeded, false otherwise
 * <li> {@link android.accounts.AccountManager#KEY_ERROR_CODE AccountManager#KEY_ERROR_CODE} and {@link android.accounts.AccountManager#KEY_ERROR_MESSAGE AccountManager#KEY_ERROR_MESSAGE} to
 * indicate an error
 * </ul>
 * @throws android.accounts.NetworkErrorException if the authenticator could not honor the request due to a
 * network error
 * @apiSince 5
 */

public abstract android.os.Bundle confirmCredentials(android.accounts.AccountAuthenticatorResponse response, android.accounts.Account account, android.os.Bundle options) throws android.accounts.NetworkErrorException;

/**
 * Gets an authtoken for an account.
 *
 * If not {@code null}, the resultant {@link android.os.Bundle Bundle} will contain different sets of keys
 * depending on whether a token was successfully issued and, if not, whether one
 * could be issued via some {@link android.app.Activity}.
 * <p>
 * If a token cannot be provided without some additional activity, the Bundle should contain
 * {@link android.accounts.AccountManager#KEY_INTENT AccountManager#KEY_INTENT} with an associated {@link android.content.Intent Intent}. On the other hand, if
 * there is no such activity, then a Bundle containing
 * {@link android.accounts.AccountManager#KEY_ERROR_CODE AccountManager#KEY_ERROR_CODE} and {@link android.accounts.AccountManager#KEY_ERROR_MESSAGE AccountManager#KEY_ERROR_MESSAGE} should be
 * returned.
 * <p>
 * If a token can be successfully issued, the implementation should return the
 * {@link android.accounts.AccountManager#KEY_ACCOUNT_NAME AccountManager#KEY_ACCOUNT_NAME} and {@link android.accounts.AccountManager#KEY_ACCOUNT_TYPE AccountManager#KEY_ACCOUNT_TYPE} of the
 * account associated with the token as well as the {@link android.accounts.AccountManager#KEY_AUTHTOKEN AccountManager#KEY_AUTHTOKEN}. In
 * addition {@link android.accounts.AbstractAccountAuthenticator AbstractAccountAuthenticator} implementations that declare themselves
 * {@code android:customTokens=true} may also provide a non-negative {@link
 * #KEY_CUSTOM_TOKEN_EXPIRY} long value containing the expiration timestamp of the expiration
 * time (in millis since the unix epoch), tokens will be cached in memory based on
 * application's packageName/signature for however long that was specified.
 * <p>
 * Implementers should assume that tokens will be cached on the basis of account and
 * authTokenType. The system may ignore the contents of the supplied options Bundle when
 * determining to re-use a cached token. Furthermore, implementers should assume a supplied
 * expiration time will be treated as non-binding advice.
 * <p>
 * Finally, note that for {@code android:customTokens=false} authenticators, tokens are cached
 * indefinitely until some client calls {@link android.accounts.AccountManager#invalidateAuthToken(java.lang.String,java.lang.String) AccountManager#invalidateAuthToken(String,String)}.
 *
 * @param response to send the result back to the AccountManager, will never be null
 * @param account the account whose credentials are to be retrieved, will never be null
 * @param authTokenType the type of auth token to retrieve, will never be null
 * @param options a Bundle of authenticator-specific options. It always contains
 * {@link android.accounts.AccountManager#KEY_CALLER_PID AccountManager#KEY_CALLER_PID} and {@link android.accounts.AccountManager#KEY_CALLER_UID AccountManager#KEY_CALLER_UID}
 * fields which will let authenticator know the identity of the caller.
 * @return a Bundle result or null if the result is to be returned via the response.
 * @throws android.accounts.NetworkErrorException if the authenticator could not honor the request due to a
 * network error
 * @apiSince 5
 */

public abstract android.os.Bundle getAuthToken(android.accounts.AccountAuthenticatorResponse response, android.accounts.Account account, java.lang.String authTokenType, android.os.Bundle options) throws android.accounts.NetworkErrorException;

/**
 * Ask the authenticator for a localized label for the given authTokenType.
 * @param authTokenType the authTokenType whose label is to be returned, will never be null
 * @return the localized label of the auth token type, may be null if the type isn't known
 * @apiSince 5
 */

public abstract java.lang.String getAuthTokenLabel(java.lang.String authTokenType);

/**
 * Update the locally stored credentials for an account.
 * @param response to send the result back to the AccountManager, will never be null
 * @param account the account whose credentials are to be updated, will never be null
 * @param authTokenType the type of auth token to retrieve after updating the credentials,
 * may be null
 * @param options a Bundle of authenticator-specific options, may be null
 * @return a Bundle result or null if the result is to be returned via the response. The result
 * will contain either:
 * <ul>
 * <li> {@link android.accounts.AccountManager#KEY_INTENT AccountManager#KEY_INTENT}, or
 * <li> {@link android.accounts.AccountManager#KEY_ACCOUNT_NAME AccountManager#KEY_ACCOUNT_NAME} and {@link android.accounts.AccountManager#KEY_ACCOUNT_TYPE AccountManager#KEY_ACCOUNT_TYPE} of
 * the account whose credentials were updated, or
 * <li> {@link android.accounts.AccountManager#KEY_ERROR_CODE AccountManager#KEY_ERROR_CODE} and {@link android.accounts.AccountManager#KEY_ERROR_MESSAGE AccountManager#KEY_ERROR_MESSAGE} to
 * indicate an error
 * </ul>
 * @throws android.accounts.NetworkErrorException if the authenticator could not honor the request due to a
 * network error
 * @apiSince 5
 */

public abstract android.os.Bundle updateCredentials(android.accounts.AccountAuthenticatorResponse response, android.accounts.Account account, java.lang.String authTokenType, android.os.Bundle options) throws android.accounts.NetworkErrorException;

/**
 * Checks if the account supports all the specified authenticator specific features.
 * @param response to send the result back to the AccountManager, will never be null
 * @param account the account to check, will never be null
 * @param features an array of features to check, will never be null
 * @return a Bundle result or null if the result is to be returned via the response. The result
 * will contain either:
 * <ul>
 * <li> {@link android.accounts.AccountManager#KEY_INTENT AccountManager#KEY_INTENT}, or
 * <li> {@link android.accounts.AccountManager#KEY_BOOLEAN_RESULT AccountManager#KEY_BOOLEAN_RESULT}, true if the account has all the features,
 * false otherwise
 * <li> {@link android.accounts.AccountManager#KEY_ERROR_CODE AccountManager#KEY_ERROR_CODE} and {@link android.accounts.AccountManager#KEY_ERROR_MESSAGE AccountManager#KEY_ERROR_MESSAGE} to
 * indicate an error
 * </ul>
 * @throws android.accounts.NetworkErrorException if the authenticator could not honor the request due to a
 * network error
 * @apiSince 5
 */

public abstract android.os.Bundle hasFeatures(android.accounts.AccountAuthenticatorResponse response, android.accounts.Account account, java.lang.String[] features) throws android.accounts.NetworkErrorException;

/**
 * Checks if the removal of this account is allowed.
 * @param response to send the result back to the AccountManager, will never be null
 * @param account the account to check, will never be null
 * @return a Bundle result or null if the result is to be returned via the response. The result
 * will contain either:
 * <ul>
 * <li> {@link android.accounts.AccountManager#KEY_INTENT AccountManager#KEY_INTENT}, or
 * <li> {@link android.accounts.AccountManager#KEY_BOOLEAN_RESULT AccountManager#KEY_BOOLEAN_RESULT}, true if the removal of the account is
 * allowed, false otherwise
 * <li> {@link android.accounts.AccountManager#KEY_ERROR_CODE AccountManager#KEY_ERROR_CODE} and {@link android.accounts.AccountManager#KEY_ERROR_MESSAGE AccountManager#KEY_ERROR_MESSAGE} to
 * indicate an error
 * </ul>
 * @throws android.accounts.NetworkErrorException if the authenticator could not honor the request due to a
 * network error
 * @apiSince 5
 */

public android.os.Bundle getAccountRemovalAllowed(android.accounts.AccountAuthenticatorResponse response, android.accounts.Account account) throws android.accounts.NetworkErrorException { throw new RuntimeException("Stub!"); }

/**
 * Returns a Bundle that contains whatever is required to clone the account on a different
 * user. The Bundle is passed to the authenticator instance in the target user via
 * {@link #addAccountFromCredentials(android.accounts.AccountAuthenticatorResponse,android.accounts.Account,android.os.Bundle)}.
 * The default implementation returns null, indicating that cloning is not supported.
 * @param response to send the result back to the AccountManager, will never be null
 * @param account the account to clone, will never be null
 * @return a Bundle result or null if the result is to be returned via the response.
 * @throws android.accounts.NetworkErrorException
 * @see #addAccountFromCredentials(AccountAuthenticatorResponse, Account, Bundle)
 * @apiSince 18
 */

public android.os.Bundle getAccountCredentialsForCloning(android.accounts.AccountAuthenticatorResponse response, android.accounts.Account account) throws android.accounts.NetworkErrorException { throw new RuntimeException("Stub!"); }

/**
 * Creates an account based on credentials provided by the authenticator instance of another
 * user on the device, who has chosen to share the account with this user.
 * @param response to send the result back to the AccountManager, will never be null
 * @param account the account to clone, will never be null
 * @param accountCredentials the Bundle containing the required credentials to create the
 * account. Contents of the Bundle are only meaningful to the authenticator. This Bundle is
 * provided by {@link #getAccountCredentialsForCloning(android.accounts.AccountAuthenticatorResponse,android.accounts.Account)}.
 * @return a Bundle result or null if the result is to be returned via the response.
 * @throws android.accounts.NetworkErrorException
 * @see #getAccountCredentialsForCloning(AccountAuthenticatorResponse, Account)
 * @apiSince 18
 */

public android.os.Bundle addAccountFromCredentials(android.accounts.AccountAuthenticatorResponse response, android.accounts.Account account, android.os.Bundle accountCredentials) throws android.accounts.NetworkErrorException { throw new RuntimeException("Stub!"); }

/**
 * Starts the add account session to authenticate user to an account of the
 * specified accountType. No file I/O should be performed in this call.
 * Account should be added to device only when {@link #finishSession} is
 * called after this.
 * <p>
 * Note: when overriding this method, {@link #finishSession} should be
 * overridden too.
 * </p>
 *
 * @param response to send the result back to the AccountManager, will never
 *            be null
 * @param accountType the type of account to authenticate with, will never
 *            be null
 * @param authTokenType the type of auth token to retrieve after
 *            authenticating with the account, may be null
 * @param requiredFeatures a String array of authenticator-specific features
 *            that the account authenticated with must support, may be null
 * @param options a Bundle of authenticator-specific options, may be null
 * @return a Bundle result or null if the result is to be returned via the
 *         response. The result will contain either:
 *         <ul>
 *         <li>{@link android.accounts.AccountManager#KEY_INTENT AccountManager#KEY_INTENT}, or
 *         <li>{@link android.accounts.AccountManager#KEY_ACCOUNT_SESSION_BUNDLE AccountManager#KEY_ACCOUNT_SESSION_BUNDLE} for adding
 *         the account to device later, and if account is authenticated,
 *         optional {@link android.accounts.AccountManager#KEY_PASSWORD AccountManager#KEY_PASSWORD} and
 *         {@link android.accounts.AccountManager#KEY_ACCOUNT_STATUS_TOKEN AccountManager#KEY_ACCOUNT_STATUS_TOKEN} for checking the
 *         status of the account, or
 *         <li>{@link android.accounts.AccountManager#KEY_ERROR_CODE AccountManager#KEY_ERROR_CODE} and
 *         {@link android.accounts.AccountManager#KEY_ERROR_MESSAGE AccountManager#KEY_ERROR_MESSAGE} to indicate an error
 *         </ul>
 * @throws android.accounts.NetworkErrorException if the authenticator could not honor the
 *             request due to a network error
 * @see #finishSession(AccountAuthenticatorResponse, String, Bundle)
 * @apiSince 26
 */

public android.os.Bundle startAddAccountSession(android.accounts.AccountAuthenticatorResponse response, java.lang.String accountType, java.lang.String authTokenType, java.lang.String[] requiredFeatures, android.os.Bundle options) throws android.accounts.NetworkErrorException { throw new RuntimeException("Stub!"); }

/**
 * Asks user to re-authenticate for an account but defers updating the
 * locally stored credentials. No file I/O should be performed in this call.
 * Local credentials should be updated only when {@link #finishSession} is
 * called after this.
 * <p>
 * Note: when overriding this method, {@link #finishSession} should be
 * overridden too.
 * </p>
 *
 * @param response to send the result back to the AccountManager, will never
 *            be null
 * @param account the account whose credentials are to be updated, will
 *            never be null
 * @param authTokenType the type of auth token to retrieve after updating
 *            the credentials, may be null
 * @param options a Bundle of authenticator-specific options, may be null
 * @return a Bundle result or null if the result is to be returned via the
 *         response. The result will contain either:
 *         <ul>
 *         <li>{@link android.accounts.AccountManager#KEY_INTENT AccountManager#KEY_INTENT}, or
 *         <li>{@link android.accounts.AccountManager#KEY_ACCOUNT_SESSION_BUNDLE AccountManager#KEY_ACCOUNT_SESSION_BUNDLE} for
 *         updating the locally stored credentials later, and if account is
 *         re-authenticated, optional {@link android.accounts.AccountManager#KEY_PASSWORD AccountManager#KEY_PASSWORD}
 *         and {@link android.accounts.AccountManager#KEY_ACCOUNT_STATUS_TOKEN AccountManager#KEY_ACCOUNT_STATUS_TOKEN} for checking
 *         the status of the account later, or
 *         <li>{@link android.accounts.AccountManager#KEY_ERROR_CODE AccountManager#KEY_ERROR_CODE} and
 *         {@link android.accounts.AccountManager#KEY_ERROR_MESSAGE AccountManager#KEY_ERROR_MESSAGE} to indicate an error
 *         </ul>
 * @throws android.accounts.NetworkErrorException if the authenticator could not honor the
 *             request due to a network error
 * @see #finishSession(AccountAuthenticatorResponse, String, Bundle)
 * @apiSince 26
 */

public android.os.Bundle startUpdateCredentialsSession(android.accounts.AccountAuthenticatorResponse response, android.accounts.Account account, java.lang.String authTokenType, android.os.Bundle options) throws android.accounts.NetworkErrorException { throw new RuntimeException("Stub!"); }

/**
 * Finishes the session started by #startAddAccountSession or
 * #startUpdateCredentials by installing the account to device with
 * AccountManager, or updating the local credentials. File I/O may be
 * performed in this call.
 * <p>
 * Note: when overriding this method, {@link #startAddAccountSession} and
 * {@link #startUpdateCredentialsSession} should be overridden too.
 * </p>
 *
 * @param response to send the result back to the AccountManager, will never
 *            be null
 * @param accountType the type of account to authenticate with, will never
 *            be null
 * @param sessionBundle a bundle of session data created by
 *            {@link #startAddAccountSession} used for adding account to
 *            device, or by {@link #startUpdateCredentialsSession} used for
 *            updating local credentials.
 * @return a Bundle result or null if the result is to be returned via the
 *         response. The result will contain either:
 *         <ul>
 *         <li>{@link android.accounts.AccountManager#KEY_INTENT AccountManager#KEY_INTENT}, or
 *         <li>{@link android.accounts.AccountManager#KEY_ACCOUNT_NAME AccountManager#KEY_ACCOUNT_NAME} and
 *         {@link android.accounts.AccountManager#KEY_ACCOUNT_TYPE AccountManager#KEY_ACCOUNT_TYPE} of the account that was
 *         added or local credentials were updated, and optional
 *         {@link android.accounts.AccountManager#KEY_ACCOUNT_STATUS_TOKEN AccountManager#KEY_ACCOUNT_STATUS_TOKEN} for checking
 *         the status of the account later, or
 *         <li>{@link android.accounts.AccountManager#KEY_ERROR_CODE AccountManager#KEY_ERROR_CODE} and
 *         {@link android.accounts.AccountManager#KEY_ERROR_MESSAGE AccountManager#KEY_ERROR_MESSAGE} to indicate an error
 *         </ul>
 * @throws android.accounts.NetworkErrorException if the authenticator could not honor the request due to a
 *             network error
 * @see #startAddAccountSession and #startUpdateCredentialsSession
 * @apiSince 26
 */

public android.os.Bundle finishSession(android.accounts.AccountAuthenticatorResponse response, java.lang.String accountType, android.os.Bundle sessionBundle) throws android.accounts.NetworkErrorException { throw new RuntimeException("Stub!"); }

/**
 * Checks if update of the account credentials is suggested.
 *
 * @param response to send the result back to the AccountManager, will never be null.
 * @param account the account to check, will never be null
 * @param statusToken a String of token which can be used to check the status of locally
 *            stored credentials and if update of credentials is suggested
 * @return a Bundle result or null if the result is to be returned via the response. The result
 *         will contain either:
 *         <ul>
 *         <li>{@link android.accounts.AccountManager#KEY_BOOLEAN_RESULT AccountManager#KEY_BOOLEAN_RESULT}, true if update of account's
 *         credentials is suggested, false otherwise
 *         <li>{@link android.accounts.AccountManager#KEY_ERROR_CODE AccountManager#KEY_ERROR_CODE} and
 *         {@link android.accounts.AccountManager#KEY_ERROR_MESSAGE AccountManager#KEY_ERROR_MESSAGE} to indicate an error
 *         </ul>
 * @throws android.accounts.NetworkErrorException if the authenticator could not honor the request due to a
 *             network error
 * @apiSince 26
 */

public android.os.Bundle isCredentialsUpdateSuggested(android.accounts.AccountAuthenticatorResponse response, android.accounts.Account account, java.lang.String statusToken) throws android.accounts.NetworkErrorException { throw new RuntimeException("Stub!"); }

/**
 * Bundle key used for the {@code long} expiration time (in millis from the unix epoch) of the
 * associated auth token.
 *
 * @see #getAuthToken
 * @apiSince 23
 */

public static final java.lang.String KEY_CUSTOM_TOKEN_EXPIRY = "android.accounts.expiry";
}

