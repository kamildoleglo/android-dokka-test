/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.media;


/**
 * This class provides methods to play DTMF tones (ITU-T Recommendation Q.23),
 * call supervisory tones (3GPP TS 22.001, CEPT) and proprietary tones (3GPP TS 31.111).
 * Depending on call state and routing options, tones are mixed to the downlink audio
 * or output to the speaker phone or headset.
 * This API is not for generating tones over the uplink audio path.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ToneGenerator {

/**
 * ToneGenerator class contructor specifying output stream type and volume.
 *
 * @param streamType The streame type used for tone playback (e.g. STREAM_MUSIC).
 * @param volume     The volume of the tone, given in percentage of maximum volume (from 0-100).
 *
 * @apiSince 1
 */

public ToneGenerator(int streamType, int volume) { throw new RuntimeException("Stub!"); }

/**
 * This method starts the playback of a tone of the specified type.
 * only one tone can play at a time: if a tone is playing while this method is called,
 * this tone is stopped and replaced by the one requested.
 * @param toneType   The type of tone generated chosen from the following list:
 * <ul>
 * <li>{@link #TONE_DTMF_0}
 * <li>{@link #TONE_DTMF_1}
 * <li>{@link #TONE_DTMF_2}
 * <li>{@link #TONE_DTMF_3}
 * <li>{@link #TONE_DTMF_4}
 * <li>{@link #TONE_DTMF_5}
 * <li>{@link #TONE_DTMF_6}
 * <li>{@link #TONE_DTMF_7}
 * <li>{@link #TONE_DTMF_8}
 * <li>{@link #TONE_DTMF_9}
 * <li>{@link #TONE_DTMF_A}
 * <li>{@link #TONE_DTMF_B}
 * <li>{@link #TONE_DTMF_C}
 * <li>{@link #TONE_DTMF_D}
 * <li>{@link #TONE_SUP_DIAL}
 * <li>{@link #TONE_SUP_BUSY}
 * <li>{@link #TONE_SUP_CONGESTION}
 * <li>{@link #TONE_SUP_RADIO_ACK}
 * <li>{@link #TONE_SUP_RADIO_NOTAVAIL}
 * <li>{@link #TONE_SUP_ERROR}
 * <li>{@link #TONE_SUP_CALL_WAITING}
 * <li>{@link #TONE_SUP_RINGTONE}
 * <li>{@link #TONE_PROP_BEEP}
 * <li>{@link #TONE_PROP_ACK}
 * <li>{@link #TONE_PROP_NACK}
 * <li>{@link #TONE_PROP_PROMPT}
 * <li>{@link #TONE_PROP_BEEP2}
 * <li>{@link #TONE_SUP_INTERCEPT}
 * <li>{@link #TONE_SUP_INTERCEPT_ABBREV}
 * <li>{@link #TONE_SUP_CONGESTION_ABBREV}
 * <li>{@link #TONE_SUP_CONFIRM}
 * <li>{@link #TONE_SUP_PIP}
 * <li>{@link #TONE_CDMA_DIAL_TONE_LITE}
 * <li>{@link #TONE_CDMA_NETWORK_USA_RINGBACK}
 * <li>{@link #TONE_CDMA_INTERCEPT}
 * <li>{@link #TONE_CDMA_ABBR_INTERCEPT}
 * <li>{@link #TONE_CDMA_REORDER}
 * <li>{@link #TONE_CDMA_ABBR_REORDER}
 * <li>{@link #TONE_CDMA_NETWORK_BUSY}
 * <li>{@link #TONE_CDMA_CONFIRM}
 * <li>{@link #TONE_CDMA_ANSWER}
 * <li>{@link #TONE_CDMA_NETWORK_CALLWAITING}
 * <li>{@link #TONE_CDMA_PIP}
 * <li>{@link #TONE_CDMA_CALL_SIGNAL_ISDN_NORMAL}
 * <li>{@link #TONE_CDMA_CALL_SIGNAL_ISDN_INTERGROUP}
 * <li>{@link #TONE_CDMA_CALL_SIGNAL_ISDN_SP_PRI}
 * <li>{@link #TONE_CDMA_CALL_SIGNAL_ISDN_PAT3}
 * <li>{@link #TONE_CDMA_CALL_SIGNAL_ISDN_PING_RING}
 * <li>{@link #TONE_CDMA_CALL_SIGNAL_ISDN_PAT5}
 * <li>{@link #TONE_CDMA_CALL_SIGNAL_ISDN_PAT6}
 * <li>{@link #TONE_CDMA_CALL_SIGNAL_ISDN_PAT7}
 * <li>{@link #TONE_CDMA_HIGH_L}
 * <li>{@link #TONE_CDMA_MED_L}
 * <li>{@link #TONE_CDMA_LOW_L}
 * <li>{@link #TONE_CDMA_HIGH_SS}
 * <li>{@link #TONE_CDMA_MED_SS}
 * <li>{@link #TONE_CDMA_LOW_SS}
 * <li>{@link #TONE_CDMA_HIGH_SSL}
 * <li>{@link #TONE_CDMA_MED_SSL}
 * <li>{@link #TONE_CDMA_LOW_SSL}
 * <li>{@link #TONE_CDMA_HIGH_SS_2}
 * <li>{@link #TONE_CDMA_MED_SS_2}
 * <li>{@link #TONE_CDMA_LOW_SS_2}
 * <li>{@link #TONE_CDMA_HIGH_SLS}
 * <li>{@link #TONE_CDMA_MED_SLS}
 * <li>{@link #TONE_CDMA_LOW_SLS}
 * <li>{@link #TONE_CDMA_HIGH_S_X4}
 * <li>{@link #TONE_CDMA_MED_S_X4}
 * <li>{@link #TONE_CDMA_LOW_S_X4}
 * <li>{@link #TONE_CDMA_HIGH_PBX_L}
 * <li>{@link #TONE_CDMA_MED_PBX_L}
 * <li>{@link #TONE_CDMA_LOW_PBX_L}
 * <li>{@link #TONE_CDMA_HIGH_PBX_SS}
 * <li>{@link #TONE_CDMA_MED_PBX_SS}
 * <li>{@link #TONE_CDMA_LOW_PBX_SS}
 * <li>{@link #TONE_CDMA_HIGH_PBX_SSL}
 * <li>{@link #TONE_CDMA_MED_PBX_SSL}
 * <li>{@link #TONE_CDMA_LOW_PBX_SSL}
 * <li>{@link #TONE_CDMA_HIGH_PBX_SLS}
 * <li>{@link #TONE_CDMA_MED_PBX_SLS}
 * <li>{@link #TONE_CDMA_LOW_PBX_SLS}
 * <li>{@link #TONE_CDMA_HIGH_PBX_S_X4}
 * <li>{@link #TONE_CDMA_MED_PBX_S_X4}
 * <li>{@link #TONE_CDMA_LOW_PBX_S_X4}
 * <li>{@link #TONE_CDMA_ALERT_NETWORK_LITE}
 * <li>{@link #TONE_CDMA_ALERT_AUTOREDIAL_LITE}
 * <li>{@link #TONE_CDMA_ONE_MIN_BEEP}
 * <li>{@link #TONE_CDMA_KEYPAD_VOLUME_KEY_LITE}
 * <li>{@link #TONE_CDMA_PRESSHOLDKEY_LITE}
 * <li>{@link #TONE_CDMA_ALERT_INCALL_LITE}
 * <li>{@link #TONE_CDMA_EMERGENCY_RINGBACK}
 * <li>{@link #TONE_CDMA_ALERT_CALL_GUARD}
 * <li>{@link #TONE_CDMA_SOFT_ERROR_LITE}
 * <li>{@link #TONE_CDMA_CALLDROP_LITE}
 * <li>{@link #TONE_CDMA_NETWORK_BUSY_ONE_SHOT}
 * <li>{@link #TONE_CDMA_ABBR_ALERT}
 * <li>{@link #TONE_CDMA_SIGNAL_OFF}
 * </ul>
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public boolean startTone(int toneType) { throw new RuntimeException("Stub!"); }

/**
 * This method starts the playback of a tone of the specified type for the specified duration.
 * @param toneType   The type of tone generated @see {@link #startTone(int)}.
 * @param durationMs  The tone duration in milliseconds. If the tone is limited in time by definition,
 * the actual duration will be the minimum of durationMs and the defined tone duration. Setting durationMs to -1,
 * is equivalent to calling {@link #startTone(int)}.
 * @apiSince 5
 */

