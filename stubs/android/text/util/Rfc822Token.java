/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.text.util;


/**
 * This class stores an RFC 822-like name, address, and comment,
 * and provides methods to convert them to quoted strings.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Rfc822Token {

/**
 * Creates a new Rfc822Token with the specified name, address,
 * and comment.
 
 * @param name This value may be {@code null}.
 
 * @param address This value may be {@code null}.
 
 * @param comment This value may be {@code null}.
 * @apiSince 1
 */

public Rfc822Token(@androidx.annotation.Nullable java.lang.String name, @androidx.annotation.Nullable java.lang.String address, @androidx.annotation.Nullable java.lang.String comment) { throw new RuntimeException("Stub!"); }

/**
 * Returns the name part.
 
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the address part.
 
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String getAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the comment part.
 
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String getComment() { throw new RuntimeException("Stub!"); }

/**
 * Changes the name to the specified name.
 
 * @param name This value may be {@code null}.
 * @apiSince 1
 */

public void setName(@androidx.annotation.Nullable java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Changes the address to the specified address.
 
 * @param address This value may be {@code null}.
 * @apiSince 1
 */

public void setAddress(@androidx.annotation.Nullable java.lang.String address) { throw new RuntimeException("Stub!"); }

/**
 * Changes the comment to the specified comment.
 
 * @param comment This value may be {@code null}.
 * @apiSince 1
 */

public void setComment(@androidx.annotation.Nullable java.lang.String comment) { throw new RuntimeException("Stub!"); }

/**
 * Returns the name (with quoting added if necessary),
 * the comment (in parentheses), and the address (in angle brackets).
 * This should be suitable for inclusion in an RFC 822 address list.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name, conservatively quoting it if there are any
 * characters that are likely to cause trouble outside of a
 * quoted string, or returning it literally if it seems safe.
 * @apiSince 1
 */

public static java.lang.String quoteNameIfNecessary(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the name, with internal backslashes and quotation marks
 * preceded by backslashes.  The outer quote marks themselves are not
 * added by this method.
 * @apiSince 1
 */

public static java.lang.String quoteName(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the comment, with internal backslashes and parentheses
 * preceded by backslashes.  The outer parentheses themselves are
 * not added by this method.
 * @apiSince 1
 */

public static java.lang.String quoteComment(java.lang.String comment) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }
}

