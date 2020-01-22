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



package dalvik.bytecode;


/**
 * A list of all normal (not implementation-specific) Dalvik opcodes.
 *
 * @see <a href="https://source.android.com/devices/tech/dalvik/dalvik-bytecode">Dalvik bytecode</a>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface Opcodes {

/** @apiSince 1 */

public static final int OP_ADD_DOUBLE = 171; // 0xab

/** @apiSince 1 */

public static final int OP_ADD_DOUBLE_2ADDR = 203; // 0xcb

/** @apiSince 1 */

public static final int OP_ADD_FLOAT = 166; // 0xa6

/** @apiSince 1 */

public static final int OP_ADD_FLOAT_2ADDR = 198; // 0xc6

/** @apiSince 1 */

public static final int OP_ADD_INT = 144; // 0x90

/** @apiSince 1 */

public static final int OP_ADD_INT_2ADDR = 176; // 0xb0

/** @apiSince 1 */

public static final int OP_ADD_INT_LIT16 = 208; // 0xd0

/** @apiSince 1 */

public static final int OP_ADD_INT_LIT8 = 216; // 0xd8

/** @apiSince 1 */

public static final int OP_ADD_LONG = 155; // 0x9b

/** @apiSince 1 */

public static final int OP_ADD_LONG_2ADDR = 187; // 0xbb

/** @apiSince 1 */

public static final int OP_AGET = 68; // 0x44

/** @apiSince 1 */

public static final int OP_AGET_BOOLEAN = 71; // 0x47

/** @apiSince 1 */

public static final int OP_AGET_BYTE = 72; // 0x48

/** @apiSince 1 */

public static final int OP_AGET_CHAR = 73; // 0x49

/** @apiSince 1 */

public static final int OP_AGET_OBJECT = 70; // 0x46

/** @apiSince 1 */

public static final int OP_AGET_SHORT = 74; // 0x4a

/** @apiSince 1 */

public static final int OP_AGET_WIDE = 69; // 0x45

/** @apiSince 1 */

public static final int OP_AND_INT = 149; // 0x95

/** @apiSince 1 */

public static final int OP_AND_INT_2ADDR = 181; // 0xb5

/** @apiSince 1 */

public static final int OP_AND_INT_LIT16 = 213; // 0xd5

/** @apiSince 1 */

public static final int OP_AND_INT_LIT8 = 221; // 0xdd

/** @apiSince 1 */

public static final int OP_AND_LONG = 160; // 0xa0

/** @apiSince 1 */

public static final int OP_AND_LONG_2ADDR = 192; // 0xc0

/** @apiSince 1 */

public static final int OP_APUT = 75; // 0x4b

/** @apiSince 1 */

public static final int OP_APUT_BOOLEAN = 78; // 0x4e

/** @apiSince 1 */

public static final int OP_APUT_BYTE = 79; // 0x4f

/** @apiSince 1 */

public static final int OP_APUT_CHAR = 80; // 0x50

/** @apiSince 1 */

public static final int OP_APUT_OBJECT = 77; // 0x4d

/** @apiSince 1 */

public static final int OP_APUT_SHORT = 81; // 0x51

/** @apiSince 1 */

public static final int OP_APUT_WIDE = 76; // 0x4c

/** @apiSince 1 */

public static final int OP_ARRAY_LENGTH = 33; // 0x21

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 8
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_BREAKPOINT = 236; // 0xec

/** @apiSince 1 */

public static final int OP_CHECK_CAST = 31; // 0x1f

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_CHECK_CAST_JUMBO = 511; // 0x1ff

/** @apiSince 1 */

public static final int OP_CMPG_DOUBLE = 48; // 0x30

/** @apiSince 1 */

public static final int OP_CMPG_FLOAT = 46; // 0x2e

/** @apiSince 1 */

public static final int OP_CMPL_DOUBLE = 47; // 0x2f

/** @apiSince 1 */

public static final int OP_CMPL_FLOAT = 45; // 0x2d

/** @apiSince 1 */

public static final int OP_CMP_LONG = 49; // 0x31

/** @apiSince 1 */

public static final int OP_CONST = 20; // 0x14

/** @apiSince 1 */

public static final int OP_CONST_16 = 19; // 0x13

/** @apiSince 1 */

public static final int OP_CONST_4 = 18; // 0x12

/** @apiSince 1 */

public static final int OP_CONST_CLASS = 28; // 0x1c

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_CONST_CLASS_JUMBO = 255; // 0xff

/** @apiSince 1 */

