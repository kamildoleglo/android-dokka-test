/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.app.slice;


/**
 * Metrics interface for slices.
 *
 * This is called by SliceView, so Slice developers should
 * not need to reference this class.
 *
 * @see androidx.slice.widget.SliceView
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SliceMetrics {

/**
 * An object to be used throughout the life of a slice to register events.
 
 * @param context This value must never be {@code null}.
 
 * @param uri This value must never be {@code null}.
 * @apiSince 28
 */

public SliceMetrics(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * To be called whenever the slice becomes visible to the user.
 * @apiSince 28
 */

public void logVisible() { throw new RuntimeException("Stub!"); }

/**
 * To be called whenever the slice becomes invisible to the user.
 * @apiSince 28
 */

public void logHidden() { throw new RuntimeException("Stub!"); }

/**
 * To be called whenever the user invokes a discrete action via a slice.
 *
 * <P>
 *     Use this for discrete events like a tap or the end of a drag,
 *     not for a continuous streams of events, such as the motion during a gesture.
 * </P>
 *
 * @see androidx.slice.widget.EventInfo#actionType
 *
 * @param actionType The type of the event.
 * @param subSlice The URI of the sub-slice that is the subject of the interaction.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void logTouch(int actionType, @androidx.annotation.NonNull android.net.Uri subSlice) { throw new RuntimeException("Stub!"); }
}

