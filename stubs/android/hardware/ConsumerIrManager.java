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


package android.hardware;

import android.content.pm.PackageManager;

/**
 * Class that operates consumer infrared on the device.
 
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_CONSUMER_IR PackageManager#FEATURE_CONSUMER_IR} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ConsumerIrManager {

ConsumerIrManager() { throw new RuntimeException("Stub!"); }

/**
 * Check whether the device has an infrared emitter.
 *
 * @return true if the device has an infrared emitter, else false.
 * @apiSince 19
 */

public boolean hasIrEmitter() { throw new RuntimeException("Stub!"); }

/**
 * Transmit an infrared pattern
 * <p>
 * This method is synchronous; when it returns the pattern has
 * been transmitted. Only patterns shorter than 2 seconds will
 * be transmitted.
 * </p>
 *
 * @param carrierFrequency The IR carrier frequency in Hertz.
 * @param pattern The alternating on/off pattern in microseconds to transmit.
 * @apiSince 19
 */

public void transmit(int carrierFrequency, int[] pattern) { throw new RuntimeException("Stub!"); }

/**
 * Query the infrared transmitter's supported carrier frequencies
 *
 * @return an array of
 * {@link android.hardware.ConsumerIrManager.CarrierFrequencyRange}
 * objects representing the ranges that the transmitter can support, or
 * null if there was an error communicating with the Consumer IR Service.
 * @apiSince 19
 */

public android.hardware.ConsumerIrManager.CarrierFrequencyRange[] getCarrierFrequencies() { throw new RuntimeException("Stub!"); }
/**
 * Represents a range of carrier frequencies (inclusive) on which the
 * infrared transmitter can transmit
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CarrierFrequencyRange {

/**
 * Create a segment of a carrier frequency range.
 *
 * @param min The minimum transmittable frequency in this range segment.
 * @param max The maximum transmittable frequency in this range segment.
 */

public CarrierFrequencyRange(int min, int max) { throw new RuntimeException("Stub!"); }

/**
 * Get the minimum (inclusive) frequency in this range segment.
 * @apiSince 19
 */

public int getMinFrequency() { throw new RuntimeException("Stub!"); }

/**
 * Get the maximum (inclusive) frequency in this range segment.
 * @apiSince 19
 */

public int getMaxFrequency() { throw new RuntimeException("Stub!"); }
}

}

