/*
 * Copyright (C) 2015 The Android Open Source Project
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
 * limitations under the License
 */


package android.service.media;


/**
 * Extend this class to implement a camera prewarm service. See
 * {@link android.provider.MediaStore#META_DATA_STILL_IMAGE_CAMERA_PREWARM_SERVICE}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CameraPrewarmService extends android.app.Service {

public CameraPrewarmService() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean onUnbind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called when the camera should be prewarmed.
 * @apiSince 23
 */

public abstract void onPrewarm();

/**
 * Called when prewarm phase is done, either because the camera launch intent has been fired
 * at this point or prewarm is no longer needed. A client should close the camera
 * immediately in the latter case.
 * <p>
 * In case the camera launch intent has been fired, there is no guarantee about the ordering
 * of these two events. Cooldown might happen either before or after the activity has been
 * created that handles the camera intent.
 *
 * @param cameraIntentFired Indicates whether the intent to launch the camera has been
 *                          fired.
 * @apiSince 23
 */

public abstract void onCooldown(boolean cameraIntentFired);
}

