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

/**
 * Class to represent various settings for the visual voicemail SMS filter. When the filter is
 * enabled, incoming SMS matching the generalized OMTP format:
 *
 * <p>[clientPrefix]:[prefix]:([key]=[value];)*
 *
 * <p>will be regarded as a visual voicemail SMS, and removed before reaching the SMS provider. The
 * {@link android.telephony.VisualVoicemailService VisualVoicemailService} in the current default dialer will be bound and
 * {@link android.telephony.VisualVoicemailService#onSmsReceived(android.telephony.VisualVoicemailService.VisualVoicemailTask,android.telephony.VisualVoicemailSms) VisualVoicemailService#onSmsReceived(VisualVoicemailTask, VisualVoicemailSms)}
 * will called with the information extracted from the SMS.
 *
 * <p>Use {@link android.telephony.VisualVoicemailSmsFilterSettings.Builder} to construct this
 * class.
 *
 * @see android.telephony.TelephonyManager#setVisualVoicemailSmsFilterSettings(VisualVoicemailSmsFilterSettings)
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class VisualVoicemailSmsFilterSettings implements android.os.Parcelable {

private VisualVoicemailSmsFilterSettings() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.VisualVoicemailSmsFilterSettings> CREATOR;
static { CREATOR = null; }

/**
 * The visual voicemail SMS message does not have to be a data SMS, and can be directed to any
 * port.
 * @apiSince 26
 */

public static final int DESTINATION_PORT_ANY = -1; // 0xffffffff

/**
 * The visual voicemail SMS message can be directed to any port, but must be a data SMS.
 * @apiSince 26
 */

public static final int DESTINATION_PORT_DATA_SMS = -2; // 0xfffffffe

/**
 * The client prefix for the visual voicemail SMS filter. The client prefix will appear at the
 * start of a visual voicemail SMS message, followed by a colon(:).
 * @apiSince 26
 */

public final java.lang.String clientPrefix;
{ clientPrefix = null; }

/**
 * The destination port for the visual voicemail SMS filter, or {@link #DESTINATION_PORT_ANY},
 * or {@link #DESTINATION_PORT_DATA_SMS}
 * @apiSince 26
 */

public final int destinationPort;
{ destinationPort = 0; }

/**
 * The originating number whitelist for the visual voicemail SMS filter of a phone account. If
 * the list is not null only the SMS messages from a number in the list can be considered as a
 * visual voicemail SMS. Otherwise, messages from any address will be considered.
 * @apiSince 26
 */

public final java.util.List<java.lang.String> originatingNumbers;
{ originatingNumbers = null; }
/**
 * Builder class for {@link android.telephony.VisualVoicemailSmsFilterSettings VisualVoicemailSmsFilterSettings} objects.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public android.telephony.VisualVoicemailSmsFilterSettings build() { throw new RuntimeException("Stub!"); }

/**
 * Sets the client prefix for the visual voicemail SMS filter. The client prefix will appear
 * at the start of a visual voicemail SMS message, followed by a colon(:).
 * @apiSince 26
 */

public android.telephony.VisualVoicemailSmsFilterSettings.Builder setClientPrefix(java.lang.String clientPrefix) { throw new RuntimeException("Stub!"); }

/**
 * Sets the originating number whitelist for the visual voicemail SMS filter. If the list is
 * not null only the SMS messages from a number in the list can be considered as a visual
 * voicemail SMS. Otherwise, messages from any address will be considered.
 * @apiSince 26
 */

public android.telephony.VisualVoicemailSmsFilterSettings.Builder setOriginatingNumbers(java.util.List<java.lang.String> originatingNumbers) { throw new RuntimeException("Stub!"); }

/**
 * Sets the destination port for the visual voicemail SMS filter.
 *
 * @param destinationPort The destination port, or {@link #DESTINATION_PORT_ANY}, or {@link
 * #DESTINATION_PORT_DATA_SMS}
 * @apiSince 26
 */

public android.telephony.VisualVoicemailSmsFilterSettings.Builder setDestinationPort(int destinationPort) { throw new RuntimeException("Stub!"); }
}

}

