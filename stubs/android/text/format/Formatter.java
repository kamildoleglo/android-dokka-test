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


package android.text.format;

import android.content.Context;

/**
 * Utility class to aid in formatting common values that are not covered
 * by the {@link java.util.Formatter} class in {@link java.util}
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Formatter {

public Formatter() { throw new RuntimeException("Stub!"); }

/**
 * Formats a content size to be in the form of bytes, kilobytes, megabytes, etc.
 *
 * <p>As of O, the prefixes are used in their standard meanings in the SI system, so kB = 1000
 * bytes, MB = 1,000,000 bytes, etc.</p>
 *
 * <p class="note">In {@link android.os.Build.VERSION_CODES#N} and earlier, powers of 1024 are
 * used instead, with KB = 1024 bytes, MB = 1,048,576 bytes, etc.</p>
 *
 * <p>If the context has a right-to-left locale, the returned string is wrapped in bidi
 * formatting characters to make sure it's displayed correctly if inserted inside a
 * right-to-left string. (This is useful in cases where the unit strings, like "MB", are
 * left-to-right, but the locale is right-to-left.)</p>
 *
 * @param context Context to use to load the localized units
 * This value may be {@code null}.
 * @param sizeBytes size value to be formatted, in bytes
 * @return formatted string with the number
 * @apiSince 3
 */

public static java.lang.String formatFileSize(@androidx.annotation.Nullable android.content.Context context, long sizeBytes) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #formatFileSize}, but trying to generate shorter numbers
 * (showing fewer digits of precision).
 
 * @param context This value may be {@code null}.
 * @apiSince 5
 */

public static java.lang.String formatShortFileSize(@androidx.annotation.Nullable android.content.Context context, long sizeBytes) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string in the canonical IPv4 format ###.###.###.### from a packed integer
 * containing the IP address. The IPv4 address is expected to be in little-endian
 * format (LSB first). That is, 0x01020304 will return "4.3.2.1".
 *
 * @deprecated Use {@link java.net.InetAddress#getHostAddress()}, which supports both IPv4 and
 *     IPv6 addresses. This method does not support IPv6 addresses.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated
public static java.lang.String formatIpAddress(int ipv4Address) { throw new RuntimeException("Stub!"); }
}

