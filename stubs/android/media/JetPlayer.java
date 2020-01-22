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

import android.os.Handler;

/**
 * JetPlayer provides access to JET content playback and control.
 *
 * <p>Please refer to the JET Creator User Manual for a presentation of the JET interactive
 * music concept and how to use the JetCreator tool to create content to be player by JetPlayer.
 *
 * <p>Use of the JetPlayer class is based around the playback of a number of JET segments
 * sequentially added to a playback FIFO queue. The rendering of the MIDI content stored in each
 * segment can be dynamically affected by two mechanisms:
 * <ul>
 * <li>tracks in a segment can be muted or unmuted at any moment, individually or through
 *    a mask (to change the mute state of multiple tracks at once)</li>
 * <li>parts of tracks in a segment can be played at predefined points in the segment, in order
 *    to maintain synchronization with the other tracks in the segment. This is achieved through
 *    the notion of "clips", which can be triggered at any time, but that will play only at the
 *    right time, as authored in the corresponding JET file.</li>
 * </ul>
 * As a result of the rendering and playback of the JET segments, the user of the JetPlayer instance
 * can receive notifications from the JET engine relative to:
 * <ul>
 * <li>the playback state,</li>
 * <li>the number of segments left to play in the queue,</li>
 * <li>application controller events (CC80-83) to mark points in the MIDI segments.</li>
 * </ul>
 * Use {@link #getJetPlayer()} to construct a JetPlayer instance. JetPlayer is a singleton class.
 * </p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about how to use JetPlayer, read the
 * <a href="{@docRoot}guide/topics/media/jetplayer.html">JetPlayer</a> developer guide.</p></div>
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class JetPlayer {

private JetPlayer() { throw new RuntimeException("Stub!"); }

/**
 * Factory method for the JetPlayer class.
 * @return the singleton JetPlayer instance
 * @apiSince 3
 */

public static android.media.JetPlayer getJetPlayer() { throw new RuntimeException("Stub!"); }

/**
 * Cloning a JetPlayer instance is not supported. Calling clone() will generate an exception.
 * @apiSince 3
 */

