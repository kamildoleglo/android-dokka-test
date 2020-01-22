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
 * An entity class that describes the information required to send transactions
 * between a device and an online DRM server. The DRM framework achieves
 * server registration, license acquisition, and any other server-related transactions
 * by passing an instance of this class to {@link android.drm.DrmManagerClient#processDrmInfo DrmManagerClient#processDrmInfo}.
 *<p>
 * The caller can retrieve the {@link android.drm.DrmInfo DrmInfo} instance by passing a {@link android.drm.DrmInfoRequest DrmInfoRequest}
 * instance to {@link android.drm.DrmManagerClient#acquireDrmInfo DrmManagerClient#acquireDrmInfo}.
 *
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DrmInfo {

/**
 * Creates a <code>DrmInfo</code> object with the given parameters.
 *
 * @param infoType The type of information.
 * @param data The trigger data.
 * @param mimeType The MIME type.
 * @apiSince 11
 */

public DrmInfo(int infoType, byte[] data, java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Creates a <code>DrmInfo</code> object with the given parameters.
 *
 * @param infoType The type of information.
 * @param path The trigger data.
 * @param mimeType The MIME type.
 * @apiSince 11
 */

public DrmInfo(int infoType, java.lang.String path, java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Adds optional information as key-value pairs to this object. To add a custom object
 * to the <code>DrmInfo</code> object, you must override the {@link #toString} implementation.
 *
 * @param key Key to add.
 * @param value Value to add.
 *
 * @apiSince 11
 */

public void put(java.lang.String key, java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the value of a given key.
 *
 * @param key The key whose value is being retrieved.
 *
 * @return The value of the key being retrieved. Returns null if the key cannot be found.
 * @apiSince 11
 */

public java.lang.Object get(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves an iterator object that you can use to iterate over the keys associated with
 * this <code>DrmInfo</code> object.
 *
 * @return The iterator object.
 * @apiSince 11
 */

public java.util.Iterator<java.lang.String> keyIterator() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves an iterator object that you can use to iterate over the values associated with
 * this <code>DrmInfo</code> object.
 *
 * @return The iterator object.
 * @apiSince 11
 */

public java.util.Iterator<java.lang.Object> iterator() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the trigger data associated with this object.
 *
 * @return The trigger data.
 * @apiSince 11
 */

public byte[] getData() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the MIME type associated with this object.
 *
 * @return The MIME type.
 * @apiSince 11
 */

public java.lang.String getMimeType() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the information type associated with this object.
 *
 * @return The information type.
 * @apiSince 11
 */

public int getInfoType() { throw new RuntimeException("Stub!"); }
}

