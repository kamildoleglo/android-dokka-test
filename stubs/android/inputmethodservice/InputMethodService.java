/*
 * Copyright (C) 2007-2008 The Android Open Source Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


package android.inputmethodservice;

import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.View;
import android.view.KeyEvent;
import android.view.inputmethod.InputBinding;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.CursorAnchorInfo;
import android.os.Build;
import android.text.InputType;

/**
 * InputMethodService provides a standard implementation of an InputMethod,
 * which final implementations can derive from and customize.  See the
 * base class {@link android.inputmethodservice.AbstractInputMethodService AbstractInputMethodService} and the {@link android.view.inputmethod.InputMethod InputMethod}
 * interface for more information on the basics of writing input methods.
 *
 * <p>In addition to the normal Service lifecycle methods, this class
 * introduces some new specific callbacks that most subclasses will want
 * to make use of:</p>
 * <ul>
 * <li> {@link #onInitializeInterface()} for user-interface initialization,
 * in particular to deal with configuration changes while the service is
 * running.
 * <li> {@link #onBindInput} to find out about switching to a new client.
 * <li> {@link #onStartInput} to deal with an input session starting with
 * the client.
 * <li> {@link #onCreateInputView()}, {@link #onCreateCandidatesView()},
 * and {@link #onCreateExtractTextView()} for non-demand generation of the UI.
 * <li> {@link #onStartInputView(android.view.inputmethod.EditorInfo,boolean)} to deal with input
 * starting within the input area of the IME.
 * </ul>
 *
 * <p>An input method has significant discretion in how it goes about its
 * work: the {@link android.inputmethodservice.InputMethodService} provides
 * a basic framework for standard UI elements (input view, candidates view,
 * and running in fullscreen mode), but it is up to a particular implementor
 * to decide how to use them.  For example, one input method could implement
 * an input area with a keyboard, another could allow the user to draw text,
 * while a third could have no input area (and thus not be visible to the
 * user) but instead listen to audio and perform text to speech conversion.</p>
 *
 * <p>In the implementation provided here, all of these elements are placed
 * together in a single window managed by the InputMethodService.  It will
 * execute callbacks as it needs information about them, and provides APIs for
 * programmatic control over them.  They layout of these elements is explicitly
 * defined:</p>
 *
 * <ul>
 * <li>The soft input view, if available, is placed at the bottom of the
 * screen.
 * <li>The candidates view, if currently shown, is placed above the soft
 * input view.
 * <li>If not running fullscreen, the application is moved or resized to be
 * above these views; if running fullscreen, the window will completely cover
 * the application and its top part will contain the extract text of what is
 * currently being edited by the application.
 * </ul>
 *
 *
 * <a name="SoftInputView"></a>
 * <h3>Soft Input View</h3>
 *
 * <p>Central to most input methods is the soft input view.  This is where most
 * user interaction occurs: pressing on soft keys, drawing characters, or
 * however else your input method wants to generate text.  Most implementations
 * will simply have their own view doing all of this work, and return a new
 * instance of it when {@link #onCreateInputView()} is called.  At that point,
 * as long as the input view is visible, you will see user interaction in
 * that view and can call back on the InputMethodService to interact with the
 * application as appropriate.</p>
 *
 * <p>There are some situations where you want to decide whether or not your
 * soft input view should be shown to the user.  This is done by implementing
 * the {@link #onEvaluateInputViewShown()} to return true or false based on
 * whether it should be shown in the current environment.  If any of your
 * state has changed that may impact this, call
 * {@link #updateInputViewShown()} to have it re-evaluated.  The default
 * implementation always shows the input view unless there is a hard
 * keyboard available, which is the appropriate behavior for most input
 * methods.</p>
 *
 *
 * <a name="CandidatesView"></a>
 * <h3>Candidates View</h3>
 *
 * <p>Often while the user is generating raw text, an input method wants to
 * provide them with a list of possible interpretations of that text that can
 * be selected for use.  This is accomplished with the candidates view, and
 * like the soft input view you implement {@link #onCreateCandidatesView()}
 * to instantiate your own view implementing your candidates UI.</p>
 *
 * <p>Management of the candidates view is a little different than the input
 * view, because the candidates view tends to be more transient, being shown
 * only when there are possible candidates for the current text being entered
 * by the user.  To control whether the candidates view is shown, you use
 * {@link #setCandidatesViewShown(boolean)}.  Note that because the candidate
 * view tends to be shown and hidden a lot, it does not impact the application
 * UI in the same way as the soft input view: it will never cause application
 * windows to resize, only cause them to be panned if needed for the user to
 * see the current focus.</p>
 *
 *
 * <a name="FullscreenMode"></a>
 * <h3>Fullscreen Mode</h3>
 *
 * <p>Sometimes your input method UI is too large to integrate with the
 * application UI, so you just want to take over the screen.  This is
 * accomplished by switching to full-screen mode, causing the input method
 * window to fill the entire screen and add its own "extracted text" editor
 * showing the user the text that is being typed.  Unlike the other UI elements,
 * there is a standard implementation for the extract editor that you should
 * not need to change.  The editor is placed at the top of the IME, above the
 * input and candidates views.</p>
 *
 * <p>Similar to the input view, you control whether the IME is running in
 * fullscreen mode by implementing {@link #onEvaluateFullscreenMode()}
 * to return true or false based on
 * whether it should be fullscreen in the current environment.  If any of your
 * state has changed that may impact this, call
 * {@link #updateFullscreenMode()} to have it re-evaluated.  The default
 * implementation selects fullscreen mode when the screen is in a landscape
 * orientation, which is appropriate behavior for most input methods that have
 * a significant input area.</p>
 *
 * <p>When in fullscreen mode, you have some special requirements because the
 * user can not see the application UI.  In particular, you should implement
 * {@link #onDisplayCompletions(android.view.inputmethod.CompletionInfo[])} to show completions
 * generated by your application, typically in your candidates view like you
 * would normally show candidates.
 *
 *
 * <a name="GeneratingText"></a>
 * <h3>Generating Text</h3>
 *
 * <p>The key part of an IME is of course generating text for the application.
 * This is done through calls to the
 * {@link android.view.inputmethod.InputConnection} interface to the
 * application, which can be retrieved from {@link #getCurrentInputConnection()}.
 * This interface allows you to generate raw key events or, if the target
 * supports it, directly edit in strings of candidates and committed text.</p>
 *
 * <p>Information about what the target is expected and supports can be found
 * through the {@link android.view.inputmethod.EditorInfo} class, which is
 * retrieved with {@link #getCurrentInputEditorInfo()} method.  The most
 * important part of this is {@link android.view.inputmethod.EditorInfo#inputType
 * EditorInfo.inputType}; in particular, if this is
 * {@link android.view.inputmethod.EditorInfo#TYPE_NULL EditorInfo.TYPE_NULL},
 * then the target does not support complex edits and you need to only deliver
 * raw key events to it.  An input method will also want to look at other
 * values here, to for example detect password mode, auto complete text views,
 * phone number entry, etc.</p>
 *
 * <p>When the user switches between input targets, you will receive calls to
 * {@link #onFinishInput()} and {@link #onStartInput(android.view.inputmethod.EditorInfo,boolean)}.
 * You can use these to reset and initialize your input state for the current
 * target.  For example, you will often want to clear any input state, and
 * update a soft keyboard to be appropriate for the new inputType.</p>
 *
 * @attr ref android.R.styleable#InputMethodService_imeFullscreenBackground
 * @attr ref android.R.styleable#InputMethodService_imeExtractEnterAnimation
 * @attr ref android.R.styleable#InputMethodService_imeExtractExitAnimation
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class InputMethodService extends android.inputmethodservice.AbstractInputMethodService {

public InputMethodService() { throw new RuntimeException("Stub!"); }

/**
 * You can call this to customize the theme used by your IME's window.
 * This theme should typically be one that derives from
 * {@link android.R.style#Theme_InputMethod}, which is the default theme
 * you will get.  This must be set before {@link #onCreate}, so you
 * will typically call it in your constructor with the resource ID
 * of your custom theme.
 * @apiSince 3
 */

