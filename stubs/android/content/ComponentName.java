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


package android.content;

import android.os.Parcel;

/**
 * Identifier for a specific application component
 * ({@link android.app.Activity}, {@link android.app.Service},
 * {@link android.content.BroadcastReceiver}, or
 * {@link android.content.ContentProvider}) that is available.  Two
 * pieces of information, encapsulated here, are required to identify
 * a component: the package (a String) it exists in, and the class (a String)
 * name inside of that package.
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ComponentName implements android.os.Parcelable, java.lang.Cloneable, java.lang.Comparable<android.content.ComponentName> {

/**
 * Create a new component identifier.
 *
 * @param pkg The name of the package that the component exists in.  Can
 * not be null.
 * This value must never be {@code null}.
 * @param cls The name of the class inside of <var>pkg</var> that
 * implements the component.  Can not be null.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public ComponentName(@androidx.annotation.NonNull java.lang.String pkg, @androidx.annotation.NonNull java.lang.String cls) { throw new RuntimeException("Stub!"); }

/**
 * Create a new component identifier from a Context and class name.
 *
 * @param pkg A Context for the package implementing the component,
 * from which the actual package name will be retrieved.
 * This value must never be {@code null}.
 * @param cls The name of the class inside of <var>pkg</var> that
 * implements the component.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public ComponentName(@androidx.annotation.NonNull android.content.Context pkg, @androidx.annotation.NonNull java.lang.String cls) { throw new RuntimeException("Stub!"); }

/**
 * Create a new component identifier from a Context and Class object.
 *
 * @param pkg A Context for the package implementing the component, from
 * which the actual package name will be retrieved.
 * This value must never be {@code null}.
 * @param cls The Class object of the desired component, from which the
 * actual class name will be retrieved.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public ComponentName(@androidx.annotation.NonNull android.content.Context pkg, @androidx.annotation.NonNull java.lang.Class<?> cls) { throw new RuntimeException("Stub!"); }

/**
 * Instantiate a new ComponentName from the data in a Parcel that was
 * previously written with {@link #writeToParcel(android.os.Parcel,int)}.  Note that you
 * must not use this with data written by
 * {@link #writeToParcel(android.content.ComponentName,android.os.Parcel)} since it is not possible
 * to handle a null ComponentObject here.
 *
 * @param in The Parcel containing the previously written ComponentName,
 * positioned at the location in the buffer where it was written.
 * @apiSince 1
 */

public ComponentName(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Create a new component identifier where the class name may be specified
 * as either absolute or relative to the containing package.
 *
 * <p>Relative package names begin with a <code>'.'</code> character. For a package
 * <code>"com.example"</code> and class name <code>".app.MyActivity"</code> this method
 * will return a ComponentName with the package <code>"com.example"</code>and class name
 * <code>"com.example.app.MyActivity"</code>. Fully qualified class names are also
 * permitted.</p>
 *
 * @param pkg the name of the package the component exists in
 * This value must never be {@code null}.
 * @param cls the name of the class inside of <var>pkg</var> that implements
 *            the component
 * This value must never be {@code null}.
 * @return the new ComponentName
 
 * This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public static android.content.ComponentName createRelative(@androidx.annotation.NonNull java.lang.String pkg, @androidx.annotation.NonNull java.lang.String cls) { throw new RuntimeException("Stub!"); }

/**
 * Create a new component identifier where the class name may be specified
 * as either absolute or relative to the containing package.
 *
 * <p>Relative package names begin with a <code>'.'</code> character. For a package
 * <code>"com.example"</code> and class name <code>".app.MyActivity"</code> this method
 * will return a ComponentName with the package <code>"com.example"</code>and class name
 * <code>"com.example.app.MyActivity"</code>. Fully qualified class names are also
 * permitted.</p>
 *
 * @param pkg a Context for the package implementing the component
 * This value must never be {@code null}.
 * @param cls the name of the class inside of <var>pkg</var> that implements
 *            the component
 * This value must never be {@code null}.
 * @return the new ComponentName
 
 * This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public static android.content.ComponentName createRelative(@androidx.annotation.NonNull android.content.Context pkg, @androidx.annotation.NonNull java.lang.String cls) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.content.ComponentName clone() { throw new RuntimeException("Stub!"); }

/**
 * Return the package name of this component.
 
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Return the class name of this component.
 
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getClassName() { throw new RuntimeException("Stub!"); }

/**
 * Return the class name, either fully qualified or in a shortened form
 * (with a leading '.') if it is a suffix of the package.
 * @apiSince 1
 */

public java.lang.String getShortClassName() { throw new RuntimeException("Stub!"); }

/**
 * Return a String that unambiguously describes both the package and
 * class names contained in the ComponentName.  You can later recover
 * the ComponentName from this string through
 * {@link #unflattenFromString(java.lang.String)}.
 *
 * @return Returns a new String holding the package and class names.  This
 * is represented as the package name, concatenated with a '/' and then the
 * class name.
 *
 * This value will never be {@code null}.
 * @see #unflattenFromString(String)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String flattenToString() { throw new RuntimeException("Stub!"); }

/**
 * The same as {@link #flattenToString()}, but abbreviates the class
 * name if it is a suffix of the package.  The result can still be used
 * with {@link #unflattenFromString(java.lang.String)}.
 *
 * @return Returns a new String holding the package and class names.  This
 * is represented as the package name, concatenated with a '/' and then the
 * class name.
 *
 * This value will never be {@code null}.
 * @see #unflattenFromString(String)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String flattenToShortString() { throw new RuntimeException("Stub!"); }

/**
 * Recover a ComponentName from a String that was previously created with
 * {@link #flattenToString()}.  It splits the string at the first '/',
 * taking the part before as the package name and the part after as the
 * class name.  As a special convenience (to use, for example, when
 * parsing component names on the command line), if the '/' is immediately
 * followed by a '.' then the final class name will be the concatenation
 * of the package name with the string following the '/'.  Thus
 * "com.foo/.Blah" becomes package="com.foo" class="com.foo.Blah".
 *
 * @param str The String that was returned by flattenToString().
 * This value must never be {@code null}.
 * @return Returns a new ComponentName containing the package and class
 * names that were encoded in <var>str</var>
 *
 * This value may be {@code null}.
 * @see #flattenToString()
 * @apiSince 1
 */

@androidx.annotation.Nullable
public static android.content.ComponentName unflattenFromString(@androidx.annotation.NonNull java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * Return string representation of this class without the class's name
 * as a prefix.
 * @apiSince 1
 */

public java.lang.String toShortString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public int compareTo(android.content.ComponentName that) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Write a ComponentName to a Parcel, handling null pointers.  Must be
 * read with {@link #readFromParcel(android.os.Parcel)}.
 *
 * @param c The ComponentName to be written.
 * @param out The Parcel in which the ComponentName will be placed.
 *
 * @see #readFromParcel(Parcel)
 * @apiSince 1
 */

public static void writeToParcel(android.content.ComponentName c, android.os.Parcel out) { throw new RuntimeException("Stub!"); }

/**
 * Read a ComponentName from a Parcel that was previously written
 * with {@link #writeToParcel(android.content.ComponentName,android.os.Parcel)}, returning either
 * a null or new object as appropriate.
 *
 * @param in The Parcel from which to read the ComponentName
 * @return Returns a new ComponentName matching the previously written
 * object, or null if a null had been written.
 *
 * @see #writeToParcel(ComponentName, Parcel)
 * @apiSince 1
 */

public static android.content.ComponentName readFromParcel(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.ComponentName> CREATOR;
static { CREATOR = null; }
}

