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


package android.webkit;


/**
 * Manages Service Workers used by WebView.
 *
 * <p>Example usage:
 * <pre class="prettyprint">
 * ServiceWorkerController swController = ServiceWorkerController.getInstance();
 * swController.setServiceWorkerClient(new ServiceWorkerClient() {
 *   {@literal @}Override
 *   public WebResourceResponse shouldInterceptRequest(WebResourceRequest request) {
 *     // Capture request here and generate response or allow pass-through
 *     // by returning null.
 *     return null;
 *   }
 * });
 * </pre>
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ServiceWorkerController {

/**
 * @deprecated This class should not be constructed by applications, use {@link #getInstance()}
 * instead to fetch the singleton instance.
 * @apiSince 24
 */

@Deprecated
public ServiceWorkerController() { throw new RuntimeException("Stub!"); }

/**
 * Returns the default ServiceWorkerController instance. At present there is
 * only one ServiceWorkerController instance for all WebView instances,
 * however this restriction may be relaxed in the future.
 *
 * @return the default ServiceWorkerController instance
 
 * This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static android.webkit.ServiceWorkerController getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Gets the settings for all service workers.
 *
 * @return the current ServiceWorkerWebSettings
 
 * This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public abstract android.webkit.ServiceWorkerWebSettings getServiceWorkerWebSettings();

/**
 * Sets the client to capture service worker related callbacks.
 *
 * A {@link android.webkit.ServiceWorkerClient ServiceWorkerClient} should be set before any service workers are
 * active, e.g. a safe place is before any WebView instances are created or
 * pages loaded.
 
 * @param client This value may be {@code null}.
 * @apiSince 24
 */

public abstract void setServiceWorkerClient(@androidx.annotation.Nullable android.webkit.ServiceWorkerClient client);
}

