/*
**
** Copyright 2012, The Android Open Source Project
**
** Licensed under the Apache License, Version 2.0 (the "License");
** you may not use this file except in compliance with the License.
** You may obtain a copy of the License at
**
**     http://www.apache.org/licenses/LICENSE-2.0
**
** Unless required by applicable law or agreed to in writing, software
** distributed under the License is distributed on an "AS IS" BASIS,
** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
** See the License for the specific language governing permissions and
** limitations under the License.
*/


package android.opengl;


/**
 * Base class for wrapped EGL objects.
 *
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class EGLObjectHandle {

/**
 * @deprecated Use {@link #EGLObjectHandle(long)} instead. Handles
 *     on 64 bit platforms will be wider than java ints.
 * @apiSince 17
 */

@Deprecated
protected EGLObjectHandle(int handle) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected EGLObjectHandle(long handle) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getNativeHandle()} instead. Handles on
 *     64 bit platforms will be wider than java ints.
 * @apiSince 17
 * @deprecatedSince 21
 */

@Deprecated
public int getHandle() { throw new RuntimeException("Stub!"); }

/**
 * Returns the native handle of the wrapped EGL object. This handle can be
 * cast to the corresponding native type on the native side.
 *
 * For example, EGLDisplay dpy = (EGLDisplay)handle;
 *
 * @return the native handle of the wrapped EGL object.
 * @apiSince 21
 */

public long getNativeHandle() { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

