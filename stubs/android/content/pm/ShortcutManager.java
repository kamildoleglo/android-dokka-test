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

package android.content.pm;

import java.util.List;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.os.Build.VERSION_CODES;
import android.content.IntentSender;
import android.content.Intent;

/**
 * <p><code>ShortcutManager</code> executes operations on an app's set of <i>shortcuts</i>, which
 * represent specific tasks and actions that users can perform within your app. This page lists
 * components of the <code>ShortcutManager</code> class that you can use to create and manage
 * sets of shortcuts.
 *
 * <p>To learn about methods that retrieve information about a single shortcut&mdash;including
 * identifiers, type, and status&mdash;read the <code>
 * <a href="/reference/android/content/pm/ShortcutInfo.html">ShortcutInfo</a></code> reference.
 *
 * <p>For guidance about using shortcuts, see
 * <a href="/guide/topics/ui/shortcuts/index.html">App shortcuts</a>.
 *
 * <h3>Retrieving class instances</h3>
 * <!-- Provides a heading for the content filled in by the @SystemService annotation below -->
 * @apiSince 25
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ShortcutManager {

ShortcutManager() { throw new RuntimeException("Stub!"); }

/**
 * Publish the list of shortcuts.  All existing dynamic shortcuts from the caller app
 * will be replaced.  If there are already pinned shortcuts with the same IDs,
 * the mutable pinned shortcuts are updated.
 *
 * <p>This API will be rate-limited.
 *
 * @param shortcutInfoList This value must never be {@code null}.
 * @return {@code true} if the call has succeeded. {@code false} if the call is rate-limited.
 *
 * @throws java.lang.IllegalArgumentException if {@link #getMaxShortcutCountPerActivity()} is exceeded,
 * or when trying to update immutable shortcuts.
 *
 * @throws java.lang.IllegalStateException when the user is locked.
 * @apiSince 25
 */

public boolean setDynamicShortcuts(@androidx.annotation.NonNull java.util.List<android.content.pm.ShortcutInfo> shortcutInfoList) { throw new RuntimeException("Stub!"); }

/**
 * Return all dynamic shortcuts from the caller app.
 *
 * <p>This API is intended to be used for examining what shortcuts are currently published.
 * Re-publishing returned {@link android.content.pm.ShortcutInfo ShortcutInfo}s via APIs such as
 * {@link #setDynamicShortcuts(java.util.List)} may cause loss of information such as icons.
 *
 * @throws java.lang.IllegalStateException when the user is locked.
 
 * @return This value will never be {@code null}.
 * @apiSince 25
 */

@androidx.annotation.NonNull
public java.util.List<android.content.pm.ShortcutInfo> getDynamicShortcuts() { throw new RuntimeException("Stub!"); }

/**
 * Return all static (manifest) shortcuts from the caller app.
 *
 * <p>This API is intended to be used for examining what shortcuts are currently published.
 * Re-publishing returned {@link android.content.pm.ShortcutInfo ShortcutInfo}s via APIs such as
 * {@link #setDynamicShortcuts(java.util.List)} may cause loss of information such as icons.
 *
 * @throws java.lang.IllegalStateException when the user is locked.
 
 * @return This value will never be {@code null}.
 * @apiSince 25
 */

@androidx.annotation.NonNull
public java.util.List<android.content.pm.ShortcutInfo> getManifestShortcuts() { throw new RuntimeException("Stub!"); }

/**
 * Publish the list of dynamic shortcuts.  If there are already dynamic or pinned shortcuts with
 * the same IDs, each mutable shortcut is updated.
 *
 * <p>This API will be rate-limited.
 *
 * @param shortcutInfoList This value must never be {@code null}.
 * @return {@code true} if the call has succeeded. {@code false} if the call is rate-limited.
 *
 * @throws java.lang.IllegalArgumentException if {@link #getMaxShortcutCountPerActivity()} is exceeded,
 * or when trying to update immutable shortcuts.
 *
 * @throws java.lang.IllegalStateException when the user is locked.
 * @apiSince 25
 */

public boolean addDynamicShortcuts(@androidx.annotation.NonNull java.util.List<android.content.pm.ShortcutInfo> shortcutInfoList) { throw new RuntimeException("Stub!"); }

/**
 * Delete dynamic shortcuts by ID.
 *
 * @throws java.lang.IllegalStateException when the user is locked.
 
 * @param shortcutIds This value must never be {@code null}.
 * @apiSince 25
 */

public void removeDynamicShortcuts(@androidx.annotation.NonNull java.util.List<java.lang.String> shortcutIds) { throw new RuntimeException("Stub!"); }

/**
 * Delete all dynamic shortcuts from the caller app.
 *
 * @throws java.lang.IllegalStateException when the user is locked.
 * @apiSince 25
 */

public void removeAllDynamicShortcuts() { throw new RuntimeException("Stub!"); }

