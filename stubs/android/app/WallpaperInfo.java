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


package android.app;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager;
import android.content.ComponentName;
import android.app.slice.Slice;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;
import android.os.Parcel;

/**
 * This class is used to specify meta information of a wallpaper service.
 * @apiSince 7
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class WallpaperInfo implements android.os.Parcelable {

/**
 * Constructor.
 *
 * @param context The Context in which we are parsing the wallpaper.
 * @param service The ResolveInfo returned from the package manager about
 * this wallpaper's component.
 * @apiSince 7
 */

public WallpaperInfo(android.content.Context context, android.content.pm.ResolveInfo service) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Return the .apk package that implements this wallpaper.
 * @apiSince 7
 */

public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Return the class name of the service component that implements
 * this wallpaper.
 * @apiSince 7
 */

public java.lang.String getServiceName() { throw new RuntimeException("Stub!"); }

/**
 * Return the raw information about the Service implementing this
 * wallpaper.  Do not modify the returned object.
 * @apiSince 7
 */

public android.content.pm.ServiceInfo getServiceInfo() { throw new RuntimeException("Stub!"); }

/**
 * Return the component of the service that implements this wallpaper.
 * @apiSince 7
 */

public android.content.ComponentName getComponent() { throw new RuntimeException("Stub!"); }

/**
 * Load the user-displayed label for this wallpaper.
 *
 * @param pm Supply a PackageManager used to load the wallpaper's
 * resources.
 * @apiSince 7
 */

public java.lang.CharSequence loadLabel(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Load the user-displayed icon for this wallpaper.
 *
 * @param pm Supply a PackageManager used to load the wallpaper's
 * resources.
 * @apiSince 7
 */

public android.graphics.drawable.Drawable loadIcon(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Load the thumbnail image for this wallpaper.
 *
 * @param pm Supply a PackageManager used to load the wallpaper's
 * resources.
 * @apiSince 7
 */

public android.graphics.drawable.Drawable loadThumbnail(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Return a string indicating the author(s) of this wallpaper.
 * @apiSince 7
 */

public java.lang.CharSequence loadAuthor(android.content.pm.PackageManager pm) throws android.content.res.Resources.NotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Return a brief summary of this wallpaper's behavior.
 * @apiSince 7
 */

public java.lang.CharSequence loadDescription(android.content.pm.PackageManager pm) throws android.content.res.Resources.NotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Returns an URI that specifies a link for further context about this wallpaper.
 *
 * @param pm An instance of {@link android.content.pm.PackageManager PackageManager} to retrieve the URI.
 * @return The URI.
 * @apiSince 25
 */

public android.net.Uri loadContextUri(android.content.pm.PackageManager pm) throws android.content.res.Resources.NotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves a title of the URI that specifies a link for further context about this wallpaper.
 *
 * @param pm An instance of {@link android.content.pm.PackageManager PackageManager} to retrieve the title.
 * @return The title.
 * @apiSince 25
 */

public java.lang.CharSequence loadContextDescription(android.content.pm.PackageManager pm) throws android.content.res.Resources.NotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Queries whether any metadata should be shown when previewing the wallpaper. If this value is
 * set to true, any component that shows a preview of this live wallpaper should also show
 * accompanying information like {@link #loadLabel},
 * {@link #loadDescription}, {@link #loadAuthor} and
 * {@link #loadContextDescription(android.content.pm.PackageManager)}, so the user gets to know further information
 * about this wallpaper.
 *
 * @return Whether any metadata should be shown when previewing the wallpaper.
 * @apiSince 25
 */

public boolean getShowMetadataInPreview() { throw new RuntimeException("Stub!"); }

/**
 * Return the class name of an activity that provides a settings UI for
 * the wallpaper.  You can launch this activity be starting it with
 * an {@link android.content.Intent} whose action is MAIN and with an
 * explicit {@link android.content.ComponentName}
 * composed of {@link #getPackageName} and the class name returned here.
 *
 * <p>{@code null} will be returned if there is no settings activity associated
 * with the wallpaper.
 * @apiSince 7
 */

public java.lang.String getSettingsActivity() { throw new RuntimeException("Stub!"); }

/**
 * Returns an URI that provides a settings {@link android.app.slice.Slice Slice} for this wallpaper.
 * The wallpaper should implement a SliceProvider associated with this URI.
 * The system will display the Slice in the customization section while previewing the live
 * wallpaper. Because this URI is accessible to other apps, it is recommended to protect it
 * with the android.permission.BIND_WALLPAPER permission.
 *
 * <p>{@code null} will be returned if there is no settings Slice URI associated
 * with the wallpaper.
 *
 * @return The URI.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.net.Uri getSettingsSliceUri() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this wallpaper service can support multiple engines to render on each surface
 * independently. An example use case is a multi-display set-up where the wallpaper service can
 * render surfaces to each of the connected displays.
 * <p>
 * This corresponds to the value {@link android.R.styleable#Wallpaper_supportsMultipleDisplays}
 * in the XML description of the wallpaper.
 * <p>
 * The default value is {@code false}.
 *
 * @see android.service.wallpaper.WallpaperService#onCreateEngine()
 * @see android.service.wallpaper.WallpaperService.Engine#onCreate(SurfaceHolder)
 * @return {@code true} if multiple engines can render independently on each surface.
 *
 * @attr ref android.R.styleable#Wallpaper_supportsMultipleDisplays
 * @apiSince 29
 */

public boolean supportsMultipleDisplays() { throw new RuntimeException("Stub!"); }

/** @apiSince 7 */

public void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/** @apiSince 7 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link android.os.Parcel Parcel}.
 *
 * @param dest The {@link android.os.Parcel Parcel} to be written.
 * @param flags The flags used for parceling.
 * @apiSince 7
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 7 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 * @apiSince 7
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.WallpaperInfo> CREATOR;
static { CREATOR = null; }
}

