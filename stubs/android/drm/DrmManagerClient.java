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

import android.content.Context;
import android.content.ContentValues;
import java.io.IOException;
import java.io.File;

/**
 * The main programming interface for the DRM framework. An application must instantiate this class
 * to access DRM agents through the DRM framework.
 *
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DrmManagerClient implements java.lang.AutoCloseable {

/**
 * Creates a <code>DrmManagerClient</code>.
 *
 * @param context Context of the caller.
 * @apiSince 11
 */

public DrmManagerClient(android.content.Context context) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Releases resources associated with the current session of
 * DrmManagerClient. It is considered good practice to call this method when
 * the {@link android.drm.DrmManagerClient DrmManagerClient} object is no longer needed in your
 * application. After this method is called, {@link android.drm.DrmManagerClient DrmManagerClient} is no
 * longer usable since it has lost all of its required resource.
 *
 * This method was added in API 24. In API versions 16 through 23, release()
 * should be called instead. There is no need to do anything for API
 * versions prior to 16.
 * @apiSince 24
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated replaced by {@link #close()}.
 * @apiSince 16
 * @deprecatedSince 24
 */

@Deprecated
public void release() { throw new RuntimeException("Stub!"); }

/**
 * Registers an {@link android.drm.DrmManagerClient.OnInfoListener DrmManagerClient.OnInfoListener} callback, which is invoked when the
 * DRM framework sends status or warning information during registration or rights acquisition.
 *
 * @param infoListener Interface definition for the callback.
 * @apiSince 11
 */

public synchronized void setOnInfoListener(android.drm.DrmManagerClient.OnInfoListener infoListener) { throw new RuntimeException("Stub!"); }

/**
 * Registers an {@link android.drm.DrmManagerClient.OnEventListener DrmManagerClient.OnEventListener} callback, which is invoked when the
 * DRM framework sends information about DRM processing.
 *
 * @param eventListener Interface definition for the callback.
 * @apiSince 11
 */

public synchronized void setOnEventListener(android.drm.DrmManagerClient.OnEventListener eventListener) { throw new RuntimeException("Stub!"); }

/**
 * Registers an {@link android.drm.DrmManagerClient.OnErrorListener DrmManagerClient.OnErrorListener} callback, which is invoked when
 * the DRM framework sends error information.
 *
 * @param errorListener Interface definition for the callback.
 * @apiSince 11
 */

public synchronized void setOnErrorListener(android.drm.DrmManagerClient.OnErrorListener errorListener) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves information about all the DRM plug-ins (agents) that are registered with
 * the DRM framework.
 *
 * @return A <code>String</code> array of DRM plug-in descriptions.
 * @apiSince 11
 */

public java.lang.String[] getAvailableDrmEngines() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves constraint information for rights-protected content.
 *
 * @param path Path to the content from which you are retrieving DRM constraints.
 * @param action Action defined in {@link android.drm.DrmStore.Action DrmStore.Action}.
 *
 * @return A {@link android.content.ContentValues} instance that contains
 * key-value pairs representing the constraints. Null in case of failure.
 * The keys are defined in {@link android.drm.DrmStore.ConstraintsColumns DrmStore.ConstraintsColumns}.
 * @apiSince 11
 */

public android.content.ContentValues getConstraints(java.lang.String path, int action) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves metadata information for rights-protected content.
 *
 * @param path Path to the content from which you are retrieving metadata information.
 *
 * @return A {@link android.content.ContentValues} instance that contains
 * key-value pairs representing the metadata. Null in case of failure.
 * @apiSince 11
 */

public android.content.ContentValues getMetadata(java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves constraint information for rights-protected content.
 *
 * @param uri URI for the content from which you are retrieving DRM constraints.
 * @param action Action defined in {@link android.drm.DrmStore.Action DrmStore.Action}.
 *
 * @return A {@link android.content.ContentValues} instance that contains
 * key-value pairs representing the constraints. Null in case of failure.
 * @apiSince 11
 */

public android.content.ContentValues getConstraints(android.net.Uri uri, int action) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves metadata information for rights-protected content.
 *
 * @param uri URI for the content from which you are retrieving metadata information.
 *
 * @return A {@link android.content.ContentValues} instance that contains
 * key-value pairs representing the constraints. Null in case of failure.
 * @apiSince 11
 */

public android.content.ContentValues getMetadata(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Saves rights to a specified path and associates that path with the content path.
 *
 * <p class="note"><strong>Note:</strong> For OMA or WM-DRM, <code>rightsPath</code> and
 * <code>contentPath</code> can be null.</p>
 *
 * @param drmRights The {@link android.drm.DrmRights DrmRights} to be saved.
 * @param rightsPath File path where rights will be saved.
 * @param contentPath File path where content is saved.
 *
 * @return ERROR_NONE for success; ERROR_UNKNOWN for failure.
 *
 * @throws java.io.IOException If the call failed to save rights information at the given
 * <code>rightsPath</code>.
 * @apiSince 11
 */

public int saveRights(android.drm.DrmRights drmRights, java.lang.String rightsPath, java.lang.String contentPath) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the given MIME type or path can be handled.
 *
 * @param path Path of the content to be handled.
 * @param mimeType MIME type of the object to be handled.
 *
 * @return True if the given MIME type or path can be handled; false if they cannot be handled.
 * @apiSince 11
 */

public boolean canHandle(java.lang.String path, java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the given MIME type or URI can be handled.
 *
 * @param uri URI for the content to be handled.
 * @param mimeType MIME type of the object to be handled
 *
 * @return True if the given MIME type or URI can be handled; false if they cannot be handled.
 * @apiSince 11
 */

public boolean canHandle(android.net.Uri uri, java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Processes the given DRM information based on the information type.
 *
 * @param drmInfo The {@link android.drm.DrmInfo DrmInfo} to be processed.
 * @return ERROR_NONE for success; ERROR_UNKNOWN for failure.
 * @apiSince 11
 */

public int processDrmInfo(android.drm.DrmInfo drmInfo) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves information for registering, unregistering, or acquiring rights.
 *
 * @param drmInfoRequest The {@link android.drm.DrmInfoRequest DrmInfoRequest} that specifies the type of DRM
 * information being retrieved.
 *
 * @return A {@link android.drm.DrmInfo DrmInfo} instance.
 * @apiSince 11
 */

public android.drm.DrmInfo acquireDrmInfo(android.drm.DrmInfoRequest drmInfoRequest) { throw new RuntimeException("Stub!"); }

/**
 * Processes a given {@link android.drm.DrmInfoRequest DrmInfoRequest} and returns the rights information asynchronously.
 *<p>
 * This is a utility method that consists of an
 * {@link #acquireDrmInfo(android.drm.DrmInfoRequest) acquireDrmInfo()} and a
 * {@link #processDrmInfo(android.drm.DrmInfo) processDrmInfo()} method call. This utility method can be
 * used only if the selected DRM plug-in (agent) supports this sequence of calls. Some DRM
 * agents, such as OMA, do not support this utility method, in which case an application must
 * invoke {@link #acquireDrmInfo(android.drm.DrmInfoRequest) acquireDrmInfo()} and
 * {@link #processDrmInfo(android.drm.DrmInfo) processDrmInfo()} separately.
 *
 * @param drmInfoRequest The {@link android.drm.DrmInfoRequest DrmInfoRequest} used to acquire the rights.
 * @return ERROR_NONE for success; ERROR_UNKNOWN for failure.
 * @apiSince 11
 */

public int acquireRights(android.drm.DrmInfoRequest drmInfoRequest) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the type of rights-protected object (for example, content object, rights
 * object, and so on) using the specified path or MIME type. At least one parameter must
 * be specified to retrieve the DRM object type.
 *
 * @param path Path to the content or null.
 * @param mimeType MIME type of the content or null.
 *
 * @return An <code>int</code> that corresponds to a {@link android.drm.DrmStore.DrmObjectType DrmStore.DrmObjectType}.
 * @apiSince 11
 */

public int getDrmObjectType(java.lang.String path, java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the type of rights-protected object (for example, content object, rights
 * object, and so on) using the specified URI or MIME type. At least one parameter must
 * be specified to retrieve the DRM object type.
 *
 * @param uri URI for the content or null.
 * @param mimeType MIME type of the content or null.
 *
 * @return An <code>int</code> that corresponds to a {@link android.drm.DrmStore.DrmObjectType DrmStore.DrmObjectType}.
 * @apiSince 11
 */

public int getDrmObjectType(android.net.Uri uri, java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the MIME type embedded in the original content.
 *
 * @param path Path to the rights-protected content.
 *
 * @return The MIME type of the original content, such as <code>video/mpeg</code>.
 * @apiSince 11
 */

public java.lang.String getOriginalMimeType(java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the MIME type embedded in the original content.
 *
 * @param uri URI of the rights-protected content.
 *
 * @return MIME type of the original content, such as <code>video/mpeg</code>.
 * @apiSince 11
 */

public java.lang.String getOriginalMimeType(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the given content has valid rights.
 *
 * @param path Path to the rights-protected content.
 *
 * @return An <code>int</code> representing the {@link android.drm.DrmStore.RightsStatus DrmStore.RightsStatus} of the content.
 * @apiSince 11
 */

public int checkRightsStatus(java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Check whether the given content has valid rights.
 *
 * @param uri URI of the rights-protected content.
 *
 * @return An <code>int</code> representing the {@link android.drm.DrmStore.RightsStatus DrmStore.RightsStatus} of the content.
 * @apiSince 11
 */

public int checkRightsStatus(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the given rights-protected content has valid rights for the specified
 * {@link android.drm.DrmStore.Action DrmStore.Action}.
 *
 * @param path Path to the rights-protected content.
 * @param action The {@link android.drm.DrmStore.Action DrmStore.Action} to perform.
 *
 * @return An <code>int</code> representing the {@link android.drm.DrmStore.RightsStatus DrmStore.RightsStatus} of the content.
 * @apiSince 11
 */

public int checkRightsStatus(java.lang.String path, int action) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the given rights-protected content has valid rights for the specified
 * {@link android.drm.DrmStore.Action DrmStore.Action}.
 *
 * @param uri URI for the rights-protected content.
 * @param action The {@link android.drm.DrmStore.Action DrmStore.Action} to perform.
 *
 * @return An <code>int</code> representing the {@link android.drm.DrmStore.RightsStatus DrmStore.RightsStatus} of the content.
 * @apiSince 11
 */

public int checkRightsStatus(android.net.Uri uri, int action) { throw new RuntimeException("Stub!"); }

/**
 * Removes the rights associated with the given rights-protected content.
 *
 * @param path Path to the rights-protected content.
 *
 * @return ERROR_NONE for success; ERROR_UNKNOWN for failure.
 * @apiSince 11
 */

public int removeRights(java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Removes the rights associated with the given rights-protected content.
 *
 * @param uri URI for the rights-protected content.
 *
 * @return ERROR_NONE for success; ERROR_UNKNOWN for failure.
 * @apiSince 11
 */

public int removeRights(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Removes all the rights information of every DRM plug-in (agent) associated with
 * the DRM framework. Will be used during a master reset.
 *
 * @return ERROR_NONE for success; ERROR_UNKNOWN for failure.
 * @apiSince 11
 */

public int removeAllRights() { throw new RuntimeException("Stub!"); }

/**
 * Initiates a new conversion session. An application must initiate a conversion session
 * with this method each time it downloads a rights-protected file that needs to be converted.
 *<p>
 * This method applies only to forward-locking (copy protection) DRM schemes.
 *
 * @param mimeType MIME type of the input data packet.
 *
 * @return A convert ID that is used used to maintain the conversion session.
 * @apiSince 11
 */

public int openConvertSession(java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Converts the input data (content) that is part of a rights-protected file. The converted
 * data and status is returned in a {@link android.drm.DrmConvertedStatus DrmConvertedStatus} object. This method should be
 * called each time there is a new block of data received by the application.
 *
 * @param convertId Handle for the conversion session.
 * @param inputData Input data that needs to be converted.
 *
 * @return A {@link android.drm.DrmConvertedStatus DrmConvertedStatus} object that contains the status of the data conversion,
 * the converted data, and offset for the header and body signature. An application can
 * ignore the offset because it is only relevant to the
 * {@link #closeConvertSession closeConvertSession()} method.
 * @apiSince 11
 */

public android.drm.DrmConvertedStatus convertData(int convertId, byte[] inputData) { throw new RuntimeException("Stub!"); }

/**
 * Informs the DRM plug-in (agent) that there is no more data to convert or that an error
 * has occurred. Upon successful conversion of the data, the DRM agent will provide an offset
 * value indicating where the header and body signature should be added. Appending the
 * signature is necessary to protect the integrity of the converted file.
 *
 * @param convertId Handle for the conversion session.
 *
 * @return A {@link android.drm.DrmConvertedStatus DrmConvertedStatus} object that contains the status of the data conversion,
 * the converted data, and the offset for the header and body signature.
 * @apiSince 11
 */

public android.drm.DrmConvertedStatus closeConvertSession(int convertId) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that a request was successful or that no error occurred.
 * @apiSince 11
 */

public static final int ERROR_NONE = 0; // 0x0

/**
 * Indicates that an error occurred and the reason is not known.
 * @apiSince 11
 */

public static final int ERROR_UNKNOWN = -2000; // 0xfffff830
/**
 * Interface definition for a callback that receives information about DRM framework errors.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnErrorListener {

/**
 * Called when the DRM framework sends error information.
 *
 * @param client The <code>DrmManagerClient</code> instance.
 * @param event The {@link android.drm.DrmErrorEvent DrmErrorEvent} instance that wraps the error type and message.
 * @apiSince 11
 */

public void onError(android.drm.DrmManagerClient client, android.drm.DrmErrorEvent event);
}

/**
 * Interface definition for a callback that receives information
 * about DRM processing events.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnEventListener {

/**
 * Called when the DRM framework sends information about a DRM processing request.
 *
 * @param client The <code>DrmManagerClient</code> instance.
 * @param event The {@link android.drm.DrmEvent DrmEvent} instance that wraps the information being
 * conveyed, such as the information type and message.
 * @apiSince 12
 */

public void onEvent(android.drm.DrmManagerClient client, android.drm.DrmEvent event);
}

/**
 * Interface definition for a callback that receives status messages and warnings
 * during registration and rights acquisition.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnInfoListener {

/**
 * Called when the DRM framework sends status or warning information during registration
 * and rights acquisition.
 *
 * @param client The <code>DrmManagerClient</code> instance.
 * @param event The {@link android.drm.DrmInfoEvent DrmInfoEvent} instance that wraps the status information or
 * warnings.
 * @apiSince 11
 */

public void onInfo(android.drm.DrmManagerClient client, android.drm.DrmInfoEvent event);
}

}

