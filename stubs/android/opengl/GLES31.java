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


/** OpenGL ES 3.1
 @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GLES31 extends android.opengl.GLES30 {

GLES31() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public static native void glDispatchCompute(int num_groups_x, int num_groups_y, int num_groups_z);

/** @apiSince 21 */

public static native void glDispatchComputeIndirect(long indirect);

/** @apiSince 21 */

public static native void glDrawArraysIndirect(int mode, long indirect);

/** @apiSince 21 */

public static native void glDrawElementsIndirect(int mode, int type, long indirect);

/** @apiSince 21 */

public static native void glFramebufferParameteri(int target, int pname, int param);

/** @apiSince 21 */

public static native void glGetFramebufferParameteriv(int target, int pname, int[] params, int offset);

/** @apiSince 21 */

public static native void glGetFramebufferParameteriv(int target, int pname, java.nio.IntBuffer params);

/** @apiSince 21 */

public static native void glGetProgramInterfaceiv(int program, int programInterface, int pname, int[] params, int offset);

/** @apiSince 21 */

public static native void glGetProgramInterfaceiv(int program, int programInterface, int pname, java.nio.IntBuffer params);

/** @apiSince 21 */

public static native int glGetProgramResourceIndex(int program, int programInterface, java.lang.String name);

/** @apiSince 21 */

public static native java.lang.String glGetProgramResourceName(int program, int programInterface, int index);

/** @apiSince 21 */

public static native void glGetProgramResourceiv(int program, int programInterface, int index, int propCount, int[] props, int propsOffset, int bufSize, int[] length, int lengthOffset, int[] params, int paramsOffset);

/** @apiSince 21 */

public static native void glGetProgramResourceiv(int program, int programInterface, int index, int propCount, java.nio.IntBuffer props, int bufSize, java.nio.IntBuffer length, java.nio.IntBuffer params);

/** @apiSince 21 */

public static native int glGetProgramResourceLocation(int program, int programInterface, java.lang.String name);

/** @apiSince 21 */

public static native void glUseProgramStages(int pipeline, int stages, int program);

/** @apiSince 21 */

public static native void glActiveShaderProgram(int pipeline, int program);

/** @apiSince 21 */

public static native int glCreateShaderProgramv(int type, java.lang.String[] strings);

/** @apiSince 21 */

public static native void glBindProgramPipeline(int pipeline);

/** @apiSince 21 */

public static native void glDeleteProgramPipelines(int n, int[] pipelines, int offset);

/** @apiSince 21 */

public static native void glDeleteProgramPipelines(int n, java.nio.IntBuffer pipelines);

/** @apiSince 21 */

public static native void glGenProgramPipelines(int n, int[] pipelines, int offset);

/** @apiSince 21 */

public static native void glGenProgramPipelines(int n, java.nio.IntBuffer pipelines);

/** @apiSince 21 */

public static native boolean glIsProgramPipeline(int pipeline);

/** @apiSince 21 */

public static native void glGetProgramPipelineiv(int pipeline, int pname, int[] params, int offset);

/** @apiSince 21 */

public static native void glGetProgramPipelineiv(int pipeline, int pname, java.nio.IntBuffer params);

/** @apiSince 21 */

public static native void glProgramUniform1i(int program, int location, int v0);

/** @apiSince 21 */

public static native void glProgramUniform2i(int program, int location, int v0, int v1);

/** @apiSince 21 */

public static native void glProgramUniform3i(int program, int location, int v0, int v1, int v2);

/** @apiSince 21 */

public static native void glProgramUniform4i(int program, int location, int v0, int v1, int v2, int v3);

/** @apiSince 21 */

public static native void glProgramUniform1ui(int program, int location, int v0);

/** @apiSince 21 */

public static native void glProgramUniform2ui(int program, int location, int v0, int v1);

/** @apiSince 21 */

public static native void glProgramUniform3ui(int program, int location, int v0, int v1, int v2);

/** @apiSince 21 */

public static native void glProgramUniform4ui(int program, int location, int v0, int v1, int v2, int v3);

