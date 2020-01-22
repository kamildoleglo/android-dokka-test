/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.media.tv;

import android.provider.Settings;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;

/**
 * This class is used to specify meta information of a TV input.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TvInputInfo implements android.os.Parcelable {

private TvInputInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns a unique ID for this TV input. The ID is generated from the package and class name
 * implementing the TV input service.
 * @apiSince 21
 */

public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the parent input ID.
 *
 * <p>A TV input may have a parent input if the TV input is actually a logical representation of
 * a device behind the hardware port represented by the parent input.
 * For example, a HDMI CEC logical device, connected to a HDMI port, appears as another TV
 * input. In this case, the parent input of this logical device is the HDMI port.
 *
 * <p>Applications may group inputs by parent input ID to provide an easier access to inputs
 * sharing the same physical port. In the example of HDMI CEC, logical HDMI CEC devices behind
 * the same HDMI port have the same parent ID, which is the ID representing the port. Thus
 * applications can group the hardware HDMI port and the logical HDMI CEC devices behind it
 * together using this method.
 *
 * @return the ID of the parent input, if exists. Returns {@code null} if the parent input is
 *         not specified.
 * @apiSince 21
 */

public java.lang.String getParentId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the information of the service that implements this TV input.
 * @apiSince 21
 */

public android.content.pm.ServiceInfo getServiceInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns an intent to start the setup activity for this TV input.
 * @apiSince 21
 */

public android.content.Intent createSetupIntent() { throw new RuntimeException("Stub!"); }

/**
 * Returns an intent to start the settings activity for this TV input.
 *
 * @deprecated Use {@link #createSetupIntent()} instead. Settings activity is deprecated.
 *             Use setup activity instead to provide settings.
 * @apiSince 21
 * @deprecatedSince 26
 */

