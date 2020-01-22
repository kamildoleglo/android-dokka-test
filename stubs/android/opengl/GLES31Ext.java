/*
 * Copyright 2014 The Android Open Source Project
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


/** @apiSince 21 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GLES31Ext {

private GLES31Ext() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public static native void glBlendBarrierKHR();

/** @apiSince 21 */

public static native void glDebugMessageControlKHR(int source, int type, int severity, int count, int[] ids, int offset, boolean enabled);

/** @apiSince 21 */

public static native void glDebugMessageControlKHR(int source, int type, int severity, int count, java.nio.IntBuffer ids, boolean enabled);

/** @apiSince 21 */

public static native void glDebugMessageInsertKHR(int source, int type, int id, int severity, java.lang.String buf);

/** @apiSince 21 */

public static native void glDebugMessageCallbackKHR(android.opengl.GLES31Ext.DebugProcKHR callback);

/** @apiSince 21 */

public static native int glGetDebugMessageLogKHR(int count, int bufSize, int[] sources, int sourcesOffset, int[] types, int typesOffset, int[] ids, int idsOffset, int[] severities, int severitiesOffset, int[] lengths, int lengthsOffset, byte[] messageLog, int messageLogOffset);

/** @apiSince 21 */

public static native int glGetDebugMessageLogKHR(int count, java.nio.IntBuffer sources, java.nio.IntBuffer types, java.nio.IntBuffer ids, java.nio.IntBuffer severities, java.nio.IntBuffer lengths, java.nio.ByteBuffer messageLog);

/** @apiSince 21 */

public static native java.lang.String[] glGetDebugMessageLogKHR(int count, int[] sources, int sourcesOffset, int[] types, int typesOffset, int[] ids, int idsOffset, int[] severities, int severitiesOffset);

/** @apiSince 21 */

public static native java.lang.String[] glGetDebugMessageLogKHR(int count, java.nio.IntBuffer sources, java.nio.IntBuffer types, java.nio.IntBuffer ids, java.nio.IntBuffer severities);

/** @apiSince 21 */

public static native void glPushDebugGroupKHR(int source, int id, int length, java.lang.String message);

/** @apiSince 21 */

public static native void glPopDebugGroupKHR();

/** @apiSince 21 */

public static native void glObjectLabelKHR(int identifier, int name, int length, java.lang.String label);

/** @apiSince 21 */

public static native java.lang.String glGetObjectLabelKHR(int identifier, int name);

/** @apiSince 21 */

public static native void glObjectPtrLabelKHR(long ptr, java.lang.String label);

/** @apiSince 21 */

public static native java.lang.String glGetObjectPtrLabelKHR(long ptr);

/** @apiSince 21 */

public static native android.opengl.GLES31Ext.DebugProcKHR glGetDebugMessageCallbackKHR();

/** @apiSince 21 */

public static native void glMinSampleShadingOES(float value);

/** @apiSince 21 */

public static native void glTexStorage3DMultisampleOES(int target, int samples, int internalformat, int width, int height, int depth, boolean fixedsamplelocations);

/** @apiSince 21 */

public static native void glCopyImageSubDataEXT(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth);

/** @apiSince 21 */

public static native void glEnableiEXT(int target, int index);

/** @apiSince 21 */

public static native void glDisableiEXT(int target, int index);

/** @apiSince 21 */

public static native void glBlendEquationiEXT(int buf, int mode);

/** @apiSince 21 */

public static native void glBlendEquationSeparateiEXT(int buf, int modeRGB, int modeAlpha);

/** @apiSince 21 */

public static native void glBlendFunciEXT(int buf, int src, int dst);

/** @apiSince 21 */

public static native void glBlendFuncSeparateiEXT(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha);

/** @apiSince 21 */

public static native void glColorMaskiEXT(int index, boolean r, boolean g, boolean b, boolean a);

/** @apiSince 21 */

public static native boolean glIsEnablediEXT(int target, int index);

/** @apiSince 21 */

public static native void glFramebufferTextureEXT(int target, int attachment, int texture, int level);

/** @apiSince 21 */

public static native void glPrimitiveBoundingBoxEXT(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW);

/** @apiSince 21 */

public static native void glPatchParameteriEXT(int pname, int value);

/** @apiSince 21 */

public static native void glTexParameterIivEXT(int target, int pname, int[] params, int offset);

/** @apiSince 21 */

