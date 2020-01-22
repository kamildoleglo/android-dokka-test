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

import android.util.Half;

/**
 * {@usesMathJax}
 *
 * <p>The <code>Color</code> class provides methods for creating, converting and
 * manipulating colors. Colors have three different representations:</p>
 * <ul>
 *     <li>Color ints, the most common representation</li>
 *     <li>Color longs</li>
 *     <li><code>Color</code> instances</li>
 * </ul>
 * <p>The section below describe each representation in detail.</p>
 *
 * <h3>Color ints</h3>
 * <p>Color ints are the most common representation of colors on Android and
 * have been used since {@link android.os.Build.VERSION_CODES#BASE API level 1}.</p>
 *
 * <p>A color int always defines a color in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB}
 * color space using 4 components packed in a single 32 bit integer value:</p>
 *
 * <table summary="Color int definition">
 *     <tr>
 *         <th>Component</th><th>Name</th><th>Size</th><th>Range</th>
 *     </tr>
 *     <tr><td>A</td><td>Alpha</td><td>8 bits</td><td>\([0..255]\)</td></tr>
 *     <tr><td>R</td><td>Red</td><td>8 bits</td><td>\([0..255]\)</td></tr>
 *     <tr><td>G</td><td>Green</td><td>8 bits</td><td>\([0..255]\)</td></tr>
 *     <tr><td>B</td><td>Blue</td><td>8 bits</td><td>\([0..255]\)</td></tr>
 * </table>
 *
 * <p>The components in this table are listed in encoding order (see below),
 * which is why color ints are called ARGB colors.</p>
 *
 * <h4>Usage in code</h4>
 * <p>To avoid confusing color ints with arbitrary integer values, it is a
 * good practice to annotate them with the <code>@ColorInt</code> annotation
 * found in the Android Support Library.</p>
 *
 * <h4>Encoding</h4>
 * <p>The four components of a color int are encoded in the following way:</p>
 * <pre class="prettyprint">
 * int color = (A & 0xff) << 24 | (R & 0xff) << 16 | (G & 0xff) << 8 | (B & 0xff);
 * </pre>
 *
 * <p>Because of this encoding, color ints can easily be described as an integer
 * constant in source. For instance, opaque blue is <code>0xff0000ff</code>
 * and yellow is <code>0xffffff00</code>.</p>
 *
 * <p>To easily encode color ints, it is recommended to use the static methods
 * {@link #argb(int,int,int,int)} and {@link #rgb(int,int,int)}. The second
 * method omits the alpha component and assumes the color is opaque (alpha is 255).
 * As a convenience this class also offers methods to encode color ints from components
 * defined in the \([0..1]\) range: {@link #argb(float,float,float,float)} and
 * {@link #rgb(float,float,float)}.</p>
 *
 * <p>Color longs (defined below) can be easily converted to color ints by invoking
 * the {@link #toArgb(long)} method. This method performs a color space conversion
 * if needed.</p>
 *
 * <p>It is also possible to create a color int by invoking the method {@link #toArgb()}
 * on a color instance.</p>
 *
 * <h4>Decoding</h4>
 * <p>The four ARGB components can be individually extracted from a color int
 * using the following expressions:</p>
 * <pre class="prettyprint">
 * int A = (color >> 24) & 0xff; // or color >>> 24
 * int R = (color >> 16) & 0xff;
 * int G = (color >>  8) & 0xff;
 * int B = (color      ) & 0xff;
 * </pre>
 *
 * <p>This class offers convenience methods to easily extract these components:</p>
 * <ul>
 *     <li>{@link #alpha(int)} to extract the alpha component</li>
 *     <li>{@link #red(int)} to extract the red component</li>
 *     <li>{@link #green(int)} to extract the green component</li>
 *     <li>{@link #blue(int)} to extract the blue component</li>
 * </ul>
 *
 * <h3>Color longs</h3>
 * <p>Color longs are a representation introduced in
 * {@link android.os.Build.VERSION_CODES#O Android O} to store colors in different
 * {@link android.graphics.ColorSpace ColorSpace}, with more precision than color ints.</p>
 *
 * <p>A color long always defines a color using 4 components packed in a single
 * 64 bit long value. One of these components is always alpha while the other
 * three components depend on the color space's {@link android.graphics.ColorSpace.Model ColorSpace.Model}.
 * The most common color model is the {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB} model in
 * which the components represent red, green and blue values.</p>
 *
 * <p class="note"><b>Component ranges:</b> the ranges defined in the tables
 * below indicate the ranges that can be encoded in a color long. They do not
 * represent the actual ranges as they may differ per color space. For instance,
 * the RGB components of a color in the {@link android.graphics.ColorSpace.Named#DISPLAY_P3 ColorSpace.Named#DISPLAY_P3}
 * color space use the \([0..1]\) range. Please refer to the documentation of the
 * various {@link android.graphics.ColorSpace.Named ColorSpace.Named} to find their respective ranges.</p>
 *
 * <p class="note"><b>Alpha range:</b> while alpha is encoded in a color long using
 * a 10 bit integer (thus using a range of \([0..1023]\)), it is converted to and
 * from \([0..1]\) float values when decoding and encoding color longs.</p>
 *
 * <p class="note"><b>sRGB color space:</b> for compatibility reasons and ease of
 * use, color longs encoding {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} colors do not
 * use the same encoding as other color longs.</p>
 *
 * <table summary="Color long definition">
 *     <tr>
 *         <th>Component</th><th>Name</th><th>Size</th><th>Range</th>
 *     </tr>
 *     <tr><td colspan="4">{@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB} color model</td></tr>
 *     <tr><td>R</td><td>Red</td><td>16 bits</td><td>\([-65504.0, 65504.0]\)</td></tr>
 *     <tr><td>G</td><td>Green</td><td>16 bits</td><td>\([-65504.0, 65504.0]\)</td></tr>
 *     <tr><td>B</td><td>Blue</td><td>16 bits</td><td>\([-65504.0, 65504.0]\)</td></tr>
 *     <tr><td>A</td><td>Alpha</td><td>10 bits</td><td>\([0..1023]\)</td></tr>
 *     <tr><td></td><td>Color space</td><td>6 bits</td><td>\([0..63]\)</td></tr>
 *     <tr><td colspan="4">{@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} color space</td></tr>
 *     <tr><td>A</td><td>Alpha</td><td>8 bits</td><td>\([0..255]\)</td></tr>
 *     <tr><td>R</td><td>Red</td><td>8 bits</td><td>\([0..255]\)</td></tr>
 *     <tr><td>G</td><td>Green</td><td>8 bits</td><td>\([0..255]\)</td></tr>
 *     <tr><td>B</td><td>Blue</td><td>8 bits</td><td>\([0..255]\)</td></tr>
 *     <tr><td>X</td><td>Unused</td><td>32 bits</td><td>\(0\)</td></tr>
 *     <tr><td colspan="4">{@link android.graphics.ColorSpace.Model#XYZ ColorSpace.Model#XYZ} color model</td></tr>
 *     <tr><td>X</td><td>X</td><td>16 bits</td><td>\([-65504.0, 65504.0]\)</td></tr>
 *     <tr><td>Y</td><td>Y</td><td>16 bits</td><td>\([-65504.0, 65504.0]\)</td></tr>
 *     <tr><td>Z</td><td>Z</td><td>16 bits</td><td>\([-65504.0, 65504.0]\)</td></tr>
 *     <tr><td>A</td><td>Alpha</td><td>10 bits</td><td>\([0..1023]\)</td></tr>
 *     <tr><td></td><td>Color space</td><td>6 bits</td><td>\([0..63]\)</td></tr>
 *     <tr><td colspan="4">{@link android.graphics.ColorSpace.Model#XYZ ColorSpace.Model#XYZ} color model</td></tr>
 *     <tr><td>L</td><td>L</td><td>16 bits</td><td>\([-65504.0, 65504.0]\)</td></tr>
 *     <tr><td>a</td><td>a</td><td>16 bits</td><td>\([-65504.0, 65504.0]\)</td></tr>
 *     <tr><td>b</td><td>b</td><td>16 bits</td><td>\([-65504.0, 65504.0]\)</td></tr>
 *     <tr><td>A</td><td>Alpha</td><td>10 bits</td><td>\([0..1023]\)</td></tr>
 *     <tr><td></td><td>Color space</td><td>6 bits</td><td>\([0..63]\)</td></tr>
 *     <tr><td colspan="4">{@link android.graphics.ColorSpace.Model#CMYK ColorSpace.Model#CMYK} color model</td></tr>
 *     <tr><td colspan="4">Unsupported</td></tr>
 * </table>
 *
 * <p>The components in this table are listed in encoding order (see below),
 * which is why color longs in the RGB model are called RGBA colors (even if
 * this doesn't quite hold for the special case of sRGB colors).</p>
 *
 * <p>The color long encoding relies on half-precision float values (fp16). If you
 * wish to know more about the limitations of half-precision float values, please
 * refer to the documentation of the {@link android.util.Half Half} class.</p>
 *
 * <h4>Usage in code</h4>
 * <p>To avoid confusing color longs with arbitrary long values, it is a
 * good practice to annotate them with the <code>@ColorLong</code> annotation
 * found in the Android Support Library.</p>
 *
 * <h4>Encoding</h4>
 *
 * <p>Given the complex nature of color longs, it is strongly encouraged to use
 * the various methods provided by this class to encode them.</p>
 *
 * <p>The most flexible way to encode a color long is to use the method
 * {@link #pack(float,float,float,float,android.graphics.ColorSpace)}. This method allows you
 * to specify three color components (typically RGB), an alpha component and a
 * color space. To encode sRGB colors, use {@link #pack(float,float,float)}
 * and {@link #pack(float,float,float,float)} which are the
 * equivalent of {@link #rgb(int,int,int)} and {@link #argb(int,int,int,int)}
 * for color ints. If you simply need to convert a color int into a color long,
 * use {@link #pack(int)}.</p>
 *
 * <p>It is also possible to create a color long value by invoking the method
 * {@link #pack()} on a color instance.</p>
 *
 * <h4>Decoding</h4>
 *
 * <p>This class offers convenience methods to easily extract the components
 * of a color long:</p>
 * <ul>
 *     <li>{@link #alpha(long)} to extract the alpha component</li>
 *     <li>{@link #red(long)} to extract the red/X/L component</li>
 *     <li>{@link #green(long)} to extract the green/Y/a component</li>
 *     <li>{@link #blue(long)} to extract the blue/Z/b component</li>
 * </ul>
 *
 * <p>The values returned by these methods depend on the color space encoded
 * in the color long. The values are however typically in the \([0..1]\) range
 * for RGB colors. Please refer to the documentation of the various
 * {@link android.graphics.ColorSpace.Named ColorSpace.Named} for the exact ranges.</p>
 *
 * <h3>Color instances</h3>
 * <p>Color instances are a representation introduced in
 * {@link android.os.Build.VERSION_CODES#O Android O} to store colors in different
 * {@link android.graphics.ColorSpace ColorSpace}, with more precision than both color ints and
 * color longs. Color instances also offer the ability to store more than 4
 * components if necessary.</p>
 *
 * <p>Colors instances are immutable and can be created using one of the various
 * <code>valueOf</code> methods. For instance:</p>
 * <pre class="prettyprint">
 * // sRGB
 * Color opaqueRed = Color.valueOf(0xffff0000); // from a color int
 * Color translucentRed = Color.valueOf(1.0f, 0.0f, 0.0f, 0.5f);
 *
 * // Wide gamut color
 * {@literal @}ColorLong long p3 = pack(1.0f, 1.0f, 0.0f, 1.0f, colorSpaceP3);
 * Color opaqueYellow = Color.valueOf(p3); // from a color long
 *
 * // CIE L*a*b* color space
 * ColorSpace lab = ColorSpace.get(ColorSpace.Named.LAB);
 * Color green = Color.valueOf(100.0f, -128.0f, 128.0f, 1.0f, lab);
 * </pre>
 *
 * <p>Color instances can be converted to color ints ({@link #toArgb()}) or
 * color longs ({@link #pack()}). They also offer easy access to their various
 * components using the following methods:</p>
 * <ul>
 *     <li>{@link #alpha()}, returns the alpha component value</li>
 *     <li>{@link #red()}, returns the red component value (or first
 *     component value in non-RGB models)</li>
 *     <li>{@link #green()}, returns the green component value (or second
 *     component value in non-RGB models)</li>
 *     <li>{@link #blue()}, returns the blue component value (or third
 *     component value in non-RGB models)</li>
 *     <li>{@link #getComponent(int)}, returns a specific component value</li>
 *     <li>{@link #getComponents()}, returns all component values as an array</li>
 * </ul>
 *
 * <h3>Color space conversions</h3>
 * <p>You can convert colors from one color space to another using
 * {@link android.graphics.ColorSpace#connect(android.graphics.ColorSpace,android.graphics.ColorSpace) ColorSpace#connect(ColorSpace, ColorSpace)} and its variants. However,
 * the <code>Color</code> class provides a few convenience methods to simplify
 * the process. Here is a brief description of some of them:</p>
 * <ul>
 *     <li>{@link #convert(android.graphics.ColorSpace)} to convert a color instance in a color
 *     space to a new color instance in a different color space</li>
 *     <li>{@link #convert(float,float,float,float,android.graphics.ColorSpace,android.graphics.ColorSpace)} to
 *     convert a color from a source color space to a destination color space</li>
 *     <li>{@link #convert(long,android.graphics.ColorSpace)} to convert a color long from its
 *     built-in color space to a destination color space</li>
 *     <li>{@link #convert(int,android.graphics.ColorSpace)} to convert a color int from sRGB
 *     to a destination color space</li>
 * </ul>
 *
 * <p>Please refere to the {@link android.graphics.ColorSpace ColorSpace} documentation for more
 * information.</p>
 *
 * <h3>Alpha and transparency</h3>
 * <p>The alpha component of a color defines the level of transparency of a
 * color. When the alpha component is 0, the color is completely transparent.
 * When the alpha is component is 1 (in the \([0..1]\) range) or 255 (in the
 * \([0..255]\) range), the color is completely opaque.</p>
 *
 * <p>The color representations described above do not use pre-multiplied
 * color components (a pre-multiplied color component is a color component
 * that has been multiplied by the value of the alpha component).
 * For instance, the color int representation of opaque red is
 * <code>0xffff0000</code>. For semi-transparent (50%) red, the
 * representation becomes <code>0x80ff0000</code>. The equivalent color
 * instance representations would be <code>(1.0, 0.0, 0.0, 1.0)</code>
 * and <code>(1.0, 0.0, 0.0, 0.5)</code>.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Color {

/**
 * Creates a new color instance set to opaque black in the
 * {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} color space.
 *
 * @see #valueOf(float, float, float)
 * @see #valueOf(float, float, float, float)
 * @see #valueOf(float, float, float, float, ColorSpace)
 * @see #valueOf(float[], ColorSpace)
 * @see #valueOf(int)
 * @see #valueOf(long)
 * @apiSince 1
 */

