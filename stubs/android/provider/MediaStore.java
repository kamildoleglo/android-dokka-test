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


package android.provider;

import android.net.Uri;
import android.content.ContentResolver;
import android.os.CancellationSignal;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.app.Activity;
import android.service.media.CameraPrewarmService;
import android.graphics.Bitmap;
import android.content.ClipData;
import android.database.Cursor;
import android.content.ContentValues;
import java.io.File;
import java.util.Collection;
import android.media.ExifInterface;
import android.graphics.PostProcessor;
import android.graphics.ImageDecoder;
import android.os.OperationCanceledException;

/**
 * The contract between the media provider and applications. Contains
 * definitions for the supported URIs and columns.
 * <p>
 * The media provider provides an indexed collection of common media types, such
 * as {@link android.provider.MediaStore.Audio Audio}, {@link android.provider.MediaStore.Video Video}, and {@link android.provider.MediaStore.Images Images}, from any attached
 * storage devices. Each collection is organized based on the primary MIME type
 * of the underlying content; for example, {@code image/*} content is indexed
 * under {@link android.provider.MediaStore.Images Images}. The {@link android.provider.MediaStore.Files Files} collection provides a broad view
 * across all collections, and does not filter by MIME type.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaStore {

public MediaStore() { throw new RuntimeException("Stub!"); }

/**
 * Update the given {@link android.net.Uri Uri} to also include any pending media items from
 * calls such as
 * {@link android.content.ContentResolver#query(android.net.Uri,java.lang.String[],android.os.Bundle,android.os.CancellationSignal) ContentResolver#query(Uri, String[], Bundle, CancellationSignal)}.
 * By default no pending items are returned.
 *
 * @see android.provider.MediaStore.MediaColumns#IS_PENDING
 * @see android.provider.MediaStore#setIncludePending(Uri)
 
 * @param uri This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.net.Uri setIncludePending(@androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Update the given {@link android.net.Uri Uri} to indicate that the caller requires the
 * original file contents when calling
 * {@link android.content.ContentResolver#openFileDescriptor(android.net.Uri,java.lang.String) ContentResolver#openFileDescriptor(Uri, String)}.
 * <p>
 * This can be useful when the caller wants to ensure they're backing up the
 * exact bytes of the underlying media, without any Exif redaction being
 * performed.
 * <p>
 * If the original file contents cannot be provided, a
 * {@link java.lang.UnsupportedOperationException UnsupportedOperationException} will be thrown when the returned
 * {@link android.net.Uri Uri} is used, such as when the caller doesn't hold
 * {@link android.Manifest.permission#ACCESS_MEDIA_LOCATION}.
 
 * @param uri This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.net.Uri setRequireOriginal(@androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Return list of all specific volume names that make up
 * {@link #VOLUME_EXTERNAL}. This includes a unique volume name for each
 * shared storage device that is currently attached, which typically
 * includes {@link android.provider.MediaStore#VOLUME_EXTERNAL_PRIMARY MediaStore#VOLUME_EXTERNAL_PRIMARY}.
 * <p>
 * Each specific volume name can be passed to APIs like
 * {@link android.provider.MediaStore.Images.Media#getContentUri(java.lang.String) MediaStore.Images.Media#getContentUri(String)} to interact with
 * media on that storage device.
 
 * @param context This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static java.util.Set<java.lang.String> getExternalVolumeNames(@androidx.annotation.NonNull android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Return the volume name that the given {@link android.net.Uri Uri} references.
 
 * @param uri This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static java.lang.String getVolumeName(@androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Uri for querying the state of the media scanner.
 * @apiSince 1
 */

public static android.net.Uri getMediaScannerUri() { throw new RuntimeException("Stub!"); }

/**
 * Return an opaque version string describing the {@link android.provider.MediaStore MediaStore} state.
 * <p>
 * Applications that import data from {@link android.provider.MediaStore MediaStore} into their own
 * caches can use this to detect that {@link android.provider.MediaStore MediaStore} has undergone
 * substantial changes, and that data should be rescanned.
 * <p>
 * No other assumptions should be made about the meaning of the version.
 * <p>
 * This method returns the version for
 * {@link android.provider.MediaStore#VOLUME_EXTERNAL_PRIMARY MediaStore#VOLUME_EXTERNAL_PRIMARY}; to obtain a version for a
 * different volume, use {@link #getVersion(android.content.Context,java.lang.String)}.
 
 * @param context This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 12
 */

