/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.io.*;
import java.util.*;
import javax.security.auth.callback.*;
import javax.crypto.SecretKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import javax.security.auth.DestroyFailedException;
import java.security.cert.X509Certificate;

/**
 * This class represents a storage facility for cryptographic
 * keys and certificates.
 *
 * <p> A {@code KeyStore} manages different types of entries.
 * Each type of entry implements the {@code KeyStore.Entry} interface.
 * Three basic {@code KeyStore.Entry} implementations are provided:
 *
 * <ul>
 * <li><b>KeyStore.PrivateKeyEntry</b>
 * <p> This type of entry holds a cryptographic {@code PrivateKey},
 * which is optionally stored in a protected format to prevent
 * unauthorized access.  It is also accompanied by a certificate chain
 * for the corresponding public key.
 *
 * <p> Private keys and certificate chains are used by a given entity for
 * self-authentication. Applications for this authentication include software
 * distribution organizations which sign JAR files as part of releasing
 * and/or licensing software.
 *
 * <li><b>KeyStore.SecretKeyEntry</b>
 * <p> This type of entry holds a cryptographic {@code SecretKey},
 * which is optionally stored in a protected format to prevent
 * unauthorized access.
 *
 * <li><b>KeyStore.TrustedCertificateEntry</b>
 * <p> This type of entry contains a single public key {@code Certificate}
 * belonging to another party. It is called a <i>trusted certificate</i>
 * because the keystore owner trusts that the public key in the certificate
 * indeed belongs to the identity identified by the <i>subject</i> (owner)
 * of the certificate.
 *
 * <p>This type of entry can be used to authenticate other parties.
 * </ul>
 *
 * <p> Each entry in a keystore is identified by an "alias" string. In the
 * case of private keys and their associated certificate chains, these strings
 * distinguish among the different ways in which the entity may authenticate
 * itself. For example, the entity may authenticate itself using different
 * certificate authorities, or using different public key algorithms.
 *
 * <p> Whether aliases are case sensitive is implementation dependent. In order
 * to avoid problems, it is recommended not to use aliases in a KeyStore that
 * only differ in case.
 *
 * <p> Whether keystores are persistent, and the mechanisms used by the
 * keystore if it is persistent, are not specified here. This allows
 * use of a variety of techniques for protecting sensitive (e.g., private or
 * secret) keys. Smart cards or other integrated cryptographic engines
 * (SafeKeyper) are one option, and simpler mechanisms such as files may also
 * be used (in a variety of formats).
 *
 * <p> Typical ways to request a KeyStore object include
 * relying on the default type and providing a specific keystore type.
 *
 * <ul>
 * <li>To rely on the default type:
 * <pre>
 *    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
 * </pre>
 * The system will return a keystore implementation for the default type.
 *
 * <li>To provide a specific keystore type:
 * <pre>
 *      KeyStore ks = KeyStore.getInstance("JKS");
 * </pre>
 * The system will return the most preferred implementation of the
 * specified keystore type available in the environment. <p>
 * </ul>
 *
 * <p> Before a keystore can be accessed, it must be
 * {@link #load(java.io.InputStream,char[]) loaded}.
 * <pre>
 *    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
 *
 *    // get user password and file input stream
 *    char[] password = getPassword();
 *
 *    try (FileInputStream fis = new FileInputStream("keyStoreName")) {
 *        ks.load(fis, password);
 *    }
 * </pre>
 *
 * To create an empty keystore using the above {@code load} method,
 * pass {@code null} as the {@code InputStream} argument.
 *
 * <p> Once the keystore has been loaded, it is possible
 * to read existing entries from the keystore, or to write new entries
 * into the keystore:
 * <pre>
 *    KeyStore.ProtectionParameter protParam =
 *        new KeyStore.PasswordProtection(password);
 *
 *    // get my private key
 *    KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry)
 *        ks.getEntry("privateKeyAlias", protParam);
 *    PrivateKey myPrivateKey = pkEntry.getPrivateKey();
 *
 *    // save my secret key
 *    javax.crypto.SecretKey mySecretKey;
 *    KeyStore.SecretKeyEntry skEntry =
 *        new KeyStore.SecretKeyEntry(mySecretKey);
 *    ks.setEntry("secretKeyAlias", skEntry, protParam);
 *
 *    // store away the keystore
 *    try (FileOutputStream fos = new FileOutputStream("newKeyStoreName")) {
 *        ks.store(fos, password);
 *    }
 * </pre>
 *
 * Note that although the same password may be used to
 * load the keystore, to protect the private key entry,
 * to protect the secret key entry, and to store the keystore
 * (as is shown in the sample code above),
 * different passwords or other protection parameters
 * may also be used.
 *
 * <p> Android provides the following <code>KeyStore</code> types:
 * <table>
 *   <thead>
 *     <tr>
 *       <th>Algorithm</th>
 *       <th>Supported API Levels</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>AndroidCAStore</td>
 *       <td>14+</td>
 *     </tr>
 *     <tr>
 *       <td>AndroidKeyStore</td>
 *       <td>18+</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>BCPKCS12</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr>
 *       <td>BKS</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>BouncyCastle</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>PKCS12</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>PKCS12-DEF</td>
 *       <td>1-8</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * These types are described in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyStore">
 * KeyStore section</a> of the
 * Java Cryptography Architecture Standard Algorithm Name Documentation.
 *
 * @author Jan Luehe
 *
 * @see java.security.PrivateKey
 * @see javax.crypto.SecretKey
 * @see java.security.cert.Certificate
 *
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class KeyStore {

/**
 * Creates a KeyStore object of the given type, and encapsulates the given
 * provider implementation (SPI object) in it.
 *
 * @param keyStoreSpi the provider implementation.
 * @param provider the provider.
 * @param type the keystore type.
 * @apiSince 1
 */

