/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.security;

import java.util.*;
import java.util.regex.*;

/**
 * This class provides a cryptographically strong random number
 * generator (RNG).
 *
 * <p>A cryptographically strong random number
 * minimally complies with the statistical random number generator tests
 * specified in <a href="http://csrc.nist.gov/cryptval/140-2.htm">
 * <i>FIPS 140-2, Security Requirements for Cryptographic Modules</i></a>,
 * section 4.9.1.
 * Additionally, SecureRandom must produce non-deterministic output.
 * Therefore any seed material passed to a SecureRandom object must be
 * unpredictable, and all SecureRandom output sequences must be
 * cryptographically strong, as described in
 * <a href="http://www.ietf.org/rfc/rfc1750.txt">
 * <i>RFC 1750: Randomness Recommendations for Security</i></a>.
 *
 * <p>A caller obtains a SecureRandom instance via the
 * no-argument constructor or one of the {@code getInstance} methods:
 *
 * <pre>
 *      SecureRandom random = new SecureRandom();
 * </pre>
 *
 * <p> Many SecureRandom implementations are in the form of a pseudo-random
 * number generator (PRNG), which means they use a deterministic algorithm
 * to produce a pseudo-random sequence from a true random seed.
 * Other implementations may produce true random numbers,
 * and yet others may use a combination of both techniques.
 *
 * <p> Typical callers of SecureRandom invoke the following methods
 * to retrieve random bytes:
 *
 * <pre>
 *      SecureRandom random = new SecureRandom();
 *      byte bytes[] = new byte[20];
 *      random.nextBytes(bytes);
 * </pre>
 *
 * <p> Callers may also invoke the {@code generateSeed} method
 * to generate a given number of seed bytes (to seed other random number
 * generators, for example):
 * <pre>
 *      byte seed[] = random.generateSeed(20);
 * </pre>
 *
 * Note: Depending on the implementation, the {@code generateSeed} and
 * {@code nextBytes} methods may block as entropy is being gathered,
 * for example, if they need to read from /dev/random on various Unix-like
 * operating systems.
 *
 * The SHA1PRNG algorithm from the Crypto provider has been deprecated as it was insecure, and also
 * incorrectly used by some apps as a key derivation function. See
 * <a href="http://android-developers.blogspot.com/2016/06/security-crypto-provider-deprecated-in.html">
 * Security &quot;Crypto&quot; provider deprecated in Android N</a> for details.
 *
 * @see java.security.SecureRandomSpi
 * @see java.util.Random
 *
 * @author Benjamin Renaud
 * @author Josh Bloch
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SecureRandom extends java.util.Random {

/**
 * Constructs a secure random number generator (RNG) implementing the
 * default random number algorithm.
 *
 * <p> This constructor traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new SecureRandom object encapsulating the
 * SecureRandomSpi implementation from the first
 * Provider that supports a SecureRandom (RNG) algorithm is returned.
 * If none of the Providers support a RNG algorithm,
 * then an implementation-specific default is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * <p> See the SecureRandom section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecureRandom">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard RNG algorithm names.
 *
 * <p> The returned SecureRandom object has not been seeded.  To seed the
 * returned object, call the {@code setSeed} method.
 * If {@code setSeed} is not called, the first call to
 * {@code nextBytes} will force the SecureRandom object to seed itself.
 * This self-seeding will not occur if {@code setSeed} was
 * previously called.
 * @apiSince 1
 */

public SecureRandom() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a secure random number generator (RNG) implementing the
 * default random number algorithm.
 * The SecureRandom instance is seeded with the specified seed bytes.
 *
 * <p> This constructor traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new SecureRandom object encapsulating the
 * SecureRandomSpi implementation from the first
 * Provider that supports a SecureRandom (RNG) algorithm is returned.
 * If none of the Providers support a RNG algorithm,
 * then an implementation-specific default is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * <p> See the SecureRandom section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecureRandom">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard RNG algorithm names.
 *
 * @param seed the seed.
 * @apiSince 1
 */

public SecureRandom(byte[] seed) { throw new RuntimeException("Stub!"); }

