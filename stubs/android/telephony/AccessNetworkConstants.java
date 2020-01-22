/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.telephony;


/**
 * Contains access network related constants.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AccessNetworkConstants {

private AccessNetworkConstants() { throw new RuntimeException("Stub!"); }
/** @apiSince 28 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class AccessNetworkType {

private AccessNetworkType() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public static final int CDMA2000 = 4; // 0x4

/** @apiSince 28 */

public static final int EUTRAN = 3; // 0x3

/** @apiSince 28 */

public static final int GERAN = 1; // 0x1

/** @apiSince 28 */

public static final int IWLAN = 5; // 0x5

/** @apiSince R */

public static final int NGRAN = 6; // 0x6

/** @apiSince 28 */

public static final int UNKNOWN = 0; // 0x0

/** @apiSince 28 */

public static final int UTRAN = 2; // 0x2
}

/**
 * Frenquency bands for EUTRAN.
 * http://www.etsi.org/deliver/etsi_ts/136100_136199/136101/14.03.00_60/ts_136101v140p.pdf
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class EutranBand {

private EutranBand() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public static final int BAND_1 = 1; // 0x1

/** @apiSince 28 */

public static final int BAND_10 = 10; // 0xa

/** @apiSince 28 */

public static final int BAND_11 = 11; // 0xb

/** @apiSince 28 */

public static final int BAND_12 = 12; // 0xc

/** @apiSince 28 */

public static final int BAND_13 = 13; // 0xd

/** @apiSince 28 */

public static final int BAND_14 = 14; // 0xe

/** @apiSince 28 */

public static final int BAND_17 = 17; // 0x11

/** @apiSince 28 */

public static final int BAND_18 = 18; // 0x12

/** @apiSince 28 */

public static final int BAND_19 = 19; // 0x13

/** @apiSince 28 */

public static final int BAND_2 = 2; // 0x2

/** @apiSince 28 */

public static final int BAND_20 = 20; // 0x14

/** @apiSince 28 */

public static final int BAND_21 = 21; // 0x15

/** @apiSince 28 */

public static final int BAND_22 = 22; // 0x16

/** @apiSince 28 */

public static final int BAND_23 = 23; // 0x17

/** @apiSince 28 */

public static final int BAND_24 = 24; // 0x18

/** @apiSince 28 */

public static final int BAND_25 = 25; // 0x19

/** @apiSince 28 */

public static final int BAND_26 = 26; // 0x1a

/** @apiSince 28 */

public static final int BAND_27 = 27; // 0x1b

/** @apiSince 28 */

public static final int BAND_28 = 28; // 0x1c

/** @apiSince 28 */

public static final int BAND_3 = 3; // 0x3

/** @apiSince 28 */

public static final int BAND_30 = 30; // 0x1e

/** @apiSince 28 */

public static final int BAND_31 = 31; // 0x1f

/** @apiSince 28 */

public static final int BAND_33 = 33; // 0x21

/** @apiSince 28 */

public static final int BAND_34 = 34; // 0x22

/** @apiSince 28 */

public static final int BAND_35 = 35; // 0x23

/** @apiSince 28 */

public static final int BAND_36 = 36; // 0x24

/** @apiSince 28 */

public static final int BAND_37 = 37; // 0x25

/** @apiSince 28 */

public static final int BAND_38 = 38; // 0x26

/** @apiSince 28 */

public static final int BAND_39 = 39; // 0x27

/** @apiSince 28 */

public static final int BAND_4 = 4; // 0x4

/** @apiSince 28 */

public static final int BAND_40 = 40; // 0x28

/** @apiSince 28 */

public static final int BAND_41 = 41; // 0x29

/** @apiSince 28 */

public static final int BAND_42 = 42; // 0x2a

/** @apiSince 28 */

public static final int BAND_43 = 43; // 0x2b

/** @apiSince 28 */

public static final int BAND_44 = 44; // 0x2c

