/*
 * Copyright (C) 2009 The Android Open Source Project
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
 * limitations under the License
 */


package android.provider;

import android.net.Uri;
import android.content.ContentResolver;
import android.database.CursorWrapper;
import java.io.InputStream;
import android.database.Cursor;
import android.content.Entity;
import android.content.res.AssetFileDescriptor;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import android.content.ContentUris;
import android.content.ContentProviderOperation;
import java.util.ArrayList;
import android.content.ContentValues;
import android.content.res.Resources;
import android.content.ComponentName;
import android.telecom.PhoneAccountHandle;
import android.accounts.Account;
import android.text.TextUtils;
import android.content.Context;
import android.view.View;
import android.util.DisplayMetrics;
import android.graphics.Rect;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.app.Activity;

/**
 * <p>
 * The contract between the contacts provider and applications. Contains
 * definitions for the supported URIs and columns. These APIs supersede
 * {@link android.provider.ContactsContract.Contacts Contacts}.
 * </p>
 * <h3>Overview</h3>
 * <p>
 * ContactsContract defines an extensible database of contact-related
 * information. Contact information is stored in a three-tier data model:
 * </p>
 * <ul>
 * <li>
 * A row in the {@link android.provider.ContactsContract.Data Data} table can store any kind of personal data, such
 * as a phone number or email addresses.  The set of data kinds that can be
 * stored in this table is open-ended. There is a predefined set of common
 * kinds, but any application can add its own data kinds.
 * </li>
 * <li>
 * A row in the {@link android.provider.ContactsContract.RawContacts RawContacts} table represents a set of data describing a
 * person and associated with a single account (for example, one of the user's
 * Gmail accounts).
 * </li>
 * <li>
 * A row in the {@link android.provider.ContactsContract.Contacts Contacts} table represents an aggregate of one or more
 * RawContacts presumably describing the same person.  When data in or associated with
 * the RawContacts table is changed, the affected aggregate contacts are updated as
 * necessary.
 * </li>
 * </ul>
 * <p>
 * Other tables include:
 * </p>
 * <ul>
 * <li>
 * {@link android.provider.ContactsContract.Groups Groups}, which contains information about raw contact groups
 * such as Gmail contact groups.  The
 * current API does not support the notion of groups spanning multiple accounts.
 * </li>
 * <li>
 * {@link android.provider.ContactsContract.StatusUpdates StatusUpdates}, which contains social status updates including IM
 * availability.
 * </li>
 * <li>
 * {@link android.provider.ContactsContract.AggregationExceptions AggregationExceptions}, which is used for manual aggregation and
 * disaggregation of raw contacts
 * </li>
 * <li>
 * {@link android.provider.ContactsContract.Settings Settings}, which contains visibility and sync settings for accounts
 * and groups.
 * </li>
 * <li>
 * {@link android.provider.ContactsContract.SyncState SyncState}, which contains free-form data maintained on behalf of sync
 * adapters
 * </li>
 * <li>
 * {@link android.provider.ContactsContract.PhoneLookup PhoneLookup}, which is used for quick caller-ID lookup</li>
 * </ul>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ContactsContract {

public ContactsContract() { throw new RuntimeException("Stub!"); }

/**
 * This method can be used to identify whether the given ID is associated with profile
 * data.  It does not necessarily indicate that the ID is tied to valid data, merely
 * that accessing data using this ID will result in profile access checks and will only
 * return data from the profile.
 *
 * @param id The ID to check.
 * @return Whether the ID is associated with profile data.
 * @apiSince 14
 */

public static boolean isProfileId(long id) { throw new RuntimeException("Stub!"); }

/**
 * The authority for the contacts provider
 * @apiSince 5
 */

public static final java.lang.String AUTHORITY = "com.android.contacts";

/**
 * A content:// style uri to the authority for the contacts provider
 * @apiSince 5
 */

public static final android.net.Uri AUTHORITY_URI;
static { AUTHORITY_URI = null; }

/**
 * An optional URI parameter for insert, update, or delete queries
 * that allows the caller
 * to specify that it is a sync adapter. The default value is false. If true
 * {@link android.provider.ContactsContract.RawContacts#DIRTY RawContacts#DIRTY} is not automatically set and the
 * "syncToNetwork" parameter is set to false when calling
 * {@link android.content.ContentResolver#notifyChange(android.net.Uri,android.database.ContentObserver,boolean) ContentResolver#notifyChange(android.net.Uri, android.database.ContentObserver, boolean)}.
 * This prevents an unnecessary extra synchronization, see the discussion of
 * the delete operation in {@link android.provider.ContactsContract.RawContacts RawContacts}.
 * @apiSince 5
 */

public static final java.lang.String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";

/**
 * A key to a boolean in the "extras" bundle of the cursor.
 * The boolean indicates that the provider did not create a snippet and that the client asking
 * for the snippet should do it (true means the snippeting was deferred to the client).
 *
 * @see android.provider.ContactsContract.SearchSnippets
 * @apiSince 21
 */

public static final java.lang.String DEFERRED_SNIPPETING = "deferred_snippeting";

/**
 * Key to retrieve the original deferred snippeting from the cursor on the client side.
 *
 * @see android.provider.ContactsContract.SearchSnippets
 * @see #DEFERRED_SNIPPETING
 * @apiSince 21
 */

public static final java.lang.String DEFERRED_SNIPPETING_QUERY = "deferred_snippeting_query";

/**
 * Query parameter that should be used by the client to access a specific
 * {@link android.provider.ContactsContract.Directory Directory}. The parameter value should be the _ID of the corresponding
 * directory, e.g.
 * {@code content://com.android.contacts/data/emails/filter/acme?directory=3}
 * @apiSince 11
 */

public static final java.lang.String DIRECTORY_PARAM_KEY = "directory";

/**
 * A query parameter that limits the number of results returned for supported URIs. The
 * parameter value should be an integer.
 *
 * <p>This parameter is not supported by all URIs.  Supported URIs include, but not limited to,
 * {@link android.provider.ContactsContract.Contacts#CONTENT_URI Contacts#CONTENT_URI},
 * {@link android.provider.ContactsContract.RawContacts#CONTENT_URI RawContacts#CONTENT_URI},
 * {@link android.provider.ContactsContract.Data#CONTENT_URI Data#CONTENT_URI},
 * {@link CommonDataKinds.Phone#CONTENT_URI},
 * {@link CommonDataKinds.Callable#CONTENT_URI},
 * {@link CommonDataKinds.Email#CONTENT_URI},
 * {@link CommonDataKinds.Contactables#CONTENT_URI},
 *
 * <p>In order to limit the number of rows returned by a non-supported URI, you can implement a
 * {@link android.database.CursorWrapper CursorWrapper} and override the {@link android.database.CursorWrapper#getCount() CursorWrapper#getCount()} methods.
 * @apiSince 11
 */

public static final java.lang.String LIMIT_PARAM_KEY = "limit";

/**
 * A query parameter specifing a primary account. This parameter should be used with
 * {@link #PRIMARY_ACCOUNT_TYPE}. The contacts provider handling a query may rely on
 * this information to optimize its query results.
 *
 * For example, in an email composition screen, its implementation can specify an account when
 * obtaining possible recipients, letting the provider know which account is selected during
 * the composition. The provider may use the "primary account" information to optimize
 * the search result.
 * @apiSince 14
 */

public static final java.lang.String PRIMARY_ACCOUNT_NAME = "name_for_primary_account";

/**
 * A query parameter specifing a primary account. This parameter should be used with
 * {@link #PRIMARY_ACCOUNT_NAME}. See the doc in {@link #PRIMARY_ACCOUNT_NAME}.
 * @apiSince 14
 */

public static final java.lang.String PRIMARY_ACCOUNT_TYPE = "type_for_primary_account";

/**
 * A boolean parameter for {@link CommonDataKinds.Phone#CONTENT_URI Phone.CONTENT_URI},
 * {@link CommonDataKinds.Email#CONTENT_URI Email.CONTENT_URI}, and
 * {@link CommonDataKinds.StructuredPostal#CONTENT_URI StructuredPostal.CONTENT_URI}.
 * This enables a content provider to remove duplicate entries in results.
 * @apiSince 21
 */

public static final java.lang.String REMOVE_DUPLICATE_ENTRIES = "remove_duplicate_entries";

/**
 * A boolean parameter for {@link android.provider.ContactsContract.Contacts#CONTENT_STREQUENT_URI Contacts#CONTENT_STREQUENT_URI} and
 * {@link android.provider.ContactsContract.Contacts#CONTENT_STREQUENT_FILTER_URI Contacts#CONTENT_STREQUENT_FILTER_URI}, which requires the ContactsProvider to
 * return only phone-related results.
 * @apiSince 21
 */

public static final java.lang.String STREQUENT_PHONE_ONLY = "strequent_phone_only";
/**
 * <p>
 * Constants for the contact aggregation exceptions table, which contains
 * aggregation rules overriding those used by automatic aggregation. This
 * type only supports query and update. Neither insert nor delete are
 * supported.
 * </p>
 * <h2>Columns</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th colspan='4'>AggregationExceptions</th>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #TYPE}</td>
 * <td>read/write</td>
 * <td>The type of exception: {@link #TYPE_KEEP_TOGETHER},
 * {@link #TYPE_KEEP_SEPARATE} or {@link #TYPE_AUTOMATIC}.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #RAW_CONTACT_ID1}</td>
 * <td>read/write</td>
 * <td>A reference to the {@link android.provider.ContactsContract.RawContacts#_ID RawContacts#_ID} of the raw contact that
 * the rule applies to.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #RAW_CONTACT_ID2}</td>
 * <td>read/write</td>
 * <td>A reference to the other {@link android.provider.ContactsContract.RawContacts#_ID RawContacts#_ID} of the raw contact
 * that the rule applies to.</td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class AggregationExceptions implements android.provider.BaseColumns {

private AggregationExceptions() { throw new RuntimeException("Stub!"); }

/**
 * The MIME type of a {@link #CONTENT_URI} subdirectory of an aggregation exception
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/aggregation_exception";

/**
 * The MIME type of {@link #CONTENT_URI} providing a directory of data.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/aggregation_exception";

/**
 * The content:// style URI for this table
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * A reference to the {@link android.provider.ContactsContract.RawContacts#_ID RawContacts#_ID} of the raw contact that the rule applies to.
 * @apiSince 5
 */

public static final java.lang.String RAW_CONTACT_ID1 = "raw_contact_id1";

/**
 * A reference to the other {@link android.provider.ContactsContract.RawContacts#_ID RawContacts#_ID} of the raw contact that the rule
 * applies to.
 * @apiSince 5
 */

public static final java.lang.String RAW_CONTACT_ID2 = "raw_contact_id2";

/**
 * The type of exception: {@link #TYPE_KEEP_TOGETHER}, {@link #TYPE_KEEP_SEPARATE} or
 * {@link #TYPE_AUTOMATIC}.
 *
 * <P>Type: INTEGER</P>
 * @apiSince 5
 */

public static final java.lang.String TYPE = "type";

/**
 * Allows the provider to automatically decide whether the specified raw contacts should
 * be included in the same aggregate contact or not.
 * @apiSince 5
 */

public static final int TYPE_AUTOMATIC = 0; // 0x0

/**
 * Makes sure that the specified raw contacts are NOT included in the same
 * aggregate contact.
 * @apiSince 5
 */

public static final int TYPE_KEEP_SEPARATE = 2; // 0x2

/**
 * Makes sure that the specified raw contacts are included in the same
 * aggregate contact.
 * @apiSince 5
 */

public static final int TYPE_KEEP_TOGETHER = 1; // 0x1
}

/**
 * Generic columns for use by sync adapters. The specific functions of
 * these columns are private to the sync adapter. Other clients of the API
 * should not attempt to either read or write this column.
 *
 * @see android.provider.ContactsContract.RawContacts
 * @see android.provider.ContactsContract.Groups
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface BaseSyncColumns {

/**
 * Generic column for use by sync adapters.
 * @apiSince 5
 */

public static final java.lang.String SYNC1 = "sync1";

/**
 * Generic column for use by sync adapters.
 * @apiSince 5
 */

public static final java.lang.String SYNC2 = "sync2";

/**
 * Generic column for use by sync adapters.
 * @apiSince 5
 */

public static final java.lang.String SYNC3 = "sync3";

/**
 * Generic column for use by sync adapters.
 * @apiSince 5
 */

public static final java.lang.String SYNC4 = "sync4";
}

/**
 * Container for definitions of common data types stored in the {@link android.provider.ContactsContract.Data ContactsContract.Data}
 * table.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CommonDataKinds {

private CommonDataKinds() { throw new RuntimeException("Stub!"); }
/**
 * The base types that all "Typed" data kinds support.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface BaseTypes {

/**
 * A custom type. The custom label should be supplied by user.
 * @apiSince 5
 */

public static final int TYPE_CUSTOM = 0; // 0x0
}

/**
 * <p>
 * Convenient functionalities for "callable" data. Note that, this is NOT a separate data
 * kind.
 * </p>
 * <p>
 * This URI allows the ContactsProvider to return a unified result for "callable" data
 * that users can use for calling purposes. {@link android.provider.ContactsContract.CommonDataKinds.Phone Phone} and {@link android.provider.ContactsContract.CommonDataKinds.SipAddress SipAddress} are the
 * current examples for "callable", but may be expanded to the other types.
 * </p>
 * <p>
 * Each returned row may have a different MIMETYPE and thus different interpretation for
 * each column. For example the meaning for {@link android.provider.ContactsContract.CommonDataKinds.Phone Phone}'s type is different than
 * {@link android.provider.ContactsContract.CommonDataKinds.SipAddress SipAddress}'s.
 * </p>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Callable implements android.provider.ContactsContract.DataColumnsWithJoins, android.provider.ContactsContract.CommonDataKinds.CommonColumns {

public Callable() { throw new RuntimeException("Stub!"); }

/**
 * <p>Similar to {@link android.provider.ContactsContract.CommonDataKinds.Phone#CONTENT_FILTER_URI Phone#CONTENT_FILTER_URI}, but allows users to filter callable
 * data.
 *
 * <p class="caution"><b>Caution: </b>This field no longer sorts results based on
 * contacts frequency. For more information, see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.
 * @apiSince 21
 */

public static final android.net.Uri CONTENT_FILTER_URI;
static { CONTENT_FILTER_URI = null; }

/**
 * Similar to {@link android.provider.ContactsContract.CommonDataKinds.Phone#CONTENT_URI Phone#CONTENT_URI}, but returns callable data instead of only
 * phone numbers.
 * @apiSince 21
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * <p>Similar to {@link android.provider.ContactsContract.CommonDataKinds.Phone#ENTERPRISE_CONTENT_FILTER_URI Phone#ENTERPRISE_CONTENT_FILTER_URI}, but allows users to filter
 * callable data. This URI requires {@link android.provider.ContactsContract#DIRECTORY_PARAM_KEY ContactsContract#DIRECTORY_PARAM_KEY} in
 * parameters, otherwise it will throw IllegalArgumentException.
 *
 * <p class="caution"><b>Caution: </b>If you publish your app to the Google Play Store,
 * this field doesn't sort results based on contacts frequency. For more information,
 * see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.</p>
 * @apiSince 24
 */

public static final android.net.Uri ENTERPRISE_CONTENT_FILTER_URI;
static { ENTERPRISE_CONTENT_FILTER_URI = null; }

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";
}

/**
 * Columns common across the specific types.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface CommonColumns extends android.provider.ContactsContract.CommonDataKinds.BaseTypes {

/**
 * The data for the contact method.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String DATA = "data1";

/**
 * The user defined label for the the contact method.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String LABEL = "data3";

/**
 * The type of data, for example Home or Work.
 * <P>Type: INTEGER</P>
 * @apiSince 5
 */

public static final java.lang.String TYPE = "data2";
}

/**
 * A special class of data items, used to refer to types of data that can be used to attempt
 * to start communicating with a person ({@link android.provider.ContactsContract.CommonDataKinds.Phone Phone} and {@link android.provider.ContactsContract.CommonDataKinds.Email Email}). Note that this
 * is NOT a separate data kind.
 *
 * This URI allows the ContactsProvider to return a unified result for data items that users
 * can use to initiate communications with another contact. {@link android.provider.ContactsContract.CommonDataKinds.Phone Phone} and {@link android.provider.ContactsContract.CommonDataKinds.Email Email}
 * are the current data types in this category.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Contactables implements android.provider.ContactsContract.DataColumnsWithJoins, android.provider.ContactsContract.CommonDataKinds.CommonColumns {

public Contactables() { throw new RuntimeException("Stub!"); }

/**
 * <p>The content:// style URI for these data items, which allows for a query parameter
 * to be appended onto the end to filter for data items matching the query.
 *
 * <p class="caution"><b>Caution: </b>If you publish your app to the Google Play Store,
 * this field doesn't sort results based on contacts frequency. For more information,
 * see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.
 * @apiSince 18
 */

public static final android.net.Uri CONTENT_FILTER_URI;
static { CONTENT_FILTER_URI = null; }

/**
 * The content:// style URI for these data items, which requests a directory of data
 * rows matching the selection criteria.
 * @apiSince 18
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/**
 * A boolean parameter for {@link android.provider.ContactsContract.Data#CONTENT_URI Data#CONTENT_URI}.
 * This specifies whether or not the returned data items should be filtered to show
 * data items belonging to visible contacts only.
 * @apiSince 18
 */

public static final java.lang.String VISIBLE_CONTACTS_ONLY = "visible_contacts_only";
}

/**
 * <p>
 * A data kind representing an email address.
 * </p>
 * <p>
 * You can use all columns defined for {@link android.provider.ContactsContract.Data ContactsContract.Data} as
 * well as the following aliases.
 * </p>
 * <h2>Column aliases</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th>Type</th>
 * <th>Alias</th><th colspan='2'>Data column</th>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #ADDRESS}</td>
 * <td>{@link #DATA1}</td>
 * <td>Email address itself.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #TYPE}</td>
 * <td>{@link #DATA2}</td>
 * <td>Allowed values are:
 * <p>
 * <ul>
 * <li>{@link #TYPE_CUSTOM}. Put the actual type in {@link #LABEL}.</li>
 * <li>{@link #TYPE_HOME}</li>
 * <li>{@link #TYPE_WORK}</li>
 * <li>{@link #TYPE_OTHER}</li>
 * <li>{@link #TYPE_MOBILE}</li>
 * </ul>
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #LABEL}</td>
 * <td>{@link #DATA3}</td>
 * <td></td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Email implements android.provider.ContactsContract.DataColumnsWithJoins, android.provider.ContactsContract.CommonDataKinds.CommonColumns {

private Email() { throw new RuntimeException("Stub!"); }

/**
 * Return the string resource that best describes the given
 * {@link #TYPE}. Will always return a valid resource.
 * @apiSince 5
 */

