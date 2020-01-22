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

import android.content.res.Resources;

/**
 * A resource that manages a number of alternate Drawables, each assigned a maximum numerical value.
 * Setting the level value of the object with {@link #setLevel(int)} will load the image with the next
 * greater or equal value assigned to its max attribute.
 * A good example use of
 * a LevelListDrawable would be a battery level indicator icon, with different images to indicate the current
 * battery level.
 * <p>
 * It can be defined in an XML file with the <code>&lt;level-list></code> element.
 * Each Drawable level is defined in a nested <code>&lt;item></code>. For example:
 * </p>
 * <pre>
 * &lt;level-list xmlns:android="http://schemas.android.com/apk/res/android">
 *  &lt;item android:maxLevel="0" android:drawable="@drawable/ic_wifi_signal_1" />
 *  &lt;item android:maxLevel="1" android:drawable="@drawable/ic_wifi_signal_2" />
 *  &lt;item android:maxLevel="2" android:drawable="@drawable/ic_wifi_signal_3" />
 *  &lt;item android:maxLevel="3" android:drawable="@drawable/ic_wifi_signal_4" />
 * &lt;/level-list>
 *</pre>
 * <p>With this XML saved into the res/drawable/ folder of the project, it can be referenced as
 * the drawable for an {@link android.widget.ImageView}. The default image is the first in the list.
 * It can then be changed to one of the other levels with
 * {@link android.widget.ImageView#setImageLevel(int)}. For more
 * information, see the guide to <a
 * href="{@docRoot}guide/topics/resources/drawable-resource.html">Drawable Resources</a>.</p>
 *
 * @attr ref android.R.styleable#LevelListDrawableItem_minLevel
 * @attr ref android.R.styleable#LevelListDrawableItem_maxLevel
 * @attr ref android.R.styleable#LevelListDrawableItem_drawable
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LevelListDrawable extends android.graphics.drawable.DrawableContainer {

/** @apiSince 1 */

public LevelListDrawable() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void addLevel(int low, int high, android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean onLevelChange(int level) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void inflate(android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs, android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param state This value must never be {@code null}.
 * @apiSince 1
 */

protected void setConstantState(@androidx.annotation.NonNull android.graphics.drawable.DrawableContainer.DrawableContainerState state) { throw new RuntimeException("Stub!"); }
}

