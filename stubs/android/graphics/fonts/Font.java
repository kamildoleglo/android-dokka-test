/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.graphics.fonts;

import java.nio.ByteBuffer;

/**
 * A font class can be used for creating FontFamily.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Font {

private Font() { throw new RuntimeException("Stub!"); }

/**
 * Returns a font file buffer.
 *
 * @return a font buffer
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.nio.ByteBuffer getBuffer() { throw new RuntimeException("Stub!"); }

/**
 * Returns a file path of this font.
 *
 * This returns null if this font is not created from regular file.
 *
 * @return a file path of the font
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.io.File getFile() { throw new RuntimeException("Stub!"); }

/**
 * Get a style associated with this font.
 *
 * @see android.graphics.fonts.Font.Builder#setWeight(int)
 * @see android.graphics.fonts.Font.Builder#setSlant(int)
 * @return a font style
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.fonts.FontStyle getStyle() { throw new RuntimeException("Stub!"); }

/**
 * Get a TTC index value associated with this font.
 *
 * If TTF/OTF file is provided, this value is always 0.
 *
 * @see android.graphics.fonts.Font.Builder#setTtcIndex(int)
 * @return a TTC index value
 
 * Value is 0 or greater
 * @apiSince 29
 */

public int getTtcIndex() { throw new RuntimeException("Stub!"); }

