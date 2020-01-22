/*
 * Copyright 2015 The Android Open Source Project
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

// This source file is automatically generated


package android.opengl;


/** OpenGL ES 3.2
 @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GLES32 extends android.opengl.GLES31 {

private GLES32() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public static native void glBlendBarrier();

/** @apiSince 24 */

public static native void glCopyImageSubData(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth);

/** @apiSince 24 */

public static native void glDebugMessageControl(int source, int type, int severity, int count, int[] ids, int offset, boolean enabled);

/** @apiSince 24 */

public static native void glDebugMessageControl(int source, int type, int severity, int count, java.nio.IntBuffer ids, boolean enabled);

/** @apiSince 24 */

public static native void glDebugMessageInsert(int source, int type, int id, int severity, int length, java.lang.String buf);

/** @apiSince 24 */

public static native void glDebugMessageCallback(android.opengl.GLES32.DebugProc callback);

/** @apiSince 24 */

public static native int glGetDebugMessageLog(int count, int bufSize, int[] sources, int sourcesOffset, int[] types, int typesOffset, int[] ids, int idsOffset, int[] severities, int severitiesOffset, int[] lengths, int lengthsOffset, byte[] messageLog, int messageLogOffset);

/** @apiSince 24 */

public static native int glGetDebugMessageLog(int count, java.nio.IntBuffer sources, java.nio.IntBuffer types, java.nio.IntBuffer ids, java.nio.IntBuffer severities, java.nio.IntBuffer lengths, java.nio.ByteBuffer messageLog);

/** @apiSince 24 */

public static native java.lang.String[] glGetDebugMessageLog(int count, int[] sources, int sourcesOffset, int[] types, int typesOffset, int[] ids, int idsOffset, int[] severities, int severitiesOffset);

/** @apiSince 24 */

public static native java.lang.String[] glGetDebugMessageLog(int count, java.nio.IntBuffer sources, java.nio.IntBuffer types, java.nio.IntBuffer ids, java.nio.IntBuffer severities);

/** @apiSince 24 */

public static native void glPushDebugGroup(int source, int id, int length, java.lang.String message);

/** @apiSince 24 */

public static native void glPopDebugGroup();

/** @apiSince 24 */

public static native void glObjectLabel(int identifier, int name, int length, java.lang.String label);

/** @apiSince 24 */

public static native java.lang.String glGetObjectLabel(int identifier, int name);

/** @apiSince 24 */

public static native void glObjectPtrLabel(long ptr, java.lang.String label);

/** @apiSince 24 */

public static native java.lang.String glGetObjectPtrLabel(long ptr);

/** @apiSince 24 */

public static native long glGetPointerv(int pname);

/** @apiSince 24 */

public static native void glEnablei(int target, int index);

/** @apiSince 24 */

public static native void glDisablei(int target, int index);

/** @apiSince 24 */

public static native void glBlendEquationi(int buf, int mode);

/** @apiSince 24 */

public static native void glBlendEquationSeparatei(int buf, int modeRGB, int modeAlpha);

/** @apiSince 24 */

public static native void glBlendFunci(int buf, int src, int dst);

/** @apiSince 24 */

public static native void glBlendFuncSeparatei(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha);

/** @apiSince 24 */

public static native void glColorMaski(int index, boolean r, boolean g, boolean b, boolean a);

/** @apiSince 24 */

public static native boolean glIsEnabledi(int target, int index);

/** @apiSince 24 */

public static native void glDrawElementsBaseVertex(int mode, int count, int type, java.nio.Buffer indices, int basevertex);

/** @apiSince 24 */

public static native void glDrawRangeElementsBaseVertex(int mode, int start, int end, int count, int type, java.nio.Buffer indices, int basevertex);

/** @apiSince 24 */

public static native void glDrawElementsInstancedBaseVertex(int mode, int count, int type, java.nio.Buffer indices, int instanceCount, int basevertex);

/** @apiSince 24 */

public static native void glDrawElementsInstancedBaseVertex(int mode, int count, int type, int indicesOffset, int instanceCount, int basevertex);

/** @apiSince 24 */

public static native void glFramebufferTexture(int target, int attachment, int texture, int level);

/** @apiSince 24 */

public static native void glPrimitiveBoundingBox(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW);

/** @apiSince 24 */

public static native int glGetGraphicsResetStatus();

/** @apiSince 24 */