@Deprecated
public android.content.Intent createSettingsIntent() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of this TV input.
 
 * @return Value is {@link android.media.tv.TvInputInfo#TYPE_TUNER}, {@link android.media.tv.TvInputInfo#TYPE_OTHER}, {@link android.media.tv.TvInputInfo#TYPE_COMPOSITE}, {@link android.media.tv.TvInputInfo#TYPE_SVIDEO}, {@link android.media.tv.TvInputInfo#TYPE_SCART}, {@link android.media.tv.TvInputInfo#TYPE_COMPONENT}, {@link android.media.tv.TvInputInfo#TYPE_VGA}, {@link android.media.tv.TvInputInfo#TYPE_DVI}, {@link android.media.tv.TvInputInfo#TYPE_HDMI}, or {@link android.media.tv.TvInputInfo#TYPE_DISPLAY_PORT}
 * @apiSince 21
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of tuners this TV input has.
 *
 * <p>This method is valid only for inputs of type {@link #TYPE_TUNER}. For inputs of other
 * types, it returns 0.
 *
 * <p>Tuners correspond to physical/logical resources that allow reception of TV signal. Having
 * <i>N</i> tuners means that the TV input is capable of receiving <i>N</i> different channels
 * concurrently.
 * @apiSince 24
 */

public int getTunerCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this TV input can record TV programs, {@code false} otherwise.
 * @apiSince 24
 */

public boolean canRecord() { throw new RuntimeException("Stub!"); }

/**
 * Returns domain-specific extras associated with this TV input.
 * @apiSince 24
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this TV input is pass-though which does not have any real channels in
 * TvProvider. {@code false} otherwise.
 *
 * @see android.media.tv.TvContract#buildChannelUriForPassthroughInput(String)
 * @apiSince 21
 */

public boolean isPassthroughInput() { throw new RuntimeException("Stub!"); }

/**
 * Checks if this TV input is marked hidden by the user in the settings.
 *
 * @param context Supplies a {@link android.content.Context Context} used to check if this TV input is hidden.
 * @return {@code true} if the user marked this TV input hidden in settings. {@code false}
 *         otherwise.
 * @apiSince 24
 */

public boolean isHidden(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Loads the user-displayed label for this TV input.
 *
 * @param context Supplies a {@link android.content.Context Context} used to load the label.
 * This value must never be {@code null}.
 * @return a CharSequence containing the TV input's label. If the TV input does not have
 *         a label, its name is returned.
 * @apiSince 21
 */

public java.lang.CharSequence loadLabel(@androidx.annotation.NonNull android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Loads the custom label set by user in settings.
 *
 * @param context Supplies a {@link android.content.Context Context} used to load the custom label.
 * @return a CharSequence containing the TV input's custom label. {@code null} if there is no
 *         custom label.
 * @apiSince 24
 */

public java.lang.CharSequence loadCustomLabel(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Loads the user-displayed icon for this TV input.
 *
 * @param context Supplies a {@link android.content.Context Context} used to load the icon.
 * This value must never be {@code null}.
 * @return a Drawable containing the TV input's icon. If the TV input does not have an icon,
 *         application's icon is returned. If it's unavailable too, {@code null} is returned.
 * @apiSince 21
 */

public android.graphics.drawable.Drawable loadIcon(@androidx.annotation.NonNull android.content.Context context) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link android.os.Parcel Parcel}.
 *
 * @param dest The {@link android.os.Parcel Parcel} to be written.
 * This value must never be {@code null}.
 * @param flags The flags used for parceling.
 * @apiSince 21
 */

public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.tv.TvInputInfo> CREATOR;
static { CREATOR = null; }

/**
 * Used as a String extra field in setup intents created by {@link #createSetupIntent()} to
 * supply the ID of a specific TV input to set up.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_INPUT_ID = "android.media.tv.extra.INPUT_ID";

/**
 * TV input type: the TV input service represents a component port.
 * @apiSince 21
 */

public static final int TYPE_COMPONENT = 1004; // 0x3ec

/**
 * TV input type: the TV input service represents a composite port.
 * @apiSince 21
 */

public static final int TYPE_COMPOSITE = 1001; // 0x3e9

/**
 * TV input type: the TV input service represents a display port.
 * @apiSince 21
 */

public static final int TYPE_DISPLAY_PORT = 1008; // 0x3f0

/**
 * TV input type: the TV input service represents a DVI port.
 * @apiSince 21
 */

public static final int TYPE_DVI = 1006; // 0x3ee

/**
 * TV input type: the TV input service is HDMI. (e.g. HDMI 1)
 * @apiSince 21
 */

public static final int TYPE_HDMI = 1007; // 0x3ef

/**
 * TV input type: a generic hardware TV input type.
 * @apiSince 21
 */

public static final int TYPE_OTHER = 1000; // 0x3e8

/**
 * TV input type: the TV input service represents a SCART port.
 * @apiSince 21
 */

public static final int TYPE_SCART = 1003; // 0x3eb

/**
 * TV input type: the TV input service represents a SVIDEO port.
 * @apiSince 21
 */

public static final int TYPE_SVIDEO = 1002; // 0x3ea

/**
 * TV input type: the TV input service is a tuner which provides channels.
 * @apiSince 21
 */

public static final int TYPE_TUNER = 0; // 0x0

/**
 * TV input type: the TV input service represents a VGA port.
 * @apiSince 21
 */

public static final int TYPE_VGA = 1005; // 0x3ed
/**
 * A convenience builder for creating {@link android.media.tv.TvInputInfo TvInputInfo} objects.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Constructs a new builder for {@link android.media.tv.TvInputInfo TvInputInfo}.
 *
 * @param context A Context of the application package implementing this class.
 * @param component The name of the application component to be used for the
 *            {@link android.media.tv.TvInputService TvInputService}.
 * @apiSince 24
 */

public Builder(android.content.Context context, android.content.ComponentName component) { throw new RuntimeException("Stub!"); }

/**
 * Sets the tuner count. Valid only for {@link #TYPE_TUNER}.
 *
 * @param tunerCount The number of tuners this TV input has.
 * @return This Builder object to allow for chaining of calls to builder methods.
 * @apiSince 24
 */

public android.media.tv.TvInputInfo.Builder setTunerCount(int tunerCount) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this TV input can record TV programs or not.
 *
 * @param canRecord Whether this TV input can record TV programs.
 * @return This Builder object to allow for chaining of calls to builder methods.
 * @apiSince 24
 */

public android.media.tv.TvInputInfo.Builder setCanRecord(boolean canRecord) { throw new RuntimeException("Stub!"); }

/**
 * Sets domain-specific extras associated with this TV input.
 *
 * @param extras Domain-specific extras associated with this TV input. Keys <em>must</em> be
 *            a scoped name, i.e. prefixed with a package name you own, so that different
 *            developers will not create conflicting keys.
 * @return This Builder object to allow for chaining of calls to builder methods.
 * @apiSince 24
 */

public android.media.tv.TvInputInfo.Builder setExtras(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.media.tv.TvInputInfo TvInputInfo} instance with the specified fields. Most of the information
 * is obtained by parsing the AndroidManifest and {@link android.media.tv.TvInputService#SERVICE_META_DATA TvInputService#SERVICE_META_DATA}
 * for the {@link android.media.tv.TvInputService TvInputService} this TV input implements.
 *
 * @return TvInputInfo containing information about this TV input.
 * @apiSince 24
 */

public android.media.tv.TvInputInfo build() { throw new RuntimeException("Stub!"); }
}

}

