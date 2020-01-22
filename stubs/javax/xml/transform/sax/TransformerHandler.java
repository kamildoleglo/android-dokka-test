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

// $Id: TransformerHandler.java 446598 2006-09-15 12:55:40Z jeremias $



package javax.xml.transform.sax;

import org.xml.sax.ContentHandler;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;

/**
 * A TransformerHandler
 * listens for SAX ContentHandler parse events and transforms
 * them to a Result.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface TransformerHandler extends org.xml.sax.ContentHandler,  org.xml.sax.ext.LexicalHandler, org.xml.sax.DTDHandler {

/**
 * <p>Set  the <code>Result</code> associated with this
 * <code>TransformerHandler</code> to be used for the transformation.</p>
 *
 * @param result A <code>Result</code> instance, should not be
 *   <code>null</code>.
 *
 * @throws java.lang.IllegalArgumentException if result is invalid for some reason.
 * @apiSince 8
 */

public void setResult(javax.xml.transform.Result result) throws java.lang.IllegalArgumentException;

/**
 * Set the base ID (URI or system ID) from where relative
 * URLs will be resolved.
 * @param systemID Base URI for the source tree.
 * @apiSince 8
 */

public void setSystemId(java.lang.String systemID);

/**
 * Get the base ID (URI or system ID) from where relative
 * URLs will be resolved.
 * @return The systemID that was set with {@link #setSystemId}.
 * @apiSince 8
 */

public java.lang.String getSystemId();

/**
 * <p>Get the <code>Transformer</code> associated with this handler, which
 * is needed in order to set parameters and output properties.</p>
 *
 * @return <code>Transformer</code> associated with this
 *   <code>TransformerHandler</code>.
 * @apiSince 8
 */

public javax.xml.transform.Transformer getTransformer();
}

