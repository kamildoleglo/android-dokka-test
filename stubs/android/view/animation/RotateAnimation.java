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
 * An animation that controls the rotation of an object. This rotation takes
 * place in the X-Y plane. You can specify the point to use for the center of
 * the rotation, where (0,0) is the top left point. If not specified, (0,0) is
 * the default rotation point.
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RotateAnimation extends android.view.animation.Animation {

/**
 * Constructor used when a RotateAnimation is loaded from a resource.
 *
 * @param context Application context to use
 * @param attrs Attribute set from which to read values
 * @apiSince 1
 */

public RotateAnimation(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Constructor to use when building a RotateAnimation from code.
 * Default pivotX/pivotY point is (0,0).
 *
 * @param fromDegrees Rotation offset to apply at the start of the
 *        animation.
 *
 * @param toDegrees Rotation offset to apply at the end of the animation.
 * @apiSince 1
 */

public RotateAnimation(float fromDegrees, float toDegrees) { throw new RuntimeException("Stub!"); }

/**
 * Constructor to use when building a RotateAnimation from code
 *
 * @param fromDegrees Rotation offset to apply at the start of the
 *        animation.
 *
 * @param toDegrees Rotation offset to apply at the end of the animation.
 *
 * @param pivotX The X coordinate of the point about which the object is
 *        being rotated, specified as an absolute number where 0 is the left
 *        edge.
 * @param pivotY The Y coordinate of the point about which the object is
 *        being rotated, specified as an absolute number where 0 is the top
 *        edge.
 * @apiSince 1
 */

public RotateAnimation(float fromDegrees, float toDegrees, float pivotX, float pivotY) { throw new RuntimeException("Stub!"); }

/**
 * Constructor to use when building a RotateAnimation from code
 *
 * @param fromDegrees Rotation offset to apply at the start of the
 *        animation.
 *
 * @param toDegrees Rotation offset to apply at the end of the animation.
 *
 * @param pivotXType Specifies how pivotXValue should be interpreted. One of
 *        Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
 *        Animation.RELATIVE_TO_PARENT.
 * @param pivotXValue The X coordinate of the point about which the object
 *        is being rotated, specified as an absolute number where 0 is the
 *        left edge. This value can either be an absolute number if
 *        pivotXType is ABSOLUTE, or a percentage (where 1.0 is 100%)
 *        otherwise.
 * @param pivotYType Specifies how pivotYValue should be interpreted. One of
 *        Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
 *        Animation.RELATIVE_TO_PARENT.
 * @param pivotYValue The Y coordinate of the point about which the object
 *        is being rotated, specified as an absolute number where 0 is the
 *        top edge. This value can either be an absolute number if
 *        pivotYType is ABSOLUTE, or a percentage (where 1.0 is 100%)
 *        otherwise.
 * @apiSince 1
 */

public RotateAnimation(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void applyTransformation(float interpolatedTime, android.view.animation.Transformation t) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void initialize(int width, int height, int parentWidth, int parentHeight) { throw new RuntimeException("Stub!"); }
}

