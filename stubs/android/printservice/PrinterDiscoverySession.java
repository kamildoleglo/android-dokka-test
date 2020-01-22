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


package android.printservice;

import java.util.List;
import android.print.PrinterId;
import android.print.PrinterCapabilitiesInfo;
import android.print.PrinterInfo;

/**
 * This class encapsulates the interaction between a print service and the
 * system during printer discovery. During printer discovery you are responsible
 * for adding discovered printers, removing previously added printers that
 * disappeared, and updating already added printers.
 * <p>
 * During the lifetime of this session you may be asked to start and stop
 * performing printer discovery multiple times. You will receive a call to {@link android.printservice.PrinterDiscoverySession#onStartPrinterDiscovery(java.util.List) PrinterDiscoverySession#onStartPrinterDiscovery(List)} to start printer
 * discovery and a call to {@link android.printservice.PrinterDiscoverySession#onStopPrinterDiscovery() PrinterDiscoverySession#onStopPrinterDiscovery()}
 * to stop printer discovery. When the system is no longer interested in printers
 * discovered by this session you will receive a call to {@link #onDestroy()} at
 * which point the system will no longer call into the session and all the session
 * methods will do nothing.
 * </p>
 * <p>
 * Discovered printers are added by invoking {@link android.printservice.PrinterDiscoverySession#addPrinters(java.util.List) PrinterDiscoverySession#addPrinters(List)}. Added printers that disappeared are
 * removed by invoking {@link android.printservice.PrinterDiscoverySession#removePrinters(java.util.List) PrinterDiscoverySession#removePrinters(List)}. Added
 * printers whose properties or capabilities changed are updated through a call to
 * {@link android.printservice.PrinterDiscoverySession#addPrinters(java.util.List) PrinterDiscoverySession#addPrinters(List)}. The printers added in this
 * session can be acquired via {@link #getPrinters()} where the returned printers
 * will be an up-to-date snapshot of the printers that you reported during the
 * session. Printers are <strong>not</strong> persisted across sessions.
 * </p>
 * <p>
 * The system will make a call to {@link #onValidatePrinters(java.util.List)} if you
 * need to update some printers. It is possible that you add a printer without
 * specifying its capabilities. This enables you to avoid querying all discovered
 * printers for their capabilities, rather querying the capabilities of a printer
 * only if necessary. For example, the system will request that you update a printer
 * if it gets selected by the user. When validating printers you do not need to
 * provide the printers' capabilities but may do so.
 * </p>
 * <p>
 * If the system is interested in being constantly updated for the state of a
 * printer you will receive a call to {@link #onStartPrinterStateTracking(android.print.PrinterId)}
 * after which you will have to do a best effort to keep the system updated for
 * changes in the printer state and capabilities. You also <strong>must</strong>
 * update the printer capabilities if you did not provide them when adding it, or
 * the printer will be ignored. When the system is no longer interested in getting
 * updates for a printer you will receive a call to {@link #onStopPrinterStateTracking(android.print.PrinterId)}.
 * </p>
 * <p>
 * <strong>Note: </strong> All callbacks in this class are executed on the main
 * application thread. You also have to invoke any method of this class on the main
 * application thread.
 * </p>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class PrinterDiscoverySession {

/**
 * Constructor.
 * @apiSince 19
 */

public PrinterDiscoverySession() { throw new RuntimeException("Stub!"); }

/**
 * Gets the printers reported in this session. For example, if you add two
 * printers and remove one of them, the returned list will contain only
 * the printer that was added but not removed.
 * <p>
 * <strong>Note: </strong> Calls to this method after the session is
 * destroyed, that is after the {@link #onDestroy()} callback, will be ignored.
 * </p>
 *
 * @return The printers.
 *
 * This value will never be {@code null}.
 * @see #addPrinters(List)
 * @see #removePrinters(List)
 * @see #isDestroyed()
 * @apiSince 19
 */

@androidx.annotation.NonNull
public final java.util.List<android.print.PrinterInfo> getPrinters() { throw new RuntimeException("Stub!"); }

