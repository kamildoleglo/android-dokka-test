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


package android.util;


/**
 * Immutable class for describing width and height dimensions in pixels.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Size {

/**
 * Create a new immutable Size instance.
 *
 * @param width The width of the size, in pixels
 * @param height The height of the size, in pixels
 * @apiSince 21
 */

public Size(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Get the width of the size (in pixels).
 * @return width
 * @apiSince 21
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Get the height of the size (in pixels).
 * @return height
 * @apiSince 21
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Check if this size is equal to another size.
 * <p>
 * Two sizes are equal if and only if both their widths and heights are
 * equal.
 * </p>
 * <p>
 * A size object is never equal to any other type of object.
 * </p>
 *
 * @return {@code true} if the objects were equal, {@code false} otherwise
 * @apiSince 21
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Return the size represented as a string with the format {@code "WxH"}
 *
 * @return string representation of the size
 * @apiSince 21
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Parses the specified string as a size value.
 * <p>
 * The ASCII characters {@code \}{@code u002a} ('*') and
 * {@code \}{@code u0078} ('x') are recognized as separators between
 * the width and height.</p>
 * <p>
 * For any {@code Size s}: {@code Size.parseSize(s.toString()).equals(s)}.
 * However, the method also handles sizes expressed in the
 * following forms:</p>
 * <p>
 * "<i>width</i>{@code x}<i>height</i>" or
 * "<i>width</i>{@code *}<i>height</i>" {@code => new Size(width, height)},
 * where <i>width</i> and <i>height</i> are string integers potentially
 * containing a sign, such as "-10", "+7" or "5".</p>
 *
 * <pre>{@code
 * Size.parseSize("3*+6").equals(new Size(3, 6)) == true
 * Size.parseSize("-3x-6").equals(new Size(-3, -6)) == true
 * Size.parseSize("4 by 3") => throws NumberFormatException
 * }</pre>
 *
 * @param string the string representation of a size value.
 * @return the size value represented by {@code string}.
 *
 * @throws java.lang.NumberFormatException if {@code string} cannot be parsed
 * as a size value.
 * @throws java.lang.NullPointerException if {@code string} was {@code null}
 * @apiSince 21
 */

public static android.util.Size parseSize(java.lang.String string) throws java.lang.NumberFormatException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 21
 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