public static native void glReadnPixels(int x, int y, int width, int height, int format, int type, int bufSize, java.nio.Buffer data);

/** @apiSince 24 */

public static native void glGetnUniformfv(int program, int location, int bufSize, float[] params, int offset);

/** @apiSince 24 */

public static native void glGetnUniformfv(int program, int location, int bufSize, java.nio.FloatBuffer params);

/** @apiSince 24 */

public static native void glGetnUniformiv(int program, int location, int bufSize, int[] params, int offset);

/** @apiSince 24 */

public static native void glGetnUniformiv(int program, int location, int bufSize, java.nio.IntBuffer params);

/** @apiSince 24 */

public static native void glGetnUniformuiv(int program, int location, int bufSize, int[] params, int offset);

/** @apiSince 24 */

public static native void glGetnUniformuiv(int program, int location, int bufSize, java.nio.IntBuffer params);

/** @apiSince 24 */

public static native void glMinSampleShading(float value);

/** @apiSince 24 */

public static native void glPatchParameteri(int pname, int value);

/** @apiSince 24 */

public static native void glTexParameterIiv(int target, int pname, int[] params, int offset);

/** @apiSince 24 */

public static native void glTexParameterIiv(int target, int pname, java.nio.IntBuffer params);

/** @apiSince 24 */

public static native void glTexParameterIuiv(int target, int pname, int[] params, int offset);

/** @apiSince 24 */

public static native void glTexParameterIuiv(int target, int pname, java.nio.IntBuffer params);

/** @apiSince 24 */

public static native void glGetTexParameterIiv(int target, int pname, int[] params, int offset);

/** @apiSince 24 */

public static native void glGetTexParameterIiv(int target, int pname, java.nio.IntBuffer params);

/** @apiSince 24 */

public static native void glGetTexParameterIuiv(int target, int pname, int[] params, int offset);

/** @apiSince 24 */

public static native void glGetTexParameterIuiv(int target, int pname, java.nio.IntBuffer params);

/** @apiSince 24 */

public static native void glSamplerParameterIiv(int sampler, int pname, int[] param, int offset);

/** @apiSince 24 */

public static native void glSamplerParameterIiv(int sampler, int pname, java.nio.IntBuffer param);

/** @apiSince 24 */

public static native void glSamplerParameterIuiv(int sampler, int pname, int[] param, int offset);

/** @apiSince 24 */

public static native void glSamplerParameterIuiv(int sampler, int pname, java.nio.IntBuffer param);

/** @apiSince 24 */

public static native void glGetSamplerParameterIiv(int sampler, int pname, int[] params, int offset);

/** @apiSince 24 */

public static native void glGetSamplerParameterIiv(int sampler, int pname, java.nio.IntBuffer params);

/** @apiSince 24 */

public static native void glGetSamplerParameterIuiv(int sampler, int pname, int[] params, int offset);

/** @apiSince 24 */

public static native void glGetSamplerParameterIuiv(int sampler, int pname, java.nio.IntBuffer params);

/** @apiSince 24 */

public static native void glTexBuffer(int target, int internalformat, int buffer);

/** @apiSince 24 */

public static native void glTexBufferRange(int target, int internalformat, int buffer, int offset, int size);

/** @apiSince 24 */

public static native void glTexStorage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, boolean fixedsamplelocations);

/** @apiSince 24 */

public static final int GL_BUFFER = 33504; // 0x82e0

/** @apiSince 24 */

public static final int GL_CLAMP_TO_BORDER = 33069; // 0x812d

/** @apiSince 24 */

public static final int GL_COLORBURN = 37530; // 0x929a

/** @apiSince 24 */

public static final int GL_COLORDODGE = 37529; // 0x9299

/** @apiSince 24 */

public static final int GL_COMPRESSED_RGBA_ASTC_10x10 = 37819; // 0x93bb

/** @apiSince 24 */

public static final int GL_COMPRESSED_RGBA_ASTC_10x5 = 37816; // 0x93b8

/** @apiSince 24 */

public static final int GL_COMPRESSED_RGBA_ASTC_10x6 = 37817; // 0x93b9

/** @apiSince 24 */

public static final int GL_COMPRESSED_RGBA_ASTC_10x8 = 37818; // 0x93ba

/** @apiSince 24 */

public static final int GL_COMPRESSED_RGBA_ASTC_12x10 = 37820; // 0x93bc

