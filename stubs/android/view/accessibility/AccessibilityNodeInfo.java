/*
 * Copyright (C) 2011 The Android Open Source Project
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

import android.accessibilityservice.AccessibilityService;
import android.view.View;
import android.os.Bundle;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.graphics.Rect;
import android.text.style.URLSpan;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.InputType;
import android.graphics.Region;
import android.view.TouchDelegate;
import android.os.Parcelable;

/**
 * This class represents a node of the window content as well as actions that
 * can be requested from its source. From the point of view of an
 * {@link android.accessibilityservice.AccessibilityService} a window's content is
 * presented as a tree of accessibility node infos, which may or may not map one-to-one
 * to the view hierarchy. In other words, a custom view is free to report itself as
 * a tree of accessibility node info.
 * </p>
 * <p>
 * Once an accessibility node info is delivered to an accessibility service it is
 * made immutable and calling a state mutation method generates an error.
 * </p>
 * <p>
 * Please refer to {@link android.accessibilityservice.AccessibilityService} for
 * details about how to obtain a handle to window content as a tree of accessibility
 * node info as well as details about the security model.
 * </p>
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about making applications accessible, read the
 * <a href="{@docRoot}guide/topics/ui/accessibility/index.html">Accessibility</a>
 * developer guide.</p>
 * </div>
 *
 * @see android.accessibilityservice.AccessibilityService
 * @see android.view.accessibility.AccessibilityEvent
 * @see android.view.accessibility.AccessibilityManager
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AccessibilityNodeInfo implements android.os.Parcelable {

AccessibilityNodeInfo() { throw new RuntimeException("Stub!"); }

/**
 * Sets the source.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param source The info source.
 * @apiSince 14
 */

public void setSource(android.view.View source) { throw new RuntimeException("Stub!"); }

/**
 * Sets the source to be a virtual descendant of the given <code>root</code>.
 * If <code>virtualDescendantId</code> is {@link android.view.View#NO_ID View#NO_ID} the root
 * is set as the source.
 * <p>
 * A virtual descendant is an imaginary View that is reported as a part of the view
 * hierarchy for accessibility purposes. This enables custom views that draw complex
 * content to report themselves as a tree of virtual views, thus conveying their
 * logical structure.
 * </p>
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param root The root of the virtual subtree.
 * @param virtualDescendantId The id of the virtual descendant.
 * @apiSince 16
 */

public void setSource(android.view.View root, int virtualDescendantId) { throw new RuntimeException("Stub!"); }

/**
 * Find the view that has the specified focus type. The search starts from
 * the view represented by this node info.
 *
 * @param focus The focus to find. One of {@link #FOCUS_INPUT} or
 *         {@link #FOCUS_ACCESSIBILITY}.
 * @return The node info of the focused view or null.
 *
 * @see #FOCUS_INPUT
 * @see #FOCUS_ACCESSIBILITY
 * @apiSince 16
 */

public android.view.accessibility.AccessibilityNodeInfo findFocus(int focus) { throw new RuntimeException("Stub!"); }

/**
 * Searches for the nearest view in the specified direction that can take
 * the input focus.
 *
 * @param direction The direction. Can be one of:
 *     {@link android.view.View#FOCUS_DOWN View#FOCUS_DOWN},
 *     {@link android.view.View#FOCUS_UP View#FOCUS_UP},
 *     {@link android.view.View#FOCUS_LEFT View#FOCUS_LEFT},
 *     {@link android.view.View#FOCUS_RIGHT View#FOCUS_RIGHT},
 *     {@link android.view.View#FOCUS_FORWARD View#FOCUS_FORWARD},
 *     {@link android.view.View#FOCUS_BACKWARD View#FOCUS_BACKWARD}.
 *
 * @return The node info for the view that can take accessibility focus.
 * @apiSince 16
 */

