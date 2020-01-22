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
 * This class represents the attributes of a print job. These attributes
 * describe how the printed content should be laid out. For example, the
 * print attributes may state that the content should be laid out on a
 * letter size with 300 DPI (dots per inch) resolution, have a margin of
 * 10 mills (thousand of an inch) on all sides, and be black and white.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PrintAttributes implements android.os.Parcelable {

PrintAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Gets the media size.
 *
 * @return The media size or <code>null</code> if not set.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.print.PrintAttributes.MediaSize getMediaSize() { throw new RuntimeException("Stub!"); }

/**
 * Gets the resolution.
 *
 * @return The resolution or <code>null</code> if not set.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.print.PrintAttributes.Resolution getResolution() { throw new RuntimeException("Stub!"); }

/**
 * Gets the minimal margins. If the content does not fit
 * these margins it will be clipped.
 * <p>
 * <strong>These margins are physically imposed by the printer and they
 * are <em>not</em> rotated, i.e. they are the same for both portrait and
 * landscape. For example, a printer may not be able to print in a stripe
 * on both left and right sides of the page.
 * </strong>
 * </p>
 *
 * @return The margins or <code>null</code> if not set.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.print.PrintAttributes.Margins getMinMargins() { throw new RuntimeException("Stub!"); }

/**
 * Gets the color mode.
 *
 * @return The color mode or zero if not set.
 *
 * Value is 0 or greater
 * @see #COLOR_MODE_COLOR
 * @see #COLOR_MODE_MONOCHROME
 * @apiSince 19
 */

public int getColorMode() { throw new RuntimeException("Stub!"); }

/**
 * Gets the duplex mode.
 *
 * @return The duplex mode or zero if not set.
 *
 * Value is 0 or greater
 * @see #DUPLEX_MODE_NONE
 * @see #DUPLEX_MODE_LONG_EDGE
 * @see #DUPLEX_MODE_SHORT_EDGE
 * @apiSince 23
 */

public int getDuplexMode() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Color mode: Color color scheme, for example many colors are used.
 * @apiSince 19
 */

public static final int COLOR_MODE_COLOR = 2; // 0x2

/**
 * Color mode: Monochrome color scheme, for example one color is used.
 * @apiSince 19
 */

public static final int COLOR_MODE_MONOCHROME = 1; // 0x1

/** @apiSince 19 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.print.PrintAttributes> CREATOR;
static { CREATOR = null; }

/**
 * Duplex mode: Pages are turned sideways along the long edge - like a book.
 * @apiSince 23
 */

public static final int DUPLEX_MODE_LONG_EDGE = 2; // 0x2

/**
 * Duplex mode: No duplexing.
 * @apiSince 23
 */

public static final int DUPLEX_MODE_NONE = 1; // 0x1

/**
 * Duplex mode: Pages are turned upwards along the short edge - like a notpad.
 * @apiSince 23
 */

public static final int DUPLEX_MODE_SHORT_EDGE = 4; // 0x4
/**
 * Builder for creating {@link android.print.PrintAttributes PrintAttributes}.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the media size.
 *
 * @param mediaSize The media size.
 * This value must never be {@code null}.
 * @return This builder.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrintAttributes.Builder setMediaSize(@androidx.annotation.NonNull android.print.PrintAttributes.MediaSize mediaSize) { throw new RuntimeException("Stub!"); }

/**
 * Sets the resolution.
 *
 * @param resolution The resolution.
 * This value must never be {@code null}.
 * @return This builder.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrintAttributes.Builder setResolution(@androidx.annotation.NonNull android.print.PrintAttributes.Resolution resolution) { throw new RuntimeException("Stub!"); }

/**
 * Sets the minimal margins. If the content does not fit
 * these margins it will be clipped.
 *
 * @param margins The margins.
 * This value must never be {@code null}.
 * @return This builder.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrintAttributes.Builder setMinMargins(@androidx.annotation.NonNull android.print.PrintAttributes.Margins margins) { throw new RuntimeException("Stub!"); }

/**
 * Sets the color mode.
 *
 * @param colorMode A valid color mode or zero.
 * Value is either <code>0</code> or a combination of {@link android.print.PrintAttributes#COLOR_MODE_MONOCHROME}, and {@link android.print.PrintAttributes#COLOR_MODE_COLOR}
 * @return This builder.
 *
 * This value will never be {@code null}.
 * @see android.print.PrintAttributes#COLOR_MODE_MONOCHROME
 * @see android.print.PrintAttributes#COLOR_MODE_COLOR
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrintAttributes.Builder setColorMode(int colorMode) { throw new RuntimeException("Stub!"); }

/**
 * Sets the duplex mode.
 *
 * @param duplexMode A valid duplex mode or zero.
 * Value is either <code>0</code> or a combination of {@link android.print.PrintAttributes#DUPLEX_MODE_NONE}, {@link android.print.PrintAttributes#DUPLEX_MODE_LONG_EDGE}, and {@link android.print.PrintAttributes#DUPLEX_MODE_SHORT_EDGE}
 * @return This builder.
 *
 * This value will never be {@code null}.
 * @see android.print.PrintAttributes#DUPLEX_MODE_NONE
 * @see android.print.PrintAttributes#DUPLEX_MODE_LONG_EDGE
 * @see android.print.PrintAttributes#DUPLEX_MODE_SHORT_EDGE
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.print.PrintAttributes.Builder setDuplexMode(int duplexMode) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link android.print.PrintAttributes PrintAttributes} instance.
 *
 * @return The new instance.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrintAttributes build() { throw new RuntimeException("Stub!"); }
}

/**
 * This class specifies content margins. Margins define the white space
 * around the content where the left margin defines the amount of white
 * space on the left of the content and so on.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Margins {

/**
 * Creates a new instance.
 *
 * @param leftMils The left margin in mils (thousandths of an inch).
 * @param topMils The top margin in mils (thousandths of an inch).
 * @param rightMils The right margin in mils (thousandths of an inch).
 * @param bottomMils The bottom margin in mils (thousandths of an inch).
 * @apiSince 19
 */

public Margins(int leftMils, int topMils, int rightMils, int bottomMils) { throw new RuntimeException("Stub!"); }

/**
 * Gets the left margin in mils (thousandths of an inch).
 *
 * @return The left margin.
 * @apiSince 19
 */

public int getLeftMils() { throw new RuntimeException("Stub!"); }

/**
 * Gets the top margin in mils (thousandths of an inch).
 *
 * @return The top margin.
 * @apiSince 19
 */

public int getTopMils() { throw new RuntimeException("Stub!"); }

/**
 * Gets the right margin in mils (thousandths of an inch).
 *
 * @return The right margin.
 * @apiSince 19
 */

public int getRightMils() { throw new RuntimeException("Stub!"); }

/**
 * Gets the bottom margin in mils (thousandths of an inch).
 *
 * @return The bottom margin.
 * @apiSince 19
 */

public int getBottomMils() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public static final android.print.PrintAttributes.Margins NO_MARGINS;
static { NO_MARGINS = null; }
}

