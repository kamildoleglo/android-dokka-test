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

import java.io.File;

/**
 * An entity class that wraps the license information retrieved from the online DRM server.
 *<p>
 * A caller can instantiate a {@link android.drm.DrmRights DrmRights} object by first invoking the
 * {@link android.drm.DrmManagerClient#processDrmInfo(android.drm.DrmInfo) DrmManagerClient#processDrmInfo(DrmInfo)} method and then using the resulting
 * {@link android.drm.ProcessedData ProcessedData} object to invoke the {@link android.drm.DrmRights#DrmRights(android.drm.ProcessedData,java.lang.String) DrmRights#DrmRights(ProcessedData, String)}
 * constructor.
 *<p>
 * A caller can also instantiate a {@link android.drm.DrmRights DrmRights} object by using the
 * {@link android.drm.DrmRights#DrmRights(java.lang.String,java.lang.String) DrmRights#DrmRights(String, String)} constructor, which takes a path to a file
 * containing rights information instead of a <code>ProcessedData</code>.
 *<p>
 * Please note that the account id and subscription id is not mandatory by all DRM agents
 * or plugins. When account id or subscription id is not required by the specific DRM
 * agent or plugin, they can be either null, or an empty string, or any other don't-care
 * string value.
 *
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DrmRights {

/**
 * Creates a <code>DrmRights</code> object with the given parameters.
 *
 * @param rightsFilePath Path to the file containing rights information.
 * @param mimeType MIME type. Must not be null or an empty string.
 * @apiSince 11
 */

public DrmRights(java.lang.String rightsFilePath, java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Creates a <code>DrmRights</code> object with the given parameters.
 *
 * @param rightsFilePath Path to the file containing rights information.
 * @param mimeType MIME type. Must not be null or an empty string.
 * @param accountId Account ID of the user.
 * @apiSince 11
 */

public DrmRights(java.lang.String rightsFilePath, java.lang.String mimeType, java.lang.String accountId) { throw new RuntimeException("Stub!"); }

/**
 * Creates a <code>DrmRights</code> object with the given parameters.
 *
 * @param rightsFilePath Path to the file containing rights information.
 * @param mimeType MIME type. Must not be null or an empty string.
 * @param accountId Account ID of the user.
 * @param subscriptionId Subscription ID of the user.
 * @apiSince 11
 */

public DrmRights(java.lang.String rightsFilePath, java.lang.String mimeType, java.lang.String accountId, java.lang.String subscriptionId) { throw new RuntimeException("Stub!"); }

/**
 * Creates a <code>DrmRights</code> object with the given parameters.
 *
 * @param rightsFile File containing rights information.
 * @param mimeType MIME type. Must not be null or an empty string.
 * @apiSince 11
 */

public DrmRights(java.io.File rightsFile, java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Creates a <code>DrmRights</code> object with the given parameters.
 *
 * @param data A {@link android.drm.ProcessedData ProcessedData} object containing rights information.
 *             Must not be null.
 * @param mimeType The MIME type. It must not be null or an empty string.
 * @apiSince 11
 */

public DrmRights(android.drm.ProcessedData data, java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the rights data associated with this <code>DrmRights</code> object.
 *
 * @return A <code>byte</code> array representing the rights data.
 * @apiSince 11
 */

public byte[] getData() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the MIME type associated with this <code>DrmRights</code> object.
 *
 * @return The MIME type.
 * @apiSince 11
 */

public java.lang.String getMimeType() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the account ID associated with this <code>DrmRights</code> object.
 *
 * @return The account ID.
 * @apiSince 11
 */

public java.lang.String getAccountId() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the subscription ID associated with this <code>DrmRights</code> object.
 *
 * @return The subscription ID.
 * @apiSince 11
 */

public java.lang.String getSubscriptionId() { throw new RuntimeException("Stub!"); }
}