public static int getTypeLabelResource(int type) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link java.lang.CharSequence CharSequence} that best describes the given type,
 * possibly substituting the given {@link #LABEL} value
 * for {@link #TYPE_CUSTOM}.
 * @apiSince 5
 */

public static java.lang.CharSequence getTypeLabel(android.content.res.Resources res, int type, java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * The email address.
 * <P>Type: TEXT</P>
 * @apiSince 11
 */

public static final java.lang.String ADDRESS = "data1";

/**
 * <p>The content:// style URL for email lookup using a filter. The filter returns
 * records of MIME type {@link #CONTENT_ITEM_TYPE}. The filter is applied
 * to display names as well as email addresses. The filter argument should be passed
 * as an additional path segment after this URI.
 * </p>
 *
 * <p class="caution"><b>Caution: </b>If you publish your app to the Google Play Store,
 * this field doesn't sort results based on contacts frequency. For more information,
 * see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.</p>
 *
 * <p>The query in the following example will return "Robert Parr (bob@incredibles.com)"
 * as well as "Bob Parr (incredible@android.com)".
 * <pre>
 * Uri uri = Uri.withAppendedPath(Email.CONTENT_LOOKUP_URI, Uri.encode("bob"));
 * Cursor c = getContentResolver().query(uri,
 *          new String[]{Email.DISPLAY_NAME, Email.DATA},
 *          null, null, null);
 * </pre>
 * </p>
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_FILTER_URI;
static { CONTENT_FILTER_URI = null; }

/**
 * MIME type used when storing this in data table.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/email_v2";

/**
 * <p>
 * The content:// style URL for looking up data rows by email address. The
 * lookup argument, an email address, should be passed as an additional path segment
 * after this URI.
 * </p>
 * <p>Example:
 * <pre>
 * Uri uri = Uri.withAppendedPath(Email.CONTENT_LOOKUP_URI, Uri.encode(email));
 * Cursor c = getContentResolver().query(uri,
 *          new String[]{Email.CONTACT_ID, Email.DISPLAY_NAME, Email.DATA},
 *          null, null, null);
 * </pre>
 * </p>
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_LOOKUP_URI;
static { CONTENT_LOOKUP_URI = null; }

/**
 * The MIME type of {@link #CONTENT_URI} providing a directory of email addresses.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/email_v2";

/**
 * The content:// style URI for all data records of the
 * {@link #CONTENT_ITEM_TYPE} MIME type, combined with the
 * associated raw contact and aggregate contact data.
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The display name for the email address
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String DISPLAY_NAME = "data4";

/**
 * <p>It supports the similar semantics as {@link #CONTENT_FILTER_URI} and returns the
 * same columns. This URI requires {@link android.provider.ContactsContract#DIRECTORY_PARAM_KEY ContactsContract#DIRECTORY_PARAM_KEY} in
 * parameters, otherwise it will throw IllegalArgumentException.
 *
 * <p class="caution"><b>Caution: </b>If you publish your app to the Google Play Store,
 * this field doesn't sort results based on contacts frequency. For more information,
 * see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.
 * @apiSince 24
 */

public static final android.net.Uri ENTERPRISE_CONTENT_FILTER_URI;
static { ENTERPRISE_CONTENT_FILTER_URI = null; }

/**
 * <p>URI used for enterprise email lookup.</p>
 *
 * <p>
 * It supports the same semantics as {@link #CONTENT_LOOKUP_URI} and returns the same
 * columns.  If the device has no corp profile that is linked to the current profile, it
 * behaves in the exact same way as {@link #CONTENT_LOOKUP_URI}.  If there is a
 * corp profile linked to the current profile, it first queries against the personal contact database,
 * and if no matching contacts are found there, then queries against the
 * corp contacts database.
 * </p>
 * <p>
 * If a result is from the corp profile, it makes the following changes to the data:
 * <ul>
 *     <li>
 *     {@link #PHOTO_THUMBNAIL_URI} and {@link #PHOTO_URI} will be rewritten to special
 *     URIs.  Use {@link android.content.ContentResolver#openAssetFileDescriptor ContentResolver#openAssetFileDescriptor} or its siblings to
 *     load pictures from them.
 *     {@link #PHOTO_ID} and {@link #PHOTO_FILE_ID} will be set to null.  Do not
 *     use them.
 *     </li>
 *     <li>
 *     Corp contacts will get artificial {@link #CONTACT_ID}s.  In order to tell whether
 *     a contact
 *     is from the corp profile, use
 *     {@link android.provider.ContactsContract.Contacts#isEnterpriseContactId(long) ContactsContract.Contacts#isEnterpriseContactId(long)}.
 *     </li>
 *     <li>
 *     Corp contacts will get artificial {@link #LOOKUP_KEY}s too.
 *     </li>
 *     <li>
 *     Returned work contact IDs and lookup keys are not accepted in places that not
 *     explicitly say to accept them.
 *     </li>
 * </ul>
 * <p>
 * A contact lookup URL built by
 * {@link android.provider.ContactsContract.Contacts#getLookupUri(long,java.lang.String) ContactsContract.Contacts#getLookupUri(long, String)}
 * with an {@link #_ID} and a {@link #LOOKUP_KEY} returned by this API can be passed to
 * {@link android.provider.ContactsContract.QuickContact#showQuickContact ContactsContract.QuickContact#showQuickContact} even if a contact is from the
 * corp profile.
 * </p>
 *
 * <pre>
 * Uri lookupUri = Uri.withAppendedPath(Email.ENTERPRISE_CONTENT_LOOKUP_URI,
 *         Uri.encode(email));
 * </pre>
 * @apiSince 23
 */

public static final android.net.Uri ENTERPRISE_CONTENT_LOOKUP_URI;
static { ENTERPRISE_CONTENT_LOOKUP_URI = null; }

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/** @apiSince 5 */

public static final int TYPE_HOME = 1; // 0x1

/** @apiSince 5 */

public static final int TYPE_MOBILE = 4; // 0x4

/** @apiSince 5 */

public static final int TYPE_OTHER = 3; // 0x3

/** @apiSince 5 */

public static final int TYPE_WORK = 2; // 0x2
}

/**
 * <p>
 * A data kind representing an event.
 * </p>
 * <p>
 * You can use all columns defined for {@link android.provider.ContactsContract.Data ContactsContract.Data} as
 * well as the following aliases.
 * </p>
 * <h2>Column aliases</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th>Type</th>
 * <th>Alias</th><th colspan='2'>Data column</th>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #START_DATE}</td>
 * <td>{@link #DATA1}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #TYPE}</td>
 * <td>{@link #DATA2}</td>
 * <td>Allowed values are:
 * <p>
 * <ul>
 * <li>{@link #TYPE_CUSTOM}. Put the actual type in {@link #LABEL}.</li>
 * <li>{@link #TYPE_ANNIVERSARY}</li>
 * <li>{@link #TYPE_OTHER}</li>
 * <li>{@link #TYPE_BIRTHDAY}</li>
 * </ul>
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #LABEL}</td>
 * <td>{@link #DATA3}</td>
 * <td></td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Event implements android.provider.ContactsContract.DataColumnsWithJoins, android.provider.ContactsContract.CommonDataKinds.CommonColumns {

private Event() { throw new RuntimeException("Stub!"); }

/**
 * Return the string resource that best describes the given
 * {@link #TYPE}. Will always return a valid resource.
 * @apiSince 5
 */

public static int getTypeResource(java.lang.Integer type) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link java.lang.CharSequence CharSequence} that best describes the given type,
 * possibly substituting the given {@link #LABEL} value
 * for {@link #TYPE_CUSTOM}.
 * @apiSince 21
 */

public static java.lang.CharSequence getTypeLabel(android.content.res.Resources res, int type, java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * MIME type used when storing this in data table.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_event";

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/**
 * The event start date as the user entered it.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String START_DATE = "data1";

/** @apiSince 5 */

public static final int TYPE_ANNIVERSARY = 1; // 0x1

/** @apiSince 5 */

public static final int TYPE_BIRTHDAY = 3; // 0x3

/** @apiSince 5 */

public static final int TYPE_OTHER = 2; // 0x2
}

/**
 * <p>
 * Group Membership.
 * </p>
 * <p>
 * You can use all columns defined for {@link android.provider.ContactsContract.Data ContactsContract.Data} as
 * well as the following aliases.
 * </p>
 * <h2>Column aliases</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th>Type</th>
 * <th>Alias</th><th colspan='2'>Data column</th>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #GROUP_ROW_ID}</td>
 * <td>{@link #DATA1}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #GROUP_SOURCE_ID}</td>
 * <td>none</td>
 * <td>
 * <p>
 * The sourceid of the group that this group membership refers to.
 * Exactly one of this or {@link #GROUP_ROW_ID} must be set when
 * inserting a row.
 * </p>
 * <p>
 * If this field is specified, the provider will first try to
 * look up a group with this {@link android.provider.ContactsContract.Groups Groups}.  If such a group
 * is found, it will use the corresponding row id.  If the group is not
 * found, it will create one.
 * </td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class GroupMembership implements android.provider.ContactsContract.DataColumnsWithJoins {

private GroupMembership() { throw new RuntimeException("Stub!"); }

/**
 * MIME type used when storing this in data table.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/group_membership";

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/**
 * The row id of the group that this group membership refers to. Exactly one of
 * this or {@link #GROUP_SOURCE_ID} must be set when inserting a row.
 * <P>Type: INTEGER</P>
 * @apiSince 5
 */

public static final java.lang.String GROUP_ROW_ID = "data1";

/**
 * The sourceid of the group that this group membership refers to.  Exactly one of
 * this or {@link #GROUP_ROW_ID} must be set when inserting a row.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String GROUP_SOURCE_ID = "group_sourceid";
}

/**
 * A data kind representing an Identity related to the contact.
 * <p>
 * This can be used as a signal by the aggregator to combine raw contacts into
 * contacts, e.g. if two contacts have Identity rows with
 * the same NAMESPACE and IDENTITY values the aggregator can know that they refer
 * to the same person.
 * </p>
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Identity implements android.provider.ContactsContract.DataColumnsWithJoins {

private Identity() { throw new RuntimeException("Stub!"); }

/**
 * MIME type used when storing this in data table.
 * @apiSince 14
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/identity";

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/**
 * The identity string.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String IDENTITY = "data1";

/**
 * The namespace of the identity string, e.g.&nbsp;"com.google"
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String NAMESPACE = "data2";
}

/**
 * <p>
 * A data kind representing an IM address
 * </p>
 * <p>
 * You can use all columns defined for {@link android.provider.ContactsContract.Data ContactsContract.Data} as
 * well as the following aliases.
 * </p>
 * <h2>Column aliases</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th>Type</th>
 * <th>Alias</th><th colspan='2'>Data column</th>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #DATA}</td>
 * <td>{@link #DATA1}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #TYPE}</td>
 * <td>{@link #DATA2}</td>
 * <td>Allowed values are:
 * <p>
 * <ul>
 * <li>{@link #TYPE_CUSTOM}. Put the actual type in {@link #LABEL}.</li>
 * <li>{@link #TYPE_HOME}</li>
 * <li>{@link #TYPE_WORK}</li>
 * <li>{@link #TYPE_OTHER}</li>
 * </ul>
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #LABEL}</td>
 * <td>{@link #DATA3}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #PROTOCOL}</td>
 * <td>{@link #DATA5}</td>
 * <td>
 * <p>
 * Allowed values:
 * <ul>
 * <li>{@link #PROTOCOL_CUSTOM}. Also provide the actual protocol name
 * as {@link #CUSTOM_PROTOCOL}.</li>
 * <li>{@link #PROTOCOL_AIM}</li>
 * <li>{@link #PROTOCOL_MSN}</li>
 * <li>{@link #PROTOCOL_YAHOO}</li>
 * <li>{@link #PROTOCOL_SKYPE}</li>
 * <li>{@link #PROTOCOL_QQ}</li>
 * <li>{@link #PROTOCOL_GOOGLE_TALK}</li>
 * <li>{@link #PROTOCOL_ICQ}</li>
 * <li>{@link #PROTOCOL_JABBER}</li>
 * <li>{@link #PROTOCOL_NETMEETING}</li>
 * </ul>
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #CUSTOM_PROTOCOL}</td>
 * <td>{@link #DATA6}</td>
 * <td></td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Im implements android.provider.ContactsContract.DataColumnsWithJoins, android.provider.ContactsContract.CommonDataKinds.CommonColumns {

private Im() { throw new RuntimeException("Stub!"); }

/**
 * Return the string resource that best describes the given
 * {@link #TYPE}. Will always return a valid resource.
 * @apiSince 5
 */

public static int getTypeLabelResource(int type) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link java.lang.CharSequence CharSequence} that best describes the given type,
 * possibly substituting the given {@link #LABEL} value
 * for {@link #TYPE_CUSTOM}.
 * @apiSince 5
 */

public static java.lang.CharSequence getTypeLabel(android.content.res.Resources res, int type, java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * Return the string resource that best describes the given
 * {@link #PROTOCOL}. Will always return a valid resource.
 * @apiSince 5
 */

public static int getProtocolLabelResource(int type) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link java.lang.CharSequence CharSequence} that best describes the given
 * protocol, possibly substituting the given
 * {@link #CUSTOM_PROTOCOL} value for {@link #PROTOCOL_CUSTOM}.
 * @apiSince 5
 */

public static java.lang.CharSequence getProtocolLabel(android.content.res.Resources res, int type, java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * MIME type used when storing this in data table.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/im";

/** @apiSince 5 */

public static final java.lang.String CUSTOM_PROTOCOL = "data6";

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/**
 * This column should be populated with one of the defined
 * constants, e.g.&nbsp;{@link #PROTOCOL_YAHOO}. If the value of this
 * column is {@link #PROTOCOL_CUSTOM}, the {@link #CUSTOM_PROTOCOL}
 * should contain the name of the custom protocol.
 * @apiSince 5
 */

public static final java.lang.String PROTOCOL = "data5";

/** @apiSince 5 */

public static final int PROTOCOL_AIM = 0; // 0x0

/** @apiSince 5 */

public static final int PROTOCOL_CUSTOM = -1; // 0xffffffff

/** @apiSince 5 */

public static final int PROTOCOL_GOOGLE_TALK = 5; // 0x5

/** @apiSince 5 */

public static final int PROTOCOL_ICQ = 6; // 0x6

/** @apiSince 5 */

public static final int PROTOCOL_JABBER = 7; // 0x7

/** @apiSince 5 */

public static final int PROTOCOL_MSN = 1; // 0x1

/** @apiSince 5 */

public static final int PROTOCOL_NETMEETING = 8; // 0x8

/** @apiSince 5 */

public static final int PROTOCOL_QQ = 4; // 0x4

/** @apiSince 5 */

public static final int PROTOCOL_SKYPE = 3; // 0x3

/** @apiSince 5 */

public static final int PROTOCOL_YAHOO = 2; // 0x2

/** @apiSince 5 */

public static final int TYPE_HOME = 1; // 0x1

/** @apiSince 5 */

public static final int TYPE_OTHER = 3; // 0x3

/** @apiSince 5 */

public static final int TYPE_WORK = 2; // 0x2
}

/**
 * <p>A data kind representing the contact's nickname. For example, for
 * Bob Parr ("Mr. Incredible"):
 * <pre>
 * ArrayList&lt;ContentProviderOperation&gt; ops =
 *          new ArrayList&lt;ContentProviderOperation&gt;();
 *
 * ops.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
 *          .withValue(Data.RAW_CONTACT_ID, rawContactId)
 *          .withValue(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE)
 *          .withValue(StructuredName.DISPLAY_NAME, &quot;Bob Parr&quot;)
 *          .build());
 *
 * ops.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
 *          .withValue(Data.RAW_CONTACT_ID, rawContactId)
 *          .withValue(Data.MIMETYPE, Nickname.CONTENT_ITEM_TYPE)
 *          .withValue(Nickname.NAME, "Mr. Incredible")
 *          .withValue(Nickname.TYPE, Nickname.TYPE_CUSTOM)
 *          .withValue(Nickname.LABEL, "Superhero")
 *          .build());
 *
 * getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
 * </pre>
 * </p>
 * <p>
 * You can use all columns defined for {@link android.provider.ContactsContract.Data ContactsContract.Data} as well as the
 * following aliases.
 * </p>
 *
 * <h2>Column aliases</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th>Type</th><th>Alias</th><th colspan='2'>Data column</th>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #NAME}</td>
 * <td>{@link #DATA1}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #TYPE}</td>
 * <td>{@link #DATA2}</td>
 * <td>
 * Allowed values are:
 * <p>
 * <ul>
 * <li>{@link #TYPE_CUSTOM}. Put the actual type in {@link #LABEL}.</li>
 * <li>{@link #TYPE_DEFAULT}</li>
 * <li>{@link #TYPE_OTHER_NAME}</li>
 * <li>{@link #TYPE_MAIDEN_NAME}</li>
 * <li>{@link #TYPE_SHORT_NAME}</li>
 * <li>{@link #TYPE_INITIALS}</li>
 * </ul>
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #LABEL}</td>
 * <td>{@link #DATA3}</td>
 * <td></td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Nickname implements android.provider.ContactsContract.DataColumnsWithJoins, android.provider.ContactsContract.CommonDataKinds.CommonColumns {

private Nickname() { throw new RuntimeException("Stub!"); }

/**
 * MIME type used when storing this in data table.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/nickname";

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/**
 * The name itself
 * @apiSince 5
 */

public static final java.lang.String NAME = "data1";

/** @apiSince 5 */

public static final int TYPE_DEFAULT = 1; // 0x1

/** @apiSince 5 */

public static final int TYPE_INITIALS = 5; // 0x5

/** @apiSince 9 */

public static final int TYPE_MAIDEN_NAME = 3; // 0x3

/**
 * @deprecated Use TYPE_MAIDEN_NAME instead.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated public static final int TYPE_MAINDEN_NAME = 3; // 0x3

/** @apiSince 5 */

public static final int TYPE_OTHER_NAME = 2; // 0x2

/** @apiSince 5 */

public static final int TYPE_SHORT_NAME = 4; // 0x4
}

/**
 * <p>
 * Notes about the contact.
 * </p>
 * <p>
 * You can use all columns defined for {@link android.provider.ContactsContract.Data ContactsContract.Data} as
 * well as the following aliases.
 * </p>
 * <h2>Column aliases</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th>Type</th>
 * <th>Alias</th><th colspan='2'>Data column</th>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #NOTE}</td>
 * <td>{@link #DATA1}</td>
 * <td></td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Note implements android.provider.ContactsContract.DataColumnsWithJoins {

private Note() { throw new RuntimeException("Stub!"); }

/**
 * MIME type used when storing this in data table.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/note";

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/**
 * The note text.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String NOTE = "data1";
}

/**
 * <p>
 * A data kind representing an organization.
 * </p>
 * <p>
 * You can use all columns defined for {@link android.provider.ContactsContract.Data ContactsContract.Data} as
 * well as the following aliases.
 * </p>
 * <h2>Column aliases</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th>Type</th>
 * <th>Alias</th><th colspan='2'>Data column</th>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #COMPANY}</td>
 * <td>{@link #DATA1}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #TYPE}</td>
 * <td>{@link #DATA2}</td>
 * <td>Allowed values are:
 * <p>
 * <ul>
 * <li>{@link #TYPE_CUSTOM}. Put the actual type in {@link #LABEL}.</li>
 * <li>{@link #TYPE_WORK}</li>
 * <li>{@link #TYPE_OTHER}</li>
 * </ul>
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #LABEL}</td>
 * <td>{@link #DATA3}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #TITLE}</td>
 * <td>{@link #DATA4}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #DEPARTMENT}</td>
 * <td>{@link #DATA5}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #JOB_DESCRIPTION}</td>
 * <td>{@link #DATA6}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #SYMBOL}</td>
 * <td>{@link #DATA7}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #PHONETIC_NAME}</td>
 * <td>{@link #DATA8}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #OFFICE_LOCATION}</td>
 * <td>{@link #DATA9}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>PHONETIC_NAME_STYLE</td>
 * <td>{@link #DATA10}</td>
 * <td></td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Organization implements android.provider.ContactsContract.DataColumnsWithJoins, android.provider.ContactsContract.CommonDataKinds.CommonColumns {

private Organization() { throw new RuntimeException("Stub!"); }

/**
 * Return the string resource that best describes the given
 * {@link #TYPE}. Will always return a valid resource.
 * @apiSince 5
 */

public static int getTypeLabelResource(int type) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link java.lang.CharSequence CharSequence} that best describes the given type,
 * possibly substituting the given {@link #LABEL} value
 * for {@link #TYPE_CUSTOM}.
 * @apiSince 5
 */

public static java.lang.CharSequence getTypeLabel(android.content.res.Resources res, int type, java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * The company as the user entered it.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String COMPANY = "data1";

/**
 * MIME type used when storing this in data table.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/organization";

/**
 * The department at this company as the user entered it.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String DEPARTMENT = "data5";

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/**
 * The job description at this company as the user entered it.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String JOB_DESCRIPTION = "data6";

/**
 * The office location of this organization.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String OFFICE_LOCATION = "data9";

/**
 * The phonetic name of this company as the user entered it.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String PHONETIC_NAME = "data8";

/**
 * The alphabet used for capturing the phonetic name.
 * See {@link android.provider.ContactsContract.PhoneticNameStyle ContactsContract.PhoneticNameStyle}.
 * @apiSince 11
 */

public static final java.lang.String PHONETIC_NAME_STYLE = "data10";

/**
 * The symbol of this company as the user entered it.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String SYMBOL = "data7";

/**
 * The position title at this company as the user entered it.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String TITLE = "data4";

/** @apiSince 5 */

public static final int TYPE_OTHER = 2; // 0x2

/** @apiSince 5 */

public static final int TYPE_WORK = 1; // 0x1
}

/**
 * <p>
 * A data kind representing a telephone number.
 * </p>
 * <p>
 * You can use all columns defined for {@link android.provider.ContactsContract.Data ContactsContract.Data} as
 * well as the following aliases.
 * </p>
 * <h2>Column aliases</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th>Type</th>
 * <th>Alias</th><th colspan='2'>Data column</th>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #NUMBER}</td>
 * <td>{@link #DATA1}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #TYPE}</td>
 * <td>{@link #DATA2}</td>
 * <td>Allowed values are:
 * <p>
 * <ul>
 * <li>{@link #TYPE_CUSTOM}. Put the actual type in {@link #LABEL}.</li>
 * <li>{@link #TYPE_HOME}</li>
 * <li>{@link #TYPE_MOBILE}</li>
 * <li>{@link #TYPE_WORK}</li>
 * <li>{@link #TYPE_FAX_WORK}</li>
 * <li>{@link #TYPE_FAX_HOME}</li>
 * <li>{@link #TYPE_PAGER}</li>
 * <li>{@link #TYPE_OTHER}</li>
 * <li>{@link #TYPE_CALLBACK}</li>
 * <li>{@link #TYPE_CAR}</li>
 * <li>{@link #TYPE_COMPANY_MAIN}</li>
 * <li>{@link #TYPE_ISDN}</li>
 * <li>{@link #TYPE_MAIN}</li>
 * <li>{@link #TYPE_OTHER_FAX}</li>
 * <li>{@link #TYPE_RADIO}</li>
 * <li>{@link #TYPE_TELEX}</li>
 * <li>{@link #TYPE_TTY_TDD}</li>
 * <li>{@link #TYPE_WORK_MOBILE}</li>
 * <li>{@link #TYPE_WORK_PAGER}</li>
 * <li>{@link #TYPE_ASSISTANT}</li>
 * <li>{@link #TYPE_MMS}</li>
 * </ul>
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #LABEL}</td>
 * <td>{@link #DATA3}</td>
 * <td></td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Phone implements android.provider.ContactsContract.DataColumnsWithJoins, android.provider.ContactsContract.CommonDataKinds.CommonColumns {

private Phone() { throw new RuntimeException("Stub!"); }

/**
 * Return the string resource that best describes the given
 * {@link #TYPE}. Will always return a valid resource.
 * @apiSince 5
 */

public static int getTypeLabelResource(int type) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link java.lang.CharSequence CharSequence} that best describes the given type,
 * possibly substituting the given {@link #LABEL} value
 * for {@link #TYPE_CUSTOM}.
 * @apiSince 5
 */

public static java.lang.CharSequence getTypeLabel(android.content.res.Resources res, int type, java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * <p>The content:// style URL for phone lookup using a filter. The filter returns
 * records of MIME type {@link #CONTENT_ITEM_TYPE}. The filter is applied
 * to display names as well as phone numbers. The filter argument should be passed
 * as an additional path segment after this URI.
 *
 * <p class="caution"><b>Caution: </b>This field deosn't sort results based on contacts
 * frequency. For more information, see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_FILTER_URI;
static { CONTENT_FILTER_URI = null; }

/**
 * MIME type used when storing this in data table.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/phone_v2";

/**
 * The MIME type of {@link #CONTENT_URI} providing a directory of
 * phones.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/phone_v2";

/**
 * The content:// style URI for all data records of the
 * {@link #CONTENT_ITEM_TYPE} MIME type, combined with the
 * associated raw contact and aggregate contact data.
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * <p>It supports the similar semantics as {@link #CONTENT_FILTER_URI} and returns the
 * same columns. This URI requires {@link android.provider.ContactsContract#DIRECTORY_PARAM_KEY ContactsContract#DIRECTORY_PARAM_KEY} in
 * parameters, otherwise it will throw IllegalArgumentException.
 *
 * <p class="caution"><b>Caution: </b>If you publish your app to the Google Play Store,
 * this field doesn't sort results based on contacts frequency. For more information,
 * see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.
 * @apiSince 24
 */

public static final android.net.Uri ENTERPRISE_CONTENT_FILTER_URI;
static { ENTERPRISE_CONTENT_FILTER_URI = null; }

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/**
 * The phone number's E164 representation. This value can be omitted in which
 * case the provider will try to automatically infer it.  (It'll be left null if the
 * provider fails to infer.)
 * If present, {@link #NUMBER} has to be set as well (it will be ignored otherwise).
 * <P>Type: TEXT</P>
 * @apiSince 16
 */

public static final java.lang.String NORMALIZED_NUMBER = "data4";

/**
 * The phone number as the user entered it.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String NUMBER = "data1";

/**
 * A boolean query parameter that can be used with {@link #CONTENT_FILTER_URI}.
 * If "1" or "true", display names are searched.  If "0" or "false", display names
 * are not searched.  Default is "1".
 * @apiSince 16
 */

public static final java.lang.String SEARCH_DISPLAY_NAME_KEY = "search_display_name";

/**
 * A boolean query parameter that can be used with {@link #CONTENT_FILTER_URI}.
 * If "1" or "true", phone numbers are searched.  If "0" or "false", phone numbers
 * are not searched.  Default is "1".
 * @apiSince 16
 */

public static final java.lang.String SEARCH_PHONE_NUMBER_KEY = "search_phone_number";

/** @apiSince 5 */

public static final int TYPE_ASSISTANT = 19; // 0x13

/** @apiSince 5 */

public static final int TYPE_CALLBACK = 8; // 0x8

/** @apiSince 5 */

public static final int TYPE_CAR = 9; // 0x9

/** @apiSince 5 */

public static final int TYPE_COMPANY_MAIN = 10; // 0xa

/** @apiSince 5 */

public static final int TYPE_FAX_HOME = 5; // 0x5

/** @apiSince 5 */

public static final int TYPE_FAX_WORK = 4; // 0x4

/** @apiSince 5 */

public static final int TYPE_HOME = 1; // 0x1

/** @apiSince 5 */

public static final int TYPE_ISDN = 11; // 0xb

/** @apiSince 5 */

public static final int TYPE_MAIN = 12; // 0xc

/** @apiSince 5 */

public static final int TYPE_MMS = 20; // 0x14

/** @apiSince 5 */

public static final int TYPE_MOBILE = 2; // 0x2

/** @apiSince 5 */

public static final int TYPE_OTHER = 7; // 0x7

/** @apiSince 5 */

public static final int TYPE_OTHER_FAX = 13; // 0xd

/** @apiSince 5 */

public static final int TYPE_PAGER = 6; // 0x6

/** @apiSince 5 */

public static final int TYPE_RADIO = 14; // 0xe

/** @apiSince 5 */

public static final int TYPE_TELEX = 15; // 0xf

/** @apiSince 5 */

public static final int TYPE_TTY_TDD = 16; // 0x10

/** @apiSince 5 */

public static final int TYPE_WORK = 3; // 0x3

/** @apiSince 5 */

public static final int TYPE_WORK_MOBILE = 17; // 0x11

/** @apiSince 5 */

public static final int TYPE_WORK_PAGER = 18; // 0x12
}

/**
 * <p>
 * A data kind representing a photo for the contact.
 * </p>
 * <p>
 * Some sync adapters will choose to download photos in a separate
 * pass. A common pattern is to use columns {@link android.provider.ContactsContract.Data#SYNC1 ContactsContract.Data#SYNC1}
 * through {@link android.provider.ContactsContract.Data#SYNC4 ContactsContract.Data#SYNC4} to store temporary
 * data, e.g. the image URL or ID, state of download, server-side version
 * of the image.  It is allowed for the {@link #PHOTO} to be null.
 * </p>
 * <p>
 * You can use all columns defined for {@link android.provider.ContactsContract.Data ContactsContract.Data} as
 * well as the following aliases.
 * </p>
 * <h2>Column aliases</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th>Type</th>
 * <th>Alias</th><th colspan='2'>Data column</th>
 * </tr>
 * <tr>
 * <td>NUMBER</td>
 * <td>{@link #PHOTO_FILE_ID}</td>
 * <td>{@link #DATA14}</td>
 * <td>ID of the hi-res photo file.</td>
 * </tr>
 * <tr>
 * <td>BLOB</td>
 * <td>{@link #PHOTO}</td>
 * <td>{@link #DATA15}</td>
 * <td>By convention, binary data is stored in DATA15.  The thumbnail of the
 * photo is stored in this column.</td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Photo implements android.provider.ContactsContract.DataColumnsWithJoins {

private Photo() { throw new RuntimeException("Stub!"); }

/**
 * MIME type used when storing this in data table.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/photo";

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/**
 * Thumbnail photo of the raw contact. This is the raw bytes of an image
 * that could be inflated using {@link android.graphics.BitmapFactory}.
 * <p>
 * Type: BLOB
 * @apiSince 5
 */

public static final java.lang.String PHOTO = "data15";

/**
 * Photo file ID for the display photo of the raw contact.
 * See {@link android.provider.ContactsContract.DisplayPhoto ContactsContract.DisplayPhoto}.
 * <p>
 * Type: NUMBER
 * @apiSince 14
 */

public static final java.lang.String PHOTO_FILE_ID = "data14";
}

/**
 * <p>
 * A data kind representing a relation.
 * </p>
 * <p>
 * You can use all columns defined for {@link android.provider.ContactsContract.Data ContactsContract.Data} as
 * well as the following aliases.
 * </p>
 * <h2>Column aliases</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th>Type</th>
 * <th>Alias</th><th colspan='2'>Data column</th>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #NAME}</td>
 * <td>{@link #DATA1}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #TYPE}</td>
 * <td>{@link #DATA2}</td>
 * <td>Allowed values are:
 * <p>
 * <ul>
 * <li>{@link #TYPE_CUSTOM}. Put the actual type in {@link #LABEL}.</li>
 * <li>{@link #TYPE_ASSISTANT}</li>
 * <li>{@link #TYPE_BROTHER}</li>
 * <li>{@link #TYPE_CHILD}</li>
 * <li>{@link #TYPE_DOMESTIC_PARTNER}</li>
 * <li>{@link #TYPE_FATHER}</li>
 * <li>{@link #TYPE_FRIEND}</li>
 * <li>{@link #TYPE_MANAGER}</li>
 * <li>{@link #TYPE_MOTHER}</li>
 * <li>{@link #TYPE_PARENT}</li>
 * <li>{@link #TYPE_PARTNER}</li>
 * <li>{@link #TYPE_REFERRED_BY}</li>
 * <li>{@link #TYPE_RELATIVE}</li>
 * <li>{@link #TYPE_SISTER}</li>
 * <li>{@link #TYPE_SPOUSE}</li>
 * </ul>
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #LABEL}</td>
 * <td>{@link #DATA3}</td>
 * <td></td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Relation implements android.provider.ContactsContract.DataColumnsWithJoins, android.provider.ContactsContract.CommonDataKinds.CommonColumns {

private Relation() { throw new RuntimeException("Stub!"); }

/**
 * Return the string resource that best describes the given
 * {@link #TYPE}. Will always return a valid resource.
 * @apiSince 11
 */

public static int getTypeLabelResource(int type) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link java.lang.CharSequence CharSequence} that best describes the given type,
 * possibly substituting the given {@link #LABEL} value
 * for {@link #TYPE_CUSTOM}.
 * @apiSince 11
 */

public static java.lang.CharSequence getTypeLabel(android.content.res.Resources res, int type, java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * MIME type used when storing this in data table.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/relation";

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/**
 * The name of the relative as the user entered it.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String NAME = "data1";

/** @apiSince 5 */

public static final int TYPE_ASSISTANT = 1; // 0x1

/** @apiSince 5 */

public static final int TYPE_BROTHER = 2; // 0x2

/** @apiSince 5 */

public static final int TYPE_CHILD = 3; // 0x3

/** @apiSince 5 */

public static final int TYPE_DOMESTIC_PARTNER = 4; // 0x4

/** @apiSince 5 */

public static final int TYPE_FATHER = 5; // 0x5

/** @apiSince 5 */

public static final int TYPE_FRIEND = 6; // 0x6

/** @apiSince 5 */

public static final int TYPE_MANAGER = 7; // 0x7

/** @apiSince 5 */

public static final int TYPE_MOTHER = 8; // 0x8

/** @apiSince 5 */

public static final int TYPE_PARENT = 9; // 0x9

/** @apiSince 5 */

public static final int TYPE_PARTNER = 10; // 0xa

/** @apiSince 5 */

public static final int TYPE_REFERRED_BY = 11; // 0xb

/** @apiSince 5 */

public static final int TYPE_RELATIVE = 12; // 0xc

/** @apiSince 5 */

public static final int TYPE_SISTER = 13; // 0xd

/** @apiSince 5 */

public static final int TYPE_SPOUSE = 14; // 0xe
}

/**
 * <p>
 * A data kind representing a SIP address for the contact.
 * </p>
 * <p>
 * You can use all columns defined for {@link android.provider.ContactsContract.Data ContactsContract.Data} as
 * well as the following aliases.
 * </p>
 * <h2>Column aliases</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th>Type</th>
 * <th>Alias</th><th colspan='2'>Data column</th>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #SIP_ADDRESS}</td>
 * <td>{@link #DATA1}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #TYPE}</td>
 * <td>{@link #DATA2}</td>
 * <td>Allowed values are:
 * <p>
 * <ul>
 * <li>{@link #TYPE_CUSTOM}. Put the actual type in {@link #LABEL}.</li>
 * <li>{@link #TYPE_HOME}</li>
 * <li>{@link #TYPE_WORK}</li>
 * <li>{@link #TYPE_OTHER}</li>
 * </ul>
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #LABEL}</td>
 * <td>{@link #DATA3}</td>
 * <td></td>
 * </tr>
 * </table>
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class SipAddress implements android.provider.ContactsContract.DataColumnsWithJoins, android.provider.ContactsContract.CommonDataKinds.CommonColumns {

private SipAddress() { throw new RuntimeException("Stub!"); }

/**
 * Return the string resource that best describes the given
 * {@link #TYPE}. Will always return a valid resource.
 * @apiSince 9
 */

public static int getTypeLabelResource(int type) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link java.lang.CharSequence CharSequence} that best describes the given type,
 * possibly substituting the given {@link #LABEL} value
 * for {@link #TYPE_CUSTOM}.
 * @apiSince 9
 */

public static java.lang.CharSequence getTypeLabel(android.content.res.Resources res, int type, java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * MIME type used when storing this in data table.
 * @apiSince 9
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/sip_address";

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/**
 * The SIP address.
 * <P>Type: TEXT</P>
 * @apiSince 9
 */

public static final java.lang.String SIP_ADDRESS = "data1";

/** @apiSince 9 */

public static final int TYPE_HOME = 1; // 0x1

/** @apiSince 9 */

public static final int TYPE_OTHER = 3; // 0x3

/** @apiSince 9 */

public static final int TYPE_WORK = 2; // 0x2
}

/**
 * A data kind representing the contact's proper name. You can use all
 * columns defined for {@link android.provider.ContactsContract.Data ContactsContract.Data} as well as the following aliases.
 *
 * <h2>Column aliases</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th>Type</th><th>Alias</th><th colspan='2'>Data column</th>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #DISPLAY_NAME}</td>
 * <td>{@link #DATA1}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #GIVEN_NAME}</td>
 * <td>{@link #DATA2}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #FAMILY_NAME}</td>
 * <td>{@link #DATA3}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #PREFIX}</td>
 * <td>{@link #DATA4}</td>
 * <td>Common prefixes in English names are "Mr", "Ms", "Dr" etc.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #MIDDLE_NAME}</td>
 * <td>{@link #DATA5}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #SUFFIX}</td>
 * <td>{@link #DATA6}</td>
 * <td>Common suffixes in English names are "Sr", "Jr", "III" etc.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #PHONETIC_GIVEN_NAME}</td>
 * <td>{@link #DATA7}</td>
 * <td>Used for phonetic spelling of the name, e.g. Pinyin, Katakana, Hiragana</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #PHONETIC_MIDDLE_NAME}</td>
 * <td>{@link #DATA8}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #PHONETIC_FAMILY_NAME}</td>
 * <td>{@link #DATA9}</td>
 * <td></td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class StructuredName implements android.provider.ContactsContract.DataColumnsWithJoins {

private StructuredName() { throw new RuntimeException("Stub!"); }

/**
 * MIME type used when storing this in data table.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/name";

/**
 * The name that should be used to display the contact.
 * <i>Unstructured component of the name should be consistent with
 * its structured representation.</i>
 * <p>
 * Type: TEXT
 * @apiSince 5
 */

public static final java.lang.String DISPLAY_NAME = "data1";

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/**
 * The family name for the contact.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String FAMILY_NAME = "data3";

/**
 * The style used for combining given/middle/family name into a full name.
 * See {@link android.provider.ContactsContract.FullNameStyle ContactsContract.FullNameStyle}.
 * @apiSince 21
 */

public static final java.lang.String FULL_NAME_STYLE = "data10";

/**
 * The given name for the contact.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String GIVEN_NAME = "data2";

/**
 * The contact's middle name
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String MIDDLE_NAME = "data5";

/**
 * The phonetic version of the family name for the contact.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String PHONETIC_FAMILY_NAME = "data9";

/**
 * The phonetic version of the given name for the contact.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String PHONETIC_GIVEN_NAME = "data7";

/**
 * The phonetic version of the additional name for the contact.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String PHONETIC_MIDDLE_NAME = "data8";

/**
 * The alphabet used for capturing the phonetic name.
 * See ContactsContract.PhoneticNameStyle.
 * @apiSince 11
 */

public static final java.lang.String PHONETIC_NAME_STYLE = "data11";

/**
 * The contact's honorific prefix, e.g.&nbsp;"Sir"
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String PREFIX = "data4";

/**
 * The contact's honorific suffix, e.g.&nbsp;"Jr"
 * @apiSince 5
 */

public static final java.lang.String SUFFIX = "data6";
}

/**
 * <p>
 * A data kind representing a postal addresses.
 * </p>
 * <p>
 * You can use all columns defined for {@link android.provider.ContactsContract.Data ContactsContract.Data} as
 * well as the following aliases.
 * </p>
 * <h2>Column aliases</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th>Type</th>
 * <th>Alias</th><th colspan='2'>Data column</th>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #FORMATTED_ADDRESS}</td>
 * <td>{@link #DATA1}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #TYPE}</td>
 * <td>{@link #DATA2}</td>
 * <td>Allowed values are:
 * <p>
 * <ul>
 * <li>{@link #TYPE_CUSTOM}. Put the actual type in {@link #LABEL}.</li>
 * <li>{@link #TYPE_HOME}</li>
 * <li>{@link #TYPE_WORK}</li>
 * <li>{@link #TYPE_OTHER}</li>
 * </ul>
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #LABEL}</td>
 * <td>{@link #DATA3}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #STREET}</td>
 * <td>{@link #DATA4}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #POBOX}</td>
 * <td>{@link #DATA5}</td>
 * <td>Post Office Box number</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #NEIGHBORHOOD}</td>
 * <td>{@link #DATA6}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #CITY}</td>
 * <td>{@link #DATA7}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #REGION}</td>
 * <td>{@link #DATA8}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #POSTCODE}</td>
 * <td>{@link #DATA9}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #COUNTRY}</td>
 * <td>{@link #DATA10}</td>
 * <td></td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class StructuredPostal implements android.provider.ContactsContract.DataColumnsWithJoins, android.provider.ContactsContract.CommonDataKinds.CommonColumns {

private StructuredPostal() { throw new RuntimeException("Stub!"); }

/**
 * Return the string resource that best describes the given
 * {@link #TYPE}. Will always return a valid resource.
 * @apiSince 5
 */

public static int getTypeLabelResource(int type) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link java.lang.CharSequence CharSequence} that best describes the given type,
 * possibly substituting the given {@link #LABEL} value
 * for {@link #TYPE_CUSTOM}.
 * @apiSince 5
 */

public static java.lang.CharSequence getTypeLabel(android.content.res.Resources res, int type, java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * Can be city, village, town, borough, etc. This is the postal town
 * and not necessarily the place of residence or place of business.
 * <p>
 * Type: TEXT
 * @apiSince 5
 */

public static final java.lang.String CITY = "data7";

/**
 * MIME type used when storing this in data table.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/postal-address_v2";

/**
 * The MIME type of {@link #CONTENT_URI} providing a directory of
 * postal addresses.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/postal-address_v2";

/**
 * The content:// style URI for all data records of the
 * {@link android.provider.ContactsContract.CommonDataKinds.StructuredPostal#CONTENT_ITEM_TYPE StructuredPostal#CONTENT_ITEM_TYPE} MIME type.
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The name or code of the country.
 * <p>
 * Type: TEXT
 * @apiSince 5
 */

public static final java.lang.String COUNTRY = "data10";

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/**
 * The full, unstructured postal address. <i>This field must be
 * consistent with any structured data.</i>
 * <p>
 * Type: TEXT
 * @apiSince 5
 */

public static final java.lang.String FORMATTED_ADDRESS = "data1";

/**
 * This is used to disambiguate a street address when a city
 * contains more than one street with the same name, or to specify a
 * small place whose mail is routed through a larger postal town. In
 * China it could be a county or a minor city.
 * <p>
 * Type: TEXT
 * @apiSince 5
 */

public static final java.lang.String NEIGHBORHOOD = "data6";

/**
 * Covers actual P.O. boxes, drawers, locked bags, etc. This is
 * usually but not always mutually exclusive with street.
 * <p>
 * Type: TEXT
 * @apiSince 5
 */

public static final java.lang.String POBOX = "data5";

/**
 * Postal code. Usually country-wide, but sometimes specific to the
 * city (e.g. "2" in "Dublin 2, Ireland" addresses).
 * <p>
 * Type: TEXT
 * @apiSince 5
 */

public static final java.lang.String POSTCODE = "data9";

/**
 * A state, province, county (in Ireland), Land (in Germany),
 * departement (in France), etc.
 * <p>
 * Type: TEXT
 * @apiSince 5
 */

public static final java.lang.String REGION = "data8";

/**
 * Can be street, avenue, road, etc. This element also includes the
 * house number and room/apartment/flat/floor number.
 * <p>
 * Type: TEXT
 * @apiSince 5
 */

public static final java.lang.String STREET = "data4";

/** @apiSince 5 */

public static final int TYPE_HOME = 1; // 0x1

/** @apiSince 5 */

public static final int TYPE_OTHER = 3; // 0x3

/** @apiSince 5 */

public static final int TYPE_WORK = 2; // 0x2
}

/**
 * <p>
 * A data kind representing a website related to the contact.
 * </p>
 * <p>
 * You can use all columns defined for {@link android.provider.ContactsContract.Data ContactsContract.Data} as
 * well as the following aliases.
 * </p>
 * <h2>Column aliases</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th>Type</th>
 * <th>Alias</th><th colspan='2'>Data column</th>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #URL}</td>
 * <td>{@link #DATA1}</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #TYPE}</td>
 * <td>{@link #DATA2}</td>
 * <td>Allowed values are:
 * <p>
 * <ul>
 * <li>{@link #TYPE_CUSTOM}. Put the actual type in {@link #LABEL}.</li>
 * <li>{@link #TYPE_HOMEPAGE}</li>
 * <li>{@link #TYPE_BLOG}</li>
 * <li>{@link #TYPE_PROFILE}</li>
 * <li>{@link #TYPE_HOME}</li>
 * <li>{@link #TYPE_WORK}</li>
 * <li>{@link #TYPE_FTP}</li>
 * <li>{@link #TYPE_OTHER}</li>
 * </ul>
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #LABEL}</td>
 * <td>{@link #DATA3}</td>
 * <td></td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Website implements android.provider.ContactsContract.DataColumnsWithJoins, android.provider.ContactsContract.CommonDataKinds.CommonColumns {

private Website() { throw new RuntimeException("Stub!"); }

/**
 * MIME type used when storing this in data table.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/website";

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/** @apiSince 5 */

public static final int TYPE_BLOG = 2; // 0x2

/** @apiSince 5 */

public static final int TYPE_FTP = 6; // 0x6

/** @apiSince 5 */

public static final int TYPE_HOME = 4; // 0x4

/** @apiSince 5 */

public static final int TYPE_HOMEPAGE = 1; // 0x1

/** @apiSince 5 */

public static final int TYPE_OTHER = 7; // 0x7

/** @apiSince 5 */

public static final int TYPE_PROFILE = 3; // 0x3

/** @apiSince 5 */

public static final int TYPE_WORK = 5; // 0x5

/**
 * The website URL string.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String URL = "data1";
}

}

/**
 * Contact name and contact name metadata columns in the RawContacts table.
 *
 * @see android.provider.ContactsContract.Contacts
 * @see android.provider.ContactsContract.RawContacts
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface ContactNameColumns {

/**
 * <p>
 * An alternative representation of the display name, such as "family name first"
 * instead of "given name first" for Western names.  If an alternative is not
 * available, the values should be the same as {@link #DISPLAY_NAME_PRIMARY}.
 * </p>
 * <p>
 * A contacts provider is free to provide alternatives as necessary for
 * its target market.
 * For example the default Android Open Source Project contacts provider
 * currently provides an
 * alternative in a single case:  if the display name is
 * based on the structured name and the structured name follows
 * the Western full name style, then the field contains the "family name first"
 * version of the full name.
 * Other cases may be added later.
 * </p>
 * @apiSince 11
 */

public static final java.lang.String DISPLAY_NAME_ALTERNATIVE = "display_name_alt";

/**
 * <p>
 * The standard text shown as the contact's display name, based on the best
 * available information for the contact (for example, it might be the email address
 * if the name is not available).
 * The information actually used to compute the name is stored in
 * {@link #DISPLAY_NAME_SOURCE}.
 * </p>
 * <p>
 * A contacts provider is free to choose whatever representation makes most
 * sense for its target market.
 * For example in the default Android Open Source Project implementation,
 * if the display name is
 * based on the structured name and the structured name follows
 * the Western full-name style, then this field contains the "given name first"
 * version of the full name.
 * <p>
 *
 * @see android.provider.ContactsContract.ContactNameColumns#DISPLAY_NAME_ALTERNATIVE
 * @apiSince 11
 */

public static final java.lang.String DISPLAY_NAME_PRIMARY = "display_name";

/**
 * The kind of data that is used as the display name for the contact, such as
 * structured name or email address.  See {@link android.provider.ContactsContract.DisplayNameSources DisplayNameSources}.
 * @apiSince 11
 */

public static final java.lang.String DISPLAY_NAME_SOURCE = "display_name_source";

/**
 * <p>
 * Pronunciation of the full name in the phonetic alphabet specified by
 * {@link #PHONETIC_NAME_STYLE}.
 * </p>
 * <p>
 * The value may be set manually by the user. This capability is of
 * interest only in countries with commonly used phonetic alphabets,
 * such as Japan and Korea. See {@link android.provider.ContactsContract.PhoneticNameStyle PhoneticNameStyle}.
 * </p>
 * @apiSince 11
 */

public static final java.lang.String PHONETIC_NAME = "phonetic_name";

/**
 * The phonetic alphabet used to represent the {@link #PHONETIC_NAME}.  See
 * {@link android.provider.ContactsContract.PhoneticNameStyle PhoneticNameStyle}.
 * @apiSince 11
 */

public static final java.lang.String PHONETIC_NAME_STYLE = "phonetic_name_style";

/**
 * Sort key based on the alternative representation of the full name,
 * {@link #DISPLAY_NAME_ALTERNATIVE}.  Thus for Western names,
 * it is the one using the "family name first" format.
 * @apiSince 11
 */

public static final java.lang.String SORT_KEY_ALTERNATIVE = "sort_key_alt";

/**
 * Sort key that takes into account locale-based traditions for sorting
 * names in address books.  The default
 * sort key is {@link #DISPLAY_NAME_PRIMARY}.  For Chinese names
 * the sort key is the name's Pinyin spelling, and for Japanese names
 * it is the Hiragana version of the phonetic name.
 * @apiSince 11
 */

public static final java.lang.String SORT_KEY_PRIMARY = "sort_key";
}

/**
 * Columns of {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts} that track the user's
 * preferences for, or interactions with, the contact.
 *
 * @see android.provider.ContactsContract.Contacts
 * @see android.provider.ContactsContract.RawContacts
 * @see android.provider.ContactsContract.Data
 * @see android.provider.ContactsContract.PhoneLookup
 * @see android.provider.ContactsContract.Contacts.AggregationSuggestions
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface ContactOptionsColumns {

/**
 * URI for a custom ringtone associated with the contact. If null or missing,
 * the default ringtone is used.
 * <P>Type: TEXT (URI to the ringtone)</P>
 * @apiSince 5
 */

public static final java.lang.String CUSTOM_RINGTONE = "custom_ringtone";

/**
 * The last time a contact was contacted.
 * <p class="caution"><b>Caution: </b>If you publish your app to the Google Play Store,
 * this field is obsolete, regardless of Android version. For more information, see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.</p>
 * <P>Type: INTEGER</P>
 *
 * @deprecated Contacts affinity information is no longer supported as of
 * Android version {@link android.os.Build.VERSION_CODES#Q}. This column
 * always contains 0.
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String LAST_TIME_CONTACTED = "last_time_contacted";

/**
 * The position at which the contact is pinned. If {@link android.provider.ContactsContract.PinnedPositions#UNPINNED PinnedPositions#UNPINNED},
 * the contact is not pinned. Also see {@link android.provider.ContactsContract.PinnedPositions PinnedPositions}.
 * <P>Type: INTEGER </P>
 * @apiSince 21
 */

public static final java.lang.String PINNED = "pinned";

/**
 * Whether the contact should always be sent to voicemail. If missing,
 * defaults to false.
 * <P>Type: INTEGER (0 for false, 1 for true)</P>
 * @apiSince 5
 */

public static final java.lang.String SEND_TO_VOICEMAIL = "send_to_voicemail";

/**
 * Is the contact starred?
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 5
 */

public static final java.lang.String STARRED = "starred";

/**
 * The number of times a contact has been contacted.
 * <p class="caution"><b>Caution: </b>If you publish your app to the Google Play Store,
 * this field is obsolete, regardless of Android version. For more information, see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.</p>
 * <P>Type: INTEGER</P>
 *
 * @deprecated Contacts affinity information is no longer supported as of
 * Android version {@link android.os.Build.VERSION_CODES#Q}. This column
 * always contains 0.
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String TIMES_CONTACTED = "times_contacted";
}

/**
 * @see android.provider.ContactsContract.Contacts
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface ContactStatusColumns {

/**
 * Contact Chat Capabilities. See {@link android.provider.ContactsContract.StatusUpdates StatusUpdates} for individual
 * definitions.
 * <p>Type: NUMBER</p>
 * @apiSince 11
 */

public static final java.lang.String CONTACT_CHAT_CAPABILITY = "contact_chat_capability";

/**
 * Contact presence status. See {@link android.provider.ContactsContract.StatusUpdates StatusUpdates} for individual status
 * definitions.
 * <p>Type: NUMBER</p>
 * @apiSince 5
 */

public static final java.lang.String CONTACT_PRESENCE = "contact_presence";

/**
 * Contact's latest status update.
 * <p>Type: TEXT</p>
 * @apiSince 5
 */

public static final java.lang.String CONTACT_STATUS = "contact_status";

/**
 * The resource ID of the icon for the source of contact status. This
 * resource is scoped by the {@link #CONTACT_STATUS_RES_PACKAGE}.
 * <p>Type: NUMBER</p>
 * @apiSince 5
 */

public static final java.lang.String CONTACT_STATUS_ICON = "contact_status_icon";

/**
 * The resource ID of the label describing the source of contact
 * status, e.g.&nbsp;"Google Talk". This resource is scoped by the
 * {@link #CONTACT_STATUS_RES_PACKAGE}.
 * <p>Type: NUMBER</p>
 * @apiSince 5
 */

public static final java.lang.String CONTACT_STATUS_LABEL = "contact_status_label";

/**
 * The package containing resources for this status: label and icon.
 * <p>Type: TEXT</p>
 * @apiSince 5
 */

public static final java.lang.String CONTACT_STATUS_RES_PACKAGE = "contact_status_res_package";

/**
 * The absolute time in milliseconds when the latest status was
 * inserted/updated.
 * <p>Type: NUMBER</p>
 * @apiSince 5
 */

public static final java.lang.String CONTACT_STATUS_TIMESTAMP = "contact_status_ts";
}

/**
 * Constants for the contacts table, which contains a record per aggregate
 * of raw contacts representing the same person.
 * <h3>Operations</h3>
 * <dl>
 * <dt><b>Insert</b></dt>
 * <dd>A Contact cannot be created explicitly. When a raw contact is
 * inserted, the provider will first try to find a Contact representing the
 * same person. If one is found, the raw contact's
 * {@link android.provider.ContactsContract.RawContacts#CONTACT_ID RawContacts#CONTACT_ID} column gets the _ID of the aggregate
 * Contact. If no match is found, the provider automatically inserts a new
 * Contact and puts its _ID into the {@link android.provider.ContactsContract.RawContacts#CONTACT_ID RawContacts#CONTACT_ID} column
 * of the newly inserted raw contact.</dd>
 * <dt><b>Update</b></dt>
 * <dd>Only certain columns of Contact are modifiable:
 * {@link #STARRED}, {@link #CUSTOM_RINGTONE}, {@link #SEND_TO_VOICEMAIL}. Changing any of
 * these columns on the Contact also changes them on all constituent raw
 * contacts.</dd>
 * <dt><b>Delete</b></dt>
 * <dd>Be careful with deleting Contacts! Deleting an aggregate contact
 * deletes all constituent raw contacts. The corresponding sync adapters
 * will notice the deletions of their respective raw contacts and remove
 * them from their back end storage.</dd>
 * <dt><b>Query</b></dt>
 * <dd>
 * <ul>
 * <li>If you need to read an individual contact, consider using
 * {@link #CONTENT_LOOKUP_URI} instead of {@link #CONTENT_URI}.</li>
 * <li>If you need to look up a contact by the phone number, use
 * {@link android.provider.ContactsContract.PhoneLookup#CONTENT_FILTER_URI PhoneLookup#CONTENT_FILTER_URI},
 * which is optimized for this purpose.</li>
 * <li>If you need to look up a contact by partial name, e.g. to produce
 * filter-as-you-type suggestions, use the {@link #CONTENT_FILTER_URI} URI.
 * <li>If you need to look up a contact by some data element like email
 * address, nickname, etc, use a query against the {@link android.provider.ContactsContract.Data ContactsContract.Data} table.
 * The result will contain contact ID, name etc.
 * </ul>
 * </dd>
 * </dl>
 * <h2>Columns</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th colspan='4'>Contacts</th>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #_ID}</td>
 * <td>read-only</td>
 * <td>Row ID. Consider using {@link #LOOKUP_KEY} instead.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #LOOKUP_KEY}</td>
 * <td>read-only</td>
 * <td>An opaque value that contains hints on how to find the contact if its
 * row id changed as a result of a sync or aggregation.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>NAME_RAW_CONTACT_ID</td>
 * <td>read-only</td>
 * <td>The ID of the raw contact that contributes the display name
 * to the aggregate contact. During aggregation one of the constituent
 * raw contacts is chosen using a heuristic: a longer name or a name
 * with more diacritic marks or more upper case characters is chosen.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>DISPLAY_NAME_PRIMARY</td>
 * <td>read-only</td>
 * <td>The display name for the contact. It is the display name
 * contributed by the raw contact referred to by the NAME_RAW_CONTACT_ID
 * column.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #PHOTO_ID}</td>
 * <td>read-only</td>
 * <td>Reference to the row in the {@link android.provider.ContactsContract.Data ContactsContract.Data} table holding the photo.
 * That row has the mime type
 * {@link CommonDataKinds.Photo#CONTENT_ITEM_TYPE}. The value of this field
 * is computed automatically based on the
 * {@link CommonDataKinds.Photo#IS_SUPER_PRIMARY} field of the data rows of
 * that mime type.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #PHOTO_URI}</td>
 * <td>read-only</td>
 * <td>A URI that can be used to retrieve the contact's full-size photo. This
 * column is the preferred method of retrieving the contact photo.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #PHOTO_THUMBNAIL_URI}</td>
 * <td>read-only</td>
 * <td>A URI that can be used to retrieve the thumbnail of contact's photo.  This
 * column is the preferred method of retrieving the contact photo.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #IN_VISIBLE_GROUP}</td>
 * <td>read-only</td>
 * <td>An indicator of whether this contact is supposed to be visible in the
 * UI. "1" if the contact has at least one raw contact that belongs to a
 * visible group; "0" otherwise.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #HAS_PHONE_NUMBER}</td>
 * <td>read-only</td>
 * <td>An indicator of whether this contact has at least one phone number.
 * "1" if there is at least one phone number, "0" otherwise.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #STARRED}</td>
 * <td>read/write</td>
 * <td>An indicator for favorite contacts: '1' if favorite, '0' otherwise.
 * When raw contacts are aggregated, this field is automatically computed:
 * if any constituent raw contacts are starred, then this field is set to
 * '1'. Setting this field automatically changes the corresponding field on
 * all constituent raw contacts.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #CUSTOM_RINGTONE}</td>
 * <td>read/write</td>
 * <td>A custom ringtone associated with a contact. Typically this is the
 * URI returned by an activity launched with the
 * {@link android.media.RingtoneManager#ACTION_RINGTONE_PICKER} intent.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #SEND_TO_VOICEMAIL}</td>
 * <td>read/write</td>
 * <td>An indicator of whether calls from this contact should be forwarded
 * directly to voice mail ('1') or not ('0'). When raw contacts are
 * aggregated, this field is automatically computed: if <i>all</i>
 * constituent raw contacts have SEND_TO_VOICEMAIL=1, then this field is set
 * to '1'. Setting this field automatically changes the corresponding field
 * on all constituent raw contacts.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #CONTACT_PRESENCE}</td>
 * <td>read-only</td>
 * <td>Contact IM presence status. See {@link android.provider.ContactsContract.StatusUpdates StatusUpdates} for individual
 * status definitions. Automatically computed as the highest presence of all
 * constituent raw contacts. The provider may choose not to store this value
 * in persistent storage. The expectation is that presence status will be
 * updated on a regular basis.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #CONTACT_STATUS}</td>
 * <td>read-only</td>
 * <td>Contact's latest status update. Automatically computed as the latest
 * of all constituent raw contacts' status updates.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #CONTACT_STATUS_TIMESTAMP}</td>
 * <td>read-only</td>
 * <td>The absolute time in milliseconds when the latest status was
 * inserted/updated.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #CONTACT_STATUS_RES_PACKAGE}</td>
 * <td>read-only</td>
 * <td> The package containing resources for this status: label and icon.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #CONTACT_STATUS_LABEL}</td>
 * <td>read-only</td>
 * <td>The resource ID of the label describing the source of contact status,
 * e.g. "Google Talk". This resource is scoped by the
 * {@link #CONTACT_STATUS_RES_PACKAGE}.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #CONTACT_STATUS_ICON}</td>
 * <td>read-only</td>
 * <td>The resource ID of the icon for the source of contact status. This
 * resource is scoped by the {@link #CONTACT_STATUS_RES_PACKAGE}.</td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Contacts implements android.provider.BaseColumns, android.provider.ContactsContract.ContactsColumns, android.provider.ContactsContract.ContactOptionsColumns, android.provider.ContactsContract.ContactNameColumns, android.provider.ContactsContract.ContactStatusColumns {

private Contacts() { throw new RuntimeException("Stub!"); }

/**
 * Builds a {@link #CONTENT_LOOKUP_URI} style {@link android.net.Uri Uri} describing the
 * requested {@link android.provider.ContactsContract.Contacts Contacts} entry.
 *
 * @param contactUri A {@link #CONTENT_URI} row, or an existing
 *            {@link #CONTENT_LOOKUP_URI} to attempt refreshing.
 * @apiSince 5
 */

public static android.net.Uri getLookupUri(android.content.ContentResolver resolver, android.net.Uri contactUri) { throw new RuntimeException("Stub!"); }

/**
 * Build a {@link #CONTENT_LOOKUP_URI} lookup {@link android.net.Uri Uri} using the
 * given {@link android.provider.ContactsContract.Contacts#_ID ContactsContract.Contacts#_ID} and {@link #LOOKUP_KEY}.
 * <p>
 * Returns null if unable to construct a valid lookup URI from the
 * provided parameters.
 * @apiSince 5
 */

public static android.net.Uri getLookupUri(long contactId, java.lang.String lookupKey) { throw new RuntimeException("Stub!"); }

/**
 * Computes a content URI (see {@link #CONTENT_URI}) given a lookup URI.
 * <p>
 * Returns null if the contact cannot be found.
 * @apiSince 5
 */

public static android.net.Uri lookupContact(android.content.ContentResolver resolver, android.net.Uri lookupUri) { throw new RuntimeException("Stub!"); }

/**
 * Mark a contact as having been contacted. Updates two fields:
 * {@link #TIMES_CONTACTED} and {@link #LAST_TIME_CONTACTED}. The
 * TIMES_CONTACTED field is incremented by 1 and the LAST_TIME_CONTACTED
 * field is populated with the current system time.
 *
 * <p class="caution"><b>Caution: </b>If you publish your app to the Google Play Store,
 * this field is obsolete, regardless of Android version. For more information, see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.</p>
 *
 * @param resolver the ContentResolver to use
 * @param contactId the person who was contacted
 *
 * @deprecated Contacts affinity information is no longer supported as of
 * Android version {@link android.os.Build.VERSION_CODES#Q}. This method
 * is no-op.
 * @apiSince 5
 * @deprecatedSince 16
 */

@Deprecated
public static void markAsContacted(android.content.ContentResolver resolver, long contactId) { throw new RuntimeException("Stub!"); }

/**
 * Return TRUE if a contact ID is from the contacts provider on the enterprise profile.
 *
 * {@link android.provider.ContactsContract.PhoneLookup#ENTERPRISE_CONTENT_FILTER_URI PhoneLookup#ENTERPRISE_CONTENT_FILTER_URI} may return such a contact.
 * @apiSince 21
 */

public static boolean isEnterpriseContactId(long contactId) { throw new RuntimeException("Stub!"); }

/**
 * Opens an InputStream for the contacts's photo and returns the
 * photo as a byte stream.
 * @param cr The content resolver to use for querying
 * @param contactUri the contact whose photo should be used. This can be used with
 * either a {@link #CONTENT_URI} or a {@link #CONTENT_LOOKUP_URI} URI.
 * @param preferHighres If this is true and the contact has a higher resolution photo
 * available, it is returned. If false, this function always tries to get the thumbnail
 * @return an InputStream of the photo, or null if no photo is present
 * @apiSince 14
 */

public static java.io.InputStream openContactPhotoInputStream(android.content.ContentResolver cr, android.net.Uri contactUri, boolean preferHighres) { throw new RuntimeException("Stub!"); }

/**
 * Opens an InputStream for the contacts's thumbnail photo and returns the
 * photo as a byte stream.
 * @param cr The content resolver to use for querying
 * @param contactUri the contact whose photo should be used. This can be used with
 * either a {@link #CONTENT_URI} or a {@link #CONTENT_LOOKUP_URI} URI.
 * @return an InputStream of the photo, or null if no photo is present
 * @see #openContactPhotoInputStream(ContentResolver, Uri, boolean), if instead
 * of the thumbnail the high-res picture is preferred
 * @apiSince 5
 */

public static java.io.InputStream openContactPhotoInputStream(android.content.ContentResolver cr, android.net.Uri contactUri) { throw new RuntimeException("Stub!"); }

/**
 * The content:// style URI used for "type-to-filter" functionality on the
 * {@link #CONTENT_URI} URI. The filter string will be used to match
 * various parts of the contact name. The filter argument should be passed
 * as an additional path segment after this URI.
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_FILTER_URI;
static { CONTENT_FILTER_URI = null; }

/**
 * The content:// style URI for showing a list of frequently contacted people.
 *
 * @deprecated Frequent contacts are no longer supported as of
 * Android version {@link android.os.Build.VERSION_CODES#Q}.
 * This URI always returns an empty cursor.
 *
 * <p class="caution"><b>Caution: </b>If you publish your app to the Google Play Store, this
 * field doesn't sort results based on contacts frequency. For more information, see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.
 * @apiSince 21
 * @deprecatedSince 29
 */

@Deprecated public static final android.net.Uri CONTENT_FREQUENT_URI;
static { CONTENT_FREQUENT_URI = null; }

/** @apiSince 5 */

public static final android.net.Uri CONTENT_GROUP_URI;
static { CONTENT_GROUP_URI = null; }

/**
 * The MIME type of a {@link #CONTENT_URI} subdirectory of a single
 * person.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact";

/**
 * A content:// style URI for this table that should be used to create
 * shortcuts or otherwise create long-term links to contacts. This URI
 * should always be followed by a "/" and the contact's {@link #LOOKUP_KEY}.
 * It can optionally also have a "/" and last known contact ID appended after
 * that. This "complete" format is an important optimization and is highly recommended.
 * <p>
 * As long as the contact's row ID remains the same, this URI is
 * equivalent to {@link #CONTENT_URI}. If the contact's row ID changes
 * as a result of a sync or aggregation, this URI will look up the
 * contact using indirect information (sync IDs or constituent raw
 * contacts).
 * <p>
 * Lookup key should be appended unencoded - it is stored in the encoded
 * form, ready for use in a URI.
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_LOOKUP_URI;
static { CONTENT_LOOKUP_URI = null; }

/**
 * Base {@link android.net.Uri Uri} for referencing multiple {@link android.provider.ContactsContract.Contacts Contacts} entry,
 * created by appending {@link #LOOKUP_KEY} using
 * {@link android.net.Uri#withAppendedPath(android.net.Uri,java.lang.String) Uri#withAppendedPath(Uri, String)}. The lookup keys have to be
 * joined with the colon (":") separator, and the resulting string encoded.
 *
 * Provides {@link android.provider.OpenableColumns OpenableColumns} columns when queried, or returns the
 * referenced contact formatted as a vCard when opened through
 * {@link android.content.ContentResolver#openAssetFileDescriptor(android.net.Uri,java.lang.String) ContentResolver#openAssetFileDescriptor(Uri, String)}.
 *
 * <p>
 * Usage example:
 * <dl>
 * <dt>The following code snippet creates a multi-vcard URI that references all the
 * contacts in a user's database.</dt>
 * <dd>
 *
 * <pre>
 * public Uri getAllContactsVcardUri() {
 *     Cursor cursor = getActivity().getContentResolver().query(Contacts.CONTENT_URI,
 *         new String[] {Contacts.LOOKUP_KEY}, null, null, null);
 *     if (cursor == null) {
 *         return null;
 *     }
 *     try {
 *         StringBuilder uriListBuilder = new StringBuilder();
 *         int index = 0;
 *         while (cursor.moveToNext()) {
 *             if (index != 0) uriListBuilder.append(':');
 *             uriListBuilder.append(cursor.getString(0));
 *             index++;
 *         }
 *         return Uri.withAppendedPath(Contacts.CONTENT_MULTI_VCARD_URI,
 *                 Uri.encode(uriListBuilder.toString()));
 *     } finally {
 *         cursor.close();
 *     }
 * }
 * </pre>
 *
 * </p>
 * @apiSince 21
 */

public static final android.net.Uri CONTENT_MULTI_VCARD_URI;
static { CONTENT_MULTI_VCARD_URI = null; }

/**
 * <p>The content:// style URI used for "type-to-filter" functionality on the
 * {@link #CONTENT_STREQUENT_URI} URI. The filter string will be used to match
 * various parts of the contact name. The filter argument should be passed
 * as an additional path segment after this URI.
 *
 * <p class="caution"><b>Caution: </b>If you publish your app to the Google Play Store, this
 * field doesn't sort results based on contacts frequency. For more information, see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_STREQUENT_FILTER_URI;
static { CONTENT_STREQUENT_FILTER_URI = null; }

/**
 * The content:// style URI for this table joined with useful data from
 * {@link android.provider.ContactsContract.Data ContactsContract.Data}, filtered to include only starred contacts.
 * Frequent contacts are no longer included in the result as of
 * Android version {@link android.os.Build.VERSION_CODES#Q}.
 *
 * <p class="caution"><b>Caution: </b>If you publish your app to the Google Play Store, this
 * field doesn't sort results based on contacts frequency. For more information, see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_STREQUENT_URI;
static { CONTENT_STREQUENT_URI = null; }

/**
 * The MIME type of {@link #CONTENT_URI} providing a directory of
 * people.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/contact";

/**
 * The content:// style URI for this table
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The MIME type of a {@link #CONTENT_URI} subdirectory of a single
 * person.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_VCARD_TYPE = "text/x-vcard";

/**
 * Base {@link android.net.Uri Uri} for referencing a single {@link android.provider.ContactsContract.Contacts Contacts} entry,
 * created by appending {@link #LOOKUP_KEY} using
 * {@link android.net.Uri#withAppendedPath(android.net.Uri,java.lang.String) Uri#withAppendedPath(Uri, String)}. Provides
 * {@link android.provider.OpenableColumns OpenableColumns} columns when queried, or returns the
 * referenced contact formatted as a vCard when opened through
 * {@link android.content.ContentResolver#openAssetFileDescriptor(android.net.Uri,java.lang.String) ContentResolver#openAssetFileDescriptor(Uri, String)}.
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_VCARD_URI;
static { CONTENT_VCARD_URI = null; }

/**
 * It supports the similar semantics as {@link #CONTENT_FILTER_URI} and returns the same
 * columns. This URI requires {@link android.provider.ContactsContract#DIRECTORY_PARAM_KEY ContactsContract#DIRECTORY_PARAM_KEY} in parameters,
 * otherwise it will throw IllegalArgumentException.
 * @apiSince 24
 */

public static final android.net.Uri ENTERPRISE_CONTENT_FILTER_URI;
static { ENTERPRISE_CONTENT_FILTER_URI = null; }

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/**
 * Boolean parameter that may be used with {@link #CONTENT_VCARD_URI}
 * and {@link #CONTENT_MULTI_VCARD_URI} to indicate that the returned
 * vcard should not contain a photo.
 *
 * This is useful for obtaining a space efficient vcard.
 * @apiSince 23
 */

public static final java.lang.String QUERY_PARAMETER_VCARD_NO_PHOTO = "no_photo";
/**
 * <p>
 * A <i>read-only</i> sub-directory of a single contact aggregate that
 * contains all aggregation suggestions (other contacts). The
 * aggregation suggestions are computed based on approximate data
 * matches with this contact.
 * </p>
 * <p>
 * <i>Note: this query may be expensive! If you need to use it in bulk,
 * make sure the user experience is acceptable when the query runs for a
 * long time.</i>
 * <p>
 * Usage example:
 *
 * <pre>
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendEncodedPath(String.valueOf(contactId))
 *          .appendPath(Contacts.AggregationSuggestions.CONTENT_DIRECTORY)
 *          .appendQueryParameter(&quot;limit&quot;, &quot;3&quot;)
 *          .build()
 * Cursor cursor = getContentResolver().query(suggestionsUri,
 *          new String[] {Contacts.DISPLAY_NAME, Contacts._ID, Contacts.LOOKUP_KEY},
 *          null, null, null);
 * </pre>
 *
 * </p>
 * <p>
 * This directory can be used either with a {@link #CONTENT_URI} or
 * {@link #CONTENT_LOOKUP_URI}.
 * </p>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class AggregationSuggestions implements android.provider.BaseColumns, android.provider.ContactsContract.ContactsColumns, android.provider.ContactsContract.ContactOptionsColumns, android.provider.ContactsContract.ContactStatusColumns {

private AggregationSuggestions() { throw new RuntimeException("Stub!"); }

/**
 * The directory twig for this sub-table. The URI can be followed by an optional
 * type-to-filter, similar to
 * {@link android.provider.ContactsContract.Contacts#CONTENT_FILTER_URI}.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_DIRECTORY = "suggestions";
/**
 * A convenience builder for aggregation suggestion content URIs.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Optional existing contact ID.  If it is not provided, the search
 * will be based exclusively on the values supplied with {@link #addNameParameter}.
 *
 * @param contactId contact to find aggregation suggestions for
 * @return This Builder object to allow for chaining of calls to builder methods
 * @apiSince 23
 */

public android.provider.ContactsContract.Contacts.AggregationSuggestions.Builder setContactId(long contactId) { throw new RuntimeException("Stub!"); }

/**
 * Add a name to be used when searching for aggregation suggestions.
 *
 * @param name name to find aggregation suggestions for
 * @return This Builder object to allow for chaining of calls to builder methods
 * @apiSince 23
 */

public android.provider.ContactsContract.Contacts.AggregationSuggestions.Builder addNameParameter(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Maximum number of suggested aggregations that should be returned.
 * @param limit The maximum number of suggested aggregations
 *
 * @return This Builder object to allow for chaining of calls to builder methods
 * @apiSince 23
 */

public android.provider.ContactsContract.Contacts.AggregationSuggestions.Builder setLimit(int limit) { throw new RuntimeException("Stub!"); }

/**
 * Combine all of the options that have been set and return a new {@link android.net.Uri Uri}
 * object for fetching aggregation suggestions.
 * @apiSince 23
 */

public android.net.Uri build() { throw new RuntimeException("Stub!"); }
}

}

/**
 * A sub-directory of a single contact that contains all of the constituent raw contact
 * {@link android.provider.ContactsContract.Data ContactsContract.Data} rows.  This directory can be used either
 * with a {@link #CONTENT_URI} or {@link #CONTENT_LOOKUP_URI}.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Data implements android.provider.BaseColumns, android.provider.ContactsContract.DataColumns {

private Data() { throw new RuntimeException("Stub!"); }

/**
 * The directory twig for this sub-table
 * @apiSince 5
 */

public static final java.lang.String CONTENT_DIRECTORY = "data";
}

/**
 * <p>
 * A sub-directory of a contact that contains all of its
 * {@link android.provider.ContactsContract.RawContacts ContactsContract.RawContacts} as well as
 * {@link android.provider.ContactsContract.Data ContactsContract.Data} rows. To access this directory append
 * {@link #CONTENT_DIRECTORY} to the contact URI.
 * </p>
 * <p>
 * Entity has three ID fields: {@link #CONTACT_ID} for the contact,
 * {@link #RAW_CONTACT_ID} for the raw contact and {@link #DATA_ID} for
 * the data rows. Entity always contains at least one row per
 * constituent raw contact, even if there are no actual data rows. In
 * this case the {@link #DATA_ID} field will be null.
 * </p>
 * <p>
 * Entity reads all data for the entire contact in one transaction, to
 * guarantee consistency.  There is significant data duplication
 * in the Entity (each row repeats all Contact columns and all RawContact
 * columns), so the benefits of transactional consistency should be weighed
 * against the cost of transferring large amounts of denormalized data
 * from the Provider.
 * </p>
 * <p>
 * To reduce the amount of data duplication the contacts provider and directory
 * providers implementing this protocol are allowed to provide common Contacts
 * and RawContacts fields in the first row returned for each raw contact only and
 * leave them as null in subsequent rows.
 * </p>
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Entity implements android.provider.BaseColumns, android.provider.ContactsContract.ContactsColumns, android.provider.ContactsContract.ContactNameColumns, android.provider.ContactsContract.RawContactsColumns, android.provider.ContactsContract.BaseSyncColumns, android.provider.ContactsContract.SyncColumns, android.provider.ContactsContract.DataColumns, android.provider.ContactsContract.StatusColumns, android.provider.ContactsContract.ContactOptionsColumns, android.provider.ContactsContract.ContactStatusColumns, android.provider.ContactsContract.DataUsageStatColumns {

private Entity() { throw new RuntimeException("Stub!"); }

/**
 * The directory twig for this sub-table
 * @apiSince 11
 */

public static final java.lang.String CONTENT_DIRECTORY = "entities";

/**
 * The ID of the data row. The value will be null if this raw contact has no
 * data rows.
 * <P>Type: INTEGER</P>
 * @apiSince 11
 */

public static final java.lang.String DATA_ID = "data_id";

/**
 * The ID of the raw contact row.
 * <P>Type: INTEGER</P>
 * @apiSince 11
 */

public static final java.lang.String RAW_CONTACT_ID = "raw_contact_id";
}

/**
 * A <i>read-only</i> sub-directory of a single contact that contains
 * the contact's primary photo.  The photo may be stored in up to two ways -
 * the default "photo" is a thumbnail-sized image stored directly in the data
 * row, while the "display photo", if present, is a larger version stored as
 * a file.
 * <p>
 * Usage example:
 * <dl>
 * <dt>Retrieving the thumbnail-sized photo</dt>
 * <dd>
 * <pre>
 * public InputStream openPhoto(long contactId) {
 *     Uri contactUri = ContentUris.withAppendedId(Contacts.CONTENT_URI, contactId);
 *     Uri photoUri = Uri.withAppendedPath(contactUri, Contacts.Photo.CONTENT_DIRECTORY);
 *     Cursor cursor = getContentResolver().query(photoUri,
 *          new String[] {Contacts.Photo.PHOTO}, null, null, null);
 *     if (cursor == null) {
 *         return null;
 *     }
 *     try {
 *         if (cursor.moveToFirst()) {
 *             byte[] data = cursor.getBlob(0);
 *             if (data != null) {
 *                 return new ByteArrayInputStream(data);
 *             }
 *         }
 *     } finally {
 *         cursor.close();
 *     }
 *     return null;
 * }
 * </pre>
 * </dd>
 * <dt>Retrieving the larger photo version</dt>
 * <dd>
 * <pre>
 * public InputStream openDisplayPhoto(long contactId) {
 *     Uri contactUri = ContentUris.withAppendedId(Contacts.CONTENT_URI, contactId);
 *     Uri displayPhotoUri = Uri.withAppendedPath(contactUri, Contacts.Photo.DISPLAY_PHOTO);
 *     try {
 *         AssetFileDescriptor fd =
 *             getContentResolver().openAssetFileDescriptor(displayPhotoUri, "r");
 *         return fd.createInputStream();
 *     } catch (IOException e) {
 *         return null;
 *     }
 * }
 * </pre>
 * </dd>
 * </dl>
 *
 * </p>
 * <p>You may also consider using the convenience method
 * {@link android.provider.ContactsContract.Contacts#openContactPhotoInputStream(android.content.ContentResolver,android.net.Uri,boolean) ContactsContract.Contacts#openContactPhotoInputStream(ContentResolver, Uri, boolean)}
 * to retrieve the raw photo contents of either the thumbnail-sized or the full-sized photo.
 * </p>
 * <p>
 * This directory can be used either with a {@link #CONTENT_URI} or
 * {@link #CONTENT_LOOKUP_URI}.
 * </p>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Photo implements android.provider.BaseColumns, android.provider.ContactsContract.DataColumnsWithJoins {

private Photo() { throw new RuntimeException("Stub!"); }

/**
 * The directory twig for this sub-table
 * @apiSince 5
 */

public static final java.lang.String CONTENT_DIRECTORY = "photo";

/**
 * The directory twig for retrieving the full-size display photo.
 * @apiSince 14
 */

public static final java.lang.String DISPLAY_PHOTO = "display_photo";

/**
 * Thumbnail photo of the raw contact. This is the raw bytes of an image
 * that could be inflated using {@link android.graphics.BitmapFactory}.
 * <p>
 * Type: BLOB
 * @apiSince 11
 */

public static final java.lang.String PHOTO = "data15";

/**
 * Full-size photo file ID of the raw contact.
 * See {@link android.provider.ContactsContract.DisplayPhoto ContactsContract.DisplayPhoto}.
 * <p>
 * Type: NUMBER
 * @apiSince 14
 */

public static final java.lang.String PHOTO_FILE_ID = "data14";
}

}

/**
 * Columns of {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts} that refer to intrinsic
 * properties of the contact, as opposed to the user-specified options
 * found in {@link android.provider.ContactsContract.ContactOptionsColumns ContactOptionsColumns}.
 *
 * @see android.provider.ContactsContract.Contacts
 * @see android.provider.ContactsContract.Data
 * @see android.provider.ContactsContract.PhoneLookup
 * @see android.provider.ContactsContract.Contacts.AggregationSuggestions
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface ContactsColumns {

/**
 * Timestamp (milliseconds since epoch) of when this contact was last updated.  This
 * includes updates to all data associated with this contact including raw contacts.  Any
 * modification (including deletes and inserts) of underlying contact data are also
 * reflected in this timestamp.
 * @apiSince 18
 */

public static final java.lang.String CONTACT_LAST_UPDATED_TIMESTAMP = "contact_last_updated_timestamp";

/**
 * The display name for the contact.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String DISPLAY_NAME = "display_name";

/**
 * An indicator of whether this contact has at least one phone number. "1" if there is
 * at least one phone number, "0" otherwise.
 * <P>Type: INTEGER</P>
 * @apiSince 5
 */

public static final java.lang.String HAS_PHONE_NUMBER = "has_phone_number";

/**
 * Flag that reflects whether the contact exists inside the default directory.
 * Ie, whether the contact is designed to only be visible outside search.
 * @apiSince 21
 */

public static final java.lang.String IN_DEFAULT_DIRECTORY = "in_default_directory";

/**
 * Flag that reflects the {@link android.provider.ContactsContract.Groups#GROUP_VISIBLE Groups#GROUP_VISIBLE} state of any
 * {@link android.provider.ContactsContract.CommonDataKinds.GroupMembership CommonDataKinds.GroupMembership} for this contact.
 * @apiSince 5
 */

public static final java.lang.String IN_VISIBLE_GROUP = "in_visible_group";

/**
 * Flag that reflects whether this contact represents the user's
 * personal profile entry.
 * @apiSince 14
 */

public static final java.lang.String IS_USER_PROFILE = "is_user_profile";

/**
 * An opaque value that contains hints on how to find the contact if
 * its row id changed as a result of a sync or aggregation.
 * @apiSince 5
 */

public static final java.lang.String LOOKUP_KEY = "lookup";

/**
 * Reference to the row in the RawContacts table holding the contact name.
 * <P>Type: INTEGER REFERENCES raw_contacts(_id)</P>
 * @apiSince 21
 */

public static final java.lang.String NAME_RAW_CONTACT_ID = "name_raw_contact_id";

/**
 * Photo file ID of the full-size photo.  If present, this will be used to populate
 * {@link #PHOTO_URI}.  The ID can also be used with
 * {@link android.provider.ContactsContract.DisplayPhoto#CONTENT_URI ContactsContract.DisplayPhoto#CONTENT_URI} to create a URI to the photo.
 * If this is present, {@link #PHOTO_ID} is also guaranteed to be populated.
 *
 * <P>Type: INTEGER</P>
 * @apiSince 14
 */

public static final java.lang.String PHOTO_FILE_ID = "photo_file_id";

/**
 * Reference to the row in the data table holding the photo.  A photo can
 * be referred to either by ID (this field) or by URI (see {@link #PHOTO_THUMBNAIL_URI}
 * and {@link #PHOTO_URI}).
 * If PHOTO_ID is null, consult {@link #PHOTO_URI} or {@link #PHOTO_THUMBNAIL_URI},
 * which is a more generic mechanism for referencing the contact photo, especially for
 * contacts returned by non-local directories (see {@link android.provider.ContactsContract.Directory Directory}).
 *
 * <P>Type: INTEGER REFERENCES data(_id)</P>
 * @apiSince 5
 */

public static final java.lang.String PHOTO_ID = "photo_id";

/**
 * A URI that can be used to retrieve a thumbnail of the contact's photo.
 * A photo can be referred to either by a URI (this field or {@link #PHOTO_URI})
 * or by ID (see {@link #PHOTO_ID}). If PHOTO_ID is not null, PHOTO_URI and
 * PHOTO_THUMBNAIL_URI shall not be null (but not necessarily vice versa).
 * If the content provider does not differentiate between full-size photos
 * and thumbnail photos, PHOTO_THUMBNAIL_URI and {@link #PHOTO_URI} can contain
 * the same value, but either both shall be null or both not null.
 *
 * <P>Type: TEXT</P>
 * @apiSince 11
 */

public static final java.lang.String PHOTO_THUMBNAIL_URI = "photo_thumb_uri";

/**
 * A URI that can be used to retrieve the contact's full-size photo.
 * If PHOTO_FILE_ID is not null, this will be populated with a URI based off
 * {@link android.provider.ContactsContract.DisplayPhoto#CONTENT_URI ContactsContract.DisplayPhoto#CONTENT_URI}.  Otherwise, this will
 * be populated with the same value as {@link #PHOTO_THUMBNAIL_URI}.
 * A photo can be referred to either by a URI (this field) or by ID
 * (see {@link #PHOTO_ID}). If either PHOTO_FILE_ID or PHOTO_ID is not null,
 * PHOTO_URI and PHOTO_THUMBNAIL_URI shall not be null (but not necessarily
 * vice versa).  Thus using PHOTO_URI is a more robust method of retrieving
 * contact photos.
 *
 * <P>Type: TEXT</P>
 * @apiSince 11
 */

public static final java.lang.String PHOTO_URI = "photo_uri";
}

/**
 * <p>
 * Constants for the data table, which contains data points tied to a raw
 * contact.  Each row of the data table is typically used to store a single
 * piece of contact
 * information (such as a phone number) and its
 * associated metadata (such as whether it is a work or home number).
 * </p>
 * <h3>Data kinds</h3>
 * <p>
 * Data is a generic table that can hold any kind of contact data.
 * The kind of data stored in a given row is specified by the row's
 * {@link #MIMETYPE} value, which determines the meaning of the
 * generic columns {@link #DATA1} through
 * {@link #DATA15}.
 * For example, if the data kind is
 * {@link android.provider.ContactsContract.CommonDataKinds.Phone CommonDataKinds.Phone}, then the column
 * {@link #DATA1} stores the
 * phone number, but if the data kind is
 * {@link android.provider.ContactsContract.CommonDataKinds.Email CommonDataKinds.Email}, then {@link #DATA1}
 * stores the email address.
 * Sync adapters and applications can introduce their own data kinds.
 * </p>
 * <p>
 * ContactsContract defines a small number of pre-defined data kinds, e.g.
 * {@link android.provider.ContactsContract.CommonDataKinds.Phone CommonDataKinds.Phone}, {@link android.provider.ContactsContract.CommonDataKinds.Email CommonDataKinds.Email} etc. As a
 * convenience, these classes define data kind specific aliases for DATA1 etc.
 * For example, {@link android.provider.ContactsContract.CommonDataKinds.Phone CommonDataKinds.Phone} is the same as
 * {@link android.provider.ContactsContract.Data ContactsContract.Data}.
 * </p>
 * <p>
 * {@link #DATA1} is an indexed column and should be used for the data element that is
 * expected to be most frequently used in query selections. For example, in the
 * case of a row representing email addresses {@link #DATA1} should probably
 * be used for the email address itself, while {@link #DATA2} etc can be
 * used for auxiliary information like type of email address.
 * <p>
 * <p>
 * By convention, {@link #DATA15} is used for storing BLOBs (binary data).
 * </p>
 * <p>
 * The sync adapter for a given account type must correctly handle every data type
 * used in the corresponding raw contacts.  Otherwise it could result in lost or
 * corrupted data.
 * </p>
 * <p>
 * Similarly, you should refrain from introducing new kinds of data for an other
 * party's account types. For example, if you add a data row for
 * "favorite song" to a raw contact owned by a Google account, it will not
 * get synced to the server, because the Google sync adapter does not know
 * how to handle this data kind. Thus new data kinds are typically
 * introduced along with new account types, i.e. new sync adapters.
 * </p>
 * <h3>Batch operations</h3>
 * <p>
 * Data rows can be inserted/updated/deleted using the traditional
 * {@link android.content.ContentResolver#insert ContentResolver#insert}, {@link android.content.ContentResolver#update ContentResolver#update} and
 * {@link android.content.ContentResolver#delete ContentResolver#delete} methods, however the newer mechanism based
 * on a batch of {@link android.content.ContentProviderOperation ContentProviderOperation} will prove to be a better
 * choice in almost all cases. All operations in a batch are executed in a
 * single transaction, which ensures that the phone-side and server-side
 * state of a raw contact are always consistent. Also, the batch-based
 * approach is far more efficient: not only are the database operations
 * faster when executed in a single transaction, but also sending a batch of
 * commands to the content provider saves a lot of time on context switching
 * between your process and the process in which the content provider runs.
 * </p>
 * <p>
 * The flip side of using batched operations is that a large batch may lock
 * up the database for a long time preventing other applications from
 * accessing data and potentially causing ANRs ("Application Not Responding"
 * dialogs.)
 * </p>
 * <p>
 * To avoid such lockups of the database, make sure to insert "yield points"
 * in the batch. A yield point indicates to the content provider that before
 * executing the next operation it can commit the changes that have already
 * been made, yield to other requests, open another transaction and continue
 * processing operations. A yield point will not automatically commit the
 * transaction, but only if there is another request waiting on the
 * database. Normally a sync adapter should insert a yield point at the
 * beginning of each raw contact operation sequence in the batch. See
 * {@link android.content.ContentProviderOperation.Builder#withYieldAllowed(boolean) ContentProviderOperation.Builder#withYieldAllowed(boolean)}.
 * </p>
 * <h3>Operations</h3>
 * <dl>
 * <dt><b>Insert</b></dt>
 * <dd>
 * <p>
 * An individual data row can be inserted using the traditional
 * {@link android.content.ContentResolver#insert(android.net.Uri,android.content.ContentValues) ContentResolver#insert(Uri, ContentValues)} method. Multiple rows
 * should always be inserted as a batch.
 * </p>
 * <p>
 * An example of a traditional insert:
 * <pre>
 * ContentValues values = new ContentValues();
 * values.put(Data.RAW_CONTACT_ID, rawContactId);
 * values.put(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
 * values.put(Phone.NUMBER, "1-800-GOOG-411");
 * values.put(Phone.TYPE, Phone.TYPE_CUSTOM);
 * values.put(Phone.LABEL, "free directory assistance");
 * Uri dataUri = getContentResolver().insert(Data.CONTENT_URI, values);
 * </pre>
 * <p>
 * The same done using ContentProviderOperations:
 * <pre>
 * ArrayList&lt;ContentProviderOperation&gt; ops =
 *          new ArrayList&lt;ContentProviderOperation&gt;();
 *
 * ops.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
 *          .withValue(Data.RAW_CONTACT_ID, rawContactId)
 *          .withValue(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE)
 *          .withValue(Phone.NUMBER, "1-800-GOOG-411")
 *          .withValue(Phone.TYPE, Phone.TYPE_CUSTOM)
 *          .withValue(Phone.LABEL, "free directory assistance")
 *          .build());
 * getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
 * </pre>
 * </p>
 * <dt><b>Update</b></dt>
 * <dd>
 * <p>
 * Just as with insert, update can be done incrementally or as a batch,
 * the batch mode being the preferred method:
 * <pre>
 * ArrayList&lt;ContentProviderOperation&gt; ops =
 *          new ArrayList&lt;ContentProviderOperation&gt;();
 *
 * ops.add(ContentProviderOperation.newUpdate(Data.CONTENT_URI)
 *          .withSelection(Data._ID + "=?", new String[]{String.valueOf(dataId)})
 *          .withValue(Email.DATA, "somebody@android.com")
 *          .build());
 * getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
 * </pre>
 * </p>
 * </dd>
 * <dt><b>Delete</b></dt>
 * <dd>
 * <p>
 * Just as with insert and update, deletion can be done either using the
 * {@link android.content.ContentResolver#delete ContentResolver#delete} method or using a ContentProviderOperation:
 * <pre>
 * ArrayList&lt;ContentProviderOperation&gt; ops =
 *          new ArrayList&lt;ContentProviderOperation&gt;();
 *
 * ops.add(ContentProviderOperation.newDelete(Data.CONTENT_URI)
 *          .withSelection(Data._ID + "=?", new String[]{String.valueOf(dataId)})
 *          .build());
 * getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
 * </pre>
 * </p>
 * </dd>
 * <dt><b>Query</b></dt>
 * <dd>
 * <p>
 * <dl>
 * <dt>Finding all Data of a given type for a given contact</dt>
 * <dd>
 * <pre>
 * Cursor c = getContentResolver().query(Data.CONTENT_URI,
 *          new String[] {Data._ID, Phone.NUMBER, Phone.TYPE, Phone.LABEL},
 *          Data.CONTACT_ID + &quot;=?&quot; + " AND "
 *                  + Data.MIMETYPE + "='" + Phone.CONTENT_ITEM_TYPE + "'",
 *          new String[] {String.valueOf(contactId)}, null);
 * </pre>
 * </p>
 * <p>
 * </dd>
 * <dt>Finding all Data of a given type for a given raw contact</dt>
 * <dd>
 * <pre>
 * Cursor c = getContentResolver().query(Data.CONTENT_URI,
 *          new String[] {Data._ID, Phone.NUMBER, Phone.TYPE, Phone.LABEL},
 *          Data.RAW_CONTACT_ID + &quot;=?&quot; + " AND "
 *                  + Data.MIMETYPE + "='" + Phone.CONTENT_ITEM_TYPE + "'",
 *          new String[] {String.valueOf(rawContactId)}, null);
 * </pre>
 * </dd>
 * <dt>Finding all Data for a given raw contact</dt>
 * <dd>
 * Most sync adapters will want to read all data rows for a raw contact
 * along with the raw contact itself.  For that you should use the
 * {@link android.provider.ContactsContract.RawContactsEntity RawContactsEntity}. See also {@link android.provider.ContactsContract.RawContacts RawContacts}.
 * </dd>
 * </dl>
 * </p>
 * </dd>
 * </dl>
 * <h2>Columns</h2>
 * <p>
 * Many columns are available via a {@link android.provider.ContactsContract.Data#CONTENT_URI Data#CONTENT_URI} query.  For best performance you
 * should explicitly specify a projection to only those columns that you need.
 * </p>
 * <table class="jd-sumtable">
 * <tr>
 * <th colspan='4'>Data</th>
 * </tr>
 * <tr>
 * <td style="width: 7em;">long</td>
 * <td style="width: 20em;">{@link #_ID}</td>
 * <td style="width: 5em;">read-only</td>
 * <td>Row ID. Sync adapter should try to preserve row IDs during updates. In other words,
 * it would be a bad idea to delete and reinsert a data row. A sync adapter should
 * always do an update instead.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #MIMETYPE}</td>
 * <td>read/write-once</td>
 * <td>
 * <p>The MIME type of the item represented by this row. Examples of common
 * MIME types are:
 * <ul>
 * <li>{@link android.provider.ContactsContract.CommonDataKinds.StructuredName CommonDataKinds.StructuredName}</li>
 * <li>{@link android.provider.ContactsContract.CommonDataKinds.Phone CommonDataKinds.Phone}</li>
 * <li>{@link android.provider.ContactsContract.CommonDataKinds.Email CommonDataKinds.Email}</li>
 * <li>{@link android.provider.ContactsContract.CommonDataKinds.Photo CommonDataKinds.Photo}</li>
 * <li>{@link android.provider.ContactsContract.CommonDataKinds.Organization CommonDataKinds.Organization}</li>
 * <li>{@link android.provider.ContactsContract.CommonDataKinds.Im CommonDataKinds.Im}</li>
 * <li>{@link android.provider.ContactsContract.CommonDataKinds.Nickname CommonDataKinds.Nickname}</li>
 * <li>{@link android.provider.ContactsContract.CommonDataKinds.Note CommonDataKinds.Note}</li>
 * <li>{@link android.provider.ContactsContract.CommonDataKinds.StructuredPostal CommonDataKinds.StructuredPostal}</li>
 * <li>{@link android.provider.ContactsContract.CommonDataKinds.GroupMembership CommonDataKinds.GroupMembership}</li>
 * <li>{@link android.provider.ContactsContract.CommonDataKinds.Website CommonDataKinds.Website}</li>
 * <li>{@link android.provider.ContactsContract.CommonDataKinds.Event CommonDataKinds.Event}</li>
 * <li>{@link android.provider.ContactsContract.CommonDataKinds.Relation CommonDataKinds.Relation}</li>
 * <li>{@link android.provider.ContactsContract.CommonDataKinds.SipAddress CommonDataKinds.SipAddress}</li>
 * </ul>
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #RAW_CONTACT_ID}</td>
 * <td>read/write-once</td>
 * <td>The id of the row in the {@link android.provider.ContactsContract.RawContacts RawContacts} table that this data belongs to.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #IS_PRIMARY}</td>
 * <td>read/write</td>
 * <td>Whether this is the primary entry of its kind for the raw contact it belongs to.
 * "1" if true, "0" if false.
 * </td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #IS_SUPER_PRIMARY}</td>
 * <td>read/write</td>
 * <td>Whether this is the primary entry of its kind for the aggregate
 * contact it belongs to. Any data record that is "super primary" must
 * also be "primary".  For example, the super-primary entry may be
 * interpreted as the default contact value of its kind (for example,
 * the default phone number to use for the contact).</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #DATA_VERSION}</td>
 * <td>read-only</td>
 * <td>The version of this data record. Whenever the data row changes
 * the version goes up. This value is monotonically increasing.</td>
 * </tr>
 * <tr>
 * <td>Any type</td>
 * <td>
 * {@link #DATA1}<br>
 * {@link #DATA2}<br>
 * {@link #DATA3}<br>
 * {@link #DATA4}<br>
 * {@link #DATA5}<br>
 * {@link #DATA6}<br>
 * {@link #DATA7}<br>
 * {@link #DATA8}<br>
 * {@link #DATA9}<br>
 * {@link #DATA10}<br>
 * {@link #DATA11}<br>
 * {@link #DATA12}<br>
 * {@link #DATA13}<br>
 * {@link #DATA14}<br>
 * {@link #DATA15}
 * </td>
 * <td>read/write</td>
 * <td>
 * <p>
 * Generic data columns.  The meaning of each column is determined by the
 * {@link #MIMETYPE}.  By convention, {@link #DATA15} is used for storing
 * BLOBs (binary data).
 * </p>
 * <p>
 * Data columns whose meaning is not explicitly defined for a given MIMETYPE
 * should not be used.  There is no guarantee that any sync adapter will
 * preserve them.  Sync adapters themselves should not use such columns either,
 * but should instead use {@link #SYNC1}-{@link #SYNC4}.
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>Any type</td>
 * <td>
 * {@link #SYNC1}<br>
 * {@link #SYNC2}<br>
 * {@link #SYNC3}<br>
 * {@link #SYNC4}
 * </td>
 * <td>read/write</td>
 * <td>Generic columns for use by sync adapters. For example, a Photo row
 * may store the image URL in SYNC1, a status (not loaded, loading, loaded, error)
 * in SYNC2, server-side version number in SYNC3 and error code in SYNC4.</td>
 * </tr>
 * </table>
 *
 * <p>
 * Some columns from the most recent associated status update are also available
 * through an implicit join.
 * </p>
 * <table class="jd-sumtable">
 * <tr>
 * <th colspan='4'>Join with {@link android.provider.ContactsContract.StatusUpdates StatusUpdates}</th>
 * </tr>
 * <tr>
 * <td style="width: 7em;">int</td>
 * <td style="width: 20em;">{@link #PRESENCE}</td>
 * <td style="width: 5em;">read-only</td>
 * <td>IM presence status linked to this data row. Compare with
 * {@link #CONTACT_PRESENCE}, which contains the contact's presence across
 * all IM rows. See {@link android.provider.ContactsContract.StatusUpdates StatusUpdates} for individual status definitions.
 * The provider may choose not to store this value
 * in persistent storage. The expectation is that presence status will be
 * updated on a regular basis.
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #STATUS}</td>
 * <td>read-only</td>
 * <td>Latest status update linked with this data row.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #STATUS_TIMESTAMP}</td>
 * <td>read-only</td>
 * <td>The absolute time in milliseconds when the latest status was
 * inserted/updated for this data row.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #STATUS_RES_PACKAGE}</td>
 * <td>read-only</td>
 * <td>The package containing resources for this status: label and icon.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #STATUS_LABEL}</td>
 * <td>read-only</td>
 * <td>The resource ID of the label describing the source of status update linked
 * to this data row. This resource is scoped by the {@link #STATUS_RES_PACKAGE}.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #STATUS_ICON}</td>
 * <td>read-only</td>
 * <td>The resource ID of the icon for the source of the status update linked
 * to this data row. This resource is scoped by the {@link #STATUS_RES_PACKAGE}.</td>
 * </tr>
 * </table>
 *
 * <p>
 * Some columns from the associated raw contact are also available through an
 * implicit join.  The other columns are excluded as uninteresting in this
 * context.
 * </p>
 *
 * <table class="jd-sumtable">
 * <tr>
 * <th colspan='4'>Join with {@link android.provider.ContactsContract.RawContacts ContactsContract.RawContacts}</th>
 * </tr>
 * <tr>
 * <td style="width: 7em;">long</td>
 * <td style="width: 20em;">{@link #CONTACT_ID}</td>
 * <td style="width: 5em;">read-only</td>
 * <td>The id of the row in the {@link android.provider.ContactsContract.Contacts Contacts} table that this data belongs
 * to.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #AGGREGATION_MODE}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.RawContacts RawContacts}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #DELETED}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.RawContacts RawContacts}.</td>
 * </tr>
 * </table>
 *
 * <p>
 * The ID column for the associated aggregated contact table
 * {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts} is available
 * via the implicit join to the {@link android.provider.ContactsContract.RawContacts RawContacts} table, see above.
 * The remaining columns from this table are also
 * available, through an implicit join.  This
 * facilitates lookup by
 * the value of a single data element, such as the email address.
 * </p>
 *
 * <table class="jd-sumtable">
 * <tr>
 * <th colspan='4'>Join with {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}</th>
 * </tr>
 * <tr>
 * <td style="width: 7em;">String</td>
 * <td style="width: 20em;">{@link #LOOKUP_KEY}</td>
 * <td style="width: 5em;">read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #DISPLAY_NAME}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #PHOTO_ID}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #IN_VISIBLE_GROUP}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #HAS_PHONE_NUMBER}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #STARRED}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #CUSTOM_RINGTONE}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #SEND_TO_VOICEMAIL}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #CONTACT_PRESENCE}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #CONTACT_STATUS}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #CONTACT_STATUS_TIMESTAMP}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #CONTACT_STATUS_RES_PACKAGE}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #CONTACT_STATUS_LABEL}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #CONTACT_STATUS_ICON}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Data implements android.provider.ContactsContract.DataColumnsWithJoins {

private Data() { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Build a {@link android.provider.ContactsContract.Contacts#CONTENT_LOOKUP_URI}
 * style {@link android.net.Uri Uri} for the parent {@link android.provider.ContactsContract.Contacts}
 * entry of the given {@link android.provider.ContactsContract.Data ContactsContract.Data} entry.
 * </p>
 * <p>
 * Returns the Uri for the contact in the first entry returned by
 * {@link android.content.ContentResolver#query(android.net.Uri,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String) ContentResolver#query(Uri, String[], String, String[], String)}
 * for the provided {@code dataUri}.  If the query returns null or empty
 * results, silently returns null.
 * </p>
 * @apiSince 5
 */

public static android.net.Uri getContactLookupUri(android.content.ContentResolver resolver, android.net.Uri dataUri) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type of the results from {@link #CONTENT_URI}.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/data";

/**
 * The content:// style URI for this table, which requests a directory
 * of data rows matching the selection criteria.
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * Add this query parameter to a URI to get back row counts grouped by the address book
 * index as cursor extras. For most languages it is the first letter of the sort key. This
 * parameter does not affect the main content of the cursor.
 *
 * <p>
 * <pre>
 * Example:
 *
 * import android.provider.ContactsContract.Contacts;
 *
 * Uri uri = Contacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(Contacts.EXTRA_ADDRESS_BOOK_INDEX, "true")
 *          .build();
 * Cursor cursor = getContentResolver().query(uri,
 *          new String[] {Contacts.DISPLAY_NAME},
 *          null, null, null);
 * Bundle bundle = cursor.getExtras();
 * if (bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES) &&
 *         bundle.containsKey(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS)) {
 *     String sections[] =
 *             bundle.getStringArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_TITLES);
 *     int counts[] = bundle.getIntArray(Contacts.EXTRA_ADDRESS_BOOK_INDEX_COUNTS);
 * }
 * </pre>
 * </p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";

/**
 * The array of group counts for the corresponding group.  Contains the same number
 * of elements as the EXTRA_ADDRESS_BOOK_INDEX_TITLES array.
 * <p>TYPE: int[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";

/**
 * The array of address book index titles, which are returned in the
 * same order as the data in the cursor.
 * <p>TYPE: String[]</p>
 */

public static final java.lang.String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";

/**
 * A boolean parameter for {@link android.provider.ContactsContract.Data#CONTENT_URI Data#CONTENT_URI}.
 * This specifies whether or not the returned data items should be filtered to show
 * data items belonging to visible contacts only.
 * @apiSince 18
 */

public static final java.lang.String VISIBLE_CONTACTS_ONLY = "visible_contacts_only";
}

/**
 * Columns in the Data table.
 *
 * @see android.provider.ContactsContract.Data
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface DataColumns {

/**
 * Carrier presence information.
 * <P>
 * Type: INTEGER (A bitmask of CARRIER_PRESENCE_* fields)
 * </P>
 * @apiSince 23
 */

public static final java.lang.String CARRIER_PRESENCE = "carrier_presence";

/**
 * Indicates that the entry is Video Telephony (VT) capable on the
 * current carrier. An allowed bitmask of {@link #CARRIER_PRESENCE}.
 * @apiSince 23
 */

public static final int CARRIER_PRESENCE_VT_CAPABLE = 1; // 0x1

/**
 * Generic data column, the meaning is {@link #MIMETYPE} specific
 * @apiSince 5
 */

public static final java.lang.String DATA1 = "data1";

/**
 * Generic data column, the meaning is {@link #MIMETYPE} specific
 * @apiSince 5
 */

public static final java.lang.String DATA10 = "data10";

/**
 * Generic data column, the meaning is {@link #MIMETYPE} specific
 * @apiSince 5
 */

public static final java.lang.String DATA11 = "data11";

/**
 * Generic data column, the meaning is {@link #MIMETYPE} specific
 * @apiSince 5
 */

public static final java.lang.String DATA12 = "data12";

/**
 * Generic data column, the meaning is {@link #MIMETYPE} specific
 * @apiSince 5
 */

public static final java.lang.String DATA13 = "data13";

/**
 * Generic data column, the meaning is {@link #MIMETYPE} specific
 * @apiSince 5
 */

public static final java.lang.String DATA14 = "data14";

/**
 * Generic data column, the meaning is {@link #MIMETYPE} specific. By convention,
 * this field is used to store BLOBs (binary data).
 * @apiSince 5
 */

public static final java.lang.String DATA15 = "data15";

/**
 * Generic data column, the meaning is {@link #MIMETYPE} specific
 * @apiSince 5
 */

public static final java.lang.String DATA2 = "data2";

/**
 * Generic data column, the meaning is {@link #MIMETYPE} specific
 * @apiSince 5
 */

public static final java.lang.String DATA3 = "data3";

/**
 * Generic data column, the meaning is {@link #MIMETYPE} specific
 * @apiSince 5
 */

public static final java.lang.String DATA4 = "data4";

/**
 * Generic data column, the meaning is {@link #MIMETYPE} specific
 * @apiSince 5
 */

public static final java.lang.String DATA5 = "data5";

/**
 * Generic data column, the meaning is {@link #MIMETYPE} specific
 * @apiSince 5
 */

public static final java.lang.String DATA6 = "data6";

/**
 * Generic data column, the meaning is {@link #MIMETYPE} specific
 * @apiSince 5
 */

public static final java.lang.String DATA7 = "data7";

/**
 * Generic data column, the meaning is {@link #MIMETYPE} specific
 * @apiSince 5
 */

public static final java.lang.String DATA8 = "data8";

/**
 * Generic data column, the meaning is {@link #MIMETYPE} specific
 * @apiSince 5
 */

public static final java.lang.String DATA9 = "data9";

/**
 * The version of this data record. This is a read-only value. The data column is
 * guaranteed to not change without the version going up. This value is monotonically
 * increasing.
 * <P>Type: INTEGER</P>
 * @apiSince 5
 */

public static final java.lang.String DATA_VERSION = "data_version";

/**
 * Whether this is the primary entry of its kind for the raw contact it belongs to.
 * <P>Type: INTEGER (if set, non-0 means true)</P>
 * @apiSince 5
 */

public static final java.lang.String IS_PRIMARY = "is_primary";

/**
 * The "read-only" flag: "0" by default, "1" if the row cannot be modified or
 * deleted except by a sync adapter.  See {@link android.provider.ContactsContract#CALLER_IS_SYNCADAPTER ContactsContract#CALLER_IS_SYNCADAPTER}.
 * <P>Type: INTEGER</P>
 * @apiSince 11
 */

public static final java.lang.String IS_READ_ONLY = "is_read_only";

/**
 * Whether this is the primary entry of its kind for the aggregate
 * contact it belongs to. Any data record that is "super primary" must
 * also be "primary".
 * <P>Type: INTEGER (if set, non-0 means true)</P>
 * @apiSince 5
 */

public static final java.lang.String IS_SUPER_PRIMARY = "is_super_primary";

/**
 * The MIME type of the item represented by this row.
 * @apiSince 5
 */

public static final java.lang.String MIMETYPE = "mimetype";

/**
 * The flattened {@link android.content.ComponentName} of a  {@link
 * android.telecom.PhoneAccountHandle} that is the preferred {@code PhoneAccountHandle} to
 * call the contact with.
 *
 * <p> On a multi-SIM device this field can be used in a {@link android.provider.ContactsContract.CommonDataKinds.Phone CommonDataKinds.Phone} row
 * to indicate the {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} to call the number with, instead of using
 * {@link android.telecom.TelecomManager#getDefaultOutgoingPhoneAccount(String)} or asking
 * every time.
 *
 * <p>{@link android.telecom.TelecomManager#placeCall(Uri, android.os.Bundle)}
 * should be called with {@link android.telecom.TelecomManager#EXTRA_PHONE_ACCOUNT_HANDLE}
 * set to the {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} using the {@link android.content.ComponentName ComponentName} from this field.
 *
 * @see #PREFERRED_PHONE_ACCOUNT_ID
 * @see android.telecom.PhoneAccountHandle#getComponentName()
 * @see android.content.ComponentName#flattenToString()
 * @apiSince 28
 */

public static final java.lang.String PREFERRED_PHONE_ACCOUNT_COMPONENT_NAME = "preferred_phone_account_component_name";

/**
 * The ID of a {@link
 * android.telecom.PhoneAccountHandle} that is the preferred {@code PhoneAccountHandle} to
 * call the contact with. Used by {@link android.provider.ContactsContract.CommonDataKinds.Phone CommonDataKinds.Phone}.
 *
 * <p> On a multi-SIM device this field can be used in a {@link android.provider.ContactsContract.CommonDataKinds.Phone CommonDataKinds.Phone} row
 * to indicate the {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} to call the number with, instead of using
 * {@link android.telecom.TelecomManager#getDefaultOutgoingPhoneAccount(String)} or asking
 * every time.
 *
 * <p>{@link android.telecom.TelecomManager#placeCall(Uri, android.os.Bundle)}
 * should be called with {@link android.telecom.TelecomManager#EXTRA_PHONE_ACCOUNT_HANDLE}
 * set to the {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} using the id from this field.
 *
 * @see #PREFERRED_PHONE_ACCOUNT_COMPONENT_NAME
 * @see android.telecom.PhoneAccountHandle#getId()
 * @apiSince 28
 */

public static final java.lang.String PREFERRED_PHONE_ACCOUNT_ID = "preferred_phone_account_id";

/**
 * A reference to the {@link android.provider.ContactsContract.RawContacts#_ID RawContacts#_ID}
 * that this data belongs to.
 * @apiSince 5
 */

public static final java.lang.String RAW_CONTACT_ID = "raw_contact_id";

/**
 * The package name to use when creating {@link android.content.res.Resources Resources} objects for
 * this data row. This value is only designed for use when building user
 * interfaces, and should not be used to infer the owner.
 * @apiSince 21
 */

public static final java.lang.String RES_PACKAGE = "res_package";

/**
 * Generic column for use by sync adapters.
 * @apiSince 5
 */

public static final java.lang.String SYNC1 = "data_sync1";

/**
 * Generic column for use by sync adapters.
 * @apiSince 5
 */

public static final java.lang.String SYNC2 = "data_sync2";

/**
 * Generic column for use by sync adapters.
 * @apiSince 5
 */

public static final java.lang.String SYNC3 = "data_sync3";

/**
 * Generic column for use by sync adapters.
 * @apiSince 5
 */

public static final java.lang.String SYNC4 = "data_sync4";
}

