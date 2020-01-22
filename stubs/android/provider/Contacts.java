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


package android.provider;

import android.content.ContentResolver;
import android.net.Uri;
import java.io.InputStream;
import android.graphics.Bitmap;
import android.content.Context;

/**
 * The Contacts provider stores all information about contacts.
 *
 * @deprecated The APIs have been superseded by {@link android.provider.ContactsContract ContactsContract}. The newer APIs allow
 * access multiple accounts and support aggregation of similar contacts. These APIs continue to
 * work but will only return data for the first Google account created, which matches the original
 * behavior.
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class Contacts {

private Contacts() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String AUTHORITY = "contacts";

/**
 * The content:// style URL for this provider
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * Signifies an email address row that is stored in the ContactMethods table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int KIND_EMAIL = 1; // 0x1

/**
 * Signifies an IM address row that is stored in the ContactMethods table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int KIND_IM = 3; // 0x3

/**
 * Signifies an Organization row that is stored in the Organizations table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int KIND_ORGANIZATION = 4; // 0x4

/**
 * Signifies a Phone row that is stored in the Phones table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int KIND_PHONE = 5; // 0x5

/**
 * Signifies a postal address row that is stored in the ContactMethods table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int KIND_POSTAL = 2; // 0x2
/**
 * This table stores all non-phone contact methods and a reference to the
 * person that the contact method belongs to.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class ContactMethods implements android.provider.BaseColumns, android.provider.Contacts.ContactMethodsColumns, android.provider.Contacts.PeopleColumns {

private ContactMethods() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static java.lang.String encodePredefinedImProtocol(int protocol) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static java.lang.String encodeCustomImProtocol(java.lang.String protocolString) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static java.lang.Object decodeImProtocol(java.lang.String encodedString) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static java.lang.CharSequence getDisplayLabel(android.content.Context context, int kind, int type, java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * Add a longitude and latitude location to a postal address.
 *
 * @param context the context to use when updating the database
 * @param postalId the address to update
 * @param latitude the latitude for the address
 * @param longitude the longitude for the address
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public void addPostalLocation(android.content.Context context, long postalId, double latitude, double longitude) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type of a {@link #CONTENT_URI} sub-directory of a single
 * {@link android.provider.Contacts#KIND_EMAIL Contacts#KIND_EMAIL} entry.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_EMAIL_ITEM_TYPE = "vnd.android.cursor.item/email";

/**
 * The MIME type of a {@link #CONTENT_EMAIL_URI} sub-directory of
 * multiple {@link android.provider.Contacts#KIND_EMAIL Contacts#KIND_EMAIL} entries.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_EMAIL_TYPE = "vnd.android.cursor.dir/email";

/**
 * The content:// style URL for sub-directory of e-mail addresses.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final android.net.Uri CONTENT_EMAIL_URI;
static { CONTENT_EMAIL_URI = null; }

/**
 * The MIME type of a {@link #CONTENT_URI} sub-directory of a single
 * {@link android.provider.Contacts#KIND_IM Contacts#KIND_IM} entry.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_IM_ITEM_TYPE = "vnd.android.cursor.item/jabber-im";

/**
 * The MIME type of a {@link #CONTENT_URI} sub-directory of a single
 * {@link android.provider.Contacts#KIND_POSTAL Contacts#KIND_POSTAL} entry.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_POSTAL_ITEM_TYPE = "vnd.android.cursor.item/postal-address";

/**
 * The MIME type of a {@link #CONTENT_EMAIL_URI} sub-directory of
 * multiple {@link android.provider.Contacts#KIND_POSTAL Contacts#KIND_POSTAL} entries.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_POSTAL_TYPE = "vnd.android.cursor.dir/postal-address";

/**
 * The MIME type of {@link #CONTENT_URI} providing a directory of
 * @deprecated see {@link android.provider.ContactsContract}
 * phones.
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/contact-methods";

/**
 * The content:// style URL for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String DEFAULT_SORT_ORDER = "name ASC";

/**
 * The ID of the person this contact method is assigned to.
 * <P>Type: INTEGER (long)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PERSON_ID = "person";

/**
 * The column with latitude data for postal locations
 * <P>Type: REAL</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String POSTAL_LOCATION_LATITUDE = "data";

/**
 * The column with longitude data for postal locations
 * <P>Type: REAL</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String POSTAL_LOCATION_LONGITUDE = "aux_data";

/**
 * The predefined IM protocol types. The protocol can either be non-present, one
 * of these types, or a free-form string. These cases are encoded in the AUX_DATA
 * column as:
 *  - null
 *  - pre:<an integer, one of the protocols below>
 *  - custom:<a string>
 *  @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int PROTOCOL_AIM = 0; // 0x0

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int PROTOCOL_GOOGLE_TALK = 5; // 0x5

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int PROTOCOL_ICQ = 6; // 0x6

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int PROTOCOL_JABBER = 7; // 0x7

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int PROTOCOL_MSN = 1; // 0x1

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int PROTOCOL_QQ = 4; // 0x4

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int PROTOCOL_SKYPE = 3; // 0x3

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int PROTOCOL_YAHOO = 2; // 0x2
}

/**
 * Columns from the ContactMethods table that other tables join into
 * themseleves.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface ContactMethodsColumns {

/**
 * Auxiliary data for the contact method.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String AUX_DATA = "aux_data";

/**
 * The data for the contact method.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String DATA = "data";

/**
 * Whether this is the primary organization
 * <P>Type: INTEGER (if set, non-0 means true)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String ISPRIMARY = "isprimary";

/**
 * The kind of the the contact method. For example, email address,
 * postal address, etc.
 * <P>Type: INTEGER (one of the values below)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String KIND = "kind";

/**
 * The user defined label for the the contact method.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String LABEL = "label";

/**
 * The type of the contact method, must be one of the types below.
 * <P>Type: INTEGER (one of the values below)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String TYPE = "type";

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int TYPE_CUSTOM = 0; // 0x0

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int TYPE_HOME = 1; // 0x1

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int TYPE_OTHER = 3; // 0x3

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int TYPE_WORK = 2; // 0x2
}

/**
 * The extensions for a person
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class Extensions implements android.provider.BaseColumns, android.provider.Contacts.ExtensionsColumns {

private Extensions() { throw new RuntimeException("Stub!"); }

/**
 * The MIME type of a {@link #CONTENT_URI} subdirectory of a single
 * phone.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_extensions";

/**
 * The MIME type of {@link #CONTENT_URI} providing a directory of
 * phones.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/contact_extensions";

/**
 * The content:// style URL for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String DEFAULT_SORT_ORDER = "person, name ASC";

/**
 * The ID of the person this phone number is assigned to.
 * <P>Type: INTEGER (long)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PERSON_ID = "person";
}

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface ExtensionsColumns {

/**
 * The name of this extension. May not be null. There may be at most one row for each name.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String NAME = "name";

/**
 * The value of this extension. May not be null.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String VALUE = "value";
}

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class GroupMembership implements android.provider.BaseColumns, android.provider.Contacts.GroupsColumns {

private GroupMembership() { throw new RuntimeException("Stub!"); }

/**
 * The directory twig for this sub-table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_DIRECTORY = "groupmembership";

/**
 * The MIME type of a {@link #CONTENT_URI} subdirectory of a single
 * person group.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contactsgroupmembership";

/**
 * The MIME type of {@link #CONTENT_URI} providing a directory of all
 * person groups.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/contactsgroupmembership";

/**
 * The content:// style URL for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String DEFAULT_SORT_ORDER = "group_id ASC";

/**
 * The row id of the accounts group.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String GROUP_ID = "group_id";

/**
 * The account of the group.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String GROUP_SYNC_ACCOUNT = "group_sync_account";

/**
 * The account type of the group.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 5
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String GROUP_SYNC_ACCOUNT_TYPE = "group_sync_account_type";

/**
 * The sync id of the group.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String GROUP_SYNC_ID = "group_sync_id";

/**
 * The row id of the person.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PERSON_ID = "person";

/**
 * The content:// style URL for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final android.net.Uri RAW_CONTENT_URI;
static { RAW_CONTENT_URI = null; }
}

/**
 * This table contains the groups for an account.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class Groups implements android.provider.BaseColumns, android.provider.Contacts.GroupsColumns {

private Groups() { throw new RuntimeException("Stub!"); }

/**
 * The MIME type of a {@link #CONTENT_URI} subdirectory of a single
 * group.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contactsgroup";

/**
 * The MIME type of {@link #CONTENT_URI} providing a directory of
 * groups.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/contactsgroup";

/**
 * The content:// style URL for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String DEFAULT_SORT_ORDER = "name ASC";

/**
 * The content:// style URL for the table that holds the deleted
 * groups.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final android.net.Uri DELETED_CONTENT_URI;
static { DELETED_CONTENT_URI = null; }

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String GROUP_ANDROID_STARRED = "Starred in Android";

/**
 * The "My Contacts" system group.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String GROUP_MY_CONTACTS = "Contacts";
}

/**
 * Columns from the groups table.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface GroupsColumns {

/**
 * The group name.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String NAME = "name";

/**
 * Notes about the group.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String NOTES = "notes";

/**
 * Whether this group should be synced if the SYNC_EVERYTHING settings is false
 * for this group's account.
 * <P>Type: INTEGER (boolean)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String SHOULD_SYNC = "should_sync";

/**
 * The ID of this group if it is a System Group, null otherwise.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String SYSTEM_ID = "system_id";
}

/**
 * Contains helper classes used to create or manage {@link android.content.Intent Intents}
 * that involve contacts.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class Intents {

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 */

