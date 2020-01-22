/*
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


package android.media.tv;

import java.util.List;
import android.os.Handler;

/**
 * Central system API to the overall TV input framework (TIF) architecture, which arbitrates
 * interaction between applications and the selected TV inputs.
 *
 * <p>There are three primary parties involved in the TV input framework (TIF) architecture:
 *
 * <ul>
 * <li>The <strong>TV input manager</strong> as expressed by this class is the central point of the
 * system that manages interaction between all other parts. It is expressed as the client-side API
 * here which exists in each application context and communicates with a global system service that
 * manages the interaction across all processes.
 * <li>A <strong>TV input</strong> implemented by {@link android.media.tv.TvInputService TvInputService} represents an input source
 * of TV, which can be a pass-through input such as HDMI, or a tuner input which provides broadcast
 * TV programs. The system binds to the TV input per application’s request.
 * on implementing TV inputs.
 * <li><strong>Applications</strong> talk to the TV input manager to list TV inputs and check their
 * status. Once an application find the input to use, it uses {@link android.media.tv.TvView TvView} or
 * {@link android.media.tv.TvRecordingClient TvRecordingClient} for further interaction such as watching and recording broadcast TV
 * programs.
 * </ul>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TvInputManager {

TvInputManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns the complete list of TV inputs on the system.
 *
 * @return List of {@link android.media.tv.TvInputInfo TvInputInfo} for each TV input that describes its meta information.
 * @apiSince 21
 */

public java.util.List<android.media.tv.TvInputInfo> getTvInputList() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.media.tv.TvInputInfo TvInputInfo} for a given TV input.
 *
 * @param inputId The ID of the TV input.
 * This value must never be {@code null}.
 * @return the {@link android.media.tv.TvInputInfo TvInputInfo} for a given TV input. {@code null} if not found.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.media.tv.TvInputInfo getTvInputInfo(@androidx.annotation.NonNull java.lang.String inputId) { throw new RuntimeException("Stub!"); }

/**
 * Updates the <code>TvInputInfo</code> for an existing TV input. A TV input service
 * implementation may call this method to pass the application and system an up-to-date
 * <code>TvInputInfo</code> object that describes itself.
 *
 * <p>The system automatically creates a <code>TvInputInfo</code> object for each TV input,
 * based on the information collected from the <code>AndroidManifest.xml</code>, thus it is not
 * necessary to call this method unless such information has changed dynamically.
 * Use {@link android.media.tv.TvInputInfo.Builder TvInputInfo.Builder} to build a new <code>TvInputInfo</code> object.
 *
 * <p>Attempting to change information about a TV input that the calling package does not own
 * does nothing.
 *
 * @param inputInfo The <code>TvInputInfo</code> object that contains new information.
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the argument is {@code null}.
 * @see android.media.tv.TvInputManager.TvInputCallback#onTvInputInfoUpdated(TvInputInfo)
 * @apiSince 24
 */

public void updateTvInputInfo(@androidx.annotation.NonNull android.media.tv.TvInputInfo inputInfo) { throw new RuntimeException("Stub!"); }

/**
 * Returns the state of a given TV input.
 *
 * <p>The state is one of the following:
 * <ul>
 * <li>{@link #INPUT_STATE_CONNECTED}
 * <li>{@link #INPUT_STATE_CONNECTED_STANDBY}
 * <li>{@link #INPUT_STATE_DISCONNECTED}
 * </ul>
 *
 * @param inputId The ID of the TV input.
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the argument is {@code null}.
 
 * @return Value is {@link android.media.tv.TvInputManager#INPUT_STATE_CONNECTED}, {@link android.media.tv.TvInputManager#INPUT_STATE_CONNECTED_STANDBY}, or {@link android.media.tv.TvInputManager#INPUT_STATE_DISCONNECTED}
 * @apiSince 21
 */

public int getInputState(@androidx.annotation.NonNull java.lang.String inputId) { throw new RuntimeException("Stub!"); }

