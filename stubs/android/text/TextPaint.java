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


package android.text;

import android.graphics.Paint;

/**
 * TextPaint is an extension of Paint that leaves room for some extra
 * data used during text measuring and drawing.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TextPaint extends android.graphics.Paint {

/** @apiSince 1 */

public TextPaint() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public TextPaint(int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public TextPaint(android.graphics.Paint p) { throw new RuntimeException("Stub!"); }

/**
 * Copy the fields from tp into this TextPaint, including the
 * fields inherited from Paint.
 * @apiSince 1
 */

public void set(android.text.TextPaint tp) { throw new RuntimeException("Stub!"); }

/**
 * @hide
 */

public float getUnderlineThickness() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int baselineShift;

/** @apiSince 1 */

public int bgColor;

/** @apiSince 5 */

public float density = 1.0f;

/** @apiSince 1 */

public int[] drawableState;

/** @apiSince 1 */

public int linkColor;

/**
 * Special value 0 means no custom underline
 * @apiSince 29
 */

public int underlineColor = 0; // 0x0

/**
 * Thickness of the underline, in pixels.
 
 * <br>
 * This units of this value are pixels.
 * @apiSince 29
 */

public float underlineThickness;
}