protected KeyStore(java.security.KeyStoreSpi keyStoreSpi, java.security.Provider provider, java.lang.String type) { throw new RuntimeException("Stub!"); }

/**
 * Returns a keystore object of the specified type.
 *
 * <p> This method traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new KeyStore object encapsulating the
 * KeyStoreSpi implementation from the first
 * Provider that supports the specified type is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param type the type of keystore.
 * See the KeyStore section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyStore">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard keystore types.
 *
 * @return a keystore object of the specified type.
 *
 * @exception java.security.KeyStoreException if no Provider supports a
 *          KeyStoreSpi implementation for the
 *          specified type.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static java.security.KeyStore getInstance(java.lang.String type) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Returns a keystore object of the specified type.
 *
 * <p> A new KeyStore object encapsulating the
 * KeyStoreSpi implementation from the specified provider
 * is returned.  The specified provider must be registered
 * in the security provider list.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param type the type of keystore.
 * See the KeyStore section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyStore">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard keystore types.
 *
 * @param provider the name of the provider.
 *
 * @return a keystore object of the specified type.
 *
 * @exception java.security.KeyStoreException if a KeyStoreSpi
 *          implementation for the specified type is not
 *          available from the specified provider.
 *
 * @exception java.security.NoSuchProviderException if the specified provider is not
 *          registered in the security provider list.
 *
 * @exception java.lang.IllegalArgumentException if the provider name is null
 *          or empty.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static java.security.KeyStore getInstance(java.lang.String type, java.lang.String provider) throws java.security.KeyStoreException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Returns a keystore object of the specified type.
 *
 * <p> A new KeyStore object encapsulating the
 * KeyStoreSpi implementation from the specified Provider
 * object is returned.  Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * @param type the type of keystore.
 * See the KeyStore section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyStore">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard keystore types.
 *
 * @param provider the provider.
 *
 * @return a keystore object of the specified type.
 *
 * @exception java.security.KeyStoreException if KeyStoreSpi
 *          implementation for the specified type is not available
 *          from the specified Provider object.
 *
 * @exception java.lang.IllegalArgumentException if the specified provider is null.
 *
 * @see java.security.Provider
 *
 * @since 1.4
 * @apiSince 1
 */

public static java.security.KeyStore getInstance(java.lang.String type, java.security.Provider provider) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Returns the default keystore type as specified by the
 * {@code keystore.type} security property, or the string
 * {@literal "jks"} (acronym for {@literal "Java keystore"})
 * if no such property exists.
 *
 * <p>The default keystore type can be used by applications that do not
 * want to use a hard-coded keystore type when calling one of the
 * {@code getInstance} methods, and want to provide a default keystore
 * type in case a user does not specify its own.
 *
 * <p>The default keystore type can be changed by setting the value of the
 * {@code keystore.type} security property to the desired keystore type.
 *
 * @return the default keystore type as specified by the
 * {@code keystore.type} security property, or the string {@literal "jks"}
 * if no such property exists.
 * @see java.security.Security security properties
 * @apiSince 1
 */

public static final java.lang.String getDefaultType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider of this keystore.
 *
 * @return the provider of this keystore.
 * @apiSince 1
 */

public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of this keystore.
 *
 * @return the type of this keystore.
 * @apiSince 1
 */

public final java.lang.String getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the key associated with the given alias, using the given
 * password to recover it.  The key must have been associated with
 * the alias by a call to {@code setKeyEntry},
 * or by a call to {@code setEntry} with a
 * {@code PrivateKeyEntry} or {@code SecretKeyEntry}.
 *
 * @param alias the alias name
 * @param password the password for recovering the key
 *
 * @return the requested key, or null if the given alias does not exist
 * or does not identify a key-related entry.
 *
 * @exception java.security.KeyStoreException if the keystore has not been initialized
 * (loaded).
 * @exception java.security.NoSuchAlgorithmException if the algorithm for recovering the
 * key cannot be found
 * @exception java.security.UnrecoverableKeyException if the key cannot be recovered
 * (e.g., the given password is wrong).
 * @apiSince 1
 */

public final java.security.Key getKey(java.lang.String alias, char[] password) throws java.security.KeyStoreException, java.security.NoSuchAlgorithmException, java.security.UnrecoverableKeyException { throw new RuntimeException("Stub!"); }

/**
 * Returns the certificate chain associated with the given alias.
 * The certificate chain must have been associated with the alias
 * by a call to {@code setKeyEntry},
 * or by a call to {@code setEntry} with a
 * {@code PrivateKeyEntry}.
 *
 * @param alias the alias name
 *
 * @return the certificate chain (ordered with the user's certificate first
 * followed by zero or more certificate authorities), or null if the given alias
 * does not exist or does not contain a certificate chain
 *
 * @exception java.security.KeyStoreException if the keystore has not been initialized
 * (loaded).
 * @apiSince 1
 */

public final java.security.cert.Certificate[] getCertificateChain(java.lang.String alias) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Returns the certificate associated with the given alias.
 *
 * <p> If the given alias name identifies an entry
 * created by a call to {@code setCertificateEntry},
 * or created by a call to {@code setEntry} with a
 * {@code TrustedCertificateEntry},
 * then the trusted certificate contained in that entry is returned.
 *
 * <p> If the given alias name identifies an entry
 * created by a call to {@code setKeyEntry},
 * or created by a call to {@code setEntry} with a
 * {@code PrivateKeyEntry},
 * then the first element of the certificate chain in that entry
 * is returned.
 *
 * @param alias the alias name
 *
 * @return the certificate, or null if the given alias does not exist or
 * does not contain a certificate.
 *
 * @exception java.security.KeyStoreException if the keystore has not been initialized
 * (loaded).
 * @apiSince 1
 */

