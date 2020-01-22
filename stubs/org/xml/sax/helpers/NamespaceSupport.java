// NamespaceSupport.java - generic Namespace support for SAX.
// http://www.saxproject.org
// Written by David Megginson
// This class is in the Public Domain.  NO WARRANTY!
// $Id: NamespaceSupport.java,v 1.15 2004/04/26 17:34:35 dmegginson Exp $



package org.xml.sax.helpers;


/**
 * Encapsulate Namespace logic for use by applications using SAX,
 * or internally by SAX drivers.
 *
 * <blockquote>
 * <em>This module, both source code and documentation, is in the
 * Public Domain, and comes with <strong>NO WARRANTY</strong>.</em>
 * See <a href='http://www.saxproject.org'>http://www.saxproject.org</a>
 * for further information.
 * </blockquote>
 *
 * <p>This class encapsulates the logic of Namespace processing: it
 * tracks the declarations currently in force for each context and
 * automatically processes qualified XML names into their Namespace
 * parts; it can also be used in reverse for generating XML qnames
 * from Namespaces.</p>
 *
 * <p>Namespace support objects are reusable, but the reset method
 * must be invoked between each session.</p>
 *
 * <p>Here is a simple session:</p>
 *
 * <pre>
 * String parts[] = new String[3];
 * NamespaceSupport support = new NamespaceSupport();
 *
 * support.pushContext();
 * support.declarePrefix("", "http://www.w3.org/1999/xhtml");
 * support.declarePrefix("dc", "http://www.purl.org/dc#");
 *
 * parts = support.processName("p", parts, false);
 * System.out.println("Namespace URI: " + parts[0]);
 * System.out.println("Local name: " + parts[1]);
 * System.out.println("Raw name: " + parts[2]);
 *
 * parts = support.processName("dc:title", parts, false);
 * System.out.println("Namespace URI: " + parts[0]);
 * System.out.println("Local name: " + parts[1]);
 * System.out.println("Raw name: " + parts[2]);
 *
 * support.popContext();
 * </pre>
 *
 * <p>Note that this class is optimized for the use case where most
 * elements do not contain Namespace declarations: if the same
 * prefix/URI mapping is repeated for each context (for example), this
 * class will be somewhat less efficient.</p>
 *
 * <p>Although SAX drivers (parsers) may choose to use this class to
 * implement namespace handling, they are not required to do so.
 * Applications must track namespace information themselves if they
 * want to use namespace information.
 *
 * @since SAX 2.0
 * @author David Megginson
 * @version 2.0.1 (sax2r2)
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class NamespaceSupport {

/**
 * Create a new Namespace support object.
 * @apiSince 1
 */

public NamespaceSupport() { throw new RuntimeException("Stub!"); }

/**
 * Reset this Namespace support object for reuse.
 *
 * <p>It is necessary to invoke this method before reusing the
 * Namespace support object for a new session.  If namespace
 * declaration URIs are to be supported, that flag must also
 * be set to a non-default value.
 * </p>
 *
 * @see #setNamespaceDeclUris
 * @apiSince 1
 */

public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Start a new Namespace context.
 * The new context will automatically inherit
 * the declarations of its parent context, but it will also keep
 * track of which declarations were made within this context.
 *
 * <p>Event callback code should start a new context once per element.
 * This means being ready to call this in either of two places.
 * For elements that don't include namespace declarations, the
 * <em>ContentHandler.startElement()</em> callback is the right place.
 * For elements with such a declaration, it'd done in the first
 * <em>ContentHandler.startPrefixMapping()</em> callback.
 * A boolean flag can be used to
 * track whether a context has been started yet.  When either of
 * those methods is called, it checks the flag to see if a new context
 * needs to be started.  If so, it starts the context and sets the
 * flag.  After <em>ContentHandler.startElement()</em>
 * does that, it always clears the flag.
 *
 * <p>Normally, SAX drivers would push a new context at the beginning
 * of each XML element.  Then they perform a first pass over the
 * attributes to process all namespace declarations, making
 * <em>ContentHandler.startPrefixMapping()</em> callbacks.
 * Then a second pass is made, to determine the namespace-qualified
 * names for all attributes and for the element name.
 * Finally all the information for the
 * <em>ContentHandler.startElement()</em> callback is available,
 * so it can then be made.
 *
 * <p>The Namespace support object always starts with a base context
 * already in force: in this context, only the "xml" prefix is
 * declared.</p>
 *
 * @see org.xml.sax.ContentHandler
 * @see #popContext
 * @apiSince 1
 */

public void pushContext() { throw new RuntimeException("Stub!"); }

