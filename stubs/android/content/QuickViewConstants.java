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


package android.content;


/**
 * Constants for {@link android.content.Intent#ACTION_QUICK_VIEW Intent#ACTION_QUICK_VIEW}.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class QuickViewConstants {

private QuickViewConstants() { throw new RuntimeException("Stub!"); }

/**
 * Feature to delete an individual document. Quick viewer implementations must use
 * Storage Access Framework to both verify delete permission and to delete content.
 *
 * @see android.provider.DocumentsContract.Document#FLAG_SUPPORTS_DELETE
 * @see android.provider.DocumentsContract#deleteDocument(ContentResolver, android.net.Uri)
 * @apiSince 28
 */

public static final java.lang.String FEATURE_DELETE = "android:delete";

/**
 * Feature to download a document to the local file system.
 *
 * @see android.content.Intent#EXTRA_QUICK_VIEW_FEATURES
 * @see android.content.Intent#ACTION_QUICK_VIEW
 * @apiSince 26
 */

public static final java.lang.String FEATURE_DOWNLOAD = "android:download";

/**
 * Feature to edit a document using system standard editing mechanism, like
 * {@link android.content.Intent#ACTION_EDIT Intent#ACTION_EDIT}.
 *
 * @see android.content.Intent#EXTRA_QUICK_VIEW_FEATURES
 * @see android.content.Intent#ACTION_QUICK_VIEW
 * @apiSince 26
 */

public static final java.lang.String FEATURE_EDIT = "android:edit";

/**
 * Feature to print a document.
 *
 * @see android.content.Intent#EXTRA_QUICK_VIEW_FEATURES
 * @see android.content.Intent#ACTION_QUICK_VIEW
 * @apiSince 26
 */

public static final java.lang.String FEATURE_PRINT = "android:print";

/**
 * Feature to view a document using system standard sending mechanism, like
 * {@link android.content.Intent#ACTION_SEND Intent#ACTION_SEND}.
 *
 * @see android.content.Intent#EXTRA_QUICK_VIEW_FEATURES
 * @see android.content.Intent#ACTION_QUICK_VIEW
 * @apiSince 26
 */

public static final java.lang.String FEATURE_SEND = "android:send";

/**
 * Feature to view a document using system standard viewing mechanism, like
 * {@link android.content.Intent#ACTION_VIEW Intent#ACTION_VIEW}.
 *
 * @see android.content.Intent#EXTRA_QUICK_VIEW_FEATURES
 * @see android.content.Intent#ACTION_QUICK_VIEW
 * @apiSince 26
 */

public static final java.lang.String FEATURE_VIEW = "android:view";
}

