/*
 * Copyright (C) 2016 The Android Open Source Project
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


package android.view;


/**
 * Class containing timing data for various milestones in a frame
 * lifecycle reported by the rendering subsystem.
 * <p>
 * Supported metrics can be queried via their corresponding identifier.
 * </p>
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FrameMetrics {

/**
 * Constructs a FrameMetrics object as a copy.
 * <p>
 * Use this method to copy out metrics reported by
 * {@link android.view.Window.OnFrameMetricsAvailableListener#onFrameMetricsAvailable(android.view.Window,android.view.FrameMetrics,int) Window.OnFrameMetricsAvailableListener#onFrameMetricsAvailable(
 * Window, FrameMetrics, int)}
 * </p>
 * @param other the FrameMetrics object to copy.
 * @apiSince 24
 */

public FrameMetrics(android.view.FrameMetrics other) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the value associated with Metric identifier {@code id}
 * for this frame.
 * <p>
 * Boolean metrics are represented in [0,1], with 0 corresponding to
 * false, and 1 corresponding to true.
 * </p>
 * @param id the metric to retrieve
 * Value is {@link android.view.FrameMetrics#UNKNOWN_DELAY_DURATION}, {@link android.view.FrameMetrics#INPUT_HANDLING_DURATION}, {@link android.view.FrameMetrics#ANIMATION_DURATION}, {@link android.view.FrameMetrics#LAYOUT_MEASURE_DURATION}, {@link android.view.FrameMetrics#DRAW_DURATION}, {@link android.view.FrameMetrics#SYNC_DURATION}, {@link android.view.FrameMetrics#COMMAND_ISSUE_DURATION}, {@link android.view.FrameMetrics#SWAP_BUFFERS_DURATION}, {@link android.view.FrameMetrics#TOTAL_DURATION}, {@link android.view.FrameMetrics#FIRST_DRAW_FRAME}, {@link android.view.FrameMetrics#INTENDED_VSYNC_TIMESTAMP}, or {@link android.view.FrameMetrics#VSYNC_TIMESTAMP}
 * @return the value of the metric or -1 if it is not available.
 * @apiSince 24
 */

public long getMetric(int id) { throw new RuntimeException("Stub!"); }

/**
 * Metric identifier for animation callback duration.
 * <p>
 * Represents the number of nanoseconds elapsed issuing
 * animation callbacks.
 * </p>
 * @apiSince 24
 */

public static final int ANIMATION_DURATION = 2; // 0x2

/**
 * Metric identifier for command issue duration.
 * <p>
 * Represents the number of nanoseconds elapsed
 * issuing draw commands to the GPU.
 * </p>
 * @apiSince 24
 */

public static final int COMMAND_ISSUE_DURATION = 6; // 0x6

/**
 * Metric identifier for draw duration.
 * <p>
 * Represents the number of nanoseconds elapsed computing
 * DisplayLists for transformations applied to the view
 * hierarchy.
 * </p>
 * @apiSince 24
 */

public static final int DRAW_DURATION = 4; // 0x4

/**
 * Metric identifier for a boolean value determining whether this frame was
 * the first to draw in a new Window layout.
 * <p>
 * {@link #getMetric(int)} will return 0 for false, 1 for true.
 * </p>
 * <p>
 * First draw frames are expected to be slow and should usually be exempt
 * from display jank calculations as they do not cause skips in animations
 * and are usually hidden by window animations or other tricks.
 * </p>
 * @apiSince 24
 */

public static final int FIRST_DRAW_FRAME = 9; // 0x9

/**
 * Metric identifier for input handling duration.
 * <p>
 * Represents the number of nanoseconds elapsed issuing
 * input handling callbacks.
 * </p>
 * @apiSince 24
 */

public static final int INPUT_HANDLING_DURATION = 1; // 0x1

/**
 * Metric identifier for the timestamp of the intended vsync for this frame.
 * <p>
 * The intended start point for the frame. If this value is different from
 * {@link #VSYNC_TIMESTAMP}, there was work occurring on the UI thread that
 * prevented it from responding to the vsync signal in a timely fashion.
 * </p>
 * @apiSince 26
 */

public static final int INTENDED_VSYNC_TIMESTAMP = 10; // 0xa

/**
 * Metric identifier for layout/measure duration.
 * <p>
 * Represents the number of nanoseconds elapsed measuring
 * and laying out the invalidated pieces of the view hierarchy.
 * </p>
 * @apiSince 24
 */

public static final int LAYOUT_MEASURE_DURATION = 3; // 0x3

/**
 * Metric identifier for swap buffers duration.
 * <p>
 * Represents the number of nanoseconds elapsed issuing
 * the frame buffer for this frame to the display
 * subsystem.
 * </p>
 * @apiSince 24
 */

public static final int SWAP_BUFFERS_DURATION = 7; // 0x7

/**
 * Metric identifier for sync duration.
 * <p>
 * Represents the number of nanoseconds elapsed
 * synchronizing the computed display lists with the render
 * thread.
 * </p>
 * @apiSince 24
 */

public static final int SYNC_DURATION = 5; // 0x5

/**
 * Metric identifier for total frame duration.
 * <p>
 * Represents the total time in nanoseconds this frame took to render
 * and be issued to the display subsystem.
 * </p>
 * <p>
 * Equal to the sum of the values of all other time-valued metric
 * identifiers.
 * </p>
 * @apiSince 24
 */

public static final int TOTAL_DURATION = 8; // 0x8

/**
 * Metric identifier for unknown delay.
 * <p>
 * Represents the number of nanoseconds elapsed waiting for the
 * UI thread to become responsive and process the frame. This
 * should be 0 most of the time.
 * </p>
 * @apiSince 24
 */

public static final int UNKNOWN_DELAY_DURATION = 0; // 0x0

/**
 * Metric identifier for the timestamp of the actual vsync for this frame.
 * <p>
 * The time value that was used in all the vsync listeners and drawing for
 * the frame (Choreographer frame callbacks, animations,
 * {@link android.view.View#getDrawingTime() View#getDrawingTime()}, etc…)
 * </p>
 * @apiSince 26
 */

public static final int VSYNC_TIMESTAMP = 11; // 0xb
}

