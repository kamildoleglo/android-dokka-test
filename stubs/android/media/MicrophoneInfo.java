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


package android.media;

import android.util.Pair;

/**
 * Class providing information on a microphone. It indicates the location and orientation of the
 * microphone on the device as well as useful information like frequency response and sensitivity.
 * It can be used by applications implementing special pre processing effects like noise suppression
 * of beam forming that need to know about precise microphone characteristics in order to adapt
 * their algorithms.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MicrophoneInfo {

MicrophoneInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns alphanumeric code that uniquely identifies the device.
 *
 * @return the description of the microphone
 * @apiSince 28
 */

public java.lang.String getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Returns The system unique device ID that corresponds to the id
 * returned by {@link android.media.AudioDeviceInfo#getId() AudioDeviceInfo#getId()}.
 *
 * @return the microphone's id
 * @apiSince 28
 */

public int getId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the device type identifier of the microphone (e.g AudioDeviceInfo.TYPE_BUILTIN_MIC).
 *
 * @return the device type of the microphone
 * @apiSince 28
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns The "address" string of the microphone that corresponds to the
 * address returned by {@link android.media.AudioDeviceInfo#getAddress() AudioDeviceInfo#getAddress()}
 * @return the address of the microphone
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.lang.String getAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the location of the microphone. The return value is
 * one of {@link #LOCATION_UNKNOWN}, {@link #LOCATION_MAINBODY},
 * {@link #LOCATION_MAINBODY_MOVABLE}, or {@link #LOCATION_PERIPHERAL}.
 *
 * @return the location of the microphone
 
 * Value is either <code>0</code> or a combination of {@link android.media.MicrophoneInfo#LOCATION_UNKNOWN}, {@link android.media.MicrophoneInfo#LOCATION_MAINBODY}, {@link android.media.MicrophoneInfo#LOCATION_MAINBODY_MOVABLE}, and {@link android.media.MicrophoneInfo#LOCATION_PERIPHERAL}
 * @apiSince 28
 */

public int getLocation() { throw new RuntimeException("Stub!"); }

/**
 * Returns A device group id that can be used to group together microphones on the same
 * peripheral, attachments or logical groups. Main body is usually group 0.
 *
 * @return the group of the microphone or {@link #GROUP_UNKNOWN} if the group is unknown
 * @apiSince 28
 */

public int getGroup() { throw new RuntimeException("Stub!"); }

/**
 * Returns unique index for device within its group.
 *
 * @return the microphone's index in its group or {@link #INDEX_IN_THE_GROUP_UNKNOWN} if the
 * index in the group is unknown
 * @apiSince 28
 */

public int getIndexInTheGroup() { throw new RuntimeException("Stub!"); }

/**
 * Returns A {@link android.media.MicrophoneInfo.Coordinate3F Coordinate3F} object that represents the geometric location of microphone
 * in meters, from bottom-left-back corner of appliance. X-axis, Y-axis and Z-axis show
 * as the x, y, z values.
 *
 * @return the geometric location of the microphone or {@link #POSITION_UNKNOWN} if the
 * geometric location is unknown
 * @apiSince 28
 */

public android.media.MicrophoneInfo.Coordinate3F getPosition() { throw new RuntimeException("Stub!"); }

/**
 * Returns A {@link android.media.MicrophoneInfo.Coordinate3F Coordinate3F} object that represents the orientation of microphone.
 * X-axis, Y-axis and Z-axis show as the x, y, z value. The orientation will be normalized
 * such as sqrt(x^2 + y^2 + z^2) equals 1.
 *
 * @return the orientation of the microphone or {@link #ORIENTATION_UNKNOWN} if orientation
 * is unknown
 * @apiSince 28
 */

public android.media.MicrophoneInfo.Coordinate3F getOrientation() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.util.Pair} list of frequency responses.
 * For every {@link android.util.Pair} in the list, the first value represents frequency in Hz,
 * and the second value represents response in dB.
 *
 * @return the frequency response of the microphone
 * @apiSince 28
 */

public java.util.List<android.util.Pair<java.lang.Float,java.lang.Float>> getFrequencyResponse() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.util.Pair} list for channel mapping, which indicating how this
 * microphone is used by each channels or a capture stream. For each {@link android.util.Pair},
 * the first value is channel index, the second value is channel mapping type, which could be
 * either {@link #CHANNEL_MAPPING_DIRECT} or {@link #CHANNEL_MAPPING_PROCESSED}.
 * If a channel has contributions from more than one microphone, it is likely the HAL
 * did some extra processing to combine the sources, but this is to be inferred by the user.
 * Empty list when the MicrophoneInfo is returned by AudioManager.getMicrophones().
 * At least one entry when the MicrophoneInfo is returned by AudioRecord.getActiveMicrophones().
 *
 * @return a {@link android.util.Pair} list for channel mapping
 * @apiSince 28
 */

public java.util.List<android.util.Pair<java.lang.Integer,java.lang.Integer>> getChannelMapping() { throw new RuntimeException("Stub!"); }

/**
 * Returns the level in dBFS produced by a 1000Hz tone at 94 dB SPL.
 *
 * @return the sensitivity of the microphone or {@link #SENSITIVITY_UNKNOWN} if the sensitivity
 * is unknown
 * @apiSince 28
 */

public float getSensitivity() { throw new RuntimeException("Stub!"); }

/**
 * Returns the level in dB of the maximum SPL supported by the device at 1000Hz.
 *
 * @return the maximum level in dB or {@link #SPL_UNKNOWN} if maximum SPL is unknown
 * @apiSince 28
 */

public float getMaxSpl() { throw new RuntimeException("Stub!"); }

/**
 * Returns the level in dB of the minimum SPL that can be registered by the device at 1000Hz.
 *
 * @return the minimum level in dB or {@link #SPL_UNKNOWN} if minimum SPL is unknown
 * @apiSince 28
 */

public float getMinSpl() { throw new RuntimeException("Stub!"); }

/**
 * Returns the directionality of microphone. The return value is one of
 * {@link #DIRECTIONALITY_UNKNOWN}, {@link #DIRECTIONALITY_OMNI},
 * {@link #DIRECTIONALITY_BI_DIRECTIONAL}, {@link #DIRECTIONALITY_CARDIOID},
 * {@link #DIRECTIONALITY_HYPER_CARDIOID}, or {@link #DIRECTIONALITY_SUPER_CARDIOID}.
 *
 * @return the directionality of microphone
 
 * Value is either <code>0</code> or a combination of {@link android.media.MicrophoneInfo#DIRECTIONALITY_UNKNOWN}, {@link android.media.MicrophoneInfo#DIRECTIONALITY_OMNI}, {@link android.media.MicrophoneInfo#DIRECTIONALITY_BI_DIRECTIONAL}, {@link android.media.MicrophoneInfo#DIRECTIONALITY_CARDIOID}, {@link android.media.MicrophoneInfo#DIRECTIONALITY_HYPER_CARDIOID}, and {@link android.media.MicrophoneInfo#DIRECTIONALITY_SUPER_CARDIOID}
 * @apiSince 28
 */

public int getDirectionality() { throw new RuntimeException("Stub!"); }

/**
 * The channel contains raw audio from this microphone.
 * @apiSince 28
 */

public static final int CHANNEL_MAPPING_DIRECT = 1; // 0x1

/**
 * The channel contains processed audio from this microphone and possibly another microphone.
 * @apiSince 28
 */

public static final int CHANNEL_MAPPING_PROCESSED = 2; // 0x2

/**
 * Microphone directionality type: bi-directional.
 * @apiSince 28
 */

public static final int DIRECTIONALITY_BI_DIRECTIONAL = 2; // 0x2

/**
 * Microphone directionality type: cardioid.
 * @apiSince 28
 */

public static final int DIRECTIONALITY_CARDIOID = 3; // 0x3

/**
 * Microphone directionality type: hyper cardioid.
 * @apiSince 28
 */

public static final int DIRECTIONALITY_HYPER_CARDIOID = 4; // 0x4

/**
 * Microphone directionality type: omni.
 * @apiSince 28
 */

public static final int DIRECTIONALITY_OMNI = 1; // 0x1

/**
 * Microphone directionality type: super cardioid.
 * @apiSince 28
 */

public static final int DIRECTIONALITY_SUPER_CARDIOID = 5; // 0x5

/**
 * Unknown microphone directionality.
 * @apiSince 28
 */

public static final int DIRECTIONALITY_UNKNOWN = 0; // 0x0

/**
 * Value used for when the group of the microphone is unknown.
 * @apiSince 28
 */

public static final int GROUP_UNKNOWN = -1; // 0xffffffff

/**
 * Value used for when the index in the group of the microphone is unknown.
 * @apiSince 28
 */

public static final int INDEX_IN_THE_GROUP_UNKNOWN = -1; // 0xffffffff

/**
 * A microphone that locate on main body of the device.
 * @apiSince 28
 */

public static final int LOCATION_MAINBODY = 1; // 0x1

/**
 * A microphone that locate on a movable main body of the device.
 * @apiSince 28
 */

public static final int LOCATION_MAINBODY_MOVABLE = 2; // 0x2

/**
 * A microphone that locate on a peripheral.
 * @apiSince 28
 */

public static final int LOCATION_PERIPHERAL = 3; // 0x3

/**
 * A microphone that the location is unknown.
 * @apiSince 28
 */

public static final int LOCATION_UNKNOWN = 0; // 0x0

/**
 * Value used for when the orientation of the microphone is unknown.
 * @apiSince 28
 */

public static final android.media.MicrophoneInfo.Coordinate3F ORIENTATION_UNKNOWN;
static { ORIENTATION_UNKNOWN = null; }

/**
 * Value used for when the position of the microphone is unknown.
 * @apiSince 28
 */

public static final android.media.MicrophoneInfo.Coordinate3F POSITION_UNKNOWN;
static { POSITION_UNKNOWN = null; }

/**
 * Value used for when the sensitivity of the microphone is unknown.
 * @apiSince 28
 */

public static final float SENSITIVITY_UNKNOWN = -3.4028235E38f;

/**
 * Value used for when the SPL of the microphone is unknown. This value could be used when
 * maximum SPL or minimum SPL is unknown.
 * @apiSince 28
 */

public static final float SPL_UNKNOWN = -3.4028235E38f;
/** @apiSince 28 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Coordinate3F {

Coordinate3F() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public final float x;
{ x = 0; }

/** @apiSince 28 */

public final float y;
{ y = 0; }

/** @apiSince 28 */

public final float z;
{ z = 0; }
}

}

