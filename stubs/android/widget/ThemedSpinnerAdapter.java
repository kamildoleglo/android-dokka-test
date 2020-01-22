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


package android.widget;

import android.view.ViewGroup;
import android.content.res.Resources.Theme;
import android.view.View;
import android.content.res.Resources;

/**
 * An extension of SpinnerAdapter that is capable of inflating drop-down views
 * against a different theme than normal views.
 * <p>
 * Classes that implement this interface should use the theme provided to
 * {@link #setDropDownViewTheme(android.content.res.Resources.Theme)} when creating views in
 * {@link android.widget.SpinnerAdapter#getDropDownView(int,android.view.View,android.view.ViewGroup) SpinnerAdapter#getDropDownView(int, View, ViewGroup)}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface ThemedSpinnerAdapter extends android.widget.SpinnerAdapter {

/**
 * Sets the {@link android.content.res.Resources.Theme Resources.Theme} against which drop-down views are
 * inflated.
 *
 * @param theme the context against which to inflate drop-down views, or
 *              {@code null} to use the default theme
 * This value may be {@code null}.
 * @see android.widget.SpinnerAdapter#getDropDownView(int, View, ViewGroup)
 * @apiSince 23
 */

public void setDropDownViewTheme(@androidx.annotation.Nullable android.content.res.Resources.Theme theme);

/**
 * Returns the value previously set by a call to
 * {@link #setDropDownViewTheme(android.content.res.Resources.Theme)}.
 *
 * @return the {@link android.content.res.Resources.Theme Resources.Theme} against which drop-down views are
 *         inflated, or {@code null} if one has not been explicitly set
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.content.res.Resources.Theme getDropDownViewTheme();
}

