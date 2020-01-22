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


/**
 * A specialization of {@link android.database.Observable Observable} for {@link android.database.DataSetObserver DataSetObserver}
 * that provides methods for sending notifications to a list of
 * {@link android.database.DataSetObserver DataSetObserver} objects.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DataSetObservable extends android.database.Observable<android.database.DataSetObserver> {

public DataSetObservable() { throw new RuntimeException("Stub!"); }

/**
 * Invokes {@link android.database.DataSetObserver#onChanged DataSetObserver#onChanged} on each observer.
 * Called when the contents of the data set have changed.  The recipient
 * will obtain the new contents the next time it queries the data set.
 * @apiSince 1
 */

public void notifyChanged() { throw new RuntimeException("Stub!"); }

/**
 * Invokes {@link android.database.DataSetObserver#onInvalidated DataSetObserver#onInvalidated} on each observer.
 * Called when the data set is no longer valid and cannot be queried again,
 * such as when the data set has been closed.
 * @apiSince 1
 */

public void notifyInvalidated() { throw new RuntimeException("Stub!"); }
}

