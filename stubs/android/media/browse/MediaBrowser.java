/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.media.browse;

import java.util.List;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.media.MediaDescription;
import android.media.session.MediaController;

/**
 * Browses media content offered by a link MediaBrowserService.
 * <p>
 * This object is not thread-safe. All calls should happen on the thread on which the browser
 * was constructed.
 * </p>
 * <h3>Standard Extra Data</h3>
 *
 * <p>These are the current standard fields that can be used as extra data via
 * {@link #subscribe(java.lang.String,android.os.Bundle,android.media.browse.MediaBrowser.SubscriptionCallback)},
 * {@link #unsubscribe(java.lang.String,android.media.browse.MediaBrowser.SubscriptionCallback)}, and
 * {@link android.media.browse.MediaBrowser.SubscriptionCallback#onChildrenLoaded(java.lang.String,java.util.List,android.os.Bundle) SubscriptionCallback#onChildrenLoaded(String, List, Bundle)}.
 *
 * <ul>
 *     <li> {@link #EXTRA_PAGE}
 *     <li> {@link #EXTRA_PAGE_SIZE}
 * </ul>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaBrowser {

/**
 * Creates a media browser for the specified media browser service.
 *
 * @param context The context.
 * @param serviceComponent The component name of the media browser service.
 * @param callback The connection callback.
 * @param rootHints An optional bundle of service-specific arguments to send
 * to the media browser service when connecting and retrieving the root id
 * for browsing, or null if none. The contents of this bundle may affect
 * the information returned when browsing.
 * @see android.service.media.MediaBrowserService.BrowserRoot#EXTRA_RECENT
 * @see android.service.media.MediaBrowserService.BrowserRoot#EXTRA_OFFLINE
 * @see android.service.media.MediaBrowserService.BrowserRoot#EXTRA_SUGGESTED
 * @apiSince 21
 */

public MediaBrowser(android.content.Context context, android.content.ComponentName serviceComponent, android.media.browse.MediaBrowser.ConnectionCallback callback, android.os.Bundle rootHints) { throw new RuntimeException("Stub!"); }

/**
 * Connects to the media browser service.
 * <p>
 * The connection callback specified in the constructor will be invoked
 * when the connection completes or fails.
 * </p>
 * @apiSince 21
 */

public void connect() { throw new RuntimeException("Stub!"); }

/**
 * Disconnects from the media browser service.
 * After this, no more callbacks will be received.
 * @apiSince 21
 */

public void disconnect() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the browser is connected to the service.
 * @apiSince 21
 */

public boolean isConnected() { throw new RuntimeException("Stub!"); }

