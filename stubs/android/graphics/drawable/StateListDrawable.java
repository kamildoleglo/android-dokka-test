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


package android.graphics.drawable;

import android.content.res.Resources;

/**
 * Lets you assign a number of graphic images to a single Drawable and swap out the visible item by a string
 * ID value.
 * <p/>
 * <p>It can be defined in an XML file with the <code>&lt;selector></code> element.
 * Each state Drawable is defined in a nested <code>&lt;item></code> element. For more
 * information, see the guide to <a
 * href="{@docRoot}guide/topics/resources/drawable-resource.html">Drawable Resources</a>.</p>
 *
 * @attr ref android.R.styleable#StateListDrawable_visible
 * @attr ref android.R.styleable#StateListDrawable_variablePadding
 * @attr ref android.R.styleable#StateListDrawable_constantSize
 * @attr ref android.R.styleable#DrawableStates_state_focused
 * @attr ref android.R.styleable#DrawableStates_state_window_focused
 * @attr ref android.R.styleable#DrawableStates_state_enabled
 * @attr ref android.R.styleable#DrawableStates_state_checkable
 * @attr ref android.R.styleable#DrawableStates_state_checked
 * @attr ref android.R.styleable#DrawableStates_state_selected
 * @attr ref android.R.styleable#DrawableStates_state_activated
 * @attr ref android.R.styleable#DrawableStates_state_active
 * @attr ref android.R.styleable#DrawableStates_state_single
 * @attr ref android.R.styleable#DrawableStates_state_first
 * @attr ref android.R.styleable#DrawableStates_state_middle
 * @attr ref android.R.styleable#DrawableStates_state_last
 * @attr ref android.R.styleable#DrawableStates_state_pressed
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StateListDrawable extends android.graphics.drawable.DrawableContainer {

/** @apiSince 1 */

public StateListDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Add a new image/string ID to the set of images.
 *
 * @param stateSet An array of resource Ids to associate with the image.
 *                 Switch to this image by calling setState().
 * @param drawable The image to show. Note this must be a unique Drawable that is not shared
 *                 between any other View or Drawable otherwise the results are
 *                 undefined and can lead to unexpected rendering behavior
 * @apiSince 1
 */

public void addState(int[] stateSet, android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isStateful() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean onStateChange(int[] stateSet) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void inflate(android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs, android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of states contained in this drawable.
 *
 * @return The number of states contained in this drawable.
 * @see #getStateSet(int)
 * @see #getStateDrawable(int)
 * @apiSince 29
 */

public int getStateCount() { throw new RuntimeException("Stub!"); }

/**
 * Gets the state set at an index.
 *
 * @param index The index of the state set.
 * @return The state set at the index.
 * This value will never be {@code null}.
 * @see #getStateCount()
 * @see #getStateDrawable(int)
 * @apiSince 29
 */

@androidx.annotation.NonNull
public int[] getStateSet(int index) { throw new RuntimeException("Stub!"); }

/**
 * Gets the drawable at an index.
 *
 * @param index The index of the drawable.
 * @return The drawable at the index.
 * This value may be {@code null}.
 * @see #getStateCount()
 * @see #getStateSet(int)
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable getStateDrawable(int index) { throw new RuntimeException("Stub!"); }

/**
 * Gets the index of the drawable with the provided state set.
 *
 * @param stateSet the state set to look up
 * This value must never be {@code null}.
 * @return the index of the provided state set, or -1 if not found
 * @see #getStateDrawable(int)
 * @see #getStateSet(int)
 * @apiSince 29
 */

public int findStateDrawableIndex(@androidx.annotation.NonNull int[] stateSet) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void applyTheme(android.content.res.Resources.Theme theme) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param state This value must never be {@code null}.
 * @apiSince 1
 */

protected void setConstantState(@androidx.annotation.NonNull android.graphics.drawable.DrawableContainer.DrawableContainerState state) { throw new RuntimeException("Stub!"); }
}

