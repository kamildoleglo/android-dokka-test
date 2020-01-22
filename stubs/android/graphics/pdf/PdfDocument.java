/*
 * Copyright (C) 2013 The Android Open Source Project
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

import android.graphics.Rect;
import java.io.IOException;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * <p>
 * This class enables generating a PDF document from native Android content. You
 * create a new document and then for every page you want to add you start a page,
 * write content to the page, and finish the page. After you are done with all
 * pages, you write the document to an output stream and close the document.
 * After a document is closed you should not use it anymore. Note that pages are
 * created one by one, i.e. you can have only a single page to which you are
 * writing at any given time. This class is not thread safe.
 * </p>
 * <p>
 * A typical use of the APIs looks like this:
 * </p>
 * <pre>
 * // create a new document
 * PdfDocument document = new PdfDocument();
 *
 * // crate a page description
 * PageInfo pageInfo = new PageInfo.Builder(new Rect(0, 0, 100, 100), 1).create();
 *
 * // start a page
 * Page page = document.startPage(pageInfo);
 *
 * // draw something on the page
 * View content = getContentView();
 * content.draw(page.getCanvas());
 *
 * // finish the page
 * document.finishPage(page);
 * . . .
 * // add more pages
 * . . .
 * // write the document content
 * document.writeTo(getOutputStream());
 *
 * // close the document
 * document.close();
 * </pre>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PdfDocument {

/**
 * Creates a new instance.
 * @apiSince 19
 */

public PdfDocument() { throw new RuntimeException("Stub!"); }

/**
 * Starts a page using the provided {@link android.graphics.pdf.PdfDocument.PageInfo PageInfo}. After the page
 * is created you can draw arbitrary content on the page's canvas which
 * you can get by calling {@link android.graphics.pdf.PdfDocument.Page#getCanvas() Page#getCanvas()}. After you are done
 * drawing the content you should finish the page by calling
 * {@link #finishPage(android.graphics.pdf.PdfDocument.Page)}. After the page is finished you should
 * no longer access the page or its canvas.
 * <p>
 * <strong>Note:</strong> Do not call this method after {@link #close()}.
 * Also do not call this method if the last page returned by this method
 * is not finished by calling {@link #finishPage(android.graphics.pdf.PdfDocument.Page)}.
 * </p>
 *
 * @param pageInfo The page info. Cannot be null.
 * @return A blank page.
 *
 * @see #finishPage(Page)
 * @apiSince 19
 */

public android.graphics.pdf.PdfDocument.Page startPage(android.graphics.pdf.PdfDocument.PageInfo pageInfo) { throw new RuntimeException("Stub!"); }

/**
 * Finishes a started page. You should always finish the last started page.
 * <p>
 * <strong>Note:</strong> Do not call this method after {@link #close()}.
 * You should not finish the same page more than once.
 * </p>
 *
 * @param page The page. Cannot be null.
 *
 * @see #startPage(PageInfo)
 * @apiSince 19
 */

public void finishPage(android.graphics.pdf.PdfDocument.Page page) { throw new RuntimeException("Stub!"); }

/**
 * Writes the document to an output stream. You can call this method
 * multiple times.
 * <p>
 * <strong>Note:</strong> Do not call this method after {@link #close()}.
 * Also do not call this method if a page returned by {@link #startPage(android.graphics.pdf.PdfDocument.PageInfo)} is not finished by calling {@link #finishPage(android.graphics.pdf.PdfDocument.Page)}.
 * </p>
 *
 * @param out The output stream. Cannot be null.
 *
 * @throws java.io.IOException If an error occurs while writing.
 * @apiSince 19
 */

public void writeTo(java.io.OutputStream out) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Gets the pages of the document.
 *
 * @return The pages or an empty list.
 * @apiSince 19
 */

public java.util.List<android.graphics.pdf.PdfDocument.PageInfo> getPages() { throw new RuntimeException("Stub!"); }

/**
 * Closes this document. This method should be called after you
 * are done working with the document. After this call the document
 * is considered closed and none of its methods should be called.
 * <p>
 * <strong>Note:</strong> Do not call this method if the page
 * returned by {@link #startPage(android.graphics.pdf.PdfDocument.PageInfo)} is not finished by
 * calling {@link #finishPage(android.graphics.pdf.PdfDocument.Page)}.
 * </p>
 * @apiSince 19
 */

