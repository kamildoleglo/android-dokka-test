/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.drm;


/**
 * An entity class that wraps converted data, conversion status, and the
 * offset for appending the header and body signature to the converted data.
 * An instance of this class may be created two ways by the drm framework:
 * a) a call to {@link android.drm.DrmManagerClient#convertData DrmManagerClient#convertData} and
 * b) a call to {@link android.drm.DrmManagerClient#closeConvertSession DrmManagerClient#closeConvertSession}.
 * An valid offset value is provided only from a success call to
 * {@link android.drm.DrmManagerClient#closeConvertSession DrmManagerClient#closeConvertSession}.
 *
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DrmConvertedStatus {

/**
 * Creates a <code>DrmConvertedStatus</code> object with the specified parameters.
 *
 * @param statusCode Conversion status. Must be one of the status code constants
 * defined above.
 * @param convertedData Converted data. It can be null.
 * @param offset Offset value for appending the header and body signature.
 * @apiSince 11
 */

public DrmConvertedStatus(int statusCode, byte[] convertedData, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Indicate a general failed conversion status.
 * @apiSince 11
 */

public static final int STATUS_ERROR = 3; // 0x3

/**
 * Indicate a failed conversion status due to input data.
 * @apiSince 11
 */

public static final int STATUS_INPUTDATA_ERROR = 2; // 0x2

/**
 * Indicate the conversion status is successful.
 * @apiSince 11
 */

public static final int STATUS_OK = 1; // 0x1

/**
 * Converted data. It is optional and thus can be null.
 * @apiSince 11
 */

public final byte[] convertedData;
{ convertedData = new byte[0]; }

/**
 * Offset value for the body and header signature.
 * @apiSince 11
 */

public final int offset;
{ offset = 0; }

/**
 * Status code for the conversion. Must be one of the defined status
 * constants above.
 * @apiSince 11
 */

public final int statusCode;
{ statusCode = 0; }
}

