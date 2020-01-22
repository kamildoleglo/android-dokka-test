/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.util;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;

/**
 * A container object which may or may not contain a {@code double} value.
 * If a value is present, {@code isPresent()} will return {@code true} and
 * {@code getAsDouble()} will return the value.
 *
 * <p>Additional methods that depend on the presence or absence of a contained
 * value are provided, such as {@link #orElse(double) orElse()}
 * (return a default value if value not present) and
 * {@link #ifPresent(java.util.function.DoubleConsumer) ifPresent()} (execute a block
 * of code if the value is present).
 *
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class OptionalDouble {

private OptionalDouble() { throw new RuntimeException("Stub!"); }

/**
 * Returns an empty {@code OptionalDouble} instance.  No value is present for this
 * OptionalDouble.
 *
 * @apiNote Though it may be tempting to do so, avoid testing if an object
 * is empty by comparing with {@code ==} against instances returned by
 * {@code Option.empty()}. There is no guarantee that it is a singleton.
 * Instead, use {@link #isPresent()}.
 *
 *  @return an empty {@code OptionalDouble}.
 * @apiSince 24
 */

public static java.util.OptionalDouble empty() { throw new RuntimeException("Stub!"); }

/**
 * Return an {@code OptionalDouble} with the specified value present.
 *
 * @param value the value to be present
 * @return an {@code OptionalDouble} with the value present
 * @apiSince 24
 */

public static java.util.OptionalDouble of(double value) { throw new RuntimeException("Stub!"); }

/**
 * If a value is present in this {@code OptionalDouble}, returns the value,
 * otherwise throws {@code NoSuchElementException}.
 *
 * @return the value held by this {@code OptionalDouble}
 * @throws java.util.NoSuchElementException if there is no value present
 *
 * @see java.util.OptionalDouble#isPresent()
 * @apiSince 24
 */

public double getAsDouble() { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if there is a value present, otherwise {@code false}.
 *
 * @return {@code true} if there is a value present, otherwise {@code false}
 * @apiSince 24
 */

public boolean isPresent() { throw new RuntimeException("Stub!"); }

/**
 * Have the specified consumer accept the value if a value is present,
 * otherwise do nothing.
 *
 * @param consumer block to be executed if a value is present
 * @throws java.lang.NullPointerException if value is present and {@code consumer} is
 * null
 * @apiSince 24
 */

public void ifPresent(java.util.function.DoubleConsumer consumer) { throw new RuntimeException("Stub!"); }

/**
 * Return the value if present, otherwise return {@code other}.
 *
 * @param other the value to be returned if there is no value present
 * @return the value, if present, otherwise {@code other}
 * @apiSince 24
 */

public double orElse(double other) { throw new RuntimeException("Stub!"); }

/**
 * Return the value if present, otherwise invoke {@code other} and return
 * the result of that invocation.
 *
 * @param other a {@code DoubleSupplier} whose result is returned if no value
 * is present
 * @return the value if present otherwise the result of {@code other.getAsDouble()}
 * @throws java.lang.NullPointerException if value is not present and {@code other} is
 * null
 * @apiSince 24
 */

public double orElseGet(java.util.function.DoubleSupplier other) { throw new RuntimeException("Stub!"); }

/**
 * Return the contained value, if present, otherwise throw an exception
 * to be created by the provided supplier.
 *
 * @apiNote A method reference to the exception constructor with an empty
 * argument list can be used as the supplier. For example,
 * {@code IllegalStateException::new}
 *
 * @param <X> Type of the exception to be thrown
 * @param exceptionSupplier The supplier which will return the exception to
 * be thrown
 * @return the present value
 * @throws X if there is no value present
 * @throws java.lang.NullPointerException if no value is present and
 * {@code exceptionSupplier} is null
 * @apiSince 24
 */

public <X extends java.lang.Throwable> double orElseThrow(java.util.function.Supplier<X> exceptionSupplier) throws X { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether some other object is "equal to" this OptionalDouble. The
 * other object is considered equal if:
 * <ul>
 * <li>it is also an {@code OptionalDouble} and;
 * <li>both instances have no value present or;
 * <li>the present values are "equal to" each other via {@code Double.compare() == 0}.
 * </ul>
 *
 * @param obj an object to be tested for equality
 * @return {code true} if the other object is "equal to" this object
 * otherwise {@code false}
 * @apiSince 24
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns the hash code value of the present value, if any, or 0 (zero) if
 * no value is present.
 *
 * @return hash code value of the present value or 0 if no value is present
 * @apiSince 24
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * Returns a non-empty string representation of this object suitable for
 * debugging. The exact presentation format is unspecified and may vary
 * between implementations and versions.
 *
 * @implSpec If a value is present the result must include its string
 * representation in the result. Empty and present instances must be
 * unambiguously differentiable.
 *
 * @return the string representation of this instance
 * @apiSince 24
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

