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

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.content.res.Resources;
import android.graphics.Rect;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.graphics.BlendModeColorFilter;
import android.graphics.PorterDuff;
import android.graphics.BlendMode;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PixelFormat;
import android.graphics.Region;
import android.graphics.Outline;
import android.content.res.Resources.Theme;
import org.xmlpull.v1.XmlPullParser;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;

/**
 * A Drawable is a general abstraction for "something that can be drawn."  Most
 * often you will deal with Drawable as the type of resource retrieved for
 * drawing things to the screen; the Drawable class provides a generic API for
 * dealing with an underlying visual resource that may take a variety of forms.
 * Unlike a {@link android.view.View}, a Drawable does not have any facility to
 * receive events or otherwise interact with the user.
 *
 * <p>In addition to simple drawing, Drawable provides a number of generic
 * mechanisms for its client to interact with what is being drawn:
 *
 * <ul>
 *     <li> The {@link #setBounds} method <var>must</var> be called to tell the
 *     Drawable where it is drawn and how large it should be.  All Drawables
 *     should respect the requested size, often simply by scaling their
 *     imagery.  A client can find the preferred size for some Drawables with
 *     the {@link #getIntrinsicHeight} and {@link #getIntrinsicWidth} methods.
 *
 *     <li> The {@link #getPadding} method can return from some Drawables
 *     information about how to frame content that is placed inside of them.
 *     For example, a Drawable that is intended to be the frame for a button
 *     widget would need to return padding that correctly places the label
 *     inside of itself.
 *
 *     <li> The {@link #setState} method allows the client to tell the Drawable
 *     in which state it is to be drawn, such as "focused", "selected", etc.
 *     Some drawables may modify their imagery based on the selected state.
 *
 *     <li> The {@link #setLevel} method allows the client to supply a single
 *     continuous controller that can modify the Drawable is displayed, such as
 *     a battery level or progress level.  Some drawables may modify their
 *     imagery based on the current level.
 *
 *     <li> A Drawable can perform animations by calling back to its client
 *     through the {@link android.graphics.drawable.Drawable.Callback Callback} interface.  All clients should support this
 *     interface (via {@link #setCallback}) so that animations will work.  A
 *     simple way to do this is through the system facilities such as
 *     {@link android.view.View#setBackground(Drawable)} and
 *     {@link android.widget.ImageView}.
 * </ul>
 *
 * Though usually not visible to the application, Drawables may take a variety
 * of forms:
 *
 * <ul>
 *     <li> <b>Bitmap</b>: the simplest Drawable, a PNG or JPEG image.
 *     <li> <b>Nine Patch</b>: an extension to the PNG format allows it to
 *     specify information about how to stretch it and place things inside of
 *     it.
 *     <li><b>Vector</b>: a drawable defined in an XML file as a set of points,
 *     lines, and curves along with its associated color information. This type
 *     of drawable can be scaled without loss of display quality.
 *     <li> <b>Shape</b>: contains simple drawing commands instead of a raw
 *     bitmap, allowing it to resize better in some cases.
 *     <li> <b>Layers</b>: a compound drawable, which draws multiple underlying
 *     drawables on top of each other.
 *     <li> <b>States</b>: a compound drawable that selects one of a set of
 *     drawables based on its state.
 *     <li> <b>Levels</b>: a compound drawable that selects one of a set of
 *     drawables based on its level.
 *     <li> <b>Scale</b>: a compound drawable with a single child drawable,
 *     whose overall size is modified based on the current level.
 * </ul>
 *
 * <a name="Custom"></a>
 * <h3>Custom drawables</h3>
 *
 * <p>
 * All versions of Android allow the Drawable class to be extended and used at
 * run time in place of framework-provided drawable classes. Starting in
 * {@link android.os.Build.VERSION_CODES#N API 24}, custom drawables classes
 * may also be used in XML.
 * <p>
 * <strong>Note:</strong> Custom drawable classes are only accessible from
 * within your application package. Other applications will not be able to load
 * them.
 * <p>
 * At a minimum, custom drawable classes must implement the abstract methods on
 * Drawable and should override the {@link android.graphics.drawable.Drawable#draw(android.graphics.Canvas) Drawable#draw(Canvas)} method to
 * draw content.
 * <p>
 * Custom drawables classes may be used in XML in multiple ways:
 * <ul>
 *     <li>
 *         Using the fully-qualified class name as the XML element name. For
 *         this method, the custom drawable class must be a public top-level
 *         class.
 * <pre>
 * &lt;com.myapp.MyCustomDrawable xmlns:android="http://schemas.android.com/apk/res/android"
 *     android:color="#ffff0000" /&gt;
 * </pre>
 *     </li>
 *     <li>
 *         Using <em>drawable</em> as the XML element name and specifying the
 *         fully-qualified class name from the <em>class</em> attribute. This
 *         method may be used for both public top-level classes and public
 *         static inner classes.
 * <pre>
 * &lt;drawable xmlns:android="http://schemas.android.com/apk/res/android"
 *     class="com.myapp.MyTopLevelClass$InnerCustomDrawable"
 *     android:color="#ffff0000" /&gt;
 * </pre>
 *     </li>
 * </ul>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about how to use drawables, read the
 * <a href="{@docRoot}guide/topics/graphics/2d-graphics.html">Canvas and Drawables</a> developer
 * guide. For information and examples of creating drawable resources (XML or bitmap files that
 * can be loaded in code), read the
 * <a href="{@docRoot}guide/topics/resources/drawable-resource.html">Drawable Resources</a>
 * document.</p></div>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Drawable {

public Drawable() { throw new RuntimeException("Stub!"); }

/**
 * Draw in its bounds (set via setBounds) respecting optional effects such
 * as alpha (set via setAlpha) and color filter (set via setColorFilter).
 *
 * @param canvas The canvas to draw into
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public abstract void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas);

/**
 * Specify a bounding rectangle for the Drawable. This is where the drawable
 * will draw when its draw() method is called.
 * @apiSince 1
 */