public final java.security.cert.Certificate getCertificate(java.lang.String alias) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Returns the creation date of the entry identified by the given alias.
 *
 * @param alias the alias name
 *
 * @return the creation date of this entry, or null if the given alias does
 * not exist
 *
 * @exception java.security.KeyStoreException if the keystore has not been initialized
 * (loaded).
 * @apiSince 1
 */

public final java.util.Date getCreationDate(java.lang.String alias) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Assigns the given key to the given alias, protecting it with the given
 * password.
 *
 * <p>If the given key is of type {@code java.security.PrivateKey},
 * it must be accompanied by a certificate chain certifying the
 * corresponding public key.
 *
 * <p>If the given alias already exists, the keystore information
 * associated with it is overridden by the given key (and possibly
 * certificate chain).
 *
 * @param alias the alias name
 * @param key the key to be associated with the alias
 * @param password the password to protect the key
 * @param chain the certificate chain for the corresponding public
 * key (only required if the given key is of type
 * {@code java.security.PrivateKey}).
 *
 * @exception java.security.KeyStoreException if the keystore has not been initialized
 * (loaded), the given key cannot be protected, or this operation fails
 * for some other reason
 * @apiSince 1
 */

public final void setKeyEntry(java.lang.String alias, java.security.Key key, char[] password, java.security.cert.Certificate[] chain) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Assigns the given key (that has already been protected) to the given
 * alias.
 *
 * <p>If the protected key is of type
 * {@code java.security.PrivateKey}, it must be accompanied by a
 * certificate chain certifying the corresponding public key. If the
 * underlying keystore implementation is of type {@code jks},
 * {@code key} must be encoded as an
 * {@code EncryptedPrivateKeyInfo} as defined in the PKCS #8 standard.
 *
 * <p>If the given alias already exists, the keystore information
 * associated with it is overridden by the given key (and possibly
 * certificate chain).
 *
 * @param alias the alias name
 * @param key the key (in protected format) to be associated with the alias
 * @param chain the certificate chain for the corresponding public
 *          key (only useful if the protected key is of type
 *          {@code java.security.PrivateKey}).
 *
 * @exception java.security.KeyStoreException if the keystore has not been initialized
 * (loaded), or if this operation fails for some other reason.
 * @apiSince 1
 */

public final void setKeyEntry(java.lang.String alias, byte[] key, java.security.cert.Certificate[] chain) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Assigns the given trusted certificate to the given alias.
 *
 * <p> If the given alias identifies an existing entry
 * created by a call to {@code setCertificateEntry},
 * or created by a call to {@code setEntry} with a
 * {@code TrustedCertificateEntry},
 * the trusted certificate in the existing entry
 * is overridden by the given certificate.
 *
 * @param alias the alias name
 * @param cert the certificate
 *
 * @exception java.security.KeyStoreException if the keystore has not been initialized,
 * or the given alias already exists and does not identify an
 * entry containing a trusted certificate,
 * or this operation fails for some other reason.
 * @apiSince 1
 */

public final void setCertificateEntry(java.lang.String alias, java.security.cert.Certificate cert) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Deletes the entry identified by the given alias from this keystore.
 *
 * @param alias the alias name
 *
 * @exception java.security.KeyStoreException if the keystore has not been initialized,
 * or if the entry cannot be removed.
 * @apiSince 1
 */

public final void deleteEntry(java.lang.String alias) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Lists all the alias names of this keystore.
 *
 * @return enumeration of the alias names
 *
 * @exception java.security.KeyStoreException if the keystore has not been initialized
 * (loaded).
 * @apiSince 1
 */

public final java.util.Enumeration<java.lang.String> aliases() throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Checks if the given alias exists in this keystore.
 *
 * @param alias the alias name
 *
 * @return true if the alias exists, false otherwise
 *
 * @exception java.security.KeyStoreException if the keystore has not been initialized
 * (loaded).
 * @apiSince 1
 */

public final boolean containsAlias(java.lang.String alias) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the number of entries in this keystore.
 *
 * @return the number of entries in this keystore
 *
 * @exception java.security.KeyStoreException if the keystore has not been initialized
 * (loaded).
 * @apiSince 1
 */

public final int size() throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the entry identified by the given alias
 * was created by a call to {@code setKeyEntry},
 * or created by a call to {@code setEntry} with a
 * {@code PrivateKeyEntry} or a {@code SecretKeyEntry}.
 *
 * @param alias the alias for the keystore entry to be checked
 *
 * @return true if the entry identified by the given alias is a
 * key-related entry, false otherwise.
 *
 * @exception java.security.KeyStoreException if the keystore has not been initialized
 * (loaded).
 * @apiSince 1
 */

public final boolean isKeyEntry(java.lang.String alias) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the entry identified by the given alias
 * was created by a call to {@code setCertificateEntry},
 * or created by a call to {@code setEntry} with a
 * {@code TrustedCertificateEntry}.
 *
 * @param alias the alias for the keystore entry to be checked
 *
 * @return true if the entry identified by the given alias contains a
 * trusted certificate, false otherwise.
 *
 * @exception java.security.KeyStoreException if the keystore has not been initialized
 * (loaded).
 * @apiSince 1
 */

