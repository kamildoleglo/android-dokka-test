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


package android.os;


/**
 * A TokenWatcher watches a collection of {@link android.os.IBinder IBinder}s. IBinders are added
 * to the collection by calling {@link #acquire}, and removed by calling {@link
 * #release}. IBinders are also implicitly removed when they become weakly
 * reachable. Each IBinder may be added at most once.
 *
 * The {@link #acquired} method is invoked by posting to the specified handler
 * whenever the size of the watched collection becomes nonzero.  The {@link
 * #released} method is invoked on the specified handler whenever the size of
 * the watched collection becomes zero.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class TokenWatcher {

/**
 * Construct the TokenWatcher
 *
 * @param h A handler to call {@link #acquired} and {@link #released}
 * on.  If you don't care, just call it like this, although your thread
 * will have to be a Looper thread.
 * <code>new TokenWatcher(new Handler())</code>
 * @param tag A debugging tag for this TokenWatcher
 * @apiSince 1
 */

public TokenWatcher(android.os.Handler h, java.lang.String tag) { throw new RuntimeException("Stub!"); }

/**
 * Called when the number of active tokens goes from 0 to 1.
 * @apiSince 1
 */

public abstract void acquired();

/**
 * Called when the number of active tokens goes from 1 to 0.
 * @apiSince 1
 */

public abstract void released();

/**
 * Record that this token has been acquired.  When acquire is called, and
 * the current count is 0, the acquired method is called on the given
 * handler.
 *
 * Note that the same {@code token} can only be acquired once. If this
 * {@code token} has already been acquired, no action is taken. The first
 * subsequent call to {@link #release} will release this {@code token}
 * immediately.
 *
 * @param token An IBinder object.
 * @param tag   A string used by the {@link #dump} method for debugging,
 *              to see who has references.
 * @apiSince 1
 */

public void acquire(android.os.IBinder token, java.lang.String tag) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void cleanup(android.os.IBinder token, boolean unlink) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void release(android.os.IBinder token) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isAcquired() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void dump() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void dump(java.io.PrintWriter pw) { throw new RuntimeException("Stub!"); }
}

