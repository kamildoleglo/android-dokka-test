/**
 * Copyright (C) 2014 The Android Open Source Project
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


package android.service.voice;

import android.app.Activity;
import android.content.Intent;

/**
 * A class that lets a VoiceInteractionService implementation interact with
 * always-on keyphrase detection APIs.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AlwaysOnHotwordDetector {

AlwaysOnHotwordDetector() { throw new RuntimeException("Stub!"); }

/**
 * Gets the recognition modes supported by the associated keyphrase.
 *
 * @see #RECOGNITION_MODE_USER_IDENTIFICATION
 * @see #RECOGNITION_MODE_VOICE_TRIGGER
 *
 * @throws java.lang.UnsupportedOperationException if the keyphrase itself isn't supported.
 *         Callers should only call this method after a supported state callback on
 *         {@link android.service.voice.AlwaysOnHotwordDetector.Callback#onAvailabilityChanged(int) Callback#onAvailabilityChanged(int)} to avoid this exception.
 * @throws java.lang.IllegalStateException if the detector is in an invalid state.
 *         This may happen if another detector has been instantiated or the
 *         {@link android.service.voice.VoiceInteractionService VoiceInteractionService} hosting this detector has been shut down.
 
 * @return Value is either <code>0</code> or a combination of {@link android.service.voice.AlwaysOnHotwordDetector#RECOGNITION_MODE_VOICE_TRIGGER}, and {@link android.service.voice.AlwaysOnHotwordDetector#RECOGNITION_MODE_USER_IDENTIFICATION}
 * @apiSince 21
 */

public int getSupportedRecognitionModes() { throw new RuntimeException("Stub!"); }

/**
 * Starts recognition for the associated keyphrase.
 *
 * @see #RECOGNITION_FLAG_CAPTURE_TRIGGER_AUDIO
 * @see #RECOGNITION_FLAG_ALLOW_MULTIPLE_TRIGGERS
 *
 * @param recognitionFlags The flags to control the recognition properties.
 * Value is either <code>0</code> or a combination of android.service.voice.AlwaysOnHotwordDetector.RECOGNITION_FLAG_NONE, {@link android.service.voice.AlwaysOnHotwordDetector#RECOGNITION_FLAG_CAPTURE_TRIGGER_AUDIO}, and {@link android.service.voice.AlwaysOnHotwordDetector#RECOGNITION_FLAG_ALLOW_MULTIPLE_TRIGGERS}
 * @return Indicates whether the call succeeded or not.
 * @throws java.lang.UnsupportedOperationException if the recognition isn't supported.
 *         Callers should only call this method after a supported state callback on
 *         {@link android.service.voice.AlwaysOnHotwordDetector.Callback#onAvailabilityChanged(int) Callback#onAvailabilityChanged(int)} to avoid this exception.
 * @throws java.lang.IllegalStateException if the detector is in an invalid state.
 *         This may happen if another detector has been instantiated or the
 *         {@link android.service.voice.VoiceInteractionService VoiceInteractionService} hosting this detector has been shut down.
 * @apiSince 21
 */

public boolean startRecognition(int recognitionFlags) { throw new RuntimeException("Stub!"); }

/**
 * Stops recognition for the associated keyphrase.
 *
 * @return Indicates whether the call succeeded or not.
 * @throws java.lang.UnsupportedOperationException if the recognition isn't supported.
 *         Callers should only call this method after a supported state callback on
 *         {@link android.service.voice.AlwaysOnHotwordDetector.Callback#onAvailabilityChanged(int) Callback#onAvailabilityChanged(int)} to avoid this exception.
 * @throws java.lang.IllegalStateException if the detector is in an invalid state.
 *         This may happen if another detector has been instantiated or the
 *         {@link android.service.voice.VoiceInteractionService VoiceInteractionService} hosting this detector has been shut down.
 * @apiSince 21
 */

public boolean stopRecognition() { throw new RuntimeException("Stub!"); }

