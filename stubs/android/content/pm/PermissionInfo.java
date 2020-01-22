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


package android.content.pm;


/**
 * Information you can retrieve about a particular security permission
 * known to the system.  This corresponds to information collected from the
 * AndroidManifest.xml's &lt;permission&gt; tags.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PermissionInfo extends android.content.pm.PackageItemInfo implements android.os.Parcelable {

/**
 * @deprecated Should only be created by the system.
 * @apiSince 1
 */

@Deprecated
public PermissionInfo() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Should only be created by the system.
 
 * @param orig This value must never be {@code null}.
 * @apiSince 1
 */

@Deprecated
public PermissionInfo(@androidx.annotation.NonNull android.content.pm.PermissionInfo orig) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the textual description of this permission.  This
 * will call back on the given PackageManager to load the description from
 * the application.
 *
 * @param pm A PackageManager from which the label can be loaded; usually
 * the PackageManager from which you originally retrieved this item.
 *
 * This value must never be {@code null}.
 * @return Returns a CharSequence containing the permission's description.
 * If there is no description, null is returned.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.CharSequence loadDescription(@androidx.annotation.NonNull android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Return the base permission type.
 
 * @return Value is {@link android.content.pm.PermissionInfo#PROTECTION_NORMAL}, {@link android.content.pm.PermissionInfo#PROTECTION_DANGEROUS}, {@link android.content.pm.PermissionInfo#PROTECTION_SIGNATURE}, or {@link android.content.pm.PermissionInfo#PROTECTION_SIGNATURE_OR_SYSTEM}
 * @apiSince 28
 */

public int getProtection() { throw new RuntimeException("Stub!"); }

/**
 * Return the additional flags in {@link #protectionLevel}.
 
 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.PermissionInfo#PROTECTION_FLAG_PRIVILEGED}, {@link android.content.pm.PermissionInfo#PROTECTION_FLAG_SYSTEM}, {@link android.content.pm.PermissionInfo#PROTECTION_FLAG_DEVELOPMENT}, {@link android.content.pm.PermissionInfo#PROTECTION_FLAG_APPOP}, {@link android.content.pm.PermissionInfo#PROTECTION_FLAG_PRE23}, {@link android.content.pm.PermissionInfo#PROTECTION_FLAG_INSTALLER}, {@link android.content.pm.PermissionInfo#PROTECTION_FLAG_VERIFIER}, {@link android.content.pm.PermissionInfo#PROTECTION_FLAG_PREINSTALLED}, {@link android.content.pm.PermissionInfo#PROTECTION_FLAG_SETUP}, {@link android.content.pm.PermissionInfo#PROTECTION_FLAG_INSTANT}, {@link android.content.pm.PermissionInfo#PROTECTION_FLAG_RUNTIME_ONLY}, android.content.pm.PermissionInfo.PROTECTION_FLAG_OEM, android.content.pm.PermissionInfo.PROTECTION_FLAG_VENDOR_PRIVILEGED, android.content.pm.PermissionInfo.PROTECTION_FLAG_SYSTEM_TEXT_CLASSIFIER, android.content.pm.PermissionInfo.PROTECTION_FLAG_WELLBEING, android.content.pm.PermissionInfo.PROTECTION_FLAG_DOCUMENTER, android.content.pm.PermissionInfo.PROTECTION_FLAG_CONFIGURATOR, android.content.pm.PermissionInfo.PROTECTION_FLAG_INCIDENT_REPORT_APPROVER, android.content.pm.PermissionInfo.PROTECTION_FLAG_APP_PREDICTOR, and android.content.pm.PermissionInfo.PROTECTION_FLAG_TELEPHONY
 * @apiSince 28
 */

public int getProtectionFlags() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.pm.PermissionInfo> CREATOR;
static { CREATOR = null; }

/**
 * Flag for {@link #flags}, corresponding to <code>costsMoney</code>
 * value of {@link android.R.attr#permissionFlags}.
 * @apiSince 17
 */

public static final int FLAG_COSTS_MONEY = 1; // 0x1

/**
 * Flag for {@link #flags}, corresponding to <code>hardRestricted</code>
 * value of {@link android.R.attr#permissionFlags}.
 *
 * <p> This permission is restricted by the platform and it would be
 * grantable only to apps that meet special criteria per platform
 * policy.
 * @apiSince 29
 */

public static final int FLAG_HARD_RESTRICTED = 4; // 0x4

/**
 * Flag for {@link #flags}, corresponding to <code>immutablyRestricted</code>
 * value of {@link android.R.attr#permissionFlags}.
 *
 * <p>This permission is restricted immutably which means that its
 * restriction state may be specified only on the first install of
 * the app and will stay in this initial whitelist state until
 * the app is uninstalled.
 * @apiSince 29
 */

public static final int FLAG_IMMUTABLY_RESTRICTED = 16; // 0x10

/**
 * Flag for {@link #flags}, indicating that this permission has been
 * installed into the system's globally defined permissions.
 * @apiSince 23
 */

public static final int FLAG_INSTALLED = 1073741824; // 0x40000000

/**
 * Flag for {@link #flags}, corresponding to <code>softRestricted</code>
 * value of {@link android.R.attr#permissionFlags}.
 *
 * <p>This permission is restricted by the platform and it would be
 * grantable in its full form to apps that meet special criteria
 * per platform policy. Otherwise, a weaker form of the permission
 * would be granted. The weak grant depends on the permission.
 * @apiSince 29
 */

public static final int FLAG_SOFT_RESTRICTED = 8; // 0x8

/**
 * Dangerous value for {@link #protectionLevel}, corresponding
 * to the <code>dangerous</code> value of
 * {@link android.R.attr#protectionLevel}.
 * @apiSince 1
 */

public static final int PROTECTION_DANGEROUS = 1; // 0x1

/**
 * Additional flag for {@link #protectionLevel}, corresponding
 * to the <code>appop</code> value of
 * {@link android.R.attr#protectionLevel}.
 * @apiSince 21
 */

public static final int PROTECTION_FLAG_APPOP = 64; // 0x40

/**
 * Additional flag for {@link #protectionLevel}, corresponding
 * to the <code>development</code> value of
 * {@link android.R.attr#protectionLevel}.
 * @apiSince 16
 */

public static final int PROTECTION_FLAG_DEVELOPMENT = 32; // 0x20

/**
 * Additional flag for {@link #protectionLevel}, corresponding
 * to the <code>installer</code> value of
 * {@link android.R.attr#protectionLevel}.
 * @apiSince 23
 */

public static final int PROTECTION_FLAG_INSTALLER = 256; // 0x100

/**
 * Additional flag for {@link #protectionLevel}, corresponding
 * to the <code>instant</code> value of
 * {@link android.R.attr#protectionLevel}.
 * @apiSince 27
 */

public static final int PROTECTION_FLAG_INSTANT = 4096; // 0x1000

/**
 * Additional flag for {@link #protectionLevel}, corresponding
 * to the <code>pre23</code> value of
 * {@link android.R.attr#protectionLevel}.
 * @apiSince 23
 */

public static final int PROTECTION_FLAG_PRE23 = 128; // 0x80

/**
 * Additional flag for {@link #protectionLevel}, corresponding
 * to the <code>preinstalled</code> value of
 * {@link android.R.attr#protectionLevel}.
 * @apiSince 23
 */

public static final int PROTECTION_FLAG_PREINSTALLED = 1024; // 0x400

/**
 * Additional flag for {@link #protectionLevel}, corresponding
 * to the <code>privileged</code> value of
 * {@link android.R.attr#protectionLevel}.
 * @apiSince 23
 */

public static final int PROTECTION_FLAG_PRIVILEGED = 16; // 0x10

/**
 * Additional flag for {@link #protectionLevel}, corresponding
 * to the <code>runtime</code> value of
 * {@link android.R.attr#protectionLevel}.
 * @apiSince 26
 */

public static final int PROTECTION_FLAG_RUNTIME_ONLY = 8192; // 0x2000

/**
 * Additional flag for {@link #protectionLevel}, corresponding
 * to the <code>setup</code> value of
 * {@link android.R.attr#protectionLevel}.
 * @apiSince 24
 */

public static final int PROTECTION_FLAG_SETUP = 2048; // 0x800

/**
 * @deprecated Old name for {@link #PROTECTION_FLAG_PRIVILEGED}, which
 * is now very confusing because it only applies to privileged apps, not all
 * apps on the system image.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int PROTECTION_FLAG_SYSTEM = 16; // 0x10

/**
 * Additional flag for {@link #protectionLevel}, corresponding
 * to the <code>verifier</code> value of
 * {@link android.R.attr#protectionLevel}.
 * @apiSince 23
 */

public static final int PROTECTION_FLAG_VERIFIER = 512; // 0x200

/**
 * Mask for {@link #protectionLevel}: the basic protection type.
 *
 * @deprecated Use #getProtection() instead.
 * @apiSince 16
 * @deprecatedSince 28
 */

@Deprecated public static final int PROTECTION_MASK_BASE = 15; // 0xf

/**
 * Mask for {@link #protectionLevel}: additional flag bits.
 *
 * @deprecated Use #getProtectionFlags() instead.
 * @apiSince 16
 * @deprecatedSince 28
 */

@Deprecated public static final int PROTECTION_MASK_FLAGS = 65520; // 0xfff0

/**
 * A normal application value for {@link #protectionLevel}, corresponding
 * to the <code>normal</code> value of
 * {@link android.R.attr#protectionLevel}.
 * @apiSince 1
 */

public static final int PROTECTION_NORMAL = 0; // 0x0

/**
 * System-level value for {@link #protectionLevel}, corresponding
 * to the <code>signature</code> value of
 * {@link android.R.attr#protectionLevel}.
 * @apiSince 1
 */

public static final int PROTECTION_SIGNATURE = 2; // 0x2

/**
 * @deprecated Use {@link #PROTECTION_SIGNATURE}|{@link #PROTECTION_FLAG_PRIVILEGED}
 * instead.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated public static final int PROTECTION_SIGNATURE_OR_SYSTEM = 3; // 0x3

/**
 * A string resource identifier (in the package's resources) of this
 * permission's description.  From the "description" attribute or,
 * if not set, 0.
 * @apiSince 1
 */

public int descriptionRes;

/**
 * Additional flags about this permission as given by
 * {@link android.R.attr#permissionFlags}.
 
 * <br>
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PermissionInfo#FLAG_COSTS_MONEY}, android.content.pm.PermissionInfo.FLAG_REMOVED, {@link android.content.pm.PermissionInfo#FLAG_HARD_RESTRICTED}, {@link android.content.pm.PermissionInfo#FLAG_SOFT_RESTRICTED}, {@link android.content.pm.PermissionInfo#FLAG_IMMUTABLY_RESTRICTED}, and {@link android.content.pm.PermissionInfo#FLAG_INSTALLED}
 * @apiSince 17
 */

public int flags;

/**
 * The group this permission is a part of, as per
 * {@link android.R.attr#permissionGroup}.
 * @apiSince 1
 */

@androidx.annotation.Nullable public java.lang.String group;

/**
 * The description string provided in the AndroidManifest file, if any.  You
 * probably don't want to use this, since it will be null if the description
 * is in a resource.  You probably want
 * {@link android.content.pm.PermissionInfo#loadDescription PermissionInfo#loadDescription} instead.
 * @apiSince 1
 */

@androidx.annotation.Nullable public java.lang.CharSequence nonLocalizedDescription;

/**
 * The level of access this permission is protecting, as per
 * {@link android.R.attr#protectionLevel}. Consists of
 * a base permission type and zero or more flags. Use the following functions
 * to extract them.
 *
 * <pre>
 * int basePermissionType = permissionInfo.getProtection();
 * int permissionFlags = permissionInfo.getProtectionFlags();
 * </pre>
 *
 * <p></p>Base permission types are {@link #PROTECTION_NORMAL},
 * {@link #PROTECTION_DANGEROUS}, {@link #PROTECTION_SIGNATURE}
 * and the deprecated {@link #PROTECTION_SIGNATURE_OR_SYSTEM}.
 * Flags are listed under {@link android.R.attr#protectionLevel}.
 *
 * @deprecated Use #getProtection() and #getProtectionFlags() instead.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public int protectionLevel;
}

