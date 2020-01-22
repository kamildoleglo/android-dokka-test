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

import android.util.SparseBooleanArray;
import java.util.List;
import java.io.FileDescriptor;
import android.util.SparseArray;
import java.util.Map;
import java.util.Set;
import android.util.ArrayMap;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Container for a message (data and object references) that can
 * be sent through an IBinder.  A Parcel can contain both flattened data
 * that will be unflattened on the other side of the IPC (using the various
 * methods here for writing specific types, or the general
 * {@link android.os.Parcelable Parcelable} interface), and references to live {@link android.os.IBinder IBinder}
 * objects that will result in the other side receiving a proxy IBinder
 * connected with the original IBinder in the Parcel.
 *
 * <p class="note">Parcel is <strong>not</strong> a general-purpose
 * serialization mechanism.  This class (and the corresponding
 * {@link android.os.Parcelable Parcelable} API for placing arbitrary objects into a Parcel) is
 * designed as a high-performance IPC transport.  As such, it is not
 * appropriate to place any Parcel data in to persistent storage: changes
 * in the underlying implementation of any of the data in the Parcel can
 * render older data unreadable.</p>
 *
 * <p>The bulk of the Parcel API revolves around reading and writing data
 * of various types.  There are six major classes of such functions available.</p>
 *
 * <h3>Primitives</h3>
 *
 * <p>The most basic data functions are for writing and reading primitive
 * data types: {@link #writeByte}, {@link #readByte}, {@link #writeDouble},
 * {@link #readDouble}, {@link #writeFloat}, {@link #readFloat}, {@link #writeInt},
 * {@link #readInt}, {@link #writeLong}, {@link #readLong},
 * {@link #writeString}, {@link #readString}.  Most other
 * data operations are built on top of these.  The given data is written and
 * read using the endianess of the host CPU.</p>
 *
 * <h3>Primitive Arrays</h3>
 *
 * <p>There are a variety of methods for reading and writing raw arrays
 * of primitive objects, which generally result in writing a 4-byte length
 * followed by the primitive data items.  The methods for reading can either
 * read the data into an existing array, or create and return a new array.
 * These available types are:</p>
 *
 * <ul>
 * <li> {@link #writeBooleanArray(boolean[])},
 * {@link #readBooleanArray(boolean[])}, {@link #createBooleanArray()}
 * <li> {@link #writeByteArray(byte[])},
 * {@link #writeByteArray(byte[],int,int)}, {@link #readByteArray(byte[])},
 * {@link #createByteArray()}
 * <li> {@link #writeCharArray(char[])}, {@link #readCharArray(char[])},
 * {@link #createCharArray()}
 * <li> {@link #writeDoubleArray(double[])}, {@link #readDoubleArray(double[])},
 * {@link #createDoubleArray()}
 * <li> {@link #writeFloatArray(float[])}, {@link #readFloatArray(float[])},
 * {@link #createFloatArray()}
 * <li> {@link #writeIntArray(int[])}, {@link #readIntArray(int[])},
 * {@link #createIntArray()}
 * <li> {@link #writeLongArray(long[])}, {@link #readLongArray(long[])},
 * {@link #createLongArray()}
 * <li> {@link #writeStringArray(java.lang.String[])}, {@link #readStringArray(java.lang.String[])},
 * {@link #createStringArray()}.
 * <li> {@link #writeSparseBooleanArray(android.util.SparseBooleanArray)},
 * {@link #readSparseBooleanArray()}.
 * </ul>
 *
 * <h3>Parcelables</h3>
 *
 * <p>The {@link android.os.Parcelable Parcelable} protocol provides an extremely efficient (but
 * low-level) protocol for objects to write and read themselves from Parcels.
 * You can use the direct methods {@link #writeParcelable(android.os.Parcelable,int)}
 * and {@link #readParcelable(java.lang.ClassLoader)} or
 * {@link #writeParcelableArray} and
 * {@link #readParcelableArray(java.lang.ClassLoader)} to write or read.  These
 * methods write both the class type and its data to the Parcel, allowing
 * that class to be reconstructed from the appropriate class loader when
 * later reading.</p>
 *
 * <p>There are also some methods that provide a more efficient way to work
 * with Parcelables: {@link #writeTypedObject}, {@link #writeTypedArray},
 * {@link #writeTypedList}, {@link #readTypedObject},
 * {@link #createTypedArray} and {@link #createTypedArrayList}.  These methods
 * do not write the class information of the original object: instead, the
 * caller of the read function must know what type to expect and pass in the
 * appropriate {@link android.os.Parcelable.Creator Parcelable.Creator} instead to
 * properly construct the new object and read its data.  (To more efficient
 * write and read a single Parcelable object that is not null, you can directly
 * call {@link android.os.Parcelable#writeToParcel Parcelable#writeToParcel} and
 * {@link android.os.Parcelable.Creator#createFromParcel Parcelable.Creator#createFromParcel}
 * yourself.)</p>
 *
 * <h3>Bundles</h3>
 *
 * <p>A special type-safe container, called {@link android.os.Bundle Bundle}, is available
 * for key/value maps of heterogeneous values.  This has many optimizations
 * for improved performance when reading and writing data, and its type-safe
 * API avoids difficult to debug type errors when finally marshalling the
 * data contents into a Parcel.  The methods to use are
 * {@link #writeBundle(android.os.Bundle)}, {@link #readBundle()}, and
 * {@link #readBundle(java.lang.ClassLoader)}.
 *
 * <h3>Active Objects</h3>
 *
 * <p>An unusual feature of Parcel is the ability to read and write active
 * objects.  For these objects the actual contents of the object is not
 * written, rather a special token referencing the object is written.  When
 * reading the object back from the Parcel, you do not get a new instance of
 * the object, but rather a handle that operates on the exact same object that
 * was originally written.  There are two forms of active objects available.</p>
 *
 * <p>{@link android.os.Binder Binder} objects are a core facility of Android's general cross-process
 * communication system.  The {@link android.os.IBinder IBinder} interface describes an abstract
 * protocol with a Binder object.  Any such interface can be written in to
 * a Parcel, and upon reading you will receive either the original object
 * implementing that interface or a special proxy implementation
 * that communicates calls back to the original object.  The methods to use are
 * {@link #writeStrongBinder(android.os.IBinder)},
 * {@link #writeStrongInterface(android.os.IInterface)}, {@link #readStrongBinder()},
 * {@link #writeBinderArray(android.os.IBinder[])}, {@link #readBinderArray(android.os.IBinder[])},
 * {@link #createBinderArray()},
 * {@link #writeBinderList(java.util.List)}, {@link #readBinderList(java.util.List)},
 * {@link #createBinderArrayList()}.</p>
 *
 * <p>FileDescriptor objects, representing raw Linux file descriptor identifiers,
 * can be written and {@link android.os.ParcelFileDescriptor ParcelFileDescriptor} objects returned to operate
 * on the original file descriptor.  The returned file descriptor is a dup
 * of the original file descriptor: the object and fd is different, but
 * operating on the same underlying file stream, with the same position, etc.
 * The methods to use are {@link #writeFileDescriptor(java.io.FileDescriptor)},
 * {@link #readFileDescriptor()}.
 *
 * <h3>Untyped Containers</h3>
 *
 * <p>A final class of methods are for writing and reading standard Java
 * containers of arbitrary types.  These all revolve around the
 * {@link #writeValue(java.lang.Object)} and {@link #readValue(java.lang.ClassLoader)} methods
 * which define the types of objects allowed.  The container methods are
 * {@link #writeArray(java.lang.Object[])}, {@link #readArray(java.lang.ClassLoader)},
 * {@link #writeList(java.util.List)}, {@link #readList(java.util.List,java.lang.ClassLoader)},
 * {@link #readArrayList(java.lang.ClassLoader)},
 * {@link #writeMap(java.util.Map)}, {@link #readMap(java.util.Map,java.lang.ClassLoader)},
 * {@link #writeSparseArray(android.util.SparseArray)},
 * {@link #readSparseArray(java.lang.ClassLoader)}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Parcel {

private Parcel() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a new Parcel object from the pool.
 
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static android.os.Parcel obtain() { throw new RuntimeException("Stub!"); }

/**
 * Put a Parcel object back into the pool.  You must not touch
 * the object after this call.
 * @apiSince 1
 */

public void recycle() { throw new RuntimeException("Stub!"); }

/**
 * Returns the total amount of data contained in the parcel.
 * @apiSince 1
 */

public int dataSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the amount of data remaining to be read from the
 * parcel.  That is, {@link #dataSize}-{@link #dataPosition}.
 * @apiSince 1
 */

public int dataAvail() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current position in the parcel data.  Never
 * more than {@link #dataSize}.
 * @apiSince 1
 */

public int dataPosition() { throw new RuntimeException("Stub!"); }

/**
 * Returns the total amount of space in the parcel.  This is always
 * >= {@link #dataSize}.  The difference between it and dataSize() is the
 * amount of room left until the parcel needs to re-allocate its
 * data buffer.
 * @apiSince 1
 */

public int dataCapacity() { throw new RuntimeException("Stub!"); }

/**
 * Change the amount of data in the parcel.  Can be either smaller or
 * larger than the current size.  If larger than the current capacity,
 * more memory will be allocated.
 *
 * @param size The new number of bytes in the Parcel.
 * @apiSince 1
 */

public void setDataSize(int size) { throw new RuntimeException("Stub!"); }

/**
 * Move the current read/write position in the parcel.
 * @param pos New offset in the parcel; must be between 0 and
 * {@link #dataSize}.
 * @apiSince 1
 */

public void setDataPosition(int pos) { throw new RuntimeException("Stub!"); }

/**
 * Change the capacity (current available space) of the parcel.
 *
 * @param size The new capacity of the parcel, in bytes.  Can not be
 * less than {@link #dataSize} -- that is, you can not drop existing data
 * with this method.
 * @apiSince 1
 */

public void setDataCapacity(int size) { throw new RuntimeException("Stub!"); }

/**
 * Returns the raw bytes of the parcel.
 *
 * <p class="note">The data you retrieve here <strong>must not</strong>
 * be placed in any kind of persistent storage (on local disk, across
 * a network, etc).  For that, you should use standard serialization
 * or another kind of general serialization mechanism.  The Parcel
 * marshalled representation is highly optimized for local IPC, and as
 * such does not attempt to maintain compatibility with data created
 * in different versions of the platform.
 * @apiSince 1
 */

public byte[] marshall() { throw new RuntimeException("Stub!"); }

/**
 * Set the bytes in data to be the raw bytes of this Parcel.
 
 * @param data This value must never be {@code null}.
 * @apiSince 1
 */

public void unmarshall(@androidx.annotation.NonNull byte[] data, int offset, int length) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void appendFrom(android.os.Parcel parcel, int offset, int length) { throw new RuntimeException("Stub!"); }

/**
 * Report whether the parcel contains any marshalled file descriptors.
 * @apiSince 1
 */

public boolean hasFileDescriptors() { throw new RuntimeException("Stub!"); }

/**
 * Store or read an IBinder interface token in the parcel at the current
 * {@link #dataPosition}.  This is used to validate that the marshalled
 * transaction is intended for the target interface.
 * @apiSince 1
 */

public void writeInterfaceToken(java.lang.String interfaceName) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void enforceInterface(java.lang.String interfaceName) { throw new RuntimeException("Stub!"); }

/**
 * Write a byte array into the parcel at the current {@link #dataPosition},
 * growing {@link #dataCapacity} if needed.
 * @param b Bytes to place into the parcel.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void writeByteArray(@androidx.annotation.Nullable byte[] b) { throw new RuntimeException("Stub!"); }

/**
 * Write a byte array into the parcel at the current {@link #dataPosition},
 * growing {@link #dataCapacity} if needed.
 * @param b Bytes to place into the parcel.
 * This value may be {@code null}.
 * @param offset Index of first byte to be written.
 * @param len Number of bytes to write.
 * @apiSince 1
 */

public void writeByteArray(@androidx.annotation.Nullable byte[] b, int offset, int len) { throw new RuntimeException("Stub!"); }

/**
 * Write an integer value into the parcel at the current dataPosition(),
 * growing dataCapacity() if needed.
 * @apiSince 1
 */

public void writeInt(int val) { throw new RuntimeException("Stub!"); }

/**
 * Write a long integer value into the parcel at the current dataPosition(),
 * growing dataCapacity() if needed.
 * @apiSince 1
 */

public void writeLong(long val) { throw new RuntimeException("Stub!"); }

/**
 * Write a floating point value into the parcel at the current
 * dataPosition(), growing dataCapacity() if needed.
 * @apiSince 1
 */

public void writeFloat(float val) { throw new RuntimeException("Stub!"); }

/**
 * Write a double precision floating point value into the parcel at the
 * current dataPosition(), growing dataCapacity() if needed.
 * @apiSince 1
 */

public void writeDouble(double val) { throw new RuntimeException("Stub!"); }

/**
 * Write a string value into the parcel at the current dataPosition(),
 * growing dataCapacity() if needed.
 
 * @param val This value may be {@code null}.
 * @apiSince 1
 */

public void writeString(@androidx.annotation.Nullable java.lang.String val) { throw new RuntimeException("Stub!"); }

/**
 * Write a boolean value into the parcel at the current dataPosition(),
 * growing dataCapacity() if needed.
 *
 * <p>Note: This method currently delegates to writeInt with a value of 1 or 0
 * for true or false, respectively, but may change in the future.
 * @apiSince 29
 */

public void writeBoolean(boolean val) { throw new RuntimeException("Stub!"); }

/**
 * Write an object into the parcel at the current dataPosition(),
 * growing dataCapacity() if needed.
 * @apiSince 1
 */

public void writeStrongBinder(android.os.IBinder val) { throw new RuntimeException("Stub!"); }

/**
 * Write an object into the parcel at the current dataPosition(),
 * growing dataCapacity() if needed.
 * @apiSince 1
 */

public void writeStrongInterface(android.os.IInterface val) { throw new RuntimeException("Stub!"); }

/**
 * Write a FileDescriptor into the parcel at the current dataPosition(),
 * growing dataCapacity() if needed.
 *
 * <p class="caution">The file descriptor will not be closed, which may
 * result in file descriptor leaks when objects are returned from Binder
 * calls.  Use {@link android.os.ParcelFileDescriptor#writeToParcel ParcelFileDescriptor#writeToParcel} instead, which
 * accepts contextual flags and will close the original file descriptor
 * if {@link android.os.Parcelable#PARCELABLE_WRITE_RETURN_VALUE Parcelable#PARCELABLE_WRITE_RETURN_VALUE} is set.</p>
 
 * @param val This value must never be {@code null}.
 * @apiSince 1
 */

public void writeFileDescriptor(@androidx.annotation.NonNull java.io.FileDescriptor val) { throw new RuntimeException("Stub!"); }

/**
 * Write a byte value into the parcel at the current dataPosition(),
 * growing dataCapacity() if needed.
 *
 * <p>Note: This method currently delegates to writeInt but may change in
 * the future.
 * @apiSince 1
 */

public void writeByte(byte val) { throw new RuntimeException("Stub!"); }

/**
 * Please use {@link #writeBundle} instead.  Flattens a Map into the parcel
 * at the current dataPosition(),
 * growing dataCapacity() if needed.  The Map keys must be String objects.
 * The Map values are written using {@link #writeValue} and must follow
 * the specification there.
 *
 * <p>It is strongly recommended to use {@link #writeBundle} instead of
 * this method, since the Bundle class provides a type-safe API that
 * allows you to avoid mysterious type errors at the point of marshalling.
 
 * @param val This value may be {@code null}.
 * @apiSince 1
 */

public void writeMap(@androidx.annotation.Nullable java.util.Map val) { throw new RuntimeException("Stub!"); }

/**
 * Flatten an {@link android.util.ArrayMap ArrayMap} with string keys containing a particular object
 * type into the parcel at the current dataPosition() and growing dataCapacity()
 * if needed. The type of the objects in the array must be one that implements
 * Parcelable. Only the raw data of the objects is written and not their type,
 * so you must use the corresponding {@link #createTypedArrayMap(android.os.Parcelable.Creator)}
 *
 * @param val The map of objects to be written.
 * This value may be {@code null}.
 * @param parcelableFlags The parcelable flags to use.
 *
 * @see #createTypedArrayMap(Parcelable.Creator)
 * @see android.os.Parcelable
 * @apiSince 29
 */

public <T extends android.os.Parcelable> void writeTypedArrayMap(@androidx.annotation.Nullable android.util.ArrayMap<java.lang.String,T> val, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/**
 * Flatten a Bundle into the parcel at the current dataPosition(),
 * growing dataCapacity() if needed.
 
 * @param val This value may be {@code null}.
 * @apiSince 1
 */

public void writeBundle(@androidx.annotation.Nullable android.os.Bundle val) { throw new RuntimeException("Stub!"); }

/**
 * Flatten a PersistableBundle into the parcel at the current dataPosition(),
 * growing dataCapacity() if needed.
 
 * @param val This value may be {@code null}.
 * @apiSince 21
 */

public void writePersistableBundle(@androidx.annotation.Nullable android.os.PersistableBundle val) { throw new RuntimeException("Stub!"); }

/**
 * Flatten a Size into the parcel at the current dataPosition(),
 * growing dataCapacity() if needed.
 
 * @param val This value must never be {@code null}.
 * @apiSince 21
 */

public void writeSize(@androidx.annotation.NonNull android.util.Size val) { throw new RuntimeException("Stub!"); }

/**
 * Flatten a SizeF into the parcel at the current dataPosition(),
 * growing dataCapacity() if needed.
 
 * @param val This value must never be {@code null}.
 * @apiSince 21
 */

public void writeSizeF(@androidx.annotation.NonNull android.util.SizeF val) { throw new RuntimeException("Stub!"); }

/**
 * Flatten a List into the parcel at the current dataPosition(), growing
 * dataCapacity() if needed.  The List values are written using
 * {@link #writeValue} and must follow the specification there.
 
 * @param val This value may be {@code null}.
 * @apiSince 1
 */

public void writeList(@androidx.annotation.Nullable java.util.List val) { throw new RuntimeException("Stub!"); }

/**
 * Flatten an Object array into the parcel at the current dataPosition(),
 * growing dataCapacity() if needed.  The array values are written using
 * {@link #writeValue} and must follow the specification there.
 
 * @param val This value may be {@code null}.
 * @apiSince 1
 */

public void writeArray(@androidx.annotation.Nullable java.lang.Object[] val) { throw new RuntimeException("Stub!"); }

/**
 * Flatten a generic SparseArray into the parcel at the current
 * dataPosition(), growing dataCapacity() if needed.  The SparseArray
 * values are written using {@link #writeValue} and must follow the
 * specification there.
 
 * @param val This value may be {@code null}.
 * @apiSince 1
 */

public <T> void writeSparseArray(@androidx.annotation.Nullable android.util.SparseArray<T> val) { throw new RuntimeException("Stub!"); }

/**
 * @param val This value may be {@code null}.
 * @apiSince 1
 */

public void writeSparseBooleanArray(@androidx.annotation.Nullable android.util.SparseBooleanArray val) { throw new RuntimeException("Stub!"); }

/**
 * @param val This value may be {@code null}.
 * @apiSince 1
 */

public void writeBooleanArray(@androidx.annotation.Nullable boolean[] val) { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public boolean[] createBooleanArray() { throw new RuntimeException("Stub!"); }

/**
 * @param val This value must never be {@code null}.
 * @apiSince 1
 */

public void readBooleanArray(@androidx.annotation.NonNull boolean[] val) { throw new RuntimeException("Stub!"); }

/**
 * @param val This value may be {@code null}.
 * @apiSince 1
 */

public void writeCharArray(@androidx.annotation.Nullable char[] val) { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public char[] createCharArray() { throw new RuntimeException("Stub!"); }

/**
 * @param val This value must never be {@code null}.
 * @apiSince 1
 */

public void readCharArray(@androidx.annotation.NonNull char[] val) { throw new RuntimeException("Stub!"); }

/**
 * @param val This value may be {@code null}.
 * @apiSince 1
 */

public void writeIntArray(@androidx.annotation.Nullable int[] val) { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public int[] createIntArray() { throw new RuntimeException("Stub!"); }

/**
 * @param val This value must never be {@code null}.
 * @apiSince 1
 */

public void readIntArray(@androidx.annotation.NonNull int[] val) { throw new RuntimeException("Stub!"); }

/**
 * @param val This value may be {@code null}.
 * @apiSince 1
 */

public void writeLongArray(@androidx.annotation.Nullable long[] val) { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public long[] createLongArray() { throw new RuntimeException("Stub!"); }

/**
 * @param val This value must never be {@code null}.
 * @apiSince 1
 */

public void readLongArray(@androidx.annotation.NonNull long[] val) { throw new RuntimeException("Stub!"); }

/**
 * @param val This value may be {@code null}.
 * @apiSince 1
 */

public void writeFloatArray(@androidx.annotation.Nullable float[] val) { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public float[] createFloatArray() { throw new RuntimeException("Stub!"); }

/**
 * @param val This value must never be {@code null}.
 * @apiSince 1
 */

public void readFloatArray(@androidx.annotation.NonNull float[] val) { throw new RuntimeException("Stub!"); }

/**
 * @param val This value may be {@code null}.
 * @apiSince 1
 */

public void writeDoubleArray(@androidx.annotation.Nullable double[] val) { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public double[] createDoubleArray() { throw new RuntimeException("Stub!"); }

/**
 * @param val This value must never be {@code null}.
 * @apiSince 1
 */

public void readDoubleArray(@androidx.annotation.NonNull double[] val) { throw new RuntimeException("Stub!"); }

/**
 * @param val This value may be {@code null}.
 * @apiSince 1
 */

public void writeStringArray(@androidx.annotation.Nullable java.lang.String[] val) { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String[] createStringArray() { throw new RuntimeException("Stub!"); }

/**
 * @param val This value must never be {@code null}.
 * @apiSince 1
 */

public void readStringArray(@androidx.annotation.NonNull java.lang.String[] val) { throw new RuntimeException("Stub!"); }

/**
 * @param val This value may be {@code null}.
 * @apiSince 1
 */

public void writeBinderArray(@androidx.annotation.Nullable android.os.IBinder[] val) { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.os.IBinder[] createBinderArray() { throw new RuntimeException("Stub!"); }

/**
 * @param val This value must never be {@code null}.
 * @apiSince 1
 */

public void readBinderArray(@androidx.annotation.NonNull android.os.IBinder[] val) { throw new RuntimeException("Stub!"); }

/**
 * Flatten a List containing a particular object type into the parcel, at
 * the current dataPosition() and growing dataCapacity() if needed.  The
 * type of the objects in the list must be one that implements Parcelable.
 * Unlike the generic writeList() method, however, only the raw data of the
 * objects is written and not their type, so you must use the corresponding
 * readTypedList() to unmarshall them.
 *
 * @param val The list of objects to be written.
 *
 * This value may be {@code null}.
 * @see #createTypedArrayList
 * @see #readTypedList
 * @see android.os.Parcelable
 * @apiSince 1
 */

public <T extends android.os.Parcelable> void writeTypedList(@androidx.annotation.Nullable java.util.List<T> val) { throw new RuntimeException("Stub!"); }

/**
 * Flatten a {@link android.util.SparseArray SparseArray} containing a particular object type into the parcel
 * at the current dataPosition() and growing dataCapacity() if needed. The
 * type of the objects in the array must be one that implements Parcelable.
 * Unlike the generic {@link #writeSparseArray(android.util.SparseArray)} method, however, only
 * the raw data of the objects is written and not their type, so you must use the
 * corresponding {@link #createTypedSparseArray(android.os.Parcelable.Creator)}.
 *
 * @param val The list of objects to be written.
 * This value may be {@code null}.
 * @param parcelableFlags The parcelable flags to use.
 *
 * @see #createTypedSparseArray(Parcelable.Creator)
 * @see android.os.Parcelable
 * @apiSince 29
 */

public <T extends android.os.Parcelable> void writeTypedSparseArray(@androidx.annotation.Nullable android.util.SparseArray<T> val, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/**
 * Flatten a List containing String objects into the parcel, at
 * the current dataPosition() and growing dataCapacity() if needed.  They
 * can later be retrieved with {@link #createStringArrayList} or
 * {@link #readStringList}.
 *
 * @param val The list of strings to be written.
 *
 * This value may be {@code null}.
 * @see #createStringArrayList
 * @see #readStringList
 * @apiSince 1
 */

public void writeStringList(@androidx.annotation.Nullable java.util.List<java.lang.String> val) { throw new RuntimeException("Stub!"); }

/**
 * Flatten a List containing IBinder objects into the parcel, at
 * the current dataPosition() and growing dataCapacity() if needed.  They
 * can later be retrieved with {@link #createBinderArrayList} or
 * {@link #readBinderList}.
 *
 * @param val The list of strings to be written.
 *
 * This value may be {@code null}.
 * @see #createBinderArrayList
 * @see #readBinderList
 * @apiSince 1
 */

public void writeBinderList(@androidx.annotation.Nullable java.util.List<android.os.IBinder> val) { throw new RuntimeException("Stub!"); }

/**
 * Flatten a {@code List} containing arbitrary {@code Parcelable} objects into this parcel
 * at the current position. They can later be retrieved using
 * {@link #readParcelableList(java.util.List,java.lang.ClassLoader)} if required.
 *
 * @see #readParcelableList(List, ClassLoader)
 
 * @param val This value may be {@code null}.
 * @apiSince 29
 */

public <T extends android.os.Parcelable> void writeParcelableList(@androidx.annotation.Nullable java.util.List<T> val, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Flatten a homogeneous array containing a particular object type into
 * the parcel, at
 * the current dataPosition() and growing dataCapacity() if needed.  The
 * type of the objects in the array must be one that implements Parcelable.
 * Unlike the {@link #writeParcelableArray} method, however, only the
 * raw data of the objects is written and not their type, so you must use
 * {@link #readTypedArray} with the correct corresponding
 * {@link android.os.Parcelable.Creator Parcelable.Creator} implementation to unmarshall them.
 *
 * @param val The array of objects to be written.
 * This value may be {@code null}.
 * @param parcelableFlags Contextual flags as per
 * {@link android.os.Parcelable#writeToParcel(android.os.Parcel,int) Parcelable#writeToParcel(Parcel, int)}.
 *
 * @see #readTypedArray
 * @see #writeParcelableArray
 * @see android.os.Parcelable.Creator
 * @apiSince 1
 */

public <T extends android.os.Parcelable> void writeTypedArray(@androidx.annotation.Nullable T[] val, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/**
 * Flatten the Parcelable object into the parcel.
 *
 * @param val The Parcelable object to be written.
 * This value may be {@code null}.
 * @param parcelableFlags Contextual flags as per
 * {@link android.os.Parcelable#writeToParcel(android.os.Parcel,int) Parcelable#writeToParcel(Parcel, int)}.
 *
 * @see #readTypedObject
 * @apiSince 23
 */

public <T extends android.os.Parcelable> void writeTypedObject(@androidx.annotation.Nullable T val, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/**
 * Flatten a generic object in to a parcel.  The given Object value may
 * currently be one of the following types:
 *
 * <ul>
 * <li> null
 * <li> String
 * <li> Byte
 * <li> Short
 * <li> Integer
 * <li> Long
 * <li> Float
 * <li> Double
 * <li> Boolean
 * <li> String[]
 * <li> boolean[]
 * <li> byte[]
 * <li> int[]
 * <li> long[]
 * <li> Object[] (supporting objects of the same type defined here).
 * <li> {@link android.os.Bundle Bundle}
 * <li> Map (as supported by {@link #writeMap}).
 * <li> Any object that implements the {@link android.os.Parcelable Parcelable} protocol.
 * <li> Parcelable[]
 * <li> CharSequence (as supported by {@link android.text.TextUtils#writeToParcel TextUtils#writeToParcel}).
 * <li> List (as supported by {@link #writeList}).
 * <li> {@link android.util.SparseArray SparseArray} (as supported by {@link #writeSparseArray(android.util.SparseArray)}).
 * <li> {@link android.os.IBinder IBinder}
 * <li> Any object that implements Serializable (but see
 *      {@link #writeSerializable} for caveats).  Note that all of the
 *      previous types have relatively efficient implementations for
 *      writing to a Parcel; having to rely on the generic serialization
 *      approach is much less efficient and should be avoided whenever
 *      possible.
 * </ul>
 *
 * <p class="caution">{@link android.os.Parcelable Parcelable} objects are written with
 * {@link android.os.Parcelable#writeToParcel Parcelable#writeToParcel} using contextual flags of 0.  When
 * serializing objects containing {@link android.os.ParcelFileDescriptor ParcelFileDescriptor}s,
 * this may result in file descriptor leaks when they are returned from
 * Binder calls (where {@link android.os.Parcelable#PARCELABLE_WRITE_RETURN_VALUE Parcelable#PARCELABLE_WRITE_RETURN_VALUE}
 * should be used).</p>
 
 * @param v This value may be {@code null}.
 * @apiSince 1
 */

public void writeValue(@androidx.annotation.Nullable java.lang.Object v) { throw new RuntimeException("Stub!"); }

/**
 * Flatten the name of the class of the Parcelable and its contents
 * into the parcel.
 *
 * @param p The Parcelable object to be written.
 * This value may be {@code null}.
 * @param parcelableFlags Contextual flags as per
 * {@link android.os.Parcelable#writeToParcel(android.os.Parcel,int) Parcelable#writeToParcel(Parcel, int)}.
 * @apiSince 1
 */

public void writeParcelable(@androidx.annotation.Nullable android.os.Parcelable p, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/**
 * Write a generic serializable object in to a Parcel.  It is strongly
 * recommended that this method be avoided, since the serialization
 * overhead is extremely large, and this approach will be much slower than
 * using the other approaches to writing data in to a Parcel.
 
 * @param s This value may be {@code null}.
 * @apiSince 1
 */

public void writeSerializable(@androidx.annotation.Nullable java.io.Serializable s) { throw new RuntimeException("Stub!"); }

/**
 * Special function for writing an exception result at the header of
 * a parcel, to be used when returning an exception from a transaction.
 * Note that this currently only supports a few exception types; any other
 * exception will be re-thrown by this function as a RuntimeException
 * (to be caught by the system's last-resort exception handling when
 * dispatching a transaction).
 *
 * <p>The supported exception types are:
 * <ul>
 * <li>{@link android.os.BadParcelableException BadParcelableException}
 * <li>{@link java.lang.IllegalArgumentException IllegalArgumentException}
 * <li>{@link java.lang.IllegalStateException IllegalStateException}
 * <li>{@link java.lang.NullPointerException NullPointerException}
 * <li>{@link java.lang.SecurityException SecurityException}
 * <li>{@link java.lang.UnsupportedOperationException UnsupportedOperationException}
 * <li>{@link android.os.NetworkOnMainThreadException NetworkOnMainThreadException}
 * </ul>
 *
 * @param e The Exception to be written.
 *
 * This value must never be {@code null}.
 * @see #writeNoException
 * @see #readException
 * @apiSince 1
 */

public void writeException(@androidx.annotation.NonNull java.lang.Exception e) { throw new RuntimeException("Stub!"); }

/**
 * Special function for writing information at the front of the Parcel
 * indicating that no exception occurred.
 *
 * @see #writeException
 * @see #readException
 * @apiSince 1
 */

public void writeNoException() { throw new RuntimeException("Stub!"); }

/**
 * Special function for reading an exception result from the header of
 * a parcel, to be used after receiving the result of a transaction.  This
 * will throw the exception for you if it had been written to the Parcel,
 * otherwise return and let you read the normal result data from the Parcel.
 *
 * @see #writeException
 * @see #writeNoException
 * @apiSince 1
 */

public void readException() { throw new RuntimeException("Stub!"); }

/**
 * Throw an exception with the given message. Not intended for use
 * outside the Parcel class.
 *
 * @param code Used to determine which exception class to throw.
 * @param msg The exception message.
 * @apiSince 1
 */

public void readException(int code, java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Read an integer value from the parcel at the current dataPosition().
 * @apiSince 1
 */

public int readInt() { throw new RuntimeException("Stub!"); }

/**
 * Read a long integer value from the parcel at the current dataPosition().
 * @apiSince 1
 */

public long readLong() { throw new RuntimeException("Stub!"); }

/**
 * Read a floating point value from the parcel at the current
 * dataPosition().
 * @apiSince 1
 */

public float readFloat() { throw new RuntimeException("Stub!"); }

/**
 * Read a double precision floating point value from the parcel at the
 * current dataPosition().
 * @apiSince 1
 */

public double readDouble() { throw new RuntimeException("Stub!"); }

/**
 * Read a string value from the parcel at the current dataPosition().
 
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String readString() { throw new RuntimeException("Stub!"); }

/**
 * Read a boolean value from the parcel at the current dataPosition().
 * @apiSince 29
 */

public boolean readBoolean() { throw new RuntimeException("Stub!"); }

/**
 * Read an object from the parcel at the current dataPosition().
 * @apiSince 1
 */

public android.os.IBinder readStrongBinder() { throw new RuntimeException("Stub!"); }

/**
 * Read a FileDescriptor from the parcel at the current dataPosition().
 * @apiSince 1
 */

public android.os.ParcelFileDescriptor readFileDescriptor() { throw new RuntimeException("Stub!"); }

/**
 * Read a byte value from the parcel at the current dataPosition().
 * @apiSince 1
 */

public byte readByte() { throw new RuntimeException("Stub!"); }

/**
 * Please use {@link #readBundle(java.lang.ClassLoader)} instead (whose data must have
 * been written with {@link #writeBundle}.  Read into an existing Map object
 * from the parcel at the current dataPosition().
 
 * @param outVal This value must never be {@code null}.
 
 * @param loader This value may be {@code null}.
 * @apiSince 1
 */

public void readMap(@androidx.annotation.NonNull java.util.Map outVal, @androidx.annotation.Nullable java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/**
 * Read into an existing List object from the parcel at the current
 * dataPosition(), using the given class loader to load any enclosed
 * Parcelables.  If it is null, the default class loader is used.
 
 * @param outVal This value must never be {@code null}.
 
 * @param loader This value may be {@code null}.
 * @apiSince 1
 */

public void readList(@androidx.annotation.NonNull java.util.List outVal, @androidx.annotation.Nullable java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/**
 * Please use {@link #readBundle(java.lang.ClassLoader)} instead (whose data must have
 * been written with {@link #writeBundle}.  Read and return a new HashMap
 * object from the parcel at the current dataPosition(), using the given
 * class loader to load any enclosed Parcelables.  Returns null if
 * the previously written map object was null.
 
 * @param loader This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.util.HashMap readHashMap(@androidx.annotation.Nullable java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/**
 * Read and return a new Bundle object from the parcel at the current
 * dataPosition().  Returns null if the previously written Bundle object was
 * null.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.os.Bundle readBundle() { throw new RuntimeException("Stub!"); }

/**
 * Read and return a new Bundle object from the parcel at the current
 * dataPosition(), using the given class loader to initialize the class
 * loader of the Bundle for later retrieval of Parcelable objects.
 * Returns null if the previously written Bundle object was null.
 
 * @param loader This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.os.Bundle readBundle(@androidx.annotation.Nullable java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/**
 * Read and return a new Bundle object from the parcel at the current
 * dataPosition().  Returns null if the previously written Bundle object was
 * null.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.os.PersistableBundle readPersistableBundle() { throw new RuntimeException("Stub!"); }

/**
 * Read and return a new Bundle object from the parcel at the current
 * dataPosition(), using the given class loader to initialize the class
 * loader of the Bundle for later retrieval of Parcelable objects.
 * Returns null if the previously written Bundle object was null.
 
 * @param loader This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.os.PersistableBundle readPersistableBundle(@androidx.annotation.Nullable java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/**
 * Read a Size from the parcel at the current dataPosition().
 
 * @return This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.util.Size readSize() { throw new RuntimeException("Stub!"); }

/**
 * Read a SizeF from the parcel at the current dataPosition().
 
 * @return This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.util.SizeF readSizeF() { throw new RuntimeException("Stub!"); }

/**
 * Read and return a byte[] object from the parcel.
 
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public byte[] createByteArray() { throw new RuntimeException("Stub!"); }

/**
 * Read a byte[] object from the parcel and copy it into the
 * given byte array.
 
 * @param val This value must never be {@code null}.
 * @apiSince 1
 */

public void readByteArray(@androidx.annotation.NonNull byte[] val) { throw new RuntimeException("Stub!"); }

/**
 * Read and return a new ArrayList object from the parcel at the current
 * dataPosition().  Returns null if the previously written list object was
 * null.  The given class loader will be used to load any enclosed
 * Parcelables.
 
 * @param loader This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.util.ArrayList readArrayList(@androidx.annotation.Nullable java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/**
 * Read and return a new Object array from the parcel at the current
 * dataPosition().  Returns null if the previously written array was
 * null.  The given class loader will be used to load any enclosed
 * Parcelables.
 
 * @param loader This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.Object[] readArray(@androidx.annotation.Nullable java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/**
 * Read and return a new SparseArray object from the parcel at the current
 * dataPosition().  Returns null if the previously written list object was
 * null.  The given class loader will be used to load any enclosed
 * Parcelables.
 
 * @param loader This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public <T> android.util.SparseArray<T> readSparseArray(@androidx.annotation.Nullable java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/**
 * Read and return a new SparseBooleanArray object from the parcel at the current
 * dataPosition().  Returns null if the previously written list object was
 * null.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.util.SparseBooleanArray readSparseBooleanArray() { throw new RuntimeException("Stub!"); }

/**
 * Read and return a new ArrayList containing a particular object type from
 * the parcel that was written with {@link #writeTypedList} at the
 * current dataPosition().  Returns null if the
 * previously written list object was null.  The list <em>must</em> have
 * previously been written via {@link #writeTypedList} with the same object
 * type.
 *
 * @param c This value must never be {@code null}.
 * @return A newly created ArrayList containing objects with the same data
 *         as those that were previously written.
 *
 * @see #writeTypedList
 * @apiSince 1
 */

@androidx.annotation.Nullable
public <T> java.util.ArrayList<T> createTypedArrayList(@androidx.annotation.NonNull android.os.Parcelable.Creator<T> c) { throw new RuntimeException("Stub!"); }

/**
 * Read into the given List items containing a particular object type
 * that were written with {@link #writeTypedList} at the
 * current dataPosition().  The list <em>must</em> have
 * previously been written via {@link #writeTypedList} with the same object
 * type.
 *
 * @param list This value must never be {@code null}.
 * @param c This value must never be {@code null}.
 * @return A newly created ArrayList containing objects with the same data
 *         as those that were previously written.
 *
 * @see #writeTypedList
 * @apiSince 1
 */

public <T> void readTypedList(@androidx.annotation.NonNull java.util.List<T> list, @androidx.annotation.NonNull android.os.Parcelable.Creator<T> c) { throw new RuntimeException("Stub!"); }

/**
 * Read into a new {@link android.util.SparseArray SparseArray} items containing a particular object type
 * that were written with {@link #writeTypedSparseArray(android.util.SparseArray,int)} at the
 * current dataPosition().  The list <em>must</em> have previously been written
 * via {@link #writeTypedSparseArray(android.util.SparseArray,int)} with the same object type.
 *
 * @param creator The creator to use when for instantiation.
 *
 * This value must never be {@code null}.
 * @return A newly created {@link android.util.SparseArray SparseArray} containing objects with the same data
 *         as those that were previously written.
 *
 * This value may be {@code null}.
 * @see #writeTypedSparseArray(SparseArray, int)
 * @apiSince 29
 */

@androidx.annotation.Nullable
public <T extends android.os.Parcelable> android.util.SparseArray<T> createTypedSparseArray(@androidx.annotation.NonNull android.os.Parcelable.Creator<T> creator) { throw new RuntimeException("Stub!"); }

/**
 * Read into a new {@link android.util.ArrayMap ArrayMap} with string keys items containing a particular
 * object type that were written with {@link #writeTypedArrayMap(android.util.ArrayMap,int)} at the
 * current dataPosition().  The list <em>must</em> have previously been written
 * via {@link #writeTypedArrayMap(android.util.ArrayMap,int)} with the same object type.
 *
 * @param creator The creator to use when for instantiation.
 *
 * This value must never be {@code null}.
 * @return A newly created {@link android.util.ArrayMap ArrayMap} containing objects with the same data
 *         as those that were previously written.
 *
 * This value may be {@code null}.
 * @see #writeTypedArrayMap(ArrayMap, int)
 * @apiSince 29
 */

@androidx.annotation.Nullable
public <T extends android.os.Parcelable> android.util.ArrayMap<java.lang.String,T> createTypedArrayMap(@androidx.annotation.NonNull android.os.Parcelable.Creator<T> creator) { throw new RuntimeException("Stub!"); }

/**
 * Read and return a new ArrayList containing String objects from
 * the parcel that was written with {@link #writeStringList} at the
 * current dataPosition().  Returns null if the
 * previously written list object was null.
 *
 * @return A newly created ArrayList containing strings with the same data
 *         as those that were previously written.
 *
 * @see #writeStringList
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.util.ArrayList<java.lang.String> createStringArrayList() { throw new RuntimeException("Stub!"); }

/**
 * Read and return a new ArrayList containing IBinder objects from
 * the parcel that was written with {@link #writeBinderList} at the
 * current dataPosition().  Returns null if the
 * previously written list object was null.
 *
 * @return A newly created ArrayList containing strings with the same data
 *         as those that were previously written.
 *
 * @see #writeBinderList
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.util.ArrayList<android.os.IBinder> createBinderArrayList() { throw new RuntimeException("Stub!"); }

/**
 * Read into the given List items String objects that were written with
 * {@link #writeStringList} at the current dataPosition().
 *
 * @see #writeStringList
 
 * @param list This value must never be {@code null}.
 * @apiSince 1
 */

public void readStringList(@androidx.annotation.NonNull java.util.List<java.lang.String> list) { throw new RuntimeException("Stub!"); }

/**
 * Read into the given List items IBinder objects that were written with
 * {@link #writeBinderList} at the current dataPosition().
 *
 * @see #writeBinderList
 
 * @param list This value must never be {@code null}.
 * @apiSince 1
 */

public void readBinderList(@androidx.annotation.NonNull java.util.List<android.os.IBinder> list) { throw new RuntimeException("Stub!"); }

/**
 * Read the list of {@code Parcelable} objects at the current data position into the
 * given {@code list}. The contents of the {@code list} are replaced. If the serialized
 * list was {@code null}, {@code list} is cleared.
 *
 * @see #writeParcelableList(List, int)
 
 * @param list This value must never be {@code null}.
 
 * @param cl This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public <T extends android.os.Parcelable> java.util.List<T> readParcelableList(@androidx.annotation.NonNull java.util.List<T> list, @androidx.annotation.Nullable java.lang.ClassLoader cl) { throw new RuntimeException("Stub!"); }

/**
 * Read and return a new array containing a particular object type from
 * the parcel at the current dataPosition().  Returns null if the
 * previously written array was null.  The array <em>must</em> have
 * previously been written via {@link #writeTypedArray} with the same
 * object type.
 *
 * @param c This value must never be {@code null}.
 * @return A newly created array containing objects with the same data
 *         as those that were previously written.
 *
 * @see #writeTypedArray
 * @apiSince 1
 */

@androidx.annotation.Nullable
public <T> T[] createTypedArray(@androidx.annotation.NonNull android.os.Parcelable.Creator<T> c) { throw new RuntimeException("Stub!"); }

/**
 * @param val This value must never be {@code null}.
 
 * @param c This value must never be {@code null}.
 * @apiSince 1
 */

public <T> void readTypedArray(@androidx.annotation.NonNull T[] val, @androidx.annotation.NonNull android.os.Parcelable.Creator<T> c) { throw new RuntimeException("Stub!"); }

/**
 * Read and return a typed Parcelable object from a parcel.
 * Returns null if the previous written object was null.
 * The object <em>must</em> have previous been written via
 * {@link #writeTypedObject} with the same object type.
 *
 * @param c This value must never be {@code null}.
 * @return A newly created object of the type that was previously
 *         written.
 *
 * @see #writeTypedObject
 * @apiSince 23
 */

@androidx.annotation.Nullable
public <T> T readTypedObject(@androidx.annotation.NonNull android.os.Parcelable.Creator<T> c) { throw new RuntimeException("Stub!"); }

/**
 * Write a heterogeneous array of Parcelable objects into the Parcel.
 * Each object in the array is written along with its class name, so
 * that the correct class can later be instantiated.  As a result, this
 * has significantly more overhead than {@link #writeTypedArray}, but will
 * correctly handle an array containing more than one type of object.
 *
 * @param value The array of objects to be written.
 * This value may be {@code null}.
 * @param parcelableFlags Contextual flags as per
 * {@link android.os.Parcelable#writeToParcel(android.os.Parcel,int) Parcelable#writeToParcel(Parcel, int)}.
 *
 * @see #writeTypedArray
 * @apiSince 1
 */

public <T extends android.os.Parcelable> void writeParcelableArray(@androidx.annotation.Nullable T[] value, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/**
 * Read a typed object from a parcel.  The given class loader will be
 * used to load any enclosed Parcelables.  If it is null, the default class
 * loader will be used.
 
 * @param loader This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.Object readValue(@androidx.annotation.Nullable java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/**
 * Read and return a new Parcelable from the parcel.  The given class loader
 * will be used to load any enclosed Parcelables.  If it is null, the default
 * class loader will be used.
 * @param loader A ClassLoader from which to instantiate the Parcelable
 * object, or null for the default class loader.
 * This value may be {@code null}.
 * @return Returns the newly created Parcelable, or null if a null
 * object has been written.
 * @throws android.os.BadParcelableException Throws BadParcelableException if there
 * was an error trying to instantiate the Parcelable.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public <T extends android.os.Parcelable> T readParcelable(@androidx.annotation.Nullable java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/**
 * Read and return a new Parcelable array from the parcel.
 * The given class loader will be used to load any enclosed
 * Parcelables.
 * @param loader This value may be {@code null}.
 * @return the Parcelable array, or null if the array is null
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.os.Parcelable[] readParcelableArray(@androidx.annotation.Nullable java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/**
 * Read and return a new Serializable object from the parcel.
 * @return the Serializable object, or null if the Serializable name
 * wasn't found in the parcel.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.io.Serializable readSerializable() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static final android.os.Parcelable.Creator<java.lang.String> STRING_CREATOR;
static { STRING_CREATOR = null; }
}

