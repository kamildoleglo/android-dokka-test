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


package android.media.midi;


/**
 * This class is used for receiving data from a port on a MIDI device
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MidiOutputPort extends android.media.midi.MidiSender implements java.io.Closeable {

MidiOutputPort() { throw new RuntimeException("Stub!"); }

/**
 * Returns the port number of this port
 *
 * @return the port's port number
 * @apiSince 23
 */

public int getPortNumber() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void onConnect(android.media.midi.MidiReceiver receiver) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void onDisconnect(android.media.midi.MidiReceiver receiver) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
}

