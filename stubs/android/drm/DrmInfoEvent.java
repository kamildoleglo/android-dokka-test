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
 * An entity class that is passed to the
 * {@link android.drm.DrmManagerClient.OnInfoListener#onInfo DrmManagerClient.OnInfoListener#onInfo} callback.
 *
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DrmInfoEvent extends android.drm.DrmEvent {

/**
 * Creates a <code>DrmInfoEvent</code> object with the specified parameters.
 *
 * @param uniqueId Unique session identifier.
 * @param type Type of the event. Must be any of the event types defined above,
 * or the constants defined in {@link android.drm.DrmEvent DrmEvent}.
 * @param message Message description. It can be null.
 * @apiSince 11
 */

public DrmInfoEvent(int uniqueId, int type, java.lang.String message) { super(0, 0, (java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a <code>DrmInfoEvent</code> object with the specified parameters.
 *
 * @param uniqueId Unique session identifier.
 * @param type Type of the event. Must be any of the event types defined above,
 * or the constants defined in {@link android.drm.DrmEvent DrmEvent}
 * @param message Message description. It can be null.
 * @param attributes Attributes for extensible information. Could be any
 * information provided by the plug-in.
 * @apiSince 12
 */

public DrmInfoEvent(int uniqueId, int type, java.lang.String message, java.util.HashMap<java.lang.String,java.lang.Object> attributes) { super(0, 0, (java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * The registration has already been done for the given account.
 * @apiSince 11
 */

public static final int TYPE_ACCOUNT_ALREADY_REGISTERED = 5; // 0x5

/**
 * The registration has already been done by another account ID.
 * @apiSince 11
 */

public static final int TYPE_ALREADY_REGISTERED_BY_ANOTHER_ACCOUNT = 1; // 0x1

/**
 * The rights need to be removed completely.
 * @apiSince 11
 */

public static final int TYPE_REMOVE_RIGHTS = 2; // 0x2

/**
 * The rights have been successfully downloaded and installed.
 * @apiSince 11
 */

public static final int TYPE_RIGHTS_INSTALLED = 3; // 0x3

/**
 * The rights have been removed.
 * @apiSince 12
 */

public static final int TYPE_RIGHTS_REMOVED = 6; // 0x6

/**
 * The rights object is being delivered to the device. You must wait before
 * calling {@link android.drm.DrmManagerClient#acquireRights DrmManagerClient#acquireRights} again.
 * @apiSince 11
 */

public static final int TYPE_WAIT_FOR_RIGHTS = 4; // 0x4
}

