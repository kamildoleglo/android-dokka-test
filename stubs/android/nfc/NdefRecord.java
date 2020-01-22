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


package android.nfc;

import android.net.Uri;
import android.content.Intent;

/**
 * Represents an immutable NDEF Record.
 * <p>
 * NDEF (NFC Data Exchange Format) is a light-weight binary format,
 * used to encapsulate typed data. It is specified by the NFC Forum,
 * for transmission and storage with NFC, however it is transport agnostic.
 * <p>
 * NDEF defines messages and records. An NDEF Record contains
 * typed data, such as MIME-type media, a URI, or a custom
 * application payload. An NDEF Message is a container for
 * one or more NDEF Records.
 * <p>
 * This class represents logical (complete) NDEF Records, and can not be
 * used to represent chunked (partial) NDEF Records. However
 * {@link android.nfc.NdefMessage#NdefMessage(byte[]) NdefMessage#NdefMessage(byte[])} can be used to parse a message
 * containing chunked records, and will return a message with unchunked
 * (complete) records.
 * <p>
 * A logical NDEF Record always contains a 3-bit TNF (Type Name Field)
 * that provides high level typing for the rest of the record. The
 * remaining fields are variable length and not always present:
 * <ul>
 * <li><em>type</em>: detailed typing for the payload</li>
 * <li><em>id</em>: identifier meta-data, not commonly used</li>
 * <li><em>payload</em>: the actual payload</li>
 * </ul>
 * <p>
 * Helpers such as {@link android.nfc.NdefRecord#createUri NdefRecord#createUri}, {@link android.nfc.NdefRecord#createMime NdefRecord#createMime}
 * and {@link android.nfc.NdefRecord#createExternal NdefRecord#createExternal} are included to create well-formatted
 * NDEF Records with correctly set tnf, type, id and payload fields, please
 * use these helpers whenever possible.
 * <p>
 * Use the constructor {@link #NdefRecord(short,byte[],byte[],byte[])}
 * if you know what you are doing and what to set the fields individually.
 * Only basic validation is performed with this constructor, so it is possible
 * to create records that do not confirm to the strict NFC Forum
 * specifications.
 * <p>
 * The binary representation of an NDEF Record includes additional flags to
 * indicate location with an NDEF message, provide support for chunking of
 * NDEF records, and to pack optional fields. This class does not expose
 * those details. To write an NDEF Record as binary you must first put it
 * into an {@link android.nfc.NdefMessage NdefMessage}, then call {@link android.nfc.NdefMessage#toByteArray() NdefMessage#toByteArray()}.
 * <p class="note">
 * {@link android.nfc.NdefMessage NdefMessage} and {@link android.nfc.NdefRecord NdefRecord} implementations are
 * always available, even on Android devices that do not have NFC hardware.
 * <p class="note">
 * {@link android.nfc.NdefRecord NdefRecord}s are intended to be immutable (and thread-safe),
 * however they may contain mutable fields. So take care not to modify
 * mutable fields passed into constructors, or modify mutable fields
 * obtained by getter methods, unless such modification is explicitly
 * marked as safe.
 *
 * @see android.nfc.NfcAdapter#ACTION_NDEF_DISCOVERED
 * @see android.nfc.NdefMessage
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NdefRecord implements android.os.Parcelable {

/**
 * Construct an NDEF Record from its component fields.<p>
 * Recommend to use helpers such as {#createUri} or
 * {{@link #createExternal} where possible, since they perform
 * stricter validation that the record is correctly formatted
 * as per NDEF specifications. However if you know what you are
 * doing then this constructor offers the most flexibility.<p>
 * An {@link android.nfc.NdefRecord NdefRecord} represents a logical (complete)
 * record, and cannot represent NDEF Record chunks.<p>
 * Basic validation of the tnf, type, id and payload is performed
 * as per the following rules:
 * <ul>
 * <li>The tnf paramter must be a 3-bit value.</li>
 * <li>Records with a tnf of {@link #TNF_EMPTY} cannot have a type,
 * id or payload.</li>
 * <li>Records with a tnf of {@link #TNF_UNKNOWN} or {@literal 0x07}
 * cannot have a type.</li>
 * <li>Records with a tnf of {@link #TNF_UNCHANGED} are not allowed
 * since this class only represents complete (unchunked) records.</li>
 * </ul>
 * This minimal validation is specified by
 * NFCForum-TS-NDEF_1.0 section 3.2.6 (Type Name Format).<p>
 * If any of the above validation
 * steps fail then {@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown.<p>
 * Deep inspection of the type, id and payload fields is not
 * performed, so it is possible to create NDEF Records
 * that conform to section 3.2.6
 * but fail other more strict NDEF specification requirements. For
 * example, the payload may be invalid given the tnf and type.
 * <p>
 * To omit a type, id or payload field, set the parameter to an
 * empty byte array or null.
 *
 * @param tnf  a 3-bit TNF constant
 * @param type byte array, containing zero to 255 bytes, or null
 * @param id   byte array, containing zero to 255 bytes, or null
 * @param payload byte array, containing zero to (2 ** 32 - 1) bytes,
 *                or null
 * @throws IllegalArugmentException if a valid record cannot be created
 * @apiSince 9
 */