public android.view.accessibility.AccessibilityNodeInfo focusSearch(int direction) { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of the window from which the info comes from.
 *
 * @return The window id.
 * @apiSince 14
 */

public int getWindowId() { throw new RuntimeException("Stub!"); }

/**
 * Refreshes this info with the latest state of the view it represents.
 *
 * @return {@code true} if the refresh succeeded. {@code false} if the {@link android.view.View View} represented
 * by this node is no longer in the view tree (and thus this node is obsolete and should be
 * recycled).
 * @apiSince 18
 */

public boolean refresh() { throw new RuntimeException("Stub!"); }

/**
 * Refreshes this info with the latest state of the view it represents, and request new
 * data be added by the View.
 *
 * @param extraDataKey The extra data requested. Data that must be requested
 *                     with this mechanism is generally expensive to retrieve, so should only be
 *                     requested when needed. See
 *                     {@link #EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY} and
 *                     {@link #getAvailableExtraData()}.
 * @param args A bundle of arguments for the request. These depend on the particular request.
 *
 * @return {@code true} if the refresh succeeded. {@code false} if the {@link android.view.View View} represented
 * by this node is no longer in the view tree (and thus this node is obsolete and should be
 * recycled).
 * @apiSince 26
 */

public boolean refreshWithExtraData(java.lang.String extraDataKey, android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of children.
 *
 * @return The child count.
 * @apiSince 14
 */

public int getChildCount() { throw new RuntimeException("Stub!"); }

/**
 * Get the child at given index.
 * <p>
 *   <strong>Note:</strong> It is a client responsibility to recycle the
 *     received info by calling {@link android.view.accessibility.AccessibilityNodeInfo#recycle() AccessibilityNodeInfo#recycle()}
 *     to avoid creating of multiple instances.
 * </p>
 *
 * @param index The child index.
 * @return The child node.
 *
 * @throws java.lang.IllegalStateException If called outside of an AccessibilityService.
 *
 * @apiSince 14
 */

public android.view.accessibility.AccessibilityNodeInfo getChild(int index) { throw new RuntimeException("Stub!"); }

/**
 * Adds a child.
 * <p>
 * <strong>Note:</strong> Cannot be called from an
 * {@link android.accessibilityservice.AccessibilityService}.
 * This class is made immutable before being delivered to an AccessibilityService.
 * Note that a view cannot be made its own child.
 * </p>
 *
 * @param child The child.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void addChild(android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * Removes a child. If the child was not previously added to the node,
 * calling this method has no effect.
 * <p>
 * <strong>Note:</strong> Cannot be called from an
 * {@link android.accessibilityservice.AccessibilityService}.
 * This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param child The child.
 * @return true if the child was present
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 21
 */

public boolean removeChild(android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * Adds a virtual child which is a descendant of the given <code>root</code>.
 * If <code>virtualDescendantId</code> is {@link android.view.View#NO_ID View#NO_ID} the root
 * is added as a child.
 * <p>
 * A virtual descendant is an imaginary View that is reported as a part of the view
 * hierarchy for accessibility purposes. This enables custom views that draw complex
 * content to report them selves as a tree of virtual views, thus conveying their
 * logical structure.
 * Note that a view cannot be made its own child.
 * </p>
 *
 * @param root The root of the virtual subtree.
 * @param virtualDescendantId The id of the virtual child.
 * @apiSince 16
 */

public void addChild(android.view.View root, int virtualDescendantId) { throw new RuntimeException("Stub!"); }

/**
 * Removes a virtual child which is a descendant of the given
 * <code>root</code>. If the child was not previously added to the node,
 * calling this method has no effect.
 *
 * @param root The root of the virtual subtree.
 * @param virtualDescendantId The id of the virtual child.
 * @return true if the child was present
 * @see #addChild(View, int)
 * @apiSince 21
 */

public boolean removeChild(android.view.View root, int virtualDescendantId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the actions that can be performed on the node.
 * @apiSince 21
 */

public java.util.List<android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction> getActionList() { throw new RuntimeException("Stub!"); }

/**
 * Gets the actions that can be performed on the node.
 *
 * @return The bit mask of with actions.
 *
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_FOCUS
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_CLEAR_FOCUS
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_SELECT
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_CLEAR_SELECTION
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_ACCESSIBILITY_FOCUS
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_CLEAR_ACCESSIBILITY_FOCUS
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_CLICK
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_LONG_CLICK
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_NEXT_AT_MOVEMENT_GRANULARITY
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_NEXT_HTML_ELEMENT
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_PREVIOUS_HTML_ELEMENT
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_SCROLL_FORWARD
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_SCROLL_BACKWARD
 *
 * @deprecated Use {@link #getActionList()}.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public int getActions() { throw new RuntimeException("Stub!"); }

/**
 * Adds an action that can be performed on the node.
 * <p>
 * To add a standard action use the static constants on {@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction AccessibilityAction}.
 * To add a custom action create a new {@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction AccessibilityAction} by passing in a
 * resource id from your application as the action id and an optional label that
 * describes the action. To override one of the standard actions use as the action
 * id of a standard action id such as {@link #ACTION_CLICK} and an optional label that
 * describes the action.
 * </p>
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param action The action.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 21
 */

public void addAction(android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction action) { throw new RuntimeException("Stub!"); }

/**
 * Adds an action that can be performed on the node.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param action The action.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @throws java.lang.IllegalArgumentException If the argument is not one of the standard actions.
 *
 * @deprecated This has been deprecated for {@link #addAction(android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction)}
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public void addAction(int action) { throw new RuntimeException("Stub!"); }

/**
 * Removes an action that can be performed on the node. If the action was
 * not already added to the node, calling this method has no effect.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param action The action to be removed.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @deprecated Use {@link #removeAction(android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction)}
 * @apiSince 21
 * @deprecatedSince 21
 */

@Deprecated
public void removeAction(int action) { throw new RuntimeException("Stub!"); }

/**
 * Removes an action that can be performed on the node. If the action was
 * not already added to the node, calling this method has no effect.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param action The action to be removed.
 * @return The action removed from the list of actions.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 21
 */

public boolean removeAction(android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction action) { throw new RuntimeException("Stub!"); }

/**
 * Gets the node before which this one is visited during traversal. A screen-reader
 * must visit the content of this node before the content of the one it precedes.
 *
 * @return The succeeding node if such or <code>null</code>.
 *
 * @see #setTraversalBefore(android.view.View)
 * @see #setTraversalBefore(android.view.View, int)
 * @apiSince 22
 */

public android.view.accessibility.AccessibilityNodeInfo getTraversalBefore() { throw new RuntimeException("Stub!"); }

/**
 * Sets the view before whose node this one should be visited during traversal. A
 * screen-reader must visit the content of this node before the content of the one
 * it precedes.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param view The view providing the preceding node.
 *
 * @see #getTraversalBefore()
 * @apiSince 22
 */

public void setTraversalBefore(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Sets the node before which this one is visited during traversal. A screen-reader
 * must visit the content of this node before the content of the one it precedes.
 * The successor is a virtual descendant of the given <code>root</code>. If
 * <code>virtualDescendantId</code> equals to {@link android.view.View#NO_ID View#NO_ID} the root is set
 * as the successor.
 * <p>
 * A virtual descendant is an imaginary View that is reported as a part of the view
 * hierarchy for accessibility purposes. This enables custom views that draw complex
 * content to report them selves as a tree of virtual views, thus conveying their
 * logical structure.
 * </p>
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param root The root of the virtual subtree.
 * @param virtualDescendantId The id of the virtual descendant.
 * @apiSince 22
 */

public void setTraversalBefore(android.view.View root, int virtualDescendantId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the node after which this one is visited in accessibility traversal.
 * A screen-reader must visit the content of the other node before the content
 * of this one.
 *
 * @return The succeeding node if such or <code>null</code>.
 *
 * @see #setTraversalAfter(android.view.View)
 * @see #setTraversalAfter(android.view.View, int)
 * @apiSince 22
 */

public android.view.accessibility.AccessibilityNodeInfo getTraversalAfter() { throw new RuntimeException("Stub!"); }

/**
 * Sets the view whose node is visited after this one in accessibility traversal.
 * A screen-reader must visit the content of the other node before the content
 * of this one.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param view The previous view.
 *
 * @see #getTraversalAfter()
 * @apiSince 22
 */

public void setTraversalAfter(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Sets the node after which this one is visited in accessibility traversal.
 * A screen-reader must visit the content of the other node before the content
 * of this one. If <code>virtualDescendantId</code> equals to {@link android.view.View#NO_ID View#NO_ID}
 * the root is set as the predecessor.
 * <p>
 * A virtual descendant is an imaginary View that is reported as a part of the view
 * hierarchy for accessibility purposes. This enables custom views that draw complex
 * content to report them selves as a tree of virtual views, thus conveying their
 * logical structure.
 * </p>
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param root The root of the virtual subtree.
 * @param virtualDescendantId The id of the virtual descendant.
 * @apiSince 22
 */

public void setTraversalAfter(android.view.View root, int virtualDescendantId) { throw new RuntimeException("Stub!"); }

/**
 * Get the extra data available for this node.
 * <p>
 * Some data that is useful for some accessibility services is expensive to compute, and would
 * place undue overhead on apps to compute all the time. That data can be requested with
 * {@link #refreshWithExtraData(java.lang.String,android.os.Bundle)}.
 *
 * @return An unmodifiable list of keys corresponding to extra data that can be requested.
 * @see #EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY
 * @apiSince 26
 */

public java.util.List<java.lang.String> getAvailableExtraData() { throw new RuntimeException("Stub!"); }

/**
 * Set the extra data available for this node.
 * <p>
 * <strong>Note:</strong> When a {@code View} passes in a non-empty list, it promises that
 * it will populate the node's extras with corresponding pieces of information in
 * {@link android.view.View#addExtraDataToAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo,java.lang.String,android.os.Bundle) View#addExtraDataToAccessibilityNodeInfo(AccessibilityNodeInfo, String, Bundle)}.
 * <p>
 * <strong>Note:</strong> Cannot be called from an
 * {@link android.accessibilityservice.AccessibilityService}.
 * This class is made immutable before being delivered to an AccessibilityService.
 *
 * @param extraDataKeys A list of types of extra data that are available.
 * @see #getAvailableExtraData()
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 26
 */

public void setAvailableExtraData(java.util.List<java.lang.String> extraDataKeys) { throw new RuntimeException("Stub!"); }

/**
 * Sets the maximum text length, or -1 for no limit.
 * <p>
 * Typically used to indicate that an editable text field has a limit on
 * the number of characters entered.
 * <p>
 * <strong>Note:</strong> Cannot be called from an
 * {@link android.accessibilityservice.AccessibilityService}.
 * This class is made immutable before being delivered to an AccessibilityService.
 *
 * @param max The maximum text length.
 * @see #getMaxTextLength()
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 21
 */

public void setMaxTextLength(int max) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum text length for this node.
 *
 * @return The maximum text length, or -1 for no limit.
 * @see #setMaxTextLength(int)
 * @apiSince 21
 */

public int getMaxTextLength() { throw new RuntimeException("Stub!"); }

/**
 * Sets the movement granularities for traversing the text of this node.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param granularities The bit mask with granularities.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 16
 */

public void setMovementGranularities(int granularities) { throw new RuntimeException("Stub!"); }

/**
 * Gets the movement granularities for traversing the text of this node.
 *
 * @return The bit mask with granularities.
 * @apiSince 16
 */

public int getMovementGranularities() { throw new RuntimeException("Stub!"); }

/**
 * Performs an action on the node.
 * <p>
 *   <strong>Note:</strong> An action can be performed only if the request is made
 *   from an {@link android.accessibilityservice.AccessibilityService}.
 * </p>
 *
 * @param action The action to perform.
 * @return True if the action was performed.
 *
 * @throws java.lang.IllegalStateException If called outside of an AccessibilityService.
 * @apiSince 14
 */

public boolean performAction(int action) { throw new RuntimeException("Stub!"); }

/**
 * Performs an action on the node.
 * <p>
 *   <strong>Note:</strong> An action can be performed only if the request is made
 *   from an {@link android.accessibilityservice.AccessibilityService}.
 * </p>
 *
 * @param action The action to perform.
 * @param arguments A bundle with additional arguments.
 * @return True if the action was performed.
 *
 * @throws java.lang.IllegalStateException If called outside of an AccessibilityService.
 * @apiSince 16
 */

public boolean performAction(int action, android.os.Bundle arguments) { throw new RuntimeException("Stub!"); }

/**
 * Finds {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo}s by text. The match is case
 * insensitive containment. The search is relative to this info i.e.
 * this info is the root of the traversed tree.
 *
 * <p>
 *   <strong>Note:</strong> It is a client responsibility to recycle the
 *     received info by calling {@link android.view.accessibility.AccessibilityNodeInfo#recycle() AccessibilityNodeInfo#recycle()}
 *     to avoid creating of multiple instances.
 * </p>
 *
 * @param text The searched text.
 * @return A list of node info.
 * @apiSince 14
 */

public java.util.List<android.view.accessibility.AccessibilityNodeInfo> findAccessibilityNodeInfosByText(java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Finds {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo}s by the fully qualified view id's resource
 * name where a fully qualified id is of the from "package:id/id_resource_name".
 * For example, if the target application's package is "foo.bar" and the id
 * resource name is "baz", the fully qualified resource id is "foo.bar:id/baz".
 *
 * <p>
 *   <strong>Note:</strong> It is a client responsibility to recycle the
 *     received info by calling {@link android.view.accessibility.AccessibilityNodeInfo#recycle() AccessibilityNodeInfo#recycle()}
 *     to avoid creating of multiple instances.
 * </p>
 * <p>
 *   <strong>Note:</strong> The primary usage of this API is for UI test automation
 *   and in order to report the fully qualified view id if an {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo}
 *   the client has to set the {@link android.accessibilityservice.AccessibilityServiceInfo#FLAG_REPORT_VIEW_IDS AccessibilityServiceInfo#FLAG_REPORT_VIEW_IDS}
 *   flag when configuring his {@link android.accessibilityservice.AccessibilityService}.
 * </p>
 *
 * @param viewId The fully qualified resource name of the view id to find.
 * @return A list of node info.
 * @apiSince 18
 */

public java.util.List<android.view.accessibility.AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId(java.lang.String viewId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the window to which this node belongs.
 *
 * @return The window.
 *
 * @see android.accessibilityservice.AccessibilityService#getWindows()
 * @apiSince 21
 */

public android.view.accessibility.AccessibilityWindowInfo getWindow() { throw new RuntimeException("Stub!"); }

/**
 * Gets the parent.
 * <p>
 *   <strong>Note:</strong> It is a client responsibility to recycle the
 *     received info by calling {@link android.view.accessibility.AccessibilityNodeInfo#recycle() AccessibilityNodeInfo#recycle()}
 *     to avoid creating of multiple instances.
 * </p>
 *
 * @return The parent.
 * @apiSince 14
 */

public android.view.accessibility.AccessibilityNodeInfo getParent() { throw new RuntimeException("Stub!"); }

/**
 * Sets the parent.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param parent The parent.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void setParent(android.view.View parent) { throw new RuntimeException("Stub!"); }

/**
 * Sets the parent to be a virtual descendant of the given <code>root</code>.
 * If <code>virtualDescendantId</code> equals to {@link android.view.View#NO_ID View#NO_ID} the root
 * is set as the parent.
 * <p>
 * A virtual descendant is an imaginary View that is reported as a part of the view
 * hierarchy for accessibility purposes. This enables custom views that draw complex
 * content to report them selves as a tree of virtual views, thus conveying their
 * logical structure.
 * </p>
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param root The root of the virtual subtree.
 * @param virtualDescendantId The id of the virtual descendant.
 * @apiSince 16
 */

public void setParent(android.view.View root, int virtualDescendantId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the node bounds in the viewParent's coordinates.
 * {@link #getParent()} does not represent the source's viewParent.
 * Instead it represents the result of {@link android.view.View#getParentForAccessibility() View#getParentForAccessibility()},
 * which returns the closest ancestor where {@link android.view.View#isImportantForAccessibility() View#isImportantForAccessibility()} is true.
 * So this method is not reliable.
 *
 * @param outBounds The output node bounds.
 * @deprecated Use {@link #getBoundsInScreen(android.graphics.Rect)} instead.
 *
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void getBoundsInParent(android.graphics.Rect outBounds) { throw new RuntimeException("Stub!"); }

/**
 * Sets the node bounds in the viewParent's coordinates.
 * {@link #getParent()} does not represent the source's viewParent.
 * Instead it represents the result of {@link android.view.View#getParentForAccessibility() View#getParentForAccessibility()},
 * which returns the closest ancestor where {@link android.view.View#isImportantForAccessibility() View#isImportantForAccessibility()} is true.
 * So this method is not reliable.
 *
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param bounds The node bounds.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @deprecated Accessibility services should not care about these bounds.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void setBoundsInParent(android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/**
 * Gets the node bounds in screen coordinates.
 *
 * @param outBounds The output node bounds.
 * @apiSince 14
 */

public void getBoundsInScreen(android.graphics.Rect outBounds) { throw new RuntimeException("Stub!"); }

/**
 * Sets the node bounds in screen coordinates.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param bounds The node bounds.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void setBoundsInScreen(android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this node is checkable.
 *
 * @return True if the node is checkable.
 * @apiSince 14
 */

public boolean isCheckable() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this node is checkable.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param checkable True if the node is checkable.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void setCheckable(boolean checkable) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this node is checked.
 *
 * @return True if the node is checked.
 * @apiSince 14
 */

public boolean isChecked() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this node is checked.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param checked True if the node is checked.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void setChecked(boolean checked) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this node is focusable.
 *
 * @return True if the node is focusable.
 * @apiSince 14
 */

public boolean isFocusable() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this node is focusable.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param focusable True if the node is focusable.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void setFocusable(boolean focusable) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this node is focused.
 *
 * @return True if the node is focused.
 * @apiSince 14
 */

public boolean isFocused() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this node is focused.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param focused True if the node is focused.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void setFocused(boolean focused) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this node is visible to the user.
 *
 * @return Whether the node is visible to the user.
 * @apiSince 16
 */

public boolean isVisibleToUser() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this node is visible to the user.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param visibleToUser Whether the node is visible to the user.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 16
 */

public void setVisibleToUser(boolean visibleToUser) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this node is accessibility focused.
 *
 * @return True if the node is accessibility focused.
 * @apiSince 16
 */

public boolean isAccessibilityFocused() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this node is accessibility focused.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param focused True if the node is accessibility focused.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 16
 */

public void setAccessibilityFocused(boolean focused) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this node is selected.
 *
 * @return True if the node is selected.
 * @apiSince 14
 */

public boolean isSelected() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this node is selected.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param selected True if the node is selected.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void setSelected(boolean selected) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this node is clickable.
 *
 * @return True if the node is clickable.
 * @apiSince 14
 */

public boolean isClickable() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this node is clickable.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param clickable True if the node is clickable.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void setClickable(boolean clickable) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this node is long clickable.
 *
 * @return True if the node is long clickable.
 * @apiSince 14
 */

public boolean isLongClickable() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this node is long clickable.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param longClickable True if the node is long clickable.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void setLongClickable(boolean longClickable) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this node is enabled.
 *
 * @return True if the node is enabled.
 * @apiSince 14
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this node is enabled.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param enabled True if the node is enabled.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this node is a password.
 *
 * @return True if the node is a password.
 * @apiSince 14
 */

public boolean isPassword() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this node is a password.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param password True if the node is a password.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void setPassword(boolean password) { throw new RuntimeException("Stub!"); }

/**
 * Gets if the node is scrollable.
 *
 * @return True if the node is scrollable, false otherwise.
 * @apiSince 14
 */

public boolean isScrollable() { throw new RuntimeException("Stub!"); }

/**
 * Sets if the node is scrollable.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param scrollable True if the node is scrollable, false otherwise.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void setScrollable(boolean scrollable) { throw new RuntimeException("Stub!"); }

/**
 * Gets if the node is editable.
 *
 * @return True if the node is editable, false otherwise.
 * @apiSince 18
 */

public boolean isEditable() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this node is editable.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param editable True if the node is editable.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 18
 */

public void setEditable(boolean editable) { throw new RuntimeException("Stub!"); }

/**
 * If this node represents a visually distinct region of the screen that may update separately
 * from the rest of the window, it is considered a pane. Set the pane title to indicate that
 * the node is a pane, and to provide a title for it.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 * @param paneTitle The title of the pane represented by this node.
 
 * This value may be {@code null}.
 * @apiSince 28
 */

public void setPaneTitle(@androidx.annotation.Nullable java.lang.CharSequence paneTitle) { throw new RuntimeException("Stub!"); }

/**
 * Get the title of the pane represented by this node.
 *
 * @return The title of the pane represented by this node, or {@code null} if this node does
 *         not represent a pane.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getPaneTitle() { throw new RuntimeException("Stub!"); }

/**
 * Get the drawing order of the view corresponding it this node.
 * <p>
 * Drawing order is determined only within the node's parent, so this index is only relative
 * to its siblings.
 * <p>
 * In some cases, the drawing order is essentially simultaneous, so it is possible for two
 * siblings to return the same value. It is also possible that values will be skipped.
 *
 * @return The drawing position of the view corresponding to this node relative to its siblings.
 * @apiSince 24
 */

public int getDrawingOrder() { throw new RuntimeException("Stub!"); }

/**
 * Set the drawing order of the view corresponding it this node.
 *
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 * @param drawingOrderInParent
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 24
 */

public void setDrawingOrder(int drawingOrderInParent) { throw new RuntimeException("Stub!"); }

/**
 * Gets the collection info if the node is a collection. A collection
 * child is always a collection item.
 *
 * @return The collection info.
 * @apiSince 19
 */

public android.view.accessibility.AccessibilityNodeInfo.CollectionInfo getCollectionInfo() { throw new RuntimeException("Stub!"); }

/**
 * Sets the collection info if the node is a collection. A collection
 * child is always a collection item.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param collectionInfo The collection info.
 * @apiSince 19
 */

public void setCollectionInfo(android.view.accessibility.AccessibilityNodeInfo.CollectionInfo collectionInfo) { throw new RuntimeException("Stub!"); }

/**
 * Gets the collection item info if the node is a collection item. A collection
 * item is always a child of a collection.
 *
 * @return The collection item info.
 * @apiSince 19
 */

public android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo getCollectionItemInfo() { throw new RuntimeException("Stub!"); }

/**
 * Sets the collection item info if the node is a collection item. A collection
 * item is always a child of a collection.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 * @apiSince 19
 */

public void setCollectionItemInfo(android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo) { throw new RuntimeException("Stub!"); }

/**
 * Gets the range info if this node is a range.
 *
 * @return The range.
 * @apiSince 19
 */

public android.view.accessibility.AccessibilityNodeInfo.RangeInfo getRangeInfo() { throw new RuntimeException("Stub!"); }

/**
 * Sets the range info if this node is a range.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param rangeInfo The range info.
 * @apiSince 19
 */

public void setRangeInfo(android.view.accessibility.AccessibilityNodeInfo.RangeInfo rangeInfo) { throw new RuntimeException("Stub!"); }

/**
 * Gets if the content of this node is invalid. For example,
 * a date is not well-formed.
 *
 * @return If the node content is invalid.
 * @apiSince 19
 */

public boolean isContentInvalid() { throw new RuntimeException("Stub!"); }

/**
 * Sets if the content of this node is invalid. For example,
 * a date is not well-formed.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param contentInvalid If the node content is invalid.
 * @apiSince 19
 */

public void setContentInvalid(boolean contentInvalid) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this node is context clickable.
 *
 * @return True if the node is context clickable.
 * @apiSince 23
 */

public boolean isContextClickable() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this node is context clickable.
 * <p>
 * <strong>Note:</strong> Cannot be called from an
 * {@link android.accessibilityservice.AccessibilityService}. This class is made immutable
 * before being delivered to an AccessibilityService.
 * </p>
 *
 * @param contextClickable True if the node is context clickable.
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 23
 */

public void setContextClickable(boolean contextClickable) { throw new RuntimeException("Stub!"); }

/**
 * Gets the node's live region mode.
 * <p>
 * A live region is a node that contains information that is important for
 * the user and when it changes the user should be notified. For example,
 * in a login screen with a TextView that displays an "incorrect password"
 * notification, that view should be marked as a live region with mode
 * {@link android.view.View#ACCESSIBILITY_LIVE_REGION_POLITE View#ACCESSIBILITY_LIVE_REGION_POLITE}.
 * <p>
 * It is the responsibility of the accessibility service to monitor
 * {@link android.view.accessibility.AccessibilityEvent#TYPE_WINDOW_CONTENT_CHANGED AccessibilityEvent#TYPE_WINDOW_CONTENT_CHANGED} events indicating
 * changes to live region nodes and their children.
 *
 * @return The live region mode, or
 *         {@link android.view.View#ACCESSIBILITY_LIVE_REGION_NONE View#ACCESSIBILITY_LIVE_REGION_NONE} if the view is not a
 *         live region.
 * @see android.view.View#getAccessibilityLiveRegion()
 * @apiSince 19
 */

public int getLiveRegion() { throw new RuntimeException("Stub!"); }

/**
 * Sets the node's live region mode.
 * <p>
 * <strong>Note:</strong> Cannot be called from an
 * {@link android.accessibilityservice.AccessibilityService}. This class is
 * made immutable before being delivered to an AccessibilityService.
 *
 * @param mode The live region mode, or
 *        {@link android.view.View#ACCESSIBILITY_LIVE_REGION_NONE View#ACCESSIBILITY_LIVE_REGION_NONE} if the view is not a
 *        live region.
 * @see android.view.View#setAccessibilityLiveRegion(int)
 * @apiSince 19
 */

public void setLiveRegion(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Gets if the node is a multi line editable text.
 *
 * @return True if the node is multi line.
 * @apiSince 19
 */

public boolean isMultiLine() { throw new RuntimeException("Stub!"); }

/**
 * Sets if the node is a multi line editable text.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param multiLine True if the node is multi line.
 * @apiSince 19
 */

public void setMultiLine(boolean multiLine) { throw new RuntimeException("Stub!"); }

/**
 * Gets if this node opens a popup or a dialog.
 *
 * @return If the the node opens a popup.
 * @apiSince 19
 */

public boolean canOpenPopup() { throw new RuntimeException("Stub!"); }

/**
 * Sets if this node opens a popup or a dialog.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param opensPopup If the the node opens a popup.
 * @apiSince 19
 */

public void setCanOpenPopup(boolean opensPopup) { throw new RuntimeException("Stub!"); }

/**
 * Gets if the node can be dismissed.
 *
 * @return If the node can be dismissed.
 * @apiSince 19
 */

public boolean isDismissable() { throw new RuntimeException("Stub!"); }

/**
 * Sets if the node can be dismissed.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param dismissable If the node can be dismissed.
 * @apiSince 19
 */

public void setDismissable(boolean dismissable) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the node originates from a view considered important for accessibility.
 *
 * @return {@code true} if the node originates from a view considered important for
 *         accessibility, {@code false} otherwise
 *
 * @see android.view.View#isImportantForAccessibility()
 * @apiSince 24
 */

public boolean isImportantForAccessibility() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the node is considered important for accessibility.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param important {@code true} if the node is considered important for accessibility,
 *                  {@code false} otherwise
 * @apiSince 24
 */

public void setImportantForAccessibility(boolean important) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the node is explicitly marked as a focusable unit by a screen reader. Note
 * that {@code false} indicates that it is not explicitly marked, not that the node is not
 * a focusable unit. Screen readers should generally use other signals, such as
 * {@link #isFocusable()}, or the presence of text in a node, to determine what should receive
 * focus.
 *
 * @return {@code true} if the node is specifically marked as a focusable unit for screen
 *         readers, {@code false} otherwise.
 *
 * @see android.view.View#isScreenReaderFocusable()
 * @apiSince 28
 */

public boolean isScreenReaderFocusable() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the node should be considered a focusable unit by a screen reader.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param screenReaderFocusable {@code true} if the node is a focusable unit for screen readers,
 *                              {@code false} otherwise.
 * @apiSince 28
 */

public void setScreenReaderFocusable(boolean screenReaderFocusable) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the node's text represents a hint for the user to enter text. It should only
 * be {@code true} if the node has editable text.
 *
 * @return {@code true} if the text in the node represents a hint to the user, {@code false}
 * otherwise.
 * @apiSince 26
 */

public boolean isShowingHintText() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the node's text represents a hint for the user to enter text. It should only
 * be {@code true} if the node has editable text.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param showingHintText {@code true} if the text in the node represents a hint to the user,
 * {@code false} otherwise.
 * @apiSince 26
 */

public void setShowingHintText(boolean showingHintText) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether node represents a heading.
 * <p><strong>Note:</strong> Returns {@code true} if either {@link #setHeading(boolean)}
 * marks this node as a heading or if the node has a {@link android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo CollectionItemInfo} that marks
 * it as such, to accomodate apps that use the now-deprecated API.</p>
 *
 * @return {@code true} if the node is a heading, {@code false} otherwise.
 * @apiSince 28
 */

public boolean isHeading() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the node represents a heading.
 *
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param isHeading {@code true} if the node is a heading, {@code false} otherwise.
 * @apiSince 28
 */

public void setHeading(boolean isHeading) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether node represents a text entry key that is part of a keyboard or keypad.
 *
 * @return {@code true} if the node is a text entry key., {@code false} otherwise.
 * @apiSince 29
 */

public boolean isTextEntryKey() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the node represents a text entry key that is part of a keyboard or keypad.
 *
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param isTextEntryKey {@code true} if the node is a text entry key, {@code false} otherwise.
 * @apiSince 29
 */

public void setTextEntryKey(boolean isTextEntryKey) { throw new RuntimeException("Stub!"); }

/**
 * Gets the package this node comes from.
 *
 * @return The package name.
 * @apiSince 14
 */

public java.lang.CharSequence getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Sets the package this node comes from.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param packageName The package name.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void setPackageName(java.lang.CharSequence packageName) { throw new RuntimeException("Stub!"); }

/**
 * Gets the class this node comes from.
 *
 * @return The class name.
 * @apiSince 14
 */

public java.lang.CharSequence getClassName() { throw new RuntimeException("Stub!"); }

/**
 * Sets the class this node comes from.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param className The class name.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void setClassName(java.lang.CharSequence className) { throw new RuntimeException("Stub!"); }

/**
 * Gets the text of this node.
 * <p>
 *   <strong>Note:</strong> If the text contains {@link android.text.style.ClickableSpan ClickableSpan}s or {@link android.text.style.URLSpan URLSpan}s,
 *   these spans will have been replaced with ones whose {@link android.text.style.ClickableSpan#onClick(android.view.View) ClickableSpan#onClick(View)}
 *   can be called from an {@link android.accessibilityservice.AccessibilityService AccessibilityService}. When called from a service, the
 *   {@link android.view.View View} argument is ignored and the corresponding span will be found on the view that
 *   this {@code AccessibilityNodeInfo} represents and called with that view as its argument.
 *   <p>
 *   This treatment of {@link android.text.style.ClickableSpan ClickableSpan}s means that the text returned from this method may
 *   different slightly one passed to {@link #setText(java.lang.CharSequence)}, although they will be
 *   equivalent according to {@link android.text.TextUtils#equals(java.lang.CharSequence,java.lang.CharSequence) TextUtils#equals(CharSequence, CharSequence)}. The
 *   {@link android.text.style.ClickableSpan#onClick(android.view.View) ClickableSpan#onClick(View)} of any spans, however, will generally not work outside
 *   of an accessibility service.
 * </p>
 *
 * @return The text.
 * @apiSince 14
 */

public java.lang.CharSequence getText() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text of this node.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param text The text.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void setText(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Gets the hint text of this node. Only applies to nodes where text can be entered.
 *
 * @return The hint text.
 * @apiSince 26
 */

public java.lang.CharSequence getHintText() { throw new RuntimeException("Stub!"); }

/**
 * Sets the hint text of this node. Only applies to nodes where text can be entered.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param hintText The hint text for this mode.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 26
 */

public void setHintText(java.lang.CharSequence hintText) { throw new RuntimeException("Stub!"); }

/**
 * Sets the error text of this node.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param error The error text.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 21
 */

public void setError(java.lang.CharSequence error) { throw new RuntimeException("Stub!"); }

/**
 * Gets the error text of this node.
 *
 * @return The error text.
 * @apiSince 21
 */

public java.lang.CharSequence getError() { throw new RuntimeException("Stub!"); }

/**
 * Gets the content description of this node.
 *
 * @return The content description.
 * @apiSince 14
 */

public java.lang.CharSequence getContentDescription() { throw new RuntimeException("Stub!"); }

/**
 * Sets the content description of this node.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param contentDescription The content description.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 14
 */

public void setContentDescription(java.lang.CharSequence contentDescription) { throw new RuntimeException("Stub!"); }

/**
 * Gets the tooltip text of this node.
 *
 * @return The tooltip text.
 
 * This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getTooltipText() { throw new RuntimeException("Stub!"); }

/**
 * Sets the tooltip text of this node.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param tooltipText The tooltip text.
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 28
 */

public void setTooltipText(@androidx.annotation.Nullable java.lang.CharSequence tooltipText) { throw new RuntimeException("Stub!"); }

/**
 * Sets the view for which the view represented by this info serves as a
 * label for accessibility purposes.
 *
 * @param labeled The view for which this info serves as a label.
 * @apiSince 17
 */

public void setLabelFor(android.view.View labeled) { throw new RuntimeException("Stub!"); }

/**
 * Sets the view for which the view represented by this info serves as a
 * label for accessibility purposes. If <code>virtualDescendantId</code>
 * is {@link android.view.View#NO_ID View#NO_ID} the root is set as the labeled.
 * <p>
 * A virtual descendant is an imaginary View that is reported as a part of the view
 * hierarchy for accessibility purposes. This enables custom views that draw complex
 * content to report themselves as a tree of virtual views, thus conveying their
 * logical structure.
 * </p>
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param root The root whose virtual descendant serves as a label.
 * @param virtualDescendantId The id of the virtual descendant.
 * @apiSince 17
 */

public void setLabelFor(android.view.View root, int virtualDescendantId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the node info for which the view represented by this info serves as
 * a label for accessibility purposes.
 * <p>
 *   <strong>Note:</strong> It is a client responsibility to recycle the
 *     received info by calling {@link android.view.accessibility.AccessibilityNodeInfo#recycle() AccessibilityNodeInfo#recycle()}
 *     to avoid creating of multiple instances.
 * </p>
 *
 * @return The labeled info.
 * @apiSince 17
 */

public android.view.accessibility.AccessibilityNodeInfo getLabelFor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the view which serves as the label of the view represented by
 * this info for accessibility purposes.
 *
 * @param label The view that labels this node's source.
 * @apiSince 17
 */

public void setLabeledBy(android.view.View label) { throw new RuntimeException("Stub!"); }

/**
 * Sets the view which serves as the label of the view represented by
 * this info for accessibility purposes. If <code>virtualDescendantId</code>
 * is {@link android.view.View#NO_ID View#NO_ID} the root is set as the label.
 * <p>
 * A virtual descendant is an imaginary View that is reported as a part of the view
 * hierarchy for accessibility purposes. This enables custom views that draw complex
 * content to report themselves as a tree of virtual views, thus conveying their
 * logical structure.
 * </p>
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param root The root whose virtual descendant labels this node's source.
 * @param virtualDescendantId The id of the virtual descendant.
 * @apiSince 17
 */

public void setLabeledBy(android.view.View root, int virtualDescendantId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the node info which serves as the label of the view represented by
 * this info for accessibility purposes.
 * <p>
 *   <strong>Note:</strong> It is a client responsibility to recycle the
 *     received info by calling {@link android.view.accessibility.AccessibilityNodeInfo#recycle() AccessibilityNodeInfo#recycle()}
 *     to avoid creating of multiple instances.
 * </p>
 *
 * @return The label.
 * @apiSince 17
 */

public android.view.accessibility.AccessibilityNodeInfo getLabeledBy() { throw new RuntimeException("Stub!"); }

/**
 * Sets the fully qualified resource name of the source view's id.
 *
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param viewIdResName The id resource name.
 * @apiSince 18
 */

public void setViewIdResourceName(java.lang.String viewIdResName) { throw new RuntimeException("Stub!"); }

/**
 * Gets the fully qualified resource name of the source view's id.
 *
 * <p>
 *   <strong>Note:</strong> The primary usage of this API is for UI test automation
 *   and in order to report the source view id of an {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo} the
 *   client has to set the {@link android.accessibilityservice.AccessibilityServiceInfo#FLAG_REPORT_VIEW_IDS AccessibilityServiceInfo#FLAG_REPORT_VIEW_IDS}
 *   flag when configuring his {@link android.accessibilityservice.AccessibilityService}.
 * </p>
 
 * @return The id resource name.
 * @apiSince 18
 */

public java.lang.String getViewIdResourceName() { throw new RuntimeException("Stub!"); }

/**
 * Gets the text selection start or the cursor position.
 * <p>
 * If no text is selected, both this method and
 * {@link android.view.accessibility.AccessibilityNodeInfo#getTextSelectionEnd() AccessibilityNodeInfo#getTextSelectionEnd()} return the same value:
 * the current location of the cursor.
 * </p>
 *
 * @return The text selection start, the cursor location if there is no selection, or -1 if
 *         there is no text selection and no cursor.
 * @apiSince 18
 */

public int getTextSelectionStart() { throw new RuntimeException("Stub!"); }

/**
 * Gets the text selection end if text is selected.
 * <p>
 * If no text is selected, both this method and
 * {@link android.view.accessibility.AccessibilityNodeInfo#getTextSelectionStart() AccessibilityNodeInfo#getTextSelectionStart()} return the same value:
 * the current location of the cursor.
 * </p>
 *
 * @return The text selection end, the cursor location if there is no selection, or -1 if
 *         there is no text selection and no cursor.
 * @apiSince 18
 */

public int getTextSelectionEnd() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text selection start and end.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an AccessibilityService.
 * </p>
 *
 * @param start The text selection start.
 * @param end The text selection end.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 18
 */

public void setTextSelection(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Gets the input type of the source as defined by {@link android.text.InputType InputType}.
 *
 * @return The input type.
 * @apiSince 19
 */

public int getInputType() { throw new RuntimeException("Stub!"); }

/**
 * Sets the input type of the source as defined by {@link android.text.InputType InputType}.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an
 *   AccessibilityService.
 * </p>
 *
 * @param inputType The input type.
 *
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 19
 */

public void setInputType(int inputType) { throw new RuntimeException("Stub!"); }

/**
 * Gets an optional bundle with extra data. The bundle
 * is lazily created and never <code>null</code>.
 * <p>
 * <strong>Note:</strong> It is recommended to use the package
 * name of your application as a prefix for the keys to avoid
 * collisions which may confuse an accessibility service if the
 * same key has different meaning when emitted from different
 * applications.
 * </p>
 *
 * @return The bundle.
 * @apiSince 19
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Get the {@link android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo TouchDelegateInfo} for touch delegate behavior with the represented view.
 * It is possible for the same node to be pointed to by several regions. Use
 * {@link android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo#getRegionAt(int) TouchDelegateInfo#getRegionAt(int)} to get touch delegate target {@link android.graphics.Region Region}, and
 * {@link android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo#getTargetForRegion(android.graphics.Region) TouchDelegateInfo#getTargetForRegion(Region)} for {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo} from
 * the given region.
 *
 * @return {@link android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo TouchDelegateInfo} or {@code null} if there are no touch delegates.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo getTouchDelegateInfo() { throw new RuntimeException("Stub!"); }

/**
 * Set touch delegate info if the represented view has a {@link android.view.TouchDelegate TouchDelegate}.
 * <p>
 *   <strong>Note:</strong> Cannot be called from an
 *   {@link android.accessibilityservice.AccessibilityService}.
 *   This class is made immutable before being delivered to an
 *   AccessibilityService.
 * </p>
 *
 * @param delegatedInfo {@link android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo TouchDelegateInfo} returned from
 *         {@link android.view.TouchDelegate#getTouchDelegateInfo() TouchDelegate#getTouchDelegateInfo()}.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException If called from an AccessibilityService.
 * @apiSince 29
 */

public void setTouchDelegateInfo(@androidx.annotation.NonNull android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo delegatedInfo) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 14
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Returns a cached instance if such is available otherwise a new one
 * and sets the source.
 *
 * @param source The source view.
 * @return An instance.
 *
 * @see #setSource(View)
 * @apiSince 14
 */

public static android.view.accessibility.AccessibilityNodeInfo obtain(android.view.View source) { throw new RuntimeException("Stub!"); }

/**
 * Returns a cached instance if such is available otherwise a new one
 * and sets the source.
 *
 * @param root The root of the virtual subtree.
 * @param virtualDescendantId The id of the virtual descendant.
 * @return An instance.
 *
 * @see #setSource(View, int)
 * @apiSince 16
 */

public static android.view.accessibility.AccessibilityNodeInfo obtain(android.view.View root, int virtualDescendantId) { throw new RuntimeException("Stub!"); }

/**
 * Returns a cached instance if such is available otherwise a new one.
 *
 * @return An instance.
 * @apiSince 14
 */

public static android.view.accessibility.AccessibilityNodeInfo obtain() { throw new RuntimeException("Stub!"); }

/**
 * Returns a cached instance if such is available or a new one is
 * create. The returned instance is initialized from the given
 * <code>info</code>.
 *
 * @param info The other info.
 * @return An instance.
 * @apiSince 14
 */

public static android.view.accessibility.AccessibilityNodeInfo obtain(android.view.accessibility.AccessibilityNodeInfo info) { throw new RuntimeException("Stub!"); }

/**
 * Return an instance back to be reused.
 * <p>
 * <strong>Note:</strong> You must not touch the object after calling this function.
 *
 * @throws java.lang.IllegalStateException If the info is already recycled.
 * @apiSince 14
 */

public void recycle() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * <p>
 *   <strong>Note:</strong> After the instance is written to a parcel it
 *      is recycled. You must not touch the object after calling this function.
 * </p>
 * @apiSince 14
 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public boolean equals(java.lang.Object object) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Action that gives accessibility focus to the node.
 * @apiSince 16
 */

public static final int ACTION_ACCESSIBILITY_FOCUS = 64; // 0x40

/**
 * Argument for specifying the collection column to make visible on screen.
 * <p>
 * <strong>Type:</strong> int<br>
 * <strong>Actions:</strong>
 * <ul>
 *     <li>{@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_SCROLL_TO_POSITION AccessibilityAction#ACTION_SCROLL_TO_POSITION}</li>
 * </ul>
 *
 * @see android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_SCROLL_TO_POSITION
 * @apiSince 23
 */

public static final java.lang.String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";

/**
 * Argument for whether when moving at granularity to extend the selection
 * or to move it otherwise.
 * <p>
 * <strong>Type:</strong> boolean<br>
 * <strong>Actions:</strong>
 * <ul>
 *     <li>{@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_NEXT_AT_MOVEMENT_GRANULARITY AccessibilityAction#ACTION_NEXT_AT_MOVEMENT_GRANULARITY}</li>
 *     <li>{@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY AccessibilityAction#ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY}</li>
 * </ul>
 *
 * @see android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_NEXT_AT_MOVEMENT_GRANULARITY
 * @see android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY
 * @apiSince 18
 */

public static final java.lang.String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";

/**
 * Argument for which HTML element to get moving to the next/previous HTML element.
 * <p>
 * <strong>Type:</strong> String<br>
 * <strong>Actions:</strong>
 * <ul>
 *     <li>{@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_NEXT_HTML_ELEMENT AccessibilityAction#ACTION_NEXT_HTML_ELEMENT}</li>
 *     <li>{@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_PREVIOUS_HTML_ELEMENT AccessibilityAction#ACTION_PREVIOUS_HTML_ELEMENT}</li>
 * </ul>
 * </p>
 *
 * @see android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_NEXT_HTML_ELEMENT
 * @see android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_PREVIOUS_HTML_ELEMENT
 * @apiSince 16
 */

public static final java.lang.String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";

/**
 * Argument for which movement granularity to be used when traversing the node text.
 * <p>
 * <strong>Type:</strong> int<br>
 * <strong>Actions:</strong>
 * <ul>
 *     <li>{@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_NEXT_AT_MOVEMENT_GRANULARITY AccessibilityAction#ACTION_NEXT_AT_MOVEMENT_GRANULARITY}</li>
 *     <li>{@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY AccessibilityAction#ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY}</li>
 * </ul>
 * </p>
 *
 * @see android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_NEXT_AT_MOVEMENT_GRANULARITY
 * @see android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY
 * @apiSince 16
 */

public static final java.lang.String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";

/**
 * Argument for specifying the x coordinate to which to move a window.
 * <p>
 * <strong>Type:</strong> int<br>
 * <strong>Actions:</strong>
 * <ul>
 *     <li>{@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_MOVE_WINDOW AccessibilityAction#ACTION_MOVE_WINDOW}</li>
 * </ul>
 *
 * @see android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_MOVE_WINDOW
 * @apiSince 26
 */

public static final java.lang.String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";

/**
 * Argument for specifying the y coordinate to which to move a window.
 * <p>
 * <strong>Type:</strong> int<br>
 * <strong>Actions:</strong>
 * <ul>
 *     <li>{@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_MOVE_WINDOW AccessibilityAction#ACTION_MOVE_WINDOW}</li>
 * </ul>
 *
 * @see android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_MOVE_WINDOW
 * @apiSince 26
 */

public static final java.lang.String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";

/**
 * Argument for specifying the progress value to set.
 * <p>
 * <strong>Type:</strong> float<br>
 * <strong>Actions:</strong>
 * <ul>
 *     <li>{@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_SET_PROGRESS AccessibilityAction#ACTION_SET_PROGRESS}</li>
 * </ul>
 *
 * @see android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_SET_PROGRESS
 * @apiSince 24
 */

public static final java.lang.String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";

/**
 * Argument for specifying the collection row to make visible on screen.
 * <p>
 * <strong>Type:</strong> int<br>
 * <strong>Actions:</strong>
 * <ul>
 *     <li>{@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_SCROLL_TO_POSITION AccessibilityAction#ACTION_SCROLL_TO_POSITION}</li>
 * </ul>
 *
 * @see android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_SCROLL_TO_POSITION
 * @apiSince 23
 */

public static final java.lang.String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";

/**
 * Argument for specifying the selection end.
 * <p>
 * <strong>Type:</strong> int<br>
 * <strong>Actions:</strong>
 * <ul>
 *     <li>{@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_SET_SELECTION AccessibilityAction#ACTION_SET_SELECTION}</li>
 * </ul>
 *
 * @see android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_SET_SELECTION
 * @apiSince 18
 */

public static final java.lang.String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";

/**
 * Argument for specifying the selection start.
 * <p>
 * <strong>Type:</strong> int<br>
 * <strong>Actions:</strong>
 * <ul>
 *     <li>{@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_SET_SELECTION AccessibilityAction#ACTION_SET_SELECTION}</li>
 * </ul>
 *
 * @see android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_SET_SELECTION
 * @apiSince 18
 */

public static final java.lang.String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";

/**
 * Argument for specifying the text content to set.
 * <p>
 * <strong>Type:</strong> CharSequence<br>
 * <strong>Actions:</strong>
 * <ul>
 *     <li>{@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_SET_TEXT AccessibilityAction#ACTION_SET_TEXT}</li>
 * </ul>
 *
 * @see android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_SET_TEXT
 * @apiSince 21
 */

public static final java.lang.String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";

/**
 * Action that clears accessibility focus of the node.
 * @apiSince 16
 */

public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128; // 0x80

/**
 * Action that clears input focus of the node.
 * @apiSince 14
 */

public static final int ACTION_CLEAR_FOCUS = 2; // 0x2

/**
 * Action that deselects the node.
 * @apiSince 14
 */

public static final int ACTION_CLEAR_SELECTION = 8; // 0x8

/**
 * Action that clicks on the node info.
 *
 * See {@link android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction#ACTION_CLICK AccessibilityAction#ACTION_CLICK}
 * @apiSince 16
 */

public static final int ACTION_CLICK = 16; // 0x10

/**
 * Action to collapse an expandable node.
 * @apiSince 19
 */

public static final int ACTION_COLLAPSE = 524288; // 0x80000

/**
 * Action to copy the current selection to the clipboard.
 * @apiSince 18
 */

public static final int ACTION_COPY = 16384; // 0x4000

/**
 * Action to cut the current selection and place it to the clipboard.
 * @apiSince 18
 */

public static final int ACTION_CUT = 65536; // 0x10000

/**
 * Action to dismiss a dismissable node.
 * @apiSince 19
 */

public static final int ACTION_DISMISS = 1048576; // 0x100000

/**
 * Action to expand an expandable node.
 * @apiSince 19
 */

public static final int ACTION_EXPAND = 262144; // 0x40000

/**
 * Action that gives input focus to the node.
 * @apiSince 14
 */

public static final int ACTION_FOCUS = 1; // 0x1

/**
 * Action that long clicks on the node.
 * @apiSince 16
 */

public static final int ACTION_LONG_CLICK = 32; // 0x20

/**
 * Action that requests to go to the next entity in this node's text
 * at a given movement granularity. For example, move to the next character,
 * word, etc.
 * <p>
 * <strong>Arguments:</strong> {@link #ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT}<,
 * {@link #ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN}<br>
 * <strong>Example:</strong> Move to the previous character and do not extend selection.
 * <code><pre><p>
 *   Bundle arguments = new Bundle();
 *   arguments.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT,
 *           AccessibilityNodeInfo.MOVEMENT_GRANULARITY_CHARACTER);
 *   arguments.putBoolean(AccessibilityNodeInfo.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN,
 *           false);
 *   info.performAction(AccessibilityNodeInfo.ACTION_NEXT_AT_MOVEMENT_GRANULARITY, arguments);
 * </code></pre></p>
 * </p>
 *
 * @see #ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT
 * @see #ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN
 *
 * @see #setMovementGranularities(int)
 * @see #getMovementGranularities()
 *
 * @see #MOVEMENT_GRANULARITY_CHARACTER
 * @see #MOVEMENT_GRANULARITY_WORD
 * @see #MOVEMENT_GRANULARITY_LINE
 * @see #MOVEMENT_GRANULARITY_PARAGRAPH
 * @see #MOVEMENT_GRANULARITY_PAGE
 * @apiSince 16
 */

public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256; // 0x100

/**
 * Action to move to the next HTML element of a given type. For example, move
 * to the BUTTON, INPUT, TABLE, etc.
 * <p>
 * <strong>Arguments:</strong> {@link #ACTION_ARGUMENT_HTML_ELEMENT_STRING}<br>
 * <strong>Example:</strong>
 * <code><pre><p>
 *   Bundle arguments = new Bundle();
 *   arguments.putString(AccessibilityNodeInfo.ACTION_ARGUMENT_HTML_ELEMENT_STRING, "BUTTON");
 *   info.performAction(AccessibilityNodeInfo.ACTION_NEXT_HTML_ELEMENT, arguments);
 * </code></pre></p>
 * </p>
 * @apiSince 16
 */

public static final int ACTION_NEXT_HTML_ELEMENT = 1024; // 0x400

/**
 * Action to paste the current clipboard content.
 * @apiSince 18
 */

public static final int ACTION_PASTE = 32768; // 0x8000

/**
 * Action that requests to go to the previous entity in this node's text
 * at a given movement granularity. For example, move to the next character,
 * word, etc.
 * <p>
 * <strong>Arguments:</strong> {@link #ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT}<,
 * {@link #ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN}<br>
 * <strong>Example:</strong> Move to the next character and do not extend selection.
 * <code><pre><p>
 *   Bundle arguments = new Bundle();
 *   arguments.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT,
 *           AccessibilityNodeInfo.MOVEMENT_GRANULARITY_CHARACTER);
 *   arguments.putBoolean(AccessibilityNodeInfo.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN,
 *           false);
 *   info.performAction(AccessibilityNodeInfo.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY,
 *           arguments);
 * </code></pre></p>
 * </p>
 *
 * @see #ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT
 * @see #ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN
 *
 * @see #setMovementGranularities(int)
 * @see #getMovementGranularities()
 *
 * @see #MOVEMENT_GRANULARITY_CHARACTER
 * @see #MOVEMENT_GRANULARITY_WORD
 * @see #MOVEMENT_GRANULARITY_LINE
 * @see #MOVEMENT_GRANULARITY_PARAGRAPH
 * @see #MOVEMENT_GRANULARITY_PAGE
 * @apiSince 16
 */

public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512; // 0x200

/**
 * Action to move to the previous HTML element of a given type. For example, move
 * to the BUTTON, INPUT, TABLE, etc.
 * <p>
 * <strong>Arguments:</strong> {@link #ACTION_ARGUMENT_HTML_ELEMENT_STRING}<br>
 * <strong>Example:</strong>
 * <code><pre><p>
 *   Bundle arguments = new Bundle();
 *   arguments.putString(AccessibilityNodeInfo.ACTION_ARGUMENT_HTML_ELEMENT_STRING, "BUTTON");
 *   info.performAction(AccessibilityNodeInfo.ACTION_PREVIOUS_HTML_ELEMENT, arguments);
 * </code></pre></p>
 * </p>
 * @apiSince 16
 */

public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048; // 0x800

/**
 * Action to scroll the node content backward.
 * @apiSince 16
 */

public static final int ACTION_SCROLL_BACKWARD = 8192; // 0x2000

/**
 * Action to scroll the node content forward.
 * @apiSince 16
 */

public static final int ACTION_SCROLL_FORWARD = 4096; // 0x1000

/**
 * Action that selects the node.
 * @apiSince 14
 */

public static final int ACTION_SELECT = 4; // 0x4

/**
 * Action to set the selection. Performing this action with no arguments
 * clears the selection.
 * <p>
 * <strong>Arguments:</strong>
 * {@link #ACTION_ARGUMENT_SELECTION_START_INT},
 * {@link #ACTION_ARGUMENT_SELECTION_END_INT}<br>
 * <strong>Example:</strong>
 * <code><pre><p>
 *   Bundle arguments = new Bundle();
 *   arguments.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_SELECTION_START_INT, 1);
 *   arguments.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_SELECTION_END_INT, 2);
 *   info.performAction(AccessibilityNodeInfo.ACTION_SET_SELECTION, arguments);
 * </code></pre></p>
 * </p>
 *
 * @see #ACTION_ARGUMENT_SELECTION_START_INT
 * @see #ACTION_ARGUMENT_SELECTION_END_INT
 * @apiSince 18
 */

public static final int ACTION_SET_SELECTION = 131072; // 0x20000

/**
 * Action that sets the text of the node. Performing the action without argument, using <code>
 * null</code> or empty {@link java.lang.CharSequence CharSequence} will clear the text. This action will also put the
 * cursor at the end of text.
 * <p>
 * <strong>Arguments:</strong>
 * {@link #ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE}<br>
 * <strong>Example:</strong>
 * <code><pre><p>
 *   Bundle arguments = new Bundle();
 *   arguments.putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE,
 *       "android");
 *   info.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arguments);
 * </code></pre></p>
 * @apiSince 21
 */

public static final int ACTION_SET_TEXT = 2097152; // 0x200000

/**
 * @see android.os.Parcelable.Creator
 * @apiSince 14
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.accessibility.AccessibilityNodeInfo> CREATOR;
static { CREATOR = null; }

/**
 * Integer argument specifying the end index of the requested text location data. Must be
 * positive.
 *
 * @see #EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY
 * @apiSince 26
 */

public static final java.lang.String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH = "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH";

/**
 * Integer argument specifying the start index of the requested text location data. Must be
 * valid inside the CharSequence returned by {@link #getText()}.
 *
 * @see #EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY
 * @apiSince 26
 */

public static final java.lang.String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX = "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX";

/**
 * Key used to request and locate extra data for text character location. This key requests that
 * an array of {@link android.graphics.RectF}s be added to the extras. This request is made with
 * {@link #refreshWithExtraData(java.lang.String,android.os.Bundle)}. The arguments taken by this request are two
 * integers: {@link #EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX} and
 * {@link #EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH}. The starting index must be valid
 * inside the CharSequence returned by {@link #getText()}, and the length must be positive.
 * <p>
 * The data can be retrieved from the {@code Bundle} returned by {@link #getExtras()} using this
 * string as a key for {@link android.os.Bundle#getParcelableArray(java.lang.String) Bundle#getParcelableArray(String)}. The
 * {@link android.graphics.RectF} will be null for characters that either do not exist or are
 * off the screen.
 *
 * {@see #refreshWithExtraData(String, Bundle)}
 * @apiSince 26
 */

public static final java.lang.String EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY = "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY";

/**
 * The accessibility focus.
 * @apiSince 16
 */

public static final int FOCUS_ACCESSIBILITY = 2; // 0x2

/**
 * The input focus.
 * @apiSince 16
 */

public static final int FOCUS_INPUT = 1; // 0x1

/**
 * Movement granularity bit for traversing the text of a node by character.
 * @apiSince 16
 */

public static final int MOVEMENT_GRANULARITY_CHARACTER = 1; // 0x1

/**
 * Movement granularity bit for traversing the text of a node by line.
 * @apiSince 16
 */

public static final int MOVEMENT_GRANULARITY_LINE = 4; // 0x4

/**
 * Movement granularity bit for traversing the text of a node by page.
 * @apiSince 16
 */

public static final int MOVEMENT_GRANULARITY_PAGE = 16; // 0x10

/**
 * Movement granularity bit for traversing the text of a node by paragraph.
 * @apiSince 16
 */

public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8; // 0x8

/**
 * Movement granularity bit for traversing the text of a node by word.
 * @apiSince 16
 */

public static final int MOVEMENT_GRANULARITY_WORD = 2; // 0x2
/**
 * A class defining an action that can be performed on an {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo}.
 * Each action has a unique id that is mandatory and optional data.
 * <p>
 * There are three categories of actions:
 * <ul>
 * <li><strong>Standard actions</strong> - These are actions that are reported and
 * handled by the standard UI widgets in the platform. For each standard action
 * there is a static constant defined in this class, e.g. {@link #ACTION_FOCUS}.
 * These actions will have {@code null} labels.
 * </li>
 * <li><strong>Custom actions action</strong> - These are actions that are reported
 * and handled by custom widgets. i.e. ones that are not part of the UI toolkit. For
 * example, an application may define a custom action for clearing the user history.
 * </li>
 * <li><strong>Overriden standard actions</strong> - These are actions that override
 * standard actions to customize them. For example, an app may add a label to the
 * standard {@link #ACTION_CLICK} action to indicate to the user that this action clears
 * browsing history.
 * </ul>
 * </p>
 * <p>
 * Actions are typically added to an {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo} by using
 * {@link android.view.accessibility.AccessibilityNodeInfo#addAction(android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction) AccessibilityNodeInfo#addAction(AccessibilityAction)} within
 * {@link android.view.View#onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo) View#onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo)} and are performed
 * within {@link android.view.View#performAccessibilityAction(int,android.os.Bundle) View#performAccessibilityAction(int, Bundle)}.
 * </p>
 * <p class="note">
 * <strong>Note:</strong> Views which support these actions should invoke
 * {@link android.view.View#setImportantForAccessibility(int) View#setImportantForAccessibility(int)} with
 * {@link android.view.View#IMPORTANT_FOR_ACCESSIBILITY_YES View#IMPORTANT_FOR_ACCESSIBILITY_YES} to ensure an {@link android.accessibilityservice.AccessibilityService AccessibilityService}
 * can discover the set of supported actions.
 * </p>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class AccessibilityAction {

/**
 * Creates a new AccessibilityAction. For adding a standard action without a specific label,
 * use the static constants.
 *
 * You can also override the description for one the standard actions. Below is an example
 * how to override the standard click action by adding a custom label:
 * <pre>
 *   AccessibilityAction action = new AccessibilityAction(
 *           AccessibilityAction.ACTION_CLICK.getId(), getLocalizedLabel());
 *   node.addAction(action);
 * </pre>
 *
 * @param actionId The id for this action. This should either be one of the
 *                 standard actions or a specific action for your app. In that case it is
 *                 required to use a resource identifier.
 * @param label The label for the new AccessibilityAction.
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public AccessibilityAction(int actionId, @androidx.annotation.Nullable java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * Gets the id for this action.
 *
 * @return The action id.
 * @apiSince 21
 */

public int getId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the label for this action. Its purpose is to describe the
 * action to user.
 *
 * @return The label.
 * @apiSince 21
 */

public java.lang.CharSequence getLabel() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Action that gives accessibility focus to the node.
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_ACCESSIBILITY_FOCUS;
static { ACTION_ACCESSIBILITY_FOCUS = null; }

/**
 * Action that clears accessibility focus of the node.
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_CLEAR_ACCESSIBILITY_FOCUS;
static { ACTION_CLEAR_ACCESSIBILITY_FOCUS = null; }

/**
 * Action that clears input focus of the node.
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_CLEAR_FOCUS;
static { ACTION_CLEAR_FOCUS = null; }

/**
 * Action that deselects the node.
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_CLEAR_SELECTION;
static { ACTION_CLEAR_SELECTION = null; }

/**
 * Action that clicks on the node info.
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_CLICK;
static { ACTION_CLICK = null; }

/**
 * Action to collapse an expandable node.
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_COLLAPSE;
static { ACTION_COLLAPSE = null; }

/**
 * Action that context clicks the node.
 * @apiSince 23
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_CONTEXT_CLICK;
static { ACTION_CONTEXT_CLICK = null; }

/**
 * Action to copy the current selection to the clipboard.
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_COPY;
static { ACTION_COPY = null; }

/**
 * Action to cut the current selection and place it to the clipboard.
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_CUT;
static { ACTION_CUT = null; }

/**
 * Action to dismiss a dismissable node.
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_DISMISS;
static { ACTION_DISMISS = null; }

/**
 * Action to expand an expandable node.
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_EXPAND;
static { ACTION_EXPAND = null; }

/**
 * Action that gives input focus to the node.
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_FOCUS;
static { ACTION_FOCUS = null; }

/**
 * Action to hide a tooltip. A node should expose this action only for views that are
 * currently showing a tooltip.
 * @apiSince 28
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_HIDE_TOOLTIP;
static { ACTION_HIDE_TOOLTIP = null; }

/**
 * Action that long clicks on the node.
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_LONG_CLICK;
static { ACTION_LONG_CLICK = null; }

/**
 * Action to move a window to a new location.
 * <p>
 * <strong>Arguments:</strong>
 * {@link android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_MOVE_WINDOW_X AccessibilityNodeInfo#ACTION_ARGUMENT_MOVE_WINDOW_X}
 * {@link android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_MOVE_WINDOW_Y AccessibilityNodeInfo#ACTION_ARGUMENT_MOVE_WINDOW_Y}
 * @apiSince 26
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_MOVE_WINDOW;
static { ACTION_MOVE_WINDOW = null; }

/**
 * Action that requests to go to the next entity in this node's text
 * at a given movement granularity. For example, move to the next character,
 * word, etc.
 * <p>
 * <strong>Arguments:</strong>
 * {@link android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT AccessibilityNodeInfo#ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT},
 * {@link android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN AccessibilityNodeInfo#ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN}<br>
 * <strong>Example:</strong> Move to the previous character and do not extend selection.
 * <code><pre><p>
 *   Bundle arguments = new Bundle();
 *   arguments.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT,
 *           AccessibilityNodeInfo.MOVEMENT_GRANULARITY_CHARACTER);
 *   arguments.putBoolean(AccessibilityNodeInfo.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN,
 *           false);
 *   info.performAction(AccessibilityAction.ACTION_NEXT_AT_MOVEMENT_GRANULARITY.getId(),
 *           arguments);
 * </code></pre></p>
 * </p>
 *
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT
 *  AccessibilityNodeInfo.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN
 *  AccessibilityNodeInfo.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN
 *
 * @see android.view.accessibility.AccessibilityNodeInfo#setMovementGranularities(int)
 *  AccessibilityNodeInfo.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN
 * @see android.view.accessibility.AccessibilityNodeInfo#getMovementGranularities()
 *  AccessibilityNodeInfo.getMovementGranularities()
 *
 * @see android.view.accessibility.AccessibilityNodeInfo#MOVEMENT_GRANULARITY_CHARACTER
 *  AccessibilityNodeInfo.MOVEMENT_GRANULARITY_CHARACTER
 * @see android.view.accessibility.AccessibilityNodeInfo#MOVEMENT_GRANULARITY_WORD
 *  AccessibilityNodeInfo.MOVEMENT_GRANULARITY_WORD
 * @see android.view.accessibility.AccessibilityNodeInfo#MOVEMENT_GRANULARITY_LINE
 *  AccessibilityNodeInfo.MOVEMENT_GRANULARITY_LINE
 * @see android.view.accessibility.AccessibilityNodeInfo#MOVEMENT_GRANULARITY_PARAGRAPH
 *  AccessibilityNodeInfo.MOVEMENT_GRANULARITY_PARAGRAPH
 * @see android.view.accessibility.AccessibilityNodeInfo#MOVEMENT_GRANULARITY_PAGE
 *  AccessibilityNodeInfo.MOVEMENT_GRANULARITY_PAGE
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
static { ACTION_NEXT_AT_MOVEMENT_GRANULARITY = null; }

/**
 * Action to move to the next HTML element of a given type. For example, move
 * to the BUTTON, INPUT, TABLE, etc.
 * <p>
 * <strong>Arguments:</strong>
 * {@link android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_HTML_ELEMENT_STRING AccessibilityNodeInfo#ACTION_ARGUMENT_HTML_ELEMENT_STRING}<br>
 * <strong>Example:</strong>
 * <code><pre><p>
 *   Bundle arguments = new Bundle();
 *   arguments.putString(AccessibilityNodeInfo.ACTION_ARGUMENT_HTML_ELEMENT_STRING, "BUTTON");
 *   info.performAction(AccessibilityAction.ACTION_NEXT_HTML_ELEMENT.getId(), arguments);
 * </code></pre></p>
 * </p>
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_NEXT_HTML_ELEMENT;
static { ACTION_NEXT_HTML_ELEMENT = null; }

/**
 * Action to move to the page below.
 * @apiSince 29
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_PAGE_DOWN;
static { ACTION_PAGE_DOWN = null; }

/**
 * Action to move to the page left.
 * @apiSince 29
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_PAGE_LEFT;
static { ACTION_PAGE_LEFT = null; }

/**
 * Action to move to the page right.
 * @apiSince 29
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_PAGE_RIGHT;
static { ACTION_PAGE_RIGHT = null; }

/**
 * Action to move to the page above.
 * @apiSince 29
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_PAGE_UP;
static { ACTION_PAGE_UP = null; }

/**
 * Action to paste the current clipboard content.
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_PASTE;
static { ACTION_PASTE = null; }

/**
 * Action that requests to go to the previous entity in this node's text
 * at a given movement granularity. For example, move to the next character,
 * word, etc.
 * <p>
 * <strong>Arguments:</strong>
 * {@link android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT AccessibilityNodeInfo#ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT},
 * {@link android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN AccessibilityNodeInfo#ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN}<br>
 * <strong>Example:</strong> Move to the next character and do not extend selection.
 * <code><pre><p>
 *   Bundle arguments = new Bundle();
 *   arguments.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT,
 *           AccessibilityNodeInfo.MOVEMENT_GRANULARITY_CHARACTER);
 *   arguments.putBoolean(AccessibilityNodeInfo.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN,
 *           false);
 *   info.performAction(AccessibilityAction.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY.getId(),
 *           arguments);
 * </code></pre></p>
 * </p>
 *
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT
 *  AccessibilityNodeInfo.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN
 *  AccessibilityNodeInfo.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN
 *
 * @see android.view.accessibility.AccessibilityNodeInfo#setMovementGranularities(int)
 *   AccessibilityNodeInfo.setMovementGranularities(int)
 * @see android.view.accessibility.AccessibilityNodeInfo#getMovementGranularities()
 *  AccessibilityNodeInfo.getMovementGranularities()
 *
 * @see android.view.accessibility.AccessibilityNodeInfo#MOVEMENT_GRANULARITY_CHARACTER
 *  AccessibilityNodeInfo.MOVEMENT_GRANULARITY_CHARACTER
 * @see android.view.accessibility.AccessibilityNodeInfo#MOVEMENT_GRANULARITY_WORD
 *  AccessibilityNodeInfo.MOVEMENT_GRANULARITY_WORD
 * @see android.view.accessibility.AccessibilityNodeInfo#MOVEMENT_GRANULARITY_LINE
 *  AccessibilityNodeInfo.MOVEMENT_GRANULARITY_LINE
 * @see android.view.accessibility.AccessibilityNodeInfo#MOVEMENT_GRANULARITY_PARAGRAPH
 *  AccessibilityNodeInfo.MOVEMENT_GRANULARITY_PARAGRAPH
 * @see android.view.accessibility.AccessibilityNodeInfo#MOVEMENT_GRANULARITY_PAGE
 *  AccessibilityNodeInfo.MOVEMENT_GRANULARITY_PAGE
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
static { ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = null; }

/**
 * Action to move to the previous HTML element of a given type. For example, move
 * to the BUTTON, INPUT, TABLE, etc.
 * <p>
 * <strong>Arguments:</strong>
 * {@link android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_HTML_ELEMENT_STRING AccessibilityNodeInfo#ACTION_ARGUMENT_HTML_ELEMENT_STRING}<br>
 * <strong>Example:</strong>
 * <code><pre><p>
 *   Bundle arguments = new Bundle();
 *   arguments.putString(AccessibilityNodeInfo.ACTION_ARGUMENT_HTML_ELEMENT_STRING, "BUTTON");
 *   info.performAction(AccessibilityAction.ACTION_PREVIOUS_HTML_ELEMENT.getId(), arguments);
 * </code></pre></p>
 * </p>
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_PREVIOUS_HTML_ELEMENT;
static { ACTION_PREVIOUS_HTML_ELEMENT = null; }

/**
 * Action to scroll the node content backward.
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_SCROLL_BACKWARD;
static { ACTION_SCROLL_BACKWARD = null; }

/**
 * Action to scroll the node content down.
 * @apiSince 23
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_SCROLL_DOWN;
static { ACTION_SCROLL_DOWN = null; }

/**
 * Action to scroll the node content forward.
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_SCROLL_FORWARD;
static { ACTION_SCROLL_FORWARD = null; }

/**
 * Action to scroll the node content left.
 * @apiSince 23
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_SCROLL_LEFT;
static { ACTION_SCROLL_LEFT = null; }

/**
 * Action to scroll the node content right.
 * @apiSince 23
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_SCROLL_RIGHT;
static { ACTION_SCROLL_RIGHT = null; }

/**
 * Action that scrolls the node to make the specified collection
 * position visible on screen.
 * <p>
 * <strong>Arguments:</strong>
 * <ul>
 *     <li>{@link android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_ROW_INT AccessibilityNodeInfo#ACTION_ARGUMENT_ROW_INT}</li>
 *     <li>{@link android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_COLUMN_INT AccessibilityNodeInfo#ACTION_ARGUMENT_COLUMN_INT}</li>
 * <ul>
 *
 * @see android.view.accessibility.AccessibilityNodeInfo#getCollectionInfo()
 * @apiSince 23
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_SCROLL_TO_POSITION;
static { ACTION_SCROLL_TO_POSITION = null; }

/**
 * Action to scroll the node content up.
 * @apiSince 23
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_SCROLL_UP;
static { ACTION_SCROLL_UP = null; }

/**
 *  Action that selects the node.
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_SELECT;
static { ACTION_SELECT = null; }

/**
 * Action that sets progress between {@link android.view.accessibility.AccessibilityNodeInfo.RangeInfo#getMin() RangeInfo#getMin()} and
 * {@link android.view.accessibility.AccessibilityNodeInfo.RangeInfo#getMax() RangeInfo#getMax()}. It should use the same value type as
 * {@link android.view.accessibility.AccessibilityNodeInfo.RangeInfo#getType() RangeInfo#getType()}
 * <p>
 * <strong>Arguments:</strong>
 * {@link android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_PROGRESS_VALUE AccessibilityNodeInfo#ACTION_ARGUMENT_PROGRESS_VALUE}
 *
 * @see android.view.accessibility.AccessibilityNodeInfo.RangeInfo
 * @apiSince 24
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_SET_PROGRESS;
static { ACTION_SET_PROGRESS = null; }

/**
 * Action to set the selection. Performing this action with no arguments
 * clears the selection.
 * <p>
 * <strong>Arguments:</strong>
 * {@link android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_SELECTION_START_INT AccessibilityNodeInfo#ACTION_ARGUMENT_SELECTION_START_INT},
 * {@link android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_SELECTION_END_INT AccessibilityNodeInfo#ACTION_ARGUMENT_SELECTION_END_INT}<br>
 * <strong>Example:</strong>
 * <code><pre><p>
 *   Bundle arguments = new Bundle();
 *   arguments.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_SELECTION_START_INT, 1);
 *   arguments.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_SELECTION_END_INT, 2);
 *   info.performAction(AccessibilityAction.ACTION_SET_SELECTION.getId(), arguments);
 * </code></pre></p>
 * </p>
 *
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_SELECTION_START_INT
 *  AccessibilityNodeInfo.ACTION_ARGUMENT_SELECTION_START_INT
 * @see android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_SELECTION_END_INT
 *  AccessibilityNodeInfo.ACTION_ARGUMENT_SELECTION_END_INT
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_SET_SELECTION;
static { ACTION_SET_SELECTION = null; }

/**
 * Action that sets the text of the node. Performing the action without argument,
 * using <code> null</code> or empty {@link java.lang.CharSequence CharSequence} will clear the text. This
 * action will also put the cursor at the end of text.
 * <p>
 * <strong>Arguments:</strong>
 * {@link android.view.accessibility.AccessibilityNodeInfo#ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE AccessibilityNodeInfo#ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE}<br>
 * <strong>Example:</strong>
 * <code><pre><p>
 *   Bundle arguments = new Bundle();
 *   arguments.putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE,
 *       "android");
 *   info.performAction(AccessibilityAction.ACTION_SET_TEXT.getId(), arguments);
 * </code></pre></p>
 * @apiSince 21
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_SET_TEXT;
static { ACTION_SET_TEXT = null; }

/**
 * Action that requests the node make its bounding rectangle visible
 * on the screen, scrolling if necessary just enough.
 *
 * @see android.view.View#requestRectangleOnScreen(Rect)
 * @apiSince 23
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_SHOW_ON_SCREEN;
static { ACTION_SHOW_ON_SCREEN = null; }

/**
 * Action to show a tooltip. A node should expose this action only for views with tooltip
 * text that but are not currently showing a tooltip.
 * @apiSince 28
 */

public static final android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction ACTION_SHOW_TOOLTIP;
static { ACTION_SHOW_TOOLTIP = null; }
}

/**
 * Class with information if a node is a collection. Use
 * {@link android.view.accessibility.AccessibilityNodeInfo.CollectionInfo#obtain(int,int,boolean) CollectionInfo#obtain(int, int, boolean)} to get an instance. Recycling is
 * handled by the {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo} to which this object is attached.
 * <p>
 * A collection of items has rows and columns and may be hierarchical.
 * For example, a horizontal list is a collection with one column, as
 * many rows as the list items, and is not hierarchical; A table is a
 * collection with several rows, several columns, and is not hierarchical;
 * A vertical tree is a hierarchical collection with one column and
 * as many rows as the first level children.
 * </p>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CollectionInfo {

private CollectionInfo() { throw new RuntimeException("Stub!"); }

/**
 * Obtains a pooled instance.
 *
 * @param rowCount The number of rows.
 * @param columnCount The number of columns.
 * @param hierarchical Whether the collection is hierarchical.
 * @apiSince 19
 */

public static android.view.accessibility.AccessibilityNodeInfo.CollectionInfo obtain(int rowCount, int columnCount, boolean hierarchical) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a pooled instance.
 *
 * @param rowCount The number of rows.
 * @param columnCount The number of columns.
 * @param hierarchical Whether the collection is hierarchical.
 * @param selectionMode The collection's selection mode, one of:
 *            <ul>
 *            <li>{@link #SELECTION_MODE_NONE}
 *            <li>{@link #SELECTION_MODE_SINGLE}
 *            <li>{@link #SELECTION_MODE_MULTIPLE}
 *            </ul>
 * @apiSince 21
 */

public static android.view.accessibility.AccessibilityNodeInfo.CollectionInfo obtain(int rowCount, int columnCount, boolean hierarchical, int selectionMode) { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of rows.
 *
 * @return The row count.
 * @apiSince 19
 */

public int getRowCount() { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of columns.
 *
 * @return The column count.
 * @apiSince 19
 */

public int getColumnCount() { throw new RuntimeException("Stub!"); }

/**
 * Gets if the collection is a hierarchically ordered.
 *
 * @return Whether the collection is hierarchical.
 * @apiSince 19
 */

public boolean isHierarchical() { throw new RuntimeException("Stub!"); }

/**
 * Gets the collection's selection mode.
 *
 * @return The collection's selection mode, one of:
 *         <ul>
 *         <li>{@link #SELECTION_MODE_NONE}
 *         <li>{@link #SELECTION_MODE_SINGLE}
 *         <li>{@link #SELECTION_MODE_MULTIPLE}
 *         </ul>
 * @apiSince 21
 */

public int getSelectionMode() { throw new RuntimeException("Stub!"); }

/**
 * Selection mode where multiple items may be selected.
 * @apiSince 21
 */

public static final int SELECTION_MODE_MULTIPLE = 2; // 0x2

/**
 * Selection mode where items are not selectable.
 * @apiSince 21
 */

public static final int SELECTION_MODE_NONE = 0; // 0x0

/**
 * Selection mode where a single item may be selected.
 * @apiSince 21
 */

public static final int SELECTION_MODE_SINGLE = 1; // 0x1
}

/**
 * Class with information if a node is a collection item. Use
 * {@link android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo#obtain(int,int,int,int,boolean) CollectionItemInfo#obtain(int, int, int, int, boolean)}
 * to get an instance. Recycling is handled by the {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo} to which this
 * object is attached.
 * <p>
 * A collection item is contained in a collection, it starts at
 * a given row and column in the collection, and spans one or
 * more rows and columns. For example, a header of two related
 * table columns starts at the first row and the first column,
 * spans one row and two columns.
 * </p>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CollectionItemInfo {

private CollectionItemInfo() { throw new RuntimeException("Stub!"); }

/**
 * Obtains a pooled instance.
 *
 * @param rowIndex The row index at which the item is located.
 * @param rowSpan The number of rows the item spans.
 * @param columnIndex The column index at which the item is located.
 * @param columnSpan The number of columns the item spans.
 * @param heading Whether the item is a heading. (Prefer
 *                {@link android.view.accessibility.AccessibilityNodeInfo#setHeading(boolean) AccessibilityNodeInfo#setHeading(boolean)}).
 * @apiSince 19
 */

public static android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo obtain(int rowIndex, int rowSpan, int columnIndex, int columnSpan, boolean heading) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a pooled instance.
 *
 * @param rowIndex The row index at which the item is located.
 * @param rowSpan The number of rows the item spans.
 * @param columnIndex The column index at which the item is located.
 * @param columnSpan The number of columns the item spans.
 * @param heading Whether the item is a heading. (Prefer
 *                {@link android.view.accessibility.AccessibilityNodeInfo#setHeading(boolean) AccessibilityNodeInfo#setHeading(boolean)})
 * @param selected Whether the item is selected.
 * @apiSince 21
 */

public static android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo obtain(int rowIndex, int rowSpan, int columnIndex, int columnSpan, boolean heading, boolean selected) { throw new RuntimeException("Stub!"); }

/**
 * Gets the column index at which the item is located.
 *
 * @return The column index.
 * @apiSince 19
 */

public int getColumnIndex() { throw new RuntimeException("Stub!"); }

/**
 * Gets the row index at which the item is located.
 *
 * @return The row index.
 * @apiSince 19
 */

public int getRowIndex() { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of columns the item spans.
 *
 * @return The column span.
 * @apiSince 19
 */

public int getColumnSpan() { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of rows the item spans.
 *
 * @return The row span.
 * @apiSince 19
 */

public int getRowSpan() { throw new RuntimeException("Stub!"); }

/**
 * Gets if the collection item is a heading. For example, section
 * heading, table header, etc.
 *
 * @return If the item is a heading.
 * @deprecated Use {@link android.view.accessibility.AccessibilityNodeInfo#isHeading() AccessibilityNodeInfo#isHeading()}
 * @apiSince 19
 * @deprecatedSince 28
 */

@Deprecated
public boolean isHeading() { throw new RuntimeException("Stub!"); }

/**
 * Gets if the collection item is selected.
 *
 * @return If the item is selected.
 * @apiSince 21
 */

public boolean isSelected() { throw new RuntimeException("Stub!"); }
}

/**
 * Class with information if a node is a range. Use
 * {@link android.view.accessibility.AccessibilityNodeInfo.RangeInfo#obtain(int,float,float,float) RangeInfo#obtain(int, float, float, float)} to get an instance. Recycling is
 * handled by the {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo} to which this object is attached.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class RangeInfo {

private RangeInfo() { throw new RuntimeException("Stub!"); }

/**
 * Obtains a pooled instance.
 *
 * @param type The type of the range.
 * @param min The minimum value. Use {@code Float.NEGATIVE_INFINITY} if the range has no
 *            minimum.
 * @param max The maximum value. Use {@code Float.POSITIVE_INFINITY} if the range has no
 *            maximum.
 * @param current The current value.
 * @apiSince 19
 */

public static android.view.accessibility.AccessibilityNodeInfo.RangeInfo obtain(int type, float min, float max, float current) { throw new RuntimeException("Stub!"); }

/**
 * Gets the range type.
 *
 * @return The range type.
 *
 * @see #RANGE_TYPE_INT
 * @see #RANGE_TYPE_FLOAT
 * @see #RANGE_TYPE_PERCENT
 * @apiSince 19
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Gets the minimum value.
 *
 * @return The minimum value, or {@code Float.NEGATIVE_INFINITY} if no minimum exists.
 * @apiSince 19
 */

public float getMin() { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum value.
 *
 * @return The maximum value, or {@code Float.POSITIVE_INFINITY} if no maximum exists.
 * @apiSince 19
 */

public float getMax() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current value.
 *
 * @return The current value.
 * @apiSince 19
 */

public float getCurrent() { throw new RuntimeException("Stub!"); }

/**
 * Range type: float.
 * @apiSince 19
 */

public static final int RANGE_TYPE_FLOAT = 1; // 0x1

/**
 * Range type: integer.
 * @apiSince 19
 */

public static final int RANGE_TYPE_INT = 0; // 0x0

/**
 * Range type: percent with values from zero to one.
 * @apiSince 19
 */

public static final int RANGE_TYPE_PERCENT = 2; // 0x2
}

/**
 * Class with information of touch delegated views and regions from {@link android.view.TouchDelegate TouchDelegate} for
 * the {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo}.
 *
 * @see android.view.accessibility.AccessibilityNodeInfo#setTouchDelegateInfo(TouchDelegateInfo)
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class TouchDelegateInfo implements android.os.Parcelable {

/**
 * Create a new instance of {@link android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo TouchDelegateInfo}.
 *
 * @param targetMap A map from regions (in view coordinates) to delegated views.
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if targetMap is empty or {@code null} in
 * Regions or Views.
 * @apiSince 29
 */

public TouchDelegateInfo(@androidx.annotation.NonNull java.util.Map<android.graphics.Region,android.view.View> targetMap) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of touch delegate target region.
 *
 * @return Number of touch delegate target region.
 * @apiSince 29
 */

public int getRegionCount() { throw new RuntimeException("Stub!"); }

/**
 * Return the {@link android.graphics.Region Region} at the given index in the {@link android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo TouchDelegateInfo}.
 *
 * @param index The desired index, must be between 0 and {@link #getRegionCount()}-1.
 * @return Returns the {@link android.graphics.Region Region} stored at the given index.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Region getRegionAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return the target {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo} for the given {@link android.graphics.Region Region}.
 * <p>
 *   <strong>Note:</strong> This api can only be called from {@link android.accessibilityservice.AccessibilityService AccessibilityService}.
 * </p>
 * <p>
 *   <strong>Note:</strong> It is a client responsibility to recycle the
 *     received info by calling {@link android.view.accessibility.AccessibilityNodeInfo#recycle() AccessibilityNodeInfo#recycle()}
 *     to avoid creating of multiple instances.
 * </p>
 *
 * @param region The region retrieved from {@link #getRegionAt(int)}.
 * This value must never be {@code null}.
 * @return The target node associates with the given region.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.view.accessibility.AccessibilityNodeInfo getTargetForRegion(@androidx.annotation.NonNull android.graphics.Region region) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 29
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 29
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @see android.os.Parcelable.Creator
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo> CREATOR;
static { CREATOR = null; }
}

}