/**
 * Adds discovered printers. Adding an already added printer updates it.
 * Removed printers can be added again. You can call this method multiple
 * times during the life of this session. Duplicates will be ignored.
 * <p>
 * <strong>Note: </strong> Calls to this method after the session is
 * destroyed, that is after the {@link #onDestroy()} callback, will be ignored.
 * </p>
 *
 * @param printers The printers to add.
 *
 * This value must never be {@code null}.
 * @see #removePrinters(List)
 * @see #getPrinters()
 * @see #isDestroyed()
 * @apiSince 19
 */

public final void addPrinters(@androidx.annotation.NonNull java.util.List<android.print.PrinterInfo> printers) { throw new RuntimeException("Stub!"); }

/**
 * Removes added printers. Removing an already removed or never added
 * printer has no effect. Removed printers can be added again. You can
 * call this method multiple times during the lifetime of this session.
 * <p>
 * <strong>Note: </strong> Calls to this method after the session is
 * destroyed, that is after the {@link #onDestroy()} callback, will be ignored.
 * </p>
 *
 * @param printerIds The ids of the removed printers.
 *
 * This value must never be {@code null}.
 * @see #addPrinters(List)
 * @see #getPrinters()
 * @see #isDestroyed()
 * @apiSince 19
 */

public final void removePrinters(@androidx.annotation.NonNull java.util.List<android.print.PrinterId> printerIds) { throw new RuntimeException("Stub!"); }

/**
 * Callback asking you to start printer discovery. Discovered printers should be
 * added via calling {@link #addPrinters(java.util.List)}. Added printers that disappeared
 * should be removed via calling {@link #removePrinters(java.util.List)}. Added printers
 * whose properties or capabilities changed should be updated via calling {@link
 * #addPrinters(java.util.List)}. You will receive a call to {@link #onStopPrinterDiscovery()}
 * when you should stop printer discovery.
 * <p>
 * During the lifetime of this session all printers that are known to your print
 * service have to be added. The system does not retain any printers across sessions.
 * However, if you were asked to start and then stop performing printer discovery
 * in this session, then a subsequent discovering should not re-discover already
 * discovered printers. You can get the printers reported during this session by
 * calling {@link #getPrinters()}.
 * </p>
 * <p>
 * <strong>Note: </strong>You are also given a list of printers whose availability
 * has to be checked first. For example, these printers could be the user's favorite
 * ones, therefore they have to be verified first. You do <strong>not need</strong>
 * to provide the capabilities of the printers, rather verify whether they exist
 * similarly to {@link #onValidatePrinters(java.util.List)}.
 * </p>
 *
 * @param priorityList The list of printers to validate first. Never null.
 *
 * This value must never be {@code null}.
 * @see #onStopPrinterDiscovery()
 * @see #addPrinters(List)
 * @see #removePrinters(List)
 * @see #isPrinterDiscoveryStarted()
 * @apiSince 19
 */

public abstract void onStartPrinterDiscovery(@androidx.annotation.NonNull java.util.List<android.print.PrinterId> priorityList);

/**
 * Callback notifying you that you should stop printer discovery.
 *
 * @see #onStartPrinterDiscovery(List)
 * @see #isPrinterDiscoveryStarted()
 * @apiSince 19
 */

public abstract void onStopPrinterDiscovery();

/**
 * Callback asking you to validate that the given printers are valid, that
 * is they exist. You are responsible for checking whether these printers
 * exist and for the ones that do exist notify the system via calling
 * {@link #addPrinters(java.util.List)}.
 * <p>
 * <strong>Note: </strong> You are <strong>not required</strong> to provide
 * the printer capabilities when updating the printers that do exist.
 * <p>
 *
 * @param printerIds The printers to validate.
 *
 * This value must never be {@code null}.
 * @see android.print.PrinterInfo.Builder#setCapabilities(PrinterCapabilitiesInfo)
 *      PrinterInfo.Builder.setCapabilities(PrinterCapabilitiesInfo)
 * @apiSince 19
 */

public abstract void onValidatePrinters(@androidx.annotation.NonNull java.util.List<android.print.PrinterId> printerIds);

