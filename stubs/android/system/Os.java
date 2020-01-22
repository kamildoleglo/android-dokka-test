/*
 * Copyright (C) 2011 The Android Open Source Project
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



package android.system;


/**
 * Access to low-level system functionality. Most of these are system calls. Most users will want
 * to use higher-level APIs where available, but this class provides access to the underlying
 * primitives used to implement the higher-level APIs.
 *
 * <p>The corresponding constants can be found in {@link android.system.OsConstants OsConstants}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Os {

private Os() { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/accept.2.html">accept(2)</a>.
 * @apiSince 21
 */

public static java.io.FileDescriptor accept(java.io.FileDescriptor fd, java.net.InetSocketAddress peerAddress) throws android.system.ErrnoException, java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/access.2.html">access(2)</a>.
 * @apiSince 21
 */

public static boolean access(java.lang.String path, int mode) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/bind.2.html">bind(2)</a>.
 * @apiSince 21
 */

public static void bind(java.io.FileDescriptor fd, java.net.InetAddress address, int port) throws android.system.ErrnoException, java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/bind.2.html">bind(2)</a>.
 * @apiSince 29
 */

public static void bind(@androidx.annotation.NonNull java.io.FileDescriptor fd, @androidx.annotation.NonNull java.net.SocketAddress address) throws android.system.ErrnoException, java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/chmod.2.html">chmod(2)</a>.
 * @apiSince 21
 */

public static void chmod(java.lang.String path, int mode) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/chown.2.html">chown(2)</a>.
 * @apiSince 21
 */

public static void chown(java.lang.String path, int uid, int gid) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/close.2.html">close(2)</a>.
 * @apiSince 21
 */

public static void close(java.io.FileDescriptor fd) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/connect.2.html">connect(2)</a>.
 * @apiSince 21
 */

public static void connect(java.io.FileDescriptor fd, java.net.InetAddress address, int port) throws android.system.ErrnoException, java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/connect.2.html">connect(2)</a>.
 * @apiSince 29
 */

public static void connect(@androidx.annotation.NonNull java.io.FileDescriptor fd, @androidx.annotation.NonNull java.net.SocketAddress address) throws android.system.ErrnoException, java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/dup.2.html">dup(2)</a>.
 * @apiSince 21
 */

public static java.io.FileDescriptor dup(java.io.FileDescriptor oldFd) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/dup2.2.html">dup2(2)</a>.
 * @apiSince 21
 */

public static java.io.FileDescriptor dup2(java.io.FileDescriptor oldFd, int newFd) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/environ.3.html">environ(3)</a>.
 * @apiSince 21
 */