public java.lang.Object clone() throws java.lang.CloneNotSupportedException { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected void finalize() { throw new RuntimeException("Stub!"); }

/**
 * Stops the current JET playback, and releases all associated native resources.
 * The object can no longer be used and the reference should be set to null
 * after a call to release().
 * @apiSince 3
 */

public void release() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum number of simultaneous MIDI tracks supported by JetPlayer
 * @apiSince 3
 */

public static int getMaxTracks() { throw new RuntimeException("Stub!"); }

/**
 * Loads a .jet file from a given path.
 * @param path the path to the .jet file, for instance "/sdcard/mygame/music.jet".
 * @return true if loading the .jet file was successful, false if loading failed.
 * @apiSince 3
 */

public boolean loadJetFile(java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Loads a .jet file from an asset file descriptor.
 * @param afd the asset file descriptor.
 * @return true if loading the .jet file was successful, false if loading failed.
 * @apiSince 3
 */

public boolean loadJetFile(android.content.res.AssetFileDescriptor afd) { throw new RuntimeException("Stub!"); }

/**
 * Closes the resource containing the JET content.
 * @return true if successfully closed, false otherwise.
 * @apiSince 3
 */

public boolean closeJetFile() { throw new RuntimeException("Stub!"); }

/**
 * Starts playing the JET segment queue.
 * @return true if rendering and playback is successfully started, false otherwise.
 * @apiSince 3
 */

public boolean play() { throw new RuntimeException("Stub!"); }

/**
 * Pauses the playback of the JET segment queue.
 * @return true if rendering and playback is successfully paused, false otherwise.
 * @apiSince 3
 */

public boolean pause() { throw new RuntimeException("Stub!"); }

/**
 * Queues the specified segment in the JET queue.
 * @param segmentNum the identifier of the segment.
 * @param libNum the index of the sound bank associated with the segment. Use -1 to indicate
 *    that no sound bank (DLS file) is associated with this segment, in which case JET will use
 *    the General MIDI library.
 * @param repeatCount the number of times the segment will be repeated. 0 means the segment will
 *    only play once. -1 means the segment will repeat indefinitely.
 * @param transpose the amount of pitch transposition. Set to 0 for normal playback.
 *    Range is -12 to +12.
 * @param muteFlags a bitmask to specify which MIDI tracks will be muted during playback. Bit 0
 *    affects track 0, bit 1 affects track 1 etc.
 * @param userID a value specified by the application that uniquely identifies the segment.
 *    this value is received in the
 *    {@link android.media.JetPlayer.OnJetEventListener#onJetUserIdUpdate(android.media.JetPlayer,int,int) OnJetEventListener#onJetUserIdUpdate(JetPlayer, int, int)} event listener method.
 *    Normally, the application will keep a byte value that is incremented each time a new
 *    segment is queued up. This can be used to look up any special characteristics of that
 *    track including trigger clips and mute flags.
 * @return true if the segment was successfully queued, false if the queue is full or if the
 *    parameters are invalid.
 * @apiSince 3
 */

public boolean queueJetSegment(int segmentNum, int libNum, int repeatCount, int transpose, int muteFlags, byte userID) { throw new RuntimeException("Stub!"); }

/**
 * Queues the specified segment in the JET queue.
 * @param segmentNum the identifier of the segment.
 * @param libNum the index of the soundbank associated with the segment. Use -1 to indicate that
 *    no sound bank (DLS file) is associated with this segment, in which case JET will use
 *    the General MIDI library.
 * @param repeatCount the number of times the segment will be repeated. 0 means the segment will
 *    only play once. -1 means the segment will repeat indefinitely.
 * @param transpose the amount of pitch transposition. Set to 0 for normal playback.
 *    Range is -12 to +12.
 * @param muteArray an array of booleans to specify which MIDI tracks will be muted during
 *    playback. The value at index 0 affects track 0, value at index 1 affects track 1 etc.
 *    The length of the array must be {@link #getMaxTracks()} for the call to succeed.
 * @param userID a value specified by the application that uniquely identifies the segment.
 *    this value is received in the
 *    {@link android.media.JetPlayer.OnJetEventListener#onJetUserIdUpdate(android.media.JetPlayer,int,int) OnJetEventListener#onJetUserIdUpdate(JetPlayer, int, int)} event listener method.
 *    Normally, the application will keep a byte value that is incremented each time a new
 *    segment is queued up. This can be used to look up any special characteristics of that
 *    track including trigger clips and mute flags.
 * @return true if the segment was successfully queued, false if the queue is full or if the
 *    parameters are invalid.
 * @apiSince 3
 */

public boolean queueJetSegmentMuteArray(int segmentNum, int libNum, int repeatCount, int transpose, boolean[] muteArray, byte userID) { throw new RuntimeException("Stub!"); }

/**
 * Modifies the mute flags.
 * @param muteFlags a bitmask to specify which MIDI tracks are muted. Bit 0 affects track 0,
 *    bit 1 affects track 1 etc.
 * @param sync if false, the new mute flags will be applied as soon as possible by the JET
 *    render and playback engine. If true, the mute flags will be updated at the start of the
 *    next segment. If the segment is repeated, the flags will take effect the next time
 *    segment is repeated.
 * @return true if the mute flags were successfully updated, false otherwise.
 * @apiSince 3
 */

public boolean setMuteFlags(int muteFlags, boolean sync) { throw new RuntimeException("Stub!"); }

/**
 * Modifies the mute flags for the current active segment.
 * @param muteArray an array of booleans to specify which MIDI tracks are muted. The value at
 *    index 0 affects track 0, value at index 1 affects track 1 etc.
 *    The length of the array must be {@link #getMaxTracks()} for the call to succeed.
 * @param sync if false, the new mute flags will be applied as soon as possible by the JET
 *    render and playback engine. If true, the mute flags will be updated at the start of the
 *    next segment. If the segment is repeated, the flags will take effect the next time
 *    segment is repeated.
 * @return true if the mute flags were successfully updated, false otherwise.
 * @apiSince 3
 */

public boolean setMuteArray(boolean[] muteArray, boolean sync) { throw new RuntimeException("Stub!"); }

/**
 * Mutes or unmutes a single track.
 * @param trackId the index of the track to mute.
 * @param muteFlag set to true to mute, false to unmute.
 * @param sync if false, the new mute flags will be applied as soon as possible by the JET
 *    render and playback engine. If true, the mute flag will be updated at the start of the
 *    next segment. If the segment is repeated, the flag will take effect the next time
 *    segment is repeated.
 * @return true if the mute flag was successfully updated, false otherwise.
 * @apiSince 3
 */

public boolean setMuteFlag(int trackId, boolean muteFlag, boolean sync) { throw new RuntimeException("Stub!"); }

/**
 * Schedules the playback of a clip.
 * This will automatically update the mute flags in sync with the JET Clip Marker (controller
 * 103). The parameter clipID must be in the range of 0-63. After the call to triggerClip, when
 * JET next encounters a controller event 103 with bits 0-5 of the value equal to clipID and
 * bit 6 set to 1, it will automatically unmute the track containing the controller event.
 * When JET encounters the complementary controller event 103 with bits 0-5 of the value equal
 * to clipID and bit 6 set to 0, it will mute the track again.
 * @param clipId the identifier of the clip to trigger.
 * @return true if the clip was successfully triggered, false otherwise.
 * @apiSince 3
 */

public boolean triggerClip(int clipId) { throw new RuntimeException("Stub!"); }

/**
 * Empties the segment queue, and clears all clips that are scheduled for playback.
 * @return true if the queue was successfully cleared, false otherwise.
 * @apiSince 3
 */

public boolean clearQueue() { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener JetPlayer notifies when a JET event is generated by the rendering and
 * playback engine.
 * Notifications will be received in the same thread as the one in which the JetPlayer
 * instance was created.
 * @param listener
 * @apiSince 3
 */

public void setEventListener(android.media.JetPlayer.OnJetEventListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener JetPlayer notifies when a JET event is generated by the rendering and
 * playback engine.
 * Use this method to receive JET events in the Handler associated with another
 * thread than the one in which you created the JetPlayer instance.
 * @param listener
 * @param handler the Handler that will receive the event notification messages.
 * @apiSince 3
 */

public void setEventListener(android.media.JetPlayer.OnJetEventListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }
/**
 * Handles the notification when the JET engine generates an event.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnJetEventListener {

/**
 * Callback for when the JET engine generates a new event.
 *
 * @param player the JET player the event is coming from
 * @param segment 8 bit unsigned value
 * @param track 6 bit unsigned value
 * @param channel 4 bit unsigned value
 * @param controller 7 bit unsigned value
 * @param value 7 bit unsigned value
 * @apiSince 3
 */

public void onJetEvent(android.media.JetPlayer player, short segment, byte track, byte channel, byte controller, byte value);

/**
 * Callback for when JET's currently playing segment's userID is updated.
 *
 * @param player the JET player the status update is coming from
 * @param userId the ID of the currently playing segment
 * @param repeatCount the repetition count for the segment (0 means it plays once)
 * @apiSince 3
 */

public void onJetUserIdUpdate(android.media.JetPlayer player, int userId, int repeatCount);

/**
 * Callback for when JET's number of queued segments is updated.
 *
 * @param player the JET player the status update is coming from
 * @param nbSegments the number of segments in the JET queue
 * @apiSince 3
 */

public void onJetNumQueuedSegmentUpdate(android.media.JetPlayer player, int nbSegments);

/**
 * Callback for when JET pause state is updated.
 *
 * @param player the JET player the status update is coming from
 * @param paused indicates whether JET is paused (1) or not (0)
 * @apiSince 3
 */

public void onJetPauseUpdate(android.media.JetPlayer player, int paused);
}

}

