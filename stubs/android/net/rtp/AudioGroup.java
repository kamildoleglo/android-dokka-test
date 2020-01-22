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


package android.net.rtp;

import android.media.AudioManager;
import android.content.Context;

/**
 * An AudioGroup is an audio hub for the speaker, the microphone, and
 * {@link android.net.rtp.AudioStream AudioStream}s. Each of these components can be logically turned on
 * or off by calling {@link #setMode(int)} or {@link android.net.rtp.RtpStream#setMode(int) RtpStream#setMode(int)}.
 * The AudioGroup will go through these components and process them one by one
 * within its execution loop. The loop consists of four steps. First, for each
 * AudioStream not in {@link android.net.rtp.RtpStream#MODE_SEND_ONLY RtpStream#MODE_SEND_ONLY}, decodes its incoming
 * packets and stores in its buffer. Then, if the microphone is enabled,
 * processes the recorded audio and stores in its buffer. Third, if the speaker
 * is enabled, mixes all AudioStream buffers and plays back. Finally, for each
 * AudioStream not in {@link android.net.rtp.RtpStream#MODE_RECEIVE_ONLY RtpStream#MODE_RECEIVE_ONLY}, mixes all other
 * buffers and sends back the encoded packets. An AudioGroup does nothing if
 * there is no AudioStream in it.
 *
 * <p>Few things must be noticed before using these classes. The performance is
 * highly related to the system load and the network bandwidth. Usually a
 * simpler {@link android.net.rtp.AudioCodec AudioCodec} costs fewer CPU cycles but requires more network
 * bandwidth, and vise versa. Using two AudioStreams at the same time doubles
 * not only the load but also the bandwidth. The condition varies from one
 * device to another, and developers should choose the right combination in
 * order to get the best result.</p>
 *
 * <p>It is sometimes useful to keep multiple AudioGroups at the same time. For
 * example, a Voice over IP (VoIP) application might want to put a conference
 * call on hold in order to make a new call but still allow people in the
 * conference call talking to each other. This can be done easily using two
 * AudioGroups, but there are some limitations. Since the speaker and the
 * microphone are globally shared resources, only one AudioGroup at a time is
 * allowed to run in a mode other than {@link #MODE_ON_HOLD}. The others will
 * be unable to acquire these resources and fail silently.</p>
 *
 * <p class="note">Using this class requires
 * {@link android.Manifest.permission#RECORD_AUDIO} permission. Developers
 * should set the audio mode to {@link android.media.AudioManager#MODE_IN_COMMUNICATION AudioManager#MODE_IN_COMMUNICATION}
 * using {@link android.media.AudioManager#setMode(int) AudioManager#setMode(int)} and change it back when none of
 * the AudioGroups is in use.</p>
 *
 * @see android.net.rtp.AudioStream
 * @apiSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AudioGroup {

/**
 * Creates an empty AudioGroup.
 * @deprecated Replaced by {@link #AudioGroup(android.content.Context)}
 * @apiSince 12
 */

@Deprecated
public AudioGroup() { throw new RuntimeException("Stub!"); }

/**
 * Creates an empty AudioGroup.
 * @param context Context used to get package name. If context is null, app ops checks will
 * fail and as a result {@link android.net.rtp.AudioStream#join(android.net.rtp.AudioGroup) AudioStream#join(AudioGroup)} may fail.
 
 * This value may be {@code null}.
 * @apiSince R
 */

public AudioGroup(@androidx.annotation.Nullable android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.net.rtp.AudioStream AudioStream}s in this group.
 * @apiSince 12
 */

public android.net.rtp.AudioStream[] getStreams() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current mode.
 * @apiSince 12
 */

public int getMode() { throw new RuntimeException("Stub!"); }

/**
 * Changes the current mode. It must be one of {@link #MODE_ON_HOLD},
 * {@link #MODE_MUTED}, {@link #MODE_NORMAL}, and
 * {@link #MODE_ECHO_SUPPRESSION}.
 *
 * @param mode The mode to change to.
 * @throws java.lang.IllegalArgumentException if the mode is invalid.
 * @apiSince 12
 */

public void setMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Sends a DTMF digit to every {@link android.net.rtp.AudioStream AudioStream} in this group. Currently
 * only event {@code 0} to {@code 15} are supported.
 *
 * @throws java.lang.IllegalArgumentException if the event is invalid.
 * @apiSince 12
 */

public void sendDtmf(int event) { throw new RuntimeException("Stub!"); }

/**
 * Removes every {@link android.net.rtp.AudioStream AudioStream} in this group.
 * @apiSince 12
 */

public void clear() { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * This mode is similar to {@link #MODE_NORMAL} except the echo suppression
 * is enabled. It should be only used when the speaker phone is on.
 * @apiSince 12
 */

public static final int MODE_ECHO_SUPPRESSION = 3; // 0x3

/**
 * This mode is similar to {@link #MODE_NORMAL} except the microphone is
 * disabled.
 * @apiSince 12
 */

public static final int MODE_MUTED = 1; // 0x1

/**
 * This mode indicates that the speaker, the microphone, and all
 * {@link android.net.rtp.AudioStream AudioStream}s in the group are enabled. First, the packets
 * received from the streams are decoded and mixed with the audio recorded
 * from the microphone. Then, the results are played back to the speaker,
 * encoded and sent back to each stream.
 * @apiSince 12
 */

public static final int MODE_NORMAL = 2; // 0x2

/**
 * This mode is similar to {@link #MODE_NORMAL} except the speaker and
 * the microphone are both disabled.
 * @apiSince 12
 */

public static final int MODE_ON_HOLD = 0; // 0x0
}

