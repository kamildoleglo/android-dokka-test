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


/**
 * Shader used to draw a bitmap as a texture. The bitmap can be repeated or
 * mirrored by setting the tiling mode.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BitmapShader extends android.graphics.Shader {

/**
 * Call this to create a new shader that will draw with a bitmap.
 *
 * @param bitmap The bitmap to use inside the shader
 * This value must never be {@code null}.
 * @param tileX The tiling mode for x to draw the bitmap in.
 * This value must never be {@code null}.
 * @param tileY The tiling mode for y to draw the bitmap in.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public BitmapShader(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, @androidx.annotation.NonNull android.graphics.Shader.TileMode tileX, @androidx.annotation.NonNull android.graphics.Shader.TileMode tileY) { throw new RuntimeException("Stub!"); }
}

