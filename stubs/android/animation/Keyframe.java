/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.animation;


/**
 * This class holds a time/value pair for an animation. The Keyframe class is used
 * by {@link android.animation.ValueAnimator ValueAnimator} to define the values that the animation target will have over the course
 * of the animation. As the time proceeds from one keyframe to the other, the value of the
 * target object will animate between the value at the previous keyframe and the value at the
 * next keyframe. Each keyframe also holds an optional {@link android.animation.TimeInterpolator TimeInterpolator}
 * object, which defines the time interpolation over the intervalue preceding the keyframe.
 *
 * <p>The Keyframe class itself is abstract. The type-specific factory methods will return
 * a subclass of Keyframe specific to the type of value being stored. This is done to improve
 * performance when dealing with the most common cases (e.g., <code>float</code> and
 * <code>int</code> values). Other types will fall into a more general Keyframe class that
 * treats its values as Objects. Unless your animation requires dealing with a custom type
 * or a data structure that needs to be animated directly (and evaluated using an implementation
 * of {@link android.animation.TypeEvaluator TypeEvaluator}), you should stick to using float and int as animations using those
 * types have lower runtime overhead than other types.</p>
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Keyframe implements java.lang.Cloneable {

public Keyframe() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a Keyframe object with the given time and value. The time defines the
 * time, as a proportion of an overall animation's duration, at which the value will hold true
 * for the animation. The value for the animation between keyframes will be calculated as
 * an interpolation between the values at those keyframes.
 *
 * @param fraction The time, expressed as a value between 0 and 1, representing the fraction
 * of time elapsed of the overall animation duration.
 * @param value The value that the object will animate to as the animation time approaches
 * the time in this keyframe, and the value animated from as the time passes the time in
 * this keyframe.
 * @apiSince 11
 */

public static android.animation.Keyframe ofInt(float fraction, int value) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a Keyframe object with the given time. The value at this time will be derived
 * from the target object when the animation first starts (note that this implies that keyframes
 * with no initial value must be used as part of an {@link android.animation.ObjectAnimator ObjectAnimator}).
 * The time defines the
 * time, as a proportion of an overall animation's duration, at which the value will hold true
 * for the animation. The value for the animation between keyframes will be calculated as
 * an interpolation between the values at those keyframes.
 *
 * @param fraction The time, expressed as a value between 0 and 1, representing the fraction
 * of time elapsed of the overall animation duration.
 * @apiSince 11
 */

public static android.animation.Keyframe ofInt(float fraction) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a Keyframe object with the given time and value. The time defines the
 * time, as a proportion of an overall animation's duration, at which the value will hold true
 * for the animation. The value for the animation between keyframes will be calculated as
 * an interpolation between the values at those keyframes.
 *
 * @param fraction The time, expressed as a value between 0 and 1, representing the fraction
 * of time elapsed of the overall animation duration.
 * @param value The value that the object will animate to as the animation time approaches
 * the time in this keyframe, and the value animated from as the time passes the time in
 * this keyframe.
 * @apiSince 11
 */

public static android.animation.Keyframe ofFloat(float fraction, float value) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a Keyframe object with the given time. The value at this time will be derived
 * from the target object when the animation first starts (note that this implies that keyframes
 * with no initial value must be used as part of an {@link android.animation.ObjectAnimator ObjectAnimator}).
 * The time defines the
 * time, as a proportion of an overall animation's duration, at which the value will hold true
 * for the animation. The value for the animation between keyframes will be calculated as
 * an interpolation between the values at those keyframes.
 *
 * @param fraction The time, expressed as a value between 0 and 1, representing the fraction
 * of time elapsed of the overall animation duration.
 * @apiSince 11
 */

public static android.animation.Keyframe ofFloat(float fraction) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a Keyframe object with the given time and value. The time defines the
 * time, as a proportion of an overall animation's duration, at which the value will hold true
 * for the animation. The value for the animation between keyframes will be calculated as
 * an interpolation between the values at those keyframes.
 *
 * @param fraction The time, expressed as a value between 0 and 1, representing the fraction
 * of time elapsed of the overall animation duration.
 * @param value The value that the object will animate to as the animation time approaches
 * the time in this keyframe, and the value animated from as the time passes the time in
 * this keyframe.
 * @apiSince 11
 */

public static android.animation.Keyframe ofObject(float fraction, java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a Keyframe object with the given time. The value at this time will be derived
 * from the target object when the animation first starts (note that this implies that keyframes
 * with no initial value must be used as part of an {@link android.animation.ObjectAnimator ObjectAnimator}).
 * The time defines the
 * time, as a proportion of an overall animation's duration, at which the value will hold true
 * for the animation. The value for the animation between keyframes will be calculated as
 * an interpolation between the values at those keyframes.
 *
 * @param fraction The time, expressed as a value between 0 and 1, representing the fraction
 * of time elapsed of the overall animation duration.
 * @apiSince 11
 */

public static android.animation.Keyframe ofObject(float fraction) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this keyframe has a valid value. This method is called internally when
 * an {@link android.animation.ObjectAnimator ObjectAnimator} first starts; keyframes without values are assigned values at
 * that time by deriving the value for the property from the target object.
 *
 * @return boolean Whether this object has a value assigned.
 * @apiSince 11
 */

public boolean hasValue() { throw new RuntimeException("Stub!"); }

/**
 * Gets the value for this Keyframe.
 *
 * @return The value for this Keyframe.
 * @apiSince 11
 */

public abstract java.lang.Object getValue();

/**
 * Sets the value for this Keyframe.
 *
 * @param value value for this Keyframe.
 * @apiSince 11
 */

public abstract void setValue(java.lang.Object value);

/**
 * Gets the time for this keyframe, as a fraction of the overall animation duration.
 *
 * @return The time associated with this keyframe, as a fraction of the overall animation
 * duration. This should be a value between 0 and 1.
 * @apiSince 11
 */

public float getFraction() { throw new RuntimeException("Stub!"); }

/**
 * Sets the time for this keyframe, as a fraction of the overall animation duration.
 *
 * @param fraction time associated with this keyframe, as a fraction of the overall animation
 * duration. This should be a value between 0 and 1.
 * @apiSince 11
 */

public void setFraction(float fraction) { throw new RuntimeException("Stub!"); }

/**
 * Gets the optional interpolator for this Keyframe. A value of <code>null</code> indicates
 * that there is no interpolation, which is the same as linear interpolation.
 *
 * @return The optional interpolator for this Keyframe.
 * @apiSince 11
 */

public android.animation.TimeInterpolator getInterpolator() { throw new RuntimeException("Stub!"); }

/**
 * Sets the optional interpolator for this Keyframe. A value of <code>null</code> indicates
 * that there is no interpolation, which is the same as linear interpolation.
 *
 * @return The optional interpolator for this Keyframe.
 * @apiSince 11
 */

public void setInterpolator(android.animation.TimeInterpolator interpolator) { throw new RuntimeException("Stub!"); }

/**
 * Gets the type of keyframe. This information is used by ValueAnimator to determine the type of
 * {@link android.animation.TypeEvaluator TypeEvaluator} to use when calculating values between keyframes. The type is based
 * on the type of Keyframe created.
 *
 * @return The type of the value stored in the Keyframe.
 * @apiSince 11
 */

public java.lang.Class getType() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public abstract android.animation.Keyframe clone();
}

