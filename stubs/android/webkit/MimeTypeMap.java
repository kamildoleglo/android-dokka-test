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


package android.webkit;


/**
 * Two-way map that maps MIME-types to file extensions and vice versa.
 *
 * <p>See also {@link java.net.URLConnection#guessContentTypeFromName}
 * and {@link java.net.URLConnection#guessContentTypeFromStream}. This
 * class and {@code URLConnection} share the same MIME-type database.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MimeTypeMap {

private MimeTypeMap() { throw new RuntimeException("Stub!"); }

/**
 * Returns the file extension or an empty string if there is no
 * extension. This method is a convenience method for obtaining the
 * extension of a url and has undefined results for other Strings.
 * @param url
 * @return The file extension of the given url.
 * @apiSince 1
 */

public static java.lang.String getFileExtensionFromUrl(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the given MIME type has an entry in the map.
 * @param mimeType A MIME type (i.e. text/plain)
 * @return {@code true} if there is a mimeType entry in the map.
 * @apiSince 1
 */

public boolean hasMimeType(java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Return the MIME type for the given extension.
 * @param extension A file extension without the leading '.'
 * @return The MIME type for the given extension or {@code null} if there is none.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String getMimeTypeFromExtension(java.lang.String extension) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the given extension has a registered MIME type.
 * @param extension A file extension without the leading '.'
 * @return {@code true} if there is an extension entry in the map.
 * @apiSince 1
 */

public boolean hasExtension(java.lang.String extension) { throw new RuntimeException("Stub!"); }

/**
 * Return the registered extension for the given MIME type. Note that some
 * MIME types map to multiple extensions. This call will return the most
 * common extension for the given MIME type.
 * @param mimeType A MIME type (i.e. text/plain)
 * @return The extension for the given MIME type or {@code null} if there is none.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String getExtensionFromMimeType(java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Get the singleton instance of MimeTypeMap.
 * @return The singleton instance of the MIME-type map.
 * @apiSince 1
 */

public static android.webkit.MimeTypeMap getSingleton() { throw new RuntimeException("Stub!"); }
}

