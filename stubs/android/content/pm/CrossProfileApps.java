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

package android.content.pm;

import android.os.UserHandle;
import android.content.ComponentName;
import android.os.UserManager;

/**
 * Class for handling cross profile operations. Apps can use this class to interact with its
 * instance in any profile that is in {@link #getTargetUserProfiles()}. For example, app can
 * use this class to start its main activity in managed profile.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CrossProfileApps {

CrossProfileApps() { throw new RuntimeException("Stub!"); }

/**
 * Starts the specified main activity of the caller package in the specified profile.
 *
 * @param component The ComponentName of the activity to launch, it must be exported and has
 *        action {@link android.content.Intent#ACTION_MAIN}, category
 *        {@link android.content.Intent#CATEGORY_LAUNCHER}. Otherwise, SecurityException will
 *        be thrown.
 * This value must never be {@code null}.
 * @param targetUser The UserHandle of the profile, must be one of the users returned by
 *        {@link #getTargetUserProfiles()}, otherwise a {@link java.lang.SecurityException SecurityException} will
 *        be thrown.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void startMainActivity(@androidx.annotation.NonNull android.content.ComponentName component, @androidx.annotation.NonNull android.os.UserHandle targetUser) { throw new RuntimeException("Stub!"); }

/**
 * Return a list of user profiles that that the caller can use when calling other APIs in this
 * class.
 * <p>
 * A user profile would be considered as a valid target user profile, provided that:
 * <ul>
 * <li>It gets caller app installed</li>
 * <li>It is not equal to the calling user</li>
 * <li>It is in the same profile group of calling user profile</li>
 * <li>It is enabled</li>
 * </ul>
 *
 * @see android.os.UserManager#getUserProfiles()
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.List<android.os.UserHandle> getTargetUserProfiles() { throw new RuntimeException("Stub!"); }

/**
 * Return a label that calling app can show to user for the semantic of profile switching --
 * launching its own activity in specified user profile. For example, it may return
 * "Switch to work" if the given user handle is the managed profile one.
 *
 * @param userHandle The UserHandle of the target profile, must be one of the users returned by
 *        {@link #getTargetUserProfiles()}, otherwise a {@link java.lang.SecurityException SecurityException} will
 *        be thrown.
 * This value must never be {@code null}.
 * @return a label that calling app can show user for the semantic of launching its own
 *         activity in the specified user profile.
 *
 * This value will never be {@code null}.
 * @see #startMainActivity(ComponentName, UserHandle)
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.lang.CharSequence getProfileSwitchingLabel(@androidx.annotation.NonNull android.os.UserHandle userHandle) { throw new RuntimeException("Stub!"); }

/**
 * Return a drawable that calling app can show to user for the semantic of profile switching --
 * launching its own activity in specified user profile. For example, it may return a briefcase
 * icon if the given user handle is the managed profile one.
 *
 * @param userHandle The UserHandle of the target profile, must be one of the users returned by
 *        {@link #getTargetUserProfiles()}, otherwise a {@link java.lang.SecurityException SecurityException} will
 *        be thrown.
 * This value must never be {@code null}.
 * @return an icon that calling app can show user for the semantic of launching its own
 *         activity in specified user profile.
 *
 * This value will never be {@code null}.
 * @see #startMainActivity(ComponentName, UserHandle)
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.graphics.drawable.Drawable getProfileSwitchingIconDrawable(@androidx.annotation.NonNull android.os.UserHandle userHandle) { throw new RuntimeException("Stub!"); }
}

