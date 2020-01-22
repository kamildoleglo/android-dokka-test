/*
 * Copyright (C) 2008 The Android Open Source Project
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
 * Schedule a countdown until a time in the future, with
 * regular notifications on intervals along the way.
 *
 * Example of showing a 30 second countdown in a text field:
 *
 * <pre class="prettyprint">
 * new CountDownTimer(30000, 1000) {
 *
 *     public void onTick(long millisUntilFinished) {
 *         mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
 *     }
 *
 *     public void onFinish() {
 *         mTextField.setText("done!");
 *     }
 *  }.start();
 * </pre>
 *
 * The calls to {@link #onTick(long)} are synchronized to this object so that
 * one call to {@link #onTick(long)} won't ever occur before the previous
 * callback is complete.  This is only relevant when the implementation of
 * {@link #onTick(long)} takes an amount of time to execute that is significant
 * compared to the countdown interval.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CountDownTimer {

/**
 * @param millisInFuture The number of millis in the future from the call
 *   to {@link #start()} until the countdown is done and {@link #onFinish()}
 *   is called.
 * @param countDownInterval The interval along the way to receive
 *   {@link #onTick(long)} callbacks.
 * @apiSince 1
 */

public CountDownTimer(long millisInFuture, long countDownInterval) { throw new RuntimeException("Stub!"); }

/**
 * Cancel the countdown.
 * @apiSince 1
 */

public final synchronized void cancel() { throw new RuntimeException("Stub!"); }

/**
 * Start the countdown.
 * @apiSince 1
 */

public final synchronized android.os.CountDownTimer start() { throw new RuntimeException("Stub!"); }

/**
 * Callback fired on regular interval.
 * @param millisUntilFinished The amount of time until finished.
 * @apiSince 1
 */

public abstract void onTick(long millisUntilFinished);

/**
 * Callback fired when the time is up.
 * @apiSince 1
 */

public abstract void onFinish();
}

