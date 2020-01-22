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

import android.app.Activity;
import java.util.List;
import android.content.Context;
import android.os.Handler;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import java.util.Map;
import java.util.Set;
import java.io.IOException;

/**
 * This class provides access to a centralized registry of the user's
 * online accounts.  The user enters credentials (username and password) once
 * per account, granting applications access to online resources with
 * "one-click" approval.
 *
 * <p>Different online services have different ways of handling accounts and
 * authentication, so the account manager uses pluggable <em>authenticator</em>
 * modules for different <em>account types</em>.  Authenticators (which may be
 * written by third parties) handle the actual details of validating account
 * credentials and storing account information.  For example, Google, Facebook,
 * and Microsoft Exchange each have their own authenticator.
 *
 * <p>Many servers support some notion of an <em>authentication token</em>,
 * which can be used to authenticate a request to the server without sending
 * the user's actual password.  (Auth tokens are normally created with a
 * separate request which does include the user's credentials.)  AccountManager
 * can generate auth tokens for applications, so the application doesn't need to
 * handle passwords directly.  Auth tokens are normally reusable and cached by
 * AccountManager, but must be refreshed periodically.  It's the responsibility
 * of applications to <em>invalidate</em> auth tokens when they stop working so
 * the AccountManager knows it needs to regenerate them.
 *
 * <p>Applications accessing a server normally go through these steps:
 *
 * <ul>
 * <li>Get an instance of AccountManager using {@link #get(android.content.Context)}.
 *
 * <li>List the available accounts using {@link #getAccountsByType} or
 * {@link #getAccountsByTypeAndFeatures}.  Normally applications will only
 * be interested in accounts with one particular <em>type</em>, which
 * identifies the authenticator.  Account <em>features</em> are used to
 * identify particular account subtypes and capabilities.  Both the account
 * type and features are authenticator-specific strings, and must be known by
 * the application in coordination with its preferred authenticators.
 *
 * <li>Select one or more of the available accounts, possibly by asking the
 * user for their preference.  If no suitable accounts are available,
 * {@link #addAccount} may be called to prompt the user to create an
 * account of the appropriate type.
 *
 * <li><b>Important:</b> If the application is using a previously remembered
 * account selection, it must make sure the account is still in the list
 * of accounts returned by {@link #getAccountsByType}.  Requesting an auth token
 * for an account no longer on the device results in an undefined failure.
 *
 * <li>Request an auth token for the selected account(s) using one of the
 * {@link #getAuthToken} methods or related helpers.  Refer to the description
 * of each method for exact usage and error handling details.
 *
 * <li>Make the request using the auth token.  The form of the auth token,
 * the format of the request, and the protocol used are all specific to the
 * service you are accessing.  The application may use whatever network and
 * protocol libraries are useful.
 *
 * <li><b>Important:</b> If the request fails with an authentication error,
 * it could be that a cached auth token is stale and no longer honored by
 * the server.  The application must call {@link #invalidateAuthToken} to remove
 * the token from the cache, otherwise requests will continue failing!  After
 * invalidating the auth token, immediately go back to the "Request an auth
 * token" step above.  If the process fails the second time, then it can be
 * treated as a "genuine" authentication failure and the user notified or other
 * appropriate actions taken.
 * </ul>
 *
 * <p>Some AccountManager methods may need to interact with the user to
 * prompt for credentials, present options, or ask the user to add an account.
 * The caller may choose whether to allow AccountManager to directly launch the
 * necessary user interface and wait for the user, or to return an Intent which
 * the caller may use to launch the interface, or (in some cases) to install a
 * notification which the user can select at any time to launch the interface.
 * To have AccountManager launch the interface directly, the caller must supply
 * the current foreground {@link android.app.Activity Activity} context.
 *
 * <p>Many AccountManager methods take {@link android.accounts.AccountManagerCallback AccountManagerCallback} and
 * {@link android.os.Handler Handler} as parameters.  These methods return immediately and
 * run asynchronously. If a callback is provided then
 * {@link android.accounts.AccountManagerCallback#run AccountManagerCallback#run} will be invoked on the Handler's
 * thread when the request completes, successfully or not.
 * The result is retrieved by calling {@link android.accounts.AccountManagerFuture#getResult() AccountManagerFuture#getResult()}
 * on the {@link android.accounts.AccountManagerFuture AccountManagerFuture} returned by the method (and also passed
 * to the callback).  This method waits for the operation to complete (if
 * necessary) and either returns the result or throws an exception if an error
 * occurred during the operation.  To make the request synchronously, call
 * {@link android.accounts.AccountManagerFuture#getResult() AccountManagerFuture#getResult()} immediately on receiving the
 * future from the method; no callback need be supplied.
 *
 * <p>Requests which may block, including
 * {@link android.accounts.AccountManagerFuture#getResult() AccountManagerFuture#getResult()}, must never be called on
 * the application's main event thread.  These operations throw
 * {@link java.lang.IllegalStateException IllegalStateException} if they are used on the main thread.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AccountManager {

AccountManager() { throw new RuntimeException("Stub!"); }

/**
 * Gets an AccountManager instance associated with a Context.
 * The {@link android.content.Context Context} will be used as long as the AccountManager is
 * active, so make sure to use a {@link android.content.Context Context} whose lifetime is
 * commensurate with any listeners registered to
 * {@link #addOnAccountsUpdatedListener} or similar methods.
 *
 * <p>It is safe to call this method from the main thread.
 *
 * <p>No permission is required to call this method.
 *
 * @param context The {@link android.content.Context Context} to use when necessary
 * @return An {@link android.accounts.AccountManager AccountManager} instance
 * @apiSince 5
 */

