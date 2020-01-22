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


package android.app;

import android.view.View;
import android.content.DialogInterface;
import android.widget.ListView;
import android.os.Message;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ListAdapter;
import android.database.Cursor;
import android.widget.AdapterView;

/**
 * A subclass of Dialog that can display one, two or three buttons. If you only want to
 * display a String in this dialog box, use the setMessage() method.  If you
 * want to display a more complex view, look up the FrameLayout called "custom"
 * and add your view to it:
 *
 * <pre>
 * FrameLayout fl = findViewById(android.R.id.custom);
 * fl.addView(myView, new LayoutParams(MATCH_PARENT, WRAP_CONTENT));
 * </pre>
 *
 * <p>The AlertDialog class takes care of automatically setting
 * {@link android.view.WindowManager.LayoutParams#FLAG_ALT_FOCUSABLE_IM
 * WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM} for you based on whether
 * any views in the dialog return true from {@link android.view.View#onCheckIsTextEditor() View#onCheckIsTextEditor()}.  Generally you want this set for a Dialog
 * without text editors, so that it will be placed on top of the current
 * input method UI.  You can modify this behavior by forcing the flag to your
 * desired mode after calling {@link #onCreate}.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about creating dialogs, read the
 * <a href="{@docRoot}guide/topics/ui/dialogs.html">Dialogs</a> developer guide.</p>
 * </div>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AlertDialog extends android.app.Dialog implements android.content.DialogInterface {

/**
 * Creates an alert dialog that uses the default alert dialog theme.
 * <p>
 * The default alert dialog theme is defined by
 * {@link android.R.attr#alertDialogTheme} within the parent
 * {@code context}'s theme.
 *
 * @param context the parent context
 * @see android.R.styleable#Theme_alertDialogTheme
 * @apiSince 1
 */

