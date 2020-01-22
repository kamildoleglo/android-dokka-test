/*
 * Copyright (C) 2012 The Android Open Source Project
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
 * The media route action provider displays a {@link android.app.MediaRouteButton MediaRouteButton}
 * in the application's {@link android.app.ActionBar ActionBar} to allow the user to select routes and
 * to control the currently selected route.
 * <p>
 * The application must specify the kinds of routes that the user should be allowed
 * to select by specifying the route types with the {@link #setRouteTypes} method.
 * </p><p>
 * Refer to {@link android.app.MediaRouteButton MediaRouteButton} for a description of the button that will
 * appear in the action bar menu.  Note that instead of disabling the button
 * when no routes are available, the action provider will instead make the
 * menu item invisible.  In this way, the button will only be visible when it
 * is possible for the user to discover and select a matching route.
 * </p>
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MediaRouteActionProvider extends android.view.ActionProvider {

/** @apiSince 16 */

public MediaRouteActionProvider(android.content.Context context) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Sets the types of routes that will be shown in the media route chooser dialog
 * launched by this button.
 *
 * @param types The route types to match.
 * @apiSince 16
 */

public void setRouteTypes(int types) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void setExtendedSettingsClickListener(android.view.View.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public android.view.View onCreateActionView() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public android.view.View onCreateActionView(android.view.MenuItem item) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public boolean onPerformDefaultAction() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public boolean overridesItemVisibility() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public boolean isVisible() { throw new RuntimeException("Stub!"); }
}

