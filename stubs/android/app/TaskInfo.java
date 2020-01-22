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


package android.app;


/**
 * Stores information about a particular Task.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TaskInfo {

TaskInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The component of the first activity in the task, can be considered the "application" of this
 * task.
 * @apiSince 29
 */

@androidx.annotation.Nullable public android.content.ComponentName baseActivity;

/**
 * The base intent of the task (generally the intent that launched the task). This intent can
 * be used to relaunch the task (if it is no longer running) or brought to the front if it is.
 * @apiSince 29
 */

@androidx.annotation.NonNull public android.content.Intent baseIntent;

/**
 * Whether or not this task has any running activities.
 * @apiSince 29
 */

public boolean isRunning;

/**
 * The number of activities in this task (including running).
 * @apiSince 29
 */

public int numActivities;

/**
 * The component of the target activity if this task was started from an activity alias.
 * Otherwise, this is null.
 * @apiSince 29
 */

@androidx.annotation.Nullable public android.content.ComponentName origActivity;

/**
 * The recent activity values for the highest activity in the stack to have set the values.
 * {@link android.app.Activity#setTaskDescription(android.app.ActivityManager.TaskDescription) Activity#setTaskDescription(android.app.ActivityManager.TaskDescription)}.
 * @apiSince 29
 */

@androidx.annotation.Nullable public android.app.ActivityManager.TaskDescription taskDescription;

/**
 * The identifier for this task.
 * @apiSince 29
 */

public int taskId;

/**
 * The component of the top activity in the task, currently showing to the user.
 * @apiSince 29
 */

@androidx.annotation.Nullable public android.content.ComponentName topActivity;
}

