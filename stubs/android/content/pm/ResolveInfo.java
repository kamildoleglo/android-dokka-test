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


package android.content.pm;

import android.content.IntentFilter;
import android.graphics.drawable.Drawable;

/**
 * Information that is returned from resolving an intent
 * against an IntentFilter. This partially corresponds to
 * information collected from the AndroidManifest.xml's
 * &lt;intent&gt; tags.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ResolveInfo implements android.os.Parcelable {

/** @apiSince 1 */

public ResolveInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public ResolveInfo(android.content.pm.ResolveInfo orig) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current textual label associated with this resolution.  This
 * will call back on the given PackageManager to load the label from
 * the application.
 *
 * @param pm A PackageManager from which the label can be loaded; usually
 * the PackageManager from which you originally retrieved this item.
 *
 * @return Returns a CharSequence containing the resolutions's label.  If the
 * item does not have a label, its name is returned.
 * @apiSince 1
 */

public java.lang.CharSequence loadLabel(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current graphical icon associated with this resolution.  This
 * will call back on the given PackageManager to load the icon from
 * the application.
 *
 * @param pm A PackageManager from which the icon can be loaded; usually
 * the PackageManager from which you originally retrieved this item.
 *
 * @return Returns a Drawable containing the resolution's icon.  If the
 * item does not have an icon, the default activity icon is returned.
 * @apiSince 1
 */

public android.graphics.drawable.Drawable loadIcon(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Return the icon resource identifier to use for this match.  If the
 * match defines an icon, that is used; else if the activity defines
 * an icon, that is used; else, the application icon is used.
 *
 * @return The icon associated with this match.
 * @apiSince 1
 */

public final int getIconResource() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.pm.ResolveInfo> CREATOR;
static { CREATOR = null; }

/**
 * The activity or broadcast receiver that corresponds to this resolution
 * match, if this resolution is for an activity or broadcast receiver.
 * Exactly one of {@link #activityInfo}, {@link #serviceInfo}, or
 * {@link #providerInfo} will be non-null.
 * @apiSince 1
 */

public android.content.pm.ActivityInfo activityInfo;

/**
 * The IntentFilter that was matched for this ResolveInfo.
 * @apiSince 1
 */

public android.content.IntentFilter filter;

/**
 * A drawable resource identifier (in the package's resources) of this
 * match's icon.  From the "icon" attribute or, if not set, 0. It is
 * set only if the icon can be obtained by resource id alone.
 * @apiSince 1
 */

public int icon;

/**
 * This filter has specified the Intent.CATEGORY_DEFAULT, meaning it
 * would like to be considered a default action that the user can
 * perform on this data.
 * @apiSince 1
 */

public boolean isDefault;

/**
 * Whether or not an instant app is available for the resolved intent.
 * @apiSince 26
 */

public boolean isInstantAppAvailable;

/**
 * A string resource identifier (in the package's resources) of this
 * match's label.  From the "label" attribute or, if not set, 0.
 * @apiSince 1
 */

public int labelRes;

/**
 * The system's evaluation of how well the activity matches the
 * IntentFilter.  This is a match constant, a combination of
 * {@link android.content.IntentFilter#MATCH_CATEGORY_MASK IntentFilter#MATCH_CATEGORY_MASK}
 * and {@link android.content.IntentFilter#MATCH_ADJUSTMENT_MASK IntentFilter#MATCH_ADJUSTMENT_MASK}.
 * @apiSince 1
 */

public int match;

/**
 * The actual string retrieve from <var>labelRes</var> or null if none
 * was provided.
 * @apiSince 1
 */

public java.lang.CharSequence nonLocalizedLabel;

/**
 * Order of result according to the user's preference.  If the user
 * has not set a preference for this result, the value is 0; higher
 * values are a higher priority.
 * @apiSince 1
 */

public int preferredOrder;

/**
 * The declared priority of this match.  Comes from the "priority"
 * attribute or, if not set, defaults to 0.  Higher values are a higher
 * priority.
 * @apiSince 1
 */

public int priority;

/**
 * The provider that corresponds to this resolution match, if this
 * resolution is for a provider. Exactly one of {@link #activityInfo},
 * {@link #serviceInfo}, or {@link #providerInfo} will be non-null.
 * @apiSince 19
 */

public android.content.pm.ProviderInfo providerInfo;

/**
 * Optional -- if non-null, the {@link #labelRes} and {@link #icon}
 * resources will be loaded from this package, rather than the one
 * containing the resolved component.
 * @apiSince 5
 */

public java.lang.String resolvePackageName;

/**
 * The service that corresponds to this resolution match, if this resolution
 * is for a service. Exactly one of {@link #activityInfo},
 * {@link #serviceInfo}, or {@link #providerInfo} will be non-null.
 * @apiSince 1
 */

public android.content.pm.ServiceInfo serviceInfo;

/**
 * Only set when returned by
 * {@link android.content.pm.PackageManager#queryIntentActivityOptions PackageManager#queryIntentActivityOptions}, this tells you
 * which of the given specific intents this result came from.  0 is the
 * first in the list, < 0 means it came from the generic Intent query.
 * @apiSince 1
 */

public int specificIndex = -1; // 0xffffffff
/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class DisplayNameComparator implements java.util.Comparator<android.content.pm.ResolveInfo> {

/** @apiSince 1 */

public DisplayNameComparator(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final int compare(android.content.pm.ResolveInfo a, android.content.pm.ResolveInfo b) { throw new RuntimeException("Stub!"); }
}

}