/** @apiSince 24 */

public static final int GL_COMPRESSED_RGBA_ASTC_12x12 = 37821; // 0x93bd

/** @apiSince 24 */

public static final int GL_COMPRESSED_RGBA_ASTC_4x4 = 37808; // 0x93b0

/** @apiSince 24 */

public static final int GL_COMPRESSED_RGBA_ASTC_5x4 = 37809; // 0x93b1

/** @apiSince 24 */

public static final int GL_COMPRESSED_RGBA_ASTC_5x5 = 37810; // 0x93b2

/** @apiSince 24 */

public static final int GL_COMPRESSED_RGBA_ASTC_6x5 = 37811; // 0x93b3

/** @apiSince 24 */

public static final int GL_COMPRESSED_RGBA_ASTC_6x6 = 37812; // 0x93b4

/** @apiSince 24 */

public static final int GL_COMPRESSED_RGBA_ASTC_8x5 = 37813; // 0x93b5

/** @apiSince 24 */

public static final int GL_COMPRESSED_RGBA_ASTC_8x6 = 37814; // 0x93b6

/** @apiSince 24 */

public static final int GL_COMPRESSED_RGBA_ASTC_8x8 = 37815; // 0x93b7

/** @apiSince 24 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x10 = 37851; // 0x93db

/** @apiSince 24 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x5 = 37848; // 0x93d8

/** @apiSince 24 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x6 = 37849; // 0x93d9

/** @apiSince 24 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x8 = 37850; // 0x93da

/** @apiSince 24 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_12x10 = 37852; // 0x93dc

/** @apiSince 24 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_12x12 = 37853; // 0x93dd

/** @apiSince 24 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_4x4 = 37840; // 0x93d0

/** @apiSince 24 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_5x4 = 37841; // 0x93d1

/** @apiSince 24 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_5x5 = 37842; // 0x93d2

/** @apiSince 24 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_6x5 = 37843; // 0x93d3

/** @apiSince 24 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_6x6 = 37844; // 0x93d4

/** @apiSince 24 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_8x5 = 37845; // 0x93d5

/** @apiSince 24 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_8x6 = 37846; // 0x93d6

/** @apiSince 24 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_8x8 = 37847; // 0x93d7

/** @apiSince 24 */

public static final int GL_CONTEXT_FLAGS = 33310; // 0x821e

/** @apiSince 24 */

public static final int GL_CONTEXT_FLAG_DEBUG_BIT = 2; // 0x2

/** @apiSince 24 */

public static final int GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT = 4; // 0x4

/** @apiSince 24 */

public static final int GL_CONTEXT_LOST = 1287; // 0x507

/** @apiSince 24 */

public static final int GL_DARKEN = 37527; // 0x9297

/** @apiSince 24 */

public static final int GL_DEBUG_CALLBACK_FUNCTION = 33348; // 0x8244

/** @apiSince 24 */

public static final int GL_DEBUG_CALLBACK_USER_PARAM = 33349; // 0x8245

/** @apiSince 24 */

public static final int GL_DEBUG_GROUP_STACK_DEPTH = 33389; // 0x826d

/** @apiSince 24 */

public static final int GL_DEBUG_LOGGED_MESSAGES = 37189; // 0x9145

/** @apiSince 24 */

public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH = 33347; // 0x8243

/** @apiSince 24 */

public static final int GL_DEBUG_OUTPUT = 37600; // 0x92e0

/** @apiSince 24 */

public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS = 33346; // 0x8242

/** @apiSince 24 */

public static final int GL_DEBUG_SEVERITY_HIGH = 37190; // 0x9146

/** @apiSince 24 */

public static final int GL_DEBUG_SEVERITY_LOW = 37192; // 0x9148

/** @apiSince 24 */

public static final int GL_DEBUG_SEVERITY_MEDIUM = 37191; // 0x9147

/** @apiSince 24 */

public static final int GL_DEBUG_SEVERITY_NOTIFICATION = 33387; // 0x826b

/** @apiSince 24 */

public static final int GL_DEBUG_SOURCE_API = 33350; // 0x8246

/** @apiSince 24 */

public static final int GL_DEBUG_SOURCE_APPLICATION = 33354; // 0x824a

/** @apiSince 24 */

public static final int GL_DEBUG_SOURCE_OTHER = 33355; // 0x824b

/** @apiSince 24 */

