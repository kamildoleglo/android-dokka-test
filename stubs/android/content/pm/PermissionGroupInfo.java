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
 * group known to the system.  This corresponds to information collected from the
 * AndroidManifest.xml's &lt;permission-group&gt; tags.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PermissionGroupInfo extends android.content.pm.PackageItemInfo implements android.os.Parcelable {

/**
 * @deprecated Should only be created by the system.
 * @apiSince 1
 */

@Deprecated
public PermissionGroupInfo() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Should only be created by the system.
 
 * @param orig This value must never be {@code null}.
 * @apiSince 1
 */

@Deprecated
public PermissionGroupInfo(@androidx.annotation.NonNull android.content.pm.PermissionGroupInfo orig) { throw new RuntimeException("Stub!"); }

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

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.pm.PermissionGroupInfo> CREATOR;
static { CREATOR = null; }

/**
 * Flag for {@link #flags}, corresponding to <code>personalInfo</code>
 * value of {@link android.R.attr#permissionGroupFlags}.
 * @apiSince 17
 */

public static final int FLAG_PERSONAL_INFO = 1; // 0x1

/**
 * A string resource identifier (in the package's resources) of this
 * permission's description.  From the "description" attribute or,
 * if not set, 0.
 * @apiSince 1
 */

public int descriptionRes;

/**
 * Additional flags about this group as given by
 * {@link android.R.attr#permissionGroupFlags}.
 
 * <br>
 * Value is either <code>0</code> or {@link android.content.pm.PermissionGroupInfo#FLAG_PERSONAL_INFO}
 * @apiSince 17
 */

public int flags;

/**
 * The description string provided in the AndroidManifest file, if any.  You
 * probably don't want to use this, since it will be null if the description
 * is in a resource.  You probably want
 * {@link android.content.pm.PermissionInfo#loadDescription PermissionInfo#loadDescription} instead.
 * @apiSince 1
 */

@androidx.annotation.Nullable public java.lang.CharSequence nonLocalizedDescription;

/**
 * Prioritization of this group, for visually sorting with other groups.
 * @apiSince 17
 */

public int priority;
}

