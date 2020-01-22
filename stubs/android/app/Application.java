/*
 * Copyright (C) 2006 The Android Open Source Project
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

import android.content.Context;
import android.content.Intent;

/**
 * Base class for maintaining global application state. You can provide your own
 * implementation by creating a subclass and specifying the fully-qualified name
 * of this subclass as the <code>"android:name"</code> attribute in your
 * AndroidManifest.xml's <code>&lt;application&gt;</code> tag. The Application
 * class, or your subclass of the Application class, is instantiated before any
 * other class when the process for your application/package is created.
 *
 * <p class="note"><strong>Note: </strong>There is normally no need to subclass
 * Application.  In most situations, static singletons can provide the same
 * functionality in a more modular way.  If your singleton needs a global
 * context (for example to register broadcast receivers), include
 * {@link android.content.Context#getApplicationContext() Context.getApplicationContext()}
 * as a {@link android.content.Context} argument when invoking your singleton's
 * <code>getInstance()</code> method.
 * </p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Application extends android.content.ContextWrapper implements android.content.ComponentCallbacks2 {

/** @apiSince 1 */

public Application() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Called when the application is starting, before any activity, service,
 * or receiver objects (excluding content providers) have been created.
 *
 * <p>Implementations should be as quick as possible (for example using
 * lazy initialization of state) since the time spent in this function
 * directly impacts the performance of starting the first activity,
 * service, or receiver in a process.</p>
 *
 * <p>If you override this method, be sure to call {@code super.onCreate()}.</p>
 *
 * <p class="note">Be aware that direct boot may also affect callback order on
 * Android {@link android.os.Build.VERSION_CODES#N} and later devices.
 * Until the user unlocks the device, only direct boot aware components are
 * allowed to run. You should consider that all direct boot unaware
 * components, including such {@link android.content.ContentProvider}, are
 * disabled until user unlock happens, especially when component callback
 * order matters.</p>
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 1
 */

public void onCreate() { throw new RuntimeException("Stub!"); }

/**
 * This method is for use in emulated process environments.  It will
 * never be called on a production Android device, where processes are
 * removed by simply killing them; no user code (including this callback)
 * is executed when doing so.
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 1
 */

public void onTerminate() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 
 * @param newConfig This value must never be {@code null}.
 * @apiSince 1
 */

public void onConfigurationChanged(@androidx.annotation.NonNull android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 1
 */

public void onLowMemory() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 14
 */

public void onTrimMemory(int level) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public void registerComponentCallbacks(android.content.ComponentCallbacks callback) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public void unregisterComponentCallbacks(android.content.ComponentCallbacks callback) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public void registerActivityLifecycleCallbacks(android.app.Application.ActivityLifecycleCallbacks callback) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public void unregisterActivityLifecycleCallbacks(android.app.Application.ActivityLifecycleCallbacks callback) { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public void registerOnProvideAssistDataListener(android.app.Application.OnProvideAssistDataListener callback) { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public void unregisterOnProvideAssistDataListener(android.app.Application.OnProvideAssistDataListener callback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the current process. A package's default process name
 * is the same as its package name. Non-default processes will look like
 * "$PACKAGE_NAME:$NAME", where $NAME corresponds to an android:process
 * attribute within AndroidManifest.xml.
 * @apiSince 28
 */

public static java.lang.String getProcessName() { throw new RuntimeException("Stub!"); }
/** @apiSince 14 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ActivityLifecycleCallbacks {

/**
 * Called as the first step of the Activity being created. This is always called before
 * {@link android.app.Activity#onCreate Activity#onCreate}.
 
 * @param activity This value must never be {@code null}.
 
 * @param savedInstanceState This value may be {@code null}.
 * @apiSince 29
 */

public default void onActivityPreCreated(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Called when the Activity calls {@link android.app.Activity#onCreate Activity#onCreate}.
 
 * @param activity This value must never be {@code null}.
 
 * @param savedInstanceState This value may be {@code null}.
 * @apiSince 14
 */

public void onActivityCreated(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable android.os.Bundle savedInstanceState);

/**
 * Called as the last step of the Activity being created. This is always called after
 * {@link android.app.Activity#onCreate Activity#onCreate}.
 
 * @param activity This value must never be {@code null}.
 
 * @param savedInstanceState This value may be {@code null}.
 * @apiSince 29
 */

public default void onActivityPostCreated(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Called as the first step of the Activity being started. This is always called before
 * {@link android.app.Activity#onStart Activity#onStart}.
 
 * @param activity This value must never be {@code null}.
 * @apiSince 29
 */

public default void onActivityPreStarted(@androidx.annotation.NonNull android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Called when the Activity calls {@link android.app.Activity#onStart Activity#onStart}.
 
 * @param activity This value must never be {@code null}.
 * @apiSince 14
 */

public void onActivityStarted(@androidx.annotation.NonNull android.app.Activity activity);

/**
 * Called as the last step of the Activity being started. This is always called after
 * {@link android.app.Activity#onStart Activity#onStart}.
 
 * @param activity This value must never be {@code null}.
 * @apiSince 29
 */

public default void onActivityPostStarted(@androidx.annotation.NonNull android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Called as the first step of the Activity being resumed. This is always called before
 * {@link android.app.Activity#onResume Activity#onResume}.
 
 * @param activity This value must never be {@code null}.
 * @apiSince 29
 */

public default void onActivityPreResumed(@androidx.annotation.NonNull android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Called when the Activity calls {@link android.app.Activity#onResume Activity#onResume}.
 
 * @param activity This value must never be {@code null}.
 * @apiSince 14
 */

public void onActivityResumed(@androidx.annotation.NonNull android.app.Activity activity);

/**
 * Called as the last step of the Activity being resumed. This is always called after
 * {@link android.app.Activity#onResume Activity#onResume} and {@link android.app.Activity#onPostResume Activity#onPostResume}.
 
 * @param activity This value must never be {@code null}.
 * @apiSince 29
 */

public default void onActivityPostResumed(@androidx.annotation.NonNull android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Called as the first step of the Activity being paused. This is always called before
 * {@link android.app.Activity#onPause Activity#onPause}.
 
 * @param activity This value must never be {@code null}.
 * @apiSince 29
 */

public default void onActivityPrePaused(@androidx.annotation.NonNull android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Called when the Activity calls {@link android.app.Activity#onPause Activity#onPause}.
 
 * @param activity This value must never be {@code null}.
 * @apiSince 14
 */

public void onActivityPaused(@androidx.annotation.NonNull android.app.Activity activity);

/**
 * Called as the last step of the Activity being paused. This is always called after
 * {@link android.app.Activity#onPause Activity#onPause}.
 
 * @param activity This value must never be {@code null}.
 * @apiSince 29
 */

public default void onActivityPostPaused(@androidx.annotation.NonNull android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Called as the first step of the Activity being stopped. This is always called before
 * {@link android.app.Activity#onStop Activity#onStop}.
 
 * @param activity This value must never be {@code null}.
 * @apiSince 29
 */

public default void onActivityPreStopped(@androidx.annotation.NonNull android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Called when the Activity calls {@link android.app.Activity#onStop Activity#onStop}.
 
 * @param activity This value must never be {@code null}.
 * @apiSince 14
 */

public void onActivityStopped(@androidx.annotation.NonNull android.app.Activity activity);

/**
 * Called as the last step of the Activity being stopped. This is always called after
 * {@link android.app.Activity#onStop Activity#onStop}.
 
 * @param activity This value must never be {@code null}.
 * @apiSince 29
 */

public default void onActivityPostStopped(@androidx.annotation.NonNull android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Called as the first step of the Activity saving its instance state. This is always
 * called before {@link android.app.Activity#onSaveInstanceState Activity#onSaveInstanceState}.
 
 * @param activity This value must never be {@code null}.
 
 * @param outState This value must never be {@code null}.
 * @apiSince 29
 */

public default void onActivityPreSaveInstanceState(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.os.Bundle outState) { throw new RuntimeException("Stub!"); }

/**
 * Called when the Activity calls
 * {@link android.app.Activity#onSaveInstanceState Activity#onSaveInstanceState}.
 
 * @param activity This value must never be {@code null}.
 
 * @param outState This value must never be {@code null}.
 * @apiSince 14
 */

public void onActivitySaveInstanceState(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.os.Bundle outState);

/**
 * Called as the last step of the Activity saving its instance state. This is always
 * called after{@link android.app.Activity#onSaveInstanceState Activity#onSaveInstanceState}.
 
 * @param activity This value must never be {@code null}.
 
 * @param outState This value must never be {@code null}.
 * @apiSince 29
 */

public default void onActivityPostSaveInstanceState(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.os.Bundle outState) { throw new RuntimeException("Stub!"); }

/**
 * Called as the first step of the Activity being destroyed. This is always called before
 * {@link android.app.Activity#onDestroy Activity#onDestroy}.
 
 * @param activity This value must never be {@code null}.
 * @apiSince 29
 */

public default void onActivityPreDestroyed(@androidx.annotation.NonNull android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Called when the Activity calls {@link android.app.Activity#onDestroy Activity#onDestroy}.
 
 * @param activity This value must never be {@code null}.
 * @apiSince 14
 */

public void onActivityDestroyed(@androidx.annotation.NonNull android.app.Activity activity);

/**
 * Called as the last step of the Activity being destroyed. This is always called after
 * {@link android.app.Activity#onDestroy Activity#onDestroy}.
 
 * @param activity This value must never be {@code null}.
 * @apiSince 29
 */

public default void onActivityPostDestroyed(@androidx.annotation.NonNull android.app.Activity activity) { throw new RuntimeException("Stub!"); }
}

/**
 * Callback interface for use with {@link android.app.Application#registerOnProvideAssistDataListener Application#registerOnProvideAssistDataListener}
 * and {@link android.app.Application#unregisterOnProvideAssistDataListener Application#unregisterOnProvideAssistDataListener}.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnProvideAssistDataListener {

/**
 * This is called when the user is requesting an assist, to build a full
 * {@link android.content.Intent#ACTION_ASSIST Intent#ACTION_ASSIST} Intent with all of the context of the current
 * application.  You can override this method to place into the bundle anything
 * you would like to appear in the {@link android.content.Intent#EXTRA_ASSIST_CONTEXT Intent#EXTRA_ASSIST_CONTEXT} part
 * of the assist Intent.
 * @apiSince 18
 */

public void onProvideAssistData(android.app.Activity activity, android.os.Bundle data);
}

}