public native boolean startTone(int toneType, int durationMs);

/**
 * This method stops the tone currently playing playback.
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public native void stopTone();

/**
 * Releases resources associated with this ToneGenerator object. It is good
 * practice to call this method when you're done using the ToneGenerator.
 * @apiSince 1
 */

public native void release();

/**
 * Returns the audio session ID.
 *
 * @return the ID of the audio session this ToneGenerator belongs to or 0 if an error
 * occured.
 * @apiSince 16
 */

public final native int getAudioSessionId();

/** @apiSince 1 */

protected void finalize() { throw new RuntimeException("Stub!"); }

/**
 * Maximum volume, for use with {@link #ToneGenerator(int,int)}
 * @apiSince 1
 */

public static final int MAX_VOLUME = 100; // 0x64

/**
 * Minimum volume setting, for use with {@link #ToneGenerator(int,int)}
 * @apiSince 1
 */

public static final int MIN_VOLUME = 0; // 0x0

/**
 * CDMA_ABBR_ALERT tone: 1150Hz+770Hz 400ms ON
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_ABBR_ALERT = 97; // 0x61

/**
 * CDMA Abbr Intercept tone: 440Hz 250ms ON, 620Hz 250ms ON
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_ABBR_INTERCEPT = 37; // 0x25

/**
 *
 * CDMA Abbr Reorder tone: 480Hz+620Hz 250ms ON, 250ms OFF repeated for 8 times
 * @see #ToneGenerator(int, int)
 @apiSince 4
 */

