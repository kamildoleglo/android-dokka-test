/*
 * Copyright (C) 2014 The Android Open Source Project
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

package android.transition;

import android.graphics.Path;

/**
 * A PathMotion that takes a Path pattern and applies it to the separation between two points.
 * The starting point of the Path will be moved to the origin and the end point will be scaled
 * and rotated so that it matches with the target end point.
 * <p>This may be used in XML as an element inside a transition.</p>
 * <pre>{@code
 * <changeBounds>
 *     <patternPathMotion android:patternPathData="M0 0 L0 100 L100 100"/>
 * </changeBounds>}
 * </pre>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PatternPathMotion extends android.transition.PathMotion {

/**
 * Constructs a PatternPathMotion with a straight-line pattern.
 * @apiSince 21
 */

public PatternPathMotion() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public PatternPathMotion(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Creates a PatternPathMotion with the Path defining a pattern of motion between two
 * coordinates. The pattern will be translated, rotated, and scaled to fit between the start
 * and end points. The pattern must not be empty and must have the end point differ from the
 * start point.
 *
 * @param patternPath A Path to be used as a pattern for two-dimensional motion.
 * @apiSince 21
 */

public PatternPathMotion(android.graphics.Path patternPath) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Path defining a pattern of motion between two coordinates.
 * The pattern will be translated, rotated, and scaled to fit between the start and end points.
 * The pattern must not be empty and must have the end point differ from the start point.
 *
 * @return the Path defining a pattern of motion between two coordinates.
 * @attr ref android.R.styleable#PatternPathMotion_patternPathData
 * @apiSince 21
 */

public android.graphics.Path getPatternPath() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Path defining a pattern of motion between two coordinates.
 * The pattern will be translated, rotated, and scaled to fit between the start and end points.
 * The pattern must not be empty and must have the end point differ from the start point.
 *
 * @param patternPath A Path to be used as a pattern for two-dimensional motion.
 * @attr ref android.R.styleable#PatternPathMotion_patternPathData
 * @apiSince 21
 */

public void setPatternPath(android.graphics.Path patternPath) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.graphics.Path getPath(float startX, float startY, float endX, float endY) { throw new RuntimeException("Stub!"); }
}

