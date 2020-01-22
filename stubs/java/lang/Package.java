/*
 * Copyright (C) 2014 The Android Open Source Project
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



package java.lang;


/**
 * {@code Package} objects contain version information
 * about the implementation and specification of a Java package.
 * This versioning information is retrieved and made available
 * by the {@link java.lang.ClassLoader ClassLoader} instance that
 * loaded the class(es).  Typically, it is stored in the manifest that is
 * distributed with the classes.
 *
 * <p>The set of classes that make up the package may implement a
 * particular specification and if so the specification title, version number,
 * and vendor strings identify that specification.
 * An application can ask if the package is
 * compatible with a particular version, see the {@link
 * #isCompatibleWith isCompatibleWith}
 * method for details.
 *
 * <p>Specification version numbers use a syntax that consists of nonnegative
 * decimal integers separated by periods ".", for example "2.0" or
 * "1.2.3.4.5.6.7".  This allows an extensible number to be used to represent
 * major, minor, micro, etc. versions.  The version specification is described
 * by the following formal grammar:
 * <blockquote>
 * <dl>
 * <dt><i>SpecificationVersion:</i>
 * <dd><i>Digits RefinedVersion<sub>opt</sub></i>
 
 * <dt><i>RefinedVersion:</i>
 * <dd>{@code .} <i>Digits</i>
 * <dd>{@code .} <i>Digits RefinedVersion</i>
 *
 * <dt><i>Digits:</i>
 * <dd><i>Digit</i>
 * <dd><i>Digits</i>
 *
 * <dt><i>Digit:</i>
 * <dd>any character for which {@link java.lang.Character#isDigit Character#isDigit} returns {@code true},
 * e.g. 0, 1, 2, ...
 * </dl>
 * </blockquote>
 *
 * <p>The implementation title, version, and vendor strings identify an
 * implementation and are made available conveniently to enable accurate
 * reporting of the packages involved when a problem occurs. The contents
 * all three implementation strings are vendor specific. The
 * implementation version strings have no specified syntax and should
 * only be compared for equality with desired version identifiers.
 *
 * <p>Within each {@code ClassLoader} instance all classes from the same
 * java package have the same Package object.  The static methods allow a package
 * to be found by name or the set of all packages known to the current class
 * loader to be found.
 *
 * @see java.lang.ClassLoader#definePackage
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Package implements java.lang.reflect.AnnotatedElement {

Package() { throw new RuntimeException("Stub!"); }

/**
 * Return the name of this package.
 *
 * @return  The fully-qualified name of this package as defined in section 6.5.3 of
 *          <cite>The Java&trade; Language Specification</cite>,
 *          for example, {@code java.lang}
 * @apiSince 1
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Return the title of the specification that this package implements.
 * @return the specification title, null is returned if it is not known.
 * @apiSince 1
 */

public java.lang.String getSpecificationTitle() { throw new RuntimeException("Stub!"); }

/**
 * Returns the version number of the specification
 * that this package implements.
 * This version string must be a sequence of nonnegative decimal
 * integers separated by "."'s and may have leading zeros.
 * When version strings are compared the most significant
 * numbers are compared.
 * @return the specification version, null is returned if it is not known.
 * @apiSince 1
 */

public java.lang.String getSpecificationVersion() { throw new RuntimeException("Stub!"); }

/**
 * Return the name of the organization, vendor,
 * or company that owns and maintains the specification
 * of the classes that implement this package.
 * @return the specification vendor, null is returned if it is not known.
 * @apiSince 1
 */

public java.lang.String getSpecificationVendor() { throw new RuntimeException("Stub!"); }

/**
 * Return the title of this package.
 * @return the title of the implementation, null is returned if it is not known.
 * @apiSince 1
 */

public java.lang.String getImplementationTitle() { throw new RuntimeException("Stub!"); }

/**
 * Return the version of this implementation. It consists of any string
 * assigned by the vendor of this implementation and does
 * not have any particular syntax specified or expected by the Java
 * runtime. It may be compared for equality with other
 * package version strings used for this implementation
 * by this vendor for this package.
 * @return the version of the implementation, null is returned if it is not known.
 * @apiSince 1
 */

public java.lang.String getImplementationVersion() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the organization,
 * vendor or company that provided this implementation.
 * @return the vendor that implemented this package..
 * @apiSince 1
 */

