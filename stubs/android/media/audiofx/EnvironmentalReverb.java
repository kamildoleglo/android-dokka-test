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
 * A sound generated within a room travels in many directions. The listener first hears the direct
 * sound from the source itself. Later, he or she hears discrete echoes caused by sound bouncing off
 * nearby walls, the ceiling and the floor. As sound waves arrive after undergoing more and more
 * reflections, individual reflections become indistinguishable and the listener hears continuous
 * reverberation that decays over time.
 * Reverb is vital for modeling a listener's environment. It can be used in music applications
 * to simulate music being played back in various environments, or in games to immerse the
 * listener within the game's environment.
 * The EnvironmentalReverb class allows an application to control each reverb engine property in a
 * global reverb environment and is more suitable for games. For basic control, more suitable for
 * music applications, it is recommended to use the
 * {@link android.media.audiofx.PresetReverb} class.
 * <p>An application creates a EnvironmentalReverb object to instantiate and control a reverb engine
 * in the audio framework.
 * <p>The methods, parameter types and units exposed by the EnvironmentalReverb implementation are
 * directly mapping those defined by the OpenSL ES 1.0.1 Specification
 * (http://www.khronos.org/opensles/) for the SLEnvironmentalReverbItf interface.
 * Please refer to this specification for more details.
 * <p>The EnvironmentalReverb is an output mix auxiliary effect and should be created on
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
public class EnvironmentalReverb extends android.media.audiofx.AudioEffect {

/**
 * Class constructor.
 * @param priority the priority level requested by the application for controlling the
 * EnvironmentalReverb engine. As the same engine can be shared by several applications, this
 * parameter indicates how much the requesting application needs control of effect parameters.
 * The normal priority is 0, above normal is a positive number, below normal a negative number.
 * @param audioSession  system wide unique audio session identifier. If audioSession
 *  is not 0, the EnvironmentalReverb will be attached to the MediaPlayer or AudioTrack in the
 *  same audio session. Otherwise, the EnvironmentalReverb will apply to the output mix.
 *  As the EnvironmentalReverb is an auxiliary effect it is recommended to instantiate it on
 *  audio session 0 and to attach it to the MediaPLayer auxiliary output.
 *
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @throws java.lang.RuntimeException
 * @apiSince 9
 */

public EnvironmentalReverb(int priority, int audioSession) throws java.lang.IllegalArgumentException, java.lang.RuntimeException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Sets the master volume level of the environmental reverb effect.
 * @param room room level in millibels. The valid range is [-9000, 0].
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setRoomLevel(short room) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the master volume level of the environmental reverb effect.
 * @return the room level in millibels.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public short getRoomLevel() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Sets the volume level at 5 kHz relative to the volume level at low frequencies of the
 * overall reverb effect.
 * <p>This controls a low-pass filter that will reduce the level of the high-frequency.
 * @param roomHF high frequency attenuation level in millibels. The valid range is [-9000, 0].
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setRoomHFLevel(short roomHF) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the room HF level.
 * @return the room HF level in millibels.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public short getRoomHFLevel() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Sets the time taken for the level of reverberation to decay by 60 dB.
 * @param decayTime decay time in milliseconds. The valid range is [100, 20000].
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setDecayTime(int decayTime) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the decay time.
 * @return the decay time in milliseconds.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public int getDecayTime() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Sets the ratio of high frequency decay time (at 5 kHz) relative to the decay time at low
 * frequencies.
 * @param decayHFRatio high frequency decay ratio using a permille scale. The valid range is
 * [100, 2000]. A ratio of 1000 indicates that all frequencies decay at the same rate.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setDecayHFRatio(short decayHFRatio) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the ratio of high frequency decay time (at 5 kHz) relative to low frequencies.
 * @return the decay HF ration. See {@link #setDecayHFRatio(short)} for units.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public short getDecayHFRatio() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Sets the volume level of the early reflections.
 * <p>This level is combined with the overall room level
 * (set using {@link #setRoomLevel(short)}).
 * @param reflectionsLevel reflection level in millibels. The valid range is [-9000, 1000].
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setReflectionsLevel(short reflectionsLevel) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the volume level of the early reflections.
 * @return the early reflections level in millibels.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public short getReflectionsLevel() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Sets the delay time for the early reflections.
 * <p>This method sets the time between when the direct path is heard and when the first
 * reflection is heard.
 * @param reflectionsDelay reflections delay in milliseconds. The valid range is [0, 300].
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setReflectionsDelay(int reflectionsDelay) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the reflections delay.
 * @return the early reflections delay in milliseconds.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public int getReflectionsDelay() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Sets the volume level of the late reverberation.
 * <p>This level is combined with the overall room level (set using {@link #setRoomLevel(short)}).
 * @param reverbLevel reverb level in millibels. The valid range is [-9000, 2000].
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setReverbLevel(short reverbLevel) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the reverb level.
 * @return the reverb level in millibels.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public short getReverbLevel() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Sets the time between the first reflection and the reverberation.
 * @param reverbDelay reverb delay in milliseconds. The valid range is [0, 100].
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setReverbDelay(int reverbDelay) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the reverb delay.
 * @return the reverb delay in milliseconds.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public int getReverbDelay() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Sets the echo density in the late reverberation decay.
 * <p>The scale should approximately map linearly to the perceived change in reverberation.
 * @param diffusion diffusion specified using a permille scale. The diffusion valid range is
 * [0, 1000]. A value of 1000 o/oo indicates a smooth reverberation decay.
 * Values below this level give a more <i>grainy</i> character.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setDiffusion(short diffusion) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets diffusion level.
 * @return the diffusion level. See {@link #setDiffusion(short)} for units.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public short getDiffusion() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Controls the modal density of the late reverberation decay.
 * <p> The scale should approximately map linearly to the perceived change in reverberation.
 * A lower density creates a hollow sound that is useful for simulating small reverberation
 * spaces such as bathrooms.
 * @param density density specified using a permille scale. The valid range is [0, 1000].
 * A value of 1000 o/oo indicates a natural sounding reverberation. Values below this level
 * produce a more colored effect.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setDensity(short density) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the density level.
 * @return the density level. See {@link #setDiffusion(short)} for units.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public short getDensity() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Registers an OnParameterChangeListener interface.
 * @param listener OnParameterChangeListener interface registered
 * @apiSince 9
 */

public void setParameterListener(android.media.audiofx.EnvironmentalReverb.OnParameterChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Gets the environmental reverb properties. This method is useful when a snapshot of current
 * reverb settings must be saved by the application.
 * @return an EnvironmentalReverb.Settings object containing all current parameters values
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public android.media.audiofx.EnvironmentalReverb.Settings getProperties() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Sets the environmental reverb properties. This method is useful when reverb settings have to
 * be applied from a previous backup.
 * @param settings a EnvironmentalReverb.Settings object containing the properties to apply
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setProperties(android.media.audiofx.EnvironmentalReverb.Settings settings) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Decay HF ratio. Parameter ID for
 * {@link android.media.audiofx.EnvironmentalReverb.OnParameterChangeListener}
 * @apiSince 9
 */

public static final int PARAM_DECAY_HF_RATIO = 3; // 0x3

/**
 * Decay time. Parameter ID for OnParameterChangeListener
 * @apiSince 9
 */

public static final int PARAM_DECAY_TIME = 2; // 0x2

/**
 * Density. Parameter ID for OnParameterChangeListener
 * @apiSince 9
 */

public static final int PARAM_DENSITY = 9; // 0x9

/**
 * Diffusion. Parameter ID for OnParameterChangeListener
 * @apiSince 9
 */

public static final int PARAM_DIFFUSION = 8; // 0x8

/**
 * Early reflections delay. Parameter ID for OnParameterChangeListener
 * @apiSince 9
 */

public static final int PARAM_REFLECTIONS_DELAY = 5; // 0x5

/**
 * Early reflections level. Parameter ID for OnParameterChangeListener
 * @apiSince 9
 */

public static final int PARAM_REFLECTIONS_LEVEL = 4; // 0x4

/**
 * Reverb delay. Parameter ID for OnParameterChangeListener
 * @apiSince 9
 */

public static final int PARAM_REVERB_DELAY = 7; // 0x7

/**
 * Reverb level. Parameter ID for OnParameterChangeListener
 * @apiSince 9
 */

public static final int PARAM_REVERB_LEVEL = 6; // 0x6

/**
 * Room HF level. Parameter ID for OnParameterChangeListener
 * @apiSince 9
 */

public static final int PARAM_ROOM_HF_LEVEL = 1; // 0x1

/**
 * Room level. Parameter ID for OnParameterChangeListener
 * @apiSince 9
 */

public static final int PARAM_ROOM_LEVEL = 0; // 0x0
/**
 * The OnParameterChangeListener interface defines a method called by the EnvironmentalReverb
 * when a parameter value has changed.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnParameterChangeListener {

/**
 * Method called when a parameter value has changed. The method is called only if the
 * parameter was changed by another application having the control of the same
 * EnvironmentalReverb engine.
 * @param effect the EnvironmentalReverb on which the interface is registered.
 * @param status status of the set parameter operation.
 * @param param ID of the modified parameter. See {@link #PARAM_ROOM_LEVEL} ...
 * @param value the new parameter value.
 * @apiSince 9
 */

public void onParameterChange(android.media.audiofx.EnvironmentalReverb effect, int status, int param, int value);
}

/**
 * The Settings class regroups all environmental reverb parameters. It is used in
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

public short decayHFRatio;

/** @apiSince 9 */

public int decayTime;

/** @apiSince 9 */

public short density;

/** @apiSince 9 */

public short diffusion;

/** @apiSince 9 */

public int reflectionsDelay;

/** @apiSince 9 */

public short reflectionsLevel;

/** @apiSince 9 */

public int reverbDelay;

/** @apiSince 9 */

public short reverbLevel;

/** @apiSince 9 */

public short roomHFLevel;

/** @apiSince 9 */

public short roomLevel;
}

}

