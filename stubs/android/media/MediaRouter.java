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


package android.media;

import android.content.Context;
import android.view.Display;
import java.util.List;

/**
 * MediaRouter allows applications to control the routing of media channels
 * and streams from the current device to external speakers and destination devices.
 *
 * <p>A MediaRouter is retrieved through {@link android.content.Context#getSystemService(java.lang.String) Context#getSystemService(String)} of a {@link android.content.Context#MEDIA_ROUTER_SERVICE Context#MEDIA_ROUTER_SERVICE}.
 *
 * <p>The media router API is not thread-safe; all interactions with it must be
 * done from the main thread of the process.</p>
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MediaRouter {

MediaRouter() { throw new RuntimeException("Stub!"); }

/**
 * Gets the default route for playing media content on the system.
 * <p>
 * The system always provides a default route.
 * </p>
 *
 * @return The default route, which is guaranteed to never be null.
 * @apiSince 18
 */

public android.media.MediaRouter.RouteInfo getDefaultRoute() { throw new RuntimeException("Stub!"); }

/**
 * Return the currently selected route for any of the given types
 *
 * @param type route types
 * @return the selected route
 * @apiSince 16
 */

public android.media.MediaRouter.RouteInfo getSelectedRoute(int type) { throw new RuntimeException("Stub!"); }

/**
 * Add a callback to listen to events about specific kinds of media routes.
 * If the specified callback is already registered, its registration will be updated for any
 * additional route types specified.
 * <p>
 * This is a convenience method that has the same effect as calling
 * {@link #addCallback(int,android.media.MediaRouter.Callback,int)} without flags.
 * </p>
 *
 * @param types Types of routes this callback is interested in
 * @param cb Callback to add
 * @apiSince 16
 */

public void addCallback(int types, android.media.MediaRouter.Callback cb) { throw new RuntimeException("Stub!"); }

/**
 * Add a callback to listen to events about specific kinds of media routes.
 * If the specified callback is already registered, its registration will be updated for any
 * additional route types specified.
 * <p>
 * By default, the callback will only be invoked for events that affect routes
 * that match the specified selector.  The filtering may be disabled by specifying
 * the {@link #CALLBACK_FLAG_UNFILTERED_EVENTS} flag.
 * </p>
 *
 * @param types Types of routes this callback is interested in
 * @param cb Callback to add
 * @param flags Flags to control the behavior of the callback.
 * May be zero or a combination of {@link #CALLBACK_FLAG_PERFORM_ACTIVE_SCAN} and
 * {@link #CALLBACK_FLAG_UNFILTERED_EVENTS}.
 * @apiSince 18
 */

