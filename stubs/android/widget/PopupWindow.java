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

import android.transition.Transition;
import android.graphics.Rect;
import android.transition.Transition.EpicenterCallback;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.os.Build;
import android.view.ViewGroup;
import android.view.Gravity;

/**
 * <p>
 * This class represents a popup window that can be used to display an
 * arbitrary view. The popup window is a floating container that appears on top
 * of the current activity.
 * </p>
 * <a name="Animation"></a>
 * <h3>Animation</h3>
 * <p>
 * On all versions of Android, popup window enter and exit animations may be
 * specified by calling {@link #setAnimationStyle(int)} and passing the
 * resource ID for an animation style that defines {@code windowEnterAnimation}
 * and {@code windowExitAnimation}. For example, passing
 * {@link android.R.style#Animation_Dialog} will give a scale and alpha
 * animation.
 * </br>
 * A window animation style may also be specified in the popup window's style
 * XML via the {@link android.R.styleable#PopupWindow_popupAnimationStyle popupAnimationStyle}
 * attribute.
 * </p>
 * <p>
 * Starting with API 23, more complex popup window enter and exit transitions
 * may be specified by calling either {@link #setEnterTransition(android.transition.Transition)}
 * or {@link #setExitTransition(android.transition.Transition)} and passing a  {@link android.transition.Transition Transition}.
 * </br>
 * Popup enter and exit transitions may also be specified in the popup window's
 * style XML via the {@link android.R.styleable#PopupWindow_popupEnterTransition popupEnterTransition}
 * and {@link android.R.styleable#PopupWindow_popupExitTransition popupExitTransition}
 * attributes, respectively.
 * </p>
 *
 * @attr ref android.R.styleable#PopupWindow_overlapAnchor
 * @attr ref android.R.styleable#PopupWindow_popupAnimationStyle
 * @attr ref android.R.styleable#PopupWindow_popupBackground
 * @attr ref android.R.styleable#PopupWindow_popupElevation
 * @attr ref android.R.styleable#PopupWindow_popupEnterTransition
 * @attr ref android.R.styleable#PopupWindow_popupExitTransition
 *
 * @see android.widget.AutoCompleteTextView
 * @see android.widget.Spinner
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PopupWindow {

/**
 * <p>Create a new empty, non focusable popup window of dimension (0,0).</p>
 *
 * <p>The popup does provide a background.</p>
 * @apiSince 1
 */

