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

// $Id: DOMResult.java 569995 2007-08-27 04:31:06Z mrglavas $



package javax.xml.transform.dom;

import org.w3c.dom.Node;
import javax.xml.transform.Result;

/**
 * <p>Acts as a holder for a transformation result tree in the form of a Document Object Model (DOM) tree.</p>
 *
 * <p>If no output DOM source is set, the transformation will create a Document node as the holder for the result of the transformation,
 * which may be retrieved with {@link #getNode()}.</p>
 *
 * @author <a href="Jeff.Suttor@Sun.com">Jeff Suttor</a>
 * @version $Revision: 569995 $, $Date: 2007-08-26 21:31:06 -0700 (Sun, 26 Aug 2007) $
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DOMResult implements javax.xml.transform.Result {

/**
 * <p>Zero-argument default constructor.</p>
 *
 * <p><code>node</code>,
 * <code>siblingNode</code> and
 * <code>systemId</code>
 * will be set to <code>null</code>.</p>
 * @apiSince 8
 */

public DOMResult() { throw new RuntimeException("Stub!"); }

/**
 * <p>Use a DOM node to create a new output target.</p>
 *
 * <p>In practice, the node should be
 * a {@link org.w3c.dom.Document} node,
 * a {@link org.w3c.dom.DocumentFragment} node, or
 * a {@link org.w3c.dom.Element} node.
 * In other words, a node that accepts children.</p>
 *
 * <p><code>siblingNode</code> and
 * <code>systemId</code>
 * will be set to <code>null</code>.</p>
 *
 * @param node The DOM node that will contain the result tree.
 * @apiSince 8
 */

public DOMResult(org.w3c.dom.Node node) { throw new RuntimeException("Stub!"); }

/**
 * <p>Use a DOM node to create a new output target with the specified System ID.<p>
 *
 * <p>In practice, the node should be
 * a {@link org.w3c.dom.Document} node,
 * a {@link org.w3c.dom.DocumentFragment} node, or
 * a {@link org.w3c.dom.Element} node.
 * In other words, a node that accepts children.</p>
 *
 * <p><code>siblingNode</code> will be set to <code>null</code>.</p>
 *
 * @param node The DOM node that will contain the result tree.
 * @param systemId The system identifier which may be used in association with this node.
 * @apiSince 8
 */

public DOMResult(org.w3c.dom.Node node, java.lang.String systemId) { throw new RuntimeException("Stub!"); }

/**
 * <p>Use a DOM node to create a new output target specifying the child node where the result nodes should be inserted before.</p>
 *
 * <p>In practice, <code>node</code> and <code>nextSibling</code> should be
 * a {@link org.w3c.dom.Document} node,
 * a {@link org.w3c.dom.DocumentFragment} node, or
 * a {@link org.w3c.dom.Element} node.
 * In other words, a node that accepts children.</p>
 *
 * <p>Use <code>nextSibling</code> to specify the child node
 * where the result nodes should be inserted before.
 * If <code>nextSibling</code> is not a sibling of <code>node</code>,
 * then an <code>IllegalArgumentException</code> is thrown.
 * If <code>node</code> is <code>null</code> and <code>nextSibling</code> is not <code>null</code>,
 * then an <code>IllegalArgumentException</code> is thrown.
 * If <code>nextSibling</code> is <code>null</code>,
 * then the behavior is the same as calling {@link #DOMResult(org.w3c.dom.Node)},
 * i.e. append the result nodes as the last child of the specified <code>node</code>.</p>
 *
 * <p><code>systemId</code> will be set to <code>null</code>.</p>
 *
 * @param node The DOM node that will contain the result tree.
 * @param nextSibling The child node where the result nodes should be inserted before.
 *
 * @throws java.lang.IllegalArgumentException If <code>nextSibling</code> is not a sibling of <code>node</code>.
 * @throws java.lang.IllegalArgumentException If <code>node</code> is <code>null</code> and <code>nextSibling</code> is not <code>null</code>.
 *
 * @since 1.5
 * @apiSince 8
 */

public DOMResult(org.w3c.dom.Node node, org.w3c.dom.Node nextSibling) { throw new RuntimeException("Stub!"); }

/**
 * <p>Use a DOM node to create a new output target specifying the child node where the result nodes should be inserted before and
 * the specified System ID.</p>
 *
 * <p>In practice, <code>node</code> and <code>nextSibling</code> should be
 * a {@link org.w3c.dom.Document} node,
 * a {@link org.w3c.dom.DocumentFragment} node, or a
 * {@link org.w3c.dom.Element} node.
 * In other words, a node that accepts children.</p>
 *
 * <p>Use <code>nextSibling</code> to specify the child node
 * where the result nodes should be inserted before.
 * If <code>nextSibling</code> is not a sibling of <code>node</code>,
 * then an <code>IllegalArgumentException</code> is thrown.
 * If <code>node</code> is <code>null</code> and <code>nextSibling</code> is not <code>null</code>,
 * then an <code>IllegalArgumentException</code> is thrown.
 * If <code>nextSibling</code> is <code>null</code>,
 * then the behavior is the same as calling {@link #DOMResult(org.w3c.dom.Node,java.lang.String)},
 * i.e. append the result nodes as the last child of the specified node and use the specified System ID.</p>
 *
 * @param node The DOM node that will contain the result tree.
 * @param nextSibling The child node where the result nodes should be inserted before.
 * @param systemId The system identifier which may be used in association with this node.
 *
 * @throws java.lang.IllegalArgumentException If <code>nextSibling</code> is not a sibling of <code>node</code>.
 * @throws java.lang.IllegalArgumentException If <code>node</code> is <code>null</code> and <code>nextSibling</code> is not <code>null</code>.
 *
 * @since 1.5
 * @apiSince 8
 */

