/*
 * Copyright (C) 2009 The Android Open Source Project
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


package android.view.accessibility;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>
 * This class represents accessibility events that are sent by the system when
 * something notable happens in the user interface. For example, when a
 * {@link android.widget.Button} is clicked, a {@link android.view.View} is focused, etc.
 * </p>
 * <p>
 * An accessibility event is fired by an individual view which populates the event with
 * data for its state and requests from its parent to send the event to interested
 * parties. The parent can optionally modify or even block the event based on its broader
 * understanding of the user interface's context.
 * </p>
 * <p>
 * The main purpose of an accessibility event is to communicate changes in the UI to an
 * {@link android.accessibilityservice.AccessibilityService}. The service may then inspect,
 * if needed the user interface by examining the View hierarchy, as represented by a tree of
 * {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo}s (snapshot of a View state)
 * which can be used for exploring the window content. Note that the privilege for accessing
 * an event's source, thus the window content, has to be explicitly requested. For more
 * details refer to {@link android.accessibilityservice.AccessibilityService}. If an
 * accessibility service has not requested to retrieve the window content the event will
 * not contain reference to its source. Also for events of type
 * {@link #TYPE_NOTIFICATION_STATE_CHANGED} the source is never available.
 * </p>
 * <p>
 * This class represents various semantically different accessibility event
 * types. Each event type has an associated set of related properties. In other
 * words, each event type is characterized via a subset of the properties exposed
 * by this class. For each event type there is a corresponding constant defined
 * in this class. Follows a specification of the event types and their associated properties:
 * </p>
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about creating and processing AccessibilityEvents, read the
 * <a href="{@docRoot}guide/topics/ui/accessibility/index.html">Accessibility</a>
 * developer guide.</p>
 * </div>
 * <p>
 * <b>VIEW TYPES</b></br>
 * </p>
 * <p>
 * <b>View clicked</b> - represents the event of clicking on a {@link android.view.View}
 * like {@link android.widget.Button}, {@link android.widget.CompoundButton}, etc.</br>
 * <em>Type:</em>{@link #TYPE_VIEW_CLICKED}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 *   <li>{@link #getSource()} - The source info (for registered clients).</li>
 *   <li>{@link #getClassName()} - The class name of the source.</li>
 *   <li>{@link #getPackageName()} - The package name of the source.</li>
 *   <li>{@link #getEventTime()}  - The event time.</li>
 * </ul>
 * </p>
 * <p>
 * <b>View long clicked</b> - represents the event of long clicking on a {@link android.view.View}
 * like {@link android.widget.Button}, {@link android.widget.CompoundButton}, etc </br>
 * <em>Type:</em>{@link #TYPE_VIEW_LONG_CLICKED}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 *   <li>{@link #getSource()} - The source info (for registered clients).</li>
 *   <li>{@link #getClassName()} - The class name of the source.</li>
 *   <li>{@link #getPackageName()} - The package name of the source.</li>
 *   <li>{@link #getEventTime()}  - The event time.</li>
 * </ul>
 * </p>
 * <p>
 * <b>View selected</b> - represents the event of selecting an item usually in
 * the context of an {@link android.widget.AdapterView}.</br>
 * <em>Type:</em> {@link #TYPE_VIEW_SELECTED}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 *   <li>{@link #getSource()} - The source info (for registered clients).</li>
 *   <li>{@link #getClassName()} - The class name of the source.</li>
 *   <li>{@link #getPackageName()} - The package name of the source.</li>
 *   <li>{@link #getEventTime()}  - The event time.</li>
 * </ul>
 * </p>
 * <p>
 * <b>View focused</b> - represents the event of focusing a
 * {@link android.view.View}.</br>
 * <em>Type:</em> {@link #TYPE_VIEW_FOCUSED}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 *   <li>{@link #getSource()} - The source info (for registered clients).</li>
 *   <li>{@link #getClassName()} - The class name of the source.</li>
 *   <li>{@link #getPackageName()} - The package name of the source.</li>
 *   <li>{@link #getEventTime()}  - The event time.</li>
 * </ul>
 * </p>
 * <p>
 * <b>View text changed</b> - represents the event of changing the text of an
 * {@link android.widget.EditText}.</br>
 * <em>Type:</em> {@link #TYPE_VIEW_TEXT_CHANGED}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 *   <li>{@link #getSource()} - The source info (for registered clients).</li>
 *   <li>{@link #getClassName()} - The class name of the source.</li>
 *   <li>{@link #getPackageName()} - The package name of the source.</li>
 *   <li>{@link #getEventTime()}  - The event time.</li>
 *   <li>{@link #getText()} - The new text of the source.</li>
 *   <li>{@link #getBeforeText()} - The text of the source before the change.</li>
 *   <li>{@link #getFromIndex()} - The text change start index.</li>
 *   <li>{@link #getAddedCount()} - The number of added characters.</li>
 *   <li>{@link #getRemovedCount()} - The number of removed characters.</li>
 * </ul>
 * </p>
 * <p>
 * <b>View text selection changed</b> - represents the event of changing the text
 * selection of an {@link android.widget.EditText}.</br>
 * <em>Type:</em> {@link #TYPE_VIEW_TEXT_SELECTION_CHANGED} </br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 *   <li>{@link #getSource()} - The source info (for registered clients).</li>
 *   <li>{@link #getClassName()} - The class name of the source.</li>
 *   <li>{@link #getPackageName()} - The package name of the source.</li>
 *   <li>{@link #getEventTime()}  - The event time.</li>
 * </ul>
 * </p>
 * <b>View text traversed at movement granularity</b> - represents the event of traversing the
 * text of a view at a given granularity. For example, moving to the next word.</br>
 * <em>Type:</em> {@link #TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY} </br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 *   <li>{@link #getSource()} - The source info (for registered clients).</li>
 *   <li>{@link #getClassName()} - The class name of the source.</li>
 *   <li>{@link #getPackageName()} - The package name of the source.</li>
 *   <li>{@link #getEventTime()}  - The event time.</li>
 *   <li>{@link #getMovementGranularity()} - Sets the granularity at which a view's text
 *       was traversed.</li>
 *   <li>{@link #getText()} -  The text of the source's sub-tree.</li>
 *   <li>{@link #getFromIndex()} - The start the text that was skipped over in this movement.
 *       This is the starting point when moving forward through the text, but not when moving
 *       back.</li>
 *   <li>{@link #getToIndex()} - The end of the text that was skipped over in this movement.
 *       This is the ending point when moving forward through the text, but not when moving
 *       back.</li>
 *   <li>{@link #getAction()} - Gets traversal action which specifies the direction.</li>
 * </ul>
 * </p>
 * <p>
 * <b>View scrolled</b> - represents the event of scrolling a view. </br>
 * <em>Type:</em> {@link #TYPE_VIEW_SCROLLED}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 *   <li>{@link #getSource()} - The source info (for registered clients).</li>
 *   <li>{@link #getClassName()} - The class name of the source.</li>
 *   <li>{@link #getPackageName()} - The package name of the source.</li>
 *   <li>{@link #getEventTime()}  - The event time.</li>
 *   <li>{@link #getScrollDeltaX()} - The difference in the horizontal position.</li>
 *   <li>{@link #getScrollDeltaY()} - The difference in the vertical position.</li>
 * </ul>
 * </p>
 * <p>
 * <b>TRANSITION TYPES</b></br>
 * </p>
 * <p>
 * <b>Window state changed</b> - represents the event of a change to a section of
 * the user interface that is visually distinct. Should be sent from either the
 * root view of a window or from a view that is marked as a pane
 * {@link android.view.View#setAccessibilityPaneTitle(CharSequence)}. Not that changes
 * to true windows are represented by {@link #TYPE_WINDOWS_CHANGED}.</br>
 * <em>Type:</em> {@link #TYPE_WINDOW_STATE_CHANGED}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 *   <li>{@link #getContentChangeTypes()} - The type of state changes.</li>
 *   <li>{@link #getSource()} - The source info (for registered clients).</li>
 *   <li>{@link #getClassName()} - The class name of the source.</li>
 *   <li>{@link #getPackageName()} - The package name of the source.</li>
 *   <li>{@link #getEventTime()}  - The event time.</li>
 *   <li>{@link #getText()} - The text of the source's sub-tree, including the pane titles.</li>
 * </ul>
 * </p>
 * <p>
 * <b>Window content changed</b> - represents the event of change in the
 * content of a window. This change can be adding/removing view, changing
 * a view size, etc.</br>
 * </p>
 * <p>
 * <em>Type:</em> {@link #TYPE_WINDOW_CONTENT_CHANGED}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 *   <li>{@link #getContentChangeTypes()} - The type of content changes.</li>
 *   <li>{@link #getSource()} - The source info (for registered clients).</li>
 *   <li>{@link #getClassName()} - The class name of the source.</li>
 *   <li>{@link #getPackageName()} - The package name of the source.</li>
 *   <li>{@link #getEventTime()}  - The event time.</li>
 * </ul>
 * </p>
 * <p>
 * <b>Windows changed</b> - represents a change in the windows shown on
 * the screen such as a window appeared, a window disappeared, a window size changed,
 * a window layer changed, etc. These events should only come from the system, which is responsible
 * for managing windows. The list of windows is available from
 * {@link android.accessibilityservice.AccessibilityService#getWindows()}.
 * For regions of the user interface that are presented as windows but are
 * controlled by an app's process, use {@link #TYPE_WINDOW_STATE_CHANGED}.</br>
 * <em>Type:</em> {@link #TYPE_WINDOWS_CHANGED}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 *   <li>{@link #getEventTime()} - The event time.</li>
 *   <li>{@link #getWindowChanges()}</li> - The specific change to the source window
 * </ul>
 * <em>Note:</em> You can retrieve the {@link android.view.accessibility.AccessibilityWindowInfo AccessibilityWindowInfo} for the window
 * source of the event by looking through the list returned by
 * {@link android.accessibilityservice.AccessibilityService#getWindows()} for the window whose ID
 * matches {@link #getWindowId()}.
 * </p>
 * <p>
 * <b>NOTIFICATION TYPES</b></br>
 * </p>
 * <p>
 * <b>Notification state changed</b> - represents the event showing a transient piece of information
 * to the user. This information may be a {@link android.app.Notification} or
 * {@link android.widget.Toast}.</br>
 * <em>Type:</em> {@link #TYPE_NOTIFICATION_STATE_CHANGED}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 *   <li>{@link #getClassName()} - The class name of the source.</li>
 *   <li>{@link #getPackageName()} - The package name of the source.</li>
 *   <li>{@link #getEventTime()}  - The event time.</li>
 *   <li>{@link #getParcelableData()} - The posted {@link android.app.Notification}, if
 *   applicable.</li>
 *   <li>{@link #getText()} - Displayed text of the {@link android.widget.Toast}, if applicable,
 *   or may contain text from the {@link android.app.Notification}, although
 *   {@link #getParcelableData()} is a richer set of data for {@link android.app.Notification}.</li>
 * </ul>
 * </p>
 * <p>
 * <b>EXPLORATION TYPES</b></br>
 * </p>
 * <p>
 * <b>View hover enter</b> - represents the event of beginning to hover
 * over a {@link android.view.View}. The hover may be generated via
 * exploring the screen by touch or via a pointing device.</br>
 * <em>Type:</em> {@link #TYPE_VIEW_HOVER_ENTER}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 *   <li>{@link #getSource()} - The source info (for registered clients).</li>
 *   <li>{@link #getClassName()} - The class name of the source.</li>
 *   <li>{@link #getPackageName()} - The package name of the source.</li>
 *   <li>{@link #getEventTime()}  - The event time.</li>
 * </ul>
 * </p>
 * <b>View hover exit</b> - represents the event of stopping to hover
 * over a {@link android.view.View}. The hover may be generated via
 * exploring the screen by touch or via a pointing device.</br>
 * <em>Type:</em> {@link #TYPE_VIEW_HOVER_EXIT}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 *   <li>{@link #getSource()} - The source info (for registered clients).</li>
 *   <li>{@link #getClassName()} - The class name of the source.</li>
 *   <li>{@link #getPackageName()} - The package name of the source.</li>
 *   <li>{@link #getEventTime()}  - The event time.</li>
 * </ul>
 * </p>
 * <p>
 * <b>Touch interaction start</b> - represents the event of starting a touch
 * interaction, which is the user starts touching the screen.</br>
 * <em>Type:</em> {@link #TYPE_TOUCH_INTERACTION_START}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 * </ul>
 * <em>Note:</em> This event is fired only by the system and is not passed to the
 * view tree to be populated.</br>
 * </p>
 * <p>
 * <b>Touch interaction end</b> - represents the event of ending a touch
 * interaction, which is the user stops touching the screen.</br>
 * <em>Type:</em> {@link #TYPE_TOUCH_INTERACTION_END}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 * </ul>
 * <em>Note:</em> This event is fired only by the system and is not passed to the
 * view tree to be populated.</br>
 * </p>
 * <p>
 * <b>Touch exploration gesture start</b> - represents the event of starting a touch
 * exploring gesture.</br>
 * <em>Type:</em> {@link #TYPE_TOUCH_EXPLORATION_GESTURE_START}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 * </ul>
 * <em>Note:</em> This event is fired only by the system and is not passed to the
 * view tree to be populated.</br>
 * </p>
 * <p>
 * <b>Touch exploration gesture end</b> - represents the event of ending a touch
 * exploring gesture.</br>
 * <em>Type:</em> {@link #TYPE_TOUCH_EXPLORATION_GESTURE_END}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 * </ul>
 * <em>Note:</em> This event is fired only by the system and is not passed to the
 * view tree to be populated.</br>
 * </p>
 * <p>
 * <b>Touch gesture detection start</b> - represents the event of starting a user
 * gesture detection.</br>
 * <em>Type:</em> {@link #TYPE_GESTURE_DETECTION_START}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 * </ul>
 * <em>Note:</em> This event is fired only by the system and is not passed to the
 * view tree to be populated.</br>
 * </p>
 * <p>
 * <b>Touch gesture detection end</b> - represents the event of ending a user
 * gesture detection.</br>
 * <em>Type:</em> {@link #TYPE_GESTURE_DETECTION_END}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 * </ul>
 * <em>Note:</em> This event is fired only by the system and is not passed to the
 * view tree to be populated.</br>
 * </p>
 * <p>
 * <b>MISCELLANEOUS TYPES</b></br>
 * </p>
 * <p>
 * <b>Announcement</b> - represents the event of an application requesting a screen reader to make
 * an announcement. Because the event carries no semantic meaning, this event is appropriate only
 * in exceptional situations where additional screen reader output is needed but other types of
 * accessibility services do not need to be aware of the change.</br>
 * <em>Type:</em> {@link #TYPE_ANNOUNCEMENT}</br>
 * <em>Properties:</em></br>
 * <ul>
 *   <li>{@link #getEventType()} - The type of the event.</li>
 *   <li>{@link #getSource()} - The source info (for registered clients).</li>
 *   <li>{@link #getClassName()} - The class name of the source.</li>
 *   <li>{@link #getPackageName()} - The package name of the source.</li>
 *   <li>{@link #getEventTime()}  - The event time.</li>
 *   <li>{@link #getText()} - The text of the announcement.</li>
 * </ul>
 * </p>
 *
 * @see android.view.accessibility.AccessibilityManager
 * @see android.accessibilityservice.AccessibilityService
 * @see android.view.accessibility.AccessibilityNodeInfo
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AccessibilityEvent extends android.view.accessibility.AccessibilityRecord implements android.os.Parcelable {

private AccessibilityEvent() { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of records contained in the event.
 *
 * @return The number of records.
 * @apiSince 14
 */