public PopupWindow(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a new empty, non focusable popup window of dimension (0,0).</p>
 *
 * <p>The popup does provide a background.</p>
 * @apiSince 1
 */

public PopupWindow(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a new empty, non focusable popup window of dimension (0,0).</p>
 *
 * <p>The popup does provide a background.</p>
 * @apiSince 1
 */

public PopupWindow(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a new, empty, non focusable popup window of dimension (0,0).</p>
 *
 * <p>The popup does not provide a background.</p>
 * @apiSince 11
 */

public PopupWindow(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a new empty, non focusable popup window of dimension (0,0).</p>
 *
 * <p>The popup does not provide any background. This should be handled
 * by the content view.</p>
 * @apiSince 1
 */

public PopupWindow() { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a new non focusable popup window which can display the
 * <tt>contentView</tt>. The dimension of the window are (0,0).</p>
 *
 * <p>The popup does not provide any background. This should be handled
 * by the content view.</p>
 *
 * @param contentView the popup's content
 * @apiSince 1
 */

public PopupWindow(android.view.View contentView) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a new empty, non focusable popup window. The dimension of the
 * window must be passed to this constructor.</p>
 *
 * <p>The popup does not provide any background. This should be handled
 * by the content view.</p>
 *
 * @param width the popup's width
 * @param height the popup's height
 * @apiSince 1
 */

public PopupWindow(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a new non focusable popup window which can display the
 * <tt>contentView</tt>. The dimension of the window must be passed to
 * this constructor.</p>
 *
 * <p>The popup does not provide any background. This should be handled
 * by the content view.</p>
 *
 * @param contentView the popup's content
 * @param width the popup's width
 * @param height the popup's height
 * @apiSince 1
 */

public PopupWindow(android.view.View contentView, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a new popup window which can display the <tt>contentView</tt>.
 * The dimension of the window must be passed to this constructor.</p>
 *
 * <p>The popup does not provide any background. This should be handled
 * by the content view.</p>
 *
 * @param contentView the popup's content
 * @param width the popup's width
 * @param height the popup's height
 * @param focusable true if the popup can be focused, false otherwise
 * @apiSince 1
 */

public PopupWindow(android.view.View contentView, int width, int height, boolean focusable) { throw new RuntimeException("Stub!"); }

/**
 * Sets the enter transition to be used when the popup window is shown.
 *
 * @param enterTransition the enter transition, or {@code null} to clear
 * This value may be {@code null}.
 * @see #getEnterTransition()
 * @attr ref android.R.styleable#PopupWindow_popupEnterTransition
 * @apiSince 23
 */

public void setEnterTransition(@androidx.annotation.Nullable android.transition.Transition enterTransition) { throw new RuntimeException("Stub!"); }

/**
 * Returns the enter transition to be used when the popup window is shown.
 *
 * @return the enter transition, or {@code null} if not set
 * @see #setEnterTransition(Transition)
 * @attr ref android.R.styleable#PopupWindow_popupEnterTransition
 * @apiSince 24
 */

@androidx.annotation.Nullable
public android.transition.Transition getEnterTransition() { throw new RuntimeException("Stub!"); }

/**
 * Sets the exit transition to be used when the popup window is dismissed.
 *
 * @param exitTransition the exit transition, or {@code null} to clear
 * This value may be {@code null}.
 * @see #getExitTransition()
 * @attr ref android.R.styleable#PopupWindow_popupExitTransition
 * @apiSince 23
 */

public void setExitTransition(@androidx.annotation.Nullable android.transition.Transition exitTransition) { throw new RuntimeException("Stub!"); }

/**
 * Returns the exit transition to be used when the popup window is
 * dismissed.
 *
 * @return the exit transition, or {@code null} if not set
 * @see #setExitTransition(Transition)
 * @attr ref android.R.styleable#PopupWindow_popupExitTransition
 * @apiSince 24
 */

@androidx.annotation.Nullable
public android.transition.Transition getExitTransition() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns bounds which are used as a center of the enter and exit transitions.<p/>
 *
 * <p>Transitions use Rect, referred to as the epicenter, to orient
 * the direction of travel. For popup windows, the anchor view bounds are
 * used as the default epicenter.</p>
 *
 * <p>See {@link android.transition.Transition#setEpicenterCallback(android.transition.Transition.EpicenterCallback) Transition#setEpicenterCallback(EpicenterCallback)} for more
 * information about how transition epicenters work.</p>
 *
 * @return bounds relative to anchor view, or {@code null} if not set
 * @see #setEpicenterBounds(Rect)
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.Rect getEpicenterBounds() { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the bounds used as the epicenter of the enter and exit transitions.</p>
 *
 * <p>Transitions use Rect, referred to as the epicenter, to orient
 * the direction of travel. For popup windows, the anchor view bounds are
 * used as the default epicenter.</p>
 *
 * <p>See {@link android.transition.Transition#setEpicenterCallback(android.transition.Transition.EpicenterCallback) Transition#setEpicenterCallback(EpicenterCallback)} for more
 * information about how transition epicenters work.</p>
 *
 * @param bounds the epicenter bounds relative to the anchor view, or
 *               {@code null} to use the default epicenter
 *
 * This value may be {@code null}.
 * @see #getEpicenterBounds()
 * @apiSince 29
 */

public void setEpicenterBounds(@androidx.annotation.Nullable android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/**
 * Return the drawable used as the popup window's background.
 *
 * @return the background drawable or {@code null} if not set
 * @see #setBackgroundDrawable(Drawable)
 * @attr ref android.R.styleable#PopupWindow_popupBackground
 * @apiSince 1
 */

public android.graphics.drawable.Drawable getBackground() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the background drawable for this popup window. The background
 * can be set to {@code null}.
 *
 * @param background the popup's background
 * @see #getBackground()
 * @attr ref android.R.styleable#PopupWindow_popupBackground
 * @apiSince 1
 */

public void setBackgroundDrawable(android.graphics.drawable.Drawable background) { throw new RuntimeException("Stub!"); }

/**
 * @return the elevation for this popup window in pixels
 * @see #setElevation(float)
 * @attr ref android.R.styleable#PopupWindow_popupElevation
 * @apiSince 21
 */

public float getElevation() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the elevation for this popup window.
 *
 * @param elevation the popup's elevation in pixels
 * @see #getElevation()
 * @attr ref android.R.styleable#PopupWindow_popupElevation
 * @apiSince 21
 */

public void setElevation(float elevation) { throw new RuntimeException("Stub!"); }

/**
 * <p>Return the animation style to use the popup appears and disappears</p>
 *
 * @return the animation style to use the popup appears and disappears
 * @apiSince 1
 */

public int getAnimationStyle() { throw new RuntimeException("Stub!"); }

/**
 * Set the flag on popup to ignore cheek press events; by default this flag
 * is set to false
 * which means the popup will not ignore cheek press dispatch events.
 *
 * <p>If the popup is showing, calling this method will take effect only
 * the next time the popup is shown or through a manual call to one of
 * the {@link #update()} methods.</p>
 *
 * @see #update()
 * @apiSince 1
 */

public void setIgnoreCheekPress() { throw new RuntimeException("Stub!"); }

/**
 * <p>Change the animation style resource for this popup.</p>
 *
 * <p>If the popup is showing, calling this method will take effect only
 * the next time the popup is shown or through a manual call to one of
 * the {@link #update()} methods.</p>
 *
 * @param animationStyle animation style to use when the popup appears
 *      and disappears.  Set to -1 for the default animation, 0 for no
 *      animation, or a resource identifier for an explicit animation.
 *
 * @see #update()
 * @apiSince 1
 */

public void setAnimationStyle(int animationStyle) { throw new RuntimeException("Stub!"); }

/**
 * <p>Return the view used as the content of the popup window.</p>
 *
 * @return a {@link android.view.View} representing the popup's content
 *
 * @see #setContentView(android.view.View)
 * @apiSince 1
 */

public android.view.View getContentView() { throw new RuntimeException("Stub!"); }

/**
 * <p>Change the popup's content. The content is represented by an instance
 * of {@link android.view.View}.</p>
 *
 * <p>This method has no effect if called when the popup is showing.</p>
 *
 * @param contentView the new content for the popup
 *
 * @see #getContentView()
 * @see #isShowing()
 * @apiSince 1
 */

public void setContentView(android.view.View contentView) { throw new RuntimeException("Stub!"); }

/**
 * Set a callback for all touch events being dispatched to the popup
 * window.
 * @apiSince 3
 */

public void setTouchInterceptor(android.view.View.OnTouchListener l) { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicate whether the popup window can grab the focus.</p>
 *
 * @return true if the popup is focusable, false otherwise
 *
 * @see #setFocusable(boolean)
 * @apiSince 1
 */

public boolean isFocusable() { throw new RuntimeException("Stub!"); }

/**
 * <p>Changes the focusability of the popup window. When focusable, the
 * window will grab the focus from the current focused widget if the popup
 * contains a focusable {@link android.view.View}.  By default a popup
 * window is not focusable.</p>
 *
 * <p>If the popup is showing, calling this method will take effect only
 * the next time the popup is shown or through a manual call to one of
 * the {@link #update()} methods.</p>
 *
 * @param focusable true if the popup should grab focus, false otherwise.
 *
 * @see #isFocusable()
 * @see #isShowing()
 * @see #update()
 * @apiSince 1
 */

public void setFocusable(boolean focusable) { throw new RuntimeException("Stub!"); }

/**
 * Return the current value in {@link #setInputMethodMode(int)}.
 *
 * @see #setInputMethodMode(int)
 * @apiSince 3
 */

public int getInputMethodMode() { throw new RuntimeException("Stub!"); }

/**
 * Control how the popup operates with an input method: one of
 * {@link #INPUT_METHOD_FROM_FOCUSABLE}, {@link #INPUT_METHOD_NEEDED},
 * or {@link #INPUT_METHOD_NOT_NEEDED}.
 *
 * <p>If the popup is showing, calling this method will take effect only
 * the next time the popup is shown or through a manual call to one of
 * the {@link #update()} methods.</p>
 *
 * @see #getInputMethodMode()
 * @see #update()
 * @apiSince 3
 */

public void setInputMethodMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Sets the operating mode for the soft input area.
 *
 * @param mode The desired mode, see
 *        {@link android.view.WindowManager.LayoutParams#softInputMode}
 *        for the full list
 *
 * Value is either <code>0</code> or a combination of {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_UNSPECIFIED}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_UNCHANGED}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_HIDDEN}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_ALWAYS_HIDDEN}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_VISIBLE}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_ALWAYS_VISIBLE}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_UNSPECIFIED}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_RESIZE}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_PAN}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_NOTHING}, and {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_IS_FORWARD_NAVIGATION}
 * @see android.view.WindowManager.LayoutParams#softInputMode
 * @see #getSoftInputMode()
 * @apiSince 4
 */

public void setSoftInputMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current value in {@link #setSoftInputMode(int)}.
 *
 * @see #setSoftInputMode(int)
 * @see android.view.WindowManager.LayoutParams#softInputMode
 
 * @return Value is either <code>0</code> or a combination of {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_UNSPECIFIED}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_UNCHANGED}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_HIDDEN}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_ALWAYS_HIDDEN}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_VISIBLE}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_ALWAYS_VISIBLE}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_UNSPECIFIED}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_RESIZE}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_PAN}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_NOTHING}, and {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_IS_FORWARD_NAVIGATION}
 * @apiSince 4
 */

