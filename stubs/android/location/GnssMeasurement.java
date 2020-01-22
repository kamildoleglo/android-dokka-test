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
 * limitations under the License
 */


package android.location;


/**
 * A class representing a GNSS satellite measurement, containing raw and computed information.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class GnssMeasurement implements android.os.Parcelable {

GnssMeasurement() { throw new RuntimeException("Stub!"); }

/**
 * Gets the satellite ID.
 *
 * <p>Interpretation depends on {@link #getConstellationType()}.
 * See {@link android.location.GnssStatus#getSvid(int) GnssStatus#getSvid(int)}.
 * @apiSince 24
 */

public int getSvid() { throw new RuntimeException("Stub!"); }

/**
 * Gets the constellation type.
 *
 * <p>The return value is one of those constants with {@code CONSTELLATION_} prefix in
 * {@link android.location.GnssStatus GnssStatus}.
 
 * @return Value is {@link android.location.GnssStatus#CONSTELLATION_UNKNOWN}, {@link android.location.GnssStatus#CONSTELLATION_GPS}, {@link android.location.GnssStatus#CONSTELLATION_SBAS}, {@link android.location.GnssStatus#CONSTELLATION_GLONASS}, {@link android.location.GnssStatus#CONSTELLATION_QZSS}, {@link android.location.GnssStatus#CONSTELLATION_BEIDOU}, {@link android.location.GnssStatus#CONSTELLATION_GALILEO}, or {@link android.location.GnssStatus#CONSTELLATION_IRNSS}
 * @apiSince 24
 */

public int getConstellationType() { throw new RuntimeException("Stub!"); }

/**
 * Gets the time offset at which the measurement was taken in nanoseconds.
 *
 * <p>The reference receiver's time from which this is offset is specified by
 * {@link android.location.GnssClock#getTimeNanos() GnssClock#getTimeNanos()}.
 *
 * <p>The sign of this value is given by the following equation:
 * <pre>
 *      measurement time = TimeNanos + TimeOffsetNanos</pre>
 *
 * <p>The value provides an individual time-stamp for the measurement, and allows sub-nanosecond
 * accuracy.
 * @apiSince 24
 */

public double getTimeOffsetNanos() { throw new RuntimeException("Stub!"); }

