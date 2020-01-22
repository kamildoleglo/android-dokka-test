/*
 * Copyright (C) 2006 The Android Open Source Project
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


package android.content;


/**
 * This exception is thrown from {@link android.content.Context#registerReceiver Context#registerReceiver} and
 * {@link android.content.Context#bindService Context#bindService} when these methods are being used from
 * an {@link android.content.BroadcastReceiver BroadcastReceiver} component.  In this case, the component will no
 * longer be active upon returning from receiving the Intent, so it is
 * not valid to use asynchronous APIs.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ReceiverCallNotAllowedException extends android.util.AndroidRuntimeException {

/** @apiSince 1 */

public ReceiverCallNotAllowedException(java.lang.String msg) { throw new RuntimeException("Stub!"); }
}