/**
 * Creates an intent to start the enrollment for the associated keyphrase.
 * This intent must be invoked using {@link android.app.Activity#startActivityForResult(android.content.Intent,int) Activity#startActivityForResult(Intent, int)}.
 * Starting re-enrollment is only valid if the keyphrase is un-enrolled,
 * i.e. {@link #STATE_KEYPHRASE_UNENROLLED},
 * otherwise {@link #createReEnrollIntent()} should be preferred.
 *
 * @return An {@link android.content.Intent Intent} to start enrollment for the given keyphrase.
 * @throws java.lang.UnsupportedOperationException if managing they keyphrase isn't supported.
 *         Callers should only call this method after a supported state callback on
 *         {@link android.service.voice.AlwaysOnHotwordDetector.Callback#onAvailabilityChanged(int) Callback#onAvailabilityChanged(int)} to avoid this exception.
 * @throws java.lang.IllegalStateException if the detector is in an invalid state.
 *         This may happen if another detector has been instantiated or the
 *         {@link android.service.voice.VoiceInteractionService VoiceInteractionService} hosting this detector has been shut down.
 * @apiSince 21
 */

public android.content.Intent createEnrollIntent() { throw new RuntimeException("Stub!"); }

/**
 * Creates an intent to start the un-enrollment for the associated keyphrase.
 * This intent must be invoked using {@link android.app.Activity#startActivityForResult(android.content.Intent,int) Activity#startActivityForResult(Intent, int)}.
 * Starting re-enrollment is only valid if the keyphrase is already enrolled,
 * i.e. {@link #STATE_KEYPHRASE_ENROLLED}, otherwise invoking this may result in an error.
 *
 * @return An {@link android.content.Intent Intent} to start un-enrollment for the given keyphrase.
 * @throws java.lang.UnsupportedOperationException if managing they keyphrase isn't supported.
 *         Callers should only call this method after a supported state callback on
 *         {@link android.service.voice.AlwaysOnHotwordDetector.Callback#onAvailabilityChanged(int) Callback#onAvailabilityChanged(int)} to avoid this exception.
 * @throws java.lang.IllegalStateException if the detector is in an invalid state.
 *         This may happen if another detector has been instantiated or the
 *         {@link android.service.voice.VoiceInteractionService VoiceInteractionService} hosting this detector has been shut down.
 * @apiSince 21
 */

public android.content.Intent createUnEnrollIntent() { throw new RuntimeException("Stub!"); }

/**
 * Creates an intent to start the re-enrollment for the associated keyphrase.
 * This intent must be invoked using {@link android.app.Activity#startActivityForResult(android.content.Intent,int) Activity#startActivityForResult(Intent, int)}.
 * Starting re-enrollment is only valid if the keyphrase is already enrolled,
 * i.e. {@link #STATE_KEYPHRASE_ENROLLED}, otherwise invoking this may result in an error.
 *
 * @return An {@link android.content.Intent Intent} to start re-enrollment for the given keyphrase.
 * @throws java.lang.UnsupportedOperationException if managing they keyphrase isn't supported.
 *         Callers should only call this method after a supported state callback on
 *         {@link android.service.voice.AlwaysOnHotwordDetector.Callback#onAvailabilityChanged(int) Callback#onAvailabilityChanged(int)} to avoid this exception.
 * @throws java.lang.IllegalStateException if the detector is in an invalid state.
 *         This may happen if another detector has been instantiated or the
 *         {@link android.service.voice.VoiceInteractionService VoiceInteractionService} hosting this detector has been shut down.
 * @apiSince 21
 */

public android.content.Intent createReEnrollIntent() { throw new RuntimeException("Stub!"); }

/**
 * Recognition flag for {@link #startRecognition(int)} that indicates
 * whether the recognition should keep going on even after the keyphrase triggers.
 * If this flag is specified, it's possible to get multiple triggers after a
 * call to {@link #startRecognition(int)} if the user speaks the keyphrase multiple times.
 * When this isn't specified, the default behavior is to stop recognition once the
 * keyphrase is spoken, till the caller starts recognition again.
 * @apiSince 21
 */

public static final int RECOGNITION_FLAG_ALLOW_MULTIPLE_TRIGGERS = 2; // 0x2

/**
 * Recognition flag for {@link #startRecognition(int)} that indicates
 * whether the trigger audio for hotword needs to be captured.
 * @apiSince 21
 */

public static final int RECOGNITION_FLAG_CAPTURE_TRIGGER_AUDIO = 1; // 0x1

/**
 * User identification performed with the keyphrase recognition.
 * Returned by {@link #getSupportedRecognitionModes()}
 * @apiSince 21
 */

public static final int RECOGNITION_MODE_USER_IDENTIFICATION = 2; // 0x2

