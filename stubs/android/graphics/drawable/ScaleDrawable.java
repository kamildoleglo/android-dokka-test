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
import android.view.Gravity;

/**
 * A Drawable that changes the size of another Drawable based on its current
 * level value. You can control how much the child Drawable changes in width
 * and height based on the level, as well as a gravity to control where it is
 * placed in its overall container. Most often used to implement things like
 * progress bars.
 * <p>
 * The default level may be specified from XML using the
 * {@link android.R.styleable#ScaleDrawable_level android:level} property. When
 * this property is not specified, the default level is 0, which corresponds to
 * zero height and/or width depending on the values specified for
 * {@code android.R.styleable#ScaleDrawable_scaleWidth scaleWidth} and
 * {@code android.R.styleable#ScaleDrawable_scaleHeight scaleHeight}. At run
 * time, the level may be set via {@link #setLevel(int)}.
 * <p>
 * A scale drawable may be defined in an XML file with the {@code <scale>}
 * element. For more information, see the guide to
 * <a href="{@docRoot}guide/topics/resources/drawable-resource.html">Drawable
 * Resources</a>.
 *
 * @attr ref android.R.styleable#ScaleDrawable_scaleWidth
 * @attr ref android.R.styleable#ScaleDrawable_scaleHeight
 * @attr ref android.R.styleable#ScaleDrawable_scaleGravity
 * @attr ref android.R.styleable#ScaleDrawable_drawable
 * @attr ref android.R.styleable#ScaleDrawable_level
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ScaleDrawable extends android.graphics.drawable.DrawableWrapper {

/**
 * Creates a new scale drawable with the specified gravity and scale
 * properties.
 *
 * @param drawable the drawable to scale
 * @param gravity gravity constant (see {@link android.view.Gravity Gravity} used to position
 *                the scaled drawable within the parent container
 * @param scaleWidth width scaling factor [0...1] to use then the level is
 *                   at the maximum value, or -1 to not scale width
 * @param scaleHeight height scaling factor [0...1] to use then the level
 *                    is at the maximum value, or -1 to not scale height
 * @apiSince 1
 */

public ScaleDrawable(android.graphics.drawable.Drawable drawable, int gravity, float scaleWidth, float scaleHeight) { super(null); throw new RuntimeException("Stub!"); }

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

/** @apiSince 1 */

public int getOpacity() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean onLevelChange(int level) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onBoundsChange(android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }
}

