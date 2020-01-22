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
 * A sound generated within a room travels in many directions. The listener first hears the
 * direct sound from the source itself. Later, he or she hears discrete echoes caused by sound
 * bouncing off nearby walls, the ceiling and the floor. As sound waves arrive after
 * undergoing more and more reflections, individual reflections become indistinguishable and
 * the listener hears continuous reverberation that decays over time.
 * Reverb is vital for modeling a listener's environment. It can be used in music applications
 * to simulate music being played back in various environments, or in games to immerse the
 * listener within the game's environment.
 * The PresetReverb class allows an application to configure the global reverb using a reverb preset.
 * This is primarily used for adding some reverb in a music playback context. Applications
 * requiring control over a more advanced environmental reverb are advised to use the
 * {@link android.media.audiofx.EnvironmentalReverb} class.
 * <p>An application creates a PresetReverb object to instantiate and control a reverb engine in the
 * audio framework.
 * <p>The methods, parameter types and units exposed by the PresetReverb implementation are
 * directly mapping those defined by the OpenSL ES 1.0.1 Specification
 * (http://www.khronos.org/opensles/) for the SLPresetReverbItf interface.
 * Please refer to this specification for more details.
 * <p>The PresetReverb is an output mix auxiliary effect and should be created on
 * Audio session 0. In order for a MediaPlayer or AudioTrack to be fed into this effect,
 * they must be explicitely attached to it and a send level must be specified. Use the effect ID
 * returned by getId() method to designate this particular effect when attaching it to the
 * MediaPlayer or AudioTrack.
 * <p>Creating a reverb on the output mix (audio session 0) requires permission
 * {@link android.Manifest.permission#MODIFY_AUDIO_SETTINGS}
 * <p>See {@link android.media.audiofx.AudioEffect} class for more details on controlling
 * audio effects.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PresetReverb extends android.media.audiofx.AudioEffect {

/**
 * Class constructor.
 * @param priority the priority level requested by the application for controlling the
 * PresetReverb engine. As the same engine can be shared by several applications, this
 * parameter indicates how much the requesting application needs control of effect parameters.
 * The normal priority is 0, above normal is a positive number, below normal a negative number.
 * @param audioSession  system wide unique audio session identifier. If audioSession
 *  is not 0, the PresetReverb will be attached to the MediaPlayer or AudioTrack in the
 *  same audio session. Otherwise, the PresetReverb will apply to the output mix.
 *  As the PresetReverb is an auxiliary effect it is recommended to instantiate it on
 *  audio session 0 and to attach it to the MediaPLayer auxiliary output.
 *
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @throws java.lang.RuntimeException
 * @apiSince 9
 */

public PresetReverb(int priority, int audioSession) throws java.lang.IllegalArgumentException, java.lang.RuntimeException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 *  Enables a preset on the reverb.
 *  <p>The reverb PRESET_NONE disables any reverb from the current output but does not free the
 *  resources associated with the reverb. For an application to signal to the implementation
 *  to free the resources, it must call the release() method.
 * @param preset this must be one of the the preset constants defined in this class.
 * e.g. {@link #PRESET_SMALLROOM}
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setPreset(short preset) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets current reverb preset.
 * @return the preset that is set at the moment.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public short getPreset() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Registers an OnParameterChangeListener interface.
 * @param listener OnParameterChangeListener interface registered
 * @apiSince 9
 */

public void setParameterListener(android.media.audiofx.PresetReverb.OnParameterChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Gets the preset reverb properties. This method is useful when a snapshot of current
 * preset reverb settings must be saved by the application.
 * @return a PresetReverb.Settings object containing all current parameters values
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public android.media.audiofx.PresetReverb.Settings getProperties() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Sets the preset reverb properties. This method is useful when preset reverb settings have to
 * be applied from a previous backup.
 * @param settings a PresetReverb.Settings object containing the properties to apply
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setProperties(android.media.audiofx.PresetReverb.Settings settings) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Preset. Parameter ID for
 * {@link android.media.audiofx.PresetReverb.OnParameterChangeListener}
 * @apiSince 9
 */

public static final int PARAM_PRESET = 0; // 0x0

/**
 * Reverb preset representing a large-sized hall suitable for a full orchestra
 * @apiSince 9
 */

public static final short PRESET_LARGEHALL = 5; // 0x5

/**
 * Reverb preset representing a large-sized room suitable for live performances
 * @apiSince 9
 */

public static final short PRESET_LARGEROOM = 3; // 0x3

/**
 * Reverb preset representing a medium-sized hall
 * @apiSince 9
 */

public static final short PRESET_MEDIUMHALL = 4; // 0x4

/**
 * Reverb preset representing a medium room with a length of ten meters or less
 * @apiSince 9
 */

public static final short PRESET_MEDIUMROOM = 2; // 0x2

/**
 * No reverb or reflections
 * @apiSince 9
 */

public static final short PRESET_NONE = 0; // 0x0

/**
 * Reverb preset representing a synthesis of the traditional plate reverb
 * @apiSince 9
 */

public static final short PRESET_PLATE = 6; // 0x6

/**
 * Reverb preset representing a small room less than five meters in length
 * @apiSince 9
 */

public static final short PRESET_SMALLROOM = 1; // 0x1
/**
 * The OnParameterChangeListener interface defines a method called by the PresetReverb
 * when a parameter value has changed.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnParameterChangeListener {

/**
 * Method called when a parameter value has changed. The method is called only if the
 * parameter was changed by another application having the control of the same
 * PresetReverb engine.
 * @param effect the PresetReverb on which the interface is registered.
 * @param status status of the set parameter operation.
 * @param param ID of the modified parameter. See {@link #PARAM_PRESET} ...
 * @param value the new parameter value.
 * @apiSince 9
 */

public void onParameterChange(android.media.audiofx.PresetReverb effect, int status, int param, short value);
}

/**
 * The Settings class regroups all preset reverb parameters. It is used in
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

public short preset;
}

}

