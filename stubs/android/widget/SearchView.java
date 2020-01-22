/*
 * Copyright (C) 2010 The Android Open Source Project
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

import android.app.SearchableInfo;
import android.app.SearchManager;
import android.view.KeyEvent;

/**
 * A widget that provides a user interface for the user to enter a search query and submit a request
 * to a search provider. Shows a list of query suggestions or results, if available, and allows the
 * user to pick a suggestion or result to launch into.
 *
 * <p>
 * When the SearchView is used in an ActionBar as an action view for a collapsible menu item, it
 * needs to be set to iconified by default using {@link #setIconifiedByDefault(boolean)
 * setIconifiedByDefault(true)}. This is the default, so nothing needs to be done.
 * </p>
 * <p>
 * If you want the search field to always be visible, then call setIconifiedByDefault(false).
 * </p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about using {@code SearchView}, read the
 * <a href="{@docRoot}guide/topics/search/index.html">Search</a> developer guide.</p>
 * </div>
 *
 * @see android.view.MenuItem#SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW
 * @attr ref android.R.styleable#SearchView_iconifiedByDefault
 * @attr ref android.R.styleable#SearchView_imeOptions
 * @attr ref android.R.styleable#SearchView_inputType
 * @attr ref android.R.styleable#SearchView_maxWidth
 * @attr ref android.R.styleable#SearchView_queryHint
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SearchView extends android.widget.LinearLayout implements android.view.CollapsibleActionView {

/** @apiSince 11 */

public SearchView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public SearchView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public SearchView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public SearchView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Sets the SearchableInfo for this SearchView. Properties in the SearchableInfo are used
 * to display labels, hints, suggestions, create intents for launching search results screens
 * and controlling other affordances such as a voice button.
 *
 * @param searchable a SearchableInfo can be retrieved from the SearchManager, for a specific
 * activity or a global search provider.
 * @apiSince 11
 */

public void setSearchableInfo(android.app.SearchableInfo searchable) { throw new RuntimeException("Stub!"); }

/**
 * Sets the IME options on the query text field.
 *
 * @see android.widget.TextView#setImeOptions(int)
 * @param imeOptions the options to set on the query text field
 *
 * @attr ref android.R.styleable#SearchView_imeOptions
 * @apiSince 14
 */

public void setImeOptions(int imeOptions) { throw new RuntimeException("Stub!"); }

/**
 * Returns the IME options set on the query text field.
 * @return the ime options
 * @see android.widget.TextView#setImeOptions(int)
 *
 * @attr ref android.R.styleable#SearchView_imeOptions
 * @apiSince 16
 */

public int getImeOptions() { throw new RuntimeException("Stub!"); }

/**
 * Sets the input type on the query text field.
 *
 * @see android.widget.TextView#setInputType(int)
 * @param inputType the input type to set on the query text field
 *
 * @attr ref android.R.styleable#SearchView_inputType
 * @apiSince 14
 */

public void setInputType(int inputType) { throw new RuntimeException("Stub!"); }

/**
 * Returns the input type set on the query text field.
 * @return the input type
 *
 * @attr ref android.R.styleable#SearchView_inputType
 * @apiSince 16
 */

public int getInputType() { throw new RuntimeException("Stub!"); }

/** @hide */

public boolean requestFocus(int direction, android.graphics.Rect previouslyFocusedRect) { throw new RuntimeException("Stub!"); }

/** @hide */

