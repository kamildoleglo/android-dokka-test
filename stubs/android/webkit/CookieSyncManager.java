/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.webkit;

import android.content.Context;

/**
 * The CookieSyncManager is used to synchronize the browser cookie store
 * between RAM and permanent storage. To get the best performance, browser cookies are
 * saved in RAM. A separate thread saves the cookies between, driven by a timer.
 * <p>
 *
 * To use the CookieSyncManager, the host application has to call the following
 * when the application starts:
 * <p>
 *
 * <pre class="prettyprint">CookieSyncManager.createInstance(context)</pre><p>
 *
 * To set up for sync, the host application has to call<p>
 * <pre class="prettyprint">CookieSyncManager.getInstance().startSync()</pre><p>
 *
 * in Activity.onResume(), and call
 * <p>
 *
 * <pre class="prettyprint">
 * CookieSyncManager.getInstance().stopSync()
 * </pre><p>
 *
 * in Activity.onPause().<p>
 *
 * To get instant sync instead of waiting for the timer to trigger, the host can
 * call
 * <p>
 * <pre class="prettyprint">CookieSyncManager.getInstance().sync()</pre><p>
 *
 * The sync interval is 5 minutes, so you will want to force syncs
 * manually anyway, for instance in {@link android.webkit.WebViewClient#onPageFinished WebViewClient#onPageFinished}. Note that even sync() happens
 * asynchronously, so don't do it just as your activity is shutting
 * down.
 *
 * @deprecated The WebView now automatically syncs cookies as necessary.
 *             You no longer need to create or use the CookieSyncManager.
 *             To manually force a sync you can use the CookieManager
 *             method {@link android.webkit.CookieManager#flush CookieManager#flush} which is a synchronous
 *             replacement for {@link #sync}.
 * @apiSince 1
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public final class CookieSyncManager implements java.lang.Runnable {

private CookieSyncManager() { throw new RuntimeException("Stub!"); }

/**
 * Singleton access to a {@link android.webkit.CookieSyncManager CookieSyncManager}. An
 * IllegalStateException will be thrown if
 * {@link android.webkit.CookieSyncManager#createInstance(android.content.Context) CookieSyncManager#createInstance(Context)} is not called before.
 *
 * @return CookieSyncManager
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public static android.webkit.CookieSyncManager getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Create a singleton CookieSyncManager within a context
 * @param context
 * @return CookieSyncManager
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public static android.webkit.CookieSyncManager createInstance(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * sync() forces sync manager to sync now
 * @deprecated Use {@link android.webkit.CookieManager#flush CookieManager#flush} instead.
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated
public void sync() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link android.webkit.CookieManager#flush CookieManager#flush} instead.
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
protected void syncFromRamToFlash() { throw new RuntimeException("Stub!"); }

/**
 * resetSync() resets sync manager's timer.
 * @deprecated Calling resetSync is no longer necessary as the WebView automatically
 *             syncs cookies.
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated
public void resetSync() { throw new RuntimeException("Stub!"); }

/**
 * startSync() requests sync manager to start sync.
 * @deprecated Calling startSync is no longer necessary as the WebView automatically
 *             syncs cookies.
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated
public void startSync() { throw new RuntimeException("Stub!"); }

/**
 * stopSync() requests sync manager to stop sync. remove any SYNC_MESSAGE in
 * the queue to break the sync loop
 * @deprecated Calling stopSync is no longer useful as the WebView
 *             automatically syncs cookies.
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated
public void stopSync() { throw new RuntimeException("Stub!"); }

@Deprecated
public void run() { throw new RuntimeException("Stub!"); }
}

