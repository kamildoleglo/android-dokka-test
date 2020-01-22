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


package android.telephony.gsm;

import android.os.Bundle;

/**
 * Represents the cell location on a GSM phone.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GsmCellLocation extends android.telephony.CellLocation {

/**
 * Empty constructor.  Initializes the LAC and CID to -1.
 * @apiSince 1
 */

public GsmCellLocation() { throw new RuntimeException("Stub!"); }

/**
 * Initialize the object from a bundle.
 * @apiSince 1
 */

public GsmCellLocation(android.os.Bundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * @return gsm location area code, -1 if unknown, 0xffff max legal value
 * @apiSince 1
 */

public int getLac() { throw new RuntimeException("Stub!"); }

/**
 * @return gsm cell id, -1 if unknown, 0xffff max legal value
 * @apiSince 1
 */

public int getCid() { throw new RuntimeException("Stub!"); }

/**
 * On a UMTS network, returns the primary scrambling code of the serving
 * cell.
 *
 * @return primary scrambling code for UMTS, -1 if unknown or GSM
 * @apiSince 9
 */

public int getPsc() { throw new RuntimeException("Stub!"); }

/**
 * Invalidate this object.  The location area code and the cell id are set to -1.
 * @apiSince 1
 */

public void setStateInvalid() { throw new RuntimeException("Stub!"); }

/**
 * Set the location area code and the cell id.
 * @apiSince 1
 */

public void setLacAndCid(int lac, int cid) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Set intent notifier Bundle based on service state
 *
 * @param m intent notifier Bundle
 * @apiSince 1
 */

public void fillInNotifierBundle(android.os.Bundle m) { throw new RuntimeException("Stub!"); }
}

