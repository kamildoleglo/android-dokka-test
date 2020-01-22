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


package android.os;


/**
 * Takes care of the grunt work of maintaining a list of remote interfaces,
 * typically for the use of performing callbacks from a
 * {@link android.app.Service} to its clients.  In particular, this:
 *
 * <ul>
 * <li> Keeps track of a set of registered {@link android.os.IInterface IInterface} callbacks,
 * taking care to identify them through their underlying unique {@link android.os.IBinder IBinder}
 * (by calling {@link android.os.IInterface#asBinder IInterface#asBinder}.
 * <li> Attaches a {@link android.os.IBinder.DeathRecipient IBinder.DeathRecipient} to
 * each registered interface, so that it can be cleaned out of the list if its
 * process goes away.
 * <li> Performs locking of the underlying list of interfaces to deal with
 * multithreaded incoming calls, and a thread-safe way to iterate over a
 * snapshot of the list without holding its lock.
 * </ul>
 *
 * <p>To use this class, simply create a single instance along with your
 * service, and call its {@link #register} and {@link #unregister} methods
 * as client register and unregister with your service.  To call back on to
 * the registered clients, use {@link #beginBroadcast},
 * {@link #getBroadcastItem}, and {@link #finishBroadcast}.
 *
 * <p>If a registered callback's process goes away, this class will take
 * care of automatically removing it from the list.  If you want to do
 * additional work in this situation, you can create a subclass that
 * implements the {@link #onCallbackDied} method.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RemoteCallbackList<E extends android.os.IInterface> {

public RemoteCallbackList() { throw new RuntimeException("Stub!"); }

/**
 * Simple version of {@link android.os.RemoteCallbackList#register(E,java.lang.Object) RemoteCallbackList#register(E, Object)}
 * that does not take a cookie object.
 * @apiSince 1
 */

public boolean register(E callback) { throw new RuntimeException("Stub!"); }

/**
 * Add a new callback to the list.  This callback will remain in the list
 * until a corresponding call to {@link #unregister} or its hosting process
 * goes away.  If the callback was already registered (determined by
 * checking to see if the {@link android.os.IInterface#asBinder IInterface#asBinder}
 * object is already in the list), then it will be left as-is.
 * Registrations are not counted; a single call to {@link #unregister}
 * will remove a callback after any number calls to register it.
 *
 * @param callback The callback interface to be added to the list.  Must
 * not be null -- passing null here will cause a NullPointerException.
 * Most services will want to check for null before calling this with
 * an object given from a client, so that clients can't crash the
 * service with bad data.
 *
 * @param cookie Optional additional data to be associated with this
 * callback.
 *
 * @return Returns true if the callback was successfully added to the list.
 * Returns false if it was not added, either because {@link #kill} had
 * previously been called or the callback's process has gone away.
 *
 * @see #unregister
 * @see #kill
 * @see #onCallbackDied
 * @apiSince 4
 */

public boolean register(E callback, java.lang.Object cookie) { throw new RuntimeException("Stub!"); }

/**
 * Remove from the list a callback that was previously added with
 * {@link #register}.  This uses the
 * {@link android.os.IInterface#asBinder IInterface#asBinder} object to correctly
 * find the previous registration.
 * Registrations are not counted; a single unregister call will remove
 * a callback after any number calls to {@link #register} for it.
 *
 * @param callback The callback to be removed from the list.  Passing
 * null here will cause a NullPointerException, so you will generally want
 * to check for null before calling.
 *
 * @return Returns true if the callback was found and unregistered.  Returns
 * false if the given callback was not found on the list.
 *
 * @see #register
 * @apiSince 1
 */

public boolean unregister(E callback) { throw new RuntimeException("Stub!"); }

/**
 * Disable this callback list.  All registered callbacks are unregistered,
 * and the list is disabled so that future calls to {@link #register} will
 * fail.  This should be used when a Service is stopping, to prevent clients
 * from registering callbacks after it is stopped.
 *
 * @see #register
 * @apiSince 1
 */

public void kill() { throw new RuntimeException("Stub!"); }

/**
 * Old version of {@link #onCallbackDied(E,java.lang.Object)} that
 * does not provide a cookie.
 * @apiSince 1
 */

public void onCallbackDied(E callback) { throw new RuntimeException("Stub!"); }

/**
 * Called when the process hosting a callback in the list has gone away.
 * The default implementation calls {@link #onCallbackDied(E)}
 * for backwards compatibility.
 *
 * @param callback The callback whose process has died.  Note that, since
 * its process has died, you can not make any calls on to this interface.
 * You can, however, retrieve its IBinder and compare it with another
 * IBinder to see if it is the same object.
 * @param cookie The cookie object original provided to
 * {@link #register(E,java.lang.Object)}.
 *
 * @see #register
 * @apiSince 4
 */

