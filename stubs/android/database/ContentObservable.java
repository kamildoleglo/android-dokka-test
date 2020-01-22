/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.database;

import android.net.Uri;

/**
 * A specialization of {@link android.database.Observable Observable} for {@link android.database.ContentObserver ContentObserver}
 * that provides methods for sending notifications to a list of
 * {@link android.database.ContentObserver ContentObserver} objects.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ContentObservable extends android.database.Observable<android.database.ContentObserver> {

public ContentObservable() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void registerObserver(android.database.ContentObserver observer) { throw new RuntimeException("Stub!"); }

/**
 * Invokes {@link android.database.ContentObserver#dispatchChange(boolean) ContentObserver#dispatchChange(boolean)} on each observer.
 * <p>
 * If <code>selfChange</code> is true, only delivers the notification
 * to the observer if it has indicated that it wants to receive self-change
 * notifications by implementing {@link android.database.ContentObserver#deliverSelfNotifications ContentObserver#deliverSelfNotifications}
 * to return true.
 * </p>
 *
 * @param selfChange True if this is a self-change notification.
 *
 * @deprecated Use {@link #dispatchChange(boolean,android.net.Uri)} instead.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
public void dispatchChange(boolean selfChange) { throw new RuntimeException("Stub!"); }

/**
 * Invokes {@link android.database.ContentObserver#dispatchChange(boolean,android.net.Uri) ContentObserver#dispatchChange(boolean, Uri)} on each observer.
 * Includes the changed content Uri when available.
 * <p>
 * If <code>selfChange</code> is true, only delivers the notification
 * to the observer if it has indicated that it wants to receive self-change
 * notifications by implementing {@link android.database.ContentObserver#deliverSelfNotifications ContentObserver#deliverSelfNotifications}
 * to return true.
 * </p>
 *
 * @param selfChange True if this is a self-change notification.
 * @param uri The Uri of the changed content, or null if unknown.
 * @apiSince 16
 */

public void dispatchChange(boolean selfChange, android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Invokes {@link android.database.ContentObserver#onChange ContentObserver#onChange} on each observer.
 *
 * @param selfChange True if this is a self-change notification.
 *
 * @deprecated Use {@link #dispatchChange} instead.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
public void notifyChange(boolean selfChange) { throw new RuntimeException("Stub!"); }
}

