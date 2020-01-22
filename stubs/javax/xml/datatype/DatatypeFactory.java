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

//$Id: DatatypeFactory.java 884950 2009-11-27 18:46:18Z mrglavas $



package javax.xml.datatype;

import java.util.GregorianCalendar;
import java.math.BigInteger;
import java.math.BigDecimal;

/**
 * <p>Factory that creates new <code>javax.xml.datatype</code> <code>Object</code>s that map XML to/from Java <code>Object</code>s.</p>
 *
 * <p id="DatatypeFactory.newInstance">{@link #newInstance()} is used to create a new <code>DatatypeFactory</code>.
 * The following implementation resolution mechanisms are used in the following order:</p>
 * <ol>
 *    <li>
 *      If the system property specified by {@link #DATATYPEFACTORY_PROPERTY}, "<code>javax.xml.datatype.DatatypeFactory</code>",
 *      exists, a class with the name of the property's value is instantiated.
 *      Any Exception thrown during the instantiation process is wrapped as a {@link javax.xml.datatype.DatatypeConfigurationException DatatypeConfigurationException}.
 *    </li>
 *    <li>
 *      If the file ${JAVA_HOME}/lib/jaxp.properties exists, it is loaded in a {@link java.util.Properties} <code>Object</code>.
 *      The <code>Properties</code> <code>Object </code> is then queried for the property as documented in the prior step
 *      and processed as documented in the prior step.
 *    </li>
 *    <li>
 *      The services resolution mechanism is used, e.g. <code>META-INF/services/java.xml.datatype.DatatypeFactory</code>.
 *      Any Exception thrown during the instantiation process is wrapped as a {@link javax.xml.datatype.DatatypeConfigurationException DatatypeConfigurationException}.
 *    </li>
 *    <li>
 *      The final mechanism is to attempt to instantiate the <code>Class</code> specified by
 *      {@link #DATATYPEFACTORY_IMPLEMENTATION_CLASS}, "<code>javax.xml.datatype.DatatypeFactoryImpl</code>".
 *      Any Exception thrown during the instantiation process is wrapped as a {@link javax.xml.datatype.DatatypeConfigurationException DatatypeConfigurationException}.
 *    </li>
 * </ol>
 *
 * <p>Note that you must supply your own implementation (such as Xerces); Android does not ship with a default implementation.
 *
 * @author <a href="mailto:Joseph.Fialli@Sun.COM">Joseph Fialli</a>
 * @author <a href="mailto:Jeff.Suttor@Sun.com">Jeff Suttor</a>
 * @version $Revision: 884950 $, $Date: 2009-11-27 10:46:18 -0800 (Fri, 27 Nov 2009) $
 * @since 1.5
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class DatatypeFactory {

/**
 * <p>Protected constructor to prevent instantiation outside of package.</p>
 *
 * <p>Use {@link #newInstance()} to create a <code>DatatypeFactory</code>.</p>
 * @apiSince 8
 */

protected DatatypeFactory() { throw new RuntimeException("Stub!"); }

/**
 * <p>Obtain a new instance of a <code>DatatypeFactory</code>.</p>
 *
 * <p>The implementation resolution mechanisms are <a href="#DatatypeFactory.newInstance">defined</a> in this
 * <code>Class</code>'s documentation.</p>
 * <p>Note that you must supply your own implementation (such as Xerces); Android does not ship with a default implementation.
 *
 * @return New instance of a <code>DocumentBuilderFactory</code>
 *
 * @throws javax.xml.datatype.DatatypeConfigurationException If the implementation is not
 *   available or cannot be instantiated.
 * @apiSince 8
 */

public static javax.xml.datatype.DatatypeFactory newInstance() throws javax.xml.datatype.DatatypeConfigurationException { throw new RuntimeException("Stub!"); }

/**
 * Returns an instance of the named implementation of {@code DatatypeFactory}.
 *
 * @throws javax.xml.datatype.DatatypeConfigurationException if {@code factoryClassName} is not available or cannot
 *     be instantiated.
 * @since 1.6
 * @apiSince 9
 */

public static javax.xml.datatype.DatatypeFactory newInstance(java.lang.String factoryClassName, java.lang.ClassLoader classLoader) throws javax.xml.datatype.DatatypeConfigurationException { throw new RuntimeException("Stub!"); }

/**
 * <p>Obtain a new instance of a <code>Duration</code>
 * specifying the <code>Duration</code> as its string representation, "PnYnMnDTnHnMnS",
 * as defined in XML Schema 1.0 section 3.2.6.1.</p>
 *
 * <p>XML Schema Part 2: Datatypes, 3.2.6 duration, defines <code>duration</code> as:</p>
 * <blockquote>
 * duration represents a duration of time.
 * The value space of duration is a six-dimensional space where the coordinates designate the
 * Gregorian year, month, day, hour, minute, and second components defined in Section 5.5.3.2 of [ISO 8601], respectively.
 * These components are ordered in their significance by their order of appearance i.e. as
 * year, month, day, hour, minute, and second.
 * </blockquote>
 * <p>All six values are set and available from the created {@link javax.xml.datatype.Duration Duration}</p>
 *
 * <p>The XML Schema specification states that values can be of an arbitrary size.
 * Implementations may chose not to or be incapable of supporting arbitrarily large and/or small values.
 * An {@link java.lang.UnsupportedOperationException UnsupportedOperationException} will be thrown with a message indicating implementation limits
 * if implementation capacities are exceeded.</p>
 *
 * @param lexicalRepresentation <code>String</code> representation of a <code>Duration</code>.
 *
 * @return New <code>Duration</code> created from parsing the <code>lexicalRepresentation</code>.
 *
 * @throws java.lang.IllegalArgumentException If <code>lexicalRepresentation</code> is not a valid representation of a <code>Duration</code>.
 * @throws java.lang.UnsupportedOperationException If implementation cannot support requested values.
 * @throws java.lang.NullPointerException if <code>lexicalRepresentation</code> is <code>null</code>.
 * @apiSince 8
 */

