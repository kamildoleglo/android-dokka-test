/*
 * Copyright 2018 The Android Open Source Project
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

import android.icu.util.ULocale;

/**
 * This class represents events that are sent by components to the {@link android.view.textclassifier.TextClassifier TextClassifier} to report
 * something of note that relates to a feature powered by the TextClassifier. The TextClassifier may
 * log these events or use them to improve future responses to queries.
 * <p>
 * Each category of events has its their own subclass. Events of each type have an associated
 * set of related properties. You can find their specification in the subclasses.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class TextClassifierEvent implements android.os.Parcelable {

private TextClassifierEvent() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns the event category. e.g. {@link #CATEGORY_SELECTION}.
 
 * @return Value is {@link android.view.textclassifier.TextClassifierEvent#CATEGORY_SELECTION}, {@link android.view.textclassifier.TextClassifierEvent#CATEGORY_LINKIFY}, {@link android.view.textclassifier.TextClassifierEvent#CATEGORY_CONVERSATION_ACTIONS}, or {@link android.view.textclassifier.TextClassifierEvent#CATEGORY_LANGUAGE_DETECTION}
 * @apiSince 29
 */

public int getEventCategory() { throw new RuntimeException("Stub!"); }

/**
 * Returns the event type. e.g. {@link #TYPE_SELECTION_STARTED}.
 
 * @return Value is {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_STARTED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_MODIFIED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SMART_SELECTION_SINGLE}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SMART_SELECTION_MULTI}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_AUTO_SELECTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_ACTIONS_SHOWN}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_LINK_CLICKED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_OVERTYPE}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_COPY_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_PASTE_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_CUT_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SHARE_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SMART_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_DRAG}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_DESTROYED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_OTHER_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECT_ALL}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_RESET}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_MANUAL_REPLY}, or {@link android.view.textclassifier.TextClassifierEvent#TYPE_ACTIONS_GENERATED}
 * @apiSince 29
 */

