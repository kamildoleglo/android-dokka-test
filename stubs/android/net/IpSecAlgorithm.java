/*
 * Copyright (C) 2017 The Android Open Source Project
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

package android.net;

import android.os.Parcelable;

/**
 * This class represents a single algorithm that can be used by an {@link android.net.IpSecTransform IpSecTransform}.
 *
 * @see <a href="https://tools.ietf.org/html/rfc4301">RFC 4301, Security Architecture for the
 * Internet Protocol</a>
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class IpSecAlgorithm implements android.os.Parcelable {

/**
 * Creates an IpSecAlgorithm of one of the supported types. Supported algorithm names are
 * defined as constants in this class.
 *
 * <p>For algorithms that produce an integrity check value, the truncation length is a required
 * parameter. See {@link #IpSecAlgorithm(java.lang.String,byte[] key,int truncLenBits)}
 *
 * @param algorithm name of the algorithm.
 * This value must never be {@code null}.
 * Value is {@link android.net.IpSecAlgorithm#CRYPT_AES_CBC}, {@link android.net.IpSecAlgorithm#AUTH_HMAC_MD5}, {@link android.net.IpSecAlgorithm#AUTH_HMAC_SHA1}, {@link android.net.IpSecAlgorithm#AUTH_HMAC_SHA256}, {@link android.net.IpSecAlgorithm#AUTH_HMAC_SHA384}, {@link android.net.IpSecAlgorithm#AUTH_HMAC_SHA512}, or {@link android.net.IpSecAlgorithm#AUTH_CRYPT_AES_GCM}
 * @param key key padded to a multiple of 8 bits.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public IpSecAlgorithm(@androidx.annotation.NonNull java.lang.String algorithm, @androidx.annotation.NonNull byte[] key) { throw new RuntimeException("Stub!"); }

/**
 * Creates an IpSecAlgorithm of one of the supported types. Supported algorithm names are
 * defined as constants in this class.
 *
 * <p>This constructor only supports algorithms that use a truncation length. i.e.
 * Authentication and Authenticated Encryption algorithms.
 *
 * @param algorithm name of the algorithm.
 * This value must never be {@code null}.
 * Value is {@link android.net.IpSecAlgorithm#CRYPT_AES_CBC}, {@link android.net.IpSecAlgorithm#AUTH_HMAC_MD5}, {@link android.net.IpSecAlgorithm#AUTH_HMAC_SHA1}, {@link android.net.IpSecAlgorithm#AUTH_HMAC_SHA256}, {@link android.net.IpSecAlgorithm#AUTH_HMAC_SHA384}, {@link android.net.IpSecAlgorithm#AUTH_HMAC_SHA512}, or {@link android.net.IpSecAlgorithm#AUTH_CRYPT_AES_GCM}
 * @param key key padded to a multiple of 8 bits.
 * This value must never be {@code null}.
 * @param truncLenBits number of bits of output hash to use.
 * @apiSince 28
 */

public IpSecAlgorithm(@androidx.annotation.NonNull java.lang.String algorithm, @androidx.annotation.NonNull byte[] key, int truncLenBits) { throw new RuntimeException("Stub!"); }

/**
 * Get the algorithm name
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Get the key for this algorithm
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public byte[] getKey() { throw new RuntimeException("Stub!"); }

/**
 * Get the truncation length of this algorithm, in bits
 * @apiSince 28
 */

public int getTruncationLengthBits() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Write to parcel
 * @apiSince 28
 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * AES-GCM Authentication/Integrity + Encryption/Ciphering Algorithm.
 *
 * <p>Valid lengths for keying material are {160, 224, 288}.
 *
 * <p>As per <a href="https://tools.ietf.org/html/rfc4106#section-8.1">RFC4106 (Section
 * 8.1)</a>, keying material consists of a 128, 192, or 256 bit AES key followed by a 32-bit
 * salt. RFC compliance requires that the salt must be unique per invocation with the same key.
 *
 * <p>Valid ICV (truncation) lengths are {64, 96, 128}.
 * @apiSince 28
 */

public static final java.lang.String AUTH_CRYPT_AES_GCM = "rfc4106(gcm(aes))";

/**
 * MD5 HMAC Authentication/Integrity Algorithm. <b>This algorithm is not recommended for use in
 * new applications and is provided for legacy compatibility with 3gpp infrastructure.</b>
 *
 * <p>Keys for this algorithm must be 128 bits in length.
 *
 * <p>Valid truncation lengths are multiples of 8 bits from 96 to 128.
 * @apiSince 28
 */

public static final java.lang.String AUTH_HMAC_MD5 = "hmac(md5)";

/**
 * SHA1 HMAC Authentication/Integrity Algorithm. <b>This algorithm is not recommended for use in
 * new applications and is provided for legacy compatibility with 3gpp infrastructure.</b>
 *
 * <p>Keys for this algorithm must be 160 bits in length.
 *
 * <p>Valid truncation lengths are multiples of 8 bits from 96 to 160.
 * @apiSince 28
 */

public static final java.lang.String AUTH_HMAC_SHA1 = "hmac(sha1)";

/**
 * SHA256 HMAC Authentication/Integrity Algorithm.
 *
 * <p>Keys for this algorithm must be 256 bits in length.
 *
 * <p>Valid truncation lengths are multiples of 8 bits from 96 to 256.
 * @apiSince 28
 */

public static final java.lang.String AUTH_HMAC_SHA256 = "hmac(sha256)";

/**
 * SHA384 HMAC Authentication/Integrity Algorithm.
 *
 * <p>Keys for this algorithm must be 384 bits in length.
 *
 * <p>Valid truncation lengths are multiples of 8 bits from 192 to 384.
 * @apiSince 28
 */

public static final java.lang.String AUTH_HMAC_SHA384 = "hmac(sha384)";

/**
 * SHA512 HMAC Authentication/Integrity Algorithm.
 *
 * <p>Keys for this algorithm must be 512 bits in length.
 *
 * <p>Valid truncation lengths are multiples of 8 bits from 256 to 512.
 * @apiSince 28
 */

public static final java.lang.String AUTH_HMAC_SHA512 = "hmac(sha512)";

/**
 * Parcelable Creator
 * @apiSince 28
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.IpSecAlgorithm> CREATOR;
static { CREATOR = null; }

/**
 * AES-CBC Encryption/Ciphering Algorithm.
 *
 * <p>Valid lengths for this key are {128, 192, 256}.
 * @apiSince 28
 */

public static final java.lang.String CRYPT_AES_CBC = "cbc(aes)";
}

