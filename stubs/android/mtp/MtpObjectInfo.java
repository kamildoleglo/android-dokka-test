/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.mtp;


/**
 * This class encapsulates information about an object on an MTP device.
 * This corresponds to the ObjectInfo Dataset described in
 * section 5.3.1 of the MTP specification.
 * @apiSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MtpObjectInfo {

private MtpObjectInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the object handle for the MTP object
 *
 * @return the object handle
 * @apiSince 12
 */

public int getObjectHandle() { throw new RuntimeException("Stub!"); }

/**
 * Returns the storage ID for the MTP object's storage unit
 *
 * @return the storage ID
 * @apiSince 12
 */

public int getStorageId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the format code for the MTP object
 *
 * @return the format code
 * @apiSince 12
 */

public int getFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns the protection status for the MTP object
 * Possible values are:
 *
 * <ul>
 * <li> {@link android.mtp.MtpConstants#PROTECTION_STATUS_NONE}
 * <li> {@link android.mtp.MtpConstants#PROTECTION_STATUS_READ_ONLY}
 * <li> {@link android.mtp.MtpConstants#PROTECTION_STATUS_NON_TRANSFERABLE_DATA}
 * </ul>
 *
 * @return the protection status
 * @apiSince 12
 */

public int getProtectionStatus() { throw new RuntimeException("Stub!"); }

/**
 * Returns the size of the MTP object
 *
 * @return the object size
 * @apiSince 12
 */

public int getCompressedSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the size of the MTP object
 *
 * @return the object size
 * @apiSince 24
 */

public long getCompressedSizeLong() { throw new RuntimeException("Stub!"); }

/**
 * Returns the format code for the MTP object's thumbnail
 * Will be zero for objects with no thumbnail
 *
 * @return the thumbnail format code
 * @apiSince 12
 */

public int getThumbFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns the size of the MTP object's thumbnail
 * Will be zero for objects with no thumbnail
 *
 * @return the thumbnail size
 * @apiSince 12
 */

public int getThumbCompressedSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the size of the MTP object's thumbnail
 * Will be zero for objects with no thumbnail
 *
 * @return the thumbnail size
 * @apiSince 24
 */

public long getThumbCompressedSizeLong() { throw new RuntimeException("Stub!"); }

/**
 * Returns the width of the MTP object's thumbnail in pixels
 * Will be zero for objects with no thumbnail
 *
 * @return the thumbnail width
 * @apiSince 12
 */

public int getThumbPixWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the width of the MTP object's thumbnail in pixels
 * Will be zero for objects with no thumbnail
 *
 * @return the thumbnail width
 * @apiSince 24
 */

public long getThumbPixWidthLong() { throw new RuntimeException("Stub!"); }

/**
 * Returns the height of the MTP object's thumbnail in pixels
 * Will be zero for objects with no thumbnail
 *
 * @return the thumbnail height
 * @apiSince 12
 */

public int getThumbPixHeight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the height of the MTP object's thumbnail in pixels
 * Will be zero for objects with no thumbnail
 *
 * @return the thumbnail height
 * @apiSince 24
 */

public long getThumbPixHeightLong() { throw new RuntimeException("Stub!"); }

/**
 * Returns the width of the MTP object in pixels
 * Will be zero for non-image objects
 *
 * @return the image width
 * @apiSince 12
 */

public int getImagePixWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the width of the MTP object in pixels
 * Will be zero for non-image objects
 *
 * @return the image width
 * @apiSince 24
 */

public long getImagePixWidthLong() { throw new RuntimeException("Stub!"); }

/**
 * Returns the height of the MTP object in pixels
 * Will be zero for non-image objects
 *
 * @return the image height
 * @apiSince 12
 */

public int getImagePixHeight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the height of the MTP object in pixels
 * Will be zero for non-image objects
 *
 * @return the image height
 * @apiSince 24
 */

public long getImagePixHeightLong() { throw new RuntimeException("Stub!"); }

/**
 * Returns the depth of the MTP object in bits per pixel
 * Will be zero for non-image objects
 *
 * @return the image depth
 * @apiSince 12
 */

public int getImagePixDepth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the depth of the MTP object in bits per pixel
 * Will be zero for non-image objects
 *
 * @return the image depth
 * @apiSince 24
 */

public long getImagePixDepthLong() { throw new RuntimeException("Stub!"); }

/**
 * Returns the object handle for the object's parent
 * Will be zero for the root directory of a storage unit
 *
 * @return the object's parent
 * @apiSince 12
 */

public int getParent() { throw new RuntimeException("Stub!"); }

/**
 * Returns the association type for the MTP object
 * Will be zero objects that are not of format
 * {@link android.mtp.MtpConstants#FORMAT_ASSOCIATION}
 * For directories the association type is typically
 * {@link android.mtp.MtpConstants#ASSOCIATION_TYPE_GENERIC_FOLDER}
 *
 * @return the object's association type
 * @apiSince 12
 */

public int getAssociationType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the association description for the MTP object
 * Will be zero objects that are not of format
 * {@link android.mtp.MtpConstants#FORMAT_ASSOCIATION}
 *
 * @return the object's association description
 * @apiSince 12
 */

public int getAssociationDesc() { throw new RuntimeException("Stub!"); }

/**
 * Returns the sequence number for the MTP object
 * This field is typically not used for MTP devices,
 * but is sometimes used to define a sequence of photos
 * on PTP cameras.
 *
 * @return the object's sequence number
 * @apiSince 12
 */

public int getSequenceNumber() { throw new RuntimeException("Stub!"); }

/**
 * Returns the sequence number for the MTP object
 * This field is typically not used for MTP devices,
 * but is sometimes used to define a sequence of photos
 * on PTP cameras.
 *
 * @return the object's sequence number
 * @apiSince 24
 */

public long getSequenceNumberLong() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the MTP object
 *
 * @return the object's name
 
 * This value will never be {@code null}.
 * @apiSince 12
 */

@androidx.annotation.NonNull
public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the creation date of the MTP object
 * The value is represented as milliseconds since January 1, 1970
 *
 * @return the object's creation date
 * @apiSince 12
 */

public long getDateCreated() { throw new RuntimeException("Stub!"); }

/**
 * Returns the modification date of the MTP object
 * The value is represented as milliseconds since January 1, 1970
 *
 * @return the object's modification date
 * @apiSince 12
 */

public long getDateModified() { throw new RuntimeException("Stub!"); }

/**
 * Returns a comma separated list of keywords for the MTP object
 *
 * @return the object's keyword list
 
 * This value will never be {@code null}.
 * @apiSince 12
 */

@androidx.annotation.NonNull
public java.lang.String getKeywords() { throw new RuntimeException("Stub!"); }
/**
 * Builds a new object info instance.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/** @apiSince 24 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Creates a builder on a copy of an existing object info.
 * All fields, except the object handle will be copied.
 *
 * @param objectInfo object info of an existing entry
 * @apiSince 24
 */

public Builder(android.mtp.MtpObjectInfo objectInfo) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setObjectHandle(int value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setAssociationDesc(int value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setAssociationType(int value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setCompressedSize(long value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setDateCreated(long value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setDateModified(long value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setFormat(int value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setImagePixDepth(long value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setImagePixHeight(long value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setImagePixWidth(long value) { throw new RuntimeException("Stub!"); }

/**
 * @param value This value must never be {@code null}.
 * @apiSince 24
 */

public android.mtp.MtpObjectInfo.Builder setKeywords(@androidx.annotation.NonNull java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * @param value This value must never be {@code null}.
 * @apiSince 24
 */

public android.mtp.MtpObjectInfo.Builder setName(@androidx.annotation.NonNull java.lang.String value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setParent(int value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setProtectionStatus(int value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setSequenceNumber(long value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setStorageId(int value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setThumbCompressedSize(long value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setThumbFormat(int value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setThumbPixHeight(long value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.mtp.MtpObjectInfo.Builder setThumbPixWidth(long value) { throw new RuntimeException("Stub!"); }

/**
 * Builds the object info instance. Once called, methods of the builder
 * must not be called anymore.
 *
 * @return the object info of the newly created file, or NULL in case
 *         of an error.
 * @apiSince 24
 */

public android.mtp.MtpObjectInfo build() { throw new RuntimeException("Stub!"); }
}

}

