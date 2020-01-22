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

import android.content.Intent;
import android.print.PrintJobInfo;
import android.print.PrinterInfo;
import android.app.PendingIntent;
import android.app.Activity;

/**
 * <p>
 * This is the base class for implementing print services. A print service knows
 * how to discover and interact one or more printers via one or more protocols.
 * </p>
 * <h3>Printer discovery</h3>
 * <p>
 * A print service is responsible for discovering printers, adding discovered printers,
 * removing added printers, and updating added printers. When the system is interested
 * in printers managed by your service it will call {@link
 * #onCreatePrinterDiscoverySession()} from which you must return a new {@link android.printservice.PrinterDiscoverySession PrinterDiscoverySession} instance. The returned session encapsulates the interaction
 * between the system and your service during printer discovery. For description of this
 * interaction refer to the documentation for {@link android.printservice.PrinterDiscoverySession PrinterDiscoverySession}.
 * </p>
 * <p>
 * For every printer discovery session all printers have to be added since system does
 * not retain printers across sessions. Hence, each printer known to this print service
 * should be added only once during a discovery session. Only an already added printer
 * can be removed or updated. Removed printers can be added again.
 * </p>
 * <h3>Print jobs</h3>
 * <p>
 * When a new print job targeted to a printer managed by this print service is is queued,
 * i.e. ready for processing by the print service, you will receive a call to {@link
 * #onPrintJobQueued(android.printservice.PrintJob)}. The print service may handle the print job immediately
 * or schedule that for an appropriate time in the future. The list of all active print
 * jobs for this service is obtained by calling {@link #getActivePrintJobs()}. Active
 * print jobs are ones that are queued or started.
 * </p>
 * <p>
 * A print service is responsible for setting a print job's state as appropriate
 * while processing it. Initially, a print job is queued, i.e. {@link android.printservice.PrintJob#isQueued() PrintJob#isQueued()} returns true, which means that the document to be printed is
 * spooled by the system and the print service can begin processing it. You can obtain
 * the printed document by calling {@link android.printservice.PrintJob#getDocument() PrintJob#getDocument()}
 * whose data is accessed via {@link android.printservice.PrintDocument#getData() PrintDocument#getData()}.
 * After the print service starts printing the data it should set the print job's
 * state to started by calling {@link android.printservice.PrintJob#start() PrintJob#start()} after which
 * {@link android.printservice.PrintJob#isStarted() PrintJob#isStarted()} would return true. Upon successful
 * completion, the print job should be marked as completed by calling {@link android.printservice.PrintJob#complete() PrintJob#complete()} after which {@link android.printservice.PrintJob#isCompleted() PrintJob#isCompleted()} would return true. In case of a failure, the print job should
 * be marked as failed by calling {@link android.printservice.PrintJob#fail(java.lang.String) PrintJob#fail(String)} after which {@link android.printservice.PrintJob#isFailed() PrintJob#isFailed()} would
 * return true.
 * </p>
 * <p>
 * If a print job is queued or started and the user requests to cancel it, the print
 * service will receive a call to {@link #onRequestCancelPrintJob(android.printservice.PrintJob)} which
 * requests from the service to do best effort in canceling the job. In case the job
 * is successfully canceled, its state has to be marked as cancelled by calling {@link android.printservice.PrintJob#cancel() PrintJob#cancel()} after which {@link android.printservice.PrintJob#isCancelled() PrintJob#isCancelled()} would return true.
 * </p>
 * <h3>Lifecycle</h3>
 * <p>
 * The lifecycle of a print service is managed exclusively by the system and follows
 * the established service lifecycle. Additionally, starting or stopping a print service
 * is triggered exclusively by an explicit user action through enabling or disabling it
 * in the device settings. After the system binds to a print service, it calls {@link
 * #onConnected()}. This method can be overriden by clients to perform post binding setup.
 * Also after the system unbinds from a print service, it calls {@link #onDisconnected()}.
 * This method can be overriden by clients to perform post unbinding cleanup. Your should
 * not do any work after the system disconnected from your print service since the
 * service can be killed at any time to reclaim memory. The system will not disconnect
 * from a print service if there are active print jobs for the printers managed by it.
 * </p>
 * <h3>Declaration</h3>
 * <p>
 * A print service is declared as any other service in an AndroidManifest.xml but it must
 * also specify that it handles the {@link android.content.Intent} with action {@link
 * #SERVICE_INTERFACE android.printservice.PrintService}. Failure to declare this intent
 * will cause the system to ignore the print service. Additionally, a print service must
 * request the {@link android.Manifest.permission#BIND_PRINT_SERVICE
 * android.permission.BIND_PRINT_SERVICE} permission to ensure that only the system can
 * bind to it. Failure to declare this intent will cause the system to ignore the print
 * service. Following is an example declaration:
 * </p>
 * <pre>
 * &lt;service android:name=".MyPrintService"
 *         android:permission="android.permission.BIND_PRINT_SERVICE"&gt;
 *     &lt;intent-filter&gt;
 *         &lt;action android:name="android.printservice.PrintService" /&gt;
 *     &lt;/intent-filter&gt;
 *     . . .
 * &lt;/service&gt;
 * </pre>
 * <h3>Configuration</h3>
 * <p>
 * A print service can be configured by specifying an optional settings activity which
 * exposes service specific settings, an optional add printers activity which is used for
 * manual addition of printers, vendor name ,etc. It is a responsibility of the system
 * to launch the settings and add printers activities when appropriate.
 * </p>
 * <p>
 * A print service is configured by providing a {@link #SERVICE_META_DATA meta-data}
 * entry in the manifest when declaring the service. A service declaration with a meta-data
 * tag is presented below:
 * <pre> &lt;service android:name=".MyPrintService"
 *         android:permission="android.permission.BIND_PRINT_SERVICE"&gt;
 *     &lt;intent-filter&gt;
 *         &lt;action android:name="android.printservice.PrintService" /&gt;
 *     &lt;/intent-filter&gt;
 *     &lt;meta-data android:name="android.printservice" android:resource="@xml/printservice" /&gt;
 * &lt;/service&gt;</pre>
 * </p>
 * <p>
 * For more details for how to configure your print service via the meta-data refer to
 * {@link #SERVICE_META_DATA} and <code>&lt;{@link android.R.styleable#PrintService
 * print-service}&gt;</code>.
 * </p>
 * <p>
 * <strong>Note: </strong> All callbacks in this class are executed on the main
 * application thread. You should also invoke any method of this class on the main
 * application thread.
 * </p>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class PrintService extends android.app.Service {

public PrintService() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

protected final void attachBaseContext(android.content.Context base) { throw new RuntimeException("Stub!"); }

/**
 * The system has connected to this service.
 * @apiSince 19
 */

