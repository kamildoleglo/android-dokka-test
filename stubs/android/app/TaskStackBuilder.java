/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.app;

import android.content.Intent;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;

/**
 * Utility class for constructing synthetic back stacks for cross-task navigation
 * on Android 3.0 and newer.
 *
 * <p>In API level 11 (Android 3.0/Honeycomb) the recommended conventions for
 * app navigation using the back key changed. The back key's behavior is local
 * to the current task and does not capture navigation across different tasks.
 * Navigating across tasks and easily reaching the previous task is accomplished
 * through the "recents" UI, accessible through the software-provided Recents key
 * on the navigation or system bar. On devices with the older hardware button configuration
 * the recents UI can be accessed with a long press on the Home key.</p>
 *
 * <p>When crossing from one task stack to another post-Android 3.0,
 * the application should synthesize a back stack/history for the new task so that
 * the user may navigate out of the new task and back to the Launcher by repeated
 * presses of the back key. Back key presses should not navigate across task stacks.</p>
 *
 * <p>TaskStackBuilder provides a way to obey the correct conventions
 * around cross-task navigation.</p>
 *
 * <div class="special reference">
 * <h3>About Navigation</h3>
 * For more detailed information about tasks, the back stack, and navigation design guidelines,
 * please read
 * <a href="{@docRoot}guide/topics/fundamentals/tasks-and-back-stack.html">Tasks and Back Stack</a>
 * from the developer guide and <a href="{@docRoot}design/patterns/navigation.html">Navigation</a>
 * from the design guide.
 * </div>
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TaskStackBuilder {

private TaskStackBuilder() { throw new RuntimeException("Stub!"); }

/**
 * Return a new TaskStackBuilder for launching a fresh task stack consisting
 * of a series of activities.
 *
 * @param context The context that will launch the new task stack or generate a PendingIntent
 * @return A new TaskStackBuilder
 * @apiSince 16
 */

