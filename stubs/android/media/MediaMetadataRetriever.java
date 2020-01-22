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


package android.media;

import java.io.FileDescriptor;
import android.content.Context;
import android.net.Uri;
import android.graphics.Bitmap;

/**
 * MediaMetadataRetriever class provides a unified interface for retrieving
 * frame and meta data from an input media file.
 * @apiSince 10
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MediaMetadataRetriever implements java.lang.AutoCloseable {

/** @apiSince 10 */

public MediaMetadataRetriever() { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source (file pathname) to use. Call this
 * method before the rest of the methods in this class. This method may be
 * time-consuming.
 *
 * @param path The path of the input media file.
 * @throws java.lang.IllegalArgumentException If the path is invalid.
 * @apiSince 10
 */

public void setDataSource(java.lang.String path) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source (URI) to use. Call this
 * method before the rest of the methods in this class. This method may be
 * time-consuming.
 *
 * @param uri The URI of the input media.
 * @param headers the headers to be sent together with the request for the data
 * @throws java.lang.IllegalArgumentException If the URI is invalid.
 * @apiSince 14
 */

public void setDataSource(java.lang.String uri, java.util.Map<java.lang.String,java.lang.String> headers) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source (FileDescriptor) to use.  It is the caller's
 * responsibility to close the file descriptor. It is safe to do so as soon
 * as this call returns. Call this method before the rest of the methods in
 * this class. This method may be time-consuming.
 *
 * @param fd the FileDescriptor for the file you want to play
 * @param offset the offset into the file where the data to be played starts,
 * in bytes. It must be non-negative
 * @param length the length in bytes of the data to be played. It must be
 * non-negative.
 * @throws java.lang.IllegalArgumentException if the arguments are invalid
 * @apiSince 10
 */

public native void setDataSource(java.io.FileDescriptor fd, long offset, long length) throws java.lang.IllegalArgumentException;

/**
 * Sets the data source (FileDescriptor) to use. It is the caller's
 * responsibility to close the file descriptor. It is safe to do so as soon
 * as this call returns. Call this method before the rest of the methods in
 * this class. This method may be time-consuming.
 *
 * @param fd the FileDescriptor for the file you want to play
 * @throws java.lang.IllegalArgumentException if the FileDescriptor is invalid
 * @apiSince 10
 */

public void setDataSource(java.io.FileDescriptor fd) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source as a content Uri. Call this method before
 * the rest of the methods in this class. This method may be time-consuming.
 *
 * @param context the Context to use when resolving the Uri
 * @param uri the Content URI of the data you want to play
 * @throws java.lang.IllegalArgumentException if the Uri is invalid
 * @throws java.lang.SecurityException if the Uri cannot be used due to lack of
 * permission.
 * @apiSince 10
 */

public void setDataSource(android.content.Context context, android.net.Uri uri) throws java.lang.IllegalArgumentException, java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source (MediaDataSource) to use.
 *
 * @param dataSource the MediaDataSource for the media you want to play
 * @apiSince 23
 */

public void setDataSource(android.media.MediaDataSource dataSource) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Call this method after setDataSource(). This method retrieves the
 * meta data value associated with the keyCode.
 *
 * The keyCode currently supported is listed below as METADATA_XXX
 * constants. With any other value, it returns a null pointer.
 *
 * @param keyCode One of the constants listed below at the end of the class.
 * @return The meta data value associate with the given keyCode on success;
 * null on failure.
 * @apiSince 10
 */

public native java.lang.String extractMetadata(int keyCode);

/**
 * Call this method after setDataSource(). This method finds a
 * representative frame close to the given time position by considering
 * the given option if possible, and returns it as a bitmap.
 *
 * <p>If you don't need a full-resolution
 * frame (for example, because you need a thumbnail image), use
 * {@link #getScaledFrameAtTime getScaledFrameAtTime()} instead of this
 * method.</p>
 *
 * @param timeUs The time position where the frame will be retrieved.
 * When retrieving the frame at the given time position, there is no
 * guarantee that the data source has a frame located at the position.
 * When this happens, a frame nearby will be returned. If timeUs is
 * negative, time position and option will ignored, and any frame
 * that the implementation considers as representative may be returned.
 *
 * @param option a hint on how the frame is found. Use
 * {@link #OPTION_PREVIOUS_SYNC} if one wants to retrieve a sync frame
 * that has a timestamp earlier than or the same as timeUs. Use
 * {@link #OPTION_NEXT_SYNC} if one wants to retrieve a sync frame
 * that has a timestamp later than or the same as timeUs. Use
 * {@link #OPTION_CLOSEST_SYNC} if one wants to retrieve a sync frame
 * that has a timestamp closest to or the same as timeUs. Use
 * {@link #OPTION_CLOSEST} if one wants to retrieve a frame that may
 * or may not be a sync frame but is closest to or the same as timeUs.
 * {@link #OPTION_CLOSEST} often has larger performance overhead compared
 * to the other options if there is no sync frame located at timeUs.
 *
 * Value is either <code>0</code> or a combination of {@link android.media.MediaMetadataRetriever#OPTION_PREVIOUS_SYNC}, {@link android.media.MediaMetadataRetriever#OPTION_NEXT_SYNC}, {@link android.media.MediaMetadataRetriever#OPTION_CLOSEST_SYNC}, and {@link android.media.MediaMetadataRetriever#OPTION_CLOSEST}
 * @return A Bitmap containing a representative video frame, which
 *         can be null, if such a frame cannot be retrieved.
 * @apiSince 10
 */

public android.graphics.Bitmap getFrameAtTime(long timeUs, int option) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a video frame near a given timestamp scaled to a desired size.
 * Call this method after setDataSource(). This method finds a representative
 * frame close to the given time position by considering the given option
 * if possible, and returns it as a bitmap with same aspect ratio as the source
 * while scaling it so that it fits into the desired size of dst_width by dst_height.
 * This is useful for generating a thumbnail for an input data source or just to
 * obtain a scaled frame at the given time position.
 *
 * @param timeUs The time position in microseconds where the frame will be retrieved.
 * When retrieving the frame at the given time position, there is no
 * guarantee that the data source has a frame located at the position.
 * When this happens, a frame nearby will be returned. If timeUs is
 * negative, time position and option will ignored, and any frame
 * that the implementation considers as representative may be returned.
 *
 * @param option a hint on how the frame is found. Use
 * {@link #OPTION_PREVIOUS_SYNC} if one wants to retrieve a sync frame
 * that has a timestamp earlier than or the same as timeUs. Use
 * {@link #OPTION_NEXT_SYNC} if one wants to retrieve a sync frame
 * that has a timestamp later than or the same as timeUs. Use
 * {@link #OPTION_CLOSEST_SYNC} if one wants to retrieve a sync frame
 * that has a timestamp closest to or the same as timeUs. Use
 * {@link #OPTION_CLOSEST} if one wants to retrieve a frame that may
 * or may not be a sync frame but is closest to or the same as timeUs.
 * {@link #OPTION_CLOSEST} often has larger performance overhead compared
 * to the other options if there is no sync frame located at timeUs.
 *
 * Value is either <code>0</code> or a combination of {@link android.media.MediaMetadataRetriever#OPTION_PREVIOUS_SYNC}, {@link android.media.MediaMetadataRetriever#OPTION_NEXT_SYNC}, {@link android.media.MediaMetadataRetriever#OPTION_CLOSEST_SYNC}, and {@link android.media.MediaMetadataRetriever#OPTION_CLOSEST}
 * @param dstWidth expected output bitmap width
 * @param dstHeight expected output bitmap height
 * @return A Bitmap of size not larger than dstWidth by dstHeight containing a
 *         scaled video frame, which can be null, if such a frame cannot be retrieved.
 * @throws java.lang.IllegalArgumentException if passed in invalid option or width by height
 *         is less than or equal to 0.
 * @apiSince 27
 */

public android.graphics.Bitmap getScaledFrameAtTime(long timeUs, int option, int dstWidth, int dstHeight) { throw new RuntimeException("Stub!"); }

/**
 * Call this method after setDataSource(). This method finds a
 * representative frame close to the given time position if possible,
 * and returns it as a bitmap. Call this method if one does not care
 * how the frame is found as long as it is close to the given time;
 * otherwise, please call {@link #getFrameAtTime(long,int)}.
 *
 * <p>If you don't need a full-resolution
 * frame (for example, because you need a thumbnail image), use
 * {@link #getScaledFrameAtTime getScaledFrameAtTime()} instead of this
 * method.</p>
 *
 * @param timeUs The time position where the frame will be retrieved.
 * When retrieving the frame at the given time position, there is no
 * guarentee that the data source has a frame located at the position.
 * When this happens, a frame nearby will be returned. If timeUs is
 * negative, time position and option will ignored, and any frame
 * that the implementation considers as representative may be returned.
 *
 * @return A Bitmap of size dst_widthxdst_height containing a representative
 *         video frame, which can be null, if such a frame cannot be retrieved.
 *
 * @see #getFrameAtTime(long, int)
 * @apiSince 10
 */

public android.graphics.Bitmap getFrameAtTime(long timeUs) { throw new RuntimeException("Stub!"); }

/**
 * Call this method after setDataSource(). This method finds a
 * representative frame at any time position if possible,
 * and returns it as a bitmap. Call this method if one does not
 * care about where the frame is located; otherwise, please call
 * {@link #getFrameAtTime(long)} or {@link #getFrameAtTime(long,int)}
 *
 * <p>If you don't need a full-resolution
 * frame (for example, because you need a thumbnail image), use
 * {@link #getScaledFrameAtTime getScaledFrameAtTime()} instead of this
 * method.</p>
 *
 * @return A Bitmap containing a representative video frame, which
 *         can be null, if such a frame cannot be retrieved.
 *
 * @see #getFrameAtTime(long)
 * @see #getFrameAtTime(long, int)
 * @apiSince 10
 */

public android.graphics.Bitmap getFrameAtTime() { throw new RuntimeException("Stub!"); }

/**
 * This method retrieves a video frame by its index. It should only be called
 * after {@link #setDataSource}.
 *
 * After the bitmap is returned, you can query the actual parameters that were
 * used to create the bitmap from the {@code BitmapParams} argument, for instance
 * to query the bitmap config used for the bitmap with {@link android.media.MediaMetadataRetriever.BitmapParams#getActualConfig BitmapParams#getActualConfig}.
 *
 * @param frameIndex 0-based index of the video frame. The frame index must be that of
 *        a valid frame. The total number of frames available for retrieval can be queried
 *        via the {@link #METADATA_KEY_VIDEO_FRAME_COUNT} key.
 * @param params BitmapParams that controls the returned bitmap config (such as pixel formats).
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if the container doesn't contain video or image sequences.
 * @throws java.lang.IllegalArgumentException if the requested frame index does not exist.
 *
 * @return A Bitmap containing the requested video frame, or null if the retrieval fails.
 *
 * @see #getFrameAtIndex(int)
 * @see #getFramesAtIndex(int, int, BitmapParams)
 * @see #getFramesAtIndex(int, int)
 * @apiSince 28
 */

public android.graphics.Bitmap getFrameAtIndex(int frameIndex, @androidx.annotation.NonNull android.media.MediaMetadataRetriever.BitmapParams params) { throw new RuntimeException("Stub!"); }

/**
 * This method is similar to {@link #getFrameAtIndex(int,android.media.MediaMetadataRetriever.BitmapParams)} except that
 * the default for {@link android.media.MediaMetadataRetriever.BitmapParams BitmapParams} will be used.
 *
 * @param frameIndex 0-based index of the video frame. The frame index must be that of
 *        a valid frame. The total number of frames available for retrieval can be queried
 *        via the {@link #METADATA_KEY_VIDEO_FRAME_COUNT} key.
 *
 * @throws java.lang.IllegalStateException if the container doesn't contain video or image sequences.
 * @throws java.lang.IllegalArgumentException if the requested frame index does not exist.
 *
 * @return A Bitmap containing the requested video frame, or null if the retrieval fails.
 *
 * @see #getFrameAtIndex(int, BitmapParams)
 * @see #getFramesAtIndex(int, int, BitmapParams)
 * @see #getFramesAtIndex(int, int)
 * @apiSince 28
 */

public android.graphics.Bitmap getFrameAtIndex(int frameIndex) { throw new RuntimeException("Stub!"); }

/**
 * This method retrieves a consecutive set of video frames starting at the
 * specified index. It should only be called after {@link #setDataSource}.
 *
 * If the caller intends to retrieve more than one consecutive video frames,
 * this method is preferred over {@link #getFrameAtIndex(int,android.media.MediaMetadataRetriever.BitmapParams)} for efficiency.
 *
 * After the bitmaps are returned, you can query the actual parameters that were
 * used to create the bitmaps from the {@code BitmapParams} argument, for instance
 * to query the bitmap config used for the bitmaps with {@link android.media.MediaMetadataRetriever.BitmapParams#getActualConfig BitmapParams#getActualConfig}.
 *
 * @param frameIndex 0-based index of the first video frame to retrieve. The frame index
 *        must be that of a valid frame. The total number of frames available for retrieval
 *        can be queried via the {@link #METADATA_KEY_VIDEO_FRAME_COUNT} key.
 * @param numFrames number of consecutive video frames to retrieve. Must be a positive
 *        value. The stream must contain at least numFrames frames starting at frameIndex.
 * @param params BitmapParams that controls the returned bitmap config (such as pixel formats).
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if the container doesn't contain video or image sequences.
 * @throws java.lang.IllegalArgumentException if the frameIndex or numFrames is invalid, or the
 *         stream doesn't contain at least numFrames starting at frameIndex.
 
 * @return An list of Bitmaps containing the requested video frames. The returned
 *         array could contain less frames than requested if the retrieval fails.
 *
 * This value will never be {@code null}.
 * @see #getFrameAtIndex(int, BitmapParams)
 * @see #getFrameAtIndex(int)
 * @see #getFramesAtIndex(int, int)
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.List<android.graphics.Bitmap> getFramesAtIndex(int frameIndex, int numFrames, @androidx.annotation.NonNull android.media.MediaMetadataRetriever.BitmapParams params) { throw new RuntimeException("Stub!"); }

/**
 * This method is similar to {@link #getFramesAtIndex(int,int,android.media.MediaMetadataRetriever.BitmapParams)} except that
 * the default for {@link android.media.MediaMetadataRetriever.BitmapParams BitmapParams} will be used.
 *
 * @param frameIndex 0-based index of the first video frame to retrieve. The frame index
 *        must be that of a valid frame. The total number of frames available for retrieval
 *        can be queried via the {@link #METADATA_KEY_VIDEO_FRAME_COUNT} key.
 * @param numFrames number of consecutive video frames to retrieve. Must be a positive
 *        value. The stream must contain at least numFrames frames starting at frameIndex.
 *
 * @throws java.lang.IllegalStateException if the container doesn't contain video or image sequences.
 * @throws java.lang.IllegalArgumentException if the frameIndex or numFrames is invalid, or the
 *         stream doesn't contain at least numFrames starting at frameIndex.
 
 * @return An list of Bitmaps containing the requested video frames. The returned
 *         array could contain less frames than requested if the retrieval fails.
 *
 * This value will never be {@code null}.
 * @see #getFrameAtIndex(int, BitmapParams)
 * @see #getFrameAtIndex(int)
 * @see #getFramesAtIndex(int, int, BitmapParams)
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.List<android.graphics.Bitmap> getFramesAtIndex(int frameIndex, int numFrames) { throw new RuntimeException("Stub!"); }

/**
 * This method retrieves a still image by its index. It should only be called
 * after {@link #setDataSource}.
 *
 * After the bitmap is returned, you can query the actual parameters that were
 * used to create the bitmap from the {@code BitmapParams} argument, for instance
 * to query the bitmap config used for the bitmap with {@link android.media.MediaMetadataRetriever.BitmapParams#getActualConfig BitmapParams#getActualConfig}.
 *
 * @param imageIndex 0-based index of the image.
 * @param params BitmapParams that controls the returned bitmap config (such as pixel formats).
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if the container doesn't contain still images.
 * @throws java.lang.IllegalArgumentException if the requested image does not exist.
 *
 * @return the requested still image, or null if the image cannot be retrieved.
 *
 * @see #getImageAtIndex(int)
 * @see #getPrimaryImage(BitmapParams)
 * @see #getPrimaryImage()
 * @apiSince 28
 */

public android.graphics.Bitmap getImageAtIndex(int imageIndex, @androidx.annotation.NonNull android.media.MediaMetadataRetriever.BitmapParams params) { throw new RuntimeException("Stub!"); }

/**
 * This method is similar to {@link #getImageAtIndex(int,android.media.MediaMetadataRetriever.BitmapParams)} except that
 * the default for {@link android.media.MediaMetadataRetriever.BitmapParams BitmapParams} will be used.
 *
 * @param imageIndex 0-based index of the image.
 *
 * @throws java.lang.IllegalStateException if the container doesn't contain still images.
 * @throws java.lang.IllegalArgumentException if the requested image does not exist.
 *
 * @return the requested still image, or null if the image cannot be retrieved.
 *
 * @see #getImageAtIndex(int, BitmapParams)
 * @see #getPrimaryImage(BitmapParams)
 * @see #getPrimaryImage()
 * @apiSince 28
 */

public android.graphics.Bitmap getImageAtIndex(int imageIndex) { throw new RuntimeException("Stub!"); }

/**
 * This method retrieves the primary image of the media content. It should only
 * be called after {@link #setDataSource}.
 *
 * After the bitmap is returned, you can query the actual parameters that were
 * used to create the bitmap from the {@code BitmapParams} argument, for instance
 * to query the bitmap config used for the bitmap with {@link android.media.MediaMetadataRetriever.BitmapParams#getActualConfig BitmapParams#getActualConfig}.
 *
 * @param params BitmapParams that controls the returned bitmap config (such as pixel formats).
 *
 * This value must never be {@code null}.
 * @return the primary image, or null if it cannot be retrieved.
 *
 * @throws java.lang.IllegalStateException if the container doesn't contain still images.
 *
 * @see #getImageAtIndex(int, BitmapParams)
 * @see #getImageAtIndex(int)
 * @see #getPrimaryImage()
 * @apiSince 28
 */

public android.graphics.Bitmap getPrimaryImage(@androidx.annotation.NonNull android.media.MediaMetadataRetriever.BitmapParams params) { throw new RuntimeException("Stub!"); }

/**
 * This method is similar to {@link #getPrimaryImage(android.media.MediaMetadataRetriever.BitmapParams)} except that
 * the default for {@link android.media.MediaMetadataRetriever.BitmapParams BitmapParams} will be used.
 *
 * @return the primary image, or null if it cannot be retrieved.
 *
 * @throws java.lang.IllegalStateException if the container doesn't contain still images.
 *
 * @see #getImageAtIndex(int, BitmapParams)
 * @see #getImageAtIndex(int)
 * @see #getPrimaryImage(BitmapParams)
 * @apiSince 28
 */

public android.graphics.Bitmap getPrimaryImage() { throw new RuntimeException("Stub!"); }

/**
 * Call this method after setDataSource(). This method finds the optional
 * graphic or album/cover art associated associated with the data source. If
 * there are more than one pictures, (any) one of them is returned.
 *
 * @return null if no such graphic is found.
 * @apiSince 10
 */

public byte[] getEmbeddedPicture() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Call it when one is done with the object. This method releases the memory
 * allocated internally.
 * @apiSince 10
 */

public native void release();

/** @apiSince 10 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * The metadata key to retrieve the information about the album title
 * of the data source.
 * @apiSince 10
 */

public static final int METADATA_KEY_ALBUM = 1; // 0x1

/**
 * The metadata key to retrieve the information about the performers or
 * artist associated with the data source.
 * @apiSince 10
 */

public static final int METADATA_KEY_ALBUMARTIST = 13; // 0xd

/**
 * The metadata key to retrieve the information about the artist of
 * the data source.
 * @apiSince 10
 */

public static final int METADATA_KEY_ARTIST = 2; // 0x2

/**
 * The metadata key to retrieve the information about the author of
 * the data source.
 * @apiSince 10
 */

public static final int METADATA_KEY_AUTHOR = 3; // 0x3

/**
 * This key retrieves the average bitrate (in bits/sec), if available.
 * @apiSince 14
 */

public static final int METADATA_KEY_BITRATE = 20; // 0x14

/**
 * This key retrieves the original capture framerate, if it's
 * available. The capture framerate will be a floating point
 * number.
 * @apiSince 23
 */

public static final int METADATA_KEY_CAPTURE_FRAMERATE = 25; // 0x19

/**
 * The metadata key to retrieve the numeric string describing the
 * order of the audio data source on its original recording.
 * @apiSince 10
 */

public static final int METADATA_KEY_CD_TRACK_NUMBER = 0; // 0x0

/**
 * The metadata key to retrieve the music album compilation status.
 * @apiSince 10
 */

public static final int METADATA_KEY_COMPILATION = 15; // 0xf

/**
 * The metadata key to retrieve the information about the composer of
 * the data source.
 * @apiSince 10
 */

public static final int METADATA_KEY_COMPOSER = 4; // 0x4

/**
 * The metadata key to retrieve the date when the data source was created
 * or modified.
 * @apiSince 10
 */

public static final int METADATA_KEY_DATE = 5; // 0x5

/**
 * The metadata key to retrieve the numberic string that describes which
 * part of a set the audio data source comes from.
 * @apiSince 10
 */

public static final int METADATA_KEY_DISC_NUMBER = 14; // 0xe

/**
 * The metadata key to retrieve the playback duration of the data source.
 * @apiSince 10
 */

public static final int METADATA_KEY_DURATION = 9; // 0x9

/**
 * If the media contains EXIF data, this key retrieves the length of the
 * data.
 * @apiSince 29
 */

public static final int METADATA_KEY_EXIF_LENGTH = 34; // 0x22

/**
 * If the media contains EXIF data, this key retrieves the offset value
 * of the data.
 * @apiSince 29
 */

public static final int METADATA_KEY_EXIF_OFFSET = 33; // 0x21

/**
 * The metadata key to retrieve the content type or genre of the data
 * source.
 * @apiSince 10
 */

public static final int METADATA_KEY_GENRE = 6; // 0x6

/**
 * If this key exists the media contains audio content.
 * @apiSince 14
 */

public static final int METADATA_KEY_HAS_AUDIO = 16; // 0x10

/**
 * If this key exists the media contains still image content.
 * @apiSince 28
 */

public static final int METADATA_KEY_HAS_IMAGE = 26; // 0x1a

/**
 * If this key exists the media contains video content.
 * @apiSince 14
 */

public static final int METADATA_KEY_HAS_VIDEO = 17; // 0x11

/**
 * If the media contains still images, this key retrieves the number
 * of still images.
 * @apiSince 28
 */

public static final int METADATA_KEY_IMAGE_COUNT = 27; // 0x1b

/**
 * If the media contains still images, this key retrieves the height
 * of the primary image.
 * @apiSince 28
 */

public static final int METADATA_KEY_IMAGE_HEIGHT = 30; // 0x1e

/**
 * If the media contains still images, this key retrieves the image
 * index of the primary image.
 * @apiSince 28
 */

public static final int METADATA_KEY_IMAGE_PRIMARY = 28; // 0x1c

/**
 * If the media contains still images, this key retrieves the rotation
 * angle (in degrees clockwise) of the primary image. The image rotation
 * angle must be one of 0, 90, 180, or 270 degrees.
 * @apiSince 28
 */

public static final int METADATA_KEY_IMAGE_ROTATION = 31; // 0x1f

/**
 * If the media contains still images, this key retrieves the width
 * of the primary image.
 * @apiSince 28
 */

public static final int METADATA_KEY_IMAGE_WIDTH = 29; // 0x1d

/**
 * This key retrieves the location information, if available.
 * The location should be specified according to ISO-6709 standard, under
 * a mp4/3gp box "@xyz". Location with longitude of -90 degrees and latitude
 * of 180 degrees will be retrieved as "+180.0000-90.0000/", for instance.
 * @apiSince 15
 */

public static final int METADATA_KEY_LOCATION = 23; // 0x17

/**
 * The metadata key to retrieve the mime type of the data source. Some
 * example mime types include: "video/mp4", "audio/mp4", "audio/amr-wb",
 * etc.
 * @apiSince 10
 */

public static final int METADATA_KEY_MIMETYPE = 12; // 0xc

/**
 * The metadata key to retrieve the number of tracks, such as audio, video,
 * text, in the data source, such as a mp4 or 3gpp file.
 * @apiSince 10
 */

public static final int METADATA_KEY_NUM_TRACKS = 10; // 0xa

/**
 * The metadata key to retrieve the data source title.
 * @apiSince 10
 */

public static final int METADATA_KEY_TITLE = 7; // 0x7

/**
 * If the media contains video and this key exists, it retrieves the
 * total number of frames in the video sequence.
 * @apiSince 28
 */

public static final int METADATA_KEY_VIDEO_FRAME_COUNT = 32; // 0x20

/**
 * If the media contains video, this key retrieves its height.
 * @apiSince 14
 */

public static final int METADATA_KEY_VIDEO_HEIGHT = 19; // 0x13

/**
 * This key retrieves the video rotation angle in degrees, if available.
 * The video rotation angle may be 0, 90, 180, or 270 degrees.
 * @apiSince 17
 */

public static final int METADATA_KEY_VIDEO_ROTATION = 24; // 0x18

/**
 * If the media contains video, this key retrieves its width.
 * @apiSince 14
 */

public static final int METADATA_KEY_VIDEO_WIDTH = 18; // 0x12

/**
 * The metadata key to retrieve the information of the writer (such as
 * lyricist) of the data source.
 * @apiSince 10
 */

public static final int METADATA_KEY_WRITER = 11; // 0xb

/**
 * The metadata key to retrieve the year when the data source was created
 * or modified.
 * @apiSince 10
 */

public static final int METADATA_KEY_YEAR = 8; // 0x8

/**
 * This option is used with {@link #getFrameAtTime(long,int)} to retrieve
 * a frame (not necessarily a key frame) associated with a data source that
 * is located closest to or at the given time.
 *
 * @see #getFrameAtTime(long, int)
 * @apiSince 10
 */

public static final int OPTION_CLOSEST = 3; // 0x3

/**
 * This option is used with {@link #getFrameAtTime(long,int)} to retrieve
 * a sync (or key) frame associated with a data source that is located
 * closest to (in time) or at the given time.
 *
 * @see #getFrameAtTime(long, int)
 * @apiSince 10
 */

public static final int OPTION_CLOSEST_SYNC = 2; // 0x2

/**
 * This option is used with {@link #getFrameAtTime(long,int)} to retrieve
 * a sync (or key) frame associated with a data source that is located
 * right after or at the given time.
 *
 * @see #getFrameAtTime(long, int)
 * @apiSince 10
 */

public static final int OPTION_NEXT_SYNC = 1; // 0x1

/**
 * This option is used with {@link #getFrameAtTime(long,int)} to retrieve
 * a sync (or key) frame associated with a data source that is located
 * right before or at the given time.
 *
 * @see #getFrameAtTime(long, int)
 * @apiSince 10
 */

public static final int OPTION_PREVIOUS_SYNC = 0; // 0x0
/** @apiSince 28 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class BitmapParams {

/**
 * Create a default BitmapParams object. By default, it uses {@link android.graphics.Bitmap.Config#ARGB_8888 Bitmap.Config#ARGB_8888}
 * as the preferred bitmap config.
 * @apiSince 28
 */

public BitmapParams() { throw new RuntimeException("Stub!"); }

/**
 * Set the preferred bitmap config for the decoder to decode into.
 *
 * If not set, or the request cannot be met, the decoder will output
 * in {@link android.graphics.Bitmap.Config#ARGB_8888 Bitmap.Config#ARGB_8888} config by default.
 *
 * After decode, the actual config used can be retrieved by {@link #getActualConfig()}.
 *
 * @param config the preferred bitmap config to use.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void setPreferredConfig(@androidx.annotation.NonNull android.graphics.Bitmap.Config config) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the preferred bitmap config in the params.
 *
 * @return the preferred bitmap config.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.graphics.Bitmap.Config getPreferredConfig() { throw new RuntimeException("Stub!"); }

/**
 * Get the actual bitmap config used to decode the bitmap after the decoding.
 *
 * @return the actual bitmap config used.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.graphics.Bitmap.Config getActualConfig() { throw new RuntimeException("Stub!"); }
}

}