public static final int OP_CONST_HIGH16 = 21; // 0x15

/** @apiSince 28 */

public static final int OP_CONST_METHOD_HANDLE = 254; // 0xfe

/** @apiSince 28 */

public static final int OP_CONST_METHOD_TYPE = 255; // 0xff

/** @apiSince 1 */

public static final int OP_CONST_STRING = 26; // 0x1a

/** @apiSince 1 */

public static final int OP_CONST_STRING_JUMBO = 27; // 0x1b

/** @apiSince 1 */

public static final int OP_CONST_WIDE = 24; // 0x18

/** @apiSince 1 */

public static final int OP_CONST_WIDE_16 = 22; // 0x16

/** @apiSince 1 */

public static final int OP_CONST_WIDE_32 = 23; // 0x17

/** @apiSince 1 */

public static final int OP_CONST_WIDE_HIGH16 = 25; // 0x19

/** @apiSince 1 */

public static final int OP_DIV_DOUBLE = 174; // 0xae

/** @apiSince 1 */

public static final int OP_DIV_DOUBLE_2ADDR = 206; // 0xce

/** @apiSince 1 */

public static final int OP_DIV_FLOAT = 169; // 0xa9

/** @apiSince 1 */

public static final int OP_DIV_FLOAT_2ADDR = 201; // 0xc9

/** @apiSince 1 */

public static final int OP_DIV_INT = 147; // 0x93

/** @apiSince 1 */

public static final int OP_DIV_INT_2ADDR = 179; // 0xb3

/** @apiSince 1 */

public static final int OP_DIV_INT_LIT16 = 211; // 0xd3

/** @apiSince 1 */

public static final int OP_DIV_INT_LIT8 = 219; // 0xdb

/** @apiSince 1 */

public static final int OP_DIV_LONG = 158; // 0x9e

/** @apiSince 1 */

public static final int OP_DIV_LONG_2ADDR = 190; // 0xbe

/** @apiSince 1 */

public static final int OP_DOUBLE_TO_FLOAT = 140; // 0x8c

/** @apiSince 1 */

public static final int OP_DOUBLE_TO_INT = 138; // 0x8a

/** @apiSince 1 */

public static final int OP_DOUBLE_TO_LONG = 139; // 0x8b

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_EXECUTE_INLINE = 238; // 0xee

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 8
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_EXECUTE_INLINE_RANGE = 239; // 0xef

/** @apiSince 1 */

public static final int OP_FILLED_NEW_ARRAY = 36; // 0x24

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_FILLED_NEW_ARRAY_JUMBO = 1535; // 0x5ff

/** @apiSince 1 */

public static final int OP_FILLED_NEW_ARRAY_RANGE = 37; // 0x25

/** @apiSince 1 */

public static final int OP_FILL_ARRAY_DATA = 38; // 0x26

/** @apiSince 1 */

public static final int OP_FLOAT_TO_DOUBLE = 137; // 0x89

/** @apiSince 1 */

public static final int OP_FLOAT_TO_INT = 135; // 0x87

/** @apiSince 1 */

public static final int OP_FLOAT_TO_LONG = 136; // 0x88

/** @apiSince 1 */

public static final int OP_GOTO = 40; // 0x28

/** @apiSince 1 */

public static final int OP_GOTO_16 = 41; // 0x29

/** @apiSince 1 */

public static final int OP_GOTO_32 = 42; // 0x2a

/** @apiSince 1 */

public static final int OP_IF_EQ = 50; // 0x32

/** @apiSince 1 */

public static final int OP_IF_EQZ = 56; // 0x38

/** @apiSince 1 */

public static final int OP_IF_GE = 53; // 0x35

/** @apiSince 1 */

public static final int OP_IF_GEZ = 59; // 0x3b

/** @apiSince 1 */

public static final int OP_IF_GT = 54; // 0x36

/** @apiSince 1 */

public static final int OP_IF_GTZ = 60; // 0x3c

/** @apiSince 1 */

public static final int OP_IF_LE = 55; // 0x37

/** @apiSince 1 */

public static final int OP_IF_LEZ = 61; // 0x3d

/** @apiSince 1 */

public static final int OP_IF_LT = 52; // 0x34

/** @apiSince 1 */

public static final int OP_IF_LTZ = 58; // 0x3a

/** @apiSince 1 */

public static final int OP_IF_NE = 51; // 0x33

/** @apiSince 1 */

public static final int OP_IF_NEZ = 57; // 0x39

/** @apiSince 1 */

