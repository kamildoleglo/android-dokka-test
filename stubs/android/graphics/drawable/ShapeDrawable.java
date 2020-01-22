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

import android.graphics.drawable.shapes.Shape;
import android.graphics.Canvas;
import android.content.res.Resources;
import android.graphics.Shader;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * A Drawable object that draws primitive shapes. A ShapeDrawable takes a
 * {@link android.graphics.drawable.shapes.Shape} object and manages its
 * presence on the screen. If no Shape is given, then the ShapeDrawable will
 * default to a {@link android.graphics.drawable.shapes.RectShape}.
 * <p>
 * This object can be defined in an XML file with the <code>&lt;shape></code>
 * element.
 * </p>
 * <div class="special reference"> <h3>Developer Guides</h3>
 * <p>
 * For more information about how to use ShapeDrawable, read the <a
 * href="{@docRoot}guide/topics/graphics/2d-graphics.html#shape-drawable">
 * Canvas and Drawables</a> document. For more information about defining a
 * ShapeDrawable in XML, read the
 * <a href="{@docRoot}guide/topics/resources/drawable-resource.html#Shape">
 * Drawable Resources</a> document.
 * </p>
 * </div>
 *
 * @attr ref android.R.styleable#ShapeDrawablePadding_left
 * @attr ref android.R.styleable#ShapeDrawablePadding_top
 * @attr ref android.R.styleable#ShapeDrawablePadding_right
 * @attr ref android.R.styleable#ShapeDrawablePadding_bottom
 * @attr ref android.R.styleable#ShapeDrawable_color
 * @attr ref android.R.styleable#ShapeDrawable_width
 * @attr ref android.R.styleable#ShapeDrawable_height
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ShapeDrawable extends android.graphics.drawable.Drawable {

/**
 * ShapeDrawable constructor.
 * @apiSince 1
 */

public ShapeDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Creates a ShapeDrawable with a specified Shape.
 *
 * @param s the Shape that this ShapeDrawable should be
 * @apiSince 1
 */

public ShapeDrawable(android.graphics.drawable.shapes.Shape s) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Shape of this ShapeDrawable.
 * @apiSince 1
 */

public android.graphics.drawable.shapes.Shape getShape() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Shape of this ShapeDrawable.
 * @apiSince 1
 */

public void setShape(android.graphics.drawable.shapes.Shape s) { throw new RuntimeException("Stub!"); }

/**
 * Sets a ShaderFactory to which requests for a
 * {@link android.graphics.Shader} object will be made.
 *
 * @param fact an instance of your ShaderFactory implementation
 * @apiSince 1
 */

public void setShaderFactory(android.graphics.drawable.ShapeDrawable.ShaderFactory fact) { throw new RuntimeException("Stub!"); }

/**
 * Returns the ShaderFactory used by this ShapeDrawable for requesting a
 * {@link android.graphics.Shader}.
 * @apiSince 1
 */

public android.graphics.drawable.ShapeDrawable.ShaderFactory getShaderFactory() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Paint used to draw the shape.
 * @apiSince 1
 */

public android.graphics.Paint getPaint() { throw new RuntimeException("Stub!"); }

/**
 * Sets padding for the shape.
 *
 * @param left padding for the left side (in pixels)
 * @param top padding for the top (in pixels)
 * @param right padding for the right side (in pixels)
 * @param bottom padding for the bottom (in pixels)
 * @apiSince 1
 */

public void setPadding(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Sets padding for this shape, defined by a Rect object. Define the padding
 * in the Rect object as: left, top, right, bottom.
 * @apiSince 1
 */

public void setPadding(android.graphics.Rect padding) { throw new RuntimeException("Stub!"); }

/**
 * Sets the intrinsic (default) width for this shape.
 *
 * @param width the intrinsic width (in pixels)
 * @apiSince 1
 */

public void setIntrinsicWidth(int width) { throw new RuntimeException("Stub!"); }

/**
 * Sets the intrinsic (default) height for this shape.
 *
 * @param height the intrinsic height (in pixels)
 * @apiSince 1
 */

public void setIntrinsicHeight(int height) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIntrinsicWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIntrinsicHeight() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean getPadding(android.graphics.Rect padding) { throw new RuntimeException("Stub!"); }

/**
 * Called from the drawable's draw() method after the canvas has been set to
 * draw the shape at (0,0). Subclasses can override for special effects such
 * as multiple layers, stroking, etc.
 * @apiSince 1
 */

protected void onDraw(android.graphics.drawable.shapes.Shape shape, android.graphics.Canvas canvas, android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @apiSince 1
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * Set the alpha level for this drawable [0..255]. Note that this drawable
 * also has a color in its paint, which has an alpha as well. These two
 * values are automatically combined during drawing. Thus if the color's
 * alpha is 75% (i.e. 192) and the drawable's alpha is 50% (i.e. 128), then
 * the combined alpha that will be used during drawing will be 37.5% (i.e.
 * 96).
 * @apiSince 1
 */

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int getAlpha() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setTintList(android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param blendMode This value must never be {@code null}.
 * @apiSince 29
 */

public void setTintBlendMode(@androidx.annotation.NonNull android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setColorFilter(android.graphics.ColorFilter colorFilter) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getOpacity() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setDither(boolean dither) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onBoundsChange(android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean onStateChange(int[] stateSet) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isStateful() { throw new RuntimeException("Stub!"); }

/**
 * Subclasses override this to parse custom subelements. If you handle it,
 * return true, else return <em>super.inflateTag(...)</em>.
 * @apiSince 1
 */

protected boolean inflateTag(java.lang.String name, android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void inflate(android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs, android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void applyTheme(android.content.res.Resources.Theme t) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void getOutline(android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }
/**
 * Base class defines a factory object that is called each time the drawable
 * is resized (has a new width or height). Its resize() method returns a
 * corresponding shader, or null. Implement this class if you'd like your
 * ShapeDrawable to use a special {@link android.graphics.Shader}, such as a
 * {@link android.graphics.LinearGradient}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class ShaderFactory {

public ShaderFactory() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Shader to be drawn when a Drawable is drawn. The
 * dimensions of the Drawable are passed because they may be needed to
 * adjust how the Shader is configured for drawing. This is called by
 * ShapeDrawable.setShape().
 *
 * @param width the width of the Drawable being drawn
 * @param height the heigh of the Drawable being drawn
 * @return the Shader to be drawn
 * @apiSince 1
 */

public abstract android.graphics.Shader resize(int width, int height);
}

}

