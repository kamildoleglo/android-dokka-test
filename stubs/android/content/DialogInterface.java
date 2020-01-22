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


package android.content;

import android.view.KeyEvent;

/**
 * Interface that defines a dialog-type class that can be shown, dismissed, or
 * canceled, and may have buttons that can be clicked.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface DialogInterface {

/**
 * Cancels the dialog, invoking the {@link android.content.DialogInterface.OnCancelListener OnCancelListener}.
 * <p>
 * The {@link android.content.DialogInterface.OnDismissListener OnDismissListener} may also be called if cancellation
 * dismisses the dialog.
 * @apiSince 1
 */

public void cancel();

/**
 * Dismisses the dialog, invoking the {@link android.content.DialogInterface.OnDismissListener OnDismissListener}.
 * @apiSince 1
 */

public void dismiss();

/**
 * @deprecated Use {@link #BUTTON_POSITIVE}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int BUTTON1 = -1; // 0xffffffff

/**
 * @deprecated Use {@link #BUTTON_NEGATIVE}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int BUTTON2 = -2; // 0xfffffffe

/**
 * @deprecated Use {@link #BUTTON_NEUTRAL}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int BUTTON3 = -3; // 0xfffffffd

/**
 * The identifier for the negative button.
 * @apiSince 3
 */

public static final int BUTTON_NEGATIVE = -2; // 0xfffffffe

/**
 * The identifier for the neutral button.
 * @apiSince 3
 */

public static final int BUTTON_NEUTRAL = -3; // 0xfffffffd

/**
 * The identifier for the positive button.
 * @apiSince 3
 */

public static final int BUTTON_POSITIVE = -1; // 0xffffffff
/**
 * Interface used to allow the creator of a dialog to run some code when the
 * dialog is canceled.
 * <p>
 * This will only be called when the dialog is canceled, if the creator
 * needs to know when it is dismissed in general, use
 * {@link android.content.DialogInterface.OnDismissListener DialogInterface.OnDismissListener}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnCancelListener {

/**
 * This method will be invoked when the dialog is canceled.
 *
 * @param dialog the dialog that was canceled will be passed into the
 *               method
 * @apiSince 1
 */

public void onCancel(android.content.DialogInterface dialog);
}

/**
 * Interface used to allow the creator of a dialog to run some code when an
 * item on the dialog is clicked.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnClickListener {

/**
 * This method will be invoked when a button in the dialog is clicked.
 *
 * @param dialog the dialog that received the click
 * @param which the button that was clicked (ex.
 *              {@link android.content.DialogInterface#BUTTON_POSITIVE DialogInterface#BUTTON_POSITIVE}) or the position
 *              of the item clicked
 * @apiSince 1
 */

public void onClick(android.content.DialogInterface dialog, int which);
}

/**
 * Interface used to allow the creator of a dialog to run some code when the
 * dialog is dismissed.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDismissListener {

/**
 * This method will be invoked when the dialog is dismissed.
 *
 * @param dialog the dialog that was dismissed will be passed into the
 *               method
 * @apiSince 1
 */

public void onDismiss(android.content.DialogInterface dialog);
}

/**
 * Interface definition for a callback to be invoked when a key event is
 * dispatched to this dialog. The callback will be invoked before the key
 * event is given to the dialog.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnKeyListener {

/**
 * Called when a key is dispatched to a dialog. This allows listeners to
 * get a chance to respond before the dialog.
 *
 * @param dialog the dialog the key has been dispatched to
 * @param keyCode the code for the physical key that was pressed
 * @param event the KeyEvent object containing full information about
 *              the event
 * @return {@code true} if the listener has consumed the event,
 *         {@code false} otherwise
 * @apiSince 1
 */

public boolean onKey(android.content.DialogInterface dialog, int keyCode, android.view.KeyEvent event);
}

/**
 * Interface used to allow the creator of a dialog to run some code when an
 * item in a multi-choice dialog is clicked.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnMultiChoiceClickListener {

/**
 * This method will be invoked when an item in the dialog is clicked.
 *
 * @param dialog the dialog where the selection was made
 * @param which the position of the item in the list that was clicked
 * @param isChecked {@code true} if the click checked the item, else
 *                  {@code false}
 * @apiSince 1
 */

public void onClick(android.content.DialogInterface dialog, int which, boolean isChecked);
}

/**
 * Interface used to allow the creator of a dialog to run some code when the
 * dialog is shown.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnShowListener {

/**
 * This method will be invoked when the dialog is shown.
 *
 * @param dialog the dialog that was shown will be passed into the
 *               method
 * @apiSince 8
 */

public void onShow(android.content.DialogInterface dialog);
}

}

