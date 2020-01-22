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


package android.text.style;

import android.content.Intent;

/**
 * Implementation of the {@link android.text.style.ClickableSpan ClickableSpan} that allows setting a url string. When
 * selecting and clicking on the text to which the span is attached, the <code>URLSpan</code>
 * will try to open the url, by launching an an Activity with an {@link android.content.Intent#ACTION_VIEW Intent#ACTION_VIEW} intent.
 * <p>
 * For example, a <code>URLSpan</code> can be used like this:
 * <pre>
 * SpannableString string = new SpannableString("Text with a url span");
 * string.setSpan(new URLSpan("http://www.developer.android.com"), 12, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
 * </pre>
 * <img src="{@docRoot}reference/android/images/text/style/urlspan.png" />
 * <figcaption>Text with <code>URLSpan</code>.</figcaption>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class URLSpan extends android.text.style.ClickableSpan implements android.text.ParcelableSpan {

/**
 * Constructs a {@link android.text.style.URLSpan URLSpan} from a url string.
 *
 * @param url the url string
 * @apiSince 1
 */

public URLSpan(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@link android.text.style.URLSpan URLSpan} from a parcel.
 
 * @param src This value must never be {@code null}.
 * @apiSince 3
 */

public URLSpan(@androidx.annotation.NonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param dest This value must never be {@code null}.
 * @apiSince 3
 */

public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Get the url string for this span.
 *
 * @return the url string.
 * @apiSince 1
 */

public java.lang.String getURL() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onClick(android.view.View widget) { throw new RuntimeException("Stub!"); }
}