/**
 * This class specifies a supported media size. Media size is the
 * dimension of the media on which the content is printed. For
 * example, the {@link #NA_LETTER} media size designates a page
 * with size 8.5" x 11".
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class MediaSize {

/**
 * Creates a new instance.
 *
 * @param id The unique media size id. It is unique amongst other media sizes
 *        supported by the printer.
 * This value must never be {@code null}.
 * @param label The <strong>localized</strong> human readable label.
 * This value must never be {@code null}.
 * @param widthMils The width in mils (thousandths of an inch).
 * Value is 1 or greater
 * @param heightMils The height in mils (thousandths of an inch).
 *
 * Value is 1 or greater
 * @throws java.lang.IllegalArgumentException If the id is empty or the label is empty
 * or the widthMils is less than or equal to zero or the heightMils is less
 * than or equal to zero.
 * @apiSince 19
 */

public MediaSize(@androidx.annotation.NonNull java.lang.String id, @androidx.annotation.NonNull java.lang.String label, int widthMils, int heightMils) { throw new RuntimeException("Stub!"); }

/**
 * Gets the unique media size id. It is unique amongst other media sizes
 * supported by the printer.
 * <p>
 * This id is defined by the client that generated the media size
 * instance and should not be interpreted by other parties.
 * </p>
 *
 * @return The unique media size id.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the human readable media size label.
 *
 * @param packageManager The package manager for loading the label.
 * This value must never be {@code null}.
 * @return The human readable label.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public java.lang.String getLabel(@androidx.annotation.NonNull android.content.pm.PackageManager packageManager) { throw new RuntimeException("Stub!"); }

/**
 * Gets the media width in mils (thousandths of an inch).
 *
 * @return The media width.
 
 * Value is 1 or greater
 * @apiSince 19
 */

