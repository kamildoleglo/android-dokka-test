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
 * An entity class that wraps the result of a
 * {@link android.drm.DrmManagerClient#processDrmInfo(android.drm.DrmInfo) DrmManagerClient#processDrmInfo(DrmInfo)}
 * transaction between a device and a DRM server.
 *
 * In a license acquisition scenario this class holds the rights information in binary form.
 *
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ProcessedData {

ProcessedData() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the processed data.
 *
 * @return The rights data.
 * @apiSince 11
 */

public byte[] getData() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the account ID associated with this object.
 *
 * @return The account ID of the user.
 * @apiSince 11
 */

public java.lang.String getAccountId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the subscription ID associated with this object.
 *
 * @return The subscription ID of the user.
 * @apiSince 11
 */

public java.lang.String getSubscriptionId() { throw new RuntimeException("Stub!"); }
}