/**
 * Gets per-satellite sync state.
 *
 * <p>It represents the current sync state for the associated satellite.
 *
 * <p>This value helps interpret {@link #getReceivedSvTimeNanos()}.
 
 * @return Value is either <code>0</code> or a combination of {@link android.location.GnssMeasurement#STATE_CODE_LOCK}, {@link android.location.GnssMeasurement#STATE_BIT_SYNC}, {@link android.location.GnssMeasurement#STATE_SUBFRAME_SYNC}, {@link android.location.GnssMeasurement#STATE_TOW_DECODED}, {@link android.location.GnssMeasurement#STATE_MSEC_AMBIGUOUS}, {@link android.location.GnssMeasurement#STATE_SYMBOL_SYNC}, {@link android.location.GnssMeasurement#STATE_GLO_STRING_SYNC}, {@link android.location.GnssMeasurement#STATE_GLO_TOD_DECODED}, {@link android.location.GnssMeasurement#STATE_BDS_D2_BIT_SYNC}, {@link android.location.GnssMeasurement#STATE_BDS_D2_SUBFRAME_SYNC}, {@link android.location.GnssMeasurement#STATE_GAL_E1BC_CODE_LOCK}, {@link android.location.GnssMeasurement#STATE_GAL_E1C_2ND_CODE_LOCK}, {@link android.location.GnssMeasurement#STATE_GAL_E1B_PAGE_SYNC}, {@link android.location.GnssMeasurement#STATE_SBAS_SYNC}, {@link android.location.GnssMeasurement#STATE_TOW_KNOWN}, {@link android.location.GnssMeasurement#STATE_GLO_TOD_KNOWN}, and {@link android.location.GnssMeasurement#STATE_2ND_CODE_LOCK}
 * @apiSince 24
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Gets the received GNSS satellite time, at the measurement time, in nanoseconds.
 *
 * <p>The received satellite time is relative to the beginning of the system week for all
 * constellations except for Glonass where it is relative to the beginning of the Glonass
 * system day.
 *
 * <p>The table below indicates the valid range of the received GNSS satellite time. These
 * ranges depend on the constellation and code being tracked and the state of the tracking
 * algorithms given by the {@link #getState} method. The minimum value of this field is zero.
 * The maximum value of this field is determined by looking across all of the state flags
 * that are set, for the given constellation and code type, and finding the the maximum value
 * in this table.
 *
 * <p>For example, for GPS L1 C/A, if STATE_TOW_KNOWN is set, this field can be any value from 0
 * to 1 week (in nanoseconds), and for GAL E1B code, if only STATE_GAL_E1BC_CODE_LOCK is set,
 * then this field can be any value from 0 to 4 milliseconds (in nanoseconds.)
 *
 * <table border="1">
 *   <thead>
 *     <tr>
 *       <td />
 *       <td colspan="3"><strong>GPS/QZSS</strong></td>
 *       <td><strong>GLNS</strong></td>
 *       <td colspan="2"><strong>BDS</strong></td>
 *       <td colspan="3"><strong>GAL</strong></td>
 *       <td><strong>SBAS</strong></td>
 *     </tr>
 *     <tr>
 *       <td><strong>State Flag</strong></td>
 *       <td><strong>L1 C/A</strong></td>
 *       <td><strong>L5I</strong></td>
 *       <td><strong>L5Q</strong></td>
 *       <td><strong>L1OF</strong></td>
 *       <td><strong>B1I (D1)</strong></td>
 *       <td><strong>B1I &nbsp;(D2)</strong></td>
 *       <td><strong>E1B</strong></td>
 *       <td><strong>E1C</strong></td>
 *       <td><strong>E5AQ</strong></td>
 *       <td><strong>L1 C/A</strong></td>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>
 *         <strong>STATE_UNKNOWN</strong>
 *       </td>
 *       <td>0</td>
 *       <td>0</td>
 *       <td>0</td>
 *       <td>0</td>
 *       <td>0</td>
 *       <td>0</td>
 *       <td>0</td>
 *       <td>0</td>
 *       <td>0</td>
 *       <td>0</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <strong>STATE_CODE_LOCK</strong>
 *       </td>
 *       <td>1 ms</td>
 *       <td>1 ms</td>
 *       <td>1 ms</td>
 *       <td>1 ms</td>
 *       <td>1 ms</td>
 *       <td>1 ms</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>1 ms</td>
 *       <td>1 ms</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <strong>STATE_SYMBOL_SYNC</strong>
 *       </td>
 *       <td>20 ms (optional)</td>
 *       <td>10 ms</td>
 *       <td>1 ms (optional)</td>
 *       <td>10 ms</td>
 *       <td>20 ms (optional)</td>
 *       <td>2 ms</td>
 *       <td>4 ms (optional)</td>
 *       <td>4 ms (optional)</td>
 *       <td>1 ms (optional)</td>
 *       <td>2 ms</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <strong>STATE_BIT_SYNC</strong>
 *       </td>
 *       <td>20 ms</td>
 *       <td>20 ms</td>
 *       <td>1 ms (optional)</td>
 *       <td>20 ms</td>
 *       <td>20 ms</td>
 *       <td>-</td>
 *       <td>8 ms</td>
 *       <td>-</td>
 *       <td>1 ms (optional)</td>
 *       <td>4 ms</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <strong>STATE_SUBFRAME_SYNC</strong>
 *       </td>
 *       <td>6s</td>
 *       <td>6s</td>
 *       <td>-</td>
 *       <td>2 s</td>
 *       <td>6 s</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>100 ms</td>
 *       <td>-</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <strong>STATE_TOW_DECODED</strong>
 *       </td>
 *       <td colspan="2">1 week</td>
 *       <td>-</td>
 *       <td>1 day</td>
 *       <td colspan="2">1 week</td>
 *       <td colspan="2">1 week</td>
 *       <td>-</td>
 *       <td>1 week</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <strong>STATE_TOW_KNOWN</strong>
 *       </td>
 *       <td colspan="3">1 week</td>
 *       <td>1 day</td>
 *       <td colspan="2">1 week</td>
 *       <td colspan="3">1 week</td>
 *       <td>1 week</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <strong>STATE_GLO_STRING_SYNC</strong>
 *       </td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>2 s</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <strong>STATE_GLO_TOD_DECODED</strong>
 *       </td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>1 day</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <strong>STATE_GLO_TOD_KNOWN</strong>
 *       </td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>1 day</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <strong>STATE_BDS_D2_BIT_SYNC</strong>
 *       </td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>2 ms</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <strong>STATE_BDS_D2_SUBFRAME_SYNC</strong>
 *       </td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>600 ms</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <strong>STATE_GAL_E1BC_CODE_LOCK</strong>
 *       </td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>4 ms</td>
 *       <td>4 ms</td>
 *       <td>-</td>
 *       <td>-</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <strong>STATE_GAL_E1C_2ND_CODE_LOCK</strong>
 *       </td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>100 ms</td>
 *       <td>-</td>
 *       <td>-</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <strong>STATE_2ND_CODE_LOCK</strong>
 *       </td>
 *       <td>-</td>
 *       <td>10 ms (optional)</td>
 *       <td>20 ms</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>100 ms (optional)</td>
 *       <td>100 ms</td>
 *       <td>-</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <strong>STATE_GAL_E1B_PAGE_SYNC</strong>
 *       </td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>2 s</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *     </tr>
 *     <tr>
 *       <td>
 *         <strong>STATE_SBAS_SYNC</strong>
 *       </td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>-</td>
 *       <td>1 s</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * <p>Note: TOW Known refers to the case where TOW is possibly not decoded over the air but has
 * been determined from other sources. If TOW decoded is set then TOW Known must also be set.
 *
 * <p>Note well: if there is any ambiguity in integer millisecond, STATE_MSEC_AMBIGUOUS must be
 * set accordingly, in the 'state' field. This value must be populated, unless the 'state' ==
 * STATE_UNKNOWN.
 *
 * <p>Note on optional flags:
 * <ul>
 *     <li> For L1 C/A and B1I, STATE_SYMBOL_SYNC is optional since the symbol length is the
 *     same as the bit length.
 *     <li> For L5Q and E5aQ, STATE_BIT_SYNC and STATE_SYMBOL_SYNC are optional since they are
 *     implied by STATE_CODE_LOCK.
 *     <li> STATE_2ND_CODE_LOCK for L5I is optional since it is implied by STATE_SYMBOL_SYNC.
 *     <li> STATE_2ND_CODE_LOCK for E1C is optional since it is implied by
 *     STATE_GAL_E1C_2ND_CODE_LOCK.
 *     <li> For E1B and E1C, STATE_SYMBOL_SYNC is optional, because it is implied by
 *     STATE_GAL_E1BC_CODE_LOCK.
 * </ul>
 * @apiSince 24
 */