public int getWidthMils() { throw new RuntimeException("Stub!"); }

/**
 * Gets the media height in mils (thousandths of an inch).
 *
 * @return The media height.
 
 * Value is 1 or greater
 * @apiSince 19
 */

public int getHeightMils() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this media size is in portrait which is the
 * height is greater or equal to the width.
 *
 * @return True if the media size is in portrait, false if
 * it is in landscape.
 * @apiSince 19
 */

public boolean isPortrait() { throw new RuntimeException("Stub!"); }

/**
 * Returns a new media size instance in a portrait orientation,
 * which is the height is the greater dimension.
 *
 * @return New instance in landscape orientation if this one
 * is in landscape, otherwise this instance.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrintAttributes.MediaSize asPortrait() { throw new RuntimeException("Stub!"); }

/**
 * Returns a new media size instance in a landscape orientation,
 * which is the height is the lesser dimension.
 *
 * @return New instance in landscape orientation if this one
 * is in portrait, otherwise this instance.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrintAttributes.MediaSize asLandscape() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * ISO A0 media size: 841mm x 1189mm (33.11" x 46.81")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_A0;
static { ISO_A0 = null; }

/**
 * ISO A1 media size: 594mm x 841mm (23.39" x 33.11")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_A1;
static { ISO_A1 = null; }

/**
 * ISO A10 media size: 26mm x 37mm (1.02" x 1.46")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_A10;
static { ISO_A10 = null; }

/**
 * ISO A2 media size: 420mm x 594mm (16.54" x 23.39")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_A2;
static { ISO_A2 = null; }

/**
 * ISO A3 media size: 297mm x 420mm (11.69" x 16.54")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_A3;
static { ISO_A3 = null; }

/**
 * ISO A4 media size: 210mm x 297mm (8.27" x 11.69")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_A4;
static { ISO_A4 = null; }

/**
 * ISO A5 media size: 148mm x 210mm (5.83" x 8.27")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_A5;
static { ISO_A5 = null; }

/**
 * ISO A6 media size: 105mm x 148mm (4.13" x 5.83")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_A6;
static { ISO_A6 = null; }

/**
 * ISO A7 media size: 74mm x 105mm (2.91" x 4.13")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_A7;
static { ISO_A7 = null; }

/**
 * ISO A8 media size: 52mm x 74mm (2.05" x 2.91")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_A8;
static { ISO_A8 = null; }

/**
 * ISO A9 media size: 37mm x 52mm (1.46" x 2.05")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_A9;
static { ISO_A9 = null; }

/**
 * ISO B0 media size: 1000mm x 1414mm (39.37" x 55.67")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_B0;
static { ISO_B0 = null; }

/**
 * ISO B1 media size: 707mm x 1000mm (27.83" x 39.37")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_B1;
static { ISO_B1 = null; }

/**
 * ISO B10 media size: 31mm x 44mm (1.22" x 1.73")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_B10;
static { ISO_B10 = null; }

/**
 * ISO B2 media size: 500mm x 707mm (19.69" x 27.83")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_B2;
static { ISO_B2 = null; }

/**
 * ISO B3 media size: 353mm x 500mm (13.90" x 19.69")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_B3;
static { ISO_B3 = null; }

/**
 * ISO B4 media size: 250mm x 353mm (9.84" x 13.90")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_B4;
static { ISO_B4 = null; }

/**
 * ISO B5 media size: 176mm x 250mm (6.93" x 9.84")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_B5;
static { ISO_B5 = null; }

/**
 * ISO B6 media size: 125mm x 176mm (4.92" x 6.93")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_B6;
static { ISO_B6 = null; }

/**
 * ISO B7 media size: 88mm x 125mm (3.46" x 4.92")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_B7;
static { ISO_B7 = null; }

/**
 * ISO B8 media size: 62mm x 88mm (2.44" x 3.46")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_B8;
static { ISO_B8 = null; }

/**
 * ISO B9 media size: 44mm x 62mm (1.73" x 2.44")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_B9;
static { ISO_B9 = null; }

/**
 * ISO C0 media size: 917mm x 1297mm (36.10" x 51.06")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_C0;
static { ISO_C0 = null; }

/**
 * ISO C1 media size: 648mm x 917mm (25.51" x 36.10")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_C1;
static { ISO_C1 = null; }

/**
 * ISO C10 media size: 28mm x 40mm (1.10" x 1.57")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_C10;
static { ISO_C10 = null; }

/**
 * ISO C2 media size: 458mm x 648mm (18.03" x 25.51")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_C2;
static { ISO_C2 = null; }

/**
 * ISO C3 media size: 324mm x 458mm (12.76" x 18.03")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_C3;
static { ISO_C3 = null; }

/**
 * ISO C4 media size: 229mm x 324mm (9.02" x 12.76")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_C4;
static { ISO_C4 = null; }

/**
 * ISO C5 media size: 162mm x 229mm (6.38" x 9.02")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_C5;
static { ISO_C5 = null; }

/**
 * ISO C6 media size: 114mm x 162mm (4.49" x 6.38")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_C6;
static { ISO_C6 = null; }

/**
 * ISO C7 media size: 81mm x 114mm (3.19" x 4.49")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_C7;
static { ISO_C7 = null; }

/**
 * ISO C8 media size: 57mm x 81mm (2.24" x 3.19")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_C8;
static { ISO_C8 = null; }

/**
 * ISO C9 media size: 40mm x 57mm (1.57" x 2.24")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ISO_C9;
static { ISO_C9 = null; }

/**
 * Japanese JIS B0 media size: 1030mm x 1456mm (40.551" x 57.323")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JIS_B0;
static { JIS_B0 = null; }

/**
 * Japanese JIS B1 media size: 728mm x 1030mm (28.661" x 40.551")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JIS_B1;
static { JIS_B1 = null; }

/**
 * Japanese JIS B10 media size: 32mm x 45mm (1.259" x 1.772")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JIS_B10;
static { JIS_B10 = null; }

/**
 * Japanese JIS B2 media size: 515mm x 728mm (20.276" x 28.661")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JIS_B2;
static { JIS_B2 = null; }

/**
 * Japanese JIS B3 media size: 364mm x 515mm (14.331" x 20.276")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JIS_B3;
static { JIS_B3 = null; }

/**
 * Japanese JIS B4 media size: 257mm x 364mm (10.118" x 14.331")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JIS_B4;
static { JIS_B4 = null; }

/**
 * Japanese JIS B5 media size: 182mm x 257mm (7.165" x 10.118")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JIS_B5;
static { JIS_B5 = null; }

/**
 * Japanese JIS B6 media size: 128mm x 182mm (5.049" x 7.165")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JIS_B6;
static { JIS_B6 = null; }

/**
 * Japanese JIS B7 media size: 91mm x 128mm (3.583" x 5.049")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JIS_B7;
static { JIS_B7 = null; }

/**
 * Japanese JIS B8 media size: 64mm x 91mm (2.52" x 3.583")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JIS_B8;
static { JIS_B8 = null; }

/**
 * Japanese JIS B9 media size: 45mm x 64mm (1.772" x 2.52")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JIS_B9;
static { JIS_B9 = null; }

/**
 * Japanese JIS Exec media size: 216mm x 330mm (8.504" x 12.992")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JIS_EXEC;
static { JIS_EXEC = null; }

/**
 * Japanese Chou2 media size: 111.1mm x 146mm (4.374" x 5.748")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JPN_CHOU2;
static { JPN_CHOU2 = null; }

/**
 * Japanese Chou3 media size: 120mm x 235mm (4.724" x 9.252")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JPN_CHOU3;
static { JPN_CHOU3 = null; }

/**
 * Japanese Chou4 media size: 90mm x 205mm (3.543" x 8.071")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JPN_CHOU4;
static { JPN_CHOU4 = null; }

/**
 * Japanese Hagaki media size: 100mm x 148mm (3.937" x 5.827")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JPN_HAGAKI;
static { JPN_HAGAKI = null; }

/**
 * Japanese Kahu media size: 240mm x 322.1mm (9.449" x 12.681")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JPN_KAHU;
static { JPN_KAHU = null; }

/**
 * Japanese Kaku2 media size: 240mm x 332mm (9.449" x 13.071")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JPN_KAKU2;
static { JPN_KAKU2 = null; }

/**
 * Japanese Oufuku media size: 148mm x 200mm (5.827" x 7.874")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JPN_OUFUKU;
static { JPN_OUFUKU = null; }

/**
 * Japanese You4 media size: 105mm x 235mm (4.134" x 9.252")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize JPN_YOU4;
static { JPN_YOU4 = null; }

/**
 * North America Foolscap media size: 8" x 13" (203mm x 330mm)
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize NA_FOOLSCAP;
static { NA_FOOLSCAP = null; }

/**
 * North America Government-Letter media size: 8.0" x 10.5" (203mm x 267mm)
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize NA_GOVT_LETTER;
static { NA_GOVT_LETTER = null; }

/**
 * North America Index Card 3x5 media size: 3" x 5" (76mm x 127mm)
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize NA_INDEX_3X5;
static { NA_INDEX_3X5 = null; }

/**
 * North America Index Card 4x6 media size: 4" x 6" (102mm x 152mm)
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize NA_INDEX_4X6;
static { NA_INDEX_4X6 = null; }

/**
 * North America Index Card 5x8 media size: 5" x 8" (127mm x 203mm)
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize NA_INDEX_5X8;
static { NA_INDEX_5X8 = null; }

/**
 * North America Junior Legal media size: 8.0" x 5.0" (203mm × 127mm)
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize NA_JUNIOR_LEGAL;
static { NA_JUNIOR_LEGAL = null; }

/**
 * North America Ledger media size: 17" x 11" (432mm × 279mm)
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize NA_LEDGER;
static { NA_LEDGER = null; }

/**
 * North America Legal media size: 8.5" x 14" (216mm x 356mm)
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize NA_LEGAL;
static { NA_LEGAL = null; }

/**
 * North America Letter media size: 8.5" x 11" (279mm x 216mm)
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize NA_LETTER;
static { NA_LETTER = null; }

/**
 * North America Monarch media size: 7.25" x 10.5" (184mm x 267mm)
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize NA_MONARCH;
static { NA_MONARCH = null; }

/**
 * North America Quarto media size: 8" x 10" (203mm x 254mm)
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize NA_QUARTO;
static { NA_QUARTO = null; }

/**
 * North America Tabloid media size: 11" x 17" (279mm × 432mm)
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize NA_TABLOID;
static { NA_TABLOID = null; }

/**
 * Chinese Dai Pa Kai media size: 275mm x 395mm (10.827" x 15.551")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize OM_DAI_PA_KAI;
static { OM_DAI_PA_KAI = null; }

/**
 * Chinese Jurro Ku Kai media size: 198mm x 275mm (7.796" x 10.827")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize OM_JUURO_KU_KAI;
static { OM_JUURO_KU_KAI = null; }

/**
 * Chinese Pa Kai media size: 267mm x 389mm (10.512" x 15.315")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize OM_PA_KAI;
static { OM_PA_KAI = null; }

/**
 * Chinese PRC 1 media size: 102mm x 165mm (4.015" x 6.496")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize PRC_1;
static { PRC_1 = null; }

/**
 * Chinese PRC 10 media size: 324mm x 458mm (12.756" x 18.032")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize PRC_10;
static { PRC_10 = null; }

/**
 * Chinese PRC 16k media size: 146mm x 215mm (5.749" x 8.465")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize PRC_16K;
static { PRC_16K = null; }

/**
 * Chinese PRC 2 media size: 102mm x 176mm (4.015" x 6.929")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize PRC_2;
static { PRC_2 = null; }

/**
 * Chinese PRC 3 media size: 125mm x 176mm (4.921" x 6.929")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize PRC_3;
static { PRC_3 = null; }

/**
 * Chinese PRC 4 media size: 110mm x 208mm (4.330" x 8.189")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize PRC_4;
static { PRC_4 = null; }

/**
 * Chinese PRC 5 media size: 110mm x 220mm (4.330" x 8.661")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize PRC_5;
static { PRC_5 = null; }

/**
 * Chinese PRC 6 media size: 120mm x 320mm (4.724" x 12.599")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize PRC_6;
static { PRC_6 = null; }

/**
 * Chinese PRC 7 media size: 160mm x 230mm (6.299" x 9.055")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize PRC_7;
static { PRC_7 = null; }

/**
 * Chinese PRC 8 media size: 120mm x 309mm (4.724" x 12.165")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize PRC_8;
static { PRC_8 = null; }

/**
 * Chinese PRC 9 media size: 229mm x 324mm (9.016" x 12.756")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize PRC_9;
static { PRC_9 = null; }

/**
 * Chinese ROC 16K media size: 195mm x 270mm (7.677" x 10.629")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ROC_16K;
static { ROC_16K = null; }

/**
 * Chinese ROC 8K media size: 270mm x 390mm (10.629" x 15.3543")
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize ROC_8K;
static { ROC_8K = null; }

/**
 * Unknown media size in landscape mode.
 * <p>
 * <strong>Note: </strong>This is for specifying orientation without media
 * size. You should not use the dimensions reported by this instance.
 * </p>
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize UNKNOWN_LANDSCAPE;
static { UNKNOWN_LANDSCAPE = null; }

/**
 * Unknown media size in portrait mode.
 * <p>
 * <strong>Note: </strong>This is for specifying orientation without media
 * size. You should not use the dimensions reported by this instance.
 * </p>
 * @apiSince 19
 */

