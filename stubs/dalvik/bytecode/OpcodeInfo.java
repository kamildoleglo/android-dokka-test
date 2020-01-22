/*
 * Copyright (C) 2010 The Android Open Source Project
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



package dalvik.bytecode;


/**
 * Information about Dalvik opcodes.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class OpcodeInfo {

private OpcodeInfo() { throw new RuntimeException("Stub!"); }

/**
 * The maximum possible "packed value" of a Dalvik opcode. The
 * packed value of an opcode is a denser representation that is
 * only used when reporting usage statistics. The mapping between
 * packed opcode values and regular opcode values is
 * implementation-specific and may vary over time.
 *
 * <p><b>Note:</b>: This is constant in any given VM incarnation,
 * but it is subject to change over time, so it is not appropriate
 * to represent as a compile-time constant value.</p>
 * @apiSince 11
 */

public static final int MAXIMUM_PACKED_VALUE;
static { MAXIMUM_PACKED_VALUE = 0; }

/**
 * The maximum possible value of a Dalvik opcode.
 *
 * <p><b>Note:</b>: This is constant in any given VM incarnation,
 * but it is subject to change over time, so it is not appropriate
 * to represent as a compile-time constant value.</p>
 * @apiSince 11
 */

public static final int MAXIMUM_VALUE;
static { MAXIMUM_VALUE = 0; }
}

