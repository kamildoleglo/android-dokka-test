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
 *
 * Defines a message containing a description and arbitrary data object that can be
 * sent to a {@link android.os.Handler Handler}.  This object contains two extra int fields and an
 * extra object field that allow you to not do allocations in many cases.
 *
 * <p class="note">While the constructor of Message is public, the best way to get
 * one of these is to call {@link #obtain Message.obtain()} or one of the
 * {@link android.os.Handler#obtainMessage Handler#obtainMessage} methods, which will pull
 * them from a pool of recycled objects.</p>
 @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Message implements android.os.Parcelable {

/** Constructor (but the preferred way to get a Message is to call {@link #obtain() Message.obtain()}).
 @apiSince 1
 */

public Message() { throw new RuntimeException("Stub!"); }

/**
 * Return a new Message instance from the global pool. Allows us to
 * avoid allocating new objects in many cases.
 * @apiSince 1
 */

public static android.os.Message obtain() { throw new RuntimeException("Stub!"); }

/**
 * Same as {@link #obtain()}, but copies the values of an existing
 * message (including its target) into the new one.
 * @param orig Original message to copy.
 * @return A Message object from the global pool.
 * @apiSince 1
 */

public static android.os.Message obtain(android.os.Message orig) { throw new RuntimeException("Stub!"); }

/**
 * Same as {@link #obtain()}, but sets the value for the <em>target</em> member on the Message returned.
 * @param h  Handler to assign to the returned Message object's <em>target</em> member.
 * @return A Message object from the global pool.
 * @apiSince 1
 */

public static android.os.Message obtain(android.os.Handler h) { throw new RuntimeException("Stub!"); }

/**
 * Same as {@link #obtain(android.os.Handler)}, but assigns a callback Runnable on
 * the Message that is returned.
 * @param h  Handler to assign to the returned Message object's <em>target</em> member.
 * @param callback Runnable that will execute when the message is handled.
 * @return A Message object from the global pool.
 * @apiSince 1
 */

public static android.os.Message obtain(android.os.Handler h, java.lang.Runnable callback) { throw new RuntimeException("Stub!"); }

/**
 * Same as {@link #obtain()}, but sets the values for both <em>target</em> and
 * <em>what</em> members on the Message.
 * @param h  Value to assign to the <em>target</em> member.
 * @param what  Value to assign to the <em>what</em> member.
 * @return A Message object from the global pool.
 * @apiSince 1
 */

public static android.os.Message obtain(android.os.Handler h, int what) { throw new RuntimeException("Stub!"); }

/**
 * Same as {@link #obtain()}, but sets the values of the <em>target</em>, <em>what</em>, and <em>obj</em>
 * members.
 * @param h  The <em>target</em> value to set.
 * @param what  The <em>what</em> value to set.
 * @param obj  The <em>object</em> method to set.
 * @return  A Message object from the global pool.
 * @apiSince 1
 */

public static android.os.Message obtain(android.os.Handler h, int what, java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Same as {@link #obtain()}, but sets the values of the <em>target</em>, <em>what</em>,
 * <em>arg1</em>, and <em>arg2</em> members.
 *
 * @param h  The <em>target</em> value to set.
 * @param what  The <em>what</em> value to set.
 * @param arg1  The <em>arg1</em> value to set.
 * @param arg2  The <em>arg2</em> value to set.
 * @return  A Message object from the global pool.
 * @apiSince 1
 */

public static android.os.Message obtain(android.os.Handler h, int what, int arg1, int arg2) { throw new RuntimeException("Stub!"); }

/**
 * Same as {@link #obtain()}, but sets the values of the <em>target</em>, <em>what</em>,
 * <em>arg1</em>, <em>arg2</em>, and <em>obj</em> members.
 *
 * @param h  The <em>target</em> value to set.
 * @param what  The <em>what</em> value to set.
 * @param arg1  The <em>arg1</em> value to set.
 * @param arg2  The <em>arg2</em> value to set.
 * @param obj  The <em>obj</em> value to set.
 * @return  A Message object from the global pool.
 * @apiSince 1
 */

public static android.os.Message obtain(android.os.Handler h, int what, int arg1, int arg2, java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Return a Message instance to the global pool.
 * <p>
 * You MUST NOT touch the Message after calling this function because it has
 * effectively been freed.  It is an error to recycle a message that is currently
 * enqueued or that is in the process of being delivered to a Handler.
 * </p>
 * @apiSince 1
 */

public void recycle() { throw new RuntimeException("Stub!"); }

/**
 * Make this message like o.  Performs a shallow copy of the data field.
 * Does not copy the linked list fields, nor the timestamp or
 * target/callback of the original message.
 * @apiSince 1
 */

public void copyFrom(android.os.Message o) { throw new RuntimeException("Stub!"); }

/**
 * Return the targeted delivery time of this message, in milliseconds.
 * @apiSince 1
 */

public long getWhen() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setTarget(android.os.Handler target) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the {@link android.os.Handler Handler} implementation that
 * will receive this message. The object must implement
 * {@link android.os.Handler#handleMessage(android.os.Message)
 * Handler.handleMessage()}. Each Handler has its own name-space for
 * message codes, so you do not need to
 * worry about yours conflicting with other handlers.
 * @apiSince 1
 */

public android.os.Handler getTarget() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve callback object that will execute when this message is handled.
 * This object must implement Runnable. This is called by
 * the <em>target</em> {@link android.os.Handler Handler} that is receiving this Message to
 * dispatch it.  If
 * not set, the message will be dispatched to the receiving Handler's
 * {@link android.os.Handler#handleMessage(android.os.Message) Handler#handleMessage(Message)}.
 * @apiSince 1
 */

public java.lang.Runnable getCallback() { throw new RuntimeException("Stub!"); }

/**
 * Obtains a Bundle of arbitrary data associated with this
 * event, lazily creating it if necessary. Set this value by calling
 * {@link #setData(android.os.Bundle)}.  Note that when transferring data across
 * processes via {@link android.os.Messenger Messenger}, you will need to set your ClassLoader
 * on the Bundle via {@link android.os.Bundle#setClassLoader(java.lang.ClassLoader) Bundle#setClassLoader(ClassLoader)} so that it can instantiate your objects when
 * you retrieve them.
 * @see #peekData()
 * @see #setData(Bundle)
 * @apiSince 1
 */

public android.os.Bundle getData() { throw new RuntimeException("Stub!"); }

/**
 * Like getData(), but does not lazily create the Bundle.  A null
 * is returned if the Bundle does not already exist.  See
 * {@link #getData} for further information on this.
 * @see #getData()
 * @see #setData(Bundle)
 * @apiSince 1
 */

public android.os.Bundle peekData() { throw new RuntimeException("Stub!"); }

/**
 * Sets a Bundle of arbitrary data values. Use arg1 and arg2 members
 * as a lower cost way to send a few simple integer values, if you can.
 * @see #getData()
 * @see #peekData()
 * @apiSince 1
 */

public void setData(android.os.Bundle data) { throw new RuntimeException("Stub!"); }

/**
 * Sends this Message to the Handler specified by {@link #getTarget}.
 * Throws a null pointer exception if this field has not been set.
 * @apiSince 1
 */

public void sendToTarget() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the message is asynchronous, meaning that it is not
 * subject to {@link android.os.Looper Looper} synchronization barriers.
 *
 * @return True if the message is asynchronous.
 *
 * @see #setAsynchronous(boolean)
 * @apiSince 22
 */

public boolean isAsynchronous() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the message is asynchronous, meaning that it is not
 * subject to {@link android.os.Looper Looper} synchronization barriers.
 * <p>
 * Certain operations, such as view invalidation, may introduce synchronization
 * barriers into the {@link android.os.Looper Looper}'s message queue to prevent subsequent messages
 * from being delivered until some condition is met.  In the case of view invalidation,
 * messages which are posted after a call to {@link android.view.View#invalidate}
 * are suspended by means of a synchronization barrier until the next frame is
 * ready to be drawn.  The synchronization barrier ensures that the invalidation
 * request is completely handled before resuming.
 * </p><p>
 * Asynchronous messages are exempt from synchronization barriers.  They typically
 * represent interrupts, input events, and other signals that must be handled independently
 * even while other work has been suspended.
 * </p><p>
 * Note that asynchronous messages may be delivered out of order with respect to
 * synchronous messages although they are always delivered in order among themselves.
 * If the relative order of these messages matters then they probably should not be
 * asynchronous in the first place.  Use with caution.
 * </p>
 *
 * @param async True if the message is asynchronous.
 *
 * @see #isAsynchronous()
 * @apiSince 22
 */

public void setAsynchronous(boolean async) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.os.Message> CREATOR;
static { CREATOR = null; }

/**
 * arg1 and arg2 are lower-cost alternatives to using
 * {@link #setData(android.os.Bundle) setData()} if you only need to store a
 * few integer values.
 * @apiSince 1
 */

public int arg1;

/**
 * arg1 and arg2 are lower-cost alternatives to using
 * {@link #setData(android.os.Bundle) setData()} if you only need to store a
 * few integer values.
 * @apiSince 1
 */

public int arg2;

/**
 * An arbitrary object to send to the recipient.  When using
 * {@link android.os.Messenger Messenger} to send the message across processes this can only
 * be non-null if it contains a Parcelable of a framework class (not one
 * implemented by the application).   For other data transfer use
 * {@link #setData}.
 *
 * <p>Note that Parcelable objects here are not supported prior to
 * the {@link android.os.Build.VERSION_CODES#FROYO} release.
 * @apiSince 1
 */

public java.lang.Object obj;

/**
 * Optional Messenger where replies to this message can be sent.  The
 * semantics of exactly how this is used are up to the sender and
 * receiver.
 * @apiSince 1
 */

public android.os.Messenger replyTo;

/**
 * Optional field indicating the uid that sent the message.  This is
 * only valid for messages posted by a {@link android.os.Messenger Messenger}; otherwise,
 * it will be -1.
 * @apiSince 21
 */

public int sendingUid = -1; // 0xffffffff

/**
 * User-defined message code so that the recipient can identify
 * what this message is about. Each {@link android.os.Handler Handler} has its own name-space
 * for message codes, so you do not need to worry about yours conflicting
 * with other handlers.
 * @apiSince 1
 */

public int what;
}

