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


package android.os;


/**
 * Reference to a Handler, which others can use to send messages to it.
 * This allows for the implementation of message-based communication across
 * processes, by creating a Messenger pointing to a Handler in one process,
 * and handing that Messenger to another process.
 *
 * <p>Note: the implementation underneath is just a simple wrapper around
 * a {@link android.os.Binder Binder} that is used to perform the communication.  This means
 * semantically you should treat it as such: this class does not impact process
 * lifecycle management (you must be using some higher-level component to tell
 * the system that your process needs to continue running), the connection will
 * break if your process goes away for any reason, etc.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Messenger implements android.os.Parcelable {

/**
 * Create a new Messenger pointing to the given Handler.  Any Message
 * objects sent through this Messenger will appear in the Handler as if
 * {@link android.os.Handler#sendMessage(android.os.Message) Handler#sendMessage(Message)} had
 * been called directly.
 *
 * @param target The Handler that will receive sent messages.
 * @apiSince 1
 */

public Messenger(android.os.Handler target) { throw new RuntimeException("Stub!"); }

/**
 * Create a Messenger from a raw IBinder, which had previously been
 * retrieved with {@link #getBinder}.
 *
 * @param target The IBinder this Messenger should communicate with.
 * @apiSince 1
 */

public Messenger(android.os.IBinder target) { throw new RuntimeException("Stub!"); }

/**
 * Send a Message to this Messenger's Handler.
 *
 * @param message The Message to send.  Usually retrieved through
 * {@link android.os.Message#obtain() Message#obtain()}.
 *
 * @throws android.os.RemoteException Throws DeadObjectException if the target
 * Handler no longer exists.
 * @apiSince 1
 */

public void send(android.os.Message message) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the IBinder that this Messenger is using to communicate with
 * its associated Handler.
 *
 * @return Returns the IBinder backing this Messenger.
 * @apiSince 1
 */

public android.os.IBinder getBinder() { throw new RuntimeException("Stub!"); }

/**
 * Comparison operator on two Messenger objects, such that true
 * is returned then they both point to the same Handler.
 * @apiSince 1
 */

public boolean equals(java.lang.Object otherObj) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for writing either a Messenger or null pointer to
 * a Parcel.  You must use this with {@link #readMessengerOrNullFromParcel}
 * for later reading it.
 *
 * @param messenger The Messenger to write, or null.
 * @param out Where to write the Messenger.
 * @apiSince 1
 */

public static void writeMessengerOrNullToParcel(android.os.Messenger messenger, android.os.Parcel out) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for reading either a Messenger or null pointer from
 * a Parcel.  You must have previously written the Messenger with
 * {@link #writeMessengerOrNullToParcel}.
 *
 * @param in The Parcel containing the written Messenger.
 *
 * @return Returns the Messenger read from the Parcel, or null if null had
 * been written.
 * @apiSince 1
 */

public static android.os.Messenger readMessengerOrNullFromParcel(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.os.Messenger> CREATOR;
static { CREATOR = null; }
}

