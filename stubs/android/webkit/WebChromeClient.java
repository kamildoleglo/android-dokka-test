/*
 * Copyright (C) 2008 The Android Open Source Project
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

import android.graphics.Bitmap;
import android.view.View;
import android.content.pm.ActivityInfo;
import android.os.Message;
import android.content.Intent;

/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WebChromeClient {

public WebChromeClient() { throw new RuntimeException("Stub!"); }

/**
 * Tell the host application the current progress of loading a page.
 * @param view The WebView that initiated the callback.
 * @param newProgress Current page loading progress, represented by
 *                    an integer between 0 and 100.
 * @apiSince 1
 */

public void onProgressChanged(android.webkit.WebView view, int newProgress) { throw new RuntimeException("Stub!"); }

/**
 * Notify the host application of a change in the document title.
 * @param view The WebView that initiated the callback.
 * @param title A String containing the new title of the document.
 * @apiSince 1
 */

public void onReceivedTitle(android.webkit.WebView view, java.lang.String title) { throw new RuntimeException("Stub!"); }

/**
 * Notify the host application of a new favicon for the current page.
 * @param view The WebView that initiated the callback.
 * @param icon A Bitmap containing the favicon for the current page.
 * @apiSince 1
 */

public void onReceivedIcon(android.webkit.WebView view, android.graphics.Bitmap icon) { throw new RuntimeException("Stub!"); }

/**
 * Notify the host application of the url for an apple-touch-icon.
 * @param view The WebView that initiated the callback.
 * @param url The icon url.
 * @param precomposed {@code true} if the url is for a precomposed touch icon.
 * @apiSince 7
 */

public void onReceivedTouchIconUrl(android.webkit.WebView view, java.lang.String url, boolean precomposed) { throw new RuntimeException("Stub!"); }

/**
 * Notify the host application that the current page has entered full
 * screen mode. The host application must show the custom View which
 * contains the web contents &mdash; video or other HTML content &mdash;
 * in full screen mode. Also see "Full screen support" documentation on
 * {@link android.webkit.WebView WebView}.
 * @param view is the View object to be shown.
 * @param callback invoke this callback to request the page to exit
 * full screen mode.
 * @apiSince 7
 */

