/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * A <code>PrintStream</code> adds functionality to another output stream,
 * namely the ability to print representations of various data values
 * conveniently.  Two other features are provided as well.  Unlike other output
 * streams, a <code>PrintStream</code> never throws an
 * <code>IOException</code>; instead, exceptional situations merely set an
 * internal flag that can be tested via the <code>checkError</code> method.
 * Optionally, a <code>PrintStream</code> can be created so as to flush
 * automatically; this means that the <code>flush</code> method is
 * automatically invoked after a byte array is written, one of the
 * <code>println</code> methods is invoked, or a newline character or byte
 * (<code>'\n'</code>) is written.
 *
 * <p> All characters printed by a <code>PrintStream</code> are converted into
 * bytes using the platform's default character encoding.  The <code>{@link java.io.PrintWriter PrintWriter}</code> class should be used in situations that require writing
 * characters rather than bytes.
 *
 * @author     Frank Yellin
 * @author     Mark Reinhold
 * @since      JDK1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PrintStream extends java.io.FilterOutputStream implements java.lang.Appendable, java.io.Closeable {

/**
 * Creates a new print stream.  This stream will not flush automatically.
 *
 * @param  out        The output stream to which values and objects will be
 *                    printed
 *
 * @see java.io.PrintWriter#PrintWriter(java.io.OutputStream)
 * @apiSince 1
 */

public PrintStream(java.io.OutputStream out) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new print stream.
 *
 * @param  out        The output stream to which values and objects will be
 *                    printed
 * @param  autoFlush  A boolean; if true, the output buffer will be flushed
 *                    whenever a byte array is written, one of the
 *                    <code>println</code> methods is invoked, or a newline
 *                    character or byte (<code>'\n'</code>) is written
 *
 * @see java.io.PrintWriter#PrintWriter(java.io.OutputStream, boolean)
 * @apiSince 1
 */

public PrintStream(java.io.OutputStream out, boolean autoFlush) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new print stream.
 *
 * @param  out        The output stream to which values and objects will be
 *                    printed
 * @param  autoFlush  A boolean; if true, the output buffer will be flushed
 *                    whenever a byte array is written, one of the
 *                    <code>println</code> methods is invoked, or a newline
 *                    character or byte (<code>'\n'</code>) is written
 * @param  encoding   The name of a supported
 *                    <a href="../lang/package-summary.html#charenc">
 *                    character encoding</a>
 *
 * @throws  java.io.UnsupportedEncodingException
 *          If the named encoding is not supported
 *
 * @since  1.4
 * @apiSince 1
 */

public PrintStream(java.io.OutputStream out, boolean autoFlush, java.lang.String encoding) throws java.io.UnsupportedEncodingException { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new print stream, without automatic line flushing, with the
 * specified file name.  This convenience constructor creates
 * the necessary intermediate {@link java.io.OutputStreamWriter
 * OutputStreamWriter}, which will encode characters using the
 * {@linkplain java.nio.charset.Charset#defaultCharset() default charset}
 * for this instance of the Java virtual machine.
 *
 * @param  fileName
 *         The name of the file to use as the destination of this print
 *         stream.  If the file exists, then it will be truncated to
 *         zero size; otherwise, a new file will be created.  The output
 *         will be written to the file and is buffered.
 *
 * @throws  java.io.FileNotFoundException
 *          If the given file object does not denote an existing, writable
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

public PrintStream(java.lang.String fileName) throws java.io.FileNotFoundException { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new print stream, without automatic line flushing, with the
 * specified file name and charset.  This convenience constructor creates
 * the necessary intermediate {@link java.io.OutputStreamWriter
 * OutputStreamWriter}, which will encode characters using the provided
 * charset.
 *
 * @param  fileName
 *         The name of the file to use as the destination of this print
 *         stream.  If the file exists, then it will be truncated to
 *         zero size; otherwise, a new file will be created.  The output
 *         will be written to the file and is buffered.
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
 *          If a security manager is present and {@link java.lang.SecurityManager#checkWrite SecurityManager#checkWrite} denies write
 *          access to the file
 *
 * @throws  java.io.UnsupportedEncodingException
 *          If the named charset is not supported
 *
 * @since  1.5
 * @apiSince 1
 */

public PrintStream(java.lang.String fileName, java.lang.String csn) throws java.io.FileNotFoundException, java.io.UnsupportedEncodingException { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new print stream, without automatic line flushing, with the
 * specified file.  This convenience constructor creates the necessary
 * intermediate {@link java.io.OutputStreamWriter OutputStreamWriter},
 * which will encode characters using the {@linkplain
 * java.nio.charset.Charset#defaultCharset() default charset} for this
 * instance of the Java virtual machine.
 *
 * @param  file
 *         The file to use as the destination of this print stream.  If the
 *         file exists, then it will be truncated to zero size; otherwise,
 *         a new file will be created.  The output will be written to the
 *         file and is buffered.
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

public PrintStream(java.io.File file) throws java.io.FileNotFoundException { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new print stream, without automatic line flushing, with the
 * specified file and charset.  This convenience constructor creates
 * the necessary intermediate {@link java.io.OutputStreamWriter
 * OutputStreamWriter}, which will encode characters using the provided
 * charset.
 *
 * @param  file
 *         The file to use as the destination of this print stream.  If the
 *         file exists, then it will be truncated to zero size; otherwise,
 *         a new file will be created.  The output will be written to the
 *         file and is buffered.
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

public PrintStream(java.io.File file, java.lang.String csn) throws java.io.FileNotFoundException, java.io.UnsupportedEncodingException { super(null); throw new RuntimeException("Stub!"); }

/**
 * Flushes the stream.  This is done by writing any buffered output bytes to
 * the underlying output stream and then flushing that stream.
 *
 * @see        java.io.OutputStream#flush()
 * @apiSince 1
 */

public void flush() { throw new RuntimeException("Stub!"); }

/**
 * Closes the stream.  This is done by flushing the stream and then closing
 * the underlying output stream.
 *
 * @see        java.io.OutputStream#close()
 * @apiSince 1
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Flushes the stream and checks its error state. The internal error state
 * is set to <code>true</code> when the underlying output stream throws an
 * <code>IOException</code> other than <code>InterruptedIOException</code>,
 * and when the <code>setError</code> method is invoked.  If an operation
 * on the underlying output stream throws an
 * <code>InterruptedIOException</code>, then the <code>PrintStream</code>
 * converts the exception back into an interrupt by doing:
 * <pre>
 *     Thread.currentThread().interrupt();
 * </pre>
 * or the equivalent.
 *
 * @return <code>true</code> if and only if this stream has encountered an
 *         <code>IOException</code> other than
 *         <code>InterruptedIOException</code>, or the
 *         <code>setError</code> method has been invoked
 * @apiSince 1
 */

public boolean checkError() { throw new RuntimeException("Stub!"); }

/**
 * Sets the error state of the stream to <code>true</code>.
 *
 * <p> This method will cause subsequent invocations of {@link
 * #checkError()} to return <tt>true</tt> until {@link
 * #clearError()} is invoked.
 *
 * @since JDK1.1
 * @apiSince 1
 */

protected void setError() { throw new RuntimeException("Stub!"); }

/**
 * Clears the internal error state of this stream.
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
 * Writes the specified byte to this stream.  If the byte is a newline and
 * automatic flushing is enabled then the <code>flush</code> method will be
 * invoked.
 *
 * <p> Note that the byte is written as given; to write a character that
 * will be translated according to the platform's default character
 * encoding, use the <code>print(char)</code> or <code>println(char)</code>
 * methods.
 *
 * @param  b  The byte to be written
 * @see #print(char)
 * @see #println(char)
 * @apiSince 1
 */

public void write(int b) { throw new RuntimeException("Stub!"); }

/**
 * Writes <code>len</code> bytes from the specified byte array starting at
 * offset <code>off</code> to this stream.  If automatic flushing is
 * enabled then the <code>flush</code> method will be invoked.
 *
 * <p> Note that the bytes will be written as given; to write characters
 * that will be translated according to the platform's default character
 * encoding, use the <code>print(char)</code> or <code>println(char)</code>
 * methods.
 *
 * @param  buf   A byte array
 * @param  off   Offset from which to start taking bytes
 * @param  len   Number of bytes to write
 * @apiSince 1
 */

public void write(byte[] buf, int off, int len) { throw new RuntimeException("Stub!"); }

/**
 * Prints a boolean value.  The string produced by <code>{@link
 * java.lang.String#valueOf(boolean)}</code> is translated into bytes
 * according to the platform's default character encoding, and these bytes
 * are written in exactly the manner of the
 * <code>{@link #write(int)}</code> method.
 *
 * @param      b   The <code>boolean</code> to be printed
 * @apiSince 1
 */

public void print(boolean b) { throw new RuntimeException("Stub!"); }

/**
 * Prints a character.  The character is translated into one or more bytes
 * according to the platform's default character encoding, and these bytes
 * are written in exactly the manner of the
 * <code>{@link #write(int)}</code> method.
 *
 * @param      c   The <code>char</code> to be printed
 * @apiSince 1
 */

public void print(char c) { throw new RuntimeException("Stub!"); }

/**
 * Prints an integer.  The string produced by <code>{@link
 * java.lang.String#valueOf(int)}</code> is translated into bytes
 * according to the platform's default character encoding, and these bytes
 * are written in exactly the manner of the
 * <code>{@link #write(int)}</code> method.
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
 * are written in exactly the manner of the
 * <code>{@link #write(int)}</code> method.
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
 * are written in exactly the manner of the
 * <code>{@link #write(int)}</code> method.
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
 * are written in exactly the manner of the
 * <code>{@link #write(int)}</code> method.
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

public void print(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Prints an object.  The string produced by the <code>{@link
 * java.lang.String#valueOf(Object)}</code> method is translated into bytes
 * according to the platform's default character encoding, and these bytes
 * are written in exactly the manner of the
 * <code>{@link #write(int)}</code> method.
 *
 * @param      obj   The <code>Object</code> to be printed
 * @see        java.lang.Object#toString()
 * @apiSince 1
 */

public void print(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Terminates the current line by writing the line separator string.  The
 * line separator string is defined by the system property
 * <code>line.separator</code>, and is not necessarily a single newline
 * character (<code>'\n'</code>).
 * @apiSince 1
 */

public void println() { throw new RuntimeException("Stub!"); }

/**
 * Prints a boolean and then terminate the line.  This method behaves as
 * though it invokes <code>{@link #print(boolean)}</code> and then
 * <code>{@link #println()}</code>.
 *
 * @param x  The <code>boolean</code> to be printed
 * @apiSince 1
 */

public void println(boolean x) { throw new RuntimeException("Stub!"); }

/**
 * Prints a character and then terminate the line.  This method behaves as
 * though it invokes <code>{@link #print(char)}</code> and then
 * <code>{@link #println()}</code>.
 *
 * @param x  The <code>char</code> to be printed.
 * @apiSince 1
 */

public void println(char x) { throw new RuntimeException("Stub!"); }

/**
 * Prints an integer and then terminate the line.  This method behaves as
 * though it invokes <code>{@link #print(int)}</code> and then
 * <code>{@link #println()}</code>.
 *
 * @param x  The <code>int</code> to be printed.
 * @apiSince 1
 */

public void println(int x) { throw new RuntimeException("Stub!"); }

/**
 * Prints a long and then terminate the line.  This method behaves as
 * though it invokes <code>{@link #print(long)}</code> and then
 * <code>{@link #println()}</code>.
 *
 * @param x  a The <code>long</code> to be printed.
 * @apiSince 1
 */

public void println(long x) { throw new RuntimeException("Stub!"); }

/**
 * Prints a float and then terminate the line.  This method behaves as
 * though it invokes <code>{@link #print(float)}</code> and then
 * <code>{@link #println()}</code>.
 *
 * @param x  The <code>float</code> to be printed.
 * @apiSince 1
 */

public void println(float x) { throw new RuntimeException("Stub!"); }

/**
 * Prints a double and then terminate the line.  This method behaves as
 * though it invokes <code>{@link #print(double)}</code> and then
 * <code>{@link #println()}</code>.
 *
 * @param x  The <code>double</code> to be printed.
 * @apiSince 1
 */

public void println(double x) { throw new RuntimeException("Stub!"); }

/**
 * Prints an array of characters and then terminate the line.  This method
 * behaves as though it invokes <code>{@link #print(char[])}</code> and
 * then <code>{@link #println()}</code>.
 *
 * @param x  an array of chars to print.
 * @apiSince 1
 */

public void println(char[] x) { throw new RuntimeException("Stub!"); }

/**
 * Prints a String and then terminate the line.  This method behaves as
 * though it invokes <code>{@link #print(java.lang.String)}</code> and then
 * <code>{@link #println()}</code>.
 *
 * @param x  The <code>String</code> to be printed.
 * @apiSince 1
 */

public void println(java.lang.String x) { throw new RuntimeException("Stub!"); }

/**
 * Prints an Object and then terminate the line.  This method calls
 * at first String.valueOf(x) to get the printed object's string value,
 * then behaves as
 * though it invokes <code>{@link #print(java.lang.String)}</code> and then
 * <code>{@link #println()}</code>.
 *
 * @param x  The <code>Object</code> to be printed.
 * @apiSince 1
 */

public void println(java.lang.Object x) { throw new RuntimeException("Stub!"); }

/**
 * A convenience method to write a formatted string to this output stream
 * using the specified format string and arguments.
 *
 * <p> An invocation of this method of the form <tt>out.printf(format,
 * args)</tt> behaves in exactly the same way as the invocation
 *
 * <pre>
 *     out.format(format, args) </pre>
 *
 * @param  format
 *         A format string as described in <a
 *         href="../util/Formatter.html#syntax">Format string syntax</a>
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
 * @return  This output stream
 *
 * @since  1.5
 * @apiSince 1
 */

public java.io.PrintStream printf(java.lang.String format, java.lang.Object... args) { throw new RuntimeException("Stub!"); }

/**
 * A convenience method to write a formatted string to this output stream
 * using the specified format string and arguments.
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
 *         href="../util/Formatter.html#syntax">Format string syntax</a>
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
 * @return  This output stream
 *
 * @since  1.5
 * @apiSince 1
 */

public java.io.PrintStream printf(java.util.Locale l, java.lang.String format, java.lang.Object... args) { throw new RuntimeException("Stub!"); }

/**
 * Writes a formatted string to this output stream using the specified
 * format string and arguments.
 *
 * <p> The locale always used is the one returned by {@link
 * java.util.Locale#getDefault() Locale.getDefault()}, regardless of any
 * previous invocations of other formatting methods on this object.
 *
 * @param  format
 *         A format string as described in <a
 *         href="../util/Formatter.html#syntax">Format string syntax</a>
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
 * @return  This output stream
 *
 * @since  1.5
 * @apiSince 1
 */

public java.io.PrintStream format(java.lang.String format, java.lang.Object... args) { throw new RuntimeException("Stub!"); }

/**
 * Writes a formatted string to this output stream using the specified
 * format string and arguments.
 *
 * @param  l
 *         The {@linkplain java.util.Locale locale} to apply during
 *         formatting.  If <tt>l</tt> is <tt>null</tt> then no localization
 *         is applied.
 *
 * @param  format
 *         A format string as described in <a
 *         href="../util/Formatter.html#syntax">Format string syntax</a>
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
 * @return  This output stream
 *
 * @since  1.5
 * @apiSince 1
 */

public java.io.PrintStream format(java.util.Locale l, java.lang.String format, java.lang.Object... args) { throw new RuntimeException("Stub!"); }

/**
 * Appends the specified character sequence to this output stream.
 *
 * <p> An invocation of this method of the form <tt>out.append(csq)</tt>
 * behaves in exactly the same way as the invocation
 *
 * <pre>
 *     out.print(csq.toString()) </pre>
 *
 * <p> Depending on the specification of <tt>toString</tt> for the
 * character sequence <tt>csq</tt>, the entire sequence may not be
 * appended.  For instance, invoking then <tt>toString</tt> method of a
 * character buffer will return a subsequence whose content depends upon
 * the buffer's position and limit.
 *
 * @param  csq
 *         The character sequence to append.  If <tt>csq</tt> is
 *         <tt>null</tt>, then the four characters <tt>"null"</tt> are
 *         appended to this output stream.
 *
 * @return  This output stream
 *
 * @since  1.5
 * @apiSince 1
 */

public java.io.PrintStream append(java.lang.CharSequence csq) { throw new RuntimeException("Stub!"); }

/**
 * Appends a subsequence of the specified character sequence to this output
 * stream.
 *
 * <p> An invocation of this method of the form <tt>out.append(csq, start,
 * end)</tt> when <tt>csq</tt> is not <tt>null</tt>, behaves in
 * exactly the same way as the invocation
 *
 * <pre>
 *     out.print(csq.subSequence(start, end).toString()) </pre>
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
 * @return  This output stream
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If <tt>start</tt> or <tt>end</tt> are negative, <tt>start</tt>
 *          is greater than <tt>end</tt>, or <tt>end</tt> is greater than
 *          <tt>csq.length()</tt>
 *
 * @since  1.5
 * @apiSince 1
 */

public java.io.PrintStream append(java.lang.CharSequence csq, int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Appends the specified character to this output stream.
 *
 * <p> An invocation of this method of the form <tt>out.append(c)</tt>
 * behaves in exactly the same way as the invocation
 *
 * <pre>
 *     out.print(c) </pre>
 *
 * @param  c
 *         The 16-bit character to append
 *
 * @return  This output stream
 *
 * @since  1.5
 * @apiSince 1
 */

public java.io.PrintStream append(char c) { throw new RuntimeException("Stub!"); }
}

