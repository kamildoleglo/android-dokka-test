/*
 * Copyright (c) 1996, 2012, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.charset.Charset;
import java.util.Formatter;
import java.util.Locale;

/**
 * Prints formatted representations of objects to a text-output stream.  This
 * class implements all of the <tt>print</tt> methods found in {@link java.io.PrintStream PrintStream}.  It does not contain methods for writing raw bytes, for which
 * a program should use unencoded byte streams.
 *
 * <p> Unlike the {@link java.io.PrintStream PrintStream} class, if automatic flushing is enabled
 * it will be done only when one of the <tt>println</tt>, <tt>printf</tt>, or
 * <tt>format</tt> methods is invoked, rather than whenever a newline character
 * happens to be output.  These methods use the platform's own notion of line
 * separator rather than the newline character.
 *
 * <p> Methods in this class never throw I/O exceptions, although some of its
 * constructors may.  The client may inquire as to whether any errors have
 * occurred by invoking {@link #checkError checkError()}.
 *
 * @author      Frank Yellin
 * @author      Mark Reinhold
 * @since       JDK1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PrintWriter extends java.io.Writer {

/**
 * Creates a new PrintWriter, without automatic line flushing.
 *
 * @param  out        A character-output stream
 * @apiSince 1
 */

public PrintWriter(@androidx.annotation.NonNull java.io.Writer out) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new PrintWriter.
 *
 * @param  out        A character-output stream
 * @param  autoFlush  A boolean; if true, the <tt>println</tt>,
 *                    <tt>printf</tt>, or <tt>format</tt> methods will
 *                    flush the output buffer
 * @apiSince 1
 */

public PrintWriter(@androidx.annotation.NonNull java.io.Writer out, boolean autoFlush) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new PrintWriter, without automatic line flushing, from an
 * existing OutputStream.  This convenience constructor creates the
 * necessary intermediate OutputStreamWriter, which will convert characters
 * into bytes using the default character encoding.
 *
 * @param  out        An output stream
 *
 * @see java.io.OutputStreamWriter#OutputStreamWriter(java.io.OutputStream)
 * @apiSince 1
 */

public PrintWriter(@androidx.annotation.NonNull java.io.OutputStream out) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new PrintWriter from an existing OutputStream.  This
 * convenience constructor creates the necessary intermediate
 * OutputStreamWriter, which will convert characters into bytes using the
 * default character encoding.
 *
 * @param  out        An output stream
 * @param  autoFlush  A boolean; if true, the <tt>println</tt>,
 *                    <tt>printf</tt>, or <tt>format</tt> methods will
 *                    flush the output buffer
 *
 * @see java.io.OutputStreamWriter#OutputStreamWriter(java.io.OutputStream)
 * @apiSince 1
 */