public DOMResult(org.w3c.dom.Node node, org.w3c.dom.Node nextSibling, java.lang.String systemId) { throw new RuntimeException("Stub!"); }

/**
 * <p>Set the node that will contain the result DOM tree.<p>
 *
 * <p>In practice, the node should be
 * a {@link org.w3c.dom.Document} node,
 * a {@link org.w3c.dom.DocumentFragment} node, or
 * a {@link org.w3c.dom.Element} node.
 * In other words, a node that accepts children.</p>
 *
 * <p>An <code>IllegalStateException</code> is thrown if <code>nextSibling</code> is not <code>null</code> and
 * <code>node</code> is not a parent of <code>nextSibling</code>.
 * An <code>IllegalStateException</code> is thrown if <code>node</code> is <code>null</code> and
 * <code>nextSibling</code> is not <code>null</code>.</p>
 *
 * @param node The node to which the transformation will be appended.
 *
 * @throws java.lang.IllegalStateException If <code>nextSibling</code> is not <code>null</code> and
 *   <code>nextSibling</code> is not a child of <code>node</code>.
 * @throws java.lang.IllegalStateException If <code>node</code> is <code>null</code> and
 *   <code>nextSibling</code> is not <code>null</code>.
 * @apiSince 8
 */

public void setNode(org.w3c.dom.Node node) { throw new RuntimeException("Stub!"); }

/**
 * <p>Get the node that will contain the result DOM tree.</p>
 *
 * <p>If no node was set via
 * {@link #DOMResult(org.w3c.dom.Node)},
 * {@link #DOMResult(org.w3c.dom.Node,java.lang.String)},
 * {@link #DOMResult(org.w3c.dom.Node,org.w3c.dom.Node)},
 * {@link #DOMResult(org.w3c.dom.Node,org.w3c.dom.Node,java.lang.String)} or
 * {@link #setNode(org.w3c.dom.Node)},
 * then the node will be set by the transformation, and may be obtained from this method once the transformation is complete.
 * Calling this method before the transformation will return <code>null</code>.</p>
 *
 * @return The node to which the transformation will be appended.
 * @apiSince 8
 */

public org.w3c.dom.Node getNode() { throw new RuntimeException("Stub!"); }

/**
 * <p>Set the child node before which the result nodes will be inserted.</p>
 *
 * <p>Use <code>nextSibling</code> to specify the child node
 * before which the result nodes should be inserted.
 * If <code>nextSibling</code> is not a descendant of <code>node</code>,
 * then an <code>IllegalArgumentException</code> is thrown.
 * If <code>node</code> is <code>null</code> and <code>nextSibling</code> is not <code>null</code>,
 * then an <code>IllegalStateException</code> is thrown.
 * If <code>nextSibling</code> is <code>null</code>,
 * then the behavior is the same as calling {@link #DOMResult(org.w3c.dom.Node)},
 * i.e. append the result nodes as the last child of the specified <code>node</code>.</p>
 *
 * @param nextSibling The child node before which the result nodes will be inserted.
 *
 * @throws java.lang.IllegalArgumentException If <code>nextSibling</code> is not a descendant of <code>node</code>.
 * @throws java.lang.IllegalStateException If <code>node</code> is <code>null</code> and <code>nextSibling</code> is not <code>null</code>.
 *
 * @since 1.5
 * @apiSince 8
 */

public void setNextSibling(org.w3c.dom.Node nextSibling) { throw new RuntimeException("Stub!"); }

/**
 * <p>Get the child node before which the result nodes will be inserted.</p>
 *
 * <p>If no node was set via
 * {@link #DOMResult(org.w3c.dom.Node,org.w3c.dom.Node)},
 * {@link #DOMResult(org.w3c.dom.Node,org.w3c.dom.Node,java.lang.String)} or
 * {@link #setNextSibling(org.w3c.dom.Node)},
 * then <code>null</code> will be returned.</p>
 *
 * @return The child node before which the result nodes will be inserted.
 *
 * @since 1.5
 * @apiSince 8
 */

public org.w3c.dom.Node getNextSibling() { throw new RuntimeException("Stub!"); }

/**
 * <p>Set the systemId that may be used in association with the node.</p>
 *
 * @param systemId The system identifier as a URI string.
 * @apiSince 8
 */

public void setSystemId(java.lang.String systemId) { throw new RuntimeException("Stub!"); }

/**
 * <p>Get the System Identifier.</p>
 *
 * <p>If no System ID was set via
 * {@link #DOMResult(org.w3c.dom.Node,java.lang.String)},
 * {@link #DOMResult(org.w3c.dom.Node,org.w3c.dom.Node,java.lang.String)} or
 * {@link #setSystemId(java.lang.String)},
 * then <code>null</code> will be returned.</p>
 *
 * @return The system identifier.
 * @apiSince 8
 */

public java.lang.String getSystemId() { throw new RuntimeException("Stub!"); }

/** <p>If {@link javax.xml.transform.TransformerFactory#getFeature}
 * returns <code>true</code> when passed this value as an argument,
 * the <code>Transformer</code> supports <code>Result</code> output of this type.</p>
 * @apiSince 8
 */

public static final java.lang.String FEATURE = "http://javax.xml.transform.dom.DOMResult/feature";
}

