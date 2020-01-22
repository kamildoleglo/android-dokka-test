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
 * limitations under the License.
 */


package android.accessibilityservice;


/**
 * Accessibility services with the
 * {@link android.R.styleable#AccessibilityService_canPerformGestures} property can dispatch
 * gestures. This class describes those gestures. Gestures are made up of one or more strokes.
 * Gestures are immutable once built.
 * <p>
 * Spatial dimensions throughout are in screen pixels. Time is measured in milliseconds.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class GestureDescription {

private GestureDescription() { throw new RuntimeException("Stub!"); }

/**
 * Get the upper limit for the number of strokes a gesture may contain.
 *
 * @return The maximum number of strokes.
 * @apiSince 24
 */

public static int getMaxStrokeCount() { throw new RuntimeException("Stub!"); }

/**
 * Get the upper limit on a gesture's duration.
 *
 * @return The maximum duration in milliseconds.
 * @apiSince 24
 */

public static long getMaxGestureDuration() { throw new RuntimeException("Stub!"); }

/**
 * Get the number of stroke in the gesture.
 *
 * @return the number of strokes in this gesture
 * @apiSince 24
 */

public int getStrokeCount() { throw new RuntimeException("Stub!"); }

/**
 * Read a stroke from the gesture
 *
 * @param index the index of the stroke
 *
 * Value is 0 or greater
 * @return A description of the stroke.
 * @apiSince 24
 */

public android.accessibilityservice.GestureDescription.StrokeDescription getStroke(int index) { throw new RuntimeException("Stub!"); }
/**
 * Builder for a {@code GestureDescription}
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Add a stroke to the gesture description. Up to
 * {@link android.accessibilityservice.GestureDescription#getMaxStrokeCount() GestureDescription#getMaxStrokeCount()} paths may be
 * added to a gesture, and the total gesture duration (earliest path start time to latest
 * path end time) may not exceed {@link android.accessibilityservice.GestureDescription#getMaxGestureDuration() GestureDescription#getMaxGestureDuration()}.
 *
 * @param strokeDescription the stroke to add.
 *
 * This value must never be {@code null}.
 * @return this
 * @apiSince 24
 */

public android.accessibilityservice.GestureDescription.Builder addStroke(@androidx.annotation.NonNull android.accessibilityservice.GestureDescription.StrokeDescription strokeDescription) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.accessibilityservice.GestureDescription build() { throw new RuntimeException("Stub!"); }
}

/**
 * Immutable description of stroke that can be part of a gesture.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class StrokeDescription {

/**
 * @param path The path to follow. Must have exactly one contour. The bounds of the path
 * must not be negative. The path must not be empty. If the path has zero length
 * (for example, a single {@code moveTo()}), the stroke is a touch that doesn't move.
 * This value must never be {@code null}.
 * @param startTime The time, in milliseconds, from the time the gesture starts to the
 * time the stroke should start. Must not be negative.
 * Value is 0 or greater
 * @param duration The duration, in milliseconds, the stroke takes to traverse the path.
 * Must be positive.
 
 * Value is 0 or greater
 * @apiSince 24
 */

public StrokeDescription(@androidx.annotation.NonNull android.graphics.Path path, long startTime, long duration) { throw new RuntimeException("Stub!"); }

/**
 * @param path The path to follow. Must have exactly one contour. The bounds of the path
 * must not be negative. The path must not be empty. If the path has zero length
 * (for example, a single {@code moveTo()}), the stroke is a touch that doesn't move.
 * This value must never be {@code null}.
 * @param startTime The time, in milliseconds, from the time the gesture starts to the
 * time the stroke should start. Must not be negative.
 * Value is 0 or greater
 * @param duration The duration, in milliseconds, the stroke takes to traverse the path.
 * Must be positive.
 * Value is 0 or greater
 * @param willContinue {@code true} if this stroke will be continued by one in the
 * next gesture {@code false} otherwise. Continued strokes keep their pointers down when
 * the gesture completes.
 * @apiSince 26
 */

public StrokeDescription(@androidx.annotation.NonNull android.graphics.Path path, long startTime, long duration, boolean willContinue) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a copy of the path for this stroke
 *
 * @return A copy of the path
 * @apiSince 24
 */

public android.graphics.Path getPath() { throw new RuntimeException("Stub!"); }

/**
 * Get the stroke's start time
 *
 * @return the start time for this stroke.
 * @apiSince 24
 */

public long getStartTime() { throw new RuntimeException("Stub!"); }

/**
 * Get the stroke's duration
 *
 * @return the duration for this stroke
 * @apiSince 24
 */

public long getDuration() { throw new RuntimeException("Stub!"); }

/**
 * Create a new stroke that will continue this one. This is only possible if this stroke
 * will continue.
 *
 * @param path The path for the stroke that continues this one. The starting point of
 *             this path must match the ending point of the stroke it continues.
 * @param startTime The time, in milliseconds, from the time the gesture starts to the
 *                  time this stroke should start. Must not be negative. This time is from
 *                  the start of the new gesture, not the one being continued.
 * @param duration The duration for the new stroke. Must not be negative.
 * @param willContinue {@code true} if this stroke will be continued by one in the
 *             next gesture {@code false} otherwise.
 * @return
 * @apiSince 26
 */

public android.accessibilityservice.GestureDescription.StrokeDescription continueStroke(android.graphics.Path path, long startTime, long duration, boolean willContinue) { throw new RuntimeException("Stub!"); }

/**
 * Check if this stroke is marked to continue in the next gesture.
 *
 * @return {@code true} if the stroke is to be continued.
 * @apiSince 26
 */

public boolean willContinue() { throw new RuntimeException("Stub!"); }
}

}

