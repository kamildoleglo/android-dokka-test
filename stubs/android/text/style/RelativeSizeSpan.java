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
 * Uniformly scales the size of the text to which it's attached by a certain proportion.
 * <p>
 * For example, a <code>RelativeSizeSpan</code> that increases the text size by 50% can be
 * constructed like this:
 * <pre>{@code
 *  SpannableString string = new SpannableString("Text with relative size span");
 *string.setSpan(new RelativeSizeSpan(1.5f), 10, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/relativesizespan.png" />
 * <figcaption>Text increased by 50% with <code>RelativeSizeSpan</code>.</figcaption>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RelativeSizeSpan extends android.text.style.MetricAffectingSpan implements android.text.ParcelableSpan {

/**
 * Creates a {@link android.text.style.RelativeSizeSpan RelativeSizeSpan} based on a proportion.
 *
 * @param proportion the proportion with which the text is scaled.
 
 * Value is 0 or greater
 * @apiSince 1
 */

public RelativeSizeSpan(float proportion) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.text.style.RelativeSizeSpan RelativeSizeSpan} from a parcel.
 
 * @param src This value must never be {@code null}.
 * @apiSince 3
 */

public RelativeSizeSpan(@androidx.annotation.NonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

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
 * @return the proportion with which the text size is changed.
 * @apiSince 1
 */

public float getSizeChange() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param ds This value must never be {@code null}.
 * @apiSince 1
 */

public void updateDrawState(@androidx.annotation.NonNull android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param ds This value must never be {@code null}.
 * @apiSince 1
 */

public void updateMeasureState(@androidx.annotation.NonNull android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }
}

