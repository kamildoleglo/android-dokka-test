/*
 * Copyright 2018 The Android Open Source Project
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


package android.media;


/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * A set of {@link android.media.Session2Command Session2Command} which represents a command group.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Session2CommandGroup implements android.os.Parcelable {

Session2CommandGroup() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether this command group has a command that matches given {@code command}.
 *
 * @param command A command to find. Shouldn't be {@code null}.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public boolean hasCommand(@androidx.annotation.NonNull android.media.Session2Command command) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether this command group has a command that matches given {@code commandCode}.
 *
 * @param commandCode A command code to find.
 *                    Shouldn't be {@link android.media.Session2Command#COMMAND_CODE_CUSTOM Session2Command#COMMAND_CODE_CUSTOM}.
 * @apiSince 29
 */

public boolean hasCommand(int commandCode) { throw new RuntimeException("Stub!"); }

/**
 * Gets all commands of this command group.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.Set<android.media.Session2Command> getCommands() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param dest This value must never be {@code null}.
 * @apiSince 29
 */

public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.Session2CommandGroup> CREATOR;
static { CREATOR = null; }
/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Builds a {@link android.media.Session2CommandGroup Session2CommandGroup} object.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/** @apiSince 29 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new builder for {@link android.media.Session2CommandGroup Session2CommandGroup} with commands copied from another
 * {@link android.media.Session2CommandGroup Session2CommandGroup} object.
 * @param commandGroup
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull android.media.Session2CommandGroup commandGroup) { throw new RuntimeException("Stub!"); }

/**
 * Adds a command to this command group.
 *
 * @param command A command to add. Shouldn't be {@code null}.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.Session2CommandGroup.Builder addCommand(@androidx.annotation.NonNull android.media.Session2Command command) { throw new RuntimeException("Stub!"); }

/**
 * Removes a command from this group which matches given {@code command}.
 *
 * @param command A command to find. Shouldn't be {@code null}.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.Session2CommandGroup.Builder removeCommand(@androidx.annotation.NonNull android.media.Session2Command command) { throw new RuntimeException("Stub!"); }

/**
 * Builds {@link android.media.Session2CommandGroup Session2CommandGroup}.
 *
 * @return a new {@link android.media.Session2CommandGroup Session2CommandGroup}.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.Session2CommandGroup build() { throw new RuntimeException("Stub!"); }
}

}

