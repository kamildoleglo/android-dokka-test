/*
 * Copyright (C) 2007 The Android Open Source Project
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

import android.os.SystemClock;
import java.util.Objects;

/**
 * Object used to report movement (mouse, pen, finger, trackball) events.
 * Motion events may hold either absolute or relative movements and other data,
 * depending on the type of device.
 *
 * <h3>Overview</h3>
 * <p>
 * Motion events describe movements in terms of an action code and a set of axis values.
 * The action code specifies the state change that occurred such as a pointer going
 * down or up.  The axis values describe the position and other movement properties.
 * </p><p>
 * For example, when the user first touches the screen, the system delivers a touch
 * event to the appropriate {@link android.view.View View} with the action code {@link #ACTION_DOWN}
 * and a set of axis values that include the X and Y coordinates of the touch and
 * information about the pressure, size and orientation of the contact area.
 * </p><p>
 * Some devices can report multiple movement traces at the same time.  Multi-touch
 * screens emit one movement trace for each finger.  The individual fingers or
 * other objects that generate movement traces are referred to as <em>pointers</em>.
 * Motion events contain information about all of the pointers that are currently active
 * even if some of them have not moved since the last event was delivered.
 * </p><p>
 * The number of pointers only ever changes by one as individual pointers go up and down,
 * except when the gesture is canceled.
 * </p><p>
 * Each pointer has a unique id that is assigned when it first goes down
 * (indicated by {@link #ACTION_DOWN} or {@link #ACTION_POINTER_DOWN}).  A pointer id
 * remains valid until the pointer eventually goes up (indicated by {@link #ACTION_UP}
 * or {@link #ACTION_POINTER_UP}) or when the gesture is canceled (indicated by
 * {@link #ACTION_CANCEL}).
 * </p><p>
 * The MotionEvent class provides many methods to query the position and other properties of
 * pointers, such as {@link #getX(int)}, {@link #getY(int)}, {@link #getAxisValue},
 * {@link #getPointerId(int)}, {@link #getToolType(int)}, and many others.  Most of these
 * methods accept the pointer index as a parameter rather than the pointer id.
 * The pointer index of each pointer in the event ranges from 0 to one less than the value
 * returned by {@link #getPointerCount()}.
 * </p><p>
 * The order in which individual pointers appear within a motion event is undefined.
 * Thus the pointer index of a pointer can change from one event to the next but
 * the pointer id of a pointer is guaranteed to remain constant as long as the pointer
 * remains active.  Use the {@link #getPointerId(int)} method to obtain the
 * pointer id of a pointer to track it across all subsequent motion events in a gesture.
 * Then for successive motion events, use the {@link #findPointerIndex(int)} method
 * to obtain the pointer index for a given pointer id in that motion event.
 * </p><p>
 * Mouse and stylus buttons can be retrieved using {@link #getButtonState()}.  It is a
 * good idea to check the button state while handling {@link #ACTION_DOWN} as part
 * of a touch event.  The application may choose to perform some different action
 * if the touch event starts due to a secondary button click, such as presenting a
 * context menu.
 * </p>
 *
 * <h3>Batching</h3>
 * <p>
 * For efficiency, motion events with {@link #ACTION_MOVE} may batch together
 * multiple movement samples within a single object.  The most current
 * pointer coordinates are available using {@link #getX(int)} and {@link #getY(int)}.
 * Earlier coordinates within the batch are accessed using {@link #getHistoricalX(int,int)}
 * and {@link #getHistoricalY(int,int)}.  The coordinates are "historical" only
 * insofar as they are older than the current coordinates in the batch; however,
 * they are still distinct from any other coordinates reported in prior motion events.
 * To process all coordinates in the batch in time order, first consume the historical
 * coordinates then consume the current coordinates.
 * </p><p>
 * Example: Consuming all samples for all pointers in a motion event in time order.
 * </p><p><pre><code>
 * void printSamples(MotionEvent ev) {
 *     final int historySize = ev.getHistorySize();
 *     final int pointerCount = ev.getPointerCount();
 *     for (int h = 0; h &lt; historySize; h++) {
 *         System.out.printf("At time %d:", ev.getHistoricalEventTime(h));
 *         for (int p = 0; p &lt; pointerCount; p++) {
 *             System.out.printf("  pointer %d: (%f,%f)",
 *                 ev.getPointerId(p), ev.getHistoricalX(p, h), ev.getHistoricalY(p, h));
 *         }
 *     }
 *     System.out.printf("At time %d:", ev.getEventTime());
 *     for (int p = 0; p &lt; pointerCount; p++) {
 *         System.out.printf("  pointer %d: (%f,%f)",
 *             ev.getPointerId(p), ev.getX(p), ev.getY(p));
 *     }
 * }
 * </code></pre></p>
 *
 * <h3>Device Types</h3>
 * <p>
 * The interpretation of the contents of a MotionEvent varies significantly depending
 * on the source class of the device.
 * </p><p>
 * On pointing devices with source class {@link android.view.InputDevice#SOURCE_CLASS_POINTER InputDevice#SOURCE_CLASS_POINTER}
 * such as touch screens, the pointer coordinates specify absolute
 * positions such as view X/Y coordinates.  Each complete gesture is represented
 * by a sequence of motion events with actions that describe pointer state transitions
 * and movements.  A gesture starts with a motion event with {@link #ACTION_DOWN}
 * that provides the location of the first pointer down.  As each additional
 * pointer that goes down or up, the framework will generate a motion event with
 * {@link #ACTION_POINTER_DOWN} or {@link #ACTION_POINTER_UP} accordingly.
 * Pointer movements are described by motion events with {@link #ACTION_MOVE}.
 * Finally, a gesture end either when the final pointer goes up as represented
 * by a motion event with {@link #ACTION_UP} or when gesture is canceled
 * with {@link #ACTION_CANCEL}.
 * </p><p>
 * Some pointing devices such as mice may support vertical and/or horizontal scrolling.
 * A scroll event is reported as a generic motion event with {@link #ACTION_SCROLL} that
 * includes the relative scroll offset in the {@link #AXIS_VSCROLL} and
 * {@link #AXIS_HSCROLL} axes.  See {@link #getAxisValue(int)} for information
 * about retrieving these additional axes.
 * </p><p>
 * On trackball devices with source class {@link android.view.InputDevice#SOURCE_CLASS_TRACKBALL InputDevice#SOURCE_CLASS_TRACKBALL},
 * the pointer coordinates specify relative movements as X/Y deltas.
 * A trackball gesture consists of a sequence of movements described by motion
 * events with {@link #ACTION_MOVE} interspersed with occasional {@link #ACTION_DOWN}
 * or {@link #ACTION_UP} motion events when the trackball button is pressed or released.
 * </p><p>
 * On joystick devices with source class {@link android.view.InputDevice#SOURCE_CLASS_JOYSTICK InputDevice#SOURCE_CLASS_JOYSTICK},
 * the pointer coordinates specify the absolute position of the joystick axes.
 * The joystick axis values are normalized to a range of -1.0 to 1.0 where 0.0 corresponds
 * to the center position.  More information about the set of available axes and the
 * range of motion can be obtained using {@link android.view.InputDevice#getMotionRange InputDevice#getMotionRange}.
 * Some common joystick axes are {@link #AXIS_X}, {@link #AXIS_Y},
 * {@link #AXIS_HAT_X}, {@link #AXIS_HAT_Y}, {@link #AXIS_Z} and {@link #AXIS_RZ}.
 * </p><p>
 * Refer to {@link android.view.InputDevice InputDevice} for more information about how different kinds of
 * input devices and sources represent pointer coordinates.
 * </p>
 *
 * <h3>Consistency Guarantees</h3>
 * <p>
 * Motion events are always delivered to views as a consistent stream of events.
 * What constitutes a consistent stream varies depending on the type of device.
 * For touch events, consistency implies that pointers go down one at a time,
 * move around as a group and then go up one at a time or are canceled.
 * </p><p>
 * While the framework tries to deliver consistent streams of motion events to
 * views, it cannot guarantee it.  Some events may be dropped or modified by
 * containing views in the application before they are delivered thereby making
 * the stream of events inconsistent.  Views should always be prepared to
 * handle {@link #ACTION_CANCEL} and should tolerate anomalous
 * situations such as receiving a new {@link #ACTION_DOWN} without first having
 * received an {@link #ACTION_UP} for the prior gesture.
 * </p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MotionEvent extends android.view.InputEvent implements android.os.Parcelable {

private MotionEvent() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Create a new MotionEvent, filling in all of the basic values that
 * define the motion.
 *
 * @param downTime The time (in ms) when the user originally pressed down to start
 * a stream of position events.  This must be obtained from {@link android.os.SystemClock#uptimeMillis() SystemClock#uptimeMillis()}.
 * @param eventTime The the time (in ms) when this specific event was generated.  This
 * must be obtained from {@link android.os.SystemClock#uptimeMillis() SystemClock#uptimeMillis()}.
 * @param action The kind of action being performed, such as {@link #ACTION_DOWN}.
 * @param pointerCount The number of pointers that will be in this event.
 * @param pointerProperties An array of <em>pointerCount</em> values providing
 * a {@link android.view.MotionEvent.PointerProperties PointerProperties} property object for each pointer, which must
 * include the pointer identifier.
 * @param pointerCoords An array of <em>pointerCount</em> values providing
 * a {@link android.view.MotionEvent.PointerCoords PointerCoords} coordinate object for each pointer.
 * @param metaState The state of any meta / modifier keys that were in effect when
 * the event was generated.
 * @param buttonState The state of buttons that are pressed.
 * @param xPrecision The precision of the X coordinate being reported.
 * @param yPrecision The precision of the Y coordinate being reported.
 * @param deviceId The id for the device that this event came from.  An id of
 * zero indicates that the event didn't come from a physical device; other
 * numbers are arbitrary and you shouldn't depend on the values.
 * @param edgeFlags A bitfield indicating which edges, if any, were touched by this
 * MotionEvent.
 * @param source The source of this event.
 * @param flags The motion event flags.
 * @apiSince 14
 */

