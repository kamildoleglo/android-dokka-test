/*
 * Copyright (C) 2017 The Android Open Source Project
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


/**
 * Class that holds information about single font variation axis.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FontVariationAxis {

/**
 * Construct FontVariationAxis.
 *
 * The axis tag must contain four ASCII characters. Tag string that are longer or shorter than
 * four characters, or contains characters outside of U+0020..U+007E are invalid.
 *
 * @throws java.lang.IllegalArgumentException If given tag string is invalid.
 
 * @param tagString This value must never be {@code null}.
 * @apiSince 26
 */

public FontVariationAxis(@androidx.annotation.NonNull java.lang.String tagString, float styleValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the variable font axis tag associated to this axis.
 * @apiSince 26
 */

public java.lang.String getTag() { throw new RuntimeException("Stub!"); }

/**
 * Returns the style value associated to the given axis for this font.
 * @apiSince 26
 */

public float getStyleValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns a valid font variation setting string for this object.
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Construct FontVariationAxis array from font variation settings.
 *
 * The settings string is constructed from multiple pairs of axis tag and style values. The axis
 * tag must contain four ASCII characters and must be wrapped with single quotes (U+0027) or
 * double quotes (U+0022). Axis strings that are longer or shorter than four characters, or
 * contain characters outside of U+0020..U+007E are invalid. If a specified axis name is not
 * defined in the font, the settings will be ignored.
 *
 * <pre>
 *   FontVariationAxis.fromFontVariationSettings("'wdth' 1.0");
 *   FontVariationAxis.fromFontVariationSettings("'AX  ' 1.0, 'FB  ' 2.0");
 * </pre>
 *
 * @param settings font variation settings.
 * This value may be {@code null}.
 * @return FontVariationAxis[] the array of parsed font variation axis. {@code null} if settings
 *                             has no font variation settings.
 * @throws java.lang.IllegalArgumentException If given string is not a valid font variation settings
 *                                  format.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public static android.graphics.fonts.FontVariationAxis[] fromFontVariationSettings(@androidx.annotation.Nullable java.lang.String settings) { throw new RuntimeException("Stub!"); }

/**
 * Stringify the array of FontVariationAxis.
 *
 * @param axes an array of FontVariationAxis.
 * This value may be {@code null}.
 * @return String a valid font variation settings string.
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static java.lang.String toFontVariationSettings(@androidx.annotation.Nullable android.graphics.fonts.FontVariationAxis[] axes) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param o This value may be {@code null}.
 * @apiSince 26
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