public static final int GL_DEBUG_SOURCE_SHADER_COMPILER = 33352; // 0x8248

/** @apiSince 24 */

public static final int GL_DEBUG_SOURCE_THIRD_PARTY = 33353; // 0x8249

/** @apiSince 24 */

public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM = 33351; // 0x8247

/** @apiSince 24 */

public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 33357; // 0x824d

/** @apiSince 24 */

public static final int GL_DEBUG_TYPE_ERROR = 33356; // 0x824c

/** @apiSince 24 */

public static final int GL_DEBUG_TYPE_MARKER = 33384; // 0x8268

/** @apiSince 24 */

public static final int GL_DEBUG_TYPE_OTHER = 33361; // 0x8251

/** @apiSince 24 */

public static final int GL_DEBUG_TYPE_PERFORMANCE = 33360; // 0x8250

/** @apiSince 24 */

public static final int GL_DEBUG_TYPE_POP_GROUP = 33386; // 0x826a

/** @apiSince 24 */

public static final int GL_DEBUG_TYPE_PORTABILITY = 33359; // 0x824f

/** @apiSince 24 */

public static final int GL_DEBUG_TYPE_PUSH_GROUP = 33385; // 0x8269

/** @apiSince 24 */

public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 33358; // 0x824e

/** @apiSince 24 */

public static final int GL_DIFFERENCE = 37534; // 0x929e

/** @apiSince 24 */

public static final int GL_EXCLUSION = 37536; // 0x92a0

/** @apiSince 24 */

public static final int GL_FIRST_VERTEX_CONVENTION = 36429; // 0x8e4d

/** @apiSince 24 */

public static final int GL_FRACTIONAL_EVEN = 36476; // 0x8e7c

/** @apiSince 24 */

public static final int GL_FRACTIONAL_ODD = 36475; // 0x8e7b

/** @apiSince 24 */

public static final int GL_FRAGMENT_INTERPOLATION_OFFSET_BITS = 36445; // 0x8e5d

/** @apiSince 24 */

public static final int GL_FRAMEBUFFER_ATTACHMENT_LAYERED = 36263; // 0x8da7

/** @apiSince 24 */

public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 37650; // 0x9312

/** @apiSince 24 */

public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS = 36264; // 0x8da8

/** @apiSince 24 */

public static final int GL_GEOMETRY_INPUT_TYPE = 35095; // 0x8917

/** @apiSince 24 */

public static final int GL_GEOMETRY_OUTPUT_TYPE = 35096; // 0x8918

/** @apiSince 24 */

public static final int GL_GEOMETRY_SHADER = 36313; // 0x8dd9

/** @apiSince 24 */

public static final int GL_GEOMETRY_SHADER_BIT = 4; // 0x4

/** @apiSince 24 */

public static final int GL_GEOMETRY_SHADER_INVOCATIONS = 34943; // 0x887f

/** @apiSince 24 */

public static final int GL_GEOMETRY_VERTICES_OUT = 35094; // 0x8916

/** @apiSince 24 */

public static final int GL_GUILTY_CONTEXT_RESET = 33363; // 0x8253

/** @apiSince 24 */

public static final int GL_HARDLIGHT = 37531; // 0x929b

/** @apiSince 24 */

public static final int GL_HSL_COLOR = 37551; // 0x92af

/** @apiSince 24 */

public static final int GL_HSL_HUE = 37549; // 0x92ad

/** @apiSince 24 */

public static final int GL_HSL_LUMINOSITY = 37552; // 0x92b0

/** @apiSince 24 */

public static final int GL_HSL_SATURATION = 37550; // 0x92ae

/** @apiSince 24 */

public static final int GL_IMAGE_BUFFER = 36945; // 0x9051

/** @apiSince 24 */

public static final int GL_IMAGE_CUBE_MAP_ARRAY = 36948; // 0x9054

/** @apiSince 24 */

public static final int GL_INNOCENT_CONTEXT_RESET = 33364; // 0x8254

/** @apiSince 24 */

public static final int GL_INT_IMAGE_BUFFER = 36956; // 0x905c

/** @apiSince 24 */

public static final int GL_INT_IMAGE_CUBE_MAP_ARRAY = 36959; // 0x905f

/** @apiSince 24 */

public static final int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37132; // 0x910c

/** @apiSince 24 */

