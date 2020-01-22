/*
 * Copyright (C) 2008 The Android Open Source Project
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

import android.graphics.Picture;
import android.graphics.drawable.Drawable;

/**
 * Drawable subclass that wraps a Picture, allowing the picture to be used
 * wherever a Drawable is supported.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PictureDrawable extends android.graphics.drawable.Drawable {

/**
 * Construct a new drawable referencing the specified picture. The picture
 * may be null.
 *
 * @param picture The picture to associate with the drawable. May be null.
 * @apiSince 1
 */

public PictureDrawable(android.graphics.Picture picture) { throw new RuntimeException("Stub!"); }

/**
 * Return the picture associated with the drawable. May be null.
 *
 * @return the picture associated with the drawable, or null.
 * @apiSince 1
 */

public android.graphics.Picture getPicture() { throw new RuntimeException("Stub!"); }

/**
 * Associate a picture with this drawable. The picture may be null.
 *
 * @param picture The picture to associate with the drawable. May be null.
 * @apiSince 1
 */

public void setPicture(android.graphics.Picture picture) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIntrinsicWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIntrinsicHeight() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getOpacity() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setColorFilter(android.graphics.ColorFilter colorFilter) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }
}

