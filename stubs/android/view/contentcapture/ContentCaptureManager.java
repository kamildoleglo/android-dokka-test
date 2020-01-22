/*
 * Copyright (C) 2018 The Android Open Source Project
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

package android.view.contentcapture;

import android.view.ViewStructure;
import android.view.View;

/**
 * Content capture is mechanism used to let apps notify the Android system of events associated with
 * views.
 *
 * <p>Before using this manager, you should check if it's available. Example:
 * <pre><code>
 *  ContentCaptureManager mgr = context.getSystemService(ContentCaptureManager.class);
 *  if (mgr != null && mgr.isContentCaptureEnabled()) {
 *    // ...
 *  }
 *  </code></pre>
 *
 * <p>To support content capture, you must notifiy the Android system of the following events:
 *
 * <ul>
 *   <li>When a visible view is laid out, call
 *   {@link android.view.contentcapture.ContentCaptureSession#notifyViewAppeared(android.view.ViewStructure) ContentCaptureSession#notifyViewAppeared(ViewStructure)}.
 *   <li>When a view becomes invisible or is removed from the view hierarchy, call
 *   {@link android.view.contentcapture.ContentCaptureSession#notifyViewDisappeared(android.view.autofill.AutofillId) ContentCaptureSession#notifyViewDisappeared(android.view.autofill.AutofillId)}.
 *   <li>When the view represents text and the text value changed, call {@link android.view.contentcapture.ContentCaptureSession#notifyViewTextChanged(android.view.autofill.AutofillId,java.lang.CharSequence) ContentCaptureSession#notifyViewTextChanged(android.view.autofill.AutofillId, CharSequence)}.
 * </ul>
 *
 * <p>You can get a blank content capture structure using
 * {@link android.view.contentcapture.ContentCaptureSession#newViewStructure(android.view.View) ContentCaptureSession#newViewStructure(View)}, then populate its relevant fields.
 * Here's an example of the relevant methods for an {@code EditText}-like view:
 *
 * <pre><code>
 * public class MyEditText extends View {
 *
 * private void populateContentCaptureStructure(@NonNull ViewStructure structure) {
 *   structure.setText(getText(), getSelectionStart(), getSelectionEnd());
 *   structure.setHint(getHint());
 *   structure.setInputType(getInputType());
 *   // set other properties like setTextIdEntry(), setTextLines(), setTextStyle(),
 *   // setMinTextEms(), setMaxTextEms(), setMaxTextLength()
 * }
 *
 * private void onTextChanged() {
 *   if (isLaidOut() && isTextEditable()) {
 *     ContentCaptureManager mgr = mContext.getSystemService(ContentCaptureManager.class);
 *     if (cm != null && cm.isContentCaptureEnabled()) {
 *        ContentCaptureSession session = getContentCaptureSession();
 *        if (session != null) {
 *          session.notifyViewTextChanged(getAutofillId(), getText());
 *        }
 *   }
 * }
 * </code></pre>
 *
 * <p>The main integration point with content capture is the {@link android.view.contentcapture.ContentCaptureSession ContentCaptureSession}. A "main"
 * session is automatically created by the Android system when content capture is enabled for the
 * activity. The session could have a {@link android.view.contentcapture.ContentCaptureContext ContentCaptureContext} to provide more contextual info
 * about it, such as the locus associated with the view hierarchy
 * (see {@link android.content.LocusId} for more info about locus). By default, the main session
 * doesn't have a {@code ContentCaptureContext}, but you can change it after its created. Example:
 *
 * <pre><code>
 * protected void onCreate(Bundle savedInstanceState) {
 *   // Initialize view structure
 *   ContentCaptureSession session = rootView.getContentCaptureSession();
 *   if (session != null) {
 *     session.setContentCaptureContext(ContentCaptureContext.forLocusId("chat_UserA_UserB"));
 *   }
 * }
 * </code></pre>
 *
 * <p>If your activity contains view hierarchies with a different contextual meaning, you should
 * created child sessions for each view hierarchy root. For example, if your activity is a browser,
 * you could use the main session for the main URL being rendered, then child sessions for each
 * {@code IFRAME}:
 *
 * <pre><code>
 * ContentCaptureSession mMainSession;
 *
 * protected void onCreate(Bundle savedInstanceState) {
 *    // Initialize view structure...
 *    mMainSession = rootView.getContentCaptureSession();
 *    if (mMainSession != null) {
 *      mMainSession.setContentCaptureContext(
 *          ContentCaptureContext.forLocusId("https://example.com"));
 *    }
 * }
 *
 * private void loadIFrame(View iframeRootView, String url) {
 *   if (mMainSession != null) {
 *      ContentCaptureSession iFrameSession = mMainSession.newChild(
 *          ContentCaptureContext.forLocusId(url));
 *      }
 *      iframeRootView.setContentCaptureSession(iFrameSession);
 *   }
 *   // Load iframe...
 * }
 * </code></pre>
 *
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ContentCaptureManager {

ContentCaptureManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns the component name of the system service that is consuming the captured events for
 * the current user.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.content.ComponentName getServiceComponentName() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether content capture is enabled for this activity.
 * @apiSince 29
 */

public boolean isContentCaptureEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Gets the list of conditions for when content capture should be allowed.
 *
 * <p>This method is typically used by web browsers so they don't generate unnecessary content
 * capture events for some websites.
 *
 * @return list of conditions, or {@code null} if there isn't any restriction
 * (in which case content capture events should always be generated). If the list is empty,
 * then it should not generate any event at all.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.util.Set<android.view.contentcapture.ContentCaptureCondition> getContentCaptureConditions() { throw new RuntimeException("Stub!"); }

/**
 * Called by apps to explicitly enable or disable content capture.
 *
 * <p><b>Note: </b> this call is not persisted accross reboots, so apps should typically call
 * it on {@link android.app.Activity#onCreate(android.os.Bundle, android.os.PersistableBundle)}.
 * @apiSince 29
 */

public void setContentCaptureEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Called by the app to remove content capture data associated with some context.
 *
 * @param request object specifying what data should be removed.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void removeData(@androidx.annotation.NonNull android.view.contentcapture.DataRemovalRequest request) { throw new RuntimeException("Stub!"); }
}

