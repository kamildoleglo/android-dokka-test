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
 * A font style object.
 *
 * This class represents a single font style which is a pair of weight value and slant value.
 * Here are common font styles examples:
 * <p>
 * <pre>
 * <code>
 * final FontStyle NORMAL = new FontStyle(FONT_WEIGHT_NORMAL, FONT_SLANT_UPRIGHT);
 * final FontStyle BOLD = new FontStyle(FONT_WEIGHT_BOLD, FONT_SLANT_UPRIGHT);
 * final FontStyle ITALIC = new FontStyle(FONT_WEIGHT_NORMAL, FONT_SLANT_ITALIC);
 * final FontStyle BOLD_ITALIC = new FontStyle(FONT_WEIGHT_BOLD, FONT_SLANT_ITALIC);
 * </code>
 * </pre>
 * </p>
 *
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FontStyle {

/** @apiSince 29 */

public FontStyle() { throw new RuntimeException("Stub!"); }

/**
 * Create FontStyle with specific weight and italic
 *
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
 * @param slant a slant value
 
 * Value is {@link android.graphics.fonts.FontStyle#FONT_SLANT_UPRIGHT}, or {@link android.graphics.fonts.FontStyle#FONT_SLANT_ITALIC}
 * @apiSince 29
 */

public FontStyle(int weight, int slant) { throw new RuntimeException("Stub!"); }

/**
 * Gets the weight value
 *
 * @see FontStyle#setWeight(int)
 * @return a weight value
 
 * Value is between 0 and 1000 inclusive
 * @apiSince 29
 */

public int getWeight() { throw new RuntimeException("Stub!"); }

/**
 * Gets the slant value
 *
 * @return a slant value
 
 * Value is {@link android.graphics.fonts.FontStyle#FONT_SLANT_UPRIGHT}, or {@link android.graphics.fonts.FontStyle#FONT_SLANT_ITALIC}
 * @apiSince 29
 */

public int getSlant() { throw new RuntimeException("Stub!"); }

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
 * A font slant value for italic
 * @apiSince 29
 */

public static final int FONT_SLANT_ITALIC = 1; // 0x1

/**
 * A font slant value for upright
 * @apiSince 29
 */

public static final int FONT_SLANT_UPRIGHT = 0; // 0x0

/**
 * A font weight value for the black weight
 * @apiSince 29
 */

public static final int FONT_WEIGHT_BLACK = 900; // 0x384

/**
 * A font weight value for the bold weight.
 * @apiSince 29
 */

public static final int FONT_WEIGHT_BOLD = 700; // 0x2bc

/**
 * A font weight value for the extra-bold weight
 * @apiSince 29
 */

public static final int FONT_WEIGHT_EXTRA_BOLD = 800; // 0x320

/**
 * A font weight value for the extra-light weight
 * @apiSince 29
 */

public static final int FONT_WEIGHT_EXTRA_LIGHT = 200; // 0xc8

/**
 * A font weight value for the light weight
 * @apiSince 29
 */

public static final int FONT_WEIGHT_LIGHT = 300; // 0x12c

/**
 * A maximum weight value for the font
 * @apiSince 29
 */

public static final int FONT_WEIGHT_MAX = 1000; // 0x3e8

/**
 * A font weight value for the medium weight
 * @apiSince 29
 */

public static final int FONT_WEIGHT_MEDIUM = 500; // 0x1f4

/**
 * A minimum weight value for the font
 * @apiSince 29
 */

public static final int FONT_WEIGHT_MIN = 1; // 0x1

/**
 * A font weight value for the normal weight
 * @apiSince 29
 */

public static final int FONT_WEIGHT_NORMAL = 400; // 0x190

/**
 * A font weight value for the semi-bold weight
 * @apiSince 29
 */

public static final int FONT_WEIGHT_SEMI_BOLD = 600; // 0x258

/**
 * A font weight value for the thin weight
 * @apiSince 29
 */

public static final int FONT_WEIGHT_THIN = 100; // 0x64
}