public NdefRecord(short tnf, byte[] type, byte[] id, byte[] payload) { throw new RuntimeException("Stub!"); }

/**
 * Construct an NDEF Record from raw bytes.<p>
 * This method is deprecated, use {@link android.nfc.NdefMessage#NdefMessage(byte[]) NdefMessage#NdefMessage(byte[])}
 * instead. This is because it does not make sense to parse a record:
 * the NDEF binary format is only defined for a message, and the
 * record flags MB and ME do not make sense outside of the context of
 * an entire message.<p>
 * This implementation will attempt to parse a single record by ignoring
 * the MB and ME flags, and otherwise following the rules of
 * {@link android.nfc.NdefMessage#NdefMessage(byte[]) NdefMessage#NdefMessage(byte[])}.<p>
 *
 * @param data raw bytes to parse
 * @throws android.nfc.FormatException if the data cannot be parsed into a valid record
 * @deprecated use {@link android.nfc.NdefMessage#NdefMessage(byte[]) NdefMessage#NdefMessage(byte[])} instead.
 * @apiSince 9
 */

@Deprecated
public NdefRecord(byte[] data) throws android.nfc.FormatException { throw new RuntimeException("Stub!"); }

/**
 * Create a new Android Application Record (AAR).
 * <p>
 * This record indicates to other Android devices the package
 * that should be used to handle the entire NDEF message.
 * You can embed this record anywhere into your message
 * to ensure that the intended package receives the message.
 * <p>
 * When an Android device dispatches an {@link android.nfc.NdefMessage NdefMessage}
 * containing one or more Android application records,
 * the applications contained in those records will be the
 * preferred target for the {@link android.nfc.NfcAdapter#ACTION_NDEF_DISCOVERED NfcAdapter#ACTION_NDEF_DISCOVERED}
 * intent, in the order in which they appear in the message.
 * This dispatch behavior was first added to Android in
 * Ice Cream Sandwich.
 * <p>
 * If none of the applications have a are installed on the device,
 * a Market link will be opened to the first application.
 * <p>
 * Note that Android application records do not overrule
 * applications that have called
 * {@link android.nfc.NfcAdapter#enableForegroundDispatch NfcAdapter#enableForegroundDispatch}.
 *
 * @param packageName Android package name
 * @return Android application NDEF record
 * @apiSince 14
 */