public static final int TONE_CDMA_ABBR_REORDER = 39; // 0x27

/**
 * CDMA Alert Auto Redial tone: {1245Hz 62ms ON, 659Hz 62ms ON} 3 times,
 * 1245 62ms ON
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_ALERT_AUTOREDIAL_LITE = 87; // 0x57

/**
 * CDMA ALERT CALL GUARD tone: {1319Hz 125ms ON, 125ms OFF} 3 times
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_ALERT_CALL_GUARD = 93; // 0x5d

/**
 * CDMA ALERT INCALL LITE tone: 587Hz 62ms, 784 62ms, 831Hz 62ms,
 * 784Hz 62ms, 1109 62ms, 784Hz 62ms, 831Hz 62ms, 784Hz 62ms
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_ALERT_INCALL_LITE = 91; // 0x5b

/**
 * CDMA Alert Network Lite tone: 1109Hz 62ms ON, 784Hz 62ms ON, 740Hz 62ms ON
 * 622Hz 62ms ON, 1109Hz 62ms ON
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_ALERT_NETWORK_LITE = 86; // 0x56

/**
 *
 * CDMA answer tone: silent tone - defintion Frequency 0, 0ms ON, 0ms OFF
 * @see #ToneGenerator(int, int)
 @apiSince 4
 */

public static final int TONE_CDMA_ANSWER = 42; // 0x2a

/**
 * CDMA CALLDROP LITE tone: 1480Hz 125ms, 1397Hz 125ms, 784Hz 125ms
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_CALLDROP_LITE = 95; // 0x5f

/**
 *  ISDN Call Signal Intergroup tone: {2091Hz 32ms ON, 2556 64ms ON} 8 times,
 * 2091Hz 32ms ON, 400ms OFF, {2091Hz 32ms ON, 2556Hz 64ms ON} times,
 * 2091Hz 32ms ON, 4s OFF.
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_CALL_SIGNAL_ISDN_INTERGROUP = 46; // 0x2e

/**
 *  ISDN Call Signal Normal tone: {2091Hz 32ms ON, 2556 64ms ON} 20 times,
 *  2091 32ms ON, 2556 48ms ON, 4s OFF
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_CALL_SIGNAL_ISDN_NORMAL = 45; // 0x2d

/**
 * ISDN Call sign PAT3 tone: silent tone
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_CALL_SIGNAL_ISDN_PAT3 = 48; // 0x30

/**
 *
 * ISDN Pat5 tone: silent tone
 * @see #ToneGenerator(int, int)
 @apiSince 4
 */

public static final int TONE_CDMA_CALL_SIGNAL_ISDN_PAT5 = 50; // 0x32

/**
 *
 * ISDN Pat6 tone: silent tone
 * @see #ToneGenerator(int, int)
 @apiSince 4
 */

