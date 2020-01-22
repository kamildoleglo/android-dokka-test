/*
 * Copyright (C) 2011 The Android Open Source Project
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


/**
 * Automatic Gain Control (AGC).
 * <p>Automatic Gain Control (AGC) is an audio pre-processor which automatically normalizes the
 * output of the captured signal by boosting or lowering input from the microphone to match a preset
 * level so that the output signal level is virtually constant.
 * AGC can be used by applications where the input signal dynamic range is not important but where
 * a constant strong capture level is desired.
 * <p>An application creates a AutomaticGainControl object to instantiate and control an AGC
 * engine in the audio framework.
 * <p>To attach the AutomaticGainControl to a particular {@link android.media.AudioRecord},
 * specify the audio session ID of this AudioRecord when creating the AutomaticGainControl.
 * The audio session is retrieved by calling
 * {@link android.media.AudioRecord#getAudioSessionId()} on the AudioRecord instance.
 * <p>On some devices, an AGC can be inserted by default in the capture path by the platform
 * according to the {@link android.media.MediaRecorder.AudioSource} used. The application should
 * call AutomaticGainControl.getEnable() after creating the AGC to check the default AGC activation
 * state on a particular AudioRecord session.
 * <p>See {@link android.media.audiofx.AudioEffect} class for more details on
 * controlling audio effects.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AutomaticGainControl extends android.media.audiofx.AudioEffect {

private AutomaticGainControl() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the device implements automatic gain control.
 * @return true if the device implements automatic gain control, false otherwise.
 * @apiSince 16
 */

public static boolean isAvailable() { throw new RuntimeException("Stub!"); }

/**
 * Creates an AutomaticGainControl and attaches it to the AudioRecord on the audio
 * session specified.
 * @param audioSession system wide unique audio session identifier. The AutomaticGainControl
 * will be applied to the AudioRecord with the same audio session.
 * @return AutomaticGainControl created or null if the device does not implement AGC.
 * @apiSince 16
 */

public static android.media.audiofx.AutomaticGainControl create(int audioSession) { throw new RuntimeException("Stub!"); }
}

