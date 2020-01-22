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
// $Id: XPath.java 569998 2007-08-27 04:40:02Z mrglavas $



package javax.xml.xpath;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import org.xml.sax.InputSource;

/**
 * <p><code>XPath</code> provides access to the XPath evaluation environment and expressions.</p>
 *
 * <table id="XPath-evaluation" border="1" cellpadding="2">
 *   <thead>
 *     <tr>
 *       <th colspan="2">Evaluation of XPath Expressions.</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>context</td>
 *       <td>
 *         If a request is made to evaluate the expression in the absence
 * of a context item, an empty document node will be used for the context.
 * For the purposes of evaluating XPath expressions, a DocumentFragment
 * is treated like a Document node.
 *      </td>
 *    </tr>
 *    <tr>
 *      <td>variables</td>
 *      <td>
 *        If the expression contains a variable reference, its value will be found through the {@link javax.xml.xpath.XPathVariableResolver XPathVariableResolver}
 *        set with {@link #setXPathVariableResolver(javax.xml.xpath.XPathVariableResolver)}.
 *        An {@link javax.xml.xpath.XPathExpressionException XPathExpressionException} is raised if the variable resolver is undefined or
 *        the resolver returns <code>null</code> for the variable.
 *        The value of a variable must be immutable through the course of any single evaluation.</p>
 *      </td>
 *    </tr>
 *    <tr>
 *      <td>functions</td>
 *      <td>
 *        If the expression contains a function reference, the function will be found through the {@link javax.xml.xpath.XPathFunctionResolver XPathFunctionResolver}
 *        set with {@link #setXPathFunctionResolver(javax.xml.xpath.XPathFunctionResolver)}.
 *        An {@link javax.xml.xpath.XPathExpressionException XPathExpressionException} is raised if the function resolver is undefined or
 *        the function resolver returns <code>null</code> for the function.</p>
 *      </td>
 *    </tr>
 *    <tr>
 *      <td>QNames</td>
 *      <td>
 *        QNames in the expression are resolved against the XPath namespace context
 *        set with {@link #setNamespaceContext(javax.xml.namespace.NamespaceContext)}.
 *      </td>
 *    </tr>
 *    <tr>
 *      <td>result</td>
 *      <td>
 *        This result of evaluating an expression is converted to an instance of the desired return type.
 *        Valid return types are defined in {@link javax.xml.xpath.XPathConstants XPathConstants}.
 *        Conversion to the return type follows XPath conversion rules.</p>
 *      </td>
 *    </tr>
 * </table>
 *
 * @author  <a href="Norman.Walsh@Sun.com">Norman Walsh</a>
 * @author  <a href="Jeff.Suttor@Sun.com">Jeff Suttor</a>
 * @version $Revision: 569998 $, $Date: 2007-08-26 21:40:02 -0700 (Sun, 26 Aug 2007) $
 * @see <a href="http://www.w3.org/TR/xpath">XML Path Language (XPath) Version 1.0</a>
 * @since 1.5
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface XPath {

/**
 * <p>Reset this <code>XPath</code> to its original configuration.</p>
 *
 * <p><code>XPath</code> is reset to the same state as when it was created with
 * {@link javax.xml.xpath.XPathFactory#newXPath() XPathFactory#newXPath()}.
 * <code>reset()</code> is designed to allow the reuse of existing <code>XPath</code>s
 * thus saving resources associated with the creation of new <code>XPath</code>s.</p>
 *
 * <p>The reset <code>XPath</code> is not guaranteed to have the same {@link javax.xml.xpath.XPathFunctionResolver XPathFunctionResolver}, {@link javax.xml.xpath.XPathVariableResolver XPathVariableResolver}
 * or {@link javax.xml.namespace.NamespaceContext NamespaceContext} <code>Object</code>s, e.g. {@link java.lang.Object#equals(java.lang.Object) Object#equals(Object obj)}.
 * It is guaranteed to have a functionally equal <code>XPathFunctionResolver</code>, <code>XPathVariableResolver</code>
 * and <code>NamespaceContext</code>.</p>
 * @apiSince 8
 */

public void reset();

/**
 * <p>Establish a variable resolver.</p>
 *
 * <p>A <code>NullPointerException</code> is thrown if <code>resolver</code> is <code>null</code>.</p>
 *
 * @param resolver Variable resolver.
 *
 *  @throws java.lang.NullPointerException If <code>resolver</code> is <code>null</code>.
 * @apiSince 8
 */

public void setXPathVariableResolver(javax.xml.xpath.XPathVariableResolver resolver);

/**
 * <p>Return the current variable resolver.</p>
 *
 * <p><code>null</code> is returned in no variable resolver is in effect.</p>
 *
 * @return Current variable resolver.
 * @apiSince 8
 */