/**
 * Registers a {@link android.media.tv.TvInputManager.TvInputCallback TvInputCallback}.
 *
 * @param callback A callback used to monitor status of the TV inputs.
 * This value must never be {@code null}.
 * @param handler A {@link android.os.Handler Handler} that the status change will be delivered to.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void registerCallback(@androidx.annotation.NonNull android.media.tv.TvInputManager.TvInputCallback callback, @androidx.annotation.NonNull android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters the existing {@link android.media.tv.TvInputManager.TvInputCallback TvInputCallback}.
 *
 * @param callback The existing callback to remove.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void unregisterCallback(@androidx.annotation.NonNull android.media.tv.TvInputManager.TvInputCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the user's parental controls enabled state.
 *
 * @return {@code true} if the user enabled the parental controls, {@code false} otherwise.
 * @apiSince 21
 */

public boolean isParentalControlsEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether a given TV content rating is blocked by the user.
 *
 * @param rating The TV content rating to check. Can be {@link android.media.tv.TvContentRating#UNRATED TvContentRating#UNRATED}.
 * This value must never be {@code null}.
 * @return {@code true} if the given TV content rating is blocked, {@code false} otherwise.
 * @apiSince 21
 */

public boolean isRatingBlocked(@androidx.annotation.NonNull android.media.tv.TvContentRating rating) { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of blocked content ratings.
 *
 * @return the list of content ratings blocked by the user.
 * @apiSince 28
 */

public java.util.List<android.media.tv.TvContentRating> getBlockedRatings() { throw new RuntimeException("Stub!"); }

/**
 * Broadcast intent action when the user blocked content ratings change. For use with the
 * {@link #isRatingBlocked}.
 * @apiSince 21
 */

public static final java.lang.String ACTION_BLOCKED_RATINGS_CHANGED = "android.media.tv.action.BLOCKED_RATINGS_CHANGED";

/**
 * Broadcast intent action when the parental controls enabled state changes. For use with the
 * {@link #isParentalControlsEnabled}.
 * @apiSince 21
 */

public static final java.lang.String ACTION_PARENTAL_CONTROLS_ENABLED_CHANGED = "android.media.tv.action.PARENTAL_CONTROLS_ENABLED_CHANGED";

/**
 * Broadcast intent action used to query available content rating systems.
 *
 * <p>The TV input manager service locates available content rating systems by querying
 * broadcast receivers that are registered for this action. An application can offer additional
 * content rating systems to the user by declaring a suitable broadcast receiver in its
 * manifest.
 *
 * <p>Here is an example broadcast receiver declaration that an application might include in its
 * AndroidManifest.xml to advertise custom content rating systems. The meta-data specifies a
 * resource that contains a description of each content rating system that is provided by the
 * application.
 *
 * <p><pre class="prettyprint">
 * {@literal
 * <receiver android:name=".TvInputReceiver">
 *     <intent-filter>
 *         <action android:name=
 *                 "android.media.tv.action.QUERY_CONTENT_RATING_SYSTEMS" />
 *     </intent-filter>
 *     <meta-data
 *             android:name="android.media.tv.metadata.CONTENT_RATING_SYSTEMS"
 *             android:resource="@xml/tv_content_rating_systems" />
 * </receiver>}</pre>
 *
 * <p>In the above example, the <code>@xml/tv_content_rating_systems</code> resource refers to an
 * XML resource whose root element is <code>&lt;rating-system-definitions&gt;</code> that
 * contains zero or more <code>&lt;rating-system-definition&gt;</code> elements. Each <code>
 * &lt;rating-system-definition&gt;</code> element specifies the ratings, sub-ratings and rating
 * orders of a particular content rating system.
 *
 * @see android.media.tv.TvContentRating
 * @apiSince 21
 */

public static final java.lang.String ACTION_QUERY_CONTENT_RATING_SYSTEMS = "android.media.tv.action.QUERY_CONTENT_RATING_SYSTEMS";

/**
 * Activity action to set up channel sources i.e.&nbsp;TV inputs of type
 * {@link android.media.tv.TvInputInfo#TYPE_TUNER TvInputInfo#TYPE_TUNER}. When invoked, the system will display an appropriate UI for
 * the user to initiate the individual setup flow provided by
 * {@link android.R.attr#setupActivity} of each TV input service.
 * @apiSince 24
 */

public static final java.lang.String ACTION_SETUP_INPUTS = "android.media.tv.action.SETUP_INPUTS";

/**
 * Activity action to display the recording schedules. When invoked, the system will display an
 * appropriate UI to browse the schedules.
 * @apiSince 26
 */

public static final java.lang.String ACTION_VIEW_RECORDING_SCHEDULES = "android.media.tv.action.VIEW_RECORDING_SCHEDULES";

/**
 * State for {@link #getInputState(java.lang.String)} and
 * {@link android.media.tv.TvInputManager.TvInputCallback#onInputStateChanged(java.lang.String,int) TvInputCallback#onInputStateChanged(String, int)}: The input source is connected.
 *
 * <p>This state indicates that a source device is connected to the input port and is in the
 * normal operation mode. It is mostly relevant to hardware inputs such as HDMI input.
 * Non-hardware inputs are considered connected all the time.
 * @apiSince 21
 */

public static final int INPUT_STATE_CONNECTED = 0; // 0x0

/**
 * State for {@link #getInputState(java.lang.String)} and
 * {@link android.media.tv.TvInputManager.TvInputCallback#onInputStateChanged(java.lang.String,int) TvInputCallback#onInputStateChanged(String, int)}: The input source is connected but
 * in standby mode.
 *
 * <p>This state indicates that a source device is connected to the input port but is in standby
 * or low power mode. It is mostly relevant to hardware inputs such as HDMI input and Component
 * inputs.
 * @apiSince 21
 */

public static final int INPUT_STATE_CONNECTED_STANDBY = 1; // 0x1

/**
 * State for {@link #getInputState(java.lang.String)} and
 * {@link android.media.tv.TvInputManager.TvInputCallback#onInputStateChanged(java.lang.String,int) TvInputCallback#onInputStateChanged(String, int)}: The input source is disconnected.
 *
 * <p>This state indicates that a source device is disconnected from the input port. It is
 * mostly relevant to hardware inputs such as HDMI input.
 *
 * @apiSince 21
 */

public static final int INPUT_STATE_DISCONNECTED = 2; // 0x2

/**
 * Content rating systems metadata associated with {@link #ACTION_QUERY_CONTENT_RATING_SYSTEMS}.
 *
 * <p>Specifies the resource ID of an XML resource that describes the content rating systems
 * that are provided by the application.
 * @apiSince 21
 */

public static final java.lang.String META_DATA_CONTENT_RATING_SYSTEMS = "android.media.tv.metadata.CONTENT_RATING_SYSTEMS";

/**
 * Error for {@link android.media.tv.TvInputService.RecordingSession#notifyError(int) TvInputService.RecordingSession#notifyError(int)} and
 * {@link android.media.tv.TvRecordingClient.RecordingCallback#onError(int) TvRecordingClient.RecordingCallback#onError(int)}: Recording cannot proceed due to
 * insufficient storage space.
 * @apiSince 24
 */

public static final int RECORDING_ERROR_INSUFFICIENT_SPACE = 1; // 0x1

/**
 * Error for {@link android.media.tv.TvInputService.RecordingSession#notifyError(int) TvInputService.RecordingSession#notifyError(int)} and
 * {@link android.media.tv.TvRecordingClient.RecordingCallback#onError(int) TvRecordingClient.RecordingCallback#onError(int)}: Recording cannot proceed because
 * a required recording resource was not able to be allocated.
 * @apiSince 24
 */

public static final int RECORDING_ERROR_RESOURCE_BUSY = 2; // 0x2

/**
 * Error for {@link android.media.tv.TvInputService.RecordingSession#notifyError(int) TvInputService.RecordingSession#notifyError(int)} and
 * {@link android.media.tv.TvRecordingClient.RecordingCallback#onError(int) TvRecordingClient.RecordingCallback#onError(int)}: The requested operation cannot be
 * completed due to a problem that does not fit under any other error codes, or the error code
 * for the problem is defined on the higher version than application's
 * <code>android:targetSdkVersion</code>.
 * @apiSince 24
 */

public static final int RECORDING_ERROR_UNKNOWN = 0; // 0x0

/**
 * Value returned by {@link android.media.tv.TvInputService.Session#onTimeShiftGetCurrentPosition() TvInputService.Session#onTimeShiftGetCurrentPosition()} and
 * {@link android.media.tv.TvInputService.Session#onTimeShiftGetStartPosition() TvInputService.Session#onTimeShiftGetStartPosition()} when time shifting has not
 * yet started.
 * @apiSince 23
 */

public static final long TIME_SHIFT_INVALID_TIME = -9223372036854775808L; // 0x8000000000000000L

/**
 * Status for {@link android.media.tv.TvInputService.Session#notifyTimeShiftStatusChanged(int) TvInputService.Session#notifyTimeShiftStatusChanged(int)} and
 * {@link android.media.tv.TvView.TvInputCallback#onTimeShiftStatusChanged(java.lang.String,int) TvView.TvInputCallback#onTimeShiftStatusChanged(String, int)}: Time shifting is
 * currently available. In this status, the application assumes it can pause/resume playback,
 * seek to a specified time position and set playback rate and audio mode.
 * @apiSince 23
 */

public static final int TIME_SHIFT_STATUS_AVAILABLE = 3; // 0x3

/**
 * Status for {@link android.media.tv.TvInputService.Session#notifyTimeShiftStatusChanged(int) TvInputService.Session#notifyTimeShiftStatusChanged(int)} and
 * {@link android.media.tv.TvView.TvInputCallback#onTimeShiftStatusChanged(java.lang.String,int) TvView.TvInputCallback#onTimeShiftStatusChanged(String, int)}: Time shifting is
 * currently unavailable but might work again later.
 * @apiSince 23
 */

public static final int TIME_SHIFT_STATUS_UNAVAILABLE = 2; // 0x2

/**
 * Status for {@link android.media.tv.TvInputService.Session#notifyTimeShiftStatusChanged(int) TvInputService.Session#notifyTimeShiftStatusChanged(int)} and
 * {@link android.media.tv.TvView.TvInputCallback#onTimeShiftStatusChanged(java.lang.String,int) TvView.TvInputCallback#onTimeShiftStatusChanged(String, int)}: Unknown status. Also
 * the status prior to calling {@code notifyTimeShiftStatusChanged}.
 * @apiSince 23
 */

public static final int TIME_SHIFT_STATUS_UNKNOWN = 0; // 0x0

/**
 * Status for {@link android.media.tv.TvInputService.Session#notifyTimeShiftStatusChanged(int) TvInputService.Session#notifyTimeShiftStatusChanged(int)} and
 * {@link android.media.tv.TvView.TvInputCallback#onTimeShiftStatusChanged(java.lang.String,int) TvView.TvInputCallback#onTimeShiftStatusChanged(String, int)}: The current TV input
 * does not support time shifting.
 * @apiSince 23
 */

public static final int TIME_SHIFT_STATUS_UNSUPPORTED = 1; // 0x1

/**
 * Reason for {@link android.media.tv.TvInputService.Session#notifyVideoUnavailable(int) TvInputService.Session#notifyVideoUnavailable(int)} and
 * {@link android.media.tv.TvView.TvInputCallback#onVideoUnavailable(java.lang.String,int) TvView.TvInputCallback#onVideoUnavailable(String, int)}: Video is unavailable because
 * the current TV program is audio-only.
 * @apiSince 23
 */

public static final int VIDEO_UNAVAILABLE_REASON_AUDIO_ONLY = 4; // 0x4

/**
 * Reason for {@link android.media.tv.TvInputService.Session#notifyVideoUnavailable(int) TvInputService.Session#notifyVideoUnavailable(int)} and
 * {@link android.media.tv.TvView.TvInputCallback#onVideoUnavailable(java.lang.String,int) TvView.TvInputCallback#onVideoUnavailable(String, int)}: Video is unavailable because
 * the corresponding TV input has stopped playback temporarily to buffer more data.
 * @apiSince 21
 */

public static final int VIDEO_UNAVAILABLE_REASON_BUFFERING = 3; // 0x3

/**
 * Reason for {@link android.media.tv.TvInputService.Session#notifyVideoUnavailable(int) TvInputService.Session#notifyVideoUnavailable(int)} and
 * {@link android.media.tv.TvView.TvInputCallback#onVideoUnavailable(java.lang.String,int) TvView.TvInputCallback#onVideoUnavailable(String, int)}: Video is unavailable because
 * the corresponding TV input is in the middle of tuning to a new channel.
 * @apiSince 21
 */

public static final int VIDEO_UNAVAILABLE_REASON_TUNING = 1; // 0x1

/**
 * Reason for {@link android.media.tv.TvInputService.Session#notifyVideoUnavailable(int) TvInputService.Session#notifyVideoUnavailable(int)} and
 * {@link android.media.tv.TvView.TvInputCallback#onVideoUnavailable(java.lang.String,int) TvView.TvInputCallback#onVideoUnavailable(String, int)}: Video is unavailable due to
 * an unspecified error.
 * @apiSince 21
 */

public static final int VIDEO_UNAVAILABLE_REASON_UNKNOWN = 0; // 0x0

/**
 * Reason for {@link android.media.tv.TvInputService.Session#notifyVideoUnavailable(int) TvInputService.Session#notifyVideoUnavailable(int)} and
 * {@link android.media.tv.TvView.TvInputCallback#onVideoUnavailable(java.lang.String,int) TvView.TvInputCallback#onVideoUnavailable(String, int)}: Video is unavailable due to
 * weak TV signal.
 * @apiSince 21
 */

public static final int VIDEO_UNAVAILABLE_REASON_WEAK_SIGNAL = 2; // 0x2
/**
 * Callback used to monitor status of the TV inputs.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class TvInputCallback {

public TvInputCallback() { throw new RuntimeException("Stub!"); }

/**
 * This is called when the state of a given TV input is changed.
 *
 * @param inputId The ID of the TV input.
 * @param state State of the TV input. The value is one of the following:
 * <ul>
 * <li>{@link android.media.tv.TvInputManager#INPUT_STATE_CONNECTED TvInputManager#INPUT_STATE_CONNECTED}
 * <li>{@link android.media.tv.TvInputManager#INPUT_STATE_CONNECTED_STANDBY TvInputManager#INPUT_STATE_CONNECTED_STANDBY}
 * <li>{@link android.media.tv.TvInputManager#INPUT_STATE_DISCONNECTED TvInputManager#INPUT_STATE_DISCONNECTED}
 * </ul>
 
 * Value is {@link android.media.tv.TvInputManager#INPUT_STATE_CONNECTED}, {@link android.media.tv.TvInputManager#INPUT_STATE_CONNECTED_STANDBY}, or {@link android.media.tv.TvInputManager#INPUT_STATE_DISCONNECTED}
 * @apiSince 21
 */

public void onInputStateChanged(java.lang.String inputId, int state) { throw new RuntimeException("Stub!"); }

/**
 * This is called when a TV input is added to the system.
 *
 * <p>Normally it happens when the user installs a new TV input package that implements
 * {@link android.media.tv.TvInputService TvInputService} interface.
 *
 * @param inputId The ID of the TV input.
 * @apiSince 21
 */

public void onInputAdded(java.lang.String inputId) { throw new RuntimeException("Stub!"); }

/**
 * This is called when a TV input is removed from the system.
 *
 * <p>Normally it happens when the user uninstalls the previously installed TV input
 * package.
 *
 * @param inputId The ID of the TV input.
 * @apiSince 21
 */

public void onInputRemoved(java.lang.String inputId) { throw new RuntimeException("Stub!"); }

/**
 * This is called when a TV input is updated on the system.
 *
 * <p>Normally it happens when a previously installed TV input package is re-installed or
 * the media on which a newer version of the package exists becomes available/unavailable.
 *
 * @param inputId The ID of the TV input.
 * @apiSince 24
 */

public void onInputUpdated(java.lang.String inputId) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the information about an existing TV input has been updated.
 *
 * <p>Because the system automatically creates a <code>TvInputInfo</code> object for each TV
 * input based on the information collected from the <code>AndroidManifest.xml</code>, this
 * method is only called back when such information has changed dynamically.
 *
 * @param inputInfo The <code>TvInputInfo</code> object that contains new information.
 * @apiSince 24
 */

public void onTvInputInfoUpdated(android.media.tv.TvInputInfo inputInfo) { throw new RuntimeException("Stub!"); }
}

}