public PrintWriter(@androidx.annotation.NonNull java.io.OutputStream out, boolean autoFlush) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new PrintWriter, without automatic line flushing, with the
 * specified file name.  This convenience constructor creates the necessary
 * intermediate {@link java.io.OutputStreamWriter OutputStreamWriter},
 * which will encode characters using the {@linkplain
 * java.nio.charset.Charset#defaultCharset() default charset} for this
 * instance of the Java virtual machine.
 *
 * @param  fileName
 *         The name of the file to use as the destination of this writer.
 *         If the file exists then it will be truncated to zero size;
 *         otherwise, a new file will be created.  The output will be
 *         written to the file and is buffered.
 *
 * @throws  java.io.FileNotFoundException
 *          If the given string does not denote an existing, writable
 *          regular file and a new regular file of that name cannot be
 *          created, or if some other error occurs while opening or
 *          creating the file
 *
 * @throws  java.lang.SecurityException
 *          If a security manager is present and {@link java.lang.SecurityManager#checkWrite SecurityManager#checkWrite} denies write
 *          access to the file
 *
 * @since  1.5
 * @apiSince 1
 */

public PrintWriter(@androidx.annotation.NonNull java.lang.String fileName) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new PrintWriter, without automatic line flushing, with the
 * specified file name and charset.  This convenience constructor creates
 * the necessary intermediate {@link java.io.OutputStreamWriter
 * OutputStreamWriter}, which will encode characters using the provided
 * charset.
 *
 * @param  fileName
 *         The name of the file to use as the destination of this writer.
 *         If the file exists then it will be truncated to zero size;
 *         otherwise, a new file will be created.  The output will be
 *         written to the file and is buffered.
 *
 * @param  csn
 *         The name of a supported {@linkplain java.nio.charset.Charset
 *         charset}
 *
 * @throws  java.io.FileNotFoundException
 *          If the given string does not denote an existing, writable
 *          regular file and a new regular file of that name cannot be
 *          created, or if some other error occurs while opening or
 *          creating the file
 *
 * @throws  java.lang.SecurityException
 *          If a security manager is present and {@link java.lang.SecurityManager#checkWrite SecurityManager#checkWrite} denies write
 *          access to the file
 *
 * @throws  java.io.UnsupportedEncodingException
 *          If the named charset is not supported
 *
 * @since  1.5
 * @apiSince 1
 */

public PrintWriter(@androidx.annotation.NonNull java.lang.String fileName, @androidx.annotation.NonNull java.lang.String csn) throws java.io.FileNotFoundException, java.io.UnsupportedEncodingException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new PrintWriter, without automatic line flushing, with the
 * specified file.  This convenience constructor creates the necessary
 * intermediate {@link java.io.OutputStreamWriter OutputStreamWriter},
 * which will encode characters using the {@linkplain
 * java.nio.charset.Charset#defaultCharset() default charset} for this
 * instance of the Java virtual machine.
 *
 * @param  file
 *         The file to use as the destination of this writer.  If the file
 *         exists then it will be truncated to zero size; otherwise, a new
 *         file will be created.  The output will be written to the file
 *         and is buffered.
 *
 * @throws  java.io.FileNotFoundException
 *          If the given file object does not denote an existing, writable
 *          regular file and a new regular file of that name cannot be
 *          created, or if some other error occurs while opening or
 *          creating the file
 *
 * @throws  java.lang.SecurityException
 *          If a security manager is present and {@link java.lang.SecurityManager#checkWrite SecurityManager#checkWrite}
 *          denies write access to the file
 *
 * @since  1.5
 * @apiSince 1
 */

public PrintWriter(@androidx.annotation.NonNull java.io.File file) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new PrintWriter, without automatic line flushing, with the
 * specified file and charset.  This convenience constructor creates the
 * necessary intermediate {@link java.io.OutputStreamWriter
 * OutputStreamWriter}, which will encode characters using the provided
 * charset.
 *
 * @param  file
 *         The file to use as the destination of this writer.  If the file
 *         exists then it will be truncated to zero size; otherwise, a new
 *         file will be created.  The output will be written to the file
 *         and is buffered.
 *
 * @param  csn
 *         The name of a supported {@linkplain java.nio.charset.Charset
 *         charset}
 *
 * @throws  java.io.FileNotFoundException
 *          If the given file object does not denote an existing, writable
 *          regular file and a new regular file of that name cannot be
 *          created, or if some other error occurs while opening or
 *          creating the file
 *
 * @throws  java.lang.SecurityException
 *          If a security manager is present and {@link java.lang.SecurityManager#checkWrite SecurityManager#checkWrite}
 *          denies write access to the file
 *
 * @throws  java.io.UnsupportedEncodingException
 *          If the named charset is not supported
 *
 * @since  1.5
 * @apiSince 1
 */

public PrintWriter(@androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull java.lang.String csn) throws java.io.FileNotFoundException, java.io.UnsupportedEncodingException { throw new RuntimeException("Stub!"); }

/**
 * Flushes the stream.
 * @see #checkError()
 * @apiSince 1
 */

public void flush() { throw new RuntimeException("Stub!"); }

/**
 * Closes the stream and releases any system resources associated
 * with it. Closing a previously closed stream has no effect.
 *
 * @see #checkError()
 * @apiSince 1
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Flushes the stream if it's not closed and checks its error state.
 *
 * @return <code>true</code> if the print stream has encountered an error,
 *          either on the underlying output stream or during a format
 *          conversion.
 * @apiSince 1
 */

public boolean checkError() { throw new RuntimeException("Stub!"); }

/**
 * Indicates that an error has occurred.
 *
 * <p> This method will cause subsequent invocations of {@link
 * #checkError()} to return <tt>true</tt> until {@link
 * #clearError()} is invoked.
 * @apiSince 1
 */

protected void setError() { throw new RuntimeException("Stub!"); }

/**
 * Clears the error state of this stream.
 *
 * <p> This method will cause subsequent invocations of {@link
 * #checkError()} to return <tt>false</tt> until another write
 * operation fails and invokes {@link #setError()}.
 *
 * @since 1.6
 * @apiSince 9
 */

protected void clearError() { throw new RuntimeException("Stub!"); }

/**
 * Writes a single character.
 * @param c int specifying a character to be written.
 * @apiSince 1
 */

public void write(int c) { throw new RuntimeException("Stub!"); }

/**
 * Writes A Portion of an array of characters.
 * @param buf Array of characters
 * @param off Offset from which to start writing characters
 * @param len Number of characters to write
 * @apiSince 1
 */

public void write(char[] buf, int off, int len) { throw new RuntimeException("Stub!"); }

/**
 * Writes an array of characters.  This method cannot be inherited from the
 * Writer class because it must suppress I/O exceptions.
 * @param buf Array of characters to be written
 * @apiSince 1
 */

public void write(char[] buf) { throw new RuntimeException("Stub!"); }

/**
 * Writes a portion of a string.
 * @param s A String
 * @param off Offset from which to start writing characters
 * @param len Number of characters to write
 * @apiSince 1
 */

public void write(@androidx.annotation.NonNull java.lang.String s, int off, int len) { throw new RuntimeException("Stub!"); }

/**
 * Writes a string.  This method cannot be inherited from the Writer class
 * because it must suppress I/O exceptions.
 * @param s String to be written
 * @apiSince 1
 */

public void write(@androidx.annotation.NonNull java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Prints a boolean value.  The string produced by <code>{@link
 * java.lang.String#valueOf(boolean)}</code> is translated into bytes
 * according to the platform's default character encoding, and these bytes
 * are written in exactly the manner of the <code>{@link
 * #write(int)}</code> method.
 *
 * @param      b   The <code>boolean</code> to be printed
 * @apiSince 1
 */

public void print(boolean b) { throw new RuntimeException("Stub!"); }

/**
 * Prints a character.  The character is translated into one or more bytes
 * according to the platform's default character encoding, and these bytes
 * are written in exactly the manner of the <code>{@link
 * #write(int)}</code> method.
 *
 * @param      c   The <code>char</code> to be printed
 * @apiSince 1
 */

public void print(char c) { throw new RuntimeException("Stub!"); }

/**
 * Prints an integer.  The string produced by <code>{@link
 * java.lang.String#valueOf(int)}</code> is translated into bytes according
 * to the platform's default character encoding, and these bytes are
 * written in exactly the manner of the <code>{@link #write(int)}</code>
 * method.
 *
 * @param      i   The <code>int</code> to be printed
 * @see        java.lang.Integer#toString(int)
 * @apiSince 1
 */

public void print(int i) { throw new RuntimeException("Stub!"); }

/**
 * Prints a long integer.  The string produced by <code>{@link
 * java.lang.String#valueOf(long)}</code> is translated into bytes
 * according to the platform's default character encoding, and these bytes
 * are written in exactly the manner of the <code>{@link #write(int)}</code>
 * method.
 *
 * @param      l   The <code>long</code> to be printed
 * @see        java.lang.Long#toString(long)
 * @apiSince 1
 */

public void print(long l) { throw new RuntimeException("Stub!"); }

/**
 * Prints a floating-point number.  The string produced by <code>{@link
 * java.lang.String#valueOf(float)}</code> is translated into bytes
 * according to the platform's default character encoding, and these bytes
 * are written in exactly the manner of the <code>{@link #write(int)}</code>
 * method.
 *
 * @param      f   The <code>float</code> to be printed
 * @see        java.lang.Float#toString(float)
 * @apiSince 1
 */

public void print(float f) { throw new RuntimeException("Stub!"); }

/**
 * Prints a double-precision floating-point number.  The string produced by
 * <code>{@link java.lang.String#valueOf(double)}</code> is translated into
 * bytes according to the platform's default character encoding, and these
 * bytes are written in exactly the manner of the <code>{@link
 * #write(int)}</code> method.
 *
 * @param      d   The <code>double</code> to be printed
 * @see        java.lang.Double#toString(double)
 * @apiSince 1
 */

public void print(double d) { throw new RuntimeException("Stub!"); }

/**
 * Prints an array of characters.  The characters are converted into bytes
 * according to the platform's default character encoding, and these bytes
 * are written in exactly the manner of the <code>{@link #write(int)}</code>
 * method.
 *
 * @param      s   The array of chars to be printed
 *
 * @throws  java.lang.NullPointerException  If <code>s</code> is <code>null</code>
 * @apiSince 1
 */

public void print(char[] s) { throw new RuntimeException("Stub!"); }

/**
 * Prints a string.  If the argument is <code>null</code> then the string
 * <code>"null"</code> is printed.  Otherwise, the string's characters are
 * converted into bytes according to the platform's default character
 * encoding, and these bytes are written in exactly the manner of the
 * <code>{@link #write(int)}</code> method.
 *
 * @param      s   The <code>String</code> to be printed
 * @apiSince 1
 */

public void print(@androidx.annotation.Nullable java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Prints an object.  The string produced by the <code>{@link
 * java.lang.String#valueOf(Object)}</code> method is translated into bytes
 * according to the platform's default character encoding, and these bytes
 * are written in exactly the manner of the <code>{@link #write(int)}</code>
 * method.
 *
 * @param      obj   The <code>Object</code> to be printed
 * @see        java.lang.Object#toString()
 * @apiSince 1
 */

public void print(@androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Terminates the current line by writing the line separator string.  The
 * line separator string is defined by the system property
 * <code>line.separator</code>, and is not necessarily a single newline
 * character (<code>'\n'</code>).
 * @apiSince 1
 */

public void println() { throw new RuntimeException("Stub!"); }

/**
 * Prints a boolean value and then terminates the line.  This method behaves
 * as though it invokes <code>{@link #print(boolean)}</code> and then
 * <code>{@link #println()}</code>.
 *
 * @param x the <code>boolean</code> value to be printed
 * @apiSince 1
 */

public void println(boolean x) { throw new RuntimeException("Stub!"); }

/**
 * Prints a character and then terminates the line.  This method behaves as
 * though it invokes <code>{@link #print(char)}</code> and then <code>{@link
 * #println()}</code>.
 *
 * @param x the <code>char</code> value to be printed
 * @apiSince 1
 */

public void println(char x) { throw new RuntimeException("Stub!"); }

/**
 * Prints an integer and then terminates the line.  This method behaves as
 * though it invokes <code>{@link #print(int)}</code> and then <code>{@link
 * #println()}</code>.
 *
 * @param x the <code>int</code> value to be printed
 * @apiSince 1
 */

public void println(int x) { throw new RuntimeException("Stub!"); }

/**
 * Prints a long integer and then terminates the line.  This method behaves
 * as though it invokes <code>{@link #print(long)}</code> and then
 * <code>{@link #println()}</code>.
 *
 * @param x the <code>long</code> value to be printed
 * @apiSince 1
 */

public void println(long x) { throw new RuntimeException("Stub!"); }

/**
 * Prints a floating-point number and then terminates the line.  This method
 * behaves as though it invokes <code>{@link #print(float)}</code> and then
 * <code>{@link #println()}</code>.
 *
 * @param x the <code>float</code> value to be printed
 * @apiSince 1
 */

public void println(float x) { throw new RuntimeException("Stub!"); }

/**
 * Prints a double-precision floating-point number and then terminates the
 * line.  This method behaves as though it invokes <code>{@link
 * #print(double)}</code> and then <code>{@link #println()}</code>.
 *
 * @param x the <code>double</code> value to be printed
 * @apiSince 1
 */

public void println(double x) { throw new RuntimeException("Stub!"); }

/**
 * Prints an array of characters and then terminates the line.  This method
 * behaves as though it invokes <code>{@link #print(char[])}</code> and then
 * <code>{@link #println()}</code>.
 *
 * @param x the array of <code>char</code> values to be printed
 * @apiSince 1
 */

public void println(char[] x) { throw new RuntimeException("Stub!"); }

/**
 * Prints a String and then terminates the line.  This method behaves as
 * though it invokes <code>{@link #print(java.lang.String)}</code> and then
 * <code>{@link #println()}</code>.
 *
 * @param x the <code>String</code> value to be printed
 * @apiSince 1
 */

public void println(@androidx.annotation.Nullable java.lang.String x) { throw new RuntimeException("Stub!"); }

/**
 * Prints an Object and then terminates the line.  This method calls
 * at first String.valueOf(x) to get the printed object's string value,
 * then behaves as
 * though it invokes <code>{@link #print(java.lang.String)}</code> and then
 * <code>{@link #println()}</code>.
 *
 * @param x  The <code>Object</code> to be printed.
 * @apiSince 1
 */

public void println(@androidx.annotation.Nullable java.lang.Object x) { throw new RuntimeException("Stub!"); }

/**
 * A convenience method to write a formatted string to this writer using
 * the specified format string and arguments.  If automatic flushing is
 * enabled, calls to this method will flush the output buffer.
 *
 * <p> An invocation of this method of the form <tt>out.printf(format,
 * args)</tt> behaves in exactly the same way as the invocation
 *
 * <pre>
 *     out.format(format, args) </pre>
 *
 * @param  format
 *         A format string as described in <a
 *         href="../util/Formatter.html#syntax">Format string syntax</a>.
 *
 * @param  args
 *         Arguments referenced by the format specifiers in the format
 *         string.  If there are more arguments than format specifiers, the
 *         extra arguments are ignored.  The number of arguments is
 *         variable and may be zero.  The maximum number of arguments is
 *         limited by the maximum dimension of a Java array as defined by
 *         <cite>The Java&trade; Virtual Machine Specification</cite>.
 *         The behaviour on a
 *         <tt>null</tt> argument depends on the <a
 *         href="../util/Formatter.html#syntax">conversion</a>.
 *
 * @throws  java.util.IllegalFormatException
 *          If a format string contains an illegal syntax, a format
 *          specifier that is incompatible with the given arguments,
 *          insufficient arguments given the format string, or other
 *          illegal conditions.  For specification of all possible
 *          formatting errors, see the <a
 *          href="../util/Formatter.html#detail">Details</a> section of the
 *          formatter class specification.
 *
 * @throws  java.lang.NullPointerException
 *          If the <tt>format</tt> is <tt>null</tt>
 *
 * @return  This writer
 *
 * @since  1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.io.PrintWriter printf(@androidx.annotation.NonNull java.lang.String format, @androidx.annotation.NonNull java.lang.Object... args) { throw new RuntimeException("Stub!"); }

/**
 * A convenience method to write a formatted string to this writer using
 * the specified format string and arguments.  If automatic flushing is
 * enabled, calls to this method will flush the output buffer.
 *
 * <p> An invocation of this method of the form <tt>out.printf(l, format,
 * args)</tt> behaves in exactly the same way as the invocation
 *
 * <pre>
 *     out.format(l, format, args) </pre>
 *
 * @param  l
 *         The {@linkplain java.util.Locale locale} to apply during
 *         formatting.  If <tt>l</tt> is <tt>null</tt> then no localization
 *         is applied.
 *
 * @param  format
 *         A format string as described in <a
 *         href="../util/Formatter.html#syntax">Format string syntax</a>.
 *
 * @param  args
 *         Arguments referenced by the format specifiers in the format
 *         string.  If there are more arguments than format specifiers, the
 *         extra arguments are ignored.  The number of arguments is
 *         variable and may be zero.  The maximum number of arguments is
 *         limited by the maximum dimension of a Java array as defined by
 *         <cite>The Java&trade; Virtual Machine Specification</cite>.
 *         The behaviour on a
 *         <tt>null</tt> argument depends on the <a
 *         href="../util/Formatter.html#syntax">conversion</a>.
 *
 * @throws  java.util.IllegalFormatException
 *          If a format string contains an illegal syntax, a format
 *          specifier that is incompatible with the given arguments,
 *          insufficient arguments given the format string, or other
 *          illegal conditions.  For specification of all possible
 *          formatting errors, see the <a
 *          href="../util/Formatter.html#detail">Details</a> section of the
 *          formatter class specification.
 *
 * @throws  java.lang.NullPointerException
 *          If the <tt>format</tt> is <tt>null</tt>
 *
 * @return  This writer
 *
 * @since  1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.io.PrintWriter printf(@androidx.annotation.Nullable java.util.Locale l, @androidx.annotation.NonNull java.lang.String format, @androidx.annotation.NonNull java.lang.Object... args) { throw new RuntimeException("Stub!"); }

/**
 * Writes a formatted string to this writer using the specified format
 * string and arguments.  If automatic flushing is enabled, calls to this
 * method will flush the output buffer.
 *
 * <p> The locale always used is the one returned by {@link
 * java.util.Locale#getDefault() Locale.getDefault()}, regardless of any
 * previous invocations of other formatting methods on this object.
 *
 * @param  format
 *         A format string as described in <a
 *         href="../util/Formatter.html#syntax">Format string syntax</a>.
 *
 * @param  args
 *         Arguments referenced by the format specifiers in the format
 *         string.  If there are more arguments than format specifiers, the
 *         extra arguments are ignored.  The number of arguments is
 *         variable and may be zero.  The maximum number of arguments is
 *         limited by the maximum dimension of a Java array as defined by
 *         <cite>The Java&trade; Virtual Machine Specification</cite>.
 *         The behaviour on a
 *         <tt>null</tt> argument depends on the <a
 *         href="../util/Formatter.html#syntax">conversion</a>.
 *
 * @throws  java.util.IllegalFormatException
 *          If a format string contains an illegal syntax, a format
 *          specifier that is incompatible with the given arguments,
 *          insufficient arguments given the format string, or other
 *          illegal conditions.  For specification of all possible
 *          formatting errors, see the <a
 *          href="../util/Formatter.html#detail">Details</a> section of the
 *          Formatter class specification.
 *
 * @throws  java.lang.NullPointerException
 *          If the <tt>format</tt> is <tt>null</tt>
 *
 * @return  This writer
 *
 * @since  1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.io.PrintWriter format(@androidx.annotation.NonNull java.lang.String format, @androidx.annotation.NonNull java.lang.Object... args) { throw new RuntimeException("Stub!"); }

/**
 * Writes a formatted string to this writer using the specified format
 * string and arguments.  If automatic flushing is enabled, calls to this
 * method will flush the output buffer.
 *
 * @param  l
 *         The {@linkplain java.util.Locale locale} to apply during
 *         formatting.  If <tt>l</tt> is <tt>null</tt> then no localization
 *         is applied.
 *
 * @param  format
 *         A format string as described in <a
 *         href="../util/Formatter.html#syntax">Format string syntax</a>.
 *
 * @param  args
 *         Arguments referenced by the format specifiers in the format
 *         string.  If there are more arguments than format specifiers, the
 *         extra arguments are ignored.  The number of arguments is
 *         variable and may be zero.  The maximum number of arguments is
 *         limited by the maximum dimension of a Java array as defined by
 *         <cite>The Java&trade; Virtual Machine Specification</cite>.
 *         The behaviour on a
 *         <tt>null</tt> argument depends on the <a
 *         href="../util/Formatter.html#syntax">conversion</a>.
 *
 * @throws  java.util.IllegalFormatException
 *          If a format string contains an illegal syntax, a format
 *          specifier that is incompatible with the given arguments,
 *          insufficient arguments given the format string, or other
 *          illegal conditions.  For specification of all possible
 *          formatting errors, see the <a
 *          href="../util/Formatter.html#detail">Details</a> section of the
 *          formatter class specification.
 *
 * @throws  java.lang.NullPointerException
 *          If the <tt>format</tt> is <tt>null</tt>
 *
 * @return  This writer
 *
 * @since  1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.io.PrintWriter format(@androidx.annotation.Nullable java.util.Locale l, @androidx.annotation.NonNull java.lang.String format, @androidx.annotation.NonNull java.lang.Object... args) { throw new RuntimeException("Stub!"); }

/**
 * Appends the specified character sequence to this writer.
 *
 * <p> An invocation of this method of the form <tt>out.append(csq)</tt>
 * behaves in exactly the same way as the invocation
 *
 * <pre>
 *     out.write(csq.toString()) </pre>
 *
 * <p> Depending on the specification of <tt>toString</tt> for the
 * character sequence <tt>csq</tt>, the entire sequence may not be
 * appended. For instance, invoking the <tt>toString</tt> method of a
 * character buffer will return a subsequence whose content depends upon
 * the buffer's position and limit.
 *
 * @param  csq
 *         The character sequence to append.  If <tt>csq</tt> is
 *         <tt>null</tt>, then the four characters <tt>"null"</tt> are
 *         appended to this writer.
 *
 * @return  This writer
 *
 * @since  1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.io.PrintWriter append(@androidx.annotation.Nullable java.lang.CharSequence csq) { throw new RuntimeException("Stub!"); }

/**
 * Appends a subsequence of the specified character sequence to this writer.
 *
 * <p> An invocation of this method of the form <tt>out.append(csq, start,
 * end)</tt> when <tt>csq</tt> is not <tt>null</tt>, behaves in
 * exactly the same way as the invocation
 *
 * <pre>
 *     out.write(csq.subSequence(start, end).toString()) </pre>
 *
 * @param  csq
 *         The character sequence from which a subsequence will be
 *         appended.  If <tt>csq</tt> is <tt>null</tt>, then characters
 *         will be appended as if <tt>csq</tt> contained the four
 *         characters <tt>"null"</tt>.
 *
 * @param  start
 *         The index of the first character in the subsequence
 *
 * @param  end
 *         The index of the character following the last character in the
 *         subsequence
 *
 * @return  This writer
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If <tt>start</tt> or <tt>end</tt> are negative, <tt>start</tt>
 *          is greater than <tt>end</tt>, or <tt>end</tt> is greater than
 *          <tt>csq.length()</tt>
 *
 * @since  1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.io.PrintWriter append(@androidx.annotation.Nullable java.lang.CharSequence csq, int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Appends the specified character to this writer.
 *
 * <p> An invocation of this method of the form <tt>out.append(c)</tt>
 * behaves in exactly the same way as the invocation
 *
 * <pre>
 *     out.write(c) </pre>
 *
 * @param  c
 *         The 16-bit character to append
 *
 * @return  This writer
 *
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.io.PrintWriter append(char c) { throw new RuntimeException("Stub!"); }

/**
 * The underlying character-output stream of this
 * <code>PrintWriter</code>.
 *
 * @since 1.2
 * @apiSince 1
 */

protected java.io.Writer out;
}

