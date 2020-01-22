/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.graphics.pdf;

import java.io.IOException;
import android.graphics.Matrix;
import android.graphics.Bitmap.Config;

/**
 * <p>
 * This class enables rendering a PDF document. This class is not thread safe.
 * </p>
 * <p>
 * If you want to render a PDF, you create a renderer and for every page you want
 * to render, you open the page, render it, and close the page. After you are done
 * with rendering, you close the renderer. After the renderer is closed it should not
 * be used anymore. Note that the pages are rendered one by one, i.e. you can have
 * only a single page opened at any given time.
 * </p>
 * <p>
 * A typical use of the APIs to render a PDF looks like this:
 * </p>
 * <pre>
 * // create a new renderer
 * PdfRenderer renderer = new PdfRenderer(getSeekableFileDescriptor());
 *
 * // let us just render all pages
 * final int pageCount = renderer.getPageCount();
 * for (int i = 0; i < pageCount; i++) {
 *     Page page = renderer.openPage(i);
 *
 *     // say we render for showing on the screen
 *     page.render(mBitmap, null, null, Page.RENDER_MODE_FOR_DISPLAY);
 *
 *     // do stuff with the bitmap
 *
 *     // close the page
 *     page.close();
 * }
 *
 * // close the renderer
 * renderer.close();
 * </pre>
 *
 * <h3>Print preview and print output</h3>
 * <p>
 * If you are using this class to rasterize a PDF for printing or show a print
 * preview, it is recommended that you respect the following contract in order
 * to provide a consistent user experience when seeing a preview and printing,
 * i.e. the user sees a preview that is the same as the printout.
 * </p>
 * <ul>
 * <li>
 * Respect the property whether the document would like to be scaled for printing
 * as per {@link #shouldScaleForPrinting()}.
 * </li>
 * <li>
 * When scaling a document for printing the aspect ratio should be preserved.
 * </li>
 * <li>
 * Do not inset the content with any margins from the {@link android.print.PrintAttributes}
 * as the application is responsible to render it such that the margins are respected.
 * </li>
 * <li>
 * If document page size is greater than the printed media size the content should
 * be anchored to the upper left corner of the page for left-to-right locales and
 * top right corner for right-to-left locales.
 * </li>
 * </ul>
 *
 * @see #close()
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PdfRenderer implements java.lang.AutoCloseable {

/**
 * Creates a new instance.
 * <p>
 * <strong>Note:</strong> The provided file descriptor must be <strong>seekable</strong>,
 * i.e. its data being randomly accessed, e.g. pointing to a file.
 * </p>
 * <p>
 * <strong>Note:</strong> This class takes ownership of the passed in file descriptor
 * and is responsible for closing it when the renderer is closed.
 * </p>
 * <p>
 * If the file is from an untrusted source it is recommended to run the renderer in a separate,
 * isolated process with minimal permissions to limit the impact of security exploits.
 * </p>
 *
 * @param input Seekable file descriptor to read from.
 *
 * This value must never be {@code null}.
 * @throws java.io.IOException If an error occurs while reading the file.
 * @throws java.lang.SecurityException If the file requires a password or
 *         the security scheme is not supported.
 * @apiSince 21
 */

public PdfRenderer(@androidx.annotation.NonNull android.os.ParcelFileDescriptor input) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes this renderer. You should not use this instance
 * after this method is called.
 * @apiSince 21
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of pages in the document.
 *
 * @return The page count.
 * @apiSince 21
 */

public int getPageCount() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether the document prefers to be scaled for printing.
 * You should take this info account if the document is rendered
 * for printing and the target media size differs from the page
 * size.
 *
 * @return If to scale the document.
 * @apiSince 21
 */

public boolean shouldScaleForPrinting() { throw new RuntimeException("Stub!"); }

/**
 * Opens a page for rendering.
 *
 * @param index The page index.
 * @return A page that can be rendered.
 *
 * @see android.graphics.pdf.PdfRenderer.Page#close() PdfRenderer.Page.close()
 * @apiSince 21
 */

public android.graphics.pdf.PdfRenderer.Page openPage(int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
/**
 * This class represents a PDF document page for rendering.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Page implements java.lang.AutoCloseable {

private Page() { throw new RuntimeException("Stub!"); }

/**
 * Gets the page index.
 *
 * @return The index.
 * @apiSince 21
 */

public int getIndex() { throw new RuntimeException("Stub!"); }

/**
 * Gets the page width in points (1/72").
 *
 * @return The width in points.
 * @apiSince 21
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Gets the page height in points (1/72").
 *
 * @return The height in points.
 * @apiSince 21
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Renders a page to a bitmap.
 * <p>
 * You may optionally specify a rectangular clip in the bitmap bounds. No rendering
 * outside the clip will be performed, hence it is your responsibility to initialize
 * the bitmap outside the clip.
 * </p>
 * <p>
 * You may optionally specify a matrix to transform the content from page coordinates
 * which are in points (1/72") to bitmap coordinates which are in pixels. If this
 * matrix is not provided this method will apply a transformation that will fit the
 * whole page to the destination clip if provided or the destination bitmap if no
 * clip is provided.
 * </p>
 * <p>
 * The clip and transformation are useful for implementing tile rendering where the
 * destination bitmap contains a portion of the image, for example when zooming.
 * Another useful application is for printing where the size of the bitmap holding
 * the page is too large and a client can render the page in stripes.
 * </p>
 * <p>
 * <strong>Note: </strong> The destination bitmap format must be
 * {@link android.graphics.Bitmap.Config#ARGB_8888 Config#ARGB_8888}.
 * </p>
 * <p>
 * <strong>Note: </strong> The optional transformation matrix must be affine as per
 * {@link android.graphics.Matrix#isAffine() Matrix.isAffine()}. Hence, you can specify
 * rotation, scaling, translation but not a perspective transformation.
 * </p>
 *
 * @param destination Destination bitmap to which to render.
 * This value must never be {@code null}.
 * @param destClip Optional clip in the bitmap bounds.
 * This value may be {@code null}.
 * @param transform Optional transformation to apply when rendering.
 * This value may be {@code null}.
 * @param renderMode The render mode.
 *
 * Value is {@link android.graphics.pdf.PdfRenderer.Page#RENDER_MODE_FOR_DISPLAY}, or {@link android.graphics.pdf.PdfRenderer.Page#RENDER_MODE_FOR_PRINT}
 * @see #RENDER_MODE_FOR_DISPLAY
 * @see #RENDER_MODE_FOR_PRINT
 * @apiSince 21
 */

public void render(@androidx.annotation.NonNull android.graphics.Bitmap destination, @androidx.annotation.Nullable android.graphics.Rect destClip, @androidx.annotation.Nullable android.graphics.Matrix transform, int renderMode) { throw new RuntimeException("Stub!"); }

/**
 * Closes this page.
 *
 * @see android.graphics.pdf.PdfRenderer#openPage(int)
 * @apiSince 21
 */

public void close() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Mode to render the content for display on a screen.
 * @apiSince 21
 */

public static final int RENDER_MODE_FOR_DISPLAY = 1; // 0x1

/**
 * Mode to render the content for printing.
 * @apiSince 21
 */

public static final int RENDER_MODE_FOR_PRINT = 2; // 0x2
}

}

