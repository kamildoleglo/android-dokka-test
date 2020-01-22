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

import android.os.SystemClock;

/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Interpolator {

/** @apiSince 1 */

public Interpolator(int valueCount) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public Interpolator(int valueCount, int frameCount) { throw new RuntimeException("Stub!"); }

/**
 * Reset the Interpolator to have the specified number of values and an
 * implicit keyFrame count of 2 (just a start and end). After this call the
 * values for each keyFrame must be assigned using setKeyFrame().
 * @apiSince 1
 */

public void reset(int valueCount) { throw new RuntimeException("Stub!"); }

/**
 * Reset the Interpolator to have the specified number of values and
 * keyFrames. After this call the values for each keyFrame must be assigned
 * using setKeyFrame().
 * @apiSince 1
 */

public void reset(int valueCount, int frameCount) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final int getKeyFrameCount() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final int getValueCount() { throw new RuntimeException("Stub!"); }

/**
 * Assign the keyFrame (specified by index) a time value and an array of key
 * values (with an implicity blend array of [0, 0, 1, 1] giving linear
 * transition to the next set of key values).
 *
 * @param index The index of the key frame to assign
 * @param msec The time (in mililiseconds) for this key frame. Based on the
 *        SystemClock.uptimeMillis() clock
 * @param values Array of values associated with theis key frame
 * @apiSince 1
 */

public void setKeyFrame(int index, int msec, float[] values) { throw new RuntimeException("Stub!"); }

/**
 * Assign the keyFrame (specified by index) a time value and an array of key
 * values and blend array.
 *
 * @param index The index of the key frame to assign
 * @param msec The time (in mililiseconds) for this key frame. Based on the
 *        SystemClock.uptimeMillis() clock
 * @param values Array of values associated with theis key frame
 * @param blend (may be null) Optional array of 4 blend values
 * @apiSince 1
 */

public void setKeyFrame(int index, int msec, float[] values, float[] blend) { throw new RuntimeException("Stub!"); }

/**
 * Set a repeat count (which may be fractional) for the interpolator, and
 * whether the interpolator should mirror its repeats. The default settings
 * are repeatCount = 1, and mirror = false.
 * @apiSince 1
 */

public void setRepeatMirror(float repeatCount, boolean mirror) { throw new RuntimeException("Stub!"); }

/**
 * Calls timeToValues(msec, values) with the msec set to now (by calling
 * (int)SystemClock.uptimeMillis().)
 * @apiSince 1
 */

public android.graphics.Interpolator.Result timeToValues(float[] values) { throw new RuntimeException("Stub!"); }

/**
 * Given a millisecond time value (msec), return the interpolated values and
 * return whether the specified time was within the range of key times
 * (NORMAL), was before the first key time (FREEZE_START) or after the last
 * key time (FREEZE_END). In any event, computed values are always returned.
 *
 * @param msec The time (in milliseconds) used to sample into the
 *        Interpolator. Based on the SystemClock.uptimeMillis() clock
 * @param values Where to write the computed values (may be NULL).
 * @return how the values were computed (even if values == null)
 * @apiSince 1
 */

public android.graphics.Interpolator.Result timeToValues(int msec, float[] values) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum Result {
/** @apiSince 1 */

NORMAL,
/** @apiSince 1 */

FREEZE_START,
/** @apiSince 1 */

FREEZE_END;
}

}