public void setTheme(int theme) { throw new RuntimeException("Stub!"); }

/**
 * You can call this to try to enable accelerated drawing for your IME. This must be set before
 * {@link #onCreate()}, so you will typically call it in your constructor.  It is not always
 * possible to use hardware accelerated drawing in an IME (for example on low-end devices that
 * do not have the resources to support this), so the call {@code true} if it succeeds otherwise
 * {@code false} if you will need to draw in software.  You must be able to handle either case.
 *
 * <p>In API 21 and later, system may automatically enable hardware accelerated drawing for your
 * IME on capable devices even if this method is not explicitly called. Make sure that your IME
 * is able to handle either case.</p>
 *
 * @return {@code true} if accelerated drawing is successfully enabled otherwise {@code false}.
 *         On API 21 and later devices the return value is basically just a hint and your IME
 *         does not need to change the behavior based on the it
 * @deprecated Starting in API 21, hardware acceleration is always enabled on capable devices
 * @apiSince 17
 * @deprecatedSince 21
 */

@Deprecated
public boolean enableHardwareAcceleration() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void onCreate() { throw new RuntimeException("Stub!"); }

/**
 * This is a hook that subclasses can use to perform initialization of
 * their interface.  It is called for you prior to any of your UI objects
 * being created, both after the service is first created and after a
 * configuration change happens.
 * @apiSince 3
 */