public static final int TONE_CDMA_CALL_SIGNAL_ISDN_PAT6 = 51; // 0x33

/**
 * ISDN Pat7 tone: silent tone
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_CALL_SIGNAL_ISDN_PAT7 = 52; // 0x34

/**
 * ISDN Ping Ring tone: {2091Hz 32ms ON, 2556Hz 64ms ON} 5 times
 * 2091Hz 20ms ON
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_CALL_SIGNAL_ISDN_PING_RING = 49; // 0x31

/**
 * ISDN Call Signal SP PRI tone:{2091Hz 32ms ON, 2556 64ms ON} 4 times
 * 2091Hz 16ms ON, 200ms OFF, {2091Hz 32ms ON, 2556Hz 64ms ON} 4 times,
 * 2091Hz 16ms ON, 200ms OFF
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_CALL_SIGNAL_ISDN_SP_PRI = 47; // 0x2f

/**
 * CDMA Confirm tone: 350Hz+440Hz 100ms ON, 100ms OFF repeated for 3 times
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_CONFIRM = 41; // 0x29

/**
 *  CDMA Dial tone : 425Hz  continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_DIAL_TONE_LITE = 34; // 0x22

/**
 * CDMA EMERGENCY RINGBACK tone: {941Hz 125ms ON, 10ms OFF} 3times
 * 4990ms OFF, REPEAT...
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_EMERGENCY_RINGBACK = 92; // 0x5c

/**
 * TONE_CDMA_HIGH_L tone: {3700Hz 25ms, 4000Hz 25ms} 40 times
 * 4000ms OFF, Repeat ....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_HIGH_L = 53; // 0x35

/**
 * CDMA HIGH PBX L: {3700Hz 25ms, 4000Hz 25ms}20 times,
 * 2000ms OFF,  REPEAT....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_HIGH_PBX_L = 71; // 0x47

/**
 * CDMA HIGH PBX SSL tone:{3700Hz 25ms, 4000Hz 25ms} 8 times
 * 200ms OFF, {3700Hz 25ms, 4000Hz 25ms} 16 times, 200ms OFF,
 * {3700Hz 25ms, 4000Hz 25ms} 8 times, 1000ms OFF, REPEAT....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_HIGH_PBX_SLS = 80; // 0x50

/**
 * CDMA HIGH PBX SS tone: {3700Hz 25ms, 4000Hz 25ms} 8 times
 * 200 ms OFF, {3700Hz 25ms 4000Hz 25ms}8 times,
 * 2000ms OFF, REPEAT....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_HIGH_PBX_SS = 74; // 0x4a

/**
 * CDMA HIGH PBX SSL tone:{3700Hz 25ms, 4000Hz 25ms} 8 times
 * 200ms OFF, {3700Hz 25ms, 4000Hz 25ms} 8 times, 200ms OFF,
 * {3700Hz 25ms, 4000Hz 25ms} 16 times, 1000ms OFF, REPEAT....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_HIGH_PBX_SSL = 77; // 0x4d

/**
 * CDMA HIGH PBX X S4 tone: {3700Hz 25ms 4000Hz 25ms} 8 times,
 * 200ms OFF, {3700Hz 25ms 4000Hz 25ms} 8 times, 200ms OFF,
 * {3700Hz 25ms 4000Hz 25ms} 8 times, 200ms OFF,
 * {3700Hz 25ms 4000Hz 25ms} 8 times, 800ms OFF, REPEAT...
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_HIGH_PBX_S_X4 = 83; // 0x53

/**
 *  CDMA HIGH SLS tone: {3700Hz 25ms, 4000Hz 25ms} 10 times,
 *  500ms OFF, {3700Hz 25ms, 4000Hz 25ms} 20 times, 500ms OFF,
 *  {3700Hz 25ms, 4000Hz 25ms} 10 times, 3000ms OFF, REPEAT
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_HIGH_SLS = 65; // 0x41

/**
 * CDMA HIGH SS tone: {3700Hz 25ms, 4000Hz 25ms} repeat 16 times,
 * 400ms OFF, repeat ....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_HIGH_SS = 56; // 0x38

/**
 * CDMA HIGH SSL tone: {3700Hz 25ms, 4000Hz 25ms} 8 times,
 * 200ms OFF, {3700Hz 25ms, 4000Hz 25ms} repeat 8 times,
 * 200ms OFF, {3700Hz 25ms, 4000Hz 25ms} repeat 16 times,
 * 4000ms OFF, repeat ...
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_HIGH_SSL = 59; // 0x3b

/**
 * CDMA HIGH SS2 tone: {3700Hz 25ms, 4000Hz 25ms} 20 times,
 * 1000ms OFF, {3700Hz 25ms, 4000Hz 25ms} 20 times,
 * 3000ms OFF, repeat ....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_HIGH_SS_2 = 62; // 0x3e

/**
 *  CDMA HIGH S X4 tone: {3700Hz 25ms, 4000Hz 25ms} 10 times,
 *  500ms OFF, {3700Hz 25ms, 4000Hz 25ms} 10 times, 500ms OFF,
 *  {3700Hz 25ms, 4000Hz 25ms} 10 times, 500ms OFF,
 *  {3700Hz 25ms, 4000Hz 25ms} 10 times, 2500ms OFF, REPEAT....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_HIGH_S_X4 = 68; // 0x44

/**
 *  CDMA Intercept tone: 440Hz 250ms ON, 620Hz 250ms ON ...
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_INTERCEPT = 36; // 0x24

/**
 *
 * CDMA KEYPAD Volume key lite tone: 941Hz+1477Hz 120ms ON
 * @see #ToneGenerator(int, int)
 @apiSince 4
 */

