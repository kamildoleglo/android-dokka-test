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
 * Manages settings state for a WebView. When a WebView is first created, it
 * obtains a set of default settings. These default settings will be returned
 * from any getter call. A {@code WebSettings} object obtained from
 * {@link android.webkit.WebView#getSettings() WebView#getSettings()} is tied to the life of the WebView. If a WebView has
 * been destroyed, any method call on {@code WebSettings} will throw an
 * {@link java.lang.IllegalStateException IllegalStateException}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class WebSettings {

public WebSettings() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the WebView should support zooming using its on-screen zoom
 * controls and gestures. The particular zoom mechanisms that should be used
 * can be set with {@link #setBuiltInZoomControls}. This setting does not
 * affect zooming performed using the {@link android.webkit.WebView#zoomIn() WebView#zoomIn()} and
 * {@link android.webkit.WebView#zoomOut() WebView#zoomOut()} methods. The default is {@code true}.
 *
 * @param support whether the WebView should support zoom
 * @apiSince 1
 */

public abstract void setSupportZoom(boolean support);

/**
 * Gets whether the WebView supports zoom.
 *
 * @return {@code true} if the WebView supports zoom
 * @see #setSupportZoom
 * @apiSince 1
 */

public abstract boolean supportZoom();

/**
 * Sets whether the WebView requires a user gesture to play media.
 * The default is {@code true}.
 *
 * @param require whether the WebView requires a user gesture to play media
 * @apiSince 17
 */

public abstract void setMediaPlaybackRequiresUserGesture(boolean require);

/**
 * Gets whether the WebView requires a user gesture to play media.
 *
 * @return {@code true} if the WebView requires a user gesture to play media
 * @see #setMediaPlaybackRequiresUserGesture
 * @apiSince 17
 */

public abstract boolean getMediaPlaybackRequiresUserGesture();

/**
 * Sets whether the WebView should use its built-in zoom mechanisms. The
 * built-in zoom mechanisms comprise on-screen zoom controls, which are
 * displayed over the WebView's content, and the use of a pinch gesture to
 * control zooming. Whether or not these on-screen controls are displayed
 * can be set with {@link #setDisplayZoomControls}. The default is {@code false}.
 * <p>
 * The built-in mechanisms are the only currently supported zoom
 * mechanisms, so it is recommended that this setting is always enabled.
 *
 * @param enabled whether the WebView should use its built-in zoom mechanisms
 * @apiSince 3
 */

public abstract void setBuiltInZoomControls(boolean enabled);

/**
 * Gets whether the zoom mechanisms built into WebView are being used.
 *
 * @return {@code true} if the zoom mechanisms built into WebView are being used
 * @see #setBuiltInZoomControls
 * @apiSince 3
 */

public abstract boolean getBuiltInZoomControls();

/**
 * Sets whether the WebView should display on-screen zoom controls when
 * using the built-in zoom mechanisms. See {@link #setBuiltInZoomControls}.
 * The default is {@code true}.
 *
 * @param enabled whether the WebView should display on-screen zoom controls
 * @apiSince 11
 */

public abstract void setDisplayZoomControls(boolean enabled);

/**
 * Gets whether the WebView displays on-screen zoom controls when using
 * the built-in zoom mechanisms.
 *
 * @return {@code true} if the WebView displays on-screen zoom controls when using
 *         the built-in zoom mechanisms
 * @see #setDisplayZoomControls
 * @apiSince 11
 */

public abstract boolean getDisplayZoomControls();

/**
 * Enables or disables file access within WebView. File access is enabled by
 * default.  Note that this enables or disables file system access only.
 * Assets and resources are still accessible using file:///android_asset and
 * file:///android_res.
 * @apiSince 3
 */

public abstract void setAllowFileAccess(boolean allow);

/**
 * Gets whether this WebView supports file access.
 *
 * @see #setAllowFileAccess
 * @apiSince 3
 */

public abstract boolean getAllowFileAccess();

/**
 * Enables or disables content URL access within WebView.  Content URL
 * access allows WebView to load content from a content provider installed
 * in the system. The default is enabled.
 * @apiSince 11
 */

public abstract void setAllowContentAccess(boolean allow);

/**
 * Gets whether this WebView supports content URL access.
 *
 * @see #setAllowContentAccess
 * @apiSince 11
 */

public abstract boolean getAllowContentAccess();

/**
 * Sets whether the WebView loads pages in overview mode, that is,
 * zooms out the content to fit on screen by width. This setting is
 * taken into account when the content width is greater than the width
 * of the WebView control, for example, when {@link #getUseWideViewPort}
 * is enabled. The default is {@code false}.
 * @apiSince 7
 */

public abstract void setLoadWithOverviewMode(boolean overview);

/**
 * Gets whether this WebView loads pages in overview mode.
 *
 * @return whether this WebView loads pages in overview mode
 * @see #setLoadWithOverviewMode
 * @apiSince 7
 */

public abstract boolean getLoadWithOverviewMode();

/**
 * Sets whether the WebView will enable smooth transition while panning or
 * zooming or while the window hosting the WebView does not have focus.
 * If it is {@code true}, WebView will choose a solution to maximize the performance.
 * e.g. the WebView's content may not be updated during the transition.
 * If it is false, WebView will keep its fidelity. The default value is {@code false}.
 *
 * @deprecated This method is now obsolete, and will become a no-op in future.
 * @apiSince 11
 * @deprecatedSince 17
 */

@Deprecated
public abstract void setEnableSmoothTransition(boolean enable);

/**
 * Gets whether the WebView enables smooth transition while panning or
 * zooming.
 *
 * @see #setEnableSmoothTransition
 *
 * @deprecated This method is now obsolete, and will become a no-op in future.
 * @apiSince 11
 * @deprecatedSince 17
 */

@Deprecated
public abstract boolean enableSmoothTransition();

/**
 * Sets whether the WebView should save form data. In Android O, the
 * platform has implemented a fully functional Autofill feature to store
 * form data. Therefore, the Webview form data save feature is disabled.
 *
 * Note that the feature will continue to be supported on older versions of
 * Android as before.
 *
 * @deprecated In Android O and afterwards, this function does not have
 * any effect, the form data will be saved to platform's autofill service
 * if applicable.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public abstract void setSaveFormData(boolean save);

/**
 * Gets whether the WebView saves form data.
 *
 * @return whether the WebView saves form data
 * @see #setSaveFormData
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public abstract boolean getSaveFormData();

/**
 * Sets whether the WebView should save passwords. The default is {@code true}.
 * @deprecated Saving passwords in WebView will not be supported in future versions.
 * @apiSince 1
 * @deprecatedSince 18
 */

@Deprecated
public abstract void setSavePassword(boolean save);

/**
 * Gets whether the WebView saves passwords.
 *
 * @return whether the WebView saves passwords
 * @see #setSavePassword
 * @deprecated Saving passwords in WebView will not be supported in future versions.
 * @apiSince 1
 * @deprecatedSince 18
 */

@Deprecated
public abstract boolean getSavePassword();

/**
 * Sets the text zoom of the page in percent. The default is 100.
 *
 * @param textZoom the text zoom in percent
 * @apiSince 14
 */

public abstract void setTextZoom(int textZoom);

/**
 * Gets the text zoom of the page in percent.
 *
 * @return the text zoom of the page in percent
 * @see #setTextZoom
 * @apiSince 14
 */

public abstract int getTextZoom();

/**
 * Sets the text size of the page. The default is {@link android.webkit.WebSettings.TextSize#NORMAL TextSize#NORMAL}.
 *
 * @param t the text size as a {@link android.webkit.WebSettings.TextSize TextSize} value
 * @deprecated Use {@link #setTextZoom} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public synchronized void setTextSize(android.webkit.WebSettings.TextSize t) { throw new RuntimeException("Stub!"); }

/**
 * Gets the text size of the page. If the text size was previously specified
 * in percent using {@link #setTextZoom}, this will return the closest
 * matching {@link android.webkit.WebSettings.TextSize TextSize}.
 *
 * @return the text size as a {@link android.webkit.WebSettings.TextSize TextSize} value
 * @see #setTextSize
 * @deprecated Use {@link #getTextZoom} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public synchronized android.webkit.WebSettings.TextSize getTextSize() { throw new RuntimeException("Stub!"); }

/**
 * Sets the default zoom density of the page. This must be called from the UI
 * thread. The default is {@link android.webkit.WebSettings.ZoomDensity#MEDIUM ZoomDensity#MEDIUM}.
 *
 * This setting is not recommended for use in new applications.  If the WebView
 * is utilized to display mobile-oriented pages, the desired effect can be achieved by
 * adjusting 'width' and 'initial-scale' attributes of page's 'meta viewport'
 * tag. For pages lacking the tag, {@link android.webkit.WebView#setInitialScale}
 * and {@link #setUseWideViewPort} can be used.
 *
 * @param zoom the zoom density
 * @deprecated This method is no longer supported, see the function documentation for
 *             recommended alternatives.
 * @apiSince 7
 * @deprecatedSince 19
 */

@Deprecated
public abstract void setDefaultZoom(android.webkit.WebSettings.ZoomDensity zoom);

/**
 * Gets the default zoom density of the page. This should be called from
 * the UI thread.
 *
 * This setting is not recommended for use in new applications.
 *
 * @return the zoom density
 * @see #setDefaultZoom
 * @deprecated Will only return the default value.
 * @apiSince 7
 * @deprecatedSince 19
 */

@Deprecated
public abstract android.webkit.WebSettings.ZoomDensity getDefaultZoom();

/**
 * Enables using light touches to make a selection and activate mouseovers.
 * @deprecated From {@link android.os.Build.VERSION_CODES#JELLY_BEAN} this
 *             setting is obsolete and has no effect.
 * @apiSince 1
 * @deprecatedSince 18
 */

@Deprecated
public abstract void setLightTouchEnabled(boolean enabled);

/**
 * Gets whether light touches are enabled.
 * @see #setLightTouchEnabled
 * @deprecated This setting is obsolete.
 * @apiSince 1
 * @deprecatedSince 18
 */

@Deprecated
public abstract boolean getLightTouchEnabled();

/**
 * Sets whether the WebView should enable support for the &quot;viewport&quot;
 * HTML meta tag or should use a wide viewport.
 * When the value of the setting is {@code false}, the layout width is always set to the
 * width of the WebView control in device-independent (CSS) pixels.
 * When the value is {@code true} and the page contains the viewport meta tag, the value
 * of the width specified in the tag is used. If the page does not contain the tag or
 * does not provide a width, then a wide viewport will be used.
 *
 * @param use whether to enable support for the viewport meta tag
 * @apiSince 1
 */

public abstract void setUseWideViewPort(boolean use);

/**
 * Gets whether the WebView supports the &quot;viewport&quot;
 * HTML meta tag or will use a wide viewport.
 *
 * @return {@code true} if the WebView supports the viewport meta tag
 * @see #setUseWideViewPort
 * @apiSince 1
 */

public abstract boolean getUseWideViewPort();

/**
 * Sets whether the WebView whether supports multiple windows. If set to
 * true, {@link android.webkit.WebChromeClient#onCreateWindow WebChromeClient#onCreateWindow} must be implemented by the
 * host application. The default is {@code false}.
 *
 * @param support whether to support multiple windows
 * @apiSince 1
 */

public abstract void setSupportMultipleWindows(boolean support);

/**
 * Gets whether the WebView supports multiple windows.
 *
 * @return {@code true} if the WebView supports multiple windows
 * @see #setSupportMultipleWindows
 * @apiSince 1
 */

public abstract boolean supportMultipleWindows();

/**
 * Sets the underlying layout algorithm. This will cause a re-layout of the
 * WebView. The default is {@link android.webkit.WebSettings.LayoutAlgorithm#NARROW_COLUMNS LayoutAlgorithm#NARROW_COLUMNS}.
 *
 * @param l the layout algorithm to use, as a {@link android.webkit.WebSettings.LayoutAlgorithm LayoutAlgorithm} value
 * @apiSince 1
 */

public abstract void setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm l);

/**
 * Gets the current layout algorithm.
 *
 * @return the layout algorithm in use, as a {@link android.webkit.WebSettings.LayoutAlgorithm LayoutAlgorithm} value
 * @see #setLayoutAlgorithm
 * @apiSince 1
 */

public abstract android.webkit.WebSettings.LayoutAlgorithm getLayoutAlgorithm();

/**
 * Sets the standard font family name. The default is "sans-serif".
 *
 * @param font a font family name
 * @apiSince 1
 */

public abstract void setStandardFontFamily(java.lang.String font);

/**
 * Gets the standard font family name.
 *
 * @return the standard font family name as a string
 * @see #setStandardFontFamily
 * @apiSince 1
 */

public abstract java.lang.String getStandardFontFamily();

/**
 * Sets the fixed font family name. The default is "monospace".
 *
 * @param font a font family name
 * @apiSince 1
 */

public abstract void setFixedFontFamily(java.lang.String font);

/**
 * Gets the fixed font family name.
 *
 * @return the fixed font family name as a string
 * @see #setFixedFontFamily
 * @apiSince 1
 */

public abstract java.lang.String getFixedFontFamily();

/**
 * Sets the sans-serif font family name. The default is "sans-serif".
 *
 * @param font a font family name
 * @apiSince 1
 */

public abstract void setSansSerifFontFamily(java.lang.String font);

/**
 * Gets the sans-serif font family name.
 *
 * @return the sans-serif font family name as a string
 * @see #setSansSerifFontFamily
 * @apiSince 1
 */

public abstract java.lang.String getSansSerifFontFamily();

/**
 * Sets the serif font family name. The default is "sans-serif".
 *
 * @param font a font family name
 * @apiSince 1
 */

public abstract void setSerifFontFamily(java.lang.String font);

/**
 * Gets the serif font family name. The default is "serif".
 *
 * @return the serif font family name as a string
 * @see #setSerifFontFamily
 * @apiSince 1
 */

public abstract java.lang.String getSerifFontFamily();

/**
 * Sets the cursive font family name. The default is "cursive".
 *
 * @param font a font family name
 * @apiSince 1
 */

public abstract void setCursiveFontFamily(java.lang.String font);

/**
 * Gets the cursive font family name.
 *
 * @return the cursive font family name as a string
 * @see #setCursiveFontFamily
 * @apiSince 1
 */

public abstract java.lang.String getCursiveFontFamily();

/**
 * Sets the fantasy font family name. The default is "fantasy".
 *
 * @param font a font family name
 * @apiSince 1
 */

public abstract void setFantasyFontFamily(java.lang.String font);

/**
 * Gets the fantasy font family name.
 *
 * @return the fantasy font family name as a string
 * @see #setFantasyFontFamily
 * @apiSince 1
 */

public abstract java.lang.String getFantasyFontFamily();

/**
 * Sets the minimum font size. The default is 8.
 *
 * @param size a non-negative integer between 1 and 72. Any number outside
 *             the specified range will be pinned.
 * @apiSince 1
 */

public abstract void setMinimumFontSize(int size);

/**
 * Gets the minimum font size.
 *
 * @return a non-negative integer between 1 and 72
 * @see #setMinimumFontSize
 * @apiSince 1
 */

public abstract int getMinimumFontSize();

/**
 * Sets the minimum logical font size. The default is 8.
 *
 * @param size a non-negative integer between 1 and 72. Any number outside
 *             the specified range will be pinned.
 * @apiSince 1
 */

public abstract void setMinimumLogicalFontSize(int size);

/**
 * Gets the minimum logical font size.
 *
 * @return a non-negative integer between 1 and 72
 * @see #setMinimumLogicalFontSize
 * @apiSince 1
 */

public abstract int getMinimumLogicalFontSize();

/**
 * Sets the default font size. The default is 16.
 *
 * @param size a non-negative integer between 1 and 72. Any number outside
 *             the specified range will be pinned.
 * @apiSince 1
 */

public abstract void setDefaultFontSize(int size);

/**
 * Gets the default font size.
 *
 * @return a non-negative integer between 1 and 72
 * @see #setDefaultFontSize
 * @apiSince 1
 */

public abstract int getDefaultFontSize();

/**
 * Sets the default fixed font size. The default is 16.
 *
 * @param size a non-negative integer between 1 and 72. Any number outside
 *             the specified range will be pinned.
 * @apiSince 1
 */

public abstract void setDefaultFixedFontSize(int size);

/**
 * Gets the default fixed font size.
 *
 * @return a non-negative integer between 1 and 72
 * @see #setDefaultFixedFontSize
 * @apiSince 1
 */

public abstract int getDefaultFixedFontSize();

/**
 * Sets whether the WebView should load image resources. Note that this method
 * controls loading of all images, including those embedded using the data
 * URI scheme. Use {@link #setBlockNetworkImage} to control loading only
 * of images specified using network URI schemes. Note that if the value of this
 * setting is changed from {@code false} to {@code true}, all images resources referenced
 * by content currently displayed by the WebView are loaded automatically.
 * The default is {@code true}.
 *
 * @param flag whether the WebView should load image resources
 * @apiSince 1
 */

public abstract void setLoadsImagesAutomatically(boolean flag);

/**
 * Gets whether the WebView loads image resources. This includes
 * images embedded using the data URI scheme.
 *
 * @return {@code true} if the WebView loads image resources
 * @see #setLoadsImagesAutomatically
 * @apiSince 1
 */

public abstract boolean getLoadsImagesAutomatically();

/**
 * Sets whether the WebView should not load image resources from the
 * network (resources accessed via http and https URI schemes).  Note
 * that this method has no effect unless
 * {@link #getLoadsImagesAutomatically} returns {@code true}. Also note that
 * disabling all network loads using {@link #setBlockNetworkLoads}
 * will also prevent network images from loading, even if this flag is set
 * to false. When the value of this setting is changed from {@code true} to {@code false},
 * network images resources referenced by content currently displayed by
 * the WebView are fetched automatically. The default is {@code false}.
 *
 * @param flag whether the WebView should not load image resources from the
 *             network
 * @see #setBlockNetworkLoads
 * @apiSince 1
 */

public abstract void setBlockNetworkImage(boolean flag);

/**
 * Gets whether the WebView does not load image resources from the network.
 *
 * @return {@code true} if the WebView does not load image resources from the network
 * @see #setBlockNetworkImage
 * @apiSince 1
 */

public abstract boolean getBlockNetworkImage();

/**
 * Sets whether the WebView should not load resources from the network.
 * Use {@link #setBlockNetworkImage} to only avoid loading
 * image resources. Note that if the value of this setting is
 * changed from {@code true} to {@code false}, network resources referenced by content
 * currently displayed by the WebView are not fetched until
 * {@link android.webkit.WebView#reload} is called.
 * If the application does not have the
 * {@link android.Manifest.permission#INTERNET} permission, attempts to set
 * a value of {@code false} will cause a {@link java.lang.SecurityException}
 * to be thrown. The default value is {@code false} if the application has the
 * {@link android.Manifest.permission#INTERNET} permission, otherwise it is
 * {@code true}.
 *
 * @param flag {@code true} means block network loads by the WebView
 * @see android.webkit.WebView#reload
 * @apiSince 8
 */

public abstract void setBlockNetworkLoads(boolean flag);

/**
 * Gets whether the WebView does not load any resources from the network.
 *
 * @return {@code true} if the WebView does not load any resources from the network
 * @see #setBlockNetworkLoads
 * @apiSince 8
 */

public abstract boolean getBlockNetworkLoads();

/**
 * Tells the WebView to enable JavaScript execution.
 * <b>The default is {@code false}.</b>
 *
 * @param flag {@code true} if the WebView should execute JavaScript
 * @apiSince 1
 */

public abstract void setJavaScriptEnabled(boolean flag);

/**
 * Sets whether JavaScript running in the context of a file scheme URL
 * should be allowed to access content from any origin. This includes
 * access to content from other file scheme URLs. See
 * {@link #setAllowFileAccessFromFileURLs}. To enable the most restrictive,
 * and therefore secure policy, this setting should be disabled.
 * Note that this setting affects only JavaScript access to file scheme
 * resources. Other access to such resources, for example, from image HTML
 * elements, is unaffected. To prevent possible violation of same domain policy
 * when targeting {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH_MR1} and earlier,
 * you should explicitly set this value to {@code false}.
 * <p>
 * The default value is {@code true} for apps targeting
 * {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH_MR1} and below,
 * and {@code false} when targeting {@link android.os.Build.VERSION_CODES#JELLY_BEAN}
 * and above.
 *
 * @param flag whether JavaScript running in the context of a file scheme
 *             URL should be allowed to access content from any origin
 * @apiSince 16
 */

public abstract void setAllowUniversalAccessFromFileURLs(boolean flag);

/**
 * Sets whether JavaScript running in the context of a file scheme URL
 * should be allowed to access content from other file scheme URLs. To
 * enable the most restrictive, and therefore secure, policy this setting
 * should be disabled. Note that the value of this setting is ignored if
 * the value of {@link #getAllowUniversalAccessFromFileURLs} is {@code true}.
 * Note too, that this setting affects only JavaScript access to file scheme
 * resources. Other access to such resources, for example, from image HTML
 * elements, is unaffected. To prevent possible violation of same domain policy
 * when targeting {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH_MR1} and earlier,
 * you should explicitly set this value to {@code false}.
 * <p>
 * The default value is {@code true} for apps targeting
 * {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH_MR1} and below,
 * and {@code false} when targeting {@link android.os.Build.VERSION_CODES#JELLY_BEAN}
 * and above.
 *
 * @param flag whether JavaScript running in the context of a file scheme
 *             URL should be allowed to access content from other file
 *             scheme URLs
 * @apiSince 16
 */

public abstract void setAllowFileAccessFromFileURLs(boolean flag);

/**
 * Tells the WebView to enable, disable, or have plugins on demand. On
 * demand mode means that if a plugin exists that can handle the embedded
 * content, a placeholder icon will be shown instead of the plugin. When
 * the placeholder is clicked, the plugin will be enabled. The default is
 * {@link android.webkit.WebSettings.PluginState#OFF PluginState#OFF}.
 *
 * @param state a PluginState value
 * @deprecated Plugins are not supported in API level
 *             {@link android.os.Build.VERSION_CODES#KITKAT} or later;
 *             enabling plugins is a no-op.
 * @apiSince 8
 * @deprecatedSince 18
 */

@Deprecated
public abstract void setPluginState(android.webkit.WebSettings.PluginState state);

/**
 * Sets the path to where database storage API databases should be saved.
 * In order for the database storage API to function correctly, this method
 * must be called with a path to which the application can write. This
 * method should only be called once: repeated calls are ignored.
 *
 * @param databasePath a path to the directory where databases should be
 *                     saved.
 * @deprecated Database paths are managed by the implementation and calling this method
 *             will have no effect.
 * @apiSince 5
 * @deprecatedSince 19
 */

@Deprecated
public abstract void setDatabasePath(java.lang.String databasePath);

/**
 * Sets the path where the Geolocation databases should be saved. In order
 * for Geolocation permissions and cached positions to be persisted, this
 * method must be called with a path to which the application can write.
 *
 * @param databasePath a path to the directory where databases should be
 *                     saved.
 * @deprecated Geolocation database are managed by the implementation and calling this method
 *             will have no effect.
 * @apiSince 5
 * @deprecatedSince 24
 */

@Deprecated
public abstract void setGeolocationDatabasePath(java.lang.String databasePath);

/**
 * Sets whether the Application Caches API should be enabled. The default
 * is {@code false}. Note that in order for the Application Caches API to be
 * enabled, a valid database path must also be supplied to
 * {@link #setAppCachePath}.
 *
 * @param flag {@code true} if the WebView should enable Application Caches
 * @apiSince 7
 */

public abstract void setAppCacheEnabled(boolean flag);

/**
 * Sets the path to the Application Caches files. In order for the
 * Application Caches API to be enabled, this method must be called with a
 * path to which the application can write. This method should only be
 * called once: repeated calls are ignored.
 *
 * @param appCachePath a String path to the directory containing
 *                     Application Caches files.
 * @see #setAppCacheEnabled
 * @apiSince 7
 */

public abstract void setAppCachePath(java.lang.String appCachePath);

/**
 * Sets the maximum size for the Application Cache content. The passed size
 * will be rounded to the nearest value that the database can support, so
 * this should be viewed as a guide, not a hard limit. Setting the
 * size to a value less than current database size does not cause the
 * database to be trimmed. The default size is {@link java.lang.Long#MAX_VALUE Long#MAX_VALUE}.
 * It is recommended to leave the maximum size set to the default value.
 *
 * @param appCacheMaxSize the maximum size in bytes
 * @deprecated In future quota will be managed automatically.
 * @apiSince 7
 * @deprecatedSince 18
 */

@Deprecated
public abstract void setAppCacheMaxSize(long appCacheMaxSize);

/**
 * Sets whether the database storage API is enabled. The default value is
 * false. See also {@link #setDatabasePath} for how to correctly set up the
 * database storage API.
 *
 * This setting is global in effect, across all WebView instances in a process.
 * Note you should only modify this setting prior to making <b>any</b> WebView
 * page load within a given process, as the WebView implementation may ignore
 * changes to this setting after that point.
 *
 * @param flag {@code true} if the WebView should use the database storage API
 * @apiSince 5
 */

public abstract void setDatabaseEnabled(boolean flag);

/**
 * Sets whether the DOM storage API is enabled. The default value is {@code false}.
 *
 * @param flag {@code true} if the WebView should use the DOM storage API
 * @apiSince 7
 */

public abstract void setDomStorageEnabled(boolean flag);

/**
 * Gets whether the DOM Storage APIs are enabled.
 *
 * @return {@code true} if the DOM Storage APIs are enabled
 * @see #setDomStorageEnabled
 * @apiSince 7
 */

public abstract boolean getDomStorageEnabled();

/**
 * Gets the path to where database storage API databases are saved.
 *
 * @return the String path to the database storage API databases
 * @see #setDatabasePath
 * @deprecated Database paths are managed by the implementation this method is obsolete.
 * @apiSince 5
 * @deprecatedSince 19
 */

@Deprecated
public abstract java.lang.String getDatabasePath();

/**
 * Gets whether the database storage API is enabled.
 *
 * @return {@code true} if the database storage API is enabled
 * @see #setDatabaseEnabled
 * @apiSince 5
 */

public abstract boolean getDatabaseEnabled();

/**
 * Sets whether Geolocation is enabled. The default is {@code true}.
 * <p>
 * Please note that in order for the Geolocation API to be usable
 * by a page in the WebView, the following requirements must be met:
 * <ul>
 *   <li>an application must have permission to access the device location,
 *   see {@link android.Manifest.permission#ACCESS_COARSE_LOCATION},
 *   {@link android.Manifest.permission#ACCESS_FINE_LOCATION};
 *   <li>an application must provide an implementation of the
 *   {@link android.webkit.WebChromeClient#onGeolocationPermissionsShowPrompt WebChromeClient#onGeolocationPermissionsShowPrompt} callback
 *   to receive notifications that a page is requesting access to location
 *   via the JavaScript Geolocation API.
 * </ul>
 * <p>
 *
 * @param flag whether Geolocation should be enabled
 * @apiSince 5
 */

public abstract void setGeolocationEnabled(boolean flag);

/**
 * Gets whether JavaScript is enabled.
 *
 * @return {@code true} if JavaScript is enabled
 * @see #setJavaScriptEnabled
 * @apiSince 1
 */

public abstract boolean getJavaScriptEnabled();

/**
 * Gets whether JavaScript running in the context of a file scheme URL can
 * access content from any origin. This includes access to content from
 * other file scheme URLs.
 *
 * @return whether JavaScript running in the context of a file scheme URL
 *         can access content from any origin
 * @see #setAllowUniversalAccessFromFileURLs
 * @apiSince 16
 */

public abstract boolean getAllowUniversalAccessFromFileURLs();

/**
 * Gets whether JavaScript running in the context of a file scheme URL can
 * access content from other file scheme URLs.
 *
 * @return whether JavaScript running in the context of a file scheme URL
 *         can access content from other file scheme URLs
 * @see #setAllowFileAccessFromFileURLs
 * @apiSince 16
 */

public abstract boolean getAllowFileAccessFromFileURLs();

/**
 * Gets the current state regarding whether plugins are enabled.
 *
 * @return the plugin state as a {@link android.webkit.WebSettings.PluginState PluginState} value
 * @see #setPluginState
 * @deprecated Plugins are not supported in API level
 *             {@link android.os.Build.VERSION_CODES#KITKAT} or later;
 *             enabling plugins is a no-op.
 * @apiSince 8
 * @deprecatedSince 18
 */

@Deprecated
public abstract android.webkit.WebSettings.PluginState getPluginState();

/**
 * Tells JavaScript to open windows automatically. This applies to the
 * JavaScript function {@code window.open()}. The default is {@code false}.
 *
 * @param flag {@code true} if JavaScript can open windows automatically
 * @apiSince 1
 */

public abstract void setJavaScriptCanOpenWindowsAutomatically(boolean flag);

/**
 * Gets whether JavaScript can open windows automatically.
 *
 * @return {@code true} if JavaScript can open windows automatically during
 *         {@code window.open()}
 * @see #setJavaScriptCanOpenWindowsAutomatically
 * @apiSince 1
 */

public abstract boolean getJavaScriptCanOpenWindowsAutomatically();

/**
 * Sets the default text encoding name to use when decoding html pages.
 * The default is "UTF-8".
 *
 * @param encoding the text encoding name
 * @apiSince 1
 */

public abstract void setDefaultTextEncodingName(java.lang.String encoding);

/**
 * Gets the default text encoding name.
 *
 * @return the default text encoding name as a string
 * @see #setDefaultTextEncodingName
 * @apiSince 1
 */

public abstract java.lang.String getDefaultTextEncodingName();

/**
 * Sets the WebView's user-agent string. If the string is {@code null} or empty,
 * the system default value will be used.
 *
 * Note that starting from {@link android.os.Build.VERSION_CODES#KITKAT} Android
 * version, changing the user-agent while loading a web page causes WebView
 * to initiate loading once again.
 *
 * @param ua new user-agent string
 
 * This value may be {@code null}.
 * @apiSince 3
 */

public abstract void setUserAgentString(@androidx.annotation.Nullable java.lang.String ua);

/**
 * Gets the WebView's user-agent string.
 *
 * @return the WebView's user-agent string
 * @see #setUserAgentString
 * @apiSince 3
 */

public abstract java.lang.String getUserAgentString();

/**
 * Returns the default User-Agent used by a WebView.
 * An instance of WebView could use a different User-Agent if a call
 * is made to {@link android.webkit.WebSettings#setUserAgentString(java.lang.String) WebSettings#setUserAgentString(String)}.
 *
 * @param context a Context object used to access application assets
 * @apiSince 17
 */

public static java.lang.String getDefaultUserAgent(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Tells the WebView whether it needs to set a node to have focus when
 * {@link android.webkit.WebView#requestFocus(int,android.graphics.Rect) WebView#requestFocus(int, android.graphics.Rect)} is called. The
 * default value is {@code true}.
 *
 * @param flag whether the WebView needs to set a node
 * @apiSince 1
 */

public abstract void setNeedInitialFocus(boolean flag);

/**
 * Sets the priority of the Render thread. Unlike the other settings, this
 * one only needs to be called once per process. The default value is
 * {@link android.webkit.WebSettings.RenderPriority#NORMAL RenderPriority#NORMAL}.
 *
 * @param priority the priority
 * @deprecated It is not recommended to adjust thread priorities, and this will
 *             not be supported in future versions.
 * @apiSince 1
 * @deprecatedSince 18
 */

@Deprecated
public abstract void setRenderPriority(android.webkit.WebSettings.RenderPriority priority);

/**
 * Overrides the way the cache is used. The way the cache is used is based
 * on the navigation type. For a normal page load, the cache is checked
 * and content is re-validated as needed. When navigating back, content is
 * not revalidated, instead the content is just retrieved from the cache.
 * This method allows the client to override this behavior by specifying
 * one of {@link #LOAD_DEFAULT},
 * {@link #LOAD_CACHE_ELSE_NETWORK}, {@link #LOAD_NO_CACHE} or
 * {@link #LOAD_CACHE_ONLY}. The default value is {@link #LOAD_DEFAULT}.
 *
 * @param mode the mode to use
 
 * Value is {@link android.webkit.WebSettings#LOAD_DEFAULT}, {@link android.webkit.WebSettings#LOAD_NORMAL}, {@link android.webkit.WebSettings#LOAD_CACHE_ELSE_NETWORK}, {@link android.webkit.WebSettings#LOAD_NO_CACHE}, or {@link android.webkit.WebSettings#LOAD_CACHE_ONLY}
 * @apiSince 1
 */

public abstract void setCacheMode(int mode);

/**
 * Gets the current setting for overriding the cache mode.
 *
 * @return the current setting for overriding the cache mode
 * Value is {@link android.webkit.WebSettings#LOAD_DEFAULT}, {@link android.webkit.WebSettings#LOAD_NORMAL}, {@link android.webkit.WebSettings#LOAD_CACHE_ELSE_NETWORK}, {@link android.webkit.WebSettings#LOAD_NO_CACHE}, or {@link android.webkit.WebSettings#LOAD_CACHE_ONLY}
 * @see #setCacheMode
 * @apiSince 1
 */

public abstract int getCacheMode();

/**
 * Configures the WebView's behavior when a secure origin attempts to load a resource from an
 * insecure origin.
 *
 * By default, apps that target {@link android.os.Build.VERSION_CODES#KITKAT} or below default
 * to {@link #MIXED_CONTENT_ALWAYS_ALLOW}. Apps targeting
 * {@link android.os.Build.VERSION_CODES#LOLLIPOP} default to {@link #MIXED_CONTENT_NEVER_ALLOW}.
 *
 * The preferred and most secure mode of operation for the WebView is
 * {@link #MIXED_CONTENT_NEVER_ALLOW} and use of {@link #MIXED_CONTENT_ALWAYS_ALLOW} is
 * strongly discouraged.
 *
 * @param mode The mixed content mode to use. One of {@link #MIXED_CONTENT_NEVER_ALLOW},
 *     {@link #MIXED_CONTENT_ALWAYS_ALLOW} or {@link #MIXED_CONTENT_COMPATIBILITY_MODE}.
 * @apiSince 21
 */

public abstract void setMixedContentMode(int mode);

/**
 * Gets the current behavior of the WebView with regard to loading insecure content from a
 * secure origin.
 * @return The current setting, one of {@link #MIXED_CONTENT_NEVER_ALLOW},
 *     {@link #MIXED_CONTENT_ALWAYS_ALLOW} or {@link #MIXED_CONTENT_COMPATIBILITY_MODE}.
 * @apiSince 21
 */

public abstract int getMixedContentMode();

/**
 * Sets whether this WebView should raster tiles when it is
 * offscreen but attached to a window. Turning this on can avoid
 * rendering artifacts when animating an offscreen WebView on-screen.
 * Offscreen WebViews in this mode use more memory. The default value is
 * false.<br>
 * Please follow these guidelines to limit memory usage:
 * <ul>
 * <li> WebView size should be not be larger than the device screen size.
 * <li> Limit use of this mode to a small number of WebViews. Use it for
 *   visible WebViews and WebViews about to be animated to visible.
 * </ul>
 * @apiSince 23
 */

public abstract void setOffscreenPreRaster(boolean enabled);

/**
 * Gets whether this WebView should raster tiles when it is
 * offscreen but attached to a window.
 * @return {@code true} if this WebView will raster tiles when it is
 * offscreen but attached to a window.
 * @apiSince 23
 */

public abstract boolean getOffscreenPreRaster();

/**
 * Sets whether Safe Browsing is enabled. Safe Browsing allows WebView to
 * protect against malware and phishing attacks by verifying the links.
 *
 * <p>
 * Safe Browsing can be disabled for all WebViews using a manifest tag (read <a
 * href="{@docRoot}reference/android/webkit/WebView.html">general Safe Browsing info</a>). The
 * manifest tag has a lower precedence than this API.
 *
 * <p>
 * Safe Browsing is enabled by default for devices which support it.
 *
 * @param enabled Whether Safe Browsing is enabled.
 * @apiSince 26
 */

public abstract void setSafeBrowsingEnabled(boolean enabled);

/**
 * Gets whether Safe Browsing is enabled.
 * See {@link #setSafeBrowsingEnabled}.
 *
 * @return {@code true} if Safe Browsing is enabled and {@code false} otherwise.
 * @apiSince 26
 */

public abstract boolean getSafeBrowsingEnabled();

/**
 * Set the force dark mode for this WebView.
 *
 * @param forceDark the force dark mode to set.
 * Value is {@link android.webkit.WebSettings#FORCE_DARK_OFF}, {@link android.webkit.WebSettings#FORCE_DARK_AUTO}, or {@link android.webkit.WebSettings#FORCE_DARK_ON}
 * @see #getForceDark
 * @apiSince 29
 */

public void setForceDark(int forceDark) { throw new RuntimeException("Stub!"); }

/**
 * Get the force dark mode for this WebView.
 * The default force dark mode is {@link #FORCE_DARK_AUTO}.
 *
 * @return the currently set force dark mode.
 * Value is {@link android.webkit.WebSettings#FORCE_DARK_OFF}, {@link android.webkit.WebSettings#FORCE_DARK_AUTO}, or {@link android.webkit.WebSettings#FORCE_DARK_ON}
 * @see #setForceDark
 * @apiSince 29
 */

public int getForceDark() { throw new RuntimeException("Stub!"); }

/**
 * Disables the action mode menu items according to {@code menuItems} flag.
 * @param menuItems an integer field flag for the menu items to be disabled.
 
 * Value is either <code>0</code> or a combination of {@link android.webkit.WebSettings#MENU_ITEM_NONE}, {@link android.webkit.WebSettings#MENU_ITEM_SHARE}, {@link android.webkit.WebSettings#MENU_ITEM_WEB_SEARCH}, and {@link android.webkit.WebSettings#MENU_ITEM_PROCESS_TEXT}
 * @apiSince 24
 */

public abstract void setDisabledActionModeMenuItems(int menuItems);

/**
 * Gets the action mode menu items that are disabled, expressed in an integer field flag.
 * The default value is {@link #MENU_ITEM_NONE}
 *
 * @return all the disabled menu item flags combined with bitwise OR.
 
 * Value is either <code>0</code> or a combination of {@link android.webkit.WebSettings#MENU_ITEM_NONE}, {@link android.webkit.WebSettings#MENU_ITEM_SHARE}, {@link android.webkit.WebSettings#MENU_ITEM_WEB_SEARCH}, and {@link android.webkit.WebSettings#MENU_ITEM_PROCESS_TEXT}
 * @apiSince 24
 */

public abstract int getDisabledActionModeMenuItems();

/**
 * Enable force dark dependent on the state of the WebView parent view. If the WebView parent
 * view is being automatically force darkened
 * (see: {@link android.view.View#setForceDarkAllowed}), then WebView content will be rendered
 * so as to emulate a dark theme. WebViews that are not attached to the view hierarchy will not
 * be inverted.
 *
 * @see #setForceDark
 * @apiSince 29
 */

public static final int FORCE_DARK_AUTO = 1; // 0x1

/**
 * Disable force dark, irrespective of the force dark mode of the WebView parent. In this mode,
 * WebView content will always be rendered as-is, regardless of whether native views are being
 * automatically darkened.
 *
 * @see #setForceDark
 * @apiSince 29
 */

public static final int FORCE_DARK_OFF = 0; // 0x0

/**
 * Unconditionally enable force dark. In this mode WebView content will always be rendered so
 * as to emulate a dark theme.
 *
 * @see #setForceDark
 * @apiSince 29
 */

public static final int FORCE_DARK_ON = 2; // 0x2

/**
 * Use cached resources when they are available, even if they have expired.
 * Otherwise load resources from the network.
 * Use with {@link #setCacheMode}.
 * @apiSince 1
 */

public static final int LOAD_CACHE_ELSE_NETWORK = 1; // 0x1

/**
 * Don't use the network, load from the cache.
 * Use with {@link #setCacheMode}.
 * @apiSince 1
 */

public static final int LOAD_CACHE_ONLY = 3; // 0x3

/**
 * Default cache usage mode. If the navigation type doesn't impose any
 * specific behavior, use cached resources when they are available
 * and not expired, otherwise load resources from the network.
 * Use with {@link #setCacheMode}.
 * @apiSince 1
 */

public static final int LOAD_DEFAULT = -1; // 0xffffffff

/**
 * Normal cache usage mode. Use with {@link #setCacheMode}.
 *
 * @deprecated This value is obsolete, as from API level
 * {@link android.os.Build.VERSION_CODES#HONEYCOMB} and onwards it has the
 * same effect as {@link #LOAD_DEFAULT}.
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final int LOAD_NORMAL = 0; // 0x0

/**
 * Don't use the cache, load from the network.
 * Use with {@link #setCacheMode}.
 * @apiSince 1
 */

public static final int LOAD_NO_CACHE = 2; // 0x2

/**
 * No menu items should be disabled.
 *
 * @see #setDisabledActionModeMenuItems
 * @apiSince 24
 */

public static final int MENU_ITEM_NONE = 0; // 0x0

/**
 * Disable all the action mode menu items for text processing.
 * By default WebView searches for activities that are able to handle
 * {@link android.content.Intent#ACTION_PROCESS_TEXT} and show them in the
 * action mode menu. If this flag is set via {@link
 * #setDisabledActionModeMenuItems}, these menu items will be disabled.
 *
 * @see #setDisabledActionModeMenuItems
 * @apiSince 24
 */

public static final int MENU_ITEM_PROCESS_TEXT = 4; // 0x4

/**
 * Disable menu item "Share".
 *
 * @see #setDisabledActionModeMenuItems
 * @apiSince 24
 */

public static final int MENU_ITEM_SHARE = 1; // 0x1

/**
 * Disable menu item "Web Search".
 *
 * @see #setDisabledActionModeMenuItems
 * @apiSince 24
 */

public static final int MENU_ITEM_WEB_SEARCH = 2; // 0x2

/**
 * In this mode, the WebView will allow a secure origin to load content from any other origin,
 * even if that origin is insecure. This is the least secure mode of operation for the WebView,
 * and where possible apps should not set this mode.
 *
 * @see #setMixedContentMode
 * @apiSince 21
 */

public static final int MIXED_CONTENT_ALWAYS_ALLOW = 0; // 0x0

/**
 * In this mode, the WebView will attempt to be compatible with the approach of a modern web
 * browser with regard to mixed content. Some insecure content may be allowed to be loaded by
 * a secure origin and other types of content will be blocked. The types of content are allowed
 * or blocked may change release to release and are not explicitly defined.
 *
 * This mode is intended to be used by apps that are not in control of the content that they
 * render but desire to operate in a reasonably secure environment. For highest security, apps
 * are recommended to use {@link #MIXED_CONTENT_NEVER_ALLOW}.
 *
 * @see #setMixedContentMode
 * @apiSince 21
 */

public static final int MIXED_CONTENT_COMPATIBILITY_MODE = 2; // 0x2

/**
 * In this mode, the WebView will not allow a secure origin to load content from an insecure
 * origin. This is the preferred and most secure mode of operation for the WebView and apps are
 * strongly advised to use this mode.
 *
 * @see #setMixedContentMode
 * @apiSince 21
 */

public static final int MIXED_CONTENT_NEVER_ALLOW = 1; // 0x1
/**
 * Enum for controlling the layout of html.
 * <ul>
 *   <li>{@code NORMAL} means no rendering changes. This is the recommended choice for maximum
 *       compatibility across different platforms and Android versions.</li>
 *   <li>{@code SINGLE_COLUMN} moves all content into one column that is the width of the
 *       view.</li>
 *   <li>{@code NARROW_COLUMNS} makes all columns no wider than the screen if possible. Only use
 *       this for API levels prior to {@link android.os.Build.VERSION_CODES#KITKAT}.</li>
 *   <li>{@code TEXT_AUTOSIZING} boosts font size of paragraphs based on heuristics to make
 *       the text readable when viewing a wide-viewport layout in the overview mode.
 *       It is recommended to enable zoom support {@link #setSupportZoom} when
 *       using this mode. Supported from API level
 *       {@link android.os.Build.VERSION_CODES#KITKAT}</li>
 * </ul>
 * @apiSince 1
 * @deprecatedSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum LayoutAlgorithm {
/**
 * @apiSince 1
 * @deprecatedSince 12
 */

NORMAL,
/**
 * @deprecated This algorithm is now obsolete.
 * @apiSince 1
 * @deprecatedSince 12
 */

@Deprecated
SINGLE_COLUMN,
/**
 * @deprecated This algorithm is now obsolete.
 * @apiSince 1
 * @deprecatedSince 12
 */

@Deprecated
NARROW_COLUMNS,
/**
 * @apiSince 19
 * @deprecatedSince 12
 */

TEXT_AUTOSIZING;
}

/**
 * The plugin state effects how plugins are treated on a page. ON means
 * that any object will be loaded even if a plugin does not exist to handle
 * the content. ON_DEMAND means that if there is a plugin installed that
 * can handle the content, a placeholder is shown until the user clicks on
 * the placeholder. Once clicked, the plugin will be enabled on the page.
 * OFF means that all plugins will be turned off and any fallback content
 * will be used.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum PluginState {
/** @apiSince 8 */

ON,
/** @apiSince 8 */

ON_DEMAND,
/** @apiSince 8 */

OFF;
}

/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum RenderPriority {
/** @apiSince 1 */

NORMAL,
/** @apiSince 1 */

HIGH,
/** @apiSince 1 */

LOW;
}

/**
 * Enum for specifying the text size.
 * <ul>
 *   <li>SMALLEST is 50%</li>
 *   <li>SMALLER is 75%</li>
 *   <li>NORMAL is 100%</li>
 *   <li>LARGER is 150%</li>
 *   <li>LARGEST is 200%</li>
 * </ul>
 *
 * @deprecated Use {@link android.webkit.WebSettings#setTextZoom(int) WebSettings#setTextZoom(int)} and {@link android.webkit.WebSettings#getTextZoom() WebSettings#getTextZoom()} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public enum TextSize {
/**
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
SMALLEST,
/**
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
SMALLER,
/**
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
NORMAL,
/**
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
LARGER,
/**
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
LARGEST;
}

/**
 * Enum for specifying the WebView's desired density.
 * <ul>
 *   <li>{@code FAR} makes 100% looking like in 240dpi</li>
 *   <li>{@code MEDIUM} makes 100% looking like in 160dpi</li>
 *   <li>{@code CLOSE} makes 100% looking like in 120dpi</li>
 * </ul>
 * @apiSince 7
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum ZoomDensity {
/** @apiSince 7 */

FAR,
/** @apiSince 7 */

MEDIUM,
/** @apiSince 7 */

CLOSE;
}

}

