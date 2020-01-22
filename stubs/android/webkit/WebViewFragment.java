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


package android.webkit;

import android.webkit.WebView;
import android.app.Fragment;

/**
 * A fragment that displays a WebView.
 * <p>
 * The WebView is automically paused or resumed when the Fragment is paused or resumed.
 *
 * @deprecated Manually call {@link android.webkit.WebView#onPause() WebView#onPause()} and {@link android.webkit.WebView#onResume() WebView#onResume()}
 * @apiSince 11
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class WebViewFragment extends android.app.Fragment {

/** @apiSince 11 */

@Deprecated
public WebViewFragment() { throw new RuntimeException("Stub!"); }

/**
 * Called to instantiate the view. Creates and returns the WebView.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public android.view.View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container, android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Called when the fragment is visible to the user and actively running. Resumes the WebView.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onPause() { throw new RuntimeException("Stub!"); }

/**
 * Called when the fragment is no longer resumed. Pauses the WebView.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onResume() { throw new RuntimeException("Stub!"); }

/**
 * Called when the WebView has been detached from the fragment.
 * The WebView is no longer available after this time.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onDestroyView() { throw new RuntimeException("Stub!"); }

/**
 * Called when the fragment is no longer in use. Destroys the internal state of the WebView.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Gets the WebView.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public android.webkit.WebView getWebView() { throw new RuntimeException("Stub!"); }
}

