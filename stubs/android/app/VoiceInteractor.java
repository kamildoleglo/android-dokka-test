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


package android.app;

import android.content.Context;
import java.util.concurrent.Executor;
import android.os.Bundle;

/**
 * Interface for an {@link android.app.Activity Activity} to interact with the user through voice.  Use
 * {@link android.app.Activity#getVoiceInteractor() Activity.getVoiceInteractor}
 * to retrieve the interface, if the activity is currently involved in a voice interaction.
 *
 * <p>The voice interactor revolves around submitting voice interaction requests to the
 * back-end voice interaction service that is working with the user.  These requests are
 * submitted with {@link #submitRequest}, providing a new instance of a
 * {@link android.app.VoiceInteractor.Request Request} subclass describing the type of operation to perform -- currently the
 * possible requests are {@link android.app.VoiceInteractor.ConfirmationRequest ConfirmationRequest} and {@link android.app.VoiceInteractor.CommandRequest CommandRequest}.
 *
 * <p>Once a request is submitted, the voice system will process it and eventually deliver
 * the result to the request object.  The application can cancel a pending request at any
 * time.
 *
 * <p>The VoiceInteractor is integrated with Activity's state saving mechanism, so that
 * if an activity is being restarted with retained state, it will retain the current
 * VoiceInteractor and any outstanding requests.  Because of this, you should always use
 * {@link android.app.VoiceInteractor.Request#getActivity() Request#getActivity()} to get back to the activity of a
 * request, rather than holding on to the activity instance yourself, either explicitly
 * or implicitly through a non-static inner class.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class VoiceInteractor {

VoiceInteractor() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean submitRequest(android.app.VoiceInteractor.Request request) { throw new RuntimeException("Stub!"); }

/**
 * Submit a new {@link android.app.VoiceInteractor.Request Request} to the voice interaction service.  The request must be
 * one of the available subclasses -- {@link android.app.VoiceInteractor.ConfirmationRequest ConfirmationRequest}, {@link android.app.VoiceInteractor.PickOptionRequest PickOptionRequest},
 * {@link android.app.VoiceInteractor.CompleteVoiceRequest CompleteVoiceRequest}, {@link android.app.VoiceInteractor.AbortVoiceRequest AbortVoiceRequest}, or {@link android.app.VoiceInteractor.CommandRequest CommandRequest}.
 *
 * @param request The desired request to submit.
 * @param name An optional name for this request, or null. This can be used later with
 * {@link #getActiveRequests} and {@link #getActiveRequest} to find the request.
 *
 * @return Returns true of the request was successfully submitted, else false.
 * @apiSince 23
 */

