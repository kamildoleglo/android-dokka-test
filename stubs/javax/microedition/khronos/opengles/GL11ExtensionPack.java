/* //device/java/android/javax/microedition/khronos/opengles/GL11ExtensionPack.java
**
** Copyright 2007, The Android Open Source Project
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


package javax.microedition.khronos.opengles;


/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface GL11ExtensionPack extends javax.microedition.khronos.opengles.GL {

/** @apiSince 1 */

public void glBindFramebufferOES(int target, int framebuffer);

/** @apiSince 1 */

public void glBindRenderbufferOES(int target, int renderbuffer);

/** @apiSince 1 */

public void glBindTexture(int target, int texture);

/** @apiSince 1 */

public void glBlendEquation(int mode);

/** @apiSince 1 */

public void glBlendEquationSeparate(int modeRGB, int modeAlpha);

/** @apiSince 1 */

public void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha);

/** @apiSince 1 */

public int glCheckFramebufferStatusOES(int target);

/** @apiSince 1 */

public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, java.nio.Buffer data);

/** @apiSince 1 */

public void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border);

/** @apiSince 1 */

public void glDeleteFramebuffersOES(int n, int[] framebuffers, int offset);

/** @apiSince 1 */

public void glDeleteFramebuffersOES(int n, java.nio.IntBuffer framebuffers);

/** @apiSince 1 */

public void glDeleteRenderbuffersOES(int n, int[] renderbuffers, int offset);

/** @apiSince 1 */

public void glDeleteRenderbuffersOES(int n, java.nio.IntBuffer renderbuffers);

/** @apiSince 1 */

public void glEnable(int cap);

/** @apiSince 1 */

public void glFramebufferRenderbufferOES(int target, int attachment, int renderbuffertarget, int renderbuffer);

/** @apiSince 1 */

public void glFramebufferTexture2DOES(int target, int attachment, int textarget, int texture, int level);

/** @apiSince 1 */

public void glGenerateMipmapOES(int target);

/** @apiSince 1 */

public void glGenFramebuffersOES(int n, int[] framebuffers, int offset);

/** @apiSince 1 */

public void glGenFramebuffersOES(int n, java.nio.IntBuffer framebuffers);

/** @apiSince 1 */

public void glGenRenderbuffersOES(int n, int[] renderbuffers, int offset);

/** @apiSince 1 */

public void glGenRenderbuffersOES(int n, java.nio.IntBuffer renderbuffers);

/** @apiSince 1 */

public void glGetFramebufferAttachmentParameterivOES(int target, int attachment, int pname, int[] params, int offset);

/** @apiSince 1 */

public void glGetFramebufferAttachmentParameterivOES(int target, int attachment, int pname, java.nio.IntBuffer params);

/** @apiSince 1 */

public void glGetIntegerv(int pname, int[] params, int offset);

/** @apiSince 1 */

public void glGetIntegerv(int pname, java.nio.IntBuffer params);

/** @apiSince 1 */

public void glGetRenderbufferParameterivOES(int target, int pname, int[] params, int offset);

/** @apiSince 1 */

public void glGetRenderbufferParameterivOES(int target, int pname, java.nio.IntBuffer params);

/** @apiSince 1 */

public void glGetTexGenfv(int coord, int pname, float[] params, int offset);

/** @apiSince 1 */

public void glGetTexGenfv(int coord, int pname, java.nio.FloatBuffer params);

/** @apiSince 1 */

public void glGetTexGeniv(int coord, int pname, int[] params, int offset);

/** @apiSince 1 */

public void glGetTexGeniv(int coord, int pname, java.nio.IntBuffer params);

/** @apiSince 1 */

public void glGetTexGenxv(int coord, int pname, int[] params, int offset);

/** @apiSince 1 */

public void glGetTexGenxv(int coord, int pname, java.nio.IntBuffer params);

/** @apiSince 1 */

public boolean glIsFramebufferOES(int framebuffer);

/** @apiSince 1 */

public boolean glIsRenderbufferOES(int renderbuffer);

/** @apiSince 1 */

public void glRenderbufferStorageOES(int target, int internalformat, int width, int height);

/** @apiSince 1 */

public void glStencilOp(int fail, int zfail, int zpass);

/** @apiSince 1 */

public void glTexEnvf(int target, int pname, float param);

/** @apiSince 1 */

public void glTexEnvfv(int target, int pname, float[] params, int offset);

/** @apiSince 1 */

public void glTexEnvfv(int target, int pname, java.nio.FloatBuffer params);

/** @apiSince 1 */

public void glTexEnvx(int target, int pname, int param);

/** @apiSince 1 */

public void glTexEnvxv(int target, int pname, int[] params, int offset);

/** @apiSince 1 */

public void glTexEnvxv(int target, int pname, java.nio.IntBuffer params);

/** @apiSince 1 */

public void glTexGenf(int coord, int pname, float param);

/** @apiSince 1 */

public void glTexGenfv(int coord, int pname, float[] params, int offset);

/** @apiSince 1 */

public void glTexGenfv(int coord, int pname, java.nio.FloatBuffer params);