public static native void glTexParameterIivEXT(int target, int pname, java.nio.IntBuffer params);

/** @apiSince 21 */

public static native void glTexParameterIuivEXT(int target, int pname, int[] params, int offset);

/** @apiSince 21 */

public static native void glTexParameterIuivEXT(int target, int pname, java.nio.IntBuffer params);

/** @apiSince 21 */

public static native void glGetTexParameterIivEXT(int target, int pname, int[] params, int offset);

/** @apiSince 21 */

public static native void glGetTexParameterIivEXT(int target, int pname, java.nio.IntBuffer params);

/** @apiSince 21 */

public static native void glGetTexParameterIuivEXT(int target, int pname, int[] params, int offset);

/** @apiSince 21 */

public static native void glGetTexParameterIuivEXT(int target, int pname, java.nio.IntBuffer params);

/** @apiSince 21 */

public static native void glSamplerParameterIivEXT(int sampler, int pname, int[] param, int offset);

/** @apiSince 21 */

public static native void glSamplerParameterIivEXT(int sampler, int pname, java.nio.IntBuffer param);

/** @apiSince 21 */

public static native void glSamplerParameterIuivEXT(int sampler, int pname, int[] param, int offset);

/** @apiSince 21 */

public static native void glSamplerParameterIuivEXT(int sampler, int pname, java.nio.IntBuffer param);

/** @apiSince 21 */

public static native void glGetSamplerParameterIivEXT(int sampler, int pname, int[] params, int offset);

/** @apiSince 21 */

public static native void glGetSamplerParameterIivEXT(int sampler, int pname, java.nio.IntBuffer params);

/** @apiSince 21 */

public static native void glGetSamplerParameterIuivEXT(int sampler, int pname, int[] params, int offset);

/** @apiSince 21 */

public static native void glGetSamplerParameterIuivEXT(int sampler, int pname, java.nio.IntBuffer params);

/** @apiSince 21 */

public static native void glTexBufferEXT(int target, int internalformat, int buffer);

/** @apiSince 21 */

public static native void glTexBufferRangeEXT(int target, int internalformat, int buffer, int offset, int size);

/** @apiSince 21 */

public static final int GL_BLEND_ADVANCED_COHERENT_KHR = 37509; // 0x9285

/** @apiSince 21 */

public static final int GL_BUFFER_KHR = 33504; // 0x82e0

/** @apiSince 21 */

public static final int GL_CLAMP_TO_BORDER_EXT = 33069; // 0x812d

/** @apiSince 21 */

public static final int GL_COLORBURN_KHR = 37530; // 0x929a

/** @apiSince 21 */

public static final int GL_COLORDODGE_KHR = 37529; // 0x9299

/** @apiSince 21 */

public static final int GL_COMPRESSED_RGBA_ASTC_10x10_KHR = 37819; // 0x93bb

/** @apiSince 21 */

public static final int GL_COMPRESSED_RGBA_ASTC_10x5_KHR = 37816; // 0x93b8

/** @apiSince 21 */

public static final int GL_COMPRESSED_RGBA_ASTC_10x6_KHR = 37817; // 0x93b9

/** @apiSince 21 */

public static final int GL_COMPRESSED_RGBA_ASTC_10x8_KHR = 37818; // 0x93ba

/** @apiSince 21 */

public static final int GL_COMPRESSED_RGBA_ASTC_12x10_KHR = 37820; // 0x93bc

/** @apiSince 21 */

public static final int GL_COMPRESSED_RGBA_ASTC_12x12_KHR = 37821; // 0x93bd

/** @apiSince 21 */

public static final int GL_COMPRESSED_RGBA_ASTC_4x4_KHR = 37808; // 0x93b0

/** @apiSince 21 */

public static final int GL_COMPRESSED_RGBA_ASTC_5x4_KHR = 37809; // 0x93b1

/** @apiSince 21 */

public static final int GL_COMPRESSED_RGBA_ASTC_5x5_KHR = 37810; // 0x93b2

/** @apiSince 21 */

public static final int GL_COMPRESSED_RGBA_ASTC_6x5_KHR = 37811; // 0x93b3

/** @apiSince 21 */

public static final int GL_COMPRESSED_RGBA_ASTC_6x6_KHR = 37812; // 0x93b4

/** @apiSince 21 */

public static final int GL_COMPRESSED_RGBA_ASTC_8x5_KHR = 37813; // 0x93b5

