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


package android.content.res;

import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/**
 * The XML parsing interface returned for an XML resource.  This is a standard
 * {@link org.xmlpull.v1.XmlPullParser XmlPullParser} interface but also extends {@link android.util.AttributeSet AttributeSet} and
 * adds an additional {@link #close()} method for the client to indicate when
 * it is done reading the resource.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface XmlResourceParser extends org.xmlpull.v1.XmlPullParser,  android.util.AttributeSet, java.lang.AutoCloseable {

/** @apiSince 1 */

public java.lang.String getAttributeNamespace(int index);

/**
 * Close this parser. Calls on the interface are no longer valid after this call.
 * @apiSince 1
 */

public void close();
}