/**
 * Combines all columns returned by {@link android.provider.ContactsContract.Data ContactsContract.Data} table queries.
 *
 * @see android.provider.ContactsContract.Data
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface DataColumnsWithJoins extends android.provider.BaseColumns,  android.provider.ContactsContract.DataColumns, android.provider.ContactsContract.StatusColumns, android.provider.ContactsContract.RawContactsColumns, android.provider.ContactsContract.ContactsColumns, android.provider.ContactsContract.ContactNameColumns, android.provider.ContactsContract.ContactOptionsColumns, android.provider.ContactsContract.ContactStatusColumns, android.provider.ContactsContract.DataUsageStatColumns {
}

/**
 * <p>
 * API allowing applications to send usage information for each {@link android.provider.ContactsContract.Data Data} row to the
 * Contacts Provider.  Applications can also clear all usage information.
 * </p>
 * <p class="caution"><b>Caution: </b>If you publish your app to the Google Play Store,
 * this field is obsolete, regardless of Android version. For more information, see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.</p>
 * <p>
 * With the feedback, Contacts Provider may return more contextually appropriate results for
 * Data listing, typically supplied with
 * {@link android.provider.ContactsContract.Contacts#CONTENT_FILTER_URI ContactsContract.Contacts#CONTENT_FILTER_URI},
 * {@link android.provider.ContactsContract.CommonDataKinds.Email#CONTENT_FILTER_URI ContactsContract.CommonDataKinds.Email#CONTENT_FILTER_URI},
 * {@link android.provider.ContactsContract.CommonDataKinds.Phone#CONTENT_FILTER_URI ContactsContract.CommonDataKinds.Phone#CONTENT_FILTER_URI}, and users can benefit
 * from better ranked (sorted) lists in applications that show auto-complete list.
 * </p>
 * <p>
 * There is no guarantee for how this feedback is used, or even whether it is used at all.
 * The ranking algorithm will make best efforts to use the feedback data, but the exact
 * implementation, the storage data structures as well as the resulting sort order is device
 * and version specific and can change over time.
 * </p>
 * <p>
 * When updating usage information, users of this API need to use
 * {@link android.content.ContentResolver#update(android.net.Uri,android.content.ContentValues,java.lang.String,java.lang.String[]) ContentResolver#update(Uri, ContentValues, String, String[])} with a Uri constructed
 * from {@link android.provider.ContactsContract.DataUsageFeedback#FEEDBACK_URI DataUsageFeedback#FEEDBACK_URI}. The Uri must contain one or more data id(s) as
 * its last path. They also need to append a query parameter to the Uri, to specify the type of
 * the communication, which enables the Contacts Provider to differentiate between kinds of
 * interactions using the same contact data field (for example a phone number can be used to
 * make phone calls or send SMS).
 * </p>
 * <p>
 * Selection and selectionArgs are ignored and must be set to null. To get data ids,
 * you may need to call {@link android.content.ContentResolver#query(android.net.Uri,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String) ContentResolver#query(Uri, String[], String, String[], String)}
 * toward {@link android.provider.ContactsContract.Data#CONTENT_URI Data#CONTENT_URI}.
 * </p>
 * <p>
 * {@link android.content.ContentResolver#update(android.net.Uri,android.content.ContentValues,java.lang.String,java.lang.String[]) ContentResolver#update(Uri, ContentValues, String, String[])} returns a positive
 * integer when successful, and returns 0 if no contact with that id was found.
 * </p>
 * <p>
 * Example:
 * <pre>
 * Uri uri = DataUsageFeedback.FEEDBACK_URI.buildUpon()
 *         .appendPath(TextUtils.join(",", dataIds))
 *         .appendQueryParameter(DataUsageFeedback.USAGE_TYPE,
 *                 DataUsageFeedback.USAGE_TYPE_CALL)
 *         .build();
 * boolean successful = resolver.update(uri, new ContentValues(), null, null) > 0;
 * </pre>
 * </p>
 * <p>
 * Applications can also clear all usage information with:
 * <pre>
 * boolean successful = resolver.delete(DataUsageFeedback.DELETE_USAGE_URI, null, null) > 0;
 * </pre>
 * </p>
 *
 * @deprecated Contacts affinity information is no longer supported as of
 * Android version {@link android.os.Build.VERSION_CODES#Q}.
 * Both update and delete calls are always ignored.
 * @apiSince 14
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class DataUsageFeedback {

@Deprecated
public DataUsageFeedback() { throw new RuntimeException("Stub!"); }

/**
 * The content:// style URI for deleting all usage information.
 * Must be used with {@link android.content.ContentResolver#delete(android.net.Uri,java.lang.String,java.lang.String[]) ContentResolver#delete(Uri, String, String[])}.
 * The {@code where} and {@code selectionArgs} parameters are ignored.
 * @apiSince 16
 * @deprecatedSince 29
 */

