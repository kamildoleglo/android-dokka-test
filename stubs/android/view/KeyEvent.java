/*
 * Copyright (C) 2006 The Android Open Source Project
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

import android.text.method.MetaKeyKeyListener;
import android.view.KeyCharacterMap.KeyData;
import android.os.Build;

/**
 * Object used to report key and button events.
 * <p>
 * Each key press is described by a sequence of key events.  A key press
 * starts with a key event with {@link #ACTION_DOWN}.  If the key is held
 * sufficiently long that it repeats, then the initial down is followed
 * additional key events with {@link #ACTION_DOWN} and a non-zero value for
 * {@link #getRepeatCount()}.  The last key event is a {@link #ACTION_UP}
 * for the key up.  If the key press is canceled, the key up event will have the
 * {@link #FLAG_CANCELED} flag set.
 * </p><p>
 * Key events are generally accompanied by a key code ({@link #getKeyCode()}),
 * scan code ({@link #getScanCode()}) and meta state ({@link #getMetaState()}).
 * Key code constants are defined in this class.  Scan code constants are raw
 * device-specific codes obtained from the OS and so are not generally meaningful
 * to applications unless interpreted using the {@link android.view.KeyCharacterMap KeyCharacterMap}.
 * Meta states describe the pressed state of key modifiers
 * such as {@link #META_SHIFT_ON} or {@link #META_ALT_ON}.
 * </p><p>
 * Key codes typically correspond one-to-one with individual keys on an input device.
 * Many keys and key combinations serve quite different functions on different
 * input devices so care must be taken when interpreting them.  Always use the
 * {@link android.view.KeyCharacterMap KeyCharacterMap} associated with the input device when mapping keys
 * to characters.  Be aware that there may be multiple key input devices active
 * at the same time and each will have its own key character map.
 * </p><p>
 * As soft input methods can use multiple and inventive ways of inputting text,
 * there is no guarantee that any key press on a soft keyboard will generate a key
 * event: this is left to the IME's discretion, and in fact sending such events is
 * discouraged.  You should never rely on receiving KeyEvents for any key on a soft
 * input method.  In particular, the default software keyboard will never send any
 * key event to any application targetting Jelly Bean or later, and will only send
 * events for some presses of the delete and return keys to applications targetting
 * Ice Cream Sandwich or earlier.  Be aware that other software input methods may
 * never send key events regardless of the version.  Consider using editor actions
 * like {@link android.view.inputmethod.EditorInfo#IME_ACTION_DONE} if you need
 * specific interaction with the software keyboard, as it gives more visibility to
 * the user as to how your application will react to key presses.
 * </p><p>
 * When interacting with an IME, the framework may deliver key events
 * with the special action {@link #ACTION_MULTIPLE} that either specifies
 * that single repeated key code or a sequence of characters to insert.
 * </p><p>
 * In general, the framework cannot guarantee that the key events it delivers
 * to a view always constitute complete key sequences since some events may be dropped
 * or modified by containing views before they are delivered.  The view implementation
 * should be prepared to handle {@link #FLAG_CANCELED} and should tolerate anomalous
 * situations such as receiving a new {@link #ACTION_DOWN} without first having
 * received an {@link #ACTION_UP} for the prior key press.
 * </p><p>
 * Refer to {@link android.view.InputDevice InputDevice} for more information about how different kinds of
 * input devices and sources represent keys and buttons.
 * </p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class KeyEvent extends android.view.InputEvent implements android.os.Parcelable {

/**
 * Create a new key event.
 *
 * @param action Action code: either {@link #ACTION_DOWN},
 * {@link #ACTION_UP}, or {@link #ACTION_MULTIPLE}.
 * @param code The key code.
 * @apiSince 1
 */

public KeyEvent(int action, int code) { throw new RuntimeException("Stub!"); }

/**
 * Create a new key event.
 *
 * @param downTime The time (in {@link android.os.SystemClock#uptimeMillis})
 * at which this key code originally went down.
 * @param eventTime The time (in {@link android.os.SystemClock#uptimeMillis})
 * at which this event happened.
 * @param action Action code: either {@link #ACTION_DOWN},
 * {@link #ACTION_UP}, or {@link #ACTION_MULTIPLE}.
 * @param code The key code.
 * @param repeat A repeat count for down events (> 0 if this is after the
 * initial down) or event count for multiple events.
 * @apiSince 1
 */

public KeyEvent(long downTime, long eventTime, int action, int code, int repeat) { throw new RuntimeException("Stub!"); }

/**
 * Create a new key event.
 *
 * @param downTime The time (in {@link android.os.SystemClock#uptimeMillis})
 * at which this key code originally went down.
 * @param eventTime The time (in {@link android.os.SystemClock#uptimeMillis})
 * at which this event happened.
 * @param action Action code: either {@link #ACTION_DOWN},
 * {@link #ACTION_UP}, or {@link #ACTION_MULTIPLE}.
 * @param code The key code.
 * @param repeat A repeat count for down events (> 0 if this is after the
 * initial down) or event count for multiple events.
 * @param metaState Flags indicating which meta keys are currently pressed.
 * @apiSince 1
 */

public KeyEvent(long downTime, long eventTime, int action, int code, int repeat, int metaState) { throw new RuntimeException("Stub!"); }

/**
 * Create a new key event.
 *
 * @param downTime The time (in {@link android.os.SystemClock#uptimeMillis})
 * at which this key code originally went down.
 * @param eventTime The time (in {@link android.os.SystemClock#uptimeMillis})
 * at which this event happened.
 * @param action Action code: either {@link #ACTION_DOWN},
 * {@link #ACTION_UP}, or {@link #ACTION_MULTIPLE}.
 * @param code The key code.
 * @param repeat A repeat count for down events (> 0 if this is after the
 * initial down) or event count for multiple events.
 * @param metaState Flags indicating which meta keys are currently pressed.
 * @param deviceId The device ID that generated the key event.
 * @param scancode Raw device scan code of the event.
 * @apiSince 1
 */

public KeyEvent(long downTime, long eventTime, int action, int code, int repeat, int metaState, int deviceId, int scancode) { throw new RuntimeException("Stub!"); }

/**
 * Create a new key event.
 *
 * @param downTime The time (in {@link android.os.SystemClock#uptimeMillis})
 * at which this key code originally went down.
 * @param eventTime The time (in {@link android.os.SystemClock#uptimeMillis})
 * at which this event happened.
 * @param action Action code: either {@link #ACTION_DOWN},
 * {@link #ACTION_UP}, or {@link #ACTION_MULTIPLE}.
 * @param code The key code.
 * @param repeat A repeat count for down events (> 0 if this is after the
 * initial down) or event count for multiple events.
 * @param metaState Flags indicating which meta keys are currently pressed.
 * @param deviceId The device ID that generated the key event.
 * @param scancode Raw device scan code of the event.
 * @param flags The flags for this key event
 * @apiSince 1
 */