public abstract javax.xml.datatype.Duration newDuration(java.lang.String lexicalRepresentation);

/**
 * <p>Obtain a new instance of a <code>Duration</code>
 * specifying the <code>Duration</code> as milliseconds.</p>
 *
 * <p>XML Schema Part 2: Datatypes, 3.2.6 duration, defines <code>duration</code> as:</p>
 * <blockquote>
 * duration represents a duration of time.
 * The value space of duration is a six-dimensional space where the coordinates designate the
 * Gregorian year, month, day, hour, minute, and second components defined in Section 5.5.3.2 of [ISO 8601], respectively.
 * These components are ordered in their significance by their order of appearance i.e. as
 * year, month, day, hour, minute, and second.
 * </blockquote>
 * <p>All six values are set by computing their values from the specified milliseconds
 * and are available using the <code>get</code> methods of  the created {@link javax.xml.datatype.Duration Duration}.
 * The values conform to and are defined by:</p>
 * <ul>
 *   <li>ISO 8601:2000(E) Section 5.5.3.2 Alternative format</li>
 *   <li><a href="http://www.w3.org/TR/xmlschema-2/#isoformats">
 *     W3C XML Schema 1.0 Part 2, Appendix D, ISO 8601 Date and Time Formats</a>
 *   </li>
 *   <li>{@link javax.xml.datatype.XMLGregorianCalendar XMLGregorianCalendar}  Date/Time Datatype Field Mapping Between XML Schema 1.0 and Java Representation</li>
 * </ul>
 *
 * <p>The default start instance is defined by {@link java.util.GregorianCalendar GregorianCalendar}'s use of the start of the epoch: i.e.,
 * {@link java.util.Calendar#YEAR} = 1970,
 * {@link java.util.Calendar#MONTH} = {@link java.util.Calendar#JANUARY},
 * {@link java.util.Calendar#DATE} = 1, etc.
 * This is important as there are variations in the Gregorian Calendar,
 * e.g. leap years have different days in the month = {@link java.util.Calendar#FEBRUARY}
 * so the result of {@link javax.xml.datatype.Duration#getMonths() Duration#getMonths()} and {@link javax.xml.datatype.Duration#getDays() Duration#getDays()} can be influenced.</p>
 *
 * @param durationInMilliSeconds Duration in milliseconds to create.
 *
 * @return New <code>Duration</code> representing <code>durationInMilliSeconds</code>.
 * @apiSince 8
 */

public abstract javax.xml.datatype.Duration newDuration(long durationInMilliSeconds);

/**
 * <p>Obtain a new instance of a <code>Duration</code>
 * specifying the <code>Duration</code> as isPositive, years, months, days, hours, minutes, seconds.</p>
 *
 * <p>The XML Schema specification states that values can be of an arbitrary size.
 * Implementations may chose not to or be incapable of supporting arbitrarily large and/or small values.
 * An {@link java.lang.UnsupportedOperationException UnsupportedOperationException} will be thrown with a message indicating implementation limits
 * if implementation capacities are exceeded.</p>
 *
 * <p>A <code>null</code> value indicates that field is not set.</p>
 *
 * @param isPositive Set to <code>false</code> to create a negative duration. When the length
 *   of the duration is zero, this parameter will be ignored.
 * @param years of this <code>Duration</code>
 * @param months of this <code>Duration</code>
 * @param days of this <code>Duration</code>
 * @param hours of this <code>Duration</code>
 * @param minutes of this <code>Duration</code>
 * @param seconds of this <code>Duration</code>
 *
 * @return New <code>Duration</code> created from the specified values.
 *
 * @throws java.lang.IllegalArgumentException If values are not a valid representation of a <code>Duration</code>.
 * @throws java.lang.UnsupportedOperationException If implementation cannot support requested values.
 * @apiSince 8
 */

public abstract javax.xml.datatype.Duration newDuration(boolean isPositive, java.math.BigInteger years, java.math.BigInteger months, java.math.BigInteger days, java.math.BigInteger hours, java.math.BigInteger minutes, java.math.BigDecimal seconds);