/**
 * Return all pinned shortcuts from the caller app.
 *
 * <p>This API is intended to be used for examining what shortcuts are currently published.
 * Re-publishing returned {@link android.content.pm.ShortcutInfo ShortcutInfo}s via APIs such as
 * {@link #setDynamicShortcuts(java.util.List)} may cause loss of information such as icons.
 *
 * @throws java.lang.IllegalStateException when the user is locked.
 
 * @return This value will never be {@code null}.
 * @apiSince 25
 */

@androidx.annotation.NonNull
public java.util.List<android.content.pm.ShortcutInfo> getPinnedShortcuts() { throw new RuntimeException("Stub!"); }

/**
 * Update all existing shortcuts with the same IDs.  Target shortcuts may be pinned and/or
 * dynamic, but they must not be immutable.
 *
 * <p>This API will be rate-limited.
 *
 * @param shortcutInfoList This value must never be {@code null}.
 * @return {@code true} if the call has succeeded. {@code false} if the call is rate-limited.
 *
 * @throws java.lang.IllegalArgumentException If trying to update immutable shortcuts.
 *
 * @throws java.lang.IllegalStateException when the user is locked.
 * @apiSince 25
 */

public boolean updateShortcuts(@androidx.annotation.NonNull java.util.List<android.content.pm.ShortcutInfo> shortcutInfoList) { throw new RuntimeException("Stub!"); }

/**
 * Disable pinned shortcuts.  For more details, read
 * <a href="/guide/topics/ui/shortcuts/managing-shortcuts.html#disable-shortcuts">
 * Disable shortcuts</a>.
 *
 * @throws java.lang.IllegalArgumentException If trying to disable immutable shortcuts.
 *
 * @throws java.lang.IllegalStateException when the user is locked.
 
 * @param shortcutIds This value must never be {@code null}.
 * @apiSince 25
 */

public void disableShortcuts(@androidx.annotation.NonNull java.util.List<java.lang.String> shortcutIds) { throw new RuntimeException("Stub!"); }

/**
 * Disable pinned shortcuts, showing the user a custom error message when they try to select
 * the disabled shortcuts.
 * For more details, read
 * <a href="/guide/topics/ui/shortcuts/managing-shortcuts.html#disable-shortcuts">
 * Disable shortcuts</a>.
 *
 * @throws java.lang.IllegalArgumentException If trying to disable immutable shortcuts.
 *
 * @throws java.lang.IllegalStateException when the user is locked.
 
 * @param shortcutIds This value must never be {@code null}.
 * @apiSince 25
 */

public void disableShortcuts(@androidx.annotation.NonNull java.util.List<java.lang.String> shortcutIds, java.lang.CharSequence disabledMessage) { throw new RuntimeException("Stub!"); }

/**
 * Re-enable pinned shortcuts that were previously disabled.  If the target shortcuts
 * are already enabled, this method does nothing.
 *
 * @throws java.lang.IllegalArgumentException If trying to enable immutable shortcuts.
 *
 * @throws java.lang.IllegalStateException when the user is locked.
 
 * @param shortcutIds This value must never be {@code null}.
 * @apiSince 25
 */

public void enableShortcuts(@androidx.annotation.NonNull java.util.List<java.lang.String> shortcutIds) { throw new RuntimeException("Stub!"); }

/**
 * Return the maximum number of static and dynamic shortcuts that each launcher icon
 * can have at a time.
 * @apiSince 25
 */

public int getMaxShortcutCountPerActivity() { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} when rate-limiting is active for the caller app.
 *
 * <p>For details, see <a href="/guide/topics/ui/shortcuts/managing-shortcuts#rate-limiting">
 * Rate limiting</a>.
 *
 * @throws java.lang.IllegalStateException when the user is locked.
 * @apiSince 25
 */

public boolean isRateLimitingActive() { throw new RuntimeException("Stub!"); }

/**
 * Return the max width for icons, in pixels.
 *
 * <p> Note that this method returns max width of icon's visible part. Hence, it does not take
 * into account the inset introduced by {@link android.graphics.drawable.AdaptiveIconDrawable AdaptiveIconDrawable}. To calculate bitmap image
 * to function as {@link android.graphics.drawable.AdaptiveIconDrawable AdaptiveIconDrawable}, multiply
 * 1 + 2 * {@link android.graphics.drawable.AdaptiveIconDrawable#getExtraInsetFraction() AdaptiveIconDrawable#getExtraInsetFraction()} to the returned size.
 * @apiSince 25
 */

public int getIconMaxWidth() { throw new RuntimeException("Stub!"); }

/**
 * Return the max height for icons, in pixels.
 * @apiSince 25
 */

public int getIconMaxHeight() { throw new RuntimeException("Stub!"); }

/**
 * Apps that publish shortcuts should call this method whenever the user
 * selects the shortcut containing the given ID or when the user completes
 * an action in the app that is equivalent to selecting the shortcut.
 * For more details, read about
 * <a href="/guide/topics/ui/shortcuts/managing-shortcuts.html#track-usage">
 * tracking shortcut usage</a>.
 *
 * <p>The information is accessible via {@link android.app.usage.UsageStatsManager#queryEvents UsageStatsManager#queryEvents}
 * Typically, launcher apps use this information to build a prediction model
 * so that they can promote the shortcuts that are likely to be used at the moment.
 *
 * @throws java.lang.IllegalStateException when the user is locked.
 * @apiSince 25
 */

