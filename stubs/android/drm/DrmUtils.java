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

import java.util.Iterator;

/**
 * A utility class that provides operations for parsing extended metadata embedded in
 * DRM constraint information. If a DRM scheme has specific constraints beyond the standard
 * constraints, the constraints will show up in the
 * {@link android.drm.DrmStore.ConstraintsColumns#EXTENDED_METADATA DrmStore.ConstraintsColumns#EXTENDED_METADATA} key. You can use
 * {@link android.drm.DrmUtils.ExtendedMetadataParser DrmUtils.ExtendedMetadataParser} to iterate over those values.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DrmUtils {

public DrmUtils() { throw new RuntimeException("Stub!"); }

/**
 * Gets an instance of {@link android.drm.DrmUtils.ExtendedMetadataParser DrmUtils.ExtendedMetadataParser}, which can be used to parse
 * extended metadata embedded in DRM constraint information.
 *
 * @param extendedMetadata Object in which key-value pairs of extended metadata are embedded.
 *
 * @apiSince 11
 */

public static android.drm.DrmUtils.ExtendedMetadataParser getExtendedMetadataParser(byte[] extendedMetadata) { throw new RuntimeException("Stub!"); }
/**
 * Utility that parses extended metadata embedded in DRM constraint information.
 *<p>
 * Usage example:
 *<p>
 * byte[] extendedMetadata<br>
 * &nbsp;&nbsp;&nbsp;&nbsp; =
 *         constraints.getAsByteArray(DrmStore.ConstraintsColumns.EXTENDED_METADATA);<br>
 * ExtendedMetadataParser parser = getExtendedMetadataParser(extendedMetadata);<br>
 * Iterator keyIterator = parser.keyIterator();<br>
 * while (keyIterator.hasNext()) {<br>
 *     &nbsp;&nbsp;&nbsp;&nbsp;String extendedMetadataKey = keyIterator.next();<br>
 *     &nbsp;&nbsp;&nbsp;&nbsp;String extendedMetadataValue =
 *             parser.get(extendedMetadataKey);<br>
 * }
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class ExtendedMetadataParser {

private ExtendedMetadataParser() { throw new RuntimeException("Stub!"); }

/**
 * This method returns an iterator object that can be used to iterate over
 * all values of the metadata.
 *
 * @return The iterator object.
 * @apiSince 11
 */

public java.util.Iterator<java.lang.String> iterator() { throw new RuntimeException("Stub!"); }

/**
 * This method returns an iterator object that can be used to iterate over
 * all keys of the metadata.
 *
 * @return The iterator object.
 * @apiSince 11
 */

public java.util.Iterator<java.lang.String> keyIterator() { throw new RuntimeException("Stub!"); }

/**
 * This method retrieves the metadata value associated with a given key.
 *
 * @param key The key whose value is being retrieved.
 *
 * @return The metadata value associated with the given key. Returns null
 * if the key is not found.
 * @apiSince 11
 */

public java.lang.String get(java.lang.String key) { throw new RuntimeException("Stub!"); }
}

}

