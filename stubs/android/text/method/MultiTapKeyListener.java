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


package android.text.method;


/**
 * This is the standard key listener for alphabetic input on 12-key
 * keyboards.  You should generally not need to instantiate this yourself;
 * TextKeyListener will do it for you.
 * <p></p>
 * As for all implementations of {@link android.text.method.KeyListener KeyListener}, this class is only concerned
 * with hardware keyboards.  Software input methods have no obligation to trigger
 * the methods in this class.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MultiTapKeyListener extends android.text.method.BaseKeyListener implements android.text.SpanWatcher {

/** @apiSince 1 */

public MultiTapKeyListener(android.text.method.TextKeyListener.Capitalize cap, boolean autotext) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new or existing instance with the specified capitalization
 * and correction properties.
 * @apiSince 1
 */

public static android.text.method.MultiTapKeyListener getInstance(boolean autotext, android.text.method.TextKeyListener.Capitalize cap) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int getInputType() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyDown(android.view.View view, android.text.Editable content, int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onSpanChanged(android.text.Spannable buf, java.lang.Object what, int s, int e, int start, int stop) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onSpanAdded(android.text.Spannable s, java.lang.Object what, int start, int end) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onSpanRemoved(android.text.Spannable s, java.lang.Object what, int start, int end) { throw new RuntimeException("Stub!"); }
}

