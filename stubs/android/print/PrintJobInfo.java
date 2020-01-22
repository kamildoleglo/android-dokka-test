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


/**
 * This class represents the description of a print job. The print job
 * state includes properties such as its id, print attributes used for
 * generating the content, and so on. Note that the print jobs state may
 * change over time and this class represents a snapshot of this state.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PrintJobInfo implements android.os.Parcelable {

PrintJobInfo() { throw new RuntimeException("Stub!"); }

/**
 * Gets the unique print job id.
 *
 * @return The id.
 
 * This value may be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.print.PrintJobId getId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the human readable job label.
 *
 * @return The label.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public java.lang.String getLabel() { throw new RuntimeException("Stub!"); }

/**
 * Gets the unique target printer id.
 *
 * @return The target printer id.
 
 * This value may be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.print.PrinterId getPrinterId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current job state.
 *
 * @return The job state.
 *
 * Value is {@link android.print.PrintJobInfo#STATE_CREATED}, {@link android.print.PrintJobInfo#STATE_QUEUED}, {@link android.print.PrintJobInfo#STATE_STARTED}, {@link android.print.PrintJobInfo#STATE_BLOCKED}, {@link android.print.PrintJobInfo#STATE_COMPLETED}, {@link android.print.PrintJobInfo#STATE_FAILED}, or {@link android.print.PrintJobInfo#STATE_CANCELED}
 * @see #STATE_CREATED
 * @see #STATE_QUEUED
 * @see #STATE_STARTED
 * @see #STATE_COMPLETED
 * @see #STATE_BLOCKED
 * @see #STATE_FAILED
 * @see #STATE_CANCELED
 * @apiSince 19
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Gets the wall time in millisecond when this print job was created.
 *
 * @return The creation time in milliseconds.
 * @apiSince 19
 */

public long getCreationTime() { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of copies.
 *
 * @return The number of copies or zero if not set.
 
 * Value is 0 or greater
 * @apiSince 19
 */

public int getCopies() { throw new RuntimeException("Stub!"); }

/**
 * Gets the included pages.
 *
 * @return The included pages or <code>null</code> if not set.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.print.PageRange[] getPages() { throw new RuntimeException("Stub!"); }

/**
 * Gets the print job attributes.
 *
 * @return The attributes.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrintAttributes getAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this job has a given advanced (printer specific) print
 * option.
 *
 * @param key The option key.
 * @return Whether the option is present.
 * @apiSince 26
 */

public boolean hasAdvancedOption(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of an advanced (printer specific) print option.
 *
 * @param key The option key.
 * @return The option value.
 * @apiSince 26
 */

public java.lang.String getAdvancedStringOption(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of an advanced (printer specific) print option.
 *
 * @param key The option key.
 * @return The option value.
 * @apiSince 26
 */

public int getAdvancedIntOption(java.lang.String key) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.print.PrintJobInfo> CREATOR;
static { CREATOR = null; }

/**
 * Print job state: The print job is blocked.
 * <p>
 * Next valid states: {@link #STATE_FAILED}, {@link #STATE_CANCELED},
 * {@link #STATE_STARTED}
 * </p>
 * @apiSince 19
 */

public static final int STATE_BLOCKED = 4; // 0x4

/**
 * Print job state: The print job is canceled.
 * This is a terminal state.
 * <p>
 * Next valid states: None
 * </p>
 * @apiSince 19
 */

public static final int STATE_CANCELED = 7; // 0x7

/**
 * Print job state: The print job is successfully printed.
 * This is a terminal state.
 * <p>
 * Next valid states: None
 * </p>
 * @apiSince 19
 */

public static final int STATE_COMPLETED = 5; // 0x5

/**
 * Print job state: The print job is being created but not yet
 * ready to be printed.
 * <p>
 * Next valid states: {@link #STATE_QUEUED}
 * </p>
 * @apiSince 19
 */

public static final int STATE_CREATED = 1; // 0x1

/**
 * Print job state: The print job was printing but printing failed.
 * <p>
 * Next valid states: {@link #STATE_CANCELED}, {@link #STATE_STARTED}
 * </p>
 * @apiSince 19
 */

public static final int STATE_FAILED = 6; // 0x6

/**
 * Print job state: The print jobs is created, it is ready
 * to be printed and should be processed.
 * <p>
 * Next valid states: {@link #STATE_STARTED}, {@link #STATE_FAILED},
 * {@link #STATE_CANCELED}
 * </p>
 * @apiSince 19
 */

public static final int STATE_QUEUED = 2; // 0x2

/**
 * Print job state: The print job is being printed.
 * <p>
 * Next valid states: {@link #STATE_COMPLETED}, {@link #STATE_FAILED},
 * {@link #STATE_CANCELED}, {@link #STATE_BLOCKED}
 * </p>
 * @apiSince 19
 */

public static final int STATE_STARTED = 3; // 0x3
/**
 * Builder for creating a {@link android.print.PrintJobInfo PrintJobInfo}.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Constructor.
 *
 * @param prototype Prototype to use as a starting point.
 * Can be <code>null</code>.
 
 * This value may be {@code null}.
 * @apiSince 19
 */

public Builder(@androidx.annotation.Nullable android.print.PrintJobInfo prototype) { throw new RuntimeException("Stub!"); }

/**
 * Sets the number of copies.
 *
 * @param copies The number of copies.
 
 * Value is 1 or greater
 * @apiSince 19
 */

public void setCopies(int copies) { throw new RuntimeException("Stub!"); }

/**
 * Sets the print job attributes.
 *
 * @param attributes The attributes.
 
 * This value must never be {@code null}.
 * @apiSince 19
 */

public void setAttributes(@androidx.annotation.NonNull android.print.PrintAttributes attributes) { throw new RuntimeException("Stub!"); }

/**
 * Sets the included pages.
 *
 * @param pages The included pages.
 
 * This value must never be {@code null}.
 * @apiSince 19
 */

public void setPages(@androidx.annotation.NonNull android.print.PageRange[] pages) { throw new RuntimeException("Stub!"); }

/**
 * Puts an advanced (printer specific) option.
 *
 * @param key The option key.
 * This value must never be {@code null}.
 * @param value The option value.
 
 * This value may be {@code null}.
 * @apiSince 19
 */

public void putAdvancedOption(@androidx.annotation.NonNull java.lang.String key, @androidx.annotation.Nullable java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Puts an advanced (printer specific) option.
 *
 * @param key The option key.
 * This value must never be {@code null}.
 * @param value The option value.
 * @apiSince 19
 */

public void putAdvancedOption(@androidx.annotation.NonNull java.lang.String key, int value) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link android.print.PrintJobInfo PrintJobInfo} instance.
 *
 * @return The new instance.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrintJobInfo build() { throw new RuntimeException("Stub!"); }
}

}

