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
 * An animation that controls the alpha level of an object.
 * Useful for fading things in and out. This animation ends up
 * changing the alpha property of a {@link android.view.animation.Transformation Transformation}
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AlphaAnimation extends android.view.animation.Animation {

/**
 * Constructor used when an AlphaAnimation is loaded from a resource.
 *
 * @param context Application context to use
 * @param attrs Attribute set from which to read values
 * @apiSince 1
 */

public AlphaAnimation(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Constructor to use when building an AlphaAnimation from code
 *
 * @param fromAlpha Starting alpha value for the animation, where 1.0 means
 *        fully opaque and 0.0 means fully transparent.
 * @param toAlpha Ending alpha value for the animation.
 * @apiSince 1
 */

public AlphaAnimation(float fromAlpha, float toAlpha) { throw new RuntimeException("Stub!"); }

/**
 * Changes the alpha property of the supplied {@link android.view.animation.Transformation Transformation}
 * @apiSince 1
 */

protected void applyTransformation(float interpolatedTime, android.view.animation.Transformation t) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean willChangeTransformationMatrix() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean willChangeBounds() { throw new RuntimeException("Stub!"); }
}

