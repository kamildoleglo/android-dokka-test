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
 * limitations under the License.
 */


package android.telephony;

import android.os.Parcelable;
import android.content.Context;
import android.util.DisplayMetrics;
import android.graphics.Bitmap;

/**
 * A Parcelable class for Subscription Information.
 * @apiSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SubscriptionInfo implements android.os.Parcelable {

SubscriptionInfo() { throw new RuntimeException("Stub!"); }

/**
 * @return the subscription ID.
 * @apiSince 22
 */

public int getSubscriptionId() { throw new RuntimeException("Stub!"); }

/**
 * @return the ICC ID.
 * @apiSince 22
 */

public java.lang.String getIccId() { throw new RuntimeException("Stub!"); }

/**
 * @return the slot index of this Subscription's SIM card.
 * @apiSince 22
 */

public int getSimSlotIndex() { throw new RuntimeException("Stub!"); }

/**
 * @return the carrier id of this Subscription carrier.
 * @see android.telephony.TelephonyManager#getSimCarrierId()
 * @apiSince 29
 */

public int getCarrierId() { throw new RuntimeException("Stub!"); }

/**
 * @return the name displayed to the user that identifies this subscription
 * @apiSince 22
 */

public java.lang.CharSequence getDisplayName() { throw new RuntimeException("Stub!"); }

/**
 * @return the name displayed to the user that identifies Subscription provider name
 * @apiSince 22
 */

public java.lang.CharSequence getCarrierName() { throw new RuntimeException("Stub!"); }

/**
 * Creates and returns an icon {@code Bitmap} to represent this {@code SubscriptionInfo} in a
 * user interface.
 *
 * @param context A {@code Context} to get the {@code DisplayMetrics}s from.
 *
 * @return A bitmap icon for this {@code SubscriptionInfo}.
 * @apiSince 22
 */

public android.graphics.Bitmap createIconBitmap(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * A highlight color to use in displaying information about this {@code PhoneAccount}.
 *
 * @return A hexadecimal color value.
 * @apiSince 22
 */

public int getIconTint() { throw new RuntimeException("Stub!"); }

/**
 * @return the number of this subscription.
 * @apiSince 22
 */

public java.lang.String getNumber() { throw new RuntimeException("Stub!"); }

/**
 * @return the data roaming state for this subscription, either
 * {@link android.telephony.SubscriptionManager#DATA_ROAMING_ENABLE SubscriptionManager#DATA_ROAMING_ENABLE} or {@link android.telephony.SubscriptionManager#DATA_ROAMING_DISABLE SubscriptionManager#DATA_ROAMING_DISABLE}.
 * @apiSince 22
 */

public int getDataRoaming() { throw new RuntimeException("Stub!"); }

/**
 * @return the MCC.
 * @deprecated Use {@link #getMccString()} instead.
 * @apiSince 22
 * @deprecatedSince 29
 */

@Deprecated
public int getMcc() { throw new RuntimeException("Stub!"); }

/**
 * @return the MNC.
 * @deprecated Use {@link #getMncString()} instead.
 * @apiSince 22
 * @deprecatedSince 29
 */

@Deprecated
public int getMnc() { throw new RuntimeException("Stub!"); }

/**
 * @return The MCC, as a string.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getMccString() { throw new RuntimeException("Stub!"); }

/**
 * @return The MNC, as a string.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getMncString() { throw new RuntimeException("Stub!"); }

/**
 * @return the ISO country code
 * @apiSince 22
 */

public java.lang.String getCountryIso() { throw new RuntimeException("Stub!"); }

/**
 * @return whether the subscription is an eUICC one.
 * @apiSince 28
 */

public boolean isEmbedded() { throw new RuntimeException("Stub!"); }

/**
 * An opportunistic subscription connects to a network that is
 * limited in functionality and / or coverage.
 *
 * @return whether subscription is opportunistic.
 * @apiSince 29
 */

public boolean isOpportunistic() { throw new RuntimeException("Stub!"); }

/**
 * Used in scenarios where different subscriptions are bundled as a group.
 * It's typically a primary and an opportunistic subscription. (see {@link #isOpportunistic()})
 * Such that those subscriptions will have some affiliated behaviors such as opportunistic
 * subscription may be invisible to the user.
 *
 * @return group UUID a String of group UUID if it belongs to a group. Otherwise
 * it will return null.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.os.ParcelUuid getGroupUuid() { throw new RuntimeException("Stub!"); }

/**
 * This method returns the type of a subscription. It can be
 * {@link android.telephony.SubscriptionManager#SUBSCRIPTION_TYPE_LOCAL_SIM SubscriptionManager#SUBSCRIPTION_TYPE_LOCAL_SIM} or
 * {@link android.telephony.SubscriptionManager#SUBSCRIPTION_TYPE_REMOTE_SIM SubscriptionManager#SUBSCRIPTION_TYPE_REMOTE_SIM}.
 * @return the type of subscription
 
 * Value is {@link android.telephony.SubscriptionManager#SUBSCRIPTION_TYPE_LOCAL_SIM}, or {@link android.telephony.SubscriptionManager#SUBSCRIPTION_TYPE_REMOTE_SIM}
 * @apiSince 29
 */

public int getSubscriptionType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the card ID of the SIM card which contains the subscription (see
 * {@link android.telephony.UiccCardInfo#getCardId() UiccCardInfo#getCardId()}.
 * @return the cardId
 * @apiSince 29
 */

public int getCardId() { throw new RuntimeException("Stub!"); }

/** @apiSince 22 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 22 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 22 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 22 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 22 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 22 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.SubscriptionInfo> CREATOR;
static { CREATOR = null; }
}