/**
 * Gets the service component that the media browser is connected to.
 
 * @return This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.content.ComponentName getServiceComponent() { throw new RuntimeException("Stub!"); }

/**
 * Gets the root id.
 * <p>
 * Note that the root id may become invalid or change when the
 * browser is disconnected.
 * </p>
 *
 * @throws java.lang.IllegalStateException if not connected.
 
 * @return This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.lang.String getRoot() { throw new RuntimeException("Stub!"); }

/**
 * Gets any extras for the media service.
 *
 * @throws java.lang.IllegalStateException if not connected.
 
 * @return This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Gets the media session token associated with the media browser.
 * <p>
 * Note that the session token may become invalid or change when the
 * browser is disconnected.
 * </p>
 *
 * @return The session token for the browser, never null.
 *
 * @throws java.lang.IllegalStateException if not connected.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.media.session.MediaSession.Token getSessionToken() { throw new RuntimeException("Stub!"); }

/**
 * Queries for information about the media items that are contained within
 * the specified id and subscribes to receive updates when they change.
 * <p>
 * The list of subscriptions is maintained even when not connected and is
 * restored after the reconnection. It is ok to subscribe while not connected
 * but the results will not be returned until the connection completes.
 * </p>
 * <p>
 * If the id is already subscribed with a different callback then the new
 * callback will replace the previous one and the child data will be
 * reloaded.
 * </p>
 *
 * @param parentId The id of the parent media item whose list of children
 *            will be subscribed.
 * This value must never be {@code null}.
 * @param callback The callback to receive the list of children.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void subscribe(@androidx.annotation.NonNull java.lang.String parentId, @androidx.annotation.NonNull android.media.browse.MediaBrowser.SubscriptionCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Queries with service-specific arguments for information about the media items
 * that are contained within the specified id and subscribes to receive updates
 * when they change.
 * <p>
 * The list of subscriptions is maintained even when not connected and is
 * restored after the reconnection. It is ok to subscribe while not connected
 * but the results will not be returned until the connection completes.
 * </p>
 * <p>
 * If the id is already subscribed with a different callback then the new
 * callback will replace the previous one and the child data will be
 * reloaded.
 * </p>
 *
 * @param parentId The id of the parent media item whose list of children
 *            will be subscribed.
 * This value must never be {@code null}.
 * @param options The bundle of service-specific arguments to send to the media
 *            browser service. The contents of this bundle may affect the
 *            information returned when browsing.
 * This value must never be {@code null}.
 * @param callback The callback to receive the list of children.
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public void subscribe(@androidx.annotation.NonNull java.lang.String parentId, @androidx.annotation.NonNull android.os.Bundle options, @androidx.annotation.NonNull android.media.browse.MediaBrowser.SubscriptionCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Unsubscribes for changes to the children of the specified media id.
 * <p>
 * The query callback will no longer be invoked for results associated with
 * this id once this method returns.
 * </p>
 *
 * @param parentId The id of the parent media item whose list of children
 *            will be unsubscribed.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void unsubscribe(@androidx.annotation.NonNull java.lang.String parentId) { throw new RuntimeException("Stub!"); }

/**
 * Unsubscribes for changes to the children of the specified media id through a callback.
 * <p>
 * The query callback will no longer be invoked for results associated with
 * this id once this method returns.
 * </p>
 *
 * @param parentId The id of the parent media item whose list of children
 *            will be unsubscribed.
 * This value must never be {@code null}.
 * @param callback A callback sent to the media browser service to subscribe.
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public void unsubscribe(@androidx.annotation.NonNull java.lang.String parentId, @androidx.annotation.NonNull android.media.browse.MediaBrowser.SubscriptionCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves a specific {@link android.media.browse.MediaBrowser.MediaItem MediaItem} from the connected service. Not
 * all services may support this, so falling back to subscribing to the
 * parent's id should be used when unavailable.
 *
 * @param mediaId The id of the item to retrieve.
 * This value must never be {@code null}.
 * @param cb The callback to receive the result on.
 
 * This value must never be {@code null}.
 * @apiSince 23
 */

public void getItem(@androidx.annotation.NonNull java.lang.String mediaId, @androidx.annotation.NonNull android.media.browse.MediaBrowser.ItemCallback cb) { throw new RuntimeException("Stub!"); }

/**
 * Used as an int extra field to denote the page number to subscribe.
 * The value of {@code EXTRA_PAGE} should be greater than or equal to 0.
 *
 * @see #EXTRA_PAGE_SIZE
 * @apiSince 24
 */

public static final java.lang.String EXTRA_PAGE = "android.media.browse.extra.PAGE";

/**
 * Used as an int extra field to denote the number of media items in a page.
 * The value of {@code EXTRA_PAGE_SIZE} should be greater than or equal to 1.
 *
 * @see #EXTRA_PAGE
 * @apiSince 24
 */

public static final java.lang.String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
/**
 * Callbacks for connection related events.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class ConnectionCallback {

public ConnectionCallback() { throw new RuntimeException("Stub!"); }

/**
 * Invoked after {@link android.media.browse.MediaBrowser#connect() MediaBrowser#connect()} when the request has successfully completed.
 * @apiSince 21
 */

public void onConnected() { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the client is disconnected from the media browser.
 * @apiSince 21
 */

public void onConnectionSuspended() { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the connection to the media browser failed.
 * @apiSince 21
 */

public void onConnectionFailed() { throw new RuntimeException("Stub!"); }
}

/**
 * Callback for receiving the result of {@link #getItem}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class ItemCallback {

public ItemCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when the item has been returned by the connected service.
 *
 * @param item The item that was returned or null if it doesn't exist.
 * @apiSince 23
 */

public void onItemLoaded(android.media.browse.MediaBrowser.MediaItem item) { throw new RuntimeException("Stub!"); }

/**
 * Called there was an error retrieving it or the connected service doesn't support
 * {@link #getItem}.
 *
 * @param mediaId The media id of the media item which could not be loaded.
 
 * This value must never be {@code null}.
 * @apiSince 23
 */

public void onError(@androidx.annotation.NonNull java.lang.String mediaId) { throw new RuntimeException("Stub!"); }
}