public static android.app.TaskStackBuilder create(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Add a new Intent to the task stack. The most recently added Intent will invoke
 * the Activity at the top of the final task stack.
 *
 * @param nextIntent Intent for the next Activity in the synthesized task stack
 * @return This TaskStackBuilder for method chaining
 * @apiSince 16
 */

public android.app.TaskStackBuilder addNextIntent(android.content.Intent nextIntent) { throw new RuntimeException("Stub!"); }

/**
 * Add a new Intent with the resolved chain of parents for the target activity to
 * the task stack.
 *
 * <p>This is equivalent to calling {@link #addParentStack(android.content.ComponentName) addParentStack}
 * with the resolved ComponentName of nextIntent (if it can be resolved), followed by
 * {@link #addNextIntent(android.content.Intent) addNextIntent} with nextIntent.</p>
 *
 * @param nextIntent Intent for the topmost Activity in the synthesized task stack.
 *                   Its chain of parents as specified in the manifest will be added.
 * @return This TaskStackBuilder for method chaining.
 * @apiSince 16
 */

public android.app.TaskStackBuilder addNextIntentWithParentStack(android.content.Intent nextIntent) { throw new RuntimeException("Stub!"); }

/**
 * Add the activity parent chain as specified by the
 * {@link android.app.Activity#getParentActivityIntent() Activity#getParentActivityIntent()} method of the activity
 * specified and the {@link android.R.attr#parentActivityName parentActivityName} attributes
 * of each successive activity (or activity-alias) element in the application's manifest
 * to the task stack builder.
 *
 * @param sourceActivity All parents of this activity will be added
 * @return This TaskStackBuilder for method chaining
 * @apiSince 16
 */

public android.app.TaskStackBuilder addParentStack(android.app.Activity sourceActivity) { throw new RuntimeException("Stub!"); }

/**
 * Add the activity parent chain as specified by the
 * {@link android.R.attr#parentActivityName parentActivityName} attribute of the activity
 * (or activity-alias) element in the application's manifest to the task stack builder.
 *
 * @param sourceActivityClass All parents of this activity will be added
 * @return This TaskStackBuilder for method chaining
 * @apiSince 16
 */

public android.app.TaskStackBuilder addParentStack(java.lang.Class<?> sourceActivityClass) { throw new RuntimeException("Stub!"); }

/**
 * Add the activity parent chain as specified by the
 * {@link android.R.attr#parentActivityName parentActivityName} attribute of the activity
 * (or activity-alias) element in the application's manifest to the task stack builder.
 *
 * @param sourceActivityName Must specify an Activity component. All parents of
 *                           this activity will be added
 * @return This TaskStackBuilder for method chaining
 * @apiSince 16
 */

public android.app.TaskStackBuilder addParentStack(android.content.ComponentName sourceActivityName) { throw new RuntimeException("Stub!"); }

/**
 * @return the number of intents added so far.
 * @apiSince 16
 */

public int getIntentCount() { throw new RuntimeException("Stub!"); }

/**
 * Return the intent at the specified index for modification.
 * Useful if you need to modify the flags or extras of an intent that was previously added,
 * for example with {@link #addParentStack(android.app.Activity)}.
 *
 * @param index Index from 0-getIntentCount()
 * @return the intent at position index
 * @apiSince 16
 */

public android.content.Intent editIntentAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Start the task stack constructed by this builder.
 * @apiSince 16
 */

public void startActivities() { throw new RuntimeException("Stub!"); }

/**
 * Start the task stack constructed by this builder.
 *
 * @param options Additional options for how the Activity should be started.
 * See {@link android.content.Context#startActivity(Intent, Bundle)}
 * Context.startActivity(Intent, Bundle)} for more details.
 * @apiSince 16
 */

public void startActivities(android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Obtain a {@link android.app.PendingIntent PendingIntent} for launching the task constructed by this builder so far.
 *
 * @param requestCode Private request code for the sender
 * @param flags May be {@link android.app.PendingIntent#FLAG_ONE_SHOT PendingIntent#FLAG_ONE_SHOT},
 *              {@link android.app.PendingIntent#FLAG_NO_CREATE PendingIntent#FLAG_NO_CREATE}, {@link android.app.PendingIntent#FLAG_CANCEL_CURRENT PendingIntent#FLAG_CANCEL_CURRENT},
 *              {@link android.app.PendingIntent#FLAG_UPDATE_CURRENT PendingIntent#FLAG_UPDATE_CURRENT}, or any of the flags supported by
 *              {@link android.content.Intent#fillIn(android.content.Intent,int) Intent#fillIn(Intent, int)} to control which unspecified parts of the
 *              intent that can be supplied when the actual send happens.
 *
 * Value is either <code>0</code> or a combination of {@link android.app.PendingIntent#FLAG_ONE_SHOT}, {@link android.app.PendingIntent#FLAG_NO_CREATE}, {@link android.app.PendingIntent#FLAG_CANCEL_CURRENT}, {@link android.app.PendingIntent#FLAG_UPDATE_CURRENT}, {@link android.app.PendingIntent#FLAG_IMMUTABLE}, {@link android.content.Intent#FILL_IN_ACTION}, {@link android.content.Intent#FILL_IN_DATA}, {@link android.content.Intent#FILL_IN_CATEGORIES}, {@link android.content.Intent#FILL_IN_COMPONENT}, {@link android.content.Intent#FILL_IN_PACKAGE}, {@link android.content.Intent#FILL_IN_SOURCE_BOUNDS}, {@link android.content.Intent#FILL_IN_SELECTOR}, and {@link android.content.Intent#FILL_IN_CLIP_DATA}
 * @return The obtained PendingIntent
 * @apiSince 16
 */

public android.app.PendingIntent getPendingIntent(int requestCode, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Obtain a {@link android.app.PendingIntent PendingIntent} for launching the task constructed by this builder so far.
 *
 * @param requestCode Private request code for the sender
 * @param flags May be {@link android.app.PendingIntent#FLAG_ONE_SHOT PendingIntent#FLAG_ONE_SHOT},
 *              {@link android.app.PendingIntent#FLAG_NO_CREATE PendingIntent#FLAG_NO_CREATE}, {@link android.app.PendingIntent#FLAG_CANCEL_CURRENT PendingIntent#FLAG_CANCEL_CURRENT},
 *              {@link android.app.PendingIntent#FLAG_UPDATE_CURRENT PendingIntent#FLAG_UPDATE_CURRENT}, or any of the flags supported by
 *              {@link android.content.Intent#fillIn(android.content.Intent,int) Intent#fillIn(Intent, int)} to control which unspecified parts of the
 *              intent that can be supplied when the actual send happens.
 * Value is either <code>0</code> or a combination of {@link android.app.PendingIntent#FLAG_ONE_SHOT}, {@link android.app.PendingIntent#FLAG_NO_CREATE}, {@link android.app.PendingIntent#FLAG_CANCEL_CURRENT}, {@link android.app.PendingIntent#FLAG_UPDATE_CURRENT}, {@link android.app.PendingIntent#FLAG_IMMUTABLE}, {@link android.content.Intent#FILL_IN_ACTION}, {@link android.content.Intent#FILL_IN_DATA}, {@link android.content.Intent#FILL_IN_CATEGORIES}, {@link android.content.Intent#FILL_IN_COMPONENT}, {@link android.content.Intent#FILL_IN_PACKAGE}, {@link android.content.Intent#FILL_IN_SOURCE_BOUNDS}, {@link android.content.Intent#FILL_IN_SELECTOR}, and {@link android.content.Intent#FILL_IN_CLIP_DATA}
 * @param options Additional options for how the Activity should be started.
 * See {@link android.content.Context#startActivity(Intent, Bundle)}
 * Context.startActivity(Intent, Bundle)} for more details.
 *
 * @return The obtained PendingIntent
 * @apiSince 16
 */

public android.app.PendingIntent getPendingIntent(int requestCode, int flags, android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Return an array containing the intents added to this builder. The intent at the
 * root of the task stack will appear as the first item in the array and the
 * intent at the top of the stack will appear as the last item.
 *
 * @return An array containing the intents added to this builder.
 
 * This value will never be {@code null}.
 * @apiSince 16
 */

@androidx.annotation.NonNull
public android.content.Intent[] getIntents() { throw new RuntimeException("Stub!"); }
}

