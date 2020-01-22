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


package android.view.textclassifier;


/**
 * A selection event.
 * Specify index parameters as word token indices.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SelectionEvent implements android.os.Parcelable {

SelectionEvent() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Creates a "selection started" event.
 *
 * @param invocationMethod  the way the selection was triggered
 * Value is {@link android.view.textclassifier.SelectionEvent#INVOCATION_MANUAL}, {@link android.view.textclassifier.SelectionEvent#INVOCATION_LINK}, or {@link android.view.textclassifier.SelectionEvent#INVOCATION_UNKNOWN}
 * @param start  the index of the selected text
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.view.textclassifier.SelectionEvent createSelectionStartedEvent(int invocationMethod, int start) { throw new RuntimeException("Stub!"); }

/**
 * Creates a "selection modified" event.
 * Use when the user modifies the selection.
 *
 * @param start  the start (inclusive) index of the selection
 * @param end  the end (exclusive) index of the selection
 *
 * @throws java.lang.IllegalArgumentException if end is less than start
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.view.textclassifier.SelectionEvent createSelectionModifiedEvent(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Creates a "selection modified" event.
 * Use when the user modifies the selection and the selection's entity type is known.
 *
 * @param start  the start (inclusive) index of the selection
 * @param end  the end (exclusive) index of the selection
 * @param classification  the TextClassification object returned by the TextClassifier that
 *      classified the selected text
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if end is less than start
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.view.textclassifier.SelectionEvent createSelectionModifiedEvent(int start, int end, @androidx.annotation.NonNull android.view.textclassifier.TextClassification classification) { throw new RuntimeException("Stub!"); }

/**
 * Creates a "selection modified" event.
 * Use when a TextClassifier modifies the selection.
 *
 * @param start  the start (inclusive) index of the selection
 * @param end  the end (exclusive) index of the selection
 * @param selection  the TextSelection object returned by the TextClassifier for the
 *      specified selection
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if end is less than start
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.view.textclassifier.SelectionEvent createSelectionModifiedEvent(int start, int end, @androidx.annotation.NonNull android.view.textclassifier.TextSelection selection) { throw new RuntimeException("Stub!"); }

/**
 * Creates an event specifying an action taken on a selection.
 * Use when the user clicks on an action to act on the selected text.
 *
 * @param start  the start (inclusive) index of the selection
 * @param end  the end (exclusive) index of the selection
 * @param actionType  the action that was performed on the selection
 *
 * Value is {@link android.view.textclassifier.SelectionEvent#ACTION_OVERTYPE}, {@link android.view.textclassifier.SelectionEvent#ACTION_COPY}, {@link android.view.textclassifier.SelectionEvent#ACTION_PASTE}, {@link android.view.textclassifier.SelectionEvent#ACTION_CUT}, {@link android.view.textclassifier.SelectionEvent#ACTION_SHARE}, {@link android.view.textclassifier.SelectionEvent#ACTION_SMART_SHARE}, {@link android.view.textclassifier.SelectionEvent#ACTION_DRAG}, {@link android.view.textclassifier.SelectionEvent#ACTION_ABANDON}, {@link android.view.textclassifier.SelectionEvent#ACTION_OTHER}, {@link android.view.textclassifier.SelectionEvent#ACTION_SELECT_ALL}, or {@link android.view.textclassifier.SelectionEvent#ACTION_RESET}
 * @throws java.lang.IllegalArgumentException if end is less than start
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.view.textclassifier.SelectionEvent createSelectionActionEvent(int start, int end, int actionType) { throw new RuntimeException("Stub!"); }

/**
 * Creates an event specifying an action taken on a selection.
 * Use when the user clicks on an action to act on the selected text and the selection's
 * entity type is known.
 *
 * @param start  the start (inclusive) index of the selection
 * @param end  the end (exclusive) index of the selection
 * @param actionType  the action that was performed on the selection
 * Value is {@link android.view.textclassifier.SelectionEvent#ACTION_OVERTYPE}, {@link android.view.textclassifier.SelectionEvent#ACTION_COPY}, {@link android.view.textclassifier.SelectionEvent#ACTION_PASTE}, {@link android.view.textclassifier.SelectionEvent#ACTION_CUT}, {@link android.view.textclassifier.SelectionEvent#ACTION_SHARE}, {@link android.view.textclassifier.SelectionEvent#ACTION_SMART_SHARE}, {@link android.view.textclassifier.SelectionEvent#ACTION_DRAG}, {@link android.view.textclassifier.SelectionEvent#ACTION_ABANDON}, {@link android.view.textclassifier.SelectionEvent#ACTION_OTHER}, {@link android.view.textclassifier.SelectionEvent#ACTION_SELECT_ALL}, or {@link android.view.textclassifier.SelectionEvent#ACTION_RESET}
 * @param classification  the TextClassification object returned by the TextClassifier that
 *      classified the selected text
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if end is less than start
 * @throws java.lang.IllegalArgumentException If actionType is not a valid SelectionEvent actionType
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.view.textclassifier.SelectionEvent createSelectionActionEvent(int start, int end, int actionType, @androidx.annotation.NonNull android.view.textclassifier.TextClassification classification) { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of event that was triggered. e.g. {@link #ACTION_COPY}.
 
 * @return Value is {@link android.view.textclassifier.SelectionEvent#ACTION_OVERTYPE}, {@link android.view.textclassifier.SelectionEvent#ACTION_COPY}, {@link android.view.textclassifier.SelectionEvent#ACTION_PASTE}, {@link android.view.textclassifier.SelectionEvent#ACTION_CUT}, {@link android.view.textclassifier.SelectionEvent#ACTION_SHARE}, {@link android.view.textclassifier.SelectionEvent#ACTION_SMART_SHARE}, {@link android.view.textclassifier.SelectionEvent#ACTION_DRAG}, {@link android.view.textclassifier.SelectionEvent#ACTION_ABANDON}, {@link android.view.textclassifier.SelectionEvent#ACTION_OTHER}, {@link android.view.textclassifier.SelectionEvent#ACTION_SELECT_ALL}, {@link android.view.textclassifier.SelectionEvent#ACTION_RESET}, {@link android.view.textclassifier.SelectionEvent#EVENT_SELECTION_STARTED}, {@link android.view.textclassifier.SelectionEvent#EVENT_SELECTION_MODIFIED}, {@link android.view.textclassifier.SelectionEvent#EVENT_SMART_SELECTION_SINGLE}, {@link android.view.textclassifier.SelectionEvent#EVENT_SMART_SELECTION_MULTI}, or {@link android.view.textclassifier.SelectionEvent#EVENT_AUTO_SELECTION}
 * @apiSince 28
 */

