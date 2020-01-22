/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.print;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.CancellationSignal;

/**
 * Base class that provides the content of a document to be printed.
 *
 * <h3>Lifecycle</h3>
 * <p>
 * <ul>
 * <li>
 * Initially, you will receive a call to {@link #onStart()}. This callback
 * can be used to allocate resources.
 * </li>
 * <li>
 * Next, you will get one or more calls to {@link #onLayout(android.print.PrintAttributes,android.print.PrintAttributes,android.os.CancellationSignal,android.print.PrintDocumentAdapter.LayoutResultCallback,android.os.Bundle)} to
 * inform you that the print attributes (page size, density, etc) changed
 * giving you an opportunity to layout the content to match the new constraints.
 * </li>
 * <li>
 * After every call to {@link #onLayout(android.print.PrintAttributes,android.print.PrintAttributes,android.os.CancellationSignal,android.print.PrintDocumentAdapter.LayoutResultCallback,android.os.Bundle)}, you <strong>may</strong> get
 * a call to {@link #onWrite(android.print.PageRange[],android.os.ParcelFileDescriptor,android.os.CancellationSignal,android.print.PrintDocumentAdapter.WriteResultCallback)} asking you to write a PDF file with the content for
 * specific pages.
 * </li>
 * <li>
 * Finally, you will receive a call to {@link #onFinish()}. You can use this
 * callback to release resources allocated in {@link #onStart()}.
 * </li>
 * </ul>
 * <p>
 * The {@link #onStart()} callback is always the first call you will receive and
 * is useful for doing one time setup or resource allocation before printing. You
 * will not receive a subsequent call here.
 * </p>
 * <p>
 * The {@link #onLayout(android.print.PrintAttributes,android.print.PrintAttributes,android.os.CancellationSignal,android.print.PrintDocumentAdapter.LayoutResultCallback,android.os.Bundle)} callback requires that you layout the content
 * based on the current {@link android.print.PrintAttributes PrintAttributes}. The execution of this method is
 * not considered completed until you invoke one of the methods on the passed in
 * callback instance. Hence, you will not receive a subsequent call to any other
 * method of this class until the execution of this method is complete by invoking
 * one of the callback methods.
 * </p>
 * <p>
 * The {@link #onWrite(android.print.PageRange[],android.os.ParcelFileDescriptor,android.os.CancellationSignal,android.print.PrintDocumentAdapter.WriteResultCallback)} requires that you render and write the content of some
 * pages to the provided destination. The execution of this method is not
 * considered complete until you invoke one of the methods on the passed in
 * callback instance. Hence, you will not receive a subsequent call to any other
 * method of this class until the execution of this method is complete by invoking
 * one of the callback methods. You will never receive a sequence of one or more
 * calls to this method without a previous call to {@link #onLayout(android.print.PrintAttributes,android.print.PrintAttributes,android.os.CancellationSignal,android.print.PrintDocumentAdapter.LayoutResultCallback,android.os.Bundle)}.
 * </p>
 * <p>
 * The {@link #onFinish()} callback is always the last call you will receive and
 * is useful for doing one time cleanup or resource deallocation after printing.
 * You will not receive a subsequent call here.
 * </p>
 * </p>
 * <h3>Implementation</h3>
 * <p>
 * The APIs defined in this class are designed to enable doing part or all
 * of the work on an arbitrary thread. For example, if the printed content
 * does not depend on the UI state, i.e. on what is shown on the screen, then
 * you can offload the entire work on a dedicated thread, thus making your
 * application interactive while the print work is being performed. Note that
 * while your activity is covered by the system print UI and a user cannot
 * interact with it, doing the printing work on the main application thread
 * may affect the performance of your other application components as they
 * are also executed on that thread.
 * </p>
 * <p>
 * You can also do work on different threads, for example if you print UI
 * content, you can handle {@link #onStart()} and {@link #onLayout(android.print.PrintAttributes,android.print.PrintAttributes,android.os.CancellationSignal,android.print.PrintDocumentAdapter.LayoutResultCallback,android.os.Bundle)} on
 * the UI thread (assuming onStart initializes resources needed for layout).
 * This will ensure that the UI does not change while you are laying out the
 * printed content. Then you can handle {@link #onWrite(android.print.PageRange[],android.os.ParcelFileDescriptor,android.os.CancellationSignal,android.print.PrintDocumentAdapter.WriteResultCallback)} and {@link #onFinish()} on another
 * thread. This will ensure that the main thread is busy for a minimal amount of
 * time. Also this assumes that you will generate the printed content in
 * {@link #onLayout(android.print.PrintAttributes,android.print.PrintAttributes,android.os.CancellationSignal,android.print.PrintDocumentAdapter.LayoutResultCallback,android.os.Bundle)} which is not mandatory. If you use multiple
 * threads, you are responsible for proper synchronization.
 * </p>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class PrintDocumentAdapter {

public PrintDocumentAdapter() { throw new RuntimeException("Stub!"); }

/**
 * Called when printing starts. You can use this callback to allocate
 * resources. This method is invoked on the main thread.
 * @apiSince 19
 */