public static final int OP_IGET = 82; // 0x52

/** @apiSince 1 */

public static final int OP_IGET_BOOLEAN = 85; // 0x55

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_IGET_BOOLEAN_JUMBO = 2559; // 0x9ff

/** @apiSince 1 */

public static final int OP_IGET_BYTE = 86; // 0x56

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_IGET_BYTE_JUMBO = 2815; // 0xaff

/** @apiSince 1 */

public static final int OP_IGET_CHAR = 87; // 0x57

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_IGET_CHAR_JUMBO = 3071; // 0xbff

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_IGET_JUMBO = 1791; // 0x6ff

/** @apiSince 1 */

public static final int OP_IGET_OBJECT = 84; // 0x54

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_IGET_OBJECT_JUMBO = 2303; // 0x8ff

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_IGET_OBJECT_QUICK = 244; // 0xf4

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_IGET_QUICK = 242; // 0xf2

/** @apiSince 1 */

public static final int OP_IGET_SHORT = 88; // 0x58

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_IGET_SHORT_JUMBO = 3327; // 0xcff

/** @apiSince 1 */

public static final int OP_IGET_WIDE = 83; // 0x53

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_IGET_WIDE_JUMBO = 2047; // 0x7ff

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_IGET_WIDE_QUICK = 243; // 0xf3

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 9
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_IGET_WIDE_VOLATILE = 232; // 0xe8

/** @apiSince 1 */

public static final int OP_INSTANCE_OF = 32; // 0x20

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_INSTANCE_OF_JUMBO = 767; // 0x2ff

/** @apiSince 1 */

public static final int OP_INT_TO_BYTE = 141; // 0x8d

/** @apiSince 1 */

public static final int OP_INT_TO_CHAR = 142; // 0x8e

/** @apiSince 1 */

public static final int OP_INT_TO_DOUBLE = 131; // 0x83

/** @apiSince 1 */

public static final int OP_INT_TO_FLOAT = 130; // 0x82

/** @apiSince 1 */

public static final int OP_INT_TO_LONG = 129; // 0x81

/** @apiSince 1 */

public static final int OP_INT_TO_SHORT = 143; // 0x8f

/** @apiSince 26 */

public static final int OP_INVOKE_CUSTOM = 252; // 0xfc

/** @apiSince 26 */

public static final int OP_INVOKE_CUSTOM_RANGE = 253; // 0xfd

/** @apiSince 1 */

public static final int OP_INVOKE_DIRECT = 112; // 0x70

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_INVOKE_DIRECT_EMPTY = 240; // 0xf0

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_INVOKE_DIRECT_JUMBO = 9471; // 0x24ff

/** @apiSince 1 */

public static final int OP_INVOKE_DIRECT_RANGE = 118; // 0x76

/** @apiSince 1 */

public static final int OP_INVOKE_INTERFACE = 114; // 0x72

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_INVOKE_INTERFACE_JUMBO = 9983; // 0x26ff

/** @apiSince 1 */

public static final int OP_INVOKE_INTERFACE_RANGE = 120; // 0x78

/** @apiSince 26 */

public static final int OP_INVOKE_POLYMORPHIC = 250; // 0xfa

/** @apiSince 26 */

public static final int OP_INVOKE_POLYMORPHIC_RANGE = 251; // 0xfb

/** @apiSince 1 */

public static final int OP_INVOKE_STATIC = 113; // 0x71

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_INVOKE_STATIC_JUMBO = 9727; // 0x25ff

/** @apiSince 1 */

public static final int OP_INVOKE_STATIC_RANGE = 119; // 0x77

/** @apiSince 1 */

public static final int OP_INVOKE_SUPER = 111; // 0x6f

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_INVOKE_SUPER_JUMBO = 9215; // 0x23ff

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_INVOKE_SUPER_QUICK = 250; // 0xfa

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_INVOKE_SUPER_QUICK_RANGE = 251; // 0xfb

/** @apiSince 1 */

public static final int OP_INVOKE_SUPER_RANGE = 117; // 0x75

/** @apiSince 1 */

public static final int OP_INVOKE_VIRTUAL = 110; // 0x6e

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_INVOKE_VIRTUAL_JUMBO = 8959; // 0x22ff

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_INVOKE_VIRTUAL_QUICK = 248; // 0xf8

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_INVOKE_VIRTUAL_QUICK_RANGE = 249; // 0xf9

/** @apiSince 1 */

public static final int OP_INVOKE_VIRTUAL_RANGE = 116; // 0x74

/** @apiSince 1 */

