/*
 * Copyright (C) 2011 The Android Open Source Project
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



package android.media.effect;


/**
 * <p>An EffectContext keeps all necessary state information to run Effects within a Open GL ES 2.0
 * context.</p>
 *
 * <p>Every EffectContext is bound to one GL context. The application is responsible for creating
 * this EGL context, and making it current before applying any effect. If your EGL context is
 * destroyed, the EffectContext becomes invalid and any effects bound to this context can no longer
 * be used. If you switch to another EGL context, you must create a new EffectContext. Each Effect
 * is bound to a single EffectContext, and can only be executed in that context.</p>
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class EffectContext {

private EffectContext() { throw new RuntimeException("Stub!"); }

/**
 * Creates a context within the current GL context.
 *
 * <p>Binds the EffectContext to the current OpenGL context. All subsequent calls to the
 * EffectContext must be made in the GL context that was active during creation.
 * When you have finished using a context, you must call {@link #release()}. to dispose of all
 * resources associated with this context.</p>
 * @apiSince 14
 */

public static android.media.effect.EffectContext createWithCurrentGlContext() { throw new RuntimeException("Stub!"); }

/**
 * Returns the EffectFactory for this context.
 *
 * <p>The EffectFactory returned from this method allows instantiating new effects within this
 * context.</p>
 *
 * @return The EffectFactory instance for this context.
 * @apiSince 14
 */

public android.media.effect.EffectFactory getFactory() { throw new RuntimeException("Stub!"); }

/**
 * Releases the context.
 *
 * <p>Releases all the resources and effects associated with the EffectContext. This renders the
 * context and all the effects bound to this context invalid. You must no longer use the context
 * or any of its bound effects after calling release().</p>
 *
 * <p>Note that this method must be called with the proper EGL context made current, as the
 * EffectContext and its effects may release internal GL resources.</p>
 * @apiSince 14
 */

public void release() { throw new RuntimeException("Stub!"); }
}

