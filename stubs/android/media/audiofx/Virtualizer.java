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
import android.media.AudioFormat;

/**
 * An audio virtualizer is a general name for an effect to spatialize audio channels. The exact
 * behavior of this effect is dependent on the number of audio input channels and the types and
 * number of audio output channels of the device. For example, in the case of a stereo input and
 * stereo headphone output, a stereo widening effect is used when this effect is turned on.
 * <p>An application creates a Virtualizer object to instantiate and control a virtualizer engine
 * in the audio framework.
 * <p>The methods, parameter types and units exposed by the Virtualizer implementation are directly
 * mapping those defined by the OpenSL ES 1.0.1 Specification (http://www.khronos.org/opensles/)
 * for the SLVirtualizerItf interface. Please refer to this specification for more details.
 * <p>To attach the Virtualizer to a particular AudioTrack or MediaPlayer, specify the audio session
 * ID of this AudioTrack or MediaPlayer when constructing the Virtualizer.
 * <p>NOTE: attaching a Virtualizer to the global audio output mix by use of session 0 is
 * deprecated.
 * <p>See {@link android.media.MediaPlayer#getAudioSessionId()} for details on audio sessions.
 * <p>See {@link android.media.audiofx.AudioEffect} class for more details on controlling
 * audio effects.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Virtualizer extends android.media.audiofx.AudioEffect {

/**
 * Class constructor.
 * @param priority the priority level requested by the application for controlling the Virtualizer
 * engine. As the same engine can be shared by several applications, this parameter indicates
 * how much the requesting application needs control of effect parameters. The normal priority
 * is 0, above normal is a positive number, below normal a negative number.
 * @param audioSession  system wide unique audio session identifier. The Virtualizer will
 * be attached to the MediaPlayer or AudioTrack in the same audio session.
 *
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @throws java.lang.RuntimeException
 * @apiSince 9
 */

public Virtualizer(int priority, int audioSession) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.RuntimeException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether setting strength is supported. If this method returns false, only one
 * strength is supported and the setStrength() method always rounds to that value.
 * @return true is strength parameter is supported, false otherwise
 * @apiSince 9
 */

public boolean getStrengthSupported() { throw new RuntimeException("Stub!"); }

/**
 * Sets the strength of the virtualizer effect. If the implementation does not support per mille
 * accuracy for setting the strength, it is allowed to round the given strength to the nearest
 * supported value. You can use the {@link #getRoundedStrength()} method to query the
 * (possibly rounded) value that was actually set.
 * @param strength strength of the effect. The valid range for strength strength is [0, 1000],
 * where 0 per mille designates the mildest effect and 1000 per mille designates the strongest.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setStrength(short strength) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Gets the current strength of the effect.
 * @return the strength of the effect. The valid range for strength is [0, 1000], where 0 per
 * mille designates the mildest effect and 1000 per mille the strongest
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public short getRoundedStrength() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Checks if the combination of a channel mask and virtualization mode is supported by this
 * virtualizer.
 * Some virtualizer implementations may only support binaural processing (i.e. only support
 * headphone output, see {@link #VIRTUALIZATION_MODE_BINAURAL}), some may support transaural
 * processing (i.e. for speaker output, see {@link #VIRTUALIZATION_MODE_TRANSAURAL}) for the
 * built-in speakers. Use this method to query the virtualizer implementation capabilities.
 * @param inputChannelMask the channel mask of the content to virtualize.
 * @param virtualizationMode the mode for which virtualization processing is to be performed,
 *    one of {@link #VIRTUALIZATION_MODE_BINAURAL}, {@link #VIRTUALIZATION_MODE_TRANSAURAL}.
 * Value is {@link android.media.audiofx.Virtualizer#VIRTUALIZATION_MODE_BINAURAL}, or {@link android.media.audiofx.Virtualizer#VIRTUALIZATION_MODE_TRANSAURAL}
 * @return true if the combination of channel mask and virtualization mode is supported, false
 *    otherwise.
 *    <br>An indication that a certain channel mask is not supported doesn't necessarily mean
 *    you cannot play content with that channel mask, it more likely implies the content will
 *    be downmixed before being virtualized. For instance a virtualizer that only supports a
 *    mask such as {@link android.media.AudioFormat#CHANNEL_OUT_STEREO AudioFormat#CHANNEL_OUT_STEREO}
 *    will still be able to process content with a mask of
 *    {@link android.media.AudioFormat#CHANNEL_OUT_5POINT1 AudioFormat#CHANNEL_OUT_5POINT1}, but will downmix the content to stereo first, and
 *    then will virtualize, as opposed to virtualizing each channel individually.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 21
 */

