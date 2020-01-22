/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.widget;

import android.database.Cursor;
import android.content.Context;
import android.view.ViewGroup;
import android.content.res.Resources;

/**
 * An easy adapter that creates views defined in an XML file. You can specify
 * the XML file that defines the appearance of the views.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ResourceCursorAdapter extends android.widget.CursorAdapter {

/**
 * Constructor the enables auto-requery.
 *
 * @deprecated This option is discouraged, as it results in Cursor queries
 * being performed on the application's UI thread and thus can cause poor
 * responsiveness or even Application Not Responding errors.  As an alternative,
 * use {@link android.app.LoaderManager} with a {@link android.content.CursorLoader}.
 *
 * @param context The context where the ListView associated with this adapter is running
 * @param layout resource identifier of a layout file that defines the views
 *            for this list item.  Unless you override them later, this will
 *            define both the item views and the drop down views.
 * @apiSince 1
 */

@Deprecated
public ResourceCursorAdapter(android.content.Context context, int layout, android.database.Cursor c) { super((android.content.Context)null, (android.database.Cursor)null); throw new RuntimeException("Stub!"); }

/**
 * Constructor with default behavior as per
 * {@link android.widget.CursorAdapter#CursorAdapter(android.content.Context,android.database.Cursor,boolean) CursorAdapter#CursorAdapter(Context, Cursor, boolean)}; it is recommended
 * you not use this, but instead {@link #ResourceCursorAdapter(android.content.Context,int,android.database.Cursor,int)}.
 * When using this constructor, {@link #FLAG_REGISTER_CONTENT_OBSERVER}
 * will always be set.
 *
 * @param context The context where the ListView associated with this adapter is running
 * @param layout resource identifier of a layout file that defines the views
 *            for this list item.  Unless you override them later, this will
 *            define both the item views and the drop down views.
 * @param c The cursor from which to get the data.
 * @param autoRequery If true the adapter will call requery() on the
 *                    cursor whenever it changes so the most recent
 *                    data is always displayed.  Using true here is discouraged.
 * @apiSince 3
 */

public ResourceCursorAdapter(android.content.Context context, int layout, android.database.Cursor c, boolean autoRequery) { super((android.content.Context)null, (android.database.Cursor)null); throw new RuntimeException("Stub!"); }

/**
 * Standard constructor.
 *
 * @param context The context where the ListView associated with this adapter is running
 * @param layout Resource identifier of a layout file that defines the views
 *            for this list item.  Unless you override them later, this will
 *            define both the item views and the drop down views.
 * @param c The cursor from which to get the data.
 * @param flags Flags used to determine the behavior of the adapter,
 * as per {@link android.widget.CursorAdapter#CursorAdapter(android.content.Context,android.database.Cursor,int) CursorAdapter#CursorAdapter(Context, Cursor, int)}.
 * @apiSince 11
 */

public ResourceCursorAdapter(android.content.Context context, int layout, android.database.Cursor c, int flags) { super((android.content.Context)null, (android.database.Cursor)null); throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.content.res.Resources.Theme} against which drop-down views are
 * inflated.
 * <p>
 * By default, drop-down views are inflated against the theme of the
 * {@link android.content.Context Context} passed to the adapter's constructor.
 *
 * @param theme the theme against which to inflate drop-down views or
 *              {@code null} to use the theme from the adapter's context
 * @see #newDropDownView(Context, Cursor, ViewGroup)
 * @apiSince 23
 */

public void setDropDownViewTheme(android.content.res.Resources.Theme theme) { throw new RuntimeException("Stub!"); }

/**
 * Inflates view(s) from the specified XML file.
 *
 * @see android.widget.CursorAdapter#newView(android.content.Context,
 *      android.database.Cursor, ViewGroup)
 * @apiSince 1
 */

public android.view.View newView(android.content.Context context, android.database.Cursor cursor, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.view.View newDropDownView(android.content.Context context, android.database.Cursor cursor, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the layout resource of the item views.</p>
 *
 * @param layout the layout resources used to create item views
 * @apiSince 3
 */

public void setViewResource(int layout) { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the layout resource of the drop down views.</p>
 *
 * @param dropDownLayout the layout resources used to create drop down views
 * @apiSince 1
 */

public void setDropDownViewResource(int dropDownLayout) { throw new RuntimeException("Stub!"); }
}

