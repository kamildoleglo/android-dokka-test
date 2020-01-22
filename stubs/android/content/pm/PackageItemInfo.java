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

import android.graphics.drawable.Drawable;

/**
 * Base class containing information common to all package items held by
 * the package manager.  This provides a very common basic set of attributes:
 * a label, icon, and meta-data.  This class is not intended
 * to be used by itself; it is simply here to share common definitions
 * between all items returned by the package manager.  As such, it does not
 * itself implement Parcelable, but does provide convenience methods to assist
 * in the implementation of Parcelable in subclasses.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PackageItemInfo {

/** @apiSince 1 */

public PackageItemInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public PackageItemInfo(android.content.pm.PackageItemInfo orig) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected PackageItemInfo(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current textual label associated with this item.  This
 * will call back on the given PackageManager to load the label from
 * the application.
 *
 * @param pm A PackageManager from which the label can be loaded; usually
 * the PackageManager from which you originally retrieved this item.
 *
 * This value must never be {@code null}.
 * @return Returns a CharSequence containing the item's label.  If the
 * item does not have a label, its name is returned.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.CharSequence loadLabel(@androidx.annotation.NonNull android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current graphical icon associated with this item.  This
 * will call back on the given PackageManager to load the icon from
 * the application.
 *
 * @param pm A PackageManager from which the icon can be loaded; usually
 * the PackageManager from which you originally retrieved this item.
 *
 * @return Returns a Drawable containing the item's icon.  If the
 * item does not have an icon, the item's default icon is returned
 * such as the default activity icon.
 * @apiSince 1
 */

public android.graphics.drawable.Drawable loadIcon(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current graphical icon associated with this item without
 * the addition of a work badge if applicable.
 * This will call back on the given PackageManager to load the icon from
 * the application.
 *
 * @param pm A PackageManager from which the icon can be loaded; usually
 * the PackageManager from which you originally retrieved this item.
 *
 * @return Returns a Drawable containing the item's icon.  If the
 * item does not have an icon, the item's default icon is returned
 * such as the default activity icon.
 * @apiSince 22
 */

public android.graphics.drawable.Drawable loadUnbadgedIcon(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current graphical banner associated with this item.  This
 * will call back on the given PackageManager to load the banner from
 * the application.
 *
 * @param pm A PackageManager from which the banner can be loaded; usually
 * the PackageManager from which you originally retrieved this item.
 *
 * @return Returns a Drawable containing the item's banner.  If the item
 * does not have a banner, this method will return null.
 * @apiSince 20
 */

public android.graphics.drawable.Drawable loadBanner(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current graphical logo associated with this item. This
 * will call back on the given PackageManager to load the logo from
 * the application.
 *
 * @param pm A PackageManager from which the logo can be loaded; usually
 * the PackageManager from which you originally retrieved this item.
 *
 * @return Returns a Drawable containing the item's logo. If the item
 * does not have a logo, this method will return null.
 * @apiSince 9
 */

public android.graphics.drawable.Drawable loadLogo(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Load an XML resource attached to the meta-data of this item.  This will
 * retrieved the name meta-data entry, and if defined call back on the
 * given PackageManager to load its XML file from the application.
 *
 * @param pm A PackageManager from which the XML can be loaded; usually
 * the PackageManager from which you originally retrieved this item.
 * @param name Name of the meta-date you would like to load.
 *
 * @return Returns an XmlPullParser you can use to parse the XML file
 * assigned as the given meta-data.  If the meta-data name is not defined
 * or the XML resource could not be found, null is returned.
 * @apiSince 1
 */

public android.content.res.XmlResourceParser loadXmlMetaData(android.content.pm.PackageManager pm, java.lang.String name) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void dumpFront(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void dumpBack(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/**
 * A drawable resource identifier (in the package's resources) of this
 * component's banner.  From the "banner" attribute or, if not set, 0.
 * @apiSince 20
 */

public int banner;

/**
 * A drawable resource identifier (in the package's resources) of this
 * component's icon.  From the "icon" attribute or, if not set, 0.
 * @apiSince 1
 */

public int icon;

/**
 * A string resource identifier (in the package's resources) of this
 * component's label.  From the "label" attribute or, if not set, 0.
 * @apiSince 1
 */

public int labelRes;

/**
 * A drawable resource identifier (in the package's resources) of this
 * component's logo. Logos may be larger/wider than icons and are
 * displayed by certain UI elements in place of a name or name/icon
 * combination. From the "logo" attribute or, if not set, 0.
 * @apiSince 9
 */

public int logo;

/**
 * Additional meta-data associated with this component.  This field
 * will only be filled in if you set the
 * {@link android.content.pm.PackageManager#GET_META_DATA PackageManager#GET_META_DATA} flag when requesting the info.
 * @apiSince 1
 */

public android.os.Bundle metaData;

/**
 * Public name of this item. From the "android:name" attribute.
 * @apiSince 1
 */

public java.lang.String name;

/**
 * The string provided in the AndroidManifest file, if any.  You
 * probably don't want to use this.  You probably want
 * {@link android.content.pm.PackageManager#getApplicationLabel PackageManager#getApplicationLabel}
 * @apiSince 1
 */

public java.lang.CharSequence nonLocalizedLabel;

/**
 * Name of the package that this item is in.
 * @apiSince 1
 */

public java.lang.String packageName;
/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class DisplayNameComparator implements java.util.Comparator<android.content.pm.PackageItemInfo> {

/** @apiSince 1 */

public DisplayNameComparator(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final int compare(android.content.pm.PackageItemInfo aa, android.content.pm.PackageItemInfo ab) { throw new RuntimeException("Stub!"); }
}

}