/**
 * Creates a SecureRandom object.
 *
 * @param secureRandomSpi the SecureRandom implementation.
 * @param provider the provider.
 * @apiSince 1
 */

protected SecureRandom(java.security.SecureRandomSpi secureRandomSpi, java.security.Provider provider) { throw new RuntimeException("Stub!"); }

/**
 * Returns a SecureRandom object that implements the specified
 * Random Number Generator (RNG) algorithm.
 *
 * <p> This method traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new SecureRandom object encapsulating the
 * SecureRandomSpi implementation from the first
 * Provider that supports the specified algorithm is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * <p> The returned SecureRandom object has not been seeded.  To seed the
 * returned object, call the {@code setSeed} method.
 * If {@code setSeed} is not called, the first call to
 * {@code nextBytes} will force the SecureRandom object to seed itself.
 * This self-seeding will not occur if {@code setSeed} was
 * previously called.
 *
 * @param algorithm the name of the RNG algorithm.
 * See the SecureRandom section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecureRandom">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard RNG algorithm names.
 *
 * @return the new SecureRandom object.
 *
 * @exception java.security.NoSuchAlgorithmException if no Provider supports a
 *          SecureRandomSpi implementation for the
 *          specified algorithm.
 *
 * @see java.security.Provider
 *
 * @since 1.2
 * @apiSince 1
 */

public static java.security.SecureRandom getInstance(java.lang.String algorithm) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns a SecureRandom object that implements the specified
 * Random Number Generator (RNG) algorithm.
 *
 * <p> A new SecureRandom object encapsulating the
 * SecureRandomSpi implementation from the specified provider
 * is returned.  The specified provider must be registered
 * in the security provider list.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * <p> The returned SecureRandom object has not been seeded.  To seed the
 * returned object, call the {@code setSeed} method.
 * If {@code setSeed} is not called, the first call to
 * {@code nextBytes} will force the SecureRandom object to seed itself.
 * This self-seeding will not occur if {@code setSeed} was
 * previously called.
 *
 * @param algorithm the name of the RNG algorithm.
 * See the SecureRandom section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecureRandom">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard RNG algorithm names.
 *
 * @param provider the name of the provider.
 *
 * @return the new SecureRandom object.
 *
 * @exception java.security.NoSuchAlgorithmException if a SecureRandomSpi
 *          implementation for the specified algorithm is not
 *          available from the specified provider.
 *
 * @exception java.security.NoSuchProviderException if the specified provider is not
 *          registered in the security provider list.
 *
 * @exception java.lang.IllegalArgumentException if the provider name is null
 *          or empty.
 *
 * @see java.security.Provider
 *
 * @since 1.2
 * @apiSince 1
 */

public static java.security.SecureRandom getInstance(java.lang.String algorithm, java.lang.String provider) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Returns a SecureRandom object that implements the specified
 * Random Number Generator (RNG) algorithm.
 *
 * <p> A new SecureRandom object encapsulating the
 * SecureRandomSpi implementation from the specified Provider
 * object is returned.  Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * <p> The returned SecureRandom object has not been seeded.  To seed the
 * returned object, call the {@code setSeed} method.
 * If {@code setSeed} is not called, the first call to
 * {@code nextBytes} will force the SecureRandom object to seed itself.
 * This self-seeding will not occur if {@code setSeed} was
 * previously called.
 *
 * @param algorithm the name of the RNG algorithm.
 * See the SecureRandom section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecureRandom">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard RNG algorithm names.
 *
 * @param provider the provider.
 *
 * @return the new SecureRandom object.
 *
 * @exception java.security.NoSuchAlgorithmException if a SecureRandomSpi
 *          implementation for the specified algorithm is not available
 *          from the specified Provider object.
 *
 * @exception java.lang.IllegalArgumentException if the specified provider is null.
 *
 * @see java.security.Provider
 *
 * @since 1.4
 * @apiSince 1
 */

public static java.security.SecureRandom getInstance(java.lang.String algorithm, java.security.Provider provider) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider of this SecureRandom object.
 *
 * @return the provider of this SecureRandom object.
 * @apiSince 1
 */