public KeyEvent(long downTime, long eventTime, int action, int code, int repeat, int metaState, int deviceId, int scancode, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Create a new key event.
 *
 * @param downTime The time (in {@link android.os.SystemClock#uptimeMillis})
 * at which this key code originally went down.
 * @param eventTime The time (in {@link android.os.SystemClock#uptimeMillis})
 * at which this event happened.
 * @param action Action code: either {@link #ACTION_DOWN},
 * {@link #ACTION_UP}, or {@link #ACTION_MULTIPLE}.
 * @param code The key code.
 * @param repeat A repeat count for down events (> 0 if this is after the
 * initial down) or event count for multiple events.
 * @param metaState Flags indicating which meta keys are currently pressed.
 * @param deviceId The device ID that generated the key event.
 * @param scancode Raw device scan code of the event.
 * @param flags The flags for this key event
 * @param source The input source such as {@link android.view.InputDevice#SOURCE_KEYBOARD InputDevice#SOURCE_KEYBOARD}.
 * @apiSince 9
 */

public KeyEvent(long downTime, long eventTime, int action, int code, int repeat, int metaState, int deviceId, int scancode, int flags, int source) { throw new RuntimeException("Stub!"); }

/**
 * Create a new key event for a string of characters.  The key code,
 * action, repeat count and source will automatically be set to
 * {@link #KEYCODE_UNKNOWN}, {@link #ACTION_MULTIPLE}, 0, and
 * {@link android.view.InputDevice#SOURCE_KEYBOARD InputDevice#SOURCE_KEYBOARD} for you.
 *
 * @param time The time (in {@link android.os.SystemClock#uptimeMillis})
 * at which this event occured.
 * @param characters The string of characters.
 * @param deviceId The device ID that generated the key event.
 * @param flags The flags for this key event
 * @apiSince 3
 */

public KeyEvent(long time, java.lang.String characters, int deviceId, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Make an exact copy of an existing key event.
 * @apiSince 3
 */

public KeyEvent(android.view.KeyEvent origEvent) { throw new RuntimeException("Stub!"); }

/**
 * Copy an existing key event, modifying its time and repeat count.
 *
 * @deprecated Use {@link #changeTimeRepeat(android.view.KeyEvent,long,int)}
 * instead.
 *
 * @param origEvent The existing event to be copied.
 * @param eventTime The new event time
 * (in {@link android.os.SystemClock#uptimeMillis}) of the event.
 * @param newRepeat The new repeat count of the event.
 * @apiSince 1
 */

@Deprecated
public KeyEvent(android.view.KeyEvent origEvent, long eventTime, int newRepeat) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum keycode.
 * @apiSince 3
 */

public static int getMaxKeyCode() { throw new RuntimeException("Stub!"); }

/**
 * Get the character that is produced by putting accent on the character
 * c.
 * For example, getDeadChar('`', 'e') returns &egrave;.
 * @apiSince 1
 */

public static int getDeadChar(int accent, int c) { throw new RuntimeException("Stub!"); }

/**
 * Create a new key event that is the same as the given one, but whose
 * event time and repeat count are replaced with the given value.
 *
 * @param event The existing event to be copied.  This is not modified.
 * @param eventTime The new event time
 * (in {@link android.os.SystemClock#uptimeMillis}) of the event.
 * @param newRepeat The new repeat count of the event.
 * @apiSince 3
 */

public static android.view.KeyEvent changeTimeRepeat(android.view.KeyEvent event, long eventTime, int newRepeat) { throw new RuntimeException("Stub!"); }

/**
 * Create a new key event that is the same as the given one, but whose
 * event time and repeat count are replaced with the given value.
 *
 * @param event The existing event to be copied.  This is not modified.
 * @param eventTime The new event time
 * (in {@link android.os.SystemClock#uptimeMillis}) of the event.
 * @param newRepeat The new repeat count of the event.
 * @param newFlags New flags for the event, replacing the entire value
 * in the original event.
 * @apiSince 5
 */

public static android.view.KeyEvent changeTimeRepeat(android.view.KeyEvent event, long eventTime, int newRepeat, int newFlags) { throw new RuntimeException("Stub!"); }

/**
 * Create a new key event that is the same as the given one, but whose
 * action is replaced with the given value.
 *
 * @param event The existing event to be copied.  This is not modified.
 * @param action The new action code of the event.
 * @apiSince 3
 */

public static android.view.KeyEvent changeAction(android.view.KeyEvent event, int action) { throw new RuntimeException("Stub!"); }

/**
 * Create a new key event that is the same as the given one, but whose
 * flags are replaced with the given value.
 *
 * @param event The existing event to be copied.  This is not modified.
 * @param flags The new flags constant.
 * @apiSince 3
 */

public static android.view.KeyEvent changeFlags(android.view.KeyEvent event, int flags) { throw new RuntimeException("Stub!"); }

/** Is this a system key?  System keys can not be used for menu shortcuts.
 @apiSince 1
 */

public final boolean isSystem() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the specified keycode is a gamepad button.
 * @return True if the keycode is a gamepad button, such as {@link #KEYCODE_BUTTON_A}.
 * @apiSince 12
 */

public static final boolean isGamepadButton(int keyCode) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public final int getDeviceId() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 9
 */

public final int getSource() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 12
 */

public final void setSource(int source) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the state of the meta keys.</p>
 *
 * @return an integer in which each bit set to 1 represents a pressed
 *         meta key
 *
 * @see #isAltPressed()
 * @see #isShiftPressed()
 * @see #isSymPressed()
 * @see #isCtrlPressed()
 * @see #isMetaPressed()
 * @see #isFunctionPressed()
 * @see #isCapsLockOn()
 * @see #isNumLockOn()
 * @see #isScrollLockOn()
 * @see #META_ALT_ON
 * @see #META_ALT_LEFT_ON
 * @see #META_ALT_RIGHT_ON
 * @see #META_SHIFT_ON
 * @see #META_SHIFT_LEFT_ON
 * @see #META_SHIFT_RIGHT_ON
 * @see #META_SYM_ON
 * @see #META_FUNCTION_ON
 * @see #META_CTRL_ON
 * @see #META_CTRL_LEFT_ON
 * @see #META_CTRL_RIGHT_ON
 * @see #META_META_ON
 * @see #META_META_LEFT_ON
 * @see #META_META_RIGHT_ON
 * @see #META_CAPS_LOCK_ON
 * @see #META_NUM_LOCK_ON
 * @see #META_SCROLL_LOCK_ON
 * @see #getModifiers
 * @apiSince 1
 */

public final int getMetaState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the state of the modifier keys.
 * <p>
 * For the purposes of this function, {@link #KEYCODE_CAPS_LOCK},
 * {@link #KEYCODE_SCROLL_LOCK}, and {@link #KEYCODE_NUM_LOCK} are
 * not considered modifier keys.  Consequently, this function specifically masks out
 * {@link #META_CAPS_LOCK_ON}, {@link #META_SCROLL_LOCK_ON} and {@link #META_NUM_LOCK_ON}.
 * </p><p>
 * The value returned consists of the meta state (from {@link #getMetaState})
 * normalized using {@link #normalizeMetaState(int)} and then masked with
 * {@link #getModifierMetaStateMask} so that only valid modifier bits are retained.
 * </p>
 *
 * @return An integer in which each bit set to 1 represents a pressed modifier key.
 * @see #getMetaState
 * @apiSince 13
 */

public final int getModifiers() { throw new RuntimeException("Stub!"); }

/**
 * Returns the flags for this key event.
 *
 * @see #FLAG_WOKE_HERE
 * @apiSince 1
 */

public final int getFlags() { throw new RuntimeException("Stub!"); }

/**
 * Gets a mask that includes all valid modifier key meta state bits.
 * <p>
 * For the purposes of this function, {@link #KEYCODE_CAPS_LOCK},
 * {@link #KEYCODE_SCROLL_LOCK}, and {@link #KEYCODE_NUM_LOCK} are
 * not considered modifier keys.  Consequently, the mask specifically excludes
 * {@link #META_CAPS_LOCK_ON}, {@link #META_SCROLL_LOCK_ON} and {@link #META_NUM_LOCK_ON}.
 * </p>
 *
 * @return The modifier meta state mask which is a combination of
 * {@link #META_SHIFT_ON}, {@link #META_SHIFT_LEFT_ON}, {@link #META_SHIFT_RIGHT_ON},
 * {@link #META_ALT_ON}, {@link #META_ALT_LEFT_ON}, {@link #META_ALT_RIGHT_ON},
 * {@link #META_CTRL_ON}, {@link #META_CTRL_LEFT_ON}, {@link #META_CTRL_RIGHT_ON},
 * {@link #META_META_ON}, {@link #META_META_LEFT_ON}, {@link #META_META_RIGHT_ON},
 * {@link #META_SYM_ON}, {@link #META_FUNCTION_ON}.
 * @apiSince 11
 */

public static int getModifierMetaStateMask() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this key code is a modifier key.
 * <p>
 * For the purposes of this function, {@link #KEYCODE_CAPS_LOCK},
 * {@link #KEYCODE_SCROLL_LOCK}, and {@link #KEYCODE_NUM_LOCK} are
 * not considered modifier keys.  Consequently, this function return false
 * for those keys.
 * </p>
 *
 * @return True if the key code is one of
 * {@link #KEYCODE_SHIFT_LEFT} {@link #KEYCODE_SHIFT_RIGHT},
 * {@link #KEYCODE_ALT_LEFT}, {@link #KEYCODE_ALT_RIGHT},
 * {@link #KEYCODE_CTRL_LEFT}, {@link #KEYCODE_CTRL_RIGHT},
 * {@link #KEYCODE_META_LEFT}, or {@link #KEYCODE_META_RIGHT},
 * {@link #KEYCODE_SYM}, {@link #KEYCODE_NUM}, {@link #KEYCODE_FUNCTION}.
 * @apiSince 1
 */

public static boolean isModifierKey(int keyCode) { throw new RuntimeException("Stub!"); }

/**
 * Normalizes the specified meta state.
 * <p>
 * The meta state is normalized such that if either the left or right modifier meta state
 * bits are set then the result will also include the universal bit for that modifier.
 * </p><p>
 * If the specified meta state contains {@link #META_ALT_LEFT_ON} then
 * the result will also contain {@link #META_ALT_ON} in addition to {@link #META_ALT_LEFT_ON}
 * and the other bits that were specified in the input.  The same is process is
 * performed for shift, control and meta.
 * </p><p>
 * If the specified meta state contains synthetic meta states defined by
 * {@link android.text.method.MetaKeyKeyListener MetaKeyKeyListener}, then those states are translated here and the original
 * synthetic meta states are removed from the result.
 * {@link android.text.method.MetaKeyKeyListener#META_CAP_LOCKED MetaKeyKeyListener#META_CAP_LOCKED} is translated to {@link #META_CAPS_LOCK_ON}.
 * {@link android.text.method.MetaKeyKeyListener#META_ALT_LOCKED MetaKeyKeyListener#META_ALT_LOCKED} is translated to {@link #META_ALT_ON}.
 * {@link android.text.method.MetaKeyKeyListener#META_SYM_LOCKED MetaKeyKeyListener#META_SYM_LOCKED} is translated to {@link #META_SYM_ON}.
 * </p><p>
 * Undefined meta state bits are removed.
 * </p>
 *
 * @param metaState The meta state.
 * @return The normalized meta state.
 * @apiSince 11
 */

public static int normalizeMetaState(int metaState) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if no modifiers keys are pressed according to the specified meta state.
 * <p>
 * For the purposes of this function, {@link #KEYCODE_CAPS_LOCK},
 * {@link #KEYCODE_SCROLL_LOCK}, and {@link #KEYCODE_NUM_LOCK} are
 * not considered modifier keys.  Consequently, this function ignores
 * {@link #META_CAPS_LOCK_ON}, {@link #META_SCROLL_LOCK_ON} and {@link #META_NUM_LOCK_ON}.
 * </p><p>
 * The meta state is normalized prior to comparison using {@link #normalizeMetaState(int)}.
 * </p>
 *
 * @param metaState The meta state to consider.
 * @return True if no modifier keys are pressed.
 * @see #hasNoModifiers()
 * @apiSince 11
 */

public static boolean metaStateHasNoModifiers(int metaState) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if only the specified modifier keys are pressed according to
 * the specified meta state.  Returns false if a different combination of modifier
 * keys are pressed.
 * <p>
 * For the purposes of this function, {@link #KEYCODE_CAPS_LOCK},
 * {@link #KEYCODE_SCROLL_LOCK}, and {@link #KEYCODE_NUM_LOCK} are
 * not considered modifier keys.  Consequently, this function ignores
 * {@link #META_CAPS_LOCK_ON}, {@link #META_SCROLL_LOCK_ON} and {@link #META_NUM_LOCK_ON}.
 * </p><p>
 * If the specified modifier mask includes directional modifiers, such as
 * {@link #META_SHIFT_LEFT_ON}, then this method ensures that the
 * modifier is pressed on that side.
 * If the specified modifier mask includes non-directional modifiers, such as
 * {@link #META_SHIFT_ON}, then this method ensures that the modifier
 * is pressed on either side.
 * If the specified modifier mask includes both directional and non-directional modifiers
 * for the same type of key, such as {@link #META_SHIFT_ON} and {@link #META_SHIFT_LEFT_ON},
 * then this method throws an illegal argument exception.
 * </p>
 *
 * @param metaState The meta state to consider.
 * @param modifiers The meta state of the modifier keys to check.  May be a combination
 * of modifier meta states as defined by {@link #getModifierMetaStateMask()}.  May be 0 to
 * ensure that no modifier keys are pressed.
 * @return True if only the specified modifier keys are pressed.
 * @throws java.lang.IllegalArgumentException if the modifiers parameter contains invalid modifiers
 * @see #hasModifiers
 * @apiSince 11
 */

public static boolean metaStateHasModifiers(int metaState, int modifiers) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if no modifier keys are pressed.
 * <p>
 * For the purposes of this function, {@link #KEYCODE_CAPS_LOCK},
 * {@link #KEYCODE_SCROLL_LOCK}, and {@link #KEYCODE_NUM_LOCK} are
 * not considered modifier keys.  Consequently, this function ignores
 * {@link #META_CAPS_LOCK_ON}, {@link #META_SCROLL_LOCK_ON} and {@link #META_NUM_LOCK_ON}.
 * </p><p>
 * The meta state is normalized prior to comparison using {@link #normalizeMetaState(int)}.
 * </p>
 *
 * @return True if no modifier keys are pressed.
 * @see #metaStateHasNoModifiers
 * @apiSince 11
 */

public final boolean hasNoModifiers() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if only the specified modifiers keys are pressed.
 * Returns false if a different combination of modifier keys are pressed.
 * <p>
 * For the purposes of this function, {@link #KEYCODE_CAPS_LOCK},
 * {@link #KEYCODE_SCROLL_LOCK}, and {@link #KEYCODE_NUM_LOCK} are
 * not considered modifier keys.  Consequently, this function ignores
 * {@link #META_CAPS_LOCK_ON}, {@link #META_SCROLL_LOCK_ON} and {@link #META_NUM_LOCK_ON}.
 * </p><p>
 * If the specified modifier mask includes directional modifiers, such as
 * {@link #META_SHIFT_LEFT_ON}, then this method ensures that the
 * modifier is pressed on that side.
 * If the specified modifier mask includes non-directional modifiers, such as
 * {@link #META_SHIFT_ON}, then this method ensures that the modifier
 * is pressed on either side.
 * If the specified modifier mask includes both directional and non-directional modifiers
 * for the same type of key, such as {@link #META_SHIFT_ON} and {@link #META_SHIFT_LEFT_ON},
 * then this method throws an illegal argument exception.
 * </p>
 *
 * @param modifiers The meta state of the modifier keys to check.  May be a combination
 * of modifier meta states as defined by {@link #getModifierMetaStateMask()}.  May be 0 to
 * ensure that no modifier keys are pressed.
 * @return True if only the specified modifier keys are pressed.
 * @throws java.lang.IllegalArgumentException if the modifiers parameter contains invalid modifiers
 * @see #metaStateHasModifiers
 * @apiSince 11
 */

public final boolean hasModifiers(int modifiers) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the pressed state of the ALT meta key.</p>
 *
 * @return true if the ALT key is pressed, false otherwise
 *
 * @see #KEYCODE_ALT_LEFT
 * @see #KEYCODE_ALT_RIGHT
 * @see #META_ALT_ON
 * @apiSince 1
 */

public final boolean isAltPressed() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the pressed state of the SHIFT meta key.</p>
 *
 * @return true if the SHIFT key is pressed, false otherwise
 *
 * @see #KEYCODE_SHIFT_LEFT
 * @see #KEYCODE_SHIFT_RIGHT
 * @see #META_SHIFT_ON
 * @apiSince 1
 */

public final boolean isShiftPressed() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the pressed state of the SYM meta key.</p>
 *
 * @return true if the SYM key is pressed, false otherwise
 *
 * @see #KEYCODE_SYM
 * @see #META_SYM_ON
 * @apiSince 1
 */

public final boolean isSymPressed() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the pressed state of the CTRL meta key.</p>
 *
 * @return true if the CTRL key is pressed, false otherwise
 *
 * @see #KEYCODE_CTRL_LEFT
 * @see #KEYCODE_CTRL_RIGHT
 * @see #META_CTRL_ON
 * @apiSince 11
 */

public final boolean isCtrlPressed() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the pressed state of the META meta key.</p>
 *
 * @return true if the META key is pressed, false otherwise
 *
 * @see #KEYCODE_META_LEFT
 * @see #KEYCODE_META_RIGHT
 * @see #META_META_ON
 * @apiSince 11
 */

public final boolean isMetaPressed() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the pressed state of the FUNCTION meta key.</p>
 *
 * @return true if the FUNCTION key is pressed, false otherwise
 *
 * @see #KEYCODE_FUNCTION
 * @see #META_FUNCTION_ON
 * @apiSince 11
 */

public final boolean isFunctionPressed() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the locked state of the CAPS LOCK meta key.</p>
 *
 * @return true if the CAPS LOCK key is on, false otherwise
 *
 * @see #KEYCODE_CAPS_LOCK
 * @see #META_CAPS_LOCK_ON
 * @apiSince 11
 */

public final boolean isCapsLockOn() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the locked state of the NUM LOCK meta key.</p>
 *
 * @return true if the NUM LOCK key is on, false otherwise
 *
 * @see #KEYCODE_NUM_LOCK
 * @see #META_NUM_LOCK_ON
 * @apiSince 11
 */

public final boolean isNumLockOn() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the locked state of the SCROLL LOCK meta key.</p>
 *
 * @return true if the SCROLL LOCK key is on, false otherwise
 *
 * @see #KEYCODE_SCROLL_LOCK
 * @see #META_SCROLL_LOCK_ON
 * @apiSince 11
 */

public final boolean isScrollLockOn() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the action of this key event.  May be either
 * {@link #ACTION_DOWN}, {@link #ACTION_UP}, or {@link #ACTION_MULTIPLE}.
 *
 * @return The event action: ACTION_DOWN, ACTION_UP, or ACTION_MULTIPLE.
 * @apiSince 1
 */

public final int getAction() { throw new RuntimeException("Stub!"); }

/**
 * For {@link #ACTION_UP} events, indicates that the event has been
 * canceled as per {@link #FLAG_CANCELED}.
 * @apiSince 5
 */

public final boolean isCanceled() { throw new RuntimeException("Stub!"); }

/**
 * Call this during {@link android.view.KeyEvent.Callback#onKeyDown Callback#onKeyDown} to have the system track
 * the key through its final up (possibly including a long press).  Note
 * that only one key can be tracked at a time -- if another key down
 * event is received while a previous one is being tracked, tracking is
 * stopped on the previous event.
 * @apiSince 5
 */

public final void startTracking() { throw new RuntimeException("Stub!"); }

/**
 * For {@link #ACTION_UP} events, indicates that the event is still being
 * tracked from its initial down event as per
 * {@link #FLAG_TRACKING}.
 * @apiSince 5
 */

public final boolean isTracking() { throw new RuntimeException("Stub!"); }

/**
 * For {@link #ACTION_DOWN} events, indicates that the event has been
 * canceled as per {@link #FLAG_LONG_PRESS}.
 * @apiSince 5
 */

public final boolean isLongPress() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the key code of the key event.  This is the physical key that
 * was pressed, <em>not</em> the Unicode character.
 *
 * @return The key code of the event.
 * @apiSince 1
 */

public final int getKeyCode() { throw new RuntimeException("Stub!"); }

/**
 * For the special case of a {@link #ACTION_MULTIPLE} event with key
 * code of {@link #KEYCODE_UNKNOWN}, this is a raw string of characters
 * associated with the event.  In all other cases it is null.
 *
 * @return Returns a String of 1 or more characters associated with
 * the event.
 *
 * @deprecated no longer used by the input system.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public final java.lang.String getCharacters() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the hardware key id of this key event.  These values are not
 * reliable and vary from device to device.
 *
 * {@more}
 * Mostly this is here for debugging purposes.
 * @apiSince 1
 */

public final int getScanCode() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the repeat count of the event.  For key down events,
 * this is the number of times the key has repeated with the first
 * down starting at 0 and counting up from there.  For key up events,
 * this is always equal to zero. For multiple key events,
 * this is the number of down/up pairs that have occurred.
 *
 * @return The number of times the key has repeated.
 * @apiSince 1
 */

public final int getRepeatCount() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the time of the most recent key down event,
 * in the {@link android.os.SystemClock#uptimeMillis} time base.  If this
 * is a down event, this will be the same as {@link #getEventTime()}.
 * Note that when chording keys, this value is the down time of the
 * most recently pressed key, which may <em>not</em> be the same physical
 * key of this event.
 *
 * @return Returns the most recent key down time, in the
 * {@link android.os.SystemClock#uptimeMillis} time base
 * @apiSince 1
 */

public final long getDownTime() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the time this event occurred,
 * in the {@link android.os.SystemClock#uptimeMillis} time base.
 *
 * @return Returns the time this event occurred,
 * in the {@link android.os.SystemClock#uptimeMillis} time base.
 * @apiSince 1
 */

public final long getEventTime() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.view.KeyCharacterMap KeyCharacterMap} associated with the keyboard device.
 *
 * @return The associated key character map.
 * @throws {@link android.view.KeyCharacterMap.UnavailableException KeyCharacterMap.UnavailableException} if the key character map
 * could not be loaded because it was malformed or the default key character map
 * is missing from the system.
 *
 * @see android.view.KeyCharacterMap#load
 * @apiSince 11
 */

public final android.view.KeyCharacterMap getKeyCharacterMap() { throw new RuntimeException("Stub!"); }

/**
 * Gets the primary character for this key.
 * In other words, the label that is physically printed on it.
 *
 * @return The display label character, or 0 if none (eg. for non-printing keys).
 * @apiSince 1
 */

public char getDisplayLabel() { throw new RuntimeException("Stub!"); }

/**
 * Gets the Unicode character generated by the specified key and meta
 * key state combination.
 * <p>
 * Returns the Unicode character that the specified key would produce
 * when the specified meta bits (see {@link android.text.method.MetaKeyKeyListener MetaKeyKeyListener})
 * were active.
 * </p><p>
 * Returns 0 if the key is not one that is used to type Unicode
 * characters.
 * </p><p>
 * If the return value has bit {@link android.view.KeyCharacterMap#COMBINING_ACCENT KeyCharacterMap#COMBINING_ACCENT} set, the
 * key is a "dead key" that should be combined with another to
 * actually produce a character -- see {@link android.view.KeyCharacterMap#getDeadChar KeyCharacterMap#getDeadChar} --
 * after masking with {@link android.view.KeyCharacterMap#COMBINING_ACCENT_MASK KeyCharacterMap#COMBINING_ACCENT_MASK}.
 * </p>
 *
 * @return The associated character or combining accent, or 0 if none.
 * @apiSince 1
 */

public int getUnicodeChar() { throw new RuntimeException("Stub!"); }

/**
 * Gets the Unicode character generated by the specified key and meta
 * key state combination.
 * <p>
 * Returns the Unicode character that the specified key would produce
 * when the specified meta bits (see {@link android.text.method.MetaKeyKeyListener MetaKeyKeyListener})
 * were active.
 * </p><p>
 * Returns 0 if the key is not one that is used to type Unicode
 * characters.
 * </p><p>
 * If the return value has bit {@link android.view.KeyCharacterMap#COMBINING_ACCENT KeyCharacterMap#COMBINING_ACCENT} set, the
 * key is a "dead key" that should be combined with another to
 * actually produce a character -- see {@link android.view.KeyCharacterMap#getDeadChar KeyCharacterMap#getDeadChar} --
 * after masking with {@link android.view.KeyCharacterMap#COMBINING_ACCENT_MASK KeyCharacterMap#COMBINING_ACCENT_MASK}.
 * </p>
 *
 * @param metaState The meta key modifier state.
 * @return The associated character or combining accent, or 0 if none.
 * @apiSince 1
 */

public int getUnicodeChar(int metaState) { throw new RuntimeException("Stub!"); }

/**
 * Get the character conversion data for a given key code.
 *
 * @param results A {@link android.view.KeyCharacterMap.KeyData KeyCharacterMap.KeyData} instance that will be
 * filled with the results.
 * @return True if the key was mapped.  If the key was not mapped, results is not modified.
 *
 * @deprecated instead use {@link #getDisplayLabel()},
 * {@link #getNumber()} or {@link #getUnicodeChar(int)}.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public boolean getKeyData(android.view.KeyCharacterMap.KeyData results) { throw new RuntimeException("Stub!"); }

/**
 * Gets the first character in the character array that can be generated
 * by the specified key code.
 * <p>
 * This is a convenience function that returns the same value as
 * {@link #getMatch(char[],int) getMatch(chars, 0)}.
 * </p>
 *
 * @param chars The array of matching characters to consider.
 * @return The matching associated character, or 0 if none.
 * @apiSince 1
 */

public char getMatch(char[] chars) { throw new RuntimeException("Stub!"); }

/**
 * Gets the first character in the character array that can be generated
 * by the specified key code.  If there are multiple choices, prefers
 * the one that would be generated with the specified meta key modifier state.
 *
 * @param chars The array of matching characters to consider.
 * @param metaState The preferred meta key modifier state.
 * @return The matching associated character, or 0 if none.
 * @apiSince 1
 */

public char getMatch(char[] chars, int metaState) { throw new RuntimeException("Stub!"); }

/**
 * Gets the number or symbol associated with the key.
 * <p>
 * The character value is returned, not the numeric value.
 * If the key is not a number, but is a symbol, the symbol is retuned.
 * </p><p>
 * This method is intended to to support dial pads and other numeric or
 * symbolic entry on keyboards where certain keys serve dual function
 * as alphabetic and symbolic keys.  This method returns the number
 * or symbol associated with the key independent of whether the user
 * has pressed the required modifier.
 * </p><p>
 * For example, on one particular keyboard the keys on the top QWERTY row generate
 * numbers when ALT is pressed such that ALT-Q maps to '1'.  So for that keyboard
 * when {@link #getNumber} is called with {@link android.view.KeyEvent#KEYCODE_Q KeyEvent#KEYCODE_Q} it returns '1'
 * so that the user can type numbers without pressing ALT when it makes sense.
 * </p>
 *
 * @return The associated numeric or symbolic character, or 0 if none.
 * @apiSince 1
 */

public char getNumber() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this key produces a glyph.
 *
 * @return True if the key is a printing key.
 * @apiSince 1
 */

public boolean isPrintingKey() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #dispatch(android.view.KeyEvent.Callback,android.view.KeyEvent.DispatcherState,java.lang.Object)} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public final boolean dispatch(android.view.KeyEvent.Callback receiver) { throw new RuntimeException("Stub!"); }

/**
 * Deliver this key event to a {@link android.view.KeyEvent.Callback Callback} interface.  If this is
 * an ACTION_MULTIPLE event and it is not handled, then an attempt will
 * be made to deliver a single normal event.
 *
 * @param receiver The Callback that will be given the event.
 * @param state State information retained across events.
 * @param target The target of the dispatch, for use in tracking.
 *
 * @return The return value from the Callback method that was called.
 * @apiSince 5
 */

public final boolean dispatch(android.view.KeyEvent.Callback receiver, android.view.KeyEvent.DispatcherState state, java.lang.Object target) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string that represents the symbolic name of the specified keycode
 * such as "KEYCODE_A", "KEYCODE_DPAD_UP", or an equivalent numeric constant
 * such as "1001" if unknown.
 *
 * This function is intended to be used mostly for debugging, logging, and testing. It is not
 * locale-specific and is not intended to be used in a user-facing manner.
 *
 * @param keyCode The key code.
 * @return The symbolic name of the specified keycode.
 *
 * @see android.view.KeyCharacterMap#getDisplayLabel
 * @apiSince 12
 */

public static java.lang.String keyCodeToString(int keyCode) { throw new RuntimeException("Stub!"); }

/**
 * Gets a keycode by its symbolic name such as "KEYCODE_A" or an equivalent
 * numeric constant such as "29". For symbolic names,
 * starting in {@link android.os.Build.VERSION_CODES#Q} the prefix "KEYCODE_" is optional.
 *
 * @param symbolicName The symbolic name of the keycode.
 * This value must never be {@code null}.
 * @return The keycode or {@link #KEYCODE_UNKNOWN} if not found.
 * @see #keyCodeToString(int)
 * @apiSince 12
 */

public static int keyCodeFromString(@androidx.annotation.NonNull java.lang.String symbolicName) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * {@link #getAction} value: the key has been pressed down.
 * @apiSince 1
 */

public static final int ACTION_DOWN = 0; // 0x0

/**
 * @deprecated No longer used by the input system.
 * {@link #getAction} value: multiple duplicate key events have
 * occurred in a row, or a complex string is being delivered.  If the
 * key code is not {@link #KEYCODE_UNKNOWN} then the
 * {@link #getRepeatCount()} method returns the number of times
 * the given key code should be executed.
 * Otherwise, if the key code is {@link #KEYCODE_UNKNOWN}, then
 * this is a sequence of characters as returned by {@link #getCharacters}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int ACTION_MULTIPLE = 2; // 0x2

/**
 * {@link #getAction} value: the key has been released.
 * @apiSince 1
 */

public static final int ACTION_UP = 1; // 0x1

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.KeyEvent> CREATOR;
static { CREATOR = null; }

/**
 * When associated with up key events, this indicates that the key press
 * has been canceled.  Typically this is used with virtual touch screen
 * keys, where the user can slide from the virtual key area on to the
 * display: in that case, the application will receive a canceled up
 * event and should not perform the action normally associated with the
 * key.  Note that for this to work, the application can not perform an
 * action for a key until it receives an up or the long press timeout has
 * expired.
 * @apiSince 5
 */

public static final int FLAG_CANCELED = 32; // 0x20

/**
 * Set when a key event has {@link #FLAG_CANCELED} set because a long
 * press action was executed while it was down.
 * @apiSince 5
 */

public static final int FLAG_CANCELED_LONG_PRESS = 256; // 0x100

/**
 * This mask is used for compatibility, to identify enter keys that are
 * coming from an IME whose enter key has been auto-labelled "next" or
 * "done".  This allows TextView to dispatch these as normal enter keys
 * for old applications, but still do the appropriate action when
 * receiving them.
 * @apiSince 3
 */

public static final int FLAG_EDITOR_ACTION = 16; // 0x10

/**
 * Set when a key event has been synthesized to implement default behavior
 * for an event that the application did not handle.
 * Fallback key events are generated by unhandled trackball motions
 * (to emulate a directional keypad) and by certain unhandled key presses
 * that are declared in the key map (such as special function numeric keypad
 * keys when numlock is off).
 * @apiSince 11
 */

public static final int FLAG_FALLBACK = 1024; // 0x400

/**
 * This mask is set if an event was known to come from a trusted part
 * of the system.  That is, the event is known to come from the user,
 * and could not have been spoofed by a third party component.
 * @apiSince 3
 */

public static final int FLAG_FROM_SYSTEM = 8; // 0x8

/**
 * This mask is set if we don't want the key event to cause us to leave
 * touch mode.
 * @apiSince 3
 */

public static final int FLAG_KEEP_TOUCH_MODE = 4; // 0x4

/**
 * This flag is set for the first key repeat that occurs after the
 * long press timeout.
 * @apiSince 5
 */

public static final int FLAG_LONG_PRESS = 128; // 0x80

/**
 * This mask is set if the key event was generated by a software keyboard.
 * @apiSince 3
 */

public static final int FLAG_SOFT_KEYBOARD = 2; // 0x2

/**
 * Set for {@link #ACTION_UP} when this event's key code is still being
 * tracked from its initial down.  That is, somebody requested that tracking
 * started on the key down and a long press has not caused
 * the tracking to be canceled.
 * @apiSince 5
 */

public static final int FLAG_TRACKING = 512; // 0x200

/**
 * This key event was generated by a virtual (on-screen) hard key area.
 * Typically this is an area of the touchscreen, outside of the regular
 * display, dedicated to "hardware" buttons.
 * @apiSince 5
 */

public static final int FLAG_VIRTUAL_HARD_KEY = 64; // 0x40

/**
 * This mask is set if the device woke because of this key event.
 *
 * @deprecated This flag will never be set by the system since the system
 * consumes all wake keys itself.
 * @apiSince 1
 * @deprecatedSince 20
 */

@Deprecated public static final int FLAG_WOKE_HERE = 1; // 0x1

/**
 * Key code constant: '0' key.
 * @apiSince 1
 */

public static final int KEYCODE_0 = 7; // 0x7

/**
 * Key code constant: '1' key.
 * @apiSince 1
 */

public static final int KEYCODE_1 = 8; // 0x8

/**
 * Key code constant: '11' key.
 * @apiSince 21
 */

public static final int KEYCODE_11 = 227; // 0xe3

/**
 * Key code constant: '12' key.
 * @apiSince 21
 */

public static final int KEYCODE_12 = 228; // 0xe4

/**
 * Key code constant: '2' key.
 * @apiSince 1
 */

public static final int KEYCODE_2 = 9; // 0x9

/**
 * Key code constant: '3' key.
 * @apiSince 1
 */

public static final int KEYCODE_3 = 10; // 0xa

/** Key code constant: 3D Mode key.
 * Toggles the display between 2D and 3D mode.     * @apiSince 14
 */

public static final int KEYCODE_3D_MODE = 206; // 0xce

/**
 * Key code constant: '4' key.
 * @apiSince 1
 */

public static final int KEYCODE_4 = 11; // 0xb

/**
 * Key code constant: '5' key.
 * @apiSince 1
 */

public static final int KEYCODE_5 = 12; // 0xc

/**
 * Key code constant: '6' key.
 * @apiSince 1
 */

public static final int KEYCODE_6 = 13; // 0xd

/**
 * Key code constant: '7' key.
 * @apiSince 1
 */

public static final int KEYCODE_7 = 14; // 0xe

/**
 * Key code constant: '8' key.
 * @apiSince 1
 */

public static final int KEYCODE_8 = 15; // 0xf

/**
 * Key code constant: '9' key.
 * @apiSince 1
 */

public static final int KEYCODE_9 = 16; // 0x10

/**
 * Key code constant: 'A' key.
 * @apiSince 1
 */

public static final int KEYCODE_A = 29; // 0x1d

/**
 * Key code constant: Show all apps
 * @apiSince 28
 */

public static final int KEYCODE_ALL_APPS = 284; // 0x11c

/**
 * Key code constant: Left Alt modifier key.
 * @apiSince 1
 */

public static final int KEYCODE_ALT_LEFT = 57; // 0x39

/**
 * Key code constant: Right Alt modifier key.
 * @apiSince 1
 */

public static final int KEYCODE_ALT_RIGHT = 58; // 0x3a

/**
 * Key code constant: ''' (apostrophe) key.
 * @apiSince 1
 */

public static final int KEYCODE_APOSTROPHE = 75; // 0x4b

/** Key code constant: App switch key.
 * Should bring up the application switcher dialog.     * @apiSince 11
 */

public static final int KEYCODE_APP_SWITCH = 187; // 0xbb

/** Key code constant: Assist key.
 * Launches the global assist activity.  Not delivered to applications.     * @apiSince 16
 */

public static final int KEYCODE_ASSIST = 219; // 0xdb

/**
 * Key code constant: '@' key.
 * @apiSince 1
 */

public static final int KEYCODE_AT = 77; // 0x4d

/** Key code constant: A/V Receiver input key.
 * On TV remotes, switches the input mode on an external A/V Receiver.     * @apiSince 11
 */

public static final int KEYCODE_AVR_INPUT = 182; // 0xb6

/** Key code constant: A/V Receiver power key.
 * On TV remotes, toggles the power on an external A/V Receiver.     * @apiSince 11
 */

public static final int KEYCODE_AVR_POWER = 181; // 0xb5

/**
 * Key code constant: 'B' key.
 * @apiSince 1
 */

public static final int KEYCODE_B = 30; // 0x1e

/**
 * Key code constant: Back key.
 * @apiSince 1
 */

public static final int KEYCODE_BACK = 4; // 0x4

/**
 * Key code constant: '\' key.
 * @apiSince 1
 */

public static final int KEYCODE_BACKSLASH = 73; // 0x49

/** Key code constant: Bookmark key.
 * On some TV remotes, bookmarks content or web pages.     * @apiSince 11
 */

public static final int KEYCODE_BOOKMARK = 174; // 0xae

/**
 * Key code constant: Break / Pause key.
 * @apiSince 11
 */

public static final int KEYCODE_BREAK = 121; // 0x79

/** Key code constant: Brightness Down key.
 * Adjusts the screen brightness down.     * @apiSince 18
 */

public static final int KEYCODE_BRIGHTNESS_DOWN = 220; // 0xdc

/** Key code constant: Brightness Up key.
 * Adjusts the screen brightness up.     * @apiSince 18
 */

public static final int KEYCODE_BRIGHTNESS_UP = 221; // 0xdd

/**
 * Key code constant: Generic Game Pad Button #1.
 * @apiSince 12
 */

public static final int KEYCODE_BUTTON_1 = 188; // 0xbc

/**
 * Key code constant: Generic Game Pad Button #10.
 * @apiSince 12
 */

public static final int KEYCODE_BUTTON_10 = 197; // 0xc5

/**
 * Key code constant: Generic Game Pad Button #11.
 * @apiSince 12
 */

public static final int KEYCODE_BUTTON_11 = 198; // 0xc6

/**
 * Key code constant: Generic Game Pad Button #12.
 * @apiSince 12
 */

public static final int KEYCODE_BUTTON_12 = 199; // 0xc7

/**
 * Key code constant: Generic Game Pad Button #13.
 * @apiSince 12
 */

public static final int KEYCODE_BUTTON_13 = 200; // 0xc8

/**
 * Key code constant: Generic Game Pad Button #14.
 * @apiSince 12
 */

public static final int KEYCODE_BUTTON_14 = 201; // 0xc9

/**
 * Key code constant: Generic Game Pad Button #15.
 * @apiSince 12
 */

public static final int KEYCODE_BUTTON_15 = 202; // 0xca

/**
 * Key code constant: Generic Game Pad Button #16.
 * @apiSince 12
 */

public static final int KEYCODE_BUTTON_16 = 203; // 0xcb

/**
 * Key code constant: Generic Game Pad Button #2.
 * @apiSince 12
 */

public static final int KEYCODE_BUTTON_2 = 189; // 0xbd

/**
 * Key code constant: Generic Game Pad Button #3.
 * @apiSince 12
 */

public static final int KEYCODE_BUTTON_3 = 190; // 0xbe

/**
 * Key code constant: Generic Game Pad Button #4.
 * @apiSince 12
 */

public static final int KEYCODE_BUTTON_4 = 191; // 0xbf

/**
 * Key code constant: Generic Game Pad Button #5.
 * @apiSince 12
 */

public static final int KEYCODE_BUTTON_5 = 192; // 0xc0

/**
 * Key code constant: Generic Game Pad Button #6.
 * @apiSince 12
 */

public static final int KEYCODE_BUTTON_6 = 193; // 0xc1

/**
 * Key code constant: Generic Game Pad Button #7.
 * @apiSince 12
 */

public static final int KEYCODE_BUTTON_7 = 194; // 0xc2

/**
 * Key code constant: Generic Game Pad Button #8.
 * @apiSince 12
 */

public static final int KEYCODE_BUTTON_8 = 195; // 0xc3

/**
 * Key code constant: Generic Game Pad Button #9.
 * @apiSince 12
 */

public static final int KEYCODE_BUTTON_9 = 196; // 0xc4

/** Key code constant: A Button key.
 * On a game controller, the A button should be either the button labeled A
 * or the first button on the bottom row of controller buttons.     * @apiSince 9
 */

public static final int KEYCODE_BUTTON_A = 96; // 0x60

/** Key code constant: B Button key.
 * On a game controller, the B button should be either the button labeled B
 * or the second button on the bottom row of controller buttons.     * @apiSince 9
 */

public static final int KEYCODE_BUTTON_B = 97; // 0x61

/** Key code constant: C Button key.
 * On a game controller, the C button should be either the button labeled C
 * or the third button on the bottom row of controller buttons.     * @apiSince 9
 */

public static final int KEYCODE_BUTTON_C = 98; // 0x62

/** Key code constant: L1 Button key.
 * On a game controller, the L1 button should be either the button labeled L1 (or L)
 * or the top left trigger button.     * @apiSince 9
 */

public static final int KEYCODE_BUTTON_L1 = 102; // 0x66

/** Key code constant: L2 Button key.
 * On a game controller, the L2 button should be either the button labeled L2
 * or the bottom left trigger button.     * @apiSince 9
 */

public static final int KEYCODE_BUTTON_L2 = 104; // 0x68

/** Key code constant: Mode Button key.
 * On a game controller, the button labeled Mode.     * @apiSince 9
 */

public static final int KEYCODE_BUTTON_MODE = 110; // 0x6e

/** Key code constant: R1 Button key.
 * On a game controller, the R1 button should be either the button labeled R1 (or R)
 * or the top right trigger button.     * @apiSince 9
 */

public static final int KEYCODE_BUTTON_R1 = 103; // 0x67

/** Key code constant: R2 Button key.
 * On a game controller, the R2 button should be either the button labeled R2
 * or the bottom right trigger button.     * @apiSince 9
 */

public static final int KEYCODE_BUTTON_R2 = 105; // 0x69

/** Key code constant: Select Button key.
 * On a game controller, the button labeled Select.     * @apiSince 9
 */

public static final int KEYCODE_BUTTON_SELECT = 109; // 0x6d

/** Key code constant: Start Button key.
 * On a game controller, the button labeled Start.     * @apiSince 9
 */

public static final int KEYCODE_BUTTON_START = 108; // 0x6c

/** Key code constant: Left Thumb Button key.
 * On a game controller, the left thumb button indicates that the left (or only)
 * joystick is pressed.     * @apiSince 9
 */

public static final int KEYCODE_BUTTON_THUMBL = 106; // 0x6a

/** Key code constant: Right Thumb Button key.
 * On a game controller, the right thumb button indicates that the right
 * joystick is pressed.     * @apiSince 9
 */

public static final int KEYCODE_BUTTON_THUMBR = 107; // 0x6b

/** Key code constant: X Button key.
 * On a game controller, the X button should be either the button labeled X
 * or the first button on the upper row of controller buttons.     * @apiSince 9
 */

public static final int KEYCODE_BUTTON_X = 99; // 0x63

/** Key code constant: Y Button key.
 * On a game controller, the Y button should be either the button labeled Y
 * or the second button on the upper row of controller buttons.     * @apiSince 9
 */

public static final int KEYCODE_BUTTON_Y = 100; // 0x64

/** Key code constant: Z Button key.
 * On a game controller, the Z button should be either the button labeled Z
 * or the third button on the upper row of controller buttons.     * @apiSince 9
 */

public static final int KEYCODE_BUTTON_Z = 101; // 0x65

/**
 * Key code constant: 'C' key.
 * @apiSince 1
 */

public static final int KEYCODE_C = 31; // 0x1f

/** Key code constant: Calculator special function key.
 * Used to launch a calculator application.     * @apiSince 15
 */

public static final int KEYCODE_CALCULATOR = 210; // 0xd2

/** Key code constant: Calendar special function key.
 * Used to launch a calendar application.     * @apiSince 15
 */

public static final int KEYCODE_CALENDAR = 208; // 0xd0

/**
 * Key code constant: Call key.
 * @apiSince 1
 */

public static final int KEYCODE_CALL = 5; // 0x5

/** Key code constant: Camera key.
 * Used to launch a camera application or take pictures.     * @apiSince 1
 */

public static final int KEYCODE_CAMERA = 27; // 0x1b

/**
 * Key code constant: Caps Lock key.
 * @apiSince 11
 */

public static final int KEYCODE_CAPS_LOCK = 115; // 0x73

/** Key code constant: Toggle captions key.
 * Switches the mode for closed-captioning text, for example during television shows.     * @apiSince 11
 */

public static final int KEYCODE_CAPTIONS = 175; // 0xaf

/** Key code constant: Channel down key.
 * On TV remotes, decrements the television channel.     * @apiSince 11
 */

public static final int KEYCODE_CHANNEL_DOWN = 167; // 0xa7

/** Key code constant: Channel up key.
 * On TV remotes, increments the television channel.     * @apiSince 11
 */

public static final int KEYCODE_CHANNEL_UP = 166; // 0xa6

/**
 * Key code constant: Clear key.
 * @apiSince 1
 */

public static final int KEYCODE_CLEAR = 28; // 0x1c

/**
 * Key code constant: ',' key.
 * @apiSince 1
 */

public static final int KEYCODE_COMMA = 55; // 0x37

/** Key code constant: Contacts special function key.
 * Used to launch an address book application.     * @apiSince 15
 */

public static final int KEYCODE_CONTACTS = 207; // 0xcf

/**
 * Key code constant: Copy key.
 * @apiSince 24
 */

public static final int KEYCODE_COPY = 278; // 0x116

/**
 * Key code constant: Left Control modifier key.
 * @apiSince 11
 */

public static final int KEYCODE_CTRL_LEFT = 113; // 0x71

/**
 * Key code constant: Right Control modifier key.
 * @apiSince 11
 */

public static final int KEYCODE_CTRL_RIGHT = 114; // 0x72

/**
 * Key code constant: Cut key.
 * @apiSince 24
 */

public static final int KEYCODE_CUT = 277; // 0x115

/**
 * Key code constant: 'D' key.
 * @apiSince 1
 */

public static final int KEYCODE_D = 32; // 0x20

/** Key code constant: Backspace key.
 * Deletes characters before the insertion point, unlike {@link #KEYCODE_FORWARD_DEL}.     * @apiSince 1
 */

public static final int KEYCODE_DEL = 67; // 0x43

/** Key code constant: Directional Pad Center key.
 * May also be synthesized from trackball motions.     * @apiSince 1
 */

public static final int KEYCODE_DPAD_CENTER = 23; // 0x17

/** Key code constant: Directional Pad Down key.
 * May also be synthesized from trackball motions.     * @apiSince 1
 */

public static final int KEYCODE_DPAD_DOWN = 20; // 0x14

/**
 * Key code constant: Directional Pad Down-Left
 * @apiSince 24
 */

public static final int KEYCODE_DPAD_DOWN_LEFT = 269; // 0x10d

/**
 * Key code constant: Directional Pad Down-Right
 * @apiSince 24
 */

public static final int KEYCODE_DPAD_DOWN_RIGHT = 271; // 0x10f

/** Key code constant: Directional Pad Left key.
 * May also be synthesized from trackball motions.     * @apiSince 1
 */

public static final int KEYCODE_DPAD_LEFT = 21; // 0x15

/** Key code constant: Directional Pad Right key.
 * May also be synthesized from trackball motions.     * @apiSince 1
 */

public static final int KEYCODE_DPAD_RIGHT = 22; // 0x16

/** Key code constant: Directional Pad Up key.
 * May also be synthesized from trackball motions.     * @apiSince 1
 */

public static final int KEYCODE_DPAD_UP = 19; // 0x13

/**
 * Key code constant: Directional Pad Up-Left
 * @apiSince 24
 */

public static final int KEYCODE_DPAD_UP_LEFT = 268; // 0x10c

/**
 * Key code constant: Directional Pad Up-Right
 * @apiSince 24
 */

public static final int KEYCODE_DPAD_UP_RIGHT = 270; // 0x10e

/** Key code constant: DVR key.
 * On some TV remotes, switches to a DVR mode for recorded shows.     * @apiSince 11
 */

public static final int KEYCODE_DVR = 173; // 0xad

/**
 * Key code constant: 'E' key.
 * @apiSince 1
 */

public static final int KEYCODE_E = 33; // 0x21

/**
 * Key code constant: Japanese alphanumeric key.
 * @apiSince 16
 */

public static final int KEYCODE_EISU = 212; // 0xd4

/**
 * Key code constant: End Call key.
 * @apiSince 1
 */

public static final int KEYCODE_ENDCALL = 6; // 0x6

/**
 * Key code constant: Enter key.
 * @apiSince 1
 */

public static final int KEYCODE_ENTER = 66; // 0x42

/** Key code constant: Envelope special function key.
 * Used to launch a mail application.     * @apiSince 1
 */

public static final int KEYCODE_ENVELOPE = 65; // 0x41

/**
 * Key code constant: '=' key.
 * @apiSince 1
 */

public static final int KEYCODE_EQUALS = 70; // 0x46

/**
 * Key code constant: Escape key.
 * @apiSince 11
 */

public static final int KEYCODE_ESCAPE = 111; // 0x6f

/** Key code constant: Explorer special function key.
 * Used to launch a browser application.     * @apiSince 1
 */

public static final int KEYCODE_EXPLORER = 64; // 0x40

/**
 * Key code constant: 'F' key.
 * @apiSince 1
 */

public static final int KEYCODE_F = 34; // 0x22

/**
 * Key code constant: F1 key.
 * @apiSince 11
 */

public static final int KEYCODE_F1 = 131; // 0x83

/**
 * Key code constant: F10 key.
 * @apiSince 11
 */

public static final int KEYCODE_F10 = 140; // 0x8c

/**
 * Key code constant: F11 key.
 * @apiSince 11
 */

public static final int KEYCODE_F11 = 141; // 0x8d

/**
 * Key code constant: F12 key.
 * @apiSince 11
 */

public static final int KEYCODE_F12 = 142; // 0x8e

/**
 * Key code constant: F2 key.
 * @apiSince 11
 */

public static final int KEYCODE_F2 = 132; // 0x84

/**
 * Key code constant: F3 key.
 * @apiSince 11
 */

public static final int KEYCODE_F3 = 133; // 0x85

/**
 * Key code constant: F4 key.
 * @apiSince 11
 */

public static final int KEYCODE_F4 = 134; // 0x86

/**
 * Key code constant: F5 key.
 * @apiSince 11
 */

public static final int KEYCODE_F5 = 135; // 0x87

/**
 * Key code constant: F6 key.
 * @apiSince 11
 */

public static final int KEYCODE_F6 = 136; // 0x88

/**
 * Key code constant: F7 key.
 * @apiSince 11
 */

public static final int KEYCODE_F7 = 137; // 0x89

/**
 * Key code constant: F8 key.
 * @apiSince 11
 */

public static final int KEYCODE_F8 = 138; // 0x8a

/**
 * Key code constant: F9 key.
 * @apiSince 11
 */

public static final int KEYCODE_F9 = 139; // 0x8b

/** Key code constant: Camera Focus key.
 * Used to focus the camera.     * @apiSince 1
 */

public static final int KEYCODE_FOCUS = 80; // 0x50

/** Key code constant: Forward key.
 * Navigates forward in the history stack.  Complement of {@link #KEYCODE_BACK}.     * @apiSince 11
 */

public static final int KEYCODE_FORWARD = 125; // 0x7d

/** Key code constant: Forward Delete key.
 * Deletes characters ahead of the insertion point, unlike {@link #KEYCODE_DEL}.     * @apiSince 11
 */

public static final int KEYCODE_FORWARD_DEL = 112; // 0x70

/**
 * Key code constant: Function modifier key.
 * @apiSince 11
 */

public static final int KEYCODE_FUNCTION = 119; // 0x77

/**
 * Key code constant: 'G' key.
 * @apiSince 1
 */

public static final int KEYCODE_G = 35; // 0x23

/**
 * Key code constant: '`' (backtick) key.
 * @apiSince 1
 */

public static final int KEYCODE_GRAVE = 68; // 0x44

/** Key code constant: Guide key.
 * On TV remotes, shows a programming guide.     * @apiSince 11
 */

public static final int KEYCODE_GUIDE = 172; // 0xac

/**
 * Key code constant: 'H' key.
 * @apiSince 1
 */

public static final int KEYCODE_H = 36; // 0x24

/** Key code constant: Headset Hook key.
 * Used to hang up calls and stop media.     * @apiSince 1
 */

public static final int KEYCODE_HEADSETHOOK = 79; // 0x4f

/**
 * Key code constant: Help key.
 * @apiSince 21
 */

public static final int KEYCODE_HELP = 259; // 0x103

/**
 * Key code constant: Japanese conversion key.
 * @apiSince 16
 */

public static final int KEYCODE_HENKAN = 214; // 0xd6

/** Key code constant: Home key.
 * This key is handled by the framework and is never delivered to applications.     * @apiSince 1
 */

public static final int KEYCODE_HOME = 3; // 0x3

/**
 * Key code constant: 'I' key.
 * @apiSince 1
 */

public static final int KEYCODE_I = 37; // 0x25

/** Key code constant: Info key.
 * Common on TV remotes to show additional information related to what is
 * currently being viewed.     * @apiSince 11
 */

public static final int KEYCODE_INFO = 165; // 0xa5

/** Key code constant: Insert key.
 * Toggles insert / overwrite edit mode.     * @apiSince 11
 */

public static final int KEYCODE_INSERT = 124; // 0x7c

/**
 * Key code constant: 'J' key.
 * @apiSince 1
 */

public static final int KEYCODE_J = 38; // 0x26

/**
 * Key code constant: 'K' key.
 * @apiSince 1
 */

public static final int KEYCODE_K = 39; // 0x27

/**
 * Key code constant: Japanese kana key.
 * @apiSince 16
 */

public static final int KEYCODE_KANA = 218; // 0xda

/**
 * Key code constant: Japanese katakana / hiragana key.
 * @apiSince 16
 */

public static final int KEYCODE_KATAKANA_HIRAGANA = 215; // 0xd7

/**
 * Key code constant: 'L' key.
 * @apiSince 1
 */

public static final int KEYCODE_L = 40; // 0x28

/** Key code constant: Language Switch key.
 * Toggles the current input language such as switching between English and Japanese on
 * a QWERTY keyboard.  On some devices, the same function may be performed by
 * pressing Shift+Spacebar.     * @apiSince 14
 */

public static final int KEYCODE_LANGUAGE_SWITCH = 204; // 0xcc

/** Key code constant: Last Channel key.
 * Goes to the last viewed channel.     * @apiSince 21
 */

public static final int KEYCODE_LAST_CHANNEL = 229; // 0xe5

/**
 * Key code constant: '[' key.
 * @apiSince 1
 */

public static final int KEYCODE_LEFT_BRACKET = 71; // 0x47

/**
 * Key code constant: 'M' key.
 * @apiSince 1
 */

public static final int KEYCODE_M = 41; // 0x29

/** Key code constant: Manner Mode key.
 * Toggles silent or vibrate mode on and off to make the device behave more politely
 * in certain settings such as on a crowded train.  On some devices, the key may only
 * operate when long-pressed.     * @apiSince 14
 */

public static final int KEYCODE_MANNER_MODE = 205; // 0xcd

/** Key code constant: Audio Track key.
 * Switches the audio tracks.     * @apiSince 19
 */

public static final int KEYCODE_MEDIA_AUDIO_TRACK = 222; // 0xde

/** Key code constant: Close media key.
 * May be used to close a CD tray, for example.     * @apiSince 11
 */

public static final int KEYCODE_MEDIA_CLOSE = 128; // 0x80

/** Key code constant: Eject media key.
 * May be used to eject a CD tray, for example.     * @apiSince 11
 */

public static final int KEYCODE_MEDIA_EJECT = 129; // 0x81

/**
 * Key code constant: Fast Forward media key.
 * @apiSince 3
 */

public static final int KEYCODE_MEDIA_FAST_FORWARD = 90; // 0x5a

/**
 * Key code constant: Play Next media key.
 * @apiSince 3
 */

public static final int KEYCODE_MEDIA_NEXT = 87; // 0x57

/**
 * Key code constant: Pause media key.
 * @apiSince 11
 */

public static final int KEYCODE_MEDIA_PAUSE = 127; // 0x7f

/**
 * Key code constant: Play media key.
 * @apiSince 11
 */

public static final int KEYCODE_MEDIA_PLAY = 126; // 0x7e

/**
 * Key code constant: Play/Pause media key.
 * @apiSince 3
 */

public static final int KEYCODE_MEDIA_PLAY_PAUSE = 85; // 0x55

/**
 * Key code constant: Play Previous media key.
 * @apiSince 3
 */

public static final int KEYCODE_MEDIA_PREVIOUS = 88; // 0x58

/**
 * Key code constant: Record media key.
 * @apiSince 11
 */

public static final int KEYCODE_MEDIA_RECORD = 130; // 0x82

/**
 * Key code constant: Rewind media key.
 * @apiSince 3
 */

public static final int KEYCODE_MEDIA_REWIND = 89; // 0x59

/**
 * Key code constant: Skip backward media key.
 * @apiSince 23
 */

public static final int KEYCODE_MEDIA_SKIP_BACKWARD = 273; // 0x111

/**
 * Key code constant: Skip forward media key.
 * @apiSince 23
 */

public static final int KEYCODE_MEDIA_SKIP_FORWARD = 272; // 0x110

/** Key code constant: Step backward media key.
 * Steps media backward, one frame at a time.     * @apiSince 23
 */

public static final int KEYCODE_MEDIA_STEP_BACKWARD = 275; // 0x113

/** Key code constant: Step forward media key.
 * Steps media forward, one frame at a time.     * @apiSince 23
 */

public static final int KEYCODE_MEDIA_STEP_FORWARD = 274; // 0x112

/**
 * Key code constant: Stop media key.
 * @apiSince 3
 */

public static final int KEYCODE_MEDIA_STOP = 86; // 0x56

/** Key code constant: Media Top Menu key.
 * Goes to the top of media menu.     * @apiSince 21
 */

public static final int KEYCODE_MEDIA_TOP_MENU = 226; // 0xe2

/**
 * Key code constant: Menu key.
 * @apiSince 1
 */

public static final int KEYCODE_MENU = 82; // 0x52

/**
 * Key code constant: Left Meta modifier key.
 * @apiSince 11
 */

public static final int KEYCODE_META_LEFT = 117; // 0x75

/**
 * Key code constant: Right Meta modifier key.
 * @apiSince 11
 */

public static final int KEYCODE_META_RIGHT = 118; // 0x76

/**
 * Key code constant: '-'.
 * @apiSince 1
 */

public static final int KEYCODE_MINUS = 69; // 0x45

/** Key code constant: End Movement key.
 * Used for scrolling or moving the cursor around to the end of a line
 * or to the bottom of a list.     * @apiSince 11
 */

public static final int KEYCODE_MOVE_END = 123; // 0x7b

/** Key code constant: Home Movement key.
 * Used for scrolling or moving the cursor around to the start of a line
 * or to the top of a list.     * @apiSince 11
 */

public static final int KEYCODE_MOVE_HOME = 122; // 0x7a

/**
 * Key code constant: Japanese non-conversion key.
 * @apiSince 16
 */

public static final int KEYCODE_MUHENKAN = 213; // 0xd5

/** Key code constant: Music special function key.
 * Used to launch a music player application.     * @apiSince 15
 */

public static final int KEYCODE_MUSIC = 209; // 0xd1

/** Key code constant: Mute key.
 * Mutes the microphone, unlike {@link #KEYCODE_VOLUME_MUTE}.     * @apiSince 3
 */

public static final int KEYCODE_MUTE = 91; // 0x5b

/**
 * Key code constant: 'N' key.
 * @apiSince 1
 */

public static final int KEYCODE_N = 42; // 0x2a

/** Key code constant: Navigate in key.
 * Activates the item that currently has focus or expands to the next level of a navigation
 * hierarchy.     * @apiSince 23
 */

public static final int KEYCODE_NAVIGATE_IN = 262; // 0x106

/** Key code constant: Navigate to next key.
 * Advances to the next item in an ordered collection of items.     * @apiSince 23
 */

public static final int KEYCODE_NAVIGATE_NEXT = 261; // 0x105

/** Key code constant: Navigate out key.
 * Backs out one level of a navigation hierarchy or collapses the item that currently has
 * focus.     * @apiSince 23
 */

public static final int KEYCODE_NAVIGATE_OUT = 263; // 0x107

/** Key code constant: Navigate to previous key.
 * Goes backward by one item in an ordered collection of items.     * @apiSince 23
 */

public static final int KEYCODE_NAVIGATE_PREVIOUS = 260; // 0x104

/**
 * Key code constant: Notification key.
 * @apiSince 1
 */

public static final int KEYCODE_NOTIFICATION = 83; // 0x53

/** Key code constant: Number modifier key.
 * Used to enter numeric symbols.
 * This key is not Num Lock; it is more like {@link #KEYCODE_ALT_LEFT} and is
 * interpreted as an ALT key by {@link android.text.method.MetaKeyKeyListener}.     * @apiSince 1
 */

public static final int KEYCODE_NUM = 78; // 0x4e

/**
 * Key code constant: Numeric keypad '0' key.
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_0 = 144; // 0x90

/**
 * Key code constant: Numeric keypad '1' key.
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_1 = 145; // 0x91

/**
 * Key code constant: Numeric keypad '2' key.
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_2 = 146; // 0x92

/**
 * Key code constant: Numeric keypad '3' key.
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_3 = 147; // 0x93

/**
 * Key code constant: Numeric keypad '4' key.
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_4 = 148; // 0x94

/**
 * Key code constant: Numeric keypad '5' key.
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_5 = 149; // 0x95

/**
 * Key code constant: Numeric keypad '6' key.
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_6 = 150; // 0x96

/**
 * Key code constant: Numeric keypad '7' key.
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_7 = 151; // 0x97

/**
 * Key code constant: Numeric keypad '8' key.
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_8 = 152; // 0x98

/**
 * Key code constant: Numeric keypad '9' key.
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_9 = 153; // 0x99

/**
 * Key code constant: Numeric keypad '+' key (for addition).
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_ADD = 157; // 0x9d

/**
 * Key code constant: Numeric keypad ',' key (for decimals or digit grouping).
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_COMMA = 159; // 0x9f

/**
 * Key code constant: Numeric keypad '/' key (for division).
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_DIVIDE = 154; // 0x9a

/**
 * Key code constant: Numeric keypad '.' key (for decimals or digit grouping).
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_DOT = 158; // 0x9e

/**
 * Key code constant: Numeric keypad Enter key.
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_ENTER = 160; // 0xa0

/**
 * Key code constant: Numeric keypad '=' key.
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_EQUALS = 161; // 0xa1

/**
 * Key code constant: Numeric keypad '(' key.
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_LEFT_PAREN = 162; // 0xa2

/**
 * Key code constant: Numeric keypad '*' key (for multiplication).
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_MULTIPLY = 155; // 0x9b

/**
 * Key code constant: Numeric keypad ')' key.
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_RIGHT_PAREN = 163; // 0xa3

/**
 * Key code constant: Numeric keypad '-' key (for subtraction).
 * @apiSince 11
 */

public static final int KEYCODE_NUMPAD_SUBTRACT = 156; // 0x9c

/** Key code constant: Num Lock key.
 * This is the Num Lock key; it is different from {@link #KEYCODE_NUM}.
 * This key alters the behavior of other keys on the numeric keypad.     * @apiSince 11
 */

public static final int KEYCODE_NUM_LOCK = 143; // 0x8f

/**
 * Key code constant: 'O' key.
 * @apiSince 1
 */

public static final int KEYCODE_O = 43; // 0x2b

/**
 * Key code constant: 'P' key.
 * @apiSince 1
 */

public static final int KEYCODE_P = 44; // 0x2c

/**
 * Key code constant: Page Down key.
 * @apiSince 9
 */

public static final int KEYCODE_PAGE_DOWN = 93; // 0x5d

/**
 * Key code constant: Page Up key.
 * @apiSince 9
 */

public static final int KEYCODE_PAGE_UP = 92; // 0x5c

/** Key code constant: Pairing key.
 * Initiates peripheral pairing mode. Useful for pairing remote control
 * devices or game controllers, especially if no other input mode is
 * available.     * @apiSince 21
 */

public static final int KEYCODE_PAIRING = 225; // 0xe1

/**
 * Key code constant: Paste key.
 * @apiSince 24
 */

public static final int KEYCODE_PASTE = 279; // 0x117

/**
 * Key code constant: '.' key.
 * @apiSince 1
 */

public static final int KEYCODE_PERIOD = 56; // 0x38

/** Key code constant: Picture Symbols modifier key.
 * Used to switch symbol sets (Emoji, Kao-moji).     * @apiSince 9
 */

public static final int KEYCODE_PICTSYMBOLS = 94; // 0x5e

/**
 * Key code constant: '+' key.
 * @apiSince 1
 */

public static final int KEYCODE_PLUS = 81; // 0x51

/**
 * Key code constant: '#' key.
 * @apiSince 1
 */

public static final int KEYCODE_POUND = 18; // 0x12

/**
 * Key code constant: Power key.
 * @apiSince 1
 */

public static final int KEYCODE_POWER = 26; // 0x1a

/**
 * Key code constant: Used to switch current {@link android.accounts.Account} that is
 * consuming content. May be consumed by system to set account globally.
 * @apiSince 29
 */

public static final int KEYCODE_PROFILE_SWITCH = 288; // 0x120

/** Key code constant: Blue "programmable" key.
 * On TV remotes, acts as a contextual/programmable key.     * @apiSince 11
 */

public static final int KEYCODE_PROG_BLUE = 186; // 0xba

/** Key code constant: Green "programmable" key.
 * On TV remotes, actsas a contextual/programmable key.     * @apiSince 11
 */

public static final int KEYCODE_PROG_GREEN = 184; // 0xb8

/** Key code constant: Red "programmable" key.
 * On TV remotes, acts as a contextual/programmable key.     * @apiSince 11
 */

public static final int KEYCODE_PROG_RED = 183; // 0xb7

/** Key code constant: Yellow "programmable" key.
 * On TV remotes, acts as a contextual/programmable key.     * @apiSince 11
 */

public static final int KEYCODE_PROG_YELLOW = 185; // 0xb9

/**
 * Key code constant: 'Q' key.
 * @apiSince 1
 */

public static final int KEYCODE_Q = 45; // 0x2d

/**
 * Key code constant: 'R' key.
 * @apiSince 1
 */

public static final int KEYCODE_R = 46; // 0x2e

/**
 * Key code constant: Refresh key.
 * @apiSince 28
 */

public static final int KEYCODE_REFRESH = 285; // 0x11d

/**
 * Key code constant: ']' key.
 * @apiSince 1
 */

public static final int KEYCODE_RIGHT_BRACKET = 72; // 0x48

/**
 * Key code constant: Japanese Ro key.
 * @apiSince 16
 */

public static final int KEYCODE_RO = 217; // 0xd9

/**
 * Key code constant: 'S' key.
 * @apiSince 1
 */

public static final int KEYCODE_S = 47; // 0x2f

/**
 * Key code constant: Scroll Lock key.
 * @apiSince 11
 */

public static final int KEYCODE_SCROLL_LOCK = 116; // 0x74

/**
 * Key code constant: Search key.
 * @apiSince 1
 */

public static final int KEYCODE_SEARCH = 84; // 0x54

/**
 * Key code constant: ';' key.
 * @apiSince 1
 */

public static final int KEYCODE_SEMICOLON = 74; // 0x4a

/** Key code constant: Settings key.
 * Starts the system settings activity.     * @apiSince 11
 */

public static final int KEYCODE_SETTINGS = 176; // 0xb0

/**
 * Key code constant: Left Shift modifier key.
 * @apiSince 1
 */

public static final int KEYCODE_SHIFT_LEFT = 59; // 0x3b

/**
 * Key code constant: Right Shift modifier key.
 * @apiSince 1
 */

public static final int KEYCODE_SHIFT_RIGHT = 60; // 0x3c

/**
 * Key code constant: '/' key.
 * @apiSince 1
 */

public static final int KEYCODE_SLASH = 76; // 0x4c

/** Key code constant: Sleep key.
 * Puts the device to sleep.  Behaves somewhat like {@link #KEYCODE_POWER} but it
 * has no effect if the device is already asleep.     * @apiSince 20
 */

public static final int KEYCODE_SLEEP = 223; // 0xdf

/** Key code constant: Soft Left key.
 * Usually situated below the display on phones and used as a multi-function
 * feature key for selecting a software defined function shown on the bottom left
 * of the display.     * @apiSince 1
 */

public static final int KEYCODE_SOFT_LEFT = 1; // 0x1

/** Key code constant: Soft Right key.
 * Usually situated below the display on phones and used as a multi-function
 * feature key for selecting a software defined function shown on the bottom right
 * of the display.     * @apiSince 1
 */

public static final int KEYCODE_SOFT_RIGHT = 2; // 0x2

/**
 * Key code constant: put device to sleep unless a wakelock is held.
 * @apiSince 24
 */

public static final int KEYCODE_SOFT_SLEEP = 276; // 0x114

/**
 * Key code constant: Space key.
 * @apiSince 1
 */

public static final int KEYCODE_SPACE = 62; // 0x3e

/**
 * Key code constant: '*' key.
 * @apiSince 1
 */

public static final int KEYCODE_STAR = 17; // 0x11

/** Key code constant: Set-top-box input key.
 * On TV remotes, switches the input mode on an external Set-top-box.     * @apiSince 11
 */

public static final int KEYCODE_STB_INPUT = 180; // 0xb4

/** Key code constant: Set-top-box power key.
 * On TV remotes, toggles the power on an external Set-top-box.     * @apiSince 11
 */

public static final int KEYCODE_STB_POWER = 179; // 0xb3

/**
 * Key code constant: Generic stem key 1 for Wear
 * @apiSince 24
 */

public static final int KEYCODE_STEM_1 = 265; // 0x109

/**
 * Key code constant: Generic stem key 2 for Wear
 * @apiSince 24
 */

public static final int KEYCODE_STEM_2 = 266; // 0x10a

/**
 * Key code constant: Generic stem key 3 for Wear
 * @apiSince 24
 */

public static final int KEYCODE_STEM_3 = 267; // 0x10b

/** Key code constant: Primary stem key for Wear
 * Main power/reset button on watch.     * @apiSince 24
 */

public static final int KEYCODE_STEM_PRIMARY = 264; // 0x108

/** Key code constant: Switch Charset modifier key.
 * Used to switch character sets (Kanji, Katakana).     * @apiSince 9
 */

public static final int KEYCODE_SWITCH_CHARSET = 95; // 0x5f

/** Key code constant: Symbol modifier key.
 * Used to enter alternate symbols.     * @apiSince 1
 */

public static final int KEYCODE_SYM = 63; // 0x3f

/**
 * Key code constant: System Request / Print Screen key.
 * @apiSince 11
 */

public static final int KEYCODE_SYSRQ = 120; // 0x78

/**
 * Key code constant: Consumed by the system for navigation down
 * @apiSince 25
 */

public static final int KEYCODE_SYSTEM_NAVIGATION_DOWN = 281; // 0x119

/**
 * Key code constant: Consumed by the system for navigation left
 * @apiSince 25
 */

public static final int KEYCODE_SYSTEM_NAVIGATION_LEFT = 282; // 0x11a

/**
 * Key code constant: Consumed by the system for navigation right
 * @apiSince 25
 */

public static final int KEYCODE_SYSTEM_NAVIGATION_RIGHT = 283; // 0x11b

/**
 * Key code constant: Consumed by the system for navigation up
 * @apiSince 25
 */

public static final int KEYCODE_SYSTEM_NAVIGATION_UP = 280; // 0x118

/**
 * Key code constant: 'T' key.
 * @apiSince 1
 */

public static final int KEYCODE_T = 48; // 0x30

/**
 * Key code constant: Tab key.
 * @apiSince 1
 */

public static final int KEYCODE_TAB = 61; // 0x3d

/**
 * Key code constant: Thumbs down key. Apps can use this to let user downvote content.
 * @apiSince 29
 */

public static final int KEYCODE_THUMBS_DOWN = 287; // 0x11f

/**
 * Key code constant: Thumbs up key. Apps can use this to let user upvote content.
 * @apiSince 29
 */

public static final int KEYCODE_THUMBS_UP = 286; // 0x11e

/** Key code constant: TV key.
 * On TV remotes, switches to viewing live TV.     * @apiSince 11
 */

public static final int KEYCODE_TV = 170; // 0xaa

/** Key code constant: Antenna/Cable key.
 * Toggles broadcast input source between antenna and cable.     * @apiSince 21
 */

public static final int KEYCODE_TV_ANTENNA_CABLE = 242; // 0xf2

/** Key code constant: Audio description key.
 * Toggles audio description off / on.     * @apiSince 21
 */

public static final int KEYCODE_TV_AUDIO_DESCRIPTION = 252; // 0xfc

/** Key code constant: Audio description mixing volume down key.
 * Lessen audio description volume as compared with normal audio volume.     * @apiSince 21
 */

public static final int KEYCODE_TV_AUDIO_DESCRIPTION_MIX_DOWN = 254; // 0xfe

/** Key code constant: Audio description mixing volume up key.
 * Louden audio description volume as compared with normal audio volume.     * @apiSince 21
 */

public static final int KEYCODE_TV_AUDIO_DESCRIPTION_MIX_UP = 253; // 0xfd

/** Key code constant: Contents menu key.
 * Goes to the title list. Corresponds to Contents Menu (0x0B) of CEC User Control
 * Code     * @apiSince 21
 */

public static final int KEYCODE_TV_CONTENTS_MENU = 256; // 0x100

/** Key code constant: TV data service key.
 * Displays data services like weather, sports.     * @apiSince 21
 */

public static final int KEYCODE_TV_DATA_SERVICE = 230; // 0xe6

/** Key code constant: TV input key.
 * On TV remotes, switches the input on a television screen.     * @apiSince 11
 */

public static final int KEYCODE_TV_INPUT = 178; // 0xb2

/** Key code constant: Component #1 key.
 * Switches to component video input #1.     * @apiSince 21
 */

public static final int KEYCODE_TV_INPUT_COMPONENT_1 = 249; // 0xf9

/** Key code constant: Component #2 key.
 * Switches to component video input #2.     * @apiSince 21
 */

public static final int KEYCODE_TV_INPUT_COMPONENT_2 = 250; // 0xfa

/** Key code constant: Composite #1 key.
 * Switches to composite video input #1.     * @apiSince 21
 */

public static final int KEYCODE_TV_INPUT_COMPOSITE_1 = 247; // 0xf7

/** Key code constant: Composite #2 key.
 * Switches to composite video input #2.     * @apiSince 21
 */

public static final int KEYCODE_TV_INPUT_COMPOSITE_2 = 248; // 0xf8

/** Key code constant: HDMI #1 key.
 * Switches to HDMI input #1.     * @apiSince 21
 */

public static final int KEYCODE_TV_INPUT_HDMI_1 = 243; // 0xf3

/** Key code constant: HDMI #2 key.
 * Switches to HDMI input #2.     * @apiSince 21
 */

public static final int KEYCODE_TV_INPUT_HDMI_2 = 244; // 0xf4

/** Key code constant: HDMI #3 key.
 * Switches to HDMI input #3.     * @apiSince 21
 */

public static final int KEYCODE_TV_INPUT_HDMI_3 = 245; // 0xf5

/** Key code constant: HDMI #4 key.
 * Switches to HDMI input #4.     * @apiSince 21
 */

public static final int KEYCODE_TV_INPUT_HDMI_4 = 246; // 0xf6

/** Key code constant: VGA #1 key.
 * Switches to VGA (analog RGB) input #1.     * @apiSince 21
 */

public static final int KEYCODE_TV_INPUT_VGA_1 = 251; // 0xfb

/** Key code constant: Media context menu key.
 * Goes to the context menu of media contents. Corresponds to Media Context-sensitive
 * Menu (0x11) of CEC User Control Code.     * @apiSince 21
 */

public static final int KEYCODE_TV_MEDIA_CONTEXT_MENU = 257; // 0x101

/** Key code constant: Toggle Network key.
 * Toggles selecting broacast services.     * @apiSince 21
 */

public static final int KEYCODE_TV_NETWORK = 241; // 0xf1

/** Key code constant: Number entry key.
 * Initiates to enter multi-digit channel nubmber when each digit key is assigned
 * for selecting separate channel. Corresponds to Number Entry Mode (0x1D) of CEC
 * User Control Code.     * @apiSince 21
 */

public static final int KEYCODE_TV_NUMBER_ENTRY = 234; // 0xea

/** Key code constant: TV power key.
 * On TV remotes, toggles the power on a television screen.     * @apiSince 11
 */

public static final int KEYCODE_TV_POWER = 177; // 0xb1

/** Key code constant: Radio key.
 * Toggles TV service / Radio service.     * @apiSince 21
 */

public static final int KEYCODE_TV_RADIO_SERVICE = 232; // 0xe8

/** Key code constant: Satellite key.
 * Switches to digital satellite broadcast service.     * @apiSince 21
 */

public static final int KEYCODE_TV_SATELLITE = 237; // 0xed

/** Key code constant: BS key.
 * Switches to BS digital satellite broadcasting service available in Japan.     * @apiSince 21
 */

public static final int KEYCODE_TV_SATELLITE_BS = 238; // 0xee

/** Key code constant: CS key.
 * Switches to CS digital satellite broadcasting service available in Japan.     * @apiSince 21
 */

public static final int KEYCODE_TV_SATELLITE_CS = 239; // 0xef

/** Key code constant: BS/CS key.
 * Toggles between BS and CS digital satellite services.     * @apiSince 21
 */

public static final int KEYCODE_TV_SATELLITE_SERVICE = 240; // 0xf0

/** Key code constant: Teletext key.
 * Displays Teletext service.     * @apiSince 21
 */

public static final int KEYCODE_TV_TELETEXT = 233; // 0xe9

/** Key code constant: Analog Terrestrial key.
 * Switches to analog terrestrial broadcast service.     * @apiSince 21
 */

public static final int KEYCODE_TV_TERRESTRIAL_ANALOG = 235; // 0xeb

/** Key code constant: Digital Terrestrial key.
 * Switches to digital terrestrial broadcast service.     * @apiSince 21
 */

public static final int KEYCODE_TV_TERRESTRIAL_DIGITAL = 236; // 0xec

/** Key code constant: Timer programming key.
 * Goes to the timer recording menu. Corresponds to Timer Programming (0x54) of
 * CEC User Control Code.     * @apiSince 21
 */

public static final int KEYCODE_TV_TIMER_PROGRAMMING = 258; // 0x102

/** Key code constant: Zoom mode key.
 * Changes Zoom mode (Normal, Full, Zoom, Wide-zoom, etc.)     * @apiSince 21
 */

public static final int KEYCODE_TV_ZOOM_MODE = 255; // 0xff

/**
 * Key code constant: 'U' key.
 * @apiSince 1
 */

public static final int KEYCODE_U = 49; // 0x31

/**
 * Key code constant: Unknown key code.
 * @apiSince 1
 */

public static final int KEYCODE_UNKNOWN = 0; // 0x0

/**
 * Key code constant: 'V' key.
 * @apiSince 1
 */

public static final int KEYCODE_V = 50; // 0x32

/** Key code constant: Voice Assist key.
 * Launches the global voice assist activity. Not delivered to applications.     * @apiSince 21
 */

public static final int KEYCODE_VOICE_ASSIST = 231; // 0xe7

/** Key code constant: Volume Down key.
 * Adjusts the speaker volume down.     * @apiSince 1
 */

public static final int KEYCODE_VOLUME_DOWN = 25; // 0x19

/** Key code constant: Volume Mute key.
 * Mutes the speaker, unlike {@link #KEYCODE_MUTE}.
 * This key should normally be implemented as a toggle such that the first press
 * mutes the speaker and the second press restores the original volume.     * @apiSince 11
 */

public static final int KEYCODE_VOLUME_MUTE = 164; // 0xa4

/** Key code constant: Volume Up key.
 * Adjusts the speaker volume up.     * @apiSince 1
 */

public static final int KEYCODE_VOLUME_UP = 24; // 0x18

/**
 * Key code constant: 'W' key.
 * @apiSince 1
 */

public static final int KEYCODE_W = 51; // 0x33

/** Key code constant: Wakeup key.
 * Wakes up the device.  Behaves somewhat like {@link #KEYCODE_POWER} but it
 * has no effect if the device is already awake.     * @apiSince 20
 */

public static final int KEYCODE_WAKEUP = 224; // 0xe0

/** Key code constant: Window key.
 * On TV remotes, toggles picture-in-picture mode or other windowing functions.
 * On Android Wear devices, triggers a display offset.     * @apiSince 11
 */

public static final int KEYCODE_WINDOW = 171; // 0xab

/**
 * Key code constant: 'X' key.
 * @apiSince 1
 */

public static final int KEYCODE_X = 52; // 0x34

/**
 * Key code constant: 'Y' key.
 * @apiSince 1
 */

public static final int KEYCODE_Y = 53; // 0x35

/**
 * Key code constant: Japanese Yen key.
 * @apiSince 16
 */

public static final int KEYCODE_YEN = 216; // 0xd8

/**
 * Key code constant: 'Z' key.
 * @apiSince 1
 */

public static final int KEYCODE_Z = 54; // 0x36

/**
 * Key code constant: Japanese full-width / half-width key.
 * @apiSince 16
 */

public static final int KEYCODE_ZENKAKU_HANKAKU = 211; // 0xd3

/**
 * Key code constant: Zoom in key.
 * @apiSince 11
 */

public static final int KEYCODE_ZOOM_IN = 168; // 0xa8

/**
 * Key code constant: Zoom out key.
 * @apiSince 11
 */

public static final int KEYCODE_ZOOM_OUT = 169; // 0xa9

/**
 * @deprecated There are now more than MAX_KEYCODE keycodes.
 * Use {@link #getMaxKeyCode()} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int MAX_KEYCODE = 84; // 0x54

/**
 * <p>This mask is used to check whether the left ALT meta key is pressed.</p>
 *
 * @see #isAltPressed()
 * @see #getMetaState()
 * @see #KEYCODE_ALT_LEFT
 * @apiSince 1
 */

public static final int META_ALT_LEFT_ON = 16; // 0x10

/**
 * This mask is a combination of {@link #META_ALT_ON}, {@link #META_ALT_LEFT_ON}
 * and {@link #META_ALT_RIGHT_ON}.
 * @apiSince 11
 */

public static final int META_ALT_MASK = 50; // 0x32

/**
 * <p>This mask is used to check whether one of the ALT meta keys is pressed.</p>
 *
 * @see #isAltPressed()
 * @see #getMetaState()
 * @see #KEYCODE_ALT_LEFT
 * @see #KEYCODE_ALT_RIGHT
 * @apiSince 1
 */

public static final int META_ALT_ON = 2; // 0x2

/**
 * <p>This mask is used to check whether the right the ALT meta key is pressed.</p>
 *
 * @see #isAltPressed()
 * @see #getMetaState()
 * @see #KEYCODE_ALT_RIGHT
 * @apiSince 1
 */

public static final int META_ALT_RIGHT_ON = 32; // 0x20

/**
 * <p>This mask is used to check whether the CAPS LOCK meta key is on.</p>
 *
 * @see #isCapsLockOn()
 * @see #getMetaState()
 * @see #KEYCODE_CAPS_LOCK
 * @apiSince 11
 */

public static final int META_CAPS_LOCK_ON = 1048576; // 0x100000

/**
 * <p>This mask is used to check whether the left CTRL meta key is pressed.</p>
 *
 * @see #isCtrlPressed()
 * @see #getMetaState()
 * @see #KEYCODE_CTRL_LEFT
 * @apiSince 11
 */

public static final int META_CTRL_LEFT_ON = 8192; // 0x2000

/**
 * This mask is a combination of {@link #META_CTRL_ON}, {@link #META_CTRL_LEFT_ON}
 * and {@link #META_CTRL_RIGHT_ON}.
 * @apiSince 11
 */

public static final int META_CTRL_MASK = 28672; // 0x7000

/**
 * <p>This mask is used to check whether one of the CTRL meta keys is pressed.</p>
 *
 * @see #isCtrlPressed()
 * @see #getMetaState()
 * @see #KEYCODE_CTRL_LEFT
 * @see #KEYCODE_CTRL_RIGHT
 * @apiSince 11
 */

public static final int META_CTRL_ON = 4096; // 0x1000

/**
 * <p>This mask is used to check whether the right CTRL meta key is pressed.</p>
 *
 * @see #isCtrlPressed()
 * @see #getMetaState()
 * @see #KEYCODE_CTRL_RIGHT
 * @apiSince 11
 */

public static final int META_CTRL_RIGHT_ON = 16384; // 0x4000

/**
 * <p>This mask is used to check whether the FUNCTION meta key is pressed.</p>
 *
 * @see #isFunctionPressed()
 * @see #getMetaState()
 * @apiSince 11
 */

public static final int META_FUNCTION_ON = 8; // 0x8

/**
 * <p>This mask is used to check whether the left META meta key is pressed.</p>
 *
 * @see #isMetaPressed()
 * @see #getMetaState()
 * @see #KEYCODE_META_LEFT
 * @apiSince 11
 */

public static final int META_META_LEFT_ON = 131072; // 0x20000

/**
 * This mask is a combination of {@link #META_META_ON}, {@link #META_META_LEFT_ON}
 * and {@link #META_META_RIGHT_ON}.
 * @apiSince 11
 */

public static final int META_META_MASK = 458752; // 0x70000

/**
 * <p>This mask is used to check whether one of the META meta keys is pressed.</p>
 *
 * @see #isMetaPressed()
 * @see #getMetaState()
 * @see #KEYCODE_META_LEFT
 * @see #KEYCODE_META_RIGHT
 * @apiSince 11
 */

public static final int META_META_ON = 65536; // 0x10000

/**
 * <p>This mask is used to check whether the right META meta key is pressed.</p>
 *
 * @see #isMetaPressed()
 * @see #getMetaState()
 * @see #KEYCODE_META_RIGHT
 * @apiSince 11
 */

public static final int META_META_RIGHT_ON = 262144; // 0x40000

/**
 * <p>This mask is used to check whether the NUM LOCK meta key is on.</p>
 *
 * @see #isNumLockOn()
 * @see #getMetaState()
 * @see #KEYCODE_NUM_LOCK
 * @apiSince 11
 */

public static final int META_NUM_LOCK_ON = 2097152; // 0x200000

/**
 * <p>This mask is used to check whether the SCROLL LOCK meta key is on.</p>
 *
 * @see #isScrollLockOn()
 * @see #getMetaState()
 * @see #KEYCODE_SCROLL_LOCK
 * @apiSince 11
 */

public static final int META_SCROLL_LOCK_ON = 4194304; // 0x400000

/**
 * <p>This mask is used to check whether the left SHIFT meta key is pressed.</p>
 *
 * @see #isShiftPressed()
 * @see #getMetaState()
 * @see #KEYCODE_SHIFT_LEFT
 * @apiSince 1
 */

public static final int META_SHIFT_LEFT_ON = 64; // 0x40

/**
 * This mask is a combination of {@link #META_SHIFT_ON}, {@link #META_SHIFT_LEFT_ON}
 * and {@link #META_SHIFT_RIGHT_ON}.
 * @apiSince 11
 */

public static final int META_SHIFT_MASK = 193; // 0xc1

/**
 * <p>This mask is used to check whether one of the SHIFT meta keys is pressed.</p>
 *
 * @see #isShiftPressed()
 * @see #getMetaState()
 * @see #KEYCODE_SHIFT_LEFT
 * @see #KEYCODE_SHIFT_RIGHT
 * @apiSince 1
 */

public static final int META_SHIFT_ON = 1; // 0x1

/**
 * <p>This mask is used to check whether the right SHIFT meta key is pressed.</p>
 *
 * @see #isShiftPressed()
 * @see #getMetaState()
 * @see #KEYCODE_SHIFT_RIGHT
 * @apiSince 1
 */

public static final int META_SHIFT_RIGHT_ON = 128; // 0x80

/**
 * <p>This mask is used to check whether the SYM meta key is pressed.</p>
 *
 * @see #isSymPressed()
 * @see #getMetaState()
 * @apiSince 1
 */

public static final int META_SYM_ON = 4; // 0x4
/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Callback {

/**
 * Called when a key down event has occurred.  If you return true,
 * you can first call {@link android.view.KeyEvent#startTracking() KeyEvent#startTracking()} to have the framework track the event
 * through its {@link #onKeyUp(int,android.view.KeyEvent)} and also call your
 * {@link #onKeyLongPress(int,android.view.KeyEvent)} if it occurs.
 *
 * @param keyCode The value in event.getKeyCode().
 * @param event Description of the key event.
 *
 * @return If you handled the event, return true.  If you want to allow
 *         the event to be handled by the next receiver, return false.
 * @apiSince 1
 */

public boolean onKeyDown(int keyCode, android.view.KeyEvent event);

/**
 * Called when a long press has occurred.  If you return true,
 * the final key up will have {@link android.view.KeyEvent#FLAG_CANCELED KeyEvent#FLAG_CANCELED} and
 * {@link android.view.KeyEvent#FLAG_CANCELED_LONG_PRESS KeyEvent#FLAG_CANCELED_LONG_PRESS} set.  Note that in
 * order to receive this callback, someone in the event change
 * <em>must</em> return true from {@link #onKeyDown} <em>and</em>
 * call {@link android.view.KeyEvent#startTracking() KeyEvent#startTracking()} on the event.
 *
 * @param keyCode The value in event.getKeyCode().
 * @param event Description of the key event.
 *
 * @return If you handled the event, return true.  If you want to allow
 *         the event to be handled by the next receiver, return false.
 * @apiSince 5
 */

public boolean onKeyLongPress(int keyCode, android.view.KeyEvent event);

/**
 * Called when a key up event has occurred.
 *
 * @param keyCode The value in event.getKeyCode().
 * @param event Description of the key event.
 *
 * @return If you handled the event, return true.  If you want to allow
 *         the event to be handled by the next receiver, return false.
 * @apiSince 1
 */

public boolean onKeyUp(int keyCode, android.view.KeyEvent event);

/**
 * Called when a user's interaction with an analog control, such as
 * flinging a trackball, generates simulated down/up events for the same
 * key multiple times in quick succession.
 *
 * @param keyCode The value in event.getKeyCode().
 * @param count Number of pairs as returned by event.getRepeatCount().
 * @param event Description of the key event.
 *
 * @return If you handled the event, return true.  If you want to allow
 *         the event to be handled by the next receiver, return false.
 * @apiSince 1
 */

public boolean onKeyMultiple(int keyCode, int count, android.view.KeyEvent event);
}

/**
 * Use with {@link android.view.KeyEvent#dispatch(android.view.KeyEvent.Callback,android.view.KeyEvent.DispatcherState,java.lang.Object) KeyEvent#dispatch(Callback, DispatcherState, Object)}
 * for more advanced key dispatching, such as long presses.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class DispatcherState {

public DispatcherState() { throw new RuntimeException("Stub!"); }

/**
 * Reset back to initial state.
 * @apiSince 5
 */

public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Stop any tracking associated with this target.
 * @apiSince 5
 */

public void reset(java.lang.Object target) { throw new RuntimeException("Stub!"); }

/**
 * Start tracking the key code associated with the given event.  This
 * can only be called on a key down.  It will allow you to see any
 * long press associated with the key, and will result in
 * {@link android.view.KeyEvent#isTracking KeyEvent#isTracking} return true on the long press and up
 * events.
 *
 * <p>This is only needed if you are directly dispatching events, rather
 * than handling them in {@link android.view.KeyEvent.Callback#onKeyDown Callback#onKeyDown}.
 * @apiSince 5
 */

public void startTracking(android.view.KeyEvent event, java.lang.Object target) { throw new RuntimeException("Stub!"); }

/**
 * Return true if the key event is for a key code that is currently
 * being tracked by the dispatcher.
 * @apiSince 5
 */

public boolean isTracking(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Keep track of the given event's key code as having performed an
 * action with a long press, so no action should occur on the up.
 * <p>This is only needed if you are directly dispatching events, rather
 * than handling them in {@link android.view.KeyEvent.Callback#onKeyLongPress Callback#onKeyLongPress}.
 * @apiSince 5
 */

public void performedLongPress(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Handle key up event to stop tracking.  This resets the dispatcher state,
 * and updates the key event state based on it.
 * <p>This is only needed if you are directly dispatching events, rather
 * than handling them in {@link android.view.KeyEvent.Callback#onKeyUp Callback#onKeyUp}.
 * @apiSince 5
 */

public void handleUpEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }
}

}