/** @apiSince 21 */

public static native void glProgramUniform1f(int program, int location, float v0);

/** @apiSince 21 */

public static native void glProgramUniform2f(int program, int location, float v0, float v1);

/** @apiSince 21 */

public static native void glProgramUniform3f(int program, int location, float v0, float v1, float v2);

/** @apiSince 21 */

public static native void glProgramUniform4f(int program, int location, float v0, float v1, float v2, float v3);

/** @apiSince 21 */

public static native void glProgramUniform1iv(int program, int location, int count, int[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniform1iv(int program, int location, int count, java.nio.IntBuffer value);

/** @apiSince 21 */

public static native void glProgramUniform2iv(int program, int location, int count, int[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniform2iv(int program, int location, int count, java.nio.IntBuffer value);

/** @apiSince 21 */

public static native void glProgramUniform3iv(int program, int location, int count, int[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniform3iv(int program, int location, int count, java.nio.IntBuffer value);

/** @apiSince 21 */

public static native void glProgramUniform4iv(int program, int location, int count, int[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniform4iv(int program, int location, int count, java.nio.IntBuffer value);

/** @apiSince 21 */

public static native void glProgramUniform1uiv(int program, int location, int count, int[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniform1uiv(int program, int location, int count, java.nio.IntBuffer value);

/** @apiSince 21 */

public static native void glProgramUniform2uiv(int program, int location, int count, int[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniform2uiv(int program, int location, int count, java.nio.IntBuffer value);

/** @apiSince 21 */

public static native void glProgramUniform3uiv(int program, int location, int count, int[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniform3uiv(int program, int location, int count, java.nio.IntBuffer value);

/** @apiSince 21 */

public static native void glProgramUniform4uiv(int program, int location, int count, int[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniform4uiv(int program, int location, int count, java.nio.IntBuffer value);

/** @apiSince 21 */

public static native void glProgramUniform1fv(int program, int location, int count, float[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniform1fv(int program, int location, int count, java.nio.FloatBuffer value);

/** @apiSince 21 */

public static native void glProgramUniform2fv(int program, int location, int count, float[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniform2fv(int program, int location, int count, java.nio.FloatBuffer value);

/** @apiSince 21 */

public static native void glProgramUniform3fv(int program, int location, int count, float[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniform3fv(int program, int location, int count, java.nio.FloatBuffer value);

/** @apiSince 21 */

public static native void glProgramUniform4fv(int program, int location, int count, float[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniform4fv(int program, int location, int count, java.nio.FloatBuffer value);

/** @apiSince 21 */

public static native void glProgramUniformMatrix2fv(int program, int location, int count, boolean transpose, float[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniformMatrix2fv(int program, int location, int count, boolean transpose, java.nio.FloatBuffer value);

/** @apiSince 21 */

public static native void glProgramUniformMatrix3fv(int program, int location, int count, boolean transpose, float[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniformMatrix3fv(int program, int location, int count, boolean transpose, java.nio.FloatBuffer value);

/** @apiSince 21 */

public static native void glProgramUniformMatrix4fv(int program, int location, int count, boolean transpose, float[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniformMatrix4fv(int program, int location, int count, boolean transpose, java.nio.FloatBuffer value);

/** @apiSince 21 */

public static native void glProgramUniformMatrix2x3fv(int program, int location, int count, boolean transpose, float[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniformMatrix2x3fv(int program, int location, int count, boolean transpose, java.nio.FloatBuffer value);

/** @apiSince 21 */

public static native void glProgramUniformMatrix3x2fv(int program, int location, int count, boolean transpose, float[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniformMatrix3x2fv(int program, int location, int count, boolean transpose, java.nio.FloatBuffer value);

/** @apiSince 21 */

public static native void glProgramUniformMatrix2x4fv(int program, int location, int count, boolean transpose, float[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniformMatrix2x4fv(int program, int location, int count, boolean transpose, java.nio.FloatBuffer value);

/** @apiSince 21 */

public static native void glProgramUniformMatrix4x2fv(int program, int location, int count, boolean transpose, float[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniformMatrix4x2fv(int program, int location, int count, boolean transpose, java.nio.FloatBuffer value);

/** @apiSince 21 */

public static native void glProgramUniformMatrix3x4fv(int program, int location, int count, boolean transpose, float[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniformMatrix3x4fv(int program, int location, int count, boolean transpose, java.nio.FloatBuffer value);

/** @apiSince 21 */

public static native void glProgramUniformMatrix4x3fv(int program, int location, int count, boolean transpose, float[] value, int offset);

/** @apiSince 21 */

public static native void glProgramUniformMatrix4x3fv(int program, int location, int count, boolean transpose, java.nio.FloatBuffer value);

/** @apiSince 21 */

public static native void glValidateProgramPipeline(int pipeline);

/** @apiSince 21 */

public static native java.lang.String glGetProgramPipelineInfoLog(int program);

/** @apiSince 21 */

public static native void glBindImageTexture(int unit, int texture, int level, boolean layered, int layer, int access, int format);

/** @apiSince 21 */

public static native void glGetBooleani_v(int target, int index, boolean[] data, int offset);

/** @apiSince 21 */

public static native void glGetBooleani_v(int target, int index, java.nio.IntBuffer data);

/** @apiSince 21 */

public static native void glMemoryBarrier(int barriers);

/** @apiSince 21 */

public static native void glMemoryBarrierByRegion(int barriers);

/** @apiSince 21 */

public static native void glTexStorage2DMultisample(int target, int samples, int internalformat, int width, int height, boolean fixedsamplelocations);

/** @apiSince 21 */

public static native void glGetMultisamplefv(int pname, int index, float[] val, int offset);

/** @apiSince 21 */

public static native void glGetMultisamplefv(int pname, int index, java.nio.FloatBuffer val);

/** @apiSince 21 */

public static native void glSampleMaski(int maskNumber, int mask);

/** @apiSince 21 */

public static native void glGetTexLevelParameteriv(int target, int level, int pname, int[] params, int offset);

/** @apiSince 21 */

public static native void glGetTexLevelParameteriv(int target, int level, int pname, java.nio.IntBuffer params);

/** @apiSince 21 */

public static native void glGetTexLevelParameterfv(int target, int level, int pname, float[] params, int offset);

/** @apiSince 21 */

public static native void glGetTexLevelParameterfv(int target, int level, int pname, java.nio.FloatBuffer params);

/** @apiSince 21 */

public static native void glBindVertexBuffer(int bindingindex, int buffer, long offset, int stride);

/** @apiSince 21 */

public static native void glVertexAttribFormat(int attribindex, int size, int type, boolean normalized, int relativeoffset);

/** @apiSince 21 */

public static native void glVertexAttribIFormat(int attribindex, int size, int type, int relativeoffset);

/** @apiSince 21 */

public static native void glVertexAttribBinding(int attribindex, int bindingindex);

/** @apiSince 21 */

public static native void glVertexBindingDivisor(int bindingindex, int divisor);

/** @apiSince 21 */

public static final int GL_ACTIVE_ATOMIC_COUNTER_BUFFERS = 37593; // 0x92d9

/** @apiSince 21 */

public static final int GL_ACTIVE_PROGRAM = 33369; // 0x8259

/** @apiSince 21 */

public static final int GL_ACTIVE_RESOURCES = 37621; // 0x92f5

/** @apiSince 21 */

public static final int GL_ACTIVE_VARIABLES = 37637; // 0x9305

/** @apiSince 24 */

public static final int GL_ALL_BARRIER_BITS = -1; // 0xffffffff

/** @apiSince 21 */

public static final int GL_ALL_SHADER_BITS = -1; // 0xffffffff

/** @apiSince 21 */

public static final int GL_ARRAY_SIZE = 37627; // 0x92fb

/** @apiSince 21 */

public static final int GL_ARRAY_STRIDE = 37630; // 0x92fe

/** @apiSince 21 */

public static final int GL_ATOMIC_COUNTER_BARRIER_BIT = 4096; // 0x1000

/** @apiSince 21 */

public static final int GL_ATOMIC_COUNTER_BUFFER = 37568; // 0x92c0

/** @apiSince 21 */

public static final int GL_ATOMIC_COUNTER_BUFFER_BINDING = 37569; // 0x92c1

/** @apiSince 21 */

public static final int GL_ATOMIC_COUNTER_BUFFER_INDEX = 37633; // 0x9301

/** @apiSince 21 */

public static final int GL_ATOMIC_COUNTER_BUFFER_SIZE = 37571; // 0x92c3

/** @apiSince 21 */

public static final int GL_ATOMIC_COUNTER_BUFFER_START = 37570; // 0x92c2

/** @apiSince 21 */

public static final int GL_BLOCK_INDEX = 37629; // 0x92fd

/** @apiSince 21 */

public static final int GL_BUFFER_BINDING = 37634; // 0x9302

/** @apiSince 21 */

public static final int GL_BUFFER_DATA_SIZE = 37635; // 0x9303

/** @apiSince 21 */

public static final int GL_BUFFER_UPDATE_BARRIER_BIT = 512; // 0x200

/** @apiSince 21 */

public static final int GL_BUFFER_VARIABLE = 37605; // 0x92e5

/** @apiSince 21 */

public static final int GL_COMMAND_BARRIER_BIT = 64; // 0x40

/** @apiSince 21 */

public static final int GL_COMPUTE_SHADER = 37305; // 0x91b9

/** @apiSince 21 */

public static final int GL_COMPUTE_SHADER_BIT = 32; // 0x20

/** @apiSince 21 */

public static final int GL_COMPUTE_WORK_GROUP_SIZE = 33383; // 0x8267

/** @apiSince 21 */

public static final int GL_DEPTH_STENCIL_TEXTURE_MODE = 37098; // 0x90ea

/** @apiSince 21 */

public static final int GL_DISPATCH_INDIRECT_BUFFER = 37102; // 0x90ee

/** @apiSince 21 */

public static final int GL_DISPATCH_INDIRECT_BUFFER_BINDING = 37103; // 0x90ef

/** @apiSince 21 */

public static final int GL_DRAW_INDIRECT_BUFFER = 36671; // 0x8f3f

/** @apiSince 21 */

public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 36675; // 0x8f43

/** @apiSince 24 */

public static final int GL_ELEMENT_ARRAY_BARRIER_BIT = 2; // 0x2

/** @apiSince 21 */

public static final int GL_FRAGMENT_SHADER_BIT = 2; // 0x2

/** @apiSince 21 */

public static final int GL_FRAMEBUFFER_BARRIER_BIT = 1024; // 0x400

/** @apiSince 21 */

public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 37652; // 0x9314

/** @apiSince 21 */

public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 37649; // 0x9311

/** @apiSince 21 */

public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 37651; // 0x9313

/** @apiSince 21 */

public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 37648; // 0x9310

/** @apiSince 21 */

public static final int GL_IMAGE_2D = 36941; // 0x904d

/** @apiSince 21 */

public static final int GL_IMAGE_2D_ARRAY = 36947; // 0x9053

/** @apiSince 21 */

public static final int GL_IMAGE_3D = 36942; // 0x904e

/** @apiSince 21 */

public static final int GL_IMAGE_BINDING_ACCESS = 36670; // 0x8f3e

/** @apiSince 21 */

public static final int GL_IMAGE_BINDING_FORMAT = 36974; // 0x906e

/** @apiSince 21 */

public static final int GL_IMAGE_BINDING_LAYER = 36669; // 0x8f3d

/** @apiSince 21 */

public static final int GL_IMAGE_BINDING_LAYERED = 36668; // 0x8f3c

/** @apiSince 21 */

public static final int GL_IMAGE_BINDING_LEVEL = 36667; // 0x8f3b

/** @apiSince 21 */

public static final int GL_IMAGE_BINDING_NAME = 36666; // 0x8f3a

/** @apiSince 21 */

public static final int GL_IMAGE_CUBE = 36944; // 0x9050

/** @apiSince 21 */

public static final int GL_IMAGE_FORMAT_COMPATIBILITY_BY_CLASS = 37065; // 0x90c9

/** @apiSince 21 */

public static final int GL_IMAGE_FORMAT_COMPATIBILITY_BY_SIZE = 37064; // 0x90c8

/** @apiSince 21 */

public static final int GL_IMAGE_FORMAT_COMPATIBILITY_TYPE = 37063; // 0x90c7

/** @apiSince 21 */

public static final int GL_INT_IMAGE_2D = 36952; // 0x9058

/** @apiSince 21 */

public static final int GL_INT_IMAGE_2D_ARRAY = 36958; // 0x905e

/** @apiSince 21 */

public static final int GL_INT_IMAGE_3D = 36953; // 0x9059

/** @apiSince 21 */

public static final int GL_INT_IMAGE_CUBE = 36955; // 0x905b

/** @apiSince 21 */

public static final int GL_INT_SAMPLER_2D_MULTISAMPLE = 37129; // 0x9109

/** @apiSince 21 */

public static final int GL_IS_ROW_MAJOR = 37632; // 0x9300

/** @apiSince 21 */

public static final int GL_LOCATION = 37646; // 0x930e

/** @apiSince 21 */

public static final int GL_MATRIX_STRIDE = 37631; // 0x92ff

/** @apiSince 21 */

public static final int GL_MAX_ATOMIC_COUNTER_BUFFER_BINDINGS = 37596; // 0x92dc

/** @apiSince 21 */

public static final int GL_MAX_ATOMIC_COUNTER_BUFFER_SIZE = 37592; // 0x92d8

/** @apiSince 21 */

public static final int GL_MAX_COLOR_TEXTURE_SAMPLES = 37134; // 0x910e

/** @apiSince 21 */

public static final int GL_MAX_COMBINED_ATOMIC_COUNTERS = 37591; // 0x92d7

/** @apiSince 21 */

public static final int GL_MAX_COMBINED_ATOMIC_COUNTER_BUFFERS = 37585; // 0x92d1

/** @apiSince 21 */

public static final int GL_MAX_COMBINED_COMPUTE_UNIFORM_COMPONENTS = 33382; // 0x8266

/** @apiSince 21 */

public static final int GL_MAX_COMBINED_IMAGE_UNIFORMS = 37071; // 0x90cf

/** @apiSince 21 */

public static final int GL_MAX_COMBINED_SHADER_OUTPUT_RESOURCES = 36665; // 0x8f39

/** @apiSince 21 */

public static final int GL_MAX_COMBINED_SHADER_STORAGE_BLOCKS = 37084; // 0x90dc

/** @apiSince 21 */

public static final int GL_MAX_COMPUTE_ATOMIC_COUNTERS = 33381; // 0x8265

/** @apiSince 21 */

public static final int GL_MAX_COMPUTE_ATOMIC_COUNTER_BUFFERS = 33380; // 0x8264

/** @apiSince 21 */

public static final int GL_MAX_COMPUTE_IMAGE_UNIFORMS = 37309; // 0x91bd

/** @apiSince 21 */

public static final int GL_MAX_COMPUTE_SHADER_STORAGE_BLOCKS = 37083; // 0x90db

/** @apiSince 21 */

public static final int GL_MAX_COMPUTE_SHARED_MEMORY_SIZE = 33378; // 0x8262

/** @apiSince 21 */

public static final int GL_MAX_COMPUTE_TEXTURE_IMAGE_UNITS = 37308; // 0x91bc

/** @apiSince 21 */

public static final int GL_MAX_COMPUTE_UNIFORM_BLOCKS = 37307; // 0x91bb

/** @apiSince 21 */

public static final int GL_MAX_COMPUTE_UNIFORM_COMPONENTS = 33379; // 0x8263

/** @apiSince 21 */

public static final int GL_MAX_COMPUTE_WORK_GROUP_COUNT = 37310; // 0x91be

/** @apiSince 21 */

public static final int GL_MAX_COMPUTE_WORK_GROUP_INVOCATIONS = 37099; // 0x90eb

/** @apiSince 21 */

public static final int GL_MAX_COMPUTE_WORK_GROUP_SIZE = 37311; // 0x91bf

/** @apiSince 21 */

public static final int GL_MAX_DEPTH_TEXTURE_SAMPLES = 37135; // 0x910f

/** @apiSince 21 */

public static final int GL_MAX_FRAGMENT_ATOMIC_COUNTERS = 37590; // 0x92d6

/** @apiSince 21 */

public static final int GL_MAX_FRAGMENT_ATOMIC_COUNTER_BUFFERS = 37584; // 0x92d0

/** @apiSince 21 */

public static final int GL_MAX_FRAGMENT_IMAGE_UNIFORMS = 37070; // 0x90ce

/** @apiSince 21 */

public static final int GL_MAX_FRAGMENT_SHADER_STORAGE_BLOCKS = 37082; // 0x90da

/** @apiSince 21 */

public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 37654; // 0x9316

/** @apiSince 21 */

public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 37656; // 0x9318

/** @apiSince 21 */

public static final int GL_MAX_FRAMEBUFFER_WIDTH = 37653; // 0x9315

/** @apiSince 21 */

public static final int GL_MAX_IMAGE_UNITS = 36664; // 0x8f38

/** @apiSince 21 */

public static final int GL_MAX_INTEGER_SAMPLES = 37136; // 0x9110

/** @apiSince 21 */

public static final int GL_MAX_NAME_LENGTH = 37622; // 0x92f6

/** @apiSince 21 */

public static final int GL_MAX_NUM_ACTIVE_VARIABLES = 37623; // 0x92f7

/** @apiSince 21 */

public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_OFFSET = 36447; // 0x8e5f

/** @apiSince 21 */

public static final int GL_MAX_SAMPLE_MASK_WORDS = 36441; // 0x8e59

/** @apiSince 21 */

public static final int GL_MAX_SHADER_STORAGE_BLOCK_SIZE = 37086; // 0x90de

/** @apiSince 21 */

public static final int GL_MAX_SHADER_STORAGE_BUFFER_BINDINGS = 37085; // 0x90dd

/** @apiSince 21 */

public static final int GL_MAX_UNIFORM_LOCATIONS = 33390; // 0x826e

/** @apiSince 21 */

public static final int GL_MAX_VERTEX_ATOMIC_COUNTERS = 37586; // 0x92d2

/** @apiSince 21 */

public static final int GL_MAX_VERTEX_ATOMIC_COUNTER_BUFFERS = 37580; // 0x92cc

/** @apiSince 21 */

public static final int GL_MAX_VERTEX_ATTRIB_BINDINGS = 33498; // 0x82da

/** @apiSince 21 */

public static final int GL_MAX_VERTEX_ATTRIB_RELATIVE_OFFSET = 33497; // 0x82d9

/** @apiSince 21 */

public static final int GL_MAX_VERTEX_ATTRIB_STRIDE = 33509; // 0x82e5

/** @apiSince 21 */

public static final int GL_MAX_VERTEX_IMAGE_UNIFORMS = 37066; // 0x90ca

/** @apiSince 21 */

public static final int GL_MAX_VERTEX_SHADER_STORAGE_BLOCKS = 37078; // 0x90d6

/** @apiSince 21 */

public static final int GL_MIN_PROGRAM_TEXTURE_GATHER_OFFSET = 36446; // 0x8e5e

/** @apiSince 21 */

public static final int GL_NAME_LENGTH = 37625; // 0x92f9

/** @apiSince 21 */

public static final int GL_NUM_ACTIVE_VARIABLES = 37636; // 0x9304

/** @apiSince 21 */

public static final int GL_OFFSET = 37628; // 0x92fc

/** @apiSince 21 */

public static final int GL_PIXEL_BUFFER_BARRIER_BIT = 128; // 0x80

/** @apiSince 21 */

public static final int GL_PROGRAM_INPUT = 37603; // 0x92e3

/** @apiSince 21 */

public static final int GL_PROGRAM_OUTPUT = 37604; // 0x92e4

/** @apiSince 21 */

public static final int GL_PROGRAM_PIPELINE_BINDING = 33370; // 0x825a

/** @apiSince 21 */

public static final int GL_PROGRAM_SEPARABLE = 33368; // 0x8258

/** @apiSince 21 */

public static final int GL_READ_ONLY = 35000; // 0x88b8

/** @apiSince 21 */

public static final int GL_READ_WRITE = 35002; // 0x88ba

/** @apiSince 21 */

public static final int GL_REFERENCED_BY_COMPUTE_SHADER = 37643; // 0x930b

/** @apiSince 21 */

public static final int GL_REFERENCED_BY_FRAGMENT_SHADER = 37642; // 0x930a

/** @apiSince 21 */

public static final int GL_REFERENCED_BY_VERTEX_SHADER = 37638; // 0x9306

/** @apiSince 21 */

public static final int GL_SAMPLER_2D_MULTISAMPLE = 37128; // 0x9108

/** @apiSince 21 */

public static final int GL_SAMPLE_MASK = 36433; // 0x8e51

/** @apiSince 21 */

public static final int GL_SAMPLE_MASK_VALUE = 36434; // 0x8e52

/** @apiSince 21 */

public static final int GL_SAMPLE_POSITION = 36432; // 0x8e50

/** @apiSince 24 */

public static final int GL_SHADER_IMAGE_ACCESS_BARRIER_BIT = 32; // 0x20

/** @apiSince 21 */

public static final int GL_SHADER_STORAGE_BARRIER_BIT = 8192; // 0x2000

/** @apiSince 21 */

public static final int GL_SHADER_STORAGE_BLOCK = 37606; // 0x92e6

/** @apiSince 21 */

public static final int GL_SHADER_STORAGE_BUFFER = 37074; // 0x90d2

/** @apiSince 21 */

public static final int GL_SHADER_STORAGE_BUFFER_BINDING = 37075; // 0x90d3

/** @apiSince 21 */

public static final int GL_SHADER_STORAGE_BUFFER_OFFSET_ALIGNMENT = 37087; // 0x90df

/** @apiSince 21 */

public static final int GL_SHADER_STORAGE_BUFFER_SIZE = 37077; // 0x90d5

/** @apiSince 21 */

public static final int GL_SHADER_STORAGE_BUFFER_START = 37076; // 0x90d4

/** @apiSince 21 */

public static final int GL_STENCIL_INDEX = 6401; // 0x1901

/** @apiSince 21 */

public static final int GL_TEXTURE_2D_MULTISAMPLE = 37120; // 0x9100

/** @apiSince 21 */

public static final int GL_TEXTURE_ALPHA_SIZE = 32863; // 0x805f

/** @apiSince 21 */

public static final int GL_TEXTURE_ALPHA_TYPE = 35859; // 0x8c13

/** @apiSince 21 */

public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE = 37124; // 0x9104

/** @apiSince 21 */

public static final int GL_TEXTURE_BLUE_SIZE = 32862; // 0x805e

/** @apiSince 21 */

public static final int GL_TEXTURE_BLUE_TYPE = 35858; // 0x8c12

/** @apiSince 21 */

public static final int GL_TEXTURE_COMPRESSED = 34465; // 0x86a1

/** @apiSince 21 */

public static final int GL_TEXTURE_DEPTH = 32881; // 0x8071

/** @apiSince 21 */

public static final int GL_TEXTURE_DEPTH_SIZE = 34890; // 0x884a

/** @apiSince 21 */

public static final int GL_TEXTURE_DEPTH_TYPE = 35862; // 0x8c16

/** @apiSince 21 */

public static final int GL_TEXTURE_FETCH_BARRIER_BIT = 8; // 0x8

/** @apiSince 21 */

public static final int GL_TEXTURE_FIXED_SAMPLE_LOCATIONS = 37127; // 0x9107

/** @apiSince 21 */

public static final int GL_TEXTURE_GREEN_SIZE = 32861; // 0x805d

/** @apiSince 21 */

public static final int GL_TEXTURE_GREEN_TYPE = 35857; // 0x8c11

/** @apiSince 21 */

public static final int GL_TEXTURE_HEIGHT = 4097; // 0x1001

/** @apiSince 21 */

public static final int GL_TEXTURE_INTERNAL_FORMAT = 4099; // 0x1003

/** @apiSince 21 */

public static final int GL_TEXTURE_RED_SIZE = 32860; // 0x805c

/** @apiSince 21 */

public static final int GL_TEXTURE_RED_TYPE = 35856; // 0x8c10

/** @apiSince 21 */

public static final int GL_TEXTURE_SAMPLES = 37126; // 0x9106

/** @apiSince 21 */

public static final int GL_TEXTURE_SHARED_SIZE = 35903; // 0x8c3f

/** @apiSince 21 */

public static final int GL_TEXTURE_STENCIL_SIZE = 35057; // 0x88f1

/** @apiSince 21 */

public static final int GL_TEXTURE_UPDATE_BARRIER_BIT = 256; // 0x100

/** @apiSince 21 */

public static final int GL_TEXTURE_WIDTH = 4096; // 0x1000

/** @apiSince 21 */

public static final int GL_TOP_LEVEL_ARRAY_SIZE = 37644; // 0x930c

/** @apiSince 21 */

public static final int GL_TOP_LEVEL_ARRAY_STRIDE = 37645; // 0x930d

/** @apiSince 21 */

public static final int GL_TRANSFORM_FEEDBACK_BARRIER_BIT = 2048; // 0x800

/** @apiSince 21 */

public static final int GL_TRANSFORM_FEEDBACK_VARYING = 37620; // 0x92f4

/** @apiSince 21 */

public static final int GL_TYPE = 37626; // 0x92fa

/** @apiSince 21 */

public static final int GL_UNIFORM = 37601; // 0x92e1

/** @apiSince 21 */

public static final int GL_UNIFORM_BARRIER_BIT = 4; // 0x4

/** @apiSince 21 */

public static final int GL_UNIFORM_BLOCK = 37602; // 0x92e2

/** @apiSince 21 */

public static final int GL_UNSIGNED_INT_ATOMIC_COUNTER = 37595; // 0x92db

/** @apiSince 21 */

public static final int GL_UNSIGNED_INT_IMAGE_2D = 36963; // 0x9063

/** @apiSince 21 */

public static final int GL_UNSIGNED_INT_IMAGE_2D_ARRAY = 36969; // 0x9069

/** @apiSince 21 */

public static final int GL_UNSIGNED_INT_IMAGE_3D = 36964; // 0x9064

/** @apiSince 21 */

public static final int GL_UNSIGNED_INT_IMAGE_CUBE = 36966; // 0x9066

/** @apiSince 21 */

public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE = 37130; // 0x910a

/** @apiSince 24 */

public static final int GL_VERTEX_ATTRIB_ARRAY_BARRIER_BIT = 1; // 0x1

/** @apiSince 21 */

public static final int GL_VERTEX_ATTRIB_BINDING = 33492; // 0x82d4

/** @apiSince 21 */

public static final int GL_VERTEX_ATTRIB_RELATIVE_OFFSET = 33493; // 0x82d5

/** @apiSince 21 */

public static final int GL_VERTEX_BINDING_BUFFER = 36687; // 0x8f4f

/** @apiSince 21 */

public static final int GL_VERTEX_BINDING_DIVISOR = 33494; // 0x82d6

/** @apiSince 21 */

public static final int GL_VERTEX_BINDING_OFFSET = 33495; // 0x82d7

/** @apiSince 21 */

public static final int GL_VERTEX_BINDING_STRIDE = 33496; // 0x82d8

/** @apiSince 21 */

public static final int GL_VERTEX_SHADER_BIT = 1; // 0x1

/** @apiSince 21 */

public static final int GL_WRITE_ONLY = 35001; // 0x88b9
}