/**
 * Simple recognition of the key phrase.
 * Returned by {@link #getSupportedRecognitionModes()}
 * @apiSince 21
 */

public static final int RECOGNITION_MODE_VOICE_TRIGGER = 1; // 0x1

/**
 * Indicates that recognition for the given keyphrase is not available on the system
 * because of the hardware configuration.
 * No further interaction should be performed with the detector that returns this availability.
 * @apiSince 21
 */

public static final int STATE_HARDWARE_UNAVAILABLE = -2; // 0xfffffffe

/**
 * Indicates that the given keyphrase is currently enrolled and it's possible to start
 * recognition for it.
 * @apiSince 21
 */

public static final int STATE_KEYPHRASE_ENROLLED = 2; // 0x2

/**
 * Indicates that the given keyphrase is not enrolled.
 * The caller may choose to begin an enrollment flow for the keyphrase.
 * @apiSince 21
 */

public static final int STATE_KEYPHRASE_UNENROLLED = 1; // 0x1

/**
 * Indicates that recognition for the given keyphrase is not supported.
 * No further interaction should be performed with the detector that returns this availability.
 * @apiSince 21
 */

public static final int STATE_KEYPHRASE_UNSUPPORTED = -1; // 0xffffffff
/**
 * Callbacks for always-on hotword detection.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Called when the hotword availability changes.
 * This indicates a change in the availability of recognition for the given keyphrase.
 * It's called at least once with the initial availability.<p/>
 *
 * Availability implies whether the hardware on this system is capable of listening for
 * the given keyphrase or not. <p/>
 *
 * @see android.service.voice.AlwaysOnHotwordDetector#STATE_HARDWARE_UNAVAILABLE
 * @see android.service.voice.AlwaysOnHotwordDetector#STATE_KEYPHRASE_UNSUPPORTED
 * @see android.service.voice.AlwaysOnHotwordDetector#STATE_KEYPHRASE_UNENROLLED
 * @see android.service.voice.AlwaysOnHotwordDetector#STATE_KEYPHRASE_ENROLLED
 * @apiSince 21
 */

public abstract void onAvailabilityChanged(int status);

/**
 * Called when the keyphrase is spoken.
 * This implicitly stops listening for the keyphrase once it's detected.
 * Clients should start a recognition again once they are done handling this
 * detection.
 *
 * @param eventPayload Payload data for the detection event.
 *        This may contain the trigger audio, if requested when calling
 *        {@link android.service.voice.AlwaysOnHotwordDetector#startRecognition(int) AlwaysOnHotwordDetector#startRecognition(int)}.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public abstract void onDetected(@androidx.annotation.NonNull android.service.voice.AlwaysOnHotwordDetector.EventPayload eventPayload);

/**
 * Called when the detection fails due to an error.
 * @apiSince 21
 */

public abstract void onError();

/**
 * Called when the recognition is paused temporarily for some reason.
 * This is an informational callback, and the clients shouldn't be doing anything here
 * except showing an indication on their UI if they have to.
 * @apiSince 21
 */

public abstract void onRecognitionPaused();

/**
 * Called when the recognition is resumed after it was temporarily paused.
 * This is an informational callback, and the clients shouldn't be doing anything here
 * except showing an indication on their UI if they have to.
 * @apiSince 21
 */

public abstract void onRecognitionResumed();
}

/**
 * Additional payload for {@link android.service.voice.AlwaysOnHotwordDetector.Callback#onDetected Callback#onDetected}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class EventPayload {

private EventPayload() { throw new RuntimeException("Stub!"); }

/**
 * Gets the format of the audio obtained using {@link #getTriggerAudio()}.
 * May be null if there's no audio present.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.media.AudioFormat getCaptureAudioFormat() { throw new RuntimeException("Stub!"); }

/**
 * Gets the raw audio that triggered the keyphrase.
 * This may be null if the trigger audio isn't available.
 * If non-null, the format of the audio can be obtained by calling
 * {@link #getCaptureAudioFormat()}.
 *
 * @see android.service.voice.AlwaysOnHotwordDetector#RECOGNITION_FLAG_CAPTURE_TRIGGER_AUDIO
 * @apiSince 21
 */

@androidx.annotation.Nullable
public byte[] getTriggerAudio() { throw new RuntimeException("Stub!"); }
}

}

