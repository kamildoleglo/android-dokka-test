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

package android.app.slice;

import android.net.Uri;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.content.IntentFilter;
import android.content.Intent;
import java.util.List;

/**
 * A SliceProvider allows an app to provide content to be displayed in system spaces. This content
 * is templated and can contain actions, and the behavior of how it is surfaced is specific to the
 * system surface.
 * <p>
 * Slices are not currently live content. They are bound once and shown to the user. If the content
 * changes due to a callback from user interaction, then
 * {@link android.content.ContentResolver#notifyChange(android.net.Uri,android.database.ContentObserver) ContentResolver#notifyChange(Uri, ContentObserver)} should be used to notify the system.
 * </p>
 * <p>
 * The provider needs to be declared in the manifest to provide the authority for the app. The
 * authority for most slices is expected to match the package of the application.
 * </p>
 *
 * <pre class="prettyprint">
 * {@literal
 * <provider
 *     android:name="com.example.mypkg.MySliceProvider"
 *     android:authorities="com.example.mypkg" />}
 * </pre>
 * <p>
 * Slices can be identified by a Uri or by an Intent. To link an Intent with a slice, the provider
 * must have an {@link android.content.IntentFilter IntentFilter} matching the slice intent. When a slice is being requested via
 * an intent, {@link #onMapIntentToUri(android.content.Intent)} can be called and is expected to return an
 * appropriate Uri representing the slice.
 *
 * <pre class="prettyprint">
 * {@literal
 * <provider
 *     android:name="com.example.mypkg.MySliceProvider"
 *     android:authorities="com.example.mypkg">
 *     <intent-filter>
 *         <action android:name="com.example.mypkg.intent.action.MY_SLICE_INTENT" />
 *         <category android:name="android.app.slice.category.SLICE" />
 *     </intent-filter>
 * </provider>}
 * </pre>
 *
 * @see android.app.slice.Slice
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SliceProvider extends android.content.ContentProvider {

/**
 * A version of constructing a SliceProvider that allows autogranting slice permissions
 * to apps that hold specific platform permissions.
 * <p>
 * When an app tries to bind a slice from this provider that it does not have access to,
 * This provider will check if the caller holds permissions to any of the autoGrantPermissions
 * specified, if they do they will be granted persisted uri access to all slices of this
 * provider.
 *
 * @param autoGrantPermissions List of permissions that holders are auto-granted access
 *                             to slices.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public SliceProvider(@androidx.annotation.NonNull java.lang.String... autoGrantPermissions) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public SliceProvider() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void attachInfo(android.content.Context context, android.content.pm.ProviderInfo info) { throw new RuntimeException("Stub!"); }

/**
 * Implemented to create a slice.
 * <p>
 * onBindSlice should return as quickly as possible so that the UI tied
 * to this slice can be responsive. No network or other IO will be allowed
 * during onBindSlice. Any loading that needs to be done should happen
 * in the background with a call to {@link android.content.ContentResolver#notifyChange(android.net.Uri,android.database.ContentObserver) ContentResolver#notifyChange(Uri, ContentObserver)}
 * when the app is ready to provide the complete data in onBindSlice.
 * <p>
 * The slice returned should have a spec that is compatible with one of
 * the supported specs.
 *
 * @param sliceUri Uri to bind.
 * @param supportedSpecs List of supported specs.
 * @see android.app.slice.Slice
 * @see android.app.slice.Slice#HINT_PARTIAL
 * @apiSince 28
 */

public android.app.slice.Slice onBindSlice(android.net.Uri sliceUri, java.util.Set<android.app.slice.SliceSpec> supportedSpecs) { throw new RuntimeException("Stub!"); }

