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
 * Bass boost is an audio effect to boost or amplify low frequencies of the sound. It is comparable
 * to a simple equalizer but limited to one band amplification in the low frequency range.
 * <p>An application creates a BassBoost object to instantiate and control a bass boost engine in
 * the audio framework.
 * <p>The methods, parameter types and units exposed by the BassBoost implementation are directly
 * mapping those defined by the OpenSL ES 1.0.1 Specification (http://www.khronos.org/opensles/)
 * for the SLBassBoostItf interface. Please refer to this specification for more details.
 * <p>To attach the BassBoost to a particular AudioTrack or MediaPlayer, specify the audio session
 * ID of this AudioTrack or MediaPlayer when constructing the BassBoost.
 * <p>NOTE: attaching a BassBoost to the global audio output mix by use of session 0 is deprecated.
 * <p>See {@link android.media.MediaPlayer#getAudioSessionId()} for details on audio sessions.
 * <p>See {@link android.media.audiofx.AudioEffect} class for more details on
 * controlling audio effects.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BassBoost extends android.media.audiofx.AudioEffect {

/**
 * Class constructor.
 * @param priority the priority level requested by the application for controlling the BassBoost
 * engine. As the same engine can be shared by several applications, this parameter indicates
 * how much the requesting application needs control of effect parameters. The normal priority
 * is 0, above normal is a positive number, below normal a negative number.
 * @param audioSession system wide unique audio session identifier. The BassBoost will be
 * attached to the MediaPlayer or AudioTrack in the same audio session.
 *
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @throws java.lang.RuntimeException
 * @apiSince 9
 */

public BassBoost(int priority, int audioSession) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.RuntimeException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether setting strength is supported. If this method returns false, only one
 * strength is supported and the setStrength() method always rounds to that value.
 * @return true is strength parameter is supported, false otherwise
 * @apiSince 9
 */

public boolean getStrengthSupported() { throw new RuntimeException("Stub!"); }

/**
 * Sets the strength of the bass boost effect. If the implementation does not support per mille
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
 * Registers an OnParameterChangeListener interface.
 * @param listener OnParameterChangeListener interface registered
 * @apiSince 9
 */

public void setParameterListener(android.media.audiofx.BassBoost.OnParameterChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Gets the bass boost properties. This method is useful when a snapshot of current
 * bass boost settings must be saved by the application.
 * @return a BassBoost.Settings object containing all current parameters values
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public android.media.audiofx.BassBoost.Settings getProperties() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Sets the bass boost properties. This method is useful when bass boost settings have to
 * be applied from a previous backup.
 * @param settings a BassBoost.Settings object containing the properties to apply
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 9
 */

public void setProperties(android.media.audiofx.BassBoost.Settings settings) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Bass boost effect strength. Parameter ID for
 * {@link android.media.audiofx.BassBoost.OnParameterChangeListener}
 * @apiSince 9
 */

public static final int PARAM_STRENGTH = 1; // 0x1

/**
 * Is strength parameter supported by bass boost engine. Parameter ID for getParameter().
 * @apiSince 9
 */

public static final int PARAM_STRENGTH_SUPPORTED = 0; // 0x0
/**
 * The OnParameterChangeListener interface defines a method called by the BassBoost when a
 * parameter value has changed.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnParameterChangeListener {

/**
 * Method called when a parameter value has changed. The method is called only if the
 * parameter was changed by another application having the control of the same
 * BassBoost engine.
 * @param effect the BassBoost on which the interface is registered.
 * @param status status of the set parameter operation.
 * @param param ID of the modified parameter. See {@link #PARAM_STRENGTH} ...
 * @param value the new parameter value.
 * @apiSince 9
 */

public void onParameterChange(android.media.audiofx.BassBoost effect, int status, int param, short value);
}

/**
 * The Settings class regroups all bass boost parameters. It is used in
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