@Deprecated
public Intents() { throw new RuntimeException("Stub!"); }

/**
 * Starts an Activity that lets the user pick a contact to attach an image to.
 * After picking the contact it launches the image cropper in face detection mode.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String ATTACH_IMAGE = "com.android.contacts.action.ATTACH_IMAGE";

/**
 * Used with {@link #SHOW_OR_CREATE_CONTACT} to specify an exact
 * description to be shown when prompting user about creating a new
 * contact.
 * <p>
 * Type: STRING
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 3
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String EXTRA_CREATE_DESCRIPTION = "com.android.contacts.action.CREATE_DESCRIPTION";

/**
 * Used with {@link #SHOW_OR_CREATE_CONTACT} to force creating a new
 * contact if no matching contact found. Otherwise, default behavior is
 * to prompt user with dialog before creating.
 * <p>
 * Type: BOOLEAN
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 3
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String EXTRA_FORCE_CREATE = "com.android.contacts.action.FORCE_CREATE";

/**
 * This is the intent that is fired when a search suggestion is clicked on.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String SEARCH_SUGGESTION_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_CLICKED";

/**
 * This is the intent that is fired when a search suggestion for creating a contact
 * is clicked on.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED";

/**
 * This is the intent that is fired when a search suggestion for dialing a number
 * is clicked on.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED";

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
 * Any extras from the {@link android.provider.Contacts.Intents.Insert Insert} class will be passed along to the
 * create activity if there are no contacts to show.
 * <p>
 * Passing true for the {@link #EXTRA_FORCE_CREATE} extra will skip
 * prompting the user when the contact doesn't exist.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 3
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String SHOW_OR_CREATE_CONTACT = "com.android.contacts.action.SHOW_OR_CREATE_CONTACT";
/**
 * Convenience class that contains string constants used
 * to create contact {@link android.content.Intent Intents}.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class Insert {

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 */