public int getEventType() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of entity types. e.g. {@link android.view.textclassifier.TextClassifier#TYPE_ADDRESS TextClassifier#TYPE_ADDRESS}.
 *
 * @see android.view.textclassifier.TextClassifierEvent.Builder#setEntityTypes(String...) for supported types.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String[] getEntityTypes() { throw new RuntimeException("Stub!"); }

/**
 * Returns the event context.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.view.textclassifier.TextClassificationContext getEventContext() { throw new RuntimeException("Stub!"); }

/**
 * Returns the id of the text classifier result related to this event.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getResultId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the index of this event in the series of event it belongs to.
 * @apiSince 29
 */

public int getEventIndex() { throw new RuntimeException("Stub!"); }

/**
 * Returns the scores of the suggestions.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public float[] getScores() { throw new RuntimeException("Stub!"); }

/**
 * Returns the model name.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getModelName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the indices of the actions relating to this event.
 * Actions are usually returned by the text classifier in priority order with the most
 * preferred action at index 0. This list gives an indication of the position of the actions
 * that are being reported.
 *
 * @see android.view.textclassifier.TextClassifierEvent.Builder#setActionIndices(int...)
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public int[] getActionIndices() { throw new RuntimeException("Stub!"); }

/**
 * Returns the detected locale.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.icu.util.ULocale getLocale() { throw new RuntimeException("Stub!"); }

/**
 * Returns a bundle containing non-structured extra information about this event.
 *
 * <p><b>NOTE: </b>Do not modify this bundle.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 *  Conversation actions
 *
 * @see android.view.textclassifier.TextClassifierEvent.ConversationActionsEvent
 * @apiSince 29
 */

public static final int CATEGORY_CONVERSATION_ACTIONS = 3; // 0x3

/**
 * Language detection
 *
 * @see android.view.textclassifier.TextClassifierEvent.LanguageDetectionEvent
 * @apiSince 29
 */

public static final int CATEGORY_LANGUAGE_DETECTION = 4; // 0x4

/**
 * Linkify
 *
 * @see android.view.textclassifier.TextClassifierEvent.TextLinkifyEvent
 * @apiSince 29
 */

public static final int CATEGORY_LINKIFY = 2; // 0x2

/**
 * Smart selection
 *
 * @see android.view.textclassifier.TextClassifierEvent.TextSelectionEvent
 * @apiSince 29
 */

public static final int CATEGORY_SELECTION = 1; // 0x1

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.TextClassifierEvent> CREATOR;
static { CREATOR = null; }

/**
 * TextClassifier generated some actions
 * @apiSince 29
 */

public static final int TYPE_ACTIONS_GENERATED = 20; // 0x14

/**
 * Smart actions shown to the user.
 * @apiSince 29
 */

public static final int TYPE_ACTIONS_SHOWN = 6; // 0x6

/**
 * Something else other than user or the default TextClassifier triggered a selection.
 * @apiSince 29
 */

public static final int TYPE_AUTO_SELECTION = 5; // 0x5

/**
 * User clicked on Copy action.
 * @apiSince 29
 */

public static final int TYPE_COPY_ACTION = 9; // 0x9

/**
 * User clicked on Cut action.
 * @apiSince 29
 */

public static final int TYPE_CUT_ACTION = 11; // 0xb

/**
 * User clicked a link.
 * @apiSince 29
 */

public static final int TYPE_LINK_CLICKED = 7; // 0x7

/**
 * User composed a reply.
 * @apiSince 29
 */

public static final int TYPE_MANUAL_REPLY = 19; // 0x13

/**
 * User clicked on a custom action.
 * @apiSince 29
 */

public static final int TYPE_OTHER_ACTION = 16; // 0x10

/**
 * User typed over the selection.
 * @apiSince 29
 */

public static final int TYPE_OVERTYPE = 8; // 0x8

/**
 * User clicked on Paste action.
 * @apiSince 29
 */

public static final int TYPE_PASTE_ACTION = 10; // 0xa

/**
 * Selection is destroyed.
 * @apiSince 29
 */

public static final int TYPE_SELECTION_DESTROYED = 15; // 0xf

/**
 * User dragged+dropped the selection.
 * @apiSince 29
 */

public static final int TYPE_SELECTION_DRAG = 14; // 0xe

/**
 * User modified an existing selection.
 * @apiSince 29
 */

public static final int TYPE_SELECTION_MODIFIED = 2; // 0x2

/**
 * User reset the smart selection.
 * @apiSince 29
 */

public static final int TYPE_SELECTION_RESET = 18; // 0x12

/**
 * User started a new selection.
 * @apiSince 29
 */

public static final int TYPE_SELECTION_STARTED = 1; // 0x1

/**
 * User clicked on Select All action
 * @apiSince 29
 */

public static final int TYPE_SELECT_ALL = 17; // 0x11

/**
 * User clicked on Share action.
 * @apiSince 29
 */

public static final int TYPE_SHARE_ACTION = 12; // 0xc

/**
 * User clicked on a Smart action.
 * @apiSince 29
 */

public static final int TYPE_SMART_ACTION = 13; // 0xd

/**
 * Smart selection triggered spanning multiple tokens (words).
 * @apiSince 29
 */

public static final int TYPE_SMART_SELECTION_MULTI = 4; // 0x4

/**
 * Smart selection triggered for a single token (word).
 * @apiSince 29
 */

public static final int TYPE_SMART_SELECTION_SINGLE = 3; // 0x3
/**
 * Builder to build a text classifier event.
 *
 * @param <T> The subclass to be built.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Builder<T extends android.view.textclassifier.TextClassifierEvent.Builder<T>> {

private Builder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the entity types. e.g. {@link android.view.textclassifier.TextClassifier#TYPE_ADDRESS TextClassifier#TYPE_ADDRESS}.
 * <p>
 * Supported types:
 * <p>See {@link android.view.textclassifier.TextClassifier.EntityType TextClassifier.EntityType}
 * <p>See {@link android.view.textclassifier.ConversationAction.ActionType ConversationAction.ActionType}
 * <p>See {@link android.icu.util.ULocale#toLanguageTag() ULocale#toLanguageTag()}
 
 * @param entityTypes This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public T setEntityTypes(@androidx.annotation.NonNull java.lang.String... entityTypes) { throw new RuntimeException("Stub!"); }

/**
 * Sets the event context.
 
 * @param eventContext This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public T setEventContext(@androidx.annotation.Nullable android.view.textclassifier.TextClassificationContext eventContext) { throw new RuntimeException("Stub!"); }

/**
 * Sets the id of the text classifier result related to this event.
 
 * @param resultId This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public T setResultId(@androidx.annotation.Nullable java.lang.String resultId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the index of this event in the series of events it belongs to.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public T setEventIndex(int eventIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sets the scores of the suggestions.
 
 * @param scores This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public T setScores(@androidx.annotation.NonNull float... scores) { throw new RuntimeException("Stub!"); }

/**
 * Sets the model name string.
 
 * @param modelVersion This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public T setModelName(@androidx.annotation.Nullable java.lang.String modelVersion) { throw new RuntimeException("Stub!"); }

/**
 * Sets the indices of the actions involved in this event. Actions are usually returned by
 * the text classifier in priority order with the most preferred action at index 0.
 * These indices give an indication of the position of the actions that are being reported.
 * <p>
 * E.g.
 * <pre>
 *   // 3 smart actions are shown at index 0, 1, 2 respectively in response to a link click.
 *   new TextClassifierEvent.Builder(CATEGORY_LINKIFY, TYPE_ACTIONS_SHOWN)
 *       .setEventIndex(0, 1, 2)
 *       ...
 *       .build();
 *
 *   ...
 *
 *   // Smart action at index 1 is activated.
 *   new TextClassifierEvent.Builder(CATEGORY_LINKIFY, TYPE_SMART_ACTION)
 *       .setEventIndex(1)
 *       ...
 *       .build();
 * </pre>
 *
 * @see android.view.textclassifier.TextClassification#getActions()
 
 * @param actionIndices This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public T setActionIndices(@androidx.annotation.NonNull int... actionIndices) { throw new RuntimeException("Stub!"); }

/**
 * Sets the detected locale.
 
 * @param locale This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public T setLocale(@androidx.annotation.Nullable android.icu.util.ULocale locale) { throw new RuntimeException("Stub!"); }

/**
 * Sets a bundle containing non-structured extra information about the event.
 *
 * <p><b>NOTE: </b>Prefer to set only immutable values on the bundle otherwise, avoid
 * updating the internals of this bundle as it may have unexpected consequences on the
 * clients of the built event object. For similar reasons, avoid depending on mutable
 * objects in this bundle.
 
 * @param extras This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public T setExtras(@androidx.annotation.NonNull android.os.Bundle extras) { throw new RuntimeException("Stub!"); }
}

/**
 * This class represents events that are related to the conversation actions feature.
 * <p>
 * <pre>
 *     // Conversation (contextual) actions/replies generated.
 *     new ConversationActionsEvent.Builder(TYPE_ACTIONS_GENERATED)
 *         .setEventContext(classificationContext)
 *         .setResultId(conversationActions.getId())
 *         .setEntityTypes(getTypes(conversationActions))
 *         .setActionIndices(range(conversationActions.getActions().size()))
 *         .setEventIndex(0)
 *         .build();
 *
 *     // Conversation actions/replies presented to user.
 *     new ConversationActionsEvent.Builder(TYPE_ACTIONS_SHOWN)
 *         .setEventContext(classificationContext)
 *         .setResultId(conversationActions.getId())
 *         .setEntityTypes(getTypes(conversationActions))
 *         .setActionIndices(range(conversationActions.getActions().size()))
 *         .setEventIndex(1)
 *         .build();
 *
 *     // User clicked the "Reply" button to compose their custom reply.
 *     new ConversationActionsEvent.Builder(TYPE_MANUAL_REPLY)
 *         .setEventContext(classificationContext)
 *         .setResultId(conversationActions.getId())
 *         .setEventIndex(2)
 *         .build();
 *
 *     // User selected a smart (contextual) action/reply.
 *     new ConversationActionsEvent.Builder(TYPE_SMART_ACTION)
 *         .setEventContext(classificationContext)
 *         .setResultId(conversationActions.getId())
 *         .setEntityTypes(conversationActions.get(1).getType())
 *         .setScore(conversationAction.get(1).getConfidenceScore())
 *         .setActionIndices(1)
 *         .setEventIndex(2)
 *         .build();
 * </pre>
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class ConversationActionsEvent extends android.view.textclassifier.TextClassifierEvent implements android.os.Parcelable {

private ConversationActionsEvent() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.TextClassifierEvent.ConversationActionsEvent> CREATOR;
static { CREATOR = null; }
/**
 * Builder class for {@link android.view.textclassifier.TextClassifierEvent.ConversationActionsEvent ConversationActionsEvent}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder extends android.view.textclassifier.TextClassifierEvent.Builder<android.view.textclassifier.TextClassifierEvent.ConversationActionsEvent.Builder> {

/**
 * Creates a builder for building {@link android.view.textclassifier.TextClassifierEvent.TextSelectionEvent TextSelectionEvent}s.
 *
 * @param eventType The event type. e.g. {@link #TYPE_SMART_ACTION}
 
 * Value is {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_STARTED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_MODIFIED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SMART_SELECTION_SINGLE}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SMART_SELECTION_MULTI}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_AUTO_SELECTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_ACTIONS_SHOWN}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_LINK_CLICKED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_OVERTYPE}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_COPY_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_PASTE_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_CUT_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SHARE_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SMART_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_DRAG}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_DESTROYED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_OTHER_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECT_ALL}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_RESET}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_MANUAL_REPLY}, or {@link android.view.textclassifier.TextClassifierEvent#TYPE_ACTIONS_GENERATED}
 * @apiSince 29
 */

public Builder(int eventType) { throw new RuntimeException("Stub!"); }

/**
 * Builds and returns a {@link android.view.textclassifier.TextClassifierEvent.ConversationActionsEvent ConversationActionsEvent}.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifierEvent.ConversationActionsEvent build() { throw new RuntimeException("Stub!"); }
}

}

/**
 * This class represents events that are related to the language detection feature.
 * <p>
 * <pre>
 *     // Translate action shown for foreign text.
 *     new LanguageDetectionEvent.Builder(TYPE_ACTIONS_SHOWN)
 *         .setEventContext(classificationContext)
 *         .setResultId(textClassification.getId())
 *         .setEntityTypes(language)
 *         .setScore(score)
 *         .setActionIndices(textClassification.getActions().indexOf(translateAction))
 *         .setEventIndex(0)
 *         .build();
 *
 *     // Translate action selected.
 *     new LanguageDetectionEvent.Builder(TYPE_SMART_ACTION)
 *         .setEventContext(classificationContext)
 *         .setResultId(textClassification.getId())
 *         .setEntityTypes(language)
 *         .setScore(score)
 *         .setActionIndices(textClassification.getActions().indexOf(translateAction))
 *         .setEventIndex(1)
 *         .build();
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class LanguageDetectionEvent extends android.view.textclassifier.TextClassifierEvent implements android.os.Parcelable {

private LanguageDetectionEvent() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.TextClassifierEvent.LanguageDetectionEvent> CREATOR;
static { CREATOR = null; }
/**
 * Builder class for {@link android.view.textclassifier.TextClassifierEvent.LanguageDetectionEvent LanguageDetectionEvent}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder extends android.view.textclassifier.TextClassifierEvent.Builder<android.view.textclassifier.TextClassifierEvent.LanguageDetectionEvent.Builder> {

/**
 * Creates a builder for building {@link android.view.textclassifier.TextClassifierEvent.TextSelectionEvent TextSelectionEvent}s.
 *
 * @param eventType The event type. e.g. {@link #TYPE_SMART_ACTION}
 
 * Value is {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_STARTED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_MODIFIED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SMART_SELECTION_SINGLE}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SMART_SELECTION_MULTI}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_AUTO_SELECTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_ACTIONS_SHOWN}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_LINK_CLICKED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_OVERTYPE}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_COPY_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_PASTE_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_CUT_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SHARE_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SMART_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_DRAG}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_DESTROYED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_OTHER_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECT_ALL}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_RESET}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_MANUAL_REPLY}, or {@link android.view.textclassifier.TextClassifierEvent#TYPE_ACTIONS_GENERATED}
 * @apiSince 29
 */

public Builder(int eventType) { throw new RuntimeException("Stub!"); }

/**
 * Builds and returns a {@link android.view.textclassifier.TextClassifierEvent.LanguageDetectionEvent LanguageDetectionEvent}.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifierEvent.LanguageDetectionEvent build() { throw new RuntimeException("Stub!"); }
}

}

/**
 * This class represents events that are related to the smart linkify feature.
 * <p>
 * <pre>
 *     // User clicked on a link.
 *     new TextLinkifyEvent.Builder(TYPE_LINK_CLICKED)
 *         .setEventContext(classificationContext)
 *         .setResultId(textClassification.getId())
 *         .setEntityTypes(textClassification.getEntity(0))
 *         .setScore(textClassification.getConfidenceScore(entityType))
 *         .setEventIndex(0)
 *         .build();
 *
 *     // Smart (contextual) actions presented to the user in response to a link click.
 *     new TextLinkifyEvent.Builder(TYPE_ACTIONS_SHOWN)
 *         .setEventContext(classificationContext)
 *         .setResultId(textClassification.getId())
 *         .setEntityTypes(textClassification.getEntity(0))
 *         .setScore(textClassification.getConfidenceScore(entityType))
 *         .setActionIndices(range(textClassification.getActions().size()))
 *         .setEventIndex(1)
 *         .build();
 *
 *     // User chooses smart action at index 0.
 *     new TextLinkifyEvent.Builder(TYPE_SMART_ACTION)
 *         .setEventContext(classificationContext)
 *         .setResultId(textClassification.getId())
 *         .setEntityTypes(textClassification.getEntity(0))
 *         .setScore(textClassification.getConfidenceScore(entityType))
 *         .setActionIndices(0)
 *         .setEventIndex(2)
 *         .build();
 * </pre>
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class TextLinkifyEvent extends android.view.textclassifier.TextClassifierEvent implements android.os.Parcelable {

private TextLinkifyEvent() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.TextClassifierEvent.TextLinkifyEvent> CREATOR;
static { CREATOR = null; }
/**
 * Builder class for {@link android.view.textclassifier.TextClassifierEvent.TextLinkifyEvent TextLinkifyEvent}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder extends android.view.textclassifier.TextClassifierEvent.Builder<android.view.textclassifier.TextClassifierEvent.TextLinkifyEvent.Builder> {

/**
 * Creates a builder for building {@link android.view.textclassifier.TextClassifierEvent.TextLinkifyEvent TextLinkifyEvent}s.
 *
 * @param eventType The event type. e.g. {@link #TYPE_SMART_ACTION}
 
 * Value is {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_STARTED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_MODIFIED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SMART_SELECTION_SINGLE}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SMART_SELECTION_MULTI}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_AUTO_SELECTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_ACTIONS_SHOWN}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_LINK_CLICKED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_OVERTYPE}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_COPY_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_PASTE_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_CUT_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SHARE_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SMART_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_DRAG}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_DESTROYED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_OTHER_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECT_ALL}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_RESET}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_MANUAL_REPLY}, or {@link android.view.textclassifier.TextClassifierEvent#TYPE_ACTIONS_GENERATED}
 * @apiSince 29
 */

public Builder(int eventType) { throw new RuntimeException("Stub!"); }

/**
 * Builds and returns a {@link android.view.textclassifier.TextClassifierEvent.TextLinkifyEvent TextLinkifyEvent}.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifierEvent.TextLinkifyEvent build() { throw new RuntimeException("Stub!"); }
}

}

/**
 * This class represents events that are related to the smart text selection feature.
 * <p>
 * <pre>
 *     // User started a selection. e.g. "York" in text "New York City, NY".
 *     new TextSelectionEvent.Builder(TYPE_SELECTION_STARTED)
 *         .setEventContext(classificationContext)
 *         .setEventIndex(0)
 *         .build();
 *
 *     // System smart-selects a recognized entity. e.g. "New York City".
 *     new TextSelectionEvent.Builder(TYPE_SMART_SELECTION_MULTI)
 *         .setEventContext(classificationContext)
 *         .setResultId(textSelection.getId())
 *         .setRelativeWordStartIndex(-1) // Goes back one word to "New" from "York".
 *         .setRelativeWordEndIndex(2)    // Goes forward 2 words from "York" to start of ",".
 *         .setEntityTypes(textClassification.getEntity(0))
 *         .setScore(textClassification.getConfidenceScore(entityType))
 *         .setEventIndex(1)
 *         .build();
 *
 *     // User resets the selection to the original selection. i.e. "York".
 *     new TextSelectionEvent.Builder(TYPE_SELECTION_RESET)
 *         .setEventContext(classificationContext)
 *         .setResultId(textSelection.getId())
 *         .setRelativeSuggestedWordStartIndex(-1) // Repeated from above.
 *         .setRelativeSuggestedWordEndIndex(2)    // Repeated from above.
 *         .setRelativeWordStartIndex(0)           // Original selection is always at (0, 1].
 *         .setRelativeWordEndIndex(1)
 *         .setEntityTypes(textClassification.getEntity(0))
 *         .setScore(textClassification.getConfidenceScore(entityType))
 *         .setEventIndex(2)
 *         .build();
 *
 *     // User modified the selection. e.g. "New".
 *     new TextSelectionEvent.Builder(TYPE_SELECTION_MODIFIED)
 *         .setEventContext(classificationContext)
 *         .setResultId(textSelection.getId())
 *         .setRelativeSuggestedWordStartIndex(-1) // Repeated from above.
 *         .setRelativeSuggestedWordEndIndex(2)    // Repeated from above.
 *         .setRelativeWordStartIndex(-1)          // Goes backward one word from "York" to
 *         "New".
 *         .setRelativeWordEndIndex(0)             // Goes backward one word to exclude "York".
 *         .setEntityTypes(textClassification.getEntity(0))
 *         .setScore(textClassification.getConfidenceScore(entityType))
 *         .setEventIndex(3)
 *         .build();
 *
 *     // Smart (contextual) actions (at indices, 0, 1, 2) presented to the user.
 *     // e.g. "Map", "Ride share", "Explore".
 *     new TextSelectionEvent.Builder(TYPE_ACTIONS_SHOWN)
 *         .setEventContext(classificationContext)
 *         .setResultId(textClassification.getId())
 *         .setEntityTypes(textClassification.getEntity(0))
 *         .setScore(textClassification.getConfidenceScore(entityType))
 *         .setActionIndices(0, 1, 2)
 *         .setEventIndex(4)
 *         .build();
 *
 *     // User chooses the "Copy" action.
 *     new TextSelectionEvent.Builder(TYPE_COPY_ACTION)
 *         .setEventContext(classificationContext)
 *         .setResultId(textClassification.getId())
 *         .setEntityTypes(textClassification.getEntity(0))
 *         .setScore(textClassification.getConfidenceScore(entityType))
 *         .setEventIndex(5)
 *         .build();
 *
 *     // User chooses smart action at index 1. i.e. "Ride share".
 *     new TextSelectionEvent.Builder(TYPE_SMART_ACTION)
 *         .setEventContext(classificationContext)
 *         .setResultId(textClassification.getId())
 *         .setEntityTypes(textClassification.getEntity(0))
 *         .setScore(textClassification.getConfidenceScore(entityType))
 *         .setActionIndices(1)
 *         .setEventIndex(5)
 *         .build();
 *
 *     // Selection dismissed.
 *     new TextSelectionEvent.Builder(TYPE_SELECTION_DESTROYED)
 *         .setEventContext(classificationContext)
 *         .setResultId(textClassification.getId())
 *         .setEntityTypes(textClassification.getEntity(0))
 *         .setScore(textClassification.getConfidenceScore(entityType))
 *         .setEventIndex(6)
 *         .build();
 * </pre>
 * <p>
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class TextSelectionEvent extends android.view.textclassifier.TextClassifierEvent implements android.os.Parcelable {

private TextSelectionEvent() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns the relative word index of the start of the selection.
 * @apiSince 29
 */

public int getRelativeWordStartIndex() { throw new RuntimeException("Stub!"); }

/**
 * Returns the relative word (exclusive) index of the end of the selection.
 * @apiSince 29
 */

public int getRelativeWordEndIndex() { throw new RuntimeException("Stub!"); }

/**
 * Returns the relative word index of the start of the smart selection.
 * @apiSince 29
 */

public int getRelativeSuggestedWordStartIndex() { throw new RuntimeException("Stub!"); }

/**
 * Returns the relative word (exclusive) index of the end of the
 * smart selection.
 * @apiSince 29
 */

public int getRelativeSuggestedWordEndIndex() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.TextClassifierEvent.TextSelectionEvent> CREATOR;
static { CREATOR = null; }
/**
 * Builder class for {@link android.view.textclassifier.TextClassifierEvent.TextSelectionEvent TextSelectionEvent}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder extends android.view.textclassifier.TextClassifierEvent.Builder<android.view.textclassifier.TextClassifierEvent.TextSelectionEvent.Builder> {

/**
 * Creates a builder for building {@link android.view.textclassifier.TextClassifierEvent.TextSelectionEvent TextSelectionEvent}s.
 *
 * @param eventType     The event type. e.g. {@link #TYPE_SELECTION_STARTED}
 
 * Value is {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_STARTED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_MODIFIED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SMART_SELECTION_SINGLE}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SMART_SELECTION_MULTI}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_AUTO_SELECTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_ACTIONS_SHOWN}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_LINK_CLICKED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_OVERTYPE}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_COPY_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_PASTE_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_CUT_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SHARE_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SMART_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_DRAG}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_DESTROYED}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_OTHER_ACTION}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECT_ALL}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_SELECTION_RESET}, {@link android.view.textclassifier.TextClassifierEvent#TYPE_MANUAL_REPLY}, or {@link android.view.textclassifier.TextClassifierEvent#TYPE_ACTIONS_GENERATED}
 * @apiSince 29
 */

public Builder(int eventType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the relative word index of the start of the selection.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifierEvent.TextSelectionEvent.Builder setRelativeWordStartIndex(int relativeWordStartIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sets the relative word (exclusive) index of the end of the
 * selection.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifierEvent.TextSelectionEvent.Builder setRelativeWordEndIndex(int relativeWordEndIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sets the relative word index of the start of the smart
 * selection.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifierEvent.TextSelectionEvent.Builder setRelativeSuggestedWordStartIndex(int relativeSuggestedWordStartIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sets the relative word (exclusive) index of the end of the
 * smart selection.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifierEvent.TextSelectionEvent.Builder setRelativeSuggestedWordEndIndex(int relativeSuggestedWordEndIndex) { throw new RuntimeException("Stub!"); }

/**
 * Builds and returns a {@link android.view.textclassifier.TextClassifierEvent.TextSelectionEvent TextSelectionEvent}.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifierEvent.TextSelectionEvent build() { throw new RuntimeException("Stub!"); }
}

}

}

