/*
 * Copyright (C) 2017 The Android Open Source Project
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



package android.hardware.camera2.params;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraCaptureSession;
import java.util.concurrent.Executor;
import java.util.List;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;

/**
 * A helper class that aggregates all supported arguments for capture session initialization.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SessionConfiguration implements android.os.Parcelable {

/**
 * Create a new {@link android.hardware.camera2.params.SessionConfiguration SessionConfiguration}.
 *
 * @param sessionType The session type.
 * Value is {@link android.hardware.camera2.params.SessionConfiguration#SESSION_REGULAR}, or {@link android.hardware.camera2.params.SessionConfiguration#SESSION_HIGH_SPEED}
 * @param outputs A list of output configurations for the capture session.
 * This value must never be {@code null}.
 * @param executor The executor which should be used to invoke the callback. In general it is
 *                 recommended that camera operations are not done on the main (UI) thread.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param cb A state callback interface implementation.
 *
 * This value must never be {@code null}.
 * @see #SESSION_REGULAR
 * @see #SESSION_HIGH_SPEED
 * @see CameraDevice#createCaptureSession(List, CameraCaptureSession.StateCallback, Handler)
 * @see android.hardware.camera2.CameraDevice#createCaptureSessionByOutputConfigurations
 * @see android.hardware.camera2.CameraDevice#createReprocessableCaptureSession
 * @see android.hardware.camera2.CameraDevice#createConstrainedHighSpeedCaptureSession
 * @apiSince 28
 */

public SessionConfiguration(int sessionType, @androidx.annotation.NonNull java.util.List<android.hardware.camera2.params.OutputConfiguration> outputs, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.hardware.camera2.CameraCaptureSession.StateCallback cb) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Check if this {@link android.hardware.camera2.params.SessionConfiguration SessionConfiguration} is equal to another {@link android.hardware.camera2.params.SessionConfiguration SessionConfiguration}.
 *
 * <p>Two output session configurations are only equal if and only if the underlying input
 * configuration, output configurations, and session type are equal. </p>
 *
 * @return {@code true} if the objects were equal, {@code false} otherwise
 * @apiSince 28
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 28
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the type of the capture session.
 *
 * @return The capture session type.
 
 * Value is {@link android.hardware.camera2.params.SessionConfiguration#SESSION_REGULAR}, or {@link android.hardware.camera2.params.SessionConfiguration#SESSION_HIGH_SPEED}
 * @apiSince 28
 */

public int getSessionType() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the {@link android.hardware.camera2.params.OutputConfiguration OutputConfiguration} list for the capture session.
 *
 * @return A list of output configurations for the capture session.
 * @apiSince 28
 */

public java.util.List<android.hardware.camera2.params.OutputConfiguration> getOutputConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the {@link android.hardware.camera2.CameraCaptureSession.StateCallback CameraCaptureSession.StateCallback} for the capture session.
 *
 * @return A state callback interface implementation.
 * @apiSince 28
 */

public android.hardware.camera2.CameraCaptureSession.StateCallback getStateCallback() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the {@link java.util.concurrent.Executor} for the capture session.
 *
 * @return The Executor on which the callback will be invoked.
 * @apiSince 28
 */

public java.util.concurrent.Executor getExecutor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.hardware.camera2.params.InputConfiguration InputConfiguration} for a reprocessable session. Input configuration are not
 * supported for {@link #SESSION_HIGH_SPEED}.
 *
 * @param input Input configuration.
 * This value must never be {@code null}.
 * @throws java.lang.UnsupportedOperationException In case it is called for {@link #SESSION_HIGH_SPEED}
 *                                       type session configuration.
 * @apiSince 28
 */

public void setInputConfiguration(@androidx.annotation.NonNull android.hardware.camera2.params.InputConfiguration input) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the {@link android.hardware.camera2.params.InputConfiguration InputConfiguration}.
 *
 * @return The capture session input configuration.
 * @apiSince 28
 */

public android.hardware.camera2.params.InputConfiguration getInputConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * Sets the session wide camera parameters (see {@link android.hardware.camera2.CaptureRequest CaptureRequest}). This argument can
 * be set for every supported session type and will be passed to the camera device as part
 * of the capture session initialization. Session parameters are a subset of the available
 * capture request parameters (see {@link android.hardware.camera2.CameraCharacteristics#getAvailableSessionKeys CameraCharacteristics#getAvailableSessionKeys})
 * and their application can introduce internal camera delays. To improve camera performance
 * it is suggested to change them sparingly within the lifetime of the capture session and
 * to pass their initial values as part of this method.
 *
 * @param params A capture request that includes the initial values for any available
 *               session wide capture keys. Tags (see {@link android.hardware.camera2.CaptureRequest.Builder#setTag CaptureRequest.Builder#setTag}) and
 *               output targets (see {@link android.hardware.camera2.CaptureRequest.Builder#addTarget CaptureRequest.Builder#addTarget}) are ignored if
 *               set. Parameter values not part of
 *               {@link android.hardware.camera2.CameraCharacteristics#getAvailableSessionKeys CameraCharacteristics#getAvailableSessionKeys} will also be ignored. It
 *               is recommended to build the session parameters using the same template type as
 *               the initial capture request, so that the session and initial request parameters
 *               match as much as possible.
 * @apiSince 28
 */

public void setSessionParameters(android.hardware.camera2.CaptureRequest params) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the session wide camera parameters (see {@link android.hardware.camera2.CaptureRequest CaptureRequest}).
 *
 * @return A capture request that includes the initial values for any available
 *         session wide capture keys.
 * @apiSince 28
 */

public android.hardware.camera2.CaptureRequest getSessionParameters() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.hardware.camera2.params.SessionConfiguration> CREATOR;
static { CREATOR = null; }

/**
 * A high speed session type that can only contain instances of {@link android.hardware.camera2.params.OutputConfiguration OutputConfiguration}.
 * The outputs can run using high speed FPS ranges. Calls to {@link #setInputConfiguration}
 * are not supported.
 *
 * @see android.hardware.camera2.CameraDevice#createConstrainedHighSpeedCaptureSession
 * @apiSince 28
 */

public static final int SESSION_HIGH_SPEED = 1; // 0x1

/**
 * A regular session type containing instances of {@link android.hardware.camera2.params.OutputConfiguration OutputConfiguration} running
 * at regular non high speed FPS ranges and optionally {@link android.hardware.camera2.params.InputConfiguration InputConfiguration} for
 * reprocessable sessions.
 *
 * @see CameraDevice#createCaptureSession
 * @see android.hardware.camera2.CameraDevice#createReprocessableCaptureSession
 * @apiSince 28
 */

public static final int SESSION_REGULAR = 0; // 0x0
}

