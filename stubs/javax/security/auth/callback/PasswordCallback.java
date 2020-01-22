/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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



package javax.security.auth.callback;


/**
 * <p> Underlying security services instantiate and pass a
 * {@code PasswordCallback} to the {@code handle}
 * method of a {@code CallbackHandler} to retrieve password information.
 *
 * @see javax.security.auth.callback.CallbackHandler
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PasswordCallback implements javax.security.auth.callback.Callback, java.io.Serializable {

/**
 * Construct a {@code PasswordCallback} with a prompt
 * and a boolean specifying whether the password should be displayed
 * as it is being typed.
 *
 * <p>
 *
 * @param prompt the prompt used to request the password. <p>
 *
 * @param echoOn true if the password should be displayed
 *                  as it is being typed.
 *
 * @exception java.lang.IllegalArgumentException if {@code prompt} is null or
 *                  if {@code prompt} has a length of 0.
 * @apiSince 1
 */

public PasswordCallback(java.lang.String prompt, boolean echoOn) { throw new RuntimeException("Stub!"); }

/**
 * Get the prompt.
 *
 * <p>
 *
 * @return the prompt.
 * @apiSince 1
 */

public java.lang.String getPrompt() { throw new RuntimeException("Stub!"); }

/**
 * Return whether the password
 * should be displayed as it is being typed.
 *
 * <p>
 *
 * @return the whether the password
 *          should be displayed as it is being typed.
 * @apiSince 1
 */

public boolean isEchoOn() { throw new RuntimeException("Stub!"); }

/**
 * Set the retrieved password.
 *
 * <p> This method makes a copy of the input <i>password</i>
 * before storing it.
 *
 * <p>
 *
 * @param password the retrieved password, which may be null.
 *
 * @see #getPassword
 * @apiSince 1
 */

public void setPassword(char[] password) { throw new RuntimeException("Stub!"); }

/**
 * Get the retrieved password.
 *
 * <p> This method returns a copy of the retrieved password.
 *
 * <p>
 *
 * @return the retrieved password, which may be null.
 *
 * @see #setPassword
 * @apiSince 1
 */

public char[] getPassword() { throw new RuntimeException("Stub!"); }

/**
 * Clear the retrieved password.
 * @apiSince 1
 */

public void clearPassword() { throw new RuntimeException("Stub!"); }
}

