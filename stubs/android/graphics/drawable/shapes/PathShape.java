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

import android.graphics.Path;
import android.graphics.Canvas;

/**
 * Creates geometric paths, utilizing the {@link android.graphics.Path} class.
 * <p>
 * The path can be drawn to a Canvas with its own draw() method,
 * but more graphical control is available if you instead pass
 * the PathShape to a {@link android.graphics.drawable.ShapeDrawable}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PathShape extends android.graphics.drawable.shapes.Shape {

/**
 * PathShape constructor.
 *
 * @param path a Path that defines the geometric paths for this shape
 * This value must never be {@code null}.
 * @param stdWidth the standard width for the shape. Any changes to the
 *                 width with resize() will result in a width scaled based
 *                 on the new width divided by this width.
 * @param stdHeight the standard height for the shape. Any changes to the
 *                  height with resize() will result in a height scaled based
 *                  on the new height divided by this height.
 * @apiSince 1
 */

public PathShape(@androidx.annotation.NonNull android.graphics.Path path, float stdWidth, float stdHeight) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void draw(android.graphics.Canvas canvas, android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onResize(float width, float height) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.graphics.drawable.shapes.PathShape clone() throws java.lang.CloneNotSupportedException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

