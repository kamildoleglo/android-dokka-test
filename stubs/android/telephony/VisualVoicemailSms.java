/*
 * Copyright (C) 2016 The Android Open Source Project
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


package android.telephony;

import android.telephony.VisualVoicemailService.VisualVoicemailTask;
import android.telecom.PhoneAccountHandle;

/**
 * Represents the content of a visual voicemail SMS. If a incoming SMS matches the {@link android.telephony.VisualVoicemailSmsFilterSettings VisualVoicemailSmsFilterSettings} set by the default dialer, {@link android.telephony.VisualVoicemailService#onSmsReceived(android.telephony.VisualVoicemailService.VisualVoicemailTask,android.telephony.VisualVoicemailSms) VisualVoicemailService#onSmsReceived(VisualVoicemailTask, VisualVoicemailSms)} will be called.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class VisualVoicemailSms implements android.os.Parcelable {

VisualVoicemailSms() { throw new RuntimeException("Stub!"); }

/**
 * The {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} that received the SMS.
 * @apiSince 26
 */

public android.telecom.PhoneAccountHandle getPhoneAccountHandle() { throw new RuntimeException("Stub!"); }

/**
 * The event type of the SMS or {@code null} if the framework cannot parse the SMS as voicemail
 * but the carrier pattern indicates it is. Common values are "SYNC" or "STATUS".
 * @apiSince 26
 */

public java.lang.String getPrefix() { throw new RuntimeException("Stub!"); }

/**
 * The key-value pairs sent by the SMS, or {@code null} if the framework cannot parse the SMS as
 * voicemail but the carrier pattern indicates it is. The interpretation of the fields is
 * carrier dependent.
 * @apiSince 26
 */

public android.os.Bundle getFields() { throw new RuntimeException("Stub!"); }

/**
 * Raw message body of the received SMS.
 * @apiSince 26
 */

public java.lang.String getMessageBody() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.VisualVoicemailSms> CREATOR;
static { CREATOR = null; }
}

