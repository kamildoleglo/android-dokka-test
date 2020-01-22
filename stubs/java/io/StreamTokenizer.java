/*
 * Copyright (c) 1995, 2012, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */



package java.io;


/**
 * The {@code StreamTokenizer} class takes an input stream and
 * parses it into "tokens", allowing the tokens to be
 * read one at a time. The parsing process is controlled by a table
 * and a number of flags that can be set to various states. The
 * stream tokenizer can recognize identifiers, numbers, quoted
 * strings, and various comment styles.
 * <p>
 * Each byte read from the input stream is regarded as a character
 * in the range {@code '\u005Cu0000'} through {@code '\u005Cu00FF'}.
 * The character value is used to look up five possible attributes of
 * the character: <i>white space</i>, <i>alphabetic</i>,
 * <i>numeric</i>, <i>string quote</i>, and <i>comment character</i>.
 * Each character can have zero or more of these attributes.
 * <p>
 * In addition, an instance has four flags. These flags indicate:
 * <ul>
 * <li>Whether line terminators are to be returned as tokens or treated
 *     as white space that merely separates tokens.
 * <li>Whether C-style comments are to be recognized and skipped.
 * <li>Whether C++-style comments are to be recognized and skipped.
 * <li>Whether the characters of identifiers are converted to lowercase.
 * </ul>
 * <p>
 * A typical application first constructs an instance of this class,
 * sets up the syntax tables, and then repeatedly loops calling the
 * {@code nextToken} method in each iteration of the loop until
 * it returns the value {@code TT_EOF}.
 *
 * @author  James Gosling
 * @see     java.io.StreamTokenizer#nextToken()
 * @see     java.io.StreamTokenizer#TT_EOF
 * @since   JDK1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StreamTokenizer {

/**
 * Creates a stream tokenizer that parses the specified input
 * stream. The stream tokenizer is initialized to the following
 * default state:
 * <ul>
 * <li>All byte values {@code 'A'} through {@code 'Z'},
 *     {@code 'a'} through {@code 'z'}, and
 *     {@code '\u005Cu00A0'} through {@code '\u005Cu00FF'} are
 *     considered to be alphabetic.
 * <li>All byte values {@code '\u005Cu0000'} through
 *     {@code '\u005Cu0020'} are considered to be white space.
 * <li>{@code '/'} is a comment character.
 * <li>Single quote {@code '\u005C''} and double quote {@code '"'}
 *     are string quote characters.
 * <li>Numbers are parsed.
 * <li>Ends of lines are treated as white space, not as separate tokens.
 * <li>C-style and C++-style comments are not recognized.
 * </ul>
 *
 * @deprecated As of JDK version 1.1, the preferred way to tokenize an
 * input stream is to convert it into a character stream, for example:
 * <blockquote><pre>
 *   Reader r = new BufferedReader(new InputStreamReader(is));
 *   StreamTokenizer st = new StreamTokenizer(r);
 * </pre></blockquote>
 *
 * @param      is        an input stream.
 * @see        java.io.BufferedReader
 * @see        java.io.InputStreamReader
 * @see        java.io.StreamTokenizer#StreamTokenizer(java.io.Reader)
 * @apiSince 1
 */

@Deprecated
public StreamTokenizer(java.io.InputStream is) { throw new RuntimeException("Stub!"); }

/**
 * Create a tokenizer that parses the given character stream.
 *
 * @param r  a Reader object providing the input stream.
 * @since   JDK1.1
 * @apiSince 1
 */

public StreamTokenizer(java.io.Reader r) { throw new RuntimeException("Stub!"); }

/**
 * Resets this tokenizer's syntax table so that all characters are
 * "ordinary." See the {@code ordinaryChar} method
 * for more information on a character being ordinary.
 *
 * @see     java.io.StreamTokenizer#ordinaryChar(int)
 * @apiSince 1
 */

public void resetSyntax() { throw new RuntimeException("Stub!"); }

