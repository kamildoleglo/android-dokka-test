/**
 * Copyright (c) 2010, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.content;

import android.net.Uri;
import android.text.Html;
import android.text.Spanned;

/**
 * Representation of a clipped data on the clipboard.
 *
 * <p>ClipData is a complex type containing one or more Item instances,
 * each of which can hold one or more representations of an item of data.
 * For display to the user, it also has a label.</p>
 *
 * <p>A ClipData contains a {@link android.content.ClipDescription ClipDescription}, which describes
 * important meta-data about the clip.  In particular, its
 * {@link android.content.ClipDescription#getMimeType(int) ClipDescription#getMimeType(int)}
 * must return correct MIME type(s) describing the data in the clip.  For help
 * in correctly constructing a clip with the correct MIME type, use
 * {@link #newPlainText(java.lang.CharSequence,java.lang.CharSequence)},
 * {@link #newUri(android.content.ContentResolver,java.lang.CharSequence,android.net.Uri)}, and
 * {@link #newIntent(java.lang.CharSequence,android.content.Intent)}.
 *
 * <p>Each Item instance can be one of three main classes of data: a simple
 * CharSequence of text, a single Intent object, or a Uri.  See {@link android.content.ClipData.Item Item}
 * for more details.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using the clipboard framework, read the
 * <a href="{@docRoot}guide/topics/clipboard/copy-paste.html">Copy and Paste</a>
 * developer guide.</p>
 * </div>
 *
 * <a name="ImplementingPaste"></a>
 * <h3>Implementing Paste or Drop</h3>
 *
 * <p>To implement a paste or drop of a ClipData object into an application,
 * the application must correctly interpret the data for its use.  If the {@link android.content.ClipData.Item Item}
 * it contains is simple text or an Intent, there is little to be done: text
 * can only be interpreted as text, and an Intent will typically be used for
 * creating shortcuts (such as placing icons on the home screen) or other
 * actions.
 *
 * <p>If all you want is the textual representation of the clipped data, you
 * can use the convenience method {@link android.content.ClipData.Item#coerceToText Item#coerceToText}.
 * In this case there is generally no need to worry about the MIME types
 * reported by {@link android.content.ClipDescription#getMimeType(int) ClipDescription#getMimeType(int)},
 * since any clip item can always be converted to a string.
 *
 * <p>More complicated exchanges will be done through URIs, in particular
 * "content:" URIs.  A content URI allows the recipient of a ClipData item
 * to interact closely with the ContentProvider holding the data in order to
 * negotiate the transfer of that data.  The clip must also be filled in with
 * the available MIME types; {@link #newUri(android.content.ContentResolver,java.lang.CharSequence,android.net.Uri)}
 * will take care of correctly doing this.
 *
 * <p>For example, here is the paste function of a simple NotePad application.
 * When retrieving the data from the clipboard, it can do either two things:
 * if the clipboard contains a URI reference to an existing note, it copies
 * the entire structure of the note into a new note; otherwise, it simply
 * coerces the clip into text and uses that as the new note's contents.
 *
 * {@sample development/samples/NotePad/src/com/example/android/notepad/NoteEditor.java
 *      paste}
 *
 * <p>In many cases an application can paste various types of streams of data.  For
 * example, an e-mail application may want to allow the user to paste an image
 * or other binary data as an attachment.  This is accomplished through the
 * ContentResolver {@link android.content.ContentResolver#getStreamTypes(android.net.Uri,java.lang.String) ContentResolver#getStreamTypes(Uri, String)} and
 * {@link android.content.ContentResolver#openTypedAssetFileDescriptor(android.net.Uri,java.lang.String,android.os.Bundle) ContentResolver#openTypedAssetFileDescriptor(Uri, String, android.os.Bundle)}
 * methods.  These allow a client to discover the type(s) of data that a particular
 * content URI can make available as a stream and retrieve the stream of data.
 *
 * <p>For example, the implementation of {@link android.content.ClipData.Item#coerceToText Item#coerceToText}
 * itself uses this to try to retrieve a URI clip as a stream of text:
 *
 * {@sample frameworks/base/core/java/android/content/ClipData.java coerceToText}
 *
 * <a name="ImplementingCopy"></a>
 * <h3>Implementing Copy or Drag</h3>
 *
 * <p>To be the source of a clip, the application must construct a ClipData
 * object that any recipient can interpret best for their context.  If the clip
 * is to contain a simple text, Intent, or URI, this is easy: an {@link android.content.ClipData.Item Item}
 * containing the appropriate data type can be constructed and used.
 *
 * <p>More complicated data types require the implementation of support in
 * a ContentProvider for describing and generating the data for the recipient.
 * A common scenario is one where an application places on the clipboard the
 * content: URI of an object that the user has copied, with the data at that
 * URI consisting of a complicated structure that only other applications with
 * direct knowledge of the structure can use.
 *
 * <p>For applications that do not have intrinsic knowledge of the data structure,
 * the content provider holding it can make the data available as an arbitrary
 * number of types of data streams.  This is done by implementing the
 * ContentProvider {@link android.content.ContentProvider#getStreamTypes(android.net.Uri,java.lang.String) ContentProvider#getStreamTypes(Uri, String)} and
 * {@link android.content.ContentProvider#openTypedAssetFile(android.net.Uri,java.lang.String,android.os.Bundle) ContentProvider#openTypedAssetFile(Uri, String, android.os.Bundle)}
 * methods.
 *
 * <p>Going back to our simple NotePad application, this is the implementation
 * it may have to convert a single note URI (consisting of a title and the note
 * text) into a stream of plain text data.
 *
 * {@sample development/samples/NotePad/src/com/example/android/notepad/NotePadProvider.java
 *      stream}
 *
 * <p>The copy operation in our NotePad application is now just a simple matter
 * of making a clip containing the URI of the note being copied:
 *
 * {@sample development/samples/NotePad/src/com/example/android/notepad/NotesList.java
 *      copy}
 *
 * <p>Note if a paste operation needs this clip as text (for example to paste
 * into an editor), then {@link android.content.ClipData.Item#coerceToText(android.content.Context) Item#coerceToText(Context)} will ask the content
 * provider for the clip URI as text and successfully paste the entire note.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ClipData implements android.os.Parcelable {

/**
 * Create a new clip.
 *
 * @param label Label to show to the user describing this clip.
 * @param mimeTypes An array of MIME types this data is available as.
 * @param item The contents of the first item in the clip.
 * @apiSince 11
 */