public int getSoftInputMode() { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether the popup window receives touch events.</p>
 *
 * @return true if the popup is touchable, false otherwise
 *
 * @see #setTouchable(boolean)
 * @apiSince 3
 */

public boolean isTouchable() { throw new RuntimeException("Stub!"); }

/**
 * <p>Changes the touchability of the popup window. When touchable, the
 * window will receive touch events, otherwise touch events will go to the
 * window below it. By default the window is touchable.</p>
 *
 * <p>If the popup is showing, calling this method will take effect only
 * the next time the popup is shown or through a manual call to one of
 * the {@link #update()} methods.</p>
 *
 * @param touchable true if the popup should receive touch events, false otherwise
 *
 * @see #isTouchable()
 * @see #isShowing()
 * @see #update()
 * @apiSince 3
 */

public void setTouchable(boolean touchable) { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether the popup window will be informed of touch events
 * outside of its window.</p>
 *
 * @return true if the popup is outside touchable, false otherwise
 *
 * @see #setOutsideTouchable(boolean)
 * @apiSince 3
 */

public boolean isOutsideTouchable() { throw new RuntimeException("Stub!"); }

/**
 * <p>Controls whether the pop-up will be informed of touch events outside
 * of its window.  This only makes sense for pop-ups that are touchable
 * but not focusable, which means touches outside of the window will
 * be delivered to the window behind.  The default is false.</p>
 *
 * <p>If the popup is showing, calling this method will take effect only
 * the next time the popup is shown or through a manual call to one of
 * the {@link #update()} methods.</p>
 *
 * @param touchable true if the popup should receive outside
 * touch events, false otherwise
 *
 * @see #isOutsideTouchable()
 * @see #isShowing()
 * @see #update()
 * @apiSince 3
 */

public void setOutsideTouchable(boolean touchable) { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether clipping of the popup window is enabled.</p>
 *
 * @return true if the clipping is enabled, false otherwise
 *
 * @see #setClippingEnabled(boolean)
 * @apiSince 3
 */

public boolean isClippingEnabled() { throw new RuntimeException("Stub!"); }

/**
 * <p>Allows the popup window to extend beyond the bounds of the screen. By default the
 * window is clipped to the screen boundaries. Setting this to false will allow windows to be
 * accurately positioned.</p>
 *
 * <p>If the popup is showing, calling this method will take effect only
 * the next time the popup is shown or through a manual call to one of
 * the {@link #update()} methods.</p>
 *
 * @param enabled false if the window should be allowed to extend outside of the screen
 * @see #isShowing()
 * @see #isClippingEnabled()
 * @see #update()
 * @apiSince 3
 */

public void setClippingEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether this popup will be clipped to the screen and not to the
 * containing window<p/>
 *
 * @return true if popup will be clipped to the screen instead of the window, false otherwise
 *
 * @see #setIsClippedToScreen(boolean)
 * @apiSince 29
 */

public boolean isClippedToScreen() { throw new RuntimeException("Stub!"); }

/**
 * <p>Clip this popup window to the screen, but not to the containing window.</p>
 *
 * <p>If the popup is showing, calling this method will take effect only
 * the next time the popup is shown or through a manual call to one of
 * the {@link #update()} methods.</p>
 *
 * @param enabled true to clip to the screen.
 *
 * @see #isClippedToScreen()
 * @apiSince 29
 */

public void setIsClippedToScreen(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether the popup window supports splitting touches.</p>
 *
 * @return true if the touch splitting is enabled, false otherwise
 *
 * @see #setSplitTouchEnabled(boolean)
 * @apiSince 11
 */

public boolean isSplitTouchEnabled() { throw new RuntimeException("Stub!"); }

/**
 * <p>Allows the popup window to split touches across other windows that also
 * support split touch.  When this flag is false, the first pointer
 * that goes down determines the window to which all subsequent touches
 * go until all pointers go up.  When this flag is true, each pointer
 * (not necessarily the first) that goes down determines the window
 * to which all subsequent touches of that pointer will go until that
 * pointer goes up thereby enabling touches with multiple pointers
 * to be split across multiple windows.</p>
 *
 * @param enabled true if the split touches should be enabled, false otherwise
 * @see #isSplitTouchEnabled()
 * @apiSince 11
 */

public void setSplitTouchEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether the popup window will be forced into using absolute screen coordinates
 * for positioning.</p>
 *
 * @return true if the window will always be positioned in screen coordinates.
 *
 * @see #setIsLaidOutInScreen(boolean)
 * @apiSince 29
 */

public boolean isLaidOutInScreen() { throw new RuntimeException("Stub!"); }

/**
 * <p>Allows the popup window to force the flag
 * {@link android.view.WindowManager.LayoutParams#FLAG_LAYOUT_IN_SCREEN WindowManager.LayoutParams#FLAG_LAYOUT_IN_SCREEN}, overriding default behavior.
 * This will cause the popup to be positioned in absolute screen coordinates.</p>
 *
 * @param enabled true if the popup should always be positioned in screen coordinates
 *
 * @see #isLaidOutInScreen()
 * @apiSince 29
 */

public void setIsLaidOutInScreen(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether the popup window will be attached in the decor frame of its parent
 * window.
 *
 * @return true if the window will be attached to the decor frame of its parent window.
 *
 * @see #setAttachedInDecor(boolean)
 * @see android.view.WindowManager.LayoutParams#FLAG_LAYOUT_ATTACHED_IN_DECOR
 * @apiSince 22
 */

public boolean isAttachedInDecor() { throw new RuntimeException("Stub!"); }

/**
 * <p>This will attach the popup window to the decor frame of the parent window to avoid
 * overlaping with screen decorations like the navigation bar. Overrides the default behavior of
 * the flag {@link android.view.WindowManager.LayoutParams#FLAG_LAYOUT_ATTACHED_IN_DECOR WindowManager.LayoutParams#FLAG_LAYOUT_ATTACHED_IN_DECOR}.
 *
 * <p>By default the flag is set on SDK version {@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1 Build.VERSION_CODES#LOLLIPOP_MR1} or
 * greater and cleared on lesser SDK versions.
 *
 * @param enabled true if the popup should be attached to the decor frame of its parent window.
 *
 * @see android.view.WindowManager.LayoutParams#FLAG_LAYOUT_ATTACHED_IN_DECOR
 * @apiSince 22
 */

public void setAttachedInDecor(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Set the layout type for this window.
 * <p>
 * See {@link android.view.WindowManager.LayoutParams#type WindowManager.LayoutParams#type} for possible values.
 *
 * @param layoutType Layout type for this window.
 *
 * @see android.view.WindowManager.LayoutParams#type
 * @apiSince 23
 */

public void setWindowLayoutType(int layoutType) { throw new RuntimeException("Stub!"); }

/**
 * Returns the layout type for this window.
 *
 * @see #setWindowLayoutType(int)
 * @apiSince 23
 */

public int getWindowLayoutType() { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether outside touches will be sent to this window
 * or other windows behind it<p/>
 *
 * @return true if touches will be sent to this window, false otherwise
 *
 * @see #setTouchModal(boolean)
 * @apiSince 29
 */

public boolean isTouchModal() { throw new RuntimeException("Stub!"); }

/**
 * <p>Set whether this window is touch modal or if outside touches will be sent to
 * other windows behind it.<p/>
 *
 * <p>If the popup is showing, calling this method will take effect only
 * the next time the popup is shown or through a manual call to one of
 * the {@link #update()} methods.</p>
 *
 * @param touchModal true to sent all outside touches to this window,
 * false to other windows behind it
 *
 * @see #isTouchModal()
 * @apiSince 29
 */

public void setTouchModal(boolean touchModal) { throw new RuntimeException("Stub!"); }

/**
 * <p>Change the width and height measure specs that are given to the
 * window manager by the popup.  By default these are 0, meaning that
 * the current width or height is requested as an explicit size from
 * the window manager.  You can supply
 * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT ViewGroup.LayoutParams#WRAP_CONTENT} or
 * {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT ViewGroup.LayoutParams#MATCH_PARENT} to have that measure
 * spec supplied instead, replacing the absolute width and height that
 * has been set in the popup.</p>
 *
 * <p>If the popup is showing, calling this method will take effect only
 * the next time the popup is shown.</p>
 *
 * @param widthSpec an explicit width measure spec mode, either
 * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT ViewGroup.LayoutParams#WRAP_CONTENT},
 * {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT ViewGroup.LayoutParams#MATCH_PARENT}, or 0 to use the absolute
 * width.
 * @param heightSpec an explicit height measure spec mode, either
 * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT ViewGroup.LayoutParams#WRAP_CONTENT},
 * {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT ViewGroup.LayoutParams#MATCH_PARENT}, or 0 to use the absolute
 * height.
 *
 * @deprecated Use {@link #setWidth(int)} and {@link #setHeight(int)}.
 * @apiSince 3
 * @deprecatedSince 23
 */

@Deprecated
public void setWindowLayoutMode(int widthSpec, int heightSpec) { throw new RuntimeException("Stub!"); }

/**
 * Returns the popup's requested height. May be a layout constant such as
 * {@link android.view.WindowManager.LayoutParams#WRAP_CONTENT LayoutParams#WRAP_CONTENT} or {@link android.view.WindowManager.LayoutParams#MATCH_PARENT LayoutParams#MATCH_PARENT}.
 * <p>
 * The actual size of the popup may depend on other factors such as
 * clipping and window layout.
 *
 * @return the popup height in pixels or a layout constant
 * @see #setHeight(int)
 * @apiSince 1
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Sets the popup's requested height. May be a layout constant such as
 * {@link android.view.WindowManager.LayoutParams#WRAP_CONTENT LayoutParams#WRAP_CONTENT} or {@link android.view.WindowManager.LayoutParams#MATCH_PARENT LayoutParams#MATCH_PARENT}.
 * <p>
 * The actual size of the popup may depend on other factors such as
 * clipping and window layout.
 * <p>
 * If the popup is showing, calling this method will take effect the next
 * time the popup is shown.
 *
 * @param height the popup height in pixels or a layout constant
 * @see #getHeight()
 * @see #isShowing()
 * @apiSince 1
 */

public void setHeight(int height) { throw new RuntimeException("Stub!"); }

/**
 * Returns the popup's requested width. May be a layout constant such as
 * {@link android.view.WindowManager.LayoutParams#WRAP_CONTENT LayoutParams#WRAP_CONTENT} or {@link android.view.WindowManager.LayoutParams#MATCH_PARENT LayoutParams#MATCH_PARENT}.
 * <p>
 * The actual size of the popup may depend on other factors such as
 * clipping and window layout.
 *
 * @return the popup width in pixels or a layout constant
 * @see #setWidth(int)
 * @apiSince 1
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Sets the popup's requested width. May be a layout constant such as
 * {@link android.view.WindowManager.LayoutParams#WRAP_CONTENT LayoutParams#WRAP_CONTENT} or {@link android.view.WindowManager.LayoutParams#MATCH_PARENT LayoutParams#MATCH_PARENT}.
 * <p>
 * The actual size of the popup may depend on other factors such as
 * clipping and window layout.
 * <p>
 * If the popup is showing, calling this method will take effect the next
 * time the popup is shown.
 *
 * @param width the popup width in pixels or a layout constant
 * @see #getWidth()
 * @see #isShowing()
 * @apiSince 1
 */

public void setWidth(int width) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the popup window should overlap its anchor view when
 * displayed as a drop-down.
 * <p>
 * If the popup is showing, calling this method will take effect only
 * the next time the popup is shown.
 *
 * @param overlapAnchor Whether the popup should overlap its anchor.
 *
 * @see #getOverlapAnchor()
 * @see #isShowing()
 * @apiSince 23
 */

public void setOverlapAnchor(boolean overlapAnchor) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the popup window should overlap its anchor view when
 * displayed as a drop-down.
 *
 * @return Whether the popup should overlap its anchor.
 *
 * @see #setOverlapAnchor(boolean)
 * @apiSince 23
 */

public boolean getOverlapAnchor() { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicate whether this popup window is showing on screen.</p>
 *
 * @return true if the popup is showing, false otherwise
 * @apiSince 1
 */

public boolean isShowing() { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Display the content view in a popup window at the specified location. If the popup window
 * cannot fit on screen, it will be clipped. See {@link android.view.WindowManager.LayoutParams}
 * for more information on how gravity and the x and y parameters are related. Specifying
 * a gravity of {@link android.view.Gravity#NO_GRAVITY} is similar to specifying
 * <code>Gravity.LEFT | Gravity.TOP</code>.
 * </p>
 *
 * @param parent a parent view to get the {@link android.view.View#getWindowToken()} token from
 * @param gravity the gravity which controls the placement of the popup window
 * @param x the popup's x location offset
 * @param y the popup's y location offset
 * @apiSince 1
 */

public void showAtLocation(android.view.View parent, int gravity, int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * Display the content view in a popup window anchored to the bottom-left
 * corner of the anchor view. If there is not enough room on screen to show
 * the popup in its entirety, this method tries to find a parent scroll
 * view to scroll. If no parent scroll view can be scrolled, the
 * bottom-left corner of the popup is pinned at the top left corner of the
 * anchor view.
 *
 * @param anchor the view on which to pin the popup window
 *
 * @see #dismiss()
 * @apiSince 1
 */

public void showAsDropDown(android.view.View anchor) { throw new RuntimeException("Stub!"); }

/**
 * Display the content view in a popup window anchored to the bottom-left
 * corner of the anchor view offset by the specified x and y coordinates.
 * If there is not enough room on screen to show the popup in its entirety,
 * this method tries to find a parent scroll view to scroll. If no parent
 * scroll view can be scrolled, the bottom-left corner of the popup is
 * pinned at the top left corner of the anchor view.
 * <p>
 * If the view later scrolls to move <code>anchor</code> to a different
 * location, the popup will be moved correspondingly.
 *
 * @param anchor the view on which to pin the popup window
 * @param xoff A horizontal offset from the anchor in pixels
 * @param yoff A vertical offset from the anchor in pixels
 *
 * @see #dismiss()
 * @apiSince 1
 */

public void showAsDropDown(android.view.View anchor, int xoff, int yoff) { throw new RuntimeException("Stub!"); }

/**
 * Displays the content view in a popup window anchored to the corner of
 * another view. The window is positioned according to the specified
 * gravity and offset by the specified x and y coordinates.
 * <p>
 * If there is not enough room on screen to show the popup in its entirety,
 * this method tries to find a parent scroll view to scroll. If no parent
 * view can be scrolled, the specified vertical gravity will be ignored and
 * the popup will anchor itself such that it is visible.
 * <p>
 * If the view later scrolls to move <code>anchor</code> to a different
 * location, the popup will be moved correspondingly.
 *
 * @param anchor the view on which to pin the popup window
 * @param xoff A horizontal offset from the anchor in pixels
 * @param yoff A vertical offset from the anchor in pixels
 * @param gravity Alignment of the popup relative to the anchor
 *
 * @see #dismiss()
 * @apiSince 19
 */

public void showAsDropDown(android.view.View anchor, int xoff, int yoff, int gravity) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the popup is showing above (the y coordinate of the popup's bottom
 * is less than the y coordinate of the anchor) or below the anchor view (the y coordinate
 * of the popup is greater than y coordinate of the anchor's bottom).
 *
 * The value returned
 * by this method is meaningful only after {@link #showAsDropDown(android.view.View)}
 * or {@link #showAsDropDown(android.view.View,int,int)} was invoked.
 *
 * @return True if this popup is showing above the anchor view, false otherwise.
 * @apiSince 3
 */

public boolean isAboveAnchor() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum height that is available for the popup to be
 * completely shown. It is recommended that this height be the maximum for
 * the popup's height, otherwise it is possible that the popup will be
 * clipped.
 *
 * @param anchor The view on which the popup window must be anchored.
 * This value must never be {@code null}.
 * @return The maximum available height for the popup to be completely
 *         shown.
 * @apiSince 1
 */

public int getMaxAvailableHeight(@androidx.annotation.NonNull android.view.View anchor) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum height that is available for the popup to be
 * completely shown. It is recommended that this height be the maximum for
 * the popup's height, otherwise it is possible that the popup will be
 * clipped.
 *
 * @param anchor The view on which the popup window must be anchored.
 * This value must never be {@code null}.
 * @param yOffset y offset from the view's bottom edge
 * @return The maximum available height for the popup to be completely
 *         shown.
 * @apiSince 3
 */

public int getMaxAvailableHeight(@androidx.annotation.NonNull android.view.View anchor, int yOffset) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum height that is available for the popup to be
 * completely shown, optionally ignoring any bottom decorations such as
 * the input method. It is recommended that this height be the maximum for
 * the popup's height, otherwise it is possible that the popup will be
 * clipped.
 *
 * @param anchor The view on which the popup window must be anchored.
 * This value must never be {@code null}.
 * @param yOffset y offset from the view's bottom edge
 * @param ignoreBottomDecorations if true, the height returned will be
 *        all the way to the bottom of the display, ignoring any
 *        bottom decorations
 * @return The maximum available height for the popup to be completely
 *         shown.
 * @apiSince 24
 */

public int getMaxAvailableHeight(@androidx.annotation.NonNull android.view.View anchor, int yOffset, boolean ignoreBottomDecorations) { throw new RuntimeException("Stub!"); }

/**
 * Disposes of the popup window. This method can be invoked only after
 * {@link #showAsDropDown(android.view.View)} has been executed. Failing
 * that, calling this method will have no effect.
 *
 * @see #showAsDropDown(android.view.View)
 * @apiSince 1
 */

public void dismiss() { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to be called when the window is dismissed.
 *
 * @param onDismissListener The listener.
 * @apiSince 1
 */

public void setOnDismissListener(android.widget.PopupWindow.OnDismissListener onDismissListener) { throw new RuntimeException("Stub!"); }

/**
 * Updates the state of the popup window, if it is currently being displayed,
 * from the currently set state.
 * <p>
 * This includes:
 * <ul>
 *     <li>{@link #setClippingEnabled(boolean)}</li>
 *     <li>{@link #setFocusable(boolean)}</li>
 *     <li>{@link #setIgnoreCheekPress()}</li>
 *     <li>{@link #setInputMethodMode(int)}</li>
 *     <li>{@link #setTouchable(boolean)}</li>
 *     <li>{@link #setAnimationStyle(int)}</li>
 *     <li>{@link #setTouchModal(boolean)} (boolean)}</li>
 *     <li>{@link #setIsClippedToScreen(boolean)}</li>
 * </ul>
 * @apiSince 3
 */

public void update() { throw new RuntimeException("Stub!"); }

/**
 * Updates the dimension of the popup window.
 * <p>
 * Calling this function also updates the window with the current popup
 * state as described for {@link #update()}.
 *
 * @param width the new width in pixels, must be >= 0 or -1 to ignore
 * @param height the new height in pixels, must be >= 0 or -1 to ignore
 * @apiSince 4
 */

public void update(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Updates the position and the dimension of the popup window.
 * <p>
 * Width and height can be set to -1 to update location only. Calling this
 * function also updates the window with the current popup state as
 * described for {@link #update()}.
 *
 * @param x the new x location
 * @param y the new y location
 * @param width the new width in pixels, must be >= 0 or -1 to ignore
 * @param height the new height in pixels, must be >= 0 or -1 to ignore
 * @apiSince 1
 */

public void update(int x, int y, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Updates the position and the dimension of the popup window.
 * <p>
 * Width and height can be set to -1 to update location only. Calling this
 * function also updates the window with the current popup state as
 * described for {@link #update()}.
 *
 * @param x the new x location
 * @param y the new y location
 * @param width the new width in pixels, must be >= 0 or -1 to ignore
 * @param height the new height in pixels, must be >= 0 or -1 to ignore
 * @param force {@code true} to reposition the window even if the specified
 *              position already seems to correspond to the LayoutParams,
 *              {@code false} to only reposition if needed
 * @apiSince 3
 */

public void update(int x, int y, int width, int height, boolean force) { throw new RuntimeException("Stub!"); }

/**
 * Updates the position and the dimension of the popup window.
 * <p>
 * Calling this function also updates the window with the current popup
 * state as described for {@link #update()}.
 *
 * @param anchor the popup's anchor view
 * @param width the new width in pixels, must be >= 0 or -1 to ignore
 * @param height the new height in pixels, must be >= 0 or -1 to ignore
 * @apiSince 1
 */

public void update(android.view.View anchor, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Updates the position and the dimension of the popup window.
 * <p>
 * Width and height can be set to -1 to update location only. Calling this
 * function also updates the window with the current popup state as
 * described for {@link #update()}.
 * <p>
 * If the view later scrolls to move {@code anchor} to a different
 * location, the popup will be moved correspondingly.
 *
 * @param anchor the popup's anchor view
 * @param xoff x offset from the view's left edge
 * @param yoff y offset from the view's bottom edge
 * @param width the new width in pixels, must be >= 0 or -1 to ignore
 * @param height the new height in pixels, must be >= 0 or -1 to ignore
 * @apiSince 1
 */

public void update(android.view.View anchor, int xoff, int yoff, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Mode for {@link #setInputMethodMode(int)}: the requirements for the
 * input method should be based on the focusability of the popup.  That is
 * if it is focusable than it needs to work with the input method, else
 * it doesn't.
 * @apiSince 3
 */

public static final int INPUT_METHOD_FROM_FOCUSABLE = 0; // 0x0

/**
 * Mode for {@link #setInputMethodMode(int)}: this popup always needs to
 * work with an input method, regardless of whether it is focusable.  This
 * means that it will always be displayed so that the user can also operate
 * the input method while it is shown.
 * @apiSince 3
 */

public static final int INPUT_METHOD_NEEDED = 1; // 0x1

/**
 * Mode for {@link #setInputMethodMode(int)}: this popup never needs to
 * work with an input method, regardless of whether it is focusable.  This
 * means that it will always be displayed to use as much space on the
 * screen as needed, regardless of whether this covers the input method.
 * @apiSince 3
 */

public static final int INPUT_METHOD_NOT_NEEDED = 2; // 0x2
/**
 * Listener that is called when this popup window is dismissed.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDismissListener {

/**
 * Called when this popup window is dismissed.
 * @apiSince 1
 */

public void onDismiss();
}

}

