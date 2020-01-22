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

import android.view.animation.AccelerateDecelerateInterpolator;
import android.util.Property;
import android.graphics.Path;
import android.graphics.PointF;

/**
 * This subclass of {@link android.animation.ValueAnimator ValueAnimator} provides support for animating properties on target objects.
 * The constructors of this class take parameters to define the target object that will be animated
 * as well as the name of the property that will be animated. Appropriate set/get functions
 * are then determined internally and the animation will call these functions as necessary to
 * animate the property.
 *
 * <p>Animators can be created from either code or resource files, as shown here:</p>
 *
 * {@sample development/samples/ApiDemos/res/anim/object_animator.xml ObjectAnimatorResources}
 *
 * <p>Starting from API 23, it is possible to use {@link android.animation.PropertyValuesHolder PropertyValuesHolder} and
 * {@link android.animation.Keyframe Keyframe} in resource files to create more complex animations. Using PropertyValuesHolders
 * allows animators to animate several properties in parallel, as shown in this sample:</p>
 *
 * {@sample development/samples/ApiDemos/res/anim/object_animator_pvh.xml
 * PropertyValuesHolderResources}
 *
 * <p>Using Keyframes allows animations to follow more complex paths from the start
 * to the end values. Note that you can specify explicit fractional values (from 0 to 1) for
 * each keyframe to determine when, in the overall duration, the animation should arrive at that
 * value. Alternatively, you can leave the fractions off and the keyframes will be equally
 * distributed within the total duration. Also, a keyframe with no value will derive its value
 * from the target object when the animator starts, just like animators with only one
 * value specified. In addition, an optional interpolator can be specified. The interpolator will
 * be applied on the interval between the keyframe that the interpolator is set on and the previous
 * keyframe. When no interpolator is supplied, the default {@link android.view.animation.AccelerateDecelerateInterpolator AccelerateDecelerateInterpolator}
 * will be used. </p>
 *
 * {@sample development/samples/ApiDemos/res/anim/object_animator_pvh_kf_interpolated.xml KeyframeResources}
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about animating with {@code ObjectAnimator}, read the
 * <a href="{@docRoot}guide/topics/graphics/prop-animation.html#object-animator">Property
 * Animation</a> developer guide.</p>
 * </div>
 *
 * @see #setPropertyName(String)
 *
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ObjectAnimator extends android.animation.ValueAnimator {

/**
 * Creates a new ObjectAnimator object. This default constructor is primarily for
 * use internally; the other constructors which take parameters are more generally
 * useful.
 * @apiSince 11
 */

public ObjectAnimator() { throw new RuntimeException("Stub!"); }

/**
 * Sets the name of the property that will be animated. This name is used to derive
 * a setter function that will be called to set animated values.
 * For example, a property name of <code>foo</code> will result
 * in a call to the function <code>setFoo()</code> on the target object. If either
 * <code>valueFrom</code> or <code>valueTo</code> is null, then a getter function will
 * also be derived and called.
 *
 * <p>For best performance of the mechanism that calls the setter function determined by the
 * name of the property being animated, use <code>float</code> or <code>int</code> typed values,
 * and make the setter function for those properties have a <code>void</code> return value. This
 * will cause the code to take an optimized path for these constrained circumstances. Other
 * property types and return types will work, but will have more overhead in processing
 * the requests due to normal reflection mechanisms.</p>
 *
 * <p>Note that the setter function derived from this property name
 * must take the same parameter type as the
 * <code>valueFrom</code> and <code>valueTo</code> properties, otherwise the call to
 * the setter function will fail.</p>
 *
 * <p>If this ObjectAnimator has been set up to animate several properties together,
 * using more than one PropertyValuesHolder objects, then setting the propertyName simply
 * sets the propertyName in the first of those PropertyValuesHolder objects.</p>
 *
 * @param propertyName The name of the property being animated. Should not be null.
 
 * This value must never be {@code null}.
 * @apiSince 11
 */

public void setPropertyName(@androidx.annotation.NonNull java.lang.String propertyName) { throw new RuntimeException("Stub!"); }