public int getRecordCount() { throw new RuntimeException("Stub!"); }

/**
 * Appends an {@link android.view.accessibility.AccessibilityRecord AccessibilityRecord} to the end of event records.
 *
 * @param record The record to append.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void appendRecord(android.view.accessibility.AccessibilityRecord record) { throw new RuntimeException("Stub!"); }

/**
 * Gets the record at a given index.
 *
 * @param index The index.
 * @return The record at the specified index.
 * @apiSince 14
 */

public android.view.accessibility.AccessibilityRecord getRecord(int index) { throw new RuntimeException("Stub!"); }

/**
 * Gets the event type.
 *
 * @return The event type.
 
 * Value is either <code>0</code> or a combination of {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_CLICKED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_LONG_CLICKED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_SELECTED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_FOCUSED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_TEXT_CHANGED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_WINDOW_STATE_CHANGED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_NOTIFICATION_STATE_CHANGED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_HOVER_ENTER}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_HOVER_EXIT}, {@link android.view.accessibility.AccessibilityEvent#TYPE_TOUCH_EXPLORATION_GESTURE_START}, {@link android.view.accessibility.AccessibilityEvent#TYPE_TOUCH_EXPLORATION_GESTURE_END}, {@link android.view.accessibility.AccessibilityEvent#TYPE_WINDOW_CONTENT_CHANGED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_SCROLLED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_TEXT_SELECTION_CHANGED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_ANNOUNCEMENT}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_ACCESSIBILITY_FOCUSED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY}, {@link android.view.accessibility.AccessibilityEvent#TYPE_GESTURE_DETECTION_START}, {@link android.view.accessibility.AccessibilityEvent#TYPE_GESTURE_DETECTION_END}, {@link android.view.accessibility.AccessibilityEvent#TYPE_TOUCH_INTERACTION_START}, {@link android.view.accessibility.AccessibilityEvent#TYPE_TOUCH_INTERACTION_END}, {@link android.view.accessibility.AccessibilityEvent#TYPE_WINDOWS_CHANGED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_CONTEXT_CLICKED}, and {@link android.view.accessibility.AccessibilityEvent#TYPE_ASSIST_READING_CONTEXT}
 * @apiSince 4
 */