/**
 * <p>Obtain a new instance of a <code>Duration</code>
 * specifying the <code>Duration</code> as isPositive, years, months, days, hours, minutes, seconds.</p>
 *
 * <p>A {@link javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED DatatypeConstants#FIELD_UNDEFINED} value indicates that field is not set.</p>
 *
 * @param isPositive Set to <code>false</code> to create a negative duration. When the length
 *   of the duration is zero, this parameter will be ignored.
 * @param years of this <code>Duration</code>
 * @param months of this <code>Duration</code>
 * @param days of this <code>Duration</code>
 * @param hours of this <code>Duration</code>
 * @param minutes of this <code>Duration</code>
 * @param seconds of this <code>Duration</code>
 *
 * @return New <code>Duration</code> created from the specified values.
 *
 * @throws java.lang.IllegalArgumentException If values are not a valid representation of a <code>Duration</code>.
 *
 * @see #newDuration(
 *   boolean isPositive,
 *   BigInteger years,
 *   BigInteger months,
 *   BigInteger days,
 *   BigInteger hours,
 *   BigInteger minutes,
 *   BigDecimal seconds)
 * @apiSince 8
 */

public javax.xml.datatype.Duration newDuration(boolean isPositive, int years, int months, int days, int hours, int minutes, int seconds) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a <code>Duration</code> of type <code>xdt:dayTimeDuration</code> by parsing its <code>String</code> representation,
 * "<em>PnDTnHnMnS</em>", <a href="http://www.w3.org/TR/xpath-datamodel#dt-dayTimeDuration">
 *   XQuery 1.0 and XPath 2.0 Data Model, xdt:dayTimeDuration</a>.</p>
 *
 * <p>The datatype <code>xdt:dayTimeDuration</code> is a subtype of <code>xs:duration</code>
 * whose lexical representation contains only day, hour, minute, and second components.
 * This datatype resides in the namespace <code>http://www.w3.org/2003/11/xpath-datatypes</code>.</p>
 *
 * <p>All four values are set and available from the created {@link javax.xml.datatype.Duration Duration}</p>
 *
 * <p>The XML Schema specification states that values can be of an arbitrary size.
 * Implementations may chose not to or be incapable of supporting arbitrarily large and/or small values.
 * An {@link java.lang.UnsupportedOperationException UnsupportedOperationException} will be thrown with a message indicating implementation limits
 * if implementation capacities are exceeded.</p>
 *
 * @param lexicalRepresentation Lexical representation of a duration.
 *
 * @return New <code>Duration</code> created using the specified <code>lexicalRepresentation</code>.
 *
 * @throws java.lang.IllegalArgumentException If the given string does not conform to the aforementioned specification.
 * @throws java.lang.UnsupportedOperationException If implementation cannot support requested values.
 * @throws java.lang.NullPointerException If <code>lexicalRepresentation</code> is <code>null</code>.
 * @apiSince 8
 */

