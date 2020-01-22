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


package android.webkit;

import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.os.Bundle;
import android.os.Build;
import android.widget.AbsoluteLayout;
import android.graphics.Canvas;
import android.print.PrintDocumentAdapter;
import android.view.textclassifier.TextClassifier;
import java.util.concurrent.Executor;
import android.graphics.Picture;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.os.Looper;
import android.view.autofill.AutofillValue;
import android.view.ViewStructure;
import android.view.inputmethod.InputConnection;

/**
 * A View that displays web pages.
 *
 * <h3>Basic usage</h3>
 *
 *
 * <p>In most cases, we recommend using a standard web browser, like Chrome, to deliver
 * content to the user. To learn more about web browsers, read the guide on
 * <a href="/guide/components/intents-common#Browser">
 * invoking a browser with an intent</a>.
 *
 * <p>WebView objects allow you to display web content as part of your activity layout, but
 * lack some of the features of fully-developed browsers. A WebView is useful when
 * you need increased control over the UI and advanced configuration options that will allow
 * you to embed web pages in a specially-designed environment for your app.
 *
 * <p>To learn more about WebView and alternatives for serving web content, read the
 * documentation on
 * <a href="/guide/webapps/">
 * Web-based content</a>.
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WebView extends android.widget.AbsoluteLayout implements android.view.ViewTreeObserver.OnGlobalFocusChangeListener, android.view.ViewGroup.OnHierarchyChangeListener {

/**
 * Constructs a new WebView with an Activity Context object.
 *
 * <p class="note"><b>Note:</b> WebView should always be instantiated with an Activity Context.
 * If instantiated with an Application Context, WebView will be unable to provide several
 * features, such as JavaScript dialogs and autofill.
 *
 * @param context an Activity Context to access application assets
 * @apiSince 1
 */

public WebView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a new WebView with layout parameters.
 *
 * @param context an Activity Context to access application assets
 * @param attrs an AttributeSet passed to our parent
 * @apiSince 1
 */

public WebView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a new WebView with layout parameters and a default style.
 *
 * @param context an Activity Context to access application assets
 * @param attrs an AttributeSet passed to our parent
 * @param defStyleAttr an attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the view. Can be 0 to not look for defaults.
 * @apiSince 1
 */

public WebView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a new WebView with layout parameters and a default style.
 *
 * @param context an Activity Context to access application assets
 * @param attrs an AttributeSet passed to our parent
 * @param defStyleAttr an attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the view. Can be 0 to not look for defaults.
 * @param defStyleRes a resource identifier of a style resource that
 *        supplies default values for the view, used only if
 *        defStyleAttr is 0 or can not be found in the theme. Can be 0
 *        to not look for defaults.
 * @apiSince 21
 */

public WebView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a new WebView with layout parameters and a default style.
 *
 * @param context an Activity Context to access application assets
 * @param attrs an AttributeSet passed to our parent
 * @param defStyleAttr an attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the view. Can be 0 to not look for defaults.
 * @param privateBrowsing whether this WebView will be initialized in
 *                        private mode
 *
 * @deprecated Private browsing is no longer supported directly via
 * WebView and will be removed in a future release. Prefer using
 * {@link android.webkit.WebSettings WebSettings}, {@link android.webkit.WebViewDatabase WebViewDatabase}, {@link android.webkit.CookieManager CookieManager}
 * and {@link android.webkit.WebStorage WebStorage} for fine-grained control of privacy data.
 * @apiSince 11
 */

@Deprecated
public WebView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Specifies whether the horizontal scrollbar has overlay style.
 *
 * @deprecated This method has no effect.
 * @param overlay {@code true} if horizontal scrollbar should have overlay style
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public void setHorizontalScrollbarOverlay(boolean overlay) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether the vertical scrollbar has overlay style.
 *
 * @deprecated This method has no effect.
 * @param overlay {@code true} if vertical scrollbar should have overlay style
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public void setVerticalScrollbarOverlay(boolean overlay) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether horizontal scrollbar has overlay style.
 *
 * @deprecated This method is now obsolete.
 * @return {@code true}
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public boolean overlayHorizontalScrollbar() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether vertical scrollbar has overlay style.
 *
 * @deprecated This method is now obsolete.
 * @return {@code false}
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public boolean overlayVerticalScrollbar() { throw new RuntimeException("Stub!"); }

/**
 * Gets the SSL certificate for the main top-level page or {@code null} if there is
 * no certificate (the site is not secure).
 *
 * @return the SSL certificate for the main top-level page
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.net.http.SslCertificate getCertificate() { throw new RuntimeException("Stub!"); }

/**
 * Sets the SSL certificate for the main top-level page.
 *
 * @deprecated Calling this function has no useful effect, and will be
 * ignored in future releases.
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public void setCertificate(android.net.http.SslCertificate certificate) { throw new RuntimeException("Stub!"); }

/**
 * Sets a username and password pair for the specified host. This data is
 * used by the WebView to autocomplete username and password fields in web
 * forms. Note that this is unrelated to the credentials used for HTTP
 * authentication.
 *
 * @param host the host that required the credentials
 * @param username the username for the given host
 * @param password the password for the given host
 * @see android.webkit.WebViewDatabase#clearUsernamePassword
 * @see android.webkit.WebViewDatabase#hasUsernamePassword
 * @deprecated Saving passwords in WebView will not be supported in future versions.
 * @apiSince 1
 * @deprecatedSince 18
 */

@Deprecated
public void savePassword(java.lang.String host, java.lang.String username, java.lang.String password) { throw new RuntimeException("Stub!"); }

/**
 * Stores HTTP authentication credentials for a given host and realm to the {@link android.webkit.WebViewDatabase WebViewDatabase}
 * instance.
 *
 * @param host the host to which the credentials apply
 * @param realm the realm to which the credentials apply
 * @param username the username
 * @param password the password
 * @deprecated Use {@link android.webkit.WebViewDatabase#setHttpAuthUsernamePassword WebViewDatabase#setHttpAuthUsernamePassword} instead
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public void setHttpAuthUsernamePassword(java.lang.String host, java.lang.String realm, java.lang.String username, java.lang.String password) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves HTTP authentication credentials for a given host and realm from the {@link android.webkit.WebViewDatabase WebViewDatabase} instance.
 * @param host the host to which the credentials apply
 * @param realm the realm to which the credentials apply
 * @return the credentials as a String array, if found. The first element
 *         is the username and the second element is the password. {@code null} if
 *         no credentials are found.
 * @deprecated Use {@link android.webkit.WebViewDatabase#getHttpAuthUsernamePassword WebViewDatabase#getHttpAuthUsernamePassword} instead
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
@androidx.annotation.Nullable
public java.lang.String[] getHttpAuthUsernamePassword(java.lang.String host, java.lang.String realm) { throw new RuntimeException("Stub!"); }

/**
 * Destroys the internal state of this WebView. This method should be called
 * after this WebView has been removed from the view system. No other
 * methods may be called on this WebView after destroy.
 * @apiSince 1
 */

public void destroy() { throw new RuntimeException("Stub!"); }

/**
 * Informs WebView of the network state. This is used to set
 * the JavaScript property window.navigator.isOnline and
 * generates the online/offline event as specified in HTML5, sec. 5.7.7
 *
 * @param networkUp a boolean indicating if network is available
 * @apiSince 3
 */

public void setNetworkAvailable(boolean networkUp) { throw new RuntimeException("Stub!"); }

/**
 * Saves the state of this WebView used in
 * {@link android.app.Activity#onSaveInstanceState}. Please note that this
 * method no longer stores the display data for this WebView. The previous
 * behavior could potentially leak files if {@link #restoreState} was never
 * called.
 *
 * @param outState the Bundle to store this WebView's state
 * @return the same copy of the back/forward list used to save the state, {@code null} if the
 *         method fails.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.webkit.WebBackForwardList saveState(android.os.Bundle outState) { throw new RuntimeException("Stub!"); }

/**
 * Restores the state of this WebView from the given Bundle. This method is
 * intended for use in {@link android.app.Activity#onRestoreInstanceState}
 * and should be called to restore the state of this WebView. If
 * it is called after this WebView has had a chance to build state (load
 * pages, create a back/forward list, etc.) there may be undesirable
 * side-effects. Please note that this method no longer restores the
 * display data for this WebView.
 *
 * @param inState the incoming Bundle of state
 * @return the restored back/forward list or {@code null} if restoreState failed
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.webkit.WebBackForwardList restoreState(android.os.Bundle inState) { throw new RuntimeException("Stub!"); }

/**
 * Loads the given URL with the specified additional HTTP headers.
 * <p>
 * Also see compatibility note on {@link #evaluateJavascript}.
 *
 * @param url the URL of the resource to load
 * @param additionalHttpHeaders the additional headers to be used in the
 *            HTTP request for this URL, specified as a map from name to
 *            value. Note that if this map contains any of the headers
 *            that are set by default by this WebView, such as those
 *            controlling caching, accept types or the User-Agent, their
 *            values may be overridden by this WebView's defaults.
 * @apiSince 8
 */

public void loadUrl(java.lang.String url, java.util.Map<java.lang.String,java.lang.String> additionalHttpHeaders) { throw new RuntimeException("Stub!"); }

/**
 * Loads the given URL.
 * <p>
 * Also see compatibility note on {@link #evaluateJavascript}.
 *
 * @param url the URL of the resource to load
 * @apiSince 1
 */