public int getEventType() { throw new RuntimeException("Stub!"); }

/**
 * Gets the bit mask of change types signaled by a
 * {@link #TYPE_WINDOW_CONTENT_CHANGED} event or {@link #TYPE_WINDOW_STATE_CHANGED}. A single
 * event may represent multiple change types.
 *
 * @return The bit mask of change types. One or more of:
 *         <ul>
 *         <li>{@link #CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION}
 *         <li>{@link #CONTENT_CHANGE_TYPE_SUBTREE}
 *         <li>{@link #CONTENT_CHANGE_TYPE_TEXT}
 *         <li>{@link #CONTENT_CHANGE_TYPE_PANE_TITLE}
 *         <li>{@link #CONTENT_CHANGE_TYPE_UNDEFINED}
 *         <li>{@link #CONTENT_CHANGE_TYPE_PANE_APPEARED}
 *         <li>{@link #CONTENT_CHANGE_TYPE_PANE_DISAPPEARED}
 *         </ul>
 
 * Value is either <code>0</code> or a combination of {@link android.view.accessibility.AccessibilityEvent#CONTENT_CHANGE_TYPE_UNDEFINED}, {@link android.view.accessibility.AccessibilityEvent#CONTENT_CHANGE_TYPE_SUBTREE}, {@link android.view.accessibility.AccessibilityEvent#CONTENT_CHANGE_TYPE_TEXT}, {@link android.view.accessibility.AccessibilityEvent#CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION}, {@link android.view.accessibility.AccessibilityEvent#CONTENT_CHANGE_TYPE_PANE_TITLE}, {@link android.view.accessibility.AccessibilityEvent#CONTENT_CHANGE_TYPE_PANE_APPEARED}, and {@link android.view.accessibility.AccessibilityEvent#CONTENT_CHANGE_TYPE_PANE_DISAPPEARED}
 * @apiSince 19
 */

