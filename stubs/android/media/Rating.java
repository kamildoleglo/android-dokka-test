/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.media;


/**
 * A class to encapsulate rating information used as content metadata.
 * A rating is defined by its rating style (see {@link #RATING_HEART},
 * {@link #RATING_THUMB_UP_DOWN}, {@link #RATING_3_STARS}, {@link #RATING_4_STARS},
 * {@link #RATING_5_STARS} or {@link #RATING_PERCENTAGE}) and the actual rating value (which may
 * be defined as "unrated"), both of which are defined when the rating instance is constructed
 * through one of the factory methods.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Rating implements android.os.Parcelable {

private Rating() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Return a Rating instance with no rating.
 * Create and return a new Rating instance with no rating known for the given
 * rating style.
 * @param ratingStyle one of {@link #RATING_HEART}, {@link #RATING_THUMB_UP_DOWN},
 *    {@link #RATING_3_STARS}, {@link #RATING_4_STARS}, {@link #RATING_5_STARS},
 *    or {@link #RATING_PERCENTAGE}.
 * Value is {@link android.media.Rating#RATING_NONE}, {@link android.media.Rating#RATING_HEART}, {@link android.media.Rating#RATING_THUMB_UP_DOWN}, {@link android.media.Rating#RATING_3_STARS}, {@link android.media.Rating#RATING_4_STARS}, {@link android.media.Rating#RATING_5_STARS}, or {@link android.media.Rating#RATING_PERCENTAGE}
 * @return null if an invalid rating style is passed, a new Rating instance otherwise.
 * @apiSince 19
 */

public static android.media.Rating newUnratedRating(int ratingStyle) { throw new RuntimeException("Stub!"); }

/**
 * Return a Rating instance with a heart-based rating.
 * Create and return a new Rating instance with a rating style of {@link #RATING_HEART},
 * and a heart-based rating.
 * @param hasHeart true for a "heart selected" rating, false for "heart unselected".
 * @return a new Rating instance.
 * @apiSince 19
 */

public static android.media.Rating newHeartRating(boolean hasHeart) { throw new RuntimeException("Stub!"); }

/**
 * Return a Rating instance with a thumb-based rating.
 * Create and return a new Rating instance with a {@link #RATING_THUMB_UP_DOWN}
 * rating style, and a "thumb up" or "thumb down" rating.
 * @param thumbIsUp true for a "thumb up" rating, false for "thumb down".
 * @return a new Rating instance.
 * @apiSince 19
 */

public static android.media.Rating newThumbRating(boolean thumbIsUp) { throw new RuntimeException("Stub!"); }

/**
 * Return a Rating instance with a star-based rating.
 * Create and return a new Rating instance with one of the star-base rating styles
 * and the given integer or fractional number of stars. Non integer values can for instance
 * be used to represent an average rating value, which might not be an integer number of stars.
 * @param starRatingStyle one of {@link #RATING_3_STARS}, {@link #RATING_4_STARS},
 *     {@link #RATING_5_STARS}.
 * Value is {@link android.media.Rating#RATING_3_STARS}, {@link android.media.Rating#RATING_4_STARS}, or {@link android.media.Rating#RATING_5_STARS}
 * @param starRating a number ranging from 0.0f to 3.0f, 4.0f or 5.0f according to
 *     the rating style.
 * @return null if the rating style is invalid, or the rating is out of range,
 *     a new Rating instance otherwise.
 * @apiSince 19
 */

public static android.media.Rating newStarRating(int starRatingStyle, float starRating) { throw new RuntimeException("Stub!"); }

/**
 * Return a Rating instance with a percentage-based rating.
 * Create and return a new Rating instance with a {@link #RATING_PERCENTAGE}
 * rating style, and a rating of the given percentage.
 * @param percent the value of the rating
 * @return null if the rating is out of range, a new Rating instance otherwise.
 * @apiSince 19
 */

public static android.media.Rating newPercentageRating(float percent) { throw new RuntimeException("Stub!"); }

/**
 * Return whether there is a rating value available.
 * @return true if the instance was not created with {@link #newUnratedRating(int)}.
 * @apiSince 19
 */

public boolean isRated() { throw new RuntimeException("Stub!"); }

/**
 * Return the rating style.
 * @return one of {@link #RATING_HEART}, {@link #RATING_THUMB_UP_DOWN},
 *    {@link #RATING_3_STARS}, {@link #RATING_4_STARS}, {@link #RATING_5_STARS},
 *    or {@link #RATING_PERCENTAGE}.
 
 * Value is {@link android.media.Rating#RATING_NONE}, {@link android.media.Rating#RATING_HEART}, {@link android.media.Rating#RATING_THUMB_UP_DOWN}, {@link android.media.Rating#RATING_3_STARS}, {@link android.media.Rating#RATING_4_STARS}, {@link android.media.Rating#RATING_5_STARS}, or {@link android.media.Rating#RATING_PERCENTAGE}
 * @apiSince 19
 */

public int getRatingStyle() { throw new RuntimeException("Stub!"); }

/**
 * Return whether the rating is "heart selected".
 * @return true if the rating is "heart selected", false if the rating is "heart unselected",
 *    if the rating style is not {@link #RATING_HEART} or if it is unrated.
 * @apiSince 19
 */

public boolean hasHeart() { throw new RuntimeException("Stub!"); }

/**
 * Return whether the rating is "thumb up".
 * @return true if the rating is "thumb up", false if the rating is "thumb down",
 *    if the rating style is not {@link #RATING_THUMB_UP_DOWN} or if it is unrated.
 * @apiSince 19
 */

public boolean isThumbUp() { throw new RuntimeException("Stub!"); }

/**
 * Return the star-based rating value.
 * @return a rating value greater or equal to 0.0f, or a negative value if the rating style is
 *    not star-based, or if it is unrated.
 * @apiSince 19
 */

public float getStarRating() { throw new RuntimeException("Stub!"); }

/**
 * Return the percentage-based rating value.
 * @return a rating value greater or equal to 0.0f, or a negative value if the rating style is
 *    not percentage-based, or if it is unrated.
 * @apiSince 19
 */

public float getPercentRating() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.Rating> CREATOR;
static { CREATOR = null; }

/**
 * A rating style with 0 to 3 stars.
 * @apiSince 19
 */

public static final int RATING_3_STARS = 3; // 0x3

/**
 * A rating style with 0 to 4 stars.
 * @apiSince 19
 */

public static final int RATING_4_STARS = 4; // 0x4

/**
 * A rating style with 0 to 5 stars.
 * @apiSince 19
 */

public static final int RATING_5_STARS = 5; // 0x5

/**
 * A rating style with a single degree of rating, "heart" vs "no heart". Can be used to
 * indicate the content referred to is a favorite (or not).
 * @apiSince 19
 */

public static final int RATING_HEART = 1; // 0x1

/**
 * Indicates a rating style is not supported. A Rating will never have this
 * type, but can be used by other classes to indicate they do not support
 * Rating.
 * @apiSince 21
 */

public static final int RATING_NONE = 0; // 0x0

/**
 * A rating style expressed as a percentage.
 * @apiSince 19
 */

public static final int RATING_PERCENTAGE = 6; // 0x6

/**
 * A rating style for "thumb up" vs "thumb down".
 * @apiSince 19
 */

public static final int RATING_THUMB_UP_DOWN = 2; // 0x2
}

