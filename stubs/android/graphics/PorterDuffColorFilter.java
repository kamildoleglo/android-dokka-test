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


/**
 * A color filter that can be used to tint the source pixels using a single
 * color and a specific {@link android.graphics.PorterDuff PorterDuff}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PorterDuffColorFilter extends android.graphics.ColorFilter {

/**
 * Create a color filter that uses the specified color and Porter-Duff mode.
 *
 * @param color The ARGB source color used with the specified Porter-Duff mode
 * @param mode The porter-duff mode that is applied
 *
 * This value must never be {@code null}.
 * @see android.graphics.Color
 * @apiSince 1
 */

public PorterDuffColorFilter(int color, @androidx.annotation.NonNull android.graphics.PorterDuff.Mode mode) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object object) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

