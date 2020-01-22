/*
 * Copyright (C) 2017 The Android Open Source Project
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

package android.provider;

import android.graphics.fonts.Font;
import android.graphics.Typeface;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;

/**
 * Utility class to deal with Font ContentProviders.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class FontsContract {

private FontsContract() { throw new RuntimeException("Stub!"); }

/**
 * Create a typeface object given a font request. The font will be asynchronously fetched,
 * therefore the result is delivered to the given callback. See {@link android.provider.FontRequest FontRequest}.
 * Only one of the methods in callback will be invoked, depending on whether the request
 * succeeds or fails. These calls will happen on the caller thread.
 *
 * Note that the result Typeface may be cached internally and the same instance will be returned
 * the next time you call this method with the same request. If you want to bypass this cache,
 * use {@link #fetchFonts} and {@link #buildTypeface} instead.
 *
 * @param context A context to be used for fetching from font provider.
 * This value must never be {@code null}.
 * @param request A {@link android.provider.FontRequest FontRequest} object that identifies the provider and query for the
 *                request. May not be null.
 * This value must never be {@code null}.
 * @param handler A handler to be processed the font fetching.
 * This value must never be {@code null}.
 * @param cancellationSignal A signal to cancel the operation in progress, or null if none. If
 *                           the operation is canceled, then {@link
 *                           android.os.OperationCanceledException} will be thrown.
 * This value may be {@code null}.
 * @param callback A callback that will be triggered when results are obtained. May not be null.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public static void requestFonts(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.provider.FontRequest request, @androidx.annotation.NonNull android.os.Handler handler, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull android.provider.FontsContract.FontRequestCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Fetch fonts given a font request.
 *
 * @param context A {@link android.content.Context Context} to be used for fetching fonts.
 * This value must never be {@code null}.
 * @param cancellationSignal A signal to cancel the operation in progress, or null if none. If
 *                           the operation is canceled, then {@link
 *                           android.os.OperationCanceledException} will be thrown when the
 *                           query is executed.
 * This value may be {@code null}.
 * @param request A {@link android.provider.FontRequest FontRequest} object that identifies the provider and query for the
 *                request.
 *
 * This value must never be {@code null}.
 * @return {@link android.provider.FontsContract.FontFamilyResult FontFamilyResult}
 *
 * @throws android.content.pm.PackageManager.NameNotFoundException If requested package or authority was not found in system.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static android.provider.FontsContract.FontFamilyResult fetchFonts(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull android.provider.FontRequest request) throws android.content.pm.PackageManager.NameNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Build a Typeface from an array of {@link android.provider.FontsContract.FontInfo FontInfo}
 *
 * Results that are marked as not ready will be skipped.
 *
 * @param context A {@link android.content.Context Context} that will be used to fetch the font contents.
 * This value must never be {@code null}.
 * @param cancellationSignal A signal to cancel the operation in progress, or null if none. If
 *                           the operation is canceled, then {@link
 *                           android.os.OperationCanceledException} will be thrown.
 * This value may be {@code null}.
 * @param fonts An array of {@link android.provider.FontsContract.FontInfo FontInfo} to be used to create a Typeface.
 * This value must never be {@code null}.
 * @return A Typeface object. Returns null if typeface creation fails.
 * @apiSince 26
 */

public static android.graphics.Typeface buildTypeface(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull android.provider.FontsContract.FontInfo[] fonts) { throw new RuntimeException("Stub!"); }
/**
 * Defines the constants used in a response from a Font Provider. The cursor returned from the
 * query should have the ID column populated with the content uri ID for the resulting font.
 * This should point to a real file or shared memory, as the client will mmap the given file
 * descriptor. Pipes, sockets and other non-mmap-able file descriptors will fail to load in the
 * client application.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Columns implements android.provider.BaseColumns {

private Columns() { throw new RuntimeException("Stub!"); }

/**
 * Constant used to request data from a font provider. The cursor returned from the query
 * may populate this column with a long for the font file ID. The client will request a file
 * descriptor to "file/FILE_ID" with this ID immediately under the top-level content URI. If
 * not present, the client will request a file descriptor to the top-level URI with the
 * given base font ID. Note that several results may return the same file ID, e.g. for TTC
 * files with different indices.
 * @apiSince 26
 */

public static final java.lang.String FILE_ID = "file_id";

/**
 * Constant used to request data from a font provider. The cursor returned from the query
 * should have this column populated with the int italic for the resulting font. This should
 * be 0 for regular style and 1 for italic.
 * @apiSince 26
 */