@androidx.annotation.NonNull
public static java.lang.String getVersion(@androidx.annotation.NonNull android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Return an opaque version string describing the {@link android.provider.MediaStore MediaStore} state.
 * <p>
 * Applications that import data from {@link android.provider.MediaStore MediaStore} into their own
 * caches can use this to detect that {@link android.provider.MediaStore MediaStore} has undergone
 * substantial changes, and that data should be rescanned.
 * <p>
 * No other assumptions should be made about the meaning of the version.
 *
 * @param volumeName specific volume to obtain an opaque version string for.
 *            Must be one of the values returned from
 *            {@link #getExternalVolumeNames(android.content.Context)}.
 
 * This value must never be {@code null}.
 * @param context This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static java.lang.String getVersion(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link android.provider.DocumentsProvider DocumentsProvider} Uri that is an equivalent to the given
 * {@link android.provider.MediaStore MediaStore} Uri.
 * <p>
 * This allows apps with Storage Access Framework permissions to convert
 * between {@link android.provider.MediaStore MediaStore} and {@link android.provider.DocumentsProvider DocumentsProvider} Uris that refer
 * to the same underlying item. Note that this method doesn't grant any new
 * permissions; callers must already hold permissions obtained with
 * {@link android.content.Intent#ACTION_OPEN_DOCUMENT Intent#ACTION_OPEN_DOCUMENT} or related APIs.
 *
 * @param mediaUri The {@link android.provider.MediaStore MediaStore} Uri to convert.
 * This value must never be {@code null}.
 * @param context This value must never be {@code null}.
 * @return An equivalent {@link android.provider.DocumentsProvider DocumentsProvider} Uri. Returns {@code null}
 *         if no equivalent was found.
 * @see #getMediaUri(Context, Uri)
 * @apiSince 26
 */

@androidx.annotation.Nullable
public static android.net.Uri getDocumentUri(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.net.Uri mediaUri) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link android.provider.MediaStore MediaStore} Uri that is an equivalent to the given
 * {@link android.provider.DocumentsProvider DocumentsProvider} Uri.
 * <p>
 * This allows apps with Storage Access Framework permissions to convert
 * between {@link android.provider.MediaStore MediaStore} and {@link android.provider.DocumentsProvider DocumentsProvider} Uris that refer
 * to the same underlying item. Note that this method doesn't grant any new
 * permissions; callers must already hold permissions obtained with
 * {@link android.content.Intent#ACTION_OPEN_DOCUMENT Intent#ACTION_OPEN_DOCUMENT} or related APIs.
 *
 * @param documentUri The {@link android.provider.DocumentsProvider DocumentsProvider} Uri to convert.
 * This value must never be {@code null}.
 * @param context This value must never be {@code null}.
 * @return An equivalent {@link android.provider.MediaStore MediaStore} Uri. Returns {@code null} if no
 *         equivalent was found.
 * @see #getDocumentUri(Context, Uri)
 * @apiSince 29
 */

@androidx.annotation.Nullable
public static android.net.Uri getMediaUri(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.net.Uri documentUri) { throw new RuntimeException("Stub!"); }

/**
 * Standard Intent action that can be sent to have the camera application
 * capture an image and return it.
 * <p>
 * The caller may pass an extra EXTRA_OUTPUT to control where this image will be written.
 * If the EXTRA_OUTPUT is not present, then a small sized image is returned as a Bitmap
 * object in the extra field. This is useful for applications that only need a small image.
 * If the EXTRA_OUTPUT is present, then the full-sized image will be written to the Uri
 * value of EXTRA_OUTPUT.
 * As of {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this uri can also be supplied through
 * {@link android.content.Intent#setClipData(ClipData)}. If using this approach, you still must
 * supply the uri through the EXTRA_OUTPUT field for compatibility with old applications.
 * If you don't set a ClipData, it will be copied there for you when calling
 * {@link android.content.Context#startActivity(android.content.Intent) Context#startActivity(Intent)}.
 *
 * <p>Note: if you app targets {@link android.os.Build.VERSION_CODES#M M} and above
 * and declares as using the {@link android.Manifest.permission#CAMERA} permission which
 * is not granted, then attempting to use this action will result in a {@link
 * java.lang.SecurityException}.
 *
 *  @see #EXTRA_OUTPUT
 * @apiSince 3
 */

public static final java.lang.String ACTION_IMAGE_CAPTURE = "android.media.action.IMAGE_CAPTURE";

/**
 * Intent action that can be sent to have the camera application capture an image and return
 * it when the device is secured (e.g.&nbsp;with a pin, password, pattern, or face unlock).
 * Applications responding to this intent must not expose any personal content like existing
 * photos or videos on the device. The applications should be careful not to share any photo
 * or video with other applications or Internet. The activity should use {@link android.app.Activity#setShowWhenLocked Activity#setShowWhenLocked} to display on top of the
 * lock screen while secured. There is no activity stack when this flag is used, so
 * launching more than one activity is strongly discouraged.
 * <p>
 * The caller may pass an extra EXTRA_OUTPUT to control where this image will be written.
 * If the EXTRA_OUTPUT is not present, then a small sized image is returned as a Bitmap
 * object in the extra field. This is useful for applications that only need a small image.
 * If the EXTRA_OUTPUT is present, then the full-sized image will be written to the Uri
 * value of EXTRA_OUTPUT.
 * As of {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this uri can also be supplied through
 * {@link android.content.Intent#setClipData(ClipData)}. If using this approach, you still must
 * supply the uri through the EXTRA_OUTPUT field for compatibility with old applications.
 * If you don't set a ClipData, it will be copied there for you when calling
 * {@link android.content.Context#startActivity(android.content.Intent) Context#startActivity(Intent)}.
 *
 * @see #ACTION_IMAGE_CAPTURE
 * @see #EXTRA_OUTPUT
 * @apiSince 17
 */

public static final java.lang.String ACTION_IMAGE_CAPTURE_SECURE = "android.media.action.IMAGE_CAPTURE_SECURE";

/**
 * Standard action that can be sent to review the given media file.
 * <p>
 * The launched application is expected to provide a large-scale view of the
 * given media file, while allowing the user to quickly access other
 * recently captured media files.
 * <p>
 * Input: {@link android.content.Intent#getData Intent#getData} is URI of the primary media item to
 * initially display.
 *
 * @see #ACTION_REVIEW_SECURE
 * @see #EXTRA_BRIGHTNESS
 * @apiSince 29
 */

public static final java.lang.String ACTION_REVIEW = "android.provider.action.REVIEW";

/**
 * Standard action that can be sent to review the given media file when the
 * device is secured (e.g.&nbsp;with a pin, password, pattern, or face unlock).
 * The applications should be careful not to share any media with other
 * applications or Internet. The activity should use
 * {@link android.app.Activity#setShowWhenLocked Activity#setShowWhenLocked} to display on top of the lock screen
 * while secured. There is no activity stack when this flag is used, so
 * launching more than one activity is strongly discouraged.
 * <p>
 * The launched application is expected to provide a large-scale view of the
 * given primary media file, while only allowing the user to quickly access
 * other media from an explicit secondary list.
 * <p>
 * Input: {@link android.content.Intent#getData Intent#getData} is URI of the primary media item to
 * initially display. {@link android.content.Intent#getClipData Intent#getClipData} is the limited list of
 * secondary media items that the user is allowed to review. If
 * {@link android.content.Intent#getClipData Intent#getClipData} is undefined, then no other media access
 * should be allowed.
 *
 * @see #EXTRA_BRIGHTNESS
 * @apiSince 29
 */

public static final java.lang.String ACTION_REVIEW_SECURE = "android.provider.action.REVIEW_SECURE";

/**
 * Standard Intent action that can be sent to have the camera application
 * capture a video and return it.
 * <p>
 * The caller may pass in an extra EXTRA_VIDEO_QUALITY to control the video quality.
 * <p>
 * The caller may pass in an extra EXTRA_OUTPUT to control
 * where the video is written. If EXTRA_OUTPUT is not present the video will be
 * written to the standard location for videos, and the Uri of that location will be
 * returned in the data field of the Uri.
 * As of {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this uri can also be supplied through
 * {@link android.content.Intent#setClipData(ClipData)}. If using this approach, you still must
 * supply the uri through the EXTRA_OUTPUT field for compatibility with old applications.
 * If you don't set a ClipData, it will be copied there for you when calling
 * {@link android.content.Context#startActivity(android.content.Intent) Context#startActivity(Intent)}.
 *
 * <p>Note: if you app targets {@link android.os.Build.VERSION_CODES#M M} and above
 * and declares as using the {@link android.Manifest.permission#CAMERA} permission which
 * is not granted, then atempting to use this action will result in a {@link
 * java.lang.SecurityException}.
 *
 * @see #EXTRA_OUTPUT
 * @see #EXTRA_VIDEO_QUALITY
 * @see #EXTRA_SIZE_LIMIT
 * @see #EXTRA_DURATION_LIMIT
 * @apiSince 3
 */

public static final java.lang.String ACTION_VIDEO_CAPTURE = "android.media.action.VIDEO_CAPTURE";

/**
 * The authority for the media provider
 * @apiSince 1
 */

public static final java.lang.String AUTHORITY = "media";

/**
 * A content:// style uri to the authority for the media provider
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.net.Uri AUTHORITY_URI;
static { AUTHORITY_URI = null; }

/**
 * When defined, the launched application is requested to set the given
 * brightness value via
 * {@link android.view.WindowManager.LayoutParams#screenBrightness} to help
 * ensure a smooth transition when launching {@link #ACTION_REVIEW} or
 * {@link #ACTION_REVIEW_SECURE} intents.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_BRIGHTNESS = "android.provider.extra.BRIGHTNESS";

/**
 * Specify the maximum allowed recording duration in seconds.
 * @apiSince 8
 */

public static final java.lang.String EXTRA_DURATION_LIMIT = "android.intent.extra.durationLimit";

/**
 * The name of the Intent-extra used to control the onCompletion behavior of a MovieView.
 * This is a boolean property that specifies whether or not to finish the MovieView activity
 * when the movie completes playing. The default value is true, which means to automatically
 * exit the movie player activity when the movie completes playing.
 * @apiSince 3
 */

public static final java.lang.String EXTRA_FINISH_ON_COMPLETION = "android.intent.extra.finishOnCompletion";

/**
 * The name of an Intent-extra used to control the UI of a ViewImage.
 * This is a boolean property that overrides the activity's default fullscreen state.
 * @apiSince 8
 */

public static final java.lang.String EXTRA_FULL_SCREEN = "android.intent.extra.fullScreen";

/**
 * The name of the Intent-extra used to define the album
 * @apiSince 3
 */

public static final java.lang.String EXTRA_MEDIA_ALBUM = "android.intent.extra.album";

/**
 * The name of the Intent-extra used to define the artist
 * @apiSince 3
 */

public static final java.lang.String EXTRA_MEDIA_ARTIST = "android.intent.extra.artist";

/**
 * The name of the Intent-extra used to define the search focus. The search focus
 * indicates whether the search should be for things related to the artist, album
 * or song that is identified by the other extras.
 * @apiSince 3
 */

public static final java.lang.String EXTRA_MEDIA_FOCUS = "android.intent.extra.focus";

/**
 * The name of the Intent-extra used to define the genre.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_MEDIA_GENRE = "android.intent.extra.genre";

/**
 * The name of the Intent-extra used to define the playlist.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_MEDIA_PLAYLIST = "android.intent.extra.playlist";

/**
 * The name of the Intent-extra used to define the radio channel.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_MEDIA_RADIO_CHANNEL = "android.intent.extra.radio_channel";

/**
 * The name of the Intent-extra used to define the song title
 * @apiSince 3
 */

public static final java.lang.String EXTRA_MEDIA_TITLE = "android.intent.extra.title";

/**
 * The name of the Intent-extra used to indicate a content resolver Uri to be used to
 * store the requested image or video.
 * @apiSince 3
 */

public static final java.lang.String EXTRA_OUTPUT = "output";

/**
 * The name of the Intent-extra used to control the orientation of a ViewImage or a MovieView.
 * This is an int property that overrides the activity's requestedOrientation.
 * @see android.content.pm.ActivityInfo#SCREEN_ORIENTATION_UNSPECIFIED
 * @apiSince 3
 */

public static final java.lang.String EXTRA_SCREEN_ORIENTATION = "android.intent.extra.screenOrientation";

/**
 * The name of an Intent-extra used to control the UI of a ViewImage.
 * This is a boolean property that specifies whether or not to show action icons.
 * @apiSince 8
 */

public static final java.lang.String EXTRA_SHOW_ACTION_ICONS = "android.intent.extra.showActionIcons";

/**
 * Specify the maximum allowed size.
 * @apiSince 8
 */

public static final java.lang.String EXTRA_SIZE_LIMIT = "android.intent.extra.sizeLimit";

/**
 * The name of the Intent-extra used to control the quality of a recorded video. This is an
 * integer property. Currently value 0 means low quality, suitable for MMS messages, and
 * value 1 means high quality. In the future other quality levels may be added.
 * @apiSince 3
 */

public static final java.lang.String EXTRA_VIDEO_QUALITY = "android.intent.extra.videoQuality";

/**
 * An intent to perform a search for music media and automatically play content from the
 * result when possible. This can be fired, for example, by the result of a voice recognition
 * command to listen to music.
 * <p>This intent always includes the {@link android.provider.MediaStore#EXTRA_MEDIA_FOCUS}
 * and {@link android.app.SearchManager#QUERY} extras. The
 * {@link android.provider.MediaStore#EXTRA_MEDIA_FOCUS} extra determines the search mode, and
 * the value of the {@link android.app.SearchManager#QUERY} extra depends on the search mode.
 * For more information about the search modes for this intent, see
 * <a href="{@docRoot}guide/components/intents-common.html#PlaySearch">Play music based
 * on a search query</a> in <a href="{@docRoot}guide/components/intents-common.html">Common
 * Intents</a>.</p>
 *
 * <p>This intent makes the most sense for apps that can support large-scale search of music,
 * such as services connected to an online database of music which can be streamed and played
 * on the device.</p>
 * @apiSince 9
 */

public static final java.lang.String INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH = "android.media.action.MEDIA_PLAY_FROM_SEARCH";

/**
 * Activity Action: Perform a search for media.
 * Contains at least the {@link android.app.SearchManager#QUERY} extra.
 * May also contain any combination of the following extras:
 * EXTRA_MEDIA_ARTIST, EXTRA_MEDIA_ALBUM, EXTRA_MEDIA_TITLE, EXTRA_MEDIA_FOCUS
 *
 * @see android.provider.MediaStore#EXTRA_MEDIA_ARTIST
 * @see android.provider.MediaStore#EXTRA_MEDIA_ALBUM
 * @see android.provider.MediaStore#EXTRA_MEDIA_TITLE
 * @see android.provider.MediaStore#EXTRA_MEDIA_FOCUS
 * @apiSince 3
 */

public static final java.lang.String INTENT_ACTION_MEDIA_SEARCH = "android.intent.action.MEDIA_SEARCH";

/**
 * Activity Action: Launch a music player.
 * The activity should be able to play, browse, or manipulate music files stored on the device.
 *
 * @deprecated Use {@link android.content.Intent#CATEGORY_APP_MUSIC} instead.
 * @apiSince 8
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String INTENT_ACTION_MUSIC_PLAYER = "android.intent.action.MUSIC_PLAYER";

/**
 * The name of the Intent action used to launch a camera in still image mode.
 * @apiSince 3
 */

public static final java.lang.String INTENT_ACTION_STILL_IMAGE_CAMERA = "android.media.action.STILL_IMAGE_CAMERA";

/**
 * The name of the Intent action used to launch a camera in still image mode
 * for use when the device is secured (e.g.&nbsp;with a pin, password, pattern,
 * or face unlock). Applications responding to this intent must not expose
 * any personal content like existing photos or videos on the device. The
 * applications should be careful not to share any photo or video with other
 * applications or internet. The activity should use {@link android.app.Activity#setShowWhenLocked Activity#setShowWhenLocked} to display
 * on top of the lock screen while secured. There is no activity stack when
 * this flag is used, so launching more than one activity is strongly
 * discouraged.
 * @apiSince 17
 */

public static final java.lang.String INTENT_ACTION_STILL_IMAGE_CAMERA_SECURE = "android.media.action.STILL_IMAGE_CAMERA_SECURE";

/**
 * An intent to perform a search for readable media and automatically play content from the
 * result when possible. This can be fired, for example, by the result of a voice recognition
 * command to read a book or magazine.
 * <p>
 * Contains the {@link android.app.SearchManager#QUERY} extra, which is a string that can
 * contain any type of unstructured text search, like the name of a book or magazine, an author
 * a genre, a publisher, or any combination of these.
 * <p>
 * Because this intent includes an open-ended unstructured search string, it makes the most
 * sense for apps that can support large-scale search of text media, such as services connected
 * to an online database of books and/or magazines which can be read on the device.
 * @apiSince 17
 */

public static final java.lang.String INTENT_ACTION_TEXT_OPEN_FROM_SEARCH = "android.media.action.TEXT_OPEN_FROM_SEARCH";

/**
 * The name of the Intent action used to launch a camera in video mode.
 * @apiSince 3
 */

public static final java.lang.String INTENT_ACTION_VIDEO_CAMERA = "android.media.action.VIDEO_CAMERA";

/**
 * An intent to perform a search for video media and automatically play content from the
 * result when possible. This can be fired, for example, by the result of a voice recognition
 * command to play movies.
 * <p>
 * Contains the {@link android.app.SearchManager#QUERY} extra, which is a string that can
 * contain any type of unstructured video search, like the name of a movie, one or more actors,
 * a genre, or any combination of these.
 * <p>
 * Because this intent includes an open-ended unstructured search string, it makes the most
 * sense for apps that can support large-scale search of video, such as services connected to an
 * online database of videos which can be streamed and played on the device.
 * @apiSince 17
 */

public static final java.lang.String INTENT_ACTION_VIDEO_PLAY_FROM_SEARCH = "android.media.action.VIDEO_PLAY_FROM_SEARCH";

/**
 * Name of the file signaling the media scanner to ignore media in the containing directory
 * and its subdirectories. Developers should use this to avoid application graphics showing
 * up in the Gallery and likewise prevent application sounds and music from showing up in
 * the Music app.
 * @apiSince 9
 */

public static final java.lang.String MEDIA_IGNORE_FILENAME = ".nomedia";

/**
 * Name of current volume being scanned by the media scanner.
 * @apiSince 1
 */

public static final java.lang.String MEDIA_SCANNER_VOLUME = "volume";

/**
 * Name under which an activity handling {@link #INTENT_ACTION_STILL_IMAGE_CAMERA} or
 * {@link #INTENT_ACTION_STILL_IMAGE_CAMERA_SECURE} publishes the service name for its prewarm
 * service.
 * <p>
 * This meta-data should reference the fully qualified class name of the prewarm service
 * extending {@link android.service.media.CameraPrewarmService CameraPrewarmService}.
 * <p>
 * The prewarm service will get bound and receive a prewarm signal
 * {@link android.service.media.CameraPrewarmService#onPrewarm() CameraPrewarmService#onPrewarm()} when a camera launch intent fire might be imminent.
 * An application implementing a prewarm service should do the absolute minimum amount of work
 * to initialize the camera in order to reduce startup time in likely case that shortly after a
 * camera launch intent would be sent.
 * @apiSince 23
 */

public static final java.lang.String META_DATA_STILL_IMAGE_CAMERA_PREWARM_SERVICE = "android.media.still_image_camera_preview_service";

/**
 * The string that is used when a media attribute is not known. For example,
 * if an audio file does not have any meta data, the artist and album columns
 * will be set to this value.
 * @apiSince 8
 */

public static final java.lang.String UNKNOWN_STRING = "<unknown>";

/**
 * Synthetic volume name that provides a view of all content across the
 * "external" storage of the device.
 * <p>
 * This synthetic volume provides a merged view of all media across all
 * currently attached external storage devices.
 * <p>
 * Because this is a synthetic volume, you can't insert new content into
 * this volume. Instead, you can insert content into a specific storage
 * volume obtained from {@link #getExternalVolumeNames(android.content.Context)}.
 * @apiSince 29
 */

public static final java.lang.String VOLUME_EXTERNAL = "external";

/**
 * Specific volume name that represents the primary external storage device
 * at {@link android.os.Environment#getExternalStorageDirectory() Environment#getExternalStorageDirectory()}.
 * <p>
 * This volume may not always be available, such as when the user has
 * ejected the device. You can find a list of all specific volume names
 * using {@link #getExternalVolumeNames(android.content.Context)}.
 * @apiSince 29
 */

public static final java.lang.String VOLUME_EXTERNAL_PRIMARY = "external_primary";

/**
 * Synthetic volume name that provides a view of all content across the
 * "internal" storage of the device.
 * <p>
 * This synthetic volume provides a merged view of all media distributed
 * with the device, such as built-in ringtones and wallpapers.
 * <p>
 * Because this is a synthetic volume, you can't insert new content into
 * this volume.
 * @apiSince 29
 */

public static final java.lang.String VOLUME_INTERNAL = "internal";
/**
 * Collection of all media with MIME type of {@code audio/*}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Audio {

public Audio() { throw new RuntimeException("Stub!"); }

/**
 * Converts a name to a "key" that can be used for grouping, sorting
 * and searching.
 * The rules that govern this conversion are:
 * - remove 'special' characters like ()[]'!?.,
 * - remove leading/trailing spaces
 * - convert everything to lowercase
 * - remove leading "the ", "an " and "a "
 * - remove trailing ", the|an|a"
 * - remove accents. This step leaves us with CollationKey data,
 *   which is not human readable
 *
 * @param name The artist or album name to convert
 * @return The "key" for the given name.
 * @apiSince 1
 */

public static java.lang.String keyFor(java.lang.String name) { throw new RuntimeException("Stub!"); }
/**
 * Audio album metadata columns.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface AlbumColumns {

/**
 * The album on which the audio file appears, if any
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String ALBUM = "album";

/**
 * Cached album art.
 *
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @deprecated Apps may not have filesystem permissions to directly
 *             access this path. Instead of trying to open this path
 *             directly, apps should use
 *             {@link android.content.ContentResolver#loadThumbnail ContentResolver#loadThumbnail}
 *             to gain access.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String ALBUM_ART = "album_art";

/**
 * The id for the album
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String ALBUM_ID = "album_id";

/**
 * A non human readable key calculated from the ALBUM, used for
 * searching, sorting and grouping
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String ALBUM_KEY = "album_key";

/**
 * The name of the artist whose songs appear on this album.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String ARTIST = "artist";

/**
 * The ID of the artist whose songs appear on this album.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 29
 */

public static final java.lang.String ARTIST_ID = "artist_id";

/**
 * The year in which the earliest songs
 * on this album were released. This will often
 * be the same as {@link #LAST_YEAR}, but for compilation albums
 * they might differ.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String FIRST_YEAR = "minyear";

/**
 * The year in which the latest songs
 * on this album were released. This will often
 * be the same as {@link #FIRST_YEAR}, but for compilation albums
 * they might differ.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String LAST_YEAR = "maxyear";

/**
 * The number of songs on this album
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String NUMBER_OF_SONGS = "numsongs";

/**
 * This column is available when getting album info via artist,
 * and indicates the number of songs on the album by the given
 * artist.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 3
 */

public static final java.lang.String NUMBER_OF_SONGS_FOR_ARTIST = "numsongs_by_artist";
}

/**
 * Contains artists for audio files
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Albums implements android.provider.BaseColumns, android.provider.MediaStore.Audio.AlbumColumns {

public Albums() { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the albums table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the audio albums table on the given volume
 * @apiSince 1
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type for this table.
 * @apiSince 1
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/albums";

/**
 * The default sort order for this table
 * @apiSince 1
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "album_key";

/**
 * The MIME type for entries in this table.
 * @apiSince 1
 */

public static final java.lang.String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/album";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 * @apiSince 1
 */

public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * The content:// style URI for the internal storage.
 * @apiSince 1
 */

public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }
}

