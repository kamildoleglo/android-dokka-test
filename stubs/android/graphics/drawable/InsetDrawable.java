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
 * A Drawable that insets another Drawable by a specified distance or fraction of the content bounds.
 * This is used when a View needs a background that is smaller than
 * the View's actual bounds.
 *
 * <p>It can be defined in an XML file with the <code>&lt;inset></code> element. For more
 * information, see the guide to <a
 * href="{@docRoot}guide/topics/resources/drawable-resource.html">Drawable Resources</a>.</p>
 *
 * @attr ref android.R.styleable#InsetDrawable_visible
 * @attr ref android.R.styleable#InsetDrawable_drawable
 * @attr ref android.R.styleable#InsetDrawable_insetLeft
 * @attr ref android.R.styleable#InsetDrawable_insetRight
 * @attr ref android.R.styleable#InsetDrawable_insetTop
 * @attr ref android.R.styleable#InsetDrawable_insetBottom
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class InsetDrawable extends android.graphics.drawable.DrawableWrapper {

/**
 * Creates a new inset drawable with the specified inset.
 *
 * @param drawable The drawable to inset.
 * This value may be {@code null}.
 * @param inset Inset in pixels around the drawable.
 * @apiSince 1
 */

public InsetDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable, int inset) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new inset drawable with the specified inset.
 *
 * @param drawable The drawable to inset.
 * This value may be {@code null}.
 * @param inset Inset in fraction (range: [0, 1)) of the inset content bounds.
 * @apiSince 26
 */

public InsetDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable, float inset) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new inset drawable with the specified insets in pixels.
 *
 * @param drawable The drawable to inset.
 * This value may be {@code null}.
 * @param insetLeft Left inset in pixels.
 * @param insetTop Top inset in pixels.
 * @param insetRight Right inset in pixels.
 * @param insetBottom Bottom inset in pixels.
 * @apiSince 1
 */

public InsetDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable, int insetLeft, int insetTop, int insetRight, int insetBottom) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new inset drawable with the specified insets in fraction of the view bounds.
 *
 * @param drawable The drawable to inset.
 * This value may be {@code null}.
 * @param insetLeftFraction Left inset in fraction (range: [0, 1)) of the inset content bounds.
 * @param insetTopFraction Top inset in fraction (range: [0, 1)) of the inset content bounds.
 * @param insetRightFraction Right inset in fraction (range: [0, 1)) of the inset content bounds.
 * @param insetBottomFraction Bottom inset in fraction (range: [0, 1)) of the inset content bounds.
 * @apiSince 26
 */

public InsetDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable, float insetLeftFraction, float insetTopFraction, float insetRightFraction, float insetBottomFraction) { super(null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param r This value must never be {@code null}.
 
 * @param parser This value must never be {@code null}.
 
 * @param attrs This value must never be {@code null}.
 
 * @param theme This value may be {@code null}.
 * @apiSince 21
 */

public void inflate(@androidx.annotation.NonNull android.content.res.Resources r, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser parser, @androidx.annotation.NonNull android.util.AttributeSet attrs, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param t This value must never be {@code null}.
 * @apiSince 21
 */

public void applyTheme(@androidx.annotation.NonNull android.content.res.Resources.Theme t) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean getPadding(android.graphics.Rect padding) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public android.graphics.Insets getOpticalInsets() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getOpacity() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onBoundsChange(android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIntrinsicWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIntrinsicHeight() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param outline This value must never be {@code null}.
 * @apiSince 21
 */

public void getOutline(@androidx.annotation.NonNull android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }
}

