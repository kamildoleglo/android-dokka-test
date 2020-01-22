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

package android.view;

import android.graphics.drawable.Drawable;

/**
 * An overlay is an extra layer that sits on top of a View (the "host view")
 * which is drawn after all other content in that view (including children,
 * if the view is a ViewGroup). Interaction with the overlay layer is done
 * by adding and removing drawables.
 *
 * <p>An overlay requested from a ViewGroup is of type {@link android.view.ViewGroupOverlay ViewGroupOverlay},
 * which also supports adding and removing views.</p>
 *
 * @see android.view.View#getOverlay() View.getOverlay()
 * @see android.view.ViewGroup#getOverlay() ViewGroup.getOverlay()
 * @see android.view.ViewGroupOverlay
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ViewOverlay {

ViewOverlay() { throw new RuntimeException("Stub!"); }

/**
 * Adds a {@link android.graphics.drawable.Drawable Drawable} to the overlay. The bounds of the drawable should be relative to
 * the host view. Any drawable added to the overlay should be removed when it is no longer
 * needed or no longer visible. Adding an already existing {@link android.graphics.drawable.Drawable Drawable}
 * is a no-op. Passing <code>null</code> parameter will result in an
 * {@link java.lang.IllegalArgumentException IllegalArgumentException} being thrown.
 *
 * @param drawable The {@link android.graphics.drawable.Drawable Drawable} to be added to the overlay. This drawable will be
 * drawn when the view redraws its overlay. {@link android.graphics.drawable.Drawable Drawable}s will be drawn in the order that
 * they were added.
 * This value must never be {@code null}.
 * @see #remove(Drawable)
 * @apiSince 18
 */

public void add(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Removes the specified {@link android.graphics.drawable.Drawable Drawable} from the overlay. Removing a {@link android.graphics.drawable.Drawable Drawable} that was
 * not added with {@link #add(android.graphics.drawable.Drawable)} is a no-op. Passing <code>null</code> parameter will
 * result in an {@link java.lang.IllegalArgumentException IllegalArgumentException} being thrown.
 *
 * @param drawable The {@link android.graphics.drawable.Drawable Drawable} to be removed from the overlay.
 * This value must never be {@code null}.
 * @see #add(Drawable)
 * @apiSince 18
 */

public void remove(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Removes all content from the overlay.
 * @apiSince 18
 */

public void clear() { throw new RuntimeException("Stub!"); }
}

