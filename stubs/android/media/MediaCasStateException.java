/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.media;


/**
 * Base class for MediaCas runtime exceptions
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MediaCasStateException extends java.lang.IllegalStateException {

private MediaCasStateException() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a developer-readable diagnostic information string
 * associated with the exception. Do not show this to end-users,
 * since this string will not be localized or generally comprehensible
 * to end-users.
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.lang.String getDiagnosticInfo() { throw new RuntimeException("Stub!"); }
}

