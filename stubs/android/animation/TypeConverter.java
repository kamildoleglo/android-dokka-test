/*
 * Copyright (C) 2013 The Android Open Source Project
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
 * Abstract base class used convert type T to another type V. This
 * is necessary when the value types of in animation are different
 * from the property type.
 * @see android.animation.PropertyValuesHolder#setConverter(TypeConverter)
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class TypeConverter<T, V> {

/** @apiSince 21 */

public TypeConverter(java.lang.Class<T> fromClass, java.lang.Class<V> toClass) { throw new RuntimeException("Stub!"); }

/**
 * Converts a value from one type to another.
 * @param value The Object to convert.
 * @return A value of type V, converted from <code>value</code>.
 * @apiSince 21
 */

public abstract V convert(T value);
}

