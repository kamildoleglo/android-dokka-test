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
// $Id: XPathFactory.java 888889 2009-12-09 17:43:18Z mrglavas $



package javax.xml.xpath;


/**
 * <p>An <code>XPathFactory</code> instance can be used to create
 * {@link javax.xml.xpath.XPath} objects.</p>
 *
 *<p>See {@link #newInstance(java.lang.String)} for lookup mechanism.</p>
 *
 * @author  <a href="mailto:Norman.Walsh@Sun.com">Norman Walsh</a>
 * @author  <a href="mailto:Jeff.Suttor@Sun.com">Jeff Suttor</a>
 * @version $Revision: 888889 $, $Date: 2009-12-09 09:43:18 -0800 (Wed, 09 Dec 2009) $
 * @since 1.5
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class XPathFactory {

/**
 * <p>Protected constructor as {@link #newInstance()}, {@link #newInstance(java.lang.String)}
 * or {@link #newInstance(java.lang.String,java.lang.String,java.lang.ClassLoader)}
 * should be used to create a new instance of an <code>XPathFactory</code>.</p>
 * @apiSince 8
 */

protected XPathFactory() { throw new RuntimeException("Stub!"); }

/**
 * <p>Get a new <code>XPathFactory</code> instance using the default object model,
 * {@link #DEFAULT_OBJECT_MODEL_URI},
 * the W3C DOM.</p>
 *
 * <p>This method is functionally equivalent to:</p>
 * <pre>
 *   newInstance(DEFAULT_OBJECT_MODEL_URI)
 * </pre>
 *
 * <p>Since the implementation for the W3C DOM is always available, this method will never fail.</p>
 *
 * @return Instance of an <code>XPathFactory</code>.
 * @apiSince 8
 */

public static final javax.xml.xpath.XPathFactory newInstance() { throw new RuntimeException("Stub!"); }

/**
 * <p>Get a new <code>XPathFactory</code> instance using the specified object model.</p>
 *
 * <p>To find a <code>XPathFactory</code> object,
 * this method looks the following places in the following order where "the class loader" refers to the context class loader:</p>
 * <ol>
 *   <li>
 *     If the system property {@link #DEFAULT_PROPERTY_NAME} + ":uri" is present,
 *     where uri is the parameter to this method, then its value is read as a class name.
 *     The method will try to create a new instance of this class by using the class loader,
 *     and returns it if it is successfully created.
 *   </li>
 *   <li>
 *     ${java.home}/lib/jaxp.properties is read and the value associated with the key being the system property above is looked for.
 *     If present, the value is processed just like above.
 *   </li>
 *   <li>
 *     The class loader is asked for service provider provider-configuration files matching <code>javax.xml.xpath.XPathFactory</code>
 *     in the resource directory META-INF/services.
 *     See the JAR File Specification for file format and parsing rules.
 *     Each potential service provider is required to implement the method:
 *     <pre>
 *       {@link #isObjectModelSupported(java.lang.String)}
 *     </pre>
 *     The first service provider found in class loader order that supports the specified object model is returned.
 *   </li>
 *   <li>
 *     Platform default <code>XPathFactory</code> is located in a platform specific way.
 *     There must be a platform default XPathFactory for the W3C DOM, i.e. {@link #DEFAULT_OBJECT_MODEL_URI}.
 *   </li>
 * </ol>
 * <p>If everything fails, an <code>XPathFactoryConfigurationException</code> will be thrown.</p>
 *
 * <p>Tip for Trouble-shooting:</p>
 * <p>See {@link java.util.Properties#load(java.io.InputStream)} for exactly how a property file is parsed.
 * In particular, colons ':' need to be escaped in a property file, so make sure the URIs are properly escaped in it.
 * For example:</p>
 * <pre>
 *   http\://java.sun.com/jaxp/xpath/dom=org.acme.DomXPathFactory
 * </pre>
 *
 * @param uri Identifies the underlying object model.
 *   The specification only defines the URI {@link #DEFAULT_OBJECT_MODEL_URI},
 *   <code>http://java.sun.com/jaxp/xpath/dom</code> for the W3C DOM,
 *   the org.w3c.dom package, and implementations are free to introduce other URIs for other object models.
 *
 * @return Instance of an <code>XPathFactory</code>.
 *
 * @throws javax.xml.xpath.XPathFactoryConfigurationException If the specified object model is unavailable.
 * @throws java.lang.NullPointerException If <code>uri</code> is <code>null</code>.
 * @throws java.lang.IllegalArgumentException If <code>uri.length() == 0</code>.
 * @apiSince 8
 */

public static final javax.xml.xpath.XPathFactory newInstance(java.lang.String uri) throws javax.xml.xpath.XPathFactoryConfigurationException { throw new RuntimeException("Stub!"); }

/**
 * @return Instance of an <code>XPathFactory</code>.
 *
 * @throws javax.xml.xpath.XPathFactoryConfigurationException If the specified object model is unavailable.
 * @throws java.lang.NullPointerException If <code>uri</code> is <code>null</code>.
 * @throws java.lang.IllegalArgumentException If <code>uri.length() == 0</code>.
 * @apiSince 8
 */