/**
 * Audio artist metadata columns.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ArtistColumns {

/**
 * The artist who created the audio file, if any
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String ARTIST = "artist";

/**
 * A non human readable key calculated from the ARTIST, used for
 * searching, sorting and grouping
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String ARTIST_KEY = "artist_key";

/**
 * The number of albums in the database for this artist
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String NUMBER_OF_ALBUMS = "number_of_albums";

/**
 * The number of albums in the database for this artist
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String NUMBER_OF_TRACKS = "number_of_tracks";
}

/**
 * Contains artists for audio files
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Artists implements android.provider.BaseColumns, android.provider.MediaStore.Audio.ArtistColumns {

public Artists() { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the artists table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the audio artists table on the given volume
 * @apiSince 1
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type for this table.
 * @apiSince 1
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/artists";

/**
 * The default sort order for this table
 * @apiSince 1
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "artist_key";

/**
 * The MIME type for entries in this table.
 * @apiSince 1
 */

public static final java.lang.String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/artist";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 * @apiSince 1
 */

public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * The content:// style URI for the internal storage.
 * @apiSince 1
 */

public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }
/**
 * Sub-directory of each artist containing all albums on which
 * a song by the artist appears.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Albums implements android.provider.MediaStore.Audio.AlbumColumns {

public Albums() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static android.net.Uri getContentUri(java.lang.String volumeName, long artistId) { throw new RuntimeException("Stub!"); }
}

}

/**
 * Audio metadata columns.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface AudioColumns extends android.provider.MediaStore.MediaColumns {

/**
 * The album the audio file is from, if any
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String ALBUM = "album";

/**
 * The id of the album the audio file is from, if any
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String ALBUM_ID = "album_id";

/**
 * A non human readable key calculated from the ALBUM, used for
 * searching, sorting and grouping
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String ALBUM_KEY = "album_key";

/**
 * The artist who created the audio file, if any
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String ARTIST = "artist";

/**
 * The id of the artist who created the audio file, if any
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String ARTIST_ID = "artist_id";

/**
 * A non human readable key calculated from the ARTIST, used for
 * searching, sorting and grouping
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String ARTIST_KEY = "artist_key";

/**
 * The position within the audio item at which playback should be
 * resumed.
 
 * <br>
 * Value is a non-negative duration in milliseconds.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 8
 */