public static final java.lang.String ITALIC = "font_italic";

/**
 * Constant used to request data from a font provider. The cursor returned from the query
 * should have this column populated to indicate the result status of the
 * query. This will be checked before any other data in the cursor. Possible values are
 * {@link #RESULT_CODE_OK}, {@link #RESULT_CODE_FONT_NOT_FOUND},
 * {@link #RESULT_CODE_MALFORMED_QUERY} and {@link #RESULT_CODE_FONT_UNAVAILABLE} for system
 * defined values. You may also define your own values in the 0x000010000..0xFFFF0000 range.
 * If not present, {@link #RESULT_CODE_OK} will be assumed.
 * @apiSince 26
 */

public static final java.lang.String RESULT_CODE = "result_code";

/**
 * Constant used to represent a result was not found. See {@link #RESULT_CODE}.
 * @apiSince 26
 */

public static final int RESULT_CODE_FONT_NOT_FOUND = 1; // 0x1

/**
 * Constant used to represent a result was found, but cannot be provided at this moment. Use
 * this to indicate, for example, that a font needs to be fetched from the network. See
 * {@link #RESULT_CODE}.
 * @apiSince 26
 */

public static final int RESULT_CODE_FONT_UNAVAILABLE = 2; // 0x2

/**
 * Constant used to represent that the query was not in a supported format by the provider.
 * See {@link #RESULT_CODE}.
 * @apiSince 26
 */

public static final int RESULT_CODE_MALFORMED_QUERY = 3; // 0x3

/**
 * Constant used to represent a result was retrieved successfully. The given fonts will be
 * attempted to retrieve immediately via
 * {@link android.content.ContentProvider#openFile(Uri, String)}. See {@link #RESULT_CODE}.
 * @apiSince 26
 */

public static final int RESULT_CODE_OK = 0; // 0x0

/**
 * Constant used to request data from a font provider. The cursor returned from the query
 * should have this column populated with an int for the ttc index for the resulting font.
 * @apiSince 26
 */

public static final java.lang.String TTC_INDEX = "font_ttc_index";

/**
 * Constant used to request data from a font provider. The cursor returned from the query
 * may populate this column with the font variation settings String information for the
 * font.
 * @apiSince 26
 */

public static final java.lang.String VARIATION_SETTINGS = "font_variation_settings";

/**
 * Constant used to request data from a font provider. The cursor returned from the query
 * should have this column populated with the int weight for the resulting font. This value
 * should be between 100 and 900. The most common values are 400 for regular weight and 700
 * for bold weight.
 * @apiSince 26
 */

public static final java.lang.String WEIGHT = "font_weight";
}

/**
 * Object returned from {@link #fetchFonts}.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class FontFamilyResult {

FontFamilyResult() { throw new RuntimeException("Stub!"); }

/**
 * @return Value is {@link android.provider.FontsContract.FontFamilyResult#STATUS_OK}, {@link android.provider.FontsContract.FontFamilyResult#STATUS_WRONG_CERTIFICATES}, or {@link android.provider.FontsContract.FontFamilyResult#STATUS_UNEXPECTED_DATA_PROVIDED}
 * @apiSince 26
 */

public int getStatusCode() { throw new RuntimeException("Stub!"); }

/**
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.provider.FontsContract.FontInfo[] getFonts() { throw new RuntimeException("Stub!"); }

/**
 * Constant represents that the font was successfully retrieved. Note that when this value
 * is set and {@link #getFonts} returns an empty array, it means there were no fonts
 * matching the given query.
 * @apiSince 26
 */

public static final int STATUS_OK = 0; // 0x0

/**
 * Constant represents that the fetching font data was rejected by system. This happens if
 * the passed context is restricted.
 * @apiSince 26
 */

public static final int STATUS_REJECTED = 3; // 0x3

/**
 * Constant represents that the provider returns unexpected data. {@link #getFonts} returns
 * null if this status was set. For example, this value is set when the font provider
 * gives invalid format of variation settings.
 * @apiSince 26
 */

public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2; // 0x2

/**
 * Constant represents that the given certificate was not matched with the provider's
 * signature. {@link #getFonts} returns null if this status was set.
 * @apiSince 26
 */

public static final int STATUS_WRONG_CERTIFICATES = 1; // 0x1
}