public static final int OP_IPUT = 89; // 0x59

/** @apiSince 1 */

public static final int OP_IPUT_BOOLEAN = 92; // 0x5c

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_IPUT_BOOLEAN_JUMBO = 4351; // 0x10ff

/** @apiSince 1 */

public static final int OP_IPUT_BYTE = 93; // 0x5d

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_IPUT_BYTE_JUMBO = 4607; // 0x11ff

/** @apiSince 1 */

public static final int OP_IPUT_CHAR = 94; // 0x5e

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_IPUT_CHAR_JUMBO = 4863; // 0x12ff

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_IPUT_JUMBO = 3583; // 0xdff

/** @apiSince 1 */

public static final int OP_IPUT_OBJECT = 91; // 0x5b

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_IPUT_OBJECT_JUMBO = 4095; // 0xfff

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_IPUT_OBJECT_QUICK = 247; // 0xf7

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_IPUT_QUICK = 245; // 0xf5

/** @apiSince 1 */

public static final int OP_IPUT_SHORT = 95; // 0x5f

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_IPUT_SHORT_JUMBO = 5119; // 0x13ff

/** @apiSince 1 */

public static final int OP_IPUT_WIDE = 90; // 0x5a

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_IPUT_WIDE_JUMBO = 3839; // 0xeff

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_IPUT_WIDE_QUICK = 246; // 0xf6

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 9
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_IPUT_WIDE_VOLATILE = 233; // 0xe9

/** @apiSince 1 */

public static final int OP_LONG_TO_DOUBLE = 134; // 0x86

/** @apiSince 1 */

public static final int OP_LONG_TO_FLOAT = 133; // 0x85

/** @apiSince 1 */

public static final int OP_LONG_TO_INT = 132; // 0x84

/** @apiSince 1 */

public static final int OP_MONITOR_ENTER = 29; // 0x1d

/** @apiSince 1 */

public static final int OP_MONITOR_EXIT = 30; // 0x1e

/** @apiSince 1 */

public static final int OP_MOVE = 1; // 0x1

/** @apiSince 1 */

public static final int OP_MOVE_16 = 3; // 0x3

/** @apiSince 1 */

public static final int OP_MOVE_EXCEPTION = 13; // 0xd

/** @apiSince 1 */

public static final int OP_MOVE_FROM16 = 2; // 0x2

/** @apiSince 1 */

public static final int OP_MOVE_OBJECT = 7; // 0x7

/** @apiSince 1 */

public static final int OP_MOVE_OBJECT_16 = 9; // 0x9

/** @apiSince 1 */

public static final int OP_MOVE_OBJECT_FROM16 = 8; // 0x8

/** @apiSince 1 */

public static final int OP_MOVE_RESULT = 10; // 0xa

/** @apiSince 1 */

public static final int OP_MOVE_RESULT_OBJECT = 12; // 0xc

/** @apiSince 1 */

public static final int OP_MOVE_RESULT_WIDE = 11; // 0xb

/** @apiSince 1 */

public static final int OP_MOVE_WIDE = 4; // 0x4

/** @apiSince 1 */

public static final int OP_MOVE_WIDE_16 = 6; // 0x6

/** @apiSince 1 */

public static final int OP_MOVE_WIDE_FROM16 = 5; // 0x5

/** @apiSince 1 */

public static final int OP_MUL_DOUBLE = 173; // 0xad

/** @apiSince 1 */

public static final int OP_MUL_DOUBLE_2ADDR = 205; // 0xcd

/** @apiSince 1 */

public static final int OP_MUL_FLOAT = 168; // 0xa8

/** @apiSince 1 */

public static final int OP_MUL_FLOAT_2ADDR = 200; // 0xc8

/** @apiSince 1 */

public static final int OP_MUL_INT = 146; // 0x92

/** @apiSince 1 */

public static final int OP_MUL_INT_2ADDR = 178; // 0xb2

/** @apiSince 1 */

public static final int OP_MUL_INT_LIT16 = 210; // 0xd2

/** @apiSince 1 */

public static final int OP_MUL_INT_LIT8 = 218; // 0xda

/** @apiSince 1 */

public static final int OP_MUL_LONG = 157; // 0x9d

/** @apiSince 1 */

public static final int OP_MUL_LONG_2ADDR = 189; // 0xbd

/** @apiSince 1 */

public static final int OP_NEG_DOUBLE = 128; // 0x80

/** @apiSince 1 */

public static final int OP_NEG_FLOAT = 127; // 0x7f

