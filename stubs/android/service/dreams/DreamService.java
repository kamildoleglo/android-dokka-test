/**
 * Copyright (C) 2012 The Android Open Source Project
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

package android.service.dreams;

import android.app.Service;
import android.view.WindowManager;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.ViewGroup;
import android.view.View;
import android.content.Intent;

/**
 * Extend this class to implement a custom dream (available to the user as a "Daydream").
 *
 * <p>Dreams are interactive screensavers launched when a charging device is idle, or docked in a
 * desk dock. Dreams provide another modality for apps to express themselves, tailored for
 * an exhibition/lean-back experience.</p>
 *
 * <p>The {@code DreamService} lifecycle is as follows:</p>
 * <ol>
 *   <li>{@link #onAttachedToWindow}
 *     <p>Use this for initial setup, such as calling {@link #setContentView setContentView()}.</li>
 *   <li>{@link #onDreamingStarted}
 *     <p>Your dream has started, so you should begin animations or other behaviors here.</li>
 *   <li>{@link #onDreamingStopped}
 *     <p>Use this to stop the things you started in {@link #onDreamingStarted}.</li>
 *   <li>{@link #onDetachedFromWindow}
 *     <p>Use this to dismantle resources (for example, detach from handlers
 *        and listeners).</li>
 * </ol>
 *
 * <p>In addition, onCreate and onDestroy (from the Service interface) will also be called, but
 * initialization and teardown should be done by overriding the hooks above.</p>
 *
 * <p>To be available to the system, your {@code DreamService} should be declared in the
 * manifest as follows:</p>
 * <pre>
 * &lt;service
 *     android:name=".MyDream"
 *     android:exported="true"
 *     android:icon="@drawable/my_icon"
 *     android:label="@string/my_dream_label" >
 *
 *     &lt;intent-filter>
 *         &lt;action android:name="android.service.dreams.DreamService" />
 *         &lt;category android:name="android.intent.category.DEFAULT" />
 *     &lt;/intent-filter>
 *
 *     &lt;!-- Point to additional information for this dream (optional) -->
 *     &lt;meta-data
 *         android:name="android.service.dream"
 *         android:resource="@xml/my_dream" />
 * &lt;/service>
 * </pre>
 *
 * <p>If specified with the {@code <meta-data>} element,
 * additional information for the dream is defined using the
 * {@link android.R.styleable#Dream &lt;dream&gt;} element in a separate XML file.
 * Currently, the only addtional
 * information you can provide is for a settings activity that allows the user to configure
 * the dream behavior. For example:</p>
 * <p class="code-caption">res/xml/my_dream.xml</p>
 * <pre>
 * &lt;dream xmlns:android="http://schemas.android.com/apk/res/android"
 *     android:settingsActivity="com.example.app/.MyDreamSettingsActivity" />
 * </pre>
 * <p>This makes a Settings button available alongside your dream's listing in the
 * system settings, which when pressed opens the specified activity.</p>
 *
 *
 * <p>To specify your dream layout, call {@link #setContentView}, typically during the
 * {@link #onAttachedToWindow} callback. For example:</p>
 * <pre>
 * public class MyDream extends DreamService {
 *
 *     &#64;Override
 *     public void onAttachedToWindow() {
 *         super.onAttachedToWindow();
 *
 *         // Exit dream upon user touch
 *         setInteractive(false);
 *         // Hide system UI
 *         setFullscreen(true);
 *         // Set the dream layout
 *         setContentView(R.layout.dream);
 *     }
 * }
 * </pre>
 *
 * <p>When targeting api level 21 and above, you must declare the service in your manifest file
 * with the {@link android.Manifest.permission#BIND_DREAM_SERVICE} permission. For example:</p>
 * <pre>
 * &lt;service
 *     android:name=".MyDream"
 *     android:exported="true"
 *     android:icon="@drawable/my_icon"
 *     android:label="@string/my_dream_label"
 *     android:permission="android.permission.BIND_DREAM_SERVICE">
 *   &lt;intent-filter>
 *     &lt;action android:name=”android.service.dreams.DreamService” />
 *     &lt;category android:name=”android.intent.category.DEFAULT” />
 *   &lt;/intent-filter>
 * &lt;/service>
 * </pre>
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DreamService extends android.app.Service implements android.view.Window.Callback {

/** @apiSince 17 */