public javax.xml.xpath.XPathVariableResolver getXPathVariableResolver();

/**
 * <p>Establish a function resolver.</p>
 *
 * <p>A <code>NullPointerException</code> is thrown if <code>resolver</code> is <code>null</code>.</p>
 *
 * @param resolver XPath function resolver.
 *
 * @throws java.lang.NullPointerException If <code>resolver</code> is <code>null</code>.
 * @apiSince 8
 */

public void setXPathFunctionResolver(javax.xml.xpath.XPathFunctionResolver resolver);

/**
 * <p>Return the current function resolver.</p>
 *
 * <p><code>null</code> is returned in no function resolver is in effect.</p>
 *
 * @return Current function resolver.
 * @apiSince 8
 */

public javax.xml.xpath.XPathFunctionResolver getXPathFunctionResolver();

/**
 * <p>Establish a namespace context.</p>
 *
 * <p>A <code>NullPointerException</code> is thrown if <code>nsContext</code> is <code>null</code>.</p>
 *
 * @param nsContext Namespace context to use.
 *
 * @throws java.lang.NullPointerException If <code>nsContext</code> is <code>null</code>.
 * @apiSince 8
 */

public void setNamespaceContext(javax.xml.namespace.NamespaceContext nsContext);

/**
 * <p>Return the current namespace context.</p>
 *
 * <p><code>null</code> is returned in no namespace context is in effect.</p>
 *
 * @return Current Namespace context.
 * @apiSince 8
 */

public javax.xml.namespace.NamespaceContext getNamespaceContext();

/**
 * <p>Compile an XPath expression for later evaluation.</p>
 *
 * <p>If <code>expression</code> contains any {@link javax.xml.xpath.XPathFunction XPathFunction}s,
 * they must be available via the {@link javax.xml.xpath.XPathFunctionResolver XPathFunctionResolver}.
 * An {@link javax.xml.xpath.XPathExpressionException XPathExpressionException} will be thrown if the <code>XPathFunction</code>
 * cannot be resolved with the <code>XPathFunctionResolver</code>.</p>
 *
 * <p>If <code>expression</code> is <code>null</code>, a <code>NullPointerException</code> is thrown.</p>
 *
 * @param expression The XPath expression.
 *
 * @return Compiled XPath expression.
 
 * @throws javax.xml.xpath.XPathExpressionException If <code>expression</code> cannot be compiled.
 * @throws java.lang.NullPointerException If <code>expression</code> is <code>null</code>.
 * @apiSince 8
 */

public javax.xml.xpath.XPathExpression compile(java.lang.String expression) throws javax.xml.xpath.XPathExpressionException;

/**
 * <p>Evaluate an <code>XPath</code> expression in the specified context and return the result as the specified type.</p>
 *
 * <p>See <a href="#XPath-evaluation">Evaluation of XPath Expressions</a> for context item evaluation,
 * variable, function and <code>QName</code> resolution and return type conversion.</p>
 *
 * <p>If <code>returnType</code> is not one of the types defined in {@link javax.xml.xpath.XPathConstants XPathConstants} (
 * {@link javax.xml.xpath.XPathConstants#NUMBER XPathConstants#NUMBER},
 * {@link javax.xml.xpath.XPathConstants#STRING XPathConstants#STRING},
 * {@link javax.xml.xpath.XPathConstants#BOOLEAN XPathConstants#BOOLEAN},
 * {@link javax.xml.xpath.XPathConstants#NODE XPathConstants#NODE} or
 * {@link javax.xml.xpath.XPathConstants#NODESET XPathConstants#NODESET})
 * then an <code>IllegalArgumentException</code> is thrown.</p>
 *
 * <p>If a <code>null</code> value is provided for
 * <code>item</code>, an empty document will be used for the
 * context.
 * If <code>expression</code> or <code>returnType</code> is <code>null</code>, then a
 * <code>NullPointerException</code> is thrown.</p>
 *
 * @param expression The XPath expression.
 * @param item The starting context (node or node list, for example).
 * @param returnType The desired return type.
 *
 * @return Result of evaluating an XPath expression as an <code>Object</code> of <code>returnType</code>.
 *
 * @throws javax.xml.xpath.XPathExpressionException If <code>expression</code> cannot be evaluated.
 * @throws java.lang.IllegalArgumentException If <code>returnType</code> is not one of the types defined in {@link javax.xml.xpath.XPathConstants XPathConstants}.
 * @throws java.lang.NullPointerException If <code>expression</code> or <code>returnType</code> is <code>null</code>.
 * @apiSince 8
 */