@Deprecated
public Insert() { throw new RuntimeException("Stub!"); }

/** The action code to use when adding a contact
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String ACTION = "android.intent.action.INSERT";

/**
 * The extra field for the contact company.
 * <P>Type: String</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String COMPANY = "company";

/**
 * The extra field for the contact email address.
 * <P>Type: String</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String EMAIL = "email";

/**
 * The extra field for the email isprimary flag.
 * <P>Type: boolean</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String EMAIL_ISPRIMARY = "email_isprimary";

/**
 * The extra field for the contact email type.
 * <P>Type: Either an integer value from {@link android.provider.Contacts.ContactMethodsColumns ContactMethodsColumns}
 *  or a string specifying a custom label.</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String EMAIL_TYPE = "email_type";

/**
 * If present, forces a bypass of quick insert mode.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String FULL_MODE = "full_mode";

/**
 * The extra field for an IM handle.
 * <P>Type: String</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String IM_HANDLE = "im_handle";

/**
 * The extra field for the IM isprimary flag.
 * <P>Type: boolean</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String IM_ISPRIMARY = "im_isprimary";

/**
 * The extra field for the IM protocol
 * <P>Type: the result of {@link android.provider.Contacts.ContactMethods#encodePredefinedImProtocol Contacts.ContactMethods#encodePredefinedImProtocol}
 * or {@link android.provider.Contacts.ContactMethods#encodeCustomImProtocol Contacts.ContactMethods#encodeCustomImProtocol}.</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String IM_PROTOCOL = "im_protocol";

/**
 * The extra field for the contact job title.
 * <P>Type: String</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String JOB_TITLE = "job_title";

/**
 * The extra field for the contact name.
 * <P>Type: String</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String NAME = "name";

/**
 * The extra field for the contact notes.
 * <P>Type: String</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String NOTES = "notes";

/**
 * The extra field for the contact phone number.
 * <P>Type: String</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PHONE = "phone";

/**
 * The extra field for the contact phonetic name.
 * <P>Type: String</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 3
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PHONETIC_NAME = "phonetic_name";

/**
 * The extra field for the phone isprimary flag.
 * <P>Type: boolean</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PHONE_ISPRIMARY = "phone_isprimary";

/**
 * The extra field for the contact phone number type.
 * <P>Type: Either an integer value from {@link android.provider.Contacts.PhonesColumns PhonesColumns},
 *  or a string specifying a custom label.</P>
 *  @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PHONE_TYPE = "phone_type";

/**
 * The extra field for the contact postal address.
 * <P>Type: String</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String POSTAL = "postal";

/**
 * The extra field for the postal isprimary flag.
 * <P>Type: boolean</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String POSTAL_ISPRIMARY = "postal_isprimary";

/**
 * The extra field for the contact postal address type.
 * <P>Type: Either an integer value from {@link android.provider.Contacts.ContactMethodsColumns ContactMethodsColumns}
 *  or a string specifying a custom label.</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String POSTAL_TYPE = "postal_type";

/**
 * The extra field for an optional second contact email address.
 * <P>Type: String</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 3
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String SECONDARY_EMAIL = "secondary_email";

/**
 * The extra field for an optional second contact email type.
 * <P>Type: Either an integer value from {@link android.provider.Contacts.ContactMethodsColumns ContactMethodsColumns}
 *  or a string specifying a custom label.</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 3
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String SECONDARY_EMAIL_TYPE = "secondary_email_type";

/**
 * The extra field for an optional second contact phone number.
 * <P>Type: String</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 3
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String SECONDARY_PHONE = "secondary_phone";

/**
 * The extra field for an optional second contact phone number type.
 * <P>Type: Either an integer value from {@link android.provider.Contacts.PhonesColumns PhonesColumns},
 *  or a string specifying a custom label.</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 3
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String SECONDARY_PHONE_TYPE = "secondary_phone_type";

/**
 * The extra field for an optional third contact email address.
 * <P>Type: String</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 3
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String TERTIARY_EMAIL = "tertiary_email";

/**
 * The extra field for an optional third contact email type.
 * <P>Type: Either an integer value from {@link android.provider.Contacts.ContactMethodsColumns ContactMethodsColumns}
 *  or a string specifying a custom label.</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 3
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String TERTIARY_EMAIL_TYPE = "tertiary_email_type";

/**
 * The extra field for an optional third contact phone number.
 * <P>Type: String</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 3
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String TERTIARY_PHONE = "tertiary_phone";

/**
 * The extra field for an optional third contact phone number type.
 * <P>Type: Either an integer value from {@link android.provider.Contacts.PhonesColumns PhonesColumns},
 *  or a string specifying a custom label.</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 3
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String TERTIARY_PHONE_TYPE = "tertiary_phone_type";
}

/**
 * Intents related to the Contacts app UI.
 * @deprecated Do not use. This is not supported.
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class UI {

/**
 * @deprecated Do not use. This is not supported.
 * @apiSince 1
 */