public static final int GL_INT_SAMPLER_BUFFER = 36304; // 0x8dd0

/** @apiSince 24 */

public static final int GL_INT_SAMPLER_CUBE_MAP_ARRAY = 36878; // 0x900e

/** @apiSince 24 */

public static final int GL_ISOLINES = 36474; // 0x8e7a

/** @apiSince 24 */

public static final int GL_IS_PER_PATCH = 37607; // 0x92e7

/** @apiSince 24 */

public static final int GL_LAST_VERTEX_CONVENTION = 36430; // 0x8e4e

/** @apiSince 24 */

public static final int GL_LAYER_PROVOKING_VERTEX = 33374; // 0x825e

/** @apiSince 24 */

public static final int GL_LIGHTEN = 37528; // 0x9298

/** @apiSince 24 */

public static final int GL_LINES_ADJACENCY = 10; // 0xa

/** @apiSince 24 */

public static final int GL_LINE_STRIP_ADJACENCY = 11; // 0xb

/** @apiSince 24 */

public static final int GL_LOSE_CONTEXT_ON_RESET = 33362; // 0x8252

/** @apiSince 24 */

public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 35378; // 0x8a32

/** @apiSince 24 */

public static final int GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS = 36382; // 0x8e1e

/** @apiSince 24 */

public static final int GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS = 36383; // 0x8e1f

/** @apiSince 24 */

public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH = 33388; // 0x826c

/** @apiSince 24 */

public static final int GL_MAX_DEBUG_LOGGED_MESSAGES = 37188; // 0x9144

/** @apiSince 24 */

public static final int GL_MAX_DEBUG_MESSAGE_LENGTH = 37187; // 0x9143

/** @apiSince 24 */

public static final int GL_MAX_FRAGMENT_INTERPOLATION_OFFSET = 36444; // 0x8e5c

/** @apiSince 24 */

public static final int GL_MAX_FRAMEBUFFER_LAYERS = 37655; // 0x9317

/** @apiSince 24 */

public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTERS = 37589; // 0x92d5

/** @apiSince 24 */

public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTER_BUFFERS = 37583; // 0x92cf

/** @apiSince 24 */

public static final int GL_MAX_GEOMETRY_IMAGE_UNIFORMS = 37069; // 0x90cd

/** @apiSince 24 */

public static final int GL_MAX_GEOMETRY_INPUT_COMPONENTS = 37155; // 0x9123

/** @apiSince 24 */

public static final int GL_MAX_GEOMETRY_OUTPUT_COMPONENTS = 37156; // 0x9124

/** @apiSince 24 */

public static final int GL_MAX_GEOMETRY_OUTPUT_VERTICES = 36320; // 0x8de0

/** @apiSince 24 */

public static final int GL_MAX_GEOMETRY_SHADER_INVOCATIONS = 36442; // 0x8e5a

/** @apiSince 24 */

public static final int GL_MAX_GEOMETRY_SHADER_STORAGE_BLOCKS = 37079; // 0x90d7

/** @apiSince 24 */

public static final int GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS = 35881; // 0x8c29

/** @apiSince 24 */

public static final int GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS = 36321; // 0x8de1

/** @apiSince 24 */

public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 35372; // 0x8a2c

/** @apiSince 24 */

public static final int GL_MAX_GEOMETRY_UNIFORM_COMPONENTS = 36319; // 0x8ddf

/** @apiSince 24 */

public static final int GL_MAX_LABEL_LENGTH = 33512; // 0x82e8

/** @apiSince 24 */

public static final int GL_MAX_PATCH_VERTICES = 36477; // 0x8e7d

/** @apiSince 24 */

public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTERS = 37587; // 0x92d3

/** @apiSince 24 */

public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTER_BUFFERS = 37581; // 0x92cd

/** @apiSince 24 */

public static final int GL_MAX_TESS_CONTROL_IMAGE_UNIFORMS = 37067; // 0x90cb

/** @apiSince 24 */

public static final int GL_MAX_TESS_CONTROL_INPUT_COMPONENTS = 34924; // 0x886c

/** @apiSince 24 */

public static final int GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS = 36483; // 0x8e83

/** @apiSince 24 */

public static final int GL_MAX_TESS_CONTROL_SHADER_STORAGE_BLOCKS = 37080; // 0x90d8

/** @apiSince 24 */

public static final int GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS = 36481; // 0x8e81

/** @apiSince 24 */

