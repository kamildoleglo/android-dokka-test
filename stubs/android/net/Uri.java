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


package android.net;

import android.content.Intent;
import android.os.Parcel;

/**
 * Immutable URI reference. A URI reference includes a URI and a fragment, the
 * component of the URI following a '#'. Builds and parses URI references
 * which conform to
 * <a href="http://www.faqs.org/rfcs/rfc2396.html">RFC 2396</a>.
 *
 * <p>In the interest of performance, this class performs little to no
 * validation. Behavior is undefined for invalid input. This class is very
 * forgiving--in the face of invalid input, it will return garbage
 * rather than throw an exception unless otherwise specified.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Uri implements android.os.Parcelable, java.lang.Comparable<android.net.Uri> {

private Uri() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this URI is hierarchical like "http://google.com".
 * Absolute URIs are hierarchical if the scheme-specific part starts with
 * a '/'. Relative URIs are always hierarchical.
 * @apiSince 1
 */

public abstract boolean isHierarchical();

/**
 * Returns true if this URI is opaque like "mailto:nobody@google.com". The
 * scheme-specific part of an opaque URI cannot start with a '/'.
 * @apiSince 1
 */

public boolean isOpaque() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this URI is relative, i.e.&nbsp;if it doesn't contain an
 * explicit scheme.
 *
 * @return true if this URI is relative, false if it's absolute
 * @apiSince 1
 */

public abstract boolean isRelative();

/**
 * Returns true if this URI is absolute, i.e.&nbsp;if it contains an
 * explicit scheme.
 *
 * @return true if this URI is absolute, false if it's relative
 * @apiSince 1
 */

public boolean isAbsolute() { throw new RuntimeException("Stub!"); }

/**
 * Gets the scheme of this URI. Example: "http"
 *
 * @return the scheme or null if this is a relative URI
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.String getScheme();

/**
 * Gets the scheme-specific part of this URI, i.e.&nbsp;everything between
 * the scheme separator ':' and the fragment separator '#'. If this is a
 * relative URI, this method returns the entire URI. Decodes escaped octets.
 *
 * <p>Example: "//www.google.com/search?q=android"
 *
 * @return the decoded scheme-specific-part
 * @apiSince 1
 */

public abstract java.lang.String getSchemeSpecificPart();

/**
 * Gets the scheme-specific part of this URI, i.e.&nbsp;everything between
 * the scheme separator ':' and the fragment separator '#'. If this is a
 * relative URI, this method returns the entire URI. Leaves escaped octets
 * intact.
 *
 * <p>Example: "//www.google.com/search?q=android"
 *
 * @return the encoded scheme-specific-part
 * @apiSince 1
 */

public abstract java.lang.String getEncodedSchemeSpecificPart();

/**
 * Gets the decoded authority part of this URI. For
 * server addresses, the authority is structured as follows:
 * {@code [ userinfo '@' ] host [ ':' port ]}
 *
 * <p>Examples: "google.com", "bob@google.com:80"
 *
 * @return the authority for this URI or null if not present
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.String getAuthority();

/**
 * Gets the encoded authority part of this URI. For
 * server addresses, the authority is structured as follows:
 * {@code [ userinfo '@' ] host [ ':' port ]}
 *
 * <p>Examples: "google.com", "bob@google.com:80"
 *
 * @return the authority for this URI or null if not present
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.String getEncodedAuthority();

/**
 * Gets the decoded user information from the authority.
 * For example, if the authority is "nobody@google.com", this method will
 * return "nobody".
 *
 * @return the user info for this URI or null if not present
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.String getUserInfo();

/**
 * Gets the encoded user information from the authority.
 * For example, if the authority is "nobody@google.com", this method will
 * return "nobody".
 *
 * @return the user info for this URI or null if not present
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.String getEncodedUserInfo();

/**
 * Gets the encoded host from the authority for this URI. For example,
 * if the authority is "bob@google.com", this method will return
 * "google.com".
 *
 * @return the host for this URI or null if not present
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.String getHost();

/**
 * Gets the port from the authority for this URI. For example,
 * if the authority is "google.com:80", this method will return 80.
 *
 * @return the port for this URI or -1 if invalid or not present
 * @apiSince 1
 */

public abstract int getPort();

