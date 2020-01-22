/*
 * Copyright (C) 2014 The Android Open Source Project
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

import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/**
 * Interface by which a View builds its {@link android.graphics.Outline Outline}, used for shadow casting and clipping.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ViewOutlineProvider {

public ViewOutlineProvider() { throw new RuntimeException("Stub!"); }

/**
 * Called to get the provider to populate the Outline.
 *
 * This method will be called by a View when its owned Drawables are invalidated, when the
 * View's size changes, or if {@link android.view.View#invalidateOutline() View#invalidateOutline()} is called
 * explicitly.
 *
 * The input outline is empty and has an alpha of <code>1.0f</code>.
 *
 * @param view The view building the outline.
 * @param outline The empty outline to be populated.
 * @apiSince 21
 */

public abstract void getOutline(android.view.View view, android.graphics.Outline outline);

/**
 * Default outline provider for Views, which queries the Outline from the View's background,
 * or generates a 0 alpha, rectangular Outline the size of the View if a background
 * isn't present.
 *
 * @see android.graphics.drawable.Drawable#getOutline(Outline)
 * @apiSince 21
 */

public static final android.view.ViewOutlineProvider BACKGROUND;
static { BACKGROUND = null; }

/**
 * Maintains the outline of the View to match its rectangular bounds,
 * at <code>1.0f</code> alpha.
 *
 * This can be used to enable Views that are opaque but lacking a background cast a shadow.
 * @apiSince 21
 */

public static final android.view.ViewOutlineProvider BOUNDS;
static { BOUNDS = null; }

/**
 * Maintains the outline of the View to match its rectangular padded bounds,
 * at <code>1.0f</code> alpha.
 *
 * This can be used to enable Views that are opaque but lacking a background cast a shadow.
 * @apiSince 21
 */

public static final android.view.ViewOutlineProvider PADDED_BOUNDS;
static { PADDED_BOUNDS = null; }
}

