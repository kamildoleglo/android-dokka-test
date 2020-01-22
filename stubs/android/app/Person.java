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


package android.app;

import android.os.Parcelable;

/**
 * Provides an immutable reference to an entity that appears repeatedly on different surfaces of the
 * platform. For example, this could represent the sender of a message.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Person implements android.os.Parcelable {

private Person() { throw new RuntimeException("Stub!"); }

/**
 * Creates and returns a new {@link android.app.Person.Builder Builder} initialized with this Person's data.
 * @apiSince 28
 */

public android.app.Person.Builder toBuilder() { throw new RuntimeException("Stub!"); }

/**
 * @return the uri provided for this person or {@code null} if no Uri was provided.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getUri() { throw new RuntimeException("Stub!"); }

/**
 * @return the name provided for this person or {@code null} if no name was provided.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getName() { throw new RuntimeException("Stub!"); }

/**
 * @return the icon provided for this person or {@code null} if no icon was provided.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Icon getIcon() { throw new RuntimeException("Stub!"); }

/**
 * @return the key provided for this person or {@code null} if no key was provided.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getKey() { throw new RuntimeException("Stub!"); }

/**
 * @return whether this Person is a machine.
 * @apiSince 28
 */

public boolean isBot() { throw new RuntimeException("Stub!"); }

/**
 * @return whether this Person is important.
 * @apiSince 28
 */

public boolean isImportant() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param flags Value is either <code>0</code> or a combination of {@link android.os.Parcelable#PARCELABLE_WRITE_RETURN_VALUE}, and android.os.Parcelable.PARCELABLE_ELIDE_DUPLICATES
 * @apiSince 28
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.Person> CREATOR;
static { CREATOR = null; }
/**
 * Builder for the immutable {@link android.app.Person Person} class.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Creates a new, empty {@link android.app.Person.Builder Builder}.
 * @apiSince 28
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Give this person a name.
 *
 * @param name the name of this person.
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.app.Person.Builder setName(@androidx.annotation.Nullable java.lang.CharSequence name) { throw new RuntimeException("Stub!"); }

/**
 * Add an icon for this person.
 * <br />
 * The system will prefer this icon over any images that are resolved from the URI.
 *
 * @param icon the icon of the person.
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.app.Person.Builder setIcon(@androidx.annotation.Nullable android.graphics.drawable.Icon icon) { throw new RuntimeException("Stub!"); }

/**
 * Set a URI associated with this person.
 *
 * <P>
 * The person should be specified by the {@code String} representation of a
 * {@link android.provider.ContactsContract.Contacts#CONTENT_LOOKUP_URI}.
 * </P>
 *
 * <P>The system will also attempt to resolve {@code mailto:} and {@code tel:} schema
 * URIs. The path part of these URIs must exist in the contacts database, in the
 * appropriate column, or the reference will be discarded as invalid. Telephone schema
 * URIs will be resolved by {@link android.provider.ContactsContract.PhoneLookup}.
 * </P>
 *
 * @param uri a URI for the person.
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.app.Person.Builder setUri(@androidx.annotation.Nullable java.lang.String uri) { throw new RuntimeException("Stub!"); }

/**
 * Add a key to this person in order to uniquely identify it.
 * This is especially useful if the name doesn't uniquely identify this person or if the
 * display name is a short handle of the actual name.
 *
 * <P>If no key is provided, the name serves as the key for the purpose of
 * identification.</P>
 *
 * @param key the key that uniquely identifies this person.
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.app.Person.Builder setKey(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this is an important person. Use this method to denote users who frequently
 * interact with the user of this device when {@link #setUri(java.lang.String)} isn't provided with
 * {@link android.provider.ContactsContract.Contacts#CONTENT_LOOKUP_URI}, and instead with
 * the {@code mailto:} or {@code tel:} schemas.
 *
 * @param isImportant {@code true} if this is an important person, {@code false} otherwise.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.app.Person.Builder setImportant(boolean isImportant) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this person is a machine rather than a human.
 *
 * @param isBot {@code true} if this person is a machine, {@code false} otherwise.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.app.Person.Builder setBot(boolean isBot) { throw new RuntimeException("Stub!"); }

/**
 * Creates and returns the {@link android.app.Person Person} this builder represents.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.app.Person build() { throw new RuntimeException("Stub!"); }
}

}

