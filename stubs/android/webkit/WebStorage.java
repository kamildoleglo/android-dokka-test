/*
 * Copyright (C) 2009 The Android Open Source Project
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

import java.util.Map;

/**
 * This class is used to manage the JavaScript storage APIs provided by the
 * {@link android.webkit.WebView WebView}. It manages the Application Cache API, the Web SQL Database
 * API and the HTML5 Web Storage API.
 *
 * The Application Cache API provides a mechanism to create and maintain an
 * application cache to power offline Web applications. Use of the Application
 * Cache API can be attributed to an origin {@link android.webkit.WebStorage.Origin WebStorage.Origin}, however
 * it is not possible to set per-origin quotas. Note that there can be only
 * one application cache per application.
 *
 * The Web SQL Database API provides storage which is private to a given origin.
 * Similar to the Application Cache, use of the Web SQL Database can be attributed
 * to an origin. It is also possible to set per-origin quotas.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WebStorage {

WebStorage() { throw new RuntimeException("Stub!"); }

/**
 * Gets the origins currently using either the Application Cache or Web SQL
 * Database APIs. This method operates asynchronously, with the result
 * being provided via a {@link android.webkit.ValueCallback ValueCallback}. The origins are provided as
 * a map, of type {@code Map<String, WebStorage.Origin>}, from the string
 * representation of the origin to a {@link android.webkit.WebStorage.Origin WebStorage.Origin} object.
 * @apiSince 7
 */

public void getOrigins(android.webkit.ValueCallback<java.util.Map> callback) { throw new RuntimeException("Stub!"); }

/**
 * Gets the amount of storage currently being used by both the Application
 * Cache and Web SQL Database APIs by the given origin. The amount is given
 * in bytes and the origin is specified using its string representation.
 * This method operates asynchronously, with the result being provided via
 * a {@link android.webkit.ValueCallback ValueCallback}.
 * @apiSince 7
 */

public void getUsageForOrigin(java.lang.String origin, android.webkit.ValueCallback<java.lang.Long> callback) { throw new RuntimeException("Stub!"); }

/**
 * Gets the storage quota for the Web SQL Database API for the given origin.
 * The quota is given in bytes and the origin is specified using its string
 * representation. This method operates asynchronously, with the result
 * being provided via a {@link android.webkit.ValueCallback ValueCallback}. Note that a quota is not
 * enforced on a per-origin basis for the Application Cache API.
 * @apiSince 7
 */

public void getQuotaForOrigin(java.lang.String origin, android.webkit.ValueCallback<java.lang.Long> callback) { throw new RuntimeException("Stub!"); }

/**
 * Sets the storage quota for the Web SQL Database API for the given origin.
 * The quota is specified in bytes and the origin is specified using its string
 * representation. Note that a quota is not enforced on a per-origin basis
 * for the Application Cache API.
 * @deprecated Controlling quota per-origin will not be supported in future.
 * @apiSince 7
 * @deprecatedSince 18
 */

@Deprecated
public void setQuotaForOrigin(java.lang.String origin, long quota) { throw new RuntimeException("Stub!"); }

/**
 * Clears the storage currently being used by both the Application Cache and
 * Web SQL Database APIs by the given origin. The origin is specified using
 * its string representation.
 * @apiSince 7
 */

public void deleteOrigin(java.lang.String origin) { throw new RuntimeException("Stub!"); }

/**
 * Clears all storage currently being used by the JavaScript storage APIs.
 * This includes the Application Cache, Web SQL Database and the HTML5 Web
 * Storage APIs.
 * @apiSince 7
 */

public void deleteAllData() { throw new RuntimeException("Stub!"); }

/**
 * Gets the singleton instance of this class.
 *
 * @return the singleton {@link android.webkit.WebStorage WebStorage} instance
 * @apiSince 7
 */

public static android.webkit.WebStorage getInstance() { throw new RuntimeException("Stub!"); }
/**
 * This class encapsulates information about the amount of storage
 * currently used by an origin for the JavaScript storage APIs.
 * An origin comprises the host, scheme and port of a URI.
 * See {@link android.webkit.WebStorage WebStorage} for details.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Origin {

Origin() { throw new RuntimeException("Stub!"); }

/**
 * Gets the string representation of this origin.
 *
 * @return the string representation of this origin
 * @apiSince 11
 */

public java.lang.String getOrigin() { throw new RuntimeException("Stub!"); }

/**
 * Gets the quota for this origin, for the Web SQL Database API, in
 * bytes. If this origin does not use the Web SQL Database API, this
 * quota will be set to zero.
 *
 * @return the quota, in bytes
 * @apiSince 11
 */

public long getQuota() { throw new RuntimeException("Stub!"); }

/**
 * Gets the total amount of storage currently being used by this origin,
 * for all JavaScript storage APIs, in bytes.
 *
 * @return the total amount of storage, in bytes
 * @apiSince 11
 */

public long getUsage() { throw new RuntimeException("Stub!"); }
}

/**
 * Encapsulates a callback function which is used to provide a new quota
 * for a JavaScript storage API.
 * See
 * {@link android.webkit.WebChromeClient#onExceededDatabaseQuota WebChromeClient#onExceededDatabaseQuota} and
 * {@link android.webkit.WebChromeClient#onReachedMaxAppCacheSize WebChromeClient#onReachedMaxAppCacheSize}.
 * @deprecated This class is obsolete and no longer used.
 * @apiSince 5
 * @deprecatedSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface QuotaUpdater {

/**
 * Provides a new quota, specified in bytes.
 *
 * @param newQuota the new quota, in bytes
 * @apiSince 5
 * @deprecatedSince 19
 */

@Deprecated
public void updateQuota(long newQuota);
}

}

