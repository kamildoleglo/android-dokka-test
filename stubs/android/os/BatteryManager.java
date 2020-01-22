/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.os;

import android.content.Intent;

/**
 * The BatteryManager class contains strings and constants used for values
 * in the {@link android.content.Intent#ACTION_BATTERY_CHANGED} Intent, and
 * provides a method for querying battery and charging properties.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BatteryManager {

BatteryManager() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the battery is currently considered to be charging.  This means that
 * the device is plugged in and is supplying sufficient power that the battery level is
 * going up (or the battery is fully charged).  Changes in this state are matched by
 * broadcasts of {@link #ACTION_CHARGING} and {@link #ACTION_DISCHARGING}.
 * @apiSince 23
 */

public boolean isCharging() { throw new RuntimeException("Stub!"); }

/**
 * Return the value of a battery property of integer type.
 *
 * @param id identifier of the requested property
 *
 * @return the property value. If the property is not supported or there is any other error,
 *    return (a) 0 if {@code targetSdkVersion < VERSION_CODES.P} or (b) Integer.MIN_VALUE
 *    if {@code targetSdkVersion >= VERSION_CODES.P}.
 * @apiSince 21
 */

public int getIntProperty(int id) { throw new RuntimeException("Stub!"); }

/**
 * Return the value of a battery property of long type If the
 * platform does not provide the property queried, this value will
 * be Long.MIN_VALUE.
 *
 * @param id identifier of the requested property
 *
 * @return the property value, or Long.MIN_VALUE if not supported.
 * @apiSince 21
 */

public long getLongProperty(int id) { throw new RuntimeException("Stub!"); }

/**
 * Compute an approximation for how much time (in milliseconds) remains until the battery is
 * fully charged. Returns -1 if no time can be computed: either there is not enough current
 * data to make a decision or the battery is currently discharging.
 *
 * @return how much time is left, in milliseconds, until the battery is fully charged or -1 if
 *         the computation fails
 * @apiSince 28
 */

public long computeChargeTimeRemaining() { throw new RuntimeException("Stub!"); }

/**
 * Sent when the device's battery has started charging (or has reached full charge
 * and the device is on power).  This is a good time to do work that you would like to
 * avoid doing while on battery (that is to avoid draining the user's battery due to
 * things they don't care enough about).
 *
 * This is paired with {@link #ACTION_DISCHARGING}.  The current state can always
 * be retrieved with {@link #isCharging()}.
 * @apiSince 23
 */

public static final java.lang.String ACTION_CHARGING = "android.os.action.CHARGING";

/**
 * Sent when the device's battery may be discharging, so apps should avoid doing
 * extraneous work that would cause it to discharge faster.
 *
 * This is paired with {@link #ACTION_CHARGING}.  The current state can always
 * be retrieved with {@link #isCharging()}.
 * @apiSince 23
 */

public static final java.lang.String ACTION_DISCHARGING = "android.os.action.DISCHARGING";

/** @apiSince 11 */

public static final int BATTERY_HEALTH_COLD = 7; // 0x7

/** @apiSince 1 */

public static final int BATTERY_HEALTH_DEAD = 4; // 0x4

/** @apiSince 1 */

public static final int BATTERY_HEALTH_GOOD = 2; // 0x2

/** @apiSince 1 */

public static final int BATTERY_HEALTH_OVERHEAT = 3; // 0x3

/** @apiSince 1 */

public static final int BATTERY_HEALTH_OVER_VOLTAGE = 5; // 0x5

/** @apiSince 1 */

public static final int BATTERY_HEALTH_UNKNOWN = 1; // 0x1

/** @apiSince 1 */

public static final int BATTERY_HEALTH_UNSPECIFIED_FAILURE = 6; // 0x6

/**
 * Power source is an AC charger.
 * @apiSince 1
 */

public static final int BATTERY_PLUGGED_AC = 1; // 0x1

/**
 * Power source is a USB port.
 * @apiSince 1
 */

public static final int BATTERY_PLUGGED_USB = 2; // 0x2

/**
 * Power source is wireless.
 * @apiSince 17
 */

public static final int BATTERY_PLUGGED_WIRELESS = 4; // 0x4

/**
 * Remaining battery capacity as an integer percentage of total capacity
 * (with no fractional part).
 * @apiSince 21
 */

public static final int BATTERY_PROPERTY_CAPACITY = 4; // 0x4

/**
 * Battery capacity in microampere-hours, as an integer.
 * @apiSince 21
 */

public static final int BATTERY_PROPERTY_CHARGE_COUNTER = 1; // 0x1

