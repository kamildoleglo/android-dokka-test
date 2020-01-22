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


package android.content.res;

import java.io.IOException;

/**
 * Class to scan Opaque Binary Blob (OBB) files. Use this to get information
 * about an OBB file for use in a program via {@link android.content.res.ObbInfo ObbInfo}.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ObbScanner {

private ObbScanner() { throw new RuntimeException("Stub!"); }

/**
 * Scan a file for OBB information.
 *
 * @param filePath path to the OBB file to be scanned.
 * @return ObbInfo object information corresponding to the file path
 * @throws java.lang.IllegalArgumentException if the OBB file couldn't be found
 * @throws java.io.IOException if the OBB file couldn't be read
 * @apiSince 9
 */

public static android.content.res.ObbInfo getObbInfo(java.lang.String filePath) throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