public Color() { throw new RuntimeException("Stub!"); }

/**
 * Returns this color's color space.
 *
 * @return A non-null instance of {@link android.graphics.ColorSpace ColorSpace}
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.graphics.ColorSpace getColorSpace() { throw new RuntimeException("Stub!"); }

/**
 * Returns the color model of this color.
 *
 * @return A non-null {@link android.graphics.ColorSpace.Model ColorSpace.Model}
 * @apiSince 26
 */

public android.graphics.ColorSpace.Model getModel() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this color color is in a wide-gamut color space.
 * See {@link android.graphics.ColorSpace#isWideGamut() ColorSpace#isWideGamut()} for a definition of a wide-gamut
 * color space.
 *
 * @return True if this color is in a wide-gamut color space, false otherwise
 *
 * @see #isSrgb()
 * @see android.graphics.ColorSpace#isWideGamut()
 * @apiSince 26
 */

public boolean isWideGamut() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this color is in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB}
 * color space.
 *
 * @return True if this color is in the sRGB color space, false otherwise
 *
 * @see #isWideGamut()
 * @apiSince 26
 */

public boolean isSrgb() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of components that form a color value according
 * to this color space's color model, plus one extra component for
 * alpha.
 *
 * @return The integer 4 or 5
 
 * Value is between 4 and 5 inclusive
 * @apiSince 26
 */

