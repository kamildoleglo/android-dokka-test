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


package java.util.stream;

import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.Collection;
import java.util.function.Supplier;
import java.util.Collections;
import java.util.Optional;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.function.ToLongFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

/**
 * Implementations of {@link java.util.stream.Collector Collector} that implement various useful reduction
 * operations, such as accumulating elements into collections, summarizing
 * elements according to various criteria, etc.
 *
 * <p>The following are examples of using the predefined collectors to perform
 * common mutable reduction tasks:
 *
 * <pre>{@code
 *     // Accumulate names into a List
 *     List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());
 *
 *     // Accumulate names into a TreeSet
 *     Set<String> set = people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));
 *
 *     // Convert elements to strings and concatenate them, separated by commas
 *     String joined = things.stream()
 *                           .map(Object::toString)
 *                           .collect(Collectors.joining(", "));
 *
 *     // Compute sum of salaries of employee
 *     int total = employees.stream()
 *                          .collect(Collectors.summingInt(Employee::getSalary)));
 *
 *     // Group employees by department
 *     Map<Department, List<Employee>> byDept
 *         = employees.stream()
 *                    .collect(Collectors.groupingBy(Employee::getDepartment));
 *
 *     // Compute sum of salaries by department
 *     Map<Department, Integer> totalByDept
 *         = employees.stream()
 *                    .collect(Collectors.groupingBy(Employee::getDepartment,
 *                                                   Collectors.summingInt(Employee::getSalary)));
 *
 *     // Partition students into passing and failing
 *     Map<Boolean, List<Student>> passingFailing =
 *         students.stream()
 *                 .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
 *
 * }</pre>
 *
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Collectors {

private Collectors() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that accumulates the input elements into a
 * new {@code Collection}, in encounter order.  The {@code Collection} is
 * created by the provided factory.
 *
 * @param <T> the type of the input elements
 * @param <C> the type of the resulting {@code Collection}
 * @param collectionFactory a {@code Supplier} which returns a new, empty
 * {@code Collection} of the appropriate type
 * @return a {@code Collector} which collects all the input elements into a
 * {@code Collection}, in encounter order
 * @apiSince 24
 */

