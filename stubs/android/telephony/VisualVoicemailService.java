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

import android.telecom.TelecomManager;
import android.telecom.PhoneAccountHandle;
import android.content.Intent;

/**
 * This service is implemented by dialer apps that wishes to handle OMTP or similar visual
 * voicemails. Telephony binds to this service when the cell service is first connected, a visual
 * voicemail SMS has been received, or when a SIM has been removed. Telephony will only bind to the
 * default dialer for such events (See {@link android.telecom.TelecomManager#getDefaultDialerPackage() TelecomManager#getDefaultDialerPackage()}). The
 * {@link android.service.carrier.CarrierMessagingService} precedes the VisualVoicemailService in
 * the SMS filtering chain and may intercept the visual voicemail SMS before it reaches this
 * service.
 * <p>
 * To extend this class, The service must be declared in the manifest file with
 * the {@link android.Manifest.permission#BIND_VISUAL_VOICEMAIL_SERVICE} permission and include an
 * intent filter with the {@link #SERVICE_INTERFACE} action.
 * <p>
 * Below is an example manifest registration for a {@code VisualVoicemailService}.
 * <pre>
 * {@code
 * <service android:name="your.package.YourVisualVoicemailServiceImplementation"
 *          android:permission="android.permission.BIND_VISUAL_VOICEMAIL_SERVICE">
 *      <intent-filter>
 *          <action android:name="android.telephony.VisualVoicemailService"/>
 *      </intent-filter>
 * </service>
 * }
 * </pre>
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class VisualVoicemailService extends android.app.Service {

public VisualVoicemailService() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called when the cellular service is connected on a {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} for the first
 * time, or when the carrier config has changed. It will not be called when the signal is lost
 * then restored.
 *
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * @param task The task representing this event. {@link android.telephony.VisualVoicemailService.VisualVoicemailTask#finish() VisualVoicemailTask#finish()} must be
 * called when the task is completed.
 * @param phoneAccountHandle The {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} triggering this event.
 * @apiSince 26
 */

public abstract void onCellServiceConnected(android.telephony.VisualVoicemailService.VisualVoicemailTask task, android.telecom.PhoneAccountHandle phoneAccountHandle);

/**
 * Called when a SMS matching the {@link android.telephony.VisualVoicemailSmsFilterSettings VisualVoicemailSmsFilterSettings} set by
 * {@link android.telephony.TelephonyManager#setVisualVoicemailSmsFilterSettings(android.telephony.VisualVoicemailSmsFilterSettings) TelephonyManager#setVisualVoicemailSmsFilterSettings(VisualVoicemailSmsFilterSettings)}
 * is received.
 *
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * @param task The task representing this event. {@link android.telephony.VisualVoicemailService.VisualVoicemailTask#finish() VisualVoicemailTask#finish()} must be
 * called when the task is completed.
 * @param sms The content of the received SMS.
 * @apiSince 26
 */

public abstract void onSmsReceived(android.telephony.VisualVoicemailService.VisualVoicemailTask task, android.telephony.VisualVoicemailSms sms);

/**
 * Called when a SIM is removed.
 *
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * @param task The task representing this event. {@link android.telephony.VisualVoicemailService.VisualVoicemailTask#finish() VisualVoicemailTask#finish()} must be
 * called when the task is completed.
 * @param phoneAccountHandle The {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} triggering this event.
 * @apiSince 26
 */

public abstract void onSimRemoved(android.telephony.VisualVoicemailService.VisualVoicemailTask task, android.telecom.PhoneAccountHandle phoneAccountHandle);

/**
 * Called before the system is about to terminate a task. The service should persist any
 * necessary data and call finish on the task immediately.
 
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * @apiSince 26
 */

public abstract void onStopped(android.telephony.VisualVoicemailService.VisualVoicemailTask task);

/**
 * The {@link android.content.Intent Intent} that must be declared as handled by the service.
 * @apiSince 26
 */

public static final java.lang.String SERVICE_INTERFACE = "android.telephony.VisualVoicemailService";
/**
 * Represents a visual voicemail event which needs to be handled. While the task is being
 * processed telephony will hold a wakelock for the VisualVoicemailService. The service can
 * unblock the main thread and pass the task to a worker thread. Once the task is finished,
 * {@link android.telephony.VisualVoicemailService.VisualVoicemailTask#finish() VisualVoicemailTask#finish()} should be called to signal telephony to release the
 * resources. Telephony will call {@link android.telephony.VisualVoicemailService#onStopped(android.telephony.VisualVoicemailService.VisualVoicemailTask) VisualVoicemailService#onStopped(VisualVoicemailTask)}
 * when the task is going to be terminated before completion.
 *
 * @see #onCellServiceConnected(VisualVoicemailTask, PhoneAccountHandle)
 * @see #onSmsReceived(VisualVoicemailTask, VisualVoicemailSms)
 * @see #onSimRemoved(VisualVoicemailTask, PhoneAccountHandle)
 * @see #onStopped(VisualVoicemailTask)
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class VisualVoicemailTask {

private VisualVoicemailTask() { throw new RuntimeException("Stub!"); }

/**
 * Call to signal telephony the task has completed. Must be called for every task.
 * @apiSince 26
 */

public final void finish() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

}