public void loadUrl(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * Loads the URL with postData using "POST" method into this WebView. If url
 * is not a network URL, it will be loaded with {@link #loadUrl(java.lang.String)}
 * instead, ignoring the postData param.
 *
 * @param url the URL of the resource to load
 * @param postData the data will be passed to "POST" request, which must be
 *     be "application/x-www-form-urlencoded" encoded.
 * @apiSince 5
 */

public void postUrl(java.lang.String url, byte[] postData) { throw new RuntimeException("Stub!"); }

/**
 * Loads the given data into this WebView using a 'data' scheme URL.
 * <p>
 * Note that JavaScript's same origin policy means that script running in a
 * page loaded using this method will be unable to access content loaded
 * using any scheme other than 'data', including 'http(s)'. To avoid this
 * restriction, use {@link
 * #loadDataWithBaseURL(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)
 * loadDataWithBaseURL()} with an appropriate base URL.
 * <p>
 * The {@code encoding} parameter specifies whether the data is base64 or URL
 * encoded. If the data is base64 encoded, the value of the encoding
 * parameter must be {@code "base64"}. HTML can be encoded with {@link
 * android.util.Base64#encodeToString(byte[],int)} like so:
 * <pre class="prettyprint">
 * String unencodedHtml =
 *     "&lt;html&gt;&lt;body&gt;'%28' is the code for '('&lt;/body&gt;&lt;/html&gt;";
 * String encodedHtml = Base64.encodeToString(unencodedHtml.getBytes(), Base64.NO_PADDING);
 * webView.loadData(encodedHtml, "text/html", "base64");
 * </pre>
 * <p class="note">
 * For all other values of {@code encoding} (including {@code null}) it is assumed that the
 * data uses ASCII encoding for octets inside the range of safe URL characters and use the
 * standard %xx hex encoding of URLs for octets outside that range. See <a
 * href="https://tools.ietf.org/html/rfc3986#section-2.2">RFC 3986</a> for more information.
 * Applications targeting {@link android.os.Build.VERSION_CODES#Q} or later must either use
 * base64 or encode any {@code #} characters in the content as {@code %23}, otherwise they
 * will be treated as the end of the content and the remaining text used as a document
 * fragment identifier.
 * <p>
 * The {@code mimeType} parameter specifies the format of the data.
 * If WebView can't handle the specified MIME type, it will download the data.
 * If {@code null}, defaults to 'text/html'.
 * <p>
 * The 'data' scheme URL formed by this method uses the default US-ASCII
 * charset. If you need to set a different charset, you should form a
 * 'data' scheme URL which explicitly specifies a charset parameter in the
 * mediatype portion of the URL and call {@link #loadUrl(java.lang.String)} instead.
 * Note that the charset obtained from the mediatype portion of a data URL
 * always overrides that specified in the HTML or XML document itself.
 * <p>
 * Content loaded using this method will have a {@code window.origin} value
 * of {@code "null"}. This must not be considered to be a trusted origin
 * by the application or by any JavaScript code running inside the WebView
 * (for example, event sources in DOM event handlers or web messages),
 * because malicious content can also create frames with a null origin. If
 * you need to identify the main frame's origin in a trustworthy way, you
 * should use {@link #loadDataWithBaseURL(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)
 * loadDataWithBaseURL()} with a valid HTTP or HTTPS base URL to set the
 * origin.
 *
 * @param data a String of data in the given encoding
 * @param mimeType the MIME type of the data, e.g. 'text/html'.
 * This value may be {@code null}.
 * @param encoding the encoding of the data
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void loadData(java.lang.String data, @androidx.annotation.Nullable java.lang.String mimeType, @androidx.annotation.Nullable java.lang.String encoding) { throw new RuntimeException("Stub!"); }

/**
 * Loads the given data into this WebView, using baseUrl as the base URL for
 * the content. The base URL is used both to resolve relative URLs and when
 * applying JavaScript's same origin policy. The historyUrl is used for the
 * history entry.
 * <p>
 * The {@code mimeType} parameter specifies the format of the data.
 * If WebView can't handle the specified MIME type, it will download the data.
 * If {@code null}, defaults to 'text/html'.
 * <p>
 * Note that content specified in this way can access local device files
 * (via 'file' scheme URLs) only if baseUrl specifies a scheme other than
 * 'http', 'https', 'ftp', 'ftps', 'about' or 'javascript'.
 * <p>
 * If the base URL uses the data scheme, this method is equivalent to
 * calling {@link #loadData(java.lang.String,java.lang.String,java.lang.String) loadData()} and the
 * historyUrl is ignored, and the data will be treated as part of a data: URL,
 * including the requirement that the content be URL-encoded or base64 encoded.
 * If the base URL uses any other scheme, then the data will be loaded into
 * the WebView as a plain string (i.e. not part of a data URL) and any URL-encoded
 * entities in the string will not be decoded.
 * <p>
 * Note that the baseUrl is sent in the 'Referer' HTTP header when
 * requesting subresources (images, etc.) of the page loaded using this method.
 * <p>
 * If a valid HTTP or HTTPS base URL is not specified in {@code baseUrl}, then
 * content loaded using this method will have a {@code window.origin} value
 * of {@code "null"}. This must not be considered to be a trusted origin
 * by the application or by any JavaScript code running inside the WebView
 * (for example, event sources in DOM event handlers or web messages),
 * because malicious content can also create frames with a null origin. If
 * you need to identify the main frame's origin in a trustworthy way, you
 * should use a valid HTTP or HTTPS base URL to set the origin.
 *
 * @param baseUrl the URL to use as the page's base URL. If {@code null} defaults to
 *                'about:blank'.
 * This value may be {@code null}.
 * @param data a String of data in the given encoding
 * @param mimeType the MIME type of the data, e.g. 'text/html'.
 * This value may be {@code null}.
 * @param encoding the encoding of the data
 * This value may be {@code null}.
 * @param historyUrl the URL to use as the history entry. If {@code null} defaults
 *                   to 'about:blank'. If non-null, this must be a valid URL.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void loadDataWithBaseURL(@androidx.annotation.Nullable java.lang.String baseUrl, java.lang.String data, @androidx.annotation.Nullable java.lang.String mimeType, @androidx.annotation.Nullable java.lang.String encoding, @androidx.annotation.Nullable java.lang.String historyUrl) { throw new RuntimeException("Stub!"); }

/**
 * Asynchronously evaluates JavaScript in the context of the currently displayed page.
 * If non-null, {@code resultCallback} will be invoked with any result returned from that
 * execution. This method must be called on the UI thread and the callback will
 * be made on the UI thread.
 * <p>
 * Compatibility note. Applications targeting {@link android.os.Build.VERSION_CODES#N} or
 * later, JavaScript state from an empty WebView is no longer persisted across navigations like
 * {@link #loadUrl(java.lang.String)}. For example, global variables and functions defined before calling
 * {@link #loadUrl(java.lang.String)} will not exist in the loaded page. Applications should use
 * {@link #addJavascriptInterface} instead to persist JavaScript objects across navigations.
 *
 * @param script the JavaScript to execute.
 * @param resultCallback A callback to be invoked when the script execution
 *                       completes with the result of the execution (if any).
 *                       May be {@code null} if no notification of the result is required.
 
 * This value may be {@code null}.
 * @apiSince 19
 */

public void evaluateJavascript(java.lang.String script, @androidx.annotation.Nullable android.webkit.ValueCallback<java.lang.String> resultCallback) { throw new RuntimeException("Stub!"); }

/**
 * Saves the current view as a web archive.
 *
 * @param filename the filename where the archive should be placed
 * @apiSince 11
 */

public void saveWebArchive(java.lang.String filename) { throw new RuntimeException("Stub!"); }

/**
 * Saves the current view as a web archive.
 *
 * @param basename the filename where the archive should be placed
 * @param autoname if {@code false}, takes basename to be a file. If {@code true}, basename
 *                 is assumed to be a directory in which a filename will be
 *                 chosen according to the URL of the current page.
 * @param callback called after the web archive has been saved. The
 *                 parameter for onReceiveValue will either be the filename
 *                 under which the file was saved, or {@code null} if saving the
 *                 file failed.
 
 * This value may be {@code null}.
 * @apiSince 11
 */

public void saveWebArchive(java.lang.String basename, boolean autoname, @androidx.annotation.Nullable android.webkit.ValueCallback<java.lang.String> callback) { throw new RuntimeException("Stub!"); }

/**
 * Stops the current load.
 * @apiSince 1
 */

public void stopLoading() { throw new RuntimeException("Stub!"); }

/**
 * Reloads the current URL.
 * @apiSince 1
 */

public void reload() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this WebView has a back history item.
 *
 * @return {@code true} if this WebView has a back history item
 * @apiSince 1
 */

public boolean canGoBack() { throw new RuntimeException("Stub!"); }

/**
 * Goes back in the history of this WebView.
 * @apiSince 1
 */

public void goBack() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this WebView has a forward history item.
 *
 * @return {@code true} if this WebView has a forward history item
 * @apiSince 1
 */

public boolean canGoForward() { throw new RuntimeException("Stub!"); }

/**
 * Goes forward in the history of this WebView.
 * @apiSince 1
 */

public void goForward() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether the page can go back or forward the given
 * number of steps.
 *
 * @param steps the negative or positive number of steps to move the
 *              history
 * @apiSince 1
 */

public boolean canGoBackOrForward(int steps) { throw new RuntimeException("Stub!"); }

/**
 * Goes to the history item that is the number of steps away from
 * the current item. Steps is negative if backward and positive
 * if forward.
 *
 * @param steps the number of steps to take back or forward in the back
 *              forward list
 * @apiSince 1
 */

public void goBackOrForward(int steps) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether private browsing is enabled in this WebView.
 * @apiSince 11
 */

public boolean isPrivateBrowsingEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Scrolls the contents of this WebView up by half the view size.
 *
 * @param top {@code true} to jump to the top of the page
 * @return {@code true} if the page was scrolled
 * @apiSince 1
 */

public boolean pageUp(boolean top) { throw new RuntimeException("Stub!"); }

/**
 * Scrolls the contents of this WebView down by half the page size.
 *
 * @param bottom {@code true} to jump to bottom of page
 * @return {@code true} if the page was scrolled
 * @apiSince 1
 */

public boolean pageDown(boolean bottom) { throw new RuntimeException("Stub!"); }

/**
 * Posts a {@link android.webkit.WebView.VisualStateCallback VisualStateCallback}, which will be called when
 * the current state of the WebView is ready to be drawn.
 *
 * <p>Because updates to the DOM are processed asynchronously, updates to the DOM may not
 * immediately be reflected visually by subsequent {@link android.webkit.WebView#onDraw WebView#onDraw} invocations. The
 * {@link android.webkit.WebView.VisualStateCallback VisualStateCallback} provides a mechanism to notify the caller when the contents of
 * the DOM at the current time are ready to be drawn the next time the {@link android.webkit.WebView WebView}
 * draws.
 *
 * <p>The next draw after the callback completes is guaranteed to reflect all the updates to the
 * DOM up to the point at which the {@link android.webkit.WebView.VisualStateCallback VisualStateCallback} was posted, but it may also
 * contain updates applied after the callback was posted.
 *
 * <p>The state of the DOM covered by this API includes the following:
 * <ul>
 * <li>primitive HTML elements (div, img, span, etc..)</li>
 * <li>images</li>
 * <li>CSS animations</li>
 * <li>WebGL</li>
 * <li>canvas</li>
 * </ul>
 * It does not include the state of:
 * <ul>
 * <li>the video tag</li>
 * </ul>
 *
 * <p>To guarantee that the {@link android.webkit.WebView WebView} will successfully render the first frame
 * after the {@link android.webkit.WebView.VisualStateCallback#onComplete VisualStateCallback#onComplete} method has been called a set of conditions
 * must be met:
 * <ul>
 * <li>If the {@link android.webkit.WebView WebView}'s visibility is set to {@link android.view.View#VISIBLE View#VISIBLE} then
 * the {@link android.webkit.WebView WebView} must be attached to the view hierarchy.</li>
 * <li>If the {@link android.webkit.WebView WebView}'s visibility is set to {@link android.view.View#INVISIBLE View#INVISIBLE}
 * then the {@link android.webkit.WebView WebView} must be attached to the view hierarchy and must be made
 * {@link android.view.View#VISIBLE View#VISIBLE} from the {@link android.webkit.WebView.VisualStateCallback#onComplete VisualStateCallback#onComplete} method.</li>
 * <li>If the {@link android.webkit.WebView WebView}'s visibility is set to {@link android.view.View#GONE View#GONE} then the
 * {@link android.webkit.WebView WebView} must be attached to the view hierarchy and its
 * {@link android.widget.AbsoluteLayout.LayoutParams AbsoluteLayout.LayoutParams}'s width and height need to be set to fixed
 * values and must be made {@link android.view.View#VISIBLE View#VISIBLE} from the
 * {@link android.webkit.WebView.VisualStateCallback#onComplete VisualStateCallback#onComplete} method.</li>
 * </ul>
 *
 * <p>When using this API it is also recommended to enable pre-rasterization if the {@link android.webkit.WebView WebView} is off screen to avoid flickering. See {@link android.webkit.WebSettings#setOffscreenPreRaster WebSettings#setOffscreenPreRaster} for
 * more details and do consider its caveats.
 *
 * @param requestId An id that will be returned in the callback to allow callers to match
 *                  requests with callbacks.
 * @param callback  The callback to be invoked.
 * @apiSince 23
 */

public void postVisualStateCallback(long requestId, android.webkit.WebView.VisualStateCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Clears this WebView so that onDraw() will draw nothing but white background,
 * and onMeasure() will return 0 if MeasureSpec is not MeasureSpec.EXACTLY.
 * @deprecated Use WebView.loadUrl("about:blank") to reliably reset the view state
 *             and release page resources (including any running JavaScript).
 * @apiSince 1
 * @deprecatedSince 18
 */

@Deprecated
public void clearView() { throw new RuntimeException("Stub!"); }

/**
 * Gets a new picture that captures the current contents of this WebView.
 * The picture is of the entire document being displayed, and is not
 * limited to the area currently displayed by this WebView. Also, the
 * picture is a static copy and is unaffected by later changes to the
 * content being displayed.
 * <p>
 * Note that due to internal changes, for API levels between
 * {@link android.os.Build.VERSION_CODES#HONEYCOMB} and
 * {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH} inclusive, the
 * picture does not include fixed position elements or scrollable divs.
 * <p>
 * Note that from {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR1} the returned picture
 * should only be drawn into bitmap-backed Canvas - using any other type of Canvas will involve
 * additional conversion at a cost in memory and performance.
 *
 * @deprecated Use {@link #onDraw} to obtain a bitmap snapshot of the WebView, or
 * {@link #saveWebArchive} to save the content to a file.
 *
 * @return a picture that captures the current contents of this WebView
 * @apiSince 1
 * @deprecatedSince 19
 */

@Deprecated
public android.graphics.Picture capturePicture() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #createPrintDocumentAdapter(java.lang.String)} which requires user
 *             to provide a print document name.
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated
public android.print.PrintDocumentAdapter createPrintDocumentAdapter() { throw new RuntimeException("Stub!"); }

/**
 * Creates a PrintDocumentAdapter that provides the content of this WebView for printing.
 *
 * The adapter works by converting the WebView contents to a PDF stream. The WebView cannot
 * be drawn during the conversion process - any such draws are undefined. It is recommended
 * to use a dedicated off screen WebView for the printing. If necessary, an application may
 * temporarily hide a visible WebView by using a custom PrintDocumentAdapter instance
 * wrapped around the object returned and observing the onStart and onFinish methods. See
 * {@link android.print.PrintDocumentAdapter} for more information.
 *
 * @param documentName  The user-facing name of the printed document. See
 *                      {@link android.print.PrintDocumentInfo}
 * @apiSince 21
 */

public android.print.PrintDocumentAdapter createPrintDocumentAdapter(java.lang.String documentName) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current scale of this WebView.
 *
 * @return the current scale
 *
 * @deprecated This method is prone to inaccuracy due to race conditions
 * between the web rendering and UI threads; prefer
 * {@link android.webkit.WebViewClient#onScaleChanged WebViewClient#onScaleChanged}.
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
@android.view.ViewDebug.ExportedProperty(category="webview")
public float getScale() { throw new RuntimeException("Stub!"); }

/**
 * Sets the initial scale for this WebView. 0 means default.
 * The behavior for the default scale depends on the state of
 * {@link android.webkit.WebSettings#getUseWideViewPort() WebSettings#getUseWideViewPort()} and
 * {@link android.webkit.WebSettings#getLoadWithOverviewMode() WebSettings#getLoadWithOverviewMode()}.
 * If the content fits into the WebView control by width, then
 * the zoom is set to 100%. For wide content, the behavior
 * depends on the state of {@link android.webkit.WebSettings#getLoadWithOverviewMode() WebSettings#getLoadWithOverviewMode()}.
 * If its value is {@code true}, the content will be zoomed out to be fit
 * by width into the WebView control, otherwise not.
 *
 * If initial scale is greater than 0, WebView starts with this value
 * as initial scale.
 * Please note that unlike the scale properties in the viewport meta tag,
 * this method doesn't take the screen density into account.
 *
 * @param scaleInPercent the initial scale in percent
 * @apiSince 1
 */

public void setInitialScale(int scaleInPercent) { throw new RuntimeException("Stub!"); }

/**
 * Invokes the graphical zoom picker widget for this WebView. This will
 * result in the zoom widget appearing on the screen to control the zoom
 * level of this WebView.
 * @apiSince 1
 */

public void invokeZoomPicker() { throw new RuntimeException("Stub!"); }

/**
 * Gets a HitTestResult based on the current cursor node. If a HTML::a
 * tag is found and the anchor has a non-JavaScript URL, the HitTestResult
 * type is set to SRC_ANCHOR_TYPE and the URL is set in the "extra" field.
 * If the anchor does not have a URL or if it is a JavaScript URL, the type
 * will be UNKNOWN_TYPE and the URL has to be retrieved through
 * {@link #requestFocusNodeHref} asynchronously. If a HTML::img tag is
 * found, the HitTestResult type is set to IMAGE_TYPE and the URL is set in
 * the "extra" field. A type of
 * SRC_IMAGE_ANCHOR_TYPE indicates an anchor with a URL that has an image as
 * a child node. If a phone number is found, the HitTestResult type is set
 * to PHONE_TYPE and the phone number is set in the "extra" field of
 * HitTestResult. If a map address is found, the HitTestResult type is set
 * to GEO_TYPE and the address is set in the "extra" field of HitTestResult.
 * If an email address is found, the HitTestResult type is set to EMAIL_TYPE
 * and the email is set in the "extra" field of HitTestResult. Otherwise,
 * HitTestResult type is set to UNKNOWN_TYPE.
 * @apiSince 1
 */

public android.webkit.WebView.HitTestResult getHitTestResult() { throw new RuntimeException("Stub!"); }

/**
 * Requests the anchor or image element URL at the last tapped point.
 * If hrefMsg is {@code null}, this method returns immediately and does not
 * dispatch hrefMsg to its target. If the tapped point hits an image,
 * an anchor, or an image in an anchor, the message associates
 * strings in named keys in its data. The value paired with the key
 * may be an empty string.
 *
 * @param hrefMsg the message to be dispatched with the result of the
 *                request. The message data contains three keys. "url"
 *                returns the anchor's href attribute. "title" returns the
 *                anchor's text. "src" returns the image's src attribute.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void requestFocusNodeHref(@androidx.annotation.Nullable android.os.Message hrefMsg) { throw new RuntimeException("Stub!"); }

/**
 * Requests the URL of the image last touched by the user. msg will be sent
 * to its target with a String representing the URL as its object.
 *
 * @param msg the message to be dispatched with the result of the request
 *            as the data member with "url" as key. The result can be {@code null}.
 * @apiSince 1
 */

public void requestImageRef(android.os.Message msg) { throw new RuntimeException("Stub!"); }

/**
 * Gets the URL for the current page. This is not always the same as the URL
 * passed to WebViewClient.onPageStarted because although the load for
 * that URL has begun, the current page may not have changed.
 *
 * @return the URL for the current page
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="webview")
public java.lang.String getUrl() { throw new RuntimeException("Stub!"); }

/**
 * Gets the original URL for the current page. This is not always the same
 * as the URL passed to WebViewClient.onPageStarted because although the
 * load for that URL has begun, the current page may not have changed.
 * Also, there may have been redirects resulting in a different URL to that
 * originally requested.
 *
 * @return the URL that was originally requested for the current page
 * @apiSince 3
 */

@android.view.ViewDebug.ExportedProperty(category="webview")
public java.lang.String getOriginalUrl() { throw new RuntimeException("Stub!"); }

/**
 * Gets the title for the current page. This is the title of the current page
 * until WebViewClient.onReceivedTitle is called.
 *
 * @return the title for the current page
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="webview")
public java.lang.String getTitle() { throw new RuntimeException("Stub!"); }

/**
 * Gets the favicon for the current page. This is the favicon of the current
 * page until WebViewClient.onReceivedIcon is called.
 *
 * @return the favicon for the current page
 * @apiSince 1
 */

public android.graphics.Bitmap getFavicon() { throw new RuntimeException("Stub!"); }

/**
 * Gets the progress for the current page.
 *
 * @return the progress for the current page between 0 and 100
 * @apiSince 1
 */

public int getProgress() { throw new RuntimeException("Stub!"); }

/**
 * Gets the height of the HTML content.
 *
 * @return the height of the HTML content
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="webview")
public int getContentHeight() { throw new RuntimeException("Stub!"); }

/**
 * Pauses all layout, parsing, and JavaScript timers for all WebViews. This
 * is a global requests, not restricted to just this WebView. This can be
 * useful if the application has been paused.
 * @apiSince 1
 */

public void pauseTimers() { throw new RuntimeException("Stub!"); }

/**
 * Resumes all layout, parsing, and JavaScript timers for all WebViews.
 * This will resume dispatching all timers.
 * @apiSince 1
 */

public void resumeTimers() { throw new RuntimeException("Stub!"); }

/**
 * Does a best-effort attempt to pause any processing that can be paused
 * safely, such as animations and geolocation. Note that this call
 * does not pause JavaScript. To pause JavaScript globally, use
 * {@link #pauseTimers}.
 *
 * To resume WebView, call {@link #onResume}.
 * @apiSince 11
 */

public void onPause() { throw new RuntimeException("Stub!"); }

/**
 * Resumes a WebView after a previous call to {@link #onPause}.
 * @apiSince 11
 */

public void onResume() { throw new RuntimeException("Stub!"); }

/**
 * Informs this WebView that memory is low so that it can free any available
 * memory.
 * @deprecated Memory caches are automatically dropped when no longer needed, and in response
 *             to system memory pressure.
 * @apiSince 7
 * @deprecatedSince 19
 */

@Deprecated
public void freeMemory() { throw new RuntimeException("Stub!"); }

/**
 * Clears the resource cache. Note that the cache is per-application, so
 * this will clear the cache for all WebViews used.
 *
 * @param includeDiskFiles if {@code false}, only the RAM cache is cleared
 * @apiSince 1
 */

public void clearCache(boolean includeDiskFiles) { throw new RuntimeException("Stub!"); }

/**
 * Removes the autocomplete popup from the currently focused form field, if
 * present. Note this only affects the display of the autocomplete popup,
 * it does not remove any saved form data from this WebView's store. To do
 * that, use {@link android.webkit.WebViewDatabase#clearFormData WebViewDatabase#clearFormData}.
 * @apiSince 1
 */

public void clearFormData() { throw new RuntimeException("Stub!"); }

/**
 * Tells this WebView to clear its internal back/forward list.
 * @apiSince 1
 */

public void clearHistory() { throw new RuntimeException("Stub!"); }

/**
 * Clears the SSL preferences table stored in response to proceeding with
 * SSL certificate errors.
 * @apiSince 1
 */

public void clearSslPreferences() { throw new RuntimeException("Stub!"); }

/**
 * Clears the client certificate preferences stored in response
 * to proceeding/cancelling client cert requests. Note that WebView
 * automatically clears these preferences when the system keychain is updated.
 * The preferences are shared by all the WebViews that are created by the embedder application.
 *
 * @param onCleared  A runnable to be invoked when client certs are cleared.
 *                   The runnable will be called in UI thread.
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public static void clearClientCertPreferences(@androidx.annotation.Nullable java.lang.Runnable onCleared) { throw new RuntimeException("Stub!"); }

/**
 * Starts Safe Browsing initialization.
 * <p>
 * URL loads are not guaranteed to be protected by Safe Browsing until after {@code callback} is
 * invoked with {@code true}. Safe Browsing is not fully supported on all devices. For those
 * devices {@code callback} will receive {@code false}.
 * <p>
 * This should not be called if Safe Browsing has been disabled by manifest tag or {@link android.webkit.WebSettings#setSafeBrowsingEnabled WebSettings#setSafeBrowsingEnabled}. This prepares resources used for Safe Browsing.
 * <p>
 * This should be called with the Application Context (and will always use the Application
 * context to do its work regardless).
 *
 * @param context Application Context.
 * This value must never be {@code null}.
 * @param callback will be called on the UI thread with {@code true} if initialization is
 * successful, {@code false} otherwise.
 
 * This value may be {@code null}.
 * @apiSince 27
 */

public static void startSafeBrowsing(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.webkit.ValueCallback<java.lang.Boolean> callback) { throw new RuntimeException("Stub!"); }

/**
 * Sets the list of hosts (domain names/IP addresses) that are exempt from SafeBrowsing checks.
 * The list is global for all the WebViews.
 * <p>
 * Each rule should take one of these:
 * <table>
 * <tr><th> Rule </th> <th> Example </th> <th> Matches Subdomain</th> </tr>
 * <tr><td> HOSTNAME </td> <td> example.com </td> <td> Yes </td> </tr>
 * <tr><td> .HOSTNAME </td> <td> .example.com </td> <td> No </td> </tr>
 * <tr><td> IPV4_LITERAL </td> <td> 192.168.1.1 </td> <td> No </td></tr>
 * <tr><td> IPV6_LITERAL_WITH_BRACKETS </td><td>[10:20:30:40:50:60:70:80]</td><td>No</td></tr>
 * </table>
 * <p>
 * All other rules, including wildcards, are invalid.
 * <p>
 * The correct syntax for hosts is defined by <a
 * href="https://tools.ietf.org/html/rfc3986#section-3.2.2">RFC 3986</a>.
 *
 * @param hosts the list of hosts
 * This value must never be {@code null}.
 * @param callback will be called with {@code true} if hosts are successfully added to the
 * whitelist. It will be called with {@code false} if any hosts are malformed. The callback
 * will be run on the UI thread
 
 * This value may be {@code null}.
 * @apiSince 27
 */

public static void setSafeBrowsingWhitelist(@androidx.annotation.NonNull java.util.List<java.lang.String> hosts, @androidx.annotation.Nullable android.webkit.ValueCallback<java.lang.Boolean> callback) { throw new RuntimeException("Stub!"); }

/**
 * Returns a URL pointing to the privacy policy for Safe Browsing reporting.
 *
 * @return the url pointing to a privacy policy document which can be displayed to users.
 
 * This value will never be {@code null}.
 * @apiSince 27
 */

@androidx.annotation.NonNull
public static android.net.Uri getSafeBrowsingPrivacyPolicyUrl() { throw new RuntimeException("Stub!"); }

/**
 * Gets the WebBackForwardList for this WebView. This contains the
 * back/forward list for use in querying each item in the history stack.
 * This is a copy of the private WebBackForwardList so it contains only a
 * snapshot of the current state. Multiple calls to this method may return
 * different objects. The object returned from this method will not be
 * updated to reflect any new state.
 * @apiSince 1
 */

public android.webkit.WebBackForwardList copyBackForwardList() { throw new RuntimeException("Stub!"); }

/**
 * Registers the listener to be notified as find-on-page operations
 * progress. This will replace the current listener.
 *
 * @param listener an implementation of {@link android.webkit.WebView.FindListener FindListener}
 * @apiSince 16
 */

public void setFindListener(android.webkit.WebView.FindListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Highlights and scrolls to the next match found by
 * {@link #findAllAsync}, wrapping around page boundaries as necessary.
 * Notifies any registered {@link android.webkit.WebView.FindListener FindListener}. If {@link #findAllAsync(java.lang.String)}
 * has not been called yet, or if {@link #clearMatches} has been called since the
 * last find operation, this function does nothing.
 *
 * @param forward the direction to search
 * @see #setFindListener
 * @apiSince 3
 */

public void findNext(boolean forward) { throw new RuntimeException("Stub!"); }

/**
 * Finds all instances of find on the page and highlights them.
 * Notifies any registered {@link android.webkit.WebView.FindListener FindListener}.
 *
 * @param find the string to find
 * @return the number of occurrences of the String "find" that were found
 * @deprecated {@link #findAllAsync} is preferred.
 * @see #setFindListener
 * @apiSince 3
 * @deprecatedSince 16
 */

@Deprecated
public int findAll(java.lang.String find) { throw new RuntimeException("Stub!"); }

/**
 * Finds all instances of find on the page and highlights them,
 * asynchronously. Notifies any registered {@link android.webkit.WebView.FindListener FindListener}.
 * Successive calls to this will cancel any pending searches.
 *
 * @param find the string to find.
 * @see #setFindListener
 * @apiSince 16
 */

public void findAllAsync(java.lang.String find) { throw new RuntimeException("Stub!"); }

/**
 * Starts an ActionMode for finding text in this WebView.  Only works if this
 * WebView is attached to the view system.
 *
 * @param text if non-null, will be the initial text to search for.
 *             Otherwise, the last String searched for in this WebView will
 *             be used to start.
 * This value may be {@code null}.
 * @param showIme if {@code true}, show the IME, assuming the user will begin typing.
 *                If {@code false} and text is non-null, perform a find all.
 * @return {@code true} if the find dialog is shown, {@code false} otherwise
 * @deprecated This method does not work reliably on all Android versions;
 *             implementing a custom find dialog using WebView.findAllAsync()
 *             provides a more robust solution.
 * @apiSince 11
 * @deprecatedSince 18
 */

@Deprecated
public boolean showFindDialog(@androidx.annotation.Nullable java.lang.String text, boolean showIme) { throw new RuntimeException("Stub!"); }

/**
 * Gets the first substring which appears to be the address of a physical
 * location. Only addresses in the United States can be detected, which
 * must consist of:
 * <ul>
 *   <li>a house number</li>
 *   <li>a street name</li>
 *   <li>a street type (Road, Circle, etc), either spelled out or
 *       abbreviated</li>
 *   <li>a city name</li>
 *   <li>a state or territory, either spelled out or two-letter abbr</li>
 *   <li>an optional 5 digit or 9 digit zip code</li>
 * </ul>
 * All names must be correctly capitalized, and the zip code, if present,
 * must be valid for the state. The street type must be a standard USPS
 * spelling or abbreviation. The state or territory must also be spelled
 * or abbreviated using USPS standards. The house number may not exceed
 * five digits.
 *
 * <p class="note"><b>Note:</b> This function is deprecated and should be
 * avoided on all API levels, as it cannot detect addresses outside of the
 * United States and has a high rate of false positives. On API level
 * {@link android.os.Build.VERSION_CODES#O_MR1} and earlier, it also causes
 * the entire WebView implementation to be loaded and initialized, which
 * can throw {@link android.util.AndroidRuntimeException} or other exceptions
 * if the WebView implementation is currently being updated.
 *
 * @param addr the string to search for addresses
 * @return the address, or if no address is found, {@code null}
 * @deprecated This method is superseded by {@link android.view.textclassifier.TextClassifier#generateLinks(android.view.textclassifier.TextLinks.Request) TextClassifier#generateLinks(
 * android.view.textclassifier.TextLinks.Request)}. Avoid using this method even when targeting
 * API levels where no alternative is available.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.Nullable
public static java.lang.String findAddress(java.lang.String addr) { throw new RuntimeException("Stub!"); }

/**
 * For apps targeting the L release, WebView has a new default behavior that reduces
 * memory footprint and increases performance by intelligently choosing
 * the portion of the HTML document that needs to be drawn. These
 * optimizations are transparent to the developers. However, under certain
 * circumstances, an App developer may want to disable them:
 * <ol>
 *   <li>When an app uses {@link #onDraw} to do own drawing and accesses portions
 *       of the page that is way outside the visible portion of the page.</li>
 *   <li>When an app uses {@link #capturePicture} to capture a very large HTML document.
 *       Note that capturePicture is a deprecated API.</li>
 * </ol>
 * Enabling drawing the entire HTML document has a significant performance
 * cost. This method should be called before any WebViews are created.
 * @apiSince 21
 */

public static void enableSlowWholeDocumentDraw() { throw new RuntimeException("Stub!"); }

/**
 * Clears the highlighting surrounding text matches created by
 * {@link #findAllAsync}.
 * @apiSince 3
 */

public void clearMatches() { throw new RuntimeException("Stub!"); }

/**
 * Queries the document to see if it contains any image references. The
 * message object will be dispatched with arg1 being set to 1 if images
 * were found and 0 if the document does not reference any images.
 *
 * @param response the message that will be dispatched with the result
 * @apiSince 1
 */

public void documentHasImages(android.os.Message response) { throw new RuntimeException("Stub!"); }

/**
 * Sets the WebViewClient that will receive various notifications and
 * requests. This will replace the current handler.
 *
 * @param client an implementation of WebViewClient
 * @see #getWebViewClient
 * @apiSince 1
 */

public void setWebViewClient(android.webkit.WebViewClient client) { throw new RuntimeException("Stub!"); }

/**
 * Gets the WebViewClient.
 *
 * @return the WebViewClient, or a default client if not yet set
 * @see #setWebViewClient
 * @apiSince 26
 */

public android.webkit.WebViewClient getWebViewClient() { throw new RuntimeException("Stub!"); }

/**
 * Gets a handle to the WebView renderer process associated with this WebView.
 *
 * <p>In {@link android.os.Build.VERSION_CODES#O} and above, WebView may
 * run in "multiprocess" mode. In multiprocess mode, rendering of web
 * content is performed by a sandboxed renderer process separate to the
 * application process.  This renderer process may be shared with other
 * WebViews in the application, but is not shared with other application
 * processes.
 *
 * <p>If WebView is running in multiprocess mode, this method returns a
 * handle to the renderer process associated with the WebView, which can
 * be used to control the renderer process.
 *
 * @return the {@link android.webkit.WebViewRenderProcess WebViewRenderProcess} renderer handle associated
 *         with this {@link android.webkit.WebView WebView}, or {@code null} if
 *         WebView is not runing in multiprocess mode.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.webkit.WebViewRenderProcess getWebViewRenderProcess() { throw new RuntimeException("Stub!"); }

/**
 * Sets the renderer client object associated with this WebView.
 *
 * <p>The renderer client encapsulates callbacks relevant to WebView renderer
 * state. See {@link android.webkit.WebViewRenderProcessClient WebViewRenderProcessClient} for details.
 *
 * <p>Although many WebView instances may share a single underlying
 * renderer, and renderers may live either in the application
 * process, or in a sandboxed process that is isolated from the
 * application process, instances of {@link android.webkit.WebViewRenderProcessClient WebViewRenderProcessClient}
 * are set per-WebView.  Callbacks represent renderer events from
 * the perspective of this WebView, and may or may not be correlated
 * with renderer events affecting other WebViews.
 *
 * @param executor the Executor on which {@link android.webkit.WebViewRenderProcessClient WebViewRenderProcessClient}
 *                 callbacks will execute.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param webViewRenderProcessClient the {@link android.webkit.WebViewRenderProcessClient WebViewRenderProcessClient}
 *                                   object.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void setWebViewRenderProcessClient(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.webkit.WebViewRenderProcessClient webViewRenderProcessClient) { throw new RuntimeException("Stub!"); }

/**
 * Sets the renderer client object associated with this WebView.
 *
 * See {@link #setWebViewRenderProcessClient(java.util.concurrent.Executor,android.webkit.WebViewRenderProcessClient)} for details.
 *
 * <p> {@link android.webkit.WebViewRenderProcessClient WebViewRenderProcessClient} callbacks will run on the thread that this WebView was
 * initialized on.
 *
 * @param webViewRenderProcessClient the {@link android.webkit.WebViewRenderProcessClient WebViewRenderProcessClient} object.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public void setWebViewRenderProcessClient(@androidx.annotation.Nullable android.webkit.WebViewRenderProcessClient webViewRenderProcessClient) { throw new RuntimeException("Stub!"); }

/**
 * Gets the renderer client object associated with this WebView.
 *
 * @return the {@link android.webkit.WebViewRenderProcessClient WebViewRenderProcessClient} object associated with this WebView, if one
 *         has been set via {@link #setWebViewRenderProcessClient(android.webkit.WebViewRenderProcessClient)}
 *         or {@code null} otherwise.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.webkit.WebViewRenderProcessClient getWebViewRenderProcessClient() { throw new RuntimeException("Stub!"); }

/**
 * Registers the interface to be used when content can not be handled by
 * the rendering engine, and should be downloaded instead. This will replace
 * the current handler.
 *
 * @param listener an implementation of DownloadListener
 * @apiSince 1
 */

public void setDownloadListener(android.webkit.DownloadListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the chrome handler. This is an implementation of WebChromeClient for
 * use in handling JavaScript dialogs, favicons, titles, and the progress.
 * This will replace the current handler.
 *
 * @param client an implementation of WebChromeClient
 * @see #getWebChromeClient
 * @apiSince 1
 */

public void setWebChromeClient(android.webkit.WebChromeClient client) { throw new RuntimeException("Stub!"); }

/**
 * Gets the chrome handler.
 *
 * @return the WebChromeClient, or {@code null} if not yet set
 * @see #setWebChromeClient
 * @apiSince 26
 */

@androidx.annotation.Nullable
public android.webkit.WebChromeClient getWebChromeClient() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Picture listener. This is an interface used to receive
 * notifications of a new Picture.
 *
 * @param listener an implementation of WebView.PictureListener
 * @deprecated This method is now obsolete.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void setPictureListener(android.webkit.WebView.PictureListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Injects the supplied Java object into this WebView. The object is
 * injected into all frames of the web page, including all the iframes,
 * using the supplied name. This allows the Java object's methods to be
 * accessed from JavaScript. For applications targeted to API
 * level {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR1}
 * and above, only public methods that are annotated with
 * {@link android.webkit.JavascriptInterface} can be accessed from JavaScript.
 * For applications targeted to API level {@link android.os.Build.VERSION_CODES#JELLY_BEAN} or below,
 * all public methods (including the inherited ones) can be accessed, see the
 * important security note below for implications.
 * <p> Note that injected objects will not appear in JavaScript until the page is next
 * (re)loaded. JavaScript should be enabled before injecting the object. For example:
 * <pre class="prettyprint">
 * class JsObject {
 *    {@literal @}JavascriptInterface
 *    public String toString() { return "injectedObject"; }
 * }
 * webview.getSettings().setJavaScriptEnabled(true);
 * webView.addJavascriptInterface(new JsObject(), "injectedObject");
 * webView.loadData("<!DOCTYPE html><title></title>", "text/html", null);
 * webView.loadUrl("javascript:alert(injectedObject.toString())");</pre>
 * <p>
 * <strong>IMPORTANT:</strong>
 * <ul>
 * <li> This method can be used to allow JavaScript to control the host
 * application. This is a powerful feature, but also presents a security
 * risk for apps targeting {@link android.os.Build.VERSION_CODES#JELLY_BEAN} or earlier.
 * Apps that target a version later than {@link android.os.Build.VERSION_CODES#JELLY_BEAN}
 * are still vulnerable if the app runs on a device running Android earlier than 4.2.
 * The most secure way to use this method is to target {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR1}
 * and to ensure the method is called only when running on Android 4.2 or later.
 * With these older versions, JavaScript could use reflection to access an
 * injected object's public fields. Use of this method in a WebView
 * containing untrusted content could allow an attacker to manipulate the
 * host application in unintended ways, executing Java code with the
 * permissions of the host application. Use extreme care when using this
 * method in a WebView which could contain untrusted content.</li>
 * <li> JavaScript interacts with Java object on a private, background
 * thread of this WebView. Care is therefore required to maintain thread
 * safety.
 * </li>
 * <li> Because the object is exposed to all the frames, any frame could
 * obtain the object name and call methods on it. There is no way to tell the
 * calling frame's origin from the app side, so the app must not assume that
 * the caller is trustworthy unless the app can guarantee that no third party
 * content is ever loaded into the WebView even inside an iframe.</li>
 * <li> The Java object's fields are not accessible.</li>
 * <li> For applications targeted to API level {@link android.os.Build.VERSION_CODES#LOLLIPOP}
 * and above, methods of injected Java objects are enumerable from
 * JavaScript.</li>
 * </ul>
 *
 * @param object the Java object to inject into this WebView's JavaScript
 *               context. {@code null} values are ignored.
 * @param name the name used to expose the object in JavaScript
 * @apiSince 1
 */

public void addJavascriptInterface(java.lang.Object object, java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Removes a previously injected Java object from this WebView. Note that
 * the removal will not be reflected in JavaScript until the page is next
 * (re)loaded. See {@link #addJavascriptInterface}.
 *
 * @param name the name used to expose the object in JavaScript
 
 * This value must never be {@code null}.
 * @apiSince 11
 */

public void removeJavascriptInterface(@androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Creates a message channel to communicate with JS and returns the message
 * ports that represent the endpoints of this message channel. The HTML5 message
 * channel functionality is described
 * <a href="https://html.spec.whatwg.org/multipage/comms.html#messagechannel">here
 * </a>
 *
 * <p>The returned message channels are entangled and already in started state.
 *
 * @return the two message ports that form the message channel.
 * @apiSince 23
 */

public android.webkit.WebMessagePort[] createWebMessageChannel() { throw new RuntimeException("Stub!"); }

/**
 * Post a message to main frame. The embedded application can restrict the
 * messages to a certain target origin. See
 * <a href="https://html.spec.whatwg.org/multipage/comms.html#posting-messages">
 * HTML5 spec</a> for how target origin can be used.
 * <p>
 * A target origin can be set as a wildcard ("*"). However this is not recommended.
 * See the page above for security issues.
 * <p>
 * Content loaded via {@link #loadData(java.lang.String,java.lang.String,java.lang.String)} will not have a
 * valid origin, and thus cannot be sent messages securely. If you need to send
 * messages using this function, you should use
 * {@link #loadDataWithBaseURL(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)} with a valid
 * HTTP or HTTPS {@code baseUrl} to define a valid origin that can be used for
 * messaging.
 *
 * @param message the WebMessage
 * @param targetOrigin the target origin.
 * @apiSince 23
 */

public void postWebMessage(android.webkit.WebMessage message, android.net.Uri targetOrigin) { throw new RuntimeException("Stub!"); }

/**
 * Gets the WebSettings object used to control the settings for this
 * WebView.
 *
 * @return a WebSettings object that can be used to control this WebView's
 *         settings
 * @apiSince 1
 */

public android.webkit.WebSettings getSettings() { throw new RuntimeException("Stub!"); }

/**
 * Enables debugging of web contents (HTML / CSS / JavaScript)
 * loaded into any WebViews of this application. This flag can be enabled
 * in order to facilitate debugging of web layouts and JavaScript
 * code running inside WebViews. Please refer to WebView documentation
 * for the debugging guide.
 *
 * The default is {@code false}.
 *
 * @param enabled whether to enable web contents debugging
 * @apiSince 19
 */

public static void setWebContentsDebuggingEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Define the directory used to store WebView data for the current process.
 * The provided suffix will be used when constructing data and cache
 * directory paths. If this API is not called, no suffix will be used.
 * Each directory can be used by only one process in the application. If more
 * than one process in an app wishes to use WebView, only one process can use
 * the default directory, and other processes must call this API to define
 * a unique suffix.
 * <p>
 * This means that different processes in the same application cannot directly
 * share WebView-related data, since the data directories must be distinct.
 * Applications that use this API may have to explicitly pass data between
 * processes. For example, login cookies may have to be copied from one
 * process's cookie jar to the other using {@link android.webkit.CookieManager CookieManager} if both
 * processes' WebViews are intended to be logged in.
 * <p>
 * Most applications should simply ensure that all components of the app
 * that rely on WebView are in the same process, to avoid needing multiple
 * data directories. The {@link #disableWebView} method can be used to ensure
 * that the other processes do not use WebView by accident in this case.
 * <p>
 * This API must be called before any instances of WebView are created in
 * this process and before any other methods in the android.webkit package
 * are called by this process.
 *
 * @param suffix The directory name suffix to be used for the current
 *               process. Must not contain a path separator.
 * @throws java.lang.IllegalStateException if WebView has already been initialized
 *                               in the current process.
 * @throws java.lang.IllegalArgumentException if the suffix contains a path separator.
 * @apiSince 28
 */

public static void setDataDirectorySuffix(java.lang.String suffix) { throw new RuntimeException("Stub!"); }

/**
 * Indicate that the current process does not intend to use WebView, and
 * that an exception should be thrown if a WebView is created or any other
 * methods in the android.webkit package are used.
 * <p>
 * Applications with multiple processes may wish to call this in processes
 * that are not intended to use WebView to avoid accidentally incurring
 * the memory usage of initializing WebView in long-lived processes that
 * have no need for it, and to prevent potential data directory conflicts
 * (see {@link #setDataDirectorySuffix}).
 * <p>
 * For example, an audio player application with one process for its
 * activities and another process for its playback service may wish to call
 * this method in the playback service's {@link android.app.Service#onCreate}.
 *
 * @throws java.lang.IllegalStateException if WebView has already been initialized
 *                               in the current process.
 * @apiSince 28
 */

public static void disableWebView() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated WebView no longer needs to implement
 * ViewGroup.OnHierarchyChangeListener.  This method does nothing now.
 * @apiSince 1
 */

@Deprecated
public void onChildViewAdded(android.view.View parent, android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated WebView no longer needs to implement
 * ViewGroup.OnHierarchyChangeListener.  This method does nothing now.
 * @apiSince 1
 */

@Deprecated
public void onChildViewRemoved(android.view.View p, android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated WebView should not have implemented
 * ViewTreeObserver.OnGlobalFocusChangeListener. This method does nothing now.
 * @apiSince 1
 */

@Deprecated
public void onGlobalFocusChanged(android.view.View oldFocus, android.view.View newFocus) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Only the default case, {@code true}, will be supported in a future version.
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public void setMapTrackballToArrowKeys(boolean setMap) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void flingScroll(int vx, int vy) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this WebView can be zoomed in.
 *
 * @return {@code true} if this WebView can be zoomed in
 *
 * @deprecated This method is prone to inaccuracy due to race conditions
 * between the web rendering and UI threads; prefer
 * {@link android.webkit.WebViewClient#onScaleChanged WebViewClient#onScaleChanged}.
 * @apiSince 11
 * @deprecatedSince 17
 */

@Deprecated
public boolean canZoomIn() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this WebView can be zoomed out.
 *
 * @return {@code true} if this WebView can be zoomed out
 *
 * @deprecated This method is prone to inaccuracy due to race conditions
 * between the web rendering and UI threads; prefer
 * {@link android.webkit.WebViewClient#onScaleChanged WebViewClient#onScaleChanged}.
 * @apiSince 11
 * @deprecatedSince 17
 */

@Deprecated
public boolean canZoomOut() { throw new RuntimeException("Stub!"); }

/**
 * Performs a zoom operation in this WebView.
 *
 * @param zoomFactor the zoom factor to apply. The zoom factor will be clamped to the WebView's
 * zoom limits. This value must be in the range 0.01 to 100.0 inclusive.
 * @apiSince 21
 */

public void zoomBy(float zoomFactor) { throw new RuntimeException("Stub!"); }

/**
 * Performs zoom in in this WebView.
 *
 * @return {@code true} if zoom in succeeds, {@code false} if no zoom changes
 * @apiSince 1
 */

public boolean zoomIn() { throw new RuntimeException("Stub!"); }

/**
 * Performs zoom out in this WebView.
 *
 * @return {@code true} if zoom out succeeds, {@code false} if no zoom changes
 * @apiSince 1
 */

public boolean zoomOut() { throw new RuntimeException("Stub!"); }

/**
 * Set the renderer priority policy for this {@link android.webkit.WebView WebView}. The
 * priority policy will be used to determine whether an out of
 * process renderer should be considered to be a target for OOM
 * killing.
 *
 * Because a renderer can be associated with more than one
 * WebView, the final priority it is computed as the maximum of
 * any attached WebViews. When a WebView is destroyed it will
 * cease to be considerered when calculating the renderer
 * priority. Once no WebViews remain associated with the renderer,
 * the priority of the renderer will be reduced to
 * {@link #RENDERER_PRIORITY_WAIVED}.
 *
 * The default policy is to set the priority to
 * {@link #RENDERER_PRIORITY_IMPORTANT} regardless of visibility,
 * and this should not be changed unless the caller also handles
 * renderer crashes with
 * {@link android.webkit.WebViewClient#onRenderProcessGone WebViewClient#onRenderProcessGone}. Any other setting
 * will result in WebView renderers being killed by the system
 * more aggressively than the application.
 *
 * @param rendererRequestedPriority the minimum priority at which
 *        this WebView desires the renderer process to be bound.
 * Value is {@link android.webkit.WebView#RENDERER_PRIORITY_WAIVED}, {@link android.webkit.WebView#RENDERER_PRIORITY_BOUND}, or {@link android.webkit.WebView#RENDERER_PRIORITY_IMPORTANT}
 * @param waivedWhenNotVisible if {@code true}, this flag specifies that
 *        when this WebView is not visible, it will be treated as
 *        if it had requested a priority of
 *        {@link #RENDERER_PRIORITY_WAIVED}.
 * @apiSince 26
 */

public void setRendererPriorityPolicy(int rendererRequestedPriority, boolean waivedWhenNotVisible) { throw new RuntimeException("Stub!"); }

/**
 * Get the requested renderer priority for this WebView.
 *
 * @return the requested renderer priority policy.
 
 * Value is {@link android.webkit.WebView#RENDERER_PRIORITY_WAIVED}, {@link android.webkit.WebView#RENDERER_PRIORITY_BOUND}, or {@link android.webkit.WebView#RENDERER_PRIORITY_IMPORTANT}
 * @apiSince 26
 */

public int getRendererRequestedPriority() { throw new RuntimeException("Stub!"); }

/**
 * Return whether this WebView requests a priority of
 * {@link #RENDERER_PRIORITY_WAIVED} when not visible.
 *
 * @return whether this WebView requests a priority of
 * {@link #RENDERER_PRIORITY_WAIVED} when not visible.
 * @apiSince 26
 */

public boolean getRendererPriorityWaivedWhenNotVisible() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.view.textclassifier.TextClassifier TextClassifier} for this WebView.
 
 * @param textClassifier This value may be {@code null}.
 * @apiSince 27
 */

public void setTextClassifier(@androidx.annotation.Nullable android.view.textclassifier.TextClassifier textClassifier) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.view.textclassifier.TextClassifier TextClassifier} used by this WebView.
 * If no TextClassifier has been set, this WebView uses the default set by the system.
 
 * @return This value will never be {@code null}.
 * @apiSince 27
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifier getTextClassifier() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link java.lang.ClassLoader ClassLoader} used to load internal WebView classes.
 * This method is meant for use by the WebView Support Library, there is no reason to use this
 * method otherwise.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static java.lang.ClassLoader getWebViewClassLoader() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.os.Looper Looper} corresponding to the thread on which WebView calls must be made.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.os.Looper getWebViewLooper() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setLayoutParams(android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void setOverScrollMode(int mode) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setScrollBarStyle(int style) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected int computeHorizontalScrollRange() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected int computeHorizontalScrollOffset() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected int computeVerticalScrollRange() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected int computeVerticalScrollOffset() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected int computeVerticalScrollExtent() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void computeScroll() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public boolean onHoverEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

public boolean onGenericMotionEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onTrackballEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyDown(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyUp(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyMultiple(int keyCode, int repeatCount, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public android.view.accessibility.AccessibilityNodeProvider getAccessibilityNodeProvider() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

@Deprecated
public boolean shouldDelayChildPressedState() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void onProvideVirtualStructure(android.view.ViewStructure structure) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>The {@link android.view.ViewStructure ViewStructure} traditionally represents a {@link android.view.View View}, while for web pages
 * it represent HTML nodes. Hence, it's necessary to "map" the HTML properties in a way that is
 * understood by the {@link android.service.autofill.AutofillService} implementations:
 *
 * <ol>
 *   <li>Only the HTML nodes inside a {@code FORM} are generated.
 *   <li>The source of the HTML is set using {@link android.view.ViewStructure#setWebDomain(java.lang.String) ViewStructure#setWebDomain(String)} in the
 *   node representing the WebView.
 *   <li>If a web page has multiple {@code FORM}s, only the data for the current form is
 *   represented&mdash;if the user taps a field from another form, then the current autofill
 *   context is canceled (by calling {@link android.view.autofill.AutofillManager#cancel()} and
 *   a new context is created for that {@code FORM}.
 *   <li>Similarly, if the page has {@code IFRAME} nodes, they are not initially represented in
 *   the view structure until the user taps a field from a {@code FORM} inside the
 *   {@code IFRAME}, in which case it would be treated the same way as multiple forms described
 *   above, except that the {@link android.view.ViewStructure#setWebDomain(java.lang.String) ViewStructure#setWebDomain(String)} of the
 *   {@code FORM} contains the {@code src} attribute from the {@code IFRAME} node.
 *   <li>The W3C autofill field ({@code autocomplete} tag attribute) maps to
 *   {@link android.view.ViewStructure#setAutofillHints(java.lang.String[]) ViewStructure#setAutofillHints(String[])}.
 *   <li>If the view is editable, the {@link android.view.ViewStructure#setAutofillType(int) ViewStructure#setAutofillType(int)} and
 *   {@link android.view.ViewStructure#setAutofillValue(android.view.autofill.AutofillValue) ViewStructure#setAutofillValue(AutofillValue)} must be set.
 *   <li>The {@code placeholder} attribute maps to {@link android.view.ViewStructure#setHint(java.lang.CharSequence) ViewStructure#setHint(CharSequence)}.
 *   <li>Other HTML attributes can be represented through
 *   {@link android.view.ViewStructure#setHtmlInfo(android.view.ViewStructure.HtmlInfo) ViewStructure#setHtmlInfo(android.view.ViewStructure.HtmlInfo)}.
 * </ol>
 *
 * <p>If the WebView implementation can determine that the value of a field was set statically
 * (for example, not through Javascript), it should also call
 * {@code structure.setDataIsSensitive(false)}.
 *
 * <p>For example, an HTML form with 2 fields for username and password:
 *
 * <pre class="prettyprint">
 *    &lt;label&gt;Username:&lt;/label&gt;
 *    &lt;input type="text" name="username" id="user" value="Type your username" autocomplete="username" placeholder="Email or username"&gt;
 *    &lt;label&gt;Password:&lt;/label&gt;
 *    &lt;input type="password" name="password" id="pass" autocomplete="current-password" placeholder="Password"&gt;
 * </pre>
 *
 * <p>Would map to:
 *
 * <pre class="prettyprint">
 *     int index = structure.addChildCount(2);
 *     ViewStructure username = structure.newChild(index);
 *     username.setAutofillId(structure.getAutofillId(), 1); // id 1 - first child
 *     username.setAutofillHints("username");
 *     username.setHtmlInfo(username.newHtmlInfoBuilder("input")
 *         .addAttribute("type", "text")
 *         .addAttribute("name", "username")
 *         .addAttribute("label", "Username:")
 *         .build());
 *     username.setHint("Email or username");
 *     username.setAutofillType(View.AUTOFILL_TYPE_TEXT);
 *     username.setAutofillValue(AutofillValue.forText("Type your username"));
 *     // Value of the field is not sensitive because it was created statically and not changed.
 *     username.setDataIsSensitive(false);
 *
 *     ViewStructure password = structure.newChild(index + 1);
 *     username.setAutofillId(structure, 2); // id 2 - second child
 *     password.setAutofillHints("current-password");
 *     password.setHtmlInfo(password.newHtmlInfoBuilder("input")
 *         .addAttribute("type", "password")
 *         .addAttribute("name", "password")
 *         .addAttribute("label", "Password:")
 *         .build());
 *     password.setHint("Password");
 *     password.setAutofillType(View.AUTOFILL_TYPE_TEXT);
 * </pre>
 * @apiSince 26
 */

public void onProvideAutofillVirtualStructure(android.view.ViewStructure structure, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void autofill(android.util.SparseArray<android.view.autofill.AutofillValue> values) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public boolean isVisibleToUserForAutofill(int virtualId) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onWindowVisibilityChanged(int visibility) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean performLongClick() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

protected void onConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new InputConnection for an InputMethod to interact with the WebView.
 * This is similar to {@link android.view.View#onCreateInputConnection View#onCreateInputConnection} but note that WebView
 * calls InputConnection methods on a thread other than the UI thread.
 * If these methods are overridden, then the overriding methods should respect
 * thread restrictions when calling View methods or accessing data.
 * @apiSince 3
 */

public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo outAttrs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public boolean onDragEvent(android.view.DragEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

protected void onVisibilityChanged(android.view.View changedView, int visibility) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onWindowFocusChanged(boolean hasWindowFocus) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onFocusChanged(boolean focused, int direction, android.graphics.Rect previouslyFocusedRect) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onSizeChanged(int w, int h, int ow, int oh) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onScrollChanged(int l, int t, int oldl, int oldt) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean dispatchKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean requestFocus(int direction, android.graphics.Rect previouslyFocusedRect) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean requestChildRectangleOnScreen(android.view.View child, android.graphics.Rect rect, boolean immediate) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setBackgroundColor(int color) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void setLayerType(int layerType, android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void dispatchDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void onStartTemporaryDetach() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void onFinishTemporaryDetach() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.os.Handler getHandler() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.view.View findFocus() { throw new RuntimeException("Stub!"); }

/**
 * If WebView has already been loaded into the current process this method will return the
 * package that was used to load it. Otherwise, the package that would be used if the WebView
 * was loaded right now will be returned; this does not cause WebView to be loaded, so this
 * information may become outdated at any time.
 * The WebView package changes either when the current WebView package is updated, disabled, or
 * uninstalled. It can also be changed through a Developer Setting.
 * If the WebView package changes, any app process that has loaded WebView will be killed. The
 * next time the app starts and loads WebView it will use the new WebView package instead.
 * @return the current WebView package, or {@code null} if there is none.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public static android.content.pm.PackageInfo getCurrentWebViewPackage() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean onCheckIsTextEditor() { throw new RuntimeException("Stub!"); }

/**
 * The renderer associated with this WebView is bound with
 * the default priority for services.
 *
 * Use with {@link #setRendererPriorityPolicy}.
 * @apiSince 26
 */

public static final int RENDERER_PRIORITY_BOUND = 1; // 0x1

/**
 * The renderer associated with this WebView is bound with
 * {@link android.content.Context#BIND_IMPORTANT Context#BIND_IMPORTANT}.
 *
 * Use with {@link #setRendererPriorityPolicy}.
 * @apiSince 26
 */

public static final int RENDERER_PRIORITY_IMPORTANT = 2; // 0x2

/**
 * The renderer associated with this WebView is bound with
 * {@link android.content.Context#BIND_WAIVE_PRIORITY Context#BIND_WAIVE_PRIORITY}. At this priority level
 * {@link android.webkit.WebView WebView} renderers will be strong targets for out of memory
 * killing.
 *
 * Use with {@link #setRendererPriorityPolicy}.
 * @apiSince 26
 */

public static final int RENDERER_PRIORITY_WAIVED = 0; // 0x0

/**
 * URI scheme for map address.
 * @apiSince 1
 */

public static final java.lang.String SCHEME_GEO = "geo:0,0?q=";

/**
 * URI scheme for email address.
 * @apiSince 1
 */

public static final java.lang.String SCHEME_MAILTO = "mailto:";

/**
 * URI scheme for telephone number.
 * @apiSince 1
 */

public static final java.lang.String SCHEME_TEL = "tel:";
/**
 * Interface to listen for find results.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface FindListener {

/**
 * Notifies the listener about progress made by a find operation.
 *
 * @param activeMatchOrdinal the zero-based ordinal of the currently selected match
 * @param numberOfMatches how many matches have been found
 * @param isDoneCounting whether the find operation has actually completed. The listener
 *                       may be notified multiple times while the
 *                       operation is underway, and the numberOfMatches
 *                       value should not be considered final unless
 *                       isDoneCounting is {@code true}.
 * @apiSince 16
 */

public void onFindResultReceived(int activeMatchOrdinal, int numberOfMatches, boolean isDoneCounting);
}

/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class HitTestResult {

HitTestResult() { throw new RuntimeException("Stub!"); }

/**
 * Gets the type of the hit test result. See the XXX_TYPE constants
 * defined in this class.
 *
 * @return the type of the hit test result
 * @apiSince 1
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Gets additional type-dependant information about the result. See
 * {@link android.webkit.WebView#getHitTestResult() WebView#getHitTestResult()} for details. May either be {@code null}
 * or contain extra information about this result.
 *
 * @return additional type-dependant information about the result
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String getExtra() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This type is no longer used.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int ANCHOR_TYPE = 1; // 0x1

/**
 * HitTestResult for hitting an edit text area.
 * @apiSince 1
 */

public static final int EDIT_TEXT_TYPE = 9; // 0x9

/**
 * HitTestResult for hitting an email address.
 * @apiSince 1
 */

public static final int EMAIL_TYPE = 4; // 0x4

/**
 * HitTestResult for hitting a map address.
 * @apiSince 1
 */

public static final int GEO_TYPE = 3; // 0x3

/**
 * @deprecated This type is no longer used.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int IMAGE_ANCHOR_TYPE = 6; // 0x6

/**
 * HitTestResult for hitting an HTML::img tag.
 * @apiSince 1
 */

public static final int IMAGE_TYPE = 5; // 0x5

/**
 * HitTestResult for hitting a phone number.
 * @apiSince 1
 */

public static final int PHONE_TYPE = 2; // 0x2

/**
 * HitTestResult for hitting a HTML::a tag with src=http.
 * @apiSince 1
 */

public static final int SRC_ANCHOR_TYPE = 7; // 0x7

/**
 * HitTestResult for hitting a HTML::a tag with src=http + HTML::img.
 * @apiSince 1
 */

public static final int SRC_IMAGE_ANCHOR_TYPE = 8; // 0x8

/**
 * Default HitTestResult, where the target is unknown.
 * @apiSince 1
 */

public static final int UNKNOWN_TYPE = 0; // 0x0
}

/**
 * Interface to listen for new pictures as they change.
 *
 * @deprecated This interface is now obsolete.
 * @apiSince 1
 * @deprecatedSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface PictureListener {

/**
 * Used to provide notification that the WebView's picture has changed.
 * See {@link android.webkit.WebView#capturePicture WebView#capturePicture} for details of the picture.
 *
 * @param view the WebView that owns the picture
 * @param picture the new picture. Applications targeting
 *     {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2} or above
 *     will always receive a {@code null} Picture.
 * This value may be {@code null}.
 * @deprecated Deprecated due to internal changes.
 * @apiSince 1
 * @deprecatedSince 12
 */

@Deprecated
public void onNewPicture(android.webkit.WebView view, @androidx.annotation.Nullable android.graphics.Picture picture);
}

/**
 * Callback interface supplied to {@link #postVisualStateCallback} for receiving
 * notifications about the visual state.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class VisualStateCallback {

public VisualStateCallback() { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the visual state is ready to be drawn in the next {@link #onDraw}.
 *
 * @param requestId The identifier passed to {@link #postVisualStateCallback} when this
 *                  callback was posted.
 * @apiSince 23
 */

public abstract void onComplete(long requestId);
}

/**
 *  Transportation object for returning WebView across thread boundaries.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WebViewTransport {

public WebViewTransport() { throw new RuntimeException("Stub!"); }

/**
 * Sets the WebView to the transportation object.
 *
 * @param webview the WebView to transport
 * @apiSince 1
 */

public synchronized void setWebView(android.webkit.WebView webview) { throw new RuntimeException("Stub!"); }

/**
 * Gets the WebView object.
 *
 * @return the transported WebView object
 * @apiSince 1
 */

public synchronized android.webkit.WebView getWebView() { throw new RuntimeException("Stub!"); }
}

}

