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

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Base class for a remotable object, the core part of a lightweight
 * remote procedure call mechanism defined by {@link android.os.IBinder IBinder}.
 * This class is an implementation of IBinder that provides
 * standard local implementation of such an object.
 *
 * <p>Most developers will not implement this class directly, instead using the
 * <a href="{@docRoot}guide/components/aidl.html">aidl</a> tool to describe the desired
 * interface, having it generate the appropriate Binder subclass.  You can,
 * however, derive directly from Binder to implement your own custom RPC
 * protocol or simply instantiate a raw Binder object directly to use as a
 * token that can be shared across processes.
 *
 * <p>This class is just a basic IPC primitive; it has no impact on an application's
 * lifecycle, and is valid only as long as the process that created it continues to run.
 * To use this correctly, you must be doing so within the context of a top-level
 * application component (a {@link android.app.Service}, {@link android.app.Activity},
 * or {@link android.content.ContentProvider}) that lets the system know your process
 * should remain running.</p>
 *
 * <p>You must keep in mind the situations in which your process
 * could go away, and thus require that you later re-create a new Binder and re-attach
 * it when the process starts again.  For example, if you are using this within an
 * {@link android.app.Activity}, your activity's process may be killed any time the
 * activity is not started; if the activity is later re-created you will need to
 * create a new Binder and hand it back to the correct place again; you need to be
 * aware that your process may be started for another reason (for example to receive
 * a broadcast) that will not involve re-creating the activity and thus run its code
 * to create a new Binder.</p>
 *
 * @see android.os.IBinder
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Binder implements android.os.IBinder {

/**
 * Default constructor just initializes the object.
 *
 * If you're creating a Binder token (a Binder object without an attached interface),
 * you should use {@link #Binder(java.lang.String)} instead.
 * @apiSince 1
 */

public Binder() { throw new RuntimeException("Stub!"); }

/**
 * Constructor for creating a raw Binder object (token) along with a descriptor.
 *
 * The descriptor of binder objects usually specifies the interface they are implementing.
 * In case of binder tokens, no interface is implemented, and the descriptor can be used
 * as a sort of tag to help identify the binder token. This will help identify remote
 * references to these objects more easily when debugging.
 *
 * @param descriptor Used to identify the creator of this token, for example the class name.
 * Instead of creating multiple tokens with the same descriptor, consider adding a suffix to
 * help identify them.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public Binder(@androidx.annotation.Nullable java.lang.String descriptor) { throw new RuntimeException("Stub!"); }

/**
 * Return the ID of the process that sent you the current transaction
 * that is being processed.  This pid can be used with higher-level
 * system services to determine its identity and check permissions.
 * If the current thread is not currently executing an incoming transaction,
 * then its own pid is returned.
 * @apiSince 1
 */

public static final native int getCallingPid();

/**
 * Return the Linux uid assigned to the process that sent you the
 * current transaction that is being processed.  This uid can be used with
 * higher-level system services to determine its identity and check
 * permissions.  If the current thread is not currently executing an
 * incoming transaction, then its own uid is returned.
 * @apiSince 1
 */

public static final native int getCallingUid();

/**
 * Return the Linux uid assigned to the process that sent the transaction
 * currently being processed.
 *
 * @throws java.lang.IllegalStateException if the current thread is not currently
 *        executing an incoming transaction.
 * @apiSince 29
 */

public static final int getCallingUidOrThrow() { throw new RuntimeException("Stub!"); }

/**
 * Return the UserHandle assigned to the process that sent you the
 * current transaction that is being processed.  This is the user
 * of the caller.  It is distinct from {@link #getCallingUid()} in that a
 * particular user will have multiple distinct apps running under it each
 * with their own uid.  If the current thread is not currently executing an
 * incoming transaction, then its own UserHandle is returned.
 
 * @return This value will never be {@code null}.
 * @apiSince 17
 */

@androidx.annotation.NonNull
public static final android.os.UserHandle getCallingUserHandle() { throw new RuntimeException("Stub!"); }

/**
 * Reset the identity of the incoming IPC on the current thread.  This can
 * be useful if, while handling an incoming call, you will be calling
 * on interfaces of other objects that may be local to your process and
 * need to do permission checks on the calls coming into them (so they
 * will check the permission of your own local process, and not whatever
 * process originally called you).
 *
 * @return Returns an opaque token that can be used to restore the
 * original calling identity by passing it to
 * {@link #restoreCallingIdentity(long)}.
 *
 * @see #getCallingPid()
 * @see #getCallingUid()
 * @see #restoreCallingIdentity(long)
 * @apiSince 1
 */

public static final native long clearCallingIdentity();

/**
 * Restore the identity of the incoming IPC on the current thread
 * back to a previously identity that was returned by {@link
 * #clearCallingIdentity}.
 *
 * @param token The opaque token that was previously returned by
 * {@link #clearCallingIdentity}.
 *
 * @see #clearCallingIdentity
 * @apiSince 1
 */

public static final native void restoreCallingIdentity(long token);

/**
 * Sets the work source for this thread.
 *
 * <p>All the following binder calls on this thread will use the provided work source. If this
 * is called during an on-going binder transaction, all the following binder calls will use the
 * work source until the end of the transaction.
 *
 * <p>The concept of worksource is similar to {@link android.os.WorkSource WorkSource}. However, for performance
 * reasons, we only support one UID. This UID represents the original user responsible for the
 * binder calls.
 *
 * <p>{@link android.os.Binder#restoreCallingWorkSource(long) Binder#restoreCallingWorkSource(long)} must always be called after setting the
 * worksource.
 *
 * <p>A typical use case would be
 * <pre>
 * long token = Binder.setCallingWorkSourceUid(uid);
 * try {
 *   // Call an API.
 * } finally {
 *   Binder.restoreCallingWorkSource(token);
 * }
 * </pre>
 *
 * <p>The work source will be propagated for future outgoing binder transactions
 * executed on this thread.
 *
 * @param workSource The original UID responsible for the binder call.
 * @return token to restore original work source.
 *     * @apiSince 29
 */

public static final native long setCallingWorkSourceUid(int workSource);

/**
 * Returns the work source set by the caller.
 *
 * Unlike {@link android.os.Binder#getCallingUid() Binder#getCallingUid()}, this result of this method cannot be trusted. The
 * caller can set the value to whatever they want. Only use this value if you trust the calling
 * uid.
 *
 * @return The original UID responsible for the binder transaction.
 * @apiSince 29
 */

public static final native int getCallingWorkSourceUid();

/**
 * Clears the work source on this thread.
 *
 * <p>The work source will be propagated for future outgoing binder transactions
 * executed on this thread.
 *
 * <p>{@link android.os.Binder#restoreCallingWorkSource(long) Binder#restoreCallingWorkSource(long)} must always be called after clearing the
 * worksource.
 *
 * <p>A typical use case would be
 * <pre>
 * long token = Binder.clearCallingWorkSource();
 * try {
 *   // Call an API.
 * } finally {
 *   Binder.restoreCallingWorkSource(token);
 * }
 * </pre>
 *
 * @return token to restore original work source.
 *     * @apiSince 29
 */

public static final native long clearCallingWorkSource();

/**
 * Restores the work source on this thread using a token returned by
 * {@link #setCallingWorkSourceUid(int) or {@link clearCallingWorkSource()}.
 *
 * <p>A typical use case would be
 * <pre>
 * long token = Binder.setCallingWorkSourceUid(uid);
 * try {
 *   // Call an API.
 * } finally {
 *   Binder.restoreCallingWorkSource(token);
 * }
 * </pre>
 *     * @apiSince 29
 */

public static final native void restoreCallingWorkSource(long token);

/**
 * Flush any Binder commands pending in the current thread to the kernel
 * driver.  This can be
 * useful to call before performing an operation that may block for a long
 * time, to ensure that any pending object references have been released
 * in order to prevent the process from holding on to objects longer than
 * it needs to.
 * @apiSince 1
 */

public static final native void flushPendingCommands();

/**
 * Add the calling thread to the IPC thread pool.  This function does
 * not return until the current process is exiting.
 * @apiSince 1
 */

public static final void joinThreadPool() { throw new RuntimeException("Stub!"); }

/**
 * Convenience method for associating a specific interface with the Binder.
 * After calling, queryLocalInterface() will be implemented for you
 * to return the given owner IInterface when the corresponding
 * descriptor is requested.
 
 * @param owner This value may be {@code null}.
 
 * @param descriptor This value may be {@code null}.
 * @apiSince 1
 */

public void attachInterface(@androidx.annotation.Nullable android.os.IInterface owner, @androidx.annotation.Nullable java.lang.String descriptor) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation returns an empty interface name.
 
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String getInterfaceDescriptor() { throw new RuntimeException("Stub!"); }

/**
 * Default implementation always returns true -- if you got here,
 * the object is alive.
 * @apiSince 1
 */

public boolean pingBinder() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * Note that if you're calling on a local binder, this always returns true
 * because your process is alive if you're calling it.
 * @apiSince 1
 */

public boolean isBinderAlive() { throw new RuntimeException("Stub!"); }

/**
 * Use information supplied to attachInterface() to return the
 * associated IInterface if it matches the requested
 * descriptor.
 
 * @param descriptor This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.os.IInterface queryLocalInterface(@androidx.annotation.NonNull java.lang.String descriptor) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation is a stub that returns false.  You will want
 * to override this to do the appropriate unmarshalling of transactions.
 *
 * <p>If you want to call this, call transact().
 *
 * <p>Implementations that are returning a result should generally use
 * {@link android.os.Parcel#writeNoException() Parcel#writeNoException()} and
 * {@link android.os.Parcel#writeException(java.lang.Exception) Parcel#writeException(Exception)} to propagate
 * exceptions back to the caller.</p>
 *
 * @param code The action to perform.  This should
 * be a number between {@link #FIRST_CALL_TRANSACTION} and
 * {@link #LAST_CALL_TRANSACTION}.
 * @param data Marshalled data being received from the caller.
 * This value must never be {@code null}.
 * @param reply If the caller is expecting a result back, it should be marshalled
 * in to here.
 * This value may be {@code null}.
 * @param flags Additional operation flags.  Either 0 for a normal
 * RPC, or {@link #FLAG_ONEWAY} for a one-way RPC.
 *
 * @return Return true on a successful call; returning false is generally used to
 * indicate that you did not understand the transaction code.
 * @apiSince 1
 */

protected boolean onTransact(int code, @androidx.annotation.NonNull android.os.Parcel data, @androidx.annotation.Nullable android.os.Parcel reply, int flags) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * Implemented to call the more convenient version
 * {@link #dump(java.io.FileDescriptor,java.io.PrintWriter,java.lang.String[])}.
 
 * @param fd This value must never be {@code null}.
 
 * @param args This value may be {@code null}.
 * @apiSince 3
 */

public void dump(@androidx.annotation.NonNull java.io.FileDescriptor fd, @androidx.annotation.Nullable java.lang.String[] args) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #dump(java.io.FileDescriptor,java.lang.String[])}, but ensures the target
 * executes asynchronously.
 
 * @param fd This value must never be {@code null}.
 
 * @param args This value may be {@code null}.
 * @apiSince 13
 */

public void dumpAsync(@androidx.annotation.NonNull java.io.FileDescriptor fd, @androidx.annotation.Nullable java.lang.String[] args) { throw new RuntimeException("Stub!"); }

/**
 * Print the object's state into the given stream.
 *
 * @param fd The raw file descriptor that the dump is being sent to.
 * This value must never be {@code null}.
 * @param fout The file to which you should dump your state.  This will be
 * closed for you after you return.
 * This value must never be {@code null}.
 * @param args additional arguments to the dump request.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

protected void dump(@androidx.annotation.NonNull java.io.FileDescriptor fd, @androidx.annotation.NonNull java.io.PrintWriter fout, @androidx.annotation.Nullable java.lang.String[] args) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation rewinds the parcels and calls onTransact.  On
 * the remote side, transact calls into the binder to do the IPC.
 
 * @param data This value must never be {@code null}.
 
 * @param reply This value may be {@code null}.
 * @apiSince 1
 */

public final boolean transact(int code, @androidx.annotation.NonNull android.os.Parcel data, @androidx.annotation.Nullable android.os.Parcel reply, int flags) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * Local implementation is a no-op.
 
 * @param recipient This value must never be {@code null}.
 * @apiSince 1
 */

public void linkToDeath(@androidx.annotation.NonNull android.os.IBinder.DeathRecipient recipient, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Local implementation is a no-op.
 
 * @param recipient This value must never be {@code null}.
 * @apiSince 1
 */

public boolean unlinkToDeath(@androidx.annotation.NonNull android.os.IBinder.DeathRecipient recipient, int flags) { throw new RuntimeException("Stub!"); }
}

