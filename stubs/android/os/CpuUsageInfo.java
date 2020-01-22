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


package android.os;


/**
 * CPU usage information per core.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CpuUsageInfo implements android.os.Parcelable {

CpuUsageInfo() { throw new RuntimeException("Stub!"); }

/**
 * Gets the active time in milliseconds since the system last booted.
 *
 * @return Active time in milliseconds.
 * @apiSince 24
 */

public long getActive() { throw new RuntimeException("Stub!"); }

/**
 * Gets the total time in milliseconds that the CPU has been enabled since the system last
 * booted. This includes time the CPU spent idle.
 *
 * @return Total time in milliseconds.
 * @apiSince 24
 */

public long getTotal() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.os.CpuUsageInfo> CREATOR;
static { CREATOR = null; }
}

