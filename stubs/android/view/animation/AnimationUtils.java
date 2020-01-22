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


package android.view.animation;

import android.os.SystemClock;
import android.content.res.Resources.NotFoundException;
import android.content.Context;

/**
 * Defines common utilities for working with animations.
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AnimationUtils {

public AnimationUtils() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current animation time in milliseconds. This time should be used when invoking
 * {@link android.view.animation.Animation#setStartTime(long) Animation#setStartTime(long)}. Refer to {@link android.os.SystemClock} for more
 * information about the different available clocks. The clock used by this method is
 * <em>not</em> the "wall" clock (it is not {@link java.lang.System#currentTimeMillis System#currentTimeMillis}).
 *
 * @return the current animation time in milliseconds
 *
 * @see android.os.SystemClock
 * @apiSince 1
 */

public static long currentAnimationTimeMillis() { throw new RuntimeException("Stub!"); }

/**
 * Loads an {@link android.view.animation.Animation Animation} object from a resource
 *
 * @param context Application context used to access resources
 * @param id The resource id of the animation to load
 * @return The animation object reference by the specified id
 * @throws android.content.res.Resources.NotFoundException when the animation cannot be loaded
 * @apiSince 1
 */

public static android.view.animation.Animation loadAnimation(android.content.Context context, int id) throws android.content.res.Resources.NotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Loads a {@link android.view.animation.LayoutAnimationController LayoutAnimationController} object from a resource
 *
 * @param context Application context used to access resources
 * @param id The resource id of the animation to load
 * @return The animation object reference by the specified id
 * @throws android.content.res.Resources.NotFoundException when the layout animation controller cannot be loaded
 * @apiSince 1
 */

public static android.view.animation.LayoutAnimationController loadLayoutAnimation(android.content.Context context, int id) throws android.content.res.Resources.NotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Make an animation for objects becoming visible. Uses a slide and fade
 * effect.
 *
 * @param c Context for loading resources
 * @param fromLeft is the object to be animated coming from the left
 * @return The new animation
 * @apiSince 1
 */

public static android.view.animation.Animation makeInAnimation(android.content.Context c, boolean fromLeft) { throw new RuntimeException("Stub!"); }

/**
 * Make an animation for objects becoming invisible. Uses a slide and fade
 * effect.
 *
 * @param c Context for loading resources
 * @param toRight is the object to be animated exiting to the right
 * @return The new animation
 * @apiSince 1
 */

public static android.view.animation.Animation makeOutAnimation(android.content.Context c, boolean toRight) { throw new RuntimeException("Stub!"); }

/**
 * Make an animation for objects becoming visible. Uses a slide up and fade
 * effect.
 *
 * @param c Context for loading resources
 * @return The new animation
 * @apiSince 1
 */

public static android.view.animation.Animation makeInChildBottomAnimation(android.content.Context c) { throw new RuntimeException("Stub!"); }

/**
 * Loads an {@link android.view.animation.Interpolator Interpolator} object from a resource
 *
 * @param context Application context used to access resources
 * @param id The resource id of the animation to load
 * @return The animation object reference by the specified id
 * @throws android.content.res.Resources.NotFoundException
 * @apiSince 1
 */

public static android.view.animation.Interpolator loadInterpolator(android.content.Context context, int id) throws android.content.res.Resources.NotFoundException { throw new RuntimeException("Stub!"); }
}