public long getReceivedSvTimeNanos() { throw new RuntimeException("Stub!"); }

/**
 * Gets the error estimate (1-sigma) for the received GNSS time, in nanoseconds.
 * @apiSince 24
 */

public long getReceivedSvTimeUncertaintyNanos() { throw new RuntimeException("Stub!"); }

/**
 * Gets the Carrier-to-noise density in dB-Hz.
 *
 * <p>Typical range: 10-50 db-Hz.
 *
 * <p>The value contains the measured C/N0 for the signal at the antenna input.
 * @apiSince 24
 */

public double getCn0DbHz() { throw new RuntimeException("Stub!"); }

/**
 * Gets the Pseudorange rate at the timestamp in m/s.
 *
 * <p>The error estimate for this value is
 * {@link #getPseudorangeRateUncertaintyMetersPerSecond()}.
 *
 * <p>The value is uncorrected, i.e. corrections for receiver and satellite clock frequency
 * errors are not included.
 *
 * <p>A positive 'uncorrected' value indicates that the SV is moving away from the receiver. The
 * sign of the 'uncorrected' 'pseudorange rate' and its relation to the sign of 'doppler shift'
 * is given by the equation:
 *
 * <pre>
 *      pseudorange rate = -k * doppler shift   (where k is a constant)</pre>
 * @apiSince 24
 */

public double getPseudorangeRateMetersPerSecond() { throw new RuntimeException("Stub!"); }

/**
 * Gets the pseudorange's rate uncertainty (1-Sigma) in m/s.
 *
 * <p>The uncertainty is represented as an absolute (single sided) value.
 * @apiSince 24
 */

public double getPseudorangeRateUncertaintyMetersPerSecond() { throw new RuntimeException("Stub!"); }