public static android.view.MotionEvent obtain(long downTime, long eventTime, int action, int pointerCount, android.view.MotionEvent.PointerProperties[] pointerProperties, android.view.MotionEvent.PointerCoords[] pointerCoords, int metaState, int buttonState, float xPrecision, float yPrecision, int deviceId, int edgeFlags, int source, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Create a new MotionEvent, filling in all of the basic values that
 * define the motion.
 *
 * @param downTime The time (in ms) when the user originally pressed down to start
 * a stream of position events.  This must be obtained from {@link android.os.SystemClock#uptimeMillis() SystemClock#uptimeMillis()}.
 * @param eventTime The the time (in ms) when this specific event was generated.  This
 * must be obtained from {@link android.os.SystemClock#uptimeMillis() SystemClock#uptimeMillis()}.
 * @param action The kind of action being performed, such as {@link #ACTION_DOWN}.
 * @param pointerCount The number of pointers that will be in this event.
 * @param pointerIds An array of <em>pointerCount</em> values providing
 * an identifier for each pointer.
 * @param pointerCoords An array of <em>pointerCount</em> values providing
 * a {@link android.view.MotionEvent.PointerCoords PointerCoords} coordinate object for each pointer.
 * @param metaState The state of any meta / modifier keys that were in effect when
 * the event was generated.
 * @param xPrecision The precision of the X coordinate being reported.
 * @param yPrecision The precision of the Y coordinate being reported.
 * @param deviceId The id for the device that this event came from.  An id of
 * zero indicates that the event didn't come from a physical device; other
 * numbers are arbitrary and you shouldn't depend on the values.
 * @param edgeFlags A bitfield indicating which edges, if any, were touched by this
 * MotionEvent.
 * @param source The source of this event.
 * @param flags The motion event flags.
 *
 * @deprecated Use {@link #obtain(long,long,int,int,android.view.MotionEvent.PointerProperties[],android.view.MotionEvent.PointerCoords[],int,int,float,float,int,int,int,int)}
 * instead.
 * @apiSince 9
 * @deprecatedSince 15
 */

@Deprecated
public static android.view.MotionEvent obtain(long downTime, long eventTime, int action, int pointerCount, int[] pointerIds, android.view.MotionEvent.PointerCoords[] pointerCoords, int metaState, float xPrecision, float yPrecision, int deviceId, int edgeFlags, int source, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Create a new MotionEvent, filling in all of the basic values that
 * define the motion.
 *
 * @param downTime The time (in ms) when the user originally pressed down to start
 * a stream of position events.  This must be obtained from {@link android.os.SystemClock#uptimeMillis() SystemClock#uptimeMillis()}.
 * @param eventTime  The the time (in ms) when this specific event was generated.  This
 * must be obtained from {@link android.os.SystemClock#uptimeMillis() SystemClock#uptimeMillis()}.
 * @param action The kind of action being performed, such as {@link #ACTION_DOWN}.
 * @param x The X coordinate of this event.
 * @param y The Y coordinate of this event.
 * @param pressure The current pressure of this event.  The pressure generally
 * ranges from 0 (no pressure at all) to 1 (normal pressure), however
 * values higher than 1 may be generated depending on the calibration of
 * the input device.
 * @param size A scaled value of the approximate size of the area being pressed when
 * touched with the finger. The actual value in pixels corresponding to the finger
 * touch is normalized with a device specific range of values
 * and scaled to a value between 0 and 1.
 * @param metaState The state of any meta / modifier keys that were in effect when
 * the event was generated.
 * @param xPrecision The precision of the X coordinate being reported.
 * @param yPrecision The precision of the Y coordinate being reported.
 * @param deviceId The id for the device that this event came from.  An id of
 * zero indicates that the event didn't come from a physical device; other
 * numbers are arbitrary and you shouldn't depend on the values.
 * @param edgeFlags A bitfield indicating which edges, if any, were touched by this
 * MotionEvent.
 * @apiSince 1
 */

public static android.view.MotionEvent obtain(long downTime, long eventTime, int action, float x, float y, float pressure, float size, int metaState, float xPrecision, float yPrecision, int deviceId, int edgeFlags) { throw new RuntimeException("Stub!"); }

/**
 * Create a new MotionEvent, filling in all of the basic values that
 * define the motion.
 *
 * @param downTime The time (in ms) when the user originally pressed down to start
 * a stream of position events.  This must be obtained from {@link android.os.SystemClock#uptimeMillis() SystemClock#uptimeMillis()}.
 * @param eventTime  The the time (in ms) when this specific event was generated.  This
 * must be obtained from {@link android.os.SystemClock#uptimeMillis() SystemClock#uptimeMillis()}.
 * @param action The kind of action being performed, such as {@link #ACTION_DOWN}.
 * @param pointerCount The number of pointers that are active in this event.
 * @param x The X coordinate of this event.
 * @param y The Y coordinate of this event.
 * @param pressure The current pressure of this event.  The pressure generally
 * ranges from 0 (no pressure at all) to 1 (normal pressure), however
 * values higher than 1 may be generated depending on the calibration of
 * the input device.
 * @param size A scaled value of the approximate size of the area being pressed when
 * touched with the finger. The actual value in pixels corresponding to the finger
 * touch is normalized with a device specific range of values
 * and scaled to a value between 0 and 1.
 * @param metaState The state of any meta / modifier keys that were in effect when
 * the event was generated.
 * @param xPrecision The precision of the X coordinate being reported.
 * @param yPrecision The precision of the Y coordinate being reported.
 * @param deviceId The id for the device that this event came from.  An id of
 * zero indicates that the event didn't come from a physical device; other
 * numbers are arbitrary and you shouldn't depend on the values.
 * @param edgeFlags A bitfield indicating which edges, if any, were touched by this
 * MotionEvent.
 *
 * @deprecated Use {@link #obtain(long,long,int,float,float,float,float,int,float,float,int,int)}
 * instead.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated
public static android.view.MotionEvent obtain(long downTime, long eventTime, int action, int pointerCount, float x, float y, float pressure, float size, int metaState, float xPrecision, float yPrecision, int deviceId, int edgeFlags) { throw new RuntimeException("Stub!"); }

/**
 * Create a new MotionEvent, filling in a subset of the basic motion
 * values.  Those not specified here are: device id (always 0), pressure
 * and size (always 1), x and y precision (always 1), and edgeFlags (always 0).
 *
 * @param downTime The time (in ms) when the user originally pressed down to start
 * a stream of position events.  This must be obtained from {@link android.os.SystemClock#uptimeMillis() SystemClock#uptimeMillis()}.
 * @param eventTime  The the time (in ms) when this specific event was generated.  This
 * must be obtained from {@link android.os.SystemClock#uptimeMillis() SystemClock#uptimeMillis()}.
 * @param action The kind of action being performed, such as {@link #ACTION_DOWN}.
 * @param x The X coordinate of this event.
 * @param y The Y coordinate of this event.
 * @param metaState The state of any meta / modifier keys that were in effect when
 * the event was generated.
 * @apiSince 1
 */

public static android.view.MotionEvent obtain(long downTime, long eventTime, int action, float x, float y, int metaState) { throw new RuntimeException("Stub!"); }

/**
 * Create a new MotionEvent, copying from an existing one.
 * @apiSince 1
 */

public static android.view.MotionEvent obtain(android.view.MotionEvent other) { throw new RuntimeException("Stub!"); }

/**
 * Create a new MotionEvent, copying from an existing one, but not including
 * any historical point information.
 * @apiSince 5
 */

public static android.view.MotionEvent obtainNoHistory(android.view.MotionEvent other) { throw new RuntimeException("Stub!"); }

/**
 * Recycle the MotionEvent, to be re-used by a later caller.  After calling
 * this function you must not ever touch the event again.
 * @apiSince 1
 */

public void recycle() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public int getDeviceId() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 9
 */

public int getSource() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 12
 */

public void setSource(int source) { throw new RuntimeException("Stub!"); }

/**
 * Return the kind of action being performed.
 * Consider using {@link #getActionMasked} and {@link #getActionIndex} to retrieve
 * the separate masked action and pointer index.
 * @return The action, such as {@link #ACTION_DOWN} or
 * the combination of {@link #ACTION_POINTER_DOWN} with a shifted pointer index.
 * @apiSince 1
 */

public int getAction() { throw new RuntimeException("Stub!"); }

/**
 * Return the masked action being performed, without pointer index information.
 * Use {@link #getActionIndex} to return the index associated with pointer actions.
 * @return The action, such as {@link #ACTION_DOWN} or {@link #ACTION_POINTER_DOWN}.
 * @apiSince 8
 */

public int getActionMasked() { throw new RuntimeException("Stub!"); }

/**
 * For {@link #ACTION_POINTER_DOWN} or {@link #ACTION_POINTER_UP}
 * as returned by {@link #getActionMasked}, this returns the associated
 * pointer index.
 * The index may be used with {@link #getPointerId(int)},
 * {@link #getX(int)}, {@link #getY(int)}, {@link #getPressure(int)},
 * and {@link #getSize(int)} to get information about the pointer that has
 * gone down or up.
 * @return The index associated with the action.
 * @apiSince 8
 */

public int getActionIndex() { throw new RuntimeException("Stub!"); }

/**
 * Gets the motion event flags.
 *
 * @see #FLAG_WINDOW_IS_OBSCURED
 * @apiSince 9
 */

public int getFlags() { throw new RuntimeException("Stub!"); }

/**
 * Returns the time (in ms) when the user originally pressed down to start
 * a stream of position events.
 * @apiSince 1
 */

public long getDownTime() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the time this event occurred,
 * in the {@link android.os.SystemClock#uptimeMillis} time base.
 *
 * @return Returns the time this event occurred,
 * in the {@link android.os.SystemClock#uptimeMillis} time base.
 * @apiSince 1
 */

public long getEventTime() { throw new RuntimeException("Stub!"); }

/**
 * {@link #getX(int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @see #AXIS_X
 * @apiSince 1
 */

public float getX() { throw new RuntimeException("Stub!"); }

/**
 * {@link #getY(int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @see #AXIS_Y
 * @apiSince 1
 */

public float getY() { throw new RuntimeException("Stub!"); }

/**
 * {@link #getPressure(int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @see #AXIS_PRESSURE
 * @apiSince 1
 */

public float getPressure() { throw new RuntimeException("Stub!"); }

/**
 * {@link #getSize(int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @see #AXIS_SIZE
 * @apiSince 1
 */

public float getSize() { throw new RuntimeException("Stub!"); }

/**
 * {@link #getTouchMajor(int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @see #AXIS_TOUCH_MAJOR
 * @apiSince 9
 */

public float getTouchMajor() { throw new RuntimeException("Stub!"); }

/**
 * {@link #getTouchMinor(int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @see #AXIS_TOUCH_MINOR
 * @apiSince 9
 */

public float getTouchMinor() { throw new RuntimeException("Stub!"); }

/**
 * {@link #getToolMajor(int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @see #AXIS_TOOL_MAJOR
 * @apiSince 9
 */

public float getToolMajor() { throw new RuntimeException("Stub!"); }

/**
 * {@link #getToolMinor(int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @see #AXIS_TOOL_MINOR
 * @apiSince 9
 */

public float getToolMinor() { throw new RuntimeException("Stub!"); }

/**
 * {@link #getOrientation(int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @see #AXIS_ORIENTATION
 * @apiSince 9
 */

public float getOrientation() { throw new RuntimeException("Stub!"); }

/**
 * {@link #getAxisValue(int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @param axis The axis identifier for the axis value to retrieve.
 *
 * @see #AXIS_X
 * @see #AXIS_Y
 * @apiSince 12
 */

public float getAxisValue(int axis) { throw new RuntimeException("Stub!"); }

/**
 * The number of pointers of data contained in this event.  Always
 * >= 1.
 * @apiSince 5
 */

public int getPointerCount() { throw new RuntimeException("Stub!"); }

/**
 * Return the pointer identifier associated with a particular pointer
 * data index in this event.  The identifier tells you the actual pointer
 * number associated with the data, accounting for individual pointers
 * going up and down since the start of the current gesture.
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 * @apiSince 5
 */

public int getPointerId(int pointerIndex) { throw new RuntimeException("Stub!"); }

/**
 * Gets the tool type of a pointer for the given pointer index.
 * The tool type indicates the type of tool used to make contact such
 * as a finger or stylus, if known.
 *
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 * @return The tool type of the pointer.
 *
 * @see #TOOL_TYPE_UNKNOWN
 * @see #TOOL_TYPE_FINGER
 * @see #TOOL_TYPE_STYLUS
 * @see #TOOL_TYPE_MOUSE
 * @apiSince 14
 */

public int getToolType(int pointerIndex) { throw new RuntimeException("Stub!"); }

/**
 * Given a pointer identifier, find the index of its data in the event.
 *
 * @param pointerId The identifier of the pointer to be found.
 * @return Returns either the index of the pointer (for use with
 * {@link #getX(int)} et al.), or -1 if there is no data available for
 * that pointer identifier.
 * @apiSince 5
 */

public int findPointerIndex(int pointerId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the X coordinate of this event for the given pointer
 * <em>index</em> (use {@link #getPointerId(int)} to find the pointer
 * identifier for this index).
 * Whole numbers are pixels; the
 * value may have a fraction for input devices that are sub-pixel precise.
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 *
 * @see #AXIS_X
 * @apiSince 5
 */

public float getX(int pointerIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Y coordinate of this event for the given pointer
 * <em>index</em> (use {@link #getPointerId(int)} to find the pointer
 * identifier for this index).
 * Whole numbers are pixels; the
 * value may have a fraction for input devices that are sub-pixel precise.
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 *
 * @see #AXIS_Y
 * @apiSince 5
 */

public float getY(int pointerIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current pressure of this event for the given pointer
 * <em>index</em> (use {@link #getPointerId(int)} to find the pointer
 * identifier for this index).
 * The pressure generally
 * ranges from 0 (no pressure at all) to 1 (normal pressure), however
 * values higher than 1 may be generated depending on the calibration of
 * the input device.
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 *
 * @see #AXIS_PRESSURE
 * @apiSince 5
 */

public float getPressure(int pointerIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns a scaled value of the approximate size for the given pointer
 * <em>index</em> (use {@link #getPointerId(int)} to find the pointer
 * identifier for this index).
 * This represents some approximation of the area of the screen being
 * pressed; the actual value in pixels corresponding to the
 * touch is normalized with the device specific range of values
 * and scaled to a value between 0 and 1. The value of size can be used to
 * determine fat touch events.
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 *
 * @see #AXIS_SIZE
 * @apiSince 5
 */

public float getSize(int pointerIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of the major axis of an ellipse that describes the touch
 * area at the point of contact for the given pointer
 * <em>index</em> (use {@link #getPointerId(int)} to find the pointer
 * identifier for this index).
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 *
 * @see #AXIS_TOUCH_MAJOR
 * @apiSince 9
 */

public float getTouchMajor(int pointerIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of the minor axis of an ellipse that describes the touch
 * area at the point of contact for the given pointer
 * <em>index</em> (use {@link #getPointerId(int)} to find the pointer
 * identifier for this index).
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 *
 * @see #AXIS_TOUCH_MINOR
 * @apiSince 9
 */

public float getTouchMinor(int pointerIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of the major axis of an ellipse that describes the size of
 * the approaching tool for the given pointer
 * <em>index</em> (use {@link #getPointerId(int)} to find the pointer
 * identifier for this index).
 * The tool area represents the estimated size of the finger or pen that is
 * touching the device independent of its actual touch area at the point of contact.
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 *
 * @see #AXIS_TOOL_MAJOR
 * @apiSince 9
 */

public float getToolMajor(int pointerIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of the minor axis of an ellipse that describes the size of
 * the approaching tool for the given pointer
 * <em>index</em> (use {@link #getPointerId(int)} to find the pointer
 * identifier for this index).
 * The tool area represents the estimated size of the finger or pen that is
 * touching the device independent of its actual touch area at the point of contact.
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 *
 * @see #AXIS_TOOL_MINOR
 * @apiSince 9
 */

public float getToolMinor(int pointerIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the orientation of the touch area and tool area in radians clockwise from vertical
 * for the given pointer <em>index</em> (use {@link #getPointerId(int)} to find the pointer
 * identifier for this index).
 * An angle of 0 radians indicates that the major axis of contact is oriented
 * upwards, is perfectly circular or is of unknown orientation.  A positive angle
 * indicates that the major axis of contact is oriented to the right.  A negative angle
 * indicates that the major axis of contact is oriented to the left.
 * The full range is from -PI/2 radians (finger pointing fully left) to PI/2 radians
 * (finger pointing fully right).
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 *
 * @see #AXIS_ORIENTATION
 * @apiSince 9
 */

public float getOrientation(int pointerIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the requested axis for the given pointer <em>index</em>
 * (use {@link #getPointerId(int)} to find the pointer identifier for this index).
 *
 * @param axis The axis identifier for the axis value to retrieve.
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 * @return The value of the axis, or 0 if the axis is not available.
 *
 * @see #AXIS_X
 * @see #AXIS_Y
 * @apiSince 12
 */

public float getAxisValue(int axis, int pointerIndex) { throw new RuntimeException("Stub!"); }

/**
 * Populates a {@link android.view.MotionEvent.PointerCoords PointerCoords} object with pointer coordinate data for
 * the specified pointer index.
 *
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 * @param outPointerCoords The pointer coordinate object to populate.
 *
 * @see android.view.MotionEvent.PointerCoords
 * @apiSince 9
 */

public void getPointerCoords(int pointerIndex, android.view.MotionEvent.PointerCoords outPointerCoords) { throw new RuntimeException("Stub!"); }

/**
 * Populates a {@link android.view.MotionEvent.PointerProperties PointerProperties} object with pointer properties for
 * the specified pointer index.
 *
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 * @param outPointerProperties The pointer properties object to populate.
 *
 * @see android.view.MotionEvent.PointerProperties
 * @apiSince 14
 */

public void getPointerProperties(int pointerIndex, android.view.MotionEvent.PointerProperties outPointerProperties) { throw new RuntimeException("Stub!"); }

/**
 * Returns the state of any meta / modifier keys that were in effect when
 * the event was generated.  This is the same values as those
 * returned by {@link android.view.KeyEvent#getMetaState() KeyEvent#getMetaState()}.
 *
 * @return an integer in which each bit set to 1 represents a pressed
 *         meta key
 *
 * @see android.view.KeyEvent#getMetaState()
 * @apiSince 1
 */

public int getMetaState() { throw new RuntimeException("Stub!"); }

/**
 * Gets the state of all buttons that are pressed such as a mouse or stylus button.
 *
 * @return The button state.
 *
 * @see #BUTTON_PRIMARY
 * @see #BUTTON_SECONDARY
 * @see #BUTTON_TERTIARY
 * @see #BUTTON_FORWARD
 * @see #BUTTON_BACK
 * @see #BUTTON_STYLUS_PRIMARY
 * @see #BUTTON_STYLUS_SECONDARY
 * @apiSince 14
 */

public int getButtonState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the classification for the current gesture.
 * The classification may change as more events become available for the same gesture.
 *
 * @see #CLASSIFICATION_NONE
 * @see #CLASSIFICATION_AMBIGUOUS_GESTURE
 * @see #CLASSIFICATION_DEEP_PRESS
 
 * @return Value is {@link android.view.MotionEvent#CLASSIFICATION_NONE}, {@link android.view.MotionEvent#CLASSIFICATION_AMBIGUOUS_GESTURE}, or {@link android.view.MotionEvent#CLASSIFICATION_DEEP_PRESS}
 * @apiSince 29
 */

public int getClassification() { throw new RuntimeException("Stub!"); }

/**
 * Gets which button has been modified during a press or release action.
 *
 * For actions other than {@link #ACTION_BUTTON_PRESS} and {@link #ACTION_BUTTON_RELEASE}
 * the returned value is undefined.
 *
 * @see #getButtonState()
 * @apiSince 23
 */

public int getActionButton() { throw new RuntimeException("Stub!"); }

/**
 * Returns the original raw X coordinate of this event.  For touch
 * events on the screen, this is the original location of the event
 * on the screen, before it had been adjusted for the containing window
 * and views.
 *
 * @see #getX(int)
 * @see #AXIS_X
 * @apiSince 1
 */

public float getRawX() { throw new RuntimeException("Stub!"); }

/**
 * Returns the original raw Y coordinate of this event.  For touch
 * events on the screen, this is the original location of the event
 * on the screen, before it had been adjusted for the containing window
 * and views.
 *
 * @see #getY(int)
 * @see #AXIS_Y
 * @apiSince 1
 */

public float getRawY() { throw new RuntimeException("Stub!"); }

/**
 * Returns the original raw X coordinate of this event.  For touch
 * events on the screen, this is the original location of the event
 * on the screen, before it had been adjusted for the containing window
 * and views.
 *
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 *
 * @see #getX(int)
 * @see #AXIS_X
 * @apiSince 29
 */

public float getRawX(int pointerIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the original raw Y coordinate of this event.  For touch
 * events on the screen, this is the original location of the event
 * on the screen, before it had been adjusted for the containing window
 * and views.
 *
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 *
 * @see #getY(int)
 * @see #AXIS_Y
 * @apiSince 29
 */

public float getRawY(int pointerIndex) { throw new RuntimeException("Stub!"); }

/**
 * Return the precision of the X coordinates being reported.  You can
 * multiply this number with {@link #getX} to find the actual hardware
 * value of the X coordinate.
 * @return Returns the precision of X coordinates being reported.
 *
 * @see #AXIS_X
 * @apiSince 1
 */

public float getXPrecision() { throw new RuntimeException("Stub!"); }

/**
 * Return the precision of the Y coordinates being reported.  You can
 * multiply this number with {@link #getY} to find the actual hardware
 * value of the Y coordinate.
 * @return Returns the precision of Y coordinates being reported.
 *
 * @see #AXIS_Y
 * @apiSince 1
 */

public float getYPrecision() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of historical points in this event.  These are
 * movements that have occurred between this event and the previous event.
 * This only applies to ACTION_MOVE events -- all other actions will have
 * a size of 0.
 *
 * @return Returns the number of historical points in the event.
 * @apiSince 1
 */

public int getHistorySize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the time that a historical movement occurred between this event
 * and the previous event, in the {@link android.os.SystemClock#uptimeMillis} time base.
 * <p>
 * This only applies to ACTION_MOVE events.
 * </p>
 *
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 * @return Returns the time that a historical movement occurred between this
 * event and the previous event,
 * in the {@link android.os.SystemClock#uptimeMillis} time base.
 *
 * @see #getHistorySize
 * @see #getEventTime
 * @apiSince 1
 */

public long getHistoricalEventTime(int pos) { throw new RuntimeException("Stub!"); }

/**
 * {@link #getHistoricalX(int,int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getX()
 * @see #AXIS_X
 * @apiSince 1
 */

public float getHistoricalX(int pos) { throw new RuntimeException("Stub!"); }

/**
 * {@link #getHistoricalY(int,int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getY()
 * @see #AXIS_Y
 * @apiSince 1
 */

public float getHistoricalY(int pos) { throw new RuntimeException("Stub!"); }

/**
 * {@link #getHistoricalPressure(int,int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getPressure()
 * @see #AXIS_PRESSURE
 * @apiSince 1
 */

public float getHistoricalPressure(int pos) { throw new RuntimeException("Stub!"); }

/**
 * {@link #getHistoricalSize(int,int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getSize()
 * @see #AXIS_SIZE
 * @apiSince 1
 */

public float getHistoricalSize(int pos) { throw new RuntimeException("Stub!"); }

/**
 * {@link #getHistoricalTouchMajor(int,int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getTouchMajor()
 * @see #AXIS_TOUCH_MAJOR
 * @apiSince 9
 */

public float getHistoricalTouchMajor(int pos) { throw new RuntimeException("Stub!"); }

/**
 * {@link #getHistoricalTouchMinor(int,int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getTouchMinor()
 * @see #AXIS_TOUCH_MINOR
 * @apiSince 9
 */

public float getHistoricalTouchMinor(int pos) { throw new RuntimeException("Stub!"); }

/**
 * {@link #getHistoricalToolMajor(int,int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getToolMajor()
 * @see #AXIS_TOOL_MAJOR
 * @apiSince 9
 */

public float getHistoricalToolMajor(int pos) { throw new RuntimeException("Stub!"); }

/**
 * {@link #getHistoricalToolMinor(int,int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getToolMinor()
 * @see #AXIS_TOOL_MINOR
 * @apiSince 9
 */

public float getHistoricalToolMinor(int pos) { throw new RuntimeException("Stub!"); }

/**
 * {@link #getHistoricalOrientation(int,int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getOrientation()
 * @see #AXIS_ORIENTATION
 * @apiSince 9
 */

public float getHistoricalOrientation(int pos) { throw new RuntimeException("Stub!"); }

/**
 * {@link #getHistoricalAxisValue(int,int,int)} for the first pointer index (may be an
 * arbitrary pointer identifier).
 *
 * @param axis The axis identifier for the axis value to retrieve.
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getAxisValue(int)
 * @see #AXIS_X
 * @see #AXIS_Y
 * @apiSince 12
 */

public float getHistoricalAxisValue(int axis, int pos) { throw new RuntimeException("Stub!"); }

/**
 * Returns a historical X coordinate, as per {@link #getX(int)}, that
 * occurred between this event and the previous event for the given pointer.
 * Only applies to ACTION_MOVE events.
 *
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getX(int)
 * @see #AXIS_X
 * @apiSince 5
 */

public float getHistoricalX(int pointerIndex, int pos) { throw new RuntimeException("Stub!"); }

/**
 * Returns a historical Y coordinate, as per {@link #getY(int)}, that
 * occurred between this event and the previous event for the given pointer.
 * Only applies to ACTION_MOVE events.
 *
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getY(int)
 * @see #AXIS_Y
 * @apiSince 5
 */

public float getHistoricalY(int pointerIndex, int pos) { throw new RuntimeException("Stub!"); }

/**
 * Returns a historical pressure coordinate, as per {@link #getPressure(int)},
 * that occurred between this event and the previous event for the given
 * pointer.  Only applies to ACTION_MOVE events.
 *
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getPressure(int)
 * @see #AXIS_PRESSURE
 * @apiSince 5
 */

public float getHistoricalPressure(int pointerIndex, int pos) { throw new RuntimeException("Stub!"); }

/**
 * Returns a historical size coordinate, as per {@link #getSize(int)}, that
 * occurred between this event and the previous event for the given pointer.
 * Only applies to ACTION_MOVE events.
 *
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getSize(int)
 * @see #AXIS_SIZE
 * @apiSince 5
 */

public float getHistoricalSize(int pointerIndex, int pos) { throw new RuntimeException("Stub!"); }

/**
 * Returns a historical touch major axis coordinate, as per {@link #getTouchMajor(int)}, that
 * occurred between this event and the previous event for the given pointer.
 * Only applies to ACTION_MOVE events.
 *
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getTouchMajor(int)
 * @see #AXIS_TOUCH_MAJOR
 * @apiSince 9
 */

public float getHistoricalTouchMajor(int pointerIndex, int pos) { throw new RuntimeException("Stub!"); }

/**
 * Returns a historical touch minor axis coordinate, as per {@link #getTouchMinor(int)}, that
 * occurred between this event and the previous event for the given pointer.
 * Only applies to ACTION_MOVE events.
 *
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getTouchMinor(int)
 * @see #AXIS_TOUCH_MINOR
 * @apiSince 9
 */

public float getHistoricalTouchMinor(int pointerIndex, int pos) { throw new RuntimeException("Stub!"); }

/**
 * Returns a historical tool major axis coordinate, as per {@link #getToolMajor(int)}, that
 * occurred between this event and the previous event for the given pointer.
 * Only applies to ACTION_MOVE events.
 *
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getToolMajor(int)
 * @see #AXIS_TOOL_MAJOR
 * @apiSince 9
 */

public float getHistoricalToolMajor(int pointerIndex, int pos) { throw new RuntimeException("Stub!"); }

/**
 * Returns a historical tool minor axis coordinate, as per {@link #getToolMinor(int)}, that
 * occurred between this event and the previous event for the given pointer.
 * Only applies to ACTION_MOVE events.
 *
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getToolMinor(int)
 * @see #AXIS_TOOL_MINOR
 * @apiSince 9
 */

public float getHistoricalToolMinor(int pointerIndex, int pos) { throw new RuntimeException("Stub!"); }

/**
 * Returns a historical orientation coordinate, as per {@link #getOrientation(int)}, that
 * occurred between this event and the previous event for the given pointer.
 * Only applies to ACTION_MOVE events.
 *
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 *
 * @see #getHistorySize
 * @see #getOrientation(int)
 * @see #AXIS_ORIENTATION
 * @apiSince 9
 */

public float getHistoricalOrientation(int pointerIndex, int pos) { throw new RuntimeException("Stub!"); }

/**
 * Returns the historical value of the requested axis, as per {@link #getAxisValue(int,int)},
 * occurred between this event and the previous event for the given pointer.
 * Only applies to ACTION_MOVE events.
 *
 * @param axis The axis identifier for the axis value to retrieve.
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 * @return The value of the axis, or 0 if the axis is not available.
 *
 * @see #AXIS_X
 * @see #AXIS_Y
 * @apiSince 12
 */

public float getHistoricalAxisValue(int axis, int pointerIndex, int pos) { throw new RuntimeException("Stub!"); }

/**
 * Populates a {@link android.view.MotionEvent.PointerCoords PointerCoords} object with historical pointer coordinate data,
 * as per {@link #getPointerCoords}, that occurred between this event and the previous
 * event for the given pointer.
 * Only applies to ACTION_MOVE events.
 *
 * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
 * (the first pointer that is down) to {@link #getPointerCount()}-1.
 * @param pos Which historical value to return; must be less than
 * {@link #getHistorySize}
 * @param outPointerCoords The pointer coordinate object to populate.
 *
 * @see #getHistorySize
 * @see #getPointerCoords
 * @see android.view.MotionEvent.PointerCoords
 * @apiSince 9
 */

public void getHistoricalPointerCoords(int pointerIndex, int pos, android.view.MotionEvent.PointerCoords outPointerCoords) { throw new RuntimeException("Stub!"); }

/**
 * Returns a bitfield indicating which edges, if any, were touched by this
 * MotionEvent. For touch events, clients can use this to determine if the
 * user's finger was touching the edge of the display.
 *
 * This property is only set for {@link #ACTION_DOWN} events.
 *
 * @see #EDGE_LEFT
 * @see #EDGE_TOP
 * @see #EDGE_RIGHT
 * @see #EDGE_BOTTOM
 * @apiSince 1
 */

public int getEdgeFlags() { throw new RuntimeException("Stub!"); }

/**
 * Sets the bitfield indicating which edges, if any, were touched by this
 * MotionEvent.
 *
 * @see #getEdgeFlags()
 * @apiSince 1
 */

public void setEdgeFlags(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Sets this event's action.
 * @apiSince 1
 */

public void setAction(int action) { throw new RuntimeException("Stub!"); }

/**
 * Adjust this event's location.
 * @param deltaX Amount to add to the current X coordinate of the event.
 * @param deltaY Amount to add to the current Y coordinate of the event.
 * @apiSince 1
 */

public void offsetLocation(float deltaX, float deltaY) { throw new RuntimeException("Stub!"); }

/**
 * Set this event's location.  Applies {@link #offsetLocation} with a
 * delta from the current location to the given new location.
 *
 * @param x New absolute X location.
 * @param y New absolute Y location.
 * @apiSince 1
 */

public void setLocation(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Applies a transformation matrix to all of the points in the event.
 *
 * @param matrix The transformation matrix to apply.
 * @apiSince 11
 */

public void transform(android.graphics.Matrix matrix) { throw new RuntimeException("Stub!"); }

/**
 * Add a new movement to the batch of movements in this event.  The event's
 * current location, position and size is updated to the new values.
 * The current values in the event are added to a list of historical values.
 *
 * Only applies to {@link #ACTION_MOVE} or {@link #ACTION_HOVER_MOVE} events.
 *
 * @param eventTime The time stamp (in ms) for this data.
 * @param x The new X position.
 * @param y The new Y position.
 * @param pressure The new pressure.
 * @param size The new size.
 * @param metaState Meta key state.
 * @apiSince 1
 */

public void addBatch(long eventTime, float x, float y, float pressure, float size, int metaState) { throw new RuntimeException("Stub!"); }

/**
 * Add a new movement to the batch of movements in this event.  The event's
 * current location, position and size is updated to the new values.
 * The current values in the event are added to a list of historical values.
 *
 * Only applies to {@link #ACTION_MOVE} or {@link #ACTION_HOVER_MOVE} events.
 *
 * @param eventTime The time stamp (in ms) for this data.
 * @param pointerCoords The new pointer coordinates.
 * @param metaState Meta key state.
 * @apiSince 9
 */

public void addBatch(long eventTime, android.view.MotionEvent.PointerCoords[] pointerCoords, int metaState) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string that represents the symbolic name of the specified unmasked action
 * such as "ACTION_DOWN", "ACTION_POINTER_DOWN(3)" or an equivalent numeric constant
 * such as "35" if unknown.
 *
 * @param action The unmasked action.
 * @return The symbolic name of the specified action.
 * @see #getAction()
 * @apiSince 19
 */

public static java.lang.String actionToString(int action) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string that represents the symbolic name of the specified axis
 * such as "AXIS_X" or an equivalent numeric constant such as "42" if unknown.
 *
 * @param axis The axis.
 * @return The symbolic name of the specified axis.
 * @apiSince 12
 */

public static java.lang.String axisToString(int axis) { throw new RuntimeException("Stub!"); }

/**
 * Gets an axis by its symbolic name such as "AXIS_X" or an
 * equivalent numeric constant such as "42".
 *
 * @param symbolicName The symbolic name of the axis.
 * @return The axis or -1 if not found.
 * @see android.view.KeyEvent#keyCodeToString(int)
 * @apiSince 12
 */

public static int axisFromString(java.lang.String symbolicName) { throw new RuntimeException("Stub!"); }

/**
 * Checks if a mouse or stylus button (or combination of buttons) is pressed.
 * @param button Button (or combination of buttons).
 * @return True if specified buttons are pressed.
 *
 * @see #BUTTON_PRIMARY
 * @see #BUTTON_SECONDARY
 * @see #BUTTON_TERTIARY
 * @see #BUTTON_FORWARD
 * @see #BUTTON_BACK
 * @see #BUTTON_STYLUS_PRIMARY
 * @see #BUTTON_STYLUS_SECONDARY
 * @apiSince 21
 */

public boolean isButtonPressed(int button) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Constant for {@link #getActionMasked}: A button has been pressed.
 *
 * <p>
 * Use {@link #getActionButton()} to get which button was pressed.
 * </p><p>
 * This action is not a touch event so it is delivered to
 * {@link android.view.View#onGenericMotionEvent(android.view.MotionEvent) View#onGenericMotionEvent(MotionEvent)} rather than
 * {@link android.view.View#onTouchEvent(android.view.MotionEvent) View#onTouchEvent(MotionEvent)}.
 * </p>
 * @apiSince 23
 */

public static final int ACTION_BUTTON_PRESS = 11; // 0xb

/**
 * Constant for {@link #getActionMasked}: A button has been released.
 *
 * <p>
 * Use {@link #getActionButton()} to get which button was released.
 * </p><p>
 * This action is not a touch event so it is delivered to
 * {@link android.view.View#onGenericMotionEvent(android.view.MotionEvent) View#onGenericMotionEvent(MotionEvent)} rather than
 * {@link android.view.View#onTouchEvent(android.view.MotionEvent) View#onTouchEvent(MotionEvent)}.
 * </p>
 * @apiSince 23
 */

public static final int ACTION_BUTTON_RELEASE = 12; // 0xc

/**
 * Constant for {@link #getActionMasked}: The current gesture has been aborted.
 * You will not receive any more points in it.  You should treat this as
 * an up event, but not perform any action that you normally would.
 * @apiSince 1
 */

public static final int ACTION_CANCEL = 3; // 0x3

/**
 * Constant for {@link #getActionMasked}: A pressed gesture has started, the
 * motion contains the initial starting location.
 * <p>
 * This is also a good time to check the button state to distinguish
 * secondary and tertiary button clicks and handle them appropriately.
 * Use {@link #getButtonState} to retrieve the button state.
 * </p>
 * @apiSince 1
 */

public static final int ACTION_DOWN = 0; // 0x0

/**
 * Constant for {@link #getActionMasked}: The pointer is not down but has entered the
 * boundaries of a window or view.
 * <p>
 * This action is always delivered to the window or view under the pointer.
 * </p><p>
 * This action is not a touch event so it is delivered to
 * {@link android.view.View#onGenericMotionEvent(android.view.MotionEvent) View#onGenericMotionEvent(MotionEvent)} rather than
 * {@link android.view.View#onTouchEvent(android.view.MotionEvent) View#onTouchEvent(MotionEvent)}.
 * </p>
 * @apiSince 14
 */

public static final int ACTION_HOVER_ENTER = 9; // 0x9

/**
 * Constant for {@link #getActionMasked}: The pointer is not down but has exited the
 * boundaries of a window or view.
 * <p>
 * This action is always delivered to the window or view that was previously under the pointer.
 * </p><p>
 * This action is not a touch event so it is delivered to
 * {@link android.view.View#onGenericMotionEvent(android.view.MotionEvent) View#onGenericMotionEvent(MotionEvent)} rather than
 * {@link android.view.View#onTouchEvent(android.view.MotionEvent) View#onTouchEvent(MotionEvent)}.
 * </p>
 * @apiSince 14
 */

public static final int ACTION_HOVER_EXIT = 10; // 0xa

/**
 * Constant for {@link #getActionMasked}: A change happened but the pointer
 * is not down (unlike {@link #ACTION_MOVE}).  The motion contains the most
 * recent point, as well as any intermediate points since the last
 * hover move event.
 * <p>
 * This action is always delivered to the window or view under the pointer.
 * </p><p>
 * This action is not a touch event so it is delivered to
 * {@link android.view.View#onGenericMotionEvent(android.view.MotionEvent) View#onGenericMotionEvent(MotionEvent)} rather than
 * {@link android.view.View#onTouchEvent(android.view.MotionEvent) View#onTouchEvent(MotionEvent)}.
 * </p>
 * @apiSince 12
 */

public static final int ACTION_HOVER_MOVE = 7; // 0x7

/**
 * Bit mask of the parts of the action code that are the action itself.
 * @apiSince 5
 */

public static final int ACTION_MASK = 255; // 0xff

/**
 * Constant for {@link #getActionMasked}: A change has happened during a
 * press gesture (between {@link #ACTION_DOWN} and {@link #ACTION_UP}).
 * The motion contains the most recent point, as well as any intermediate
 * points since the last down or move event.
 * @apiSince 1
 */

public static final int ACTION_MOVE = 2; // 0x2

/**
 * Constant for {@link #getActionMasked}: A movement has happened outside of the
 * normal bounds of the UI element.  This does not provide a full gesture,
 * but only the initial location of the movement/touch.
 * <p>
 * Note: Because the location of any event will be outside the
 * bounds of the view hierarchy, it will not get dispatched to
 * any children of a ViewGroup by default. Therefore,
 * movements with ACTION_OUTSIDE should be handled in either the
 * root {@link android.view.View View} or in the appropriate {@link android.view.Window.Callback Window.Callback}
 * (e.g. {@link android.app.Activity} or {@link android.app.Dialog}).
 * </p>
 * @apiSince 3
 */

public static final int ACTION_OUTSIDE = 4; // 0x4

/**
 * @deprecated Use {@link #ACTION_POINTER_INDEX_MASK} to retrieve the
 * data index associated with {@link #ACTION_POINTER_DOWN}.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated public static final int ACTION_POINTER_1_DOWN = 5; // 0x5

/**
 * @deprecated Use {@link #ACTION_POINTER_INDEX_MASK} to retrieve the
 * data index associated with {@link #ACTION_POINTER_UP}.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated public static final int ACTION_POINTER_1_UP = 6; // 0x6

/**
 * @deprecated Use {@link #ACTION_POINTER_INDEX_MASK} to retrieve the
 * data index associated with {@link #ACTION_POINTER_DOWN}.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated public static final int ACTION_POINTER_2_DOWN = 261; // 0x105

/**
 * @deprecated Use {@link #ACTION_POINTER_INDEX_MASK} to retrieve the
 * data index associated with {@link #ACTION_POINTER_UP}.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated public static final int ACTION_POINTER_2_UP = 262; // 0x106

/**
 * @deprecated Use {@link #ACTION_POINTER_INDEX_MASK} to retrieve the
 * data index associated with {@link #ACTION_POINTER_DOWN}.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated public static final int ACTION_POINTER_3_DOWN = 517; // 0x205

/**
 * @deprecated Use {@link #ACTION_POINTER_INDEX_MASK} to retrieve the
 * data index associated with {@link #ACTION_POINTER_UP}.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated public static final int ACTION_POINTER_3_UP = 518; // 0x206

/**
 * Constant for {@link #getActionMasked}: A non-primary pointer has gone down.
 * <p>
 * Use {@link #getActionIndex} to retrieve the index of the pointer that changed.
 * </p><p>
 * The index is encoded in the {@link #ACTION_POINTER_INDEX_MASK} bits of the
 * unmasked action returned by {@link #getAction}.
 * </p>
 * @apiSince 5
 */

public static final int ACTION_POINTER_DOWN = 5; // 0x5

/**
 * @deprecated Renamed to {@link #ACTION_POINTER_INDEX_MASK} to match
 * the actual data contained in these bits.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated public static final int ACTION_POINTER_ID_MASK = 65280; // 0xff00

/**
 * @deprecated Renamed to {@link #ACTION_POINTER_INDEX_SHIFT} to match
 * the actual data contained in these bits.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated public static final int ACTION_POINTER_ID_SHIFT = 8; // 0x8

/**
 * Bits in the action code that represent a pointer index, used with
 * {@link #ACTION_POINTER_DOWN} and {@link #ACTION_POINTER_UP}.  Shifting
 * down by {@link #ACTION_POINTER_INDEX_SHIFT} provides the actual pointer
 * index where the data for the pointer going up or down can be found; you can
 * get its identifier with {@link #getPointerId(int)} and the actual
 * data with {@link #getX(int)} etc.
 *
 * @see #getActionIndex
 * @apiSince 8
 */

public static final int ACTION_POINTER_INDEX_MASK = 65280; // 0xff00

/**
 * Bit shift for the action bits holding the pointer index as
 * defined by {@link #ACTION_POINTER_INDEX_MASK}.
 *
 * @see #getActionIndex
 * @apiSince 8
 */

public static final int ACTION_POINTER_INDEX_SHIFT = 8; // 0x8

/**
 * Constant for {@link #getActionMasked}: A non-primary pointer has gone up.
 * <p>
 * Use {@link #getActionIndex} to retrieve the index of the pointer that changed.
 * </p><p>
 * The index is encoded in the {@link #ACTION_POINTER_INDEX_MASK} bits of the
 * unmasked action returned by {@link #getAction}.
 * </p>
 * @apiSince 5
 */

public static final int ACTION_POINTER_UP = 6; // 0x6

/**
 * Constant for {@link #getActionMasked}: The motion event contains relative
 * vertical and/or horizontal scroll offsets.  Use {@link #getAxisValue(int)}
 * to retrieve the information from {@link #AXIS_VSCROLL} and {@link #AXIS_HSCROLL}.
 * The pointer may or may not be down when this event is dispatched.
 * <p>
 * This action is always delivered to the window or view under the pointer, which
 * may not be the window or view currently touched.
 * </p><p>
 * This action is not a touch event so it is delivered to
 * {@link android.view.View#onGenericMotionEvent(android.view.MotionEvent) View#onGenericMotionEvent(MotionEvent)} rather than
 * {@link android.view.View#onTouchEvent(android.view.MotionEvent) View#onTouchEvent(MotionEvent)}.
 * </p>
 * @apiSince 12
 */

public static final int ACTION_SCROLL = 8; // 0x8

/**
 * Constant for {@link #getActionMasked}: A pressed gesture has finished, the
 * motion contains the final release location as well as any intermediate
 * points since the last down or move event.
 * @apiSince 1
 */

public static final int ACTION_UP = 1; // 0x1

/**
 * Axis constant: Brake axis of a motion event.
 * <p>
 * <ul>
 * <li>For a joystick, reports the absolute position of the brake control.
 * The value is normalized to a range from 0.0 (no braking) to 1.0 (maximum braking).
 * </ul>
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_BRAKE = 23; // 0x17

/**
 * Axis constant: Distance axis of a motion event.
 * <p>
 * <ul>
 * <li>For a stylus, reports the distance of the stylus from the screen.
 * A value of 0.0 indicates direct contact and larger values indicate increasing
 * distance from the surface.
 * </ul>
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 14
 */

public static final int AXIS_DISTANCE = 24; // 0x18

/**
 * Axis constant: Gas axis of a motion event.
 * <p>
 * <ul>
 * <li>For a joystick, reports the absolute position of the gas (accelerator) control.
 * The value is normalized to a range from 0.0 (no acceleration)
 * to 1.0 (maximum acceleration).
 * </ul>
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GAS = 22; // 0x16

/**
 * Axis constant: Generic 1 axis of a motion event.
 * The interpretation of a generic axis is device-specific.
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GENERIC_1 = 32; // 0x20

/**
 * Axis constant: Generic 10 axis of a motion event.
 * The interpretation of a generic axis is device-specific.
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GENERIC_10 = 41; // 0x29

/**
 * Axis constant: Generic 11 axis of a motion event.
 * The interpretation of a generic axis is device-specific.
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GENERIC_11 = 42; // 0x2a

/**
 * Axis constant: Generic 12 axis of a motion event.
 * The interpretation of a generic axis is device-specific.
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GENERIC_12 = 43; // 0x2b

/**
 * Axis constant: Generic 13 axis of a motion event.
 * The interpretation of a generic axis is device-specific.
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GENERIC_13 = 44; // 0x2c

/**
 * Axis constant: Generic 14 axis of a motion event.
 * The interpretation of a generic axis is device-specific.
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GENERIC_14 = 45; // 0x2d

/**
 * Axis constant: Generic 15 axis of a motion event.
 * The interpretation of a generic axis is device-specific.
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GENERIC_15 = 46; // 0x2e

/**
 * Axis constant: Generic 16 axis of a motion event.
 * The interpretation of a generic axis is device-specific.
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GENERIC_16 = 47; // 0x2f

/**
 * Axis constant: Generic 2 axis of a motion event.
 * The interpretation of a generic axis is device-specific.
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GENERIC_2 = 33; // 0x21

/**
 * Axis constant: Generic 3 axis of a motion event.
 * The interpretation of a generic axis is device-specific.
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GENERIC_3 = 34; // 0x22

/**
 * Axis constant: Generic 4 axis of a motion event.
 * The interpretation of a generic axis is device-specific.
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GENERIC_4 = 35; // 0x23

/**
 * Axis constant: Generic 5 axis of a motion event.
 * The interpretation of a generic axis is device-specific.
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GENERIC_5 = 36; // 0x24

/**
 * Axis constant: Generic 6 axis of a motion event.
 * The interpretation of a generic axis is device-specific.
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GENERIC_6 = 37; // 0x25

/**
 * Axis constant: Generic 7 axis of a motion event.
 * The interpretation of a generic axis is device-specific.
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GENERIC_7 = 38; // 0x26

/**
 * Axis constant: Generic 8 axis of a motion event.
 * The interpretation of a generic axis is device-specific.
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GENERIC_8 = 39; // 0x27

/**
 * Axis constant: Generic 9 axis of a motion event.
 * The interpretation of a generic axis is device-specific.
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_GENERIC_9 = 40; // 0x28

/**
 * Axis constant: Hat X axis of a motion event.
 * <p>
 * <ul>
 * <li>For a joystick, reports the absolute X position of the directional hat control.
 * The value is normalized to a range from -1.0 (left) to 1.0 (right).
 * </ul>
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_HAT_X = 15; // 0xf

/**
 * Axis constant: Hat Y axis of a motion event.
 * <p>
 * <ul>
 * <li>For a joystick, reports the absolute Y position of the directional hat control.
 * The value is normalized to a range from -1.0 (up) to 1.0 (down).
 * </ul>
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_HAT_Y = 16; // 0x10

/**
 * Axis constant: Horizontal Scroll axis of a motion event.
 * <p>
 * <ul>
 * <li>For a mouse, reports the relative movement of the horizontal scroll wheel.
 * The value is normalized to a range from -1.0 (left) to 1.0 (right).
 * </ul>
 * </p><p>
 * This axis should be used to scroll views horizontally.
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_HSCROLL = 10; // 0xa

/**
 * Axis constant: Left Trigger axis of a motion event.
 * <p>
 * <ul>
 * <li>For a joystick, reports the absolute position of the left trigger control.
 * The value is normalized to a range from 0.0 (released) to 1.0 (fully pressed).
 * </ul>
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_LTRIGGER = 17; // 0x11

/**
 * Axis constant: Orientation axis of a motion event.
 * <p>
 * <ul>
 * <li>For a touch screen or touch pad, reports the orientation of the finger
 * or tool in radians relative to the vertical plane of the device.
 * An angle of 0 radians indicates that the major axis of contact is oriented
 * upwards, is perfectly circular or is of unknown orientation.  A positive angle
 * indicates that the major axis of contact is oriented to the right.  A negative angle
 * indicates that the major axis of contact is oriented to the left.
 * The full range is from -PI/2 radians (finger pointing fully left) to PI/2 radians
 * (finger pointing fully right).
 * <li>For a stylus, the orientation indicates the direction in which the stylus
 * is pointing in relation to the vertical axis of the current orientation of the screen.
 * The range is from -PI radians to PI radians, where 0 is pointing up,
 * -PI/2 radians is pointing left, -PI or PI radians is pointing down, and PI/2 radians
 * is pointing right.  See also {@link #AXIS_TILT}.
 * </ul>
 * </p>
 *
 * @see #getOrientation(int)
 * @see #getHistoricalOrientation(int, int)
 * @see android.view.MotionEvent.PointerCoords#orientation
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_ORIENTATION = 8; // 0x8

/**
 * Axis constant: Pressure axis of a motion event.
 * <p>
 * <ul>
 * <li>For a touch screen or touch pad, reports the approximate pressure applied to the surface
 * by a finger or other tool.  The value is normalized to a range from
 * 0 (no pressure at all) to 1 (normal pressure), although values higher than 1
 * may be generated depending on the calibration of the input device.
 * <li>For a trackball, the value is set to 1 if the trackball button is pressed
 * or 0 otherwise.
 * <li>For a mouse, the value is set to 1 if the primary mouse button is pressed
 * or 0 otherwise.
 * </ul>
 * </p>
 *
 * @see #getPressure(int)
 * @see #getHistoricalPressure(int, int)
 * @see android.view.MotionEvent.PointerCoords#pressure
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_PRESSURE = 2; // 0x2

/**
 * Axis constant: The movement of x position of a motion event.
 * <p>
 * <ul>
 * <li>For a mouse, reports a difference of x position between the previous position.
 * This is useful when pointer is captured, in that case the mouse pointer doesn't change
 * the location but this axis reports the difference which allows the app to see
 * how the mouse is moved.
 * </ul>
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int, int)
 * @see InputDevice#getMotionRange
 * @apiSince 24
 */

public static final int AXIS_RELATIVE_X = 27; // 0x1b

/**
 * Axis constant: The movement of y position of a motion event.
 * <p>
 * This is similar to {@link #AXIS_RELATIVE_X} but for y-axis.
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int, int)
 * @see InputDevice#getMotionRange
 * @apiSince 24
 */

public static final int AXIS_RELATIVE_Y = 28; // 0x1c

/**
 * Axis constant: Right Trigger axis of a motion event.
 * <p>
 * <ul>
 * <li>For a joystick, reports the absolute position of the right trigger control.
 * The value is normalized to a range from 0.0 (released) to 1.0 (fully pressed).
 * </ul>
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_RTRIGGER = 18; // 0x12

/**
 * Axis constant: Rudder axis of a motion event.
 * <p>
 * <ul>
 * <li>For a joystick, reports the absolute position of the rudder control.
 * The value is normalized to a range from -1.0 (turn left) to 1.0 (turn right).
 * </ul>
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_RUDDER = 20; // 0x14

/**
 * Axis constant: X Rotation axis of a motion event.
 * <p>
 * <ul>
 * <li>For a joystick, reports the absolute rotation angle about the X axis.
 * The value is normalized to a range from -1.0 (counter-clockwise) to 1.0 (clockwise).
 * </ul>
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_RX = 12; // 0xc

/**
 * Axis constant: Y Rotation axis of a motion event.
 * <p>
 * <ul>
 * <li>For a joystick, reports the absolute rotation angle about the Y axis.
 * The value is normalized to a range from -1.0 (counter-clockwise) to 1.0 (clockwise).
 * </ul>
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_RY = 13; // 0xd

/**
 * Axis constant: Z Rotation axis of a motion event.
 * <p>
 * <ul>
 * <li>For a joystick, reports the absolute rotation angle about the Z axis.
 * The value is normalized to a range from -1.0 (counter-clockwise) to 1.0 (clockwise).
 * <em>On game pads with two analog joysticks, this axis is often reinterpreted
 * to report the absolute Y position of the second joystick instead.</em>
 * </ul>
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_RZ = 14; // 0xe

/**
 * Axis constant: Generic scroll axis of a motion event.
 * <p>
 * <ul>
 * <li>Reports the relative movement of the generic scrolling device.
 * </ul>
 * </p><p>
 * This axis should be used for scroll events that are neither strictly vertical nor horizontal.
 * A good example would be the rotation of a rotary encoder input device.
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @apiSince 26
 */

public static final int AXIS_SCROLL = 26; // 0x1a

/**
 * Axis constant: Size axis of a motion event.
 * <p>
 * <ul>
 * <li>For a touch screen or touch pad, reports the approximate size of the contact area in
 * relation to the maximum detectable size for the device.  The value is normalized
 * to a range from 0 (smallest detectable size) to 1 (largest detectable size),
 * although it is not a linear scale.  This value is of limited use.
 * To obtain calibrated size information, use
 * {@link #AXIS_TOUCH_MAJOR} or {@link #AXIS_TOOL_MAJOR}.
 * </ul>
 * </p>
 *
 * @see #getSize(int)
 * @see #getHistoricalSize(int, int)
 * @see android.view.MotionEvent.PointerCoords#size
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_SIZE = 3; // 0x3

/**
 * Axis constant: Throttle axis of a motion event.
 * <p>
 * <ul>
 * <li>For a joystick, reports the absolute position of the throttle control.
 * The value is normalized to a range from 0.0 (fully open) to 1.0 (fully closed).
 * </ul>
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_THROTTLE = 19; // 0x13

/**
 * Axis constant: Tilt axis of a motion event.
 * <p>
 * <ul>
 * <li>For a stylus, reports the tilt angle of the stylus in radians where
 * 0 radians indicates that the stylus is being held perpendicular to the
 * surface, and PI/2 radians indicates that the stylus is being held flat
 * against the surface.
 * </ul>
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int, int)
 * @see InputDevice#getMotionRange
 * @apiSince 14
 */

public static final int AXIS_TILT = 25; // 0x19

/**
 * Axis constant: ToolMajor axis of a motion event.
 * <p>
 * <ul>
 * <li>For a touch screen, reports the length of the major axis of an ellipse that
 * represents the size of the approaching finger or tool used to make contact.
 * <li>For a touch pad, reports the length of the major axis of an ellipse that
 * represents the size of the approaching finger or tool used to make contact.
 * The units are device-dependent; use {@link android.view.InputDevice#getMotionRange(int) InputDevice#getMotionRange(int)}
 * to query the effective range of values.
 * </ul>
 * </p><p>
 * When the touch is circular, the major and minor axis lengths will be equal to one another.
 * </p><p>
 * The tool size may be larger than the touch size since the tool may not be fully
 * in contact with the touch sensor.
 * </p>
 *
 * @see #getToolMajor(int)
 * @see #getHistoricalToolMajor(int, int)
 * @see android.view.MotionEvent.PointerCoords#toolMajor
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_TOOL_MAJOR = 6; // 0x6

/**
 * Axis constant: ToolMinor axis of a motion event.
 * <p>
 * <ul>
 * <li>For a touch screen, reports the length of the minor axis of an ellipse that
 * represents the size of the approaching finger or tool used to make contact.
 * <li>For a touch pad, reports the length of the minor axis of an ellipse that
 * represents the size of the approaching finger or tool used to make contact.
 * The units are device-dependent; use {@link android.view.InputDevice#getMotionRange(int) InputDevice#getMotionRange(int)}
 * to query the effective range of values.
 * </ul>
 * </p><p>
 * When the touch is circular, the major and minor axis lengths will be equal to one another.
 * </p><p>
 * The tool size may be larger than the touch size since the tool may not be fully
 * in contact with the touch sensor.
 * </p>
 *
 * @see #getToolMinor(int)
 * @see #getHistoricalToolMinor(int, int)
 * @see android.view.MotionEvent.PointerCoords#toolMinor
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_TOOL_MINOR = 7; // 0x7

/**
 * Axis constant: TouchMajor axis of a motion event.
 * <p>
 * <ul>
 * <li>For a touch screen, reports the length of the major axis of an ellipse that
 * represents the touch area at the point of contact.
 * The units are display pixels.
 * <li>For a touch pad, reports the length of the major axis of an ellipse that
 * represents the touch area at the point of contact.
 * The units are device-dependent; use {@link android.view.InputDevice#getMotionRange(int) InputDevice#getMotionRange(int)}
 * to query the effective range of values.
 * </ul>
 * </p>
 *
 * @see #getTouchMajor(int)
 * @see #getHistoricalTouchMajor(int, int)
 * @see android.view.MotionEvent.PointerCoords#touchMajor
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_TOUCH_MAJOR = 4; // 0x4

/**
 * Axis constant: TouchMinor axis of a motion event.
 * <p>
 * <ul>
 * <li>For a touch screen, reports the length of the minor axis of an ellipse that
 * represents the touch area at the point of contact.
 * The units are display pixels.
 * <li>For a touch pad, reports the length of the minor axis of an ellipse that
 * represents the touch area at the point of contact.
 * The units are device-dependent; use {@link android.view.InputDevice#getMotionRange(int) InputDevice#getMotionRange(int)}
 * to query the effective range of values.
 * </ul>
 * </p><p>
 * When the touch is circular, the major and minor axis lengths will be equal to one another.
 * </p>
 *
 * @see #getTouchMinor(int)
 * @see #getHistoricalTouchMinor(int, int)
 * @see android.view.MotionEvent.PointerCoords#touchMinor
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_TOUCH_MINOR = 5; // 0x5

/**
 * Axis constant: Vertical Scroll axis of a motion event.
 * <p>
 * <ul>
 * <li>For a mouse, reports the relative movement of the vertical scroll wheel.
 * The value is normalized to a range from -1.0 (down) to 1.0 (up).
 * </ul>
 * </p><p>
 * This axis should be used to scroll views vertically.
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_VSCROLL = 9; // 0x9

/**
 * Axis constant: Wheel axis of a motion event.
 * <p>
 * <ul>
 * <li>For a joystick, reports the absolute position of the steering wheel control.
 * The value is normalized to a range from -1.0 (turn left) to 1.0 (turn right).
 * </ul>
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_WHEEL = 21; // 0x15

/**
 * Axis constant: X axis of a motion event.
 * <p>
 * <ul>
 * <li>For a touch screen, reports the absolute X screen position of the center of
 * the touch contact area.  The units are display pixels.
 * <li>For a touch pad, reports the absolute X surface position of the center of the touch
 * contact area.  The units are device-dependent; use {@link android.view.InputDevice#getMotionRange(int) InputDevice#getMotionRange(int)}
 * to query the effective range of values.
 * <li>For a mouse, reports the absolute X screen position of the mouse pointer.
 * The units are display pixels.
 * <li>For a trackball, reports the relative horizontal displacement of the trackball.
 * The value is normalized to a range from -1.0 (left) to 1.0 (right).
 * <li>For a joystick, reports the absolute X position of the joystick.
 * The value is normalized to a range from -1.0 (left) to 1.0 (right).
 * </ul>
 * </p>
 *
 * @see #getX(int)
 * @see #getHistoricalX(int, int)
 * @see android.view.MotionEvent.PointerCoords#x
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_X = 0; // 0x0

/**
 * Axis constant: Y axis of a motion event.
 * <p>
 * <ul>
 * <li>For a touch screen, reports the absolute Y screen position of the center of
 * the touch contact area.  The units are display pixels.
 * <li>For a touch pad, reports the absolute Y surface position of the center of the touch
 * contact area.  The units are device-dependent; use {@link android.view.InputDevice#getMotionRange(int) InputDevice#getMotionRange(int)}
 * to query the effective range of values.
 * <li>For a mouse, reports the absolute Y screen position of the mouse pointer.
 * The units are display pixels.
 * <li>For a trackball, reports the relative vertical displacement of the trackball.
 * The value is normalized to a range from -1.0 (up) to 1.0 (down).
 * <li>For a joystick, reports the absolute Y position of the joystick.
 * The value is normalized to a range from -1.0 (up or far) to 1.0 (down or near).
 * </ul>
 * </p>
 *
 * @see #getY(int)
 * @see #getHistoricalY(int, int)
 * @see android.view.MotionEvent.PointerCoords#y
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_Y = 1; // 0x1

/**
 * Axis constant: Z axis of a motion event.
 * <p>
 * <ul>
 * <li>For a joystick, reports the absolute Z position of the joystick.
 * The value is normalized to a range from -1.0 (high) to 1.0 (low).
 * <em>On game pads with two analog joysticks, this axis is often reinterpreted
 * to report the absolute X position of the second joystick instead.</em>
 * </ul>
 * </p>
 *
 * @see #getAxisValue(int, int)
 * @see #getHistoricalAxisValue(int, int, int)
 * @see android.view.MotionEvent.PointerCoords#getAxisValue(int)
 * @see InputDevice#getMotionRange
 * @apiSince 12
 */

public static final int AXIS_Z = 11; // 0xb

/**
 * Button constant: Back button pressed (mouse back button).
 * <p>
 * The system may send a {@link android.view.KeyEvent#KEYCODE_BACK KeyEvent#KEYCODE_BACK} key press to the application
 * when this button is pressed.
 * </p>
 *
 * @see #getButtonState
 * @apiSince 14
 */

public static final int BUTTON_BACK = 8; // 0x8

/**
 * Button constant: Forward button pressed (mouse forward button).
 * <p>
 * The system may send a {@link android.view.KeyEvent#KEYCODE_FORWARD KeyEvent#KEYCODE_FORWARD} key press to the application
 * when this button is pressed.
 * </p>
 *
 * @see #getButtonState
 * @apiSince 14
 */

public static final int BUTTON_FORWARD = 16; // 0x10

/**
 * Button constant: Primary button (left mouse button).
 *
 * This button constant is not set in response to simple touches with a finger
 * or stylus tip.  The user must actually push a button.
 *
 * @see #getButtonState
 * @apiSince 14
 */

public static final int BUTTON_PRIMARY = 1; // 0x1

/**
 * Button constant: Secondary button (right mouse button).
 *
 * @see #getButtonState
 * @apiSince 14
 */

public static final int BUTTON_SECONDARY = 2; // 0x2

/**
 * Button constant: Primary stylus button pressed.
 *
 * @see #getButtonState
 * @apiSince 23
 */

public static final int BUTTON_STYLUS_PRIMARY = 32; // 0x20

/**
 * Button constant: Secondary stylus button pressed.
 *
 * @see #getButtonState
 * @apiSince 23
 */

public static final int BUTTON_STYLUS_SECONDARY = 64; // 0x40

/**
 * Button constant: Tertiary button (middle mouse button).
 *
 * @see #getButtonState
 * @apiSince 14
 */

public static final int BUTTON_TERTIARY = 4; // 0x4

/**
 * Classification constant: Ambiguous gesture.
 *
 * The user's intent with respect to the current event stream is not yet determined.
 * Gestural actions, such as scrolling, should be inhibited until the classification resolves
 * to another value or the event stream ends.
 *
 * @see #getClassification
 * @apiSince 29
 */

public static final int CLASSIFICATION_AMBIGUOUS_GESTURE = 1; // 0x1

/**
 * Classification constant: Deep press.
 *
 * The current event stream represents the user intentionally pressing harder on the screen.
 * This classification type should be used to accelerate the long press behaviour.
 *
 * @see #getClassification
 * @apiSince 29
 */

public static final int CLASSIFICATION_DEEP_PRESS = 2; // 0x2

/**
 * Classification constant: None.
 *
 * No additional information is available about the current motion event stream.
 *
 * @see #getClassification
 * @apiSince 29
 */

public static final int CLASSIFICATION_NONE = 0; // 0x0

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.MotionEvent> CREATOR;
static { CREATOR = null; }

/**
 * Flag indicating the motion event intersected the bottom edge of the screen.
 * @apiSince 1
 */

public static final int EDGE_BOTTOM = 2; // 0x2

/**
 * Flag indicating the motion event intersected the left edge of the screen.
 * @apiSince 1
 */

public static final int EDGE_LEFT = 4; // 0x4

/**
 * Flag indicating the motion event intersected the right edge of the screen.
 * @apiSince 1
 */

public static final int EDGE_RIGHT = 8; // 0x8

/**
 * Flag indicating the motion event intersected the top edge of the screen.
 * @apiSince 1
 */

public static final int EDGE_TOP = 1; // 0x1

/**
 * This flag indicates that the window that received this motion event is partly
 * or wholly obscured by another visible window above it. This flag is set to true
 * if the event directly passed through the obscured area.
 *
 * A security sensitive application can check this flag to identify situations in which
 * a malicious application may have covered up part of its content for the purpose
 * of misleading the user or hijacking touches.  An appropriate response might be
 * to drop the suspect touches or to take additional precautions to confirm the user's
 * actual intent.
 * @apiSince 9
 */

public static final int FLAG_WINDOW_IS_OBSCURED = 1; // 0x1

/**
 * This flag indicates that the window that received this motion event is partly
 * or wholly obscured by another visible window above it. This flag is set to true
 * even if the event did not directly pass through the obscured area.
 *
 * A security sensitive application can check this flag to identify situations in which
 * a malicious application may have covered up part of its content for the purpose
 * of misleading the user or hijacking touches.  An appropriate response might be
 * to drop the suspect touches or to take additional precautions to confirm the user's
 * actual intent.
 *
 * Unlike FLAG_WINDOW_IS_OBSCURED, this is true even if the window that received this event is
 * obstructed in areas other than the touched location.
 * @apiSince 29
 */

public static final int FLAG_WINDOW_IS_PARTIALLY_OBSCURED = 2; // 0x2

/**
 * An invalid pointer id.
 *
 * This value (-1) can be used as a placeholder to indicate that a pointer id
 * has not been assigned or is not available.  It cannot appear as
 * a pointer id inside a {@link android.view.MotionEvent MotionEvent}.
 * @apiSince 14
 */

public static final int INVALID_POINTER_ID = -1; // 0xffffffff

/**
 * Tool type constant: The tool is an eraser or a stylus being used in an inverted posture.
 *
 * @see #getToolType
 * @apiSince 14
 */

public static final int TOOL_TYPE_ERASER = 4; // 0x4

/**
 * Tool type constant: The tool is a finger.
 *
 * @see #getToolType
 * @apiSince 14
 */

public static final int TOOL_TYPE_FINGER = 1; // 0x1

/**
 * Tool type constant: The tool is a mouse or trackpad.
 *
 * @see #getToolType
 * @apiSince 14
 */

public static final int TOOL_TYPE_MOUSE = 3; // 0x3

/**
 * Tool type constant: The tool is a stylus.
 *
 * @see #getToolType
 * @apiSince 14
 */

public static final int TOOL_TYPE_STYLUS = 2; // 0x2

/**
 * Tool type constant: Unknown tool type.
 * This constant is used when the tool type is not known or is not relevant,
 * such as for a trackball or other non-pointing device.
 *
 * @see #getToolType
 * @apiSince 14
 */

public static final int TOOL_TYPE_UNKNOWN = 0; // 0x0
/**
 * Transfer object for pointer coordinates.
 *
 * Objects of this type can be used to specify the pointer coordinates when
 * creating new {@link android.view.MotionEvent MotionEvent} objects and to query pointer coordinates
 * in bulk.
 *
 * Refer to {@link android.view.InputDevice InputDevice} for information about how different kinds of
 * input devices and sources represent pointer coordinates.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class PointerCoords {

/**
 * Creates a pointer coords object with all axes initialized to zero.
 * @apiSince 9
 */

public PointerCoords() { throw new RuntimeException("Stub!"); }

/**
 * Creates a pointer coords object as a copy of the
 * contents of another pointer coords object.
 *
 * @param other The pointer coords object to copy.
 * @apiSince 12
 */

public PointerCoords(android.view.MotionEvent.PointerCoords other) { throw new RuntimeException("Stub!"); }

/**
 * Clears the contents of this object.
 * Resets all axes to zero.
 * @apiSince 12
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Copies the contents of another pointer coords object.
 *
 * @param other The pointer coords object to copy.
 * @apiSince 12
 */

public void copyFrom(android.view.MotionEvent.PointerCoords other) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value associated with the specified axis.
 *
 * @param axis The axis identifier for the axis value to retrieve.
 * @return The value associated with the axis, or 0 if none.
 *
 * @see android.view.MotionEvent#AXIS_X
 * @see android.view.MotionEvent#AXIS_Y
 * @apiSince 12
 */

public float getAxisValue(int axis) { throw new RuntimeException("Stub!"); }

/**
 * Sets the value associated with the specified axis.
 *
 * @param axis The axis identifier for the axis value to assign.
 * @param value The value to set.
 *
 * @see android.view.MotionEvent#AXIS_X
 * @see android.view.MotionEvent#AXIS_Y
 * @apiSince 12
 */

public void setAxisValue(int axis, float value) { throw new RuntimeException("Stub!"); }

/**
 * The orientation of the touch area and tool area in radians clockwise from vertical.
 * An angle of 0 radians indicates that the major axis of contact is oriented
 * upwards, is perfectly circular or is of unknown orientation.  A positive angle
 * indicates that the major axis of contact is oriented to the right.  A negative angle
 * indicates that the major axis of contact is oriented to the left.
 * The full range is from -PI/2 radians (finger pointing fully left) to PI/2 radians
 * (finger pointing fully right).
 *
 * @see android.view.MotionEvent#AXIS_ORIENTATION
 * @apiSince 9
 */

public float orientation;

/**
 * A normalized value that describes the pressure applied to the device
 * by a finger or other tool.
 * The pressure generally ranges from 0 (no pressure at all) to 1 (normal pressure),
 * although values higher than 1 may be generated depending on the calibration of
 * the input device.
 *
 * @see android.view.MotionEvent#AXIS_PRESSURE
 * @apiSince 9
 */

public float pressure;

/**
 * A normalized value that describes the approximate size of the pointer touch area
 * in relation to the maximum detectable size of the device.
 * It represents some approximation of the area of the screen being
 * pressed; the actual value in pixels corresponding to the
 * touch is normalized with the device specific range of values
 * and scaled to a value between 0 and 1. The value of size can be used to
 * determine fat touch events.
 *
 * @see android.view.MotionEvent#AXIS_SIZE
 * @apiSince 9
 */

public float size;

/**
 * The length of the major axis of an ellipse that describes the size of
 * the approaching tool.
 * The tool area represents the estimated size of the finger or pen that is
 * touching the device independent of its actual touch area at the point of contact.
 * If the device is a touch screen, the length is reported in pixels, otherwise it is
 * reported in device-specific units.
 *
 * @see android.view.MotionEvent#AXIS_TOOL_MAJOR
 * @apiSince 9
 */

public float toolMajor;

/**
 * The length of the minor axis of an ellipse that describes the size of
 * the approaching tool.
 * The tool area represents the estimated size of the finger or pen that is
 * touching the device independent of its actual touch area at the point of contact.
 * If the device is a touch screen, the length is reported in pixels, otherwise it is
 * reported in device-specific units.
 *
 * @see android.view.MotionEvent#AXIS_TOOL_MINOR
 * @apiSince 9
 */

public float toolMinor;

/**
 * The length of the major axis of an ellipse that describes the touch area at
 * the point of contact.
 * If the device is a touch screen, the length is reported in pixels, otherwise it is
 * reported in device-specific units.
 *
 * @see android.view.MotionEvent#AXIS_TOUCH_MAJOR
 * @apiSince 9
 */

public float touchMajor;

/**
 * The length of the minor axis of an ellipse that describes the touch area at
 * the point of contact.
 * If the device is a touch screen, the length is reported in pixels, otherwise it is
 * reported in device-specific units.
 *
 * @see android.view.MotionEvent#AXIS_TOUCH_MINOR
 * @apiSince 9
 */

public float touchMinor;

/**
 * The X component of the pointer movement.
 *
 * @see android.view.MotionEvent#AXIS_X
 * @apiSince 9
 */

public float x;

/**
 * The Y component of the pointer movement.
 *
 * @see android.view.MotionEvent#AXIS_Y
 * @apiSince 9
 */

public float y;
}

/**
 * Transfer object for pointer properties.
 *
 * Objects of this type can be used to specify the pointer id and tool type
 * when creating new {@link android.view.MotionEvent MotionEvent} objects and to query pointer properties in bulk.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class PointerProperties {

/**
 * Creates a pointer properties object with an invalid pointer id.
 * @apiSince 14
 */

public PointerProperties() { throw new RuntimeException("Stub!"); }

/**
 * Creates a pointer properties object as a copy of the contents of
 * another pointer properties object.
 * @param other
 * @apiSince 14
 */

public PointerProperties(android.view.MotionEvent.PointerProperties other) { throw new RuntimeException("Stub!"); }

/**
 * Resets the pointer properties to their initial values.
 * @apiSince 14
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Copies the contents of another pointer properties object.
 *
 * @param other The pointer properties object to copy.
 * @apiSince 14
 */

public void copyFrom(android.view.MotionEvent.PointerProperties other) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * The pointer id.
 * Initially set to {@link #INVALID_POINTER_ID} (-1).
 *
 * @see android.view.MotionEvent#getPointerId(int)
 * @apiSince 14
 */

public int id;

/**
 * The pointer tool type.
 * Initially set to 0.
 *
 * @see android.view.MotionEvent#getToolType(int)
 * @apiSince 14
 */

public int toolType;
}

}