public void setBounds(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Specify a bounding rectangle for the Drawable. This is where the drawable
 * will draw when its draw() method is called.
 
 * @param bounds This value must never be {@code null}.
 * @apiSince 1
 */

public void setBounds(@androidx.annotation.NonNull android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/**
 * Return a copy of the drawable's bounds in the specified Rect (allocated
 * by the caller). The bounds specify where this will draw when its draw()
 * method is called.
 *
 * @param bounds Rect to receive the drawable's bounds (allocated by the
 *               caller).
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public final void copyBounds(@androidx.annotation.NonNull android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/**
 * Return a copy of the drawable's bounds in a new Rect. This returns the
 * same values as getBounds(), but the returned object is guaranteed to not
 * be changed later by the drawable (i.e. it retains no reference to this
 * rect). If the caller already has a Rect allocated, call copyBounds(rect).
 *
 * @return A copy of the drawable's bounds
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final android.graphics.Rect copyBounds() { throw new RuntimeException("Stub!"); }

/**
 * Return the drawable's bounds Rect. Note: for efficiency, the returned
 * object may be the same object stored in the drawable (though this is not
 * guaranteed), so if a persistent copy of the bounds is needed, call
 * copyBounds(rect) instead.
 * You should also not change the object returned by this method as it may
 * be the same object stored in the drawable.
 *
 * @return The bounds of the drawable (which may change later, so caller
 *         beware). DO NOT ALTER the returned object as it may change the
 *         stored bounds of this drawable.
 *
 * This value will never be {@code null}.
 * @see #copyBounds()
 * @see #copyBounds(android.graphics.Rect)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final android.graphics.Rect getBounds() { throw new RuntimeException("Stub!"); }

/**
 * Return the drawable's dirty bounds Rect. Note: for efficiency, the
 * returned object may be the same object stored in the drawable (though
 * this is not guaranteed).
 * <p>
 * By default, this returns the full drawable bounds. Custom drawables may
 * override this method to perform more precise invalidation.
 *
 * @return The dirty bounds of this drawable
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.graphics.Rect getDirtyBounds() { throw new RuntimeException("Stub!"); }

/**
 * Set a mask of the configuration parameters for which this drawable
 * may change, requiring that it be re-created.
 *
 * @param configs A mask of the changing configuration parameters, as
 * defined by {@link android.content.pm.ActivityInfo}.
 *
 * Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @see android.content.pm.ActivityInfo
 * @apiSince 1
 */

public void setChangingConfigurations(int configs) { throw new RuntimeException("Stub!"); }

/**
 * Return a mask of the configuration parameters for which this drawable
 * may change, requiring that it be re-created.  The default implementation
 * returns whatever was provided through
 * {@link #setChangingConfigurations(int)} or 0 by default.  Subclasses
 * may extend this to or in the changing configurations of any other
 * drawables they hold.
 *
 * @return Returns a mask of the changing configuration parameters, as
 * defined by {@link android.content.pm.ActivityInfo}.
 *
 * Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @see android.content.pm.ActivityInfo
 * @apiSince 1
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * Set to true to have the drawable dither its colors when drawn to a
 * device with fewer than 8-bits per color component.
 *
 * @see android.graphics.Paint#setDither(boolean);
 * @deprecated This property is ignored.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public void setDither(boolean dither) { throw new RuntimeException("Stub!"); }

/**
 * Set to true to have the drawable filter its bitmaps with bilinear
 * sampling when they are scaled or rotated.
 *
 * <p>This can improve appearance when bitmaps are rotated. If the drawable
 * does not use bitmaps, this call is ignored.</p>
 *
 * @see #isFilterBitmap()
 * @see android.graphics.Paint#setFilterBitmap(boolean);
 * @apiSince 1
 */

public void setFilterBitmap(boolean filter) { throw new RuntimeException("Stub!"); }

/**
 * @return whether this drawable filters its bitmaps
 * @see #setFilterBitmap(boolean)
 * @apiSince 23
 */

public boolean isFilterBitmap() { throw new RuntimeException("Stub!"); }

/**
 * Bind a {@link android.graphics.drawable.Drawable.Callback Callback} object to this Drawable.  Required for clients
 * that want to support animated drawables.
 *
 * @param cb The client's Callback implementation.
 *
 * This value may be {@code null}.
 * @see #getCallback()
 * @apiSince 1
 */

public final void setCallback(@androidx.annotation.Nullable android.graphics.drawable.Drawable.Callback cb) { throw new RuntimeException("Stub!"); }

/**
 * Return the current {@link android.graphics.drawable.Drawable.Callback Callback} implementation attached to this
 * Drawable.
 *
 * @return A {@link android.graphics.drawable.Drawable.Callback Callback} instance or null if no callback was set.
 *
 * @see #setCallback(android.graphics.drawable.Drawable.Callback)
 * @apiSince 11
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable.Callback getCallback() { throw new RuntimeException("Stub!"); }

/**
 * Use the current {@link android.graphics.drawable.Drawable.Callback Callback} implementation to have this Drawable
 * redrawn.  Does nothing if there is no Callback attached to the
 * Drawable.
 *
 * @see android.graphics.drawable.Drawable.Callback#invalidateDrawable
 * @see #getCallback()
 * @see #setCallback(android.graphics.drawable.Drawable.Callback)
 * @apiSince 1
 */

public void invalidateSelf() { throw new RuntimeException("Stub!"); }

/**
 * Use the current {@link android.graphics.drawable.Drawable.Callback Callback} implementation to have this Drawable
 * scheduled.  Does nothing if there is no Callback attached to the
 * Drawable.
 *
 * @param what The action being scheduled.
 * This value must never be {@code null}.
 * @param when The time (in milliseconds) to run.
 *
 * @see android.graphics.drawable.Drawable.Callback#scheduleDrawable
 * @apiSince 1
 */

public void scheduleSelf(@androidx.annotation.NonNull java.lang.Runnable what, long when) { throw new RuntimeException("Stub!"); }

/**
 * Use the current {@link android.graphics.drawable.Drawable.Callback Callback} implementation to have this Drawable
 * unscheduled.  Does nothing if there is no Callback attached to the
 * Drawable.
 *
 * @param what The runnable that you no longer want called.
 *
 * This value must never be {@code null}.
 * @see android.graphics.drawable.Drawable.Callback#unscheduleDrawable
 * @apiSince 1
 */

public void unscheduleSelf(@androidx.annotation.NonNull java.lang.Runnable what) { throw new RuntimeException("Stub!"); }

/**
 * Returns the resolved layout direction for this Drawable.
 *
 * @return One of {@link android.view.View#LAYOUT_DIRECTION_LTR},
 *         {@link android.view.View#LAYOUT_DIRECTION_RTL}
 * Value is {@link android.view.View#LAYOUT_DIRECTION_LTR}, or {@link android.view.View#LAYOUT_DIRECTION_RTL}
 * @see #setLayoutDirection(int)
 * @apiSince 23
 */

public int getLayoutDirection() { throw new RuntimeException("Stub!"); }

/**
 * Set the layout direction for this drawable. Should be a resolved
 * layout direction, as the Drawable has no capacity to do the resolution on
 * its own.
 *
 * @param layoutDirection the resolved layout direction for the drawable,
 *                        either {@link android.view.View#LAYOUT_DIRECTION_LTR}
 *                        or {@link android.view.View#LAYOUT_DIRECTION_RTL}
 * Value is {@link android.view.View#LAYOUT_DIRECTION_LTR}, or {@link android.view.View#LAYOUT_DIRECTION_RTL}
 * @return {@code true} if the layout direction change has caused the
 *         appearance of the drawable to change such that it needs to be
 *         re-drawn, {@code false} otherwise
 * @see #getLayoutDirection()
 * @apiSince 23
 */

public final boolean setLayoutDirection(int layoutDirection) { throw new RuntimeException("Stub!"); }

/**
 * Called when the drawable's resolved layout direction changes.
 *
 * @param layoutDirection the new resolved layout direction
 * Value is {@link android.view.View#LAYOUT_DIRECTION_LTR}, or {@link android.view.View#LAYOUT_DIRECTION_RTL}
 * @return {@code true} if the layout direction change has caused the
 *         appearance of the drawable to change such that it needs to be
 *         re-drawn, {@code false} otherwise
 * @see #setLayoutDirection(int)
 * @apiSince 23
 */

public boolean onLayoutDirectionChanged(int layoutDirection) { throw new RuntimeException("Stub!"); }

/**
 * Specify an alpha value for the drawable. 0 means fully transparent, and
 * 255 means fully opaque.
 
 * @param alpha Value is between 0 and 255 inclusive
 * @apiSince 1
 */

public abstract void setAlpha(int alpha);

/**
 * Gets the current alpha value for the drawable. 0 means fully transparent,
 * 255 means fully opaque. This method is implemented by
 * Drawable subclasses and the value returned is specific to how that class treats alpha.
 * The default return value is 255 if the class does not override this method to return a value
 * specific to its use of alpha.
 
 * @return Value is between 0 and 255 inclusive
 * @apiSince 19
 */

public int getAlpha() { throw new RuntimeException("Stub!"); }

/**
 * Specify an optional color filter for the drawable.
 * <p>
 * If a Drawable has a ColorFilter, each output pixel of the Drawable's
 * drawing contents will be modified by the color filter before it is
 * blended onto the render target of a Canvas.
 * </p>
 * <p>
 * Pass {@code null} to remove any existing color filter.
 * </p>
 * <p class="note"><strong>Note:</strong> Setting a non-{@code null} color
 * filter disables {@link #setTintList(android.content.res.ColorStateList) tint}.
 * </p>
 *
 * @param colorFilter The color filter to apply, or {@code null} to remove the
 *            existing color filter
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public abstract void setColorFilter(@androidx.annotation.Nullable android.graphics.ColorFilter colorFilter);

/**
 * Specify a color and Porter-Duff mode to be the color filter for this
 * drawable.
 * <p>
 * Convenience for {@link #setColorFilter(android.graphics.ColorFilter)} which constructs a
 * {@link android.graphics.PorterDuffColorFilter PorterDuffColorFilter}.
 * </p>
 * <p class="note"><strong>Note:</strong> Setting a color filter disables
 * {@link #setTintList(android.content.res.ColorStateList) tint}.
 * </p>
 *
 * @see {@link #setColorFilter(android.graphics.ColorFilter)} }
 * @deprecated use {@link #setColorFilter(android.graphics.ColorFilter)} with an instance
 * of {@link android.graphics.BlendModeColorFilter}
 
 * @param mode This value must never be {@code null}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setColorFilter(int color, @androidx.annotation.NonNull android.graphics.PorterDuff.Mode mode) { throw new RuntimeException("Stub!"); }

/**
 * Specifies tint color for this drawable.
 * <p>
 * A Drawable's drawing content will be blended together with its tint
 * before it is drawn to the screen. This functions similarly to
 * {@link #setColorFilter(int,android.graphics.PorterDuff.Mode)}.
 * </p>
 * <p>
 * To clear the tint, pass {@code null} to
 * {@link #setTintList(android.content.res.ColorStateList)}.
 * </p>
 * <p class="note"><strong>Note:</strong> Setting a color filter via
 * {@link #setColorFilter(android.graphics.ColorFilter)} or
 * {@link #setColorFilter(int,android.graphics.PorterDuff.Mode)} overrides tint.
 * </p>
 *
 * @param tintColor Color to use for tinting this drawable
 * @see #setTintList(ColorStateList)
 * @see #setTintMode(PorterDuff.Mode)
 * @see #setTintBlendMode(BlendMode)
 * @apiSince 21
 */

public void setTint(int tintColor) { throw new RuntimeException("Stub!"); }

/**
 * Specifies tint color for this drawable as a color state list.
 * <p>
 * A Drawable's drawing content will be blended together with its tint
 * before it is drawn to the screen. This functions similarly to
 * {@link #setColorFilter(int,android.graphics.PorterDuff.Mode)}.
 * </p>
 * <p class="note"><strong>Note:</strong> Setting a color filter via
 * {@link #setColorFilter(android.graphics.ColorFilter)} or
 * {@link #setColorFilter(int,android.graphics.PorterDuff.Mode)} overrides tint.
 * </p>
 *
 * @param tint Color state list to use for tinting this drawable, or
 *            {@code null} to clear the tint
 * This value may be {@code null}.
 * @see #setTint(int)
 * @see #setTintMode(PorterDuff.Mode)
 * @see #setTintBlendMode(BlendMode)
 * @apiSince 21
 */

public void setTintList(@androidx.annotation.Nullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * Specifies a tint blending mode for this drawable.
 * <p>
 * Defines how this drawable's tint color should be blended into the drawable
 * before it is drawn to screen. Default tint mode is {@link android.graphics.PorterDuff.Mode#SRC_IN PorterDuff.Mode#SRC_IN}.
 * </p>
 * <p class="note"><strong>Note:</strong> Setting a color filter via
 * {@link #setColorFilter(android.graphics.ColorFilter)} or
 * {@link #setColorFilter(int,android.graphics.PorterDuff.Mode)} overrides tint.
 * </p>
 *
 * @param tintMode A Porter-Duff blending mode to apply to the drawable, a value of null sets
 *                 the default Porter-Diff blending mode value
 *                 of {@link android.graphics.PorterDuff.Mode#SRC_IN PorterDuff.Mode#SRC_IN}
 * This value may be {@code null}.
 * @see #setTint(int)
 * @see #setTintList(ColorStateList)
 * @apiSince 21
 */

public void setTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * Specifies a tint blending mode for this drawable.
 * <p>
 * Defines how this drawable's tint color should be blended into the drawable
 * before it is drawn to screen. Default tint mode is {@link android.graphics.BlendMode#SRC_IN BlendMode#SRC_IN}.
 * </p>
 * <p class="note"><strong>Note:</strong> Setting a color filter via
 * {@link #setColorFilter(android.graphics.ColorFilter)}
 * </p>
 *
 * @param blendMode BlendMode to apply to the drawable, a value of null sets the default
 *                  blend mode value of {@link android.graphics.BlendMode#SRC_IN BlendMode#SRC_IN}
 * This value may be {@code null}.
 * @see #setTint(int)
 * @see #setTintList(ColorStateList)
 * @apiSince 29
 */

public void setTintBlendMode(@androidx.annotation.Nullable android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current color filter, or {@code null} if none set.
 *
 * @return the current color filter, or {@code null} if none set
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.graphics.ColorFilter getColorFilter() { throw new RuntimeException("Stub!"); }

/**
 * Removes the color filter for this drawable.
 * @apiSince 1
 */

public void clearColorFilter() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the hotspot's location within the drawable.
 *
 * @param x The X coordinate of the center of the hotspot
 * @param y The Y coordinate of the center of the hotspot
 * @apiSince 21
 */

public void setHotspot(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Sets the bounds to which the hotspot is constrained, if they should be
 * different from the drawable bounds.
 *
 * @param left position in pixels of the left bound
 * @param top position in pixels of the top bound
 * @param right position in pixels of the right bound
 * @param bottom position in pixels of the bottom bound
 * @see #getHotspotBounds(android.graphics.Rect)
 * @apiSince 21
 */

public void setHotspotBounds(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Populates {@code outRect} with the hotspot bounds.
 *
 * @param outRect the rect to populate with the hotspot bounds
 * This value must never be {@code null}.
 * @see #setHotspotBounds(int, int, int, int)
 * @apiSince 23
 */

public void getHotspotBounds(@androidx.annotation.NonNull android.graphics.Rect outRect) { throw new RuntimeException("Stub!"); }

/**
 * Whether this drawable requests projection. Indicates that the
 * {@link android.graphics.RenderNode} this Drawable will draw into should be drawn immediately
 * after the closest ancestor RenderNode containing a projection receiver.
 *
 * @see android.graphics.RenderNode#setProjectBackwards(boolean)
 * @apiSince 29
 */

public boolean isProjected() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this drawable will change its appearance based on
 * state. Clients can use this to determine whether it is necessary to
 * calculate their state and call setState.
 *
 * @return True if this drawable changes its appearance based on state,
 *         false otherwise.
 * @see #setState(int[])
 * @apiSince 1
 */

public boolean isStateful() { throw new RuntimeException("Stub!"); }

/**
 * Specify a set of states for the drawable. These are use-case specific,
 * so see the relevant documentation. As an example, the background for
 * widgets like Button understand the following states:
 * [{@link android.R.attr#state_focused},
 *  {@link android.R.attr#state_pressed}].
 *
 * <p>If the new state you are supplying causes the appearance of the
 * Drawable to change, then it is responsible for calling
 * {@link #invalidateSelf} in order to have itself redrawn, <em>and</em>
 * true will be returned from this function.
 *
 * <p>Note: The Drawable holds a reference on to <var>stateSet</var>
 * until a new state array is given to it, so you must not modify this
 * array during that time.</p>
 *
 * @param stateSet The new set of states to be displayed.
 *
 * This value must never be {@code null}.
 * @return Returns true if this change in state has caused the appearance
 * of the Drawable to change (hence requiring an invalidate), otherwise
 * returns false.
 * @apiSince 1
 */

public boolean setState(@androidx.annotation.NonNull int[] stateSet) { throw new RuntimeException("Stub!"); }

/**
 * Describes the current state, as a union of primitve states, such as
 * {@link android.R.attr#state_focused},
 * {@link android.R.attr#state_selected}, etc.
 * Some drawables may modify their imagery based on the selected state.
 * @return An array of resource Ids describing the current state.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public int[] getState() { throw new RuntimeException("Stub!"); }

/**
 * If this Drawable does transition animations between states, ask that
 * it immediately jump to the current state and skip any active animations.
 * @apiSince 11
 */

public void jumpToCurrentState() { throw new RuntimeException("Stub!"); }

/**
 * @return The current drawable that will be used by this drawable. For simple drawables, this
 *         is just the drawable itself. For drawables that change state like
 *         {@link android.graphics.drawable.StateListDrawable StateListDrawable} and {@link android.graphics.drawable.LevelListDrawable LevelListDrawable} this will be the child drawable
 *         currently in use.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.graphics.drawable.Drawable getCurrent() { throw new RuntimeException("Stub!"); }

/**
 * Specify the level for the drawable.  This allows a drawable to vary its
 * imagery based on a continuous controller, for example to show progress
 * or volume level.
 *
 * <p>If the new level you are supplying causes the appearance of the
 * Drawable to change, then it is responsible for calling
 * {@link #invalidateSelf} in order to have itself redrawn, <em>and</em>
 * true will be returned from this function.
 *
 * @param level The new level, from 0 (minimum) to 10000 (maximum).
 *
 * Value is between 0 and 10000 inclusive
 * @return Returns true if this change in level has caused the appearance
 * of the Drawable to change (hence requiring an invalidate), otherwise
 * returns false.
 * @apiSince 1
 */

public final boolean setLevel(int level) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current level.
 *
 * @return int Current level, from 0 (minimum) to 10000 (maximum).
 
 * Value is between 0 and 10000 inclusive
 * @apiSince 1
 */

public final int getLevel() { throw new RuntimeException("Stub!"); }

/**
 * Set whether this Drawable is visible.  This generally does not impact
 * the Drawable's behavior, but is a hint that can be used by some
 * Drawables, for example, to decide whether run animations.
 *
 * @param visible Set to true if visible, false if not.
 * @param restart You can supply true here to force the drawable to behave
 *                as if it has just become visible, even if it had last
 *                been set visible.  Used for example to force animations
 *                to restart.
 *
 * @return boolean Returns true if the new visibility is different than
 *         its previous state.
 * @apiSince 1
 */

public boolean setVisible(boolean visible, boolean restart) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final boolean isVisible() { throw new RuntimeException("Stub!"); }

/**
 * Set whether this Drawable is automatically mirrored when its layout direction is RTL
 * (right-to left). See {@link android.util.LayoutDirection}.
 *
 * @param mirrored Set to true if the Drawable should be mirrored, false if not.
 * @apiSince 19
 */

public void setAutoMirrored(boolean mirrored) { throw new RuntimeException("Stub!"); }

/**
 * Tells if this Drawable will be automatically mirrored  when its layout direction is RTL
 * right-to-left. See {@link android.util.LayoutDirection}.
 *
 * @return boolean Returns true if this Drawable will be automatically mirrored.
 * @apiSince 19
 */

public boolean isAutoMirrored() { throw new RuntimeException("Stub!"); }

/**
 * Applies the specified theme to this Drawable and its children.
 *
 * @param t the theme to apply
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void applyTheme(@androidx.annotation.NonNull android.content.res.Resources.Theme t) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }

/**
 * Return the opacity/transparency of this Drawable.  The returned value is
 * one of the abstract format constants in
 * {@link android.graphics.PixelFormat}:
 * {@link android.graphics.PixelFormat#UNKNOWN},
 * {@link android.graphics.PixelFormat#TRANSLUCENT},
 * {@link android.graphics.PixelFormat#TRANSPARENT}, or
 * {@link android.graphics.PixelFormat#OPAQUE}.
 *
 * <p>An OPAQUE drawable is one that draws all all content within its bounds, completely
 * covering anything behind the drawable. A TRANSPARENT drawable is one that draws nothing
 * within its bounds, allowing everything behind it to show through. A TRANSLUCENT drawable
 * is a drawable in any other state, where the drawable will draw some, but not all,
 * of the content within its bounds and at least some content behind the drawable will
 * be visible. If the visibility of the drawable's contents cannot be determined, the
 * safest/best return value is TRANSLUCENT.
 *
 * <p>Generally a Drawable should be as conservative as possible with the
 * value it returns.  For example, if it contains multiple child drawables
 * and only shows one of them at a time, if only one of the children is
 * TRANSLUCENT and the others are OPAQUE then TRANSLUCENT should be
 * returned.  You can use the method {@link #resolveOpacity} to perform a
 * standard reduction of two opacities to the appropriate single output.
 *
 * <p>Note that the returned value does not necessarily take into account a
 * custom alpha or color filter that has been applied by the client through
 * the {@link #setAlpha} or {@link #setColorFilter} methods. Some subclasses,
 * such as {@link android.graphics.drawable.BitmapDrawable BitmapDrawable}, {@link android.graphics.drawable.ColorDrawable ColorDrawable}, and {@link android.graphics.drawable.GradientDrawable GradientDrawable},
 * do account for the value of {@link #setAlpha}, but the general behavior is dependent
 * upon the implementation of the subclass.
 *
 * @deprecated This method is no longer used in graphics optimizations
 *
 * @return int The opacity class of the Drawable.
 *
 * Value is {@link android.graphics.PixelFormat#UNKNOWN}, {@link android.graphics.PixelFormat#TRANSLUCENT}, {@link android.graphics.PixelFormat#TRANSPARENT}, or {@link android.graphics.PixelFormat#OPAQUE}
 * @see android.graphics.PixelFormat
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public abstract int getOpacity();

/**
 * Return the appropriate opacity value for two source opacities.  If
 * either is UNKNOWN, that is returned; else, if either is TRANSLUCENT,
 * that is returned; else, if either is TRANSPARENT, that is returned;
 * else, OPAQUE is returned.
 *
 * <p>This is to help in implementing {@link #getOpacity}.
 *
 * @param op1 One opacity value.
 * Value is {@link android.graphics.PixelFormat#UNKNOWN}, {@link android.graphics.PixelFormat#TRANSLUCENT}, {@link android.graphics.PixelFormat#TRANSPARENT}, or {@link android.graphics.PixelFormat#OPAQUE}
 * @param op2 Another opacity value.
 *
 * Value is {@link android.graphics.PixelFormat#UNKNOWN}, {@link android.graphics.PixelFormat#TRANSLUCENT}, {@link android.graphics.PixelFormat#TRANSPARENT}, or {@link android.graphics.PixelFormat#OPAQUE}
 * @return int The combined opacity value.
 *
 * Value is {@link android.graphics.PixelFormat#UNKNOWN}, {@link android.graphics.PixelFormat#TRANSLUCENT}, {@link android.graphics.PixelFormat#TRANSPARENT}, or {@link android.graphics.PixelFormat#OPAQUE}
 * @see #getOpacity
 * @apiSince 1
 */

public static int resolveOpacity(int op1, int op2) { throw new RuntimeException("Stub!"); }

/**
 * Returns a Region representing the part of the Drawable that is completely
 * transparent.  This can be used to perform drawing operations, identifying
 * which parts of the target will not change when rendering the Drawable.
 * The default implementation returns null, indicating no transparent
 * region; subclasses can optionally override this to return an actual
 * Region if they want to supply this optimization information, but it is
 * not required that they do so.
 *
 * @return Returns null if the Drawables has no transparent region to
 * report, else a Region holding the parts of the Drawable's bounds that
 * are transparent.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.graphics.Region getTransparentRegion() { throw new RuntimeException("Stub!"); }

/**
 * Override this in your subclass to change appearance if you recognize the
 * specified state.
 *
 * @return Returns true if the state change has caused the appearance of
 * the Drawable to change (that is, it needs to be drawn), else false
 * if it looks the same and there is no need to redraw it since its
 * last state.
 * @apiSince 1
 */

protected boolean onStateChange(int[] state) { throw new RuntimeException("Stub!"); }

/** Override this in your subclass to change appearance if you vary based
 *  on level.
 * @return Returns true if the level change has caused the appearance of
 * the Drawable to change (that is, it needs to be drawn), else false
 * if it looks the same and there is no need to redraw it since its
 * last level.
 * @apiSince 1
 */

protected boolean onLevelChange(int level) { throw new RuntimeException("Stub!"); }

/**
 * Override this in your subclass to change appearance if you vary based on
 * the bounds.
 * @apiSince 1
 */

protected void onBoundsChange(android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/**
 * Returns the drawable's intrinsic width.
 * <p>
 * Intrinsic width is the width at which the drawable would like to be laid
 * out, including any inherent padding. If the drawable has no intrinsic
 * width, such as a solid color, this method returns -1.
 *
 * @return the intrinsic width, or -1 if no intrinsic width
 * @apiSince 1
 */

public int getIntrinsicWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the drawable's intrinsic height.
 * <p>
 * Intrinsic height is the height at which the drawable would like to be
 * laid out, including any inherent padding. If the drawable has no
 * intrinsic height, such as a solid color, this method returns -1.
 *
 * @return the intrinsic height, or -1 if no intrinsic height
 * @apiSince 1
 */

public int getIntrinsicHeight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum width suggested by this Drawable. If a View uses this
 * Drawable as a background, it is suggested that the View use at least this
 * value for its width. (There will be some scenarios where this will not be
 * possible.) This value should INCLUDE any padding.
 *
 * @return The minimum width suggested by this Drawable. If this Drawable
 *         doesn't have a suggested minimum width, 0 is returned.
 * @apiSince 1
 */

public int getMinimumWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum height suggested by this Drawable. If a View uses this
 * Drawable as a background, it is suggested that the View use at least this
 * value for its height. (There will be some scenarios where this will not be
 * possible.) This value should INCLUDE any padding.
 *
 * @return The minimum height suggested by this Drawable. If this Drawable
 *         doesn't have a suggested minimum height, 0 is returned.
 * @apiSince 1
 */

public int getMinimumHeight() { throw new RuntimeException("Stub!"); }

/**
 * Return in padding the insets suggested by this Drawable for placing
 * content inside the drawable's bounds. Positive values move toward the
 * center of the Drawable (set Rect.inset).
 *
 * @param padding This value must never be {@code null}.
 * @return true if this drawable actually has a padding, else false. When false is returned,
 * the padding is always set to 0.
 * @apiSince 1
 */

public boolean getPadding(@androidx.annotation.NonNull android.graphics.Rect padding) { throw new RuntimeException("Stub!"); }

/**
 * Return in insets the layout insets suggested by this Drawable for use with alignment
 * operations during layout.
 *
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Insets getOpticalInsets() { throw new RuntimeException("Stub!"); }

/**
 * Called to get the drawable to populate the Outline that defines its drawing area.
 * <p>
 * This method is called by the default {@link android.view.ViewOutlineProvider} to define
 * the outline of the View.
 * <p>
 * The default behavior defines the outline to be the bounding rectangle of 0 alpha.
 * Subclasses that wish to convey a different shape or alpha value must override this method.
 *
 * @see android.view.View#setOutlineProvider(android.view.ViewOutlineProvider)
 
 * @param outline This value must never be {@code null}.
 * @apiSince 21
 */

public void getOutline(@androidx.annotation.NonNull android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/**
 * Make this drawable mutable. This operation cannot be reversed. A mutable
 * drawable is guaranteed to not share its state with any other drawable.
 * This is especially useful when you need to modify properties of drawables
 * loaded from resources. By default, all drawables instances loaded from
 * the same resource share a common state; if you modify the state of one
 * instance, all the other instances will receive the same modification.
 *
 * Calling this method on a mutable Drawable will have no effect.
 *
 * @return This drawable.
 * This value will never be {@code null}.
 * @see android.graphics.drawable.Drawable.ConstantState
 * @see #getConstantState()
 * @apiSince 3
 */

@androidx.annotation.NonNull
public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

/**
 * Create a drawable from an inputstream
 * @apiSince 1
 */

public static android.graphics.drawable.Drawable createFromStream(java.io.InputStream is, java.lang.String srcName) { throw new RuntimeException("Stub!"); }

/**
 * Create a drawable from an inputstream, using the given resources and
 * value to determine density information.
 * @apiSince 4
 */

public static android.graphics.drawable.Drawable createFromResourceStream(android.content.res.Resources res, android.util.TypedValue value, java.io.InputStream is, java.lang.String srcName) { throw new RuntimeException("Stub!"); }

/**
 * Create a drawable from an inputstream, using the given resources and
 * value to determine density information.
 *
 * @deprecated Prefer the version without an Options object.
 
 * @param res This value may be {@code null}.
 * @param value This value may be {@code null}.
 * @param is This value may be {@code null}.
 * @param srcName This value may be {@code null}.
 * @param opts This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 5
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.Nullable
public static android.graphics.drawable.Drawable createFromResourceStream(@androidx.annotation.Nullable android.content.res.Resources res, @androidx.annotation.Nullable android.util.TypedValue value, @androidx.annotation.Nullable java.io.InputStream is, @androidx.annotation.Nullable java.lang.String srcName, @androidx.annotation.Nullable android.graphics.BitmapFactory.Options opts) { throw new RuntimeException("Stub!"); }

/**
 * Create a drawable from an XML document. For more information on how to
 * create resources in XML, see
 * <a href="{@docRoot}guide/topics/resources/drawable-resource.html">Drawable Resources</a>.
 
 * @param r This value must never be {@code null}.
 * @param parser This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static android.graphics.drawable.Drawable createFromXml(@androidx.annotation.NonNull android.content.res.Resources r, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser parser) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Create a drawable from an XML document using an optional {@link android.content.res.Resources.Theme Theme}.
 * For more information on how to create resources in XML, see
 * <a href="{@docRoot}guide/topics/resources/drawable-resource.html">Drawable Resources</a>.
 
 * @param r This value must never be {@code null}.
 * @param parser This value must never be {@code null}.
 * @param theme This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public static android.graphics.drawable.Drawable createFromXml(@androidx.annotation.NonNull android.content.res.Resources r, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser parser, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Create from inside an XML document.  Called on a parser positioned at
 * a tag in an XML document, tries to create a Drawable from that tag.
 * Returns null if the tag is not a valid drawable.
 
 * @param r This value must never be {@code null}.
 
 * @param parser This value must never be {@code null}.
 
 * @param attrs This value must never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static android.graphics.drawable.Drawable createFromXmlInner(@androidx.annotation.NonNull android.content.res.Resources r, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser parser, @androidx.annotation.NonNull android.util.AttributeSet attrs) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Create a drawable from inside an XML document using an optional
 * {@link android.content.res.Resources.Theme Theme}. Called on a parser positioned at a tag in an XML
 * document, tries to create a Drawable from that tag. Returns {@code null}
 * if the tag is not a valid drawable.
 
 * @param r This value must never be {@code null}.
 
 * @param parser This value must never be {@code null}.
 
 * @param attrs This value must never be {@code null}.
 
 * @param theme This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public static android.graphics.drawable.Drawable createFromXmlInner(@androidx.annotation.NonNull android.content.res.Resources r, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser parser, @androidx.annotation.NonNull android.util.AttributeSet attrs, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Create a drawable from file path name.
 
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public static android.graphics.drawable.Drawable createFromPath(java.lang.String pathName) { throw new RuntimeException("Stub!"); }

/**
 * Inflate this Drawable from an XML resource. Does not apply a theme.
 *
 * @see #inflate(Resources, XmlPullParser, AttributeSet, Theme)
 
 * @param r This value must never be {@code null}.
 
 * @param parser This value must never be {@code null}.
 
 * @param attrs This value must never be {@code null}.
 * @apiSince 1
 */

public void inflate(@androidx.annotation.NonNull android.content.res.Resources r, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser parser, @androidx.annotation.NonNull android.util.AttributeSet attrs) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Inflate this Drawable from an XML resource optionally styled by a theme.
 * This can't be called more than once for each Drawable. Note that framework may have called
 * this once to create the Drawable instance from XML resource.
 *
 * @param r Resources used to resolve attribute values
 * This value must never be {@code null}.
 * @param parser XML parser from which to inflate this Drawable
 * This value must never be {@code null}.
 * @param attrs Base set of attribute values
 * This value must never be {@code null}.
 * @param theme Theme to apply, may be null
 * This value may be {@code null}.
 * @throws org.xmlpull.v1.XmlPullParserException
 * @throws java.io.IOException
 * @apiSince 21
 */

public void inflate(@androidx.annotation.NonNull android.content.res.Resources r, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser parser, @androidx.annotation.NonNull android.util.AttributeSet attrs, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link android.graphics.drawable.Drawable.ConstantState ConstantState} instance that holds the shared state of this Drawable.
 *
 * @return The ConstantState associated to that Drawable.
 * This value may be {@code null}.
 * @see android.graphics.drawable.Drawable.ConstantState
 * @see android.graphics.drawable.Drawable#mutate()
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }
/**
 * Implement this interface if you want to create an animated drawable that
 * extends {@link android.graphics.drawable.Drawable Drawable}.
 * Upon retrieving a drawable, use
 * {@link android.graphics.drawable.Drawable#setCallback(android.graphics.drawable.Drawable.Callback) Drawable#setCallback(android.graphics.drawable.Drawable.Callback)}
 * to supply your implementation of the interface to the drawable; it uses
 * this interface to schedule and execute animation changes.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Callback {

/**
 * Called when the drawable needs to be redrawn.  A view at this point
 * should invalidate itself (or at least the part of itself where the
 * drawable appears).
 *
 * @param who The drawable that is requesting the update.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void invalidateDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who);

/**
 * A Drawable can call this to schedule the next frame of its
 * animation.  An implementation can generally simply call
 * {@link android.os.Handler#postAtTime(Runnable, Object, long)} with
 * the parameters <var>(what, who, when)</var> to perform the
 * scheduling.
 *
 * @param who The drawable being scheduled.
 * This value must never be {@code null}.
 * @param what The action to execute.
 * This value must never be {@code null}.
 * @param when The time (in milliseconds) to run.  The timebase is
 *             {@link android.os.SystemClock#uptimeMillis}
 * @apiSince 1
 */

public void scheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who, @androidx.annotation.NonNull java.lang.Runnable what, long when);

/**
 * A Drawable can call this to unschedule an action previously
 * scheduled with {@link #scheduleDrawable}.  An implementation can
 * generally simply call
 * {@link android.os.Handler#removeCallbacks(Runnable, Object)} with
 * the parameters <var>(what, who)</var> to unschedule the drawable.
 *
 * @param who The drawable being unscheduled.
 * This value must never be {@code null}.
 * @param what The action being unscheduled.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void unscheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who, @androidx.annotation.NonNull java.lang.Runnable what);
}

/**
 * This abstract class is used by {@link android.graphics.drawable.Drawable Drawable}s to store shared constant state and data
 * between Drawables. {@link android.graphics.drawable.BitmapDrawable BitmapDrawable}s created from the same resource will for instance
 * share a unique bitmap stored in their ConstantState.
 *
 * <p>
 * {@link #newDrawable(android.content.res.Resources)} can be used as a factory to create new Drawable instances
 * from this ConstantState.
 * </p>
 *
 * Use {@link android.graphics.drawable.Drawable#getConstantState() Drawable#getConstantState()} to retrieve the ConstantState of a Drawable. Calling
 * {@link android.graphics.drawable.Drawable#mutate() Drawable#mutate()} on a Drawable should typically create a new ConstantState for that
 * Drawable.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class ConstantState {

public ConstantState() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new Drawable instance from its constant state.
 * <p>
 * <strong>Note:</strong> Using this method means density-dependent
 * properties, such as pixel dimensions or bitmap images, will not be
 * updated to match the density of the target display. To ensure
 * correct scaling, use {@link #newDrawable(android.content.res.Resources)} instead to
 * provide an appropriate Resources object.
 *
 * @return a new drawable object based on this constant state
 * This value will never be {@code null}.
 * @see #newDrawable(Resources)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract android.graphics.drawable.Drawable newDrawable();

/**
 * Creates a new Drawable instance from its constant state using the
 * specified resources. This method should be implemented for drawables
 * that have density-dependent properties.
 * <p>
 * The default implementation for this method calls through to
 * {@link #newDrawable()}.
 *
 * @param res the resources of the context in which the drawable will
 *            be displayed
 * This value may be {@code null}.
 * @return a new drawable object based on this constant state
 
 * This value will never be {@code null}.
 * @apiSince 5
 */

@androidx.annotation.NonNull
public android.graphics.drawable.Drawable newDrawable(@androidx.annotation.Nullable android.content.res.Resources res) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new Drawable instance from its constant state using the
 * specified resources and theme. This method should be implemented for
 * drawables that have theme-dependent properties.
 * <p>
 * The default implementation for this method calls through to
 * {@link #newDrawable(android.content.res.Resources)}.
 *
 * @param res the resources of the context in which the drawable will
 *            be displayed
 * This value may be {@code null}.
 * @param theme the theme of the context in which the drawable will be
 *              displayed
 * This value may be {@code null}.
 * @return a new drawable object based on this constant state
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.graphics.drawable.Drawable newDrawable(@androidx.annotation.Nullable android.content.res.Resources res, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) { throw new RuntimeException("Stub!"); }

/**
 * Return a bit mask of configuration changes that will impact
 * this drawable (and thus require completely reloading it).
 
 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @apiSince 1
 */

public abstract int getChangingConfigurations();

/**
 * Return whether this constant state can have a theme applied.
 * @apiSince 21
 */

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }
}

}