/**
 * Revert to the previous Namespace context.
 *
 * <p>Normally, you should pop the context at the end of each
 * XML element.  After popping the context, all Namespace prefix
 * mappings that were previously in force are restored.</p>
 *
 * <p>You must not attempt to declare additional Namespace
 * prefixes after popping a context, unless you push another
 * context first.</p>
 *
 * @see #pushContext
 * @apiSince 1
 */

public void popContext() { throw new RuntimeException("Stub!"); }

/**
 * Declare a Namespace prefix.  All prefixes must be declared
 * before they are referenced.  For example, a SAX driver (parser)
 * would scan an element's attributes
 * in two passes:  first for namespace declarations,
 * then a second pass using {@link #processName processName()} to
 * interpret prefixes against (potentially redefined) prefixes.
 *
 * <p>This method declares a prefix in the current Namespace
 * context; the prefix will remain in force until this context
 * is popped, unless it is shadowed in a descendant context.</p>
 *
 * <p>To declare the default element Namespace, use the empty string as
 * the prefix.</p>
 *
 * <p>Note that you must <em>not</em> declare a prefix after
 * you've pushed and popped another Namespace context, or
 * treated the declarations phase as complete by processing
 * a prefixed name.</p>
 *
 * <p>Note that there is an asymmetry in this library: {@link
 * #getPrefix getPrefix} will not return the "" prefix,
 * even if you have declared a default element namespace.
 * To check for a default namespace,
 * you have to look it up explicitly using {@link #getURI getURI}.
 * This asymmetry exists to make it easier to look up prefixes
 * for attribute names, where the default prefix is not allowed.</p>
 *
 * @param prefix The prefix to declare, or the empty string to
 *    indicate the default element namespace.  This may never have
 *    the value "xml" or "xmlns".
 * @param uri The Namespace URI to associate with the prefix.
 * @return true if the prefix was legal, false otherwise
 *
 * @see #processName
 * @see #getURI
 * @see #getPrefix
 * @apiSince 1
 */

public boolean declarePrefix(java.lang.String prefix, java.lang.String uri) { throw new RuntimeException("Stub!"); }

/**
 * Process a raw XML qualified name, after all declarations in the
 * current context have been handled by {@link #declarePrefix
 * declarePrefix()}.
 *
 * <p>This method processes a raw XML qualified name in the
 * current context by removing the prefix and looking it up among
 * the prefixes currently declared.  The return value will be the
 * array supplied by the caller, filled in as follows:</p>
 *
 * <dl>
 * <dt>parts[0]</dt>
 * <dd>The Namespace URI, or an empty string if none is
 *  in use.</dd>
 * <dt>parts[1]</dt>
 * <dd>The local name (without prefix).</dd>
 * <dt>parts[2]</dt>
 * <dd>The original raw name.</dd>
 * </dl>
 *
 * <p>All of the strings in the array will be internalized.  If
 * the raw name has a prefix that has not been declared, then
 * the return value will be null.</p>
 *
 * <p>Note that attribute names are processed differently than
 * element names: an unprefixed element name will receive the
 * default Namespace (if any), while an unprefixed attribute name
 * will not.</p>
 *
 * @param qName The XML qualified name to be processed.
 * @param parts An array supplied by the caller, capable of
 *        holding at least three members.
 * @param isAttribute A flag indicating whether this is an
 *        attribute name (true) or an element name (false).
 * @return The supplied array holding three internalized strings
 *        representing the Namespace URI (or empty string), the
 *        local name, and the XML qualified name; or null if there
 *        is an undeclared prefix.
 * @see #declarePrefix
 * @see java.lang.String#intern * @apiSince 1
 */

public java.lang.String[] processName(java.lang.String qName, java.lang.String[] parts, boolean isAttribute) { throw new RuntimeException("Stub!"); }

/**
 * Look up a prefix and get the currently-mapped Namespace URI.
 *
 * <p>This method looks up the prefix in the current context.
 * Use the empty string ("") for the default Namespace.</p>
 *
 * @param prefix The prefix to look up.
 * @return The associated Namespace URI, or null if the prefix
 *         is undeclared in this context.
 * @see #getPrefix
 * @see #getPrefixes
 * @apiSince 1
 */

