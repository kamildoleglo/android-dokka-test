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
// $Id: ValidatorHandler.java 446598 2006-09-15 12:55:40Z jeremias $



package javax.xml.validation;

import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXNotRecognizedException;

/**
 * Streaming validator that works on SAX stream.
 *
 * <p>
 * A {@link javax.xml.validation.ValidatorHandler ValidatorHandler} object is a thread-unsafe, non-reentrant object.
 * In other words, it is the application's responsibility to make
 * sure that one {@link javax.xml.validation.ValidatorHandler ValidatorHandler} object is not used from
 * more than one thread at any given time.
 *
 * <p>
 * {@link javax.xml.validation.ValidatorHandler ValidatorHandler} checks if the SAX events follow
 * the set of constraints described in the associated {@link javax.xml.validation.Schema Schema},
 * and additionally it may modify the SAX events (for example
 * by adding default values, etc.)
 *
 * <p>
 * {@link javax.xml.validation.ValidatorHandler ValidatorHandler} extends from {@link org.xml.sax.ContentHandler ContentHandler},
 * but it refines the underlying {@link org.xml.sax.ContentHandler ContentHandler} in
 * the following way:
 * <ol>
 *  <li>startElement/endElement events must receive non-null String
 *      for <code>uri</code>, <code>localName</code>, and <code>qname</code>,
 *      even though SAX allows some of them to be null.
 *      Similarly, the user-specified {@link org.xml.sax.ContentHandler ContentHandler} will receive non-null
 *      Strings for all three parameters.
 *
 *  <li>Applications must ensure that {@link javax.xml.validation.ValidatorHandler ValidatorHandler}'s
 *      {@link org.xml.sax.ContentHandler#startPrefixMapping(java.lang.String,java.lang.String) ContentHandler#startPrefixMapping(String,String)} and
 *      {@link org.xml.sax.ContentHandler#endPrefixMapping(java.lang.String) ContentHandler#endPrefixMapping(String)} are invoked
 *      properly. Similarly, the user-specified {@link org.xml.sax.ContentHandler ContentHandler}
 *      will receive startPrefixMapping/endPrefixMapping events.
 *      If the {@link javax.xml.validation.ValidatorHandler ValidatorHandler} introduces additional namespace
 *      bindings, the user-specified {@link org.xml.sax.ContentHandler ContentHandler} will receive
 *      additional startPrefixMapping/endPrefixMapping events.
 *
 *  <li>{@link org.xml.sax.Attributes} for the
 *      {@link org.xml.sax.ContentHandler#startElement(java.lang.String,java.lang.String,java.lang.String,Attributes) ContentHandler#startElement(String,String,String,Attributes)} method
 *      may or may not include xmlns* attributes.
 * </ol>
 *
 * <p>
 * A {@link javax.xml.validation.ValidatorHandler ValidatorHandler} is automatically reset every time
 * the startDocument method is invoked.
 *
 * <h2>Recognized Properties and Features</h2>
 * <p>
 * This spec defines the following feature that must be recognized
 * by all {@link javax.xml.validation.ValidatorHandler ValidatorHandler} implementations.
 *
 * <h3><code>http://xml.org/sax/features/namespace-prefixes</code></h3>
 * <p>
 * This feature controls how a {@link javax.xml.validation.ValidatorHandler ValidatorHandler} introduces
 * namespace bindings that were not present in the original SAX event
 * stream.
 * When this feature is set to true, it must make
 * sure that the user's {@link org.xml.sax.ContentHandler ContentHandler} will see
 * the corresponding <code>xmlns*</code> attribute in
 * the {@link org.xml.sax.Attributes} object of the
 * {@link org.xml.sax.ContentHandler#startElement(java.lang.String,java.lang.String,java.lang.String,Attributes) ContentHandler#startElement(String,String,String,Attributes)}
 * callback. Otherwise, <code>xmlns*</code> attributes must not be
 * added to {@link org.xml.sax.Attributes} that's passed to the
 * user-specified {@link org.xml.sax.ContentHandler ContentHandler}.
 * <p>
 * (Note that regardless of this switch, namespace bindings are
 * always notified to applications through
 * {@link org.xml.sax.ContentHandler#startPrefixMapping(java.lang.String,java.lang.String) ContentHandler#startPrefixMapping(String,String)} and
 * {@link org.xml.sax.ContentHandler#endPrefixMapping(java.lang.String) ContentHandler#endPrefixMapping(String)} methods of the
 * {@link org.xml.sax.ContentHandler ContentHandler} specified by the user.)
 *
 * <p>
 * Note that this feature does <em>NOT</em> affect the way
 * a {@link javax.xml.validation.ValidatorHandler ValidatorHandler} receives SAX events. It merely
 * changes the way it augments SAX events.
 *
 * <p>This feature is set to <code>false</code> by default.</p>
 *
 * @author  <a href="mailto:Kohsuke.Kawaguchi@Sun.com">Kohsuke Kawaguchi</a>
 * @version $Revision: 446598 $, $Date: 2006-09-15 05:55:40 -0700 (Fri, 15 Sep 2006) $
 * @since 1.5
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ValidatorHandler implements org.xml.sax.ContentHandler {

/**
 * Constructor for derived classes.
 *
 * <p>
 * The constructor does nothing.
 *
 * <p>
 * Derived classes must create {@link javax.xml.validation.ValidatorHandler ValidatorHandler} objects that have
 * <tt>null</tt> {@link org.xml.sax.ErrorHandler ErrorHandler} and
 * <tt>null</tt> {@link org.w3c.dom.ls.LSResourceResolver LSResourceResolver}.
 * @apiSince 8
 */

