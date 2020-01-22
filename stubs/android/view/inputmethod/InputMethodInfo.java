/*
 * Copyright (C) 2007-2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


package android.view.inputmethod;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager;
import android.content.ComponentName;
import android.os.Parcel;

/**
 * This class is used to specify meta information of an input method.
 *
 * <p>It should be defined in an XML resource file with an {@code <input-method>} element.
 * For more information, see the guide to
 * <a href="{@docRoot}guide/topics/text/creating-input-method.html">
 * Creating an Input Method</a>.</p>
 *
 * @see android.view.inputmethod.InputMethodSubtype
 *
 * @attr ref android.R.styleable#InputMethod_settingsActivity
 * @attr ref android.R.styleable#InputMethod_isDefault
 * @attr ref android.R.styleable#InputMethod_supportsSwitchingToNextInputMethod
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class InputMethodInfo implements android.os.Parcelable {

/**
 * Constructor.
 *
 * @param context The Context in which we are parsing the input method.
 * @param service The ResolveInfo returned from the package manager about
 * this input method's component.
 * @apiSince 3
 */

public InputMethodInfo(android.content.Context context, android.content.pm.ResolveInfo service) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Temporary API for creating a built-in input method for test.
 * @apiSince 3
 */

public InputMethodInfo(java.lang.String packageName, java.lang.String className, java.lang.CharSequence label, java.lang.String settingsActivity) { throw new RuntimeException("Stub!"); }

/**
 * Return a unique ID for this input method.  The ID is generated from
 * the package and class name implementing the method.
 * @apiSince 3
 */

public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * Return the .apk package that implements this input method.
 * @apiSince 3
 */

public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Return the class name of the service component that implements
 * this input method.
 * @apiSince 3
 */

public java.lang.String getServiceName() { throw new RuntimeException("Stub!"); }

/**
 * Return the raw information about the Service implementing this
 * input method.  Do not modify the returned object.
 * @apiSince 3
 */

public android.content.pm.ServiceInfo getServiceInfo() { throw new RuntimeException("Stub!"); }

/**
 * Return the component of the service that implements this input
 * method.
 * @apiSince 3
 */

public android.content.ComponentName getComponent() { throw new RuntimeException("Stub!"); }

/**
 * Load the user-displayed label for this input method.
 *
 * @param pm Supply a PackageManager used to load the input method's
 * resources.
 * @apiSince 3
 */

public java.lang.CharSequence loadLabel(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Load the user-displayed icon for this input method.
 *
 * @param pm Supply a PackageManager used to load the input method's
 * resources.
 * @apiSince 3
 */

public android.graphics.drawable.Drawable loadIcon(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Return the class name of an activity that provides a settings UI for
 * the input method.  You can launch this activity be starting it with
 * an {@link android.content.Intent} whose action is MAIN and with an
 * explicit {@link android.content.ComponentName}
 * composed of {@link #getPackageName} and the class name returned here.
 *
 * <p>A null will be returned if there is no settings activity associated
 * with the input method.</p>
 * @apiSince 3
 */

public java.lang.String getSettingsActivity() { throw new RuntimeException("Stub!"); }

/**
 * Return the count of the subtypes of Input Method.
 * @apiSince 11
 */

public int getSubtypeCount() { throw new RuntimeException("Stub!"); }

/**
 * Return the Input Method's subtype at the specified index.
 *
 * @param index the index of the subtype to return.
 * @apiSince 11
 */

public android.view.inputmethod.InputMethodSubtype getSubtypeAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return the resource identifier of a resource inside of this input
 * method's .apk that determines whether it should be considered a
 * default input method for the system.
 * @apiSince 3
 */

public int getIsDefaultResourceId() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Used to test whether the given parameter object is an
 * {@link android.view.inputmethod.InputMethodInfo InputMethodInfo} and its Id is the same to this one.
 *
 * @return true if the given parameter object is an
 *         {@link android.view.inputmethod.InputMethodInfo InputMethodInfo} and its Id is the same to this one.
 * @apiSince 3
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link android.os.Parcel Parcel}.
 *
 * @param dest The {@link android.os.Parcel Parcel} to be written.
 * @param flags The flags used for parceling.
 * @apiSince 3
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 * @apiSince 3
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.inputmethod.InputMethodInfo> CREATOR;
static { CREATOR = null; }
}