public int getEventType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of entity that is associated with this event. e.g.
 * {@link android.view.textclassifier.TextClassifier#TYPE_EMAIL}.
 
 * @return Value is {@link android.view.textclassifier.TextClassifier#TYPE_UNKNOWN}, {@link android.view.textclassifier.TextClassifier#TYPE_OTHER}, {@link android.view.textclassifier.TextClassifier#TYPE_EMAIL}, {@link android.view.textclassifier.TextClassifier#TYPE_PHONE}, {@link android.view.textclassifier.TextClassifier#TYPE_ADDRESS}, {@link android.view.textclassifier.TextClassifier#TYPE_URL}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE_TIME}, {@link android.view.textclassifier.TextClassifier#TYPE_FLIGHT_NUMBER}, or android.view.textclassifier.TextClassifier.TYPE_DICTIONARY
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.lang.String getEntityType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the package name of the app that this event originated in.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of widget that was involved in triggering this event.
 
 * @return Value is {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_TEXTVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_EDITTEXT}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_UNSELECTABLE_TEXTVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_WEBVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_EDIT_WEBVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_CUSTOM_TEXTVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_CUSTOM_EDITTEXT}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_CUSTOM_UNSELECTABLE_TEXTVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_NOTIFICATION}, or {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_UNKNOWN}
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.lang.String getWidgetType() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string version info for the widget this event was triggered in.
 
 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getWidgetVersion() { throw new RuntimeException("Stub!"); }

/**
 * Returns the way the selection mode was invoked.
 
 * @return Value is {@link android.view.textclassifier.SelectionEvent#INVOCATION_MANUAL}, {@link android.view.textclassifier.SelectionEvent#INVOCATION_LINK}, or {@link android.view.textclassifier.SelectionEvent#INVOCATION_UNKNOWN}
 * @apiSince 28
 */

public int getInvocationMethod() { throw new RuntimeException("Stub!"); }

/**
 * Returns the id of the text classifier result associated with this event.
 
 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getResultId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the time this event was triggered.
 * @apiSince 28
 */

public long getEventTime() { throw new RuntimeException("Stub!"); }

/**
 * Returns the duration in ms between when this event was triggered and when the first event in
 * the selection session was triggered.
 * @apiSince 28
 */

public long getDurationSinceSessionStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns the duration in ms between when this event was triggered and when the previous event
 * in the selection session was triggered.
 * @apiSince 28
 */

public long getDurationSincePreviousEvent() { throw new RuntimeException("Stub!"); }

/**
 * Returns the index (e.g.&nbsp;1st event, 2nd event, etc.) of this event in the selection session.
 * @apiSince 28
 */

public int getEventIndex() { throw new RuntimeException("Stub!"); }

/**
 * Returns the selection session id.
 
 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.view.textclassifier.TextClassificationSessionId getSessionId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the start index of this events relative to the index of the start selection
 * event in the selection session.
 * @apiSince 28
 */