public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the algorithm implemented by this SecureRandom
 * object.
 *
 * @return the name of the algorithm or {@code unknown}
 *          if the algorithm name cannot be determined.
 * @since 1.5
 * @apiSince 1
 */

public java.lang.String getAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Reseeds this random object. The given seed supplements, rather than
 * replaces, the existing seed. Thus, repeated calls are guaranteed
 * never to reduce randomness.
 *
 * @param seed the seed.
 *
 * @see #getSeed
 * @apiSince 1
 */

public synchronized void setSeed(byte[] seed) { throw new RuntimeException("Stub!"); }

/**
 * Reseeds this random object, using the eight bytes contained
 * in the given {@code long seed}. The given seed supplements,
 * rather than replaces, the existing seed. Thus, repeated calls
 * are guaranteed never to reduce randomness.
 *
 * <p>This method is defined for compatibility with
 * {@code java.util.Random}.
 *
 * @param seed the seed.
 *
 * @see #getSeed
 * @apiSince 1
 */

public void setSeed(long seed) { throw new RuntimeException("Stub!"); }

/**
 * Generates a user-specified number of random bytes.
 *
 * <p> If a call to {@code setSeed} had not occurred previously,
 * the first call to this method forces this SecureRandom object
 * to seed itself.  This self-seeding will not occur if
 * {@code setSeed} was previously called.
 *
 * @param bytes the array to be filled in with random bytes.
 * @apiSince 1
 */

public synchronized void nextBytes(byte[] bytes) { throw new RuntimeException("Stub!"); }

/**
 * Generates an integer containing the user-specified number of
 * pseudo-random bits (right justified, with leading zeros).  This
 * method overrides a {@code java.util.Random} method, and serves
 * to provide a source of random bits to all of the methods inherited
 * from that class (for example, {@code nextInt},
 * {@code nextLong}, and {@code nextFloat}).
 *
 * @param numBits number of pseudo-random bits to be generated, where
 * {@code 0 <= numBits <= 32}.
 *
 * @return an {@code int} containing the user-specified number
 * of pseudo-random bits (right justified, with leading zeros).
 * @apiSince 1
 */

protected final int next(int numBits) { throw new RuntimeException("Stub!"); }

/**
 * Returns the given number of seed bytes, computed using the seed
 * generation algorithm that this class uses to seed itself.  This
 * call may be used to seed other random number generators.
 *
 * <p>This method is only included for backwards compatibility.
 * The caller is encouraged to use one of the alternative
 * {@code getInstance} methods to obtain a SecureRandom object, and
 * then call the {@code generateSeed} method to obtain seed bytes
 * from that object.
 *
 * @param numBytes the number of seed bytes to generate.
 *
 * @return the seed bytes.
 *
 * @see #setSeed
 * @apiSince 1
 */

public static byte[] getSeed(int numBytes) { throw new RuntimeException("Stub!"); }

/**
 * Returns the given number of seed bytes, computed using the seed
 * generation algorithm that this class uses to seed itself.  This
 * call may be used to seed other random number generators.
 *
 * @param numBytes the number of seed bytes to generate.
 *
 * @return the seed bytes.
 * @apiSince 1
 */

public byte[] generateSeed(int numBytes) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code SecureRandom} object.
 *
 * In Android this is equivalent to get a SHA1PRNG from AndroidOpenSSL.
 *
 * Some situations require strong random values, such as when
 * creating high-value/long-lived secrets like RSA public/private
 * keys.  To help guide applications in selecting a suitable strong
 * {@code SecureRandom} implementation, Java distributions
 * include a list of known strong {@code SecureRandom}
 * implementations in the {@code securerandom.strongAlgorithms}
 * Security property.
 * <p>
 * Every implementation of the Java platform is required to
 * support at least one strong {@code SecureRandom} implementation.
 *
 * @return a strong {@code SecureRandom} implementation
 *
 * @throws java.security.NoSuchAlgorithmException if no algorithm is available
 *
 * @see java.security.Security#getProperty(String)
 *
 * @since 1.8
 * @apiSince 26
 */

public static java.security.SecureRandom getInstanceStrong() throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }
}

