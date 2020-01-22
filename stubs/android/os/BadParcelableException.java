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
 * Exception thrown when a {@link android.os.Parcelable Parcelable} is malformed or otherwise invalid.
 * <p>
 * This is typically encountered when a custom {@link android.os.Parcelable Parcelable} object is
 * passed to another process that doesn't have the same {@link android.os.Parcelable Parcelable} class
 * in its {@link java.lang.ClassLoader ClassLoader}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BadParcelableException extends android.util.AndroidRuntimeException {

/** @apiSince 1 */

public BadParcelableException(java.lang.String msg) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public BadParcelableException(java.lang.Exception cause) { throw new RuntimeException("Stub!"); }
}

