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


/**
 * Object used to communicate responses back to the AccountManager
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AccountAuthenticatorResponse implements android.os.Parcelable {

/** @apiSince 5 */

public AccountAuthenticatorResponse(android.os.Parcel parcel) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void onResult(android.os.Bundle result) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void onRequestContinued() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void onError(int errorCode, java.lang.String errorMessage) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.accounts.AccountAuthenticatorResponse> CREATOR;
static { CREATOR = null; }
}

