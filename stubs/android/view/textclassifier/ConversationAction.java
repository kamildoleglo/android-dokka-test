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

package android.view.textclassifier;

import android.app.RemoteAction;

/**
 * Represents the action suggested by a {@link android.view.textclassifier.TextClassifier TextClassifier} on a given conversation.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ConversationAction implements android.os.Parcelable {

private ConversationAction() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of this action, for example, {@link #TYPE_VIEW_CALENDAR}.
 * @return This value will never be {@code null}.
 
 * Value is {@link android.view.textclassifier.ConversationAction#TYPE_VIEW_CALENDAR}, {@link android.view.textclassifier.ConversationAction#TYPE_VIEW_MAP}, {@link android.view.textclassifier.ConversationAction#TYPE_TRACK_FLIGHT}, {@link android.view.textclassifier.ConversationAction#TYPE_OPEN_URL}, {@link android.view.textclassifier.ConversationAction#TYPE_SEND_SMS}, {@link android.view.textclassifier.ConversationAction#TYPE_CALL_PHONE}, {@link android.view.textclassifier.ConversationAction#TYPE_SEND_EMAIL}, {@link android.view.textclassifier.ConversationAction#TYPE_TEXT_REPLY}, {@link android.view.textclassifier.ConversationAction#TYPE_CREATE_REMINDER}, or {@link android.view.textclassifier.ConversationAction#TYPE_SHARE_LOCATION}
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns a RemoteAction object, which contains the icon, label and a PendingIntent, for
 * the specified action type.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.app.RemoteAction getAction() { throw new RuntimeException("Stub!"); }

/**
 * Returns the confidence score for the specified action. The value ranges from 0 (low
 * confidence) to 1 (high confidence).
 
 * @return Value is between 0 and 1 inclusive
 * @apiSince 29
 */

public float getConfidenceScore() { throw new RuntimeException("Stub!"); }

/**
 * Returns the text reply that could be sent as a reply to the given conversation.
 * <p>
 * This is only available when the type of the action is {@link #TYPE_TEXT_REPLY}.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getTextReply() { throw new RuntimeException("Stub!"); }

/**
 * Returns the extended data related to this conversation action.
 *
 * <p><b>NOTE: </b>Do not modify this bundle.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.ConversationAction> CREATOR;
static { CREATOR = null; }

/**
 * Indicates an action to call a phone number.
 * @apiSince 29
 */

public static final java.lang.String TYPE_CALL_PHONE = "call_phone";

/**
 * Indicates an action to create a reminder.
 * @apiSince 29
 */

public static final java.lang.String TYPE_CREATE_REMINDER = "create_reminder";

/**
 * Indicates an action to open an URL.
 * @apiSince 29
 */

public static final java.lang.String TYPE_OPEN_URL = "open_url";

/**
 * Indicates an action to send an email.
 * @apiSince 29
 */

public static final java.lang.String TYPE_SEND_EMAIL = "send_email";

/**
 * Indicates an action to send a SMS.
 * @apiSince 29
 */

public static final java.lang.String TYPE_SEND_SMS = "send_sms";

/**
 * Indicates an action to reply with a location.
 * @apiSince 29
 */

public static final java.lang.String TYPE_SHARE_LOCATION = "share_location";

/**
 * Indicates an action to reply with a text message.
 * @apiSince 29
 */

public static final java.lang.String TYPE_TEXT_REPLY = "text_reply";

/**
 * Indicates an action to track a flight.
 * @apiSince 29
 */

public static final java.lang.String TYPE_TRACK_FLIGHT = "track_flight";

/**
 * Indicates an action to view a calendar at a specified time.
 * @apiSince 29
 */

public static final java.lang.String TYPE_VIEW_CALENDAR = "view_calendar";

/**
 * Indicates an action to view the map at a specified location.
 * @apiSince 29
 */

public static final java.lang.String TYPE_VIEW_MAP = "view_map";
/**
 * Builder class to construct {@link android.view.textclassifier.ConversationAction ConversationAction}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * @param actionType This value must never be {@code null}.
 
 * Value is {@link android.view.textclassifier.ConversationAction#TYPE_VIEW_CALENDAR}, {@link android.view.textclassifier.ConversationAction#TYPE_VIEW_MAP}, {@link android.view.textclassifier.ConversationAction#TYPE_TRACK_FLIGHT}, {@link android.view.textclassifier.ConversationAction#TYPE_OPEN_URL}, {@link android.view.textclassifier.ConversationAction#TYPE_SEND_SMS}, {@link android.view.textclassifier.ConversationAction#TYPE_CALL_PHONE}, {@link android.view.textclassifier.ConversationAction#TYPE_SEND_EMAIL}, {@link android.view.textclassifier.ConversationAction#TYPE_TEXT_REPLY}, {@link android.view.textclassifier.ConversationAction#TYPE_CREATE_REMINDER}, or {@link android.view.textclassifier.ConversationAction#TYPE_SHARE_LOCATION}
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull java.lang.String actionType) { throw new RuntimeException("Stub!"); }

/**
 * Sets an action that may be performed on the given conversation.
 
 * @param action This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.ConversationAction.Builder setAction(@androidx.annotation.Nullable android.app.RemoteAction action) { throw new RuntimeException("Stub!"); }

/**
 * Sets a text reply that may be performed on the given conversation.
 
 * @param textReply This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.ConversationAction.Builder setTextReply(@androidx.annotation.Nullable java.lang.CharSequence textReply) { throw new RuntimeException("Stub!"); }

/**
 * Sets the confident score.
 * @param score Value is between 0 and 1 inclusive
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.ConversationAction.Builder setConfidenceScore(float score) { throw new RuntimeException("Stub!"); }

/**
 * Sets the extended data for the conversation action object.
 
 * @param extras This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.ConversationAction.Builder setExtras(@androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Builds the {@link android.view.textclassifier.ConversationAction ConversationAction} object.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.ConversationAction build() { throw new RuntimeException("Stub!"); }
}

}

