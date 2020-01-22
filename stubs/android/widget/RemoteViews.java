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

import android.view.ViewGroup;
import android.view.View;
import android.net.Uri;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.os.Parcelable;
import android.app.Activity;
import android.app.ActivityOptions;
import android.util.Pair;

/**
 * A class that describes a view hierarchy that can be displayed in
 * another process. The hierarchy is inflated from a layout resource
 * file, and this class provides some basic operations for modifying
 * the content of the inflated hierarchy.
 *
 * <p>{@code RemoteViews} is limited to support for the following layouts:</p>
 * <ul>
 *   <li>{@link android.widget.AdapterViewFlipper}</li>
 *   <li>{@link android.widget.FrameLayout}</li>
 *   <li>{@link android.widget.GridLayout}</li>
 *   <li>{@link android.widget.GridView}</li>
 *   <li>{@link android.widget.LinearLayout}</li>
 *   <li>{@link android.widget.ListView}</li>
 *   <li>{@link android.widget.RelativeLayout}</li>
 *   <li>{@link android.widget.StackView}</li>
 *   <li>{@link android.widget.ViewFlipper}</li>
 * </ul>
 * <p>And the following widgets:</p>
 * <ul>
 *   <li>{@link android.widget.AnalogClock}</li>
 *   <li>{@link android.widget.Button}</li>
 *   <li>{@link android.widget.Chronometer}</li>
 *   <li>{@link android.widget.ImageButton}</li>
 *   <li>{@link android.widget.ImageView}</li>
 *   <li>{@link android.widget.ProgressBar}</li>
 *   <li>{@link android.widget.TextClock}</li>
 *   <li>{@link android.widget.TextView}</li>
 * </ul>
 * <p>Descendants of these classes are not supported.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RemoteViews implements android.os.Parcelable, android.view.LayoutInflater.Filter {

/**
 * Create a new RemoteViews object that will display the views contained
 * in the specified layout file.
 *
 * @param packageName Name of the package that contains the layout resource
 * @param layoutId The id of the layout resource
 * @apiSince 1
 */

public RemoteViews(java.lang.String packageName, int layoutId) { throw new RuntimeException("Stub!"); }

/**
 * Create a new RemoteViews object that will inflate as the specified
 * landspace or portrait RemoteViews, depending on the current configuration.
 *
 * @param landscape The RemoteViews to inflate in landscape configuration
 * @param portrait The RemoteViews to inflate in portrait configuration
 * @apiSince 16
 */

public RemoteViews(android.widget.RemoteViews landscape, android.widget.RemoteViews portrait) { throw new RuntimeException("Stub!"); }

/**
 * Creates a copy of another RemoteViews.
 * @apiSince 28
 */

public RemoteViews(android.widget.RemoteViews src) { throw new RuntimeException("Stub!"); }

/**
 * Reads a RemoteViews object from a parcel.
 *
 * @param parcel
 * @apiSince 1
 */

public RemoteViews(android.os.Parcel parcel) { throw new RuntimeException("Stub!"); }

/**
 * Returns a deep copy of the RemoteViews object. The RemoteView may not be
 * attached to another RemoteView -- it must be the root of a hierarchy.
 *
 * @deprecated use {@link #RemoteViews(android.widget.RemoteViews)} instead.
 * @throws java.lang.IllegalStateException if this is not the root of a RemoteView
 *         hierarchy
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
public android.widget.RemoteViews clone() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getPackage() { throw new RuntimeException("Stub!"); }

/**
 * Returns the layout id of the root layout associated with this RemoteViews. In the case
 * that the RemoteViews has both a landscape and portrait root, this will return the layout
 * id associated with the portrait layout.
 *
 * @return the layout id.
 * @apiSince 1
 */