public static android.accounts.AccountManager get(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Gets the saved password associated with the account. This is intended for authenticators and
 * related code; applications should get an auth token instead.
 *
 * <p>
 * It is safe to call this method from the main thread.
 *
 * <p>
 * This method requires the caller to have a signature match with the authenticator that owns
 * the specified account.
 *
 * <p>
 * <b>NOTE:</b> If targeting your app to work on API level
 * {@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1} and before, AUTHENTICATE_ACCOUNTS
 * permission is needed for those platforms. See docs for this function in API level
 * {@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1}.
 *
 * <br>
 * Requires android.Manifest.permission.AUTHENTICATE_ACCOUNTS
 * @param account The account to query for a password. Must not be {@code null}.
 * @return The account's password, null if none or if the account doesn't exist
 * @apiSince 5
 */

public java.lang.String getPassword(android.accounts.Account account) { throw new RuntimeException("Stub!"); }

/**
 * Gets the user data named by "key" associated with the account. This is intended for
 * authenticators and related code to store arbitrary metadata along with accounts. The meaning
 * of the keys and values is up to the authenticator for the account.
 *
 * <p>
 * It is safe to call this method from the main thread.
 *
 * <p>
 * This method requires the caller to have a signature match with the authenticator that owns
 * the specified account.
 *
 * <p>
 * <b>NOTE:</b> If targeting your app to work on API level
 * {@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1} and before, AUTHENTICATE_ACCOUNTS
 * permission is needed for those platforms. See docs for this function in API level
 * {@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1}.
 *
 * <br>
 * Requires android.Manifest.permission.AUTHENTICATE_ACCOUNTS
 * @param account The account to query for user data
 * @return The user data, null if the account, key doesn't exist, or the user is locked
 * @apiSince 5
 */

public java.lang.String getUserData(android.accounts.Account account, java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Lists the currently registered authenticators.
 *
 * <p>It is safe to call this method from the main thread.
 *
 * <p>No permission is required to call this method.
 *
 * @return An array of {@link android.accounts.AuthenticatorDescription AuthenticatorDescription} for every
 *     authenticator known to the AccountManager service.  Empty (never
 *     null) if no authenticators are known.
 * @apiSince 5
 */

public android.accounts.AuthenticatorDescription[] getAuthenticatorTypes() { throw new RuntimeException("Stub!"); }

/**
 * Lists all accounts visible to the caller regardless of type. Equivalent to
 * getAccountsByType(null). These accounts may be visible because the user granted access to the
 * account, or the AbstractAcccountAuthenticator managing the account did so or because the
 * client shares a signature with the managing AbstractAccountAuthenticator.
 *
 * <p>
 * It is safe to call this method from the main thread.
 *
 * <br>
 * Requires {@link android.Manifest.permission#GET_ACCOUNTS}
 * @return An array of {@link android.accounts.Account Account}, one for each account. Empty (never null) if no accounts
 *         have been added.
 * @apiSince 5
 */

@androidx.annotation.NonNull
public android.accounts.Account[] getAccounts() { throw new RuntimeException("Stub!"); }

/**
 * Returns the accounts visible to the specified package in an environment where some apps are
 * not authorized to view all accounts. This method can only be called by system apps and
 * authenticators managing the type.
 * Beginning API level {@link android.os.Build.VERSION_CODES#O} it also return accounts
 * which user can make visible to the application (see {@link #VISIBILITY_USER_MANAGED_VISIBLE}).
 *
 * @param type The type of accounts to return, null to retrieve all accounts
 * @param packageName The package name of the app for which the accounts are to be returned
 * @return An array of {@link android.accounts.Account Account}, one per matching account. Empty (never null) if no
 *         accounts of the specified type can be accessed by the package.
 *
 * @apiSince 18
 */

@androidx.annotation.NonNull
public android.accounts.Account[] getAccountsByTypeForPackage(java.lang.String type, java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Lists all accounts of particular type visible to the caller. These accounts may be visible
 * because the user granted access to the account, or the AbstractAcccountAuthenticator managing
 * the account did so or because the client shares a signature with the managing
 * AbstractAccountAuthenticator.
 *
 * <p>
 * The account type is a string token corresponding to the authenticator and useful domain of
 * the account. For example, there are types corresponding to Google and Facebook. The exact
 * string token to use will be published somewhere associated with the authenticator in
 * question.
 *
 * <p>
 * It is safe to call this method from the main thread.
 *
 * <p>
 * Caller targeting API level {@link android.os.Build.VERSION_CODES#O} and above, will get list
 * of accounts made visible to it by user
 * (see {@link #newChooseAccountIntent(android.accounts.Account,java.util.List,java.lang.String[],java.lang.String,java.lang.String,java.lang.String[],android.os.Bundle)}) or AbstractAcccountAuthenticator
 * using {@link #setAccountVisibility}.
 * {@link android.Manifest.permission#GET_ACCOUNTS} permission is not used.
 *
 * <p>
 * Caller targeting API level below {@link android.os.Build.VERSION_CODES#O} that have not been
 * granted the {@link android.Manifest.permission#GET_ACCOUNTS} permission, will only see those
 * accounts managed by AbstractAccountAuthenticators whose signature matches the client.
 *
 * <p>
 * <b>NOTE:</b> If targeting your app to work on API level
 * {@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1} and before,
 * {@link android.Manifest.permission#GET_ACCOUNTS} permission is
 * needed for those platforms, irrespective of uid or signature match. See docs for this
 * function in API level {@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#GET_ACCOUNTS}
 * @param type The type of accounts to return, null to retrieve all accounts
 * @return An array of {@link android.accounts.Account Account}, one per matching account. Empty (never null) if no
 *         accounts of the specified type have been added.
 * @apiSince 5
 */

@androidx.annotation.NonNull
public android.accounts.Account[] getAccountsByType(java.lang.String type) { throw new RuntimeException("Stub!"); }

/**
 * Finds out whether a particular account has all the specified features. Account features are
 * authenticator-specific string tokens identifying boolean account properties. For example,
 * features are used to tell whether Google accounts have a particular service (such as Google
 * Calendar or Google Talk) enabled. The feature names and their meanings are published
 * somewhere associated with the authenticator in question.
 *
 * <p>
 * This method may be called from any thread, but the returned {@link android.accounts.AccountManagerFuture AccountManagerFuture} must
 * not be used on the main thread.
 *
 * <p>
 * If caller target API level is below {@link android.os.Build.VERSION_CODES#O}, it is
 * required to hold the permission {@link android.Manifest.permission#GET_ACCOUNTS} or have a
 * signature match with the AbstractAccountAuthenticator that manages the account.
 *
 * @param account The {@link android.accounts.Account Account} to test
 * @param features An array of the account features to check
 * @param callback Callback to invoke when the request completes, null for no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread, null for the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to a Boolean, true if the account
 *         exists and has all of the specified features.
 * @apiSince 8
 */

public android.accounts.AccountManagerFuture<java.lang.Boolean> hasFeatures(android.accounts.Account account, java.lang.String[] features, android.accounts.AccountManagerCallback<java.lang.Boolean> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Lists all accounts of a type which have certain features. The account type identifies the
 * authenticator (see {@link #getAccountsByType}). Account features are authenticator-specific
 * string tokens identifying boolean account properties (see {@link #hasFeatures}).
 *
 * <p>
 * Unlike {@link #getAccountsByType}, this method calls the authenticator, which may contact the
 * server or do other work to check account features, so the method returns an
 * {@link android.accounts.AccountManagerFuture AccountManagerFuture}.
 *
 * <p>
 * This method may be called from any thread, but the returned {@link android.accounts.AccountManagerFuture AccountManagerFuture} must
 * not be used on the main thread.
 *
 * <p>
 * Caller targeting API level {@link android.os.Build.VERSION_CODES#O} and above, will get list
 * of accounts made visible to it by user
 * (see {@link #newChooseAccountIntent(android.accounts.Account,java.util.List,java.lang.String[],java.lang.String,java.lang.String,java.lang.String[],android.os.Bundle)}) or AbstractAcccountAuthenticator
 * using {@link #setAccountVisibility}.
 * {@link android.Manifest.permission#GET_ACCOUNTS} permission is not used.
 *
 * <p>
 * Caller targeting API level below {@link android.os.Build.VERSION_CODES#O} that have not been
 * granted the {@link android.Manifest.permission#GET_ACCOUNTS} permission, will only see those
 * accounts managed by AbstractAccountAuthenticators whose signature matches the client.
 * <p>
 * <b>NOTE:</b> If targeting your app to work on API level
 * {@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1} and before,
 * {@link android.Manifest.permission#GET_ACCOUNTS} permission is
 * needed for those platforms, irrespective of uid or signature match. See docs for this
 * function in API level {@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1}.
 *
 *
 * @param type The type of accounts to return, must not be null
 * @param features An array of the account features to require, may be null or empty *
 * @param callback Callback to invoke when the request completes, null for no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread, null for the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to an array of {@link android.accounts.Account Account}, one
 *         per account of the specified type which matches the requested features.
 * @apiSince 5
 */

public android.accounts.AccountManagerFuture<android.accounts.Account[]> getAccountsByTypeAndFeatures(java.lang.String type, java.lang.String[] features, android.accounts.AccountManagerCallback<android.accounts.Account[]> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Adds an account directly to the AccountManager. Normally used by sign-up
 * wizards associated with authenticators, not directly by applications.
 * <p>Calling this method does not update the last authenticated timestamp,
 * referred by {@link #KEY_LAST_AUTHENTICATED_TIME}. To update it, call
 * {@link #notifyAccountAuthenticated(android.accounts.Account)} after getting success.
 * However, if this method is called when it is triggered by addAccount() or
 * addAccountAsUser() or similar functions, then there is no need to update
 * timestamp manually as it is updated automatically by framework on
 * successful completion of the mentioned functions.
 * <p>It is safe to call this method from the main thread.
 * <p>This method requires the caller to have a signature match with the
 * authenticator that owns the specified account.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * AUTHENTICATE_ACCOUNTS permission is needed for those platforms. See docs
 * for this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.AUTHENTICATE_ACCOUNTS
 * @param account The {@link android.accounts.Account Account} to add
 * @param password The password to associate with the account, null for none
 * @param userdata String values to use for the account's userdata, null for
 *            none
 * @return True if the account was successfully added, false if the account
 *         already exists, the account is null, the user is locked, or another error occurs.
 * @apiSince 5
 */

public boolean addAccountExplicitly(android.accounts.Account account, java.lang.String password, android.os.Bundle userdata) { throw new RuntimeException("Stub!"); }

/**
 * Adds an account directly to the AccountManager. Additionally it specifies Account visibility
 * for given list of packages.
 * <p>
 * Normally used by sign-up wizards associated with authenticators, not directly by
 * applications.
 * <p>
 * Calling this method does not update the last authenticated timestamp, referred by
 * {@link #KEY_LAST_AUTHENTICATED_TIME}. To update it, call
 * {@link #notifyAccountAuthenticated(android.accounts.Account)} after getting success.
 * <p>
 * It is safe to call this method from the main thread.
 * <p>
 * This method requires the caller to have a signature match with the authenticator that owns
 * the specified account.
 *
 * @param account The {@link android.accounts.Account Account} to add
 * @param password The password to associate with the account, null for none
 * @param extras String values to use for the account's userdata, null for none
 * @param visibility Map from packageName to visibility values which will be set before account
 *        is added. See {@link #getAccountVisibility} for possible values.
 *
 * @return True if the account was successfully added, false if the account already exists, the
 *         account is null, or another error occurs.
 * @apiSince 26
 */

public boolean addAccountExplicitly(android.accounts.Account account, java.lang.String password, android.os.Bundle extras, java.util.Map<java.lang.String,java.lang.Integer> visibility) { throw new RuntimeException("Stub!"); }

/**
 * Returns package names and visibility which were explicitly set for given account.
 * <p>
 * This method requires the caller to have a signature match with the authenticator that owns
 * the specified account.
 *
 * @param account The account for which visibility data should be returned
 *
 * @return Map from package names to visibility for given account
 * @apiSince 26
 */

public java.util.Map<java.lang.String,java.lang.Integer> getPackagesAndVisibilityForAccount(android.accounts.Account account) { throw new RuntimeException("Stub!"); }

/**
 * Gets all accounts of given type and their visibility for specific package. This method
 * requires the caller to have a signature match with the authenticator that manages
 * accountType. It is a helper method which combines calls to {@link #getAccountsByType} by
 * authenticator and {@link #getAccountVisibility} for every returned account.
 *
 * <p>
 *
 * @param packageName Package name
 * @param accountType {@link android.accounts.Account Account} type
 *
 * @return Map with visibility for all accounts of given type
 * See {@link #getAccountVisibility} for possible values
 * @apiSince 26
 */

public java.util.Map<android.accounts.Account,java.lang.Integer> getAccountsAndVisibilityForPackage(java.lang.String packageName, java.lang.String accountType) { throw new RuntimeException("Stub!"); }

/**
 * Set visibility value of given account to certain package.
 * Package name must match installed application, or be equal to
 * {@link #PACKAGE_NAME_KEY_LEGACY_VISIBLE} or {@link #PACKAGE_NAME_KEY_LEGACY_NOT_VISIBLE}.
 * <p>
 * Possible visibility values:
 * <ul>
 * <li>{@link #VISIBILITY_UNDEFINED}</li>
 * <li>{@link #VISIBILITY_VISIBLE}</li>
 * <li>{@link #VISIBILITY_USER_MANAGED_VISIBLE}</li>
 * <li>{@link #VISIBILITY_NOT_VISIBLE}
 * <li>{@link #VISIBILITY_USER_MANAGED_NOT_VISIBLE}</li>
 * </ul>
 * <p>
 * This method requires the caller to have a signature match with the authenticator that owns
 * the specified account.
 *
 * @param account {@link android.accounts.Account Account} to update visibility
 * @param packageName Package name of the application to modify account visibility
 * @param visibility New visibility value
 *
 * Value is {@link android.accounts.AccountManager#VISIBILITY_UNDEFINED}, {@link android.accounts.AccountManager#VISIBILITY_VISIBLE}, {@link android.accounts.AccountManager#VISIBILITY_USER_MANAGED_VISIBLE}, {@link android.accounts.AccountManager#VISIBILITY_NOT_VISIBLE}, or {@link android.accounts.AccountManager#VISIBILITY_USER_MANAGED_NOT_VISIBLE}
 * @return True, if visibility value was successfully updated.
 * @apiSince 26
 */

public boolean setAccountVisibility(android.accounts.Account account, java.lang.String packageName, int visibility) { throw new RuntimeException("Stub!"); }

/**
 * Get visibility of certain account for given application. Possible returned values are:
 * <ul>
 * <li>{@link #VISIBILITY_VISIBLE}</li>
 * <li>{@link #VISIBILITY_USER_MANAGED_VISIBLE}</li>
 * <li>{@link #VISIBILITY_NOT_VISIBLE}
 * <li>{@link #VISIBILITY_USER_MANAGED_NOT_VISIBLE}</li>
 * </ul>
 *
 * <p>
 * This method requires the caller to have a signature match with the authenticator that owns
 * the specified account.
 *
 * @param account {@link android.accounts.Account Account} to get visibility
 * @param packageName Package name of the application to get account visibility
 *
 * @return int Visibility of given account.
 
 * Value is {@link android.accounts.AccountManager#VISIBILITY_UNDEFINED}, {@link android.accounts.AccountManager#VISIBILITY_VISIBLE}, {@link android.accounts.AccountManager#VISIBILITY_USER_MANAGED_VISIBLE}, {@link android.accounts.AccountManager#VISIBILITY_NOT_VISIBLE}, or {@link android.accounts.AccountManager#VISIBILITY_USER_MANAGED_NOT_VISIBLE}
 * @apiSince 26
 */

public int getAccountVisibility(android.accounts.Account account, java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the system that the account has just been authenticated. This
 * information may be used by other applications to verify the account. This
 * should be called only when the user has entered correct credentials for
 * the account.
 * <p>
 * It is not safe to call this method from the main thread. As such, call it
 * from another thread.
 * <p>This method requires the caller to have a signature match with the
 * authenticator that owns the specified account.
 *
 * <br>
 * Requires android.Manifest.permission.AUTHENTICATE_ACCOUNTS
 * @param account The {@link android.accounts.Account Account} to be updated.
 * @return boolean {@code true} if the authentication of the account has been successfully
 *         acknowledged. Otherwise {@code false}.
 * @apiSince 23
 */

public boolean notifyAccountAuthenticated(android.accounts.Account account) { throw new RuntimeException("Stub!"); }

/**
 * Rename the specified {@link android.accounts.Account Account}.  This is equivalent to removing
 * the existing account and adding a new renamed account with the old
 * account's user data.
 *
 * <p>It is safe to call this method from the main thread.
 *
 * <p>This method requires the caller to have a signature match with the
 * authenticator that manages the specified account.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * AUTHENTICATE_ACCOUNTS permission and same UID as account's authenticator
 * is needed for those platforms. See docs for this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.AUTHENTICATE_ACCOUNTS
 * @param account The {@link android.accounts.Account Account} to rename
 * @param newName String name to be associated with the account.
 * @param callback Callback to invoke when the request completes, null for
 *     no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread, null for
 *     the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to the Account
 *     after the name change. If successful the account's name will be the
 *     specified new name.
 * @apiSince 21
 */

public android.accounts.AccountManagerFuture<android.accounts.Account> renameAccount(android.accounts.Account account, java.lang.String newName, android.accounts.AccountManagerCallback<android.accounts.Account> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Gets the previous name associated with the account or {@code null}, if
 * none. This is intended so that clients of
 * {@link android.accounts.OnAccountsUpdateListener OnAccountsUpdateListener} can determine if an
 * authenticator has renamed an account.
 *
 * <p>It is safe to call this method from the main thread.
 *
 * @param account The account to query for a previous name.
 * @return The account's previous name, null if the account has never been
 *         renamed.
 * @apiSince 21
 */

public java.lang.String getPreviousName(android.accounts.Account account) { throw new RuntimeException("Stub!"); }

/**
 * Removes an account from the AccountManager.  Does nothing if the account
 * does not exist.  Does not delete the account from the server.
 * The authenticator may have its own policies preventing account
 * deletion, in which case the account will not be deleted.
 *
 * <p>This method requires the caller to have a signature match with the
 * authenticator that manages the specified account.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * MANAGE_ACCOUNTS permission is needed for those platforms. See docs for
 * this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.MANAGE_ACCOUNTS
 * @param account The {@link android.accounts.Account Account} to remove
 * @param callback Callback to invoke when the request completes,
 *     null for no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread,
 *     null for the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to a Boolean,
 *     true if the account has been successfully removed
 * @deprecated use
 *     {@link #removeAccount(android.accounts.Account,android.app.Activity,android.accounts.AccountManagerCallback,android.os.Handler)}
 *     instead
 * @apiSince 5
 * @deprecatedSince 22
 */

@Deprecated
public android.accounts.AccountManagerFuture<java.lang.Boolean> removeAccount(android.accounts.Account account, android.accounts.AccountManagerCallback<java.lang.Boolean> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Removes an account from the AccountManager. Does nothing if the account
 * does not exist.  Does not delete the account from the server.
 * The authenticator may have its own policies preventing account
 * deletion, in which case the account will not be deleted.
 *
 * <p>This method may be called from any thread, but the returned
 * {@link android.accounts.AccountManagerFuture AccountManagerFuture} must not be used on the main thread.
 *
 * <p>This method requires the caller to have a signature match with the
 * authenticator that manages the specified account.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * MANAGE_ACCOUNTS permission is needed for those platforms. See docs for
 * this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.MANAGE_ACCOUNTS
 * @param account The {@link android.accounts.Account Account} to remove
 * @param activity The {@link android.app.Activity Activity} context to use for launching a new
 *     authenticator-defined sub-Activity to prompt the user to delete an
 *     account; used only to call startActivity(); if null, the prompt
 *     will not be launched directly, but the {@link android.content.Intent Intent} may be
 *     returned to the caller instead
 * @param callback Callback to invoke when the request completes,
 *     null for no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread,
 *     null for the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to a Bundle with
 *     {@link #KEY_BOOLEAN_RESULT} if activity was specified and an account
 *     was removed or if active. If no activity was specified, the returned
 *     Bundle contains only {@link #KEY_INTENT} with the {@link android.content.Intent Intent}
 *     needed to launch the actual account removal process, if authenticator
 *     needs the activity launch. If an error occurred,
 *     {@link android.accounts.AccountManagerFuture#getResult() AccountManagerFuture#getResult()} throws:
 * <ul>
 * <li> {@link android.accounts.AuthenticatorException AuthenticatorException} if no authenticator was registered for
 *      this account type or the authenticator failed to respond
 * <li> {@link android.accounts.OperationCanceledException OperationCanceledException} if the operation was canceled for
 *      any reason, including the user canceling the creation process or
 *      adding accounts (of this type) has been disabled by policy
 * </ul>
 * @apiSince 22
 */

public android.accounts.AccountManagerFuture<android.os.Bundle> removeAccount(android.accounts.Account account, android.app.Activity activity, android.accounts.AccountManagerCallback<android.os.Bundle> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Removes an account directly. Normally used by authenticators, not
 * directly by applications. Does not delete the account from the server.
 * The authenticator may have its own policies preventing account deletion,
 * in which case the account will not be deleted.
 * <p>
 * It is safe to call this method from the main thread.
 * <p>This method requires the caller to have a signature match with the
 * authenticator that manages the specified account.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * AUTHENTICATE_ACCOUNTS permission and same UID as account's authenticator
 * is needed for those platforms. See docs for this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.AUTHENTICATE_ACCOUNTS
 * @param account The {@link android.accounts.Account Account} to delete.
 * @return True if the account was successfully deleted, false if the
 *         account did not exist, the account is null, or another error
 *         occurs.
 * @apiSince 22
 */

public boolean removeAccountExplicitly(android.accounts.Account account) { throw new RuntimeException("Stub!"); }

/**
 * Removes an auth token from the AccountManager's cache.  Does nothing if
 * the auth token is not currently in the cache.  Applications must call this
 * method when the auth token is found to have expired or otherwise become
 * invalid for authenticating requests.  The AccountManager does not validate
 * or expire cached auth tokens otherwise.
 *
 * <p>It is safe to call this method from the main thread.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * MANAGE_ACCOUNTS or USE_CREDENTIALS permission is needed for those
 * platforms. See docs for this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.MANAGE_ACCOUNTS or android.Manifest.permission.USE_CREDENTIALS
 * @param accountType The account type of the auth token to invalidate, must not be null
 * @param authToken The auth token to invalidate, may be null
 * @apiSince 5
 */

public void invalidateAuthToken(java.lang.String accountType, java.lang.String authToken) { throw new RuntimeException("Stub!"); }

/**
 * Gets an auth token from the AccountManager's cache.  If no auth
 * token is cached for this account, null will be returned -- a new
 * auth token will not be generated, and the server will not be contacted.
 * Intended for use by the authenticator, not directly by applications.
 *
 * <p>It is safe to call this method from the main thread.
 *
 * <p>This method requires the caller to have a signature match with the
 * authenticator that manages the specified account.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * AUTHENTICATE_ACCOUNTS permission and same UID as account's authenticator
 * is needed for those platforms. See docs for this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.AUTHENTICATE_ACCOUNTS
 * @param account The account for which an auth token is to be fetched. Cannot be {@code null}.
 * @param authTokenType The type of auth token to fetch. Cannot be {@code null}.
 * @return The cached auth token for this account and type, or null if
 *     no auth token is cached, the account does not exist, or the user is locked
 * @see #getAuthToken
 * @apiSince 5
 */

public java.lang.String peekAuthToken(android.accounts.Account account, java.lang.String authTokenType) { throw new RuntimeException("Stub!"); }

/**
 * Sets or forgets a saved password. This modifies the local copy of the
 * password used to automatically authenticate the user; it does not change
 * the user's account password on the server. Intended for use by the
 * authenticator, not directly by applications.
 * <p>Calling this method does not update the last authenticated timestamp,
 * referred by {@link #KEY_LAST_AUTHENTICATED_TIME}. To update it, call
 * {@link #notifyAccountAuthenticated(android.accounts.Account)} after getting success.
 * <p>It is safe to call this method from the main thread.
 * <p>This method requires the caller to have a signature match with the
 * authenticator that manages the specified account.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * AUTHENTICATE_ACCOUNTS permission and same UID as account's authenticator
 * is needed for those platforms. See docs for this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.AUTHENTICATE_ACCOUNTS
 * @param account The account whose password is to be set. Cannot be
 *            {@code null}.
 * @param password The password to set, null to clear the password
 * @apiSince 5
 */

public void setPassword(android.accounts.Account account, java.lang.String password) { throw new RuntimeException("Stub!"); }

/**
 * Forgets a saved password.  This erases the local copy of the password;
 * it does not change the user's account password on the server.
 * Has the same effect as setPassword(account, null) but requires fewer
 * permissions, and may be used by applications or management interfaces
 * to "sign out" from an account.
 *
 * <p>This method only successfully clear the account's password when the
 * caller has the same signature as the authenticator that owns the
 * specified account. Otherwise, this method will silently fail.
 *
 * <p>It is safe to call this method from the main thread.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * MANAGE_ACCOUNTS permission is needed for those platforms. See docs for
 * this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.MANAGE_ACCOUNTS
 * @param account The account whose password to clear
 * @apiSince 5
 */

public void clearPassword(android.accounts.Account account) { throw new RuntimeException("Stub!"); }

/**
 * Sets one userdata key for an account. Intended by use for the
 * authenticator to stash state for itself, not directly by applications.
 * The meaning of the keys and values is up to the authenticator.
 *
 * <p>It is safe to call this method from the main thread.
 *
 * <p>This method requires the caller to have a signature match with the
 * authenticator that manages the specified account.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * AUTHENTICATE_ACCOUNTS permission and same UID as account's authenticator
 * is needed for those platforms. See docs for this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.AUTHENTICATE_ACCOUNTS
 * @param account Account whose user data is to be set. Must not be {@code null}.
 * @param key String user data key to set.  Must not be null
 * @param value String value to set, {@code null} to clear this user data key
 * @apiSince 5
 */

public void setUserData(android.accounts.Account account, java.lang.String key, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Adds an auth token to the AccountManager cache for an account.
 * If the account does not exist then this call has no effect.
 * Replaces any previous auth token for this account and auth token type.
 * Intended for use by the authenticator, not directly by applications.
 *
 * <p>It is safe to call this method from the main thread.
 *
 * <p>This method requires the caller to have a signature match with the
 * authenticator that manages the specified account.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * AUTHENTICATE_ACCOUNTS permission and same UID as account's authenticator
 * is needed for those platforms. See docs for this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.AUTHENTICATE_ACCOUNTS
 * @param account The account to set an auth token for
 * @param authTokenType The type of the auth token, see {#getAuthToken}
 * @param authToken The auth token to add to the cache
 * @apiSince 5
 */

public void setAuthToken(android.accounts.Account account, java.lang.String authTokenType, java.lang.String authToken) { throw new RuntimeException("Stub!"); }

/**
 * This convenience helper synchronously gets an auth token with
 * {@link #getAuthToken(android.accounts.Account,java.lang.String,boolean,android.accounts.AccountManagerCallback,android.os.Handler)}.
 *
 * <p>This method may block while a network request completes, and must
 * never be made from the main thread.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * USE_CREDENTIALS permission is needed for those platforms. See docs for
 * this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.USE_CREDENTIALS
 * @param account The account to fetch an auth token for
 * @param authTokenType The auth token type, see {@link #getAuthToken getAuthToken()}
 * @param notifyAuthFailure If true, display a notification and return null
 *     if authentication fails; if false, prompt and wait for the user to
 *     re-enter correct credentials before returning
 * @return An auth token of the specified type for this account, or null
 *     if authentication fails or none can be fetched.
 * @throws android.accounts.AuthenticatorException if the authenticator failed to respond
 * @throws android.accounts.OperationCanceledException if the request was canceled for any
 *     reason, including the user canceling a credential request
 * @throws java.io.IOException if the authenticator experienced an I/O problem
 *     creating a new auth token, usually because of network trouble
 * @apiSince 5
 */

public java.lang.String blockingGetAuthToken(android.accounts.Account account, java.lang.String authTokenType, boolean notifyAuthFailure) throws android.accounts.AuthenticatorException, java.io.IOException, android.accounts.OperationCanceledException { throw new RuntimeException("Stub!"); }

/**
 * Gets an auth token of the specified type for a particular account,
 * prompting the user for credentials if necessary.  This method is
 * intended for applications running in the foreground where it makes
 * sense to ask the user directly for a password.
 *
 * <p>If a previously generated auth token is cached for this account and
 * type, then it is returned.  Otherwise, if a saved password is
 * available, it is sent to the server to generate a new auth token.
 * Otherwise, the user is prompted to enter a password.
 *
 * <p>Some authenticators have auth token <em>types</em>, whose value
 * is authenticator-dependent.  Some services use different token types to
 * access different functionality -- for example, Google uses different auth
 * tokens to access Gmail and Google Calendar for the same account.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * USE_CREDENTIALS permission is needed for those platforms. See docs for
 * this function in API level 22.
 *
 * <p>This method may be called from any thread, but the returned
 * {@link android.accounts.AccountManagerFuture AccountManagerFuture} must not be used on the main thread.
 *
 * <br>
 * Requires android.Manifest.permission.USE_CREDENTIALS
 * @param account The account to fetch an auth token for
 * @param authTokenType The auth token type, an authenticator-dependent
 *     string token, must not be null
 * @param options Authenticator-specific options for the request,
 *     may be null or empty
 * @param activity The {@link android.app.Activity Activity} context to use for launching a new
 *     authenticator-defined sub-Activity to prompt the user for a password
 *     if necessary; used only to call startActivity(); must not be null.
 * @param callback Callback to invoke when the request completes,
 *     null for no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread,
 *     null for the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to a Bundle with
 *     at least the following fields:
 * <ul>
 * <li> {@link #KEY_ACCOUNT_NAME} - the name of the account you supplied
 * <li> {@link #KEY_ACCOUNT_TYPE} - the type of the account
 * <li> {@link #KEY_AUTHTOKEN} - the auth token you wanted
 * </ul>
 *
 * (Other authenticator-specific values may be returned.)  If an auth token
 * could not be fetched, {@link android.accounts.AccountManagerFuture#getResult() AccountManagerFuture#getResult()} throws:
 * <ul>
 * <li> {@link android.accounts.AuthenticatorException AuthenticatorException} if the authenticator failed to respond
 * <li> {@link android.accounts.OperationCanceledException OperationCanceledException} if the operation is canceled for
 *      any reason, incluidng the user canceling a credential request
 * <li> {@link java.io.IOException IOException} if the authenticator experienced an I/O problem
 *      creating a new auth token, usually because of network trouble
 * </ul>
 * If the account is no longer present on the device, the return value is
 * authenticator-dependent.  The caller should verify the validity of the
 * account before requesting an auth token.
 * @apiSince 5
 */

public android.accounts.AccountManagerFuture<android.os.Bundle> getAuthToken(android.accounts.Account account, java.lang.String authTokenType, android.os.Bundle options, android.app.Activity activity, android.accounts.AccountManagerCallback<android.os.Bundle> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Gets an auth token of the specified type for a particular account,
 * optionally raising a notification if the user must enter credentials.
 * This method is intended for background tasks and services where the
 * user should not be immediately interrupted with a password prompt.
 *
 * <p>If a previously generated auth token is cached for this account and
 * type, then it is returned.  Otherwise, if a saved password is
 * available, it is sent to the server to generate a new auth token.
 * Otherwise, an {@link android.content.Intent Intent} is returned which, when started, will
 * prompt the user for a password.  If the notifyAuthFailure parameter is
 * set, a status bar notification is also created with the same Intent,
 * alerting the user that they need to enter a password at some point.
 *
 * <p>In that case, you may need to wait until the user responds, which
 * could take hours or days or forever.  When the user does respond and
 * supply a new password, the account manager will broadcast the
 * {@link #LOGIN_ACCOUNTS_CHANGED_ACTION} Intent and
 * notify {@link android.accounts.OnAccountsUpdateListener OnAccountsUpdateListener} which applications can
 * use to try again.
 *
 * <p>If notifyAuthFailure is not set, it is the application's
 * responsibility to launch the returned Intent at some point.
 * Either way, the result from this call will not wait for user action.
 *
 * <p>Some authenticators have auth token <em>types</em>, whose value
 * is authenticator-dependent.  Some services use different token types to
 * access different functionality -- for example, Google uses different auth
 * tokens to access Gmail and Google Calendar for the same account.
 *
 * <p>This method may be called from any thread, but the returned
 * {@link android.accounts.AccountManagerFuture AccountManagerFuture} must not be used on the main thread.
 *
 * <br>
 * Requires android.Manifest.permission.USE_CREDENTIALS
 * @param account The account to fetch an auth token for
 * @param authTokenType The auth token type, an authenticator-dependent
 *     string token, must not be null
 * @param notifyAuthFailure True to add a notification to prompt the
 *     user for a password if necessary, false to leave that to the caller
 * @param callback Callback to invoke when the request completes,
 *     null for no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread,
 *     null for the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to a Bundle with
 *     at least the following fields on success:
 * <ul>
 * <li> {@link #KEY_ACCOUNT_NAME} - the name of the account you supplied
 * <li> {@link #KEY_ACCOUNT_TYPE} - the type of the account
 * <li> {@link #KEY_AUTHTOKEN} - the auth token you wanted
 * </ul>
 *
 * (Other authenticator-specific values may be returned.)  If the user
 * must enter credentials, the returned Bundle contains only
 * {@link #KEY_INTENT} with the {@link android.content.Intent Intent} needed to launch a prompt.
 *
 * If an error occurred, {@link android.accounts.AccountManagerFuture#getResult() AccountManagerFuture#getResult()} throws:
 * <ul>
 * <li> {@link android.accounts.AuthenticatorException AuthenticatorException} if the authenticator failed to respond
 * <li> {@link android.accounts.OperationCanceledException OperationCanceledException} if the operation is canceled for
 *      any reason, incluidng the user canceling a credential request
 * <li> {@link java.io.IOException IOException} if the authenticator experienced an I/O problem
 *      creating a new auth token, usually because of network trouble
 * </ul>
 * If the account is no longer present on the device, the return value is
 * authenticator-dependent.  The caller should verify the validity of the
 * account before requesting an auth token.
 * @deprecated use {@link #getAuthToken(android.accounts.Account,java.lang.String,android.os.Bundle,boolean,android.accounts.AccountManagerCallback,android.os.Handler)} instead
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated
public android.accounts.AccountManagerFuture<android.os.Bundle> getAuthToken(android.accounts.Account account, java.lang.String authTokenType, boolean notifyAuthFailure, android.accounts.AccountManagerCallback<android.os.Bundle> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Gets an auth token of the specified type for a particular account,
 * optionally raising a notification if the user must enter credentials.
 * This method is intended for background tasks and services where the
 * user should not be immediately interrupted with a password prompt.
 *
 * <p>If a previously generated auth token is cached for this account and
 * type, then it is returned.  Otherwise, if a saved password is
 * available, it is sent to the server to generate a new auth token.
 * Otherwise, an {@link android.content.Intent Intent} is returned which, when started, will
 * prompt the user for a password.  If the notifyAuthFailure parameter is
 * set, a status bar notification is also created with the same Intent,
 * alerting the user that they need to enter a password at some point.
 *
 * <p>In that case, you may need to wait until the user responds, which
 * could take hours or days or forever.  When the user does respond and
 * supply a new password, the account manager will broadcast the
 * {@link #LOGIN_ACCOUNTS_CHANGED_ACTION} Intent and
 * notify {@link android.accounts.OnAccountsUpdateListener OnAccountsUpdateListener} which applications can
 * use to try again.
 *
 * <p>If notifyAuthFailure is not set, it is the application's
 * responsibility to launch the returned Intent at some point.
 * Either way, the result from this call will not wait for user action.
 *
 * <p>Some authenticators have auth token <em>types</em>, whose value
 * is authenticator-dependent.  Some services use different token types to
 * access different functionality -- for example, Google uses different auth
 * tokens to access Gmail and Google Calendar for the same account.
 *
 * <p>This method may be called from any thread, but the returned
 * {@link android.accounts.AccountManagerFuture AccountManagerFuture} must not be used on the main thread.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * USE_CREDENTIALS permission is needed for those platforms. See docs for
 * this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.USE_CREDENTIALS
 * @param account The account to fetch an auth token for
 * @param authTokenType The auth token type, an authenticator-dependent
 *     string token, must not be null
 * @param options Authenticator-specific options for the request,
 *     may be null or empty
 * @param notifyAuthFailure True to add a notification to prompt the
 *     user for a password if necessary, false to leave that to the caller
 * @param callback Callback to invoke when the request completes,
 *     null for no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread,
 *     null for the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to a Bundle with
 *     at least the following fields on success:
 * <ul>
 * <li> {@link #KEY_ACCOUNT_NAME} - the name of the account you supplied
 * <li> {@link #KEY_ACCOUNT_TYPE} - the type of the account
 * <li> {@link #KEY_AUTHTOKEN} - the auth token you wanted
 * </ul>
 *
 * (Other authenticator-specific values may be returned.)  If the user
 * must enter credentials, the returned Bundle contains only
 * {@link #KEY_INTENT} with the {@link android.content.Intent Intent} needed to launch a prompt.
 *
 * If an error occurred, {@link android.accounts.AccountManagerFuture#getResult() AccountManagerFuture#getResult()} throws:
 * <ul>
 * <li> {@link android.accounts.AuthenticatorException AuthenticatorException} if the authenticator failed to respond
 * <li> {@link android.accounts.OperationCanceledException OperationCanceledException} if the operation is canceled for
 *      any reason, incluidng the user canceling a credential request
 * <li> {@link java.io.IOException IOException} if the authenticator experienced an I/O problem
 *      creating a new auth token, usually because of network trouble
 * </ul>
 * If the account is no longer present on the device, the return value is
 * authenticator-dependent.  The caller should verify the validity of the
 * account before requesting an auth token.
 * @apiSince 14
 */

public android.accounts.AccountManagerFuture<android.os.Bundle> getAuthToken(android.accounts.Account account, java.lang.String authTokenType, android.os.Bundle options, boolean notifyAuthFailure, android.accounts.AccountManagerCallback<android.os.Bundle> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Asks the user to add an account of a specified type.  The authenticator
 * for this account type processes this request with the appropriate user
 * interface.  If the user does elect to create a new account, the account
 * name is returned.
 *
 * <p>This method may be called from any thread, but the returned
 * {@link android.accounts.AccountManagerFuture AccountManagerFuture} must not be used on the main thread.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * MANAGE_ACCOUNTS permission is needed for those platforms. See docs for
 * this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.MANAGE_ACCOUNTS
 * @param accountType The type of account to add; must not be null
 * @param authTokenType The type of auth token (see {@link #getAuthToken})
 *     this account will need to be able to generate, null for none
 * @param requiredFeatures The features (see {@link #hasFeatures}) this
 *     account must have, null for none
 * @param addAccountOptions Authenticator-specific options for the request,
 *     may be null or empty
 * @param activity The {@link android.app.Activity Activity} context to use for launching a new
 *     authenticator-defined sub-Activity to prompt the user to create an
 *     account; used only to call startActivity(); if null, the prompt
 *     will not be launched directly, but the necessary {@link android.content.Intent Intent}
 *     will be returned to the caller instead
 * @param callback Callback to invoke when the request completes,
 *     null for no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread,
 *     null for the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to a Bundle with
 *     these fields if activity was specified and an account was created:
 * <ul>
 * <li> {@link #KEY_ACCOUNT_NAME} - the name of the account created
 * <li> {@link #KEY_ACCOUNT_TYPE} - the type of the account
 * </ul>
 *
 * If no activity was specified, the returned Bundle contains only
 * {@link #KEY_INTENT} with the {@link android.content.Intent Intent} needed to launch the
 * actual account creation process.  If an error occurred,
 * {@link android.accounts.AccountManagerFuture#getResult() AccountManagerFuture#getResult()} throws:
 * <ul>
 * <li> {@link android.accounts.AuthenticatorException AuthenticatorException} if no authenticator was registered for
 *      this account type or the authenticator failed to respond
 * <li> {@link android.accounts.OperationCanceledException OperationCanceledException} if the operation was canceled for
 *      any reason, including the user canceling the creation process or adding accounts
 *      (of this type) has been disabled by policy
 * <li> {@link java.io.IOException IOException} if the authenticator experienced an I/O problem
 *      creating a new account, usually because of network trouble
 * </ul>
 * @apiSince 5
 */

public android.accounts.AccountManagerFuture<android.os.Bundle> addAccount(java.lang.String accountType, java.lang.String authTokenType, java.lang.String[] requiredFeatures, android.os.Bundle addAccountOptions, android.app.Activity activity, android.accounts.AccountManagerCallback<android.os.Bundle> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Confirms that the user knows the password for an account to make extra
 * sure they are the owner of the account.  The user-entered password can
 * be supplied directly, otherwise the authenticator for this account type
 * prompts the user with the appropriate interface.  This method is
 * intended for applications which want extra assurance; for example, the
 * phone lock screen uses this to let the user unlock the phone with an
 * account password if they forget the lock pattern.
 *
 * <p>If the user-entered password matches a saved password for this
 * account, the request is considered valid; otherwise the authenticator
 * verifies the password (usually by contacting the server).
 *
 * <p>This method may be called from any thread, but the returned
 * {@link android.accounts.AccountManagerFuture AccountManagerFuture} must not be used on the main thread.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * MANAGE_ACCOUNTS permission is needed for those platforms. See docs
 * for this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.MANAGE_ACCOUNTS
 * @param account The account to confirm password knowledge for
 * @param options Authenticator-specific options for the request;
 *     if the {@link #KEY_PASSWORD} string field is present, the
 *     authenticator may use it directly rather than prompting the user;
 *     may be null or empty
 * @param activity The {@link android.app.Activity Activity} context to use for launching a new
 *     authenticator-defined sub-Activity to prompt the user to enter a
 *     password; used only to call startActivity(); if null, the prompt
 *     will not be launched directly, but the necessary {@link android.content.Intent Intent}
 *     will be returned to the caller instead
 * @param callback Callback to invoke when the request completes,
 *     null for no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread,
 *     null for the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to a Bundle
 *     with these fields if activity or password was supplied and
 *     the account was successfully verified:
 * <ul>
 * <li> {@link #KEY_ACCOUNT_NAME} - the name of the account verified
 * <li> {@link #KEY_ACCOUNT_TYPE} - the type of the account
 * <li> {@link #KEY_BOOLEAN_RESULT} - true to indicate success
 * </ul>
 *
 * If no activity or password was specified, the returned Bundle contains
 * {@link #KEY_INTENT} with the {@link android.content.Intent Intent} needed to launch the
 * password prompt.
 *
 * <p>Also the returning Bundle may contain {@link
 * #KEY_LAST_AUTHENTICATED_TIME} indicating the last time the
 * credential was validated/created.
 *
 * If an error occurred,{@link android.accounts.AccountManagerFuture#getResult() AccountManagerFuture#getResult()} throws:
 * <ul>
 * <li> {@link android.accounts.AuthenticatorException AuthenticatorException} if the authenticator failed to respond
 * <li> {@link android.accounts.OperationCanceledException OperationCanceledException} if the operation was canceled for
 *      any reason, including the user canceling the password prompt
 * <li> {@link java.io.IOException IOException} if the authenticator experienced an I/O problem
 *      verifying the password, usually because of network trouble
 * </ul>
 * @apiSince 5
 */

public android.accounts.AccountManagerFuture<android.os.Bundle> confirmCredentials(android.accounts.Account account, android.os.Bundle options, android.app.Activity activity, android.accounts.AccountManagerCallback<android.os.Bundle> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Asks the user to enter a new password for an account, updating the
 * saved credentials for the account.  Normally this happens automatically
 * when the server rejects credentials during an auth token fetch, but this
 * can be invoked directly to ensure we have the correct credentials stored.
 *
 * <p>This method may be called from any thread, but the returned
 * {@link android.accounts.AccountManagerFuture AccountManagerFuture} must not be used on the main thread.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * MANAGE_ACCOUNTS permission is needed for those platforms. See docs for
 * this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.MANAGE_ACCOUNTS
 * @param account The account to update credentials for
 * @param authTokenType The credentials entered must allow an auth token
 *     of this type to be created (but no actual auth token is returned);
 *     may be null
 * @param options Authenticator-specific options for the request;
 *     may be null or empty
 * @param activity The {@link android.app.Activity Activity} context to use for launching a new
 *     authenticator-defined sub-Activity to prompt the user to enter a
 *     password; used only to call startActivity(); if null, the prompt
 *     will not be launched directly, but the necessary {@link android.content.Intent Intent}
 *     will be returned to the caller instead
 * @param callback Callback to invoke when the request completes,
 *     null for no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread,
 *     null for the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to a Bundle
 *     with these fields if an activity was supplied and the account
 *     credentials were successfully updated:
 * <ul>
 * <li> {@link #KEY_ACCOUNT_NAME} - the name of the account
 * <li> {@link #KEY_ACCOUNT_TYPE} - the type of the account
 * </ul>
 *
 * If no activity was specified, the returned Bundle contains
 * {@link #KEY_INTENT} with the {@link android.content.Intent Intent} needed to launch the
 * password prompt. If an error occurred,
 * {@link android.accounts.AccountManagerFuture#getResult() AccountManagerFuture#getResult()} throws:
 * <ul>
 * <li> {@link android.accounts.AuthenticatorException AuthenticatorException} if the authenticator failed to respond
 * <li> {@link android.accounts.OperationCanceledException OperationCanceledException} if the operation was canceled for
 *      any reason, including the user canceling the password prompt
 * <li> {@link java.io.IOException IOException} if the authenticator experienced an I/O problem
 *      verifying the password, usually because of network trouble
 * </ul>
 * @apiSince 5
 */

public android.accounts.AccountManagerFuture<android.os.Bundle> updateCredentials(android.accounts.Account account, java.lang.String authTokenType, android.os.Bundle options, android.app.Activity activity, android.accounts.AccountManagerCallback<android.os.Bundle> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Offers the user an opportunity to change an authenticator's settings.
 * These properties are for the authenticator in general, not a particular
 * account.  Not all authenticators support this method.
 *
 * <p>This method may be called from any thread, but the returned
 * {@link android.accounts.AccountManagerFuture AccountManagerFuture} must not be used on the main thread.
 *
 * <p>This method requires the caller to have the same signature as the
 * authenticator associated with the specified account type.
 *
 * <p><b>NOTE:</b> If targeting your app to work on API level 22 and before,
 * MANAGE_ACCOUNTS permission is needed for those platforms. See docs
 * for this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.MANAGE_ACCOUNTS
 * @param accountType The account type associated with the authenticator
 *     to adjust
 * @param activity The {@link android.app.Activity Activity} context to use for launching a new
 *     authenticator-defined sub-Activity to adjust authenticator settings;
 *     used only to call startActivity(); if null, the settings dialog will
 *     not be launched directly, but the necessary {@link android.content.Intent Intent} will be
 *     returned to the caller instead
 * @param callback Callback to invoke when the request completes,
 *     null for no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread,
 *     null for the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to a Bundle
 *     which is empty if properties were edited successfully, or
 *     if no activity was specified, contains only {@link #KEY_INTENT}
 *     needed to launch the authenticator's settings dialog.
 *     If an error occurred, {@link android.accounts.AccountManagerFuture#getResult() AccountManagerFuture#getResult()}
 *     throws:
 * <ul>
 * <li> {@link android.accounts.AuthenticatorException AuthenticatorException} if no authenticator was registered for
 *      this account type or the authenticator failed to respond
 * <li> {@link android.accounts.OperationCanceledException OperationCanceledException} if the operation was canceled for
 *      any reason, including the user canceling the settings dialog
 * <li> {@link java.io.IOException IOException} if the authenticator experienced an I/O problem
 *      updating settings, usually because of network trouble
 * </ul>
 * @apiSince 5
 */

public android.accounts.AccountManagerFuture<android.os.Bundle> editProperties(java.lang.String accountType, android.app.Activity activity, android.accounts.AccountManagerCallback<android.os.Bundle> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * This convenience helper combines the functionality of {@link #getAccountsByTypeAndFeatures},
 * {@link #getAuthToken}, and {@link #addAccount}.
 *
 * <p>
 * This method gets a list of the accounts matching specific type and feature set which are
 * visible to the caller (see {@link #getAccountsByType} for details);
 * if there is exactly one already visible account, it is used; if there are some
 * accounts for which user grant visibility, the user is prompted to pick one; if there are
 * none, the user is prompted to add one. Finally, an auth token is acquired for the chosen
 * account.
 *
 * <p>
 * This method may be called from any thread, but the returned {@link android.accounts.AccountManagerFuture AccountManagerFuture} must
 * not be used on the main thread.
 *
 * <p>
 * <b>NOTE:</b> If targeting your app to work on API level 22 and before, MANAGE_ACCOUNTS
 * permission is needed for those platforms. See docs for this function in API level 22.
 *
 * <br>
 * Requires android.Manifest.permission.MANAGE_ACCOUNTS
 * @param accountType The account type required (see {@link #getAccountsByType}), must not be
 *        null
 * @param authTokenType The desired auth token type (see {@link #getAuthToken}), must not be
 *        null
 * @param features Required features for the account (see
 *        {@link #getAccountsByTypeAndFeatures}), may be null or empty
 * @param activity The {@link android.app.Activity Activity} context to use for launching new sub-Activities to
 *        prompt to add an account, select an account, and/or enter a password, as necessary;
 *        used only to call startActivity(); should not be null
 * @param addAccountOptions Authenticator-specific options to use for adding new accounts; may
 *        be null or empty
 * @param getAuthTokenOptions Authenticator-specific options to use for getting auth tokens; may
 *        be null or empty
 * @param callback Callback to invoke when the request completes, null for no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread, null for the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to a Bundle with at least the
 *         following fields:
 *         <ul>
 *         <li>{@link #KEY_ACCOUNT_NAME} - the name of the account
 *         <li>{@link #KEY_ACCOUNT_TYPE} - the type of the account
 *         <li>{@link #KEY_AUTHTOKEN} - the auth token you wanted
 *         </ul>
 *
 *         If an error occurred, {@link android.accounts.AccountManagerFuture#getResult() AccountManagerFuture#getResult()} throws:
 *         <ul>
 *         <li>{@link android.accounts.AuthenticatorException AuthenticatorException} if no authenticator was registered for this
 *         account type or the authenticator failed to respond
 *         <li>{@link android.accounts.OperationCanceledException OperationCanceledException} if the operation was canceled for any reason,
 *         including the user canceling any operation
 *         <li>{@link java.io.IOException IOException} if the authenticator experienced an I/O problem updating
 *         settings, usually because of network trouble
 *         </ul>
 * @apiSince 5
 */

public android.accounts.AccountManagerFuture<android.os.Bundle> getAuthTokenByFeatures(java.lang.String accountType, java.lang.String authTokenType, java.lang.String[] features, android.app.Activity activity, android.os.Bundle addAccountOptions, android.os.Bundle getAuthTokenOptions, android.accounts.AccountManagerCallback<android.os.Bundle> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Deprecated in favor of {@link #newChooseAccountIntent(android.accounts.Account,java.util.List,java.lang.String[],java.lang.String,java.lang.String,java.lang.String[],android.os.Bundle)}.
 *
 * Returns an intent to an {@link android.app.Activity Activity} that prompts the user to choose from a list of
 * accounts.
 * The caller will then typically start the activity by calling
 * <code>startActivityForResult(intent, ...);</code>.
 * <p>
 * On success the activity returns a Bundle with the account name and type specified using
 * keys {@link #KEY_ACCOUNT_NAME} and {@link #KEY_ACCOUNT_TYPE}.
 * Chosen account is marked as {@link #VISIBILITY_USER_MANAGED_VISIBLE} to the caller
 * (see {@link #setAccountVisibility}) and will be returned to it in consequent
 * {@link #getAccountsByType}) calls.
 * <p>
 * The most common case is to call this with one account type, e.g.:
 * <p>
 * <pre>  newChooseAccountIntent(null, null, new String[]{"com.google"}, false, null,
 * null, null, null);</pre>
 * @param selectedAccount if specified, indicates that the {@link android.accounts.Account Account} is the currently
 * selected one, according to the caller's definition of selected.
 * @param allowableAccounts an optional {@link java.util.List List} of accounts that are allowed to be
 * shown. If not specified then this field will not limit the displayed accounts.
 * @param allowableAccountTypes an optional string array of account types. These are used
 * both to filter the shown accounts and to filter the list of account types that are shown
 * when adding an account. If not specified then this field will not limit the displayed
 * account types when adding an account.
 * @param alwaysPromptForAccount boolean that is ignored.
 * @param descriptionOverrideText if non-null this string is used as the description in the
 * accounts chooser screen rather than the default
 * @param addAccountAuthTokenType this string is passed as the {@link #addAccount}
 * authTokenType parameter
 * @param addAccountRequiredFeatures this string array is passed as the {@link #addAccount}
 * requiredFeatures parameter
 * @param addAccountOptions This {@link android.os.Bundle Bundle} is passed as the {@link #addAccount} options
 * parameter
 * @return an {@link android.content.Intent Intent} that can be used to launch the ChooseAccount activity flow.
 * @apiSince 14
 * @deprecatedSince 23
 */

@Deprecated
public static android.content.Intent newChooseAccountIntent(android.accounts.Account selectedAccount, java.util.ArrayList<android.accounts.Account> allowableAccounts, java.lang.String[] allowableAccountTypes, boolean alwaysPromptForAccount, java.lang.String descriptionOverrideText, java.lang.String addAccountAuthTokenType, java.lang.String[] addAccountRequiredFeatures, android.os.Bundle addAccountOptions) { throw new RuntimeException("Stub!"); }

/**
 * Returns an intent to an {@link android.app.Activity Activity} that prompts the user to choose from a list of
 * accounts.
 * The caller will then typically start the activity by calling
 * <code>startActivityForResult(intent, ...);</code>.
 * <p>
 * On success the activity returns a Bundle with the account name and type specified using
 * keys {@link #KEY_ACCOUNT_NAME} and {@link #KEY_ACCOUNT_TYPE}.
 * Chosen account is marked as {@link #VISIBILITY_USER_MANAGED_VISIBLE} to the caller
 * (see {@link #setAccountVisibility}) and will be returned to it in consequent
 * {@link #getAccountsByType}) calls.
 * <p>
 * The most common case is to call this with one account type, e.g.:
 * <p>
 * <pre>  newChooseAccountIntent(null, null, new String[]{"com.google"}, null, null, null,
 * null);</pre>
 * @param selectedAccount if specified, indicates that the {@link android.accounts.Account Account} is the currently
 * selected one, according to the caller's definition of selected.
 * @param allowableAccounts an optional {@link java.util.List List} of accounts that are allowed to be
 * shown. If not specified then this field will not limit the displayed accounts.
 * @param allowableAccountTypes an optional string array of account types. These are used
 * both to filter the shown accounts and to filter the list of account types that are shown
 * when adding an account. If not specified then this field will not limit the displayed
 * account types when adding an account.
 * @param descriptionOverrideText if non-null this string is used as the description in the
 * accounts chooser screen rather than the default
 * @param addAccountAuthTokenType this string is passed as the {@link #addAccount}
 * authTokenType parameter
 * @param addAccountRequiredFeatures this string array is passed as the {@link #addAccount}
 * requiredFeatures parameter
 * @param addAccountOptions This {@link android.os.Bundle Bundle} is passed as the {@link #addAccount} options
 * parameter
 * @return an {@link android.content.Intent Intent} that can be used to launch the ChooseAccount activity flow.
 * @apiSince 23
 */

public static android.content.Intent newChooseAccountIntent(android.accounts.Account selectedAccount, java.util.List<android.accounts.Account> allowableAccounts, java.lang.String[] allowableAccountTypes, java.lang.String descriptionOverrideText, java.lang.String addAccountAuthTokenType, java.lang.String[] addAccountRequiredFeatures, android.os.Bundle addAccountOptions) { throw new RuntimeException("Stub!"); }

/**
 * Adds an {@link android.accounts.OnAccountsUpdateListener OnAccountsUpdateListener} to this instance of the {@link android.accounts.AccountManager AccountManager}. This
 * listener will be notified whenever user or AbstractAcccountAuthenticator made changes to
 * accounts of any type related to the caller. This method is equivalent to
 * addOnAccountsUpdatedListener(listener, handler, updateImmediately, null)
 *
 * <br>
 * Requires {@link android.Manifest.permission#GET_ACCOUNTS}
 * @see #addOnAccountsUpdatedListener(OnAccountsUpdateListener, Handler, boolean,
 *      String[])
 * @apiSince 5
 */

public void addOnAccountsUpdatedListener(android.accounts.OnAccountsUpdateListener listener, android.os.Handler handler, boolean updateImmediately) { throw new RuntimeException("Stub!"); }

/**
 * Adds an {@link android.accounts.OnAccountsUpdateListener OnAccountsUpdateListener} to this instance of the {@link android.accounts.AccountManager AccountManager}. This
 * listener will be notified whenever user or AbstractAcccountAuthenticator made changes to
 * accounts of given types related to the caller -
 * either list of accounts returned by {@link #getAccounts()}
 * was changed, or new account was added for which user can grant access to the caller.
 * <p>
 * As long as this listener is present, the AccountManager instance will not be
 * garbage-collected, and neither will the {@link android.content.Context Context} used to retrieve it, which may be a
 * large Activity instance. To avoid memory leaks, you must remove this listener before then.
 * Normally listeners are added in an Activity or Service's {@link android.app.Activity#onCreate Activity#onCreate} and
 * removed in {@link android.app.Activity#onDestroy Activity#onDestroy}.
 * <p>
 * It is safe to call this method from the main thread.
 *
 * @param listener The listener to send notifications to
 * @param handler {@link android.os.Handler Handler} identifying the thread to use for notifications, null for the
 *        main thread
 * @param updateImmediately If true, the listener will be invoked (on the handler thread) right
 *        away with the current account list
 * @param accountTypes If set, only changes to accounts of given types will be reported.
 * @throws java.lang.IllegalArgumentException if listener is null
 * @throws java.lang.IllegalStateException if listener was already added
 * @apiSince 26
 */

public void addOnAccountsUpdatedListener(android.accounts.OnAccountsUpdateListener listener, android.os.Handler handler, boolean updateImmediately, java.lang.String[] accountTypes) { throw new RuntimeException("Stub!"); }

/**
 * Removes an {@link android.accounts.OnAccountsUpdateListener OnAccountsUpdateListener} previously registered with
 * {@link #addOnAccountsUpdatedListener}.  The listener will no longer
 * receive notifications of account changes.
 *
 * <p>It is safe to call this method from the main thread.
 *
 * <p>No permission is required to call this method.
 *
 * @param listener The previously added listener to remove
 * @throws java.lang.IllegalArgumentException if listener is null
 * @throws java.lang.IllegalStateException if listener was not already added
 * @apiSince 5
 */

public void removeOnAccountsUpdatedListener(android.accounts.OnAccountsUpdateListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Asks the user to authenticate with an account of a specified type. The
 * authenticator for this account type processes this request with the
 * appropriate user interface. If the user does elect to authenticate with a
 * new account, a bundle of session data for installing the account later is
 * returned with optional account password and account status token.
 * <p>
 * This method may be called from any thread, but the returned
 * {@link android.accounts.AccountManagerFuture AccountManagerFuture} must not be used on the main thread.
 * <p>
 * <p>
 * <b>NOTE:</b> The account will not be installed to the device by calling
 * this api alone. #finishSession should be called after this to install the
 * account on device.
 *
 * @param accountType The type of account to add; must not be null
 * @param authTokenType The type of auth token (see {@link #getAuthToken})
 *            this account will need to be able to generate, null for none
 * @param requiredFeatures The features (see {@link #hasFeatures}) this
 *            account must have, null for none
 * @param options Authenticator-specific options for the request, may be
 *            null or empty
 * @param activity The {@link android.app.Activity Activity} context to use for launching a new
 *            authenticator-defined sub-Activity to prompt the user to
 *            create an account; used only to call startActivity(); if null,
 *            the prompt will not be launched directly, but the necessary
 *            {@link android.content.Intent Intent} will be returned to the caller instead
 * @param callback Callback to invoke when the request completes, null for
 *            no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread, null for
 *            the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to a Bundle with
 *         these fields if activity was specified and user was authenticated
 *         with an account:
 *         <ul>
 *         <li>{@link #KEY_ACCOUNT_SESSION_BUNDLE} - encrypted Bundle for
 *         adding the the to the device later.
 *         <li>{@link #KEY_ACCOUNT_STATUS_TOKEN} - optional, token to check
 *         status of the account
 *         </ul>
 *         If no activity was specified, the returned Bundle contains only
 *         {@link #KEY_INTENT} with the {@link android.content.Intent Intent} needed to launch the
 *         actual account creation process. If authenticator doesn't support
 *         this method, the returned Bundle contains only
 *         {@link #KEY_ACCOUNT_SESSION_BUNDLE} with encrypted
 *         {@code options} needed to add account later. If an error
 *         occurred, {@link android.accounts.AccountManagerFuture#getResult() AccountManagerFuture#getResult()} throws:
 *         <ul>
 *         <li>{@link android.accounts.AuthenticatorException AuthenticatorException} if no authenticator was
 *         registered for this account type or the authenticator failed to
 *         respond
 *         <li>{@link android.accounts.OperationCanceledException OperationCanceledException} if the operation was
 *         canceled for any reason, including the user canceling the
 *         creation process or adding accounts (of this type) has been
 *         disabled by policy
 *         <li>{@link java.io.IOException IOException} if the authenticator experienced an I/O
 *         problem creating a new account, usually because of network
 *         trouble
 *         </ul>
 * @see #finishSession
 * @apiSince 26
 */

public android.accounts.AccountManagerFuture<android.os.Bundle> startAddAccountSession(java.lang.String accountType, java.lang.String authTokenType, java.lang.String[] requiredFeatures, android.os.Bundle options, android.app.Activity activity, android.accounts.AccountManagerCallback<android.os.Bundle> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Asks the user to enter a new password for the account but not updating the
 * saved credentials for the account until {@link #finishSession} is called.
 * <p>
 * This method may be called from any thread, but the returned
 * {@link android.accounts.AccountManagerFuture AccountManagerFuture} must not be used on the main thread.
 * <p>
 * <b>NOTE:</b> The saved credentials for the account alone will not be
 * updated by calling this API alone. #finishSession should be called after
 * this to update local credentials
 *
 * @param account The account to update credentials for
 * @param authTokenType The credentials entered must allow an auth token of
 *            this type to be created (but no actual auth token is
 *            returned); may be null
 * @param options Authenticator-specific options for the request; may be
 *            null or empty
 * @param activity The {@link android.app.Activity Activity} context to use for launching a new
 *            authenticator-defined sub-Activity to prompt the user to enter
 *            a password; used only to call startActivity(); if null, the
 *            prompt will not be launched directly, but the necessary
 *            {@link android.content.Intent Intent} will be returned to the caller instead
 * @param callback Callback to invoke when the request completes, null for
 *            no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread, null for
 *            the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to a Bundle with
 *         these fields if an activity was supplied and user was
 *         successfully re-authenticated to the account:
 *         <ul>
 *         <li>{@link #KEY_ACCOUNT_SESSION_BUNDLE} - encrypted Bundle for
 *         updating the local credentials on device later.
 *         <li>{@link #KEY_ACCOUNT_STATUS_TOKEN} - optional, token to check
 *         status of the account
 *         </ul>
 *         If no activity was specified, the returned Bundle contains
 *         {@link #KEY_INTENT} with the {@link android.content.Intent Intent} needed to launch the
 *         password prompt. If an error occurred,
 *         {@link android.accounts.AccountManagerFuture#getResult() AccountManagerFuture#getResult()} throws:
 *         <ul>
 *         <li>{@link android.accounts.AuthenticatorException AuthenticatorException} if the authenticator failed to
 *         respond
 *         <li>{@link android.accounts.OperationCanceledException OperationCanceledException} if the operation was
 *         canceled for any reason, including the user canceling the
 *         password prompt
 *         <li>{@link java.io.IOException IOException} if the authenticator experienced an I/O
 *         problem verifying the password, usually because of network
 *         trouble
 *         </ul>
 * @see #finishSession
 * @apiSince 26
 */

public android.accounts.AccountManagerFuture<android.os.Bundle> startUpdateCredentialsSession(android.accounts.Account account, java.lang.String authTokenType, android.os.Bundle options, android.app.Activity activity, android.accounts.AccountManagerCallback<android.os.Bundle> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Finishes the session started by {@link #startAddAccountSession} or
 * {@link #startUpdateCredentialsSession}. This will either add the account
 * to AccountManager or update the local credentials stored.
 * <p>
 * This method may be called from any thread, but the returned
 * {@link android.accounts.AccountManagerFuture AccountManagerFuture} must not be used on the main thread.
 *
 * @param sessionBundle a {@link android.os.Bundle Bundle} created by {@link #startAddAccountSession} or
 *            {@link #startUpdateCredentialsSession}
 * @param activity The {@link android.app.Activity Activity} context to use for launching a new
 *            authenticator-defined sub-Activity to prompt the user to
 *            create an account or reauthenticate existing account; used
 *            only to call startActivity(); if null, the prompt will not
 *            be launched directly, but the necessary {@link android.content.Intent Intent} will
 *            be returned to the caller instead
 * @param callback Callback to invoke when the request completes, null for
 *            no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread, null for
 *            the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to a Bundle with
 *         these fields if an activity was supplied and an account was added
 *         to device or local credentials were updated::
 *         <ul>
 *         <li>{@link #KEY_ACCOUNT_NAME} - the name of the account created
 *         <li>{@link #KEY_ACCOUNT_TYPE} - the type of the account
 *         <li>{@link #KEY_ACCOUNT_STATUS_TOKEN} - optional, token to check
 *         status of the account
 *         </ul>
 *         If no activity was specified and additional information is needed
 *         from user, the returned Bundle may contains only
 *         {@link #KEY_INTENT} with the {@link android.content.Intent Intent} needed to launch the
 *         actual account creation process. If an error occurred,
 *         {@link android.accounts.AccountManagerFuture#getResult() AccountManagerFuture#getResult()} throws:
 *         <ul>
 *         <li>{@link android.accounts.AuthenticatorException AuthenticatorException} if no authenticator was
 *         registered for this account type or the authenticator failed to
 *         respond
 *         <li>{@link android.accounts.OperationCanceledException OperationCanceledException} if the operation was
 *         canceled for any reason, including the user canceling the
 *         creation process or adding accounts (of this type) has been
 *         disabled by policy
 *         <li>{@link java.io.IOException IOException} if the authenticator experienced an I/O
 *         problem creating a new account, usually because of network
 *         trouble
 *         </ul>
 * @see #startAddAccountSession and #startUpdateCredentialsSession
 * @apiSince 26
 */

public android.accounts.AccountManagerFuture<android.os.Bundle> finishSession(android.os.Bundle sessionBundle, android.app.Activity activity, android.accounts.AccountManagerCallback<android.os.Bundle> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether {@link #updateCredentials} or {@link #startUpdateCredentialsSession} should be
 * called with respect to the specified account.
 * <p>
 * This method may be called from any thread, but the returned {@link android.accounts.AccountManagerFuture AccountManagerFuture} must
 * not be used on the main thread.
 *
 * @param account The {@link android.accounts.Account Account} to be checked whether {@link #updateCredentials} or
 * {@link #startUpdateCredentialsSession} should be called
 * @param statusToken a String of token to check account staus
 * @param callback Callback to invoke when the request completes, null for no callback
 * @param handler {@link android.os.Handler Handler} identifying the callback thread, null for the main thread
 * @return An {@link android.accounts.AccountManagerFuture AccountManagerFuture} which resolves to a Boolean, true if the credentials
 *         of the account should be updated.
 * @apiSince 26
 */

public android.accounts.AccountManagerFuture<java.lang.Boolean> isCredentialsUpdateSuggested(android.accounts.Account account, java.lang.String statusToken, android.accounts.AccountManagerCallback<java.lang.Boolean> callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Action sent as a broadcast Intent by the AccountsService when any account is removed
 * or renamed. Only applications which were able to see the account will receive the intent.
 * Intent extra will include the following fields:
 * <ul>
 * <li> {@link #KEY_ACCOUNT_NAME} - the name of the removed account
 * <li> {@link #KEY_ACCOUNT_TYPE} - the type of the account
 * </ul>
 * @apiSince 26
 */

public static final java.lang.String ACTION_ACCOUNT_REMOVED = "android.accounts.action.ACCOUNT_REMOVED";

/** @apiSince 5 */

public static final java.lang.String ACTION_AUTHENTICATOR_INTENT = "android.accounts.AccountAuthenticator";

/** @apiSince 5 */

public static final java.lang.String AUTHENTICATOR_ATTRIBUTES_NAME = "account-authenticator";

/** @apiSince 5 */

public static final java.lang.String AUTHENTICATOR_META_DATA_NAME = "android.accounts.AccountAuthenticator";

/** @apiSince 5 */

public static final int ERROR_CODE_BAD_ARGUMENTS = 7; // 0x7

/** @apiSince 18 */

public static final int ERROR_CODE_BAD_AUTHENTICATION = 9; // 0x9

/** @apiSince 5 */

public static final int ERROR_CODE_BAD_REQUEST = 8; // 0x8

/** @apiSince 5 */

public static final int ERROR_CODE_CANCELED = 4; // 0x4

/** @apiSince 5 */

public static final int ERROR_CODE_INVALID_RESPONSE = 5; // 0x5

/** @apiSince 5 */

public static final int ERROR_CODE_NETWORK_ERROR = 3; // 0x3

/** @apiSince 5 */

public static final int ERROR_CODE_REMOTE_EXCEPTION = 1; // 0x1

/** @apiSince 5 */

public static final int ERROR_CODE_UNSUPPORTED_OPERATION = 6; // 0x6

/** @apiSince 5 */

public static final java.lang.String KEY_ACCOUNTS = "accounts";

/** @apiSince 5 */

public static final java.lang.String KEY_ACCOUNT_AUTHENTICATOR_RESPONSE = "accountAuthenticatorResponse";

/** @apiSince 5 */

public static final java.lang.String KEY_ACCOUNT_MANAGER_RESPONSE = "accountManagerResponse";

/**
 * Bundle key used for the {@link java.lang.String String} account name in results
 * from methods which return information about a particular account.
 * @apiSince 5
 */

public static final java.lang.String KEY_ACCOUNT_NAME = "authAccount";

/**
 * Bundle key used for a {@link android.os.Bundle Bundle} in result from
 * {@link #startAddAccountSession} and friends which returns session data
 * for installing an account later.
 * @apiSince 26
 */

public static final java.lang.String KEY_ACCOUNT_SESSION_BUNDLE = "accountSessionBundle";

/**
 * Bundle key used for the {@link java.lang.String String} account status token in result
 * from {@link #startAddAccountSession} and friends which returns
 * information about a particular account.
 * @apiSince 26
 */

public static final java.lang.String KEY_ACCOUNT_STATUS_TOKEN = "accountStatusToken";

/**
 * Bundle key used for the {@link java.lang.String String} account type in results
 * from methods which return information about a particular account.
 * @apiSince 5
 */

public static final java.lang.String KEY_ACCOUNT_TYPE = "accountType";

/**
 * The Android package of the caller will be set in the options bundle by the
 * {@link android.accounts.AccountManager AccountManager} and will be passed to the AccountManagerService and
 * to the AccountAuthenticators. The uid of the caller will be known by the
 * AccountManagerService as well as the AccountAuthenticators so they will be able to
 * verify that the package is consistent with the uid (a uid might be shared by many
 * packages).
 * @apiSince 14
 */

public static final java.lang.String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";

/** @apiSince 5 */

public static final java.lang.String KEY_AUTHENTICATOR_TYPES = "authenticator_types";

/**
 * Bundle key used for the auth token value in results
 * from {@link #getAuthToken} and friends.
 * @apiSince 5
 */

public static final java.lang.String KEY_AUTHTOKEN = "authtoken";

/** @apiSince 5 */

public static final java.lang.String KEY_AUTH_FAILED_MESSAGE = "authFailedMessage";

/** @apiSince 5 */

public static final java.lang.String KEY_AUTH_TOKEN_LABEL = "authTokenLabelKey";

/** @apiSince 5 */

public static final java.lang.String KEY_BOOLEAN_RESULT = "booleanResult";

/**
 * The process id of caller app.
 * @apiSince 11
 */

public static final java.lang.String KEY_CALLER_PID = "callerPid";

/**
 * The UID of caller app.
 * @apiSince 11
 */

public static final java.lang.String KEY_CALLER_UID = "callerUid";

/** @apiSince 5 */

public static final java.lang.String KEY_ERROR_CODE = "errorCode";

/** @apiSince 5 */

public static final java.lang.String KEY_ERROR_MESSAGE = "errorMessage";

/**
 * Bundle key used for an {@link android.content.Intent Intent} in results from methods that
 * may require the caller to interact with the user.  The Intent can
 * be used to start the corresponding user interface activity.
 * @apiSince 5
 */

public static final java.lang.String KEY_INTENT = "intent";

/**
 * Bundle key used to supply the last time the credentials of the account
 * were authenticated successfully. Time is specified in milliseconds since
 * epoch. Associated time is updated on successful authentication of account
 * on adding account, confirming credentials, or updating credentials.
 * @apiSince 23
 */

public static final java.lang.String KEY_LAST_AUTHENTICATED_TIME = "lastAuthenticatedTime";

/**
 * Bundle key used to supply the password directly in options to
 * {@link #confirmCredentials}, rather than prompting the user with
 * the standard password prompt.
 * @apiSince 5
 */

public static final java.lang.String KEY_PASSWORD = "password";

/** @apiSince 5 */

public static final java.lang.String KEY_USERDATA = "userdata";

/**
 * Action sent as a broadcast Intent by the AccountsService when accounts are added, accounts
 * are removed, or an account's credentials (saved password, etc) are changed.
 *
 * @see #addOnAccountsUpdatedListener
 * @see #ACTION_ACCOUNT_REMOVED
 *
 * @deprecated use {@link #addOnAccountsUpdatedListener} to get account updates in runtime.
 * @apiSince 5
 * @deprecatedSince 26
 */

@Deprecated public static final java.lang.String LOGIN_ACCOUNTS_CHANGED_ACTION = "android.accounts.LOGIN_ACCOUNTS_CHANGED";

/**
 * Key to set default visibility for applications which don't satisfy conditions in
 * {@link #PACKAGE_NAME_KEY_LEGACY_VISIBLE}. If the value was not set by authenticator
 * {@link #VISIBILITY_USER_MANAGED_NOT_VISIBLE} is used.
 * @apiSince 26
 */

public static final java.lang.String PACKAGE_NAME_KEY_LEGACY_NOT_VISIBLE = "android:accounts:key_legacy_not_visible";

/**
 * Key to set visibility for applications which satisfy one of the following conditions:
 * <ul>
 * <li>Target API level below {@link android.os.Build.VERSION_CODES#O} and have
 * deprecated {@link android.Manifest.permission#GET_ACCOUNTS} permission.
 * </li>
 * <li> Have {@link android.Manifest.permission#GET_ACCOUNTS_PRIVILEGED} permission. </li>
 * <li> Have the same signature as authenticator. </li>
 * <li> Have {@link android.Manifest.permission#READ_CONTACTS} permission and
 * account type may be associated with contacts data - (verified by
 * {@link android.Manifest.permission#WRITE_CONTACTS} permission check for the authenticator).
 * </li>
 * </ul>
 * See {@link #getAccountVisibility}. If the value was not set by authenticator
 * {@link #VISIBILITY_USER_MANAGED_VISIBLE} is used.
 * @apiSince 26
 */

public static final java.lang.String PACKAGE_NAME_KEY_LEGACY_VISIBLE = "android:accounts:key_legacy_visible";

/**
 * Account is not visible to given application and only authenticator can grant visibility.
 * @apiSince 26
 */

public static final int VISIBILITY_NOT_VISIBLE = 3; // 0x3

/**
 * Account visibility was not set. Default visibility value will be used.
 * See {@link #PACKAGE_NAME_KEY_LEGACY_VISIBLE}, {@link #PACKAGE_NAME_KEY_LEGACY_NOT_VISIBLE}
 * @apiSince 26
 */

public static final int VISIBILITY_UNDEFINED = 0; // 0x0

/**
 * Account is not visible to given application, but user can reveal it, for example, using
 * {@link #newChooseAccountIntent(android.accounts.Account,java.util.List,java.lang.String[],java.lang.String,java.lang.String,java.lang.String[],android.os.Bundle)}
 * @apiSince 26
 */

public static final int VISIBILITY_USER_MANAGED_NOT_VISIBLE = 4; // 0x4

/**
 * Account is visible to given application, but user can revoke visibility.
 * @apiSince 26
 */

public static final int VISIBILITY_USER_MANAGED_VISIBLE = 2; // 0x2

/**
 * Account is always visible to given application and only authenticator can revoke visibility.
 * @apiSince 26
 */

public static final int VISIBILITY_VISIBLE = 1; // 0x1
}