public static final android.print.PrintAttributes.MediaSize UNKNOWN_PORTRAIT;
static { UNKNOWN_PORTRAIT = null; }
}

/**
 * This class specifies a supported resolution in DPI (dots per inch).
 * Resolution defines how many points with different color can be placed
 * on one inch in horizontal or vertical direction of the target media.
 * For example, a printer with 600 DPI can produce higher quality images
 * the one with 300 DPI resolution.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Resolution {

/**
 * Creates a new instance.
 *
 * @param id The unique resolution id. It is unique amongst other resolutions
 *        supported by the printer.
 * This value must never be {@code null}.
 * @param label The <strong>localized</strong> human readable label.
 * This value must never be {@code null}.
 * @param horizontalDpi The horizontal resolution in DPI (dots per inch).
 * Value is 1 or greater
 * @param verticalDpi The vertical resolution in DPI (dots per inch).
 *
 * Value is 1 or greater
 * @throws java.lang.IllegalArgumentException If the id is empty or the label is empty
 * or the horizontalDpi is less than or equal to zero or the verticalDpi is
 * less than or equal to zero.
 * @apiSince 19
 */

public Resolution(@androidx.annotation.NonNull java.lang.String id, @androidx.annotation.NonNull java.lang.String label, int horizontalDpi, int verticalDpi) { throw new RuntimeException("Stub!"); }

/**
 * Gets the unique resolution id. It is unique amongst other resolutions
 * supported by the printer.
 * <p>
 * This id is defined by the client that generated the resolution
 * instance and should not be interpreted by other parties.
 * </p>
 *
 * @return The unique resolution id.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the resolution human readable label.
 *
 * @return The human readable label.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public java.lang.String getLabel() { throw new RuntimeException("Stub!"); }

/**
 * Gets the horizontal resolution in DPI (dots per inch).
 *
 * @return The horizontal resolution.
 
 * Value is 1 or greater
 * @apiSince 19
 */

public int getHorizontalDpi() { throw new RuntimeException("Stub!"); }

/**
 * Gets the vertical resolution in DPI (dots per inch).
 *
 * @return The vertical resolution.
 
 * Value is 1 or greater
 * @apiSince 19
 */

public int getVerticalDpi() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

}