/**
 * Called to inform an app that a slice has been pinned.
 * <p>
 * Pinning is a way that slice hosts use to notify apps of which slices
 * they care about updates for. When a slice is pinned the content is
 * expected to be relatively fresh and kept up to date.
 * <p>
 * Being pinned does not provide any escalated privileges for the slice
 * provider. So apps should do things such as turn on syncing or schedule
 * a job in response to a onSlicePinned.
 * <p>
 * Pinned state is not persisted through a reboot, and apps can expect a
 * new call to onSlicePinned for any slices that should remain pinned
 * after a reboot occurs.
 *
 * @param sliceUri The uri of the slice being unpinned.
 * @see #onSliceUnpinned(Uri)
 * @apiSince 28
 */

public void onSlicePinned(android.net.Uri sliceUri) { throw new RuntimeException("Stub!"); }

/**
 * Called to inform an app that a slices is no longer pinned.
 * <p>
 * This means that no other apps on the device care about updates to this
 * slice anymore and therefore it is not important to be updated. Any syncs
 * or jobs related to this slice should be cancelled.
 * @see #onSlicePinned(Uri)
 * @apiSince 28
 */

public void onSliceUnpinned(android.net.Uri sliceUri) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a list of slices that are descendants of the specified Uri.
 * <p>
 * Implementing this is optional for a SliceProvider, but does provide a good
 * discovery mechanism for finding slice Uris.
 *
 * @param uri The uri to look for descendants under.
 * This value must never be {@code null}.
 * @return All slices within the space.
 * This value will never be {@code null}.
 * @see android.app.slice.SliceManager#getSliceDescendants(Uri)
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.Collection<android.net.Uri> onGetSliceDescendants(@androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * This method must be overridden if an {@link android.content.IntentFilter IntentFilter} is specified on the SliceProvider.
 * In that case, this method can be called and is expected to return a non-null Uri representing
 * a slice. Otherwise this will throw {@link java.lang.UnsupportedOperationException UnsupportedOperationException}.
 *
 * Any intent filter added to a slice provider should also contain
 * {@link android.app.slice.SliceManager#CATEGORY_SLICE SliceManager#CATEGORY_SLICE}, because otherwise it will not be detected by
 * {@link android.app.slice.SliceManager#mapIntentToUri(android.content.Intent) SliceManager#mapIntentToUri(Intent)}.
 *
 * @return Uri representing the slice associated with the provided intent.
 * @see android.app.slice.Slice
 * @see android.app.slice.SliceManager#mapIntentToUri(Intent)
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.net.Uri onMapIntentToUri(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called when an app requests a slice it does not have write permission
 * to the uri for.
 * <p>
 * The return value will be the action on a slice that prompts the user that
 * the calling app wants to show slices from this app. The default implementation
 * launches a dialog that allows the user to grant access to this slice. Apps
 * that do not want to allow this user grant, can override this and instead
 * launch their own dialog with different behavior.
 *
 * @param sliceUri the Uri of the slice attempting to be bound.
 * @see #getCallingPackage()
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.app.PendingIntent onCreatePermissionRequest(android.net.Uri sliceUri) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public final int update(android.net.Uri uri, android.content.ContentValues values, java.lang.String selection, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public final int delete(android.net.Uri uri, java.lang.String selection, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public final android.database.Cursor query(android.net.Uri uri, java.lang.String[] projection, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String sortOrder) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public final android.database.Cursor query(android.net.Uri uri, java.lang.String[] projection, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String sortOrder, android.os.CancellationSignal cancellationSignal) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public final android.database.Cursor query(android.net.Uri uri, java.lang.String[] projection, android.os.Bundle queryArgs, android.os.CancellationSignal cancellationSignal) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public final android.net.Uri insert(android.net.Uri uri, android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public final java.lang.String getType(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.os.Bundle call(java.lang.String method, java.lang.String arg, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * This is the Android platform's MIME type for a URI
 * containing a slice implemented through {@link android.app.slice.SliceProvider SliceProvider}.
 * @apiSince 28
 */

public static final java.lang.String SLICE_TYPE = "vnd.android.slice";
}

