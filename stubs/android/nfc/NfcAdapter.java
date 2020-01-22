/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.nfc;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.net.Uri;
import android.content.IntentFilter;
import android.app.PendingIntent;
import android.nfc.tech.Ndef;
import android.os.Handler;
import java.io.IOException;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcF;

/**
 * Represents the local NFC adapter.
 * <p>
 * Use the helper {@link #getDefaultAdapter(android.content.Context)} to get the default NFC
 * adapter for this Android device.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using NFC, read the
 * <a href="{@docRoot}guide/topics/nfc/index.html">Near Field Communication</a> developer guide.</p>
 * <p>To perform basic file sharing between devices, read
 * <a href="{@docRoot}training/beam-files/index.html">Sharing Files with NFC</a>.
 * </div>
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NfcAdapter {

NfcAdapter() { throw new RuntimeException("Stub!"); }

/**
 * Helper to get the default NFC Adapter.
 * <p>
 * Most Android devices will only have one NFC Adapter (NFC Controller).
 * <p>
 * This helper is the equivalent of:
 * <pre>
 * NfcManager manager = (NfcManager) context.getSystemService(Context.NFC_SERVICE);
 * NfcAdapter adapter = manager.getDefaultAdapter();</pre>
 * @param context the calling application's context
 *
 * @return the default NFC adapter, or null if no NFC adapter exists
 * @apiSince 10
 */

