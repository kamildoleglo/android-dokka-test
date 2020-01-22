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

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * This class animates properties of a {@link android.graphics.drawable.VectorDrawable} with
 * animations defined using {@link android.animation.ObjectAnimator} or
 * {@link android.animation.AnimatorSet}.
 * <p>
 * Starting from API 25, AnimatedVectorDrawable runs on RenderThread (as opposed to on UI thread for
 * earlier APIs). This means animations in AnimatedVectorDrawable can remain smooth even when there
 * is heavy workload on the UI thread. Note: If the UI thread is unresponsive, RenderThread may
 * continue animating until the UI thread is capable of pushing another frame. Therefore, it is not
 * possible to precisely coordinate a RenderThread-enabled AnimatedVectorDrawable with UI thread
 * animations. Additionally,
 * {@link android.graphics.drawable.Animatable2.AnimationCallback#onAnimationEnd(Drawable)} will be
 * called the frame after the AnimatedVectorDrawable finishes on the RenderThread.
 * </p>
 * <p>
 * AnimatedVectorDrawable can be defined in either <a href="#ThreeXML">three separate XML files</a>,
 * or <a href="#OneXML">one XML</a>.
 * </p>
 * <a name="ThreeXML"></a>
 * <h3>Define an AnimatedVectorDrawable in three separate XML files</h3>
 * <ul>
 * <a name="VDExample"></a>
 * <li><h4>XML for the VectorDrawable containing properties to be animated</h4>
 * <p>
 * Animations can be performed on the animatable attributes in
 * {@link android.graphics.drawable.VectorDrawable}. These attributes will be animated by
 * {@link android.animation.ObjectAnimator}. The ObjectAnimator's target can be the root element,
 * a group element or a path element. The targeted elements need to be named uniquely within
 * the same VectorDrawable. Elements without animation do not need to be named.
 * </p>
 * <p>
 * Here are all the animatable attributes in {@link android.graphics.drawable.VectorDrawable}:
 * <table border="2" align="center" cellpadding="5">
 *     <thead>
 *         <tr>
 *             <th>Element Name</th>
 *             <th>Animatable attribute name</th>
 *         </tr>
 *     </thead>
 *     <tr>
 *         <td>&lt;vector&gt;</td>
 *         <td>alpha</td>
 *     </tr>
 *     <tr>
 *         <td rowspan="7">&lt;group&gt;</td>
 *         <td>rotation</td>
 *     </tr>
 *     <tr>
 *         <td>pivotX</td>
 *     </tr>
 *     <tr>
 *         <td>pivotY</td>
 *     </tr>
 *     <tr>
 *         <td>scaleX</td>
 *     </tr>
 *     <tr>
 *         <td>scaleY</td>
 *     </tr>
 *     <tr>
 *         <td>translateX</td>
 *     </tr>
 *     <tr>
 *         <td>translateY</td>
 *     </tr>
 *     <tr>
 *         <td rowspan="9">&lt;path&gt;</td>
 *         <td>pathData</td>
 *     </tr>
 *     <tr>
 *         <td>fillColor</td>
 *     </tr>
 *     <tr>
 *         <td>strokeColor</td>
 *     </tr>
 *     <tr>
 *         <td>strokeWidth</td>
 *     </tr>
 *     <tr>
 *         <td>strokeAlpha</td>
 *     </tr>
 *     <tr>
 *         <td>fillAlpha</td>
 *     </tr>
 *     <tr>
 *         <td>trimPathStart</td>
 *     </tr>
 *     <tr>
 *         <td>trimPathEnd</td>
 *     </tr>
 *     <tr>
 *         <td>trimPathOffset</td>
 *     </tr>
 *     <tr>
 *         <td>&lt;clip-path&gt;</td>
 *         <td>pathData</td>
 *     </tr>
 * </table>
 * </p>
 * Below is an example of a VectorDrawable defined in vectordrawable.xml. This VectorDrawable is
 * referred to by its file name (not including file suffix) in the
 * <a href="#AVDExample">AnimatedVectorDrawable XML example</a>.
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
 * </pre></li>
 *
 * <a name="AVDExample"></a>
 * <li><h4>XML for AnimatedVectorDrawable</h4>
 * <p>
 * An AnimatedVectorDrawable element has a VectorDrawable attribute, and one or more target
 * element(s). The target element can specify its target by android:name attribute, and link the
 * target with the proper ObjectAnimator or AnimatorSet by android:animation attribute.
 * </p>
 * The following code sample defines an AnimatedVectorDrawable. Note that the names refer to the
 * groups and paths in the <a href="#VDExample">VectorDrawable XML above</a>.
 * <pre>
 * &lt;animated-vector xmlns:android=&quot;http://schemas.android.com/apk/res/android&quot;
 *     android:drawable=&quot;@drawable/vectordrawable&quot; &gt;
 *     &lt;target
 *         android:name=&quot;rotationGroup&quot;
 *         android:animation=&quot;@animator/rotation&quot; /&gt;
 *     &lt;target
 *         android:name=&quot;v&quot;
 *         android:animation=&quot;@animator/path_morph&quot; /&gt;
 * &lt;/animated-vector&gt;
 * </pre>
 * </li>
 *
 * <li><h4>XML for Animations defined using ObjectAnimator or AnimatorSet</h4>
 * <p>
 * From the previous <a href="#AVDExample">example of AnimatedVectorDrawable</a>, two animations
 * were used: rotation.xml and path_morph.xml.
 * </p>
 * rotation.xml rotates the target group from 0 degree to 360 degrees over 6000ms:
 * <pre>
 * &lt;objectAnimator
 *     android:duration=&quot;6000&quot;
 *     android:propertyName=&quot;rotation&quot;
 *     android:valueFrom=&quot;0&quot;
 *     android:valueTo=&quot;360&quot; /&gt;
 * </pre>
 *
 * path_morph.xml morphs the path from one shape into the other. Note that the paths must be
 * compatible for morphing. Specifically, the paths must have the same commands, in the same order,
 * and must have the same number of parameters for each command. It is recommended to store path
 * strings as string resources for reuse.
 * <pre>
 * &lt;set xmlns:android=&quot;http://schemas.android.com/apk/res/android&quot;&gt;
 *     &lt;objectAnimator
 *         android:duration=&quot;3000&quot;
 *         android:propertyName=&quot;pathData&quot;
 *         android:valueFrom=&quot;M300,70 l 0,-70 70,70 0,0 -70,70z&quot;
 *         android:valueTo=&quot;M300,70 l 0,-70 70,0  0,140 -70,0 z&quot;
 *         android:valueType=&quot;pathType&quot;/&gt;
 * &lt;/set&gt;
 * </pre>
 * </ul>
 * <a name="OneXML"></a>
 * <h3>Define an AnimatedVectorDrawable all in one XML file</h3>
 * <p>
 * Since the AAPT tool supports a new format that bundles several related XML files together, we can
 * merge the XML files from the previous examples into one XML file:
 * </p>
 * <pre>
 * &lt;animated-vector xmlns:android=&quot;http://schemas.android.com/apk/res/android&quot;
 *                  xmlns:aapt=&quothttp://schemas.android.com/aapt&quot; &gt;
 *     &lt;aapt:attr name="android:drawable"&gt;
 *         &lt;vector
 *             android:height=&quot;64dp&quot;
 *             android:width=&quot;64dp&quot;
 *             android:viewportHeight=&quot;600&quot;
 *             android:viewportWidth=&quot;600&quot; &gt;
 *             &lt;group
 *                 android:name=&quot;rotationGroup&quot;
 *                 android:pivotX=&quot;300.0&quot;
 *                 android:pivotY=&quot;300.0&quot;
 *                 android:rotation=&quot;45.0&quot; &gt;
 *                 &lt;path
 *                     android:name=&quot;v&quot;
 *                     android:fillColor=&quot;#000000&quot;
 *                     android:pathData=&quot;M300,70 l 0,-70 70,70 0,0 -70,70z&quot; /&gt;
 *             &lt;/group&gt;
 *         &lt;/vector&gt;
 *     &lt;/aapt:attr&gt;
 *
 *     &lt;target android:name=&quot;rotationGroup&quot;&gt; *
 *         &lt;aapt:attr name="android:animation"&gt;
 *             &lt;objectAnimator
 *             android:duration=&quot;6000&quot;
 *             android:propertyName=&quot;rotation&quot;
 *             android:valueFrom=&quot;0&quot;
 *             android:valueTo=&quot;360&quot; /&gt;
 *         &lt;/aapt:attr&gt;
 *     &lt;/target&gt;
 *
 *     &lt;target android:name=&quot;v&quot; &gt;
 *         &lt;aapt:attr name="android:animation"&gt;
 *             &lt;set&gt;
 *                 &lt;objectAnimator
 *                     android:duration=&quot;3000&quot;
 *                     android:propertyName=&quot;pathData&quot;
 *                     android:valueFrom=&quot;M300,70 l 0,-70 70,70 0,0 -70,70z&quot;
 *                     android:valueTo=&quot;M300,70 l 0,-70 70,0  0,140 -70,0 z&quot;
 *                     android:valueType=&quot;pathType&quot;/&gt;
 *             &lt;/set&gt;
 *         &lt;/aapt:attr&gt;
 *      &lt;/target&gt;
 * &lt;/animated-vector&gt;
 * </pre>
 *
 * @attr ref android.R.styleable#AnimatedVectorDrawable_drawable
 * @attr ref android.R.styleable#AnimatedVectorDrawableTarget_name
 * @attr ref android.R.styleable#AnimatedVectorDrawableTarget_animation
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AnimatedVectorDrawable extends android.graphics.drawable.Drawable implements android.graphics.drawable.Animatable2 {

/** @apiSince 21 */

public AnimatedVectorDrawable() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @apiSince 21
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * Draws the AnimatedVectorDrawable into the given canvas.
 * <p>
 * <strong>Note:</strong> Calling this method with a software canvas when the
 * AnimatedVectorDrawable is being animated on RenderThread (for API 25 and later) may yield
 * outdated result, as the UI thread is not guaranteed to be in sync with RenderThread on
 * VectorDrawable's property changes during RenderThread animations.
 * </p>
 *
 * @param canvas The canvas to draw into
 * @apiSince 21
 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void onBoundsChange(android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected boolean onStateChange(int[] state) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected boolean onLevelChange(int level) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param layoutDirection Value is {@link android.view.View#LAYOUT_DIRECTION_LTR}, or {@link android.view.View#LAYOUT_DIRECTION_RTL}
 * @apiSince 23
 */

public boolean onLayoutDirectionChanged(int layoutDirection) { throw new RuntimeException("Stub!"); }

/**
 * For API 25 and later, AnimatedVectorDrawable runs on RenderThread. Therefore, when the
 * root alpha is being animated, this getter does not guarantee to return an up-to-date alpha
 * value.
 *
 * @return the containing vector drawable's root alpha value.
 * @apiSince 21
 */

public int getAlpha() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setColorFilter(android.graphics.ColorFilter colorFilter) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.graphics.ColorFilter getColorFilter() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setTintList(android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setHotspot(float x, float y) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setHotspotBounds(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param blendMode This value must never be {@code null}.
 * @apiSince 29
 */

public void setTintBlendMode(@androidx.annotation.NonNull android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean setVisible(boolean visible, boolean restart) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean isStateful() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int getOpacity() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int getIntrinsicWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int getIntrinsicHeight() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param outline This value must never be {@code null}.
 * @apiSince 21
 */

public void getOutline(@androidx.annotation.NonNull android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public android.graphics.Insets getOpticalInsets() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void inflate(android.content.res.Resources res, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs, android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void applyTheme(android.content.res.Resources.Theme t) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean isRunning() { throw new RuntimeException("Stub!"); }

/**
 * Resets the AnimatedVectorDrawable to the start state as specified in the animators.
 * @apiSince 23
 */

public void reset() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void start() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void stop() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param callback This value must never be {@code null}.
 * @apiSince 23
 */

public void registerAnimationCallback(@androidx.annotation.NonNull android.graphics.drawable.Animatable2.AnimationCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param callback This value must never be {@code null}.
 * @apiSince 23
 */

public boolean unregisterAnimationCallback(@androidx.annotation.NonNull android.graphics.drawable.Animatable2.AnimationCallback callback) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void clearAnimationCallbacks() { throw new RuntimeException("Stub!"); }
}