protected ValidatorHandler() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link org.xml.sax.ContentHandler ContentHandler} which receives
 * the augmented validation result.
 *
 * <p>
 * When a {@link org.xml.sax.ContentHandler ContentHandler} is specified, a
 * {@link javax.xml.validation.ValidatorHandler ValidatorHandler} will work as a filter
 * and basically copy the incoming events to the
 * specified {@link org.xml.sax.ContentHandler ContentHandler}.
 *
 * <p>
 * In doing so, a {@link javax.xml.validation.ValidatorHandler ValidatorHandler} may modify
 * the events, for example by adding defaulted attributes.
 *
 * <p>
 * A {@link javax.xml.validation.ValidatorHandler ValidatorHandler} may buffer events to certain
 * extent, but to allow {@link javax.xml.validation.ValidatorHandler ValidatorHandler} to be used
 * by a parser, the following requirement has to be met.
 *
 * <ol>
 *  <li>When
 *      {@link org.xml.sax.ContentHandler#startElement(java.lang.String,java.lang.String,java.lang.String,Attributes) ContentHandler#startElement(String, String, String, Attributes)},
 *      {@link org.xml.sax.ContentHandler#endElement(java.lang.String,java.lang.String,java.lang.String) ContentHandler#endElement(String, String, String)},
 *      {@link org.xml.sax.ContentHandler#startDocument() ContentHandler#startDocument()}, or
 *      {@link org.xml.sax.ContentHandler#endDocument() ContentHandler#endDocument()}
 *      are invoked on a {@link javax.xml.validation.ValidatorHandler ValidatorHandler},
 *      the same method on the user-specified {@link org.xml.sax.ContentHandler ContentHandler}
 *      must be invoked for the same event before the callback
 *      returns.
 *  <li>{@link javax.xml.validation.ValidatorHandler ValidatorHandler} may not introduce new elements that
 *      were not present in the input.
 *
 *  <li>{@link javax.xml.validation.ValidatorHandler ValidatorHandler} may not remove attributes that were
 *      present in the input.
 * </ol>
 *
 * <p>
 * When a callback method on the specified {@link org.xml.sax.ContentHandler ContentHandler}
 * throws an exception, the same exception object must be thrown
 * from the {@link javax.xml.validation.ValidatorHandler ValidatorHandler}. The {@link org.xml.sax.ErrorHandler ErrorHandler}
 * should not be notified of such an exception.
 *
 * <p>
 * This method can be called even during a middle of a validation.
 *
 * @param receiver
 *      A {@link org.xml.sax.ContentHandler ContentHandler} or a null value.
 * @apiSince 8
 */

public abstract void setContentHandler(org.xml.sax.ContentHandler receiver);

/**
 * Gets the {@link org.xml.sax.ContentHandler ContentHandler} which receives the
 * augmented validation result.
 *
 * @return
 *      This method returns the object that was last set through
 *      the {@link #getContentHandler()} method, or null
 *      if that method has never been called since this {@link javax.xml.validation.ValidatorHandler ValidatorHandler}
 *      has created.
 *
 * @see #setContentHandler(ContentHandler)
 * @apiSince 8
 */

public abstract org.xml.sax.ContentHandler getContentHandler();

/**
 * Sets the {@link org.xml.sax.ErrorHandler ErrorHandler} to receive errors encountered
 * during the validation.
 *
 * <p>
 * Error handler can be used to customize the error handling process
 * during a validation. When an {@link org.xml.sax.ErrorHandler ErrorHandler} is set,
 * errors found during the validation will be first sent
 * to the {@link org.xml.sax.ErrorHandler ErrorHandler}.
 *
 * <p>
 * The error handler can abort further validation immediately
 * by throwing {@link org.xml.sax.SAXException} from the handler. Or for example
 * it can print an error to the screen and try to continue the
 * validation by returning normally from the {@link org.xml.sax.ErrorHandler ErrorHandler}
 *
 * <p>
 * If any {@link java.lang.Throwable Throwable} is thrown from an {@link org.xml.sax.ErrorHandler ErrorHandler},
 * the same {@link java.lang.Throwable Throwable} object will be thrown toward the
 * root of the call stack.
 *
 * <p>
 * {@link javax.xml.validation.ValidatorHandler ValidatorHandler} is not allowed to
 * throw {@link org.xml.sax.SAXException} without first reporting it to
 * {@link org.xml.sax.ErrorHandler ErrorHandler}.
 *
 * <p>
 * When the {@link org.xml.sax.ErrorHandler ErrorHandler} is null, the implementation will
 * behave as if the following {@link org.xml.sax.ErrorHandler ErrorHandler} is set:
 * <pre>
 * class DraconianErrorHandler implements {@link org.xml.sax.ErrorHandler ErrorHandler} {
 *     public void fatalError( {@link org.xml.sax.SAXParseException} e ) throws {@link org.xml.sax.SAXException} {
 *         throw e;
 *     }
 *     public void error( {@link org.xml.sax.SAXParseException} e ) throws {@link org.xml.sax.SAXException} {
 *         throw e;
 *     }
 *     public void warning( {@link org.xml.sax.SAXParseException} e ) throws {@link org.xml.sax.SAXException} {
 *         // noop
 *     }
 * }
 * </pre>
 *
 * <p>
 * When a new {@link javax.xml.validation.ValidatorHandler ValidatorHandler} object is created, initially
 * this field is set to null.
 *
 * @param   errorHandler
 *      A new error handler to be set. This parameter can be null.
 * @apiSince 8
 */

public abstract void setErrorHandler(org.xml.sax.ErrorHandler errorHandler);

/**
 * Gets the current {@link org.xml.sax.ErrorHandler ErrorHandler} set to this {@link javax.xml.validation.ValidatorHandler ValidatorHandler}.
 *
 * @return
 *      This method returns the object that was last set through
 *      the {@link #setErrorHandler(org.xml.sax.ErrorHandler)} method, or null
 *      if that method has never been called since this {@link javax.xml.validation.ValidatorHandler ValidatorHandler}
 *      has created.
 *
 * @see #setErrorHandler(ErrorHandler)
 * @apiSince 8
 */

public abstract org.xml.sax.ErrorHandler getErrorHandler();

/**
 * Sets the {@link org.w3c.dom.ls.LSResourceResolver LSResourceResolver} to customize
 * resource resolution while in a validation episode.
 *
 * <p>
 * {@link javax.xml.validation.ValidatorHandler ValidatorHandler} uses a {@link org.w3c.dom.ls.LSResourceResolver LSResourceResolver}
 * when it needs to locate external resources while a validation,
 * although exactly what constitutes "locating external resources" is
 * up to each schema language.
 *
 * <p>
 * When the {@link org.w3c.dom.ls.LSResourceResolver LSResourceResolver} is null, the implementation will
 * behave as if the following {@link org.w3c.dom.ls.LSResourceResolver LSResourceResolver} is set:
 * <pre>
 * class DumbLSResourceResolver implements {@link org.w3c.dom.ls.LSResourceResolver LSResourceResolver} {
 *     public {@link org.w3c.dom.ls.LSInput} resolveResource(
 *         String publicId, String systemId, String baseURI) {
 *
 *         return null; // always return null
 *     }
 * }
 * </pre>
 *
 * <p>
 * If a {@link org.w3c.dom.ls.LSResourceResolver LSResourceResolver} throws a {@link java.lang.RuntimeException RuntimeException}
 *  (or instances of its derived classes),
 * then the {@link javax.xml.validation.ValidatorHandler ValidatorHandler} will abort the parsing and
 * the caller of the <code>validate</code> method will receive
 * the same {@link java.lang.RuntimeException RuntimeException}.
 *
 * <p>
 * When a new {@link javax.xml.validation.ValidatorHandler ValidatorHandler} object is created, initially
 * this field is set to null.
 *
 * @param   resourceResolver
 *      A new resource resolver to be set. This parameter can be null.
 * @apiSince 8
 */

public abstract void setResourceResolver(org.w3c.dom.ls.LSResourceResolver resourceResolver);

/**
 * Gets the current {@link org.w3c.dom.ls.LSResourceResolver LSResourceResolver} set to this {@link javax.xml.validation.ValidatorHandler ValidatorHandler}.
 *
 * @return
 *      This method returns the object that was last set through
 *      the {@link #setResourceResolver(org.w3c.dom.ls.LSResourceResolver)} method, or null
 *      if that method has never been called since this {@link javax.xml.validation.ValidatorHandler ValidatorHandler}
 *      has created.
 *
 * @see #setErrorHandler(ErrorHandler)
 * @apiSince 8
 */

public abstract org.w3c.dom.ls.LSResourceResolver getResourceResolver();

/**
 * Obtains the {@link javax.xml.validation.TypeInfoProvider TypeInfoProvider} implementation of this
 * {@link javax.xml.validation.ValidatorHandler ValidatorHandler}.
 *
 * <p>
 * The obtained {@link javax.xml.validation.TypeInfoProvider TypeInfoProvider} can be queried during a parse
 * to access the type information determined by the validator.
 *
 * <p>
 * Some schema languages do not define the notion of type,
 * for those languages, this method may not be supported.
 * However, to be compliant with this specification, implementations
 * for W3C XML Schema 1.0 must support this operation.
 *
 * @return
 *      null if the validator / schema language does not support
 *      the notion of {@link org.w3c.dom.TypeInfo}.
 *      Otherwise a non-null valid {@link javax.xml.validation.TypeInfoProvider TypeInfoProvider}.
 * @apiSince 8
 */

public abstract javax.xml.validation.TypeInfoProvider getTypeInfoProvider();

/**
 * Look up the value of a feature flag.
 *
 * <p>The feature name is any fully-qualified URI.  It is
 * possible for a {@link javax.xml.validation.ValidatorHandler ValidatorHandler} to recognize a feature name but
 * temporarily be unable to return its value.
 * Some feature values may be available only in specific
 * contexts, such as before, during, or after a validation.
 *
 * <p>Implementors are free (and encouraged) to invent their own features,
 * using names built on their own URIs.</p>
 *
 * @param name The feature name, which is a non-null fully-qualified URI.
 * @return The current value of the feature (true or false).
 * @exception org.xml.sax.SAXNotRecognizedException If the feature
 *            value can't be assigned or retrieved.
 * @exception org.xml.sax.SAXNotSupportedException When the
 *            {@link javax.xml.validation.ValidatorHandler ValidatorHandler} recognizes the feature name but
 *            cannot determine its value at this time.
 * @throws java.lang.NullPointerException
 *          When the name parameter is null.
 * @see #setFeature(String, boolean)
 * @apiSince 8
 */

public boolean getFeature(java.lang.String name) throws org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException { throw new RuntimeException("Stub!"); }

/**
 * Set the value of a feature flag.
 *
 * <p>
 * Feature can be used to control the way a {@link javax.xml.validation.ValidatorHandler ValidatorHandler}
 * parses schemas, although {@link javax.xml.validation.ValidatorHandler ValidatorHandler}s are not required
 * to recognize any specific property names.</p>
 *
 * <p>The feature name is any fully-qualified URI.  It is
 * possible for a {@link javax.xml.validation.ValidatorHandler ValidatorHandler} to expose a feature value but
 * to be unable to change the current value.
 * Some feature values may be immutable or mutable only
 * in specific contexts, such as before, during, or after
 * a validation.</p>
 *
 * @param name The feature name, which is a non-null fully-qualified URI.
 * @param value The requested value of the feature (true or false).
 *
 * @exception org.xml.sax.SAXNotRecognizedException If the feature
 *            value can't be assigned or retrieved.
 * @exception org.xml.sax.SAXNotSupportedException When the
 *            {@link javax.xml.validation.ValidatorHandler ValidatorHandler} recognizes the feature name but
 *            cannot set the requested value.
 * @throws java.lang.NullPointerException
 *          When the name parameter is null.
 *
 * @see #getFeature(String)
 * @apiSince 8
 */

public void setFeature(java.lang.String name, boolean value) throws org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException { throw new RuntimeException("Stub!"); }

/**
 * Set the value of a property.
 *
 * <p>The property name is any fully-qualified URI.  It is
 * possible for a {@link javax.xml.validation.ValidatorHandler ValidatorHandler} to recognize a property name but
 * to be unable to change the current value.
 * Some property values may be immutable or mutable only
 * in specific contexts, such as before, during, or after
 * a validation.</p>
 *
 * <p>{@link javax.xml.validation.ValidatorHandler ValidatorHandler}s are not required to recognize setting
 * any specific property names.</p>
 *
 * @param name The property name, which is a non-null fully-qualified URI.
 * @param object The requested value for the property.
 *
 * @exception org.xml.sax.SAXNotRecognizedException If the property
 *            value can't be assigned or retrieved.
 * @exception org.xml.sax.SAXNotSupportedException When the
 *            {@link javax.xml.validation.ValidatorHandler ValidatorHandler} recognizes the property name but
 *            cannot set the requested value.
 * @throws java.lang.NullPointerException
 *          When the name parameter is null.
 * @apiSince 8
 */

public void setProperty(java.lang.String name, java.lang.Object object) throws org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException { throw new RuntimeException("Stub!"); }

/**
 * Look up the value of a property.
 *
 * <p>The property name is any fully-qualified URI.  It is
 * possible for a {@link javax.xml.validation.ValidatorHandler ValidatorHandler} to recognize a property name but
 * temporarily be unable to return its value.
 * Some property values may be available only in specific
 * contexts, such as before, during, or after a validation.</p>
 *
 * <p>{@link javax.xml.validation.ValidatorHandler ValidatorHandler}s are not required to recognize any specific
 * property names.</p>
 *
 * <p>Implementors are free (and encouraged) to invent their own properties,
 * using names built on their own URIs.</p>
 *
 * @param name The property name, which is a non-null fully-qualified URI.
 * @return The current value of the property.
 * @exception org.xml.sax.SAXNotRecognizedException If the property
 *            value can't be assigned or retrieved.
 * @exception org.xml.sax.SAXNotSupportedException When the
 *            XMLReader recognizes the property name but
 *            cannot determine its value at this time.
 * @throws java.lang.NullPointerException
 *          When the name parameter is null.
 * @see #setProperty(String, Object)
 * @apiSince 8
 */

public java.lang.Object getProperty(java.lang.String name) throws org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException { throw new RuntimeException("Stub!"); }
}

