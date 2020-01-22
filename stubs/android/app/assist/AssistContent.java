
package android.app.assist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * Holds information about the content an application is viewing, to hand to an
 * assistant at the user's request.  This is filled in by
 * {@link android.app.Activity#onProvideAssistContent Activity.onProvideAssistContent}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AssistContent implements android.os.Parcelable {

/** @apiSince 23 */

public AssistContent() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Intent associated with the content, describing the current top-level context of
 * the activity.  If this contains a reference to a piece of data related to the activity,
 * be sure to set {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION Intent#FLAG_GRANT_READ_URI_PERMISSION} so the accessibility
 * service can access it.
 * @apiSince 23
 */

public void setIntent(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current {@link #setIntent} if one is set, else the default Intent obtained from
 * {@link android.app.Activity#getIntent Activity.getIntent}. Can be modified in-place.
 * @apiSince 23
 */

public android.content.Intent getIntent() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not the current Intent was explicitly provided in
 * {@link android.app.Activity#onProvideAssistContent Activity.onProvideAssistContent}. If not,
 * the Intent was automatically set based on
 * {@link android.app.Activity#getIntent Activity.getIntent}.
 * @apiSince 23
 */

public boolean isAppProvidedIntent() { throw new RuntimeException("Stub!"); }

/**
 * Optional additional content items that are involved with
 * the current UI.  Access to this content will be granted to the assistant as if you
 * are sending it through an Intent with {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION Intent#FLAG_GRANT_READ_URI_PERMISSION}.
 * @apiSince 23
 */

public void setClipData(android.content.ClipData clip) { throw new RuntimeException("Stub!"); }

/**
 * Return the current {@link #setClipData}, which you can modify in-place.
 * @apiSince 23
 */

public android.content.ClipData getClipData() { throw new RuntimeException("Stub!"); }

/**
 * Sets optional structured data regarding the content being viewed. The provided data
 * must be a string represented with <a href="http://json-ld.org/">JSON-LD</a> using the
 * <a href="http://schema.org/">schema.org</a> vocabulary.
 * @apiSince 23
 */

public void setStructuredData(java.lang.String structuredData) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current {@link #setStructuredData}.
 * @apiSince 23
 */

public java.lang.String getStructuredData() { throw new RuntimeException("Stub!"); }

/**
 * Set a web URI associated with the current data being shown to the user.
 * This URI could be opened in a web browser, or in the app as an
 * {@link android.content.Intent#ACTION_VIEW Intent#ACTION_VIEW} Intent, to show the same data that is currently
 * being displayed by it.  The URI here should be something that is transportable
 * off the device into other environments to acesss the same data as is currently
 * being shown in the app; if the app does not have such a representation, it should
 * leave the null and only report the local intent and clip data.
 * @apiSince 23
 */

public void setWebUri(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Return the content's web URI as per {@link #setWebUri(android.net.Uri)}, or null if
 * there is none.
 * @apiSince 23
 */

public android.net.Uri getWebUri() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not the current {@link #getWebUri} was explicitly provided in
 * {@link android.app.Activity#onProvideAssistContent Activity.onProvideAssistContent}. If not,
 * the Intent was automatically set based on
 * {@link android.app.Activity#getIntent Activity.getIntent}.
 * @apiSince 24
 */

public boolean isAppProvidedWebUri() { throw new RuntimeException("Stub!"); }

/**
 * Return Bundle for extra vendor-specific data that can be modified and examined.
 * @apiSince 23
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.assist.AssistContent> CREATOR;
static { CREATOR = null; }
}