/**
 * Sets the property that will be animated. Property objects will take precedence over
 * properties specified by the {@link #setPropertyName(java.lang.String)} method. Animations should
 * be set up to use one or the other, not both.
 *
 * @param property The property being animated. Should not be null.
 
 * This value must never be {@code null}.
 * @apiSince 14
 */

public void setProperty(@androidx.annotation.NonNull android.util.Property property) { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of the property that will be animated. This name will be used to derive
 * a setter function that will be called to set animated values.
 * For example, a property name of <code>foo</code> will result
 * in a call to the function <code>setFoo()</code> on the target object. If either
 * <code>valueFrom</code> or <code>valueTo</code> is null, then a getter function will
 * also be derived and called.
 *
 * <p>If this animator was created with a {@link android.util.Property Property} object instead of the
 * string name of a property, then this method will return the {@link android.util.Property#getName() Property#getName()} of that Property object instead. If this animator was
 * created with one or more {@link android.animation.PropertyValuesHolder PropertyValuesHolder} objects, then this method
 * will return the {@link android.animation.PropertyValuesHolder#getPropertyName() PropertyValuesHolder#getPropertyName()} of that
 * object (if there was just one) or a comma-separated list of all of the
 * names (if there are more than one).</p>
 * @apiSince 11
 */

@androidx.annotation.Nullable
public java.lang.String getPropertyName() { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates between int values. A single
 * value implies that that value is the one being animated to, in which case the start value
 * will be derived from the property being animated and the target object when {@link #start()}
 * is called for the first time. Two values imply starting and ending values. More than two
 * values imply a starting value, values to animate through along the way, and an ending value
 * (these values will be distributed evenly across the duration of the animation).
 *
 * @param target The object whose property is to be animated. This object should
 * have a public method on it called <code>setName()</code>, where <code>name</code> is
 * the value of the <code>propertyName</code> parameter.
 * @param propertyName The name of the property being animated.
 * @param values A set of values that the animation will animate between over time.
 * @return An ObjectAnimator object that is set up to animate between the given values.
 * @apiSince 11
 */

public static android.animation.ObjectAnimator ofInt(java.lang.Object target, java.lang.String propertyName, int... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates coordinates along a <code>Path</code>
 * using two properties. A <code>Path</code></> animation moves in two dimensions, animating
 * coordinates <code>(x, y)</code> together to follow the line. In this variation, the
 * coordinates are integers that are set to separate properties designated by
 * <code>xPropertyName</code> and <code>yPropertyName</code>.
 *
 * @param target The object whose properties are to be animated. This object should
 *               have public methods on it called <code>setNameX()</code> and
 *               <code>setNameY</code>, where <code>nameX</code> and <code>nameY</code>
 *               are the value of <code>xPropertyName</code> and <code>yPropertyName</code>
 *               parameters, respectively.
 * @param xPropertyName The name of the property for the x coordinate being animated.
 * @param yPropertyName The name of the property for the y coordinate being animated.
 * @param path The <code>Path</code> to animate values along.
 * @return An ObjectAnimator object that is set up to animate along <code>path</code>.
 * @apiSince 21
 */

public static android.animation.ObjectAnimator ofInt(java.lang.Object target, java.lang.String xPropertyName, java.lang.String yPropertyName, android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates between int values. A single
 * value implies that that value is the one being animated to, in which case the start value
 * will be derived from the property being animated and the target object when {@link #start()}
 * is called for the first time. Two values imply starting and ending values. More than two
 * values imply a starting value, values to animate through along the way, and an ending value
 * (these values will be distributed evenly across the duration of the animation).
 *
 * @param target The object whose property is to be animated.
 * @param property The property being animated.
 * @param values A set of values that the animation will animate between over time.
 * @return An ObjectAnimator object that is set up to animate between the given values.
 * @apiSince 14
 */

public static <T> android.animation.ObjectAnimator ofInt(T target, android.util.Property<T,java.lang.Integer> property, int... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates coordinates along a <code>Path</code>
 * using two properties.  A <code>Path</code></> animation moves in two dimensions, animating
 * coordinates <code>(x, y)</code> together to follow the line. In this variation, the
 * coordinates are integers that are set to separate properties, <code>xProperty</code> and
 * <code>yProperty</code>.
 *
 * @param target The object whose properties are to be animated.
 * @param xProperty The property for the x coordinate being animated.
 * @param yProperty The property for the y coordinate being animated.
 * @param path The <code>Path</code> to animate values along.
 * @return An ObjectAnimator object that is set up to animate along <code>path</code>.
 * @apiSince 21
 */

public static <T> android.animation.ObjectAnimator ofInt(T target, android.util.Property<T,java.lang.Integer> xProperty, android.util.Property<T,java.lang.Integer> yProperty, android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates over int values for a multiple
 * parameters setter. Only public methods that take only int parameters are supported.
 * Each <code>int[]</code> contains a complete set of parameters to the setter method.
 * At least two <code>int[]</code> values must be provided, a start and end. More than two
 * values imply a starting value, values to animate through along the way, and an ending
 * value (these values will be distributed evenly across the duration of the animation).
 *
 * @param target The object whose property is to be animated. This object may
 * have a public method on it called <code>setName()</code>, where <code>name</code> is
 * the value of the <code>propertyName</code> parameter. <code>propertyName</code> may also
 * be the case-sensitive complete name of the public setter method.
 * @param propertyName The name of the property being animated or the name of the setter method.
 * @param values A set of values that the animation will animate between over time.
 * @return An ObjectAnimator object that is set up to animate between the given values.
 * @apiSince 21
 */

public static android.animation.ObjectAnimator ofMultiInt(java.lang.Object target, java.lang.String propertyName, int[][] values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates the target using a multi-int setter
 * along the given <code>Path</code>. A <code>Path</code></> animation moves in two dimensions,
 * animating coordinates <code>(x, y)</code> together to follow the line. In this variation, the
 * coordinates are integer x and y coordinates used in the first and second parameter of the
 * setter, respectively.
 *
 * @param target The object whose property is to be animated. This object may
 * have a public method on it called <code>setName()</code>, where <code>name</code> is
 * the value of the <code>propertyName</code> parameter. <code>propertyName</code> may also
 * be the case-sensitive complete name of the public setter method.
 * @param propertyName The name of the property being animated or the name of the setter method.
 * @param path The <code>Path</code> to animate values along.
 * @return An ObjectAnimator object that is set up to animate along <code>path</code>.
 * @apiSince 21
 */

public static android.animation.ObjectAnimator ofMultiInt(java.lang.Object target, java.lang.String propertyName, android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates over values for a multiple int
 * parameters setter. Only public methods that take only int parameters are supported.
 * <p>At least two values must be provided, a start and end. More than two
 * values imply a starting value, values to animate through along the way, and an ending
 * value (these values will be distributed evenly across the duration of the animation).</p>
 *
 * @param target The object whose property is to be animated. This object may
 * have a public method on it called <code>setName()</code>, where <code>name</code> is
 * the value of the <code>propertyName</code> parameter. <code>propertyName</code> may also
 * be the case-sensitive complete name of the public setter method.
 * @param propertyName The name of the property being animated or the name of the setter method.
 * @param converter Converts T objects into int parameters for the multi-value setter.
 * @param evaluator A TypeEvaluator that will be called on each animation frame to
 * provide the necessary interpolation between the Object values to derive the animated
 * value.
 * @param values A set of values that the animation will animate between over time.
 * @return An ObjectAnimator object that is set up to animate between the given values.
 * @apiSince 21
 */

@java.lang.SafeVarargs
public static <T> android.animation.ObjectAnimator ofMultiInt(java.lang.Object target, java.lang.String propertyName, android.animation.TypeConverter<T,int[]> converter, android.animation.TypeEvaluator<T> evaluator, T... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates between color values. A single
 * value implies that that value is the one being animated to, in which case the start value
 * will be derived from the property being animated and the target object when {@link #start()}
 * is called for the first time. Two values imply starting and ending values. More than two
 * values imply a starting value, values to animate through along the way, and an ending value
 * (these values will be distributed evenly across the duration of the animation).
 *
 * @param target The object whose property is to be animated. This object should
 * have a public method on it called <code>setName()</code>, where <code>name</code> is
 * the value of the <code>propertyName</code> parameter.
 * @param propertyName The name of the property being animated.
 * @param values A set of values that the animation will animate between over time.
 * @return An ObjectAnimator object that is set up to animate between the given values.
 * @apiSince 21
 */

public static android.animation.ObjectAnimator ofArgb(java.lang.Object target, java.lang.String propertyName, int... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates between color values. A single
 * value implies that that value is the one being animated to, in which case the start value
 * will be derived from the property being animated and the target object when {@link #start()}
 * is called for the first time. Two values imply starting and ending values. More than two
 * values imply a starting value, values to animate through along the way, and an ending value
 * (these values will be distributed evenly across the duration of the animation).
 *
 * @param target The object whose property is to be animated.
 * @param property The property being animated.
 * @param values A set of values that the animation will animate between over time.
 * @return An ObjectAnimator object that is set up to animate between the given values.
 * @apiSince 21
 */

public static <T> android.animation.ObjectAnimator ofArgb(T target, android.util.Property<T,java.lang.Integer> property, int... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates between float values. A single
 * value implies that that value is the one being animated to, in which case the start value
 * will be derived from the property being animated and the target object when {@link #start()}
 * is called for the first time. Two values imply starting and ending values. More than two
 * values imply a starting value, values to animate through along the way, and an ending value
 * (these values will be distributed evenly across the duration of the animation).
 *
 * @param target The object whose property is to be animated. This object should
 * have a public method on it called <code>setName()</code>, where <code>name</code> is
 * the value of the <code>propertyName</code> parameter.
 * @param propertyName The name of the property being animated.
 * @param values A set of values that the animation will animate between over time.
 * @return An ObjectAnimator object that is set up to animate between the given values.
 * @apiSince 11
 */

public static android.animation.ObjectAnimator ofFloat(java.lang.Object target, java.lang.String propertyName, float... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates coordinates along a <code>Path</code>
 * using two properties. A <code>Path</code></> animation moves in two dimensions, animating
 * coordinates <code>(x, y)</code> together to follow the line. In this variation, the
 * coordinates are floats that are set to separate properties designated by
 * <code>xPropertyName</code> and <code>yPropertyName</code>.
 *
 * @param target The object whose properties are to be animated. This object should
 *               have public methods on it called <code>setNameX()</code> and
 *               <code>setNameY</code>, where <code>nameX</code> and <code>nameY</code>
 *               are the value of the <code>xPropertyName</code> and <code>yPropertyName</code>
 *               parameters, respectively.
 * @param xPropertyName The name of the property for the x coordinate being animated.
 * @param yPropertyName The name of the property for the y coordinate being animated.
 * @param path The <code>Path</code> to animate values along.
 * @return An ObjectAnimator object that is set up to animate along <code>path</code>.
 * @apiSince 21
 */

public static android.animation.ObjectAnimator ofFloat(java.lang.Object target, java.lang.String xPropertyName, java.lang.String yPropertyName, android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates between float values. A single
 * value implies that that value is the one being animated to, in which case the start value
 * will be derived from the property being animated and the target object when {@link #start()}
 * is called for the first time. Two values imply starting and ending values. More than two
 * values imply a starting value, values to animate through along the way, and an ending value
 * (these values will be distributed evenly across the duration of the animation).
 *
 * @param target The object whose property is to be animated.
 * @param property The property being animated.
 * @param values A set of values that the animation will animate between over time.
 * @return An ObjectAnimator object that is set up to animate between the given values.
 * @apiSince 14
 */

public static <T> android.animation.ObjectAnimator ofFloat(T target, android.util.Property<T,java.lang.Float> property, float... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates coordinates along a <code>Path</code>
 * using two properties. A <code>Path</code></> animation moves in two dimensions, animating
 * coordinates <code>(x, y)</code> together to follow the line. In this variation, the
 * coordinates are floats that are set to separate properties, <code>xProperty</code> and
 * <code>yProperty</code>.
 *
 * @param target The object whose properties are to be animated.
 * @param xProperty The property for the x coordinate being animated.
 * @param yProperty The property for the y coordinate being animated.
 * @param path The <code>Path</code> to animate values along.
 * @return An ObjectAnimator object that is set up to animate along <code>path</code>.
 * @apiSince 21
 */

public static <T> android.animation.ObjectAnimator ofFloat(T target, android.util.Property<T,java.lang.Float> xProperty, android.util.Property<T,java.lang.Float> yProperty, android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates over float values for a multiple
 * parameters setter. Only public methods that take only float parameters are supported.
 * Each <code>float[]</code> contains a complete set of parameters to the setter method.
 * At least two <code>float[]</code> values must be provided, a start and end. More than two
 * values imply a starting value, values to animate through along the way, and an ending
 * value (these values will be distributed evenly across the duration of the animation).
 *
 * @param target The object whose property is to be animated. This object may
 * have a public method on it called <code>setName()</code>, where <code>name</code> is
 * the value of the <code>propertyName</code> parameter. <code>propertyName</code> may also
 * be the case-sensitive complete name of the public setter method.
 * @param propertyName The name of the property being animated or the name of the setter method.
 * @param values A set of values that the animation will animate between over time.
 * @return An ObjectAnimator object that is set up to animate between the given values.
 * @apiSince 21
 */

public static android.animation.ObjectAnimator ofMultiFloat(java.lang.Object target, java.lang.String propertyName, float[][] values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates the target using a multi-float setter
 * along the given <code>Path</code>. A <code>Path</code></> animation moves in two dimensions,
 * animating coordinates <code>(x, y)</code> together to follow the line. In this variation, the
 * coordinates are float x and y coordinates used in the first and second parameter of the
 * setter, respectively.
 *
 * @param target The object whose property is to be animated. This object may
 * have a public method on it called <code>setName()</code>, where <code>name</code> is
 * the value of the <code>propertyName</code> parameter. <code>propertyName</code> may also
 * be the case-sensitive complete name of the public setter method.
 * @param propertyName The name of the property being animated or the name of the setter method.
 * @param path The <code>Path</code> to animate values along.
 * @return An ObjectAnimator object that is set up to animate along <code>path</code>.
 * @apiSince 21
 */

public static android.animation.ObjectAnimator ofMultiFloat(java.lang.Object target, java.lang.String propertyName, android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates over values for a multiple float
 * parameters setter. Only public methods that take only float parameters are supported.
 * <p>At least two values must be provided, a start and end. More than two
 * values imply a starting value, values to animate through along the way, and an ending
 * value (these values will be distributed evenly across the duration of the animation).</p>
 *
 * @param target The object whose property is to be animated. This object may
 * have a public method on it called <code>setName()</code>, where <code>name</code> is
 * the value of the <code>propertyName</code> parameter. <code>propertyName</code> may also
 * be the case-sensitive complete name of the public setter method.
 * @param propertyName The name of the property being animated or the name of the setter method.
 * @param converter Converts T objects into float parameters for the multi-value setter.
 * @param evaluator A TypeEvaluator that will be called on each animation frame to
 * provide the necessary interpolation between the Object values to derive the animated
 * value.
 * @param values A set of values that the animation will animate between over time.
 * @return An ObjectAnimator object that is set up to animate between the given values.
 * @apiSince 21
 */

@java.lang.SafeVarargs
public static <T> android.animation.ObjectAnimator ofMultiFloat(java.lang.Object target, java.lang.String propertyName, android.animation.TypeConverter<T,float[]> converter, android.animation.TypeEvaluator<T> evaluator, T... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates between Object values. A single
 * value implies that that value is the one being animated to, in which case the start value
 * will be derived from the property being animated and the target object when {@link #start()}
 * is called for the first time. Two values imply starting and ending values. More than two
 * values imply a starting value, values to animate through along the way, and an ending value
 * (these values will be distributed evenly across the duration of the animation).
 *
 * <p><strong>Note:</strong> The values are stored as references to the original
 * objects, which means that changes to those objects after this method is called will
 * affect the values on the animator. If the objects will be mutated externally after
 * this method is called, callers should pass a copy of those objects instead.
 *
 * @param target The object whose property is to be animated. This object should
 * have a public method on it called <code>setName()</code>, where <code>name</code> is
 * the value of the <code>propertyName</code> parameter.
 * @param propertyName The name of the property being animated.
 * @param evaluator A TypeEvaluator that will be called on each animation frame to
 * provide the necessary interpolation between the Object values to derive the animated
 * value.
 * @param values A set of values that the animation will animate between over time.
 * @return An ObjectAnimator object that is set up to animate between the given values.
 * @apiSince 11
 */

public static android.animation.ObjectAnimator ofObject(java.lang.Object target, java.lang.String propertyName, android.animation.TypeEvaluator evaluator, java.lang.Object... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates a property along a <code>Path</code>.
 * A <code>Path</code></> animation moves in two dimensions, animating coordinates
 * <code>(x, y)</code> together to follow the line. This variant animates the coordinates
 * in a <code>PointF</code> to follow the <code>Path</code>. If the <code>Property</code>
 * associated with <code>propertyName</code> uses a type other than <code>PointF</code>,
 * <code>converter</code> can be used to change from <code>PointF</code> to the type
 * associated with the <code>Property</code>.
 *
 * @param target The object whose property is to be animated. This object should
 * have a public method on it called <code>setName()</code>, where <code>name</code> is
 * the value of the <code>propertyName</code> parameter.
 * @param propertyName The name of the property being animated.
 * @param converter Converts a PointF to the type associated with the setter. May be
 *                  null if conversion is unnecessary.
 * This value may be {@code null}.
 * @param path The <code>Path</code> to animate values along.
 * @return An ObjectAnimator object that is set up to animate along <code>path</code>.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public static android.animation.ObjectAnimator ofObject(java.lang.Object target, java.lang.String propertyName, @androidx.annotation.Nullable android.animation.TypeConverter<android.graphics.PointF,?> converter, android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates between Object values. A single
 * value implies that that value is the one being animated to, in which case the start value
 * will be derived from the property being animated and the target object when {@link #start()}
 * is called for the first time. Two values imply starting and ending values. More than two
 * values imply a starting value, values to animate through along the way, and an ending value
 * (these values will be distributed evenly across the duration of the animation).
 *
 * <p><strong>Note:</strong> The values are stored as references to the original
 * objects, which means that changes to those objects after this method is called will
 * affect the values on the animator. If the objects will be mutated externally after
 * this method is called, callers should pass a copy of those objects instead.
 *
 * @param target The object whose property is to be animated.
 * @param property The property being animated.
 * @param evaluator A TypeEvaluator that will be called on each animation frame to
 * provide the necessary interpolation between the Object values to derive the animated
 * value.
 * @param values A set of values that the animation will animate between over time.
 * @return An ObjectAnimator object that is set up to animate between the given values.
 
 * This value will never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.NonNull
@java.lang.SafeVarargs
public static <T, V> android.animation.ObjectAnimator ofObject(T target, android.util.Property<T,V> property, android.animation.TypeEvaluator<V> evaluator, V... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates between Object values. A single
 * value implies that that value is the one being animated to, in which case the start value
 * will be derived from the property being animated and the target object when {@link #start()}
 * is called for the first time. Two values imply starting and ending values. More than two
 * values imply a starting value, values to animate through along the way, and an ending value
 * (these values will be distributed evenly across the duration of the animation).
 * This variant supplies a <code>TypeConverter</code> to convert from the animated values to the
 * type of the property. If only one value is supplied, the <code>TypeConverter</code> must be a
 * {@link android.animation.BidirectionalTypeConverter} to retrieve the current value.
 *
 * <p><strong>Note:</strong> The values are stored as references to the original
 * objects, which means that changes to those objects after this method is called will
 * affect the values on the animator. If the objects will be mutated externally after
 * this method is called, callers should pass a copy of those objects instead.
 *
 * @param target The object whose property is to be animated.
 * @param property The property being animated.
 * @param converter Converts the animated object to the Property type.
 * @param evaluator A TypeEvaluator that will be called on each animation frame to
 * provide the necessary interpolation between the Object values to derive the animated
 * value.
 * @param values A set of values that the animation will animate between over time.
 * @return An ObjectAnimator object that is set up to animate between the given values.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
@java.lang.SafeVarargs
public static <T, V, P> android.animation.ObjectAnimator ofObject(T target, android.util.Property<T,P> property, android.animation.TypeConverter<V,P> converter, android.animation.TypeEvaluator<V> evaluator, V... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates a property along a <code>Path</code>.
 * A <code>Path</code></> animation moves in two dimensions, animating coordinates
 * <code>(x, y)</code> together to follow the line. This variant animates the coordinates
 * in a <code>PointF</code> to follow the <code>Path</code>. If <code>property</code>
 * uses a type other than <code>PointF</code>, <code>converter</code> can be used to change
 * from <code>PointF</code> to the type associated with the <code>Property</code>.
 *
 * <p>The PointF passed to <code>converter</code> or <code>property</code>, if
 * <code>converter</code> is <code>null</code>, is reused on each animation frame and should
 * not be stored by the setter or TypeConverter.</p>
 *
 * @param target The object whose property is to be animated.
 * @param property The property being animated. Should not be null.
 * This value must never be {@code null}.
 * @param converter Converts a PointF to the type associated with the setter. May be
 *                  null if conversion is unnecessary.
 * This value may be {@code null}.
 * @param path The <code>Path</code> to animate values along.
 * @return An ObjectAnimator object that is set up to animate along <code>path</code>.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public static <T, V> android.animation.ObjectAnimator ofObject(T target, @androidx.annotation.NonNull android.util.Property<T,V> property, @androidx.annotation.Nullable android.animation.TypeConverter<android.graphics.PointF,V> converter, android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns an ObjectAnimator that animates between the sets of values specified
 * in <code>PropertyValueHolder</code> objects. This variant should be used when animating
 * several properties at once with the same ObjectAnimator, since PropertyValuesHolder allows
 * you to associate a set of animation values with a property name.
 *
 * @param target The object whose property is to be animated. Depending on how the
 * PropertyValuesObjects were constructed, the target object should either have the {@link
 * android.util.Property} objects used to construct the PropertyValuesHolder objects or (if the
 * PropertyValuesHOlder objects were created with property names) the target object should have
 * public methods on it called <code>setName()</code>, where <code>name</code> is the name of
 * the property passed in as the <code>propertyName</code> parameter for each of the
 * PropertyValuesHolder objects.
 * @param values A set of PropertyValuesHolder objects whose values will be animated between
 * over time.
 * @return An ObjectAnimator object that is set up to animate between the given values.
 
 * This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public static android.animation.ObjectAnimator ofPropertyValuesHolder(java.lang.Object target, android.animation.PropertyValuesHolder... values) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void setIntValues(int... values) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void setFloatValues(float... values) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void setObjectValues(java.lang.Object... values) { throw new RuntimeException("Stub!"); }

/**
 * autoCancel controls whether an ObjectAnimator will be canceled automatically
 * when any other ObjectAnimator with the same target and properties is started.
 * Setting this flag may make it easier to run different animators on the same target
 * object without having to keep track of whether there are conflicting animators that
 * need to be manually canceled. Canceling animators must have the same exact set of
 * target properties, in the same order.
 *
 * @param cancel Whether future ObjectAnimators with the same target and properties
 * as this ObjectAnimator will cause this ObjectAnimator to be canceled.
 * @apiSince 18
 */

public void setAutoCancel(boolean cancel) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void start() { throw new RuntimeException("Stub!"); }

/**
 * Sets the length of the animation. The default duration is 300 milliseconds.
 *
 * @param duration The length of the animation, in milliseconds.
 * @return ObjectAnimator The object called with setDuration(). This return
 * value makes it easier to compose statements together that construct and then set the
 * duration, as in
 * <code>ObjectAnimator.ofInt(target, propertyName, 0, 10).setDuration(500).start()</code>.
 
 * This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public android.animation.ObjectAnimator setDuration(long duration) { throw new RuntimeException("Stub!"); }

/**
 * The target object whose property will be animated by this animation
 *
 * @return The object being animated
 
 * This value may be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.Nullable
public java.lang.Object getTarget() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param target This value may be {@code null}.
 * @apiSince 11
 */

public void setTarget(@androidx.annotation.Nullable java.lang.Object target) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void setupStartValues() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void setupEndValues() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public android.animation.ObjectAnimator clone() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