/** @apiSince 28 */

public static final int BAND_45 = 45; // 0x2d

/** @apiSince 28 */

public static final int BAND_46 = 46; // 0x2e

/** @apiSince 28 */

public static final int BAND_47 = 47; // 0x2f

/** @apiSince 28 */

public static final int BAND_48 = 48; // 0x30

/** @apiSince 28 */

public static final int BAND_5 = 5; // 0x5

/** @apiSince 28 */

public static final int BAND_6 = 6; // 0x6

/** @apiSince 28 */

public static final int BAND_65 = 65; // 0x41

/** @apiSince 28 */

public static final int BAND_66 = 66; // 0x42

/** @apiSince 28 */

public static final int BAND_68 = 68; // 0x44

/** @apiSince 28 */

public static final int BAND_7 = 7; // 0x7

/** @apiSince 28 */

public static final int BAND_70 = 70; // 0x46

/** @apiSince 28 */

public static final int BAND_8 = 8; // 0x8

/** @apiSince 28 */

public static final int BAND_9 = 9; // 0x9
}

/**
 * Frequency bands for GERAN.
 * http://www.etsi.org/deliver/etsi_ts/145000_145099/145005/14.00.00_60/ts_145005v140000p.pdf
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class GeranBand {

private GeranBand() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public static final int BAND_450 = 3; // 0x3

/** @apiSince 28 */

public static final int BAND_480 = 4; // 0x4

/** @apiSince 28 */

public static final int BAND_710 = 5; // 0x5

/** @apiSince 28 */

public static final int BAND_750 = 6; // 0x6

/** @apiSince 28 */

public static final int BAND_850 = 8; // 0x8

/** @apiSince 28 */

public static final int BAND_DCS1800 = 12; // 0xc

/** @apiSince 28 */

public static final int BAND_E900 = 10; // 0xa

/** @apiSince 28 */

public static final int BAND_ER900 = 14; // 0xe

/** @apiSince 28 */

public static final int BAND_P900 = 9; // 0x9

/** @apiSince 28 */

public static final int BAND_PCS1900 = 13; // 0xd

/** @apiSince 28 */

public static final int BAND_R900 = 11; // 0xb

/** @apiSince 28 */

public static final int BAND_T380 = 1; // 0x1

/** @apiSince 28 */

public static final int BAND_T410 = 2; // 0x2

/** @apiSince 28 */

public static final int BAND_T810 = 7; // 0x7
}

/**
 * Frequency bands for NGRAN
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class NgranBands {

private NgranBands() { throw new RuntimeException("Stub!"); }

/**
 * FR1 bands
 * @apiSince R
 */

public static final int BAND_1 = 1; // 0x1

/** @apiSince R */

public static final int BAND_12 = 12; // 0xc

/** @apiSince R */

public static final int BAND_14 = 14; // 0xe

/** @apiSince R */

public static final int BAND_18 = 18; // 0x12

/** @apiSince R */

public static final int BAND_2 = 2; // 0x2

/** @apiSince R */

public static final int BAND_20 = 20; // 0x14

/** @apiSince R */

public static final int BAND_25 = 25; // 0x19

/**
 * FR2 bands
 * @apiSince R
 */

public static final int BAND_257 = 257; // 0x101

/** @apiSince R */

public static final int BAND_258 = 258; // 0x102

/** @apiSince R */

public static final int BAND_260 = 260; // 0x104

/** @apiSince R */

public static final int BAND_261 = 261; // 0x105

/** @apiSince R */

public static final int BAND_28 = 28; // 0x1c

/** @apiSince R */

public static final int BAND_29 = 29; // 0x1d

/** @apiSince R */

public static final int BAND_3 = 3; // 0x3

/** @apiSince R */

public static final int BAND_30 = 30; // 0x1e

/** @apiSince R */

public static final int BAND_34 = 34; // 0x22

/** @apiSince R */

public static final int BAND_38 = 38; // 0x26

