/* GENERATED SOURCE. DO NOT MODIFY. */
// © 2016 and later: Unicode, Inc. and others.
// License & terms of use: http://www.unicode.org/copyright.html#License
/**
 *******************************************************************************
 * Copyright (C) 2004-2016, International Business Machines Corporation and
 * others. All Rights Reserved.
 *******************************************************************************
 */


package android.icu.lang;


/**
 * A container for the different 'enumerated types' used by UCharacter.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UCharacterEnums {

private UCharacterEnums() { throw new RuntimeException("Stub!"); }
/**
 * 'Enum' for the CharacterCategory constants.  These constants are
 * compatible in name <b>but not in value</b> with those defined in
 * {@link java.lang.Character}.
 * @see android.icu.lang.UCharacterCategory
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ECharacterCategory {

/**
 * Character type Mc
 * @apiSince 24
 */

public static final byte COMBINING_SPACING_MARK = 8; // 0x8

/**
 * Character type Pc
 * @apiSince 24
 */

public static final byte CONNECTOR_PUNCTUATION = 22; // 0x16

/**
 * Character type Cc
 * @apiSince 24
 */

public static final byte CONTROL = 15; // 0xf

/**
 * Character type Sc
 * @apiSince 24
 */

public static final byte CURRENCY_SYMBOL = 25; // 0x19

/**
 * Character type Pd
 * @apiSince 24
 */

public static final byte DASH_PUNCTUATION = 19; // 0x13

/**
 * Character type Nd
 * @apiSince 24
 */

public static final byte DECIMAL_DIGIT_NUMBER = 9; // 0x9

/**
 * Character type Me
 * @apiSince 24
 */

public static final byte ENCLOSING_MARK = 7; // 0x7

/**
 * Character type Pe
 * @apiSince 24
 */

public static final byte END_PUNCTUATION = 21; // 0x15

/**
 * Character type Pf
 * @see #FINAL_QUOTE_PUNCTUATION
 * @apiSince 24
 */

public static final byte FINAL_PUNCTUATION = 29; // 0x1d

/**
 * Character type Pf
 * This name is compatible with java.lang.Character's name for this type.
 * @see #FINAL_PUNCTUATION
 * @apiSince 24
 */

public static final byte FINAL_QUOTE_PUNCTUATION = 29; // 0x1d

/**
 * Character type Cf
 * @apiSince 24
 */

public static final byte FORMAT = 16; // 0x10

/**
 * Character type Cn
 * Not Assigned (no characters in [UnicodeData.txt] have this property)
 * @apiSince 24
 */

public static final byte GENERAL_OTHER_TYPES = 0; // 0x0

/**
 * Character type Pi
 * @see #INITIAL_QUOTE_PUNCTUATION
 * @apiSince 24
 */

public static final byte INITIAL_PUNCTUATION = 28; // 0x1c

/**
 * Character type Pi
 * This name is compatible with java.lang.Character's name for this type.
 * @see #INITIAL_PUNCTUATION
 * @apiSince 24
 */

public static final byte INITIAL_QUOTE_PUNCTUATION = 28; // 0x1c

/**
 * Character type Nl
 * @apiSince 24
 */

public static final byte LETTER_NUMBER = 10; // 0xa

/**
 * Character type Zl
 * @apiSince 24
 */

public static final byte LINE_SEPARATOR = 13; // 0xd

/**
 * Character type Ll
 * @apiSince 24
 */

public static final byte LOWERCASE_LETTER = 2; // 0x2

/**
 * Character type Sm
 * @apiSince 24
 */

public static final byte MATH_SYMBOL = 24; // 0x18

/**
 * Character type Lm
 * @apiSince 24
 */

public static final byte MODIFIER_LETTER = 4; // 0x4

/**
 * Character type Sk
 * @apiSince 24
 */

public static final byte MODIFIER_SYMBOL = 26; // 0x1a

/**
 * Character type Mn
 * @apiSince 24
 */

public static final byte NON_SPACING_MARK = 6; // 0x6

/**
 * Character type Lo
 * @apiSince 24
 */

public static final byte OTHER_LETTER = 5; // 0x5

/**
 * Character type No
 * @apiSince 24
 */