/** @apiSince 21 */

public static final int GL_COMPRESSED_RGBA_ASTC_8x6_KHR = 37814; // 0x93b6

/** @apiSince 21 */

public static final int GL_COMPRESSED_RGBA_ASTC_8x8_KHR = 37815; // 0x93b7

/** @apiSince 21 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x10_KHR = 37851; // 0x93db

/** @apiSince 21 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x5_KHR = 37848; // 0x93d8

/** @apiSince 21 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x6_KHR = 37849; // 0x93d9

/** @apiSince 21 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x8_KHR = 37850; // 0x93da

/** @apiSince 21 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_12x10_KHR = 37852; // 0x93dc

/** @apiSince 21 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_12x12_KHR = 37853; // 0x93dd

/** @apiSince 21 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_4x4_KHR = 37840; // 0x93d0

/** @apiSince 21 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_5x4_KHR = 37841; // 0x93d1

/** @apiSince 21 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_5x5_KHR = 37842; // 0x93d2

/** @apiSince 21 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_6x5_KHR = 37843; // 0x93d3

/** @apiSince 21 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_6x6_KHR = 37844; // 0x93d4

/** @apiSince 21 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_8x5_KHR = 37845; // 0x93d5

/** @apiSince 21 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_8x6_KHR = 37846; // 0x93d6

/** @apiSince 21 */

public static final int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_8x8_KHR = 37847; // 0x93d7

/** @apiSince 21 */

public static final int GL_CONTEXT_FLAG_DEBUG_BIT_KHR = 2; // 0x2

/** @apiSince 21 */

public static final int GL_DARKEN_KHR = 37527; // 0x9297

/** @apiSince 21 */

public static final int GL_DEBUG_CALLBACK_FUNCTION_KHR = 33348; // 0x8244

/** @apiSince 21 */

public static final int GL_DEBUG_CALLBACK_USER_PARAM_KHR = 33349; // 0x8245

/** @apiSince 21 */

public static final int GL_DEBUG_GROUP_STACK_DEPTH_KHR = 33389; // 0x826d

/** @apiSince 21 */

public static final int GL_DEBUG_LOGGED_MESSAGES_KHR = 37189; // 0x9145

/** @apiSince 21 */

public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH_KHR = 33347; // 0x8243

/** @apiSince 21 */

public static final int GL_DEBUG_OUTPUT_KHR = 37600; // 0x92e0

/** @apiSince 21 */

public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS_KHR = 33346; // 0x8242

/** @apiSince 21 */

public static final int GL_DEBUG_SEVERITY_HIGH_KHR = 37190; // 0x9146

/** @apiSince 21 */

public static final int GL_DEBUG_SEVERITY_LOW_KHR = 37192; // 0x9148

/** @apiSince 21 */

public static final int GL_DEBUG_SEVERITY_MEDIUM_KHR = 37191; // 0x9147

/** @apiSince 21 */

public static final int GL_DEBUG_SEVERITY_NOTIFICATION_KHR = 33387; // 0x826b

/** @apiSince 21 */

public static final int GL_DEBUG_SOURCE_API_KHR = 33350; // 0x8246

/** @apiSince 21 */

public static final int GL_DEBUG_SOURCE_APPLICATION_KHR = 33354; // 0x824a

/** @apiSince 21 */

public static final int GL_DEBUG_SOURCE_OTHER_KHR = 33355; // 0x824b

/** @apiSince 21 */

public static final int GL_DEBUG_SOURCE_SHADER_COMPILER_KHR = 33352; // 0x8248

/** @apiSince 21 */

public static final int GL_DEBUG_SOURCE_THIRD_PARTY_KHR = 33353; // 0x8249

/** @apiSince 21 */

public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM_KHR = 33351; // 0x8247

/** @apiSince 21 */

public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR_KHR = 33357; // 0x824d

/** @apiSince 21 */

public static final int GL_DEBUG_TYPE_ERROR_KHR = 33356; // 0x824c

/** @apiSince 21 */

public static final int GL_DEBUG_TYPE_MARKER_KHR = 33384; // 0x8268

/** @apiSince 21 */

public static final int GL_DEBUG_TYPE_OTHER_KHR = 33361; // 0x8251

/** @apiSince 21 */

public static final int GL_DEBUG_TYPE_PERFORMANCE_KHR = 33360; // 0x8250