@Deprecated public static final android.net.Uri DELETE_USAGE_URI;
static { DELETE_USAGE_URI = null; }

/**
 * The content:// style URI for sending usage feedback.
 * Must be used with {@link android.content.ContentResolver#update(android.net.Uri,android.content.ContentValues,java.lang.String,java.lang.String[]) ContentResolver#update(Uri, ContentValues, String, String[])}.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated public static final android.net.Uri FEEDBACK_URI;
static { FEEDBACK_URI = null; }

/**
 * <p>
 * Name for query parameter specifying the type of data usage.
 * </p>
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String USAGE_TYPE = "type";

/**
 * <p>
 * Type of usage for voice interaction, which includes phone call, voice chat, and
 * video chat.
 * </p>
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String USAGE_TYPE_CALL = "call";

/**
 * <p>
 * Type of usage for text interaction involving longer messages, which includes email.
 * </p>
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String USAGE_TYPE_LONG_TEXT = "long_text";

/**
 * <p>
 * Type of usage for text interaction involving shorter messages, which includes SMS,
 * text chat with email addresses.
 * </p>
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String USAGE_TYPE_SHORT_TEXT = "short_text";
}

/**
 * Columns in the Data_Usage_Stat table
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface DataUsageStatColumns {

/**
 * The last time (in milliseconds) this {@link android.provider.ContactsContract.Data Data} was used.
 * @deprecated Contacts affinity information is no longer supported as of
 * Android version {@link android.os.Build.VERSION_CODES#Q}.
 * This column always contains 0.
 *
 * <p class="caution"><b>Caution: </b>If you publish your app to the Google Play Store,
 * this field is obsolete, regardless of Android version. For more information, see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.</p>
 * @apiSince 18
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String LAST_TIME_USED = "last_time_used";

/**
 * The number of times the referenced {@link android.provider.ContactsContract.Data Data} has been used.
 * @deprecated Contacts affinity information is no longer supported as of
 * Android version {@link android.os.Build.VERSION_CODES#Q}.
 * This column always contains 0.
 *
 * <p class="caution"><b>Caution: </b>If you publish your app to the Google Play Store,
 * this field is obsolete, regardless of Android version. For more information, see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.</p>
 * @apiSince 18
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String TIMES_USED = "times_used";
}

/**
 * Constants for the deleted contact table.  This table holds a log of deleted contacts.
 * <p>
 * Log older than {@link #DAYS_KEPT_MILLISECONDS} may be deleted.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class DeletedContacts implements android.provider.ContactsContract.DeletedContactsColumns {

private DeletedContacts() { throw new RuntimeException("Stub!"); }

/**
 * The content:// style URI for this table, which requests a directory of raw contact rows
 * matching the selection criteria.
 * @apiSince 18
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * Milliseconds that the delete log will be kept.  After this time, delete records may be
 * deleted.
 * @apiSince 18
 */

