/*
 * Copyright (C) 2010 The Android Open Source Project
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
 * A Canvas implementation that records view system drawing operations for deferred rendering.
 * This is used in combination with RenderNode. This class keeps a list of all the Paint and
 * Bitmap objects that it draws, preventing the backing memory of Bitmaps from being released while
 * the RecordingCanvas is still holding a native reference to the memory.
 *
 * This is obtained by calling {@link android.graphics.RenderNode#beginRecording() RenderNode#beginRecording()} and is valid until the matching
 * {@link android.graphics.RenderNode#endRecording() RenderNode#endRecording()} is called. It must not be retained beyond that as it is
 * internally reused.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RecordingCanvas extends android.graphics.Canvas {

RecordingCanvas() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void setDensity(int density) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean isHardwareAccelerated() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void setBitmap(android.graphics.Bitmap bitmap) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean isOpaque() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int getMaximumBitmapWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int getMaximumBitmapHeight() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void enableZ() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void disableZ() { throw new RuntimeException("Stub!"); }

/**
 * Draws the specified display list onto this canvas.
 *
 * @param renderNode The RenderNode to draw.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void drawRenderNode(@androidx.annotation.NonNull android.graphics.RenderNode renderNode) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param text This value must never be {@code null}.
 
 * @param path This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawTextOnPath(@androidx.annotation.NonNull char[] text, int index, int count, @androidx.annotation.NonNull android.graphics.Path path, float hOffset, float vOffset, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param text This value must never be {@code null}.
 
 * @param path This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawTextOnPath(@androidx.annotation.NonNull java.lang.String text, @androidx.annotation.NonNull android.graphics.Path path, float hOffset, float vOffset, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated checkstyle
 * @param text This value must never be {@code null}.
 
 * @param pos This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

@Deprecated
public final void drawPosText(@androidx.annotation.NonNull char[] text, int index, int count, @androidx.annotation.NonNull float[] pos, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated checkstyle
 * @param text This value must never be {@code null}.
 
 * @param pos This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

@Deprecated
public final void drawPosText(@androidx.annotation.NonNull java.lang.String text, @androidx.annotation.NonNull float[] pos, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param paint This value must never be {@code null}.
 */