/** @apiSince 21 */

public static final int GL_DEBUG_TYPE_POP_GROUP_KHR = 33386; // 0x826a

/** @apiSince 21 */

public static final int GL_DEBUG_TYPE_PORTABILITY_KHR = 33359; // 0x824f

/** @apiSince 21 */

public static final int GL_DEBUG_TYPE_PUSH_GROUP_KHR = 33385; // 0x8269

/** @apiSince 21 */

public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR_KHR = 33358; // 0x824e

/** @apiSince 21 */

public static final int GL_DECODE_EXT = 35401; // 0x8a49

/** @apiSince 21 */

public static final int GL_DIFFERENCE_KHR = 37534; // 0x929e

/** @apiSince 21 */

public static final int GL_EXCLUSION_KHR = 37536; // 0x92a0

/** @apiSince 21 */

public static final int GL_FIRST_VERTEX_CONVENTION_EXT = 36429; // 0x8e4d

/** @apiSince 21 */

public static final int GL_FRACTIONAL_EVEN_EXT = 36476; // 0x8e7c

/** @apiSince 21 */

public static final int GL_FRACTIONAL_ODD_EXT = 36475; // 0x8e7b

/** @apiSince 21 */

public static final int GL_FRAGMENT_INTERPOLATION_OFFSET_BITS_OES = 36445; // 0x8e5d

/** @apiSince 21 */

public static final int GL_FRAMEBUFFER_ATTACHMENT_LAYERED_EXT = 36263; // 0x8da7

/** @apiSince 21 */

public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS_EXT = 37650; // 0x9312

/** @apiSince 21 */

public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS_EXT = 36264; // 0x8da8

/** @apiSince 21 */

public static final int GL_GEOMETRY_LINKED_INPUT_TYPE_EXT = 35095; // 0x8917

/** @apiSince 21 */

public static final int GL_GEOMETRY_LINKED_OUTPUT_TYPE_EXT = 35096; // 0x8918

/** @apiSince 21 */

public static final int GL_GEOMETRY_LINKED_VERTICES_OUT_EXT = 35094; // 0x8916

/** @apiSince 21 */

public static final int GL_GEOMETRY_SHADER_BIT_EXT = 4; // 0x4

/** @apiSince 21 */

public static final int GL_GEOMETRY_SHADER_EXT = 36313; // 0x8dd9

/** @apiSince 21 */

public static final int GL_GEOMETRY_SHADER_INVOCATIONS_EXT = 34943; // 0x887f

/** @apiSince 21 */

public static final int GL_HARDLIGHT_KHR = 37531; // 0x929b

/** @apiSince 21 */

public static final int GL_HSL_COLOR_KHR = 37551; // 0x92af

/** @apiSince 21 */

public static final int GL_HSL_HUE_KHR = 37549; // 0x92ad

/** @apiSince 21 */

public static final int GL_HSL_LUMINOSITY_KHR = 37552; // 0x92b0

/** @apiSince 21 */

public static final int GL_HSL_SATURATION_KHR = 37550; // 0x92ae

/** @apiSince 21 */

public static final int GL_IMAGE_BUFFER_EXT = 36945; // 0x9051

/** @apiSince 21 */

public static final int GL_IMAGE_CUBE_MAP_ARRAY_EXT = 36948; // 0x9054

/** @apiSince 21 */

public static final int GL_INT_IMAGE_BUFFER_EXT = 36956; // 0x905c

/** @apiSince 21 */

public static final int GL_INT_IMAGE_CUBE_MAP_ARRAY_EXT = 36959; // 0x905f

/** @apiSince 21 */

public static final int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY_OES = 37132; // 0x910c

/** @apiSince 21 */

public static final int GL_INT_SAMPLER_BUFFER_EXT = 36304; // 0x8dd0

/** @apiSince 21 */

public static final int GL_INT_SAMPLER_CUBE_MAP_ARRAY_EXT = 36878; // 0x900e

/** @apiSince 21 */

public static final int GL_ISOLINES_EXT = 36474; // 0x8e7a

/** @apiSince 21 */

public static final int GL_IS_PER_PATCH_EXT = 37607; // 0x92e7

/** @apiSince 21 */

public static final int GL_LAST_VERTEX_CONVENTION_EXT = 36430; // 0x8e4e

/** @apiSince 21 */

