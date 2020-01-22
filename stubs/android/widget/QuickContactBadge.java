/*
 * Copyright (C) 2009 The Android Open Source Project
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


package android.widget;

import android.provider.ContactsContract.QuickContact;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Intents;

/**
 * Widget used to show an image with the standard QuickContact badge
 * and on-click behavior.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class QuickContactBadge extends android.widget.ImageView implements android.view.View.OnClickListener {

/** @apiSince 5 */

public QuickContactBadge(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public QuickContactBadge(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public QuickContactBadge(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public QuickContactBadge(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

protected void drawableStateChanged() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void drawableHotspotChanged(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * This call has no effect anymore, as there is only one QuickContact mode
 * @apiSince 5
 */

public void setMode(int size) { throw new RuntimeException("Stub!"); }

/**
 * Set which mimetype should be prioritized in the QuickContacts UI. For example, passing the
 * value {@link android.provider.ContactsContract.CommonDataKinds.Email#CONTENT_ITEM_TYPE Email#CONTENT_ITEM_TYPE} can cause emails to be displayed more prominently in
 * QuickContacts.
 * @apiSince 23
 */

public void setPrioritizedMimeType(java.lang.String prioritizedMimeType) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

protected void onDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Resets the contact photo to the default state.
 * @apiSince 11
 */

public void setImageToDefault() { throw new RuntimeException("Stub!"); }

/**
 * Assign the contact uri that this QuickContactBadge should be associated
 * with. Note that this is only used for displaying the QuickContact window and
 * won't bind the contact's photo for you. Call {@link #setImageDrawable(android.graphics.drawable.Drawable)} to set the
 * photo.
 *
 * @param contactUri Either a {@link android.provider.ContactsContract.Contacts#CONTENT_URI Contacts#CONTENT_URI} or
 *            {@link android.provider.ContactsContract.Contacts#CONTENT_LOOKUP_URI Contacts#CONTENT_LOOKUP_URI} style URI.
 * @apiSince 5
 */

public void assignContactUri(android.net.Uri contactUri) { throw new RuntimeException("Stub!"); }

/**
 * Assign a contact based on an email address. This should only be used when
 * the contact's URI is not available, as an extra query will have to be
 * performed to lookup the URI based on the email.
 *
 * @param emailAddress The email address of the contact.
 * @param lazyLookup If this is true, the lookup query will not be performed
 * until this view is clicked.
 * @apiSince 5
 */

public void assignContactFromEmail(java.lang.String emailAddress, boolean lazyLookup) { throw new RuntimeException("Stub!"); }

/**
 * Assign a contact based on an email address. This should only be used when
 * the contact's URI is not available, as an extra query will have to be
 * performed to lookup the URI based on the email.
 
 @param emailAddress The email address of the contact.
 @param lazyLookup If this is true, the lookup query will not be performed
 until this view is clicked.
 @param extras A bundle of extras to populate the contact edit page with if the contact
 is not found and the user chooses to add the email address to an existing contact or
 create a new contact. Uses the same string constants as those found in
 {@link android.provider.ContactsContract.Intents.Insert}
 * @apiSince 18
 */

public void assignContactFromEmail(java.lang.String emailAddress, boolean lazyLookup, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Assign a contact based on a phone number. This should only be used when
 * the contact's URI is not available, as an extra query will have to be
 * performed to lookup the URI based on the phone number.
 *
 * @param phoneNumber The phone number of the contact.
 * @param lazyLookup If this is true, the lookup query will not be performed
 * until this view is clicked.
 * @apiSince 5
 */

public void assignContactFromPhone(java.lang.String phoneNumber, boolean lazyLookup) { throw new RuntimeException("Stub!"); }

/**
 * Assign a contact based on a phone number. This should only be used when
 * the contact's URI is not available, as an extra query will have to be
 * performed to lookup the URI based on the phone number.
 *
 * @param phoneNumber The phone number of the contact.
 * @param lazyLookup If this is true, the lookup query will not be performed
 * until this view is clicked.
 * @param extras A bundle of extras to populate the contact edit page with if the contact
 * is not found and the user chooses to add the phone number to an existing contact or
 * create a new contact. Uses the same string constants as those found in
 * {@link android.provider.ContactsContract.Intents.Insert}
 * @apiSince 18
 */

public void assignContactFromPhone(java.lang.String phoneNumber, boolean lazyLookup, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the drawable that is to be drawn on top of the assigned contact photo.
 *
 * @param overlay Drawable to be drawn over the assigned contact photo. Must have a non-zero
 *         instrinsic width and height.
 * @apiSince 21
 */

public void setOverlay(android.graphics.drawable.Drawable overlay) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void onClick(android.view.View v) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/**
 * Set a list of specific MIME-types to exclude and not display. For
 * example, this can be used to hide the {@link android.provider.ContactsContract.Contacts#CONTENT_ITEM_TYPE Contacts#CONTENT_ITEM_TYPE}
 * profile icon.
 * @apiSince 5
 */

public void setExcludeMimes(java.lang.String[] excludeMimes) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

protected java.lang.String[] mExcludeMimes;
}