public static android.nfc.NfcAdapter getDefaultAdapter(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Return true if this NFC Adapter has any features enabled.
 *
 * <p>If this method returns false, the NFC hardware is guaranteed not to
 * generate or respond to any NFC communication over its NFC radio.
 * <p>Applications can use this to check if NFC is enabled. Applications
 * can request Settings UI allowing the user to toggle NFC using:
 * <p><pre>startActivity(new Intent(Settings.ACTION_NFC_SETTINGS))</pre>
 *
 * @see android.provider.Settings#ACTION_NFC_SETTINGS
 * @return true if this NFC Adapter has any features enabled
 * @apiSince 9
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Set one or more {@link android.net.Uri Uri}s to send using Android Beam (TM). Every
 * Uri you provide must have either scheme 'file' or scheme 'content'.
 *
 * <p>For the data provided through this method, Android Beam tries to
 * switch to alternate transports such as Bluetooth to achieve a fast
 * transfer speed. Hence this method is very suitable
 * for transferring large files such as pictures or songs.
 *
 * <p>The receiving side will store the content of each Uri in
 * a file and present a notification to the user to open the file
 * with a {@link android.content.Intent} with action
 * {@link android.content.Intent#ACTION_VIEW}.
 * If multiple URIs are sent, the {@link android.content.Intent} will refer
 * to the first of the stored files.
 *
 * <p>This method may be called at any time before {@link android.app.Activity#onDestroy Activity#onDestroy},
 * but the URI(s) are only made available for Android Beam when the
 * specified activity(s) are in resumed (foreground) state. The recommended
 * approach is to call this method during your Activity's
 * {@link android.app.Activity#onCreate Activity#onCreate} - see sample
 * code below. This method does not immediately perform any I/O or blocking work,
 * so is safe to call on your main thread.
 *
 * <p>{@link #setBeamPushUris} and {@link #setBeamPushUrisCallback}
 * have priority over both {@link #setNdefPushMessage} and
 * {@link #setNdefPushMessageCallback}.
 *
 * <p>If {@link #setBeamPushUris} is called with a null Uri array,
 * and/or {@link #setBeamPushUrisCallback} is called with a null callback,
 * then the Uri push will be completely disabled for the specified activity(s).
 *
 * <p>Code example:
 * <pre>
 * protected void onCreate(Bundle savedInstanceState) {
 *     super.onCreate(savedInstanceState);
 *     NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
 *     if (nfcAdapter == null) return;  // NFC not available on this device
 *     nfcAdapter.setBeamPushUris(new Uri[] {uri1, uri2}, this);
 * }</pre>
 * And that is it. Only one call per activity is necessary. The Android
 * OS will automatically release its references to the Uri(s) and the
 * Activity object when it is destroyed if you follow this pattern.
 *
 * <p>If your Activity wants to dynamically supply Uri(s),
 * then set a callback using {@link #setBeamPushUrisCallback} instead
 * of using this method.
 *
 * <p class="note">Do not pass in an Activity that has already been through
 * {@link android.app.Activity#onDestroy Activity#onDestroy}. This is guaranteed if you call this API
 * during {@link android.app.Activity#onCreate Activity#onCreate}.
 *
 * <p class="note">If this device does not support alternate transports
 * such as Bluetooth or WiFI, calling this method does nothing.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param uris an array of Uri(s) to push over Android Beam
 * @param activity activity for which the Uri(s) will be pushed
 * @throws java.lang.UnsupportedOperationException if FEATURE_NFC is unavailable.
 * @deprecated this feature is deprecated. File sharing can work using other technology like
 * Bluetooth.
 * @apiSince 16
 * @deprecatedSince 29
 */

@Deprecated
public void setBeamPushUris(android.net.Uri[] uris, android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Set a callback that will dynamically generate one or more {@link android.net.Uri Uri}s
 * to send using Android Beam (TM). Every Uri the callback provides
 * must have either scheme 'file' or scheme 'content'.
 *
 * <p>For the data provided through this callback, Android Beam tries to
 * switch to alternate transports such as Bluetooth to achieve a fast
 * transfer speed. Hence this method is very suitable
 * for transferring large files such as pictures or songs.
 *
 * <p>The receiving side will store the content of each Uri in
 * a file and present a notification to the user to open the file
 * with a {@link android.content.Intent} with action
 * {@link android.content.Intent#ACTION_VIEW}.
 * If multiple URIs are sent, the {@link android.content.Intent} will refer
 * to the first of the stored files.
 *
 * <p>This method may be called at any time before {@link android.app.Activity#onDestroy Activity#onDestroy},
 * but the URI(s) are only made available for Android Beam when the
 * specified activity(s) are in resumed (foreground) state. The recommended
 * approach is to call this method during your Activity's
 * {@link android.app.Activity#onCreate Activity#onCreate} - see sample
 * code below. This method does not immediately perform any I/O or blocking work,
 * so is safe to call on your main thread.
 *
 * <p>{@link #setBeamPushUris} and {@link #setBeamPushUrisCallback}
 * have priority over both {@link #setNdefPushMessage} and
 * {@link #setNdefPushMessageCallback}.
 *
 * <p>If {@link #setBeamPushUris} is called with a null Uri array,
 * and/or {@link #setBeamPushUrisCallback} is called with a null callback,
 * then the Uri push will be completely disabled for the specified activity(s).
 *
 * <p>Code example:
 * <pre>
 * protected void onCreate(Bundle savedInstanceState) {
 *     super.onCreate(savedInstanceState);
 *     NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
 *     if (nfcAdapter == null) return;  // NFC not available on this device
 *     nfcAdapter.setBeamPushUrisCallback(callback, this);
 * }</pre>
 * And that is it. Only one call per activity is necessary. The Android
 * OS will automatically release its references to the Uri(s) and the
 * Activity object when it is destroyed if you follow this pattern.
 *
 * <p class="note">Do not pass in an Activity that has already been through
 * {@link android.app.Activity#onDestroy Activity#onDestroy}. This is guaranteed if you call this API
 * during {@link android.app.Activity#onCreate Activity#onCreate}.
 *
 * <p class="note">If this device does not support alternate transports
 * such as Bluetooth or WiFI, calling this method does nothing.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param callback callback, or null to disable
 * @param activity activity for which the Uri(s) will be pushed
 * @throws java.lang.UnsupportedOperationException if FEATURE_NFC is unavailable.
 * @deprecated this feature is deprecated. File sharing can work using other technology like
 * Bluetooth.
 * @apiSince 16
 * @deprecatedSince 29
 */

@Deprecated
public void setBeamPushUrisCallback(android.nfc.NfcAdapter.CreateBeamUrisCallback callback, android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Set a static {@link android.nfc.NdefMessage NdefMessage} to send using Android Beam (TM).
 *
 * <p>This method may be called at any time before {@link android.app.Activity#onDestroy Activity#onDestroy},
 * but the NDEF message is only made available for NDEF push when the
 * specified activity(s) are in resumed (foreground) state. The recommended
 * approach is to call this method during your Activity's
 * {@link android.app.Activity#onCreate Activity#onCreate} - see sample
 * code below. This method does not immediately perform any I/O or blocking work,
 * so is safe to call on your main thread.
 *
 * <p>Only one NDEF message can be pushed by the currently resumed activity.
 * If both {@link #setNdefPushMessage} and
 * {@link #setNdefPushMessageCallback} are set, then
 * the callback will take priority.
 *
 * <p>If neither {@link #setNdefPushMessage} or
 * {@link #setNdefPushMessageCallback} have been called for your activity, then
 * the Android OS may choose to send a default NDEF message on your behalf,
 * such as a URI for your application.
 *
 * <p>If {@link #setNdefPushMessage} is called with a null NDEF message,
 * and/or {@link #setNdefPushMessageCallback} is called with a null callback,
 * then NDEF push will be completely disabled for the specified activity(s).
 * This also disables any default NDEF message the Android OS would have
 * otherwise sent on your behalf for those activity(s).
 *
 * <p>If you want to prevent the Android OS from sending default NDEF
 * messages completely (for all activities), you can include a
 * {@code <meta-data>} element inside the {@code <application>}
 * element of your AndroidManifest.xml file, like this:
 * <pre>
 * &lt;application ...>
 *     &lt;meta-data android:name="android.nfc.disable_beam_default"
 *         android:value="true" />
 * &lt;/application></pre>
 *
 * <p>The API allows for multiple activities to be specified at a time,
 * but it is strongly recommended to just register one at a time,
 * and to do so during the activity's {@link android.app.Activity#onCreate Activity#onCreate}. For example:
 * <pre>
 * protected void onCreate(Bundle savedInstanceState) {
 *     super.onCreate(savedInstanceState);
 *     NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
 *     if (nfcAdapter == null) return;  // NFC not available on this device
 *     nfcAdapter.setNdefPushMessage(ndefMessage, this);
 * }</pre>
 * And that is it. Only one call per activity is necessary. The Android
 * OS will automatically release its references to the NDEF message and the
 * Activity object when it is destroyed if you follow this pattern.
 *
 * <p>If your Activity wants to dynamically generate an NDEF message,
 * then set a callback using {@link #setNdefPushMessageCallback} instead
 * of a static message.
 *
 * <p class="note">Do not pass in an Activity that has already been through
 * {@link android.app.Activity#onDestroy Activity#onDestroy}. This is guaranteed if you call this API
 * during {@link android.app.Activity#onCreate Activity#onCreate}.
 *
 * <p class="note">For sending large content such as pictures and songs,
 * consider using {@link #setBeamPushUris}, which switches to alternate transports
 * such as Bluetooth to achieve a fast transfer rate.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param message NDEF message to push over NFC, or null to disable
 * @param activity activity for which the NDEF message will be pushed
 * @param activities optional additional activities, however we strongly recommend
 *        to only register one at a time, and to do so in that activity's
 *        {@link android.app.Activity#onCreate Activity#onCreate}
 * @throws java.lang.UnsupportedOperationException if FEATURE_NFC is unavailable.
 * @deprecated this feature is deprecated. File sharing can work using other technology like
 * Bluetooth.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void setNdefPushMessage(android.nfc.NdefMessage message, android.app.Activity activity, android.app.Activity... activities) { throw new RuntimeException("Stub!"); }

/**
 * Set a callback that dynamically generates NDEF messages to send using Android Beam (TM).
 *
 * <p>This method may be called at any time before {@link android.app.Activity#onDestroy Activity#onDestroy},
 * but the NDEF message callback can only occur when the
 * specified activity(s) are in resumed (foreground) state. The recommended
 * approach is to call this method during your Activity's
 * {@link android.app.Activity#onCreate Activity#onCreate} - see sample
 * code below. This method does not immediately perform any I/O or blocking work,
 * so is safe to call on your main thread.
 *
 * <p>Only one NDEF message can be pushed by the currently resumed activity.
 * If both {@link #setNdefPushMessage} and
 * {@link #setNdefPushMessageCallback} are set, then
 * the callback will take priority.
 *
 * <p>If neither {@link #setNdefPushMessage} or
 * {@link #setNdefPushMessageCallback} have been called for your activity, then
 * the Android OS may choose to send a default NDEF message on your behalf,
 * such as a URI for your application.
 *
 * <p>If {@link #setNdefPushMessage} is called with a null NDEF message,
 * and/or {@link #setNdefPushMessageCallback} is called with a null callback,
 * then NDEF push will be completely disabled for the specified activity(s).
 * This also disables any default NDEF message the Android OS would have
 * otherwise sent on your behalf for those activity(s).
 *
 * <p>If you want to prevent the Android OS from sending default NDEF
 * messages completely (for all activities), you can include a
 * {@code <meta-data>} element inside the {@code <application>}
 * element of your AndroidManifest.xml file, like this:
 * <pre>
 * &lt;application ...>
 *     &lt;meta-data android:name="android.nfc.disable_beam_default"
 *         android:value="true" />
 * &lt;/application></pre>
 *
 * <p>The API allows for multiple activities to be specified at a time,
 * but it is strongly recommended to just register one at a time,
 * and to do so during the activity's {@link android.app.Activity#onCreate Activity#onCreate}. For example:
 * <pre>
 * protected void onCreate(Bundle savedInstanceState) {
 *     super.onCreate(savedInstanceState);
 *     NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
 *     if (nfcAdapter == null) return;  // NFC not available on this device
 *     nfcAdapter.setNdefPushMessageCallback(callback, this);
 * }</pre>
 * And that is it. Only one call per activity is necessary. The Android
 * OS will automatically release its references to the callback and the
 * Activity object when it is destroyed if you follow this pattern.
 *
 * <p class="note">Do not pass in an Activity that has already been through
 * {@link android.app.Activity#onDestroy Activity#onDestroy}. This is guaranteed if you call this API
 * during {@link android.app.Activity#onCreate Activity#onCreate}.
 * <p class="note">For sending large content such as pictures and songs,
 * consider using {@link #setBeamPushUris}, which switches to alternate transports
 * such as Bluetooth to achieve a fast transfer rate.
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param callback callback, or null to disable
 * @param activity activity for which the NDEF message will be pushed
 * @param activities optional additional activities, however we strongly recommend
 *        to only register one at a time, and to do so in that activity's
 *        {@link android.app.Activity#onCreate Activity#onCreate}
 * @throws java.lang.UnsupportedOperationException if FEATURE_NFC is unavailable.
 * @deprecated this feature is deprecated. File sharing can work using other technology like
 * Bluetooth.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void setNdefPushMessageCallback(android.nfc.NfcAdapter.CreateNdefMessageCallback callback, android.app.Activity activity, android.app.Activity... activities) { throw new RuntimeException("Stub!"); }

/**
 * Set a callback on successful Android Beam (TM).
 *
 * <p>This method may be called at any time before {@link android.app.Activity#onDestroy Activity#onDestroy},
 * but the callback can only occur when the
 * specified activity(s) are in resumed (foreground) state. The recommended
 * approach is to call this method during your Activity's
 * {@link android.app.Activity#onCreate Activity#onCreate} - see sample
 * code below. This method does not immediately perform any I/O or blocking work,
 * so is safe to call on your main thread.
 *
 * <p>The API allows for multiple activities to be specified at a time,
 * but it is strongly recommended to just register one at a time,
 * and to do so during the activity's {@link android.app.Activity#onCreate Activity#onCreate}. For example:
 * <pre>
 * protected void onCreate(Bundle savedInstanceState) {
 *     super.onCreate(savedInstanceState);
 *     NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
 *     if (nfcAdapter == null) return;  // NFC not available on this device
 *     nfcAdapter.setOnNdefPushCompleteCallback(callback, this);
 * }</pre>
 * And that is it. Only one call per activity is necessary. The Android
 * OS will automatically release its references to the callback and the
 * Activity object when it is destroyed if you follow this pattern.
 *
 * <p class="note">Do not pass in an Activity that has already been through
 * {@link android.app.Activity#onDestroy Activity#onDestroy}. This is guaranteed if you call this API
 * during {@link android.app.Activity#onCreate Activity#onCreate}.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param callback callback, or null to disable
 * @param activity activity for which the NDEF message will be pushed
 * @param activities optional additional activities, however we strongly recommend
 *        to only register one at a time, and to do so in that activity's
 *        {@link android.app.Activity#onCreate Activity#onCreate}
 * @throws java.lang.UnsupportedOperationException if FEATURE_NFC is unavailable.
 * @deprecated this feature is deprecated. File sharing can work using other technology like
 * Bluetooth.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void setOnNdefPushCompleteCallback(android.nfc.NfcAdapter.OnNdefPushCompleteCallback callback, android.app.Activity activity, android.app.Activity... activities) { throw new RuntimeException("Stub!"); }

/**
 * Enable foreground dispatch to the given Activity.
 *
 * <p>This will give priority to the foreground activity when
 * dispatching a discovered {@link android.nfc.Tag Tag} to an application.
 *
 * <p>If any IntentFilters are provided to this method they are used to match dispatch Intents
 * for both the {@link android.nfc.NfcAdapter#ACTION_NDEF_DISCOVERED NfcAdapter#ACTION_NDEF_DISCOVERED} and
 * {@link android.nfc.NfcAdapter#ACTION_TAG_DISCOVERED NfcAdapter#ACTION_TAG_DISCOVERED}. Since {@link android.nfc.NfcAdapter#ACTION_TECH_DISCOVERED NfcAdapter#ACTION_TECH_DISCOVERED}
 * relies on meta data outside of the IntentFilter matching for that dispatch Intent is handled
 * by passing in the tech lists separately. Each first level entry in the tech list represents
 * an array of technologies that must all be present to match. If any of the first level sets
 * match then the dispatch is routed through the given PendingIntent. In other words, the second
 * level is ANDed together and the first level entries are ORed together.
 *
 * <p>If you pass {@code null} for both the {@code filters} and {@code techLists} parameters
 * that acts a wild card and will cause the foreground activity to receive all tags via the
 * {@link android.nfc.NfcAdapter#ACTION_TAG_DISCOVERED NfcAdapter#ACTION_TAG_DISCOVERED} intent.
 *
 * <p>This method must be called from the main thread, and only when the activity is in the
 * foreground (resumed). Also, activities must call {@link #disableForegroundDispatch} before
 * the completion of their {@link android.app.Activity#onPause Activity#onPause} callback to disable foreground dispatch
 * after it has been enabled.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param activity the Activity to dispatch to
 * @param intent the PendingIntent to start for the dispatch
 * @param filters the IntentFilters to override dispatching for, or null to always dispatch
 * @param techLists the tech lists used to perform matching for dispatching of the
 *      {@link android.nfc.NfcAdapter#ACTION_TECH_DISCOVERED NfcAdapter#ACTION_TECH_DISCOVERED} intent
 * @throws java.lang.IllegalStateException if the Activity is not currently in the foreground
 * @throws java.lang.UnsupportedOperationException if FEATURE_NFC is unavailable.
 * @apiSince 10
 */

public void enableForegroundDispatch(android.app.Activity activity, android.app.PendingIntent intent, android.content.IntentFilter[] filters, java.lang.String[][] techLists) { throw new RuntimeException("Stub!"); }

/**
 * Disable foreground dispatch to the given activity.
 *
 * <p>After calling {@link #enableForegroundDispatch}, an activity
 * must call this method before its {@link android.app.Activity#onPause Activity#onPause} callback
 * completes.
 *
 * <p>This method must be called from the main thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param activity the Activity to disable dispatch to
 * @throws java.lang.IllegalStateException if the Activity has already been paused
 * @throws java.lang.UnsupportedOperationException if FEATURE_NFC is unavailable.
 * @apiSince 10
 */

public void disableForegroundDispatch(android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Limit the NFC controller to reader mode while this Activity is in the foreground.
 *
 * <p>In this mode the NFC controller will only act as an NFC tag reader/writer,
 * thus disabling any peer-to-peer (Android Beam) and card-emulation modes of
 * the NFC adapter on this device.
 *
 * <p>Use {@link #FLAG_READER_SKIP_NDEF_CHECK} to prevent the platform from
 * performing any NDEF checks in reader mode. Note that this will prevent the
 * {@link android.nfc.tech.Ndef Ndef} tag technology from being enumerated on the tag, and that
 * NDEF-based tag dispatch will not be functional.
 *
 * <p>For interacting with tags that are emulated on another Android device
 * using Android's host-based card-emulation, the recommended flags are
 * {@link #FLAG_READER_NFC_A} and {@link #FLAG_READER_SKIP_NDEF_CHECK}.
 *
 * @param activity the Activity that requests the adapter to be in reader mode
 * @param callback the callback to be called when a tag is discovered
 * @param flags Flags indicating poll technologies and other optional parameters
 * @param extras Additional extras for configuring reader mode.
 * @throws java.lang.UnsupportedOperationException if FEATURE_NFC is unavailable.
 * @apiSince 19
 */

public void enableReaderMode(android.app.Activity activity, android.nfc.NfcAdapter.ReaderCallback callback, int flags, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Restore the NFC adapter to normal mode of operation: supporting
 * peer-to-peer (Android Beam), card emulation, and polling for
 * all supported tag technologies.
 *
 * @param activity the Activity that currently has reader mode enabled
 * @throws java.lang.UnsupportedOperationException if FEATURE_NFC is unavailable.
 * @apiSince 19
 */

public void disableReaderMode(android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Manually invoke Android Beam to share data.
 *
 * <p>The Android Beam animation is normally only shown when two NFC-capable
 * devices come into range.
 * By calling this method, an Activity can invoke the Beam animation directly
 * even if no other NFC device is in range yet. The Beam animation will then
 * prompt the user to tap another NFC-capable device to complete the data
 * transfer.
 *
 * <p>The main advantage of using this method is that it avoids the need for the
 * user to tap the screen to complete the transfer, as this method already
 * establishes the direction of the transfer and the consent of the user to
 * share data. Callers are responsible for making sure that the user has
 * consented to sharing data on NFC tap.
 *
 * <p>Note that to use this method, the passed in Activity must have already
 * set data to share over Beam by using method calls such as
 * {@link #setNdefPushMessageCallback} or
 * {@link #setBeamPushUrisCallback}.
 *
 * @param activity the current foreground Activity that has registered data to share
 * @return whether the Beam animation was successfully invoked
 * @throws java.lang.UnsupportedOperationException if FEATURE_NFC is unavailable.
 * @deprecated this feature is deprecated. File sharing can work using other technology like
 * Bluetooth.
 * @apiSince 21
 * @deprecatedSince 29
 */

@Deprecated
public boolean invokeBeam(android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Enable NDEF message push over NFC while this Activity is in the foreground.
 *
 * <p>You must explicitly call this method every time the activity is
 * resumed, and you must call {@link #disableForegroundNdefPush} before
 * your activity completes {@link android.app.Activity#onPause Activity#onPause}.
 *
 * <p>Strongly recommend to use the new {@link #setNdefPushMessage}
 * instead: it automatically hooks into your activity life-cycle,
 * so you do not need to call enable/disable in your onResume/onPause.
 *
 * <p>For NDEF push to function properly the other NFC device must
 * support either NFC Forum's SNEP (Simple Ndef Exchange Protocol), or
 * Android's "com.android.npp" (Ndef Push Protocol). This was optional
 * on Gingerbread level Android NFC devices, but SNEP is mandatory on
 * Ice-Cream-Sandwich and beyond.
 *
 * <p>This method must be called from the main thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param activity foreground activity
 * @param message a NDEF Message to push over NFC
 * @throws java.lang.IllegalStateException if the activity is not currently in the foreground
 * @throws java.lang.UnsupportedOperationException if FEATURE_NFC is unavailable.
 * @deprecated use {@link #setNdefPushMessage} instead
 * @apiSince 10
 * @deprecatedSince 15
 */

@Deprecated
public void enableForegroundNdefPush(android.app.Activity activity, android.nfc.NdefMessage message) { throw new RuntimeException("Stub!"); }

/**
 * Disable NDEF message push over P2P.
 *
 * <p>After calling {@link #enableForegroundNdefPush}, an activity
 * must call this method before its {@link android.app.Activity#onPause Activity#onPause} callback
 * completes.
 *
 * <p>Strongly recommend to use the new {@link #setNdefPushMessage}
 * instead: it automatically hooks into your activity life-cycle,
 * so you do not need to call enable/disable in your onResume/onPause.
 *
 * <p>This method must be called from the main thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param activity the Foreground activity
 * @throws java.lang.IllegalStateException if the Activity has already been paused
 * @throws java.lang.UnsupportedOperationException if FEATURE_NFC is unavailable.
 * @deprecated use {@link #setNdefPushMessage} instead
 * @apiSince 10
 * @deprecatedSince 15
 */

@Deprecated
public void disableForegroundNdefPush(android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the device supports Secure NFC functionality.
 *
 * @return True if device supports Secure NFC, false otherwise
 * @throws java.lang.UnsupportedOperationException if FEATURE_NFC is unavailable.
 * @apiSince 29
 */

public boolean isSecureNfcSupported() { throw new RuntimeException("Stub!"); }

/**
 * Checks Secure NFC feature is enabled.
 *
 * @return True if Secure NFC is enabled, false otherwise
 * @throws java.lang.UnsupportedOperationException if FEATURE_NFC is unavailable.
 * @throws java.lang.UnsupportedOperationException if device doesn't support
 *         Secure NFC functionality. {@link #isSecureNfcSupported}
 * @apiSince 29
 */

public boolean isSecureNfcEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the NDEF Push (Android Beam) feature is enabled.
 * <p>This function will return true only if both NFC is enabled, and the
 * NDEF Push feature is enabled.
 * <p>Note that if NFC is enabled but NDEF Push is disabled then this
 * device can still <i>receive</i> NDEF messages, it just cannot send them.
 * <p>Applications cannot directly toggle the NDEF Push feature, but they
 * can request Settings UI allowing the user to toggle NDEF Push using
 * <code>startActivity(new Intent(Settings.ACTION_NFCSHARING_SETTINGS))</code>
 * <p>Example usage in an Activity that requires NDEF Push:
 * <p><pre>
 * protected void onResume() {
 *     super.onResume();
 *     if (!nfcAdapter.isEnabled()) {
 *         startActivity(new Intent(Settings.ACTION_NFC_SETTINGS));
 *     } else if (!nfcAdapter.isNdefPushEnabled()) {
 *         startActivity(new Intent(Settings.ACTION_NFCSHARING_SETTINGS));
 *     }
 * }</pre>
 *
 * @see android.provider.Settings#ACTION_NFCSHARING_SETTINGS
 * @return true if NDEF Push feature is enabled
 * @throws java.lang.UnsupportedOperationException if FEATURE_NFC is unavailable.
 * @deprecated this feature is deprecated. File sharing can work using other technology like
 * Bluetooth.
 * @apiSince 16
 * @deprecatedSince 29
 */

@Deprecated
public boolean isNdefPushEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Signals that you are no longer interested in communicating with an NFC tag
 * for as long as it remains in range.
 *
 * All future attempted communication to this tag will fail with {@link java.io.IOException IOException}.
 * The NFC controller will be put in a low-power polling mode, allowing the device
 * to save power in cases where it's "attached" to a tag all the time (e.g. a tag in
 * car dock).
 *
 * Additionally the debounceMs parameter allows you to specify for how long the tag needs
 * to have gone out of range, before it will be dispatched again.
 *
 * Note: the NFC controller typically polls at a pretty slow interval (100 - 500 ms).
 * This means that if the tag repeatedly goes in and out of range (for example, in
 * case of a flaky connection), and the controller happens to poll every time the
 * tag is out of range, it *will* re-dispatch the tag after debounceMs, despite the tag
 * having been "in range" during the interval.
 *
 * Note 2: if a tag with another UID is detected after this API is called, its effect
 * will be cancelled; if this tag shows up before the amount of time specified in
 * debounceMs, it will be dispatched again.
 *
 * Note 3: some tags have a random UID, in which case this API won't work reliably.
 *
 * @param tag        the {@link android.nfc.Tag Tag} to ignore.
 * @param debounceMs minimum amount of time the tag needs to be out of range before being
 *                   dispatched again.
 * @param tagRemovedListener listener to be called when the tag is removed from the field.
 *                           Note that this will only be called if the tag has been out of range
 *                           for at least debounceMs, or if another tag came into range before
 *                           debounceMs. May be null in case you don't want a callback.
 * @param handler the {@link android.os.Handler Handler} that will be used for delivering
 *                the callback. if the handler is null, then the thread used for delivering
 *                the callback is unspecified.
 * @return false if the tag couldn't be found (or has already gone out of range), true otherwise
 * @apiSince 24
 */

public boolean ignore(android.nfc.Tag tag, int debounceMs, android.nfc.NfcAdapter.OnTagRemovedListener tagRemovedListener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Broadcast Action: The state of the local NFC adapter has been
 * changed.
 * <p>For example, NFC has been turned on or off.
 * <p>Always contains the extra field {@link #EXTRA_ADAPTER_STATE}
 * @apiSince 18
 */

public static final java.lang.String ACTION_ADAPTER_STATE_CHANGED = "android.nfc.action.ADAPTER_STATE_CHANGED";

/**
 * Intent to start an activity when a tag with NDEF payload is discovered.
 *
 * <p>The system inspects the first {@link android.nfc.NdefRecord NdefRecord} in the first {@link android.nfc.NdefMessage NdefMessage} and
 * looks for a URI, SmartPoster, or MIME record. If a URI or SmartPoster record is found the
 * intent will contain the URI in its data field. If a MIME record is found the intent will
 * contain the MIME type in its type field. This allows activities to register
 * {@link android.content.IntentFilter IntentFilter}s targeting specific content on tags. Activities should register the
 * most specific intent filters possible to avoid the activity chooser dialog, which can
 * disrupt the interaction with the tag as the user interacts with the screen.
 *
 * <p>If the tag has an NDEF payload this intent is started before
 * {@link #ACTION_TECH_DISCOVERED}. If any activities respond to this intent neither
 * {@link #ACTION_TECH_DISCOVERED} or {@link #ACTION_TAG_DISCOVERED} will be started.
 *
 * <p>The MIME type or data URI of this intent are normalized before dispatch -
 * so that MIME, URI scheme and URI host are always lower-case.
 * @apiSince 10
 */

public static final java.lang.String ACTION_NDEF_DISCOVERED = "android.nfc.action.NDEF_DISCOVERED";

/**
 * Broadcast Action: Intent to notify if the preferred payment service changed.
 *
 * <p>This intent will only be sent to the application has requested permission for
 * {@link android.Manifest.permission#NFC_PREFERRED_PAYMENT_INFO} and if the application
 * has the necessary access to Secure Element which witnessed the particular event.
 
 * <br>
 * Requires {@link android.Manifest.permission#NFC_PREFERRED_PAYMENT_INFO}
 * @apiSince R
 */

public static final java.lang.String ACTION_PREFERRED_PAYMENT_CHANGED = "android.nfc.action.PREFERRED_PAYMENT_CHANGED";

/**
 * Intent to start an activity when a tag is discovered.
 *
 * <p>This intent will not be started when a tag is discovered if any activities respond to
 * {@link #ACTION_NDEF_DISCOVERED} or {@link #ACTION_TECH_DISCOVERED} for the current tag.
 * @apiSince 9
 */

public static final java.lang.String ACTION_TAG_DISCOVERED = "android.nfc.action.TAG_DISCOVERED";

/**
 * Intent to start an activity when a tag is discovered and activities are registered for the
 * specific technologies on the tag.
 *
 * <p>To receive this intent an activity must include an intent filter
 * for this action and specify the desired tech types in a
 * manifest <code>meta-data</code> entry. Here is an example manfiest entry:
 * <pre>
 * &lt;activity android:name=".nfc.TechFilter" android:label="NFC/TechFilter"&gt;
 *     &lt;!-- Add a technology filter --&gt;
 *     &lt;intent-filter&gt;
 *         &lt;action android:name="android.nfc.action.TECH_DISCOVERED" /&gt;
 *     &lt;/intent-filter&gt;
 *
 *     &lt;meta-data android:name="android.nfc.action.TECH_DISCOVERED"
 *         android:resource="@xml/filter_nfc"
 *     /&gt;
 * &lt;/activity&gt;</pre>
 *
 * <p>The meta-data XML file should contain one or more <code>tech-list</code> entries
 * each consisting or one or more <code>tech</code> entries. The <code>tech</code> entries refer
 * to the qualified class name implementing the technology, for example "android.nfc.tech.NfcA".
 *
 * <p>A tag matches if any of the
 * <code>tech-list</code> sets is a subset of {@link android.nfc.Tag#getTechList() Tag#getTechList()}. Each
 * of the <code>tech-list</code>s is considered independently and the
 * activity is considered a match is any single <code>tech-list</code> matches the tag that was
 * discovered. This provides AND and OR semantics for filtering desired techs. Here is an
 * example that will match any tag using {@link android.nfc.tech.NfcF NfcF} or any tag using {@link android.nfc.tech.NfcA NfcA},
 * {@link android.nfc.tech.MifareClassic MifareClassic}, and {@link android.nfc.tech.Ndef Ndef}:
 *
 * <pre>
 * &lt;resources xmlns:xliff="urn:oasis:names:tc:xliff:document:1.2"&gt;
 *     &lt;!-- capture anything using NfcF --&gt;
 *     &lt;tech-list&gt;
 *         &lt;tech&gt;android.nfc.tech.NfcF&lt;/tech&gt;
 *     &lt;/tech-list&gt;
 *
 *     &lt;!-- OR --&gt;
 *
 *     &lt;!-- capture all MIFARE Classics with NDEF payloads --&gt;
 *     &lt;tech-list&gt;
 *         &lt;tech&gt;android.nfc.tech.NfcA&lt;/tech&gt;
 *         &lt;tech&gt;android.nfc.tech.MifareClassic&lt;/tech&gt;
 *         &lt;tech&gt;android.nfc.tech.Ndef&lt;/tech&gt;
 *     &lt;/tech-list&gt;
 * &lt;/resources&gt;</pre>
 *
 * <p>This intent is started after {@link #ACTION_NDEF_DISCOVERED} and before
 * {@link #ACTION_TAG_DISCOVERED}. If any activities respond to {@link #ACTION_NDEF_DISCOVERED}
 * this intent will not be started. If any activities respond to this intent
 * {@link #ACTION_TAG_DISCOVERED} will not be started.
 * @apiSince 10
 */

public static final java.lang.String ACTION_TECH_DISCOVERED = "android.nfc.action.TECH_DISCOVERED";

/**
 * Broadcast Action: Intent to notify an application that a transaction event has occurred
 * on the Secure Element.
 *
 * <p>This intent will only be sent if the application has requested permission for
 * {@link android.Manifest.permission#NFC_TRANSACTION_EVENT} and if the application has the
 * necessary access to Secure Element which witnessed the particular event.
 
 * <br>
 * Requires {@link android.Manifest.permission#NFC_TRANSACTION_EVENT}
 * @apiSince 28
 */

public static final java.lang.String ACTION_TRANSACTION_DETECTED = "android.nfc.action.TRANSACTION_DETECTED";

/**
 * Used as an int extra field in {@link #ACTION_ADAPTER_STATE_CHANGED}
 * intents to request the current power state. Possible values are:
 * {@link #STATE_OFF},
 * {@link #STATE_TURNING_ON},
 * {@link #STATE_ON},
 * {@link #STATE_TURNING_OFF},
 * @apiSince 18
 */

public static final java.lang.String EXTRA_ADAPTER_STATE = "android.nfc.extra.ADAPTER_STATE";

/**
 * Mandatory byte[] extra field in {@link #ACTION_TRANSACTION_DETECTED}
 * @apiSince 28
 */

public static final java.lang.String EXTRA_AID = "android.nfc.extra.AID";

/**
 * Optional byte[] extra field in {@link #ACTION_TRANSACTION_DETECTED}
 * @apiSince 28
 */

public static final java.lang.String EXTRA_DATA = "android.nfc.extra.DATA";

/**
 * Optional extra containing a byte array containing the ID of the discovered tag for
 * the {@link #ACTION_NDEF_DISCOVERED}, {@link #ACTION_TECH_DISCOVERED}, and
 * {@link #ACTION_TAG_DISCOVERED} intents.
 * @apiSince 9
 */

public static final java.lang.String EXTRA_ID = "android.nfc.extra.ID";

/**
 * Extra containing an array of {@link android.nfc.NdefMessage NdefMessage} present on the discovered tag.<p>
 * This extra is mandatory for {@link #ACTION_NDEF_DISCOVERED} intents,
 * and optional for {@link #ACTION_TECH_DISCOVERED}, and
 * {@link #ACTION_TAG_DISCOVERED} intents.<p>
 * When this extra is present there will always be at least one
 * {@link android.nfc.NdefMessage NdefMessage} element. Most NDEF tags have only one NDEF message,
 * but we use an array for future compatibility.
 * @apiSince 9
 */

public static final java.lang.String EXTRA_NDEF_MESSAGES = "android.nfc.extra.NDEF_MESSAGES";

/**
 * Mandatory String extra field in {@link #ACTION_PREFERRED_PAYMENT_CHANGED}
 * Indicates the condition when trigger this event.
 * @apiSince R
 */

public static final java.lang.String EXTRA_PREFERRED_PAYMENT_CHANGED_REASON = "android.nfc.extra.PREFERRED_PAYMENT_CHANGED_REASON";

/**
 * Int Extra for use with {@link #enableReaderMode(android.app.Activity,android.nfc.NfcAdapter.ReaderCallback,int,android.os.Bundle)}.
 * <p>
 * Setting this integer extra allows the calling application to specify
 * the delay that the platform will use for performing presence checks
 * on any discovered tag.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_READER_PRESENCE_CHECK_DELAY = "presence";

/**
 * Mandatory String extra field in {@link #ACTION_TRANSACTION_DETECTED}
 * Indicates the Secure Element on which the transaction occurred.
 * eSE1...eSEn for Embedded Secure Elements, SIM1...SIMn for UICC, etc.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_SECURE_ELEMENT_NAME = "android.nfc.extra.SECURE_ELEMENT_NAME";

/**
 * Mandatory extra containing the {@link android.nfc.Tag Tag} that was discovered for the
 * {@link #ACTION_NDEF_DISCOVERED}, {@link #ACTION_TECH_DISCOVERED}, and
 * {@link #ACTION_TAG_DISCOVERED} intents.
 * @apiSince 10
 */

public static final java.lang.String EXTRA_TAG = "android.nfc.extra.TAG";

/**
 * Flag for use with {@link #enableReaderMode(android.app.Activity,android.nfc.NfcAdapter.ReaderCallback,int,android.os.Bundle)}.
 * <p>
 * Setting this flag enables polling for Nfc-A technology.
 * @apiSince 19
 */

public static final int FLAG_READER_NFC_A = 1; // 0x1

/**
 * Flag for use with {@link #enableReaderMode(android.app.Activity,android.nfc.NfcAdapter.ReaderCallback,int,android.os.Bundle)}.
 * <p>
 * Setting this flag enables polling for Nfc-B technology.
 * @apiSince 19
 */

public static final int FLAG_READER_NFC_B = 2; // 0x2

/**
 * Flag for use with {@link #enableReaderMode(android.app.Activity,android.nfc.NfcAdapter.ReaderCallback,int,android.os.Bundle)}.
 * <p>
 * Setting this flag enables polling for NfcBarcode technology.
 * @apiSince 19
 */

public static final int FLAG_READER_NFC_BARCODE = 16; // 0x10

/**
 * Flag for use with {@link #enableReaderMode(android.app.Activity,android.nfc.NfcAdapter.ReaderCallback,int,android.os.Bundle)}.
 * <p>
 * Setting this flag enables polling for Nfc-F technology.
 * @apiSince 19
 */

public static final int FLAG_READER_NFC_F = 4; // 0x4

/**
 * Flag for use with {@link #enableReaderMode(android.app.Activity,android.nfc.NfcAdapter.ReaderCallback,int,android.os.Bundle)}.
 * <p>
 * Setting this flag enables polling for Nfc-V (ISO15693) technology.
 * @apiSince 19
 */

public static final int FLAG_READER_NFC_V = 8; // 0x8

/**
 * Flag for use with {@link #enableReaderMode(android.app.Activity,android.nfc.NfcAdapter.ReaderCallback,int,android.os.Bundle)}.
 * <p>
 * Setting this flag allows the caller to prevent the
 * platform from playing sounds when it discovers a tag.
 * @apiSince 19
 */

public static final int FLAG_READER_NO_PLATFORM_SOUNDS = 256; // 0x100

/**
 * Flag for use with {@link #enableReaderMode(android.app.Activity,android.nfc.NfcAdapter.ReaderCallback,int,android.os.Bundle)}.
 * <p>
 * Setting this flag allows the caller to prevent the
 * platform from performing an NDEF check on the tags it
 * finds.
 * @apiSince 19
 */

public static final int FLAG_READER_SKIP_NDEF_CHECK = 128; // 0x80

/** @apiSince R */

public static final int PREFERRED_PAYMENT_CHANGED = 2; // 0x2

/** @apiSince R */

public static final int PREFERRED_PAYMENT_LOADED = 1; // 0x1

/** @apiSince R */

public static final int PREFERRED_PAYMENT_UPDATED = 3; // 0x3

/** @apiSince 18 */

public static final int STATE_OFF = 1; // 0x1

/** @apiSince 18 */

public static final int STATE_ON = 3; // 0x3

/** @apiSince 18 */

public static final int STATE_TURNING_OFF = 4; // 0x4

/** @apiSince 18 */

public static final int STATE_TURNING_ON = 2; // 0x2
/**
 * @deprecated this feature is deprecated. File sharing can work using other technology like
 * Bluetooth.
 * @apiSince 16
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface CreateBeamUrisCallback {

/**
 * @apiSince 16
 * @deprecatedSince 29
 */

@Deprecated
public android.net.Uri[] createBeamUris(android.nfc.NfcEvent event);
}

/**
 * A callback to be invoked when another NFC device capable of NDEF push (Android Beam)
 * is within range.
 * <p>Implement this interface and pass it to {@link android.nfc.NfcAdapter#setNdefPushMessageCallback NfcAdapter#setNdefPushMessageCallback} in order to create an
 * {@link android.nfc.NdefMessage NdefMessage} at the moment that another device is within range for NFC. Using this
 * callback allows you to create a message with data that might vary based on the
 * content currently visible to the user. Alternatively, you can call {@link
 * #setNdefPushMessage setNdefPushMessage()} if the {@link android.nfc.NdefMessage NdefMessage} always contains the
 * same data.
 * @deprecated this feature is deprecated. File sharing can work using other technology like
 * Bluetooth.
 * @apiSince 14
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface CreateNdefMessageCallback {

/**
 * Called to provide a {@link android.nfc.NdefMessage NdefMessage} to push.
 *
 * <p>This callback is usually made on a binder thread (not the UI thread).
 *
 * <p>Called when this device is in range of another device
 * that might support NDEF push. It allows the application to
 * create the NDEF message only when it is required.
 *
 * <p>NDEF push cannot occur until this method returns, so do not
 * block for too long.
 *
 * <p>The Android operating system will usually show a system UI
 * on top of your activity during this time, so do not try to request
 * input from the user to complete the callback, or provide custom NDEF
 * push UI. The user probably will not see it.
 *
 * @param event {@link android.nfc.NfcEvent NfcEvent} with the {@link android.nfc.NfcEvent#nfcAdapter NfcEvent#nfcAdapter} field set
 * @return NDEF message to push, or null to not provide a message
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public android.nfc.NdefMessage createNdefMessage(android.nfc.NfcEvent event);
}

/**
 * A callback to be invoked when the system successfully delivers your {@link android.nfc.NdefMessage NdefMessage}
 * to another device.
 * @see #setOnNdefPushCompleteCallback
 * @deprecated this feature is deprecated. File sharing can work using other technology like
 * Bluetooth.
 * @apiSince 14
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnNdefPushCompleteCallback {

/**
 * Called on successful NDEF push.
 *
 * <p>This callback is usually made on a binder thread (not the UI thread).
 *
 * @param event {@link android.nfc.NfcEvent NfcEvent} with the {@link android.nfc.NfcEvent#nfcAdapter NfcEvent#nfcAdapter} field set
 * @see #setNdefPushMessageCallback
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void onNdefPushComplete(android.nfc.NfcEvent event);
}

/**
 * A callback that is invoked when a tag is removed from the field.
 * @see android.nfc.NfcAdapter#ignore
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnTagRemovedListener {

/** @apiSince 24 */

public void onTagRemoved();
}

/**
 * A callback to be invoked when the system finds a tag while the foreground activity is
 * operating in reader mode.
 * <p>Register your {@code ReaderCallback} implementation with {@link android.nfc.NfcAdapter#enableReaderMode NfcAdapter#enableReaderMode} and disable it with {@link android.nfc.NfcAdapter#disableReaderMode NfcAdapter#disableReaderMode}.
 * @see android.nfc.NfcAdapter#enableReaderMode
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ReaderCallback {

/** @apiSince 19 */

public void onTagDiscovered(android.nfc.Tag tag);
}

}