public void onCallbackDied(E callback, java.lang.Object cookie) { throw new RuntimeException("Stub!"); }

/**
 * Prepare to start making calls to the currently registered callbacks.
 * This creates a copy of the callback list, which you can retrieve items
 * from using {@link #getBroadcastItem}.  Note that only one broadcast can
 * be active at a time, so you must be sure to always call this from the
 * same thread (usually by scheduling with {@link android.os.Handler Handler}) or
 * do your own synchronization.  You must call {@link #finishBroadcast}
 * when done.
 *
 * <p>A typical loop delivering a broadcast looks like this:
 *
 * <pre>
 * int i = callbacks.beginBroadcast();
 * while (i &gt; 0) {
 *     i--;
 *     try {
 *         callbacks.getBroadcastItem(i).somethingHappened();
 *     } catch (RemoteException e) {
 *         // The RemoteCallbackList will take care of removing
 *         // the dead object for us.
 *     }
 * }
 * callbacks.finishBroadcast();</pre>
 *
 * @return Returns the number of callbacks in the broadcast, to be used
 * with {@link #getBroadcastItem} to determine the range of indices you
 * can supply.
 *
 * @see #getBroadcastItem
 * @see #finishBroadcast
 * @apiSince 1
 */

public int beginBroadcast() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve an item in the active broadcast that was previously started
 * with {@link #beginBroadcast}.  This can <em>only</em> be called after
 * the broadcast is started, and its data is no longer valid after
 * calling {@link #finishBroadcast}.
 *
 * <p>Note that it is possible for the process of one of the returned
 * callbacks to go away before you call it, so you will need to catch
 * {@link android.os.RemoteException RemoteException} when calling on to the returned object.
 * The callback list itself, however, will take care of unregistering
 * these objects once it detects that it is no longer valid, so you can
 * handle such an exception by simply ignoring it.
 *
 * @param index Which of the registered callbacks you would like to
 * retrieve.  Ranges from 0 to 1-{@link #beginBroadcast}.
 *
 * @return Returns the callback interface that you can call.  This will
 * always be non-null.
 *
 * @see #beginBroadcast
 * @apiSince 1
 */

public E getBroadcastItem(int index) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the cookie associated with the item
 * returned by {@link #getBroadcastItem(int)}.
 *
 * @see #getBroadcastItem
 * @apiSince 4
 */

public java.lang.Object getBroadcastCookie(int index) { throw new RuntimeException("Stub!"); }

/**
 * Clean up the state of a broadcast previously initiated by calling
 * {@link #beginBroadcast}.  This must always be called when you are done
 * with a broadcast.
 *
 * @see #beginBroadcast
 * @apiSince 1
 */

public void finishBroadcast() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of registered callbacks. Note that the number of registered
 * callbacks may differ from the value returned by {@link #beginBroadcast()} since
 * the former returns the number of callbacks registered at the time of the call
 * and the second the number of callback to which the broadcast will be delivered.
 * <p>
 * This function is useful to decide whether to schedule a broadcast if this
 * requires doing some work which otherwise would not be performed.
 * </p>
 *
 * @return The size.
 * @apiSince 17
 */

public int getRegisteredCallbackCount() { throw new RuntimeException("Stub!"); }

/**
 * Return a currently registered callback.  Note that this is
 * <em>not</em> the same as {@link #getBroadcastItem} and should not be used
 * interchangeably with it.  This method returns the registered callback at the given
 * index, not the current broadcast state.  This means that it is not itself thread-safe:
 * any call to {@link #register} or {@link #unregister} will change these indices, so you
 * must do your own thread safety between these to protect from such changes.
 *
 * @param index Index of which callback registration to return, from 0 to
 * {@link #getRegisteredCallbackCount()} - 1.
 *
 * @return Returns whatever callback is associated with this index, or null if
 * {@link #kill()} has been called.
 * @apiSince 26
 */

public E getRegisteredCallbackItem(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return any cookie associated with a currently registered callback.  Note that this is
 * <em>not</em> the same as {@link #getBroadcastCookie} and should not be used
 * interchangeably with it.  This method returns the current cookie registered at the given
 * index, not the current broadcast state.  This means that it is not itself thread-safe:
 * any call to {@link #register} or {@link #unregister} will change these indices, so you
 * must do your own thread safety between these to protect from such changes.
 *
 * @param index Index of which registration cookie to return, from 0 to
 * {@link #getRegisteredCallbackCount()} - 1.
 *
 * @return Returns whatever cookie object is associated with this index, or null if
 * {@link #kill()} has been called.
 * @apiSince 26
 */

public java.lang.Object getRegisteredCallbackCookie(int index) { throw new RuntimeException("Stub!"); }
}

