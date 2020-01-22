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
 * limitations under the License
 */


package android.telephony.mbms;

import android.content.BroadcastReceiver;

/**
 * The {@link android.content.BroadcastReceiver BroadcastReceiver} responsible for handling intents sent from the middleware. Apps
 * that wish to download using MBMS APIs should declare this class in their AndroidManifest.xml as
 * follows:
 <pre>{@code
 <receiver
    android:name="android.telephony.mbms.MbmsDownloadReceiver"
    android:permission="android.permission.SEND_EMBMS_INTENTS"
    android:enabled="true"
    android:exported="true">
 </receiver>}</pre>
 * @apiSince 28
  */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MbmsDownloadReceiver extends android.content.BroadcastReceiver {

public MbmsDownloadReceiver() { throw new RuntimeException("Stub!"); }

/** @hide */

public void onReceive(android.content.Context context, android.content.Intent intent) { throw new RuntimeException("Stub!"); }
}

