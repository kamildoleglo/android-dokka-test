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
 * This adapter class provides empty implementations of the methods from {@link android.animation.Animator.AnimatorListener}.
 * Any custom listener that cares only about a subset of the methods of this listener can
 * simply subclass this adapter class instead of implementing the interface directly.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AnimatorListenerAdapter implements android.animation.Animator.AnimatorListener, android.animation.Animator.AnimatorPauseListener {

public AnimatorListenerAdapter() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 11
 */

public void onAnimationCancel(android.animation.Animator animation) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 11
 */

public void onAnimationEnd(android.animation.Animator animation) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 11
 */

public void onAnimationRepeat(android.animation.Animator animation) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 11
 */

public void onAnimationStart(android.animation.Animator animation) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 19
 */

public void onAnimationPause(android.animation.Animator animation) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 19
 */

public void onAnimationResume(android.animation.Animator animation) { throw new RuntimeException("Stub!"); }
}

