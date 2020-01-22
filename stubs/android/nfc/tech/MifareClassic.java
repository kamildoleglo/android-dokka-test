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


package android.nfc.tech;

import android.nfc.Tag;
import java.io.IOException;
import android.nfc.TagLostException;

/**
 * Provides access to MIFARE Classic properties and I/O operations on a {@link android.nfc.Tag Tag}.
 *
 * <p>Acquire a {@link android.nfc.tech.MifareClassic MifareClassic} object using {@link #get}.
 *
 * <p>MIFARE Classic is also known as MIFARE Standard.
 * <p>MIFARE Classic tags are divided into sectors, and each sector is sub-divided into
 * blocks. Block size is always 16 bytes ({@link #BLOCK_SIZE}. Sector size varies.
 * <ul>
 * <li>MIFARE Classic Mini are 320 bytes ({@link #SIZE_MINI}), with 5 sectors each of 4 blocks.
 * <li>MIFARE Classic 1k are 1024 bytes ({@link #SIZE_1K}), with 16 sectors each of 4 blocks.
 * <li>MIFARE Classic 2k are 2048 bytes ({@link #SIZE_2K}), with 32 sectors each of 4 blocks.
 * <li>MIFARE Classic 4k are 4096 bytes ({@link #SIZE_4K}). The first 32 sectors contain 4 blocks
 * and the last 8 sectors contain 16 blocks.
 * </ul>
 *
 * <p>MIFARE Classic tags require authentication on a per-sector basis before any
 * other I/O operations on that sector can be performed. There are two keys per sector,
 * and ACL bits determine what I/O operations are allowed on that sector after
 * authenticating with a key. {@see #authenticateSectorWithKeyA} and
 * {@see #authenticateSectorWithKeyB}.
 *
 * <p>Three well-known authentication keys are defined in this class:
 * {@link #KEY_DEFAULT}, {@link #KEY_MIFARE_APPLICATION_DIRECTORY},
 * {@link #KEY_NFC_FORUM}.
 * <ul>
 * <li>{@link #KEY_DEFAULT} is the default factory key for MIFARE Classic.
 * <li>{@link #KEY_MIFARE_APPLICATION_DIRECTORY} is the well-known key for
 * MIFARE Classic cards that have been formatted according to the
 * MIFARE Application Directory (MAD) specification.
 * <li>{@link #KEY_NFC_FORUM} is the well-known key for MIFARE Classic cards that
 * have been formatted according to the NXP specification for NDEF on MIFARE Classic.
 *
 * <p>Implementation of this class on a Android NFC device is optional.
 * If it is not implemented, then
 * {@link android.nfc.tech.MifareClassic MifareClassic} will never be enumerated in {@link android.nfc.Tag#getTechList Tag#getTechList}.
 * If it is enumerated, then all {@link android.nfc.tech.MifareClassic MifareClassic} I/O operations will be supported,
 * and {@link android.nfc.tech.Ndef#MIFARE_CLASSIC Ndef#MIFARE_CLASSIC} NDEF tags will also be supported. In either case,
 * {@link android.nfc.tech.NfcA NfcA} will also be enumerated on the tag, because all MIFARE Classic tags are also
 * {@link android.nfc.tech.NfcA NfcA}.
 *
 * <p class="note"><strong>Note:</strong> Methods that perform I/O operations
 * require the {@link android.Manifest.permission#NFC} permission.
 * @apiSince 10
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MifareClassic implements android.nfc.tech.TagTechnology {

MifareClassic() { throw new RuntimeException("Stub!"); }

/**
 * Get an instance of {@link android.nfc.tech.MifareClassic MifareClassic} for the given tag.
 * <p>Does not cause any RF activity and does not block.
 * <p>Returns null if {@link android.nfc.tech.MifareClassic MifareClassic} was not enumerated in {@link android.nfc.Tag#getTechList Tag#getTechList}.
 * This indicates the tag is not MIFARE Classic compatible, or this Android
 * device does not support MIFARE Classic.
 *
 * @param tag an MIFARE Classic compatible tag
 * @return MIFARE Classic object
 * @apiSince 10
 */

public static android.nfc.tech.MifareClassic get(android.nfc.Tag tag) { throw new RuntimeException("Stub!"); }

