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
 * Define a command that a {@link android.media.MediaController2 MediaController2} can send to a {@link android.media.MediaSession2 MediaSession2}.
 * <p>
 * If {@link #getCommandCode()} isn't {@link #COMMAND_CODE_CUSTOM}), it's predefined command.
 * If {@link #getCommandCode()} is {@link #COMMAND_CODE_CUSTOM}), it's custom command and
 * {@link #getCustomAction()} shouldn't be {@code null}.
 * <p>
 * Refer to the
 * <a href="{@docRoot}reference/androidx/media2/SessionCommand2.html">AndroidX SessionCommand</a>
 * class for the list of valid commands.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Session2Command implements android.os.Parcelable {

/**
 * Constructor for creating a command predefined in AndroidX media2.
 *
 * @param commandCode A command code for a command predefined in AndroidX media2.
 * @apiSince 29
 */

public Session2Command(int commandCode) { throw new RuntimeException("Stub!"); }

/**
 * Constructor for creating a custom command.
 *
 * @param action The action of this custom command.
 * This value must never be {@code null}.
 * @param extras An extra bundle for this custom command.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public Session2Command(@androidx.annotation.NonNull java.lang.String action, @androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Gets the command code of a predefined command.
 * This will return {@link #COMMAND_CODE_CUSTOM} for a custom command.
 * @apiSince 29
 */

public int getCommandCode() { throw new RuntimeException("Stub!"); }

/**
 * Gets the action of a custom command.
 * This will return {@code null} for a predefined command.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getCustomAction() { throw new RuntimeException("Stub!"); }

/**
 * Gets the extra bundle of a custom command.
 * This will return {@code null} for a predefined command.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.os.Bundle getCustomExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param dest This value must never be {@code null}.
 * @apiSince 29
 */

public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param obj This value may be {@code null}.
 * @apiSince 29
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Command code for the custom command which can be defined by string action in the
 * {@link android.media.Session2Command Session2Command}.
 * @apiSince 29
 */

public static final int COMMAND_CODE_CUSTOM = 0; // 0x0

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.Session2Command> CREATOR;
static { CREATOR = null; }
/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Contains the result of {@link android.media.Session2Command Session2Command}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Result {

/**
 * Constructor of {@link android.media.Session2Command.Result Result}.
 *
 * @param resultCode result code
 * @param resultData result data
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public Result(int resultCode, @androidx.annotation.Nullable android.os.Bundle resultData) { throw new RuntimeException("Stub!"); }

/**
 * Returns the result code.
 * @apiSince 29
 */

public int getResultCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the result data.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.os.Bundle getResultData() { throw new RuntimeException("Stub!"); }

/**
 * Result code represents that call is ended with an unknown error.
 * @apiSince 29
 */

public static final int RESULT_ERROR_UNKNOWN_ERROR = -1; // 0xffffffff

/**
 * Result code representing that the command is skipped or canceled. For an example, a seek
 * command can be skipped if it is followed by another seek command.
 * @apiSince 29
 */

public static final int RESULT_INFO_SKIPPED = 1; // 0x1

/**
 * Result code representing that the command is successfully completed.
 * @apiSince 29
 */

public static final int RESULT_SUCCESS = 0; // 0x0
}

}