public int getContentChangeTypes() { throw new RuntimeException("Stub!"); }

/**
 * Sets the bit mask of node tree changes signaled by an
 * {@link #TYPE_WINDOW_CONTENT_CHANGED} event.
 *
 * @param changeTypes The bit mask of change types.
 * Value is either <code>0</code> or a combination of {@link android.view.accessibility.AccessibilityEvent#CONTENT_CHANGE_TYPE_UNDEFINED}, {@link android.view.accessibility.AccessibilityEvent#CONTENT_CHANGE_TYPE_SUBTREE}, {@link android.view.accessibility.AccessibilityEvent#CONTENT_CHANGE_TYPE_TEXT}, {@link android.view.accessibility.AccessibilityEvent#CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION}, {@link android.view.accessibility.AccessibilityEvent#CONTENT_CHANGE_TYPE_PANE_TITLE}, {@link android.view.accessibility.AccessibilityEvent#CONTENT_CHANGE_TYPE_PANE_APPEARED}, and {@link android.view.accessibility.AccessibilityEvent#CONTENT_CHANGE_TYPE_PANE_DISAPPEARED}
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @see #getContentChangeTypes()
 * @apiSince 19
 */

public void setContentChangeTypes(int changeTypes) { throw new RuntimeException("Stub!"); }