public final boolean isCertificateEntry(java.lang.String alias) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Returns the (alias) name of the first keystore entry whose certificate
 * matches the given certificate.
 *
 * <p> This method attempts to match the given certificate with each
 * keystore entry. If the entry being considered was
 * created by a call to {@code setCertificateEntry},
 * or created by a call to {@code setEntry} with a
 * {@code TrustedCertificateEntry},
 * then the given certificate is compared to that entry's certificate.
 *
 * <p> If the entry being considered was
 * created by a call to {@code setKeyEntry},
 * or created by a call to {@code setEntry} with a
 * {@code PrivateKeyEntry},
 * then the given certificate is compared to the first
 * element of that entry's certificate chain.
 *
 * @param cert the certificate to match with.
 *
 * @return the alias name of the first entry with a matching certificate,
 * or null if no such entry exists in this keystore.
 *
 * @exception java.security.KeyStoreException if the keystore has not been initialized
 * (loaded).
 * @apiSince 1
 */

public final java.lang.String getCertificateAlias(java.security.cert.Certificate cert) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Stores this keystore to the given output stream, and protects its
 * integrity with the given password.
 *
 * @param stream the output stream to which this keystore is written.
 * @param password the password to generate the keystore integrity check
 *
 * @exception java.security.KeyStoreException if the keystore has not been initialized
 * (loaded).
 * @exception java.io.IOException if there was an I/O problem with data
 * @exception java.security.NoSuchAlgorithmException if the appropriate data integrity
 * algorithm could not be found
 * @exception java.security.cert.CertificateException if any of the certificates included in
 * the keystore data could not be stored
 * @apiSince 1
 */

public final void store(java.io.OutputStream stream, char[] password) throws java.security.cert.CertificateException, java.io.IOException, java.security.KeyStoreException, java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Stores this keystore using the given {@code LoadStoreParameter}.
 *
 * @param param the {@code LoadStoreParameter}
 *          that specifies how to store the keystore,
 *          which may be {@code null}
 *
 * @exception java.lang.IllegalArgumentException if the given
 *          {@code LoadStoreParameter}
 *          input is not recognized
 * @exception java.security.KeyStoreException if the keystore has not been initialized
 *          (loaded)
 * @exception java.io.IOException if there was an I/O problem with data
 * @exception java.security.NoSuchAlgorithmException if the appropriate data integrity
 *          algorithm could not be found
 * @exception java.security.cert.CertificateException if any of the certificates included in
 *          the keystore data could not be stored
 *
 * @since 1.5
 * @apiSince 1
 */

