/*
 * Copyright (C) 2011 The Android Open Source Project
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
 * Thrown when a reader encounters malformed JSON. Some syntax errors can be
 * ignored by calling {@link android.util.JsonReader#setLenient(boolean) JsonReader#setLenient(boolean)}.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MalformedJsonException extends java.io.IOException {

/** @apiSince 11 */

public MalformedJsonException(java.lang.String message) { throw new RuntimeException("Stub!"); }
}

