/*
 * Copyright 2019 The Android Open Source Project
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


/**
 * WebViewRenderProcess provides an opaque handle to a {@link android.webkit.WebView WebView} renderer.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class WebViewRenderProcess {

/** @apiSince 29 */

public WebViewRenderProcess() { throw new RuntimeException("Stub!"); }

/**
 * Cause this renderer to terminate.
 *
 * <p>Calling this on a not yet started, or an already terminated renderer will have no effect.
 *
 * <p>Terminating a renderer process may have an effect on multiple {@link android.webkit.WebView WebView} instances.
 *
 * <p>Renderer termination must be handled by properly overriding
 * {@link android.webkit.WebViewClient#onRenderProcessGone WebViewClient#onRenderProcessGone} for every WebView that shares this
 * renderer. If termination is not handled by all associated WebViews, then the application
 * process will also be terminated.
 *
 * @return {@code true} if it was possible to terminate this renderer, {@code false} otherwise.
 * @apiSince 29
 */

public abstract boolean terminate();
}