@Deprecated
public UI() { throw new RuntimeException("Stub!"); }

/**
 * Activity Action: Display a filtered list of contacts
 * <p>
 * Input: Extra field {@link #FILTER_TEXT_EXTRA_KEY} is the text to use for
 * filtering
 * <p>
 * Output: Nothing.
 * @deprecated Do not use. This is not supported.
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String FILTER_CONTACTS_ACTION = "com.android.contacts.action.FILTER_CONTACTS";

/**
 * Used as an int extra field in {@link #FILTER_CONTACTS_ACTION}
 * intents to supply the text on which to filter.
 * @deprecated Do not use. This is not supported.
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String FILTER_TEXT_EXTRA_KEY = "com.android.contacts.extra.FILTER_TEXT";

/**
 * When in LIST_GROUP_ACTION mode, this is the group to display.
 * @deprecated Do not use. This is not supported.
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String GROUP_NAME_EXTRA_KEY = "com.android.contacts.extra.GROUP";

/**
 * The action for the all contacts list tab.
 * @deprecated Do not use. This is not supported.
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String LIST_ALL_CONTACTS_ACTION = "com.android.contacts.action.LIST_ALL_CONTACTS";

/**
 * The action for the contacts with phone numbers list tab.
 * @deprecated Do not use. This is not supported.
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String LIST_CONTACTS_WITH_PHONES_ACTION = "com.android.contacts.action.LIST_CONTACTS_WITH_PHONES";

/**
 * The action for the default contacts list tab.
 * @deprecated Do not use. This is not supported.
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String LIST_DEFAULT = "com.android.contacts.action.LIST_DEFAULT";

/**
 * The action for the frequent contacts list tab.
 * @deprecated Do not use. This is not supported.
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String LIST_FREQUENT_ACTION = "com.android.contacts.action.LIST_FREQUENT";

/**
 * The action for the contacts list tab.
 * @deprecated Do not use. This is not supported.
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String LIST_GROUP_ACTION = "com.android.contacts.action.LIST_GROUP";

/**
 * The action for the starred contacts list tab.
 * @deprecated Do not use. This is not supported.
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String LIST_STARRED_ACTION = "com.android.contacts.action.LIST_STARRED";

/**
 * The action for the "strequent" contacts list tab. It first lists the starred
 * contacts in alphabetical order and then the frequent contacts in descending
 * order of the number of times they have been contacted.
 * @deprecated Do not use. This is not supported.
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String LIST_STREQUENT_ACTION = "com.android.contacts.action.LIST_STREQUENT";

/**
 * A key for to be used as an intent extra to set the activity
 * title to a custom String value.
 * @deprecated Do not use. This is not supported.
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String TITLE_EXTRA_KEY = "com.android.contacts.extra.TITLE_EXTRA";
}

}

/**
 * Columns from the Organizations table that other columns join into themselves.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OrganizationColumns {

/**
 * The name of the company for this organization.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String COMPANY = "company";

/**
 * Whether this is the primary organization
 * <P>Type: INTEGER (if set, non-0 means true)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String ISPRIMARY = "isprimary";

/**
 * The user provided label, only used if TYPE is TYPE_CUSTOM.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String LABEL = "label";

/**
 * The person this organization is tied to.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PERSON_ID = "person";

/**
 * The title within this organization.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String TITLE = "title";

/**
 * The type of the organizations.
 * <P>Type: INTEGER (one of the constants below)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String TYPE = "type";

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int TYPE_CUSTOM = 0; // 0x0

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int TYPE_OTHER = 2; // 0x2

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int TYPE_WORK = 1; // 0x1
}

/**
 * A sub directory of a single person that contains all of their Phones.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class Organizations implements android.provider.BaseColumns, android.provider.Contacts.OrganizationColumns {

private Organizations() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static java.lang.CharSequence getDisplayLabel(android.content.Context context, int type, java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * The directory twig for this sub-table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_DIRECTORY = "organizations";

/**
 * The content:// style URL for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String DEFAULT_SORT_ORDER = "company, title, isprimary ASC";
}

/**
 * This table contains people.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class People implements android.provider.BaseColumns, android.provider.Contacts.PeopleColumns, android.provider.Contacts.PhonesColumns, android.provider.Contacts.PresenceColumns {

private People() { throw new RuntimeException("Stub!"); }

/**
 * This API is no longer supported as of O.
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static void markAsContacted(android.content.ContentResolver resolver, long personId) { throw new RuntimeException("Stub!"); }

/**
 * Adds a person to the My Contacts group.
 *
 * @param resolver the resolver to use
 * @param personId the person to add to the group
 * @return the URI of the group membership row
 * @throws java.lang.IllegalStateException if the My Contacts group can't be found
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static android.net.Uri addToMyContactsGroup(android.content.ContentResolver resolver, long personId) { throw new RuntimeException("Stub!"); }

/**
 * Adds a person to a group referred to by name.
 *
 * @param resolver the resolver to use
 * @param personId the person to add to the group
 * @param groupName the name of the group to add the contact to
 * @return the URI of the group membership row
 * @throws java.lang.IllegalStateException if the group can't be found
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static android.net.Uri addToGroup(android.content.ContentResolver resolver, long personId, java.lang.String groupName) { throw new RuntimeException("Stub!"); }

/**
 * Adds a person to a group.
 *
 * @param resolver the resolver to use
 * @param personId the person to add to the group
 * @param groupId the group to add the person to
 * @return the URI of the group membership row
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static android.net.Uri addToGroup(android.content.ContentResolver resolver, long personId, long groupId) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new contacts and adds it to the "My Contacts" group.
 *
 * @param resolver the ContentResolver to use
 * @param values the values to use when creating the contact
 * @return the URI of the contact, or null if the operation fails
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static android.net.Uri createPersonInMyContactsGroup(android.content.ContentResolver resolver, android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static android.database.Cursor queryGroups(android.content.ContentResolver resolver, long person) { throw new RuntimeException("Stub!"); }

/**
 * Set the photo for this person. data may be null
 * @param cr the ContentResolver to use
 * @param person the Uri of the person whose photo is to be updated
 * @param data the byte[] that represents the photo
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static void setPhotoData(android.content.ContentResolver cr, android.net.Uri person, byte[] data) { throw new RuntimeException("Stub!"); }

/**
 * Opens an InputStream for the person's photo and returns the photo as a Bitmap.
 * If the person's photo isn't present returns the placeholderImageResource instead.
 * @param person the person whose photo should be used
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static java.io.InputStream openContactPhotoInputStream(android.content.ContentResolver cr, android.net.Uri person) { throw new RuntimeException("Stub!"); }

/**
 * Opens an InputStream for the person's photo and returns the photo as a Bitmap.
 * If the person's photo isn't present returns the placeholderImageResource instead.
 * @param context the Context
 * @param person the person whose photo should be used
 * @param placeholderImageResource the image resource to use if the person doesn't
 *   have a photo
 * @param options the decoding options, can be set to null
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static android.graphics.Bitmap loadContactPhoto(android.content.Context context, android.net.Uri person, int placeholderImageResource, android.graphics.BitmapFactory.Options options) { throw new RuntimeException("Stub!"); }

/**
 * The content:// style URL for filtering people by name. The filter
 * argument should be passed as an additional path segment after this URI.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final android.net.Uri CONTENT_FILTER_URI;
static { CONTENT_FILTER_URI = null; }

/**
 * The MIME type of a {@link #CONTENT_URI} subdirectory of a single
 * person.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/person";

/**
 * The MIME type of {@link #CONTENT_URI} providing a directory of
 * people.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/person";

/**
 * The content:// style URL for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String DEFAULT_SORT_ORDER = "name ASC";

/**
 * The content:// style URL for the table that holds the deleted
 * contacts.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final android.net.Uri DELETED_CONTENT_URI;
static { DELETED_CONTENT_URI = null; }

/**
 * The ID of the persons preferred email.
 * <P>Type: INTEGER (foreign key to contact_methods table on the
 * _ID field)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PRIMARY_EMAIL_ID = "primary_email";

/**
 * The ID of the persons preferred organization.
 * <P>Type: INTEGER (foreign key to organizations table on the
 * _ID field)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PRIMARY_ORGANIZATION_ID = "primary_organization";

/**
 * The ID of the persons preferred phone number.
 * <P>Type: INTEGER (foreign key to phones table on the _ID field)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PRIMARY_PHONE_ID = "primary_phone";
/**
 * A subdirectory of a single person that contains all of their
 * ContactMethods.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class ContactMethods implements android.provider.BaseColumns, android.provider.Contacts.ContactMethodsColumns, android.provider.Contacts.PeopleColumns {

private ContactMethods() { throw new RuntimeException("Stub!"); }

/**
 * The directory twig for this sub-table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_DIRECTORY = "contact_methods";

/**
 * The default sort order for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String DEFAULT_SORT_ORDER = "data ASC";
}

/**
 * The extensions for a person
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class Extensions implements android.provider.BaseColumns, android.provider.Contacts.ExtensionsColumns {

private Extensions() { throw new RuntimeException("Stub!"); }

/**
 * The directory twig for this sub-table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_DIRECTORY = "extensions";

/**
 * The default sort order for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String DEFAULT_SORT_ORDER = "name ASC";

/**
 * The ID of the person this phone number is assigned to.
 * <P>Type: INTEGER (long)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PERSON_ID = "person";
}

/**
 * A sub directory of a single person that contains all of their Phones.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class Phones implements android.provider.BaseColumns, android.provider.Contacts.PhonesColumns, android.provider.Contacts.PeopleColumns {

private Phones() { throw new RuntimeException("Stub!"); }

/**
 * The directory twig for this sub-table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_DIRECTORY = "phones";

/**
 * The default sort order for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String DEFAULT_SORT_ORDER = "number ASC";
}

}

/**
 * Columns from the People table that other tables join into themselves.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface PeopleColumns {

/**
 * A custom ringtone associated with a person. Not always present.
 * <P>Type: TEXT (URI to the ringtone)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CUSTOM_RINGTONE = "custom_ringtone";

/**
 * The display name. If name is not null name, else if number is not null number,
 * else if email is not null email.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String DISPLAY_NAME = "display_name";

/**
 * The last time a person was contacted.
 * <P>Type: INTEGER</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String LAST_TIME_CONTACTED = "last_time_contacted";

/**
 * The person's name.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String NAME = "name";

/**
 * Notes about the person.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String NOTES = "notes";

/**
 * Phonetic equivalent of the person's name, in a locale-dependent
 * character set (e.g.&nbsp;hiragana for Japanese).
 * Used for pronunciation and/or collation in some languages.
 * <p>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 3
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PHONETIC_NAME = "phonetic_name";

/**
 * The server version of the photo
 * <P>Type: TEXT (the version number portion of the photo URI)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PHOTO_VERSION = "photo_version";

/**
 * Whether the person should always be sent to voicemail. Not always
 * present.
 * <P>Type: INTEGER (0 for false, 1 for true)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String SEND_TO_VOICEMAIL = "send_to_voicemail";

/**
 * Is the contact starred?
 * <P>Type: INTEGER (boolean)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String STARRED = "starred";

/**
 * The number of times a person has been contacted
 * <P>Type: INTEGER</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String TIMES_CONTACTED = "times_contacted";
}

/**
 * This table stores phone numbers and a reference to the person that the
 * contact method belongs to. Phone numbers are stored separately from
 * other contact methods to make caller ID lookup more efficient.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class Phones implements android.provider.BaseColumns, android.provider.Contacts.PhonesColumns, android.provider.Contacts.PeopleColumns {

private Phones() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static java.lang.CharSequence getDisplayLabel(android.content.Context context, int type, java.lang.CharSequence label, java.lang.CharSequence[] labelArray) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static java.lang.CharSequence getDisplayLabel(android.content.Context context, int type, java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * The content:// style URL for filtering phone numbers
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final android.net.Uri CONTENT_FILTER_URL;
static { CONTENT_FILTER_URL = null; }

/**
 * The MIME type of a {@link #CONTENT_URI} subdirectory of a single
 * phone.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/phone";

/**
 * The MIME type of {@link #CONTENT_URI} providing a directory of
 * phones.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/phone";

/**
 * The content:// style URL for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String DEFAULT_SORT_ORDER = "name ASC";

/**
 * The ID of the person this phone number is assigned to.
 * <P>Type: INTEGER (long)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PERSON_ID = "person";
}

/**
 * Columns from the Phones table that other columns join into themselves.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface PhonesColumns {

/**
 * Whether this is the primary phone number
 * <P>Type: INTEGER (if set, non-0 means true)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String ISPRIMARY = "isprimary";

/**
 * The user provided label for the phone number, only used if TYPE is TYPE_CUSTOM.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String LABEL = "label";

/**
 * The phone number as the user entered it.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String NUMBER = "number";

/**
 * The normalized phone number
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String NUMBER_KEY = "number_key";

/**
 * The type of the the phone number.
 * <P>Type: INTEGER (one of the constants below)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String TYPE = "type";

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int TYPE_CUSTOM = 0; // 0x0

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int TYPE_FAX_HOME = 5; // 0x5

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int TYPE_FAX_WORK = 4; // 0x4

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int TYPE_HOME = 1; // 0x1

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int TYPE_MOBILE = 2; // 0x2

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int TYPE_OTHER = 7; // 0x7

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int TYPE_PAGER = 6; // 0x6

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final int TYPE_WORK = 3; // 0x3
}

/**
 * The photos over all of the people
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class Photos implements android.provider.BaseColumns, android.provider.Contacts.PhotosColumns {

private Photos() { throw new RuntimeException("Stub!"); }

/**
 * The directory twig for this sub-table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_DIRECTORY = "photo";

/**
 * The content:// style URL for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String DEFAULT_SORT_ORDER = "person ASC";
}

/**
 * Columns from the Photos table that other columns join into themselves.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface PhotosColumns {

/**
 * The image data, or null if there is no image.
 * <P>Type: BLOB</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String DATA = "data";

/**
 * non-zero if a download is required and the photo isn't marked as a bad resource.
 * You must specify this in the columns in order to use it in the where clause.
 * <P>Type: INTEGER(boolean)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String DOWNLOAD_REQUIRED = "download_required";

/**
 * non-zero if this photo is known to exist on the server
 * <P>Type: INTEGER(boolean)</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String EXISTS_ON_SERVER = "exists_on_server";

/**
 * The _SYNC_VERSION of the photo that was last downloaded
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String LOCAL_VERSION = "local_version";

/**
 * The person this photo is associated with.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PERSON_ID = "person";

/**
 * Contains the description of the upload or download error from
 * the previous attempt. If null then the previous attempt succeeded.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String SYNC_ERROR = "sync_error";
}

/**
 * The IM presence columns with some contacts specific columns mixed in.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface PresenceColumns {

/**
 * @apiSince 8
 * @deprecatedSince 5
 */