/** @apiSince 1 */

public void glTexGeni(int coord, int pname, int param);

/** @apiSince 1 */

public void glTexGeniv(int coord, int pname, int[] params, int offset);

/** @apiSince 1 */

public void glTexGeniv(int coord, int pname, java.nio.IntBuffer params);

/** @apiSince 1 */

public void glTexGenx(int coord, int pname, int param);

/** @apiSince 1 */

public void glTexGenxv(int coord, int pname, int[] params, int offset);

/** @apiSince 1 */

public void glTexGenxv(int coord, int pname, java.nio.IntBuffer params);

/** @apiSince 1 */

public void glTexParameterf(int target, int pname, float param);

/** @apiSince 1 */

public static final int GL_BLEND_DST_ALPHA = 32970; // 0x80ca

/** @apiSince 1 */

public static final int GL_BLEND_DST_RGB = 32968; // 0x80c8

/** @apiSince 1 */

public static final int GL_BLEND_EQUATION = 32777; // 0x8009

/** @apiSince 1 */

public static final int GL_BLEND_EQUATION_ALPHA = 34877; // 0x883d

/** @apiSince 1 */

public static final int GL_BLEND_EQUATION_RGB = 32777; // 0x8009

/** @apiSince 1 */

public static final int GL_BLEND_SRC_ALPHA = 32971; // 0x80cb

/** @apiSince 1 */

public static final int GL_BLEND_SRC_RGB = 32969; // 0x80c9

/** @apiSince 1 */

public static final int GL_COLOR_ATTACHMENT0_OES = 36064; // 0x8ce0

/** @apiSince 1 */

public static final int GL_COLOR_ATTACHMENT10_OES = 36074; // 0x8cea

/** @apiSince 1 */

public static final int GL_COLOR_ATTACHMENT11_OES = 36075; // 0x8ceb

/** @apiSince 1 */

public static final int GL_COLOR_ATTACHMENT12_OES = 36076; // 0x8cec

/** @apiSince 1 */

public static final int GL_COLOR_ATTACHMENT13_OES = 36077; // 0x8ced

/** @apiSince 1 */

public static final int GL_COLOR_ATTACHMENT14_OES = 36078; // 0x8cee

/** @apiSince 1 */

public static final int GL_COLOR_ATTACHMENT15_OES = 36079; // 0x8cef

/** @apiSince 1 */

public static final int GL_COLOR_ATTACHMENT1_OES = 36065; // 0x8ce1

/** @apiSince 1 */

public static final int GL_COLOR_ATTACHMENT2_OES = 36066; // 0x8ce2

/** @apiSince 1 */

public static final int GL_COLOR_ATTACHMENT3_OES = 36067; // 0x8ce3

/** @apiSince 1 */

public static final int GL_COLOR_ATTACHMENT4_OES = 36068; // 0x8ce4

/** @apiSince 1 */

public static final int GL_COLOR_ATTACHMENT5_OES = 36069; // 0x8ce5

/** @apiSince 1 */

public static final int GL_COLOR_ATTACHMENT6_OES = 36070; // 0x8ce6

/** @apiSince 1 */

public static final int GL_COLOR_ATTACHMENT7_OES = 36071; // 0x8ce7

/** @apiSince 1 */

public static final int GL_COLOR_ATTACHMENT8_OES = 36072; // 0x8ce8

/** @apiSince 1 */

public static final int GL_COLOR_ATTACHMENT9_OES = 36073; // 0x8ce9

/** @apiSince 1 */

public static final int GL_DECR_WRAP = 34056; // 0x8508

/** @apiSince 1 */

public static final int GL_DEPTH_ATTACHMENT_OES = 36096; // 0x8d00

/** @apiSince 1 */

public static final int GL_DEPTH_COMPONENT = 6402; // 0x1902

/** @apiSince 1 */

public static final int GL_DEPTH_COMPONENT16 = 33189; // 0x81a5

/** @apiSince 1 */

public static final int GL_DEPTH_COMPONENT24 = 33190; // 0x81a6

/** @apiSince 1 */

public static final int GL_DEPTH_COMPONENT32 = 33191; // 0x81a7

/** @apiSince 1 */

public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME_OES = 36049; // 0x8cd1

/** @apiSince 1 */

public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE_OES = 36048; // 0x8cd0

/** @apiSince 1 */

public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE_OES = 36051; // 0x8cd3

/** @apiSince 1 */

public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL_OES = 36050; // 0x8cd2

/** @apiSince 1 */

public static final int GL_FRAMEBUFFER_BINDING_OES = 36006; // 0x8ca6

/** @apiSince 1 */

public static final int GL_FRAMEBUFFER_COMPLETE_OES = 36053; // 0x8cd5

/** @apiSince 1 */

public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_OES = 36054; // 0x8cd6

/** @apiSince 1 */

public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_OES = 36057; // 0x8cd9

/** @apiSince 1 */

public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_OES = 36059; // 0x8cdb

/** @apiSince 1 */

public static final int GL_FRAMEBUFFER_INCOMPLETE_FORMATS_OES = 36058; // 0x8cda

