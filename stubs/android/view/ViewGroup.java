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


package android.view;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityEvent;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import android.util.SparseArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.Transformation;
import android.animation.LayoutTransition;
import android.view.animation.Animation;
import java.util.List;

/**
 * <p>
 * A <code>ViewGroup</code> is a special view that can contain other views
 * (called children.) The view group is the base class for layouts and views
 * containers. This class also defines the
 * {@link android.view.ViewGroup.LayoutParams} class which serves as the base
 * class for layouts parameters.
 * </p>
 *
 * <p>
 * Also see {@link android.view.ViewGroup.LayoutParams LayoutParams} for layout attributes.
 * </p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about creating user interface layouts, read the
 * <a href="{@docRoot}guide/topics/ui/declaring-layout.html">XML Layouts</a> developer
 * guide.</p></div>
 *
 * <p>Here is a complete implementation of a custom ViewGroup that implements
 * a simple {@link android.widget.FrameLayout} along with the ability to stack
 * children in left and right gutters.</p>
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/view/CustomLayout.java
 *      Complete}
 *
 * <p>If you are implementing XML layout attributes as shown in the example, this is the
 * corresponding definition for them that would go in <code>res/values/attrs.xml</code>:</p>
 *
 * {@sample development/samples/ApiDemos/res/values/attrs.xml CustomLayout}
 *
 * <p>Finally the layout manager can be used in an XML layout like so:</p>
 *
 * {@sample development/samples/ApiDemos/res/layout/custom_layout.xml Complete}
 *
 * @attr ref android.R.styleable#ViewGroup_clipChildren
 * @attr ref android.R.styleable#ViewGroup_clipToPadding
 * @attr ref android.R.styleable#ViewGroup_layoutAnimation
 * @attr ref android.R.styleable#ViewGroup_animationCache
 * @attr ref android.R.styleable#ViewGroup_persistentDrawingCache
 * @attr ref android.R.styleable#ViewGroup_alwaysDrawnWithCache
 * @attr ref android.R.styleable#ViewGroup_addStatesFromChildren
 * @attr ref android.R.styleable#ViewGroup_descendantFocusability
 * @attr ref android.R.styleable#ViewGroup_animateLayoutChanges
 * @attr ref android.R.styleable#ViewGroup_splitMotionEvents
 * @attr ref android.R.styleable#ViewGroup_layoutMode
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ViewGroup extends android.view.View implements android.view.ViewParent, android.view.ViewManager {

/** @apiSince 1 */

