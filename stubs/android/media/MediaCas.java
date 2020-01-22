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


package android.media;

import android.media.MediaCasException;

/**
 * MediaCas can be used to obtain keys for descrambling protected media streams, in
 * conjunction with {@link android.media.MediaDescrambler}. The MediaCas APIs are
 * designed to support conditional access such as those in the ISO/IEC13818-1.
 * The CA system is identified by a 16-bit integer CA_system_id. The scrambling
 * algorithms are usually proprietary and implemented by vendor-specific CA plugins
 * installed on the device.
 * <p>
 * The app is responsible for constructing a MediaCas object for the CA system it
 * intends to use. The app can query if a certain CA system is supported using static
 * method {@link #isSystemIdSupported}. It can also obtain the entire list of supported
 * CA systems using static method {@link #enumeratePlugins}.
 * <p>
 * Once the MediaCas object is constructed, the app should properly provision it by
 * using method {@link #provision} and/or {@link #processEmm}. The EMMs (Entitlement
 * management messages) can be distributed out-of-band, or in-band with the stream.
 * <p>
 * To descramble elementary streams, the app first calls {@link #openSession} to
 * generate a {@link android.media.MediaCas.Session Session} object that will uniquely identify a session. A session
 * provides a context for subsequent key updates and descrambling activities. The ECMs
 * (Entitlement control messages) are sent to the session via method
 * {@link android.media.MediaCas.Session#processEcm Session#processEcm}.
 * <p>
 * The app next constructs a MediaDescrambler object, and initializes it with the
 * session using {@link android.media.MediaDescrambler#setMediaCasSession MediaDescrambler#setMediaCasSession}. This ties the
 * descrambler to the session, and the descrambler can then be used to descramble
 * content secured with the session's key, either during extraction, or during decoding
 * with {@link android.media.MediaCodec}.
 * <p>
 * If the app handles sample extraction using its own extractor, it can use
 * MediaDescrambler to descramble samples into clear buffers (if the session's license
 * doesn't require secure decoders), or descramble a small amount of data to retrieve
 * information necessary for the downstream pipeline to process the sample (if the
 * session's license requires secure decoders).
 * <p>
 * If the session requires a secure decoder, a MediaDescrambler needs to be provided to
 * MediaCodec to descramble samples queued by {@link android.media.MediaCodec#queueSecureInputBuffer MediaCodec#queueSecureInputBuffer}
 * into protected buffers. The app should use {@link android.media.MediaCodec#configure(android.media.MediaFormat,android.view.Surface,int,android.media.MediaDescrambler) MediaCodec#configure(MediaFormat,
 * android.view.Surface, int, MediaDescrambler)} instead of the normal {@link android.media.MediaCodec#configure(android.media.MediaFormat,android.view.Surface,android.media.MediaCrypto,int) MediaCodec#configure(MediaFormat, android.view.Surface, MediaCrypto, int)} method
 * to configure MediaCodec.
 * <p>
 * <h3>Using Android's MediaExtractor</h3>
 * <p>
 * If the app uses {@link android.media.MediaExtractor MediaExtractor}, it can delegate the CAS session
 * management to MediaExtractor by calling {@link android.media.MediaExtractor#setMediaCas MediaExtractor#setMediaCas}.
 * MediaExtractor will take over and call {@link #openSession}, {@link #processEmm}
 * and/or {@link android.media.MediaCas.Session#processEcm Session#processEcm}, etc.. if necessary.
 * <p>
 * When using {@link android.media.MediaExtractor MediaExtractor}, the app would still need a MediaDescrambler
 * to use with {@link android.media.MediaCodec MediaCodec} if the licensing requires a secure decoder. The
 * session associated with the descrambler of a track can be retrieved by calling
 * {@link android.media.MediaExtractor#getCasInfo MediaExtractor#getCasInfo}, and used to initialize a MediaDescrambler
 * object for MediaCodec.
 * <p>
 * <h3>Listeners</h3>
 * <p>The app may register a listener to receive events from the CA system using
 * method {@link #setEventListener}. The exact format of the event is scheme-specific
 * and is not specified by this API.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaCas implements java.lang.AutoCloseable {

/**
 * Instantiate a CA system of the specified system id.
 *
 * @param CA_system_id The system id of the CA system.
 *
 * @throws android.media.MediaCasException.UnsupportedCasException if the device does not support the
 * specified CA system.
 * @apiSince 26
 */

public MediaCas(int CA_system_id) throws android.media.MediaCasException.UnsupportedCasException { throw new RuntimeException("Stub!"); }

/**
 * Query if a certain CA system is supported on this device.
 *
 * @param CA_system_id the id of the CA system.
 *
 * @return Whether the specified CA system is supported on this device.
 * @apiSince 26
 */

