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


package android.view;

import org.xmlpull.v1.XmlPullParser;
import android.app.Activity;

/**
 * This class is used to instantiate menu XML files into Menu objects.
 * <p>
 * For performance reasons, menu inflation relies heavily on pre-processing of
 * XML files that is done at build time. Therefore, it is not currently possible
 * to use MenuInflater with an XmlPullParser over a plain XML file at runtime;
 * it only works with an XmlPullParser returned from a compiled resource (R.
 * <em>something</em> file.)
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MenuInflater {

/**
 * Constructs a menu inflater.
 *
 * @see android.app.Activity#getMenuInflater()
 * @apiSince 1
 */

public MenuInflater(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Inflate a menu hierarchy from the specified XML resource. Throws
 * {@link android.view.InflateException InflateException} if there is an error.
 *
 * @param menuRes Resource ID for an XML layout resource to load (e.g.,
 *            <code>R.menu.main_activity</code>)
 * @param menu The Menu to inflate into. The items and submenus will be
 *            added to this Menu.
 * @apiSince 1
 */

public void inflate(int menuRes, android.view.Menu menu) { throw new RuntimeException("Stub!"); }
}

