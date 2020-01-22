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
 * An entity class that wraps the result of communication between a device
 * and an online DRM server. Specifically, when the
 * {@link android.drm.DrmManagerClient#processDrmInfo DrmManagerClient#processDrmInfo}
 * method is called, an instance of <code>DrmInfoStatus</code> is returned.
 *<p>
 * This class contains the {@link android.drm.ProcessedData ProcessedData} object, which can be used
 * to instantiate a {@link android.drm.DrmRights DrmRights} object during license acquisition.
 *
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DrmInfoStatus {

/**
 * Creates a <code>DrmInfoStatus</code> object with the specified parameters.
 *
 * @param statusCode The status of the communication. Must be one of the defined
 * status constants above.
 * @param infoType The type of the DRM information processed. Must be a valid
 * type for {@link android.drm.DrmInfoRequest DrmInfoRequest}.
 * @param data The processed data.
 * @param mimeType The MIME type.
 * @apiSince 11
 */

public DrmInfoStatus(int statusCode, int infoType, android.drm.ProcessedData data, java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Indicate failed communication.
 * @apiSince 11
 */

public static final int STATUS_ERROR = 2; // 0x2

/**
 * Indicate successful communication.
 * @apiSince 11
 */

public static final int STATUS_OK = 1; // 0x1

/**
 * The processed data. It is optional and thus could be null. When it
 * is null, it indicates that a particular call to
 * {@link android.drm.DrmManagerClient#processDrmInfo DrmManagerClient#processDrmInfo}
 * does not return any additional useful information except for the status code.
 * @apiSince 11
 */

public final android.drm.ProcessedData data;
{ data = null; }

/**
 * The type of DRM information processed. Must be one of the valid type
 * constants defined in {@link android.drm.DrmInfoRequest DrmInfoRequest}.
 * @apiSince 11
 */

public final int infoType;
{ infoType = 0; }

/**
 * The MIME type of the content. Must not be null or an empty string.
 * @apiSince 11
 */

public final java.lang.String mimeType;
{ mimeType = null; }

/**
 * The status of the communication. Must be one of the defined status
 * constants above.
 * @apiSince 11
 */

public final int statusCode;
{ statusCode = 0; }
}

