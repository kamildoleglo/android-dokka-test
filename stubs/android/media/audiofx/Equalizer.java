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


package android.media.audiofx;

import android.media.audiofx.AudioEffect;

/**
 * An Equalizer is used to alter the frequency response of a particular music source or of the main
 * output mix.
 * <p>An application creates an Equalizer object to instantiate and control an Equalizer engine
 * in the audio framework. The application can either simply use predefined presets or have a more
 * precise control of the gain in each frequency band controlled by the equalizer.
 * <p>The methods, parameter types and units exposed by the Equalizer implementation are directly
 * mapping those defined by the OpenSL ES 1.0.1 Specification (http://www.khronos.org/opensles/)
 * for the SLEqualizerItf interface. Please refer to this specification for more details.
 * <p>To attach the Equalizer to a particular AudioTrack or MediaPlayer, specify the audio session
 * ID of this AudioTrack or MediaPlayer when constructing the Equalizer.
 * <p>NOTE: attaching an Equalizer to the global audio output mix by use of session 0 is deprecated.
 * <p>See {@link android.media.MediaPlayer#getAudioSessionId()} for details on audio sessions.
 * <p>See {@link android.media.audiofx.AudioEffect} class for more details on controlling audio
 * effects.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Equalizer extends android.media.audiofx.AudioEffect {

/**
 * Class constructor.
 * @param priority the priority level requested by the application for controlling the Equalizer
 * engine. As the same engine can be shared by several applications, this parameter indicates
 * how much the requesting application needs control of effect parameters. The normal priority
 * is 0, above normal is a positive number, below normal a negative number.
 * @param audioSession  system wide unique audio session identifier. The Equalizer will be
 * attached to the MediaPlayer or AudioTrack in the same audio session.
 *
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @throws java.lang.RuntimeException
 * @apiSince 9
 */