public ViewGroup(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ViewGroup(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ViewGroup(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public ViewGroup(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Gets the descendant focusability of this view group.  The descendant
 * focusability defines the relationship between this view group and its
 * descendants when looking for a view to take focus in
 * {@link #requestFocus(int,android.graphics.Rect)}.
 *
 * @return one of {@link #FOCUS_BEFORE_DESCENDANTS}, {@link #FOCUS_AFTER_DESCENDANTS},
 *   {@link #FOCUS_BLOCK_DESCENDANTS}.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="focus", mapping={@android.view.ViewDebug.IntToString(from=android.view.ViewGroup.FOCUS_BEFORE_DESCENDANTS, to="FOCUS_BEFORE_DESCENDANTS"), @android.view.ViewDebug.IntToString(from=android.view.ViewGroup.FOCUS_AFTER_DESCENDANTS, to="FOCUS_AFTER_DESCENDANTS"), @android.view.ViewDebug.IntToString(from=android.view.ViewGroup.FOCUS_BLOCK_DESCENDANTS, to="FOCUS_BLOCK_DESCENDANTS")})
public int getDescendantFocusability() { throw new RuntimeException("Stub!"); }

/**
 * Set the descendant focusability of this view group. This defines the relationship
 * between this view group and its descendants when looking for a view to
 * take focus in {@link #requestFocus(int,android.graphics.Rect)}.
 *
 * @param focusability one of {@link #FOCUS_BEFORE_DESCENDANTS}, {@link #FOCUS_AFTER_DESCENDANTS},
 *   {@link #FOCUS_BLOCK_DESCENDANTS}.
 * @apiSince 1
 */

public void setDescendantFocusability(int focusability) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void requestChildFocus(android.view.View child, android.view.View focused) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void focusableViewAvailable(android.view.View v) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean showContextMenuForChild(android.view.View originalView) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean showContextMenuForChild(android.view.View originalView, float x, float y) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public android.view.ActionMode startActionModeForChild(android.view.View originalView, android.view.ActionMode.Callback callback) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public android.view.ActionMode startActionModeForChild(android.view.View originalView, android.view.ActionMode.Callback callback, int type) { throw new RuntimeException("Stub!"); }

/**
 * Find the nearest view in the specified direction that wants to take
 * focus.
 *
 * @param focused The view that currently has focus
 * @param direction One of FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, and
 *        FOCUS_RIGHT, or 0 for not applicable.
 * @apiSince 1
 */

public android.view.View focusSearch(android.view.View focused, int direction) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean requestChildRectangleOnScreen(android.view.View child, android.graphics.Rect rectangle, boolean immediate) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public boolean requestSendAccessibilityEvent(android.view.View child, android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called when a child has requested sending an {@link android.view.accessibility.AccessibilityEvent AccessibilityEvent} and
 * gives an opportunity to its parent to augment the event.
 * <p>
 * If an {@link android.view.View.AccessibilityDelegate} has been specified via calling
 * {@link android.view.View#setAccessibilityDelegate(android.view.View.AccessibilityDelegate)} its
 * {@link android.view.View.AccessibilityDelegate#onRequestSendAccessibilityEvent(ViewGroup, View, AccessibilityEvent)}
 * is responsible for handling this call.
 * </p>
 *
 * @param child The child which requests sending the event.
 * @param event The event to be sent.
 * @return True if the event should be sent.
 *
 * @see #requestSendAccessibilityEvent(View, AccessibilityEvent)
 * @apiSince 14
 */

public boolean onRequestSendAccessibilityEvent(android.view.View child, android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called when a child view has changed whether or not it is tracking transient state.
 * @apiSince 19
 */

public void childHasTransientStateChanged(android.view.View child, boolean childHasTransientState) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public boolean hasTransientState() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean dispatchUnhandledMove(android.view.View focused, int direction) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void clearChildFocus(android.view.View child) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void clearFocus() { throw new RuntimeException("Stub!"); }

/**
 * Returns the focused child of this view, if any. The child may have focus
 * or contain focus.
 *
 * @return the focused child or null.
 * @apiSince 1
 */

public android.view.View getFocusedChild() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this view has or contains focus
 *
 * @return true if this view has or contains focus
 * @apiSince 1
 */

public boolean hasFocus() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.view.View findFocus() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void addFocusables(java.util.ArrayList<android.view.View> views, int direction, int focusableMode) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void addKeyboardNavigationClusters(java.util.Collection<android.view.View> views, int direction) { throw new RuntimeException("Stub!"); }

/**
 * Set whether this ViewGroup should ignore focus requests for itself and its children.
 * If this option is enabled and the ViewGroup or a descendant currently has focus, focus
 * will proceed forward.
 *
 * @param touchscreenBlocksFocus true to enable blocking focus in the presence of a touchscreen
 * @apiSince 21
 */

public void setTouchscreenBlocksFocus(boolean touchscreenBlocksFocus) { throw new RuntimeException("Stub!"); }

/**
 * Check whether this ViewGroup should ignore focus requests for itself and its children.
 * @apiSince 21
 */

@android.view.ViewDebug.ExportedProperty(category="focus")
public boolean getTouchscreenBlocksFocus() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public void findViewsWithText(java.util.ArrayList<android.view.View> outViews, java.lang.CharSequence text, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void dispatchWindowFocusChanged(boolean hasFocus) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void addTouchables(java.util.ArrayList<android.view.View> views) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void dispatchDisplayHint(int hint) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

protected void dispatchVisibilityChanged(android.view.View changedView, int visibility) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void dispatchWindowVisibilityChanged(int visibility) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void dispatchConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void recomputeViewAttributes(android.view.View child) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void bringChildToFront(android.view.View child) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public boolean dispatchDragEvent(android.view.DragEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void dispatchWindowSystemUiVisiblityChanged(int visible) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void dispatchSystemUiVisibilityChanged(int visible) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean dispatchKeyEventPreIme(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean dispatchKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean dispatchKeyShortcutEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean dispatchTrackballEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean dispatchCapturedPointerEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void dispatchPointerCaptureChanged(boolean hasCapture) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.view.PointerIcon onResolvePointerIcon(android.view.MotionEvent event, int pointerIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

protected boolean dispatchHoverEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void addChildrenForAccessibility(java.util.ArrayList<android.view.View> outChildren) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to intercept hover events before they are handled
 * by child views.
 * <p>
 * This method is called before dispatching a hover event to a child of
 * the view group or to the view group's own {@link #onHoverEvent} to allow
 * the view group a chance to intercept the hover event.
 * This method can also be used to watch all pointer motions that occur within
 * the bounds of the view group even when the pointer is hovering over
 * a child of the view group rather than over the view group itself.
 * </p><p>
 * The view group can prevent its children from receiving hover events by
 * implementing this method and returning <code>true</code> to indicate
 * that it would like to intercept hover events.  The view group must
 * continuously return <code>true</code> from {@link #onInterceptHoverEvent}
 * for as long as it wishes to continue intercepting hover events from
 * its children.
 * </p><p>
 * Interception preserves the invariant that at most one view can be
 * hovered at a time by transferring hover focus from the currently hovered
 * child to the view group or vice-versa as needed.
 * </p><p>
 * If this method returns <code>true</code> and a child is already hovered, then the
 * child view will first receive a hover exit event and then the view group
 * itself will receive a hover enter event in {@link #onHoverEvent}.
 * Likewise, if this method had previously returned <code>true</code> to intercept hover
 * events and instead returns <code>false</code> while the pointer is hovering
 * within the bounds of one of a child, then the view group will first receive a
 * hover exit event in {@link #onHoverEvent} and then the hovered child will
 * receive a hover enter event.
 * </p><p>
 * The default implementation handles mouse hover on the scroll bars.
 * </p>
 *
 * @param event The motion event that describes the hover.
 * @return True if the view group would like to intercept the hover event
 * and prevent its children from receiving it.
 * @apiSince 14
 */

public boolean onInterceptHoverEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

protected boolean dispatchGenericPointerEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

protected boolean dispatchGenericFocusedEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean dispatchTouchEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

/**
 * Enable or disable the splitting of MotionEvents to multiple children during touch event
 * dispatch. This behavior is enabled by default for applications that target an
 * SDK version of {@link android.os.Build.VERSION_CODES#HONEYCOMB Build.VERSION_CODES#HONEYCOMB} or newer.
 *
 * <p>When this option is enabled MotionEvents may be split and dispatched to different child
 * views depending on where each pointer initially went down. This allows for user interactions
 * such as scrolling two panes of content independently, chording of buttons, and performing
 * independent gestures on different pieces of content.
 *
 * @param split <code>true</code> to allow MotionEvents to be split and dispatched to multiple
 *              child views. <code>false</code> to only allow one child view to be the target of
 *              any MotionEvent received by this ViewGroup.
 * @attr ref android.R.styleable#ViewGroup_splitMotionEvents
 * @apiSince 11
 */

public void setMotionEventSplittingEnabled(boolean split) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if MotionEvents dispatched to this ViewGroup can be split to multiple children.
 * @return true if MotionEvents dispatched to this ViewGroup can be split to multiple children.
 * @apiSince 11
 */

public boolean isMotionEventSplittingEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this ViewGroup should be considered as a single entity for removal
 * when executing an Activity transition. If this is false, child elements will move
 * individually during the transition.
 *
 * @return True if the ViewGroup should be acted on together during an Activity transition.
 * The default value is true when there is a non-null background or if
 * {@link #getTransitionName()} is not null or if a
 * non-null {@link android.view.ViewOutlineProvider} other than
 * {@link android.view.ViewOutlineProvider#BACKGROUND} was given to
 * {@link #setOutlineProvider(android.view.ViewOutlineProvider)} and false otherwise.
 * @apiSince 21
 */

public boolean isTransitionGroup() { throw new RuntimeException("Stub!"); }

/**
 * Changes whether or not this ViewGroup should be treated as a single entity during
 * Activity Transitions.
 * @param isTransitionGroup Whether or not the ViewGroup should be treated as a unit
 *                          in Activity transitions. If false, the ViewGroup won't transition,
 *                          only its children. If true, the entire ViewGroup will transition
 *                          together.
 * @see android.app.ActivityOptions#makeSceneTransitionAnimation(android.app.Activity,
 * android.util.Pair[])
 * @apiSince 21
 */

public void setTransitionGroup(boolean isTransitionGroup) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to intercept all touch screen motion events.  This
 * allows you to watch events as they are dispatched to your children, and
 * take ownership of the current gesture at any point.
 *
 * <p>Using this function takes some care, as it has a fairly complicated
 * interaction with {@link android.view.View#onTouchEvent(android.view.MotionEvent) View#onTouchEvent(MotionEvent)}, and using it requires implementing
 * that method as well as this one in the correct way.  Events will be
 * received in the following order:
 *
 * <ol>
 * <li> You will receive the down event here.
 * <li> The down event will be handled either by a child of this view
 * group, or given to your own onTouchEvent() method to handle; this means
 * you should implement onTouchEvent() to return true, so you will
 * continue to see the rest of the gesture (instead of looking for
 * a parent view to handle it).  Also, by returning true from
 * onTouchEvent(), you will not receive any following
 * events in onInterceptTouchEvent() and all touch processing must
 * happen in onTouchEvent() like normal.
 * <li> For as long as you return false from this function, each following
 * event (up to and including the final up) will be delivered first here
 * and then to the target's onTouchEvent().
 * <li> If you return true from here, you will not receive any
 * following events: the target view will receive the same event but
 * with the action {@link android.view.MotionEvent#ACTION_CANCEL MotionEvent#ACTION_CANCEL}, and all further
 * events will be delivered to your onTouchEvent() method and no longer
 * appear here.
 * </ol>
 *
 * @param ev The motion event being dispatched down the hierarchy.
 * @return Return true to steal motion events from the children and have
 * them dispatched to this ViewGroup through onTouchEvent().
 * The current target will receive an ACTION_CANCEL event, and no further
 * messages will be delivered here.
 * @apiSince 1
 */

public boolean onInterceptTouchEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * Looks for a view to give focus to respecting the setting specified by
 * {@link #getDescendantFocusability()}.
 *
 * Uses {@link #onRequestFocusInDescendants(int,android.graphics.Rect)} to
 * find focus within the children of this group when appropriate.
 *
 * @see #FOCUS_BEFORE_DESCENDANTS
 * @see #FOCUS_AFTER_DESCENDANTS
 * @see #FOCUS_BLOCK_DESCENDANTS
 * @see #onRequestFocusInDescendants(int, android.graphics.Rect)
 * @apiSince 1
 */

public boolean requestFocus(int direction, android.graphics.Rect previouslyFocusedRect) { throw new RuntimeException("Stub!"); }

/**
 * Look for a descendant to call {@link android.view.View#requestFocus View#requestFocus} on.
 * Called by {@link android.view.ViewGroup#requestFocus(int,android.graphics.Rect) ViewGroup#requestFocus(int, android.graphics.Rect)}
 * when it wants to request focus within its children.  Override this to
 * customize how your {@link android.view.ViewGroup ViewGroup} requests focus within its children.
 * @param direction One of FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, and FOCUS_RIGHT
 * @param previouslyFocusedRect The rectangle (in this View's coordinate system)
 *        to give a finer grained hint about where focus is coming from.  May be null
 *        if there is no hint.
 * @return Whether focus was taken.
 * @apiSince 1
 */

protected boolean onRequestFocusInDescendants(int direction, android.graphics.Rect previouslyFocusedRect) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean restoreDefaultFocus() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @hide
 */

public void dispatchStartTemporaryDetach() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @hide
 */

public void dispatchFinishTemporaryDetach() { throw new RuntimeException("Stub!"); }

/**
 * Dispatch creation of {@link android.view.ViewStructure ViewStructure} down the hierarchy.  This implementation
 * adds in all child views of the view group, in addition to calling the default View
 * implementation.
 * @apiSince 23
 */

public void dispatchProvideStructure(android.view.ViewStructure structure) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This implementation adds in all child views of the view group, in addition to calling the
 * default {@link android.view.View View} implementation.
 
 * @param flags Value is either <code>0</code> or {@link android.view.View#AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS}
 * @apiSince 26
 */

public void dispatchProvideAutofillStructure(android.view.ViewStructure structure, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void notifySubtreeAccessibilityStateChanged(android.view.View child, android.view.View source, int changeType) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>Subclasses should always call <code>super.onNestedPrePerformAccessibilityAction</code></p>
 *
 * @param target The target view dispatching this action
 * @param action Action being performed; see
 *               {@link android.view.accessibility.AccessibilityNodeInfo}
 * @param args Optional action arguments
 * @return false by default. Subclasses should return true if they handle the event.
 * @apiSince 22
 */

public boolean onNestedPrePerformAccessibilityAction(android.view.View target, int action, android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void dispatchSaveInstanceState(android.util.SparseArray<android.os.Parcelable> container) { throw new RuntimeException("Stub!"); }

/**
 * Perform dispatching of a {@link #saveHierarchyState(android.util.SparseArray)}  freeze()}
 * to only this view, not to its children.  For use when overriding
 * {@link #dispatchSaveInstanceState(android.util.SparseArray)}  dispatchFreeze()} to allow
 * subclasses to freeze their own state but not the state of their children.
 *
 * @param container the container
 * @apiSince 1
 */

protected void dispatchFreezeSelfOnly(android.util.SparseArray<android.os.Parcelable> container) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void dispatchRestoreInstanceState(android.util.SparseArray<android.os.Parcelable> container) { throw new RuntimeException("Stub!"); }

/**
 * Perform dispatching of a {@link #restoreHierarchyState(android.util.SparseArray)}
 * to only this view, not to its children.  For use when overriding
 * {@link #dispatchRestoreInstanceState(android.util.SparseArray)} to allow
 * subclasses to thaw their own state but not the state of their children.
 *
 * @param container the container
 * @apiSince 1
 */

protected void dispatchThawSelfOnly(android.util.SparseArray<android.os.Parcelable> container) { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables the drawing cache for each child of this view group.
 *
 * @param enabled true to enable the cache, false to dispose of it
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int,android.graphics.Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link android.graphics.Canvas Canvas} from either a {@link android.graphics.Bitmap Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(android.graphics.Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link android.view.PixelCopy PixelCopy} API is recommended.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
protected void setChildrenDrawingCacheEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void dispatchDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Returns the ViewGroupOverlay for this view group, creating it if it does
 * not yet exist. In addition to {@link android.view.ViewOverlay ViewOverlay}'s support for drawables,
 * {@link android.view.ViewGroupOverlay ViewGroupOverlay} allows views to be added to the overlay. These
 * views, like overlay drawables, are visual-only; they do not receive input
 * events and should not be used as anything other than a temporary
 * representation of a view in a parent container, such as might be used
 * by an animation effect.
 *
 * <p>Note: Overlays do not currently work correctly with {@link android.view.SurfaceView SurfaceView} or {@link android.view.TextureView TextureView}; contents in overlays for these
 * types of views may not display correctly.</p>
 *
 * @return The ViewGroupOverlay object for this view.
 * @see android.view.ViewGroupOverlay
 * @apiSince 18
 */

public android.view.ViewGroupOverlay getOverlay() { throw new RuntimeException("Stub!"); }

/**
 * Converts drawing order position to container position. Override this
 * if you want to change the drawing order of children. By default, it
 * returns drawingPosition.
 * <p>
 * NOTE: In order for this method to be called, you must enable child ordering
 * first by calling {@link #setChildrenDrawingOrderEnabled(boolean)}.
 *
 * @param drawingPosition the drawing order position.
 * @return the container position of a child for this drawing order position.
 *
 * @see #setChildrenDrawingOrderEnabled(boolean)
 * @see #isChildrenDrawingOrderEnabled()
 * @apiSince 1
 */

protected int getChildDrawingOrder(int childCount, int drawingPosition) { throw new RuntimeException("Stub!"); }

/**
 * Converts drawing order position to container position.
 * <p>
 * Children are not necessarily drawn in the order in which they appear in the container.
 * ViewGroups can enable a custom ordering via {@link #setChildrenDrawingOrderEnabled(boolean)}.
 * This method returns the container position of a child that appears in the given position
 * in the current drawing order.
 *
 * @param drawingPosition the drawing order position.
 * @return the container position of a child for this drawing order position.
 *
 * @see #getChildDrawingOrder(int, int)}
 * @apiSince 29
 */

public final int getChildDrawingOrder(int drawingPosition) { throw new RuntimeException("Stub!"); }

/**
 * Draw one child of this View Group. This method is responsible for getting
 * the canvas in the right state. This includes clipping, translating so
 * that the child's scrolled origin is at 0, 0, and applying any animation
 * transformations.
 *
 * @param canvas The canvas on which to draw the child
 * @param child Who to draw
 * @param drawingTime The time at which draw is occurring
 * @return True if an invalidate() was issued
 * @apiSince 1
 */

protected boolean drawChild(android.graphics.Canvas canvas, android.view.View child, long drawingTime) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this group's children are clipped to their bounds before drawing.
 * The default value is true.
 * @see #setClipChildren(boolean)
 *
 * @return True if the group's children will be clipped to their bounds,
 * false otherwise.
 * @apiSince 18
 */

@android.view.ViewDebug.ExportedProperty(category="drawing")
public boolean getClipChildren() { throw new RuntimeException("Stub!"); }

/**
 * By default, children are clipped to their bounds before drawing. This
 * allows view groups to override this behavior for animations, etc.
 *
 * @param clipChildren true to clip children to their bounds,
 *        false otherwise
 * @attr ref android.R.styleable#ViewGroup_clipChildren
 * @apiSince 1
 */

public void setClipChildren(boolean clipChildren) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this ViewGroup will clip its children to its padding and resize (but not
 * clip) any EdgeEffect to the padded region, if padding is present.
 * <p>
 * By default, children are clipped to the padding of their parent
 * ViewGroup. This clipping behavior is only enabled if padding is non-zero.
 *
 * @param clipToPadding true to clip children to the padding of the group, and resize (but
 *        not clip) any EdgeEffect to the padded region. False otherwise.
 * @attr ref android.R.styleable#ViewGroup_clipToPadding
 * @apiSince 1
 */

public void setClipToPadding(boolean clipToPadding) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this ViewGroup will clip its children to its padding, and resize (but
 * not clip) any EdgeEffect to the padded region, if padding is present.
 * <p>
 * By default, children are clipped to the padding of their parent
 * Viewgroup. This clipping behavior is only enabled if padding is non-zero.
 *
 * @return true if this ViewGroup clips children to its padding and resizes (but doesn't
 *         clip) any EdgeEffect to the padded region, false otherwise.
 *
 * @attr ref android.R.styleable#ViewGroup_clipToPadding
 * @apiSince 21
 */

@android.view.ViewDebug.ExportedProperty(category="drawing")
public boolean getClipToPadding() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void dispatchSetSelected(boolean selected) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void dispatchSetActivated(boolean activated) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void dispatchSetPressed(boolean pressed) { throw new RuntimeException("Stub!"); }

/**
 * Dispatches drawable hotspot changes to child views that meet at least
 * one of the following criteria:
 * <ul>
 *     <li>Returns {@code false} from both {@link android.view.View#isClickable() View#isClickable()} and
 *     {@link android.view.View#isLongClickable() View#isLongClickable()}</li>
 *     <li>Requests duplication of parent state via
 *     {@link android.view.View#setDuplicateParentStateEnabled(boolean) View#setDuplicateParentStateEnabled(boolean)}</li>
 * </ul>
 *
 * @param x hotspot x coordinate
 * @param y hotspot y coordinate
 * @see #drawableHotspotChanged(float, float)
 * @apiSince 22
 */

public void dispatchDrawableHotspotChanged(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * When this property is set to true, this ViewGroup supports static transformations on
 * children; this causes
 * {@link #getChildStaticTransformation(android.view.View,android.view.animation.Transformation)} to be
 * invoked when a child is drawn.
 *
 * Any subclass overriding
 * {@link #getChildStaticTransformation(android.view.View,android.view.animation.Transformation)} should
 * set this property to true.
 *
 * @param enabled True to enable static transformations on children, false otherwise.
 *
 * @see #getChildStaticTransformation(View, android.view.animation.Transformation)
 * @apiSince 3
 */

protected void setStaticTransformationsEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Sets  <code>t</code> to be the static transformation of the child, if set, returning a
 * boolean to indicate whether a static transform was set. The default implementation
 * simply returns <code>false</code>; subclasses may override this method for different
 * behavior. {@link #setStaticTransformationsEnabled(boolean)} must be set to true
 * for this method to be called.
 *
 * @param child The child view whose static transform is being requested
 * @param t The Transformation which will hold the result
 * @return true if the transformation was set, false otherwise
 * @see #setStaticTransformationsEnabled(boolean)
 * @apiSince 1
 */

protected boolean getChildStaticTransformation(android.view.View child, android.view.animation.Transformation t) { throw new RuntimeException("Stub!"); }

/**
 * <p>Adds a child view. If no layout parameters are already set on the child, the
 * default parameters for this ViewGroup are set on the child.</p>
 *
 * <p><strong>Note:</strong> do not invoke this method from
 * {@link #draw(android.graphics.Canvas)}, {@link #onDraw(android.graphics.Canvas)},
 * {@link #dispatchDraw(android.graphics.Canvas)} or any related method.</p>
 *
 * @param child the child view to add
 *
 * @see #generateDefaultLayoutParams()
 * @apiSince 1
 */

public void addView(android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * Adds a child view. If no layout parameters are already set on the child, the
 * default parameters for this ViewGroup are set on the child.
 *
 * <p><strong>Note:</strong> do not invoke this method from
 * {@link #draw(android.graphics.Canvas)}, {@link #onDraw(android.graphics.Canvas)},
 * {@link #dispatchDraw(android.graphics.Canvas)} or any related method.</p>
 *
 * @param child the child view to add
 * @param index the position at which to add the child
 *
 * @see #generateDefaultLayoutParams()
 * @apiSince 1
 */

public void addView(android.view.View child, int index) { throw new RuntimeException("Stub!"); }

/**
 * Adds a child view with this ViewGroup's default layout parameters and the
 * specified width and height.
 *
 * <p><strong>Note:</strong> do not invoke this method from
 * {@link #draw(android.graphics.Canvas)}, {@link #onDraw(android.graphics.Canvas)},
 * {@link #dispatchDraw(android.graphics.Canvas)} or any related method.</p>
 *
 * @param child the child view to add
 * @apiSince 1
 */

public void addView(android.view.View child, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Adds a child view with the specified layout parameters.
 *
 * <p><strong>Note:</strong> do not invoke this method from
 * {@link #draw(android.graphics.Canvas)}, {@link #onDraw(android.graphics.Canvas)},
 * {@link #dispatchDraw(android.graphics.Canvas)} or any related method.</p>
 *
 * @param child the child view to add
 * @param params the layout parameters to set on the child
 * @apiSince 1
 */

public void addView(android.view.View child, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * Adds a child view with the specified layout parameters.
 *
 * <p><strong>Note:</strong> do not invoke this method from
 * {@link #draw(android.graphics.Canvas)}, {@link #onDraw(android.graphics.Canvas)},
 * {@link #dispatchDraw(android.graphics.Canvas)} or any related method.</p>
 *
 * @param child the child view to add
 * @param index the position at which to add the child or -1 to add last
 * @param params the layout parameters to set on the child
 * @apiSince 1
 */

public void addView(android.view.View child, int index, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void updateViewLayout(android.view.View view, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when a child is added to or removed
 * from this view.
 *
 * @param listener the callback to invoke on hierarchy change
 * @apiSince 1
 */

public void setOnHierarchyChangeListener(android.view.ViewGroup.OnHierarchyChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Called when a new child is added to this ViewGroup. Overrides should always
 * call super.onViewAdded.
 *
 * @param child the added child view
 * @apiSince 23
 */

public void onViewAdded(android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * Called when a child view is removed from this ViewGroup. Overrides should always
 * call super.onViewRemoved.
 *
 * @param child the removed child view
 * @apiSince 23
 */

public void onViewRemoved(android.view.View child) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/**
 * Adds a view during layout. This is useful if in your onLayout() method,
 * you need to add more views (as does the list view for example).
 *
 * If index is negative, it means put it at the end of the list.
 *
 * @param child the view to add to the group
 * @param index the index at which the child must be added or -1 to add last
 * @param params the layout parameters to associate with the child
 * @return true if the child was added, false otherwise
 * @apiSince 1
 */

protected boolean addViewInLayout(android.view.View child, int index, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * Adds a view during layout. This is useful if in your onLayout() method,
 * you need to add more views (as does the list view for example).
 *
 * If index is negative, it means put it at the end of the list.
 *
 * @param child the view to add to the group
 * @param index the index at which the child must be added or -1 to add last
 * @param params the layout parameters to associate with the child
 * @param preventRequestLayout if true, calling this method will not trigger a
 *        layout request on child
 * @return true if the child was added, false otherwise
 * @apiSince 1
 */

protected boolean addViewInLayout(android.view.View child, int index, android.view.ViewGroup.LayoutParams params, boolean preventRequestLayout) { throw new RuntimeException("Stub!"); }

/**
 * Prevents the specified child to be laid out during the next layout pass.
 *
 * @param child the child on which to perform the cleanup
 * @apiSince 1
 */

protected void cleanupLayoutState(android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * Subclasses should override this method to set layout animation
 * parameters on the supplied child.
 *
 * @param child the child to associate with animation parameters
 * @param params the child's layout parameters which hold the animation
 *        parameters
 * @param index the index of the child in the view group
 * @param count the number of children in the view group
 * @apiSince 1
 */

protected void attachLayoutAnimationParameters(android.view.View child, android.view.ViewGroup.LayoutParams params, int index, int count) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p><strong>Note:</strong> do not invoke this method from
 * {@link #draw(android.graphics.Canvas)}, {@link #onDraw(android.graphics.Canvas)},
 * {@link #dispatchDraw(android.graphics.Canvas)} or any related method.</p>
 * @apiSince 1
 */

public void removeView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Removes a view during layout. This is useful if in your onLayout() method,
 * you need to remove more views.
 *
 * <p><strong>Note:</strong> do not invoke this method from
 * {@link #draw(android.graphics.Canvas)}, {@link #onDraw(android.graphics.Canvas)},
 * {@link #dispatchDraw(android.graphics.Canvas)} or any related method.</p>
 *
 * @param view the view to remove from the group
 * @apiSince 1
 */

public void removeViewInLayout(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Removes a range of views during layout. This is useful if in your onLayout() method,
 * you need to remove more views.
 *
 * <p><strong>Note:</strong> do not invoke this method from
 * {@link #draw(android.graphics.Canvas)}, {@link #onDraw(android.graphics.Canvas)},
 * {@link #dispatchDraw(android.graphics.Canvas)} or any related method.</p>
 *
 * @param start the index of the first view to remove from the group
 * @param count the number of views to remove from the group
 * @apiSince 1
 */

public void removeViewsInLayout(int start, int count) { throw new RuntimeException("Stub!"); }

/**
 * Removes the view at the specified position in the group.
 *
 * <p><strong>Note:</strong> do not invoke this method from
 * {@link #draw(android.graphics.Canvas)}, {@link #onDraw(android.graphics.Canvas)},
 * {@link #dispatchDraw(android.graphics.Canvas)} or any related method.</p>
 *
 * @param index the position in the group of the view to remove
 * @apiSince 1
 */

public void removeViewAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Removes the specified range of views from the group.
 *
 * <p><strong>Note:</strong> do not invoke this method from
 * {@link #draw(android.graphics.Canvas)}, {@link #onDraw(android.graphics.Canvas)},
 * {@link #dispatchDraw(android.graphics.Canvas)} or any related method.</p>
 *
 * @param start the first position in the group of the range of views to remove
 * @param count the number of views to remove
 * @apiSince 1
 */

public void removeViews(int start, int count) { throw new RuntimeException("Stub!"); }

/**
 * Sets the LayoutTransition object for this ViewGroup. If the LayoutTransition object is
 * not null, changes in layout which occur because of children being added to or removed from
 * the ViewGroup will be animated according to the animations defined in that LayoutTransition
 * object. By default, the transition object is null (so layout changes are not animated).
 *
 * <p>Replacing a non-null transition will cause that previous transition to be
 * canceled, if it is currently running, to restore this container to
 * its correct post-transition state.</p>
 *
 * @param transition The LayoutTransition object that will animated changes in layout. A value
 * of <code>null</code> means no transition will run on layout changes.
 * @attr ref android.R.styleable#ViewGroup_animateLayoutChanges
 * @apiSince 11
 */

public void setLayoutTransition(android.animation.LayoutTransition transition) { throw new RuntimeException("Stub!"); }

/**
 * Gets the LayoutTransition object for this ViewGroup. If the LayoutTransition object is
 * not null, changes in layout which occur because of children being added to or removed from
 * the ViewGroup will be animated according to the animations defined in that LayoutTransition
 * object. By default, the transition object is null (so layout changes are not animated).
 *
 * @return LayoutTranstion The LayoutTransition object that will animated changes in layout.
 * A value of <code>null</code> means no transition will run on layout changes.
 * @apiSince 11
 */

public android.animation.LayoutTransition getLayoutTransition() { throw new RuntimeException("Stub!"); }

/**
 * Call this method to remove all child views from the
 * ViewGroup.
 *
 * <p><strong>Note:</strong> do not invoke this method from
 * {@link #draw(android.graphics.Canvas)}, {@link #onDraw(android.graphics.Canvas)},
 * {@link #dispatchDraw(android.graphics.Canvas)} or any related method.</p>
 * @apiSince 1
 */

public void removeAllViews() { throw new RuntimeException("Stub!"); }

/**
 * Called by a ViewGroup subclass to remove child views from itself,
 * when it must first know its size on screen before it can calculate how many
 * child views it will render. An example is a Gallery or a ListView, which
 * may "have" 50 children, but actually only render the number of children
 * that can currently fit inside the object on screen. Do not call
 * this method unless you are extending ViewGroup and understand the
 * view measuring and layout pipeline.
 *
 * <p><strong>Note:</strong> do not invoke this method from
 * {@link #draw(android.graphics.Canvas)}, {@link #onDraw(android.graphics.Canvas)},
 * {@link #dispatchDraw(android.graphics.Canvas)} or any related method.</p>
 * @apiSince 1
 */

public void removeAllViewsInLayout() { throw new RuntimeException("Stub!"); }

/**
 * Finishes the removal of a detached view. This method will dispatch the detached from
 * window event and notify the hierarchy change listener.
 * <p>
 * This method is intended to be lightweight and makes no assumptions about whether the
 * parent or child should be redrawn. Proper use of this method will include also making
 * any appropriate {@link #requestLayout()} or {@link #invalidate()} calls.
 * For example, callers can {@link #post(java.lang.Runnable) post} a {@link java.lang.Runnable Runnable}
 * which performs a {@link #requestLayout()} on the next frame, after all detach/remove
 * calls are finished, causing layout to be run prior to redrawing the view hierarchy.
 *
 * @param child the child to be definitely removed from the view hierarchy
 * @param animate if true and the view has an animation, the view is placed in the
 *                disappearing views list, otherwise, it is detached from the window
 *
 * @see #attachViewToParent(View, int, android.view.ViewGroup.LayoutParams)
 * @see #detachAllViewsFromParent()
 * @see #detachViewFromParent(View)
 * @see #detachViewFromParent(int)
 * @apiSince 1
 */

protected void removeDetachedView(android.view.View child, boolean animate) { throw new RuntimeException("Stub!"); }

/**
 * Attaches a view to this view group. Attaching a view assigns this group as the parent,
 * sets the layout parameters and puts the view in the list of children so that
 * it can be retrieved by calling {@link #getChildAt(int)}.
 * <p>
 * This method is intended to be lightweight and makes no assumptions about whether the
 * parent or child should be redrawn. Proper use of this method will include also making
 * any appropriate {@link #requestLayout()} or {@link #invalidate()} calls.
 * For example, callers can {@link #post(java.lang.Runnable) post} a {@link java.lang.Runnable Runnable}
 * which performs a {@link #requestLayout()} on the next frame, after all detach/attach
 * calls are finished, causing layout to be run prior to redrawing the view hierarchy.
 * <p>
 * This method should be called only for views which were detached from their parent.
 *
 * @param child the child to attach
 * @param index the index at which the child should be attached
 * @param params the layout parameters of the child
 *
 * @see #removeDetachedView(View, boolean)
 * @see #detachAllViewsFromParent()
 * @see #detachViewFromParent(View)
 * @see #detachViewFromParent(int)
 * @apiSince 1
 */

protected void attachViewToParent(android.view.View child, int index, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * Detaches a view from its parent. Detaching a view should be followed
 * either by a call to
 * {@link #attachViewToParent(android.view.View,int,android.view.ViewGroup.LayoutParams)}
 * or a call to {@link #removeDetachedView(android.view.View,boolean)}. Detachment should only be
 * temporary; reattachment or removal should happen within the same drawing cycle as
 * detachment. When a view is detached, its parent is null and cannot be retrieved by a
 * call to {@link #getChildAt(int)}.
 *
 * @param child the child to detach
 *
 * @see #detachViewFromParent(int)
 * @see #detachViewsFromParent(int, int)
 * @see #detachAllViewsFromParent()
 * @see #attachViewToParent(View, int, android.view.ViewGroup.LayoutParams)
 * @see #removeDetachedView(View, boolean)
 * @apiSince 1
 */

protected void detachViewFromParent(android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * Detaches a view from its parent. Detaching a view should be followed
 * either by a call to
 * {@link #attachViewToParent(android.view.View,int,android.view.ViewGroup.LayoutParams)}
 * or a call to {@link #removeDetachedView(android.view.View,boolean)}. Detachment should only be
 * temporary; reattachment or removal should happen within the same drawing cycle as
 * detachment. When a view is detached, its parent is null and cannot be retrieved by a
 * call to {@link #getChildAt(int)}.
 *
 * @param index the index of the child to detach
 *
 * @see #detachViewFromParent(View)
 * @see #detachAllViewsFromParent()
 * @see #detachViewsFromParent(int, int)
 * @see #attachViewToParent(View, int, android.view.ViewGroup.LayoutParams)
 * @see #removeDetachedView(View, boolean)
 * @apiSince 1
 */

protected void detachViewFromParent(int index) { throw new RuntimeException("Stub!"); }

/**
 * Detaches a range of views from their parents. Detaching a view should be followed
 * either by a call to
 * {@link #attachViewToParent(android.view.View,int,android.view.ViewGroup.LayoutParams)}
 * or a call to {@link #removeDetachedView(android.view.View,boolean)}. Detachment should only be
 * temporary; reattachment or removal should happen within the same drawing cycle as
 * detachment. When a view is detached, its parent is null and cannot be retrieved by a
 * call to {@link #getChildAt(int)}.
 *
 * @param start the first index of the childrend range to detach
 * @param count the number of children to detach
 *
 * @see #detachViewFromParent(View)
 * @see #detachViewFromParent(int)
 * @see #detachAllViewsFromParent()
 * @see #attachViewToParent(View, int, android.view.ViewGroup.LayoutParams)
 * @see #removeDetachedView(View, boolean)
 * @apiSince 1
 */

protected void detachViewsFromParent(int start, int count) { throw new RuntimeException("Stub!"); }

/**
 * Detaches all views from the parent. Detaching a view should be followed
 * either by a call to
 * {@link #attachViewToParent(android.view.View,int,android.view.ViewGroup.LayoutParams)}
 * or a call to {@link #removeDetachedView(android.view.View,boolean)}. Detachment should only be
 * temporary; reattachment or removal should happen within the same drawing cycle as
 * detachment. When a view is detached, its parent is null and cannot be retrieved by a
 * call to {@link #getChildAt(int)}.
 *
 * @see #detachViewFromParent(View)
 * @see #detachViewFromParent(int)
 * @see #detachViewsFromParent(int, int)
 * @see #attachViewToParent(View, int, android.view.ViewGroup.LayoutParams)
 * @see #removeDetachedView(View, boolean)
 * @apiSince 1
 */

protected void detachAllViewsFromParent() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 
 * @param child This value must never be {@code null}.
 
 * @param target This value must never be {@code null}.
 * @apiSince 26
 */

public void onDescendantInvalidated(@androidx.annotation.NonNull android.view.View child, @androidx.annotation.NonNull android.view.View target) { throw new RuntimeException("Stub!"); }

/**
 * Don't call or override this method. It is used for the implementation of
 * the view hierarchy.
 *
 * @deprecated Use {@link #onDescendantInvalidated(android.view.View,android.view.View)} instead to observe updates to
 * draw state in descendants.
 * @apiSince 1
 */

@Deprecated
public final void invalidateChild(android.view.View child, android.graphics.Rect dirty) { throw new RuntimeException("Stub!"); }

/**
 * Don't call or override this method. It is used for the implementation of
 * the view hierarchy.
 *
 * This implementation returns null if this ViewGroup does not have a parent,
 * if this ViewGroup is already fully invalidated or if the dirty rectangle
 * does not intersect with this ViewGroup's bounds.
 *
 * @deprecated Use {@link #onDescendantInvalidated(android.view.View,android.view.View)} instead to observe updates to
 * draw state in descendants.
 * @apiSince 1
 */

@Deprecated
public android.view.ViewParent invalidateChildInParent(int[] location, android.graphics.Rect dirty) { throw new RuntimeException("Stub!"); }

/**
 * Offset a rectangle that is in a descendant's coordinate
 * space into our coordinate space.
 * @param descendant A descendant of this view
 * @param rect A rectangle defined in descendant's coordinate space.
 * @apiSince 1
 */

public final void offsetDescendantRectToMyCoords(android.view.View descendant, android.graphics.Rect rect) { throw new RuntimeException("Stub!"); }

/**
 * Offset a rectangle that is in our coordinate space into an ancestor's
 * coordinate space.
 * @param descendant A descendant of this view
 * @param rect A rectangle defined in descendant's coordinate space.
 * @apiSince 1
 */

public final void offsetRectIntoDescendantCoords(android.view.View descendant, android.graphics.Rect rect) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean getChildVisibleRect(android.view.View child, android.graphics.Rect r, android.graphics.Point offset) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final void layout(int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected abstract void onLayout(boolean changed, int l, int t, int r, int b);

/**
 * Indicates whether the view group has the ability to animate its children
 * after the first layout.
 *
 * @return true if the children can be animated, false otherwise
 * @apiSince 1
 */

protected boolean canAnimate() { throw new RuntimeException("Stub!"); }

/**
 * Runs the layout animation. Calling this method triggers a relayout of
 * this view group.
 * @apiSince 1
 */

public void startLayoutAnimation() { throw new RuntimeException("Stub!"); }

/**
 * Schedules the layout animation to be played after the next layout pass
 * of this view group. This can be used to restart the layout animation
 * when the content of the view group changes or when the activity is
 * paused and resumed.
 * @apiSince 1
 */

public void scheduleLayoutAnimation() { throw new RuntimeException("Stub!"); }

/**
 * Sets the layout animation controller used to animate the group's
 * children after the first layout.
 *
 * @param controller the animation controller
 * @apiSince 1
 */

public void setLayoutAnimation(android.view.animation.LayoutAnimationController controller) { throw new RuntimeException("Stub!"); }

/**
 * Returns the layout animation controller used to animate the group's
 * children.
 *
 * @return the current animation controller
 * @apiSince 1
 */

public android.view.animation.LayoutAnimationController getLayoutAnimation() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the children's drawing cache is used during a layout
 * animation. By default, the drawing cache is enabled but this will prevent
 * nested layout animations from working. To nest animations, you must disable
 * the cache.
 *
 * @return true if the animation cache is enabled, false otherwise
 *
 * @see #setAnimationCacheEnabled(boolean)
 * @see android.view.View#setDrawingCacheEnabled(boolean)
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#M}, this property is ignored.
 * Caching behavior of children may be controlled through {@link android.view.View#setLayerType(int,android.graphics.Paint) View#setLayerType(int, Paint)}.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public boolean isAnimationCacheEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables the children's drawing cache during a layout animation.
 * By default, the drawing cache is enabled but this will prevent nested
 * layout animations from working. To nest animations, you must disable the
 * cache.
 *
 * @param enabled true to enable the animation cache, false otherwise
 *
 * @see #isAnimationCacheEnabled()
 * @see android.view.View#setDrawingCacheEnabled(boolean)
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#M}, this property is ignored.
 * Caching behavior of children may be controlled through {@link android.view.View#setLayerType(int,android.graphics.Paint) View#setLayerType(int, Paint)}.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public void setAnimationCacheEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this ViewGroup will always try to draw its children using their
 * drawing cache. By default this property is enabled.
 *
 * @return true if the animation cache is enabled, false otherwise
 *
 * @see #setAlwaysDrawnWithCacheEnabled(boolean)
 * @see #setChildrenDrawnWithCacheEnabled(boolean)
 * @see android.view.View#setDrawingCacheEnabled(boolean)
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#M}, this property is ignored.
 * Child views may no longer have their caching behavior disabled by parents.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public boolean isAlwaysDrawnWithCacheEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this ViewGroup will always try to draw its children using their
 * drawing cache. This property can be set to true when the cache rendering is
 * slightly different from the children's normal rendering. Renderings can be different,
 * for instance, when the cache's quality is set to low.
 *
 * When this property is disabled, the ViewGroup will use the drawing cache of its
 * children only when asked to. It's usually the task of subclasses to tell ViewGroup
 * when to start using the drawing cache and when to stop using it.
 *
 * @param always true to always draw with the drawing cache, false otherwise
 *
 * @see #isAlwaysDrawnWithCacheEnabled()
 * @see #setChildrenDrawnWithCacheEnabled(boolean)
 * @see android.view.View#setDrawingCacheEnabled(boolean)
 * @see android.view.View#setDrawingCacheQuality(int)
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#M}, this property is ignored.
 * Child views may no longer have their caching behavior disabled by parents.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public void setAlwaysDrawnWithCacheEnabled(boolean always) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the ViewGroup is currently drawing its children using
 * their drawing cache.
 *
 * @return true if children should be drawn with their cache, false otherwise
 *
 * @see #setAlwaysDrawnWithCacheEnabled(boolean)
 * @see #setChildrenDrawnWithCacheEnabled(boolean)
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#M}, this property is ignored.
 * Child views may no longer be forced to cache their rendering state by their parents.
 * Use {@link android.view.View#setLayerType(int,android.graphics.Paint) View#setLayerType(int, Paint)} on individual Views instead.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
protected boolean isChildrenDrawnWithCacheEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Tells the ViewGroup to draw its children using their drawing cache. This property
 * is ignored when {@link #isAlwaysDrawnWithCacheEnabled()} is true. A child's drawing cache
 * will be used only if it has been enabled.
 *
 * Subclasses should call this method to start and stop using the drawing cache when
 * they perform performance sensitive operations, like scrolling or animating.
 *
 * @param enabled true if children should be drawn with their cache, false otherwise
 *
 * @see #setAlwaysDrawnWithCacheEnabled(boolean)
 * @see #isChildrenDrawnWithCacheEnabled()
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#M}, this property is ignored.
 * Child views may no longer be forced to cache their rendering state by their parents.
 * Use {@link android.view.View#setLayerType(int,android.graphics.Paint) View#setLayerType(int, Paint)} on individual Views instead.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
protected void setChildrenDrawnWithCacheEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the ViewGroup is drawing its children in the order defined by
 * {@link #getChildDrawingOrder(int,int)}.
 *
 * @return true if children drawing order is defined by {@link #getChildDrawingOrder(int,int)},
 *         false otherwise
 *
 * @see #setChildrenDrawingOrderEnabled(boolean)
 * @see #getChildDrawingOrder(int, int)
 * @apiSince 7
 */

@android.view.ViewDebug.ExportedProperty(category="drawing")
protected boolean isChildrenDrawingOrderEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Tells the ViewGroup whether to draw its children in the order defined by the method
 * {@link #getChildDrawingOrder(int,int)}.
 * <p>
 * Note that {@link android.view.View#getZ() View#getZ()} reordering, done by {@link #dispatchDraw(android.graphics.Canvas)},
 * will override custom child ordering done via this method.
 *
 * @param enabled true if the order of the children when drawing is determined by
 *        {@link #getChildDrawingOrder(int,int)}, false otherwise
 *
 * @see #isChildrenDrawingOrderEnabled()
 * @see #getChildDrawingOrder(int, int)
 * @apiSince 7
 */

protected void setChildrenDrawingOrderEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Returns an integer indicating what types of drawing caches are kept in memory.
 *
 * @see #setPersistentDrawingCache(int)
 * @see #setAnimationCacheEnabled(boolean)
 *
 * @return one or a combination of {@link #PERSISTENT_NO_CACHE},
 *         {@link #PERSISTENT_ANIMATION_CACHE}, {@link #PERSISTENT_SCROLLING_CACHE}
 *         and {@link #PERSISTENT_ALL_CACHES}
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int,android.graphics.Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link android.graphics.Canvas Canvas} from either a {@link android.graphics.Bitmap Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(android.graphics.Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link android.view.PixelCopy PixelCopy} API is recommended.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
@android.view.ViewDebug.ExportedProperty(category="drawing", mapping={@android.view.ViewDebug.IntToString(from=android.view.ViewGroup.PERSISTENT_NO_CACHE, to="NONE"), @android.view.ViewDebug.IntToString(from=android.view.ViewGroup.PERSISTENT_ANIMATION_CACHE, to="ANIMATION"), @android.view.ViewDebug.IntToString(from=android.view.ViewGroup.PERSISTENT_SCROLLING_CACHE, to="SCROLLING"), @android.view.ViewDebug.IntToString(from=android.view.ViewGroup.PERSISTENT_ALL_CACHES, to="ALL")})
public int getPersistentDrawingCache() { throw new RuntimeException("Stub!"); }

/**
 * Indicates what types of drawing caches should be kept in memory after
 * they have been created.
 *
 * @see #getPersistentDrawingCache()
 * @see #setAnimationCacheEnabled(boolean)
 *
 * @param drawingCacheToKeep one or a combination of {@link #PERSISTENT_NO_CACHE},
 *        {@link #PERSISTENT_ANIMATION_CACHE}, {@link #PERSISTENT_SCROLLING_CACHE}
 *        and {@link #PERSISTENT_ALL_CACHES}
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int,android.graphics.Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link android.graphics.Canvas Canvas} from either a {@link android.graphics.Bitmap Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(android.graphics.Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link android.view.PixelCopy PixelCopy} API is recommended.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
public void setPersistentDrawingCache(int drawingCacheToKeep) { throw new RuntimeException("Stub!"); }

/**
 * Returns the basis of alignment during layout operations on this ViewGroup:
 * either {@link #LAYOUT_MODE_CLIP_BOUNDS} or {@link #LAYOUT_MODE_OPTICAL_BOUNDS}.
 * <p>
 * If no layoutMode was explicitly set, either programmatically or in an XML resource,
 * the method returns the layoutMode of the view's parent ViewGroup if such a parent exists,
 * otherwise the method returns a default value of {@link #LAYOUT_MODE_CLIP_BOUNDS}.
 *
 * @return the layout mode to use during layout operations
 *
 * @see #setLayoutMode(int)
 * @apiSince 18
 */

public int getLayoutMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets the basis of alignment during the layout of this ViewGroup.
 * Valid values are either {@link #LAYOUT_MODE_CLIP_BOUNDS} or
 * {@link #LAYOUT_MODE_OPTICAL_BOUNDS}.
 *
 * @param layoutMode the layout mode to use during layout operations
 *
 * @see #getLayoutMode()
 * @attr ref android.R.styleable#ViewGroup_layoutMode
 * @apiSince 18
 */

public void setLayoutMode(int layoutMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new set of layout parameters based on the supplied attributes set.
 *
 * @param attrs the attributes to build the layout parameters from
 *
 * @return an instance of {@link android.view.ViewGroup.LayoutParams} or one
 *         of its descendants
 * @apiSince 1
 */

public android.view.ViewGroup.LayoutParams generateLayoutParams(android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Returns a safe set of layout parameters based on the supplied layout params.
 * When a ViewGroup is passed a View whose layout params do not pass the test of
 * {@link #checkLayoutParams(android.view.ViewGroup.LayoutParams)}, this method
 * is invoked. This method should return a new set of layout params suitable for
 * this ViewGroup, possibly by copying the appropriate attributes from the
 * specified set of layout params.
 *
 * @param p The layout parameters to convert into a suitable set of layout parameters
 *          for this ViewGroup.
 *
 * @return an instance of {@link android.view.ViewGroup.LayoutParams} or one
 *         of its descendants
 * @apiSince 1
 */

protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }

/**
 * Returns a set of default layout parameters. These parameters are requested
 * when the View passed to {@link #addView(android.view.View)} has no layout parameters
 * already set. If null is returned, an exception is thrown from addView.
 *
 * @return a set of default layout parameters or null
 * @apiSince 1
 */

protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void debug(int depth) { throw new RuntimeException("Stub!"); }

/**
 * Returns the position in the group of the specified child view.
 *
 * @param child the view for which to get the position
 * @return a positive integer representing the position of the view in the
 *         group, or -1 if the view does not exist in the group
 * @apiSince 1
 */

public int indexOfChild(android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of children in the group.
 *
 * @return a positive integer representing the number of children in
 *         the group
 * @apiSince 1
 */

public int getChildCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the view at the specified position in the group.
 *
 * @param index the position at which to get the view from
 * @return the view at the specified position or null if the position
 *         does not exist within the group
 * @apiSince 1
 */

public android.view.View getChildAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Ask all of the children of this view to measure themselves, taking into
 * account both the MeasureSpec requirements for this view and its padding.
 * We skip children that are in the GONE state The heavy lifting is done in
 * getChildMeasureSpec.
 *
 * @param widthMeasureSpec The width requirements for this view
 * @param heightMeasureSpec The height requirements for this view
 * @apiSince 1
 */

protected void measureChildren(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/**
 * Ask one of the children of this view to measure itself, taking into
 * account both the MeasureSpec requirements for this view and its padding.
 * The heavy lifting is done in getChildMeasureSpec.
 *
 * @param child The child to measure
 * @param parentWidthMeasureSpec The width requirements for this view
 * @param parentHeightMeasureSpec The height requirements for this view
 * @apiSince 1
 */

protected void measureChild(android.view.View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) { throw new RuntimeException("Stub!"); }

/**
 * Ask one of the children of this view to measure itself, taking into
 * account both the MeasureSpec requirements for this view and its padding
 * and margins. The child must have MarginLayoutParams The heavy lifting is
 * done in getChildMeasureSpec.
 *
 * @param child The child to measure
 * @param parentWidthMeasureSpec The width requirements for this view
 * @param widthUsed Extra space that has been used up by the parent
 *        horizontally (possibly by other children of the parent)
 * @param parentHeightMeasureSpec The height requirements for this view
 * @param heightUsed Extra space that has been used up by the parent
 *        vertically (possibly by other children of the parent)
 * @apiSince 1
 */

protected void measureChildWithMargins(android.view.View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) { throw new RuntimeException("Stub!"); }

/**
 * Does the hard part of measureChildren: figuring out the MeasureSpec to
 * pass to a particular child. This method figures out the right MeasureSpec
 * for one dimension (height or width) of one child view.
 *
 * The goal is to combine information from our MeasureSpec with the
 * LayoutParams of the child to get the best possible results. For example,
 * if the this view knows its size (because its MeasureSpec has a mode of
 * EXACTLY), and the child has indicated in its LayoutParams that it wants
 * to be the same size as the parent, the parent should ask the child to
 * layout given an exact size.
 *
 * @param spec The requirements for this view
 * @param padding The padding of this view for the current dimension and
 *        margins, if applicable
 * @param childDimension How big the child wants to be in the current
 *        dimension
 * @return a MeasureSpec integer for the child
 * @apiSince 1
 */

public static int getChildMeasureSpec(int spec, int padding, int childDimension) { throw new RuntimeException("Stub!"); }

/**
 * Removes any pending animations for views that have been removed. Call
 * this if you don't want animations for exiting views to stack up.
 * @apiSince 1
 */

public void clearDisappearingChildren() { throw new RuntimeException("Stub!"); }

/**
 * This method tells the ViewGroup that the given View object, which should have this
 * ViewGroup as its parent,
 * should be kept around  (re-displayed when the ViewGroup draws its children) even if it
 * is removed from its parent. This allows animations, such as those used by
 * {@link android.app.Fragment} and {@link android.animation.LayoutTransition} to animate
 * the removal of views. A call to this method should always be accompanied by a later call
 * to {@link #endViewTransition(android.view.View)}, such as after an animation on the View has finished,
 * so that the View finally gets removed.
 *
 * @param view The View object to be kept visible even if it gets removed from its parent.
 * @apiSince 11
 */

public void startViewTransition(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * This method should always be called following an earlier call to
 * {@link #startViewTransition(android.view.View)}. The given View is finally removed from its parent
 * and will no longer be displayed. Note that this method does not perform the functionality
 * of removing a view from its parent; it just discontinues the display of a View that
 * has previously been removed.
 *
 * @return view The View object that has been removed but is being kept around in the visible
 * hierarchy by an earlier call to {@link #startViewTransition(android.view.View)}.
 * @apiSince 11
 */

public void endViewTransition(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Tells this ViewGroup to suppress all layout() calls until layout
 * suppression is disabled with a later call to suppressLayout(false).
 * When layout suppression is disabled, a requestLayout() call is sent
 * if layout() was attempted while layout was being suppressed.
 * @apiSince 29
 */

public void suppressLayout(boolean suppress) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether layout calls on this container are currently being
 * suppressed, due to an earlier call to {@link #suppressLayout(boolean)}.
 *
 * @return true if layout calls are currently suppressed, false otherwise.
 * @apiSince 29
 */

public boolean isLayoutSuppressed() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean gatherTransparentRegion(android.graphics.Region region) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void requestTransparentRegion(android.view.View child) { throw new RuntimeException("Stub!"); }

/** @apiSince 20 */

public android.view.WindowInsets dispatchApplyWindowInsets(android.view.WindowInsets insets) { throw new RuntimeException("Stub!"); }

/**
 * Returns the animation listener to which layout animation events are
 * sent.
 *
 * @return an {@link android.view.animation.Animation.AnimationListener}
 * @apiSince 1
 */

public android.view.animation.Animation.AnimationListener getLayoutAnimationListener() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void drawableStateChanged() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void jumpDrawablesToCurrentState() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected int[] onCreateDrawableState(int extraSpace) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this ViewGroup's drawable states also include
 * its children's drawable states.  This is used, for example, to
 * make a group appear to be focused when its child EditText or button
 * is focused.
 * @apiSince 1
 */

public void setAddStatesFromChildren(boolean addsStates) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this ViewGroup's drawable states also include
 * its children's drawable states.  This is used, for example, to
 * make a group appear to be focused when its child EditText or button
 * is focused.
 * @apiSince 1
 */

public boolean addStatesFromChildren() { throw new RuntimeException("Stub!"); }

/**
 * If {@link #addStatesFromChildren} is true, refreshes this group's
 * drawable state (to include the states from its children).
 * @apiSince 1
 */

public void childDrawableStateChanged(android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the animation listener to which layout animation events must
 * be sent. Only
 * {@link android.view.animation.Animation.AnimationListener#onAnimationStart(Animation)}
 * and
 * {@link android.view.animation.Animation.AnimationListener#onAnimationEnd(Animation)}
 * are invoked.
 *
 * @param animationListener the layout animation listener
 * @apiSince 1
 */

public void setLayoutAnimationListener(android.view.animation.Animation.AnimationListener animationListener) { throw new RuntimeException("Stub!"); }

/**
 * Return true if the pressed state should be delayed for children or descendants of this
 * ViewGroup. Generally, this should be done for containers that can scroll, such as a List.
 * This prevents the pressed state from appearing when the user is actually trying to scroll
 * the content.
 *
 * The default implementation returns true for compatibility reasons. Subclasses that do
 * not scroll should generally override this method and return false.
 * @apiSince 14
 */

public boolean shouldDelayChildPressedState() { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 * @apiSince 21
 */

public boolean onStartNestedScroll(android.view.View child, android.view.View target, int nestedScrollAxes) { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 * @apiSince 21
 */

public void onNestedScrollAccepted(android.view.View child, android.view.View target, int axes) { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 *
 * <p>The default implementation of onStopNestedScroll calls
 * {@link #stopNestedScroll()} to halt any recursive nested scrolling in progress.</p>
 * @apiSince 21
 */

public void onStopNestedScroll(android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 * @apiSince 21
 */

public void onNestedScroll(android.view.View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 * @apiSince 21
 */

public void onNestedPreScroll(android.view.View target, int dx, int dy, int[] consumed) { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 * @apiSince 21
 */

public boolean onNestedFling(android.view.View target, float velocityX, float velocityY, boolean consumed) { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 * @apiSince 21
 */

public boolean onNestedPreFling(android.view.View target, float velocityX, float velocityY) { throw new RuntimeException("Stub!"); }

/**
 * Return the current axes of nested scrolling for this ViewGroup.
 *
 * <p>A ViewGroup returning something other than {@link #SCROLL_AXIS_NONE} is currently
 * acting as a nested scrolling parent for one or more descendant views in the hierarchy.</p>
 *
 * @return Flags indicating the current axes of nested scrolling
 * @see #SCROLL_AXIS_HORIZONTAL
 * @see #SCROLL_AXIS_VERTICAL
 * @see #SCROLL_AXIS_NONE
 * @apiSince 21
 */

public int getNestedScrollAxes() { throw new RuntimeException("Stub!"); }

/**
 * We clip to padding when FLAG_CLIP_TO_PADDING and FLAG_PADDING_NOT_NULL
 * are set at the same time.
 * @apiSince 1
 */

protected static final int CLIP_TO_PADDING_MASK = 34; // 0x22

/**
 * This view will get focus only if none of its descendants want it.
 * @apiSince 1
 */

public static final int FOCUS_AFTER_DESCENDANTS = 262144; // 0x40000

/**
 * This view will get focus before any of its descendants.
 * @apiSince 1
 */

public static final int FOCUS_BEFORE_DESCENDANTS = 131072; // 0x20000

/**
 * This view will block any of its descendants from getting focus, even
 * if they are focusable.
 * @apiSince 1
 */

public static final int FOCUS_BLOCK_DESCENDANTS = 393216; // 0x60000

/**
 * This constant is a {@link #setLayoutMode(int) layoutMode}.
 * Clip bounds are the raw values of {@link #getLeft() left}, {@link #getTop() top},
 * {@link #getRight() right} and {@link #getBottom() bottom}.
 * @apiSince 18
 */

public static final int LAYOUT_MODE_CLIP_BOUNDS = 0; // 0x0

/**
 * This constant is a {@link #setLayoutMode(int) layoutMode}.
 * Optical bounds describe where a widget appears to be. They sit inside the clip
 * bounds which need to cover a larger area to allow other effects,
 * such as shadows and glows, to be drawn.
 * @apiSince 18
 */

public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1; // 0x1

/**
 * Used to indicate that all drawing caches should be kept in memory.
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int,android.graphics.Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link android.graphics.Canvas Canvas} from either a {@link android.graphics.Bitmap Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(android.graphics.Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link android.view.PixelCopy PixelCopy} API is recommended.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final int PERSISTENT_ALL_CACHES = 3; // 0x3

/**
 * Used to indicate that the animation drawing cache should be kept in memory.
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int,android.graphics.Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link android.graphics.Canvas Canvas} from either a {@link android.graphics.Bitmap Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(android.graphics.Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link android.view.PixelCopy PixelCopy} API is recommended.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final int PERSISTENT_ANIMATION_CACHE = 1; // 0x1

/**
 * Used to indicate that no drawing cache should be kept in memory.
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int,android.graphics.Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link android.graphics.Canvas Canvas} from either a {@link android.graphics.Bitmap Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(android.graphics.Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link android.view.PixelCopy PixelCopy} API is recommended.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final int PERSISTENT_NO_CACHE = 0; // 0x0

/**
 * Used to indicate that the scrolling drawing cache should be kept in memory.
 *
 * @deprecated The view drawing cache was largely made obsolete with the introduction of
 * hardware-accelerated rendering in API 11. With hardware-acceleration, intermediate cache
 * layers are largely unnecessary and can easily result in a net loss in performance due to the
 * cost of creating and updating the layer. In the rare cases where caching layers are useful,
 * such as for alpha animations, {@link #setLayerType(int,android.graphics.Paint)} handles this with hardware
 * rendering. For software-rendered snapshots of a small part of the View hierarchy or
 * individual Views it is recommended to create a {@link android.graphics.Canvas Canvas} from either a {@link android.graphics.Bitmap Bitmap} or
 * {@link android.graphics.Picture} and call {@link #draw(android.graphics.Canvas)} on the View. However these
 * software-rendered usages are discouraged and have compatibility issues with hardware-only
 * rendering features such as {@link android.graphics.Bitmap.Config#HARDWARE Config.HARDWARE}
 * bitmaps, real-time shadows, and outline clipping. For screenshots of the UI for feedback
 * reports or unit testing the {@link android.view.PixelCopy PixelCopy} API is recommended.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final int PERSISTENT_SCROLLING_CACHE = 2; // 0x2
/**
 * LayoutParams are used by views to tell their parents how they want to be
 * laid out. See
 * {@link android.R.styleable#ViewGroup_Layout ViewGroup Layout Attributes}
 * for a list of all child view attributes that this class supports.
 *
 * <p>
 * The base LayoutParams class just describes how big the view wants to be
 * for both width and height. For each dimension, it can specify one of:
 * <ul>
 * <li>FILL_PARENT (renamed MATCH_PARENT in API Level 8 and higher), which
 * means that the view wants to be as big as its parent (minus padding)
 * <li> WRAP_CONTENT, which means that the view wants to be just big enough
 * to enclose its content (plus padding)
 * <li> an exact number
 * </ul>
 * There are subclasses of LayoutParams for different subclasses of
 * ViewGroup. For example, AbsoluteLayout has its own subclass of
 * LayoutParams which adds an X and Y value.</p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about creating user interface layouts, read the
 * <a href="{@docRoot}guide/topics/ui/declaring-layout.html">XML Layouts</a> developer
 * guide.</p></div>
 *
 * @attr ref android.R.styleable#ViewGroup_Layout_layout_height
 * @attr ref android.R.styleable#ViewGroup_Layout_layout_width
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class LayoutParams {

/**
 * Creates a new set of layout parameters. The values are extracted from
 * the supplied attributes set and context. The XML attributes mapped
 * to this set of layout parameters are:
 *
 * <ul>
 *   <li><code>layout_width</code>: the width, either an exact value,
 *   {@link #WRAP_CONTENT}, or {@link #FILL_PARENT} (replaced by
 *   {@link #MATCH_PARENT} in API Level 8)</li>
 *   <li><code>layout_height</code>: the height, either an exact value,
 *   {@link #WRAP_CONTENT}, or {@link #FILL_PARENT} (replaced by
 *   {@link #MATCH_PARENT} in API Level 8)</li>
 * </ul>
 *
 * @param c the application environment
 * @param attrs the set of attributes from which to extract the layout
 *              parameters' values
 * @apiSince 1
 */

public LayoutParams(android.content.Context c, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new set of layout parameters with the specified width
 * and height.
 *
 * @param width the width, either {@link #WRAP_CONTENT},
 *        {@link #FILL_PARENT} (replaced by {@link #MATCH_PARENT} in
 *        API Level 8), or a fixed size in pixels
 * @param height the height, either {@link #WRAP_CONTENT},
 *        {@link #FILL_PARENT} (replaced by {@link #MATCH_PARENT} in
 *        API Level 8), or a fixed size in pixels
 * @apiSince 1
 */

public LayoutParams(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Copy constructor. Clones the width and height values of the source.
 *
 * @param source The layout params to copy from.
 * @apiSince 1
 */

public LayoutParams(android.view.ViewGroup.LayoutParams source) { throw new RuntimeException("Stub!"); }

/**
 * Extracts the layout parameters from the supplied attributes.
 *
 * @param a the style attributes to extract the parameters from
 * @param widthAttr the identifier of the width attribute
 * @param heightAttr the identifier of the height attribute
 * @apiSince 1
 */

protected void setBaseAttributes(android.content.res.TypedArray a, int widthAttr, int heightAttr) { throw new RuntimeException("Stub!"); }

/**
 * Resolve layout parameters depending on the layout direction. Subclasses that care about
 * layoutDirection changes should override this method. The default implementation does
 * nothing.
 *
 * @param layoutDirection the direction of the layout
 *
 * {@link android.view.View#LAYOUT_DIRECTION_LTR View#LAYOUT_DIRECTION_LTR}
 * {@link android.view.View#LAYOUT_DIRECTION_RTL View#LAYOUT_DIRECTION_RTL}
 * @apiSince 17
 */

public void resolveLayoutDirection(int layoutDirection) { throw new RuntimeException("Stub!"); }

/**
 * Special value for the height or width requested by a View.
 * FILL_PARENT means that the view wants to be as big as its parent,
 * minus the parent's padding, if any. This value is deprecated
 * starting in API Level 8 and replaced by {@link #MATCH_PARENT}.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int FILL_PARENT = -1; // 0xffffffff

/**
 * Special value for the height or width requested by a View.
 * MATCH_PARENT means that the view wants to be as big as its parent,
 * minus the parent's padding, if any. Introduced in API Level 8.
 * @apiSince 8
 */

public static final int MATCH_PARENT = -1; // 0xffffffff

/**
 * Special value for the height or width requested by a View.
 * WRAP_CONTENT means that the view wants to be just large enough to fit
 * its own internal content, taking its own padding into account.
 * @apiSince 1
 */

public static final int WRAP_CONTENT = -2; // 0xfffffffe

/**
 * Information about how tall the view wants to be. Can be one of the
 * constants FILL_PARENT (replaced by MATCH_PARENT
 * in API Level 8) or WRAP_CONTENT, or an exact size.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="layout", mapping={@android.view.ViewDebug.IntToString(from=android.view.ViewGroup.LayoutParams.MATCH_PARENT, to="MATCH_PARENT"), @android.view.ViewDebug.IntToString(from=android.view.ViewGroup.LayoutParams.WRAP_CONTENT, to="WRAP_CONTENT")}) public int height;

/**
 * Used to animate layouts.
 * @apiSince 1
 */

public android.view.animation.LayoutAnimationController.AnimationParameters layoutAnimationParameters;

/**
 * Information about how wide the view wants to be. Can be one of the
 * constants FILL_PARENT (replaced by MATCH_PARENT
 * in API Level 8) or WRAP_CONTENT, or an exact size.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="layout", mapping={@android.view.ViewDebug.IntToString(from=android.view.ViewGroup.LayoutParams.MATCH_PARENT, to="MATCH_PARENT"), @android.view.ViewDebug.IntToString(from=android.view.ViewGroup.LayoutParams.WRAP_CONTENT, to="WRAP_CONTENT")}) public int width;
}

/**
 * Per-child layout information for layouts that support margins.
 * See
 * {@link android.R.styleable#ViewGroup_MarginLayout ViewGroup Margin Layout Attributes}
 * for a list of all child view attributes that this class supports.
 *
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_margin
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginHorizontal
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginVertical
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginLeft
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginTop
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginRight
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginBottom
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginStart
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginEnd
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class MarginLayoutParams extends android.view.ViewGroup.LayoutParams {

/**
 * Creates a new set of layout parameters. The values are extracted from
 * the supplied attributes set and context.
 *
 * @param c the application environment
 * @param attrs the set of attributes from which to extract the layout
 *              parameters' values
 * @apiSince 1
 */

public MarginLayoutParams(android.content.Context c, android.util.AttributeSet attrs) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public MarginLayoutParams(int width, int height) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * Copy constructor. Clones the width, height and margin values of the source.
 *
 * @param source The layout params to copy from.
 * @apiSince 1
 */

public MarginLayoutParams(android.view.ViewGroup.MarginLayoutParams source) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public MarginLayoutParams(android.view.ViewGroup.LayoutParams source) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * Sets the margins, in pixels. A call to {@link android.view.View#requestLayout()} needs
 * to be done so that the new margins are taken into account. Left and right margins may be
 * overridden by {@link android.view.View#requestLayout()} depending on layout direction.
 * Margin values should be positive.
 *
 * @param left the left margin size
 * @param top the top margin size
 * @param right the right margin size
 * @param bottom the bottom margin size
 *
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginLeft
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginTop
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginRight
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginBottom
 * @apiSince 1
 */

public void setMargins(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Sets the relative start margin. Margin values should be positive.
 *
 * @param start the start margin size
 *
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginStart
 * @apiSince 17
 */

public void setMarginStart(int start) { throw new RuntimeException("Stub!"); }

/**
 * Returns the start margin in pixels.
 *
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginStart
 *
 * @return the start margin in pixels.
 * @apiSince 17
 */

public int getMarginStart() { throw new RuntimeException("Stub!"); }

/**
 * Sets the relative end margin. Margin values should be positive.
 *
 * @param end the end margin size
 *
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginEnd
 * @apiSince 17
 */

public void setMarginEnd(int end) { throw new RuntimeException("Stub!"); }

/**
 * Returns the end margin in pixels.
 *
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginEnd
 *
 * @return the end margin in pixels.
 * @apiSince 17
 */

public int getMarginEnd() { throw new RuntimeException("Stub!"); }

/**
 * Check if margins are relative.
 *
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginStart
 * @attr ref android.R.styleable#ViewGroup_MarginLayout_layout_marginEnd
 *
 * @return true if either marginStart or marginEnd has been set.
 * @apiSince 17
 */

public boolean isMarginRelative() { throw new RuntimeException("Stub!"); }

/**
 * Set the layout direction
 * @param layoutDirection the layout direction.
 *        Should be either {@link android.view.View#LAYOUT_DIRECTION_LTR View#LAYOUT_DIRECTION_LTR}
 *                     or {@link android.view.View#LAYOUT_DIRECTION_RTL View#LAYOUT_DIRECTION_RTL}.
 * @apiSince 17
 */

public void setLayoutDirection(int layoutDirection) { throw new RuntimeException("Stub!"); }

/**
 * Retuns the layout direction. Can be either {@link android.view.View#LAYOUT_DIRECTION_LTR View#LAYOUT_DIRECTION_LTR} or
 * {@link android.view.View#LAYOUT_DIRECTION_RTL View#LAYOUT_DIRECTION_RTL}.
 *
 * @return the layout direction.
 * @apiSince 17
 */

public int getLayoutDirection() { throw new RuntimeException("Stub!"); }

/**
 * This will be called by {@link android.view.View#requestLayout()}. Left and Right margins
 * may be overridden depending on layout direction.
 * @apiSince 17
 */

public void resolveLayoutDirection(int layoutDirection) { throw new RuntimeException("Stub!"); }

/**
 * The bottom margin in pixels of the child. Margin values should be positive.
 * Call {@link android.view.ViewGroup#setLayoutParams(android.view.ViewGroup.LayoutParams) ViewGroup#setLayoutParams(LayoutParams)} after reassigning a new value
 * to this field.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="layout") public int bottomMargin;

/**
 * The left margin in pixels of the child. Margin values should be positive.
 * Call {@link android.view.ViewGroup#setLayoutParams(android.view.ViewGroup.LayoutParams) ViewGroup#setLayoutParams(LayoutParams)} after reassigning a new value
 * to this field.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="layout") public int leftMargin;

/**
 * The right margin in pixels of the child. Margin values should be positive.
 * Call {@link android.view.ViewGroup#setLayoutParams(android.view.ViewGroup.LayoutParams) ViewGroup#setLayoutParams(LayoutParams)} after reassigning a new value
 * to this field.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="layout") public int rightMargin;

/**
 * The top margin in pixels of the child. Margin values should be positive.
 * Call {@link android.view.ViewGroup#setLayoutParams(android.view.ViewGroup.LayoutParams) ViewGroup#setLayoutParams(LayoutParams)} after reassigning a new value
 * to this field.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="layout") public int topMargin;
}

/**
 * Interface definition for a callback to be invoked when the hierarchy
 * within this view changed. The hierarchy changes whenever a child is added
 * to or removed from this view.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnHierarchyChangeListener {

/**
 * Called when a new child is added to a parent view.
 *
 * @param parent the view in which a child was added
 * @param child the new child view added in the hierarchy
 * @apiSince 1
 */

public void onChildViewAdded(android.view.View parent, android.view.View child);

/**
 * Called when a child is removed from a parent view.
 *
 * @param parent the view from which the child was removed
 * @param child the child removed from the hierarchy
 * @apiSince 1
 */

public void onChildViewRemoved(android.view.View parent, android.view.View child);
}

}