public void addCallback(int types, android.media.MediaRouter.Callback cb, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Remove the specified callback. It will no longer receive events about media routing.
 *
 * @param cb Callback to remove
 * @apiSince 16
 */

public void removeCallback(android.media.MediaRouter.Callback cb) { throw new RuntimeException("Stub!"); }

/**
 * Select the specified route to use for output of the given media types.
 * <p class="note">
 * As API version 18, this function may be used to select any route.
 * In prior versions, this function could only be used to select user
 * routes and would ignore any attempt to select a system route.
 * </p>
 *
 * @param types type flags indicating which types this route should be used for.
 *              The route must support at least a subset.
 * @param route Route to select
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the given route is {@code null}
 * @apiSince 16
 */

public void selectRoute(int types, @androidx.annotation.NonNull android.media.MediaRouter.RouteInfo route) { throw new RuntimeException("Stub!"); }

/**
 * Add an app-specified route for media to the MediaRouter.
 * App-specified route definitions are created using {@link #createUserRoute(android.media.MediaRouter.RouteCategory)}
 *
 * @param info Definition of the route to add
 * @see #createUserRoute(RouteCategory)
 * @see #removeUserRoute(UserRouteInfo)
 * @apiSince 16
 */

public void addUserRoute(android.media.MediaRouter.UserRouteInfo info) { throw new RuntimeException("Stub!"); }

/**
 * Remove an app-specified route for media from the MediaRouter.
 *
 * @param info Definition of the route to remove
 * @see #addUserRoute(UserRouteInfo)
 * @apiSince 16
 */

public void removeUserRoute(android.media.MediaRouter.UserRouteInfo info) { throw new RuntimeException("Stub!"); }

/**
 * Remove all app-specified routes from the MediaRouter.
 *
 * @see #removeUserRoute(UserRouteInfo)
 * @apiSince 16
 */

public void clearUserRoutes() { throw new RuntimeException("Stub!"); }

/**
 * Return the number of {@link android.media.MediaRouter.RouteCategory MediaRouter.RouteCategory} currently
 * represented by routes known to this MediaRouter.
 *
 * @return the number of unique categories represented by this MediaRouter's known routes
 * @apiSince 16
 */

public int getCategoryCount() { throw new RuntimeException("Stub!"); }

/**
 * Return the {@link android.media.MediaRouter.RouteCategory MediaRouter.RouteCategory} at the given index.
 * Valid indices are in the range [0-getCategoryCount).
 *
 * @param index which category to return
 * @return the category at index
 * @apiSince 16
 */

public android.media.MediaRouter.RouteCategory getCategoryAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of {@link android.media.MediaRouter.RouteInfo MediaRouter.RouteInfo} currently known
 * to this MediaRouter.
 *
 * @return the number of routes tracked by this router
 * @apiSince 16
 */

public int getRouteCount() { throw new RuntimeException("Stub!"); }

/**
 * Return the route at the specified index.
 *
 * @param index index of the route to return
 * @return the route at index
 * @apiSince 16
 */

public android.media.MediaRouter.RouteInfo getRouteAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Create a new user route that may be modified and registered for use by the application.
 *
 * @param category The category the new route will belong to
 * @return A new UserRouteInfo for use by the application
 *
 * @see #addUserRoute(UserRouteInfo)
 * @see #removeUserRoute(UserRouteInfo)
 * @see #createRouteCategory(CharSequence, boolean)
 * @apiSince 16
 */

public android.media.MediaRouter.UserRouteInfo createUserRoute(android.media.MediaRouter.RouteCategory category) { throw new RuntimeException("Stub!"); }

/**
 * Create a new route category. Each route must belong to a category.
 *
 * @param name Name of the new category
 * @param isGroupable true if routes in this category may be grouped with one another
 * @return the new RouteCategory
 * @apiSince 16
 */

public android.media.MediaRouter.RouteCategory createRouteCategory(java.lang.CharSequence name, boolean isGroupable) { throw new RuntimeException("Stub!"); }

/**
 * Create a new route category. Each route must belong to a category.
 *
 * @param nameResId Resource ID of the name of the new category
 * @param isGroupable true if routes in this category may be grouped with one another
 * @return the new RouteCategory
 * @apiSince 16
 */

public android.media.MediaRouter.RouteCategory createRouteCategory(int nameResId, boolean isGroupable) { throw new RuntimeException("Stub!"); }

/**
 * Flag for {@link #addCallback}: Actively scan for routes while this callback
 * is registered.
 * <p>
 * When this flag is specified, the media router will actively scan for new
 * routes.  Certain routes, such as wifi display routes, may not be discoverable
 * except when actively scanning.  This flag is typically used when the route picker
 * dialog has been opened by the user to ensure that the route information is
 * up to date.
 * </p><p>
 * Active scanning may consume a significant amount of power and may have intrusive
 * effects on wireless connectivity.  Therefore it is important that active scanning
 * only be requested when it is actually needed to satisfy a user request to
 * discover and select a new route.
 * </p>
 * @apiSince 18
 */

public static final int CALLBACK_FLAG_PERFORM_ACTIVE_SCAN = 1; // 0x1

/**
 * Flag for {@link #addCallback}: Do not filter route events.
 * <p>
 * When this flag is specified, the callback will be invoked for event that affect any
 * route even if they do not match the callback's filter.
 * </p>
 * @apiSince 18
 */

public static final int CALLBACK_FLAG_UNFILTERED_EVENTS = 2; // 0x2

/**
 * Route type flag for live audio.
 *
 * <p>A device that supports live audio routing will allow the media audio stream
 * to be routed to supported destinations. This can include internal speakers or
 * audio jacks on the device itself, A2DP devices, and more.</p>
 *
 * <p>Once initiated this routing is transparent to the application. All audio
 * played on the media stream will be routed to the selected destination.</p>
 * @apiSince 16
 */

public static final int ROUTE_TYPE_LIVE_AUDIO = 1; // 0x1

/**
 * Route type flag for live video.
 *
 * <p>A device that supports live video routing will allow a mirrored version
 * of the device's primary display or a customized
 * {@link android.app.Presentation Presentation} to be routed to supported destinations.</p>
 *
 * <p>Once initiated, display mirroring is transparent to the application.
 * While remote routing is active the application may use a
 * {@link android.app.Presentation Presentation} to replace the mirrored view
 * on the external display with different content.</p>
 *
 * @see android.media.MediaRouter.RouteInfo#getPresentationDisplay()
 * @see android.app.Presentation
 * @apiSince 17
 */

public static final int ROUTE_TYPE_LIVE_VIDEO = 2; // 0x2

/**
 * Route type flag for application-specific usage.
 *
 * <p>Unlike other media route types, user routes are managed by the application.
 * The MediaRouter will manage and dispatch events for user routes, but the application
 * is expected to interpret the meaning of these events and perform the requested
 * routing tasks.</p>
 * @apiSince 16
 */

public static final int ROUTE_TYPE_USER = 8388608; // 0x800000
/**
 * Interface for receiving events about media routing changes.
 * All methods of this interface will be called from the application's main thread.
 * <p>
 * A Callback will only receive events relevant to routes that the callback
 * was registered for unless the {@link android.media.MediaRouter#CALLBACK_FLAG_UNFILTERED_EVENTS MediaRouter#CALLBACK_FLAG_UNFILTERED_EVENTS}
 * flag was specified in {@link android.media.MediaRouter#addCallback(int,android.media.MediaRouter.Callback,int) MediaRouter#addCallback(int, Callback, int)}.
 * </p>
 *
 * @see android.media.MediaRouter#addCallback(int, Callback, int)
 * @see android.media.MediaRouter#removeCallback(Callback)
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Called when the supplied route becomes selected as the active route
 * for the given route type.
 *
 * @param router the MediaRouter reporting the event
 * @param type Type flag set indicating the routes that have been selected
 * @param info Route that has been selected for the given route types
 * @apiSince 16
 */

public abstract void onRouteSelected(android.media.MediaRouter router, int type, android.media.MediaRouter.RouteInfo info);

/**
 * Called when the supplied route becomes unselected as the active route
 * for the given route type.
 *
 * @param router the MediaRouter reporting the event
 * @param type Type flag set indicating the routes that have been unselected
 * @param info Route that has been unselected for the given route types
 * @apiSince 16
 */

public abstract void onRouteUnselected(android.media.MediaRouter router, int type, android.media.MediaRouter.RouteInfo info);

/**
 * Called when a route for the specified type was added.
 *
 * @param router the MediaRouter reporting the event
 * @param info Route that has become available for use
 * @apiSince 16
 */

public abstract void onRouteAdded(android.media.MediaRouter router, android.media.MediaRouter.RouteInfo info);

/**
 * Called when a route for the specified type was removed.
 *
 * @param router the MediaRouter reporting the event
 * @param info Route that has been removed from availability
 * @apiSince 16
 */

public abstract void onRouteRemoved(android.media.MediaRouter router, android.media.MediaRouter.RouteInfo info);

/**
 * Called when an aspect of the indicated route has changed.
 *
 * <p>This will not indicate that the types supported by this route have
 * changed, only that cosmetic info such as name or status have been updated.</p>
 *
 * @param router the MediaRouter reporting the event
 * @param info The route that was changed
 * @apiSince 16
 */

public abstract void onRouteChanged(android.media.MediaRouter router, android.media.MediaRouter.RouteInfo info);

/**
 * Called when a route is added to a group.
 *
 * @param router the MediaRouter reporting the event
 * @param info The route that was added
 * @param group The group the route was added to
 * @param index The route index within group that info was added at
 * @apiSince 16
 */

public abstract void onRouteGrouped(android.media.MediaRouter router, android.media.MediaRouter.RouteInfo info, android.media.MediaRouter.RouteGroup group, int index);

/**
 * Called when a route is removed from a group.
 *
 * @param router the MediaRouter reporting the event
 * @param info The route that was removed
 * @param group The group the route was removed from
 * @apiSince 16
 */

public abstract void onRouteUngrouped(android.media.MediaRouter router, android.media.MediaRouter.RouteInfo info, android.media.MediaRouter.RouteGroup group);

/**
 * Called when a route's volume changes.
 *
 * @param router the MediaRouter reporting the event
 * @param info The route with altered volume
 * @apiSince 16
 */

public abstract void onRouteVolumeChanged(android.media.MediaRouter router, android.media.MediaRouter.RouteInfo info);

/**
 * Called when a route's presentation display changes.
 * <p>
 * This method is called whenever the route's presentation display becomes
 * available, is removes or has changes to some of its properties (such as its size).
 * </p>
 *
 * @param router the MediaRouter reporting the event
 * @param info The route whose presentation display changed
 *
 * @see android.media.MediaRouter.RouteInfo#getPresentationDisplay()
 * @apiSince 17
 */

public void onRoutePresentationDisplayChanged(android.media.MediaRouter router, android.media.MediaRouter.RouteInfo info) { throw new RuntimeException("Stub!"); }
}

