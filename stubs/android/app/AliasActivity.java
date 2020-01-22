/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.app;


/**
 * Stub activity that launches another activity (and then finishes itself)
 * based on information in its component's manifest meta-data.  This is a
 * simple way to implement an alias-like mechanism.
 *
 * To use this activity, you should include in the manifest for the associated
 * component an entry named "android.app.alias".  It is a reference to an XML
 * resource describing an intent that launches the real application.
 *
 * @deprecated Use {@code <activity-alias>} or subclass Activity directly.
 * @apiSince 1
 * @deprecatedSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class AliasActivity extends android.app.Activity {

@Deprecated
public AliasActivity() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
protected void onCreate(android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }
}

