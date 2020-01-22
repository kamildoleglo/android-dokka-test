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

// $Id: SAXResult.java 446598 2006-09-15 12:55:40Z jeremias $



package javax.xml.transform.sax;

import javax.xml.transform.Result;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/**
 * <p>Acts as an holder for a transformation Result.</p>
 *
 * @author <a href="Jeff.Suttor@Sun.com">Jeff Suttor</a>
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SAXResult implements javax.xml.transform.Result {

/**
 * Zero-argument default constructor.
 * @apiSince 8
 */

public SAXResult() { throw new RuntimeException("Stub!"); }

/**
 * Create a SAXResult that targets a SAX2 {@link org.xml.sax.ContentHandler}.
 *
 * @param handler Must be a non-null ContentHandler reference.
 * @apiSince 8
 */

public SAXResult(org.xml.sax.ContentHandler handler) { throw new RuntimeException("Stub!"); }

/**
 * Set the target to be a SAX2 {@link org.xml.sax.ContentHandler}.
 *
 * @param handler Must be a non-null ContentHandler reference.
 * @apiSince 8
 */

public void setHandler(org.xml.sax.ContentHandler handler) { throw new RuntimeException("Stub!"); }

/**
 * Get the {@link org.xml.sax.ContentHandler} that is the Result.
 *
 * @return The ContentHandler that is to be transformation output.
 * @apiSince 8
 */

public org.xml.sax.ContentHandler getHandler() { throw new RuntimeException("Stub!"); }

/**
 * Set the SAX2 {@link org.xml.sax.ext.LexicalHandler} for the output.
 *
 * <p>This is needed to handle XML comments and the like.  If the
 * lexical handler is not set, an attempt should be made by the
 * transformer to cast the {@link org.xml.sax.ContentHandler} to a
 * <code>LexicalHandler</code>.</p>
 *
 * @param handler A non-null <code>LexicalHandler</code> for
 * handling lexical parse events.
 * @apiSince 8
 */

public void setLexicalHandler(org.xml.sax.ext.LexicalHandler handler) { throw new RuntimeException("Stub!"); }

/**
 * Get a SAX2 {@link org.xml.sax.ext.LexicalHandler} for the output.
 *
 * @return A <code>LexicalHandler</code>, or null.
 * @apiSince 8
 */

public org.xml.sax.ext.LexicalHandler getLexicalHandler() { throw new RuntimeException("Stub!"); }

/**
 * Method setSystemId Set the systemID that may be used in association
 * with the {@link org.xml.sax.ContentHandler}.
 *
 * @param systemId The system identifier as a URI string.
 * @apiSince 8
 */

public void setSystemId(java.lang.String systemId) { throw new RuntimeException("Stub!"); }

/**
 * Get the system identifier that was set with setSystemId.
 *
 * @return The system identifier that was set with setSystemId, or null
 * if setSystemId was not called.
 * @apiSince 8
 */

public java.lang.String getSystemId() { throw new RuntimeException("Stub!"); }

/**
 * If {@link javax.xml.transform.TransformerFactory#getFeature}
 * returns true when passed this value as an argument,
 * the Transformer supports Result output of this type.
 * @apiSince 8
 */

public static final java.lang.String FEATURE = "http://javax.xml.transform.sax.SAXResult/feature";
}

