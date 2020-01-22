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

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.content.res.Resources;
import android.view.WindowManager;

/**
 * Base class for presentations.
 * <p>
 * A presentation is a special kind of dialog whose purpose is to present
 * content on a secondary display.  A {@link android.app.Presentation Presentation} is associated with
 * the target {@link android.view.Display Display} at creation time and configures its context and
 * resource configuration according to the display's metrics.
 * </p><p>
 * Notably, the {@link android.content.Context Context} of a presentation is different from the context
 * of its containing {@link android.app.Activity Activity}.  It is important to inflate the layout
 * of a presentation and load other resources using the presentation's own context
 * to ensure that assets of the correct size and density for the target display
 * are loaded.
 * </p><p>
 * A presentation is automatically canceled (see {@link android.app.Dialog#cancel() Dialog#cancel()}) when
 * the display to which it is attached is removed.  An activity should take
 * care of pausing and resuming whatever content is playing within the presentation
 * whenever the activity itself is paused or resumed.
 * </p>
 *
 * <h3>Choosing a presentation display</h3>
 * <p>
 * Before showing a {@link android.app.Presentation Presentation} it's important to choose the {@link android.view.Display Display}
 * on which it will appear.  Choosing a presentation display is sometimes difficult
 * because there may be multiple displays attached.  Rather than trying to guess
 * which display is best, an application should let the system choose a suitable
 * presentation display.
 * </p><p>
 * There are two main ways to choose a {@link android.view.Display Display}.
 * </p>
 *
 * <h4>Using the media router to choose a presentation display</h4>
 * <p>
 * The easiest way to choose a presentation display is to use the
 * {@link android.media.MediaRouter MediaRouter} API.  The media router service keeps
 * track of which audio and video routes are available on the system.
 * The media router sends notifications whenever routes are selected or unselected
 * or when the preferred presentation display of a route changes.
 * So an application can simply watch for these notifications and show or dismiss
 * a presentation on the preferred presentation display automatically.
 * </p><p>
 * The preferred presentation display is the display that the media router recommends
 * that the application should use if it wants to show content on the secondary display.
 * Sometimes there may not be a preferred presentation display in which
 * case the application should show its content locally without using a presentation.
 * </p><p>
 * Here's how to use the media router to create and show a presentation on the preferred
 * presentation display using {@link android.media.MediaRouter.RouteInfo#getPresentationDisplay()}.
 * </p>
 * <pre>
 * MediaRouter mediaRouter = (MediaRouter) context.getSystemService(Context.MEDIA_ROUTER_SERVICE);
 * MediaRouter.RouteInfo route = mediaRouter.getSelectedRoute();
 * if (route != null) {
 *     Display presentationDisplay = route.getPresentationDisplay();
 *     if (presentationDisplay != null) {
 *         Presentation presentation = new MyPresentation(context, presentationDisplay);
 *         presentation.show();
 *     }
 * }</pre>
 * <p>
 * The following sample code from <code>ApiDemos</code> demonstrates how to use the media
 * router to automatically switch between showing content in the main activity and showing
 * the content in a presentation when a presentation display is available.
 * </p>
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/PresentationWithMediaRouterActivity.java
 *      activity}
 *
 * <h4>Using the display manager to choose a presentation display</h4>
 * <p>
 * Another way to choose a presentation display is to use the {@link android.hardware.display.DisplayManager DisplayManager} API
 * directly.  The display manager service provides functions to enumerate and describe all
 * displays that are attached to the system including displays that may be used
 * for presentations.
 * </p><p>
 * The display manager keeps track of all displays in the system.  However, not all
 * displays are appropriate for showing presentations.  For example, if an activity
 * attempted to show a presentation on the main display it might obscure its own content
 * (it's like opening a dialog on top of your activity).
 * </p><p>
 * Here's how to identify suitable displays for showing presentations using
 * {@link android.hardware.display.DisplayManager#getDisplays(java.lang.String) DisplayManager#getDisplays(String)} and the
 * {@link android.hardware.display.DisplayManager#DISPLAY_CATEGORY_PRESENTATION DisplayManager#DISPLAY_CATEGORY_PRESENTATION} category.
 * </p>
 * <pre>
 * DisplayManager displayManager = (DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE);
 * Display[] presentationDisplays = displayManager.getDisplays(DisplayManager.DISPLAY_CATEGORY_PRESENTATION);
 * if (presentationDisplays.length > 0) {
 *     // If there is more than one suitable presentation display, then we could consider
 *     // giving the user a choice.  For this example, we simply choose the first display
 *     // which is the one the system recommends as the preferred presentation display.
 *     Display display = presentationDisplays[0];
 *     Presentation presentation = new MyPresentation(context, presentationDisplay);
 *     presentation.show();
 * }</pre>
 * <p>
 * The following sample code from <code>ApiDemos</code> demonstrates how to use the display
 * manager to enumerate displays and show content on multiple presentation displays
 * simultaneously.
 * </p>
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/PresentationActivity.java
 *      activity}
 *
 * @see android.media.MediaRouter#ROUTE_TYPE_LIVE_VIDEO for information on about live
 * video routes and how to obtain the preferred presentation display for the
 * current media route.
 * @see android.hardware.display.DisplayManager for information on how to enumerate displays and receive
 * notifications when displays are added or removed.
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Presentation extends android.app.Dialog {

/**
 * Creates a new presentation that is attached to the specified display
 * using the default theme.
 *
 * @param outerContext The context of the application that is showing the presentation.
 * The presentation will create its own context (see {@link #getContext()}) based
 * on this context and information about the associated display.
 * @param display The display to which the presentation should be attached.
 * @apiSince 17
 */

