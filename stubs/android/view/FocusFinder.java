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


/**
 * The algorithm used for finding the next focusable view in a given direction
 * from a view that currently has focus.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class FocusFinder {

private FocusFinder() { throw new RuntimeException("Stub!"); }

/**
 * Get the focus finder for this thread.
 * @apiSince 1
 */

public static android.view.FocusFinder getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Find the next view to take focus in root's descendants, starting from the view
 * that currently is focused.
 * @param root Contains focused. Cannot be null.
 * @param focused Has focus now.
 * @param direction Direction to look.
 * @return The next focusable view, or null if none exists.
 * @apiSince 1
 */

public final android.view.View findNextFocus(android.view.ViewGroup root, android.view.View focused, int direction) { throw new RuntimeException("Stub!"); }

/**
 * Find the next view to take focus in root's descendants, searching from
 * a particular rectangle in root's coordinates.
 * @param root Contains focusedRect. Cannot be null.
 * @param focusedRect The starting point of the search.
 * @param direction Direction to look.
 * @return The next focusable view, or null if none exists.
 * @apiSince 1
 */

public android.view.View findNextFocusFromRect(android.view.ViewGroup root, android.graphics.Rect focusedRect, int direction) { throw new RuntimeException("Stub!"); }

/**
 * Find the root of the next keyboard navigation cluster after the current one.
 * @param root The view tree to look inside. Cannot be null
 * This value must never be {@code null}.
 * @param currentCluster The starting point of the search. Null means the default cluster
 * This value may be {@code null}.
 * @param direction Direction to look
 * Value is {@link android.view.View#FOCUS_BACKWARD}, {@link android.view.View#FOCUS_FORWARD}, {@link android.view.View#FOCUS_LEFT}, {@link android.view.View#FOCUS_UP}, {@link android.view.View#FOCUS_RIGHT}, or {@link android.view.View#FOCUS_DOWN}
 * @return The next cluster, or null if none exists
 * @apiSince 26
 */

public android.view.View findNextKeyboardNavigationCluster(@androidx.annotation.NonNull android.view.View root, @androidx.annotation.Nullable android.view.View currentCluster, int direction) { throw new RuntimeException("Stub!"); }

/**
 * Find the nearest touchable view to the specified view.
 *
 * @param root The root of the tree in which to search
 * @param x X coordinate from which to start the search
 * @param y Y coordinate from which to start the search
 * @param direction Direction to look
 * @param deltas Offset from the <x, y> to the edge of the nearest view. Note that this array
 *        may already be populated with values.
 * @return The nearest touchable view, or null if none exists.
 * @apiSince 1
 */

public android.view.View findNearestTouchable(android.view.ViewGroup root, int x, int y, int direction, int[] deltas) { throw new RuntimeException("Stub!"); }
}

