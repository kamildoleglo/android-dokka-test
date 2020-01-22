/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.view.accessibility;

import android.view.View;
import android.os.Bundle;

/**
 * Object responsible to ensuring that a {@link android.view.View View} is prepared to meet a synchronous request for
 * accessibility data.
 * <p>
 * Because accessibility requests arrive to {@link android.view.View View}s synchronously on the UI thread, a View
 * that requires information from other processes can struggle to meet those requests. Registering
 * an instance of this class with {@link android.view.accessibility.AccessibilityManager AccessibilityManager} allows a View to be notified when
 * a request is about to be made, and to asynchronously inform the accessibility system when it is
 * ready to meet the request.
 * <p>
 * <strong>Note:</strong> This class should only be needed in exceptional situations where a
 * {@link android.view.View View} cannot otherwise synchronously meet the request for accessibility data.
 * @apiSince 27
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AccessibilityRequestPreparer {

/**
 * @param view The view whose requests need preparation. It must be attached to a
 * window. This object will retain a weak reference to this view, and will unregister itself
 * from AccessibilityManager if the view is detached from a window. It will not re-register
 * itself.
 * @param requestTypes The types of requests that require preparation. Different types may
 * be ORed together.
 *
 * Value is either <code>0</code> or {@link android.view.accessibility.AccessibilityRequestPreparer#REQUEST_TYPE_EXTRA_DATA}
 * @throws java.lang.IllegalStateException if the view is not attached to a window.
 * @apiSince 27
 */

public AccessibilityRequestPreparer(android.view.View view, int requestTypes) { throw new RuntimeException("Stub!"); }

/**
 * Callback to allow preparation for filling extra data. Only called back if
 * REQUEST_TYPE_EXTRA_DATA is requested.
 *
 * @param virtualViewId The ID of a virtual child node, if the {@link android.view.View View} for this preparer
 * supports virtual descendents, or {@link android.view.accessibility.AccessibilityNodeProvider#HOST_VIEW_ID AccessibilityNodeProvider#HOST_VIEW_ID}
 * if the request is for the view itself.
 * @param extraDataKey The extra data key for the request
 * @param args The arguments for the request
 * @param preparationFinishedMessage A message that must be sent to its target when preparations
 * are complete.
 *
 * @see android.view.View#addExtraDataToAccessibilityNodeInfo(AccessibilityNodeInfo, String, Bundle)
 * @see android.view.View.AccessibilityDelegate#addExtraDataToAccessibilityNodeInfo(
 * View, AccessibilityNodeInfo, String, Bundle)
 * @see android.view.accessibility.AccessibilityNodeProvider#addExtraDataToAccessibilityNodeInfo(
 * int, AccessibilityNodeInfo, String, Bundle)
 * @apiSince 27
 */

public abstract void onPrepareExtraData(int virtualViewId, java.lang.String extraDataKey, android.os.Bundle args, android.os.Message preparationFinishedMessage);

/**
 * Get the view this object was created with.
 *
 * @return The view this object was created with, or {@code null} if the weak reference held
 * to the view is no longer valid.
 * @apiSince 27
 */

@androidx.annotation.Nullable
public android.view.View getView() { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

public static final int REQUEST_TYPE_EXTRA_DATA = 1; // 0x1
}

