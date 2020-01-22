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
 * An entity class that is used to pass information to an online DRM server. An instance of this
 * class is passed to the {@link android.drm.DrmManagerClient#acquireDrmInfo DrmManagerClient#acquireDrmInfo} method to get an
 * instance of a {@link android.drm.DrmInfo DrmInfo}.
 *
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DrmInfoRequest {

/**
 * Creates a <code>DrmInfoRequest</code> object with type and MIME type.
 *
 * @param infoType Type of information.
 * @param mimeType MIME type.
 * @apiSince 11
 */

public DrmInfoRequest(int infoType, java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

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

/**
 * Adds optional information as key-value pairs to this object.
 *
 * @param key The key to add.
 * @param value The value to add.
 * @apiSince 11
 */

public void put(java.lang.String key, java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the value of a given key.
 *
 * @param key The key whose value is being retrieved.
 *
 * @return The value of the key that is being retrieved. Returns null if the key cannot be
 * found.
 * @apiSince 11
 */

public java.lang.Object get(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves an iterator object that you can use to iterate over the keys associated with
 * this <code>DrmInfoRequest</code> object.
 *
 * @return The iterator object.
 * @apiSince 11
 */

public java.util.Iterator<java.lang.String> keyIterator() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves an iterator object that you can use to iterate over the values associated with
 * this <code>DrmInfoRequest</code> object.
 *
 * @return The iterator object.
 * @apiSince 11
 */

public java.util.Iterator<java.lang.Object> iterator() { throw new RuntimeException("Stub!"); }

/**
 * Key that is used to pass the unique session ID for the account or the user.
 * @apiSince 11
 */

public static final java.lang.String ACCOUNT_ID = "account_id";

/**
 * Key that is used to pass the unique session ID for the subscription.
 * @apiSince 11
 */

public static final java.lang.String SUBSCRIPTION_ID = "subscription_id";

/**
 * Acquires DRM server registration information.
 * @apiSince 11
 */

public static final int TYPE_REGISTRATION_INFO = 1; // 0x1

/**
 * Acquires rights information.
 * @apiSince 11
 */

public static final int TYPE_RIGHTS_ACQUISITION_INFO = 3; // 0x3

/**
 * Acquires the progress of the rights acquisition.
 * @apiSince 11
 */

public static final int TYPE_RIGHTS_ACQUISITION_PROGRESS_INFO = 4; // 0x4

/**
 * Acquires information for unregistering the DRM server.
 * @apiSince 11
 */

public static final int TYPE_UNREGISTRATION_INFO = 2; // 0x2
}