/**
 * Specifies that all characters <i>c</i> in the range
 * <code>low&nbsp;&lt;=&nbsp;<i>c</i>&nbsp;&lt;=&nbsp;high</code>
 * are word constituents. A word token consists of a word constituent
 * followed by zero or more word constituents or number constituents.
 *
 * @param   low   the low end of the range.
 * @param   hi    the high end of the range.
 * @apiSince 1
 */

public void wordChars(int low, int hi) { throw new RuntimeException("Stub!"); }

/**
 * Specifies that all characters <i>c</i> in the range
 * <code>low&nbsp;&lt;=&nbsp;<i>c</i>&nbsp;&lt;=&nbsp;high</code>
 * are white space characters. White space characters serve only to
 * separate tokens in the input stream.
 *
 * <p>Any other attribute settings for the characters in the specified
 * range are cleared.
 *
 * @param   low   the low end of the range.
 * @param   hi    the high end of the range.
 * @apiSince 1
 */

public void whitespaceChars(int low, int hi) { throw new RuntimeException("Stub!"); }

/**
 * Specifies that all characters <i>c</i> in the range
 * <code>low&nbsp;&lt;=&nbsp;<i>c</i>&nbsp;&lt;=&nbsp;high</code>
 * are "ordinary" in this tokenizer. See the
 * {@code ordinaryChar} method for more information on a
 * character being ordinary.
 *
 * @param   low   the low end of the range.
 * @param   hi    the high end of the range.
 * @see     java.io.StreamTokenizer#ordinaryChar(int)
 * @apiSince 1
 */

public void ordinaryChars(int low, int hi) { throw new RuntimeException("Stub!"); }

/**
 * Specifies that the character argument is "ordinary"
 * in this tokenizer. It removes any special significance the
 * character has as a comment character, word component, string
 * delimiter, white space, or number character. When such a character
 * is encountered by the parser, the parser treats it as a
 * single-character token and sets {@code ttype} field to the
 * character value.
 *
 * <p>Making a line terminator character "ordinary" may interfere
 * with the ability of a {@code StreamTokenizer} to count
 * lines. The {@code lineno} method may no longer reflect
 * the presence of such terminator characters in its line count.
 *
 * @param   ch   the character.
 * @see     java.io.StreamTokenizer#ttype
 * @apiSince 1
 */

public void ordinaryChar(int ch) { throw new RuntimeException("Stub!"); }

/**
 * Specified that the character argument starts a single-line
 * comment. All characters from the comment character to the end of
 * the line are ignored by this stream tokenizer.
 *
 * <p>Any other attribute settings for the specified character are cleared.
 *
 * @param   ch   the character.
 * @apiSince 1
 */

public void commentChar(int ch) { throw new RuntimeException("Stub!"); }

/**
 * Specifies that matching pairs of this character delimit string
 * constants in this tokenizer.
 * <p>
 * When the {@code nextToken} method encounters a string
 * constant, the {@code ttype} field is set to the string
 * delimiter and the {@code sval} field is set to the body of
 * the string.
 * <p>
 * If a string quote character is encountered, then a string is
 * recognized, consisting of all characters after (but not including)
 * the string quote character, up to (but not including) the next
 * occurrence of that same string quote character, or a line
 * terminator, or end of file. The usual escape sequences such as
 * {@code "\u005Cn"} and {@code "\u005Ct"} are recognized and
 * converted to single characters as the string is parsed.
 *
 * <p>Any other attribute settings for the specified character are cleared.
 *
 * @param   ch   the character.
 * @see     java.io.StreamTokenizer#nextToken()
 * @see     java.io.StreamTokenizer#sval
 * @see     java.io.StreamTokenizer#ttype
 * @apiSince 1
 */

public void quoteChar(int ch) { throw new RuntimeException("Stub!"); }

/**
 * Specifies that numbers should be parsed by this tokenizer. The
 * syntax table of this tokenizer is modified so that each of the twelve
 * characters:
 * <blockquote><pre>
 *      0 1 2 3 4 5 6 7 8 9 . -
 * </pre></blockquote>
 * <p>
 * has the "numeric" attribute.
 * <p>
 * When the parser encounters a word token that has the format of a
 * double precision floating-point number, it treats the token as a
 * number rather than a word, by setting the {@code ttype}
 * field to the value {@code TT_NUMBER} and putting the numeric
 * value of the token into the {@code nval} field.
 *
 * @see     java.io.StreamTokenizer#nval
 * @see     java.io.StreamTokenizer#TT_NUMBER
 * @see     java.io.StreamTokenizer#ttype
 * @apiSince 1
 */

