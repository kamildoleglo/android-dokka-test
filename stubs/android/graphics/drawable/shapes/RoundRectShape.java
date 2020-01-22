/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.graphics.drawable.shapes;

import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * Creates a rounded-corner rectangle. Optionally, an inset (rounded) rectangle
 * can be included (to make a sort of "O" shape).
 * <p>
 * The rounded rectangle can be drawn to a Canvas with its own draw() method,
 * but more graphical control is available if you instead pass
 * the RoundRectShape to a {@link android.graphics.drawable.ShapeDrawable}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RoundRectShape extends android.graphics.drawable.shapes.RectShape {

/**
 * RoundRectShape constructor.
 * <p>
 * Specifies an outer (round)rect and an optional inner (round)rect.
 *
 * @param outerRadii An array of 8 radius values, for the outer roundrect.
 *                   The first two floats are for the top-left corner
 *                   (remaining pairs correspond clockwise). For no rounded
 *                   corners on the outer rectangle, pass {@code null}.
 * This value may be {@code null}.
 * @param inset A RectF that specifies the distance from the inner
 *              rect to each side of the outer rect. For no inner, pass
 *              {@code null}.
 * This value may be {@code null}.
 * @param innerRadii An array of 8 radius values, for the inner roundrect.
 *                   The first two floats are for the top-left corner
 *                   (remaining pairs correspond clockwise). For no rounded
 *                   corners on the inner rectangle, pass {@code null}. If
 *                   inset parameter is {@code null}, this parameter is
 *                   ignored.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public RoundRectShape(@androidx.annotation.Nullable float[] outerRadii, @androidx.annotation.Nullable android.graphics.RectF inset, @androidx.annotation.Nullable float[] innerRadii) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void draw(android.graphics.Canvas canvas, android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void getOutline(android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onResize(float w, float h) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.graphics.drawable.shapes.RoundRectShape clone() throws java.lang.CloneNotSupportedException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

