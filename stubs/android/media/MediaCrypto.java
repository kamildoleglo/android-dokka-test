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


package android.media;

import java.util.UUID;
import android.media.MediaCryptoException;

/**
 * MediaCrypto class can be used in conjunction with {@link android.media.MediaCodec}
 * to decode encrypted media data.
 *
 * Crypto schemes are assigned 16 byte UUIDs,
 * the method {@link #isCryptoSchemeSupported} can be used to query if a given
 * scheme is supported on the device.
 *
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaCrypto {

/**
 * Instantiate a MediaCrypto object and associate it with a MediaDrm session
 *
 * @param uuid The UUID of the crypto scheme.
 * This value must never be {@code null}.
 * @param sessionId The MediaDrm sessionId to associate with this
 * MediaCrypto session. The sessionId may be changed after the MediaCrypto
 * is created using {@link #setMediaDrmSession}
 
 * This value must never be {@code null}.
 * @apiSince 16
 */

public MediaCrypto(@androidx.annotation.NonNull java.util.UUID uuid, @androidx.annotation.NonNull byte[] sessionId) throws android.media.MediaCryptoException { throw new RuntimeException("Stub!"); }

/**
 * Query if the given scheme identified by its UUID is supported on
 * this device.
 * @param uuid The UUID of the crypto scheme.
 
 * This value must never be {@code null}.
 * @apiSince 16
 */

public static boolean isCryptoSchemeSupported(@androidx.annotation.NonNull java.util.UUID uuid) { throw new RuntimeException("Stub!"); }

/**
 * Query if the crypto scheme requires the use of a secure decoder
 * to decode data of the given mime type.
 * @param mime The mime type of the media data
 
 * This value must never be {@code null}.
 * @apiSince 16
 */

public native boolean requiresSecureDecoderComponent(@androidx.annotation.NonNull java.lang.String mime);

/**
 * Associate a MediaDrm session with this MediaCrypto instance.  The
 * MediaDrm session is used to securely load decryption keys for a
 * crypto scheme.  The crypto keys loaded through the MediaDrm session
 * may be selected for use during the decryption operation performed
 * by {@link android.media.MediaCodec#queueSecureInputBuffer} by specifying
 * their key ids in the {@link android.media.MediaCodec.CryptoInfo#key} field.
 * @param sessionId the MediaDrm sessionId to associate with this
 * MediaCrypto instance
 * This value must never be {@code null}.
 * @throws android.media.MediaCryptoException on failure to set the sessionId
 * @apiSince 23
 */

public native void setMediaDrmSession(@androidx.annotation.NonNull byte[] sessionId) throws android.media.MediaCryptoException;

/** @apiSince 16 */

protected void finalize() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public native void release();
}

