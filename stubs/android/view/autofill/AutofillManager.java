/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.view.autofill;

import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.view.View;
import android.util.SparseArray;
import android.service.autofill.AutofillService;
import android.service.autofill.UserData;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

/**
 * <p>The {@link android.view.autofill.AutofillManager AutofillManager} class provides ways for apps and custom views to
 * integrate with the Autofill Framework lifecycle.
 *
 * <p>To learn about using Autofill in your app, read
 * the <a href="/guide/topics/text/autofill">Autofill Framework</a> guides.
 *
 * <h3 id="autofill-lifecycle">Autofill lifecycle</h3>
 *
 * <p>The autofill lifecycle starts with the creation of an autofill context associated with an
 * activity context. The autofill context is created when one of the following methods is called for
 * the first time in an activity context, and the current user has an enabled autofill service:
 *
 * <ul>
 *   <li>{@link #notifyViewEntered(android.view.View)}
 *   <li>{@link #notifyViewEntered(android.view.View,int,android.graphics.Rect)}
 *   <li>{@link #requestAutofill(android.view.View)}
 * </ul>
 *
 * <p>Typically, the context is automatically created when the first view of the activity is
 * focused because {@code View.onFocusChanged()} indirectly calls
 * {@link #notifyViewEntered(android.view.View)}. App developers can call {@link #requestAutofill(android.view.View)} to
 * explicitly create it (for example, a custom view developer could offer a contextual menu action
 * in a text-field view to let users manually request autofill).
 *
 * <p>After the context is created, the Android System creates a {@link android.view.ViewStructure}
 * that represents the view hierarchy by calling
 * {@link android.view.View#dispatchProvideAutofillStructure(android.view.ViewStructure,int) View#dispatchProvideAutofillStructure(android.view.ViewStructure, int)} in the root views
 * of all application windows. By default, {@code dispatchProvideAutofillStructure()} results in
 * subsequent calls to {@link android.view.View#onProvideAutofillStructure(android.view.ViewStructure,int) View#onProvideAutofillStructure(android.view.ViewStructure, int)} and
 * {@link android.view.View#onProvideAutofillVirtualStructure(android.view.ViewStructure,int) View#onProvideAutofillVirtualStructure(android.view.ViewStructure, int)} for each view in
 * the hierarchy.
 *
 * <p>The resulting {@link android.view.ViewStructure} is then passed to the autofill service, which
 * parses it looking for views that can be autofilled. If the service finds such views, it returns
 * a data structure to the Android System containing the following optional info:
 *
 * <ul>
 *   <li>Datasets used to autofill subsets of views in the activity.
 *   <li>Id of views that the service can save their values for future autofilling.
 * </ul>
 *
 * <p>When the service returns datasets, the Android System displays an autofill dataset picker
 * UI associated with the view, when the view is focused on and is part of a dataset.
 * The application can be notified when the UI is shown by registering an
 * {@link android.view.autofill.AutofillManager.AutofillCallback AutofillCallback} through {@link #registerCallback(android.view.autofill.AutofillManager.AutofillCallback)}. When the user
 * selects a dataset from the UI, all views present in the dataset are autofilled, through
 * calls to {@link android.view.View#autofill(android.view.autofill.AutofillValue) View#autofill(AutofillValue)} or {@link android.view.View#autofill(android.util.SparseArray) View#autofill(SparseArray)}.
 *
 * <p>When the service returns ids of savable views, the Android System keeps track of changes
 * made to these views, so they can be used to determine if the autofill save UI is shown later.
 *
 * <p>The context is then finished when one of the following occurs:
 *
 * <ul>
 *   <li>{@link #commit()} is called or all savable views are gone.
 *   <li>{@link #cancel()} is called.
 * </ul>
 *
 * <p>Finally, after the autofill context is commited (i.e., not cancelled), the Android System
 * shows an autofill save UI if the value of savable views have changed. If the user selects the
 * option to Save, the current value of the views is then sent to the autofill service.
 *
 * <h3 id="additional-notes">Additional notes</h3>
 *
 * <p>It is safe to call <code>AutofillManager</code> methods from any thread.
 
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_AUTOFILL PackageManager#FEATURE_AUTOFILL} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AutofillManager {

AutofillManager() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether autofill is enabled for the current user.
 *
 * <p>Typically used to determine whether the option to explicitly request autofill should
 * be offered - see {@link #requestAutofill(android.view.View)}.
 *
 * @return whether autofill is enabled for the current user.
 * @apiSince 26
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Explicitly requests a new autofill context.
 *
 * <p>Normally, the autofill context is automatically started if necessary when
 * {@link #notifyViewEntered(android.view.View)} is called, but this method should be used in the
 * cases where it must be explicitly started. For example, when the view offers an AUTOFILL
 * option on its contextual overflow menu, and the user selects it.
 *
 * @param view view requesting the new autofill context.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void requestAutofill(@androidx.annotation.NonNull android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Explicitly requests a new autofill context for virtual views.
 *
 * <p>Normally, the autofill context is automatically started if necessary when
 * {@link #notifyViewEntered(android.view.View,int,android.graphics.Rect)} is called, but this method should be used in the
 * cases where it must be explicitly started. For example, when the virtual view offers an
 * AUTOFILL option on its contextual overflow menu, and the user selects it.
 *
 * <p>The virtual view boundaries must be absolute screen coordinates. For example, if the
 * parent view uses {@code bounds} to draw the virtual view inside its Canvas,
 * the absolute bounds could be calculated by:
 *
 * <pre class="prettyprint">
 *   int offset[] = new int[2];
 *   getLocationOnScreen(offset);
 *   Rect absBounds = new Rect(bounds.left + offset[0],
 *       bounds.top + offset[1],
 *       bounds.right + offset[0], bounds.bottom + offset[1]);
 * </pre>
 *
 * @param view the virtual view parent.
 * This value must never be {@code null}.
 * @param virtualId id identifying the virtual child inside the parent view.
 * @param absBounds absolute boundaries of the virtual view in the screen.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void requestAutofill(@androidx.annotation.NonNull android.view.View view, int virtualId, @androidx.annotation.NonNull android.graphics.Rect absBounds) { throw new RuntimeException("Stub!"); }

/**
 * Called when a {@link android.view.View View} that supports autofill is entered.
 *
 * @param view {@link android.view.View View} that was entered.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void notifyViewEntered(@androidx.annotation.NonNull android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Called when a {@link android.view.View View} that supports autofill is exited.
 *
 * @param view {@link android.view.View View} that was exited.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void notifyViewExited(@androidx.annotation.NonNull android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Called when a {@link android.view.View View} visibility changed.
 *
 * @param view {@link android.view.View View} that was exited.
 * This value must never be {@code null}.
 * @param isVisible visible if the view is visible in the view hierarchy.
 * @apiSince 27
 */