/**
 * Return the type of this MIFARE Classic compatible tag.
 * <p>One of {@link #TYPE_UNKNOWN}, {@link #TYPE_CLASSIC}, {@link #TYPE_PLUS} or
 * {@link #TYPE_PRO}.
 * <p>Does not cause any RF activity and does not block.
 *
 * @return type
 * @apiSince 10
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Return the size of the tag in bytes
 * <p>One of {@link #SIZE_MINI}, {@link #SIZE_1K}, {@link #SIZE_2K}, {@link #SIZE_4K}.
 * These constants are equal to their respective size in bytes.
 * <p>Does not cause any RF activity and does not block.
 * @return size in bytes
 * @apiSince 10
 */

public int getSize() { throw new RuntimeException("Stub!"); }

/**
 * Return the number of MIFARE Classic sectors.
 * <p>Does not cause any RF activity and does not block.
 * @return number of sectors
 * @apiSince 10
 */

public int getSectorCount() { throw new RuntimeException("Stub!"); }

/**
 * Return the total number of MIFARE Classic blocks.
 * <p>Does not cause any RF activity and does not block.
 * @return total number of blocks
 * @apiSince 10
 */

public int getBlockCount() { throw new RuntimeException("Stub!"); }

/**
 * Return the number of blocks in the given sector.
 * <p>Does not cause any RF activity and does not block.
 *
 * @param sectorIndex index of sector, starting from 0
 * @return number of blocks in the sector
 * @apiSince 10
 */

public int getBlockCountInSector(int sectorIndex) { throw new RuntimeException("Stub!"); }

/**
 * Return the sector that contains a given block.
 * <p>Does not cause any RF activity and does not block.
 *
 * @param blockIndex index of block to lookup, starting from 0
 * @return sector index that contains the block
 * @apiSince 10
 */

public int blockToSector(int blockIndex) { throw new RuntimeException("Stub!"); }

/**
 * Return the first block of a given sector.
 * <p>Does not cause any RF activity and does not block.
 *
 * @param sectorIndex index of sector to lookup, starting from 0
 * @return block index of first block in sector
 * @apiSince 10
 */

public int sectorToBlock(int sectorIndex) { throw new RuntimeException("Stub!"); }

/**
 * Authenticate a sector with key A.
 *
 * <p>Successful authentication of a sector with key A enables other
 * I/O operations on that sector. The set of operations granted by key A
 * key depends on the ACL bits set in that sector. For more information
 * see the MIFARE Classic specification on <a href="http://www.nxp.com">http://www.nxp.com</a>.
 *
 * <p>A failed authentication attempt causes an implicit reconnection to the
 * tag, so authentication to other sectors will be lost.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param sectorIndex index of sector to authenticate, starting from 0
 * @param key 6-byte authentication key
 * @return true on success, false on authentication failure
 * @throws android.nfc.TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or the operation is canceled
 * @apiSince 10
 */

public boolean authenticateSectorWithKeyA(int sectorIndex, byte[] key) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Authenticate a sector with key B.
 *
 * <p>Successful authentication of a sector with key B enables other
 * I/O operations on that sector. The set of operations granted by key B
 * depends on the ACL bits set in that sector. For more information
 * see the MIFARE Classic specification on <a href="http://www.nxp.com">http://www.nxp.com</a>.
 *
 * <p>A failed authentication attempt causes an implicit reconnection to the
 * tag, so authentication to other sectors will be lost.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param sectorIndex index of sector to authenticate, starting from 0
 * @param key 6-byte authentication key
 * @return true on success, false on authentication failure
 * @throws android.nfc.TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or the operation is canceled
 * @apiSince 10
 */

public boolean authenticateSectorWithKeyB(int sectorIndex, byte[] key) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Read 16-byte block.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param blockIndex index of block to read, starting from 0
 * @return 16 byte block
 * @throws android.nfc.TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or the operation is canceled
 * @apiSince 10
 */

public byte[] readBlock(int blockIndex) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Write 16-byte block.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param blockIndex index of block to write, starting from 0
 * @param data 16 bytes of data to write
 * @throws android.nfc.TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or the operation is canceled
 * @apiSince 10
 */

public void writeBlock(int blockIndex, byte[] data) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Increment a value block, storing the result in the temporary block on the tag.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param blockIndex index of block to increment, starting from 0
 * @param value non-negative to increment by
 * @throws android.nfc.TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or the operation is canceled
 * @apiSince 10
 */

public void increment(int blockIndex, int value) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Decrement a value block, storing the result in the temporary block on the tag.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param blockIndex index of block to decrement, starting from 0
 * @param value non-negative to decrement by
 * @throws android.nfc.TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or the operation is canceled
 * @apiSince 10
 */