public void close() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
/**
 * This class represents a PDF document page. It has associated
 * a canvas on which you can draw content and is acquired by a
 * call to {@link #getCanvas()}. It also has associated a
 * {@link android.graphics.pdf.PdfDocument.PageInfo PageInfo} instance that describes its attributes. Also
 * a page has
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Page {

private Page() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.graphics.Canvas Canvas} of the page.
 *
 * <p>
 * <strong>Note: </strong> There are some draw operations that are not yet
 * supported by the canvas returned by this method. More specifically:
 * <ul>
 * <li>Inverse path clipping performed via {@link android.graphics.Canvas#clipPath(android.graphics.Path,android.graphics.Region.Op) Canvas#clipPath(android.graphics.Path,
 *     android.graphics.Region.Op)} for {@link
 *     android.graphics.Region.Op#REVERSE_DIFFERENCE
 *     Region.Op#REVERSE_DIFFERENCE} operations.</li>
 * <li>{@link android.graphics.Canvas#drawVertices(android.graphics.Canvas.VertexMode,int,float[],int,float[],int,int[],int,short[],int,int,android.graphics.Paint) Canvas#drawVertices(android.graphics.Canvas.VertexMode, int,
 *     float[], int, float[], int, int[], int, short[], int, int,
 *     android.graphics.Paint)}</li>
 * <li>Color filters set via {@link android.graphics.Paint#setColorFilter(android.graphics.ColorFilter) Paint#setColorFilter(
 *     android.graphics.ColorFilter)}</li>
 * <li>Mask filters set via {@link android.graphics.Paint#setMaskFilter(android.graphics.MaskFilter) Paint#setMaskFilter(
 *     android.graphics.MaskFilter)}</li>
 * <li>Some XFER modes such as
 *     {@link android.graphics.PorterDuff.Mode#SRC_ATOP PorterDuff.Mode SRC},
 *     {@link android.graphics.PorterDuff.Mode#DST_ATOP PorterDuff.DST_ATOP},
 *     {@link android.graphics.PorterDuff.Mode#XOR PorterDuff.XOR},
 *     {@link android.graphics.PorterDuff.Mode#ADD PorterDuff.ADD}</li>
 * </ul>
 *
 * @return The canvas if the page is not finished, null otherwise.
 *
 * @see android.graphics.pdf.PdfDocument#finishPage(Page)
 * @apiSince 19
 */

public android.graphics.Canvas getCanvas() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.graphics.pdf.PdfDocument.PageInfo PageInfo} with meta-data for the page.
 *
 * @return The page info.
 *
 * @see android.graphics.pdf.PdfDocument#finishPage(Page)
 * @apiSince 19
 */

public android.graphics.pdf.PdfDocument.PageInfo getInfo() { throw new RuntimeException("Stub!"); }
}

/**
 * This class represents meta-data that describes a PDF {@link android.graphics.pdf.PdfDocument.Page Page}.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class PageInfo {

private PageInfo() { throw new RuntimeException("Stub!"); }

/**
 * Gets the page width in PostScript points (1/72th of an inch).
 *
 * @return The page width.
 * @apiSince 19
 */

public int getPageWidth() { throw new RuntimeException("Stub!"); }

/**
 * Gets the page height in PostScript points (1/72th of an inch).
 *
 * @return The page height.
 * @apiSince 19
 */

public int getPageHeight() { throw new RuntimeException("Stub!"); }

/**
 * Get the content rectangle in PostScript points (1/72th of an inch).
 * This is the area that contains the page content and is relative to
 * the page top left.
 *
 * @return The content rectangle.
 * @apiSince 19
 */

public android.graphics.Rect getContentRect() { throw new RuntimeException("Stub!"); }

/**
 * Gets the page number.
 *
 * @return The page number.
 * @apiSince 19
 */

public int getPageNumber() { throw new RuntimeException("Stub!"); }
/**
 * Builder for creating a {@link android.graphics.pdf.PdfDocument.PageInfo PageInfo}.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a new builder with the mandatory page info attributes.
 *
 * @param pageWidth The page width in PostScript (1/72th of an inch).
 * @param pageHeight The page height in PostScript (1/72th of an inch).
 * @param pageNumber The page number.
 * @apiSince 19
 */

public Builder(int pageWidth, int pageHeight, int pageNumber) { throw new RuntimeException("Stub!"); }

/**
 * Sets the content rectangle in PostScript point (1/72th of an inch).
 * This is the area that contains the page content and is relative to
 * the page top left.
 *
 * @param contentRect The content rectangle. Must fit in the page.
 * @apiSince 19
 */

public android.graphics.pdf.PdfDocument.PageInfo.Builder setContentRect(android.graphics.Rect contentRect) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link android.graphics.pdf.PdfDocument.PageInfo PageInfo}.
 *
 * @return The new instance.
 * @apiSince 19
 */

public android.graphics.pdf.PdfDocument.PageInfo create() { throw new RuntimeException("Stub!"); }
}

}

}