public static final byte OTHER_NUMBER = 11; // 0xb

/**
 * Character type Po
 * @apiSince 24
 */

public static final byte OTHER_PUNCTUATION = 23; // 0x17

/**
 * Character type So
 * @apiSince 24
 */

public static final byte OTHER_SYMBOL = 27; // 0x1b

/**
 * Character type Zp
 * @apiSince 24
 */

public static final byte PARAGRAPH_SEPARATOR = 14; // 0xe

/**
 * Character type Co
 * @apiSince 24
 */

public static final byte PRIVATE_USE = 17; // 0x11

/**
 * Character type Zs
 * @apiSince 24
 */

public static final byte SPACE_SEPARATOR = 12; // 0xc

/**
 * Character type Ps
 * @apiSince 24
 */

public static final byte START_PUNCTUATION = 20; // 0x14

/**
 * Character type Cs
 * @apiSince 24
 */

public static final byte SURROGATE = 18; // 0x12

/**
 * Character type Lt
 * @apiSince 24
 */

public static final byte TITLECASE_LETTER = 3; // 0x3

/**
 * Unassigned character type
 * @apiSince 24
 */

public static final byte UNASSIGNED = 0; // 0x0

/**
 * Character type Lu
 * @apiSince 24
 */

public static final byte UPPERCASE_LETTER = 1; // 0x1
}

/**
 * 'Enum' for the CharacterDirection constants. Some constants are
 * compatible in name <b>but not in value</b> with those defined in
 * {@link java.lang.Character}.
 * @see android.icu.lang.UCharacterDirection
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ECharacterDirection {

/**
 * Directional type AN
 * @apiSince 24
 */

public static final int ARABIC_NUMBER = 5; // 0x5

/**
 * Directional type B
 * @apiSince 24
 */

public static final int BLOCK_SEPARATOR = 7; // 0x7

/**
 * Directional type BN
 * @apiSince 24
 */

public static final int BOUNDARY_NEUTRAL = 18; // 0x12

/**
 * Directional type CS
 * @apiSince 24
 */

