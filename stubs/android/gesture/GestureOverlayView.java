/*
 * Copyright (C) 2009 The Android Open Source Project
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


package android.gesture;


/**
 * A transparent overlay for gesture input that can be placed on top of other
 * widgets or contain other widgets.
 *
 * @attr ref android.R.styleable#GestureOverlayView_eventsInterceptionEnabled
 * @attr ref android.R.styleable#GestureOverlayView_fadeDuration
 * @attr ref android.R.styleable#GestureOverlayView_fadeOffset
 * @attr ref android.R.styleable#GestureOverlayView_fadeEnabled
 * @attr ref android.R.styleable#GestureOverlayView_gestureStrokeWidth
 * @attr ref android.R.styleable#GestureOverlayView_gestureStrokeAngleThreshold
 * @attr ref android.R.styleable#GestureOverlayView_gestureStrokeLengthThreshold
 * @attr ref android.R.styleable#GestureOverlayView_gestureStrokeSquarenessThreshold
 * @attr ref android.R.styleable#GestureOverlayView_gestureStrokeType
 * @attr ref android.R.styleable#GestureOverlayView_gestureColor
 * @attr ref android.R.styleable#GestureOverlayView_orientation
 * @attr ref android.R.styleable#GestureOverlayView_uncertainGestureColor
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GestureOverlayView extends android.widget.FrameLayout {

/** @apiSince 4 */

public GestureOverlayView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public GestureOverlayView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public GestureOverlayView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public GestureOverlayView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public java.util.ArrayList<android.gesture.GesturePoint> getCurrentStroke() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public int getOrientation() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void setOrientation(int orientation) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void setGestureColor(int color) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void setUncertainGestureColor(int color) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public int getUncertainGestureColor() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public int getGestureColor() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public float getGestureStrokeWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void setGestureStrokeWidth(float gestureStrokeWidth) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public int getGestureStrokeType() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void setGestureStrokeType(int gestureStrokeType) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public float getGestureStrokeLengthThreshold() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void setGestureStrokeLengthThreshold(float gestureStrokeLengthThreshold) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public float getGestureStrokeSquarenessTreshold() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void setGestureStrokeSquarenessTreshold(float gestureStrokeSquarenessTreshold) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public float getGestureStrokeAngleThreshold() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void setGestureStrokeAngleThreshold(float gestureStrokeAngleThreshold) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public boolean isEventsInterceptionEnabled() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void setEventsInterceptionEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public boolean isFadeEnabled() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void setFadeEnabled(boolean fadeEnabled) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public android.gesture.Gesture getGesture() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void setGesture(android.gesture.Gesture gesture) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public android.graphics.Path getGesturePath() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public android.graphics.Path getGesturePath(android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public boolean isGestureVisible() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void setGestureVisible(boolean visible) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public long getFadeOffset() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void setFadeOffset(long fadeOffset) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void addOnGestureListener(android.gesture.GestureOverlayView.OnGestureListener listener) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void removeOnGestureListener(android.gesture.GestureOverlayView.OnGestureListener listener) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void removeAllOnGestureListeners() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void addOnGesturePerformedListener(android.gesture.GestureOverlayView.OnGesturePerformedListener listener) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void removeOnGesturePerformedListener(android.gesture.GestureOverlayView.OnGesturePerformedListener listener) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void removeAllOnGesturePerformedListeners() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void addOnGesturingListener(android.gesture.GestureOverlayView.OnGesturingListener listener) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void removeOnGesturingListener(android.gesture.GestureOverlayView.OnGesturingListener listener) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void removeAllOnGesturingListeners() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public boolean isGesturing() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void clear(boolean animated) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void cancelClearAnimation() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void cancelGesture() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public boolean dispatchTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public static final int GESTURE_STROKE_TYPE_MULTIPLE = 1; // 0x1

/** @apiSince 4 */

public static final int GESTURE_STROKE_TYPE_SINGLE = 0; // 0x0

/** @apiSince 4 */

public static final int ORIENTATION_HORIZONTAL = 0; // 0x0

/** @apiSince 4 */

public static final int ORIENTATION_VERTICAL = 1; // 0x1
/** @apiSince 4 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnGestureListener {

/** @apiSince 4 */

public void onGestureStarted(android.gesture.GestureOverlayView overlay, android.view.MotionEvent event);

/** @apiSince 4 */

public void onGesture(android.gesture.GestureOverlayView overlay, android.view.MotionEvent event);

/** @apiSince 4 */

public void onGestureEnded(android.gesture.GestureOverlayView overlay, android.view.MotionEvent event);

/** @apiSince 4 */

public void onGestureCancelled(android.gesture.GestureOverlayView overlay, android.view.MotionEvent event);
}

/** @apiSince 4 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnGesturePerformedListener {

/** @apiSince 4 */

public void onGesturePerformed(android.gesture.GestureOverlayView overlay, android.gesture.Gesture gesture);
}

/** @apiSince 4 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnGesturingListener {

/** @apiSince 4 */

public void onGesturingStarted(android.gesture.GestureOverlayView overlay);

/** @apiSince 4 */

public void onGesturingEnded(android.gesture.GestureOverlayView overlay);
}

}