public final void store(java.security.KeyStore.LoadStoreParameter param) throws java.security.cert.CertificateException, java.io.IOException, java.security.KeyStoreException, java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Loads this KeyStore from the given input stream.
 *
 * <p>A password may be given to unlock the keystore
 * (e.g. the keystore resides on a hardware token device),
 * or to check the integrity of the keystore data.
 * If a password is not given for integrity checking,
 * then integrity checking is not performed.
 *
 * <p>In order to create an empty keystore, or if the keystore cannot
 * be initialized from a stream, pass {@code null}
 * as the {@code stream} argument.
 *
 * <p> Note that if this keystore has already been loaded, it is
 * reinitialized and loaded again from the given input stream.
 *
 * @param stream the input stream from which the keystore is loaded,
 * or {@code null}
 * @param password the password used to check the integrity of
 * the keystore, the password used to unlock the keystore,
 * or {@code null}
 *
 * @exception java.io.IOException if there is an I/O or format problem with the
 * keystore data, if a password is required but not given,
 * or if the given password was incorrect. If the error is due to a
 * wrong password, the {@link java.lang.Throwable#getCause Throwable#getCause} of the
 * {@code IOException} should be an
 * {@code UnrecoverableKeyException}
 * @exception java.security.NoSuchAlgorithmException if the algorithm used to check
 * the integrity of the keystore cannot be found
 * @exception java.security.cert.CertificateException if any of the certificates in the
 * keystore could not be loaded
 * @apiSince 1
 */

public final void load(java.io.InputStream stream, char[] password) throws java.security.cert.CertificateException, java.io.IOException, java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Loads this keystore using the given {@code LoadStoreParameter}.
 *
 * <p> Note that if this KeyStore has already been loaded, it is
 * reinitialized and loaded again from the given parameter.
 *
 * @param param the {@code LoadStoreParameter}
 *          that specifies how to load the keystore,
 *          which may be {@code null}
 *
 * @exception java.lang.IllegalArgumentException if the given
 *          {@code LoadStoreParameter}
 *          input is not recognized
 * @exception java.io.IOException if there is an I/O or format problem with the
 *          keystore data. If the error is due to an incorrect
 *         {@code ProtectionParameter} (e.g. wrong password)
 *         the {@link java.lang.Throwable#getCause Throwable#getCause} of the
 *         {@code IOException} should be an
 *         {@code UnrecoverableKeyException}
 * @exception java.security.NoSuchAlgorithmException if the algorithm used to check
 *          the integrity of the keystore cannot be found
 * @exception java.security.cert.CertificateException if any of the certificates in the
 *          keystore could not be loaded
 *
 * @since 1.5
 * @apiSince 1
 */

public final void load(java.security.KeyStore.LoadStoreParameter param) throws java.security.cert.CertificateException, java.io.IOException, java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Gets a keystore {@code Entry} for the specified alias
 * with the specified protection parameter.
 *
 * @param alias get the keystore {@code Entry} for this alias
 * @param protParam the {@code ProtectionParameter}
 *          used to protect the {@code Entry},
 *          which may be {@code null}
 *
 * @return the keystore {@code Entry} for the specified alias,
 *          or {@code null} if there is no such entry
 *
 * @exception java.lang.NullPointerException if
 *          {@code alias} is {@code null}
 * @exception java.security.NoSuchAlgorithmException if the algorithm for recovering the
 *          entry cannot be found
 * @exception java.security.UnrecoverableEntryException if the specified
 *          {@code protParam} were insufficient or invalid
 * @exception java.security.UnrecoverableKeyException if the entry is a
 *          {@code PrivateKeyEntry} or {@code SecretKeyEntry}
 *          and the specified {@code protParam} does not contain
 *          the information needed to recover the key (e.g. wrong password)
 * @exception java.security.KeyStoreException if the keystore has not been initialized
 *          (loaded).
 * @see #setEntry(String, KeyStore.Entry, KeyStore.ProtectionParameter)
 *
 * @since 1.5
 * @apiSince 1
 */

public final java.security.KeyStore.Entry getEntry(java.lang.String alias, java.security.KeyStore.ProtectionParameter protParam) throws java.security.KeyStoreException, java.security.NoSuchAlgorithmException, java.security.UnrecoverableEntryException { throw new RuntimeException("Stub!"); }

/**
 * Saves a keystore {@code Entry} under the specified alias.
 * The protection parameter is used to protect the
 * {@code Entry}.
 *
 * <p> If an entry already exists for the specified alias,
 * it is overridden.
 *
 * @param alias save the keystore {@code Entry} under this alias
 * @param entry the {@code Entry} to save
 * @param protParam the {@code ProtectionParameter}
 *          used to protect the {@code Entry},
 *          which may be {@code null}
 *
 * @exception java.lang.NullPointerException if
 *          {@code alias} or {@code entry}
 *          is {@code null}
 * @exception java.security.KeyStoreException if the keystore has not been initialized
 *          (loaded), or if this operation fails for some other reason
 *
 * @see #getEntry(String, KeyStore.ProtectionParameter)
 *
 * @since 1.5
 * @apiSince 1
 */

public final void setEntry(java.lang.String alias, java.security.KeyStore.Entry entry, java.security.KeyStore.ProtectionParameter protParam) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Determines if the keystore {@code Entry} for the specified
 * {@code alias} is an instance or subclass of the specified
 * {@code entryClass}.
 *
 * @param alias the alias name
 * @param entryClass the entry class
 *
 * @return true if the keystore {@code Entry} for the specified
 *          {@code alias} is an instance or subclass of the
 *          specified {@code entryClass}, false otherwise
 *
 * @exception java.lang.NullPointerException if
 *          {@code alias} or {@code entryClass}
 *          is {@code null}
 * @exception java.security.KeyStoreException if the keystore has not been
 *          initialized (loaded)
 *
 * @since 1.5
 * @apiSince 1
 */

public final boolean entryInstanceOf(java.lang.String alias, java.lang.Class<? extends java.security.KeyStore.Entry> entryClass) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }
/**
 * A description of a to-be-instantiated KeyStore object.
 *
 * <p>An instance of this class encapsulates the information needed to
 * instantiate and initialize a KeyStore object. That process is
 * triggered when the {@linkplain #getKeyStore} method is called.
 *
 * <p>This makes it possible to decouple configuration from KeyStore
 * object creation and e.g. delay a password prompt until it is
 * needed.
 *
 * @see java.security.KeyStore
 * @see javax.net.ssl.KeyStoreBuilderParameters
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Builder {

/**
 * Construct a new Builder.
 * @apiSince 1
 */

protected Builder() { throw new RuntimeException("Stub!"); }

/**
 * Returns the KeyStore described by this object.
 *
 * @return the {@code KeyStore} described by this object
 * @exception java.security.KeyStoreException if an error occurred during the
 *   operation, for example if the KeyStore could not be
 *   instantiated or loaded
 * @apiSince 1
 */

public abstract java.security.KeyStore getKeyStore() throws java.security.KeyStoreException;

/**
 * Returns the ProtectionParameters that should be used to obtain
 * the {@link java.security.KeyStore.Entry KeyStore.Entry} with the given alias.
 * The {@code getKeyStore} method must be invoked before this
 * method may be called.
 *
 * @return the ProtectionParameters that should be used to obtain
 *   the {@link java.security.KeyStore.Entry KeyStore.Entry} with the given alias.
 * @param alias the alias of the KeyStore entry
 * @throws java.lang.NullPointerException if alias is null
 * @throws java.security.KeyStoreException if an error occurred during the
 *   operation
 * @throws java.lang.IllegalStateException if the getKeyStore method has
 *   not been invoked prior to calling this method
 * @apiSince 1
 */

public abstract java.security.KeyStore.ProtectionParameter getProtectionParameter(java.lang.String alias) throws java.security.KeyStoreException;

/**
 * Returns a new Builder that encapsulates the given KeyStore.
 * The {@linkplain #getKeyStore} method of the returned object
 * will return {@code keyStore}, the {@linkplain
 * #getProtectionParameter getProtectionParameter()} method will
 * return {@code protectionParameters}.
 *
 * <p> This is useful if an existing KeyStore object needs to be
 * used with Builder-based APIs.
 *
 * @return a new Builder object
 * @param keyStore the KeyStore to be encapsulated
 * @param protectionParameter the ProtectionParameter used to
 *   protect the KeyStore entries
 * @throws java.lang.NullPointerException if keyStore or
 *   protectionParameters is null
 * @throws java.lang.IllegalArgumentException if the keyStore has not been
 *   initialized
 * @apiSince 1
 */

public static java.security.KeyStore.Builder newInstance(java.security.KeyStore keyStore, java.security.KeyStore.ProtectionParameter protectionParameter) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new Builder object.
 *
 * <p>The first call to the {@link #getKeyStore} method on the returned
 * builder will create a KeyStore of type {@code type} and call
 * its {@link java.security.KeyStore#load KeyStore#load} method.
 * The {@code inputStream} argument is constructed from
 * {@code file}.
 * If {@code protection} is a
 * {@code PasswordProtection}, the password is obtained by
 * calling the {@code getPassword} method.
 * Otherwise, if {@code protection} is a
 * {@code CallbackHandlerProtection}, the password is obtained
 * by invoking the CallbackHandler.
 *
 * <p>Subsequent calls to {@link #getKeyStore} return the same object
 * as the initial call. If the initial call to failed with a
 * KeyStoreException, subsequent calls also throw a
 * KeyStoreException.
 *
 * <p>The KeyStore is instantiated from {@code provider} if
 * non-null. Otherwise, all installed providers are searched.
 *
 * <p>Calls to {@link #getProtectionParameter getProtectionParameter()}
 * will return a {@link java.security.KeyStore.PasswordProtection KeyStore.PasswordProtection}
 * object encapsulating the password that was used to invoke the
 * {@code load} method.
 *
 * <p><em>Note</em> that the {@link #getKeyStore} method is executed
 * within the {@link java.security.AccessControlContext AccessControlContext} of the code invoking this
 * method.
 *
 * @return a new Builder object
 * @param type the type of KeyStore to be constructed
 * @param provider the provider from which the KeyStore is to
 *   be instantiated (or null)
 * @param file the File that contains the KeyStore data
 * @param protection the ProtectionParameter securing the KeyStore data
 * @throws java.lang.NullPointerException if type, file or protection is null
 * @throws java.lang.IllegalArgumentException if protection is not an instance
 *   of either PasswordProtection or CallbackHandlerProtection; or
 *   if file does not exist or does not refer to a normal file
 * @apiSince 1
 */

public static java.security.KeyStore.Builder newInstance(java.lang.String type, java.security.Provider provider, java.io.File file, java.security.KeyStore.ProtectionParameter protection) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new Builder object.
 *
 * <p>Each call to the {@link #getKeyStore} method on the returned
 * builder will return a new KeyStore object of type {@code type}.
 * Its {@link java.security.KeyStore#load(java.security.KeyStore.LoadStoreParameter) KeyStore#load(KeyStore.LoadStoreParameter)}
 * method is invoked using a
 * {@code LoadStoreParameter} that encapsulates
 * {@code protection}.
 *
 * <p>The KeyStore is instantiated from {@code provider} if
 * non-null. Otherwise, all installed providers are searched.
 *
 * <p>Calls to {@link #getProtectionParameter getProtectionParameter()}
 * will return {@code protection}.
 *
 * <p><em>Note</em> that the {@link #getKeyStore} method is executed
 * within the {@link java.security.AccessControlContext AccessControlContext} of the code invoking this
 * method.
 *
 * @return a new Builder object
 * @param type the type of KeyStore to be constructed
 * @param provider the provider from which the KeyStore is to
 *   be instantiated (or null)
 * @param protection the ProtectionParameter securing the Keystore
 * @throws java.lang.NullPointerException if type or protection is null
 * @apiSince 1
 */

public static java.security.KeyStore.Builder newInstance(java.lang.String type, java.security.Provider provider, java.security.KeyStore.ProtectionParameter protection) { throw new RuntimeException("Stub!"); }
}

/**
 * A ProtectionParameter encapsulating a CallbackHandler.
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class CallbackHandlerProtection implements java.security.KeyStore.ProtectionParameter {

/**
 * Constructs a new CallbackHandlerProtection from a
 * CallbackHandler.
 *
 * @param handler the CallbackHandler
 * @exception java.lang.NullPointerException if handler is null
 * @apiSince 1
 */

public CallbackHandlerProtection(javax.security.auth.callback.CallbackHandler handler) { throw new RuntimeException("Stub!"); }

/**
 * Returns the CallbackHandler.
 *
 * @return the CallbackHandler.
 * @apiSince 1
 */

public javax.security.auth.callback.CallbackHandler getCallbackHandler() { throw new RuntimeException("Stub!"); }
}

/**
 * A marker interface for {@code KeyStore} entry types.
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Entry {

/**
 * Retrieves the attributes associated with an entry.
 * <p>
 * The default implementation returns an empty {@code Set}.
 *
 * @return an unmodifiable {@code Set} of attributes, possibly empty
 *
 * @since 1.8
 * @apiSince 26
 */

public default java.util.Set<java.security.KeyStore.Entry.Attribute> getAttributes() { throw new RuntimeException("Stub!"); }
/**
 * An attribute associated with a keystore entry.
 * It comprises a name and one or more values.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Attribute {

/**
 * Returns the attribute's name.
 *
 * @return the attribute name
 * @apiSince 26
 */

public java.lang.String getName();

/**
 * Returns the attribute's value.
 * Multi-valued attributes encode their values as a single string.
 *
 * @return the attribute value
 * @apiSince 26
 */

public java.lang.String getValue();
}

}

/**
 * A marker interface for {@code KeyStore}
 * {@link #load(java.security.KeyStore.LoadStoreParameter) load}
 * and
 * {@link #store(java.security.KeyStore.LoadStoreParameter) store}
 * parameters.
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface LoadStoreParameter {

/**
 * Gets the parameter used to protect keystore data.
 *
 * @return the parameter used to protect keystore data, or null
 * @apiSince 1
 */

public java.security.KeyStore.ProtectionParameter getProtectionParameter();
}

/**
 * A password-based implementation of {@code ProtectionParameter}.
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class PasswordProtection implements java.security.KeyStore.ProtectionParameter, javax.security.auth.Destroyable {

/**
 * Creates a password parameter.
 *
 * <p> The specified {@code password} is cloned before it is stored
 * in the new {@code PasswordProtection} object.
 *
 * @param password the password, which may be {@code null}
 * @apiSince 1
 */

public PasswordProtection(char[] password) { throw new RuntimeException("Stub!"); }

/**
 * Creates a password parameter and specifies the protection algorithm
 * and associated parameters to use when encrypting a keystore entry.
 * <p>
 * The specified {@code password} is cloned before it is stored in the
 * new {@code PasswordProtection} object.
 *
 * @param password the password, which may be {@code null}
 * @param protectionAlgorithm the encryption algorithm name, for
 *     example, {@code PBEWithHmacSHA256AndAES_256}.
 *     See the Cipher section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Cipher">
 * Java Cryptography Architecture Standard Algorithm Name
 * Documentation</a>
 *     for information about standard encryption algorithm names.
 * @param protectionParameters the encryption algorithm parameter
 *     specification, which may be {@code null}
 * @exception java.lang.NullPointerException if {@code protectionAlgorithm} is
 *     {@code null}
 *
 * @since 1.8
 * @apiSince 26
 */

public PasswordProtection(char[] password, java.lang.String protectionAlgorithm, java.security.spec.AlgorithmParameterSpec protectionParameters) { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of the protection algorithm.
 * If none was set then the keystore provider will use its default
 * protection algorithm. The name of the default protection algorithm
 * for a given keystore type is set using the
 * {@code 'keystore.<type>.keyProtectionAlgorithm'} security property.
 * For example, the
 * {@code keystore.PKCS12.keyProtectionAlgorithm} property stores the
 * name of the default key protection algorithm used for PKCS12
 * keystores. If the security property is not set, an
 * implementation-specific algorithm will be used.
 *
 * @return the algorithm name, or {@code null} if none was set
 *
 * @since 1.8
 * @apiSince 26
 */

public java.lang.String getProtectionAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Gets the parameters supplied for the protection algorithm.
 *
 * @return the algorithm parameter specification, or {@code  null},
 *     if none was set
 *
 * @since 1.8
 * @apiSince 26
 */

public java.security.spec.AlgorithmParameterSpec getProtectionParameters() { throw new RuntimeException("Stub!"); }

/**
 * Gets the password.
 *
 * <p>Note that this method returns a reference to the password.
 * If a clone of the array is created it is the caller's
 * responsibility to zero out the password information
 * after it is no longer needed.
 *
 * @see #destroy()
 * @return the password, which may be {@code null}
 * @exception java.lang.IllegalStateException if the password has
 *              been cleared (destroyed)
 * @apiSince 1
 */

public synchronized char[] getPassword() { throw new RuntimeException("Stub!"); }

/**
 * Clears the password.
 *
 * @exception javax.security.auth.DestroyFailedException if this method was unable
 *      to clear the password
 * @apiSince 1
 */

public synchronized void destroy() throws javax.security.auth.DestroyFailedException { throw new RuntimeException("Stub!"); }

/**
 * Determines if password has been cleared.
 *
 * @return true if the password has been cleared, false otherwise
 * @apiSince 1
 */

public synchronized boolean isDestroyed() { throw new RuntimeException("Stub!"); }
}

/**
 * A {@code KeyStore} entry that holds a {@code PrivateKey}
 * and corresponding certificate chain.
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class PrivateKeyEntry implements java.security.KeyStore.Entry {

/**
 * Constructs a {@code PrivateKeyEntry} with a
 * {@code PrivateKey} and corresponding certificate chain.
 *
 * <p> The specified {@code chain} is cloned before it is stored
 * in the new {@code PrivateKeyEntry} object.
 *
 * @param privateKey the {@code PrivateKey}
 * @param chain an array of {@code Certificate}s
 *      representing the certificate chain.
 *      The chain must be ordered and contain a
 *      {@code Certificate} at index 0
 *      corresponding to the private key.
 *
 * @exception java.lang.NullPointerException if
 *      {@code privateKey} or {@code chain}
 *      is {@code null}
 * @exception java.lang.IllegalArgumentException if the specified chain has a
 *      length of 0, if the specified chain does not contain
 *      {@code Certificate}s of the same type,
 *      or if the {@code PrivateKey} algorithm
 *      does not match the algorithm of the {@code PublicKey}
 *      in the end entity {@code Certificate} (at index 0)
 * @apiSince 1
 */

public PrivateKeyEntry(java.security.PrivateKey privateKey, java.security.cert.Certificate[] chain) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@code PrivateKeyEntry} with a {@code PrivateKey} and
 * corresponding certificate chain and associated entry attributes.
 *
 * <p> The specified {@code chain} and {@code attributes} are cloned
 * before they are stored in the new {@code PrivateKeyEntry} object.
 *
 * @param privateKey the {@code PrivateKey}
 * @param chain an array of {@code Certificate}s
 *      representing the certificate chain.
 *      The chain must be ordered and contain a
 *      {@code Certificate} at index 0
 *      corresponding to the private key.
 * @param attributes the attributes
 *
 * @exception java.lang.NullPointerException if {@code privateKey}, {@code chain}
 *      or {@code attributes} is {@code null}
 * @exception java.lang.IllegalArgumentException if the specified chain has a
 *      length of 0, if the specified chain does not contain
 *      {@code Certificate}s of the same type,
 *      or if the {@code PrivateKey} algorithm
 *      does not match the algorithm of the {@code PublicKey}
 *      in the end entity {@code Certificate} (at index 0)
 *
 * @since 1.8
 * @apiSince 26
 */

public PrivateKeyEntry(java.security.PrivateKey privateKey, java.security.cert.Certificate[] chain, java.util.Set<java.security.KeyStore.Entry.Attribute> attributes) { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@code PrivateKey} from this entry.
 *
 * @return the {@code PrivateKey} from this entry
 * @apiSince 1
 */

public java.security.PrivateKey getPrivateKey() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@code Certificate} chain from this entry.
 *
 * <p> The stored chain is cloned before being returned.
 *
 * @return an array of {@code Certificate}s corresponding
 *      to the certificate chain for the public key.
 *      If the certificates are of type X.509,
 *      the runtime type of the returned array is
 *      {@code X509Certificate[]}.
 * @apiSince 1
 */

public java.security.cert.Certificate[] getCertificateChain() { throw new RuntimeException("Stub!"); }

/**
 * Gets the end entity {@code Certificate}
 * from the certificate chain in this entry.
 *
 * @return the end entity {@code Certificate} (at index 0)
 *      from the certificate chain in this entry.
 *      If the certificate is of type X.509,
 *      the runtime type of the returned certificate is
 *      {@code X509Certificate}.
 * @apiSince 1
 */

public java.security.cert.Certificate getCertificate() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the attributes associated with an entry.
 * <p>
 *
 * @return an unmodifiable {@code Set} of attributes, possibly empty
 *
 * @since 1.8
 * @apiSince 26
 */

public java.util.Set<java.security.KeyStore.Entry.Attribute> getAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this PrivateKeyEntry.
 * @return a string representation of this PrivateKeyEntry.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

/**
 * A marker interface for keystore protection parameters.
 *
 * <p> The information stored in a {@code ProtectionParameter}
 * object protects the contents of a keystore.
 * For example, protection parameters may be used to check
 * the integrity of keystore data, or to protect the
 * confidentiality of sensitive keystore data
 * (such as a {@code PrivateKey}).
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ProtectionParameter {
}

/**
 * A {@code KeyStore} entry that holds a {@code SecretKey}.
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class SecretKeyEntry implements java.security.KeyStore.Entry {

/**
 * Constructs a {@code SecretKeyEntry} with a
 * {@code SecretKey}.
 *
 * @param secretKey the {@code SecretKey}
 *
 * @exception java.lang.NullPointerException if {@code secretKey}
 *      is {@code null}
 * @apiSince 1
 */

public SecretKeyEntry(javax.crypto.SecretKey secretKey) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@code SecretKeyEntry} with a {@code SecretKey} and
 * associated entry attributes.
 *
 * <p> The specified {@code attributes} is cloned before it is stored
 * in the new {@code SecretKeyEntry} object.
 *
 * @param secretKey the {@code SecretKey}
 * @param attributes the attributes
 *
 * @exception java.lang.NullPointerException if {@code secretKey} or
 *     {@code attributes} is {@code null}
 *
 * @since 1.8
 * @apiSince 26
 */

public SecretKeyEntry(javax.crypto.SecretKey secretKey, java.util.Set<java.security.KeyStore.Entry.Attribute> attributes) { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@code SecretKey} from this entry.
 *
 * @return the {@code SecretKey} from this entry
 * @apiSince 1
 */

public javax.crypto.SecretKey getSecretKey() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the attributes associated with an entry.
 * <p>
 *
 * @return an unmodifiable {@code Set} of attributes, possibly empty
 *
 * @since 1.8
 * @apiSince 26
 */

public java.util.Set<java.security.KeyStore.Entry.Attribute> getAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this SecretKeyEntry.
 * @return a string representation of this SecretKeyEntry.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

/**
 * A {@code KeyStore} entry that holds a trusted
 * {@code Certificate}.
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class TrustedCertificateEntry implements java.security.KeyStore.Entry {

/**
 * Constructs a {@code TrustedCertificateEntry} with a
 * trusted {@code Certificate}.
 *
 * @param trustedCert the trusted {@code Certificate}
 *
 * @exception java.lang.NullPointerException if
 *      {@code trustedCert} is {@code null}
 * @apiSince 1
 */

public TrustedCertificateEntry(java.security.cert.Certificate trustedCert) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@code TrustedCertificateEntry} with a
 * trusted {@code Certificate} and associated entry attributes.
 *
 * <p> The specified {@code attributes} is cloned before it is stored
 * in the new {@code TrustedCertificateEntry} object.
 *
 * @param trustedCert the trusted {@code Certificate}
 * @param attributes the attributes
 *
 * @exception java.lang.NullPointerException if {@code trustedCert} or
 *     {@code attributes} is {@code null}
 *
 * @since 1.8
 * @apiSince 26
 */

public TrustedCertificateEntry(java.security.cert.Certificate trustedCert, java.util.Set<java.security.KeyStore.Entry.Attribute> attributes) { throw new RuntimeException("Stub!"); }

/**
 * Gets the trusted {@code Certficate} from this entry.
 *
 * @return the trusted {@code Certificate} from this entry
 * @apiSince 1
 */

public java.security.cert.Certificate getTrustedCertificate() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the attributes associated with an entry.
 * <p>
 *
 * @return an unmodifiable {@code Set} of attributes, possibly empty
 *
 * @since 1.8
 * @apiSince 26
 */

public java.util.Set<java.security.KeyStore.Entry.Attribute> getAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this TrustedCertificateEntry.
 * @return a string representation of this TrustedCertificateEntry.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

}