public static final long DAYS_KEPT_MILLISECONDS = 2592000000L; // 0x9a7ec800L
}

/** @apiSince 18 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface DeletedContactsColumns {

/**
 * Time (milliseconds since epoch) that the contact was deleted.
 * @apiSince 18
 */

public static final java.lang.String CONTACT_DELETED_TIMESTAMP = "contact_deleted_timestamp";

/**
 * A reference to the {@link android.provider.ContactsContract.Contacts#_ID ContactsContract.Contacts#_ID} that was deleted.
 * <P>Type: INTEGER</P>
 * @apiSince 18
 */

public static final java.lang.String CONTACT_ID = "contact_id";
}

/**
 * A Directory represents a contacts corpus, e.g.&nbsp;Local contacts,
 * Google Apps Global Address List or Corporate Global Address List.
 * <p>
 * A Directory is implemented as a content provider with its unique authority and
 * the same API as the main Contacts Provider.  However, there is no expectation that
 * every directory provider will implement this Contract in its entirety.  If a
 * directory provider does not have an implementation for a specific request, it
 * should throw an UnsupportedOperationException.
 * </p>
 * <p>
 * The most important use case for Directories is search.  A Directory provider is
 * expected to support at least {@link android.provider.ContactsContract.Contacts#CONTENT_FILTER_URI ContactsContract.Contacts#CONTENT_FILTER_URI}.  If a Directory provider wants to participate
 * in email and phone lookup functionalities, it should also implement
 * {@link CommonDataKinds.Email#CONTENT_FILTER_URI CommonDataKinds.Email.CONTENT_FILTER_URI}
 * and
 * {@link CommonDataKinds.Phone#CONTENT_FILTER_URI CommonDataKinds.Phone.CONTENT_FILTER_URI}.
 * </p>
 * <p>
 * A directory provider should return NULL for every projection field it does not
 * recognize, rather than throwing an exception.  This way it will not be broken
 * if ContactsContract is extended with new fields in the future.
 * </p>
 * <p>
 * The client interacts with a directory via Contacts Provider by supplying an
 * optional {@code directory=} query parameter.
 * <p>
 * <p>
 * When the Contacts Provider receives the request, it transforms the URI and forwards
 * the request to the corresponding directory content provider.
 * The URI is transformed in the following fashion:
 * <ul>
 * <li>The URI authority is replaced with the corresponding {@link #DIRECTORY_AUTHORITY}.</li>
 * <li>The {@code accountName=} and {@code accountType=} parameters are added or
 * replaced using the corresponding {@link #ACCOUNT_TYPE} and {@link #ACCOUNT_NAME} values.</li>
 * </ul>
 * </p>
 * <p>
 * Clients should send directory requests to Contacts Provider and let it
 * forward them to the respective providers rather than constructing
 * directory provider URIs by themselves. This level of indirection allows
 * Contacts Provider to implement additional system-level features and
 * optimizations. Access to Contacts Provider is protected by the
 * READ_CONTACTS permission, but access to the directory provider is protected by
 * BIND_DIRECTORY_SEARCH. This permission was introduced at the API level 17, for previous
 * platform versions the provider should perform the following check to make sure the call
 * is coming from the ContactsProvider:
 * <pre>
 * private boolean isCallerAllowed() {
 *   PackageManager pm = getContext().getPackageManager();
 *   for (String packageName: pm.getPackagesForUid(Binder.getCallingUid())) {
 *     if (packageName.equals("com.android.providers.contacts")) {
 *       return true;
 *     }
 *   }
 *   return false;
 * }
 * </pre>
 * </p>
 * <p>
 * The Directory table is read-only and is maintained by the Contacts Provider
 * automatically.
 * </p>
 * <p>It always has at least these two rows:
 * <ul>
 * <li>
 * The local directory. It has {@link android.provider.ContactsContract.Directory#_ID Directory#_ID} =
 * {@link android.provider.ContactsContract.Directory#DEFAULT Directory#DEFAULT}. This directory can be used to access locally
 * stored contacts. The same can be achieved by omitting the {@code directory=}
 * parameter altogether.
 * </li>
 * <li>
 * The local invisible contacts. The corresponding directory ID is
 * {@link android.provider.ContactsContract.Directory#LOCAL_INVISIBLE Directory#LOCAL_INVISIBLE}.
 * </li>
 * </ul>
 * </p>
 * <p>Custom Directories are discovered by the Contacts Provider following this procedure:
 * <ul>
 * <li>It finds all installed content providers with meta data identifying them
 * as directory providers in AndroidManifest.xml:
 * <code>
 * &lt;meta-data android:name="android.content.ContactDirectory"
 *               android:value="true" /&gt;
 * </code>
 * <p>
 * This tag should be placed inside the corresponding content provider declaration.
 * </p>
 * </li>
 * <li>
 * Then Contacts Provider sends a {@link android.provider.ContactsContract.Directory#CONTENT_URI Directory#CONTENT_URI}
 * query to each of the directory authorities.  A directory provider must implement
 * this query and return a list of directories.  Each directory returned by
 * the provider must have a unique combination for the {@link #ACCOUNT_NAME} and
 * {@link #ACCOUNT_TYPE} columns (nulls are allowed).  Since directory IDs are assigned
 * automatically, the _ID field will not be part of the query projection.
 * </li>
 * <li>Contacts Provider compiles directory lists received from all directory
 * providers into one, assigns each individual directory a globally unique ID and
 * stores all directory records in the Directory table.
 * </li>
 * </ul>
 * </p>
 * <p>Contacts Provider automatically interrogates newly installed or replaced packages.
 * Thus simply installing a package containing a directory provider is sufficient
 * to have that provider registered.  A package supplying a directory provider does
 * not have to contain launchable activities.
 * </p>
 * <p>
 * Every row in the Directory table is automatically associated with the corresponding package
 * (apk).  If the package is later uninstalled, all corresponding directory rows
 * are automatically removed from the Contacts Provider.
 * </p>
 * <p>
 * When the list of directories handled by a directory provider changes
 * (for instance when the user adds a new Directory account), the directory provider
 * should call {@link #notifyDirectoryChange} to notify the Contacts Provider of the change.
 * In response, the Contacts Provider will requery the directory provider to obtain the
 * new list of directories.
 * </p>
 * <p>
 * A directory row can be optionally associated with an existing account
 * (see {@link android.accounts.AccountManager}). If the account is later removed,
 * the corresponding directory rows are automatically removed from the Contacts Provider.
 * </p>
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Directory implements android.provider.BaseColumns {

private Directory() { throw new RuntimeException("Stub!"); }

/**
 * Return TRUE if it is a remote stored directory.
 * @apiSince 24
 */

public static boolean isRemoteDirectoryId(long directoryId) { throw new RuntimeException("Stub!"); }

/**
 * Return TRUE if a directory ID is from the contacts provider on the enterprise profile.
 *
 * @apiSince 24
 */

public static boolean isEnterpriseDirectoryId(long directoryId) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the system of a change in the list of directories handled by
 * a particular directory provider. The Contacts provider will turn around
 * and send a query to the directory provider for the full list of directories,
 * which will replace the previous list.
 * @apiSince 11
 */

public static void notifyDirectoryChange(android.content.ContentResolver resolver) { throw new RuntimeException("Stub!"); }

/**
 * The account with which this directory is associated. If the account is later
 * removed, the directories it owns are automatically removed from this table.
 *
 * <p>TYPE: text</p>
 * @apiSince 11
 */

public static final java.lang.String ACCOUNT_NAME = "accountName";

/**
 * The account type which this directory is associated.
 *
 * <p>TYPE: text</p>
 * @apiSince 11
 */

public static final java.lang.String ACCOUNT_TYPE = "accountType";

/**
 * A query parameter that's passed to directory providers which indicates the client
 * package name that has made the query requests.
 * @apiSince 26
 */

public static final java.lang.String CALLER_PACKAGE_PARAM_KEY = "callerPackage";

/**
 * The MIME type of a {@link #CONTENT_URI} item.
 * @apiSince 11
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_directory";

/**
 * The MIME-type of {@link #CONTENT_URI} providing a directory of
 * contact directories.
 * @apiSince 11
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/contact_directories";

/**
 * The content:// style URI for this table.  Requests to this URI can be
 * performed on the UI thread because they are always unblocking.
 * @apiSince 11
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * _ID of the default directory, which represents locally stored contacts.
 * <b>This is only supported by {@link android.provider.ContactsContract.Contacts#CONTENT_URI ContactsContract.Contacts#CONTENT_URI} and
 * {@link android.provider.ContactsContract.Contacts#CONTENT_FILTER_URI ContactsContract.Contacts#CONTENT_FILTER_URI}.
 * Other URLs do not support the concept of "visible" or "invisible" contacts.
 * @apiSince 11
 */

public static final long DEFAULT = 0L; // 0x0L

/**
 * <p>
 * The authority of the Directory Provider. Contacts Provider will
 * use this authority to forward requests to the directory provider.
 * A directory provider can leave this column empty - Contacts Provider will fill it in.
 * </p>
 * <p>
 * Clients of this API should not send requests directly to this authority.
 * All directory requests must be routed through Contacts Provider.
 * </p>
 *
 * <p>TYPE: text</p>
 * @apiSince 11
 */

public static final java.lang.String DIRECTORY_AUTHORITY = "authority";

/**
 * An optional name that can be used in the UI to represent this directory,
 * e.g.&nbsp;"Acme Corp"
 * <p>TYPE: text</p>
 * @apiSince 11
 */

public static final java.lang.String DISPLAY_NAME = "displayName";

/**
 * URI used for getting all directories from primary and managed profile.
 * It supports the same semantics as {@link #CONTENT_URI} and returns the same columns.
 * If the device has no managed profile that is linked to the current profile, it behaves
 * in the exact same way as {@link #CONTENT_URI}.
 * If there is a managed profile linked to the current profile, it will merge
 * managed profile and current profile's results and return.
 *
 * Note: this query returns primary profile results before managed profile results,
 * and this order is not affected by sorting parameter.
 *
 * @apiSince 24
 */

public static final android.net.Uri ENTERPRISE_CONTENT_URI;
static { ENTERPRISE_CONTENT_URI = null; }

/**
 * _ID of the work profile default directory, which represents locally stored contacts.
 * @apiSince 24
 */

public static final long ENTERPRISE_DEFAULT = 1000000000L; // 0x3b9aca00L

/**
 * _ID of the work profile directory that represents locally stored invisible contacts.
 * @apiSince 24
 */

public static final long ENTERPRISE_LOCAL_INVISIBLE = 1000000001L; // 0x3b9aca01L

/**
 * One of {@link #EXPORT_SUPPORT_NONE}, {@link #EXPORT_SUPPORT_ANY_ACCOUNT},
 * {@link #EXPORT_SUPPORT_SAME_ACCOUNT_ONLY}. This is the expectation the
 * directory has for data exported from it.  Clients must obey this setting.
 * @apiSince 11
 */

public static final java.lang.String EXPORT_SUPPORT = "exportSupport";

/**
 * An {@link #EXPORT_SUPPORT} setting that indicates that the directory
 * allow its data copied to any contacts account.
 * @apiSince 11
 */

public static final int EXPORT_SUPPORT_ANY_ACCOUNT = 2; // 0x2

/**
 * An {@link #EXPORT_SUPPORT} setting that indicates that the directory
 * does not allow any data to be copied out of it.
 * @apiSince 11
 */

public static final int EXPORT_SUPPORT_NONE = 0; // 0x0

/**
 * An {@link #EXPORT_SUPPORT} setting that indicates that the directory
 * allow its data copied only to the account specified by
 * {@link #ACCOUNT_TYPE}/{@link #ACCOUNT_NAME}.
 * @apiSince 11
 */

public static final int EXPORT_SUPPORT_SAME_ACCOUNT_ONLY = 1; // 0x1

/**
 * _ID of the directory that represents locally stored invisible contacts.
 * @apiSince 11
 */

public static final long LOCAL_INVISIBLE = 1L; // 0x1L

/**
 * The name of the package that owns this directory. Contacts Provider
 * fill it in with the name of the package containing the directory provider.
 * If the package is later uninstalled, the directories it owns are
 * automatically removed from this table.
 *
 * <p>TYPE: TEXT</p>
 * @apiSince 11
 */

public static final java.lang.String PACKAGE_NAME = "packageName";

/**
 * One of {@link #PHOTO_SUPPORT_NONE}, {@link #PHOTO_SUPPORT_THUMBNAIL_ONLY},
 * {@link #PHOTO_SUPPORT_FULL}. This is a feature flag indicating the extent
 * to which the directory supports contact photos.
 * @apiSince 11
 */

public static final java.lang.String PHOTO_SUPPORT = "photoSupport";

/**
 * An {@link #PHOTO_SUPPORT} setting that indicates that the directory
 * can produce thumbnails as well as full-size contact photos.
 * @apiSince 11
 */

public static final int PHOTO_SUPPORT_FULL = 3; // 0x3

/**
 * An {@link #PHOTO_SUPPORT} setting that indicates that the directory
 * has full-size contact photos, but cannot provide scaled thumbnails.
 * @apiSince 11
 */

public static final int PHOTO_SUPPORT_FULL_SIZE_ONLY = 2; // 0x2

/**
 * An {@link #PHOTO_SUPPORT} setting that indicates that the directory
 * does not provide any photos.
 * @apiSince 11
 */

public static final int PHOTO_SUPPORT_NONE = 0; // 0x0

/**
 * An {@link #PHOTO_SUPPORT} setting that indicates that the directory
 * can only produce small size thumbnails of contact photos.
 * @apiSince 11
 */

public static final int PHOTO_SUPPORT_THUMBNAIL_ONLY = 1; // 0x1

/**
 * One of {@link #SHORTCUT_SUPPORT_NONE}, {@link #SHORTCUT_SUPPORT_DATA_ITEMS_ONLY},
 * {@link #SHORTCUT_SUPPORT_FULL}. This is the expectation the directory
 * has for shortcuts created for its elements. Clients must obey this setting.
 * @apiSince 11
 */

public static final java.lang.String SHORTCUT_SUPPORT = "shortcutSupport";

/**
 * An {@link #SHORTCUT_SUPPORT} setting that indicates that the directory
 * allow creation of shortcuts for data items like email, phone or postal address,
 * but not the entire contact.
 * @apiSince 11
 */

public static final int SHORTCUT_SUPPORT_DATA_ITEMS_ONLY = 1; // 0x1

/**
 * An {@link #SHORTCUT_SUPPORT} setting that indicates that the directory
 * allow creation of shortcuts for contact as well as their constituent elements.
 * @apiSince 11
 */

public static final int SHORTCUT_SUPPORT_FULL = 2; // 0x2

/**
 * An {@link #SHORTCUT_SUPPORT} setting that indicates that the directory
 * does not allow any shortcuts created for its contacts.
 * @apiSince 11
 */

public static final int SHORTCUT_SUPPORT_NONE = 0; // 0x0

/**
 * The type of directory captured as a resource ID in the context of the
 * package {@link #PACKAGE_NAME}, e.g.&nbsp;"Corporate Directory"
 *
 * <p>TYPE: INTEGER</p>
 * @apiSince 11
 */

public static final java.lang.String TYPE_RESOURCE_ID = "typeResourceId";
}

/**
 * Types of data used to produce the display name for a contact. In the order
 * of increasing priority: {@link #EMAIL}, {@link #PHONE},
 * {@link #ORGANIZATION}, {@link #NICKNAME}, {@link #STRUCTURED_PHONETIC_NAME},
 * {@link #STRUCTURED_NAME}.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface DisplayNameSources {

/** @apiSince 11 */

public static final int EMAIL = 10; // 0xa

/** @apiSince 11 */

public static final int NICKNAME = 35; // 0x23

/** @apiSince 11 */

public static final int ORGANIZATION = 30; // 0x1e

/** @apiSince 11 */

public static final int PHONE = 20; // 0x14

/** @apiSince 11 */

public static final int STRUCTURED_NAME = 40; // 0x28

/**
 * Display name comes from a structured name that only has phonetic components.
 * @apiSince 23
 */

public static final int STRUCTURED_PHONETIC_NAME = 37; // 0x25

/** @apiSince 11 */

public static final int UNDEFINED = 0; // 0x0
}

/**
 * Helper class for accessing full-size photos by photo file ID.
 * <p>
 * Usage example:
 * <dl>
 * <dt>Retrieving a full-size photo by photo file ID (see
 * {@link android.provider.ContactsContract.ContactsColumns#PHOTO_FILE_ID ContactsContract.ContactsColumns#PHOTO_FILE_ID})
 * </dt>
 * <dd>
 * <pre>
 * public InputStream openDisplayPhoto(long photoFileId) {
 *     Uri displayPhotoUri = ContentUris.withAppendedId(DisplayPhoto.CONTENT_URI, photoKey);
 *     try {
 *         AssetFileDescriptor fd = getContentResolver().openAssetFileDescriptor(
 *             displayPhotoUri, "r");
 *         return fd.createInputStream();
 *     } catch (IOException e) {
 *         return null;
 *     }
 * }
 * </pre>
 * </dd>
 * </dl>
 * </p>
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class DisplayPhoto {

private DisplayPhoto() { throw new RuntimeException("Stub!"); }

/**
 * This URI allows the caller to query for the maximum dimensions of a display photo
 * or thumbnail.  Requests to this URI can be performed on the UI thread because
 * they are always unblocking.
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_MAX_DIMENSIONS_URI;
static { CONTENT_MAX_DIMENSIONS_URI = null; }

/**
 * The content:// style URI for this class, which allows access to full-size photos,
 * given a key.
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * Queries to {@link android.provider.ContactsContract.DisplayPhoto#CONTENT_MAX_DIMENSIONS_URI ContactsContract.DisplayPhoto#CONTENT_MAX_DIMENSIONS_URI} will
 * contain this column, populated with the maximum height and width (in pixels)
 * that will be stored for a display photo.  Larger photos will be down-sized to
 * fit within a square of this many pixels.
 * @apiSince 14
 */

public static final java.lang.String DISPLAY_MAX_DIM = "display_max_dim";

/**
 * Queries to {@link android.provider.ContactsContract.DisplayPhoto#CONTENT_MAX_DIMENSIONS_URI ContactsContract.DisplayPhoto#CONTENT_MAX_DIMENSIONS_URI} will
 * contain this column, populated with the height and width (in pixels) for photo
 * thumbnails.
 * @apiSince 14
 */

public static final java.lang.String THUMBNAIL_MAX_DIM = "thumbnail_max_dim";
}

/**
 * Constants for various styles of combining given name, family name etc into
 * a full name.  For example, the western tradition follows the pattern
 * 'given name' 'middle name' 'family name' with the alternative pattern being
 * 'family name', 'given name' 'middle name'.  The CJK tradition is
 * 'family name' 'middle name' 'given name', with Japanese favoring a space between
 * the names and Chinese omitting the space.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface FullNameStyle {

/** @apiSince 11 */

public static final int CHINESE = 3; // 0x3

/**
 * Used if the name is written in Hanzi/Kanji/Hanja and we could not determine
 * which specific language it belongs to: Chinese, Japanese or Korean.
 * @apiSince 11
 */

public static final int CJK = 2; // 0x2

/** @apiSince 11 */

public static final int JAPANESE = 4; // 0x4

/** @apiSince 11 */

public static final int KOREAN = 5; // 0x5

/** @apiSince 11 */

public static final int UNDEFINED = 0; // 0x0

/** @apiSince 11 */

public static final int WESTERN = 1; // 0x1
}

/**
 * Constants for the groups table. Only per-account groups are supported.
 * <h2>Columns</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th colspan='4'>Groups</th>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #_ID}</td>
 * <td>read-only</td>
 * <td>Row ID. Sync adapter should try to preserve row IDs during updates.
 * In other words, it would be a really bad idea to delete and reinsert a
 * group. A sync adapter should always do an update instead.</td>
 * </tr>
 # <tr>
 * <td>String</td>
 * <td>{@link #DATA_SET}</td>
 * <td>read/write-once</td>
 * <td>
 * <p>
 * The data set within the account that this group belongs to.  This allows
 * multiple sync adapters for the same account type to distinguish between
 * each others' group data.  The combination of {@link #ACCOUNT_TYPE},
 * {@link #ACCOUNT_NAME}, and {@link #DATA_SET} identifies a set of data
 * that is associated with a single sync adapter.
 * </p>
 * <p>
 * This is empty by default, and is completely optional.  It only needs to
 * be populated if multiple sync adapters are entering distinct data for
 * the same account type and account name.
 * </p>
 * <p>
 * It should be set at the time the group is inserted and never changed
 * afterwards.
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #TITLE}</td>
 * <td>read/write</td>
 * <td>The display title of this group.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #NOTES}</td>
 * <td>read/write</td>
 * <td>Notes about the group.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #SYSTEM_ID}</td>
 * <td>read/write</td>
 * <td>The ID of this group if it is a System Group, i.e. a group that has a
 * special meaning to the sync adapter, null otherwise.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #SUMMARY_COUNT}</td>
 * <td>read-only</td>
 * <td>The total number of {@link android.provider.ContactsContract.Contacts Contacts} that have
 * {@link android.provider.ContactsContract.CommonDataKinds.GroupMembership CommonDataKinds.GroupMembership} in this group. Read-only value
 * that is only present when querying {@link android.provider.ContactsContract.Groups#CONTENT_SUMMARY_URI Groups#CONTENT_SUMMARY_URI}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #SUMMARY_WITH_PHONES}</td>
 * <td>read-only</td>
 * <td>The total number of {@link android.provider.ContactsContract.Contacts Contacts} that have both
 * {@link android.provider.ContactsContract.CommonDataKinds.GroupMembership CommonDataKinds.GroupMembership} in this group, and also have
 * phone numbers. Read-only value that is only present when querying
 * {@link android.provider.ContactsContract.Groups#CONTENT_SUMMARY_URI Groups#CONTENT_SUMMARY_URI}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #GROUP_VISIBLE}</td>
 * <td>read-only</td>
 * <td>Flag indicating if the contacts belonging to this group should be
 * visible in any user interface. Allowed values: 0 and 1.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #DELETED}</td>
 * <td>read/write</td>
 * <td>The "deleted" flag: "0" by default, "1" if the row has been marked
 * for deletion. When {@link android.content.ContentResolver#delete} is
 * called on a group, it is marked for deletion. The sync adaptor deletes
 * the group on the server and then calls ContactResolver.delete once more,
 * this time setting the the {@link android.provider.ContactsContract#CALLER_IS_SYNCADAPTER ContactsContract#CALLER_IS_SYNCADAPTER}
 * query parameter to finalize the data removal.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #SHOULD_SYNC}</td>
 * <td>read/write</td>
 * <td>Whether this group should be synced if the SYNC_EVERYTHING settings
 * is false for this group's account.</td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Groups implements android.provider.BaseColumns, android.provider.ContactsContract.GroupsColumns, android.provider.ContactsContract.SyncColumns {

private Groups() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public static android.content.EntityIterator newEntityIterator(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type of a single group.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/group";

/**
 * The content:// style URI for this table joined with details data from
 * {@link android.provider.ContactsContract.Data ContactsContract.Data}.
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_SUMMARY_URI;
static { CONTENT_SUMMARY_URI = null; }

/**
 * The MIME type of a directory of groups.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/group";

/**
 * The content:// style URI for this table
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }
}

/**
 * @see android.provider.ContactsContract.Groups
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface GroupsColumns {

/**
 * Any newly created contacts will automatically be added to groups that have this
 * flag set to true.
 * <p>
 * Type: INTEGER (boolean)
 * @apiSince 11
 */

public static final java.lang.String AUTO_ADD = "auto_add";

/**
 * The data set within the account that this group belongs to.  This allows
 * multiple sync adapters for the same account type to distinguish between
 * each others' group data.
 *
 * This is empty by default, and is completely optional.  It only needs to
 * be populated if multiple sync adapters are entering distinct group data
 * for the same account type and account name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String DATA_SET = "data_set";

/**
 * The "deleted" flag: "0" by default, "1" if the row has been marked
 * for deletion. When {@link android.content.ContentResolver#delete} is
 * called on a group, it is marked for deletion. The sync adaptor
 * deletes the group on the server and then calls ContactResolver.delete
 * once more, this time setting the the
 * {@link android.provider.ContactsContract#CALLER_IS_SYNCADAPTER ContactsContract#CALLER_IS_SYNCADAPTER} query parameter to
 * finalize the data removal.
 * <P>Type: INTEGER</P>
 * @apiSince 5
 */

public static final java.lang.String DELETED = "deleted";

/**
 * When a contacts is marked as a favorites it will be automatically added
 * to the groups that have this flag set, and when it is removed from favorites
 * it will be removed from these groups.
 * <p>
 * Type: INTEGER (boolean)
 * @apiSince 11
 */

public static final java.lang.String FAVORITES = "favorites";

/**
 * The "read-only" flag: "0" by default, "1" if the row cannot be modified or
 * deleted except by a sync adapter.  See {@link android.provider.ContactsContract#CALLER_IS_SYNCADAPTER ContactsContract#CALLER_IS_SYNCADAPTER}.
 * <P>Type: INTEGER</P>
 * @apiSince 11
 */

public static final java.lang.String GROUP_IS_READ_ONLY = "group_is_read_only";

/**
 * Flag indicating if the contacts belonging to this group should be
 * visible in any user interface.
 * <p>
 * Type: INTEGER (boolean)
 * @apiSince 5
 */

public static final java.lang.String GROUP_VISIBLE = "group_visible";

/**
 * Notes about the group.
 * <p>
 * Type: TEXT
 * @apiSince 5
 */

public static final java.lang.String NOTES = "notes";

/**
 * The package name to use when creating {@link android.content.res.Resources Resources} objects for
 * this group. This value is only designed for use when building user
 * interfaces, and should not be used to infer the owner.
 * @apiSince 21
 */

public static final java.lang.String RES_PACKAGE = "res_package";

/**
 * Whether this group should be synced if the SYNC_EVERYTHING settings
 * is false for this group's account.
 * <p>
 * Type: INTEGER (boolean)
 * @apiSince 5
 */

public static final java.lang.String SHOULD_SYNC = "should_sync";

/**
 * The total number of {@link android.provider.ContactsContract.Contacts Contacts} that have
 * {@link android.provider.ContactsContract.CommonDataKinds.GroupMembership CommonDataKinds.GroupMembership} in this group. Read-only value that is only
 * present when querying {@link android.provider.ContactsContract.Groups#CONTENT_SUMMARY_URI Groups#CONTENT_SUMMARY_URI}.
 * <p>
 * Type: INTEGER
 * @apiSince 5
 */

public static final java.lang.String SUMMARY_COUNT = "summ_count";

/**
 * The total number of {@link android.provider.ContactsContract.Contacts Contacts} that have both
 * {@link android.provider.ContactsContract.CommonDataKinds.GroupMembership CommonDataKinds.GroupMembership} in this group, and also have phone numbers.
 * Read-only value that is only present when querying
 * {@link android.provider.ContactsContract.Groups#CONTENT_SUMMARY_URI Groups#CONTENT_SUMMARY_URI}.
 * <p>
 * Type: INTEGER
 * @apiSince 5
 */

public static final java.lang.String SUMMARY_WITH_PHONES = "summ_phones";

