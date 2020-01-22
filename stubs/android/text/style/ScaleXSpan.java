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
 * Scales horizontally the size of the text to which it's attached by a certain factor.
 * <p>
 * Values > 1.0 will stretch the text wider. Values < 1.0 will stretch the text narrower.
 * <p>
 * For example, a <code>ScaleXSpan</code> that stretches the text size by 100% can be
 * constructed like this:
 * <pre>{@code
 * SpannableString string = new SpannableString("Text with ScaleX span");
 *string.setSpan(new ScaleXSpan(2f), 10, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/scalexspan.png" />
 * <figcaption>Text scaled by 100% with <code>ScaleXSpan</code>.</figcaption>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ScaleXSpan extends android.text.style.MetricAffectingSpan implements android.text.ParcelableSpan {

/**
 * Creates a {@link android.text.style.ScaleXSpan ScaleXSpan} based on a proportion. Values > 1.0 will stretch the text wider.
 * Values < 1.0 will stretch the text narrower.
 *
 * @param proportion the horizontal scale factor.
 
 * Value is 0 or greater
 * @apiSince 1
 */

public ScaleXSpan(float proportion) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.text.style.ScaleXSpan ScaleXSpan} from a parcel.
 
 * @param src This value must never be {@code null}.
 * @apiSince 3
 */

public ScaleXSpan(@androidx.annotation.NonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

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
 * Get the horizontal scale factor for the text.
 *
 * @return the horizontal scale factor.
 * @apiSince 1
 */

public float getScaleX() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void updateDrawState(android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void updateMeasureState(android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }
}

