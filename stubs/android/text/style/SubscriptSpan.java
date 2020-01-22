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


/**
 * The span that moves the position of the text baseline lower.
 * <p>
 * The span can be used like this:
 * <pre>{@code
 *  SpannableString string = new SpannableString("☕- C8H10N4O2\n");
 *string.setSpan(new SubscriptSpan(), 4, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
 *string.setSpan(new SubscriptSpan(), 6, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
 *string.setSpan(new SubscriptSpan(), 9, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
 *string.setSpan(new SubscriptSpan(), 11, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/subscriptspan.png" />
 * <figcaption>Text with <code>SubscriptSpan</code>.</figcaption>
 * Note: Since the span affects the position of the text, if the text is on the last line of a
 * TextView, it may appear cut.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SubscriptSpan extends android.text.style.MetricAffectingSpan implements android.text.ParcelableSpan {

/**
 * Creates a {@link android.text.style.SubscriptSpan SubscriptSpan}.
 * @apiSince 1
 */

public SubscriptSpan() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.text.style.SubscriptSpan SubscriptSpan} from a parcel.
 
 * @param src This value must never be {@code null}.
 * @apiSince 3
 */

public SubscriptSpan(@androidx.annotation.NonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param textPaint This value must never be {@code null}.
 * @apiSince 1
 */

public void updateDrawState(@androidx.annotation.NonNull android.text.TextPaint textPaint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param textPaint This value must never be {@code null}.
 * @apiSince 1
 */

public void updateMeasureState(@androidx.annotation.NonNull android.text.TextPaint textPaint) { throw new RuntimeException("Stub!"); }
}

