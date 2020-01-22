/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// $Id: StreamResult.java 829970 2009-10-26 21:15:29Z mrglavas $



package javax.xml.transform.stream;

import java.io.OutputStream;
import java.io.Writer;
import java.io.File;
import javax.xml.transform.Result;

/**
 * <p>Acts as an holder for a transformation result,
 * which may be XML, plain Text, HTML, or some other form of markup.</p>
 *
 * @author <a href="Jeff.Suttor@Sun.com">Jeff Suttor</a>
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StreamResult implements javax.xml.transform.Result {

/**
 * Zero-argument default constructor.
 * @apiSince 8
 */

public StreamResult() { throw new RuntimeException("Stub!"); }

/**
 * Construct a StreamResult from a byte stream.  Normally,
 * a stream should be used rather than a reader, so that
 * the transformer may use instructions contained in the
 * transformation instructions to control the encoding.
 *
 * @param outputStream A valid OutputStream reference.
 * @apiSince 8
 */

public StreamResult(java.io.OutputStream outputStream) { throw new RuntimeException("Stub!"); }

/**
 * Construct a StreamResult from a character stream.  Normally,
 * a stream should be used rather than a reader, so that
 * the transformer may use instructions contained in the
 * transformation instructions to control the encoding.  However,
 * there are times when it is useful to write to a character
 * stream, such as when using a StringWriter.
 *
 * @param writer  A valid Writer reference.
 * @apiSince 8
 */

public StreamResult(java.io.Writer writer) { throw new RuntimeException("Stub!"); }

/**
 * Construct a StreamResult from a URL.
 *
 * @param systemId Must be a String that conforms to the URI syntax.
 * @apiSince 8
 */

public StreamResult(java.lang.String systemId) { throw new RuntimeException("Stub!"); }

/**
 * Construct a StreamResult from a File.
 *
 * @param f Must a non-null File reference.
 * @apiSince 8
 */

public StreamResult(java.io.File f) { throw new RuntimeException("Stub!"); }

/**
 * Set the ByteStream that is to be written to.  Normally,
 * a stream should be used rather than a reader, so that
 * the transformer may use instructions contained in the
 * transformation instructions to control the encoding.
 *
 * @param outputStream A valid OutputStream reference.
 * @apiSince 8
 */

public void setOutputStream(java.io.OutputStream outputStream) { throw new RuntimeException("Stub!"); }

/**
 * Get the byte stream that was set with setOutputStream.
 *
 * @return The byte stream that was set with setOutputStream, or null
 * if setOutputStream or the ByteStream constructor was not called.
 * @apiSince 8
 */

public java.io.OutputStream getOutputStream() { throw new RuntimeException("Stub!"); }

/**
 * Set the writer that is to receive the result.  Normally,
 * a stream should be used rather than a writer, so that
 * the transformer may use instructions contained in the
 * transformation instructions to control the encoding.  However,
 * there are times when it is useful to write to a writer,
 * such as when using a StringWriter.
 *
 * @param writer  A valid Writer reference.
 * @apiSince 8
 */

public void setWriter(java.io.Writer writer) { throw new RuntimeException("Stub!"); }

/**
 * Get the character stream that was set with setWriter.
 *
 * @return The character stream that was set with setWriter, or null
 * if setWriter or the Writer constructor was not called.
 * @apiSince 8
 */

public java.io.Writer getWriter() { throw new RuntimeException("Stub!"); }

/**
 * Set the systemID that may be used in association
 * with the byte or character stream, or, if neither is set, use
 * this value as a writeable URI (probably a file name).
 *
 * @param systemId The system identifier as a URI string.
 * @apiSince 8
 */

public void setSystemId(java.lang.String systemId) { throw new RuntimeException("Stub!"); }

/**
 * <p>Set the system ID from a <code>File</code> reference.</p>
 *
 * <p>Note the use of {@link java.io.File#toURI() File#toURI()} and {@link java.io.File#toURL() File#toURL()}.
 * <code>toURI()</code> is preferred and used if possible.
 * To allow JAXP 1.3 to run on J2SE 1.3, <code>toURL()</code>
 * is used if a {@link java.lang.NoSuchMethodException NoSuchMethodException} is thrown by the attempt
 * to use <code>toURI()</code>.</p>
 *
 * @param f Must a non-null File reference.
 * @apiSince 8
 */

public void setSystemId(java.io.File f) { throw new RuntimeException("Stub!"); }

/**
 * Get the system identifier that was set with setSystemId.
 *
 * @return The system identifier that was set with setSystemId, or null
 * if setSystemId was not called.
 * @apiSince 8
 */

public java.lang.String getSystemId() { throw new RuntimeException("Stub!"); }

/** If {@link javax.xml.transform.TransformerFactory#getFeature}
 * returns true when passed this value as an argument,
 * the Transformer supports Result output of this type.
 * @apiSince 8
 */

public static final java.lang.String FEATURE = "http://javax.xml.transform.stream.StreamResult/feature";
}

