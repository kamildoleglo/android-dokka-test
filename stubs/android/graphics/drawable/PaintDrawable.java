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


package android.graphics.drawable;


/**
 * Drawable that draws its bounds in the given paint, with optional
 * rounded corners.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PaintDrawable extends android.graphics.drawable.ShapeDrawable {

/** @apiSince 1 */

public PaintDrawable() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public PaintDrawable(int color) { throw new RuntimeException("Stub!"); }

/**
 * Specify radius for the corners of the rectangle. If this is > 0, then the
 * drawable is drawn in a round-rectangle, rather than a rectangle.
 * @param radius the radius for the corners of the rectangle
 * @apiSince 1
 */

public void setCornerRadius(float radius) { throw new RuntimeException("Stub!"); }

/**
 * Specify radii for each of the 4 corners. For each corner, the array
 * contains 2 values, [X_radius, Y_radius]. The corners are ordered
 * top-left, top-right, bottom-right, bottom-left
 * @param radii the x and y radii of the corners
 * @apiSince 1
 */

public void setCornerRadii(float[] radii) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean inflateTag(java.lang.String name, android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }
}

