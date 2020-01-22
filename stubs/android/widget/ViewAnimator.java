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


package android.widget;

import android.view.View;
import android.content.Context;
import android.view.animation.Animation;

/**
 * Base class for a {@link android.widget.FrameLayout FrameLayout} container that will perform animations
 * when switching between its views.
 *
 * @attr ref android.R.styleable#ViewAnimator_inAnimation
 * @attr ref android.R.styleable#ViewAnimator_outAnimation
 * @attr ref android.R.styleable#ViewAnimator_animateFirstView
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ViewAnimator extends android.widget.FrameLayout {

/** @apiSince 1 */

public ViewAnimator(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ViewAnimator(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Sets which child view will be displayed.
 *
 * @param whichChild the index of the child view to display
 * @apiSince 1
 */

public void setDisplayedChild(int whichChild) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index of the currently displayed child view.
 * @apiSince 1
 */

public int getDisplayedChild() { throw new RuntimeException("Stub!"); }

/**
 * Manually shows the next child.
 * @apiSince 1
 */

public void showNext() { throw new RuntimeException("Stub!"); }

/**
 * Manually shows the previous child.
 * @apiSince 1
 */

public void showPrevious() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void addView(android.view.View child, int index, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void removeAllViews() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void removeView(android.view.View view) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void removeViewAt(int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void removeViewInLayout(android.view.View view) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void removeViews(int start, int count) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void removeViewsInLayout(int start, int count) { throw new RuntimeException("Stub!"); }

/**
 * Returns the View corresponding to the currently displayed child.
 *
 * @return The View currently displayed.
 *
 * @see #getDisplayedChild()
 * @apiSince 1
 */

public android.view.View getCurrentView() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current animation used to animate a View that enters the screen.
 *
 * @return An Animation or null if none is set.
 *
 * @see #setInAnimation(android.view.animation.Animation)
 * @see #setInAnimation(android.content.Context, int)
 * @apiSince 1
 */

public android.view.animation.Animation getInAnimation() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the animation used to animate a View that enters the screen.
 *
 * @param inAnimation The animation started when a View enters the screen.
 *
 * @see #getInAnimation()
 * @see #setInAnimation(android.content.Context, int)
 * @apiSince 1
 */

public void setInAnimation(android.view.animation.Animation inAnimation) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current animation used to animate a View that exits the screen.
 *
 * @return An Animation or null if none is set.
 *
 * @see #setOutAnimation(android.view.animation.Animation)
 * @see #setOutAnimation(android.content.Context, int)
 * @apiSince 1
 */

public android.view.animation.Animation getOutAnimation() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the animation used to animate a View that exit the screen.
 *
 * @param outAnimation The animation started when a View exit the screen.
 *
 * @see #getOutAnimation()
 * @see #setOutAnimation(android.content.Context, int)
 * @apiSince 1
 */

public void setOutAnimation(android.view.animation.Animation outAnimation) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the animation used to animate a View that enters the screen.
 *
 * @param context The application's environment.
 * @param resourceID The resource id of the animation.
 *
 * @see #getInAnimation()
 * @see #setInAnimation(android.view.animation.Animation)
 * @apiSince 1
 */

public void setInAnimation(android.content.Context context, int resourceID) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the animation used to animate a View that exit the screen.
 *
 * @param context The application's environment.
 * @param resourceID The resource id of the animation.
 *
 * @see #getOutAnimation()
 * @see #setOutAnimation(android.view.animation.Animation)
 * @apiSince 1
 */

public void setOutAnimation(android.content.Context context, int resourceID) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the current View should be animated the first time the ViewAnimator
 * is displayed.
 *
 * @return true if the current View will be animated the first time it is displayed,
 * false otherwise.
 *
 * @see #setAnimateFirstView(boolean)
 * @apiSince 17
 */

public boolean getAnimateFirstView() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the current View should be animated the first time
 * the ViewAnimator is displayed.
 *
 * @param animate True to animate the current View the first time it is displayed,
 *                false otherwise.
 * @apiSince 1
 */

public void setAnimateFirstView(boolean animate) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getBaseline() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
}

