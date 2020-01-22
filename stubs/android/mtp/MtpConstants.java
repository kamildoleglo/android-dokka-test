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
 * A class containing constants in the MTP and PTP specifications.
 * @apiSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MtpConstants {

public MtpConstants() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the object is abstract (that is, it has no representation
 * in the underlying file system).
 *
 * @param format the format of the object
 * @return true if the object is abstract
 * @apiSince 12
 */

public static boolean isAbstractObject(int format) { throw new RuntimeException("Stub!"); }

/**
 * Association type for objects representing file system directories.
 * @apiSince 12
 */

public static final int ASSOCIATION_TYPE_GENERIC_FOLDER = 1; // 0x1

/**
 * Format code for 3GP files
 * @apiSince 12
 */

public static final int FORMAT_3GP_CONTAINER = 47492; // 0xb984

/**
 * Format code for AAC audio files
 * @apiSince 12
 */

public static final int FORMAT_AAC = 47363; // 0xb903

/**
 * Format code for audio albums
 * @apiSince 12
 */

public static final int FORMAT_ABSTRACT_AUDIO_ALBUM = 47619; // 0xba03

/**
 * Format code for abstract audio playlists
 * @apiSince 12
 */

public static final int FORMAT_ABSTRACT_AUDIO_PLAYLIST = 47625; // 0xba09

/**
 * Format code for abstract AV playlists
 * @apiSince 12
 */

public static final int FORMAT_ABSTRACT_AV_PLAYLIST = 47621; // 0xba05

/**
 * Format code for abstract documents
 * @apiSince 12
 */

public static final int FORMAT_ABSTRACT_DOCUMENT = 47745; // 0xba81

/**
 * Format code for image albums
 * @apiSince 12
 */

public static final int FORMAT_ABSTRACT_IMAGE_ALBUM = 47618; // 0xba02

/**
 * Format code for abstract mediacasts
 * @apiSince 12
 */

public static final int FORMAT_ABSTRACT_MEDIACAST = 47627; // 0xba0b

/**
 * Format code for multimedia albums
 * @apiSince 12
 */

public static final int FORMAT_ABSTRACT_MULTIMEDIA_ALBUM = 47617; // 0xba01

/**
 * Format code for video albums
 * @apiSince 12
 */

public static final int FORMAT_ABSTRACT_VIDEO_ALBUM = 47620; // 0xba04

/**
 * Format code for abstract video playlists
 * @apiSince 12
 */

public static final int FORMAT_ABSTRACT_VIDEO_PLAYLIST = 47626; // 0xba0a

/**
 * Format code for AIFF audio files
 * @apiSince 12
 */

public static final int FORMAT_AIFF = 12295; // 0x3007

/**
 * Format code for ASF files
 * @apiSince 12
 */

public static final int FORMAT_ASF = 12300; // 0x300c

/**
 * Format code for associations (folders and directories)
 * @apiSince 12
 */

public static final int FORMAT_ASSOCIATION = 12289; // 0x3001

/**
 * Format code for ASX playlist files
 * @apiSince 12
 */

public static final int FORMAT_ASX_PLAYLIST = 47635; // 0xba13

/**
 * Format code for Audible audio files
 * @apiSince 12
 */

public static final int FORMAT_AUDIBLE = 47364; // 0xb904

/**
 * Format code for AVI video files
 * @apiSince 12
 */

public static final int FORMAT_AVI = 12298; // 0x300a

/**
 * Format code for BMP image files
 * @apiSince 12
 */

public static final int FORMAT_BMP = 14340; // 0x3804

/**
 * Format code for unknown image files.
 * <p>
 * Will be used for the formats which are not specified in PTP specification.
 * For instance, WEBP and WBMP.
 * @apiSince 24
 */

public static final int FORMAT_DEFINED = 14336; // 0x3800

/**
 * Format code for DNG files
 * @apiSince 24
 */

public static final int FORMAT_DNG = 14353; // 0x3811

/**
 * Format code for DPOF files
 * @apiSince 12
 */

public static final int FORMAT_DPOF = 12294; // 0x3006

/**
 * Format code for executable files
 * @apiSince 12
 */

public static final int FORMAT_EXECUTABLE = 12291; // 0x3003

/**
 * Format code for JPEG image files
 * @apiSince 12
 */

public static final int FORMAT_EXIF_JPEG = 14337; // 0x3801

/**
 * Format code for FLAC audio files
 * @apiSince 12
 */

public static final int FORMAT_FLAC = 47366; // 0xb906

/**
 * Format code for GIF image files
 * @apiSince 12
 */

public static final int FORMAT_GIF = 14343; // 0x3807

/**
 * Format code for HTML files
 * @apiSince 12
 */

public static final int FORMAT_HTML = 12293; // 0x3005

/**
 * Format code for JFIF image files
 * @apiSince 12
 */

public static final int FORMAT_JFIF = 14344; // 0x3808

/**
 * Format code for JP2 files
 * @apiSince 12
 */

public static final int FORMAT_JP2 = 14351; // 0x380f

/**
 * Format code for JPX files
 * @apiSince 12
 */

public static final int FORMAT_JPX = 14352; // 0x3810

/**
 * Format code for M3u playlist files
 * @apiSince 12
 */

public static final int FORMAT_M3U_PLAYLIST = 47633; // 0xba11

/**
 * Format code for MP2 files
 * @apiSince 12
 */

public static final int FORMAT_MP2 = 47491; // 0xb983

/**
 * Format code for MP3 audio files
 * @apiSince 12
 */

public static final int FORMAT_MP3 = 12297; // 0x3009

/**
 * Format code for MP4 files
 * @apiSince 12
 */

public static final int FORMAT_MP4_CONTAINER = 47490; // 0xb982

/**
 * Format code for MPEG video files
 * @apiSince 12
 */

public static final int FORMAT_MPEG = 12299; // 0x300b

/**
 * Format code for MPL playlist files
 * @apiSince 12
 */

public static final int FORMAT_MPL_PLAYLIST = 47634; // 0xba12

/**
 * Format code for MS Excel spreadsheets
 * @apiSince 12
 */

public static final int FORMAT_MS_EXCEL_SPREADSHEET = 47749; // 0xba85

/**
 * Format code for MS PowerPoint presentatiosn
 * @apiSince 12
 */

public static final int FORMAT_MS_POWERPOINT_PRESENTATION = 47750; // 0xba86

/**
 * Format code for MS Word documents
 * @apiSince 12
 */

public static final int FORMAT_MS_WORD_DOCUMENT = 47747; // 0xba83

/**
 * Format code for OGG audio files
 * @apiSince 12
 */

public static final int FORMAT_OGG = 47362; // 0xb902

/**
 * Format code for PICT image files
 * @apiSince 12
 */

public static final int FORMAT_PICT = 14346; // 0x380a

/**
 * Format code for PLS playlist files
 * @apiSince 12
 */

public static final int FORMAT_PLS_PLAYLIST = 47636; // 0xba14

/**
 * Format code for PNG image files
 * @apiSince 12
 */

public static final int FORMAT_PNG = 14347; // 0x380b

/**
 * Format code for script files
 * @apiSince 12
 */

public static final int FORMAT_SCRIPT = 12290; // 0x3002

/**
 * Format code for text files
 * @apiSince 12
 */

public static final int FORMAT_TEXT = 12292; // 0x3004

/**
 * Format code for TIFF image files
 * @apiSince 12
 */

public static final int FORMAT_TIFF = 14349; // 0x380d

/**
 * Format code for TIFF EP image files
 * @apiSince 12
 */

public static final int FORMAT_TIFF_EP = 14338; // 0x3802

/**
 * Undefined format code
 * @apiSince 12
 */

public static final int FORMAT_UNDEFINED = 12288; // 0x3000

/**
 * Format code for undefined audio files files
 * @apiSince 12
 */

public static final int FORMAT_UNDEFINED_AUDIO = 47360; // 0xb900

/**
 * Format code for undefined collections
 * @apiSince 12
 */

public static final int FORMAT_UNDEFINED_COLLECTION = 47616; // 0xba00

/**
 * Format code for undefined document files
 * @apiSince 12
 */

public static final int FORMAT_UNDEFINED_DOCUMENT = 47744; // 0xba80

/**
 * Format code for firmware files
 * @apiSince 12
 */

public static final int FORMAT_UNDEFINED_FIRMWARE = 47106; // 0xb802

/**
 * Format code for undefined video files
 * @apiSince 12
 */

public static final int FORMAT_UNDEFINED_VIDEO = 47488; // 0xb980

/**
 * Format code for WAV audio files
 * @apiSince 12
 */

public static final int FORMAT_WAV = 12296; // 0x3008

/**
 * Format code for Windows image files
 * @apiSince 12
 */

public static final int FORMAT_WINDOWS_IMAGE_FORMAT = 47233; // 0xb881

/**
 * Format code for WMA audio files
 * @apiSince 12
 */

public static final int FORMAT_WMA = 47361; // 0xb901

/**
 * Format code for WMV video files
 * @apiSince 12
 */

public static final int FORMAT_WMV = 47489; // 0xb981

/**
 * Format code for WPL playlist files
 * @apiSince 12
 */

public static final int FORMAT_WPL_PLAYLIST = 47632; // 0xba10

/**
 * Format code for XML documents
 * @apiSince 12
 */

public static final int FORMAT_XML_DOCUMENT = 47746; // 0xba82

/**
 * Operation code for CloseSession
 * @apiSince 24
 */

public static final int OPERATION_CLOSE_SESSION = 4099; // 0x1003

/**
 * Operation code for CopyObject
 * @apiSince 24
 */

public static final int OPERATION_COPY_OBJECT = 4122; // 0x101a

/**
 * Operation code for DeleteObject
 * @apiSince 24
 */

public static final int OPERATION_DELETE_OBJECT = 4107; // 0x100b

/**
 * Operation code for FormatStore
 * @apiSince 24
 */

public static final int OPERATION_FORMAT_STORE = 4111; // 0x100f

/**
 * Operation code for GetDeviceInfo
 * @apiSince 24
 */

public static final int OPERATION_GET_DEVICE_INFO = 4097; // 0x1001

/**
 * Operation code for GetDevicePropDesc
 * @apiSince 24
 */

public static final int OPERATION_GET_DEVICE_PROP_DESC = 4116; // 0x1014

/**
 * Operation code for GetDevicePropValue
 * @apiSince 24
 */

public static final int OPERATION_GET_DEVICE_PROP_VALUE = 4117; // 0x1015

/**
 * Operation code for GetNumObjects
 * @apiSince 24
 */

public static final int OPERATION_GET_NUM_OBJECTS = 4102; // 0x1006

/**
 * Operation code for GetObject
 * @apiSince 24
 */

public static final int OPERATION_GET_OBJECT = 4105; // 0x1009

/**
 * Operation code for GetObjectHandles
 * @apiSince 24
 */

public static final int OPERATION_GET_OBJECT_HANDLES = 4103; // 0x1007

/**
 * Operation code for GetObjectInfo
 * @apiSince 24
 */

public static final int OPERATION_GET_OBJECT_INFO = 4104; // 0x1008

/**
 * Operation code for GetObjectPropsSupported
 * @apiSince 24
 */

public static final int OPERATION_GET_OBJECT_PROPS_SUPPORTED = 38913; // 0x9801

/**
 * Operation code for GetObjectPropDesc
 * @apiSince 24
 */

public static final int OPERATION_GET_OBJECT_PROP_DESC = 38914; // 0x9802

/**
 * Operation code for GetObjectPropValue
 * @apiSince 24
 */

public static final int OPERATION_GET_OBJECT_PROP_VALUE = 38915; // 0x9803

/**
 * Operation code for GetObjectReferences
 * @apiSince 24
 */

public static final int OPERATION_GET_OBJECT_REFERENCES = 38928; // 0x9810

/**
 * Operation code for GetPartialObject
 * @apiSince 24
 */

public static final int OPERATION_GET_PARTIAL_OBJECT = 4123; // 0x101b

/**
 * Operation code for GetPartialObject64
 * @apiSince 24
 */

public static final int OPERATION_GET_PARTIAL_OBJECT_64 = 38337; // 0x95c1

/**
 * Operation code for GetStorageInfo
 * @apiSince 24
 */

public static final int OPERATION_GET_STORAGE_INFO = 4101; // 0x1005

/**
 * Operation code for GetStorageIDs
 * @apiSince 24
 */

public static final int OPERATION_GET_STORAGE_I_DS = 4100; // 0x1004

/**
 * Operation code for GetThumb
 * @apiSince 24
 */

public static final int OPERATION_GET_THUMB = 4106; // 0x100a

/**
 * Operation code for InitiateCapture
 * @apiSince 24
 */

public static final int OPERATION_INITIATE_CAPTURE = 4110; // 0x100e

/**
 * Operation code for InitiateOpenCapture
 * @apiSince 24
 */

public static final int OPERATION_INITIATE_OPEN_CAPTURE = 4124; // 0x101c

/**
 * Operation code for MoveObject
 * @apiSince 24
 */

public static final int OPERATION_MOVE_OBJECT = 4121; // 0x1019

/**
 * Operation code for OpenSession
 * @apiSince 24
 */

public static final int OPERATION_OPEN_SESSION = 4098; // 0x1002

/**
 * Operation code for PowerDown
 * @apiSince 24
 */

public static final int OPERATION_POWER_DOWN = 4115; // 0x1013

/**
 * Operation code for ResetDevice
 * @apiSince 24
 */

public static final int OPERATION_RESET_DEVICE = 4112; // 0x1010

/**
 * Operation code for ResetDevicePropValue
 * @apiSince 24
 */

public static final int OPERATION_RESET_DEVICE_PROP_VALUE = 4119; // 0x1017

/**
 * Operation code for SelfTest
 * @apiSince 24
 */

public static final int OPERATION_SELF_TEST = 4113; // 0x1011

/**
 * Operation code for SendObject
 * @apiSince 24
 */

public static final int OPERATION_SEND_OBJECT = 4109; // 0x100d

/**
 * Operation code for SendObjectInfo
 * @apiSince 24
 */

public static final int OPERATION_SEND_OBJECT_INFO = 4108; // 0x100c

/**
 * Operation code for SetDevicePropValue
 * @apiSince 24
 */

public static final int OPERATION_SET_DEVICE_PROP_VALUE = 4118; // 0x1016

/**
 * Operation code for SetObjectPropValue
 * @apiSince 24
 */

public static final int OPERATION_SET_OBJECT_PROP_VALUE = 38916; // 0x9804

/**
 * Operation code for SetObjectProtection
 * @apiSince 24
 */

public static final int OPERATION_SET_OBJECT_PROTECTION = 4114; // 0x1012

/**
 * Operation code for SetObjectReferences
 * @apiSince 24
 */

public static final int OPERATION_SET_OBJECT_REFERENCES = 38929; // 0x9811

/**
 * Operation code for Skip
 * @apiSince 24
 */

public static final int OPERATION_SKIP = 38944; // 0x9820

/**
 * Operation code for TerminateOpenCapture
 * @apiSince 24
 */

public static final int OPERATION_TERMINATE_OPEN_CAPTURE = 4120; // 0x1018

/**
 * Object is not protected. It may be modified and deleted, and its properties
 * may be modified.
 * @apiSince 12
 */

public static final int PROTECTION_STATUS_NONE = 0; // 0x0

/**
 * Object's contents can not be transfered from the device, but the object
 * may be moved or deleted and its properties may be modified.
 * @apiSince 12
 */

public static final int PROTECTION_STATUS_NON_TRANSFERABLE_DATA = 32771; // 0x8003

/**
 * Object can not be modified or deleted and its properties can not be modified.
 * @apiSince 12
 */

public static final int PROTECTION_STATUS_READ_ONLY = 32769; // 0x8001

/**
 * Object can not be modified or deleted but its properties are modifiable.
 * @apiSince 12
 */

public static final int PROTECTION_STATUS_READ_ONLY_DATA = 32770; // 0x8002
}

