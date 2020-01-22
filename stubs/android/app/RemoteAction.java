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
 * Represents a remote action that can be called from another process.  The action can have an
 * associated visualization including metadata like an icon or title.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RemoteAction implements android.os.Parcelable {

/**
 * @param icon This value must never be {@code null}.
 
 * @param title This value must never be {@code null}.
 
 * @param contentDescription This value must never be {@code null}.
 
 * @param intent This value must never be {@code null}.
 * @apiSince 26
 */

public RemoteAction(@androidx.annotation.NonNull android.graphics.drawable.Icon icon, @androidx.annotation.NonNull java.lang.CharSequence title, @androidx.annotation.NonNull java.lang.CharSequence contentDescription, @androidx.annotation.NonNull android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this action is enabled.
 * @apiSince 26
 */

public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Return whether this action is enabled.
 * @apiSince 26
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the icon should be shown.
 * @apiSince 28
 */

public void setShouldShowIcon(boolean shouldShowIcon) { throw new RuntimeException("Stub!"); }

/**
 * Return whether the icon should be shown.
 * @apiSince 28
 */

public boolean shouldShowIcon() { throw new RuntimeException("Stub!"); }

/**
 * Return an icon representing the action.
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.graphics.drawable.Icon getIcon() { throw new RuntimeException("Stub!"); }

/**
 * Return an title representing the action.
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.lang.CharSequence getTitle() { throw new RuntimeException("Stub!"); }

/**
 * Return a content description representing the action.
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.lang.CharSequence getContentDescription() { throw new RuntimeException("Stub!"); }

/**
 * Return the action intent.
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.app.PendingIntent getActionIntent() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public android.app.RemoteAction clone() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void dump(java.lang.String prefix, java.io.PrintWriter pw) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.RemoteAction> CREATOR;
static { CREATOR = null; }
}

