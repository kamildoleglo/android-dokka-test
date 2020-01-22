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


/**
 * System API to the overall text services, which arbitrates interaction between applications
 * and text services.
 *
 * The user can change the current text services in Settings. And also applications can specify
 * the target text services.
 *
 * <h3>Architecture Overview</h3>
 *
 * <p>There are three primary parties involved in the text services
 * framework (TSF) architecture:</p>
 *
 * <ul>
 * <li> The <strong>text services manager</strong> as expressed by this class
 * is the central point of the system that manages interaction between all
 * other parts.  It is expressed as the client-side API here which exists
 * in each application context and communicates with a global system service
 * that manages the interaction across all processes.
 * <li> A <strong>text service</strong> implements a particular
 * interaction model allowing the client application to retrieve information of text.
 * The system binds to the current text service that is in use, causing it to be created and run.
 * <li> Multiple <strong>client applications</strong> arbitrate with the text service
 * manager for connections to text services.
 * </ul>
 *
 * <h3>Text services sessions</h3>
 * <ul>
 * <li>The <strong>spell checker session</strong> is one of the text services.
 * {@link android.view.textservice.SpellCheckerSession}</li>
 * </ul>
 *
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TextServicesManager {

private TextServicesManager() { throw new RuntimeException("Stub!"); }

/**
 * Get a spell checker session for the specified spell checker
 * @param locale the locale for the spell checker. If {@code locale} is null and
 * referToSpellCheckerLanguageSettings is true, the locale specified in Settings will be
 * returned. If {@code locale} is not null and referToSpellCheckerLanguageSettings is true,
 * the locale specified in Settings will be returned only when it is same as {@code locale}.
 * Exceptionally, when referToSpellCheckerLanguageSettings is true and {@code locale} is
 * only language (e.g. "en"), the specified locale in Settings (e.g. "en_US") will be
 * selected.
 * @param listener a spell checker session lister for getting results from a spell checker.
 * @param referToSpellCheckerLanguageSettings if true, the session for one of enabled
 * languages in settings will be returned.
 * @return the spell checker session of the spell checker
 * @apiSince 14
 */

public android.view.textservice.SpellCheckerSession newSpellCheckerSession(android.os.Bundle bundle, java.util.Locale locale, android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener listener, boolean referToSpellCheckerLanguageSettings) { throw new RuntimeException("Stub!"); }
}

