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


package android.printservice;

import android.print.PrintDocumentInfo;

/**
 * This class represents a printed document from the perspective of a print
 * service. It exposes APIs to query the document and obtain its data.
 * <p>
 * <strong>Note: </strong> All methods of this class must be executed on the
 * main application thread.
 * </p>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PrintDocument {

PrintDocument() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.print.PrintDocumentInfo PrintDocumentInfo} that describes this document.
 *
 * @return The document info.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrintDocumentInfo getInfo() { throw new RuntimeException("Stub!"); }

/**
 * Gets the data associated with this document.
 * <p>
 * <strong>Note: </strong> It is a responsibility of the client to open a
 * stream to the returned file descriptor, fully read the data, and close
 * the file descriptor.
 * </p>
 *
 * @return A file descriptor for reading the data.
 
 * This value may be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.os.ParcelFileDescriptor getData() { throw new RuntimeException("Stub!"); }
}

