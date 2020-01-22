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


package android.widget;

import android.view.Gravity;
import android.content.res.Resources;

/**
 * A toast is a view containing a quick little message for the user.  The toast class
 * helps you create and show those.
 * {@more}
 *
 * <p>
 * When the view is shown to the user, appears as a floating view over the
 * application.  It will never receive focus.  The user will probably be in the
 * middle of typing something else.  The idea is to be as unobtrusive as
 * possible, while still showing the user the information you want them to see.
 * Two examples are the volume control, and the brief message saying that your
 * settings have been saved.
 * <p>
 * The easiest way to use this class is to call one of the static methods that constructs
 * everything you need and returns a new Toast object.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about creating Toast notifications, read the
 * <a href="{@docRoot}guide/topics/ui/notifiers/toasts.html">Toast Notifications</a> developer
 * guide.</p>
 * </div>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Toast {

/**
 * Construct an empty Toast object.  You must call {@link #setView} before you
 * can call {@link #show}.
 *
 * @param context  The context to use.  Usually your {@link android.app.Application}
 *                 or {@link android.app.Activity} object.
 * @apiSince 1
 */

public Toast(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Show the view for the specified duration.
 * @apiSince 1
 */

public void show() { throw new RuntimeException("Stub!"); }

/**
 * Close the view if it's showing, or don't show it if it isn't showing yet.
 * You do not normally have to call this.  Normally view will disappear on its own
 * after the appropriate duration.
 * @apiSince 1
 */

public void cancel() { throw new RuntimeException("Stub!"); }

/**
 * Set the view to show.
 * @see #getView
 * @apiSince 1
 */

public void setView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Return the view.
 * @see #setView
 * @apiSince 1
 */

public android.view.View getView() { throw new RuntimeException("Stub!"); }

/**
 * Set how long to show the view for.
 * @see #LENGTH_SHORT
 * @see #LENGTH_LONG
 
 * @param duration Value is {@link android.widget.Toast#LENGTH_SHORT}, or {@link android.widget.Toast#LENGTH_LONG}
 * @apiSince 1
 */

public void setDuration(int duration) { throw new RuntimeException("Stub!"); }

/**
 * Return the duration.
 * @see #setDuration
 
 * @return Value is {@link android.widget.Toast#LENGTH_SHORT}, or {@link android.widget.Toast#LENGTH_LONG}
 * @apiSince 1
 */

public int getDuration() { throw new RuntimeException("Stub!"); }

/**
 * Set the margins of the view.
 *
 * @param horizontalMargin The horizontal margin, in percentage of the
 *        container width, between the container's edges and the
 *        notification
 * @param verticalMargin The vertical margin, in percentage of the
 *        container height, between the container's edges and the
 *        notification
 * @apiSince 1
 */

public void setMargin(float horizontalMargin, float verticalMargin) { throw new RuntimeException("Stub!"); }

/**
 * Return the horizontal margin.
 * @apiSince 1
 */

public float getHorizontalMargin() { throw new RuntimeException("Stub!"); }

/**
 * Return the vertical margin.
 * @apiSince 1
 */

public float getVerticalMargin() { throw new RuntimeException("Stub!"); }

/**
 * Set the location at which the notification should appear on the screen.
 * @see android.view.Gravity
 * @see #getGravity
 * @apiSince 1
 */

public void setGravity(int gravity, int xOffset, int yOffset) { throw new RuntimeException("Stub!"); }

/**
 * Get the location at which the notification should appear on the screen.
 * @see android.view.Gravity
 * @see #getGravity
 * @apiSince 1
 */

public int getGravity() { throw new RuntimeException("Stub!"); }

/**
 * Return the X offset in pixels to apply to the gravity's location.
 * @apiSince 1
 */

public int getXOffset() { throw new RuntimeException("Stub!"); }

/**
 * Return the Y offset in pixels to apply to the gravity's location.
 * @apiSince 1
 */

public int getYOffset() { throw new RuntimeException("Stub!"); }

/**
 * Make a standard toast that just contains a text view.
 *
 * @param context  The context to use.  Usually your {@link android.app.Application}
 *                 or {@link android.app.Activity} object.
 * @param text     The text to show.  Can be formatted text.
 * @param duration How long to display the message.  Either {@link #LENGTH_SHORT} or
 *                 {@link #LENGTH_LONG}
 *
 
 * Value is {@link android.widget.Toast#LENGTH_SHORT}, or {@link android.widget.Toast#LENGTH_LONG}
 * @apiSince 1
 */

public static android.widget.Toast makeText(android.content.Context context, java.lang.CharSequence text, int duration) { throw new RuntimeException("Stub!"); }

/**
 * Make a standard toast that just contains a text view with the text from a resource.
 *
 * @param context  The context to use.  Usually your {@link android.app.Application}
 *                 or {@link android.app.Activity} object.
 * @param resId    The resource id of the string resource to use.  Can be formatted text.
 * @param duration How long to display the message.  Either {@link #LENGTH_SHORT} or
 *                 {@link #LENGTH_LONG}
 *
 * Value is {@link android.widget.Toast#LENGTH_SHORT}, or {@link android.widget.Toast#LENGTH_LONG}
 * @throws android.content.res.Resources.NotFoundException if the resource can't be found.
 * @apiSince 1
 */

public static android.widget.Toast makeText(android.content.Context context, int resId, int duration) throws android.content.res.Resources.NotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Update the text in a Toast that was previously created using one of the makeText() methods.
 * @param resId The new text for the Toast.
 * @apiSince 1
 */

public void setText(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Update the text in a Toast that was previously created using one of the makeText() methods.
 * @param s The new text for the Toast.
 * @apiSince 1
 */

public void setText(java.lang.CharSequence s) { throw new RuntimeException("Stub!"); }

/**
 * Show the view or text notification for a long period of time.  This time
 * could be user-definable.
 * @see #setDuration
 * @apiSince 1
 */

public static final int LENGTH_LONG = 1; // 0x1

/**
 * Show the view or text notification for a short period of time.  This time
 * could be user-definable.  This is the default.
 * @see #setDuration
 * @apiSince 1
 */

public static final int LENGTH_SHORT = 0; // 0x0
}

