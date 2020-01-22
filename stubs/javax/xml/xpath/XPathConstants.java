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
// $Id: XPathConstants.java 446598 2006-09-15 12:55:40Z jeremias $



package javax.xml.xpath;


/**
 * <p>XPath constants.</p>
 *
 * @author <a href="mailto:Norman.Walsh@Sun.COM">Norman Walsh</a>
 * @author <a href="mailto:Jeff.Suttor@Sun.COM">Jeff Suttor</a>
 * @version $Revision: 446598 $, $Date: 2006-09-15 05:55:40 -0700 (Fri, 15 Sep 2006) $
 * @see <a href="http://www.w3.org/TR/xpath">XML Path Language (XPath) Version 1.0</a>
 * @since 1.5
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class XPathConstants {

private XPathConstants() { throw new RuntimeException("Stub!"); }

/**
 * <p>The XPath 1.0 boolean data type.</p>
 *
 * <p>Maps to Java {@link java.lang.Boolean Boolean}.</p>
 * @apiSince 8
 */

public static final javax.xml.namespace.QName BOOLEAN;
static { BOOLEAN = null; }

/**
 * <p>The URI for the DOM object model, "http://java.sun.com/jaxp/xpath/dom".</p>
 * @apiSince 8
 */

public static final java.lang.String DOM_OBJECT_MODEL = "http://java.sun.com/jaxp/xpath/dom";

/**
 * <p>The XPath 1.0 NodeSet data type.
 *
 * <p>Maps to Java {@link org.w3c.dom.Node}.</p>
 * @apiSince 8
 */

public static final javax.xml.namespace.QName NODE;
static { NODE = null; }

/**
 * <p>The XPath 1.0 NodeSet data type.</p>
 *
 * <p>Maps to Java {@link org.w3c.dom.NodeList}.</p>
 * @apiSince 8
 */

public static final javax.xml.namespace.QName NODESET;
static { NODESET = null; }

/**
 * <p>The XPath 1.0 number data type.</p>
 *
 * <p>Maps to Java {@link java.lang.Double Double}.</p>
 * @apiSince 8
 */

public static final javax.xml.namespace.QName NUMBER;
static { NUMBER = null; }

/**
 * <p>The XPath 1.0 string data type.</p>
 *
 * <p>Maps to Java {@link java.lang.String String}.</p>
 * @apiSince 8
 */

public static final javax.xml.namespace.QName STRING;
static { STRING = null; }
}

