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


package android.app;


/**
 * Represents a set of parameters used to initialize and update an Activity in picture-in-picture
 * mode.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PictureInPictureParams implements android.os.Parcelable {

PictureInPictureParams() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.PictureInPictureParams> CREATOR;
static { CREATOR = null; }
/**
 * Builder class for {@link android.app.PictureInPictureParams PictureInPictureParams} objects.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the aspect ratio.  This aspect ratio is defined as the desired width / height, and
 * does not change upon device rotation.
 *
 * @param aspectRatio the new aspect ratio for the activity in picture-in-picture, must be
 * between 2.39:1 and 1:2.39 (inclusive).
 *
 * @return this builder instance.
 * @apiSince 26
 */

public android.app.PictureInPictureParams.Builder setAspectRatio(android.util.Rational aspectRatio) { throw new RuntimeException("Stub!"); }

/**
 * Sets the user actions.  If there are more than
 * {@link android.app.Activity#getMaxNumPictureInPictureActions() Activity#getMaxNumPictureInPictureActions()} actions, then the input list
 * will be truncated to that number.
 *
 * @param actions the new actions to show in the picture-in-picture menu.
 *
 * @return this builder instance.
 *
 * @see android.app.RemoteAction
 * @apiSince 26
 */

public android.app.PictureInPictureParams.Builder setActions(java.util.List<android.app.RemoteAction> actions) { throw new RuntimeException("Stub!"); }

/**
 * Sets the source bounds hint. These bounds are only used when an activity first enters
 * picture-in-picture, and describe the bounds in window coordinates of activity entering
 * picture-in-picture that will be visible following the transition. For the best effect,
 * these bounds should also match the aspect ratio in the arguments.
 *
 * @param launchBounds window-coordinate bounds indicating the area of the activity that
 * will still be visible following the transition into picture-in-picture (eg. the video
 * view bounds in a video player)
 *
 * @return this builder instance.
 * @apiSince 26
 */

public android.app.PictureInPictureParams.Builder setSourceRectHint(android.graphics.Rect launchBounds) { throw new RuntimeException("Stub!"); }

/**
 * @return an immutable {@link android.app.PictureInPictureParams PictureInPictureParams} to be used when entering or updating
 * the activity in picture-in-picture.
 *
 * @see android.app.Activity#enterPictureInPictureMode(PictureInPictureParams)
 * @see android.app.Activity#setPictureInPictureParams(PictureInPictureParams)
 * @apiSince 26
 */

public android.app.PictureInPictureParams build() { throw new RuntimeException("Stub!"); }
}

}

