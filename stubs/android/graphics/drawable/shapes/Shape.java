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
import android.graphics.Outline;

/**
 * Defines a generic graphical "shape."
 * <p>
 * Any Shape can be drawn to a Canvas with its own draw() method, but more
 * graphical control is available if you instead pass it to a
 * {@link android.graphics.drawable.ShapeDrawable}.
 * <p>
 * Custom Shape classes must implement {@link #clone()} and return an instance
 * of the custom Shape class.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Shape implements java.lang.Cloneable {

public Shape() { throw new RuntimeException("Stub!"); }

/**
 * Returns the width of the Shape.
 * @apiSince 1
 */

public final float getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the height of the Shape.
 * @apiSince 1
 */

public final float getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Draws this shape into the provided Canvas, with the provided Paint.
 * <p>
 * Before calling this, you must call {@link #resize(float,float)}.
 *
 * @param canvas the Canvas within which this shape should be drawn
 * @param paint  the Paint object that defines this shape's characteristics
 * @apiSince 1
 */

public abstract void draw(android.graphics.Canvas canvas, android.graphics.Paint paint);

/**
 * Resizes the dimensions of this shape.
 * <p>
 * Must be called before {@link #draw(android.graphics.Canvas,android.graphics.Paint)}.
 *
 * @param width the width of the shape (in pixels)
 * @param height the height of the shape (in pixels)
 * @apiSince 1
 */

public final void resize(float width, float height) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the Shape is opaque.
 * <p>
 * Default impl returns {@code true}. Override if your subclass can be
 * opaque.
 *
 * @return true if any part of the drawable is <em>not</em> opaque.
 * @apiSince 1
 */

public boolean hasAlpha() { throw new RuntimeException("Stub!"); }

/**
 * Callback method called when {@link #resize(float,float)} is executed.
 *
 * @param width the new width of the Shape
 * @param height the new height of the Shape
 * @apiSince 1
 */

protected void onResize(float width, float height) { throw new RuntimeException("Stub!"); }

/**
 * Computes the Outline of the shape and return it in the supplied Outline
 * parameter. The default implementation does nothing and {@code outline}
 * is not changed.
 *
 * @param outline the Outline to be populated with the result. Must be
 *                non-{@code null}.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void getOutline(@androidx.annotation.NonNull android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.graphics.drawable.shapes.Shape clone() throws java.lang.CloneNotSupportedException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