public static final int TONE_CDMA_KEYPAD_VOLUME_KEY_LITE = 89; // 0x59

/**
 * TONE_CDMA_LOW_L tone: {1300Hz 25ms, 1450Hz 25ms} 40 times,
 * 4000ms OFF, Repeat ....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_LOW_L = 55; // 0x37

/**
 * CDMA LOW PBX L: {1300Hz 25ms,1450Hz 25ms}20 times,
 * 2000ms OFF,  REPEAT....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_LOW_PBX_L = 73; // 0x49

/**
 * CDMA HIGH PBX SLS tone:{1300Hz 25ms, 1450Hz 25ms} 8 times
 * 200ms OFF, {1300Hz 25ms, 1450Hz 25ms} 16 times, 200ms OFF,
 * {1300Hz 25ms, 1450Hz 25ms} 8 times, 1000ms OFF, REPEAT....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_LOW_PBX_SLS = 82; // 0x52

/**
 * CDMA LOW PBX SS tone: {1300Hz 25ms, 1450Hz 25ms} 8 times
 * 200 ms OFF, {1300Hz 25ms 1450Hz 25ms}8 times,
 * 2000ms OFF, REPEAT....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_LOW_PBX_SS = 76; // 0x4c

/**
 * CDMA LOW PBX SSL tone:{1300Hz 25ms, 1450Hz 25ms} 8 times
 * 200ms OFF, {1300Hz 25ms, 1450Hz 25ms} 8 times, 200ms OFF,
 * {1300Hz 25ms, 1450Hz 25ms} 16 times, 1000ms OFF, REPEAT....
 *
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_LOW_PBX_SSL = 79; // 0x4f

/**
 * CDMA LOW PBX X S4 tone: {1300Hz 25ms 1450Hz 25ms} 8 times,
 * 200ms OFF, {1300Hz 25ms 1450Hz 25ms} 8 times, 200ms OFF,
 * {1300Hz 25ms 1450Hz 25ms} 8 times, 200ms OFF,
 * {1300Hz 25ms 1450Hz 25ms} 8 times, 800ms OFF, REPEAT...
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_LOW_PBX_S_X4 = 85; // 0x55

/**
 *  CDMA LOW SLS tone: {1300Hz 25ms, 1450Hz 25ms} 10 times,
 *  500ms OFF, {1300Hz 25ms, 1450Hz 25ms} 20 times, 500ms OFF,
 *  {1300Hz 25ms, 1450Hz 25ms} 10 times, 3000ms OFF, REPEAT
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_LOW_SLS = 67; // 0x43

/**
 * CDMA LOW SS tone: {1300z 25ms, 1450Hz 25ms} repeat 16 times,
 * 400ms OFF, repeat ....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_LOW_SS = 58; // 0x3a

/**
 * CDMA LOW SSL tone: {1300Hz 25ms, 1450Hz 25ms} 8 times,
 * 200ms OFF, {1300Hz 25ms, 1450Hz 25ms} repeat 8 times,
 * 200ms OFF, {1300Hz 25ms, 1450Hz 25ms} repeat 16 times,
 * 4000ms OFF, repeat ...
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_LOW_SSL = 61; // 0x3d

/**
 * CDMA LOW SS2 tone: {1300Hz 25ms, 1450Hz 25ms} 20 times,
 * 1000ms OFF, {1300Hz 25ms, 1450Hz 25ms} 20 times,
 * 3000ms OFF, repeat ....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_LOW_SS_2 = 64; // 0x40

/**
 *  CDMA LOW  S X4 tone: {2600Hz 25ms, 2900Hz 25ms} 10 times,
 *  500ms OFF, {2600Hz 25ms, 2900Hz 25ms} 10 times, 500ms OFF,
 *  {2600Hz 25ms, 2900Hz 25ms} 10 times, 500ms OFF,
 *  {2600Hz 25ms, 2900Hz 25ms} 10 times, 2500ms OFF, REPEAT....
 *
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_LOW_S_X4 = 70; // 0x46

/**
 * TONE_CDMA_MED_L tone: {2600Hz 25ms, 2900Hz 25ms} 40 times
 * 4000ms OFF, Repeat ....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_MED_L = 54; // 0x36

/**
 *  CDMA MED PBX L: {2600Hz 25ms, 2900Hz 25ms}20 times,
 * 2000ms OFF,  REPEAT....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_MED_PBX_L = 72; // 0x48

/**
 * CDMA HIGH PBX SLS tone:{2600Hz 25ms, 2900Hz 25ms} 8 times
 * 200ms OFF, {2600Hz 25ms, 2900Hz 25ms} 16 times, 200ms OFF,
 * {2600Hz 25ms, 2900Hz 25ms} 8 times, 1000ms OFF, REPEAT....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_MED_PBX_SLS = 81; // 0x51

/**
 * CDMA MED PBX SS tone: {2600Hz 25ms, 2900Hz 25ms} 8 times
 * 200 ms OFF, {2600Hz 25ms 2900Hz 25ms}8 times,
 * 2000ms OFF, REPEAT....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_MED_PBX_SS = 75; // 0x4b

/**
 * CDMA MED PBX SSL tone:{2600Hz 25ms, 2900Hz 25ms} 8 times
 * 200ms OFF, {2600Hz 25ms, 2900Hz 25ms} 8 times, 200ms OFF,
 * {2600Hz 25ms, 2900Hz 25ms} 16 times, 1000ms OFF, REPEAT....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_MED_PBX_SSL = 78; // 0x4e

/**
 * CDMA MED PBX X S4 tone: {2600Hz 25ms 2900Hz 25ms} 8 times,
 * 200ms OFF, {2600Hz 25ms 2900Hz 25ms} 8 times, 200ms OFF,
 * {2600Hz 25ms 2900Hz 25ms} 8 times, 200ms OFF,
 * {2600Hz 25ms 2900Hz 25ms} 8 times, 800ms OFF, REPEAT...
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_MED_PBX_S_X4 = 84; // 0x54

/**
 *  CDMA MED  SLS tone: {2600Hz 25ms, 2900Hz 25ms} 10 times,
 *  500ms OFF, {2600Hz 25ms, 2900Hz 25ms} 20 times, 500ms OFF,
 *  {2600Hz 25ms, 2900Hz 25ms} 10 times, 3000ms OFF, REPEAT
 *
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_MED_SLS = 66; // 0x42

/**
 * CDMA MED SS tone: {2600Hz 25ms, 2900Hz 25ms} repeat 16 times,
 * 400ms OFF, repeat ....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_MED_SS = 57; // 0x39

/**
 * CDMA MED SSL tone: {2600Hz 25ms, 2900Hz 25ms} 8 times,
 * 200ms OFF, {2600Hz 25ms, 2900Hz 25ms} repeat 8 times,
 * 200ms OFF, {2600Hz 25ms, 2900Hz 25ms} repeat 16 times,
 * 4000ms OFF, repeat ...
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_MED_SSL = 60; // 0x3c

/**
 * CDMA MED SS2 tone: {2600Hz 25ms, 2900Hz 25ms} 20 times,
 * 1000ms OFF, {2600Hz 25ms, 2900Hz 25ms} 20 times,
 * 3000ms OFF, repeat ....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_MED_SS_2 = 63; // 0x3f

/**
 *  CDMA MED S X4 tone: {2600Hz 25ms, 2900Hz 25ms} 10 times,
 *  500ms OFF, {2600Hz 25ms, 2900Hz 25ms} 10 times, 500ms OFF,
 *  {2600Hz 25ms, 2900Hz 25ms} 10 times, 500ms OFF,
 *  {2600Hz 25ms, 2900Hz 25ms} 10 times, 2500ms OFF, REPEAT....
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_MED_S_X4 = 69; // 0x45

/**
 * CDMA Network Busy tone: 480Hz+620Hz 500ms ON, 500ms OFF continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_NETWORK_BUSY = 40; // 0x28

/**
 * CDMA_NETWORK_BUSY_ONE_SHOT tone: 425Hz 500ms ON, 500ms OFF.
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_NETWORK_BUSY_ONE_SHOT = 96; // 0x60

/**
 *
 * CDMA Network Callwaiting tone: 440Hz 300ms ON
 * @see #ToneGenerator(int, int)
 @apiSince 4
 */

