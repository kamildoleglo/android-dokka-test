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
 * Retrieve overall information about the space on a filesystem. This is a
 * wrapper for Unix statvfs().
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StatFs {

/**
 * Construct a new StatFs for looking at the stats of the filesystem at
 * {@code path}. Upon construction, the stat of the file system will be
 * performed, and the values retrieved available from the methods on this
 * class.
 *
 * @param path path in the desired file system to stat.
 *
 * @throws java.lang.IllegalArgumentException if the file system access fails
 * @apiSince 1
 */

public StatFs(java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Perform a restat of the file system referenced by this object. This is
 * the same as re-constructing the object with the same file system path,
 * and the new stat values are available upon return.
 *
 * @throws java.lang.IllegalArgumentException if the file system access fails
 * @apiSince 1
 */

public void restat(java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getBlockSizeLong()} instead.
 * @apiSince 1
 * @deprecatedSince 18
 */

@Deprecated
public int getBlockSize() { throw new RuntimeException("Stub!"); }

/**
 * The size, in bytes, of a block on the file system. This corresponds to
 * the Unix {@code statvfs.f_frsize} field.
 * @apiSince 18
 */

public long getBlockSizeLong() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getBlockCountLong()} instead.
 * @apiSince 1
 * @deprecatedSince 18
 */

@Deprecated
public int getBlockCount() { throw new RuntimeException("Stub!"); }

/**
 * The total number of blocks on the file system. This corresponds to the
 * Unix {@code statvfs.f_blocks} field.
 * @apiSince 18
 */

public long getBlockCountLong() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getFreeBlocksLong()} instead.
 * @apiSince 1
 * @deprecatedSince 18
 */

@Deprecated
public int getFreeBlocks() { throw new RuntimeException("Stub!"); }

/**
 * The total number of blocks that are free on the file system, including
 * reserved blocks (that are not available to normal applications). This
 * corresponds to the Unix {@code statvfs.f_bfree} field. Most applications
 * will want to use {@link #getAvailableBlocks()} instead.
 * @apiSince 18
 */

public long getFreeBlocksLong() { throw new RuntimeException("Stub!"); }

/**
 * The number of bytes that are free on the file system, including reserved
 * blocks (that are not available to normal applications). Most applications
 * will want to use {@link #getAvailableBytes()} instead.
 * @apiSince 18
 */

public long getFreeBytes() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getAvailableBlocksLong()} instead.
 * @apiSince 1
 * @deprecatedSince 18
 */

@Deprecated
public int getAvailableBlocks() { throw new RuntimeException("Stub!"); }

/**
 * The number of blocks that are free on the file system and available to
 * applications. This corresponds to the Unix {@code statvfs.f_bavail} field.
 * @apiSince 18
 */

public long getAvailableBlocksLong() { throw new RuntimeException("Stub!"); }

/**
 * The number of bytes that are free on the file system and available to
 * applications.
 * @apiSince 18
 */

public long getAvailableBytes() { throw new RuntimeException("Stub!"); }

/**
 * The total number of bytes supported by the file system.
 * @apiSince 18
 */

public long getTotalBytes() { throw new RuntimeException("Stub!"); }
}

