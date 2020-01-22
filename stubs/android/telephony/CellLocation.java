/*
 * Copyright (C) 2006 The Android Open Source Project
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
 * Abstract class that represents the location of the device.  {@more}
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CellLocation {

public CellLocation() { throw new RuntimeException("Stub!"); }

/**
 * Request an update of the current location.  If the location has changed,
 * a broadcast will be sent to everyone registered with {@link android.telephony.PhoneStateListener#LISTEN_CELL_LOCATION PhoneStateListener#LISTEN_CELL_LOCATION}.
 * @apiSince 1
 */

public static void requestLocationUpdate() { throw new RuntimeException("Stub!"); }

/**
 * Return a new CellLocation object representing an unknown
 * location, or null for unknown/none phone radio types.
 *
 * @apiSince 1
 */

public static android.telephony.CellLocation getEmpty() { throw new RuntimeException("Stub!"); }
}

