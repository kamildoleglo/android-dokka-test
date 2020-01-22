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

import android.content.Intent;
import android.net.Uri;
import java.util.List;
import android.content.ContentResolver;
import java.util.Set;
import android.content.pm.PackageManager;

/**
 * Class to handle interactions with {@link android.app.slice.Slice Slice}s.
 * <p>
 * The SliceManager manages permissions and pinned state for slices.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SliceManager {

SliceManager() { throw new RuntimeException("Stub!"); }

/**
 * Ensures that a slice is in a pinned state.
 * <p>
 * Pinned state is not persisted across reboots, so apps are expected to re-pin any slices
 * they still care about after a reboot.
 * <p>
 * This may only be called by apps that are the default launcher for the device
 * or the default voice interaction service. Otherwise will throw {@link java.lang.SecurityException SecurityException}.
 *
 * @param uri The uri of the slice being pinned.
 * This value must never be {@code null}.
 * @param specs The list of supported {@link android.app.slice.SliceSpec SliceSpec}s of the callback.
 * This value must never be {@code null}.
 * @see android.app.slice.SliceProvider#onSlicePinned(Uri)
 * @see android.content.Intent#ACTION_ASSIST
 * @see android.content.Intent#CATEGORY_HOME
 * @apiSince 28
 */

public void pinSlice(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.util.Set<android.app.slice.SliceSpec> specs) { throw new RuntimeException("Stub!"); }

/**
 * Remove a pin for a slice.
 * <p>
 * If the slice has no other pins/callbacks then the slice will be unpinned.
 * <p>
 * This may only be called by apps that are the default launcher for the device
 * or the default voice interaction service. Otherwise will throw {@link java.lang.SecurityException SecurityException}.
 *
 * @param uri The uri of the slice being unpinned.
 * This value must never be {@code null}.
 * @see #pinSlice
 * @see android.app.slice.SliceProvider#onSliceUnpinned(Uri)
 * @see android.content.Intent#ACTION_ASSIST
 * @see android.content.Intent#CATEGORY_HOME
 * @apiSince 28
 */

