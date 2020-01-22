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
 * Constants and helper functions for use with {@link android.system.Os Os}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class OsConstants {

private OsConstants() { throw new RuntimeException("Stub!"); }

/**
 * Tests whether the given mode is a block device.
 * @apiSince 21
 */

public static boolean S_ISBLK(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether the given mode is a character device.
 * @apiSince 21
 */

public static boolean S_ISCHR(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether the given mode is a directory.
 * @apiSince 21
 */

public static boolean S_ISDIR(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether the given mode is a FIFO.
 * @apiSince 21
 */

public static boolean S_ISFIFO(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether the given mode is a regular file.
 * @apiSince 21
 */

public static boolean S_ISREG(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether the given mode is a symbolic link.
 * @apiSince 21
 */

public static boolean S_ISLNK(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether the given mode is a socket.
 * @apiSince 21
 */

public static boolean S_ISSOCK(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Extracts the exit status of a child. Only valid if WIFEXITED returns true.
 * @apiSince 21
 */

public static int WEXITSTATUS(int status) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether the child dumped core. Only valid if WIFSIGNALED returns true.
 * @apiSince 21
 */

public static boolean WCOREDUMP(int status) { throw new RuntimeException("Stub!"); }

/**
 * Returns the signal that caused the child to exit. Only valid if WIFSIGNALED returns true.
 * @apiSince 21
 */

public static int WTERMSIG(int status) { throw new RuntimeException("Stub!"); }

/**
 * Returns the signal that cause the child to stop. Only valid if WIFSTOPPED returns true.
 * @apiSince 21
 */

public static int WSTOPSIG(int status) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether the child exited normally.
 * @apiSince 21
 */

public static boolean WIFEXITED(int status) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether the child was stopped (not terminated) by a signal.
 * @apiSince 21
 */

public static boolean WIFSTOPPED(int status) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether the child was terminated by a signal.
 * @apiSince 21
 */

public static boolean WIFSIGNALED(int status) { throw new RuntimeException("Stub!"); }

/**
 * Returns the string name of a getaddrinfo(3) error value.
 * For example, "EAI_AGAIN".
 * @apiSince 21
 */

public static java.lang.String gaiName(int error) { throw new RuntimeException("Stub!"); }

/**
 * Returns the string name of an errno value.
 * For example, "EACCES". See {@link android.system.Os#strerror Os#strerror} for human-readable errno descriptions.
 * @apiSince 21
 */

public static java.lang.String errnoName(int errno) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public static final int AF_INET;
static { AF_INET = 0; }

/** @apiSince 21 */

public static final int AF_INET6;
static { AF_INET6 = 0; }

/** @apiSince 29 */

public static final int AF_NETLINK;
static { AF_NETLINK = 0; }

/** @apiSince 29 */

public static final int AF_PACKET;
static { AF_PACKET = 0; }

/** @apiSince 21 */

public static final int AF_UNIX;
static { AF_UNIX = 0; }

/** @apiSince 21 */

public static final int AF_UNSPEC;
static { AF_UNSPEC = 0; }

/** @apiSince 21 */

public static final int AI_ADDRCONFIG;
static { AI_ADDRCONFIG = 0; }

/** @apiSince 21 */

public static final int AI_ALL;
static { AI_ALL = 0; }

/** @apiSince 21 */

public static final int AI_CANONNAME;
static { AI_CANONNAME = 0; }

/** @apiSince 21 */

public static final int AI_NUMERICHOST;
static { AI_NUMERICHOST = 0; }

/** @apiSince 21 */

public static final int AI_NUMERICSERV;
static { AI_NUMERICSERV = 0; }

/** @apiSince 21 */

public static final int AI_PASSIVE;
static { AI_PASSIVE = 0; }

/** @apiSince 21 */

public static final int AI_V4MAPPED;
static { AI_V4MAPPED = 0; }

/** @apiSince 29 */

public static final int ARPHRD_ETHER;
static { ARPHRD_ETHER = 0; }

/** @apiSince 21 */

public static final int CAP_AUDIT_CONTROL;
static { CAP_AUDIT_CONTROL = 0; }

/** @apiSince 21 */

public static final int CAP_AUDIT_WRITE;
static { CAP_AUDIT_WRITE = 0; }

/** @apiSince 21 */

public static final int CAP_BLOCK_SUSPEND;
static { CAP_BLOCK_SUSPEND = 0; }

/** @apiSince 21 */

public static final int CAP_CHOWN;
static { CAP_CHOWN = 0; }

/** @apiSince 21 */

public static final int CAP_DAC_OVERRIDE;
static { CAP_DAC_OVERRIDE = 0; }

/** @apiSince 21 */

public static final int CAP_DAC_READ_SEARCH;
static { CAP_DAC_READ_SEARCH = 0; }

/** @apiSince 21 */

public static final int CAP_FOWNER;
static { CAP_FOWNER = 0; }

/** @apiSince 21 */

public static final int CAP_FSETID;
static { CAP_FSETID = 0; }

/** @apiSince 21 */

public static final int CAP_IPC_LOCK;
static { CAP_IPC_LOCK = 0; }

/** @apiSince 21 */

public static final int CAP_IPC_OWNER;
static { CAP_IPC_OWNER = 0; }

/** @apiSince 21 */

public static final int CAP_KILL;
static { CAP_KILL = 0; }

/** @apiSince 21 */

public static final int CAP_LAST_CAP;
static { CAP_LAST_CAP = 0; }

/** @apiSince 21 */

public static final int CAP_LEASE;
static { CAP_LEASE = 0; }

/** @apiSince 21 */

public static final int CAP_LINUX_IMMUTABLE;
static { CAP_LINUX_IMMUTABLE = 0; }

/** @apiSince 21 */

public static final int CAP_MAC_ADMIN;
static { CAP_MAC_ADMIN = 0; }

/** @apiSince 21 */

public static final int CAP_MAC_OVERRIDE;
static { CAP_MAC_OVERRIDE = 0; }

/** @apiSince 21 */

public static final int CAP_MKNOD;
static { CAP_MKNOD = 0; }

/** @apiSince 21 */

public static final int CAP_NET_ADMIN;
static { CAP_NET_ADMIN = 0; }

/** @apiSince 21 */

public static final int CAP_NET_BIND_SERVICE;
static { CAP_NET_BIND_SERVICE = 0; }

/** @apiSince 21 */

public static final int CAP_NET_BROADCAST;
static { CAP_NET_BROADCAST = 0; }

/** @apiSince 21 */

public static final int CAP_NET_RAW;
static { CAP_NET_RAW = 0; }

/** @apiSince 21 */

public static final int CAP_SETFCAP;
static { CAP_SETFCAP = 0; }

/** @apiSince 21 */

public static final int CAP_SETGID;
static { CAP_SETGID = 0; }

/** @apiSince 21 */

public static final int CAP_SETPCAP;
static { CAP_SETPCAP = 0; }

/** @apiSince 21 */

public static final int CAP_SETUID;
static { CAP_SETUID = 0; }

/** @apiSince 21 */

public static final int CAP_SYSLOG;
static { CAP_SYSLOG = 0; }

/** @apiSince 21 */

public static final int CAP_SYS_ADMIN;
static { CAP_SYS_ADMIN = 0; }

/** @apiSince 21 */

public static final int CAP_SYS_BOOT;
static { CAP_SYS_BOOT = 0; }

/** @apiSince 21 */

public static final int CAP_SYS_CHROOT;
static { CAP_SYS_CHROOT = 0; }

/** @apiSince 21 */

public static final int CAP_SYS_MODULE;
static { CAP_SYS_MODULE = 0; }

/** @apiSince 21 */

public static final int CAP_SYS_NICE;
static { CAP_SYS_NICE = 0; }

/** @apiSince 21 */

public static final int CAP_SYS_PACCT;
static { CAP_SYS_PACCT = 0; }

/** @apiSince 21 */

public static final int CAP_SYS_PTRACE;
static { CAP_SYS_PTRACE = 0; }

/** @apiSince 21 */

public static final int CAP_SYS_RAWIO;
static { CAP_SYS_RAWIO = 0; }

/** @apiSince 21 */

public static final int CAP_SYS_RESOURCE;
static { CAP_SYS_RESOURCE = 0; }

/** @apiSince 21 */

public static final int CAP_SYS_TIME;
static { CAP_SYS_TIME = 0; }

/** @apiSince 21 */

public static final int CAP_SYS_TTY_CONFIG;
static { CAP_SYS_TTY_CONFIG = 0; }

/** @apiSince 21 */

public static final int CAP_WAKE_ALARM;
static { CAP_WAKE_ALARM = 0; }

/** @apiSince 21 */

public static final int E2BIG;
static { E2BIG = 0; }

/** @apiSince 21 */

public static final int EACCES;
static { EACCES = 0; }

/** @apiSince 21 */

public static final int EADDRINUSE;
static { EADDRINUSE = 0; }

/** @apiSince 21 */

public static final int EADDRNOTAVAIL;
static { EADDRNOTAVAIL = 0; }

/** @apiSince 21 */

public static final int EAFNOSUPPORT;
static { EAFNOSUPPORT = 0; }

/** @apiSince 21 */

public static final int EAGAIN;
static { EAGAIN = 0; }

/** @apiSince 21 */

public static final int EAI_AGAIN;
static { EAI_AGAIN = 0; }

/** @apiSince 21 */

public static final int EAI_BADFLAGS;
static { EAI_BADFLAGS = 0; }

/** @apiSince 21 */

public static final int EAI_FAIL;
static { EAI_FAIL = 0; }

/** @apiSince 21 */

public static final int EAI_FAMILY;
static { EAI_FAMILY = 0; }

/** @apiSince 21 */

public static final int EAI_MEMORY;
static { EAI_MEMORY = 0; }

/** @apiSince 21 */

public static final int EAI_NODATA;
static { EAI_NODATA = 0; }

/** @apiSince 21 */

public static final int EAI_NONAME;
static { EAI_NONAME = 0; }

/** @apiSince 21 */

public static final int EAI_OVERFLOW;
static { EAI_OVERFLOW = 0; }

/** @apiSince 21 */

public static final int EAI_SERVICE;
static { EAI_SERVICE = 0; }

/** @apiSince 21 */

public static final int EAI_SOCKTYPE;
static { EAI_SOCKTYPE = 0; }

/** @apiSince 21 */

public static final int EAI_SYSTEM;
static { EAI_SYSTEM = 0; }

/** @apiSince 21 */

public static final int EALREADY;
static { EALREADY = 0; }

/** @apiSince 21 */

public static final int EBADF;
static { EBADF = 0; }

/** @apiSince 21 */

public static final int EBADMSG;
static { EBADMSG = 0; }

/** @apiSince 21 */

public static final int EBUSY;
static { EBUSY = 0; }

/** @apiSince 21 */

public static final int ECANCELED;
static { ECANCELED = 0; }

/** @apiSince 21 */

public static final int ECHILD;
static { ECHILD = 0; }

/** @apiSince 21 */

public static final int ECONNABORTED;
static { ECONNABORTED = 0; }

/** @apiSince 21 */

public static final int ECONNREFUSED;
static { ECONNREFUSED = 0; }

/** @apiSince 21 */

public static final int ECONNRESET;
static { ECONNRESET = 0; }

/** @apiSince 21 */

public static final int EDEADLK;
static { EDEADLK = 0; }

/** @apiSince 21 */

public static final int EDESTADDRREQ;
static { EDESTADDRREQ = 0; }

/** @apiSince 21 */

public static final int EDOM;
static { EDOM = 0; }

/** @apiSince 21 */

public static final int EDQUOT;
static { EDQUOT = 0; }

/** @apiSince 21 */

public static final int EEXIST;
static { EEXIST = 0; }

/** @apiSince 21 */

public static final int EFAULT;
static { EFAULT = 0; }

/** @apiSince 21 */

public static final int EFBIG;
static { EFBIG = 0; }

/** @apiSince 21 */

public static final int EHOSTUNREACH;
static { EHOSTUNREACH = 0; }

/** @apiSince 21 */

public static final int EIDRM;
static { EIDRM = 0; }

/** @apiSince 21 */

public static final int EILSEQ;
static { EILSEQ = 0; }

/** @apiSince 21 */

public static final int EINPROGRESS;
static { EINPROGRESS = 0; }

/** @apiSince 21 */

public static final int EINTR;
static { EINTR = 0; }

/** @apiSince 21 */

public static final int EINVAL;
static { EINVAL = 0; }

/** @apiSince 21 */

public static final int EIO;
static { EIO = 0; }

/** @apiSince 21 */

public static final int EISCONN;
static { EISCONN = 0; }

/** @apiSince 21 */

public static final int EISDIR;
static { EISDIR = 0; }

/** @apiSince 21 */

public static final int ELOOP;
static { ELOOP = 0; }

/** @apiSince 21 */

public static final int EMFILE;
static { EMFILE = 0; }

/** @apiSince 21 */

public static final int EMLINK;
static { EMLINK = 0; }

/** @apiSince 21 */

public static final int EMSGSIZE;
static { EMSGSIZE = 0; }

/** @apiSince 21 */

public static final int EMULTIHOP;
static { EMULTIHOP = 0; }

/** @apiSince 21 */

public static final int ENAMETOOLONG;
static { ENAMETOOLONG = 0; }

/** @apiSince 21 */

public static final int ENETDOWN;
static { ENETDOWN = 0; }

/** @apiSince 21 */

public static final int ENETRESET;
static { ENETRESET = 0; }

/** @apiSince 21 */

public static final int ENETUNREACH;
static { ENETUNREACH = 0; }

/** @apiSince 21 */

public static final int ENFILE;
static { ENFILE = 0; }

/** @apiSince 21 */

public static final int ENOBUFS;
static { ENOBUFS = 0; }

/** @apiSince 21 */

public static final int ENODATA;
static { ENODATA = 0; }

/** @apiSince 21 */

public static final int ENODEV;
static { ENODEV = 0; }

/** @apiSince 21 */

public static final int ENOENT;
static { ENOENT = 0; }

/** @apiSince 21 */

public static final int ENOEXEC;
static { ENOEXEC = 0; }

/** @apiSince 21 */

public static final int ENOLCK;
static { ENOLCK = 0; }

/** @apiSince 21 */

public static final int ENOLINK;
static { ENOLINK = 0; }

/** @apiSince 21 */

public static final int ENOMEM;
static { ENOMEM = 0; }

/** @apiSince 21 */

public static final int ENOMSG;
static { ENOMSG = 0; }

/** @apiSince 21 */

public static final int ENOPROTOOPT;
static { ENOPROTOOPT = 0; }

/** @apiSince 21 */

public static final int ENOSPC;
static { ENOSPC = 0; }

/** @apiSince 21 */

public static final int ENOSR;
static { ENOSR = 0; }

/** @apiSince 21 */

public static final int ENOSTR;
static { ENOSTR = 0; }

/** @apiSince 21 */

public static final int ENOSYS;
static { ENOSYS = 0; }

/** @apiSince 21 */

public static final int ENOTCONN;
static { ENOTCONN = 0; }

/** @apiSince 21 */

public static final int ENOTDIR;
static { ENOTDIR = 0; }

/** @apiSince 21 */

public static final int ENOTEMPTY;
static { ENOTEMPTY = 0; }

/** @apiSince 21 */

public static final int ENOTSOCK;
static { ENOTSOCK = 0; }

/** @apiSince 21 */

public static final int ENOTSUP;
static { ENOTSUP = 0; }

/** @apiSince 21 */

public static final int ENOTTY;
static { ENOTTY = 0; }

/** @apiSince 21 */

public static final int ENXIO;
static { ENXIO = 0; }

/** @apiSince 21 */

public static final int EOPNOTSUPP;
static { EOPNOTSUPP = 0; }

/** @apiSince 21 */

public static final int EOVERFLOW;
static { EOVERFLOW = 0; }

/** @apiSince 21 */

public static final int EPERM;
static { EPERM = 0; }

/** @apiSince 21 */

public static final int EPIPE;
static { EPIPE = 0; }

/** @apiSince 21 */

public static final int EPROTO;
static { EPROTO = 0; }

/** @apiSince 21 */

public static final int EPROTONOSUPPORT;
static { EPROTONOSUPPORT = 0; }

/** @apiSince 21 */

public static final int EPROTOTYPE;
static { EPROTOTYPE = 0; }

/** @apiSince 21 */

public static final int ERANGE;
static { ERANGE = 0; }

/** @apiSince 21 */

public static final int EROFS;
static { EROFS = 0; }

/** @apiSince 21 */

public static final int ESPIPE;
static { ESPIPE = 0; }

/** @apiSince 21 */

public static final int ESRCH;
static { ESRCH = 0; }

/** @apiSince 21 */

public static final int ESTALE;
static { ESTALE = 0; }

/** @apiSince 29 */

public static final int ETH_P_ALL;
static { ETH_P_ALL = 0; }

/** @apiSince 29 */

public static final int ETH_P_ARP;
static { ETH_P_ARP = 0; }

/** @apiSince 29 */

public static final int ETH_P_IP;
static { ETH_P_IP = 0; }

/** @apiSince 29 */

public static final int ETH_P_IPV6;
static { ETH_P_IPV6 = 0; }

/** @apiSince 21 */

public static final int ETIME;
static { ETIME = 0; }

/** @apiSince 21 */

public static final int ETIMEDOUT;
static { ETIMEDOUT = 0; }

/** @apiSince 21 */

public static final int ETXTBSY;
static { ETXTBSY = 0; }

/** @apiSince 21 */

public static final int EXDEV;
static { EXDEV = 0; }

/** @apiSince 21 */

public static final int EXIT_FAILURE;
static { EXIT_FAILURE = 0; }

/** @apiSince 21 */

public static final int EXIT_SUCCESS;
static { EXIT_SUCCESS = 0; }

/** @apiSince 21 */

public static final int FD_CLOEXEC;
static { FD_CLOEXEC = 0; }

/** @apiSince 21 */

public static final int FIONREAD;
static { FIONREAD = 0; }

/** @apiSince 21 */

public static final int F_DUPFD;
static { F_DUPFD = 0; }

/** @apiSince 27 */

public static final int F_DUPFD_CLOEXEC;
static { F_DUPFD_CLOEXEC = 0; }

/** @apiSince 21 */

public static final int F_GETFD;
static { F_GETFD = 0; }

/** @apiSince 21 */

public static final int F_GETFL;
static { F_GETFL = 0; }

/** @apiSince 21 */

public static final int F_GETLK;
static { F_GETLK = 0; }

/** @apiSince 21 */

public static final int F_GETLK64;
static { F_GETLK64 = 0; }

/** @apiSince 21 */

public static final int F_GETOWN;
static { F_GETOWN = 0; }

/** @apiSince 21 */

public static final int F_OK;
static { F_OK = 0; }

/** @apiSince 21 */

public static final int F_RDLCK;
static { F_RDLCK = 0; }

/** @apiSince 21 */

public static final int F_SETFD;
static { F_SETFD = 0; }

/** @apiSince 21 */

public static final int F_SETFL;
static { F_SETFL = 0; }

/** @apiSince 21 */

public static final int F_SETLK;
static { F_SETLK = 0; }

/** @apiSince 21 */

public static final int F_SETLK64;
static { F_SETLK64 = 0; }

/** @apiSince 21 */

public static final int F_SETLKW;
static { F_SETLKW = 0; }

/** @apiSince 21 */

public static final int F_SETLKW64;
static { F_SETLKW64 = 0; }

/** @apiSince 21 */

public static final int F_SETOWN;
static { F_SETOWN = 0; }

/** @apiSince 21 */

public static final int F_UNLCK;
static { F_UNLCK = 0; }

/** @apiSince 21 */

public static final int F_WRLCK;
static { F_WRLCK = 0; }

/** @apiSince 29 */

public static final int ICMP6_ECHO_REPLY;
static { ICMP6_ECHO_REPLY = 0; }

/** @apiSince 29 */

public static final int ICMP6_ECHO_REQUEST;
static { ICMP6_ECHO_REQUEST = 0; }

/** @apiSince 29 */

public static final int ICMP_ECHO;
static { ICMP_ECHO = 0; }

/** @apiSince 29 */

public static final int ICMP_ECHOREPLY;
static { ICMP_ECHOREPLY = 0; }

/** @apiSince 21 */

public static final int IFA_F_DADFAILED;
static { IFA_F_DADFAILED = 0; }

/** @apiSince 21 */

public static final int IFA_F_DEPRECATED;
static { IFA_F_DEPRECATED = 0; }

/** @apiSince 21 */

public static final int IFA_F_HOMEADDRESS;
static { IFA_F_HOMEADDRESS = 0; }

/** @apiSince 21 */

public static final int IFA_F_NODAD;
static { IFA_F_NODAD = 0; }

/** @apiSince 21 */

public static final int IFA_F_OPTIMISTIC;
static { IFA_F_OPTIMISTIC = 0; }

/** @apiSince 21 */

public static final int IFA_F_PERMANENT;
static { IFA_F_PERMANENT = 0; }

/** @apiSince 21 */

public static final int IFA_F_SECONDARY;
static { IFA_F_SECONDARY = 0; }

/** @apiSince 21 */

public static final int IFA_F_TEMPORARY;
static { IFA_F_TEMPORARY = 0; }

/** @apiSince 21 */

public static final int IFA_F_TENTATIVE;
static { IFA_F_TENTATIVE = 0; }

/** @apiSince 21 */

public static final int IFF_ALLMULTI;
static { IFF_ALLMULTI = 0; }

/** @apiSince 21 */

public static final int IFF_AUTOMEDIA;
static { IFF_AUTOMEDIA = 0; }

/** @apiSince 21 */

public static final int IFF_BROADCAST;
static { IFF_BROADCAST = 0; }

/** @apiSince 21 */

public static final int IFF_DEBUG;
static { IFF_DEBUG = 0; }

/** @apiSince 21 */

public static final int IFF_DYNAMIC;
static { IFF_DYNAMIC = 0; }

/** @apiSince 21 */

public static final int IFF_LOOPBACK;
static { IFF_LOOPBACK = 0; }

/** @apiSince 21 */

public static final int IFF_MASTER;
static { IFF_MASTER = 0; }

/** @apiSince 21 */

public static final int IFF_MULTICAST;
static { IFF_MULTICAST = 0; }

/** @apiSince 21 */

public static final int IFF_NOARP;
static { IFF_NOARP = 0; }

/** @apiSince 21 */

public static final int IFF_NOTRAILERS;
static { IFF_NOTRAILERS = 0; }

/** @apiSince 21 */

public static final int IFF_POINTOPOINT;
static { IFF_POINTOPOINT = 0; }

/** @apiSince 21 */

public static final int IFF_PORTSEL;
static { IFF_PORTSEL = 0; }

/** @apiSince 21 */

public static final int IFF_PROMISC;
static { IFF_PROMISC = 0; }

/** @apiSince 21 */

public static final int IFF_RUNNING;
static { IFF_RUNNING = 0; }

/** @apiSince 21 */

public static final int IFF_SLAVE;
static { IFF_SLAVE = 0; }

/** @apiSince 21 */

public static final int IFF_UP;
static { IFF_UP = 0; }

/** @apiSince 21 */

public static final int IPPROTO_ICMP;
static { IPPROTO_ICMP = 0; }

/** @apiSince 21 */

public static final int IPPROTO_ICMPV6;
static { IPPROTO_ICMPV6 = 0; }

/** @apiSince 21 */

public static final int IPPROTO_IP;
static { IPPROTO_IP = 0; }

/** @apiSince 21 */

public static final int IPPROTO_IPV6;
static { IPPROTO_IPV6 = 0; }

/** @apiSince 21 */

public static final int IPPROTO_RAW;
static { IPPROTO_RAW = 0; }

/** @apiSince 21 */

public static final int IPPROTO_TCP;
static { IPPROTO_TCP = 0; }

/** @apiSince 21 */

public static final int IPPROTO_UDP;
static { IPPROTO_UDP = 0; }

/** @apiSince 21 */

public static final int IPV6_CHECKSUM;
static { IPV6_CHECKSUM = 0; }

/** @apiSince 21 */

public static final int IPV6_MULTICAST_HOPS;
static { IPV6_MULTICAST_HOPS = 0; }

/** @apiSince 21 */

public static final int IPV6_MULTICAST_IF;
static { IPV6_MULTICAST_IF = 0; }

/** @apiSince 21 */

public static final int IPV6_MULTICAST_LOOP;
static { IPV6_MULTICAST_LOOP = 0; }

/** @apiSince 21 */

public static final int IPV6_RECVDSTOPTS;
static { IPV6_RECVDSTOPTS = 0; }

/** @apiSince 21 */

public static final int IPV6_RECVHOPLIMIT;
static { IPV6_RECVHOPLIMIT = 0; }

/** @apiSince 21 */

public static final int IPV6_RECVHOPOPTS;
static { IPV6_RECVHOPOPTS = 0; }

/** @apiSince 21 */

public static final int IPV6_RECVPKTINFO;
static { IPV6_RECVPKTINFO = 0; }

/** @apiSince 21 */

public static final int IPV6_RECVRTHDR;
static { IPV6_RECVRTHDR = 0; }

/** @apiSince 21 */

public static final int IPV6_RECVTCLASS;
static { IPV6_RECVTCLASS = 0; }

/** @apiSince 21 */

public static final int IPV6_TCLASS;
static { IPV6_TCLASS = 0; }

/** @apiSince 21 */

public static final int IPV6_UNICAST_HOPS;
static { IPV6_UNICAST_HOPS = 0; }

/** @apiSince 21 */

public static final int IPV6_V6ONLY;
static { IPV6_V6ONLY = 0; }

/** @apiSince 21 */

public static final int IP_MULTICAST_IF;
static { IP_MULTICAST_IF = 0; }

/** @apiSince 21 */

public static final int IP_MULTICAST_LOOP;
static { IP_MULTICAST_LOOP = 0; }

/** @apiSince 21 */

public static final int IP_MULTICAST_TTL;
static { IP_MULTICAST_TTL = 0; }

/** @apiSince 21 */

public static final int IP_TOS;
static { IP_TOS = 0; }

/** @apiSince 21 */

public static final int IP_TTL;
static { IP_TTL = 0; }

/** @apiSince R */

public static final int MAP_ANONYMOUS;
static { MAP_ANONYMOUS = 0; }

/** @apiSince 21 */

public static final int MAP_FIXED;
static { MAP_FIXED = 0; }

/** @apiSince 21 */

public static final int MAP_PRIVATE;
static { MAP_PRIVATE = 0; }

/** @apiSince 21 */

public static final int MAP_SHARED;
static { MAP_SHARED = 0; }

/** @apiSince 21 */

public static final int MCAST_BLOCK_SOURCE;
static { MCAST_BLOCK_SOURCE = 0; }

/** @apiSince 21 */

public static final int MCAST_JOIN_GROUP;
static { MCAST_JOIN_GROUP = 0; }

/** @apiSince 21 */

public static final int MCAST_JOIN_SOURCE_GROUP;
static { MCAST_JOIN_SOURCE_GROUP = 0; }

/** @apiSince 21 */

public static final int MCAST_LEAVE_GROUP;
static { MCAST_LEAVE_GROUP = 0; }

/** @apiSince 21 */

public static final int MCAST_LEAVE_SOURCE_GROUP;
static { MCAST_LEAVE_SOURCE_GROUP = 0; }

/** @apiSince 21 */

public static final int MCAST_UNBLOCK_SOURCE;
static { MCAST_UNBLOCK_SOURCE = 0; }

/** @apiSince 21 */

public static final int MCL_CURRENT;
static { MCL_CURRENT = 0; }

/** @apiSince 21 */

public static final int MCL_FUTURE;
static { MCL_FUTURE = 0; }

/** @apiSince R */

public static final int MFD_CLOEXEC;
static { MFD_CLOEXEC = 0; }

/** @apiSince 21 */

public static final int MSG_CTRUNC;
static { MSG_CTRUNC = 0; }

/** @apiSince 21 */

public static final int MSG_DONTROUTE;
static { MSG_DONTROUTE = 0; }

/** @apiSince 21 */

public static final int MSG_EOR;
static { MSG_EOR = 0; }

/** @apiSince 21 */

public static final int MSG_OOB;
static { MSG_OOB = 0; }

/** @apiSince 21 */

public static final int MSG_PEEK;
static { MSG_PEEK = 0; }

/** @apiSince 21 */

public static final int MSG_TRUNC;
static { MSG_TRUNC = 0; }

/** @apiSince 21 */

public static final int MSG_WAITALL;
static { MSG_WAITALL = 0; }

/** @apiSince 21 */

public static final int MS_ASYNC;
static { MS_ASYNC = 0; }

/** @apiSince 21 */

public static final int MS_INVALIDATE;
static { MS_INVALIDATE = 0; }

/** @apiSince 21 */

public static final int MS_SYNC;
static { MS_SYNC = 0; }

/**
 * SELinux enforces that only system_server and netd may use this netlink socket type.
 * @apiSince 29
 */

public static final int NETLINK_INET_DIAG;
static { NETLINK_INET_DIAG = 0; }

/** @apiSince R */

public static final int NETLINK_NETFILTER;
static { NETLINK_NETFILTER = 0; }

/** @apiSince 29 */

public static final int NETLINK_ROUTE;
static { NETLINK_ROUTE = 0; }

/** @apiSince 21 */

public static final int NI_DGRAM;
static { NI_DGRAM = 0; }

/** @apiSince 21 */

public static final int NI_NAMEREQD;
static { NI_NAMEREQD = 0; }

/** @apiSince 21 */

public static final int NI_NOFQDN;
static { NI_NOFQDN = 0; }

/** @apiSince 21 */

public static final int NI_NUMERICHOST;
static { NI_NUMERICHOST = 0; }

/** @apiSince 21 */

public static final int NI_NUMERICSERV;
static { NI_NUMERICSERV = 0; }

/** @apiSince 21 */

public static final int O_ACCMODE;
static { O_ACCMODE = 0; }

/** @apiSince 21 */

public static final int O_APPEND;
static { O_APPEND = 0; }

/** @apiSince 27 */

public static final int O_CLOEXEC;
static { O_CLOEXEC = 0; }

/** @apiSince 21 */

public static final int O_CREAT;
static { O_CREAT = 0; }

/** @apiSince 27 */

public static final int O_DSYNC;
static { O_DSYNC = 0; }

/** @apiSince 21 */

public static final int O_EXCL;
static { O_EXCL = 0; }

/** @apiSince 21 */

public static final int O_NOCTTY;
static { O_NOCTTY = 0; }

/** @apiSince 21 */

public static final int O_NOFOLLOW;
static { O_NOFOLLOW = 0; }

/** @apiSince 21 */

public static final int O_NONBLOCK;
static { O_NONBLOCK = 0; }

/** @apiSince 21 */

public static final int O_RDONLY;
static { O_RDONLY = 0; }

/** @apiSince 21 */

public static final int O_RDWR;
static { O_RDWR = 0; }

/** @apiSince 21 */

public static final int O_SYNC;
static { O_SYNC = 0; }

/** @apiSince 21 */

public static final int O_TRUNC;
static { O_TRUNC = 0; }

/** @apiSince 21 */

public static final int O_WRONLY;
static { O_WRONLY = 0; }

/** @apiSince 21 */

public static final int POLLERR;
static { POLLERR = 0; }

/** @apiSince 21 */

public static final int POLLHUP;
static { POLLHUP = 0; }

/** @apiSince 21 */

public static final int POLLIN;
static { POLLIN = 0; }

/** @apiSince 21 */

public static final int POLLNVAL;
static { POLLNVAL = 0; }

/** @apiSince 21 */

public static final int POLLOUT;
static { POLLOUT = 0; }

/** @apiSince 21 */

public static final int POLLPRI;
static { POLLPRI = 0; }

/** @apiSince 21 */

public static final int POLLRDBAND;
static { POLLRDBAND = 0; }

/** @apiSince 21 */

public static final int POLLRDNORM;
static { POLLRDNORM = 0; }

/** @apiSince 21 */

public static final int POLLWRBAND;
static { POLLWRBAND = 0; }

/** @apiSince 21 */

public static final int POLLWRNORM;
static { POLLWRNORM = 0; }

/** @apiSince 21 */

public static final int PROT_EXEC;
static { PROT_EXEC = 0; }

/** @apiSince 21 */

public static final int PROT_NONE;
static { PROT_NONE = 0; }

/** @apiSince 21 */

public static final int PROT_READ;
static { PROT_READ = 0; }

/** @apiSince 21 */

public static final int PROT_WRITE;
static { PROT_WRITE = 0; }

/** @apiSince 21 */

public static final int PR_GET_DUMPABLE;
static { PR_GET_DUMPABLE = 0; }

/** @apiSince 21 */

public static final int PR_SET_DUMPABLE;
static { PR_SET_DUMPABLE = 0; }

/** @apiSince 21 */

public static final int PR_SET_NO_NEW_PRIVS;
static { PR_SET_NO_NEW_PRIVS = 0; }

/** @apiSince 29 */

public static final int RTMGRP_NEIGH;
static { RTMGRP_NEIGH = 0; }

/** @apiSince 21 */

public static final int RT_SCOPE_HOST;
static { RT_SCOPE_HOST = 0; }

/** @apiSince 21 */

public static final int RT_SCOPE_LINK;
static { RT_SCOPE_LINK = 0; }

/** @apiSince 21 */

public static final int RT_SCOPE_NOWHERE;
static { RT_SCOPE_NOWHERE = 0; }

/** @apiSince 21 */

public static final int RT_SCOPE_SITE;
static { RT_SCOPE_SITE = 0; }

/** @apiSince 21 */

public static final int RT_SCOPE_UNIVERSE;
static { RT_SCOPE_UNIVERSE = 0; }

/** @apiSince 21 */

public static final int R_OK;
static { R_OK = 0; }

/** @apiSince 21 */

public static final int SEEK_CUR;
static { SEEK_CUR = 0; }

/** @apiSince 21 */

public static final int SEEK_END;
static { SEEK_END = 0; }

/** @apiSince 21 */

public static final int SEEK_SET;
static { SEEK_SET = 0; }

/** @apiSince 21 */

public static final int SHUT_RD;
static { SHUT_RD = 0; }

/** @apiSince 21 */

public static final int SHUT_RDWR;
static { SHUT_RDWR = 0; }

/** @apiSince 21 */

public static final int SHUT_WR;
static { SHUT_WR = 0; }

/** @apiSince 21 */

public static final int SIGABRT;
static { SIGABRT = 0; }

/** @apiSince 21 */

public static final int SIGALRM;
static { SIGALRM = 0; }

/** @apiSince 21 */

public static final int SIGBUS;
static { SIGBUS = 0; }

/** @apiSince 21 */

public static final int SIGCHLD;
static { SIGCHLD = 0; }

/** @apiSince 21 */

public static final int SIGCONT;
static { SIGCONT = 0; }

/** @apiSince 21 */

public static final int SIGFPE;
static { SIGFPE = 0; }

/** @apiSince 21 */

public static final int SIGHUP;
static { SIGHUP = 0; }

/** @apiSince 21 */

public static final int SIGILL;
static { SIGILL = 0; }

/** @apiSince 21 */

public static final int SIGINT;
static { SIGINT = 0; }

/** @apiSince 21 */

public static final int SIGIO;
static { SIGIO = 0; }

/** @apiSince 21 */

public static final int SIGKILL;
static { SIGKILL = 0; }

/** @apiSince 21 */

public static final int SIGPIPE;
static { SIGPIPE = 0; }

/** @apiSince 21 */

public static final int SIGPROF;
static { SIGPROF = 0; }

/** @apiSince 21 */

public static final int SIGPWR;
static { SIGPWR = 0; }

/** @apiSince 21 */

public static final int SIGQUIT;
static { SIGQUIT = 0; }

/** @apiSince 21 */

public static final int SIGRTMAX;
static { SIGRTMAX = 0; }

/** @apiSince 21 */

public static final int SIGRTMIN;
static { SIGRTMIN = 0; }

/** @apiSince 21 */

public static final int SIGSEGV;
static { SIGSEGV = 0; }

/** @apiSince 21 */

public static final int SIGSTKFLT;
static { SIGSTKFLT = 0; }

/** @apiSince 21 */

public static final int SIGSTOP;
static { SIGSTOP = 0; }

/** @apiSince 21 */

public static final int SIGSYS;
static { SIGSYS = 0; }

/** @apiSince 21 */

public static final int SIGTERM;
static { SIGTERM = 0; }

/** @apiSince 21 */

public static final int SIGTRAP;
static { SIGTRAP = 0; }

/** @apiSince 21 */

public static final int SIGTSTP;
static { SIGTSTP = 0; }

/** @apiSince 21 */

public static final int SIGTTIN;
static { SIGTTIN = 0; }

/** @apiSince 21 */

public static final int SIGTTOU;
static { SIGTTOU = 0; }

/** @apiSince 21 */

public static final int SIGURG;
static { SIGURG = 0; }

/** @apiSince 21 */

public static final int SIGUSR1;
static { SIGUSR1 = 0; }

/** @apiSince 21 */

public static final int SIGUSR2;
static { SIGUSR2 = 0; }

/** @apiSince 21 */

public static final int SIGVTALRM;
static { SIGVTALRM = 0; }

/** @apiSince 21 */

public static final int SIGWINCH;
static { SIGWINCH = 0; }

/** @apiSince 21 */

public static final int SIGXCPU;
static { SIGXCPU = 0; }

/** @apiSince 21 */

public static final int SIGXFSZ;
static { SIGXFSZ = 0; }

/** @apiSince 21 */

public static final int SIOCGIFADDR;
static { SIOCGIFADDR = 0; }

/** @apiSince 21 */

public static final int SIOCGIFBRDADDR;
static { SIOCGIFBRDADDR = 0; }

/** @apiSince 21 */

public static final int SIOCGIFDSTADDR;
static { SIOCGIFDSTADDR = 0; }

/** @apiSince 21 */

public static final int SIOCGIFNETMASK;
static { SIOCGIFNETMASK = 0; }

/**
 * Set the close-on-exec ({@code FD_CLOEXEC}) flag on the new file
 * descriptor created by {@link android.system.Os#socket(int,int,int) Os#socket(int,int,int)} or
 * {@link android.system.Os#socketpair(int,int,int,java.io.FileDescriptor,java.io.FileDescriptor) Os#socketpair(int,int,int,java.io.FileDescriptor,java.io.FileDescriptor)}.
 * See the description of the O_CLOEXEC flag in
 * <a href="http://man7.org/linux/man-pages/man2/open.2.html">open(2)</a>
 * for reasons why this may be useful.
 *
 * <p>Applications wishing to make use of this flag on older API versions
 * may use {@link #O_CLOEXEC} instead. On Android, {@code O_CLOEXEC} and
 * {@code SOCK_CLOEXEC} are the same value.
 * @apiSince 29
 */

public static final int SOCK_CLOEXEC;
static { SOCK_CLOEXEC = 0; }

/** @apiSince 21 */

public static final int SOCK_DGRAM;
static { SOCK_DGRAM = 0; }

/**
 * Set the O_NONBLOCK file status flag on the file descriptor
 * created by {@link android.system.Os#socket(int,int,int) Os#socket(int,int,int)} or
 * {@link android.system.Os#socketpair(int,int,int,java.io.FileDescriptor,java.io.FileDescriptor) Os#socketpair(int,int,int,java.io.FileDescriptor,java.io.FileDescriptor)}.
 *
 * <p>Applications wishing to make use of this flag on older API versions
 * may use {@link #O_NONBLOCK} instead. On Android, {@code O_NONBLOCK}
 * and {@code SOCK_NONBLOCK} are the same value.
 * @apiSince 29
 */

public static final int SOCK_NONBLOCK;
static { SOCK_NONBLOCK = 0; }

/** @apiSince 21 */

public static final int SOCK_RAW;
static { SOCK_RAW = 0; }

/** @apiSince 21 */

public static final int SOCK_SEQPACKET;
static { SOCK_SEQPACKET = 0; }

/** @apiSince 21 */

public static final int SOCK_STREAM;
static { SOCK_STREAM = 0; }

/** @apiSince 21 */

public static final int SOL_SOCKET;
static { SOL_SOCKET = 0; }

/** @apiSince 21 */

public static final int SO_BINDTODEVICE;
static { SO_BINDTODEVICE = 0; }

/** @apiSince 21 */

public static final int SO_BROADCAST;
static { SO_BROADCAST = 0; }

/** @apiSince 21 */

public static final int SO_DEBUG;
static { SO_DEBUG = 0; }

/** @apiSince 21 */

public static final int SO_DONTROUTE;
static { SO_DONTROUTE = 0; }

/** @apiSince 21 */

public static final int SO_ERROR;
static { SO_ERROR = 0; }

/** @apiSince 21 */

public static final int SO_KEEPALIVE;
static { SO_KEEPALIVE = 0; }

/** @apiSince 21 */

public static final int SO_LINGER;
static { SO_LINGER = 0; }

/** @apiSince 21 */

public static final int SO_OOBINLINE;
static { SO_OOBINLINE = 0; }

/** @apiSince 21 */

public static final int SO_PASSCRED;
static { SO_PASSCRED = 0; }

/** @apiSince 21 */

public static final int SO_PEERCRED;
static { SO_PEERCRED = 0; }

/** @apiSince 21 */

public static final int SO_RCVBUF;
static { SO_RCVBUF = 0; }

/** @apiSince 21 */

public static final int SO_RCVLOWAT;
static { SO_RCVLOWAT = 0; }

/** @apiSince 21 */

public static final int SO_RCVTIMEO;
static { SO_RCVTIMEO = 0; }

/** @apiSince 21 */

public static final int SO_REUSEADDR;
static { SO_REUSEADDR = 0; }

/** @apiSince 21 */

public static final int SO_SNDBUF;
static { SO_SNDBUF = 0; }

/** @apiSince 21 */

public static final int SO_SNDLOWAT;
static { SO_SNDLOWAT = 0; }

/** @apiSince 21 */

public static final int SO_SNDTIMEO;
static { SO_SNDTIMEO = 0; }

/** @apiSince 21 */

public static final int SO_TYPE;
static { SO_TYPE = 0; }

/** @apiSince 21 */

public static final int STDERR_FILENO;
static { STDERR_FILENO = 0; }

/** @apiSince 21 */

public static final int STDIN_FILENO;
static { STDIN_FILENO = 0; }

/** @apiSince 21 */

public static final int STDOUT_FILENO;
static { STDOUT_FILENO = 0; }

/** @apiSince 23 */

public static final int ST_MANDLOCK;
static { ST_MANDLOCK = 0; }

/** @apiSince 23 */

public static final int ST_NOATIME;
static { ST_NOATIME = 0; }

/** @apiSince 23 */

public static final int ST_NODEV;
static { ST_NODEV = 0; }

/** @apiSince 23 */

public static final int ST_NODIRATIME;
static { ST_NODIRATIME = 0; }

/** @apiSince 23 */

public static final int ST_NOEXEC;
static { ST_NOEXEC = 0; }

/** @apiSince 23 */

public static final int ST_NOSUID;
static { ST_NOSUID = 0; }

/** @apiSince 23 */

public static final int ST_RDONLY;
static { ST_RDONLY = 0; }

/** @apiSince 23 */

public static final int ST_RELATIME;
static { ST_RELATIME = 0; }

/** @apiSince 23 */

public static final int ST_SYNCHRONOUS;
static { ST_SYNCHRONOUS = 0; }

/** @apiSince 21 */

public static final int S_IFBLK;
static { S_IFBLK = 0; }

/** @apiSince 21 */

public static final int S_IFCHR;
static { S_IFCHR = 0; }

/** @apiSince 21 */

public static final int S_IFDIR;
static { S_IFDIR = 0; }

/** @apiSince 21 */

public static final int S_IFIFO;
static { S_IFIFO = 0; }

/** @apiSince 21 */

public static final int S_IFLNK;
static { S_IFLNK = 0; }

/** @apiSince 21 */

public static final int S_IFMT;
static { S_IFMT = 0; }

/** @apiSince 21 */

public static final int S_IFREG;
static { S_IFREG = 0; }

/** @apiSince 21 */

public static final int S_IFSOCK;
static { S_IFSOCK = 0; }

/** @apiSince 21 */

public static final int S_IRGRP;
static { S_IRGRP = 0; }

/** @apiSince 21 */

public static final int S_IROTH;
static { S_IROTH = 0; }

/** @apiSince 21 */

public static final int S_IRUSR;
static { S_IRUSR = 0; }

/** @apiSince 21 */

public static final int S_IRWXG;
static { S_IRWXG = 0; }

/** @apiSince 21 */

public static final int S_IRWXO;
static { S_IRWXO = 0; }

/** @apiSince 21 */

public static final int S_IRWXU;
static { S_IRWXU = 0; }

/** @apiSince 21 */

public static final int S_ISGID;
static { S_ISGID = 0; }

/** @apiSince 21 */

public static final int S_ISUID;
static { S_ISUID = 0; }

/** @apiSince 21 */

public static final int S_ISVTX;
static { S_ISVTX = 0; }

/** @apiSince 21 */

public static final int S_IWGRP;
static { S_IWGRP = 0; }

/** @apiSince 21 */

public static final int S_IWOTH;
static { S_IWOTH = 0; }

/** @apiSince 21 */

public static final int S_IWUSR;
static { S_IWUSR = 0; }

/** @apiSince 21 */

public static final int S_IXGRP;
static { S_IXGRP = 0; }

/** @apiSince 21 */

public static final int S_IXOTH;
static { S_IXOTH = 0; }

/** @apiSince 21 */

public static final int S_IXUSR;
static { S_IXUSR = 0; }

/** @apiSince 21 */

public static final int TCP_NODELAY;
static { TCP_NODELAY = 0; }

/** @apiSince 26 */

public static final int TCP_USER_TIMEOUT;
static { TCP_USER_TIMEOUT = 0; }

/** @apiSince 21 */

public static final int WCONTINUED;
static { WCONTINUED = 0; }

/** @apiSince 21 */

public static final int WEXITED;
static { WEXITED = 0; }

/** @apiSince 21 */

public static final int WNOHANG;
static { WNOHANG = 0; }

/** @apiSince 21 */

public static final int WNOWAIT;
static { WNOWAIT = 0; }

/** @apiSince 21 */

public static final int WSTOPPED;
static { WSTOPPED = 0; }

/** @apiSince 21 */

public static final int WUNTRACED;
static { WUNTRACED = 0; }

/** @apiSince 21 */

public static final int W_OK;
static { W_OK = 0; }

/** @apiSince 21 */

public static final int X_OK;
static { X_OK = 0; }

/** @apiSince 21 */

public static final int _SC_2_CHAR_TERM;
static { _SC_2_CHAR_TERM = 0; }

/** @apiSince 21 */

public static final int _SC_2_C_BIND;
static { _SC_2_C_BIND = 0; }

/** @apiSince 21 */

public static final int _SC_2_C_DEV;
static { _SC_2_C_DEV = 0; }

/** @apiSince 21 */

public static final int _SC_2_C_VERSION;
static { _SC_2_C_VERSION = 0; }

/** @apiSince 21 */

public static final int _SC_2_FORT_DEV;
static { _SC_2_FORT_DEV = 0; }

/** @apiSince 21 */

public static final int _SC_2_FORT_RUN;
static { _SC_2_FORT_RUN = 0; }

/** @apiSince 21 */

public static final int _SC_2_LOCALEDEF;
static { _SC_2_LOCALEDEF = 0; }

/** @apiSince 21 */

public static final int _SC_2_SW_DEV;
static { _SC_2_SW_DEV = 0; }

/** @apiSince 21 */

public static final int _SC_2_UPE;
static { _SC_2_UPE = 0; }

/** @apiSince 21 */

public static final int _SC_2_VERSION;
static { _SC_2_VERSION = 0; }

/** @apiSince 21 */

public static final int _SC_AIO_LISTIO_MAX;
static { _SC_AIO_LISTIO_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_AIO_MAX;
static { _SC_AIO_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_AIO_PRIO_DELTA_MAX;
static { _SC_AIO_PRIO_DELTA_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_ARG_MAX;
static { _SC_ARG_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_ASYNCHRONOUS_IO;
static { _SC_ASYNCHRONOUS_IO = 0; }

/** @apiSince 21 */

public static final int _SC_ATEXIT_MAX;
static { _SC_ATEXIT_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_AVPHYS_PAGES;
static { _SC_AVPHYS_PAGES = 0; }

/** @apiSince 21 */

public static final int _SC_BC_BASE_MAX;
static { _SC_BC_BASE_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_BC_DIM_MAX;
static { _SC_BC_DIM_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_BC_SCALE_MAX;
static { _SC_BC_SCALE_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_BC_STRING_MAX;
static { _SC_BC_STRING_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_CHILD_MAX;
static { _SC_CHILD_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_CLK_TCK;
static { _SC_CLK_TCK = 0; }

/** @apiSince 21 */

public static final int _SC_COLL_WEIGHTS_MAX;
static { _SC_COLL_WEIGHTS_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_DELAYTIMER_MAX;
static { _SC_DELAYTIMER_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_EXPR_NEST_MAX;
static { _SC_EXPR_NEST_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_FSYNC;
static { _SC_FSYNC = 0; }

/** @apiSince 21 */

public static final int _SC_GETGR_R_SIZE_MAX;
static { _SC_GETGR_R_SIZE_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_GETPW_R_SIZE_MAX;
static { _SC_GETPW_R_SIZE_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_IOV_MAX;
static { _SC_IOV_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_JOB_CONTROL;
static { _SC_JOB_CONTROL = 0; }

/** @apiSince 21 */

public static final int _SC_LINE_MAX;
static { _SC_LINE_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_LOGIN_NAME_MAX;
static { _SC_LOGIN_NAME_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_MAPPED_FILES;
static { _SC_MAPPED_FILES = 0; }

/** @apiSince 21 */

public static final int _SC_MEMLOCK;
static { _SC_MEMLOCK = 0; }

/** @apiSince 21 */

public static final int _SC_MEMLOCK_RANGE;
static { _SC_MEMLOCK_RANGE = 0; }

/** @apiSince 21 */

public static final int _SC_MEMORY_PROTECTION;
static { _SC_MEMORY_PROTECTION = 0; }

/** @apiSince 21 */

public static final int _SC_MESSAGE_PASSING;
static { _SC_MESSAGE_PASSING = 0; }

/** @apiSince 21 */

public static final int _SC_MQ_OPEN_MAX;
static { _SC_MQ_OPEN_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_MQ_PRIO_MAX;
static { _SC_MQ_PRIO_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_NGROUPS_MAX;
static { _SC_NGROUPS_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_NPROCESSORS_CONF;
static { _SC_NPROCESSORS_CONF = 0; }

/** @apiSince 21 */

public static final int _SC_NPROCESSORS_ONLN;
static { _SC_NPROCESSORS_ONLN = 0; }

/** @apiSince 21 */

public static final int _SC_OPEN_MAX;
static { _SC_OPEN_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_PAGESIZE;
static { _SC_PAGESIZE = 0; }

/** @apiSince 21 */

public static final int _SC_PAGE_SIZE;
static { _SC_PAGE_SIZE = 0; }

/** @apiSince 21 */

public static final int _SC_PASS_MAX;
static { _SC_PASS_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_PHYS_PAGES;
static { _SC_PHYS_PAGES = 0; }

/** @apiSince 21 */

public static final int _SC_PRIORITIZED_IO;
static { _SC_PRIORITIZED_IO = 0; }

/** @apiSince 21 */

public static final int _SC_PRIORITY_SCHEDULING;
static { _SC_PRIORITY_SCHEDULING = 0; }

/** @apiSince 21 */

public static final int _SC_REALTIME_SIGNALS;
static { _SC_REALTIME_SIGNALS = 0; }

/** @apiSince 21 */

public static final int _SC_RE_DUP_MAX;
static { _SC_RE_DUP_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_RTSIG_MAX;
static { _SC_RTSIG_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_SAVED_IDS;
static { _SC_SAVED_IDS = 0; }

/** @apiSince 21 */

public static final int _SC_SEMAPHORES;
static { _SC_SEMAPHORES = 0; }

/** @apiSince 21 */

public static final int _SC_SEM_NSEMS_MAX;
static { _SC_SEM_NSEMS_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_SEM_VALUE_MAX;
static { _SC_SEM_VALUE_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_SHARED_MEMORY_OBJECTS;
static { _SC_SHARED_MEMORY_OBJECTS = 0; }

/** @apiSince 21 */

public static final int _SC_SIGQUEUE_MAX;
static { _SC_SIGQUEUE_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_STREAM_MAX;
static { _SC_STREAM_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_SYNCHRONIZED_IO;
static { _SC_SYNCHRONIZED_IO = 0; }

/** @apiSince 21 */

public static final int _SC_THREADS;
static { _SC_THREADS = 0; }

/** @apiSince 21 */

public static final int _SC_THREAD_ATTR_STACKADDR;
static { _SC_THREAD_ATTR_STACKADDR = 0; }

/** @apiSince 21 */

public static final int _SC_THREAD_ATTR_STACKSIZE;
static { _SC_THREAD_ATTR_STACKSIZE = 0; }

/** @apiSince 21 */

public static final int _SC_THREAD_DESTRUCTOR_ITERATIONS;
static { _SC_THREAD_DESTRUCTOR_ITERATIONS = 0; }

/** @apiSince 21 */

public static final int _SC_THREAD_KEYS_MAX;
static { _SC_THREAD_KEYS_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_THREAD_PRIORITY_SCHEDULING;
static { _SC_THREAD_PRIORITY_SCHEDULING = 0; }

/** @apiSince 21 */

public static final int _SC_THREAD_PRIO_INHERIT;
static { _SC_THREAD_PRIO_INHERIT = 0; }

/** @apiSince 21 */

public static final int _SC_THREAD_PRIO_PROTECT;
static { _SC_THREAD_PRIO_PROTECT = 0; }

/** @apiSince 21 */

public static final int _SC_THREAD_SAFE_FUNCTIONS;
static { _SC_THREAD_SAFE_FUNCTIONS = 0; }

/** @apiSince 21 */

public static final int _SC_THREAD_STACK_MIN;
static { _SC_THREAD_STACK_MIN = 0; }

/** @apiSince 21 */

public static final int _SC_THREAD_THREADS_MAX;
static { _SC_THREAD_THREADS_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_TIMERS;
static { _SC_TIMERS = 0; }

/** @apiSince 21 */

public static final int _SC_TIMER_MAX;
static { _SC_TIMER_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_TTY_NAME_MAX;
static { _SC_TTY_NAME_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_TZNAME_MAX;
static { _SC_TZNAME_MAX = 0; }

/** @apiSince 21 */

public static final int _SC_VERSION;
static { _SC_VERSION = 0; }

/** @apiSince 21 */

public static final int _SC_XBS5_ILP32_OFF32;
static { _SC_XBS5_ILP32_OFF32 = 0; }

/** @apiSince 21 */

public static final int _SC_XBS5_ILP32_OFFBIG;
static { _SC_XBS5_ILP32_OFFBIG = 0; }

/** @apiSince 21 */

public static final int _SC_XBS5_LP64_OFF64;
static { _SC_XBS5_LP64_OFF64 = 0; }

/** @apiSince 21 */

public static final int _SC_XBS5_LPBIG_OFFBIG;
static { _SC_XBS5_LPBIG_OFFBIG = 0; }

/** @apiSince 21 */

public static final int _SC_XOPEN_CRYPT;
static { _SC_XOPEN_CRYPT = 0; }

/** @apiSince 21 */

public static final int _SC_XOPEN_ENH_I18N;
static { _SC_XOPEN_ENH_I18N = 0; }

/** @apiSince 21 */

public static final int _SC_XOPEN_LEGACY;
static { _SC_XOPEN_LEGACY = 0; }

/** @apiSince 21 */

public static final int _SC_XOPEN_REALTIME;
static { _SC_XOPEN_REALTIME = 0; }

/** @apiSince 21 */

public static final int _SC_XOPEN_REALTIME_THREADS;
static { _SC_XOPEN_REALTIME_THREADS = 0; }

/** @apiSince 21 */

public static final int _SC_XOPEN_SHM;
static { _SC_XOPEN_SHM = 0; }

/** @apiSince 21 */

public static final int _SC_XOPEN_UNIX;
static { _SC_XOPEN_UNIX = 0; }

/** @apiSince 21 */

public static final int _SC_XOPEN_VERSION;
static { _SC_XOPEN_VERSION = 0; }

/** @apiSince 21 */

public static final int _SC_XOPEN_XCU_VERSION;
static { _SC_XOPEN_XCU_VERSION = 0; }
}

