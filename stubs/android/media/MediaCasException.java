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
 * Base class for MediaCas exceptions
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MediaCasException extends java.lang.Exception {

private MediaCasException() { throw new RuntimeException("Stub!"); }
/**
 * Exception thrown when the provisioning server or key server denies a
 * license for a device.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class DeniedByServerException extends android.media.MediaCasException {

DeniedByServerException() { throw new RuntimeException("Stub!"); }
}

/**
 * Exception thrown when an operation on a MediaCas object is attempted
 * before it's provisioned successfully.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class NotProvisionedException extends android.media.MediaCasException {

NotProvisionedException() { throw new RuntimeException("Stub!"); }
}

/**
 * Exception thrown when an operation on a MediaCas object is attempted
 * and hardware resources are not available, due to being in use.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class ResourceBusyException extends android.media.MediaCasException {

ResourceBusyException() { throw new RuntimeException("Stub!"); }
}

/**
 * Exception thrown when an attempt is made to construct a MediaCas object
 * using a CA_system_id that is not supported by the device
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class UnsupportedCasException extends android.media.MediaCasException {

UnsupportedCasException() { throw new RuntimeException("Stub!"); }
}

}

