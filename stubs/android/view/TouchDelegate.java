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

import android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo;

/**
 * Helper class to handle situations where you want a view to have a larger touch area than its
 * actual view bounds. The view whose touch area is changed is called the delegate view. This
 * class should be used by an ancestor of the delegate. To use a TouchDelegate, first create an
 * instance that specifies the bounds that should be mapped to the delegate and the delegate
 * view itself.
 * <p>
 * The ancestor should then forward all of its touch events received in its
 * {@link android.view.View#onTouchEvent(MotionEvent)} to {@link #onTouchEvent(android.view.MotionEvent)}.
 * </p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TouchDelegate {

/**
 * Constructor
 *
 * @param bounds Bounds in local coordinates of the containing view that should be mapped to
 *        the delegate view
 * @param delegateView The view that should receive motion events
 * @apiSince 1
 */

public TouchDelegate(android.graphics.Rect bounds, android.view.View delegateView) { throw new RuntimeException("Stub!"); }

/**
 * Forward touch events to the delegate view if the event is within the bounds
 * specified in the constructor.
 *
 * @param event The touch event to forward
 * This value must never be {@code null}.
 * @return True if the event was consumed by the delegate, false otherwise.
 * @apiSince 1
 */

public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Forward hover events to the delegate view if the event is within the bounds
 * specified in the constructor and touch exploration is enabled.
 *
 * <p>This method is provided for accessibility purposes so touch exploration, which is
 * commonly used by screen readers, can properly place accessibility focus on views that
 * use touch delegates. Therefore, touch exploration must be enabled for hover events
 * to be dispatched through the delegate.</p>
 *
 * @param event The hover event to forward
 * This value must never be {@code null}.
 * @return True if the event was consumed by the delegate, false otherwise.
 *
 * @see android.view.accessibility.AccessibilityManager#isTouchExplorationEnabled
 * @apiSince 29
 */

public boolean onTouchExplorationHoverEvent(@androidx.annotation.NonNull android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo TouchDelegateInfo} mapping from regions (in view coordinates) to
 * delegated views for accessibility usage.
 *
 * @return A TouchDelegateInfo.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo getTouchDelegateInfo() { throw new RuntimeException("Stub!"); }

/**
 * The touchable region of the View extends above its actual extent.
 * @apiSince 1
 */

public static final int ABOVE = 1; // 0x1

/**
 * The touchable region of the View extends below its actual extent.
 * @apiSince 1
 */

public static final int BELOW = 2; // 0x2

/**
 * The touchable region of the View extends to the left of its actual extent.
 * @apiSince 1
 */

public static final int TO_LEFT = 4; // 0x4

/**
 * The touchable region of the View extends to the right of its actual extent.
 * @apiSince 1
 */

public static final int TO_RIGHT = 8; // 0x8
}

