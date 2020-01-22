/*
 * Copyright (C) 2009 The Android Open Source Project
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
 * Description of permissions needed to access a particular path
 * in a {@link android.content.pm.ProviderInfo ProviderInfo}.
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PathPermission extends android.os.PatternMatcher {

/** @apiSince 4 */

public PathPermission(java.lang.String pattern, int type, java.lang.String readPermission, java.lang.String writePermission) { super((android.os.Parcel)null); throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public PathPermission(android.os.Parcel src) { super((android.os.Parcel)null); throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public java.lang.String getReadPermission() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public java.lang.String getWritePermission() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.pm.PathPermission> CREATOR;
static { CREATOR = null; }
}

