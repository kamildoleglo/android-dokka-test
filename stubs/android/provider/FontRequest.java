/*
 * Copyright (C) 2017 The Android Open Source Project
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

package android.provider;


/**
 * Information about a font request that may be sent to a Font Provider.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FontRequest {

/**
 * @param providerAuthority The authority of the Font Provider to be used for the request. This
 *         should be a system installed app.
 * This value must never be {@code null}.
 * @param providerPackage The package for the Font Provider to be used for the request. This is
 *         used to verify the identity of the provider.
 * This value must never be {@code null}.
 * @param query The query to be sent over to the provider. Refer to your font provider's
 *         documentation on the format of this string.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public FontRequest(@androidx.annotation.NonNull java.lang.String providerAuthority, @androidx.annotation.NonNull java.lang.String providerPackage, @androidx.annotation.NonNull java.lang.String query) { throw new RuntimeException("Stub!"); }

/**
 * @param providerAuthority The authority of the Font Provider to be used for the request.
 * This value must never be {@code null}.
 * @param query The query to be sent over to the provider. Refer to your font provider's
 *         documentation on the format of this string.
 * This value must never be {@code null}.
 * @param providerPackage The package for the Font Provider to be used for the request. This is
 *         used to verify the identity of the provider.
 * This value must never be {@code null}.
 * @param certificates The list of sets of hashes for the certificates the provider should be
 *         signed with. This is used to verify the identity of the provider. Each set in the
 *         list represents one collection of signature hashes. Refer to your font provider's
 *         documentation for these values.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public FontRequest(@androidx.annotation.NonNull java.lang.String providerAuthority, @androidx.annotation.NonNull java.lang.String providerPackage, @androidx.annotation.NonNull java.lang.String query, @androidx.annotation.NonNull java.util.List<java.util.List<byte[]>> certificates) { throw new RuntimeException("Stub!"); }

/**
 * Returns the selected font provider's authority. This tells the system what font provider
 * it should request the font from.
 * @apiSince 26
 */

public java.lang.String getProviderAuthority() { throw new RuntimeException("Stub!"); }

/**
 * Returns the selected font provider's package. This helps the system verify that the provider
 * identified by the given authority is the one requested.
 * @apiSince 26
 */

public java.lang.String getProviderPackage() { throw new RuntimeException("Stub!"); }

/**
 * Returns the query string. Refer to your font provider's documentation on the format of this
 * string.
 * @apiSince 26
 */

public java.lang.String getQuery() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of certificate sets given for this provider. This helps the system verify
 * that the provider identified by the given authority is the one requested.
 * @apiSince 26
 */

public java.util.List<java.util.List<byte[]>> getCertificates() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