/**
 * Gets the decoded path.
 *
 * @return the decoded path, or null if this is not a hierarchical URI
 * (like "mailto:nobody@google.com") or the URI is invalid
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.String getPath();

/**
 * Gets the encoded path.
 *
 * @return the encoded path, or null if this is not a hierarchical URI
 * (like "mailto:nobody@google.com") or the URI is invalid
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.String getEncodedPath();

/**
 * Gets the decoded query component from this URI. The query comes after
 * the query separator ('?') and before the fragment separator ('#'). This
 * method would return "q=android" for
 * "http://www.google.com/search?q=android".
 *
 * @return the decoded query or null if there isn't one
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.String getQuery();

/**
 * Gets the encoded query component from this URI. The query comes after
 * the query separator ('?') and before the fragment separator ('#'). This
 * method would return "q=android" for
 * "http://www.google.com/search?q=android".
 *
 * @return the encoded query or null if there isn't one
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.String getEncodedQuery();

/**
 * Gets the decoded fragment part of this URI, everything after the '#'.
 *
 * @return the decoded fragment or null if there isn't one
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.String getFragment();

/**
 * Gets the encoded fragment part of this URI, everything after the '#'.
 *
 * @return the encoded fragment or null if there isn't one
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.String getEncodedFragment();

/**
 * Gets the decoded path segments.
 *
 * @return decoded path segments, each without a leading or trailing '/'
 * @apiSince 1
 */

public abstract java.util.List<java.lang.String> getPathSegments();

/**
 * Gets the decoded last segment in the path.
 *
 * @return the decoded last segment or null if the path is empty
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.String getLastPathSegment();

/**
 * Compares this Uri to another object for equality. Returns true if the
 * encoded string representations of this Uri and the given Uri are
 * equal. Case counts. Paths are not normalized. If one Uri specifies a
 * default port explicitly and the other leaves it implicit, they will not
 * be considered equal.
 * @apiSince 1
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Hashes the encoded string represention of this Uri consistently with
 * {@link #equals(java.lang.Object)}.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Compares the string representation of this Uri with that of
 * another.
 * @apiSince 1
 */

public int compareTo(android.net.Uri other) { throw new RuntimeException("Stub!"); }

/**
 * Returns the encoded string representation of this URI.
 * Example: "http://google.com/"
 * @apiSince 1
 */

public abstract java.lang.String toString();

/**
 * Constructs a new builder, copying the attributes from this Uri.
 * @apiSince 1
 */

public abstract android.net.Uri.Builder buildUpon();

/**
 * Creates a Uri which parses the given encoded URI string.
 *
 * @param uriString an RFC 2396-compliant, encoded URI
 * @throws java.lang.NullPointerException if uriString is null
 * @return Uri for this given uri string
 * @apiSince 1
 */

public static android.net.Uri parse(java.lang.String uriString) { throw new RuntimeException("Stub!"); }

/**
 * Creates a Uri from a file. The URI has the form
 * "file://<absolute path>". Encodes path characters with the exception of
 * '/'.
 *
 * <p>Example: "file:///tmp/android.txt"
 *
 * @throws java.lang.NullPointerException if file is null
 * @return a Uri for the given file
 * @apiSince 1
 */

public static android.net.Uri fromFile(java.io.File file) { throw new RuntimeException("Stub!"); }

/**
 * Creates an opaque Uri from the given components. Encodes the ssp
 * which means this method cannot be used to create hierarchical URIs.
 *
 * @param scheme of the URI
 * @param ssp scheme-specific-part, everything between the
 *  scheme separator (':') and the fragment separator ('#'), which will
 *  get encoded
 * @param fragment fragment, everything after the '#', null if undefined,
 *  will get encoded
 *
 * @throws java.lang.NullPointerException if scheme or ssp is null
 * @return Uri composed of the given scheme, ssp, and fragment
 *
 * @see android.net.Uri.Builder if you don't want the ssp and fragment to be encoded
 * @apiSince 1
 */

public static android.net.Uri fromParts(java.lang.String scheme, java.lang.String ssp, java.lang.String fragment) { throw new RuntimeException("Stub!"); }

/**
 * Returns a set of the unique names of all query parameters. Iterating
 * over the set will return the names in order of their first occurrence.
 *
 * @throws java.lang.UnsupportedOperationException if this isn't a hierarchical URI
 *
 * @return a set of decoded names
 * @apiSince 11
 */

public java.util.Set<java.lang.String> getQueryParameterNames() { throw new RuntimeException("Stub!"); }

