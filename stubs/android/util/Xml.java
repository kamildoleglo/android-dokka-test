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

import org.xmlpull.v1.XmlPullParser;

/**
 * XML utility methods.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Xml {

private Xml() { throw new RuntimeException("Stub!"); }

/**
 * Parses the given xml string and fires events on the given SAX handler.
 * @apiSince 1
 */

public static void parse(java.lang.String xml, org.xml.sax.ContentHandler contentHandler) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Parses xml from the given reader and fires events on the given SAX
 * handler.
 * @apiSince 1
 */

public static void parse(java.io.Reader in, org.xml.sax.ContentHandler contentHandler) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Parses xml from the given input stream and fires events on the given SAX
 * handler.
 * @apiSince 1
 */

public static void parse(java.io.InputStream in, android.util.Xml.Encoding encoding, org.xml.sax.ContentHandler contentHandler) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Returns a new pull parser with namespace support.
 * @apiSince 1
 */

public static org.xmlpull.v1.XmlPullParser newPullParser() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new xml serializer.
 * @apiSince 1
 */

public static org.xmlpull.v1.XmlSerializer newSerializer() { throw new RuntimeException("Stub!"); }

/**
 * Finds an encoding by name. Returns UTF-8 if you pass {@code null}.
 * @apiSince 1
 */

public static android.util.Xml.Encoding findEncodingByName(java.lang.String encodingName) throws java.io.UnsupportedEncodingException { throw new RuntimeException("Stub!"); }

/**
 * Return an AttributeSet interface for use with the given XmlPullParser.
 * If the given parser itself implements AttributeSet, that implementation
 * is simply returned.  Otherwise a wrapper class is
 * instantiated on top of the XmlPullParser, as a proxy for retrieving its
 * attributes, and returned to you.
 *
 * @param parser The existing parser for which you would like an
 *               AttributeSet.
 *
 * @return An AttributeSet you can use to retrieve the
 *         attribute values at each of the tags as the parser moves
 *         through its XML document.
 *
 * @see android.util.AttributeSet
 * @apiSince 1
 */

public static android.util.AttributeSet asAttributeSet(org.xmlpull.v1.XmlPullParser parser) { throw new RuntimeException("Stub!"); }

/**
 * {@link org.xmlpull.v1.XmlPullParser} "relaxed" feature name.
 *
 * @see <a href="http://xmlpull.org/v1/doc/features.html#relaxed">
 *  specification</a>
 * @apiSince 1
 */

public static java.lang.String FEATURE_RELAXED = "http://xmlpull.org/v1/doc/features.html#relaxed";
/**
 * Supported character encodings.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum Encoding {
/** @apiSince 1 */

US_ASCII,
/** @apiSince 1 */

UTF_8,
/** @apiSince 1 */

UTF_16,
/** @apiSince 1 */

ISO_8859_1;
}

}