/** @apiSince 1 */

public static final int OP_NEG_INT = 123; // 0x7b

/** @apiSince 1 */

public static final int OP_NEG_LONG = 125; // 0x7d

/** @apiSince 1 */

public static final int OP_NEW_ARRAY = 35; // 0x23

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_NEW_ARRAY_JUMBO = 1279; // 0x4ff

/** @apiSince 1 */

public static final int OP_NEW_INSTANCE = 34; // 0x22

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_NEW_INSTANCE_JUMBO = 1023; // 0x3ff

/** @apiSince 1 */

public static final int OP_NOP = 0; // 0x0

/** @apiSince 1 */

public static final int OP_NOT_INT = 124; // 0x7c

/** @apiSince 1 */

public static final int OP_NOT_LONG = 126; // 0x7e

/** @apiSince 1 */

public static final int OP_OR_INT = 150; // 0x96

/** @apiSince 1 */

public static final int OP_OR_INT_2ADDR = 182; // 0xb6

/** @apiSince 1 */

public static final int OP_OR_INT_LIT16 = 214; // 0xd6

/** @apiSince 1 */

public static final int OP_OR_INT_LIT8 = 222; // 0xde

/** @apiSince 1 */

public static final int OP_OR_LONG = 161; // 0xa1

/** @apiSince 1 */

public static final int OP_OR_LONG_2ADDR = 193; // 0xc1

/** @apiSince 1 */

public static final int OP_PACKED_SWITCH = 43; // 0x2b

/** @apiSince 1 */

public static final int OP_REM_DOUBLE = 175; // 0xaf

/** @apiSince 1 */

public static final int OP_REM_DOUBLE_2ADDR = 207; // 0xcf

/** @apiSince 1 */

public static final int OP_REM_FLOAT = 170; // 0xaa

/** @apiSince 1 */

public static final int OP_REM_FLOAT_2ADDR = 202; // 0xca

/** @apiSince 1 */

public static final int OP_REM_INT = 148; // 0x94

/** @apiSince 1 */

public static final int OP_REM_INT_2ADDR = 180; // 0xb4

/** @apiSince 1 */

public static final int OP_REM_INT_LIT16 = 212; // 0xd4

/** @apiSince 1 */

public static final int OP_REM_INT_LIT8 = 220; // 0xdc

/** @apiSince 1 */

public static final int OP_REM_LONG = 159; // 0x9f

/** @apiSince 1 */

public static final int OP_REM_LONG_2ADDR = 191; // 0xbf

/** @apiSince 1 */

public static final int OP_RETURN = 15; // 0xf

/** @apiSince 1 */

public static final int OP_RETURN_OBJECT = 17; // 0x11

/** @apiSince 1 */

public static final int OP_RETURN_VOID = 14; // 0xe

/** @apiSince 1 */

public static final int OP_RETURN_WIDE = 16; // 0x10

/** @apiSince 1 */

public static final int OP_RSUB_INT = 209; // 0xd1

/** @apiSince 1 */

public static final int OP_RSUB_INT_LIT8 = 217; // 0xd9

/** @apiSince 1 */

public static final int OP_SGET = 96; // 0x60

/** @apiSince 1 */

public static final int OP_SGET_BOOLEAN = 99; // 0x63

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_SGET_BOOLEAN_JUMBO = 6143; // 0x17ff

/** @apiSince 1 */

public static final int OP_SGET_BYTE = 100; // 0x64

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_SGET_BYTE_JUMBO = 6399; // 0x18ff

/** @apiSince 1 */

public static final int OP_SGET_CHAR = 101; // 0x65

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_SGET_CHAR_JUMBO = 6655; // 0x19ff

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_SGET_JUMBO = 5375; // 0x14ff

/** @apiSince 1 */

public static final int OP_SGET_OBJECT = 98; // 0x62

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_SGET_OBJECT_JUMBO = 5887; // 0x16ff

/** @apiSince 1 */

public static final int OP_SGET_SHORT = 102; // 0x66

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_SGET_SHORT_JUMBO = 6911; // 0x1aff

/** @apiSince 1 */

public static final int OP_SGET_WIDE = 97; // 0x61

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_SGET_WIDE_JUMBO = 5631; // 0x15ff

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 9
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_SGET_WIDE_VOLATILE = 234; // 0xea

/** @apiSince 1 */

public static final int OP_SHL_INT = 152; // 0x98

/** @apiSince 1 */

public static final int OP_SHL_INT_2ADDR = 184; // 0xb8

/** @apiSince 1 */