/**
 * Searches the query string for parameter values with the given key.
 *
 * @param key which will be encoded
 *
 * @throws java.lang.UnsupportedOperationException if this isn't a hierarchical URI
 * @throws java.lang.NullPointerException if key is null
 * @return a list of decoded values
 * @apiSince 1
 */

public java.util.List<java.lang.String> getQueryParameters(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the query string for the first value with the given key.
 *
 * <p><strong>Warning:</strong> Prior to Jelly Bean, this decoded
 * the '+' character as '+' rather than ' '.
 *
 * @param key which will be encoded
 * @throws java.lang.UnsupportedOperationException if this isn't a hierarchical URI
 * @throws java.lang.NullPointerException if key is null
 * @return the decoded value or null if no parameter is found
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String getQueryParameter(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the query string for the first value with the given key and interprets it
 * as a boolean value. "false" and "0" are interpreted as <code>false</code>, everything
 * else is interpreted as <code>true</code>.
 *
 * @param key which will be decoded
 * @param defaultValue the default value to return if there is no query parameter for key
 * @return the boolean interpretation of the query parameter key
 * @apiSince 11
 */

public boolean getBooleanQueryParameter(java.lang.String key, boolean defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Return an equivalent URI with a lowercase scheme component.
 * This aligns the Uri with Android best practices for
 * intent filtering.
 *
 * <p>For example, "HTTP://www.android.com" becomes
 * "http://www.android.com"
 *
 * <p>All URIs received from outside Android (such as user input,
 * or external sources like Bluetooth, NFC, or the Internet) should
 * be normalized before they are used to create an Intent.
 *
 * <p class="note">This method does <em>not</em> validate bad URI's,
 * or 'fix' poorly formatted URI's - so do not use it for input validation.
 * A Uri will always be returned, even if the Uri is badly formatted to
 * begin with and a scheme component cannot be found.
 *
 * @return normalized Uri (never null)
 * @see android.content.Intent#setData
 * @see android.content.Intent#setDataAndNormalize
 * @apiSince 16
 */

public android.net.Uri normalizeScheme() { throw new RuntimeException("Stub!"); }

/**
 * Writes a Uri to a Parcel.
 *
 * @param out parcel to write to
 * @param uri to write, can be null
 * @apiSince 1
 */

public static void writeToParcel(android.os.Parcel out, android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Encodes characters in the given string as '%'-escaped octets
 * using the UTF-8 scheme. Leaves letters ("A-Z", "a-z"), numbers
 * ("0-9"), and unreserved characters ("_-!.~'()*") intact. Encodes
 * all other characters.
 *
 * @param s string to encode
 * @return an encoded version of s suitable for use as a URI component,
 *  or null if s is null
 * @apiSince 1
 */

public static java.lang.String encode(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Encodes characters in the given string as '%'-escaped octets
 * using the UTF-8 scheme. Leaves letters ("A-Z", "a-z"), numbers
 * ("0-9"), and unreserved characters ("_-!.~'()*") intact. Encodes
 * all other characters with the exception of those specified in the
 * allow argument.
 *
 * @param s string to encode
 * @param allow set of additional characters to allow in the encoded form,
 *  null if no characters should be skipped
 * @return an encoded version of s suitable for use as a URI component,
 *  or null if s is null
 * @apiSince 1
 */

public static java.lang.String encode(java.lang.String s, java.lang.String allow) { throw new RuntimeException("Stub!"); }

/**
 * Decodes '%'-escaped octets in the given string using the UTF-8 scheme.
 * Replaces invalid octets with the unicode replacement character
 * ("\\uFFFD").
 *
 * @param s encoded string to decode
 * @return the given string with escaped octets decoded, or null if
 *  s is null
 * @apiSince 1
 */

public static java.lang.String decode(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new Uri by appending an already-encoded path segment to a
 * base Uri.
 *
 * @param baseUri Uri to append path segment to
 * @param pathSegment encoded path segment to append
 * @return a new Uri based on baseUri with the given segment appended to
 *  the path
 * @throws java.lang.NullPointerException if baseUri is null
 * @apiSince 1
 */

public static android.net.Uri withAppendedPath(android.net.Uri baseUri, java.lang.String pathSegment) { throw new RuntimeException("Stub!"); }

/**
 * Reads Uris from Parcels.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.Uri> CREATOR;
static { CREATOR = null; }

/**
 * The empty URI, equivalent to "".
 * @apiSince 1
 */

public static final android.net.Uri EMPTY;
static { EMPTY = null; }
/**
 * Helper class for building or manipulating URI references. Not safe for
 * concurrent use.
 *
 * <p>An absolute hierarchical URI reference follows the pattern:
 * {@code <scheme>://<authority><absolute path>?<query>#<fragment>}
 *
 * <p>Relative URI references (which are always hierarchical) follow one
 * of two patterns: {@code <relative or absolute path>?<query>#<fragment>}
 * or {@code //<authority><absolute path>?<query>#<fragment>}
 *
 * <p>An opaque URI follows this pattern:
 * {@code <scheme>:<opaque part>#<fragment>}
 *
 * <p>Use {@link android.net.Uri#buildUpon() Uri#buildUpon()} to obtain a builder representing an existing URI.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Constructs a new Builder.
 * @apiSince 1
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the scheme.
 *
 * @param scheme name or {@code null} if this is a relative Uri
 * @apiSince 1
 */

public android.net.Uri.Builder scheme(java.lang.String scheme) { throw new RuntimeException("Stub!"); }

/**
 * Encodes and sets the given opaque scheme-specific-part.
 *
 * @param opaquePart decoded opaque part
 * @apiSince 1
 */

public android.net.Uri.Builder opaquePart(java.lang.String opaquePart) { throw new RuntimeException("Stub!"); }

/**
 * Sets the previously encoded opaque scheme-specific-part.
 *
 * @param opaquePart encoded opaque part
 * @apiSince 1
 */

public android.net.Uri.Builder encodedOpaquePart(java.lang.String opaquePart) { throw new RuntimeException("Stub!"); }

/**
 * Encodes and sets the authority.
 * @apiSince 1
 */

public android.net.Uri.Builder authority(java.lang.String authority) { throw new RuntimeException("Stub!"); }

/**
 * Sets the previously encoded authority.
 * @apiSince 1
 */

public android.net.Uri.Builder encodedAuthority(java.lang.String authority) { throw new RuntimeException("Stub!"); }

/**
 * Sets the path. Leaves '/' characters intact but encodes others as
 * necessary.
 *
 * <p>If the path is not null and doesn't start with a '/', and if
 * you specify a scheme and/or authority, the builder will prepend the
 * given path with a '/'.
 * @apiSince 1
 */

public android.net.Uri.Builder path(java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Sets the previously encoded path.
 *
 * <p>If the path is not null and doesn't start with a '/', and if
 * you specify a scheme and/or authority, the builder will prepend the
 * given path with a '/'.
 * @apiSince 1
 */

public android.net.Uri.Builder encodedPath(java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Encodes the given segment and appends it to the path.
 * @apiSince 1
 */

public android.net.Uri.Builder appendPath(java.lang.String newSegment) { throw new RuntimeException("Stub!"); }

/**
 * Appends the given segment to the path.
 * @apiSince 1
 */

public android.net.Uri.Builder appendEncodedPath(java.lang.String newSegment) { throw new RuntimeException("Stub!"); }

/**
 * Encodes and sets the query.
 * @apiSince 1
 */

public android.net.Uri.Builder query(java.lang.String query) { throw new RuntimeException("Stub!"); }

/**
 * Sets the previously encoded query.
 * @apiSince 1
 */

public android.net.Uri.Builder encodedQuery(java.lang.String query) { throw new RuntimeException("Stub!"); }

/**
 * Encodes and sets the fragment.
 * @apiSince 1
 */

public android.net.Uri.Builder fragment(java.lang.String fragment) { throw new RuntimeException("Stub!"); }

/**
 * Sets the previously encoded fragment.
 * @apiSince 1
 */

public android.net.Uri.Builder encodedFragment(java.lang.String fragment) { throw new RuntimeException("Stub!"); }

/**
 * Encodes the key and value and then appends the parameter to the
 * query string.
 *
 * @param key which will be encoded
 * @param value which will be encoded
 * @apiSince 1
 */

public android.net.Uri.Builder appendQueryParameter(java.lang.String key, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Clears the the previously set query.
 * @apiSince 11
 */

public android.net.Uri.Builder clearQuery() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a Uri with the current attributes.
 *
 * @throws java.lang.UnsupportedOperationException if the URI is opaque and the
 *  scheme is null
 * @apiSince 1
 */

public android.net.Uri build() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

}

