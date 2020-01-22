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


package android.widget;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/**
 * {@link android.widget.ViewSwitcher ViewSwitcher} that switches between two ImageViews when a new
 * image is set on it. The views added to an ImageSwitcher must all be
 * {@link android.widget.ImageView ImageView}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ImageSwitcher extends android.widget.ViewSwitcher {

/**
 * Creates a new empty ImageSwitcher.
 *
 * @param context the application's environment
 * @apiSince 1
 */

public ImageSwitcher(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new empty ImageSwitcher for the given context and with the
 * specified set attributes.
 *
 * @param context the application environment
 * @param attrs a collection of attributes
 * @apiSince 1
 */

public ImageSwitcher(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Sets a new image on the ImageSwitcher with the given resource id.
 * This will set that image resource on the next ImageView in the switcher and will
 * then switch to that view.
 *
 * @param resid a Drawable resource id
 *
 * @see android.widget.ImageView#setImageResource(int)
 * @apiSince 1
 */

public void setImageResource(int resid) { throw new RuntimeException("Stub!"); }

/**
 * Sets a new image on the ImageSwitcher with the given Uri.
 * This will set that image on the next ImageView in the switcher and will
 * then switch to that view.
 *
 * @param uri the Uri of an image
 *
 * @see android.widget.ImageView#setImageURI(Uri)
 * @apiSince 1
 */

public void setImageURI(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Sets a new drawable on the ImageSwitcher.
 * This will set that drawable on the next ImageView in the switcher and will
 * then switch to that view.
 *
 * @param drawable the drawable to be set or {@code null} to clear the content
 *
 * @see android.widget.ImageView#setImageDrawable(Drawable)
 * @apiSince 1
 */

public void setImageDrawable(android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
}

