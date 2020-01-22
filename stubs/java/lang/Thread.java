/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1994, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */



package java.lang;

import java.util.Map;
import java.util.concurrent.locks.LockSupport;

/**
 * A <i>thread</i> is a thread of execution in a program. The Java
 * Virtual Machine allows an application to have multiple threads of
 * execution running concurrently.
 * <p>
 * Every thread has a priority. Threads with higher priority are
 * executed in preference to threads with lower priority. Each thread
 * may or may not also be marked as a daemon. When code running in
 * some thread creates a new <code>Thread</code> object, the new
 * thread has its priority initially set equal to the priority of the
 * creating thread, and is a daemon thread if and only if the
 * creating thread is a daemon.
 * <p>
 * When a Java Virtual Machine starts up, there is usually a single
 * non-daemon thread (which typically calls the method named
 * <code>main</code> of some designated class). The Java Virtual
 * Machine continues to execute threads until either of the following
 * occurs:
 * <ul>
 * <li>The <code>exit</code> method of class <code>Runtime</code> has been
 *     called and the security manager has permitted the exit operation
 *     to take place.
 * <li>All threads that are not daemon threads have died, either by
 *     returning from the call to the <code>run</code> method or by
 *     throwing an exception that propagates beyond the <code>run</code>
 *     method.
 * </ul>
 * <p>
 * There are two ways to create a new thread of execution. One is to
 * declare a class to be a subclass of <code>Thread</code>. This
 * subclass should override the <code>run</code> method of class
 * <code>Thread</code>. An instance of the subclass can then be
 * allocated and started. For example, a thread that computes primes
 * larger than a stated value could be written as follows:
 * <hr><blockquote><pre>
 *     class PrimeThread extends Thread {
 *         long minPrime;
 *         PrimeThread(long minPrime) {
 *             this.minPrime = minPrime;
 *         }
 *
 *         public void run() {
 *             // compute primes larger than minPrime
 *             &nbsp;.&nbsp;.&nbsp;.
 *         }
 *     }
 * </pre></blockquote><hr>
 * <p>
 * The following code would then create a thread and start it running:
 * <blockquote><pre>
 *     PrimeThread p = new PrimeThread(143);
 *     p.start();
 * </pre></blockquote>
 * <p>
 * The other way to create a thread is to declare a class that
 * implements the <code>Runnable</code> interface. That class then
 * implements the <code>run</code> method. An instance of the class can
 * then be allocated, passed as an argument when creating
 * <code>Thread</code>, and started. The same example in this other
 * style looks like the following:
 * <hr><blockquote><pre>
 *     class PrimeRun implements Runnable {
 *         long minPrime;
 *         PrimeRun(long minPrime) {
 *             this.minPrime = minPrime;
 *         }
 *
 *         public void run() {
 *             // compute primes larger than minPrime
 *             &nbsp;.&nbsp;.&nbsp;.
 *         }
 *     }
 * </pre></blockquote><hr>
 * <p>
 * The following code would then create a thread and start it running:
 * <blockquote><pre>
 *     PrimeRun p = new PrimeRun(143);
 *     new Thread(p).start();
 * </pre></blockquote>
 * <p>
 * Every thread has a name for identification purposes. More than
 * one thread may have the same name. If a name is not specified when
 * a thread is created, a new name is generated for it.
 * <p>
 * Unless otherwise noted, passing a {@code null} argument to a constructor
 * or method in this class will cause a {@link java.lang.NullPointerException NullPointerException} to be
 * thrown.
 *
 * @author  unascribed
 * @see     java.lang.Runnable
 * @see     java.lang.Runtime#exit(int)
 * @see     #run()
 * @see     #stop()
 * @since   JDK1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Thread implements java.lang.Runnable {

/**
 * Allocates a new {@code Thread} object. This constructor has the same
 * effect as {@linkplain #Thread(java.lang.ThreadGroup,java.lang.Runnable,java.lang.String) Thread}
 * {@code (null, null, gname)}, where {@code gname} is a newly generated
 * name. Automatically generated names are of the form
 * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
 * @apiSince 1
 */