public static final java.lang.String BOOKMARK = "bookmark";

/**
 * The composer of the audio file, if any
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String COMPOSER = "composer";

/**
 * Non-zero if the audio file may be an alarm
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String IS_ALARM = "is_alarm";

/**
 * Non-zero if the audio file is an audiobook
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 29
 */

public static final java.lang.String IS_AUDIOBOOK = "is_audiobook";

/**
 * Non-zero if the audio file is music
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String IS_MUSIC = "is_music";

/**
 * Non-zero if the audio file may be a notification sound
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String IS_NOTIFICATION = "is_notification";

/**
 * Non-zero if the audio file is a podcast
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 8
 */

public static final java.lang.String IS_PODCAST = "is_podcast";

/**
 * Non-zero if the audio file may be a ringtone
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String IS_RINGTONE = "is_ringtone";

/**
 * A non human readable key calculated from the TITLE, used for
 * searching, sorting and grouping
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String TITLE_KEY = "title_key";

/**
 * The track number of this song on the album, if any.
 * This number encodes both the track number and the
 * disc number. For multi-disc sets, this number will
 * be 1xxx for tracks on the first disc, 2xxx for tracks
 * on the second disc, etc.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String TRACK = "track";

/**
 * The year the audio file was recorded, if any
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String YEAR = "year";
}

/**
 * Contains all genres for audio files
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Genres implements android.provider.BaseColumns, android.provider.MediaStore.Audio.GenresColumns {

public Genres() { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the audio genres table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the audio genres table on the given volume
 * @apiSince 1
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for querying the genres of an audio file.
 *
 * @param volumeName the name of the volume to get the URI for
 * @param audioId the ID of the audio file for which to retrieve the genres
 * @return the URI to for querying the genres for the audio file
 * with the given the volume and audioID
 * @apiSince 11
 */

public static android.net.Uri getContentUriForAudioId(java.lang.String volumeName, int audioId) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type for this table.
 * @apiSince 1
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/genre";

/**
 * The default sort order for this table
 * @apiSince 1
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "name";

/**
 * The MIME type for entries in this table.
 * @apiSince 1
 */

public static final java.lang.String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/genre";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 * @apiSince 1
 */

public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * The content:// style URI for the internal storage.
 * @apiSince 1
 */

public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }
/**
 * Sub-directory of each genre containing all members.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Members implements android.provider.MediaStore.Audio.AudioColumns {

public Members() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static android.net.Uri getContentUri(java.lang.String volumeName, long genreId) { throw new RuntimeException("Stub!"); }

/**
 * The ID of the audio file
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 1
 */

public static final java.lang.String AUDIO_ID = "audio_id";

/**
 * A subdirectory of each genre containing all member audio files.
 * @apiSince 1
 */

public static final java.lang.String CONTENT_DIRECTORY = "members";

/**
 * The default sort order for this table
 * @apiSince 1
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "title_key";

/**
 * The ID of the genre
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 1
 */

public static final java.lang.String GENRE_ID = "genre_id";
}

}

/**
 * Audio genre metadata columns.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface GenresColumns {

/**
 * The name of the genre
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @apiSince 1
 */

public static final java.lang.String NAME = "name";
}

