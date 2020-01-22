/*
 * Copyright (C) 2015 The Android Open Source Project
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


package android.mtp;


/**
 * This class encapsulates information about a MTP event.
 * This corresponds to the events described in appendix G of the MTP specification.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MtpEvent {

private MtpEvent() { throw new RuntimeException("Stub!"); }

/**
 * Returns event code of MTP event.
 * See the USB-IF MTP specification for the details of event constants.
 * @return event code
 * @apiSince 24
 */

public int getEventCode() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the first event parameter.
 * @apiSince 24
 */

public int getParameter1() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the second event parameter.
 * @apiSince 24
 */

public int getParameter2() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the third event parameter.
 * @apiSince 24
 */

public int getParameter3() { throw new RuntimeException("Stub!"); }

/**
 * Obtains objectHandle event parameter.
 *
 * @see #EVENT_OBJECT_ADDED
 * @see #EVENT_OBJECT_REMOVED
 * @see #EVENT_OBJECT_INFO_CHANGED
 * @see #EVENT_REQUEST_OBJECT_TRANSFER
 * @see #EVENT_OBJECT_PROP_CHANGED
 * @see #EVENT_OBJECT_REFERENCES_CHANGED
 * @apiSince 24
 */

public int getObjectHandle() { throw new RuntimeException("Stub!"); }

/**
 * Obtains storageID event parameter.
 *
 * @see #EVENT_STORE_ADDED
 * @see #EVENT_STORE_REMOVED
 * @see #EVENT_STORE_FULL
 * @see #EVENT_STORAGE_INFO_CHANGED
 * @apiSince 24
 */

public int getStorageId() { throw new RuntimeException("Stub!"); }

/**
 * Obtains devicePropCode event parameter.
 *
 * @see #EVENT_DEVICE_PROP_CHANGED
 * @apiSince 24
 */

public int getDevicePropCode() { throw new RuntimeException("Stub!"); }

/**
 * Obtains transactionID event parameter.
 *
 * @see #EVENT_CAPTURE_COMPLETE
 * @apiSince 24
 */

public int getTransactionId() { throw new RuntimeException("Stub!"); }

/**
 * Obtains objectPropCode event parameter.
 *
 * @see #EVENT_OBJECT_PROP_CHANGED
 * @see #EVENT_OBJECT_PROP_DESC_CHANGED
 * @apiSince 24
 */

public int getObjectPropCode() { throw new RuntimeException("Stub!"); }

/**
 * Obtains objectFormatCode event parameter.
 *
 * @see #EVENT_OBJECT_PROP_DESC_CHANGED
 * @apiSince 24
 */

public int getObjectFormatCode() { throw new RuntimeException("Stub!"); }

/**
 * Event code for CANCEL_TRANSACTION event
 * @apiSince 24
 */

public static final int EVENT_CANCEL_TRANSACTION = 16385; // 0x4001

/**
 * Event code for CAPTURE_COMPLETE event
 * @apiSince 24
 */

public static final int EVENT_CAPTURE_COMPLETE = 16397; // 0x400d

/**
 * Event code for DEVICE_INFO_CHANGED event
 * @apiSince 24
 */

public static final int EVENT_DEVICE_INFO_CHANGED = 16392; // 0x4008

/**
 * Event code for DEVICE_PROP_CHANGED event
 * @apiSince 24
 */

public static final int EVENT_DEVICE_PROP_CHANGED = 16390; // 0x4006

/**
 * Event code for DEVICE_RESET event
 * @apiSince 24
 */

public static final int EVENT_DEVICE_RESET = 16395; // 0x400b

/**
 * Event code for OBJECT_ADDED event
 * @apiSince 24
 */

public static final int EVENT_OBJECT_ADDED = 16386; // 0x4002

/**
 * Event code for OBJECT_INFO_CHANGED event
 * @apiSince 24
 */

public static final int EVENT_OBJECT_INFO_CHANGED = 16391; // 0x4007

/**
 * Event code for OBJECT_PROP_CHANGED event
 * @apiSince 24
 */

public static final int EVENT_OBJECT_PROP_CHANGED = 51201; // 0xc801

/**
 * Event code for OBJECT_PROP_DESC_CHANGED event
 * @apiSince 24
 */

public static final int EVENT_OBJECT_PROP_DESC_CHANGED = 51202; // 0xc802

/**
 * Event code for OBJECT_REFERENCES_CHANGED event
 * @apiSince 24
 */

public static final int EVENT_OBJECT_REFERENCES_CHANGED = 51203; // 0xc803

/**
 * Event code for OBJECT_REMOVED event
 * @apiSince 24
 */

public static final int EVENT_OBJECT_REMOVED = 16387; // 0x4003

/**
 * Event code for REQUEST_OBJECT_TRANSFER event
 * @apiSince 24
 */

public static final int EVENT_REQUEST_OBJECT_TRANSFER = 16393; // 0x4009

/**
 * Event code for STORAGE_INFO_CHANGED event
 * @apiSince 24
 */

public static final int EVENT_STORAGE_INFO_CHANGED = 16396; // 0x400c

/**
 * Event code for STORE_ADDED event
 * @apiSince 24
 */

public static final int EVENT_STORE_ADDED = 16388; // 0x4004

/**
 * Event code for STORE_FULL event
 * @apiSince 24
 */

public static final int EVENT_STORE_FULL = 16394; // 0x400a

/**
 * Event code for STORE_REMOVED event
 * @apiSince 24
 */

public static final int EVENT_STORE_REMOVED = 16389; // 0x4005

/**
 * Event code for UNDEFINED event
 * @apiSince 24
 */

public static final int EVENT_UNDEFINED = 16384; // 0x4000

/**
 * Event code for UNREPORTED_STATUS event
 * @apiSince 24
 */

public static final int EVENT_UNREPORTED_STATUS = 16398; // 0x400e
}

