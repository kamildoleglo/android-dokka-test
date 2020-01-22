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


package android.preference;

import android.view.View;
import android.graphics.drawable.Drawable;
import android.app.AlertDialog;
import android.content.SharedPreferences;

/**
 * A base class for {@link android.preference.Preference Preference} objects that are
 * dialog-based. These preferences will, when clicked, open a dialog showing the
 * actual preference controls.
 *
 * @attr ref android.R.styleable#DialogPreference_dialogTitle
 * @attr ref android.R.styleable#DialogPreference_dialogMessage
 * @attr ref android.R.styleable#DialogPreference_dialogIcon
 * @attr ref android.R.styleable#DialogPreference_dialogLayout
 * @attr ref android.R.styleable#DialogPreference_positiveButtonText
 * @attr ref android.R.styleable#DialogPreference_negativeButtonText
 *
 * @deprecated Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 *      <a href="{@docRoot}reference/androidx/preference/package-summary.html">
 *      Preference Library</a> for consistent behavior across all devices. For more information on
 *      using the AndroidX Preference Library see
 *      <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class DialogPreference extends android.preference.Preference implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnDismissListener, android.preference.PreferenceManager.OnActivityDestroyListener {

/** @apiSince 21 */

@Deprecated
public DialogPreference(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public DialogPreference(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public DialogPreference(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@Deprecated
public DialogPreference(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Sets the title of the dialog. This will be shown on subsequent dialogs.
 *
 * @param dialogTitle The title.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setDialogTitle(java.lang.CharSequence dialogTitle) { throw new RuntimeException("Stub!"); }

/**
 * @see #setDialogTitle(CharSequence)
 * @param dialogTitleResId The dialog title as a resource.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setDialogTitle(int dialogTitleResId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the title to be shown on subsequent dialogs.
 * @return The title.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.CharSequence getDialogTitle() { throw new RuntimeException("Stub!"); }

/**
 * Sets the message of the dialog. This will be shown on subsequent dialogs.
 * <p>
 * This message forms the content View of the dialog and conflicts with
 * list-based dialogs, for example. If setting a custom View on a dialog via
 * {@link #setDialogLayoutResource(int)}, include a text View with ID
 * {@link android.R.id#message} and it will be populated with this message.
 *
 * @param dialogMessage The message.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setDialogMessage(java.lang.CharSequence dialogMessage) { throw new RuntimeException("Stub!"); }

/**
 * @see #setDialogMessage(CharSequence)
 * @param dialogMessageResId The dialog message as a resource.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setDialogMessage(int dialogMessageResId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the message to be shown on subsequent dialogs.
 * @return The message.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.CharSequence getDialogMessage() { throw new RuntimeException("Stub!"); }

/**
 * Sets the icon of the dialog. This will be shown on subsequent dialogs.
 *
 * @param dialogIcon The icon, as a {@link android.graphics.drawable.Drawable Drawable}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setDialogIcon(android.graphics.drawable.Drawable dialogIcon) { throw new RuntimeException("Stub!"); }

/**
 * Sets the icon (resource ID) of the dialog. This will be shown on
 * subsequent dialogs.
 *
 * @param dialogIconRes The icon, as a resource ID.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setDialogIcon(int dialogIconRes) { throw new RuntimeException("Stub!"); }

/**
 * Returns the icon to be shown on subsequent dialogs.
 * @return The icon, as a {@link android.graphics.drawable.Drawable Drawable}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.graphics.drawable.Drawable getDialogIcon() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text of the positive button of the dialog. This will be shown on
 * subsequent dialogs.
 *
 * @param positiveButtonText The text of the positive button.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setPositiveButtonText(java.lang.CharSequence positiveButtonText) { throw new RuntimeException("Stub!"); }

/**
 * @see #setPositiveButtonText(CharSequence)
 * @param positiveButtonTextResId The positive button text as a resource.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setPositiveButtonText(int positiveButtonTextResId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the text of the positive button to be shown on subsequent
 * dialogs.
 *
 * @return The text of the positive button.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.CharSequence getPositiveButtonText() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text of the negative button of the dialog. This will be shown on
 * subsequent dialogs.
 *
 * @param negativeButtonText The text of the negative button.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setNegativeButtonText(java.lang.CharSequence negativeButtonText) { throw new RuntimeException("Stub!"); }

/**
 * @see #setNegativeButtonText(CharSequence)
 * @param negativeButtonTextResId The negative button text as a resource.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setNegativeButtonText(int negativeButtonTextResId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the text of the negative button to be shown on subsequent
 * dialogs.
 *
 * @return The text of the negative button.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.CharSequence getNegativeButtonText() { throw new RuntimeException("Stub!"); }

/**
 * Sets the layout resource that is inflated as the {@link android.view.View View} to be shown
 * as the content View of subsequent dialogs.
 *
 * @param dialogLayoutResId The layout resource ID to be inflated.
 * @see #setDialogMessage(CharSequence)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setDialogLayoutResource(int dialogLayoutResId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the layout resource that is used as the content View for
 * subsequent dialogs.
 *
 * @return The layout resource.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public int getDialogLayoutResource() { throw new RuntimeException("Stub!"); }

/**
 * Prepares the dialog builder to be shown when the preference is clicked.
 * Use this to set custom properties on the dialog.
 * <p>
 * Do not {@link android.app.AlertDialog.Builder#create() AlertDialog.Builder#create()} or
 * {@link android.app.AlertDialog.Builder#show() AlertDialog.Builder#show()}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onClick() { throw new RuntimeException("Stub!"); }

/**
 * Shows the dialog associated with this Preference. This is normally initiated
 * automatically on clicking on the preference. Call this method if you need to
 * show the dialog on some other event.
 *
 * @param state Optional instance state to restore on the dialog
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void showDialog(android.os.Bundle state) { throw new RuntimeException("Stub!"); }

/**
 * Creates the content view for the dialog (if a custom content view is
 * required). By default, it inflates the dialog layout resource if it is
 * set.
 *
 * @return The content View for the dialog.
 * @see #setLayoutResource(int)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected android.view.View onCreateDialogView() { throw new RuntimeException("Stub!"); }

/**
 * Binds views in the content View of the dialog to data.
 * <p>
 * Make sure to call through to the superclass implementation.
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @param view The content View of the dialog, if it is custom.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onBindDialogView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void onClick(android.content.DialogInterface dialog, int which) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void onDismiss(android.content.DialogInterface dialog) { throw new RuntimeException("Stub!"); }

/**
 * Called when the dialog is dismissed and should be used to save data to
 * the {@link android.content.SharedPreferences SharedPreferences}.
 *
 * @param positiveResult Whether the positive button was clicked (true), or
 *            the negative button was clicked or the dialog was canceled (false).
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onDialogClosed(boolean positiveResult) { throw new RuntimeException("Stub!"); }

/**
 * Gets the dialog that is shown by this preference.
 *
 * @return The dialog, or null if a dialog is not being shown.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public android.app.Dialog getDialog() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void onActivityDestroy() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }
}