public boolean submitRequest(android.app.VoiceInteractor.Request request, java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Return all currently active requests.
 * @apiSince 23
 */

public android.app.VoiceInteractor.Request[] getActiveRequests() { throw new RuntimeException("Stub!"); }

/**
 * Return any currently active request that was submitted with the given name.
 *
 * @param name The name used to submit the request, as per
 * {@link #submitRequest(android.app.VoiceInteractor.Request,java.lang.String)}.
 * @return Returns the active request with that name, or null if there was none.
 * @apiSince 23
 */

public android.app.VoiceInteractor.Request getActiveRequest(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Queries the supported commands available from the VoiceInteractionService.
 * The command is a string that describes the generic operation to be performed.
 * An example might be "org.example.commands.PICK_DATE" to ask the user to pick
 * a date.  (Note: This is not an actual working example.)
 *
 * @param commands The array of commands to query for support.
 * @return Array of booleans indicating whether each command is supported or not.
 * @apiSince 23
 */

public boolean[] supportsCommands(java.lang.String[] commands) { throw new RuntimeException("Stub!"); }

/**
 * @return whether the voice interactor is destroyed. You should not interact
 * with a destroyed voice interactor.
 * @apiSince 29
 */

public boolean isDestroyed() { throw new RuntimeException("Stub!"); }

/**
 * Registers a callback to be called when the VoiceInteractor is destroyed.
 *
 * @param executor Executor on which to run the callback.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param callback The callback to run.
 * This value must never be {@code null}.
 * @return whether the callback was registered.
 * @apiSince 29
 */

public boolean registerOnDestroyedCallback(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull java.lang.Runnable callback) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a previously registered onDestroy callback
 *
 * @param callback The callback to remove.
 * This value must never be {@code null}.
 * @return whether the callback was unregistered.
 * @apiSince 29
 */

public boolean unregisterOnDestroyedCallback(@androidx.annotation.NonNull java.lang.Runnable callback) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the assist framework that the direct actions supported by the app changed.
 * @apiSince 29
 */

public void notifyDirectActionsChanged() { throw new RuntimeException("Stub!"); }
/**
 * Reports that the current interaction can not be complete with voice, so the
 * application will need to switch to a traditional input UI.  Applications should
 * only use this when they need to completely bail out of the voice interaction
 * and switch to a traditional UI.  When the response comes back, the voice
 * system has handled the request and is ready to switch; at that point the application
 * can start a new non-voice activity.  Be sure when starting the new activity
 * to use {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK
 * Intent.FLAG_ACTIVITY_NEW_TASK} to keep the new activity out of the current voice
 * interaction task.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class AbortVoiceRequest extends android.app.VoiceInteractor.Request {

/**
 * Create a new voice abort request.
 * @param prompt Optional message to speak to the user indicating why the task could
 *     not be completed by voice or null if nothing should be spoken.
 * This value may be {@code null}.
 * @param extras Additional optional information or null.
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public AbortVoiceRequest(@androidx.annotation.Nullable android.app.VoiceInteractor.Prompt prompt, @androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void onAbortResult(android.os.Bundle result) { throw new RuntimeException("Stub!"); }
}

/**
 * Execute a vendor-specific command using the trusted system VoiceInteractionService.
 * This allows an Activity to request additional information from the user needed to
 * complete an action (e.g. booking a table might have several possible times that the
 * user could select from or an app might need the user to agree to a terms of service).
 * The result of the confirmation will be returned through an asynchronous call to
 * either {@link #onCommandResult(boolean,android.os.Bundle)} or
 * {@link #onCancel()}.
 *
 * <p>The command is a string that describes the generic operation to be performed.
 * The command will determine how the properties in extras are interpreted and the set of
 * available commands is expected to grow over time.  An example might be
 * "com.google.voice.commands.REQUEST_NUMBER_BAGS" to request the number of bags as part of
 * airline check-in.  (This is not an actual working example.)
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class CommandRequest extends android.app.VoiceInteractor.Request {

/**
 * Create a new generic command request.
 * @param command The desired command to perform.
 * @param args Additional arguments to control execution of the command.
 * @apiSince 23
 */

public CommandRequest(java.lang.String command, android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Results for CommandRequest can be returned in partial chunks.
 * The isCompleted is set to true iff all results have been returned, indicating the
 * CommandRequest has completed.
 * @apiSince 23
 */

public void onCommandResult(boolean isCompleted, android.os.Bundle result) { throw new RuntimeException("Stub!"); }
}

/**
 * Reports that the current interaction was successfully completed with voice, so the
 * application can report the final status to the user. When the response comes back, the
 * voice system has handled the request and is ready to switch; at that point the
 * application can start a new non-voice activity or finish.  Be sure when starting the new
 * activity to use {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK
 * Intent.FLAG_ACTIVITY_NEW_TASK} to keep the new activity out of the current voice
 * interaction task.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class CompleteVoiceRequest extends android.app.VoiceInteractor.Request {

/**
 * Create a new completed voice interaction request.
 * @param prompt Optional message to speak to the user about the completion status of
 *     the task or null if nothing should be spoken.
 * This value may be {@code null}.
 * @param extras Additional optional information or null.
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public CompleteVoiceRequest(@androidx.annotation.Nullable android.app.VoiceInteractor.Prompt prompt, @androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void onCompleteResult(android.os.Bundle result) { throw new RuntimeException("Stub!"); }
}

/**
 * Confirms an operation with the user via the trusted system
 * VoiceInteractionService.  This allows an Activity to complete an unsafe operation that
 * would require the user to touch the screen when voice interaction mode is not enabled.
 * The result of the confirmation will be returned through an asynchronous call to
 * either {@link #onConfirmationResult(boolean,android.os.Bundle)} or
 * {@link #onCancel()} - these methods should be overridden to define the application specific
 *  behavior.
 *
 * <p>In some cases this may be a simple yes / no confirmation or the confirmation could
 * include context information about how the action will be completed
 * (e.g. booking a cab might include details about how long until the cab arrives)
 * so the user can give a confirmation.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class ConfirmationRequest extends android.app.VoiceInteractor.Request {

/**
 * Create a new confirmation request.
 * @param prompt Optional confirmation to speak to the user or null if nothing
 *     should be spoken.
 * This value may be {@code null}.
 * @param extras Additional optional information or null.
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public ConfirmationRequest(@androidx.annotation.Nullable android.app.VoiceInteractor.Prompt prompt, @androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Handle the confirmation result. Override this method to define
 * the behavior when the user confirms or rejects the operation.
 * @param confirmed Whether the user confirmed or rejected the operation.
 * @param result Additional result information or null.
 * @apiSince 23
 */

public void onConfirmationResult(boolean confirmed, android.os.Bundle result) { throw new RuntimeException("Stub!"); }
}

/**
 * Select a single option from multiple potential options with the user via the trusted system
 * VoiceInteractionService. Typically, the application would present this visually as
 * a list view to allow selecting the option by touch.
 * The result of the confirmation will be returned through an asynchronous call to
 * either {@link #onPickOptionResult} or {@link #onCancel()} - these methods should
 * be overridden to define the application specific behavior.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class PickOptionRequest extends android.app.VoiceInteractor.Request {

/**
 * Create a new pick option request.
 * @param prompt Optional question to be asked of the user when the options are
 *     presented or null if nothing should be asked.
 * This value may be {@code null}.
 * @param options The set of {@link android.app.VoiceInteractor.PickOptionRequest.Option Option}s the user is selecting from.
 * @param extras Additional optional information or null.
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public PickOptionRequest(@androidx.annotation.Nullable android.app.VoiceInteractor.Prompt prompt, android.app.VoiceInteractor.PickOptionRequest.Option[] options, @androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Called when a single option is confirmed or narrowed to one of several options. Override
 * this method to define the behavior when the user selects an option or narrows down the
 * set of options.
 * @param finished True if the voice interaction has finished making a selection, in
 *     which case {@code selections} contains the final result.  If false, this request is
 *     still active and you will continue to get calls on it.
 * @param selections Either a single {@link android.app.VoiceInteractor.PickOptionRequest.Option Option} or one of several {@link android.app.VoiceInteractor.PickOptionRequest.Option Option}s the
 *     user has narrowed the choices down to.
 * @param result Additional optional information.
 * @apiSince 23
 */

public void onPickOptionResult(boolean finished, android.app.VoiceInteractor.PickOptionRequest.Option[] selections, android.os.Bundle result) { throw new RuntimeException("Stub!"); }
/**
 * Represents a single option that the user may select using their voice. The
 * {@link #getIndex()} method should be used as a unique ID to identify the option
 * when it is returned from the voice interactor.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Option implements android.os.Parcelable {

/**
 * Creates an option that a user can select with their voice by matching the label
 * or one of several synonyms.
 * @param label The label that will both be matched against what the user speaks
 *     and displayed visually.
 * @param index The location of this option within the overall set of options.
 *     Can be used to help identify the option when it is returned from the
 *     voice interactor.
 * @apiSince 23
 */

public Option(java.lang.CharSequence label, int index) { throw new RuntimeException("Stub!"); }

/**
 * Add a synonym term to the option to indicate an alternative way the content
 * may be matched.
 * @param synonym The synonym that will be matched against what the user speaks,
 *     but not displayed.
 * @apiSince 23
 */

public android.app.VoiceInteractor.PickOptionRequest.Option addSynonym(java.lang.CharSequence synonym) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getLabel() { throw new RuntimeException("Stub!"); }

/**
 * Return the index that was supplied in the constructor.
 * If the option was constructed without an index, -1 is returned.
 * @apiSince 23
 */

public int getIndex() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int countSynonyms() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getSynonymAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Set optional extra information associated with this option.  Note that this
 * method takes ownership of the supplied extras Bundle.
 * @apiSince 23
 */

public void setExtras(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Return any optional extras information associated with this option, or null
 * if there is none.  Note that this method returns a reference to the actual
 * extras Bundle in the option, so modifications to it will directly modify the
 * extras in the option.
 * @apiSince 23
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.VoiceInteractor.PickOptionRequest.Option> CREATOR;
static { CREATOR = null; }
}

}

