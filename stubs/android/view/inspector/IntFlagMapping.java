/*
 * Copyright 2018 The Android Open Source Project
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


package android.view.inspector;


/**
 * Maps the values of an {@code int} property to sets of string for properties that encode flags.
 *
 * An {@link android.view.inspector.InspectionCompanion InspectionCompanion} may provide an instance of this class to a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * for flag values packed into primitive {@code int} properties.
 *
 * Each flag has a mask and a target value, for non-exclusive flags, the target can also be used as
 * the mask. A given integer value is compared against each flag to find what flags are active for
 * it by bitwise anding it with the mask and comparing the result against the target, that is,
 * {@code (value & mask) == target}.
 *
 * @see android.view.inspector.PropertyMapper#mapIntFlag(String, int, java.util.function.IntFunction)
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class IntFlagMapping {

public IntFlagMapping() { throw new RuntimeException("Stub!"); }

/**
 * Get a set of the names of enabled flags for a given property value.
 *
 * @param value The value of the property
 * @return The names of the enabled flags, empty if no flags enabled
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.Set<java.lang.String> get(int value) { throw new RuntimeException("Stub!"); }

/**
 * Add a mutually exclusive flag to the map.
 *
 * @param mask The bit mask to compare to and with a value
 * @param target The target value to compare the masked value with
 * @param name The name of the flag to include if enabled
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void add(int mask, int target, @androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }
}