public void notifyViewVisibilityChanged(@androidx.annotation.NonNull android.view.View view, boolean isVisible) { throw new RuntimeException("Stub!"); }

/**
 * Called when a virtual view's visibility changed.
 *
 * @param view {@link android.view.View View} that was exited.
 * This value must never be {@code null}.
 * @param virtualId id identifying the virtual child inside the parent view.
 * @param isVisible visible if the view is visible in the view hierarchy.
 * @apiSince 27
 */

public void notifyViewVisibilityChanged(@androidx.annotation.NonNull android.view.View view, int virtualId, boolean isVisible) { throw new RuntimeException("Stub!"); }

/**
 * Called when a virtual view that supports autofill is entered.
 *
 * <p>The virtual view boundaries must be absolute screen coordinates. For example, if the
 * parent, non-virtual view uses {@code bounds} to draw the virtual view inside its Canvas,
 * the absolute bounds could be calculated by:
 *
 * <pre class="prettyprint">
 *   int offset[] = new int[2];
 *   getLocationOnScreen(offset);
 *   Rect absBounds = new Rect(bounds.left + offset[0],
 *       bounds.top + offset[1],
 *       bounds.right + offset[0], bounds.bottom + offset[1]);
 * </pre>
 *
 * @param view the virtual view parent.
 * This value must never be {@code null}.
 * @param virtualId id identifying the virtual child inside the parent view.
 * @param absBounds absolute boundaries of the virtual view in the screen.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void notifyViewEntered(@androidx.annotation.NonNull android.view.View view, int virtualId, @androidx.annotation.NonNull android.graphics.Rect absBounds) { throw new RuntimeException("Stub!"); }

/**
 * Called when a virtual view that supports autofill is exited.
 *
 * @param view the virtual view parent.
 * This value must never be {@code null}.
 * @param virtualId id identifying the virtual child inside the parent view.
 * @apiSince 26
 */

