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


/**
 * An object used to create frame-by-frame animations, defined by a series of
 * Drawable objects, which can be used as a View object's background.
 * <p>
 * The simplest way to create a frame-by-frame animation is to define the
 * animation in an XML file, placed in the res/drawable/ folder, and set it as
 * the background to a View object. Then, call {@link #start()} to run the
 * animation.
 * <p>
 * An AnimationDrawable defined in XML consists of a single
 * {@code <animation-list>} element and a series of nested
 * {@code <item>} tags. Each item defines a frame of the animation. See
 * the example below.
 * <p>
 * spin_animation.xml file in res/drawable/ folder:
 * <pre>
 * &lt;!-- Animation frames are wheel0.png through wheel5.png
 *     files inside the res/drawable/ folder --&gt;
 * &lt;animation-list android:id=&quot;@+id/selected&quot; android:oneshot=&quot;false&quot;&gt;
 *    &lt;item android:drawable=&quot;@drawable/wheel0&quot; android:duration=&quot;50&quot; /&gt;
 *    &lt;item android:drawable=&quot;@drawable/wheel1&quot; android:duration=&quot;50&quot; /&gt;
 *    &lt;item android:drawable=&quot;@drawable/wheel2&quot; android:duration=&quot;50&quot; /&gt;
 *    &lt;item android:drawable=&quot;@drawable/wheel3&quot; android:duration=&quot;50&quot; /&gt;
 *    &lt;item android:drawable=&quot;@drawable/wheel4&quot; android:duration=&quot;50&quot; /&gt;
 *    &lt;item android:drawable=&quot;@drawable/wheel5&quot; android:duration=&quot;50&quot; /&gt;
 * &lt;/animation-list&gt;</pre>
 * <p>
 * Here is the code to load and play this animation.
 * <pre>
 * // Load the ImageView that will host the animation and
 * // set its background to our AnimationDrawable XML resource.
 * ImageView img = (ImageView)findViewById(R.id.spinning_wheel_image);
 * img.setBackgroundResource(R.drawable.spin_animation);
 *
 * // Get the background, which has been compiled to an AnimationDrawable object.
 * AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
 *
 * // Start the animation (looped playback by default).
 * frameAnimation.start();
 * </pre>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about animating with {@code AnimationDrawable}, read the
 * <a href="{@docRoot}guide/topics/graphics/drawable-animation.html">Drawable Animation</a>
 * developer guide.</p>
 * </div>
 *
 * @attr ref android.R.styleable#AnimationDrawable_visible
 * @attr ref android.R.styleable#AnimationDrawable_variablePadding
 * @attr ref android.R.styleable#AnimationDrawable_oneshot
 * @attr ref android.R.styleable#AnimationDrawableItem_duration
 * @attr ref android.R.styleable#AnimationDrawableItem_drawable
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AnimationDrawable extends android.graphics.drawable.DrawableContainer implements java.lang.Runnable, android.graphics.drawable.Animatable {

/** @apiSince 1 */

public AnimationDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this AnimationDrawable is visible.
 * <p>
 * When the drawable becomes invisible, it will pause its animation. A subsequent change to
 * visible with <code>restart</code> set to true will restart the animation from the
 * first frame. If <code>restart</code> is false, the drawable will resume from the most recent
 * frame. If the drawable has already reached the last frame, it will then loop back to the
 * first frame, unless it's a one shot drawable (set through {@link #setOneShot(boolean)}),
 * in which case, it will stay on the last frame.
 *
 * @param visible true if visible, false otherwise
 * @param restart when visible, true to force the animation to restart
 *                from the first frame
 * @return true if the new visibility is different than its previous state
 * @apiSince 1
 */

public boolean setVisible(boolean visible, boolean restart) { throw new RuntimeException("Stub!"); }

/**
 * Starts the animation from the first frame, looping if necessary. This method has no effect
 * if the animation is running.
 * <p>
 * <strong>Note:</strong> Do not call this in the
 * {@link android.app.Activity#onCreate} method of your activity, because
 * the {@link android.graphics.drawable.AnimationDrawable AnimationDrawable} is not yet fully attached to the window.
 * If you want to play the animation immediately without requiring
 * interaction, then you might want to call it from the
 * {@link android.app.Activity#onWindowFocusChanged} method in your
 * activity, which will get called when Android brings your window into
 * focus.
 *
 * @see #isRunning()
 * @see #stop()
 * @apiSince 1
 */

public void start() { throw new RuntimeException("Stub!"); }

/**
 * Stops the animation at the current frame. This method has no effect if the animation is not
 * running.
 *
 * @see #isRunning()
 * @see #start()
 * @apiSince 1
 */

public void stop() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the animation is currently running or not.
 *
 * @return true if the animation is running, false otherwise
 * @apiSince 1
 */

public boolean isRunning() { throw new RuntimeException("Stub!"); }

/**
 * This method exists for implementation purpose only and should not be
 * called directly. Invoke {@link #start()} instead.
 *
 * @see #start()
 * @apiSince 1
 */

public void run() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void unscheduleSelf(java.lang.Runnable what) { throw new RuntimeException("Stub!"); }

/**
 * @return The number of frames in the animation
 * @apiSince 1
 */

public int getNumberOfFrames() { throw new RuntimeException("Stub!"); }

/**
 * @return The Drawable at the specified frame index
 * @apiSince 1
 */

public android.graphics.drawable.Drawable getFrame(int index) { throw new RuntimeException("Stub!"); }

/**
 * @return The duration in milliseconds of the frame at the
 *         specified index
 * @apiSince 1
 */

public int getDuration(int i) { throw new RuntimeException("Stub!"); }

/**
 * @return True of the animation will play once, false otherwise
 * @apiSince 1
 */

public boolean isOneShot() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the animation should play once or repeat.
 *
 * @param oneShot Pass true if the animation should only play once
 * @apiSince 1
 */

public void setOneShot(boolean oneShot) { throw new RuntimeException("Stub!"); }

/**
 * Adds a frame to the animation
 *
 * @param frame The frame to add
 * This value must never be {@code null}.
 * @param duration How long in milliseconds the frame should appear
 * @apiSince 1
 */

public void addFrame(@androidx.annotation.NonNull android.graphics.drawable.Drawable frame, int duration) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void inflate(android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs, android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value will never be {@code null}.
 * @apiSince 3
 */

@androidx.annotation.NonNull
public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param state This value must never be {@code null}.
 * @apiSince 1
 */

protected void setConstantState(@androidx.annotation.NonNull android.graphics.drawable.DrawableContainer.DrawableContainerState state) { throw new RuntimeException("Stub!"); }
}

