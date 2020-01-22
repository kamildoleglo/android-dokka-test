/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.net.wifi.rtt;


/**
 * Civic Address key types used to define address elements.
 *
 * <p>These keys can be used with {@code ResponderLocation.toCivicLocationSparseArray()}
 * to look-up the corresponding string values.</p>
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CivicLocationKeys {

private CivicLocationKeys() { throw new RuntimeException("Stub!"); }

/**
 * Additional Code key e.g.&nbsp;13203000003.
 * @apiSince 29
 */

public static final int ADDITIONAL_CODE = 32; // 0x20

/**
 * Apartment or suite key e.g.&nbsp;Apt 42.
 * @apiSince 29
 */

public static final int APT = 26; // 0x1a

/**
 * Category label A4 key e.g.&nbsp;Westminster.
 * @apiSince 29
 */

public static final int BOROUGH = 4; // 0x4

/**
 * Branch Rd Name key e.g.&nbsp;Lane 7.
 * @apiSince 29
 */

public static final int BRANCH_ROAD_NAME = 36; // 0x24

/**
 * Building key e.g.&nbsp;Lincoln Library.
 * @apiSince 29
 */

public static final int BUILDING = 25; // 0x19

/**
 * Category label A3 key e.g.&nbsp;San Francisco.
 * @apiSince 29
 */

public static final int CITY = 3; // 0x3

/**
 * Category label A2 key e.g.&nbsp;Marin.
 * @apiSince 29
 */

public static final int COUNTY = 2; // 0x2

/**
 * Seat, desk, pole, or cubical key e.g.&nbsp;WS 181.
 * @apiSince 29
 */

public static final int DESK = 33; // 0x21

/**
 * Floor key e.g.&nbsp;4.
 * @apiSince 29
 */

public static final int FLOOR = 27; // 0x1b

/**
 * Category label A6 key e.g.&nbsp;University District.
 * @apiSince 29
 */

public static final int GROUP_OF_STREETS = 6; // 0x6

/**
 * House Number key e.g.&nbsp;123.
 * @apiSince 29
 */

public static final int HNO = 19; // 0x13

/**
 * House number suffix key e.g.&nbsp;A, 1/2.
 * @apiSince 29
 */

public static final int HNS = 20; // 0x14

/**
 * Language key e.g.&nbsp;i-default.
 * @apiSince 29
 */

public static final int LANGUAGE = 0; // 0x0

/**
 * Landmark or vanity address key e.g.&nbsp;Golden Gate Bridge.
 * @apiSince 29
 */

public static final int LMK = 21; // 0x15

/**
 * Additional Location info key e.g.&nbsp;South Wing.
 * @apiSince 29
 */

public static final int LOC = 22; // 0x16

/**
 * Name of residence key e.g.&nbsp;Joe's Barbershop.
 * @apiSince 29
 */

public static final int NAM = 23; // 0x17

/**
 * Category label A5 key e.g.&nbsp;Pacific Heights.
 * @apiSince 29
 */

public static final int NEIGHBORHOOD = 5; // 0x5

/**
 * Postal community name key e.g.&nbsp;Leonia.
 * @apiSince 29
 */

public static final int PCN = 30; // 0x1e

/**
 * Trailing street suffix key e.g.&nbsp;SW.
 * @apiSince 29
 */

public static final int POD = 17; // 0x11

/**
 * Postal or ZIP code key e.g.&nbsp;10027-1234.
 * @apiSince 29
 */

public static final int POSTAL_CODE = 24; // 0x18

/**
 * Post Office Box key e.g.&nbsp;12345.
 * @apiSince 29
 */

public static final int PO_BOX = 31; // 0x1f

/**
 * Leading Street direction key e.g.&nbsp;N.
 * @apiSince 29
 */

public static final int PRD = 16; // 0x10

/**
 * Primary road name key e.g.&nbsp;Shoreline.
 * @apiSince 29
 */

public static final int PRIMARY_ROAD_NAME = 34; // 0x22

/**
 * Road Section key e.g.&nbsp;14.
 * @apiSince 29
 */

public static final int ROAD_SECTION = 35; // 0x23

/**
 * Room key e.g.&nbsp;450F.
 * @apiSince 29
 */

public static final int ROOM = 28; // 0x1c

/**
 * Script key e.g.&nbsp;Latn.
 * @apiSince 29
 */

public static final int SCRIPT = 128; // 0x80

/**
 * Category label A1 key e.g.&nbsp;California.
 * @apiSince 29
 */

public static final int STATE = 1; // 0x1

/**
 * Postmodifier key e.g.&nbsp;Service.
 * @apiSince 29
 */

public static final int STREET_NAME_POST_MODIFIER = 39; // 0x27

/**
 * Premodifier key e.g.&nbsp;Old.
 * @apiSince 29
 */

public static final int STREET_NAME_PRE_MODIFIER = 38; // 0x26

/**
 * Street suffix or Type key e.g Ave, Platz.
 * @apiSince 29
 */

public static final int STS = 18; // 0x12

/**
 * Subbranch Rd Name key e.g.&nbsp;Alley 8.
 * @apiSince 29
 */

public static final int SUBBRANCH_ROAD_NAME = 37; // 0x25

/**
 * Type of place key e.g.&nbsp;office.
 * @apiSince 29
 */

public static final int TYPE_OF_PLACE = 29; // 0x1d
}

