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


/**
 * A font family class can be used for creating Typeface.
 *
 * <p>
 * A font family is a bundle of fonts for drawing text in various styles.
 * For example, you can bundle regular style font and bold style font into a single font family,
 * then system will select the correct style font from family for drawing.
 *
 * <pre>
 *  FontFamily family = new FontFamily.Builder(new Font.Builder("regular.ttf").build())
 *      .addFont(new Font.Builder("bold.ttf").build()).build();
 *  Typeface typeface = new Typeface.Builder2(family).build();
 *
 *  SpannableStringBuilder ssb = new SpannableStringBuilder("Hello, World.");
 *  ssb.setSpan(new StyleSpan(Typeface.Bold), 6, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
 *
 *  textView.setTypeface(typeface);
 *  textView.setText(ssb);
 * </pre>
 *
 * In this example, "Hello, " is drawn with "regular.ttf", and "World." is drawn with "bold.ttf".
 *
 * If there is no font exactly matches with the text style, the system will select the closest font.
 * </p>
 *
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FontFamily {

private FontFamily() { throw new RuntimeException("Stub!"); }

/**
 * Returns a font
 *
 * @param index an index of the font
 * Value is 0 or greater
 * @return a registered font
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.fonts.Font getFont(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of fonts in this FontFamily.
 *
 * @return the number of fonts registered in this family.
 
 * Value is 1 or greater
 * @apiSince 29
 */

public int getSize() { throw new RuntimeException("Stub!"); }
/**
 * A builder class for creating new FontFamily.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Constructs a builder.
 *
 * @param font a font
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull android.graphics.fonts.Font font) { throw new RuntimeException("Stub!"); }

/**
 * Adds different style font to the builder.
 *
 * System will select the font if the text style is closest to the font.
 * If the same style font is already added to the builder, this method will fail with
 * {@link java.lang.IllegalArgumentException IllegalArgumentException}.
 *
 * Note that system assumes all fonts bundled in FontFamily have the same coverage for the
 * code points. For example, regular style font and bold style font must have the same code
 * point coverage, otherwise some character may be shown as tofu.
 *
 * @param font a font
 * This value must never be {@code null}.
 * @return this builder
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.fonts.FontFamily.Builder addFont(@androidx.annotation.NonNull android.graphics.fonts.Font font) { throw new RuntimeException("Stub!"); }

/**
 * Build the font family
 * @return a font family
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.fonts.FontFamily build() { throw new RuntimeException("Stub!"); }
}

}