public static final int GL_LAYER_PROVOKING_VERTEX_EXT = 33374; // 0x825e

/** @apiSince 21 */

public static final int GL_LIGHTEN_KHR = 37528; // 0x9298

/** @apiSince 21 */

public static final int GL_LINES_ADJACENCY_EXT = 10; // 0xa

/** @apiSince 21 */

public static final int GL_LINE_STRIP_ADJACENCY_EXT = 11; // 0xb

/** @apiSince 21 */

public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS_EXT = 35378; // 0x8a32

/** @apiSince 21 */

public static final int GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS_EXT = 36382; // 0x8e1e

/** @apiSince 21 */

public static final int GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS_EXT = 36383; // 0x8e1f

/** @apiSince 21 */

public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH_KHR = 33388; // 0x826c

/** @apiSince 21 */

public static final int GL_MAX_DEBUG_LOGGED_MESSAGES_KHR = 37188; // 0x9144

/** @apiSince 21 */

public static final int GL_MAX_DEBUG_MESSAGE_LENGTH_KHR = 37187; // 0x9143

/** @apiSince 21 */

public static final int GL_MAX_FRAGMENT_INTERPOLATION_OFFSET_OES = 36444; // 0x8e5c

/** @apiSince 21 */

public static final int GL_MAX_FRAMEBUFFER_LAYERS_EXT = 37655; // 0x9317

/** @apiSince 21 */

public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTERS_EXT = 37589; // 0x92d5

/** @apiSince 21 */

public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTER_BUFFERS_EXT = 37583; // 0x92cf

/** @apiSince 21 */

public static final int GL_MAX_GEOMETRY_IMAGE_UNIFORMS_EXT = 37069; // 0x90cd

/** @apiSince 21 */

public static final int GL_MAX_GEOMETRY_INPUT_COMPONENTS_EXT = 37155; // 0x9123

/** @apiSince 21 */

public static final int GL_MAX_GEOMETRY_OUTPUT_COMPONENTS_EXT = 37156; // 0x9124

/** @apiSince 21 */

public static final int GL_MAX_GEOMETRY_OUTPUT_VERTICES_EXT = 36320; // 0x8de0

/** @apiSince 21 */

public static final int GL_MAX_GEOMETRY_SHADER_INVOCATIONS_EXT = 36442; // 0x8e5a

/** @apiSince 21 */

public static final int GL_MAX_GEOMETRY_SHADER_STORAGE_BLOCKS_EXT = 37079; // 0x90d7

/** @apiSince 21 */

public static final int GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS_EXT = 35881; // 0x8c29

/** @apiSince 21 */

public static final int GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS_EXT = 36321; // 0x8de1

/** @apiSince 21 */

public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS_EXT = 35372; // 0x8a2c

/** @apiSince 21 */

public static final int GL_MAX_GEOMETRY_UNIFORM_COMPONENTS_EXT = 36319; // 0x8ddf

/** @apiSince 21 */

public static final int GL_MAX_LABEL_LENGTH_KHR = 33512; // 0x82e8

/** @apiSince 21 */

public static final int GL_MAX_PATCH_VERTICES_EXT = 36477; // 0x8e7d

/** @apiSince 21 */

public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTERS_EXT = 37587; // 0x92d3

/** @apiSince 21 */

public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTER_BUFFERS_EXT = 37581; // 0x92cd

/** @apiSince 21 */

public static final int GL_MAX_TESS_CONTROL_IMAGE_UNIFORMS_EXT = 37067; // 0x90cb

/** @apiSince 21 */

public static final int GL_MAX_TESS_CONTROL_INPUT_COMPONENTS_EXT = 34924; // 0x886c

/** @apiSince 21 */

public static final int GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS_EXT = 36483; // 0x8e83

/** @apiSince 21 */

public static final int GL_MAX_TESS_CONTROL_SHADER_STORAGE_BLOCKS_EXT = 37080; // 0x90d8

/** @apiSince 21 */

public static final int GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS_EXT = 36481; // 0x8e81

/** @apiSince 21 */

public static final int GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS_EXT = 36485; // 0x8e85

/** @apiSince 21 */

public static final int GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS_EXT = 36489; // 0x8e89

/** @apiSince 21 */

public static final int GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS_EXT = 36479; // 0x8e7f

/** @apiSince 21 */

public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTERS_EXT = 37588; // 0x92d4

/** @apiSince 21 */

