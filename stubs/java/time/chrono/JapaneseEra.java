/*
 * Copyright (c) 2012, 2019, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * This file is available under and governed by the GNU General Public
 * License version 2 only, as published by the Free Software Foundation.
 * However, the following notice accompanied the original version of this
 * file:
 *
 * Copyright (c) 2012, Stephen Colebourne & Michael Nascimento Santos
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  * Neither the name of JSR-310 nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


package java.time.chrono;

import java.time.DateTimeException;
import java.time.temporal.TemporalField;
import java.time.temporal.ChronoField;
import java.time.temporal.UnsupportedTemporalTypeException;

/**
 * An era in the Japanese Imperial calendar system.
 * <p>
 * The Japanese government defines the official name and start date of
 * each era. Eras are consecutive and their date ranges do not overlap,
 * so the end date of one era is always the day before the start date
 * of the next era.
 * <p>
 * The Java SE Platform supports all eras defined by the Japanese government,
 * beginning with the Meiji era. Each era is identified in the Platform by an
 * integer value and a name. The {@link #of(int)} and {@link #valueOf(java.lang.String)}
 * methods may be used to obtain a singleton instance of JapaneseEra for each
 * era. The {@link #values()} method returns the singleton instances of all
 * supported eras.
 * <p>
 * For convenience, this class declares a number of public static final fields
 * that refer to singleton instances returned by the values() method.
 *
 * @apiNote
 * The fields declared in this class may evolve over time, in line with the
 * results of the {@link #values()} method. However, there is not necessarily
 * a 1:1 correspondence between the fields and the singleton instances.
 *
 * @apiNote
 * The Japanese government may announce a new era and define its start
 * date but not its official name. In this scenario, the singleton instance
 * that represents the new era may return a name that is not stable until
 * the official name is defined. Developers should exercise caution when
 * relying on the name returned by any singleton instance that does not
 * correspond to a public static final field.
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class JapaneseEra implements java.time.chrono.Era, java.io.Serializable {

private JapaneseEra() { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code JapaneseEra} from an {@code int} value.
 * <ul>
 * <li>The value {@code 1} is associated with the 'Showa' era, because
 * it contains 1970-01-01 (ISO calendar system).</li>
 * <li>The values {@code -1} and {@code 0} are associated with two earlier
 * eras, Meiji and Taisho, respectively.</li>
 * <li>A value greater than {@code 1} is associated with a later era,
 * beginning with Heisei ({@code 2}).</li>
 * </ul>
 * <p>
 * Every instance of {@code JapaneseEra} that is returned from the {@link #values()}
 * method has an int value (available via {@link java.time.chrono.Era#getValue() Era#getValue()} which is
 * accepted by this method.
 *
 * @param japaneseEra  the era to represent
 * @return the {@code JapaneseEra} singleton, not null
 * @throws java.time.DateTimeException if the value is invalid
 * @apiSince 26
 */

public static java.time.chrono.JapaneseEra of(int japaneseEra) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@code JapaneseEra} with the name.
 * <p>
 * The string must match exactly the name of the era.
 * (Extraneous whitespace characters are not permitted.)
 *
 * @param japaneseEra  the japaneseEra name; non-null
 * @return the {@code JapaneseEra} singleton, never null
 * @throws java.lang.IllegalArgumentException if there is not JapaneseEra with the specified name
 * @apiSince 26
 */

public static java.time.chrono.JapaneseEra valueOf(java.lang.String japaneseEra) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of JapaneseEras.
 * <p>
 * This method may be used to iterate over the JapaneseEras as follows:
 * <pre>
 * for (JapaneseEra c : JapaneseEra.values())
 *     System.out.println(c);
 * </pre>
 *
 * @return an array of JapaneseEras
 * @apiSince 26
 */

public static java.time.chrono.JapaneseEra[] values() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @param style {@inheritDoc}
 * @param locale {@inheritDoc}
 * @apiSince 26
 */

public java.lang.String getDisplayName(java.time.format.TextStyle style, java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Gets the numeric era {@code int} value.
 * <p>
 * The {@link #SHOWA} era that contains 1970-01-01 (ISO calendar system) has the value 1.
 * Later eras are numbered from 2 ({@link #HEISEI}).
 * Earlier eras are numbered 0 ({@link #TAISHO}), -1 ({@link #MEIJI})).
 *
 * @return the era value
 * @apiSince 26
 */

public int getValue() { throw new RuntimeException("Stub!"); }

/**
 * Gets the range of valid values for the specified field.
 * <p>
 * The range object expresses the minimum and maximum valid values for a field.
 * This era is used to enhance the accuracy of the returned range.
 * If it is not possible to return the range, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link java.time.temporal.ChronoField ChronoField} then the query is implemented here.
 * The {@code ERA} field returns the range.
 * All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}
 * passing {@code this} as the argument.
 * Whether the range can be obtained is determined by the field.
 * <p>
 * The range of valid Japanese eras can change over time due to the nature
 * of the Japanese calendar system.
 *
 * @param field  the field to query the range for, not null
 * @return the range of valid values for the field, not null
 * @throws java.time.DateTimeException if the range for the field cannot be obtained
 * @throws java.time.temporal.UnsupportedTemporalTypeException if the unit is not supported
 * @apiSince 26
 */

public java.time.temporal.ValueRange range(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The singleton instance for the 'Heisei' era (1989-01-08 - 2019-04-30)
 * which has the value 2.
 * @apiSince 26
 */

public static final java.time.chrono.JapaneseEra HEISEI;
static { HEISEI = null; }

/**
 * The singleton instance for the 'Meiji' era (1868-01-01 - 1912-07-29)
 * which has the value -1.
 * @apiSince 26
 */

public static final java.time.chrono.JapaneseEra MEIJI;
static { MEIJI = null; }

/**
 * The singleton instance for the 'Showa' era (1926-12-25 - 1989-01-07)
 * which has the value 1.
 * @apiSince 26
 */

public static final java.time.chrono.JapaneseEra SHOWA;
static { SHOWA = null; }

/**
 * The singleton instance for the 'Taisho' era (1912-07-30 - 1926-12-24)
 * which has the value 0.
 * @apiSince 26
 */

public static final java.time.chrono.JapaneseEra TAISHO;
static { TAISHO = null; }
}