/**
 * Gets 'Accumulated Delta Range' state.
 *
 * <p>It indicates whether {@link #getAccumulatedDeltaRangeMeters()} is reset or there is a
 * cycle slip (indicating 'loss of lock').
 
 * @return Value is either <code>0</code> or a combination of {@link android.location.GnssMeasurement#ADR_STATE_VALID}, {@link android.location.GnssMeasurement#ADR_STATE_RESET}, {@link android.location.GnssMeasurement#ADR_STATE_CYCLE_SLIP}, {@link android.location.GnssMeasurement#ADR_STATE_HALF_CYCLE_RESOLVED}, and {@link android.location.GnssMeasurement#ADR_STATE_HALF_CYCLE_REPORTED}
 * @apiSince 24
 */

public int getAccumulatedDeltaRangeState() { throw new RuntimeException("Stub!"); }

/**
 * Gets the accumulated delta range since the last channel reset, in meters.
 *
 * <p>The error estimate for this value is {@link #getAccumulatedDeltaRangeUncertaintyMeters()}.
 *
 * <p>The availability of the value is represented by {@link #getAccumulatedDeltaRangeState()}.
 *
 * <p>A positive value indicates that the SV is moving away from the receiver.
 * The sign of {@link #getAccumulatedDeltaRangeMeters()} and its relation to the sign of
 * {@link #getCarrierPhase()} is given by the equation:
 *
 * <pre>
 *          accumulated delta range = -k * carrier phase    (where k is a constant)</pre>
 *
 * <p>Similar to the concept of an RTCM "Phaserange", when the accumulated delta range is
 * initially chosen, and whenever it is reset, it will retain the integer nature
 * of the relative carrier phase offset between satellites observed by this receiver, such that
 * the double difference of this value between receivers and satellites may be used, together
 * with integer ambiguity resolution, to determine highly precise relative location between
 * receivers.
 *
 * <p>This includes ensuring that all half-cycle ambiguities are resolved before this value is
 * reported as {@link #ADR_STATE_VALID}.
 *
 * <p>The alignment of the phase measurement will not be adjusted by the receiver so the
 * in-phase and quadrature phase components will have a quarter cycle offset as they do when
 * transmitted from the satellites. If the measurement is from a combination of the in-phase
 * and quadrature phase components, then the alignment of the phase measurement will be aligned
 * to the in-phase component.
 * @apiSince 24
 */

public double getAccumulatedDeltaRangeMeters() { throw new RuntimeException("Stub!"); }

/**
 * Gets the accumulated delta range's uncertainty (1-Sigma) in meters.
 *
 * <p>The uncertainty is represented as an absolute (single sided) value.
 *
 * <p>The status of the value is represented by {@link #getAccumulatedDeltaRangeState()}.
 * @apiSince 24
 */

public double getAccumulatedDeltaRangeUncertaintyMeters() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getCarrierFrequencyHz()} is available, {@code false}
 * otherwise.
 * @apiSince 24
 */

public boolean hasCarrierFrequencyHz() { throw new RuntimeException("Stub!"); }

/**
 * Gets the carrier frequency of the tracked signal.
 *
 * <p>For example it can be the GPS central frequency for L1 = 1575.45 MHz, or L2 = 1227.60 MHz,
 * L5 = 1176.45 MHz, varying GLO channels, etc. If the field is not set, it is the primary
 * common use central frequency, e.g. L1 = 1575.45 MHz for GPS.
 *
 * <p> For an L1, L5 receiver tracking a satellite on L1 and L5 at the same time, two raw
 * measurement objects will be reported for this same satellite, in one of the measurement
 * objects, all the values related to L1 will be filled, and in the other all of the values
 * related to L5 will be filled.
 *
 * <p>The value is only available if {@link #hasCarrierFrequencyHz()} is {@code true}.
 *
 * @return the carrier frequency of the signal tracked in Hz.
 * @apiSince 24
 */