public void onStart() { throw new RuntimeException("Stub!"); }

/**
 * Called when the print attributes (page size, density, etc) changed
 * giving you a chance to layout the content such that it matches the
 * new constraints. This method is invoked on the main thread.
 * <p>
 * After you are done laying out, you <strong>must</strong> invoke: {@link android.print.PrintDocumentAdapter.LayoutResultCallback#onLayoutFinished(android.print.PrintDocumentInfo,boolean) LayoutResultCallback#onLayoutFinished(PrintDocumentInfo, boolean)} with
 * the last argument <code>true</code> or <code>false</code> depending on
 * whether the layout changed the content or not, respectively; or {@link android.print.PrintDocumentAdapter.LayoutResultCallback#onLayoutFailed(java.lang.CharSequence) LayoutResultCallback#onLayoutFailed(CharSequence)}, if an error occurred;
 * or {@link android.print.PrintDocumentAdapter.LayoutResultCallback#onLayoutCancelled() LayoutResultCallback#onLayoutCancelled()} if layout was
 * cancelled in a response to a cancellation request via the passed in
 * {@link android.os.CancellationSignal CancellationSignal}. Note that you <strong>must</strong> call one of
 * the methods of the given callback for this method to be considered complete
 * which is you will not receive any calls to this adapter until the current
 * layout operation is complete by invoking a method on the callback instance.
 * The callback methods can be invoked from an arbitrary thread.
 * </p>
 * <p>
 * One of the arguments passed to this method is a {@link android.os.CancellationSignal CancellationSignal}
 * which is used to propagate requests from the system to your application for
 * canceling the current layout operation. For example, a cancellation may be
 * requested if the user changes a print option that may affect layout while
 * you are performing a layout operation. In such a case the system will make
 * an attempt to cancel the current layout as another one will have to be performed.
 * Typically, you should register a cancellation callback in the cancellation
 * signal. The cancellation callback <strong>will not</strong> be made on the
 * main thread and can be registered as follows:
 * </p>
 * <pre>
 * cancellationSignal.setOnCancelListener(new OnCancelListener() {
 *     &#064;Override
 *     public void onCancel() {
 *         // Cancel layout
 *     }
 * });
 * </pre>
 * <p>
 * <strong>Note:</strong> If the content is large and a layout will be
 * performed, it is a good practice to schedule the work on a dedicated
 * thread and register an observer in the provided {@link android.os.CancellationSignal CancellationSignal} upon invocation of which you should stop the
 * layout.
 * </p>
 *
 * @param oldAttributes The old print attributes.
 * @param newAttributes The new print attributes.
 * @param cancellationSignal Signal for observing cancel layout requests.
 * @param callback Callback to inform the system for the layout result.
 * @param extras Additional information about how to layout the content.
 *
 * @see android.print.PrintDocumentAdapter.LayoutResultCallback
 * @see android.os.CancellationSignal
 * @see #EXTRA_PRINT_PREVIEW
 * @apiSince 19
 */

public abstract void onLayout(android.print.PrintAttributes oldAttributes, android.print.PrintAttributes newAttributes, android.os.CancellationSignal cancellationSignal, android.print.PrintDocumentAdapter.LayoutResultCallback callback, android.os.Bundle extras);

/**
 * Called when specific pages of the content should be written in the
 * form of a PDF file to the given file descriptor. This method is invoked
 * on the main thread.
 *<p>
 * After you are done writing, you should close the file descriptor and
 * invoke {@link android.print.PrintDocumentAdapter.WriteResultCallback#onWriteFinished(android.print.PageRange[]) WriteResultCallback#onWriteFinished(PageRange[])}, if writing
 * completed successfully; or {@link android.print.PrintDocumentAdapter.WriteResultCallback#onWriteFailed(java.lang.CharSequence) WriteResultCallback#onWriteFailed(
 * CharSequence)}, if an error occurred; or {@link android.print.PrintDocumentAdapter.WriteResultCallback#onWriteCancelled() WriteResultCallback#onWriteCancelled()},
 * if writing was cancelled in a response to a cancellation request via the passed
 * in {@link android.os.CancellationSignal CancellationSignal}. Note that you <strong>must</strong> call one of
 * the methods of the given callback for this method to be considered complete which
 * is you will not receive any calls to this adapter until the current write
 * operation is complete by invoking a method on the callback instance. The callback
 * methods can be invoked from an arbitrary thread.
 * </p>
 * <p>
 * One of the arguments passed to this method is a {@link android.os.CancellationSignal CancellationSignal}
 * which is used to propagate requests from the system to your application for
 * canceling the current write operation. For example, a cancellation may be
 * requested if the user changes a print option that may affect layout while
 * you are performing a write operation. In such a case the system will make
 * an attempt to cancel the current write as a layout will have to be performed
 * which then may be followed by a write. Typically, you should register a
 * cancellation callback in the cancellation signal. The cancellation callback
 * <strong>will not</strong> be made on the main thread and can be registered
 * as follows:
 * </p>
 * <pre>
 * cancellationSignal.setOnCancelListener(new OnCancelListener() {
 *     &#064;Override
 *     public void onCancel() {
 *         // Cancel write
 *     }
 * });
 * </pre>
 * <p>
 * <strong>Note:</strong> If the printed content is large, it is a good
 * practice to schedule writing it on a dedicated thread and register an
 * observer in the provided {@link android.os.CancellationSignal CancellationSignal} upon invocation of
 * which you should stop writing.
 * </p>
 *
 * @param pages The pages whose content to print - non-overlapping in ascending order.
 * @param destination The destination file descriptor to which to write.
 * @param cancellationSignal Signal for observing cancel writing requests.
 * @param callback Callback to inform the system for the write result.
 *
 * @see android.print.PrintDocumentAdapter.WriteResultCallback
 * @see android.os.CancellationSignal
 * @apiSince 19
 */

