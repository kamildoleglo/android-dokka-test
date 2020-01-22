/**
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package android.content.pm;


/**
 * A set of features that can be requested by an application. This corresponds
 * to information collected from the
 * AndroidManifest.xml's {@code <feature-group>} tag.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FeatureGroupInfo implements android.os.Parcelable {

/** @apiSince 21 */

public FeatureGroupInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public FeatureGroupInfo(android.content.pm.FeatureGroupInfo other) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.pm.FeatureGroupInfo> CREATOR;
static { CREATOR = null; }

/**
 * The list of features that are required by this group.
 *
 * @see android.content.pm.FeatureInfo#FLAG_REQUIRED
 * @apiSince 21
 */

public android.content.pm.FeatureInfo[] features;
}