public void onInitializeInterface() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void onDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Take care of handling configuration changes.  Subclasses of
 * InputMethodService generally don't need to deal directly with
 * this on their own; the standard implementation here takes care of
 * regenerating the input method UI as a result of the configuration
 * change, so you can rely on your {@link #onCreateInputView} and
 * other methods being called as appropriate due to a configuration change.
 *
 * <p>When a configuration change does happen,
 * {@link #onInitializeInterface()} is guaranteed to be called the next
 * time prior to any of the other input or UI creation callbacks.  The
 * following will be called immediately depending if appropriate for current
 * state: {@link #onStartInput} if input is active, and
 * {@link #onCreateInputView} and {@link #onStartInputView} and related
 * appropriate functions if the UI is displayed.
 * @apiSince 3
 */

public void onConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * Implement to return our standard {@link android.inputmethodservice.InputMethodService.InputMethodImpl InputMethodImpl}.  Subclasses
 * can override to provide their own customized version.
 * @apiSince 3
 */

public android.inputmethodservice.AbstractInputMethodService.AbstractInputMethodImpl onCreateInputMethodInterface() { throw new RuntimeException("Stub!"); }

/**
 * Implement to return our standard {@link android.inputmethodservice.InputMethodService.InputMethodSessionImpl InputMethodSessionImpl}.  Subclasses
 * can override to provide their own customized version.
 * @apiSince 3
 */

public android.inputmethodservice.AbstractInputMethodService.AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public android.view.LayoutInflater getLayoutInflater() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public android.app.Dialog getWindow() { throw new RuntimeException("Stub!"); }

/**
 * Sets the disposition mode that indicates the expected affordance for the back button.
 *
 * <p>Keep in mind that specifying this flag does not change the the default behavior of
 * {@link #onKeyDown(int,android.view.KeyEvent)}.  It is IME developers' responsibility for making sure that
 * their custom implementation of {@link #onKeyDown(int,android.view.KeyEvent)} is consistent with the mode
 * specified to this API.</p>
 *
 * @see #getBackDisposition()
 * @param disposition disposition mode to be set
 
 * Value is {@link android.inputmethodservice.InputMethodService#BACK_DISPOSITION_DEFAULT}, {@link android.inputmethodservice.InputMethodService#BACK_DISPOSITION_WILL_NOT_DISMISS}, {@link android.inputmethodservice.InputMethodService#BACK_DISPOSITION_WILL_DISMISS}, or {@link android.inputmethodservice.InputMethodService#BACK_DISPOSITION_ADJUST_NOTHING}
 * @apiSince 11
 */

public void setBackDisposition(int disposition) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the current disposition mode that indicates the expected back button affordance.
 *
 * @see #setBackDisposition(int)
 * @return currently selected disposition mode
 
 * Value is {@link android.inputmethodservice.InputMethodService#BACK_DISPOSITION_DEFAULT}, {@link android.inputmethodservice.InputMethodService#BACK_DISPOSITION_WILL_NOT_DISMISS}, {@link android.inputmethodservice.InputMethodService#BACK_DISPOSITION_WILL_DISMISS}, or {@link android.inputmethodservice.InputMethodService#BACK_DISPOSITION_ADJUST_NOTHING}
 * @apiSince 11
 */

public int getBackDisposition() { throw new RuntimeException("Stub!"); }

/**
 * Return the maximum width, in pixels, available the input method.
 * Input methods are positioned at the bottom of the screen and, unless
 * running in fullscreen, will generally want to be as short as possible
 * so should compute their height based on their contents.  However, they
 * can stretch as much as needed horizontally.  The function returns to
 * you the maximum amount of space available horizontally, which you can
 * use if needed for UI placement.
 *
 * <p>In many cases this is not needed, you can just rely on the normal
 * view layout mechanisms to position your views within the full horizontal
 * space given to the input method.
 *
 * <p>Note that this value can change dynamically, in particular when the
 * screen orientation changes.
 * @apiSince 3
 */

public int getMaxWidth() { throw new RuntimeException("Stub!"); }

/**
 * Return the currently active InputBinding for the input method, or
 * null if there is none.
 * @apiSince 3
 */

public android.view.inputmethod.InputBinding getCurrentInputBinding() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the currently active InputConnection that is bound to
 * the input method, or null if there is none.
 * @apiSince 3
 */

public android.view.inputmethod.InputConnection getCurrentInputConnection() { throw new RuntimeException("Stub!"); }

/**
 * Force switch to the last used input method and subtype. If the last input method didn't have
 * any subtypes, the framework will simply switch to the last input method with no subtype
 * specified.
 * @return true if the current input method and subtype was successfully switched to the last
 * used input method and subtype.
 * @apiSince 28
 */

public final boolean switchToPreviousInputMethod() { throw new RuntimeException("Stub!"); }

/**
 * Force switch to the next input method and subtype. If there is no IME enabled except
 * current IME and subtype, do nothing.
 * @param onlyCurrentIme if true, the framework will find the next subtype which
 * belongs to the current IME
 * @return true if the current input method and subtype was successfully switched to the next
 * input method and subtype.
 * @apiSince 28
 */

public final boolean switchToNextInputMethod(boolean onlyCurrentIme) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the current IME needs to offer the users ways to switch to a next input
 * method (e.g.&nbsp;a globe key.).
 * When an IME sets supportsSwitchingToNextInputMethod and this method returns true,
 * the IME has to offer ways to to invoke {@link #switchToNextInputMethod} accordingly.
 * <p> Note that the system determines the most appropriate next input method
 * and subtype in order to provide the consistent user experience in switching
 * between IMEs and subtypes.
 * @apiSince 28
 */

public final boolean shouldOfferSwitchingToNextInputMethod() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean getCurrentInputStarted() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public android.view.inputmethod.EditorInfo getCurrentInputEditorInfo() { throw new RuntimeException("Stub!"); }

/**
 * Re-evaluate whether the input method should be running in fullscreen
 * mode, and update its UI if this has changed since the last time it
 * was evaluated.  This will call {@link #onEvaluateFullscreenMode()} to
 * determine whether it should currently run in fullscreen mode.  You
 * can use {@link #isFullscreenMode()} to determine if the input method
 * is currently running in fullscreen mode.
 * @apiSince 3
 */

public void updateFullscreenMode() { throw new RuntimeException("Stub!"); }

/**
 * Update the given window's parameters for the given mode.  This is called
 * when the window is first displayed and each time the fullscreen or
 * candidates only mode changes.
 *
 * <p>The default implementation makes the layout for the window
 * MATCH_PARENT x MATCH_PARENT when in fullscreen mode, and
 * MATCH_PARENT x WRAP_CONTENT when in non-fullscreen mode.
 *
 * @param win The input method's window.
 * @param isFullscreen If true, the window is running in fullscreen mode
 * and intended to cover the entire application display.
 * @param isCandidatesOnly If true, the window is only showing the
 * candidates view and none of the rest of its UI.  This is mutually
 * exclusive with fullscreen mode.
 * @apiSince 3
 */

public void onConfigureWindow(android.view.Window win, boolean isFullscreen, boolean isCandidatesOnly) { throw new RuntimeException("Stub!"); }

/**
 * Return whether the input method is <em>currently</em> running in
 * fullscreen mode.  This is the mode that was last determined and
 * applied by {@link #updateFullscreenMode()}.
 * @apiSince 3
 */

public boolean isFullscreenMode() { throw new RuntimeException("Stub!"); }

/**
 * Override this to control when the input method should run in
 * fullscreen mode.  The default implementation runs in fullsceen only
 * when the screen is in landscape mode.  If you change what
 * this returns, you will need to call {@link #updateFullscreenMode()}
 * yourself whenever the returned value may have changed to have it
 * re-evaluated and applied.
 * @apiSince 3
 */

public boolean onEvaluateFullscreenMode() { throw new RuntimeException("Stub!"); }

/**
 * Controls the visibility of the extracted text area.  This only applies
 * when the input method is in fullscreen mode, and thus showing extracted
 * text.  When false, the extracted text will not be shown, allowing some
 * of the application to be seen behind.  This is normally set for you
 * by {@link #onUpdateExtractingVisibility}.  This controls the visibility
 * of both the extracted text and candidate view; the latter since it is
 * not useful if there is no text to see.
 * @apiSince 3
 */

public void setExtractViewShown(boolean shown) { throw new RuntimeException("Stub!"); }

/**
 * Return whether the fullscreen extract view is shown.  This will only
 * return true if {@link #isFullscreenMode()} returns true, and in that
 * case its value depends on the last call to
 * {@link #setExtractViewShown(boolean)}.  This effectively lets you
 * determine if the application window is entirely covered (when this
 * returns true) or if some part of it may be shown (if this returns
 * false, though if {@link #isFullscreenMode()} returns true in that case
 * then it is probably only a sliver of the application).
 * @apiSince 3
 */

public boolean isExtractViewShown() { throw new RuntimeException("Stub!"); }

/**
 * Compute the interesting insets into your UI.  The default implementation
 * uses the top of the candidates frame for the visible insets, and the
 * top of the input frame for the content insets.  The default touchable
 * insets are {@link android.inputmethodservice.InputMethodService.Insets#TOUCHABLE_INSETS_VISIBLE Insets#TOUCHABLE_INSETS_VISIBLE}.
 *
 * <p>Note that this method is not called when
 * {@link #isExtractViewShown} returns true, since
 * in that case the application is left as-is behind the input method and
 * not impacted by anything in its UI.
 *
 * @param outInsets Fill in with the current UI insets.
 * @apiSince 3
 */

public void onComputeInsets(android.inputmethodservice.InputMethodService.Insets outInsets) { throw new RuntimeException("Stub!"); }

/**
 * Re-evaluate whether the soft input area should currently be shown, and
 * update its UI if this has changed since the last time it
 * was evaluated.  This will call {@link #onEvaluateInputViewShown()} to
 * determine whether the input view should currently be shown.  You
 * can use {@link #isInputViewShown()} to determine if the input view
 * is currently shown.
 * @apiSince 3
 */

public void updateInputViewShown() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if we have been asked to show our input view.
 * @apiSince 3
 */

public boolean isShowInputRequested() { throw new RuntimeException("Stub!"); }

/**
 * Return whether the soft input view is <em>currently</em> shown to the
 * user.  This is the state that was last determined and
 * applied by {@link #updateInputViewShown()}.
 * @apiSince 3
 */

public boolean isInputViewShown() { throw new RuntimeException("Stub!"); }

/**
 * Override this to control when the soft input area should be shown to the user.  The default
 * implementation returns {@code false} when there is no hard keyboard or the keyboard is hidden
 * unless the user shows an intention to use software keyboard.  If you change what this
 * returns, you will need to call {@link #updateInputViewShown()} yourself whenever the returned
 * value may have changed to have it re-evaluated and applied.
 *
 * <p>When you override this method, it is recommended to call
 * {@code super.onEvaluateInputViewShown()} and return {@code true} when {@code true} is
 * returned.</p>
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 3
 */

public boolean onEvaluateInputViewShown() { throw new RuntimeException("Stub!"); }

/**
 * Controls the visibility of the candidates display area.  By default
 * it is hidden.
 * @apiSince 3
 */

public void setCandidatesViewShown(boolean shown) { throw new RuntimeException("Stub!"); }

/**
 * Returns the visibility mode (either {@link android.view.View#INVISIBLE View#INVISIBLE}
 * or {@link android.view.View#GONE View#GONE}) of the candidates view when it is not
 * shown.  The default implementation returns GONE when
 * {@link #isExtractViewShown} returns true,
 * otherwise VISIBLE.  Be careful if you change this to return GONE in
 * other situations -- if showing or hiding the candidates view causes
 * your window to resize, this can cause temporary drawing artifacts as
 * the resize takes place.
 * @apiSince 3
 */

public int getCandidatesHiddenVisibility() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void showStatusIcon(int iconResId) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void hideStatusIcon() { throw new RuntimeException("Stub!"); }

/**
 * Force switch to a new input method, as identified by <var>id</var>.  This
 * input method will be destroyed, and the requested one started on the
 * current input field.
 *
 * @param id Unique identifier of the new input method to start.
 * @apiSince 3
 */

public void switchInputMethod(java.lang.String id) { throw new RuntimeException("Stub!"); }

/**
 * Force switch to a new input method, as identified by {@code id}.  This
 * input method will be destroyed, and the requested one started on the
 * current input field.
 *
 * @param id Unique identifier of the new input method to start.
 * @param subtype The new subtype of the new input method to be switched to.
 * @apiSince 28
 */

public final void switchInputMethod(java.lang.String id, android.view.inputmethod.InputMethodSubtype subtype) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void setExtractView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Replaces the current candidates view with a new one.  You only need to
 * call this when dynamically changing the view; normally, you should
 * implement {@link #onCreateCandidatesView()} and create your view when
 * first needed by the input method.
 * @apiSince 3
 */

public void setCandidatesView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Replaces the current input view with a new one.  You only need to
 * call this when dynamically changing the view; normally, you should
 * implement {@link #onCreateInputView()} and create your view when
 * first needed by the input method.
 * @apiSince 3
 */

public void setInputView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Called by the framework to create the layout for showing extacted text.
 * Only called when in fullscreen mode.  The returned view hierarchy must
 * have an {@link android.inputmethodservice.ExtractEditText ExtractEditText} whose ID is
 * {@link android.R.id#inputExtractEditText}.
 * @apiSince 3
 */

public android.view.View onCreateExtractTextView() { throw new RuntimeException("Stub!"); }

/**
 * Create and return the view hierarchy used to show candidates.  This will
 * be called once, when the candidates are first displayed.  You can return
 * null to have no candidates view; the default implementation returns null.
 *
 * <p>To control when the candidates view is displayed, use
 * {@link #setCandidatesViewShown(boolean)}.
 * To change the candidates view after the first one is created by this
 * function, use {@link #setCandidatesView(android.view.View)}.
 * @apiSince 3
 */

public android.view.View onCreateCandidatesView() { throw new RuntimeException("Stub!"); }

/**
 * Create and return the view hierarchy used for the input area (such as
 * a soft keyboard).  This will be called once, when the input area is
 * first displayed.  You can return null to have no input area; the default
 * implementation returns null.
 *
 * <p>To control when the input view is displayed, implement
 * {@link #onEvaluateInputViewShown()}.
 * To change the input view after the first one is created by this
 * function, use {@link #setInputView(android.view.View)}.
 * @apiSince 3
 */

public android.view.View onCreateInputView() { throw new RuntimeException("Stub!"); }

/**
 * Called when the input view is being shown and input has started on
 * a new editor.  This will always be called after {@link #onStartInput},
 * allowing you to do your general setup there and just view-specific
 * setup here.  You are guaranteed that {@link #onCreateInputView()} will
 * have been called some time before this function is called.
 *
 * @param info Description of the type of text being edited.
 * @param restarting Set to true if we are restarting input on the
 * same text field as before.
 * @apiSince 3
 */

public void onStartInputView(android.view.inputmethod.EditorInfo info, boolean restarting) { throw new RuntimeException("Stub!"); }

/**
 * Called when the input view is being hidden from the user.  This will
 * be called either prior to hiding the window, or prior to switching to
 * another target for editing.
 *
 * <p>The default
 * implementation uses the InputConnection to clear any active composing
 * text; you can override this (not calling the base class implementation)
 * to perform whatever behavior you would like.
 *
 * @param finishingInput If true, {@link #onFinishInput} will be
 * called immediately after.
 * @apiSince 3
 */

public void onFinishInputView(boolean finishingInput) { throw new RuntimeException("Stub!"); }

/**
 * Called when only the candidates view has been shown for showing
 * processing as the user enters text through a hard keyboard.
 * This will always be called after {@link #onStartInput},
 * allowing you to do your general setup there and just view-specific
 * setup here.  You are guaranteed that {@link #onCreateCandidatesView()}
 * will have been called some time before this function is called.
 *
 * <p>Note that this will <em>not</em> be called when the input method
 * is running in full editing mode, and thus receiving
 * {@link #onStartInputView} to initiate that operation.  This is only
 * for the case when candidates are being shown while the input method
 * editor is hidden but wants to show its candidates UI as text is
 * entered through some other mechanism.
 *
 * @param info Description of the type of text being edited.
 * @param restarting Set to true if we are restarting input on the
 * same text field as before.
 * @apiSince 3
 */

public void onStartCandidatesView(android.view.inputmethod.EditorInfo info, boolean restarting) { throw new RuntimeException("Stub!"); }

/**
 * Called when the candidates view is being hidden from the user.  This will
 * be called either prior to hiding the window, or prior to switching to
 * another target for editing.
 *
 * <p>The default
 * implementation uses the InputConnection to clear any active composing
 * text; you can override this (not calling the base class implementation)
 * to perform whatever behavior you would like.
 *
 * @param finishingInput If true, {@link #onFinishInput} will be
 * called immediately after.
 * @apiSince 3
 */

public void onFinishCandidatesView(boolean finishingInput) { throw new RuntimeException("Stub!"); }

/**
 * The system has decided that it may be time to show your input method.
 * This is called due to a corresponding call to your
 * {@link android.view.inputmethod.InputMethod#showSoftInput InputMethod#showSoftInput}
 * method.  The default implementation uses
 * {@link #onEvaluateInputViewShown()}, {@link #onEvaluateFullscreenMode()},
 * and the current configuration to decide whether the input view should
 * be shown at this point.
 *
 * @param flags Provides additional information about the show request,
 * as per {@link android.view.inputmethod.InputMethod#showSoftInput InputMethod#showSoftInput}.
 * @param configChange This is true if we are re-showing due to a
 * configuration change.
 * @return Returns true to indicate that the window should be shown.
 * @apiSince 3
 */

public boolean onShowInputRequested(int flags, boolean configChange) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void showWindow(boolean showInput) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void hideWindow() { throw new RuntimeException("Stub!"); }

/**
 * Called immediately before the input method window is shown to the user.
 * You could override this to prepare for the window to be shown
 * (update view structure etc).
 * @apiSince 3
 */

public void onWindowShown() { throw new RuntimeException("Stub!"); }

/**
 * Called when the input method window has been hidden from the user,
 * after previously being visible.
 * @apiSince 3
 */

public void onWindowHidden() { throw new RuntimeException("Stub!"); }

/**
 * Called when a new client has bound to the input method.  This
 * may be followed by a series of {@link #onStartInput(android.view.inputmethod.EditorInfo,boolean)}
 * and {@link #onFinishInput()} calls as the user navigates through its
 * UI.  Upon this call you know that {@link #getCurrentInputBinding}
 * and {@link #getCurrentInputConnection} return valid objects.
 * @apiSince 3
 */

public void onBindInput() { throw new RuntimeException("Stub!"); }

/**
 * Called when the previous bound client is no longer associated
 * with the input method.  After returning {@link #getCurrentInputBinding}
 * and {@link #getCurrentInputConnection} will no longer return
 * valid objects.
 * @apiSince 3
 */

public void onUnbindInput() { throw new RuntimeException("Stub!"); }

/**
 * Called to inform the input method that text input has started in an
 * editor.  You should use this callback to initialize the state of your
 * input to match the state of the editor given to it.
 *
 * @param attribute The attributes of the editor that input is starting
 * in.
 * @param restarting Set to true if input is restarting in the same
 * editor such as because the application has changed the text in
 * the editor.  Otherwise will be false, indicating this is a new
 * session with the editor.
 * @apiSince 3
 */

public void onStartInput(android.view.inputmethod.EditorInfo attribute, boolean restarting) { throw new RuntimeException("Stub!"); }

/**
 * Called to inform the input method that text input has finished in
 * the last editor.  At this point there may be a call to
 * {@link #onStartInput(android.view.inputmethod.EditorInfo,boolean)} to perform input in a
 * new editor, or the input method may be left idle.  This method is
 * <em>not</em> called when input restarts in the same editor.
 *
 * <p>The default
 * implementation uses the InputConnection to clear any active composing
 * text; you can override this (not calling the base class implementation)
 * to perform whatever behavior you would like.
 * @apiSince 3
 */

public void onFinishInput() { throw new RuntimeException("Stub!"); }

/**
 * Called when the application has reported auto-completion candidates that
 * it would like to have the input method displayed.  Typically these are
 * only used when an input method is running in full-screen mode, since
 * otherwise the user can see and interact with the pop-up window of
 * completions shown by the application.
 *
 * <p>The default implementation here does nothing.
 * @apiSince 3
 */

public void onDisplayCompletions(android.view.inputmethod.CompletionInfo[] completions) { throw new RuntimeException("Stub!"); }

/**
 * Called when the application has reported new extracted text to be shown
 * due to changes in its current text state.  The default implementation
 * here places the new text in the extract edit text, when the input
 * method is running in fullscreen mode.
 * @apiSince 3
 */

public void onUpdateExtractedText(int token, android.view.inputmethod.ExtractedText text) { throw new RuntimeException("Stub!"); }

/**
 * Called when the application has reported a new selection region of
 * the text.  This is called whether or not the input method has requested
 * extracted text updates, although if so it will not receive this call
 * if the extracted text has changed as well.
 *
 * <p>Be careful about changing the text in reaction to this call with
 * methods such as setComposingText, commitText or
 * deleteSurroundingText. If the cursor moves as a result, this method
 * will be called again, which may result in an infinite loop.
 *
 * <p>The default implementation takes care of updating the cursor in
 * the extract text, if it is being shown.
 * @apiSince 3
 */

public void onUpdateSelection(int oldSelStart, int oldSelEnd, int newSelStart, int newSelEnd, int candidatesStart, int candidatesEnd) { throw new RuntimeException("Stub!"); }

/**
 * Called when the user tapped or clicked a text view.
 * IMEs can't rely on this method being called because this was not part of the original IME
 * protocol, so applications with custom text editing written before this method appeared will
 * not call to inform the IME of this interaction.
 * @param focusChanged true if the user changed the focused view by this click.
 * @see android.view.inputmethod.InputMethodManager#viewClicked(View)
 * @deprecated The method may not be called for composite {@link android.view.View View} that works as a giant
 *             "Canvas", which can host its own UI hierarchy and sub focus state.
 *             {@link android.webkit.WebView} is a good example. Application / IME developers
 *             should not rely on this method. If your goal is just being notified when an
 *             on-going input is interrupted, simply monitor {@link #onFinishInput()}.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void onViewClicked(boolean focusChanged) { throw new RuntimeException("Stub!"); }

/**
 * Called when the application has reported a new location of its text
 * cursor.  This is only called if explicitly requested by the input method.
 * The default implementation does nothing.
 * @deprecated Use {@link #onUpdateCursorAnchorInfo(android.view.inputmethod.CursorAnchorInfo)} instead.
 * @apiSince 3
 * @deprecatedSince 21
 */

@Deprecated
public void onUpdateCursor(android.graphics.Rect newCursor) { throw new RuntimeException("Stub!"); }

/**
 * Called when the application has reported a new location of its text insertion point and
 * characters in the composition string.  This is only called if explicitly requested by the
 * input method. The default implementation does nothing.
 * @param cursorAnchorInfo The positional information of the text insertion point and the
 * composition string.
 * @apiSince 21
 */

public void onUpdateCursorAnchorInfo(android.view.inputmethod.CursorAnchorInfo cursorAnchorInfo) { throw new RuntimeException("Stub!"); }

/**
 * Close this input method's soft input area, removing it from the display.
 *
 * The input method will continue running, but the user can no longer use it to generate input
 * by touching the screen.
 *
 * @see android.view.inputmethod.InputMethodManager#HIDE_IMPLICIT_ONLY
 * @see android.view.inputmethod.InputMethodManager#HIDE_NOT_ALWAYS
 * @param flags Provides additional operating flags.
 * @apiSince 3
 */

public void requestHideSelf(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Show the input method's soft input area, so the user sees the input method window and can
 * interact with it.
 *
 * @see android.view.inputmethod.InputMethodManager#SHOW_IMPLICIT
 * @see android.view.inputmethod.InputMethodManager#SHOW_FORCED
 * @param flags Provides additional operating flags.
 * @apiSince 28
 */

public final void requestShowSelf(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Called back when a {@link android.view.KeyEvent KeyEvent} is forwarded from the target application.
 *
 * <p>The default implementation intercepts {@link android.view.KeyEvent#KEYCODE_BACK KeyEvent#KEYCODE_BACK} if the IME is
 * currently shown , to possibly hide it when the key goes up (if not canceled or long pressed).
 * In addition, in fullscreen mode only, it will consume DPAD movement events to move the cursor
 * in the extracted text view, not allowing them to perform navigation in the underlying
 * application.</p>
 *
 * <p>The default implementation does not take flags specified to
 * {@link #setBackDisposition(int)} into account, even on API version
 * {@link android.os.Build.VERSION_CODES#P} and later devices.  IME developers are responsible
 * for making sure that their special handling for {@link android.view.KeyEvent#KEYCODE_BACK KeyEvent#KEYCODE_BACK} are consistent
 * with the flag they specified to {@link #setBackDisposition(int)}.</p>
 *
 * @param keyCode The value in {@code event.getKeyCode()}
 * @param event Description of the key event
 *
 * @return {@code true} if the event is consumed by the IME and the application no longer needs
 *         to consume it.  Return {@code false} when the event should be handled as if the IME
 *         had not seen the event at all.
 * @apiSince 3
 */

public boolean onKeyDown(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of {@link android.view.KeyEvent.Callback#onKeyLongPress(int,android.view.KeyEvent) KeyEvent.Callback#onKeyLongPress(int, KeyEvent)}: always returns false (doesn't handle
 * the event).
 * @apiSince 5
 */

public boolean onKeyLongPress(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Override this to intercept special key multiple events before they are
 * processed by the
 * application.  If you return true, the application will not itself
 * process the event.  If you return false, the normal application processing
 * will occur as if the IME had not seen the event at all.
 *
 * <p>The default implementation always returns false, except when
 * in fullscreen mode, where it will consume DPAD movement
 * events to move the cursor in the extracted text view, not allowing
 * them to perform navigation in the underlying application.
 * @apiSince 3
 */

public boolean onKeyMultiple(int keyCode, int count, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Override this to intercept key up events before they are processed by the
 * application.  If you return true, the application will not itself
 * process the event.  If you return false, the normal application processing
 * will occur as if the IME had not seen the event at all.
 *
 * <p>The default implementation intercepts {@link android.view.KeyEvent#KEYCODE_BACK KeyEvent#KEYCODE_BACK} to hide the current IME UI if it is shown.  In
 * addition, in fullscreen mode only, it will consume DPAD movement
 * events to move the cursor in the extracted text view, not allowing
 * them to perform navigation in the underlying application.
 * @apiSince 3
 */

public boolean onKeyUp(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Override this to intercept trackball motion events before they are
 * processed by the application.
 * If you return true, the application will not itself process the event.
 * If you return false, the normal application processing will occur as if
 * the IME had not seen the event at all.
 * @apiSince 3
 */

public boolean onTrackballEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Override this to intercept generic motion events before they are
 * processed by the application.
 * If you return true, the application will not itself process the event.
 * If you return false, the normal application processing will occur as if
 * the IME had not seen the event at all.
 * @apiSince 17
 */

public boolean onGenericMotionEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void onAppPrivateCommand(java.lang.String action, android.os.Bundle data) { throw new RuntimeException("Stub!"); }

/**
 * Send the given key event code (as defined by {@link android.view.KeyEvent KeyEvent}) to the
 * current input connection is a key down + key up event pair.  The sent
 * events have {@link android.view.KeyEvent#FLAG_SOFT_KEYBOARD KeyEvent#FLAG_SOFT_KEYBOARD}
 * set, so that the recipient can identify them as coming from a software
 * input method, and
 * {@link android.view.KeyEvent#FLAG_KEEP_TOUCH_MODE KeyEvent#FLAG_KEEP_TOUCH_MODE}, so
 * that they don't impact the current touch mode of the UI.
 *
 * <p>Note that it's discouraged to send such key events in normal operation;
 * this is mainly for use with {@link android.text.InputType#TYPE_NULL} type
 * text fields, or for non-rich input methods. A reasonably capable software
 * input method should use the
 * {@link android.view.inputmethod.InputConnection#commitText} family of methods
 * to send text to an application, rather than sending key events.</p>
 *
 * @param keyEventCode The raw key code to send, as defined by
 * {@link android.view.KeyEvent KeyEvent}.
 * @apiSince 3
 */

public void sendDownUpKeyEvents(int keyEventCode) { throw new RuntimeException("Stub!"); }

/**
 * Ask the input target to execute its default action via
 * {@link android.view.inputmethod.InputConnection#performEditorAction InputConnection#performEditorAction}.
 *
 * @param fromEnterKey If true, this will be executed as if the user had
 * pressed an enter key on the keyboard, that is it will <em>not</em>
 * be done if the editor has set {@link android.view.inputmethod.EditorInfo#IME_FLAG_NO_ENTER_ACTION EditorInfo#IME_FLAG_NO_ENTER_ACTION}.  If false, the action will be
 * sent regardless of how the editor has set that flag.
 *
 * @return Returns a boolean indicating whether an action has been sent.
 * If false, either the editor did not specify a default action or it
 * does not want an action from the enter key.  If true, the action was
 * sent (or there was no input connection at all).
 * @apiSince 3
 */

public boolean sendDefaultEditorAction(boolean fromEnterKey) { throw new RuntimeException("Stub!"); }

/**
 * Send the given UTF-16 character to the current input connection.  Most
 * characters will be delivered simply by calling
 * {@link android.view.inputmethod.InputConnection#commitText InputConnection#commitText} with
 * the character; some, however, may be handled different.  In particular,
 * the enter character ('\n') will either be delivered as an action code
 * or a raw key event, as appropriate.  Consider this as a convenience
 * method for IMEs that do not have a full implementation of actions; a
 * fully complying IME will decide of the right action for each event and
 * will likely never call this method except maybe to handle events coming
 * from an actual hardware keyboard.
 *
 * @param charCode The UTF-16 character code to send.
 * @apiSince 3
 */

public void sendKeyChar(char charCode) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the user has moved the cursor in the extracted
 * text view, when running in fullsreen mode.  The default implementation
 * performs the corresponding selection change on the underlying text
 * editor.
 * @apiSince 3
 */

public void onExtractedSelectionChanged(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the user has clicked on the extracted text view,
 * when running in fullscreen mode.  The default implementation hides
 * the candidates view when this happens, but only if the extracted text
 * editor has a vertical scroll bar because its text doesn't fit.
 * Re-implement this to provide whatever behavior you want.
 * @apiSince 3
 */

public void onExtractedTextClicked() { throw new RuntimeException("Stub!"); }

/**
 * This is called when the user has performed a cursor movement in the
 * extracted text view, when it is running in fullscreen mode.  The default
 * implementation hides the candidates view when a vertical movement
 * happens, but only if the extracted text editor has a vertical scroll bar
 * because its text doesn't fit.
 * Re-implement this to provide whatever behavior you want.
 * @param dx The amount of cursor movement in the x dimension.
 * @param dy The amount of cursor movement in the y dimension.
 * @apiSince 3
 */

public void onExtractedCursorMovement(int dx, int dy) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the user has selected a context menu item from the
 * extracted text view, when running in fullscreen mode.  The default
 * implementation sends this action to the current InputConnection's
 * {@link android.view.inputmethod.InputConnection#performContextMenuAction(int) InputConnection#performContextMenuAction(int)}, for it
 * to be processed in underlying "real" editor.  Re-implement this to
 * provide whatever behavior you want.
 * @apiSince 3
 */

public boolean onExtractTextContextMenuItem(int id) { throw new RuntimeException("Stub!"); }

/**
 * Return text that can be used as a button label for the given
 * {@link android.view.inputmethod.EditorInfo#imeOptions EditorInfo#imeOptions}.  Returns null
 * if there is no action requested.  Note that there is no guarantee that
 * the returned text will be relatively short, so you probably do not
 * want to use it as text on a soft keyboard key label.
 *
 * @param imeOptions The value from {@link android.view.inputmethod.EditorInfo#imeOptions EditorInfo#imeOptions}.
 *
 * @return Returns a label to use, or null if there is no action.
 * @apiSince 3
 */

public java.lang.CharSequence getTextForImeAction(int imeOptions) { throw new RuntimeException("Stub!"); }

/**
 * Called when the fullscreen-mode extracting editor info has changed,
 * to determine whether the extracting (extract text and candidates) portion
 * of the UI should be shown.  The standard implementation hides or shows
 * the extract area depending on whether it makes sense for the
 * current editor.  In particular, a {@link android.text.InputType#TYPE_NULL InputType#TYPE_NULL}
 * input type or {@link android.view.inputmethod.EditorInfo#IME_FLAG_NO_EXTRACT_UI EditorInfo#IME_FLAG_NO_EXTRACT_UI} flag will
 * turn off the extract area since there is no text to be shown.
 * @apiSince 3
 */

public void onUpdateExtractingVisibility(android.view.inputmethod.EditorInfo ei) { throw new RuntimeException("Stub!"); }

/**
 * Called when the fullscreen-mode extracting editor info has changed,
 * to update the state of its UI such as the action buttons shown.
 * You do not need to deal with this if you are using the standard
 * full screen extract UI.  If replacing it, you will need to re-implement
 * this to put the appropriate action button in your own UI and handle it,
 * and perform any other changes.
 *
 * <p>The standard implementation turns on or off its accessory area
 * depending on whether there is an action button, and hides or shows
 * the entire extract area depending on whether it makes sense for the
 * current editor.  In particular, a {@link android.text.InputType#TYPE_NULL InputType#TYPE_NULL} or
 * {@link android.text.InputType#TYPE_TEXT_VARIATION_FILTER InputType#TYPE_TEXT_VARIATION_FILTER} input type will turn off the
 * extract area since there is no text to be shown.
 * @apiSince 3
 */

public void onUpdateExtractingViews(android.view.inputmethod.EditorInfo ei) { throw new RuntimeException("Stub!"); }

/**
 * This is called when, while currently displayed in extract mode, the
 * current input target changes.  The default implementation will
 * auto-hide the IME if the new target is not a full editor, since this
 * can be a confusing experience for the user.
 * @apiSince 3
 */

public void onExtractingInputChanged(android.view.inputmethod.EditorInfo ei) { throw new RuntimeException("Stub!"); }

/**
 * Called when the subtype was changed.
 * @param newSubtype the subtype which is being changed to.
 * @apiSince 11
 */

protected void onCurrentInputMethodSubtypeChanged(android.view.inputmethod.InputMethodSubtype newSubtype) { throw new RuntimeException("Stub!"); }

/**
 * Aimed to return the previous input method's {@link android.inputmethodservice.InputMethodService.Insets#contentTopInsets Insets#contentTopInsets}, but its actual
 * semantics has never been well defined.
 *
 * <p>Note that the previous document clearly mentioned that this method could return {@code 0}
 * at any time for whatever reason.  Now this method is just always returning {@code 0}.</p>
 *
 * @return on Android {@link android.os.Build.VERSION_CODES#Q} and later devices this method
 *         always returns {@code 0}
 * @deprecated the actual behavior of this method has never been well defined.  You cannot use
 *             this method in a reliable and predictable way
 * @apiSince 21
 * @deprecatedSince 29
 */

@Deprecated
public int getInputMethodWindowRecommendedHeight() { throw new RuntimeException("Stub!"); }

/**
 * Performs a dump of the InputMethodService's internal state.  Override
 * to add your own information to the dump.
 * @apiSince 3
 */

protected void dump(java.io.FileDescriptor fd, java.io.PrintWriter fout, java.lang.String[] args) { throw new RuntimeException("Stub!"); }

/**
 * Asks the system to not adjust the back button affordance even when the software keyboard is
 * shown.
 *
 * <p>This mode is useful for UI modes where IME's main soft input window is used for some
 * supplemental UI, such as floating candidate window for languages such as Chinese and
 * Japanese, where users expect the back button is, or at least looks to be, handled by the
 * target application rather than the UI shown by the IME even while {@link #isInputViewShown()}
 * returns {@code true}.</p>
 *
 * <p>Note that {@link android.view.KeyEvent#KEYCODE_BACK KeyEvent#KEYCODE_BACK} events continue to be sent to
 * {@link #onKeyDown(int,android.view.KeyEvent)} even when this mode is specified. The default
 * implementation of {@link #onKeyDown(int,android.view.KeyEvent)} for {@link android.view.KeyEvent#KEYCODE_BACK KeyEvent#KEYCODE_BACK} does
 * not take this mode into account.</p>
 *
 * @see #setBackDisposition(int)
 * @apiSince 28
 */

public static final int BACK_DISPOSITION_ADJUST_NOTHING = 3; // 0x3

/**
 * Allows the system to optimize the back button affordance based on the presence of software
 * keyboard.
 *
 * <p>For instance, on devices that have navigation bar and software-rendered back button, the
 * system may use a different icon while {@link #isInputViewShown()} returns {@code true}, to
 * indicate that the back button has "dismiss" affordance.</p>
 *
 * <p>Note that {@link android.view.KeyEvent#KEYCODE_BACK KeyEvent#KEYCODE_BACK} events continue to be sent to
 * {@link #onKeyDown(int,android.view.KeyEvent)} even when this mode is specified. The default
 * implementation of {@link #onKeyDown(int,android.view.KeyEvent)} for {@link android.view.KeyEvent#KEYCODE_BACK KeyEvent#KEYCODE_BACK} does
 * not take this mode into account.</p>
 *
 * <p>For API level {@link android.os.Build.VERSION_CODES#O_MR1} and lower devices, this is the
 * only mode you can safely specify without worrying about the compatibility.</p>
 *
 * @see #setBackDisposition(int)
 * @apiSince 11
 */

public static final int BACK_DISPOSITION_DEFAULT = 0; // 0x0

/**
 * Deprecated flag.
 *
 * <p>To avoid compatibility issues, IME developers should not use this flag.</p>
 *
 * @deprecated on {@link android.os.Build.VERSION_CODES#P} and later devices, this flag is
 *             handled as a synonym of {@link #BACK_DISPOSITION_DEFAULT}. On
 *             {@link android.os.Build.VERSION_CODES#O_MR1} and prior devices, expected behavior
 *             of this mode had not been well defined. In AOSP implementation running on devices
 *             that have navigation bar, specifying this flag could change the software back
 *             button to "Dismiss" icon no matter whether the software keyboard is shown or not,
 *             but there would be no easy way to restore the icon state even after IME lost the
 *             connection to the application. To avoid user confusions, do not specify this mode
 *             anyway
 * @see #setBackDisposition(int)
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated public static final int BACK_DISPOSITION_WILL_DISMISS = 2; // 0x2

/**
 * Deprecated flag.
 *
 * <p>To avoid compatibility issues, IME developers should not use this flag.</p>
 *
 * @deprecated on {@link android.os.Build.VERSION_CODES#P} and later devices, this flag is
 *             handled as a synonym of {@link #BACK_DISPOSITION_DEFAULT}. On
 *             {@link android.os.Build.VERSION_CODES#O_MR1} and prior devices, expected behavior
 *             of this mode had not been well defined. Most likely the end result would be the
 *             same as {@link #BACK_DISPOSITION_DEFAULT}. Either way it is not recommended to
 *             use this mode
 * @see #setBackDisposition(int)
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated public static final int BACK_DISPOSITION_WILL_NOT_DISMISS = 1; // 0x1
/**
 * Concrete implementation of
 * {@link android.inputmethodservice.AbstractInputMethodService.AbstractInputMethodImpl AbstractInputMethodService.AbstractInputMethodImpl} that provides
 * all of the standard behavior for an input method.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class InputMethodImpl extends android.inputmethodservice.AbstractInputMethodService.AbstractInputMethodImpl {

public InputMethodImpl() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * @apiSince 3
 */

public void attachToken(android.os.IBinder token) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>Calls {@link android.inputmethodservice.InputMethodService#onBindInput() InputMethodService#onBindInput()} when done.</p>
 
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * @apiSince 3
 */

public void bindInput(android.view.inputmethod.InputBinding binding) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>Calls {@link android.inputmethodservice.InputMethodService#onUnbindInput() InputMethodService#onUnbindInput()} when done.</p>
 
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * @apiSince 3
 */

public void unbindInput() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * @apiSince 3
 */

public void startInput(android.view.inputmethod.InputConnection ic, android.view.inputmethod.EditorInfo attribute) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * @apiSince 3
 */

public void restartInput(android.view.inputmethod.InputConnection ic, android.view.inputmethod.EditorInfo attribute) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * @apiSince 3
 */

public void hideSoftInput(int flags, android.os.ResultReceiver resultReceiver) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * @apiSince 3
 */

public void showSoftInput(int flags, android.os.ResultReceiver resultReceiver) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * @apiSince 11
 */

public void changeInputMethodSubtype(android.view.inputmethod.InputMethodSubtype subtype) { throw new RuntimeException("Stub!"); }
}

/**
 * Concrete implementation of
 * {@link android.inputmethodservice.AbstractInputMethodService.AbstractInputMethodSessionImpl AbstractInputMethodService.AbstractInputMethodSessionImpl} that provides
 * all of the standard behavior for an input method session.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class InputMethodSessionImpl extends android.inputmethodservice.AbstractInputMethodService.AbstractInputMethodSessionImpl {

public InputMethodSessionImpl() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void finishInput() { throw new RuntimeException("Stub!"); }

/**
 * Call {@link android.inputmethodservice.InputMethodService#onDisplayCompletions InputMethodService#onDisplayCompletions}.
 * @apiSince 3
 */

public void displayCompletions(android.view.inputmethod.CompletionInfo[] completions) { throw new RuntimeException("Stub!"); }

/**
 * Call {@link android.inputmethodservice.InputMethodService#onUpdateExtractedText InputMethodService#onUpdateExtractedText}.
 * @apiSince 3
 */

public void updateExtractedText(int token, android.view.inputmethod.ExtractedText text) { throw new RuntimeException("Stub!"); }

/**
 * Call {@link android.inputmethodservice.InputMethodService#onUpdateSelection InputMethodService#onUpdateSelection}.
 * @apiSince 3
 */

public void updateSelection(int oldSelStart, int oldSelEnd, int newSelStart, int newSelEnd, int candidatesStart, int candidatesEnd) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public void viewClicked(boolean focusChanged) { throw new RuntimeException("Stub!"); }

/**
 * Call {@link android.inputmethodservice.InputMethodService#onUpdateCursor InputMethodService#onUpdateCursor}.
 * @apiSince 3
 */

public void updateCursor(android.graphics.Rect newCursor) { throw new RuntimeException("Stub!"); }

/**
 * Call {@link android.inputmethodservice.InputMethodService#onAppPrivateCommand InputMethodService#onAppPrivateCommand}.
 * @apiSince 3
 */

public void appPrivateCommand(java.lang.String action, android.os.Bundle data) { throw new RuntimeException("Stub!"); }

/**
 *
 * @apiSince 3
 */

public void toggleSoftInput(int showFlags, int hideFlags) { throw new RuntimeException("Stub!"); }

/**
 * Call {@link android.inputmethodservice.InputMethodService#onUpdateCursorAnchorInfo InputMethodService#onUpdateCursorAnchorInfo}.
 * @apiSince 21
 */

public void updateCursorAnchorInfo(android.view.inputmethod.CursorAnchorInfo info) { throw new RuntimeException("Stub!"); }
}

/**
 * Information about where interesting parts of the input method UI appear.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Insets {

public Insets() { throw new RuntimeException("Stub!"); }

/**
 * Option for {@link #touchableInsets}: the area inside of
 * the content insets can be touched.
 * @apiSince 3
 */

public static final int TOUCHABLE_INSETS_CONTENT = 1; // 0x1

/**
 * Option for {@link #touchableInsets}: the entire window frame
 * can be touched.
 * @apiSince 3
 */

public static final int TOUCHABLE_INSETS_FRAME = 0; // 0x0

/**
 * Option for {@link #touchableInsets}: the region specified by
 * {@link #touchableRegion} can be touched.
 * @apiSince 11
 */

public static final int TOUCHABLE_INSETS_REGION = 3; // 0x3

/**
 * Option for {@link #touchableInsets}: the area inside of
 * the visible insets can be touched.
 * @apiSince 3
 */

public static final int TOUCHABLE_INSETS_VISIBLE = 2; // 0x2

/**
 * This is the top part of the UI that is the main content.  It is
 * used to determine the basic space needed, to resize/pan the
 * application behind.  It is assumed that this inset does not
 * change very much, since any change will cause a full resize/pan
 * of the application behind.  This value is relative to the top edge
 * of the input method window.
 * @apiSince 3
 */

public int contentTopInsets;

/**
 * Determine which area of the window is touchable by the user.  May
 * be one of: {@link #TOUCHABLE_INSETS_FRAME},
 * {@link #TOUCHABLE_INSETS_CONTENT}, {@link #TOUCHABLE_INSETS_VISIBLE},
 * or {@link #TOUCHABLE_INSETS_REGION}.
 * @apiSince 3
 */

public int touchableInsets;

/**
 * This is the region of the UI that is touchable.  It is used when
 * {@link #touchableInsets} is set to {@link #TOUCHABLE_INSETS_REGION}.
 * The region should be specified relative to the origin of the window frame.
 * @apiSince 11
 */

public final android.graphics.Region touchableRegion;
{ touchableRegion = null; }

/**
 * This is the top part of the UI that is visibly covering the
 * application behind it.  This provides finer-grained control over
 * visibility, allowing you to change it relatively frequently (such
 * as hiding or showing candidates) without disrupting the underlying
 * UI too much.  For example, this will never resize the application
 * UI, will only pan if needed to make the current focus visible, and
 * will not aggressively move the pan position when this changes unless
 * needed to make the focus visible.  This value is relative to the top edge
 * of the input method window.
 * @apiSince 3
 */

public int visibleTopInsets;
}

}