public java.lang.Object evaluate(java.lang.String expression, java.lang.Object item, javax.xml.namespace.QName returnType) throws javax.xml.xpath.XPathExpressionException;

/**
 * <p>Evaluate an XPath expression in the specified context and return the result as a <code>String</code>.</p>
 *
 * <p>This method calls {@link #evaluate(java.lang.String,java.lang.Object,javax.xml.namespace.QName)} with a <code>returnType</code> of
 * {@link javax.xml.xpath.XPathConstants#STRING XPathConstants#STRING}.</p>
 *
 * <p>See <a href="#XPath-evaluation">Evaluation of XPath Expressions</a> for context item evaluation,
 * variable, function and QName resolution and return type conversion.</p>
 *
 * <p>If a <code>null</code> value is provided for
 * <code>item</code>, an empty document will be used for the
 * context.
 * If <code>expression</code> is <code>null</code>, then a <code>NullPointerException</code> is thrown.</p>
 *
 * @param expression The XPath expression.
 * @param item The starting context (node or node list, for example).
 *
 * @return The <code>String</code> that is the result of evaluating the expression and
 *   converting the result to a <code>String</code>.
 *
 * @throws javax.xml.xpath.XPathExpressionException If <code>expression</code> cannot be evaluated.
 * @throws java.lang.NullPointerException If <code>expression</code> is <code>null</code>.
 * @apiSince 8
 */

public java.lang.String evaluate(java.lang.String expression, java.lang.Object item) throws javax.xml.xpath.XPathExpressionException;

/**
 * <p>Evaluate an XPath expression in the context of the specified <code>InputSource</code>
 * and return the result as the specified type.</p>
 *
 * <p>This method builds a data model for the {@link org.xml.sax.InputSource InputSource} and calls
 * {@link #evaluate(java.lang.String,java.lang.Object,javax.xml.namespace.QName)} on the resulting document object.</p>
 *
 * <p>See <a href="#XPath-evaluation">Evaluation of XPath Expressions</a> for context item evaluation,
 * variable, function and QName resolution and return type conversion.</p>
 *
 * <p>If <code>returnType</code> is not one of the types defined in {@link javax.xml.xpath.XPathConstants XPathConstants},
 * then an <code>IllegalArgumentException</code> is thrown.</p>
 *
 * <p>If <code>expression</code>, <code>source</code> or <code>returnType</code> is <code>null</code>,
 * then a <code>NullPointerException</code> is thrown.</p>
 *
 * @param expression The XPath expression.
 * @param source The input source of the document to evaluate over.
 * @param returnType The desired return type.
 *
 * @return The <code>Object</code> that encapsulates the result of evaluating the expression.
 *
 * @throws javax.xml.xpath.XPathExpressionException If expression cannot be evaluated.
 * @throws java.lang.IllegalArgumentException If <code>returnType</code> is not one of the types defined in {@link javax.xml.xpath.XPathConstants XPathConstants}.
 * @throws java.lang.NullPointerException If <code>expression</code>, <code>source</code> or <code>returnType</code>
 *   is <code>null</code>.
 * @apiSince 8
 */

public java.lang.Object evaluate(java.lang.String expression, org.xml.sax.InputSource source, javax.xml.namespace.QName returnType) throws javax.xml.xpath.XPathExpressionException;

/**
 * <p>Evaluate an XPath expression in the context of the specified <code>InputSource</code>
 * and return the result as a <code>String</code>.</p>
 *
 * <p>This method calls {@link #evaluate(java.lang.String,org.xml.sax.InputSource,javax.xml.namespace.QName)} with a
 * <code>returnType</code> of {@link javax.xml.xpath.XPathConstants#STRING XPathConstants#STRING}.</p>
 *
 * <p>See <a href="#XPath-evaluation">Evaluation of XPath Expressions</a> for context item evaluation,
 * variable, function and QName resolution and return type conversion.</p>
 *
 * <p>If <code>expression</code> or <code>source</code> is <code>null</code>,
 * then a <code>NullPointerException</code> is thrown.</p>
 *
 * @param expression The XPath expression.
 * @param source The <code>InputSource</code> of the document to evaluate over.
 *
 * @return The <code>String</code> that is the result of evaluating the expression and
 *   converting the result to a <code>String</code>.
 *
 * @throws javax.xml.xpath.XPathExpressionException If expression cannot be evaluated.
 * @throws java.lang.NullPointerException If <code>expression</code> or <code>source</code> is <code>null</code>.
 * @apiSince 8
 */

public java.lang.String evaluate(java.lang.String expression, org.xml.sax.InputSource source) throws javax.xml.xpath.XPathExpressionException;
}

