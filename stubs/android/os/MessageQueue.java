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
 * Low-level class holding the list of messages to be dispatched by a
 * {@link android.os.Looper Looper}.  Messages are not added directly to a MessageQueue,
 * but rather through {@link android.os.Handler Handler} objects associated with the Looper.
 *
 * <p>You can retrieve the MessageQueue for the current thread with
 * {@link android.os.Looper#myQueue() Looper#myQueue()}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MessageQueue {

MessageQueue() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the looper has no pending messages which are due to be processed.
 *
 * <p>This method is safe to call from any thread.
 *
 * @return True if the looper is idle.
 * @apiSince 23
 */

public boolean isIdle() { throw new RuntimeException("Stub!"); }

/**
 * Add a new {@link android.os.MessageQueue.IdleHandler IdleHandler} to this message queue.  This may be
 * removed automatically for you by returning false from
 * {@link android.os.MessageQueue.IdleHandler#queueIdle IdleHandler#queueIdle} when it is
 * invoked, or explicitly removing it with {@link #removeIdleHandler}.
 *
 * <p>This method is safe to call from any thread.
 *
 * @param handler The IdleHandler to be added.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void addIdleHandler(@androidx.annotation.NonNull android.os.MessageQueue.IdleHandler handler) { throw new RuntimeException("Stub!"); }

/**
 * Remove an {@link android.os.MessageQueue.IdleHandler IdleHandler} from the queue that was previously added
 * with {@link #addIdleHandler}.  If the given object is not currently
 * in the idle list, nothing is done.
 *
 * <p>This method is safe to call from any thread.
 *
 * @param handler The IdleHandler to be removed.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void removeIdleHandler(@androidx.annotation.NonNull android.os.MessageQueue.IdleHandler handler) { throw new RuntimeException("Stub!"); }

/**
 * Adds a file descriptor listener to receive notification when file descriptor
 * related events occur.
 * <p>
 * If the file descriptor has already been registered, the specified events
 * and listener will replace any that were previously associated with it.
 * It is not possible to set more than one listener per file descriptor.
 * </p><p>
 * It is important to always unregister the listener when the file descriptor
 * is no longer of use.
 * </p>
 *
 * @param fd The file descriptor for which a listener will be registered.
 * This value must never be {@code null}.
 * @param events The set of events to receive: a combination of the
 * {@link android.os.MessageQueue.OnFileDescriptorEventListener#EVENT_INPUT OnFileDescriptorEventListener#EVENT_INPUT},
 * {@link android.os.MessageQueue.OnFileDescriptorEventListener#EVENT_OUTPUT OnFileDescriptorEventListener#EVENT_OUTPUT}, and
 * {@link android.os.MessageQueue.OnFileDescriptorEventListener#EVENT_ERROR OnFileDescriptorEventListener#EVENT_ERROR} event masks.  If the requested
 * set of events is zero, then the listener is unregistered.
 * Value is either <code>0</code> or a combination of {@link android.os.MessageQueue.OnFileDescriptorEventListener#EVENT_INPUT}, {@link android.os.MessageQueue.OnFileDescriptorEventListener#EVENT_OUTPUT}, and {@link android.os.MessageQueue.OnFileDescriptorEventListener#EVENT_ERROR}
 * @param listener The listener to invoke when file descriptor events occur.
 *
 * This value must never be {@code null}.
 * @see android.os.MessageQueue.OnFileDescriptorEventListener
 * @see #removeOnFileDescriptorEventListener
 * @apiSince 23
 */

public void addOnFileDescriptorEventListener(@androidx.annotation.NonNull java.io.FileDescriptor fd, int events, @androidx.annotation.NonNull android.os.MessageQueue.OnFileDescriptorEventListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Removes a file descriptor listener.
 * <p>
 * This method does nothing if no listener has been registered for the
 * specified file descriptor.
 * </p>
 *
 * @param fd The file descriptor whose listener will be unregistered.
 *
 * This value must never be {@code null}.
 * @see android.os.MessageQueue.OnFileDescriptorEventListener
 * @see #addOnFileDescriptorEventListener
 * @apiSince 23
 */

public void removeOnFileDescriptorEventListener(@androidx.annotation.NonNull java.io.FileDescriptor fd) { throw new RuntimeException("Stub!"); }
/**
 * Callback interface for discovering when a thread is going to block
 * waiting for more messages.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface IdleHandler {

/**
 * Called when the message queue has run out of messages and will now
 * wait for more.  Return true to keep your idle handler active, false
 * to have it removed.  This may be called if there are still messages
 * pending in the queue, but they are all scheduled to be dispatched
 * after the current time.
 * @apiSince 1
 */

public boolean queueIdle();
}

/**
 * A listener which is invoked when file descriptor related events occur.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnFileDescriptorEventListener {

/**
 * Called when a file descriptor receives events.
 *
 * @param fd The file descriptor.
 * This value must never be {@code null}.
 * @param events The set of events that occurred: a combination of the
 * {@link #EVENT_INPUT}, {@link #EVENT_OUTPUT}, and {@link #EVENT_ERROR} event masks.
 * Value is either <code>0</code> or a combination of {@link android.os.MessageQueue.OnFileDescriptorEventListener#EVENT_INPUT}, {@link android.os.MessageQueue.OnFileDescriptorEventListener#EVENT_OUTPUT}, and {@link android.os.MessageQueue.OnFileDescriptorEventListener#EVENT_ERROR}
 * @return The new set of events to watch, or 0 to unregister the listener.
 *
 * Value is either <code>0</code> or a combination of {@link android.os.MessageQueue.OnFileDescriptorEventListener#EVENT_INPUT}, {@link android.os.MessageQueue.OnFileDescriptorEventListener#EVENT_OUTPUT}, and {@link android.os.MessageQueue.OnFileDescriptorEventListener#EVENT_ERROR}
 * @see #EVENT_INPUT
 * @see #EVENT_OUTPUT
 * @see #EVENT_ERROR
 * @apiSince 23
 */

public int onFileDescriptorEvents(@androidx.annotation.NonNull java.io.FileDescriptor fd, int events);

/**
 * File descriptor event: Indicates that the file descriptor encountered a
 * fatal error.
 * <p>
 * File descriptor errors can occur for various reasons.  One common error
 * is when the remote peer of a socket or pipe closes its end of the connection.
 * </p><p>
 * This event may be generated at any time regardless of whether the
 * {@link #EVENT_ERROR} event mask was specified when the listener was added.
 * </p>
 * @apiSince 23
 */

public static final int EVENT_ERROR = 4; // 0x4

/**
 * File descriptor event: Indicates that the file descriptor is ready for input
 * operations, such as reading.
 * <p>
 * The listener should read all available data from the file descriptor
 * then return <code>true</code> to keep the listener active or <code>false</code>
 * to remove the listener.
 * </p><p>
 * In the case of a socket, this event may be generated to indicate
 * that there is at least one incoming connection that the listener
 * should accept.
 * </p><p>
 * This event will only be generated if the {@link #EVENT_INPUT} event mask was
 * specified when the listener was added.
 * </p>
 * @apiSince 23
 */

public static final int EVENT_INPUT = 1; // 0x1

/**
 * File descriptor event: Indicates that the file descriptor is ready for output
 * operations, such as writing.
 * <p>
 * The listener should write as much data as it needs.  If it could not
 * write everything at once, then it should return <code>true</code> to
 * keep the listener active.  Otherwise, it should return <code>false</code>
 * to remove the listener then re-register it later when it needs to write
 * something else.
 * </p><p>
 * This event will only be generated if the {@link #EVENT_OUTPUT} event mask was
 * specified when the listener was added.
 * </p>
 * @apiSince 23
 */

public static final int EVENT_OUTPUT = 2; // 0x2
}

}