public int getComponentCount() { throw new RuntimeException("Stub!"); }

/**
 * Packs this color into a color long. See the documentation of this class
 * for a description of the color long format.
 *
 * @return A color long
 *
 * @throws java.lang.IllegalArgumentException If this color's color space has the id
 * {@link android.graphics.ColorSpace#MIN_ID ColorSpace#MIN_ID} or if this color has more than 4 components
 * @apiSince 26
 */

public long pack() { throw new RuntimeException("Stub!"); }

/**
 * Converts this color from its color space to the specified color space.
 * The conversion is done using the default rendering intent as specified
 * by {@link android.graphics.ColorSpace#connect(android.graphics.ColorSpace,android.graphics.ColorSpace) ColorSpace#connect(ColorSpace, ColorSpace)}.
 *
 * @param colorSpace The destination color space, cannot be null
 *
 * This value must never be {@code null}.
 * @return A non-null color instance in the specified color space
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.graphics.Color convert(@androidx.annotation.NonNull android.graphics.ColorSpace colorSpace) { throw new RuntimeException("Stub!"); }

/**
 * Converts this color to an ARGB color int. A color int is always in
 * the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} color space. This implies
 * a color space conversion is applied if needed.
 *
 * @return An ARGB color in the sRGB color space
 * @apiSince 26
 */

