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

package android.view;


/**
 * Information about a Keyboard Shortcut.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class KeyboardShortcutInfo implements android.os.Parcelable {

/**
 * @param label The label that identifies the action performed by this shortcut.
 * @param keycode The keycode that triggers the shortcut. This should be a valid constant
 *     defined in {@link android.view.KeyEvent KeyEvent}.
 * @param modifiers The set of modifiers that, combined with the key, trigger the shortcut.
 *     These should be a combination of {@link android.view.KeyEvent#META_CTRL_ON KeyEvent#META_CTRL_ON},
 *     {@link android.view.KeyEvent#META_SHIFT_ON KeyEvent#META_SHIFT_ON}, {@link android.view.KeyEvent#META_META_ON KeyEvent#META_META_ON},
 *     {@link android.view.KeyEvent#META_ALT_ON KeyEvent#META_ALT_ON}, {@link android.view.KeyEvent#META_FUNCTION_ON KeyEvent#META_FUNCTION_ON} and
 *     {@link android.view.KeyEvent#META_SYM_ON KeyEvent#META_SYM_ON}.
 * @apiSince 24
 */

public KeyboardShortcutInfo(java.lang.CharSequence label, int keycode, int modifiers) { throw new RuntimeException("Stub!"); }

/**
 * @param label The label that identifies the action performed by this shortcut.
 * @param baseCharacter The character that triggers the shortcut.
 * @param modifiers The set of modifiers that, combined with the key, trigger the shortcut.
 *     These should be a combination of {@link android.view.KeyEvent#META_CTRL_ON KeyEvent#META_CTRL_ON},
 *     {@link android.view.KeyEvent#META_SHIFT_ON KeyEvent#META_SHIFT_ON}, {@link android.view.KeyEvent#META_META_ON KeyEvent#META_META_ON},
 *     {@link android.view.KeyEvent#META_ALT_ON KeyEvent#META_ALT_ON}, {@link android.view.KeyEvent#META_FUNCTION_ON KeyEvent#META_FUNCTION_ON} and
 *     {@link android.view.KeyEvent#META_SYM_ON KeyEvent#META_SYM_ON}.
 * @apiSince 24
 */

public KeyboardShortcutInfo(java.lang.CharSequence label, char baseCharacter, int modifiers) { throw new RuntimeException("Stub!"); }

/**
 * Returns the label to be used to describe this shortcut.
 
 * @return This value may be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getLabel() { throw new RuntimeException("Stub!"); }

/**
 * Returns the base keycode that, combined with the modifiers, triggers this shortcut. If the
 * base character was set instead, returns {@link android.view.KeyEvent#KEYCODE_UNKNOWN KeyEvent#KEYCODE_UNKNOWN}. Valid keycodes are
 * defined as constants in {@link android.view.KeyEvent KeyEvent}.
 * @apiSince 24
 */

public int getKeycode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the base character that, combined with the modifiers, triggers this shortcut. If the
 * keycode was set instead, returns {@link java.lang.Character#MIN_VALUE Character#MIN_VALUE}.
 * @apiSince 24
 */

public char getBaseCharacter() { throw new RuntimeException("Stub!"); }

/**
 * Returns the set of modifiers that, combined with the key, trigger this shortcut. These can
 * be a combination of {@link android.view.KeyEvent#META_CTRL_ON KeyEvent#META_CTRL_ON}, {@link android.view.KeyEvent#META_SHIFT_ON KeyEvent#META_SHIFT_ON},
 * {@link android.view.KeyEvent#META_META_ON KeyEvent#META_META_ON}, {@link android.view.KeyEvent#META_ALT_ON KeyEvent#META_ALT_ON},
 * {@link android.view.KeyEvent#META_FUNCTION_ON KeyEvent#META_FUNCTION_ON} and {@link android.view.KeyEvent#META_SYM_ON KeyEvent#META_SYM_ON}.
 * @apiSince 24
 */

public int getModifiers() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.KeyboardShortcutInfo> CREATOR;
static { CREATOR = null; }
}

