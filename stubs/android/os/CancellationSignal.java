/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.os;


/**
 * Provides the ability to cancel an operation in progress.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CancellationSignal {

/**
 * Creates a cancellation signal, initially not canceled.
 * @apiSince 16
 */

public CancellationSignal() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the operation has been canceled.
 *
 * @return True if the operation has been canceled.
 * @apiSince 16
 */

public boolean isCanceled() { throw new RuntimeException("Stub!"); }

/**
 * Throws {@link android.os.OperationCanceledException OperationCanceledException} if the operation has been canceled.
 *
 * @throws android.os.OperationCanceledException if the operation has been canceled.
 * @apiSince 16
 */

public void throwIfCanceled() { throw new RuntimeException("Stub!"); }

/**
 * Cancels the operation and signals the cancellation listener.
 * If the operation has not yet started, then it will be canceled as soon as it does.
 * @apiSince 16
 */

public void cancel() { throw new RuntimeException("Stub!"); }

/**
 * Sets the cancellation listener to be called when canceled.
 *
 * This method is intended to be used by the recipient of a cancellation signal
 * such as a database or a content provider to handle cancellation requests
 * while performing a long-running operation.  This method is not intended to be
 * used by applications themselves.
 *
 * If {@link android.os.CancellationSignal#cancel CancellationSignal#cancel} has already been called, then the provided
 * listener is invoked immediately.
 *
 * This method is guaranteed that the listener will not be called after it
 * has been removed.
 *
 * @param listener The cancellation listener, or null to remove the current listener.
 * @apiSince 16
 */

public void setOnCancelListener(android.os.CancellationSignal.OnCancelListener listener) { throw new RuntimeException("Stub!"); }
/**
 * Listens for cancellation.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnCancelListener {

/**
 * Called when {@link android.os.CancellationSignal#cancel CancellationSignal#cancel} is invoked.
 * @apiSince 16
 */

public void onCancel();
}

}

