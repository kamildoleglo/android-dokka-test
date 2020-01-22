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

import android.view.ViewGroup;
import android.view.View;

/**
 * {@link android.widget.ViewAnimator ViewAnimator} that switches between two views, and has a factory
 * from which these views are created.  You can either use the factory to
 * create the views, or add them yourself.  A ViewSwitcher can only have two
 * child views, of which only one is shown at a time.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ViewSwitcher extends android.widget.ViewAnimator {

/**
 * Creates a new empty ViewSwitcher.
 *
 * @param context the application's environment
 * @apiSince 1
 */

public ViewSwitcher(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new empty ViewSwitcher for the given context and with the
 * specified set attributes.
 *
 * @param context the application environment
 * @param attrs a collection of attributes
 * @apiSince 1
 */

public ViewSwitcher(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @throws java.lang.IllegalStateException if this switcher already contains two children
 * @apiSince 1
 */

public void addView(android.view.View child, int index, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the next view to be displayed.
 *
 * @return the view that will be displayed after the next views flip.
 * @apiSince 1
 */

public android.view.View getNextView() { throw new RuntimeException("Stub!"); }

/**
 * Sets the factory used to create the two views between which the
 * ViewSwitcher will flip. Instead of using a factory, you can call
 * {@link #addView(android.view.View,int,android.view.ViewGroup.LayoutParams)}
 * twice.
 *
 * @param factory the view factory used to generate the switcher's content
 * @apiSince 1
 */

public void setFactory(android.widget.ViewSwitcher.ViewFactory factory) { throw new RuntimeException("Stub!"); }

/**
 * Reset the ViewSwitcher to hide all of the existing views and to make it
 * think that the first time animation has not yet played.
 * @apiSince 1
 */

public void reset() { throw new RuntimeException("Stub!"); }
/**
 * Creates views in a ViewSwitcher.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ViewFactory {

/**
 * Creates a new {@link android.view.View} to be added in a
 * {@link android.widget.ViewSwitcher}.
 *
 * @return a {@link android.view.View}
 * @apiSince 1
 */

public android.view.View makeView();
}

}