public int getLayoutId() { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.view.ViewGroup#addView(android.view.View) ViewGroup#addView(View)} after inflating the
 * given {@link android.widget.RemoteViews RemoteViews}. This allows users to build "nested"
 * {@link android.widget.RemoteViews RemoteViews}. In cases where consumers of {@link android.widget.RemoteViews RemoteViews} may
 * recycle layouts, use {@link #removeAllViews(int)} to clear any existing
 * children.
 *
 * @param viewId The id of the parent {@link android.view.ViewGroup ViewGroup} to add child into.
 * @param nestedView {@link android.widget.RemoteViews RemoteViews} that describes the child.
 * @apiSince 7
 */

public void addView(int viewId, android.widget.RemoteViews nestedView) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.view.ViewGroup#removeAllViews() ViewGroup#removeAllViews()}.
 *
 * @param viewId The id of the parent {@link android.view.ViewGroup ViewGroup} to remove all
 *            children from.
 * @apiSince 7
 */

public void removeAllViews(int viewId) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.AdapterViewAnimator#showNext() AdapterViewAnimator#showNext()}
 *
 * @param viewId The id of the view on which to call {@link android.widget.AdapterViewAnimator#showNext() AdapterViewAnimator#showNext()}
 * @apiSince 11
 */

public void showNext(int viewId) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.AdapterViewAnimator#showPrevious() AdapterViewAnimator#showPrevious()}
 *
 * @param viewId The id of the view on which to call {@link android.widget.AdapterViewAnimator#showPrevious() AdapterViewAnimator#showPrevious()}
 * @apiSince 11
 */

public void showPrevious(int viewId) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.AdapterViewAnimator#setDisplayedChild(int) AdapterViewAnimator#setDisplayedChild(int)}
 *
 * @param viewId The id of the view on which to call
 *               {@link android.widget.AdapterViewAnimator#setDisplayedChild(int) AdapterViewAnimator#setDisplayedChild(int)}
 * @apiSince 12
 */

public void setDisplayedChild(int viewId, int childIndex) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.view.View#setVisibility(int) View#setVisibility(int)}
 *
 * @param viewId The id of the view whose visibility should change
 * @param visibility The new visibility for the view
 * @apiSince 1
 */

public void setViewVisibility(int viewId, int visibility) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.TextView#setText(java.lang.CharSequence) TextView#setText(CharSequence)}
 *
 * @param viewId The id of the view whose text should change
 * @param text The new text for the view
 * @apiSince 1
 */

public void setTextViewText(int viewId, java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.TextView#setTextSize(int,float) TextView#setTextSize(int, float)}
 *
 * @param viewId The id of the view whose text size should change
 * @param units The units of size (e.g.&nbsp;COMPLEX_UNIT_SP)
 * @param size The size of the text
 * @apiSince 16
 */

public void setTextViewTextSize(int viewId, int units, float size) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling
 * {@link android.widget.TextView#setCompoundDrawablesWithIntrinsicBounds(int,int,int,int) TextView#setCompoundDrawablesWithIntrinsicBounds(int, int, int, int)}.
 *
 * @param viewId The id of the view whose text should change
 * @param left The id of a drawable to place to the left of the text, or 0
 * @param top The id of a drawable to place above the text, or 0
 * @param right The id of a drawable to place to the right of the text, or 0
 * @param bottom The id of a drawable to place below the text, or 0
 * @apiSince 16
 */

public void setTextViewCompoundDrawables(int viewId, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.TextView#setCompoundDrawablesRelativeWithIntrinsicBounds(int,int,int,int) TextView#setCompoundDrawablesRelativeWithIntrinsicBounds(int, int, int, int)}.
 *
 * @param viewId The id of the view whose text should change
 * @param start The id of a drawable to place before the text (relative to the
 * layout direction), or 0
 * @param top The id of a drawable to place above the text, or 0
 * @param end The id of a drawable to place after the text, or 0
 * @param bottom The id of a drawable to place below the text, or 0
 * @apiSince 16
 */

public void setTextViewCompoundDrawablesRelative(int viewId, int start, int top, int end, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.ImageView#setImageResource(int) ImageView#setImageResource(int)}
 *
 * @param viewId The id of the view whose drawable should change
 * @param srcId The new resource id for the drawable
 * @apiSince 1
 */

public void setImageViewResource(int viewId, int srcId) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.ImageView#setImageURI(android.net.Uri) ImageView#setImageURI(Uri)}
 *
 * @param viewId The id of the view whose drawable should change
 * @param uri The Uri for the image
 * @apiSince 1
 */

public void setImageViewUri(int viewId, android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.ImageView#setImageBitmap(android.graphics.Bitmap) ImageView#setImageBitmap(Bitmap)}
 *
 * @param viewId The id of the view whose bitmap should change
 * @param bitmap The new Bitmap for the drawable
 * @apiSince 3
 */

public void setImageViewBitmap(int viewId, android.graphics.Bitmap bitmap) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.ImageView#setImageIcon(android.graphics.drawable.Icon) ImageView#setImageIcon(Icon)}
 *
 * @param viewId The id of the view whose bitmap should change
 * @param icon The new Icon for the ImageView
 * @apiSince 23
 */

public void setImageViewIcon(int viewId, android.graphics.drawable.Icon icon) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.AdapterView#setEmptyView(android.view.View) AdapterView#setEmptyView(View)}
 *
 * @param viewId The id of the view on which to set the empty view
 * @param emptyViewId The view id of the empty view
 * @apiSince 11
 */

public void setEmptyView(int viewId, int emptyViewId) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.Chronometer#setBase Chronometer#setBase},
 * {@link android.widget.Chronometer#setFormat Chronometer#setFormat},
 * and {@link android.widget.Chronometer#start Chronometer#start} or
 * {@link android.widget.Chronometer#stop Chronometer#stop}.
 *
 * @param viewId The id of the {@link android.widget.Chronometer Chronometer} to change
 * @param base The time at which the timer would have read 0:00.  This
 *             time should be based off of
 *             {@link android.os.SystemClock#elapsedRealtime SystemClock.elapsedRealtime()}.
 * @param format The Chronometer format string, or null to
 *               simply display the timer value.
 * @param started True if you want the clock to be started, false if not.
 *
 * @see #setChronometerCountDown(int, boolean)
 * @apiSince 1
 */

public void setChronometer(int viewId, long base, java.lang.String format, boolean started) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.Chronometer#setCountDown(boolean) Chronometer#setCountDown(boolean)} on
 * the chronometer with the given viewId.
 *
 * @param viewId The id of the {@link android.widget.Chronometer Chronometer} to change
 * @param isCountDown True if you want the chronometer to count down to base instead of
 *                    counting up.
 * @apiSince 24
 */

public void setChronometerCountDown(int viewId, boolean isCountDown) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.ProgressBar#setMax ProgressBar#setMax},
 * {@link android.widget.ProgressBar#setProgress ProgressBar#setProgress}, and
 * {@link android.widget.ProgressBar#setIndeterminate ProgressBar#setIndeterminate}
 *
 * If indeterminate is true, then the values for max and progress are ignored.
 *
 * @param viewId The id of the {@link android.widget.ProgressBar ProgressBar} to change
 * @param max The 100% value for the progress bar
 * @param progress The current value of the progress bar.
 * @param indeterminate True if the progress bar is indeterminate,
 *                false if not.
 * @apiSince 1
 */

public void setProgressBar(int viewId, int max, int progress, boolean indeterminate) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling
 * {@link android.view.View#setOnClickListener(android.view.View.OnClickListener)}
 * to launch the provided {@link android.app.PendingIntent PendingIntent}. The source bounds
 * ({@link android.content.Intent#getSourceBounds() Intent#getSourceBounds()}) of the intent will be set to the bounds of the clicked
 * view in screen space.
 * Note that any activity options associated with the mPendingIntent may get overridden
 * before starting the intent.
 *
 * When setting the on-click action of items within collections (eg. {@link android.widget.ListView ListView},
 * {@link android.widget.StackView StackView} etc.), this method will not work. Instead, use {@link android.widget.RemoteViews#setPendingIntentTemplate(int,android.app.PendingIntent) RemoteViews#setPendingIntentTemplate(int, PendingIntent)} in conjunction with
 * {@link android.widget.RemoteViews#setOnClickFillInIntent(int,android.content.Intent) RemoteViews#setOnClickFillInIntent(int, Intent)}.
 *
 * @param viewId The id of the view that will trigger the {@link android.app.PendingIntent PendingIntent} when clicked
 * @param pendingIntent The {@link android.app.PendingIntent PendingIntent} to send when user clicks
 * @apiSince 3
 */

public void setOnClickPendingIntent(int viewId, android.app.PendingIntent pendingIntent) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent of calling
 * {@link android.view.View#setOnClickListener(android.view.View.OnClickListener)}
 * to launch the provided {@link android.widget.RemoteViews.RemoteResponse RemoteResponse}.
 *
 * @param viewId The id of the view that will trigger the {@link android.widget.RemoteViews.RemoteResponse RemoteResponse} when clicked
 * @param response The {@link android.widget.RemoteViews.RemoteResponse RemoteResponse} to send when user clicks
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void setOnClickResponse(int viewId, @androidx.annotation.NonNull android.widget.RemoteViews.RemoteResponse response) { throw new RuntimeException("Stub!"); }

/**
 * When using collections (eg. {@link android.widget.ListView ListView}, {@link android.widget.StackView StackView} etc.) in widgets, it is very
 * costly to set PendingIntents on the individual items, and is hence not permitted. Instead
 * this method should be used to set a single PendingIntent template on the collection, and
 * individual items can differentiate their on-click behavior using
 * {@link android.widget.RemoteViews#setOnClickFillInIntent(int,android.content.Intent) RemoteViews#setOnClickFillInIntent(int, Intent)}.
 *
 * @param viewId The id of the collection who's children will use this PendingIntent template
 *          when clicked
 * @param pendingIntentTemplate The {@link android.app.PendingIntent PendingIntent} to be combined with extras specified
 *          by a child of viewId and executed when that child is clicked
 * @apiSince 11
 */

public void setPendingIntentTemplate(int viewId, android.app.PendingIntent pendingIntentTemplate) { throw new RuntimeException("Stub!"); }

/**
 * When using collections (eg. {@link android.widget.ListView ListView}, {@link android.widget.StackView StackView} etc.) in widgets, it is very
 * costly to set PendingIntents on the individual items, and is hence not permitted. Instead
 * a single PendingIntent template can be set on the collection, see {@link android.widget.RemoteViews#setPendingIntentTemplate(int,android.app.PendingIntent) RemoteViews#setPendingIntentTemplate(int, PendingIntent)}, and the individual on-click
 * action of a given item can be distinguished by setting a fillInIntent on that item. The
 * fillInIntent is then combined with the PendingIntent template in order to determine the final
 * intent which will be executed when the item is clicked. This works as follows: any fields
 * which are left blank in the PendingIntent template, but are provided by the fillInIntent
 * will be overwritten, and the resulting PendingIntent will be used. The rest
 * of the PendingIntent template will then be filled in with the associated fields that are
 * set in fillInIntent. See {@link android.content.Intent#fillIn(android.content.Intent,int) Intent#fillIn(Intent, int)} for more details.
 *
 * @param viewId The id of the view on which to set the fillInIntent
 * @param fillInIntent The intent which will be combined with the parent's PendingIntent
 *        in order to determine the on-click behavior of the view specified by viewId
 * @apiSince 11
 */

public void setOnClickFillInIntent(int viewId, android.content.Intent fillInIntent) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.TextView#setTextColor(int)}.
 *
 * @param viewId The id of the view whose text color should change
 * @param color Sets the text color for all the states (normal, selected,
 *            focused) to be this color.
 * @apiSince 3
 */

public void setTextColor(int viewId, int color) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.AbsListView#setRemoteViewsAdapter(Intent)}.
 *
 * @param appWidgetId The id of the app widget which contains the specified view. (This
 *      parameter is ignored in this deprecated method)
 * @param viewId The id of the {@link android.widget.AdapterView AdapterView}
 * @param intent The intent of the service which will be
 *            providing data to the RemoteViewsAdapter
 * @deprecated This method has been deprecated. See
 *      {@link android.widget.RemoteViews#setRemoteAdapter(int, Intent)}
 * @apiSince 11
 * @deprecatedSince 15
 */

@Deprecated
public void setRemoteAdapter(int appWidgetId, int viewId, android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.AbsListView#setRemoteViewsAdapter(Intent)}.
 * Can only be used for App Widgets.
 *
 * @param viewId The id of the {@link android.widget.AdapterView AdapterView}
 * @param intent The intent of the service which will be
 *            providing data to the RemoteViewsAdapter
 * @apiSince 14
 */

public void setRemoteAdapter(int viewId, android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.ListView#smoothScrollToPosition(int) ListView#smoothScrollToPosition(int)}.
 *
 * @param viewId The id of the view to change
 * @param position Scroll to this adapter position
 * @apiSince 11
 */

public void setScrollPosition(int viewId, int position) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.widget.ListView#smoothScrollByOffset(int) ListView#smoothScrollByOffset(int)}.
 *
 * @param viewId The id of the view to change
 * @param offset Scroll by this adapter position offset
 * @apiSince 11
 */

public void setRelativeScrollPosition(int viewId, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.view.View#setPadding(int, int, int, int)}.
 *
 * @param viewId The id of the view to change
 * @param left the left padding in pixels
 * @param top the top padding in pixels
 * @param right the right padding in pixels
 * @param bottom the bottom padding in pixels
 * @apiSince 16
 */

public void setViewPadding(int viewId, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Call a method taking one boolean on a view in the layout for this RemoteViews.
 *
 * @param viewId The id of the view on which to call the method.
 * @param methodName The name of the method to call.
 * @param value The value to pass to the method.
 * @apiSince 3
 */

public void setBoolean(int viewId, java.lang.String methodName, boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Call a method taking one byte on a view in the layout for this RemoteViews.
 *
 * @param viewId The id of the view on which to call the method.
 * @param methodName The name of the method to call.
 * @param value The value to pass to the method.
 * @apiSince 3
 */

public void setByte(int viewId, java.lang.String methodName, byte value) { throw new RuntimeException("Stub!"); }

/**
 * Call a method taking one short on a view in the layout for this RemoteViews.
 *
 * @param viewId The id of the view on which to call the method.
 * @param methodName The name of the method to call.
 * @param value The value to pass to the method.
 * @apiSince 3
 */

public void setShort(int viewId, java.lang.String methodName, short value) { throw new RuntimeException("Stub!"); }

/**
 * Call a method taking one int on a view in the layout for this RemoteViews.
 *
 * @param viewId The id of the view on which to call the method.
 * @param methodName The name of the method to call.
 * @param value The value to pass to the method.
 * @apiSince 3
 */

public void setInt(int viewId, java.lang.String methodName, int value) { throw new RuntimeException("Stub!"); }

/**
 * Call a method taking one long on a view in the layout for this RemoteViews.
 *
 * @param viewId The id of the view on which to call the method.
 * @param methodName The name of the method to call.
 * @param value The value to pass to the method.
 * @apiSince 3
 */

public void setLong(int viewId, java.lang.String methodName, long value) { throw new RuntimeException("Stub!"); }

/**
 * Call a method taking one float on a view in the layout for this RemoteViews.
 *
 * @param viewId The id of the view on which to call the method.
 * @param methodName The name of the method to call.
 * @param value The value to pass to the method.
 * @apiSince 3
 */

public void setFloat(int viewId, java.lang.String methodName, float value) { throw new RuntimeException("Stub!"); }

/**
 * Call a method taking one double on a view in the layout for this RemoteViews.
 *
 * @param viewId The id of the view on which to call the method.
 * @param methodName The name of the method to call.
 * @param value The value to pass to the method.
 * @apiSince 3
 */

public void setDouble(int viewId, java.lang.String methodName, double value) { throw new RuntimeException("Stub!"); }

/**
 * Call a method taking one char on a view in the layout for this RemoteViews.
 *
 * @param viewId The id of the view on which to call the method.
 * @param methodName The name of the method to call.
 * @param value The value to pass to the method.
 * @apiSince 3
 */

public void setChar(int viewId, java.lang.String methodName, char value) { throw new RuntimeException("Stub!"); }

/**
 * Call a method taking one String on a view in the layout for this RemoteViews.
 *
 * @param viewId The id of the view on which to call the method.
 * @param methodName The name of the method to call.
 * @param value The value to pass to the method.
 * @apiSince 3
 */

public void setString(int viewId, java.lang.String methodName, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Call a method taking one CharSequence on a view in the layout for this RemoteViews.
 *
 * @param viewId The id of the view on which to call the method.
 * @param methodName The name of the method to call.
 * @param value The value to pass to the method.
 * @apiSince 3
 */

public void setCharSequence(int viewId, java.lang.String methodName, java.lang.CharSequence value) { throw new RuntimeException("Stub!"); }

/**
 * Call a method taking one Uri on a view in the layout for this RemoteViews.
 *
 * @param viewId The id of the view on which to call the method.
 * @param methodName The name of the method to call.
 * @param value The value to pass to the method.
 * @apiSince 3
 */

public void setUri(int viewId, java.lang.String methodName, android.net.Uri value) { throw new RuntimeException("Stub!"); }

/**
 * Call a method taking one Bitmap on a view in the layout for this RemoteViews.
 * @more
 * <p class="note">The bitmap will be flattened into the parcel if this object is
 * sent across processes, so it may end up using a lot of memory, and may be fairly slow.</p>
 *
 * @param viewId The id of the view on which to call the method.
 * @param methodName The name of the method to call.
 * @param value The value to pass to the method.
 * @apiSince 3
 */

public void setBitmap(int viewId, java.lang.String methodName, android.graphics.Bitmap value) { throw new RuntimeException("Stub!"); }

/**
 * Call a method taking one Bundle on a view in the layout for this RemoteViews.
 *
 * @param viewId The id of the view on which to call the method.
 * @param methodName The name of the method to call.
 * @param value The value to pass to the method.
 * @apiSince 8
 */

public void setBundle(int viewId, java.lang.String methodName, android.os.Bundle value) { throw new RuntimeException("Stub!"); }

/**
 * Call a method taking one Intent on a view in the layout for this RemoteViews.
 *
 * @param viewId The id of the view on which to call the method.
 * @param methodName The name of the method to call.
 * @param value The {@link android.content.Intent} to pass the method.
 * @apiSince 11
 */

public void setIntent(int viewId, java.lang.String methodName, android.content.Intent value) { throw new RuntimeException("Stub!"); }

/**
 * Call a method taking one Icon on a view in the layout for this RemoteViews.
 *
 * @param viewId The id of the view on which to call the method.
 * @param methodName The name of the method to call.
 * @param value The {@link android.graphics.drawable.Icon} to pass the method.
 * @apiSince 23
 */

public void setIcon(int viewId, java.lang.String methodName, android.graphics.drawable.Icon value) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling View.setContentDescription(CharSequence).
 *
 * @param viewId The id of the view whose content description should change.
 * @param contentDescription The new content description for the view.
 * @apiSince 15
 */

public void setContentDescription(int viewId, java.lang.CharSequence contentDescription) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.view.View#setAccessibilityTraversalBefore(int)}.
 *
 * @param viewId The id of the view whose before view in accessibility traversal to set.
 * @param nextId The id of the next in the accessibility traversal.
 *     * @apiSince 22
 */

public void setAccessibilityTraversalBefore(int viewId, int nextId) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.view.View#setAccessibilityTraversalAfter(int)}.
 *
 * @param viewId The id of the view whose after view in accessibility traversal to set.
 * @param nextId The id of the next in the accessibility traversal.
 *     * @apiSince 22
 */

public void setAccessibilityTraversalAfter(int viewId, int nextId) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link android.view.View#setLabelFor(int) View#setLabelFor(int)}.
 *
 * @param viewId The id of the view whose property to set.
 * @param labeledId The id of a view for which this view serves as a label.
 * @apiSince 17
 */

public void setLabelFor(int viewId, int labeledId) { throw new RuntimeException("Stub!"); }

/**
 * Provides an alternate layout ID, which can be used to inflate this view. This layout will be
 * used by the host when the widgets displayed on a light-background where foreground elements
 * and text can safely draw using a dark color without any additional background protection.
 * @apiSince 29
 */

public void setLightBackgroundLayoutId(int layoutId) { throw new RuntimeException("Stub!"); }

/**
 * Inflates the view hierarchy represented by this object and applies
 * all of the actions.
 *
 * <p><strong>Caller beware: this may throw</strong>
 *
 * @param context Default context to use
 * @param parent Parent that the resulting view hierarchy will be attached to. This method
 * does <strong>not</strong> attach the hierarchy. The caller should do so when appropriate.
 * @return The inflated view hierarchy
 * @apiSince 1
 */

public android.view.View apply(android.content.Context context, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/**
 * Applies all of the actions to the provided view.
 *
 * <p><strong>Caller beware: this may throw</strong>
 *
 * @param v The view to apply the actions to.  This should be the result of
 * the {@link #apply(android.content.Context,android.view.ViewGroup)} call.
 * @apiSince 1
 */

public void reapply(android.content.Context context, android.view.View v) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onLoadClass(java.lang.Class clazz) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Parcelable.Creator that instantiates RemoteViews objects
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.widget.RemoteViews> CREATOR;
static { CREATOR = null; }

/**
 * The intent extra that contains the bounds for all shared elements.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_SHARED_ELEMENT_BOUNDS = "android.widget.extra.SHARED_ELEMENT_BOUNDS";
/**
 * Exception to send when something goes wrong executing an action
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class ActionException extends java.lang.RuntimeException {

/** @apiSince 3 */

public ActionException(java.lang.Exception ex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ActionException(java.lang.String message) { throw new RuntimeException("Stub!"); }
}

/**
 * Class representing a response to an action performed on any element of a RemoteViews.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class RemoteResponse {

public RemoteResponse() { throw new RuntimeException("Stub!"); }

/**
 * Creates a response which sends a pending intent as part of the response. The source
 * bounds ({@link android.content.Intent#getSourceBounds() Intent#getSourceBounds()}) of the intent will be set to the bounds of the
 * target view in screen space.
 * Note that any activity options associated with the mPendingIntent may get overridden
 * before starting the intent.
 *
 * @param pendingIntent The {@link android.app.PendingIntent PendingIntent} to send as part of the response
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.widget.RemoteViews.RemoteResponse fromPendingIntent(@androidx.annotation.NonNull android.app.PendingIntent pendingIntent) { throw new RuntimeException("Stub!"); }

/**
 * When using collections (eg. {@link android.widget.ListView ListView}, {@link android.widget.StackView StackView} etc.) in widgets, it is
 * very costly to set PendingIntents on the individual items, and is hence not permitted.
 * Instead a single PendingIntent template can be set on the collection, see {@link android.widget.RemoteViews#setPendingIntentTemplate(int,android.app.PendingIntent) RemoteViews#setPendingIntentTemplate(int, PendingIntent)}, and the individual on-click
 * action of a given item can be distinguished by setting a fillInIntent on that item. The
 * fillInIntent is then combined with the PendingIntent template in order to determine the
 * final intent which will be executed when the item is clicked. This works as follows: any
 * fields which are left blank in the PendingIntent template, but are provided by the
 * fillInIntent will be overwritten, and the resulting PendingIntent will be used. The rest
 * of the PendingIntent template will then be filled in with the associated fields that are
 * set in fillInIntent. See {@link android.content.Intent#fillIn(android.content.Intent,int) Intent#fillIn(Intent, int)} for more details.
 * Creates a response which sends a pending intent as part of the response. The source
 * bounds ({@link android.content.Intent#getSourceBounds() Intent#getSourceBounds()}) of the intent will be set to the bounds of the
 * target view in screen space.
 * Note that any activity options associated with the mPendingIntent may get overridden
 * before starting the intent.
 *
 * @param fillIntent The intent which will be combined with the parent's PendingIntent in
 *                  order to determine the behavior of the response
 *
 * This value must never be {@code null}.
 * @see android.widget.RemoteViews#setPendingIntentTemplate(int, PendingIntent)
 * @see android.widget.RemoteViews#setOnClickFillInIntent(int, Intent)
 * @return
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.widget.RemoteViews.RemoteResponse fromFillInIntent(@androidx.annotation.NonNull android.content.Intent fillIntent) { throw new RuntimeException("Stub!"); }

/**
 * Adds a shared element to be transferred as part of the transition between Activities
 * using cross-Activity scene animations. The position of the first element will be used as
 * the epicenter for the exit Transition. The position of the associated shared element in
 * the launched Activity will be the epicenter of its entering Transition.
 *
 * @param viewId The id of the view to be shared as part of the transition
 * @param sharedElementName The shared element name for this view
 *
 * This value must never be {@code null}.
 * @see android.app.ActivityOptions#makeSceneTransitionAnimation(Activity, Pair[])
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.widget.RemoteViews.RemoteResponse addSharedElement(int viewId, @androidx.annotation.NonNull java.lang.String sharedElementName) { throw new RuntimeException("Stub!"); }
}

/**
 * This annotation indicates that a subclass of View is allowed to be used
 * with the {@link android.widget.RemoteViews RemoteViews} mechanism.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
public static @interface RemoteView {
}

}

