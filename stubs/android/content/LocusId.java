/*
 * Copyright (C) 2019 The Android Open Source Project
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

package android.content;

import android.view.contentcapture.ContentCaptureManager;

/**
 * An identifier for an unique state (locus) in the application. Should be stable across reboots and
 * backup / restore.
 *
 * <p>Locus is a new concept introduced on
 * {@link android.os.Build.VERSION_CODES#Q Android Q} and it lets the Android system correlate
 * state between different subsystems such as content capture, shortcuts, and notifications.
 *
 * <p>For example, if your app provides an activiy representing a chat between 2 users
 * (say {@code A} and {@code B}, this chat state could be represented by:
 *
 * <pre><code>
 * LocusId chatId = new LocusId("Chat_A_B");
 * </code></pre>
 *
 * <p>And then you should use that {@code chatId} by:
 *
 * <ul>
 *   <li>Setting it in the chat notification (through
 *   {@link android.app.Notification.Builder#setLocusId(LocusId)
 *   Notification.Builder.setLocusId(chatId)}).
 *   <li>Setting it into the {@link android.content.pm.ShortcutInfo} (through
 *   {@link android.content.pm.ShortcutInfo.Builder#setLocusId(LocusId)
 *   ShortcutInfo.Builder.setLocusId(chatId)}), if you provide a launcher shortcut for that chat
 *   conversation.
 *   <li>Associating it with the {@link android.view.contentcapture.ContentCaptureContext} of the
 *   root view of the chat conversation activity (through
 *   {@link android.view.View#getContentCaptureSession()}, then
 *   {@link android.view.contentcapture.ContentCaptureContext.Builder
 *   new ContentCaptureContext.Builder(chatId).build()} and
 *   {@link android.view.contentcapture.ContentCaptureSession#setContentCaptureContext(
 *   android.view.contentcapture.ContentCaptureContext)} - see {@link android.view.contentcapture.ContentCaptureManager ContentCaptureManager}
 *   for more info about content capture).
 *   <li>Configuring your app to launch the chat conversation through the
 *   {@link android.content.Intent#ACTION_VIEW_LOCUS Intent#ACTION_VIEW_LOCUS} intent.
 * </ul>
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class LocusId implements android.os.Parcelable {

/**
 * Default constructor.
 *
 * @throws java.lang.IllegalArgumentException if {@code id} is empty or {@code null}.
 
 * @param id This value must never be {@code null}.
 * @apiSince 29
 */

public LocusId(@androidx.annotation.NonNull java.lang.String id) { throw new RuntimeException("Stub!"); }

/**
 * Gets the canonical {@code id} associated with the locus.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.LocusId> CREATOR;
static { CREATOR = null; }
}

