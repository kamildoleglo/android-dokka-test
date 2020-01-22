/*
 * Copyright (C) 2010 The Android Open Source Project
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
 * Convenience for implementing an activity that will be implemented
 * purely in native code.  That is, a game (or game-like thing).  There
 * is no need to derive from this class; you can simply declare it in your
 * manifest, and use the NDK APIs from there.
 *
 * <p>A <a href="https://github.com/googlesamples/android-ndk/tree/master/native-activity">sample
 * native activity</a> is available in the NDK samples.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class NativeActivity extends android.app.Activity implements android.view.SurfaceHolder.Callback2, android.view.InputQueue.Callback, android.view.ViewTreeObserver.OnGlobalLayoutListener {

public NativeActivity() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

protected void onCreate(android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

protected void onDestroy() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

protected void onPause() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

protected void onResume() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

protected void onSaveInstanceState(android.os.Bundle outState) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

protected void onStart() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

protected void onStop() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void onConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void onLowMemory() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void onWindowFocusChanged(boolean hasFocus) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void surfaceCreated(android.view.SurfaceHolder holder) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void surfaceChanged(android.view.SurfaceHolder holder, int format, int width, int height) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void surfaceRedrawNeeded(android.view.SurfaceHolder holder) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void surfaceDestroyed(android.view.SurfaceHolder holder) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void onInputQueueCreated(android.view.InputQueue queue) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void onInputQueueDestroyed(android.view.InputQueue queue) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void onGlobalLayout() { throw new RuntimeException("Stub!"); }

/**
 * Optional meta-that can be in the manifest for this component, specifying
 * the name of the main entry point for this native activity in the
 * {@link #META_DATA_LIB_NAME} native code.  If not specified,
 * "ANativeActivity_onCreate" is used.
 * @apiSince 9
 */

public static final java.lang.String META_DATA_FUNC_NAME = "android.app.func_name";

/**
 * Optional meta-that can be in the manifest for this component, specifying
 * the name of the native shared library to load.  If not specified,
 * "main" is used.
 * @apiSince 9
 */

public static final java.lang.String META_DATA_LIB_NAME = "android.app.lib_name";
}

