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


package android.animation;


/**
 * This evaluator can be used to perform type interpolation between integer
 * values that represent ARGB colors.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ArgbEvaluator implements android.animation.TypeEvaluator {

public ArgbEvaluator() { throw new RuntimeException("Stub!"); }

/**
 * This function returns the calculated in-between value for a color
 * given integers that represent the start and end values in the four
 * bytes of the 32-bit int. Each channel is separately linearly interpolated
 * and the resulting calculated values are recombined into the return value.
 *
 * @param fraction The fraction from the starting to the ending values
 * @param startValue A 32-bit int value representing colors in the
 * separate bytes of the parameter
 * @param endValue A 32-bit int value representing colors in the
 * separate bytes of the parameter
 * @return A value that is calculated to be the linearly interpolated
 * result, derived by separating the start and end values into separate
 * color channels and interpolating each one separately, recombining the
 * resulting values in the same way.
 * @apiSince 11
 */

public java.lang.Object evaluate(float fraction, java.lang.Object startValue, java.lang.Object endValue) { throw new RuntimeException("Stub!"); }
}

