/*
 * Copyright (C) 2010 The Android Open Source Project
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

import android.hardware.input.InputManager;
import android.content.Context;
import android.os.Vibrator;

/**
 * Describes the capabilities of a particular input device.
 * <p>
 * Each input device may support multiple classes of input.  For example, a multi-function
 * keyboard may compose the capabilities of a standard keyboard together with a track pad mouse
 * or other pointing device.
 * </p><p>
 * Some input devices present multiple distinguishable sources of input.
 * Applications can query the framework about the characteristics of each distinct source.
 * </p><p>
 * As a further wrinkle, different kinds of input sources uses different coordinate systems
 * to describe motion events.  Refer to the comments on the input source constants for
 * the appropriate interpretation.
 * </p>
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class InputDevice implements android.os.Parcelable {

private InputDevice() { throw new RuntimeException("Stub!"); }

/**
 * Gets information about the input device with the specified id.
 * @param id The device id.
 * @return The input device or null if not found.
 * @apiSince 9
 */

public static android.view.InputDevice getDevice(int id) { throw new RuntimeException("Stub!"); }

/**
 * Gets the ids of all input devices in the system.
 * @return The input device ids.
 * @apiSince 9
 */

public static int[] getDeviceIds() { throw new RuntimeException("Stub!"); }

/**
 * Gets the input device id.
 * <p>
 * Each input device receives a unique id when it is first configured
 * by the system.  The input device id may change when the system is restarted or if the
 * input device is disconnected, reconnected or reconfigured at any time.
 * If you require a stable identifier for a device that persists across
 * boots and reconfigurations, use {@link #getDescriptor()}.
 * </p>
 *
 * @return The input device id.
 * @apiSince 9
 */

public int getId() { throw new RuntimeException("Stub!"); }

/**
 * The controller number for a given input device.
 * <p>
 * Each gamepad or joystick is given a unique, positive controller number when initially
 * configured by the system. This number may change due to events such as device disconnects /
 * reconnects or user initiated reassignment. Any change in number will trigger an event that
 * can be observed by registering an {@link android.hardware.input.InputManager.InputDeviceListener InputManager.InputDeviceListener}.
 * </p>
 * <p>
 * All input devices which are not gamepads or joysticks will be assigned a controller number
 * of 0.
 * </p>
 *
 * @return The controller number of the device.
 * @apiSince 19
 */

public int getControllerNumber() { throw new RuntimeException("Stub!"); }

/**
 * Gets the vendor id for the given device, if available.
 * <p>
 * A vendor id uniquely identifies the company who manufactured the device. A value of 0 will
 * be assigned where a vendor id is not available.
 * </p>
 *
 * @return The vendor id of a given device
 * @apiSince 19
 */

public int getVendorId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the product id for the given device, if available.
 * <p>
 * A product id uniquely identifies which product within the address space of a given vendor,
 * identified by the device's vendor id. A value of 0 will be assigned where a product id is
 * not available.
 * </p>
 *
 * @return The product id of a given device
 * @apiSince 19
 */

