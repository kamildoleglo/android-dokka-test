/* //device/java/android/com/google/android/gles_jni/GLImpl.java
**
** Copyright 2006, The Android Open Source Project
**
** Licensed under the Apache License, Version 2.0 (the "License"); 
** you may not use this file except in compliance with the License. 
** You may obtain a copy of the License at 
**
**     http://www.apache.org/licenses/LICENSE-2.0 
**
** Unless required by applicable law or agreed to in writing, software 
** distributed under the License is distributed on an "AS IS" BASIS, 
** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
** See the License for the specific language governing permissions and 
** limitations under the License.
*/

// This source file is automatically generated


package com.google.android.gles_jni;


/** @apiSince R */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GLImpl implements javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.opengles.GL10Ext, javax.microedition.khronos.opengles.GL11, javax.microedition.khronos.opengles.GL11Ext, javax.microedition.khronos.opengles.GL11ExtensionPack {

/** @apiSince R */

public GLImpl() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public void glGetPointerv(int pname, java.nio.Buffer[] params) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public native void glActiveTexture(int texture);

/** @apiSince R */

public native void glAlphaFunc(int func, float ref);

/** @apiSince R */

public native void glAlphaFuncx(int func, int ref);

/** @apiSince R */

public native void glBindTexture(int target, int texture);

/** @apiSince R */

public native void glBlendFunc(int sfactor, int dfactor);

/** @apiSince R */

public native void glClear(int mask);

/** @apiSince R */

public native void glClearColor(float red, float green, float blue, float alpha);

/** @apiSince R */

public native void glClearColorx(int red, int green, int blue, int alpha);

/** @apiSince R */

public native void glClearDepthf(float depth);

/** @apiSince R */

public native void glClearDepthx(int depth);

/** @apiSince R */

public native void glClearStencil(int s);

/** @apiSince R */

public native void glClientActiveTexture(int texture);

/** @apiSince R */

public native void glColor4f(float red, float green, float blue, float alpha);

/** @apiSince R */

public native void glColor4x(int red, int green, int blue, int alpha);

/** @apiSince R */

public native void glColorMask(boolean red, boolean green, boolean blue, boolean alpha);

/** @apiSince R */

public void glColorPointer(int size, int type, int stride, java.nio.Buffer pointer) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public native void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, java.nio.Buffer data);

/** @apiSince R */

public native void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, java.nio.Buffer data);

/** @apiSince R */

public native void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border);

/** @apiSince R */

public native void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height);

/** @apiSince R */

public native void glCullFace(int mode);

/** @apiSince R */

public native void glDeleteTextures(int n, int[] textures, int offset);

/** @apiSince R */

public native void glDeleteTextures(int n, java.nio.IntBuffer textures);

/** @apiSince R */

public native void glDepthFunc(int func);

/** @apiSince R */

public native void glDepthMask(boolean flag);

/** @apiSince R */

public native void glDepthRangef(float zNear, float zFar);

/** @apiSince R */

public native void glDepthRangex(int zNear, int zFar);

/** @apiSince R */

public native void glDisable(int cap);

/** @apiSince R */

public native void glDisableClientState(int array);

/** @apiSince R */

public native void glDrawArrays(int mode, int first, int count);

/** @apiSince R */

public native void glDrawElements(int mode, int count, int type, java.nio.Buffer indices);

/** @apiSince R */

public native void glEnable(int cap);

/** @apiSince R */

public native void glEnableClientState(int array);

/** @apiSince R */

public native void glFinish();

/** @apiSince R */

public native void glFlush();

/** @apiSince R */

public native void glFogf(int pname, float param);

/** @apiSince R */

public native void glFogfv(int pname, float[] params, int offset);

/** @apiSince R */

public native void glFogfv(int pname, java.nio.FloatBuffer params);

/** @apiSince R */

public native void glFogx(int pname, int param);

/** @apiSince R */

public native void glFogxv(int pname, int[] params, int offset);

/** @apiSince R */