/**
 * The ID of this group if it is a System Group, i.e. a group that has a special meaning
 * to the sync adapter, null otherwise.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String SYSTEM_ID = "system_id";

/**
 * The display title of this group.
 * <p>
 * Type: TEXT
 * @apiSince 5
 */

public static final java.lang.String TITLE = "title";

/**
 * The display title of this group to load as a resource from
 * {@link #RES_PACKAGE}, which may be localized.
 * <P>Type: TEXT</P>
 * @apiSince 21
 */

public static final java.lang.String TITLE_RES = "title_res";
}

/**
 * Contains helper classes used to create or manage {@link android.content.Intent Intents}
 * that involve contacts.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Intents {

public Intents() { throw new RuntimeException("Stub!"); }

/**
 * Activity Action: Initiate a message to someone by voice. The message could be text,
 * audio, video or image(photo). This action supports messaging with a specific contact
 * regardless of the underlying messaging protocol used.
 * <p>
 * The action could be originated from the Voice Assistant as a voice interaction. In such
 * case, a receiving activity that supports {@link android.content.Intent#CATEGORY_VOICE}
 * could check return value of {@link android.app.Activity#isVoiceInteractionRoot} before
 * proceeding. By doing this check the activity verifies that the action indeed was
 * initiated by Voice Assistant and could send a message right away, without any further
 * input from the user. This allows for a smooth user experience when sending a message by
 * voice. Note: this activity must also support the {@link
 * android.content.Intent#CATEGORY_DEFAULT} so it can be found by {@link
 * android.service.voice.VoiceInteractionSession#startVoiceActivity}.
 * <p>
 * When the action was not initiated by Voice Assistant or when the receiving activity does
 * not support {@link android.content.Intent#CATEGORY_VOICE}, the activity must confirm
 * with the user before sending the message (because in this case it is unknown which app
 * sent the intent, it could be malicious).
 * <p>
 * To allow the Voice Assistant to help users with contacts disambiguation, the messaging
 * app may choose to integrate with the Contacts Provider. You will need to specify a new
 * MIME type in order to store your app’s unique contact IDs and optional human readable
 * labels in the Data table. The Voice Assistant needs to know this MIME type and {@link android.provider.ContactsContract.RawContacts#ACCOUNT_TYPE RawContacts#ACCOUNT_TYPE} that you are using in order to provide the smooth contact
 * disambiguation user experience. The following convention should be met when performing
 * such integration:
 * <ul>
 * <li>This activity should have a string meta-data field associated with it, {@link
 * #METADATA_ACCOUNT_TYPE}, which defines {@link android.provider.ContactsContract.RawContacts#ACCOUNT_TYPE RawContacts#ACCOUNT_TYPE} for your Contacts
 * Provider implementation. The account type should be globally unique, for example you can
 * use your app package name as the account type.</li>
 * <li>This activity should have a string meta-data field associated with it, {@link
 * #METADATA_MIMETYPE}, which defines {@link android.provider.ContactsContract.DataColumns#MIMETYPE DataColumns#MIMETYPE} for your Contacts
 * Provider implementation. For example, you can use
 * "vnd.android.cursor.item/vnd.{$app_package_name}.profile" as MIME type.</li>
 * <li>When filling Data table row for METADATA_MIMETYPE, column {@link android.provider.ContactsContract.DataColumns#DATA1 DataColumns#DATA1}
 * should store the unique contact ID as understood by the app. This value will be used in
 * the {@link #EXTRA_RECIPIENT_CONTACT_CHAT_ID}.</li>
 * <li>Optionally, when filling Data table row for METADATA_MIMETYPE, column {@link android.provider.ContactsContract.DataColumns#DATA3 DataColumns#DATA3} could store a human readable label for the ID. For example it could be
 * phone number or human readable username/user_id like "a_super_cool_user_name". This label
 * may be shown below the Contact Name by the Voice Assistant as the user completes the
 * voice action. If DATA3 is empty, the ID in DATA1 may be shown instead.</li>
 * <li><em>Note: Do not use DATA3 to store the Contact Name. The Voice Assistant will
 * already get the Contact Name from the RawContact’s display_name.</em></li>
 * <li><em>Note: Some apps may choose to use phone number as the unique contact ID in DATA1.
 * If this applies to you and you’d like phone number to be shown below the Contact Name by
 * the Voice Assistant, then you may choose to leave DATA3 empty.</em></li>
 * <li><em>Note: If your app also uses DATA3 to display contact details in the Contacts App,
 * make sure it does not include prefix text such as "Message +<phone>" or "Free Message
 * +<phone>", etc. If you must show the prefix text in the Contacts App, please use a
 * different DATA# column, and update your contacts.xml to point to this new column. </em>
 * </li>
 * </ul>
 * If the app chooses not to integrate with the Contacts Provider (in particular, when
 * either METADATA_ACCOUNT_TYPE or METADATA_MIMETYPE field is missing), Voice Assistant
 * will use existing phone number entries as contact ID's for such app.
 * <p>
 * Input: {@link android.content.Intent#getType} is the MIME type of the data being sent.
 * The intent sender will always put the concrete mime type in the intent type, like
 * "text/plain" or "audio/wav" for example. If the MIME type is "text/plain", message to
 * sent will be provided via {@link android.content.Intent#EXTRA_TEXT} as a styled
 * CharSequence. Otherwise, the message content will be supplied through {@link
 * android.content.Intent#setClipData(ClipData)} as a content provider URI(s). In the latter
 * case, EXTRA_TEXT could still be supplied optionally; for example, for audio messages
 * ClipData will contain URI of a recording and EXTRA_TEXT could contain the text
 * transcription of this recording.
 * <p>
 * The message can have n recipients. The n-th recipient of the message will be provided as
 * n-th elements of {@link #EXTRA_RECIPIENT_CONTACT_URI}, {@link
 * #EXTRA_RECIPIENT_CONTACT_CHAT_ID} and {@link #EXTRA_RECIPIENT_CONTACT_NAME} (as a
 * consequence, EXTRA_RECIPIENT_CONTACT_URI, EXTRA_RECIPIENT_CONTACT_CHAT_ID and
 * EXTRA_RECIPIENT_CONTACT_NAME should all be of length n). If neither of these 3 elements
 * is provided (e.g. all 3 are null) for the recipient or if the information provided is
 * ambiguous then the activity should prompt the user for the recipient to send the message
 * to.
 * <p>
 * Output: nothing
 *
 * @see #EXTRA_RECIPIENT_CONTACT_URI
 * @see #EXTRA_RECIPIENT_CONTACT_CHAT_ID
 * @see #EXTRA_RECIPIENT_CONTACT_NAME
 * @see #METADATA_ACCOUNT_TYPE
 * @see #METADATA_MIMETYPE
 * @apiSince 24
 */

public static final java.lang.String ACTION_VOICE_SEND_MESSAGE_TO_CONTACTS = "android.provider.action.VOICE_SEND_MESSAGE_TO_CONTACTS";

/**
 * Starts an Activity that lets the user pick a contact to attach an image to.
 * After picking the contact it launches the image cropper in face detection mode.
 * @apiSince 5
 */

public static final java.lang.String ATTACH_IMAGE = "com.android.contacts.action.ATTACH_IMAGE";

/**
 * This is the intent that is fired when the contacts database is created. <p> The
 * READ_CONTACT permission is required to receive these broadcasts.
 *
 * <p>Because this is an implicit broadcast, apps targeting Android O will no longer
 * receive this broadcast via a manifest broadcast receiver.  (Broadcast receivers
 * registered at runtime with
 * {@link android.content.Context#registerReceiver(android.content.BroadcastReceiver,android.content.IntentFilter) Context#registerReceiver(BroadcastReceiver, IntentFilter)} will still receive it.)
 * Instead, an app can use {@link android.provider.ContactsContract.ProviderStatus#DATABASE_CREATION_TIMESTAMP ProviderStatus#DATABASE_CREATION_TIMESTAMP} to see if the
 * contacts database has been initialized when it starts.
 * @apiSince 18
 */

public static final java.lang.String CONTACTS_DATABASE_CREATED = "android.provider.Contacts.DATABASE_CREATED";

/**
 * Used with {@link #SHOW_OR_CREATE_CONTACT} to specify an exact
 * description to be shown when prompting user about creating a new
 * contact.
 * <p>
 * Type: STRING
 * @apiSince 5
 */

public static final java.lang.String EXTRA_CREATE_DESCRIPTION = "com.android.contacts.action.CREATE_DESCRIPTION";

/**
 * Used with {@link #SHOW_OR_CREATE_CONTACT} to force creating a new
 * contact if no matching contact found. Otherwise, default behavior is
 * to prompt user with dialog before creating.
 * <p>
 * Type: BOOLEAN
 * @apiSince 5
 */

public static final java.lang.String EXTRA_FORCE_CREATE = "com.android.contacts.action.FORCE_CREATE";

/**
 * This extra specifies a messaging app’s unique ID(s) for the contact(s), used with {@link
 * #ACTION_VOICE_SEND_MESSAGE_TO_CONTACTS} to supply the recipient(s). The value of this
 * extra is a {@code String[]}. The number of elements in the array should be equal to
 * number of recipients (and consistent with {@link #EXTRA_RECIPIENT_CONTACT_URI} and {@link
 * #EXTRA_RECIPIENT_CONTACT_NAME}). When the value of the element for the particular
 * recipient is absent, it will be set to null.
 * <p>
 * The value of the elements comes from the {@link android.provider.ContactsContract.DataColumns#DATA1 DataColumns#DATA1} column in Contacts
 * Provider with {@link android.provider.ContactsContract.DataColumns#MIMETYPE DataColumns#MIMETYPE} from {@link #METADATA_MIMETYPE} (if both
 * {@link #METADATA_ACCOUNT_TYPE} and {@link #METADATA_MIMETYPE} are specified by the app;
 * otherwise, the value will be a phone number), and should be the unambiguous contact
 * endpoint. This value is app-specific, it could be some proprietary ID or a phone number.
 * @apiSince 24
 */

public static final java.lang.String EXTRA_RECIPIENT_CONTACT_CHAT_ID = "android.provider.extra.RECIPIENT_CONTACT_CHAT_ID";

/**
 * This extra specifies the contact name (full name from the Contacts Provider), used with
 * {@link #ACTION_VOICE_SEND_MESSAGE_TO_CONTACTS} to supply the recipient. The value of this
 * extra is a {@code String[]}. The number of elements in the array should be equal to
 * number of recipients (and consistent with {@link #EXTRA_RECIPIENT_CONTACT_URI} and {@link
 * #EXTRA_RECIPIENT_CONTACT_CHAT_ID}). When the value of the element for the particular
 * recipient is absent, it will be set to null.
 * <p>
 * The value of the elements comes from RawContact's display_name column.
 * <p>
 * <em>Example value: {"Jane Doe"}</em>
 * @apiSince 24
 */

public static final java.lang.String EXTRA_RECIPIENT_CONTACT_NAME = "android.provider.extra.RECIPIENT_CONTACT_NAME";

/**
 * This extra specifies a content provider uri(s) for the contact(s) (if the contacts were
 * located in the Contacts Provider), used with {@link
 * #ACTION_VOICE_SEND_MESSAGE_TO_CONTACTS} to supply the recipient(s). The value of this
 * extra is a {@code String[]}. The number of elements in the array should be equal to
 * number of recipients (and consistent with {@link #EXTRA_RECIPIENT_CONTACT_CHAT_ID} and
 * {@link #EXTRA_RECIPIENT_CONTACT_NAME}). When the value of the element for the particular
 * recipient is absent, it will be set to null.
 * <p>
 * <em>Note: one contact may have multiple accounts (e.g. Chat IDs) on a specific messaging
 * platform, so this may be ambiguous. E.g., one contact “John Smith” could have two
 * accounts on the same messaging app.</em>
 * <p>
 * <em>Example value: {"content://com.android.contacts/contacts/16"}</em>
 * @apiSince 24
 */

public static final java.lang.String EXTRA_RECIPIENT_CONTACT_URI = "android.provider.extra.RECIPIENT_CONTACT_URI";

/**
 * This is the intent that is fired when the user clicks the "invite to the network" button
 * on a contact.  Only sent to an activity which is explicitly registered by a contact
 * provider which supports the "invite to the network" feature.
 * <p>
 * {@link android.content.Intent#getData() Intent#getData()} contains the lookup URI for the contact.
 * @apiSince 14
 */

public static final java.lang.String INVITE_CONTACT = "com.android.contacts.action.INVITE_CONTACT";

/**
 * A string associated with an {@link #ACTION_VOICE_SEND_MESSAGE_TO_CONTACTS} activity
 * describing {@link android.provider.ContactsContract.RawContacts#ACCOUNT_TYPE RawContacts#ACCOUNT_TYPE} for the corresponding Contacts Provider
 * implementation.
 * @apiSince 24
 */

public static final java.lang.String METADATA_ACCOUNT_TYPE = "android.provider.account_type";

/**
 * A string associated with an {@link #ACTION_VOICE_SEND_MESSAGE_TO_CONTACTS} activity
 * describing {@link android.provider.ContactsContract.DataColumns#MIMETYPE DataColumns#MIMETYPE} for the corresponding Contacts Provider
 * implementation.
 * @apiSince 24
 */

public static final java.lang.String METADATA_MIMETYPE = "android.provider.mimetype";

/**
 * This is the intent that is fired when a search suggestion is clicked on.
 * @apiSince 5
 */

public static final java.lang.String SEARCH_SUGGESTION_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_CLICKED";

/**
 * This is the intent that is fired when a search suggestion for creating a contact
 * is clicked on.
 * @apiSince 5
 */

public static final java.lang.String SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED";

/**
 * This is the intent that is fired when a search suggestion for dialing a number
 * is clicked on.
 * @apiSince 5
 */

public static final java.lang.String SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED";

/**
 * Takes as input a data URI with a mailto: or tel: scheme. If a single
 * contact exists with the given data it will be shown. If no contact
 * exists, a dialog will ask the user if they want to create a new
 * contact with the provided details filled in. If multiple contacts
 * share the data the user will be prompted to pick which contact they
 * want to view.
 * <p>
 * For <code>mailto:</code> URIs, the scheme specific portion must be a
 * raw email address, such as one built using
 * {@link android.net.Uri#fromParts(java.lang.String,java.lang.String,java.lang.String) Uri#fromParts(String, String, String)}.
 * <p>
 * For <code>tel:</code> URIs, the scheme specific portion is compared
 * to existing numbers using the standard caller ID lookup algorithm.
 * The number must be properly encoded, for example using
 * {@link android.net.Uri#fromParts(java.lang.String,java.lang.String,java.lang.String) Uri#fromParts(String, String, String)}.
 * <p>
 * Any extras from the {@link android.provider.ContactsContract.Intents.Insert Insert} class will be passed along to the
 * create activity if there are no contacts to show.
 * <p>
 * Passing true for the {@link #EXTRA_FORCE_CREATE} extra will skip
 * prompting the user when the contact doesn't exist.
 * @apiSince 5
 */

public static final java.lang.String SHOW_OR_CREATE_CONTACT = "com.android.contacts.action.SHOW_OR_CREATE_CONTACT";
/**
 * Convenience class that contains string constants used
 * to create contact {@link android.content.Intent Intents}.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Insert {

public Insert() { throw new RuntimeException("Stub!"); }

/**
 * The action code to use when adding a contact
 * @apiSince 5
 */

public static final java.lang.String ACTION = "android.intent.action.INSERT";

/**
 * The extra field for the contact company.
 * <P>Type: String</P>
 * @apiSince 5
 */

public static final java.lang.String COMPANY = "company";

/**
 * The extra field that allows the client to supply multiple rows of
 * arbitrary data for a single contact created using the {@link android.content.Intent#ACTION_INSERT Intent#ACTION_INSERT}
 * or edited using {@link android.content.Intent#ACTION_EDIT Intent#ACTION_EDIT}. It is an ArrayList of
 * {@link android.content.ContentValues ContentValues}, one per data row. Supplying this extra is
 * similar to inserting multiple rows into the {@link android.provider.ContactsContract.Data Data} table,
 * except the user gets a chance to see and edit them before saving.
 * Each ContentValues object must have a value for {@link android.provider.ContactsContract.Data#MIMETYPE Data#MIMETYPE}.
 * If supplied values are not visible in the editor UI, they will be
 * dropped.  Duplicate data will dropped.  Some fields
 * like {@link CommonDataKinds.Email#TYPE Email.TYPE} may be automatically
 * adjusted to comply with the constraints of the specific account type.
 * For example, an Exchange contact can only have one phone numbers of type Home,
 * so the contact editor may choose a different type for this phone number to
 * avoid dropping the valueable part of the row, which is the phone number.
 * <p>
 * Example:
 * <pre>
 *  ArrayList&lt;ContentValues&gt; data = new ArrayList&lt;ContentValues&gt;();
 *
 *  ContentValues row1 = new ContentValues();
 *  row1.put(Data.MIMETYPE, Organization.CONTENT_ITEM_TYPE);
 *  row1.put(Organization.COMPANY, "Android");
 *  data.add(row1);
 *
 *  ContentValues row2 = new ContentValues();
 *  row2.put(Data.MIMETYPE, Email.CONTENT_ITEM_TYPE);
 *  row2.put(Email.TYPE, Email.TYPE_CUSTOM);
 *  row2.put(Email.LABEL, "Green Bot");
 *  row2.put(Email.ADDRESS, "android@android.com");
 *  data.add(row2);
 *
 *  Intent intent = new Intent(Intent.ACTION_INSERT, Contacts.CONTENT_URI);
 *  intent.putParcelableArrayListExtra(Insert.DATA, data);
 *
 *  startActivity(intent);
 * </pre>
 * @apiSince 11
 */

public static final java.lang.String DATA = "data";

/**
 * The extra field for the contact email address.
 * <P>Type: String</P>
 * @apiSince 5
 */

public static final java.lang.String EMAIL = "email";

/**
 * The extra field for the email isprimary flag.
 * <P>Type: boolean</P>
 * @apiSince 5
 */

public static final java.lang.String EMAIL_ISPRIMARY = "email_isprimary";

/**
 * The extra field for the contact email type.
 * <P>Type: Either an integer value from
 * {@link android.provider.ContactsContract.CommonDataKinds.Email CommonDataKinds.Email}
 *  or a string specifying a custom label.</P>
 * @apiSince 5
 */

public static final java.lang.String EMAIL_TYPE = "email_type";

/**
 * Used to specify the account in which to create the new contact.
 * <p>
 * If this value is not provided, the user is presented with a disambiguation
 * dialog to chose an account
 * <p>
 * Type: {@link android.accounts.Account Account}
 * @apiSince 23
 */

public static final java.lang.String EXTRA_ACCOUNT = "android.provider.extra.ACCOUNT";

/**
 * Used to specify the data set within the account in which to create the
 * new contact.
 * <p>
 * This value is optional - if it is not specified, the contact will be
 * created in the base account, with no data set.
 * <p>
 * Type: String
 * @apiSince 23
 */

public static final java.lang.String EXTRA_DATA_SET = "android.provider.extra.DATA_SET";

/**
 * If present, forces a bypass of quick insert mode.
 * @apiSince 5
 */

public static final java.lang.String FULL_MODE = "full_mode";

/**
 * The extra field for an IM handle.
 * <P>Type: String</P>
 * @apiSince 5
 */

public static final java.lang.String IM_HANDLE = "im_handle";

/**
 * The extra field for the IM isprimary flag.
 * <P>Type: boolean</P>
 * @apiSince 5
 */

public static final java.lang.String IM_ISPRIMARY = "im_isprimary";

/**
 * The extra field for the IM protocol
 * @apiSince 5
 */

public static final java.lang.String IM_PROTOCOL = "im_protocol";

/**
 * The extra field for the contact job title.
 * <P>Type: String</P>
 * @apiSince 5
 */

public static final java.lang.String JOB_TITLE = "job_title";

/**
 * The extra field for the contact name.
 * <P>Type: String</P>
 * @apiSince 5
 */

public static final java.lang.String NAME = "name";

/**
 * The extra field for the contact notes.
 * <P>Type: String</P>
 * @apiSince 5
 */

public static final java.lang.String NOTES = "notes";

/**
 * The extra field for the contact phone number.
 * <P>Type: String</P>
 * @apiSince 5
 */

public static final java.lang.String PHONE = "phone";

/**
 * The extra field for the contact phonetic name.
 * <P>Type: String</P>
 * @apiSince 5
 */

public static final java.lang.String PHONETIC_NAME = "phonetic_name";

/**
 * The extra field for the phone isprimary flag.
 * <P>Type: boolean</P>
 * @apiSince 5
 */

public static final java.lang.String PHONE_ISPRIMARY = "phone_isprimary";

/**
 * The extra field for the contact phone number type.
 * <P>Type: Either an integer value from
 * {@link android.provider.ContactsContract.CommonDataKinds.Phone CommonDataKinds.Phone},
 *  or a string specifying a custom label.</P>
 * @apiSince 5
 */

public static final java.lang.String PHONE_TYPE = "phone_type";

/**
 * The extra field for the contact postal address.
 * <P>Type: String</P>
 * @apiSince 5
 */

public static final java.lang.String POSTAL = "postal";

/**
 * The extra field for the postal isprimary flag.
 * <P>Type: boolean</P>
 * @apiSince 5
 */

public static final java.lang.String POSTAL_ISPRIMARY = "postal_isprimary";

/**
 * The extra field for the contact postal address type.
 * <P>Type: Either an integer value from
 * {@link android.provider.ContactsContract.CommonDataKinds.StructuredPostal CommonDataKinds.StructuredPostal}
 *  or a string specifying a custom label.</P>
 * @apiSince 5
 */

public static final java.lang.String POSTAL_TYPE = "postal_type";

/**
 * The extra field for an optional second contact email address.
 * <P>Type: String</P>
 * @apiSince 5
 */

public static final java.lang.String SECONDARY_EMAIL = "secondary_email";

/**
 * The extra field for an optional second contact email type.
 * <P>Type: Either an integer value from
 * {@link android.provider.ContactsContract.CommonDataKinds.Email CommonDataKinds.Email}
 *  or a string specifying a custom label.</P>
 * @apiSince 5
 */

public static final java.lang.String SECONDARY_EMAIL_TYPE = "secondary_email_type";

/**
 * The extra field for an optional second contact phone number.
 * <P>Type: String</P>
 * @apiSince 5
 */

public static final java.lang.String SECONDARY_PHONE = "secondary_phone";

/**
 * The extra field for an optional second contact phone number type.
 * <P>Type: Either an integer value from
 * {@link android.provider.ContactsContract.CommonDataKinds.Phone CommonDataKinds.Phone},
 *  or a string specifying a custom label.</P>
 * @apiSince 5
 */

public static final java.lang.String SECONDARY_PHONE_TYPE = "secondary_phone_type";

/**
 * The extra field for an optional third contact email address.
 * <P>Type: String</P>
 * @apiSince 5
 */

public static final java.lang.String TERTIARY_EMAIL = "tertiary_email";

/**
 * The extra field for an optional third contact email type.
 * <P>Type: Either an integer value from
 * {@link android.provider.ContactsContract.CommonDataKinds.Email CommonDataKinds.Email}
 *  or a string specifying a custom label.</P>
 * @apiSince 5
 */

public static final java.lang.String TERTIARY_EMAIL_TYPE = "tertiary_email_type";

/**
 * The extra field for an optional third contact phone number.
 * <P>Type: String</P>
 * @apiSince 5
 */

public static final java.lang.String TERTIARY_PHONE = "tertiary_phone";

/**
 * The extra field for an optional third contact phone number type.
 * <P>Type: Either an integer value from
 * {@link android.provider.ContactsContract.CommonDataKinds.Phone CommonDataKinds.Phone},
 *  or a string specifying a custom label.</P>
 * @apiSince 5
 */

public static final java.lang.String TERTIARY_PHONE_TYPE = "tertiary_phone_type";
}

}

/**
 * A table that represents the result of looking up a phone number, for
 * example for caller ID. To perform a lookup you must append the number you
 * want to find to {@link #CONTENT_FILTER_URI}.  This query is highly
 * optimized.
 * <pre>
 * Uri uri = Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneNumber));
 * resolver.query(uri, new String[]{PhoneLookup.DISPLAY_NAME,...
 * </pre>
 *
 * <h3>Columns</h3>
 *
 * <table class="jd-sumtable">
 * <tr>
 * <th colspan='4'>PhoneLookup</th>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #NUMBER}</td>
 * <td>read-only</td>
 * <td>Phone number.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #TYPE}</td>
 * <td>read-only</td>
 * <td>Phone number type. See {@link android.provider.ContactsContract.CommonDataKinds.Phone CommonDataKinds.Phone}.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #LABEL}</td>
 * <td>read-only</td>
 * <td>Custom label for the phone number. See {@link android.provider.ContactsContract.CommonDataKinds.Phone CommonDataKinds.Phone}.</td>
 * </tr>
 * </table>
 * <p>
 * Columns from the Contacts table are also available through a join.
 * </p>
 * <table class="jd-sumtable">
 * <tr>
 * <th colspan='4'>Join with {@link android.provider.ContactsContract.Contacts Contacts}</th>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #_ID}</td>
 * <td>read-only</td>
 * <td>Contact ID.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #CONTACT_ID}</td>
 * <td>read-only</td>
 * <td>Contact ID.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #DATA_ID}</td>
 * <td>read-only</td>
 * <td>Data ID.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #LOOKUP_KEY}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #DISPLAY_NAME}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #PHOTO_ID}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #IN_VISIBLE_GROUP}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #HAS_PHONE_NUMBER}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #STARRED}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #CUSTOM_RINGTONE}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #SEND_TO_VOICEMAIL}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts}.</td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class PhoneLookup implements android.provider.BaseColumns, android.provider.ContactsContract.PhoneLookupColumns, android.provider.ContactsContract.ContactsColumns, android.provider.ContactsContract.ContactOptionsColumns, android.provider.ContactsContract.ContactNameColumns {

private PhoneLookup() { throw new RuntimeException("Stub!"); }

/**
 * The content:// style URI for this table.
 *
 * <p class="caution"><b>Caution: </b>If you publish your app to the Google Play Store, this
 * field doesn't sort results based on contacts frequency. For more information, see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.
 *
 * Append the phone number you want to lookup
 * to this URI and query it to perform a lookup. For example:
 * <pre>
 * Uri lookupUri = Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI,
 *         Uri.encode(phoneNumber));
 * </pre>
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_FILTER_URI;
static { CONTENT_FILTER_URI = null; }

/**
 * <p>URI used for the "enterprise caller-id".</p>
 *
 * <p class="caution"><b>Caution: </b>If you publish your app to the Google Play Store, this
 * field doesn't sort results based on contacts frequency. For more information, see the
 * <a href="/guide/topics/providers/contacts-provider#ObsoleteData">Contacts Provider</a>
 * page.
 *
 * <p>
 * It supports the same semantics as {@link #CONTENT_FILTER_URI} and returns the same
 * columns.  If the device has no corp profile that is linked to the current profile, it
 * behaves in the exact same way as {@link #CONTENT_FILTER_URI}.  If there is a corp profile
 * linked to the current profile, it first queries against the personal contact database,
 * and if no matching contacts are found there, then queries against the
 * corp contacts database.
 * </p>
 * <p>
 * If a result is from the corp profile, it makes the following changes to the data:
 * <ul>
 *     <li>
 *     {@link #PHOTO_THUMBNAIL_URI} and {@link #PHOTO_URI} will be rewritten to special
 *     URIs.  Use {@link android.content.ContentResolver#openAssetFileDescriptor ContentResolver#openAssetFileDescriptor} or its siblings to
 *     load pictures from them.
 *     {@link #PHOTO_ID} and {@link #PHOTO_FILE_ID} will be set to null.  Do not use them.
 *     </li>
 *     <li>
 *     Corp contacts will get artificial {@link #_ID}s.  In order to tell whether a contact
 *     is from the corp profile, use
 *     {@link android.provider.ContactsContract.Contacts#isEnterpriseContactId(long) ContactsContract.Contacts#isEnterpriseContactId(long)}.
 *     </li>
 *     <li>
 *     Corp contacts will get artificial {@link #LOOKUP_KEY}s too.
 *     </li>
 *     <li>
 *     Returned work contact IDs and lookup keys are not accepted in places that not
 *     explicitly say to accept them.
 *     </li>
 * </ul>
 * <p>
 * A contact lookup URL built by
 * {@link android.provider.ContactsContract.Contacts#getLookupUri(long,java.lang.String) ContactsContract.Contacts#getLookupUri(long, String)}
 * with an {@link #_ID} and a {@link #LOOKUP_KEY} returned by this API can be passed to
 * {@link android.provider.ContactsContract.QuickContact#showQuickContact ContactsContract.QuickContact#showQuickContact} even if a contact is from the
 * corp profile.
 * </p>
 *
 * <pre>
 * Uri lookupUri = Uri.withAppendedPath(PhoneLookup.ENTERPRISE_CONTENT_FILTER_URI,
 *         Uri.encode(phoneNumber));
 * </pre>
 * @apiSince 21
 */

public static final android.net.Uri ENTERPRISE_CONTENT_FILTER_URI;
static { ENTERPRISE_CONTENT_FILTER_URI = null; }

/**
 * If this boolean parameter is set to true, then the appended query is treated as a
 * SIP address and the lookup will be performed against SIP addresses in the user's
 * contacts.
 * @apiSince 21
 */

public static final java.lang.String QUERY_PARAMETER_SIP_ADDRESS = "sip";
}

/**
 * @see android.provider.ContactsContract.PhoneLookup
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface PhoneLookupColumns {

/**
 * A reference to the {@link android.provider.ContactsContract.Contacts#_ID ContactsContract.Contacts#_ID} that this
 * data belongs to.
 * <P>Type: INTEGER</P>
 * @apiSince 24
 */

public static final java.lang.String CONTACT_ID = "contact_id";

/**
 *  The ID of the data row.
 *  <P>Type: INTEGER</P>
 * @apiSince 24
 */

public static final java.lang.String DATA_ID = "data_id";

/**
 * The user defined label for the phone number.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String LABEL = "label";

/**
 * The phone number's E164 representation.
 * <P>Type: TEXT</P>
 * @apiSince 16
 */

public static final java.lang.String NORMALIZED_NUMBER = "normalized_number";

/**
 * The phone number as the user entered it.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String NUMBER = "number";

/**
 * The type of phone number, for example Home or Work.
 * <P>Type: INTEGER</P>
 * @apiSince 5
 */

public static final java.lang.String TYPE = "type";
}

/**
 * Constants for various styles of capturing the pronunciation of a person's name.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface PhoneticNameStyle {

/**
 * Hiragana and Katakana are two common styles of writing out the pronunciation
 * of a Japanese names.
 * @apiSince 11
 */

public static final int JAPANESE = 4; // 0x4

/**
 * Hangul is the Korean phonetic alphabet.
 * @apiSince 11
 */

public static final int KOREAN = 5; // 0x5

/**
 * Pinyin is a phonetic method of entering Chinese characters. Typically not explicitly
 * shown in UIs, but used for searches and sorting.
 * @apiSince 11
 */

public static final int PINYIN = 3; // 0x3

/** @apiSince 11 */

public static final int UNDEFINED = 0; // 0x0
}

/**
 * <p>
 * Contact-specific information about whether or not a contact has been pinned by the user
 * at a particular position within the system contact application's user interface.
 * </p>
 *
 * <p>
 * This pinning information can be used by individual applications to customize how
 * they order particular pinned contacts. For example, a Dialer application could
 * use pinned information to order user-pinned contacts in a top row of favorites.
 * </p>
 *
 * <p>
 * It is possible for two or more contacts to occupy the same pinned position (due
 * to aggregation and sync), so this pinning information should be used on a best-effort
 * basis to order contacts in-application rather than an absolute guide on where a contact
 * should be positioned. Contacts returned by the ContactsProvider will not be ordered based
 * on this information, so it is up to the client application to reorder these contacts within
 * their own UI adhering to (or ignoring as appropriate) information stored in the pinned
 * column.
 * </p>
 *
 * <p>
 * By default, unpinned contacts will have a pinned position of
 * {@link android.provider.ContactsContract.PinnedPositions#UNPINNED PinnedPositions#UNPINNED}. Client-provided pinned positions can be positive
 * integers that are greater than 1.
 * </p>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class PinnedPositions {

public PinnedPositions() { throw new RuntimeException("Stub!"); }

/**
 * Undemotes a formerly demoted contact. If the contact was not previously demoted, nothing
 * will be done.
 *
 * @param contentResolver to perform the undemote operation on.
 * @param contactId the id of the contact to undemote.
 * @apiSince 21
 */

public static void undemote(android.content.ContentResolver contentResolver, long contactId) { throw new RuntimeException("Stub!"); }

/**
 * Pins a contact at a provided position, or unpins a contact.
 *
 * @param contentResolver to perform the pinning operation on.
 * @param pinnedPosition the position to pin the contact at. To unpin a contact, use
 *         {@link android.provider.ContactsContract.PinnedPositions#UNPINNED PinnedPositions#UNPINNED}.
 * @apiSince 21
 */

public static void pin(android.content.ContentResolver contentResolver, long contactId, int pinnedPosition) { throw new RuntimeException("Stub!"); }

/**
 * Value of pinned position for a contact that a user has indicated should be considered
 * of the lowest priority. It is up to the client application to determine how to present
 * such a contact - for example all the way at the bottom of a contact list, or simply
 * just hidden from view.
 * @apiSince 21
 */

public static final int DEMOTED = -1; // 0xffffffff

/**
 * Default value for the pinned position of an unpinned contact.
 * @apiSince 21
 */

public static final int UNPINNED = 0; // 0x0
}