public static final int GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS = 36485; // 0x8e85

/** @apiSince 24 */

public static final int GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS = 36489; // 0x8e89

/** @apiSince 24 */

public static final int GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS = 36479; // 0x8e7f

/** @apiSince 24 */

public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTERS = 37588; // 0x92d4

/** @apiSince 24 */

public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTER_BUFFERS = 37582; // 0x92ce

/** @apiSince 24 */

public static final int GL_MAX_TESS_EVALUATION_IMAGE_UNIFORMS = 37068; // 0x90cc

/** @apiSince 24 */

public static final int GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS = 34925; // 0x886d

/** @apiSince 24 */

public static final int GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS = 36486; // 0x8e86

/** @apiSince 24 */

public static final int GL_MAX_TESS_EVALUATION_SHADER_STORAGE_BLOCKS = 37081; // 0x90d9

/** @apiSince 24 */

public static final int GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS = 36482; // 0x8e82

/** @apiSince 24 */

public static final int GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS = 36490; // 0x8e8a

/** @apiSince 24 */

public static final int GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS = 36480; // 0x8e80

/** @apiSince 24 */

public static final int GL_MAX_TESS_GEN_LEVEL = 36478; // 0x8e7e

/** @apiSince 24 */

public static final int GL_MAX_TESS_PATCH_COMPONENTS = 36484; // 0x8e84

/** @apiSince 24 */

public static final int GL_MAX_TEXTURE_BUFFER_SIZE = 35883; // 0x8c2b

/** @apiSince 24 */

public static final int GL_MIN_FRAGMENT_INTERPOLATION_OFFSET = 36443; // 0x8e5b

/** @apiSince 24 */

public static final int GL_MIN_SAMPLE_SHADING_VALUE = 35895; // 0x8c37

/** @apiSince 24 */

public static final int GL_MULTIPLY = 37524; // 0x9294

/** @apiSince 24 */

public static final int GL_MULTISAMPLE_LINE_WIDTH_GRANULARITY = 37762; // 0x9382

/** @apiSince 24 */

public static final int GL_MULTISAMPLE_LINE_WIDTH_RANGE = 37761; // 0x9381

/** @apiSince 24 */

public static final int GL_NO_RESET_NOTIFICATION = 33377; // 0x8261

/** @apiSince 24 */

public static final int GL_OVERLAY = 37526; // 0x9296

/** @apiSince 24 */

public static final int GL_PATCHES = 14; // 0xe

/** @apiSince 24 */

public static final int GL_PATCH_VERTICES = 36466; // 0x8e72

/** @apiSince 24 */

public static final int GL_PRIMITIVES_GENERATED = 35975; // 0x8c87

/** @apiSince 24 */

public static final int GL_PRIMITIVE_BOUNDING_BOX = 37566; // 0x92be

/** @apiSince 24 */

public static final int GL_PRIMITIVE_RESTART_FOR_PATCHES_SUPPORTED = 33313; // 0x8221

/** @apiSince 24 */

public static final int GL_PROGRAM = 33506; // 0x82e2

/** @apiSince 24 */

public static final int GL_PROGRAM_PIPELINE = 33508; // 0x82e4

/** @apiSince 24 */

public static final int GL_QUADS = 7; // 0x7

/** @apiSince 24 */

public static final int GL_QUERY = 33507; // 0x82e3

/** @apiSince 24 */

public static final int GL_REFERENCED_BY_GEOMETRY_SHADER = 37641; // 0x9309

/** @apiSince 24 */

public static final int GL_REFERENCED_BY_TESS_CONTROL_SHADER = 37639; // 0x9307

/** @apiSince 24 */

public static final int GL_REFERENCED_BY_TESS_EVALUATION_SHADER = 37640; // 0x9308

/** @apiSince 24 */

public static final int GL_RESET_NOTIFICATION_STRATEGY = 33366; // 0x8256

/** @apiSince 24 */

public static final int GL_SAMPLER = 33510; // 0x82e6

/** @apiSince 24 */

public static final int GL_SAMPLER_2D_MULTISAMPLE_ARRAY = 37131; // 0x910b

/** @apiSince 24 */

public static final int GL_SAMPLER_BUFFER = 36290; // 0x8dc2

/** @apiSince 24 */

public static final int GL_SAMPLER_CUBE_MAP_ARRAY = 36876; // 0x900c