public void decrement(int blockIndex, int value) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Copy from the temporary block to a value block.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param blockIndex index of block to copy to
 * @throws android.nfc.TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or the operation is canceled
 * @apiSince 10
 */

public void transfer(int blockIndex) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Copy from a value block to the temporary block.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param blockIndex index of block to copy from
 * @throws android.nfc.TagLostException if the tag leaves the field
 * @throws java.io.IOException if there is an I/O failure, or the operation is canceled
 * @apiSince 10
 */

public void restore(int blockIndex) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Send raw NfcA data to a tag and receive the response.
 *
 * <p>This is equivalent to connecting to this tag via {@link android.nfc.tech.NfcA NfcA}
 * and calling {@link android.nfc.tech.NfcA#transceive NfcA#transceive}. Note that all MIFARE Classic
 * tags are based on {@link android.nfc.tech.NfcA NfcA} technology.
 *
 * <p>Use {@link #getMaxTransceiveLength} to retrieve the maximum number of bytes
 * that can be sent with {@link #transceive}.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link java.io.IOException IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @see NfcA#transceive
 * @apiSince 10
 */

public byte[] transceive(byte[] data) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return the maximum number of bytes that can be sent with {@link #transceive}.
 * @return the maximum number of bytes that can be sent with {@link #transceive}.
 * @apiSince 14
 */

public int getMaxTransceiveLength() { throw new RuntimeException("Stub!"); }

/**
 * Set the {@link #transceive} timeout in milliseconds.
 *
 * <p>The timeout only applies to {@link #transceive} on this object,
 * and is reset to a default value when {@link #close} is called.
 *
 * <p>Setting a longer timeout may be useful when performing
 * transactions that require a long processing time on the tag
 * such as key generation.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param timeout timeout value in milliseconds
 * @apiSince 14
 */

public void setTimeout(int timeout) { throw new RuntimeException("Stub!"); }

/**
 * Get the current {@link #transceive} timeout in milliseconds.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @return timeout value in milliseconds
 * @apiSince 14
 */

public int getTimeout() { throw new RuntimeException("Stub!"); }

public boolean isConnected() { throw new RuntimeException("Stub!"); }

public android.nfc.Tag getTag() { throw new RuntimeException("Stub!"); }

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public void connect() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Size of a MIFARE Classic block (in bytes)
 * @apiSince 10
 */

public static final int BLOCK_SIZE = 16; // 0x10

/**
 * The default factory key.
 * @apiSince 10
 */

public static final byte[] KEY_DEFAULT;
static { KEY_DEFAULT = new byte[0]; }

/**
 * The well-known key for tags formatted according to the
 * MIFARE Application Directory (MAD) specification.
 * @apiSince 10
 */

public static final byte[] KEY_MIFARE_APPLICATION_DIRECTORY;
static { KEY_MIFARE_APPLICATION_DIRECTORY = new byte[0]; }

/**
 * The well-known key for tags formatted according to the
 * NDEF on MIFARE Classic specification.
 * @apiSince 10
 */

public static final byte[] KEY_NFC_FORUM;
static { KEY_NFC_FORUM = new byte[0]; }

/**
 * Tag contains 16 sectors, each with 4 blocks.
 * @apiSince 10
 */

public static final int SIZE_1K = 1024; // 0x400

/**
 * Tag contains 32 sectors, each with 4 blocks.
 * @apiSince 10
 */

public static final int SIZE_2K = 2048; // 0x800

/**
 * Tag contains 40 sectors. The first 32 sectors contain 4 blocks and the last 8 sectors
 * contain 16 blocks.
 * @apiSince 10
 */

public static final int SIZE_4K = 4096; // 0x1000

/**
 * Tag contains 5 sectors, each with 4 blocks.
 * @apiSince 10
 */

public static final int SIZE_MINI = 320; // 0x140

/**
 * A MIFARE Classic tag
 * @apiSince 10
 */

public static final int TYPE_CLASSIC = 0; // 0x0

/**
 * A MIFARE Plus tag
 * @apiSince 10
 */

public static final int TYPE_PLUS = 1; // 0x1

/**
 * A MIFARE Pro tag
 * @apiSince 10
 */

public static final int TYPE_PRO = 2; // 0x2

/**
 * A MIFARE Classic compatible card of unknown type
 * @apiSince 10
 */

public static final int TYPE_UNKNOWN = -1; // 0xffffffff
}

