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

import android.accounts.Account;
import android.os.RemoteException;
import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;

/**
 * The ContentProvider contract for associating data with ana data array account.
 * This may be used by providers that want to store this data in a standard way.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SyncStateContract {

public SyncStateContract() { throw new RuntimeException("Stub!"); }
/** @apiSince 5 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Columns extends android.provider.BaseColumns {

/**
 * A reference to the name of the account to which this data belongs
 * <P>Type: STRING</P>
 * @apiSince 5
 */

public static final java.lang.String ACCOUNT_NAME = "account_name";

/**
 * A reference to the type of the account to which this data belongs
 * <P>Type: STRING</P>
 * @apiSince 5
 */

public static final java.lang.String ACCOUNT_TYPE = "account_type";

/**
 * The sync data associated with this account.
 * <P>Type: NONE</P>
 * @apiSince 5
 */

public static final java.lang.String DATA = "data";
}

/** @apiSince 5 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Constants implements android.provider.SyncStateContract.Columns {

public Constants() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public static final java.lang.String CONTENT_DIRECTORY = "syncstate";
}

/** @apiSince 5 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Helpers {

public Helpers() { throw new RuntimeException("Stub!"); }

/**
 * Get the sync state that is associated with the account or null.
 * @param provider the {@link android.content.ContentProviderClient ContentProviderClient} that is to be used to communicate
 * with the {@link android.content.ContentProvider} that contains the sync state.
 * @param uri the uri of the sync state
 * @param account the {@link android.accounts.Account Account} whose sync state should be returned
 * @return the sync state or null if there is no sync state associated with the account
 * @throws android.os.RemoteException if there is a failure communicating with the remote
 * {@link android.content.ContentProvider}
 * @apiSince 5
 */

public static byte[] get(android.content.ContentProviderClient provider, android.net.Uri uri, android.accounts.Account account) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * Assigns the data array as the sync state for the given account.
 * @param provider the {@link android.content.ContentProviderClient ContentProviderClient} that is to be used to communicate
 * with the {@link android.content.ContentProvider} that contains the sync state.
 * @param uri the uri of the sync state
 * @param account the {@link android.accounts.Account Account} whose sync state should be set
 * @param data the byte[] that contains the sync state
 * @throws android.os.RemoteException if there is a failure communicating with the remote
 * {@link android.content.ContentProvider}
 * @apiSince 5
 */

public static void set(android.content.ContentProviderClient provider, android.net.Uri uri, android.accounts.Account account, byte[] data) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public static android.net.Uri insert(android.content.ContentProviderClient provider, android.net.Uri uri, android.accounts.Account account, byte[] data) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public static void update(android.content.ContentProviderClient provider, android.net.Uri uri, byte[] data) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public static android.util.Pair<android.net.Uri,byte[]> getWithUri(android.content.ContentProviderClient provider, android.net.Uri uri, android.accounts.Account account) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * Creates and returns a ContentProviderOperation that assigns the data array as the
 * sync state for the given account.
 * @param uri the uri of the sync state
 * @param account the {@link android.accounts.Account Account} whose sync state should be set
 * @param data the byte[] that contains the sync state
 * @return the new ContentProviderOperation that assigns the data array as the
 * account's sync state
 * @apiSince 5
 */

public static android.content.ContentProviderOperation newSetOperation(android.net.Uri uri, android.accounts.Account account, byte[] data) { throw new RuntimeException("Stub!"); }

/**
 * Creates and returns a ContentProviderOperation that assigns the data array as the
 * sync state for the given account.
 * @param uri the uri of the specific sync state to set
 * @param data the byte[] that contains the sync state
 * @return the new ContentProviderOperation that assigns the data array as the
 * account's sync state
 * @apiSince 5
 */

public static android.content.ContentProviderOperation newUpdateOperation(android.net.Uri uri, byte[] data) { throw new RuntimeException("Stub!"); }
}

}

