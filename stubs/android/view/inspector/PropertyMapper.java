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


/**
 * An interface for mapping the string names of inspectable properties to integer identifiers.
 *
 * This interface is consumed by {@link android.view.inspector.InspectionCompanion#mapProperties(android.view.inspector.PropertyMapper) InspectionCompanion#mapProperties(PropertyMapper)}.
 *
 * Mapping properties to IDs enables quick comparisons against shadow copies of inspectable
 * objects without performing a large number of string comparisons.
 *
 * @see android.view.inspector.InspectionCompanion#mapProperties(PropertyMapper)
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface PropertyMapper {

/**
 * Map a string name to an integer ID for a primitive boolean property.
 *
 * @param name The name of the property
 * This value must never be {@code null}.
 * @param attributeId If the property is from an XML attribute, the resource ID of the property
 * @return An integer ID for the property
 * @throws android.view.inspector.PropertyMapper.PropertyConflictException If the property name is already mapped as another type.
 * @apiSince 29
 */

public int mapBoolean(@androidx.annotation.NonNull java.lang.String name, int attributeId);

/**
 * Map a string name to an integer ID for a primitive byte property.
 *
 * @param name The name of the property
 * This value must never be {@code null}.
 * @param attributeId If the property is from an XML attribute, the resource ID of the property
 * @return An integer ID for the property
 * @throws android.view.inspector.PropertyMapper.PropertyConflictException If the property name is already mapped as another type.
 * @apiSince 29
 */

public int mapByte(@androidx.annotation.NonNull java.lang.String name, int attributeId);

/**
 * Map a string name to an integer ID for a primitive char property.
 *
 * @param name The name of the property
 * This value must never be {@code null}.
 * @param attributeId If the property is from an XML attribute, the resource ID of the property
 * @return An integer ID for the property
 * @throws android.view.inspector.PropertyMapper.PropertyConflictException If the property name is already mapped as another type.
 * @apiSince 29
 */

public int mapChar(@androidx.annotation.NonNull java.lang.String name, int attributeId);

/**
 * Map a string name to an integer ID for a primitive double property.
 *
 * @param name The name of the property
 * This value must never be {@code null}.
 * @param attributeId If the property is from an XML attribute, the resource ID of the property
 * @return An integer ID for the property
 * @throws android.view.inspector.PropertyMapper.PropertyConflictException If the property name is already mapped as another type.
 * @apiSince 29
 */

public int mapDouble(@androidx.annotation.NonNull java.lang.String name, int attributeId);

/**
 * Map a string name to an integer ID for a primitive float property.
 *
 * @param name The name of the property
 * This value must never be {@code null}.
 * @param attributeId If the property is from an XML attribute, the resource ID of the property
 * @return An integer ID for the property
 * @throws android.view.inspector.PropertyMapper.PropertyConflictException If the property name is already mapped as another type.
 * @apiSince 29
 */

public int mapFloat(@androidx.annotation.NonNull java.lang.String name, int attributeId);

/**
 * Map a string name to an integer ID for a primitive int property.
 *
 * @param name The name of the property
 * This value must never be {@code null}.
 * @param attributeId If the property is from an XML attribute, the resource ID of the property
 * @return An integer ID for the property
 * @throws android.view.inspector.PropertyMapper.PropertyConflictException If the property name is already mapped as another type.
 * @apiSince 29
 */

public int mapInt(@androidx.annotation.NonNull java.lang.String name, int attributeId);

/**
 * Map a string name to an integer ID for a primitive long property.
 *
 * @param name The name of the property
 * This value must never be {@code null}.
 * @param attributeId If the property is from an XML attribute, the resource ID of the property
 * @return An integer ID for the property
 * @throws android.view.inspector.PropertyMapper.PropertyConflictException If the property name is already mapped as another type.
 * @apiSince 29
 */

public int mapLong(@androidx.annotation.NonNull java.lang.String name, int attributeId);

/**
 * Map a string name to an integer ID for a primitive short property.
 *
 * @param name The name of the property
 * This value must never be {@code null}.
 * @param attributeId If the property is from an XML attribute, the resource ID of the property
 * @return An integer ID for the property
 * @throws android.view.inspector.PropertyMapper.PropertyConflictException If the property name is already mapped as another type.
 * @apiSince 29
 */

