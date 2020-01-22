/*
 * Copyright (C) 2006 The Android Open Source Project
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

import android.os.Handler;
import android.os.UserHandle;
import android.os.Parcel;
import android.os.Bundle;

/**
 * A description of an Intent and target action to perform with it.
 * The returned object can be
 * handed to other applications so that they can perform the action you
 * described on your behalf at a later time.
 *
 * <p>By giving a IntentSender to another application,
 * you are granting it the right to perform the operation you have specified
 * as if the other application was yourself (with the same permissions and
 * identity).  As such, you should be careful about how you build the IntentSender:
 * often, for example, the base Intent you supply will have the component
 * name explicitly set to one of your own components, to ensure it is ultimately
 * sent there and nowhere else.
 *
 * <p>A IntentSender itself is simply a reference to a token maintained by
 * the system describing the original data used to retrieve it.  This means
 * that, even if its owning application's process is killed, the
 * IntentSender itself will remain usable from other processes that
 * have been given it.  If the creating application later re-retrieves the
 * same kind of IntentSender (same operation, same Intent action, data,
 * categories, and components, and same flags), it will receive a IntentSender
 * representing the same token if that is still valid.
 *
 * <p>Instances of this class can not be made directly, but rather must be
 * created from an existing {@link android.app.PendingIntent} with
 * {@link android.app.PendingIntent#getIntentSender() PendingIntent.getIntentSender()}.
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class IntentSender implements android.os.Parcelable {

IntentSender() { throw new RuntimeException("Stub!"); }

/**
 * Perform the operation associated with this IntentSender, allowing the
 * caller to specify information about the Intent to use and be notified
 * when the send has completed.
 *
 * @param context The Context of the caller.  This may be null if
 * <var>intent</var> is also null.
 * @param code Result code to supply back to the IntentSender's target.
 * @param intent Additional Intent data.  See {@link android.content.Intent#fillIn Intent#fillIn} for information on how this is applied to the
 * original Intent.  Use null to not modify the original Intent.
 * @param onFinished The object to call back on when the send has
 * completed, or null for no callback.
 * @param handler Handler identifying the thread on which the callback
 * should happen.  If null, the callback will happen from the thread
 * pool of the process.
 *
 *
 * @throws android.content.IntentSender.SendIntentException Throws CanceledIntentException if the IntentSender
 * is no longer allowing more intents to be sent through it.
 * @apiSince 4
 */

public void sendIntent(android.content.Context context, int code, android.content.Intent intent, android.content.IntentSender.OnFinished onFinished, android.os.Handler handler) throws android.content.IntentSender.SendIntentException { throw new RuntimeException("Stub!"); }

/**
 * Perform the operation associated with this IntentSender, allowing the
 * caller to specify information about the Intent to use and be notified
 * when the send has completed.
 *
 * @param context The Context of the caller.  This may be null if
 * <var>intent</var> is also null.
 * @param code Result code to supply back to the IntentSender's target.
 * @param intent Additional Intent data.  See {@link android.content.Intent#fillIn Intent#fillIn} for information on how this is applied to the
 * original Intent.  Use null to not modify the original Intent.
 * @param onFinished The object to call back on when the send has
 * completed, or null for no callback.
 * @param handler Handler identifying the thread on which the callback
 * should happen.  If null, the callback will happen from the thread
 * pool of the process.
 * @param requiredPermission Name of permission that a recipient of the PendingIntent
 * is required to hold.  This is only valid for broadcast intents, and
 * corresponds to the permission argument in
 * {@link android.content.Context#sendBroadcast(android.content.Intent,java.lang.String) Context#sendBroadcast(Intent, String)}.
 * If null, no permission is required.
 *
 *
 * @throws android.content.IntentSender.SendIntentException Throws CanceledIntentException if the IntentSender
 * is no longer allowing more intents to be sent through it.
 * @apiSince 14
 */