public Presentation(android.content.Context outerContext, android.view.Display display) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new presentation that is attached to the specified display
 * using the optionally specified theme.
 *
 * @param outerContext The context of the application that is showing the presentation.
 * The presentation will create its own context (see {@link #getContext()}) based
 * on this context and information about the associated display.
 * @param display The display to which the presentation should be attached.
 * @param theme A style resource describing the theme to use for the window.
 * See <a href="{@docRoot}guide/topics/resources/available-resources.html#stylesandthemes">
 * Style and Theme Resources</a> for more information about defining and using
 * styles.  This theme is applied on top of the current theme in
 * <var>outerContext</var>.  If 0, the default presentation theme will be used.
 * @apiSince 17
 */

public Presentation(android.content.Context outerContext, android.view.Display display, int theme) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.view.Display Display} that this presentation appears on.
 *
 * @return The display.
 * @apiSince 17
 */

public android.view.Display getDisplay() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.content.res.Resources Resources} that should be used to inflate the layout of this presentation.
 * This resources object has been configured according to the metrics of the
 * display that the presentation appears on.
 *
 * @return The presentation resources object.
 * @apiSince 17
 */

public android.content.res.Resources getResources() { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

protected void onStart() { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

protected void onStop() { throw new RuntimeException("Stub!"); }

/**
 * Inherited from {@link android.app.Dialog#show Dialog#show}. Will throw
 * {@link android.view.WindowManager.InvalidDisplayException} if the specified secondary
 * {@link android.view.Display Display} can't be found.
 * @apiSince 17
 */

public void show() { throw new RuntimeException("Stub!"); }

/**
 * Called by the system when the {@link android.view.Display Display} to which the presentation
 * is attached has been removed.
 *
 * The system automatically calls {@link #cancel} to dismiss the presentation
 * after sending this event.
 *
 * @see #getDisplay
 * @apiSince 17
 */

public void onDisplayRemoved() { throw new RuntimeException("Stub!"); }

/**
 * Called by the system when the properties of the {@link android.view.Display Display} to which
 * the presentation is attached have changed.
 *
 * If the display metrics have changed (for example, if the display has been
 * resized or rotated), then the system automatically calls
 * {@link #cancel} to dismiss the presentation.
 *
 * @see #getDisplay
 * @apiSince 17
 */

public void onDisplayChanged() { throw new RuntimeException("Stub!"); }
}

