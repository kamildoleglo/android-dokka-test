/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/params/HttpParams.java $
 * $Revision: 610763 $
 * $Date: 2008-01-10 04:01:13 -0800 (Thu, 10 Jan 2008) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


package org.apache.http.params;


/**
 * Represents a collection of HTTP protocol and framework parameters.
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 *
 * @version $Revision: 610763 $
 *
 * @since 4.0
 *
 * @deprecated Please use {@link java.net.URL#openConnection} instead.
 *     Please visit <a href="http://android-developers.blogspot.com/2011/09/androids-http-clients.html">this webpage</a>
 *     for further details.
 * @apiSince 1
 * @deprecatedSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public interface HttpParams {

/** 
 * Obtains the value of the given parameter.
 *
 * @param name the parent name.
 *
 * @return  an object that represents the value of the parameter,
 *          <code>null</code> if the parameter is not set or if it
 *          is explicitly set to <code>null</code>
 *
 * @see #setParameter(String, Object)
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public java.lang.Object getParameter(java.lang.String name);

/**
 * Assigns the value to the parameter with the given name.
 *
 * @param name parameter name
 * @param value parameter value
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public org.apache.http.params.HttpParams setParameter(java.lang.String name, java.lang.Object value);

/**
 * Creates a copy of these parameters.
 *
 * @return  a new set of parameters holding the same values as this one
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public org.apache.http.params.HttpParams copy();

/**
 * Removes the parameter with the specified name.
 *
 * @param name parameter name
 *
 * @return true if the parameter existed and has been removed, false else.
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public boolean removeParameter(java.lang.String name);

/** 
 * Returns a {@link java.lang.Long Long} parameter value with the given name.
 * If the parameter is not explicitly set, the default value is returned.
 *
 * @param name the parent name.
 * @param defaultValue the default value.
 *
 * @return a {@link java.lang.Long Long} that represents the value of the parameter.
 *
 * @see #setLongParameter(String, long)
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public long getLongParameter(java.lang.String name, long defaultValue);

/**
 * Assigns a {@link java.lang.Long Long} to the parameter with the given name
 *
 * @param name parameter name
 * @param value parameter value
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public org.apache.http.params.HttpParams setLongParameter(java.lang.String name, long value);

/** 
 * Returns an {@link java.lang.Integer Integer} parameter value with the given name.
 * If the parameter is not explicitly set, the default value is returned.
 *
 * @param name the parent name.
 * @param defaultValue the default value.
 *
 * @return a {@link java.lang.Integer Integer} that represents the value of the parameter.
 *
 * @see #setIntParameter(String, int)
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public int getIntParameter(java.lang.String name, int defaultValue);

/**
 * Assigns an {@link java.lang.Integer Integer} to the parameter with the given name
 *
 * @param name parameter name
 * @param value parameter value
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public org.apache.http.params.HttpParams setIntParameter(java.lang.String name, int value);

/** 
 * Returns a {@link java.lang.Double Double} parameter value with the given name.
 * If the parameter is not explicitly set, the default value is returned.
 *
 * @param name the parent name.
 * @param defaultValue the default value.
 *
 * @return a {@link java.lang.Double Double} that represents the value of the parameter.
 *
 * @see #setDoubleParameter(String, double)
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public double getDoubleParameter(java.lang.String name, double defaultValue);

/**
 * Assigns a {@link java.lang.Double Double} to the parameter with the given name
 *
 * @param name parameter name
 * @param value parameter value
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public org.apache.http.params.HttpParams setDoubleParameter(java.lang.String name, double value);

/** 
 * Returns a {@link java.lang.Boolean Boolean} parameter value with the given name.
 * If the parameter is not explicitly set, the default value is returned.
 *
 * @param name the parent name.
 * @param defaultValue the default value.
 *
 * @return a {@link java.lang.Boolean Boolean} that represents the value of the parameter.
 *
 * @see #setBooleanParameter(String, boolean)
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public boolean getBooleanParameter(java.lang.String name, boolean defaultValue);

/**
 * Assigns a {@link java.lang.Boolean Boolean} to the parameter with the given name
 *
 * @param name parameter name
 * @param value parameter value
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public org.apache.http.params.HttpParams setBooleanParameter(java.lang.String name, boolean value);

/**
 * Checks if a boolean parameter is set to <code>true</code>.
 *
 * @param name parameter name
 *
 * @return <tt>true</tt> if the parameter is set to value <tt>true</tt>,
 *         <tt>false</tt> if it is not set or set to <code>false</code>
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public boolean isParameterTrue(java.lang.String name);

/**
 * Checks if a boolean parameter is not set or <code>false</code>.
 *
 * @param name parameter name
 *
 * @return <tt>true</tt> if the parameter is either not set or
 *         set to value <tt>false</tt>,
 *         <tt>false</tt> if it is set to <code>true</code>
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public boolean isParameterFalse(java.lang.String name);
}

