/*
 * Copyright (C) 2007 The Android Open Source Project
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
 * <p>
 * A Drawable that can rotate another Drawable based on the current level value.
 * The start and end angles of rotation can be controlled to map any circular
 * arc to the level values range.
 * <p>
 * It can be defined in an XML file with the <code>&lt;rotate&gt;</code> element.
 * For more information, see the guide to
 * <a href="{@docRoot}guide/topics/resources/animation-resource.html">Animation Resources</a>.
 *
 * @attr ref android.R.styleable#RotateDrawable_visible
 * @attr ref android.R.styleable#RotateDrawable_fromDegrees
 * @attr ref android.R.styleable#RotateDrawable_toDegrees
 * @attr ref android.R.styleable#RotateDrawable_pivotX
 * @attr ref android.R.styleable#RotateDrawable_pivotY
 * @attr ref android.R.styleable#RotateDrawable_drawable
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RotateDrawable extends android.graphics.drawable.DrawableWrapper {

/**
 * Creates a new rotating drawable with no wrapped drawable.
 * @apiSince 1
 */

public RotateDrawable() { super(null); throw new RuntimeException("Stub!"); }

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

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Sets the start angle for rotation.
 *
 * @param fromDegrees starting angle in degrees
 * @see #getFromDegrees()
 * @attr ref android.R.styleable#RotateDrawable_fromDegrees
 * @apiSince 21
 */

public void setFromDegrees(float fromDegrees) { throw new RuntimeException("Stub!"); }

/**
 * @return starting angle for rotation in degrees
 * @see #setFromDegrees(float)
 * @attr ref android.R.styleable#RotateDrawable_fromDegrees
 * @apiSince 21
 */

public float getFromDegrees() { throw new RuntimeException("Stub!"); }

/**
 * Sets the end angle for rotation.
 *
 * @param toDegrees ending angle in degrees
 * @see #getToDegrees()
 * @attr ref android.R.styleable#RotateDrawable_toDegrees
 * @apiSince 21
 */

public void setToDegrees(float toDegrees) { throw new RuntimeException("Stub!"); }

/**
 * @return ending angle for rotation in degrees
 * @see #setToDegrees(float)
 * @attr ref android.R.styleable#RotateDrawable_toDegrees
 * @apiSince 21
 */

public float getToDegrees() { throw new RuntimeException("Stub!"); }

/**
 * Sets the X position around which the drawable is rotated.
 * <p>
 * If the X pivot is relative (as specified by
 * {@link #setPivotXRelative(boolean)}), then the position represents a
 * fraction of the drawable width. Otherwise, the position represents an
 * absolute value in pixels.
 *
 * @param pivotX X position around which to rotate
 * @see #setPivotXRelative(boolean)
 * @attr ref android.R.styleable#RotateDrawable_pivotX
 * @apiSince 21
 */

public void setPivotX(float pivotX) { throw new RuntimeException("Stub!"); }

/**
 * @return X position around which to rotate
 * @see #setPivotX(float)
 * @attr ref android.R.styleable#RotateDrawable_pivotX
 * @apiSince 21
 */

public float getPivotX() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the X pivot value represents a fraction of the drawable
 * width or an absolute value in pixels.
 *
 * @param relative true if the X pivot represents a fraction of the drawable
 *            width, or false if it represents an absolute value in pixels
 * @see #isPivotXRelative()
 * @apiSince 21
 */

public void setPivotXRelative(boolean relative) { throw new RuntimeException("Stub!"); }

/**
 * @return true if the X pivot represents a fraction of the drawable width,
 *         or false if it represents an absolute value in pixels
 * @see #setPivotXRelative(boolean)
 * @apiSince 21
 */

public boolean isPivotXRelative() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Y position around which the drawable is rotated.
 * <p>
 * If the Y pivot is relative (as specified by
 * {@link #setPivotYRelative(boolean)}), then the position represents a
 * fraction of the drawable height. Otherwise, the position represents an
 * absolute value in pixels.
 *
 * @param pivotY Y position around which to rotate
 * @see #getPivotY()
 * @attr ref android.R.styleable#RotateDrawable_pivotY
 * @apiSince 21
 */

public void setPivotY(float pivotY) { throw new RuntimeException("Stub!"); }

/**
 * @return Y position around which to rotate
 * @see #setPivotY(float)
 * @attr ref android.R.styleable#RotateDrawable_pivotY
 * @apiSince 21
 */

public float getPivotY() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the Y pivot value represents a fraction of the drawable
 * height or an absolute value in pixels.
 *
 * @param relative True if the Y pivot represents a fraction of the drawable
 *            height, or false if it represents an absolute value in pixels
 * @see #isPivotYRelative()
 * @apiSince 21
 */

public void setPivotYRelative(boolean relative) { throw new RuntimeException("Stub!"); }

/**
 * @return true if the Y pivot represents a fraction of the drawable height,
 *         or false if it represents an absolute value in pixels
 * @see #setPivotYRelative(boolean)
 * @apiSince 21
 */

public boolean isPivotYRelative() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean onLevelChange(int level) { throw new RuntimeException("Stub!"); }
}

