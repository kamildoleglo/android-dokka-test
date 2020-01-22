/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.test.mock;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.net.Uri;
import android.database.ContentObserver;

/**
 * <p>
 *      An extension of {@link android.content.ContentResolver} that is designed for
 *      testing.
 * </p>
 * <p>
 *      MockContentResolver overrides Android's normal way of resolving providers by
 *      authority. To have access to a provider based on its authority, users of
 *      MockContentResolver first instantiate the provider and
 *      use {@link android.test.mock.MockContentResolver#addProvider(java.lang.String,android.content.ContentProvider) MockContentResolver#addProvider(String, ContentProvider)}. Resolution of an
 *      authority occurs entirely within MockContentResolver.
 * </p>
 * <p>
 *      Users can also set an authority's entry in the map to null, so that a provider is completely
 *      mocked out.
 * </p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about application testing, read the
 * <a href="{@docRoot}guide/topics/testing/index.html">Testing</a> developer guide.</p>
 * </div>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MockContentResolver extends android.content.ContentResolver {

/**
 * Creates a local map of providers. This map is used instead of the global
 * map when an API call tries to acquire a provider.
 * @apiSince 1
 */

public MockContentResolver() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a local map of providers. This map is used instead of the global
 * map when an API call tries to acquire a provider.
 * @apiSince 18
 */

public MockContentResolver(android.content.Context context) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Adds access to a provider based on its authority
 *
 * @param name The authority name associated with the provider.
 * @param provider An instance of {@link android.content.ContentProvider} or one of its
 * subclasses, or null.
 * @apiSince 1
 */

public void addProvider(java.lang.String name, android.content.ContentProvider provider) { throw new RuntimeException("Stub!"); }

/**
 * Overrides {@link android.content.ContentResolver#notifyChange(Uri, ContentObserver, boolean)
 * ContentResolver.notifChange(Uri, ContentObserver, boolean)}. All parameters are ignored.
 * The method hides providers linked to MockContentResolver from other observers in the system.
 *
 * @param uri (Ignored) The uri of the content provider.
 * @param observer (Ignored) The observer that originated the change.
 * @param syncToNetwork (Ignored) If true, attempt to sync the change to the network.
 * @apiSince 1
 */

public void notifyChange(android.net.Uri uri, android.database.ContentObserver observer, boolean syncToNetwork) { throw new RuntimeException("Stub!"); }
}