public void parseNumbers() { throw new RuntimeException("Stub!"); }

/**
 * Determines whether or not ends of line are treated as tokens.
 * If the flag argument is true, this tokenizer treats end of lines
 * as tokens; the {@code nextToken} method returns
 * {@code TT_EOL} and also sets the {@code ttype} field to
 * this value when an end of line is read.
 * <p>
 * A line is a sequence of characters ending with either a
 * carriage-return character ({@code '\u005Cr'}) or a newline
 * character ({@code '\u005Cn'}). In addition, a carriage-return
 * character followed immediately by a newline character is treated
 * as a single end-of-line token.
 * <p>
 * If the {@code flag} is false, end-of-line characters are
 * treated as white space and serve only to separate tokens.
 *
 * @param   flag   {@code true} indicates that end-of-line characters
 *                 are separate tokens; {@code false} indicates that
 *                 end-of-line characters are white space.
 * @see     java.io.StreamTokenizer#nextToken()
 * @see     java.io.StreamTokenizer#ttype
 * @see     java.io.StreamTokenizer#TT_EOL
 * @apiSince 1
 */

public void eolIsSignificant(boolean flag) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether or not the tokenizer recognizes C-style comments.
 * If the flag argument is {@code true}, this stream tokenizer
 * recognizes C-style comments. All text between successive
 * occurrences of {@code /*} and <code>*&#47;</code> are discarded.
 * <p>
 * If the flag argument is {@code false}, then C-style comments
 * are not treated specially.
 *
 * @param   flag   {@code true} indicates to recognize and ignore
 *                 C-style comments.
 * @apiSince 1
 */

public void slashStarComments(boolean flag) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether or not the tokenizer recognizes C++-style comments.
 * If the flag argument is {@code true}, this stream tokenizer
 * recognizes C++-style comments. Any occurrence of two consecutive
 * slash characters ({@code '/'}) is treated as the beginning of
 * a comment that extends to the end of the line.
 * <p>
 * If the flag argument is {@code false}, then C++-style
 * comments are not treated specially.
 *
 * @param   flag   {@code true} indicates to recognize and ignore
 *                 C++-style comments.
 * @apiSince 1
 */

public void slashSlashComments(boolean flag) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether or not word token are automatically lowercased.
 * If the flag argument is {@code true}, then the value in the
 * {@code sval} field is lowercased whenever a word token is
 * returned (the {@code ttype} field has the
 * value {@code TT_WORD} by the {@code nextToken} method
 * of this tokenizer.
 * <p>
 * If the flag argument is {@code false}, then the
 * {@code sval} field is not modified.
 *
 * @param   fl   {@code true} indicates that all word tokens should
 *               be lowercased.
 * @see     java.io.StreamTokenizer#nextToken()
 * @see     java.io.StreamTokenizer#ttype
 * @see     java.io.StreamTokenizer#TT_WORD
 * @apiSince 1
 */

public void lowerCaseMode(boolean fl) { throw new RuntimeException("Stub!"); }

/**
 * Parses the next token from the input stream of this tokenizer.
 * The type of the next token is returned in the {@code ttype}
 * field. Additional information about the token may be in the
 * {@code nval} field or the {@code sval} field of this
 * tokenizer.
 * <p>
 * Typical clients of this
 * class first set up the syntax tables and then sit in a loop
 * calling nextToken to parse successive tokens until TT_EOF
 * is returned.
 *
 * @return     the value of the {@code ttype} field.
 * @exception  java.io.IOException  if an I/O error occurs.
 * @see        java.io.StreamTokenizer#nval
 * @see        java.io.StreamTokenizer#sval
 * @see        java.io.StreamTokenizer#ttype
 * @apiSince 1
 */

public int nextToken() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Causes the next call to the {@code nextToken} method of this
 * tokenizer to return the current value in the {@code ttype}
 * field, and not to modify the value in the {@code nval} or
 * {@code sval} field.
 *
 * @see     java.io.StreamTokenizer#nextToken()
 * @see     java.io.StreamTokenizer#nval
 * @see     java.io.StreamTokenizer#sval
 * @see     java.io.StreamTokenizer#ttype
 * @apiSince 1
 */

public void pushBack() { throw new RuntimeException("Stub!"); }

/**
 * Return the current line number.
 *
 * @return  the current line number of this stream tokenizer.
 * @apiSince 1
 */

public int lineno() { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of the current stream token and
 * the line number it occurs on.
 *
 * <p>The precise string returned is unspecified, although the following
 * example can be considered typical:
 *
 * <blockquote><pre>Token['a'], line 10</pre></blockquote>
 *
 * @return  a string representation of the token
 * @see     java.io.StreamTokenizer#nval
 * @see     java.io.StreamTokenizer#sval
 * @see     java.io.StreamTokenizer#ttype
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * A constant indicating that the end of the stream has been read.
 * @apiSince 1
 */

public static final int TT_EOF = -1; // 0xffffffff

/**
 * A constant indicating that the end of the line has been read.
 * @apiSince 1
 */

public static final int TT_EOL = 10; // 0xa

/**
 * A constant indicating that a number token has been read.
 * @apiSince 1
 */

public static final int TT_NUMBER = -2; // 0xfffffffe

/**
 * A constant indicating that a word token has been read.
 * @apiSince 1
 */

public static final int TT_WORD = -3; // 0xfffffffd

/**
 * If the current token is a number, this field contains the value
 * of that number. The current token is a number when the value of
 * the {@code ttype} field is {@code TT_NUMBER}.
 * <p>
 * The initial value of this field is 0.0.
 *
 * @see     java.io.StreamTokenizer#TT_NUMBER
 * @see     java.io.StreamTokenizer#ttype
 * @apiSince 1
 */

public double nval;

/**
 * If the current token is a word token, this field contains a
 * string giving the characters of the word token. When the current
 * token is a quoted string token, this field contains the body of
 * the string.
 * <p>
 * The current token is a word when the value of the
 * {@code ttype} field is {@code TT_WORD}. The current token is
 * a quoted string token when the value of the {@code ttype} field is
 * a quote character.
 * <p>
 * The initial value of this field is null.
 *
 * @see     java.io.StreamTokenizer#quoteChar(int)
 * @see     java.io.StreamTokenizer#TT_WORD
 * @see     java.io.StreamTokenizer#ttype
 * @apiSince 1
 */

public java.lang.String sval;

/**
 * After a call to the {@code nextToken} method, this field
 * contains the type of the token just read. For a single character
 * token, its value is the single character, converted to an integer.
 * For a quoted string token, its value is the quote character.
 * Otherwise, its value is one of the following:
 * <ul>
 * <li>{@code TT_WORD} indicates that the token is a word.
 * <li>{@code TT_NUMBER} indicates that the token is a number.
 * <li>{@code TT_EOL} indicates that the end of line has been read.
 *     The field can only have this value if the
 *     {@code eolIsSignificant} method has been called with the
 *     argument {@code true}.
 * <li>{@code TT_EOF} indicates that the end of the input stream
 *     has been reached.
 * </ul>
 * <p>
 * The initial value of this field is -4.
 *
 * @see     java.io.StreamTokenizer#eolIsSignificant(boolean)
 * @see     java.io.StreamTokenizer#nextToken()
 * @see     java.io.StreamTokenizer#quoteChar(int)
 * @see     java.io.StreamTokenizer#TT_EOF
 * @see     java.io.StreamTokenizer#TT_EOL
 * @see     java.io.StreamTokenizer#TT_NUMBER
 * @see     java.io.StreamTokenizer#TT_WORD
 * @apiSince 1
 */

public int ttype = -4; // 0xfffffffc
}

