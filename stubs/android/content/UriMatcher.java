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


package android.content;

import java.util.List;
import android.net.Uri;

/**
 Utility class to aid in matching URIs in content providers.
 
 <p>To use this class, build up a tree of <code>UriMatcher</code> objects.
 For example:
 <pre>
    private static final int PEOPLE = 1;
    private static final int PEOPLE_ID = 2;
    private static final int PEOPLE_PHONES = 3;
    private static final int PEOPLE_PHONES_ID = 4;
    private static final int PEOPLE_CONTACTMETHODS = 7;
    private static final int PEOPLE_CONTACTMETHODS_ID = 8;
 
    private static final int DELETED_PEOPLE = 20;
 
    private static final int PHONES = 9;
    private static final int PHONES_ID = 10;
    private static final int PHONES_FILTER = 14;
 
    private static final int CONTACTMETHODS = 18;
    private static final int CONTACTMETHODS_ID = 19;
 
    private static final int CALLS = 11;
    private static final int CALLS_ID = 12;
    private static final int CALLS_FILTER = 15;
 
    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
 
    static
    {
        sURIMatcher.addURI("contacts", "people", PEOPLE);
        sURIMatcher.addURI("contacts", "people/#", PEOPLE_ID);
        sURIMatcher.addURI("contacts", "people/#/phones", PEOPLE_PHONES);
        sURIMatcher.addURI("contacts", "people/#/phones/#", PEOPLE_PHONES_ID);
        sURIMatcher.addURI("contacts", "people/#/contact_methods", PEOPLE_CONTACTMETHODS);
        sURIMatcher.addURI("contacts", "people/#/contact_methods/#", PEOPLE_CONTACTMETHODS_ID);
        sURIMatcher.addURI("contacts", "deleted_people", DELETED_PEOPLE);
        sURIMatcher.addURI("contacts", "phones", PHONES);
        sURIMatcher.addURI("contacts", "phones/filter/*", PHONES_FILTER);
        sURIMatcher.addURI("contacts", "phones/#", PHONES_ID);
        sURIMatcher.addURI("contacts", "contact_methods", CONTACTMETHODS);
        sURIMatcher.addURI("contacts", "contact_methods/#", CONTACTMETHODS_ID);
        sURIMatcher.addURI("call_log", "calls", CALLS);
        sURIMatcher.addURI("call_log", "calls/filter/*", CALLS_FILTER);
        sURIMatcher.addURI("call_log", "calls/#", CALLS_ID);
    }
 </pre>
 <p>Starting from API level {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}, paths can start
 with a leading slash.  For example:
 <pre>
        sURIMatcher.addURI("contacts", "/people", PEOPLE);
 </pre>
 <p>Then when you need to match against a URI, call {@link #match}, providing
 the URL that you have been given.  You can use the result to build a query,
 return a type, insert or delete a row, or whatever you need, without duplicating
 all of the if-else logic that you would otherwise need.  For example:
 <pre>
    public String getType(Uri url)
    {
        int match = sURIMatcher.match(url);
        switch (match)
        {
            case PEOPLE:
                return "vnd.android.cursor.dir/person";
            case PEOPLE_ID:
                return "vnd.android.cursor.item/person";
 ... snip ...
                return "vnd.android.cursor.dir/snail-mail";
            case PEOPLE_ADDRESS_ID:
                return "vnd.android.cursor.item/snail-mail";
            default:
                return null;
        }
    }
 </pre>
 instead of:
 <pre>
    public String getType(Uri url)
    {
        List<String> pathSegments = url.getPathSegments();
        if (pathSegments.size() >= 2) {
            if ("people".equals(pathSegments.get(1))) {
                if (pathSegments.size() == 2) {
                    return "vnd.android.cursor.dir/person";
                } else if (pathSegments.size() == 3) {
                    return "vnd.android.cursor.item/person";
 ... snip ...
                    return "vnd.android.cursor.dir/snail-mail";
                } else if (pathSegments.size() == 3) {
                    return "vnd.android.cursor.item/snail-mail";
                }
            }
        }
        return null;
    }
 </pre>
 @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UriMatcher {

/**
 * Creates the root node of the URI tree.
 *
 * @param code the code to match for the root URI
 * @apiSince 1
 */

public UriMatcher(int code) { throw new RuntimeException("Stub!"); }

/**
 * Add a URI to match, and the code to return when this URI is
 * matched. URI nodes may be exact match string, the token "*"
 * that matches any text, or the token "#" that matches only
 * numbers.
 * <p>
 * Starting from API level {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2},
 * this method will accept a leading slash in the path.
 *
 * @param authority the authority to match
 * @param path the path to match. * may be used as a wild card for
 * any text, and # may be used as a wild card for numbers.
 * @param code the code that is returned when a URI is matched
 * against the given components. Must be positive.
 * @apiSince 1
 */

public void addURI(java.lang.String authority, java.lang.String path, int code) { throw new RuntimeException("Stub!"); }

/**
 * Try to match against the path in a url.
 *
 * @param uri       The url whose path we will match against.
 *
 * @return  The code for the matched node (added using addURI),
 * or -1 if there is no matched node.
 * @apiSince 1
 */

public int match(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static final int NO_MATCH = -1; // 0xffffffff
}

