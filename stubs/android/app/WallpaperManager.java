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
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.content.Intent;
import java.io.IOException;
import android.graphics.Bitmap;
import android.graphics.Rect;
import java.io.InputStream;
import android.graphics.BitmapRegionDecoder;
import android.os.IBinder;
import android.content.ComponentName;

/**
 * Provides access to the system wallpaper. With WallpaperManager, you can
 * get the current wallpaper, get the desired dimensions for the wallpaper, set
 * the wallpaper, and more.
 *
 * <p> An app can check whether wallpapers are supported for the current user, by calling
 * {@link #isWallpaperSupported()}, and whether setting of wallpapers is allowed, by calling
 * {@link #isSetWallpaperAllowed()}.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WallpaperManager {

WallpaperManager() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a WallpaperManager associated with the given Context.
 * @apiSince 5
 */

public static android.app.WallpaperManager getInstance(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current system wallpaper; if
 * no wallpaper is set, the system built-in static wallpaper is returned.
 * This is returned as an
 * abstract Drawable that you can install in a View to display whatever
 * wallpaper the user has currently set.
 * <p>
 * This method can return null if there is no system wallpaper available, if
 * wallpapers are not supported in the current user, or if the calling app is not
 * permitted to access the system wallpaper.
 *
 * @return Returns a Drawable object that will draw the system wallpaper,
 *     or {@code null} if no system wallpaper exists or if the calling application
 *     is not able to access the wallpaper.
 * @apiSince 5
 */

public android.graphics.drawable.Drawable getDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Obtain a drawable for the built-in static system wallpaper.
 * @apiSince 19
 */

public android.graphics.drawable.Drawable getBuiltInDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Obtain a drawable for the specified built-in static system wallpaper.
 *
 * @param which The {@code FLAG_*} identifier of a valid wallpaper type.  Throws
 *     IllegalArgumentException if an invalid wallpaper is requested.
 * Value is either <code>0</code> or a combination of {@link android.app.WallpaperManager#FLAG_SYSTEM}, and {@link android.app.WallpaperManager#FLAG_LOCK}
 * @return A Drawable presenting the specified wallpaper image, or {@code null}
 *     if no built-in default image for that wallpaper type exists.
 * @apiSince 24
 */

public android.graphics.drawable.Drawable getBuiltInDrawable(int which) { throw new RuntimeException("Stub!"); }

/**
 * Returns a drawable for the system built-in static wallpaper. Based on the parameters, the
 * drawable can be cropped and scaled
 *
 * @param outWidth The width of the returned drawable
 * @param outWidth The height of the returned drawable
 * @param scaleToFit If true, scale the wallpaper down rather than just cropping it
 * @param horizontalAlignment A float value between 0 and 1 specifying where to crop the image;
 *        0 for left-aligned, 0.5 for horizontal center-aligned, and 1 for right-aligned
 * @param verticalAlignment A float value between 0 and 1 specifying where to crop the image;
 *        0 for top-aligned, 0.5 for vertical center-aligned, and 1 for bottom-aligned
 * @return A Drawable presenting the built-in default system wallpaper image,
 *        or {@code null} if no such default image is defined on this device.
 * @apiSince 19
 */

public android.graphics.drawable.Drawable getBuiltInDrawable(int outWidth, int outHeight, boolean scaleToFit, float horizontalAlignment, float verticalAlignment) { throw new RuntimeException("Stub!"); }

/**
 * Returns a drawable for the built-in static wallpaper of the specified type.  Based on the
 * parameters, the drawable can be cropped and scaled.
 *
 * @param outWidth The width of the returned drawable
 * @param outWidth The height of the returned drawable
 * @param scaleToFit If true, scale the wallpaper down rather than just cropping it
 * @param horizontalAlignment A float value between 0 and 1 specifying where to crop the image;
 *        0 for left-aligned, 0.5 for horizontal center-aligned, and 1 for right-aligned
 * @param verticalAlignment A float value between 0 and 1 specifying where to crop the image;
 *        0 for top-aligned, 0.5 for vertical center-aligned, and 1 for bottom-aligned
 * @param which The {@code FLAG_*} identifier of a valid wallpaper type.  Throws
 *     IllegalArgumentException if an invalid wallpaper is requested.
 * Value is either <code>0</code> or a combination of {@link android.app.WallpaperManager#FLAG_SYSTEM}, and {@link android.app.WallpaperManager#FLAG_LOCK}
 * @return A Drawable presenting the built-in default wallpaper image of the given type,
 *        or {@code null} if no default image of that type is defined on this device.
 * @apiSince 24
 */

public android.graphics.drawable.Drawable getBuiltInDrawable(int outWidth, int outHeight, boolean scaleToFit, float horizontalAlignment, float verticalAlignment, int which) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current system wallpaper; if there is no wallpaper set,
 * a null pointer is returned. This is returned as an
 * abstract Drawable that you can install in a View to display whatever
 * wallpaper the user has currently set.
 *
 * @return Returns a Drawable object that will draw the wallpaper or a
 * null pointer if these is none.
 * @apiSince 5
 */

public android.graphics.drawable.Drawable peekDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #getDrawable()}, but the returned Drawable has a number
 * of limitations to reduce its overhead as much as possible. It will
 * never scale the wallpaper (only centering it if the requested bounds
 * do match the bitmap bounds, which should not be typical), doesn't
 * allow setting an alpha, color filter, or other attributes, etc.  The
 * bounds of the returned drawable will be initialized to the same bounds
 * as the wallpaper, so normally you will not need to touch it.  The
 * drawable also assumes that it will be used in a context running in
 * the same density as the screen (not in density compatibility mode).
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_EXTERNAL_STORAGE}
 * @return Returns a Drawable object that will draw the wallpaper.
 * @apiSince 5
 */

public android.graphics.drawable.Drawable getFastDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #getFastDrawable()}, but if there is no wallpaper set,
 * a null pointer is returned.
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_EXTERNAL_STORAGE}
 * @return Returns an optimized Drawable object that will draw the
 * wallpaper or a null pointer if these is none.
 * @apiSince 5
 */

