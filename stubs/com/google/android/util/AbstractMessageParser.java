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
 *
 * Logic for parsing a text message typed by the user looking for smileys,
 * urls, acronyms,formatting (e.g., '*'s for bold), me commands
 * (e.g., "/me is asleep"), and punctuation.
 *
 * It constructs an array, which breaks the text up into its
 * constituent pieces, which we return to the client.
 *
 @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbstractMessageParser {

/**
 * Create a message parser to parse urls, formatting, acronyms, smileys,
 * /me text and  music
 *
 * @param text the text to parse
 * @apiSince R
 */

public AbstractMessageParser(java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Create a message parser, specifying the kinds of text to parse
 *
 * @param text the text to parse
 *
 * @apiSince R
 */

public AbstractMessageParser(java.lang.String text, boolean parseSmilies, boolean parseAcronyms, boolean parseFormatting, boolean parseUrls, boolean parseMusic, boolean parseMeText) { throw new RuntimeException("Stub!"); }

/**
 * Subclasses must define the schemes, domains, smileys and acronyms
 * that are necessary for parsing
 * @apiSince R
 */

protected abstract com.google.android.util.AbstractMessageParser.Resources getResources();

/**
 * Returns the raw text being parsed.
 * @apiSince R
 */

public final java.lang.String getRawText() { throw new RuntimeException("Stub!"); }

/**
 * Return the number of parts.
 * @apiSince R
 */

public final int getPartCount() { throw new RuntimeException("Stub!"); }

/**
 * Return the part at the given index.
 * @apiSince R
 */

public final com.google.android.util.AbstractMessageParser.Part getPart(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return the list of parts from the parsed text
 * @apiSince R
 */

public final java.util.List<com.google.android.util.AbstractMessageParser.Part> getParts() { throw new RuntimeException("Stub!"); }

/**
 * Parses the text string into an internal representation.
 * @apiSince R
 */

public void parse() { throw new RuntimeException("Stub!"); }

/**
 * Get a the appropriate Token for a given URL
 *
 * @param text the anchor text
 * @param url the url
 *
 * @apiSince R
 */

public static com.google.android.util.AbstractMessageParser.Token tokenForUrl(java.lang.String url, java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Converts the entire message into a single HTML display string.
 * @apiSince R
 */

public java.lang.String toHtml() { throw new RuntimeException("Stub!"); }

/**
 * Returns the reverse of the given string.
 * @apiSince R
 */

protected static java.lang.String reverse(java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * Music note that indicates user is listening to a music track.
 * @apiSince R
 */

public static final java.lang.String musicNote = "\u266b ";
/**
 * Represents an acronym that was found in the input.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Acronym extends com.google.android.util.AbstractMessageParser.Token {

/** @apiSince R */

public Acronym(java.lang.String text, java.lang.String value) { super(null, null); throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String getValue() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean isHtml() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.util.List<java.lang.String> getInfo() { throw new RuntimeException("Stub!"); }
}

/**
 * Represents a link to a Flickr photo or album.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class FlickrPhoto extends com.google.android.util.AbstractMessageParser.Token {

/** @apiSince R */

public FlickrPhoto(java.lang.String user, java.lang.String photo, java.lang.String grouping, java.lang.String groupingId, java.lang.String text) { super(null, null); throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String getUser() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String getPhoto() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String getGrouping() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String getGroupingId() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean isHtml() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean isMedia() { throw new RuntimeException("Stub!"); }

/**
 * Returns a FlickrPhoto object if the given url is to a photo or Flickr
 * user.
 * @apiSince R
 */

public static com.google.android.util.AbstractMessageParser.FlickrPhoto matchURL(java.lang.String url, java.lang.String text) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.util.List<java.lang.String> getInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String getUrl() { throw new RuntimeException("Stub!"); }

/**
 * Returns the URL for the RSS description.
 * @apiSince R
 */

public static java.lang.String getRssUrl(java.lang.String user) { throw new RuntimeException("Stub!"); }

/**
 * Returns the URL for a particular tag.
 * @apiSince R
 */

public static java.lang.String getTagsURL(java.lang.String tag) { throw new RuntimeException("Stub!"); }

/**
 * Returns the URL to the user's Flickr homepage.
 * @apiSince R
 */

public static java.lang.String getUserURL(java.lang.String user) { throw new RuntimeException("Stub!"); }

/**
 * Returns the URL for a particular photo.
 * @apiSince R
 */

public static java.lang.String getPhotoURL(java.lang.String user, java.lang.String photo) { throw new RuntimeException("Stub!"); }

/**
 * Returns the URL for a user tag photo set.
 * @apiSince R
 */

public static java.lang.String getUserTagsURL(java.lang.String user, java.lang.String tagId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the URL for user set.
 * @apiSince R
 */

public static java.lang.String getUserSetsURL(java.lang.String user, java.lang.String setId) { throw new RuntimeException("Stub!"); }
}

/**
 * Represents a character that changes formatting.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Format extends com.google.android.util.AbstractMessageParser.Token {

/** @apiSince R */

public Format(char ch, boolean start) { super(null, null); throw new RuntimeException("Stub!"); }

/** @apiSince R */

public void setMatched(boolean matched) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean isHtml() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String toHtml(boolean caps) { throw new RuntimeException("Stub!"); }

/**
 * Not supported. Info should not be needed for this type
 * @apiSince R
 */

public java.util.List<java.lang.String> getInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean controlCaps() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean setCaps() { throw new RuntimeException("Stub!"); }
}

/**
 * Represents a simple string of html text.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Html extends com.google.android.util.AbstractMessageParser.Token {

/** @apiSince R */

public Html(java.lang.String text, java.lang.String html) { super(null, null); throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean isHtml() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String toHtml(boolean caps) { throw new RuntimeException("Stub!"); }

/**
 * Not supported. Info should not be needed for this type
 * @apiSince R
 */

public java.util.List<java.lang.String> getInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public void trimLeadingWhitespace() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public void trimTrailingWhitespace() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public static java.lang.String trimTrailingWhitespace(java.lang.String text) { throw new RuntimeException("Stub!"); }
}

/**
 * Represents a link that was found in the input.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Link extends com.google.android.util.AbstractMessageParser.Token {

/** @apiSince R */

public Link(java.lang.String url, java.lang.String text) { super(null, null); throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String getURL() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean isHtml() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.util.List<java.lang.String> getInfo() { throw new RuntimeException("Stub!"); }
}

/**
 * Represents a music track token at the beginning.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class MusicTrack extends com.google.android.util.AbstractMessageParser.Token {

/** @apiSince R */

public MusicTrack(java.lang.String track) { super(null, null); throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String getTrack() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean isHtml() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.util.List<java.lang.String> getInfo() { throw new RuntimeException("Stub!"); }
}

/**
 * Represents set of tokens that are delivered as a single message.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Part {

/** @apiSince R */

public Part() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String getType(boolean isSend) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean isMedia() { throw new RuntimeException("Stub!"); }

/**
 * Convenience method for getting the Token of a Part that represents
 * a media Token. Parts of this kind will always only have a single Token
 *
 * @return if this.isMedia(),
 *         returns the Token representing the media contained in this Part,
 *         otherwise returns null;
 * @apiSince R
 */

public com.google.android.util.AbstractMessageParser.Token getMediaToken() { throw new RuntimeException("Stub!"); }

/**
 * Adds the given token to this part.
 * @apiSince R
 */

public void add(com.google.android.util.AbstractMessageParser.Token token) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public void setMeText(java.lang.String meText) { throw new RuntimeException("Stub!"); }

/**
 * Returns the original text of this part.
 * @apiSince R
 */

public java.lang.String getRawText() { throw new RuntimeException("Stub!"); }

/**
 * Returns the tokens in this part.
 * @apiSince R
 */

public java.util.ArrayList<com.google.android.util.AbstractMessageParser.Token> getTokens() { throw new RuntimeException("Stub!"); }
}

/**
 * Represents a link to a Picasa photo or album.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Photo extends com.google.android.util.AbstractMessageParser.Token {

/** @apiSince R */

public Photo(java.lang.String user, java.lang.String album, java.lang.String photo, java.lang.String text) { super(null, null); throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String getUser() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String getAlbum() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String getPhoto() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean isHtml() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean isMedia() { throw new RuntimeException("Stub!"); }

/**
 * Returns a Photo object if the given url is to a photo or album.
 * @apiSince R
 */

public static com.google.android.util.AbstractMessageParser.Photo matchURL(java.lang.String url, java.lang.String text) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.util.List<java.lang.String> getInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the URL for the RSS description of the user's albums.
 * @apiSince R
 */

public static java.lang.String getRssUrl(java.lang.String user) { throw new RuntimeException("Stub!"); }

/**
 * Returns the URL for an album.
 * @apiSince R
 */

public static java.lang.String getAlbumURL(java.lang.String user, java.lang.String album) { throw new RuntimeException("Stub!"); }

/**
 * Returns the URL for a particular photo.
 * @apiSince R
 */

public static java.lang.String getPhotoURL(java.lang.String user, java.lang.String album, java.lang.String photo) { throw new RuntimeException("Stub!"); }
}

/**
 * Interface representing the set of resources needed by a message parser
 *
 * @author jessan (Jessan Hutchison-Quillian)
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Resources {

/**
 * Get the known set of URL schemes.
 * @apiSince R
 */

public java.util.Set<java.lang.String> getSchemes();

/** Get the possible values for the last part of a domain name.
 *  Values are expected to be reversed in the Trie.
 * @apiSince R
 */

public com.google.android.util.AbstractMessageParser.TrieNode getDomainSuffixes();

/**
 * Get the smileys accepted by the parser.
 * @apiSince R
 */

public com.google.android.util.AbstractMessageParser.TrieNode getSmileys();

/**
 * Get the acronyms accepted by the parser.
 * @apiSince R
 */

public com.google.android.util.AbstractMessageParser.TrieNode getAcronyms();
}

/**
 * Represents a smiley that was found in the input.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Smiley extends com.google.android.util.AbstractMessageParser.Token {

/** @apiSince R */

public Smiley(java.lang.String text) { super(null, null); throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean isHtml() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.util.List<java.lang.String> getInfo() { throw new RuntimeException("Stub!"); }
}

/**
 * Represents a unit of parsed output.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Token {

/** @apiSince R */

protected Token(com.google.android.util.AbstractMessageParser.Token.Type type, java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of the token.
 * @apiSince R
 */

public com.google.android.util.AbstractMessageParser.Token.Type getType() { throw new RuntimeException("Stub!"); }

/**
 * Get the relevant information about a token
 *
 * @return a list of strings representing the token, not null
 *         The first item is always a string representation of the type
 * @apiSince R
 */

public java.util.List<java.lang.String> getInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the raw text of the token.
 * @apiSince R
 */

public java.lang.String getRawText() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean isMedia() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public abstract boolean isHtml();

/** @apiSince R */

public boolean isArray() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String toHtml(boolean caps) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean controlCaps() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean setCaps() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

protected java.lang.String text;

/** @apiSince R */

protected com.google.android.util.AbstractMessageParser.Token.Type type;
/** @apiSince R */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum Type {
/** @apiSince R */

HTML,
/** @apiSince R */

FORMAT,
/** @apiSince R */

LINK,
/** @apiSince R */

SMILEY,
/** @apiSince R */

ACRONYM,
/** @apiSince R */

MUSIC,
/** @apiSince R */

GOOGLE_VIDEO,
/** @apiSince R */

YOUTUBE_VIDEO,
/** @apiSince R */

PHOTO,
/** @apiSince R */

FLICKR;

/**
 * {@inheritDoc}
 * @apiSince R
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

}

/** @apiSince R */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class TrieNode {

/** @apiSince R */

public TrieNode() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public TrieNode(java.lang.String text) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public final boolean exists() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public final java.lang.String getText() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public final java.lang.String getValue() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public void setValue(java.lang.String value) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public com.google.android.util.AbstractMessageParser.TrieNode getChild(char ch) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public com.google.android.util.AbstractMessageParser.TrieNode getOrCreateChild(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Adds the given string into the trie.
 * @apiSince R
 */

public static void addToTrie(com.google.android.util.AbstractMessageParser.TrieNode root, java.lang.String str, java.lang.String value) { throw new RuntimeException("Stub!"); }
}

/**
 * Represents a link to a Google Video.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Video extends com.google.android.util.AbstractMessageParser.Token {

/** @apiSince R */

public Video(java.lang.String docid, java.lang.String text) { super(null, null); throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String getDocID() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean isHtml() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean isMedia() { throw new RuntimeException("Stub!"); }

/**
 * Returns a Video object if the given url is to a video.
 * @apiSince R
 */

public static com.google.android.util.AbstractMessageParser.Video matchURL(java.lang.String url, java.lang.String text) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.util.List<java.lang.String> getInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the URL for the RSS description of the given video.
 * @apiSince R
 */

public static java.lang.String getRssUrl(java.lang.String docid) { throw new RuntimeException("Stub!"); }

/**
 * (For testing purposes:) Returns a video URL with the given parts.
 * @apiSince R
 */

public static java.lang.String getURL(java.lang.String docid) { throw new RuntimeException("Stub!"); }

/**
 * (For testing purposes:) Returns a video URL with the given parts.
 * @apiSince R
 */

public static java.lang.String getURL(java.lang.String docid, java.lang.String extraParams) { throw new RuntimeException("Stub!"); }
}

/**
 * Represents a link to a YouTube video.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class YouTubeVideo extends com.google.android.util.AbstractMessageParser.Token {

/** @apiSince R */

public YouTubeVideo(java.lang.String docid, java.lang.String text) { super(null, null); throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String getDocID() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean isHtml() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean isMedia() { throw new RuntimeException("Stub!"); }

/**
 * Returns a Video object if the given url is to a video.
 * @apiSince R
 */

public static com.google.android.util.AbstractMessageParser.YouTubeVideo matchURL(java.lang.String url, java.lang.String text) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.util.List<java.lang.String> getInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the URL for the RSS description of the given video.
 * @apiSince R
 */

public static java.lang.String getRssUrl(java.lang.String docid) { throw new RuntimeException("Stub!"); }

/**
 * (For testing purposes:) Returns a video URL with the given parts.
 * @apiSince R
 */

public static java.lang.String getURL(java.lang.String docid) { throw new RuntimeException("Stub!"); }

/**
 * (For testing purposes:) Returns a video URL with the given parts.
 * @apiSince R
 */

public static java.lang.String getURL(java.lang.String docid, java.lang.String extraParams) { throw new RuntimeException("Stub!"); }

/** (For testing purposes:) Returns a video URL with the given parts.
 * @param http If true, includes http://
 * @param prefix If non-null/non-blank, adds to URL before youtube.com.
 *   (e.g., prefix="br." --> "br.youtube.com")
 * @apiSince R
 */

public static java.lang.String getPrefixedURL(boolean http, java.lang.String prefix, java.lang.String docid, java.lang.String extraParams) { throw new RuntimeException("Stub!"); }
}

}