public void sendIntent(android.content.Context context, int code, android.content.Intent intent, android.content.IntentSender.OnFinished onFinished, android.os.Handler handler, java.lang.String requiredPermission) throws android.content.IntentSender.SendIntentException { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Renamed to {@link #getCreatorPackage()}.
 * @apiSince 9
 * @deprecatedSince 17
 */

@Deprecated
public java.lang.String getTargetPackage() { throw new RuntimeException("Stub!"); }

/**
 * Return the package name of the application that created this
 * IntentSender, that is the identity under which you will actually be
 * sending the Intent.  The returned string is supplied by the system, so
 * that an application can not spoof its package.
 *
 * @return The package name of the PendingIntent, or null if there is
 * none associated with it.
 * @apiSince 17
 */

public java.lang.String getCreatorPackage() { throw new RuntimeException("Stub!"); }

/**
 * Return the uid of the application that created this
 * PendingIntent, that is the identity under which you will actually be
 * sending the Intent.  The returned integer is supplied by the system, so
 * that an application can not spoof its uid.
 *
 * @return The uid of the PendingIntent, or -1 if there is
 * none associated with it.
 * @apiSince 17
 */

public int getCreatorUid() { throw new RuntimeException("Stub!"); }

/**
 * Return the user handle of the application that created this
 * PendingIntent, that is the user under which you will actually be
 * sending the Intent.  The returned UserHandle is supplied by the system, so
 * that an application can not spoof its user.  See
 * {@link android.os.Process#myUserHandle() Process.myUserHandle()} for
 * more explanation of user handles.
 *
 * @return The user handle of the PendingIntent, or null if there is
 * none associated with it.
 * @apiSince 17
 */

public android.os.UserHandle getCreatorUserHandle() { throw new RuntimeException("Stub!"); }

/**
 * Comparison operator on two IntentSender objects, such that true
 * is returned then they both represent the same operation from the
 * same package.
 * @apiSince 4
 */

public boolean equals(java.lang.Object otherObj) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for writing either a IntentSender or null pointer to
 * a Parcel.  You must use this with {@link #readIntentSenderOrNullFromParcel}
 * for later reading it.
 *
 * @param sender The IntentSender to write, or null.
 * @param out Where to write the IntentSender.
 * @apiSince 4
 */

public static void writeIntentSenderOrNullToParcel(android.content.IntentSender sender, android.os.Parcel out) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for reading either a Messenger or null pointer from
 * a Parcel.  You must have previously written the Messenger with
 * {@link #writeIntentSenderOrNullToParcel}.
 *
 * @param in The Parcel containing the written Messenger.
 *
 * @return Returns the Messenger read from the Parcel, or null if null had
 * been written.
 * @apiSince 4
 */

public static android.content.IntentSender readIntentSenderOrNullFromParcel(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.IntentSender> CREATOR;
static { CREATOR = null; }
/**
 * Callback interface for discovering when a send operation has
 * completed.  Primarily for use with a IntentSender that is
 * performing a broadcast, this provides the same information as
 * calling {@link android.content.Context#sendOrderedBroadcast(android.content.Intent,java.lang.String,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle) Context#sendOrderedBroadcast(Intent, String,
 * android.content.BroadcastReceiver, Handler, int, String, Bundle)} with a final BroadcastReceiver.
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnFinished {

/**
 * Called when a send operation as completed.
 *
 * @param IntentSender The IntentSender this operation was sent through.
 * @param intent The original Intent that was sent.
 * @param resultCode The final result code determined by the send.
 * @param resultData The final data collected by a broadcast.
 * @param resultExtras The final extras collected by a broadcast.
 * @apiSince 4
 */

public void onSendFinished(android.content.IntentSender IntentSender, android.content.Intent intent, int resultCode, java.lang.String resultData, android.os.Bundle resultExtras);
}

/**
 * Exception thrown when trying to send through a PendingIntent that
 * has been canceled or is otherwise no longer able to execute the request.
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class SendIntentException extends android.util.AndroidException {

/** @apiSince 4 */

public SendIntentException() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public SendIntentException(java.lang.String name) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public SendIntentException(java.lang.Exception cause) { throw new RuntimeException("Stub!"); }
}

}