public static android.nfc.NdefRecord createApplicationRecord(java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Create a new NDEF Record containing a URI.<p>
 * Use this method to encode a URI (or URL) into an NDEF Record.<p>
 * Uses the well known URI type representation: {@link #TNF_WELL_KNOWN}
 * and {@link #RTD_URI}. This is the most efficient encoding
 * of a URI into NDEF.<p>
 * The uri parameter will be normalized with
 * {@link android.net.Uri#normalizeScheme Uri#normalizeScheme} to set the scheme to lower case to
 * follow Android best practices for intent filtering.
 * However the unchecked exception
 * {@link java.lang.IllegalArgumentException IllegalArgumentException} may be thrown if the uri
 * parameter has serious problems, for example if it is empty, so always
 * catch this exception if you are passing user-generated data into this
 * method.<p>
 *
 * Reference specification: NFCForum-TS-RTD_URI_1.0
 *
 * @param uri URI to encode.
 * @return an NDEF Record containing the URI
 * @throws IllegalArugmentException if the uri is empty or invalid
 * @apiSince 14
 */

public static android.nfc.NdefRecord createUri(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Create a new NDEF Record containing a URI.<p>
 * Use this method to encode a URI (or URL) into an NDEF Record.<p>
 * Uses the well known URI type representation: {@link #TNF_WELL_KNOWN}
 * and {@link #RTD_URI}. This is the most efficient encoding
 * of a URI into NDEF.<p>
 * The uriString parameter will be normalized with
 * {@link android.net.Uri#normalizeScheme Uri#normalizeScheme} to set the scheme to lower case to
 * follow Android best practices for intent filtering.
 * However the unchecked exception
 * {@link java.lang.IllegalArgumentException IllegalArgumentException} may be thrown if the uriString
 * parameter has serious problems, for example if it is empty, so always
 * catch this exception if you are passing user-generated data into this
 * method.<p>
 *
 * Reference specification: NFCForum-TS-RTD_URI_1.0
 *
 * @param uriString string URI to encode.
 * @return an NDEF Record containing the URI
 * @throws IllegalArugmentException if the uriString is empty or invalid
 * @apiSince 14
 */

public static android.nfc.NdefRecord createUri(java.lang.String uriString) { throw new RuntimeException("Stub!"); }

/**
 * Create a new NDEF Record containing MIME data.<p>
 * Use this method to encode MIME-typed data into an NDEF Record,
 * such as "text/plain", or "image/jpeg".<p>
 * The mimeType parameter will be normalized with
 * {@link android.content.Intent#normalizeMimeType Intent#normalizeMimeType} to follow Android best
 * practices for intent filtering, for example to force lower-case.
 * However the unchecked exception
 * {@link java.lang.IllegalArgumentException IllegalArgumentException} may be thrown
 * if the mimeType parameter has serious problems,
 * for example if it is empty, so always catch this
 * exception if you are passing user-generated data into this method.
 * <p>
 * For efficiency, This method might not make an internal copy of the
 * mimeData byte array, so take care not
 * to modify the mimeData byte array while still using the returned
 * NdefRecord.
 *
 * @param mimeType a valid MIME type
 * @param mimeData MIME data as bytes
 * @return an NDEF Record containing the MIME-typed data
 * @throws IllegalArugmentException if the mimeType is empty or invalid
 *
 * @apiSince 16
 */

public static android.nfc.NdefRecord createMime(java.lang.String mimeType, byte[] mimeData) { throw new RuntimeException("Stub!"); }

/**
 * Create a new NDEF Record containing external (application-specific) data.<p>
 * Use this method to encode application specific data into an NDEF Record.
 * The data is typed by a domain name (usually your Android package name) and
 * a domain-specific type. This data is packaged into a "NFC Forum External
 * Type" NDEF Record.<p>
 * NFC Forum requires that the domain and type used in an external record
 * are treated as case insensitive, however Android intent filtering is
 * always case sensitive. So this method will force the domain and type to
 * lower-case before creating the NDEF Record.<p>
 * The unchecked exception {@link java.lang.IllegalArgumentException IllegalArgumentException} will be thrown
 * if the domain and type have serious problems, for example if either field
 * is empty, so always catch this
 * exception if you are passing user-generated data into this method.<p>
 * There are no such restrictions on the payload data.<p>
 * For efficiency, This method might not make an internal copy of the
 * data byte array, so take care not
 * to modify the data byte array while still using the returned
 * NdefRecord.
 *
 * Reference specification: NFCForum-TS-RTD_1.0
 * @param domain domain-name of issuing organization
 * @param type domain-specific type of data
 * @param data payload as bytes
 * @throws IllegalArugmentException if either domain or type are empty or invalid
 * @apiSince 16
 */

public static android.nfc.NdefRecord createExternal(java.lang.String domain, java.lang.String type, byte[] data) { throw new RuntimeException("Stub!"); }

/**
 * Create a new NDEF record containing UTF-8 text data.<p>
 *
 * The caller can either specify the language code for the provided text,
 * or otherwise the language code corresponding to the current default
 * locale will be used.
 *
 * Reference specification: NFCForum-TS-RTD_Text_1.0
 * @param languageCode The languageCode for the record. If locale is empty or null,
 *                     the language code of the current default locale will be used.
 * @param text   The text to be encoded in the record. Will be represented in UTF-8 format.
 * @throws java.lang.IllegalArgumentException if text is null
 * @apiSince 21
 */

public static android.nfc.NdefRecord createTextRecord(java.lang.String languageCode, java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Returns the 3-bit TNF.
 * <p>
 * TNF is the top-level type.
 * @apiSince 9
 */

public short getTnf() { throw new RuntimeException("Stub!"); }

/**
 * Returns the variable length Type field.
 * <p>
 * This should be used in conjunction with the TNF field to determine the
 * payload format.
 * <p>
 * Returns an empty byte array if this record
 * does not have a type field.
 * @apiSince 9
 */

public byte[] getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the variable length ID.
 * <p>
 * Returns an empty byte array if this record
 * does not have an id field.
 * @apiSince 9
 */

public byte[] getId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the variable length payload.
 * <p>
 * Returns an empty byte array if this record
 * does not have a payload field.
 * @apiSince 9
 */

public byte[] getPayload() { throw new RuntimeException("Stub!"); }

/**
 * Return this NDEF Record as a byte array.<p>
 * This method is deprecated, use {@link android.nfc.NdefMessage#toByteArray NdefMessage#toByteArray}
 * instead. This is because the NDEF binary format is not defined for
 * a record outside of the context of a message: the MB and ME flags
 * cannot be set without knowing the location inside a message.<p>
 * This implementation will attempt to serialize a single record by
 * always setting the MB and ME flags (in other words, assume this
 * is a single-record NDEF Message).<p>
 *
 * @deprecated use {@link android.nfc.NdefMessage#toByteArray() NdefMessage#toByteArray()} instead
 * @apiSince 9
 * @deprecatedSince 16
 */

@Deprecated
public byte[] toByteArray() { throw new RuntimeException("Stub!"); }

/**
 * Map this record to a MIME type, or return null if it cannot be mapped.<p>
 * Currently this method considers all {@link #TNF_MIME_MEDIA} records to
 * be MIME records, as well as some {@link #TNF_WELL_KNOWN} records such as
 * {@link #RTD_TEXT}. If this is a MIME record then the MIME type as string
 * is returned, otherwise null is returned.<p>
 * This method does not perform validation that the MIME type is
 * actually valid. It always attempts to
 * return a string containing the type if this is a MIME record.<p>
 * The returned MIME type will by normalized to lower-case using
 * {@link android.content.Intent#normalizeMimeType Intent#normalizeMimeType}.<p>
 * The MIME payload can be obtained using {@link #getPayload}.
 *
 * @return MIME type as a string, or null if this is not a MIME record
 * @apiSince 16
 */

public java.lang.String toMimeType() { throw new RuntimeException("Stub!"); }

/**
 * Map this record to a URI, or return null if it cannot be mapped.<p>
 * Currently this method considers the following to be URI records:
 * <ul>
 * <li>{@link #TNF_ABSOLUTE_URI} records.</li>
 * <li>{@link #TNF_WELL_KNOWN} with a type of {@link #RTD_URI}.</li>
 * <li>{@link #TNF_WELL_KNOWN} with a type of {@link #RTD_SMART_POSTER}
 * and containing a URI record in the NDEF message nested in the payload.
 * </li>
 * <li>{@link #TNF_EXTERNAL_TYPE} records.</li>
 * </ul>
 * If this is not a URI record by the above rules, then null is returned.<p>
 * This method does not perform validation that the URI is
 * actually valid: it always attempts to create and return a URI if
 * this record appears to be a URI record by the above rules.<p>
 * The returned URI will be normalized to have a lower case scheme
 * using {@link android.net.Uri#normalizeScheme Uri#normalizeScheme}.<p>
 *
 * @return URI, or null if this is not a URI record
 * @apiSince 16
 */

public android.net.Uri toUri() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the specified NDEF Record contains
 * identical tnf, type, id and payload fields.
 * @apiSince 9
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.nfc.NdefRecord> CREATOR;
static { CREATOR = null; }

/**
 * RTD Alternative Carrier type. For use with {@literal TNF_WELL_KNOWN}.
 * @see #TNF_WELL_KNOWN
 * @apiSince 9
 */

public static final byte[] RTD_ALTERNATIVE_CARRIER;
static { RTD_ALTERNATIVE_CARRIER = new byte[0]; }

/**
 * RTD Handover Carrier type. For use with {@literal TNF_WELL_KNOWN}.
 * @see #TNF_WELL_KNOWN
 * @apiSince 9
 */

public static final byte[] RTD_HANDOVER_CARRIER;
static { RTD_HANDOVER_CARRIER = new byte[0]; }

/**
 * RTD Handover Request type. For use with {@literal TNF_WELL_KNOWN}.
 * @see #TNF_WELL_KNOWN
 * @apiSince 9
 */

public static final byte[] RTD_HANDOVER_REQUEST;
static { RTD_HANDOVER_REQUEST = new byte[0]; }

/**
 * RTD Handover Select type. For use with {@literal TNF_WELL_KNOWN}.
 * @see #TNF_WELL_KNOWN
 * @apiSince 9
 */

public static final byte[] RTD_HANDOVER_SELECT;
static { RTD_HANDOVER_SELECT = new byte[0]; }

/**
 * RTD Smart Poster type. For use with {@literal TNF_WELL_KNOWN}.
 * @see #TNF_WELL_KNOWN
 * @apiSince 9
 */

public static final byte[] RTD_SMART_POSTER;
static { RTD_SMART_POSTER = new byte[0]; }

/**
 * RTD Text type. For use with {@literal TNF_WELL_KNOWN}.
 * @see #TNF_WELL_KNOWN
 * @apiSince 9
 */

public static final byte[] RTD_TEXT;
static { RTD_TEXT = new byte[0]; }

/**
 * RTD URI type. For use with {@literal TNF_WELL_KNOWN}.
 * @see #TNF_WELL_KNOWN
 * @apiSince 9
 */

public static final byte[] RTD_URI;
static { RTD_URI = new byte[0]; }

/**
 * Indicates the type field contains an absolute-URI
 * BNF construct defined by RFC 3986.<p>
 * When creating new records prefer {@link #createUri},
 * since it offers more compact URI encoding
 * ({@literal #RTD_URI} allows compression of common URI prefixes).
 *
 * @see #createUri
 * @apiSince 9
 */

public static final short TNF_ABSOLUTE_URI = 3; // 0x3

/**
 * Indicates the record is empty.<p>
 * Type, id and payload fields are empty in a {@literal TNF_EMPTY} record.
 * @apiSince 9
 */

public static final short TNF_EMPTY = 0; // 0x0

/**
 * Indicates the type field contains an external type name.<p>
 * Used to encode custom payloads. When creating new records
 * use the helper {@link #createExternal}.<p>
 * The external-type RTD format is specified in NFCForum-TS-RTD_1.0.<p>
 * <p>
 * Note this TNF should not be used with RTD_TEXT or RTD_URI constants.
 * Those are well known RTD constants, not external RTD constants.
 *
 * @see #createExternal
 * @apiSince 9
 */

public static final short TNF_EXTERNAL_TYPE = 4; // 0x4

/**
 * Indicates the type field contains a media-type BNF
 * construct, defined by RFC 2046.<p>
 * Use this with MIME type names such as {@literal "image/jpeg"}, or
 * using the helper {@link #createMime}.
 *
 * @see #createMime
 * @apiSince 9
 */

public static final short TNF_MIME_MEDIA = 2; // 0x2

/**
 * Indicates the payload is an intermediate or final chunk of a chunked
 * NDEF Record.<p>
 * {@literal TNF_UNCHANGED} can not be used with this class
 * since all {@link android.nfc.NdefRecord NdefRecord}s are already unchunked, however they
 * may appear in the binary format.
 * @apiSince 9
 */

public static final short TNF_UNCHANGED = 6; // 0x6

/**
 * Indicates the payload type is unknown.<p>
 * NFC Forum explains this should be treated similarly to the
 * "application/octet-stream" MIME type. The payload
 * type is not explicitly encoded within the record.
 * <p>
 * The type field is empty in an {@literal TNF_UNKNOWN} record.
 * @apiSince 9
 */

public static final short TNF_UNKNOWN = 5; // 0x5

/**
 * Indicates the type field contains a well-known RTD type name.<p>
 * Use this tnf with RTD types such as {@link #RTD_TEXT}, {@link #RTD_URI}.
 * <p>
 * The RTD type name format is specified in NFCForum-TS-RTD_1.0.
 *
 * @see #RTD_URI
 * @see #RTD_TEXT
 * @see #RTD_SMART_POSTER
 * @see #createUri
 * @apiSince 9
 */

public static final short TNF_WELL_KNOWN = 1; // 0x1
}