public float getCarrierFrequencyHz() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getCarrierCycles()} is available, {@code false} otherwise.
 *
 * @deprecated use {@link #getAccumulatedDeltaRangeState()} instead.
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated
public boolean hasCarrierCycles() { throw new RuntimeException("Stub!"); }

/**
 * The number of full carrier cycles between the satellite and the receiver.
 *
 * <p>The reference frequency is given by the value of {@link #getCarrierFrequencyHz()}.
 *
 * <p>The value is only available if {@link #hasCarrierCycles()} is {@code true}.
 *
 * @deprecated use {@link #getAccumulatedDeltaRangeMeters()} instead.
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated
public long getCarrierCycles() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getCarrierPhase()} is available, {@code false} otherwise.
 *
 * @deprecated use {@link #getAccumulatedDeltaRangeState()} instead.
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated
public boolean hasCarrierPhase() { throw new RuntimeException("Stub!"); }

/**
 * Gets the RF phase detected by the receiver.
 *
 * <p>Range: [0.0, 1.0].
 *
 * <p>This is the fractional part of the complete carrier phase measurement.
 *
 * <p>The reference frequency is given by the value of {@link #getCarrierFrequencyHz()}.
 *
 * <p>The error estimate for this value is {@link #getCarrierPhaseUncertainty()}.
 *
 * <p>The value is only available if {@link #hasCarrierPhase()} is {@code true}.
 *
 * @deprecated use {@link #getAccumulatedDeltaRangeMeters()} instead.
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated
public double getCarrierPhase() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getCarrierPhaseUncertainty()} is available, {@code false}
 * otherwise.
 *
 * @deprecated use {@link #getAccumulatedDeltaRangeState()} instead.
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated
public boolean hasCarrierPhaseUncertainty() { throw new RuntimeException("Stub!"); }

/**
 * Gets the carrier-phase's uncertainty (1-Sigma).
 *
 * <p>The uncertainty is represented as an absolute (single sided) value.
 *
 * <p>The value is only available if {@link #hasCarrierPhaseUncertainty()} is {@code true}.
 *
 * @deprecated use {@link #getAccumulatedDeltaRangeUncertaintyMeters()} instead.
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated
public double getCarrierPhaseUncertainty() { throw new RuntimeException("Stub!"); }

/**
 * Gets a value indicating the 'multipath' state of the event.
 
 * @return Value is {@link android.location.GnssMeasurement#MULTIPATH_INDICATOR_UNKNOWN}, {@link android.location.GnssMeasurement#MULTIPATH_INDICATOR_DETECTED}, or {@link android.location.GnssMeasurement#MULTIPATH_INDICATOR_NOT_DETECTED}
 * @apiSince 24
 */

public int getMultipathIndicator() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getSnrInDb()} is available, {@code false} otherwise.
 * @apiSince 24
 */

public boolean hasSnrInDb() { throw new RuntimeException("Stub!"); }

/**
 * Gets the (post-correlation & integration) Signal-to-Noise ratio (SNR) in dB.
 *
 * <p>The value is only available if {@link #hasSnrInDb()} is {@code true}.
 * @apiSince 24
 */

public double getSnrInDb() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getAutomaticGainControlLevelDb()} is available,
 * {@code false} otherwise.
 * @apiSince 26
 */

public boolean hasAutomaticGainControlLevelDb() { throw new RuntimeException("Stub!"); }

/**
 * Gets the Automatic Gain Control level in dB.
 *
 * <p> AGC acts as a variable gain amplifier adjusting the power of the incoming signal. The AGC
 * level may be used to indicate potential interference. When AGC is at a nominal level, this
 * value must be set as 0. Higher gain (and/or lower input power) shall be output as a positive
 * number. Hence in cases of strong jamming, in the band of this signal, this value will go more
 * negative.
 *
 * <p> Note: Different hardware designs (e.g. antenna, pre-amplification, or other RF HW
 * components) may also affect the typical output of of this value on any given hardware design
 * in an open sky test - the important aspect of this output is that changes in this value are
 * indicative of changes on input signal power in the frequency band for this measurement.
 *
 * <p> The value is only available if {@link #hasAutomaticGainControlLevelDb()} is {@code true}
 * @apiSince 26
 */

public double getAutomaticGainControlLevelDb() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@link #getCodeType()} is available,
 * {@code false} otherwise.
 * @apiSince 29
 */

public boolean hasCodeType() { throw new RuntimeException("Stub!"); }

