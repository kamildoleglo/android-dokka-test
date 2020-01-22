/*
 * Copyright (C) 2008-2009 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


package android.inputmethodservice;

import android.os.Build;

/**
 * Loads an XML description of a keyboard and stores the attributes of the keys. A keyboard
 * consists of rows of keys.
 * <p>The layout file for a keyboard contains XML that looks like the following snippet:</p>
 * <pre>
 * &lt;Keyboard
 *         android:keyWidth="%10p"
 *         android:keyHeight="50px"
 *         android:horizontalGap="2px"
 *         android:verticalGap="2px" &gt;
 *     &lt;Row android:keyWidth="32px" &gt;
 *         &lt;Key android:keyLabel="A" /&gt;
 *         ...
 *     &lt;/Row&gt;
 *     ...
 * &lt;/Keyboard&gt;
 * </pre>
 * @attr ref android.R.styleable#Keyboard_keyWidth
 * @attr ref android.R.styleable#Keyboard_keyHeight
 * @attr ref android.R.styleable#Keyboard_horizontalGap
 * @attr ref android.R.styleable#Keyboard_verticalGap
 * @deprecated This class is deprecated because this is just a convenient UI widget class that
 *             application developers can re-implement on top of existing public APIs.  If you have
 *             already depended on this class, consider copying the implementation from AOSP into
 *             your project or re-implementing a similar widget by yourselves
 * @apiSince 3
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class Keyboard {

/**
 * Creates a keyboard from the given xml key layout file.
 * @param context the application or service context
 * @param xmlLayoutResId the resource file that contains the keyboard layout and keys.
 * @apiSince 3
 */

@Deprecated
public Keyboard(android.content.Context context, int xmlLayoutResId) { throw new RuntimeException("Stub!"); }

/**
 * Creates a keyboard from the given xml key layout file. Weeds out rows
 * that have a keyboard mode defined but don't match the specified mode.
 * @param context the application or service context
 * @param xmlLayoutResId the resource file that contains the keyboard layout and keys.
 * @param modeId keyboard mode identifier
 * @param width sets width of keyboard
 * @param height sets height of keyboard
 * @apiSince 11
 */

