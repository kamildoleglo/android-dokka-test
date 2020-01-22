/*
 * Copyright (C) 2012 The Android Open Source Project
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

/**
 * Provides access to tags containing just a barcode.
 *
 * <p>Acquire an {@link android.nfc.tech.NfcBarcode NfcBarcode} object using {@link #get}.
 *
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NfcBarcode implements android.nfc.tech.TagTechnology {

NfcBarcode() { throw new RuntimeException("Stub!"); }

/**
 * Get an instance of {@link android.nfc.tech.NfcBarcode NfcBarcode} for the given tag.
 *
 * <p>Returns null if {@link android.nfc.tech.NfcBarcode NfcBarcode} was not enumerated in {@link android.nfc.Tag#getTechList Tag#getTechList}.
 *
 * <p>Does not cause any RF activity and does not block.
 *
 * @param tag an NfcBarcode compatible tag
 * @return NfcBarcode object
 * @apiSince 17
 */

public static android.nfc.tech.NfcBarcode get(android.nfc.Tag tag) { throw new RuntimeException("Stub!"); }

/**
 * Returns the NFC Barcode tag type.
 *
 * <p>Currently only one of {@link #TYPE_KOVIO} or {@link #TYPE_UNKNOWN}.
 *
 * <p>Does not cause any RF activity and does not block.
 *
 * @return the NFC Barcode tag type
 * @apiSince 17
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the barcode of an NfcBarcode tag.
 *
 * <p> Tags of {@link #TYPE_KOVIO} return 16 bytes:
 *     <ul>
 *     <p> The first byte is 0x80 ORd with a manufacturer ID, corresponding
 *       to ISO/IEC 7816-6.
 *     <p> The second byte describes the payload data format. Defined data
 *       format types include the following:<ul>
 *       <li>0x00: Reserved for manufacturer assignment</li>
 *       <li>0x01: 96-bit URL with "http://www." prefix</li>
 *       <li>0x02: 96-bit URL with "https://www." prefix</li>
 *       <li>0x03: 96-bit URL with "http://" prefix</li>
 *       <li>0x04: 96-bit URL with "https://" prefix</li>
 *       <li>0x05: 96-bit GS1 EPC</li>
 *       <li>0x06-0xFF: reserved</li>
 *       </ul>
 *     <p>The following 12 bytes are payload:<ul>
 *       <li> In case of a URL payload, the payload is encoded in US-ASCII,
 *            following the limitations defined in RFC3987.
 *            {@see <a href="http://www.ietf.org/rfc/rfc3987.txt">RFC 3987</a>}</li>
 *       <li> In case of GS1 EPC data, see <a href="http://www.gs1.org/gsmp/kc/epcglobal/tds/">
 *            GS1 Electronic Product Code (EPC) Tag Data Standard (TDS)</a> for more details.
 *       </li>
 *     </ul>
 *     <p>The last 2 bytes comprise the CRC.
 *     </ul>
 * <p>Does not cause any RF activity and does not block.
 *
 * @return a byte array containing the barcode
 * @see <a href="http://www.thinfilm.no/docs/thinfilm-nfc-barcode-datasheet.pdf">
 *      Thinfilm NFC Barcode tag specification (previously Kovio NFC Barcode)</a>
 * @see <a href="http://www.thinfilm.no/docs/thinfilm-nfc-barcode-data-format.pdf">
 *      Thinfilm NFC Barcode data format (previously Kovio NFC Barcode)</a>
 * @apiSince 17
 */

public byte[] getBarcode() { throw new RuntimeException("Stub!"); }

public boolean isConnected() { throw new RuntimeException("Stub!"); }

public android.nfc.Tag getTag() { throw new RuntimeException("Stub!"); }

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public void connect() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Kovio Tags
 * @apiSince 17
 */

public static final int TYPE_KOVIO = 1; // 0x1

/** @apiSince 17 */

public static final int TYPE_UNKNOWN = -1; // 0xffffffff
}