/**
 * Get a font variation settings associated with this font
 *
 * @see android.graphics.fonts.Font.Builder#setFontVariationSettings(String)
 * @see android.graphics.fonts.Font.Builder#setFontVariationSettings(FontVariationAxis[])
 * @return font variation settings
 
 * This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.fonts.FontVariationAxis[] getAxes() { throw new RuntimeException("Stub!"); }

/**
 * Get a locale list of this font.
 *
 * This is always empty if this font is not a system font.
 * @return a locale list
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.os.LocaleList getLocaleList() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param o This value may be {@code null}.
 * @apiSince 29
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
/**
 * A builder class for creating new Font.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Constructs a builder with a byte buffer.
 *
 * Note that only direct buffer can be used as the source of font data.
 *
 * @see java.nio.ByteBuffer#allocateDirect(int)
 * @param buffer a byte buffer of a font data
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull java.nio.ByteBuffer buffer) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a builder with a file path.
 *
 * @param path a file path to the font file
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull java.io.File path) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a builder with a file descriptor.
 *
 * @param fd a file descriptor
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull android.os.ParcelFileDescriptor fd) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a builder with a file descriptor.
 *
 * @param fd a file descriptor
 * This value must never be {@code null}.
 * @param offset an offset to of the font data in the file
 * Value is 0 or greater
 * @param size a size of the font data. If -1 is passed, use until end of the file.
 
 * Value is -1 or greater
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull android.os.ParcelFileDescriptor fd, long offset, long size) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a builder from an asset manager and a file path in an asset directory.
 *
 * @param am the application's asset manager
 * This value must never be {@code null}.
 * @param path the file name of the font data in the asset directory
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull android.content.res.AssetManager am, @androidx.annotation.NonNull java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a builder from resources.
 *
 * Resource ID must points the font file. XML font can not be used here.
 *
 * @param res the resource of this application.
 * This value must never be {@code null}.
 * @param resId the resource ID of font file.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull android.content.res.Resources res, int resId) { throw new RuntimeException("Stub!"); }

/**
 * Sets weight of the font.
 *
 * Tells the system the weight of the given font. If this function is not called, the system
 * will resolve the weight value by reading font tables.
 *
 * Here are pairs of the common names and their values.
 * <p>
 *  <table>
 *  <thead>
 *  <tr>
 *  <th align="center">Value</th>
 *  <th align="center">Name</th>
 *  <th align="center">Android Definition</th>
 *  </tr>
 *  </thead>
 *  <tbody>
 *  <tr>
 *  <td align="center">100</td>
 *  <td align="center">Thin</td>
 *  <td align="center">{@link android.graphics.fonts.FontStyle#FONT_WEIGHT_THIN FontStyle#FONT_WEIGHT_THIN}</td>
 *  </tr>
 *  <tr>
 *  <td align="center">200</td>
 *  <td align="center">Extra Light (Ultra Light)</td>
 *  <td align="center">{@link android.graphics.fonts.FontStyle#FONT_WEIGHT_EXTRA_LIGHT FontStyle#FONT_WEIGHT_EXTRA_LIGHT}</td>
 *  </tr>
 *  <tr>
 *  <td align="center">300</td>
 *  <td align="center">Light</td>
 *  <td align="center">{@link android.graphics.fonts.FontStyle#FONT_WEIGHT_LIGHT FontStyle#FONT_WEIGHT_LIGHT}</td>
 *  </tr>
 *  <tr>
 *  <td align="center">400</td>
 *  <td align="center">Normal (Regular)</td>
 *  <td align="center">{@link android.graphics.fonts.FontStyle#FONT_WEIGHT_NORMAL FontStyle#FONT_WEIGHT_NORMAL}</td>
 *  </tr>
 *  <tr>
 *  <td align="center">500</td>
 *  <td align="center">Medium</td>
 *  <td align="center">{@link android.graphics.fonts.FontStyle#FONT_WEIGHT_MEDIUM FontStyle#FONT_WEIGHT_MEDIUM}</td>
 *  </tr>
 *  <tr>
 *  <td align="center">600</td>
 *  <td align="center">Semi Bold (Demi Bold)</td>
 *  <td align="center">{@link android.graphics.fonts.FontStyle#FONT_WEIGHT_SEMI_BOLD FontStyle#FONT_WEIGHT_SEMI_BOLD}</td>
 *  </tr>
 *  <tr>
 *  <td align="center">700</td>
 *  <td align="center">Bold</td>
 *  <td align="center">{@link android.graphics.fonts.FontStyle#FONT_WEIGHT_BOLD FontStyle#FONT_WEIGHT_BOLD}</td>
 *  </tr>
 *  <tr>
 *  <td align="center">800</td>
 *  <td align="center">Extra Bold (Ultra Bold)</td>
 *  <td align="center">{@link android.graphics.fonts.FontStyle#FONT_WEIGHT_EXTRA_BOLD FontStyle#FONT_WEIGHT_EXTRA_BOLD}</td>
 *  </tr>
 *  <tr>
 *  <td align="center">900</td>
 *  <td align="center">Black (Heavy)</td>
 *  <td align="center">{@link android.graphics.fonts.FontStyle#FONT_WEIGHT_BLACK FontStyle#FONT_WEIGHT_BLACK}</td>
 *  </tr>
 *  </tbody>
 * </p>
 *
 * @see android.graphics.fonts.FontStyle#FONT_WEIGHT_THIN
 * @see android.graphics.fonts.FontStyle#FONT_WEIGHT_EXTRA_LIGHT
 * @see android.graphics.fonts.FontStyle#FONT_WEIGHT_LIGHT
 * @see android.graphics.fonts.FontStyle#FONT_WEIGHT_NORMAL
 * @see android.graphics.fonts.FontStyle#FONT_WEIGHT_MEDIUM
 * @see android.graphics.fonts.FontStyle#FONT_WEIGHT_SEMI_BOLD
 * @see android.graphics.fonts.FontStyle#FONT_WEIGHT_BOLD
 * @see android.graphics.fonts.FontStyle#FONT_WEIGHT_EXTRA_BOLD
 * @see android.graphics.fonts.FontStyle#FONT_WEIGHT_BLACK
 * @param weight a weight value
 * Value is between FontStyle.FONT_WEIGHT_MIN and FontStyle.FONT_WEIGHT_MAX inclusive
 * @return this builder
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.fonts.Font.Builder setWeight(int weight) { throw new RuntimeException("Stub!"); }

/**
 * Sets italic information of the font.
 *
 * Tells the system the style of the given font. If this function is not called, the system
 * will resolve the style by reading font tables.
 *
 * For example, if you want to use italic font as upright font, call {@code
 * setSlant(FontStyle.FONT_SLANT_UPRIGHT)} explicitly.
 *
 * @param slant Value is {@link android.graphics.fonts.FontStyle#FONT_SLANT_UPRIGHT}, or {@link android.graphics.fonts.FontStyle#FONT_SLANT_ITALIC}
 * @return this builder
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.fonts.Font.Builder setSlant(int slant) { throw new RuntimeException("Stub!"); }

/**
 * Sets an index of the font collection. See {@link android.R.attr#ttcIndex}.
 *
 * @param ttcIndex An index of the font collection. If the font source is not font
 *                 collection, do not call this method or specify 0.
 * Value is 0 or greater
 * @return this builder
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.fonts.Font.Builder setTtcIndex(int ttcIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sets the font variation settings.
 *
 * @param variationSettings see {@link android.graphics.fonts.FontVariationAxis#fromFontVariationSettings(java.lang.String) FontVariationAxis#fromFontVariationSettings(String)}
 * This value may be {@code null}.
 * @return this builder
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException If given string is not a valid font variation settings
 *                                  format.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.fonts.Font.Builder setFontVariationSettings(@androidx.annotation.Nullable java.lang.String variationSettings) { throw new RuntimeException("Stub!"); }

/**
 * Sets the font variation settings.
 *
 * @param axes an array of font variation axis tag-value pairs
 * This value may be {@code null}.
 * @return this builder
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.fonts.Font.Builder setFontVariationSettings(@androidx.annotation.Nullable android.graphics.fonts.FontVariationAxis[] axes) { throw new RuntimeException("Stub!"); }

/**
 * Creates the font based on the configured values.
 * @return the Font object
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.fonts.Font build() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

}

