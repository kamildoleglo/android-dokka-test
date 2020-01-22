/*
 * Copyright 2017 The Android Open Source Project
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

import android.graphics.Rect;
import android.graphics.Insets;

/**
 * Represents the area of the display that is not functional for displaying content.
 *
 * <p>{@code DisplayCutout} is immutable.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DisplayCutout {

/**
 * Creates a DisplayCutout instance.
 *
 * <p>Note that this is only useful for tests. For production code, developers should always
 * use a {@link android.view.DisplayCutout DisplayCutout} obtained from the system.</p>
 *
 * @param safeInsets the insets from each edge which avoid the display cutout as returned by
 *                   {@link #getSafeInsetTop()} etc.
 * This value must never be {@code null}.
 * @param boundLeft the left bounding rect of the display cutout in pixels. If null is passed,
 *                  it's treated as an empty rectangle (0,0)-(0,0).
 * This value may be {@code null}.
 * @param boundTop the top bounding rect of the display cutout in pixels.  If null is passed,
 *                  it's treated as an empty rectangle (0,0)-(0,0).
 * This value may be {@code null}.
 * @param boundRight the right bounding rect of the display cutout in pixels.  If null is
 *                  passed, it's treated as an empty rectangle (0,0)-(0,0).
 * This value may be {@code null}.
 * @param boundBottom the bottom bounding rect of the display cutout in pixels.  If null is
 *                   passed, it's treated as an empty rectangle (0,0)-(0,0).
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public DisplayCutout(@androidx.annotation.NonNull android.graphics.Insets safeInsets, @androidx.annotation.Nullable android.graphics.Rect boundLeft, @androidx.annotation.Nullable android.graphics.Rect boundTop, @androidx.annotation.Nullable android.graphics.Rect boundRight, @androidx.annotation.Nullable android.graphics.Rect boundBottom) { throw new RuntimeException("Stub!"); }

/**
 * Creates a DisplayCutout instance.
 *
 * <p>Note that this is only useful for tests. For production code, developers should always
 * use a {@link android.view.DisplayCutout DisplayCutout} obtained from the system.</p>
 *
 * @param safeInsets the insets from each edge which avoid the display cutout as returned by
 *                   {@link #getSafeInsetTop()} etc.
 * This value may be {@code null}.
 * @param boundingRects the bounding rects of the display cutouts as returned by
 *               {@link #getBoundingRects()} ()}.
 * This value may be {@code null}.
 * @deprecated Use {@link android.view.DisplayCutout#DisplayCutout(android.graphics.Insets,android.graphics.Rect,android.graphics.Rect,android.graphics.Rect,android.graphics.Rect) DisplayCutout#DisplayCutout(Insets, Rect, Rect, Rect, Rect)} instead.
 * @apiSince 28
 */

@Deprecated
public DisplayCutout(@androidx.annotation.Nullable android.graphics.Rect safeInsets, @androidx.annotation.Nullable java.util.List<android.graphics.Rect> boundingRects) { throw new RuntimeException("Stub!"); }

/**
 * Returns the inset from the top which avoids the display cutout in pixels.
 * @apiSince 28
 */

public int getSafeInsetTop() { throw new RuntimeException("Stub!"); }

/**
 * Returns the inset from the bottom which avoids the display cutout in pixels.
 * @apiSince 28
 */

public int getSafeInsetBottom() { throw new RuntimeException("Stub!"); }

/**
 * Returns the inset from the left which avoids the display cutout in pixels.
 * @apiSince 28
 */

public int getSafeInsetLeft() { throw new RuntimeException("Stub!"); }

/**
 * Returns the inset from the right which avoids the display cutout in pixels.
 * @apiSince 28
 */

public int getSafeInsetRight() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of {@code Rect}s, each of which is the bounding rectangle for a non-functional
 * area on the display.
 *
 * There will be at most one non-functional area per short edge of the device, and none on
 * the long edges.
 *
 * @return a list of bounding {@code Rect}s, one for each display cutout area. No empty Rect is
 * returned.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.List<android.graphics.Rect> getBoundingRects() { throw new RuntimeException("Stub!"); }

/**
 * Returns a bounding rectangle for a non-functional area on the display which is located on
 * the left of the screen.
 *
 * @return bounding rectangle in pixels. In case of no bounding rectangle, an empty rectangle
 * is returned.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Rect getBoundingRectLeft() { throw new RuntimeException("Stub!"); }

/**
 * Returns a bounding rectangle for a non-functional area on the display which is located on
 * the top of the screen.
 *
 * @return bounding rectangle in pixels. In case of no bounding rectangle, an empty rectangle
 * is returned.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Rect getBoundingRectTop() { throw new RuntimeException("Stub!"); }

/**
 * Returns a bounding rectangle for a non-functional area on the display which is located on
 * the right of the screen.
 *
 * @return bounding rectangle in pixels. In case of no bounding rectangle, an empty rectangle
 * is returned.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Rect getBoundingRectRight() { throw new RuntimeException("Stub!"); }

/**
 * Returns a bounding rectangle for a non-functional area on the display which is located on
 * the bottom of the screen.
 *
 * @return bounding rectangle in pixels. In case of no bounding rectangle, an empty rectangle
 * is returned.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Rect getBoundingRectBottom() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

