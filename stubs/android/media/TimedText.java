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


package android.media;

import android.graphics.Rect;

/**
 * Class to hold the timed text's metadata, including:
 * <ul>
 * <li> The characters for rendering</li>
 * <li> The rendering position for the timed text</li>
 * </ul>
 *
 * <p> To render the timed text, applications need to do the following:
 *
 * <ul>
 * <li> Implement the {@link android.media.MediaPlayer.OnTimedTextListener MediaPlayer.OnTimedTextListener} interface</li>
 * <li> Register the {@link android.media.MediaPlayer.OnTimedTextListener MediaPlayer.OnTimedTextListener} callback on a MediaPlayer object that is used for playback</li>
 * <li> When a onTimedText callback is received, do the following:
 * <ul>
 * <li> call {@link #getText} to get the characters for rendering</li>
 * <li> call {@link #getBounds} to get the text rendering area/region</li>
 * </ul>
 * </li>
 * </ul>
 *
 * @see android.media.MediaPlayer
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TimedText {

TimedText() { throw new RuntimeException("Stub!"); }

/**
 * Get the characters in the timed text.
 *
 * @return the characters as a String object in the TimedText. Applications
 * should stop rendering previous timed text at the current rendering region if
 * a null is returned, until the next non-null timed text is received.
 * @apiSince 16
 */

public java.lang.String getText() { throw new RuntimeException("Stub!"); }

/**
 * Get the rectangle area or region for rendering the timed text as specified
 * by a Rect object.
 *
 * @return the rectangle region to render the characters in the timed text.
 * If no bounds information is available (a null is returned), render the
 * timed text at the center bottom of the display.
 * @apiSince 16
 */

public android.graphics.Rect getBounds() { throw new RuntimeException("Stub!"); }
}