/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Media implements android.provider.MediaStore.Audio.AudioColumns {

public Media() { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the audio media table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the audio media table on the given volume
 * @apiSince 1
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the given audio media file.
 *
 * @deprecated Apps may not have filesystem permissions to directly
 *             access this path.
 
 * @param path This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.Nullable
public static android.net.Uri getContentUriForPath(@androidx.annotation.NonNull java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type for this table.
 * @apiSince 1
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/audio";

/**
 * The default sort order for this table
 * @apiSince 1
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "title_key";

/**
 * The MIME type for an audio track.
 * @apiSince 21
 */

public static final java.lang.String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/audio";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 * @apiSince 1
 */

public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * The name of the Intent-extra used to define a maximum file size for
 * a recording made by the SoundRecorder application.
 *
 * @see #RECORD_SOUND_ACTION
 * @apiSince 3
 */

public static final java.lang.String EXTRA_MAX_BYTES = "android.provider.MediaStore.extra.MAX_BYTES";

/**
 * The content:// style URI for the internal storage.
 * @apiSince 1
 */

public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }

/**
 * Activity Action: Start SoundRecorder application.
 * <p>Input: nothing.
 * <p>Output: An uri to the recorded sound stored in the Media Library
 * if the recording was successful.
 * May also contain the extra EXTRA_MAX_BYTES.
 * @see #EXTRA_MAX_BYTES
 * @apiSince 1
 */

public static final java.lang.String RECORD_SOUND_ACTION = "android.provider.MediaStore.RECORD_SOUND";
}

/**
 * Contains playlists for audio files
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Playlists implements android.provider.BaseColumns, android.provider.MediaStore.Audio.PlaylistsColumns {

public Playlists() { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the audio playlists table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the audio playlists table on the given volume
 * @apiSince 1
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type for this table.
 * @apiSince 1
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/playlist";

/**
 * The default sort order for this table
 * @apiSince 1
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "name";

/**
 * The MIME type for entries in this table.
 * @apiSince 1
 */

public static final java.lang.String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/playlist";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 * @apiSince 1
 */

public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * The content:// style URI for the internal storage.
 * @apiSince 1
 */

public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }
/**
 * Sub-directory of each playlist containing all members.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Members implements android.provider.MediaStore.Audio.AudioColumns {

public Members() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static android.net.Uri getContentUri(java.lang.String volumeName, long playlistId) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to move a playlist item to a new location
 * @param res The content resolver to use
 * @param playlistId The numeric id of the playlist
 * @param from The position of the item to move
 * @param to The position to move the item to
 * @return true on success
 * @apiSince 8
 */

public static boolean moveItem(android.content.ContentResolver res, long playlistId, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * The ID of the audio file
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 1
 */

public static final java.lang.String AUDIO_ID = "audio_id";

/**
 * A subdirectory of each playlist containing all member audio
 * files.
 * @apiSince 1
 */

public static final java.lang.String CONTENT_DIRECTORY = "members";

/**
 * The default sort order for this table
 * @apiSince 1
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "play_order";

/**
 * The ID of the playlist
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 1
 */

public static final java.lang.String PLAYLIST_ID = "playlist_id";

/**
 * The order of the songs in the playlist
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 1
 */

public static final java.lang.String PLAY_ORDER = "play_order";

/**
 * The ID within the playlist.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 1
 */

public static final java.lang.String _ID = "_id";
}

}

/**
 * Audio playlist metadata columns.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface PlaylistsColumns {

/**
 * Path to the playlist file on disk.
 * <p>
 * Note that apps may not have filesystem permissions to directly
 * access this path. Instead of trying to open this path directly,
 * apps should use
 * {@link android.content.ContentResolver#openFileDescriptor(android.net.Uri,java.lang.String) ContentResolver#openFileDescriptor(Uri, String)} to gain
 * access.
 *
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @deprecated Apps may not have filesystem permissions to directly
 *             access this path. Instead of trying to open this path
 *             directly, apps should use
 *             {@link android.content.ContentResolver#openFileDescriptor(android.net.Uri,java.lang.String) ContentResolver#openFileDescriptor(Uri, String)}
 *             to gain access.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String DATA = "_data";

/**
 * The time the media item was first added.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String DATE_ADDED = "date_added";

/**
 * The time the media item was last modified.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String DATE_MODIFIED = "date_modified";

/**
 * The name of the playlist
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @apiSince 1
 */

public static final java.lang.String NAME = "name";
}

/** @apiSince 21 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Radio {

private Radio() { throw new RuntimeException("Stub!"); }

/**
 * The MIME type for entries in this table.
 * @apiSince 21
 */

public static final java.lang.String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/radio";
}

}

/**
 * Download metadata columns.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface DownloadColumns extends android.provider.MediaStore.MediaColumns {

/**
 * Uri indicating where the item has been downloaded from.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @apiSince 29
 */

public static final java.lang.String DOWNLOAD_URI = "download_uri";

/**
 * Uri indicating HTTP referer of {@link #DOWNLOAD_URI}.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @apiSince 29
 */

public static final java.lang.String REFERER_URI = "referer_uri";
}

/**
 * Collection of downloaded items.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Downloads implements android.provider.MediaStore.DownloadColumns {

private Downloads() { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the downloads table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * This value must never be {@code null}.
 * @return the URI to the image media table on the given volume
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.net.Uri getContentUri(@androidx.annotation.NonNull java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type for this table.
 * @apiSince 29
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/download";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * The content:// style URI for the internal storage.
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }
}

/**
 * Media provider table containing an index of all files in the media storage,
 * including non-media files.  This should be used by applications that work with
 * non-media file types (text, HTML, PDF, etc) as well as applications that need to
 * work with multiple media file types in a single query.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Files {

public Files() { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the files table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the files table on the given volume
 * @apiSince 11
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for a single row in the files table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @param rowId the file to get the URI for
 * @return the URI to the files table on the given volume
 * @apiSince 11
 */

public static android.net.Uri getContentUri(java.lang.String volumeName, long rowId) { throw new RuntimeException("Stub!"); }
/**
 * File metadata columns.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface FileColumns extends android.provider.MediaStore.MediaColumns {

/**
 * The media type (audio, video, image or playlist)
 * of the file, or 0 for not a media file
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 11
 */

public static final java.lang.String MEDIA_TYPE = "media_type";

/**
 * Constant for the {@link #MEDIA_TYPE} column indicating that file is an audio file.
 * @apiSince 11
 */

public static final int MEDIA_TYPE_AUDIO = 2; // 0x2

/**
 * Constant for the {@link #MEDIA_TYPE} column indicating that file is an image file.
 * @apiSince 11
 */

public static final int MEDIA_TYPE_IMAGE = 1; // 0x1

/**
 * Constant for the {@link #MEDIA_TYPE} column indicating that file
 * is not an audio, image, video or playlist file.
 * @apiSince 11
 */

public static final int MEDIA_TYPE_NONE = 0; // 0x0

/**
 * Constant for the {@link #MEDIA_TYPE} column indicating that file is a playlist file.
 * @apiSince 11
 */

public static final int MEDIA_TYPE_PLAYLIST = 4; // 0x4

/**
 * Constant for the {@link #MEDIA_TYPE} column indicating that file is a video file.
 * @apiSince 11
 */

public static final int MEDIA_TYPE_VIDEO = 3; // 0x3

/**
 * The MIME type of the media item.
 * <p>
 * This is typically defined based on the file extension of the media
 * item. However, it may be the value of the {@code format} attribute
 * defined by the <em>Dublin Core Media Initiative</em> standard,
 * extracted from any XMP metadata contained within this media item.
 * <p class="note">
 * Note: the {@code format} attribute may be ignored if the top-level
 * MIME type disagrees with the file extension. For example, it's
 * reasonable for an {@code image/jpeg} file to declare a {@code format}
 * of {@code image/vnd.google.panorama360+jpg}, but declaring a
 * {@code format} of {@code audio/ogg} would be ignored.
 * <p>
 * This is a read-only column that is automatically computed.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @apiSince 11
 */

public static final java.lang.String MIME_TYPE = "mime_type";

/**
 * The index of the parent directory of the file
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 11
 */

public static final java.lang.String PARENT = "parent";

/**
 * The title of the media item.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 11
 */

public static final java.lang.String TITLE = "title";
}

}

/**
 * Collection of all media with MIME type of {@code image/*}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Images {

public Images() { throw new RuntimeException("Stub!"); }
/**
 * Image metadata columns.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ImageColumns extends android.provider.MediaStore.MediaColumns {

/**
 * The description of the image
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String DESCRIPTION = "description";

/**
 * Whether the video should be published as public or private
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 1
 */

public static final java.lang.String IS_PRIVATE = "isprivate";

