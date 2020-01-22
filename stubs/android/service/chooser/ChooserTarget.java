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



package android.service.chooser;

import android.content.IntentFilter;
import android.os.Bundle;
import android.content.ComponentName;
import android.os.Parcelable;

/**
 * A ChooserTarget represents a deep-link into an application as returned by a
 * {@link android.service.chooser.ChooserTargetService}.
 *
 * <p>A chooser target represents a specific deep link target into an application exposed
 * for selection by the user. This might be a frequently emailed contact, a recently active
 * group messaging conversation, a folder in a cloud storage app, a collection of related
 * items published on a social media service or any other contextually relevant grouping
 * of target app + relevant metadata.</p>
 *
 * <p>Creators of chooser targets should consult the relevant design guidelines for the type
 * of target they are presenting. For example, targets involving people should be presented
 * with a circular icon.</p>
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ChooserTarget implements android.os.Parcelable {

/**
 * Construct a deep link target for presentation by a chooser UI.
 *
 * <p>A target is composed of a title and an icon for presentation to the user.
 * The UI presenting this target may truncate the title if it is too long to be presented
 * in the available space, as well as crop, resize or overlay the supplied icon.</p>
 *
 * <p>The creator of a target may supply a ranking score. This score is assumed to be relative
 * to the other targets supplied by the same
 * {@link android.service.chooser.ChooserTargetService#onGetChooserTargets(android.content.ComponentName,android.content.IntentFilter) ChooserTargetService#onGetChooserTargets(ComponentName, IntentFilter)}.
 * Scores should be in the range from 0.0f (unlikely match) to 1.0f (very relevant match).
 * Scores for a set of targets do not need to sum to 1.</p>
 *
 * <p>The ComponentName must be the name of an Activity component in the creator's own
 * package, or an exported component from any other package. You may provide an optional
 * Bundle of extras that will be merged into the final intent before it is sent to the
 * target Activity; use this to add any additional data about the deep link that the target
 * activity will read. e.g. conversation IDs, email addresses, etc.</p>
 *
 * <p>Take care not to place custom {@link android.os.Parcelable} types into
 * the extras bundle, as the system will not be able to unparcel them to merge them.</p>
 *
 * @param title title of this target that will be shown to a user
 * @param icon icon to represent this target
 * @param score ranking score for this target between 0.0f and 1.0f, inclusive
 * @param componentName Name of the component to be launched if this target is chosen
 * @param intentExtras Bundle of extras to merge with the extras of the launched intent
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public ChooserTarget(java.lang.CharSequence title, android.graphics.drawable.Icon icon, float score, android.content.ComponentName componentName, @androidx.annotation.Nullable android.os.Bundle intentExtras) { throw new RuntimeException("Stub!"); }

/**
 * Returns the title of this target for display to a user. The UI displaying the title
 * may truncate this title if it is too long to be displayed in full.
 *
 * @return the title of this target, intended to be shown to a user
 * @apiSince 23
 */

public java.lang.CharSequence getTitle() { throw new RuntimeException("Stub!"); }

/**
 * Returns the icon representing this target for display to a user. The UI displaying the icon
 * may crop, resize or overlay this icon.
 *
 * @return the icon representing this target, intended to be shown to a user
 * @apiSince 23
 */

public android.graphics.drawable.Icon getIcon() { throw new RuntimeException("Stub!"); }

/**
 * Returns the ranking score supplied by the creator of this ChooserTarget.
 * Values are between 0.0f and 1.0f. The UI displaying the target may
 * take this score into account when sorting and merging targets from multiple sources.
 *
 * @return the ranking score for this target between 0.0f and 1.0f, inclusive
 * @apiSince 23
 */

public float getScore() { throw new RuntimeException("Stub!"); }

/**
 * Returns the ComponentName of the Activity that should be launched for this ChooserTarget.
 *
 * @return the name of the target Activity to launch
 * @apiSince 23
 */

public android.content.ComponentName getComponentName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Bundle of extras to be added to an intent launched to this target.
 *
 * @return the extras to merge with the extras of the intent being launched
 * @apiSince 23
 */

public android.os.Bundle getIntentExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.chooser.ChooserTarget> CREATOR;
static { CREATOR = null; }
}

