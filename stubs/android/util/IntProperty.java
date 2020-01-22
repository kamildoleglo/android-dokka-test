/*
 * Copyright (C) 2011 The Android Open Source Project
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

package android.util;


/**
 * An implementation of {@link android.util.Property} to be used specifically with fields of type
 * <code>int</code>. This type-specific subclass enables performance benefit by allowing
 * calls to a {@link #setValue(java.lang.Object,int) setValue()} function that takes the primitive
 * <code>int</code> type and avoids autoboxing and other overhead associated with the
 * <code>Integer</code> class.
 *
 * @param <T> The class on which the Property is declared.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class IntProperty<T> extends android.util.Property<T,java.lang.Integer> {

/** @apiSince 24 */

public IntProperty(java.lang.String name) { super(null, null); throw new RuntimeException("Stub!"); }

/**
 * A type-specific variant of {@link #set(java.lang.Object,java.lang.Integer)} that is faster when dealing
 * with fields of type <code>int</code>.
 * @apiSince 24
 */

public abstract void setValue(T object, int value);

/** @apiSince 24 */

public final void set(T object, java.lang.Integer value) { throw new RuntimeException("Stub!"); }
}

