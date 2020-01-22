/**
 * Copyright (c) 2010, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.content;


/**
 * Interface to the clipboard service, for placing and retrieving text in
 * the global clipboard.
 *
 * <p>
 * The ClipboardManager API itself is very simple: it consists of methods
 * to atomically get and set the current primary clipboard data.  That data
 * is expressed as a {@link android.content.ClipData ClipData} object, which defines the protocol
 * for data exchange between applications.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using the clipboard framework, read the
 * <a href="{@docRoot}guide/topics/clipboard/copy-paste.html">Copy and Paste</a>
 * developer guide.</p>
 * </div>
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ClipboardManager extends android.text.ClipboardManager {

ClipboardManager() { throw new RuntimeException("Stub!"); }

/**
 * Sets the current primary clip on the clipboard.  This is the clip that
 * is involved in normal cut and paste operations.
 *
 * @param clip The clipped data item to set.
 * This value must never be {@code null}.
 * @see #getPrimaryClip()
 * @see #clearPrimaryClip()
 * @apiSince 11
 */

public void setPrimaryClip(@androidx.annotation.NonNull android.content.ClipData clip) { throw new RuntimeException("Stub!"); }

/**
 * Clears any current primary clip on the clipboard.
 *
 * @see #setPrimaryClip(ClipData)
 * @apiSince 28
 */

public void clearPrimaryClip() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current primary clip on the clipboard.
 *
 * <em>If the application is not the default IME or does not have input focus this return
 * {@code null}.</em>
 *
 * @see #setPrimaryClip(ClipData)
 * @apiSince 11
 */

@androidx.annotation.Nullable
public android.content.ClipData getPrimaryClip() { throw new RuntimeException("Stub!"); }

/**
 * Returns a description of the current primary clip on the clipboard
 * but not a copy of its data.
 *
 * <em>If the application is not the default IME or does not have input focus this return
 * {@code null}.</em>
 *
 * @see #setPrimaryClip(ClipData)
 * @apiSince 11
 */

@androidx.annotation.Nullable
public android.content.ClipDescription getPrimaryClipDescription() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if there is currently a primary clip on the clipboard.
 *
 * <em>If the application is not the default IME or the does not have input focus this will
 * return {@code false}.</em>
 * @apiSince 11
 */

public boolean hasPrimaryClip() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void addPrimaryClipChangedListener(android.content.ClipboardManager.OnPrimaryClipChangedListener what) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void removePrimaryClipChangedListener(android.content.ClipboardManager.OnPrimaryClipChangedListener what) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getPrimaryClip()} instead.  This retrieves
 * the primary clip and tries to coerce it to a string.
 * @apiSince 11
 */

@Deprecated
public java.lang.CharSequence getText() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #setPrimaryClip(android.content.ClipData)} instead.  This
 * creates a ClippedItem holding the given text and sets it as the
 * primary clip.  It has no label or icon.
 * @apiSince 11
 */

@Deprecated
public void setText(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #hasPrimaryClip()} instead.
 * @apiSince 11
 */

@Deprecated
public boolean hasText() { throw new RuntimeException("Stub!"); }
/**
 * Defines a listener callback that is invoked when the primary clip on the clipboard changes.
 * Objects that want to register a listener call
 * {@link android.content.ClipboardManager#addPrimaryClipChangedListener(OnPrimaryClipChangedListener)
 * addPrimaryClipChangedListener()} with an
 * object that implements OnPrimaryClipChangedListener.
 *
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnPrimaryClipChangedListener {

/**
 * Callback that is invoked by {@link android.content.ClipboardManager} when the primary
 * clip changes.
 * @apiSince 11
 */

public void onPrimaryClipChanged();
}

}