/**
 * Get the bit mask of change types signaled by a {@link #TYPE_WINDOWS_CHANGED} event. A
 * single event may represent multiple change types.
 *
 * @return The bit mask of change types.
 
 * Value is either <code>0</code> or a combination of {@link android.view.accessibility.AccessibilityEvent#WINDOWS_CHANGE_ADDED}, {@link android.view.accessibility.AccessibilityEvent#WINDOWS_CHANGE_REMOVED}, {@link android.view.accessibility.AccessibilityEvent#WINDOWS_CHANGE_TITLE}, {@link android.view.accessibility.AccessibilityEvent#WINDOWS_CHANGE_BOUNDS}, {@link android.view.accessibility.AccessibilityEvent#WINDOWS_CHANGE_LAYER}, {@link android.view.accessibility.AccessibilityEvent#WINDOWS_CHANGE_ACTIVE}, {@link android.view.accessibility.AccessibilityEvent#WINDOWS_CHANGE_FOCUSED}, {@link android.view.accessibility.AccessibilityEvent#WINDOWS_CHANGE_ACCESSIBILITY_FOCUSED}, {@link android.view.accessibility.AccessibilityEvent#WINDOWS_CHANGE_PARENT}, {@link android.view.accessibility.AccessibilityEvent#WINDOWS_CHANGE_CHILDREN}, and {@link android.view.accessibility.AccessibilityEvent#WINDOWS_CHANGE_PIP}
 * @apiSince 28
 */

public int getWindowChanges() { throw new RuntimeException("Stub!"); }

/**
 * Sets the event type.
 *
 * @param eventType The event type.
 *
 * Value is either <code>0</code> or a combination of {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_CLICKED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_LONG_CLICKED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_SELECTED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_FOCUSED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_TEXT_CHANGED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_WINDOW_STATE_CHANGED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_NOTIFICATION_STATE_CHANGED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_HOVER_ENTER}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_HOVER_EXIT}, {@link android.view.accessibility.AccessibilityEvent#TYPE_TOUCH_EXPLORATION_GESTURE_START}, {@link android.view.accessibility.AccessibilityEvent#TYPE_TOUCH_EXPLORATION_GESTURE_END}, {@link android.view.accessibility.AccessibilityEvent#TYPE_WINDOW_CONTENT_CHANGED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_SCROLLED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_TEXT_SELECTION_CHANGED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_ANNOUNCEMENT}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_ACCESSIBILITY_FOCUSED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY}, {@link android.view.accessibility.AccessibilityEvent#TYPE_GESTURE_DETECTION_START}, {@link android.view.accessibility.AccessibilityEvent#TYPE_GESTURE_DETECTION_END}, {@link android.view.accessibility.AccessibilityEvent#TYPE_TOUCH_INTERACTION_START}, {@link android.view.accessibility.AccessibilityEvent#TYPE_TOUCH_INTERACTION_END}, {@link android.view.accessibility.AccessibilityEvent#TYPE_WINDOWS_CHANGED}, {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_CONTEXT_CLICKED}, and {@link android.view.accessibility.AccessibilityEvent#TYPE_ASSIST_READING_CONTEXT}
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 4
 */

public void setEventType(int eventType) { throw new RuntimeException("Stub!"); }

/**
 * Gets the time in which this event was sent.
 *
 * @return The event time.
 * @apiSince 4
 */

public long getEventTime() { throw new RuntimeException("Stub!"); }

/**
 * Sets the time in which this event was sent.
 *
 * @param eventTime The event time.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 4
 */

public void setEventTime(long eventTime) { throw new RuntimeException("Stub!"); }

/**
 * Gets the package name of the source.
 *
 * @return The package name.
 * @apiSince 4
 */

public java.lang.CharSequence getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Sets the package name of the source.
 *
 * @param packageName The package name.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 4
 */

public void setPackageName(java.lang.CharSequence packageName) { throw new RuntimeException("Stub!"); }

/**
 * Sets the movement granularity that was traversed.
 *
 * @param granularity The granularity.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 16
 */

public void setMovementGranularity(int granularity) { throw new RuntimeException("Stub!"); }

/**
 * Gets the movement granularity that was traversed.
 *
 * @return The granularity.
 * @apiSince 16
 */

public int getMovementGranularity() { throw new RuntimeException("Stub!"); }