public int getStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns the end index of this events relative to the index of the start selection
 * event in the selection session.
 * @apiSince 28
 */

public int getEnd() { throw new RuntimeException("Stub!"); }

/**
 * Returns the start index of this events relative to the index of the smart selection
 * event in the selection session.
 * @apiSince 28
 */

public int getSmartStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns the end index of this events relative to the index of the smart selection
 * event in the selection session.
 * @apiSince 28
 */

public int getSmartEnd() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the eventType is a terminal event type. Otherwise returns false.
 * A terminal event is an event that ends a selection interaction.
 
 * @param eventType Value is {@link android.view.textclassifier.SelectionEvent#ACTION_OVERTYPE}, {@link android.view.textclassifier.SelectionEvent#ACTION_COPY}, {@link android.view.textclassifier.SelectionEvent#ACTION_PASTE}, {@link android.view.textclassifier.SelectionEvent#ACTION_CUT}, {@link android.view.textclassifier.SelectionEvent#ACTION_SHARE}, {@link android.view.textclassifier.SelectionEvent#ACTION_SMART_SHARE}, {@link android.view.textclassifier.SelectionEvent#ACTION_DRAG}, {@link android.view.textclassifier.SelectionEvent#ACTION_ABANDON}, {@link android.view.textclassifier.SelectionEvent#ACTION_OTHER}, {@link android.view.textclassifier.SelectionEvent#ACTION_SELECT_ALL}, {@link android.view.textclassifier.SelectionEvent#ACTION_RESET}, {@link android.view.textclassifier.SelectionEvent#EVENT_SELECTION_STARTED}, {@link android.view.textclassifier.SelectionEvent#EVENT_SELECTION_MODIFIED}, {@link android.view.textclassifier.SelectionEvent#EVENT_SMART_SELECTION_SINGLE}, {@link android.view.textclassifier.SelectionEvent#EVENT_SMART_SELECTION_MULTI}, or {@link android.view.textclassifier.SelectionEvent#EVENT_AUTO_SELECTION}
 * @apiSince 28
 */

public static boolean isTerminal(int eventType) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * User abandoned the selection.
 * @apiSince 28
 */

public static final int ACTION_ABANDON = 107; // 0x6b

/**
 * User copied the selection.
 * @apiSince 28
 */

public static final int ACTION_COPY = 101; // 0x65

/**
 * User cut the selection.
 * @apiSince 28
 */

public static final int ACTION_CUT = 103; // 0x67

/**
 * User dragged+dropped the selection.
 * @apiSince 28
 */

public static final int ACTION_DRAG = 106; // 0x6a

/**
 * User performed an action on the selection.
 * @apiSince 28
 */

public static final int ACTION_OTHER = 108; // 0x6c

/**
 * User typed over the selection.
 * @apiSince 28
 */

public static final int ACTION_OVERTYPE = 100; // 0x64

/**
 * User pasted over the selection.
 * @apiSince 28
 */

public static final int ACTION_PASTE = 102; // 0x66

/**
 * User reset the smart selection.
 * @apiSince 28
 */

public static final int ACTION_RESET = 201; // 0xc9

/**
 * User activated Select All
 * @apiSince 28
 */

public static final int ACTION_SELECT_ALL = 200; // 0xc8

/**
 * User shared the selection.
 * @apiSince 28
 */

public static final int ACTION_SHARE = 104; // 0x68

/**
 * User clicked the textAssist menu item.
 * @apiSince 28
 */

public static final int ACTION_SMART_SHARE = 105; // 0x69

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.SelectionEvent> CREATOR;
static { CREATOR = null; }

/**
 * Something else other than User or the default TextClassifier triggered a selection.
 * @apiSince 28
 */

public static final int EVENT_AUTO_SELECTION = 5; // 0x5

/**
 * User modified an existing selection.
 * @apiSince 28
 */

public static final int EVENT_SELECTION_MODIFIED = 2; // 0x2

/**
 * User started a new selection.
 * @apiSince 28
 */

public static final int EVENT_SELECTION_STARTED = 1; // 0x1

/**
 * Smart selection triggered spanning multiple tokens (words).
 * @apiSince 28
 */

public static final int EVENT_SMART_SELECTION_MULTI = 4; // 0x4

/**
 * Smart selection triggered for a single token (word).
 * @apiSince 28
 */

public static final int EVENT_SMART_SELECTION_SINGLE = 3; // 0x3

/**
 * Selection was invoked by the user tapping on a link.
 * @apiSince 28
 */

public static final int INVOCATION_LINK = 2; // 0x2

/**
 * Selection was invoked by the user long pressing, double tapping, or dragging to select.
 * @apiSince 28
 */

public static final int INVOCATION_MANUAL = 1; // 0x1

/**
 * Unknown invocation method
 * @apiSince 28
 */

public static final int INVOCATION_UNKNOWN = 0; // 0x0
}