protected void onConnected() { throw new RuntimeException("Stub!"); }

/**
 * The system has disconnected from this service.
 * @apiSince 19
 */

protected void onDisconnected() { throw new RuntimeException("Stub!"); }

/**
 * Callback asking you to create a new {@link android.printservice.PrinterDiscoverySession PrinterDiscoverySession}.
 *
 * @return The created session.
 * This value may be {@code null}.
 * @see android.printservice.PrinterDiscoverySession
 * @apiSince 19
 */

@androidx.annotation.Nullable
protected abstract android.printservice.PrinterDiscoverySession onCreatePrinterDiscoverySession();

/**
 * Called when cancellation of a print job is requested. The service
 * should do best effort to fulfill the request. After the cancellation
 * is performed, the print job should be marked as cancelled state by
 * calling {@link android.printservice.PrintJob#cancel() PrintJob#cancel()}.
 *
 * @param printJob The print job to cancel.
 *
 * @see android.printservice.PrintJob#cancel() PrintJob.cancel()
 * @see android.printservice.PrintJob#isCancelled() PrintJob.isCancelled()
 * @apiSince 19
 */

protected abstract void onRequestCancelPrintJob(android.printservice.PrintJob printJob);

/**
 * Called when there is a queued print job for one of the printers
 * managed by this print service.
 *
 * @param printJob The new queued print job.
 *
 * @see android.printservice.PrintJob#isQueued() PrintJob.isQueued()
 * @see #getActivePrintJobs()
 * @apiSince 19
 */

protected abstract void onPrintJobQueued(android.printservice.PrintJob printJob);

/**
 * Gets the active print jobs for the printers managed by this service.
 * Active print jobs are ones that are not in a final state, i.e. whose
 * state is queued or started.
 *
 * @return The active print jobs.
 *
 * @see android.printservice.PrintJob#isQueued() PrintJob.isQueued()
 * @see android.printservice.PrintJob#isStarted() PrintJob.isStarted()
 * @apiSince 19
 */

public final java.util.List<android.printservice.PrintJob> getActivePrintJobs() { throw new RuntimeException("Stub!"); }

/**
 * Generates a global printer id given the printer's locally unique one.
 *
 * @param localId A locally unique id in the context of your print service.
 * @return Global printer id.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public final android.print.PrinterId generatePrinterId(java.lang.String localId) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public final android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * When the {@link android.app.PendingIntent PendingIntent} declared via
 * {@link android.print.PrinterInfo.Builder#setInfoIntent(android.app.PendingIntent) PrinterInfo.Builder#setInfoIntent(PendingIntent)} is called this boolean extra
 * will be filled in if the activity can select the printer.
 *
 * @see #EXTRA_SELECT_PRINTER
 * @apiSince 26
 */

public static final java.lang.String EXTRA_CAN_SELECT_PRINTER = "android.printservice.extra.CAN_SELECT_PRINTER";

