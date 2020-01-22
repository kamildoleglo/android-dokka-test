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


package android.graphics;


/**
 * A Picture records drawing calls (via the canvas returned by beginRecording)
 * and can then play them back into Canvas (via {@link android.graphics.Picture#draw(android.graphics.Canvas) Picture#draw(Canvas)} or
 * {@link android.graphics.Canvas#drawPicture(android.graphics.Picture) Canvas#drawPicture(Picture)}).For most content (e.g. text, lines, rectangles),
 * drawing a sequence from a picture can be faster than the equivalent API
 * calls, since the picture performs its playback without incurring any
 * method-call overhead.
 *
 * <p class="note"><strong>Note:</strong> Prior to API level 23 a picture cannot
 * be replayed on a hardware accelerated canvas.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Picture {

/**
 * Creates an empty picture that is ready to record.
 * @apiSince 1
 */

public Picture() { throw new RuntimeException("Stub!"); }

/**
 * Create a picture by making a copy of what has already been recorded in
 * src. The contents of src are unchanged, and if src changes later, those
 * changes will not be reflected in this picture.
 * @apiSince 1
 */

public Picture(android.graphics.Picture src) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * To record a picture, call beginRecording() and then draw into the Canvas
 * that is returned. Nothing we appear on screen, but all of the draw
 * commands (e.g. {@link android.graphics.Canvas#drawRect(android.graphics.Rect,android.graphics.Paint) Canvas#drawRect(Rect, Paint)}) will be recorded.
 * To stop recording, call endRecording(). After endRecording() the Canvas
 * that was returned must no longer be used, and nothing should be drawn
 * into it.
 
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.graphics.Canvas beginRecording(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Call endRecording when the picture is built. After this call, the picture
 * may be drawn, but the canvas that was returned by beginRecording must not
 * be used anymore. This is automatically called if {@link android.graphics.Picture#draw Picture#draw}
 * or {@link android.graphics.Canvas#drawPicture(android.graphics.Picture) Canvas#drawPicture(Picture)} is called.
 * @apiSince 1
 */

public void endRecording() { throw new RuntimeException("Stub!"); }

/**
 * Get the width of the picture as passed to beginRecording. This
 * does not reflect (per se) the content of the picture.
 * @apiSince 1
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Get the height of the picture as passed to beginRecording. This
 * does not reflect (per se) the content of the picture.
 * @apiSince 1
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether or not this Picture contains recorded commands that only work when
 * drawn to a hardware-accelerated canvas. If this returns true then this Picture can only
 * be drawn to another Picture or to a Canvas where canvas.isHardwareAccelerated() is true.
 *
 * Note this value is only updated after recording has finished by a call to
 * {@link #endRecording()}. Prior to that it will be the default value of false.
 *
 * @return true if the Picture can only be drawn to a hardware-accelerated canvas,
 *         false otherwise.
 * @apiSince 28
 */

public boolean requiresHardwareAcceleration() { throw new RuntimeException("Stub!"); }

/**
 * Draw this picture on the canvas.
 * <p>
 * Prior to {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this call could
 * have the side effect of changing the matrix and clip of the canvas
 * if this picture had imbalanced saves/restores.
 *
 * <p>
 * <strong>Note:</strong> This forces the picture to internally call
 * {@link android.graphics.Picture#endRecording() Picture#endRecording()} in order to prepare for playback.
 *
 * @param canvas  The picture is drawn to this canvas
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }
}

