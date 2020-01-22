// Copyright 2011 Google Inc. All Rights Reserved.


package android.speech.tts;

import android.media.AudioFormat;

/**
 * Listener for events relating to the progress of an utterance through
 * the synthesis queue. Each utterance is associated with a call to
 * {@link android.speech.tts.TextToSpeech#speak TextToSpeech#speak} or {@link android.speech.tts.TextToSpeech#synthesizeToFile TextToSpeech#synthesizeToFile} with an
 * associated utterance identifier, as per {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID}.
 *
 * The callbacks specified in this method can be called from multiple threads.
 * @apiSince 15
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class UtteranceProgressListener {

public UtteranceProgressListener() { throw new RuntimeException("Stub!"); }

/**
 * Called when an utterance "starts" as perceived by the caller. This will
 * be soon before audio is played back in the case of a {@link android.speech.tts.TextToSpeech#speak TextToSpeech#speak}
 * or before the first bytes of a file are written to the file system in the case
 * of {@link android.speech.tts.TextToSpeech#synthesizeToFile TextToSpeech#synthesizeToFile}.
 *
 * @param utteranceId The utterance ID of the utterance.
 * @apiSince 15
 */

public abstract void onStart(java.lang.String utteranceId);

/**
 * Called when an utterance has successfully completed processing.
 * All audio will have been played back by this point for audible output, and all
 * output will have been written to disk for file synthesis requests.
 *
 * This request is guaranteed to be called after {@link #onStart(java.lang.String)}.
 *
 * @param utteranceId The utterance ID of the utterance.
 * @apiSince 15
 */

public abstract void onDone(java.lang.String utteranceId);

/**
 * Called when an error has occurred during processing. This can be called
 * at any point in the synthesis process. Note that there might be calls
 * to {@link #onStart(java.lang.String)} for specified utteranceId but there will never
 * be a call to both {@link #onDone(java.lang.String)} and {@link #onError(java.lang.String)} for
 * the same utterance.
 *
 * @param utteranceId The utterance ID of the utterance.
 * @deprecated Use {@link #onError(java.lang.String,int)} instead
 * @apiSince 15
 * @deprecatedSince 21
 */

@Deprecated
public abstract void onError(java.lang.String utteranceId);

/**
 * Called when an error has occurred during processing. This can be called
 * at any point in the synthesis process. Note that there might be calls
 * to {@link #onStart(java.lang.String)} for specified utteranceId but there will never
 * be a call to both {@link #onDone(java.lang.String)} and {@link #onError(java.lang.String,int)} for
 * the same utterance. The default implementation calls {@link #onError(java.lang.String)}.
 *
 * @param utteranceId The utterance ID of the utterance.
 * @param errorCode one of the ERROR_* codes from {@link android.speech.tts.TextToSpeech TextToSpeech}
 * @apiSince 21
 */

public void onError(java.lang.String utteranceId, int errorCode) { throw new RuntimeException("Stub!"); }

/**
 * Called when an utterance has been stopped while in progress or flushed from the
 * synthesis queue. This can happen if a client calls {@link android.speech.tts.TextToSpeech#stop() TextToSpeech#stop()}
 * or uses {@link android.speech.tts.TextToSpeech#QUEUE_FLUSH TextToSpeech#QUEUE_FLUSH} as an argument with the
 * {@link android.speech.tts.TextToSpeech#speak TextToSpeech#speak} or {@link android.speech.tts.TextToSpeech#synthesizeToFile TextToSpeech#synthesizeToFile} methods.
 *
 * @param utteranceId The utterance ID of the utterance.
 * @param interrupted If true, then the utterance was interrupted while being synthesized
 *        and its output is incomplete. If false, then the utterance was flushed
 *        before the synthesis started.
 * @apiSince 23
 */

public void onStop(java.lang.String utteranceId, boolean interrupted) { throw new RuntimeException("Stub!"); }

/**
 * Called when the TTS engine begins to synthesize the audio for a request.
 *
 * <p>
 * It provides information about the format of the byte array for subsequent
 * {@link #onAudioAvailable} calls.
 * </p>
 *
 * <p>
 * This is called when the TTS engine starts synthesizing audio for the request. If an
 * application wishes to know when the audio is about to start playing, {#onStart(String)}
 * should be used instead.
 * </p>
 *
 * @param utteranceId The utterance ID of the utterance.
 * @param sampleRateInHz Sample rate in hertz of the generated audio.
 * @param audioFormat Audio format of the generated audio. Should be one of
 *        {@link android.media.AudioFormat#ENCODING_PCM_8BIT AudioFormat#ENCODING_PCM_8BIT}, {@link android.media.AudioFormat#ENCODING_PCM_16BIT AudioFormat#ENCODING_PCM_16BIT} or
 *        {@link android.media.AudioFormat#ENCODING_PCM_FLOAT AudioFormat#ENCODING_PCM_FLOAT}.
 * @param channelCount The number of channels.
 * @apiSince 24
 */

public void onBeginSynthesis(java.lang.String utteranceId, int sampleRateInHz, int audioFormat, int channelCount) { throw new RuntimeException("Stub!"); }

/**
 * This is called when a chunk of audio is ready for consumption.
 *
 * <p>
 * The audio parameter is a copy of what will be synthesized to the speakers (when synthesis was
 * initiated with a {@link android.speech.tts.TextToSpeech#speak TextToSpeech#speak} call) or written to the file system (for
 * {@link android.speech.tts.TextToSpeech#synthesizeToFile TextToSpeech#synthesizeToFile}). The audio bytes are delivered in one or more chunks;
 * if {@link #onDone} or {@link #onError} is called all chunks have been received.
 * </p>
 *
 * <p>
 * The audio received here may not be played for some time depending on buffer sizes and the
 * amount of items on the synthesis queue.
 * </p>
 *
 * @param utteranceId The utterance ID of the utterance.
 * @param audio A chunk of audio; the format can be known by listening to
 *        {@link #onBeginSynthesis(java.lang.String,int,int,int)}.
 * @apiSince 24
 */

public void onAudioAvailable(java.lang.String utteranceId, byte[] audio) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the TTS service is about to speak the specified range of the utterance
 * with the given utteranceId.
 *
 * <p>This method is called when the audio is expected to start playing on the speaker. Note
 * that this is different from {@link #onAudioAvailable} which is called as soon as the audio is
 * generated.
 
 * <p>This information can be used, for example, to highlight ranges of the text while it is
 * spoken.
 *
 * <p>Only called if the engine supplies timing information by calling {@link android.speech.tts.SynthesisCallback#rangeStart(int,int,int) SynthesisCallback#rangeStart(int, int, int)}.
 *
 * @param utteranceId Unique id identifying the synthesis request.
 * @param start The start index of the range in the utterance text.
 * @param end The end index of the range (exclusive) in the utterance text.
 * @param frame The position in frames in the audio of the request where this range is spoken.
 * @apiSince 26
 */

public void onRangeStart(java.lang.String utteranceId, int start, int end, int frame) { throw new RuntimeException("Stub!"); }
}

