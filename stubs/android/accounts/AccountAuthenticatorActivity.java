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
import android.app.Activity;

/**
 * Base class for implementing an Activity that is used to help implement an
 * AbstractAccountAuthenticator. If the AbstractAccountAuthenticator needs to use an activity
 * to handle the request then it can have the activity extend AccountAuthenticatorActivity.
 * The AbstractAccountAuthenticator passes in the response to the intent using the following:
 * <pre>
 *      intent.putExtra({@link android.accounts.AccountManager#KEY_ACCOUNT_AUTHENTICATOR_RESPONSE AccountManager#KEY_ACCOUNT_AUTHENTICATOR_RESPONSE}, response);
 * </pre>
 * The activity then sets the result that is to be handed to the response via
 * {@link #setAccountAuthenticatorResult(android.os.Bundle)}.
 * This result will be sent as the result of the request when the activity finishes. If this
 * is never set or if it is set to null then error {@link android.accounts.AccountManager#ERROR_CODE_CANCELED AccountManager#ERROR_CODE_CANCELED}
 * will be called on the response.
 *
 * @deprecated Applications should extend Activity themselves. This class is not compatible with
 *   AppCompat, and the functionality it provides is not complex.
 * @apiSince 5
 * @deprecatedSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class AccountAuthenticatorActivity extends android.app.Activity {

@Deprecated
public AccountAuthenticatorActivity() { throw new RuntimeException("Stub!"); }

/**
 * Set the result that is to be sent as the result of the request that caused this
 * Activity to be launched. If result is null or this method is never called then
 * the request will be canceled.
 * @param result this is returned as the result of the AbstractAccountAuthenticator request
 * @apiSince 5
 * @deprecatedSince R
 */

@Deprecated
public final void setAccountAuthenticatorResult(android.os.Bundle result) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the AccountAuthenticatorResponse from either the intent of the icicle, if the
 * icicle is non-zero.
 * @param icicle the save instance data of this Activity, may be null
 * @apiSince 5
 * @deprecatedSince R
 */

@Deprecated
protected void onCreate(android.os.Bundle icicle) { throw new RuntimeException("Stub!"); }

/**
 * Sends the result or a Constants.ERROR_CODE_CANCELED error if a result isn't present.
 * @apiSince 5
 * @deprecatedSince R
 */

@Deprecated
public void finish() { throw new RuntimeException("Stub!"); }
}

