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


package android.text;

import android.view.View;

/**
 * Some objects that implement {@link android.text.TextDirectionHeuristic TextDirectionHeuristic}. Use these with
 * the {@link android.text.BidiFormatter#unicodeWrap BidiFormatter#unicodeWrap} methods in {@link android.text.BidiFormatter BidiFormatter}.
 * Also notice that these direction heuristics correspond to the same types of constants
 * provided in the {@link android.view.View} class for {@link android.view.View#setTextDirection
 * setTextDirection()}, such as {@link android.view.View#TEXT_DIRECTION_RTL}.
 * <p>To support versions lower than {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2},
 * you can use the support library's {@link android.support.v4.text.TextDirectionHeuristicsCompat}
 * class.
 *
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TextDirectionHeuristics {

public TextDirectionHeuristics() { throw new RuntimeException("Stub!"); }

/**
 * If the text contains any strong right to left non-format character, determines that the
 * direction is right to left, falling back to left to right if it finds none.
 * @apiSince 18
 */

public static final android.text.TextDirectionHeuristic ANYRTL_LTR;
static { ANYRTL_LTR = null; }

/**
 * Determines the direction based on the first strong directional character, including bidi
 * format chars, falling back to left to right if it finds none. This is the default behavior
 * of the Unicode Bidirectional Algorithm.
 * @apiSince 18
 */

public static final android.text.TextDirectionHeuristic FIRSTSTRONG_LTR;
static { FIRSTSTRONG_LTR = null; }

/**
 * Determines the direction based on the first strong directional character, including bidi
 * format chars, falling back to right to left if it finds none. This is similar to the default
 * behavior of the Unicode Bidirectional Algorithm, just with different fallback behavior.
 * @apiSince 18
 */

public static final android.text.TextDirectionHeuristic FIRSTSTRONG_RTL;
static { FIRSTSTRONG_RTL = null; }

/**
 * Force the paragraph direction to the Locale direction. Falls back to left to right.
 * @apiSince 18
 */

public static final android.text.TextDirectionHeuristic LOCALE;
static { LOCALE = null; }

/**
 * Always decides that the direction is left to right.
 * @apiSince 18
 */

public static final android.text.TextDirectionHeuristic LTR;
static { LTR = null; }

/**
 * Always decides that the direction is right to left.
 * @apiSince 18
 */

public static final android.text.TextDirectionHeuristic RTL;
static { RTL = null; }
}