public static final int TONE_CDMA_NETWORK_CALLWAITING = 43; // 0x2b

/**
 * CDMA USA Ringback: 440Hz+480Hz 2s ON, 4000 OFF ...
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_NETWORK_USA_RINGBACK = 35; // 0x23

/**
 * CDMA One Min Beep tone: 1150Hz+770Hz 400ms ON
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_ONE_MIN_BEEP = 88; // 0x58

/**
 * CDMA PIP tone: 480Hz 100ms ON, 100ms OFF repeated for 4 times
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_PIP = 44; // 0x2c

/**
 * CDMA PRESSHOLDKEY LITE tone: 587Hz 375ms ON, 1175Hz 125ms ON
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_PRESSHOLDKEY_LITE = 90; // 0x5a

/**
 * CDMA Reorder tone: 480Hz+620Hz 250ms ON, 250ms OFF...
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_REORDER = 38; // 0x26

/**
 * CDMA_SIGNAL_OFF - silent tone
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_SIGNAL_OFF = 98; // 0x62

/**
 * CDMA SOFT ERROR LITE  tone: 1047Hz 125ms ON, 370Hz 125ms
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_CDMA_SOFT_ERROR_LITE = 94; // 0x5e

/**
 * DTMF tone for key 0: 1336Hz, 941Hz, continuous</p>
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_DTMF_0 = 0; // 0x0

/**
 * DTMF tone for key 1: 1209Hz, 697Hz, continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_DTMF_1 = 1; // 0x1

/**
 * DTMF tone for key 2: 1336Hz, 697Hz, continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_DTMF_2 = 2; // 0x2

/**
 * DTMF tone for key 3: 1477Hz, 697Hz, continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_DTMF_3 = 3; // 0x3

/**
 * DTMF tone for key 4: 1209Hz, 770Hz, continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_DTMF_4 = 4; // 0x4

/**
 * DTMF tone for key 5: 1336Hz, 770Hz, continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_DTMF_5 = 5; // 0x5

/**
 * DTMF tone for key 6: 1477Hz, 770Hz, continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_DTMF_6 = 6; // 0x6

/**
 * DTMF tone for key 7: 1209Hz, 852Hz, continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_DTMF_7 = 7; // 0x7

/**
 * DTMF tone for key 8: 1336Hz, 852Hz, continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_DTMF_8 = 8; // 0x8

/**
 * DTMF tone for key 9: 1477Hz, 852Hz, continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_DTMF_9 = 9; // 0x9

/**
 * DTMF tone for key A: 1633Hz, 697Hz, continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_DTMF_A = 12; // 0xc

/**
 * DTMF tone for key B: 1633Hz, 770Hz, continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_DTMF_B = 13; // 0xd

/**
 * DTMF tone for key C: 1633Hz, 852Hz, continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_DTMF_C = 14; // 0xe

/**
 * DTMF tone for key D: 1633Hz, 941Hz, continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_DTMF_D = 15; // 0xf

/**
 * DTMF tone for key #: 1477Hz, 941Hz, continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_DTMF_P = 11; // 0xb

/**
 * DTMF tone for key *: 1209Hz, 941Hz, continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_DTMF_S = 10; // 0xa

/**
 * Proprietary tone, positive acknowlegement: 1200Hz, 100ms ON, 100ms OFF 2 bursts
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_PROP_ACK = 25; // 0x19

/**
 * Proprietary tone, general beep: 400Hz+1200Hz, 35ms ON
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_PROP_BEEP = 24; // 0x18

/**
 * Proprietary tone, general double beep: twice 400Hz+1200Hz, 35ms ON, 200ms OFF, 35ms ON
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_PROP_BEEP2 = 28; // 0x1c

/**
 * Proprietary tone, negative acknowlegement: 300Hz+400Hz+500Hz, 400ms ON
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_PROP_NACK = 26; // 0x1a

/**
 * Proprietary tone, prompt tone: 400Hz+1200Hz, 200ms ON
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_PROP_PROMPT = 27; // 0x1b

/**
 * Call supervisory tone, Busy:
 *      CEPT:           425Hz, 500ms ON, 500ms OFF...
 *      ANSI (IS-95):   480Hz+620Hz, 500ms ON, 500ms OFF...
 *      JAPAN:          400Hz, 500ms ON, 500ms OFF...
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_SUP_BUSY = 17; // 0x11

/**
 * Call supervisory tone, Call Waiting:
 *      CEPT, JAPAN:    425Hz, 200ms ON, 600ms OFF, 200ms ON, 3s OFF...
 *      ANSI (IS-95):   440 Hz, 300 ms ON, 9.7 s OFF,
 *                      (100 ms ON, 100 ms OFF, 100 ms ON, 9.7s OFF ...)
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_SUP_CALL_WAITING = 22; // 0x16

/**
 * Call supervisory tone (IS-95), confirm tone: a 350 Hz tone added to a 440 Hz tone
 * repeated 3 times in a 100 ms on, 100 ms off cycle
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_SUP_CONFIRM = 32; // 0x20

/**
 * Call supervisory tone, Congestion:
 *      CEPT, JAPAN:    425Hz, 200ms ON, 200ms OFF...
 *      ANSI (IS-95):   480Hz+620Hz, 250ms ON, 250ms OFF...
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_SUP_CONGESTION = 18; // 0x12

/**
 * Call supervisory tone (IS-95), abbreviated congestion: congestion tone limited to 4 seconds
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_SUP_CONGESTION_ABBREV = 31; // 0x1f

/**
 * Call supervisory tone, Dial tone:
 *      CEPT:           425Hz, continuous
 *      ANSI (IS-95):   350Hz+440Hz, continuous
 *      JAPAN:          400Hz, continuous
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_SUP_DIAL = 16; // 0x10

/**
 * Call supervisory tone, Error/Special info: 950Hz+1400Hz+1800Hz, 330ms ON, 1s OFF...
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_SUP_ERROR = 21; // 0x15

/**
 * Call supervisory tone (IS-95), intercept tone: alternating 440 Hz and 620 Hz tones,
 * each on for 250 ms
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_SUP_INTERCEPT = 29; // 0x1d

/**
 * Call supervisory tone (IS-95), abbreviated intercept: intercept tone limited to 4 seconds
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_SUP_INTERCEPT_ABBREV = 30; // 0x1e

/**
 * Call supervisory tone (IS-95), pip tone: four bursts of 480 Hz tone (0.1 s on, 0.1 s off).
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 4
 */

public static final int TONE_SUP_PIP = 33; // 0x21

/**
 * Call supervisory tone, Radio path acknowlegment :
 *      CEPT, ANSI:    425Hz, 200ms ON
 *      JAPAN:         400Hz, 1s ON, 2s OFF...
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_SUP_RADIO_ACK = 19; // 0x13

/**
 * Call supervisory tone, Radio path not available: 425Hz, 200ms ON, 200 OFF 3 bursts
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_SUP_RADIO_NOTAVAIL = 20; // 0x14

/**
 * Call supervisory tone, Ring Tone:
 *      CEPT, JAPAN:    425Hz, 1s ON, 4s OFF...
 *      ANSI (IS-95):   440Hz + 480Hz, 2s ON, 4s OFF...
 *
 * @see #ToneGenerator(int, int)
 * @apiSince 1
 */

public static final int TONE_SUP_RINGTONE = 23; // 0x17
}

