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
 * limitations under the License.
 */


package android.content.pm;

import android.content.Intent;

/**
 * A special subclass of Intent that can have a custom label/icon
 * associated with it.  Primarily for use with {@link android.content.Intent#ACTION_CHOOSER Intent#ACTION_CHOOSER}.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LabeledIntent extends android.content.Intent {

/**
 * Create a labeled intent from the given intent, supplying the label
 * and icon resources for it.
 *
 * @param origIntent The original Intent to copy.
 * @param sourcePackage The package in which the label and icon live.
 * @param labelRes Resource containing the label, or 0 if none.
 * @param icon Resource containing the icon, or 0 if none.
 * @apiSince 5
 */

public LabeledIntent(android.content.Intent origIntent, java.lang.String sourcePackage, int labelRes, int icon) { throw new RuntimeException("Stub!"); }

/**
 * Create a labeled intent from the given intent, supplying a textual
 * label and icon resource for it.
 *
 * @param origIntent The original Intent to copy.
 * @param sourcePackage The package in which the label and icon live.
 * @param nonLocalizedLabel Concrete text to use for the label.
 * @param icon Resource containing the icon, or 0 if none.
 * @apiSince 5
 */

public LabeledIntent(android.content.Intent origIntent, java.lang.String sourcePackage, java.lang.CharSequence nonLocalizedLabel, int icon) { throw new RuntimeException("Stub!"); }

/**
 * Create a labeled intent with no intent data but supplying the label
 * and icon resources for it.
 *
 * @param sourcePackage The package in which the label and icon live.
 * @param labelRes Resource containing the label, or 0 if none.
 * @param icon Resource containing the icon, or 0 if none.
 * @apiSince 5
 */

public LabeledIntent(java.lang.String sourcePackage, int labelRes, int icon) { throw new RuntimeException("Stub!"); }

/**
 * Create a labeled intent with no intent data but supplying a textual
 * label and icon resource for it.
 *
 * @param sourcePackage The package in which the label and icon live.
 * @param nonLocalizedLabel Concrete text to use for the label.
 * @param icon Resource containing the icon, or 0 if none.
 * @apiSince 5
 */

public LabeledIntent(java.lang.String sourcePackage, java.lang.CharSequence nonLocalizedLabel, int icon) { throw new RuntimeException("Stub!"); }

/**
 * Return the name of the package holding label and icon resources.
 * @apiSince 5
 */

public java.lang.String getSourcePackage() { throw new RuntimeException("Stub!"); }

/**
 * Return any resource identifier that has been given for the label text.
 * @apiSince 5
 */

public int getLabelResource() { throw new RuntimeException("Stub!"); }

/**
 * Return any concrete text that has been given for the label text.
 * @apiSince 5
 */

public java.lang.CharSequence getNonLocalizedLabel() { throw new RuntimeException("Stub!"); }

/**
 * Return any resource identifier that has been given for the label icon.
 * @apiSince 5
 */

public int getIconResource() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the label associated with this object.  If the object does
 * not have a label, null will be returned, in which case you will probably
 * want to load the label from the underlying resolved info for the Intent.
 * @apiSince 5
 */

public java.lang.CharSequence loadLabel(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the icon associated with this object.  If the object does
 * not have a icon, null will be returned, in which case you will probably
 * want to load the icon from the underlying resolved info for the Intent.
 * @apiSince 5
 */

public android.graphics.drawable.Drawable loadIcon(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void readFromParcel(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.pm.LabeledIntent> CREATOR;
static { CREATOR = null; }
}