/**
 * A class with information on a single media item for use in browsing/searching media.
 * MediaItems are application dependent so we cannot guarantee that they contain the
 * right values.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class MediaItem implements android.os.Parcelable {

/**
 * Create a new MediaItem for use in browsing media.
 * @param description The description of the media, which must include a
 *            media id.
 * This value must never be {@code null}.
 * @param flags The flags for this item.
 
 * Value is either <code>0</code> or a combination of {@link android.media.browse.MediaBrowser.MediaItem#FLAG_BROWSABLE}, and {@link android.media.browse.MediaBrowser.MediaItem#FLAG_PLAYABLE}
 * @apiSince 21
 */

public MediaItem(@androidx.annotation.NonNull android.media.MediaDescription description, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Gets the flags of the item.
 
 * @return Value is either <code>0</code> or a combination of {@link android.media.browse.MediaBrowser.MediaItem#FLAG_BROWSABLE}, and {@link android.media.browse.MediaBrowser.MediaItem#FLAG_PLAYABLE}
 * @apiSince 21
 */

public int getFlags() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this item is browsable.
 * @see #FLAG_BROWSABLE
 * @apiSince 21
 */

public boolean isBrowsable() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this item is playable.
 * @see #FLAG_PLAYABLE
 * @apiSince 21
 */

public boolean isPlayable() { throw new RuntimeException("Stub!"); }

/**
 * Returns the description of the media.
 
 * @return This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.media.MediaDescription getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Returns the media id in the {@link android.media.MediaDescription MediaDescription} for this item.
 * @see android.media.MediaMetadata#METADATA_KEY_MEDIA_ID
 
 * @return This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.String getMediaId() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.browse.MediaBrowser.MediaItem> CREATOR;
static { CREATOR = null; }

/**
 * Flag: Indicates that the item has children of its own.
 * @apiSince 21
 */

public static final int FLAG_BROWSABLE = 1; // 0x1

/**
 * Flag: Indicates that the item is playable.
 * <p>
 * The id of this item may be passed to
 * {@link android.media.session.MediaController.TransportControls#playFromMediaId(java.lang.String,android.os.Bundle) MediaController.TransportControls#playFromMediaId(String, Bundle)}
 * to start playing it.
 * </p>
 * @apiSince 21
 */

public static final int FLAG_PLAYABLE = 2; // 0x2
}

/**
 * Callbacks for subscription related events.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class SubscriptionCallback {

/** @apiSince 21 */

public SubscriptionCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when the list of children is loaded or updated.
 *
 * @param parentId The media id of the parent media item.
 * This value must never be {@code null}.
 * @param children The children which were loaded.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void onChildrenLoaded(@androidx.annotation.NonNull java.lang.String parentId, @androidx.annotation.NonNull java.util.List<android.media.browse.MediaBrowser.MediaItem> children) { throw new RuntimeException("Stub!"); }

/**
 * Called when the list of children is loaded or updated.
 *
 * @param parentId The media id of the parent media item.
 * This value must never be {@code null}.
 * @param children The children which were loaded.
 * This value must never be {@code null}.
 * @param options The bundle of service-specific arguments sent to the media
 *            browser service. The contents of this bundle may affect the
 *            information returned when browsing.
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public void onChildrenLoaded(@androidx.annotation.NonNull java.lang.String parentId, @androidx.annotation.NonNull java.util.List<android.media.browse.MediaBrowser.MediaItem> children, @androidx.annotation.NonNull android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Called when the id doesn't exist or other errors in subscribing.
 * <p>
 * If this is called, the subscription remains until {@link android.media.browse.MediaBrowser#unsubscribe MediaBrowser#unsubscribe}
 * called, because some errors may heal themselves.
 * </p>
 *
 * @param parentId The media id of the parent media item whose children could
 *            not be loaded.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void onError(@androidx.annotation.NonNull java.lang.String parentId) { throw new RuntimeException("Stub!"); }

/**
 * Called when the id doesn't exist or other errors in subscribing.
 * <p>
 * If this is called, the subscription remains until {@link android.media.browse.MediaBrowser#unsubscribe MediaBrowser#unsubscribe}
 * called, because some errors may heal themselves.
 * </p>
 *
 * @param parentId The media id of the parent media item whose children could
 *            not be loaded.
 * This value must never be {@code null}.
 * @param options The bundle of service-specific arguments sent to the media
 *            browser service.
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public void onError(@androidx.annotation.NonNull java.lang.String parentId, @androidx.annotation.NonNull android.os.Bundle options) { throw new RuntimeException("Stub!"); }
}

}