public javax.xml.datatype.Duration newDurationDayTime(java.lang.String lexicalRepresentation) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a <code>Duration</code> of type <code>xdt:dayTimeDuration</code> using the specified milliseconds as defined in
 * <a href="http://www.w3.org/TR/xpath-datamodel#dt-dayTimeDuration">
 *   XQuery 1.0 and XPath 2.0 Data Model, xdt:dayTimeDuration</a>.</p>
 *
 * <p>The datatype <code>xdt:dayTimeDuration</code> is a subtype of <code>xs:duration</code>
 * whose lexical representation contains only day, hour, minute, and second components.
 * This datatype resides in the namespace <code>http://www.w3.org/2003/11/xpath-datatypes</code>.</p>
 *
 * <p>All four values are set by computing their values from the specified milliseconds
 * and are available using the <code>get</code> methods of  the created {@link javax.xml.datatype.Duration Duration}.
 * The values conform to and are defined by:</p>
 * <ul>
 *   <li>ISO 8601:2000(E) Section 5.5.3.2 Alternative format</li>
 *   <li><a href="http://www.w3.org/TR/xmlschema-2/#isoformats">
 *     W3C XML Schema 1.0 Part 2, Appendix D, ISO 8601 Date and Time Formats</a>
 *   </li>
 *   <li>{@link javax.xml.datatype.XMLGregorianCalendar XMLGregorianCalendar}  Date/Time Datatype Field Mapping Between XML Schema 1.0 and Java Representation</li>
 * </ul>
 *
 * <p>The default start instance is defined by {@link java.util.GregorianCalendar GregorianCalendar}'s use of the start of the epoch: i.e.,
 * {@link java.util.Calendar#YEAR} = 1970,
 * {@link java.util.Calendar#MONTH} = {@link java.util.Calendar#JANUARY},
 * {@link java.util.Calendar#DATE} = 1, etc.
 * This is important as there are variations in the Gregorian Calendar,
 * e.g. leap years have different days in the month = {@link java.util.Calendar#FEBRUARY}
 * so the result of {@link javax.xml.datatype.Duration#getDays() Duration#getDays()} can be influenced.</p>
 *
 * <p>Any remaining milliseconds after determining the day, hour, minute and second are discarded.</p>
 *
 * @param durationInMilliseconds Milliseconds of <code>Duration</code> to create.
 *
 * @return New <code>Duration</code> created with the specified <code>durationInMilliseconds</code>.
 *
 * @see <a href="http://www.w3.org/TR/xpath-datamodel#dt-dayTimeDuration">
 *   XQuery 1.0 and XPath 2.0 Data Model, xdt:dayTimeDuration</a>
 * @apiSince 8
 */

public javax.xml.datatype.Duration newDurationDayTime(long durationInMilliseconds) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a <code>Duration</code> of type <code>xdt:dayTimeDuration</code> using the specified
 * <code>day</code>, <code>hour</code>, <code>minute</code> and <code>second</code> as defined in
 * <a href="http://www.w3.org/TR/xpath-datamodel#dt-dayTimeDuration">
 *   XQuery 1.0 and XPath 2.0 Data Model, xdt:dayTimeDuration</a>.</p>
 *
 * <p>The datatype <code>xdt:dayTimeDuration</code> is a subtype of <code>xs:duration</code>
 * whose lexical representation contains only day, hour, minute, and second components.
 * This datatype resides in the namespace <code>http://www.w3.org/2003/11/xpath-datatypes</code>.</p>
 *
 * <p>The XML Schema specification states that values can be of an arbitrary size.
 * Implementations may chose not to or be incapable of supporting arbitrarily large and/or small values.
 * An {@link java.lang.UnsupportedOperationException UnsupportedOperationException} will be thrown with a message indicating implementation limits
 * if implementation capacities are exceeded.</p>
 *
 * <p>A <code>null</code> value indicates that field is not set.</p>
 *
 * @param isPositive Set to <code>false</code> to create a negative duration. When the length
 *   of the duration is zero, this parameter will be ignored.
 * @param day Day of <code>Duration</code>.
 * @param hour Hour of <code>Duration</code>.
 * @param minute Minute of <code>Duration</code>.
 * @param second Second of <code>Duration</code>.
 *
 * @return New <code>Duration</code> created with the specified <code>day</code>, <code>hour</code>, <code>minute</code>
 * and <code>second</code>.
 *
 * @throws java.lang.IllegalArgumentException If any values would create an invalid <code>Duration</code>.
 * @throws java.lang.UnsupportedOperationException If implementation cannot support requested values.
 * @apiSince 8
 */

public javax.xml.datatype.Duration newDurationDayTime(boolean isPositive, java.math.BigInteger day, java.math.BigInteger hour, java.math.BigInteger minute, java.math.BigInteger second) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a <code>Duration</code> of type <code>xdt:dayTimeDuration</code> using the specified
 * <code>day</code>, <code>hour</code>, <code>minute</code> and <code>second</code> as defined in
 * <a href="http://www.w3.org/TR/xpath-datamodel#dt-dayTimeDuration">
 *   XQuery 1.0 and XPath 2.0 Data Model, xdt:dayTimeDuration</a>.</p>
 *
 * <p>The datatype <code>xdt:dayTimeDuration</code> is a subtype of <code>xs:duration</code>
 * whose lexical representation contains only day, hour, minute, and second components.
 * This datatype resides in the namespace <code>http://www.w3.org/2003/11/xpath-datatypes</code>.</p>
 *
 * <p>A {@link javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED DatatypeConstants#FIELD_UNDEFINED} value indicates that field is not set.</p>
 *
 * @param isPositive Set to <code>false</code> to create a negative duration. When the length
 *   of the duration is zero, this parameter will be ignored.
 * @param day Day of <code>Duration</code>.
 * @param hour Hour of <code>Duration</code>.
 * @param minute Minute of <code>Duration</code>.
 * @param second Second of <code>Duration</code>.
 *
 * @return New <code>Duration</code> created with the specified <code>day</code>, <code>hour</code>, <code>minute</code>
 * and <code>second</code>.
 *
 * @throws java.lang.IllegalArgumentException If any values would create an invalid <code>Duration</code>.
 * @apiSince 8
 */

public javax.xml.datatype.Duration newDurationDayTime(boolean isPositive, int day, int hour, int minute, int second) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a <code>Duration</code> of type <code>xdt:yearMonthDuration</code> by parsing its <code>String</code> representation,
 * "<em>PnYnM</em>", <a href="http://www.w3.org/TR/xpath-datamodel#dt-yearMonthDuration">
 *   XQuery 1.0 and XPath 2.0 Data Model, xdt:yearMonthDuration</a>.</p>
 *
 * <p>The datatype <code>xdt:yearMonthDuration</code> is a subtype of <code>xs:duration</code>
 * whose lexical representation contains only year and month components.
 * This datatype resides in the namespace {@link javax.xml.XMLConstants#W3C_XPATH_DATATYPE_NS_URI}.</p>
 *
 * <p>Both values are set and available from the created {@link javax.xml.datatype.Duration Duration}</p>
 *
 * <p>The XML Schema specification states that values can be of an arbitrary size.
 * Implementations may chose not to or be incapable of supporting arbitrarily large and/or small values.
 * An {@link java.lang.UnsupportedOperationException UnsupportedOperationException} will be thrown with a message indicating implementation limits
 * if implementation capacities are exceeded.</p>
 *
 * @param lexicalRepresentation Lexical representation of a duration.
 *
 * @return New <code>Duration</code> created using the specified <code>lexicalRepresentation</code>.
 *
 * @throws java.lang.IllegalArgumentException If the <code>lexicalRepresentation</code> does not conform to the specification.
 * @throws java.lang.UnsupportedOperationException If implementation cannot support requested values.
 * @throws java.lang.NullPointerException If <code>lexicalRepresentation</code> is <code>null</code>.
 * @apiSince 8
 */

public javax.xml.datatype.Duration newDurationYearMonth(java.lang.String lexicalRepresentation) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a <code>Duration</code> of type <code>xdt:yearMonthDuration</code> using the specified milliseconds as defined in
 * <a href="http://www.w3.org/TR/xpath-datamodel#dt-yearMonthDuration">
 *   XQuery 1.0 and XPath 2.0 Data Model, xdt:yearMonthDuration</a>.</p>
 *
 * <p>The datatype <code>xdt:yearMonthDuration</code> is a subtype of <code>xs:duration</code>
 * whose lexical representation contains only year and month components.
 * This datatype resides in the namespace {@link javax.xml.XMLConstants#W3C_XPATH_DATATYPE_NS_URI}.</p>
 *
 * <p>Both values are set by computing their values from the specified milliseconds
 * and are available using the <code>get</code> methods of  the created {@link javax.xml.datatype.Duration Duration}.
 * The values conform to and are defined by:</p>
 * <ul>
 *   <li>ISO 8601:2000(E) Section 5.5.3.2 Alternative format</li>
 *   <li><a href="http://www.w3.org/TR/xmlschema-2/#isoformats">
 *     W3C XML Schema 1.0 Part 2, Appendix D, ISO 8601 Date and Time Formats</a>
 *   </li>
 *   <li>{@link javax.xml.datatype.XMLGregorianCalendar XMLGregorianCalendar}  Date/Time Datatype Field Mapping Between XML Schema 1.0 and Java Representation</li>
 * </ul>
 *
 * <p>The default start instance is defined by {@link java.util.GregorianCalendar GregorianCalendar}'s use of the start of the epoch: i.e.,
 * {@link java.util.Calendar#YEAR} = 1970,
 * {@link java.util.Calendar#MONTH} = {@link java.util.Calendar#JANUARY},
 * {@link java.util.Calendar#DATE} = 1, etc.
 * This is important as there are variations in the Gregorian Calendar,
 * e.g. leap years have different days in the month = {@link java.util.Calendar#FEBRUARY}
 * so the result of {@link javax.xml.datatype.Duration#getMonths() Duration#getMonths()} can be influenced.</p>
 *
 * <p>Any remaining milliseconds after determining the year and month are discarded.</p>
 *
 * @param durationInMilliseconds Milliseconds of <code>Duration</code> to create.
 *
 * @return New <code>Duration</code> created using the specified <code>durationInMilliseconds</code>.
 * @apiSince 8
 */

public javax.xml.datatype.Duration newDurationYearMonth(long durationInMilliseconds) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a <code>Duration</code> of type <code>xdt:yearMonthDuration</code> using the specified
 * <code>year</code> and <code>month</code> as defined in
 * <a href="http://www.w3.org/TR/xpath-datamodel#dt-yearMonthyDuration">
 *   XQuery 1.0 and XPath 2.0 Data Model, xdt:yearMonthDuration</a>.</p>
 *
 * <p>The XML Schema specification states that values can be of an arbitrary size.
 * Implementations may chose not to or be incapable of supporting arbitrarily large and/or small values.
 * An {@link java.lang.UnsupportedOperationException UnsupportedOperationException} will be thrown with a message indicating implementation limits
 * if implementation capacities are exceeded.</p>
 *
 * <p>A <code>null</code> value indicates that field is not set.</p>
 *
 * @param isPositive Set to <code>false</code> to create a negative duration. When the length
 *   of the duration is zero, this parameter will be ignored.
 * @param year Year of <code>Duration</code>.
 * @param month Month of <code>Duration</code>.
 *
 * @return New <code>Duration</code> created using the specified <code>year</code> and <code>month</code>.
 *
 * @throws java.lang.IllegalArgumentException If any values would create an invalid <code>Duration</code>.
 * @throws java.lang.UnsupportedOperationException If implementation cannot support requested values.
 * @apiSince 8
 */

public javax.xml.datatype.Duration newDurationYearMonth(boolean isPositive, java.math.BigInteger year, java.math.BigInteger month) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a <code>Duration</code> of type <code>xdt:yearMonthDuration</code> using the specified
 * <code>year</code> and <code>month</code> as defined in
 * <a href="http://www.w3.org/TR/xpath-datamodel#dt-yearMonthyDuration">
 *   XQuery 1.0 and XPath 2.0 Data Model, xdt:yearMonthDuration</a>.</p>
 *
 * <p>A {@link javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED DatatypeConstants#FIELD_UNDEFINED} value indicates that field is not set.</p>
 *
 * @param isPositive Set to <code>false</code> to create a negative duration. When the length
 *   of the duration is zero, this parameter will be ignored.
 * @param year Year of <code>Duration</code>.
 * @param month Month of <code>Duration</code>.
 *
 * @return New <code>Duration</code> created using the specified <code>year</code> and <code>month</code>.
 *
 * @throws java.lang.IllegalArgumentException If any values would create an invalid <code>Duration</code>.
 * @apiSince 8
 */

public javax.xml.datatype.Duration newDurationYearMonth(boolean isPositive, int year, int month) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a new instance of an <code>XMLGregorianCalendar</code>.</p>
 *
 * <p>All date/time datatype fields set to {@link javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED DatatypeConstants#FIELD_UNDEFINED} or null.</p>
 *
 * @return New <code>XMLGregorianCalendar</code> with all date/time datatype fields set to
 *   {@link javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED DatatypeConstants#FIELD_UNDEFINED} or null.
 * @apiSince 8
 */

public abstract javax.xml.datatype.XMLGregorianCalendar newXMLGregorianCalendar();

/**
 * <p>Create a new XMLGregorianCalendar by parsing the String as a lexical representation.</p>
 *
 * <p>Parsing the lexical string representation is defined in
 * <a href="http://www.w3.org/TR/xmlschema-2/#dateTime-order">XML Schema 1.0 Part 2, Section 3.2.[7-14].1,
 * <em>Lexical Representation</em>.</a></p>
 *
 * <p>The string representation may not have any leading and trailing whitespaces.</p>
 *
 * <p>The parsing is done field by field so that
 * the following holds for any lexically correct String x:</p>
 * <pre>
 * newXMLGregorianCalendar(x).toXMLFormat().equals(x)
 * </pre>
 * <p>Except for the noted lexical/canonical representation mismatches
 * listed in <a href="http://www.w3.org/2001/05/xmlschema-errata#e2-45">
 * XML Schema 1.0 errata, Section 3.2.7.2</a>.</p>
 *
 * @param lexicalRepresentation Lexical representation of one the eight XML Schema date/time datatypes.
 *
 * @return <code>XMLGregorianCalendar</code> created from the <code>lexicalRepresentation</code>.
 *
 * @throws java.lang.IllegalArgumentException If the <code>lexicalRepresentation</code> is not a valid <code>XMLGregorianCalendar</code>.
 * @throws java.lang.NullPointerException If <code>lexicalRepresentation</code> is <code>null</code>.
 * @apiSince 8
 */

public abstract javax.xml.datatype.XMLGregorianCalendar newXMLGregorianCalendar(java.lang.String lexicalRepresentation);

/**
 * <p>Create an <code>XMLGregorianCalendar</code> from a {@link java.util.GregorianCalendar GregorianCalendar}.</p>
 *
 * <table border="2" rules="all" cellpadding="2">
 *   <thead>
 *     <tr>
 *       <th align="center" colspan="2">
 *          Field by Field Conversion from
 *          {@link java.util.GregorianCalendar GregorianCalendar} to an {@link javax.xml.datatype.XMLGregorianCalendar XMLGregorianCalendar}
 *       </th>
 *     </tr>
 *     <tr>
 *        <th><code>java.util.GregorianCalendar</code> field</th>
 *        <th><code>javax.xml.datatype.XMLGregorianCalendar</code> field</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td><code>ERA == GregorianCalendar.BC ? -YEAR : YEAR</code></td>
 *       <td>{@link javax.xml.datatype.XMLGregorianCalendar#setYear(int year) XMLGregorianCalendar#setYear(int year)}</td>
 *     </tr>
 *     <tr>
 *       <td><code>MONTH + 1</code></td>
 *       <td>{@link javax.xml.datatype.XMLGregorianCalendar#setMonth(int month) XMLGregorianCalendar#setMonth(int month)}</td>
 *     </tr>
 *     <tr>
 *       <td><code>DAY_OF_MONTH</code></td>
 *       <td>{@link javax.xml.datatype.XMLGregorianCalendar#setDay(int day) XMLGregorianCalendar#setDay(int day)}</td>
 *     </tr>
 *     <tr>
 *       <td><code>HOUR_OF_DAY, MINUTE, SECOND, MILLISECOND</code></td>
 *       <td>{@link javax.xml.datatype.XMLGregorianCalendar#setTime(int hour,int minute,int second,java.math.BigDecimal) XMLGregorianCalendar#setTime(int hour, int minute, int second, BigDecimal fractional)}</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <code>(ZONE_OFFSET + DST_OFFSET) / (60*1000)</code><br/>
 *         <em>(in minutes)</em>
 *       </td>
 *       <td>{@link javax.xml.datatype.XMLGregorianCalendar#setTimezone(int offset) XMLGregorianCalendar#setTimezone(int offset)}<sup><em>*</em></sup>
 *       </td>
 *     </tr>
 *   </tbody>
 * </table>
 * <p><em>*</em>conversion loss of information. It is not possible to represent
 * a <code>java.util.GregorianCalendar</code> daylight savings timezone id in the
 * XML Schema 1.0 date/time datatype representation.</p>
 *
 * <p>To compute the return value's <code>TimeZone</code> field,
 * <ul>
 * <li>when <code>this.getTimezone() != FIELD_UNDEFINED</code>,
 * create a <code>java.util.TimeZone</code> with a custom timezone id
 * using the <code>this.getTimezone()</code>.</li>
 * <li>else use the <code>GregorianCalendar</code> default timezone value
 * for the host is defined as specified by
 * <code>java.util.TimeZone.getDefault()</code>.</li></p>
 *
 * @param cal <code>java.util.GregorianCalendar</code> used to create <code>XMLGregorianCalendar</code>
 *
 * @return <code>XMLGregorianCalendar</code> created from <code>java.util.GregorianCalendar</code>
 *
 * @throws java.lang.NullPointerException If <code>cal</code> is <code>null</code>.
 * @apiSince 8
 */

public abstract javax.xml.datatype.XMLGregorianCalendar newXMLGregorianCalendar(java.util.GregorianCalendar cal);

/**
 * <p>Constructor allowing for complete value spaces allowed by
 * W3C XML Schema 1.0 recommendation for xsd:dateTime and related
 * builtin datatypes. Note that <code>year</code> parameter supports
 * arbitrarily large numbers and fractionalSecond has infinite
 * precision.</p>
 *
 * <p>A <code>null</code> value indicates that field is not set.</p>
 *
 * @param year of <code>XMLGregorianCalendar</code> to be created.
 * @param month of <code>XMLGregorianCalendar</code> to be created.
 * @param day of <code>XMLGregorianCalendar</code> to be created.
 * @param hour of <code>XMLGregorianCalendar</code> to be created.
 * @param minute of <code>XMLGregorianCalendar</code> to be created.
 * @param second of <code>XMLGregorianCalendar</code> to be created.
 * @param fractionalSecond of <code>XMLGregorianCalendar</code> to be created.
 * @param timezone of <code>XMLGregorianCalendar</code> to be created.
 *
 * @return <code>XMLGregorianCalendar</code> created from specified values.
 *
 * @throws java.lang.IllegalArgumentException If any individual parameter's value is outside the maximum value constraint for the field
 *   as determined by the Date/Time Data Mapping table in {@link javax.xml.datatype.XMLGregorianCalendar XMLGregorianCalendar}
 *   or if the composite values constitute an invalid <code>XMLGregorianCalendar</code> instance
 *   as determined by {@link javax.xml.datatype.XMLGregorianCalendar#isValid() XMLGregorianCalendar#isValid()}.
 * @apiSince 8
 */

public abstract javax.xml.datatype.XMLGregorianCalendar newXMLGregorianCalendar(java.math.BigInteger year, int month, int day, int hour, int minute, int second, java.math.BigDecimal fractionalSecond, int timezone);

/**
 * <p>Constructor of value spaces that a
 * <code>java.util.GregorianCalendar</code> instance would need to convert to an
 * <code>XMLGregorianCalendar</code> instance.</p>
 *
 * <p><code>XMLGregorianCalendar eon</code> and
 * <code>fractionalSecond</code> are set to <code>null</code></p>
 *
 * <p>A {@link javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED DatatypeConstants#FIELD_UNDEFINED} value indicates that field is not set.</p>
 *
 * @param year of <code>XMLGregorianCalendar</code> to be created.
 * @param month of <code>XMLGregorianCalendar</code> to be created.
 * @param day of <code>XMLGregorianCalendar</code> to be created.
 * @param hour of <code>XMLGregorianCalendar</code> to be created.
 * @param minute of <code>XMLGregorianCalendar</code> to be created.
 * @param second of <code>XMLGregorianCalendar</code> to be created.
 * @param millisecond of <code>XMLGregorianCalendar</code> to be created.
 * @param timezone of <code>XMLGregorianCalendar</code> to be created.
 *
 * @return <code>XMLGregorianCalendar</code> created from specified values.
 *
 * @throws java.lang.IllegalArgumentException If any individual parameter's value is outside the maximum value constraint for the field
 *   as determined by the Date/Time Data Mapping table in {@link javax.xml.datatype.XMLGregorianCalendar XMLGregorianCalendar}
 *   or if the composite values constitute an invalid <code>XMLGregorianCalendar</code> instance
 *   as determined by {@link javax.xml.datatype.XMLGregorianCalendar#isValid() XMLGregorianCalendar#isValid()}.
 * @apiSince 8
 */

public javax.xml.datatype.XMLGregorianCalendar newXMLGregorianCalendar(int year, int month, int day, int hour, int minute, int second, int millisecond, int timezone) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a Java representation of XML Schema builtin datatype <code>date</code> or <code>g*</code>.</p>
 *
 * <p>For example, an instance of <code>gYear</code> can be created invoking this factory
 * with <code>month</code> and <code>day</code> parameters set to
 * {@link javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED DatatypeConstants#FIELD_UNDEFINED}.</p>
 *
 * <p>A {@link javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED DatatypeConstants#FIELD_UNDEFINED} value indicates that field is not set.</p>
 *
 * @param year of <code>XMLGregorianCalendar</code> to be created.
 * @param month of <code>XMLGregorianCalendar</code> to be created.
 * @param day of <code>XMLGregorianCalendar</code> to be created.
 * @param timezone offset in minutes. {@link javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED DatatypeConstants#FIELD_UNDEFINED} indicates optional field is not set.
 *
 * @return <code>XMLGregorianCalendar</code> created from parameter values.
 *
 * @see javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED
 *
 * @throws java.lang.IllegalArgumentException If any individual parameter's value is outside the maximum value constraint for the field
 *   as determined by the Date/Time Data Mapping table in {@link javax.xml.datatype.XMLGregorianCalendar XMLGregorianCalendar}
 *   or if the composite values constitute an invalid <code>XMLGregorianCalendar</code> instance
 *   as determined by {@link javax.xml.datatype.XMLGregorianCalendar#isValid() XMLGregorianCalendar#isValid()}.
 * @apiSince 8
 */

public javax.xml.datatype.XMLGregorianCalendar newXMLGregorianCalendarDate(int year, int month, int day, int timezone) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a Java instance of XML Schema builtin datatype <code>time</code>.</p>
 *
 * <p>A {@link javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED DatatypeConstants#FIELD_UNDEFINED} value indicates that field is not set.</p>
 *
 * @param hours number of hours
 * @param minutes number of minutes
 * @param seconds number of seconds
 * @param timezone offset in minutes. {@link javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED DatatypeConstants#FIELD_UNDEFINED} indicates optional field is not set.
 *
 * @return <code>XMLGregorianCalendar</code> created from parameter values.
 *
 * @throws java.lang.IllegalArgumentException If any individual parameter's value is outside the maximum value constraint for the field
 *   as determined by the Date/Time Data Mapping table in {@link javax.xml.datatype.XMLGregorianCalendar XMLGregorianCalendar}
 *   or if the composite values constitute an invalid <code>XMLGregorianCalendar</code> instance
 *   as determined by {@link javax.xml.datatype.XMLGregorianCalendar#isValid() XMLGregorianCalendar#isValid()}.
 *
 * @see javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED
 * @apiSince 8
 */

public javax.xml.datatype.XMLGregorianCalendar newXMLGregorianCalendarTime(int hours, int minutes, int seconds, int timezone) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a Java instance of XML Schema builtin datatype time.</p>
 *
 * <p>A <code>null</code> value indicates that field is not set.</p>
 * <p>A {@link javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED DatatypeConstants#FIELD_UNDEFINED} value indicates that field is not set.</p>
 *
 * @param hours number of hours
 * @param minutes number of minutes
 * @param seconds number of seconds
 * @param fractionalSecond value of <code>null</code> indicates that this optional field is not set.
 * @param timezone offset in minutes. {@link javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED DatatypeConstants#FIELD_UNDEFINED} indicates optional field is not set.
 *
 * @return <code>XMLGregorianCalendar</code> created from parameter values.
 *
 * @see javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED
 *
 * @throws java.lang.IllegalArgumentException If any individual parameter's value is outside the maximum value constraint for the field
 *   as determined by the Date/Time Data Mapping table in {@link javax.xml.datatype.XMLGregorianCalendar XMLGregorianCalendar}
 *   or if the composite values constitute an invalid <code>XMLGregorianCalendar</code> instance
 *   as determined by {@link javax.xml.datatype.XMLGregorianCalendar#isValid() XMLGregorianCalendar#isValid()}.
 * @apiSince 8
 */

public javax.xml.datatype.XMLGregorianCalendar newXMLGregorianCalendarTime(int hours, int minutes, int seconds, java.math.BigDecimal fractionalSecond, int timezone) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a Java instance of XML Schema builtin datatype time.</p>
 *
 * <p>A {@link javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED DatatypeConstants#FIELD_UNDEFINED} value indicates that field is not set.</p>
 *
 * @param hours number of hours
 * @param minutes number of minutes
 * @param seconds number of seconds
 * @param milliseconds number of milliseconds
 * @param timezone offset in minutes. {@link javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED DatatypeConstants#FIELD_UNDEFINED} indicates optional field is not set.
 *
 * @return <code>XMLGregorianCalendar</code> created from parameter values.
 *
 * @see javax.xml.datatype.DatatypeConstants#FIELD_UNDEFINED
 *
 * @throws java.lang.IllegalArgumentException If any individual parameter's value is outside the maximum value constraint for the field
 *   as determined by the Date/Time Data Mapping table in {@link javax.xml.datatype.XMLGregorianCalendar XMLGregorianCalendar}
 *   or if the composite values constitute an invalid <code>XMLGregorianCalendar</code> instance
 *   as determined by {@link javax.xml.datatype.XMLGregorianCalendar#isValid() XMLGregorianCalendar#isValid()}.
 * @apiSince 8
 */

public javax.xml.datatype.XMLGregorianCalendar newXMLGregorianCalendarTime(int hours, int minutes, int seconds, int milliseconds, int timezone) { throw new RuntimeException("Stub!"); }

/**
 * <p>Default implementation class name as defined in JSR 206: Java(TM) API for XML Processing (JAXP) 1.3.</p>
 *
 * <p>Default value is <code>org.apache.xerces.jaxp.datatype.DatatypeFactoryImpl</code>.</p>
 * @apiSince 8
 */

public static final java.lang.String DATATYPEFACTORY_IMPLEMENTATION_CLASS;
static { DATATYPEFACTORY_IMPLEMENTATION_CLASS = null; }

/**
 * <p>Default property name as defined in JSR 206: Java(TM) API for XML Processing (JAXP) 1.3.</p>
 *
 * <p>Default value is <code>javax.xml.datatype.DatatypeFactory</code>.</p>
 * @apiSince 8
 */

public static final java.lang.String DATATYPEFACTORY_PROPERTY = "javax.xml.datatype.DatatypeFactory";
}

