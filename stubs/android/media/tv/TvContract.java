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


package android.media.tv;

import android.content.ComponentName;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * The contract between the TV provider and applications. Contains definitions for the supported
 * URIs and columns.
 * <h3>Overview</h3>
 *
 * <p>TvContract defines a basic database of TV content metadata such as channel and program
 * information. The information is stored in {@link android.media.tv.TvContract.Channels Channels} and {@link android.media.tv.TvContract.Programs Programs} tables.
 *
 * <ul>
 *     <li>A row in the {@link android.media.tv.TvContract.Channels Channels} table represents information about a TV channel. The data
 *         format can vary greatly from standard to standard or according to service provider, thus
 *         the columns here are mostly comprised of basic entities that are usually seen to users
 *         regardless of standard such as channel number and name.</li>
 *     <li>A row in the {@link android.media.tv.TvContract.Programs Programs} table represents a set of data describing a TV program such
 *         as program title and start time.</li>
 * </ul>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TvContract {

private TvContract() { throw new RuntimeException("Stub!"); }

/**
 * Builds an ID that uniquely identifies a TV input service.
 *
 * @param name The {@link android.content.ComponentName ComponentName} of the TV input service to build ID for.
 * @return the ID for the given TV input service.
 * @apiSince 21
 */

public static java.lang.String buildInputId(android.content.ComponentName name) { throw new RuntimeException("Stub!"); }

/**
 * Builds a URI that points to a specific channel.
 *
 * @param channelId The ID of the channel to point to.
 * @apiSince 21
 */

public static android.net.Uri buildChannelUri(long channelId) { throw new RuntimeException("Stub!"); }

/**
 * Build a special channel URI intended to be used with pass-through inputs. (e.g. HDMI)
 *
 * @param inputId The ID of the pass-through input to build a channels URI for.
 * @see android.media.tv.TvInputInfo#isPassthroughInput()
 * @apiSince 21
 */

public static android.net.Uri buildChannelUriForPassthroughInput(java.lang.String inputId) { throw new RuntimeException("Stub!"); }

/**
 * Builds a URI that points to a channel logo. See {@link android.media.tv.TvContract.Channels.Logo Channels.Logo}.
 *
 * @param channelId The ID of the channel whose logo is pointed to.
 * @apiSince 21
 */

public static android.net.Uri buildChannelLogoUri(long channelId) { throw new RuntimeException("Stub!"); }

/**
 * Builds a URI that points to a channel logo. See {@link android.media.tv.TvContract.Channels.Logo Channels.Logo}.
 *
 * @param channelUri The URI of the channel whose logo is pointed to.
 * @apiSince 21
 */

public static android.net.Uri buildChannelLogoUri(android.net.Uri channelUri) { throw new RuntimeException("Stub!"); }

/**
 * Builds a URI that points to all channels from a given TV input.
 *
 * @param inputId The ID of the TV input to build a channels URI for. If {@code null}, builds a
 *            URI for all the TV inputs.
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public static android.net.Uri buildChannelsUriForInput(@androidx.annotation.Nullable java.lang.String inputId) { throw new RuntimeException("Stub!"); }

/**
 * Builds a URI that points to a specific program.
 *
 * @param programId The ID of the program to point to.
 * @apiSince 21
 */

public static android.net.Uri buildProgramUri(long programId) { throw new RuntimeException("Stub!"); }

/**
 * Builds a URI that points to all programs on a given channel.
 *
 * @param channelId The ID of the channel to return programs for.
 * @apiSince 21
 */

public static android.net.Uri buildProgramsUriForChannel(long channelId) { throw new RuntimeException("Stub!"); }

/**
 * Builds a URI that points to all programs on a given channel.
 *
 * @param channelUri The URI of the channel to return programs for.
 * @apiSince 21
 */

public static android.net.Uri buildProgramsUriForChannel(android.net.Uri channelUri) { throw new RuntimeException("Stub!"); }

/**
 * Builds a URI that points to programs on a specific channel whose schedules overlap with the
 * given time frame.
 *
 * @param channelId The ID of the channel to return programs for.
 * @param startTime The start time used to filter programs. The returned programs will have a
 *            {@link android.media.tv.TvContract.Programs#COLUMN_END_TIME_UTC_MILLIS Programs#COLUMN_END_TIME_UTC_MILLIS} that is greater than or equal to
             {@code startTime}.
 * @param endTime The end time used to filter programs. The returned programs will have
 *            {@link android.media.tv.TvContract.Programs#COLUMN_START_TIME_UTC_MILLIS Programs#COLUMN_START_TIME_UTC_MILLIS} that is less than or equal to
 *            {@code endTime}.
 * @apiSince 21
 */

public static android.net.Uri buildProgramsUriForChannel(long channelId, long startTime, long endTime) { throw new RuntimeException("Stub!"); }

/**
 * Builds a URI that points to programs on a specific channel whose schedules overlap with the
 * given time frame.
 *
 * @param channelUri The URI of the channel to return programs for.
 * @param startTime The start time used to filter programs. The returned programs should have
 *            {@link android.media.tv.TvContract.Programs#COLUMN_END_TIME_UTC_MILLIS Programs#COLUMN_END_TIME_UTC_MILLIS} that is greater than this time.
 * @param endTime The end time used to filter programs. The returned programs should have
 *            {@link android.media.tv.TvContract.Programs#COLUMN_START_TIME_UTC_MILLIS Programs#COLUMN_START_TIME_UTC_MILLIS} that is less than this time.
 * @apiSince 21
 */

public static android.net.Uri buildProgramsUriForChannel(android.net.Uri channelUri, long startTime, long endTime) { throw new RuntimeException("Stub!"); }

/**
 * Builds a URI that points to a specific recorded program.
 *
 * @param recordedProgramId The ID of the recorded program to point to.
 * @apiSince 24
 */

public static android.net.Uri buildRecordedProgramUri(long recordedProgramId) { throw new RuntimeException("Stub!"); }

/**
 * Builds a URI that points to a specific preview program.
 *
 * @param previewProgramId The ID of the preview program to point to.
 * @apiSince 26
 */

public static android.net.Uri buildPreviewProgramUri(long previewProgramId) { throw new RuntimeException("Stub!"); }

/**
 * Builds a URI that points to all preview programs on a given channel.
 *
 * @param channelId The ID of the channel to return preview programs for.
 * @apiSince 26
 */

public static android.net.Uri buildPreviewProgramsUriForChannel(long channelId) { throw new RuntimeException("Stub!"); }

/**
 * Builds a URI that points to all preview programs on a given channel.
 *
 * @param channelUri The URI of the channel to return preview programs for.
 * @apiSince 26
 */

public static android.net.Uri buildPreviewProgramsUriForChannel(android.net.Uri channelUri) { throw new RuntimeException("Stub!"); }

/**
 * Builds a URI that points to a specific watch next program.
 *
 * @param watchNextProgramId The ID of the watch next program to point to.
 * @apiSince 26
 */

public static android.net.Uri buildWatchNextProgramUri(long watchNextProgramId) { throw new RuntimeException("Stub!"); }

/**
 * @param uri This value must never be {@code null}.
 * @return {@code true} if {@code uri} is a channel URI.
 * @apiSince 24
 */

public static boolean isChannelUri(@androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * @param uri This value must never be {@code null}.
 * @return {@code true} if {@code uri} is a channel URI for a tuner input.
 * @apiSince 24
 */

public static boolean isChannelUriForTunerInput(@androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * @param uri This value must never be {@code null}.
 * @return {@code true} if {@code uri} is a channel URI for a pass-through input.
 * @apiSince 24
 */

public static boolean isChannelUriForPassthroughInput(@androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * @param uri This value must never be {@code null}.
 * @return {@code true} if {@code uri} is a program URI.
 * @apiSince 24
 */

public static boolean isProgramUri(@androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * @param uri This value must never be {@code null}.
 * @return {@code true} if {@code uri} is a recorded program URI.
 * @apiSince 27
 */

public static boolean isRecordedProgramUri(@androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Requests to make a channel browsable.
 *
 * <p>Once called, the system will review the request and make the channel browsable based on
 * its policy. The first request from a package is guaranteed to be approved. This is only
 * relevant to channels with {@link android.media.tv.TvContract.Channels#TYPE_PREVIEW Channels#TYPE_PREVIEW} type.
 *
 * @param context The context for accessing content provider.
 * @param channelId The channel ID to be browsable.
 * @see android.media.tv.TvContract.Channels#COLUMN_BROWSABLE
 * @apiSince 26
 */

public static void requestChannelBrowsable(android.content.Context context, long channelId) { throw new RuntimeException("Stub!"); }

/**
 * Broadcast Action: sent to the target TV input after it is first installed to notify the input
 * to initialize its channels and programs to the system content provider.
 *
 * <p>Note that this intent is sent only on devices with
 * {@link android.content.pm.PackageManager#FEATURE_LEANBACK} enabled. Besides that, in order
 * to receive this intent, the target TV input must:
 * <ul>
 *     <li>Declare a broadcast receiver for this intent in its
 *         <code>AndroidManifest.xml</code>.</li>
 *     <li>Declare appropriate permissions to write channel and program data in its
 *         <code>AndroidManifest.xml</code>.</li>
 * </ul>
 * @apiSince 26
 */

public static final java.lang.String ACTION_INITIALIZE_PROGRAMS = "android.media.tv.action.INITIALIZE_PROGRAMS";

/**
 * Broadcast Action: sent by the system to tell the target TV input that one of its existing
 * preview programs is added to the watch next programs table by user.
 *
 * <p>The intent must contain the following bundle parameters:
 * <ul>
 *     <li>{@link #EXTRA_PREVIEW_PROGRAM_ID}: the ID of the existing preview program.</li>
 *     <li>{@link #EXTRA_WATCH_NEXT_PROGRAM_ID}: the ID of the new watch next program.</li>
 * </ul>
 * @apiSince 26
 */

public static final java.lang.String ACTION_PREVIEW_PROGRAM_ADDED_TO_WATCH_NEXT = "android.media.tv.action.PREVIEW_PROGRAM_ADDED_TO_WATCH_NEXT";

/**
 * Broadcast Action: sent by the system to tell the target TV input that one of its preview
 * program's browsable state is disabled, i.e., it will no longer be shown to users, which, for
 * example, might be a result of users' interaction with UI. The input is expected to delete the
 * preview program from the content provider.
 *
 * <p>The intent must contain the following bundle parameter:
 * <ul>
 *     <li>{@link #EXTRA_PREVIEW_PROGRAM_ID}: the disabled preview program ID.</li>
 * </ul>
 * @apiSince 26
 */

public static final java.lang.String ACTION_PREVIEW_PROGRAM_BROWSABLE_DISABLED = "android.media.tv.action.PREVIEW_PROGRAM_BROWSABLE_DISABLED";

/**
 * Activity Action: sent by an application telling the system to make the given channel
 * browsable with user interaction. The system may show UI to ask user to approve the channel.
 * This is only relevant to channels with {@link android.media.tv.TvContract.Channels#TYPE_PREVIEW Channels#TYPE_PREVIEW} type. Use
 * {@link android.app.Activity#startActivityForResult Activity#startActivityForResult} to get the result of the request.
 *
 * <p>The intent must contain the following bundle parameters:
 * <ul>
 *     <li>{@link #EXTRA_CHANNEL_ID}: ID for the {@link android.media.tv.TvContract.Channels#TYPE_PREVIEW Channels#TYPE_PREVIEW} channel as a long
 *     integer.</li>
 * </ul>
 * @apiSince 26
 */

public static final java.lang.String ACTION_REQUEST_CHANNEL_BROWSABLE = "android.media.tv.action.REQUEST_CHANNEL_BROWSABLE";

/**
 * Broadcast Action: sent by the system to tell the target TV input that one of its "watch next"
 * program's browsable state is disabled, i.e., it will no longer be shown to users, which, for
 * example, might be a result of users' interaction with UI. The input is expected to delete the
 * "watch next" program from the content provider.
 *
 * <p>The intent must contain the following bundle parameter:
 * <ul>
 *     <li>{@link #EXTRA_WATCH_NEXT_PROGRAM_ID}: the disabled "watch next" program ID.</li>
 * </ul>
 * @apiSince 26
 */

public static final java.lang.String ACTION_WATCH_NEXT_PROGRAM_BROWSABLE_DISABLED = "android.media.tv.action.WATCH_NEXT_PROGRAM_BROWSABLE_DISABLED";

/**
 * The authority for the TV provider.
 * @apiSince 21
 */

public static final java.lang.String AUTHORITY = "android.media.tv";

/**
 * The key for a bundle parameter containing a channel ID as a long integer
 * @apiSince 26
 */

public static final java.lang.String EXTRA_CHANNEL_ID = "android.media.tv.extra.CHANNEL_ID";

/**
 * The key for a bundle parameter containing a program ID as a long integer.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_PREVIEW_PROGRAM_ID = "android.media.tv.extra.PREVIEW_PROGRAM_ID";

/**
 * The key for a bundle parameter containing a watch next program ID as a long integer.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_WATCH_NEXT_PROGRAM_ID = "android.media.tv.extra.WATCH_NEXT_PROGRAM_ID";
/**
 * Common base for the tables of TV channels/programs.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface BaseTvColumns extends android.provider.BaseColumns {

/**
 * The name of the package that owns the current row.
 *
 * <p>The TV provider fills in this column with the name of the package that provides the
 * initial data of the row. If the package is later uninstalled, the rows it owns are
 * automatically removed from the tables.
 *
 * <p>Type: TEXT
 * @apiSince 21
 */

public static final java.lang.String COLUMN_PACKAGE_NAME = "package_name";
}

/**
 * Column definitions for the TV channels table.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Channels implements android.media.tv.TvContract.BaseTvColumns {

private Channels() { throw new RuntimeException("Stub!"); }

/**
 * Returns the video resolution (definition) for a given video format.
 *
 * @param videoFormat The video format defined in {@link android.media.tv.TvContract.Channels Channels}.
 * Value is {@link android.media.tv.TvContract.Channels#VIDEO_FORMAT_240P}, {@link android.media.tv.TvContract.Channels#VIDEO_FORMAT_360P}, {@link android.media.tv.TvContract.Channels#VIDEO_FORMAT_480I}, {@link android.media.tv.TvContract.Channels#VIDEO_FORMAT_576I}, {@link android.media.tv.TvContract.Channels#VIDEO_FORMAT_576P}, {@link android.media.tv.TvContract.Channels#VIDEO_FORMAT_720P}, {@link android.media.tv.TvContract.Channels#VIDEO_FORMAT_1080I}, {@link android.media.tv.TvContract.Channels#VIDEO_FORMAT_1080P}, {@link android.media.tv.TvContract.Channels#VIDEO_FORMAT_2160P}, or {@link android.media.tv.TvContract.Channels#VIDEO_FORMAT_4320P}
 * @return the corresponding video resolution string. {@code null} if the resolution string
 *         is not defined for the given video format.
 * @see #COLUMN_VIDEO_FORMAT
 * @apiSince 21
 */

@androidx.annotation.Nullable
public static java.lang.String getVideoResolution(java.lang.String videoFormat) { throw new RuntimeException("Stub!"); }

/**
 * The accent color of the app link template for this channel. This is primarily used for
 * the background color of the text box in the template.
 *
 * <p>The app-linking allows channel input sources to provide activity links from their live
 * channel programming to another activity. This enables content providers to increase user
 * engagement by offering the viewer other content or actions.
 *
 * <p>Type: INTEGER (color value)
 * @see #COLUMN_APP_LINK_ICON_URI
 * @see #COLUMN_APP_LINK_INTENT_URI
 * @see #COLUMN_APP_LINK_POSTER_ART_URI
 * @see #COLUMN_APP_LINK_TEXT
 * @apiSince 23
 */

public static final java.lang.String COLUMN_APP_LINK_COLOR = "app_link_color";

/**
 * The URI for the app badge icon of the app link template for this channel.
 *
 * <p>This small icon is overlaid at the bottom of the poster art specified by
 * {@link #COLUMN_APP_LINK_POSTER_ART_URI}. The data in the column must be a URI in one of
 * the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})
 * </li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * <p>The app-linking allows channel input sources to provide activity links from their live
 * channel programming to another activity. This enables content providers to increase user
 * engagement by offering the viewer other content or actions.
 *
 * <p>Type: TEXT
 * @see #COLUMN_APP_LINK_COLOR
 * @see #COLUMN_APP_LINK_INTENT_URI
 * @see #COLUMN_APP_LINK_POSTER_ART_URI
 * @see #COLUMN_APP_LINK_TEXT
 * @apiSince 23
 */

public static final java.lang.String COLUMN_APP_LINK_ICON_URI = "app_link_icon_uri";

/**
 * The intent URI of the app link for this channel.
 *
 * <p>The URI is created using {@link android.content.Intent#toUri Intent#toUri} with {@link android.content.Intent#URI_INTENT_SCHEME Intent#URI_INTENT_SCHEME}
 * and converted back to the original intent with {@link android.content.Intent#parseUri Intent#parseUri}. The intent is
 * launched when the user clicks the corresponding app link for the current channel.
 *
 * <p>The app-linking allows channel input sources to provide activity links from their live
 * channel programming to another activity. This enables content providers to increase user
 * engagement by offering the viewer other content or actions.
 *
 * <p>Type: TEXT
 * @see #COLUMN_APP_LINK_COLOR
 * @see #COLUMN_APP_LINK_ICON_URI
 * @see #COLUMN_APP_LINK_POSTER_ART_URI
 * @see #COLUMN_APP_LINK_TEXT
 * @apiSince 23
 */

public static final java.lang.String COLUMN_APP_LINK_INTENT_URI = "app_link_intent_uri";

/**
 * The URI for the poster art used as the background of the app link template for this
 * channel.
 *
 * <p>The data in the column must be a URL, or a URI in one of the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})
 * </li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * <p>The app-linking allows channel input sources to provide activity links from their live
 * channel programming to another activity. This enables content providers to increase user
 * engagement by offering the viewer other content or actions.
 *
 * <p>Type: TEXT
 * @see #COLUMN_APP_LINK_COLOR
 * @see #COLUMN_APP_LINK_ICON_URI
 * @see #COLUMN_APP_LINK_INTENT_URI
 * @see #COLUMN_APP_LINK_TEXT
 * @apiSince 23
 */

public static final java.lang.String COLUMN_APP_LINK_POSTER_ART_URI = "app_link_poster_art_uri";

/**
 * The link text of the app link template for this channel.
 *
 * <p>This provides a short description of the action that happens when the corresponding
 * app link is clicked.
 *
 * <p>The app-linking allows channel input sources to provide activity links from their live
 * channel programming to another activity. This enables content providers to increase user
 * engagement by offering the viewer other content or actions.
 *
 * <p>Type: TEXT
 * @see #COLUMN_APP_LINK_COLOR
 * @see #COLUMN_APP_LINK_ICON_URI
 * @see #COLUMN_APP_LINK_INTENT_URI
 * @see #COLUMN_APP_LINK_POSTER_ART_URI
 * @apiSince 23
 */

public static final java.lang.String COLUMN_APP_LINK_TEXT = "app_link_text";

/**
 * The flag indicating whether this TV channel is browsable or not.
 *
 * <p>This column can only be set by applications having proper system permission. For
 * other applications, this is a read-only column.
 *
 * <p>A value of 1 indicates the channel is included in the channel list that applications
 * use to browse channels, a value of 0 indicates the channel is not included in the list.
 * If not specified, this value is set to 0 (not browsable) by default.
 *
 * <p>Type: INTEGER (boolean)
 * @apiSince 26
 */

public static final java.lang.String COLUMN_BROWSABLE = "browsable";

/**
 * The description of this TV channel.
 *
 * <p>Can be empty initially.
 *
 * <p>Type: TEXT
 * @apiSince 21
 */

public static final java.lang.String COLUMN_DESCRIPTION = "description";

/**
 * The channel name that is displayed to the user.
 *
 * <p>A call sign is a good candidate to use for this purpose but any name that helps the
 * user recognize the current channel will be enough. Can also be empty depending on
 * broadcast standard.
 *
 * <p> Type: TEXT
 * @apiSince 21
 */

public static final java.lang.String COLUMN_DISPLAY_NAME = "display_name";

/**
 * The channel number that is displayed to the user.
 *
 * <p>The format can vary depending on broadcast standard and product specification.
 *
 * <p>Type: TEXT
 * @apiSince 21
 */

public static final java.lang.String COLUMN_DISPLAY_NUMBER = "display_number";

/**
 * The ID of the TV input service that provides this TV channel.
 *
 * <p>Use {@link #buildInputId} to build the ID.
 *
 * <p>This is a required field.
 *
 * <p>Type: TEXT
 * @apiSince 21
 */

public static final java.lang.String COLUMN_INPUT_ID = "input_id";

/**
 * Internal data used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: BLOB
 * @apiSince 21
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_DATA = "internal_provider_data";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 * @apiSince 23
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG1 = "internal_provider_flag1";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 * @apiSince 23
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG2 = "internal_provider_flag2";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 * @apiSince 23
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG3 = "internal_provider_flag3";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 * @apiSince 23
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG4 = "internal_provider_flag4";

/**
 * The internal ID used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 * @apiSince 26
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_ID = "internal_provider_id";

/**
 * The flag indicating whether this TV channel is locked or not.
 *
 * <p>This is primarily used for alternative parental control to prevent unauthorized users
 * from watching the current channel regardless of the content rating. A value of 1
 * indicates the channel is locked and the user is required to enter passcode to unlock it
 * in order to watch the current program from the channel, a value of 0 indicates the
 * channel is not locked thus the user is not prompted to enter passcode If not specified,
 * this value is set to 0 (not locked) by default.
 *
 * <p>This column can only be set by applications having proper system permission to
 * modify parental control settings. For other applications, this is a read-only column.
 
 * <p>Type: INTEGER (boolean)
 * @apiSince 26
 */

public static final java.lang.String COLUMN_LOCKED = "locked";

/**
 * The network affiliation for this TV channel.
 *
 * <p>This is used to identify a channel that is commonly called by its network affiliation
 * instead of the display name. Examples include ABC for the channel KGO-HD, FOX for the
 * channel KTVU-HD and NBC for the channel KNTV-HD. Can be empty if not applicable.
 *
 * <p>Type: TEXT
 * @apiSince 21
 */

public static final java.lang.String COLUMN_NETWORK_AFFILIATION = "network_affiliation";

/**
 * The original network ID of this TV channel.
 *
 * <p>It is used to identify the originating delivery system, if applicable. Use the same
 * coding for {@code original_network_id} for ETSI EN 300 468/TR 101 211 and ARIB STD-B10.
 *
 * <p>This is a required field only if the underlying broadcast standard defines the same
 * name field. Otherwise, leave empty.
 *
 * <p>Type: INTEGER
 * @apiSince 21
 */

public static final java.lang.String COLUMN_ORIGINAL_NETWORK_ID = "original_network_id";

/**
 * The flag indicating whether this TV channel is searchable or not.
 *
 * <p>The columns of searchable channels can be read by other applications that have proper
 * permission. Care must be taken not to open sensitive data.
 *
 * <p>A value of 1 indicates that the channel is searchable and its columns can be read by
 * other applications, a value of 0 indicates that the channel is hidden and its columns can
 * be read only by the package that owns the channel and the system. If not specified, this
 * value is set to 1 (searchable) by default.
 *
 * <p>Type: INTEGER (boolean)
 * @apiSince 21
 */

public static final java.lang.String COLUMN_SEARCHABLE = "searchable";

/**
 * The service ID of this channel.
 *
 * <p>It is used to identify the current service, or channel from any other services within
 * a given Transport Stream, if applicable. Use the same coding for {@code service_id} in
 * ETSI EN 300 468 and ARIB STD-B10 or {@code program_number} in ISO/IEC 13818-1.
 *
 * <p>This is a required field only if the underlying broadcast standard defines the same
 * name field, or the current channel is transmitted via the MPEG Transport Stream. Leave
 * empty otherwise.
 *
 * <p>Type: INTEGER
 * @apiSince 21
 */

public static final java.lang.String COLUMN_SERVICE_ID = "service_id";

/**
 * The predefined service type of this TV channel.
 *
 * <p>This is primarily used to indicate whether the current channel is a regular TV channel
 * or a radio-like channel. Use the same coding for {@code service_type} in the underlying
 * broadcast standard if it is defined there (e.g. ATSC A/53, ETSI EN 300 468 and ARIB
 * STD-B10). Otherwise use one of the followings: {@link #SERVICE_TYPE_OTHER},
 * {@link #SERVICE_TYPE_AUDIO_VIDEO}, {@link #SERVICE_TYPE_AUDIO}
 *
 * <p>This is a required field.
 *
 * <p>Type: TEXT
 * @apiSince 21
 */

public static final java.lang.String COLUMN_SERVICE_TYPE = "service_type";

/**
 * The flag indicating whether this TV channel is transient or not.
 *
 * <p>A value of 1 indicates that the channel will be automatically removed by the system on
 * reboot, and a value of 0 indicates that the channel is persistent across reboot. If not
 * specified, this value is set to 0 (not transient) by default.
 *
 * <p>Type: INTEGER (boolean)
 * @see android.media.tv.TvContract.PreviewPrograms#COLUMN_TRANSIENT
 * @see android.media.tv.TvContract.WatchNextPrograms#COLUMN_TRANSIENT
 * @apiSince 26
 */

public static final java.lang.String COLUMN_TRANSIENT = "transient";

/**
 * The transport stream ID of this channel.
 *
 * <p>It is used to identify the Transport Stream that contains the current channel from any
 * other multiplex within a network, if applicable. Use the same coding for
 * {@code transport_stream_id} defined in ISO/IEC 13818-1 if the channel is transmitted via
 * the MPEG Transport Stream.
 *
 * <p>This is a required field only if the current channel is transmitted via the MPEG
 * Transport Stream. Leave empty otherwise.
 *
 * <p>Type: INTEGER
 * @apiSince 21
 */

public static final java.lang.String COLUMN_TRANSPORT_STREAM_ID = "transport_stream_id";

/**
 * The broadcast system type of this TV channel.
 *
 * <p>This is used to indicate the broadcast standard (e.g. ATSC, DVB or ISDB) the current
 * channel conforms to. Use {@link #TYPE_OTHER} for streaming-based channels, which is the
 * default channel type. The value should match one of the followings:
 * {@link #TYPE_1SEG},
 * {@link #TYPE_ATSC_C},
 * {@link #TYPE_ATSC_M_H},
 * {@link #TYPE_ATSC_T},
 * {@link #TYPE_CMMB},
 * {@link #TYPE_DTMB},
 * {@link #TYPE_DVB_C},
 * {@link #TYPE_DVB_C2},
 * {@link #TYPE_DVB_H},
 * {@link #TYPE_DVB_S},
 * {@link #TYPE_DVB_S2},
 * {@link #TYPE_DVB_SH},
 * {@link #TYPE_DVB_T},
 * {@link #TYPE_DVB_T2},
 * {@link #TYPE_ISDB_C},
 * {@link #TYPE_ISDB_S},
 * {@link #TYPE_ISDB_S3},
 * {@link #TYPE_ISDB_T},
 * {@link #TYPE_ISDB_TB},
 * {@link #TYPE_NTSC},
 * {@link #TYPE_OTHER},
 * {@link #TYPE_PAL},
 * {@link #TYPE_SECAM},
 * {@link #TYPE_S_DMB},
 * {@link #TYPE_T_DMB}, and
 * {@link #TYPE_PREVIEW}.
 *
 * <p>This value cannot be changed once it's set. Trying to modify it will make the update
 * fail.
 *
 * <p>This is a required field.
 *
 * <p>Type: TEXT
 * @apiSince 21
 */

public static final java.lang.String COLUMN_TYPE = "type";

/**
 * The version number of this row entry used by TV input services.
 *
 * <p>This is best used by sync adapters to identify the rows to update. The number can be
 * defined by individual TV input services. One may assign the same value as
 * {@code version_number} that appears in ETSI EN 300 468 or ATSC A/65, if the data are
 * coming from a TV broadcast.
 *
 * <p>Type: INTEGER
 * @apiSince 21
 */

public static final java.lang.String COLUMN_VERSION_NUMBER = "version_number";

/**
 * The typical video format for programs from this TV channel.
 *
 * <p>This is primarily used to filter out channels based on video format by applications.
 * The value should match one of the followings: {@link #VIDEO_FORMAT_240P},
 * {@link #VIDEO_FORMAT_360P}, {@link #VIDEO_FORMAT_480I}, {@link #VIDEO_FORMAT_480P},
 * {@link #VIDEO_FORMAT_576I}, {@link #VIDEO_FORMAT_576P}, {@link #VIDEO_FORMAT_720P},
 * {@link #VIDEO_FORMAT_1080I}, {@link #VIDEO_FORMAT_1080P}, {@link #VIDEO_FORMAT_2160P},
 * {@link #VIDEO_FORMAT_4320P}. Note that the actual video resolution of each program from a
 * given channel can vary thus one should use {@link android.media.tv.TvContract.Programs#COLUMN_VIDEO_WIDTH Programs#COLUMN_VIDEO_WIDTH} and
 * {@link android.media.tv.TvContract.Programs#COLUMN_VIDEO_HEIGHT Programs#COLUMN_VIDEO_HEIGHT} to get more accurate video resolution.
 *
 * <p>Type: TEXT
 *
 * @see #getVideoResolution
 * @apiSince 21
 */

public static final java.lang.String COLUMN_VIDEO_FORMAT = "video_format";

/**
 * The MIME type of a single TV channel.
 * @apiSince 21
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/channel";

/**
 * The MIME type of a directory of TV channels.
 * @apiSince 21
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/channel";

/**
 * The content:// style URI for this table.
 *
 * <p>SQL selection is not supported for {@link android.content.ContentResolver#query ContentResolver#query},
 * {@link android.content.ContentResolver#update ContentResolver#update} and {@link android.content.ContentResolver#delete ContentResolver#delete} operations.
 * @apiSince 21
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The service type for radio channels that have audio only.
 * @apiSince 21
 */

public static final java.lang.String SERVICE_TYPE_AUDIO = "SERVICE_TYPE_AUDIO";

/**
 * The service type for regular TV channels that have both audio and video.
 * @apiSince 21
 */

public static final java.lang.String SERVICE_TYPE_AUDIO_VIDEO = "SERVICE_TYPE_AUDIO_VIDEO";

/**
 * A generic service type.
 * @apiSince 21
 */

public static final java.lang.String SERVICE_TYPE_OTHER = "SERVICE_TYPE_OTHER";

/**
 * The channel type for 1seg (handheld).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_1SEG = "TYPE_1SEG";

/**
 * The channel type for ATSC (cable).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_ATSC_C = "TYPE_ATSC_C";

/**
 * The channel type for ATSC-M/H (mobile/handheld).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_ATSC_M_H = "TYPE_ATSC_M_H";

/**
 * The channel type for ATSC (terrestrial).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_ATSC_T = "TYPE_ATSC_T";

/**
 * The channel type for CMMB (handheld).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_CMMB = "TYPE_CMMB";

/**
 * The channel type for DTMB (terrestrial).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_DTMB = "TYPE_DTMB";

/**
 * The channel type for DVB-C (cable).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_DVB_C = "TYPE_DVB_C";

/**
 * The channel type for DVB-C2 (cable).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_DVB_C2 = "TYPE_DVB_C2";

/**
 * The channel type for DVB-H (handheld).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_DVB_H = "TYPE_DVB_H";

/**
 * The channel type for DVB-S (satellite).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_DVB_S = "TYPE_DVB_S";

/**
 * The channel type for DVB-S2 (satellite).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_DVB_S2 = "TYPE_DVB_S2";

/**
 * The channel type for DVB-SH (satellite).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_DVB_SH = "TYPE_DVB_SH";

/**
 * The channel type for DVB-T (terrestrial).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_DVB_T = "TYPE_DVB_T";

/**
 * The channel type for DVB-T2 (terrestrial).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_DVB_T2 = "TYPE_DVB_T2";

/**
 * The channel type for ISDB-C (cable).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_ISDB_C = "TYPE_ISDB_C";

/**
 * The channel type for ISDB-S (satellite).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_ISDB_S = "TYPE_ISDB_S";

/**
 * The channel type for ISDB-S3 (satellite).
 *
 * @see #COLUMN_TYPE
 * @apiSince 29
 */

public static final java.lang.String TYPE_ISDB_S3 = "TYPE_ISDB_S3";

/**
 * The channel type for ISDB-T (terrestrial).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_ISDB_T = "TYPE_ISDB_T";

/**
 * The channel type for ISDB-Tb (Brazil).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_ISDB_TB = "TYPE_ISDB_TB";

/**
 * The channel type for NTSC.
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_NTSC = "TYPE_NTSC";

/**
 * A generic channel type.
 *
 * Use this if the current channel is streaming-based or its broadcast system type does not
 * fit under any other types. This is the default channel type.
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_OTHER = "TYPE_OTHER";

/**
 * The channel type for PAL.
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_PAL = "TYPE_PAL";

/**
 * The channel type for preview videos.
 *
 * <P>Unlike other broadcast TV channel types, the programs in the preview channel usually
 * are promotional videos. The UI may treat the preview channels differently from the other
 * broadcast channels.
 *
 * @see #COLUMN_TYPE
 * @apiSince 26
 */

public static final java.lang.String TYPE_PREVIEW = "TYPE_PREVIEW";

/**
 * The channel type for SECAM.
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_SECAM = "TYPE_SECAM";

/**
 * The channel type for S-DMB (satellite).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_S_DMB = "TYPE_S_DMB";

/**
 * The channel type for T-DMB (terrestrial).
 *
 * @see #COLUMN_TYPE
 * @apiSince 21
 */

public static final java.lang.String TYPE_T_DMB = "TYPE_T_DMB";

/**
 * The video format for 1080i.
 * @apiSince 21
 */

public static final java.lang.String VIDEO_FORMAT_1080I = "VIDEO_FORMAT_1080I";

/**
 * The video format for 1080p.
 * @apiSince 21
 */

public static final java.lang.String VIDEO_FORMAT_1080P = "VIDEO_FORMAT_1080P";

/**
 * The video format for 2160p.
 * @apiSince 21
 */

public static final java.lang.String VIDEO_FORMAT_2160P = "VIDEO_FORMAT_2160P";

/**
 * The video format for 240p.
 * @apiSince 21
 */

public static final java.lang.String VIDEO_FORMAT_240P = "VIDEO_FORMAT_240P";

/**
 * The video format for 360p.
 * @apiSince 21
 */

public static final java.lang.String VIDEO_FORMAT_360P = "VIDEO_FORMAT_360P";

/**
 * The video format for 4320p.
 * @apiSince 21
 */

public static final java.lang.String VIDEO_FORMAT_4320P = "VIDEO_FORMAT_4320P";

/**
 * The video format for 480i.
 * @apiSince 21
 */

public static final java.lang.String VIDEO_FORMAT_480I = "VIDEO_FORMAT_480I";

/**
 * The video format for 480p.
 * @apiSince 21
 */

public static final java.lang.String VIDEO_FORMAT_480P = "VIDEO_FORMAT_480P";

/**
 * The video format for 576i.
 * @apiSince 21
 */

public static final java.lang.String VIDEO_FORMAT_576I = "VIDEO_FORMAT_576I";

/**
 * The video format for 576p.
 * @apiSince 21
 */

public static final java.lang.String VIDEO_FORMAT_576P = "VIDEO_FORMAT_576P";

/**
 * The video format for 720p.
 * @apiSince 21
 */

public static final java.lang.String VIDEO_FORMAT_720P = "VIDEO_FORMAT_720P";

/**
 * The video resolution for enhanced-definition.
 * @apiSince 21
 */

public static final java.lang.String VIDEO_RESOLUTION_ED = "VIDEO_RESOLUTION_ED";

/**
 * The video resolution for full high-definition.
 * @apiSince 21
 */

public static final java.lang.String VIDEO_RESOLUTION_FHD = "VIDEO_RESOLUTION_FHD";

/**
 * The video resolution for high-definition.
 * @apiSince 21
 */

public static final java.lang.String VIDEO_RESOLUTION_HD = "VIDEO_RESOLUTION_HD";

/**
 * The video resolution for standard-definition.
 * @apiSince 21
 */

public static final java.lang.String VIDEO_RESOLUTION_SD = "VIDEO_RESOLUTION_SD";

/**
 * The video resolution for ultra high-definition.
 * @apiSince 21
 */

public static final java.lang.String VIDEO_RESOLUTION_UHD = "VIDEO_RESOLUTION_UHD";
/**
 * A sub-directory of a single TV channel that represents its primary logo.
 *
 * <p>To access this directory, append {@link Channels.Logo#CONTENT_DIRECTORY} to the raw
 * channel URI.  The resulting URI represents an image file, and should be interacted
 * using ContentResolver.openAssetFileDescriptor.
 *
 * <p>Note that this sub-directory also supports opening the logo as an asset file in write
 * mode.  Callers can create or replace the primary logo associated with this channel by
 * opening the asset file and writing the full-size photo contents into it. (Make sure there
 * is no padding around the logo image.) When the file is closed, the image will be parsed,
 * sized down if necessary, and stored.
 *
 * <p>Usage example:
 * <pre>
 * public void writeChannelLogo(long channelId, byte[] logo) {
 *     Uri channelLogoUri = TvContract.buildChannelLogoUri(channelId);
 *     try {
 *         AssetFileDescriptor fd =
 *             getContentResolver().openAssetFileDescriptor(channelLogoUri, "rw");
 *         OutputStream os = fd.createOutputStream();
 *         os.write(logo);
 *         os.close();
 *         fd.close();
 *     } catch (IOException e) {
 *         // Handle error cases.
 *     }
 * }
 * </pre>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Logo {

private Logo() { throw new RuntimeException("Stub!"); }

/**
 * The directory twig for this sub-table.
 * @apiSince 21
 */

public static final java.lang.String CONTENT_DIRECTORY = "logo";
}

}

/**
 * Column definitions for the preview TV programs table.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class PreviewPrograms implements android.media.tv.TvContract.BaseTvColumns {

private PreviewPrograms() { throw new RuntimeException("Stub!"); }

/**
 * The aspect ratio for 16:9.
 *
 * @see #COLUMN_POSTER_ART_ASPECT_RATIO
 * @see #COLUMN_THUMBNAIL_ASPECT_RATIO
 */

public static final int ASPECT_RATIO_16_9 = 0; // 0x0

/**
 * The aspect ratio for 1:1.
 *
 * @see #COLUMN_POSTER_ART_ASPECT_RATIO
 * @see #COLUMN_THUMBNAIL_ASPECT_RATIO
 */

public static final int ASPECT_RATIO_1_1 = 3; // 0x3

/**
 * The aspect ratio for 2:3.
 *
 * @see #COLUMN_POSTER_ART_ASPECT_RATIO
 * @see #COLUMN_THUMBNAIL_ASPECT_RATIO
 */

public static final int ASPECT_RATIO_2_3 = 4; // 0x4

/**
 * The aspect ratio for 3:2.
 *
 * @see #COLUMN_POSTER_ART_ASPECT_RATIO
 * @see #COLUMN_THUMBNAIL_ASPECT_RATIO
 */

public static final int ASPECT_RATIO_3_2 = 1; // 0x1

/**
 * The aspect ratio for 4:3.
 *
 * @see #COLUMN_POSTER_ART_ASPECT_RATIO
 * @see #COLUMN_THUMBNAIL_ASPECT_RATIO
 */

public static final int ASPECT_RATIO_4_3 = 2; // 0x2

/**
 * The availability for "available to this user".
 *
 * @see #COLUMN_AVAILABILITY
 */

public static final int AVAILABILITY_AVAILABLE = 0; // 0x0

/**
 * The availability for "free with subscription".
 *
 * @see #COLUMN_AVAILABILITY
 */

public static final int AVAILABILITY_FREE_WITH_SUBSCRIPTION = 1; // 0x1

/**
 * The availability for "paid content, either to-own or rental
 * (user has not purchased/rented).
 *
 * @see #COLUMN_AVAILABILITY
 */

public static final int AVAILABILITY_PAID_CONTENT = 2; // 0x2

/**
 * The comma-separated audio languages of this TV program.
 *
 * <p>This is used to describe available audio languages included in the program. Use either
 * ISO 639-1 or 639-2/T codes.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_AUDIO_LANGUAGE = "audio_language";

/**
 * The author or artist of this content.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_AUTHOR = "author";

/**
 * The availability of this TV program.
 *
 * <p>The value should match one of the followings:
 * {@link #AVAILABILITY_AVAILABLE},
 * {@link #AVAILABILITY_FREE_WITH_SUBSCRIPTION}, and
 * {@link #AVAILABILITY_PAID_CONTENT}.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_AVAILABILITY = "availability";

/**
 * The flag indicating whether this TV program is browsable or not.
 *
 * <p>This column can only be set by applications having proper system permission. For
 * other applications, this is a read-only column.
 *
 * <p>A value of 1 indicates that the program is browsable and can be shown to users in
 * the UI. A value of 0 indicates that the program should be hidden from users and the
 * application who changes this value to 0 should send
 * {@link #ACTION_WATCH_NEXT_PROGRAM_BROWSABLE_DISABLED} to the owner of the program
 * to notify this change.
 *
 * <p>This value is set to 1 (browsable) by default.
 *
 * <p>Type: INTEGER (boolean)
 */

public static final java.lang.String COLUMN_BROWSABLE = "browsable";

/**
 * The comma-separated canonical genre string of this TV program.
 *
 * <p>Canonical genres are defined in {@link Genres}. Use {@link Genres#encode} to create a
 * text that can be stored in this column. Use {@link Genres#decode} to get the canonical
 * genre strings from the text stored in the column.
 *
 * <p>Type: TEXT
 * @see Genres
 * @see Genres#encode
 * @see Genres#decode
 */

public static final java.lang.String COLUMN_CANONICAL_GENRE = "canonical_genre";

/**
 * The ID of the TV channel that provides this TV program.
 *
 * <p>This value cannot be changed once it's set. Trying to modify it will make the update
 * fail.
 *
 * <p>This is a part of the channel URI and matches to {@link android.provider.BaseColumns#_ID BaseColumns#_ID}.
 *
 * <p>This is a required field.
 *
 * <p>Type: INTEGER (long)
 * @apiSince 26
 */

public static final java.lang.String COLUMN_CHANNEL_ID = "channel_id";

/**
 * The content ID of this TV program.
 *
 * <p>A public ID of the content which allows the application to apply the same operation to
 * all the program copies in different channels.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_CONTENT_ID = "content_id";

/**
 * The comma-separated content ratings of this TV program.
 *
 * <p>This is used to describe the content rating(s) of this program. Each comma-separated
 * content rating sub-string should be generated by calling
 * {@link android.media.tv.TvContentRating#flattenToString TvContentRating#flattenToString}. Note that in most cases the program content is
 * rated by a single rating system, thus resulting in a corresponding single sub-string that
 * does not require comma separation and multiple sub-strings appear only when the program
 * content is rated by two or more content rating systems. If any of those ratings is
 * specified as "blocked rating" in the user's parental control settings, the TV input
 * service should block the current content and wait for the signal that it is okay to
 * unblock.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_CONTENT_RATING = "content_rating";

/**
 * The duration (in milliseconds) of the original content of this preview program.
 *
 * <p>Can be empty.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_DURATION_MILLIS = "duration_millis";

/**
 * The episode display number of this TV program for episodic TV shows.
 *
 * <p>This is used to indicate the episode number. (e.g. 1, 2 or 3) Note that the value
 * does not necessarily be numeric. (e.g. 12B)
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_EPISODE_DISPLAY_NUMBER = "episode_display_number";

/**
 * The episode title of this TV program for episodic TV shows.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_EPISODE_TITLE = "episode_title";

/**
 * The intent URI which is launched when the preview program is selected.
 *
 * <p>The URI is created using {@link android.content.Intent#toUri Intent#toUri} with {@link android.content.Intent#URI_INTENT_SCHEME Intent#URI_INTENT_SCHEME}
 * and converted back to the original intent with {@link android.content.Intent#parseUri Intent#parseUri}. The intent is
 * launched when the user selects the preview program item.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_INTENT_URI = "intent_uri";

/**
 * The interaction count for this program.
 *
 * <p>This indicates the number of times interaction has happened.
 *
 * <p>Type: INTEGER (long)
 * @see #COLUMN_INTERACTION_TYPE
 */

public static final java.lang.String COLUMN_INTERACTION_COUNT = "interaction_count";

/**
 * The type of interaction for this TV program.
 *
 * <p> The value should match one of the followings:
 * {@link #INTERACTION_TYPE_VIEWS},
 * {@link #INTERACTION_TYPE_LISTENS},
 * {@link #INTERACTION_TYPE_FOLLOWERS},
 * {@link #INTERACTION_TYPE_FANS},
 * {@link #INTERACTION_TYPE_LIKES},
 * {@link #INTERACTION_TYPE_THUMBS}, and
 * {@link #INTERACTION_TYPE_VIEWERS}.
 *
 * <p>Type: INTEGER
 * @see #COLUMN_INTERACTION_COUNT
 */

public static final java.lang.String COLUMN_INTERACTION_TYPE = "interaction_type";

/**
 * Internal data used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: BLOB
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_DATA = "internal_provider_data";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG1 = "internal_provider_flag1";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG2 = "internal_provider_flag2";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG3 = "internal_provider_flag3";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG4 = "internal_provider_flag4";

/**
 * The internal ID used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_ID = "internal_provider_id";

/**
 * The count of the items included in this TV program.
 *
 * <p>This is only relevant if the program represents a collection of items such as series,
 * episodes, or music tracks.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_ITEM_COUNT = "item_count";

/**
 * The last playback position (in milliseconds) of the original content of this preview
 * program.
 *
 * <p>Can be empty.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_LAST_PLAYBACK_POSITION_MILLIS = "last_playback_position_millis";

/**
 * The flag indicating whether this TV program is live or not.
 *
 * <p>A value of 1 indicates that the content is airing and should be consumed now, a value
 * of 0 indicates that the content is off the air and does not need to be consumed at the
 * present time. If not specified, the value is set to 0 (not live) by default.
 *
 * <p>Type: INTEGER (boolean)
 */

public static final java.lang.String COLUMN_LIVE = "live";

/**
 * The URI for the logo of this TV program.
 *
 * <p>This is a small badge shown on top of the poster art or thumbnail representing the
 * source of the content.
 *
 * <p>The data in the column must be a URL, or a URI in one of the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})
 * </li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_LOGO_URI = "logo_uri";

/**
 * The detailed, lengthy description of this TV program that is displayed only when the user
 * wants to see more information.
 *
 * <p>TV input services should leave this field empty if they have no additional details
 * beyond {@link #COLUMN_SHORT_DESCRIPTION}.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_LONG_DESCRIPTION = "long_description";

/**
 * The offer price of this TV program.
 *
 * <p>This is the promotional cost of the content. It is only used if the availability of
 * the program is {@link #AVAILABILITY_PAID_CONTENT}.
 *
 * <p>Type: TEXT
 * @see #COLUMN_STARTING_PRICE
 */

public static final java.lang.String COLUMN_OFFER_PRICE = "offer_price";

/**
 * The aspect ratio of the poster art for this TV program.
 *
 * <p>The value should match one of the followings:
 * {@link #ASPECT_RATIO_16_9},
 * {@link #ASPECT_RATIO_3_2},
 * {@link #ASPECT_RATIO_4_3},
 * {@link #ASPECT_RATIO_1_1}, and
 * {@link #ASPECT_RATIO_2_3}.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_POSTER_ART_ASPECT_RATIO = "poster_art_aspect_ratio";

/**
 * The URI for the poster art of this TV program.
 *
 * <p>The data in the column must be a URL, or a URI in one of the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})
 * </li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_POSTER_ART_URI = "poster_art_uri";

/**
 * The URI for the preview video.
 *
 * <p>The data in the column must be a URL, or a URI in one of the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})
 * </li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_PREVIEW_VIDEO_URI = "preview_video_uri";

/**
 * The release date of this TV program.
 *
 * <p>The value should be in one of the following formats:
 * "yyyy", "yyyy-MM-dd", and "yyyy-MM-ddTHH:mm:ssZ" (UTC in ISO 8601).
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_RELEASE_DATE = "release_date";

/**
 * The review rating score for this program.
 *
 * <p>The format of the value is dependent on {@link #COLUMN_REVIEW_RATING_STYLE}. If the
 * style is {@link #REVIEW_RATING_STYLE_STARS}, the value should be a real number between
 * 0.0 and 5.0. (e.g. "4.5") If the style is {@link #REVIEW_RATING_STYLE_THUMBS_UP_DOWN},
 * the value should be two integers, one for thumbs-up count and the other for thumbs-down
 * count, with a comma between them. (e.g. "200,40") If the style is
 * {@link #REVIEW_RATING_STYLE_PERCENTAGE}, the value shoule be a real number between 0 and
 * 100. (e.g. "99.9")
 *
 * <p>Type: TEXT
 * @see #COLUMN_REVIEW_RATING_STYLE
 */

public static final java.lang.String COLUMN_REVIEW_RATING = "review_rating";

/**
 * The review rating score style used for {@link #COLUMN_REVIEW_RATING}.
 *
 * <p> The value should match one of the followings: {@link #REVIEW_RATING_STYLE_STARS},
 * {@link #REVIEW_RATING_STYLE_THUMBS_UP_DOWN}, and {@link #REVIEW_RATING_STYLE_PERCENTAGE}.
 *
 * <p>Type: INTEGER
 * @see #COLUMN_REVIEW_RATING
 */

public static final java.lang.String COLUMN_REVIEW_RATING_STYLE = "review_rating_style";

/**
 * The flag indicating whether this TV program is searchable or not.
 *
 * <p>The columns of searchable programs can be read by other applications that have proper
 * permission. Care must be taken not to open sensitive data.
 *
 * <p>A value of 1 indicates that the program is searchable and its columns can be read by
 * other applications, a value of 0 indicates that the program is hidden and its columns can
 * be read only by the package that owns the program and the system. If not specified, this
 * value is set to 1 (searchable) by default.
 *
 * <p>Type: INTEGER (boolean)
 */

public static final java.lang.String COLUMN_SEARCHABLE = "searchable";

/**
 * The season display number of this TV program for episodic TV shows.
 *
 * <p>This is used to indicate the season number. (e.g. 1, 2 or 3) Note that the value
 * does not necessarily be numeric. (e.g. 12B)
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_SEASON_DISPLAY_NUMBER = "season_display_number";

/**
 * The title of the season for this TV program for episodic TV shows.
 *
 * <p>This is an optional field supplied only when the season has a special title
 * (e.g. The Final Season). If provided, the applications should display it instead of
 * {@link #COLUMN_SEASON_DISPLAY_NUMBER}, and should display it without alterations.
 * (e.g. for "The Final Season", displayed string should be "The Final Season", not
 * "Season The Final Season"). When displaying multiple programs, the order should be based
 * on {@link #COLUMN_SEASON_DISPLAY_NUMBER}, even when {@link #COLUMN_SEASON_TITLE} exists.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_SEASON_TITLE = "season_title";

/**
 * The series ID of this TV program for episodic TV shows.
 *
 * <p>This is used to indicate the series ID. Programs in the same series share a series ID.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_SERIES_ID = "series_id";

/**
 * The short description of this TV program that is displayed to the user by default.
 *
 * <p>It is recommended to limit the length of the descriptions to 256 characters.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_SHORT_DESCRIPTION = "short_description";

/**
 * The starting price of this TV program.
 *
 * <p>This indicates the lowest regular acquisition cost of the content. It is only used
 * if the availability of the program is {@link #AVAILABILITY_PAID_CONTENT}.
 *
 * <p>Type: TEXT
 * @see #COLUMN_OFFER_PRICE
 */

public static final java.lang.String COLUMN_STARTING_PRICE = "starting_price";

/**
 * The aspect ratio of the thumbnail for this TV program.
 *
 * <p>The value should match one of the followings:
 * {@link #ASPECT_RATIO_16_9},
 * {@link #ASPECT_RATIO_3_2},
 * {@link #ASPECT_RATIO_4_3},
 * {@link #ASPECT_RATIO_1_1}, and
 * {@link #ASPECT_RATIO_2_3}.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_THUMBNAIL_ASPECT_RATIO = "poster_thumbnail_aspect_ratio";

/**
 * The URI for the thumbnail of this TV program.
 *
 * <p>The system can generate a thumbnail from the poster art if this column is not
 * specified. Thus it is not necessary for TV input services to include a thumbnail if it is
 * just a scaled image of the poster art.
 *
 * <p>The data in the column must be a URL, or a URI in one of the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})
 * </li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_THUMBNAIL_URI = "thumbnail_uri";

/**
 * The title of this TV program.
 *
 * <p>If this program is an episodic TV show, it is recommended that the title is the series
 * title and its related fields ({@link #COLUMN_SEASON_TITLE} and/or
 * {@link #COLUMN_SEASON_DISPLAY_NUMBER}, {@link #COLUMN_SEASON_DISPLAY_NUMBER},
 * {@link #COLUMN_EPISODE_DISPLAY_NUMBER}, and {@link #COLUMN_EPISODE_TITLE}) are filled in.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_TITLE = "title";

/**
 * The flag indicating whether this program is transient or not.
 *
 * <p>A value of 1 indicates that the channel will be automatically removed by the system on
 * reboot, and a value of 0 indicates that the channel is persistent across reboot. If not
 * specified, this value is set to 0 (not transient) by default.
 *
 * <p>Type: INTEGER (boolean)
 * @see android.media.tv.TvContract.Channels#COLUMN_TRANSIENT
 */

public static final java.lang.String COLUMN_TRANSIENT = "transient";

/**
 * The type of this program content.
 *
 * <p>The value should match one of the followings:
 * {@link #TYPE_MOVIE},
 * {@link #TYPE_TV_SERIES},
 * {@link #TYPE_TV_SEASON},
 * {@link #TYPE_TV_EPISODE},
 * {@link #TYPE_CLIP},
 * {@link #TYPE_EVENT},
 * {@link #TYPE_CHANNEL},
 * {@link #TYPE_TRACK},
 * {@link #TYPE_ALBUM},
 * {@link #TYPE_ARTIST},
 * {@link #TYPE_PLAYLIST}, and
 * {@link #TYPE_STATION}.
 *
 * <p>This is a required field if the program is from a {@link android.media.tv.TvContract.Channels#TYPE_PREVIEW Channels#TYPE_PREVIEW}
 * channel.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_TYPE = "type";

/**
 * The version number of this row entry used by TV input services.
 *
 * <p>This is best used by sync adapters to identify the rows to update. The number can be
 * defined by individual TV input services. One may assign the same value as
 * {@code version_number} in ETSI EN 300 468 or ATSC A/65, if the data are coming from a TV
 * broadcast.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_VERSION_NUMBER = "version_number";

/**
 * The height of the video for this TV program, in the unit of pixels.
 *
 * <p>Together with {@link #COLUMN_VIDEO_WIDTH} this is used to determine the video
 * resolution of the current TV program. Can be empty if it is not known initially or the
 * program does not convey any video such as the programs from type
 * {@link android.media.tv.TvContract.Channels#SERVICE_TYPE_AUDIO Channels#SERVICE_TYPE_AUDIO} channels.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_VIDEO_HEIGHT = "video_height";

/**
 * The width of the video for this TV program, in the unit of pixels.
 *
 * <p>Together with {@link #COLUMN_VIDEO_HEIGHT} this is used to determine the video
 * resolution of the current TV program. Can be empty if it is not known initially or the
 * program does not convey any video such as the programs from type
 * {@link android.media.tv.TvContract.Channels#SERVICE_TYPE_AUDIO Channels#SERVICE_TYPE_AUDIO} channels.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_VIDEO_WIDTH = "video_width";

/**
 * The weight of the preview program within the channel.
 *
 * <p>The UI may choose to show this item in a different position in the channel row.
 * A larger weight value means the program is more important than other programs having
 * smaller weight values. The value is relevant for the preview programs in the same
 * channel. This is only relevant to {@link android.media.tv.TvContract.Channels#TYPE_PREVIEW Channels#TYPE_PREVIEW}.
 *
 * <p>Can be empty.
 *
 * <p>Type: INTEGER
 * @apiSince 26
 */

public static final java.lang.String COLUMN_WEIGHT = "weight";

/**
 * The MIME type of a single preview TV program.
 * @apiSince 26
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/preview_program";

/**
 * The MIME type of a directory of preview TV programs.
 * @apiSince 26
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/preview_program";

/**
 * The content:// style URI for this table.
 *
 * <p>SQL selection is not supported for {@link android.content.ContentResolver#query ContentResolver#query},
 * {@link android.content.ContentResolver#update ContentResolver#update} and {@link android.content.ContentResolver#delete ContentResolver#delete} operations.
 * @apiSince 26
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The interaction type for "fans".
 *
 * @see #COLUMN_INTERACTION_TYPE
 */

public static final int INTERACTION_TYPE_FANS = 3; // 0x3

/**
 * The interaction type for "followers".
 *
 * @see #COLUMN_INTERACTION_TYPE
 */

public static final int INTERACTION_TYPE_FOLLOWERS = 2; // 0x2

/**
 * The interaction type for "likes".
 *
 * @see #COLUMN_INTERACTION_TYPE
 */

public static final int INTERACTION_TYPE_LIKES = 4; // 0x4

/**
 * The interaction type for "listens".
 *
 * @see #COLUMN_INTERACTION_TYPE
 */

public static final int INTERACTION_TYPE_LISTENS = 1; // 0x1

/**
 * The interaction type for "thumbs".
 *
 * @see #COLUMN_INTERACTION_TYPE
 */

public static final int INTERACTION_TYPE_THUMBS = 5; // 0x5

/**
 * The interaction type for "viewers".
 *
 * @see #COLUMN_INTERACTION_TYPE
 */

public static final int INTERACTION_TYPE_VIEWERS = 6; // 0x6

/**
 * The interaction type for "views".
 *
 * @see #COLUMN_INTERACTION_TYPE
 */

public static final int INTERACTION_TYPE_VIEWS = 0; // 0x0

/**
 * The review rating style for 0 to 100 point system.
 *
 * @see #COLUMN_REVIEW_RATING_STYLE
 */

public static final int REVIEW_RATING_STYLE_PERCENTAGE = 2; // 0x2

/**
 * The review rating style for five star rating.
 *
 * @see #COLUMN_REVIEW_RATING_STYLE
 */

public static final int REVIEW_RATING_STYLE_STARS = 0; // 0x0

/**
 * The review rating style for thumbs-up and thumbs-down rating.
 *
 * @see #COLUMN_REVIEW_RATING_STYLE
 */

public static final int REVIEW_RATING_STYLE_THUMBS_UP_DOWN = 1; // 0x1

/**
 * The program type for album.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_ALBUM = 8; // 0x8

/**
 * The program type for artist.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_ARTIST = 9; // 0x9

/**
 * The program type for channel.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_CHANNEL = 6; // 0x6

/**
 * The program type for clip.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_CLIP = 4; // 0x4

/**
 * The program type for event.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_EVENT = 5; // 0x5

/**
 * The program type for movie.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_MOVIE = 0; // 0x0

/**
 * The program type for playlist.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_PLAYLIST = 10; // 0xa

/**
 * The program type for station.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_STATION = 11; // 0xb

/**
 * The program type for track.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_TRACK = 7; // 0x7

/**
 * The program type for TV episode.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_TV_EPISODE = 3; // 0x3

/**
 * The program type for TV season.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_TV_SEASON = 2; // 0x2

/**
 * The program type for TV series.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_TV_SERIES = 1; // 0x1
}

/**
 * Column definitions for the TV programs table.
 *
 * <p>By default, the query results will be sorted by
 * {@link android.media.tv.TvContract.Programs#COLUMN_START_TIME_UTC_MILLIS Programs#COLUMN_START_TIME_UTC_MILLIS} in ascending order.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Programs implements android.media.tv.TvContract.BaseTvColumns {

private Programs() { throw new RuntimeException("Stub!"); }

/**
 * The comma-separated audio languages of this TV program.
 *
 * <p>This is used to describe available audio languages included in the program. Use either
 * ISO 639-1 or 639-2/T codes.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_AUDIO_LANGUAGE = "audio_language";

/**
 * The comma-separated genre string of this TV program.
 *
 * <p>Use the same language appeared in the underlying broadcast standard, if applicable.
 * (For example, one can refer to the genre strings used in Genre Descriptor of ATSC A/65 or
 * Content Descriptor of ETSI EN 300 468, if appropriate.) Otherwise, leave empty. Use
 * {@link android.media.tv.TvContract.Programs.Genres#encode Genres#encode} to create a text that can be stored in this column. Use
 * {@link android.media.tv.TvContract.Programs.Genres#decode Genres#decode} to get the broadcast genre strings from the text stored in the
 * column.
 *
 * <p>Type: TEXT
 * @see android.media.tv.TvContract.Programs.Genres#encode
 * @see android.media.tv.TvContract.Programs.Genres#decode
 * @apiSince 21
 */

public static final java.lang.String COLUMN_BROADCAST_GENRE = "broadcast_genre";

/**
 * The comma-separated canonical genre string of this TV program.
 *
 * <p>Canonical genres are defined in {@link Genres}. Use {@link Genres#encode} to create a
 * text that can be stored in this column. Use {@link Genres#decode} to get the canonical
 * genre strings from the text stored in the column.
 *
 * <p>Type: TEXT
 * @see Genres
 * @see Genres#encode
 * @see Genres#decode
 */

public static final java.lang.String COLUMN_CANONICAL_GENRE = "canonical_genre";

/**
 * The ID of the TV channel that provides this TV program.
 *
 * <p>This is a part of the channel URI and matches to {@link android.provider.BaseColumns#_ID BaseColumns#_ID}.
 *
 * <p>This is a required field.
 *
 * <p>Type: INTEGER (long)
 * @apiSince 21
 */

public static final java.lang.String COLUMN_CHANNEL_ID = "channel_id";

/**
 * The comma-separated content ratings of this TV program.
 *
 * <p>This is used to describe the content rating(s) of this program. Each comma-separated
 * content rating sub-string should be generated by calling
 * {@link android.media.tv.TvContentRating#flattenToString TvContentRating#flattenToString}. Note that in most cases the program content is
 * rated by a single rating system, thus resulting in a corresponding single sub-string that
 * does not require comma separation and multiple sub-strings appear only when the program
 * content is rated by two or more content rating systems. If any of those ratings is
 * specified as "blocked rating" in the user's parental control settings, the TV input
 * service should block the current content and wait for the signal that it is okay to
 * unblock.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_CONTENT_RATING = "content_rating";

/**
 * The end time of this TV program, in milliseconds since the epoch.
 *
 * <p>The value should be equal to or less than {@link #COLUMN_START_TIME_UTC_MILLIS} of the
 * next program in the same channel. In practice, end time will usually be the start time of
 * the next program.
 *
 * <p>Can be empty if this program belongs to a {@link android.media.tv.TvContract.Channels#TYPE_PREVIEW Channels#TYPE_PREVIEW} channel.
 *
 * <p>Type: INTEGER (long)
 * @apiSince 21
 */

public static final java.lang.String COLUMN_END_TIME_UTC_MILLIS = "end_time_utc_millis";

/**
 * The episode display number of this TV program for episodic TV shows.
 *
 * <p>This is used to indicate the episode number. (e.g. 1, 2 or 3) Note that the value
 * does not necessarily be numeric. (e.g. 12B)
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_EPISODE_DISPLAY_NUMBER = "episode_display_number";

/**
 * The episode number of this TV program for episodic TV shows.
 *
 * <p>Can be empty.
 *
 * <p>Type: INTEGER
 *
 * @deprecated Use {@link #COLUMN_EPISODE_DISPLAY_NUMBER} instead.
 * @apiSince 21
 * @deprecatedSince 24
 */

@Deprecated public static final java.lang.String COLUMN_EPISODE_NUMBER = "episode_number";

/**
 * The episode title of this TV program for episodic TV shows.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_EPISODE_TITLE = "episode_title";

/**
 * Internal data used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: BLOB
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_DATA = "internal_provider_data";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG1 = "internal_provider_flag1";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG2 = "internal_provider_flag2";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG3 = "internal_provider_flag3";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG4 = "internal_provider_flag4";

/**
 * The detailed, lengthy description of this TV program that is displayed only when the user
 * wants to see more information.
 *
 * <p>TV input services should leave this field empty if they have no additional details
 * beyond {@link #COLUMN_SHORT_DESCRIPTION}.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_LONG_DESCRIPTION = "long_description";

/**
 * The URI for the poster art of this TV program.
 *
 * <p>The data in the column must be a URL, or a URI in one of the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})
 * </li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_POSTER_ART_URI = "poster_art_uri";

/**
 * The flag indicating whether recording of this program is prohibited.
 *
 * <p>A value of 1 indicates that recording of this program is prohibited and application
 * will not schedule any recording for this program. A value of 0 indicates that the
 * recording is not prohibited. If not specified, this value is set to 0 (not prohibited) by
 * default.
 *
 * <p>Type: INTEGER (boolean)
 * @apiSince 24
 */

public static final java.lang.String COLUMN_RECORDING_PROHIBITED = "recording_prohibited";

/**
 * The review rating score for this program.
 *
 * <p>The format of the value is dependent on {@link #COLUMN_REVIEW_RATING_STYLE}. If the
 * style is {@link #REVIEW_RATING_STYLE_STARS}, the value should be a real number between
 * 0.0 and 5.0. (e.g. "4.5") If the style is {@link #REVIEW_RATING_STYLE_THUMBS_UP_DOWN},
 * the value should be two integers, one for thumbs-up count and the other for thumbs-down
 * count, with a comma between them. (e.g. "200,40") If the style is
 * {@link #REVIEW_RATING_STYLE_PERCENTAGE}, the value shoule be a real number between 0 and
 * 100. (e.g. "99.9")
 *
 * <p>Type: TEXT
 * @see #COLUMN_REVIEW_RATING_STYLE
 */

public static final java.lang.String COLUMN_REVIEW_RATING = "review_rating";

/**
 * The review rating score style used for {@link #COLUMN_REVIEW_RATING}.
 *
 * <p> The value should match one of the followings: {@link #REVIEW_RATING_STYLE_STARS},
 * {@link #REVIEW_RATING_STYLE_THUMBS_UP_DOWN}, and {@link #REVIEW_RATING_STYLE_PERCENTAGE}.
 *
 * <p>Type: INTEGER
 * @see #COLUMN_REVIEW_RATING
 */

public static final java.lang.String COLUMN_REVIEW_RATING_STYLE = "review_rating_style";

/**
 * The flag indicating whether this TV program is searchable or not.
 *
 * <p>The columns of searchable programs can be read by other applications that have proper
 * permission. Care must be taken not to open sensitive data.
 *
 * <p>A value of 1 indicates that the program is searchable and its columns can be read by
 * other applications, a value of 0 indicates that the program is hidden and its columns can
 * be read only by the package that owns the program and the system. If not specified, this
 * value is set to 1 (searchable) by default.
 *
 * <p>Type: INTEGER (boolean)
 */

public static final java.lang.String COLUMN_SEARCHABLE = "searchable";

/**
 * The season display number of this TV program for episodic TV shows.
 *
 * <p>This is used to indicate the season number. (e.g. 1, 2 or 3) Note that the value
 * does not necessarily be numeric. (e.g. 12B)
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_SEASON_DISPLAY_NUMBER = "season_display_number";

/**
 * The season number of this TV program for episodic TV shows.
 *
 * <p>Can be empty.
 *
 * <p>Type: INTEGER
 *
 * @deprecated Use {@link #COLUMN_SEASON_DISPLAY_NUMBER} instead.
 * @apiSince 21
 * @deprecatedSince 24
 */

@Deprecated public static final java.lang.String COLUMN_SEASON_NUMBER = "season_number";

/**
 * The title of the season for this TV program for episodic TV shows.
 *
 * <p>This is an optional field supplied only when the season has a special title
 * (e.g. The Final Season). If provided, the applications should display it instead of
 * {@link #COLUMN_SEASON_DISPLAY_NUMBER}, and should display it without alterations.
 * (e.g. for "The Final Season", displayed string should be "The Final Season", not
 * "Season The Final Season"). When displaying multiple programs, the order should be based
 * on {@link #COLUMN_SEASON_DISPLAY_NUMBER}, even when {@link #COLUMN_SEASON_TITLE} exists.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_SEASON_TITLE = "season_title";

/**
 * The series ID of this TV program for episodic TV shows.
 *
 * <p>This is used to indicate the series ID. Programs in the same series share a series ID.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_SERIES_ID = "series_id";

/**
 * The short description of this TV program that is displayed to the user by default.
 *
 * <p>It is recommended to limit the length of the descriptions to 256 characters.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_SHORT_DESCRIPTION = "short_description";

/**
 * The start time of this TV program, in milliseconds since the epoch.
 *
 * <p>The value should be equal to or larger than {@link #COLUMN_END_TIME_UTC_MILLIS} of the
 * previous program in the same channel. In practice, start time will usually be the end
 * time of the previous program.
 *
 * <p>Can be empty if this program belongs to a {@link android.media.tv.TvContract.Channels#TYPE_PREVIEW Channels#TYPE_PREVIEW} channel.
 *
 * <p>Type: INTEGER (long)
 * @apiSince 21
 */

public static final java.lang.String COLUMN_START_TIME_UTC_MILLIS = "start_time_utc_millis";

/**
 * The URI for the thumbnail of this TV program.
 *
 * <p>The system can generate a thumbnail from the poster art if this column is not
 * specified. Thus it is not necessary for TV input services to include a thumbnail if it is
 * just a scaled image of the poster art.
 *
 * <p>The data in the column must be a URL, or a URI in one of the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})
 * </li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_THUMBNAIL_URI = "thumbnail_uri";

/**
 * The title of this TV program.
 *
 * <p>If this program is an episodic TV show, it is recommended that the title is the series
 * title and its related fields ({@link #COLUMN_SEASON_TITLE} and/or
 * {@link #COLUMN_SEASON_DISPLAY_NUMBER}, {@link #COLUMN_SEASON_DISPLAY_NUMBER},
 * {@link #COLUMN_EPISODE_DISPLAY_NUMBER}, and {@link #COLUMN_EPISODE_TITLE}) are filled in.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_TITLE = "title";

/**
 * The version number of this row entry used by TV input services.
 *
 * <p>This is best used by sync adapters to identify the rows to update. The number can be
 * defined by individual TV input services. One may assign the same value as
 * {@code version_number} in ETSI EN 300 468 or ATSC A/65, if the data are coming from a TV
 * broadcast.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_VERSION_NUMBER = "version_number";

/**
 * The height of the video for this TV program, in the unit of pixels.
 *
 * <p>Together with {@link #COLUMN_VIDEO_WIDTH} this is used to determine the video
 * resolution of the current TV program. Can be empty if it is not known initially or the
 * program does not convey any video such as the programs from type
 * {@link android.media.tv.TvContract.Channels#SERVICE_TYPE_AUDIO Channels#SERVICE_TYPE_AUDIO} channels.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_VIDEO_HEIGHT = "video_height";

/**
 * The width of the video for this TV program, in the unit of pixels.
 *
 * <p>Together with {@link #COLUMN_VIDEO_HEIGHT} this is used to determine the video
 * resolution of the current TV program. Can be empty if it is not known initially or the
 * program does not convey any video such as the programs from type
 * {@link android.media.tv.TvContract.Channels#SERVICE_TYPE_AUDIO Channels#SERVICE_TYPE_AUDIO} channels.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_VIDEO_WIDTH = "video_width";

/**
 * The MIME type of a single TV program.
 * @apiSince 21
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/program";

/**
 * The MIME type of a directory of TV programs.
 * @apiSince 21
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/program";

/**
 * The content:// style URI for this table.
 *
 * <p>SQL selection is not supported for {@link android.content.ContentResolver#query ContentResolver#query},
 * {@link android.content.ContentResolver#update ContentResolver#update} and {@link android.content.ContentResolver#delete ContentResolver#delete} operations.
 * @apiSince 21
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The review rating style for 0 to 100 point system.
 *
 * @see #COLUMN_REVIEW_RATING_STYLE
 */

public static final int REVIEW_RATING_STYLE_PERCENTAGE = 2; // 0x2

/**
 * The review rating style for five star rating.
 *
 * @see #COLUMN_REVIEW_RATING_STYLE
 */

public static final int REVIEW_RATING_STYLE_STARS = 0; // 0x0

/**
 * The review rating style for thumbs-up and thumbs-down rating.
 *
 * @see #COLUMN_REVIEW_RATING_STYLE
 */

public static final int REVIEW_RATING_STYLE_THUMBS_UP_DOWN = 1; // 0x1
/**
 * Canonical genres for TV programs.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Genres {

private Genres() { throw new RuntimeException("Stub!"); }

/**
 * Encodes genre strings to a text that can be put into the database.
 *
 * @param genres Genre strings.
 * This value must never be {@code null}.
 * Value is {@link android.media.tv.TvContract.Programs.Genres#FAMILY_KIDS}, {@link android.media.tv.TvContract.Programs.Genres#SPORTS}, {@link android.media.tv.TvContract.Programs.Genres#SHOPPING}, {@link android.media.tv.TvContract.Programs.Genres#MOVIES}, {@link android.media.tv.TvContract.Programs.Genres#COMEDY}, {@link android.media.tv.TvContract.Programs.Genres#TRAVEL}, {@link android.media.tv.TvContract.Programs.Genres#DRAMA}, {@link android.media.tv.TvContract.Programs.Genres#EDUCATION}, {@link android.media.tv.TvContract.Programs.Genres#ANIMAL_WILDLIFE}, {@link android.media.tv.TvContract.Programs.Genres#NEWS}, {@link android.media.tv.TvContract.Programs.Genres#GAMING}, {@link android.media.tv.TvContract.Programs.Genres#ARTS}, {@link android.media.tv.TvContract.Programs.Genres#ENTERTAINMENT}, {@link android.media.tv.TvContract.Programs.Genres#LIFE_STYLE}, {@link android.media.tv.TvContract.Programs.Genres#MUSIC}, {@link android.media.tv.TvContract.Programs.Genres#PREMIER}, or {@link android.media.tv.TvContract.Programs.Genres#TECH_SCIENCE}
 * @return an encoded genre string that can be inserted into the
 *         {@link #COLUMN_BROADCAST_GENRE} or {@link #COLUMN_CANONICAL_GENRE} column.
 * @apiSince 21
 */

public static java.lang.String encode(@androidx.annotation.NonNull java.lang.String... genres) { throw new RuntimeException("Stub!"); }

/**
 * Decodes the genre strings from the text stored in the database.
 *
 * @param genres The encoded genre string retrieved from the
 *            {@link #COLUMN_BROADCAST_GENRE} or {@link #COLUMN_CANONICAL_GENRE} column.
 * This value must never be {@code null}.
 * @return genre strings.
 
 * Value is {@link android.media.tv.TvContract.Programs.Genres#FAMILY_KIDS}, {@link android.media.tv.TvContract.Programs.Genres#SPORTS}, {@link android.media.tv.TvContract.Programs.Genres#SHOPPING}, {@link android.media.tv.TvContract.Programs.Genres#MOVIES}, {@link android.media.tv.TvContract.Programs.Genres#COMEDY}, {@link android.media.tv.TvContract.Programs.Genres#TRAVEL}, {@link android.media.tv.TvContract.Programs.Genres#DRAMA}, {@link android.media.tv.TvContract.Programs.Genres#EDUCATION}, {@link android.media.tv.TvContract.Programs.Genres#ANIMAL_WILDLIFE}, {@link android.media.tv.TvContract.Programs.Genres#NEWS}, {@link android.media.tv.TvContract.Programs.Genres#GAMING}, {@link android.media.tv.TvContract.Programs.Genres#ARTS}, {@link android.media.tv.TvContract.Programs.Genres#ENTERTAINMENT}, {@link android.media.tv.TvContract.Programs.Genres#LIFE_STYLE}, {@link android.media.tv.TvContract.Programs.Genres#MUSIC}, {@link android.media.tv.TvContract.Programs.Genres#PREMIER}, or {@link android.media.tv.TvContract.Programs.Genres#TECH_SCIENCE}
 * @apiSince 21
 */

public static java.lang.String[] decode(@androidx.annotation.NonNull java.lang.String genres) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether a given text is a canonical genre defined in {@link android.media.tv.TvContract.Programs.Genres Genres}.
 *
 * @param genre The name of genre to be checked.
 * @return {@code true} if the genre is canonical, otherwise {@code false}.
 * @apiSince 24
 */

public static boolean isCanonical(java.lang.String genre) { throw new RuntimeException("Stub!"); }

/**
 * The genre for Animal/Wildlife.
 * @apiSince 21
 */

public static final java.lang.String ANIMAL_WILDLIFE = "ANIMAL_WILDLIFE";

/**
 * The genre for Arts.
 * @apiSince 22
 */

public static final java.lang.String ARTS = "ARTS";

/**
 * The genre for Comedy.
 * @apiSince 21
 */

public static final java.lang.String COMEDY = "COMEDY";

/**
 * The genre for Drama.
 * @apiSince 21
 */

public static final java.lang.String DRAMA = "DRAMA";

/**
 * The genre for Education.
 * @apiSince 21
 */

public static final java.lang.String EDUCATION = "EDUCATION";

/**
 * The genre for Entertainment.
 * @apiSince 22
 */

public static final java.lang.String ENTERTAINMENT = "ENTERTAINMENT";

/**
 * The genre for Family/Kids.
 * @apiSince 21
 */

public static final java.lang.String FAMILY_KIDS = "FAMILY_KIDS";

/**
 * The genre for Gaming.
 * @apiSince 21
 */

public static final java.lang.String GAMING = "GAMING";

/**
 * The genre for Life Style.
 * @apiSince 22
 */

public static final java.lang.String LIFE_STYLE = "LIFE_STYLE";

/**
 * The genre for Movies.
 * @apiSince 21
 */

public static final java.lang.String MOVIES = "MOVIES";

/**
 * The genre for Music.
 * @apiSince 22
 */

public static final java.lang.String MUSIC = "MUSIC";

/**
 * The genre for News.
 * @apiSince 21
 */

public static final java.lang.String NEWS = "NEWS";

/**
 * The genre for Premier.
 * @apiSince 22
 */

public static final java.lang.String PREMIER = "PREMIER";

/**
 * The genre for Shopping.
 * @apiSince 21
 */

public static final java.lang.String SHOPPING = "SHOPPING";

/**
 * The genre for Sports.
 * @apiSince 21
 */

public static final java.lang.String SPORTS = "SPORTS";

/**
 * The genre for Tech/Science.
 * @apiSince 22
 */

public static final java.lang.String TECH_SCIENCE = "TECH_SCIENCE";

/**
 * The genre for Travel.
 * @apiSince 21
 */

public static final java.lang.String TRAVEL = "TRAVEL";
}

}

/**
 * Column definitions for the recorded TV programs table.
 *
 * <p>By default, the query results will be sorted by {@link #COLUMN_START_TIME_UTC_MILLIS} in
 * ascending order.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class RecordedPrograms implements android.media.tv.TvContract.BaseTvColumns {

private RecordedPrograms() { throw new RuntimeException("Stub!"); }

/**
 * The comma-separated audio languages of this TV program.
 *
 * <p>This is used to describe available audio languages included in the program. Use either
 * ISO 639-1 or 639-2/T codes.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_AUDIO_LANGUAGE = "audio_language";

/**
 * The comma-separated genre string of this recorded TV program.
 *
 * <p>Use the same language appeared in the underlying broadcast standard, if applicable.
 * (For example, one can refer to the genre strings used in Genre Descriptor of ATSC A/65 or
 * Content Descriptor of ETSI EN 300 468, if appropriate.) Otherwise, leave empty. Use
 * {@link Genres#encode Genres.encode()} to create a text that can be stored in this column.
 * Use {@link Genres#decode Genres.decode()} to get the broadcast genre strings from the
 * text stored in the column.
 *
 * <p>Type: TEXT
 * @see android.media.tv.TvContract.Programs#COLUMN_BROADCAST_GENRE
 * @apiSince 24
 */

public static final java.lang.String COLUMN_BROADCAST_GENRE = "broadcast_genre";

/**
 * The comma-separated canonical genre string of this TV program.
 *
 * <p>Canonical genres are defined in {@link Genres}. Use {@link Genres#encode} to create a
 * text that can be stored in this column. Use {@link Genres#decode} to get the canonical
 * genre strings from the text stored in the column.
 *
 * <p>Type: TEXT
 * @see Genres
 * @see Genres#encode
 * @see Genres#decode
 */

public static final java.lang.String COLUMN_CANONICAL_GENRE = "canonical_genre";

/**
 * The ID of the TV channel that provides this recorded program.
 *
 * <p>This is a part of the channel URI and matches to {@link android.provider.BaseColumns#_ID BaseColumns#_ID}.
 *
 * <p>Type: INTEGER (long)
 * @apiSince 24
 */

public static final java.lang.String COLUMN_CHANNEL_ID = "channel_id";

/**
 * The comma-separated content ratings of this TV program.
 *
 * <p>This is used to describe the content rating(s) of this program. Each comma-separated
 * content rating sub-string should be generated by calling
 * {@link android.media.tv.TvContentRating#flattenToString TvContentRating#flattenToString}. Note that in most cases the program content is
 * rated by a single rating system, thus resulting in a corresponding single sub-string that
 * does not require comma separation and multiple sub-strings appear only when the program
 * content is rated by two or more content rating systems. If any of those ratings is
 * specified as "blocked rating" in the user's parental control settings, the TV input
 * service should block the current content and wait for the signal that it is okay to
 * unblock.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_CONTENT_RATING = "content_rating";

/**
 * The end time of the original TV program, in milliseconds since the epoch.
 *
 * <p>Type: INTEGER (long)
 * @see android.media.tv.TvContract.Programs#COLUMN_END_TIME_UTC_MILLIS
 * @apiSince 24
 */

public static final java.lang.String COLUMN_END_TIME_UTC_MILLIS = "end_time_utc_millis";

/**
 * The episode display number of this TV program for episodic TV shows.
 *
 * <p>This is used to indicate the episode number. (e.g. 1, 2 or 3) Note that the value
 * does not necessarily be numeric. (e.g. 12B)
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_EPISODE_DISPLAY_NUMBER = "episode_display_number";

/**
 * The episode title of this TV program for episodic TV shows.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_EPISODE_TITLE = "episode_title";

/**
 * The ID of the TV input service that is associated with this recorded program.
 *
 * <p>Use {@link #buildInputId} to build the ID.
 *
 * <p>This is a required field.
 *
 * <p>Type: TEXT
 * @apiSince 24
 */

public static final java.lang.String COLUMN_INPUT_ID = "input_id";

/**
 * Internal data used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: BLOB
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_DATA = "internal_provider_data";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG1 = "internal_provider_flag1";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG2 = "internal_provider_flag2";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG3 = "internal_provider_flag3";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG4 = "internal_provider_flag4";

/**
 * The detailed, lengthy description of this TV program that is displayed only when the user
 * wants to see more information.
 *
 * <p>TV input services should leave this field empty if they have no additional details
 * beyond {@link #COLUMN_SHORT_DESCRIPTION}.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_LONG_DESCRIPTION = "long_description";

/**
 * The URI for the poster art of this TV program.
 *
 * <p>The data in the column must be a URL, or a URI in one of the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})
 * </li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_POSTER_ART_URI = "poster_art_uri";

/**
 * The data size (in bytes) for this recorded program.
 *
 * <p>Together with {@link #COLUMN_RECORDING_DATA_URI}, applications can use this
 * information to manage recording storage.
 *
 * <p>Type: INTEGER (long)
 * @see #COLUMN_RECORDING_DATA_URI
 * @apiSince 24
 */

public static final java.lang.String COLUMN_RECORDING_DATA_BYTES = "recording_data_bytes";

/**
 * The URI of the recording data for this recorded program.
 *
 * <p>Together with {@link #COLUMN_RECORDING_DATA_BYTES}, applications can use this
 * information to manage recording storage. The URI should indicate a file or directory with
 * the scheme {@link android.content.ContentResolver#SCHEME_FILE}.
 *
 * <p>Type: TEXT
 * @see #COLUMN_RECORDING_DATA_BYTES
 * @apiSince 24
 */

public static final java.lang.String COLUMN_RECORDING_DATA_URI = "recording_data_uri";

/**
 * The duration (in milliseconds) of this recorded program.
 *
 * <p>The actual duration of the recorded program can differ from the one calculated by
 * {@link #COLUMN_END_TIME_UTC_MILLIS} - {@link #COLUMN_START_TIME_UTC_MILLIS} as program
 * recording can be interrupted in the middle for some reason, resulting in a partially
 * recorded program, which is still playable.
 *
 * <p>Type: INTEGER
 * @apiSince 24
 */

public static final java.lang.String COLUMN_RECORDING_DURATION_MILLIS = "recording_duration_millis";

/**
 * The expiration time for this recorded program, in milliseconds since the epoch.
 *
 * <p>Recorded TV programs do not expire by default unless explicitly requested by the user
 * or the user allows applications to delete them in order to free up disk space for future
 * recording. However, some TV content can have expiration date set by the content provider
 * when recorded. This field is used to indicate such a restriction.
 *
 * <p>Can be empty.
 *
 * <p>Type: INTEGER (long)
 * @apiSince 24
 */

public static final java.lang.String COLUMN_RECORDING_EXPIRE_TIME_UTC_MILLIS = "recording_expire_time_utc_millis";

/**
 * The review rating score for this program.
 *
 * <p>The format of the value is dependent on {@link #COLUMN_REVIEW_RATING_STYLE}. If the
 * style is {@link #REVIEW_RATING_STYLE_STARS}, the value should be a real number between
 * 0.0 and 5.0. (e.g. "4.5") If the style is {@link #REVIEW_RATING_STYLE_THUMBS_UP_DOWN},
 * the value should be two integers, one for thumbs-up count and the other for thumbs-down
 * count, with a comma between them. (e.g. "200,40") If the style is
 * {@link #REVIEW_RATING_STYLE_PERCENTAGE}, the value shoule be a real number between 0 and
 * 100. (e.g. "99.9")
 *
 * <p>Type: TEXT
 * @see #COLUMN_REVIEW_RATING_STYLE
 */

public static final java.lang.String COLUMN_REVIEW_RATING = "review_rating";

/**
 * The review rating score style used for {@link #COLUMN_REVIEW_RATING}.
 *
 * <p> The value should match one of the followings: {@link #REVIEW_RATING_STYLE_STARS},
 * {@link #REVIEW_RATING_STYLE_THUMBS_UP_DOWN}, and {@link #REVIEW_RATING_STYLE_PERCENTAGE}.
 *
 * <p>Type: INTEGER
 * @see #COLUMN_REVIEW_RATING
 */

public static final java.lang.String COLUMN_REVIEW_RATING_STYLE = "review_rating_style";

/**
 * The flag indicating whether this TV program is searchable or not.
 *
 * <p>The columns of searchable programs can be read by other applications that have proper
 * permission. Care must be taken not to open sensitive data.
 *
 * <p>A value of 1 indicates that the program is searchable and its columns can be read by
 * other applications, a value of 0 indicates that the program is hidden and its columns can
 * be read only by the package that owns the program and the system. If not specified, this
 * value is set to 1 (searchable) by default.
 *
 * <p>Type: INTEGER (boolean)
 */

public static final java.lang.String COLUMN_SEARCHABLE = "searchable";

/**
 * The season display number of this TV program for episodic TV shows.
 *
 * <p>This is used to indicate the season number. (e.g. 1, 2 or 3) Note that the value
 * does not necessarily be numeric. (e.g. 12B)
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_SEASON_DISPLAY_NUMBER = "season_display_number";

/**
 * The title of the season for this TV program for episodic TV shows.
 *
 * <p>This is an optional field supplied only when the season has a special title
 * (e.g. The Final Season). If provided, the applications should display it instead of
 * {@link #COLUMN_SEASON_DISPLAY_NUMBER}, and should display it without alterations.
 * (e.g. for "The Final Season", displayed string should be "The Final Season", not
 * "Season The Final Season"). When displaying multiple programs, the order should be based
 * on {@link #COLUMN_SEASON_DISPLAY_NUMBER}, even when {@link #COLUMN_SEASON_TITLE} exists.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_SEASON_TITLE = "season_title";

/**
 * The series ID of this TV program for episodic TV shows.
 *
 * <p>This is used to indicate the series ID. Programs in the same series share a series ID.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_SERIES_ID = "series_id";

/**
 * The short description of this TV program that is displayed to the user by default.
 *
 * <p>It is recommended to limit the length of the descriptions to 256 characters.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_SHORT_DESCRIPTION = "short_description";

/**
 * The start time of the original TV program, in milliseconds since the epoch.
 *
 * <p>Type: INTEGER (long)
 * @see android.media.tv.TvContract.Programs#COLUMN_START_TIME_UTC_MILLIS
 * @apiSince 24
 */

public static final java.lang.String COLUMN_START_TIME_UTC_MILLIS = "start_time_utc_millis";

/**
 * The URI for the thumbnail of this TV program.
 *
 * <p>The system can generate a thumbnail from the poster art if this column is not
 * specified. Thus it is not necessary for TV input services to include a thumbnail if it is
 * just a scaled image of the poster art.
 *
 * <p>The data in the column must be a URL, or a URI in one of the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})
 * </li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_THUMBNAIL_URI = "thumbnail_uri";

/**
 * The title of this TV program.
 *
 * <p>If this program is an episodic TV show, it is recommended that the title is the series
 * title and its related fields ({@link #COLUMN_SEASON_TITLE} and/or
 * {@link #COLUMN_SEASON_DISPLAY_NUMBER}, {@link #COLUMN_SEASON_DISPLAY_NUMBER},
 * {@link #COLUMN_EPISODE_DISPLAY_NUMBER}, and {@link #COLUMN_EPISODE_TITLE}) are filled in.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_TITLE = "title";

/**
 * The version number of this row entry used by TV input services.
 *
 * <p>This is best used by sync adapters to identify the rows to update. The number can be
 * defined by individual TV input services. One may assign the same value as
 * {@code version_number} in ETSI EN 300 468 or ATSC A/65, if the data are coming from a TV
 * broadcast.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_VERSION_NUMBER = "version_number";

/**
 * The height of the video for this TV program, in the unit of pixels.
 *
 * <p>Together with {@link #COLUMN_VIDEO_WIDTH} this is used to determine the video
 * resolution of the current TV program. Can be empty if it is not known initially or the
 * program does not convey any video such as the programs from type
 * {@link android.media.tv.TvContract.Channels#SERVICE_TYPE_AUDIO Channels#SERVICE_TYPE_AUDIO} channels.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_VIDEO_HEIGHT = "video_height";

/**
 * The width of the video for this TV program, in the unit of pixels.
 *
 * <p>Together with {@link #COLUMN_VIDEO_HEIGHT} this is used to determine the video
 * resolution of the current TV program. Can be empty if it is not known initially or the
 * program does not convey any video such as the programs from type
 * {@link android.media.tv.TvContract.Channels#SERVICE_TYPE_AUDIO Channels#SERVICE_TYPE_AUDIO} channels.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_VIDEO_WIDTH = "video_width";

/**
 * The MIME type of a single recorded TV program.
 * @apiSince 24
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/recorded_program";

/**
 * The MIME type of a directory of recorded TV programs.
 * @apiSince 24
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/recorded_program";

/**
 * The content:// style URI for this table.
 *
 * <p>SQL selection is not supported for {@link android.content.ContentResolver#query ContentResolver#query},
 * {@link android.content.ContentResolver#update ContentResolver#update} and {@link android.content.ContentResolver#delete ContentResolver#delete} operations.
 * @apiSince 24
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The review rating style for 0 to 100 point system.
 *
 * @see #COLUMN_REVIEW_RATING_STYLE
 */

public static final int REVIEW_RATING_STYLE_PERCENTAGE = 2; // 0x2

/**
 * The review rating style for five star rating.
 *
 * @see #COLUMN_REVIEW_RATING_STYLE
 */

public static final int REVIEW_RATING_STYLE_STARS = 0; // 0x0

/**
 * The review rating style for thumbs-up and thumbs-down rating.
 *
 * @see #COLUMN_REVIEW_RATING_STYLE
 */

public static final int REVIEW_RATING_STYLE_THUMBS_UP_DOWN = 1; // 0x1
}

/**
 * Column definitions for the "watch next" TV programs table.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class WatchNextPrograms implements android.media.tv.TvContract.BaseTvColumns {

private WatchNextPrograms() { throw new RuntimeException("Stub!"); }

/**
 * The aspect ratio for 16:9.
 *
 * @see #COLUMN_POSTER_ART_ASPECT_RATIO
 * @see #COLUMN_THUMBNAIL_ASPECT_RATIO
 */

public static final int ASPECT_RATIO_16_9 = 0; // 0x0

/**
 * The aspect ratio for 1:1.
 *
 * @see #COLUMN_POSTER_ART_ASPECT_RATIO
 * @see #COLUMN_THUMBNAIL_ASPECT_RATIO
 */

public static final int ASPECT_RATIO_1_1 = 3; // 0x3

/**
 * The aspect ratio for 2:3.
 *
 * @see #COLUMN_POSTER_ART_ASPECT_RATIO
 * @see #COLUMN_THUMBNAIL_ASPECT_RATIO
 */

public static final int ASPECT_RATIO_2_3 = 4; // 0x4

/**
 * The aspect ratio for 3:2.
 *
 * @see #COLUMN_POSTER_ART_ASPECT_RATIO
 * @see #COLUMN_THUMBNAIL_ASPECT_RATIO
 */

public static final int ASPECT_RATIO_3_2 = 1; // 0x1

/**
 * The aspect ratio for 4:3.
 *
 * @see #COLUMN_POSTER_ART_ASPECT_RATIO
 * @see #COLUMN_THUMBNAIL_ASPECT_RATIO
 */

public static final int ASPECT_RATIO_4_3 = 2; // 0x2

/**
 * The availability for "available to this user".
 *
 * @see #COLUMN_AVAILABILITY
 */

public static final int AVAILABILITY_AVAILABLE = 0; // 0x0

/**
 * The availability for "free with subscription".
 *
 * @see #COLUMN_AVAILABILITY
 */

public static final int AVAILABILITY_FREE_WITH_SUBSCRIPTION = 1; // 0x1

/**
 * The availability for "paid content, either to-own or rental
 * (user has not purchased/rented).
 *
 * @see #COLUMN_AVAILABILITY
 */

public static final int AVAILABILITY_PAID_CONTENT = 2; // 0x2

/**
 * The comma-separated audio languages of this TV program.
 *
 * <p>This is used to describe available audio languages included in the program. Use either
 * ISO 639-1 or 639-2/T codes.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_AUDIO_LANGUAGE = "audio_language";

/**
 * The author or artist of this content.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_AUTHOR = "author";

/**
 * The availability of this TV program.
 *
 * <p>The value should match one of the followings:
 * {@link #AVAILABILITY_AVAILABLE},
 * {@link #AVAILABILITY_FREE_WITH_SUBSCRIPTION}, and
 * {@link #AVAILABILITY_PAID_CONTENT}.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_AVAILABILITY = "availability";

/**
 * The flag indicating whether this TV program is browsable or not.
 *
 * <p>This column can only be set by applications having proper system permission. For
 * other applications, this is a read-only column.
 *
 * <p>A value of 1 indicates that the program is browsable and can be shown to users in
 * the UI. A value of 0 indicates that the program should be hidden from users and the
 * application who changes this value to 0 should send
 * {@link #ACTION_WATCH_NEXT_PROGRAM_BROWSABLE_DISABLED} to the owner of the program
 * to notify this change.
 *
 * <p>This value is set to 1 (browsable) by default.
 *
 * <p>Type: INTEGER (boolean)
 */

public static final java.lang.String COLUMN_BROWSABLE = "browsable";

/**
 * The comma-separated canonical genre string of this TV program.
 *
 * <p>Canonical genres are defined in {@link Genres}. Use {@link Genres#encode} to create a
 * text that can be stored in this column. Use {@link Genres#decode} to get the canonical
 * genre strings from the text stored in the column.
 *
 * <p>Type: TEXT
 * @see Genres
 * @see Genres#encode
 * @see Genres#decode
 */

public static final java.lang.String COLUMN_CANONICAL_GENRE = "canonical_genre";

/**
 * The content ID of this TV program.
 *
 * <p>A public ID of the content which allows the application to apply the same operation to
 * all the program copies in different channels.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_CONTENT_ID = "content_id";

/**
 * The comma-separated content ratings of this TV program.
 *
 * <p>This is used to describe the content rating(s) of this program. Each comma-separated
 * content rating sub-string should be generated by calling
 * {@link android.media.tv.TvContentRating#flattenToString TvContentRating#flattenToString}. Note that in most cases the program content is
 * rated by a single rating system, thus resulting in a corresponding single sub-string that
 * does not require comma separation and multiple sub-strings appear only when the program
 * content is rated by two or more content rating systems. If any of those ratings is
 * specified as "blocked rating" in the user's parental control settings, the TV input
 * service should block the current content and wait for the signal that it is okay to
 * unblock.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_CONTENT_RATING = "content_rating";

/**
 * The duration (in milliseconds) of the original content of this preview program.
 *
 * <p>Can be empty.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_DURATION_MILLIS = "duration_millis";

/**
 * The episode display number of this TV program for episodic TV shows.
 *
 * <p>This is used to indicate the episode number. (e.g. 1, 2 or 3) Note that the value
 * does not necessarily be numeric. (e.g. 12B)
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_EPISODE_DISPLAY_NUMBER = "episode_display_number";

/**
 * The episode title of this TV program for episodic TV shows.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_EPISODE_TITLE = "episode_title";

/**
 * The intent URI which is launched when the preview program is selected.
 *
 * <p>The URI is created using {@link android.content.Intent#toUri Intent#toUri} with {@link android.content.Intent#URI_INTENT_SCHEME Intent#URI_INTENT_SCHEME}
 * and converted back to the original intent with {@link android.content.Intent#parseUri Intent#parseUri}. The intent is
 * launched when the user selects the preview program item.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_INTENT_URI = "intent_uri";

/**
 * The interaction count for this program.
 *
 * <p>This indicates the number of times interaction has happened.
 *
 * <p>Type: INTEGER (long)
 * @see #COLUMN_INTERACTION_TYPE
 */

public static final java.lang.String COLUMN_INTERACTION_COUNT = "interaction_count";

/**
 * The type of interaction for this TV program.
 *
 * <p> The value should match one of the followings:
 * {@link #INTERACTION_TYPE_VIEWS},
 * {@link #INTERACTION_TYPE_LISTENS},
 * {@link #INTERACTION_TYPE_FOLLOWERS},
 * {@link #INTERACTION_TYPE_FANS},
 * {@link #INTERACTION_TYPE_LIKES},
 * {@link #INTERACTION_TYPE_THUMBS}, and
 * {@link #INTERACTION_TYPE_VIEWERS}.
 *
 * <p>Type: INTEGER
 * @see #COLUMN_INTERACTION_COUNT
 */

public static final java.lang.String COLUMN_INTERACTION_TYPE = "interaction_type";

/**
 * Internal data used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: BLOB
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_DATA = "internal_provider_data";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG1 = "internal_provider_flag1";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG2 = "internal_provider_flag2";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG3 = "internal_provider_flag3";

/**
 * Internal integer flag used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_FLAG4 = "internal_provider_flag4";

/**
 * The internal ID used by individual TV input services.
 *
 * <p>This is internal to the provider that inserted it, and should not be decoded by other
 * apps.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_INTERNAL_PROVIDER_ID = "internal_provider_id";

/**
 * The count of the items included in this TV program.
 *
 * <p>This is only relevant if the program represents a collection of items such as series,
 * episodes, or music tracks.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_ITEM_COUNT = "item_count";

/**
 * The last UTC time that the user engaged in this TV program, in milliseconds since the
 * epoch. This is a hint for the application that is used for ordering of "watch next"
 * programs.
 *
 * <p>The meaning of the value varies depending on the {@link #COLUMN_WATCH_NEXT_TYPE}:
 * <ul>
 *     <li>{@link #WATCH_NEXT_TYPE_CONTINUE}: the date that the user was last watching the
 *     content.</li>
 *     <li>{@link #WATCH_NEXT_TYPE_NEXT}: the date of the last episode watched.</li>
 *     <li>{@link #WATCH_NEXT_TYPE_NEW}: the release date of the new episode.</li>
 *     <li>{@link #WATCH_NEXT_TYPE_WATCHLIST}: the date the item was added to the Watchlist.
 *     </li>
 * </ul>
 *
 * <p>This is a required field.
 *
 * <p>Type: INTEGER (long)
 * @apiSince 26
 */

public static final java.lang.String COLUMN_LAST_ENGAGEMENT_TIME_UTC_MILLIS = "last_engagement_time_utc_millis";

/**
 * The last playback position (in milliseconds) of the original content of this preview
 * program.
 *
 * <p>Can be empty.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_LAST_PLAYBACK_POSITION_MILLIS = "last_playback_position_millis";

/**
 * The flag indicating whether this TV program is live or not.
 *
 * <p>A value of 1 indicates that the content is airing and should be consumed now, a value
 * of 0 indicates that the content is off the air and does not need to be consumed at the
 * present time. If not specified, the value is set to 0 (not live) by default.
 *
 * <p>Type: INTEGER (boolean)
 */

public static final java.lang.String COLUMN_LIVE = "live";

/**
 * The URI for the logo of this TV program.
 *
 * <p>This is a small badge shown on top of the poster art or thumbnail representing the
 * source of the content.
 *
 * <p>The data in the column must be a URL, or a URI in one of the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})
 * </li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_LOGO_URI = "logo_uri";

/**
 * The detailed, lengthy description of this TV program that is displayed only when the user
 * wants to see more information.
 *
 * <p>TV input services should leave this field empty if they have no additional details
 * beyond {@link #COLUMN_SHORT_DESCRIPTION}.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_LONG_DESCRIPTION = "long_description";

/**
 * The offer price of this TV program.
 *
 * <p>This is the promotional cost of the content. It is only used if the availability of
 * the program is {@link #AVAILABILITY_PAID_CONTENT}.
 *
 * <p>Type: TEXT
 * @see #COLUMN_STARTING_PRICE
 */

public static final java.lang.String COLUMN_OFFER_PRICE = "offer_price";

/**
 * The aspect ratio of the poster art for this TV program.
 *
 * <p>The value should match one of the followings:
 * {@link #ASPECT_RATIO_16_9},
 * {@link #ASPECT_RATIO_3_2},
 * {@link #ASPECT_RATIO_4_3},
 * {@link #ASPECT_RATIO_1_1}, and
 * {@link #ASPECT_RATIO_2_3}.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_POSTER_ART_ASPECT_RATIO = "poster_art_aspect_ratio";

/**
 * The URI for the poster art of this TV program.
 *
 * <p>The data in the column must be a URL, or a URI in one of the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})
 * </li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_POSTER_ART_URI = "poster_art_uri";

/**
 * The URI for the preview video.
 *
 * <p>The data in the column must be a URL, or a URI in one of the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})
 * </li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_PREVIEW_VIDEO_URI = "preview_video_uri";

/**
 * The release date of this TV program.
 *
 * <p>The value should be in one of the following formats:
 * "yyyy", "yyyy-MM-dd", and "yyyy-MM-ddTHH:mm:ssZ" (UTC in ISO 8601).
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_RELEASE_DATE = "release_date";

/**
 * The review rating score for this program.
 *
 * <p>The format of the value is dependent on {@link #COLUMN_REVIEW_RATING_STYLE}. If the
 * style is {@link #REVIEW_RATING_STYLE_STARS}, the value should be a real number between
 * 0.0 and 5.0. (e.g. "4.5") If the style is {@link #REVIEW_RATING_STYLE_THUMBS_UP_DOWN},
 * the value should be two integers, one for thumbs-up count and the other for thumbs-down
 * count, with a comma between them. (e.g. "200,40") If the style is
 * {@link #REVIEW_RATING_STYLE_PERCENTAGE}, the value shoule be a real number between 0 and
 * 100. (e.g. "99.9")
 *
 * <p>Type: TEXT
 * @see #COLUMN_REVIEW_RATING_STYLE
 */

public static final java.lang.String COLUMN_REVIEW_RATING = "review_rating";

/**
 * The review rating score style used for {@link #COLUMN_REVIEW_RATING}.
 *
 * <p> The value should match one of the followings: {@link #REVIEW_RATING_STYLE_STARS},
 * {@link #REVIEW_RATING_STYLE_THUMBS_UP_DOWN}, and {@link #REVIEW_RATING_STYLE_PERCENTAGE}.
 *
 * <p>Type: INTEGER
 * @see #COLUMN_REVIEW_RATING
 */

public static final java.lang.String COLUMN_REVIEW_RATING_STYLE = "review_rating_style";

/**
 * The flag indicating whether this TV program is searchable or not.
 *
 * <p>The columns of searchable programs can be read by other applications that have proper
 * permission. Care must be taken not to open sensitive data.
 *
 * <p>A value of 1 indicates that the program is searchable and its columns can be read by
 * other applications, a value of 0 indicates that the program is hidden and its columns can
 * be read only by the package that owns the program and the system. If not specified, this
 * value is set to 1 (searchable) by default.
 *
 * <p>Type: INTEGER (boolean)
 */

public static final java.lang.String COLUMN_SEARCHABLE = "searchable";

/**
 * The season display number of this TV program for episodic TV shows.
 *
 * <p>This is used to indicate the season number. (e.g. 1, 2 or 3) Note that the value
 * does not necessarily be numeric. (e.g. 12B)
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_SEASON_DISPLAY_NUMBER = "season_display_number";

/**
 * The title of the season for this TV program for episodic TV shows.
 *
 * <p>This is an optional field supplied only when the season has a special title
 * (e.g. The Final Season). If provided, the applications should display it instead of
 * {@link #COLUMN_SEASON_DISPLAY_NUMBER}, and should display it without alterations.
 * (e.g. for "The Final Season", displayed string should be "The Final Season", not
 * "Season The Final Season"). When displaying multiple programs, the order should be based
 * on {@link #COLUMN_SEASON_DISPLAY_NUMBER}, even when {@link #COLUMN_SEASON_TITLE} exists.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_SEASON_TITLE = "season_title";

/**
 * The series ID of this TV program for episodic TV shows.
 *
 * <p>This is used to indicate the series ID. Programs in the same series share a series ID.
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_SERIES_ID = "series_id";

/**
 * The short description of this TV program that is displayed to the user by default.
 *
 * <p>It is recommended to limit the length of the descriptions to 256 characters.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_SHORT_DESCRIPTION = "short_description";

/**
 * The starting price of this TV program.
 *
 * <p>This indicates the lowest regular acquisition cost of the content. It is only used
 * if the availability of the program is {@link #AVAILABILITY_PAID_CONTENT}.
 *
 * <p>Type: TEXT
 * @see #COLUMN_OFFER_PRICE
 */

public static final java.lang.String COLUMN_STARTING_PRICE = "starting_price";

/**
 * The aspect ratio of the thumbnail for this TV program.
 *
 * <p>The value should match one of the followings:
 * {@link #ASPECT_RATIO_16_9},
 * {@link #ASPECT_RATIO_3_2},
 * {@link #ASPECT_RATIO_4_3},
 * {@link #ASPECT_RATIO_1_1}, and
 * {@link #ASPECT_RATIO_2_3}.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_THUMBNAIL_ASPECT_RATIO = "poster_thumbnail_aspect_ratio";

/**
 * The URI for the thumbnail of this TV program.
 *
 * <p>The system can generate a thumbnail from the poster art if this column is not
 * specified. Thus it is not necessary for TV input services to include a thumbnail if it is
 * just a scaled image of the poster art.
 *
 * <p>The data in the column must be a URL, or a URI in one of the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})
 * </li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * <p>Can be empty.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_THUMBNAIL_URI = "thumbnail_uri";

/**
 * The title of this TV program.
 *
 * <p>If this program is an episodic TV show, it is recommended that the title is the series
 * title and its related fields ({@link #COLUMN_SEASON_TITLE} and/or
 * {@link #COLUMN_SEASON_DISPLAY_NUMBER}, {@link #COLUMN_SEASON_DISPLAY_NUMBER},
 * {@link #COLUMN_EPISODE_DISPLAY_NUMBER}, and {@link #COLUMN_EPISODE_TITLE}) are filled in.
 *
 * <p>Type: TEXT
 */

public static final java.lang.String COLUMN_TITLE = "title";

/**
 * The flag indicating whether this program is transient or not.
 *
 * <p>A value of 1 indicates that the channel will be automatically removed by the system on
 * reboot, and a value of 0 indicates that the channel is persistent across reboot. If not
 * specified, this value is set to 0 (not transient) by default.
 *
 * <p>Type: INTEGER (boolean)
 * @see android.media.tv.TvContract.Channels#COLUMN_TRANSIENT
 */

public static final java.lang.String COLUMN_TRANSIENT = "transient";

/**
 * The type of this program content.
 *
 * <p>The value should match one of the followings:
 * {@link #TYPE_MOVIE},
 * {@link #TYPE_TV_SERIES},
 * {@link #TYPE_TV_SEASON},
 * {@link #TYPE_TV_EPISODE},
 * {@link #TYPE_CLIP},
 * {@link #TYPE_EVENT},
 * {@link #TYPE_CHANNEL},
 * {@link #TYPE_TRACK},
 * {@link #TYPE_ALBUM},
 * {@link #TYPE_ARTIST},
 * {@link #TYPE_PLAYLIST}, and
 * {@link #TYPE_STATION}.
 *
 * <p>This is a required field if the program is from a {@link android.media.tv.TvContract.Channels#TYPE_PREVIEW Channels#TYPE_PREVIEW}
 * channel.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_TYPE = "type";

/**
 * The version number of this row entry used by TV input services.
 *
 * <p>This is best used by sync adapters to identify the rows to update. The number can be
 * defined by individual TV input services. One may assign the same value as
 * {@code version_number} in ETSI EN 300 468 or ATSC A/65, if the data are coming from a TV
 * broadcast.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_VERSION_NUMBER = "version_number";

/**
 * The height of the video for this TV program, in the unit of pixels.
 *
 * <p>Together with {@link #COLUMN_VIDEO_WIDTH} this is used to determine the video
 * resolution of the current TV program. Can be empty if it is not known initially or the
 * program does not convey any video such as the programs from type
 * {@link android.media.tv.TvContract.Channels#SERVICE_TYPE_AUDIO Channels#SERVICE_TYPE_AUDIO} channels.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_VIDEO_HEIGHT = "video_height";

/**
 * The width of the video for this TV program, in the unit of pixels.
 *
 * <p>Together with {@link #COLUMN_VIDEO_HEIGHT} this is used to determine the video
 * resolution of the current TV program. Can be empty if it is not known initially or the
 * program does not convey any video such as the programs from type
 * {@link android.media.tv.TvContract.Channels#SERVICE_TYPE_AUDIO Channels#SERVICE_TYPE_AUDIO} channels.
 *
 * <p>Type: INTEGER
 */

public static final java.lang.String COLUMN_VIDEO_WIDTH = "video_width";

/**
 * The "watch next" type of this program content.
 *
 * <p>The value should match one of the followings:
 * {@link #WATCH_NEXT_TYPE_CONTINUE},
 * {@link #WATCH_NEXT_TYPE_NEXT},
 * {@link #WATCH_NEXT_TYPE_NEW}, and
 * {@link #WATCH_NEXT_TYPE_WATCHLIST}.
 *
 * <p>This is a required field.
 *
 * <p>Type: INTEGER
 * @apiSince 26
 */

public static final java.lang.String COLUMN_WATCH_NEXT_TYPE = "watch_next_type";

/**
 * The MIME type of a single preview TV program.
 * @apiSince 26
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/watch_next_program";

/**
 * The MIME type of a directory of "watch next" TV programs.
 * @apiSince 26
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/watch_next_program";

/**
 * The content:// style URI for this table.
 *
 * <p>SQL selection is not supported for {@link android.content.ContentResolver#query ContentResolver#query},
 * {@link android.content.ContentResolver#update ContentResolver#update} and {@link android.content.ContentResolver#delete ContentResolver#delete} operations.
 * @apiSince 26
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The interaction type for "fans".
 *
 * @see #COLUMN_INTERACTION_TYPE
 */

public static final int INTERACTION_TYPE_FANS = 3; // 0x3

/**
 * The interaction type for "followers".
 *
 * @see #COLUMN_INTERACTION_TYPE
 */

public static final int INTERACTION_TYPE_FOLLOWERS = 2; // 0x2

/**
 * The interaction type for "likes".
 *
 * @see #COLUMN_INTERACTION_TYPE
 */

public static final int INTERACTION_TYPE_LIKES = 4; // 0x4

/**
 * The interaction type for "listens".
 *
 * @see #COLUMN_INTERACTION_TYPE
 */

public static final int INTERACTION_TYPE_LISTENS = 1; // 0x1

/**
 * The interaction type for "thumbs".
 *
 * @see #COLUMN_INTERACTION_TYPE
 */

public static final int INTERACTION_TYPE_THUMBS = 5; // 0x5

/**
 * The interaction type for "viewers".
 *
 * @see #COLUMN_INTERACTION_TYPE
 */

public static final int INTERACTION_TYPE_VIEWERS = 6; // 0x6

/**
 * The interaction type for "views".
 *
 * @see #COLUMN_INTERACTION_TYPE
 */

public static final int INTERACTION_TYPE_VIEWS = 0; // 0x0

/**
 * The review rating style for 0 to 100 point system.
 *
 * @see #COLUMN_REVIEW_RATING_STYLE
 */

public static final int REVIEW_RATING_STYLE_PERCENTAGE = 2; // 0x2

/**
 * The review rating style for five star rating.
 *
 * @see #COLUMN_REVIEW_RATING_STYLE
 */

public static final int REVIEW_RATING_STYLE_STARS = 0; // 0x0

/**
 * The review rating style for thumbs-up and thumbs-down rating.
 *
 * @see #COLUMN_REVIEW_RATING_STYLE
 */

public static final int REVIEW_RATING_STYLE_THUMBS_UP_DOWN = 1; // 0x1

/**
 * The program type for album.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_ALBUM = 8; // 0x8

/**
 * The program type for artist.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_ARTIST = 9; // 0x9

/**
 * The program type for channel.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_CHANNEL = 6; // 0x6

/**
 * The program type for clip.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_CLIP = 4; // 0x4

/**
 * The program type for event.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_EVENT = 5; // 0x5

/**
 * The program type for movie.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_MOVIE = 0; // 0x0

/**
 * The program type for playlist.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_PLAYLIST = 10; // 0xa

/**
 * The program type for station.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_STATION = 11; // 0xb

/**
 * The program type for track.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_TRACK = 7; // 0x7

/**
 * The program type for TV episode.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_TV_EPISODE = 3; // 0x3

/**
 * The program type for TV season.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_TV_SEASON = 2; // 0x2

/**
 * The program type for TV series.
 *
 * @see #COLUMN_TYPE
 */

public static final int TYPE_TV_SERIES = 1; // 0x1

/**
 * The watch next type for CONTINUE. Use this type when the user has already watched more
 * than 1 minute of this content.
 *
 * @see #COLUMN_WATCH_NEXT_TYPE
 * @apiSince 26
 */

public static final int WATCH_NEXT_TYPE_CONTINUE = 0; // 0x0

/**
 * The watch next type for NEW. Use this type when the user had watched all of the available
 * episodes from some episodic content, but a new episode became available since the user
 * started watching the first episode and now there is exactly one unwatched episode. This
 * could also work for recorded events in a series e.g. soccer matches or football games.
 *
 * @see #COLUMN_WATCH_NEXT_TYPE
 * @apiSince 26
 */

public static final int WATCH_NEXT_TYPE_NEW = 2; // 0x2

/**
 * The watch next type for NEXT. Use this type when the user has watched one or more
 * complete episodes from some episodic content, but there remains more than one episode
 * remaining or there is one last episode remaining, but it is not “new” in that it was
 * released before the user started watching the show.
 *
 * @see #COLUMN_WATCH_NEXT_TYPE
 * @apiSince 26
 */

public static final int WATCH_NEXT_TYPE_NEXT = 1; // 0x1

/**
 * The watch next type for WATCHLIST. Use this type when the user has elected to explicitly
 * add a movie, event or series to a “watchlist” as a manual way of curating what they
 * want to watch next.
 *
 * @see #COLUMN_WATCH_NEXT_TYPE
 * @apiSince 26
 */

public static final int WATCH_NEXT_TYPE_WATCHLIST = 3; // 0x3
}

}

