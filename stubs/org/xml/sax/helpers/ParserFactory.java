// SAX parser factory.
// http://www.saxproject.org
// No warranty; no copyright -- use this as you will.
// $Id: ParserFactory.java,v 1.7 2002/01/30 20:52:36 dbrownell Exp $



package org.xml.sax.helpers;

import org.xml.sax.Parser;

/**
 * Java-specific class for dynamically loading SAX parsers.
 *
 * <blockquote>
 * <em>This module, both source code and documentation, is in the
 * Public Domain, and comes with <strong>NO WARRANTY</strong>.</em>
 * See <a href='http://www.saxproject.org'>http://www.saxproject.org</a>
 * for further information.
 * </blockquote>
 *
 * <p><strong>Note:</strong> This class is designed to work with the now-deprecated
 * SAX1 {@link org.xml.sax.Parser Parser} class.  SAX2 applications should use
 * {@link org.xml.sax.helpers.XMLReaderFactory XMLReaderFactory} instead.</p>
 *
 * <p>ParserFactory is not part of the platform-independent definition
 * of SAX; it is an additional convenience class designed
 * specifically for Java XML application writers.  SAX applications
 * can use the static methods in this class to allocate a SAX parser
 * dynamically at run-time based either on the value of the
 * `org.xml.sax.parser' system property or on a string containing the class
 * name.</p>
 *
 * <p>Note that the application still requires an XML parser that
 * implements SAX1.</p>
 *
 * @deprecated This class works with the deprecated
 *             {@link org.xml.sax.Parser Parser}
 *             interface.
 * @since SAX 1.0
 * @author David Megginson
 * @version 2.0.1 (sax2r2)
 * @apiSince 1
 * @deprecatedSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class ParserFactory {

private ParserFactory() { throw new RuntimeException("Stub!"); }

/**
 * Create a new SAX parser using the `org.xml.sax.parser' system property.
 *
 * <p>The named class must exist and must implement the
 * {@link org.xml.sax.Parser Parser} interface.</p>
 *
 * @return the newly created parser.
 *
 * @exception java.lang.NullPointerException There is no value
 *            for the `org.xml.sax.parser' system property.
 * @exception java.lang.ClassNotFoundException The SAX parser
 *            class was not found (check your CLASSPATH).
 * @exception java.lang.IllegalAccessException The SAX parser class was
 *            found, but you do not have permission to load
 *            it.
 * @exception java.lang.InstantiationException The SAX parser class was
 *            found but could not be instantiated.
 * @exception java.lang.ClassCastException The SAX parser class
 *            was found and instantiated, but does not implement
 *            org.xml.sax.Parser.
 * @see #makeParser(java.lang.String)
 * @see org.xml.sax.Parser
 * @apiSince 1
 * @deprecatedSince 9
 */

@Deprecated
public static org.xml.sax.Parser makeParser() throws java.lang.ClassCastException, java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.NullPointerException { throw new RuntimeException("Stub!"); }

/**
 * Create a new SAX parser object using the class name provided.
 *
 * <p>The named class must exist and must implement the
 * {@link org.xml.sax.Parser Parser} interface.</p>
 *
 * @return the newly created parser.
 *
 * @param className A string containing the name of the
 *                  SAX parser class.
 * @exception java.lang.ClassNotFoundException The SAX parser
 *            class was not found (check your CLASSPATH).
 * @exception java.lang.IllegalAccessException The SAX parser class was
 *            found, but you do not have permission to load
 *            it.
 * @exception java.lang.InstantiationException The SAX parser class was
 *            found but could not be instantiated.
 * @exception java.lang.ClassCastException The SAX parser class
 *            was found and instantiated, but does not implement
 *            org.xml.sax.Parser.
 * @see #makeParser()
 * @see org.xml.sax.Parser
 * @apiSince 1
 * @deprecatedSince 9
 */

@Deprecated
public static org.xml.sax.Parser makeParser(java.lang.String className) throws java.lang.ClassCastException, java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }
}