public static final int OP_SHL_INT_LIT8 = 224; // 0xe0

/** @apiSince 1 */

public static final int OP_SHL_LONG = 163; // 0xa3

/** @apiSince 1 */

public static final int OP_SHL_LONG_2ADDR = 195; // 0xc3

/** @apiSince 1 */

public static final int OP_SHR_INT = 153; // 0x99

/** @apiSince 1 */

public static final int OP_SHR_INT_2ADDR = 185; // 0xb9

/** @apiSince 1 */

public static final int OP_SHR_INT_LIT8 = 225; // 0xe1

/** @apiSince 1 */

public static final int OP_SHR_LONG = 164; // 0xa4

/** @apiSince 1 */

public static final int OP_SHR_LONG_2ADDR = 196; // 0xc4

/** @apiSince 1 */

public static final int OP_SPARSE_SWITCH = 44; // 0x2c

/** @apiSince 1 */

public static final int OP_SPUT = 103; // 0x67

/** @apiSince 1 */

public static final int OP_SPUT_BOOLEAN = 106; // 0x6a

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_SPUT_BOOLEAN_JUMBO = 7935; // 0x1eff

/** @apiSince 1 */

public static final int OP_SPUT_BYTE = 107; // 0x6b

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_SPUT_BYTE_JUMBO = 8191; // 0x1fff

/** @apiSince 1 */

public static final int OP_SPUT_CHAR = 108; // 0x6c

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_SPUT_CHAR_JUMBO = 8447; // 0x20ff

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_SPUT_JUMBO = 7167; // 0x1bff

/** @apiSince 1 */

public static final int OP_SPUT_OBJECT = 105; // 0x69

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_SPUT_OBJECT_JUMBO = 7679; // 0x1dff

/** @apiSince 1 */

public static final int OP_SPUT_SHORT = 109; // 0x6d

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_SPUT_SHORT_JUMBO = 8703; // 0x21ff

/** @apiSince 1 */

public static final int OP_SPUT_WIDE = 104; // 0x68

/**
 * Never implemented; do not use.
 * @apiSince 11
 */

public static final int OP_SPUT_WIDE_JUMBO = 7423; // 0x1cff

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 9
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_SPUT_WIDE_VOLATILE = 235; // 0xeb

/** @apiSince 1 */

public static final int OP_SUB_DOUBLE = 172; // 0xac

/** @apiSince 1 */

public static final int OP_SUB_DOUBLE_2ADDR = 204; // 0xcc

/** @apiSince 1 */

public static final int OP_SUB_FLOAT = 167; // 0xa7

/** @apiSince 1 */

public static final int OP_SUB_FLOAT_2ADDR = 199; // 0xc7

/** @apiSince 1 */

public static final int OP_SUB_INT = 145; // 0x91

/** @apiSince 1 */

public static final int OP_SUB_INT_2ADDR = 177; // 0xb1

/** @apiSince 1 */

public static final int OP_SUB_LONG = 156; // 0x9c

/** @apiSince 1 */

public static final int OP_SUB_LONG_2ADDR = 188; // 0xbc

/** @apiSince 1 */

public static final int OP_THROW = 39; // 0x27

/**
 * Implementation detail.
 * @deprecated Implementation detail.
 * @apiSince 8
 * @deprecatedSince 15
 */

@Deprecated public static final int OP_THROW_VERIFICATION_ERROR = 237; // 0xed

/** @apiSince 1 */

public static final int OP_USHR_INT = 154; // 0x9a

/** @apiSince 1 */

public static final int OP_USHR_INT_2ADDR = 186; // 0xba

/** @apiSince 1 */

public static final int OP_USHR_INT_LIT8 = 226; // 0xe2

/** @apiSince 1 */

public static final int OP_USHR_LONG = 165; // 0xa5

/** @apiSince 1 */

public static final int OP_USHR_LONG_2ADDR = 197; // 0xc5

/** @apiSince 1 */

public static final int OP_XOR_INT = 151; // 0x97

/** @apiSince 1 */

public static final int OP_XOR_INT_2ADDR = 183; // 0xb7

/** @apiSince 1 */

public static final int OP_XOR_INT_LIT16 = 215; // 0xd7

/** @apiSince 1 */

public static final int OP_XOR_INT_LIT8 = 223; // 0xdf

/** @apiSince 1 */

public static final int OP_XOR_LONG = 162; // 0xa2

/** @apiSince 1 */

public static final int OP_XOR_LONG_2ADDR = 194; // 0xc2
}

