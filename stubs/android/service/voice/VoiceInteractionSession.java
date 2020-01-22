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

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import java.util.concurrent.Executor;
import android.content.Context;
import android.app.Activity;
import java.util.function.Consumer;
import android.os.CancellationSignal;
import android.app.assist.AssistStructure;
import java.io.PrintWriter;

/**
 * An active voice interaction session, providing a facility for the implementation
 * to interact with the user in the voice interaction layer.  The user interface is
 * initially shown by default, and can be created be overriding {@link #onCreateContentView()}
 * in which the UI can be built.
 *
 * <p>A voice interaction session can be self-contained, ultimately calling {@link #finish}
 * when done.  It can also initiate voice interactions with applications by calling
 * {@link #startVoiceActivity}</p>.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class VoiceInteractionSession implements android.view.KeyEvent.Callback, android.content.ComponentCallbacks2 {

/** @apiSince 21 */

public VoiceInteractionSession(android.content.Context context) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public VoiceInteractionSession(android.content.Context context, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public android.content.Context getContext() { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to {@link android.service.voice.VoiceInteractionService#setDisabledShowContext VoiceInteractionService#setDisabledShowContext}.
 * @apiSince 23
 */

public void setDisabledShowContext(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to {@link android.service.voice.VoiceInteractionService#getDisabledShowContext VoiceInteractionService#getDisabledShowContext}.
 * @apiSince 23
 */

public int getDisabledShowContext() { throw new RuntimeException("Stub!"); }

/**
 * Return which show context flags have been disabled by the user through the system
 * settings UI, so the session will never get this data.  Returned flags are any combination of
 * {@link android.service.voice.VoiceInteractionSession#SHOW_WITH_ASSIST VoiceInteractionSession#SHOW_WITH_ASSIST} and
 * {@link android.service.voice.VoiceInteractionSession#SHOW_WITH_SCREENSHOT VoiceInteractionSession#SHOW_WITH_SCREENSHOT}.  Note that this only tells you about
 * global user settings, not about restrictions that may be applied contextual based on
 * the current application the user is in or other transient states.
 * @apiSince 23
 */

public int getUserDisabledShowContext() { throw new RuntimeException("Stub!"); }

/**
 * Show the UI for this session.  This asks the system to go through the process of showing
 * your UI, which will eventually culminate in {@link #onShow}.  This is similar to calling
 * {@link android.service.voice.VoiceInteractionService#showSession VoiceInteractionService#showSession}.
 * @param args Arbitrary arguments that will be propagated {@link #onShow}.
 * @param flags Indicates additional optional behavior that should be performed.  May
 * be any combination of
 * {@link android.service.voice.VoiceInteractionSession#SHOW_WITH_ASSIST VoiceInteractionSession#SHOW_WITH_ASSIST} and
 * {@link android.service.voice.VoiceInteractionSession#SHOW_WITH_SCREENSHOT VoiceInteractionSession#SHOW_WITH_SCREENSHOT}
 * to request that the system generate and deliver assist data on the current foreground
 * app as part of showing the session UI.
 * @apiSince 23
 */

public void show(android.os.Bundle args, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Hide the session's UI, if currently shown.  Call this when you are done with your
 * user interaction.
 * @apiSince 23
 */

public void hide() { throw new RuntimeException("Stub!"); }

/**
 * Control whether the UI layer for this session is enabled.  It is enabled by default.
 * If set to false, you will not be able to provide a UI through {@link #onCreateContentView()}.
 * @apiSince 26
 */

public void setUiEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * You can call this to customize the theme used by your IME's window.
 * This must be set before {@link #onCreate}, so you
 * will typically call it in your constructor with the resource ID
 * of your custom theme.
 * @apiSince 23
 */

public void setTheme(int theme) { throw new RuntimeException("Stub!"); }

/**
 * Ask that a new activity be started for voice interaction.  This will create a
 * new dedicated task in the activity manager for this voice interaction session;
 * this means that {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK Intent#FLAG_ACTIVITY_NEW_TASK}
 * will be set for you to make it a new task.
 *
 * <p>The newly started activity will be displayed to the user in a special way, as
 * a layer under the voice interaction UI.</p>
 *
 * <p>As the voice activity runs, it can retrieve a {@link android.app.VoiceInteractor}
 * through which it can perform voice interactions through your session.  These requests
 * for voice interactions will appear as callbacks on {@link #onGetSupportedCommands},
 * {@link #onRequestConfirmation}, {@link #onRequestPickOption},
 * {@link #onRequestCompleteVoice}, {@link #onRequestAbortVoice},
 * or {@link #onRequestCommand}
 *
 * <p>You will receive a call to {@link #onTaskStarted} when the task starts up
 * and {@link #onTaskFinished} when the last activity has finished.
 *
 * @param intent The Intent to start this voice interaction.  The given Intent will
 * always have {@link android.content.Intent#CATEGORY_VOICE Intent#CATEGORY_VOICE} added to it, since
 * this is part of a voice interaction.
 * @apiSince 23
 */

public void startVoiceActivity(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * <p>Ask that a new assistant activity be started.  This will create a new task in the
 * in activity manager: this means that
 * {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK Intent#FLAG_ACTIVITY_NEW_TASK}
 * will be set for you to make it a new task.</p>
 *
 * <p>The newly started activity will be displayed on top of other activities in the system
 * in a new layer that is not affected by multi-window mode.  Tasks started from this activity
 * will go into the normal activity layer and not this new layer.</p>
 *
 * <p>By default, the system will create a window for the UI for this session.  If you are using
 * an assistant activity instead, then you can disable the window creation by calling
 * {@link #setUiEnabled} in {@link #onPrepareShow(android.os.Bundle,int)}.</p>
 * @apiSince 26
 */

public void startAssistantActivity(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Requests a list of supported actions from an app.
 *
 * @param activityId Ths activity id of the app to get the actions from.
 * This value must never be {@code null}.
 * @param resultExecutor The handler to receive the callback
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param cancellationSignal A signal to cancel the operation in progress,
 *     or {@code null} if none.
 * This value may be {@code null}.
 * @param callback The callback to receive the response
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public final void requestDirectActions(@androidx.annotation.NonNull android.service.voice.VoiceInteractionSession.ActivityId activityId, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull java.util.concurrent.Executor resultExecutor, @androidx.annotation.NonNull java.util.function.Consumer<java.util.List<android.app.DirectAction>> callback) { throw new RuntimeException("Stub!"); }

/**
 * Called when the direct actions are invalidated.
 
 * @param activityId This value must never be {@code null}.
 * @apiSince 29
 */

public void onDirectActionsInvalidated(@androidx.annotation.NonNull android.service.voice.VoiceInteractionSession.ActivityId activityId) { throw new RuntimeException("Stub!"); }

/**
 * Asks that an action be performed by the app. This will send a request to the app which
 * provided this action.
 *
 * <p> An action could take time to execute and the result is provided asynchronously
 * via a callback. If the action is taking longer and you want to cancel its execution
 * you can pass in a cancellation signal through which to notify the app to abort the
 * action.
 *
 * @param action The action to be performed.
 * This value must never be {@code null}.
 * @param extras Any optional extras sent to the app as part of the request
 * This value may be {@code null}.
 * @param cancellationSignal A signal to cancel the operation in progress,
 *                          or {@code null} if none.
 * This value may be {@code null}.
 * @param resultExecutor The handler to receive the callback.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param resultListener The callback to receive the response.
 *
 * This value must never be {@code null}.
 * @see #requestDirectActions(ActivityId, CancellationSignal, Executor, Consumer)
 * @see android.app.Activity#onGetDirectActions(CancellationSignal, Consumer)
 * @apiSince 29
 */

public final void performDirectAction(@androidx.annotation.NonNull android.app.DirectAction action, @androidx.annotation.Nullable android.os.Bundle extras, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull java.util.concurrent.Executor resultExecutor, @androidx.annotation.NonNull java.util.function.Consumer<android.os.Bundle> resultListener) { throw new RuntimeException("Stub!"); }

/**
 * Set whether this session will keep the device awake while it is running a voice
 * activity.  By default, the system holds a wake lock for it while in this state,
 * so that it can work even if the screen is off.  Setting this to false removes that
 * wake lock, allowing the CPU to go to sleep.  This is typically used if the
 * session decides it has been waiting too long for a response from the user and
 * doesn't want to let this continue to drain the battery.
 *
 * <p>Passing false here will release the wake lock, and you can call later with
 * true to re-acquire it.  It will also be automatically re-acquired for you each
 * time you start a new voice activity task -- that is when you call
 * {@link #startVoiceActivity}.</p>
 * @apiSince 23
 */

public void setKeepAwake(boolean keepAwake) { throw new RuntimeException("Stub!"); }

/**
 * Request that all system dialogs (and status bar shade etc) be closed, allowing
 * access to the session's UI.  This will <em>not</em> cause the lock screen to be
 * dismissed.
 * @apiSince 23
 */

public void closeSystemDialogs() { throw new RuntimeException("Stub!"); }

/**
 * Convenience for inflating views.
 * @apiSince 23
 */

public android.view.LayoutInflater getLayoutInflater() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the window being used to show the session's UI.
 * @apiSince 23
 */

public android.app.Dialog getWindow() { throw new RuntimeException("Stub!"); }

/**
 * Finish the session.  This completely destroys the session -- the next time it is shown,
 * an entirely new one will be created.  You do not normally call this function; instead,
 * use {@link #hide} and allow the system to destroy your session if it needs its RAM.
 * @apiSince 21
 */

public void finish() { throw new RuntimeException("Stub!"); }

/**
 * Initiatize a new session.  At this point you don't know exactly what this
 * session will be used for; you will find that out in {@link #onShow}.
 * @apiSince 23
 */

public void onCreate() { throw new RuntimeException("Stub!"); }

/**
 * Called prior to {@link #onShow} before any UI setup has occurred.  Not generally useful.
 *
 * @param args The arguments that were supplied to
 * {@link android.service.voice.VoiceInteractionService#showSession VoiceInteractionService#showSession}.
 * @param showFlags The show flags originally provided to
 * {@link android.service.voice.VoiceInteractionService#showSession VoiceInteractionService#showSession}.
 * @apiSince 26
 */

public void onPrepareShow(android.os.Bundle args, int showFlags) { throw new RuntimeException("Stub!"); }

/**
 * Called when the session UI is going to be shown.  This is called after
 * {@link #onCreateContentView} (if the session's content UI needed to be created) and
 * immediately prior to the window being shown.  This may be called while the window
 * is already shown, if a show request has come in while it is shown, to allow you to
 * update the UI to match the new show arguments.
 *
 * @param args The arguments that were supplied to
 * {@link android.service.voice.VoiceInteractionService#showSession VoiceInteractionService#showSession}.
 * @param showFlags The show flags originally provided to
 * {@link android.service.voice.VoiceInteractionService#showSession VoiceInteractionService#showSession}.
 * @apiSince 23
 */

public void onShow(android.os.Bundle args, int showFlags) { throw new RuntimeException("Stub!"); }

/**
 * Called immediately after stopping to show the session UI.
 * @apiSince 23
 */

public void onHide() { throw new RuntimeException("Stub!"); }

/**
 * Last callback to the session as it is being finished.
 * @apiSince 21
 */

public void onDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Hook in which to create the session's UI.
 * @apiSince 23
 */

public android.view.View onCreateContentView() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setContentView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Called when there has been a failure transferring the {@link android.app.assist.AssistStructure AssistStructure} to
 * the assistant.  This may happen, for example, if the data is too large and results
 * in an out of memory exception, or the client has provided corrupt data.  This will
 * be called immediately before {@link #onHandleAssist} and the AssistStructure supplied
 * there afterwards will be null.
 *
 * @param failure The failure exception that was thrown when building the
 * {@link android.app.assist.AssistStructure AssistStructure}.
 * @apiSince 23
 */

public void onAssistStructureFailure(java.lang.Throwable failure) { throw new RuntimeException("Stub!"); }

/**
 * Called to receive data from the application that the user was currently viewing when
 * an assist session is started.  If the original show request did not specify
 * {@link #SHOW_WITH_ASSIST}, this method will not be called.
 *
 * @param data Arbitrary data supplied by the app through
 * {@link android.app.Activity#onProvideAssistData Activity.onProvideAssistData}.
 * May be null if assist data has been disabled by the user or device policy.
 * This value may be {@code null}.
 * @param structure If available, the structure definition of all windows currently
 * displayed by the app.  May be null if assist data has been disabled by the user
 * or device policy; will be an empty stub if the application has disabled assist
 * by marking its window as secure.
 * This value may be {@code null}.
 * @param content Additional content data supplied by the app through
 * {@link android.app.Activity#onProvideAssistContent Activity.onProvideAssistContent}.
 * May be null if assist data has been disabled by the user or device policy; will
 * not be automatically filled in with data from the app if the app has marked its
 * window as secure.
 *
 * This value may be {@code null}.
 * @deprecated use {@link #onHandleAssist(android.service.voice.VoiceInteractionSession.AssistState)}
 * @apiSince 23
 * @deprecatedSince 29
 */

@Deprecated
public void onHandleAssist(@androidx.annotation.Nullable android.os.Bundle data, @androidx.annotation.Nullable android.app.assist.AssistStructure structure, @androidx.annotation.Nullable android.app.assist.AssistContent content) { throw new RuntimeException("Stub!"); }

/**
 * Called to receive data from the application that the user was currently viewing when
 * an assist session is started.  If the original show request did not specify
 * {@link #SHOW_WITH_ASSIST}, this method will not be called.
 *
 * <p>This method is called for all activities along with an index and count that indicates
 * which activity the data is for. {@code index} will be between 0 and {@code count}-1 and
 * this method is called once for each activity in no particular order. The {@code count}
 * indicates how many activities to expect assist data for, including the top focused one.
 * The focused activity can be determined by calling {@link android.service.voice.VoiceInteractionSession.AssistState#isFocused() AssistState#isFocused()}.
 *
 * <p>To be responsive to assist requests, process assist data as soon as it is received,
 * without waiting for all queued activities to return assist data.
 *
 * @param state The state object capturing the state of an activity.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void onHandleAssist(@androidx.annotation.NonNull android.service.voice.VoiceInteractionSession.AssistState state) { throw new RuntimeException("Stub!"); }

/**
 * Called to receive data from other applications that the user was or is interacting with,
 * that are currently on the screen in a multi-window display environment, not including the
 * currently focused activity. This could be
 * a free-form window, a picture-in-picture window, or another window in a split-screen display.
 * <p>
 * This method is very similar to
 * {@link #onHandleAssist} except that it is called
 * for additional non-focused activities along with an index and count that indicates
 * which additional activity the data is for. {@code index} will be between 1 and
 * {@code count}-1 and this method is called once for each additional window, in no particular
 * order. The {@code count} indicates how many windows to expect assist data for, including the
 * top focused activity, which continues to be returned via {@link #onHandleAssist}.
 * <p>
 * To be responsive to assist requests, process assist data as soon as it is received,
 * without waiting for all queued activities to return assist data.
 *
 * @param data Arbitrary data supplied by the app through
 * {@link android.app.Activity#onProvideAssistData Activity.onProvideAssistData}.
 * May be null if assist data has been disabled by the user or device policy.
 * This value may be {@code null}.
 * @param structure If available, the structure definition of all windows currently
 * displayed by the app.  May be null if assist data has been disabled by the user
 * or device policy; will be an empty stub if the application has disabled assist
 * by marking its window as secure.
 * This value may be {@code null}.
 * @param content Additional content data supplied by the app through
 * {@link android.app.Activity#onProvideAssistContent Activity.onProvideAssistContent}.
 * May be null if assist data has been disabled by the user or device policy; will
 * not be automatically filled in with data from the app if the app has marked its
 * window as secure.
 * This value may be {@code null}.
 * @param index the index of the additional activity that this data
 *        is for.
 * @param count the total number of additional activities for which the assist data is being
 *        returned, including the focused activity that is returned via
 *        {@link #onHandleAssist}.
 *
 * @deprecated use {@link #onHandleAssist(android.service.voice.VoiceInteractionSession.AssistState)}
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public void onHandleAssistSecondary(@androidx.annotation.Nullable android.os.Bundle data, @androidx.annotation.Nullable android.app.assist.AssistStructure structure, @androidx.annotation.Nullable android.app.assist.AssistContent content, int index, int count) { throw new RuntimeException("Stub!"); }

/**
 * Called to receive a screenshot of what the user was currently viewing when an assist
 * session is started.  May be null if screenshots are disabled by the user, policy,
 * or application.  If the original show request did not specify
 * {@link #SHOW_WITH_SCREENSHOT}, this method will not be called.
 
 * @param screenshot This value may be {@code null}.
 * @apiSince 23
 */

public void onHandleScreenshot(@androidx.annotation.Nullable android.graphics.Bitmap screenshot) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean onKeyDown(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean onKeyLongPress(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean onKeyUp(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean onKeyMultiple(int keyCode, int count, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called when the user presses the back button while focus is in the session UI.  Note
 * that this will only happen if the session UI has requested input focus in its window;
 * otherwise, the back key will go to whatever window has focus and do whatever behavior
 * it normally has there.  The default implementation simply calls {@link #hide}.
 * @apiSince 23
 */

public void onBackPressed() { throw new RuntimeException("Stub!"); }

/**
 * Sessions automatically watch for requests that all system UI be closed (such as when
 * the user presses HOME), which will appear here.  The default implementation always
 * calls {@link #hide}.
 * @apiSince 21
 */

public void onCloseSystemDialogs() { throw new RuntimeException("Stub!"); }

/**
 * Called when the lockscreen was shown.
 * @apiSince 23
 */

public void onLockscreenShown() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void onConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void onLowMemory() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void onTrimMemory(int level) { throw new RuntimeException("Stub!"); }

/**
 * Compute the interesting insets into your UI.  The default implementation
 * sets {@link android.service.voice.VoiceInteractionSession.Insets#contentInsets Insets#contentInsets} to the height
 * of the window, meaning it should not adjust content underneath.  The default touchable
 * insets are {@link android.service.voice.VoiceInteractionSession.Insets#TOUCHABLE_INSETS_FRAME Insets#TOUCHABLE_INSETS_FRAME}, meaning it consumes all touch
 * events within its window frame.
 *
 * @param outInsets Fill in with the current UI insets.
 * @apiSince 23
 */

public void onComputeInsets(android.service.voice.VoiceInteractionSession.Insets outInsets) { throw new RuntimeException("Stub!"); }

/**
 * Called when a task initiated by {@link #startVoiceActivity(android.content.Intent)}
 * has actually started.
 *
 * @param intent The original {@link android.content.Intent Intent} supplied to
 * {@link #startVoiceActivity(android.content.Intent)}.
 * @param taskId Unique ID of the now running task.
 * @apiSince 23
 */

public void onTaskStarted(android.content.Intent intent, int taskId) { throw new RuntimeException("Stub!"); }

/**
 * Called when the last activity of a task initiated by
 * {@link #startVoiceActivity(android.content.Intent)} has finished.  The default
 * implementation calls {@link #finish()} on the assumption that this represents
 * the completion of a voice action.  You can override the implementation if you would
 * like a different behavior.
 *
 * @param intent The original {@link android.content.Intent Intent} supplied to
 * {@link #startVoiceActivity(android.content.Intent)}.
 * @param taskId Unique ID of the finished task.
 * @apiSince 23
 */

public void onTaskFinished(android.content.Intent intent, int taskId) { throw new RuntimeException("Stub!"); }

/**
 * Request to query for what extended commands the session supports.
 *
 * @param commands An array of commands that are being queried.
 * @return Return an array of booleans indicating which of each entry in the
 * command array is supported.  A true entry in the array indicates the command
 * is supported; false indicates it is not.  The default implementation returns
 * an array of all false entries.
 * @apiSince 23
 */

public boolean[] onGetSupportedCommands(java.lang.String[] commands) { throw new RuntimeException("Stub!"); }

/**
 * Request to confirm with the user before proceeding with an unrecoverable operation,
 * corresponding to a {@link android.app.VoiceInteractor.ConfirmationRequest
 * VoiceInteractor.ConfirmationRequest}.
 *
 * @param request The active request.
 * @apiSince 23
 */

public void onRequestConfirmation(android.service.voice.VoiceInteractionSession.ConfirmationRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Request for the user to pick one of N options, corresponding to a
 * {@link android.app.VoiceInteractor.PickOptionRequest VoiceInteractor.PickOptionRequest}.
 *
 * @param request The active request.
 * @apiSince 23
 */

public void onRequestPickOption(android.service.voice.VoiceInteractionSession.PickOptionRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Request to complete the voice interaction session because the voice activity successfully
 * completed its interaction using voice.  Corresponds to
 * {@link android.app.VoiceInteractor.CompleteVoiceRequest
 * VoiceInteractor.CompleteVoiceRequest}.  The default implementation just sends an empty
 * confirmation back to allow the activity to exit.
 *
 * @param request The active request.
 * @apiSince 23
 */

public void onRequestCompleteVoice(android.service.voice.VoiceInteractionSession.CompleteVoiceRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Request to abort the voice interaction session because the voice activity can not
 * complete its interaction using voice.  Corresponds to
 * {@link android.app.VoiceInteractor.AbortVoiceRequest
 * VoiceInteractor.AbortVoiceRequest}.  The default implementation just sends an empty
 * confirmation back to allow the activity to exit.
 *
 * @param request The active request.
 * @apiSince 23
 */

public void onRequestAbortVoice(android.service.voice.VoiceInteractionSession.AbortVoiceRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Process an arbitrary extended command from the caller,
 * corresponding to a {@link android.app.VoiceInteractor.CommandRequest
 * VoiceInteractor.CommandRequest}.
 *
 * @param request The active request.
 * @apiSince 23
 */

public void onRequestCommand(android.service.voice.VoiceInteractionSession.CommandRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Called when the {@link android.app.VoiceInteractor} has asked to cancel a {@link android.service.voice.VoiceInteractionSession.Request Request}
 * that was previously delivered to {@link #onRequestConfirmation},
 * {@link #onRequestPickOption}, {@link #onRequestCompleteVoice}, {@link #onRequestAbortVoice},
 * or {@link #onRequestCommand}.
 *
 * @param request The request that is being canceled.
 * @apiSince 23
 */

public void onCancelRequest(android.service.voice.VoiceInteractionSession.Request request) { throw new RuntimeException("Stub!"); }

/**
 * Print the Service's state into the given stream.  This gets invoked by
 * {@link android.service.voice.VoiceInteractionSessionService VoiceInteractionSessionService} when its Service
 * {@link android.app.Service#dump} method is called.
 *
 * @param prefix Text to print at the front of each line.
 * @param fd The raw file descriptor that the dump is being sent to.
 * @param writer The PrintWriter to which you should dump your state.  This will be
 * closed for you after you return.
 * @param args additional arguments to the dump request.
 * @apiSince 23
 */

public void dump(java.lang.String prefix, java.io.FileDescriptor fd, java.io.PrintWriter writer, java.lang.String[] args) { throw new RuntimeException("Stub!"); }

/**
 * Flag for use with {@link #onShow}: indicates that an Activity has invoked the voice
 * interaction service for a local interaction using
 * {@link android.app.Activity#startLocalVoiceInteraction(android.os.Bundle) Activity#startLocalVoiceInteraction(Bundle)}.
 * @apiSince 24
 */

public static final int SHOW_SOURCE_ACTIVITY = 16; // 0x10

/**
 * Flag for use with {@link #onShow}: indicates that the application itself has invoked
 * the assistant.
 * @apiSince 23
 */

public static final int SHOW_SOURCE_APPLICATION = 8; // 0x8

/**
 * Flag for use with {@link #onShow}: indicates that the session has been started from the
 * system assist gesture.
 * @apiSince 23
 */

public static final int SHOW_SOURCE_ASSIST_GESTURE = 4; // 0x4

/**
 * Flag for use with {@link #onShow}: indicates that the voice interaction service was invoked
 * from an Android automotive system UI.
 * @apiSince 29
 */

public static final int SHOW_SOURCE_AUTOMOTIVE_SYSTEM_UI = 128; // 0x80

/**
 * Flag for use with {@link #onShow}: indicates that the voice interaction service was invoked
 * from a notification.
 * @apiSince 29
 */

public static final int SHOW_SOURCE_NOTIFICATION = 64; // 0x40

/**
 * Flag for use with {@link #onShow}: indicates that the voice interaction service was invoked
 * from a physical button.
 * @apiSince 29
 */

public static final int SHOW_SOURCE_PUSH_TO_TALK = 32; // 0x20

/**
 * Flag received in {@link #onShow}: originator requested that the session be started with
 * assist data from the currently focused activity.
 * @apiSince 23
 */

public static final int SHOW_WITH_ASSIST = 1; // 0x1

/**
 * Flag received in {@link #onShow}: originator requested that the session be started with
 * a screen shot of the currently focused activity.
 * @apiSince 23
 */

public static final int SHOW_WITH_SCREENSHOT = 2; // 0x2
/**
 * A request to report that the current user interaction can not be completed with voice, as per
 * {@link android.app.VoiceInteractor.AbortVoiceRequest VoiceInteractor.AbortVoiceRequest}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class AbortVoiceRequest extends android.service.voice.VoiceInteractionSession.Request {

AbortVoiceRequest() { throw new RuntimeException("Stub!"); }

/**
 * Return the message informing the user of the problem, as per
 * {@link android.app.VoiceInteractor.AbortVoiceRequest VoiceInteractor.AbortVoiceRequest}.
 
 * @return This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.app.VoiceInteractor.Prompt getVoicePrompt() { throw new RuntimeException("Stub!"); }

/**
 * Return the message informing the user of the problem, as per
 * {@link android.app.VoiceInteractor.AbortVoiceRequest VoiceInteractor.AbortVoiceRequest}.
 * @deprecated Prefer {@link #getVoicePrompt()} which allows a separate visual message.
 
 * @return This value may be {@code null}.
 * @apiSince 23
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.Nullable
public java.lang.CharSequence getMessage() { throw new RuntimeException("Stub!"); }

/**
 * Report that the voice interactor has finished aborting the voice operation, resulting
 * in a call to
 * {@link android.app.VoiceInteractor.AbortVoiceRequest#onAbortResult
 * VoiceInteractor.AbortVoiceRequest.onAbortResult}.  This finishes the request (it
 * is no longer active).
 * @apiSince 23
 */

public void sendAbortResult(android.os.Bundle result) { throw new RuntimeException("Stub!"); }
}

/**
 * Represents the id of an assist source activity. You can use
 * {@link #equals(java.lang.Object)} to compare instances of this class.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class ActivityId {

ActivityId() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

/**
 * Represents assist state captured when this session was started.
 * It contains the various assist data objects and a reference to
 * the source activity.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class AssistState {

AssistState() { throw new RuntimeException("Stub!"); }

/**
 * @return whether the source activity is focused.
 * @apiSince 29
 */

public boolean isFocused() { throw new RuntimeException("Stub!"); }

/**
 * @return the index of the activity that this state is for or -1
 *     if there was no assist data captured.
 
 * Value is -1 or greater
 * @apiSince 29
 */

public int getIndex() { throw new RuntimeException("Stub!"); }

/**s
 * @return the total number of activities for which the assist data is
 * being returned.
 
 * Value is 0 or greater
 * @apiSince 29
 */

public int getCount() { throw new RuntimeException("Stub!"); }

/**
 * @return the id of the source activity
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.voice.VoiceInteractionSession.ActivityId getActivityId() { throw new RuntimeException("Stub!"); }

/**
 * @return Arbitrary data supplied by the app through
 * {@link android.app.Activity#onProvideAssistData Activity.onProvideAssistData}.
 * May be null if assist data has been disabled by the user or device policy.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.os.Bundle getAssistData() { throw new RuntimeException("Stub!"); }

/**
 * @return If available, the structure definition of all windows currently
 * displayed by the app. May be null if assist data has been disabled by the user
 * or device policy; will be an empty stub if the application has disabled assist
 * by marking its window as secure.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.app.assist.AssistStructure getAssistStructure() { throw new RuntimeException("Stub!"); }

/**
 * @return Additional content data supplied by the app through
 * {@link android.app.Activity#onProvideAssistContent Activity.onProvideAssistContent}.
 * May be null if assist data has been disabled by the user or device policy; will
 * not be automatically filled in with data from the app if the app has marked its
 * window as secure.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.app.assist.AssistContent getAssistContent() { throw new RuntimeException("Stub!"); }
}

/**
 * A generic vendor-specific request, as per
 * {@link android.app.VoiceInteractor.CommandRequest VoiceInteractor.CommandRequest}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CommandRequest extends android.service.voice.VoiceInteractionSession.Request {

CommandRequest() { throw new RuntimeException("Stub!"); }

/**
 * Return the command that is being executed, as per
 * {@link android.app.VoiceInteractor.CommandRequest VoiceInteractor.CommandRequest}.
 * @apiSince 23
 */

public java.lang.String getCommand() { throw new RuntimeException("Stub!"); }

/**
 * Report an intermediate result of the request, without completing it (the request
 * is still active and the app is waiting for the final result), resulting in a call to
 * {@link android.app.VoiceInteractor.CommandRequest#onCommandResult
 * VoiceInteractor.CommandRequest.onCommandResult} with false for isCompleted.
 * @apiSince 23
 */

public void sendIntermediateResult(android.os.Bundle result) { throw new RuntimeException("Stub!"); }

/**
 * Report the final result of the request, completing the request and resulting in a call to
 * {@link android.app.VoiceInteractor.CommandRequest#onCommandResult
 * VoiceInteractor.CommandRequest.onCommandResult} with true for isCompleted.
 * This finishes the request (it is no longer active).
 * @apiSince 23
 */

public void sendResult(android.os.Bundle result) { throw new RuntimeException("Stub!"); }
}

/**
 * A request to simply inform the user that the voice operation has completed, as per
 * {@link android.app.VoiceInteractor.CompleteVoiceRequest
 * VoiceInteractor.CompleteVoiceRequest}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CompleteVoiceRequest extends android.service.voice.VoiceInteractionSession.Request {

CompleteVoiceRequest() { throw new RuntimeException("Stub!"); }

/**
 * Return the message informing the user of the completion, as per
 * {@link android.app.VoiceInteractor.CompleteVoiceRequest
 * VoiceInteractor.CompleteVoiceRequest}.
 
 * @return This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.app.VoiceInteractor.Prompt getVoicePrompt() { throw new RuntimeException("Stub!"); }

/**
 * Return the message informing the user of the completion, as per
 * {@link android.app.VoiceInteractor.CompleteVoiceRequest
 * VoiceInteractor.CompleteVoiceRequest}.
 * @deprecated Prefer {@link #getVoicePrompt()} which allows a separate visual message.
 
 * @return This value may be {@code null}.
 * @apiSince 23
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.Nullable
public java.lang.CharSequence getMessage() { throw new RuntimeException("Stub!"); }

/**
 * Report that the voice interactor has finished completing the voice operation, resulting
 * in a call to
 * {@link android.app.VoiceInteractor.CompleteVoiceRequest#onCompleteResult
 * VoiceInteractor.CompleteVoiceRequest.onCompleteResult}.
 * This finishes the request (it is no longer active).
 * @apiSince 23
 */

public void sendCompleteResult(android.os.Bundle result) { throw new RuntimeException("Stub!"); }
}

/**
 * A request for confirmation from the user of an operation, as per
 * {@link android.app.VoiceInteractor.ConfirmationRequest
 * VoiceInteractor.ConfirmationRequest}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class ConfirmationRequest extends android.service.voice.VoiceInteractionSession.Request {

ConfirmationRequest() { throw new RuntimeException("Stub!"); }

/**
 * Return the prompt informing the user of what will happen, as per
 * {@link android.app.VoiceInteractor.ConfirmationRequest
 * VoiceInteractor.ConfirmationRequest}.
 
 * @return This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.app.VoiceInteractor.Prompt getVoicePrompt() { throw new RuntimeException("Stub!"); }

/**
 * Return the prompt informing the user of what will happen, as per
 * {@link android.app.VoiceInteractor.ConfirmationRequest
 * VoiceInteractor.ConfirmationRequest}.
 * @deprecated Prefer {@link #getVoicePrompt()} which allows multiple voice prompts.
 
 * @return This value may be {@code null}.
 * @apiSince 23
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.Nullable
public java.lang.CharSequence getPrompt() { throw new RuntimeException("Stub!"); }

/**
 * Report that the voice interactor has confirmed the operation with the user, resulting
 * in a call to
 * {@link android.app.VoiceInteractor.ConfirmationRequest#onConfirmationResult
 * VoiceInteractor.ConfirmationRequest.onConfirmationResult}.
 * This finishes the request (it is no longer active).
 * @apiSince 23
 */

public void sendConfirmationResult(boolean confirmed, android.os.Bundle result) { throw new RuntimeException("Stub!"); }
}

/**
 * Information about where interesting parts of the input method UI appear.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Insets {

public Insets() { throw new RuntimeException("Stub!"); }

/**
 * Option for {@link #touchableInsets}: the area inside of
 * the content insets can be touched.
 * @apiSince 23
 */

public static final int TOUCHABLE_INSETS_CONTENT = 1; // 0x1

/**
 * Option for {@link #touchableInsets}: the entire window frame
 * can be touched.
 * @apiSince 23
 */

public static final int TOUCHABLE_INSETS_FRAME = 0; // 0x0

/**
 * Option for {@link #touchableInsets}: the region specified by
 * {@link #touchableRegion} can be touched.
 * @apiSince 23
 */

public static final int TOUCHABLE_INSETS_REGION = 3; // 0x3

/**
 * This is the part of the UI that is the main content.  It is
 * used to determine the basic space needed, to resize/pan the
 * application behind.  It is assumed that this inset does not
 * change very much, since any change will cause a full resize/pan
 * of the application behind.  This value is relative to the top edge
 * of the input method window.
 * @apiSince 23
 */

public final android.graphics.Rect contentInsets;
{ contentInsets = null; }

/**
 * Determine which area of the window is touchable by the user.  May
 * be one of: {@link #TOUCHABLE_INSETS_FRAME},
 * {@link #TOUCHABLE_INSETS_CONTENT}, or {@link #TOUCHABLE_INSETS_REGION}.
 * @apiSince 23
 */

public int touchableInsets;

/**
 * This is the region of the UI that is touchable.  It is used when
 * {@link #touchableInsets} is set to {@link #TOUCHABLE_INSETS_REGION}.
 * The region should be specified relative to the origin of the window frame.
 * @apiSince 23
 */

public final android.graphics.Region touchableRegion;
{ touchableRegion = null; }
}

/**
 * A request for the user to pick from a set of option, as per
 * {@link android.app.VoiceInteractor.PickOptionRequest VoiceInteractor.PickOptionRequest}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class PickOptionRequest extends android.service.voice.VoiceInteractionSession.Request {

PickOptionRequest() { throw new RuntimeException("Stub!"); }

/**
 * Return the prompt informing the user of what they are picking, as per
 * {@link android.app.VoiceInteractor.PickOptionRequest VoiceInteractor.PickOptionRequest}.
 
 * @return This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.app.VoiceInteractor.Prompt getVoicePrompt() { throw new RuntimeException("Stub!"); }

/**
 * Return the prompt informing the user of what they are picking, as per
 * {@link android.app.VoiceInteractor.PickOptionRequest VoiceInteractor.PickOptionRequest}.
 * @deprecated Prefer {@link #getVoicePrompt()} which allows multiple voice prompts.
 
 * @return This value may be {@code null}.
 * @apiSince 23
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.Nullable
public java.lang.CharSequence getPrompt() { throw new RuntimeException("Stub!"); }

/**
 * Return the set of options the user is picking from, as per
 * {@link android.app.VoiceInteractor.PickOptionRequest VoiceInteractor.PickOptionRequest}.
 * @apiSince 23
 */

public android.app.VoiceInteractor.PickOptionRequest.Option[] getOptions() { throw new RuntimeException("Stub!"); }

/**
 * Report an intermediate option selection from the request, without completing it (the
 * request is still active and the app is waiting for the final option selection),
 * resulting in a call to
 * {@link android.app.VoiceInteractor.PickOptionRequest#onPickOptionResult
 * VoiceInteractor.PickOptionRequest.onPickOptionResult} with false for finished.
 * @apiSince 23
 */

public void sendIntermediatePickOptionResult(android.app.VoiceInteractor.PickOptionRequest.Option[] selections, android.os.Bundle result) { throw new RuntimeException("Stub!"); }

/**
 * Report the final option selection for the request, completing the request
 * and resulting in a call to
 * {@link android.app.VoiceInteractor.PickOptionRequest#onPickOptionResult
 * VoiceInteractor.PickOptionRequest.onPickOptionResult} with false for finished.
 * This finishes the request (it is no longer active).
 * @apiSince 23
 */

public void sendPickOptionResult(android.app.VoiceInteractor.PickOptionRequest.Option[] selections, android.os.Bundle result) { throw new RuntimeException("Stub!"); }
}

/**
 * Base class representing a request from a voice-driver app to perform a particular
 * voice operation with the user.  See related subclasses for the types of requests
 * that are possible.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Request {

Request() { throw new RuntimeException("Stub!"); }

/**
 * Return the uid of the application that initiated the request.
 * @apiSince 23
 */

public int getCallingUid() { throw new RuntimeException("Stub!"); }

/**
 * Return the package name of the application that initiated the request.
 * @apiSince 23
 */

public java.lang.String getCallingPackage() { throw new RuntimeException("Stub!"); }

/**
 * Return any additional extra information that was supplied as part of the request.
 * @apiSince 23
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Check whether this request is currently active.  A request becomes inactive after
 * calling {@link #cancel} or a final result method that completes the request.  After
 * this point, further interactions with the request will result in
 * {@link java.lang.IllegalStateException} errors; you should not catch these errors,
 * but can use this method if you need to determine the state of the request.  Returns
 * true if the request is still active.
 * @apiSince 23
 */

public boolean isActive() { throw new RuntimeException("Stub!"); }

/**
 * Ask the app to cancel this current request.
 * This also finishes the request (it is no longer active).
 * @apiSince 23
 */

public void cancel() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

}

