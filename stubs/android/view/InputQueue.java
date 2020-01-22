/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.view;


/**
 * An input queue provides a mechanism for an application to receive incoming
 * input events.  Currently only usable from native code.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class InputQueue {

InputQueue() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
/**
 * Interface to receive notification of when an InputQueue is associated
 * and dissociated with a thread.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Callback {

/**
 * Called when the given InputQueue is now associated with the
 * thread making this call, so it can start receiving events from it.
 * @apiSince 9
 */

public void onInputQueueCreated(android.view.InputQueue queue);

/**
 * Called when the given InputQueue is no longer associated with
 * the thread and thus not dispatching events.
 * @apiSince 9
 */

public void onInputQueueDestroyed(android.view.InputQueue queue);
}

}