public java.lang.String getImplementationVendor() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this package is sealed.
 *
 * @return true if the package is sealed, false otherwise
 * @apiSince 1
 */

public boolean isSealed() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this package is sealed with respect to the specified
 * code source url.
 *
 * @param url the code source url
 * @return true if this package is sealed with respect to url
 * @apiSince 1
 */

public boolean isSealed(java.net.URL url) { throw new RuntimeException("Stub!"); }

/**
 * Compare this package's specification version with a
 * desired version. It returns true if
 * this packages specification version number is greater than or equal
 * to the desired version number. <p>
 *
 * Version numbers are compared by sequentially comparing corresponding
 * components of the desired and specification strings.
 * Each component is converted as a decimal integer and the values
 * compared.
 * If the specification value is greater than the desired
 * value true is returned. If the value is less false is returned.
 * If the values are equal the period is skipped and the next pair of
 * components is compared.
 *
 * @param desired the version string of the desired version.
 * @return true if this package's version number is greater
 *          than or equal to the desired version number
 *
 * @exception java.lang.NumberFormatException if the desired or current version
 *          is not of the correct dotted form.
 * @apiSince 1
 */

public boolean isCompatibleWith(java.lang.String desired) throws java.lang.NumberFormatException { throw new RuntimeException("Stub!"); }

/**
 * Find a package by name in the callers {@code ClassLoader} instance.
 * The callers {@code ClassLoader} instance is used to find the package
 * instance corresponding to the named class. If the callers
 * {@code ClassLoader} instance is null then the set of packages loaded
 * by the system {@code ClassLoader} instance is searched to find the
 * named package. <p>
 *
 * Packages have attributes for versions and specifications only if the class
 * loader created the package instance with the appropriate attributes. Typically,
 * those attributes are defined in the manifests that accompany the classes.
 *
 * @param name a package name, for example, java.lang.
 * @return the package of the requested name. It may be null if no package
 *          information is available from the archive or codebase.
 * @apiSince 1
 */

public static java.lang.Package getPackage(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Get all the packages currently known for the caller's {@code ClassLoader}
 * instance.  Those packages correspond to classes loaded via or accessible by
 * name to that {@code ClassLoader} instance.  If the caller's
 * {@code ClassLoader} instance is the bootstrap {@code ClassLoader}
 * instance, which may be represented by {@code null} in some implementations,
 * only packages corresponding to classes loaded by the bootstrap
 * {@code ClassLoader} instance will be returned.
 *
 * @return a new array of packages known to the callers {@code ClassLoader}
 * instance.  An zero length array is returned if none are known.
 * @apiSince 1
 */

public static java.lang.Package[] getPackages() { throw new RuntimeException("Stub!"); }

/**
 * Return the hash code computed from the package name.
 * @return the hash code computed from the package name.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of this Package.
 * Its value is the string "package " and the package name.
 * If the package title is defined it is appended.
 * If the package version is defined it is appended.
 * @return the string representation of the package.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.NullPointerException {@inheritDoc}
 * @since 1.5
 * @apiSince 1
 */

public <A extends java.lang.annotation.Annotation> A getAnnotation(java.lang.Class<A> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws java.lang.NullPointerException {@inheritDoc}
 * @since 1.5
 * @apiSince 1
 */

public boolean isAnnotationPresent(java.lang.Class<? extends java.lang.annotation.Annotation> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.NullPointerException {@inheritDoc}
 * @since 1.8
 * @apiSince 24
 */

public <A extends java.lang.annotation.Annotation> A[] getAnnotationsByType(java.lang.Class<A> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * @since 1.5
 * @apiSince 1
 */

public java.lang.annotation.Annotation[] getAnnotations() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.NullPointerException {@inheritDoc}
 * @since 1.8
 * @apiSince 24
 */

public <A extends java.lang.annotation.Annotation> A getDeclaredAnnotation(java.lang.Class<A> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.NullPointerException {@inheritDoc}
 * @since 1.8
 * @apiSince 24
 */

public <A extends java.lang.annotation.Annotation> A[] getDeclaredAnnotationsByType(java.lang.Class<A> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * @since 1.5
 * @apiSince 1
 */

public java.lang.annotation.Annotation[] getDeclaredAnnotations() { throw new RuntimeException("Stub!"); }
}

