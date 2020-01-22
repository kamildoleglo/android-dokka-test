/*
 * Copyright (C) 2015 The Android Open Source Project
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


package android.graphics.drawable;


/**
 * Abstract class that drawables supporting animations and callbacks should extend.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface Animatable2 extends android.graphics.drawable.Animatable {

/**
 * Adds a callback to listen to the animation events.
 *
 * @param callback Callback to add.
 
 * This value must never be {@code null}.
 * @apiSince 23
 */

public void registerAnimationCallback(@androidx.annotation.NonNull android.graphics.drawable.Animatable2.AnimationCallback callback);

/**
 * Removes the specified animation callback.
 *
 * @param callback Callback to remove.
 * This value must never be {@code null}.
 * @return {@code false} if callback didn't exist in the call back list, or {@code true} if
 *         callback has been removed successfully.
 * @apiSince 23
 */

public boolean unregisterAnimationCallback(@androidx.annotation.NonNull android.graphics.drawable.Animatable2.AnimationCallback callback);

/**
 * Removes all existing animation callbacks.
 * @apiSince 23
 */

public void clearAnimationCallbacks();
/** @apiSince 23 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class AnimationCallback {

public AnimationCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when the animation starts.
 *
 * @param drawable The drawable started the animation.
 * @apiSince 23
 */

public void onAnimationStart(android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Called when the animation ends.
 *
 * @param drawable The drawable finished the animation.
 * @apiSince 23
 */

public void onAnimationEnd(android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }
}

}

