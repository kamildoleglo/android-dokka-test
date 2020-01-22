/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.google.android.collect;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Provides static methods for creating {@code List} instances easily, and other
 * utility methods for working with lists.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Lists {

public Lists() { throw new RuntimeException("Stub!"); }

/**
 * Creates an empty {@code ArrayList} instance.
 *
 * <p><b>Note:</b> if you only need an <i>immutable</i> empty List, use
 * {@link java.util.Collections#emptyList Collections#emptyList} instead.
 *
 * @return a newly-created, initially-empty {@code ArrayList}
 * @apiSince R
 */

public static <E> java.util.ArrayList<E> newArrayList() { throw new RuntimeException("Stub!"); }

/**
 * Creates a resizable {@code ArrayList} instance containing the given
 * elements.
 *
 * <p><b>Note:</b> due to a bug in javac 1.5.0_06, we cannot support the
 * following:
 *
 * <p>{@code List<Base> list = Lists.newArrayList(sub1, sub2);}
 *
 * <p>where {@code sub1} and {@code sub2} are references to subtypes of
 * {@code Base}, not of {@code Base} itself. To get around this, you must
 * use:
 *
 * <p>{@code List<Base> list = Lists.<Base>newArrayList(sub1, sub2);}
 *
 * @param elements the elements that the list should contain, in order
 * @return a newly-created {@code ArrayList} containing those elements
 * @apiSince R
 */

public static <E> java.util.ArrayList<E> newArrayList(E... elements) { throw new RuntimeException("Stub!"); }
}

