/*
 * Copyright (C) 2008 The Android Open Source Project
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

import java.util.List;
import java.util.function.Consumer;

/**
 * A view tree observer is used to register listeners that can be notified of global
 * changes in the view tree. Such global events include, but are not limited to,
 * layout of the whole tree, beginning of the drawing pass, touch mode change....
 *
 * A ViewTreeObserver should never be instantiated by applications as it is provided
 * by the views hierarchy. Refer to {@link android.view.View#getViewTreeObserver()}
 * for more information.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ViewTreeObserver {

ViewTreeObserver() { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the view hierarchy is attached to a window.
 *
 * @param listener The callback to add
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 * @apiSince 18
 */

public void addOnWindowAttachListener(android.view.ViewTreeObserver.OnWindowAttachListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Remove a previously installed window attach callback.
 *
 * @param victim The callback to remove
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 *
 * @see #addOnWindowAttachListener(android.view.ViewTreeObserver.OnWindowAttachListener)
 * @apiSince 18
 */

public void removeOnWindowAttachListener(android.view.ViewTreeObserver.OnWindowAttachListener victim) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the window focus state within the view tree changes.
 *
 * @param listener The callback to add
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 * @apiSince 18
 */

public void addOnWindowFocusChangeListener(android.view.ViewTreeObserver.OnWindowFocusChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Remove a previously installed window focus change callback.
 *
 * @param victim The callback to remove
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 *
 * @see #addOnWindowFocusChangeListener(android.view.ViewTreeObserver.OnWindowFocusChangeListener)
 * @apiSince 18
 */

public void removeOnWindowFocusChangeListener(android.view.ViewTreeObserver.OnWindowFocusChangeListener victim) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the focus state within the view tree changes.
 *
 * @param listener The callback to add
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 * @apiSince 1
 */

public void addOnGlobalFocusChangeListener(android.view.ViewTreeObserver.OnGlobalFocusChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Remove a previously installed focus change callback.
 *
 * @param victim The callback to remove
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 *
 * @see #addOnGlobalFocusChangeListener(OnGlobalFocusChangeListener)
 * @apiSince 1
 */

public void removeOnGlobalFocusChangeListener(android.view.ViewTreeObserver.OnGlobalFocusChangeListener victim) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the global layout state or the visibility of views
 * within the view tree changes
 *
 * @param listener The callback to add
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 * @apiSince 1
 */

public void addOnGlobalLayoutListener(android.view.ViewTreeObserver.OnGlobalLayoutListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Remove a previously installed global layout callback
 *
 * @param victim The callback to remove
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 *
 * @deprecated Use #removeOnGlobalLayoutListener instead
 *
 * @see #addOnGlobalLayoutListener(OnGlobalLayoutListener)
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
public void removeGlobalOnLayoutListener(android.view.ViewTreeObserver.OnGlobalLayoutListener victim) { throw new RuntimeException("Stub!"); }

/**
 * Remove a previously installed global layout callback
 *
 * @param victim The callback to remove
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 *
 * @see #addOnGlobalLayoutListener(OnGlobalLayoutListener)
 * @apiSince 16
 */

public void removeOnGlobalLayoutListener(android.view.ViewTreeObserver.OnGlobalLayoutListener victim) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the view tree is about to be drawn
 *
 * @param listener The callback to add
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 * @apiSince 1
 */

public void addOnPreDrawListener(android.view.ViewTreeObserver.OnPreDrawListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Remove a previously installed pre-draw callback
 *
 * @param victim The callback to remove
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 *
 * @see #addOnPreDrawListener(OnPreDrawListener)
 * @apiSince 1
 */

public void removeOnPreDrawListener(android.view.ViewTreeObserver.OnPreDrawListener victim) { throw new RuntimeException("Stub!"); }

/**
 * <p>Register a callback to be invoked when the view tree is about to be drawn.</p>
 * <p><strong>Note:</strong> this method <strong>cannot</strong> be invoked from
 * {@link android.view.ViewTreeObserver.OnDrawListener#onDraw()}.</p>
 *
 * @param listener The callback to add
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 * @apiSince 16
 */

public void addOnDrawListener(android.view.ViewTreeObserver.OnDrawListener listener) { throw new RuntimeException("Stub!"); }

/**
 * <p>Remove a previously installed pre-draw callback.</p>
 * <p><strong>Note:</strong> this method <strong>cannot</strong> be invoked from
 * {@link android.view.ViewTreeObserver.OnDrawListener#onDraw()}.</p>
 *
 * @param victim The callback to remove
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 *
 * @see #addOnDrawListener(OnDrawListener)
 * @apiSince 16
 */

public void removeOnDrawListener(android.view.ViewTreeObserver.OnDrawListener victim) { throw new RuntimeException("Stub!"); }

/**
 * Adds a frame commit callback. This callback will be invoked when the current rendering
 * content has been rendered into a frame and submitted to the swap chain. The frame may
 * not currently be visible on the display when this is invoked, but it has been submitted.
 * This callback is useful in combination with {@link android.view.PixelCopy PixelCopy} to capture the current
 * rendered content of the UI reliably.
 *
 * Note: Only works with hardware rendering. Does nothing otherwise.
 *
 * @param callback The callback to invoke when the frame is committed.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void registerFrameCommitCallback(@androidx.annotation.NonNull java.lang.Runnable callback) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to remove the given callback from the list of pending frame complete callbacks.
 *
 * @param callback The callback to remove
 * This value must never be {@code null}.
 * @return Whether or not the callback was removed. If this returns true the callback will
 *         not be invoked. If false is returned then the callback was either never added
 *         or may already be pending execution and was unable to be removed
 * @apiSince 29
 */

public boolean unregisterFrameCommitCallback(@androidx.annotation.NonNull java.lang.Runnable callback) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when a view has been scrolled.
 *
 * @param listener The callback to add
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 * @apiSince 3
 */

public void addOnScrollChangedListener(android.view.ViewTreeObserver.OnScrollChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Remove a previously installed scroll-changed callback
 *
 * @param victim The callback to remove
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 *
 * @see #addOnScrollChangedListener(OnScrollChangedListener)
 * @apiSince 3
 */

public void removeOnScrollChangedListener(android.view.ViewTreeObserver.OnScrollChangedListener victim) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the invoked when the touch mode changes.
 *
 * @param listener The callback to add
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 * @apiSince 1
 */

public void addOnTouchModeChangeListener(android.view.ViewTreeObserver.OnTouchModeChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Remove a previously installed touch mode change callback
 *
 * @param victim The callback to remove
 *
 * @throws java.lang.IllegalStateException If {@link #isAlive()} returns false
 *
 * @see #addOnTouchModeChangeListener(OnTouchModeChangeListener)
 * @apiSince 1
 */

public void removeOnTouchModeChangeListener(android.view.ViewTreeObserver.OnTouchModeChangeListener victim) { throw new RuntimeException("Stub!"); }

/**
 * Add a listener to be notified when the tree's <em>transformed</em> gesture exclusion rects
 * change. This could be the result of an animation or other layout change, or a view calling
 * {@link android.view.View#setSystemGestureExclusionRects(java.util.List) View#setSystemGestureExclusionRects(List)}.
 *
 * @param listener listener to add
 * This value must never be {@code null}.
 * @see android.view.View#setSystemGestureExclusionRects(List)
 * @apiSince 29
 */

public void addOnSystemGestureExclusionRectsChangedListener(@androidx.annotation.NonNull java.util.function.Consumer<java.util.List<android.graphics.Rect>> listener) { throw new RuntimeException("Stub!"); }

/**
 * Unsubscribe the given listener from gesture exclusion rect changes.
 * @see #addOnSystemGestureExclusionRectsChangedListener(Consumer)
 * @see android.view.View#setSystemGestureExclusionRects(List)
 
 * @param listener This value must never be {@code null}.
 * @apiSince 29
 */

public void removeOnSystemGestureExclusionRectsChangedListener(@androidx.annotation.NonNull java.util.function.Consumer<java.util.List<android.graphics.Rect>> listener) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this ViewTreeObserver is alive. When an observer is not alive,
 * any call to a method (except this one) will throw an exception.
 *
 * If an application keeps a long-lived reference to this ViewTreeObserver, it should
 * always check for the result of this method before calling any other method.
 *
 * @return True if this object is alive and be used, false otherwise.
 * @apiSince 1
 */

public boolean isAlive() { throw new RuntimeException("Stub!"); }

/**
 * Notifies registered listeners that a global layout happened. This can be called
 * manually if you are forcing a layout on a View or a hierarchy of Views that are
 * not attached to a Window or in the GONE state.
 * @apiSince 1
 */

public void dispatchOnGlobalLayout() { throw new RuntimeException("Stub!"); }

/**
 * Notifies registered listeners that the drawing pass is about to start. If a
 * listener returns true, then the drawing pass is canceled and rescheduled. This can
 * be called manually if you are forcing the drawing on a View or a hierarchy of Views
 * that are not attached to a Window or in the GONE state.
 *
 * @return True if the current draw should be canceled and rescheduled, false otherwise.
 * @apiSince 1
 */

public boolean dispatchOnPreDraw() { throw new RuntimeException("Stub!"); }

/**
 * Notifies registered listeners that the drawing pass is about to start.
 * @apiSince 16
 */

public void dispatchOnDraw() { throw new RuntimeException("Stub!"); }
/**
 * Interface definition for a callback to be invoked when the view tree is about to be drawn.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDrawListener {

/**
 * <p>Callback method to be invoked when the view tree is about to be drawn. At this point,
 * views cannot be modified in any way.</p>
 *
 * <p>Unlike with {@link android.view.ViewTreeObserver.OnPreDrawListener OnPreDrawListener}, this method cannot be used to cancel the
 * current drawing pass.</p>
 *
 * <p>An {@link android.view.ViewTreeObserver.OnDrawListener OnDrawListener} listener <strong>cannot be added or removed</strong>
 * from this method.</p>
 *
 * @see android.view.View#onMeasure
 * @see android.view.View#onLayout
 * @see android.view.View#onDraw
 * @apiSince 16
 */

public void onDraw();
}

/**
 * Interface definition for a callback to be invoked when the focus state within
 * the view tree changes.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnGlobalFocusChangeListener {

/**
 * Callback method to be invoked when the focus changes in the view tree. When
 * the view tree transitions from touch mode to non-touch mode, oldFocus is null.
 * When the view tree transitions from non-touch mode to touch mode, newFocus is
 * null. When focus changes in non-touch mode (without transition from or to
 * touch mode) either oldFocus or newFocus can be null.
 *
 * @param oldFocus The previously focused view, if any.
 * @param newFocus The newly focused View, if any.
 * @apiSince 1
 */

public void onGlobalFocusChanged(android.view.View oldFocus, android.view.View newFocus);
}

/**
 * Interface definition for a callback to be invoked when the global layout state
 * or the visibility of views within the view tree changes.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnGlobalLayoutListener {

/**
 * Callback method to be invoked when the global layout state or the visibility of views
 * within the view tree changes
 * @apiSince 1
 */

public void onGlobalLayout();
}

/**
 * Interface definition for a callback to be invoked when the view tree is about to be drawn.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnPreDrawListener {

/**
 * Callback method to be invoked when the view tree is about to be drawn. At this point, all
 * views in the tree have been measured and given a frame. Clients can use this to adjust
 * their scroll bounds or even to request a new layout before drawing occurs.
 *
 * @return Return true to proceed with the current drawing pass, or false to cancel.
 *
 * @see android.view.View#onMeasure
 * @see android.view.View#onLayout
 * @see android.view.View#onDraw
 * @apiSince 1
 */

public boolean onPreDraw();
}

/**
 * Interface definition for a callback to be invoked when
 * something in the view tree has been scrolled.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnScrollChangedListener {

/**
 * Callback method to be invoked when something in the view tree
 * has been scrolled.
 * @apiSince 3
 */

public void onScrollChanged();
}

/**
 * Interface definition for a callback to be invoked when the touch mode changes.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnTouchModeChangeListener {

/**
 * Callback method to be invoked when the touch mode changes.
 *
 * @param isInTouchMode True if the view hierarchy is now in touch mode, false  otherwise.
 * @apiSince 1
 */

public void onTouchModeChanged(boolean isInTouchMode);
}

/**
 * Interface definition for a callback to be invoked when the view hierarchy is
 * attached to and detached from its window.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnWindowAttachListener {

/**
 * Callback method to be invoked when the view hierarchy is attached to a window
 * @apiSince 18
 */

public void onWindowAttached();

/**
 * Callback method to be invoked when the view hierarchy is detached from a window
 * @apiSince 18
 */

public void onWindowDetached();
}

/**
 * Interface definition for a callback to be invoked when the view hierarchy's window
 * focus state changes.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnWindowFocusChangeListener {

/**
 * Callback method to be invoked when the window focus changes in the view tree.
 *
 * @param hasFocus Set to true if the window is gaining focus, false if it is
 * losing focus.
 * @apiSince 18
 */

public void onWindowFocusChanged(boolean hasFocus);
}

}

