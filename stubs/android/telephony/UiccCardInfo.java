/*
 * Copyright (C) 2018 The Android Open Source Project
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
 * The UiccCardInfo represents information about a currently inserted UICC or embedded eUICC.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class UiccCardInfo implements android.os.Parcelable {

UiccCardInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Return whether the UICC is an eUICC.
 * @return true if the UICC is an eUICC.
 * @apiSince 29
 */

public boolean isEuicc() { throw new RuntimeException("Stub!"); }

/**
 * Get the card ID of the UICC. See {@link android.telephony.TelephonyManager#getCardIdForDefaultEuicc() TelephonyManager#getCardIdForDefaultEuicc()} for more
 * details on card ID.
 * @apiSince 29
 */

public int getCardId() { throw new RuntimeException("Stub!"); }

/**
 * Get the embedded ID (EID) of the eUICC. If the UiccCardInfo is not an eUICC
 * (see {@link #isEuicc()}), or the EID is not available, returns null.
 * <p>
 * Note that this field may be omitted if the caller does not have the correct permissions
 * (see {@link android.telephony.TelephonyManager#getUiccCardsInfo() TelephonyManager#getUiccCardsInfo()}).
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getEid() { throw new RuntimeException("Stub!"); }

/**
 * Get the ICCID of the UICC. If the ICCID is not availble, returns null.
 * <p>
 * Note that this field may be omitted if the caller does not have the correct permissions
 * (see {@link android.telephony.TelephonyManager#getUiccCardsInfo() TelephonyManager#getUiccCardsInfo()}).
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getIccId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the slot index for the slot that the UICC is currently inserted in.
 * @apiSince 29
 */

public int getSlotIndex() { throw new RuntimeException("Stub!"); }

/**
 * Return whether the UICC or eUICC is removable.
 * <p>
 * UICCs are generally removable, but eUICCs may be removable or built in to the device.
 * @return true if the UICC or eUICC is removable
 * @apiSince 29
 */

public boolean isRemovable() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.UiccCardInfo> CREATOR;
static { CREATOR = null; }
}

