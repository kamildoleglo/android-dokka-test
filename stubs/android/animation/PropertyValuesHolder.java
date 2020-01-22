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

import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/**
 * This class holds information about a property and the values that that property
 * should take on during an animation. PropertyValuesHolder objects can be used to create
 * animations with ValueAnimator or ObjectAnimator that operate on several different properties
 * in parallel.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PropertyValuesHolder implements java.lang.Cloneable {

private PropertyValuesHolder() { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder with a given property name and
 * set of int values.
 * @param propertyName The name of the property being animated.
 * @param values The values that the named property will animate between.
 * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
 * @apiSince 11
 */

public static android.animation.PropertyValuesHolder ofInt(java.lang.String propertyName, int... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder with a given property and
 * set of int values.
 * @param property The property being animated. Should not be null.
 * @param values The values that the property will animate between.
 * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
 * @apiSince 14
 */

public static android.animation.PropertyValuesHolder ofInt(android.util.Property<?,java.lang.Integer> property, int... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder with a given property name and
 * set of <code>int[]</code> values. At least two <code>int[]</code> values must be supplied,
 * a start and end value. If more values are supplied, the values will be animated from the
 * start, through all intermediate values to the end value. When used with ObjectAnimator,
 * the elements of the array represent the parameters of the setter function.
 *
 * @param propertyName The name of the property being animated. Can also be the
 *                     case-sensitive name of the entire setter method. Should not be null.
 * @param values The values that the property will animate between.
 * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
 * @see android.animation.IntArrayEvaluator#IntArrayEvaluator(int[])
 * @see android.animation.ObjectAnimator#ofMultiInt(Object, String, TypeConverter, TypeEvaluator, Object[])
 * @apiSince 21
 */

public static android.animation.PropertyValuesHolder ofMultiInt(java.lang.String propertyName, int[][] values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder with a given property name to use
 * as a multi-int setter. The values are animated along the path, with the first
 * parameter of the setter set to the x coordinate and the second set to the y coordinate.
 *
 * @param propertyName The name of the property being animated. Can also be the
 *                     case-sensitive name of the entire setter method. Should not be null.
 *                     The setter must take exactly two <code>int</code> parameters.
 * @param path The Path along which the values should be animated.
 * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
 * @see android.animation.ObjectAnimator#ofPropertyValuesHolder(Object, PropertyValuesHolder...)
 * @apiSince 21
 */

public static android.animation.PropertyValuesHolder ofMultiInt(java.lang.String propertyName, android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder with a given property and
 * set of Object values for use with ObjectAnimator multi-value setters. The Object
 * values are converted to <code>int[]</code> using the converter.
 *
 * @param propertyName The property being animated or complete name of the setter.
 *                     Should not be null.
 * @param converter Used to convert the animated value to setter parameters.
 * @param evaluator A TypeEvaluator that will be called on each animation frame to
 * provide the necessary interpolation between the Object values to derive the animated
 * value.
 * @param values The values that the property will animate between.
 * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
 * @see android.animation.ObjectAnimator#ofMultiInt(Object, String, TypeConverter, TypeEvaluator, Object[])
 * @see android.animation.ObjectAnimator#ofPropertyValuesHolder(Object, PropertyValuesHolder...)
 * @apiSince 21
 */

@java.lang.SafeVarargs
public static <V> android.animation.PropertyValuesHolder ofMultiInt(java.lang.String propertyName, android.animation.TypeConverter<V,int[]> converter, android.animation.TypeEvaluator<V> evaluator, V... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder object with the specified property name or
 * setter name for use in a multi-int setter function using ObjectAnimator. The values can be
 * of any type, but the type should be consistent so that the supplied
 * {@link android.animation.TypeEvaluator} can be used to to evaluate the animated value. The
 * <code>converter</code> converts the values to parameters in the setter function.
 *
 * <p>At least two values must be supplied, a start and an end value.</p>
 *
 * @param propertyName The name of the property to associate with the set of values. This
 *                     may also be the complete name of a setter function.
 * @param converter    Converts <code>values</code> into int parameters for the setter.
 *                     Can be null if the Keyframes have int[] values.
 * @param evaluator    Used to interpolate between values.
 * @param values       The values at specific fractional times to evaluate between
 * @return A PropertyValuesHolder for a multi-int parameter setter.
 * @apiSince 21
 */

public static <T> android.animation.PropertyValuesHolder ofMultiInt(java.lang.String propertyName, android.animation.TypeConverter<T,int[]> converter, android.animation.TypeEvaluator<T> evaluator, android.animation.Keyframe... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder with a given property name and
 * set of float values.
 * @param propertyName The name of the property being animated.
 * @param values The values that the named property will animate between.
 * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
 * @apiSince 11
 */

public static android.animation.PropertyValuesHolder ofFloat(java.lang.String propertyName, float... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder with a given property and
 * set of float values.
 * @param property The property being animated. Should not be null.
 * @param values The values that the property will animate between.
 * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
 * @apiSince 14
 */

public static android.animation.PropertyValuesHolder ofFloat(android.util.Property<?,java.lang.Float> property, float... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder with a given property name and
 * set of <code>float[]</code> values. At least two <code>float[]</code> values must be supplied,
 * a start and end value. If more values are supplied, the values will be animated from the
 * start, through all intermediate values to the end value. When used with ObjectAnimator,
 * the elements of the array represent the parameters of the setter function.
 *
 * @param propertyName The name of the property being animated. Can also be the
 *                     case-sensitive name of the entire setter method. Should not be null.
 * @param values The values that the property will animate between.
 * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
 * @see android.animation.FloatArrayEvaluator#FloatArrayEvaluator(float[])
 * @see android.animation.ObjectAnimator#ofMultiFloat(Object, String, TypeConverter, TypeEvaluator, Object[])
 * @apiSince 21
 */

public static android.animation.PropertyValuesHolder ofMultiFloat(java.lang.String propertyName, float[][] values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder with a given property name to use
 * as a multi-float setter. The values are animated along the path, with the first
 * parameter of the setter set to the x coordinate and the second set to the y coordinate.
 *
 * @param propertyName The name of the property being animated. Can also be the
 *                     case-sensitive name of the entire setter method. Should not be null.
 *                     The setter must take exactly two <code>float</code> parameters.
 * @param path The Path along which the values should be animated.
 * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
 * @see android.animation.ObjectAnimator#ofPropertyValuesHolder(Object, PropertyValuesHolder...)
 * @apiSince 21
 */

public static android.animation.PropertyValuesHolder ofMultiFloat(java.lang.String propertyName, android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder with a given property and
 * set of Object values for use with ObjectAnimator multi-value setters. The Object
 * values are converted to <code>float[]</code> using the converter.
 *
 * @param propertyName The property being animated or complete name of the setter.
 *                     Should not be null.
 * @param converter Used to convert the animated value to setter parameters.
 * @param evaluator A TypeEvaluator that will be called on each animation frame to
 * provide the necessary interpolation between the Object values to derive the animated
 * value.
 * @param values The values that the property will animate between.
 * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
 * @see android.animation.ObjectAnimator#ofMultiFloat(Object, String, TypeConverter, TypeEvaluator, Object[])
 * @apiSince 21
 */

@java.lang.SafeVarargs
public static <V> android.animation.PropertyValuesHolder ofMultiFloat(java.lang.String propertyName, android.animation.TypeConverter<V,float[]> converter, android.animation.TypeEvaluator<V> evaluator, V... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder object with the specified property name or
 * setter name for use in a multi-float setter function using ObjectAnimator. The values can be
 * of any type, but the type should be consistent so that the supplied
 * {@link android.animation.TypeEvaluator} can be used to to evaluate the animated value. The
 * <code>converter</code> converts the values to parameters in the setter function.
 *
 * <p>At least two values must be supplied, a start and an end value.</p>
 *
 * @param propertyName The name of the property to associate with the set of values. This
 *                     may also be the complete name of a setter function.
 * @param converter    Converts <code>values</code> into float parameters for the setter.
 *                     Can be null if the Keyframes have float[] values.
 * @param evaluator    Used to interpolate between values.
 * @param values       The values at specific fractional times to evaluate between
 * @return A PropertyValuesHolder for a multi-float parameter setter.
 * @apiSince 21
 */

public static <T> android.animation.PropertyValuesHolder ofMultiFloat(java.lang.String propertyName, android.animation.TypeConverter<T,float[]> converter, android.animation.TypeEvaluator<T> evaluator, android.animation.Keyframe... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder with a given property name and
 * set of Object values. This variant also takes a TypeEvaluator because the system
 * cannot automatically interpolate between objects of unknown type.
 *
 * <p><strong>Note:</strong> The Object values are stored as references to the original
 * objects, which means that changes to those objects after this method is called will
 * affect the values on the PropertyValuesHolder. If the objects will be mutated externally
 * after this method is called, callers should pass a copy of those objects instead.
 *
 * @param propertyName The name of the property being animated.
 * @param evaluator A TypeEvaluator that will be called on each animation frame to
 * provide the necessary interpolation between the Object values to derive the animated
 * value.
 * @param values The values that the named property will animate between.
 * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
 * @apiSince 11
 */

public static android.animation.PropertyValuesHolder ofObject(java.lang.String propertyName, android.animation.TypeEvaluator evaluator, java.lang.Object... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder with a given property name and
 * a Path along which the values should be animated. This variant supports a
 * <code>TypeConverter</code> to convert from <code>PointF</code> to the target
 * type.
 *
 * <p>The PointF passed to <code>converter</code> or <code>property</code>, if
 * <code>converter</code> is <code>null</code>, is reused on each animation frame and should
 * not be stored by the setter or TypeConverter.</p>
 *
 * @param propertyName The name of the property being animated.
 * @param converter Converts a PointF to the type associated with the setter. May be
 *                  null if conversion is unnecessary.
 * @param path The Path along which the values should be animated.
 * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
 * @apiSince 21
 */

public static android.animation.PropertyValuesHolder ofObject(java.lang.String propertyName, android.animation.TypeConverter<android.graphics.PointF,?> converter, android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder with a given property and
 * set of Object values. This variant also takes a TypeEvaluator because the system
 * cannot automatically interpolate between objects of unknown type.
 *
 * <p><strong>Note:</strong> The Object values are stored as references to the original
 * objects, which means that changes to those objects after this method is called will
 * affect the values on the PropertyValuesHolder. If the objects will be mutated externally
 * after this method is called, callers should pass a copy of those objects instead.
 *
 * @param property The property being animated. Should not be null.
 * @param evaluator A TypeEvaluator that will be called on each animation frame to
 * provide the necessary interpolation between the Object values to derive the animated
 * value.
 * @param values The values that the property will animate between.
 * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
 * @apiSince 14
 */

@java.lang.SafeVarargs
public static <V> android.animation.PropertyValuesHolder ofObject(android.util.Property property, android.animation.TypeEvaluator<V> evaluator, V... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder with a given property and
 * set of Object values. This variant also takes a TypeEvaluator because the system
 * cannot automatically interpolate between objects of unknown type. This variant also
 * takes a <code>TypeConverter</code> to convert from animated values to the type
 * of the property. If only one value is supplied, the <code>TypeConverter</code>
 * must be a {@link android.animation.BidirectionalTypeConverter} to retrieve the current
 * value.
 *
 * <p><strong>Note:</strong> The Object values are stored as references to the original
 * objects, which means that changes to those objects after this method is called will
 * affect the values on the PropertyValuesHolder. If the objects will be mutated externally
 * after this method is called, callers should pass a copy of those objects instead.
 *
 * @param property The property being animated. Should not be null.
 * @param converter Converts the animated object to the Property type.
 * @param evaluator A TypeEvaluator that will be called on each animation frame to
 * provide the necessary interpolation between the Object values to derive the animated
 * value.
 * @param values The values that the property will animate between.
 * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
 * @see #setConverter(TypeConverter)
 * @see android.animation.TypeConverter
 * @apiSince 21
 */

@java.lang.SafeVarargs
public static <T, V> android.animation.PropertyValuesHolder ofObject(android.util.Property<?,V> property, android.animation.TypeConverter<T,V> converter, android.animation.TypeEvaluator<T> evaluator, T... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder with a given property and
 * a Path along which the values should be animated. This variant supports a
 * <code>TypeConverter</code> to convert from <code>PointF</code> to the target
 * type.
 *
 * <p>The PointF passed to <code>converter</code> or <code>property</code>, if
 * <code>converter</code> is <code>null</code>, is reused on each animation frame and should
 * not be stored by the setter or TypeConverter.</p>
 *
 * @param property The property being animated. Should not be null.
 * @param converter Converts a PointF to the type associated with the setter. May be
 *                  null if conversion is unnecessary.
 * @param path The Path along which the values should be animated.
 * @return PropertyValuesHolder The constructed PropertyValuesHolder object.
 * @apiSince 21
 */

public static <V> android.animation.PropertyValuesHolder ofObject(android.util.Property<?,V> property, android.animation.TypeConverter<android.graphics.PointF,V> converter, android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder object with the specified property name and set
 * of values. These values can be of any type, but the type should be consistent so that
 * an appropriate {@link android.animation.TypeEvaluator} can be found that matches
 * the common type.
 * <p>If there is only one value, it is assumed to be the end value of an animation,
 * and an initial value will be derived, if possible, by calling a getter function
 * on the object. Also, if any value is null, the value will be filled in when the animation
 * starts in the same way. This mechanism of automatically getting null values only works
 * if the PropertyValuesHolder object is used in conjunction
 * {@link android.animation.ObjectAnimator ObjectAnimator}, and with a getter function
 * derived automatically from <code>propertyName</code>, since otherwise PropertyValuesHolder has
 * no way of determining what the value should be.
 * @param propertyName The name of the property associated with this set of values. This
 * can be the actual property name to be used when using a ObjectAnimator object, or
 * just a name used to get animated values, such as if this object is used with an
 * ValueAnimator object.
 * @param values The set of values to animate between.
 * @apiSince 11
 */

public static android.animation.PropertyValuesHolder ofKeyframe(java.lang.String propertyName, android.animation.Keyframe... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a PropertyValuesHolder object with the specified property and set
 * of values. These values can be of any type, but the type should be consistent so that
 * an appropriate {@link android.animation.TypeEvaluator} can be found that matches
 * the common type.
 * <p>If there is only one value, it is assumed to be the end value of an animation,
 * and an initial value will be derived, if possible, by calling the property's
 * {@link android.util.Property#get(Object)} function.
 * Also, if any value is null, the value will be filled in when the animation
 * starts in the same way. This mechanism of automatically getting null values only works
 * if the PropertyValuesHolder object is used in conjunction with
 * {@link android.animation.ObjectAnimator ObjectAnimator}, since otherwise PropertyValuesHolder has
 * no way of determining what the value should be.
 * @param property The property associated with this set of values. Should not be null.
 * @param values The set of values to animate between.
 * @apiSince 14
 */

public static android.animation.PropertyValuesHolder ofKeyframe(android.util.Property property, android.animation.Keyframe... values) { throw new RuntimeException("Stub!"); }

/**
 * Set the animated values for this object to this set of ints.
 * If there is only one value, it is assumed to be the end value of an animation,
 * and an initial value will be derived, if possible, by calling a getter function
 * on the object. Also, if any value is null, the value will be filled in when the animation
 * starts in the same way. This mechanism of automatically getting null values only works
 * if the PropertyValuesHolder object is used in conjunction
 * {@link android.animation.ObjectAnimator ObjectAnimator}, and with a getter function
 * derived automatically from <code>propertyName</code>, since otherwise PropertyValuesHolder has
 * no way of determining what the value should be.
 *
 * @param values One or more values that the animation will animate between.
 * @apiSince 11
 */

public void setIntValues(int... values) { throw new RuntimeException("Stub!"); }

/**
 * Set the animated values for this object to this set of floats.
 * If there is only one value, it is assumed to be the end value of an animation,
 * and an initial value will be derived, if possible, by calling a getter function
 * on the object. Also, if any value is null, the value will be filled in when the animation
 * starts in the same way. This mechanism of automatically getting null values only works
 * if the PropertyValuesHolder object is used in conjunction
 * {@link android.animation.ObjectAnimator ObjectAnimator}, and with a getter function
 * derived automatically from <code>propertyName</code>, since otherwise PropertyValuesHolder has
 * no way of determining what the value should be.
 *
 * @param values One or more values that the animation will animate between.
 * @apiSince 11
 */

public void setFloatValues(float... values) { throw new RuntimeException("Stub!"); }

/**
 * Set the animated values for this object to this set of Keyframes.
 *
 * @param values One or more values that the animation will animate between.
 * @apiSince 11
 */

public void setKeyframes(android.animation.Keyframe... values) { throw new RuntimeException("Stub!"); }

/**
 * Set the animated values for this object to this set of Objects.
 * If there is only one value, it is assumed to be the end value of an animation,
 * and an initial value will be derived, if possible, by calling a getter function
 * on the object. Also, if any value is null, the value will be filled in when the animation
 * starts in the same way. This mechanism of automatically getting null values only works
 * if the PropertyValuesHolder object is used in conjunction
 * {@link android.animation.ObjectAnimator ObjectAnimator}, and with a getter function
 * derived automatically from <code>propertyName</code>, since otherwise PropertyValuesHolder has
 * no way of determining what the value should be.
 *
 * <p><strong>Note:</strong> The Object values are stored as references to the original
 * objects, which means that changes to those objects after this method is called will
 * affect the values on the PropertyValuesHolder. If the objects will be mutated externally
 * after this method is called, callers should pass a copy of those objects instead.
 *
 * @param values One or more values that the animation will animate between.
 * @apiSince 11
 */

public void setObjectValues(java.lang.Object... values) { throw new RuntimeException("Stub!"); }

/**
 * Sets the converter to convert from the values type to the setter's parameter type.
 * If only one value is supplied, <var>converter</var> must be a
 * {@link android.animation.BidirectionalTypeConverter}.
 * @param converter The converter to use to convert values.
 * @apiSince 21
 */

public void setConverter(android.animation.TypeConverter converter) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public android.animation.PropertyValuesHolder clone() { throw new RuntimeException("Stub!"); }

/**
 * The TypeEvaluator will be automatically determined based on the type of values
 * supplied to PropertyValuesHolder. The evaluator can be manually set, however, if so
 * desired. This may be important in cases where either the type of the values supplied
 * do not match the way that they should be interpolated between, or if the values
 * are of a custom type or one not currently understood by the animation system. Currently,
 * only values of type float and int (and their Object equivalents: Float
 * and Integer) are  correctly interpolated; all other types require setting a TypeEvaluator.
 * @param evaluator
 * @apiSince 11
 */

public void setEvaluator(android.animation.TypeEvaluator evaluator) { throw new RuntimeException("Stub!"); }

/**
 * Sets the name of the property that will be animated. This name is used to derive
 * a setter function that will be called to set animated values.
 * For example, a property name of <code>foo</code> will result
 * in a call to the function <code>setFoo()</code> on the target object. If either
 * <code>valueFrom</code> or <code>valueTo</code> is null, then a getter function will
 * also be derived and called.
 *
 * <p>Note that the setter function derived from this property name
 * must take the same parameter type as the
 * <code>valueFrom</code> and <code>valueTo</code> properties, otherwise the call to
 * the setter function will fail.</p>
 *
 * @param propertyName The name of the property being animated.
 * @apiSince 11
 */

public void setPropertyName(java.lang.String propertyName) { throw new RuntimeException("Stub!"); }

/**
 * Sets the property that will be animated.
 *
 * <p>Note that if this PropertyValuesHolder object is used with ObjectAnimator, the property
 * must exist on the target object specified in that ObjectAnimator.</p>
 *
 * @param property The property being animated.
 * @apiSince 14
 */

public void setProperty(android.util.Property property) { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of the property that will be animated. This name will be used to derive
 * a setter function that will be called to set animated values.
 * For example, a property name of <code>foo</code> will result
 * in a call to the function <code>setFoo()</code> on the target object. If either
 * <code>valueFrom</code> or <code>valueTo</code> is null, then a getter function will
 * also be derived and called.
 * @apiSince 11
 */

public java.lang.String getPropertyName() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