/** @apiSince 24 */

public static final int GL_SAMPLER_CUBE_MAP_ARRAY_SHADOW = 36877; // 0x900d

/** @apiSince 24 */

public static final int GL_SAMPLE_SHADING = 35894; // 0x8c36

/** @apiSince 24 */

public static final int GL_SCREEN = 37525; // 0x9295

/** @apiSince 24 */

public static final int GL_SHADER = 33505; // 0x82e1

/** @apiSince 24 */

public static final int GL_SOFTLIGHT = 37532; // 0x929c

/** @apiSince 24 */

public static final int GL_STACK_OVERFLOW = 1283; // 0x503

/** @apiSince 24 */

public static final int GL_STACK_UNDERFLOW = 1284; // 0x504

/** @apiSince 24 */

public static final int GL_TESS_CONTROL_OUTPUT_VERTICES = 36469; // 0x8e75

/** @apiSince 24 */

public static final int GL_TESS_CONTROL_SHADER = 36488; // 0x8e88

/** @apiSince 24 */

public static final int GL_TESS_CONTROL_SHADER_BIT = 8; // 0x8

/** @apiSince 24 */

public static final int GL_TESS_EVALUATION_SHADER = 36487; // 0x8e87

/** @apiSince 24 */

public static final int GL_TESS_EVALUATION_SHADER_BIT = 16; // 0x10

/** @apiSince 24 */

public static final int GL_TESS_GEN_MODE = 36470; // 0x8e76

/** @apiSince 24 */

public static final int GL_TESS_GEN_POINT_MODE = 36473; // 0x8e79

/** @apiSince 24 */

public static final int GL_TESS_GEN_SPACING = 36471; // 0x8e77

/** @apiSince 24 */

public static final int GL_TESS_GEN_VERTEX_ORDER = 36472; // 0x8e78

/** @apiSince 24 */

public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY = 37122; // 0x9102

/** @apiSince 24 */

public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY = 37125; // 0x9105

/** @apiSince 24 */

public static final int GL_TEXTURE_BINDING_BUFFER = 35884; // 0x8c2c

/** @apiSince 24 */

public static final int GL_TEXTURE_BINDING_CUBE_MAP_ARRAY = 36874; // 0x900a

/** @apiSince 24 */

public static final int GL_TEXTURE_BORDER_COLOR = 4100; // 0x1004

/** @apiSince 24 */

public static final int GL_TEXTURE_BUFFER = 35882; // 0x8c2a

/** @apiSince 24 */

public static final int GL_TEXTURE_BUFFER_BINDING = 35882; // 0x8c2a

/** @apiSince 24 */

public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING = 35885; // 0x8c2d

/** @apiSince 24 */

public static final int GL_TEXTURE_BUFFER_OFFSET = 37277; // 0x919d

/** @apiSince 24 */

public static final int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT = 37279; // 0x919f

/** @apiSince 24 */

public static final int GL_TEXTURE_BUFFER_SIZE = 37278; // 0x919e

/** @apiSince 24 */

public static final int GL_TEXTURE_CUBE_MAP_ARRAY = 36873; // 0x9009

/** @apiSince 24 */

public static final int GL_TRIANGLES_ADJACENCY = 12; // 0xc

/** @apiSince 24 */

public static final int GL_TRIANGLE_STRIP_ADJACENCY = 13; // 0xd

/** @apiSince 24 */

public static final int GL_UNDEFINED_VERTEX = 33376; // 0x8260

/** @apiSince 24 */

public static final int GL_UNKNOWN_CONTEXT_RESET = 33365; // 0x8255

/** @apiSince 24 */

public static final int GL_UNSIGNED_INT_IMAGE_BUFFER = 36967; // 0x9067

/** @apiSince 24 */

public static final int GL_UNSIGNED_INT_IMAGE_CUBE_MAP_ARRAY = 36970; // 0x906a

/** @apiSince 24 */

public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37133; // 0x910d

/** @apiSince 24 */

public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER = 36312; // 0x8dd8

/** @apiSince 24 */

public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_MAP_ARRAY = 36879; // 0x900f

/** @apiSince 24 */

public static final int GL_VERTEX_ARRAY = 32884; // 0x8074
/** @apiSince 24 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface DebugProc {

/** @apiSince 24 */

public void onMessage(int source, int type, int id, int severity, java.lang.String message);
}

}