public static boolean isSystemIdSupported(int CA_system_id) { throw new RuntimeException("Stub!"); }

/**
 * List all available CA plugins on the device.
 *
 * @return an array of descriptors for the available CA plugins.
 * @apiSince 26
 */

public static android.media.MediaCas.PluginDescriptor[] enumeratePlugins() { throw new RuntimeException("Stub!"); }

/**
 * Set an event listener to receive notifications from the MediaCas instance.
 *
 * @param listener the event listener to be set.
 * This value may be {@code null}.
 * @param handler the handler whose looper the event listener will be called on.
 * If handler is null, we'll try to use current thread's looper, or the main
 * looper. If neither are available, an internal thread will be created instead.
 
 * This value may be {@code null}.
 * @apiSince 26
 */

public void setEventListener(@androidx.annotation.Nullable android.media.MediaCas.EventListener listener, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Send the private data for the CA system.
 *
 * @param data byte array of the private data.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if the MediaCas instance is not valid.
 * @throws android.media.MediaCasException for CAS-specific errors.
 * @throws android.media.MediaCasStateException for CAS-specific state exceptions.
 * @apiSince 26
 */

public void setPrivateData(@androidx.annotation.NonNull byte[] data) throws android.media.MediaCasException { throw new RuntimeException("Stub!"); }

/**
 * Open a session to descramble one or more streams scrambled by the
 * conditional access system.
 *
 * @return session the newly opened session.
 *
 * @throws java.lang.IllegalStateException if the MediaCas instance is not valid.
 * @throws android.media.MediaCasException for CAS-specific errors.
 * @throws android.media.MediaCasStateException for CAS-specific state exceptions.
 * @apiSince 26
 */

public android.media.MediaCas.Session openSession() throws android.media.MediaCasException { throw new RuntimeException("Stub!"); }

/**
 * Send a received EMM packet to the CA system.
 *
 * @param data byte array of the EMM data.
 * This value must never be {@code null}.
 * @param offset position within data where the EMM data begins.
 * @param length length of the data (starting from offset).
 *
 * @throws java.lang.IllegalStateException if the MediaCas instance is not valid.
 * @throws android.media.MediaCasException for CAS-specific errors.
 * @throws android.media.MediaCasStateException for CAS-specific state exceptions.
 * @apiSince 26
 */

public void processEmm(@androidx.annotation.NonNull byte[] data, int offset, int length) throws android.media.MediaCasException { throw new RuntimeException("Stub!"); }

/**
 * Send a received EMM packet to the CA system. This is similar to
 * {@link #processEmm(byte[],int,int)} except that the entire byte
 * array is sent.
 *
 * @param data byte array of the EMM data.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if the MediaCas instance is not valid.
 * @throws android.media.MediaCasException for CAS-specific errors.
 * @throws android.media.MediaCasStateException for CAS-specific state exceptions.
 * @apiSince 26
 */

public void processEmm(@androidx.annotation.NonNull byte[] data) throws android.media.MediaCasException { throw new RuntimeException("Stub!"); }

/**
 * Send an event to a CA system. The format of the event is scheme-specific
 * and is opaque to the framework.
 *
 * @param event an integer denoting a scheme-specific event to be sent.
 * @param arg a scheme-specific integer argument for the event.
 * @param data a byte array containing scheme-specific data for the event.
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalStateException if the MediaCas instance is not valid.
 * @throws android.media.MediaCasException for CAS-specific errors.
 * @throws android.media.MediaCasStateException for CAS-specific state exceptions.
 * @apiSince 26
 */

public void sendEvent(int event, int arg, @androidx.annotation.Nullable byte[] data) throws android.media.MediaCasException { throw new RuntimeException("Stub!"); }

/**
 * Initiate a provisioning operation for a CA system.
 *
 * @param provisionString string containing information needed for the
 * provisioning operation, the format of which is scheme and implementation
 * specific.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if the MediaCas instance is not valid.
 * @throws android.media.MediaCasException for CAS-specific errors.
 * @throws android.media.MediaCasStateException for CAS-specific state exceptions.
 * @apiSince 26
 */

public void provision(@androidx.annotation.NonNull java.lang.String provisionString) throws android.media.MediaCasException { throw new RuntimeException("Stub!"); }

/**
 * Notify the CA system to refresh entitlement keys.
 *
 * @param refreshType the type of the refreshment.
 * @param refreshData private data associated with the refreshment.
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalStateException if the MediaCas instance is not valid.
 * @throws android.media.MediaCasException for CAS-specific errors.
 * @throws android.media.MediaCasStateException for CAS-specific state exceptions.
 * @apiSince 26
 */

public void refreshEntitlements(int refreshType, @androidx.annotation.Nullable byte[] refreshData) throws android.media.MediaCasException { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void close() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

protected void finalize() { throw new RuntimeException("Stub!"); }
/**
 * An interface registered by the caller to {@link #setEventListener}
 * to receives scheme-specific notifications from a MediaCas instance.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface EventListener {

/**
 * Notify the listener of a scheme-specific event from the CA system.
 *
 * @param mediaCas the MediaCas object to receive this event.
 * This value must never be {@code null}.
 * @param event an integer whose meaning is scheme-specific.
 * @param arg an integer whose meaning is scheme-specific.
 * @param data a byte array of data whose format and meaning are
 * scheme-specific.
 
 * This value may be {@code null}.
 * @apiSince 26
 */

public void onEvent(@androidx.annotation.NonNull android.media.MediaCas mediaCas, int event, int arg, @androidx.annotation.Nullable byte[] data);

/**
 * Notify the listener of a scheme-specific session event from CA system.
 *
 * @param mediaCas the MediaCas object to receive this event.
 * This value must never be {@code null}.
 * @param session session object which the event is for.
 * This value must never be {@code null}.
 * @param event an integer whose meaning is scheme-specific.
 * @param arg an integer whose meaning is scheme-specific.
 * @param data a byte array of data whose format and meaning are
 * scheme-specific.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public default void onSessionEvent(@androidx.annotation.NonNull android.media.MediaCas mediaCas, @androidx.annotation.NonNull android.media.MediaCas.Session session, int event, int arg, @androidx.annotation.Nullable byte[] data) { throw new RuntimeException("Stub!"); }
}

/**
 * Describe a CAS plugin with its CA_system_ID and string name.
 *
 * Returned as results of {@link #enumeratePlugins}.
 *
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class PluginDescriptor {

PluginDescriptor() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int getSystemId() { throw new RuntimeException("Stub!"); }

/**
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

/**
 * Class for an open session with the CA system.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Session implements java.lang.AutoCloseable {

Session() { throw new RuntimeException("Stub!"); }

/**
 * Query if an object equal current Session object.
 *
 * @param obj an object to compare to current Session object.
 *
 * @return Whether input object equal current Session object.
 * @apiSince 26
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Set the private data for a session.
 *
 * @param data byte array of the private data.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if the MediaCas instance is not valid.
 * @throws android.media.MediaCasException for CAS-specific errors.
 * @throws android.media.MediaCasStateException for CAS-specific state exceptions.
 * @apiSince 26
 */

public void setPrivateData(@androidx.annotation.NonNull byte[] data) throws android.media.MediaCasException { throw new RuntimeException("Stub!"); }

/**
 * Send a received ECM packet to the specified session of the CA system.
 *
 * @param data byte array of the ECM data.
 * This value must never be {@code null}.
 * @param offset position within data where the ECM data begins.
 * @param length length of the data (starting from offset).
 *
 * @throws java.lang.IllegalStateException if the MediaCas instance is not valid.
 * @throws android.media.MediaCasException for CAS-specific errors.
 * @throws android.media.MediaCasStateException for CAS-specific state exceptions.
 * @apiSince 26
 */

public void processEcm(@androidx.annotation.NonNull byte[] data, int offset, int length) throws android.media.MediaCasException { throw new RuntimeException("Stub!"); }

/**
 * Send a received ECM packet to the specified session of the CA system.
 * This is similar to {@link android.media.MediaCas.Session#processEcm(byte[],int,int) Session#processEcm(byte[], int, int)}
 * except that the entire byte array is sent.
 *
 * @param data byte array of the ECM data.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if the MediaCas instance is not valid.
 * @throws android.media.MediaCasException for CAS-specific errors.
 * @throws android.media.MediaCasStateException for CAS-specific state exceptions.
 * @apiSince 26
 */

public void processEcm(@androidx.annotation.NonNull byte[] data) throws android.media.MediaCasException { throw new RuntimeException("Stub!"); }

/**
 * Send a session event to a CA system. The format of the event is
 * scheme-specific and is opaque to the framework.
 *
 * @param event an integer denoting a scheme-specific event to be sent.
 * @param arg a scheme-specific integer argument for the event.
 * @param data a byte array containing scheme-specific data for the event.
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalStateException if the MediaCas instance is not valid.
 * @throws android.media.MediaCasException for CAS-specific errors.
 * @throws android.media.MediaCasStateException for CAS-specific state exceptions.
 * @apiSince 29
 */

public void sendSessionEvent(int event, int arg, @androidx.annotation.Nullable byte[] data) throws android.media.MediaCasException { throw new RuntimeException("Stub!"); }

/**
 * Close the session.
 *
 * @throws java.lang.IllegalStateException if the MediaCas instance is not valid.
 * @throws android.media.MediaCasStateException for CAS-specific state exceptions.
 * @apiSince 26
 */

public void close() { throw new RuntimeException("Stub!"); }
}

}