@Deprecated public static final int AVAILABLE = 5; // 0x5

/**
 * @apiSince 8
 * @deprecatedSince 5
 */

@Deprecated public static final int AWAY = 2; // 0x2

/**
 * @apiSince 8
 * @deprecatedSince 5
 */

@Deprecated public static final int DO_NOT_DISTURB = 4; // 0x4

/**
 * @apiSince 8
 * @deprecatedSince 5
 */

@Deprecated public static final int IDLE = 3; // 0x3

/**
 * The IM account for the local user that the presence data came from.
 * <P>Type: STRING</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String IM_ACCOUNT = "im_account";

/**
 * The IM handle the presence item is for. The handle is scoped to
 * the {@link #IM_PROTOCOL}.
 * <P>Type: STRING</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String IM_HANDLE = "im_handle";

/**
 * The IM service the presence is coming from. Formatted using either
 * {@link android.provider.Contacts.ContactMethods#encodePredefinedImProtocol Contacts.ContactMethods#encodePredefinedImProtocol} or
 * {@link android.provider.Contacts.ContactMethods#encodeCustomImProtocol Contacts.ContactMethods#encodeCustomImProtocol}.
 * <P>Type: STRING</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String IM_PROTOCOL = "im_protocol";

/**
 * @apiSince 8
 * @deprecatedSince 5
 */

