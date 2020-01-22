/*
 * Copyright (c) 1997, 2011, Oracle and/or its affiliates. All rights reserved.
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



package javax.crypto.spec;


/**
 * A user-chosen password that can be used with password-based encryption
 * (<i>PBE</i>).
 *
 * <p>The password can be viewed as some kind of raw key material, from which
 * the encryption mechanism that uses it derives a cryptographic key.
 *
 * <p>Different PBE mechanisms may consume different bits of each password
 * character. For example, the PBE mechanism defined in
 * <a href="http://www.ietf.org/rfc/rfc2898.txt">
 * PKCS #5</a> looks at only the low order 8 bits of each character, whereas
 * PKCS #12 looks at all 16 bits of each character.
 *
 * <p>You convert the password characters to a PBE key by creating an
 * instance of the appropriate secret-key factory. For example, a secret-key
 * factory for PKCS #5 will construct a PBE key from only the low order 8 bits
 * of each password character, whereas a secret-key factory for PKCS #12 will
 * take all 16 bits of each character.
 *
 * <p>Also note that this class stores passwords as char arrays instead of
 * <code>String</code> objects (which would seem more logical), because the
 * String class is immutable and there is no way to overwrite its
 * internal value when the password stored in it is no longer needed. Hence,
 * this class requests the password as a char array, so it can be overwritten
 * when done.
 *
 * @author Jan Luehe
 * @author Valerie Peng
 *
 * @see javax.crypto.SecretKeyFactory
 * @see javax.crypto.spec.PBEParameterSpec
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PBEKeySpec implements java.security.spec.KeySpec {

/**
 * Constructor that takes a password. An empty char[] is used if
 * null is specified.
 *
 * <p> Note: <code>password</code> is cloned before it is stored in
 * the new <code>PBEKeySpec</code> object.
 *
 * @param password the password.
 * @apiSince 1
 */

public PBEKeySpec(char[] password) { throw new RuntimeException("Stub!"); }

/**
 * Constructor that takes a password, salt, iteration count, and
 * to-be-derived key length for generating PBEKey of variable-key-size
 * PBE ciphers.  An empty char[] is used if null is specified for
 * <code>password</code>.
 *
 * <p> Note: the <code>password</code> and <code>salt</code>
 * are cloned before they are stored in
 * the new <code>PBEKeySpec</code> object.
 *
 * @param password the password.
 * @param salt the salt.
 * @param iterationCount the iteration count.
 * @param keyLength the to-be-derived key length.
 * @exception java.lang.NullPointerException if <code>salt</code> is null.
 * @exception java.lang.IllegalArgumentException if <code>salt</code> is empty,
 * i.e. 0-length, <code>iterationCount</code> or
 * <code>keyLength</code> is not positive.
 * @apiSince 1
 */

public PBEKeySpec(char[] password, byte[] salt, int iterationCount, int keyLength) { throw new RuntimeException("Stub!"); }

/**
 * Constructor that takes a password, salt, iteration count for
 * generating PBEKey of fixed-key-size PBE ciphers. An empty
 * char[] is used if null is specified for <code>password</code>.
 *
 * <p> Note: the <code>password</code> and <code>salt</code>
 * are cloned before they are stored in the new
 * <code>PBEKeySpec</code> object.
 *
 * @param password the password.
 * @param salt the salt.
 * @param iterationCount the iteration count.
 * @exception java.lang.NullPointerException if <code>salt</code> is null.
 * @exception java.lang.IllegalArgumentException if <code>salt</code> is empty,
 * i.e. 0-length, or <code>iterationCount</code> is not positive.
 * @apiSince 1
 */

public PBEKeySpec(char[] password, byte[] salt, int iterationCount) { throw new RuntimeException("Stub!"); }

/**
 * Clears the internal copy of the password.
 *
 * @apiSince 1
 */

public final void clearPassword() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the password.
 *
 * <p> Note: this method returns a copy of the password. It is
 * the caller's responsibility to zero out the password information after
 * it is no longer needed.
 *
 * @exception java.lang.IllegalStateException if password has been cleared by
 * calling <code>clearPassword</code> method.
 * @return the password.
 * @apiSince 1
 */

public final char[] getPassword() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the salt or null if not specified.
 *
 * <p> Note: this method should return a copy of the salt. It is
 * the caller's responsibility to zero out the salt information after
 * it is no longer needed.
 *
 * @return the salt.
 * @apiSince 1
 */

public final byte[] getSalt() { throw new RuntimeException("Stub!"); }

/**
 * Returns the iteration count or 0 if not specified.
 *
 * @return the iteration count.
 * @apiSince 1
 */

public final int getIterationCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the to-be-derived key length or 0 if not specified.
 *
 * <p> Note: this is used to indicate the preference on key length
 * for variable-key-size ciphers. The actual key size depends on
 * each provider's implementation.
 *
 * @return the to-be-derived key length.
 * @apiSince 1
 */

public final int getKeyLength() { throw new RuntimeException("Stub!"); }
}