public static javax.xml.xpath.XPathFactory newInstance(java.lang.String uri, java.lang.String factoryClassName, java.lang.ClassLoader classLoader) throws javax.xml.xpath.XPathFactoryConfigurationException { throw new RuntimeException("Stub!"); }

/**
 * <p>Is specified object model supported by this <code>XPathFactory</code>?</p>
 *
 * @param objectModel Specifies the object model which the returned <code>XPathFactory</code> will understand.
 *
 * @return <code>true</code> if <code>XPathFactory</code> supports <code>objectModel</code>, else <code>false</code>.
 *
 * @throws java.lang.NullPointerException If <code>objectModel</code> is <code>null</code>.
 * @throws java.lang.IllegalArgumentException If <code>objectModel.length() == 0</code>.
 * @apiSince 8
 */

public abstract boolean isObjectModelSupported(java.lang.String objectModel);

/**
 * <p>Set a feature for this <code>XPathFactory</code> and <code>XPath</code>s created by this factory.</p>
 *
 * <p>
 * Feature names are fully qualified {@link java.net.URI}s.
 * Implementations may define their own features.
 * An {@link javax.xml.xpath.XPathFactoryConfigurationException XPathFactoryConfigurationException} is thrown if this <code>XPathFactory</code> or the <code>XPath</code>s
 *  it creates cannot support the feature.
 * It is possible for an <code>XPathFactory</code> to expose a feature value but be unable to change its state.
 * </p>
 *
 * <p>
 * All implementations are required to support the {@link javax.xml.XMLConstants#FEATURE_SECURE_PROCESSING} feature.
 * When the feature is <code>true</code>, any reference to  an external function is an error.
 * Under these conditions, the implementation must not call the {@link javax.xml.xpath.XPathFunctionResolver XPathFunctionResolver}
 * and must throw an {@link javax.xml.xpath.XPathFunctionException XPathFunctionException}.
 * </p>
 *
 * @param name Feature name.
 * @param value Is feature state <code>true</code> or <code>false</code>.
 *
 * @throws javax.xml.xpath.XPathFactoryConfigurationException if this <code>XPathFactory</code> or the <code>XPath</code>s
 *   it creates cannot support this feature.
 * @throws java.lang.NullPointerException if <code>name</code> is <code>null</code>.
 * @apiSince 8
 */

public abstract void setFeature(java.lang.String name, boolean value) throws javax.xml.xpath.XPathFactoryConfigurationException;

/**
 * <p>Get the state of the named feature.</p>
 *
 * <p>
 * Feature names are fully qualified {@link java.net.URI}s.
 * Implementations may define their own features.
 * An {@link javax.xml.xpath.XPathFactoryConfigurationException XPathFactoryConfigurationException} is thrown if this <code>XPathFactory</code> or the <code>XPath</code>s
 * it creates cannot support the feature.
 * It is possible for an <code>XPathFactory</code> to expose a feature value but be unable to change its state.
 * </p>
 *
 * @param name Feature name.
 *
 * @return State of the named feature.
 *
 * @throws javax.xml.xpath.XPathFactoryConfigurationException if this <code>XPathFactory</code> or the <code>XPath</code>s
 *   it creates cannot support this feature.
 * @throws java.lang.NullPointerException if <code>name</code> is <code>null</code>.
 * @apiSince 8
 */

public abstract boolean getFeature(java.lang.String name) throws javax.xml.xpath.XPathFactoryConfigurationException;

/**
 * <p>Establish a default variable resolver.</p>
 *
 * <p>Any <code>XPath</code> objects constructed from this factory will use
 * the specified resolver by default.</p>
 *
 * <p>A <code>NullPointerException</code> is thrown if <code>resolver</code> is <code>null</code>.</p>
 *
 * @param resolver Variable resolver.
 *
 *  @throws java.lang.NullPointerException If <code>resolver</code> is <code>null</code>.
 * @apiSince 8
 */

public abstract void setXPathVariableResolver(javax.xml.xpath.XPathVariableResolver resolver);

/**
 * <p>Establish a default function resolver.</p>
 *
 * <p>Any <code>XPath</code> objects constructed from this factory will use
 * the specified resolver by default.</p>
 *
 * <p>A <code>NullPointerException</code> is thrown if <code>resolver</code> is <code>null</code>.</p>
 *
 * @param resolver XPath function resolver.
 *
 * @throws java.lang.NullPointerException If <code>resolver</code> is <code>null</code>.
 * @apiSince 8
 */

public abstract void setXPathFunctionResolver(javax.xml.xpath.XPathFunctionResolver resolver);

/**
 * <p>Return a new <code>XPath</code> using the underlying object
 * model determined when the <code>XPathFactory</code> was instantiated.</p>
 *
 * @return New instance of an <code>XPath</code>.
 * @apiSince 8
 */

public abstract javax.xml.xpath.XPath newXPath();

/**
 * <p>Default Object Model URI.</p>
 * @apiSince 8
 */

public static final java.lang.String DEFAULT_OBJECT_MODEL_URI = "http://java.sun.com/jaxp/xpath/dom";

/**
 * <p>The default property name according to the JAXP spec.</p>
 * @apiSince 8
 */

public static final java.lang.String DEFAULT_PROPERTY_NAME = "javax.xml.xpath.XPathFactory";
}