public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTER_BUFFERS_EXT = 37582; // 0x92ce

/** @apiSince 21 */

public static final int GL_MAX_TESS_EVALUATION_IMAGE_UNIFORMS_EXT = 37068; // 0x90cc

/** @apiSince 21 */

public static final int GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS_EXT = 34925; // 0x886d

/** @apiSince 21 */

public static final int GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS_EXT = 36486; // 0x8e86

/** @apiSince 21 */

public static final int GL_MAX_TESS_EVALUATION_SHADER_STORAGE_BLOCKS_EXT = 37081; // 0x90d9

/** @apiSince 21 */

public static final int GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS_EXT = 36482; // 0x8e82

/** @apiSince 21 */

public static final int GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS_EXT = 36490; // 0x8e8a

/** @apiSince 21 */

public static final int GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS_EXT = 36480; // 0x8e80

/** @apiSince 21 */

public static final int GL_MAX_TESS_GEN_LEVEL_EXT = 36478; // 0x8e7e

/** @apiSince 21 */

public static final int GL_MAX_TESS_PATCH_COMPONENTS_EXT = 36484; // 0x8e84

/** @apiSince 21 */

public static final int GL_MAX_TEXTURE_BUFFER_SIZE_EXT = 35883; // 0x8c2b

/** @apiSince 21 */

public static final int GL_MIN_FRAGMENT_INTERPOLATION_OFFSET_OES = 36443; // 0x8e5b

/** @apiSince 21 */

public static final int GL_MIN_SAMPLE_SHADING_VALUE_OES = 35895; // 0x8c37

/** @apiSince 21 */

public static final int GL_MULTIPLY_KHR = 37524; // 0x9294

/** @apiSince 21 */

public static final int GL_OVERLAY_KHR = 37526; // 0x9296

/** @apiSince 21 */

public static final int GL_PATCHES_EXT = 14; // 0xe

/** @apiSince 21 */

public static final int GL_PATCH_VERTICES_EXT = 36466; // 0x8e72

/** @apiSince 21 */

public static final int GL_PRIMITIVES_GENERATED_EXT = 35975; // 0x8c87

/** @apiSince 21 */

public static final int GL_PRIMITIVE_BOUNDING_BOX_EXT = 37566; // 0x92be

/** @apiSince 21 */

public static final int GL_PRIMITIVE_RESTART_FOR_PATCHES_SUPPORTED = 33313; // 0x8221

/** @apiSince 21 */

public static final int GL_PROGRAM_KHR = 33506; // 0x82e2

/** @apiSince 21 */

public static final int GL_QUADS_EXT = 7; // 0x7

/** @apiSince 21 */

public static final int GL_QUERY_KHR = 33507; // 0x82e3

/** @apiSince 21 */

public static final int GL_REFERENCED_BY_GEOMETRY_SHADER_EXT = 37641; // 0x9309

/** @apiSince 21 */

public static final int GL_REFERENCED_BY_TESS_CONTROL_SHADER_EXT = 37639; // 0x9307

/** @apiSince 21 */

public static final int GL_REFERENCED_BY_TESS_EVALUATION_SHADER_EXT = 37640; // 0x9308

/** @apiSince 21 */

public static final int GL_SAMPLER_2D_MULTISAMPLE_ARRAY_OES = 37131; // 0x910b

/** @apiSince 21 */

public static final int GL_SAMPLER_BUFFER_EXT = 36290; // 0x8dc2

/** @apiSince 21 */

public static final int GL_SAMPLER_CUBE_MAP_ARRAY_EXT = 36876; // 0x900c

/** @apiSince 21 */

public static final int GL_SAMPLER_CUBE_MAP_ARRAY_SHADOW_EXT = 36877; // 0x900d

/** @apiSince 21 */

public static final int GL_SAMPLER_KHR = 33510; // 0x82e6

/** @apiSince 21 */

public static final int GL_SAMPLE_SHADING_OES = 35894; // 0x8c36

/** @apiSince 21 */

public static final int GL_SCREEN_KHR = 37525; // 0x9295

/** @apiSince 21 */

public static final int GL_SHADER_KHR = 33505; // 0x82e1

/** @apiSince 21 */

public static final int GL_SKIP_DECODE_EXT = 35402; // 0x8a4a

/** @apiSince 21 */

public static final int GL_SOFTLIGHT_KHR = 37532; // 0x929c

/** @apiSince 21 */

