/*
 * Copyright (C) 2018 The Android Open Source Project
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

import android.net.Uri;

/**
 * Provides a contract for platform-supported Settings {@link android.app.slice.Slice Slices}.
 * <p>
 * Contains definitions for the supported {@link android.app.slice.SliceProvider SliceProvider}
 * authority, authority {@link android.net.Uri Uri}, and key constants.
 * <p>
 * {@link android.app.slice.Slice Slice} presenters interested in learning meta-data about the
 * {@link android.app.slice.Slice Slice} should read the {@link android.app.slice.Slice Slice}
 * object at runtime.
 * <p>
 * {@link android.net.Uri Uri} builder example:
 * <pre>
 * Uri wifiActionUri = BASE_URI
 *         .buildUpon()
 *         .appendPath(PATH_SETTING_ACTION)
 *         .appendPath(KEY_WIFI)
 *         .build();
 * Uri bluetoothIntentUri = BASE_URI
 *         .buildUpon()
 *         .appendPath(PATH_SETTING_INTENT)
 *         .appendPath(KEY_BLUETOOTH)
 *         .build();
 * </pre>
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SettingsSlicesContract {

private SettingsSlicesContract() { throw new RuntimeException("Stub!"); }

/**
 * Authority for platform Settings Slices.
 * @apiSince 28
 */

public static final java.lang.String AUTHORITY = "android.settings.slices";

/**
 * A content:// style uri to the Settings Slices authority, {@link #AUTHORITY}.
 * @apiSince 28
 */

public static final android.net.Uri BASE_URI;
static { BASE_URI = null; }

/**
 * {@link android.net.Uri Uri} key for the Airplane Mode setting.
 * @apiSince 28
 */

public static final java.lang.String KEY_AIRPLANE_MODE = "airplane_mode";

/**
 * {@link android.net.Uri Uri} key for the Battery Saver setting.
 * @apiSince 28
 */

public static final java.lang.String KEY_BATTERY_SAVER = "battery_saver";

/**
 * {@link android.net.Uri Uri} key for the Bluetooth setting.
 * @apiSince 28
 */

public static final java.lang.String KEY_BLUETOOTH = "bluetooth";

/**
 * {@link android.net.Uri Uri} key for the Location setting.
 * @apiSince 28
 */

public static final java.lang.String KEY_LOCATION = "location";

/**
 * {@link android.net.Uri Uri} key for the Wi-fi setting.
 * @apiSince 28
 */

public static final java.lang.String KEY_WIFI = "wifi";

/**
 * {@link android.net.Uri Uri} path indicating that the requested {@link android.app.slice.Slice Slice} should
 * have inline controls for the corresponding setting.
 * <p>
 * This path will only contain Slices defined by keys in this class.
 * @apiSince 28
 */

public static final java.lang.String PATH_SETTING_ACTION = "action";

/**
 * {@link android.net.Uri Uri} path indicating that the requested {@link android.app.slice.Slice Slice} should
 * be {@link android.content.Intent Intent}-only.
 * <p>
 * {@link android.app.slice.Slice Slices} with actions should use the {@link
 * #PATH_SETTING_ACTION} path.
 * <p>
 * This path will only contain Slices defined by keys in this class
 * @apiSince 28
 */

public static final java.lang.String PATH_SETTING_INTENT = "intent";
}

