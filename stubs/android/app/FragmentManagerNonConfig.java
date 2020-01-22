/*
 * Copyright (C) 2016 The Android Open Source Project
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



package android.app;


/**
 * FragmentManagerNonConfig stores the retained instance fragments across
 * activity recreation events.
 *
 * <p>Apps should treat objects of this type as opaque, returned by
 * and passed to the state save and restore process for fragments in
 * {@link android.app.FragmentController#retainNonConfig() FragmentController#retainNonConfig()} and
 * {@link android.app.FragmentController#restoreAllState(Parcelable,android.app.FragmentManagerNonConfig) FragmentController#restoreAllState(Parcelable, FragmentManagerNonConfig)}.</p>
 *
 * @deprecated Use the <a href="{@docRoot}tools/extras/support-library.html">Support Library</a>
 *      {@link android.support.v4.app.FragmentManagerNonConfig}
 * @apiSince 24
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class FragmentManagerNonConfig {

FragmentManagerNonConfig() { throw new RuntimeException("Stub!"); }
}

