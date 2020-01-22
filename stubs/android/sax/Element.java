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


package android.sax;


/**
 * An XML element. Provides access to child elements and hooks to listen
 * for events related to this element.
 *
 * @see android.sax.RootElement
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Element {

Element() { throw new RuntimeException("Stub!"); }

/**
 * Gets the child element with the given name. Uses an empty string as the
 * namespace.
 * @apiSince 1
 */

public android.sax.Element getChild(java.lang.String localName) { throw new RuntimeException("Stub!"); }

/**
 * Gets the child element with the given name.
 * @apiSince 1
 */

public android.sax.Element getChild(java.lang.String uri, java.lang.String localName) { throw new RuntimeException("Stub!"); }

/**
 * Gets the child element with the given name. Uses an empty string as the
 * namespace. We will throw a {@link org.xml.sax.SAXException} at parsing
 * time if the specified child is missing. This helps you ensure that your
 * listeners are called.
 * @apiSince 1
 */

public android.sax.Element requireChild(java.lang.String localName) { throw new RuntimeException("Stub!"); }

/**
 * Gets the child element with the given name. We will throw a
 * {@link org.xml.sax.SAXException} at parsing time if the specified child
 * is missing. This helps you ensure that your listeners are called.
 * @apiSince 1
 */

public android.sax.Element requireChild(java.lang.String uri, java.lang.String localName) { throw new RuntimeException("Stub!"); }

/**
 * Sets start and end element listeners at the same time.
 * @apiSince 1
 */

public void setElementListener(android.sax.ElementListener elementListener) { throw new RuntimeException("Stub!"); }

/**
 * Sets start and end text element listeners at the same time.
 * @apiSince 1
 */

public void setTextElementListener(android.sax.TextElementListener elementListener) { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener for the start of this element.
 * @apiSince 1
 */

public void setStartElementListener(android.sax.StartElementListener startElementListener) { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener for the end of this element.
 * @apiSince 1
 */

public void setEndElementListener(android.sax.EndElementListener endElementListener) { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener for the end of this text element.
 * @apiSince 1
 */

public void setEndTextElementListener(android.sax.EndTextElementListener endTextElementListener) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