public static <T, C extends java.util.Collection<T>> java.util.stream.Collector<T,?,C> toCollection(java.util.function.Supplier<C> collectionFactory) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that accumulates the input elements into a
 * new {@code List}. There are no guarantees on the type, mutability,
 * serializability, or thread-safety of the {@code List} returned; if more
 * control over the returned {@code List} is required, use {@link #toCollection(java.util.function.Supplier)}.
 *
 * @param <T> the type of the input elements
 * @return a {@code Collector} which collects all the input elements into a
 * {@code List}, in encounter order
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,java.util.List<T>> toList() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that accumulates the input elements into a
 * new {@code Set}. There are no guarantees on the type, mutability,
 * serializability, or thread-safety of the {@code Set} returned; if more
 * control over the returned {@code Set} is required, use
 * {@link #toCollection(java.util.function.Supplier)}.
 *
 * <p>This is an {@link java.util.stream.Collector.Characteristics#UNORDERED Collector.Characteristics#UNORDERED}
 * Collector.
 *
 * @param <T> the type of the input elements
 * @return a {@code Collector} which collects all the input elements into a
 * {@code Set}
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,java.util.Set<T>> toSet() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that concatenates the input elements into a
 * {@code String}, in encounter order.
 *
 * @return a {@code Collector} that concatenates the input elements into a
 * {@code String}, in encounter order
 * @apiSince 24
 */

public static java.util.stream.Collector<java.lang.CharSequence,?,java.lang.String> joining() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that concatenates the input elements,
 * separated by the specified delimiter, in encounter order.
 *
 * @param delimiter the delimiter to be used between each element
 * @return A {@code Collector} which concatenates CharSequence elements,
 * separated by the specified delimiter, in encounter order
 * @apiSince 24
 */

public static java.util.stream.Collector<java.lang.CharSequence,?,java.lang.String> joining(java.lang.CharSequence delimiter) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that concatenates the input elements,
 * separated by the specified delimiter, with the specified prefix and
 * suffix, in encounter order.
 *
 * @param delimiter the delimiter to be used between each element
 * @param  prefix the sequence of characters to be used at the beginning
 *                of the joined result
 * @param  suffix the sequence of characters to be used at the end
 *                of the joined result
 * @return A {@code Collector} which concatenates CharSequence elements,
 * separated by the specified delimiter, in encounter order
 * @apiSince 24
 */

public static java.util.stream.Collector<java.lang.CharSequence,?,java.lang.String> joining(java.lang.CharSequence delimiter, java.lang.CharSequence prefix, java.lang.CharSequence suffix) { throw new RuntimeException("Stub!"); }

/**
 * Adapts a {@code Collector} accepting elements of type {@code U} to one
 * accepting elements of type {@code T} by applying a mapping function to
 * each input element before accumulation.
 *
 * @apiNote
 * The {@code mapping()} collectors are most useful when used in a
 * multi-level reduction, such as downstream of a {@code groupingBy} or
 * {@code partitioningBy}.  For example, given a stream of
 * {@code Person}, to accumulate the set of last names in each city:
 * <pre>{@code
 *     Map<City, Set<String>> lastNamesByCity
 *         = people.stream().collect(groupingBy(Person::getCity,
 *                                              mapping(Person::getLastName, toSet())));
 * }</pre>
 *
 * @param <T> the type of the input elements
 * @param <U> type of elements accepted by downstream collector
 * @param <A> intermediate accumulation type of the downstream collector
 * @param <R> result type of collector
 * @param mapper a function to be applied to the input elements
 * @param downstream a collector which will accept mapped values
 * @return a collector which applies the mapping function to the input
 * elements and provides the mapped results to the downstream collector
 * @apiSince 24
 */

public static <T, U, A, R> java.util.stream.Collector<T,?,R> mapping(java.util.function.Function<? super T,? extends U> mapper, java.util.stream.Collector<? super U,A,R> downstream) { throw new RuntimeException("Stub!"); }

/**
 * Adapts a {@code Collector} to perform an additional finishing
 * transformation.  For example, one could adapt the {@link #toList()}
 * collector to always produce an immutable list with:
 * <pre>{@code
 *     List<String> people
 *         = people.stream().collect(collectingAndThen(toList(), Collections::unmodifiableList));
 * }</pre>
 *
 * @param <T> the type of the input elements
 * @param <A> intermediate accumulation type of the downstream collector
 * @param <R> result type of the downstream collector
 * @param <RR> result type of the resulting collector
 * @param downstream a collector
 * @param finisher a function to be applied to the final result of the downstream collector
 * @return a collector which performs the action of the downstream collector,
 * followed by an additional finishing step
 * @apiSince 24
 */

public static <T, A, R, RR> java.util.stream.Collector<T,A,RR> collectingAndThen(java.util.stream.Collector<T,A,R> downstream, java.util.function.Function<R,RR> finisher) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} accepting elements of type {@code T} that
 * counts the number of input elements.  If no elements are present, the
 * result is 0.
 *
 * @implSpec
 * This produces a result equivalent to:
 * <pre>{@code
 *     reducing(0L, e -> 1L, Long::sum)
 * }</pre>
 *
 * @param <T> the type of the input elements
 * @return a {@code Collector} that counts the input elements
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,java.lang.Long> counting() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that produces the minimal element according
 * to a given {@code Comparator}, described as an {@code Optional<T>}.
 *
 * @implSpec
 * This produces a result equivalent to:
 * <pre>{@code
 *     reducing(BinaryOperator.minBy(comparator))
 * }</pre>
 *
 * @param <T> the type of the input elements
 * @param comparator a {@code Comparator} for comparing elements
 * @return a {@code Collector} that produces the minimal value
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,java.util.Optional<T>> minBy(java.util.Comparator<? super T> comparator) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that produces the maximal element according
 * to a given {@code Comparator}, described as an {@code Optional<T>}.
 *
 * @implSpec
 * This produces a result equivalent to:
 * <pre>{@code
 *     reducing(BinaryOperator.maxBy(comparator))
 * }</pre>
 *
 * @param <T> the type of the input elements
 * @param comparator a {@code Comparator} for comparing elements
 * @return a {@code Collector} that produces the maximal value
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,java.util.Optional<T>> maxBy(java.util.Comparator<? super T> comparator) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that produces the sum of a integer-valued
 * function applied to the input elements.  If no elements are present,
 * the result is 0.
 *
 * @param <T> the type of the input elements
 * @param mapper a function extracting the property to be summed
 * @return a {@code Collector} that produces the sum of a derived property
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,java.lang.Integer> summingInt(java.util.function.ToIntFunction<? super T> mapper) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that produces the sum of a long-valued
 * function applied to the input elements.  If no elements are present,
 * the result is 0.
 *
 * @param <T> the type of the input elements
 * @param mapper a function extracting the property to be summed
 * @return a {@code Collector} that produces the sum of a derived property
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,java.lang.Long> summingLong(java.util.function.ToLongFunction<? super T> mapper) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that produces the sum of a double-valued
 * function applied to the input elements.  If no elements are present,
 * the result is 0.
 *
 * <p>The sum returned can vary depending upon the order in which
 * values are recorded, due to accumulated rounding error in
 * addition of values of differing magnitudes. Values sorted by increasing
 * absolute magnitude tend to yield more accurate results.  If any recorded
 * value is a {@code NaN} or the sum is at any point a {@code NaN} then the
 * sum will be {@code NaN}.
 *
 * @param <T> the type of the input elements
 * @param mapper a function extracting the property to be summed
 * @return a {@code Collector} that produces the sum of a derived property
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,java.lang.Double> summingDouble(java.util.function.ToDoubleFunction<? super T> mapper) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that produces the arithmetic mean of an integer-valued
 * function applied to the input elements.  If no elements are present,
 * the result is 0.
 *
 * @param <T> the type of the input elements
 * @param mapper a function extracting the property to be summed
 * @return a {@code Collector} that produces the sum of a derived property
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,java.lang.Double> averagingInt(java.util.function.ToIntFunction<? super T> mapper) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that produces the arithmetic mean of a long-valued
 * function applied to the input elements.  If no elements are present,
 * the result is 0.
 *
 * @param <T> the type of the input elements
 * @param mapper a function extracting the property to be summed
 * @return a {@code Collector} that produces the sum of a derived property
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,java.lang.Double> averagingLong(java.util.function.ToLongFunction<? super T> mapper) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that produces the arithmetic mean of a double-valued
 * function applied to the input elements.  If no elements are present,
 * the result is 0.
 *
 * <p>The average returned can vary depending upon the order in which
 * values are recorded, due to accumulated rounding error in
 * addition of values of differing magnitudes. Values sorted by increasing
 * absolute magnitude tend to yield more accurate results.  If any recorded
 * value is a {@code NaN} or the sum is at any point a {@code NaN} then the
 * average will be {@code NaN}.
 *
 * @implNote The {@code double} format can represent all
 * consecutive integers in the range -2<sup>53</sup> to
 * 2<sup>53</sup>. If the pipeline has more than 2<sup>53</sup>
 * values, the divisor in the average computation will saturate at
 * 2<sup>53</sup>, leading to additional numerical errors.
 *
 * @param <T> the type of the input elements
 * @param mapper a function extracting the property to be summed
 * @return a {@code Collector} that produces the sum of a derived property
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,java.lang.Double> averagingDouble(java.util.function.ToDoubleFunction<? super T> mapper) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} which performs a reduction of its
 * input elements under a specified {@code BinaryOperator} using the
 * provided identity.
 *
 * @apiNote
 * The {@code reducing()} collectors are most useful when used in a
 * multi-level reduction, downstream of {@code groupingBy} or
 * {@code partitioningBy}.  To perform a simple reduction on a stream,
 * use {@link java.util.stream.Stream#reduce(java.lang.Object,java.util.function.BinaryOperator) Stream#reduce(Object, BinaryOperator)}} instead.
 *
 * @param <T> element type for the input and output of the reduction
 * @param identity the identity value for the reduction (also, the value
 *                 that is returned when there are no input elements)
 * @param op a {@code BinaryOperator<T>} used to reduce the input elements
 * @return a {@code Collector} which implements the reduction operation
 *
 * @see #reducing(BinaryOperator)
 * @see #reducing(Object, Function, BinaryOperator)
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,T> reducing(T identity, java.util.function.BinaryOperator<T> op) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} which performs a reduction of its
 * input elements under a specified {@code BinaryOperator}.  The result
 * is described as an {@code Optional<T>}.
 *
 * @apiNote
 * The {@code reducing()} collectors are most useful when used in a
 * multi-level reduction, downstream of {@code groupingBy} or
 * {@code partitioningBy}.  To perform a simple reduction on a stream,
 * use {@link java.util.stream.Stream#reduce(java.util.function.BinaryOperator) Stream#reduce(BinaryOperator)} instead.
 *
 * <p>For example, given a stream of {@code Person}, to calculate tallest
 * person in each city:
 * <pre>{@code
 *     Comparator<Person> byHeight = Comparator.comparing(Person::getHeight);
 *     Map<City, Person> tallestByCity
 *         = people.stream().collect(groupingBy(Person::getCity, reducing(BinaryOperator.maxBy(byHeight))));
 * }</pre>
 *
 * @param <T> element type for the input and output of the reduction
 * @param op a {@code BinaryOperator<T>} used to reduce the input elements
 * @return a {@code Collector} which implements the reduction operation
 *
 * @see #reducing(Object, BinaryOperator)
 * @see #reducing(Object, Function, BinaryOperator)
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,java.util.Optional<T>> reducing(java.util.function.BinaryOperator<T> op) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} which performs a reduction of its
 * input elements under a specified mapping function and
 * {@code BinaryOperator}. This is a generalization of
 * {@link #reducing(java.lang.Object,java.util.function.BinaryOperator)} which allows a transformation
 * of the elements before reduction.
 *
 * @apiNote
 * The {@code reducing()} collectors are most useful when used in a
 * multi-level reduction, downstream of {@code groupingBy} or
 * {@code partitioningBy}.  To perform a simple map-reduce on a stream,
 * use {@link java.util.stream.Stream#map(java.util.function.Function) Stream#map(Function)} and {@link java.util.stream.Stream#reduce(java.lang.Object,java.util.function.BinaryOperator) Stream#reduce(Object, BinaryOperator)}
 * instead.
 *
 * <p>For example, given a stream of {@code Person}, to calculate the longest
 * last name of residents in each city:
 * <pre>{@code
 *     Comparator<String> byLength = Comparator.comparing(String::length);
 *     Map<City, String> longestLastNameByCity
 *         = people.stream().collect(groupingBy(Person::getCity,
 *                                              reducing(Person::getLastName, BinaryOperator.maxBy(byLength))));
 * }</pre>
 *
 * @param <T> the type of the input elements
 * @param <U> the type of the mapped values
 * @param identity the identity value for the reduction (also, the value
 *                 that is returned when there are no input elements)
 * @param mapper a mapping function to apply to each input value
 * @param op a {@code BinaryOperator<U>} used to reduce the mapped values
 * @return a {@code Collector} implementing the map-reduce operation
 *
 * @see #reducing(Object, BinaryOperator)
 * @see #reducing(BinaryOperator)
 * @apiSince 24
 */

public static <T, U> java.util.stream.Collector<T,?,U> reducing(U identity, java.util.function.Function<? super T,? extends U> mapper, java.util.function.BinaryOperator<U> op) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} implementing a "group by" operation on
 * input elements of type {@code T}, grouping elements according to a
 * classification function, and returning the results in a {@code Map}.
 *
 * <p>The classification function maps elements to some key type {@code K}.
 * The collector produces a {@code Map<K, List<T>>} whose keys are the
 * values resulting from applying the classification function to the input
 * elements, and whose corresponding values are {@code List}s containing the
 * input elements which map to the associated key under the classification
 * function.
 *
 * <p>There are no guarantees on the type, mutability, serializability, or
 * thread-safety of the {@code Map} or {@code List} objects returned.
 * @implSpec
 * This produces a result similar to:
 * <pre>{@code
 *     groupingBy(classifier, toList());
 * }</pre>
 *
 * @implNote
 * The returned {@code Collector} is not concurrent.  For parallel stream
 * pipelines, the {@code combiner} function operates by merging the keys
 * from one map into another, which can be an expensive operation.  If
 * preservation of the order in which elements appear in the resulting {@code Map}
 * collector is not required, using {@link #groupingByConcurrent(java.util.function.Function)}
 * may offer better parallel performance.
 *
 * @param <T> the type of the input elements
 * @param <K> the type of the keys
 * @param classifier the classifier function mapping input elements to keys
 * @return a {@code Collector} implementing the group-by operation
 *
 * @see #groupingBy(Function, Collector)
 * @see #groupingBy(Function, Supplier, Collector)
 * @see #groupingByConcurrent(Function)
 * @apiSince 24
 */

public static <T, K> java.util.stream.Collector<T,?,java.util.Map<K,java.util.List<T>>> groupingBy(java.util.function.Function<? super T,? extends K> classifier) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} implementing a cascaded "group by" operation
 * on input elements of type {@code T}, grouping elements according to a
 * classification function, and then performing a reduction operation on
 * the values associated with a given key using the specified downstream
 * {@code Collector}.
 *
 * <p>The classification function maps elements to some key type {@code K}.
 * The downstream collector operates on elements of type {@code T} and
 * produces a result of type {@code D}. The resulting collector produces a
 * {@code Map<K, D>}.
 *
 * <p>There are no guarantees on the type, mutability,
 * serializability, or thread-safety of the {@code Map} returned.
 *
 * <p>For example, to compute the set of last names of people in each city:
 * <pre>{@code
 *     Map<City, Set<String>> namesByCity
 *         = people.stream().collect(groupingBy(Person::getCity,
 *                                              mapping(Person::getLastName, toSet())));
 * }</pre>
 *
 * @implNote
 * The returned {@code Collector} is not concurrent.  For parallel stream
 * pipelines, the {@code combiner} function operates by merging the keys
 * from one map into another, which can be an expensive operation.  If
 * preservation of the order in which elements are presented to the downstream
 * collector is not required, using {@link #groupingByConcurrent(java.util.function.Function,java.util.stream.Collector)}
 * may offer better parallel performance.
 *
 * @param <T> the type of the input elements
 * @param <K> the type of the keys
 * @param <A> the intermediate accumulation type of the downstream collector
 * @param <D> the result type of the downstream reduction
 * @param classifier a classifier function mapping input elements to keys
 * @param downstream a {@code Collector} implementing the downstream reduction
 * @return a {@code Collector} implementing the cascaded group-by operation
 * @see #groupingBy(Function)
 *
 * @see #groupingBy(Function, Supplier, Collector)
 * @see #groupingByConcurrent(Function, Collector)
 * @apiSince 24
 */

public static <T, K, A, D> java.util.stream.Collector<T,?,java.util.Map<K,D>> groupingBy(java.util.function.Function<? super T,? extends K> classifier, java.util.stream.Collector<? super T,A,D> downstream) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} implementing a cascaded "group by" operation
 * on input elements of type {@code T}, grouping elements according to a
 * classification function, and then performing a reduction operation on
 * the values associated with a given key using the specified downstream
 * {@code Collector}.  The {@code Map} produced by the Collector is created
 * with the supplied factory function.
 *
 * <p>The classification function maps elements to some key type {@code K}.
 * The downstream collector operates on elements of type {@code T} and
 * produces a result of type {@code D}. The resulting collector produces a
 * {@code Map<K, D>}.
 *
 * <p>For example, to compute the set of last names of people in each city,
 * where the city names are sorted:
 * <pre>{@code
 *     Map<City, Set<String>> namesByCity
 *         = people.stream().collect(groupingBy(Person::getCity, TreeMap::new,
 *                                              mapping(Person::getLastName, toSet())));
 * }</pre>
 *
 * @implNote
 * The returned {@code Collector} is not concurrent.  For parallel stream
 * pipelines, the {@code combiner} function operates by merging the keys
 * from one map into another, which can be an expensive operation.  If
 * preservation of the order in which elements are presented to the downstream
 * collector is not required, using {@link #groupingByConcurrent(java.util.function.Function,java.util.function.Supplier,java.util.stream.Collector)}
 * may offer better parallel performance.
 *
 * @param <T> the type of the input elements
 * @param <K> the type of the keys
 * @param <A> the intermediate accumulation type of the downstream collector
 * @param <D> the result type of the downstream reduction
 * @param <M> the type of the resulting {@code Map}
 * @param classifier a classifier function mapping input elements to keys
 * @param downstream a {@code Collector} implementing the downstream reduction
 * @param mapFactory a function which, when called, produces a new empty
 *                   {@code Map} of the desired type
 * @return a {@code Collector} implementing the cascaded group-by operation
 *
 * @see #groupingBy(Function, Collector)
 * @see #groupingBy(Function)
 * @see #groupingByConcurrent(Function, Supplier, Collector)
 * @apiSince 24
 */

public static <T, K, D, A, M extends java.util.Map<K, D>> java.util.stream.Collector<T,?,M> groupingBy(java.util.function.Function<? super T,? extends K> classifier, java.util.function.Supplier<M> mapFactory, java.util.stream.Collector<? super T,A,D> downstream) { throw new RuntimeException("Stub!"); }

/**
 * Returns a concurrent {@code Collector} implementing a "group by"
 * operation on input elements of type {@code T}, grouping elements
 * according to a classification function.
 *
 * <p>This is a {@link java.util.stream.Collector.Characteristics#CONCURRENT Collector.Characteristics#CONCURRENT} and
 * {@link java.util.stream.Collector.Characteristics#UNORDERED Collector.Characteristics#UNORDERED} Collector.
 *
 * <p>The classification function maps elements to some key type {@code K}.
 * The collector produces a {@code ConcurrentMap<K, List<T>>} whose keys are the
 * values resulting from applying the classification function to the input
 * elements, and whose corresponding values are {@code List}s containing the
 * input elements which map to the associated key under the classification
 * function.
 *
 * <p>There are no guarantees on the type, mutability, or serializability
 * of the {@code Map} or {@code List} objects returned, or of the
 * thread-safety of the {@code List} objects returned.
 * @implSpec
 * This produces a result similar to:
 * <pre>{@code
 *     groupingByConcurrent(classifier, toList());
 * }</pre>
 *
 * @param <T> the type of the input elements
 * @param <K> the type of the keys
 * @param classifier a classifier function mapping input elements to keys
 * @return a concurrent, unordered {@code Collector} implementing the group-by operation
 *
 * @see #groupingBy(Function)
 * @see #groupingByConcurrent(Function, Collector)
 * @see #groupingByConcurrent(Function, Supplier, Collector)
 * @apiSince 24
 */

public static <T, K> java.util.stream.Collector<T,?,java.util.concurrent.ConcurrentMap<K,java.util.List<T>>> groupingByConcurrent(java.util.function.Function<? super T,? extends K> classifier) { throw new RuntimeException("Stub!"); }

/**
 * Returns a concurrent {@code Collector} implementing a cascaded "group by"
 * operation on input elements of type {@code T}, grouping elements
 * according to a classification function, and then performing a reduction
 * operation on the values associated with a given key using the specified
 * downstream {@code Collector}.
 *
 * <p>This is a {@link java.util.stream.Collector.Characteristics#CONCURRENT Collector.Characteristics#CONCURRENT} and
 * {@link java.util.stream.Collector.Characteristics#UNORDERED Collector.Characteristics#UNORDERED} Collector.
 *
 * <p>The classification function maps elements to some key type {@code K}.
 * The downstream collector operates on elements of type {@code T} and
 * produces a result of type {@code D}. The resulting collector produces a
 * {@code Map<K, D>}.
 *
 * <p>For example, to compute the set of last names of people in each city,
 * where the city names are sorted:
 * <pre>{@code
 *     ConcurrentMap<City, Set<String>> namesByCity
 *         = people.stream().collect(groupingByConcurrent(Person::getCity,
 *                                                        mapping(Person::getLastName, toSet())));
 * }</pre>
 *
 * @param <T> the type of the input elements
 * @param <K> the type of the keys
 * @param <A> the intermediate accumulation type of the downstream collector
 * @param <D> the result type of the downstream reduction
 * @param classifier a classifier function mapping input elements to keys
 * @param downstream a {@code Collector} implementing the downstream reduction
 * @return a concurrent, unordered {@code Collector} implementing the cascaded group-by operation
 *
 * @see #groupingBy(Function, Collector)
 * @see #groupingByConcurrent(Function)
 * @see #groupingByConcurrent(Function, Supplier, Collector)
 * @apiSince 24
 */

public static <T, K, A, D> java.util.stream.Collector<T,?,java.util.concurrent.ConcurrentMap<K,D>> groupingByConcurrent(java.util.function.Function<? super T,? extends K> classifier, java.util.stream.Collector<? super T,A,D> downstream) { throw new RuntimeException("Stub!"); }

/**
 * Returns a concurrent {@code Collector} implementing a cascaded "group by"
 * operation on input elements of type {@code T}, grouping elements
 * according to a classification function, and then performing a reduction
 * operation on the values associated with a given key using the specified
 * downstream {@code Collector}.  The {@code ConcurrentMap} produced by the
 * Collector is created with the supplied factory function.
 *
 * <p>This is a {@link java.util.stream.Collector.Characteristics#CONCURRENT Collector.Characteristics#CONCURRENT} and
 * {@link java.util.stream.Collector.Characteristics#UNORDERED Collector.Characteristics#UNORDERED} Collector.
 *
 * <p>The classification function maps elements to some key type {@code K}.
 * The downstream collector operates on elements of type {@code T} and
 * produces a result of type {@code D}. The resulting collector produces a
 * {@code Map<K, D>}.
 *
 * <p>For example, to compute the set of last names of people in each city,
 * where the city names are sorted:
 * <pre>{@code
 *     ConcurrentMap<City, Set<String>> namesByCity
 *         = people.stream().collect(groupingBy(Person::getCity, ConcurrentSkipListMap::new,
 *                                              mapping(Person::getLastName, toSet())));
 * }</pre>
 *
 *
 * @param <T> the type of the input elements
 * @param <K> the type of the keys
 * @param <A> the intermediate accumulation type of the downstream collector
 * @param <D> the result type of the downstream reduction
 * @param <M> the type of the resulting {@code ConcurrentMap}
 * @param classifier a classifier function mapping input elements to keys
 * @param downstream a {@code Collector} implementing the downstream reduction
 * @param mapFactory a function which, when called, produces a new empty
 *                   {@code ConcurrentMap} of the desired type
 * @return a concurrent, unordered {@code Collector} implementing the cascaded group-by operation
 *
 * @see #groupingByConcurrent(Function)
 * @see #groupingByConcurrent(Function, Collector)
 * @see #groupingBy(Function, Supplier, Collector)
 * @apiSince 24
 */

public static <T, K, A, D, M extends java.util.concurrent.ConcurrentMap<K, D>> java.util.stream.Collector<T,?,M> groupingByConcurrent(java.util.function.Function<? super T,? extends K> classifier, java.util.function.Supplier<M> mapFactory, java.util.stream.Collector<? super T,A,D> downstream) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} which partitions the input elements according
 * to a {@code Predicate}, and organizes them into a
 * {@code Map<Boolean, List<T>>}.
 *
 * There are no guarantees on the type, mutability,
 * serializability, or thread-safety of the {@code Map} returned.
 *
 * @param <T> the type of the input elements
 * @param predicate a predicate used for classifying input elements
 * @return a {@code Collector} implementing the partitioning operation
 *
 * @see #partitioningBy(Predicate, Collector)
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,java.util.Map<java.lang.Boolean,java.util.List<T>>> partitioningBy(java.util.function.Predicate<? super T> predicate) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} which partitions the input elements according
 * to a {@code Predicate}, reduces the values in each partition according to
 * another {@code Collector}, and organizes them into a
 * {@code Map<Boolean, D>} whose values are the result of the downstream
 * reduction.
 *
 * <p>There are no guarantees on the type, mutability,
 * serializability, or thread-safety of the {@code Map} returned.
 *
 * @param <T> the type of the input elements
 * @param <A> the intermediate accumulation type of the downstream collector
 * @param <D> the result type of the downstream reduction
 * @param predicate a predicate used for classifying input elements
 * @param downstream a {@code Collector} implementing the downstream
 *                   reduction
 * @return a {@code Collector} implementing the cascaded partitioning
 *         operation
 *
 * @see #partitioningBy(Predicate)
 * @apiSince 24
 */

public static <T, D, A> java.util.stream.Collector<T,?,java.util.Map<java.lang.Boolean,D>> partitioningBy(java.util.function.Predicate<? super T> predicate, java.util.stream.Collector<? super T,A,D> downstream) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that accumulates elements into a
 * {@code Map} whose keys and values are the result of applying the provided
 * mapping functions to the input elements.
 *
 * <p>If the mapped keys contains duplicates (according to
 * {@link java.lang.Object#equals(java.lang.Object) Object#equals(Object)}), an {@code IllegalStateException} is
 * thrown when the collection operation is performed.  If the mapped keys
 * may have duplicates, use {@link #toMap(java.util.function.Function,java.util.function.Function,java.util.function.BinaryOperator)}
 * instead.
 *
 * @apiNote
 * It is common for either the key or the value to be the input elements.
 * In this case, the utility method
 * {@link java.util.function.Function#identity()} may be helpful.
 * For example, the following produces a {@code Map} mapping
 * students to their grade point average:
 * <pre>{@code
 *     Map<Student, Double> studentToGPA
 *         students.stream().collect(toMap(Functions.identity(),
 *                                         student -> computeGPA(student)));
 * }</pre>
 * And the following produces a {@code Map} mapping a unique identifier to
 * students:
 * <pre>{@code
 *     Map<String, Student> studentIdToStudent
 *         students.stream().collect(toMap(Student::getId,
 *                                         Functions.identity());
 * }</pre>
 *
 * @implNote
 * The returned {@code Collector} is not concurrent.  For parallel stream
 * pipelines, the {@code combiner} function operates by merging the keys
 * from one map into another, which can be an expensive operation.  If it is
 * not required that results are inserted into the {@code Map} in encounter
 * order, using {@link #toConcurrentMap(java.util.function.Function,java.util.function.Function)}
 * may offer better parallel performance.
 *
 * @param <T> the type of the input elements
 * @param <K> the output type of the key mapping function
 * @param <U> the output type of the value mapping function
 * @param keyMapper a mapping function to produce keys
 * @param valueMapper a mapping function to produce values
 * @return a {@code Collector} which collects elements into a {@code Map}
 * whose keys and values are the result of applying mapping functions to
 * the input elements
 *
 * @see #toMap(Function, Function, BinaryOperator)
 * @see #toMap(Function, Function, BinaryOperator, Supplier)
 * @see #toConcurrentMap(Function, Function)
 * @apiSince 24
 */

public static <T, K, U> java.util.stream.Collector<T,?,java.util.Map<K,U>> toMap(java.util.function.Function<? super T,? extends K> keyMapper, java.util.function.Function<? super T,? extends U> valueMapper) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that accumulates elements into a
 * {@code Map} whose keys and values are the result of applying the provided
 * mapping functions to the input elements.
 *
 * <p>If the mapped
 * keys contains duplicates (according to {@link java.lang.Object#equals(java.lang.Object) Object#equals(Object)}),
 * the value mapping function is applied to each equal element, and the
 * results are merged using the provided merging function.
 *
 * @apiNote
 * There are multiple ways to deal with collisions between multiple elements
 * mapping to the same key.  The other forms of {@code toMap} simply use
 * a merge function that throws unconditionally, but you can easily write
 * more flexible merge policies.  For example, if you have a stream
 * of {@code Person}, and you want to produce a "phone book" mapping name to
 * address, but it is possible that two persons have the same name, you can
 * do as follows to gracefully deals with these collisions, and produce a
 * {@code Map} mapping names to a concatenated list of addresses:
 * <pre>{@code
 *     Map<String, String> phoneBook
 *         people.stream().collect(toMap(Person::getName,
 *                                       Person::getAddress,
 *                                       (s, a) -> s + ", " + a));
 * }</pre>
 *
 * @implNote
 * The returned {@code Collector} is not concurrent.  For parallel stream
 * pipelines, the {@code combiner} function operates by merging the keys
 * from one map into another, which can be an expensive operation.  If it is
 * not required that results are merged into the {@code Map} in encounter
 * order, using {@link #toConcurrentMap(java.util.function.Function,java.util.function.Function,java.util.function.BinaryOperator)}
 * may offer better parallel performance.
 *
 * @param <T> the type of the input elements
 * @param <K> the output type of the key mapping function
 * @param <U> the output type of the value mapping function
 * @param keyMapper a mapping function to produce keys
 * @param valueMapper a mapping function to produce values
 * @param mergeFunction a merge function, used to resolve collisions between
 *                      values associated with the same key, as supplied
 *                      to {@link java.util.Map#merge(java.lang.Object,java.lang.Object,java.util.function.BiFunction) Map#merge(Object, Object, BiFunction)}
 * @return a {@code Collector} which collects elements into a {@code Map}
 * whose keys are the result of applying a key mapping function to the input
 * elements, and whose values are the result of applying a value mapping
 * function to all input elements equal to the key and combining them
 * using the merge function
 *
 * @see #toMap(Function, Function)
 * @see #toMap(Function, Function, BinaryOperator, Supplier)
 * @see #toConcurrentMap(Function, Function, BinaryOperator)
 * @apiSince 24
 */

public static <T, K, U> java.util.stream.Collector<T,?,java.util.Map<K,U>> toMap(java.util.function.Function<? super T,? extends K> keyMapper, java.util.function.Function<? super T,? extends U> valueMapper, java.util.function.BinaryOperator<U> mergeFunction) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} that accumulates elements into a
 * {@code Map} whose keys and values are the result of applying the provided
 * mapping functions to the input elements.
 *
 * <p>If the mapped
 * keys contains duplicates (according to {@link java.lang.Object#equals(java.lang.Object) Object#equals(Object)}),
 * the value mapping function is applied to each equal element, and the
 * results are merged using the provided merging function.  The {@code Map}
 * is created by a provided supplier function.
 *
 * @implNote
 * The returned {@code Collector} is not concurrent.  For parallel stream
 * pipelines, the {@code combiner} function operates by merging the keys
 * from one map into another, which can be an expensive operation.  If it is
 * not required that results are merged into the {@code Map} in encounter
 * order, using {@link #toConcurrentMap(java.util.function.Function,java.util.function.Function,java.util.function.BinaryOperator,java.util.function.Supplier)}
 * may offer better parallel performance.
 *
 * @param <T> the type of the input elements
 * @param <K> the output type of the key mapping function
 * @param <U> the output type of the value mapping function
 * @param <M> the type of the resulting {@code Map}
 * @param keyMapper a mapping function to produce keys
 * @param valueMapper a mapping function to produce values
 * @param mergeFunction a merge function, used to resolve collisions between
 *                      values associated with the same key, as supplied
 *                      to {@link java.util.Map#merge(java.lang.Object,java.lang.Object,java.util.function.BiFunction) Map#merge(Object, Object, BiFunction)}
 * @param mapSupplier a function which returns a new, empty {@code Map} into
 *                    which the results will be inserted
 * @return a {@code Collector} which collects elements into a {@code Map}
 * whose keys are the result of applying a key mapping function to the input
 * elements, and whose values are the result of applying a value mapping
 * function to all input elements equal to the key and combining them
 * using the merge function
 *
 * @see #toMap(Function, Function)
 * @see #toMap(Function, Function, BinaryOperator)
 * @see #toConcurrentMap(Function, Function, BinaryOperator, Supplier)
 * @apiSince 24
 */

public static <T, K, U, M extends java.util.Map<K, U>> java.util.stream.Collector<T,?,M> toMap(java.util.function.Function<? super T,? extends K> keyMapper, java.util.function.Function<? super T,? extends U> valueMapper, java.util.function.BinaryOperator<U> mergeFunction, java.util.function.Supplier<M> mapSupplier) { throw new RuntimeException("Stub!"); }

/**
 * Returns a concurrent {@code Collector} that accumulates elements into a
 * {@code ConcurrentMap} whose keys and values are the result of applying
 * the provided mapping functions to the input elements.
 *
 * <p>If the mapped keys contains duplicates (according to
 * {@link java.lang.Object#equals(java.lang.Object) Object#equals(Object)}), an {@code IllegalStateException} is
 * thrown when the collection operation is performed.  If the mapped keys
 * may have duplicates, use
 * {@link #toConcurrentMap(java.util.function.Function,java.util.function.Function,java.util.function.BinaryOperator)} instead.
 *
 * @apiNote
 * It is common for either the key or the value to be the input elements.
 * In this case, the utility method
 * {@link java.util.function.Function#identity()} may be helpful.
 * For example, the following produces a {@code Map} mapping
 * students to their grade point average:
 * <pre>{@code
 *     Map<Student, Double> studentToGPA
 *         students.stream().collect(toMap(Functions.identity(),
 *                                         student -> computeGPA(student)));
 * }</pre>
 * And the following produces a {@code Map} mapping a unique identifier to
 * students:
 * <pre>{@code
 *     Map<String, Student> studentIdToStudent
 *         students.stream().collect(toConcurrentMap(Student::getId,
 *                                                   Functions.identity());
 * }</pre>
 *
 * <p>This is a {@link java.util.stream.Collector.Characteristics#CONCURRENT Collector.Characteristics#CONCURRENT} and
 * {@link java.util.stream.Collector.Characteristics#UNORDERED Collector.Characteristics#UNORDERED} Collector.
 *
 * @param <T> the type of the input elements
 * @param <K> the output type of the key mapping function
 * @param <U> the output type of the value mapping function
 * @param keyMapper the mapping function to produce keys
 * @param valueMapper the mapping function to produce values
 * @return a concurrent, unordered {@code Collector} which collects elements into a
 * {@code ConcurrentMap} whose keys are the result of applying a key mapping
 * function to the input elements, and whose values are the result of
 * applying a value mapping function to the input elements
 *
 * @see #toMap(Function, Function)
 * @see #toConcurrentMap(Function, Function, BinaryOperator)
 * @see #toConcurrentMap(Function, Function, BinaryOperator, Supplier)
 * @apiSince 24
 */

public static <T, K, U> java.util.stream.Collector<T,?,java.util.concurrent.ConcurrentMap<K,U>> toConcurrentMap(java.util.function.Function<? super T,? extends K> keyMapper, java.util.function.Function<? super T,? extends U> valueMapper) { throw new RuntimeException("Stub!"); }

/**
 * Returns a concurrent {@code Collector} that accumulates elements into a
 * {@code ConcurrentMap} whose keys and values are the result of applying
 * the provided mapping functions to the input elements.
 *
 * <p>If the mapped keys contains duplicates (according to {@link java.lang.Object#equals(java.lang.Object) Object#equals(Object)}),
 * the value mapping function is applied to each equal element, and the
 * results are merged using the provided merging function.
 *
 * @apiNote
 * There are multiple ways to deal with collisions between multiple elements
 * mapping to the same key.  The other forms of {@code toConcurrentMap} simply use
 * a merge function that throws unconditionally, but you can easily write
 * more flexible merge policies.  For example, if you have a stream
 * of {@code Person}, and you want to produce a "phone book" mapping name to
 * address, but it is possible that two persons have the same name, you can
 * do as follows to gracefully deals with these collisions, and produce a
 * {@code Map} mapping names to a concatenated list of addresses:
 * <pre>{@code
 *     Map<String, String> phoneBook
 *         people.stream().collect(toConcurrentMap(Person::getName,
 *                                                 Person::getAddress,
 *                                                 (s, a) -> s + ", " + a));
 * }</pre>
 *
 * <p>This is a {@link java.util.stream.Collector.Characteristics#CONCURRENT Collector.Characteristics#CONCURRENT} and
 * {@link java.util.stream.Collector.Characteristics#UNORDERED Collector.Characteristics#UNORDERED} Collector.
 *
 * @param <T> the type of the input elements
 * @param <K> the output type of the key mapping function
 * @param <U> the output type of the value mapping function
 * @param keyMapper a mapping function to produce keys
 * @param valueMapper a mapping function to produce values
 * @param mergeFunction a merge function, used to resolve collisions between
 *                      values associated with the same key, as supplied
 *                      to {@link java.util.Map#merge(java.lang.Object,java.lang.Object,java.util.function.BiFunction) Map#merge(Object, Object, BiFunction)}
 * @return a concurrent, unordered {@code Collector} which collects elements into a
 * {@code ConcurrentMap} whose keys are the result of applying a key mapping
 * function to the input elements, and whose values are the result of
 * applying a value mapping function to all input elements equal to the key
 * and combining them using the merge function
 *
 * @see #toConcurrentMap(Function, Function)
 * @see #toConcurrentMap(Function, Function, BinaryOperator, Supplier)
 * @see #toMap(Function, Function, BinaryOperator)
 * @apiSince 24
 */

public static <T, K, U> java.util.stream.Collector<T,?,java.util.concurrent.ConcurrentMap<K,U>> toConcurrentMap(java.util.function.Function<? super T,? extends K> keyMapper, java.util.function.Function<? super T,? extends U> valueMapper, java.util.function.BinaryOperator<U> mergeFunction) { throw new RuntimeException("Stub!"); }

/**
 * Returns a concurrent {@code Collector} that accumulates elements into a
 * {@code ConcurrentMap} whose keys and values are the result of applying
 * the provided mapping functions to the input elements.
 *
 * <p>If the mapped keys contains duplicates (according to {@link java.lang.Object#equals(java.lang.Object) Object#equals(Object)}),
 * the value mapping function is applied to each equal element, and the
 * results are merged using the provided merging function.  The
 * {@code ConcurrentMap} is created by a provided supplier function.
 *
 * <p>This is a {@link java.util.stream.Collector.Characteristics#CONCURRENT Collector.Characteristics#CONCURRENT} and
 * {@link java.util.stream.Collector.Characteristics#UNORDERED Collector.Characteristics#UNORDERED} Collector.
 *
 * @param <T> the type of the input elements
 * @param <K> the output type of the key mapping function
 * @param <U> the output type of the value mapping function
 * @param <M> the type of the resulting {@code ConcurrentMap}
 * @param keyMapper a mapping function to produce keys
 * @param valueMapper a mapping function to produce values
 * @param mergeFunction a merge function, used to resolve collisions between
 *                      values associated with the same key, as supplied
 *                      to {@link java.util.Map#merge(java.lang.Object,java.lang.Object,java.util.function.BiFunction) Map#merge(Object, Object, BiFunction)}
 * @param mapSupplier a function which returns a new, empty {@code Map} into
 *                    which the results will be inserted
 * @return a concurrent, unordered {@code Collector} which collects elements into a
 * {@code ConcurrentMap} whose keys are the result of applying a key mapping
 * function to the input elements, and whose values are the result of
 * applying a value mapping function to all input elements equal to the key
 * and combining them using the merge function
 *
 * @see #toConcurrentMap(Function, Function)
 * @see #toConcurrentMap(Function, Function, BinaryOperator)
 * @see #toMap(Function, Function, BinaryOperator, Supplier)
 * @apiSince 24
 */

public static <T, K, U, M extends java.util.concurrent.ConcurrentMap<K, U>> java.util.stream.Collector<T,?,M> toConcurrentMap(java.util.function.Function<? super T,? extends K> keyMapper, java.util.function.Function<? super T,? extends U> valueMapper, java.util.function.BinaryOperator<U> mergeFunction, java.util.function.Supplier<M> mapSupplier) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} which applies an {@code int}-producing
 * mapping function to each input element, and returns summary statistics
 * for the resulting values.
 *
 * @param <T> the type of the input elements
 * @param mapper a mapping function to apply to each element
 * @return a {@code Collector} implementing the summary-statistics reduction
 *
 * @see #summarizingDouble(ToDoubleFunction)
 * @see #summarizingLong(ToLongFunction)
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,java.util.IntSummaryStatistics> summarizingInt(java.util.function.ToIntFunction<? super T> mapper) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} which applies an {@code long}-producing
 * mapping function to each input element, and returns summary statistics
 * for the resulting values.
 *
 * @param <T> the type of the input elements
 * @param mapper the mapping function to apply to each element
 * @return a {@code Collector} implementing the summary-statistics reduction
 *
 * @see #summarizingDouble(ToDoubleFunction)
 * @see #summarizingInt(ToIntFunction)
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,java.util.LongSummaryStatistics> summarizingLong(java.util.function.ToLongFunction<? super T> mapper) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collector} which applies an {@code double}-producing
 * mapping function to each input element, and returns summary statistics
 * for the resulting values.
 *
 * @param <T> the type of the input elements
 * @param mapper a mapping function to apply to each element
 * @return a {@code Collector} implementing the summary-statistics reduction
 *
 * @see #summarizingLong(ToLongFunction)
 * @see #summarizingInt(ToIntFunction)
 * @apiSince 24
 */

public static <T> java.util.stream.Collector<T,?,java.util.DoubleSummaryStatistics> summarizingDouble(java.util.function.ToDoubleFunction<? super T> mapper) { throw new RuntimeException("Stub!"); }
}

