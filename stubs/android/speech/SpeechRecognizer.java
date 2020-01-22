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


package android.speech;

import android.content.Context;
import android.content.ComponentName;
import android.os.Bundle;

/**
 * This class provides access to the speech recognition service. This service allows access to the
 * speech recognizer. Do not instantiate this class directly, instead, call
 * {@link android.speech.SpeechRecognizer#createSpeechRecognizer(android.content.Context) SpeechRecognizer#createSpeechRecognizer(Context)}. This class's methods must be
 * invoked only from the main application thread.
 *
 * <p>The implementation of this API is likely to stream audio to remote servers to perform speech
 * recognition. As such this API is not intended to be used for continuous recognition, which would
 * consume a significant amount of battery and bandwidth.
 *
 * <p>Please note that the application must have {@link android.Manifest.permission#RECORD_AUDIO}
 * permission to use this class.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SpeechRecognizer {

private SpeechRecognizer() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether a speech recognition service is available on the system. If this method
 * returns {@code false}, {@link android.speech.SpeechRecognizer#createSpeechRecognizer(android.content.Context) SpeechRecognizer#createSpeechRecognizer(Context)} will
 * fail.
 *
 * @param context with which {@code SpeechRecognizer} will be created
 * @return {@code true} if recognition is available, {@code false} otherwise
 * @apiSince 8
 */

public static boolean isRecognitionAvailable(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Factory method to create a new {@code SpeechRecognizer}. Please note that
 * {@link #setRecognitionListener(android.speech.RecognitionListener)} should be called before dispatching any
 * command to the created {@code SpeechRecognizer}, otherwise no notifications will be
 * received.
 *
 * @param context in which to create {@code SpeechRecognizer}
 * @return a new {@code SpeechRecognizer}
 * @apiSince 8
 */

public static android.speech.SpeechRecognizer createSpeechRecognizer(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Factory method to create a new {@code SpeechRecognizer}. Please note that
 * {@link #setRecognitionListener(android.speech.RecognitionListener)} should be called before dispatching any
 * command to the created {@code SpeechRecognizer}, otherwise no notifications will be
 * received.
 *
 * Use this version of the method to specify a specific service to direct this
 * {@link android.speech.SpeechRecognizer SpeechRecognizer} to. Normally you would not use this; use
 * {@link #createSpeechRecognizer(android.content.Context)} instead to use the system default recognition
 * service.
 *
 * @param context in which to create {@code SpeechRecognizer}
 * @param serviceComponent the {@link android.content.ComponentName ComponentName} of a specific service to direct this
 *        {@code SpeechRecognizer} to
 * @return a new {@code SpeechRecognizer}
 * @apiSince 8
 */

public static android.speech.SpeechRecognizer createSpeechRecognizer(android.content.Context context, android.content.ComponentName serviceComponent) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener that will receive all the callbacks. The previous unfinished commands will
 * be executed with the old listener, while any following command will be executed with the new
 * listener.
 *
 * @param listener listener that will receive all the callbacks from the created
 *        {@link android.speech.SpeechRecognizer SpeechRecognizer}, this must not be null.
 * @apiSince 8
 */

public void setRecognitionListener(android.speech.RecognitionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Starts listening for speech. Please note that
 * {@link #setRecognitionListener(android.speech.RecognitionListener)} should be called beforehand, otherwise
 * no notifications will be received.
 *
 * @param recognizerIntent contains parameters for the recognition to be performed. The intent
 *        may also contain optional extras, see {@link android.speech.RecognizerIntent RecognizerIntent}. If these values are
 *        not set explicitly, default values will be used by the recognizer.
 * @apiSince 8
 */

public void startListening(android.content.Intent recognizerIntent) { throw new RuntimeException("Stub!"); }

/**
 * Stops listening for speech. Speech captured so far will be recognized as if the user had
 * stopped speaking at this point. Note that in the default case, this does not need to be
 * called, as the speech endpointer will automatically stop the recognizer listening when it
 * determines speech has completed. However, you can manipulate endpointer parameters directly
 * using the intent extras defined in {@link android.speech.RecognizerIntent RecognizerIntent}, in which case you may sometimes
 * want to manually call this method to stop listening sooner. Please note that
 * {@link #setRecognitionListener(android.speech.RecognitionListener)} should be called beforehand, otherwise
 * no notifications will be received.
 * @apiSince 8
 */

public void stopListening() { throw new RuntimeException("Stub!"); }

/**
 * Cancels the speech recognition. Please note that
 * {@link #setRecognitionListener(android.speech.RecognitionListener)} should be called beforehand, otherwise
 * no notifications will be received.
 * @apiSince 8
 */

public void cancel() { throw new RuntimeException("Stub!"); }

/**
 * Destroys the {@code SpeechRecognizer} object.
 * @apiSince 8
 */

public void destroy() { throw new RuntimeException("Stub!"); }

/**
 * Key used to retrieve a float array from the {@link android.os.Bundle Bundle} passed to the
 * {@link android.speech.RecognitionListener#onResults(android.os.Bundle) RecognitionListener#onResults(Bundle)} and
 * {@link android.speech.RecognitionListener#onPartialResults(android.os.Bundle) RecognitionListener#onPartialResults(Bundle)} methods. The array should be
 * the same size as the ArrayList provided in {@link #RESULTS_RECOGNITION}, and should contain
 * values ranging from 0.0 to 1.0, or -1 to represent an unavailable confidence score.
 * <p>
 * Confidence values close to 1.0 indicate high confidence (the speech recognizer is confident
 * that the recognition result is correct), while values close to 0.0 indicate low confidence.
 * <p>
 * This value is optional and might not be provided.
 * @apiSince 14
 */

public static final java.lang.String CONFIDENCE_SCORES = "confidence_scores";

/**
 * Audio recording error.
 * @apiSince 8
 */

public static final int ERROR_AUDIO = 3; // 0x3

/**
 * Other client side errors.
 * @apiSince 8
 */

public static final int ERROR_CLIENT = 5; // 0x5

/**
 * Insufficient permissions
 * @apiSince 8
 */

public static final int ERROR_INSUFFICIENT_PERMISSIONS = 9; // 0x9

/**
 * Other network related errors.
 * @apiSince 8
 */

public static final int ERROR_NETWORK = 2; // 0x2

/**
 * Network operation timed out.
 * @apiSince 8
 */

public static final int ERROR_NETWORK_TIMEOUT = 1; // 0x1

/**
 * No recognition result matched.
 * @apiSince 8
 */

public static final int ERROR_NO_MATCH = 7; // 0x7

/**
 * RecognitionService busy.
 * @apiSince 8
 */

public static final int ERROR_RECOGNIZER_BUSY = 8; // 0x8

/**
 * Server sends error status.
 * @apiSince 8
 */

public static final int ERROR_SERVER = 4; // 0x4

/**
 * No speech input
 * @apiSince 8
 */

public static final int ERROR_SPEECH_TIMEOUT = 6; // 0x6

/**
 * Key used to retrieve an {@code ArrayList<String>} from the {@link android.os.Bundle Bundle} passed to the
 * {@link android.speech.RecognitionListener#onResults(android.os.Bundle) RecognitionListener#onResults(Bundle)} and
 * {@link android.speech.RecognitionListener#onPartialResults(android.os.Bundle) RecognitionListener#onPartialResults(Bundle)} methods. These strings are the possible
 * recognition results, where the first element is the most likely candidate.
 * @apiSince 8
 */

public static final java.lang.String RESULTS_RECOGNITION = "results_recognition";
}

