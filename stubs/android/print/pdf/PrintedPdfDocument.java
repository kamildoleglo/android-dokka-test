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


package android.print.pdf;

import android.graphics.pdf.PdfDocument;
import android.content.Context;

/**
 * This class is a helper for creating a PDF file for given print attributes. It is useful for
 * implementing printing via the native Android graphics APIs.
 * <p>
 * This class computes the page width, page height, and content rectangle from the provided print
 * attributes and these precomputed values can be accessed via {@link #getPageWidth()},
 * {@link #getPageHeight()}, and {@link #getPageContentRect()}, respectively. The
 * {@link #startPage(int)} methods creates pages whose
 * {@link android.graphics.pdf.PdfDocument.PageInfo PageInfo} is initialized with the precomputed
 * values for width, height, and content rectangle.
 * <p>
 * A typical use of the APIs looks like this:
 * </p>
 * <pre>
 * // open a new document
 * PrintedPdfDocument document = new PrintedPdfDocument(context,
 *         printAttributes);
 *
 * // start a page
 * Page page = document.startPage(0);
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
 * //close the document
 * document.close();
 * </pre>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PrintedPdfDocument extends android.graphics.pdf.PdfDocument {

/**
 * Creates a new document.
 * <p>
 * <strong>Note:</strong> You must close the document after you are
 * done by calling {@link #close()}.
 * </p>
 *
 * @param context Context instance for accessing resources.
 * This value must never be {@code null}.
 * @param attributes The print attributes.
 
 * This value must never be {@code null}.
 * @apiSince 19
 */

public PrintedPdfDocument(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.print.PrintAttributes attributes) { throw new RuntimeException("Stub!"); }

/**
 * Starts a new page. The page is created using width, height and content rectangle computed
 * from the print attributes passed in the constructor and the given page number to create an
 * appropriate {@link android.graphics.pdf.PdfDocument.PageInfo PageInfo}.
 * <p>
 * After the page is created you can draw arbitrary content on the page's canvas which you can
 * get by calling {@link android.graphics.pdf.PdfDocument.Page#getCanvas() Page.getCanvas()}.
 * After you are done drawing the content you should finish the page by calling
 * {@link #finishPage(android.graphics.pdf.PdfDocument.Page)}. After the page is finished you should no longer access the page or
 * its canvas.
 * </p>
 * <p>
 * <strong>Note:</strong> Do not call this method after {@link #close()}. Also do not call this
 * method if the last page returned by this method is not finished by calling
 * {@link #finishPage(android.graphics.pdf.PdfDocument.Page)}.
 * </p>
 *
 * @param pageNumber The page number. Must be a non negative.
 * Value is 0 or greater
 * @return A blank page.
 *
 * This value will never be {@code null}.
 * @see #finishPage(Page)
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.graphics.pdf.PdfDocument.Page startPage(int pageNumber) { throw new RuntimeException("Stub!"); }

/**
 * Gets the page width.
 *
 * @return The page width in PostScript points (1/72th of an inch).
 
 * Value is 0 or greater
 * @apiSince 19
 */

public int getPageWidth() { throw new RuntimeException("Stub!"); }

/**
 * Gets the page height.
 *
 * @return The page height in PostScript points (1/72th of an inch).
 
 * Value is 0 or greater
 * @apiSince 19
 */

public int getPageHeight() { throw new RuntimeException("Stub!"); }

/**
 * Gets the content rectangle. This is the area of the page that
 * contains printed data and is relative to the page top left.
 *
 * @return The content rectangle.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.graphics.Rect getPageContentRect() { throw new RuntimeException("Stub!"); }
}