@Deprecated public static final int INVISIBLE = 1; // 0x1

/**
 * Presence Status definition
 * @apiSince 8
 * @deprecatedSince 5
 */

@Deprecated public static final int OFFLINE = 0; // 0x0

/**
 * The user defined status line.
 * <P>Type: TEXT</P>
 * @apiSince 8
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PRESENCE_CUSTOM_STATUS = "status";

/**
 * The server defined status.
 * <P>Type: INTEGER (one of the values below)</P>
 * @apiSince 8
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PRESENCE_STATUS = "mode";

/**
 * The priority, an integer, used by XMPP presence
 * <P>Type: INTEGER</P>
 * @apiSince 8
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String PRIORITY = "priority";
}

/**
 * The settings over all of the people
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class Settings implements android.provider.BaseColumns, android.provider.Contacts.SettingsColumns {

private Settings() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static java.lang.String getSetting(android.content.ContentResolver cr, java.lang.String account, java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static void setSetting(android.content.ContentResolver cr, java.lang.String account, java.lang.String key, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * The directory twig for this sub-table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String CONTENT_DIRECTORY = "settings";

/**
 * The content:// style URL for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String DEFAULT_SORT_ORDER = "key ASC";

/**
 * A setting that is used to indicate if we should sync down all groups for the
 * specified account. For this setting the _SYNC_ACCOUNT column must be set.
 * If this isn't set then we will only sync the groups whose SHOULD_SYNC column
 * is set to true.
 * <p>
 * This is a boolean setting. It is true if it is set and it is anything other than the
 * emptry string or "0".
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String SYNC_EVERYTHING = "syncEverything";
}

/**
 * Columns from the Settings table that other columns join into themselves.
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface SettingsColumns {

/**
 * The key of this setting.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String KEY = "key";

/**
 * The value of this setting.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String VALUE = "value";

/**
 * The _SYNC_ACCOUNT to which this setting corresponds. This may be null.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String _SYNC_ACCOUNT = "_sync_account";

/**
 * The _SYNC_ACCOUNT_TYPE to which this setting corresponds. This may be null.
 * <P>Type: TEXT</P>
 * @deprecated see {@link android.provider.ContactsContract}
 * @apiSince 5
 * @deprecatedSince 5
 */

@Deprecated public static final java.lang.String _SYNC_ACCOUNT_TYPE = "_sync_account_type";
}

}