public DreamService() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public boolean dispatchKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public boolean dispatchKeyShortcutEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public boolean dispatchTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public boolean dispatchTrackballEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public boolean dispatchGenericMotionEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public android.view.View onCreatePanelView(int featureId) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public boolean onCreatePanelMenu(int featureId, android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public boolean onPreparePanel(int featureId, android.view.View view, android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public boolean onMenuOpened(int featureId, android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public boolean onMenuItemSelected(int featureId, android.view.MenuItem item) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams attrs) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public void onContentChanged() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public void onWindowFocusChanged(boolean hasFocus) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public void onPanelClosed(int featureId, android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 23
 */

public boolean onSearchRequested(android.view.SearchEvent event) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public boolean onSearchRequested() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 23
 */

public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int type) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public void onActionModeStarted(android.view.ActionMode mode) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public void onActionModeFinished(android.view.ActionMode mode) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the current {@link android.view.WindowManager} for the dream.
 * Behaves similarly to {@link android.app.Activity#getWindowManager()}.
 *
 * @return The current window manager, or null if the dream is not started.
 * @apiSince 17
 */

public android.view.WindowManager getWindowManager() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the current {@link android.view.Window} for the dream.
 * Behaves similarly to {@link android.app.Activity#getWindow()}.
 *
 * @return The current window, or null if the dream is not started.
 * @apiSince 17
 */

public android.view.Window getWindow() { throw new RuntimeException("Stub!"); }

/**
 * Inflates a layout resource and set it to be the content view for this Dream.
 * Behaves similarly to {@link android.app.Activity#setContentView(int)}.
 *
 * <p>Note: Requires a window, do not call before {@link #onAttachedToWindow()}</p>
 *
 * @param layoutResID Resource ID to be inflated.
 *
 * @see #setContentView(android.view.View)
 * @see #setContentView(android.view.View, android.view.ViewGroup.LayoutParams)
 * @apiSince 17
 */

public void setContentView(int layoutResID) { throw new RuntimeException("Stub!"); }

/**
 * Sets a view to be the content view for this Dream.
 * Behaves similarly to {@link android.app.Activity#setContentView(android.view.View)} in an activity,
 * including using {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT ViewGroup.LayoutParams#MATCH_PARENT} as the layout height and width of the view.
 *
 * <p>Note: This requires a window, so you should usually call it during
 * {@link #onAttachedToWindow()} and never earlier (you <strong>cannot</strong> call it
 * during {@link #onCreate}).</p>
 *
 * @see #setContentView(int)
 * @see #setContentView(android.view.View, android.view.ViewGroup.LayoutParams)
 * @apiSince 17
 */

public void setContentView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Sets a view to be the content view for this Dream.
 * Behaves similarly to
 * {@link android.app.Activity#setContentView(android.view.View, android.view.ViewGroup.LayoutParams)}
 * in an activity.
 *
 * <p>Note: This requires a window, so you should usually call it during
 * {@link #onAttachedToWindow()} and never earlier (you <strong>cannot</strong> call it
 * during {@link #onCreate}).</p>
 *
 * @param view The desired content to display.
 * @param params Layout parameters for the view.
 *
 * @see #setContentView(android.view.View)
 * @see #setContentView(int)
 * @apiSince 17
 */

public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * Adds a view to the Dream's window, leaving other content views in place.
 *
 * <p>Note: Requires a window, do not call before {@link #onAttachedToWindow()}</p>
 *
 * @param view The desired content to display.
 * @param params Layout parameters for the view.
 * @apiSince 17
 */

public void addContentView(android.view.View view, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * Finds a view that was identified by the id attribute from the XML that
 * was processed in {@link #onCreate}.
 *
 * <p>Note: Requires a window, do not call before {@link #onAttachedToWindow()}</p>
 * <p>
 * <strong>Note:</strong> In most cases -- depending on compiler support --
 * the resulting view is automatically cast to the target class type. If
 * the target class type is unconstrained, an explicit cast may be
 * necessary.
 *
 * @param id the ID to search for
 * @return The view if found or null otherwise.
 * @see android.view.View#findViewById(int)
 * @see android.service.dreams.DreamService#requireViewById(int)
 * @apiSince 17
 */

public <T extends android.view.View> T findViewById(int id) { throw new RuntimeException("Stub!"); }

/**
 * Finds a view that was identified by the id attribute from the XML that was processed in
 * {@link #onCreate}, or throws an IllegalArgumentException if the ID is invalid or there is no
 * matching view in the hierarchy.
 *
 * <p>Note: Requires a window, do not call before {@link #onAttachedToWindow()}</p>
 * <p>
 * <strong>Note:</strong> In most cases -- depending on compiler support --
 * the resulting view is automatically cast to the target class type. If
 * the target class type is unconstrained, an explicit cast may be
 * necessary.
 *
 * @param id the ID to search for
 * @return a view with given ID
 * This value will never be {@code null}.
 * @see android.view.View#requireViewById(int)
 * @see android.service.dreams.DreamService#findViewById(int)
 * @apiSince 28
 */

@androidx.annotation.NonNull
public final <T extends android.view.View> T requireViewById(int id) { throw new RuntimeException("Stub!"); }

/**
 * Marks this dream as interactive to receive input events.
 *
 * <p>Non-interactive dreams (default) will dismiss on the first input event.</p>
 *
 * <p>Interactive dreams should call {@link #finish()} to dismiss themselves.</p>
 *
 * @param interactive True if this dream will handle input events.
 * @apiSince 17
 */

public void setInteractive(boolean interactive) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not this dream is interactive.  Defaults to false.
 *
 * @see #setInteractive(boolean)
 * @apiSince 17
 */

public boolean isInteractive() { throw new RuntimeException("Stub!"); }

/**
 * Controls {@link android.view.WindowManager.LayoutParams#FLAG_FULLSCREEN}
 * on the dream's window.
 *
 * @param fullscreen If true, the fullscreen flag will be set; else it
 * will be cleared.
 * @apiSince 17
 */

public void setFullscreen(boolean fullscreen) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not this dream is in fullscreen mode. Defaults to false.
 *
 * @see #setFullscreen(boolean)
 * @apiSince 17
 */

public boolean isFullscreen() { throw new RuntimeException("Stub!"); }

/**
 * Marks this dream as keeping the screen bright while dreaming.
 *
 * @param screenBright True to keep the screen bright while dreaming.
 * @apiSince 17
 */

public void setScreenBright(boolean screenBright) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not this dream keeps the screen bright while dreaming.
 * Defaults to false, allowing the screen to dim if necessary.
 *
 * @see #setScreenBright(boolean)
 * @apiSince 17
 */

public boolean isScreenBright() { throw new RuntimeException("Stub!"); }

/**
 * Called when this Dream is constructed.
 * @apiSince 17
 */

public void onCreate() { throw new RuntimeException("Stub!"); }

/**
 * Called when the dream's window has been created and is visible and animation may now begin.
 * @apiSince 17
 */

public void onDreamingStarted() { throw new RuntimeException("Stub!"); }

/**
 * Called when this Dream is stopped, either by external request or by calling finish(),
 * before the window has been removed.
 * @apiSince 17
 */

public void onDreamingStopped() { throw new RuntimeException("Stub!"); }

/**
 * Called when the dream is being asked to stop itself and wake.
 * <p>
 * The default implementation simply calls {@link #finish} which ends the dream
 * immediately.  Subclasses may override this function to perform a smooth exit
 * transition then call {@link #finish} afterwards.
 * </p><p>
 * Note that the dream will only be given a short period of time (currently about
 * five seconds) to wake up.  If the dream does not finish itself in a timely manner
 * then the system will forcibly finish it once the time allowance is up.
 * </p>
 * @apiSince 21
 */

public void onWakeUp() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public final android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Stops the dream and detaches from the window.
 * <p>
 * When the dream ends, the system will be allowed to go to sleep fully unless there
 * is a reason for it to be awake such as recent user activity or wake locks being held.
 * </p>
 * @apiSince 17
 */

public final void finish() { throw new RuntimeException("Stub!"); }

/**
 * Wakes the dream up gently.
 * <p>
 * Calls {@link #onWakeUp} to give the dream a chance to perform an exit transition.
 * When the transition is over, the dream should call {@link #finish}.
 * </p>
 * @apiSince 21
 */

public final void wakeUp() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 17
 */

public void onDestroy() { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

protected void dump(java.io.FileDescriptor fd, java.io.PrintWriter pw, java.lang.String[] args) { throw new RuntimeException("Stub!"); }

/**
 * Name under which a Dream publishes information about itself.
 * This meta-data must reference an XML resource containing
 * a <code>&lt;{@link android.R.styleable#Dream dream}&gt;</code>
 * tag.
 * @apiSince 17
 */

public static final java.lang.String DREAM_META_DATA = "android.service.dream";

/**
 * The {@link android.content.Intent Intent} that must be declared as handled by the service.
 * @apiSince 17
 */

public static final java.lang.String SERVICE_INTERFACE = "android.service.dreams.DreamService";
}