/**
 * The latitude where the image was captured.
 *
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_FLOAT Cursor#FIELD_TYPE_FLOAT} , and are read-only and cannot be mutated.
 * @deprecated location details are no longer indexed for privacy
 *             reasons, and this value is now always {@code null}.
 *             You can still manually obtain location metadata using
 *             {@link android.media.ExifInterface#getLatLong(float[]) ExifInterface#getLatLong(float[])}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String LATITUDE = "latitude";

/**
 * The longitude where the image was captured.
 *
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_FLOAT Cursor#FIELD_TYPE_FLOAT} , and are read-only and cannot be mutated.
 * @deprecated location details are no longer indexed for privacy
 *             reasons, and this value is now always {@code null}.
 *             You can still manually obtain location metadata using
 *             {@link android.media.ExifInterface#getLatLong(float[]) ExifInterface#getLatLong(float[])}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String LONGITUDE = "longitude";

/**
 * The mini thumb id.
 *
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @deprecated all thumbnails should be obtained via
 *             {@link android.provider.MediaStore.Images.Thumbnails#getThumbnail MediaStore.Images.Thumbnails#getThumbnail}, as this
 *             value is no longer supported.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String MINI_THUMB_MAGIC = "mini_thumb_magic";

/**
 * The picasa id of the image
 *
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @deprecated this value was only relevant for images hosted on
 *             Picasa, which are no longer supported.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String PICASA_ID = "picasa_id";
}

/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Media implements android.provider.MediaStore.Images.ImageColumns {

public Media() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated all queries should be performed through
 *             {@link android.content.ContentResolver ContentResolver} directly, which offers modern
 *             features like {@link android.os.CancellationSignal CancellationSignal}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static android.database.Cursor query(android.content.ContentResolver cr, android.net.Uri uri, java.lang.String[] projection) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated all queries should be performed through
 *             {@link android.content.ContentResolver ContentResolver} directly, which offers modern
 *             features like {@link android.os.CancellationSignal CancellationSignal}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static android.database.Cursor query(android.content.ContentResolver cr, android.net.Uri uri, java.lang.String[] projection, java.lang.String where, java.lang.String orderBy) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated all queries should be performed through
 *             {@link android.content.ContentResolver ContentResolver} directly, which offers modern
 *             features like {@link android.os.CancellationSignal CancellationSignal}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static android.database.Cursor query(android.content.ContentResolver cr, android.net.Uri uri, java.lang.String[] projection, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String orderBy) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves an image for the given url as a {@link android.graphics.Bitmap Bitmap}.
 *
 * @param cr The content resolver to use
 * @param url The url of the image
 * @deprecated loading of images should be performed through
 *             {@link android.graphics.ImageDecoder#createSource(android.content.ContentResolver,android.net.Uri) ImageDecoder#createSource(ContentResolver, Uri)},
 *             which offers modern features like
 *             {@link android.graphics.PostProcessor PostProcessor}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static android.graphics.Bitmap getBitmap(android.content.ContentResolver cr, android.net.Uri url) throws java.io.FileNotFoundException, java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Insert an image and create a thumbnail for it.
 *
 * @param cr The content resolver to use
 * @param imagePath The path to the image to insert
 * @param name The name of the image
 * @param description The description of the image
 * @return The URL to the newly created image
 * @deprecated inserting of images should be performed using
 *             {@link android.provider.MediaStore.MediaColumns#IS_PENDING MediaColumns#IS_PENDING}, which offers richer
 *             control over lifecycle.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static java.lang.String insertImage(android.content.ContentResolver cr, java.lang.String imagePath, java.lang.String name, java.lang.String description) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Insert an image and create a thumbnail for it.
 *
 * @param cr The content resolver to use
 * @param source The stream to use for the image
 * @param title The name of the image
 * @param description The description of the image
 * @return The URL to the newly created image, or <code>null</code> if the image failed to be stored
 *              for any reason.
 * @deprecated inserting of images should be performed using
 *             {@link android.provider.MediaStore.MediaColumns#IS_PENDING MediaColumns#IS_PENDING}, which offers richer
 *             control over lifecycle.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static java.lang.String insertImage(android.content.ContentResolver cr, android.graphics.Bitmap source, java.lang.String title, java.lang.String description) { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the image media table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the image media table on the given volume
 * @apiSince 1
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type of of this directory of
 * images.  Note that each entry in this directory will have a standard
 * image MIME type as appropriate -- for example, image/jpeg.
 * @apiSince 1
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/image";

/**
 * The default sort order for this table
 * @apiSince 1
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "bucket_display_name";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 * @apiSince 1
 */

public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * The content:// style URI for the internal storage.
 * @apiSince 1
 */

public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }
}

/**
 * This class provides utility methods to obtain thumbnails for various
 * {@link android.provider.MediaStore.Images Images} items.
 *
 * @deprecated Callers should migrate to using
 *             {@link android.content.ContentResolver#loadThumbnail ContentResolver#loadThumbnail}, since it offers
 *             richer control over requested thumbnail sizes and
 *             cancellation behavior.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class Thumbnails implements android.provider.BaseColumns {

@Deprecated
public Thumbnails() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated all queries should be performed through
 *             {@link android.content.ContentResolver ContentResolver} directly, which offers modern
 *             features like {@link android.os.CancellationSignal CancellationSignal}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static final android.database.Cursor query(android.content.ContentResolver cr, android.net.Uri uri, java.lang.String[] projection) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated all queries should be performed through
 *             {@link android.content.ContentResolver ContentResolver} directly, which offers modern
 *             features like {@link android.os.CancellationSignal CancellationSignal}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static final android.database.Cursor queryMiniThumbnails(android.content.ContentResolver cr, android.net.Uri uri, int kind, java.lang.String[] projection) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated all queries should be performed through
 *             {@link android.content.ContentResolver ContentResolver} directly, which offers modern
 *             features like {@link android.os.CancellationSignal CancellationSignal}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static final android.database.Cursor queryMiniThumbnail(android.content.ContentResolver cr, long origId, int kind, java.lang.String[] projection) { throw new RuntimeException("Stub!"); }

/**
 * Cancel any outstanding {@link #getThumbnail} requests, causing
 * them to return by throwing a {@link android.os.OperationCanceledException OperationCanceledException}.
 * <p>
 * This method has no effect on
 * {@link android.content.ContentResolver#loadThumbnail ContentResolver#loadThumbnail} calls, since they provide
 * their own {@link android.os.CancellationSignal CancellationSignal}.
 *
 * @deprecated Callers should migrate to using
 *             {@link android.content.ContentResolver#loadThumbnail ContentResolver#loadThumbnail}, since it
 *             offers richer control over requested thumbnail sizes
 *             and cancellation behavior.
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated
public static void cancelThumbnailRequest(android.content.ContentResolver cr, long origId) { throw new RuntimeException("Stub!"); }

/**
 * Return thumbnail representing a specific image item. If a
 * thumbnail doesn't exist, this method will block until it's
 * generated. Callers are responsible for their own in-memory
 * caching of returned values.
 *
 * @param imageId the image item to obtain a thumbnail for.
 * @param kind optimal thumbnail size desired.
 * @return decoded thumbnail, or {@code null} if problem was
 *         encountered.
 * @deprecated Callers should migrate to using
 *             {@link android.content.ContentResolver#loadThumbnail ContentResolver#loadThumbnail}, since it
 *             offers richer control over requested thumbnail sizes
 *             and cancellation behavior.
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated
public static android.graphics.Bitmap getThumbnail(android.content.ContentResolver cr, long imageId, int kind, android.graphics.BitmapFactory.Options options) { throw new RuntimeException("Stub!"); }

/**
 * Cancel any outstanding {@link #getThumbnail} requests, causing
 * them to return by throwing a {@link android.os.OperationCanceledException OperationCanceledException}.
 * <p>
 * This method has no effect on
 * {@link android.content.ContentResolver#loadThumbnail ContentResolver#loadThumbnail} calls, since they provide
 * their own {@link android.os.CancellationSignal CancellationSignal}.
 *
 * @deprecated Callers should migrate to using
 *             {@link android.content.ContentResolver#loadThumbnail ContentResolver#loadThumbnail}, since it
 *             offers richer control over requested thumbnail sizes
 *             and cancellation behavior.
 * @apiSince 8
 * @deprecatedSince 29
 */

@Deprecated
public static void cancelThumbnailRequest(android.content.ContentResolver cr, long origId, long groupId) { throw new RuntimeException("Stub!"); }

/**
 * Return thumbnail representing a specific image item. If a
 * thumbnail doesn't exist, this method will block until it's
 * generated. Callers are responsible for their own in-memory
 * caching of returned values.
 *
 * @param imageId the image item to obtain a thumbnail for.
 * @param kind optimal thumbnail size desired.
 * @return decoded thumbnail, or {@code null} if problem was
 *         encountered.
 * @deprecated Callers should migrate to using
 *             {@link android.content.ContentResolver#loadThumbnail ContentResolver#loadThumbnail}, since it
 *             offers richer control over requested thumbnail sizes
 *             and cancellation behavior.
 * @apiSince 8
 * @deprecatedSince 29
 */

