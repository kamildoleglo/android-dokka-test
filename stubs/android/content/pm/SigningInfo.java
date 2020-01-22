/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.content.pm;


/**
 * Information pertaining to the signing certificates used to sign a package.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SigningInfo implements android.os.Parcelable {

/** @apiSince 28 */

public SigningInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public SigningInfo(android.content.pm.SigningInfo orig) { throw new RuntimeException("Stub!"); }

/**
 * Although relatively uncommon, packages may be signed by more than one signer, in which case
 * their identity is viewed as being the set of all signers, not just any one.
 * @apiSince 28
 */

public boolean hasMultipleSigners() { throw new RuntimeException("Stub!"); }

/**
 * APK Signature Scheme v3 enables packages to provide a proof-of-rotation record that the
 * platform verifies, and uses, to allow the use of new signing certificates.  This is only
 * available to packages that are not signed by multiple signers.  In the event of a change to a
 * new signing certificate, the package's past signing certificates are presented as well.  Any
 * check of a package's signing certificate should also include a search through its entire
 * signing history, since it could change to a new signing certificate at any time.
 * @apiSince 28
 */

public boolean hasPastSigningCertificates() { throw new RuntimeException("Stub!"); }

/**
 * Returns the signing certificates this package has proven it is authorized to use. This
 * includes both the signing certificate associated with the signer of the package and the past
 * signing certificates it included as its proof of signing certificate rotation.  This method
 * is the preferred replacement for the {@code GET_SIGNATURES} flag used with {@link android.content.pm.PackageManager#getPackageInfo(java.lang.String,int) PackageManager#getPackageInfo(String, int)}.  When determining if a package is signed by a
 * desired certificate, the returned array should be checked to determine if it is one of the
 * entries.
 *
 * <note>
 *     This method returns null if the package is signed by multiple signing certificates, as
 *     opposed to being signed by one current signer and also providing the history of past
 *     signing certificates.  {@link #hasMultipleSigners()} may be used to determine if this
 *     package is signed by multiple signers.  Packages which are signed by multiple signers
 *     cannot change their signing certificates and their {@code Signature} array should be
 *     checked to make sure that every entry matches the looked-for signing certificates.
 * </note>
 * @apiSince 28
 */

public android.content.pm.Signature[] getSigningCertificateHistory() { throw new RuntimeException("Stub!"); }

/**
 * Returns the signing certificates used to sign the APK contents of this application.  Not
 * including any past signing certificates the package proved it is authorized to use.
 * <note>
 *     This method should not be used unless {@link #hasMultipleSigners()} returns true,
 *     indicating that {@link #getSigningCertificateHistory()} cannot be used, otherwise {@link
 *     #getSigningCertificateHistory()} should be preferred.
 * </note>
 * @apiSince 28
 */

public android.content.pm.Signature[] getApkContentsSigners() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.pm.SigningInfo> CREATOR;
static { CREATOR = null; }
}

