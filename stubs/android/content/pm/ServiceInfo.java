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


package android.content.pm;


/**
 * Information you can retrieve about a particular application
 * service. This corresponds to information collected from the
 * AndroidManifest.xml's &lt;service&gt; tags.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ServiceInfo extends android.content.pm.ComponentInfo implements android.os.Parcelable {

/** @apiSince 1 */

public ServiceInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ServiceInfo(android.content.pm.ServiceInfo orig) { throw new RuntimeException("Stub!"); }

/**
 * Return foreground service type specified in the manifest..
 * @return foreground service type specified in the manifest.
 
 * Value is either <code>0</code> or a combination of {@link android.content.pm.ServiceInfo#FOREGROUND_SERVICE_TYPE_MANIFEST}, {@link android.content.pm.ServiceInfo#FOREGROUND_SERVICE_TYPE_NONE}, {@link android.content.pm.ServiceInfo#FOREGROUND_SERVICE_TYPE_DATA_SYNC}, {@link android.content.pm.ServiceInfo#FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK}, {@link android.content.pm.ServiceInfo#FOREGROUND_SERVICE_TYPE_PHONE_CALL}, {@link android.content.pm.ServiceInfo#FOREGROUND_SERVICE_TYPE_LOCATION}, {@link android.content.pm.ServiceInfo#FOREGROUND_SERVICE_TYPE_CONNECTED_DEVICE}, and {@link android.content.pm.ServiceInfo#FOREGROUND_SERVICE_TYPE_MEDIA_PROJECTION}
 * @apiSince 29
 */

public int getForegroundServiceType() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.pm.ServiceInfo> CREATOR;
static { CREATOR = null; }

/**
 * Bit in {@link #flags}: If set, the service can be bound and run in the
 * calling application's package, rather than the package in which it is
 * declared.  Set from {@link android.R.attr#externalService} attribute.
 * @apiSince 24
 */

public static final int FLAG_EXTERNAL_SERVICE = 4; // 0x4

/**
 * Bit in {@link #flags}: If set, the service will run in its own
 * isolated process.  Set from the
 * {@link android.R.attr#isolatedProcess} attribute.
 * @apiSince 16
 */

public static final int FLAG_ISOLATED_PROCESS = 2; // 0x2

/**
 * Bit in {@link #flags}: If set, a single instance of the service will
 * run for all users on the device.  Set from the
 * {@link android.R.attr#singleUser} attribute.
 * @apiSince 17
 */

public static final int FLAG_SINGLE_USER = 1073741824; // 0x40000000

/**
 * Bit in {@link #flags}: If set, the service will automatically be
 * stopped by the system if the user removes a task that is rooted
 * in one of the application's activities.  Set from the
 * {@link android.R.attr#stopWithTask} attribute.
 * @apiSince 14
 */

public static final int FLAG_STOP_WITH_TASK = 1; // 0x1

/**
 * Bit in {@link #flags}: If set, the service (which must be isolated)
 * will be spawned from an Application Zygote, instead of the regular Zygote.
 * The Application Zygote will pre-initialize the application's class loader,
 * and call a static callback into the application to allow it to perform
 * application-specific preloads (such as loading a shared library). Therefore,
 * spawning from the Application Zygote will typically reduce the service
 * launch time and reduce its memory usage. The downside of using this flag
 * is that you will have an additional process (the app zygote itself) that
 * is taking up memory. Whether actual memory usage is improved therefore
 * strongly depends on the number of isolated services that an application
 * starts, and how much memory those services save by preloading. Therefore,
 * it is recommended to measure memory usage under typical workloads to
 * determine whether it makes sense to use this flag.
 * @apiSince 29
 */

public static final int FLAG_USE_APP_ZYGOTE = 8; // 0x8

/**
 * Constant corresponding to <code>connectedDevice</code> in
 * the {@link android.R.attr#foregroundServiceType} attribute.
 * Auto, bluetooth, TV or other devices connection, monitoring and interaction.
 * @apiSince 29
 */

public static final int FOREGROUND_SERVICE_TYPE_CONNECTED_DEVICE = 16; // 0x10

/**
 * Constant corresponding to <code>dataSync</code> in
 * the {@link android.R.attr#foregroundServiceType} attribute.
 * Data(photo, file, account) upload/download, backup/restore, import/export, fetch,
 * transfer over network between device and cloud.
 * @apiSince 29
 */

public static final int FOREGROUND_SERVICE_TYPE_DATA_SYNC = 1; // 0x1

/**
 * Constant corresponding to <code>location</code> in
 * the {@link android.R.attr#foregroundServiceType} attribute.
 * GPS, map, navigation location update.
 * @apiSince 29
 */

public static final int FOREGROUND_SERVICE_TYPE_LOCATION = 8; // 0x8

/**
 * A special value indicates to use all types set in manifest file.
 * @apiSince 29
 */

public static final int FOREGROUND_SERVICE_TYPE_MANIFEST = -1; // 0xffffffff

/**
 * Constant corresponding to <code>mediaPlayback</code> in
 * the {@link android.R.attr#foregroundServiceType} attribute.
 * Music, video, news or other media playback.
 * @apiSince 29
 */

public static final int FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK = 2; // 0x2

/**
 * Constant corresponding to {@code mediaProjection} in
 * the {@link android.R.attr#foregroundServiceType} attribute.
 * Managing a media projection session, e.g for screen recording or taking screenshots.
 * @apiSince 29
 */

public static final int FOREGROUND_SERVICE_TYPE_MEDIA_PROJECTION = 32; // 0x20

/**
 * The default foreground service type if not been set in manifest file.
 * @apiSince 29
 */

public static final int FOREGROUND_SERVICE_TYPE_NONE = 0; // 0x0

/**
 * Constant corresponding to <code>phoneCall</code> in
 * the {@link android.R.attr#foregroundServiceType} attribute.
 * Ongoing phone call or video conference.
 * @apiSince 29
 */

public static final int FOREGROUND_SERVICE_TYPE_PHONE_CALL = 4; // 0x4

/**
 * Options that have been set in the service declaration in the
 * manifest.
 * These include:
 * {@link #FLAG_STOP_WITH_TASK}, {@link #FLAG_ISOLATED_PROCESS},
 * {@link #FLAG_SINGLE_USER}.
 * @apiSince 14
 */

public int flags;

/**
 * Optional name of a permission required to be able to access this
 * Service.  From the "permission" attribute.
 * @apiSince 1
 */

public java.lang.String permission;
}

