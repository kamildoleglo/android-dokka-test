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


package android.graphics;


/**
 * An Insets instance holds four integer offsets which describe changes to the four
 * edges of a Rectangle. By convention, positive values move edges towards the
 * centre of the rectangle.
 * <p>
 * Insets are immutable so may be treated as values.
 *
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Insets implements android.os.Parcelable {

private Insets() { throw new RuntimeException("Stub!"); }

/**
 * Return an Insets instance with the appropriate values.
 *
 * @param left the left inset
 * @param top the top inset
 * @param right the right inset
 * @param bottom the bottom inset
 *
 * @return Insets instance with the appropriate values
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.graphics.Insets of(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Return an Insets instance with the appropriate values.
 *
 * @param r the rectangle from which to take the values
 *
 * This value may be {@code null}.
 * @return an Insets instance with the appropriate values
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.graphics.Insets of(@androidx.annotation.Nullable android.graphics.Rect r) { throw new RuntimeException("Stub!"); }

/**
 * Add two Insets.
 *
 * @param a The first Insets to add.
 * This value must never be {@code null}.
 * @param b The second Insets to add.
 * This value must never be {@code null}.
 * @return a + b, i. e. all insets on every side are added together.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.graphics.Insets add(@androidx.annotation.NonNull android.graphics.Insets a, @androidx.annotation.NonNull android.graphics.Insets b) { throw new RuntimeException("Stub!"); }

/**
 * Subtract two Insets.
 *
 * @param a The minuend.
 * This value must never be {@code null}.
 * @param b The subtrahend.
 * This value must never be {@code null}.
 * @return a - b, i. e. all insets on every side are subtracted from each other.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.graphics.Insets subtract(@androidx.annotation.NonNull android.graphics.Insets a, @androidx.annotation.NonNull android.graphics.Insets b) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the maximum of two Insets.
 *
 * @param a The first Insets.
 * This value must never be {@code null}.
 * @param b The second Insets.
 * This value must never be {@code null}.
 * @return max(a, b), i. e. the larger of every inset on every side is taken for the result.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.graphics.Insets max(@androidx.annotation.NonNull android.graphics.Insets a, @androidx.annotation.NonNull android.graphics.Insets b) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the minimum of two Insets.
 *
 * @param a The first Insets.
 * This value must never be {@code null}.
 * @param b The second Insets.
 * This value must never be {@code null}.
 * @return min(a, b), i. e. the smaller of every inset on every side is taken for the result.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.graphics.Insets min(@androidx.annotation.NonNull android.graphics.Insets a, @androidx.annotation.NonNull android.graphics.Insets b) { throw new RuntimeException("Stub!"); }

/**
 * Two Insets instances are equal iff they belong to the same class and their fields are
 * pairwise equal.
 *
 * @param o the object to compare this instance with.
 *
 * @return true iff this object is equal {@code o}
 * @apiSince 29
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.graphics.Insets> CREATOR;
static { CREATOR = null; }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.graphics.Insets NONE;
static { NONE = null; }

/** @apiSince 29 */

public final int bottom;
{ bottom = 0; }

/** @apiSince 29 */

public final int left;
{ left = 0; }

/** @apiSince 29 */

public final int right;
{ right = 0; }

/** @apiSince 29 */

public final int top;
{ top = 0; }
}

