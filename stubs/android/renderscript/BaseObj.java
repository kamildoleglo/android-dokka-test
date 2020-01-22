/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.renderscript;


/**
 * BaseObj is the base class for all RenderScript objects owned by a RS context.
 * It is responsible for lifetime management and resource tracking. This class
 * should not be used by a user application.
 *
 * * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BaseObj {

BaseObj() { throw new RuntimeException("Stub!"); }

/**
 * setName assigns a name to an object.  This object can later be looked up
 * by this name.
 *
 * @param name The name to assign to the object.
 * @apiSince 11
 */

public void setName(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * @return name of the renderscript object
 * @apiSince 14
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Frees any native resources associated with this object.  The
 * primary use is to force immediate cleanup of resources when it is
 * believed the GC will not respond quickly enough.
 * @apiSince 11
 */

public void destroy() { throw new RuntimeException("Stub!"); }

/**
 * Calculates the hash code value for a BaseObj.
 *
 * @return int
 * @apiSince 11
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Compare the current BaseObj with another BaseObj for equality.
 *
 * @param obj The object to check equality with.
 *
 * @return boolean
 * @apiSince 11
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }
}

