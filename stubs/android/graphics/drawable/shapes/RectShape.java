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
 * Defines a rectangle shape.
 * <p>
 * The rectangle can be drawn to a Canvas with its own draw() method,
 * but more graphical control is available if you instead pass
 * the RectShape to a {@link android.graphics.drawable.ShapeDrawable}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RectShape extends android.graphics.drawable.shapes.Shape {

/** @apiSince 1 */

public RectShape() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void draw(android.graphics.Canvas canvas, android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void getOutline(android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onResize(float width, float height) { throw new RuntimeException("Stub!"); }

/**
 * Returns the RectF that defines this rectangle's bounds.
 * @apiSince 1
 */

protected final android.graphics.RectF rect() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.graphics.drawable.shapes.RectShape clone() throws java.lang.CloneNotSupportedException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

