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

import android.widget.ProgressBar;
import android.graphics.drawable.Drawable;
import java.text.NumberFormat;

/**
 * A dialog showing a progress indicator and an optional text message or view.
 * Only a text message or a view can be used at the same time.
 *
 * <p>The dialog can be made cancelable on back key press.</p>
 *
 * <p>The progress range is 0 to {@link #getMax() max}.</p>
 *
 * @deprecated <code>ProgressDialog</code> is a modal dialog, which prevents the
 * user from interacting with the app. Instead of using this class, you should
 * use a progress indicator like {@link android.widget.ProgressBar}, which can
 * be embedded in your app's UI. Alternatively, you can use a
 * <a href="/guide/topics/ui/notifiers/notifications.html">notification</a>
 * to inform the user of the task's progress.
 * @apiSince 1
 * @deprecatedSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class ProgressDialog extends android.app.AlertDialog {

/**
 * Creates a Progress dialog.
 *
 * @param context the parent context
 * @apiSince 1
 */

@Deprecated
public ProgressDialog(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a Progress dialog.
 *
 * @param context the parent context
 * @param theme the resource ID of the theme against which to inflate
 *              this dialog, or {@code 0} to use the parent
 *              {@code context}'s default alert dialog theme
 * @apiSince 1
 */

@Deprecated
public ProgressDialog(android.content.Context context, int theme) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates and shows a ProgressDialog.
 *
 * @param context the parent context
 * @param title the title text for the dialog's window
 * @param message the text to be displayed in the dialog
 * @return the ProgressDialog
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public static android.app.ProgressDialog show(android.content.Context context, java.lang.CharSequence title, java.lang.CharSequence message) { throw new RuntimeException("Stub!"); }

/**
 * Creates and shows a ProgressDialog.
 *
 * @param context the parent context
 * @param title the title text for the dialog's window
 * @param message the text to be displayed in the dialog
 * @param indeterminate true if the dialog should be {@link #setIndeterminate(boolean)
 *        indeterminate}, false otherwise
 * @return the ProgressDialog
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public static android.app.ProgressDialog show(android.content.Context context, java.lang.CharSequence title, java.lang.CharSequence message, boolean indeterminate) { throw new RuntimeException("Stub!"); }

/**
 * Creates and shows a ProgressDialog.
 *
 * @param context the parent context
 * @param title the title text for the dialog's window
 * @param message the text to be displayed in the dialog
 * @param indeterminate true if the dialog should be {@link #setIndeterminate(boolean)
 *        indeterminate}, false otherwise
 * @param cancelable true if the dialog is {@link #setCancelable(boolean) cancelable},
 *        false otherwise
 * @return the ProgressDialog
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public static android.app.ProgressDialog show(android.content.Context context, java.lang.CharSequence title, java.lang.CharSequence message, boolean indeterminate, boolean cancelable) { throw new RuntimeException("Stub!"); }

/**
 * Creates and shows a ProgressDialog.
 *
 * @param context the parent context
 * @param title the title text for the dialog's window
 * @param message the text to be displayed in the dialog
 * @param indeterminate true if the dialog should be {@link #setIndeterminate(boolean)
 *        indeterminate}, false otherwise
 * @param cancelable true if the dialog is {@link #setCancelable(boolean) cancelable},
 *        false otherwise
 * @param cancelListener the {@link #setOnCancelListener(android.content.DialogInterface.OnCancelListener) listener}
 *        to be invoked when the dialog is canceled
 * @return the ProgressDialog
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public static android.app.ProgressDialog show(android.content.Context context, java.lang.CharSequence title, java.lang.CharSequence message, boolean indeterminate, boolean cancelable, android.content.DialogInterface.OnCancelListener cancelListener) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
protected void onCreate(android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public void onStart() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
protected void onStop() { throw new RuntimeException("Stub!"); }

/**
 * Sets the current progress.
 *
 * @param value the current progress, a value between 0 and {@link #getMax()}
 *
 * @see android.widget.ProgressBar#setProgress(int)
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public void setProgress(int value) { throw new RuntimeException("Stub!"); }

/**
 * Sets the secondary progress.
 *
 * @param secondaryProgress the current secondary progress, a value between 0 and
 * {@link #getMax()}
 *
 * @see android.widget.ProgressBar#setSecondaryProgress(int)
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public void setSecondaryProgress(int secondaryProgress) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current progress.
 *
 * @return the current progress, a value between 0 and {@link #getMax()}
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public int getProgress() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current secondary progress.
 *
 * @return the current secondary progress, a value between 0 and {@link #getMax()}
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public int getSecondaryProgress() { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum allowed progress value. The default value is 100.
 *
 * @return the maximum value
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public int getMax() { throw new RuntimeException("Stub!"); }

/**
 * Sets the maximum allowed progress value.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public void setMax(int max) { throw new RuntimeException("Stub!"); }

/**
 * Increments the current progress value.
 *
 * @param diff the amount by which the current progress will be incremented,
 * up to {@link #getMax()}
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public void incrementProgressBy(int diff) { throw new RuntimeException("Stub!"); }

/**
 * Increments the current secondary progress value.
 *
 * @param diff the amount by which the current secondary progress will be incremented,
 * up to {@link #getMax()}
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public void incrementSecondaryProgressBy(int diff) { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable to be used to display the progress value.
 *
 * @param d the drawable to be used
 *
 * @see android.widget.ProgressBar#setProgressDrawable(Drawable)
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public void setProgressDrawable(android.graphics.drawable.Drawable d) { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable to be used to display the indeterminate progress value.
 *
 * @param d the drawable to be used
 *
 * @see android.widget.ProgressBar#setProgressDrawable(Drawable)
 * @see #setIndeterminate(boolean)
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public void setIndeterminateDrawable(android.graphics.drawable.Drawable d) { throw new RuntimeException("Stub!"); }

/**
 * Change the indeterminate mode for this ProgressDialog. In indeterminate
 * mode, the progress is ignored and the dialog shows an infinite
 * animation instead.
 *
 * <p><strong>Note:</strong> A ProgressDialog with style {@link #STYLE_SPINNER}
 * is always indeterminate and will ignore this setting.</p>
 *
 * @param indeterminate true to enable indeterminate mode, false otherwise
 *
 * @see #setProgressStyle(int)
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public void setIndeterminate(boolean indeterminate) { throw new RuntimeException("Stub!"); }

/**
 * Whether this ProgressDialog is in indeterminate mode.
 *
 * @return true if the dialog is in indeterminate mode, false otherwise
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public boolean isIndeterminate() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public void setMessage(java.lang.CharSequence message) { throw new RuntimeException("Stub!"); }

/**
 * Sets the style of this ProgressDialog, either {@link #STYLE_SPINNER} or
 * {@link #STYLE_HORIZONTAL}. The default is {@link #STYLE_SPINNER}.
 *
 * <p><strong>Note:</strong> A ProgressDialog with style {@link #STYLE_SPINNER}
 * is always indeterminate and will ignore the {@link #setIndeterminate(boolean)
 * indeterminate} setting.</p>
 *
 * @param style the style of this ProgressDialog, either {@link #STYLE_SPINNER} or
 * {@link #STYLE_HORIZONTAL}
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public void setProgressStyle(int style) { throw new RuntimeException("Stub!"); }

/**
 * Change the format of the small text showing current and maximum units
 * of progress.  The default is "%1d/%2d".
 * Should not be called during the number is progressing.
 * @param format A string passed to {@link java.lang.String#format String#format};
 * use "%1d" for the current number and "%2d" for the maximum.  If null,
 * nothing will be shown.
 * @apiSince 11
 * @deprecatedSince 26
 */

@Deprecated
public void setProgressNumberFormat(java.lang.String format) { throw new RuntimeException("Stub!"); }

/**
 * Change the format of the small text showing the percentage of progress.
 * The default is
 * {@link java.text.NumberFormat#getPercentInstance() NumberFormat#getPercentInstance()}
 * Should not be called during the number is progressing.
 * @param format An instance of a {@link java.text.NumberFormat NumberFormat} to generate the
 * percentage text.  If null, nothing will be shown.
 * @apiSince 11
 * @deprecatedSince 26
 */

@Deprecated
public void setProgressPercentFormat(java.text.NumberFormat format) { throw new RuntimeException("Stub!"); }

/**
 * Creates a ProgressDialog with a horizontal progress bar.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public static final int STYLE_HORIZONTAL = 1; // 0x1

/**
 * Creates a ProgressDialog with a circular, spinning progress
 * bar. This is the default.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public static final int STYLE_SPINNER = 0; // 0x0
}

