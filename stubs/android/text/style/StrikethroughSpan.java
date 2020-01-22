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
 * A span that strikes through the text it's attached to.
 * <p>
 * The span can be used like this:
 * <pre>{@code
 * SpannableString string = new SpannableString("Text with strikethrough span");
 *string.setSpan(new StrikethroughSpan(), 10, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/strikethroughspan.png" />
 * <figcaption>Strikethrough text.</figcaption>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StrikethroughSpan extends android.text.style.CharacterStyle implements android.text.style.UpdateAppearance, android.text.ParcelableSpan {

/**
 * Creates a {@link android.text.style.StrikethroughSpan StrikethroughSpan}.
 * @apiSince 1
 */

public StrikethroughSpan() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.text.style.StrikethroughSpan StrikethroughSpan} from a parcel.
 
 * @param src This value must never be {@code null}.
 * @apiSince 3
 */

public StrikethroughSpan(@androidx.annotation.NonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

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
 * {@inheritDoc}

 * @param ds This value must never be {@code null}.
 * @apiSince 1
 */

public void updateDrawState(@androidx.annotation.NonNull android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }
}

