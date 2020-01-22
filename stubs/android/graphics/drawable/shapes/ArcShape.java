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
import android.graphics.Paint;

/**
 * Creates an arc shape. The arc shape starts at a specified angle and sweeps
 * clockwise, drawing slices of pie.
 * <p>
 * The arc can be drawn to a {@link android.graphics.Canvas Canvas} with its own
 * {@link #draw(android.graphics.Canvas,android.graphics.Paint)} method, but more graphical control is available
 * if you instead pass the ArcShape to a
 * {@link android.graphics.drawable.ShapeDrawable}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ArcShape extends android.graphics.drawable.shapes.RectShape {

/**
 * ArcShape constructor.
 *
 * @param startAngle the angle (in degrees) where the arc begins
 * @param sweepAngle the sweep angle (in degrees). Anything equal to or
 *                   greater than 360 results in a complete circle/oval.
 * @apiSince 1
 */

public ArcShape(float startAngle, float sweepAngle) { throw new RuntimeException("Stub!"); }

/**
 * @return the angle (in degrees) where the arc begins
 * @apiSince 26
 */

public final float getStartAngle() { throw new RuntimeException("Stub!"); }

/**
 * @return the sweep angle (in degrees)
 * @apiSince 26
 */

public final float getSweepAngle() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void draw(android.graphics.Canvas canvas, android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void getOutline(android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.graphics.drawable.shapes.ArcShape clone() throws java.lang.CloneNotSupportedException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