/**
 * @deprecated This old name was never meant to be made public. Do not use.
 * @apiSince 5
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class Presence extends android.provider.ContactsContract.StatusUpdates {

@Deprecated
public Presence() { throw new RuntimeException("Stub!"); }
}

/**
 * Additional data mixed in with {@link android.provider.ContactsContract.StatusColumns StatusColumns} to link
 * back to specific {@link android.provider.ContactsContract.Data#_ID ContactsContract.Data#_ID} entries.
 *
 * @see android.provider.ContactsContract.StatusUpdates
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface PresenceColumns {

/**
 * Name of the custom protocol.  Should be supplied along with the {@link #PROTOCOL} value
 * {@link android.provider.ContactsContract.CommonDataKinds.Im#PROTOCOL_CUSTOM ContactsContract.CommonDataKinds.Im#PROTOCOL_CUSTOM}.  Should be null or
 * omitted if {@link #PROTOCOL} value is not
 * {@link android.provider.ContactsContract.CommonDataKinds.Im#PROTOCOL_CUSTOM ContactsContract.CommonDataKinds.Im#PROTOCOL_CUSTOM}.
 *
 * <p>Type: NUMBER</p>
 * @apiSince 5
 */

public static final java.lang.String CUSTOM_PROTOCOL = "custom_protocol";

/**
 * Reference to the {@link android.provider.ContactsContract.Data#_ID Data#_ID} entry that owns this presence.
 * <P>Type: INTEGER</P>
 * @apiSince 5
 */

public static final java.lang.String DATA_ID = "presence_data_id";

/**
 * The IM account for the local user that the presence data came from.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String IM_ACCOUNT = "im_account";

/**
 * The IM handle the presence item is for. The handle is scoped to
 * {@link #PROTOCOL}.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String IM_HANDLE = "im_handle";

/**
 * See {@link android.provider.ContactsContract.CommonDataKinds.Im CommonDataKinds.Im} for a list of defined protocol constants.
 * <p>Type: NUMBER</p>
 * @apiSince 5
 */

public static final java.lang.String PROTOCOL = "protocol";
}

/**
 * <p>
 * Constants for the user's profile data, which is represented as a single contact on
 * the device that represents the user.  The profile contact is not aggregated
 * together automatically in the same way that normal contacts are; instead, each
 * account (including data set, if applicable) on the device may contribute a single
 * raw contact representing the user's personal profile data from that source.
 * </p>
 * <p>
 * Access to the profile entry through these URIs (or incidental access to parts of
 * the profile if retrieved directly via ID) requires additional permissions beyond
 * the read/write contact permissions required by the provider.  Querying for profile
 * data requires android.permission.READ_PROFILE permission, and inserting or
 * updating profile data requires android.permission.WRITE_PROFILE permission.
 * </p>
 * <h3>Operations</h3>
 * <dl>
 * <dt><b>Insert</b></dt>
 * <dd>The user's profile entry cannot be created explicitly (attempting to do so
 * will throw an exception). When a raw contact is inserted into the profile, the
 * provider will check for the existence of a profile on the device.  If one is
 * found, the raw contact's {@link android.provider.ContactsContract.RawContacts#CONTACT_ID RawContacts#CONTACT_ID} column gets the _ID of
 * the profile Contact. If no match is found, the profile Contact is created and
 * its _ID is put into the {@link android.provider.ContactsContract.RawContacts#CONTACT_ID RawContacts#CONTACT_ID} column of the newly
 * inserted raw contact.</dd>
 * <dt><b>Update</b></dt>
 * <dd>The profile Contact has the same update restrictions as Contacts in general,
 * but requires the android.permission.WRITE_PROFILE permission.</dd>
 * <dt><b>Delete</b></dt>
 * <dd>The profile Contact cannot be explicitly deleted.  It will be removed
 * automatically if all of its constituent raw contact entries are deleted.</dd>
 * <dt><b>Query</b></dt>
 * <dd>
 * <ul>
 * <li>The {@link #CONTENT_URI} for profiles behaves in much the same way as
 * retrieving a contact by ID, except that it will only ever return the user's
 * profile contact.
 * </li>
 * <li>
 * The profile contact supports all of the same sub-paths as an individual contact
 * does - the content of the profile contact can be retrieved as entities or
 * data rows.  Similarly, specific raw contact entries can be retrieved by appending
 * the desired raw contact ID within the profile.
 * </li>
 * </ul>
 * </dd>
 * </dl>
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Profile implements android.provider.BaseColumns, android.provider.ContactsContract.ContactsColumns, android.provider.ContactsContract.ContactOptionsColumns, android.provider.ContactsContract.ContactNameColumns, android.provider.ContactsContract.ContactStatusColumns {

private Profile() { throw new RuntimeException("Stub!"); }

/**
 * {@link android.net.Uri Uri} for referencing the raw contacts that make up the user's profile
 * {@link android.provider.ContactsContract.Contacts Contacts} entry.  An individual raw contact entry within the profile
 * can be addressed by appending the raw contact ID.  The entities or data within
 * that specific raw contact can be requested by appending the entity or data
 * path as well.
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_RAW_CONTACTS_URI;
static { CONTENT_RAW_CONTACTS_URI = null; }

/**
 * The content:// style URI for this table, which requests the contact entry
 * representing the user's personal profile data.
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * {@link android.net.Uri Uri} for referencing the user's profile {@link android.provider.ContactsContract.Contacts Contacts} entry,
 * Provides {@link android.provider.OpenableColumns OpenableColumns} columns when queried, or returns the
 * user's profile contact formatted as a vCard when opened through
 * {@link android.content.ContentResolver#openAssetFileDescriptor(android.net.Uri,java.lang.String) ContentResolver#openAssetFileDescriptor(Uri, String)}.
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_VCARD_URI;
static { CONTENT_VCARD_URI = null; }

/**
 * The minimum ID for any entity that belongs to the profile.  This essentially
 * defines an ID-space in which profile data is stored, and is used by the provider
 * to determine whether a request via a non-profile-specific URI should be directed
 * to the profile data rather than general contacts data, along with all the special
 * permission checks that entails.
 *
 * Callers may use {@link #isProfileId} to check whether a specific ID falls into
 * the set of data intended for the profile.
 * @apiSince 14
 */

public static final long MIN_ID = 9223372034707292160L; // 0x7fffffff80000000L
}

/**
 * A table provided for sync adapters to use for storing private sync state data for the
 * user's personal profile.
 *
 * @see android.provider.SyncStateContract
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class ProfileSyncState implements android.provider.SyncStateContract.Columns {

private ProfileSyncState() { throw new RuntimeException("Stub!"); }

/**
 * @see android.provider.SyncStateContract.Helpers#get
 * @apiSince 14
 */

public static byte[] get(android.content.ContentProviderClient provider, android.accounts.Account account) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * @see android.provider.SyncStateContract.Helpers#get
 * @apiSince 14
 */

public static android.util.Pair<android.net.Uri,byte[]> getWithUri(android.content.ContentProviderClient provider, android.accounts.Account account) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * @see android.provider.SyncStateContract.Helpers#set
 * @apiSince 14
 */

public static void set(android.content.ContentProviderClient provider, android.accounts.Account account, byte[] data) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * @see android.provider.SyncStateContract.Helpers#newSetOperation
 * @apiSince 14
 */

public static android.content.ContentProviderOperation newSetOperation(android.accounts.Account account, byte[] data) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static final java.lang.String CONTENT_DIRECTORY = "syncstate";

/**
 * The content:// style URI for this table
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }
}

/**
 * API for inquiring about the general status of the provider.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class ProviderStatus {

private ProviderStatus() { throw new RuntimeException("Stub!"); }

/**
 * The MIME-type of {@link #CONTENT_URI} providing a directory of
 * settings.
 * @apiSince 23
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/provider_status";

/**
 * The content:// style URI for this table.  Requests to this URI can be
 * performed on the UI thread because they are always unblocking.
 * @apiSince 23
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * Timestamp (milliseconds since epoch) of when the provider's database was created.
 *
 * <P>Type: long
 * @apiSince 26
 */

public static final java.lang.String DATABASE_CREATION_TIMESTAMP = "database_creation_timestamp";

/**
 * An integer representing the current status of the provider.
 * @apiSince 23
 */

public static final java.lang.String STATUS = "status";

/**
 * The provider won't respond to queries. It is in the middle of a long running task, such
 * as a database upgrade or locale change.
 * @apiSince 23
 */

public static final int STATUS_BUSY = 1; // 0x1

/**
 * The status that indicates that there are no accounts and no contacts
 * on the device.
 * @apiSince 23
 */

public static final int STATUS_EMPTY = 2; // 0x2

/**
 * Default status of the provider.
 * @apiSince 23
 */

public static final int STATUS_NORMAL = 0; // 0x0
}

/**
 * Helper methods to display QuickContact dialogs that display all the information belonging to
 * a specific {@link android.provider.ContactsContract.Contacts Contacts} entry.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class QuickContact {

public QuickContact() { throw new RuntimeException("Stub!"); }

/**
 * Trigger a dialog that lists the various methods of interacting with
 * the requested {@link android.provider.ContactsContract.Contacts Contacts} entry. This may be based on available
 * {@link android.provider.ContactsContract.Data ContactsContract.Data} rows under that contact, and may also
 * include social status and presence details.
 *
 * @param context The parent {@link android.content.Context Context} that may be used as the
 *            parent for this dialog.
 * @param target Specific {@link android.view.View View} from your layout that this dialog
 *            should be centered around. In particular, if the dialog
 *            has a "callout" arrow, it will be pointed and centered
 *            around this {@link android.view.View View}.
 * @param lookupUri A {@link android.provider.ContactsContract.Contacts#CONTENT_LOOKUP_URI ContactsContract.Contacts#CONTENT_LOOKUP_URI} style
 *            {@link android.net.Uri Uri} that describes a specific contact to feature
 *            in this dialog. A work lookup uri is supported here,
 *            see {@link CommonDataKinds.Email#ENTERPRISE_CONTENT_LOOKUP_URI} and
 *            {@link android.provider.ContactsContract.PhoneLookup#ENTERPRISE_CONTENT_FILTER_URI PhoneLookup#ENTERPRISE_CONTENT_FILTER_URI}.
 * @param mode Any of {@link #MODE_SMALL}, {@link #MODE_MEDIUM}, or
 *            {@link #MODE_LARGE}, indicating the desired dialog size,
 *            when supported.
 * @param excludeMimes Optional list of {@link android.provider.ContactsContract.Data#MIMETYPE Data#MIMETYPE} MIME-types
 *            to exclude when showing this dialog. For example, when
 *            already viewing the contact details card, this can be used
 *            to omit the details entry from the dialog.
 * @apiSince 5
 */

public static void showQuickContact(android.content.Context context, android.view.View target, android.net.Uri lookupUri, int mode, java.lang.String[] excludeMimes) { throw new RuntimeException("Stub!"); }

/**
 * Trigger a dialog that lists the various methods of interacting with
 * the requested {@link android.provider.ContactsContract.Contacts Contacts} entry. This may be based on available
 * {@link android.provider.ContactsContract.Data ContactsContract.Data} rows under that contact, and may also
 * include social status and presence details.
 *
 * @param context The parent {@link android.content.Context Context} that may be used as the
 *            parent for this dialog.
 * @param target Specific {@link android.graphics.Rect Rect} that this dialog should be
 *            centered around, in screen coordinates. In particular, if
 *            the dialog has a "callout" arrow, it will be pointed and
 *            centered around this {@link android.graphics.Rect Rect}. If you are running at a
 *            non-native density, you need to manually adjust using
 *            {@link android.util.DisplayMetrics#density DisplayMetrics#density} before calling.
 * @param lookupUri A
 *            {@link android.provider.ContactsContract.Contacts#CONTENT_LOOKUP_URI ContactsContract.Contacts#CONTENT_LOOKUP_URI} style
 *            {@link android.net.Uri Uri} that describes a specific contact to feature
 *            in this dialog. A work lookup uri is supported here,
 *            see {@link CommonDataKinds.Email#ENTERPRISE_CONTENT_LOOKUP_URI} and
 *            {@link android.provider.ContactsContract.PhoneLookup#ENTERPRISE_CONTENT_FILTER_URI PhoneLookup#ENTERPRISE_CONTENT_FILTER_URI}.
 * @param mode Any of {@link #MODE_SMALL}, {@link #MODE_MEDIUM}, or
 *            {@link #MODE_LARGE}, indicating the desired dialog size,
 *            when supported.
 * @param excludeMimes Optional list of {@link android.provider.ContactsContract.Data#MIMETYPE Data#MIMETYPE} MIME-types
 *            to exclude when showing this dialog. For example, when
 *            already viewing the contact details card, this can be used
 *            to omit the details entry from the dialog.
 * @apiSince 5
 */

public static void showQuickContact(android.content.Context context, android.graphics.Rect target, android.net.Uri lookupUri, int mode, java.lang.String[] excludeMimes) { throw new RuntimeException("Stub!"); }

/**
 * Trigger a dialog that lists the various methods of interacting with
 * the requested {@link android.provider.ContactsContract.Contacts Contacts} entry. This may be based on available
 * {@link android.provider.ContactsContract.Data ContactsContract.Data} rows under that contact, and may also
 * include social status and presence details.
 *
 * @param context The parent {@link android.content.Context Context} that may be used as the
 *            parent for this dialog.
 * @param target Specific {@link android.view.View View} from your layout that this dialog
 *            should be centered around. In particular, if the dialog
 *            has a "callout" arrow, it will be pointed and centered
 *            around this {@link android.view.View View}.
 * @param lookupUri A
 *            {@link android.provider.ContactsContract.Contacts#CONTENT_LOOKUP_URI ContactsContract.Contacts#CONTENT_LOOKUP_URI} style
 *            {@link android.net.Uri Uri} that describes a specific contact to feature
 *            in this dialog. A work lookup uri is supported here,
 *            see {@link CommonDataKinds.Email#ENTERPRISE_CONTENT_LOOKUP_URI} and
 *            {@link android.provider.ContactsContract.PhoneLookup#ENTERPRISE_CONTENT_FILTER_URI PhoneLookup#ENTERPRISE_CONTENT_FILTER_URI}.
 * @param excludeMimes Optional list of {@link android.provider.ContactsContract.Data#MIMETYPE Data#MIMETYPE} MIME-types
 *            to exclude when showing this dialog. For example, when
 *            already viewing the contact details card, this can be used
 *            to omit the details entry from the dialog.
 * @param prioritizedMimeType This mimetype should be prioritized in the QuickContacts UI.
 *             For example, passing the value
 *             {@link CommonDataKinds.Phone#CONTENT_ITEM_TYPE} can cause phone numbers to be
 *             displayed more prominently in QuickContacts.
 * @apiSince 23
 */

public static void showQuickContact(android.content.Context context, android.view.View target, android.net.Uri lookupUri, java.lang.String[] excludeMimes, java.lang.String prioritizedMimeType) { throw new RuntimeException("Stub!"); }

/**
 * Trigger a dialog that lists the various methods of interacting with
 * the requested {@link android.provider.ContactsContract.Contacts Contacts} entry. This may be based on available
 * {@link android.provider.ContactsContract.Data ContactsContract.Data} rows under that contact, and may also
 * include social status and presence details.
 *
 * @param context The parent {@link android.content.Context Context} that may be used as the
 *            parent for this dialog.
 * @param target Specific {@link android.graphics.Rect Rect} that this dialog should be
 *            centered around, in screen coordinates. In particular, if
 *            the dialog has a "callout" arrow, it will be pointed and
 *            centered around this {@link android.graphics.Rect Rect}. If you are running at a
 *            non-native density, you need to manually adjust using
 *            {@link android.util.DisplayMetrics#density DisplayMetrics#density} before calling.
 * @param lookupUri A
 *            {@link android.provider.ContactsContract.Contacts#CONTENT_LOOKUP_URI ContactsContract.Contacts#CONTENT_LOOKUP_URI} style
 *            {@link android.net.Uri Uri} that describes a specific contact to feature
 *            in this dialog. A work lookup uri is supported here,
 *            see {@link CommonDataKinds.Email#ENTERPRISE_CONTENT_LOOKUP_URI} and
 *            {@link android.provider.ContactsContract.PhoneLookup#ENTERPRISE_CONTENT_FILTER_URI PhoneLookup#ENTERPRISE_CONTENT_FILTER_URI}.
 * @param excludeMimes Optional list of {@link android.provider.ContactsContract.Data#MIMETYPE Data#MIMETYPE} MIME-types
 *            to exclude when showing this dialog. For example, when
 *            already viewing the contact details card, this can be used
 *            to omit the details entry from the dialog.
 * @param prioritizedMimeType This mimetype should be prioritized in the QuickContacts UI.
 *             For example, passing the value
 *             {@link CommonDataKinds.Phone#CONTENT_ITEM_TYPE} can cause phone numbers to be
 *             displayed more prominently in QuickContacts.
 * @apiSince 23
 */

public static void showQuickContact(android.content.Context context, android.graphics.Rect target, android.net.Uri lookupUri, java.lang.String[] excludeMimes, java.lang.String prioritizedMimeType) { throw new RuntimeException("Stub!"); }

/**
 * Action used to launch the system contacts application and bring up a QuickContact dialog
 * for the provided {@link android.provider.ContactsContract.Contacts Contacts} entry.
 * @apiSince 21
 */

public static final java.lang.String ACTION_QUICK_CONTACT = "android.provider.action.QUICK_CONTACT";

/**
 * Extra used to indicate a list of specific MIME-types to exclude and not display in the
 * QuickContacts dialog. Stored as a {@link java.lang.String String} array.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_EXCLUDE_MIMES = "android.provider.extra.EXCLUDE_MIMES";

/**
 * Extra used to specify size of QuickContacts. Not all implementations of QuickContacts
 * will respect this extra's value.
 *
 * One of {@link #MODE_SMALL}, {@link #MODE_MEDIUM}, or {@link #MODE_LARGE}.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_MODE = "android.provider.extra.MODE";

/**
 * Extra used to specify which mimetype should be prioritized in the QuickContacts UI.
 * For example, passing the value {@link CommonDataKinds.Phone#CONTENT_ITEM_TYPE} can
 * cause phone numbers to be displayed more prominently in QuickContacts.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_PRIORITIZED_MIMETYPE = "android.provider.extra.PRIORITIZED_MIMETYPE";

/**
 * Large QuickContact mode, includes actions and larger, card-like summary
 * of the {@link android.provider.ContactsContract.Contacts Contacts} entry being shown. This may include detailed
 * information, such as a photo.
 * @apiSince 5
 */

public static final int MODE_LARGE = 3; // 0x3

/**
 * Medium QuickContact mode, includes actions and light summary describing
 * the {@link android.provider.ContactsContract.Contacts Contacts} entry being shown. This may include social
 * status and presence details.
 * @apiSince 5
 */

public static final int MODE_MEDIUM = 2; // 0x2

/**
 * Small QuickContact mode, usually presented with minimal actions.
 * @apiSince 5
 */

public static final int MODE_SMALL = 1; // 0x1
}

/**
 * Constants for the raw contacts table, which contains one row of contact
 * information for each person in each synced account. Sync adapters and
 * contact management apps
 * are the primary consumers of this API.
 *
 * <h3>Aggregation</h3>
 * <p>
 * As soon as a raw contact is inserted or whenever its constituent data
 * changes, the provider will check if the raw contact matches other
 * existing raw contacts and if so will aggregate it with those. The
 * aggregation is reflected in the {@link android.provider.ContactsContract.RawContacts RawContacts} table by the change of the
 * {@link #CONTACT_ID} field, which is the reference to the aggregate contact.
 * </p>
 * <p>
 * Changes to the structured name, organization, phone number, email address,
 * or nickname trigger a re-aggregation.
 * </p>
 * <p>
 * See also {@link android.provider.ContactsContract.AggregationExceptions AggregationExceptions} for a mechanism to control
 * aggregation programmatically.
 * </p>
 *
 * <h3>Operations</h3>
 * <dl>
 * <dt><b>Insert</b></dt>
 * <dd>
 * <p>
 * Raw contacts can be inserted incrementally or in a batch.
 * The incremental method is more traditional but less efficient.
 * It should be used
 * only if no {@link android.provider.ContactsContract.RawContacts.Data Data} values are available at the time the raw contact is created:
 * <pre>
 * ContentValues values = new ContentValues();
 * values.put(RawContacts.ACCOUNT_TYPE, accountType);
 * values.put(RawContacts.ACCOUNT_NAME, accountName);
 * Uri rawContactUri = getContentResolver().insert(RawContacts.CONTENT_URI, values);
 * long rawContactId = ContentUris.parseId(rawContactUri);
 * </pre>
 * </p>
 * <p>
 * Once {@link android.provider.ContactsContract.RawContacts.Data Data} values become available, insert those.
 * For example, here's how you would insert a name:
 *
 * <pre>
 * values.clear();
 * values.put(Data.RAW_CONTACT_ID, rawContactId);
 * values.put(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
 * values.put(StructuredName.DISPLAY_NAME, &quot;Mike Sullivan&quot;);
 * getContentResolver().insert(Data.CONTENT_URI, values);
 * </pre>
 * </p>
 * <p>
 * The batch method is by far preferred.  It inserts the raw contact and its
 * constituent data rows in a single database transaction
 * and causes at most one aggregation pass.
 * <pre>
 * ArrayList&lt;ContentProviderOperation&gt; ops =
 *          new ArrayList&lt;ContentProviderOperation&gt;();
 * ...
 * int rawContactInsertIndex = ops.size();
 * ops.add(ContentProviderOperation.newInsert(RawContacts.CONTENT_URI)
 *          .withValue(RawContacts.ACCOUNT_TYPE, accountType)
 *          .withValue(RawContacts.ACCOUNT_NAME, accountName)
 *          .build());
 *
 * ops.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
 *          .withValueBackReference(Data.RAW_CONTACT_ID, rawContactInsertIndex)
 *          .withValue(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE)
 *          .withValue(StructuredName.DISPLAY_NAME, &quot;Mike Sullivan&quot;)
 *          .build());
 *
 * getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
 * </pre>
 * </p>
 * <p>
 * Note the use of {@link android.content.ContentProviderOperation.Builder#withValueBackReference(java.lang.String,int) ContentProviderOperation.Builder#withValueBackReference(String, int)}
 * to refer to the as-yet-unknown index value of the raw contact inserted in the
 * first operation.
 * </p>
 *
 * <dt><b>Update</b></dt>
 * <dd><p>
 * Raw contacts can be updated incrementally or in a batch.
 * Batch mode should be used whenever possible.
 * The procedures and considerations are analogous to those documented above for inserts.
 * </p></dd>
 * <dt><b>Delete</b></dt>
 * <dd><p>When a raw contact is deleted, all of its Data rows as well as StatusUpdates,
 * AggregationExceptions, PhoneLookup rows are deleted automatically. When all raw
 * contacts associated with a {@link android.provider.ContactsContract.Contacts Contacts} row are deleted, the {@link android.provider.ContactsContract.Contacts Contacts} row
 * itself is also deleted automatically.
 * </p>
 * <p>
 * The invocation of {@code resolver.delete(...)}, does not immediately delete
 * a raw contacts row.
 * Instead, it sets the {@link #DELETED} flag on the raw contact and
 * removes the raw contact from its aggregate contact.
 * The sync adapter then deletes the raw contact from the server and
 * finalizes phone-side deletion by calling {@code resolver.delete(...)}
 * again and passing the {@link android.provider.ContactsContract#CALLER_IS_SYNCADAPTER ContactsContract#CALLER_IS_SYNCADAPTER} query parameter.<p>
 * <p>Some sync adapters are read-only, meaning that they only sync server-side
 * changes to the phone, but not the reverse.  If one of those raw contacts
 * is marked for deletion, it will remain on the phone.  However it will be
 * effectively invisible, because it will not be part of any aggregate contact.
 * </dd>
 *
 * <dt><b>Query</b></dt>
 * <dd>
 * <p>
 * It is easy to find all raw contacts in a Contact:
 * <pre>
 * Cursor c = getContentResolver().query(RawContacts.CONTENT_URI,
 *          new String[]{RawContacts._ID},
 *          RawContacts.CONTACT_ID + "=?",
 *          new String[]{String.valueOf(contactId)}, null);
 * </pre>
 * </p>
 * <p>
 * To find raw contacts within a specific account,
 * you can either put the account name and type in the selection or pass them as query
 * parameters.  The latter approach is preferable, especially when you can reuse the
 * URI:
 * <pre>
 * Uri rawContactUri = RawContacts.CONTENT_URI.buildUpon()
 *          .appendQueryParameter(RawContacts.ACCOUNT_NAME, accountName)
 *          .appendQueryParameter(RawContacts.ACCOUNT_TYPE, accountType)
 *          .build();
 * Cursor c1 = getContentResolver().query(rawContactUri,
 *          RawContacts.STARRED + "&lt;&gt;0", null, null, null);
 * ...
 * Cursor c2 = getContentResolver().query(rawContactUri,
 *          RawContacts.DELETED + "&lt;&gt;0", null, null, null);
 * </pre>
 * </p>
 * <p>The best way to read a raw contact along with all the data associated with it is
 * by using the {@link android.provider.ContactsContract.RawContacts.Entity Entity} directory. If the raw contact has data rows,
 * the Entity cursor will contain a row for each data row.  If the raw contact has no
 * data rows, the cursor will still contain one row with the raw contact-level information.
 * <pre>
 * Uri rawContactUri = ContentUris.withAppendedId(RawContacts.CONTENT_URI, rawContactId);
 * Uri entityUri = Uri.withAppendedPath(rawContactUri, Entity.CONTENT_DIRECTORY);
 * Cursor c = getContentResolver().query(entityUri,
 *          new String[]{RawContacts.SOURCE_ID, Entity.DATA_ID, Entity.MIMETYPE, Entity.DATA1},
 *          null, null, null);
 * try {
 *     while (c.moveToNext()) {
 *         String sourceId = c.getString(0);
 *         if (!c.isNull(1)) {
 *             String mimeType = c.getString(2);
 *             String data = c.getString(3);
 *             ...
 *         }
 *     }
 * } finally {
 *     c.close();
 * }
 * </pre>
 * </p>
 * </dd>
 * </dl>
 * <h2>Columns</h2>
 *
 * <table class="jd-sumtable">
 * <tr>
 * <th colspan='4'>RawContacts</th>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #_ID}</td>
 * <td>read-only</td>
 * <td>Row ID. Sync adapters should try to preserve row IDs during updates. In other words,
 * it is much better for a sync adapter to update a raw contact rather than to delete and
 * re-insert it.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #CONTACT_ID}</td>
 * <td>read-only</td>
 * <td>The ID of the row in the {@link android.provider.ContactsContract.Contacts ContactsContract.Contacts} table
 * that this raw contact belongs
 * to. Raw contacts are linked to contacts by the aggregation process, which can be controlled
 * by the {@link #AGGREGATION_MODE} field and {@link android.provider.ContactsContract.AggregationExceptions AggregationExceptions}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #AGGREGATION_MODE}</td>
 * <td>read/write</td>
 * <td>A mechanism that allows programmatic control of the aggregation process. The allowed
 * values are {@link #AGGREGATION_MODE_DEFAULT}, {@link #AGGREGATION_MODE_DISABLED}
 * and {@link #AGGREGATION_MODE_SUSPENDED}. See also {@link android.provider.ContactsContract.AggregationExceptions AggregationExceptions}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #DELETED}</td>
 * <td>read/write</td>
 * <td>The "deleted" flag: "0" by default, "1" if the row has been marked
 * for deletion. When {@link android.content.ContentResolver#delete} is
 * called on a raw contact, it is marked for deletion and removed from its
 * aggregate contact. The sync adaptor deletes the raw contact on the server and
 * then calls ContactResolver.delete once more, this time passing the
 * {@link android.provider.ContactsContract#CALLER_IS_SYNCADAPTER ContactsContract#CALLER_IS_SYNCADAPTER} query parameter to finalize
 * the data removal.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #STARRED}</td>
 * <td>read/write</td>
 * <td>An indicator for favorite contacts: '1' if favorite, '0' otherwise.
 * Changing this field immediately affects the corresponding aggregate contact:
 * if any raw contacts in that aggregate contact are starred, then the contact
 * itself is marked as starred.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #CUSTOM_RINGTONE}</td>
 * <td>read/write</td>
 * <td>A custom ringtone associated with a raw contact. Typically this is the
 * URI returned by an activity launched with the
 * {@link android.media.RingtoneManager#ACTION_RINGTONE_PICKER} intent.
 * To have an effect on the corresponding value of the aggregate contact, this field
 * should be set at the time the raw contact is inserted. To set a custom
 * ringtone on a contact, use the field {@link android.provider.ContactsContract.Contacts#CUSTOM_RINGTONE ContactsContract.Contacts#CUSTOM_RINGTONE}
 * instead.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #SEND_TO_VOICEMAIL}</td>
 * <td>read/write</td>
 * <td>An indicator of whether calls from this raw contact should be forwarded
 * directly to voice mail ('1') or not ('0'). To have an effect
 * on the corresponding value of the aggregate contact, this field
 * should be set at the time the raw contact is inserted.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #ACCOUNT_NAME}</td>
 * <td>read/write-once</td>
 * <td>The name of the account instance to which this row belongs, which when paired with
 * {@link #ACCOUNT_TYPE} identifies a specific account.
 * For example, this will be the Gmail address if it is a Google account.
 * It should be set at the time the raw contact is inserted and never
 * changed afterwards.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #ACCOUNT_TYPE}</td>
 * <td>read/write-once</td>
 * <td>
 * <p>
 * The type of account to which this row belongs, which when paired with
 * {@link #ACCOUNT_NAME} identifies a specific account.
 * It should be set at the time the raw contact is inserted and never
 * changed afterwards.
 * </p>
 * <p>
 * To ensure uniqueness, new account types should be chosen according to the
 * Java package naming convention.  Thus a Google account is of type "com.google".
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #DATA_SET}</td>
 * <td>read/write-once</td>
 * <td>
 * <p>
 * The data set within the account that this row belongs to.  This allows
 * multiple sync adapters for the same account type to distinguish between
 * each others' data.  The combination of {@link #ACCOUNT_TYPE},
 * {@link #ACCOUNT_NAME}, and {@link #DATA_SET} identifies a set of data
 * that is associated with a single sync adapter.
 * </p>
 * <p>
 * This is empty by default, and is completely optional.  It only needs to
 * be populated if multiple sync adapters are entering distinct data for
 * the same account type and account name.
 * </p>
 * <p>
 * It should be set at the time the raw contact is inserted and never
 * changed afterwards.
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #SOURCE_ID}</td>
 * <td>read/write</td>
 * <td>String that uniquely identifies this row to its source account.
 * Typically it is set at the time the raw contact is inserted and never
 * changed afterwards. The one notable exception is a new raw contact: it
 * will have an account name and type (and possibly a data set), but no
 * source id. This indicates to the sync adapter that a new contact needs
 * to be created server-side and its ID stored in the corresponding
 * SOURCE_ID field on the phone.
 * </td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #VERSION}</td>
 * <td>read-only</td>
 * <td>Version number that is updated whenever this row or its related data
 * changes. This field can be used for optimistic locking of a raw contact.
 * </td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #DIRTY}</td>
 * <td>read/write</td>
 * <td>Flag indicating that {@link #VERSION} has changed, and this row needs
 * to be synchronized by its owning account.  The value is set to "1" automatically
 * whenever the raw contact changes, unless the URI has the
 * {@link android.provider.ContactsContract#CALLER_IS_SYNCADAPTER ContactsContract#CALLER_IS_SYNCADAPTER} query parameter specified.
 * The sync adapter should always supply this query parameter to prevent
 * unnecessary synchronization: user changes some data on the server,
 * the sync adapter updates the contact on the phone (without the
 * CALLER_IS_SYNCADAPTER flag) flag, which sets the DIRTY flag,
 * which triggers a sync to bring the changes to the server.
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #SYNC1}</td>
 * <td>read/write</td>
 * <td>Generic column provided for arbitrary use by sync adapters.
 * The content provider
 * stores this information on behalf of the sync adapter but does not
 * interpret it in any way.
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #SYNC2}</td>
 * <td>read/write</td>
 * <td>Generic column for use by sync adapters.
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #SYNC3}</td>
 * <td>read/write</td>
 * <td>Generic column for use by sync adapters.
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #SYNC4}</td>
 * <td>read/write</td>
 * <td>Generic column for use by sync adapters.
 * </td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class RawContacts implements android.provider.BaseColumns, android.provider.ContactsContract.RawContactsColumns, android.provider.ContactsContract.ContactOptionsColumns, android.provider.ContactsContract.ContactNameColumns, android.provider.ContactsContract.SyncColumns {

private RawContacts() { throw new RuntimeException("Stub!"); }

/**
 * Build a {@link android.provider.ContactsContract.Contacts#CONTENT_LOOKUP_URI}
 * style {@link android.net.Uri Uri} for the parent {@link android.provider.ContactsContract.Contacts}
 * entry of the given {@link android.provider.ContactsContract.RawContacts RawContacts} entry.
 * @apiSince 5
 */

public static android.net.Uri getContactLookupUri(android.content.ContentResolver resolver, android.net.Uri rawContactUri) { throw new RuntimeException("Stub!"); }

/**
 * TODO: javadoc
 * @param cursor
 * @return
 * @apiSince 8
 */