public int mapShort(@androidx.annotation.NonNull java.lang.String name, int attributeId);

/**
 * Map a string name to an integer ID for an object property.
 *
 * @param name The name of the property
 * This value must never be {@code null}.
 * @param attributeId If the property is from an XML attribute, the resource ID of the property
 * @return An integer ID for the property
 * @throws android.view.inspector.PropertyMapper.PropertyConflictException If the property name is already mapped as another type.
 * @apiSince 29
 */

public int mapObject(@androidx.annotation.NonNull java.lang.String name, int attributeId);

/**
 * Map a string name to an integer ID for a color property.
 *
 * @param name The name of the property
 * This value must never be {@code null}.
 * @param attributeId If the property is from an XML attribute, the resource ID of the property
 * @return An integer ID for the property
 * @throws android.view.inspector.PropertyMapper.PropertyConflictException If the property name is already mapped as another type.
 * @see android.graphics.Color
 * @apiSince 29
 */

public int mapColor(@androidx.annotation.NonNull java.lang.String name, int attributeId);

/**
 * Map a string name to an integer ID for a gravity property.
 *
 * @param name The name of the property
 * This value must never be {@code null}.
 * @param attributeId If the property is from an XML attribute, the resource ID of the property
 * @return An integer ID for the property
 * @throws android.view.inspector.PropertyMapper.PropertyConflictException If the property name is already mapped as another type.
 * @see android.view.Gravity
 * @apiSince 29
 */

public int mapGravity(@androidx.annotation.NonNull java.lang.String name, int attributeId);

/**
 * Map a string name to an integer ID for an enumeration packed into an int property.
 *
 * @param name The name of the property
 * This value must never be {@code null}.
 * @param attributeId If the property is from an XML attribute, the resource ID of the property
 * @param mapping A mapping from int to String
 * This value must never be {@code null}.
 * @return An integer ID for the property
 * @throws android.view.inspector.PropertyMapper.PropertyConflictException If the property name is already mapped as another type.
 * @apiSince 29
 */

public int mapIntEnum(@androidx.annotation.NonNull java.lang.String name, int attributeId, @androidx.annotation.NonNull java.util.function.IntFunction<java.lang.String> mapping);

/**
 * Map a string name to an integer ID for an attribute that contains resource IDs.
 *
 * @param name The name of the property
 * This value must never be {@code null}.
 * @param attributeId If the property is from an XML attribute, the resource ID of the property
 * @return An integer ID for the property
 * @throws android.view.inspector.PropertyMapper.PropertyConflictException If the property name is already mapped as another type.
 * @apiSince 29
 */

public int mapResourceId(@androidx.annotation.NonNull java.lang.String name, int attributeId);

/**
 * Map a string name to an integer ID for a flag set packed into an int property.
 *
 * @param name The name of the property
 * This value must never be {@code null}.
 * @param attributeId If the property is from an XML attribute, the resource ID of the property
 * @param mapping A mapping from int to a set of strings
 * This value must never be {@code null}.
 * @return An integer ID for the property
 * @throws android.view.inspector.PropertyMapper.PropertyConflictException If the property name is already mapped as another type.
 * @apiSince 29
 */

public int mapIntFlag(@androidx.annotation.NonNull java.lang.String name, int attributeId, @androidx.annotation.NonNull java.util.function.IntFunction<java.util.Set<java.lang.String>> mapping);
/**
 * Thrown from a map method if a property name is already mapped as different type.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class PropertyConflictException extends java.lang.RuntimeException {

/**
 * @param name This value must never be {@code null}.
 
 * @param newPropertyType This value must never be {@code null}.
 
 * @param existingPropertyType This value must never be {@code null}.
 * @apiSince 29
 */

public PropertyConflictException(@androidx.annotation.NonNull java.lang.String name, @androidx.annotation.NonNull java.lang.String newPropertyType, @androidx.annotation.NonNull java.lang.String existingPropertyType) { throw new RuntimeException("Stub!"); }
}

}

