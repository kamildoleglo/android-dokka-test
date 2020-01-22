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

import android.os.Parcel;

/**
 * This class contains a metadata of suggestions from the text service
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SuggestionsInfo implements android.os.Parcelable {

/**
 * Constructor.
 * @param suggestionsAttributes from the text service
 * @param suggestions from the text service
 * @apiSince 14
 */

public SuggestionsInfo(int suggestionsAttributes, java.lang.String[] suggestions) { throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 * @param suggestionsAttributes from the text service
 * @param suggestions from the text service
 * @param cookie the cookie of the input TextInfo
 * @param sequence the cookie of the input TextInfo
 * @apiSince 14
 */

public SuggestionsInfo(int suggestionsAttributes, java.lang.String[] suggestions, int cookie, int sequence) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public SuggestionsInfo(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link android.os.Parcel Parcel}.
 *
 * @param dest The {@link android.os.Parcel Parcel} to be written.
 * @param flags The flags used for parceling.
 * @apiSince 14
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Set the cookie and the sequence of SuggestionsInfo which are set to TextInfo from a client
 * application
 * @param cookie the cookie of an input TextInfo
 * @param sequence the cookie of an input TextInfo
 * @apiSince 14
 */

public void setCookieAndSequence(int cookie, int sequence) { throw new RuntimeException("Stub!"); }

/**
 * @return the cookie which may be set by a client application
 * @apiSince 14
 */

public int getCookie() { throw new RuntimeException("Stub!"); }

/**
 * @return the sequence which may be set by a client application
 * @apiSince 14
 */

public int getSequence() { throw new RuntimeException("Stub!"); }

/**
 * @return the attributes of suggestions. This includes whether the spell checker has the word
 * in its dictionary or not and whether the spell checker has confident suggestions for the
 * word or not.
 * @apiSince 14
 */

public int getSuggestionsAttributes() { throw new RuntimeException("Stub!"); }

/**
 * @return the count of the suggestions. If there's no suggestions at all, this method returns
 * -1. Even if this method returns 0, it doesn't necessarily mean that there are no suggestions
 * for the requested word. For instance, the caller could have been asked to limit the maximum
 * number of suggestions returned.
 * @apiSince 14
 */

public int getSuggestionsCount() { throw new RuntimeException("Stub!"); }

/**
 * @param i the id of suggestions
 * @return the suggestion at the specified id
 * @apiSince 14
 */

public java.lang.String getSuggestionAt(int i) { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 * @apiSince 14
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 * @apiSince 14
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textservice.SuggestionsInfo> CREATOR;
static { CREATOR = null; }

/**
 * Flag of the attributes of the suggestions that can be obtained by
 * {@link #getSuggestionsAttributes}: this tells that the text service thinks
 * the result suggestions include highly recommended ones.
 * @apiSince 15
 */

public static final int RESULT_ATTR_HAS_RECOMMENDED_SUGGESTIONS = 4; // 0x4

/**
 * Flag of the attributes of the suggestions that can be obtained by
 * {@link #getSuggestionsAttributes}: this tells that the requested word was found
 * in the dictionary in the text service.
 * @apiSince 14
 */

public static final int RESULT_ATTR_IN_THE_DICTIONARY = 1; // 0x1

/**
 * Flag of the attributes of the suggestions that can be obtained by
 * {@link #getSuggestionsAttributes}: this tells that the text service thinks the requested
 * word looks like a typo.
 * @apiSince 14
 */

public static final int RESULT_ATTR_LOOKS_LIKE_TYPO = 2; // 0x2
}

