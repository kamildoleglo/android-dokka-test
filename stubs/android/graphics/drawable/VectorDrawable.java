/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */


package android.graphics.drawable;

import android.graphics.Shader;

/**
 * This lets you create a drawable based on an XML vector graphic.
 * <p/>
 * <strong>Note:</strong> To optimize for the re-drawing performance, one bitmap cache is created
 * for each VectorDrawable. Therefore, referring to the same VectorDrawable means sharing the same
 * bitmap cache. If these references don't agree upon on the same size, the bitmap will be recreated
 * and redrawn every time size is changed. In other words, if a VectorDrawable is used for
 * different sizes, it is more efficient to create multiple VectorDrawables, one for each size.
 * <p/>
 * VectorDrawable can be defined in an XML file with the <code>&lt;vector></code> element.
 * <p/>
 * The vector drawable has the following elements:
 * <p/>
 * <dt><code>&lt;vector></code></dt>
 * <dl>
 * <dd>Used to define a vector drawable
 * <dl>
 * <dt><code>android:name</code></dt>
 * <dd>Defines the name of this vector drawable.</dd>
 * <dt><code>android:width</code></dt>
 * <dd>Used to define the intrinsic width of the drawable.
 * This support all the dimension units, normally specified with dp.</dd>
 * <dt><code>android:height</code></dt>
 * <dd>Used to define the intrinsic height the drawable.
 * This support all the dimension units, normally specified with dp.</dd>
 * <dt><code>android:viewportWidth</code></dt>
 * <dd>Used to define the width of the viewport space. Viewport is basically
 * the virtual canvas where the paths are drawn on.</dd>
 * <dt><code>android:viewportHeight</code></dt>
 * <dd>Used to define the height of the viewport space. Viewport is basically
 * the virtual canvas where the paths are drawn on.</dd>
 * <dt><code>android:tint</code></dt>
 * <dd>The color to apply to the drawable as a tint. By default, no tint is applied.</dd>
 * <dt><code>android:tintMode</code></dt>
 * <dd>The Porter-Duff blending mode for the tint color. Default is src_in.</dd>
 * <dt><code>android:autoMirrored</code></dt>
 * <dd>Indicates if the drawable needs to be mirrored when its layout direction is
 * RTL (right-to-left). Default is false.</dd>
 * <dt><code>android:alpha</code></dt>
 * <dd>The opacity of this drawable. Default is 1.0.</dd>
 * </dl></dd>
 * </dl>
 *
 * <dl>
 * <dt><code>&lt;group></code></dt>
 * <dd>Defines a group of paths or subgroups, plus transformation information.
 * The transformations are defined in the same coordinates as the viewport.
 * And the transformations are applied in the order of scale, rotate then translate.
 * <dl>
 * <dt><code>android:name</code></dt>
 * <dd>Defines the name of the group.</dd>
 * <dt><code>android:rotation</code></dt>
 * <dd>The degrees of rotation of the group. Default is 0.</dd>
 * <dt><code>android:pivotX</code></dt>
 * <dd>The X coordinate of the pivot for the scale and rotation of the group.
 * This is defined in the viewport space. Default is 0.</dd>
 * <dt><code>android:pivotY</code></dt>
 * <dd>The Y coordinate of the pivot for the scale and rotation of the group.
 * This is defined in the viewport space. Default is 0.</dd>
 * <dt><code>android:scaleX</code></dt>
 * <dd>The amount of scale on the X Coordinate. Default is 1.</dd>
 * <dt><code>android:scaleY</code></dt>
 * <dd>The amount of scale on the Y coordinate. Default is 1.</dd>
 * <dt><code>android:translateX</code></dt>
 * <dd>The amount of translation on the X coordinate.
 * This is defined in the viewport space. Default is 0.</dd>
 * <dt><code>android:translateY</code></dt>
 * <dd>The amount of translation on the Y coordinate.
 * This is defined in the viewport space. Default is 0.</dd>
 * </dl></dd>
 * </dl>
 *
 * <dl>
 * <dt><code>&lt;path></code></dt>
 * <dd>Defines paths to be drawn.
 * <dl>
 * <dt><code>android:name</code></dt>
 * <dd>Defines the name of the path.</dd>
 * <dt><code>android:pathData</code></dt>
 * <dd>Defines path data using exactly same format as "d" attribute
 * in the SVG's path data. This is defined in the viewport space.</dd>
 * <dt><code>android:fillColor</code></dt>
 * <dd>Specifies the color used to fill the path. May be a color or, for SDK 24+, a color state list
 * or a gradient color (See {@link android.R.styleable#GradientColor}
 * and {@link android.R.styleable#GradientColorItem}).
 * If this property is animated, any value set by the animation will override the original value.
 * No path fill is drawn if this property is not specified.</dd>
 * <dt><code>android:strokeColor</code></dt>
 * <dd>Specifies the color used to draw the path outline. May be a color or, for SDK 24+, a color
 * state list or a gradient color (See {@link android.R.styleable#GradientColor}
 * and {@link android.R.styleable#GradientColorItem}).
 * If this property is animated, any value set by the animation will override the original value.
 * No path outline is drawn if this property is not specified.</dd>
 * <dt><code>android:strokeWidth</code></dt>
 * <dd>The width a path stroke. Default is 0.</dd>
 * <dt><code>android:strokeAlpha</code></dt>
 * <dd>The opacity of a path stroke. Default is 1.</dd>
 * <dt><code>android:fillAlpha</code></dt>
 * <dd>The opacity to fill the path with. Default is 1.</dd>
 * <dt><code>android:trimPathStart</code></dt>
 * <dd>The fraction of the path to trim from the start, in the range from 0 to 1. Default is 0.</dd>
 * <dt><code>android:trimPathEnd</code></dt>
 * <dd>The fraction of the path to trim from the end, in the range from 0 to 1. Default is 1.</dd>
 * <dt><code>android:trimPathOffset</code></dt>
 * <dd>Shift trim region (allows showed region to include the start and end), in the range
 * from 0 to 1. Default is 0.</dd>
 * <dt><code>android:strokeLineCap</code></dt>
 * <dd>Sets the linecap for a stroked path: butt, round, square. Default is butt.</dd>
 * <dt><code>android:strokeLineJoin</code></dt>
 * <dd>Sets the lineJoin for a stroked path: miter,round,bevel. Default is miter.</dd>
 * <dt><code>android:strokeMiterLimit</code></dt>
 * <dd>Sets the Miter limit for a stroked path. Default is 4.</dd>
 * <dt><code>android:fillType</code></dt>
 * <dd>For SDK 24+, sets the fillType for a path. The types can be either "evenOdd" or "nonZero". They behave the
 * same as SVG's "fill-rule" properties. Default is nonZero. For more details, see
 * <a href="https://www.w3.org/TR/SVG/painting.html#FillRuleProperty">FillRuleProperty</a></dd>
 * </dl></dd>
 *
 * </dl>
 *
 * <dl>
 * <dt><code>&lt;clip-path></code></dt>
 * <dd>Defines path to be the current clip. Note that the clip path only apply to
 * the current group and its children.
 * <dl>
 * <dt><code>android:name</code></dt>
 * <dd>Defines the name of the clip path.</dd>
 * <dd>Animatable : No.</dd>
 * <dt><code>android:pathData</code></dt>
 * <dd>Defines clip path using the same format as "d" attribute
 * in the SVG's path data.</dd>
 * <dd>Animatable : Yes.</dd>
 * </dl></dd>
 * </dl>
 * <li>Here is a simple VectorDrawable in this vectordrawable.xml file.
 * <pre>
 * &lt;vector xmlns:android=&quot;http://schemas.android.com/apk/res/android&quot;
 *     android:height=&quot;64dp&quot;
 *     android:width=&quot;64dp&quot;
 *     android:viewportHeight=&quot;600&quot;
 *     android:viewportWidth=&quot;600&quot; &gt;
 *     &lt;group
 *         android:name=&quot;rotationGroup&quot;
 *         android:pivotX=&quot;300.0&quot;
 *         android:pivotY=&quot;300.0&quot;
 *         android:rotation=&quot;45.0&quot; &gt;
 *         &lt;path
 *             android:name=&quot;v&quot;
 *             android:fillColor=&quot;#000000&quot;
 *             android:pathData=&quot;M300,70 l 0,-70 70,70 0,0 -70,70z&quot; /&gt;
 *     &lt;/group&gt;
 * &lt;/vector&gt;
 * </pre>
 * </li>
 * <h4>Gradient support</h4>
 * We support 3 types of gradients: {@link android.graphics.LinearGradient},
 * {@link android.graphics.RadialGradient}, or {@link android.graphics.SweepGradient}.
 * <p/>
 * And we support all of 3 types of tile modes {@link android.graphics.Shader.TileMode}:
 * CLAMP, REPEAT, MIRROR.
 * <p/>
 * All of the attributes are listed in {@link android.R.styleable#GradientColor}.
 * Note that different attributes are relevant for different types of gradient.
 * <table border="2" align="center" cellpadding="5">
 *     <thead>
 *         <tr>
 *             <th>LinearGradient</th>
 *             <th>RadialGradient</th>
 *             <th>SweepGradient</th>
 *         </tr>
 *     </thead>
 *     <tr>
 *         <td>startColor </td>
 *         <td>startColor</td>
 *         <td>startColor</td>
 *     </tr>
 *     <tr>
 *         <td>centerColor</td>
 *         <td>centerColor</td>
 *         <td>centerColor</td>
 *     </tr>
 *     <tr>
 *         <td>endColor</td>
 *         <td>endColor</td>
 *         <td>endColor</td>
 *     </tr>
 *     <tr>
 *         <td>type</td>
 *         <td>type</td>
 *         <td>type</td>
 *     </tr>
 *     <tr>
 *         <td>tileMode</td>
 *         <td>tileMode</td>
 *         <td>tileMode</td>
 *     </tr>
 *     <tr>
 *         <td>startX</td>
 *         <td>centerX</td>
 *         <td>centerX</td>
 *     </tr>
 *     <tr>
 *         <td>startY</td>
 *         <td>centerY</td>
 *         <td>centerY</td>
 *     </tr>
 *     <tr>
 *         <td>endX</td>
 *         <td>gradientRadius</td>
 *         <td></td>
 *     </tr>
 *     <tr>
 *         <td>endY</td>
 *         <td></td>
 *         <td></td>
 *     </tr>
 * </table>
 * <p/>
 * Also note that if any color item {@link android.R.styleable#GradientColorItem} is defined, then
 * startColor, centerColor and endColor will be ignored.
 * <p/>
 * See more details in {@link android.R.styleable#GradientColor} and
 * {@link android.R.styleable#GradientColorItem}.
 * <p/>
 * Here is a simple example that defines a linear gradient.
 * <pre>
 * &lt;gradient xmlns:android="http://schemas.android.com/apk/res/android"
 *     android:startColor="?android:attr/colorPrimary"
 *     android:endColor="?android:attr/colorControlActivated"
 *     android:centerColor="#f00"
 *     android:startX="0"
 *     android:startY="0"
 *     android:endX="100"
 *     android:endY="100"
 *     android:type="linear"&gt;
 * &lt;/gradient&gt;
 * </pre>
 * And here is a simple example that defines a radial gradient using color items.
 * <pre>
 * &lt;gradient xmlns:android="http://schemas.android.com/apk/res/android"
 *     android:centerX="300"
 *     android:centerY="300"
 *     android:gradientRadius="100"
 *     android:type="radial"&gt;
 *     &lt;item android:offset="0.1" android:color="#0ff"/&gt;
 *     &lt;item android:offset="0.4" android:color="#fff"/&gt;
 *     &lt;item android:offset="0.9" android:color="#ff0"/&gt;
 * &lt;/gradient&gt;
 * </pre>
 *
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class VectorDrawable extends android.graphics.drawable.Drawable {

/** @apiSince 21 */

public VectorDrawable() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int getAlpha() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setColorFilter(android.graphics.ColorFilter colorFilter) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.graphics.ColorFilter getColorFilter() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setTintList(android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param blendMode This value must never be {@code null}.
 * @apiSince 29
 */

public void setTintBlendMode(@androidx.annotation.NonNull android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean isStateful() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected boolean onStateChange(int[] stateSet) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int getOpacity() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int getIntrinsicWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int getIntrinsicHeight() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public android.graphics.Insets getOpticalInsets() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void applyTheme(android.content.res.Resources.Theme t) { throw new RuntimeException("Stub!"); }

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

 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @apiSince 21
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setAutoMirrored(boolean mirrored) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean isAutoMirrored() { throw new RuntimeException("Stub!"); }
}

