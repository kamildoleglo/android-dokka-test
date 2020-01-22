/*
 * Copyright (C) 2017 The Android Open Source Project
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

package android.telephony.euicc;

import android.app.PendingIntent;

/**
 * Information about a subscription which is downloadable to an eUICC using
 * {@link android.telephony.euicc.EuiccManager#downloadSubscription(android.telephony.euicc.DownloadableSubscription,boolean,android.app.PendingIntent) EuiccManager#downloadSubscription(DownloadableSubscription, boolean, PendingIntent)}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DownloadableSubscription implements android.os.Parcelable {

private DownloadableSubscription() { throw new RuntimeException("Stub!"); }

/**
 * Gets the activation code.
 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getEncodedActivationCode() { throw new RuntimeException("Stub!"); }

/**
 * Create a DownloadableSubscription for the given activation code.
 *
 * <p>This fills the encodedActivationCode field. Other fields like confirmationCode,
 * carrierName and accessRules may be filled in the implementation of
 * {@code android.service.euicc.EuiccService} if exists.
 *
 * @param encodedActivationCode the activation code to use. An activation code can be parsed
 *         from a user scanned QR code. The format of activation code is defined in SGP.22. For
 *         example, "1$SMDP.GSMA.COM$04386-AGYFT-A74Y8-3F815$1.3.6.1.4.1.31746". For detail, see
 *         {@code com.android.euicc.data.ActivationCode}. Must not be null.
 *
 * @return the {@link android.telephony.euicc.DownloadableSubscription DownloadableSubscription} which may be passed to
 *     {@link android.telephony.euicc.EuiccManager#downloadSubscription EuiccManager#downloadSubscription}.
 * @apiSince 28
 */

public static android.telephony.euicc.DownloadableSubscription forActivationCode(java.lang.String encodedActivationCode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the confirmation code.
 *
 * <p>As an example, the confirmation code can be input by the user through a carrier app or the
 * UI component of the eUICC local profile assistant (LPA) application.
 
 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getConfirmationCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.euicc.DownloadableSubscription> CREATOR;
static { CREATOR = null; }
}

