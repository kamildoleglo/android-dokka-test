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


package android.graphics.drawable;

import android.view.View;

/**
 * A helper class that contains several {@link android.graphics.drawable.Drawable Drawable}s and selects which one to use.
 *
 * You can subclass it to create your own DrawableContainers or directly use one its child classes.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DrawableContainer extends android.graphics.drawable.Drawable implements android.graphics.drawable.Drawable.Callback {

public DrawableContainer() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @apiSince 1
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean getPadding(android.graphics.Rect padding) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public android.graphics.Insets getOpticalInsets() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param outline This value must never be {@code null}.
 * @apiSince 21
 */

public void getOutline(@androidx.annotation.NonNull android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int getAlpha() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setDither(boolean dither) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setColorFilter(android.graphics.ColorFilter colorFilter) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setTintList(android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param blendMode This value must never be {@code null}.
 * @apiSince 29
 */

public void setTintBlendMode(@androidx.annotation.NonNull android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/**
 * Change the global fade duration when a new drawable is entering
 * the scene.
 *
 * @param ms The amount of time to fade in milliseconds.
 * @apiSince 11
 */

public void setEnterFadeDuration(int ms) { throw new RuntimeException("Stub!"); }

/**
 * Change the global fade duration when a new drawable is leaving
 * the scene.
 *
 * @param ms The amount of time to fade in milliseconds.
 * @apiSince 11
 */

public void setExitFadeDuration(int ms) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onBoundsChange(android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isStateful() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void setAutoMirrored(boolean mirrored) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public boolean isAutoMirrored() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void jumpToCurrentState() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setHotspot(float x, float y) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setHotspotBounds(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void getHotspotBounds(android.graphics.Rect outRect) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean onStateChange(int[] state) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean onLevelChange(int level) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param layoutDirection Value is {@link android.view.View#LAYOUT_DIRECTION_LTR}, or {@link android.view.View#LAYOUT_DIRECTION_RTL}
 * @apiSince 23
 */

public boolean onLayoutDirectionChanged(int layoutDirection) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIntrinsicWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIntrinsicHeight() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getMinimumWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getMinimumHeight() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param who This value must never be {@code null}.
 * @apiSince 1
 */

public void invalidateDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param who This value must never be {@code null}.
 
 * @param what This value must never be {@code null}.
 * @apiSince 1
 */

public void scheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who, @androidx.annotation.NonNull java.lang.Runnable what, long when) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param who This value must never be {@code null}.
 
 * @param what This value must never be {@code null}.
 * @apiSince 1
 */

public void unscheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who, @androidx.annotation.NonNull java.lang.Runnable what) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean setVisible(boolean visible, boolean restart) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getOpacity() { throw new RuntimeException("Stub!"); }

/**
 * Sets the currently displayed drawable by index.
 * <p>
 * If an invalid index is specified, the current drawable will be set to
 * {@code null} and the index will be set to {@code -1}.
 *
 * @param index the index of the drawable to display
 * @return {@code true} if the drawable changed, {@code false} otherwise
 * @apiSince 1
 */

public boolean selectDrawable(int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.graphics.drawable.Drawable getCurrent() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void applyTheme(android.content.res.Resources.Theme theme) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void setConstantState(android.graphics.drawable.DrawableContainer.DrawableContainerState state) { throw new RuntimeException("Stub!"); }
/**
 * A ConstantState that can contain several {@link android.graphics.drawable.Drawable Drawable}s.
 *
 * This class was made public to enable testing, and its visibility may change in a future
 * release.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class DrawableContainerState extends android.graphics.drawable.Drawable.ConstantState {

DrawableContainerState() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @apiSince 1
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * Adds the drawable to the end of the list of contained drawables.
 *
 * @param dr the drawable to add
 * @return the position of the drawable within the container
 * @apiSince 1
 */

public final int addChild(android.graphics.drawable.Drawable dr) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final int getChildCount() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final android.graphics.drawable.Drawable[] getChildren() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public final android.graphics.drawable.Drawable getChild(int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }

/**
 * A boolean value indicating whether to use the maximum padding value
 * of all frames in the set (false), or to use the padding value of the
 * frame being shown (true). Default value is false.
 * @apiSince 1
 */

public final void setVariablePadding(boolean variable) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final android.graphics.Rect getConstantPadding() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final void setConstantSize(boolean constant) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final boolean isConstantSize() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final int getConstantWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final int getConstantHeight() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final int getConstantMinimumWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final int getConstantMinimumHeight() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected void computeConstantSize() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public final void setEnterFadeDuration(int duration) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public final int getEnterFadeDuration() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public final void setExitFadeDuration(int duration) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public final int getExitFadeDuration() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final int getOpacity() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final boolean isStateful() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void growArray(int oldSize, int newSize) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public synchronized boolean canConstantState() { throw new RuntimeException("Stub!"); }
}

}

