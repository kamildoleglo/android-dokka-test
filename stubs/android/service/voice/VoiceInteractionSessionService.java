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


/**
 * An active voice interaction session, initiated by a {@link android.service.voice.VoiceInteractionService VoiceInteractionService}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class VoiceInteractionSessionService extends android.app.Service {

public VoiceInteractionSessionService() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void onCreate() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public abstract android.service.voice.VoiceInteractionSession onNewSession(android.os.Bundle args);

/** @apiSince 21 */

public android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void onConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void onLowMemory() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void onTrimMemory(int level) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void dump(java.io.FileDescriptor fd, java.io.PrintWriter writer, java.lang.String[] args) { throw new RuntimeException("Stub!"); }
}