public void clearFocus() { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener for user actions within the SearchView.
 *
 * @param listener the listener object that receives callbacks when the user performs
 * actions in the SearchView such as clicking on buttons or typing a query.
 * @apiSince 11
 */

public void setOnQueryTextListener(android.widget.SearchView.OnQueryTextListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener to inform when the user closes the SearchView.
 *
 * @param listener the listener to call when the user closes the SearchView.
 * @apiSince 11
 */

public void setOnCloseListener(android.widget.SearchView.OnCloseListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener to inform when the focus of the query text field changes.
 *
 * @param listener the listener to inform of focus changes.
 * @apiSince 11
 */

public void setOnQueryTextFocusChangeListener(android.view.View.OnFocusChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener to inform when a suggestion is focused or clicked.
 *
 * @param listener the listener to inform of suggestion selection events.
 * @apiSince 11
 */

public void setOnSuggestionListener(android.widget.SearchView.OnSuggestionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener to inform when the search button is pressed. This is only
 * relevant when the text field is not visible by default. Calling {@link #setIconified
 * setIconified(false)} can also cause this listener to be informed.
 *
 * @param listener the listener to inform when the search button is clicked or
 * the text field is programmatically de-iconified.
 * @apiSince 11
 */

public void setOnSearchClickListener(android.view.View.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Returns the query string currently in the text field.
 *
 * @return the query string
 * @apiSince 11
 */

public java.lang.CharSequence getQuery() { throw new RuntimeException("Stub!"); }

/**
 * Sets a query string in the text field and optionally submits the query as well.
 *
 * @param query the query string. This replaces any query text already present in the
 * text field.
 * @param submit whether to submit the query right now or only update the contents of
 * text field.
 * @apiSince 11
 */

public void setQuery(java.lang.CharSequence query, boolean submit) { throw new RuntimeException("Stub!"); }

/**
 * Sets the hint text to display in the query text field. This overrides
 * any hint specified in the {@link android.app.SearchableInfo SearchableInfo}.
 * <p>
 * This value may be specified as an empty string to prevent any query hint
 * from being displayed.
 *
 * @param hint the hint text to display or {@code null} to clear
 * This value may be {@code null}.
 * @attr ref android.R.styleable#SearchView_queryHint
 * @apiSince 11
 */

public void setQueryHint(@androidx.annotation.Nullable java.lang.CharSequence hint) { throw new RuntimeException("Stub!"); }

/**
 * Returns the hint text that will be displayed in the query text field.
 * <p>
 * The displayed query hint is chosen in the following order:
 * <ol>
 * <li>Non-null value set with {@link #setQueryHint(java.lang.CharSequence)}
 * <li>Value specified in XML using
 *     {@link android.R.styleable#SearchView_queryHint android:queryHint}
 * <li>Valid string resource ID exposed by the {@link android.app.SearchableInfo SearchableInfo} via
 *     {@link android.app.SearchableInfo#getHintId() SearchableInfo#getHintId()}
 * <li>Default hint provided by the theme against which the view was
 *     inflated
 * </ol>
 *
 * @return the displayed query hint text, or {@code null} if none set
 * @attr ref android.R.styleable#SearchView_queryHint
 * @apiSince 16
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getQueryHint() { throw new RuntimeException("Stub!"); }

/**
 * Sets the default or resting state of the search field. If true, a single search icon is
 * shown by default and expands to show the text field and other buttons when pressed. Also,
 * if the default state is iconified, then it collapses to that state when the close button
 * is pressed. Changes to this property will take effect immediately.
 *
 * <p>The default value is true.</p>
 *
 * @param iconified whether the search field should be iconified by default
 *
 * @attr ref android.R.styleable#SearchView_iconifiedByDefault
 * @apiSince 11
 */

public void setIconifiedByDefault(boolean iconified) { throw new RuntimeException("Stub!"); }

/**
 * Returns the default iconified state of the search field.
 * @return
 *
 * @deprecated use {@link #isIconifiedByDefault()}
 * @attr ref android.R.styleable#SearchView_iconifiedByDefault
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public boolean isIconfiedByDefault() { throw new RuntimeException("Stub!"); }

/**
 * Returns the default iconified state of the search field.
 *
 * @attr ref android.R.styleable#SearchView_iconifiedByDefault
 * @apiSince 29
 */

public boolean isIconifiedByDefault() { throw new RuntimeException("Stub!"); }

/**
 * Iconifies or expands the SearchView. Any query text is cleared when iconified. This is
 * a temporary state and does not override the default iconified state set by
 * {@link #setIconifiedByDefault(boolean)}. If the default state is iconified, then
 * a false here will only be valid until the user closes the field. And if the default
 * state is expanded, then a true here will only clear the text field and not close it.
 *
 * @param iconify a true value will collapse the SearchView to an icon, while a false will
 * expand it.
 * @apiSince 11
 */

public void setIconified(boolean iconify) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current iconified state of the SearchView.
 *
 * @return true if the SearchView is currently iconified, false if the search field is
 * fully visible.
 * @apiSince 11
 */

public boolean isIconified() { throw new RuntimeException("Stub!"); }

/**
 * Enables showing a submit button when the query is non-empty. In cases where the SearchView
 * is being used to filter the contents of the current activity and doesn't launch a separate
 * results activity, then the submit button should be disabled.
 *
 * @param enabled true to show a submit button for submitting queries, false if a submit
 * button is not required.
 * @apiSince 11
 */

public void setSubmitButtonEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the submit button is enabled when necessary or never displayed.
 *
 * @return whether the submit button is enabled automatically when necessary
 * @apiSince 11
 */

public boolean isSubmitButtonEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Specifies if a query refinement button should be displayed alongside each suggestion
 * or if it should depend on the flags set in the individual items retrieved from the
 * suggestions provider. Clicking on the query refinement button will replace the text
 * in the query text field with the text from the suggestion. This flag only takes effect
 * if a SearchableInfo has been specified with {@link #setSearchableInfo(android.app.SearchableInfo)}
 * and not when using a custom adapter.
 *
 * @param enable true if all items should have a query refinement button, false if only
 * those items that have a query refinement flag set should have the button.
 *
 * @see android.app.SearchManager#SUGGEST_COLUMN_FLAGS
 * @see android.app.SearchManager#FLAG_QUERY_REFINEMENT
 * @apiSince 11
 */

public void setQueryRefinementEnabled(boolean enable) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether query refinement is enabled for all items or only specific ones.
 * @return true if enabled for all items, false otherwise.
 * @apiSince 11
 */

public boolean isQueryRefinementEnabled() { throw new RuntimeException("Stub!"); }

/**
 * You can set a custom adapter if you wish. Otherwise the default adapter is used to
 * display the suggestions from the suggestions provider associated with the SearchableInfo.
 *
 * @see #setSearchableInfo(SearchableInfo)
 * @apiSince 11
 */

public void setSuggestionsAdapter(android.widget.CursorAdapter adapter) { throw new RuntimeException("Stub!"); }

/**
 * Returns the adapter used for suggestions, if any.
 * @return the suggestions adapter
 * @apiSince 11
 */

public android.widget.CursorAdapter getSuggestionsAdapter() { throw new RuntimeException("Stub!"); }

/**
 * Makes the view at most this many pixels wide
 *
 * @attr ref android.R.styleable#SearchView_maxWidth
 * @apiSince 11
 */

public void setMaxWidth(int maxpixels) { throw new RuntimeException("Stub!"); }

/**
 * Gets the specified maximum width in pixels, if set. Returns zero if
 * no maximum width was specified.
 * @return the maximum width of the view
 *
 * @attr ref android.R.styleable#SearchView_maxWidth
 * @apiSince 16
 */

public int getMaxWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected void onLayout(boolean changed, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/**
 * Handles the key down event for dealing with action keys.
 *
 * @param keyCode This is the keycode of the typed key, and is the same value as
 *        found in the KeyEvent parameter.
 * @param event The complete event record for the typed key
 *
 * @return true if the event was handled here, or false if not.
 * @apiSince 11
 */

public boolean onKeyDown(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void onWindowFocusChanged(boolean hasWindowFocus) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 14
 */

public void onActionViewCollapsed() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 14
 */

public void onActionViewExpanded() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
/** @apiSince 11 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnCloseListener {

/**
 * The user is attempting to close the SearchView.
 *
 * @return true if the listener wants to override the default behavior of clearing the
 * text field and dismissing it, false otherwise.
 * @apiSince 11
 */

public boolean onClose();
}

/**
 * Callbacks for changes to the query text.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnQueryTextListener {

/**
 * Called when the user submits the query. This could be due to a key press on the
 * keyboard or due to pressing a submit button.
 * The listener can override the standard behavior by returning true
 * to indicate that it has handled the submit request. Otherwise return false to
 * let the SearchView handle the submission by launching any associated intent.
 *
 * @param query the query text that is to be submitted
 *
 * @return true if the query has been handled by the listener, false to let the
 * SearchView perform the default action.
 * @apiSince 11
 */

public boolean onQueryTextSubmit(java.lang.String query);

/**
 * Called when the query text is changed by the user.
 *
 * @param newText the new content of the query text field.
 *
 * @return false if the SearchView should perform the default action of showing any
 * suggestions if available, true if the action was handled by the listener.
 * @apiSince 11
 */

public boolean onQueryTextChange(java.lang.String newText);
}

/**
 * Callback interface for selection events on suggestions. These callbacks
 * are only relevant when a SearchableInfo has been specified by {@link #setSearchableInfo}.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnSuggestionListener {

/**
 * Called when a suggestion was selected by navigating to it.
 * @param position the absolute position in the list of suggestions.
 *
 * @return true if the listener handles the event and wants to override the default
 * behavior of possibly rewriting the query based on the selected item, false otherwise.
 * @apiSince 11
 */

public boolean onSuggestionSelect(int position);

/**
 * Called when a suggestion was clicked.
 * @param position the absolute position of the clicked item in the list of suggestions.
 *
 * @return true if the listener handles the event and wants to override the default
 * behavior of launching any intent or submitting a search query specified on that item.
 * Return false otherwise.
 * @apiSince 11
 */

public boolean onSuggestionClick(int position);
}

}

