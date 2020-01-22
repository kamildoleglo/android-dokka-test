/*
 * Copyright (C) 2006 The Android Open Source Project
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
 * Class that implements the condition variable locking paradigm.
 *
 * <p>
 * This differs from the built-in java.lang.Object wait() and notify()
 * in that this class contains the condition to wait on itself.  That means
 * open(), close() and block() are sticky.  If open() is called before block(),
 * block() will not block, and instead return immediately.
 *
 * <p>
 * This class uses itself as the object to wait on, so if you wait()
 * or notify() on a ConditionVariable, the results are undefined.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ConditionVariable {

/**
 * Create the ConditionVariable in the default closed state.
 * @apiSince 1
 */

public ConditionVariable() { throw new RuntimeException("Stub!"); }

/**
 * Create the ConditionVariable with the given state.
 *
 * <p>
 * Pass true for opened and false for closed.
 * @apiSince 1
 */

public ConditionVariable(boolean state) { throw new RuntimeException("Stub!"); }

/**
 * Open the condition, and release all threads that are blocked.
 *
 * <p>
 * Any threads that later approach block() will not block unless close()
 * is called.
 * @apiSince 1
 */

public void open() { throw new RuntimeException("Stub!"); }

/**
 * Reset the condition to the closed state.
 *
 * <p>
 * Any threads that call block() will block until someone calls open.
 * @apiSince 1
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Block the current thread until the condition is opened.
 *
 * <p>
 * If the condition is already opened, return immediately.
 * @apiSince 1
 */

public void block() { throw new RuntimeException("Stub!"); }

/**
 * Block the current thread until the condition is opened or until
 * timeoutMs milliseconds have passed.
 *
 * <p>
 * If the condition is already opened, return immediately.
 *
 * @param timeoutMs the maximum time to wait in milliseconds.
 *
 * @return true if the condition was opened, false if the call returns
 * because of the timeout.
 * @apiSince 1
 */

public boolean block(long timeoutMs) { throw new RuntimeException("Stub!"); }
}