/**
 * If you declared an optional activity with advanced print options via the
 * {@link android.R.attr#advancedPrintOptionsActivity advancedPrintOptionsActivity}
 * attribute, this extra is used to pass in the currently selected printer's
 * {@link android.print.PrinterInfo} to your activity allowing you to inspect it.
 *
 * @see #EXTRA_PRINT_JOB_INFO
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PRINTER_INFO = "android.intent.extra.print.EXTRA_PRINTER_INFO";

/**
 * If you declared an optional activity with advanced print options via the
 * {@link android.R.attr#advancedPrintOptionsActivity advancedPrintOptionsActivity}
 * attribute, this extra is used to pass in the meta-data for the currently printed
 * document as a {@link android.print.PrintDocumentInfo} to your activity allowing
 * you to inspect it.
 *
 * @see #EXTRA_PRINT_JOB_INFO
 * @see #EXTRA_PRINTER_INFO
 * @apiSince 23
 */

public static final java.lang.String EXTRA_PRINT_DOCUMENT_INFO = "android.printservice.extra.PRINT_DOCUMENT_INFO";

/**
 * If you declared an optional activity with advanced print options via the
 * {@link android.R.attr#advancedPrintOptionsActivity advancedPrintOptionsActivity} attribute,
 * this extra is used to pass in the currently constructed {@link android.print.PrintJobInfo PrintJobInfo} to your activity
 * allowing you to modify it. After you are done, you must return the modified
 * {@link android.print.PrintJobInfo PrintJobInfo} via the same extra.
 * <p>
 * You cannot modify the passed in {@link android.print.PrintJobInfo PrintJobInfo} directly, rather you should build
 * another one using the {@link android.print.PrintJobInfo.Builder PrintJobInfo.Builder} class.
 * You can specify any standard properties and add advanced, printer specific, ones via
 * {@link android.print.PrintJobInfo.Builder#putAdvancedOption(String, String)
 * PrintJobInfo.Builder.putAdvancedOption(String, String)} and
 * {@link android.print.PrintJobInfo.Builder#putAdvancedOption(String, int)
 * PrintJobInfo.Builder.putAdvancedOption(String, int)}. The advanced options are not
 * interpreted by the system, they will not be visible to applications, and can only be accessed
 * by your print service via {@link android.printservice.PrintJob#getAdvancedStringOption(java.lang.String) PrintJob#getAdvancedStringOption(String)} and {@link android.printservice.PrintJob#getAdvancedIntOption(java.lang.String) PrintJob#getAdvancedIntOption(String)}.
 * </p>
 * <p>
 * If the advanced print options activity offers changes to the standard print options, you can
 * get the current {@link android.print.PrinterInfo PrinterInfo} using the
 * {@link #EXTRA_PRINTER_INFO} extra which will allow you to present the user with UI options
 * supported by the current printer. For example, if the current printer does not support a
 * given media size, you should not offer it in the advanced print options UI.
 * </p>
 *
 * @see #EXTRA_PRINTER_INFO
 * @apiSince 19
 */

public static final java.lang.String EXTRA_PRINT_JOB_INFO = "android.intent.extra.print.PRINT_JOB_INFO";

/**
 * If this boolean extra is set to {@code true} in the {@link android.app.Activity#setResult(int,android.content.Intent) Activity#setResult(int, Intent)} from the activity specified in
 * {@link android.print.PrinterInfo.Builder#setInfoIntent(android.app.PendingIntent) PrinterInfo.Builder#setInfoIntent(PendingIntent)} the printer will be selected.
 *
 * @see #EXTRA_CAN_SELECT_PRINTER
 * @apiSince 26
 */

public static final java.lang.String EXTRA_SELECT_PRINTER = "android.printservice.extra.SELECT_PRINTER";

/**
 * The {@link android.content.Intent Intent} action that must be declared as handled by a service
 * in its manifest for the system to recognize it as a print service.
 * @apiSince 19
 */

public static final java.lang.String SERVICE_INTERFACE = "android.printservice.PrintService";

/**
 * Name under which a {@link android.printservice.PrintService PrintService} component publishes additional information
 * about itself. This meta-data must reference a XML resource containing a <code>
 * &lt;{@link android.R.styleable#PrintService print-service}&gt;</code> tag. This is
 * a sample XML file configuring a print service:
 * <pre> &lt;print-service
 *     android:vendor="SomeVendor"
 *     android:settingsActivity="foo.bar.MySettingsActivity"
 *     andorid:addPrintersActivity="foo.bar.MyAddPrintersActivity."
 *     . . .
 * /&gt;</pre>
 * <p>
 * For detailed configuration options that can be specified via the meta-data
 * refer to {@link android.R.styleable#PrintService android.R.styleable.PrintService}.
 * </p>
 * <p>
 * If you declare a settings or add a printers activity, they have to be exported,
 * by setting the {@link android.R.attr#exported} activity attribute to <code>true
 * </code>. Also in case you want only the system to be able to start any of these
 * activities you can specify that they request the android.permission
 * .START_PRINT_SERVICE_CONFIG_ACTIVITY permission by setting the
 * {@link android.R.attr#permission} activity attribute.
 * </p>
 * @apiSince 19
 */

public static final java.lang.String SERVICE_META_DATA = "android.printservice";
}