public ClipData(java.lang.CharSequence label, java.lang.String[] mimeTypes, android.content.ClipData.Item item) { throw new RuntimeException("Stub!"); }

/**
 * Create a new clip.
 *
 * @param description The ClipDescription describing the clip contents.
 * @param item The contents of the first item in the clip.
 * @apiSince 11
 */

public ClipData(android.content.ClipDescription description, android.content.ClipData.Item item) { throw new RuntimeException("Stub!"); }

/**
 * Create a new clip that is a copy of another clip.  This does a deep-copy
 * of all items in the clip.
 *
 * @param other The existing ClipData that is to be copied.
 * @apiSince 16
 */

public ClipData(android.content.ClipData other) { throw new RuntimeException("Stub!"); }

/**
 * Create a new ClipData holding data of the type
 * {@link android.content.ClipDescription#MIMETYPE_TEXT_PLAIN ClipDescription#MIMETYPE_TEXT_PLAIN}.
 *
 * @param label User-visible label for the clip data.
 * @param text The actual text in the clip.
 * @return Returns a new ClipData containing the specified data.
 * @apiSince 11
 */

public static android.content.ClipData newPlainText(java.lang.CharSequence label, java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Create a new ClipData holding data of the type
 * {@link android.content.ClipDescription#MIMETYPE_TEXT_HTML ClipDescription#MIMETYPE_TEXT_HTML}.
 *
 * @param label User-visible label for the clip data.
 * @param text The text of clip as plain text, for receivers that don't
 * handle HTML.  This is required.
 * @param htmlText The actual HTML text in the clip.
 * @return Returns a new ClipData containing the specified data.
 * @apiSince 16
 */

public static android.content.ClipData newHtmlText(java.lang.CharSequence label, java.lang.CharSequence text, java.lang.String htmlText) { throw new RuntimeException("Stub!"); }

/**
 * Create a new ClipData holding an Intent with MIME type
 * {@link android.content.ClipDescription#MIMETYPE_TEXT_INTENT ClipDescription#MIMETYPE_TEXT_INTENT}.
 *
 * @param label User-visible label for the clip data.
 * @param intent The actual Intent in the clip.
 * @return Returns a new ClipData containing the specified data.
 * @apiSince 11
 */

public static android.content.ClipData newIntent(java.lang.CharSequence label, android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Create a new ClipData holding a URI.  If the URI is a content: URI,
 * this will query the content provider for the MIME type of its data and
 * use that as the MIME type.  Otherwise, it will use the MIME type
 * {@link android.content.ClipDescription#MIMETYPE_TEXT_URILIST ClipDescription#MIMETYPE_TEXT_URILIST}.
 *
 * @param resolver ContentResolver used to get information about the URI.
 * @param label User-visible label for the clip data.
 * @param uri The URI in the clip.
 * @return Returns a new ClipData containing the specified data.
 * @apiSince 11
 */

public static android.content.ClipData newUri(android.content.ContentResolver resolver, java.lang.CharSequence label, android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Create a new ClipData holding an URI with MIME type
 * {@link android.content.ClipDescription#MIMETYPE_TEXT_URILIST ClipDescription#MIMETYPE_TEXT_URILIST}.
 * Unlike {@link #newUri(android.content.ContentResolver,java.lang.CharSequence,android.net.Uri)}, nothing
 * is inferred about the URI -- if it is a content: URI holding a bitmap,
 * the reported type will still be uri-list.  Use this with care!
 *
 * @param label User-visible label for the clip data.
 * @param uri The URI in the clip.
 * @return Returns a new ClipData containing the specified data.
 * @apiSince 11
 */

public static android.content.ClipData newRawUri(java.lang.CharSequence label, android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Return the {@link android.content.ClipDescription ClipDescription} associated with this data, describing
 * what it contains.
 * @apiSince 11
 */

public android.content.ClipDescription getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Add a new Item to the overall ClipData container.
 * <p> This method will <em>not</em> update the list of available MIME types in the
 * {@link android.content.ClipDescription ClipDescription}. It should be used only when adding items which do not add new
 * MIME types to this clip. If this is not the case, use {@link #addItem(android.content.ContentResolver,android.content.ClipData.Item)}
 * or call {@link #ClipData(java.lang.CharSequence,java.lang.String[],android.content.ClipData.Item)} with a complete list of MIME types.
 * @param item Item to be added.
 * @apiSince 11
 */

public void addItem(android.content.ClipData.Item item) { throw new RuntimeException("Stub!"); }

/**
 * Add a new Item to the overall ClipData container.
 * <p> Unlike {@link #addItem(android.content.ClipData.Item)}, this method will update the list of available MIME types
 * in the {@link android.content.ClipDescription ClipDescription}.
 * @param resolver ContentResolver used to get information about the URI possibly contained in
 * the item.
 * @param item Item to be added.
 * @apiSince 26
 */

public void addItem(android.content.ContentResolver resolver, android.content.ClipData.Item item) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of items in the clip data.
 * @apiSince 11
 */

public int getItemCount() { throw new RuntimeException("Stub!"); }

/**
 * Return a single item inside of the clip data.  The index can range
 * from 0 to {@link #getItemCount()}-1.
 * @apiSince 11
 */

public android.content.ClipData.Item getItemAt(int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.ClipData> CREATOR;
static { CREATOR = null; }
/**
 * Description of a single item in a ClipData.
 *
 * <p>The types than an individual item can currently contain are:</p>
 *
 * <ul>
 * <li> Text: a basic string of text.  This is actually a CharSequence,
 * so it can be formatted text supported by corresponding Android built-in
 * style spans.  (Custom application spans are not supported and will be
 * stripped when transporting through the clipboard.)
 * <li> Intent: an arbitrary Intent object.  A typical use is the shortcut
 * to create when pasting a clipped item on to the home screen.
 * <li> Uri: a URI reference.  This may be any URI (such as an http: URI
 * representing a bookmark), however it is often a content: URI.  Using
 * content provider references as clips like this allows an application to
 * share complex or large clips through the standard content provider
 * facilities.
 * </ul>
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Item {

/**
 * Create an Item consisting of a single block of (possibly styled) text.
 * @apiSince 11
 */

public Item(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Create an Item consisting of a single block of (possibly styled) text,
 * with an alternative HTML formatted representation.  You <em>must</em>
 * supply a plain text representation in addition to HTML text; coercion
 * will not be done from HTML formatted text into plain text.
 * <p class="note"><strong>Note:</strong> It is strongly recommended to
 * use content: URI for sharing large clip data. Starting on API 30,
 * ClipData.Item doesn't accept an HTML text if it's larger than 800KB.
 * </p>
 * @apiSince 16
 */

public Item(java.lang.CharSequence text, java.lang.String htmlText) { throw new RuntimeException("Stub!"); }

/**
 * Create an Item consisting of an arbitrary Intent.
 * @apiSince 11
 */

public Item(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Create an Item consisting of an arbitrary URI.
 * @apiSince 11
 */

public Item(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Create a complex Item, containing multiple representations of
 * text, Intent, and/or URI.
 * @apiSince 11
 */

public Item(java.lang.CharSequence text, android.content.Intent intent, android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Create a complex Item, containing multiple representations of
 * text, HTML text, Intent, and/or URI.  If providing HTML text, you
 * <em>must</em> supply a plain text representation as well; coercion
 * will not be done from HTML formatted text into plain text.
 * @apiSince 16
 */

public Item(java.lang.CharSequence text, java.lang.String htmlText, android.content.Intent intent, android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the raw text contained in this Item.
 * @apiSince 11
 */

public java.lang.CharSequence getText() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the raw HTML text contained in this Item.
 * @apiSince 16
 */

public java.lang.String getHtmlText() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the raw Intent contained in this Item.
 * @apiSince 11
 */

public android.content.Intent getIntent() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the raw URI contained in this Item.
 * @apiSince 11
 */

public android.net.Uri getUri() { throw new RuntimeException("Stub!"); }

/**
 * Turn this item into text, regardless of the type of data it
 * actually contains.
 *
 * <p>The algorithm for deciding what text to return is:
 * <ul>
 * <li> If {@link #getText} is non-null, return that.
 * <li> If {@link #getUri} is non-null, try to retrieve its data
 * as a text stream from its content provider.  If this succeeds, copy
 * the text into a String and return it.  If it is not a content: URI or
 * the content provider does not supply a text representation, return
 * the raw URI as a string.
 * <li> If {@link #getIntent} is non-null, convert that to an intent:
 * URI and return it.
 * <li> Otherwise, return an empty string.
 * </ul>
 *
 * @param context The caller's Context, from which its ContentResolver
 * and other things can be retrieved.
 * @return Returns the item's textual representation.
 * @apiSince 11
 */

public java.lang.CharSequence coerceToText(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #coerceToHtmlText(android.content.Context)}, but any text that would
 * be returned as HTML formatting will be returned as text with
 * style spans.
 * @param context The caller's Context, from which its ContentResolver
 * and other things can be retrieved.
 * @return Returns the item's textual representation.
 * @apiSince 16
 */

public java.lang.CharSequence coerceToStyledText(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Turn this item into HTML text, regardless of the type of data it
 * actually contains.
 *
 * <p>The algorithm for deciding what text to return is:
 * <ul>
 * <li> If {@link #getHtmlText} is non-null, return that.
 * <li> If {@link #getText} is non-null, return that, converting to
 * valid HTML text.  If this text contains style spans,
 * {@link android.text.Html#toHtml(android.text.Spanned) Html#toHtml(Spanned)} is used to
 * convert them to HTML formatting.
 * <li> If {@link #getUri} is non-null, try to retrieve its data
 * as a text stream from its content provider.  If the provider can
 * supply text/html data, that will be preferred and returned as-is.
 * Otherwise, any text/* data will be returned and escaped to HTML.
 * If it is not a content: URI or the content provider does not supply
 * a text representation, HTML text containing a link to the URI
 * will be returned.
 * <li> If {@link #getIntent} is non-null, convert that to an intent:
 * URI and return as an HTML link.
 * <li> Otherwise, return an empty string.
 * </ul>
 *
 * @param context The caller's Context, from which its ContentResolver
 * and other things can be retrieved.
 * @return Returns the item's representation as HTML text.
 * @apiSince 16
 */

public java.lang.String coerceToHtmlText(android.content.Context context) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

}

