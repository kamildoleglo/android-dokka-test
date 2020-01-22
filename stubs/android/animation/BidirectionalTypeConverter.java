/*
 * Copyright (C) 2014 The Android Open Source Project
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
 * Abstract base class used convert type T to another type V and back again. This
 * is necessary when the value types of in animation are different from the property
 * type. BidirectionalTypeConverter is needed when only the final value for the
 * animation is supplied to animators.
 * @see android.animation.PropertyValuesHolder#setConverter(TypeConverter)
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class BidirectionalTypeConverter<T, V> extends android.animation.TypeConverter<T,V> {

/** @apiSince 21 */

public BidirectionalTypeConverter(java.lang.Class<T> fromClass, java.lang.Class<V> toClass) { super(null, null); throw new RuntimeException("Stub!"); }

/**
 * Does a conversion from the target type back to the source type. The subclass
 * must implement this when a TypeConverter is used in animations and current
 * values will need to be read for an animation.
 * @param value The Object to convert.
 * @return A value of type T, converted from <code>value</code>.
 * @apiSince 21
 */

public abstract T convertBack(V value);

/**
 * Returns the inverse of this converter, where the from and to classes are reversed.
 * The inverted converter uses this convert to call {@link #convertBack(java.lang.Object)} for
 * {@link #convert(java.lang.Object)} calls and {@link #convert(java.lang.Object)} for
 * {@link #convertBack(java.lang.Object)} calls.
 * @return The inverse of this converter, where the from and to classes are reversed.
 * @apiSince 21
 */

public android.animation.BidirectionalTypeConverter<V,T> invert() { throw new RuntimeException("Stub!"); }
}