public static final int GL_STACK_OVERFLOW_KHR = 1283; // 0x503

/** @apiSince 21 */

public static final int GL_STACK_UNDERFLOW_KHR = 1284; // 0x504

/** @apiSince 21 */

public static final int GL_STENCIL_INDEX8_OES = 36168; // 0x8d48

/** @apiSince 21 */

public static final int GL_STENCIL_INDEX_OES = 6401; // 0x1901

/** @apiSince 21 */

public static final int GL_TESS_CONTROL_OUTPUT_VERTICES_EXT = 36469; // 0x8e75

/** @apiSince 21 */

public static final int GL_TESS_CONTROL_SHADER_BIT_EXT = 8; // 0x8

/** @apiSince 21 */

public static final int GL_TESS_CONTROL_SHADER_EXT = 36488; // 0x8e88

/** @apiSince 21 */

public static final int GL_TESS_EVALUATION_SHADER_BIT_EXT = 16; // 0x10

/** @apiSince 21 */

public static final int GL_TESS_EVALUATION_SHADER_EXT = 36487; // 0x8e87

/** @apiSince 21 */

public static final int GL_TESS_GEN_MODE_EXT = 36470; // 0x8e76

/** @apiSince 21 */

public static final int GL_TESS_GEN_POINT_MODE_EXT = 36473; // 0x8e79

/** @apiSince 21 */

public static final int GL_TESS_GEN_SPACING_EXT = 36471; // 0x8e77

/** @apiSince 21 */

public static final int GL_TESS_GEN_VERTEX_ORDER_EXT = 36472; // 0x8e78

/** @apiSince 21 */

public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY_OES = 37122; // 0x9102

/** @apiSince 21 */

public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY_OES = 37125; // 0x9105

/** @apiSince 21 */

public static final int GL_TEXTURE_BINDING_BUFFER_EXT = 35884; // 0x8c2c

/** @apiSince 21 */

public static final int GL_TEXTURE_BINDING_CUBE_MAP_ARRAY_EXT = 36874; // 0x900a

/** @apiSince 21 */

public static final int GL_TEXTURE_BORDER_COLOR_EXT = 4100; // 0x1004

/** @apiSince 21 */

public static final int GL_TEXTURE_BUFFER_BINDING_EXT = 35882; // 0x8c2a

/** @apiSince 21 */

public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING_EXT = 35885; // 0x8c2d

/** @apiSince 21 */

public static final int GL_TEXTURE_BUFFER_EXT = 35882; // 0x8c2a

/** @apiSince 21 */

public static final int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT_EXT = 37279; // 0x919f

/** @apiSince 21 */

public static final int GL_TEXTURE_BUFFER_OFFSET_EXT = 37277; // 0x919d

/** @apiSince 21 */

public static final int GL_TEXTURE_BUFFER_SIZE_EXT = 37278; // 0x919e

/** @apiSince 21 */

public static final int GL_TEXTURE_CUBE_MAP_ARRAY_EXT = 36873; // 0x9009

/** @apiSince 21 */

public static final int GL_TEXTURE_SRGB_DECODE_EXT = 35400; // 0x8a48

/** @apiSince 21 */

public static final int GL_TRIANGLES_ADJACENCY_EXT = 12; // 0xc

/** @apiSince 21 */

public static final int GL_TRIANGLE_STRIP_ADJACENCY_EXT = 13; // 0xd

/** @apiSince 21 */

public static final int GL_UNDEFINED_VERTEX_EXT = 33376; // 0x8260

/** @apiSince 21 */

public static final int GL_UNSIGNED_INT_IMAGE_BUFFER_EXT = 36967; // 0x9067

/** @apiSince 21 */

public static final int GL_UNSIGNED_INT_IMAGE_CUBE_MAP_ARRAY_EXT = 36970; // 0x906a

/** @apiSince 21 */

public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY_OES = 37133; // 0x910d

/** @apiSince 21 */

public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER_EXT = 36312; // 0x8dd8

/** @apiSince 21 */

public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_MAP_ARRAY_EXT = 36879; // 0x900f

/** @apiSince 21 */

public static final int GL_VERTEX_ARRAY_KHR = 32884; // 0x8074
/** @apiSince 21 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface DebugProcKHR {

/** @apiSince 21 */

public void onMessage(int source, int type, int id, int severity, java.lang.String message);
}

}

