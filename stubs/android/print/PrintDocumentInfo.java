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


package android.print;


/**
 * This class encapsulates information about a document for printing
 * purposes. This meta-data is used by the platform and print services,
 * components that interact with printers. For example, this class
 * contains the number of pages contained in the document it describes and
 * this number of pages is shown to the user allowing him/her to select
 * the range to print. Also a print service may optimize the printing
 * process based on the content type, such as document or photo.
 * <p>
 * Instances of this class are created by the printing application and
 * passed to the {@link android.print.PrintDocumentAdapter.LayoutResultCallback#onLayoutFinished(android.print.PrintDocumentInfo,boolean) PrintDocumentAdapter.LayoutResultCallback#onLayoutFinished(
 * PrintDocumentInfo, boolean)} callback after successfully laying out the
 * content which is performed in {@link android.print.PrintDocumentAdapter#onLayout(android.print.PrintAttributes,android.print.PrintAttributes,android.os.CancellationSignal,android.print.PrintDocumentAdapter.LayoutResultCallback,android.os.Bundle) PrintDocumentAdapter#onLayout(PrintAttributes,
 * PrintAttributes, android.os.CancellationSignal, PrintDocumentAdapter.LayoutResultCallback,
 * android.os.Bundle)}.
 * </p>
 * <p>
 * An example usage looks like this:
 * <pre>
 *
 * . . .
 *
 * public void onLayout(PrintAttributes oldAttributes, PrintAttributes newAttributes,
 *         CancellationSignal cancellationSignal, LayoutResultCallback callback,
 *         Bundle metadata) {
 *
 *        // Assume the app defined a LayoutResult class which contains
 *        // the layout result data and that the content is a document.
 *        LayoutResult result = doSomeLayoutWork();
 *
 *        PrintDocumentInfo info = new PrintDocumentInfo
 *                .Builder("printed_file.pdf")
 *                .setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
 *                .setPageCount(result.getPageCount())
 *                .build();
 *
 *       callback.onLayoutFinished(info, result.getContentChanged());
 *   }
 *
 *   . . .
 *
 * </pre>
 * </p>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PrintDocumentInfo implements android.os.Parcelable {

private PrintDocumentInfo() { throw new RuntimeException("Stub!"); }

/**
 * Gets the document name. This name may be shown to
 * the user.
 *
 * @return The document name.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Gets the total number of pages.
 *
 * @return The number of pages.
 *
 * Value is -1 or greater
 * @see #PAGE_COUNT_UNKNOWN
 * @apiSince 19
 */

public int getPageCount() { throw new RuntimeException("Stub!"); }

/**
 * Gets the content type.
 *
 * @return The content type.
 *
 * @see #CONTENT_TYPE_UNKNOWN
 * @see #CONTENT_TYPE_DOCUMENT
 * @see #CONTENT_TYPE_PHOTO
 * @apiSince 19
 */

public int getContentType() { throw new RuntimeException("Stub!"); }

/**
 * Gets the document data size in bytes.
 *
 * @return The data size.
 
 * Value is 0 or greater
 * @apiSince 19
 */

public long getDataSize() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Content type: document.
 * <p>
 * A print service may use normal paper to print the content instead
 * of dedicated photo paper. Also it may use a lower quality printing
 * process as the content is not as sensitive to print quality variation
 * as a photo is.
 * </p>
 * @apiSince 19
 */

public static final int CONTENT_TYPE_DOCUMENT = 0; // 0x0

/**
 * Content type: photo.
 * <p>
 * A print service may use dedicated photo paper to print the content
 * instead of normal paper. Also it may use a higher quality printing
 * process as the content is more sensitive to print quality variation
 * than a document.
 * </p>
 * @apiSince 19
 */

public static final int CONTENT_TYPE_PHOTO = 1; // 0x1

/**
 * Content type: unknown.
 * @apiSince 19
 */

public static final int CONTENT_TYPE_UNKNOWN = -1; // 0xffffffff

/** @apiSince 19 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.print.PrintDocumentInfo> CREATOR;
static { CREATOR = null; }

/**
 * Constant for unknown page count.
 * @apiSince 19
 */

public static final int PAGE_COUNT_UNKNOWN = -1; // 0xffffffff
/**
 * Builder for creating a {@link android.print.PrintDocumentInfo PrintDocumentInfo}.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Constructor.
 *
 * <p>
 * The values of the relevant properties are initialized with defaults.
 * Please refer to the documentation of the individual setters for
 * information about the default values.
 * </p>
 *
 * @param name The document name which may be shown to the user and
 * is the file name if the content it describes is saved as a PDF.
 * Cannot be empty.
 
 * This value must never be {@code null}.
 * @apiSince 19
 */

public Builder(@androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Sets the total number of pages.
 * <p>
 * <strong>Default: </strong> {@link #PAGE_COUNT_UNKNOWN}
 * </p>
 *
 * @param pageCount The number of pages. Must be greater than or equal to zero or
 *            {@link android.print.PrintDocumentInfo#PAGE_COUNT_UNKNOWN PrintDocumentInfo#PAGE_COUNT_UNKNOWN}.
 * Value is -1 or greater
 * @return This builder.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrintDocumentInfo.Builder setPageCount(int pageCount) { throw new RuntimeException("Stub!"); }

/**
 * Sets the content type.
 * <p>
 * <strong>Default: </strong> {@link #CONTENT_TYPE_DOCUMENT}
 * </p>
 *
 * @param type The content type.
 * Value is {@link android.print.PrintDocumentInfo#CONTENT_TYPE_UNKNOWN}, {@link android.print.PrintDocumentInfo#CONTENT_TYPE_DOCUMENT}, or {@link android.print.PrintDocumentInfo#CONTENT_TYPE_PHOTO}
 * @return This builder.
 * This value will never be {@code null}.
 * @see #CONTENT_TYPE_UNKNOWN
 * @see #CONTENT_TYPE_DOCUMENT
 * @see #CONTENT_TYPE_PHOTO
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrintDocumentInfo.Builder setContentType(int type) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link android.print.PrintDocumentInfo PrintDocumentInfo} instance.
 *
 * @return The new instance.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrintDocumentInfo build() { throw new RuntimeException("Stub!"); }
}

}