public int getProductId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the input device descriptor, which is a stable identifier for an input device.
 * <p>
 * An input device descriptor uniquely identifies an input device.  Its value
 * is intended to be persistent across system restarts, and should not change even
 * if the input device is disconnected, reconnected or reconfigured at any time.
 * </p><p>
 * It is possible for there to be multiple {@link android.view.InputDevice InputDevice} instances that have the
 * same input device descriptor.  This might happen in situations where a single
 * human input device registers multiple {@link android.view.InputDevice InputDevice} instances (HID collections)
 * that describe separate features of the device, such as a keyboard that also
 * has a trackpad.  Alternately, it may be that the input devices are simply
 * indistinguishable, such as two keyboards made by the same manufacturer.
 * </p><p>
 * The input device descriptor returned by {@link #getDescriptor} should only be
 * used when an application needs to remember settings associated with a particular
 * input device.  For all other purposes when referring to a logical
 * {@link android.view.InputDevice InputDevice} instance at runtime use the id returned by {@link #getId()}.
 * </p>
 *
 * @return The input device descriptor.
 * @apiSince 16
 */

public java.lang.String getDescriptor() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the device is a virtual input device rather than a real one,
 * such as the virtual keyboard (see {@link android.view.KeyCharacterMap#VIRTUAL_KEYBOARD KeyCharacterMap#VIRTUAL_KEYBOARD}).
 * <p>
 * Virtual input devices are provided to implement system-level functionality
 * and should not be seen or configured by users.
 * </p>
 *
 * @return True if the device is virtual.
 *
 * @see android.view.KeyCharacterMap#VIRTUAL_KEYBOARD
 * @apiSince 16
 */

public boolean isVirtual() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the device is external (connected to USB or Bluetooth or some other
 * peripheral bus), otherwise it is built-in.
 *
 * @return True if the device is external.
 * @apiSince 29
 */

public boolean isExternal() { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of this input device.
 * @return The input device name.
 * @apiSince 9
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Gets the input sources supported by this input device as a combined bitfield.
 * @return The supported input sources.
 * @apiSince 9
 */

public int getSources() { throw new RuntimeException("Stub!"); }

/**
 * Determines whether the input device supports the given source or sources.
 *
 * @param source The input source or sources to check against. This can be a generic device
 * type such as {@link android.view.InputDevice#SOURCE_MOUSE InputDevice#SOURCE_MOUSE}, a more generic device class, such as
 * {@link android.view.InputDevice#SOURCE_CLASS_POINTER InputDevice#SOURCE_CLASS_POINTER}, or a combination of sources bitwise ORed together.
 * @return Whether the device can produce all of the given sources.
 * @apiSince 21
 */

public boolean supportsSource(int source) { throw new RuntimeException("Stub!"); }

/**
 * Gets the keyboard type.
 * @return The keyboard type.
 * @apiSince 9
 */

public int getKeyboardType() { throw new RuntimeException("Stub!"); }

/**
 * Gets the key character map associated with this input device.
 * @return The key character map.
 * @apiSince 9
 */

public android.view.KeyCharacterMap getKeyCharacterMap() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether the device is capable of producing the list of keycodes.
 * @param keys The list of android keycodes to check for.
 * @return An array of booleans where each member specifies whether the device is capable of
 * generating the keycode given by the corresponding value at the same index in the keys array.
 * @apiSince 19
 */

public boolean[] hasKeys(int... keys) { throw new RuntimeException("Stub!"); }

/**
 * Gets information about the range of values for a particular {@link android.view.MotionEvent MotionEvent} axis.
 * If the device supports multiple sources, the same axis may have different meanings
 * for each source.  Returns information about the first axis found for any source.
 * To obtain information about the axis for a specific source, use
 * {@link #getMotionRange(int,int)}.
 *
 * @param axis The axis constant.
 * @return The range of values, or null if the requested axis is not
 * supported by the device.
 *
 * @see android.view.MotionEvent#AXIS_X
 * @see android.view.MotionEvent#AXIS_Y
 * @apiSince 9
 */

public android.view.InputDevice.MotionRange getMotionRange(int axis) { throw new RuntimeException("Stub!"); }

/**
 * Gets information about the range of values for a particular {@link android.view.MotionEvent MotionEvent} axis
 * used by a particular source on the device.
 * If the device supports multiple sources, the same axis may have different meanings
 * for each source.
 *
 * @param axis The axis constant.
 * @param source The source for which to return information.
 * @return The range of values, or null if the requested axis is not
 * supported by the device.
 *
 * @see android.view.MotionEvent#AXIS_X
 * @see android.view.MotionEvent#AXIS_Y
 * @apiSince 12
 */

public android.view.InputDevice.MotionRange getMotionRange(int axis, int source) { throw new RuntimeException("Stub!"); }

/**
 * Gets the ranges for all axes supported by the device.
 * @return The motion ranges for the device.
 *
 * @see #getMotionRange(int, int)
 * @apiSince 12
 */

public java.util.List<android.view.InputDevice.MotionRange> getMotionRanges() { throw new RuntimeException("Stub!"); }

/**
 * Gets the vibrator service associated with the device, if there is one.
 * Even if the device does not have a vibrator, the result is never null.
 * Use {@link android.os.Vibrator#hasVibrator Vibrator#hasVibrator} to determine whether a vibrator is
 * present.
 *
 * Note that the vibrator associated with the device may be different from
 * the system vibrator.  To obtain an instance of the system vibrator instead, call
 * {@link android.content.Context#getSystemService Context#getSystemService} with {@link android.content.Context#VIBRATOR_SERVICE Context#VIBRATOR_SERVICE} as argument.
 *
 * @return The vibrator service associated with the device, never null.
 * @apiSince 16
 */

public android.os.Vibrator getVibrator() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if input device is enabled.
 * @return Whether the input device is enabled.
 * @apiSince 27
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Reports whether the device has a built-in microphone.
 * @return Whether the device has a built-in microphone.
 * @apiSince 23
 */

public boolean hasMicrophone() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.InputDevice> CREATOR;
static { CREATOR = null; }

/**
 * The keyboard supports a complement of alphabetic keys.
 * @apiSince 9
 */

public static final int KEYBOARD_TYPE_ALPHABETIC = 2; // 0x2

/**
 * There is no keyboard.
 * @apiSince 9
 */

public static final int KEYBOARD_TYPE_NONE = 0; // 0x0

/**
 * The keyboard is not fully alphabetic.  It may be a numeric keypad or an assortment
 * of buttons that are not mapped as alphabetic keys suitable for text input.
 * @apiSince 9
 */

public static final int KEYBOARD_TYPE_NON_ALPHABETIC = 1; // 0x1

/**
 * Constant for retrieving the range of values for {@link android.view.MotionEvent#AXIS_ORIENTATION MotionEvent#AXIS_ORIENTATION}.
 *
 * @see #getMotionRange
 * @deprecated Use {@link android.view.MotionEvent#AXIS_ORIENTATION MotionEvent#AXIS_ORIENTATION} instead.
 * @apiSince 9
 * @deprecatedSince 15
 */

@Deprecated public static final int MOTION_RANGE_ORIENTATION = 8; // 0x8

/**
 * Constant for retrieving the range of values for {@link android.view.MotionEvent#AXIS_PRESSURE MotionEvent#AXIS_PRESSURE}.
 *
 * @see #getMotionRange
 * @deprecated Use {@link android.view.MotionEvent#AXIS_PRESSURE MotionEvent#AXIS_PRESSURE} instead.
 * @apiSince 9
 * @deprecatedSince 15
 */

@Deprecated public static final int MOTION_RANGE_PRESSURE = 2; // 0x2

/**
 * Constant for retrieving the range of values for {@link android.view.MotionEvent#AXIS_SIZE MotionEvent#AXIS_SIZE}.
 *
 * @see #getMotionRange
 * @deprecated Use {@link android.view.MotionEvent#AXIS_SIZE MotionEvent#AXIS_SIZE} instead.
 * @apiSince 9
 * @deprecatedSince 15
 */

@Deprecated public static final int MOTION_RANGE_SIZE = 3; // 0x3

/**
 * Constant for retrieving the range of values for {@link android.view.MotionEvent#AXIS_TOOL_MAJOR MotionEvent#AXIS_TOOL_MAJOR}.
 *
 * @see #getMotionRange
 * @deprecated Use {@link android.view.MotionEvent#AXIS_TOOL_MAJOR MotionEvent#AXIS_TOOL_MAJOR} instead.
 * @apiSince 9
 * @deprecatedSince 15
 */

@Deprecated public static final int MOTION_RANGE_TOOL_MAJOR = 6; // 0x6

/**
 * Constant for retrieving the range of values for {@link android.view.MotionEvent#AXIS_TOOL_MINOR MotionEvent#AXIS_TOOL_MINOR}.
 *
 * @see #getMotionRange
 * @deprecated Use {@link android.view.MotionEvent#AXIS_TOOL_MINOR MotionEvent#AXIS_TOOL_MINOR} instead.
 * @apiSince 9
 * @deprecatedSince 15
 */

@Deprecated public static final int MOTION_RANGE_TOOL_MINOR = 7; // 0x7

/**
 * Constant for retrieving the range of values for {@link android.view.MotionEvent#AXIS_TOUCH_MAJOR MotionEvent#AXIS_TOUCH_MAJOR}.
 *
 * @see #getMotionRange
 * @deprecated Use {@link android.view.MotionEvent#AXIS_TOUCH_MAJOR MotionEvent#AXIS_TOUCH_MAJOR} instead.
 * @apiSince 9
 * @deprecatedSince 15
 */

@Deprecated public static final int MOTION_RANGE_TOUCH_MAJOR = 4; // 0x4

/**
 * Constant for retrieving the range of values for {@link android.view.MotionEvent#AXIS_TOUCH_MINOR MotionEvent#AXIS_TOUCH_MINOR}.
 *
 * @see #getMotionRange
 * @deprecated Use {@link android.view.MotionEvent#AXIS_TOUCH_MINOR MotionEvent#AXIS_TOUCH_MINOR} instead.
 * @apiSince 9
 * @deprecatedSince 15
 */

@Deprecated public static final int MOTION_RANGE_TOUCH_MINOR = 5; // 0x5

/**
 * Constant for retrieving the range of values for {@link android.view.MotionEvent#AXIS_X MotionEvent#AXIS_X}.
 *
 * @see #getMotionRange
 * @deprecated Use {@link android.view.MotionEvent#AXIS_X MotionEvent#AXIS_X} instead.
 * @apiSince 9
 * @deprecatedSince 15
 */

@Deprecated public static final int MOTION_RANGE_X = 0; // 0x0

/**
 * Constant for retrieving the range of values for {@link android.view.MotionEvent#AXIS_Y MotionEvent#AXIS_Y}.
 *
 * @see #getMotionRange
 * @deprecated Use {@link android.view.MotionEvent#AXIS_Y MotionEvent#AXIS_Y} instead.
 * @apiSince 9
 * @deprecatedSince 15
 */

@Deprecated public static final int MOTION_RANGE_Y = 1; // 0x1

/**
 * A special input source constant that is used when filtering input devices
 * to match devices that provide any type of input source.
 * @apiSince 9
 */

public static final int SOURCE_ANY = -256; // 0xffffff00

/**
 * The input device is a Bluetooth stylus.
 * <p>
 * Note that this bit merely indicates that an input device is capable of
 * obtaining input from a Bluetooth stylus.  To determine whether a given
 * touch event was produced by a stylus, examine the tool type returned by
 * {@link android.view.MotionEvent#getToolType(int) MotionEvent#getToolType(int)} for each individual pointer.
 * </p><p>
 * A single touch event may multiple pointers with different tool types,
 * such as an event that has one pointer with tool type
 * {@link android.view.MotionEvent#TOOL_TYPE_FINGER MotionEvent#TOOL_TYPE_FINGER} and another pointer with tool type
 * {@link android.view.MotionEvent#TOOL_TYPE_STYLUS MotionEvent#TOOL_TYPE_STYLUS}.  So it is important to examine
 * the tool type of each pointer, regardless of the source reported
 * by {@link android.view.MotionEvent#getSource() MotionEvent#getSource()}.
 * </p><p>
 * A bluetooth stylus generally receives its pressure and button state
 * information from the stylus itself, and derives the rest from another
 * source. For example, a Bluetooth stylus used in conjunction with a
 * touchscreen would derive its contact position and pointer size from the
 * touchscreen and may not be any more accurate than other tools such as
 * fingers.
 * </p>
 *
 * @see #SOURCE_STYLUS
 * @see #SOURCE_CLASS_POINTER
 * @apiSince 23
 */

public static final int SOURCE_BLUETOOTH_STYLUS = 49154; // 0xc002

/**
 * The input source has buttons or keys.
 * Examples: {@link #SOURCE_KEYBOARD}, {@link #SOURCE_DPAD}.
 *
 * A {@link android.view.KeyEvent KeyEvent} should be interpreted as a button or key press.
 *
 * Use {@link #getKeyCharacterMap} to query the device's button and key mappings.
 * @apiSince 9
 */

public static final int SOURCE_CLASS_BUTTON = 1; // 0x1

/**
 * The input source is a joystick.
 *
 * A {@link android.view.MotionEvent MotionEvent} should be interpreted as absolute joystick movements.
 *
 * Use {@link #getMotionRange} to query the range of positions.
 * @apiSince 12
 */

public static final int SOURCE_CLASS_JOYSTICK = 16; // 0x10

/**
 * A mask for input source classes.
 *
 * Each distinct input source constant has one or more input source class bits set to
 * specify the desired interpretation for its input events.
 * @apiSince 9
 */

public static final int SOURCE_CLASS_MASK = 255; // 0xff

/**
 * The input source has no class.
 *
 * It is up to the application to determine how to handle the device based on the device type.
 * @apiSince 18
 */

public static final int SOURCE_CLASS_NONE = 0; // 0x0

/**
 * The input source is a pointing device associated with a display.
 * Examples: {@link #SOURCE_TOUCHSCREEN}, {@link #SOURCE_MOUSE}.
 *
 * A {@link android.view.MotionEvent MotionEvent} should be interpreted as absolute coordinates in
 * display units according to the {@link android.view.View View} hierarchy.  Pointer down/up indicated when
 * the finger touches the display or when the selection button is pressed/released.
 *
 * Use {@link #getMotionRange} to query the range of the pointing device.  Some devices permit
 * touches outside the display area so the effective range may be somewhat smaller or larger
 * than the actual display size.
 * @apiSince 9
 */

public static final int SOURCE_CLASS_POINTER = 2; // 0x2

/**
 * The input source is an absolute positioning device not associated with a display
 * (unlike {@link #SOURCE_CLASS_POINTER}).
 *
 * A {@link android.view.MotionEvent MotionEvent} should be interpreted as absolute coordinates in
 * device-specific surface units.
 *
 * Use {@link #getMotionRange} to query the range of positions.
 * @apiSince 9
 */

public static final int SOURCE_CLASS_POSITION = 8; // 0x8

/**
 * The input source is a trackball navigation device.
 * Examples: {@link #SOURCE_TRACKBALL}.
 *
 * A {@link android.view.MotionEvent MotionEvent} should be interpreted as relative movements in device-specific
 * units used for navigation purposes.  Pointer down/up indicates when the selection button
 * is pressed/released.
 *
 * Use {@link #getMotionRange} to query the range of motion.
 * @apiSince 9
 */

public static final int SOURCE_CLASS_TRACKBALL = 4; // 0x4

/**
 * The input source is a DPad.
 *
 * @see #SOURCE_CLASS_BUTTON
 * @apiSince 9
 */

public static final int SOURCE_DPAD = 513; // 0x201

/**
 * The input source is a game pad.
 * (It may also be a {@link #SOURCE_JOYSTICK}).
 *
 * @see #SOURCE_CLASS_BUTTON
 * @apiSince 12
 */

public static final int SOURCE_GAMEPAD = 1025; // 0x401

/**
 * The input source is a device connected through HDMI-based bus.
 *
 * The key comes in through HDMI-CEC or MHL signal line, and is treated as if it were
 * generated by a locally connected DPAD or keyboard.
 * @apiSince 21
 */

public static final int SOURCE_HDMI = 33554433; // 0x2000001

/**
 * The input source is a joystick.
 * (It may also be a {@link #SOURCE_GAMEPAD}).
 *
 * @see #SOURCE_CLASS_JOYSTICK
 * @apiSince 12
 */

public static final int SOURCE_JOYSTICK = 16777232; // 0x1000010

/**
 * The input source is a keyboard.
 *
 * This source indicates pretty much anything that has buttons.  Use
 * {@link #getKeyboardType()} to determine whether the keyboard has alphabetic keys
 * and can be used to enter text.
 *
 * @see #SOURCE_CLASS_BUTTON
 * @apiSince 9
 */

public static final int SOURCE_KEYBOARD = 257; // 0x101

/**
 * The input source is a mouse pointing device.
 * This code is also used for other mouse-like pointing devices such as trackpads
 * and trackpoints.
 *
 * @see #SOURCE_CLASS_POINTER
 * @apiSince 9
 */

public static final int SOURCE_MOUSE = 8194; // 0x2002

/**
 * The input source is a mouse device whose relative motions should be interpreted as
 * navigation events.
 *
 * @see #SOURCE_CLASS_TRACKBALL
 * @apiSince 26
 */

public static final int SOURCE_MOUSE_RELATIVE = 131076; // 0x20004

/**
 * The input source is a rotating encoder device whose motions should be interpreted as akin to
 * those of a scroll wheel.
 *
 * @see #SOURCE_CLASS_NONE
 * @apiSince 26
 */

public static final int SOURCE_ROTARY_ENCODER = 4194304; // 0x400000

/**
 * The input source is a stylus pointing device.
 * <p>
 * Note that this bit merely indicates that an input device is capable of obtaining
 * input from a stylus.  To determine whether a given touch event was produced
 * by a stylus, examine the tool type returned by {@link android.view.MotionEvent#getToolType(int) MotionEvent#getToolType(int)}
 * for each individual pointer.
 * </p><p>
 * A single touch event may multiple pointers with different tool types,
 * such as an event that has one pointer with tool type
 * {@link android.view.MotionEvent#TOOL_TYPE_FINGER MotionEvent#TOOL_TYPE_FINGER} and another pointer with tool type
 * {@link android.view.MotionEvent#TOOL_TYPE_STYLUS MotionEvent#TOOL_TYPE_STYLUS}.  So it is important to examine
 * the tool type of each pointer, regardless of the source reported
 * by {@link android.view.MotionEvent#getSource() MotionEvent#getSource()}.
 * </p>
 *
 * @see #SOURCE_CLASS_POINTER
 * @apiSince 14
 */

public static final int SOURCE_STYLUS = 16386; // 0x4002

/**
 * The input source is a touch pad or digitizer tablet that is not
 * associated with a display (unlike {@link #SOURCE_TOUCHSCREEN}).
 *
 * @see #SOURCE_CLASS_POSITION
 * @apiSince 9
 */

public static final int SOURCE_TOUCHPAD = 1048584; // 0x100008

/**
 * The input source is a touch screen pointing device.
 *
 * @see #SOURCE_CLASS_POINTER
 * @apiSince 9
 */

public static final int SOURCE_TOUCHSCREEN = 4098; // 0x1002

/**
 * The input source is a touch device whose motions should be interpreted as navigation events.
 *
 * For example, an upward swipe should be as an upward focus traversal in the same manner as
 * pressing up on a D-Pad would be. Swipes to the left, right and down should be treated in a
 * similar manner.
 *
 * @see #SOURCE_CLASS_NONE
 * @apiSince 18
 */

public static final int SOURCE_TOUCH_NAVIGATION = 2097152; // 0x200000

/**
 * The input source is a trackball.
 *
 * @see #SOURCE_CLASS_TRACKBALL
 * @apiSince 9
 */

public static final int SOURCE_TRACKBALL = 65540; // 0x10004

/**
 * The input source is unknown.
 * @apiSince 9
 */

public static final int SOURCE_UNKNOWN = 0; // 0x0
/**
 * Provides information about the range of values for a particular {@link android.view.MotionEvent MotionEvent} axis.
 *
 * @see android.view.InputDevice#getMotionRange(int)
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class MotionRange {

private MotionRange() { throw new RuntimeException("Stub!"); }

/**
 * Gets the axis id.
 * @return The axis id.
 * @apiSince 12
 */

public int getAxis() { throw new RuntimeException("Stub!"); }

/**
 * Gets the source for which the axis is defined.
 * @return The source.
 * @apiSince 12
 */

public int getSource() { throw new RuntimeException("Stub!"); }

/**
 * Determines whether the event is from the given source.
 *
 * @param source The input source to check against. This can be a specific device type,
 * such as {@link android.view.InputDevice#SOURCE_TOUCH_NAVIGATION InputDevice#SOURCE_TOUCH_NAVIGATION}, or a more generic device class,
 * such as {@link android.view.InputDevice#SOURCE_CLASS_POINTER InputDevice#SOURCE_CLASS_POINTER}.
 * @return Whether the event is from the given source.
 * @apiSince 18
 */

public boolean isFromSource(int source) { throw new RuntimeException("Stub!"); }

/**
 * Gets the inclusive minimum value for the axis.
 * @return The inclusive minimum value.
 * @apiSince 9
 */

public float getMin() { throw new RuntimeException("Stub!"); }

/**
 * Gets the inclusive maximum value for the axis.
 * @return The inclusive maximum value.
 * @apiSince 9
 */

public float getMax() { throw new RuntimeException("Stub!"); }

/**
 * Gets the range of the axis (difference between maximum and minimum).
 * @return The range of values.
 * @apiSince 9
 */

public float getRange() { throw new RuntimeException("Stub!"); }

/**
 * Gets the extent of the center flat position with respect to this axis.
 * <p>
 * For example, a flat value of 8 means that the center position is between -8 and +8.
 * This value is mainly useful for calibrating self-centering devices.
 * </p>
 * @return The extent of the center flat position.
 * @apiSince 9
 */

public float getFlat() { throw new RuntimeException("Stub!"); }

/**
 * Gets the error tolerance for input device measurements with respect to this axis.
 * <p>
 * For example, a value of 2 indicates that the measured value may be up to +/- 2 units
 * away from the actual value due to noise and device sensitivity limitations.
 * </p>
 * @return The error tolerance.
 * @apiSince 9
 */

public float getFuzz() { throw new RuntimeException("Stub!"); }

/**
 * Gets the resolution for input device measurements with respect to this axis.
 * @return The resolution in units per millimeter, or units per radian for rotational axes.
 * @apiSince 18
 */

public float getResolution() { throw new RuntimeException("Stub!"); }
}

}

