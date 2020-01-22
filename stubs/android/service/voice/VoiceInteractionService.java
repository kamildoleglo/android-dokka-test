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

import java.util.Set;
import android.content.Intent;

/**
 * Top-level service of the current global voice interactor, which is providing
 * support for hotwording, the back-end of a {@link android.app.VoiceInteractor}, etc.
 * The current VoiceInteractionService that has been selected by the user is kept
 * always running by the system, to allow it to do things like listen for hotwords
 * in the background to instigate voice interactions.
 *
 * <p>Because this service is always running, it should be kept as lightweight as
 * possible.  Heavy-weight operations (including showing UI) should be implemented
 * in the associated {@link android.service.voice.VoiceInteractionSessionService} when
 * an actual voice interaction is taking place, and that service should run in a
 * separate process from this one.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class VoiceInteractionService extends android.app.Service {

public VoiceInteractionService() { throw new RuntimeException("Stub!"); }

/**
 * Called when a user has activated an affordance to launch voice assist from the Keyguard.
 *
 * <p>This method will only be called if the VoiceInteractionService has set
 * {@link android.R.attr#supportsLaunchVoiceAssistFromKeyguard} and the Keyguard is showing.</p>
 *
 * <p>A valid implementation must start a new activity that should use {@link
 * android.view.WindowManager.LayoutParams#FLAG_SHOW_WHEN_LOCKED} to display
 * on top of the lock screen.</p>
 * @apiSince 23
 */

public void onLaunchVoiceAssistFromKeyguard() { throw new RuntimeException("Stub!"); }

/**
 * Check whether the given service component is the currently active
 * VoiceInteractionService.
 * @apiSince 21
 */

public static boolean isActiveService(android.content.Context context, android.content.ComponentName service) { throw new RuntimeException("Stub!"); }

/**
 * Set contextual options you would always like to have disabled when a session
 * is shown.  The flags may be any combination of
 * {@link android.service.voice.VoiceInteractionSession#SHOW_WITH_ASSIST VoiceInteractionSession#SHOW_WITH_ASSIST} and
 * {@link android.service.voice.VoiceInteractionSession#SHOW_WITH_SCREENSHOT VoiceInteractionSession#SHOW_WITH_SCREENSHOT}.
 * @apiSince 23
 */

public void setDisabledShowContext(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Return the value set by {@link #setDisabledShowContext}.
 * @apiSince 23
 */

public int getDisabledShowContext() { throw new RuntimeException("Stub!"); }

/**
 * Request that the associated {@link android.service.voice.VoiceInteractionSession} be
 * shown to the user, starting it if necessary.
 * @param args Arbitrary arguments that will be propagated to the session.
 * @param flags Indicates additional optional behavior that should be performed.  May
 * be any combination of
 * {@link android.service.voice.VoiceInteractionSession#SHOW_WITH_ASSIST VoiceInteractionSession#SHOW_WITH_ASSIST} and
 * {@link android.service.voice.VoiceInteractionSession#SHOW_WITH_SCREENSHOT VoiceInteractionSession#SHOW_WITH_SCREENSHOT}
 * to request that the system generate and deliver assist data on the current foreground
 * app as part of showing the session UI.
 * @apiSince 23
 */

public void showSession(android.os.Bundle args, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Request to query for what extended voice actions this service supports. This method will
 * be called when the system checks the supported actions of this
 * {@link android.service.voice.VoiceInteractionService VoiceInteractionService}. Supported actions may be delivered to
 * {@link android.service.voice.VoiceInteractionSession VoiceInteractionSession} later to request a session to perform an action.
 *
 * <p>Voice actions are defined in support libraries and could vary based on platform context.
 * For example, car related voice actions will be defined in car support libraries.
 *
 * @param voiceActions A set of checked voice actions.
 * This value must never be {@code null}.
 * @return Returns a subset of checked voice actions. Additional voice actions in the
 * returned set will be ignored. Returns empty set if no actions are supported.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.Set<java.lang.String> onGetSupportedVoiceActions(@androidx.annotation.NonNull java.util.Set<java.lang.String> voiceActions) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called during service initialization to tell you when the system is ready
 * to receive interaction from it. You should generally do initialization here
 * rather than in {@link #onCreate}. Methods such as {@link #showSession} and
 * {@link #createAlwaysOnHotwordDetector}
 * will not be operational until this point.
 * @apiSince 21
 */

public void onReady() { throw new RuntimeException("Stub!"); }

/**
 * Called during service de-initialization to tell you when the system is shutting the
 * service down.
 * At this point this service may no longer be the active {@link android.service.voice.VoiceInteractionService VoiceInteractionService}.
 * @apiSince 21
 */

public void onShutdown() { throw new RuntimeException("Stub!"); }

/**
 * Creates an {@link android.service.voice.AlwaysOnHotwordDetector AlwaysOnHotwordDetector} for the given keyphrase and locale.
 * This instance must be retained and used by the client.
 * Calling this a second time invalidates the previously created hotword detector
 * which can no longer be used to manage recognition.
 *
 * @param keyphrase The keyphrase that's being used, for example "Hello Android".
 * @param locale The locale for which the enrollment needs to be performed.
 * @param callback The callback to notify of detection events.
 * @return An always-on hotword detector for the given keyphrase and locale.
 * @apiSince 21
 */

public final android.service.voice.AlwaysOnHotwordDetector createAlwaysOnHotwordDetector(java.lang.String keyphrase, java.util.Locale locale, android.service.voice.AlwaysOnHotwordDetector.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Provide hints to be reflected in the system UI.
 *
 * @param hints Arguments used to show UI.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public final void setUiHints(@androidx.annotation.NonNull android.os.Bundle hints) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void dump(java.io.FileDescriptor fd, java.io.PrintWriter pw, java.lang.String[] args) { throw new RuntimeException("Stub!"); }

/**
 * The {@link android.content.Intent Intent} that must be declared as handled by the service.
 * To be supported, the service must also require the
 * {@link android.Manifest.permission#BIND_VOICE_INTERACTION} permission so
 * that other applications can not abuse it.
 * @apiSince 21
 */

public static final java.lang.String SERVICE_INTERFACE = "android.service.voice.VoiceInteractionService";

/**
 * Name under which a VoiceInteractionService component publishes information about itself.
 * This meta-data should reference an XML resource containing a
 * <code>&lt;{@link
 * android.R.styleable#VoiceInteractionService voice-interaction-service}&gt;</code> tag.
 * @apiSince 21
 */

public static final java.lang.String SERVICE_META_DATA = "android.voice_interaction";
}

