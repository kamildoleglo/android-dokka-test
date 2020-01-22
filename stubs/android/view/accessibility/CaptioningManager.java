/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.view.accessibility;

import android.graphics.Typeface;

/**
 * Contains methods for accessing and monitoring preferred video captioning state and visual
 * properties.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CaptioningManager {

CaptioningManager() { throw new RuntimeException("Stub!"); }

/**
 * @return the user's preferred captioning enabled state
 * @apiSince 19
 */

public final boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * @return the locale for the user's preferred captioning language, or null
 *         if not specified
 * @apiSince 19
 */

@androidx.annotation.Nullable
public final java.util.Locale getLocale() { throw new RuntimeException("Stub!"); }

/**
 * @return the user's preferred font scaling factor for video captions, or 1 if not
 *         specified
 * @apiSince 19
 */

public final float getFontScale() { throw new RuntimeException("Stub!"); }

/**
 * @return the user's preferred visual properties for captions as a
 *         {@link android.view.accessibility.CaptioningManager.CaptionStyle CaptionStyle}, or the default style if not specified
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.view.accessibility.CaptioningManager.CaptionStyle getUserStyle() { throw new RuntimeException("Stub!"); }

/**
 * Adds a listener for changes in the user's preferred captioning enabled
 * state and visual properties.
 *
 * @param listener the listener to add
 
 * This value must never be {@code null}.
 * @apiSince 19
 */

public void addCaptioningChangeListener(@androidx.annotation.NonNull android.view.accessibility.CaptioningManager.CaptioningChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Removes a listener previously added using
 * {@link #addCaptioningChangeListener}.
 *
 * @param listener the listener to remove
 
 * This value must never be {@code null}.
 * @apiSince 19
 */

public void removeCaptioningChangeListener(@androidx.annotation.NonNull android.view.accessibility.CaptioningManager.CaptioningChangeListener listener) { throw new RuntimeException("Stub!"); }
/**
 * Specifies visual properties for video captions, including foreground and
 * background colors, edge properties, and typeface.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CaptionStyle {

private CaptionStyle() { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the user has specified a background color
 *         that should override the application default, {@code false}
 *         otherwise
 * @apiSince 21
 */

public boolean hasBackgroundColor() { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the user has specified a foreground color
 *         that should override the application default, {@code false}
 *         otherwise
 * @apiSince 21
 */

public boolean hasForegroundColor() { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the user has specified an edge type that
 *         should override the application default, {@code false}
 *         otherwise
 * @apiSince 21
 */

public boolean hasEdgeType() { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the user has specified an edge color that
 *         should override the application default, {@code false}
 *         otherwise
 * @apiSince 21
 */

public boolean hasEdgeColor() { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the user has specified a window color that
 *         should override the application default, {@code false}
 *         otherwise
 * @apiSince 21
 */

public boolean hasWindowColor() { throw new RuntimeException("Stub!"); }

/**
 * @return the preferred {@link android.graphics.Typeface Typeface} for video captions, or null if
 *         not specified
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.graphics.Typeface getTypeface() { throw new RuntimeException("Stub!"); }

/**
 * Edge type value specifying depressed bevel character edges.
 * @apiSince 21
 */

public static final int EDGE_TYPE_DEPRESSED = 4; // 0x4

/**
 * Edge type value specifying drop-shadowed character edges.
 * @apiSince 19
 */

public static final int EDGE_TYPE_DROP_SHADOW = 2; // 0x2

/**
 * Edge type value specifying no character edges.
 * @apiSince 19
 */

public static final int EDGE_TYPE_NONE = 0; // 0x0

/**
 * Edge type value specifying uniformly outlined character edges.
 * @apiSince 19
 */

public static final int EDGE_TYPE_OUTLINE = 1; // 0x1

/**
 * Edge type value specifying raised bevel character edges.
 * @apiSince 21
 */

public static final int EDGE_TYPE_RAISED = 3; // 0x3

/**
 * Unspecified edge type value.
 * @apiSince 21
 */

public static final int EDGE_TYPE_UNSPECIFIED = -1; // 0xffffffff

/**
 * The preferred background color for video captions.
 * @apiSince 19
 */

public final int backgroundColor;
{ backgroundColor = 0; }

/**
 * The preferred edge color for video captions, if using an edge type
 * other than {@link #EDGE_TYPE_NONE}.
 * @apiSince 19
 */

public final int edgeColor;
{ edgeColor = 0; }

/**
 * The preferred edge type for video captions, one of:
 * <ul>
 * <li>{@link #EDGE_TYPE_UNSPECIFIED}
 * <li>{@link #EDGE_TYPE_NONE}
 * <li>{@link #EDGE_TYPE_OUTLINE}
 * <li>{@link #EDGE_TYPE_DROP_SHADOW}
 * <li>{@link #EDGE_TYPE_RAISED}
 * <li>{@link #EDGE_TYPE_DEPRESSED}
 * </ul>
 * @apiSince 19
 */

public final int edgeType;
{ edgeType = 0; }

/**
 * The preferred foreground color for video captions.
 * @apiSince 19
 */

public final int foregroundColor;
{ foregroundColor = 0; }

/**
 * The preferred window color for video captions.
 * @apiSince 21
 */

public final int windowColor;
{ windowColor = 0; }
}

/**
 * Listener for changes in captioning properties, including enabled state
 * and user style preferences.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class CaptioningChangeListener {

public CaptioningChangeListener() { throw new RuntimeException("Stub!"); }

/**
 * Called when the captioning enabled state changes.
 *
 * @param enabled the user's new preferred captioning enabled state
 * @apiSince 19
 */

public void onEnabledChanged(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Called when the captioning user style changes.
 *
 * @param userStyle the user's new preferred style
 * This value must never be {@code null}.
 * @see android.view.accessibility.CaptioningManager#getUserStyle()
 * @apiSince 19
 */

public void onUserStyleChanged(@androidx.annotation.NonNull android.view.accessibility.CaptioningManager.CaptionStyle userStyle) { throw new RuntimeException("Stub!"); }

/**
 * Called when the captioning locale changes.
 *
 * @param locale the preferred captioning locale, or {@code null} if not specified
 * This value may be {@code null}.
 * @see android.view.accessibility.CaptioningManager#getLocale()
 * @apiSince 19
 */

public void onLocaleChanged(@androidx.annotation.Nullable java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Called when the captioning font scaling factor changes.
 *
 * @param fontScale the preferred font scaling factor
 * @see android.view.accessibility.CaptioningManager#getFontScale()
 * @apiSince 19
 */

public void onFontScaleChanged(float fontScale) { throw new RuntimeException("Stub!"); }
}

}

