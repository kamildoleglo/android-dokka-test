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


package android.drm;


/**
 * An entity class that wraps the capability of each DRM plug-in (agent),
 * such as the MIME type and file suffix the DRM plug-in can handle.
 *<p>
 * Plug-in developers can expose the capability of their plug-in by passing an instance of this
 * class to an application.
 *
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DrmSupportInfo {

public DrmSupportInfo() { throw new RuntimeException("Stub!"); }

/**
 * Adds the specified MIME type to the list of MIME types this DRM plug-in supports.
 *
 * @param mimeType MIME type that can be handles by this DRM plug-in.
 * Must not be null or an empty string.
 * @apiSince 11
 */

public void addMimeType(java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Adds the specified file suffix to the list of file suffixes this DRM plug-in supports.
 *
 * @param fileSuffix File suffix that can be handled by this DRM plug-in.
 * it could be null but not an empty string. When it is null, it indicates
 * that some DRM content comes with no file suffix.
 * @apiSince 11
 */

public void addFileSuffix(java.lang.String fileSuffix) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves an iterator object that you can use to iterate over the MIME types that
 * this DRM plug-in supports.
 *
 * @return The iterator object
 * @apiSince 11
 */

public java.util.Iterator<java.lang.String> getMimeTypeIterator() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves an iterator object that you can use to iterate over the file suffixes that
 * this DRM plug-in supports.
 *
 * @return The iterator object.
 * @apiSince 11
 */

public java.util.Iterator<java.lang.String> getFileSuffixIterator() { throw new RuntimeException("Stub!"); }

/**
 * Sets a description for the DRM plug-in (agent).
 *
 * @param description Unique description of plug-in. Must not be null
 * or an empty string.
 * @apiSince 11
 */

public void setDescription(java.lang.String description) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the DRM plug-in (agent) description.
 *
 * @return The plug-in description.
 * @deprecated The method name is mis-spelled, and it is replaced by
 * {@link #getDescription()}.
 * @apiSince 11
 * @deprecatedSince 16
 */

@Deprecated
public java.lang.String getDescriprition() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the DRM plug-in (agent) description. Even if null or an empty
 * string is not allowed in {@link #setDescription(java.lang.String)}, if
 * {@link #setDescription(java.lang.String)} is not called, description returned
 * from this method is an empty string.
 *
 * @return The plug-in description.
 * @apiSince 16
 */

public java.lang.String getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Overridden hash code implementation.
 *
 * @return The hash code value.
 * @apiSince 11
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Overridden <code>equals</code> implementation. Two DrmSupportInfo objects
 * are considered being equal if they support exactly the same set of mime
 * types, file suffixes, and has exactly the same description.
 *
 * @param object The object to be compared.
 * @return True if equal; false if not equal.
 * @apiSince 11
 */

public boolean equals(java.lang.Object object) { throw new RuntimeException("Stub!"); }
}