public void unpinSlice(@androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Get the current set of specs for a pinned slice.
 * <p>
 * This is the set of specs supported for a specific pinned slice. It will take
 * into account all clients and returns only specs supported by all.
 * @see android.app.slice.SliceSpec
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.Set<android.app.slice.SliceSpec> getPinnedSpecs(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Get the list of currently pinned slices for this app.
 * @see android.app.slice.SliceProvider#onSlicePinned
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.List<android.net.Uri> getPinnedSlices() { throw new RuntimeException("Stub!"); }

/**
 * Obtains a list of slices that are descendants of the specified Uri.
 * <p>
 * Not all slice providers will implement this functionality, in which case,
 * an empty collection will be returned.
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param uri The uri to look for descendants under.
 * This value must never be {@code null}.
 * @return All slices within the space.
 * This value will never be {@code null}.
 * @see android.app.slice.SliceProvider#onGetSliceDescendants(Uri)
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.Collection<android.net.Uri> getSliceDescendants(@androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Turns a slice Uri into slice content.
 *
 * @param uri The URI to a slice provider
 * This value must never be {@code null}.
 * @param supportedSpecs List of supported specs.
 * This value must never be {@code null}.
 * @return The Slice provided by the app or null if none is given.
 * @see android.app.slice.Slice
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.app.slice.Slice bindSlice(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.util.Set<android.app.slice.SliceSpec> supportedSpecs) { throw new RuntimeException("Stub!"); }

/**
 * Turns a slice intent into a slice uri. Expects an explicit intent.
 * <p>
 * This goes through a several stage resolution process to determine if any slice
 * can represent this intent.
 * <ol>
 *  <li> If the intent contains data that {@link android.content.ContentResolver#getType ContentResolver#getType} is
 *  {@link android.app.slice.SliceProvider#SLICE_TYPE SliceProvider#SLICE_TYPE} then the data will be returned.</li>
 *  <li>If the intent explicitly points at an activity, and that activity has
 *  meta-data for key {@link #SLICE_METADATA_KEY}, then the Uri specified there will be
 *  returned.</li>
 *  <li>Lastly, if the intent with {@link #CATEGORY_SLICE} added resolves to a provider, then
 *  the provider will be asked to {@link android.app.slice.SliceProvider#onMapIntentToUri SliceProvider#onMapIntentToUri} and that result
 *  will be returned.</li>
 *  <li>If no slice is found, then {@code null} is returned.</li>
 * </ol>
 * @param intent The intent associated with a slice.
 * This value must never be {@code null}.
 * @return The Slice Uri provided by the app or null if none exists.
 * @see android.app.slice.Slice
 * @see android.app.slice.SliceProvider#onMapIntentToUri(Intent)
 * @see android.content.Intent
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.net.Uri mapIntentToUri(@androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Turns a slice intent into slice content. Is a shortcut to perform the action
 * of both {@link #mapIntentToUri(android.content.Intent)} and {@link #bindSlice(android.net.Uri,java.util.Set)} at once.
 *
 * @param intent The intent associated with a slice.
 * This value must never be {@code null}.
 * @param supportedSpecs List of supported specs.
 * This value must never be {@code null}.
 * @return The Slice provided by the app or null if none is given.
 * @see android.app.slice.Slice
 * @see android.app.slice.SliceProvider#onMapIntentToUri(Intent)
 * @see android.content.Intent
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.app.slice.Slice bindSlice(@androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.NonNull java.util.Set<android.app.slice.SliceSpec> supportedSpecs) { throw new RuntimeException("Stub!"); }

/**
 * Determine whether a particular process and user ID has been granted
 * permission to access a specific slice URI.
 *
 * @param uri The uri that is being checked.
 * This value must never be {@code null}.
 * @param pid The process ID being checked against.  Must be &gt; 0.
 * @param uid The user ID being checked against.  A uid of 0 is the root
 * user, which will pass every permission check.
 *
 * @return {@link android.content.pm.PackageManager#PERMISSION_GRANTED PackageManager#PERMISSION_GRANTED} if the given
 * pid/uid is allowed to access that uri, or
 * {@link android.content.pm.PackageManager#PERMISSION_DENIED PackageManager#PERMISSION_DENIED} if it is not.
 *
 * Value is {@link android.content.pm.PackageManager#PERMISSION_GRANTED}, or {@link android.content.pm.PackageManager#PERMISSION_DENIED}
 * @see #grantSlicePermission(String, Uri)
 * @apiSince 28
 */

public int checkSlicePermission(@androidx.annotation.NonNull android.net.Uri uri, int pid, int uid) { throw new RuntimeException("Stub!"); }

/**
 * Grant permission to access a specific slice Uri to another package.
 *
 * @param toPackage The package you would like to allow to access the Uri.
 * This value must never be {@code null}.
 * @param uri The Uri you would like to grant access to.
 *
 * This value must never be {@code null}.
 * @see #revokeSlicePermission
 * @apiSince 28
 */

public void grantSlicePermission(@androidx.annotation.NonNull java.lang.String toPackage, @androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Remove permissions to access a particular content provider Uri
 * that were previously added with {@link #grantSlicePermission} for a specific target
 * package.  The given Uri will match all previously granted Uris that are the same or a
 * sub-path of the given Uri.  That is, revoking "content://foo/target" will
 * revoke both "content://foo/target" and "content://foo/target/sub", but not
 * "content://foo".  It will not remove any prefix grants that exist at a
 * higher level.
 *
 * @param toPackage The package you would like to allow to access the Uri.
 * This value must never be {@code null}.
 * @param uri The Uri you would like to revoke access to.
 *
 * This value must never be {@code null}.
 * @see #grantSlicePermission
 * @apiSince 28
 */

public void revokeSlicePermission(@androidx.annotation.NonNull java.lang.String toPackage, @androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Category used to resolve intents that can be rendered as slices.
 * <p>
 * This category should be included on intent filters on providers that extend
 * {@link android.app.slice.SliceProvider SliceProvider}.
 * @see android.app.slice.SliceProvider
 * @see android.app.slice.SliceProvider#onMapIntentToUri(Intent)
 * @see #mapIntentToUri(Intent)
 * @apiSince 28
 */

public static final java.lang.String CATEGORY_SLICE = "android.app.slice.category.SLICE";

/**
 * The meta-data key that allows an activity to easily be linked directly to a slice.
 * <p>
 * An activity can be statically linked to a slice uri by including a meta-data item
 * for this key that contains a valid slice uri for the same application declaring
 * the activity.
 *
 * <pre class="prettyprint">
 * {@literal
 * <activity android:name="com.example.mypkg.MyActivity">
 *     <meta-data android:name="android.metadata.SLICE_URI"
 *                android:value="content://com.example.mypkg/main_slice" />
 *  </activity>}
 * </pre>
 *
 * @see #mapIntentToUri(Intent)
 * @see android.app.slice.SliceProvider#onMapIntentToUri(Intent)
 * @apiSince 28
 */

public static final java.lang.String SLICE_METADATA_KEY = "android.metadata.SLICE_URI";
}