/** @apiSince R */

public static final int BAND_39 = 39; // 0x27

/** @apiSince R */

public static final int BAND_40 = 40; // 0x28

/** @apiSince R */

public static final int BAND_41 = 41; // 0x29

/** @apiSince R */

public static final int BAND_48 = 48; // 0x30

/** @apiSince R */

public static final int BAND_5 = 5; // 0x5

/** @apiSince R */

public static final int BAND_50 = 50; // 0x32

/** @apiSince R */

public static final int BAND_51 = 51; // 0x33

/** @apiSince R */

public static final int BAND_65 = 65; // 0x41

/** @apiSince R */

public static final int BAND_66 = 66; // 0x42

/** @apiSince R */

public static final int BAND_7 = 7; // 0x7

/** @apiSince R */

public static final int BAND_70 = 70; // 0x46

/** @apiSince R */

public static final int BAND_71 = 71; // 0x47

/** @apiSince R */

public static final int BAND_74 = 74; // 0x4a

/** @apiSince R */

public static final int BAND_75 = 75; // 0x4b

/** @apiSince R */

public static final int BAND_76 = 76; // 0x4c

/** @apiSince R */

public static final int BAND_77 = 77; // 0x4d

/** @apiSince R */

public static final int BAND_78 = 78; // 0x4e

/** @apiSince R */

public static final int BAND_79 = 79; // 0x4f

/** @apiSince R */

public static final int BAND_8 = 8; // 0x8

/** @apiSince R */

public static final int BAND_80 = 80; // 0x50

/** @apiSince R */

public static final int BAND_81 = 81; // 0x51

/** @apiSince R */

public static final int BAND_82 = 82; // 0x52

/** @apiSince R */

public static final int BAND_83 = 83; // 0x53

/** @apiSince R */

public static final int BAND_84 = 84; // 0x54

/** @apiSince R */

public static final int BAND_86 = 86; // 0x56

/** @apiSince R */

public static final int BAND_90 = 90; // 0x5a
}

/**
 * Frenquency bands for UTRAN.
 * http://www.etsi.org/deliver/etsi_ts/125100_125199/125104/13.03.00_60/ts_125104v130p.pdf
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class UtranBand {

private UtranBand() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public static final int BAND_1 = 1; // 0x1

/** @apiSince 28 */

public static final int BAND_10 = 10; // 0xa

/** @apiSince 28 */

public static final int BAND_11 = 11; // 0xb

/** @apiSince 28 */

public static final int BAND_12 = 12; // 0xc

/** @apiSince 28 */

public static final int BAND_13 = 13; // 0xd

/** @apiSince 28 */

public static final int BAND_14 = 14; // 0xe

/**
 * band 15, 16, 17, 18 are reserved
 * @apiSince 28
 */

public static final int BAND_19 = 19; // 0x13

/** @apiSince 28 */

public static final int BAND_2 = 2; // 0x2

/** @apiSince 28 */

public static final int BAND_20 = 20; // 0x14

/** @apiSince 28 */

public static final int BAND_21 = 21; // 0x15

/** @apiSince 28 */

public static final int BAND_22 = 22; // 0x16

/**
 * band 23, 24 are reserved
 * @apiSince 28
 */

public static final int BAND_25 = 25; // 0x19

/** @apiSince 28 */

public static final int BAND_26 = 26; // 0x1a

/** @apiSince 28 */

public static final int BAND_3 = 3; // 0x3

/** @apiSince 28 */

public static final int BAND_4 = 4; // 0x4

/** @apiSince 28 */

public static final int BAND_5 = 5; // 0x5

/** @apiSince 28 */

public static final int BAND_6 = 6; // 0x6

/** @apiSince 28 */

public static final int BAND_7 = 7; // 0x7

/** @apiSince 28 */

public static final int BAND_8 = 8; // 0x8

/** @apiSince 28 */

public static final int BAND_9 = 9; // 0x9
}

}