@Deprecated
public static android.graphics.Bitmap getThumbnail(android.content.ContentResolver cr, long imageId, long groupId, int kind, android.graphics.BitmapFactory.Options options) { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the image media table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the image media table on the given volume
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * Path to the thumbnail file on disk.
 * <p>
 * Note that apps may not have filesystem permissions to directly
 * access this path. Instead of trying to open this path directly,
 * apps should use
 * {@link android.content.ContentResolver#openFileDescriptor(android.net.Uri,java.lang.String) ContentResolver#openFileDescriptor(Uri, String)} to gain
 * access.
 *
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @deprecated Apps may not have filesystem permissions to directly
 *             access this path. Instead of trying to open this path
 *             directly, apps should use
 *             {@link android.content.ContentResolver#loadThumbnail ContentResolver#loadThumbnail}
 *             to gain access.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String DATA = "_data";

/**
 * The default sort order for this table
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String DEFAULT_SORT_ORDER = "image_id ASC";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int FULL_SCREEN_KIND = 2; // 0x2

/**
 * The height of the thumbnail
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String HEIGHT = "height";

/**
 * The original image for the thumbnal
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String IMAGE_ID = "image_id";

/**
 * The content:// style URI for the internal storage.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }

/**
 * The kind of the thumbnail
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String KIND = "kind";

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int MICRO_KIND = 3; // 0x3

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int MINI_KIND = 1; // 0x1

/**
 * The blob raw data of thumbnail
 *
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_BLOB Cursor#FIELD_TYPE_BLOB} .
 * @deprecated this column never existed internally, and could never
 *             have returned valid data.
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String THUMB_DATA = "thumb_data";

/**
 * The width of the thumbnal
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String WIDTH = "width";
}

}

/**
 * Common media metadata columns.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface MediaColumns extends android.provider.BaseColumns {

/**
 * The primary bucket display name of this media item. This can be
 * useful to present the user a first-level clustering of related
 * media items. This is a read-only column that is automatically
 * computed.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 29
 */

public static final java.lang.String BUCKET_DISPLAY_NAME = "bucket_display_name";

/**
 * The primary bucket ID of this media item. This can be useful to
 * present the user a first-level clustering of related media items.
 * This is a read-only column that is automatically computed.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 29
 */

public static final java.lang.String BUCKET_ID = "bucket_id";

/**
 * Absolute filesystem path to the media item on disk.
 * <p>
 * Note that apps may not have filesystem permissions to directly access
 * this path. Instead of trying to open this path directly, apps should
 * use {@link android.content.ContentResolver#openFileDescriptor(android.net.Uri,java.lang.String) ContentResolver#openFileDescriptor(Uri, String)} to gain
 * access.
 *
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @deprecated Apps may not have filesystem permissions to directly
 *             access this path. Instead of trying to open this path
 *             directly, apps should use
 *             {@link android.content.ContentResolver#openFileDescriptor(android.net.Uri,java.lang.String) ContentResolver#openFileDescriptor(Uri, String)}
 *             to gain access.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String DATA = "_data";

/**
 * The time the media item was first added.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String DATE_ADDED = "date_added";

/**
 * The time the media item should be considered expired. Typically only
 * meaningful in the context of {@link #IS_PENDING}.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 29
 */

public static final java.lang.String DATE_EXPIRES = "date_expires";

/**
 * The time the media item was last modified.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String DATE_MODIFIED = "date_modified";

/**
 * The time the media item was taken.
 
 * <br>
 * Value is a non-negative timestamp measured as the number of
 * milliseconds since 1970-01-01T00:00:00Z.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 29
 */

public static final java.lang.String DATE_TAKEN = "datetaken";

/**
 * The display name of the media item.
 * <p>
 * For example, an item stored at
 * {@code /storage/0000-0000/DCIM/Vacation/IMG1024.JPG} would have a
 * display name of {@code IMG1024.JPG}.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @apiSince 1
 */

public static final java.lang.String DISPLAY_NAME = "_display_name";

/**
 * The "document ID" GUID as defined by the <em>XMP Media
 * Management</em> standard, extracted from any XMP metadata contained
 * within this media item. The value is {@code null} when no metadata
 * was found.
 * <p>
 * Each "document ID" is created once for each new resource. Different
 * renditions of that resource are expected to have different IDs.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 29
 */

public static final java.lang.String DOCUMENT_ID = "document_id";

/**
 * The duration of the media item.
 
 * <br>
 * Value is a non-negative duration in milliseconds.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 29
 */

public static final java.lang.String DURATION = "duration";

/**
 * The height of the media item, in pixels.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 16
 */

public static final java.lang.String HEIGHT = "height";

/**
 * The "instance ID" GUID as defined by the <em>XMP Media
 * Management</em> standard, extracted from any XMP metadata contained
 * within this media item. The value is {@code null} when no metadata
 * was found.
 * <p>
 * This "instance ID" changes with each save operation of a specific
 * "document ID".
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 29
 */

public static final java.lang.String INSTANCE_ID = "instance_id";

/**
 * Flag indicating if a media item is pending, and still being inserted
 * by its owner. While this flag is set, only the owner of the item can
 * open the underlying file; requests from other apps will be rejected.
 *
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @see android.provider.MediaStore#setIncludePending(Uri)
 * @apiSince 29
 */

public static final java.lang.String IS_PENDING = "is_pending";

/**
 * The MIME type of the media item.
 * <p>
 * This is typically defined based on the file extension of the media
 * item. However, it may be the value of the {@code format} attribute
 * defined by the <em>Dublin Core Media Initiative</em> standard,
 * extracted from any XMP metadata contained within this media item.
 * <p class="note">
 * Note: the {@code format} attribute may be ignored if the top-level
 * MIME type disagrees with the file extension. For example, it's
 * reasonable for an {@code image/jpeg} file to declare a {@code format}
 * of {@code image/vnd.google.panorama360+jpg}, but declaring a
 * {@code format} of {@code audio/ogg} would be ignored.
 * <p>
 * This is a read-only column that is automatically computed.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @apiSince 1
 */

public static final java.lang.String MIME_TYPE = "mime_type";

/**
 * The orientation for the media item, expressed in degrees. For
 * example, 0, 90, 180, or 270 degrees.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 29
 */

public static final java.lang.String ORIENTATION = "orientation";

/**
 * The "original document ID" GUID as defined by the <em>XMP Media
 * Management</em> standard, extracted from any XMP metadata contained
 * within this media item.
 * <p>
 * This "original document ID" links a resource to its original source.
 * For example, when you save a PSD document as a JPEG, then convert the
 * JPEG to GIF format, the "original document ID" of both the JPEG and
 * GIF files is the "document ID" of the original PSD file.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 29
 */

public static final java.lang.String ORIGINAL_DOCUMENT_ID = "original_document_id";

/**
 * Package name that contributed this media. The value may be
 * {@code NULL} if ownership cannot be reliably determined.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 29
 */

public static final java.lang.String OWNER_PACKAGE_NAME = "owner_package_name";

/**
 * Relative path of this media item within the storage device where it
 * is persisted. For example, an item stored at
 * {@code /storage/0000-0000/DCIM/Vacation/IMG1024.JPG} would have a
 * path of {@code DCIM/Vacation/}.
 * <p>
 * This value should only be used for organizational purposes, and you
 * should not attempt to construct or access a raw filesystem path using
 * this value. If you need to open a media item, use an API like
 * {@link android.content.ContentResolver#openFileDescriptor(android.net.Uri,java.lang.String) ContentResolver#openFileDescriptor(Uri, String)}.
 * <p>
 * When this value is set to {@code NULL} during an
 * {@link android.content.ContentResolver#insert ContentResolver#insert} operation, the newly created item will
 * be placed in a relevant default location based on the type of media
 * being inserted. For example, a {@code image/jpeg} item will be placed
 * under {@link android.os.Environment#DIRECTORY_PICTURES Environment#DIRECTORY_PICTURES}.
 * <p>
 * You can modify this column during an {@link android.content.ContentResolver#update ContentResolver#update}
 * call, which will move the underlying file on disk.
 * <p>
 * In both cases above, content must be placed under a top-level
 * directory that is relevant to the media type. For example, attempting
 * to place a {@code audio/mpeg} file under
 * {@link android.os.Environment#DIRECTORY_PICTURES Environment#DIRECTORY_PICTURES} will be rejected.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @apiSince 29
 */

public static final java.lang.String RELATIVE_PATH = "relative_path";

/**
 * The size of the media item.
 
 * <br>
 * Value is a non-negative number of bytes.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String SIZE = "_size";

/**
 * The title of the media item.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String TITLE = "title";

/**
 * Volume name of the specific storage device where this media item is
 * persisted. The value is typically one of the volume names returned
 * from {@link android.provider.MediaStore#getExternalVolumeNames(android.content.Context) MediaStore#getExternalVolumeNames(Context)}.
 * <p>
 * This is a read-only column that is automatically computed.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 29
 */

public static final java.lang.String VOLUME_NAME = "volume_name";

/**
 * The width of the media item, in pixels.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 16
 */

public static final java.lang.String WIDTH = "width";
}

/**
 * Collection of all media with MIME type of {@code video/*}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Video {

public Video() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated all queries should be performed through
 *             {@link android.content.ContentResolver ContentResolver} directly, which offers modern
 *             features like {@link android.os.CancellationSignal CancellationSignal}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static android.database.Cursor query(android.content.ContentResolver cr, android.net.Uri uri, java.lang.String[] projection) { throw new RuntimeException("Stub!"); }

/**
 * The default sort order for this table.
 * @apiSince 1
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "_display_name";
/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Media implements android.provider.MediaStore.Video.VideoColumns {

public Media() { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the video media table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the video media table on the given volume
 * @apiSince 1
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type for this table.
 * @apiSince 1
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/video";

/**
 * The default sort order for this table
 * @apiSince 1
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "title";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 * @apiSince 1
 */

public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * The content:// style URI for the internal storage.
 * @apiSince 1
 */

public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }
}

