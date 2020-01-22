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


package android.graphics;


/** A subclass of shader that returns the composition of two other shaders, combined by
 an {@link android.graphics.Xfermode} subclass.
 @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ComposeShader extends android.graphics.Shader {

/**
 * Create a new compose shader, given shaders A, B, and a combining mode.
 * When the mode is applied, it will be given the result from shader A as its
 * "dst", and the result from shader B as its "src".
 *
 * @param shaderA  The colors from this shader are seen as the "dst" by the mode
 * This value must never be {@code null}.
 * @param shaderB  The colors from this shader are seen as the "src" by the mode
 * This value must never be {@code null}.
 * @param mode     The mode that combines the colors from the two shaders. If mode
 *                 is null, then SRC_OVER is assumed.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

@Deprecated
public ComposeShader(@androidx.annotation.NonNull android.graphics.Shader shaderA, @androidx.annotation.NonNull android.graphics.Shader shaderB, @androidx.annotation.NonNull android.graphics.Xfermode mode) { throw new RuntimeException("Stub!"); }

/**
 * Create a new compose shader, given shaders A, B, and a combining PorterDuff mode.
 * When the mode is applied, it will be given the result from shader A as its
 * "dst", and the result from shader B as its "src".
 *
 * @param shaderA  The colors from this shader are seen as the "dst" by the mode
 * This value must never be {@code null}.
 * @param shaderB  The colors from this shader are seen as the "src" by the mode
 * This value must never be {@code null}.
 * @param mode     The PorterDuff mode that combines the colors from the two shaders.
 *
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public ComposeShader(@androidx.annotation.NonNull android.graphics.Shader shaderA, @androidx.annotation.NonNull android.graphics.Shader shaderB, @androidx.annotation.NonNull android.graphics.PorterDuff.Mode mode) { throw new RuntimeException("Stub!"); }

/**
 * Create a new compose shader, given shaders A, B, and a combining PorterDuff mode.
 * When the mode is applied, it will be given the result from shader A as its
 * "dst", and the result from shader B as its "src".
 *
 * @param shaderA  The colors from this shader are seen as the "dst" by the mode
 * This value must never be {@code null}.
 * @param shaderB  The colors from this shader are seen as the "src" by the mode
 * This value must never be {@code null}.
 * @param blendMode The blend mode that combines the colors from the two shaders.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public ComposeShader(@androidx.annotation.NonNull android.graphics.Shader shaderA, @androidx.annotation.NonNull android.graphics.Shader shaderB, @androidx.annotation.NonNull android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }
}