public void onShowCustomView(android.view.View view, android.webkit.WebChromeClient.CustomViewCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Notify the host application that the current page would
 * like to show a custom View in a particular orientation.
 * @param view is the View object to be shown.
 * @param requestedOrientation An orientation constant as used in
 * {@link android.content.pm.ActivityInfo#screenOrientation ActivityInfo#screenOrientation}.
 * @param callback is the callback to be invoked if and when the view
 * is dismissed.
 * @deprecated This method supports the obsolete plugin mechanism,
 * and will not be invoked in future
 * @apiSince 14
 * @deprecatedSince 18
 */

@Deprecated
public void onShowCustomView(android.view.View view, int requestedOrientation, android.webkit.WebChromeClient.CustomViewCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Notify the host application that the current page has exited full
 * screen mode. The host application must hide the custom View, ie. the
 * View passed to {@link #onShowCustomView} when the content entered fullscreen.
 * Also see "Full screen support" documentation on {@link android.webkit.WebView WebView}.
 * @apiSince 7
 */

public void onHideCustomView() { throw new RuntimeException("Stub!"); }

/**
 * Request the host application to create a new window. If the host
 * application chooses to honor this request, it should return {@code true} from
 * this method, create a new WebView to host the window, insert it into the
 * View system and send the supplied resultMsg message to its target with
 * the new WebView as an argument. If the host application chooses not to
 * honor the request, it should return {@code false} from this method. The default
 * implementation of this method does nothing and hence returns {@code false}.
 * <p>
 * Applications should typically not allow windows to be created when the
 * {@code isUserGesture} flag is false, as this may be an unwanted popup.
 * <p>
 * Applications should be careful how they display the new window: don't simply
 * overlay it over the existing WebView as this may mislead the user about which
 * site they are viewing. If your application displays the URL of the main page,
 * make sure to also display the URL of the new window in a similar fashion. If
 * your application does not display URLs, consider disallowing the creation of
 * new windows entirely.
 * <p class="note"><b>Note:</b> There is no trustworthy way to tell which page
 * requested the new window: the request might originate from a third-party iframe
 * inside the WebView.
 *
 * @param view The WebView from which the request for a new window
 *             originated.
 * @param isDialog {@code true} if the new window should be a dialog, rather than
 *                 a full-size window.
 * @param isUserGesture {@code true} if the request was initiated by a user gesture,
 *                      such as the user clicking a link.
 * @param resultMsg The message to send when once a new WebView has been
 *                  created. resultMsg.obj is a
 *                  {@link android.webkit.WebView.WebViewTransport WebView.WebViewTransport} object. This should be
 *                  used to transport the new WebView, by calling
 *                  {@link android.webkit.WebView.WebViewTransport#setWebView(android.webkit.WebView) WebView.WebViewTransport#setWebView(WebView)}.
 * @return This method should return {@code true} if the host application will
 *         create a new window, in which case resultMsg should be sent to
 *         its target. Otherwise, this method should return {@code false}. Returning
 *         {@code false} from this method but also sending resultMsg will result in
 *         undefined behavior.
 * @apiSince 1
 */

public boolean onCreateWindow(android.webkit.WebView view, boolean isDialog, boolean isUserGesture, android.os.Message resultMsg) { throw new RuntimeException("Stub!"); }

/**
 * Request display and focus for this WebView. This may happen due to
 * another WebView opening a link in this WebView and requesting that this
 * WebView be displayed.
 * @param view The WebView that needs to be focused.
 * @apiSince 1
 */

public void onRequestFocus(android.webkit.WebView view) { throw new RuntimeException("Stub!"); }

/**
 * Notify the host application to close the given WebView and remove it
 * from the view system if necessary. At this point, WebCore has stopped
 * any loading in this window and has removed any cross-scripting ability
 * in javascript.
 * <p>
 * As with {@link #onCreateWindow}, the application should ensure that any
 * URL or security indicator displayed is updated so that the user can tell
 * that the page they were interacting with has been closed.
 *
 * @param window The WebView that needs to be closed.
 * @apiSince 1
 */

public void onCloseWindow(android.webkit.WebView window) { throw new RuntimeException("Stub!"); }

/**
 * Tell the client to display a javascript alert dialog.  If the client
 * returns {@code true}, WebView will assume that the client will handle the
 * dialog.  If the client returns {@code false}, it will continue execution.
 * @param view The WebView that initiated the callback.
 * @param url The url of the page requesting the dialog.
 * @param message Message to be displayed in the window.
 * @param result A JsResult to confirm that the user hit enter.
 * @return boolean Whether the client will handle the alert dialog.
 * @apiSince 1
 */

public boolean onJsAlert(android.webkit.WebView view, java.lang.String url, java.lang.String message, android.webkit.JsResult result) { throw new RuntimeException("Stub!"); }

/**
 * Tell the client to display a confirm dialog to the user. If the client
 * returns {@code true}, WebView will assume that the client will handle the
 * confirm dialog and call the appropriate JsResult method. If the
 * client returns false, a default value of {@code false} will be returned to
 * javascript. The default behavior is to return {@code false}.
 * @param view The WebView that initiated the callback.
 * @param url The url of the page requesting the dialog.
 * @param message Message to be displayed in the window.
 * @param result A JsResult used to send the user's response to
 *               javascript.
 * @return boolean Whether the client will handle the confirm dialog.
 * @apiSince 1
 */

public boolean onJsConfirm(android.webkit.WebView view, java.lang.String url, java.lang.String message, android.webkit.JsResult result) { throw new RuntimeException("Stub!"); }

/**
 * Tell the client to display a prompt dialog to the user. If the client
 * returns {@code true}, WebView will assume that the client will handle the
 * prompt dialog and call the appropriate JsPromptResult method. If the
 * client returns false, a default value of {@code false} will be returned to to
 * javascript. The default behavior is to return {@code false}.
 * @param view The WebView that initiated the callback.
 * @param url The url of the page requesting the dialog.
 * @param message Message to be displayed in the window.
 * @param defaultValue The default value displayed in the prompt dialog.
 * @param result A JsPromptResult used to send the user's reponse to
 *               javascript.
 * @return boolean Whether the client will handle the prompt dialog.
 * @apiSince 1
 */

public boolean onJsPrompt(android.webkit.WebView view, java.lang.String url, java.lang.String message, java.lang.String defaultValue, android.webkit.JsPromptResult result) { throw new RuntimeException("Stub!"); }

/**
 * Tell the client to display a dialog to confirm navigation away from the
 * current page. This is the result of the onbeforeunload javascript event.
 * If the client returns {@code true}, WebView will assume that the client will
 * handle the confirm dialog and call the appropriate JsResult method. If
 * the client returns {@code false}, a default value of {@code true} will be returned to
 * javascript to accept navigation away from the current page. The default
 * behavior is to return {@code false}. Setting the JsResult to {@code true} will navigate
 * away from the current page, {@code false} will cancel the navigation.
 * @param view The WebView that initiated the callback.
 * @param url The url of the page requesting the dialog.
 * @param message Message to be displayed in the window.
 * @param result A JsResult used to send the user's response to
 *               javascript.
 * @return boolean Whether the client will handle the confirm dialog.
 * @apiSince 1
 */

public boolean onJsBeforeUnload(android.webkit.WebView view, java.lang.String url, java.lang.String message, android.webkit.JsResult result) { throw new RuntimeException("Stub!"); }

/**
 * Tell the client that the quota has been exceeded for the Web SQL Database
 * API for a particular origin and request a new quota. The client must
 * respond by invoking the
 * {@link android.webkit.WebStorage.QuotaUpdater#updateQuota(long) WebStorage.QuotaUpdater#updateQuota(long)}
 * method of the supplied {@link android.webkit.WebStorage.QuotaUpdater WebStorage.QuotaUpdater} instance. The
 * minimum value that can be set for the new quota is the current quota. The
 * default implementation responds with the current quota, so the quota will
 * not be increased.
 * @param url The URL of the page that triggered the notification
 * @param databaseIdentifier The identifier of the database where the quota
 *                           was exceeded.
 * @param quota The quota for the origin, in bytes
 * @param estimatedDatabaseSize The estimated size of the offending
 *                              database, in bytes
 * @param totalQuota The total quota for all origins, in bytes
 * @param quotaUpdater An instance of {@link android.webkit.WebStorage.QuotaUpdater WebStorage.QuotaUpdater} which
 *                     must be used to inform the WebView of the new quota.
 * @deprecated This method is no longer called; WebView now uses the HTML5 / JavaScript Quota
 *             Management API.
 * @apiSince 5
 * @deprecatedSince 19
 */

@Deprecated
public void onExceededDatabaseQuota(java.lang.String url, java.lang.String databaseIdentifier, long quota, long estimatedDatabaseSize, long totalQuota, android.webkit.WebStorage.QuotaUpdater quotaUpdater) { throw new RuntimeException("Stub!"); }

/**
 * Notify the host application that the Application Cache has reached the
 * maximum size. The client must respond by invoking the
 * {@link android.webkit.WebStorage.QuotaUpdater#updateQuota(long) WebStorage.QuotaUpdater#updateQuota(long)}
 * method of the supplied {@link android.webkit.WebStorage.QuotaUpdater WebStorage.QuotaUpdater} instance. The
 * minimum value that can be set for the new quota is the current quota. The
 * default implementation responds with the current quota, so the quota will
 * not be increased.
 * @param requiredStorage The amount of storage required by the Application
 *                        Cache operation that triggered this notification,
 *                        in bytes.
 * @param quota the current maximum Application Cache size, in bytes
 * @param quotaUpdater An instance of {@link android.webkit.WebStorage.QuotaUpdater WebStorage.QuotaUpdater} which
 *                     must be used to inform the WebView of the new quota.
 * @deprecated This method is no longer called; WebView now uses the HTML5 / JavaScript Quota
 *             Management API.
 * @apiSince 7
 * @deprecatedSince 19
 */

@Deprecated
public void onReachedMaxAppCacheSize(long requiredStorage, long quota, android.webkit.WebStorage.QuotaUpdater quotaUpdater) { throw new RuntimeException("Stub!"); }

/**
 * Notify the host application that web content from the specified origin
 * is attempting to use the Geolocation API, but no permission state is
 * currently set for that origin. The host application should invoke the
 * specified callback with the desired permission state. See
 * {@link android.webkit.GeolocationPermissions GeolocationPermissions} for details.
 *
 * <p>Note that for applications targeting Android N and later SDKs
 * (API level > {@link android.os.Build.VERSION_CODES#M})
 * this method is only called for requests originating from secure
 * origins such as https. On non-secure origins geolocation requests
 * are automatically denied.
 *
 * @param origin The origin of the web content attempting to use the
 *               Geolocation API.
 * @param callback The callback to use to set the permission state for the
 *                 origin.
 * @apiSince 5
 */

public void onGeolocationPermissionsShowPrompt(java.lang.String origin, android.webkit.GeolocationPermissions.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Notify the host application that a request for Geolocation permissions,
 * made with a previous call to
 * {@link #onGeolocationPermissionsShowPrompt(java.lang.String,android.webkit.GeolocationPermissions.Callback) onGeolocationPermissionsShowPrompt()}
 * has been canceled. Any related UI should therefore be hidden.
 * @apiSince 5
 */

public void onGeolocationPermissionsHidePrompt() { throw new RuntimeException("Stub!"); }

/**
 * Notify the host application that web content is requesting permission to
 * access the specified resources and the permission currently isn't granted
 * or denied. The host application must invoke {@link android.webkit.PermissionRequest#grant(java.lang.String[]) PermissionRequest#grant(String[])}
 * or {@link android.webkit.PermissionRequest#deny() PermissionRequest#deny()}.
 *
 * If this method isn't overridden, the permission is denied.
 *
 * @param request the PermissionRequest from current web content.
 * @apiSince 21
 */

public void onPermissionRequest(android.webkit.PermissionRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Notify the host application that the given permission request
 * has been canceled. Any related UI should therefore be hidden.
 *
 * @param request the PermissionRequest that needs be canceled.
 * @apiSince 21
 */

public void onPermissionRequestCanceled(android.webkit.PermissionRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Tell the client that a JavaScript execution timeout has occured. And the
 * client may decide whether or not to interrupt the execution. If the
 * client returns {@code true}, the JavaScript will be interrupted. If the client
 * returns {@code false}, the execution will continue. Note that in the case of
 * continuing execution, the timeout counter will be reset, and the callback
 * will continue to occur if the script does not finish at the next check
 * point.
 * @return boolean Whether the JavaScript execution should be interrupted.
 * @deprecated This method is no longer supported and will not be invoked.
 * @apiSince 7
 * @deprecatedSince 17
 */

@Deprecated
public boolean onJsTimeout() { throw new RuntimeException("Stub!"); }

/**
 * Report a JavaScript error message to the host application. The ChromeClient
 * should override this to process the log message as they see fit.
 * @param message The error message to report.
 * @param lineNumber The line number of the error.
 * @param sourceID The name of the source file that caused the error.
 * @deprecated Use {@link #onConsoleMessage(android.webkit.ConsoleMessage) onConsoleMessage(ConsoleMessage)}
 *      instead.
 * @apiSince 7
 * @deprecatedSince 15
 */

@Deprecated
public void onConsoleMessage(java.lang.String message, int lineNumber, java.lang.String sourceID) { throw new RuntimeException("Stub!"); }

/**
 * Report a JavaScript console message to the host application. The ChromeClient
 * should override this to process the log message as they see fit.
 * @param consoleMessage Object containing details of the console message.
 * @return {@code true} if the message is handled by the client.
 * @apiSince 8
 */

public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) { throw new RuntimeException("Stub!"); }

/**
 * When not playing, video elements are represented by a 'poster' image. The
 * image to use can be specified by the poster attribute of the video tag in
 * HTML. If the attribute is absent, then a default poster will be used. This
 * method allows the ChromeClient to provide that default image.
 *
 * @return Bitmap The image to use as a default poster, or {@code null} if no such image is
 * available.
 * @apiSince 7
 */

@androidx.annotation.Nullable
public android.graphics.Bitmap getDefaultVideoPoster() { throw new RuntimeException("Stub!"); }

/**
 * Obtains a View to be displayed while buffering of full screen video is taking
 * place. The host application can override this method to provide a View
 * containing a spinner or similar.
 *
 * @return View The View to be displayed whilst the video is loading.
 
 * This value may be {@code null}.
 * @apiSince 7
 */

@androidx.annotation.Nullable
public android.view.View getVideoLoadingProgressView() { throw new RuntimeException("Stub!"); }

/** Obtains a list of all visited history items, used for link coloring
 @apiSince 7
 */

public void getVisitedHistory(android.webkit.ValueCallback<java.lang.String[]> callback) { throw new RuntimeException("Stub!"); }

/**
 * Tell the client to show a file chooser.
 *
 * This is called to handle HTML forms with 'file' input type, in response to the
 * user pressing the "Select File" button.
 * To cancel the request, call <code>filePathCallback.onReceiveValue(null)</code> and
 * return {@code true}.
 *
 * @param webView The WebView instance that is initiating the request.
 * @param filePathCallback Invoke this callback to supply the list of paths to files to upload,
 *                         or {@code null} to cancel. Must only be called if the
 *                         {@link #onShowFileChooser} implementation returns {@code true}.
 * @param fileChooserParams Describes the mode of file chooser to be opened, and options to be
 *                          used with it.
 * @return {@code true} if filePathCallback will be invoked, {@code false} to use default
 *         handling.
 *
 * @see android.webkit.WebChromeClient.FileChooserParams
 * @apiSince 21
 */

public boolean onShowFileChooser(android.webkit.WebView webView, android.webkit.ValueCallback<android.net.Uri[]> filePathCallback, android.webkit.WebChromeClient.FileChooserParams fileChooserParams) { throw new RuntimeException("Stub!"); }
/**
 * A callback interface used by the host application to notify
 * the current page that its custom view has been dismissed.
 * @apiSince 7
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface CustomViewCallback {

/**
 * Invoked when the host application dismisses the
 * custom view.
 * @apiSince 7
 */

public void onCustomViewHidden();
}

/**
 * Parameters used in the {@link #onShowFileChooser} method.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class FileChooserParams {

public FileChooserParams() { throw new RuntimeException("Stub!"); }

/**
 * Parse the result returned by the file picker activity. This method should be used with
 * {@link #createIntent}. Refer to {@link #createIntent} for how to use it.
 *
 * @param resultCode the integer result code returned by the file picker activity.
 * @param data the intent returned by the file picker activity.
 * @return the Uris of selected file(s) or {@code null} if the resultCode indicates
 *         activity canceled or any other error.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public static android.net.Uri[] parseResult(int resultCode, android.content.Intent data) { throw new RuntimeException("Stub!"); }

/**
 * Returns file chooser mode.
 * @apiSince 21
 */

public abstract int getMode();

/**
 * Returns an array of acceptable MIME types. The returned MIME type
 * could be partial such as audio/*. The array will be empty if no
 * acceptable types are specified.
 * @apiSince 21
 */

public abstract java.lang.String[] getAcceptTypes();

/**
 * Returns preference for a live media captured value (e.g.&nbsp;Camera, Microphone).
 * True indicates capture is enabled, {@code false} disabled.
 *
 * Use <code>getAcceptTypes</code> to determine suitable capture devices.
 * @apiSince 21
 */

public abstract boolean isCaptureEnabled();

/**
 * Returns the title to use for this file selector. If {@code null} a default title should
 * be used.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public abstract java.lang.CharSequence getTitle();

/**
 * The file name of a default selection if specified, or {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public abstract java.lang.String getFilenameHint();

/**
 * Creates an intent that would start a file picker for file selection.
 * The Intent supports choosing files from simple file sources available
 * on the device. Some advanced sources (for example, live media capture)
 * may not be supported and applications wishing to support these sources
 * or more advanced file operations should build their own Intent.
 *
 * <p>How to use:
 * <ol>
 *   <li>Build an intent using {@link #createIntent}</li>
 *   <li>Fire the intent using {@link android.app.Activity#startActivityForResult}.</li>
 *   <li>Check for ActivityNotFoundException and take a user friendly action if thrown.</li>
 *   <li>Listen the result using {@link android.app.Activity#onActivityResult}</li>
 *   <li>Parse the result using {@link #parseResult} only if media capture was not
 *   requested.</li>
 *   <li>Send the result using filePathCallback of {@link android.webkit.WebChromeClient#onShowFileChooser WebChromeClient#onShowFileChooser}</li>
 * </ol>
 *
 * @return an Intent that supports basic file chooser sources.
 * @apiSince 21
 */

public abstract android.content.Intent createIntent();

/**
 * Open single file. Requires that the file exists before allowing the user to pick it.
 * @apiSince 21
 */

public static final int MODE_OPEN = 0; // 0x0

/**
 * Like Open but allows multiple files to be selected.
 * @apiSince 21
 */

public static final int MODE_OPEN_MULTIPLE = 1; // 0x1

/**
 *  Allows picking a nonexistent file and saving it.
 * @apiSince 21
 */

public static final int MODE_SAVE = 3; // 0x3
}

}