public abstract void onWrite(android.print.PageRange[] pages, android.os.ParcelFileDescriptor destination, android.os.CancellationSignal cancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback callback);

/**
 * Called when printing finishes. You can use this callback to release
 * resources acquired in {@link #onStart()}. This method is invoked on
 * the main thread.
 * @apiSince 19
 */

public void onFinish() { throw new RuntimeException("Stub!"); }

/**
 * Extra: mapped to a boolean value that is <code>true</code> if
 * the current layout is for a print preview, <code>false</code> otherwise.
 * This extra is provided in the {@link android.os.Bundle Bundle} argument of the {@link
 * #onLayout(android.print.PrintAttributes,android.print.PrintAttributes,android.os.CancellationSignal,android.print.PrintDocumentAdapter.LayoutResultCallback,android.os.Bundle)} callback.
 *
 * @see #onLayout(PrintAttributes, PrintAttributes, CancellationSignal,
 * LayoutResultCallback, Bundle)
 * @apiSince 19
 */

public static final java.lang.String EXTRA_PRINT_PREVIEW = "EXTRA_PRINT_PREVIEW";
/**
 * Base class for implementing a callback for the result of {@link android.print.PrintDocumentAdapter#onLayout(android.print.PrintAttributes,android.print.PrintAttributes,android.os.CancellationSignal,android.print.PrintDocumentAdapter.LayoutResultCallback,android.os.Bundle) PrintDocumentAdapter#onLayout(PrintAttributes, PrintAttributes,
 * CancellationSignal, LayoutResultCallback, Bundle)}.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class LayoutResultCallback {

LayoutResultCallback() { throw new RuntimeException("Stub!"); }

/**
 * Notifies that the layout finished and whether the content changed.
 *
 * @param info An info object describing the document. Cannot be <code>null</code>.
 * @param changed Whether the layout changed.
 *
 * @see android.print.PrintDocumentInfo
 * @apiSince 19
 */

public void onLayoutFinished(android.print.PrintDocumentInfo info, boolean changed) { throw new RuntimeException("Stub!"); }

/**
 * Notifies that an error occurred while laying out the document.
 *
 * @param error The <strong>localized</strong> error message.
 * shown to the user. May be <code>null</code> if error is unknown.
 * @apiSince 19
 */

public void onLayoutFailed(java.lang.CharSequence error) { throw new RuntimeException("Stub!"); }

/**
 * Notifies that layout was cancelled as a result of a cancellation request.
 * @apiSince 19
 */

public void onLayoutCancelled() { throw new RuntimeException("Stub!"); }
}

/**
 * Base class for implementing a callback for the result of {@link android.print.PrintDocumentAdapter#onWrite(android.print.PageRange[],android.os.ParcelFileDescriptor,android.os.CancellationSignal,android.print.PrintDocumentAdapter.WriteResultCallback) PrintDocumentAdapter#onWrite(PageRange[], ParcelFileDescriptor, CancellationSignal,
 * WriteResultCallback)}.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class WriteResultCallback {

WriteResultCallback() { throw new RuntimeException("Stub!"); }

/**
 * Notifies that all the data was written.
 *
 * @param pages The pages that were written. Cannot be <code>null</code>
 *        or empty. <br />
 *        Returning {@link android.print.PageRange#ALL_PAGES PageRange#ALL_PAGES} indicates that all pages that were
 *        requested as the {@code pages} parameter in {@link #onWrite} were written.
 * @apiSince 19
 */

public void onWriteFinished(android.print.PageRange[] pages) { throw new RuntimeException("Stub!"); }

/**
 * Notifies that an error occurred while writing the data.
 *
 * @param error The <strong>localized</strong> error message.
 * shown to the user. May be <code>null</code> if error is unknown.
 * @apiSince 19
 */

public void onWriteFailed(java.lang.CharSequence error) { throw new RuntimeException("Stub!"); }

/**
 * Notifies that write was cancelled as a result of a cancellation request.
 * @apiSince 19
 */

public void onWriteCancelled() { throw new RuntimeException("Stub!"); }
}

}

