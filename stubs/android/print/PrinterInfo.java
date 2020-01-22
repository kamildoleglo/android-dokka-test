/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.print;

import android.app.PendingIntent;

/**
 * This class represents the description of a printer. Instances of
 * this class are created by print services to report to the system
 * the printers they manage. The information of this class has two
 * major components, printer properties such as name, id, status,
 * description and printer capabilities which describe the various
 * print modes a printer supports such as media sizes, margins, etc.
 * <p>
 * Once {@link android.print.PrinterInfo.Builder#build() PrinterInfo.Builder#build()} the objects are immutable.
 * </p>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PrinterInfo implements android.os.Parcelable {

private PrinterInfo() { throw new RuntimeException("Stub!"); }

/**
 * Get the globally unique printer id.
 *
 * @return The printer id.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrinterId getId() { throw new RuntimeException("Stub!"); }

/**
 * Get the printer name.
 *
 * @return The printer name.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Gets the printer status.
 *
 * @return The status.
 *
 * Value is {@link android.print.PrinterInfo#STATUS_IDLE}, {@link android.print.PrinterInfo#STATUS_BUSY}, or {@link android.print.PrinterInfo#STATUS_UNAVAILABLE}
 * @see #STATUS_BUSY
 * @see #STATUS_IDLE
 * @see #STATUS_UNAVAILABLE
 * @apiSince 19
 */

public int getStatus() { throw new RuntimeException("Stub!"); }

/**
 * Gets the  printer description.
 *
 * @return The description.
 
 * This value may be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public java.lang.String getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Gets the printer capabilities.
 *
 * @return The capabilities.
 
 * This value may be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.print.PrinterCapabilitiesInfo getCapabilities() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.print.PrinterInfo> CREATOR;
static { CREATOR = null; }

/**
 * Printer status: the printer is busy printing.
 * @apiSince 19
 */

public static final int STATUS_BUSY = 2; // 0x2

/**
 * Printer status: the printer is idle and ready to print.
 * @apiSince 19
 */

public static final int STATUS_IDLE = 1; // 0x1

/**
 * Printer status: the printer is not available.
 * @apiSince 19
 */

public static final int STATUS_UNAVAILABLE = 3; // 0x3
/**
 * Builder for creating of a {@link android.print.PrinterInfo PrinterInfo}.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Constructor.
 *
 * @param printerId The printer id. Cannot be null.
 * This value must never be {@code null}.
 * @param name The printer name. Cannot be empty.
 * This value must never be {@code null}.
 * @param status The printer status. Must be a valid status.
 * Value is {@link android.print.PrinterInfo#STATUS_IDLE}, {@link android.print.PrinterInfo#STATUS_BUSY}, or {@link android.print.PrinterInfo#STATUS_UNAVAILABLE}
 * @throws java.lang.IllegalArgumentException If the printer id is null, or the
 * printer name is empty or the status is not a valid one.
 * @apiSince 19
 */

public Builder(@androidx.annotation.NonNull android.print.PrinterId printerId, @androidx.annotation.NonNull java.lang.String name, int status) { throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 *
 * @param other Other info from which to start building.
 
 * This value must never be {@code null}.
 * @apiSince 19
 */

public Builder(@androidx.annotation.NonNull android.print.PrinterInfo other) { throw new RuntimeException("Stub!"); }

/**
 * Sets the printer status.
 *
 * @param status The status.
 * Value is {@link android.print.PrinterInfo#STATUS_IDLE}, {@link android.print.PrinterInfo#STATUS_BUSY}, or {@link android.print.PrinterInfo#STATUS_UNAVAILABLE}
 * @return This builder.
 * This value will never be {@code null}.
 * @see android.print.PrinterInfo#STATUS_IDLE
 * @see android.print.PrinterInfo#STATUS_BUSY
 * @see android.print.PrinterInfo#STATUS_UNAVAILABLE
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrinterInfo.Builder setStatus(int status) { throw new RuntimeException("Stub!"); }

/**
 * Set a drawable resource as icon for this printer. If no icon is set the printer's
 * service's icon is used for the printer.
 *
 * @param iconResourceId The resource ID of the icon.
 * @return This builder.
 * This value will never be {@code null}.
 * @see android.print.PrinterInfo.Builder#setHasCustomPrinterIcon
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.print.PrinterInfo.Builder setIconResourceId(int iconResourceId) { throw new RuntimeException("Stub!"); }

/**
 * Declares that the print service can load a custom per printer's icon. If both
 * {@link android.print.PrinterInfo.Builder#setIconResourceId PrinterInfo.Builder#setIconResourceId} and a custom icon are set the resource icon
 * is shown while the custom icon loads but then the custom icon is used. If
 * {@link android.print.PrinterInfo.Builder#setIconResourceId PrinterInfo.Builder#setIconResourceId} is not set the printer's service's icon is
 * shown while loading.
 * <p>
 * The icon is requested asynchronously and only when needed via
 * {@link android.printservice.PrinterDiscoverySession#onRequestCustomPrinterIcon}.
 * </p>
 *
 * @param hasCustomPrinterIcon If the printer has a custom icon or not.
 *
 * @return This builder.
 
 * This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.print.PrinterInfo.Builder setHasCustomPrinterIcon(boolean hasCustomPrinterIcon) { throw new RuntimeException("Stub!"); }

/**
 * Sets the <strong>localized</strong> printer name which
 * is shown to the user
 *
 * @param name The name.
 * This value must never be {@code null}.
 * @return This builder.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrinterInfo.Builder setName(@androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Sets the <strong>localized</strong> printer description
 * which is shown to the user
 *
 * @param description The description.
 * This value must never be {@code null}.
 * @return This builder.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrinterInfo.Builder setDescription(@androidx.annotation.NonNull java.lang.String description) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.app.PendingIntent PendingIntent} that launches an activity showing more information about
 * the printer.
 *
 * @param infoIntent The {@link android.app.PendingIntent PendingIntent}.
 * This value must never be {@code null}.
 * @return This builder.
 
 * This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.print.PrinterInfo.Builder setInfoIntent(@androidx.annotation.NonNull android.app.PendingIntent infoIntent) { throw new RuntimeException("Stub!"); }

/**
 * Sets the printer capabilities.
 *
 * @param capabilities The capabilities.
 * This value must never be {@code null}.
 * @return This builder.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrinterInfo.Builder setCapabilities(@androidx.annotation.NonNull android.print.PrinterCapabilitiesInfo capabilities) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link android.print.PrinterInfo PrinterInfo}.
 *
 * @return A new {@link android.print.PrinterInfo PrinterInfo}.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrinterInfo build() { throw new RuntimeException("Stub!"); }
}

}