/**
 * A set of voice prompts to use with the voice interaction system to confirm an action, select
 * an option, or do similar operations. Multiple voice prompts may be provided for variety. A
 * visual prompt must be provided, which might not match the spoken version. For example, the
 * confirmation "Are you sure you want to purchase this item?" might use a visual label like
 * "Purchase item".
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Prompt implements android.os.Parcelable {

/**
 * Constructs a prompt set.
 * @param voicePrompts An array of one or more voice prompts. Must not be empty or null.
 * This value must never be {@code null}.
 * @param visualPrompt A prompt to display on the screen. Must not be null.
 
 * This value must never be {@code null}.
 * @apiSince 23
 */

public Prompt(@androidx.annotation.NonNull java.lang.CharSequence[] voicePrompts, @androidx.annotation.NonNull java.lang.CharSequence visualPrompt) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a prompt set with single prompt used for all interactions. This is most useful
 * in test apps. Non-trivial apps should prefer the detailed constructor.
 
 * @param prompt This value must never be {@code null}.
 * @apiSince 23
 */

public Prompt(@androidx.annotation.NonNull java.lang.CharSequence prompt) { throw new RuntimeException("Stub!"); }

/**
 * Returns a prompt to use for voice interactions.
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public java.lang.CharSequence getVoicePromptAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of different voice prompts.
 * @apiSince 23
 */