/**
 * Callback asking you to start tracking the state of a printer. Tracking
 * the state means that you should do a best effort to observe the state
 * of this printer and notify the system if that state changes via calling
 * {@link #addPrinters(java.util.List)}.
 * <p>
 * <strong>Note: </strong> A printer can be initially added without its
 * capabilities to avoid polling printers that the user will not select.
 * However, after this method is called you are expected to update the
 * printer <strong>including</strong> its capabilities. Otherwise, the
 * printer will be ignored.
 * <p>
 * <p>
 * A scenario when you may be requested to track a printer's state is if
 * the user selects that printer and the system has to present print
 * options UI based on the printer's capabilities. In this case the user
 * should be promptly informed if, for example, the printer becomes
 * unavailable.
 * </p>
 *
 * @param printerId The printer to start tracking.
 *
 * This value must never be {@code null}.
 * @see #onStopPrinterStateTracking(PrinterId)
 * @see android.print.PrinterInfo.Builder#setCapabilities(PrinterCapabilitiesInfo)
 *      PrinterInfo.Builder.setCapabilities(PrinterCapabilitiesInfo)
 * @apiSince 19
 */

public abstract void onStartPrinterStateTracking(@androidx.annotation.NonNull android.print.PrinterId printerId);

/**
 * Called by the system to request the custom icon for a printer. Once the icon is available the
 * print services uses {@link android.printservice.CustomPrinterIconCallback#onCustomPrinterIconLoaded CustomPrinterIconCallback#onCustomPrinterIconLoaded} to send the
 * icon to the system.
 *
 * @param printerId The printer to icon belongs to.
 * This value must never be {@code null}.
 * @param cancellationSignal Signal used to cancel the request.
 * This value must never be {@code null}.
 * @param callback Callback for returning the icon to the system.
 *
 * This value must never be {@code null}.
 * @see android.print.PrinterInfo.Builder#setHasCustomPrinterIcon(boolean)
 * @apiSince 24
 */

public void onRequestCustomPrinterIcon(@androidx.annotation.NonNull android.print.PrinterId printerId, @androidx.annotation.NonNull android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull android.printservice.CustomPrinterIconCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Callback asking you to stop tracking the state of a printer. The passed
 * in printer id is the one for which you received a call to {@link
 * #onStartPrinterStateTracking(android.print.PrinterId)}.
 *
 * @param printerId The printer to stop tracking.
 *
 * This value must never be {@code null}.
 * @see #onStartPrinterStateTracking(PrinterId)
 * @apiSince 19
 */

public abstract void onStopPrinterStateTracking(@androidx.annotation.NonNull android.print.PrinterId printerId);

/**
 * Gets the printers that should be tracked. These are printers that are
 * important to the user and for which you received a call to {@link
 * #onStartPrinterStateTracking(android.print.PrinterId)} asking you to observer their
 * state and reporting it to the system via {@link #addPrinters(java.util.List)}.
 * You will receive a call to {@link #onStopPrinterStateTracking(android.print.PrinterId)}
 * if you should stop tracking a printer.
 * <p>
 * <strong>Note: </strong> Calls to this method after the session is
 * destroyed, that is after the {@link #onDestroy()} callback, will be ignored.
 * </p>
 *
 * @return The printers.
 *
 * This value will never be {@code null}.
 * @see #onStartPrinterStateTracking(PrinterId)
 * @see #onStopPrinterStateTracking(PrinterId)
 * @see #isDestroyed()
 * @apiSince 19
 */

@androidx.annotation.NonNull
public final java.util.List<android.print.PrinterId> getTrackedPrinters() { throw new RuntimeException("Stub!"); }

/**
 * Notifies you that the session is destroyed. After this callback is invoked
 * any calls to the methods of this class will be ignored, {@link #isDestroyed()}
 * will return true and you will also no longer receive callbacks.
 *
 * @see #isDestroyed()
 * @apiSince 19
 */

public abstract void onDestroy();

/**
 * Gets whether the session is destroyed.
 *
 * @return Whether the session is destroyed.
 *
 * @see #onDestroy()
 * @apiSince 19
 */

public final boolean isDestroyed() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether printer discovery is started.
 *
 * @return Whether printer discovery is destroyed.
 *
 * @see #onStartPrinterDiscovery(List)
 * @see #onStopPrinterDiscovery()
 * @apiSince 19
 */

public final boolean isPrinterDiscoveryStarted() { throw new RuntimeException("Stub!"); }
}