/**
 * This class provides utility methods to obtain thumbnails for various
 * {@link android.provider.MediaStore.Video Video} items.
 *
 * @deprecated Callers should migrate to using
 *             {@link android.content.ContentResolver#loadThumbnail ContentResolver#loadThumbnail}, since it offers
 *             richer control over requested thumbnail sizes and
 *             cancellation behavior.
 * @apiSince 5
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class Thumbnails implements android.provider.BaseColumns {

@Deprecated
public Thumbnails() { throw new RuntimeException("Stub!"); }

/**
 * Cancel any outstanding {@link #getThumbnail} requests, causing
 * them to return by throwing a {@link android.os.OperationCanceledException OperationCanceledException}.
 * <p>
 * This method has no effect on
 * {@link android.content.ContentResolver#loadThumbnail ContentResolver#loadThumbnail} calls, since they provide
 * their own {@link android.os.CancellationSignal CancellationSignal}.
 *
 * @deprecated Callers should migrate to using
 *             {@link android.content.ContentResolver#loadThumbnail ContentResolver#loadThumbnail}, since it
 *             offers richer control over requested thumbnail sizes
 *             and cancellation behavior.
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated
public static void cancelThumbnailRequest(android.content.ContentResolver cr, long origId) { throw new RuntimeException("Stub!"); }

/**
 * Return thumbnail representing a specific video item. If a
 * thumbnail doesn't exist, this method will block until it's
 * generated. Callers are responsible for their own in-memory
 * caching of returned values.
 *
 * @param videoId the video item to obtain a thumbnail for.
 * @param kind optimal thumbnail size desired.
 * @return decoded thumbnail, or {@code null} if problem was
 *         encountered.
 * @deprecated Callers should migrate to using
 *             {@link android.content.ContentResolver#loadThumbnail ContentResolver#loadThumbnail}, since it
 *             offers richer control over requested thumbnail sizes
 *             and cancellation behavior.
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated
public static android.graphics.Bitmap getThumbnail(android.content.ContentResolver cr, long videoId, int kind, android.graphics.BitmapFactory.Options options) { throw new RuntimeException("Stub!"); }

/**
 * Cancel any outstanding {@link #getThumbnail} requests, causing
 * them to return by throwing a {@link android.os.OperationCanceledException OperationCanceledException}.
 * <p>
 * This method has no effect on
 * {@link android.content.ContentResolver#loadThumbnail ContentResolver#loadThumbnail} calls, since they provide
 * their own {@link android.os.CancellationSignal CancellationSignal}.
 *
 * @deprecated Callers should migrate to using
 *             {@link android.content.ContentResolver#loadThumbnail ContentResolver#loadThumbnail}, since it
 *             offers richer control over requested thumbnail sizes
 *             and cancellation behavior.
 * @apiSince 8
 * @deprecatedSince 29
 */

@Deprecated
public static void cancelThumbnailRequest(android.content.ContentResolver cr, long videoId, long groupId) { throw new RuntimeException("Stub!"); }

/**
 * Return thumbnail representing a specific video item. If a
 * thumbnail doesn't exist, this method will block until it's
 * generated. Callers are responsible for their own in-memory
 * caching of returned values.
 *
 * @param videoId the video item to obtain a thumbnail for.
 * @param kind optimal thumbnail size desired.
 * @return decoded thumbnail, or {@code null} if problem was
 *         encountered.
 * @deprecated Callers should migrate to using
 *             {@link android.content.ContentResolver#loadThumbnail ContentResolver#loadThumbnail}, since it
 *             offers richer control over requested thumbnail sizes
 *             and cancellation behavior.
 * @apiSince 8
 * @deprecatedSince 29
 */

@Deprecated
public static android.graphics.Bitmap getThumbnail(android.content.ContentResolver cr, long videoId, long groupId, int kind, android.graphics.BitmapFactory.Options options) { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the image media table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the image media table on the given volume
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated
public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * Path to the thumbnail file on disk.
 *
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @deprecated Apps may not have filesystem permissions to directly
 *             access this path. Instead of trying to open this path
 *             directly, apps should use
 *             {@link android.content.ContentResolver#openFileDescriptor(android.net.Uri,java.lang.String) ContentResolver#openFileDescriptor(Uri, String)}
 *             to gain access.
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String DATA = "_data";

/**
 * The default sort order for this table
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String DEFAULT_SORT_ORDER = "video_id ASC";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated public static final int FULL_SCREEN_KIND = 2; // 0x2

/**
 * The height of the thumbnail
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String HEIGHT = "height";

/**
 * The content:// style URI for the internal storage.
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }

/**
 * The kind of the thumbnail
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String KIND = "kind";

/**
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated public static final int MICRO_KIND = 3; // 0x3

/**
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated public static final int MINI_KIND = 1; // 0x1

/**
 * The original image for the thumbnal
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String VIDEO_ID = "video_id";

/**
 * The width of the thumbnal
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} , and are read-only and cannot be mutated.
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String WIDTH = "width";
}

/**
 * Video metadata columns.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface VideoColumns extends android.provider.MediaStore.MediaColumns {

/**
 * The album the video file is from, if any
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String ALBUM = "album";

/**
 * The artist who created the video file, if any
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String ARTIST = "artist";

/**
 * The position within the video item at which playback should be
 * resumed.
 
 * <br>
 * Value is a non-negative duration in milliseconds.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 3
 */

public static final java.lang.String BOOKMARK = "bookmark";

/**
 * The YouTube category of the video
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @apiSince 1
 */

public static final java.lang.String CATEGORY = "category";

/**
 * The description of the video recording
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String DESCRIPTION = "description";

/**
 * Whether the video should be published as public or private
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 1
 */

public static final java.lang.String IS_PRIVATE = "isprivate";

/**
 * The language of the video
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @apiSince 1
 */

public static final java.lang.String LANGUAGE = "language";

/**
 * The latitude where the video was captured.
 *
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_FLOAT Cursor#FIELD_TYPE_FLOAT} , and are read-only and cannot be mutated.
 * @deprecated location details are no longer indexed for privacy
 *             reasons, and this value is now always {@code null}.
 *             You can still manually obtain location metadata using
 *             {@link android.media.ExifInterface#getLatLong(float[]) ExifInterface#getLatLong(float[])}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String LATITUDE = "latitude";

/**
 * The longitude where the video was captured.
 *
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_FLOAT Cursor#FIELD_TYPE_FLOAT} , and are read-only and cannot be mutated.
 * @deprecated location details are no longer indexed for privacy
 *             reasons, and this value is now always {@code null}.
 *             You can still manually obtain location metadata using
 *             {@link android.media.ExifInterface#getLatLong(float[]) ExifInterface#getLatLong(float[])}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String LONGITUDE = "longitude";

/**
 * The mini thumb id.
 *
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @deprecated all thumbnails should be obtained via
 *             {@link android.provider.MediaStore.Images.Thumbnails#getThumbnail MediaStore.Images.Thumbnails#getThumbnail}, as this
 *             value is no longer supported.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String MINI_THUMB_MAGIC = "mini_thumb_magic";

/**
 * The resolution of the video file, formatted as "XxY"
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} , and are read-only and cannot be mutated.
 * @apiSince 1
 */

public static final java.lang.String RESOLUTION = "resolution";

/**
 * The user-added tags associated with a video
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} .
 * @apiSince 1
 */

public static final java.lang.String TAGS = "tags";
}

}

}

