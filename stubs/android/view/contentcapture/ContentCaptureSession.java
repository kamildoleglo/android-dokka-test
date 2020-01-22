/*
 * Copyright (C) 2018 The Android Open Source Project
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

package android.view.contentcapture;

import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;

/**
 * Session used when notifying the Android system about events associated with views.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ContentCaptureSession implements java.lang.AutoCloseable {

ContentCaptureSession() { throw new RuntimeException("Stub!"); }

/**
 * Gets the id used to identify this session.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public final android.view.contentcapture.ContentCaptureSessionId getContentCaptureSessionId() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link android.view.contentcapture.ContentCaptureSession ContentCaptureSession}.
 *
 * <p>See {@link android.view.View#setContentCaptureSession(android.view.contentcapture.ContentCaptureSession) View#setContentCaptureSession(ContentCaptureSession)} for more info.
 
 * @param context This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public final android.view.contentcapture.ContentCaptureSession createContentCaptureSession(@androidx.annotation.NonNull android.view.contentcapture.ContentCaptureContext context) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.view.contentcapture.ContentCaptureContext ContentCaptureContext} associated with the session.
 *
 * <p>Typically used to change the context associated with the default session from an activity.
 
 * @param context This value may be {@code null}.
 * @apiSince 29
 */

public final void setContentCaptureContext(@androidx.annotation.Nullable android.view.contentcapture.ContentCaptureContext context) { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.view.contentcapture.ContentCaptureContext ContentCaptureContext} associated with the session.
 *
 * @return context set on constructor or by
 *         {@link #setContentCaptureContext(android.view.contentcapture.ContentCaptureContext)}, or {@code null} if never
 *         explicitly set.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public final android.view.contentcapture.ContentCaptureContext getContentCaptureContext() { throw new RuntimeException("Stub!"); }

/**
 * Destroys this session, flushing out all pending notifications.
 *
 * <p>Once destroyed, any new notification will be dropped.
 * @apiSince 29
 */

public final void destroy() { throw new RuntimeException("Stub!"); }

/** @hide */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the Android system that a node has been added to the view structure.
 *
 * @param node node that has been added.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public final void notifyViewAppeared(@androidx.annotation.NonNull android.view.ViewStructure node) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the Android system that a node has been removed from the view structure.
 *
 * @param id id of the node that has been removed.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public final void notifyViewDisappeared(@androidx.annotation.NonNull android.view.autofill.AutofillId id) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the Android system that many nodes has been removed from a virtual view
 * structure.
 *
 * <p>Should only be called by views that handle their own virtual view hierarchy.
 *
 * @param hostId id of the non-virtual view hosting the virtual view hierarchy (it can be
 * obtained by calling {@link android.view.ViewStructure#getAutofillId() ViewStructure#getAutofillId()}).
 * This value must never be {@code null}.
 * @param virtualIds ids of the virtual children.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the {@code hostId} is an autofill id for a virtual view.
 * @throws java.lang.IllegalArgumentException if {@code virtualIds} is empty
 * @apiSince 29
 */

public final void notifyViewsDisappeared(@androidx.annotation.NonNull android.view.autofill.AutofillId hostId, @androidx.annotation.NonNull long[] virtualIds) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the Android system that the value of a text node has been changed.
 *
 * @param id of the node.
 * This value must never be {@code null}.
 * @param text new text.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public final void notifyViewTextChanged(@androidx.annotation.NonNull android.view.autofill.AutofillId id, @androidx.annotation.Nullable java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.view.ViewStructure ViewStructure} for a "standard" view.
 *
 * <p>This method should be called after a visible view is laid out; the view then must populate
 * the structure and pass it to {@link #notifyViewAppeared(android.view.ViewStructure)}.
 *
 * <b>Note: </b>views that manage a virtual structure under this view must populate just the
 * node representing this view and return right away, then asynchronously report (not
 * necessarily in the UI thread) when the children nodes appear, disappear or have their text
 * changed by calling {@link android.view.contentcapture.ContentCaptureSession#notifyViewAppeared(android.view.ViewStructure) ContentCaptureSession#notifyViewAppeared(ViewStructure)},
 * {@link android.view.contentcapture.ContentCaptureSession#notifyViewDisappeared(android.view.autofill.AutofillId) ContentCaptureSession#notifyViewDisappeared(AutofillId)}, and
 * {@link android.view.contentcapture.ContentCaptureSession#notifyViewTextChanged(android.view.autofill.AutofillId,java.lang.CharSequence) ContentCaptureSession#notifyViewTextChanged(AutofillId, CharSequence)} respectively.
 * The structure for the a child must be created using
 * {@link android.view.contentcapture.ContentCaptureSession#newVirtualViewStructure(android.view.autofill.AutofillId,long) ContentCaptureSession#newVirtualViewStructure(AutofillId, long)}, and the
 * {@code autofillId} for a child can be obtained either through
 * {@code childStructure.getAutofillId()} or
 * {@link android.view.contentcapture.ContentCaptureSession#newAutofillId(android.view.autofill.AutofillId,long) ContentCaptureSession#newAutofillId(AutofillId, long)}.
 *
 * <p>When the virtual view hierarchy represents a web page, you should also:
 *
 * <ul>
 * <li>Call {@link android.view.contentcapture.ContentCaptureManager#getContentCaptureConditions() ContentCaptureManager#getContentCaptureConditions()} to infer content capture
 * events should be generate for that URL.
 * <li>Create a new {@link android.view.contentcapture.ContentCaptureSession ContentCaptureSession} child for every HTML element that renders a
 * new URL (like an {@code IFRAME}) and use that session to notify events from that subtree.
 * </ul>
 *
 * <p><b>Note: </b>the following methods of the {@code structure} will be ignored:
 * <ul>
 * <li>{@link android.view.ViewStructure#setChildCount(int) ViewStructure#setChildCount(int)}
 * <li>{@link android.view.ViewStructure#addChildCount(int) ViewStructure#addChildCount(int)}
 * <li>{@link android.view.ViewStructure#getChildCount() ViewStructure#getChildCount()}
 * <li>{@link android.view.ViewStructure#newChild(int) ViewStructure#newChild(int)}
 * <li>{@link android.view.ViewStructure#asyncNewChild(int) ViewStructure#asyncNewChild(int)}
 * <li>{@link android.view.ViewStructure#asyncCommit() ViewStructure#asyncCommit()}
 * <li>{@link android.view.ViewStructure#setWebDomain(java.lang.String) ViewStructure#setWebDomain(String)}
 * <li>{@link android.view.ViewStructure#newHtmlInfoBuilder(java.lang.String) ViewStructure#newHtmlInfoBuilder(String)}
 * <li>{@link android.view.ViewStructure#setHtmlInfo(android.view.ViewStructure.HtmlInfo) ViewStructure#setHtmlInfo(android.view.ViewStructure.HtmlInfo)}
 * <li>{@link android.view.ViewStructure#setDataIsSensitive(boolean) ViewStructure#setDataIsSensitive(boolean)}
 * <li>{@link android.view.ViewStructure#setAlpha(float) ViewStructure#setAlpha(float)}
 * <li>{@link android.view.ViewStructure#setElevation(float) ViewStructure#setElevation(float)}
 * <li>{@link android.view.ViewStructure#setTransformation(android.graphics.Matrix) ViewStructure#setTransformation(android.graphics.Matrix)}
 * </ul>
 
 * @param view This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public final android.view.ViewStructure newViewStructure(@androidx.annotation.NonNull android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link android.view.autofill.AutofillId AutofillId} for a virtual child, so it can be used to uniquely identify
 * the children in the session.
 *
 * @param hostId id of the non-virtual view hosting the virtual view hierarchy (it can be
 * obtained by calling {@link android.view.ViewStructure#getAutofillId() ViewStructure#getAutofillId()}).
 * This value must never be {@code null}.
 * @param virtualChildId id of the virtual child, relative to the parent.
 *
 * @return if for the virtual child
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the {@code parentId} is a virtual child id.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.autofill.AutofillId newAutofillId(@androidx.annotation.NonNull android.view.autofill.AutofillId hostId, long virtualChildId) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.view.ViewStructure ViewStructure} for a "virtual" view, so it can be passed to
 * {@link #notifyViewAppeared(android.view.ViewStructure)} by the view managing the virtual view hierarchy.
 *
 * @param parentId id of the virtual view parent (it can be obtained by calling
 * {@link android.view.ViewStructure#getAutofillId() ViewStructure#getAutofillId()} on the parent).
 * This value must never be {@code null}.
 * @param virtualId id of the virtual child, relative to the parent.
 *
 * @return a new {@link android.view.ViewStructure ViewStructure} that can be used for Content Capture purposes.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public final android.view.ViewStructure newVirtualViewStructure(@androidx.annotation.NonNull android.view.autofill.AutofillId parentId, long virtualId) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