public int countVoicePrompts() { throw new RuntimeException("Stub!"); }

/**
 * Returns the prompt to use for visual display.
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public java.lang.CharSequence getVisualPrompt() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.VoiceInteractor.Prompt> CREATOR;
static { CREATOR = null; }
}

/**
 * Base class for voice interaction requests that can be submitted to the interactor.
 * Do not instantiate this directly -- instead, use the appropriate subclass.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Request {

Request() { throw new RuntimeException("Stub!"); }

/**
 * Return the name this request was submitted through
 * {@link #submitRequest(android.app.VoiceInteractor.Request,java.lang.String)}.
 * @apiSince 23
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Cancel this active request.
 * @apiSince 23
 */

public void cancel() { throw new RuntimeException("Stub!"); }

/**
 * Return the current {@link android.content.Context Context} this request is associated with.  May change
 * if the activity hosting it goes through a configuration change.
 * @apiSince 23
 */

public android.content.Context getContext() { throw new RuntimeException("Stub!"); }

/**
 * Return the current {@link android.app.Activity Activity} this request is associated with.  Will change
 * if the activity is restarted such as through a configuration change.
 * @apiSince 23
 */

public android.app.Activity getActivity() { throw new RuntimeException("Stub!"); }

/**
 * Report from voice interaction service: this operation has been canceled, typically
 * as a completion of a previous call to {@link #cancel} or when the user explicitly
 * cancelled.
 * @apiSince 23
 */

public void onCancel() { throw new RuntimeException("Stub!"); }

/**
 * The request is now attached to an activity, or being re-attached to a new activity
 * after a configuration change.
 * @apiSince 23
 */

public void onAttached(android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * The request is being detached from an activity.
 * @apiSince 23
 */

public void onDetached() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

}