public static java.lang.String[] environ() { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/execv.2.html">execv(2)</a>.
 * @apiSince 21
 */

public static void execv(java.lang.String filename, java.lang.String[] argv) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/execve.2.html">execve(2)</a>.
 * @apiSince 21
 */

public static void execve(java.lang.String filename, java.lang.String[] argv, java.lang.String[] envp) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/fchmod.2.html">fchmod(2)</a>.
 * @apiSince 21
 */

public static void fchmod(java.io.FileDescriptor fd, int mode) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/fchown.2.html">fchown(2)</a>.
 * @apiSince 21
 */

public static void fchown(java.io.FileDescriptor fd, int uid, int gid) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/fcntl.2.html">fcntl(2)</a>.
 * @apiSince R
 */

public static int fcntlInt(@androidx.annotation.NonNull java.io.FileDescriptor fd, int cmd, int arg) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/fdatasync.2.html">fdatasync(2)</a>.
 * @apiSince 21
 */

public static void fdatasync(java.io.FileDescriptor fd) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/fstat.2.html">fstat(2)</a>.
 * @apiSince 21
 */

public static android.system.StructStat fstat(java.io.FileDescriptor fd) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/fstatvfs.2.html">fstatvfs(2)</a>.
 * @apiSince 21
 */

public static android.system.StructStatVfs fstatvfs(java.io.FileDescriptor fd) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/fsync.2.html">fsync(2)</a>.
 * @apiSince 21
 */

public static void fsync(java.io.FileDescriptor fd) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/ftruncate.2.html">ftruncate(2)</a>.
 * @apiSince 21
 */

public static void ftruncate(java.io.FileDescriptor fd, long length) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/gai_strerror.3.html">gai_strerror(3)</a>.
 * @apiSince 21
 */

public static java.lang.String gai_strerror(int error) { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/getegid.2.html">getegid(2)</a>.
 * @apiSince 21
 */

public static int getegid() { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/geteuid.2.html">geteuid(2)</a>.
 * @apiSince 21
 */

public static int geteuid() { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/getgid.2.html">getgid(2)</a>.
 * @apiSince 21
 */

public static int getgid() { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/getenv.3.html">getenv(3)</a>.
 * @apiSince 21
 */

public static java.lang.String getenv(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/getpeername.2.html">getpeername(2)</a>.
 * @apiSince 21
 */

public static java.net.SocketAddress getpeername(java.io.FileDescriptor fd) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/getpid.2.html">getpid(2)</a>.
 * @apiSince 21
 */

public static int getpid() { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/getppid.2.html">getppid(2)</a>.
 * @apiSince 21
 */

public static int getppid() { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/getsockname.2.html">getsockname(2)</a>.
 * @apiSince 21
 */

public static java.net.SocketAddress getsockname(java.io.FileDescriptor fd) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/setsockopt.2.html">getsockopt(2)</a>.
 *
 * <p>Only for use with {@code option} values that return a {@code struct timeval} such as
 * {@link android.system.OsConstants#SO_RCVTIMEO OsConstants#SO_RCVTIMEO} and {@link android.system.OsConstants#SO_SNDTIMEO OsConstants#SO_SNDTIMEO}. Use with other
 * options may throw an {@code IllegalArgumentException} or return junk values.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.system.StructTimeval getsockoptTimeval(@androidx.annotation.NonNull java.io.FileDescriptor fd, int level, int option) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/gettid.2.html">gettid(2)</a>.
 * @apiSince 21
 */

public static int gettid() { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/getuid.2.html">getuid(2)</a>.
 * @apiSince 21
 */

public static int getuid() { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/getxattr.2.html">getxattr(2)</a>
 * @apiSince 26
 */

public static byte[] getxattr(java.lang.String path, java.lang.String name) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/if_indextoname.3.html">if_indextoname(3)</a>.
 * @apiSince 21
 */

public static java.lang.String if_indextoname(int index) { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/if_nametoindex.3.html">if_nametoindex(3)</a>.
 * @apiSince 26
 */

public static int if_nametoindex(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/inet_pton.3.html">inet_pton(3)</a>.
 * @apiSince 21
 */

public static java.net.InetAddress inet_pton(int family, java.lang.String address) { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/isatty.3.html">isatty(3)</a>.
 * @apiSince 21
 */

public static boolean isatty(java.io.FileDescriptor fd) { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/kill.2.html">kill(2)</a>.
 * @apiSince 21
 */

public static void kill(int pid, int signal) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/lchown.2.html">lchown(2)</a>.
 * @apiSince 21
 */

public static void lchown(java.lang.String path, int uid, int gid) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/link.2.html">link(2)</a>.
 * @apiSince 21
 */

public static void link(java.lang.String oldPath, java.lang.String newPath) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/listen.2.html">listen(2)</a>.
 * @apiSince 21
 */

public static void listen(java.io.FileDescriptor fd, int backlog) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/listxattr.2.html">listxattr(2)</a>
 * @apiSince 26
 */

public static java.lang.String[] listxattr(java.lang.String path) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/lseek.2.html">lseek(2)</a>.
 * @apiSince 21
 */

public static long lseek(java.io.FileDescriptor fd, long offset, int whence) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/lstat.2.html">lstat(2)</a>.
 * @apiSince 21
 */

public static android.system.StructStat lstat(java.lang.String path) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/memfd_create.2.html">memfd_create(2)</a>.
 * @apiSince R
 */

@androidx.annotation.NonNull
public static java.io.FileDescriptor memfd_create(@androidx.annotation.NonNull java.lang.String name, int flags) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/mincore.2.html">mincore(2)</a>.
 * @apiSince 21
 */

public static void mincore(long address, long byteCount, byte[] vector) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/mkdir.2.html">mkdir(2)</a>.
 * @apiSince 21
 */

public static void mkdir(java.lang.String path, int mode) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/mkfifo.3.html">mkfifo(3)</a>.
 * @apiSince 21
 */

public static void mkfifo(java.lang.String path, int mode) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/mlock.2.html">mlock(2)</a>.
 * @apiSince 21
 */

public static void mlock(long address, long byteCount) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/mmap.2.html">mmap(2)</a>.
 * @apiSince 21
 */

public static long mmap(long address, long byteCount, int prot, int flags, java.io.FileDescriptor fd, long offset) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/msync.2.html">msync(2)</a>.
 * @apiSince 21
 */

public static void msync(long address, long byteCount, int flags) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/munlock.2.html">munlock(2)</a>.
 * @apiSince 21
 */

public static void munlock(long address, long byteCount) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/munmap.2.html">munmap(2)</a>.
 * @apiSince 21
 */

public static void munmap(long address, long byteCount) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/open.2.html">open(2)</a>.
 * @apiSince 21
 */

public static java.io.FileDescriptor open(java.lang.String path, int flags, int mode) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/pipe.2.html">pipe(2)</a>.
 * @apiSince 21
 */

public static java.io.FileDescriptor[] pipe() throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/poll.2.html">poll(2)</a>.
 *
 * <p>Note that in Lollipop this could throw an {@code ErrnoException} with {@code EINTR}.
 * In later releases, the implementation will automatically just restart the system call with
 * an appropriately reduced timeout.
 * @apiSince 21
 */

public static int poll(android.system.StructPollfd[] fds, int timeoutMs) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/posix_fallocate.3.html">posix_fallocate(3)</a>.
 * @apiSince 21
 */

public static void posix_fallocate(java.io.FileDescriptor fd, long offset, long length) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/prctl.2.html">prctl(2)</a>.
 * @apiSince 21
 */

public static int prctl(int option, long arg2, long arg3, long arg4, long arg5) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/pread.2.html">pread(2)</a>.
 * @apiSince 21
 */

public static int pread(java.io.FileDescriptor fd, java.nio.ByteBuffer buffer, long offset) throws android.system.ErrnoException, java.io.InterruptedIOException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/pread.2.html">pread(2)</a>.
 * @apiSince 21
 */

public static int pread(java.io.FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws android.system.ErrnoException, java.io.InterruptedIOException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/pwrite.2.html">pwrite(2)</a>.
 * @apiSince 21
 */

public static int pwrite(java.io.FileDescriptor fd, java.nio.ByteBuffer buffer, long offset) throws android.system.ErrnoException, java.io.InterruptedIOException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/pwrite.2.html">pwrite(2)</a>.
 * @apiSince 21
 */

public static int pwrite(java.io.FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws android.system.ErrnoException, java.io.InterruptedIOException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/read.2.html">read(2)</a>.
 * @apiSince 21
 */

public static int read(java.io.FileDescriptor fd, java.nio.ByteBuffer buffer) throws android.system.ErrnoException, java.io.InterruptedIOException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/read.2.html">read(2)</a>.
 * @apiSince 21
 */

public static int read(java.io.FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws android.system.ErrnoException, java.io.InterruptedIOException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/readlink.2.html">readlink(2)</a>.
 * @apiSince 21
 */

public static java.lang.String readlink(java.lang.String path) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/readv.2.html">readv(2)</a>.
 * @apiSince 21
 */

public static int readv(java.io.FileDescriptor fd, java.lang.Object[] buffers, int[] offsets, int[] byteCounts) throws android.system.ErrnoException, java.io.InterruptedIOException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/recvfrom.2.html">recvfrom(2)</a>.
 * @apiSince 21
 */

public static int recvfrom(java.io.FileDescriptor fd, java.nio.ByteBuffer buffer, int flags, java.net.InetSocketAddress srcAddress) throws android.system.ErrnoException, java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/recvfrom.2.html">recvfrom(2)</a>.
 * @apiSince 21
 */

public static int recvfrom(java.io.FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, java.net.InetSocketAddress srcAddress) throws android.system.ErrnoException, java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/remove.3.html">remove(3)</a>.
 * @apiSince 21
 */

public static void remove(java.lang.String path) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/removexattr.2.html">removexattr(2)</a>.
 * @apiSince 26
 */

public static void removexattr(java.lang.String path, java.lang.String name) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/rename.2.html">rename(2)</a>.
 * @apiSince 21
 */

public static void rename(java.lang.String oldPath, java.lang.String newPath) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/sendfile.2.html">sendfile(2)</a>.
 * @apiSince 28
 */

public static long sendfile(java.io.FileDescriptor outFd, java.io.FileDescriptor inFd, android.system.Int64Ref offset, long byteCount) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/sendto.2.html">sendto(2)</a>.
 * @apiSince 21
 */

public static int sendto(java.io.FileDescriptor fd, java.nio.ByteBuffer buffer, int flags, java.net.InetAddress inetAddress, int port) throws android.system.ErrnoException, java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/sendto.2.html">sendto(2)</a>.
 * @apiSince 21
 */

public static int sendto(java.io.FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, java.net.InetAddress inetAddress, int port) throws android.system.ErrnoException, java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/sendto.2.html">sendto(2)</a>.
 * @apiSince 29
 */

public static int sendto(@androidx.annotation.NonNull java.io.FileDescriptor fd, @androidx.annotation.NonNull byte[] bytes, int byteOffset, int byteCount, int flags, @androidx.annotation.Nullable java.net.SocketAddress address) throws android.system.ErrnoException, java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/setegid.2.html">setegid(2)</a>.
 * @deprecated Android Applications do not have sufficient privileges to call this method.
 * @apiSince 21
 * @deprecatedSince 29
 */

@Deprecated
public static void setegid(int egid) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/setenv.3.html">setenv(3)</a>.
 * @apiSince 21
 */

public static void setenv(java.lang.String name, java.lang.String value, boolean overwrite) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/seteuid.2.html">seteuid(2)</a>.
 * @deprecated Android Applications do not have sufficient privileges to call this method.
 * @apiSince 21
 * @deprecatedSince 29
 */

@Deprecated
public static void seteuid(int euid) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/setgid.2.html">setgid(2)</a>.
 * @deprecated Android Applications do not have sufficient privileges to call this method.
 * @apiSince 21
 * @deprecatedSince 29
 */

@Deprecated
public static void setgid(int gid) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/setsid.2.html">setsid(2)</a>.
 * @apiSince 21
 */

public static int setsid() throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/setsockopt.2.html">setsockopt(2)</a>.
 * @apiSince 26
 */

public static void setsockoptInt(java.io.FileDescriptor fd, int level, int option, int value) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/setsockopt.2.html">setsockopt(2)</a>.
 *
 * <p>Only for use with {@code option} values that take a {@code struct timeval} such as
 * {@link android.system.OsConstants#SO_RCVTIMEO OsConstants#SO_RCVTIMEO} and {@link android.system.OsConstants#SO_SNDTIMEO OsConstants#SO_SNDTIMEO}. Use with other
 * options is likely to cause incorrect behavior.
 * @apiSince 29
 */

public static void setsockoptTimeval(@androidx.annotation.NonNull java.io.FileDescriptor fd, int level, int option, @androidx.annotation.NonNull android.system.StructTimeval value) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/setuid.2.html">setuid(2)</a>.
 * @deprecated Android Applications do not have sufficient privileges to call this method.
 * @apiSince 21
 * @deprecatedSince 29
 */

@Deprecated
public static void setuid(int uid) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/setxattr.2.html">setxattr(2)</a>
 * @apiSince 26
 */

public static void setxattr(java.lang.String path, java.lang.String name, byte[] value, int flags) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/shutdown.2.html">shutdown(2)</a>.
 * @apiSince 21
 */

public static void shutdown(java.io.FileDescriptor fd, int how) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/socket.2.html">socket(2)</a>.
 * @apiSince 21
 */

public static java.io.FileDescriptor socket(int domain, int type, int protocol) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/socketpair.2.html">socketpair(2)</a>.
 * @apiSince 21
 */

public static void socketpair(int domain, int type, int protocol, java.io.FileDescriptor fd1, java.io.FileDescriptor fd2) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/stat.2.html">stat(2)</a>.
 * @apiSince 21
 */

public static android.system.StructStat stat(java.lang.String path) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/statvfs.2.html">statvfs(2)</a>.
 * @apiSince 21
 */

public static android.system.StructStatVfs statvfs(java.lang.String path) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/strerror.3.html">strerror(2)</a>.
 * @apiSince 21
 */

public static java.lang.String strerror(int errno) { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/strsignal.3.html">strsignal(3)</a>.
 * @apiSince 21
 */

public static java.lang.String strsignal(int signal) { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/symlink.2.html">symlink(2)</a>.
 * @apiSince 21
 */

public static void symlink(java.lang.String oldPath, java.lang.String newPath) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/sysconf.3.html">sysconf(3)</a>.
 * @apiSince 21
 */

public static long sysconf(int name) { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/tcdrain.3.html">tcdrain(3)</a>.
 * @apiSince 21
 */

public static void tcdrain(java.io.FileDescriptor fd) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/tcsendbreak.3.html">tcsendbreak(3)</a>.
 * @apiSince 21
 */

public static void tcsendbreak(java.io.FileDescriptor fd, int duration) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/umask.2.html">umask(2)</a>.
 * @apiSince 21
 */

public static int umask(int mask) { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/uname.2.html">uname(2)</a>.
 * @apiSince 21
 */

public static android.system.StructUtsname uname() { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man3/unsetenv.3.html">unsetenv(3)</a>.
 * @apiSince 21
 */

public static void unsetenv(java.lang.String name) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/write.2.html">write(2)</a>.
 * @apiSince 21
 */

public static int write(java.io.FileDescriptor fd, java.nio.ByteBuffer buffer) throws android.system.ErrnoException, java.io.InterruptedIOException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/write.2.html">write(2)</a>.
 * @apiSince 21
 */

public static int write(java.io.FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws android.system.ErrnoException, java.io.InterruptedIOException { throw new RuntimeException("Stub!"); }

/**
 * See <a href="http://man7.org/linux/man-pages/man2/writev.2.html">writev(2)</a>.
 * @apiSince 21
 */

public static int writev(java.io.FileDescriptor fd, java.lang.Object[] buffers, int[] offsets, int[] byteCounts) throws android.system.ErrnoException, java.io.InterruptedIOException { throw new RuntimeException("Stub!"); }
}

