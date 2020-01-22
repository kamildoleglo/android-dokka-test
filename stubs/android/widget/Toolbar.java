/*
 * Copyright (C) 2014 The Android Open Source Project
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

import android.app.ActionBar;
import android.view.Gravity;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.Menu;
import android.text.Layout;

/**
 * A standard toolbar for use within application content.
 *
 * <p>A Toolbar is a generalization of {@link android.app.ActionBar action bars} for use
 * within application layouts. While an action bar is traditionally part of an
 * {@link android.app.Activity Activity's} opaque window decor controlled by the framework,
 * a Toolbar may be placed at any arbitrary level of nesting within a view hierarchy.
 * An application may choose to designate a Toolbar as the action bar for an Activity
 * using the {@link android.app.Activity#setActionBar(Toolbar) setActionBar()} method.</p>
 *
 * <p>Toolbar supports a more focused feature set than ActionBar. From start to end, a toolbar
 * may contain a combination of the following optional elements:
 *
 * <ul>
 *     <li><em>A navigation button.</em> This may be an Up arrow, navigation menu toggle, close,
 *     collapse, done or another glyph of the app's choosing. This button should always be used
 *     to access other navigational destinations within the container of the Toolbar and
 *     its signified content or otherwise leave the current context signified by the Toolbar.
 *     The navigation button is vertically aligned within the Toolbar's
 *     {@link android.R.styleable#View_minHeight minimum height}, if set.</li>
 *     <li><em>A branded logo image.</em> This may extend to the height of the bar and can be
 *     arbitrarily wide.</li>
 *     <li><em>A title and subtitle.</em> The title should be a signpost for the Toolbar's current
 *     position in the navigation hierarchy and the content contained there. The subtitle,
 *     if present should indicate any extended information about the current content.
 *     If an app uses a logo image it should strongly consider omitting a title and subtitle.</li>
 *     <li><em>One or more custom views.</em> The application may add arbitrary child views
 *     to the Toolbar. They will appear at this position within the layout. If a child view's
 *     {@link android.widget.Toolbar.LayoutParams LayoutParams} indicates a {@link android.view.Gravity Gravity} value of
 *     {@link android.view.Gravity#CENTER_HORIZONTAL Gravity#CENTER_HORIZONTAL} the view will attempt to center
 *     within the available space remaining in the Toolbar after all other elements have been
 *     measured.</li>
 *     <li><em>An {@link android.widget.ActionMenuView ActionMenuView}.</em> The menu of actions will pin to the
 *     end of the Toolbar offering a few
 *     <a href="http://developer.android.com/design/patterns/actionbar.html#ActionButtons">
 *     frequent, important or typical</a> actions along with an optional overflow menu for
 *     additional actions. Action buttons are vertically aligned within the Toolbar's
 *     {@link android.R.styleable#View_minHeight minimum height}, if set.</li>
 * </ul>
 * </p>
 *
 * <p>In modern Android UIs developers should lean more on a visually distinct color scheme for
 * toolbars than on their application icon. The use of application icon plus title as a standard
 * layout is discouraged on API 21 devices and newer.</p>
 *
 * @attr ref android.R.styleable#Toolbar_buttonGravity
 * @attr ref android.R.styleable#Toolbar_collapseContentDescription
 * @attr ref android.R.styleable#Toolbar_collapseIcon
 * @attr ref android.R.styleable#Toolbar_contentInsetEnd
 * @attr ref android.R.styleable#Toolbar_contentInsetLeft
 * @attr ref android.R.styleable#Toolbar_contentInsetRight
 * @attr ref android.R.styleable#Toolbar_contentInsetStart
 * @attr ref android.R.styleable#Toolbar_contentInsetStartWithNavigation
 * @attr ref android.R.styleable#Toolbar_contentInsetEndWithActions
 * @attr ref android.R.styleable#Toolbar_gravity
 * @attr ref android.R.styleable#Toolbar_logo
 * @attr ref android.R.styleable#Toolbar_logoDescription
 * @attr ref android.R.styleable#Toolbar_maxButtonHeight
 * @attr ref android.R.styleable#Toolbar_navigationContentDescription
 * @attr ref android.R.styleable#Toolbar_navigationIcon
 * @attr ref android.R.styleable#Toolbar_popupTheme
 * @attr ref android.R.styleable#Toolbar_subtitle
 * @attr ref android.R.styleable#Toolbar_subtitleTextAppearance
 * @attr ref android.R.styleable#Toolbar_subtitleTextColor
 * @attr ref android.R.styleable#Toolbar_title
 * @attr ref android.R.styleable#Toolbar_titleMargin
 * @attr ref android.R.styleable#Toolbar_titleMarginBottom
 * @attr ref android.R.styleable#Toolbar_titleMarginEnd
 * @attr ref android.R.styleable#Toolbar_titleMarginStart
 * @attr ref android.R.styleable#Toolbar_titleMarginTop
 * @attr ref android.R.styleable#Toolbar_titleTextAppearance
 * @attr ref android.R.styleable#Toolbar_titleTextColor
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Toolbar extends android.view.ViewGroup {

/** @apiSince 21 */

