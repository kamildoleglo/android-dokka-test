/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.telephony;


/**
 * Abstract base class for cell phone signal strength related information.
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CellSignalStrength {

CellSignalStrength() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve an abstract level value for the overall signal quality.
 *
 * @return a single integer from 0 to 4 representing the general signal quality.
 *     0 represents very poor or unknown signal quality while 4 represents excellent
 *     signal quality.
 
 * Value is between SIGNAL_STRENGTH_NONE_OR_UNKNOWN and SIGNAL_STRENGTH_GREAT inclusive
 * @apiSince 17
 */

public abstract int getLevel();

/**
 * Get the technology-specific signal strength in Arbitrary Strength Units, calculated from the
 * strength of the pilot signal or equivalent.
 * @apiSince 17
 */

public abstract int getAsuLevel();

/**
 * Get the technology-specific signal strength in dBm, which is the signal strength of the
 * pilot signal or equivalent.
 * @apiSince 17
 */

public abstract int getDbm();

/** @apiSince 17 */

public abstract int hashCode();

/** @apiSince 17 */

public abstract boolean equals(java.lang.Object o);

/**
 * Returns the number of signal strength levels.
 * @return Number of signal strength levels, enforced to be 5
 * @apiSince R
 */

public static final int getNumSignalStrengthLevels() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public static final int SIGNAL_STRENGTH_GOOD = 3; // 0x3

/** @apiSince 23 */

public static final int SIGNAL_STRENGTH_GREAT = 4; // 0x4

/** @apiSince 23 */

public static final int SIGNAL_STRENGTH_MODERATE = 2; // 0x2

/** @apiSince 23 */

public static final int SIGNAL_STRENGTH_NONE_OR_UNKNOWN = 0; // 0x0

/** @apiSince 23 */

public static final int SIGNAL_STRENGTH_POOR = 1; // 0x1
}