public static final int COMMON_NUMBER_SEPARATOR = 6; // 0x6

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_ARABIC_NUMBER}.
 * Synonym of {@link #ARABIC_NUMBER}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_ARABIC_NUMBER = 5; // 0x5

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_BOUNDARY_NEUTRAL}.
 * Synonym of {@link #BOUNDARY_NEUTRAL}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_BOUNDARY_NEUTRAL = 18; // 0x12

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_COMMON_NUMBER_SEPARATOR}.
 * Synonym of {@link #COMMON_NUMBER_SEPARATOR}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_COMMON_NUMBER_SEPARATOR = 6; // 0x6

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_EUROPEAN_NUMBER}.
 * Synonym of {@link #EUROPEAN_NUMBER}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_EUROPEAN_NUMBER = 2; // 0x2

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR}.
 * Synonym of {@link #EUROPEAN_NUMBER_SEPARATOR}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR = 3; // 0x3

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR}.
 * Synonym of {@link #EUROPEAN_NUMBER_TERMINATOR}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR = 4; // 0x4

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_LEFT_TO_RIGHT}.
 * Synonym of {@link #LEFT_TO_RIGHT}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_LEFT_TO_RIGHT = 0; // 0x0

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING}.
 * Synonym of {@link #LEFT_TO_RIGHT_EMBEDDING}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING = 11; // 0xb

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE}.
 * Synonym of {@link #LEFT_TO_RIGHT_OVERRIDE}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE = 12; // 0xc

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_NONSPACING_MARK}.
 * Synonym of {@link #DIR_NON_SPACING_MARK}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_NONSPACING_MARK = 17; // 0x11

/**
 * Equivalent to {@link java.lang.Character#DIRECTIONALITY_OTHER_NEUTRALS}.
 * Synonym of {@link #OTHER_NEUTRAL}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_OTHER_NEUTRALS = 10; // 0xa

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_PARAGRAPH_SEPARATOR}.
 * Synonym of {@link #BLOCK_SEPARATOR}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_PARAGRAPH_SEPARATOR = 7; // 0x7

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_POP_DIRECTIONAL_FORMAT}.
 * Synonym of {@link #POP_DIRECTIONAL_FORMAT}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_POP_DIRECTIONAL_FORMAT = 16; // 0x10

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_RIGHT_TO_LEFT}.
 * Synonym of {@link #RIGHT_TO_LEFT}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_RIGHT_TO_LEFT = 1; // 0x1

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC}.
 * Synonym of {@link #RIGHT_TO_LEFT_ARABIC}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC = 13; // 0xd

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING}.
 * Synonym of {@link #RIGHT_TO_LEFT_EMBEDDING}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING = 14; // 0xe

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE}.
 * Synonym of {@link #RIGHT_TO_LEFT_OVERRIDE}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE = 15; // 0xf

/**
 * Equivalent to {@link
 * java.lang.Character#DIRECTIONALITY_SEGMENT_SEPARATOR}.
 * Synonym of {@link #SEGMENT_SEPARATOR}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_SEGMENT_SEPARATOR = 8; // 0x8

/**
 * Undefined bidirectional character type. Undefined <code>char</code>
 * values have undefined directionality in the Unicode specification.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_UNDEFINED = -1; // 0xffffffff

/**
 * Equivalent to {@link java.lang.Character#DIRECTIONALITY_WHITESPACE}.
 * Synonym of {@link #WHITE_SPACE_NEUTRAL}.
 * @apiSince 24
 */

public static final byte DIRECTIONALITY_WHITESPACE = 9; // 0x9

/**
 * Directional type NSM
 * @apiSince 24
 */

public static final int DIR_NON_SPACING_MARK = 17; // 0x11

/**
 * Directional type EN
 * @apiSince 24
 */

public static final int EUROPEAN_NUMBER = 2; // 0x2

/**
 * Directional type ES
 * @apiSince 24
 */

public static final int EUROPEAN_NUMBER_SEPARATOR = 3; // 0x3

/**
 * Directional type ET
 * @apiSince 24
 */

public static final int EUROPEAN_NUMBER_TERMINATOR = 4; // 0x4

/**
 * Directional type FSI
 * @apiSince 24
 */

public static final byte FIRST_STRONG_ISOLATE = 19; // 0x13

/**
 * Directional type L
 * @apiSince 24
 */

public static final int LEFT_TO_RIGHT = 0; // 0x0

/**
 * Directional type LRE
 * @apiSince 24
 */

public static final int LEFT_TO_RIGHT_EMBEDDING = 11; // 0xb

/**
 * Directional type LRI
 * @apiSince 24
 */

public static final byte LEFT_TO_RIGHT_ISOLATE = 20; // 0x14

/**
 * Directional type LRO
 * @apiSince 24
 */

public static final int LEFT_TO_RIGHT_OVERRIDE = 12; // 0xc

/**
 * Directional type ON
 * @apiSince 24
 */

public static final int OTHER_NEUTRAL = 10; // 0xa

/**
 * Directional type PDF
 * @apiSince 24
 */

public static final int POP_DIRECTIONAL_FORMAT = 16; // 0x10

/**
 * Directional type PDI
 * @apiSince 24
 */

public static final byte POP_DIRECTIONAL_ISOLATE = 22; // 0x16

/**
 * Directional type R
 * @apiSince 24
 */

public static final int RIGHT_TO_LEFT = 1; // 0x1

/**
 * Directional type AL
 * @apiSince 24
 */

public static final int RIGHT_TO_LEFT_ARABIC = 13; // 0xd

/**
 * Directional type RLE
 * @apiSince 24
 */

public static final int RIGHT_TO_LEFT_EMBEDDING = 14; // 0xe

/**
 * Directional type RLI
 * @apiSince 24
 */

public static final byte RIGHT_TO_LEFT_ISOLATE = 21; // 0x15

/**
 * Directional type RLO
 * @apiSince 24
 */

public static final int RIGHT_TO_LEFT_OVERRIDE = 15; // 0xf

/**
 * Directional type S
 * @apiSince 24
 */

public static final int SEGMENT_SEPARATOR = 8; // 0x8

/**
 * Directional type WS
 * @apiSince 24
 */

public static final int WHITE_SPACE_NEUTRAL = 9; // 0x9
}

}

