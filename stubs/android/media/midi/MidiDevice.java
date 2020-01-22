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
 * This class is used for sending and receiving data to and from a MIDI device
 * Instances of this class are created by {@link android.media.midi.MidiManager#openDevice MidiManager#openDevice}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MidiDevice implements java.io.Closeable {

MidiDevice() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.media.midi.MidiDeviceInfo MidiDeviceInfo} object, which describes this device.
 *
 * @return the {@link android.media.midi.MidiDeviceInfo MidiDeviceInfo} object
 * @apiSince 23
 */

public android.media.midi.MidiDeviceInfo getInfo() { throw new RuntimeException("Stub!"); }

/**
 * Called to open a {@link android.media.midi.MidiInputPort MidiInputPort} for the specified port number.
 *
 * An input port can only be used by one sender at a time.
 * Opening an input port will fail if another application has already opened it for use.
 * A {@link android.media.midi.MidiDeviceStatus MidiDeviceStatus} can be used to determine if an input port is already open.
 *
 * @param portNumber the number of the input port to open
 * @return the {@link android.media.midi.MidiInputPort MidiInputPort} if the open is successful,
 *         or null in case of failure.
 * @apiSince 23
 */

public android.media.midi.MidiInputPort openInputPort(int portNumber) { throw new RuntimeException("Stub!"); }

/**
 * Called to open a {@link android.media.midi.MidiOutputPort MidiOutputPort} for the specified port number.
 *
 * An output port may be opened by multiple applications.
 *
 * @param portNumber the number of the output port to open
 * @return the {@link android.media.midi.MidiOutputPort MidiOutputPort} if the open is successful,
 *         or null in case of failure.
 * @apiSince 23
 */

public android.media.midi.MidiOutputPort openOutputPort(int portNumber) { throw new RuntimeException("Stub!"); }

/**
 * Connects the supplied {@link android.media.midi.MidiInputPort MidiInputPort} to the output port of this device
 * with the specified port number. Once the connection is made, the MidiInput port instance
 * can no longer receive data via its {@link android.media.midi.MidiReceiver#onSend MidiReceiver#onSend} method.
 * This method returns a {@link android.media.midi.MidiDevice.MidiConnection MidiDevice.MidiConnection} object, which can be used
 * to close the connection.
 *
 * @param inputPort the inputPort to connect
 * @param outputPortNumber the port number of the output port to connect inputPort to.
 * @return {@link android.media.midi.MidiDevice.MidiConnection MidiDevice.MidiConnection} object if the connection is successful,
 *         or null in case of failure.
 * @apiSince 23
 */

public android.media.midi.MidiDevice.MidiConnection connectPorts(android.media.midi.MidiInputPort inputPort, int outputPortNumber) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
/**
 * This class represents a connection between the output port of one device
 * and the input port of another. Created by {@link #connectPorts}.
 * Close this object to terminate the connection.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MidiConnection implements java.io.Closeable {

MidiConnection() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
}

}