/**
 * Gets the GNSS measurement's code type.
 *
 * <p>Similar to the Attribute field described in RINEX 3.03, e.g., in Tables 4-10, and Table
 * A2 at the RINEX 3.03 Update 1 Document.
 *
 * <p>Returns "A" for GALILEO E1A, GALILEO E6A, IRNSS L5A, IRNSS SA.
 *
 * <p>Returns "B" for GALILEO E1B, GALILEO E6B, IRNSS L5B, IRNSS SB.
 *
 * <p>Returns "C" for GPS L1 C/A,  GPS L2 C/A, GLONASS G1 C/A, GLONASS G2 C/A, GALILEO E1C,
 * GALILEO E6C, SBAS L1 C/A, QZSS L1 C/A, IRNSS L5C.
 *
 * <p>Returns "I" for GPS L5 I, GLONASS G3 I, GALILEO E5a I, GALILEO E5b I, GALILEO E5a+b I,
 * SBAS L5 I, QZSS L5 I, BDS B1 I, BDS B2 I, BDS B3 I.
 *
 * <p>Returns "L" for GPS L1C (P), GPS L2C (L), QZSS L1C (P), QZSS L2C (L), LEX(6) L.
 *
 * <p>Returns "M" for GPS L1M, GPS L2M.
 *
 * <p>Returns "N" for GPS L1 codeless, GPS L2 codeless.
 *
 * <p>Returns "P" for GPS L1P, GPS L2P, GLONASS G1P, GLONASS G2P.
 *
 * <p>Returns "Q" for GPS L5 Q, GLONASS G3 Q, GALILEO E5a Q, GALILEO E5b Q, GALILEO E5a+b Q,
 * SBAS L5 Q, QZSS L5 Q, BDS B1 Q, BDS B2 Q, BDS B3 Q.
 *
 * <p>Returns "S" for GPS L1C (D), GPS L2C (M), QZSS L1C (D), QZSS L2C (M), LEX(6) S.
 *
 * <p>Returns "W" for GPS L1 Z-tracking, GPS L2 Z-tracking.
 *
 * <p>Returns "X" for GPS L1C (D+P), GPS L2C (M+L), GPS L5 (I+Q), GLONASS G3 (I+Q), GALILEO
 * E1 (B+C), GALILEO E5a (I+Q), GALILEO E5b (I+Q), GALILEO E5a+b(I+Q), GALILEO E6 (B+C), SBAS
 * L5 (I+Q), QZSS L1C (D+P), QZSS L2C (M+L), QZSS L5 (I+Q), LEX(6) (S+L), BDS B1 (I+Q), BDS
 * B2 (I+Q), BDS B3 (I+Q), IRNSS L5 (B+C).
 *
 * <p>Returns "Y" for GPS L1Y, GPS L2Y.
 *
 * <p>Returns "Z" for GALILEO E1 (A+B+C), GALILEO E6 (A+B+C), QZSS L1-SAIF.
 *
 * <p>Returns "UNKNOWN" if the GNSS Measurement's code type is unknown.
 *
 * <p>This is used to specify the observation descriptor defined in GNSS Observation Data File
 * Header Section Description in the RINEX standard (Version 3.XX), in cases where the code type
 * does not align with the above listed values. For example, if a code type "G" is added, this
 * string shall be set to "G".
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String getCodeType() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The state of the {@link #getAccumulatedDeltaRangeMeters()} has a cycle slip detected.
 * @apiSince 24
 */

public static final int ADR_STATE_CYCLE_SLIP = 4; // 0x4

/**
 * Reports whether the flag {@link #ADR_STATE_HALF_CYCLE_RESOLVED} has been reported by the
 * GNSS hardware.
 *
 * <p> When this bit is set, the value of {@link #getAccumulatedDeltaRangeUncertaintyMeters()}
 * can be low (centimeter level) whether or not the half cycle ambiguity is resolved.
 *
 * <p> When this bit is unset, the value of {@link #getAccumulatedDeltaRangeUncertaintyMeters()}
 * is larger, to cover the potential error due to half cycle ambiguity being unresolved.
 * @apiSince 28
 */

public static final int ADR_STATE_HALF_CYCLE_REPORTED = 16; // 0x10

/**
 * Reports whether the value {@link #getAccumulatedDeltaRangeMeters()} has resolved the half
 * cycle ambiguity.
 *
 * <p> When this bit is set, the {@link #getAccumulatedDeltaRangeMeters()} corresponds to the
 * carrier phase measurement plus an accumulated integer number of carrier full cycles.
 *
 * <p> When this bit is unset, the {@link #getAccumulatedDeltaRangeMeters()} corresponds to the
 * carrier phase measurement plus an accumulated integer number of carrier half cycles.
 * @apiSince 28
 */

public static final int ADR_STATE_HALF_CYCLE_RESOLVED = 8; // 0x8

/**
 * The state of the {@link #getAccumulatedDeltaRangeMeters()} has detected a reset.
 * @apiSince 24
 */

public static final int ADR_STATE_RESET = 2; // 0x2

/**
 * The state of the value {@link #getAccumulatedDeltaRangeMeters()} is invalid or unknown.
 * @apiSince 24
 */

