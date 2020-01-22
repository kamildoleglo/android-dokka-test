/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.telecom;


/** @apiSince 29 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PhoneAccountSuggestion implements android.os.Parcelable {

/**
 * Creates a new instance of {@link android.telecom.PhoneAccountSuggestion PhoneAccountSuggestion}. This constructor is intended for
 * use by apps implementing a {@link android.telecom.PhoneAccountSuggestionService PhoneAccountSuggestionService}, and generally should not be
 * used by dialer apps other than for testing purposes.
 *
 * @param handle The {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} for this suggestion.
 * This value must never be {@code null}.
 * @param reason The reason for this suggestion
 * Value is {@link android.telecom.PhoneAccountSuggestion#REASON_NONE}, {@link android.telecom.PhoneAccountSuggestion#REASON_INTRA_CARRIER}, {@link android.telecom.PhoneAccountSuggestion#REASON_FREQUENT}, {@link android.telecom.PhoneAccountSuggestion#REASON_USER_SET}, or {@link android.telecom.PhoneAccountSuggestion#REASON_OTHER}
 * @param shouldAutoSelect Whether the dialer should automatically place the call using this
 *                         account. See {@link #shouldAutoSelect()}.
 * @apiSince 29
 */

public PhoneAccountSuggestion(@androidx.annotation.NonNull android.telecom.PhoneAccountHandle handle, int reason, boolean shouldAutoSelect) { throw new RuntimeException("Stub!"); }

/**
 * @return The {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} for this suggestion.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.telecom.PhoneAccountHandle getPhoneAccountHandle() { throw new RuntimeException("Stub!"); }

/**
 * @return The reason for this suggestion
 
 * Value is {@link android.telecom.PhoneAccountSuggestion#REASON_NONE}, {@link android.telecom.PhoneAccountSuggestion#REASON_INTRA_CARRIER}, {@link android.telecom.PhoneAccountSuggestion#REASON_FREQUENT}, {@link android.telecom.PhoneAccountSuggestion#REASON_USER_SET}, or {@link android.telecom.PhoneAccountSuggestion#REASON_OTHER}
 * @apiSince 29
 */

public int getReason() { throw new RuntimeException("Stub!"); }

/**
 * Suggests whether the dialer should automatically place the call using this account without
 * user interaction. This may be set on multiple {@link android.telecom.PhoneAccountSuggestion PhoneAccountSuggestion}s, and the dialer
 * is free to choose which one to use.
 * @return {@code true} if the hint is to auto-select, {@code false} otherwise.
 * @apiSince 29
 */

public boolean shouldAutoSelect() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telecom.PhoneAccountSuggestion> CREATOR;
static { CREATOR = null; }

/**
 * Indicates that the {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} is suggested because the user uses it
 * frequently for the number that we are calling.
 * @apiSince 29
 */

public static final int REASON_FREQUENT = 2; // 0x2

/**
 * Indicates that the {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} is suggested because the number we're calling
 * is on the same carrier, and therefore may have lower rates.
 * @apiSince 29
 */

public static final int REASON_INTRA_CARRIER = 1; // 0x1

/**
 * Indicates that this account is not suggested for use, but is still available.
 * @apiSince 29
 */

public static final int REASON_NONE = 0; // 0x0

/**
 * Indicates that the {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} is suggested for a reason not otherwise
 * enumerated here.
 * @apiSince 29
 */

public static final int REASON_OTHER = 4; // 0x4

/**
 * Indicates that the {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} is suggested because the user explicitly
 * specified that it be used for the number we are calling.
 * @apiSince 29
 */

public static final int REASON_USER_SET = 3; // 0x3
}