/**
 * Sets the performed action that triggered this event.
 * <p>
 * Valid actions are defined in {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo}:
 * <ul>
 * <li>{@link android.view.accessibility.AccessibilityNodeInfo#ACTION_ACCESSIBILITY_FOCUS AccessibilityNodeInfo#ACTION_ACCESSIBILITY_FOCUS}
 * <li>{@link android.view.accessibility.AccessibilityNodeInfo#ACTION_CLEAR_ACCESSIBILITY_FOCUS AccessibilityNodeInfo#ACTION_CLEAR_ACCESSIBILITY_FOCUS}
 * <li>{@link android.view.accessibility.AccessibilityNodeInfo#ACTION_CLEAR_FOCUS AccessibilityNodeInfo#ACTION_CLEAR_FOCUS}
 * <li>{@link android.view.accessibility.AccessibilityNodeInfo#ACTION_CLEAR_SELECTION AccessibilityNodeInfo#ACTION_CLEAR_SELECTION}
 * <li>{@link android.view.accessibility.AccessibilityNodeInfo#ACTION_CLICK AccessibilityNodeInfo#ACTION_CLICK}
 * <li>etc.
 * </ul>
 *
 * @param action The action.
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @see android.view.accessibility.AccessibilityNodeInfo#performAction(int)
 * @apiSince 16
 */

public void setAction(int action) { throw new RuntimeException("Stub!"); }

/**
 * Gets the performed action that triggered this event.
 *
 * @return The action.
 * @apiSince 16
 */

public int getAction() { throw new RuntimeException("Stub!"); }

/**
 * Returns a cached instance if such is available or a new one is
 * instantiated with its type property set.
 *
 * @param eventType The event type.
 * @return An instance.
 * @apiSince 4
 */

public static android.view.accessibility.AccessibilityEvent obtain(int eventType) { throw new RuntimeException("Stub!"); }

/**
 * Returns a cached instance if such is available or a new one is
 * created. The returned instance is initialized from the given
 * <code>event</code>.
 *
 * @param event The other event.
 * @return An instance.
 * @apiSince 14
 */

