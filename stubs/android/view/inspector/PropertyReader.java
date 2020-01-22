/*
 * Copyright 2018 The Android Open Source Project
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


package android.view.inspector;

import android.graphics.Color;

/**
 * An interface for reading the properties of an inspectable object.
 *
 * {@code PropertyReader} is defined as an interface that will be called by
 * {@link android.view.inspector.InspectionCompanion#readProperties(java.lang.Object,android.view.inspector.PropertyReader) InspectionCompanion#readProperties(Object, PropertyReader)}. This approach allows a
 * client inspector to read the values of primitive properties without the overhead of
 * instantiating a class to hold the property values for each inspection pass. If an inspectable
 * remains unchanged between reading passes, it should be possible for a {@code PropertyReader} to
 * avoid new allocations for subsequent reading passes.
 *
 * It has separate methods for all primitive types to avoid autoboxing overhead if a concrete
 * implementation is able to work with primitives. Implementations should be prepared to accept
 * {null} as the value of {@link android.view.inspector.PropertyReader#readObject(int,java.lang.Object) PropertyReader#readObject(int, Object)}.
 *
 * @see android.view.inspector.InspectionCompanion#readProperties(Object, PropertyReader)
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface PropertyReader {

/**
 * Read a primitive boolean property.
 *
 * @param id Identifier of the property from a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * @param value Value of the property
 * @throws android.view.inspector.PropertyReader.PropertyTypeMismatchException If the property ID is not mapped as a {@code boolean}
 * @apiSince 29
 */

public void readBoolean(int id, boolean value);

/**
 * Read a primitive byte property.
 *
 * @param id Identifier of the property from a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * @param value Value of the property
 * @throws android.view.inspector.PropertyReader.PropertyTypeMismatchException If the property ID is not mapped as a {@code byte}
 * @apiSince 29
 */

public void readByte(int id, byte value);

/**
 * Read a primitive character property.
 *
 * @param id Identifier of the property from a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * @param value Value of the property
 * @throws android.view.inspector.PropertyReader.PropertyTypeMismatchException If the property ID is not mapped as a {@code char}
 * @apiSince 29
 */

public void readChar(int id, char value);

/**
 * Read a read a primitive double property.
 *
 * @param id Identifier of the property from a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * @param value Value of the property
 * @throws android.view.inspector.PropertyReader.PropertyTypeMismatchException If the property ID is not mapped as a {@code double}
 * @apiSince 29
 */

public void readDouble(int id, double value);

/**
 * Read a primitive float property.
 *
 * @param id Identifier of the property from a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * @param value Value of the property
 * @throws android.view.inspector.PropertyReader.PropertyTypeMismatchException If the property ID is not mapped as a {@code float}
 * @apiSince 29
 */

public void readFloat(int id, float value);

/**
 * Read a primitive integer property.
 *
 * @param id Identifier of the property from a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * @param value Value of the property
 * @throws android.view.inspector.PropertyReader.PropertyTypeMismatchException If the property ID is not mapped as an {@code int}
 * @apiSince 29
 */

public void readInt(int id, int value);

/**
 * Read a primitive long property.
 *
 * @param id Identifier of the property from a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * @param value Value of the property
 * @throws android.view.inspector.PropertyReader.PropertyTypeMismatchException If the property ID is not mapped as a {@code long}
 * @apiSince 29
 */

public void readLong(int id, long value);

/**
 * Read a primitive short property.
 *
 * @param id Identifier of the property from a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * @param value Value of the property
 * @throws android.view.inspector.PropertyReader.PropertyTypeMismatchException If the property ID is not mapped as a {@code short}
 * @apiSince 29
 */

public void readShort(int id, short value);

/**
 * Read any object as a property.
 *
 * If value is null, the property is marked as empty.
 *
 * @param id Identifier of the property from a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * @param value Value of the property
 * This value may be {@code null}.
 * @throws android.view.inspector.PropertyReader.PropertyTypeMismatchException If the property ID is not mapped as an object
 * @apiSince 29
 */

public void readObject(int id, @androidx.annotation.Nullable java.lang.Object value);

/**
 * Read a color packed into a {@link android.annotation.ColorInt ColorInt} as a property.
 *
 * @param id Identifier of the property from a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * @param value Value of the property
 * @throws android.view.inspector.PropertyReader.PropertyTypeMismatchException If the property ID is not mapped as a color
 * @apiSince 29
 */

public void readColor(int id, int value);

/**
 * Read a color packed into a {@code ColorLong} as a property.
 *
 * @param id Identifier of the property from a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * @param value Value of the property packed as a {@code ColorLong}. See the
 *              {@link android.graphics.Color Color} class for details of the packing.
 * @throws android.view.inspector.PropertyReader.PropertyTypeMismatchException If the property ID is not mapped as a color
 * @apiSince 29
 */

public void readColor(int id, long value);

/**
 * Read a {@link android.graphics.Color Color} object as a property.
 *
 * @param id Identifier of the property from a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * @param value Value of the property
 * This value may be {@code null}.
 * @throws android.view.inspector.PropertyReader.PropertyTypeMismatchException If the property ID is not mapped as a color
 * @apiSince 29
 */

public void readColor(int id, @androidx.annotation.Nullable android.graphics.Color value);

/**
 * Read {@link android.view.Gravity} packed into an primitive {@code int}.
 *
 * @param id Identifier of the property from a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * @param value Value of the property
 * @throws android.view.inspector.PropertyReader.PropertyTypeMismatchException If the property ID is not mapped as a gravity property
 * @apiSince 29
 */

public void readGravity(int id, int value);

/**
 * Read an enumeration packed into a primitive {@code int}.
 *
 * @param id Identifier of the property from a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * @param value Value of the property
 * @throws android.view.inspector.PropertyReader.PropertyTypeMismatchException If the property ID is not mapped as an object
 * @apiSince 29
 */

public void readIntEnum(int id, int value);

/**
 * Read a flag packed into a primitive {@code int}.
 *
 * @param id Identifier of the property from a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * @param value Value of the property
 * @throws android.view.inspector.PropertyReader.PropertyTypeMismatchException If the property ID is not mapped as an object
 * @apiSince 29
 */

public void readIntFlag(int id, int value);

/**
 * Read an integer that contains a resource ID.
 *
 * @param id Identifier of the property from a {@link android.view.inspector.PropertyMapper PropertyMapper}
 * @param value Value of the property
 * @throws android.view.inspector.PropertyReader.PropertyTypeMismatchException If the property ID is not mapped as a resource ID.
 * @apiSince 29
 */

public void readResourceId(int id, int value);
/**
 * Thrown if a client calls a typed read method for a property of a different type.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class PropertyTypeMismatchException extends java.lang.RuntimeException {

/**
 * @param expectedPropertyType This value must never be {@code null}.
 
 * @param actualPropertyType This value must never be {@code null}.
 
 * @param propertyName This value may be {@code null}.
 * @apiSince 29
 */

public PropertyTypeMismatchException(int id, @androidx.annotation.NonNull java.lang.String expectedPropertyType, @androidx.annotation.NonNull java.lang.String actualPropertyType, @androidx.annotation.Nullable java.lang.String propertyName) { throw new RuntimeException("Stub!"); }

/**
 * @param expectedPropertyType This value must never be {@code null}.
 
 * @param actualPropertyType This value must never be {@code null}.
 * @apiSince 29
 */

public PropertyTypeMismatchException(int id, @androidx.annotation.NonNull java.lang.String expectedPropertyType, @androidx.annotation.NonNull java.lang.String actualPropertyType) { throw new RuntimeException("Stub!"); }
}

}