protected AlertDialog(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates an alert dialog that uses the default alert dialog theme and a
 * custom cancel listener.
 * <p>
 * This is functionally identical to:
 * <pre>
 *     AlertDialog dialog = new AlertDialog(context);
 *     alertDialog.setCancelable(cancelable);
 *     alertDialog.setOnCancelListener(cancelListener);
 * </pre>
 * <p>
 * The default alert dialog theme is defined by
 * {@link android.R.attr#alertDialogTheme} within the parent
 * {@code context}'s theme.
 *
 * @param context the parent context
 * @see android.R.styleable#Theme_alertDialogTheme
 * @apiSince 1
 */

protected AlertDialog(android.content.Context context, boolean cancelable, android.content.DialogInterface.OnCancelListener cancelListener) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates an alert dialog that uses an explicit theme resource.
 * <p>
 * The specified theme resource ({@code themeResId}) is applied on top of
 * the parent {@code context}'s theme. It may be specified as a style
 * resource containing a fully-populated theme, such as
 * {@link android.R.style#Theme_Material_Dialog}, to replace all attributes
 * in the parent {@code context}'s theme including primary and accent
 * colors.
 * <p>
 * To preserve attributes such as primary and accent colors, the
 * {@code themeResId} may instead be specified as an overlay theme such as
 * {@link android.R.style#ThemeOverlay_Material_Dialog}. This will override
 * only the window attributes necessary to style the alert window as a
 * dialog.
 * <p>
 * Alternatively, the {@code themeResId} may be specified as {@code 0} to
 * use the parent {@code context}'s resolved value for
 * {@link android.R.attr#alertDialogTheme}.
 *
 * @param context the parent context
 * @param themeResId the resource ID of the theme against which to inflate
 *                   this dialog, or {@code 0} to use the parent
 *                   {@code context}'s default alert dialog theme
 * @see android.R.styleable#Theme_alertDialogTheme
 * @apiSince 1
 */

protected AlertDialog(android.content.Context context, int themeResId) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Gets one of the buttons used in the dialog. Returns null if the specified
 * button does not exist or the dialog has not yet been fully created (for
 * example, via {@link #show()} or {@link #create()}).
 *
 * @param whichButton The identifier of the button that should be returned.
 *            For example, this can be
 *            {@link android.content.DialogInterface#BUTTON_POSITIVE DialogInterface#BUTTON_POSITIVE}.
 * @return The button from the dialog, or null if a button does not exist.
 * @apiSince 3
 */

public android.widget.Button getButton(int whichButton) { throw new RuntimeException("Stub!"); }

/**
 * Gets the list view used in the dialog.
 *
 * @return The {@link android.widget.ListView ListView} from the dialog.
 * @apiSince 3
 */

public android.widget.ListView getListView() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setTitle(java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.AlertDialog.Builder#setCustomTitle(View)
 * @apiSince 1
 */

public void setCustomTitle(android.view.View customTitleView) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setMessage(java.lang.CharSequence message) { throw new RuntimeException("Stub!"); }

/**
 * Set the view to display in that dialog.
 * @apiSince 1
 */

public void setView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Set the view to display in that dialog, specifying the spacing to appear around that
 * view.
 *
 * @param view The view to show in the content area of the dialog
 * @param viewSpacingLeft Extra space to appear to the left of {@code view}
 * @param viewSpacingTop Extra space to appear above {@code view}
 * @param viewSpacingRight Extra space to appear to the right of {@code view}
 * @param viewSpacingBottom Extra space to appear below {@code view}
 * @apiSince 3
 */

public void setView(android.view.View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight, int viewSpacingBottom) { throw new RuntimeException("Stub!"); }

/**
 * Set a message to be sent when a button is pressed.
 *
 * @param whichButton Which button to set the message for, can be one of
 *            {@link android.content.DialogInterface#BUTTON_POSITIVE DialogInterface#BUTTON_POSITIVE},
 *            {@link android.content.DialogInterface#BUTTON_NEGATIVE DialogInterface#BUTTON_NEGATIVE}, or
 *            {@link android.content.DialogInterface#BUTTON_NEUTRAL DialogInterface#BUTTON_NEUTRAL}
 * @param text The text to display in positive button.
 * @param msg The {@link android.os.Message Message} to be sent when clicked.
 * @apiSince 3
 */

public void setButton(int whichButton, java.lang.CharSequence text, android.os.Message msg) { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to be invoked when the positive button of the dialog is pressed.
 *
 * @param whichButton Which button to set the listener on, can be one of
 *            {@link android.content.DialogInterface#BUTTON_POSITIVE DialogInterface#BUTTON_POSITIVE},
 *            {@link android.content.DialogInterface#BUTTON_NEGATIVE DialogInterface#BUTTON_NEGATIVE}, or
 *            {@link android.content.DialogInterface#BUTTON_NEUTRAL DialogInterface#BUTTON_NEUTRAL}
 * @param text The text to display in positive button.
 * @param listener The {@link android.content.DialogInterface.OnClickListener DialogInterface.OnClickListener} to use.
 * @apiSince 3
 */

public void setButton(int whichButton, java.lang.CharSequence text, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #setButton(int,java.lang.CharSequence,android.os.Message)} with
 *             {@link android.content.DialogInterface#BUTTON_POSITIVE DialogInterface#BUTTON_POSITIVE}.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void setButton(java.lang.CharSequence text, android.os.Message msg) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #setButton(int,java.lang.CharSequence,android.os.Message)} with
 *             {@link android.content.DialogInterface#BUTTON_NEGATIVE DialogInterface#BUTTON_NEGATIVE}.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void setButton2(java.lang.CharSequence text, android.os.Message msg) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #setButton(int,java.lang.CharSequence,android.os.Message)} with
 *             {@link android.content.DialogInterface#BUTTON_NEUTRAL DialogInterface#BUTTON_NEUTRAL}.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void setButton3(java.lang.CharSequence text, android.os.Message msg) { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to be invoked when button 1 of the dialog is pressed.
 *
 * @param text The text to display in button 1.
 * @param listener The {@link android.content.DialogInterface.OnClickListener DialogInterface.OnClickListener} to use.
 * @deprecated Use
 *             {@link #setButton(int,java.lang.CharSequence,android.content.DialogInterface.OnClickListener)}
 *             with {@link android.content.DialogInterface#BUTTON_POSITIVE DialogInterface#BUTTON_POSITIVE}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void setButton(java.lang.CharSequence text, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to be invoked when button 2 of the dialog is pressed.
 * @param text The text to display in button 2.
 * @param listener The {@link android.content.DialogInterface.OnClickListener DialogInterface.OnClickListener} to use.
 * @deprecated Use
 *             {@link #setButton(int,java.lang.CharSequence,android.content.DialogInterface.OnClickListener)}
 *             with {@link android.content.DialogInterface#BUTTON_NEGATIVE DialogInterface#BUTTON_NEGATIVE}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void setButton2(java.lang.CharSequence text, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to be invoked when button 3 of the dialog is pressed.
 * @param text The text to display in button 3.
 * @param listener The {@link android.content.DialogInterface.OnClickListener DialogInterface.OnClickListener} to use.
 * @deprecated Use
 *             {@link #setButton(int,java.lang.CharSequence,android.content.DialogInterface.OnClickListener)}
 *             with {@link android.content.DialogInterface#BUTTON_NEUTRAL DialogInterface#BUTTON_NEUTRAL}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void setButton3(java.lang.CharSequence text, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set resId to 0 if you don't want an icon.
 * @param resId the resourceId of the drawable to use as the icon or 0
 * if you don't want an icon.
 * @apiSince 1
 */

public void setIcon(int resId) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setIcon(android.graphics.drawable.Drawable icon) { throw new RuntimeException("Stub!"); }

/**
 * Set an icon as supplied by a theme attribute. e.g. android.R.attr.alertDialogIcon
 *
 * @param attrId ID of a theme attribute that points to a drawable resource.
 * @apiSince 11
 */

public void setIconAttribute(int attrId) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setInverseBackgroundForced(boolean forceInverseBackground) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onCreate(android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyDown(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyUp(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Special theme constant for {@link #AlertDialog(android.content.Context,int)}: use
 * the device's default alert theme with a dark background.
 *
 * @deprecated Use {@link android.R.style#Theme_DeviceDefault_Dialog_Alert}.
 * @apiSince 14
 * @deprecatedSince 23
 */

@Deprecated public static final int THEME_DEVICE_DEFAULT_DARK = 4; // 0x4

/**
 * Special theme constant for {@link #AlertDialog(android.content.Context,int)}: use
 * the device's default alert theme with a light background.
 *
 * @deprecated Use {@link android.R.style#Theme_DeviceDefault_Light_Dialog_Alert}.
 * @apiSince 14
 * @deprecatedSince 23
 */

@Deprecated public static final int THEME_DEVICE_DEFAULT_LIGHT = 5; // 0x5

/**
 * Special theme constant for {@link #AlertDialog(android.content.Context,int)}: use
 * the holographic alert theme with a dark background.
 *
 * @deprecated Use {@link android.R.style#Theme_Material_Dialog_Alert}.
 * @apiSince 11
 * @deprecatedSince 23
 */

@Deprecated public static final int THEME_HOLO_DARK = 2; // 0x2

/**
 * Special theme constant for {@link #AlertDialog(android.content.Context,int)}: use
 * the holographic alert theme with a light background.
 *
 * @deprecated Use {@link android.R.style#Theme_Material_Light_Dialog_Alert}.
 * @apiSince 11
 * @deprecatedSince 23
 */

@Deprecated public static final int THEME_HOLO_LIGHT = 3; // 0x3

/**
 * Special theme constant for {@link #AlertDialog(android.content.Context,int)}: use
 * the traditional (pre-Holo) alert dialog theme.
 *
 * @deprecated Use {@link android.R.style#Theme_Material_Dialog_Alert}.
 * @apiSince 11
 * @deprecatedSince 23
 */

@Deprecated public static final int THEME_TRADITIONAL = 1; // 0x1
/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Creates a builder for an alert dialog that uses the default alert
 * dialog theme.
 * <p>
 * The default alert dialog theme is defined by
 * {@link android.R.attr#alertDialogTheme} within the parent
 * {@code context}'s theme.
 *
 * @param context the parent context
 * @apiSince 1
 */

public Builder(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Creates a builder for an alert dialog that uses an explicit theme
 * resource.
 * <p>
 * The specified theme resource ({@code themeResId}) is applied on top
 * of the parent {@code context}'s theme. It may be specified as a
 * style resource containing a fully-populated theme, such as
 * {@link android.R.style#Theme_Material_Dialog}, to replace all
 * attributes in the parent {@code context}'s theme including primary
 * and accent colors.
 * <p>
 * To preserve attributes such as primary and accent colors, the
 * {@code themeResId} may instead be specified as an overlay theme such
 * as {@link android.R.style#ThemeOverlay_Material_Dialog}. This will
 * override only the window attributes necessary to style the alert
 * window as a dialog.
 * <p>
 * Alternatively, the {@code themeResId} may be specified as {@code 0}
 * to use the parent {@code context}'s resolved value for
 * {@link android.R.attr#alertDialogTheme}.
 *
 * @param context the parent context
 * @param themeResId the resource ID of the theme against which to inflate
 *                   this dialog, or {@code 0} to use the parent
 *                   {@code context}'s default alert dialog theme
 * @apiSince 11
 */

public Builder(android.content.Context context, int themeResId) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.content.Context Context} with the appropriate theme for dialogs created by this Builder.
 * Applications should use this Context for obtaining LayoutInflaters for inflating views
 * that will be used in the resulting dialogs, as it will cause views to be inflated with
 * the correct theme.
 *
 * @return A Context for built Dialogs.
 * @apiSince 11
 */

public android.content.Context getContext() { throw new RuntimeException("Stub!"); }

/**
 * Set the title using the given resource id.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setTitle(int titleId) { throw new RuntimeException("Stub!"); }

/**
 * Set the title displayed in the {@link android.app.Dialog Dialog}.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setTitle(java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Set the title using the custom view {@code customTitleView}.
 * <p>
 * The methods {@link #setTitle(int)} and {@link #setIcon(int)} should
 * be sufficient for most titles, but this is provided if the title
 * needs more customization. Using this will replace the title and icon
 * set via the other methods.
 * <p>
 * <strong>Note:</strong> To ensure consistent styling, the custom view
 * should be inflated or constructed using the alert dialog's themed
 * context obtained via {@link #getContext()}.
 *
 * @param customTitleView the custom view to use as the title
 * @return this Builder object to allow for chaining of calls to set
 *         methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setCustomTitle(android.view.View customTitleView) { throw new RuntimeException("Stub!"); }

/**
 * Set the message to display using the given resource id.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setMessage(int messageId) { throw new RuntimeException("Stub!"); }

/**
 * Set the message to display.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setMessage(java.lang.CharSequence message) { throw new RuntimeException("Stub!"); }

/**
 * Set the resource id of the {@link android.graphics.drawable.Drawable Drawable} to be used in the title.
 * <p>
 * Takes precedence over values set using {@link #setIcon(android.graphics.drawable.Drawable)}.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setIcon(int iconId) { throw new RuntimeException("Stub!"); }

/**
 * Set the {@link android.graphics.drawable.Drawable Drawable} to be used in the title.
 * <p>
 * <strong>Note:</strong> To ensure consistent styling, the drawable
 * should be inflated or constructed using the alert dialog's themed
 * context obtained via {@link #getContext()}.
 *
 * @return this Builder object to allow for chaining of calls to set
 *         methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setIcon(android.graphics.drawable.Drawable icon) { throw new RuntimeException("Stub!"); }

/**
 * Set an icon as supplied by a theme attribute. e.g.
 * {@link android.R.attr#alertDialogIcon}.
 * <p>
 * Takes precedence over values set using {@link #setIcon(int)} or
 * {@link #setIcon(android.graphics.drawable.Drawable)}.
 *
 * @param attrId ID of a theme attribute that points to a drawable resource.
 * @apiSince 11
 */

public android.app.AlertDialog.Builder setIconAttribute(int attrId) { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to be invoked when the positive button of the dialog is pressed.
 * @param textId The resource id of the text to display in the positive button
 * @param listener The {@link android.content.DialogInterface.OnClickListener DialogInterface.OnClickListener} to use.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setPositiveButton(int textId, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to be invoked when the positive button of the dialog is pressed.
 * @param text The text to display in the positive button
 * @param listener The {@link android.content.DialogInterface.OnClickListener DialogInterface.OnClickListener} to use.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setPositiveButton(java.lang.CharSequence text, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to be invoked when the negative button of the dialog is pressed.
 * @param textId The resource id of the text to display in the negative button
 * @param listener The {@link android.content.DialogInterface.OnClickListener DialogInterface.OnClickListener} to use.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setNegativeButton(int textId, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to be invoked when the negative button of the dialog is pressed.
 * @param text The text to display in the negative button
 * @param listener The {@link android.content.DialogInterface.OnClickListener DialogInterface.OnClickListener} to use.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setNegativeButton(java.lang.CharSequence text, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to be invoked when the neutral button of the dialog is pressed.
 * @param textId The resource id of the text to display in the neutral button
 * @param listener The {@link android.content.DialogInterface.OnClickListener DialogInterface.OnClickListener} to use.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setNeutralButton(int textId, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to be invoked when the neutral button of the dialog is pressed.
 * @param text The text to display in the neutral button
 * @param listener The {@link android.content.DialogInterface.OnClickListener DialogInterface.OnClickListener} to use.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setNeutralButton(java.lang.CharSequence text, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the dialog is cancelable or not.  Default is true.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setCancelable(boolean cancelable) { throw new RuntimeException("Stub!"); }

/**
 * Sets the callback that will be called if the dialog is canceled.
 *
 * <p>Even in a cancelable dialog, the dialog may be dismissed for reasons other than
 * being canceled or one of the supplied choices being selected.
 * If you are interested in listening for all cases where the dialog is dismissed
 * and not just when it is canceled, see
 * {@link #setOnDismissListener(android.content.DialogInterface.OnDismissListener) setOnDismissListener}.</p>
 * @see #setCancelable(boolean)
 * @see #setOnDismissListener(android.content.DialogInterface.OnDismissListener)
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setOnCancelListener(android.content.DialogInterface.OnCancelListener onCancelListener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the callback that will be called when the dialog is dismissed for any reason.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 17
 */

public android.app.AlertDialog.Builder setOnDismissListener(android.content.DialogInterface.OnDismissListener onDismissListener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the callback that will be called if a key is dispatched to the dialog.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setOnKeyListener(android.content.DialogInterface.OnKeyListener onKeyListener) { throw new RuntimeException("Stub!"); }

/**
 * Set a list of items to be displayed in the dialog as the content, you will be notified of the
 * selected item via the supplied listener. This should be an array type i.e. R.array.foo
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setItems(int itemsId, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a list of items to be displayed in the dialog as the content, you will be notified of the
 * selected item via the supplied listener.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setItems(java.lang.CharSequence[] items, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a list of items, which are supplied by the given {@link android.widget.ListAdapter ListAdapter}, to be
 * displayed in the dialog as the content, you will be notified of the
 * selected item via the supplied listener.
 *
 * @param adapter The {@link android.widget.ListAdapter ListAdapter} to supply the list of items
 * @param listener The listener that will be called when an item is clicked.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setAdapter(android.widget.ListAdapter adapter, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a list of items, which are supplied by the given {@link android.database.Cursor Cursor}, to be
 * displayed in the dialog as the content, you will be notified of the
 * selected item via the supplied listener.
 *
 * @param cursor The {@link android.database.Cursor Cursor} to supply the list of items
 * @param listener The listener that will be called when an item is clicked.
 * @param labelColumn The column name on the cursor containing the string to display
 *          in the label.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setCursor(android.database.Cursor cursor, android.content.DialogInterface.OnClickListener listener, java.lang.String labelColumn) { throw new RuntimeException("Stub!"); }

/**
 * Set a list of items to be displayed in the dialog as the content,
 * you will be notified of the selected item via the supplied listener.
 * This should be an array type, e.g. R.array.foo. The list will have
 * a check mark displayed to the right of the text for each checked
 * item. Clicking on an item in the list will not dismiss the dialog.
 * Clicking on a button will dismiss the dialog.
 *
 * @param itemsId the resource id of an array i.e. R.array.foo
 * @param checkedItems specifies which items are checked. It should be null in which case no
 *        items are checked. If non null it must be exactly the same length as the array of
 *        items.
 * @param listener notified when an item on the list is clicked. The dialog will not be
 *        dismissed when an item is clicked. It will only be dismissed if clicked on a
 *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setMultiChoiceItems(int itemsId, boolean[] checkedItems, android.content.DialogInterface.OnMultiChoiceClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a list of items to be displayed in the dialog as the content,
 * you will be notified of the selected item via the supplied listener.
 * The list will have a check mark displayed to the right of the text
 * for each checked item. Clicking on an item in the list will not
 * dismiss the dialog. Clicking on a button will dismiss the dialog.
 *
 * @param items the text of the items to be displayed in the list.
 * @param checkedItems specifies which items are checked. It should be null in which case no
 *        items are checked. If non null it must be exactly the same length as the array of
 *        items.
 * @param listener notified when an item on the list is clicked. The dialog will not be
 *        dismissed when an item is clicked. It will only be dismissed if clicked on a
 *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setMultiChoiceItems(java.lang.CharSequence[] items, boolean[] checkedItems, android.content.DialogInterface.OnMultiChoiceClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a list of items to be displayed in the dialog as the content,
 * you will be notified of the selected item via the supplied listener.
 * The list will have a check mark displayed to the right of the text
 * for each checked item. Clicking on an item in the list will not
 * dismiss the dialog. Clicking on a button will dismiss the dialog.
 *
 * @param cursor the cursor used to provide the items.
 * @param isCheckedColumn specifies the column name on the cursor to use to determine
 *        whether a checkbox is checked or not. It must return an integer value where 1
 *        means checked and 0 means unchecked.
 * @param labelColumn The column name on the cursor containing the string to display in the
 *        label.
 * @param listener notified when an item on the list is clicked. The dialog will not be
 *        dismissed when an item is clicked. It will only be dismissed if clicked on a
 *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setMultiChoiceItems(android.database.Cursor cursor, java.lang.String isCheckedColumn, java.lang.String labelColumn, android.content.DialogInterface.OnMultiChoiceClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a list of items to be displayed in the dialog as the content, you will be notified of
 * the selected item via the supplied listener. This should be an array type i.e.
 * R.array.foo The list will have a check mark displayed to the right of the text for the
 * checked item. Clicking on an item in the list will not dismiss the dialog. Clicking on a
 * button will dismiss the dialog.
 *
 * @param itemsId the resource id of an array i.e. R.array.foo
 * @param checkedItem specifies which item is checked. If -1 no items are checked.
 * @param listener notified when an item on the list is clicked. The dialog will not be
 *        dismissed when an item is clicked. It will only be dismissed if clicked on a
 *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setSingleChoiceItems(int itemsId, int checkedItem, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a list of items to be displayed in the dialog as the content, you will be notified of
 * the selected item via the supplied listener. The list will have a check mark displayed to
 * the right of the text for the checked item. Clicking on an item in the list will not
 * dismiss the dialog. Clicking on a button will dismiss the dialog.
 *
 * @param cursor the cursor to retrieve the items from.
 * @param checkedItem specifies which item is checked. If -1 no items are checked.
 * @param labelColumn The column name on the cursor containing the string to display in the
 *        label.
 * @param listener notified when an item on the list is clicked. The dialog will not be
 *        dismissed when an item is clicked. It will only be dismissed if clicked on a
 *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setSingleChoiceItems(android.database.Cursor cursor, int checkedItem, java.lang.String labelColumn, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a list of items to be displayed in the dialog as the content, you will be notified of
 * the selected item via the supplied listener. The list will have a check mark displayed to
 * the right of the text for the checked item. Clicking on an item in the list will not
 * dismiss the dialog. Clicking on a button will dismiss the dialog.
 *
 * @param items the items to be displayed.
 * @param checkedItem specifies which item is checked. If -1 no items are checked.
 * @param listener notified when an item on the list is clicked. The dialog will not be
 *        dismissed when an item is clicked. It will only be dismissed if clicked on a
 *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setSingleChoiceItems(java.lang.CharSequence[] items, int checkedItem, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a list of items to be displayed in the dialog as the content, you will be notified of
 * the selected item via the supplied listener. The list will have a check mark displayed to
 * the right of the text for the checked item. Clicking on an item in the list will not
 * dismiss the dialog. Clicking on a button will dismiss the dialog.
 *
 * @param adapter The {@link android.widget.ListAdapter ListAdapter} to supply the list of items
 * @param checkedItem specifies which item is checked. If -1 no items are checked.
 * @param listener notified when an item on the list is clicked. The dialog will not be
 *        dismissed when an item is clicked. It will only be dismissed if clicked on a
 *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
 *
 * @return This Builder object to allow for chaining of calls to set methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setSingleChoiceItems(android.widget.ListAdapter adapter, int checkedItem, android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener to be invoked when an item in the list is selected.
 *
 * @param listener the listener to be invoked
 * @return this Builder object to allow for chaining of calls to set methods
 * @see android.widget.AdapterView#setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener)
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a custom view resource to be the contents of the Dialog. The
 * resource will be inflated, adding all top-level views to the screen.
 *
 * @param layoutResId Resource ID to be inflated.
 * @return this Builder object to allow for chaining of calls to set
 *         methods
 * @apiSince 21
 */

public android.app.AlertDialog.Builder setView(int layoutResId) { throw new RuntimeException("Stub!"); }

/**
 * Sets a custom view to be the contents of the alert dialog.
 * <p>
 * When using a pre-Holo theme, if the supplied view is an instance of
 * a {@link android.widget.ListView ListView} then the light background will be used.
 * <p>
 * <strong>Note:</strong> To ensure consistent styling, the custom view
 * should be inflated or constructed using the alert dialog's themed
 * context obtained via {@link #getContext()}.
 *
 * @param view the view to use as the contents of the alert dialog
 * @return this Builder object to allow for chaining of calls to set
 *         methods
 * @apiSince 1
 */

public android.app.AlertDialog.Builder setView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Sets the alert dialog to use the inverse background, regardless of
 * what the contents is.
 *
 * @param useInverseBackground whether to use the inverse background
 * @return this Builder object to allow for chaining of calls to set methods
 * @deprecated This flag is only used for pre-Material themes. Instead,
 *             specify the window background using on the alert dialog
 *             theme.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public android.app.AlertDialog.Builder setInverseBackgroundForced(boolean useInverseBackground) { throw new RuntimeException("Stub!"); }

/**
 * Creates an {@link android.app.AlertDialog AlertDialog} with the arguments supplied to this
 * builder.
 * <p>
 * Calling this method does not display the dialog. If no additional
 * processing is needed, {@link #show()} may be called instead to both
 * create and display the dialog.
 * @apiSince 1
 */

public android.app.AlertDialog create() { throw new RuntimeException("Stub!"); }

/**
 * Creates an {@link android.app.AlertDialog AlertDialog} with the arguments supplied to this
 * builder and immediately displays the dialog.
 * <p>
 * Calling this method is functionally identical to:
 * <pre>
 *     AlertDialog dialog = builder.create();
 *     dialog.show();
 * </pre>
 * @apiSince 1
 */

public android.app.AlertDialog show() { throw new RuntimeException("Stub!"); }
}

}