public static final int ADR_STATE_UNKNOWN = 0; // 0x0

/**
 * The state of the {@link #getAccumulatedDeltaRangeMeters()} is valid.
 * @apiSince 24
 */

public static final int ADR_STATE_VALID = 1; // 0x1

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.location.GnssMeasurement> CREATOR;
static { CREATOR = null; }

/**
 * The measurement shows signs of multi-path.
 * @apiSince 24
 */

public static final int MULTIPATH_INDICATOR_DETECTED = 1; // 0x1

/**
 * The measurement shows no signs of multi-path.
 * @apiSince 24
 */

public static final int MULTIPATH_INDICATOR_NOT_DETECTED = 2; // 0x2

/**
 * The indicator is not available or the presence or absence of multipath is unknown.
 * @apiSince 24
 */

public static final int MULTIPATH_INDICATOR_UNKNOWN = 0; // 0x0

/**
 * This GNSS measurement's tracking state has secondary code lock.
 * @apiSince 29
 */

public static final int STATE_2ND_CODE_LOCK = 65536; // 0x10000

/**
 * This Beidou measurement's tracking state has D2 bit sync.
 * @apiSince 24
 */

public static final int STATE_BDS_D2_BIT_SYNC = 256; // 0x100

/**
 * This Beidou measurement's tracking state has D2 sub-frame sync.
 * @apiSince 24
 */

public static final int STATE_BDS_D2_SUBFRAME_SYNC = 512; // 0x200

/**
 * This GNSS measurement's tracking state has bit sync.
 * @apiSince 24
 */

public static final int STATE_BIT_SYNC = 2; // 0x2

/**
 * This GNSS measurement's tracking state has code lock.
 * @apiSince 24
 */

public static final int STATE_CODE_LOCK = 1; // 0x1

/**
 * This Galileo measurement's tracking state has E1B/C code lock.
 * @apiSince 24
 */

public static final int STATE_GAL_E1BC_CODE_LOCK = 1024; // 0x400

/**
 * This Galileo measurement's tracking state has E1B page sync.
 * @apiSince 24
 */

public static final int STATE_GAL_E1B_PAGE_SYNC = 4096; // 0x1000

/**
 * This Galileo measurement's tracking state has E1C secondary code lock.
 * @apiSince 24
 */

public static final int STATE_GAL_E1C_2ND_CODE_LOCK = 2048; // 0x800

/**
 * This Glonass measurement's tracking state has string sync.
 * @apiSince 24
 */

public static final int STATE_GLO_STRING_SYNC = 64; // 0x40

/**
 * This Glonass measurement's tracking state has time-of-day decoded.
 * @apiSince 24
 */

public static final int STATE_GLO_TOD_DECODED = 128; // 0x80

/**
 * This Glonass measurement's tracking state has time-of-day known, possibly not decoded
 * over the air but has been determined from other sources. If TOD decoded is set then TOD Known
 * will also be set.
 * @apiSince 26
 */

public static final int STATE_GLO_TOD_KNOWN = 32768; // 0x8000

/**
 * This GNSS measurement's tracking state contains millisecond ambiguity.
 * @apiSince 24
 */

public static final int STATE_MSEC_AMBIGUOUS = 16; // 0x10

/**
 * This SBAS measurement's tracking state has whole second level sync.
 * @apiSince 24
 */

public static final int STATE_SBAS_SYNC = 8192; // 0x2000

/**
 * This GNSS measurement's tracking state has sub-frame sync.
 * @apiSince 24
 */

public static final int STATE_SUBFRAME_SYNC = 4; // 0x4

/**
 * This GNSS measurement's tracking state has symbol sync.
 * @apiSince 24
 */

public static final int STATE_SYMBOL_SYNC = 32; // 0x20

/**
 * This GNSS measurement's tracking state has time-of-week decoded.
 * @apiSince 24
 */

public static final int STATE_TOW_DECODED = 8; // 0x8

/**
 * This GNSS measurement's tracking state has time-of-week known, possibly not decoded
 * over the air but has been determined from other sources. If TOW decoded is set then TOW Known
 * will also be set.
 * @apiSince 26
 */

public static final int STATE_TOW_KNOWN = 16384; // 0x4000

/**
 * This GNSS measurement's tracking state is invalid or unknown.
 * @apiSince 24
 */

public static final int STATE_UNKNOWN = 0; // 0x0
}

