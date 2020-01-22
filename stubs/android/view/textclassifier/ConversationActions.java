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

import android.app.Person;

/**
 * Represents a list of actions suggested by a {@link android.view.textclassifier.TextClassifier TextClassifier} on a given conversation.
 *
 * @see android.view.textclassifier.TextClassifier#suggestConversationActions(Request)
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ConversationActions implements android.os.Parcelable {

/**
 * Constructs a {@link android.view.textclassifier.ConversationActions ConversationActions} object.
 * @param conversationActions This value must never be {@code null}.
 
 * @param id This value may be {@code null}.
 * @apiSince 29
 */

public ConversationActions(@androidx.annotation.NonNull java.util.List<android.view.textclassifier.ConversationAction> conversationActions, @androidx.annotation.Nullable java.lang.String id) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns an immutable list of {@link android.view.textclassifier.ConversationAction ConversationAction} objects, which are ordered from high
 * confidence to low confidence.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.view.textclassifier.ConversationAction> getConversationActions() { throw new RuntimeException("Stub!"); }

/**
 * Returns the id, if one exists, for this object.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.ConversationActions> CREATOR;
static { CREATOR = null; }
/**
 * Represents a message in the conversation.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Message implements android.os.Parcelable {

private Message() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Returns the person that composed the message.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.Person getAuthor() { throw new RuntimeException("Stub!"); }

/**
 * Returns the reference time of the message, for example it could be the compose or send
 * time of this message.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.time.ZonedDateTime getReferenceTime() { throw new RuntimeException("Stub!"); }

/**
 * Returns the text of the message.
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getText() { throw new RuntimeException("Stub!"); }

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

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.ConversationActions.Message> CREATOR;
static { CREATOR = null; }

/**
 * Represents the remote user.
 * <p>
 * If possible, you are suggested to create a {@link android.app.Person Person} object that can identify
 * the remote user better, so that the underlying model could differentiate between
 * different remote users.
 *
 * @see android.view.textclassifier.ConversationActions.Message.Builder#Builder(Person)
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.app.Person PERSON_USER_OTHERS;
static { PERSON_USER_OTHERS = null; }

/**
 * Represents the local user.
 *
 * @see android.view.textclassifier.ConversationActions.Message.Builder#Builder(Person)
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.app.Person PERSON_USER_SELF;
static { PERSON_USER_SELF = null; }
/**
 * Builder class to construct a {@link android.view.textclassifier.ConversationActions.Message Message}
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Constructs a builder.
 *
 * @param author the person that composed the message, use {@link #PERSON_USER_SELF}
 *               to represent the local user. If it is not possible to identify the
 *               remote user that the local user is conversing with, use
 *               {@link #PERSON_USER_OTHERS} to represent a remote user.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull android.app.Person author) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text of this message.
 * @param text This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.ConversationActions.Message.Builder setText(@androidx.annotation.Nullable java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Sets the reference time of this message, for example it could be the compose or send
 * time of this message.
 
 * @param referenceTime This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.ConversationActions.Message.Builder setReferenceTime(@androidx.annotation.Nullable java.time.ZonedDateTime referenceTime) { throw new RuntimeException("Stub!"); }

/**
 * Sets a set of extended data to the message.
 * @param bundle This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.ConversationActions.Message.Builder setExtras(@androidx.annotation.Nullable android.os.Bundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * Builds the {@link android.view.textclassifier.ConversationActions.Message Message} object.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.ConversationActions.Message build() { throw new RuntimeException("Stub!"); }
}

}

/**
 * A request object for generating conversation action suggestions.
 *
 * @see android.view.textclassifier.TextClassifier#suggestConversationActions(Request)
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Request implements android.os.Parcelable {

private Request() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type config.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifier.EntityConfig getTypeConfig() { throw new RuntimeException("Stub!"); }

/**
 * Returns an immutable list of messages that make up the conversation.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.view.textclassifier.ConversationActions.Message> getConversation() { throw new RuntimeException("Stub!"); }

/**
 * Return the maximal number of suggestions the caller wants, value -1 means no restriction
 * and this is the default.
 
 * @return Value is -1 or greater
 * @apiSince 29
 */

public int getMaxSuggestions() { throw new RuntimeException("Stub!"); }

/**
 * Returns an immutable list of hints
 * @return This value will never be {@code null}.
 
 * Value is {@link android.view.textclassifier.ConversationActions.Request#HINT_FOR_NOTIFICATION}, or {@link android.view.textclassifier.ConversationActions.Request#HINT_FOR_IN_APP}
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.String> getHints() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the package that sent this request.
 * This returns {@code null} if no calling package name is set.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getCallingPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the extended data related to this request.
 *
 * <p><b>NOTE: </b>Do not modify this bundle.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.ConversationActions.Request> CREATOR;
static { CREATOR = null; }

/**
 * To indicate the generated actions will be used within the app.
 * @apiSince 29
 */

public static final java.lang.String HINT_FOR_IN_APP = "in_app";

/**
 * To indicate the generated actions will be used for notification.
 * @apiSince 29
 */

public static final java.lang.String HINT_FOR_NOTIFICATION = "notification";
/**
 * Builder object to construct the {@link android.view.textclassifier.ConversationActions.Request Request} object.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Constructs a builder.
 *
 * @param conversation the conversation that the text classifier is going to generate
 *     actions for.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull java.util.List<android.view.textclassifier.ConversationActions.Message> conversation) { throw new RuntimeException("Stub!"); }

/**
 * Sets the hints to help text classifier to generate actions. It could be used to help
 * text classifier to infer what types of actions the caller may be interested in.
 
 * @param hints This value may be {@code null}.
 * Value is {@link android.view.textclassifier.ConversationActions.Request#HINT_FOR_NOTIFICATION}, or {@link android.view.textclassifier.ConversationActions.Request#HINT_FOR_IN_APP}
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.ConversationActions.Request.Builder setHints(@androidx.annotation.Nullable java.util.List<java.lang.String> hints) { throw new RuntimeException("Stub!"); }

/**
 * Sets the type config.
 * @param typeConfig This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.ConversationActions.Request.Builder setTypeConfig(@androidx.annotation.Nullable android.view.textclassifier.TextClassifier.EntityConfig typeConfig) { throw new RuntimeException("Stub!"); }

/**
 * Sets the maximum number of suggestions you want. Value -1 means no restriction and
 * this is the default.
 
 * @param maxSuggestions Value is -1 or greater
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.ConversationActions.Request.Builder setMaxSuggestions(int maxSuggestions) { throw new RuntimeException("Stub!"); }

/**
 * Sets a set of extended data to the request.
 * @param bundle This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.ConversationActions.Request.Builder setExtras(@androidx.annotation.Nullable android.os.Bundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * Builds the {@link android.view.textclassifier.ConversationActions.Request Request} object.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.ConversationActions.Request build() { throw new RuntimeException("Stub!"); }
}

}

}

