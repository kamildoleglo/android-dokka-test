/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


package android.view.textservice;

import android.text.ParcelableSpan;
import android.os.Parcel;

/**
 * This class contains a metadata of the input of TextService
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TextInfo implements android.os.Parcelable {

/**
 * Constructor.
 * @param text the text which will be input to TextService
 * @apiSince 14
 */

public TextInfo(java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 * @param text the text which will be input to TextService
 * @param cookie the cookie for this TextInfo
 * @param sequenceNumber the sequence number for this TextInfo
 * @apiSince 14
 */

public TextInfo(java.lang.String text, int cookie, int sequenceNumber) { throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 * @param charSequence the text which will be input to TextService. Attached spans that
 * implement {@link android.text.ParcelableSpan ParcelableSpan} will also be marshaled alongside with the text.
 * @param start the beginning of the range of text (inclusive).
 * @param end the end of the range of text (exclusive).
 * @param cookie the cookie for this TextInfo
 * @param sequenceNumber the sequence number for this TextInfo
 * @apiSince 21
 */

public TextInfo(java.lang.CharSequence charSequence, int start, int end, int cookie, int sequenceNumber) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public TextInfo(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link android.os.Parcel Parcel}.
 *
 * @param dest The {@link android.os.Parcel Parcel} to be written.
 * @param flags The flags used for parceling.
 * @apiSince 14
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @return the text which is an input of a text service
 * @apiSince 14
 */

public java.lang.String getText() { throw new RuntimeException("Stub!"); }

/**
 * @return the charSequence which is an input of a text service. This may have some parcelable
 * spans.
 * @apiSince 21
 */

public java.lang.CharSequence getCharSequence() { throw new RuntimeException("Stub!"); }

/**
 * @return the cookie of TextInfo
 * @apiSince 14
 */

public int getCookie() { throw new RuntimeException("Stub!"); }

/**
 * @return the sequence of TextInfo
 * @apiSince 14
 */

public int getSequence() { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 * @apiSince 14
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 * @apiSince 14
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textservice.TextInfo> CREATOR;
static { CREATOR = null; }
}