public android.graphics.drawable.Drawable peekFastDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Get an open, readable file descriptor to the given wallpaper image file.
 * The caller is responsible for closing the file descriptor when done ingesting the file.
 *
 * <p>If no lock-specific wallpaper has been configured for the given user, then
 * this method will return {@code null} when requesting {@link #FLAG_LOCK} rather than
 * returning the system wallpaper's image file.
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_EXTERNAL_STORAGE}
 * @param which The wallpaper whose image file is to be retrieved.  Must be a single
 *     defined kind of wallpaper, either {@link #FLAG_SYSTEM} or
 *     {@link #FLAG_LOCK}.
 * Value is either <code>0</code> or a combination of {@link android.app.WallpaperManager#FLAG_SYSTEM}, and {@link android.app.WallpaperManager#FLAG_LOCK}
 * @return An open, readable file desriptor to the requested wallpaper image file;
 *     or {@code null} if no such wallpaper is configured or if the calling app does
 *     not have permission to read the current wallpaper.
 *
 * @see #FLAG_LOCK
 * @see #FLAG_SYSTEM
 * @apiSince 24
 */

public android.os.ParcelFileDescriptor getWallpaperFile(int which) { throw new RuntimeException("Stub!"); }

/**
 * Registers a listener to get notified when the wallpaper colors change.
 * @param listener A listener to register
 * This value must never be {@code null}.
 * @param handler Where to call it from. Will be called from the main thread
 *                if null.
 
 * This value must never be {@code null}.
 * @apiSince 27
 */

public void addOnColorsChangedListener(@androidx.annotation.NonNull android.app.WallpaperManager.OnColorsChangedListener listener, @androidx.annotation.NonNull android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Stop listening to color updates.
 * @param callback A callback to unsubscribe.
 
 * This value must never be {@code null}.
 * @apiSince 27
 */

public void removeOnColorsChangedListener(@androidx.annotation.NonNull android.app.WallpaperManager.OnColorsChangedListener callback) { throw new RuntimeException("Stub!"); }

/**
 * Get the primary colors of a wallpaper.
 *
 * <p>This method can return {@code null} when:
 * <ul>
 * <li>Colors are still being processed by the system.</li>
 * <li>The user has chosen to use a live wallpaper:  live wallpapers might not
 * implement
 * {@link android.service.wallpaper.WallpaperService.Engine#onComputeColors()
 *     WallpaperService.Engine#onComputeColors()}.</li>
 * </ul>
 *
 * @param which Wallpaper type. Must be either {@link #FLAG_SYSTEM} or
 *     {@link #FLAG_LOCK}.
 * @return Current {@link android.app.WallpaperColors WallpaperColors} or null if colors are unknown.
 * @see #addOnColorsChangedListener(OnColorsChangedListener, Handler)
 * @apiSince 27
 */

@androidx.annotation.Nullable
public android.app.WallpaperColors getWallpaperColors(int which) { throw new RuntimeException("Stub!"); }

/**
 * Remove all internal references to the last loaded wallpaper.  Useful
 * for apps that want to reduce memory usage when they only temporarily
 * need to have the wallpaper.  After calling, the next request for the
 * wallpaper will require reloading it again from disk.
 * @apiSince 14
 */

public void forgetLoadedWallpaper() { throw new RuntimeException("Stub!"); }

/**
 * Returns the information about the wallpaper if the current wallpaper is
 * a live wallpaper component. Otherwise, if the wallpaper is a static image,
 * this returns null.
 * @apiSince 7
 */

public android.app.WallpaperInfo getWallpaperInfo() { throw new RuntimeException("Stub!"); }

/**
 * Get the ID of the current wallpaper of the given kind.  If there is no
 * such wallpaper configured, returns a negative number.
 *
 * <p>Every time the wallpaper image is set, a new ID is assigned to it.
 * This method allows the caller to determine whether the wallpaper imagery
 * has changed, regardless of how that change happened.
 *
 * @param which The wallpaper whose ID is to be returned.  Must be a single
 *     defined kind of wallpaper, either {@link #FLAG_SYSTEM} or
 *     {@link #FLAG_LOCK}.
 * Value is either <code>0</code> or a combination of {@link android.app.WallpaperManager#FLAG_SYSTEM}, and {@link android.app.WallpaperManager#FLAG_LOCK}
 * @return The positive numeric ID of the current wallpaper of the given kind,
 *     or a negative value if no such wallpaper is configured.
 * @apiSince 24
 */

public int getWallpaperId(int which) { throw new RuntimeException("Stub!"); }

/**
 * Gets an Intent that will launch an activity that crops the given
 * image and sets the device's wallpaper. If there is a default HOME activity
 * that supports cropping wallpapers, it will be preferred as the default.
 * Use this method instead of directly creating a {@link #ACTION_CROP_AND_SET_WALLPAPER}
 * intent.
 *
 * @param imageUri The image URI that will be set in the intent. The must be a content
 *                 URI and its provider must resolve its type to "image/*"
 *
 * @throws java.lang.IllegalArgumentException if the URI is not a content URI or its MIME type is
 *         not "image/*"
 * @apiSince 19
 */

public android.content.Intent getCropAndSetWallpaperIntent(android.net.Uri imageUri) { throw new RuntimeException("Stub!"); }

/**
 * Change the current system wallpaper to the bitmap in the given resource.
 * The resource is opened as a raw data stream and copied into the
 * wallpaper; it must be a valid PNG or JPEG image.  On success, the intent
 * {@link android.content.Intent#ACTION_WALLPAPER_CHANGED Intent#ACTION_WALLPAPER_CHANGED} is broadcast.
 *
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#SET_WALLPAPER}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#SET_WALLPAPER}
 * @param resid The resource ID of the bitmap to be used as the wallpaper image
 *
 * @throws java.io.IOException If an error occurs reverting to the built-in
 * wallpaper.
 * @apiSince 5
 */

public void setResource(int resid) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link #setResource(int)} that allows the caller to specify which
 * of the supported wallpaper categories to set.
 *
 * <br>
 * Requires {@link android.Manifest.permission#SET_WALLPAPER}
 * @param resid The resource ID of the bitmap to be used as the wallpaper image
 * @param which Flags indicating which wallpaper(s) to configure with the new imagery
 *
 * Value is either <code>0</code> or a combination of {@link android.app.WallpaperManager#FLAG_SYSTEM}, and {@link android.app.WallpaperManager#FLAG_LOCK}
 * @see #FLAG_LOCK
 * @see #FLAG_SYSTEM
 *
 * @return An integer ID assigned to the newly active wallpaper; or zero on failure.
 *
 * @throws java.io.IOException
 * @apiSince 24
 */

public int setResource(int resid, int which) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Change the current system wallpaper to a bitmap.  The given bitmap is
 * converted to a PNG and stored as the wallpaper.  On success, the intent
 * {@link android.content.Intent#ACTION_WALLPAPER_CHANGED Intent#ACTION_WALLPAPER_CHANGED} is broadcast.
 *
 * <p>This method is equivalent to calling
 * {@link #setBitmap(android.graphics.Bitmap,android.graphics.Rect,boolean)} and passing {@code null} for the
 * {@code visibleCrop} rectangle and {@code true} for the {@code allowBackup}
 * parameter.
 *
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#SET_WALLPAPER}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#SET_WALLPAPER}
 * @param bitmap The bitmap to be used as the new system wallpaper.
 *
 * @throws java.io.IOException If an error occurs when attempting to set the wallpaper
 *     to the provided image.
 * @apiSince 5
 */

public void setBitmap(android.graphics.Bitmap bitmap) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Change the current system wallpaper to a bitmap, specifying a hint about
 * which subrectangle of the full image is to be visible.  The OS will then
 * try to best present the given portion of the full image as the static system
 * wallpaper image.  On success, the intent
 * {@link android.content.Intent#ACTION_WALLPAPER_CHANGED Intent#ACTION_WALLPAPER_CHANGED} is broadcast.
 *
 * <p>Passing {@code null} as the {@code visibleHint} parameter is equivalent to
 * passing (0, 0, {@code fullImage.getWidth()}, {@code fullImage.getHeight()}).
 *
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#SET_WALLPAPER}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#SET_WALLPAPER}
 * @param fullImage A bitmap that will supply the wallpaper imagery.
 * @param visibleCropHint The rectangular subregion of {@code fullImage} that should be
 *     displayed as wallpaper.  Passing {@code null} for this parameter means that
 *     the full image should be displayed if possible given the image's and device's
 *     aspect ratios, etc.
 * @param allowBackup {@code true} if the OS is permitted to back up this wallpaper
 *     image for restore to a future device; {@code false} otherwise.
 *
 * @return An integer ID assigned to the newly active wallpaper; or zero on failure.
 *
 * @throws java.io.IOException If an error occurs when attempting to set the wallpaper
 *     to the provided image.
 * @throws java.lang.IllegalArgumentException If the {@code visibleCropHint} rectangle is
 *     empty or invalid.
 * @apiSince 24
 */

public int setBitmap(android.graphics.Bitmap fullImage, android.graphics.Rect visibleCropHint, boolean allowBackup) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link #setBitmap(android.graphics.Bitmap,android.graphics.Rect,boolean)} that allows the caller
 * to specify which of the supported wallpaper categories to set.
 *
 * <br>
 * Requires {@link android.Manifest.permission#SET_WALLPAPER}
 * @param fullImage A bitmap that will supply the wallpaper imagery.
 * @param visibleCropHint The rectangular subregion of {@code fullImage} that should be
 *     displayed as wallpaper.  Passing {@code null} for this parameter means that
 *     the full image should be displayed if possible given the image's and device's
 *     aspect ratios, etc.
 * @param allowBackup {@code true} if the OS is permitted to back up this wallpaper
 *     image for restore to a future device; {@code false} otherwise.
 * @param which Flags indicating which wallpaper(s) to configure with the new imagery.
 *
 * Value is either <code>0</code> or a combination of {@link android.app.WallpaperManager#FLAG_SYSTEM}, and {@link android.app.WallpaperManager#FLAG_LOCK}
 * @see #FLAG_LOCK
 * @see #FLAG_SYSTEM
 *
 * @return An integer ID assigned to the newly active wallpaper; or zero on failure.
 *
 * @throws java.io.IOException
 * @apiSince 24
 */

public int setBitmap(android.graphics.Bitmap fullImage, android.graphics.Rect visibleCropHint, boolean allowBackup, int which) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Change the current system wallpaper to a specific byte stream.  The
 * give InputStream is copied into persistent storage and will now be
 * used as the wallpaper.  Currently it must be either a JPEG or PNG
 * image.  On success, the intent {@link android.content.Intent#ACTION_WALLPAPER_CHANGED Intent#ACTION_WALLPAPER_CHANGED}
 * is broadcast.
 *
 * <p>This method is equivalent to calling
 * {@link #setStream(java.io.InputStream,android.graphics.Rect,boolean)} and passing {@code null} for the
 * {@code visibleCrop} rectangle and {@code true} for the {@code allowBackup}
 * parameter.
 *
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#SET_WALLPAPER}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#SET_WALLPAPER}
 * @param bitmapData A stream containing the raw data to install as a wallpaper.  This
 *     data can be in any format handled by {@link android.graphics.BitmapRegionDecoder BitmapRegionDecoder}.
 *
 * @throws java.io.IOException If an error occurs when attempting to set the wallpaper
 *     based on the provided image data.
 * @apiSince 5
 */

public void setStream(java.io.InputStream bitmapData) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Change the current system wallpaper to a specific byte stream, specifying a
 * hint about which subrectangle of the full image is to be visible.  The OS will
 * then try to best present the given portion of the full image as the static system
 * wallpaper image.  The data from the given InputStream is copied into persistent
 * storage and will then be used as the system wallpaper.  Currently the data must
 * be either a JPEG or PNG image.  On success, the intent
 * {@link android.content.Intent#ACTION_WALLPAPER_CHANGED Intent#ACTION_WALLPAPER_CHANGED} is broadcast.
 *
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#SET_WALLPAPER}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#SET_WALLPAPER}
 * @param bitmapData A stream containing the raw data to install as a wallpaper.  This
 *     data can be in any format handled by {@link android.graphics.BitmapRegionDecoder BitmapRegionDecoder}.
 * @param visibleCropHint The rectangular subregion of the streamed image that should be
 *     displayed as wallpaper.  Passing {@code null} for this parameter means that
 *     the full image should be displayed if possible given the image's and device's
 *     aspect ratios, etc.
 * @param allowBackup {@code true} if the OS is permitted to back up this wallpaper
 *     image for restore to a future device; {@code false} otherwise.
 * @return An integer ID assigned to the newly active wallpaper; or zero on failure.
 *
 * @see #getWallpaperId(int)
 *
 * @throws java.io.IOException If an error occurs when attempting to set the wallpaper
 *     based on the provided image data.
 * @throws java.lang.IllegalArgumentException If the {@code visibleCropHint} rectangle is
 *     empty or invalid.
 * @apiSince 24
 */

public int setStream(java.io.InputStream bitmapData, android.graphics.Rect visibleCropHint, boolean allowBackup) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link #setStream(java.io.InputStream,android.graphics.Rect,boolean)} that allows the caller
 * to specify which of the supported wallpaper categories to set.
 *
 * <br>
 * Requires {@link android.Manifest.permission#SET_WALLPAPER}
 * @param bitmapData A stream containing the raw data to install as a wallpaper.  This
 *     data can be in any format handled by {@link android.graphics.BitmapRegionDecoder BitmapRegionDecoder}.
 * @param visibleCropHint The rectangular subregion of the streamed image that should be
 *     displayed as wallpaper.  Passing {@code null} for this parameter means that
 *     the full image should be displayed if possible given the image's and device's
 *     aspect ratios, etc.
 * @param allowBackup {@code true} if the OS is permitted to back up this wallpaper
 *     image for restore to a future device; {@code false} otherwise.
 * @param which Flags indicating which wallpaper(s) to configure with the new imagery.
 * Value is either <code>0</code> or a combination of {@link android.app.WallpaperManager#FLAG_SYSTEM}, and {@link android.app.WallpaperManager#FLAG_LOCK}
 * @return An integer ID assigned to the newly active wallpaper; or zero on failure.
 *
 * @see #getWallpaperId(int)
 * @see #FLAG_LOCK
 * @see #FLAG_SYSTEM
 *
 * @throws java.io.IOException
 * @apiSince 24
 */

public int setStream(java.io.InputStream bitmapData, android.graphics.Rect visibleCropHint, boolean allowBackup, int which) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return whether any users are currently set to use the wallpaper
 * with the given resource ID.  That is, their wallpaper has been
 * set through {@link #setResource(int)} with the same resource id.
 * @apiSince 17
 */

public boolean hasResourceWallpaper(int resid) { throw new RuntimeException("Stub!"); }

/**
 * Returns the desired minimum width for the wallpaper. Callers of
 * {@link #setBitmap(android.graphics.Bitmap)} or
 * {@link #setStream(java.io.InputStream)} should check this value
 * beforehand to make sure the supplied wallpaper respects the desired
 * minimum width.
 *
 * If the returned value is <= 0, the caller should use the width of
 * the default display instead.
 *
 * @return The desired minimum width for the wallpaper. This value should
 * be honored by applications that set the wallpaper but it is not
 * mandatory.
 * @apiSince 5
 */

public int getDesiredMinimumWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the desired minimum height for the wallpaper. Callers of
 * {@link #setBitmap(android.graphics.Bitmap)} or
 * {@link #setStream(java.io.InputStream)} should check this value
 * beforehand to make sure the supplied wallpaper respects the desired
 * minimum height.
 *
 * If the returned value is <= 0, the caller should use the height of
 * the default display instead.
 *
 * @return The desired minimum height for the wallpaper. This value should
 * be honored by applications that set the wallpaper but it is not
 * mandatory.
 * @apiSince 5
 */

public int getDesiredMinimumHeight() { throw new RuntimeException("Stub!"); }

/**
 * For use only by the current home application, to specify the size of
 * wallpaper it would like to use.  This allows such applications to have
 * a virtual wallpaper that is larger than the physical screen, matching
 * the size of their workspace.
 *
 * <p>Note developers, who don't seem to be reading this.  This is
 * for <em>home apps</em> to tell what size wallpaper they would like.
 * Nobody else should be calling this!  Certainly not other non-home
 * apps that change the wallpaper.  Those apps are supposed to
 * <b>retrieve</b> the suggested size so they can construct a wallpaper
 * that matches it.
 *
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#SET_WALLPAPER_HINTS}.
 *
 * @param minimumWidth Desired minimum width
 * @param minimumHeight Desired minimum height
 * @apiSince 5
 */

public void suggestDesiredDimensions(int minimumWidth, int minimumHeight) { throw new RuntimeException("Stub!"); }

/**
 * Specify extra padding that the wallpaper should have outside of the display.
 * That is, the given padding supplies additional pixels the wallpaper should extend
 * outside of the display itself.
 *
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#SET_WALLPAPER_HINTS}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#SET_WALLPAPER_HINTS}
 * @param padding The number of pixels the wallpaper should extend beyond the display,
 * on its left, top, right, and bottom sides.
 * @apiSince 28
 */

public void setDisplayPadding(android.graphics.Rect padding) { throw new RuntimeException("Stub!"); }

/**
 * Reset all wallpaper to the factory default.
 *
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#SET_WALLPAPER}.
 
 * <br>
 * Requires {@link android.Manifest.permission#SET_WALLPAPER}
 * @apiSince 28
 */

public void clearWallpaper() { throw new RuntimeException("Stub!"); }

/**
 * Set the display position of the current wallpaper within any larger space, when
 * that wallpaper is visible behind the given window.  The X and Y offsets
 * are floating point numbers ranging from 0 to 1, representing where the
 * wallpaper should be positioned within the screen space.  These only
 * make sense when the wallpaper is larger than the display.
 *
 * @param windowToken The window who these offsets should be associated
 * with, as returned by {@link android.view.View#getWindowToken()
 * View.getWindowToken()}.
 * @param xOffset The offset along the X dimension, from 0 to 1.
 * @param yOffset The offset along the Y dimension, from 0 to 1.
 * @apiSince 5
 */

public void setWallpaperOffsets(android.os.IBinder windowToken, float xOffset, float yOffset) { throw new RuntimeException("Stub!"); }

/**
 * For applications that use multiple virtual screens showing a wallpaper,
 * specify the step size between virtual screens. For example, if the
 * launcher has 3 virtual screens, it would specify an xStep of 0.5,
 * since the X offset for those screens are 0.0, 0.5 and 1.0
 * @param xStep The X offset delta from one screen to the next one
 * @param yStep The Y offset delta from one screen to the next one
 * @apiSince 7
 */

public void setWallpaperOffsetSteps(float xStep, float yStep) { throw new RuntimeException("Stub!"); }

/**
 * Send an arbitrary command to the current active wallpaper.
 *
 * @param windowToken The window who these offsets should be associated
 * with, as returned by {@link android.view.View#getWindowToken()
 * View.getWindowToken()}.
 * @param action Name of the command to perform.  This must be a scoped
 * name to avoid collisions, such as "com.mycompany.wallpaper.DOIT".
 * @param x Arbitrary integer argument based on command.
 * @param y Arbitrary integer argument based on command.
 * @param z Arbitrary integer argument based on command.
 * @param extras Optional additional information for the command, or null.
 * @apiSince 7
 */

public void sendWallpaperCommand(android.os.IBinder windowToken, java.lang.String action, int x, int y, int z, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether wallpapers are supported for the calling user. If this function returns
 * {@code false}, any attempts to changing the wallpaper will have no effect,
 * and any attempt to obtain of the wallpaper will return {@code null}.
 * @apiSince 23
 */

public boolean isWallpaperSupported() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the calling package is allowed to set the wallpaper for the calling user.
 * If this function returns {@code false}, any attempts to change the wallpaper will have
 * no effect. Always returns {@code true} for device owner and profile owner.
 *
 * @see android.os.UserManager#DISALLOW_SET_WALLPAPER
 * @apiSince 24
 */

public boolean isSetWallpaperAllowed() { throw new RuntimeException("Stub!"); }

/**
 * Clear the offsets previously associated with this window through
 * {@link #setWallpaperOffsets(android.os.IBinder,float,float)}.  This reverts
 * the window to its default state, where it does not cause the wallpaper
 * to scroll from whatever its last offsets were.
 *
 * @param windowToken The window who these offsets should be associated
 * with, as returned by {@link android.view.View#getWindowToken()
 * View.getWindowToken()}.
 * @apiSince 5
 */

public void clearWallpaperOffsets(android.os.IBinder windowToken) { throw new RuntimeException("Stub!"); }

/**
 * Remove any currently set system wallpaper, reverting to the system's built-in
 * wallpaper. On success, the intent {@link android.content.Intent#ACTION_WALLPAPER_CHANGED Intent#ACTION_WALLPAPER_CHANGED}
 * is broadcast.
 *
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#SET_WALLPAPER}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#SET_WALLPAPER}
 * @throws java.io.IOException If an error occurs reverting to the built-in
 * wallpaper.
 * @apiSince 5
 */

public void clear() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Remove one or more currently set wallpapers, reverting to the system default
 * display for each one.  If {@link #FLAG_SYSTEM} is set in the {@code which}
 * parameter, the intent {@link android.content.Intent#ACTION_WALLPAPER_CHANGED Intent#ACTION_WALLPAPER_CHANGED} will be broadcast
 * upon success.
 *
 * <br>
 * Requires {@link android.Manifest.permission#SET_WALLPAPER}
 * @param which A bitwise combination of {@link #FLAG_SYSTEM} or
 *   {@link #FLAG_LOCK}
 * Value is either <code>0</code> or a combination of {@link android.app.WallpaperManager#FLAG_SYSTEM}, and {@link android.app.WallpaperManager#FLAG_LOCK}
 * @throws java.io.IOException If an error occurs reverting to the built-in wallpaper.
 * @apiSince 24
 */

public void clear(int which) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Directly launch live wallpaper preview, allowing the user to immediately
 * confirm to switch to a specific live wallpaper.  You must specify
 * {@link #EXTRA_LIVE_WALLPAPER_COMPONENT} with the ComponentName of
 * a live wallpaper component that is to be shown.
 * @apiSince 16
 */

public static final java.lang.String ACTION_CHANGE_LIVE_WALLPAPER = "android.service.wallpaper.CHANGE_LIVE_WALLPAPER";

/**
 * Activity Action: Show settings for choosing wallpaper. Do not use directly to construct
 * an intent; instead, use {@link #getCropAndSetWallpaperIntent}.
 * <p>Input:  {@link android.content.Intent#getData Intent#getData} is the URI of the image to crop and set as wallpaper.
 * <p>Output: RESULT_OK if user decided to crop/set the wallpaper, RESULT_CANCEL otherwise
 * Activities that support this intent should specify a MIME filter of "image/*"
 * @apiSince 19
 */

public static final java.lang.String ACTION_CROP_AND_SET_WALLPAPER = "android.service.wallpaper.CROP_AND_SET_WALLPAPER";

/**
 * Launch an activity for the user to pick the current global live
 * wallpaper.
 * @apiSince 7
 */

public static final java.lang.String ACTION_LIVE_WALLPAPER_CHOOSER = "android.service.wallpaper.LIVE_WALLPAPER_CHOOSER";

/**
 * Command for {@link #sendWallpaperCommand}: reported by the wallpaper
 * host when the user drops an object into an area of the host.  The x
 * and y arguments are the location of the drop.
 * @apiSince 7
 */

public static final java.lang.String COMMAND_DROP = "android.home.drop";

/**
 * Command for {@link #sendWallpaperCommand}: reported by the wallpaper
 * host when the user releases a secondary pointer on an empty area
 * (not performing an action in the host).  The x and y arguments are
 * the location of the secondary tap in screen coordinates.
 * @apiSince 11
 */

public static final java.lang.String COMMAND_SECONDARY_TAP = "android.wallpaper.secondaryTap";

/**
 * Command for {@link #sendWallpaperCommand}: reported by the wallpaper
 * host when the user taps on an empty area (not performing an action
 * in the host).  The x and y arguments are the location of the tap in
 * screen coordinates.
 * @apiSince 7
 */

public static final java.lang.String COMMAND_TAP = "android.wallpaper.tap";

/**
 * Extra in {@link #ACTION_CHANGE_LIVE_WALLPAPER} that specifies the
 * ComponentName of a live wallpaper that should be shown as a preview,
 * for the user to confirm.
 * @apiSince 16
 */

public static final java.lang.String EXTRA_LIVE_WALLPAPER_COMPONENT = "android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT";

/**
 * Flag: set or retrieve the lock-screen-specific wallpaper.
 * @apiSince 24
 */

public static final int FLAG_LOCK = 2; // 0x2

/**
 * Flag: set or retrieve the general system wallpaper.
 * @apiSince 24
 */

public static final int FLAG_SYSTEM = 1; // 0x1

/**
 * Manifest entry for activities that respond to {@link android.content.Intent#ACTION_SET_WALLPAPER Intent#ACTION_SET_WALLPAPER}
 * which allows them to provide a custom large icon associated with this action.
 * @apiSince 11
 */

public static final java.lang.String WALLPAPER_PREVIEW_META_DATA = "android.wallpaper.preview";
/**
 * Interface definition for a callback to be invoked when colors change on a wallpaper.
 * @apiSince 27
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnColorsChangedListener {

/**
 * Called when colors change.
 * A {@link android.app.WallpaperColors} object containing a simplified
 * color histogram will be given.
 *
 * @param colors Wallpaper color info
 * @param which A combination of {@link #FLAG_LOCK} and {@link #FLAG_SYSTEM}
 * @apiSince 27
 */

public void onColorsChanged(android.app.WallpaperColors colors, int which);
}

}