public Thread() { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new {@code Thread} object. This constructor has the same
 * effect as {@linkplain #Thread(java.lang.ThreadGroup,java.lang.Runnable,java.lang.String) Thread}
 * {@code (null, target, gname)}, where {@code gname} is a newly generated
 * name. Automatically generated names are of the form
 * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
 *
 * @param  target
 *         the object whose {@code run} method is invoked when this thread
 *         is started. If {@code null}, this classes {@code run} method does
 *         nothing.
 * @apiSince 1
 */

public Thread(@androidx.annotation.Nullable java.lang.Runnable target) { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new {@code Thread} object. This constructor has the same
 * effect as {@linkplain #Thread(java.lang.ThreadGroup,java.lang.Runnable,java.lang.String) Thread}
 * {@code (group, target, gname)} ,where {@code gname} is a newly generated
 * name. Automatically generated names are of the form
 * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
 *
 * @param  group
 *         the thread group. If {@code null} and there is a security
 *         manager, the group is determined by {@linkplain java.lang.SecurityManager#getThreadGroup SecurityManager#getThreadGroup}.
 *         If there is not a security manager or {@code
 *         SecurityManager.getThreadGroup()} returns {@code null}, the group
 *         is set to the current thread's thread group.
 *
 * @param  target
 *         the object whose {@code run} method is invoked when this thread
 *         is started. If {@code null}, this thread's run method is invoked.
 *
 * @throws  java.lang.SecurityException
 *          if the current thread cannot create a thread in the specified
 *          thread group
 * @apiSince 1
 */

public Thread(@androidx.annotation.Nullable java.lang.ThreadGroup group, @androidx.annotation.Nullable java.lang.Runnable target) { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new {@code Thread} object. This constructor has the same
 * effect as {@linkplain #Thread(java.lang.ThreadGroup,java.lang.Runnable,java.lang.String) Thread}
 * {@code (null, null, name)}.
 *
 * @param   name
 *          the name of the new thread
 * @apiSince 1
 */

public Thread(@androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new {@code Thread} object. This constructor has the same
 * effect as {@linkplain #Thread(java.lang.ThreadGroup,java.lang.Runnable,java.lang.String) Thread}
 * {@code (group, null, name)}.
 *
 * @param  group
 *         the thread group. If {@code null} and there is a security
 *         manager, the group is determined by {@linkplain java.lang.SecurityManager#getThreadGroup SecurityManager#getThreadGroup}.
 *         If there is not a security manager or {@code
 *         SecurityManager.getThreadGroup()} returns {@code null}, the group
 *         is set to the current thread's thread group.
 *
 * @param  name
 *         the name of the new thread
 *
 * @throws  java.lang.SecurityException
 *          if the current thread cannot create a thread in the specified
 *          thread group
 * @apiSince 1
 */

public Thread(@androidx.annotation.Nullable java.lang.ThreadGroup group, @androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new {@code Thread} object. This constructor has the same
 * effect as {@linkplain #Thread(java.lang.ThreadGroup,java.lang.Runnable,java.lang.String) Thread}
 * {@code (null, target, name)}.
 *
 * @param  target
 *         the object whose {@code run} method is invoked when this thread
 *         is started. If {@code null}, this thread's run method is invoked.
 *
 * @param  name
 *         the name of the new thread
 * @apiSince 1
 */

public Thread(@androidx.annotation.Nullable java.lang.Runnable target, @androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new {@code Thread} object so that it has {@code target}
 * as its run object, has the specified {@code name} as its name,
 * and belongs to the thread group referred to by {@code group}.
 *
 * <p>If there is a security manager, its
 * {@link java.lang.SecurityManager#checkAccess(java.lang.ThreadGroup) SecurityManager#checkAccess(ThreadGroup)}
 * method is invoked with the ThreadGroup as its argument.
 *
 * <p>In addition, its {@code checkPermission} method is invoked with
 * the {@code RuntimePermission("enableContextClassLoaderOverride")}
 * permission when invoked directly or indirectly by the constructor
 * of a subclass which overrides the {@code getContextClassLoader}
 * or {@code setContextClassLoader} methods.
 *
 * <p>The priority of the newly created thread is set equal to the
 * priority of the thread creating it, that is, the currently running
 * thread. The method {@linkplain #setPriority setPriority} may be
 * used to change the priority to a new value.
 *
 * <p>The newly created thread is initially marked as being a daemon
 * thread if and only if the thread creating it is currently marked
 * as a daemon thread. The method {@linkplain #setDaemon setDaemon}
 * may be used to change whether or not a thread is a daemon.
 *
 * @param  group
 *         the thread group. If {@code null} and there is a security
 *         manager, the group is determined by {@linkplain java.lang.SecurityManager#getThreadGroup SecurityManager#getThreadGroup}.
 *         If there is not a security manager or {@code
 *         SecurityManager.getThreadGroup()} returns {@code null}, the group
 *         is set to the current thread's thread group.
 *
 * @param  target
 *         the object whose {@code run} method is invoked when this thread
 *         is started. If {@code null}, this thread's run method is invoked.
 *
 * @param  name
 *         the name of the new thread
 *
 * @throws  java.lang.SecurityException
 *          if the current thread cannot create a thread in the specified
 *          thread group or cannot override the context class loader methods.
 * @apiSince 1
 */

public Thread(@androidx.annotation.Nullable java.lang.ThreadGroup group, @androidx.annotation.Nullable java.lang.Runnable target, @androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new {@code Thread} object so that it has {@code target}
 * as its run object, has the specified {@code name} as its name,
 * and belongs to the thread group referred to by {@code group}, and has
 * the specified <i>stack size</i>.
 *
 * <p>This constructor is identical to {@link
 * #Thread(java.lang.ThreadGroup,java.lang.Runnable,java.lang.String)} with the exception of the fact
 * that it allows the thread stack size to be specified.  The stack size
 * is the approximate number of bytes of address space that the virtual
 * machine is to allocate for this thread's stack.  <b>The effect of the
 * {@code stackSize} parameter, if any, is highly platform dependent.</b>
 *
 * <p>On some platforms, specifying a higher value for the
 * {@code stackSize} parameter may allow a thread to achieve greater
 * recursion depth before throwing a {@link java.lang.StackOverflowError StackOverflowError}.
 * Similarly, specifying a lower value may allow a greater number of
 * threads to exist concurrently without throwing an {@link java.lang.OutOfMemoryError OutOfMemoryError} (or other internal error).  The details of
 * the relationship between the value of the <tt>stackSize</tt> parameter
 * and the maximum recursion depth and concurrency level are
 * platform-dependent.  <b>On some platforms, the value of the
 * {@code stackSize} parameter may have no effect whatsoever.</b>
 *
 * <p>The virtual machine is free to treat the {@code stackSize}
 * parameter as a suggestion.  If the specified value is unreasonably low
 * for the platform, the virtual machine may instead use some
 * platform-specific minimum value; if the specified value is unreasonably
 * high, the virtual machine may instead use some platform-specific
 * maximum.  Likewise, the virtual machine is free to round the specified
 * value up or down as it sees fit (or to ignore it completely).
 *
 * <p>Specifying a value of zero for the {@code stackSize} parameter will
 * cause this constructor to behave exactly like the
 * {@code Thread(ThreadGroup, Runnable, String)} constructor.
 *
 * <p><i>Due to the platform-dependent nature of the behavior of this
 * constructor, extreme care should be exercised in its use.
 * The thread stack size necessary to perform a given computation will
 * likely vary from one JRE implementation to another.  In light of this
 * variation, careful tuning of the stack size parameter may be required,
 * and the tuning may need to be repeated for each JRE implementation on
 * which an application is to run.</i>
 *
 * <p>Implementation note: Java platform implementers are encouraged to
 * document their implementation's behavior with respect to the
 * {@code stackSize} parameter.
 *
 *
 * @param  group
 *         the thread group. If {@code null} and there is a security
 *         manager, the group is determined by {@linkplain java.lang.SecurityManager#getThreadGroup SecurityManager#getThreadGroup}.
 *         If there is not a security manager or {@code
 *         SecurityManager.getThreadGroup()} returns {@code null}, the group
 *         is set to the current thread's thread group.
 *
 * @param  target
 *         the object whose {@code run} method is invoked when this thread
 *         is started. If {@code null}, this thread's run method is invoked.
 *
 * @param  name
 *         the name of the new thread
 *
 * @param  stackSize
 *         the desired stack size for the new thread, or zero to indicate
 *         that this parameter is to be ignored.
 *
 * @throws  java.lang.SecurityException
 *          if the current thread cannot create a thread in the specified
 *          thread group
 *
 * @since 1.4
 * @apiSince 1
 */

public Thread(@androidx.annotation.Nullable java.lang.ThreadGroup group, @androidx.annotation.Nullable java.lang.Runnable target, @androidx.annotation.NonNull java.lang.String name, long stackSize) { throw new RuntimeException("Stub!"); }

/**
 * Returns a reference to the currently executing thread object.
 *
 * @return  the currently executing thread.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static native java.lang.Thread currentThread();

/**
 * A hint to the scheduler that the current thread is willing to yield
 * its current use of a processor. The scheduler is free to ignore this
 * hint.
 *
 * <p> Yield is a heuristic attempt to improve relative progression
 * between threads that would otherwise over-utilise a CPU. Its use
 * should be combined with detailed profiling and benchmarking to
 * ensure that it actually has the desired effect.
 *
 * <p> It is rarely appropriate to use this method. It may be useful
 * for debugging or testing purposes, where it may help to reproduce
 * bugs due to race conditions. It may also be useful when designing
 * concurrency control constructs such as the ones in the
 * {@link java.util.concurrent.locks} package.
 * @apiSince 1
 */

public static native void yield();

/**
 * Causes the currently executing thread to sleep (temporarily cease
 * execution) for the specified number of milliseconds, subject to
 * the precision and accuracy of system timers and schedulers. The thread
 * does not lose ownership of any monitors.
 *
 * @param  millis
 *         the length of time to sleep in milliseconds
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the value of {@code millis} is negative
 *
 * @throws  java.lang.InterruptedException
 *          if any thread has interrupted the current thread. The
 *          <i>interrupted status</i> of the current thread is
 *          cleared when this exception is thrown.
 * @apiSince 1
 */

public static void sleep(long millis) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Causes the currently executing thread to sleep (temporarily cease
 * execution) for the specified number of milliseconds plus the specified
 * number of nanoseconds, subject to the precision and accuracy of system
 * timers and schedulers. The thread does not lose ownership of any
 * monitors.
 *
 * @param  millis
 *         the length of time to sleep in milliseconds
 *
 * @param  nanos
 *         {@code 0-999999} additional nanoseconds to sleep
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the value of {@code millis} is negative, or the value of
 *          {@code nanos} is not in the range {@code 0-999999}
 *
 * @throws  java.lang.InterruptedException
 *          if any thread has interrupted the current thread. The
 *          <i>interrupted status</i> of the current thread is
 *          cleared when this exception is thrown.
 * @apiSince 1
 */

public static void sleep(long millis, int nanos) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Throws CloneNotSupportedException as a Thread can not be meaningfully
 * cloned. Construct a new Thread instead.
 *
 * @throws  java.lang.CloneNotSupportedException
 *          always
 * @apiSince 1
 */

@androidx.annotation.NonNull
protected java.lang.Object clone() throws java.lang.CloneNotSupportedException { throw new RuntimeException("Stub!"); }

/**
 * Causes this thread to begin execution; the Java Virtual Machine
 * calls the <code>run</code> method of this thread.
 * <p>
 * The result is that two threads are running concurrently: the
 * current thread (which returns from the call to the
 * <code>start</code> method) and the other thread (which executes its
 * <code>run</code> method).
 * <p>
 * It is never legal to start a thread more than once.
 * In particular, a thread may not be restarted once it has completed
 * execution.
 *
 * @exception  java.lang.IllegalThreadStateException  if the thread was already
 *               started.
 * @see        #run()
 * @see        #stop()
 * @apiSince 1
 */

public synchronized void start() { throw new RuntimeException("Stub!"); }

/**
 * If this thread was constructed using a separate
 * <code>Runnable</code> run object, then that
 * <code>Runnable</code> object's <code>run</code> method is called;
 * otherwise, this method does nothing and returns.
 * <p>
 * Subclasses of <code>Thread</code> should override this method.
 *
 * @see     #start()
 * @see     #stop()
 * @see     #Thread(ThreadGroup, Runnable, String)
 * @apiSince 1
 */

public void run() { throw new RuntimeException("Stub!"); }

/**
 * Throws {@code UnsupportedOperationException}.
 *
 * @deprecated This method was originally designed to force a thread to stop
 *       and throw a {@code ThreadDeath} as an exception. It was inherently unsafe.
 *       Stopping a thread with
 *       Thread.stop causes it to unlock all of the monitors that it
 *       has locked (as a natural consequence of the unchecked
 *       <code>ThreadDeath</code> exception propagating up the stack).  If
 *       any of the objects previously protected by these monitors were in
 *       an inconsistent state, the damaged objects become visible to
 *       other threads, potentially resulting in arbitrary behavior.  Many
 *       uses of <code>stop</code> should be replaced by code that simply
 *       modifies some variable to indicate that the target thread should
 *       stop running.  The target thread should check this variable
 *       regularly, and return from its run method in an orderly fashion
 *       if the variable indicates that it is to stop running.  If the
 *       target thread waits for long periods (on a condition variable,
 *       for example), the <code>interrupt</code> method should be used to
 *       interrupt the wait.
 *       For more information, see
 *       <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/concurrency/threadPrimitiveDeprecation.html">Why
 *       are Thread.stop, Thread.suspend and Thread.resume Deprecated?</a>.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public final void stop() { throw new RuntimeException("Stub!"); }

/**
 * Throws {@code UnsupportedOperationException}.
 *
 * @param obj ignored
 *
 * @deprecated This method was originally designed to force a thread to stop
 *        and throw a given {@code Throwable} as an exception. It was
 *        inherently unsafe (see {@link #stop()} for details), and furthermore
 *        could be used to generate exceptions that the target thread was
 *        not prepared to handle.
 *        For more information, see
 *        <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/concurrency/threadPrimitiveDeprecation.html">Why
 *        are Thread.stop, Thread.suspend and Thread.resume Deprecated?</a>.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public final synchronized void stop(@androidx.annotation.Nullable java.lang.Throwable obj) { throw new RuntimeException("Stub!"); }

/**
 * Interrupts this thread.
 *
 * <p> Unless the current thread is interrupting itself, which is
 * always permitted, the {@link #checkAccess() checkAccess} method
 * of this thread is invoked, which may cause a {@link java.lang.SecurityException SecurityException} to be thrown.
 *
 * <p> If this thread is blocked in an invocation of the {@link java.lang.Object#wait() Object#wait()}, {@link java.lang.Object#wait(long) Object#wait(long)}, or {@link java.lang.Object#wait(long,int) Object#wait(long, int)} methods of the {@link java.lang.Object Object}
 * class, or of the {@link #join()}, {@link #join(long)}, {@link
 * #join(long,int)}, {@link #sleep(long)}, or {@link #sleep(long,int)},
 * methods of this class, then its interrupt status will be cleared and it
 * will receive an {@link java.lang.InterruptedException InterruptedException}.
 *
 * <p> If this thread is blocked in an I/O operation upon an {@link
 * java.nio.channels.InterruptibleChannel InterruptibleChannel}
 * then the channel will be closed, the thread's interrupt
 * status will be set, and the thread will receive a {@link
 * java.nio.channels.ClosedByInterruptException}.
 *
 * <p> If this thread is blocked in a {@link java.nio.channels.Selector}
 * then the thread's interrupt status will be set and it will return
 * immediately from the selection operation, possibly with a non-zero
 * value, just as if the selector's {@link
 * java.nio.channels.Selector#wakeup wakeup} method were invoked.
 *
 * <p> If none of the previous conditions hold then this thread's interrupt
 * status will be set. </p>
 *
 * <p> Interrupting a thread that is not alive need not have any effect.
 *
 * @throws  java.lang.SecurityException
 *          if the current thread cannot modify this thread
 *
 * @revised 6.0
 * @spec JSR-51
 * @apiSince 1
 */

public void interrupt() { throw new RuntimeException("Stub!"); }

/**
 * Tests whether the current thread has been interrupted.  The
 * <i>interrupted status</i> of the thread is cleared by this method.  In
 * other words, if this method were to be called twice in succession, the
 * second call would return false (unless the current thread were
 * interrupted again, after the first call had cleared its interrupted
 * status and before the second call had examined it).
 *
 * <p>A thread interruption ignored because a thread was not alive
 * at the time of the interrupt will be reflected by this method
 * returning false.
 *
 * @return  <code>true</code> if the current thread has been interrupted;
 *          <code>false</code> otherwise.
 * @see #isInterrupted()
 * @revised 6.0
 * @apiSince 1
 */

public static native boolean interrupted();

/**
 * Tests whether this thread has been interrupted.  The <i>interrupted
 * status</i> of the thread is unaffected by this method.
 *
 * <p>A thread interruption ignored because a thread was not alive
 * at the time of the interrupt will be reflected by this method
 * returning false.
 *
 * @return  <code>true</code> if this thread has been interrupted;
 *          <code>false</code> otherwise.
 * @see     #interrupted()
 * @revised 6.0
 * @apiSince 1
 */

public native boolean isInterrupted();

/**
 * Throws {@link java.lang.UnsupportedOperationException UnsupportedOperationException}.
 *
 * @deprecated This method was originally designed to destroy this
 *     thread without any cleanup. Any monitors it held would have
 *     remained locked. However, the method was never implemented.
 *     If if were to be implemented, it would be deadlock-prone in
 *     much the manner of {@link #suspend}. If the target thread held
 *     a lock protecting a critical system resource when it was
 *     destroyed, no thread could ever access this resource again.
 *     If another thread ever attempted to lock this resource, deadlock
 *     would result. Such deadlocks typically manifest themselves as
 *     "frozen" processes. For more information, see
 *     <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/concurrency/threadPrimitiveDeprecation.html">
 *     Why are Thread.stop, Thread.suspend and Thread.resume Deprecated?</a>.
 * @throws java.lang.UnsupportedOperationException always
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void destroy() { throw new RuntimeException("Stub!"); }

/**
 * Tests if this thread is alive. A thread is alive if it has
 * been started and has not yet died.
 *
 * @return  <code>true</code> if this thread is alive;
 *          <code>false</code> otherwise.
 * @apiSince 1
 */

public final boolean isAlive() { throw new RuntimeException("Stub!"); }

/**
 * Throws {@link java.lang.UnsupportedOperationException UnsupportedOperationException}.
 *
 * @deprecated   This method was designed to suspend the Thread but it was
 *   inherently deadlock-prone.  If the target thread holds a lock on the
 *   monitor protecting a critical system resource when it is suspended, no
 *   thread can access this resource until the target thread is resumed. If
 *   the thread that would resume the target thread attempts to lock this
 *   monitor prior to calling <code>resume</code>, deadlock results.  Such
 *   deadlocks typically manifest themselves as "frozen" processes.
 *   For more information, see
 *   <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/concurrency/threadPrimitiveDeprecation.html">Why
 *   are Thread.stop, Thread.suspend and Thread.resume Deprecated?</a>.
 * @throws java.lang.UnsupportedOperationException always
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public final void suspend() { throw new RuntimeException("Stub!"); }

/**
 * Throws {@link java.lang.UnsupportedOperationException UnsupportedOperationException}.
 *
 * @deprecated This method exists solely for use with {@link #suspend},
 *     which has been deprecated because it is deadlock-prone.
 *     For more information, see
 *     <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/concurrency/threadPrimitiveDeprecation.html">Why
 *     are Thread.stop, Thread.suspend and Thread.resume Deprecated?</a>.
 * @throws java.lang.UnsupportedOperationException always
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public final void resume() { throw new RuntimeException("Stub!"); }

/**
 * Changes the priority of this thread.
 * <p>
 * First the <code>checkAccess</code> method of this thread is called
 * with no arguments. This may result in throwing a
 * <code>SecurityException</code>.
 * <p>
 * Otherwise, the priority of this thread is set to the smaller of
 * the specified <code>newPriority</code> and the maximum permitted
 * priority of the thread's thread group.
 *
 * @param newPriority priority to set this thread to
 * @exception  java.lang.IllegalArgumentException  If the priority is not in the
 *               range <code>MIN_PRIORITY</code> to
 *               <code>MAX_PRIORITY</code>.
 * @exception  java.lang.SecurityException  if the current thread cannot modify
 *               this thread.
 * @see        #getPriority
 * @see        #checkAccess()
 * @see        #getThreadGroup()
 * @see        #MAX_PRIORITY
 * @see        #MIN_PRIORITY
 * @see        java.lang.ThreadGroup#getMaxPriority()
 * @apiSince 1
 */

public final void setPriority(int newPriority) { throw new RuntimeException("Stub!"); }

/**
 * Returns this thread's priority.
 *
 * @return  this thread's priority.
 * @see     #setPriority
 * @apiSince 1
 */

public final int getPriority() { throw new RuntimeException("Stub!"); }

/**
 * Changes the name of this thread to be equal to the argument
 * <code>name</code>.
 * <p>
 * First the <code>checkAccess</code> method of this thread is called
 * with no arguments. This may result in throwing a
 * <code>SecurityException</code>.
 *
 * @param      name   the new name for this thread.
 * @exception  java.lang.SecurityException  if the current thread cannot modify this
 *               thread.
 * @see        #getName
 * @see        #checkAccess()
 * @apiSince 1
 */

public final synchronized void setName(@androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns this thread's name.
 *
 * @return  this thread's name.
 * @see     #setName(String)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the thread group to which this thread belongs.
 * This method returns null if this thread has died
 * (been stopped).
 *
 * @return  this thread's thread group.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public final java.lang.ThreadGroup getThreadGroup() { throw new RuntimeException("Stub!"); }

/**
 * Returns an estimate of the number of active threads in the current
 * thread's {@linkplain java.lang.ThreadGroup thread group} and its
 * subgroups. Recursively iterates over all subgroups in the current
 * thread's thread group.
 *
 * <p> The value returned is only an estimate because the number of
 * threads may change dynamically while this method traverses internal
 * data structures, and might be affected by the presence of certain
 * system threads. This method is intended primarily for debugging
 * and monitoring purposes.
 *
 * @return  an estimate of the number of active threads in the current
 *          thread's thread group and in any other thread group that
 *          has the current thread's thread group as an ancestor
 * @apiSince 1
 */

public static int activeCount() { throw new RuntimeException("Stub!"); }

/**
 * Copies into the specified array every active thread in the current
 * thread's thread group and its subgroups. This method simply
 * invokes the {@link java.lang.ThreadGroup#enumerate(Thread[])}
 * method of the current thread's thread group.
 *
 * <p> An application might use the {@linkplain #activeCount activeCount}
 * method to get an estimate of how big the array should be, however
 * <i>if the array is too short to hold all the threads, the extra threads
 * are silently ignored.</i>  If it is critical to obtain every active
 * thread in the current thread's thread group and its subgroups, the
 * invoker should verify that the returned int value is strictly less
 * than the length of {@code tarray}.
 *
 * <p> Due to the inherent race condition in this method, it is recommended
 * that the method only be used for debugging and monitoring purposes.
 *
 * @param  tarray
 *         an array into which to put the list of threads
 *
 * @return  the number of threads put into the array
 *
 * @throws  java.lang.SecurityException
 *          if {@link java.lang.ThreadGroup#checkAccess} determines that
 *          the current thread cannot access its thread group
 * @apiSince 1
 */

public static int enumerate(java.lang.Thread[] tarray) { throw new RuntimeException("Stub!"); }

/**
 * Counts the number of stack frames in this thread. The thread must
 * be suspended.
 *
 * @return     the number of stack frames in this thread.
 * @exception  java.lang.IllegalThreadStateException  if this thread is not
 *             suspended.
 * @deprecated The definition of this call depends on {@link #suspend},
 *             which is deprecated.  Further, the results of this call
 *             were never well-defined.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public int countStackFrames() { throw new RuntimeException("Stub!"); }

/**
 * Waits at most {@code millis} milliseconds for this thread to
 * die. A timeout of {@code 0} means to wait forever.
 *
 * <p> This implementation uses a loop of {@code this.wait} calls
 * conditioned on {@code this.isAlive}. As a thread terminates the
 * {@code this.notifyAll} method is invoked. It is recommended that
 * applications not use {@code wait}, {@code notify}, or
 * {@code notifyAll} on {@code Thread} instances.
 *
 * @param  millis
 *         the time to wait in milliseconds
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the value of {@code millis} is negative
 *
 * @throws  java.lang.InterruptedException
 *          if any thread has interrupted the current thread. The
 *          <i>interrupted status</i> of the current thread is
 *          cleared when this exception is thrown.
 * @apiSince 1
 */

public final void join(long millis) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Waits at most {@code millis} milliseconds plus
 * {@code nanos} nanoseconds for this thread to die.
 *
 * <p> This implementation uses a loop of {@code this.wait} calls
 * conditioned on {@code this.isAlive}. As a thread terminates the
 * {@code this.notifyAll} method is invoked. It is recommended that
 * applications not use {@code wait}, {@code notify}, or
 * {@code notifyAll} on {@code Thread} instances.
 *
 * @param  millis
 *         the time to wait in milliseconds
 *
 * @param  nanos
 *         {@code 0-999999} additional nanoseconds to wait
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the value of {@code millis} is negative, or the value
 *          of {@code nanos} is not in the range {@code 0-999999}
 *
 * @throws  java.lang.InterruptedException
 *          if any thread has interrupted the current thread. The
 *          <i>interrupted status</i> of the current thread is
 *          cleared when this exception is thrown.
 * @apiSince 1
 */

public final void join(long millis, int nanos) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Waits for this thread to die.
 *
 * <p> An invocation of this method behaves in exactly the same
 * way as the invocation
 *
 * <blockquote>
 * {@linkplain #join(long) join}{@code (0)}
 * </blockquote>
 *
 * @throws  java.lang.InterruptedException
 *          if any thread has interrupted the current thread. The
 *          <i>interrupted status</i> of the current thread is
 *          cleared when this exception is thrown.
 * @apiSince 1
 */

public final void join() throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Prints a stack trace of the current thread to the standard error stream.
 * This method is used only for debugging.
 *
 * @see     java.lang.Throwable#printStackTrace()
 * @apiSince 1
 */

public static void dumpStack() { throw new RuntimeException("Stub!"); }

/**
 * Marks this thread as either a {@linkplain #isDaemon daemon} thread
 * or a user thread. The Java Virtual Machine exits when the only
 * threads running are all daemon threads.
 *
 * <p> This method must be invoked before the thread is started.
 *
 * @param  on
 *         if {@code true}, marks this thread as a daemon thread
 *
 * @throws  java.lang.IllegalThreadStateException
 *          if this thread is {@linkplain #isAlive alive}
 *
 * @throws  java.lang.SecurityException
 *          if {@link #checkAccess} determines that the current
 *          thread cannot modify this thread
 * @apiSince 1
 */

public final void setDaemon(boolean on) { throw new RuntimeException("Stub!"); }

/**
 * Tests if this thread is a daemon thread.
 *
 * @return  <code>true</code> if this thread is a daemon thread;
 *          <code>false</code> otherwise.
 * @see     #setDaemon(boolean)
 * @apiSince 1
 */

public final boolean isDaemon() { throw new RuntimeException("Stub!"); }

/**
 * Determines if the currently running thread has permission to
 * modify this thread.
 * <p>
 * If there is a security manager, its <code>checkAccess</code> method
 * is called with this thread as its argument. This may result in
 * throwing a <code>SecurityException</code>.
 *
 * @exception  java.lang.SecurityException  if the current thread is not allowed to
 *               access this thread.
 * @see        java.lang.SecurityManager#checkAccess(Thread)
 * @apiSince 1
 */

public final void checkAccess() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this thread, including the
 * thread's name, priority, and thread group.
 *
 * @return  a string representation of this thread.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the context ClassLoader for this Thread. The context
 * ClassLoader is provided by the creator of the thread for use
 * by code running in this thread when loading classes and resources.
 * If not {@linkplain #setContextClassLoader set}, the default is the
 * ClassLoader context of the parent Thread. The context ClassLoader of the
 * primordial thread is typically set to the class loader used to load the
 * application.
 *
 * <p>If a security manager is present, and the invoker's class loader is not
 * {@code null} and is not the same as or an ancestor of the context class
 * loader, then this method invokes the security manager's {@link java.lang.SecurityManager#checkPermission(java.security.Permission) SecurityManager#checkPermission(java.security.Permission)}
 * method with a {@link java.lang.RuntimePermission RuntimePermission}{@code
 * ("getClassLoader")} permission to verify that retrieval of the context
 * class loader is permitted.
 *
 * @return  the context ClassLoader for this Thread, or {@code null}
 *          indicating the system class loader (or, failing that, the
 *          bootstrap class loader)
 *
 * @throws  java.lang.SecurityException
 *          if the current thread cannot get the context ClassLoader
 *
 * @since 1.2
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.ClassLoader getContextClassLoader() { throw new RuntimeException("Stub!"); }

/**
 * Sets the context ClassLoader for this Thread. The context
 * ClassLoader can be set when a thread is created, and allows
 * the creator of the thread to provide the appropriate class loader,
 * through {@code getContextClassLoader}, to code running in the thread
 * when loading classes and resources.
 *
 * <p>If a security manager is present, its {@link java.lang.SecurityManager#checkPermission(java.security.Permission) SecurityManager#checkPermission(java.security.Permission)}
 * method is invoked with a {@link java.lang.RuntimePermission RuntimePermission}{@code
 * ("setContextClassLoader")} permission to see if setting the context
 * ClassLoader is permitted.
 *
 * @param  cl
 *         the context ClassLoader for this Thread, or null  indicating the
 *         system class loader (or, failing that, the bootstrap class loader)
 *
 * @throws  java.lang.SecurityException
 *          if the current thread cannot set the context ClassLoader
 *
 * @since 1.2
 * @apiSince 1
 */

public void setContextClassLoader(@androidx.annotation.Nullable java.lang.ClassLoader cl) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if and only if the current thread holds the
 * monitor lock on the specified object.
 *
 * <p>This method is designed to allow a program to assert that
 * the current thread already holds a specified lock:
 * <pre>
 *     assert Thread.holdsLock(obj);
 * </pre>
 *
 * @param  obj the object on which to test lock ownership
 * @throws java.lang.NullPointerException if obj is <tt>null</tt>
 * @return <tt>true</tt> if the current thread holds the monitor lock on
 *         the specified object.
 * @since 1.4
 * @apiSince 1
 */

public static native boolean holdsLock(@androidx.annotation.NonNull java.lang.Object obj);

/**
 * Returns an array of stack trace elements representing the stack dump
 * of this thread.  This method will return a zero-length array if
 * this thread has not started, has started but has not yet been
 * scheduled to run by the system, or has terminated.
 * If the returned array is of non-zero length then the first element of
 * the array represents the top of the stack, which is the most recent
 * method invocation in the sequence.  The last element of the array
 * represents the bottom of the stack, which is the least recent method
 * invocation in the sequence.
 *
 * <p>If there is a security manager, and this thread is not
 * the current thread, then the security manager's
 * <tt>checkPermission</tt> method is called with a
 * <tt>RuntimePermission("getStackTrace")</tt> permission
 * to see if it's ok to get the stack trace.
 *
 * <p>Some virtual machines may, under some circumstances, omit one
 * or more stack frames from the stack trace.  In the extreme case,
 * a virtual machine that has no stack trace information concerning
 * this thread is permitted to return a zero-length array from this
 * method.
 *
 * @return an array of <tt>StackTraceElement</tt>,
 * each represents one stack frame.
 *
 * @throws java.lang.SecurityException
 *        if a security manager exists and its
 *        <tt>checkPermission</tt> method doesn't allow
 *        getting the stack trace of thread.
 * @see SecurityManager#checkPermission
 * @see java.lang.RuntimePermission
 * @see java.lang.Throwable#getStackTrace
 *
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StackTraceElement[] getStackTrace() { throw new RuntimeException("Stub!"); }

/**
 * Returns a map of stack traces for all live threads.
 * The map keys are threads and each map value is an array of
 * <tt>StackTraceElement</tt> that represents the stack dump
 * of the corresponding <tt>Thread</tt>.
 * The returned stack traces are in the format specified for
 * the {@link #getStackTrace getStackTrace} method.
 *
 * <p>The threads may be executing while this method is called.
 * The stack trace of each thread only represents a snapshot and
 * each stack trace may be obtained at different time.  A zero-length
 * array will be returned in the map value if the virtual machine has
 * no stack trace information about a thread.
 *
 * <p>If there is a security manager, then the security manager's
 * <tt>checkPermission</tt> method is called with a
 * <tt>RuntimePermission("getStackTrace")</tt> permission as well as
 * <tt>RuntimePermission("modifyThreadGroup")</tt> permission
 * to see if it is ok to get the stack trace of all threads.
 *
 * @return a <tt>Map</tt> from <tt>Thread</tt> to an array of
 * <tt>StackTraceElement</tt> that represents the stack trace of
 * the corresponding thread.
 *
 * @throws java.lang.SecurityException
 *        if a security manager exists and its
 *        <tt>checkPermission</tt> method doesn't allow
 *        getting the stack trace of thread.
 * @see #getStackTrace
 * @see SecurityManager#checkPermission
 * @see java.lang.RuntimePermission
 * @see java.lang.Throwable#getStackTrace
 *
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.util.Map<java.lang.Thread,java.lang.StackTraceElement[]> getAllStackTraces() { throw new RuntimeException("Stub!"); }

/**
 * Returns the identifier of this Thread.  The thread ID is a positive
 * <tt>long</tt> number generated when this thread was created.
 * The thread ID is unique and remains unchanged during its lifetime.
 * When a thread is terminated, this thread ID may be reused.
 *
 * @return this thread's ID.
 * @since 1.5
 * @apiSince 1
 */

public long getId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the state of this thread.
 * This method is designed for use in monitoring of the system state,
 * not for synchronization control.
 *
 * @return this thread's state.
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.Thread.State getState() { throw new RuntimeException("Stub!"); }

/**
 * Set the default handler invoked when a thread abruptly terminates
 * due to an uncaught exception, and no other handler has been defined
 * for that thread.
 *
 * <p>Uncaught exception handling is controlled first by the thread, then
 * by the thread's {@link java.lang.ThreadGroup ThreadGroup} object and finally by the default
 * uncaught exception handler. If the thread does not have an explicit
 * uncaught exception handler set, and the thread's thread group
 * (including parent thread groups)  does not specialize its
 * <tt>uncaughtException</tt> method, then the default handler's
 * <tt>uncaughtException</tt> method will be invoked.
 * <p>By setting the default uncaught exception handler, an application
 * can change the way in which uncaught exceptions are handled (such as
 * logging to a specific device, or file) for those threads that would
 * already accept whatever &quot;default&quot; behavior the system
 * provided.
 *
 * <p>Note that the default uncaught exception handler should not usually
 * defer to the thread's <tt>ThreadGroup</tt> object, as that could cause
 * infinite recursion.
 *
 * @param eh the object to use as the default uncaught exception handler.
 * If <tt>null</tt> then there is no default handler.
 *
 * @throws java.lang.SecurityException if a security manager is present and it
 *         denies <tt>{@link java.lang.RuntimePermission RuntimePermission}
 *         (&quot;setDefaultUncaughtExceptionHandler&quot;)</tt>
 *
 * @see #setUncaughtExceptionHandler
 * @see #getUncaughtExceptionHandler
 * @see java.lang.ThreadGroup#uncaughtException
 * @since 1.5
 * @apiSince 1
 */

public static void setDefaultUncaughtExceptionHandler(@androidx.annotation.Nullable java.lang.Thread.UncaughtExceptionHandler eh) { throw new RuntimeException("Stub!"); }

/**
 * Returns the default handler invoked when a thread abruptly terminates
 * due to an uncaught exception. If the returned value is <tt>null</tt>,
 * there is no default.
 * @since 1.5
 * @see #setDefaultUncaughtExceptionHandler
 * @return the default uncaught exception handler for all threads
 * @apiSince 1
 */

@androidx.annotation.Nullable
public static java.lang.Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() { throw new RuntimeException("Stub!"); }

/**
 * Returns the handler invoked when this thread abruptly terminates
 * due to an uncaught exception. If this thread has not had an
 * uncaught exception handler explicitly set then this thread's
 * <tt>ThreadGroup</tt> object is returned, unless this thread
 * has terminated, in which case <tt>null</tt> is returned.
 * @since 1.5
 * @return the uncaught exception handler for this thread
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() { throw new RuntimeException("Stub!"); }

/**
 * Set the handler invoked when this thread abruptly terminates
 * due to an uncaught exception.
 * <p>A thread can take full control of how it responds to uncaught
 * exceptions by having its uncaught exception handler explicitly set.
 * If no such handler is set then the thread's <tt>ThreadGroup</tt>
 * object acts as its handler.
 * @param eh the object to use as this thread's uncaught exception
 * handler. If <tt>null</tt> then this thread has no explicit handler.
 * @throws  java.lang.SecurityException  if the current thread is not allowed to
 *          modify this thread.
 * @see #setDefaultUncaughtExceptionHandler
 * @see java.lang.ThreadGroup#uncaughtException
 * @since 1.5
 * @apiSince 1
 */

public void setUncaughtExceptionHandler(@androidx.annotation.Nullable java.lang.Thread.UncaughtExceptionHandler eh) { throw new RuntimeException("Stub!"); }

/**
 * The maximum priority that a thread can have.
 * @apiSince 1
 */

public static final int MAX_PRIORITY = 10; // 0xa

/**
 * The minimum priority that a thread can have.
 * @apiSince 1
 */

public static final int MIN_PRIORITY = 1; // 0x1

/**
 * The default priority that is assigned to a thread.
 * @apiSince 1
 */

public static final int NORM_PRIORITY = 5; // 0x5
/**
 * A thread state.  A thread can be in one of the following states:
 * <ul>
 * <li>{@link #NEW}<br>
 *     A thread that has not yet started is in this state.
 *     </li>
 * <li>{@link #RUNNABLE}<br>
 *     A thread executing in the Java virtual machine is in this state.
 *     </li>
 * <li>{@link #BLOCKED}<br>
 *     A thread that is blocked waiting for a monitor lock
 *     is in this state.
 *     </li>
 * <li>{@link #WAITING}<br>
 *     A thread that is waiting indefinitely for another thread to
 *     perform a particular action is in this state.
 *     </li>
 * <li>{@link #TIMED_WAITING}<br>
 *     A thread that is waiting for another thread to perform an action
 *     for up to a specified waiting time is in this state.
 *     </li>
 * <li>{@link #TERMINATED}<br>
 *     A thread that has exited is in this state.
 *     </li>
 * </ul>
 *
 * <p>
 * A thread can be in only one state at a given point in time.
 * These states are virtual machine states which do not reflect
 * any operating system thread states.
 *
 * @since   1.5
 * @see #getState
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum State {
/**
 * Thread state for a thread which has not yet started.
 * @apiSince 1
 */

NEW,
/**
 * Thread state for a runnable thread.  A thread in the runnable
 * state is executing in the Java virtual machine but it may
 * be waiting for other resources from the operating system
 * such as processor.
 * @apiSince 1
 */

RUNNABLE,
/**
 * Thread state for a thread blocked waiting for a monitor lock.
 * A thread in the blocked state is waiting for a monitor lock
 * to enter a synchronized block/method or
 * reenter a synchronized block/method after calling
 * {@link java.lang.Object#wait() Object#wait()}.
 * @apiSince 1
 */

BLOCKED,
/**
 * Thread state for a waiting thread.
 * A thread is in the waiting state due to calling one of the
 * following methods:
 * <ul>
 *   <li>{@link java.lang.Object#wait() Object#wait()} with no timeout</li>
 *   <li>{@link #join() Thread.join} with no timeout</li>
 *   <li>{@link java.util.concurrent.locks.LockSupport#park() LockSupport#park()}</li>
 * </ul>
 *
 * <p>A thread in the waiting state is waiting for another thread to
 * perform a particular action.
 *
 * For example, a thread that has called <tt>Object.wait()</tt>
 * on an object is waiting for another thread to call
 * <tt>Object.notify()</tt> or <tt>Object.notifyAll()</tt> on
 * that object. A thread that has called <tt>Thread.join()</tt>
 * is waiting for a specified thread to terminate.
 * @apiSince 1
 */

WAITING,
/**
 * Thread state for a waiting thread with a specified waiting time.
 * A thread is in the timed waiting state due to calling one of
 * the following methods with a specified positive waiting time:
 * <ul>
 *   <li>{@link #sleep Thread.sleep}</li>
 *   <li>{@link java.lang.Object#wait(long) Object#wait(long)} with timeout</li>
 *   <li>{@link #join(long) Thread.join} with timeout</li>
 *   <li>{@link java.util.concurrent.locks.LockSupport#parkNanos LockSupport#parkNanos}</li>
 *   <li>{@link java.util.concurrent.locks.LockSupport#parkUntil LockSupport#parkUntil}</li>
 * </ul>
 * @apiSince 1
 */

TIMED_WAITING,
/**
 * Thread state for a terminated thread.
 * The thread has completed execution.
 * @apiSince 1
 */

TERMINATED;
}

/**
 * Interface for handlers invoked when a <tt>Thread</tt> abruptly
 * terminates due to an uncaught exception.
 * <p>When a thread is about to terminate due to an uncaught exception
 * the Java Virtual Machine will query the thread for its
 * <tt>UncaughtExceptionHandler</tt> using
 * {@link #getUncaughtExceptionHandler} and will invoke the handler's
 * <tt>uncaughtException</tt> method, passing the thread and the
 * exception as arguments.
 * If a thread has not had its <tt>UncaughtExceptionHandler</tt>
 * explicitly set, then its <tt>ThreadGroup</tt> object acts as its
 * <tt>UncaughtExceptionHandler</tt>. If the <tt>ThreadGroup</tt> object
 * has no
 * special requirements for dealing with the exception, it can forward
 * the invocation to the {@linkplain #getDefaultUncaughtExceptionHandler
 * default uncaught exception handler}.
 *
 * @see #setDefaultUncaughtExceptionHandler
 * @see #setUncaughtExceptionHandler
 * @see java.lang.ThreadGroup#uncaughtException
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@java.lang.FunctionalInterface
public static interface UncaughtExceptionHandler {

/**
 * Method invoked when the given thread terminates due to the
 * given uncaught exception.
 * <p>Any exception thrown by this method will be ignored by the
 * Java Virtual Machine.
 * @param t the thread
 * @param e the exception
 * @apiSince 1
 */

public void uncaughtException(@androidx.annotation.NonNull java.lang.Thread t, @androidx.annotation.NonNull java.lang.Throwable e);
}

}