public final void drawOval(float left, float top, float right, float bottom, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param oval This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawOval(@androidx.annotation.NonNull android.graphics.RectF oval, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param outer This value must never be {@code null}.
 
 * @param inner This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawDoubleRoundRect(@androidx.annotation.NonNull android.graphics.RectF outer, float outerRx, float outerRy, @androidx.annotation.NonNull android.graphics.RectF inner, float innerRx, float innerRy, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param outer This value must never be {@code null}.
 
 * @param inner This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawDoubleRoundRect(@androidx.annotation.NonNull android.graphics.RectF outer, float[] outerRadii, @androidx.annotation.NonNull android.graphics.RectF inner, float[] innerRadii, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param paint This value must never be {@code null}.
 */

public final void drawPoint(float x, float y, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param patch This value must never be {@code null}.
 
 * @param dst This value must never be {@code null}.

 * @param paint This value may be {@code null}.
 */

public final void drawPatch(@androidx.annotation.NonNull android.graphics.NinePatch patch, @androidx.annotation.NonNull android.graphics.Rect dst, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param patch This value must never be {@code null}.
 
 * @param dst This value must never be {@code null}.

 * @param paint This value may be {@code null}.
 */

public final void drawPatch(@androidx.annotation.NonNull android.graphics.NinePatch patch, @androidx.annotation.NonNull android.graphics.RectF dst, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param bitmap This value must never be {@code null}.

 * @param paint This value may be {@code null}.
 */

public final void drawBitmap(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, float left, float top, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param bitmap This value must never be {@code null}.
 
 * @param matrix This value must never be {@code null}.

 * @param paint This value may be {@code null}.
 */

public final void drawBitmap(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, @androidx.annotation.NonNull android.graphics.Matrix matrix, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param bitmap This value must never be {@code null}.

 * @param src This value may be {@code null}.
 
 * @param dst This value must never be {@code null}.

 * @param paint This value may be {@code null}.
 */

public final void drawBitmap(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, @androidx.annotation.Nullable android.graphics.Rect src, @androidx.annotation.NonNull android.graphics.Rect dst, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param bitmap This value must never be {@code null}.

 * @param src This value may be {@code null}.
 
 * @param dst This value must never be {@code null}.

 * @param paint This value may be {@code null}.
 */

public final void drawBitmap(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, @androidx.annotation.Nullable android.graphics.Rect src, @androidx.annotation.NonNull android.graphics.RectF dst, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated checkstyle
 * @param colors This value must never be {@code null}.

 * @param paint This value may be {@code null}.
 */

@Deprecated
public final void drawBitmap(@androidx.annotation.NonNull int[] colors, int offset, int stride, float x, float y, int width, int height, boolean hasAlpha, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated checkstyle
 * @param colors This value must never be {@code null}.

 * @param paint This value may be {@code null}.
 */

@Deprecated
public final void drawBitmap(@androidx.annotation.NonNull int[] colors, int offset, int stride, int x, int y, int width, int height, boolean hasAlpha, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

public final void drawColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param mode This value must never be {@code null}.
 */

public final void drawColor(int color, @androidx.annotation.NonNull android.graphics.PorterDuff.Mode mode) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param mode This value must never be {@code null}.
 */

public final void drawColor(int color, @androidx.annotation.NonNull android.graphics.BlendMode mode) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param mode This value must never be {@code null}.
 */

public final void drawColor(long color, @androidx.annotation.NonNull android.graphics.BlendMode mode) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param paint This value must never be {@code null}.
 */

public final void drawPoints(float[] pts, int offset, int count, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param pts This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawPoints(@androidx.annotation.NonNull float[] pts, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param paint This value must never be {@code null}.
 */

public final void drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param rect This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawRoundRect(@androidx.annotation.NonNull android.graphics.RectF rect, float rx, float ry, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param paint This value must never be {@code null}.
 */

public final void drawPaint(@androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param bitmap This value must never be {@code null}.

 * @param verts This value must never be {@code null}.
 
 * @param colors This value may be {@code null}.

 * @param paint This value may be {@code null}.
 */

public final void drawBitmapMesh(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, int meshWidth, int meshHeight, @androidx.annotation.NonNull float[] verts, int vertOffset, @androidx.annotation.Nullable int[] colors, int colorOffset, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param text This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawTextRun(@androidx.annotation.NonNull char[] text, int index, int count, int contextIndex, int contextCount, float x, float y, boolean isRtl, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param text This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawTextRun(@androidx.annotation.NonNull java.lang.CharSequence text, int start, int end, int contextStart, int contextEnd, float x, float y, boolean isRtl, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param measuredText This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public void drawTextRun(@androidx.annotation.NonNull android.graphics.text.MeasuredText measuredText, int start, int end, int contextStart, int contextEnd, float x, float y, boolean isRtl, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param paint This value must never be {@code null}.
 */

public final void drawCircle(float cx, float cy, float radius, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param text This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawText(@androidx.annotation.NonNull char[] text, int index, int count, float x, float y, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param text This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawText(@androidx.annotation.NonNull java.lang.CharSequence text, int start, int end, float x, float y, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param text This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawText(@androidx.annotation.NonNull java.lang.String text, float x, float y, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param text This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawText(@androidx.annotation.NonNull java.lang.String text, int start, int end, float x, float y, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param paint This value must never be {@code null}.
 */

public final void drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param oval This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawArc(@androidx.annotation.NonNull android.graphics.RectF oval, float startAngle, float sweepAngle, boolean useCenter, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param paint This value must never be {@code null}.
 */

public final void drawLine(float startX, float startY, float stopX, float stopY, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param mode This value must never be {@code null}.

 * @param verts This value must never be {@code null}.
 
 * @param texs This value may be {@code null}.

 * @param colors This value may be {@code null}.
 
 * @param indices This value may be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawVertices(@androidx.annotation.NonNull android.graphics.Canvas.VertexMode mode, int vertexCount, @androidx.annotation.NonNull float[] verts, int vertOffset, @androidx.annotation.Nullable float[] texs, int texOffset, @androidx.annotation.Nullable int[] colors, int colorOffset, @androidx.annotation.Nullable short[] indices, int indexOffset, int indexCount, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

public final void drawRGB(int r, int g, int b) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param pts This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawLines(@androidx.annotation.NonNull float[] pts, int offset, int count, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param pts This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawLines(@androidx.annotation.NonNull float[] pts, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param picture This value must never be {@code null}.
 */

public final void drawPicture(@androidx.annotation.NonNull android.graphics.Picture picture) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param picture This value must never be {@code null}.

 * @param dst This value must never be {@code null}.
 */

public final void drawPicture(@androidx.annotation.NonNull android.graphics.Picture picture, @androidx.annotation.NonNull android.graphics.Rect dst) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param picture This value must never be {@code null}.

 * @param dst This value must never be {@code null}.
 */

public final void drawPicture(@androidx.annotation.NonNull android.graphics.Picture picture, @androidx.annotation.NonNull android.graphics.RectF dst) { throw new RuntimeException("Stub!"); }

public final void drawARGB(int a, int r, int g, int b) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param path This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawPath(@androidx.annotation.NonNull android.graphics.Path path, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param paint This value must never be {@code null}.
 */

public final void drawRect(float left, float top, float right, float bottom, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param r This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawRect(@androidx.annotation.NonNull android.graphics.Rect r, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param rect This value must never be {@code null}.

 * @param paint This value must never be {@code null}.
 */

public final void drawRect(@androidx.annotation.NonNull android.graphics.RectF rect, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }
}