/**
 * Definition of a category of routes. All routes belong to a category.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class RouteCategory {

RouteCategory() { throw new RuntimeException("Stub!"); }

/**
 * @return the name of this route category
 * @apiSince 16
 */

public java.lang.CharSequence getName() { throw new RuntimeException("Stub!"); }

/**
 * Return the properly localized/configuration dependent name of this RouteCategory.
 *
 * @param context Context to resolve name resources
 * @return the name of this route category
 * @apiSince 16
 */

public java.lang.CharSequence getName(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Return the current list of routes in this category that have been added
 * to the MediaRouter.
 *
 * <p>This list will not include routes that are nested within RouteGroups.
 * A RouteGroup is treated as a single route within its category.</p>
 *
 * @param out a List to fill with the routes in this category. If this parameter is
 *            non-null, it will be cleared, filled with the current routes with this
 *            category, and returned. If this parameter is null, a new List will be
 *            allocated to report the category's current routes.
 * @return A list with the routes in this category that have been added to the MediaRouter.
 * @apiSince 16
 */

public java.util.List<android.media.MediaRouter.RouteInfo> getRoutes(java.util.List<android.media.MediaRouter.RouteInfo> out) { throw new RuntimeException("Stub!"); }

/**
 * @return Flag set describing the route types supported by this category
 * @apiSince 16
 */

public int getSupportedTypes() { throw new RuntimeException("Stub!"); }

/**
 * Return whether or not this category supports grouping.
 *
 * <p>If this method returns true, all routes obtained from this category
 * via calls to {@link #getRouteAt(int)} will be {@link android.media.MediaRouter.RouteGroup MediaRouter.RouteGroup}s.</p>
 *
 * @return true if this category supports
 * @apiSince 16
 */

public boolean isGroupable() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

/**
 * Information about a route that consists of multiple other routes in a group.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class RouteGroup extends android.media.MediaRouter.RouteInfo {

RouteGroup() { throw new RuntimeException("Stub!"); }

/**
 * Add a route to this group. The route must not currently belong to another group.
 *
 * @param route route to add to this group
 * @apiSince 16
 */

public void addRoute(android.media.MediaRouter.RouteInfo route) { throw new RuntimeException("Stub!"); }

/**
 * Add a route to this group before the specified index.
 *
 * @param route route to add
 * @param insertAt insert the new route before this index
 * @apiSince 16
 */

public void addRoute(android.media.MediaRouter.RouteInfo route, int insertAt) { throw new RuntimeException("Stub!"); }

/**
 * Remove a route from this group.
 *
 * @param route route to remove
 * @apiSince 16
 */

public void removeRoute(android.media.MediaRouter.RouteInfo route) { throw new RuntimeException("Stub!"); }

/**
 * Remove the route at the specified index from this group.
 *
 * @param index index of the route to remove
 * @apiSince 16
 */

public void removeRoute(int index) { throw new RuntimeException("Stub!"); }

/**
 * @return The number of routes in this group
 * @apiSince 16
 */

public int getRouteCount() { throw new RuntimeException("Stub!"); }

/**
 * Return the route in this group at the specified index
 *
 * @param index Index to fetch
 * @return The route at index
 * @apiSince 16
 */

public android.media.MediaRouter.RouteInfo getRouteAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Set an icon that will be used to represent this group.
 * The system may use this icon in picker UIs or similar.
 *
 * @param icon icon drawable to use to represent this group
 * @apiSince 16
 */

public void setIconDrawable(android.graphics.drawable.Drawable icon) { throw new RuntimeException("Stub!"); }

/**
 * Set an icon that will be used to represent this group.
 * The system may use this icon in picker UIs or similar.
 *
 * @param resId Resource ID of an icon drawable to use to represent this group
 * @apiSince 16
 */

public void setIconResource(int resId) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void requestSetVolume(int volume) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void requestUpdateVolume(int direction) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

/**
 * Information about a media route.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class RouteInfo {

RouteInfo() { throw new RuntimeException("Stub!"); }

/**
 * Gets the user-visible name of the route.
 * <p>
 * The route name identifies the destination represented by the route.
 * It may be a user-supplied name, an alias, or device serial number.
 * </p>
 *
 * @return The user-visible name of a media route.  This is the string presented
 * to users who may select this as the active route.
 * @apiSince 16
 */

public java.lang.CharSequence getName() { throw new RuntimeException("Stub!"); }

/**
 * Return the properly localized/resource user-visible name of this route.
 * <p>
 * The route name identifies the destination represented by the route.
 * It may be a user-supplied name, an alias, or device serial number.
 * </p>
 *
 * @param context Context used to resolve the correct configuration to load
 * @return The user-visible name of a media route.  This is the string presented
 * to users who may select this as the active route.
 * @apiSince 16
 */

public java.lang.CharSequence getName(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Gets the user-visible description of the route.
 * <p>
 * The route description describes the kind of destination represented by the route.
 * It may be a user-supplied string, a model number or brand of device.
 * </p>
 *
 * @return The description of the route, or null if none.
 * @apiSince 18
 */

public java.lang.CharSequence getDescription() { throw new RuntimeException("Stub!"); }

/**
 * @return The user-visible status for a media route. This may include a description
 * of the currently playing media, if available.
 * @apiSince 16
 */

public java.lang.CharSequence getStatus() { throw new RuntimeException("Stub!"); }

/**
 * @return A media type flag set describing which types this route supports.
 * @apiSince 16
 */

public int getSupportedTypes() { throw new RuntimeException("Stub!"); }

/**
 * Gets the type of the receiver device associated with this route.
 *
 * @return The type of the receiver device associated with this route:
 * {@link #DEVICE_TYPE_BLUETOOTH}, {@link #DEVICE_TYPE_TV}, {@link #DEVICE_TYPE_SPEAKER},
 * or {@link #DEVICE_TYPE_UNKNOWN}.
 
 * Value is {@link android.media.MediaRouter.RouteInfo#DEVICE_TYPE_UNKNOWN}, {@link android.media.MediaRouter.RouteInfo#DEVICE_TYPE_TV}, {@link android.media.MediaRouter.RouteInfo#DEVICE_TYPE_SPEAKER}, or {@link android.media.MediaRouter.RouteInfo#DEVICE_TYPE_BLUETOOTH}
 * @apiSince 24
 */

public int getDeviceType() { throw new RuntimeException("Stub!"); }

/**
 * @return The group that this route belongs to.
 * @apiSince 16
 */

public android.media.MediaRouter.RouteGroup getGroup() { throw new RuntimeException("Stub!"); }

/**
 * @return the category this route belongs to.
 * @apiSince 16
 */

public android.media.MediaRouter.RouteCategory getCategory() { throw new RuntimeException("Stub!"); }

/**
 * Get the icon representing this route.
 * This icon will be used in picker UIs if available.
 *
 * @return the icon representing this route or null if no icon is available
 * @apiSince 16
 */

public android.graphics.drawable.Drawable getIconDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Set an application-specific tag object for this route.
 * The application may use this to store arbitrary data associated with the
 * route for internal tracking.
 *
 * <p>Note that the lifespan of a route may be well past the lifespan of
 * an Activity or other Context; take care that objects you store here
 * will not keep more data in memory alive than you intend.</p>
 *
 * @param tag Arbitrary, app-specific data for this route to hold for later use
 * @apiSince 16
 */

public void setTag(java.lang.Object tag) { throw new RuntimeException("Stub!"); }

/**
 * @return The tag object previously set by the application
 * @see #setTag(Object)
 * @apiSince 16
 */

public java.lang.Object getTag() { throw new RuntimeException("Stub!"); }

/**
 * @return the type of playback associated with this route
 * Value is {@link android.media.MediaRouter.RouteInfo#PLAYBACK_TYPE_LOCAL}, or {@link android.media.MediaRouter.RouteInfo#PLAYBACK_TYPE_REMOTE}
 * @see android.media.MediaRouter.UserRouteInfo#setPlaybackType(int)
 * @apiSince 16
 */

public int getPlaybackType() { throw new RuntimeException("Stub!"); }

/**
 * @return the stream over which the playback associated with this route is performed
 * @see android.media.MediaRouter.UserRouteInfo#setPlaybackStream(int)
 * @apiSince 16
 */

public int getPlaybackStream() { throw new RuntimeException("Stub!"); }

/**
 * Return the current volume for this route. Depending on the route, this may only
 * be valid if the route is currently selected.
 *
 * @return the volume at which the playback associated with this route is performed
 * @see android.media.MediaRouter.UserRouteInfo#setVolume(int)
 * @apiSince 16
 */

public int getVolume() { throw new RuntimeException("Stub!"); }

/**
 * Request a volume change for this route.
 * @param volume value between 0 and getVolumeMax
 * @apiSince 16
 */

public void requestSetVolume(int volume) { throw new RuntimeException("Stub!"); }

/**
 * Request an incremental volume update for this route.
 * @param direction Delta to apply to the current volume
 * @apiSince 16
 */

public void requestUpdateVolume(int direction) { throw new RuntimeException("Stub!"); }

/**
 * @return the maximum volume at which the playback associated with this route is performed
 * @see android.media.MediaRouter.UserRouteInfo#setVolumeMax(int)
 * @apiSince 16
 */

public int getVolumeMax() { throw new RuntimeException("Stub!"); }

/**
 * @return how volume is handling on the route
 * Value is {@link android.media.MediaRouter.RouteInfo#PLAYBACK_VOLUME_FIXED}, or {@link android.media.MediaRouter.RouteInfo#PLAYBACK_VOLUME_VARIABLE}
 * @see android.media.MediaRouter.UserRouteInfo#setVolumeHandling(int)
 * @apiSince 16
 */

public int getVolumeHandling() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.view.Display Display} that should be used by the application to show
 * a {@link android.app.Presentation} on an external display when this route is selected.
 * Depending on the route, this may only be valid if the route is currently
 * selected.
 * <p>
 * The preferred presentation display may change independently of the route
 * being selected or unselected.  For example, the presentation display
 * of the default system route may change when an external HDMI display is connected
 * or disconnected even though the route itself has not changed.
 * </p><p>
 * This method may return null if there is no external display associated with
 * the route or if the display is not ready to show UI yet.
 * </p><p>
 * The application should listen for changes to the presentation display
 * using the {@link android.media.MediaRouter.Callback#onRoutePresentationDisplayChanged Callback#onRoutePresentationDisplayChanged} callback and
 * show or dismiss its {@link android.app.Presentation} accordingly when the display
 * becomes available or is removed.
 * </p><p>
 * This method only makes sense for {@link #ROUTE_TYPE_LIVE_VIDEO live video} routes.
 * </p>
 *
 * @return The preferred presentation display to use when this route is
 * selected or null if none.
 *
 * @see #ROUTE_TYPE_LIVE_VIDEO
 * @see android.app.Presentation
 * @apiSince 17
 */

public android.view.Display getPresentationDisplay() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this route is enabled and may be selected.
 *
 * @return True if this route is enabled.
 * @apiSince 17
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the route is in the process of connecting and is not
 * yet ready for use.
 *
 * @return True if this route is in the process of connecting.
 * @apiSince 18
 */

public boolean isConnecting() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * A receiver device type of the route indicating the presentation of the media is happening
 * on a bluetooth device such as a bluetooth speaker.
 *
 * @see #getDeviceType
 * @apiSince 24
 */

public static final int DEVICE_TYPE_BLUETOOTH = 3; // 0x3

/**
 * A receiver device type of the route indicating the presentation of the media is happening
 * on a speaker.
 *
 * @see #getDeviceType
 * @apiSince 24
 */

public static final int DEVICE_TYPE_SPEAKER = 2; // 0x2

/**
 * A receiver device type of the route indicating the presentation of the media is happening
 * on a TV.
 *
 * @see #getDeviceType
 * @apiSince 24
 */

public static final int DEVICE_TYPE_TV = 1; // 0x1

/**
 * The default receiver device type of the route indicating the type is unknown.
 *
 * @see #getDeviceType
 * @apiSince 24
 */

public static final int DEVICE_TYPE_UNKNOWN = 0; // 0x0

/**
 * The default playback type, "local", indicating the presentation of the media is happening
 * on the same device (e&#46;g&#46; a phone, a tablet) as where it is controlled from.
 * @see #getPlaybackType()
 * @apiSince 16
 */

public static final int PLAYBACK_TYPE_LOCAL = 0; // 0x0

/**
 * A playback type indicating the presentation of the media is happening on
 * a different device (i&#46;e&#46; the remote device) than where it is controlled from.
 * @see #getPlaybackType()
 * @apiSince 16
 */

public static final int PLAYBACK_TYPE_REMOTE = 1; // 0x1

/**
 * Playback information indicating the playback volume is fixed, i&#46;e&#46; it cannot be
 * controlled from this object. An example of fixed playback volume is a remote player,
 * playing over HDMI where the user prefers to control the volume on the HDMI sink, rather
 * than attenuate at the source.
 * @see #getVolumeHandling()
 * @apiSince 16
 */

public static final int PLAYBACK_VOLUME_FIXED = 0; // 0x0

/**
 * Playback information indicating the playback volume is variable and can be controlled
 * from this object.
 * @see #getVolumeHandling()
 * @apiSince 16
 */

public static final int PLAYBACK_VOLUME_VARIABLE = 1; // 0x1
}

/**
 * Stub implementation of {@link android.media.MediaRouter.Callback MediaRouter.Callback}.
 * Each abstract method is defined as a no-op. Override just the ones
 * you need.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class SimpleCallback extends android.media.MediaRouter.Callback {

public SimpleCallback() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void onRouteSelected(android.media.MediaRouter router, int type, android.media.MediaRouter.RouteInfo info) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void onRouteUnselected(android.media.MediaRouter router, int type, android.media.MediaRouter.RouteInfo info) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void onRouteAdded(android.media.MediaRouter router, android.media.MediaRouter.RouteInfo info) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void onRouteRemoved(android.media.MediaRouter router, android.media.MediaRouter.RouteInfo info) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void onRouteChanged(android.media.MediaRouter router, android.media.MediaRouter.RouteInfo info) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void onRouteGrouped(android.media.MediaRouter router, android.media.MediaRouter.RouteInfo info, android.media.MediaRouter.RouteGroup group, int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void onRouteUngrouped(android.media.MediaRouter router, android.media.MediaRouter.RouteInfo info, android.media.MediaRouter.RouteGroup group) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void onRouteVolumeChanged(android.media.MediaRouter router, android.media.MediaRouter.RouteInfo info) { throw new RuntimeException("Stub!"); }
}

/**
 * Information about a route that the application may define and modify.
 * A user route defaults to {@link android.media.MediaRouter.RouteInfo#PLAYBACK_TYPE_REMOTE RouteInfo#PLAYBACK_TYPE_REMOTE} and
 * {@link android.media.MediaRouter.RouteInfo#PLAYBACK_VOLUME_FIXED RouteInfo#PLAYBACK_VOLUME_FIXED}.
 *
 * @see android.media.MediaRouter.RouteInfo
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class UserRouteInfo extends android.media.MediaRouter.RouteInfo {

UserRouteInfo() { throw new RuntimeException("Stub!"); }

/**
 * Set the user-visible name of this route.
 * @param name Name to display to the user to describe this route
 * @apiSince 16
 */

public void setName(java.lang.CharSequence name) { throw new RuntimeException("Stub!"); }

/**
 * Set the user-visible name of this route.
 * <p>
 * The route name identifies the destination represented by the route.
 * It may be a user-supplied name, an alias, or device serial number.
 * </p>
 *
 * @param resId Resource ID of the name to display to the user to describe this route
 * @apiSince 16
 */

public void setName(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Set the user-visible description of this route.
 * <p>
 * The route description describes the kind of destination represented by the route.
 * It may be a user-supplied string, a model number or brand of device.
 * </p>
 *
 * @param description The description of the route, or null if none.
 * @apiSince 18
 */

public void setDescription(java.lang.CharSequence description) { throw new RuntimeException("Stub!"); }

/**
 * Set the current user-visible status for this route.
 * @param status Status to display to the user to describe what the endpoint
 * of this route is currently doing
 * @apiSince 16
 */

public void setStatus(java.lang.CharSequence status) { throw new RuntimeException("Stub!"); }

/**
 * Set the RemoteControlClient responsible for reporting playback info for this
 * user route.
 *
 * <p>If this route manages remote playback, the data exposed by this
 * RemoteControlClient will be used to reflect and update information
 * such as route volume info in related UIs.</p>
 *
 * <p>The RemoteControlClient must have been previously registered with
 * {@link android.media.AudioManager#registerRemoteControlClient(android.media.RemoteControlClient) AudioManager#registerRemoteControlClient(RemoteControlClient)}.</p>
 *
 * @param rcc RemoteControlClient associated with this route
 * @apiSince 16
 */

public void setRemoteControlClient(android.media.RemoteControlClient rcc) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the RemoteControlClient associated with this route, if one has been set.
 *
 * @return the RemoteControlClient associated with this route
 * @see #setRemoteControlClient(RemoteControlClient)
 * @apiSince 16
 */

public android.media.RemoteControlClient getRemoteControlClient() { throw new RuntimeException("Stub!"); }

/**
 * Set an icon that will be used to represent this route.
 * The system may use this icon in picker UIs or similar.
 *
 * @param icon icon drawable to use to represent this route
 * @apiSince 16
 */

public void setIconDrawable(android.graphics.drawable.Drawable icon) { throw new RuntimeException("Stub!"); }

/**
 * Set an icon that will be used to represent this route.
 * The system may use this icon in picker UIs or similar.
 *
 * @param resId Resource ID of an icon drawable to use to represent this route
 * @apiSince 16
 */

public void setIconResource(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Set a callback to be notified of volume update requests
 * @param vcb
 * @apiSince 16
 */

public void setVolumeCallback(android.media.MediaRouter.VolumeCallback vcb) { throw new RuntimeException("Stub!"); }

/**
 * Defines whether playback associated with this route is "local"
 *    ({@link android.media.MediaRouter.RouteInfo#PLAYBACK_TYPE_LOCAL RouteInfo#PLAYBACK_TYPE_LOCAL}) or "remote"
 *    ({@link android.media.MediaRouter.RouteInfo#PLAYBACK_TYPE_REMOTE RouteInfo#PLAYBACK_TYPE_REMOTE}).
 * @param type
 
 * Value is {@link android.media.MediaRouter.RouteInfo#PLAYBACK_TYPE_LOCAL}, or {@link android.media.MediaRouter.RouteInfo#PLAYBACK_TYPE_REMOTE}
 * @apiSince 16
 */

public void setPlaybackType(int type) { throw new RuntimeException("Stub!"); }

/**
 * Defines whether volume for the playback associated with this route is fixed
 * ({@link android.media.MediaRouter.RouteInfo#PLAYBACK_VOLUME_FIXED RouteInfo#PLAYBACK_VOLUME_FIXED}) or can modified
 * ({@link android.media.MediaRouter.RouteInfo#PLAYBACK_VOLUME_VARIABLE RouteInfo#PLAYBACK_VOLUME_VARIABLE}).
 * @param volumeHandling
 
 * Value is {@link android.media.MediaRouter.RouteInfo#PLAYBACK_VOLUME_FIXED}, or {@link android.media.MediaRouter.RouteInfo#PLAYBACK_VOLUME_VARIABLE}
 * @apiSince 16
 */

public void setVolumeHandling(int volumeHandling) { throw new RuntimeException("Stub!"); }

/**
 * Defines at what volume the playback associated with this route is performed (for user
 * feedback purposes). This information is only used when the playback is not local.
 * @param volume
 * @apiSince 16
 */

public void setVolume(int volume) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void requestSetVolume(int volume) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void requestUpdateVolume(int direction) { throw new RuntimeException("Stub!"); }

/**
 * Defines the maximum volume at which the playback associated with this route is performed
 * (for user feedback purposes). This information is only used when the playback is not
 * local.
 * @param volumeMax
 * @apiSince 16
 */

public void setVolumeMax(int volumeMax) { throw new RuntimeException("Stub!"); }

/**
 * Defines over what stream type the media is presented.
 * @param stream
 * @apiSince 16
 */

public void setPlaybackStream(int stream) { throw new RuntimeException("Stub!"); }
}

/**
 * Interface for receiving events about volume changes.
 * All methods of this interface will be called from the application's main thread.
 *
 * <p>A VolumeCallback will only receive events relevant to routes that the callback
 * was registered for.</p>
 *
 * @see android.media.MediaRouter.UserRouteInfo#setVolumeCallback(VolumeCallback)
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class VolumeCallback {

public VolumeCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when the volume for the route should be increased or decreased.
 * @param info the route affected by this event
 * @param direction an integer indicating whether the volume is to be increased
 *     (positive value) or decreased (negative value).
 *     For bundled changes, the absolute value indicates the number of changes
 *     in the same direction, e.g. +3 corresponds to three "volume up" changes.
 * @apiSince 16
 */

public abstract void onVolumeUpdateRequest(android.media.MediaRouter.RouteInfo info, int direction);

/**
 * Called when the volume for the route should be set to the given value
 * @param info the route affected by this event
 * @param volume an integer indicating the new volume value that should be used, always
 *     between 0 and the value set by {@link android.media.MediaRouter.UserRouteInfo#setVolumeMax(int) UserRouteInfo#setVolumeMax(int)}.
 * @apiSince 16
 */

public abstract void onVolumeSetRequest(android.media.MediaRouter.RouteInfo info, int volume);
}

}