public native void glFogxv(int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glFrontFace(int mode);

/** @apiSince R */

public native void glFrustumf(float left, float right, float bottom, float top, float zNear, float zFar);

/** @apiSince R */

public native void glFrustumx(int left, int right, int bottom, int top, int zNear, int zFar);

/** @apiSince R */

public native void glGenTextures(int n, int[] textures, int offset);

/** @apiSince R */

public native void glGenTextures(int n, java.nio.IntBuffer textures);

/** @apiSince R */

public native int glGetError();

/** @apiSince R */

public native void glGetIntegerv(int pname, int[] params, int offset);

/** @apiSince R */

public native void glGetIntegerv(int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native java.lang.String _glGetString(int name);

/** @apiSince R */

public java.lang.String glGetString(int name) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public native void glHint(int target, int mode);

/** @apiSince R */

public native void glLightModelf(int pname, float param);

/** @apiSince R */

public native void glLightModelfv(int pname, float[] params, int offset);

/** @apiSince R */

public native void glLightModelfv(int pname, java.nio.FloatBuffer params);

/** @apiSince R */

public native void glLightModelx(int pname, int param);

/** @apiSince R */

public native void glLightModelxv(int pname, int[] params, int offset);

/** @apiSince R */

public native void glLightModelxv(int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glLightf(int light, int pname, float param);

/** @apiSince R */

public native void glLightfv(int light, int pname, float[] params, int offset);

/** @apiSince R */

public native void glLightfv(int light, int pname, java.nio.FloatBuffer params);

/** @apiSince R */

public native void glLightx(int light, int pname, int param);

/** @apiSince R */

public native void glLightxv(int light, int pname, int[] params, int offset);

/** @apiSince R */

public native void glLightxv(int light, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glLineWidth(float width);

/** @apiSince R */

public native void glLineWidthx(int width);

/** @apiSince R */

public native void glLoadIdentity();

/** @apiSince R */

public native void glLoadMatrixf(float[] m, int offset);

/** @apiSince R */

public native void glLoadMatrixf(java.nio.FloatBuffer m);

/** @apiSince R */

public native void glLoadMatrixx(int[] m, int offset);

/** @apiSince R */

public native void glLoadMatrixx(java.nio.IntBuffer m);

/** @apiSince R */

public native void glLogicOp(int opcode);

/** @apiSince R */

public native void glMaterialf(int face, int pname, float param);

/** @apiSince R */

public native void glMaterialfv(int face, int pname, float[] params, int offset);

/** @apiSince R */

public native void glMaterialfv(int face, int pname, java.nio.FloatBuffer params);

/** @apiSince R */

public native void glMaterialx(int face, int pname, int param);

/** @apiSince R */

public native void glMaterialxv(int face, int pname, int[] params, int offset);

/** @apiSince R */

public native void glMaterialxv(int face, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glMatrixMode(int mode);

/** @apiSince R */

public native void glMultMatrixf(float[] m, int offset);

/** @apiSince R */

public native void glMultMatrixf(java.nio.FloatBuffer m);

/** @apiSince R */

public native void glMultMatrixx(int[] m, int offset);

/** @apiSince R */

public native void glMultMatrixx(java.nio.IntBuffer m);

/** @apiSince R */

public native void glMultiTexCoord4f(int target, float s, float t, float r, float q);

/** @apiSince R */

public native void glMultiTexCoord4x(int target, int s, int t, int r, int q);

/** @apiSince R */

public native void glNormal3f(float nx, float ny, float nz);

/** @apiSince R */

public native void glNormal3x(int nx, int ny, int nz);

/** @apiSince R */

public void glNormalPointer(int type, int stride, java.nio.Buffer pointer) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public native void glOrthof(float left, float right, float bottom, float top, float zNear, float zFar);

/** @apiSince R */

public native void glOrthox(int left, int right, int bottom, int top, int zNear, int zFar);

/** @apiSince R */

public native void glPixelStorei(int pname, int param);

/** @apiSince R */

public native void glPointSize(float size);

/** @apiSince R */

public native void glPointSizex(int size);

/** @apiSince R */

public native void glPolygonOffset(float factor, float units);

/** @apiSince R */

public native void glPolygonOffsetx(int factor, int units);

/** @apiSince R */

public native void glPopMatrix();

/** @apiSince R */

public native void glPushMatrix();

/** @apiSince R */

public native void glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.Buffer pixels);

/** @apiSince R */

public native void glRotatef(float angle, float x, float y, float z);

/** @apiSince R */

public native void glRotatex(int angle, int x, int y, int z);

/** @apiSince R */

public native void glSampleCoverage(float value, boolean invert);

/** @apiSince R */

public native void glSampleCoveragex(int value, boolean invert);

/** @apiSince R */

public native void glScalef(float x, float y, float z);

/** @apiSince R */

public native void glScalex(int x, int y, int z);

/** @apiSince R */

public native void glScissor(int x, int y, int width, int height);

/** @apiSince R */

public native void glShadeModel(int mode);

/** @apiSince R */

public native void glStencilFunc(int func, int ref, int mask);

/** @apiSince R */

public native void glStencilMask(int mask);

/** @apiSince R */

public native void glStencilOp(int fail, int zfail, int zpass);

/** @apiSince R */

public void glTexCoordPointer(int size, int type, int stride, java.nio.Buffer pointer) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public native void glTexEnvf(int target, int pname, float param);

/** @apiSince R */

public native void glTexEnvfv(int target, int pname, float[] params, int offset);

/** @apiSince R */

public native void glTexEnvfv(int target, int pname, java.nio.FloatBuffer params);

/** @apiSince R */

public native void glTexEnvx(int target, int pname, int param);

/** @apiSince R */

public native void glTexEnvxv(int target, int pname, int[] params, int offset);

/** @apiSince R */

public native void glTexEnvxv(int target, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, java.nio.Buffer pixels);

/** @apiSince R */

public native void glTexParameterf(int target, int pname, float param);

/** @apiSince R */

public native void glTexParameterx(int target, int pname, int param);

/** @apiSince R */

public native void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, java.nio.Buffer pixels);

/** @apiSince R */

public native void glTranslatef(float x, float y, float z);

/** @apiSince R */

public native void glTranslatex(int x, int y, int z);

/** @apiSince R */

public void glVertexPointer(int size, int type, int stride, java.nio.Buffer pointer) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public native void glViewport(int x, int y, int width, int height);

/** @apiSince R */

public native int glQueryMatrixxOES(int[] mantissa, int mantissaOffset, int[] exponent, int exponentOffset);

/** @apiSince R */

public native int glQueryMatrixxOES(java.nio.IntBuffer mantissa, java.nio.IntBuffer exponent);

/** @apiSince R */

public native void glBindBuffer(int target, int buffer);

/** @apiSince R */

public native void glBufferData(int target, int size, java.nio.Buffer data, int usage);

/** @apiSince R */

public native void glBufferSubData(int target, int offset, int size, java.nio.Buffer data);

/** @apiSince R */

public native void glClipPlanef(int plane, float[] equation, int offset);

/** @apiSince R */

public native void glClipPlanef(int plane, java.nio.FloatBuffer equation);

/** @apiSince R */

public native void glClipPlanex(int plane, int[] equation, int offset);

/** @apiSince R */

public native void glClipPlanex(int plane, java.nio.IntBuffer equation);

/** @apiSince R */

public native void glColor4ub(byte red, byte green, byte blue, byte alpha);

/** @apiSince R */

public native void glColorPointer(int size, int type, int stride, int offset);

/** @apiSince R */

public native void glDeleteBuffers(int n, int[] buffers, int offset);

/** @apiSince R */

public native void glDeleteBuffers(int n, java.nio.IntBuffer buffers);

/** @apiSince R */

public native void glDrawElements(int mode, int count, int type, int offset);

/** @apiSince R */

public native void glGenBuffers(int n, int[] buffers, int offset);

/** @apiSince R */

public native void glGenBuffers(int n, java.nio.IntBuffer buffers);

/** @apiSince R */

public native void glGetBooleanv(int pname, boolean[] params, int offset);

/** @apiSince R */

public native void glGetBooleanv(int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glGetBufferParameteriv(int target, int pname, int[] params, int offset);

/** @apiSince R */

public native void glGetBufferParameteriv(int target, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glGetClipPlanef(int pname, float[] eqn, int offset);

/** @apiSince R */

public native void glGetClipPlanef(int pname, java.nio.FloatBuffer eqn);

/** @apiSince R */

public native void glGetClipPlanex(int pname, int[] eqn, int offset);

/** @apiSince R */

public native void glGetClipPlanex(int pname, java.nio.IntBuffer eqn);

/** @apiSince R */

public native void glGetFixedv(int pname, int[] params, int offset);

/** @apiSince R */

public native void glGetFixedv(int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glGetFloatv(int pname, float[] params, int offset);

/** @apiSince R */

public native void glGetFloatv(int pname, java.nio.FloatBuffer params);

/** @apiSince R */

public native void glGetLightfv(int light, int pname, float[] params, int offset);

/** @apiSince R */

public native void glGetLightfv(int light, int pname, java.nio.FloatBuffer params);

/** @apiSince R */

public native void glGetLightxv(int light, int pname, int[] params, int offset);

/** @apiSince R */

public native void glGetLightxv(int light, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glGetMaterialfv(int face, int pname, float[] params, int offset);

/** @apiSince R */

public native void glGetMaterialfv(int face, int pname, java.nio.FloatBuffer params);

/** @apiSince R */

public native void glGetMaterialxv(int face, int pname, int[] params, int offset);

/** @apiSince R */

public native void glGetMaterialxv(int face, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glGetTexEnviv(int env, int pname, int[] params, int offset);

/** @apiSince R */

public native void glGetTexEnviv(int env, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glGetTexEnvxv(int env, int pname, int[] params, int offset);

/** @apiSince R */

public native void glGetTexEnvxv(int env, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glGetTexParameterfv(int target, int pname, float[] params, int offset);

/** @apiSince R */

public native void glGetTexParameterfv(int target, int pname, java.nio.FloatBuffer params);

/** @apiSince R */

public native void glGetTexParameteriv(int target, int pname, int[] params, int offset);

/** @apiSince R */

public native void glGetTexParameteriv(int target, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glGetTexParameterxv(int target, int pname, int[] params, int offset);

/** @apiSince R */

public native void glGetTexParameterxv(int target, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native boolean glIsBuffer(int buffer);

/** @apiSince R */

public native boolean glIsEnabled(int cap);

/** @apiSince R */

public native boolean glIsTexture(int texture);

/** @apiSince R */

public native void glNormalPointer(int type, int stride, int offset);

/** @apiSince R */

public native void glPointParameterf(int pname, float param);

/** @apiSince R */

public native void glPointParameterfv(int pname, float[] params, int offset);

/** @apiSince R */

public native void glPointParameterfv(int pname, java.nio.FloatBuffer params);

/** @apiSince R */

public native void glPointParameterx(int pname, int param);

/** @apiSince R */

public native void glPointParameterxv(int pname, int[] params, int offset);

/** @apiSince R */

public native void glPointParameterxv(int pname, java.nio.IntBuffer params);

/** @apiSince R */

public void glPointSizePointerOES(int type, int stride, java.nio.Buffer pointer) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public native void glTexCoordPointer(int size, int type, int stride, int offset);

/** @apiSince R */

public native void glTexEnvi(int target, int pname, int param);

/** @apiSince R */

public native void glTexEnviv(int target, int pname, int[] params, int offset);

/** @apiSince R */

public native void glTexEnviv(int target, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glTexParameterfv(int target, int pname, float[] params, int offset);

/** @apiSince R */

public native void glTexParameterfv(int target, int pname, java.nio.FloatBuffer params);

/** @apiSince R */

public native void glTexParameteri(int target, int pname, int param);

/** @apiSince R */

public native void glTexParameteriv(int target, int pname, int[] params, int offset);

/** @apiSince R */

public native void glTexParameteriv(int target, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glTexParameterxv(int target, int pname, int[] params, int offset);

/** @apiSince R */

public native void glTexParameterxv(int target, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glVertexPointer(int size, int type, int stride, int offset);

/** @apiSince R */

public native void glCurrentPaletteMatrixOES(int matrixpaletteindex);

/** @apiSince R */

public native void glDrawTexfOES(float x, float y, float z, float width, float height);

/** @apiSince R */

public native void glDrawTexfvOES(float[] coords, int offset);

/** @apiSince R */

public native void glDrawTexfvOES(java.nio.FloatBuffer coords);

/** @apiSince R */

public native void glDrawTexiOES(int x, int y, int z, int width, int height);

/** @apiSince R */

public native void glDrawTexivOES(int[] coords, int offset);

/** @apiSince R */

public native void glDrawTexivOES(java.nio.IntBuffer coords);

/** @apiSince R */

public native void glDrawTexsOES(short x, short y, short z, short width, short height);

/** @apiSince R */

public native void glDrawTexsvOES(short[] coords, int offset);

/** @apiSince R */

public native void glDrawTexsvOES(java.nio.ShortBuffer coords);

/** @apiSince R */

public native void glDrawTexxOES(int x, int y, int z, int width, int height);

/** @apiSince R */

public native void glDrawTexxvOES(int[] coords, int offset);

/** @apiSince R */

public native void glDrawTexxvOES(java.nio.IntBuffer coords);

/** @apiSince R */

public native void glLoadPaletteFromModelViewMatrixOES();

/** @apiSince R */

public void glMatrixIndexPointerOES(int size, int type, int stride, java.nio.Buffer pointer) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public native void glMatrixIndexPointerOES(int size, int type, int stride, int offset);

/** @apiSince R */

public void glWeightPointerOES(int size, int type, int stride, java.nio.Buffer pointer) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public native void glWeightPointerOES(int size, int type, int stride, int offset);

/** @apiSince R */

public native void glBindFramebufferOES(int target, int framebuffer);

/** @apiSince R */

public native void glBindRenderbufferOES(int target, int renderbuffer);

/** @apiSince R */

public native void glBlendEquation(int mode);

/** @apiSince R */

public native void glBlendEquationSeparate(int modeRGB, int modeAlpha);

/** @apiSince R */

public native void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha);

/** @apiSince R */

public native int glCheckFramebufferStatusOES(int target);

/** @apiSince R */

public native void glDeleteFramebuffersOES(int n, int[] framebuffers, int offset);

/** @apiSince R */

public native void glDeleteFramebuffersOES(int n, java.nio.IntBuffer framebuffers);

/** @apiSince R */

public native void glDeleteRenderbuffersOES(int n, int[] renderbuffers, int offset);

/** @apiSince R */

public native void glDeleteRenderbuffersOES(int n, java.nio.IntBuffer renderbuffers);

/** @apiSince R */

public native void glFramebufferRenderbufferOES(int target, int attachment, int renderbuffertarget, int renderbuffer);

/** @apiSince R */

public native void glFramebufferTexture2DOES(int target, int attachment, int textarget, int texture, int level);

/** @apiSince R */

public native void glGenerateMipmapOES(int target);

/** @apiSince R */

public native void glGenFramebuffersOES(int n, int[] framebuffers, int offset);

/** @apiSince R */

public native void glGenFramebuffersOES(int n, java.nio.IntBuffer framebuffers);

/** @apiSince R */

public native void glGenRenderbuffersOES(int n, int[] renderbuffers, int offset);

/** @apiSince R */

public native void glGenRenderbuffersOES(int n, java.nio.IntBuffer renderbuffers);

/** @apiSince R */

public native void glGetFramebufferAttachmentParameterivOES(int target, int attachment, int pname, int[] params, int offset);

/** @apiSince R */

public native void glGetFramebufferAttachmentParameterivOES(int target, int attachment, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glGetRenderbufferParameterivOES(int target, int pname, int[] params, int offset);

/** @apiSince R */

public native void glGetRenderbufferParameterivOES(int target, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glGetTexGenfv(int coord, int pname, float[] params, int offset);

/** @apiSince R */

public native void glGetTexGenfv(int coord, int pname, java.nio.FloatBuffer params);

/** @apiSince R */

public native void glGetTexGeniv(int coord, int pname, int[] params, int offset);

/** @apiSince R */

public native void glGetTexGeniv(int coord, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glGetTexGenxv(int coord, int pname, int[] params, int offset);

/** @apiSince R */

public native void glGetTexGenxv(int coord, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native boolean glIsFramebufferOES(int framebuffer);

/** @apiSince R */

public native boolean glIsRenderbufferOES(int renderbuffer);

/** @apiSince R */

public native void glRenderbufferStorageOES(int target, int internalformat, int width, int height);

/** @apiSince R */

public native void glTexGenf(int coord, int pname, float param);

/** @apiSince R */

public native void glTexGenfv(int coord, int pname, float[] params, int offset);

/** @apiSince R */

public native void glTexGenfv(int coord, int pname, java.nio.FloatBuffer params);

/** @apiSince R */

public native void glTexGeni(int coord, int pname, int param);

/** @apiSince R */

public native void glTexGeniv(int coord, int pname, int[] params, int offset);

/** @apiSince R */

public native void glTexGeniv(int coord, int pname, java.nio.IntBuffer params);

/** @apiSince R */

public native void glTexGenx(int coord, int pname, int param);

/** @apiSince R */

public native void glTexGenxv(int coord, int pname, int[] params, int offset);

/** @apiSince R */

public native void glTexGenxv(int coord, int pname, java.nio.IntBuffer params);
}

