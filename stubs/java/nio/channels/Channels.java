/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 2000, 2012, Oracle and/or its affiliates. All rights reserved.
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



package java.nio.channels;

import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.UnsupportedCharsetException;
import java.nio.charset.Charset;

/**
 * Utility methods for channels and streams.
 *
 * <p> This class defines static methods that support the interoperation of the
 * stream classes of the <tt>{@link java.io}</tt> package with the channel
 * classes of this package.  </p>
 *
 *
 * @author Mark Reinhold
 * @author Mike McCloskey
 * @author JSR-51 Expert Group
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Channels {

private Channels() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a stream that reads bytes from the given channel.
 *
 * <p> The <tt>read</tt> methods of the resulting stream will throw an
 * {@link java.nio.channels.IllegalBlockingModeException IllegalBlockingModeException} if invoked while the underlying
 * channel is in non-blocking mode.  The stream will not be buffered, and
 * it will not support the {@link java.io.InputStream#mark InputStream#mark} or {@link java.io.InputStream#reset InputStream#reset} methods.  The stream will be safe for access by
 * multiple concurrent threads.  Closing the stream will in turn cause the
 * channel to be closed.  </p>
 *
 * @param  ch
 *         The channel from which bytes will be read
 *
 * @return  A new input stream
 * @apiSince 1
 */

public static java.io.InputStream newInputStream(java.nio.channels.ReadableByteChannel ch) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a stream that writes bytes to the given channel.
 *
 * <p> The <tt>write</tt> methods of the resulting stream will throw an
 * {@link java.nio.channels.IllegalBlockingModeException IllegalBlockingModeException} if invoked while the underlying
 * channel is in non-blocking mode.  The stream will not be buffered.  The
 * stream will be safe for access by multiple concurrent threads.  Closing
 * the stream will in turn cause the channel to be closed.  </p>
 *
 * @param  ch
 *         The channel to which bytes will be written
 *
 * @return  A new output stream
 * @apiSince 1
 */

