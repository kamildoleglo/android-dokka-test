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


package android.graphics;


/**
 * A color filter that can be used to tint the source pixels using a single
 * color and a specific {@link android.graphics.BlendMode BlendMode}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BlendModeColorFilter extends android.graphics.ColorFilter {

/**
 * @param mode This value must never be {@code null}.
 * @apiSince 29
 */

public BlendModeColorFilter(int color, @androidx.annotation.NonNull android.graphics.BlendMode mode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the ARGB color used to tint the source pixels when this filter
 * is applied.
 *
 * @see android.graphics.Color
 *
 * @apiSince 29
 */

public int getColor() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Porter-Duff mode used to composite this color filter's
 * color with the source pixel when this filter is applied.
 *
 * @see android.graphics.BlendMode
 *
 * @apiSince 29
 */

public android.graphics.BlendMode getMode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object object) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

