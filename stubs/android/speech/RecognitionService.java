/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


package android.speech;

import android.content.Intent;
import android.os.Bundle;
import android.os.Binder;

/**
 * This class provides a base class for recognition service implementations. This class should be
 * extended only in case you wish to implement a new speech recognizer. Please note that the
 * implementation of this service is stateless.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class RecognitionService extends android.app.Service {

public RecognitionService() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the service that it should start listening for speech.
 *
 * @param recognizerIntent contains parameters for the recognition to be performed. The intent
 *        may also contain optional extras, see {@link android.speech.RecognizerIntent RecognizerIntent}. If these values are
 *        not set explicitly, default values should be used by the recognizer.
 * @param listener that will receive the service's callbacks
 * @apiSince 8
 */

protected abstract void onStartListening(android.content.Intent recognizerIntent, android.speech.RecognitionService.Callback listener);

/**
 * Notifies the service that it should cancel the speech recognition.
 * @apiSince 8
 */

protected abstract void onCancel(android.speech.RecognitionService.Callback listener);

/**
 * Notifies the service that it should stop listening for speech. Speech captured so far should
 * be recognized as if the user had stopped speaking at this point. This method is only called
 * if the application calls it explicitly.
 * @apiSince 8
 */

protected abstract void onStopListening(android.speech.RecognitionService.Callback listener);

/** @apiSince 8 */

public final android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void onDestroy() { throw new RuntimeException("Stub!"); }

/**
 * The {@link android.content.Intent Intent} that must be declared as handled by the service.
 * @apiSince 8
 */

public static final java.lang.String SERVICE_INTERFACE = "android.speech.RecognitionService";

/**
 * Name under which a RecognitionService component publishes information about itself.
 * This meta-data should reference an XML resource containing a
 * <code>&lt;{@link android.R.styleable#RecognitionService recognition-service}&gt;</code> tag.
 * @apiSince 8
 */

public static final java.lang.String SERVICE_META_DATA = "android.speech";
/**
 * This class receives callbacks from the speech recognition service and forwards them to the
 * user. An instance of this class is passed to the
 * {@link android.speech.RecognitionService#onStartListening(android.content.Intent,android.speech.RecognitionService.Callback) RecognitionService#onStartListening(Intent, Callback)} method. Recognizers may call
 * these methods on any thread.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Callback {

private Callback() { throw new RuntimeException("Stub!"); }

/**
 * The service should call this method when the user has started to speak.
 * @apiSince 8
 */

public void beginningOfSpeech() throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * The service should call this method when sound has been received. The purpose of this
 * function is to allow giving feedback to the user regarding the captured audio.
 *
 * @param buffer a buffer containing a sequence of big-endian 16-bit integers representing a
 *        single channel audio stream. The sample rate is implementation dependent.
 * @apiSince 8
 */

public void bufferReceived(byte[] buffer) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * The service should call this method after the user stops speaking.
 * @apiSince 8
 */

public void endOfSpeech() throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * The service should call this method when a network or recognition error occurred.
 *
 * @param error code is defined in {@link android.speech.SpeechRecognizer SpeechRecognizer}
 * @apiSince 8
 */

public void error(int error) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * The service should call this method when partial recognition results are available. This
 * method can be called at any time between {@link #beginningOfSpeech()} and
 * {@link #results(android.os.Bundle)} when partial results are ready. This method may be called zero,
 * one or multiple times for each call to {@link android.speech.SpeechRecognizer#startListening(android.content.Intent) SpeechRecognizer#startListening(Intent)},
 * depending on the speech recognition service implementation.
 *
 * @param partialResults the returned results. To retrieve the results in
 *        ArrayList&lt;String&gt; format use {@link android.os.Bundle#getStringArrayList(java.lang.String) Bundle#getStringArrayList(String)} with
 *        {@link android.speech.SpeechRecognizer#RESULTS_RECOGNITION SpeechRecognizer#RESULTS_RECOGNITION} as a parameter
 * @apiSince 8
 */

public void partialResults(android.os.Bundle partialResults) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * The service should call this method when the endpointer is ready for the user to start
 * speaking.
 *
 * @param params parameters set by the recognition service. Reserved for future use.
 * @apiSince 8
 */

public void readyForSpeech(android.os.Bundle params) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * The service should call this method when recognition results are ready.
 *
 * @param results the recognition results. To retrieve the results in {@code
 *        ArrayList<String>} format use {@link android.os.Bundle#getStringArrayList(java.lang.String) Bundle#getStringArrayList(String)} with
 *        {@link android.speech.SpeechRecognizer#RESULTS_RECOGNITION SpeechRecognizer#RESULTS_RECOGNITION} as a parameter
 * @apiSince 8
 */

public void results(android.os.Bundle results) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * The service should call this method when the sound level in the audio stream has changed.
 * There is no guarantee that this method will be called.
 *
 * @param rmsdB the new RMS dB value
 * @apiSince 8
 */

public void rmsChanged(float rmsdB) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * Return the Linux uid assigned to the process that sent you the current transaction that
 * is being processed. This is obtained from {@link android.os.Binder#getCallingUid() Binder#getCallingUid()}.
 * @apiSince 23
 */

public int getCallingUid() { throw new RuntimeException("Stub!"); }
}

}