public static java.io.OutputStream newOutputStream(java.nio.channels.WritableByteChannel ch) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a stream that reads bytes from the given channel.
 *
 * <p> The stream will not be buffered, and it will not support the {@link java.io.InputStream#mark InputStream#mark} or {@link java.io.InputStream#reset InputStream#reset} methods.  The
 * stream will be safe for access by multiple concurrent threads.  Closing
 * the stream will in turn cause the channel to be closed.  </p>
 *
 * @param  ch
 *         The channel from which bytes will be read
 *
 * @return  A new input stream
 *
 * @since 1.7
 * @apiSince 26
 */

public static java.io.InputStream newInputStream(java.nio.channels.AsynchronousByteChannel ch) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a stream that writes bytes to the given channel.
 *
 * <p> The stream will not be buffered. The stream will be safe for access
 * by multiple concurrent threads.  Closing the stream will in turn cause
 * the channel to be closed.  </p>
 *
 * @param  ch
 *         The channel to which bytes will be written
 *
 * @return  A new output stream
 *
 * @since 1.7
 * @apiSince 26
 */

public static java.io.OutputStream newOutputStream(java.nio.channels.AsynchronousByteChannel ch) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a channel that reads bytes from the given stream.
 *
 * <p> The resulting channel will not be buffered; it will simply redirect
 * its I/O operations to the given stream.  Closing the channel will in
 * turn cause the stream to be closed.  </p>
 *
 * @param  in
 *         The stream from which bytes are to be read
 *
 * @return  A new readable byte channel
 * @apiSince 1
 */

public static java.nio.channels.ReadableByteChannel newChannel(java.io.InputStream in) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a channel that writes bytes to the given stream.
 *
 * <p> The resulting channel will not be buffered; it will simply redirect
 * its I/O operations to the given stream.  Closing the channel will in
 * turn cause the stream to be closed.  </p>
 *
 * @param  out
 *         The stream to which bytes are to be written
 *
 * @return  A new writable byte channel
 * @apiSince 1
 */

public static java.nio.channels.WritableByteChannel newChannel(java.io.OutputStream out) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a reader that decodes bytes from the given channel using the
 * given decoder.
 *
 * <p> The resulting stream will contain an internal input buffer of at
 * least <tt>minBufferCap</tt> bytes.  The stream's <tt>read</tt> methods
 * will, as needed, fill the buffer by reading bytes from the underlying
 * channel; if the channel is in non-blocking mode when bytes are to be
 * read then an {@link java.nio.channels.IllegalBlockingModeException IllegalBlockingModeException} will be thrown.  The
 * resulting stream will not otherwise be buffered, and it will not support
 * the {@link java.io.Reader#mark Reader#mark} or {@link java.io.Reader#reset Reader#reset} methods.
 * Closing the stream will in turn cause the channel to be closed.  </p>
 *
 * @param  ch
 *         The channel from which bytes will be read
 *
 * @param  dec
 *         The charset decoder to be used
 *
 * @param  minBufferCap
 *         The minimum capacity of the internal byte buffer,
 *         or <tt>-1</tt> if an implementation-dependent
 *         default capacity is to be used
 *
 * @return  A new reader
 * @apiSince 1
 */

public static java.io.Reader newReader(java.nio.channels.ReadableByteChannel ch, java.nio.charset.CharsetDecoder dec, int minBufferCap) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a reader that decodes bytes from the given channel according
 * to the named charset.
 *
 * <p> An invocation of this method of the form
 *
 * <blockquote><pre>
 * Channels.newReader(ch, csname)</pre></blockquote>
 *
 * behaves in exactly the same way as the expression
 *
 * <blockquote><pre>
 * Channels.newReader(ch,
 *                    Charset.forName(csName)
 *                        .newDecoder(),
 *                    -1);</pre></blockquote>
 *
 * @param  ch
 *         The channel from which bytes will be read
 *
 * @param  csName
 *         The name of the charset to be used
 *
 * @return  A new reader
 *
 * @throws  java.nio.charset.UnsupportedCharsetException
 *          If no support for the named charset is available
 *          in this instance of the Java virtual machine
 * @apiSince 1
 */

public static java.io.Reader newReader(java.nio.channels.ReadableByteChannel ch, java.lang.String csName) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a writer that encodes characters using the given encoder and
 * writes the resulting bytes to the given channel.
 *
 * <p> The resulting stream will contain an internal output buffer of at
 * least <tt>minBufferCap</tt> bytes.  The stream's <tt>write</tt> methods
 * will, as needed, flush the buffer by writing bytes to the underlying
 * channel; if the channel is in non-blocking mode when bytes are to be
 * written then an {@link java.nio.channels.IllegalBlockingModeException IllegalBlockingModeException} will be thrown.
 * The resulting stream will not otherwise be buffered.  Closing the stream
 * will in turn cause the channel to be closed.  </p>
 *
 * @param  ch
 *         The channel to which bytes will be written
 *
 * @param  enc
 *         The charset encoder to be used
 *
 * @param  minBufferCap
 *         The minimum capacity of the internal byte buffer,
 *         or <tt>-1</tt> if an implementation-dependent
 *         default capacity is to be used
 *
 * @return  A new writer
 * @apiSince 1
 */

public static java.io.Writer newWriter(java.nio.channels.WritableByteChannel ch, java.nio.charset.CharsetEncoder enc, int minBufferCap) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a writer that encodes characters according to the named
 * charset and writes the resulting bytes to the given channel.
 *
 * <p> An invocation of this method of the form
 *
 * <blockquote><pre>
 * Channels.newWriter(ch, csname)</pre></blockquote>
 *
 * behaves in exactly the same way as the expression
 *
 * <blockquote><pre>
 * Channels.newWriter(ch,
 *                    Charset.forName(csName)
 *                        .newEncoder(),
 *                    -1);</pre></blockquote>
 *
 * @param  ch
 *         The channel to which bytes will be written
 *
 * @param  csName
 *         The name of the charset to be used
 *
 * @return  A new writer
 *
 * @throws  java.nio.charset.UnsupportedCharsetException
 *          If no support for the named charset is available
 *          in this instance of the Java virtual machine
 * @apiSince 1
 */

public static java.io.Writer newWriter(java.nio.channels.WritableByteChannel ch, java.lang.String csName) { throw new RuntimeException("Stub!"); }
}

