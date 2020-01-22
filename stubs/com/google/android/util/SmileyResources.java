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


package com.google.android.util;


/**
 * Resources for smiley parser.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SmileyResources implements com.google.android.util.AbstractMessageParser.Resources {

/**
 *
 * @param smilies Smiley text, e.g.&nbsp;":)", "8-)"
 * @param smileyResIds Resource IDs associated with the smileys.
 * @apiSince R
 */

public SmileyResources(java.lang.String[] smilies, int[] smileyResIds) { throw new RuntimeException("Stub!"); }

/**
 * Looks up the resource id of a given smiley.
 * @param smiley The smiley to look up.
 * @return the resource id of the specified smiley, or -1 if no resource
 *         id is associated with it.
 * @apiSince R
 */

public int getSmileyRes(java.lang.String smiley) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.util.Set<java.lang.String> getSchemes() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public com.google.android.util.AbstractMessageParser.TrieNode getDomainSuffixes() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public com.google.android.util.AbstractMessageParser.TrieNode getSmileys() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public com.google.android.util.AbstractMessageParser.TrieNode getAcronyms() { throw new RuntimeException("Stub!"); }
}