public java.lang.String getURI(java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/**
 * Return an enumeration of all prefixes whose declarations are
 * active in the current context.
 * This includes declarations from parent contexts that have
 * not been overridden.
 *
 * <p><strong>Note:</strong> if there is a default prefix, it will not be
 * returned in this enumeration; check for the default prefix
 * using the {@link #getURI getURI} with an argument of "".</p>
 *
 * @return An enumeration of prefixes (never empty).
 * @see #getDeclaredPrefixes
 * @see #getURI
 * @apiSince 1
 */

public java.util.Enumeration getPrefixes() { throw new RuntimeException("Stub!"); }

/**
 * Return one of the prefixes mapped to a Namespace URI.
 *
 * <p>If more than one prefix is currently mapped to the same
 * URI, this method will make an arbitrary selection; if you
 * want all of the prefixes, use the {@link #getPrefixes}
 * method instead.</p>
 *
 * <p><strong>Note:</strong> this will never return the empty (default) prefix;
 * to check for a default prefix, use the {@link #getURI getURI}
 * method with an argument of "".</p>
 *
 * @param uri the namespace URI
 * @return one of the prefixes currently mapped to the URI supplied,
 *         or null if none is mapped or if the URI is assigned to
 *         the default namespace
 * @see #getPrefixes(java.lang.String)
 * @see #getURI
 * @apiSince 1
 */

public java.lang.String getPrefix(java.lang.String uri) { throw new RuntimeException("Stub!"); }

/**
 * Return an enumeration of all prefixes for a given URI whose
 * declarations are active in the current context.
 * This includes declarations from parent contexts that have
 * not been overridden.
 *
 * <p>This method returns prefixes mapped to a specific Namespace
 * URI.  The xml: prefix will be included.  If you want only one
 * prefix that's mapped to the Namespace URI, and you don't care
 * which one you get, use the {@link #getPrefix getPrefix}
 *  method instead.</p>
 *
 * <p><strong>Note:</strong> the empty (default) prefix is <em>never</em> included
 * in this enumeration; to check for the presence of a default
 * Namespace, use the {@link #getURI getURI} method with an
 * argument of "".</p>
 *
 * @param uri The Namespace URI.
 * @return An enumeration of prefixes (never empty).
 * @see #getPrefix
 * @see #getDeclaredPrefixes
 * @see #getURI
 * @apiSince 1
 */

public java.util.Enumeration getPrefixes(java.lang.String uri) { throw new RuntimeException("Stub!"); }

/**
 * Return an enumeration of all prefixes declared in this context.
 *
 * <p>The empty (default) prefix will be included in this
 * enumeration; note that this behaviour differs from that of
 * {@link #getPrefix} and {@link #getPrefixes}.</p>
 *
 * @return An enumeration of all prefixes declared in this
 *         context.
 * @see #getPrefixes
 * @see #getURI
 * @apiSince 1
 */

public java.util.Enumeration getDeclaredPrefixes() { throw new RuntimeException("Stub!"); }

/**
 * Controls whether namespace declaration attributes are placed
 * into the {@link #NSDECL NSDECL} namespace
 * by {@link #processName processName()}.  This may only be
 * changed before any contexts have been pushed.
 *
 * @param value the namespace declaration attribute state. A value of true
 *              enables this feature, a value of false disables it.
 *
 * @since SAX 2.1alpha
 *
 * @exception java.lang.IllegalStateException when attempting to set this
 *    after any context has been pushed.
 * @apiSince 1
 */

public void setNamespaceDeclUris(boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if namespace declaration attributes are placed into
 * a namespace.  This behavior is not the default.
 *
 * @return true if namespace declaration attributes are enabled, false
 *         otherwise.
 * @since SAX 2.1alpha
 * @apiSince 1
 */

public boolean isNamespaceDeclUris() { throw new RuntimeException("Stub!"); }

/**
 * The namespace declaration URI as a constant.
 * The value is <code>http://www.w3.org/xmlns/2000/</code>, as defined
 * in a backwards-incompatible erratum to the "Namespaces in XML"
 * recommendation.  Because that erratum postdated SAX2, SAX2 defaults
 * to the original recommendation, and does not normally use this URI.
 *
 *
 * <p>This is the Namespace URI that is optionally applied to
 * <em>xmlns</em> and <em>xmlns:*</em> attributes, which are used to
 * declare namespaces.  </p>
 *
 * @since SAX 2.1alpha
 * @see #setNamespaceDeclUris
 * @see #isNamespaceDeclUris
 * @apiSince 1
 */

public static final java.lang.String NSDECL = "http://www.w3.org/xmlns/2000/";

/**
 * The XML Namespace URI as a constant.
 * The value is <code>http://www.w3.org/XML/1998/namespace</code>
 * as defined in the "Namespaces in XML" * recommendation.
 *
 * <p>This is the Namespace URI that is automatically mapped
 * to the "xml" prefix.</p>
 * @apiSince 1
 */

public static final java.lang.String XMLNS = "http://www.w3.org/XML/1998/namespace";
}