public static android.content.EntityIterator newEntityIterator(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * Aggregation mode: aggregate immediately after insert or update operation(s) are complete.
 * @apiSince 5
 */

public static final int AGGREGATION_MODE_DEFAULT = 0; // 0x0

/**
 * <p>
 * Aggregation mode: never aggregate this raw contact.  The raw contact will not
 * have a corresponding {@link android.provider.ContactsContract.Contacts Contacts} aggregate and therefore will not be included in
 * {@link android.provider.ContactsContract.Contacts Contacts} query results.
 * </p>
 * <p>
 * For example, this mode can be used for a raw contact that is marked for deletion while
 * waiting for the deletion to occur on the server side.
 * </p>
 *
 * @see #AGGREGATION_MODE_SUSPENDED
 * @apiSince 5
 */

public static final int AGGREGATION_MODE_DISABLED = 3; // 0x3

/**
 * Aggregation mode: aggregate at the time the raw contact is inserted/updated.
 * @deprecated Aggregation is synchronous, this historic value is a no-op
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated public static final int AGGREGATION_MODE_IMMEDIATE = 1; // 0x1

/**
 * <p>
 * Aggregation mode: aggregation suspended temporarily, and is likely to be resumed later.
 * Changes to the raw contact will update the associated aggregate contact but will not
 * result in any change in how the contact is aggregated. Similar to
 * {@link #AGGREGATION_MODE_DISABLED}, but maintains a link to the corresponding
 * {@link android.provider.ContactsContract.Contacts Contacts} aggregate.
 * </p>
 * <p>
 * This can be used to postpone aggregation until after a series of updates, for better
 * performance and/or user experience.
 * </p>
 * <p>
 * Note that changing
 * {@link #AGGREGATION_MODE} from {@link #AGGREGATION_MODE_SUSPENDED} to
 * {@link #AGGREGATION_MODE_DEFAULT} does not trigger an aggregation pass, but any
 * subsequent
 * change to the raw contact's data will.
 * </p>
 * @apiSince 5
 */

public static final int AGGREGATION_MODE_SUSPENDED = 2; // 0x2

/**
 * The MIME type of the results when a raw contact ID is appended to {@link #CONTENT_URI},
 * yielding a subdirectory of a single person.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/raw_contact";

/**
 * The MIME type of the results from {@link #CONTENT_URI} when a specific
 * ID value is not provided, and multiple raw contacts may be returned.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/raw_contact";

/**
 * The content:// style URI for this table, which requests a directory of
 * raw contact rows matching the selection criteria.
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }
/**
 * A sub-directory of a single raw contact that contains all of its
 * {@link android.provider.ContactsContract.Data ContactsContract.Data} rows. To access this directory
 * append {@link android.provider.ContactsContract.RawContacts.Data#CONTENT_DIRECTORY Data#CONTENT_DIRECTORY} to the raw contact URI.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Data implements android.provider.BaseColumns, android.provider.ContactsContract.DataColumns {

private Data() { throw new RuntimeException("Stub!"); }

/**
 * The directory twig for this sub-table
 * @apiSince 5
 */

public static final java.lang.String CONTENT_DIRECTORY = "data";
}

/**
 * <p>
 * A sub-directory of a single raw contact that represents its primary
 * display photo.  To access this directory append
 * {@link RawContacts.DisplayPhoto#CONTENT_DIRECTORY} to the raw contact URI.
 * The resulting URI represents an image file, and should be interacted with
 * using ContentResolver.openAssetFileDescriptor.
 * <p>
 * <p>
 * Note that this sub-directory also supports opening the photo as an asset file
 * in write mode.  Callers can create or replace the primary photo associated
 * with this raw contact by opening the asset file and writing the full-size
 * photo contents into it.  When the file is closed, the image will be parsed,
 * sized down if necessary for the full-size display photo and thumbnail
 * dimensions, and stored.
 * </p>
 * <p>
 * Usage example:
 * <pre>
 * public void writeDisplayPhoto(long rawContactId, byte[] photo) {
 *     Uri rawContactPhotoUri = Uri.withAppendedPath(
 *             ContentUris.withAppendedId(RawContacts.CONTENT_URI, rawContactId),
 *             RawContacts.DisplayPhoto.CONTENT_DIRECTORY);
 *     try {
 *         AssetFileDescriptor fd =
 *             getContentResolver().openAssetFileDescriptor(rawContactPhotoUri, "rw");
 *         OutputStream os = fd.createOutputStream();
 *         os.write(photo);
 *         os.close();
 *         fd.close();
 *     } catch (IOException e) {
 *         // Handle error cases.
 *     }
 * }
 * </pre>
 * </p>
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class DisplayPhoto {

private DisplayPhoto() { throw new RuntimeException("Stub!"); }

/**
 * The directory twig for this sub-table
 * @apiSince 14
 */

public static final java.lang.String CONTENT_DIRECTORY = "display_photo";
}

/**
 * <p>
 * A sub-directory of a single raw contact that contains all of its
 * {@link android.provider.ContactsContract.Data ContactsContract.Data} rows. To access this directory append
 * {@link RawContacts.Entity#CONTENT_DIRECTORY} to the raw contact URI. See
 * {@link android.provider.ContactsContract.RawContactsEntity RawContactsEntity} for a stand-alone table containing the same
 * data.
 * </p>
 * <p>
 * Entity has two ID fields: {@link #_ID} for the raw contact
 * and {@link #DATA_ID} for the data rows.
 * Entity always contains at least one row, even if there are no
 * actual data rows. In this case the {@link #DATA_ID} field will be
 * null.
 * </p>
 * <p>
 * Using Entity should be preferred to using two separate queries:
 * RawContacts followed by Data. The reason is that Entity reads all
 * data for a raw contact in one transaction, so there is no possibility
 * of the data changing between the two queries.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Entity implements android.provider.BaseColumns, android.provider.ContactsContract.DataColumns {

private Entity() { throw new RuntimeException("Stub!"); }

/**
 * The directory twig for this sub-table
 * @apiSince 5
 */

public static final java.lang.String CONTENT_DIRECTORY = "entity";

/**
 * The ID of the data row. The value will be null if this raw contact has no
 * data rows.
 * <P>Type: INTEGER</P>
 * @apiSince 5
 */

public static final java.lang.String DATA_ID = "data_id";
}

}

/** @apiSince 5 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface RawContactsColumns {

/**
 * A concatenation of the account type and data set (delimited by a forward
 * slash) - if the data set is empty, this will be the same as the account
 * type.  For applications that need to be aware of the data set, this can
 * be used instead of account type to distinguish sets of data.  This is
 * never intended to be used for specifying accounts.
 * <p>
 * This column does *not* escape forward slashes in the account type or the data set.
 * If this is an issue, consider using
 * {@link android.provider.ContactsContract.RawContacts#ACCOUNT_TYPE ContactsContract.RawContacts#ACCOUNT_TYPE} and
 * {@link android.provider.ContactsContract.RawContacts#DATA_SET ContactsContract.RawContacts#DATA_SET} directly.
 * @apiSince 21
 */

public static final java.lang.String ACCOUNT_TYPE_AND_DATA_SET = "account_type_and_data_set";

/**
 * The aggregation mode for this contact.
 * <P>Type: INTEGER</P>
 * @apiSince 5
 */

public static final java.lang.String AGGREGATION_MODE = "aggregation_mode";

/**
 * Persistent unique id for each raw_contact within its account.
 * This id is provided by its own data source, and can be used to backup metadata
 * to the server.
 * This should be unique within each set of account_name/account_type/data_set
 * @apiSince 24
 */

public static final java.lang.String BACKUP_ID = "backup_id";

/**
 * A reference to the {@link android.provider.ContactsContract.Contacts#_ID ContactsContract.Contacts#_ID} that this
 * data belongs to.
 * <P>Type: INTEGER</P>
 * @apiSince 5
 */

public static final java.lang.String CONTACT_ID = "contact_id";

/**
 * The data set within the account that this row belongs to.  This allows
 * multiple sync adapters for the same account type to distinguish between
 * each others' data.
 *
 * This is empty by default, and is completely optional.  It only needs to
 * be populated if multiple sync adapters are entering distinct data for
 * the same account type and account name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String DATA_SET = "data_set";

/**
 * The "deleted" flag: "0" by default, "1" if the row has been marked
 * for deletion. When {@link android.content.ContentResolver#delete} is
 * called on a raw contact, it is marked for deletion and removed from its
 * aggregate contact. The sync adaptor deletes the raw contact on the server and
 * then calls ContactResolver.delete once more, this time passing the
 * {@link android.provider.ContactsContract#CALLER_IS_SYNCADAPTER ContactsContract#CALLER_IS_SYNCADAPTER} query parameter to finalize
 * the data removal.
 * <P>Type: INTEGER</P>
 * @apiSince 5
 */

public static final java.lang.String DELETED = "deleted";

/**
 * Flag indicating that a raw contact's metadata has changed, and its metadata
 * needs to be synchronized by the server.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 24
 */

public static final java.lang.String METADATA_DIRTY = "metadata_dirty";

/**
 * The "read-only" flag: "0" by default, "1" if the row cannot be modified or
 * deleted except by a sync adapter.  See {@link android.provider.ContactsContract#CALLER_IS_SYNCADAPTER ContactsContract#CALLER_IS_SYNCADAPTER}.
 * <P>Type: INTEGER</P>
 * @apiSince 11
 */

public static final java.lang.String RAW_CONTACT_IS_READ_ONLY = "raw_contact_is_read_only";

/**
 * Flag that reflects whether this raw contact belongs to the user's
 * personal profile entry.
 * @apiSince 14
 */

public static final java.lang.String RAW_CONTACT_IS_USER_PROFILE = "raw_contact_is_user_profile";
}

/**
 * <p>
 * Constants for the raw contacts entities table, which can be thought of as
 * an outer join of the raw_contacts table with the data table.  It is a strictly
 * read-only table.
 * </p>
 * <p>
 * If a raw contact has data rows, the RawContactsEntity cursor will contain
 * a one row for each data row. If the raw contact has no data rows, the
 * cursor will still contain one row with the raw contact-level information
 * and nulls for data columns.
 *
 * <pre>
 * Uri entityUri = ContentUris.withAppendedId(RawContactsEntity.CONTENT_URI, rawContactId);
 * Cursor c = getContentResolver().query(entityUri,
 *          new String[]{
 *              RawContactsEntity.SOURCE_ID,
 *              RawContactsEntity.DATA_ID,
 *              RawContactsEntity.MIMETYPE,
 *              RawContactsEntity.DATA1
 *          }, null, null, null);
 * try {
 *     while (c.moveToNext()) {
 *         String sourceId = c.getString(0);
 *         if (!c.isNull(1)) {
 *             String mimeType = c.getString(2);
 *             String data = c.getString(3);
 *             ...
 *         }
 *     }
 * } finally {
 *     c.close();
 * }
 * </pre>
 *
 * <h3>Columns</h3>
 * RawContactsEntity has a combination of RawContact and Data columns.
 *
 * <table class="jd-sumtable">
 * <tr>
 * <th colspan='4'>RawContacts</th>
 * </tr>
 * <tr>
 * <td style="width: 7em;">long</td>
 * <td style="width: 20em;">{@link #_ID}</td>
 * <td style="width: 5em;">read-only</td>
 * <td>Raw contact row ID. See {@link android.provider.ContactsContract.RawContacts RawContacts}.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #CONTACT_ID}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.RawContacts RawContacts}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #AGGREGATION_MODE}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.RawContacts RawContacts}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #DELETED}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.RawContacts RawContacts}.</td>
 * </tr>
 * </table>
 *
 * <table class="jd-sumtable">
 * <tr>
 * <th colspan='4'>Data</th>
 * </tr>
 * <tr>
 * <td style="width: 7em;">long</td>
 * <td style="width: 20em;">{@link #DATA_ID}</td>
 * <td style="width: 5em;">read-only</td>
 * <td>Data row ID. It will be null if the raw contact has no data rows.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #MIMETYPE}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Data ContactsContract.Data}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #IS_PRIMARY}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Data ContactsContract.Data}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #IS_SUPER_PRIMARY}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Data ContactsContract.Data}.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #DATA_VERSION}</td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Data ContactsContract.Data}.</td>
 * </tr>
 * <tr>
 * <td>Any type</td>
 * <td>
 * {@link #DATA1}<br>
 * {@link #DATA2}<br>
 * {@link #DATA3}<br>
 * {@link #DATA4}<br>
 * {@link #DATA5}<br>
 * {@link #DATA6}<br>
 * {@link #DATA7}<br>
 * {@link #DATA8}<br>
 * {@link #DATA9}<br>
 * {@link #DATA10}<br>
 * {@link #DATA11}<br>
 * {@link #DATA12}<br>
 * {@link #DATA13}<br>
 * {@link #DATA14}<br>
 * {@link #DATA15}
 * </td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Data ContactsContract.Data}.</td>
 * </tr>
 * <tr>
 * <td>Any type</td>
 * <td>
 * {@link #SYNC1}<br>
 * {@link #SYNC2}<br>
 * {@link #SYNC3}<br>
 * {@link #SYNC4}
 * </td>
 * <td>read-only</td>
 * <td>See {@link android.provider.ContactsContract.Data ContactsContract.Data}.</td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class RawContactsEntity implements android.provider.BaseColumns, android.provider.ContactsContract.DataColumns, android.provider.ContactsContract.RawContactsColumns {

private RawContactsEntity() { throw new RuntimeException("Stub!"); }

/**
 * The MIME type of {@link #CONTENT_URI} providing a directory of raw contact entities.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/raw_contact_entity";

/**
 * The content:// style URI for this table
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The ID of the data column. The value will be null if this raw contact has no data rows.
 * <P>Type: INTEGER</P>
 * @apiSince 5
 */

public static final java.lang.String DATA_ID = "data_id";

/**
 * The content:// style URI for this table, specific to the user's profile.
 * @apiSince 14
 */

public static final android.net.Uri PROFILE_CONTENT_URI;
static { PROFILE_CONTENT_URI = null; }
}

/**
 * Additional column returned by
 * {@link android.provider.ContactsContract.Contacts#CONTENT_FILTER_URI ContactsContract.Contacts#CONTENT_FILTER_URI} explaining
 * why the filter matched the contact. This column will contain extracts from the contact's
 * constituent {@link android.provider.ContactsContract.Data Data} items, formatted in a way that indicates the section of the
 * snippet that matched the filter.
 *
 * <p>
 * The following example searches for all contacts that match the query "presi" and requests
 * the snippet column as well.
 * <pre>
 * Builder builder = Contacts.CONTENT_FILTER_URI.buildUpon();
 * builder.appendPath("presi");
 * // Defer snippeting to the client side if possible, for performance reasons.
 * builder.appendQueryParameter(SearchSnippets.DEFERRED_SNIPPETING_KEY,"1");
 *
 * Cursor cursor = getContentResolver().query(builder.build());
 *
 * Bundle extras = cursor.getExtras();
 * if (extras.getBoolean(ContactsContract.DEFERRED_SNIPPETING)) {
 *     // Do our own snippet formatting.
 *     // For a contact with the email address (president@organization.com), the snippet
 *     // column will contain the string "president@organization.com".
 * } else {
 *     // The snippet has already been pre-formatted, we can display it as is.
 *     // For a contact with the email address (president@organization.com), the snippet
 *     // column will contain the string "[presi]dent@organization.com".
 * }
 * </pre>
 * </p>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class SearchSnippets {

public SearchSnippets() { throw new RuntimeException("Stub!"); }

/**
 * The key to ask the provider to defer the formatting of the snippet to the client if
 * possible, for performance reasons.
 * A value of 1 indicates true, 0 indicates false. False is the default.
 * When a cursor is returned to the client, it should check for an extra with the name
 * {@link android.provider.ContactsContract#DEFERRED_SNIPPETING ContactsContract#DEFERRED_SNIPPETING} in the cursor. If it exists, the client
 * should do its own formatting of the snippet. If it doesn't exist, the snippet column
 * in the cursor should already contain a formatted snippet.
 * @apiSince 21
 */

public static final java.lang.String DEFERRED_SNIPPETING_KEY = "deferred_snippeting";

/**
 * The search snippet constructed by SQLite snippeting functionality.
 * <p>
 * The snippet may contain (parts of) several data elements belonging to the contact,
 * with the matching parts optionally surrounded by special characters that indicate the
 * start and end of matching text.
 *
 * For example, if a contact has an address "123 Main Street", using a filter "mai" would
 * return the formatted snippet "123 [Mai]n street".
 *
 * @see <a href="http://www.sqlite.org/fts3.html#snippet">
 *         http://www.sqlite.org/fts3.html#snippet</a>
 * @apiSince 21
 */

public static final java.lang.String SNIPPET = "snippet";
}

/**
 * <p>
 * Contacts-specific settings for various {@link android.accounts.Account Account}'s.
 * </p>
 * <h2>Columns</h2>
 * <table class="jd-sumtable">
 * <tr>
 * <th colspan='4'>Settings</th>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #ACCOUNT_NAME}</td>
 * <td>read/write-once</td>
 * <td>The name of the account instance to which this row belongs.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #ACCOUNT_TYPE}</td>
 * <td>read/write-once</td>
 * <td>The type of account to which this row belongs, which when paired with
 * {@link #ACCOUNT_NAME} identifies a specific account.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #SHOULD_SYNC}</td>
 * <td>read/write</td>
 * <td>Depending on the mode defined by the sync-adapter, this flag controls
 * the top-level sync behavior for this data source.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #UNGROUPED_VISIBLE}</td>
 * <td>read/write</td>
 * <td>Flag indicating if contacts without any
 * {@link android.provider.ContactsContract.CommonDataKinds.GroupMembership CommonDataKinds.GroupMembership} entries should be visible in any
 * user interface.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #ANY_UNSYNCED}</td>
 * <td>read-only</td>
 * <td>Read-only flag indicating if this {@link #SHOULD_SYNC} or any
 * {@link android.provider.ContactsContract.Groups#SHOULD_SYNC Groups#SHOULD_SYNC} under this account have been marked as
 * unsynced.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #UNGROUPED_COUNT}</td>
 * <td>read-only</td>
 * <td>Read-only count of {@link android.provider.ContactsContract.Contacts Contacts} from a specific source that have
 * no {@link android.provider.ContactsContract.CommonDataKinds.GroupMembership CommonDataKinds.GroupMembership} entries.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #UNGROUPED_WITH_PHONES}</td>
 * <td>read-only</td>
 * <td>Read-only count of {@link android.provider.ContactsContract.Contacts Contacts} from a specific source that have
 * no {@link android.provider.ContactsContract.CommonDataKinds.GroupMembership CommonDataKinds.GroupMembership} entries, and also have phone
 * numbers.</td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Settings implements android.provider.ContactsContract.SettingsColumns {

private Settings() { throw new RuntimeException("Stub!"); }

/**
 * The MIME-type of {@link #CONTENT_URI} providing a single setting.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/setting";

/**
 * The MIME-type of {@link #CONTENT_URI} providing a directory of
 * settings.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/setting";

/**
 * The content:// style URI for this table
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }
}

/**
 * @see android.provider.ContactsContract.Settings
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface SettingsColumns {

/**
 * The name of the account instance to which this row belongs.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String ACCOUNT_NAME = "account_name";

/**
 * The type of account to which this row belongs, which when paired with
 * {@link #ACCOUNT_NAME} identifies a specific account.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String ACCOUNT_TYPE = "account_type";

/**
 * Read-only flag indicating if this {@link #SHOULD_SYNC} or any
 * {@link android.provider.ContactsContract.Groups#SHOULD_SYNC Groups#SHOULD_SYNC} under this account have been marked as
 * unsynced.
 * @apiSince 5
 */

public static final java.lang.String ANY_UNSYNCED = "any_unsynced";

/**
 * The data set within the account that this row belongs to.  This allows
 * multiple sync adapters for the same account type to distinguish between
 * each others' data.
 *
 * This is empty by default, and is completely optional.  It only needs to
 * be populated if multiple sync adapters are entering distinct data for
 * the same account type and account name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String DATA_SET = "data_set";

/**
 * Depending on the mode defined by the sync-adapter, this flag controls
 * the top-level sync behavior for this data source.
 * <p>
 * Type: INTEGER (boolean)
 * @apiSince 5
 */

public static final java.lang.String SHOULD_SYNC = "should_sync";

/**
 * Read-only count of {@link android.provider.ContactsContract.Contacts Contacts} from a specific source that have
 * no {@link android.provider.ContactsContract.CommonDataKinds.GroupMembership CommonDataKinds.GroupMembership} entries.
 * <p>
 * Type: INTEGER
 * @apiSince 5
 */

public static final java.lang.String UNGROUPED_COUNT = "summ_count";

/**
 * Flag indicating if contacts without any {@link android.provider.ContactsContract.CommonDataKinds.GroupMembership CommonDataKinds.GroupMembership}
 * entries should be visible in any user interface.
 * <p>
 * Type: INTEGER (boolean)
 * @apiSince 5
 */

public static final java.lang.String UNGROUPED_VISIBLE = "ungrouped_visible";

/**
 * Read-only count of {@link android.provider.ContactsContract.Contacts Contacts} from a specific source that have
 * no {@link android.provider.ContactsContract.CommonDataKinds.GroupMembership CommonDataKinds.GroupMembership} entries, and also have phone numbers.
 * <p>
 * Type: INTEGER
 * @apiSince 5
 */

public static final java.lang.String UNGROUPED_WITH_PHONES = "summ_phones";
}

/**
 * Social status update columns.
 *
 * @see android.provider.ContactsContract.StatusUpdates
 * @see android.provider.ContactsContract.Data
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface StatusColumns {

/**
 * An allowed value of {@link #PRESENCE}.
 * @apiSince 8
 */

public static final int AVAILABLE = 5; // 0x5

/**
 * An allowed value of {@link #PRESENCE}.
 * @apiSince 8
 */

public static final int AWAY = 2; // 0x2

/**
 * An allowed flag of {@link #CHAT_CAPABILITY}. Indicates that the contact's device has a
 * camera that can be used for video chat (e.g. a front-facing camera on a phone).
 * @apiSince 11
 */

public static final int CAPABILITY_HAS_CAMERA = 4; // 0x4

/**
 * An allowed flag of {@link #CHAT_CAPABILITY}. Indicates that the contact's device can
 * display a video feed.
 * @apiSince 11
 */

public static final int CAPABILITY_HAS_VIDEO = 2; // 0x2

/**
 * An allowed flag of {@link #CHAT_CAPABILITY}. Indicates audio-chat capability (microphone
 * and speaker)
 * @apiSince 11
 */

public static final int CAPABILITY_HAS_VOICE = 1; // 0x1

/**
 * Contact's audio/video chat capability level.
 * <P>Type: INTEGER (one of the values below)</P>
 * @apiSince 11
 */

public static final java.lang.String CHAT_CAPABILITY = "chat_capability";

/**
 * An allowed value of {@link #PRESENCE}.
 * @apiSince 8
 */

public static final int DO_NOT_DISTURB = 4; // 0x4

/**
 * An allowed value of {@link #PRESENCE}.
 * @apiSince 8
 */

public static final int IDLE = 3; // 0x3

/**
 * An allowed value of {@link #PRESENCE}.
 * @apiSince 8
 */

public static final int INVISIBLE = 1; // 0x1

/**
 * An allowed value of {@link #PRESENCE}.
 * @apiSince 8
 */

public static final int OFFLINE = 0; // 0x0

/**
 * Contact's latest presence level.
 * <P>Type: INTEGER (one of the values below)</P>
 * @apiSince 5
 */

public static final java.lang.String PRESENCE = "mode";

/**
 * @deprecated use {@link #STATUS}
 * @apiSince 8
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String PRESENCE_CUSTOM_STATUS = "status";

/**
 * @deprecated use {@link #PRESENCE}
 * @apiSince 8
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String PRESENCE_STATUS = "mode";

/**
 * Contact latest status update.
 * <p>Type: TEXT</p>
 * @apiSince 5
 */

public static final java.lang.String STATUS = "status";

/**
 * The resource ID of the icon for the source of the status update.
 * This resource should be scoped by the {@link #STATUS_RES_PACKAGE}.
 * <p>Type: NUMBER</p>
 * @apiSince 5
 */

public static final java.lang.String STATUS_ICON = "status_icon";

/**
 * The resource ID of the label describing the source of the status update, e.g.&nbsp;"Google
 * Talk".  This resource should be scoped by the {@link #STATUS_RES_PACKAGE}.
 * <p>Type: NUMBER</p>
 * @apiSince 5
 */

public static final java.lang.String STATUS_LABEL = "status_label";

/**
 * The package containing resources for this status: label and icon.
 * <p>Type: TEXT</p>
 * @apiSince 5
 */

public static final java.lang.String STATUS_RES_PACKAGE = "status_res_package";

/**
 * The absolute time in milliseconds when the latest status was inserted/updated.
 * <p>Type: NUMBER</p>
 * @apiSince 5
 */

public static final java.lang.String STATUS_TIMESTAMP = "status_ts";
}

/**
 * <p>
 * A status update is linked to a {@link android.provider.ContactsContract.Data ContactsContract.Data} row and captures
 * the user's latest status update via the corresponding source, e.g.
 * "Having lunch" via "Google Talk".
 * </p>
 * <p>
 * There are two ways a status update can be inserted: by explicitly linking
 * it to a Data row using {@link #DATA_ID} or indirectly linking it to a data row
 * using a combination of {@link #PROTOCOL} (or {@link #CUSTOM_PROTOCOL}) and
 * {@link #IM_HANDLE}.  There is no difference between insert and update, you can use
 * either.
 * </p>
 * <p>
 * Inserting or updating a status update for the user's profile requires either using
 * the {@link #DATA_ID} to identify the data row to attach the update to, or
 * {@link android.provider.ContactsContract.StatusUpdates#PROFILE_CONTENT_URI StatusUpdates#PROFILE_CONTENT_URI} to ensure that the change is scoped to the
 * profile.
 * </p>
 * <p>
 * You cannot use {@link android.content.ContentResolver#update ContentResolver#update} to change a status, but
 * {@link android.content.ContentResolver#insert ContentResolver#insert} will replace the latests status if it already
 * exists.
 * </p>
 * <p>
 * Use {@link android.content.ContentResolver#bulkInsert(android.net.Uri,android.content.ContentValues[]) ContentResolver#bulkInsert(Uri, ContentValues[])} to insert/update statuses
 * for multiple contacts at once.
 * </p>
 *
 * <h3>Columns</h3>
 * <table class="jd-sumtable">
 * <tr>
 * <th colspan='4'>StatusUpdates</th>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #DATA_ID}</td>
 * <td>read/write</td>
 * <td>Reference to the {@link android.provider.ContactsContract.Data#_ID Data#_ID} entry that owns this presence. If this
 * field is <i>not</i> specified, the provider will attempt to find a data row
 * that matches the {@link #PROTOCOL} (or {@link #CUSTOM_PROTOCOL}) and
 * {@link #IM_HANDLE} columns.
 * </td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #PROTOCOL}</td>
 * <td>read/write</td>
 * <td>See {@link android.provider.ContactsContract.CommonDataKinds.Im CommonDataKinds.Im} for a list of defined protocol constants.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #CUSTOM_PROTOCOL}</td>
 * <td>read/write</td>
 * <td>Name of the custom protocol.  Should be supplied along with the {@link #PROTOCOL} value
 * {@link android.provider.ContactsContract.CommonDataKinds.Im#PROTOCOL_CUSTOM ContactsContract.CommonDataKinds.Im#PROTOCOL_CUSTOM}.  Should be null or
 * omitted if {@link #PROTOCOL} value is not
 * {@link android.provider.ContactsContract.CommonDataKinds.Im#PROTOCOL_CUSTOM ContactsContract.CommonDataKinds.Im#PROTOCOL_CUSTOM}.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #IM_HANDLE}</td>
 * <td>read/write</td>
 * <td> The IM handle the presence item is for. The handle is scoped to
 * {@link #PROTOCOL}.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #IM_ACCOUNT}</td>
 * <td>read/write</td>
 * <td>The IM account for the local user that the presence data came from.</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #PRESENCE}</td>
 * <td>read/write</td>
 * <td>Contact IM presence status. The allowed values are:
 * <p>
 * <ul>
 * <li>{@link #OFFLINE}</li>
 * <li>{@link #INVISIBLE}</li>
 * <li>{@link #AWAY}</li>
 * <li>{@link #IDLE}</li>
 * <li>{@link #DO_NOT_DISTURB}</li>
 * <li>{@link #AVAILABLE}</li>
 * </ul>
 * </p>
 * <p>
 * Since presence status is inherently volatile, the content provider
 * may choose not to store this field in long-term storage.
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>{@link #CHAT_CAPABILITY}</td>
 * <td>read/write</td>
 * <td>Contact IM chat compatibility value. The allowed values combinations of the following
 * flags. If None of these flags is set, the device can only do text messaging.
 * <p>
 * <ul>
 * <li>{@link #CAPABILITY_HAS_VIDEO}</li>
 * <li>{@link #CAPABILITY_HAS_VOICE}</li>
 * <li>{@link #CAPABILITY_HAS_CAMERA}</li>
 * </ul>
 * </p>
 * <p>
 * Since chat compatibility is inherently volatile as the contact's availability moves from
 * one device to another, the content provider may choose not to store this field in long-term
 * storage.
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #STATUS}</td>
 * <td>read/write</td>
 * <td>Contact's latest status update, e.g. "having toast for breakfast"</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #STATUS_TIMESTAMP}</td>
 * <td>read/write</td>
 * <td>The absolute time in milliseconds when the status was
 * entered by the user. If this value is not provided, the provider will follow
 * this logic: if there was no prior status update, the value will be left as null.
 * If there was a prior status update, the provider will default this field
 * to the current time.</td>
 * </tr>
 * <tr>
 * <td>String</td>
 * <td>{@link #STATUS_RES_PACKAGE}</td>
 * <td>read/write</td>
 * <td> The package containing resources for this status: label and icon.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #STATUS_LABEL}</td>
 * <td>read/write</td>
 * <td>The resource ID of the label describing the source of contact status,
 * e.g. "Google Talk". This resource is scoped by the
 * {@link #STATUS_RES_PACKAGE}.</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>{@link #STATUS_ICON}</td>
 * <td>read/write</td>
 * <td>The resource ID of the icon for the source of contact status. This
 * resource is scoped by the {@link #STATUS_RES_PACKAGE}.</td>
 * </tr>
 * </table>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class StatusUpdates implements android.provider.ContactsContract.StatusColumns, android.provider.ContactsContract.PresenceColumns {

private StatusUpdates() { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource ID for the proper presence icon.
 *
 * @param status the status to get the icon for
 * @return the resource ID for the proper presence icon
 * @apiSince 5
 */

public static final int getPresenceIconResourceId(int status) { throw new RuntimeException("Stub!"); }

/**
 * Returns the precedence of the status code the higher number being the higher precedence.
 *
 * @param status The status code.
 * @return An integer representing the precedence, 0 being the lowest.
 * @apiSince 5
 */

public static final int getPresencePrecedence(int status) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type of a {@link #CONTENT_URI} subdirectory of a single
 * status update detail.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/status-update";

/**
 * The MIME type of {@link #CONTENT_URI} providing a directory of
 * status update details.
 * @apiSince 5
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/status-update";

/**
 * The content:// style URI for this table
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The content:// style URI for this table, specific to the user's profile.
 * @apiSince 14
 */

public static final android.net.Uri PROFILE_CONTENT_URI;
static { PROFILE_CONTENT_URI = null; }
}

/**
 * Columns that appear when each row of a table belongs to a specific
 * account, including sync information that an account may need.
 *
 * @see android.provider.ContactsContract.RawContacts
 * @see android.provider.ContactsContract.Groups
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface SyncColumns extends android.provider.ContactsContract.BaseSyncColumns {

/**
 * The name of the account instance to which this row belongs, which when paired with
 * {@link #ACCOUNT_TYPE} identifies a specific account.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String ACCOUNT_NAME = "account_name";

/**
 * The type of account to which this row belongs, which when paired with
 * {@link #ACCOUNT_NAME} identifies a specific account.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String ACCOUNT_TYPE = "account_type";

/**
 * Flag indicating that {@link #VERSION} has changed, and this row needs
 * to be synchronized by its owning account.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 5
 */

public static final java.lang.String DIRTY = "dirty";

/**
 * String that uniquely identifies this row to its source account.
 * <P>Type: TEXT</P>
 * @apiSince 5
 */

public static final java.lang.String SOURCE_ID = "sourceid";

/**
 * Version number that is updated whenever this row or its related data
 * changes.
 * <P>Type: INTEGER</P>
 * @apiSince 5
 */

public static final java.lang.String VERSION = "version";
}

/**
 * A table provided for sync adapters to use for storing private sync state data for contacts.
 *
 * @see android.provider.SyncStateContract
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class SyncState implements android.provider.SyncStateContract.Columns {

private SyncState() { throw new RuntimeException("Stub!"); }

/**
 * @see android.provider.SyncStateContract.Helpers#get
 * @apiSince 5
 */

public static byte[] get(android.content.ContentProviderClient provider, android.accounts.Account account) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * @see android.provider.SyncStateContract.Helpers#get
 * @apiSince 5
 */

public static android.util.Pair<android.net.Uri,byte[]> getWithUri(android.content.ContentProviderClient provider, android.accounts.Account account) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * @see android.provider.SyncStateContract.Helpers#set
 * @apiSince 5
 */

public static void set(android.content.ContentProviderClient provider, android.accounts.Account account, byte[] data) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * @see android.provider.SyncStateContract.Helpers#newSetOperation
 * @apiSince 5
 */

public static android.content.ContentProviderOperation newSetOperation(android.accounts.Account account, byte[] data) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public static final java.lang.String CONTENT_DIRECTORY = "syncstate";

/**
 * The content:// style URI for this table
 * @apiSince 5
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }
}

}