public Toolbar(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public Toolbar(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public Toolbar(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public Toolbar(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the theme to use when inflating popup menus. By default, uses
 * the same theme as the toolbar itself.
 *
 * @param resId theme used to inflate popup menus
 * @see #getPopupTheme()
 * @apiSince 21
 */

public void setPopupTheme(int resId) { throw new RuntimeException("Stub!"); }

/**
 * @return resource identifier of the theme used to inflate popup menus, or
 *         0 if menus are inflated against the toolbar theme
 * @see #setPopupTheme(int)
 * @apiSince 21
 */

public int getPopupTheme() { throw new RuntimeException("Stub!"); }

/**
 * Sets the title margin.
 *
 * @param start the starting title margin in pixels
 * @param top the top title margin in pixels
 * @param end the ending title margin in pixels
 * @param bottom the bottom title margin in pixels
 * @see #getTitleMarginStart()
 * @see #getTitleMarginTop()
 * @see #getTitleMarginEnd()
 * @see #getTitleMarginBottom()
 * @attr ref android.R.styleable#Toolbar_titleMargin
 * @apiSince 24
 */

public void setTitleMargin(int start, int top, int end, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * @return the starting title margin in pixels
 * @see #setTitleMarginStart(int)
 * @attr ref android.R.styleable#Toolbar_titleMarginStart
 * @apiSince 24
 */

public int getTitleMarginStart() { throw new RuntimeException("Stub!"); }

/**
 * Sets the starting title margin in pixels.
 *
 * @param margin the starting title margin in pixels
 * @see #getTitleMarginStart()
 * @attr ref android.R.styleable#Toolbar_titleMarginStart
 * @apiSince 24
 */

public void setTitleMarginStart(int margin) { throw new RuntimeException("Stub!"); }

/**
 * @return the top title margin in pixels
 * @see #setTitleMarginTop(int)
 * @attr ref android.R.styleable#Toolbar_titleMarginTop
 * @apiSince 24
 */

public int getTitleMarginTop() { throw new RuntimeException("Stub!"); }

/**
 * Sets the top title margin in pixels.
 *
 * @param margin the top title margin in pixels
 * @see #getTitleMarginTop()
 * @attr ref android.R.styleable#Toolbar_titleMarginTop
 * @apiSince 24
 */

public void setTitleMarginTop(int margin) { throw new RuntimeException("Stub!"); }

/**
 * @return the ending title margin in pixels
 * @see #setTitleMarginEnd(int)
 * @attr ref android.R.styleable#Toolbar_titleMarginEnd
 * @apiSince 24
 */

public int getTitleMarginEnd() { throw new RuntimeException("Stub!"); }

/**
 * Sets the ending title margin in pixels.
 *
 * @param margin the ending title margin in pixels
 * @see #getTitleMarginEnd()
 * @attr ref android.R.styleable#Toolbar_titleMarginEnd
 * @apiSince 24
 */

public void setTitleMarginEnd(int margin) { throw new RuntimeException("Stub!"); }

/**
 * @return the bottom title margin in pixels
 * @see #setTitleMarginBottom(int)
 * @attr ref android.R.styleable#Toolbar_titleMarginBottom
 * @apiSince 24
 */

public int getTitleMarginBottom() { throw new RuntimeException("Stub!"); }

/**
 * Sets the bottom title margin in pixels.
 *
 * @param margin the bottom title margin in pixels
 * @see #getTitleMarginBottom()
 * @attr ref android.R.styleable#Toolbar_titleMarginBottom
 * @apiSince 24
 */

public void setTitleMarginBottom(int margin) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param layoutDirection Value is {@link android.view.View#LAYOUT_DIRECTION_LTR}, or {@link android.view.View#LAYOUT_DIRECTION_RTL}
 * @apiSince 21
 */

public void onRtlPropertiesChanged(int layoutDirection) { throw new RuntimeException("Stub!"); }

/**
 * Set a logo drawable from a resource id.
 *
 * <p>This drawable should generally take the place of title text. The logo cannot be
 * clicked. Apps using a logo should also supply a description using
 * {@link #setLogoDescription(int)}.</p>
 *
 * @param resId ID of a drawable resource
 * @apiSince 21
 */

public void setLogo(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Check whether the overflow menu is currently showing. This may not reflect
 * a pending show operation in progress.
 *
 * @return true if the overflow menu is currently showing
 * @apiSince 21
 */

public boolean isOverflowMenuShowing() { throw new RuntimeException("Stub!"); }

/**
 * Show the overflow items from the associated menu.
 *
 * @return true if the menu was able to be shown, false otherwise
 * @apiSince 21
 */

public boolean showOverflowMenu() { throw new RuntimeException("Stub!"); }

/**
 * Hide the overflow items from the associated menu.
 *
 * @return true if the menu was able to be hidden, false otherwise
 * @apiSince 21
 */

public boolean hideOverflowMenu() { throw new RuntimeException("Stub!"); }

/**
 * Dismiss all currently showing popup menus, including overflow or submenus.
 * @apiSince 21
 */

public void dismissPopupMenus() { throw new RuntimeException("Stub!"); }

/**
 * Set a logo drawable.
 *
 * <p>This drawable should generally take the place of title text. The logo cannot be
 * clicked. Apps using a logo should also supply a description using
 * {@link #setLogoDescription(int)}.</p>
 *
 * @param drawable Drawable to use as a logo
 * @apiSince 21
 */

public void setLogo(android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Return the current logo drawable.
 *
 * @return The current logo drawable
 * @see #setLogo(int)
 * @see #setLogo(android.graphics.drawable.Drawable)
 * @apiSince 21
 */

public android.graphics.drawable.Drawable getLogo() { throw new RuntimeException("Stub!"); }

/**
 * Set a description of the toolbar's logo.
 *
 * <p>This description will be used for accessibility or other similar descriptions
 * of the UI.</p>
 *
 * @param resId String resource id
 * @apiSince 21
 */

public void setLogoDescription(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Set a description of the toolbar's logo.
 *
 * <p>This description will be used for accessibility or other similar descriptions
 * of the UI.</p>
 *
 * @param description Description to set
 * @apiSince 21
 */

public void setLogoDescription(java.lang.CharSequence description) { throw new RuntimeException("Stub!"); }

/**
 * Return the description of the toolbar's logo.
 *
 * @return A description of the logo
 * @apiSince 21
 */

public java.lang.CharSequence getLogoDescription() { throw new RuntimeException("Stub!"); }

/**
 * Check whether this Toolbar is currently hosting an expanded action view.
 *
 * <p>An action view may be expanded either directly from the
 * {@link android.view.MenuItem MenuItem} it belongs to or by user action. If the Toolbar
 * has an expanded action view it can be collapsed using the {@link #collapseActionView()}
 * method.</p>
 *
 * @return true if the Toolbar has an expanded action view
 * @apiSince 21
 */

public boolean hasExpandedActionView() { throw new RuntimeException("Stub!"); }

/**
 * Collapse a currently expanded action view. If this Toolbar does not have an
 * expanded action view this method has no effect.
 *
 * <p>An action view may be expanded either directly from the
 * {@link android.view.MenuItem MenuItem} it belongs to or by user action.</p>
 *
 * @see #hasExpandedActionView()
 * @apiSince 21
 */

public void collapseActionView() { throw new RuntimeException("Stub!"); }

/**
 * Returns the title of this toolbar.
 *
 * @return The current title.
 * @apiSince 21
 */

public java.lang.CharSequence getTitle() { throw new RuntimeException("Stub!"); }

/**
 * Set the title of this toolbar.
 *
 * <p>A title should be used as the anchor for a section of content. It should
 * describe or name the content being viewed.</p>
 *
 * @param resId Resource ID of a string to set as the title
 * @apiSince 21
 */

public void setTitle(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Set the title of this toolbar.
 *
 * <p>A title should be used as the anchor for a section of content. It should
 * describe or name the content being viewed.</p>
 *
 * @param title Title to set
 * @apiSince 21
 */

public void setTitle(java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Return the subtitle of this toolbar.
 *
 * @return The current subtitle
 * @apiSince 21
 */

public java.lang.CharSequence getSubtitle() { throw new RuntimeException("Stub!"); }

/**
 * Set the subtitle of this toolbar.
 *
 * <p>Subtitles should express extended information about the current content.</p>
 *
 * @param resId String resource ID
 * @apiSince 21
 */

public void setSubtitle(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Set the subtitle of this toolbar.
 *
 * <p>Subtitles should express extended information about the current content.</p>
 *
 * @param subtitle Subtitle to set
 * @apiSince 21
 */

public void setSubtitle(java.lang.CharSequence subtitle) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text color, size, style, hint color, and highlight color
 * from the specified TextAppearance resource.
 * @apiSince 21
 */

public void setTitleTextAppearance(android.content.Context context, int resId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text color, size, style, hint color, and highlight color
 * from the specified TextAppearance resource.
 * @apiSince 21
 */

public void setSubtitleTextAppearance(android.content.Context context, int resId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text color of the title, if present.
 *
 * @param color The new text color in 0xAARRGGBB format
 * @apiSince 21
 */

public void setTitleTextColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text color of the subtitle, if present.
 *
 * @param color The new text color in 0xAARRGGBB format
 * @apiSince 21
 */

public void setSubtitleTextColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the currently configured content description for the navigation button view.
 * This will be used to describe the navigation action to users through mechanisms such
 * as screen readers or tooltips.
 *
 * @return The navigation button's content description
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#Toolbar_navigationContentDescription
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getNavigationContentDescription() { throw new RuntimeException("Stub!"); }

/**
 * Set a content description for the navigation button if one is present. The content
 * description will be read via screen readers or other accessibility systems to explain
 * the action of the navigation button.
 *
 * @param resId Resource ID of a content description string to set, or 0 to
 *              clear the description
 *
 * @attr ref android.R.styleable#Toolbar_navigationContentDescription
 * @apiSince 21
 */

public void setNavigationContentDescription(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Set a content description for the navigation button if one is present. The content
 * description will be read via screen readers or other accessibility systems to explain
 * the action of the navigation button.
 *
 * @param description Content description to set, or <code>null</code> to
 *                    clear the content description
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#Toolbar_navigationContentDescription
 * @apiSince 21
 */

public void setNavigationContentDescription(@androidx.annotation.Nullable java.lang.CharSequence description) { throw new RuntimeException("Stub!"); }

/**
 * Set the icon to use for the toolbar's navigation button.
 *
 * <p>The navigation button appears at the start of the toolbar if present. Setting an icon
 * will make the navigation button visible.</p>
 *
 * <p>If you use a navigation icon you should also set a description for its action using
 * {@link #setNavigationContentDescription(int)}. This is used for accessibility and
 * tooltips.</p>
 *
 * @param resId Resource ID of a drawable to set
 *
 * @attr ref android.R.styleable#Toolbar_navigationIcon
 * @apiSince 21
 */

public void setNavigationIcon(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Set the icon to use for the toolbar's navigation button.
 *
 * <p>The navigation button appears at the start of the toolbar if present. Setting an icon
 * will make the navigation button visible.</p>
 *
 * <p>If you use a navigation icon you should also set a description for its action using
 * {@link #setNavigationContentDescription(int)}. This is used for accessibility and
 * tooltips.</p>
 *
 * @param icon Drawable to set, may be null to clear the icon
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#Toolbar_navigationIcon
 * @apiSince 21
 */

public void setNavigationIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable icon) { throw new RuntimeException("Stub!"); }

/**
 * Return the current drawable used as the navigation icon.
 *
 * @return The navigation icon drawable
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#Toolbar_navigationIcon
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable getNavigationIcon() { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to respond to navigation events.
 *
 * <p>This listener will be called whenever the user clicks the navigation button
 * at the start of the toolbar. An icon must be set for the navigation button to appear.</p>
 *
 * @param listener Listener to set
 * @see #setNavigationIcon(android.graphics.drawable.Drawable)
 * @apiSince 21
 */

public void setNavigationOnClickListener(android.view.View.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the currently configured content description for the collapse button view.
 * This will be used to describe the collapse action to users through mechanisms such
 * as screen readers or tooltips.
 *
 * @return The collapse button's content description
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#Toolbar_collapseContentDescription
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getCollapseContentDescription() { throw new RuntimeException("Stub!"); }

/**
 * Set a content description for the collapse button if one is present. The content description
 * will be read via screen readers or other accessibility systems to explain the action of the
 * collapse button.
 *
 * @param resId Resource ID of a content description string to set, or 0 to
 *              clear the description
 *
 * @attr ref android.R.styleable#Toolbar_collapseContentDescription
 * @apiSince 29
 */

public void setCollapseContentDescription(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Set a content description for the collapse button if one is present. The content description
 * will be read via screen readers or other accessibility systems to explain the action of the
 * navigation button.
 *
 * @param description Content description to set, or <code>null</code> to
 *                    clear the content description
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#Toolbar_collapseContentDescription
 * @apiSince 29
 */

public void setCollapseContentDescription(@androidx.annotation.Nullable java.lang.CharSequence description) { throw new RuntimeException("Stub!"); }

/**
 * Return the current drawable used as the collapse icon.
 *
 * @return The collapse icon drawable
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#Toolbar_collapseIcon
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable getCollapseIcon() { throw new RuntimeException("Stub!"); }

/**
 * Set the icon to use for the toolbar's collapse button.
 *
 * <p>The collapse button appears at the start of the toolbar when an action view is present
 * .</p>
 *
 * @param resId Resource ID of a drawable to set
 *
 * @attr ref android.R.styleable#Toolbar_collapseIcon
 * @apiSince 29
 */

public void setCollapseIcon(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Set the icon to use for the toolbar's collapse button.
 *
 * <p>The collapse button appears at the start of the toolbar when an action view is present
 * .</p>
 *
 * @param icon Drawable to set, may be null to use the default icon
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#Toolbar_collapseIcon
 * @apiSince 29
 */

public void setCollapseIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable icon) { throw new RuntimeException("Stub!"); }

/**
 * Return the Menu shown in the toolbar.
 *
 * <p>Applications that wish to populate the toolbar's menu can do so from here. To use
 * an XML menu resource, use {@link #inflateMenu(int)}.</p>
 *
 * @return The toolbar's Menu
 * @apiSince 21
 */

public android.view.Menu getMenu() { throw new RuntimeException("Stub!"); }

/**
 * Set the icon to use for the overflow button.
 *
 * @param icon Drawable to set, may be null to clear the icon
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public void setOverflowIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable icon) { throw new RuntimeException("Stub!"); }

/**
 * Return the current drawable used as the overflow icon.
 *
 * @return The overflow icon drawable
 
 * This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable getOverflowIcon() { throw new RuntimeException("Stub!"); }

/**
 * Inflate a menu resource into this toolbar.
 *
 * <p>Inflate an XML menu resource into this toolbar. Existing items in the menu will not
 * be modified or removed.</p>
 *
 * @param resId ID of a menu resource to inflate
 * @apiSince 21
 */

public void inflateMenu(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to respond to menu item click events.
 *
 * <p>This listener will be invoked whenever a user selects a menu item from
 * the action buttons presented at the end of the toolbar or the associated overflow.</p>
 *
 * @param listener Listener to set
 * @apiSince 21
 */

public void setOnMenuItemClickListener(android.widget.Toolbar.OnMenuItemClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the content insets for this toolbar relative to layout direction.
 *
 * <p>The content inset affects the valid area for Toolbar content other than
 * the navigation button and menu. Insets define the minimum margin for these components
 * and can be used to effectively align Toolbar content along well-known gridlines.</p>
 *
 * @param contentInsetStart Content inset for the toolbar starting edge
 * @param contentInsetEnd Content inset for the toolbar ending edge
 *
 * @see #setContentInsetsAbsolute(int, int)
 * @see #getContentInsetStart()
 * @see #getContentInsetEnd()
 * @see #getContentInsetLeft()
 * @see #getContentInsetRight()
 * @attr ref android.R.styleable#Toolbar_contentInsetEnd
 * @attr ref android.R.styleable#Toolbar_contentInsetStart
 * @apiSince 21
 */

public void setContentInsetsRelative(int contentInsetStart, int contentInsetEnd) { throw new RuntimeException("Stub!"); }

/**
 * Gets the starting content inset for this toolbar.
 *
 * <p>The content inset affects the valid area for Toolbar content other than
 * the navigation button and menu. Insets define the minimum margin for these components
 * and can be used to effectively align Toolbar content along well-known gridlines.</p>
 *
 * @return The starting content inset for this toolbar
 *
 * @see #setContentInsetsRelative(int, int)
 * @see #setContentInsetsAbsolute(int, int)
 * @see #getContentInsetEnd()
 * @see #getContentInsetLeft()
 * @see #getContentInsetRight()
 * @attr ref android.R.styleable#Toolbar_contentInsetStart
 * @apiSince 21
 */

public int getContentInsetStart() { throw new RuntimeException("Stub!"); }

/**
 * Gets the ending content inset for this toolbar.
 *
 * <p>The content inset affects the valid area for Toolbar content other than
 * the navigation button and menu. Insets define the minimum margin for these components
 * and can be used to effectively align Toolbar content along well-known gridlines.</p>
 *
 * @return The ending content inset for this toolbar
 *
 * @see #setContentInsetsRelative(int, int)
 * @see #setContentInsetsAbsolute(int, int)
 * @see #getContentInsetStart()
 * @see #getContentInsetLeft()
 * @see #getContentInsetRight()
 * @attr ref android.R.styleable#Toolbar_contentInsetEnd
 * @apiSince 21
 */

public int getContentInsetEnd() { throw new RuntimeException("Stub!"); }

/**
 * Sets the content insets for this toolbar.
 *
 * <p>The content inset affects the valid area for Toolbar content other than
 * the navigation button and menu. Insets define the minimum margin for these components
 * and can be used to effectively align Toolbar content along well-known gridlines.</p>
 *
 * @param contentInsetLeft Content inset for the toolbar's left edge
 * @param contentInsetRight Content inset for the toolbar's right edge
 *
 * @see #setContentInsetsAbsolute(int, int)
 * @see #getContentInsetStart()
 * @see #getContentInsetEnd()
 * @see #getContentInsetLeft()
 * @see #getContentInsetRight()
 * @attr ref android.R.styleable#Toolbar_contentInsetLeft
 * @attr ref android.R.styleable#Toolbar_contentInsetRight
 * @apiSince 21
 */

public void setContentInsetsAbsolute(int contentInsetLeft, int contentInsetRight) { throw new RuntimeException("Stub!"); }

/**
 * Gets the left content inset for this toolbar.
 *
 * <p>The content inset affects the valid area for Toolbar content other than
 * the navigation button and menu. Insets define the minimum margin for these components
 * and can be used to effectively align Toolbar content along well-known gridlines.</p>
 *
 * @return The left content inset for this toolbar
 *
 * @see #setContentInsetsRelative(int, int)
 * @see #setContentInsetsAbsolute(int, int)
 * @see #getContentInsetStart()
 * @see #getContentInsetEnd()
 * @see #getContentInsetRight()
 * @attr ref android.R.styleable#Toolbar_contentInsetLeft
 * @apiSince 21
 */

public int getContentInsetLeft() { throw new RuntimeException("Stub!"); }

/**
 * Gets the right content inset for this toolbar.
 *
 * <p>The content inset affects the valid area for Toolbar content other than
 * the navigation button and menu. Insets define the minimum margin for these components
 * and can be used to effectively align Toolbar content along well-known gridlines.</p>
 *
 * @return The right content inset for this toolbar
 *
 * @see #setContentInsetsRelative(int, int)
 * @see #setContentInsetsAbsolute(int, int)
 * @see #getContentInsetStart()
 * @see #getContentInsetEnd()
 * @see #getContentInsetLeft()
 * @attr ref android.R.styleable#Toolbar_contentInsetRight
 * @apiSince 21
 */

public int getContentInsetRight() { throw new RuntimeException("Stub!"); }

/**
 * Gets the start content inset to use when a navigation button is present.
 *
 * <p>Different content insets are often called for when additional buttons are present
 * in the toolbar, as well as at different toolbar sizes. The larger value of
 * {@link #getContentInsetStart()} and this value will be used during layout.</p>
 *
 * @return the start content inset used when a navigation icon has been set in pixels
 *
 * @see #setContentInsetStartWithNavigation(int)
 * @attr ref android.R.styleable#Toolbar_contentInsetStartWithNavigation
 * @apiSince 24
 */

public int getContentInsetStartWithNavigation() { throw new RuntimeException("Stub!"); }

/**
 * Sets the start content inset to use when a navigation button is present.
 *
 * <p>Different content insets are often called for when additional buttons are present
 * in the toolbar, as well as at different toolbar sizes. The larger value of
 * {@link #getContentInsetStart()} and this value will be used during layout.</p>
 *
 * @param insetStartWithNavigation the inset to use when a navigation icon has been set
 *                                 in pixels
 *
 * @see #getContentInsetStartWithNavigation()
 * @attr ref android.R.styleable#Toolbar_contentInsetStartWithNavigation
 * @apiSince 24
 */

public void setContentInsetStartWithNavigation(int insetStartWithNavigation) { throw new RuntimeException("Stub!"); }

/**
 * Gets the end content inset to use when action buttons are present.
 *
 * <p>Different content insets are often called for when additional buttons are present
 * in the toolbar, as well as at different toolbar sizes. The larger value of
 * {@link #getContentInsetEnd()} and this value will be used during layout.</p>
 *
 * @return the end content inset used when a menu has been set in pixels
 *
 * @see #setContentInsetEndWithActions(int)
 * @attr ref android.R.styleable#Toolbar_contentInsetEndWithActions
 * @apiSince 24
 */

public int getContentInsetEndWithActions() { throw new RuntimeException("Stub!"); }

/**
 * Sets the start content inset to use when action buttons are present.
 *
 * <p>Different content insets are often called for when additional buttons are present
 * in the toolbar, as well as at different toolbar sizes. The larger value of
 * {@link #getContentInsetEnd()} and this value will be used during layout.</p>
 *
 * @param insetEndWithActions the inset to use when a menu has been set in pixels
 *
 * @see #setContentInsetEndWithActions(int)
 * @attr ref android.R.styleable#Toolbar_contentInsetEndWithActions
 * @apiSince 24
 */

public void setContentInsetEndWithActions(int insetEndWithActions) { throw new RuntimeException("Stub!"); }

/**
 * Gets the content inset that will be used on the starting side of the bar in the current
 * toolbar configuration.
 *
 * @return the current content inset start in pixels
 *
 * @see #getContentInsetStartWithNavigation()
 * @apiSince 24
 */

public int getCurrentContentInsetStart() { throw new RuntimeException("Stub!"); }

/**
 * Gets the content inset that will be used on the ending side of the bar in the current
 * toolbar configuration.
 *
 * @return the current content inset end in pixels
 *
 * @see #getContentInsetEndWithActions()
 * @apiSince 24
 */

public int getCurrentContentInsetEnd() { throw new RuntimeException("Stub!"); }

/**
 * Gets the content inset that will be used on the left side of the bar in the current
 * toolbar configuration.
 *
 * @return the current content inset left in pixels
 *
 * @see #getContentInsetStartWithNavigation()
 * @see #getContentInsetEndWithActions()
 * @apiSince 24
 */

public int getCurrentContentInsetLeft() { throw new RuntimeException("Stub!"); }

/**
 * Gets the content inset that will be used on the right side of the bar in the current
 * toolbar configuration.
 *
 * @return the current content inset right in pixels
 *
 * @see #getContentInsetStartWithNavigation()
 * @see #getContentInsetEndWithActions()
 * @apiSince 24
 */

public int getCurrentContentInsetRight() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean onTouchEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void onLayout(boolean changed, int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.widget.Toolbar.LayoutParams generateLayoutParams(android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected android.widget.Toolbar.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected android.widget.Toolbar.LayoutParams generateDefaultLayoutParams() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }
/**
 * Layout information for child views of Toolbars.
 *
 * <p>Toolbar.LayoutParams extends ActionBar.LayoutParams for compatibility with existing
 * ActionBar API. See {@link android.app.Activity#setActionBar(Toolbar) Activity.setActionBar}
 * for more info on how to use a Toolbar as your Activity's ActionBar.</p>
 *
 * @attr ref android.R.styleable#Toolbar_LayoutParams_layout_gravity
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class LayoutParams extends android.app.ActionBar.LayoutParams {

/**
 * @param c This value must never be {@code null}.
 * @apiSince 21
 */

public LayoutParams(@androidx.annotation.NonNull android.content.Context c, android.util.AttributeSet attrs) { super(0); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public LayoutParams(int width, int height) { super(0); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public LayoutParams(int width, int height, int gravity) { super(0); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public LayoutParams(int gravity) { super(0); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public LayoutParams(android.widget.Toolbar.LayoutParams source) { super(0); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public LayoutParams(android.app.ActionBar.LayoutParams source) { super(0); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public LayoutParams(android.view.ViewGroup.MarginLayoutParams source) { super(0); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public LayoutParams(android.view.ViewGroup.LayoutParams source) { super(0); throw new RuntimeException("Stub!"); }
}

/**
 * Interface responsible for receiving menu item click events if the items themselves
 * do not have individual item click listeners.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnMenuItemClickListener {

/**
 * This method will be invoked when a menu item is clicked if the item itself did
 * not already handle the event.
 *
 * @param item {@link android.view.MenuItem MenuItem} that was clicked
 * @return <code>true</code> if the event was handled, <code>false</code> otherwise.
 * @apiSince 21
 */

public boolean onMenuItemClick(android.view.MenuItem item);
}

}