public int toArgb() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the value of the red component in the range defined by this
 * color's color space (see {@link android.graphics.ColorSpace#getMinValue(int) ColorSpace#getMinValue(int)} and
 * {@link android.graphics.ColorSpace#getMaxValue(int) ColorSpace#getMaxValue(int)}).</p>
 *
 * <p>If this color's color model is not {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB},
 * calling this method is equivalent to <code>getComponent(0)</code>.</p>
 *
 * @see #alpha()
 * @see #red()
 * @see #green
 * @see #getComponents()
 * @apiSince 26
 */

public float red() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the value of the green component in the range defined by this
 * color's color space (see {@link android.graphics.ColorSpace#getMinValue(int) ColorSpace#getMinValue(int)} and
 * {@link android.graphics.ColorSpace#getMaxValue(int) ColorSpace#getMaxValue(int)}).</p>
 *
 * <p>If this color's color model is not {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB},
 * calling this method is equivalent to <code>getComponent(1)</code>.</p>
 *
 * @see #alpha()
 * @see #red()
 * @see #green
 * @see #getComponents()
 * @apiSince 26
 */

public float green() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the value of the blue component in the range defined by this
 * color's color space (see {@link android.graphics.ColorSpace#getMinValue(int) ColorSpace#getMinValue(int)} and
 * {@link android.graphics.ColorSpace#getMaxValue(int) ColorSpace#getMaxValue(int)}).</p>
 *
 * <p>If this color's color model is not {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB},
 * calling this method is equivalent to <code>getComponent(2)</code>.</p>
 *
 * @see #alpha()
 * @see #red()
 * @see #green
 * @see #getComponents()
 * @apiSince 26
 */

public float blue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the alpha component in the range \([0..1]\).
 * Calling this method is equivalent to
 * <code>getComponent(getComponentCount() - 1)</code>.
 *
 * @see #red()
 * @see #green()
 * @see #blue()
 * @see #getComponents()
 * @see #getComponent(int)
 * @apiSince 26
 */

public float alpha() { throw new RuntimeException("Stub!"); }

/**
 * Returns this color's components as a new array. The last element of the
 * array is always the alpha component.
 *
 * @return A new, non-null array whose size is equal to {@link #getComponentCount()}
 *
 * @see #getComponent(int)
 * @apiSince 26
 */

@androidx.annotation.NonNull
public float[] getComponents() { throw new RuntimeException("Stub!"); }

/**
 * Copies this color's components in the supplied array. The last element of the
 * array is always the alpha component.
 *
 * @param components An array of floats whose size must be at least
 *                  {@link #getComponentCount()}, can be null
 * This value may be {@code null}.
 * @return The array passed as a parameter if not null, or a new array of length
 *         {@link #getComponentCount()}
 *
 * @see #getComponent(int)
 *
 * @throws java.lang.IllegalArgumentException If the specified array's length is less than
 * {@link #getComponentCount()}
 * @apiSince 26
 */

@androidx.annotation.NonNull
public float[] getComponents(@androidx.annotation.Nullable float[] components) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the value of the specified component in the range defined by
 * this color's color space (see {@link android.graphics.ColorSpace#getMinValue(int) ColorSpace#getMinValue(int)} and
 * {@link android.graphics.ColorSpace#getMaxValue(int) ColorSpace#getMaxValue(int)}).</p>
 *
 * <p>If the requested component index is {@link #getComponentCount()},
 * this method returns the alpha component, always in the range
 * \([0..1]\).</p>
 *
 * @see #getComponents()
 *
 * @throws java.lang.ArrayIndexOutOfBoundsException If the specified component index
 * is < 0 or >= {@link #getComponentCount()}
 
 * @param component Value is between 0 and 4 inclusive
 * @apiSince 26
 */

public float getComponent(int component) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the relative luminance of this color.</p>
 *
 * <p>Based on the formula for relative luminance defined in WCAG 2.0,
 * W3C Recommendation 11 December 2008.</p>
 *
 * @return A value between 0 (darkest black) and 1 (lightest white)
 *
 * @throws java.lang.IllegalArgumentException If the this color's color space
 * does not use the {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB} color model
 * @apiSince 26
 */

public float luminance() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns a string representation of the object. This method returns
 * a string equal to the value of:</p>
 *
 * <pre class="prettyprint">
 * "Color(" + r + ", " + g + ", " + b + ", " + a +
 *         ", " + getColorSpace().getName + ')'
 * </pre>
 *
 * <p>For instance, the string representation of opaque black in the sRGB
 * color space is equal to the following value:</p>
 *
 * <pre>
 * Color(0.0, 0.0, 0.0, 1.0, sRGB IEC61966-2.1)
 * </pre>
 *
 * @return A non-null string representation of the object
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the color space encoded in the specified color long.
 *
 * @param color The color long whose color space to extract
 * @return A non-null color space instance
 * @throws java.lang.IllegalArgumentException If the encoded color space is invalid or unknown
 *
 * @see #red(long)
 * @see #green(long)
 * @see #blue(long)
 * @see #alpha(long)
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static android.graphics.ColorSpace colorSpace(long color) { throw new RuntimeException("Stub!"); }

/**
 * Returns the red component encoded in the specified color long.
 * The range of the returned value depends on the color space
 * associated with the specified color. The color space can be
 * queried by calling {@link #colorSpace(long)}.
 *
 * @param color The color long whose red channel to extract
 * @return A float value with a range defined by the specified color's
 * color space
 *
 * @see #colorSpace(long)
 * @see #green(long)
 * @see #blue(long)
 * @see #alpha(long)
 * @apiSince 26
 */

public static float red(long color) { throw new RuntimeException("Stub!"); }

/**
 * Returns the green component encoded in the specified color long.
 * The range of the returned value depends on the color space
 * associated with the specified color. The color space can be
 * queried by calling {@link #colorSpace(long)}.
 *
 * @param color The color long whose green channel to extract
 * @return A float value with a range defined by the specified color's
 * color space
 *
 * @see #colorSpace(long)
 * @see #red(long)
 * @see #blue(long)
 * @see #alpha(long)
 * @apiSince 26
 */

public static float green(long color) { throw new RuntimeException("Stub!"); }

/**
 * Returns the blue component encoded in the specified color long.
 * The range of the returned value depends on the color space
 * associated with the specified color. The color space can be
 * queried by calling {@link #colorSpace(long)}.
 *
 * @param color The color long whose blue channel to extract
 * @return A float value with a range defined by the specified color's
 * color space
 *
 * @see #colorSpace(long)
 * @see #red(long)
 * @see #green(long)
 * @see #alpha(long)
 * @apiSince 26
 */

public static float blue(long color) { throw new RuntimeException("Stub!"); }

/**
 * Returns the alpha component encoded in the specified color long.
 * The returned value is always in the range \([0..1]\).
 *
 * @param color The color long whose blue channel to extract
 * @return A float value in the range \([0..1]\)
 *
 * @see #colorSpace(long)
 * @see #red(long)
 * @see #green(long)
 * @see #blue(long)
 * @apiSince 26
 */

public static float alpha(long color) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the specified color is in the
 * {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} color space.
 *
 * @param color The color to test
 * @return True if the color is in the sRGB color space, false otherwise
 * @throws java.lang.IllegalArgumentException If the encoded color space is invalid or unknown
 *
 * @see #isInColorSpace(long, ColorSpace)
 * @see #isWideGamut(long)
 * @apiSince 26
 */

public static boolean isSrgb(long color) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the specified color is in a wide-gamut color space.
 * See {@link android.graphics.ColorSpace#isWideGamut() ColorSpace#isWideGamut()} for a definition of a wide-gamut
 * color space.
 *
 * @param color The color to test
 * @return True if the color is in a wide-gamut color space, false otherwise
 * @throws java.lang.IllegalArgumentException If the encoded color space is invalid or unknown
 *
 * @see #isInColorSpace(long, ColorSpace)
 * @see #isSrgb(long)
 * @see android.graphics.ColorSpace#isWideGamut()
 * @apiSince 26
 */

public static boolean isWideGamut(long color) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the specified color is in the specified color space.
 *
 * @param color The color to test
 * @param colorSpace The color space to test against
 * This value must never be {@code null}.
 * @return True if the color is in the specified color space, false otherwise
 *
 * @see #isSrgb(long)
 * @see #isWideGamut(long)
 * @apiSince 26
 */

public static boolean isInColorSpace(long color, @androidx.annotation.NonNull android.graphics.ColorSpace colorSpace) { throw new RuntimeException("Stub!"); }

/**
 * Converts the specified color long to an ARGB color int. A color int is
 * always in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} color space. This implies
 * a color space conversion is applied if needed.
 *
 * @return An ARGB color in the sRGB color space
 * @throws java.lang.IllegalArgumentException If the encoded color space is invalid or unknown
 * @apiSince 26
 */

public static int toArgb(long color) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>Color</code> instance from an ARGB color int.
 * The resulting color is in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB}
 * color space.
 *
 * @param color The ARGB color int to create a <code>Color</code> from
 * @return A non-null instance of {@link android.graphics.Color Color}
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static android.graphics.Color valueOf(int color) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>Color</code> instance from a color long.
 * The resulting color is in the same color space as the specified color long.
 *
 * @param color The color long to create a <code>Color</code> from
 * @return A non-null instance of {@link android.graphics.Color Color}
 * @throws java.lang.IllegalArgumentException If the encoded color space is invalid or unknown
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static android.graphics.Color valueOf(long color) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new opaque <code>Color</code> in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB}
 * color space with the specified red, green and blue component values. The component
 * values must be in the range \([0..1]\).
 *
 * @param r The red component of the opaque sRGB color to create, in \([0..1]\)
 * @param g The green component of the opaque sRGB color to create, in \([0..1]\)
 * @param b The blue component of the opaque sRGB color to create, in \([0..1]\)
 * @return A non-null instance of {@link android.graphics.Color Color}
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static android.graphics.Color valueOf(float r, float g, float b) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>Color</code> in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB}
 * color space with the specified red, green, blue and alpha component values.
 * The component values must be in the range \([0..1]\).
 *
 * @param r The red component of the sRGB color to create, in \([0..1]\)
 * @param g The green component of the sRGB color to create, in \([0..1]\)
 * @param b The blue component of the sRGB color to create, in \([0..1]\)
 * @param a The alpha component of the sRGB color to create, in \([0..1]\)
 * @return A non-null instance of {@link android.graphics.Color Color}
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static android.graphics.Color valueOf(float r, float g, float b, float a) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>Color</code> in the specified color space with the
 * specified red, green, blue and alpha component values. The range of the
 * components is defined by {@link android.graphics.ColorSpace#getMinValue(int) ColorSpace#getMinValue(int)} and
 * {@link android.graphics.ColorSpace#getMaxValue(int) ColorSpace#getMaxValue(int)}. The values passed to this method
 * must be in the proper range.
 *
 * @param r The red component of the color to create
 * @param g The green component of the color to create
 * @param b The blue component of the color to create
 * @param a The alpha component of the color to create, in \([0..1]\)
 * @param colorSpace The color space of the color to create
 * This value must never be {@code null}.
 * @return A non-null instance of {@link android.graphics.Color Color}
 *
 * @throws java.lang.IllegalArgumentException If the specified color space uses a
 * color model with more than 3 components
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static android.graphics.Color valueOf(float r, float g, float b, float a, @androidx.annotation.NonNull android.graphics.ColorSpace colorSpace) { throw new RuntimeException("Stub!"); }

/**
 * <p>Creates a new <code>Color</code> in the specified color space with the
 * specified component values. The range of the components is defined by
 * {@link android.graphics.ColorSpace#getMinValue(int) ColorSpace#getMinValue(int)} and {@link android.graphics.ColorSpace#getMaxValue(int) ColorSpace#getMaxValue(int)}.
 * The values passed to this method must be in the proper range. The alpha
 * component is always in the range \([0..1]\).</p>
 *
 * <p>The length of the array of components must be at least
 * <code>{@link android.graphics.ColorSpace#getComponentCount() ColorSpace#getComponentCount()} + 1</code>. The component at index
 * {@link android.graphics.ColorSpace#getComponentCount() ColorSpace#getComponentCount()} is always alpha.</p>
 *
 * @param components The components of the color to create, with alpha as the last component
 * This value must never be {@code null}.
 * @param colorSpace The color space of the color to create
 * This value must never be {@code null}.
 * @return A non-null instance of {@link android.graphics.Color Color}
 *
 * @throws java.lang.IllegalArgumentException If the array of components is smaller than
 * required by the color space
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static android.graphics.Color valueOf(@androidx.annotation.NonNull float[] components, @androidx.annotation.NonNull android.graphics.ColorSpace colorSpace) { throw new RuntimeException("Stub!"); }

/**
 * Converts the specified ARGB color int to an RGBA color long in the sRGB
 * color space. See the documentation of this class for a description of
 * the color long format.
 *
 * @param color The ARGB color int to convert to an RGBA color long in sRGB
 *
 * @return A color long
 * @apiSince 26
 */

public static long pack(int color) { throw new RuntimeException("Stub!"); }

/**
 * Packs the sRGB color defined by the specified red, green and blue component
 * values into an RGBA color long in the sRGB color space. The alpha component
 * is set to 1.0. See the documentation of this class for a description of the
 * color long format.
 *
 * @param red The red component of the sRGB color to create, in \([0..1]\)
 * @param green The green component of the sRGB color to create, in \([0..1]\)
 * @param blue The blue component of the sRGB color to create, in \([0..1]\)
 *
 * @return A color long
 * @apiSince 26
 */

public static long pack(float red, float green, float blue) { throw new RuntimeException("Stub!"); }

/**
 * Packs the sRGB color defined by the specified red, green, blue and alpha
 * component values into an RGBA color long in the sRGB color space. See the
 * documentation of this class for a description of the color long format.
 *
 * @param red The red component of the sRGB color to create, in \([0..1]\)
 * @param green The green component of the sRGB color to create, in \([0..1]\)
 * @param blue The blue component of the sRGB color to create, in \([0..1]\)
 * @param alpha The alpha component of the sRGB color to create, in \([0..1]\)
 *
 * @return A color long
 * @apiSince 26
 */

public static long pack(float red, float green, float blue, float alpha) { throw new RuntimeException("Stub!"); }

/**
 * <p>Packs the 3 component color defined by the specified red, green, blue and
 * alpha component values into a color long in the specified color space. See the
 * documentation of this class for a description of the color long format.</p>
 *
 * <p>The red, green and blue components must be in the range defined by the
 * specified color space. See {@link android.graphics.ColorSpace#getMinValue(int) ColorSpace#getMinValue(int)} and
 * {@link android.graphics.ColorSpace#getMaxValue(int) ColorSpace#getMaxValue(int)}.</p>
 *
 * @param red The red component of the color to create
 * @param green The green component of the color to create
 * @param blue The blue component of the color to create
 * @param alpha The alpha component of the color to create, in \([0..1]\)
 *
 * @param colorSpace This value must never be {@code null}.
 * @return A color long
 *
 * @throws java.lang.IllegalArgumentException If the color space's id is {@link android.graphics.ColorSpace#MIN_ID ColorSpace#MIN_ID}
 * or if the color space's color model has more than 3 components
 * @apiSince 26
 */

public static long pack(float red, float green, float blue, float alpha, @androidx.annotation.NonNull android.graphics.ColorSpace colorSpace) { throw new RuntimeException("Stub!"); }

/**
 * Converts the specified ARGB color int from the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB}
 * color space into the specified destination color space. The resulting color is
 * returned as a color long. See the documentation of this class for a description
 * of the color long format.
 *
 * @param color The sRGB color int to convert
 * @param colorSpace The destination color space
 * This value must never be {@code null}.
 * @return A color long in the destination color space
 * @apiSince 26
 */

public static long convert(int color, @androidx.annotation.NonNull android.graphics.ColorSpace colorSpace) { throw new RuntimeException("Stub!"); }

/**
 * <p>Converts the specified color long from its color space into the specified
 * destination color space. The resulting color is returned as a color long. See
 * the documentation of this class for a description of the color long format.</p>
 *
 * <p>When converting several colors in a row, it is recommended to use
 * {@link #convert(long,android.graphics.ColorSpace.Connector)} instead to
 * avoid the creation of a {@link android.graphics.ColorSpace.Connector ColorSpace.Connector} on every invocation.</p>
 *
 * @param color The color long to convert
 * @param colorSpace The destination color space
 * This value must never be {@code null}.
 * @return A color long in the destination color space
 * @throws java.lang.IllegalArgumentException If the encoded color space is invalid or unknown
 * @apiSince 26
 */

public static long convert(long color, @androidx.annotation.NonNull android.graphics.ColorSpace colorSpace) { throw new RuntimeException("Stub!"); }

/**
 * <p>Converts the specified 3 component color from the source color space to the
 * destination color space. The resulting color is returned as a color long. See
 * the documentation of this class for a description of the color long format.</p>
 *
 * <p>When converting multiple colors in a row, it is recommended to use
 * {@link #convert(float,float,float,float,android.graphics.ColorSpace.Connector)} instead to
 * avoid the creation of a {@link android.graphics.ColorSpace.Connector ColorSpace.Connector} on every invocation.</p>
 *
 * <p>The red, green and blue components must be in the range defined by the
 * specified color space. See {@link android.graphics.ColorSpace#getMinValue(int) ColorSpace#getMinValue(int)} and
 * {@link android.graphics.ColorSpace#getMaxValue(int) ColorSpace#getMaxValue(int)}.</p>
 *
 * @param r The red component of the color to convert
 * @param g The green component of the color to convert
 * @param b The blue component of the color to convert
 * @param a The alpha component of the color to convert, in \([0..1]\)
 * @param source The source color space, cannot be null
 * This value must never be {@code null}.
 * @param destination The destination color space, cannot be null
 * This value must never be {@code null}.
 * @return A color long in the destination color space
 *
 * @see #convert(float, float, float, float, ColorSpace.Connector)
 * @apiSince 26
 */

public static long convert(float r, float g, float b, float a, @androidx.annotation.NonNull android.graphics.ColorSpace source, @androidx.annotation.NonNull android.graphics.ColorSpace destination) { throw new RuntimeException("Stub!"); }

/**
 * <p>Converts the specified color long from a color space to another using the
 * specified color space {@link android.graphics.ColorSpace.Connector ColorSpace.Connector}. The resulting
 * color is returned as a color long. See the documentation of this class for a
 * description of the color long format.</p>
 *
 * <p>When converting several colors in a row, this method is preferable to
 * {@link #convert(long,android.graphics.ColorSpace)} as it prevents a new connector from being
 * created on every invocation.</p>
 *
 * <p class="note">The connector's source color space should match the color long's
 * color space.</p>
 *
 * @param color The color long to convert
 * @param connector A color space connector, cannot be null
 * This value must never be {@code null}.
 * @return A color long in the destination color space of the connector
 * @apiSince 26
 */

public static long convert(long color, @androidx.annotation.NonNull android.graphics.ColorSpace.Connector connector) { throw new RuntimeException("Stub!"); }

/**
 * <p>Converts the specified 3 component color from a color space to another using
 * the specified color space {@link android.graphics.ColorSpace.Connector ColorSpace.Connector}. The resulting
 * color is returned as a color long. See the documentation of this class for a
 * description of the color long format.</p>
 *
 * <p>When converting several colors in a row, this method is preferable to
 * {@link #convert(float,float,float,float,android.graphics.ColorSpace,android.graphics.ColorSpace)} as
 * it prevents a new connector from being created on every invocation.</p>
 *
 * <p>The red, green and blue components must be in the range defined by the
 * source color space of the connector. See {@link android.graphics.ColorSpace#getMinValue(int) ColorSpace#getMinValue(int)}
 * and {@link android.graphics.ColorSpace#getMaxValue(int) ColorSpace#getMaxValue(int)}.</p>
 *
 * @param r The red component of the color to convert
 * @param g The green component of the color to convert
 * @param b The blue component of the color to convert
 * @param a The alpha component of the color to convert, in \([0..1]\)
 * @param connector A color space connector, cannot be null
 * This value must never be {@code null}.
 * @return A color long in the destination color space of the connector
 *
 * @see #convert(float, float, float, float, ColorSpace, ColorSpace)
 * @apiSince 26
 */

public static long convert(float r, float g, float b, float a, @androidx.annotation.NonNull android.graphics.ColorSpace.Connector connector) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the relative luminance of a color.</p>
 *
 * <p>Based on the formula for relative luminance defined in WCAG 2.0,
 * W3C Recommendation 11 December 2008.</p>
 *
 * @return A value between 0 (darkest black) and 1 (lightest white)
 *
 * @throws java.lang.IllegalArgumentException If the specified color's color space
 * is unknown or does not use the {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB} color model
 * @apiSince 26
 */

public static float luminance(long color) { throw new RuntimeException("Stub!"); }

/**
 * Return the alpha component of a color int. This is the same as saying
 * color >>> 24
 
 * @return Value is between 0 and 255 inclusive
 * @apiSince 1
 */

public static int alpha(int color) { throw new RuntimeException("Stub!"); }

/**
 * Return the red component of a color int. This is the same as saying
 * (color >> 16) & 0xFF
 
 * @return Value is between 0 and 255 inclusive
 * @apiSince 1
 */

public static int red(int color) { throw new RuntimeException("Stub!"); }

/**
 * Return the green component of a color int. This is the same as saying
 * (color >> 8) & 0xFF
 
 * @return Value is between 0 and 255 inclusive
 * @apiSince 1
 */

public static int green(int color) { throw new RuntimeException("Stub!"); }

/**
 * Return the blue component of a color int. This is the same as saying
 * color & 0xFF
 
 * @return Value is between 0 and 255 inclusive
 * @apiSince 1
 */

public static int blue(int color) { throw new RuntimeException("Stub!"); }

/**
 * Return a color-int from red, green, blue components.
 * The alpha component is implicitly 255 (fully opaque).
 * These component values should be \([0..255]\), but there is no
 * range check performed, so if they are out of range, the
 * returned color is undefined.
 *
 * @param red  Red component \([0..255]\) of the color
 * Value is between 0 and 255 inclusive
 * @param green Green component \([0..255]\) of the color
 * Value is between 0 and 255 inclusive
 * @param blue  Blue component \([0..255]\) of the color
 
 * Value is between 0 and 255 inclusive
 * @apiSince 1
 */

public static int rgb(int red, int green, int blue) { throw new RuntimeException("Stub!"); }

/**
 * Return a color-int from red, green, blue float components
 * in the range \([0..1]\). The alpha component is implicitly
 * 1.0 (fully opaque). If the components are out of range, the
 * returned color is undefined.
 *
 * @param red Red component \([0..1]\) of the color
 * @param green Green component \([0..1]\) of the color
 * @param blue Blue component \([0..1]\) of the color
 * @apiSince 26
 */

public static int rgb(float red, float green, float blue) { throw new RuntimeException("Stub!"); }

/**
 * Return a color-int from alpha, red, green, blue components.
 * These component values should be \([0..255]\), but there is no
 * range check performed, so if they are out of range, the
 * returned color is undefined.
 * @param alpha Alpha component \([0..255]\) of the color
 * Value is between 0 and 255 inclusive
 * @param red Red component \([0..255]\) of the color
 * Value is between 0 and 255 inclusive
 * @param green Green component \([0..255]\) of the color
 * Value is between 0 and 255 inclusive
 * @param blue Blue component \([0..255]\) of the color
 
 * Value is between 0 and 255 inclusive
 * @apiSince 1
 */

public static int argb(int alpha, int red, int green, int blue) { throw new RuntimeException("Stub!"); }

/**
 * Return a color-int from alpha, red, green, blue float components
 * in the range \([0..1]\). If the components are out of range, the
 * returned color is undefined.
 *
 * @param alpha Alpha component \([0..1]\) of the color
 * @param red Red component \([0..1]\) of the color
 * @param green Green component \([0..1]\) of the color
 * @param blue Blue component \([0..1]\) of the color
 * @apiSince 26
 */

public static int argb(float alpha, float red, float green, float blue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the relative luminance of a color.
 * <p>
 * Assumes sRGB encoding. Based on the formula for relative luminance
 * defined in WCAG 2.0, W3C Recommendation 11 December 2008.
 *
 * @return a value between 0 (darkest black) and 1 (lightest white)
 * @apiSince 24
 */

public static float luminance(int color) { throw new RuntimeException("Stub!"); }

/**
 * </p>Parse the color string, and return the corresponding color-int.
 * If the string cannot be parsed, throws an IllegalArgumentException
 * exception. Supported formats are:</p>
 *
 * <ul>
 *   <li><code>#RRGGBB</code></li>
 *   <li><code>#AARRGGBB</code></li>
 * </ul>
 *
 * <p>The following names are also accepted: <code>red</code>, <code>blue</code>,
 * <code>green</code>, <code>black</code>, <code>white</code>, <code>gray</code>,
 * <code>cyan</code>, <code>magenta</code>, <code>yellow</code>, <code>lightgray</code>,
 * <code>darkgray</code>, <code>grey</code>, <code>lightgrey</code>, <code>darkgrey</code>,
 * <code>aqua</code>, <code>fuchsia</code>, <code>lime</code>, <code>maroon</code>,
 * <code>navy</code>, <code>olive</code>, <code>purple</code>, <code>silver</code>,
 * and <code>teal</code>.</p>
 * @apiSince 1
 */

public static int parseColor(java.lang.String colorString) { throw new RuntimeException("Stub!"); }

/**
 * Convert RGB components to HSV.
 * <ul>
 *   <li><code>hsv[0]</code> is Hue \([0..360[\)</li>
 *   <li><code>hsv[1]</code> is Saturation \([0...1]\)</li>
 *   <li><code>hsv[2]</code> is Value \([0...1]\)</li>
 * </ul>
 * @param red  red component value \([0..255]\)
 * Value is between 0 and 255 inclusive
 * @param green  green component value \([0..255]\)
 * Value is between 0 and 255 inclusive
 * @param blue  blue component value \([0..255]\)
 * Value is between 0 and 255 inclusive
 * @param hsv  3 element array which holds the resulting HSV components.
 * @apiSince 1
 */

public static void RGBToHSV(int red, int green, int blue, float[] hsv) { throw new RuntimeException("Stub!"); }

/**
 * Convert the ARGB color to its HSV components.
 * <ul>
 *   <li><code>hsv[0]</code> is Hue \([0..360[\)</li>
 *   <li><code>hsv[1]</code> is Saturation \([0...1]\)</li>
 *   <li><code>hsv[2]</code> is Value \([0...1]\)</li>
 * </ul>
 * @param color the argb color to convert. The alpha component is ignored.
 * @param hsv  3 element array which holds the resulting HSV components.
 * @apiSince 1
 */

public static void colorToHSV(int color, float[] hsv) { throw new RuntimeException("Stub!"); }

/**
 * Convert HSV components to an ARGB color. Alpha set to 0xFF.
 * <ul>
 *   <li><code>hsv[0]</code> is Hue \([0..360[\)</li>
 *   <li><code>hsv[1]</code> is Saturation \([0...1]\)</li>
 *   <li><code>hsv[2]</code> is Value \([0...1]\)</li>
 * </ul>
 * If hsv values are out of range, they are pinned.
 * @param hsv  3 element array which holds the input HSV components.
 * @return the resulting argb color
 * @apiSince 1
 */

public static int HSVToColor(float[] hsv) { throw new RuntimeException("Stub!"); }

/**
 * Convert HSV components to an ARGB color. The alpha component is passed
 * through unchanged.
 * <ul>
 *   <li><code>hsv[0]</code> is Hue \([0..360[\)</li>
 *   <li><code>hsv[1]</code> is Saturation \([0...1]\)</li>
 *   <li><code>hsv[2]</code> is Value \([0...1]\)</li>
 * </ul>
 * If hsv values are out of range, they are pinned.
 * @param alpha the alpha component of the returned argb color.
 * Value is between 0 and 255 inclusive
 * @param hsv  3 element array which holds the input HSV components.
 * @return the resulting argb color
 * @apiSince 1
 */

public static int HSVToColor(int alpha, float[] hsv) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static final int BLACK = -16777216; // 0xff000000

/** @apiSince 1 */

public static final int BLUE = -16776961; // 0xff0000ff

/** @apiSince 1 */

public static final int CYAN = -16711681; // 0xff00ffff

/** @apiSince 1 */

public static final int DKGRAY = -12303292; // 0xff444444

/** @apiSince 1 */

public static final int GRAY = -7829368; // 0xff888888

/** @apiSince 1 */

public static final int GREEN = -16711936; // 0xff00ff00

/** @apiSince 1 */

public static final int LTGRAY = -3355444; // 0xffcccccc

/** @apiSince 1 */

public static final int MAGENTA = -65281; // 0xffff00ff

/** @apiSince 1 */

public static final int RED = -65536; // 0xffff0000

/** @apiSince 1 */

public static final int TRANSPARENT = 0; // 0x0

/** @apiSince 1 */

public static final int WHITE = -1; // 0xffffffff

/** @apiSince 1 */

public static final int YELLOW = -256; // 0xffffff00
}