/** @apiSince 1 */

public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_OES = 36055; // 0x8cd7

/** @apiSince 1 */

public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER_OES = 36060; // 0x8cdc

/** @apiSince 1 */

public static final int GL_FRAMEBUFFER_OES = 36160; // 0x8d40

/** @apiSince 1 */

public static final int GL_FRAMEBUFFER_UNSUPPORTED_OES = 36061; // 0x8cdd

/** @apiSince 1 */

public static final int GL_FUNC_ADD = 32774; // 0x8006

/** @apiSince 1 */

public static final int GL_FUNC_REVERSE_SUBTRACT = 32779; // 0x800b

/** @apiSince 1 */

public static final int GL_FUNC_SUBTRACT = 32778; // 0x800a

/** @apiSince 1 */

public static final int GL_INCR_WRAP = 34055; // 0x8507

/** @apiSince 1 */

public static final int GL_INVALID_FRAMEBUFFER_OPERATION_OES = 1286; // 0x506

/** @apiSince 1 */

public static final int GL_MAX_COLOR_ATTACHMENTS_OES = 36063; // 0x8cdf

/** @apiSince 1 */

public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE = 34076; // 0x851c

/** @apiSince 1 */

public static final int GL_MAX_RENDERBUFFER_SIZE_OES = 34024; // 0x84e8

/** @apiSince 1 */

public static final int GL_MIRRORED_REPEAT = 33648; // 0x8370

/** @apiSince 1 */

public static final int GL_NORMAL_MAP = 34065; // 0x8511

/** @apiSince 1 */

public static final int GL_REFLECTION_MAP = 34066; // 0x8512

/** @apiSince 1 */

public static final int GL_RENDERBUFFER_ALPHA_SIZE_OES = 36179; // 0x8d53

/** @apiSince 1 */

public static final int GL_RENDERBUFFER_BINDING_OES = 36007; // 0x8ca7

/** @apiSince 1 */

public static final int GL_RENDERBUFFER_BLUE_SIZE_OES = 36178; // 0x8d52

/** @apiSince 1 */

public static final int GL_RENDERBUFFER_DEPTH_SIZE_OES = 36180; // 0x8d54

/** @apiSince 1 */

public static final int GL_RENDERBUFFER_GREEN_SIZE_OES = 36177; // 0x8d51

/** @apiSince 1 */

public static final int GL_RENDERBUFFER_HEIGHT_OES = 36163; // 0x8d43

/** @apiSince 1 */

public static final int GL_RENDERBUFFER_INTERNAL_FORMAT_OES = 36164; // 0x8d44

/** @apiSince 1 */

public static final int GL_RENDERBUFFER_OES = 36161; // 0x8d41

/** @apiSince 1 */

public static final int GL_RENDERBUFFER_RED_SIZE_OES = 36176; // 0x8d50

/** @apiSince 1 */

public static final int GL_RENDERBUFFER_STENCIL_SIZE_OES = 36181; // 0x8d55

/** @apiSince 1 */

public static final int GL_RENDERBUFFER_WIDTH_OES = 36162; // 0x8d42

/** @apiSince 1 */

public static final int GL_RGB565_OES = 36194; // 0x8d62

/** @apiSince 1 */

public static final int GL_RGB5_A1 = 32855; // 0x8057

/** @apiSince 1 */

public static final int GL_RGB8 = 32849; // 0x8051

/** @apiSince 1 */

public static final int GL_RGBA4 = 32854; // 0x8056

/** @apiSince 1 */

public static final int GL_RGBA8 = 32856; // 0x8058

/** @apiSince 1 */

public static final int GL_STENCIL_ATTACHMENT_OES = 36128; // 0x8d20

/** @apiSince 1 */

public static final int GL_STENCIL_INDEX = 6401; // 0x1901

/** @apiSince 1 */

public static final int GL_STENCIL_INDEX1_OES = 36166; // 0x8d46

/** @apiSince 1 */

public static final int GL_STENCIL_INDEX4_OES = 36167; // 0x8d47

/** @apiSince 1 */

public static final int GL_STENCIL_INDEX8_OES = 36168; // 0x8d48

/** @apiSince 1 */

public static final int GL_STR = -1; // 0xffffffff

/** @apiSince 1 */

public static final int GL_TEXTURE_BINDING_CUBE_MAP = 34068; // 0x8514

/** @apiSince 1 */

public static final int GL_TEXTURE_CUBE_MAP = 34067; // 0x8513

/** @apiSince 1 */

public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 34070; // 0x8516

/** @apiSince 1 */

public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 34072; // 0x8518

/** @apiSince 1 */

public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 34074; // 0x851a

/** @apiSince 1 */

public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X = 34069; // 0x8515

/** @apiSince 1 */

public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 34071; // 0x8517

/** @apiSince 1 */

public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 34073; // 0x8519

/** @apiSince 1 */

public static final int GL_TEXTURE_GEN_MODE = 9472; // 0x2500

/** @apiSince 1 */

public static final int GL_TEXTURE_GEN_STR = 36192; // 0x8d60
}

