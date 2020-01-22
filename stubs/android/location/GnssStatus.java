/*
 * Copyright (C) 2016 The Android Open Source Project
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


package android.location;


/**
 * This class represents the current state of the GNSS engine.
 * This class is used in conjunction with the {@link android.location.GnssStatus.Callback GnssStatus.Callback}.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class GnssStatus {

GnssStatus() { throw new RuntimeException("Stub!"); }

/**
 * Gets the total number of satellites in satellite list.
 * @apiSince 24
 */

public int getSatelliteCount() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the constellation type of the satellite at the specified index.
 *
 * @param satIndex the index of the satellite in the list.
 
 * @return Value is {@link android.location.GnssStatus#CONSTELLATION_UNKNOWN}, {@link android.location.GnssStatus#CONSTELLATION_GPS}, {@link android.location.GnssStatus#CONSTELLATION_SBAS}, {@link android.location.GnssStatus#CONSTELLATION_GLONASS}, {@link android.location.GnssStatus#CONSTELLATION_QZSS}, {@link android.location.GnssStatus#CONSTELLATION_BEIDOU}, {@link android.location.GnssStatus#CONSTELLATION_GALILEO}, or {@link android.location.GnssStatus#CONSTELLATION_IRNSS}
 * @apiSince 24
 */

public int getConstellationType(int satIndex) { throw new RuntimeException("Stub!"); }

/**
 * Gets the identification number for the satellite at the specific index.
 *
 * <p>This svid is pseudo-random number for most constellations. It is FCN &amp; OSN number for
 * Glonass.
 *
 * <p>The distinction is made by looking at constellation field
 * {@link #getConstellationType(int)} Expected values are in the range of:
 *
 * <ul>
 * <li>GPS: 1-32</li>
 * <li>SBAS: 120-151, 183-192</li>
 * <li>GLONASS: One of: OSN, or FCN+100
 * <ul>
 *   <li>1-24 as the orbital slot number (OSN) (preferred, if known)</li>
 *   <li>93-106 as the frequency channel number (FCN) (-7 to +6) plus 100.
 *   i.e. encode FCN of -7 as 93, 0 as 100, and +6 as 106</li>
 * </ul></li>
 * <li>QZSS: 193-200</li>
 * <li>Galileo: 1-36</li>
 * <li>Beidou: 1-37</li>
 * </ul>
 *
 * @param satIndex the index of the satellite in the list.
 * @apiSince 24
 */

public int getSvid(int satIndex) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the carrier-to-noise density at the antenna of the satellite at the specified index
 * in dB-Hz.
 *
 * @param satIndex the index of the satellite in the list.
 * @apiSince 24
 */

public float getCn0DbHz(int satIndex) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the elevation of the satellite at the specified index.
 *
 * @param satIndex the index of the satellite in the list.
 * @apiSince 24
 */

public float getElevationDegrees(int satIndex) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the azimuth the satellite at the specified index.
 *
 * @param satIndex the index of the satellite in the list.
 * @apiSince 24
 */

public float getAzimuthDegrees(int satIndex) { throw new RuntimeException("Stub!"); }

/**
 * Reports whether the satellite at the specified index has ephemeris data.
 *
 * @param satIndex the index of the satellite in the list.
 * @apiSince 24
 */

public boolean hasEphemerisData(int satIndex) { throw new RuntimeException("Stub!"); }

/**
 * Reports whether the satellite at the specified index has almanac data.
 *
 * @param satIndex the index of the satellite in the list.
 * @apiSince 24
 */

public boolean hasAlmanacData(int satIndex) { throw new RuntimeException("Stub!"); }

/**
 * Reports whether the satellite at the specified index was used in the calculation of the most
 * recent position fix.
 *
 * @param satIndex the index of the satellite in the list.
 * @apiSince 24
 */

public boolean usedInFix(int satIndex) { throw new RuntimeException("Stub!"); }

/**
 * Reports whether a valid {@link #getCarrierFrequencyHz(int satIndex)} is available.
 *
 * @param satIndex the index of the satellite in the list.
 * @apiSince 26
 */

public boolean hasCarrierFrequencyHz(int satIndex) { throw new RuntimeException("Stub!"); }

/**
 * Gets the carrier frequency of the signal tracked.
 *
 * <p>For example it can be the GPS central frequency for L1 = 1575.45 MHz, or L2 = 1227.60 MHz,
 * L5 = 1176.45 MHz, varying GLO channels, etc. If the field is not set, it is the primary
 * common use central frequency, e.g. L1 = 1575.45 MHz for GPS.
 *
 * For an L1, L5 receiver tracking a satellite on L1 and L5 at the same time, two measurements
 * will be reported for this same satellite, in one all the values related to L1 will be filled,
 * and in the other all of the values related to L5 will be filled.
 *
 * <p>The value is only available if {@link #hasCarrierFrequencyHz(int satIndex)} is {@code true}.
 *
 * @param satIndex the index of the satellite in the list.
 *
 * @return the carrier frequency of the signal tracked in Hz.
 * @apiSince 26
 */

public float getCarrierFrequencyHz(int satIndex) { throw new RuntimeException("Stub!"); }

/**
 * Constellation type constant for Beidou.
 * @apiSince 24
 */

public static final int CONSTELLATION_BEIDOU = 5; // 0x5

/**
 * Constellation type constant for Galileo.
 * @apiSince 24
 */

public static final int CONSTELLATION_GALILEO = 6; // 0x6

/**
 * Constellation type constant for Glonass.
 * @apiSince 24
 */

public static final int CONSTELLATION_GLONASS = 3; // 0x3

/**
 * Constellation type constant for GPS.
 * @apiSince 24
 */

public static final int CONSTELLATION_GPS = 1; // 0x1

/**
 * Constellation type constant for IRNSS.
 * @apiSince 29
 */

public static final int CONSTELLATION_IRNSS = 7; // 0x7

/**
 * Constellation type constant for QZSS.
 * @apiSince 24
 */

public static final int CONSTELLATION_QZSS = 4; // 0x4

/**
 * Constellation type constant for SBAS.
 * @apiSince 24
 */

public static final int CONSTELLATION_SBAS = 2; // 0x2

/**
 * Unknown constellation type.
 * @apiSince 24
 */

public static final int CONSTELLATION_UNKNOWN = 0; // 0x0
/**
 * Used for receiving notifications when GNSS events happen.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Called when GNSS system has started.
 * @apiSince 24
 */

public void onStarted() { throw new RuntimeException("Stub!"); }

/**
 * Called when GNSS system has stopped.
 * @apiSince 24
 */

public void onStopped() { throw new RuntimeException("Stub!"); }

/**
 * Called when the GNSS system has received its first fix since starting.
 * @param ttffMillis the time from start to first fix in milliseconds.
 * @apiSince 24
 */

public void onFirstFix(int ttffMillis) { throw new RuntimeException("Stub!"); }

/**
 * Called periodically to report GNSS satellite status.
 * @param status the current status of all satellites.
 * @apiSince 24
 */

public void onSatelliteStatusChanged(android.location.GnssStatus status) { throw new RuntimeException("Stub!"); }
}

}