/**
 * Average battery current in microamperes, as an integer.  Positive
 * values indicate net current entering the battery from a charge source,
 * negative values indicate net current discharging from the battery.
 * The time period over which the average is computed may depend on the
 * fuel gauge hardware and its configuration.
 * @apiSince 21
 */

public static final int BATTERY_PROPERTY_CURRENT_AVERAGE = 3; // 0x3

/**
 * Instantaneous battery current in microamperes, as an integer.  Positive
 * values indicate net current entering the battery from a charge source,
 * negative values indicate net current discharging from the battery.
 * @apiSince 21
 */

public static final int BATTERY_PROPERTY_CURRENT_NOW = 2; // 0x2

/**
 * Battery remaining energy in nanowatt-hours, as a long integer.
 * @apiSince 21
 */

public static final int BATTERY_PROPERTY_ENERGY_COUNTER = 5; // 0x5

/**
 * Battery charge status, from a BATTERY_STATUS_* value.
 * @apiSince 26
 */

public static final int BATTERY_PROPERTY_STATUS = 6; // 0x6

/** @apiSince 1 */

public static final int BATTERY_STATUS_CHARGING = 2; // 0x2

/** @apiSince 1 */

public static final int BATTERY_STATUS_DISCHARGING = 3; // 0x3

/** @apiSince 1 */

public static final int BATTERY_STATUS_FULL = 5; // 0x5

/** @apiSince 1 */

public static final int BATTERY_STATUS_NOT_CHARGING = 4; // 0x4

/** @apiSince 1 */

public static final int BATTERY_STATUS_UNKNOWN = 1; // 0x1

/**
 * Extra for {@link android.content.Intent#ACTION_BATTERY_CHANGED}:
 * Boolean field indicating whether the battery is currently considered to be
 * low, that is whether a {@link android.content.Intent#ACTION_BATTERY_LOW Intent#ACTION_BATTERY_LOW} broadcast
 * has been sent.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_BATTERY_LOW = "battery_low";

/**
 * Extra for {@link android.content.Intent#ACTION_BATTERY_CHANGED}:
 * integer containing the current health constant.
 * @apiSince 5
 */

public static final java.lang.String EXTRA_HEALTH = "health";

/**
 * Extra for {@link android.content.Intent#ACTION_BATTERY_CHANGED}:
 * integer containing the resource ID of a small status bar icon
 * indicating the current battery state.
 * @apiSince 5
 */

public static final java.lang.String EXTRA_ICON_SMALL = "icon-small";

/**
 * Extra for {@link android.content.Intent#ACTION_BATTERY_CHANGED}:
 * integer field containing the current battery level, from 0 to
 * {@link #EXTRA_SCALE}.
 * @apiSince 5
 */

public static final java.lang.String EXTRA_LEVEL = "level";

/**
 * Extra for {@link android.content.Intent#ACTION_BATTERY_CHANGED}:
 * integer indicating whether the device is plugged in to a power
 * source; 0 means it is on battery, other constants are different
 * types of power sources.
 * @apiSince 5
 */

public static final java.lang.String EXTRA_PLUGGED = "plugged";

/**
 * Extra for {@link android.content.Intent#ACTION_BATTERY_CHANGED}:
 * boolean indicating whether a battery is present.
 * @apiSince 5
 */

public static final java.lang.String EXTRA_PRESENT = "present";

/**
 * Extra for {@link android.content.Intent#ACTION_BATTERY_CHANGED}:
 * integer containing the maximum battery level.
 * @apiSince 5
 */

public static final java.lang.String EXTRA_SCALE = "scale";

/**
 * Extra for {@link android.content.Intent#ACTION_BATTERY_CHANGED}:
 * integer containing the current status constant.
 * @apiSince 5
 */

public static final java.lang.String EXTRA_STATUS = "status";

/**
 * Extra for {@link android.content.Intent#ACTION_BATTERY_CHANGED}:
 * String describing the technology of the current battery.
 * @apiSince 5
 */

public static final java.lang.String EXTRA_TECHNOLOGY = "technology";

/**
 * Extra for {@link android.content.Intent#ACTION_BATTERY_CHANGED}:
 * integer containing the current battery temperature.
 * @apiSince 5
 */

public static final java.lang.String EXTRA_TEMPERATURE = "temperature";

/**
 * Extra for {@link android.content.Intent#ACTION_BATTERY_CHANGED}:
 * integer containing the current battery voltage level.
 * @apiSince 5
 */

public static final java.lang.String EXTRA_VOLTAGE = "voltage";
}