public Equalizer(int priority, int audioSession) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.RuntimeException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of frequency bands supported by the Equalizer engine.
 * @return the number of bands
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public short getNumberOfBands() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the level range for use by {@link #setBandLevel(short,short)}. The level is expressed in
 * milliBel.
 * @return the band level range in an array of short integers. The first element is the lower
 * limit of the range, the second element the upper limit.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public short[] getBandLevelRange() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Sets the given equalizer band to the given gain value.
 * @param band frequency band that will have the new gain. The numbering of the bands starts
 * from 0 and ends at (number of bands - 1).
 * @param level new gain in millibels that will be set to the given band. getBandLevelRange()
 * will define the maximum and minimum values.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @see #getNumberOfBands()
 * @apiSince 9
 */

public void setBandLevel(short band, short level) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the gain set for the given equalizer band.
 * @param band frequency band whose gain is requested. The numbering of the bands starts
 * from 0 and ends at (number of bands - 1).
 * @return the gain in millibels of the given band.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public short getBandLevel(short band) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the center frequency of the given band.
 * @param band frequency band whose center frequency is requested. The numbering of the bands
 * starts from 0 and ends at (number of bands - 1).
 * @return the center frequency in milliHertz
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public int getCenterFreq(short band) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the frequency range of the given frequency band.
 * @param band frequency band whose frequency range is requested. The numbering of the bands
 * starts from 0 and ends at (number of bands - 1).
 * @return the frequency range in millHertz in an array of integers. The first element is the
 * lower limit of the range, the second element the upper limit.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public int[] getBandFreqRange(short band) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the band that has the most effect on the given frequency.
 * @param frequency frequency in milliHertz which is to be equalized via the returned band.
 * @return the frequency band that has most effect on the given frequency.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public short getBand(int frequency) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets current preset.
 * @return the preset that is set at the moment.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public short getCurrentPreset() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Sets the equalizer according to the given preset.
 * @param preset new preset that will be taken into use. The valid range is [0,
 * number of presets-1].
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @see #getNumberOfPresets()
 * @apiSince 9
 */

public void usePreset(short preset) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the total number of presets the equalizer supports. The presets will have indices
 * [0, number of presets-1].
 * @return the number of presets the equalizer supports.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public short getNumberOfPresets() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the preset name based on the index.
 * @param preset index of the preset. The valid range is [0, number of presets-1].
 * @return a string containing the name of the given preset.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public java.lang.String getPresetName(short preset) { throw new RuntimeException("Stub!"); }

/**
 * Registers an OnParameterChangeListener interface.
 * @param listener OnParameterChangeListener interface registered
 * @apiSince 9
 */

public void setParameterListener(android.media.audiofx.Equalizer.OnParameterChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Gets the equalizer properties. This method is useful when a snapshot of current
 * equalizer settings must be saved by the application.
 * @return an Equalizer.Settings object containing all current parameters values
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public android.media.audiofx.Equalizer.Settings getProperties() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Sets the equalizer properties. This method is useful when equalizer settings have to
 * be applied from a previous backup.
 * @param settings an Equalizer.Settings object containing the properties to apply
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setProperties(android.media.audiofx.Equalizer.Settings settings) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Band frequency range. Parameter ID for
 * {@link android.media.audiofx.Equalizer.OnParameterChangeListener}
 * @apiSince 9
 */

public static final int PARAM_BAND_FREQ_RANGE = 4; // 0x4

/**
 * Band level. Parameter ID for OnParameterChangeListener
 * @apiSince 9
 */

public static final int PARAM_BAND_LEVEL = 2; // 0x2

/**
 * Band center frequency. Parameter ID for OnParameterChangeListener
 * @apiSince 9
 */

public static final int PARAM_CENTER_FREQ = 3; // 0x3

/**
 * Current preset. Parameter ID for OnParameterChangeListener
 * @apiSince 9
 */

public static final int PARAM_CURRENT_PRESET = 6; // 0x6

/**
 * Band for a given frequency. Parameter ID for OnParameterChangeListener
 *
 * @apiSince 9
 */

public static final int PARAM_GET_BAND = 5; // 0x5

/**
 * Request number of presets. Parameter ID for OnParameterChangeListener
 * @apiSince 9
 */

public static final int PARAM_GET_NUM_OF_PRESETS = 7; // 0x7

/**
 * Request preset name. Parameter ID for OnParameterChangeListener
 * @apiSince 9
 */

public static final int PARAM_GET_PRESET_NAME = 8; // 0x8

/**
 * Band level range. Parameter ID for OnParameterChangeListener
 * @apiSince 9
 */

public static final int PARAM_LEVEL_RANGE = 1; // 0x1

/**
 * Number of bands. Parameter ID for OnParameterChangeListener
 * @apiSince 9
 */

public static final int PARAM_NUM_BANDS = 0; // 0x0

/**
 * Maximum size for preset name
 * @apiSince 9
 */

public static final int PARAM_STRING_SIZE_MAX = 32; // 0x20
/**
 * The OnParameterChangeListener interface defines a method called by the Equalizer when a
 * parameter value has changed.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnParameterChangeListener {

/**
 * Method called when a parameter value has changed. The method is called only if the
 * parameter was changed by another application having the control of the same
 * Equalizer engine.
 * @param effect the Equalizer on which the interface is registered.
 * @param status status of the set parameter operation.
 * @param param1 ID of the modified parameter. See {@link #PARAM_BAND_LEVEL} ...
 * @param param2 additional parameter qualifier (e.g the band for band level parameter).
 * @param value the new parameter value.
 * @apiSince 9
 */

public void onParameterChange(android.media.audiofx.Equalizer effect, int status, int param1, int param2, int value);
}

/**
 * The Settings class regroups all equalizer parameters. It is used in
 * conjuntion with getProperties() and setProperties() methods to backup and restore
 * all parameters in a single call.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Settings {

/** @apiSince 9 */

public Settings() { throw new RuntimeException("Stub!"); }

/**
 * Settings class constructor from a key=value; pairs formatted string. The string is
 * typically returned by Settings.toString() method.
 * @throws java.lang.IllegalArgumentException if the string is not correctly formatted.
 * @apiSince 9
 */

public Settings(java.lang.String settings) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public short[] bandLevels;

/** @apiSince 9 */

public short curPreset;

/** @apiSince 9 */

public short numBands = 0; // 0x0
}

}

