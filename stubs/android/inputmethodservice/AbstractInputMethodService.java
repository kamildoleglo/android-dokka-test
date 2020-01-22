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

import android.view.inputmethod.InputMethod;
import android.app.Service;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodSession;
import android.view.MotionEvent;

/**
 * AbstractInputMethodService provides a abstract base class for input methods.
 * Normal input method implementations will not derive from this directly,
 * instead building on top of {@link android.inputmethodservice.InputMethodService InputMethodService} or another more
 * complete base class.  Be sure to read {@link android.view.inputmethod.InputMethod InputMethod} for more
 * information on the basics of writing input methods.
 *
 * <p>This class combines a Service (representing the input method component
 * to the system with the InputMethod interface that input methods must
 * implement.  This base class takes care of reporting your InputMethod from
 * the service when clients bind to it, but provides no standard implementation
 * of the InputMethod interface itself.  Derived classes must implement that
 * interface.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbstractInputMethodService extends android.app.Service implements android.view.KeyEvent.Callback {

public AbstractInputMethodService() { throw new RuntimeException("Stub!"); }

/**
 * Return the global {@link android.view.KeyEvent.DispatcherState KeyEvent.DispatcherState}
 * for used for processing events from the target application.
 * Normally you will not need to use this directly, but
 * just use the standard high-level event callbacks like {@link #onKeyDown}.
 * @apiSince 5
 */

public android.view.KeyEvent.DispatcherState getKeyDispatcherState() { throw new RuntimeException("Stub!"); }

/**
 * Called by the framework during initialization, when the InputMethod
 * interface for this service needs to be created.
 * @apiSince 3
 */

public abstract android.inputmethodservice.AbstractInputMethodService.AbstractInputMethodImpl onCreateInputMethodInterface();

/**
 * Called by the framework when a new InputMethodSession interface is
 * needed for a new client of the input method.
 * @apiSince 3
 */

public abstract android.inputmethodservice.AbstractInputMethodService.AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface();

/**
 * Implement this to handle {@link android.os.Binder#dump Binder.dump()}
 * calls on your input method.
 * @apiSince 3
 */

protected void dump(java.io.FileDescriptor fd, java.io.PrintWriter fout, java.lang.String[] args) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public final android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Implement this to handle trackball events on your input method.
 *
 * @param event The motion event being received.
 * @return True if the event was handled in this function, false otherwise.
 * @see android.view.View#onTrackballEvent(MotionEvent)
 * @apiSince 3
 */

public boolean onTrackballEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Implement this to handle generic motion events on your input method.
 *
 * @param event The motion event being received.
 * @return True if the event was handled in this function, false otherwise.
 * @see android.view.View#onGenericMotionEvent(MotionEvent)
 * @apiSince 17
 */

public boolean onGenericMotionEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }
/**
 * Base class for derived classes to implement their {@link android.view.inputmethod.InputMethod InputMethod}
 * interface.  This takes care of basic maintenance of the input method,
 * but most behavior must be implemented in a derived class.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbstractInputMethodImpl implements android.view.inputmethod.InputMethod {

public AbstractInputMethodImpl() { throw new RuntimeException("Stub!"); }

/**
 * Instantiate a new client session for the input method, by calling
 * back to {@link android.inputmethodservice.AbstractInputMethodService#onCreateInputMethodSessionInterface() AbstractInputMethodService#onCreateInputMethodSessionInterface()}.
 
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * @apiSince 3
 */

public void createSession(android.view.inputmethod.InputMethod.SessionCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Take care of enabling or disabling an existing session by calling its
 * {@link android.inputmethodservice.AbstractInputMethodService.AbstractInputMethodSessionImpl#revokeSelf() AbstractInputMethodSessionImpl#revokeSelf()} method.
 
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * @apiSince 3
 */

public void setSessionEnabled(android.view.inputmethod.InputMethodSession session, boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Take care of killing an existing session by calling its
 * {@link android.inputmethodservice.AbstractInputMethodService.AbstractInputMethodSessionImpl#revokeSelf() AbstractInputMethodSessionImpl#revokeSelf()} method.
 
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * @apiSince 3
 */

public void revokeSession(android.view.inputmethod.InputMethodSession session) { throw new RuntimeException("Stub!"); }
}

/**
 * Base class for derived classes to implement their {@link android.view.inputmethod.InputMethodSession InputMethodSession}
 * interface.  This takes care of basic maintenance of the session,
 * but most behavior must be implemented in a derived class.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbstractInputMethodSessionImpl implements android.view.inputmethod.InputMethodSession {

public AbstractInputMethodSessionImpl() { throw new RuntimeException("Stub!"); }

/**
 * Check whether this session has been enabled by the system.  If not
 * enabled, you should not execute any calls on to it.
 * @apiSince 3
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Check whether this session has been revoked by the system.  Revoked
 * session is also always disabled, so there is generally no need to
 * explicitly check for this.
 * @apiSince 3
 */

public boolean isRevoked() { throw new RuntimeException("Stub!"); }

/**
 * Change the enabled state of the session.  This only works if the
 * session has not been revoked.
 * @apiSince 3
 */

public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Revoke the session from the client.  This disabled the session, and
 * prevents it from ever being enabled again.
 * @apiSince 3
 */

public void revokeSelf() { throw new RuntimeException("Stub!"); }

/**
 * Take care of dispatching incoming key events to the appropriate
 * callbacks on the service, and tell the client when this is done.
 * @apiSince 3
 */

public void dispatchKeyEvent(int seq, android.view.KeyEvent event, android.view.inputmethod.InputMethodSession.EventCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Take care of dispatching incoming trackball events to the appropriate
 * callbacks on the service, and tell the client when this is done.
 * @apiSince 3
 */

public void dispatchTrackballEvent(int seq, android.view.MotionEvent event, android.view.inputmethod.InputMethodSession.EventCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Take care of dispatching incoming generic motion events to the appropriate
 * callbacks on the service, and tell the client when this is done.
 * @apiSince 17
 */

public void dispatchGenericMotionEvent(int seq, android.view.MotionEvent event, android.view.inputmethod.InputMethodSession.EventCallback callback) { throw new RuntimeException("Stub!"); }
}

}