public void notifyViewExited(@androidx.annotation.NonNull android.view.View view, int virtualId) { throw new RuntimeException("Stub!"); }

/**
 * Called to indicate the value of an autofillable {@link android.view.View View} changed.
 *
 * @param view view whose value changed.
 * @apiSince 26
 */

public void notifyValueChanged(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Called to indicate the value of an autofillable virtual view has changed.
 *
 * @param view the virtual view parent.
 * @param virtualId id identifying the virtual child inside the parent view.
 * @param value new value of the child.
 * @apiSince 26
 */

public void notifyValueChanged(android.view.View view, int virtualId, android.view.autofill.AutofillValue value) { throw new RuntimeException("Stub!"); }

/**
 * Called to indicate a {@link android.view.View View} is clicked.
 *
 * @param view view that has been clicked.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void notifyViewClicked(@androidx.annotation.NonNull android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Called to indicate a virtual view has been clicked.
 *
 * @param view the virtual view parent.
 * This value must never be {@code null}.
 * @param virtualId id identifying the virtual child inside the parent view.
 * @apiSince 28
 */

public void notifyViewClicked(@androidx.annotation.NonNull android.view.View view, int virtualId) { throw new RuntimeException("Stub!"); }

/**
 * Called to indicate the current autofill context should be commited.
 *
 * <p>This method is typically called by {@link android.view.View View} that manage virtual views; for
 * example, when the view is rendering an {@code HTML} page with a form and virtual views
 * that represent the HTML elements, it should call this method after the form is submitted and
 * another page is rendered.
 *
 * <p><b>Note:</b> This method does not need to be called on regular application lifecycle
 * methods such as {@link android.app.Activity#finish()}.
 * @apiSince 26
 */

public void commit() { throw new RuntimeException("Stub!"); }

/**
 * Called to indicate the current autofill context should be cancelled.
 *
 * <p>This method is typically called by {@link android.view.View View} that manage virtual views; for
 * example, when the view is rendering an {@code HTML} page with a form and virtual views
 * that represent the HTML elements, it should call this method if the user does not post the
 * form but moves to another form in this page.
 *
 * <p><b>Note:</b> This method does not need to be called on regular application lifecycle
 * methods such as {@link android.app.Activity#finish()}.
 * @apiSince 26
 */

public void cancel() { throw new RuntimeException("Stub!"); }

/**
 * If the app calling this API has enabled autofill services they
 * will be disabled.
 * @apiSince 26
 */

public void disableAutofillServices() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the calling application provides a {@link android.service.autofill.AutofillService AutofillService} that is
 * enabled for the current user, or {@code false} otherwise.
 * @apiSince 26
 */

public boolean hasEnabledAutofillServices() { throw new RuntimeException("Stub!"); }

/**
 * Returns the component name of the {@link android.service.autofill.AutofillService AutofillService} that is enabled for the current
 * user.
 
 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.content.ComponentName getAutofillServiceComponentName() { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of the {@link android.service.autofill.UserData UserData} used for
 * <a href="AutofillService.html#FieldClassification">field classification</a>.
 *
 * <p>This method is useful when the service must check the status of the {@link android.service.autofill.UserData UserData} in
 * the device without fetching the whole object.
 *
 * <p><b>Note:</b> This method should only be called by an app providing an autofill service,
 * and it's ignored if the caller currently doesn't have an enabled autofill service for
 * the user.
 *
 * @return id of the {@link android.service.autofill.UserData UserData} previously set by {@link #setUserData(android.service.autofill.UserData)}
 * or {@code null} if it was reset or if the caller currently does not have an enabled autofill
 * service for the user.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getUserDataId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the user data used for
 * <a href="AutofillService.html#FieldClassification">field classification</a>.
 *
 * <p><b>Note:</b> This method should only be called by an app providing an autofill service,
 * and it's ignored if the caller currently doesn't have an enabled autofill service for
 * the user.
 *
 * @return value previously set by {@link #setUserData(android.service.autofill.UserData)} or {@code null} if it was
 * reset or if the caller currently does not have an enabled autofill service for the user.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.service.autofill.UserData getUserData() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.service.autofill.UserData UserData} used for
 * <a href="AutofillService.html#FieldClassification">field classification</a>
 *
 * <p><b>Note:</b> This method should only be called by an app providing an autofill service,
 * and it's ignored if the caller currently doesn't have an enabled autofill service for
 * the user.
 
 * @param userData This value may be {@code null}.
 * @apiSince 28
 */

public void setUserData(@androidx.annotation.Nullable android.service.autofill.UserData userData) { throw new RuntimeException("Stub!"); }

/**
 * Checks if <a href="AutofillService.html#FieldClassification">field classification</a> is
 * enabled.
 *
 * <p>As field classification is an expensive operation, it could be disabled, either
 * temporarily (for example, because the service exceeded a rate-limit threshold) or
 * permanently (for example, because the device is a low-level device).
 *
 * <p><b>Note:</b> This method should only be called by an app providing an autofill service,
 * and it's ignored if the caller currently doesn't have an enabled autofill service for
 * the user.
 * @apiSince 28
 */

public boolean isFieldClassificationEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of the default algorithm used for
 * <a href="AutofillService.html#FieldClassification">field classification</a>.
 *
 * <p>The default algorithm is used when the algorithm on {@link android.service.autofill.UserData UserData} is invalid or not
 * set.
 *
 * <p><b>Note:</b> This method should only be called by an app providing an autofill service,
 * and it's ignored if the caller currently doesn't have an enabled autofill service for
 * the user.
 
 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getDefaultFieldClassificationAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of all algorithms currently available for
 * <a href="AutofillService.html#FieldClassification">field classification</a>.
 *
 * <p><b>Note:</b> This method should only be called by an app providing an autofill service,
 * and it returns an empty list if the caller currently doesn't have an enabled autofill service
 * for the user.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.String> getAvailableFieldClassificationAlgorithms() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if autofill is supported by the current device and
 * is supported for this user.
 *
 * <p>Autofill is typically supported, but it could be unsupported in cases like:
 * <ol>
 *     <li>Low-end devices.
 *     <li>Device policy rules that forbid its usage.
 * </ol>
 * @apiSince 26
 */

public boolean isAutofillSupported() { throw new RuntimeException("Stub!"); }

/**
 * Gets the next unique autofill ID for the activity context.
 *
 * <p>Typically used to manage views whose content is recycled - see
 * {@link android.view.View#setAutofillId(android.view.autofill.AutofillId) View#setAutofillId(AutofillId)} for more info.
 *
 * @return An ID that is unique in the activity, or {@code null} if autofill is not supported in
 * the {@link android.content.Context Context} associated with this {@link android.view.autofill.AutofillManager AutofillManager}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.view.autofill.AutofillId getNextAutofillId() { throw new RuntimeException("Stub!"); }

/**
 * Registers a {@link android.view.autofill.AutofillManager.AutofillCallback AutofillCallback} to receive autofill events.
 *
 * @param callback callback to receive events.
 
 * This value may be {@code null}.
 * @apiSince 26
 */

public void registerCallback(@androidx.annotation.Nullable android.view.autofill.AutofillManager.AutofillCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a {@link android.view.autofill.AutofillManager.AutofillCallback AutofillCallback} to receive autofill events.
 *
 * @param callback callback to stop receiving events.
 
 * This value may be {@code null}.
 * @apiSince 26
 */

public void unregisterCallback(@androidx.annotation.Nullable android.view.autofill.AutofillManager.AutofillCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Intent extra: The assist structure which captures the filled screen.
 *
 * <p>
 * Type: {@link android.app.assist.AssistStructure}
 * @apiSince 26
 */

public static final java.lang.String EXTRA_ASSIST_STRUCTURE = "android.view.autofill.extra.ASSIST_STRUCTURE";

/**
 * Intent extra: The result of an authentication operation. It is
 * either a fully populated {@link android.service.autofill.FillResponse}
 * or a fully populated {@link android.service.autofill.Dataset} if
 * a response or a dataset is being authenticated respectively.
 *
 * <p>
 * Type: {@link android.service.autofill.FillResponse} or a
 * {@link android.service.autofill.Dataset}
 * @apiSince 26
 */

public static final java.lang.String EXTRA_AUTHENTICATION_RESULT = "android.view.autofill.extra.AUTHENTICATION_RESULT";

/**
 * Intent extra: The optional extras provided by the
 * {@link android.service.autofill.AutofillService}.
 *
 * <p>For example, when the service responds to a {@link
 * android.service.autofill.FillCallback#onSuccess(android.service.autofill.FillResponse)} with
 * a {@code FillResponse} that requires authentication, the Intent that launches the
 * service authentication will contain the Bundle set by
 * {@link android.service.autofill.FillResponse.Builder#setClientState(Bundle)} on this extra.
 *
 * <p>On Android {@link android.os.Build.VERSION_CODES#P} and higher, the autofill service
 * can also add this bundle to the {@link android.content.Intent Intent} set as the
 * {@link android.app.Activity#setResult(int, Intent) result} for an authentication request,
 * so the bundle can be recovered later on
 * {@link android.service.autofill.SaveRequest#getClientState()}.
 *
 * <p>
 * Type: {@link android.os.Bundle}
 * @apiSince 26
 */

public static final java.lang.String EXTRA_CLIENT_STATE = "android.view.autofill.extra.CLIENT_STATE";
/**
 * Callback for autofill related events.
 *
 * <p>Typically used for applications that display their own "auto-complete" views, so they can
 * enable / disable such views when the autofill UI is shown / hidden.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class AutofillCallback {

public AutofillCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called after a change in the autofill state associated with a view.
 *
 * @param view view associated with the change.
 *
 * This value must never be {@code null}.
 * @param event currently either {@link #EVENT_INPUT_SHOWN} or {@link #EVENT_INPUT_HIDDEN}.
 
 * Value is {@link android.view.autofill.AutofillManager.AutofillCallback#EVENT_INPUT_SHOWN}, {@link android.view.autofill.AutofillManager.AutofillCallback#EVENT_INPUT_HIDDEN}, or {@link android.view.autofill.AutofillManager.AutofillCallback#EVENT_INPUT_UNAVAILABLE}
 * @apiSince 26
 */

public void onAutofillEvent(@androidx.annotation.NonNull android.view.View view, int event) { throw new RuntimeException("Stub!"); }

/**
 * Called after a change in the autofill state associated with a virtual view.
 *
 * @param view parent view associated with the change.
 * This value must never be {@code null}.
 * @param virtualId id identifying the virtual child inside the parent view.
 *
 * @param event currently either {@link #EVENT_INPUT_SHOWN} or {@link #EVENT_INPUT_HIDDEN}.
 
 * Value is {@link android.view.autofill.AutofillManager.AutofillCallback#EVENT_INPUT_SHOWN}, {@link android.view.autofill.AutofillManager.AutofillCallback#EVENT_INPUT_HIDDEN}, or {@link android.view.autofill.AutofillManager.AutofillCallback#EVENT_INPUT_UNAVAILABLE}
 * @apiSince 26
 */

public void onAutofillEvent(@androidx.annotation.NonNull android.view.View view, int virtualId, int event) { throw new RuntimeException("Stub!"); }

/**
 * The autofill input UI associated with the view was hidden.
 *
 * <p>If the view provides its own auto-complete UI that was hidden upon a
 * {@link #EVENT_INPUT_SHOWN} event, it could be shown again now.
 * @apiSince 26
 */

public static final int EVENT_INPUT_HIDDEN = 2; // 0x2

/**
 * The autofill input UI associated with the view was shown.
 *
 * <p>If the view provides its own auto-complete UI and its currently shown, it
 * should be hidden upon receiving this event.
 * @apiSince 26
 */

public static final int EVENT_INPUT_SHOWN = 1; // 0x1

/**
 * The autofill input UI associated with the view isn't shown because
 * autofill is not available.
 *
 * <p>If the view provides its own auto-complete UI but was not displaying it
 * to avoid flickering, it could shown it upon receiving this event.
 * @apiSince 26
 */

public static final int EVENT_INPUT_UNAVAILABLE = 3; // 0x3
}

}

