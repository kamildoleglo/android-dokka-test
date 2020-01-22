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

import java.io.IOException;

/**
 * Interface for sending and receiving data to and from a MIDI device.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class MidiReceiver {

/**
 * Default MidiReceiver constructor. Maximum message size is set to
 * {@link java.lang.Integer#MAX_VALUE}
 * @apiSince 23
 */

public MidiReceiver() { throw new RuntimeException("Stub!"); }

/**
 * MidiReceiver constructor.
 * @param maxMessageSize the maximum size of a message this receiver can receive
 * @apiSince 23
 */

public MidiReceiver(int maxMessageSize) { throw new RuntimeException("Stub!"); }

/**
 * Called whenever the receiver is passed new MIDI data.
 * Subclasses override this method to receive MIDI data.
 * May fail if count exceeds {@link #getMaxMessageSize}.
 *
 * NOTE: the msg array parameter is only valid within the context of this call.
 * The msg bytes should be copied by the receiver rather than retaining a reference
 * to this parameter.
 * Also, modifying the contents of the msg array parameter may result in other receivers
 * in the same application receiving incorrect values in their {link #onSend} method.
 *
 * @param msg a byte array containing the MIDI data
 * @param offset the offset of the first byte of the data in the array to be processed
 * @param count the number of bytes of MIDI data in the array to be processed
 * @param timestamp the timestamp of the message (based on {@link java.lang.System#nanoTime}
 * @throws java.io.IOException
 * @apiSince 23
 */

public abstract void onSend(byte[] msg, int offset, int count, long timestamp) throws java.io.IOException;

/**
 * Instructs the receiver to discard all pending MIDI data.
 * @throws java.io.IOException
 * @apiSince 23
 */

public void flush() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Called when the receiver is instructed to discard all pending MIDI data.
 * Subclasses should override this method if they maintain a list or queue of MIDI data
 * to be processed in the future.
 * @throws java.io.IOException
 * @apiSince 23
 */

public void onFlush() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum size of a message this receiver can receive.
 * @return maximum message size
 * @apiSince 23
 */

public final int getMaxMessageSize() { throw new RuntimeException("Stub!"); }

/**
 * Called to send MIDI data to the receiver without a timestamp.
 * Data will be processed by receiver in the order sent.
 * Data will get split into multiple calls to {@link #onSend} if count exceeds
 * {@link #getMaxMessageSize}.  Blocks until all the data is sent or an exception occurs.
 * In the latter case, the amount of data sent prior to the exception is not provided to caller.
 * The communication should be considered corrupt.  The sender should reestablish
 * communication, reset all controllers and send all notes off.
 *
 * @param msg a byte array containing the MIDI data
 * @param offset the offset of the first byte of the data in the array to be sent
 * @param count the number of bytes of MIDI data in the array to be sent
 * @throws java.io.IOException if the data could not be sent in entirety
 * @apiSince 23
 */

public void send(byte[] msg, int offset, int count) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Called to send MIDI data to the receiver with a specified timestamp.
 * Data will be processed by receiver in order first by timestamp, then in the order sent.
 * Data will get split into multiple calls to {@link #onSend} if count exceeds
 * {@link #getMaxMessageSize}.  Blocks until all the data is sent or an exception occurs.
 * In the latter case, the amount of data sent prior to the exception is not provided to caller.
 * The communication should be considered corrupt.  The sender should reestablish
 * communication, reset all controllers and send all notes off.
 *
 * @param msg a byte array containing the MIDI data
 * @param offset the offset of the first byte of the data in the array to be sent
 * @param count the number of bytes of MIDI data in the array to be sent
 * @param timestamp the timestamp of the message, based on {@link java.lang.System#nanoTime}
 * @throws java.io.IOException if the data could not be sent in entirety
 * @apiSince 23
 */

public void send(byte[] msg, int offset, int count, long timestamp) throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