/**
 * Object represent a font entry in the family returned from {@link #fetchFonts}.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class FontInfo {

FontInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns a URI associated to this record.
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.net.Uri getUri() { throw new RuntimeException("Stub!"); }

/**
 * Returns the index to be used to access this font when accessing a TTC file.
 
 * @return Value is 0 or greater
 * @apiSince 26
 */

public int getTtcIndex() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of axes associated to this font.
 
 * @return This value may be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public android.graphics.fonts.FontVariationAxis[] getAxes() { throw new RuntimeException("Stub!"); }

/**
 * Returns the weight value for this font.
 
 * @return Value is between 1 and 1000 inclusive
 * @apiSince 26
 */

public int getWeight() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this font is italic.
 * @apiSince 26
 */

public boolean isItalic() { throw new RuntimeException("Stub!"); }

/**
 * Returns result code.
 *
 * {@link android.provider.FontsContract.Columns#RESULT_CODE FontsContract.Columns#RESULT_CODE}
 * @apiSince 26
 */

public int getResultCode() { throw new RuntimeException("Stub!"); }
}

/**
 * Interface used to receive asynchronously fetched typefaces.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class FontRequestCallback {

/** @apiSince 26 */

public FontRequestCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called then a Typeface request done via {@link #requestFonts} is complete. Note that this
 * method will not be called if {@link #onTypefaceRequestFailed(int)} is called instead.
 * @param typeface  The Typeface object retrieved.
 * @apiSince 26
 */

public void onTypefaceRetrieved(android.graphics.Typeface typeface) { throw new RuntimeException("Stub!"); }

/**
 * Called when a Typeface request done via {@link #requestFonts}} fails.
 * @param reason One of {@link #FAIL_REASON_PROVIDER_NOT_FOUND},
 *               {@link #FAIL_REASON_FONT_NOT_FOUND},
 *               {@link #FAIL_REASON_FONT_LOAD_ERROR},
 *               {@link #FAIL_REASON_FONT_UNAVAILABLE} or
 *               {@link #FAIL_REASON_MALFORMED_QUERY} if returned by the system. May also be
 *               a positive value greater than 0 defined by the font provider as an
 *               additional error code. Refer to the provider's documentation for more
 *               information on possible returned error codes.
 
 * Value is {@link android.provider.FontsContract.FontRequestCallback#FAIL_REASON_PROVIDER_NOT_FOUND}, {@link android.provider.FontsContract.FontRequestCallback#FAIL_REASON_FONT_LOAD_ERROR}, {@link android.provider.FontsContract.FontRequestCallback#FAIL_REASON_FONT_NOT_FOUND}, {@link android.provider.FontsContract.FontRequestCallback#FAIL_REASON_FONT_UNAVAILABLE}, or {@link android.provider.FontsContract.FontRequestCallback#FAIL_REASON_MALFORMED_QUERY}
 * @apiSince 26
 */

public void onTypefaceRequestFailed(int reason) { throw new RuntimeException("Stub!"); }

/**
 * Constant returned by {@link #onTypefaceRequestFailed(int)} signaling that the font
 * returned by the provider was not loaded properly.
 * @apiSince 26
 */

public static final int FAIL_REASON_FONT_LOAD_ERROR = -3; // 0xfffffffd

/**
 * Constant returned by {@link #onTypefaceRequestFailed(int)} signaling that the font
 * provider did not return any results for the given query.
 * @apiSince 26
 */

public static final int FAIL_REASON_FONT_NOT_FOUND = 1; // 0x1

/**
 * Constant returned by {@link #onTypefaceRequestFailed(int)} signaling that the font
 * provider found the queried font, but it is currently unavailable.
 * @apiSince 26
 */

public static final int FAIL_REASON_FONT_UNAVAILABLE = 2; // 0x2

/**
 * Constant returned by {@link #onTypefaceRequestFailed(int)} signaling that the given
 * query was not supported by the provider.
 * @apiSince 26
 */

public static final int FAIL_REASON_MALFORMED_QUERY = 3; // 0x3

/**
 * Constant returned by {@link #onTypefaceRequestFailed(int)} signaling that the given
 * provider was not found on the device.
 * @apiSince 26
 */

public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1; // 0xffffffff

/**
 * Constant returned by {@link #onTypefaceRequestFailed(int)} signaling that the given
 * provider must be authenticated and the given certificates do not match its signature.
 * @apiSince 26
 */

public static final int FAIL_REASON_WRONG_CERTIFICATES = -2; // 0xfffffffe
}

}

