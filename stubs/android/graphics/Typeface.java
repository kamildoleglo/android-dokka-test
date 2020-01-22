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

import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;

/**
 * The Typeface class specifies the typeface and intrinsic style of a font.
 * This is used in the paint, along with optionally Paint settings like
 * textSize, textSkewX, textScaleX to specify
 * how text appears when drawn (and measured).
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Typeface {

private Typeface() { throw new RuntimeException("Stub!"); }

/**
 * Returns the typeface's weight value
 * @return Value is between 0 and 1000 inclusive
 * @apiSince 28
 */

public int getWeight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the typeface's intrinsic style attributes
 * @return Value is {@link android.graphics.Typeface#NORMAL}, {@link android.graphics.Typeface#BOLD}, {@link android.graphics.Typeface#ITALIC}, or {@link android.graphics.Typeface#BOLD_ITALIC}
 * @apiSince 1
 */

public int getStyle() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if getStyle() has the BOLD bit set.
 * @apiSince 1
 */

public final boolean isBold() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if getStyle() has the ITALIC bit set.
 * @apiSince 1
 */

public final boolean isItalic() { throw new RuntimeException("Stub!"); }

/**
 * Create a typeface object given a family name, and option style information.
 * If null is passed for the name, then the "default" font will be chosen.
 * The resulting typeface object can be queried (getStyle()) to discover what
 * its "real" style characteristics are.
 *
 * @param familyName May be null. The name of the font family.
 * @param style  The style (normal, bold, italic) of the typeface.
 *               e.g. NORMAL, BOLD, ITALIC, BOLD_ITALIC
 * Value is {@link android.graphics.Typeface#NORMAL}, {@link android.graphics.Typeface#BOLD}, {@link android.graphics.Typeface#ITALIC}, or {@link android.graphics.Typeface#BOLD_ITALIC}
 * @return The best matching typeface.
 * @apiSince 1
 */

public static android.graphics.Typeface create(java.lang.String familyName, int style) { throw new RuntimeException("Stub!"); }

/**
 * Create a typeface object that best matches the specified existing
 * typeface and the specified Style. Use this call if you want to pick a new
 * style from the same family of an existing typeface object. If family is
 * null, this selects from the default font's family.
 *
 * <p>
 * This method is not thread safe on API 27 or before.
 * This method is thread safe on API 28 or after.
 * </p>
 *
 * @param family An existing {@link android.graphics.Typeface Typeface} object. In case of {@code null}, the default
 *               typeface is used instead.
 * @param style  The style (normal, bold, italic) of the typeface.
 *               e.g. NORMAL, BOLD, ITALIC, BOLD_ITALIC
 * Value is {@link android.graphics.Typeface#NORMAL}, {@link android.graphics.Typeface#BOLD}, {@link android.graphics.Typeface#ITALIC}, or {@link android.graphics.Typeface#BOLD_ITALIC}
 * @return The best matching typeface.
 * @apiSince 1
 */

public static android.graphics.Typeface create(android.graphics.Typeface family, int style) { throw new RuntimeException("Stub!"); }

/**
 * Creates a typeface object that best matches the specified existing typeface and the specified
 * weight and italic style
 * <p>Below are numerical values and corresponding common weight names.</p>
 * <table>
 * <thead>
 * <tr><th>Value</th><th>Common weight name</th></tr>
 * </thead>
 * <tbody>
 * <tr><td>100</td><td>Thin</td></tr>
 * <tr><td>200</td><td>Extra Light</td></tr>
 * <tr><td>300</td><td>Light</td></tr>
 * <tr><td>400</td><td>Normal</td></tr>
 * <tr><td>500</td><td>Medium</td></tr>
 * <tr><td>600</td><td>Semi Bold</td></tr>
 * <tr><td>700</td><td>Bold</td></tr>
 * <tr><td>800</td><td>Extra Bold</td></tr>
 * <tr><td>900</td><td>Black</td></tr>
 * </tbody>
 * </table>
 *
 * <p>
 * This method is thread safe.
 * </p>
 *
 * @param family An existing {@link android.graphics.Typeface Typeface} object. In case of {@code null}, the default
 *               typeface is used instead.
 * This value may be {@code null}.
 * @param weight The desired weight to be drawn.
 * Value is between 1 and 1000 inclusive
 * @param italic {@code true} if italic style is desired to be drawn. Otherwise, {@code false}
 * @return A {@link android.graphics.Typeface Typeface} object for drawing specified weight and italic style. Never
 *         returns {@code null}
 *
 * @see #getWeight()
 * @see #isItalic()
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.graphics.Typeface create(@androidx.annotation.Nullable android.graphics.Typeface family, int weight, boolean italic) { throw new RuntimeException("Stub!"); }

/**
 * Returns one of the default typeface objects, based on the specified style
 *
 * @param style Value is {@link android.graphics.Typeface#NORMAL}, {@link android.graphics.Typeface#BOLD}, {@link android.graphics.Typeface#ITALIC}, or {@link android.graphics.Typeface#BOLD_ITALIC}
 * @return the default typeface that corresponds to the style
 * @apiSince 1
 */

public static android.graphics.Typeface defaultFromStyle(int style) { throw new RuntimeException("Stub!"); }

/**
 * Create a new typeface from the specified font data.
 *
 * @param mgr  The application's asset manager
 * @param path The file name of the font data in the assets directory
 * @return The new typeface.
 * @apiSince 1
 */

public static android.graphics.Typeface createFromAsset(android.content.res.AssetManager mgr, java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Create a new typeface from the specified font file.
 *
 * @param file The path to the font data.
 * This value may be {@code null}.
 * @return The new typeface.
 * @apiSince 4
 */

public static android.graphics.Typeface createFromFile(@androidx.annotation.Nullable java.io.File file) { throw new RuntimeException("Stub!"); }

/**
 * Create a new typeface from the specified font file.
 *
 * @param path The full path to the font data.
 * This value may be {@code null}.
 * @return The new typeface.
 * @apiSince 4
 */

public static android.graphics.Typeface createFromFile(@androidx.annotation.Nullable java.lang.String path) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static final int BOLD = 1; // 0x1

/** @apiSince 1 */

public static final int BOLD_ITALIC = 3; // 0x3

/**
 * The default NORMAL typeface object
 * @apiSince 1
 */

public static final android.graphics.Typeface DEFAULT;
static { DEFAULT = null; }

/**
 * The default BOLD typeface object. Note: this may be not actually be
 * bold, depending on what fonts are installed. Call getStyle() to know
 * for sure.
 * @apiSince 1
 */

public static final android.graphics.Typeface DEFAULT_BOLD;
static { DEFAULT_BOLD = null; }

/** @apiSince 1 */

public static final int ITALIC = 2; // 0x2

/**
 * The NORMAL style of the default monospace typeface.
 * @apiSince 1
 */

public static final android.graphics.Typeface MONOSPACE;
static { MONOSPACE = null; }

/** @apiSince 1 */

public static final int NORMAL = 0; // 0x0

/**
 * The NORMAL style of the default sans serif typeface.
 * @apiSince 1
 */

public static final android.graphics.Typeface SANS_SERIF;
static { SANS_SERIF = null; }

/**
 * The NORMAL style of the default serif typeface.
 * @apiSince 1
 */

public static final android.graphics.Typeface SERIF;
static { SERIF = null; }
/**
 * A builder class for creating new Typeface instance.
 *
 * <p>
 * Examples,
 * 1) Create Typeface from ttf file.
 * <pre>
 * <code>
 * Typeface.Builder buidler = new Typeface.Builder("your_font_file.ttf");
 * Typeface typeface = builder.build();
 * </code>
 * </pre>
 *
 * 2) Create Typeface from ttc file in assets directory.
 * <pre>
 * <code>
 * Typeface.Builder buidler = new Typeface.Builder(getAssets(), "your_font_file.ttc");
 * builder.setTtcIndex(2);  // Set index of font collection.
 * Typeface typeface = builder.build();
 * </code>
 * </pre>
 *
 * 3) Create Typeface with variation settings.
 * <pre>
 * <code>
 * Typeface.Builder buidler = new Typeface.Builder("your_font_file.ttf");
 * builder.setFontVariationSettings("'wght' 700, 'slnt' 20, 'ital' 1");
 * builder.setWeight(700);  // Tell the system that this is a bold font.
 * builder.setItalic(true);  // Tell the system that this is an italic style font.
 * Typeface typeface = builder.build();
 * </code>
 * </pre>
 * </p>
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Constructs a builder with a file path.
 *
 * @param path The file object refers to the font file.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public Builder(@androidx.annotation.NonNull java.io.File path) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a builder with a file descriptor.
 *
 * Caller is responsible for closing the passed file descriptor after {@link #build} is
 * called.
 *
 * @param fd The file descriptor. The passed fd must be mmap-able.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public Builder(@androidx.annotation.NonNull java.io.FileDescriptor fd) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a builder with a file path.
 *
 * @param path The full path to the font file.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public Builder(@androidx.annotation.NonNull java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a builder from an asset manager and a file path in an asset directory.
 *
 * @param assetManager The application's asset manager
 * This value must never be {@code null}.
 * @param path The file name of the font data in the asset directory
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public Builder(@androidx.annotation.NonNull android.content.res.AssetManager assetManager, @androidx.annotation.NonNull java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Sets weight of the font.
 *
 * Tells the system the weight of the given font. If not provided, the system will resolve
 * the weight value by reading font tables.
 * @param weight a weight value.
 
 * Value is between 1 and 1000 inclusive
 * @apiSince 26
 */

public android.graphics.Typeface.Builder setWeight(int weight) { throw new RuntimeException("Stub!"); }

/**
 * Sets italic information of the font.
 *
 * Tells the system the style of the given font. If not provided, the system will resolve
 * the style by reading font tables.
 * @param italic {@code true} if the font is italic. Otherwise {@code false}.
 * @apiSince 26
 */

public android.graphics.Typeface.Builder setItalic(boolean italic) { throw new RuntimeException("Stub!"); }

/**
 * Sets an index of the font collection. See {@link android.R.attr#ttcIndex}.
 *
 * Can not be used for Typeface source. build() method will return null for invalid index.
 * @param ttcIndex An index of the font collection. If the font source is not font
 *                 collection, do not call this method or specify 0.
 
 * Value is 0 or greater
 * @apiSince 26
 */

public android.graphics.Typeface.Builder setTtcIndex(int ttcIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sets a font variation settings.
 *
 * @param variationSettings See {@link android.widget.TextView#setFontVariationSettings}.
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException If given string is not a valid font variation settings
 *                                  format.
 * @apiSince 26
 */

public android.graphics.Typeface.Builder setFontVariationSettings(@androidx.annotation.Nullable java.lang.String variationSettings) { throw new RuntimeException("Stub!"); }

/**
 * Sets a font variation settings.
 *
 * @param axes An array of font variation axis tag-value pairs.
 
 * This value may be {@code null}.
 * @apiSince 26
 */

public android.graphics.Typeface.Builder setFontVariationSettings(@androidx.annotation.Nullable android.graphics.fonts.FontVariationAxis[] axes) { throw new RuntimeException("Stub!"); }

/**
 * Sets a fallback family name.
 *
 * By specifying a fallback family name, a fallback Typeface will be returned if the
 * {@link #build} method fails to create a Typeface from the provided font. The fallback
 * family will be resolved with the provided weight and italic information specified by
 * {@link #setWeight} and {@link #setItalic}.
 *
 * If {@link #setWeight} is not called, the fallback family keeps the default weight.
 * Similary, if {@link #setItalic} is not called, the fallback family keeps the default
 * italic information. For example, calling {@code builder.setFallback("sans-serif-light")}
 * is equivalent to calling {@code builder.setFallback("sans-serif").setWeight(300)} in
 * terms of fallback. The default weight and italic information are overridden by calling
 * {@link #setWeight} and {@link #setItalic}. For example, if a Typeface is constructed
 * using {@code builder.setFallback("sans-serif-light").setWeight(700)}, the fallback text
 * will render as sans serif bold.
 *
 * @param familyName A family name to be used for fallback if the provided font can not be
 *                   used. By passing {@code null}, build() returns {@code null}.
 *                   If {@link #setFallback} is not called on the builder, {@code null}
 *                   is assumed.
 
 * This value may be {@code null}.
 * @apiSince 26
 */

public android.graphics.Typeface.Builder setFallback(@androidx.annotation.Nullable java.lang.String familyName) { throw new RuntimeException("Stub!"); }

/**
 * Generates new Typeface from specified configuration.
 *
 * @return Newly created Typeface. May return null if some parameters are invalid.
 * @apiSince 26
 */

public android.graphics.Typeface build() { throw new RuntimeException("Stub!"); }
}

/**
 * A builder class for creating new Typeface instance.
 *
 * There are two font fallback mechanisms, custom font fallback and system font fallback.
 * The custom font fallback is a simple ordered list. The text renderer tries to see if it can
 * render a character with the first font and if that font does not support the character, try
 * next one and so on. It will keep trying until end of the custom fallback chain. The maximum
 * length of the custom fallback chain is 64.
 * The system font fallback is a system pre-defined fallback chain. The system fallback is
 * processed only when no matching font is found in the custom font fallback.
 *
 * <p>
 * Examples,
 * 1) Create Typeface from single ttf file.
 * <pre>
 * <code>
 * Font font = new Font.Builder("your_font_file.ttf").build();
 * FontFamily family = new FontFamily.Builder(font).build();
 * Typeface typeface = new Typeface.CustomFallbackBuilder(family).build();
 * </code>
 * </pre>
 *
 * 2) Create Typeface from multiple font files and select bold style by default.
 * <pre>
 * <code>
 * Font regularFont = new Font.Builder("regular.ttf").build();
 * Font boldFont = new Font.Builder("bold.ttf").build();
 * FontFamily family = new FontFamily.Builder(regularFont)
 *     .addFont(boldFont).build();
 * Typeface typeface = new Typeface.CustomFallbackBuilder(family)
 *     .setWeight(Font.FONT_WEIGHT_BOLD)  // Set bold style as the default style.
 *                                        // If the font family doesn't have bold style font,
 *                                        // system will select the closest font.
 *     .build();
 * </code>
 * </pre>
 *
 * 3) Create Typeface from single ttf file and if that font does not have glyph for the
 * characters, use "serif" font family instead.
 * <pre>
 * <code>
 * Font font = new Font.Builder("your_font_file.ttf").build();
 * FontFamily family = new FontFamily.Builder(font).build();
 * Typeface typeface = new Typeface.CustomFallbackBuilder(family)
 *     .setSystemFallback("serif")  // Set serif font family as the fallback.
 *     .build();
 * </code>
 * </pre>
 * 4) Create Typeface from single ttf file and set another ttf file for the fallback.
 * <pre>
 * <code>
 * Font font = new Font.Builder("English.ttf").build();
 * FontFamily family = new FontFamily.Builder(font).build();
 *
 * Font fallbackFont = new Font.Builder("Arabic.ttf").build();
 * FontFamily fallbackFamily = new FontFamily.Builder(fallbackFont).build();
 * Typeface typeface = new Typeface.CustomFallbackBuilder(family)
 *     .addCustomFallback(fallbackFamily)  // Specify fallback family.
 *     .setSystemFallback("serif")  // Set serif font family as the fallback.
 *     .build();
 * </code>
 * </pre>
 * </p>
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CustomFallbackBuilder {

/**
 * Constructs a builder with a font family.
 *
 * @param family a family object
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public CustomFallbackBuilder(@androidx.annotation.NonNull android.graphics.fonts.FontFamily family) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum capacity of custom fallback families.
 *
 * This includes the the first font family passed to the constructor.
 * It is guaranteed that the value will be greater than or equal to 64.
 *
 * @return the maximum number of font families for the custom fallback
 
 * Value is 64 or greater
 * @apiSince 29
 */

public static int getMaxCustomFallbackCount() { throw new RuntimeException("Stub!"); }

/**
 * Sets a system fallback by name.
 *
 * You can specify generic font familiy names or OEM specific family names. If the system
 * don't have a specified fallback, the default fallback is used instead.
 * For more information about generic font families, see <a
 * href="https://www.w3.org/TR/css-fonts-4/#generic-font-families">CSS specification</a>
 *
 * For more information about fallback, see class description.
 *
 * @param familyName a family name to be used for fallback if the provided fonts can not be
 *                   used
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Typeface.CustomFallbackBuilder setSystemFallback(@androidx.annotation.NonNull java.lang.String familyName) { throw new RuntimeException("Stub!"); }

/**
 * Sets a font style of the Typeface.
 *
 * If the font family doesn't have a font of given style, system will select the closest
 * font from font family. For example, if a font family has fonts of 300 weight and 700
 * weight then setWeight(400) is called, system will select the font of 300 weight.
 *
 * @param style a font style
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Typeface.CustomFallbackBuilder setStyle(@androidx.annotation.NonNull android.graphics.fonts.FontStyle style) { throw new RuntimeException("Stub!"); }

/**
 * Append a font family to the end of the custom font fallback.
 *
 * You can set up to 64 custom fallback families including the first font family you passed
 * to the constructor.
 * For more information about fallback, see class description.
 *
 * @param family a fallback family
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if you give more than 64 custom fallback families
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Typeface.CustomFallbackBuilder addCustomFallback(@androidx.annotation.NonNull android.graphics.fonts.FontFamily family) { throw new RuntimeException("Stub!"); }

/**
 * Create the Typeface based on the configured values.
 *
 * @return the Typeface object
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Typeface build() { throw new RuntimeException("Stub!"); }
}

}

