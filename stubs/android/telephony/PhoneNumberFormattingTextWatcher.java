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


package android.telephony;


/**
 * Watches a {@link android.widget.TextView} and if a phone number is entered
 * will format it.
 * <p>
 * Stop formatting when the user
 * <ul>
 * <li>Inputs non-dialable characters</li>
 * <li>Removes the separator in the middle of string.</li>
 * </ul>
 * <p>
 * The formatting will be restarted once the text is cleared.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PhoneNumberFormattingTextWatcher implements android.text.TextWatcher {

/**
 * The formatting is based on the current system locale and future locale changes
 * may not take effect on this instance.
 * @apiSince 1
 */

public PhoneNumberFormattingTextWatcher() { throw new RuntimeException("Stub!"); }

/**
 * The formatting is based on the given <code>countryCode</code>.
 *
 * @param countryCode the ISO 3166-1 two-letter country code that indicates the country/region
 * where the phone number is being entered.
 * @apiSince 21
 */

public PhoneNumberFormattingTextWatcher(java.lang.String countryCode) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void beforeTextChanged(java.lang.CharSequence s, int start, int count, int after) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onTextChanged(java.lang.CharSequence s, int start, int before, int count) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public synchronized void afterTextChanged(android.text.Editable s) { throw new RuntimeException("Stub!"); }
}

