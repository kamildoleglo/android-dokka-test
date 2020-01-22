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

import java.util.ArrayList;

/**
 * Provides methods for registering or unregistering arbitrary observers in an {@link java.util.ArrayList ArrayList}.
 *
 * This abstract class is intended to be subclassed and specialized to maintain
 * a registry of observers of specific types and dispatch notifications to them.
 *
 * @param T The observer type.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Observable<T> {

public Observable() { throw new RuntimeException("Stub!"); }

/**
 * Adds an observer to the list. The observer cannot be null and it must not already
 * be registered.
 * @param observer the observer to register
 * @throws java.lang.IllegalArgumentException the observer is null
 * @throws java.lang.IllegalStateException the observer is already registered
 * @apiSince 1
 */

public void registerObserver(T observer) { throw new RuntimeException("Stub!"); }

/**
 * Removes a previously registered observer. The observer must not be null and it
 * must already have been registered.
 * @param observer the observer to unregister
 * @throws java.lang.IllegalArgumentException the observer is null
 * @throws java.lang.IllegalStateException the observer is not yet registered
 * @apiSince 1
 */

public void unregisterObserver(T observer) { throw new RuntimeException("Stub!"); }

/**
 * Remove all registered observers.
 * @apiSince 1
 */

public void unregisterAll() { throw new RuntimeException("Stub!"); }

/**
 * The list of observers.  An observer can be in the list at most
 * once and will never be null.
 * @apiSince 1
 */

protected final java.util.ArrayList<T> mObservers;
{ mObservers = null; }
}