public void reportShortcutUsed(java.lang.String shortcutId) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code TRUE} if the app is running on a device whose default launcher supports
 * {@link #requestPinShortcut(android.content.pm.ShortcutInfo,android.content.IntentSender)}.
 *
 * <p>The return value may change in subsequent calls if the user changes the default launcher
 * app.
 *
 * <p><b>Note:</b> See also the support library counterpart
 * {@link android.support.v4.content.pm.ShortcutManagerCompat#isRequestPinShortcutSupported(
 * Context)}, which supports Android versions lower than {@link android.os.Build.VERSION_CODES#O VERSION_CODES#O} using the
 * legacy private intent {@code com.android.launcher.action.INSTALL_SHORTCUT}.
 *
 * @see #requestPinShortcut(ShortcutInfo, IntentSender)
 * @apiSince 26
 */

public boolean isRequestPinShortcutSupported() { throw new RuntimeException("Stub!"); }

/**
 * Request to create a pinned shortcut.  The default launcher will receive this request and
 * ask the user for approval.  If the user approves it, the shortcut will be created, and
 * {@code resultIntent} will be sent. If a request is denied by the user, however, no response
 * will be sent to the caller.
 *
 * <p>Only apps with a foreground activity or a foreground service can call this method.
 * Otherwise, it'll throw {@link java.lang.IllegalStateException IllegalStateException}.
 *
 * <p>It's up to the launcher to decide how to handle previous pending requests when the same
 * package calls this API multiple times in a row. One possible strategy is to ignore any
 * previous requests.
 *
 * <p><b>Note:</b> See also the support library counterpart
 * {@link android.support.v4.content.pm.ShortcutManagerCompat#requestPinShortcut(
 * Context, ShortcutInfoCompat, IntentSender)},
 * which supports Android versions lower than {@link android.os.Build.VERSION_CODES#O VERSION_CODES#O} using the
 * legacy private intent {@code com.android.launcher.action.INSTALL_SHORTCUT}.
 *
 * @param shortcut Shortcut to pin.  If an app wants to pin an existing (either static
 *     or dynamic) shortcut, then it only needs to have an ID. Although other fields don't have
 *     to be set, the target shortcut must be enabled.
 *
 *     <p>If it's a new shortcut, all the mandatory fields, such as a short label, must be
 *     set.
 * This value must never be {@code null}.
 * @param resultIntent If not null, this intent will be sent when the shortcut is pinned.
 *    Use {@link android.app.PendingIntent#getIntentSender()} to create an {@link android.content.IntentSender IntentSender}.
 *    To avoid background execution limits, use an unexported, manifest-declared receiver.
 *    For more details, see
 *    <a href="/guide/topics/ui/shortcuts/creating-shortcuts.html#pinned">
 *    Creating pinned shortcuts</a>.
 *
 * This value may be {@code null}.
 * @return {@code TRUE} if the launcher supports this feature.  Note the API will return without
 *    waiting for the user to respond, so getting {@code TRUE} from this API does *not* mean
 *    the shortcut was pinned successfully.  {@code FALSE} if the launcher doesn't support this
 *    feature.
 *
 * @see #isRequestPinShortcutSupported()
 * @see android.content.IntentSender
 * @see android.app.PendingIntent#getIntentSender()
 *
 * @throws java.lang.IllegalArgumentException if a shortcut with the same ID exists and is disabled.
 * @throws java.lang.IllegalStateException The caller doesn't have a foreground activity or a foreground
 * service, or the device is locked.
 * @apiSince 26
 */

public boolean requestPinShortcut(@androidx.annotation.NonNull android.content.pm.ShortcutInfo shortcut, @androidx.annotation.Nullable android.content.IntentSender resultIntent) { throw new RuntimeException("Stub!"); }

/**
 * Returns an Intent which can be used by the default launcher to pin a shortcut containing the
 * given {@link android.content.pm.ShortcutInfo ShortcutInfo}. This method should be used by an Activity to set a result in
 * response to {@link android.content.Intent#ACTION_CREATE_SHORTCUT Intent#ACTION_CREATE_SHORTCUT}.
 *
 * @param shortcut New shortcut to pin.  If an app wants to pin an existing (either dynamic
 *     or manifest) shortcut, then it only needs to have an ID, and other fields don't have to
 *     be set, in which case, the target shortcut must be enabled.
 *     If it's a new shortcut, all the mandatory fields, such as a short label, must be
 *     set.
 * This value must never be {@code null}.
 * @return The intent that should be set as the result for the calling activity, or
 *     <code>null</code> if the current launcher doesn't support shortcuts.
 *
 * @see android.content.Intent#ACTION_CREATE_SHORTCUT
 *
 * @throws java.lang.IllegalArgumentException if a shortcut with the same ID exists and is disabled.
 * @apiSince 26
 */

public android.content.Intent createShortcutResultIntent(@androidx.annotation.NonNull android.content.pm.ShortcutInfo shortcut) { throw new RuntimeException("Stub!"); }
}