public static android.view.accessibility.AccessibilityEvent obtain(android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Returns a cached instance if such is available or a new one is
 * instantiated.
 *
 * @return An instance.
 * @apiSince 4
 */

public static android.view.accessibility.AccessibilityEvent obtain() { throw new RuntimeException("Stub!"); }

/**
 * Recycles an instance back to be reused.
 * <p>
 *   <b>Note: You must not touch the object after calling this function.</b>
 * </p>
 *
 * @throws java.lang.IllegalStateException If the event is already recycled.
 * @apiSince 4
 */

public void recycle() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new instance from a {@link android.os.Parcel Parcel}.
 *
 * @param parcel A parcel containing the state of a {@link android.view.accessibility.AccessibilityEvent AccessibilityEvent}.
 * @apiSince 4
 */

public void initFromParcel(android.os.Parcel parcel) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 4
 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 4
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of an event type. For example,
 * {@link #TYPE_VIEW_CLICKED} is represented by the string TYPE_VIEW_CLICKED.
 *
 * @param eventType The event type
 * @return The string representation.
 * @apiSince 14
 */

public static java.lang.String eventTypeToString(int eventType) { throw new RuntimeException("Stub!"); }

/**
 * Change type for {@link #TYPE_WINDOW_CONTENT_CHANGED} event:
 * The node's content description changed.
 * @apiSince 19
 */

public static final int CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION = 4; // 0x4

/**
 * Change type for {@link #TYPE_WINDOW_STATE_CHANGED} event:
 * The node has a pane title, and either just appeared or just was assigned a title when it
 * had none before.
 * @apiSince 28
 */

public static final int CONTENT_CHANGE_TYPE_PANE_APPEARED = 16; // 0x10

/**
 * Change type for {@link #TYPE_WINDOW_STATE_CHANGED} event:
 * Can mean one of two slightly different things. The primary meaning is that the node has
 * a pane title, and was removed from the node hierarchy. It will also be sent if the pane
 * title is set to {@code null} after it contained a title.
 * No source will be returned if the node is no longer on the screen. To make the change more
 * clear for the user, the first entry in {@link #getText()} will return the value that would
 * have been returned by {@code getSource().getPaneTitle()}.
 * @apiSince 28
 */

public static final int CONTENT_CHANGE_TYPE_PANE_DISAPPEARED = 32; // 0x20

/**
 * Change type for {@link #TYPE_WINDOW_STATE_CHANGED} event:
 * The node's pane title changed.
 * @apiSince 28
 */

public static final int CONTENT_CHANGE_TYPE_PANE_TITLE = 8; // 0x8

/**
 * Change type for {@link #TYPE_WINDOW_CONTENT_CHANGED} event:
 * One or more content changes occurred in the the subtree rooted at the source node,
 * or the subtree's structure changed when a node was added or removed.
 * @apiSince 19
 */

public static final int CONTENT_CHANGE_TYPE_SUBTREE = 1; // 0x1

/**
 * Change type for {@link #TYPE_WINDOW_CONTENT_CHANGED} event:
 * The node's text changed.
 * @apiSince 19
 */

public static final int CONTENT_CHANGE_TYPE_TEXT = 2; // 0x2

/**
 * Change type for {@link #TYPE_WINDOW_CONTENT_CHANGED} event:
 * The type of change is not defined.
 * @apiSince 19
 */

public static final int CONTENT_CHANGE_TYPE_UNDEFINED = 0; // 0x0

/**
 * @see android.os.Parcelable.Creator
 * @apiSince 4
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.accessibility.AccessibilityEvent> CREATOR;
static { CREATOR = null; }

/**
 * Invalid selection/focus position.
 *
 * @see #getCurrentItemIndex()
 * @apiSince 4
 */

public static final int INVALID_POSITION = -1; // 0xffffffff

/**
 * Maximum length of the text fields.
 *
 * @see #getBeforeText()
 * @see #getText()
 * </br>
 * Note: This constant is no longer needed since there
 *       is no limit on the length of text that is contained
 *       in an accessibility event anymore.
 * @apiSince 4
 * @deprecatedSince 15
 */

@Deprecated public static final int MAX_TEXT_LENGTH = 500; // 0x1f4

/**
 * Mask for {@link android.view.accessibility.AccessibilityEvent AccessibilityEvent} all types.
 *
 * @see #TYPE_VIEW_CLICKED
 * @see #TYPE_VIEW_LONG_CLICKED
 * @see #TYPE_VIEW_SELECTED
 * @see #TYPE_VIEW_FOCUSED
 * @see #TYPE_VIEW_TEXT_CHANGED
 * @see #TYPE_WINDOW_STATE_CHANGED
 * @see #TYPE_NOTIFICATION_STATE_CHANGED
 * @see #TYPE_VIEW_HOVER_ENTER
 * @see #TYPE_VIEW_HOVER_EXIT
 * @see #TYPE_TOUCH_EXPLORATION_GESTURE_START
 * @see #TYPE_TOUCH_EXPLORATION_GESTURE_END
 * @see #TYPE_WINDOW_CONTENT_CHANGED
 * @see #TYPE_VIEW_SCROLLED
 * @see #TYPE_VIEW_TEXT_SELECTION_CHANGED
 * @see #TYPE_ANNOUNCEMENT
 * @see #TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY
 * @see #TYPE_GESTURE_DETECTION_START
 * @see #TYPE_GESTURE_DETECTION_END
 * @see #TYPE_TOUCH_INTERACTION_START
 * @see #TYPE_TOUCH_INTERACTION_END
 * @see #TYPE_WINDOWS_CHANGED
 * @see #TYPE_VIEW_CONTEXT_CLICKED
 * @apiSince 4
 */

public static final int TYPES_ALL_MASK = -1; // 0xffffffff

/**
 * Represents the event of an application making an announcement.
 * @apiSince 16
 */

public static final int TYPE_ANNOUNCEMENT = 16384; // 0x4000

/**
 * Represents the event of the assistant currently reading the users screen context.
 * @apiSince 23
 */

public static final int TYPE_ASSIST_READING_CONTEXT = 16777216; // 0x1000000

/**
 * Represents the event of ending gesture detection.
 * @apiSince 17
 */

public static final int TYPE_GESTURE_DETECTION_END = 524288; // 0x80000

/**
 * Represents the event of beginning gesture detection.
 * @apiSince 17
 */

public static final int TYPE_GESTURE_DETECTION_START = 262144; // 0x40000

/**
 * Represents the event showing a {@link android.app.Notification}.
 * @apiSince 4
 */

public static final int TYPE_NOTIFICATION_STATE_CHANGED = 64; // 0x40

/**
 * Represents the event of ending a touch exploration gesture.
 * @apiSince 14
 */

public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024; // 0x400

/**
 * Represents the event of starting a touch exploration gesture.
 * @apiSince 14
 */

public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512; // 0x200

/**
 * Represents the event of the user ending to touch the screen.
 * @apiSince 17
 */

public static final int TYPE_TOUCH_INTERACTION_END = 2097152; // 0x200000

/**
 * Represents the event of the user starting to touch the screen.
 * @apiSince 17
 */

public static final int TYPE_TOUCH_INTERACTION_START = 1048576; // 0x100000

/**
 * Represents the event of gaining accessibility focus.
 * @apiSince 16
 */

public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768; // 0x8000

/**
 * Represents the event of clearing accessibility focus.
 * @apiSince 16
 */

public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536; // 0x10000

/**
 * Represents the event of clicking on a {@link android.view.View} like
 * {@link android.widget.Button}, {@link android.widget.CompoundButton}, etc.
 * @apiSince 4
 */

public static final int TYPE_VIEW_CLICKED = 1; // 0x1

/**
 * Represents the event of a context click on a {@link android.view.View}.
 * @apiSince 23
 */

public static final int TYPE_VIEW_CONTEXT_CLICKED = 8388608; // 0x800000

/**
 * Represents the event of setting input focus of a {@link android.view.View}.
 * @apiSince 4
 */

public static final int TYPE_VIEW_FOCUSED = 8; // 0x8

/**
 * Represents the event of a hover enter over a {@link android.view.View}.
 * @apiSince 14
 */

public static final int TYPE_VIEW_HOVER_ENTER = 128; // 0x80

/**
 * Represents the event of a hover exit over a {@link android.view.View}.
 * @apiSince 14
 */

public static final int TYPE_VIEW_HOVER_EXIT = 256; // 0x100

/**
 * Represents the event of long clicking on a {@link android.view.View} like
 * {@link android.widget.Button}, {@link android.widget.CompoundButton}, etc.
 * @apiSince 4
 */

public static final int TYPE_VIEW_LONG_CLICKED = 2; // 0x2

/**
 * Represents the event of scrolling a view. This event type is generally not sent directly.
 * @see android.view.View#onScrollChanged(int, int, int, int)
 * @apiSince 14
 */

public static final int TYPE_VIEW_SCROLLED = 4096; // 0x1000

/**
 * Represents the event of selecting an item usually in the context of an
 * {@link android.widget.AdapterView}.
 * @apiSince 4
 */

public static final int TYPE_VIEW_SELECTED = 4; // 0x4

/**
 * Represents the event of changing the text of an {@link android.widget.EditText}.
 * @apiSince 4
 */

public static final int TYPE_VIEW_TEXT_CHANGED = 16; // 0x10

/**
 * Represents the event of changing the selection in an {@link android.widget.EditText}.
 * @apiSince 14
 */

public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192; // 0x2000

/**
 * Represents the event of traversing the text of a view at a given movement granularity.
 * @apiSince 16
 */

public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072; // 0x20000

/**
 * Represents the event change in the system windows shown on the screen. This event type should
 * only be dispatched by the system.
 * @apiSince 21
 */

public static final int TYPE_WINDOWS_CHANGED = 4194304; // 0x400000

/**
 * Represents the event of changing the content of a window and more
 * specifically the sub-tree rooted at the event's source.
 * @apiSince 14
 */

public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048; // 0x800

/**
 * Represents the event of a change to a visually distinct section of the user interface.
 * These events should only be dispatched from {@link android.view.View}s that have
 * accessibility pane titles, and replaces {@link #TYPE_WINDOW_CONTENT_CHANGED} for those
 * sources. Details about the change are available from {@link #getContentChangeTypes()}.
 * @apiSince 4
 */

public static final int TYPE_WINDOW_STATE_CHANGED = 32; // 0x20

/**
 * Change type for {@link #TYPE_WINDOWS_CHANGED} event:
 * The window's {@link android.view.accessibility.AccessibilityWindowInfo#isAccessibilityFocused() AccessibilityWindowInfo#isAccessibilityFocused()} changed.
 * @apiSince 28
 */

public static final int WINDOWS_CHANGE_ACCESSIBILITY_FOCUSED = 128; // 0x80

/**
 * Change type for {@link #TYPE_WINDOWS_CHANGED} event:
 * The window's {@link android.view.accessibility.AccessibilityWindowInfo#isActive() AccessibilityWindowInfo#isActive()} changed.
 * @apiSince 28
 */

public static final int WINDOWS_CHANGE_ACTIVE = 32; // 0x20

/**
 * Change type for {@link #TYPE_WINDOWS_CHANGED} event:
 * The window was added.
 * @apiSince 28
 */

public static final int WINDOWS_CHANGE_ADDED = 1; // 0x1

/**
 * Change type for {@link #TYPE_WINDOWS_CHANGED} event:
 * The window's bounds changed.
 * @apiSince 28
 */

public static final int WINDOWS_CHANGE_BOUNDS = 8; // 0x8

/**
 * Change type for {@link #TYPE_WINDOWS_CHANGED} event:
 * The window's children changed.
 * @apiSince 28
 */

public static final int WINDOWS_CHANGE_CHILDREN = 512; // 0x200

/**
 * Change type for {@link #TYPE_WINDOWS_CHANGED} event:
 * The window's {@link android.view.accessibility.AccessibilityWindowInfo#isFocused() AccessibilityWindowInfo#isFocused()} changed.
 * @apiSince 28
 */

public static final int WINDOWS_CHANGE_FOCUSED = 64; // 0x40

/**
 * Change type for {@link #TYPE_WINDOWS_CHANGED} event:
 * The window's layer changed.
 * @apiSince 28
 */

public static final int WINDOWS_CHANGE_LAYER = 16; // 0x10

/**
 * Change type for {@link #TYPE_WINDOWS_CHANGED} event:
 * The window's parent changed.
 * @apiSince 28
 */

public static final int WINDOWS_CHANGE_PARENT = 256; // 0x100

/**
 * Change type for {@link #TYPE_WINDOWS_CHANGED} event:
 * The window either entered or exited picture-in-picture mode.
 * @apiSince 28
 */

public static final int WINDOWS_CHANGE_PIP = 1024; // 0x400

/**
 * Change type for {@link #TYPE_WINDOWS_CHANGED} event:
 * A window was removed.
 * @apiSince 28
 */

public static final int WINDOWS_CHANGE_REMOVED = 2; // 0x2

/**
 * Change type for {@link #TYPE_WINDOWS_CHANGED} event:
 * The window's title changed.
 * @apiSince 28
 */

public static final int WINDOWS_CHANGE_TITLE = 4; // 0x4
}

