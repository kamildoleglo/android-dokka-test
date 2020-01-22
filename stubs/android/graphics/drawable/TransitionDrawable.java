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


package android.graphics.drawable;

import android.content.res.Resources;

/**
 * An extension of LayerDrawables that is intended to cross-fade between
 * the first and second layer. To start the transition, call {@link #startTransition(int)}. To
 * display just the first layer, call {@link #resetTransition()}.
 * <p>
 * It can be defined in an XML file with the <code>&lt;transition></code> element.
 * Each Drawable in the transition is defined in a nested <code>&lt;item></code>. For more
 * information, see the guide to <a
 * href="{@docRoot}guide/topics/resources/drawable-resource.html">Drawable Resources</a>.</p>
 *
 * @attr ref android.R.styleable#LayerDrawableItem_left
 * @attr ref android.R.styleable#LayerDrawableItem_top
 * @attr ref android.R.styleable#LayerDrawableItem_right
 * @attr ref android.R.styleable#LayerDrawableItem_bottom
 * @attr ref android.R.styleable#LayerDrawableItem_drawable
 * @attr ref android.R.styleable#LayerDrawableItem_id
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TransitionDrawable extends android.graphics.drawable.LayerDrawable implements android.graphics.drawable.Drawable.Callback {

/**
 * Create a new transition drawable with the specified list of layers. At least
 * 2 layers are required for this drawable to work properly.
 * @apiSince 3
 */

public TransitionDrawable(android.graphics.drawable.Drawable[] layers) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Begin the second layer on top of the first layer.
 *
 * @param durationMillis The length of the transition in milliseconds
 * @apiSince 1
 */

public void startTransition(int durationMillis) { throw new RuntimeException("Stub!"); }

/**
 * Show only the first layer.
 * @apiSince 1
 */

public void resetTransition() { throw new RuntimeException("Stub!"); }

/**
 * Reverses the transition, picking up where the transition currently is.
 * If the transition is not currently running, this will start the transition
 * with the specified duration. If the transition is already running, the last
 * known duration will be used.
 *
 * @param duration The duration to use if no transition is running.
 * @apiSince 1
 */

public void reverseTransition(int duration) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables the cross fade of the drawables. When cross fade
 * is disabled, the first drawable is always drawn opaque. With cross
 * fade enabled, the first drawable is drawn with the opposite alpha of
 * the second drawable. Cross fade is disabled by default.
 *
 * @param enabled True to enable cross fading, false otherwise.
 * @apiSince 1
 */

public void setCrossFadeEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the cross fade is enabled for this transition.
 *
 * @return True if cross fading is enabled, false otherwise.
 * @apiSince 1
 */

public boolean isCrossFadeEnabled() { throw new RuntimeException("Stub!"); }
}