@Deprecated
public Keyboard(android.content.Context context, int xmlLayoutResId, int modeId, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Creates a keyboard from the given xml key layout file. Weeds out rows
 * that have a keyboard mode defined but don't match the specified mode.
 * @param context the application or service context
 * @param xmlLayoutResId the resource file that contains the keyboard layout and keys.
 * @param modeId keyboard mode identifier
 * @apiSince 3
 */

@Deprecated
public Keyboard(android.content.Context context, int xmlLayoutResId, int modeId) { throw new RuntimeException("Stub!"); }

/**
 * <p>Creates a blank keyboard from the given resource file and populates it with the specified
 * characters in left-to-right, top-to-bottom fashion, using the specified number of columns.
 * </p>
 * <p>If the specified number of columns is -1, then the keyboard will fit as many keys as
 * possible in each row.</p>
 * @param context the application or service context
 * @param layoutTemplateResId the layout template file, containing no keys.
 * @param characters the list of characters to display on the keyboard. One key will be created
 * for each character.
 * @param columns the number of columns of keys to display. If this number is greater than the
 * number of keys that can fit in a row, it will be ignored. If this number is -1, the
 * keyboard will fit as many keys as possible in each row.
 * @apiSince 3
 */

@Deprecated
public Keyboard(android.content.Context context, int layoutTemplateResId, java.lang.CharSequence characters, int columns, int horizontalPadding) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public java.util.List<android.inputmethodservice.Keyboard.Key> getKeys() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public java.util.List<android.inputmethodservice.Keyboard.Key> getModifierKeys() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
protected int getHorizontalGap() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
protected void setHorizontalGap(int gap) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
protected int getVerticalGap() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
protected void setVerticalGap(int gap) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
protected int getKeyHeight() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
protected void setKeyHeight(int height) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
protected int getKeyWidth() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
protected void setKeyWidth(int width) { throw new RuntimeException("Stub!"); }

/**
 * Returns the total height of the keyboard
 * @return the total height of the keyboard
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public int getMinWidth() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public boolean setShifted(boolean shiftState) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public boolean isShifted() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public int getShiftKeyIndex() { throw new RuntimeException("Stub!"); }

/**
 * Returns the indices of the keys that are closest to the given point.
 * @param x the x-coordinate of the point
 * @param y the y-coordinate of the point
 * @return the array of integer indices for the nearest keys to the given point. If the given
 * point is out of range, then an array of size zero is returned.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public int[] getNearestKeys(int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
protected android.inputmethodservice.Keyboard.Row createRowFromXml(android.content.res.Resources res, android.content.res.XmlResourceParser parser) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
protected android.inputmethodservice.Keyboard.Key createKeyFromXml(android.content.res.Resources res, android.inputmethodservice.Keyboard.Row parent, int x, int y, android.content.res.XmlResourceParser parser) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public static final int EDGE_BOTTOM = 8; // 0x8

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public static final int EDGE_LEFT = 1; // 0x1

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public static final int EDGE_RIGHT = 2; // 0x2

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public static final int EDGE_TOP = 4; // 0x4

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public static final int KEYCODE_ALT = -6; // 0xfffffffa

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public static final int KEYCODE_CANCEL = -3; // 0xfffffffd

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public static final int KEYCODE_DELETE = -5; // 0xfffffffb

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public static final int KEYCODE_DONE = -4; // 0xfffffffc

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public static final int KEYCODE_MODE_CHANGE = -2; // 0xfffffffe

/**
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public static final int KEYCODE_SHIFT = -1; // 0xffffffff
/**
 * Class for describing the position and characteristics of a single key in the keyboard.
 *
 * @attr ref android.R.styleable#Keyboard_keyWidth
 * @attr ref android.R.styleable#Keyboard_keyHeight
 * @attr ref android.R.styleable#Keyboard_horizontalGap
 * @attr ref android.R.styleable#Keyboard_Key_codes
 * @attr ref android.R.styleable#Keyboard_Key_keyIcon
 * @attr ref android.R.styleable#Keyboard_Key_keyLabel
 * @attr ref android.R.styleable#Keyboard_Key_iconPreview
 * @attr ref android.R.styleable#Keyboard_Key_isSticky
 * @attr ref android.R.styleable#Keyboard_Key_isRepeatable
 * @attr ref android.R.styleable#Keyboard_Key_isModifier
 * @attr ref android.R.styleable#Keyboard_Key_popupKeyboard
 * @attr ref android.R.styleable#Keyboard_Key_popupCharacters
 * @attr ref android.R.styleable#Keyboard_Key_keyOutputText
 * @attr ref android.R.styleable#Keyboard_Key_keyEdgeFlags
 * @apiSince 3
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class Key {

/**
 * Create an empty key with no attributes.
 * @apiSince 3
 */

@Deprecated
public Key(android.inputmethodservice.Keyboard.Row parent) { throw new RuntimeException("Stub!"); }

/** Create a key with the given top-left coordinate and extract its attributes from
 * the XML parser.
 * @param res resources associated with the caller's context
 * @param parent the row that this key belongs to. The row must already be attached to
 * a {@link android.inputmethodservice.Keyboard Keyboard}.
 * @param x the x coordinate of the top-left
 * @param y the y coordinate of the top-left
 * @param parser the XML parser containing the attributes for this key
 * @apiSince 3
 */

@Deprecated
public Key(android.content.res.Resources res, android.inputmethodservice.Keyboard.Row parent, int x, int y, android.content.res.XmlResourceParser parser) { throw new RuntimeException("Stub!"); }

/**
 * Informs the key that it has been pressed, in case it needs to change its appearance or
 * state.
 * @see #onReleased(boolean)
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public void onPressed() { throw new RuntimeException("Stub!"); }

/**
 * Changes the pressed state of the key.
 *
 * <p>Toggled state of the key will be flipped when all the following conditions are
 * fulfilled:</p>
 *
 * <ul>
 *     <li>This is a sticky key, that is, {@link #sticky} is {@code true}.
 *     <li>The parameter {@code inside} is {@code true}.
 *     <li>{@link android.os.Build.VERSION#SDK_INT} is greater than
 *         {@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1}.
 * </ul>
 *
 * @param inside whether the finger was released inside the key. Works only on Android M and
 * later. See the method document for details.
 * @see #onPressed()
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public void onReleased(boolean inside) { throw new RuntimeException("Stub!"); }

/**
 * Detects if a point falls inside this key.
 * @param x the x-coordinate of the point
 * @param y the y-coordinate of the point
 * @return whether or not the point falls inside the key. If the key is attached to an edge,
 * it will assume that all points between the key and the edge are considered to be inside
 * the key.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public boolean isInside(int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * Returns the square of the distance between the center of the key and the given point.
 * @param x the x-coordinate of the point
 * @param y the y-coordinate of the point
 * @return the square of the distance of the point from the center of the key
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public int squaredDistanceFrom(int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * Returns the drawable state for the key, based on the current state and type of the key.
 * @return the drawable state of the key.
 * @see android.graphics.drawable.StateListDrawable#setState(int[])
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public int[] getCurrentDrawableState() { throw new RuntimeException("Stub!"); }

/** 
 * All the key codes (unicode or custom code) that this key could generate, zero'th
 * being the most important.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public int[] codes;

/** 
 * Flags that specify the anchoring to edges of the keyboard for detecting touch events
 * that are just out of the boundary of the key. This is a bit mask of
 * {@link android.inputmethodservice.Keyboard#EDGE_LEFT Keyboard#EDGE_LEFT}, {@link android.inputmethodservice.Keyboard#EDGE_RIGHT Keyboard#EDGE_RIGHT}, {@link android.inputmethodservice.Keyboard#EDGE_TOP Keyboard#EDGE_TOP} and
 * {@link android.inputmethodservice.Keyboard#EDGE_BOTTOM Keyboard#EDGE_BOTTOM}.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public int edgeFlags;

/**
 * The horizontal gap before this key
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public int gap;

/**
 * Height of the key, not including the gap
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public int height;

/**
 * Icon to display instead of a label. Icon takes precedence over a label
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public android.graphics.drawable.Drawable icon;

/**
 * Preview version of the icon, for the preview popup
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public android.graphics.drawable.Drawable iconPreview;

/**
 * Label to display
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public java.lang.CharSequence label;

/**
 * Whether this is a modifier key, such as Shift or Alt
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public boolean modifier;

/**
 * If this is a sticky key, is it on?
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public boolean on;

/**
 * Popup characters
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public java.lang.CharSequence popupCharacters;

/** 
 * If this key pops up a mini keyboard, this is the resource id for the XML layout for that
 * keyboard.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public int popupResId;

/**
 * The current pressed state of this key
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public boolean pressed;

/**
 * Whether this key repeats itself when held down
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public boolean repeatable;

/**
 * Whether this key is sticky, i.e., a toggle key
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public boolean sticky;

/**
 * Text to output when pressed. This can be multiple characters, like ".com"
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public java.lang.CharSequence text;

/**
 * Width of the key, not including the gap
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public int width;

/**
 * X coordinate of the key in the keyboard layout
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public int x;

/**
 * Y coordinate of the key in the keyboard layout
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public int y;
}

/**
 * Container for keys in the keyboard. All keys in a row are at the same Y-coordinate.
 * Some of the key size defaults can be overridden per row from what the {@link android.inputmethodservice.Keyboard Keyboard}
 * defines.
 * @attr ref android.R.styleable#Keyboard_keyWidth
 * @attr ref android.R.styleable#Keyboard_keyHeight
 * @attr ref android.R.styleable#Keyboard_horizontalGap
 * @attr ref android.R.styleable#Keyboard_verticalGap
 * @attr ref android.R.styleable#Keyboard_Row_rowEdgeFlags
 * @attr ref android.R.styleable#Keyboard_Row_keyboardMode
 * @apiSince 3
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class Row {

/** @apiSince 3 */

@Deprecated
public Row(android.inputmethodservice.Keyboard parent) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

@Deprecated
public Row(android.content.res.Resources res, android.inputmethodservice.Keyboard parent, android.content.res.XmlResourceParser parser) { throw new RuntimeException("Stub!"); }

/**
 * Default height of a key in this row.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public int defaultHeight;

/**
 * Default horizontal gap between keys in this row.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public int defaultHorizontalGap;

/**
 * Default width of a key in this row.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public int defaultWidth;

/**
 * The keyboard mode for this row
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public int mode;

/**
 * Edge flags for this row of keys. Possible values that can be assigned are
 * {@link android.inputmethodservice.Keyboard#EDGE_TOP Keyboard#EDGE_TOP} and {@link android.inputmethodservice.Keyboard#EDGE_BOTTOM Keyboard#EDGE_BOTTOM}
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public int rowEdgeFlags;

/**
 * Vertical gap following this row.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public int verticalGap;
}

}

