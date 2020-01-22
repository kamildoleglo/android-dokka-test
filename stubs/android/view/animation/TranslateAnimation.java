/*
 * Copyright (C) 2006 The Android Open Source Project
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


package android.view.animation;


/**
 * An animation that controls the position of an object. See the
 * {@link android.view.animation full package} description for details and
 * sample code.
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TranslateAnimation extends android.view.animation.Animation {

/**
 * Constructor used when a TranslateAnimation is loaded from a resource.
 *
 * @param context Application context to use
 * @param attrs Attribute set from which to read values
 * @apiSince 1
 */

public TranslateAnimation(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Constructor to use when building a TranslateAnimation from code
 *
 * @param fromXDelta Change in X coordinate to apply at the start of the
 *        animation
 * @param toXDelta Change in X coordinate to apply at the end of the
 *        animation
 * @param fromYDelta Change in Y coordinate to apply at the start of the
 *        animation
 * @param toYDelta Change in Y coordinate to apply at the end of the
 *        animation
 * @apiSince 1
 */

public TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) { throw new RuntimeException("Stub!"); }

/**
 * Constructor to use when building a TranslateAnimation from code
 *
 * @param fromXType Specifies how fromXValue should be interpreted. One of
 *        Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
 *        Animation.RELATIVE_TO_PARENT.
 * @param fromXValue Change in X coordinate to apply at the start of the
 *        animation. This value can either be an absolute number if fromXType
 *        is ABSOLUTE, or a percentage (where 1.0 is 100%) otherwise.
 * @param toXType Specifies how toXValue should be interpreted. One of
 *        Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
 *        Animation.RELATIVE_TO_PARENT.
 * @param toXValue Change in X coordinate to apply at the end of the
 *        animation. This value can either be an absolute number if toXType
 *        is ABSOLUTE, or a percentage (where 1.0 is 100%) otherwise.
 * @param fromYType Specifies how fromYValue should be interpreted. One of
 *        Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
 *        Animation.RELATIVE_TO_PARENT.
 * @param fromYValue Change in Y coordinate to apply at the start of the
 *        animation. This value can either be an absolute number if fromYType
 *        is ABSOLUTE, or a percentage (where 1.0 is 100%) otherwise.
 * @param toYType Specifies how toYValue should be interpreted. One of
 *        Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
 *        Animation.RELATIVE_TO_PARENT.
 * @param toYValue Change in Y coordinate to apply at the end of the
 *        animation. This value can either be an absolute number if toYType
 *        is ABSOLUTE, or a percentage (where 1.0 is 100%) otherwise.
 * @apiSince 1
 */

public TranslateAnimation(int fromXType, float fromXValue, int toXType, float toXValue, int fromYType, float fromYValue, int toYType, float toYValue) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void applyTransformation(float interpolatedTime, android.view.animation.Transformation t) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void initialize(int width, int height, int parentWidth, int parentHeight) { throw new RuntimeException("Stub!"); }
}

