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


package android.view.animation;

import android.os.Build;

/**
 * Represents a group of Animations that should be played together.
 * The transformation of each individual animation are composed
 * together into a single transform.
 * If AnimationSet sets any properties that its children also set
 * (for example, duration or fillBefore), the values of AnimationSet
 * override the child values.
 *
 * <p>The way that AnimationSet inherits behavior from Animation is important to
 * understand. Some of the Animation attributes applied to AnimationSet affect the
 * AnimationSet itself, some are pushed down to the children, and some are ignored,
 * as follows:
 * <ul>
 *     <li>duration, repeatMode, fillBefore, fillAfter: These properties, when set
 *     on an AnimationSet object, will be pushed down to all child animations.</li>
 *     <li>repeatCount, fillEnabled: These properties are ignored for AnimationSet.</li>
 *     <li>startOffset, shareInterpolator: These properties apply to the AnimationSet itself.</li>
 * </ul>
 * Starting with {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH},
 * the behavior of these properties is the same in XML resources and at runtime (prior to that
 * release, the values set in XML were ignored for AnimationSet). That is, calling
 * <code>setDuration(500)</code> on an AnimationSet has the same effect as declaring
 * <code>android:duration="500"</code> in an XML resource for an AnimationSet object.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AnimationSet extends android.view.animation.Animation {

/**
 * Constructor used when an AnimationSet is loaded from a resource.
 *
 * @param context Application context to use
 * @param attrs Attribute set from which to read values
 * @apiSince 1
 */

public AnimationSet(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Constructor to use when building an AnimationSet from code
 *
 * @param shareInterpolator Pass true if all of the animations in this set
 *        should use the interpolator associated with this AnimationSet.
 *        Pass false if each animation should use its own interpolator.
 * @apiSince 1
 */

public AnimationSet(boolean shareInterpolator) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected android.view.animation.AnimationSet clone() throws java.lang.CloneNotSupportedException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setFillAfter(boolean fillAfter) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setFillBefore(boolean fillBefore) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setRepeatMode(int repeatMode) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setStartOffset(long startOffset) { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the duration of every child animation.</p>
 *
 * @param durationMillis the duration of the animation, in milliseconds, for
 *        every child in this set
 * @apiSince 1
 */

public void setDuration(long durationMillis) { throw new RuntimeException("Stub!"); }

/**
 * Add a child animation to this animation set.
 * The transforms of the child animations are applied in the order
 * that they were added
 * @param a Animation to add.
 * @apiSince 1
 */

public void addAnimation(android.view.animation.Animation a) { throw new RuntimeException("Stub!"); }

/**
 * Sets the start time of this animation and all child animations
 *
 * @see android.view.animation.Animation#setStartTime(long)
 * @apiSince 1
 */

public void setStartTime(long startTimeMillis) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public long getStartTime() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void restrictDuration(long durationMillis) { throw new RuntimeException("Stub!"); }

/**
 * The duration of an AnimationSet is defined to be the
 * duration of the longest child animation.
 *
 * @see android.view.animation.Animation#getDuration()
 * @apiSince 1
 */

public long getDuration() { throw new RuntimeException("Stub!"); }

/**
 * The duration hint of an animation set is the maximum of the duration
 * hints of all of its component animations.
 *
 * @see android.view.animation.Animation#computeDurationHint
 * @apiSince 3
 */

public long computeDurationHint() { throw new RuntimeException("Stub!"); }

/**
 * The transformation of an animation set is the concatenation of all of its
 * component animations.
 *
 * @see android.view.animation.Animation#getTransformation
 * @apiSince 1
 */

public boolean getTransformation(long currentTime, android.view.animation.Transformation t) { throw new RuntimeException("Stub!"); }

/**
 * @see android.view.animation.Animation#scaleCurrentDuration(float)
 * @apiSince 1
 */

public void scaleCurrentDuration(float scale) { throw new RuntimeException("Stub!"); }

/**
 * @see android.view.animation.Animation#initialize(int, int, int, int)
 * @apiSince 1
 */

public void initialize(int width, int height, int parentWidth, int parentHeight) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void reset() { throw new RuntimeException("Stub!"); }

/**
 * @return All the child animations in this AnimationSet. Note that
 * this may include other AnimationSets, which are not expanded.
 * @apiSince 1
 */

public java.util.List<android.view.animation.Animation> getAnimations() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean willChangeTransformationMatrix() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean willChangeBounds() { throw new RuntimeException("Stub!"); }
}