public boolean canVirtualize(int inputChannelMask, int virtualizationMode) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Queries the virtual speaker angles (azimuth and elevation) for a combination of a channel
 * mask and virtualization mode.
 * If the virtualization configuration (mask and mode) is supported (see
 * {@link #canVirtualize(int,int)}, the array angles will contain upon return the
 * definition of each virtual speaker and its azimuth and elevation angles relative to the
 * listener.
 * <br>Note that in some virtualizer implementations, the angles may be strength-dependent.
 * @param inputChannelMask the channel mask of the content to virtualize.
 * @param virtualizationMode the mode for which virtualization processing is to be performed,
 *    one of {@link #VIRTUALIZATION_MODE_BINAURAL}, {@link #VIRTUALIZATION_MODE_TRANSAURAL}.
 * Value is {@link android.media.audiofx.Virtualizer#VIRTUALIZATION_MODE_BINAURAL}, or {@link android.media.audiofx.Virtualizer#VIRTUALIZATION_MODE_TRANSAURAL}
 * @param angles a non-null array whose length is 3 times the number of channels in the channel
 *    mask.
 *    If the method indicates the configuration is supported, the array will contain upon return
 *    triplets of values: for each channel <code>i</code> among the channels of the mask:
 *    <ul>
 *      <li>the element at index <code>3*i</code> in the array contains the speaker
 *          identification (e.g. {@link android.media.AudioFormat#CHANNEL_OUT_FRONT_LEFT AudioFormat#CHANNEL_OUT_FRONT_LEFT}),</li>
 *      <li>the element at index <code>3*i+1</code> contains its corresponding azimuth angle
 *          expressed in degrees, where 0 is the direction the listener faces, 180 is behind
 *          the listener, and -90 is to her/his left,</li>
 *      <li>the element at index <code>3*i+2</code> contains its corresponding elevation angle
 *          where +90 is directly above the listener, 0 is the horizontal plane, and -90 is
 *          directly below the listener.</li>
 * @return true if the combination of channel mask and virtualization mode is supported, false
 *    otherwise.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 21
 */

public boolean getSpeakerAngles(int inputChannelMask, int virtualizationMode, int[] angles) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Forces the virtualizer effect to use the given processing mode.
 * The effect must be enabled for the forced mode to be applied.
 * @param virtualizationMode one of {@link #VIRTUALIZATION_MODE_BINAURAL},
 *     {@link #VIRTUALIZATION_MODE_TRANSAURAL} to force a particular processing mode, or
 *     {@value #VIRTUALIZATION_MODE_AUTO} to stop forcing a mode.
 * Value is {@link android.media.audiofx.Virtualizer#VIRTUALIZATION_MODE_AUTO}, {@link android.media.audiofx.Virtualizer#VIRTUALIZATION_MODE_BINAURAL}, or {@link android.media.audiofx.Virtualizer#VIRTUALIZATION_MODE_TRANSAURAL}
 * @return true if the processing mode is supported, and it is successfully set, or
 *     forcing was successfully disabled, false otherwise.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 21
 */

public boolean forceVirtualizationMode(int virtualizationMode) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Return the virtualization mode being used, if any.
 * @return the virtualization mode being used.
 *     If virtualization is not active, the virtualization mode will be
 *     {@link #VIRTUALIZATION_MODE_OFF}. Otherwise the value will be
 *     {@link #VIRTUALIZATION_MODE_BINAURAL} or {@link #VIRTUALIZATION_MODE_TRANSAURAL}.
 *     Virtualization may not be active either because the effect is not enabled or
 *     because the current output device is not compatible with this virtualization
 *     implementation.
 * @throws java.lang.IllegalStateException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 21
 */

public int getVirtualizationMode() throws java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Registers an OnParameterChangeListener interface.
 * @param listener OnParameterChangeListener interface registered
 * @apiSince 9
 */

public void setParameterListener(android.media.audiofx.Virtualizer.OnParameterChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Gets the virtualizer properties. This method is useful when a snapshot of current
 * virtualizer settings must be saved by the application.
 * @return a Virtualizer.Settings object containing all current parameters values
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public android.media.audiofx.Virtualizer.Settings getProperties() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Sets the virtualizer properties. This method is useful when virtualizer settings have to
 * be applied from a previous backup.
 * @param settings a Virtualizer.Settings object containing the properties to apply
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setProperties(android.media.audiofx.Virtualizer.Settings settings) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Virtualizer effect strength. Parameter ID for
 * {@link android.media.audiofx.Virtualizer.OnParameterChangeListener}
 * @apiSince 9
 */

public static final int PARAM_STRENGTH = 1; // 0x1

/**
 * Is strength parameter supported by virtualizer engine. Parameter ID for getParameter().
 * @apiSince 9
 */

public static final int PARAM_STRENGTH_SUPPORTED = 0; // 0x0

/**
 * A virtualization mode used to indicate the virtualizer effect must stop forcing the
 * processing to a particular mode in {@link #forceVirtualizationMode(int)}.
 * @apiSince 21
 */

public static final int VIRTUALIZATION_MODE_AUTO = 1; // 0x1

/**
 * A virtualization mode typically used over headphones.
 * Binaural virtualization describes an audio processing configuration for virtualization
 * where the left and right channels are respectively reaching the left and right ear of the
 * user, without also feeding the opposite ear (as is the case when listening over speakers).
 * <p>Such a mode is therefore meant to be used when audio is playing over stereo wired
 * headphones or headsets, but also stereo headphones through a wireless A2DP Bluetooth link.
 * <p>See {@link #canVirtualize(int,int)} to verify this mode is supported by this Virtualizer.
 * @apiSince 21
 */

public static final int VIRTUALIZATION_MODE_BINAURAL = 2; // 0x2

/**
 * A virtualization mode indicating virtualization processing is not active.
 * See {@link #getVirtualizationMode()} as one of the possible return value.
 * @apiSince 21
 */

public static final int VIRTUALIZATION_MODE_OFF = 0; // 0x0

/**
 * A virtualization mode typically used over speakers.
 * Transaural virtualization describes an audio processing configuration that differs from
 * binaural (as described in {@link #VIRTUALIZATION_MODE_BINAURAL} in that cross-talk is
 * present, i.e. audio played from the left channel also reaches the right ear of the user,
 * and vice-versa.
 * <p>When supported, such a mode is therefore meant to be used when audio is playing over the
 * built-in stereo speakers of a device, if they are featured.
 * <p>See {@link #canVirtualize(int,int)} to verify this mode is supported by this Virtualizer.
 * @apiSince 21
 */

public static final int VIRTUALIZATION_MODE_TRANSAURAL = 3; // 0x3
/**
 * The OnParameterChangeListener interface defines a method called by the Virtualizer when a
 * parameter value has changed.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnParameterChangeListener {

/**
 * Method called when a parameter value has changed. The method is called only if the
 * parameter was changed by another application having the control of the same
 * Virtualizer engine.
 * @param effect the Virtualizer on which the interface is registered.
 * @param status status of the set parameter operation.
 * @param param ID of the modified parameter. See {@link #PARAM_STRENGTH} ...
 * @param value the new parameter value.
 * @apiSince 9
 */

public void onParameterChange(android.media.audiofx.Virtualizer effect, int status, int param, short value);
}

/**
 * The Settings class regroups all virtualizer parameters. It is used in
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

public short strength;
}

}

