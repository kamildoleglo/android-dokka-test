/*
 * Copyright (C) 2016 The Android Open Source Project
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


package android.service.autofill;

import android.app.Activity;
import android.content.IntentSender;

/**
 * Handles save requests from the {@link android.service.autofill.AutofillService AutofillService} into the {@link android.app.Activity Activity} being
 * autofilled.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SaveCallback {

SaveCallback() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the Android System that an
 * {@link android.service.autofill.AutofillService#onSaveRequest(android.service.autofill.SaveRequest,android.service.autofill.SaveCallback) AutofillService#onSaveRequest(SaveRequest, SaveCallback)} was successfully handled
 * by the service.
 *
 * @throws java.lang.IllegalStateException if this method, {@link #onSuccess(android.content.IntentSender)}, or
 * {@link #onFailure(java.lang.CharSequence)} was already called.
 * @apiSince 26
 */

public void onSuccess() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the Android System that an
 * {@link android.service.autofill.AutofillService#onSaveRequest(android.service.autofill.SaveRequest,android.service.autofill.SaveCallback) AutofillService#onSaveRequest(SaveRequest, SaveCallback)} was successfully handled
 * by the service.
 *
 * <p>This method is useful when the service requires extra work&mdash;for example, launching an
 * activity asking the user to authenticate first &mdash;before it can process the request,
 * as the intent will be launched from the context of the activity being autofilled and hence
 * will be part of that activity's stack.
 *
 * @param intentSender intent that will be launched from the context of activity being
 * autofilled.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if this method, {@link #onSuccess()},
 * or {@link #onFailure(java.lang.CharSequence)} was already called.
 * @apiSince 28
 */

public void onSuccess(@androidx.annotation.NonNull android.content.IntentSender intentSender) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the Android System that an
 * {@link android.service.autofill.AutofillService#onSaveRequest(android.service.autofill.SaveRequest,android.service.autofill.SaveCallback) AutofillService#onSaveRequest(SaveRequest, SaveCallback)} could not be handled
 * by the service.
 *
 * <p>This method is just used for logging purposes, the Android System won't call the service
 * again in case of failures&mdash;if you need to recover from the failure, just save the
 * {@link android.service.autofill.SaveRequest SaveRequest} and try again later.
 *
 * <p><b>Note: </b>for apps targeting {@link android.os.Build.VERSION_CODES#Q} or higher, this
 * method just logs the message on {@code logcat}; for apps targetting older SDKs, it also
 * displays the message to user using a {@link android.widget.Toast}.
 *
 * @param message error message. <b>Note: </b> this message should <b>not</b> contain PII
 * (Personally Identifiable Information, such as username or email address).
 *
 * @throws java.lang.IllegalStateException if this method, {@link #onSuccess()},
 * or {@link #onSuccess(android.content.IntentSender)} was already called.
 * @apiSince 26
 */

public void onFailure(java.lang.CharSequence message) { throw new RuntimeException("Stub!"); }
}

