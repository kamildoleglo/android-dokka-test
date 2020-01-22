/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.util;


/**
 * Math routines similar to those found in {@link java.lang.Math}.
 *
 * <p>Historically these methods were faster than the equivalent double-based
 * {@link java.lang.Math} methods. On versions of Android with a JIT they
 * became slower and have since been re-implemented to wrap calls to
 * {@link java.lang.Math}. {@link java.lang.Math} should be used in
 * preference.
 *
 * <p>All methods were removed from the public API in version 23.
 *
 * @deprecated Use {@link java.lang.Math} instead.
 * @apiSince 1
 * @deprecatedSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class FloatMath {

private FloatMath() { throw new RuntimeException("Stub!"); }
}

