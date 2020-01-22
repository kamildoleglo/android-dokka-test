/*
 * Copyright (C) 2006 The Android Open Source Project
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

import android.content.res.Configuration;
import android.os.Process;
import android.os.Build;
import android.content.res.Resources;
import android.net.Uri;
import android.view.KeyEvent;
import android.content.Context;
import android.view.Window;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.os.Looper;
import android.os.PersistableBundle;
import android.database.Cursor;
import android.app.VoiceInteractor.Request;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import android.os.CancellationSignal;
import java.util.List;
import android.content.CursorLoader;
import android.content.ContentResolver;
import android.widget.Toolbar;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.transition.TransitionManager;
import android.transition.Scene;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.Menu;
import android.os.Handler;
import android.widget.AdapterView;
import android.view.View.OnCreateContextMenuListener;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.ContextMenu;
import android.view.SearchEvent;
import android.graphics.drawable.Drawable;
import android.view.MenuInflater;
import android.content.pm.PackageManager;
import android.content.IntentSender;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.session.MediaController;
import android.view.LayoutInflater;
import android.util.AttributeSet;
import java.io.PrintWriter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.ActionMode;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.app.admin.DevicePolicyManager;

/**
 * An activity is a single, focused thing that the user can do.  Almost all
 * activities interact with the user, so the Activity class takes care of
 * creating a window for you in which you can place your UI with
 * {@link #setContentView}.  While activities are often presented to the user
 * as full-screen windows, they can also be used in other ways: as floating
 * windows (via a theme with {@link android.R.attr#windowIsFloating} set),
 * <a href="https://developer.android.com/guide/topics/ui/multi-window">
 * Multi-Window mode</a> or embedded into other windows.
 *
 * There are two methods almost all subclasses of Activity will implement:
 *
 * <ul>
 *     <li> {@link #onCreate} is where you initialize your activity.  Most
 *     importantly, here you will usually call {@link #setContentView(int)}
 *     with a layout resource defining your UI, and using {@link #findViewById}
 *     to retrieve the widgets in that UI that you need to interact with
 *     programmatically.
 *
 *     <li> {@link #onPause} is where you deal with the user pausing active
 *     interaction with the activity. Any changes made by the user should at
 *     this point be committed (usually to the
 *     {@link android.content.ContentProvider} holding the data). In this
 *     state the activity is still visible on screen.
 * </ul>
 *
 * <p>To be of use with {@link android.content.Context#startActivity Context.startActivity()}, all
 * activity classes must have a corresponding
 * {@link android.R.styleable#AndroidManifestActivity &lt;activity&gt;}
 * declaration in their package's <code>AndroidManifest.xml</code>.</p>
 *
 * <p>Topics covered here:
 * <ol>
 * <li><a href="#Fragments">Fragments</a>
 * <li><a href="#ActivityLifecycle">Activity Lifecycle</a>
 * <li><a href="#ConfigurationChanges">Configuration Changes</a>
 * <li><a href="#StartingActivities">Starting Activities and Getting Results</a>
 * <li><a href="#SavingPersistentState">Saving Persistent State</a>
 * <li><a href="#Permissions">Permissions</a>
 * <li><a href="#ProcessLifecycle">Process Lifecycle</a>
 * </ol>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>The Activity class is an important part of an application's overall lifecycle,
 * and the way activities are launched and put together is a fundamental
 * part of the platform's application model. For a detailed perspective on the structure of an
 * Android application and how activities behave, please read the
 * <a href="{@docRoot}guide/topics/fundamentals.html">Application Fundamentals</a> and
 * <a href="{@docRoot}guide/components/tasks-and-back-stack.html">Tasks and Back Stack</a>
 * developer guides.</p>
 *
 * <p>You can also find a detailed discussion about how to create activities in the
 * <a href="{@docRoot}guide/components/activities.html">Activities</a>
 * developer guide.</p>
 * </div>
 *
 * <a name="Fragments"></a>
 * <h3>Fragments</h3>
 *
 * <p>The {@link android.support.v4.app.FragmentActivity} subclass
 * can make use of the {@link android.support.v4.app.Fragment} class to better
 * modularize their code, build more sophisticated user interfaces for larger
 * screens, and help scale their application between small and large screens.</p>
 *
 * <p>For more information about using fragments, read the
 * <a href="{@docRoot}guide/components/fragments.html">Fragments</a> developer guide.</p>
 *
 * <a name="ActivityLifecycle"></a>
 * <h3>Activity Lifecycle</h3>
 *
 * <p>Activities in the system are managed as
 * <a href="https://developer.android.com/guide/components/activities/tasks-and-back-stack">
 * activity stacks</a>. When a new activity is started, it is usually placed on the top of the
 * current stack and becomes the running activity -- the previous activity always remains
 * below it in the stack, and will not come to the foreground again until
 * the new activity exits. There can be one or multiple activity stacks visible
 * on screen.</p>
 *
 * <p>An activity has essentially four states:</p>
 * <ul>
 *     <li>If an activity is in the foreground of the screen (at the highest position of the topmost
 *         stack), it is <em>active</em> or <em>running</em>. This is usually the activity that the
 *         user is currently interacting with.</li>
 *     <li>If an activity has lost focus but is still presented to the user, it is <em>visible</em>.
 *         It is possible if a new non-full-sized or transparent activity has focus on top of your
 *         activity, another activity has higher position in multi-window mode, or the activity
 *         itself is not focusable in current windowing mode. Such activity is completely alive (it
 *         maintains all state and member information and remains attached to the window manager).
 *     <li>If an activity is completely obscured by another activity,
 *         it is <em>stopped</em> or <em>hidden</em>. It still retains all state and member
 *         information, however, it is no longer visible to the user so its window is hidden
 *         and it will often be killed by the system when memory is needed elsewhere.</li>
 *     <li>The system can drop the activity from memory by either asking it to finish,
 *         or simply killing its process, making it <em>destroyed</em>. When it is displayed again
 *         to the user, it must be completely restarted and restored to its previous state.</li>
 * </ul>
 *
 * <p>The following diagram shows the important state paths of an Activity.
 * The square rectangles represent callback methods you can implement to
 * perform operations when the Activity moves between states.  The colored
 * ovals are major states the Activity can be in.</p>
 *
 * <p><img src="../../../images/activity_lifecycle.png"
 *      alt="State diagram for an Android Activity Lifecycle." border="0" /></p>
 *
 * <p>There are three key loops you may be interested in monitoring within your
 * activity:
 *
 * <ul>
 * <li>The <b>entire lifetime</b> of an activity happens between the first call
 * to {@link android.app.Activity#onCreate} through to a single final call
 * to {@link android.app.Activity#onDestroy}.  An activity will do all setup
 * of "global" state in onCreate(), and release all remaining resources in
 * onDestroy().  For example, if it has a thread running in the background
 * to download data from the network, it may create that thread in onCreate()
 * and then stop the thread in onDestroy().
 *
 * <li>The <b>visible lifetime</b> of an activity happens between a call to
 * {@link android.app.Activity#onStart} until a corresponding call to
 * {@link android.app.Activity#onStop}.  During this time the user can see the
 * activity on-screen, though it may not be in the foreground and interacting
 * with the user.  Between these two methods you can maintain resources that
 * are needed to show the activity to the user.  For example, you can register
 * a {@link android.content.BroadcastReceiver} in onStart() to monitor for changes
 * that impact your UI, and unregister it in onStop() when the user no
 * longer sees what you are displaying.  The onStart() and onStop() methods
 * can be called multiple times, as the activity becomes visible and hidden
 * to the user.
 *
 * <li>The <b>foreground lifetime</b> of an activity happens between a call to
 * {@link android.app.Activity#onResume} until a corresponding call to
 * {@link android.app.Activity#onPause}.  During this time the activity is
 * in visible, active and interacting with the user.  An activity
 * can frequently go between the resumed and paused states -- for example when
 * the device goes to sleep, when an activity result is delivered, when a new
 * intent is delivered -- so the code in these methods should be fairly
 * lightweight.
 * </ul>
 *
 * <p>The entire lifecycle of an activity is defined by the following
 * Activity methods.  All of these are hooks that you can override
 * to do appropriate work when the activity changes state.  All
 * activities will implement {@link android.app.Activity#onCreate}
 * to do their initial setup; many will also implement
 * {@link android.app.Activity#onPause} to commit changes to data and
 * prepare to pause interacting with the user, and {@link android.app.Activity#onStop}
 * to handle no longer being visible on screen. You should always
 * call up to your superclass when implementing these methods.</p>
 *
 * </p>
 * <pre class="prettyprint">
 * public class Activity extends ApplicationContext {
 *     protected void onCreate(Bundle savedInstanceState);
 *
 *     protected void onStart();
 *
 *     protected void onRestart();
 *
 *     protected void onResume();
 *
 *     protected void onPause();
 *
 *     protected void onStop();
 *
 *     protected void onDestroy();
 * }
 * </pre>
 *
 * <p>In general the movement through an activity's lifecycle looks like
 * this:</p>
 *
 * <table border="2" width="85%" align="center" frame="hsides" rules="rows">
 *     <colgroup align="left" span="3" />
 *     <colgroup align="left" />
 *     <colgroup align="center" />
 *     <colgroup align="center" />
 *
 *     <thead>
 *     <tr><th colspan="3">Method</th> <th>Description</th> <th>Killable?</th> <th>Next</th></tr>
 *     </thead>
 *
 *     <tbody>
 *     <tr><td colspan="3" align="left" border="0">{@link android.app.Activity#onCreate onCreate()}</td>
 *         <td>Called when the activity is first created.
 *             This is where you should do all of your normal static set up:
 *             create views, bind data to lists, etc.  This method also
 *             provides you with a Bundle containing the activity's previously
 *             frozen state, if there was one.
 *             <p>Always followed by <code>onStart()</code>.</td>
 *         <td align="center">No</td>
 *         <td align="center"><code>onStart()</code></td>
 *     </tr>
 *
 *     <tr><td rowspan="5" style="border-left: none; border-right: none;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
 *         <td colspan="2" align="left" border="0">{@link android.app.Activity#onRestart onRestart()}</td>
 *         <td>Called after your activity has been stopped, prior to it being
 *             started again.
 *             <p>Always followed by <code>onStart()</code></td>
 *         <td align="center">No</td>
 *         <td align="center"><code>onStart()</code></td>
 *     </tr>
 *
 *     <tr><td colspan="2" align="left" border="0">{@link android.app.Activity#onStart onStart()}</td>
 *         <td>Called when the activity is becoming visible to the user.
 *             <p>Followed by <code>onResume()</code> if the activity comes
 *             to the foreground, or <code>onStop()</code> if it becomes hidden.</td>
 *         <td align="center">No</td>
 *         <td align="center"><code>onResume()</code> or <code>onStop()</code></td>
 *     </tr>
 *
 *     <tr><td rowspan="2" style="border-left: none;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
 *         <td align="left" border="0">{@link android.app.Activity#onResume onResume()}</td>
 *         <td>Called when the activity will start
 *             interacting with the user.  At this point your activity is at
 *             the top of its activity stack, with user input going to it.
 *             <p>Always followed by <code>onPause()</code>.</td>
 *         <td align="center">No</td>
 *         <td align="center"><code>onPause()</code></td>
 *     </tr>
 *
 *     <tr><td align="left" border="0">{@link android.app.Activity#onPause onPause()}</td>
 *         <td>Called when the activity loses foreground state, is no longer focusable or before
 *             transition to stopped/hidden or destroyed state. The activity is still visible to
 *             user, so it's recommended to keep it visually active and continue updating the UI.
 *             Implementations of this method must be very quick because
 *             the next activity will not be resumed until this method returns.
 *             <p>Followed by either <code>onResume()</code> if the activity
 *             returns back to the front, or <code>onStop()</code> if it becomes
 *             invisible to the user.</td>
 *         <td align="center"><font color="#800000"><strong>Pre-{@link android.os.Build.VERSION_CODES#HONEYCOMB}</strong></font></td>
 *         <td align="center"><code>onResume()</code> or<br>
 *                 <code>onStop()</code></td>
 *     </tr>
 *
 *     <tr><td colspan="2" align="left" border="0">{@link android.app.Activity#onStop onStop()}</td>
 *         <td>Called when the activity is no longer visible to the user.  This may happen either
 *             because a new activity is being started on top, an existing one is being brought in
 *             front of this one, or this one is being destroyed. This is typically used to stop
 *             animations and refreshing the UI, etc.
 *             <p>Followed by either <code>onRestart()</code> if
 *             this activity is coming back to interact with the user, or
 *             <code>onDestroy()</code> if this activity is going away.</td>
 *         <td align="center"><font color="#800000"><strong>Yes</strong></font></td>
 *         <td align="center"><code>onRestart()</code> or<br>
 *                 <code>onDestroy()</code></td>
 *     </tr>
 *
 *     <tr><td colspan="3" align="left" border="0">{@link android.app.Activity#onDestroy onDestroy()}</td>
 *         <td>The final call you receive before your
 *             activity is destroyed.  This can happen either because the
 *             activity is finishing (someone called {@link android.app.Activity#finish Activity#finish} on
 *             it), or because the system is temporarily destroying this
 *             instance of the activity to save space.  You can distinguish
 *             between these two scenarios with the {@link android.app.Activity#isFinishing Activity#isFinishing} method.</td>
 *         <td align="center"><font color="#800000"><strong>Yes</strong></font></td>
 *         <td align="center"><em>nothing</em></td>
 *     </tr>
 *     </tbody>
 * </table>
 *
 * <p>Note the "Killable" column in the above table -- for those methods that
 * are marked as being killable, after that method returns the process hosting the
 * activity may be killed by the system <em>at any time</em> without another line
 * of its code being executed.  Because of this, you should use the
 * {@link #onPause} method to write any persistent data (such as user edits)
 * to storage.  In addition, the method
 * {@link #onSaveInstanceState(android.os.Bundle)} is called before placing the activity
 * in such a background state, allowing you to save away any dynamic instance
 * state in your activity into the given Bundle, to be later received in
 * {@link #onCreate} if the activity needs to be re-created.
 * See the <a href="#ProcessLifecycle">Process Lifecycle</a>
 * section for more information on how the lifecycle of a process is tied
 * to the activities it is hosting.  Note that it is important to save
 * persistent data in {@link #onPause} instead of {@link #onSaveInstanceState}
 * because the latter is not part of the lifecycle callbacks, so will not
 * be called in every situation as described in its documentation.</p>
 *
 * <p class="note">Be aware that these semantics will change slightly between
 * applications targeting platforms starting with {@link android.os.Build.VERSION_CODES#HONEYCOMB}
 * vs. those targeting prior platforms.  Starting with Honeycomb, an application
 * is not in the killable state until its {@link #onStop} has returned.  This
 * impacts when {@link #onSaveInstanceState(android.os.Bundle)} may be called (it may be
 * safely called after {@link #onPause()}) and allows an application to safely
 * wait until {@link #onStop()} to save persistent state.</p>
 *
 * <p class="note">For applications targeting platforms starting with
 * {@link android.os.Build.VERSION_CODES#P} {@link #onSaveInstanceState(android.os.Bundle)}
 * will always be called after {@link #onStop}, so an application may safely
 * perform fragment transactions in {@link #onStop} and will be able to save
 * persistent state later.</p>
 *
 * <p>For those methods that are not marked as being killable, the activity's
 * process will not be killed by the system starting from the time the method
 * is called and continuing after it returns.  Thus an activity is in the killable
 * state, for example, between after <code>onStop()</code> to the start of
 * <code>onResume()</code>. Keep in mind that under extreme memory pressure the
 * system can kill the application process at any time.</p>
 *
 * <a name="ConfigurationChanges"></a>
 * <h3>Configuration Changes</h3>
 *
 * <p>If the configuration of the device (as defined by the
 * {@link android.content.res.Configuration Configuration} class) changes,
 * then anything displaying a user interface will need to update to match that
 * configuration.  Because Activity is the primary mechanism for interacting
 * with the user, it includes special support for handling configuration
 * changes.</p>
 *
 * <p>Unless you specify otherwise, a configuration change (such as a change
 * in screen orientation, language, input devices, etc) will cause your
 * current activity to be <em>destroyed</em>, going through the normal activity
 * lifecycle process of {@link #onPause},
 * {@link #onStop}, and {@link #onDestroy} as appropriate.  If the activity
 * had been in the foreground or visible to the user, once {@link #onDestroy} is
 * called in that instance then a new instance of the activity will be
 * created, with whatever savedInstanceState the previous instance had generated
 * from {@link #onSaveInstanceState}.</p>
 *
 * <p>This is done because any application resource,
 * including layout files, can change based on any configuration value.  Thus
 * the only safe way to handle a configuration change is to re-retrieve all
 * resources, including layouts, drawables, and strings.  Because activities
 * must already know how to save their state and re-create themselves from
 * that state, this is a convenient way to have an activity restart itself
 * with a new configuration.</p>
 *
 * <p>In some special cases, you may want to bypass restarting of your
 * activity based on one or more types of configuration changes.  This is
 * done with the {@link android.R.attr#configChanges android:configChanges}
 * attribute in its manifest.  For any types of configuration changes you say
 * that you handle there, you will receive a call to your current activity's
 * {@link #onConfigurationChanged} method instead of being restarted.  If
 * a configuration change involves any that you do not handle, however, the
 * activity will still be restarted and {@link #onConfigurationChanged}
 * will not be called.</p>
 *
 * <a name="StartingActivities"></a>
 * <h3>Starting Activities and Getting Results</h3>
 *
 * <p>The {@link android.app.Activity#startActivity}
 * method is used to start a
 * new activity, which will be placed at the top of the activity stack.  It
 * takes a single argument, an {@link android.content.Intent Intent},
 * which describes the activity
 * to be executed.</p>
 *
 * <p>Sometimes you want to get a result back from an activity when it
 * ends.  For example, you may start an activity that lets the user pick
 * a person in a list of contacts; when it ends, it returns the person
 * that was selected.  To do this, you call the
 * {@link android.app.Activity#startActivityForResult(Intent, int)}
 * version with a second integer parameter identifying the call.  The result
 * will come back through your {@link android.app.Activity#onActivityResult}
 * method.</p>
 *
 * <p>When an activity exits, it can call
 * {@link android.app.Activity#setResult(int)}
 * to return data back to its parent.  It must always supply a result code,
 * which can be the standard results RESULT_CANCELED, RESULT_OK, or any
 * custom values starting at RESULT_FIRST_USER.  In addition, it can optionally
 * return back an Intent containing any additional data it wants.  All of this
 * information appears back on the
 * parent's <code>Activity.onActivityResult()</code>, along with the integer
 * identifier it originally supplied.</p>
 *
 * <p>If a child activity fails for any reason (such as crashing), the parent
 * activity will receive a result with the code RESULT_CANCELED.</p>
 *
 * <pre class="prettyprint">
 * public class MyActivity extends Activity {
 *     ...
 *
 *     static final int PICK_CONTACT_REQUEST = 0;
 *
 *     public boolean onKeyDown(int keyCode, KeyEvent event) {
 *         if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
 *             // When the user center presses, let them pick a contact.
 *             startActivityForResult(
 *                 new Intent(Intent.ACTION_PICK,
 *                 new Uri("content://contacts")),
 *                 PICK_CONTACT_REQUEST);
 *            return true;
 *         }
 *         return false;
 *     }
 *
 *     protected void onActivityResult(int requestCode, int resultCode,
 *             Intent data) {
 *         if (requestCode == PICK_CONTACT_REQUEST) {
 *             if (resultCode == RESULT_OK) {
 *                 // A contact was picked.  Here we will just display it
 *                 // to the user.
 *                 startActivity(new Intent(Intent.ACTION_VIEW, data));
 *             }
 *         }
 *     }
 * }
 * </pre>
 *
 * <a name="SavingPersistentState"></a>
 * <h3>Saving Persistent State</h3>
 *
 * <p>There are generally two kinds of persistent state that an activity
 * will deal with: shared document-like data (typically stored in a SQLite
 * database using a {@linkplain android.content.ContentProvider content provider})
 * and internal state such as user preferences.</p>
 *
 * <p>For content provider data, we suggest that activities use an
 * "edit in place" user model.  That is, any edits a user makes are effectively
 * made immediately without requiring an additional confirmation step.
 * Supporting this model is generally a simple matter of following two rules:</p>
 *
 * <ul>
 *     <li> <p>When creating a new document, the backing database entry or file for
 *             it is created immediately.  For example, if the user chooses to write
 *             a new email, a new entry for that email is created as soon as they
 *             start entering data, so that if they go to any other activity after
 *             that point this email will now appear in the list of drafts.</p>
 *     <li> <p>When an activity's <code>onPause()</code> method is called, it should
 *             commit to the backing content provider or file any changes the user
 *             has made.  This ensures that those changes will be seen by any other
 *             activity that is about to run.  You will probably want to commit
 *             your data even more aggressively at key times during your
 *             activity's lifecycle: for example before starting a new
 *             activity, before finishing your own activity, when the user
 *             switches between input fields, etc.</p>
 * </ul>
 *
 * <p>This model is designed to prevent data loss when a user is navigating
 * between activities, and allows the system to safely kill an activity (because
 * system resources are needed somewhere else) at any time after it has been
 * stopped (or paused on platform versions before {@link android.os.Build.VERSION_CODES#HONEYCOMB}).
 * Note this implies that the user pressing BACK from your activity does <em>not</em>
 * mean "cancel" -- it means to leave the activity with its current contents
 * saved away.  Canceling edits in an activity must be provided through
 * some other mechanism, such as an explicit "revert" or "undo" option.</p>
 *
 * <p>See the {@linkplain android.content.ContentProvider content package} for
 * more information about content providers.  These are a key aspect of how
 * different activities invoke and propagate data between themselves.</p>
 *
 * <p>The Activity class also provides an API for managing internal persistent state
 * associated with an activity.  This can be used, for example, to remember
 * the user's preferred initial display in a calendar (day view or week view)
 * or the user's default home page in a web browser.</p>
 *
 * <p>Activity persistent state is managed
 * with the method {@link #getPreferences},
 * allowing you to retrieve and
 * modify a set of name/value pairs associated with the activity.  To use
 * preferences that are shared across multiple application components
 * (activities, receivers, services, providers), you can use the underlying
 * {@link android.content.Context#getSharedPreferences Context#getSharedPreferences} method
 * to retrieve a preferences
 * object stored under a specific name.
 * (Note that it is not possible to share settings data across application
 * packages -- for that you will need a content provider.)</p>
 *
 * <p>Here is an excerpt from a calendar activity that stores the user's
 * preferred view mode in its persistent settings:</p>
 *
 * <pre class="prettyprint">
 * public class CalendarActivity extends Activity {
 *     ...
 *
 *     static final int DAY_VIEW_MODE = 0;
 *     static final int WEEK_VIEW_MODE = 1;
 *
 *     private SharedPreferences mPrefs;
 *     private int mCurViewMode;
 *
 *     protected void onCreate(Bundle savedInstanceState) {
 *         super.onCreate(savedInstanceState);
 *
 *         SharedPreferences mPrefs = getSharedPreferences();
 *         mCurViewMode = mPrefs.getInt("view_mode", DAY_VIEW_MODE);
 *     }
 *
 *     protected void onPause() {
 *         super.onPause();
 *
 *         SharedPreferences.Editor ed = mPrefs.edit();
 *         ed.putInt("view_mode", mCurViewMode);
 *         ed.commit();
 *     }
 * }
 * </pre>
 *
 * <a name="Permissions"></a>
 * <h3>Permissions</h3>
 *
 * <p>The ability to start a particular Activity can be enforced when it is
 * declared in its
 * manifest's {@link android.R.styleable#AndroidManifestActivity &lt;activity&gt;}
 * tag.  By doing so, other applications will need to declare a corresponding
 * {@link android.R.styleable#AndroidManifestUsesPermission &lt;uses-permission&gt;}
 * element in their own manifest to be able to start that activity.
 *
 * <p>When starting an Activity you can set {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION Intent#FLAG_GRANT_READ_URI_PERMISSION} and/or {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION Intent#FLAG_GRANT_WRITE_URI_PERMISSION} on the Intent.  This will grant the
 * Activity access to the specific URIs in the Intent.  Access will remain
 * until the Activity has finished (it will remain across the hosting
 * process being killed and other temporary destruction).  As of
 * {@link android.os.Build.VERSION_CODES#GINGERBREAD}, if the Activity
 * was already created and a new Intent is being delivered to
 * {@link #onNewIntent(android.content.Intent)}, any newly granted URI permissions will be added
 * to the existing ones it holds.
 *
 * <p>See the <a href="{@docRoot}guide/topics/security/security.html">Security and Permissions</a>
 * document for more information on permissions and security in general.
 *
 * <a name="ProcessLifecycle"></a>
 * <h3>Process Lifecycle</h3>
 *
 * <p>The Android system attempts to keep an application process around for as
 * long as possible, but eventually will need to remove old processes when
 * memory runs low. As described in <a href="#ActivityLifecycle">Activity
 * Lifecycle</a>, the decision about which process to remove is intimately
 * tied to the state of the user's interaction with it. In general, there
 * are four states a process can be in based on the activities running in it,
 * listed here in order of importance. The system will kill less important
 * processes (the last ones) before it resorts to killing more important
 * processes (the first ones).
 *
 * <ol>
 * <li> <p>The <b>foreground activity</b> (the activity at the top of the screen
 * that the user is currently interacting with) is considered the most important.
 * Its process will only be killed as a last resort, if it uses more memory
 * than is available on the device.  Generally at this point the device has
 * reached a memory paging state, so this is required in order to keep the user
 * interface responsive.
 * <li> <p>A <b>visible activity</b> (an activity that is visible to the user
 * but not in the foreground, such as one sitting behind a foreground dialog
 * or next to other activities in multi-window mode)
 * is considered extremely important and will not be killed unless that is
 * required to keep the foreground activity running.
 * <li> <p>A <b>background activity</b> (an activity that is not visible to
 * the user and has been stopped) is no longer critical, so the system may
 * safely kill its process to reclaim memory for other foreground or
 * visible processes.  If its process needs to be killed, when the user navigates
 * back to the activity (making it visible on the screen again), its
 * {@link #onCreate} method will be called with the savedInstanceState it had previously
 * supplied in {@link #onSaveInstanceState} so that it can restart itself in the same
 * state as the user last left it.
 * <li> <p>An <b>empty process</b> is one hosting no activities or other
 * application components (such as {@link android.app.Service Service} or
 * {@link android.content.BroadcastReceiver} classes).  These are killed very
 * quickly by the system as memory becomes low.  For this reason, any
 * background operation you do outside of an activity must be executed in the
 * context of an activity BroadcastReceiver or Service to ensure that the system
 * knows it needs to keep your process around.
 * </ol>
 *
 * <p>Sometimes an Activity may need to do a long-running operation that exists
 * independently of the activity lifecycle itself.  An example may be a camera
 * application that allows you to upload a picture to a web site.  The upload
 * may take a long time, and the application should allow the user to leave
 * the application while it is executing.  To accomplish this, your Activity
 * should start a {@link android.app.Service Service} in which the upload takes place.  This allows
 * the system to properly prioritize your process (considering it to be more
 * important than other non-visible applications) for the duration of the
 * upload, independent of whether the original activity is paused, stopped,
 * or finished.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Activity extends android.view.ContextThemeWrapper implements android.view.LayoutInflater.Factory2, android.view.Window.Callback, android.view.KeyEvent.Callback, android.view.View.OnCreateContextMenuListener, android.content.ComponentCallbacks2 {

public Activity() { throw new RuntimeException("Stub!"); }

/**
 * Return the intent that started this activity.
 * @apiSince 1
 */

public android.content.Intent getIntent() { throw new RuntimeException("Stub!"); }

/**
 * Change the intent returned by {@link #getIntent}.  This holds a
 * reference to the given intent; it does not copy it.  Often used in
 * conjunction with {@link #onNewIntent}.
 *
 * @param newIntent The new Intent object to return from getIntent
 *
 * @see #getIntent
 * @see #onNewIntent
 * @apiSince 1
 */

public void setIntent(android.content.Intent newIntent) { throw new RuntimeException("Stub!"); }

/**
 * Return the application that owns this activity.
 * @apiSince 1
 */

public final android.app.Application getApplication() { throw new RuntimeException("Stub!"); }

/**
 * Is this activity embedded inside of another activity?
 * @apiSince 1
 */

public final boolean isChild() { throw new RuntimeException("Stub!"); }

/**
 * Return the parent activity if this view is an embedded child.
 * @apiSince 1
 */

public final android.app.Activity getParent() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the window manager for showing custom windows.
 * @apiSince 1
 */

public android.view.WindowManager getWindowManager() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current {@link android.view.Window} for the activity.
 * This can be used to directly access parts of the Window API that
 * are not available through Activity/Screen.
 *
 * @return Window The current window, or null if the activity is not
 *         visual.
 * @apiSince 1
 */

public android.view.Window getWindow() { throw new RuntimeException("Stub!"); }

/**
 * Return the LoaderManager for this activity, creating it if needed.
 *
 * @deprecated Use {@link android.support.v4.app.FragmentActivity#getSupportLoaderManager()}
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public android.app.LoaderManager getLoaderManager() { throw new RuntimeException("Stub!"); }

/**
 * Calls {@link android.view.Window#getCurrentFocus} on the
 * Window of this Activity to return the currently focused view.
 *
 * @return View The current View with focus or null.
 *
 * @see #getWindow
 * @see android.view.Window#getCurrentFocus
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.view.View getCurrentFocus() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void attachBaseContext(android.content.Context newBase) { throw new RuntimeException("Stub!"); }

/**
 * Register an {@link android.app.Application.ActivityLifecycleCallbacks Application.ActivityLifecycleCallbacks} instance that receives
 * lifecycle callbacks for only this Activity.
 * <p>
 * In relation to any
 * {@link android.app.Application#registerActivityLifecycleCallbacks Application#registerActivityLifecycleCallbacks},
 * the callbacks registered here will always occur nested within those callbacks. This means:
 * <ul>
 *     <li>Pre events will first be sent to Application registered callbacks, then to callbacks
 *     registered here.</li>
 *     <li>{@link android.app.Application.ActivityLifecycleCallbacks#onActivityCreated(android.app.Activity,android.os.Bundle) Application.ActivityLifecycleCallbacks#onActivityCreated(Activity, Bundle)},
 *     {@link android.app.Application.ActivityLifecycleCallbacks#onActivityStarted(android.app.Activity) Application.ActivityLifecycleCallbacks#onActivityStarted(Activity)}, and
 *     {@link android.app.Application.ActivityLifecycleCallbacks#onActivityResumed(android.app.Activity) Application.ActivityLifecycleCallbacks#onActivityResumed(Activity)} will
 *     be sent first to Application registered callbacks, then to callbacks registered here.
 *     For all other events, callbacks registered here will be sent first.</li>
 *     <li>Post events will first be sent to callbacks registered here, then to
 *     Application registered callbacks.</li>
 * </ul>
 * <p>
 * If multiple callbacks are registered here, they receive events in a first in (up through
 * {@link android.app.Application.ActivityLifecycleCallbacks#onActivityPostResumed Application.ActivityLifecycleCallbacks#onActivityPostResumed}, last out
 * ordering.
 * <p>
 * It is strongly recommended to register this in the constructor of your Activity to ensure
 * you get all available callbacks. As this callback is associated with only this Activity,
 * it is not usually necessary to {@link #unregisterActivityLifecycleCallbacks unregister} it
 * unless you specifically do not want to receive further lifecycle callbacks.
 *
 * @param callback The callback instance to register
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void registerActivityLifecycleCallbacks(@androidx.annotation.NonNull android.app.Application.ActivityLifecycleCallbacks callback) { throw new RuntimeException("Stub!"); }

/**
 * Unregister an {@link android.app.Application.ActivityLifecycleCallbacks Application.ActivityLifecycleCallbacks} previously registered
 * with {@link #registerActivityLifecycleCallbacks}. It will not receive any further
 * callbacks.
 *
 * @param callback The callback instance to unregister
 * This value must never be {@code null}.
 * @see #registerActivityLifecycleCallbacks
 * @apiSince 29
 */

public void unregisterActivityLifecycleCallbacks(@androidx.annotation.NonNull android.app.Application.ActivityLifecycleCallbacks callback) { throw new RuntimeException("Stub!"); }

/**
 * Called when the activity is starting.  This is where most initialization
 * should go: calling {@link #setContentView(int)} to inflate the
 * activity's UI, using {@link #findViewById} to programmatically interact
 * with widgets in the UI, calling
 * {@link #managedQuery(android.net.Uri,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String)} to retrieve
 * cursors for data being displayed, etc.
 *
 * <p>You can call {@link #finish} from within this function, in
 * which case onDestroy() will be immediately called after {@link #onCreate} without any of the
 * rest of the activity lifecycle ({@link #onStart}, {@link #onResume}, {@link #onPause}, etc)
 * executing.
 *
 * <p><em>Derived classes must call through to the super class's
 * implementation of this method.  If they do not, an exception will be
 * thrown.</em></p>
 *
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @param savedInstanceState If the activity is being re-initialized after
 *     previously being shut down then this Bundle contains the data it most
 *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
 *
 * This value may be {@code null}.
 * @see #onStart
 * @see #onSaveInstanceState
 * @see #onRestoreInstanceState
 * @see #onPostCreate
 * @apiSince 1
 */

protected void onCreate(@androidx.annotation.Nullable android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Same as {@link #onCreate(android.os.Bundle)} but called for those activities created with
 * the attribute {@link android.R.attr#persistableMode} set to
 * <code>persistAcrossReboots</code>.
 *
 * @param savedInstanceState if the activity is being re-initialized after
 *     previously being shut down then this Bundle contains the data it most
 *     recently supplied in {@link #onSaveInstanceState}.
 *     <b><i>Note: Otherwise it is null.</i></b>
 * This value may be {@code null}.
 * @param persistentState if the activity is being re-initialized after
 *     previously being shut down or powered off then this Bundle contains the data it most
 *     recently supplied to outPersistentState in {@link #onSaveInstanceState}.
 *     <b><i>Note: Otherwise it is null.</i></b>
 *
 * This value may be {@code null}.
 * @see #onCreate(android.os.Bundle)
 * @see #onStart
 * @see #onSaveInstanceState
 * @see #onRestoreInstanceState
 * @see #onPostCreate
 * @apiSince 21
 */

public void onCreate(@androidx.annotation.Nullable android.os.Bundle savedInstanceState, @androidx.annotation.Nullable android.os.PersistableBundle persistentState) { throw new RuntimeException("Stub!"); }

/**
 * This method is called after {@link #onStart} when the activity is
 * being re-initialized from a previously saved state, given here in
 * <var>savedInstanceState</var>.  Most implementations will simply use {@link #onCreate}
 * to restore their state, but it is sometimes convenient to do it here
 * after all of the initialization has been done or to allow subclasses to
 * decide whether to use your default implementation.  The default
 * implementation of this method performs a restore of any view state that
 * had previously been frozen by {@link #onSaveInstanceState}.
 *
 * <p>This method is called between {@link #onStart} and
 * {@link #onPostCreate}. This method is called only when recreating
 * an activity; the method isn't invoked if {@link #onStart} is called for
 * any other reason.</p>
 *
 * @param savedInstanceState the data most recently supplied in {@link #onSaveInstanceState}.
 *
 * This value must never be {@code null}.
 * @see #onCreate
 * @see #onPostCreate
 * @see #onResume
 * @see #onSaveInstanceState
 * @apiSince 1
 */

protected void onRestoreInstanceState(@androidx.annotation.NonNull android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * This is the same as {@link #onRestoreInstanceState(android.os.Bundle)} but is called for activities
 * created with the attribute {@link android.R.attr#persistableMode} set to
 * <code>persistAcrossReboots</code>. The {@link android.os.PersistableBundle} passed
 * came from the restored PersistableBundle first
 * saved in {@link #onSaveInstanceState(android.os.Bundle,android.os.PersistableBundle)}.
 *
 * <p>This method is called between {@link #onStart} and
 * {@link #onPostCreate}.
 *
 * <p>If this method is called {@link #onRestoreInstanceState(android.os.Bundle)} will not be called.
 *
 * <p>At least one of {@code savedInstanceState} or {@code persistentState} will not be null.
 *
 * @param savedInstanceState the data most recently supplied in {@link #onSaveInstanceState}
 *     or null.
 * This value may be {@code null}.
 * @param persistentState the data most recently supplied in {@link #onSaveInstanceState}
 *     or null.
 *
 * This value may be {@code null}.
 * @see #onRestoreInstanceState(Bundle)
 * @see #onCreate
 * @see #onPostCreate
 * @see #onResume
 * @see #onSaveInstanceState
 * @apiSince 21
 */

public void onRestoreInstanceState(@androidx.annotation.Nullable android.os.Bundle savedInstanceState, @androidx.annotation.Nullable android.os.PersistableBundle persistentState) { throw new RuntimeException("Stub!"); }

/**
 * Called when activity start-up is complete (after {@link #onStart}
 * and {@link #onRestoreInstanceState} have been called).  Applications will
 * generally not implement this method; it is intended for system
 * classes to do final initialization after application code has run.
 *
 * <p><em>Derived classes must call through to the super class's
 * implementation of this method.  If they do not, an exception will be
 * thrown.</em></p>
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @param savedInstanceState If the activity is being re-initialized after
 *     previously being shut down then this Bundle contains the data it most
 *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
 * This value may be {@code null}.
 * @see #onCreate
 * @apiSince 1
 */

protected void onPostCreate(@androidx.annotation.Nullable android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * This is the same as {@link #onPostCreate(android.os.Bundle)} but is called for activities
 * created with the attribute {@link android.R.attr#persistableMode} set to
 * <code>persistAcrossReboots</code>.
 *
 * @param savedInstanceState The data most recently supplied in {@link #onSaveInstanceState}
 * This value may be {@code null}.
 * @param persistentState The data caming from the PersistableBundle first
 * saved in {@link #onSaveInstanceState(android.os.Bundle,android.os.PersistableBundle)}.
 *
 * This value may be {@code null}.
 * @see #onCreate
 * @apiSince 21
 */

public void onPostCreate(@androidx.annotation.Nullable android.os.Bundle savedInstanceState, @androidx.annotation.Nullable android.os.PersistableBundle persistentState) { throw new RuntimeException("Stub!"); }

/**
 * Called after {@link #onCreate} &mdash; or after {@link #onRestart} when
 * the activity had been stopped, but is now again being displayed to the
 * user. It will usually be followed by {@link #onResume}. This is a good place to begin
 * drawing visual elements, running animations, etc.
 *
 * <p>You can call {@link #finish} from within this function, in
 * which case {@link #onStop} will be immediately called after {@link #onStart} without the
 * lifecycle transitions in-between ({@link #onResume}, {@link #onPause}, etc) executing.
 *
 * <p><em>Derived classes must call through to the super class's
 * implementation of this method.  If they do not, an exception will be
 * thrown.</em></p>
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @see #onCreate
 * @see #onStop
 * @see #onResume
 * @apiSince 1
 */

protected void onStart() { throw new RuntimeException("Stub!"); }

/**
 * Called after {@link #onStop} when the current activity is being
 * re-displayed to the user (the user has navigated back to it).  It will
 * be followed by {@link #onStart} and then {@link #onResume}.
 *
 * <p>For activities that are using raw {@link android.database.Cursor Cursor} objects (instead of
 * creating them through
 * {@link #managedQuery(android.net.Uri,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String)},
 * this is usually the place
 * where the cursor should be requeried (because you had deactivated it in
 * {@link #onStop}.
 *
 * <p><em>Derived classes must call through to the super class's
 * implementation of this method.  If they do not, an exception will be
 * thrown.</em></p>
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @see #onStop
 * @see #onStart
 * @see #onResume
 * @apiSince 1
 */

protected void onRestart() { throw new RuntimeException("Stub!"); }

/**
 * Called when an {@link #onResume} is coming up, prior to other pre-resume callbacks
 * such as {@link #onNewIntent} and {@link #onActivityResult}.  This is primarily intended
 * to give the activity a hint that its state is no longer saved -- it will generally
 * be called after {@link #onSaveInstanceState} and prior to the activity being
 * resumed/started again.
 *
 * @deprecated starting with {@link android.os.Build.VERSION_CODES#P} onSaveInstanceState is
 * called after {@link #onStop}, so this hint isn't accurate anymore: you should consider your
 * state not saved in between {@code onStart} and {@code onStop} callbacks inclusively.
 * @apiSince 23
 * @deprecatedSince 29
 */

@Deprecated
public void onStateNotSaved() { throw new RuntimeException("Stub!"); }

/**
 * Called after {@link #onRestoreInstanceState}, {@link #onRestart}, or
 * {@link #onPause}, for your activity to start interacting with the user. This is an indicator
 * that the activity became active and ready to receive input. It is on top of an activity stack
 * and visible to user.
 *
 * <p>On platform versions prior to {@link android.os.Build.VERSION_CODES#Q} this is also a good
 * place to try to open exclusive-access devices or to get access to singleton resources.
 * Starting  with {@link android.os.Build.VERSION_CODES#Q} there can be multiple resumed
 * activities in the system simultaneously, so {@link #onTopResumedActivityChanged(boolean)}
 * should be used for that purpose instead.
 *
 * <p><em>Derived classes must call through to the super class's
 * implementation of this method.  If they do not, an exception will be
 * thrown.</em></p>
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @see #onRestoreInstanceState
 * @see #onRestart
 * @see #onPostResume
 * @see #onPause
 * @see #onTopResumedActivityChanged(boolean)
 * @apiSince 1
 */

protected void onResume() { throw new RuntimeException("Stub!"); }

/**
 * Called when activity resume is complete (after {@link #onResume} has
 * been called). Applications will generally not implement this method;
 * it is intended for system classes to do final setup after application
 * resume code has run.
 *
 * <p><em>Derived classes must call through to the super class's
 * implementation of this method.  If they do not, an exception will be
 * thrown.</em></p>
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @see #onResume
 * @apiSince 1
 */

protected void onPostResume() { throw new RuntimeException("Stub!"); }

/**
 * Called when activity gets or loses the top resumed position in the system.
 *
 * <p>Starting with {@link android.os.Build.VERSION_CODES#Q} multiple activities can be resumed
 * at the same time in multi-window and multi-display modes. This callback should be used
 * instead of {@link #onResume()} as an indication that the activity can try to open
 * exclusive-access devices like camera.</p>
 *
 * <p>It will always be delivered after the activity was resumed and before it is paused. In
 * some cases it might be skipped and activity can go straight from {@link #onResume()} to
 * {@link #onPause()} without receiving the top resumed state.</p>
 *
 * @param isTopResumedActivity {@code true} if it's the topmost resumed activity in the system,
 *                             {@code false} otherwise. A call with this as {@code true} will
 *                             always be followed by another one with {@code false}.
 *
 * @see #onResume()
 * @see #onPause()
 * @see #onWindowFocusChanged(boolean)
 * @apiSince 29
 */

public void onTopResumedActivityChanged(boolean isTopResumedActivity) { throw new RuntimeException("Stub!"); }

/**
 * Check whether this activity is running as part of a voice interaction with the user.
 * If true, it should perform its interaction with the user through the
 * {@link android.app.VoiceInteractor VoiceInteractor} returned by {@link #getVoiceInteractor}.
 * @apiSince 23
 */

public boolean isVoiceInteraction() { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #isVoiceInteraction}, but only returns true if this is also the root
 * of a voice interaction.  That is, returns true if this activity was directly
 * started by the voice interaction service as the initiation of a voice interaction.
 * Otherwise, for example if it was started by another activity while under voice
 * interaction, returns false.
 * @apiSince 23
 */

public boolean isVoiceInteractionRoot() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the active {@link android.app.VoiceInteractor VoiceInteractor} that the user is going through to
 * interact with this activity.
 * @apiSince 23
 */

public android.app.VoiceInteractor getVoiceInteractor() { throw new RuntimeException("Stub!"); }

/**
 * Queries whether the currently enabled voice interaction service supports returning
 * a voice interactor for use by the activity. This is valid only for the duration of the
 * activity.
 *
 * @return whether the current voice interaction service supports local voice interaction
 * @apiSince 24
 */

public boolean isLocalVoiceInteractionSupported() { throw new RuntimeException("Stub!"); }

/**
 * Starts a local voice interaction session. When ready,
 * {@link #onLocalVoiceInteractionStarted()} is called. You can pass a bundle of private options
 * to the registered voice interaction service.
 * @param privateOptions a Bundle of private arguments to the current voice interaction service
 * @apiSince 24
 */

public void startLocalVoiceInteraction(android.os.Bundle privateOptions) { throw new RuntimeException("Stub!"); }

/**
 * Callback to indicate that {@link #startLocalVoiceInteraction(android.os.Bundle)} has resulted in a
 * voice interaction session being started. You can now retrieve a voice interactor using
 * {@link #getVoiceInteractor()}.
 * @apiSince 24
 */

public void onLocalVoiceInteractionStarted() { throw new RuntimeException("Stub!"); }

/**
 * Callback to indicate that the local voice interaction has stopped either
 * because it was requested through a call to {@link #stopLocalVoiceInteraction()}
 * or because it was canceled by the user. The previously acquired {@link android.app.VoiceInteractor VoiceInteractor}
 * is no longer valid after this.
 * @apiSince 24
 */

public void onLocalVoiceInteractionStopped() { throw new RuntimeException("Stub!"); }

/**
 * Request to terminate the current voice interaction that was previously started
 * using {@link #startLocalVoiceInteraction(android.os.Bundle)}. When the interaction is
 * terminated, {@link #onLocalVoiceInteractionStopped()} will be called.
 * @apiSince 24
 */

public void stopLocalVoiceInteraction() { throw new RuntimeException("Stub!"); }

/**
 * This is called for activities that set launchMode to "singleTop" in
 * their package, or if a client used the {@link android.content.Intent#FLAG_ACTIVITY_SINGLE_TOP Intent#FLAG_ACTIVITY_SINGLE_TOP}
 * flag when calling {@link #startActivity}.  In either case, when the
 * activity is re-launched while at the top of the activity stack instead
 * of a new instance of the activity being started, onNewIntent() will be
 * called on the existing instance with the Intent that was used to
 * re-launch it.
 *
 * <p>An activity can never receive a new intent in the resumed state. You can count on
 * {@link #onResume} being called after this method, though not necessarily immediately after
 * the completion this callback. If the activity was resumed, it will be paused and new intent
 * will be delivered, followed by {@link #onResume}. If the activity wasn't in the resumed
 * state, then new intent can be delivered immediately, with {@link #onResume()} called
 * sometime later when activity becomes active again.
 *
 * <p>Note that {@link #getIntent} still returns the original Intent.  You
 * can use {@link #setIntent} to update it to this new Intent.
 *
 * @param intent The new intent that was started for the activity.
 *
 * @see #getIntent
 * @see #setIntent
 * @see #onResume
 * @apiSince 1
 */

protected void onNewIntent(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called to retrieve per-instance state from an activity before being killed
 * so that the state can be restored in {@link #onCreate} or
 * {@link #onRestoreInstanceState} (the {@link android.os.Bundle Bundle} populated by this method
 * will be passed to both).
 *
 * <p>This method is called before an activity may be killed so that when it
 * comes back some time in the future it can restore its state.  For example,
 * if activity B is launched in front of activity A, and at some point activity
 * A is killed to reclaim resources, activity A will have a chance to save the
 * current state of its user interface via this method so that when the user
 * returns to activity A, the state of the user interface can be restored
 * via {@link #onCreate} or {@link #onRestoreInstanceState}.
 *
 * <p>Do not confuse this method with activity lifecycle callbacks such as {@link #onPause},
 * which is always called when the user no longer actively interacts with an activity, or
 * {@link #onStop} which is called when activity becomes invisible. One example of when
 * {@link #onPause} and {@link #onStop} is called and not this method is when a user navigates
 * back from activity B to activity A: there is no need to call {@link #onSaveInstanceState}
 * on B because that particular instance will never be restored,
 * so the system avoids calling it.  An example when {@link #onPause} is called and
 * not {@link #onSaveInstanceState} is when activity B is launched in front of activity A:
 * the system may avoid calling {@link #onSaveInstanceState} on activity A if it isn't
 * killed during the lifetime of B since the state of the user interface of
 * A will stay intact.
 *
 * <p>The default implementation takes care of most of the UI per-instance
 * state for you by calling {@link android.view.View#onSaveInstanceState()} on each
 * view in the hierarchy that has an id, and by saving the id of the currently
 * focused view (all of which is restored by the default implementation of
 * {@link #onRestoreInstanceState}).  If you override this method to save additional
 * information not captured by each individual view, you will likely want to
 * call through to the default implementation, otherwise be prepared to save
 * all of the state of each view yourself.
 *
 * <p>If called, this method will occur after {@link #onStop} for applications
 * targeting platforms starting with {@link android.os.Build.VERSION_CODES#P}.
 * For applications targeting earlier platform versions this method will occur
 * before {@link #onStop} and there are no guarantees about whether it will
 * occur before or after {@link #onPause}.
 *
 * @param outState Bundle in which to place your saved state.
 *
 * This value must never be {@code null}.
 * @see #onCreate
 * @see #onRestoreInstanceState
 * @see #onPause
 * @apiSince 1
 */

protected void onSaveInstanceState(@androidx.annotation.NonNull android.os.Bundle outState) { throw new RuntimeException("Stub!"); }

/**
 * This is the same as {@link #onSaveInstanceState} but is called for activities
 * created with the attribute {@link android.R.attr#persistableMode} set to
 * <code>persistAcrossReboots</code>. The {@link android.os.PersistableBundle} passed
 * in will be saved and presented in {@link #onCreate(android.os.Bundle,android.os.PersistableBundle)}
 * the first time that this activity is restarted following the next device reboot.
 *
 * @param outState Bundle in which to place your saved state.
 * This value must never be {@code null}.
 * @param outPersistentState State which will be saved across reboots.
 *
 * This value must never be {@code null}.
 * @see #onSaveInstanceState(Bundle)
 * @see #onCreate
 * @see #onRestoreInstanceState(Bundle, PersistableBundle)
 * @see #onPause
 * @apiSince 21
 */

public void onSaveInstanceState(@androidx.annotation.NonNull android.os.Bundle outState, @androidx.annotation.NonNull android.os.PersistableBundle outPersistentState) { throw new RuntimeException("Stub!"); }

/**
 * Called as part of the activity lifecycle when the user no longer actively interacts with the
 * activity, but it is still visible on screen. The counterpart to {@link #onResume}.
 *
 * <p>When activity B is launched in front of activity A, this callback will
 * be invoked on A.  B will not be created until A's {@link #onPause} returns,
 * so be sure to not do anything lengthy here.
 *
 * <p>This callback is mostly used for saving any persistent state the
 * activity is editing, to present a "edit in place" model to the user and
 * making sure nothing is lost if there are not enough resources to start
 * the new activity without first killing this one.  This is also a good
 * place to stop things that consume a noticeable amount of CPU in order to
 * make the switch to the next activity as fast as possible.
 *
 * <p>On platform versions prior to {@link android.os.Build.VERSION_CODES#Q} this is also a good
 * place to try to close exclusive-access devices or to release access to singleton resources.
 * Starting with {@link android.os.Build.VERSION_CODES#Q} there can be multiple resumed
 * activities in the system at the same time, so {@link #onTopResumedActivityChanged(boolean)}
 * should be used for that purpose instead.
 *
 * <p>If an activity is launched on top, after receiving this call you will usually receive a
 * following call to {@link #onStop} (after the next activity has been resumed and displayed
 * above). However in some cases there will be a direct call back to {@link #onResume} without
 * going through the stopped state. An activity can also rest in paused state in some cases when
 * in multi-window mode, still visible to user.
 *
 * <p><em>Derived classes must call through to the super class's
 * implementation of this method.  If they do not, an exception will be
 * thrown.</em></p>
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @see #onResume
 * @see #onSaveInstanceState
 * @see #onStop
 * @apiSince 1
 */

protected void onPause() { throw new RuntimeException("Stub!"); }

/**
 * Called as part of the activity lifecycle when an activity is about to go
 * into the background as the result of user choice.  For example, when the
 * user presses the Home key, {@link #onUserLeaveHint} will be called, but
 * when an incoming phone call causes the in-call Activity to be automatically
 * brought to the foreground, {@link #onUserLeaveHint} will not be called on
 * the activity being interrupted.  In cases when it is invoked, this method
 * is called right before the activity's {@link #onPause} callback.
 *
 * <p>This callback and {@link #onUserInteraction} are intended to help
 * activities manage status bar notifications intelligently; specifically,
 * for helping activities determine the proper time to cancel a notification.
 *
 * @see #onUserInteraction()
 * @see android.content.Intent#FLAG_ACTIVITY_NO_USER_ACTION
 * @apiSince 3
 */

protected void onUserLeaveHint() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Method doesn't do anything and will be removed in the future.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
public boolean onCreateThumbnail(android.graphics.Bitmap outBitmap, android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Generate a new description for this activity.  This method is called
 * before stopping the activity and can, if desired, return some textual
 * description of its current state to be displayed to the user.
 *
 * <p>The default implementation returns null, which will cause you to
 * inherit the description from the previous activity.  If all activities
 * return null, generally the label of the top activity will be used as the
 * description.
 *
 * @return A description of what the user is doing.  It should be short and
 *         sweet (only a few words).
 *
 * @see #onSaveInstanceState
 * @see #onStop
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.CharSequence onCreateDescription() { throw new RuntimeException("Stub!"); }

/**
 * This is called when the user is requesting an assist, to build a full
 * {@link android.content.Intent#ACTION_ASSIST Intent#ACTION_ASSIST} Intent with all of the context of the current
 * application.  You can override this method to place into the bundle anything
 * you would like to appear in the {@link android.content.Intent#EXTRA_ASSIST_CONTEXT Intent#EXTRA_ASSIST_CONTEXT} part
 * of the assist Intent.
 *
 * <p>This function will be called after any global assist callbacks that had
 * been registered with {@link android.app.Application#registerOnProvideAssistDataListener Application#registerOnProvideAssistDataListener}.
 * @apiSince 18
 */

public void onProvideAssistData(android.os.Bundle data) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the user is requesting an assist, to provide references
 * to content related to the current activity.  Before being called, the
 * {@code outContent} Intent is filled with the base Intent of the activity (the Intent
 * returned by {@link #getIntent()}).  The Intent's extras are stripped of any types
 * that are not valid for {@link android.os.PersistableBundle PersistableBundle} or non-framework Parcelables, and
 * the flags {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION Intent#FLAG_GRANT_WRITE_URI_PERMISSION} and
 * {@link android.content.Intent#FLAG_GRANT_PERSISTABLE_URI_PERMISSION Intent#FLAG_GRANT_PERSISTABLE_URI_PERMISSION} are cleared from the Intent.
 *
 * <p>Custom implementation may adjust the content intent to better reflect the top-level
 * context of the activity, and fill in its ClipData with additional content of
 * interest that the user is currently viewing.  For example, an image gallery application
 * that has launched in to an activity allowing the user to swipe through pictures should
 * modify the intent to reference the current image they are looking it; such an
 * application when showing a list of pictures should add a ClipData that has
 * references to all of the pictures currently visible on screen.</p>
 *
 * @param outContent The assist content to return.
 * @apiSince 23
 */

public void onProvideAssistContent(android.app.assist.AssistContent outContent) { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of direct actions supported by the app.
 *
 * <p>You should return the list of actions that could be executed in the
 * current context, which is in the current state of the app. If the actions
 * that could be executed by the app changes you should report that via
 * calling {@link android.app.VoiceInteractor#notifyDirectActionsChanged() VoiceInteractor#notifyDirectActionsChanged()}.
 *
 * <p>To get the voice interactor you need to call {@link #getVoiceInteractor()}
 * which would return non <code>null</code> only if there is an ongoing voice
 * interaction session. You an also detect when the voice interactor is no
 * longer valid because the voice interaction session that is backing is finished
 * by calling {@link android.app.VoiceInteractor#registerOnDestroyedCallback(java.util.concurrent.Executor,java.lang.Runnable) VoiceInteractor#registerOnDestroyedCallback(Executor, Runnable)}.
 *
 * <p>This method will be called only after {@link #onStart()} is being called and
 * before {@link #onStop()} is being called.
 *
 * <p>You should pass to the callback the currently supported direct actions which
 * cannot be <code>null</code> or contain <code>null</code> elements.
 *
 * <p>You should return the action list as soon as possible to ensure the consumer,
 * for example the assistant, is as responsive as possible which would improve user
 * experience of your app.
 *
 * @param cancellationSignal A signal to cancel the operation in progress.
 * This value must never be {@code null}.
 * @param callback The callback to send the action list. The actions list cannot
 *     contain <code>null</code> elements. You can call this on any thread.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void onGetDirectActions(@androidx.annotation.NonNull android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull java.util.function.Consumer<java.util.List<android.app.DirectAction>> callback) { throw new RuntimeException("Stub!"); }

/**
 * This is called to perform an action previously defined by the app.
 * Apps also have access to {@link #getVoiceInteractor()} to follow up on the action.
 *
 * @param actionId The ID for the action you previously reported via
 *     {@link #onGetDirectActions(android.os.CancellationSignal,java.util.function.Consumer)}.
 * This value must never be {@code null}.
 * @param arguments Any additional arguments provided by the caller that are
 *     specific to the given action.
 * This value must never be {@code null}.
 * @param cancellationSignal A signal to cancel the operation in progress.
 * This value must never be {@code null}.
 * @param resultListener The callback to provide the result back to the caller.
 *     You can call this on any thread. The result bundle is action specific.
 *
 * This value must never be {@code null}.
 * @see #onGetDirectActions(CancellationSignal, Consumer)
 * @apiSince 29
 */

public void onPerformDirectAction(@androidx.annotation.NonNull java.lang.String actionId, @androidx.annotation.NonNull android.os.Bundle arguments, @androidx.annotation.NonNull android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull java.util.function.Consumer<android.os.Bundle> resultListener) { throw new RuntimeException("Stub!"); }

/**
 * Request the Keyboard Shortcuts screen to show up. This will trigger
 * {@link #onProvideKeyboardShortcuts} to retrieve the shortcuts for the foreground activity.
 * @apiSince 24
 */

public final void requestShowKeyboardShortcuts() { throw new RuntimeException("Stub!"); }

/**
 * Dismiss the Keyboard Shortcuts screen.
 * @apiSince 24
 */

public final void dismissKeyboardShortcutsHelper() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void onProvideKeyboardShortcuts(java.util.List<android.view.KeyboardShortcutGroup> data, android.view.Menu menu, int deviceId) { throw new RuntimeException("Stub!"); }

/**
 * Ask to have the current assistant shown to the user.  This only works if the calling
 * activity is the current foreground activity.  It is the same as calling
 * {@link android.service.voice.VoiceInteractionService#showSession
 * VoiceInteractionService.showSession} and requesting all of the possible context.
 * The receiver will always see
 * {@link android.service.voice.VoiceInteractionSession#SHOW_SOURCE_APPLICATION} set.
 * @return Returns true if the assistant was successfully invoked, else false.  For example
 * false will be returned if the caller is not the current top activity.
 * @apiSince 23
 */

public boolean showAssist(android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Called when you are no longer visible to the user.  You will next
 * receive either {@link #onRestart}, {@link #onDestroy}, or nothing,
 * depending on later user activity. This is a good place to stop
 * refreshing UI, running animations and other visual things.
 *
 * <p><em>Derived classes must call through to the super class's
 * implementation of this method.  If they do not, an exception will be
 * thrown.</em></p>
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @see #onRestart
 * @see #onResume
 * @see #onSaveInstanceState
 * @see #onDestroy
 * @apiSince 1
 */

protected void onStop() { throw new RuntimeException("Stub!"); }

/**
 * Perform any final cleanup before an activity is destroyed.  This can
 * happen either because the activity is finishing (someone called
 * {@link #finish} on it), or because the system is temporarily destroying
 * this instance of the activity to save space.  You can distinguish
 * between these two scenarios with the {@link #isFinishing} method.
 *
 * <p><em>Note: do not count on this method being called as a place for
 * saving data! For example, if an activity is editing data in a content
 * provider, those edits should be committed in either {@link #onPause} or
 * {@link #onSaveInstanceState}, not here.</em> This method is usually implemented to
 * free resources like threads that are associated with an activity, so
 * that a destroyed activity does not leave such things around while the
 * rest of its application is still running.  There are situations where
 * the system will simply kill the activity's hosting process without
 * calling this method (or any others) in it, so it should not be used to
 * do things that are intended to remain around after the process goes
 * away.
 *
 * <p><em>Derived classes must call through to the super class's
 * implementation of this method.  If they do not, an exception will be
 * thrown.</em></p>
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @see #onPause
 * @see #onStop
 * @see #finish
 * @see #isFinishing
 * @apiSince 1
 */

protected void onDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Report to the system that your app is now fully drawn, purely for diagnostic
 * purposes (calling it does not impact the visible behavior of the activity).
 * This is only used to help instrument application launch times, so that the
 * app can report when it is fully in a usable state; without this, the only thing
 * the system itself can determine is the point at which the activity's window
 * is <em>first</em> drawn and displayed.  To participate in app launch time
 * measurement, you should always call this method after first launch (when
 * {@link #onCreate(android.os.Bundle)} is called), at the point where you have
 * entirely drawn your UI and populated with all of the significant data.  You
 * can safely call this method any time after first launch as well, in which case
 * it will simply be ignored.
 * @apiSince 19
 */

public void reportFullyDrawn() { throw new RuntimeException("Stub!"); }

/**
 * Called by the system when the activity changes from fullscreen mode to multi-window mode and
 * visa-versa. This method provides the same configuration that will be sent in the following
 * {@link #onConfigurationChanged(android.content.res.Configuration)} call after the activity enters this mode.
 *
 * @see android.R.attr#resizeableActivity
 *
 * @param isInMultiWindowMode True if the activity is in multi-window mode.
 * @param newConfig The new configuration of the activity with the state
 *                  {@param isInMultiWindowMode}.
 * @apiSince 26
 */

public void onMultiWindowModeChanged(boolean isInMultiWindowMode, android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * Called by the system when the activity changes from fullscreen mode to multi-window mode and
 * visa-versa.
 *
 * @see android.R.attr#resizeableActivity
 *
 * @param isInMultiWindowMode True if the activity is in multi-window mode.
 *
 * @deprecated Use {@link #onMultiWindowModeChanged(boolean,android.content.res.Configuration)} instead.
 * @apiSince 24
 * @deprecatedSince 26
 */

@Deprecated
public void onMultiWindowModeChanged(boolean isInMultiWindowMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the activity is currently in multi-window mode.
 * @see android.R.attr#resizeableActivity
 *
 * @return True if the activity is in multi-window mode.
 * @apiSince 24
 */

public boolean isInMultiWindowMode() { throw new RuntimeException("Stub!"); }

/**
 * Called by the system when the activity changes to and from picture-in-picture mode. This
 * method provides the same configuration that will be sent in the following
 * {@link #onConfigurationChanged(android.content.res.Configuration)} call after the activity enters this mode.
 *
 * @see android.R.attr#supportsPictureInPicture
 *
 * @param isInPictureInPictureMode True if the activity is in picture-in-picture mode.
 * @param newConfig The new configuration of the activity with the state
 *                  {@param isInPictureInPictureMode}.
 * @apiSince 26
 */

public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * Called by the system when the activity changes to and from picture-in-picture mode.
 *
 * @see android.R.attr#supportsPictureInPicture
 *
 * @param isInPictureInPictureMode True if the activity is in picture-in-picture mode.
 *
 * @deprecated Use {@link #onPictureInPictureModeChanged(boolean,android.content.res.Configuration)} instead.
 * @apiSince 24
 * @deprecatedSince 26
 */

@Deprecated
public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the activity is currently in picture-in-picture mode.
 * @see android.R.attr#supportsPictureInPicture
 *
 * @return True if the activity is in picture-in-picture mode.
 * @apiSince 24
 */

public boolean isInPictureInPictureMode() { throw new RuntimeException("Stub!"); }

/**
 * Puts the activity in picture-in-picture mode if possible in the current system state. Any
 * prior calls to {@link #setPictureInPictureParams(android.app.PictureInPictureParams)} will still apply
 * when entering picture-in-picture through this call.
 *
 * @see #enterPictureInPictureMode(PictureInPictureParams)
 * @see android.R.attr#supportsPictureInPicture
 * @apiSince 24
 * @deprecatedSince 26
 */

@Deprecated
public void enterPictureInPictureMode() { throw new RuntimeException("Stub!"); }

/**
 * Puts the activity in picture-in-picture mode if possible in the current system state. The
 * set parameters in {@param params} will be combined with the parameters from prior calls to
 * {@link #setPictureInPictureParams(android.app.PictureInPictureParams)}.
 *
 * The system may disallow entering picture-in-picture in various cases, including when the
 * activity is not visible, if the screen is locked or if the user has an activity pinned.
 *
 * @see android.R.attr#supportsPictureInPicture
 * @see android.app.PictureInPictureParams
 *
 * @param params non-null parameters to be combined with previously set parameters when entering
 * picture-in-picture.
 *
 * This value must never be {@code null}.
 * @return true if the system successfully put this activity into picture-in-picture mode or was
 * already in picture-in-picture mode (see {@link #isInPictureInPictureMode()}). If the device
 * does not support picture-in-picture, return false.
 * @apiSince 26
 */

public boolean enterPictureInPictureMode(@androidx.annotation.NonNull android.app.PictureInPictureParams params) { throw new RuntimeException("Stub!"); }

/**
 * Updates the properties of the picture-in-picture activity, or sets it to be used later when
 * {@link #enterPictureInPictureMode()} is called.
 *
 * @param params the new parameters for the picture-in-picture.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void setPictureInPictureParams(@androidx.annotation.NonNull android.app.PictureInPictureParams params) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of actions that will be displayed in the picture-in-picture UI when the
 * user interacts with the activity currently in picture-in-picture mode. This number may change
 * if the global configuration changes (ie. if the device is plugged into an external display),
 * but will always be larger than three.
 * @apiSince 26
 */

public int getMaxNumPictureInPictureActions() { throw new RuntimeException("Stub!"); }

/**
 * Called by the system when the device configuration changes while your
 * activity is running.  Note that this will <em>only</em> be called if
 * you have selected configurations you would like to handle with the
 * {@link android.R.attr#configChanges} attribute in your manifest.  If
 * any configuration change occurs that is not selected to be reported
 * by that attribute, then instead of reporting it the system will stop
 * and restart the activity (to have it launched with the new
 * configuration).
 *
 * <p>At the time that this function has been called, your Resources
 * object will have been updated to return resource values matching the
 * new configuration.
 *
 * @param newConfig The new device configuration.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void onConfigurationChanged(@androidx.annotation.NonNull android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * If this activity is being destroyed because it can not handle a
 * configuration parameter being changed (and thus its
 * {@link #onConfigurationChanged(android.content.res.Configuration)} method is
 * <em>not</em> being called), then you can use this method to discover
 * the set of changes that have occurred while in the process of being
 * destroyed.  Note that there is no guarantee that these will be
 * accurate (other changes could have happened at any time), so you should
 * only use this as an optimization hint.
 *
 * @return Returns a bit field of the configuration parameters that are
 * changing, as defined by the {@link android.content.res.Configuration}
 * class.
 * @apiSince 1
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the non-configuration instance data that was previously
 * returned by {@link #onRetainNonConfigurationInstance()}.  This will
 * be available from the initial {@link #onCreate} and
 * {@link #onStart} calls to the new instance, allowing you to extract
 * any useful dynamic state from the previous instance.
 *
 * <p>Note that the data you retrieve here should <em>only</em> be used
 * as an optimization for handling configuration changes.  You should always
 * be able to handle getting a null pointer back, and an activity must
 * still be able to restore itself to its previous state (through the
 * normal {@link #onSaveInstanceState(android.os.Bundle)} mechanism) even if this
 * function returns null.
 *
 * <p><strong>Note:</strong> For most cases you should use the {@link android.app.Fragment Fragment} API
 * {@link android.app.Fragment#setRetainInstance(boolean) Fragment#setRetainInstance(boolean)} instead; this is also
 * available on older platforms through the Android support libraries.
 *
 * @return the object previously returned by {@link #onRetainNonConfigurationInstance()}
 * @apiSince 1
 * @deprecatedSince 15
 */

@androidx.annotation.Nullable
public java.lang.Object getLastNonConfigurationInstance() { throw new RuntimeException("Stub!"); }

/**
 * Called by the system, as part of destroying an
 * activity due to a configuration change, when it is known that a new
 * instance will immediately be created for the new configuration.  You
 * can return any object you like here, including the activity instance
 * itself, which can later be retrieved by calling
 * {@link #getLastNonConfigurationInstance()} in the new activity
 * instance.
 *
 * <em>If you are targeting {@link android.os.Build.VERSION_CODES#HONEYCOMB}
 * or later, consider instead using a {@link android.app.Fragment Fragment} with
 * {@link android.app.Fragment#setRetainInstance(boolean) Fragment#setRetainInstance(boolean)}.</em>
 *
 * <p>This function is called purely as an optimization, and you must
 * not rely on it being called.  When it is called, a number of guarantees
 * will be made to help optimize configuration switching:
 * <ul>
 * <li> The function will be called between {@link #onStop} and
 * {@link #onDestroy}.
 * <li> A new instance of the activity will <em>always</em> be immediately
 * created after this one's {@link #onDestroy()} is called.  In particular,
 * <em>no</em> messages will be dispatched during this time (when the returned
 * object does not have an activity to be associated with).
 * <li> The object you return here will <em>always</em> be available from
 * the {@link #getLastNonConfigurationInstance()} method of the following
 * activity instance as described there.
 * </ul>
 *
 * <p>These guarantees are designed so that an activity can use this API
 * to propagate extensive state from the old to new activity instance, from
 * loaded bitmaps, to network connections, to evenly actively running
 * threads.  Note that you should <em>not</em> propagate any data that
 * may change based on the configuration, including any data loaded from
 * resources such as strings, layouts, or drawables.
 *
 * <p>The guarantee of no message handling during the switch to the next
 * activity simplifies use with active objects.  For example if your retained
 * state is an {@link android.os.AsyncTask} you are guaranteed that its
 * call back functions (like {@link android.os.AsyncTask#onPostExecute}) will
 * not be called from the call here until you execute the next instance's
 * {@link #onCreate(android.os.Bundle)}.  (Note however that there is of course no such
 * guarantee for {@link android.os.AsyncTask#doInBackground} since that is
 * running in a separate thread.)
 *
 * <p><strong>Note:</strong> For most cases you should use the {@link android.app.Fragment Fragment} API
 * {@link android.app.Fragment#setRetainInstance(boolean) Fragment#setRetainInstance(boolean)} instead; this is also
 * available on older platforms through the Android support libraries.
 *
 * @return any Object holding the desired state to propagate to the
 *         next activity instance
 * @apiSince 1
 * @deprecatedSince 15
 */

public java.lang.Object onRetainNonConfigurationInstance() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onLowMemory() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public void onTrimMemory(int level) { throw new RuntimeException("Stub!"); }

/**
 * Return the FragmentManager for interacting with fragments associated
 * with this activity.
 *
 * @deprecated Use {@link android.support.v4.app.FragmentActivity#getSupportFragmentManager()}
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public android.app.FragmentManager getFragmentManager() { throw new RuntimeException("Stub!"); }

/**
 * Called when a Fragment is being attached to this activity, immediately
 * after the call to its {@link android.app.Fragment#onAttach Fragment#onAttach}
 * method and before {@link android.app.Fragment#onCreate Fragment#onCreate}.
 *
 * @deprecated Use {@link
 * android.support.v4.app.FragmentActivity#onAttachFragment(android.support.v4.app.Fragment)}
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onAttachFragment(android.app.Fragment fragment) { throw new RuntimeException("Stub!"); }

/**
 * Wrapper around
 * {@link android.content.ContentResolver#query(android.net.Uri,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String) ContentResolver#query(android.net.Uri , String[], String, String[], String)}
 * that gives the resulting {@link android.database.Cursor Cursor} to call
 * {@link #startManagingCursor} so that the activity will manage its
 * lifecycle for you.
 *
 * <em>If you are targeting {@link android.os.Build.VERSION_CODES#HONEYCOMB}
 * or later, consider instead using {@link android.app.LoaderManager LoaderManager} instead, available
 * via {@link #getLoaderManager()}.</em>
 *
 * <p><strong>Warning:</strong> Do not call {@link android.database.Cursor#close() Cursor#close()} on a cursor obtained using
 * this method, because the activity will do that for you at the appropriate time. However, if
 * you call {@link #stopManagingCursor} on a cursor from a managed query, the system <em>will
 * not</em> automatically close the cursor and, in that case, you must call
 * {@link android.database.Cursor#close() Cursor#close()}.</p>
 *
 * @param uri The URI of the content provider to query.
 * @param projection List of columns to return.
 * @param selection SQL WHERE clause.
 * @param selectionArgs The arguments to selection, if any ?s are pesent
 * @param sortOrder SQL ORDER BY clause.
 *
 * @return The Cursor that was returned by query().
 *
 * @see android.content.ContentResolver#query(android.net.Uri , String[], String, String[], String)
 * @see #startManagingCursor
 *
 * @deprecated Use {@link android.content.CursorLoader CursorLoader} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public final android.database.Cursor managedQuery(android.net.Uri uri, java.lang.String[] projection, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String sortOrder) { throw new RuntimeException("Stub!"); }

/**
 * This method allows the activity to take care of managing the given
 * {@link android.database.Cursor Cursor}'s lifecycle for you based on the activity's lifecycle.
 * That is, when the activity is stopped it will automatically call
 * {@link android.database.Cursor#deactivate Cursor#deactivate} on the given Cursor, and when it is later restarted
 * it will call {@link android.database.Cursor#requery Cursor#requery} for you.  When the activity is
 * destroyed, all managed Cursors will be closed automatically.
 *
 * <em>If you are targeting {@link android.os.Build.VERSION_CODES#HONEYCOMB}
 * or later, consider instead using {@link android.app.LoaderManager LoaderManager} instead, available
 * via {@link #getLoaderManager()}.</em>
 *
 * <p><strong>Warning:</strong> Do not call {@link android.database.Cursor#close() Cursor#close()} on cursor obtained from
 * {@link #managedQuery}, because the activity will do that for you at the appropriate time.
 * However, if you call {@link #stopManagingCursor} on a cursor from a managed query, the system
 * <em>will not</em> automatically close the cursor and, in that case, you must call
 * {@link android.database.Cursor#close() Cursor#close()}.</p>
 *
 * @param c The Cursor to be managed.
 *
 * @see #managedQuery(android.net.Uri , String[], String, String[], String)
 * @see #stopManagingCursor
 *
 * @deprecated Use the new {@link android.content.CursorLoader} class with
 * {@link android.app.LoaderManager LoaderManager} instead; this is also
 * available on older platforms through the Android compatibility package.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void startManagingCursor(android.database.Cursor c) { throw new RuntimeException("Stub!"); }

/**
 * Given a Cursor that was previously given to
 * {@link #startManagingCursor}, stop the activity's management of that
 * cursor.
 *
 * <p><strong>Warning:</strong> After calling this method on a cursor from a managed query,
 * the system <em>will not</em> automatically close the cursor and you must call
 * {@link android.database.Cursor#close() Cursor#close()}.</p>
 *
 * @param c The Cursor that was being managed.
 *
 * @see #startManagingCursor
 *
 * @deprecated Use the new {@link android.content.CursorLoader} class with
 * {@link android.app.LoaderManager LoaderManager} instead; this is also
 * available on older platforms through the Android compatibility package.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void stopManagingCursor(android.database.Cursor c) { throw new RuntimeException("Stub!"); }

/**
 * Finds a view that was identified by the {@code android:id} XML attribute
 * that was processed in {@link #onCreate}.
 * <p>
 * <strong>Note:</strong> In most cases -- depending on compiler support --
 * the resulting view is automatically cast to the target class type. If
 * the target class type is unconstrained, an explicit cast may be
 * necessary.
 *
 * @param id the ID to search for
 * @return a view with given ID if found, or {@code null} otherwise
 * @see android.view.View#findViewById(int)
 * @see android.app.Activity#requireViewById(int)
 * @apiSince 1
 */

public <T extends android.view.View> T findViewById(int id) { throw new RuntimeException("Stub!"); }

/**
 * Finds a view that was  identified by the {@code android:id} XML attribute that was processed
 * in {@link #onCreate}, or throws an IllegalArgumentException if the ID is invalid, or there is
 * no matching view in the hierarchy.
 * <p>
 * <strong>Note:</strong> In most cases -- depending on compiler support --
 * the resulting view is automatically cast to the target class type. If
 * the target class type is unconstrained, an explicit cast may be
 * necessary.
 *
 * @param id the ID to search for
 * @return a view with given ID
 * This value will never be {@code null}.
 * @see android.view.View#requireViewById(int)
 * @see android.app.Activity#findViewById(int)
 * @apiSince 28
 */

@androidx.annotation.NonNull
public final <T extends android.view.View> T requireViewById(int id) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a reference to this activity's ActionBar.
 *
 * @return The Activity's ActionBar, or null if it does not have one.
 * @apiSince 11
 */

@androidx.annotation.Nullable
public android.app.ActionBar getActionBar() { throw new RuntimeException("Stub!"); }

/**
 * Set a {@link android.widget.Toolbar Toolbar} to act as the {@link android.app.ActionBar ActionBar} for this
 * Activity window.
 *
 * <p>When set to a non-null value the {@link #getActionBar()} method will return
 * an {@link android.app.ActionBar ActionBar} object that can be used to control the given toolbar as if it were
 * a traditional window decor action bar. The toolbar's menu will be populated with the
 * Activity's options menu and the navigation button will be wired through the standard
 * {@link android.R.id#home home} menu select action.</p>
 *
 * <p>In order to use a Toolbar within the Activity's window content the application
 * must not request the window feature {@link android.view.Window#FEATURE_ACTION_BAR Window#FEATURE_ACTION_BAR}.</p>
 *
 * @param toolbar Toolbar to set as the Activity's action bar, or {@code null} to clear it
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void setActionBar(@androidx.annotation.Nullable android.widget.Toolbar toolbar) { throw new RuntimeException("Stub!"); }

/**
 * Set the activity content from a layout resource.  The resource will be
 * inflated, adding all top-level views to the activity.
 *
 * @param layoutResID Resource ID to be inflated.
 *
 * @see #setContentView(android.view.View)
 * @see #setContentView(android.view.View, android.view.ViewGroup.LayoutParams)
 * @apiSince 1
 */

public void setContentView(int layoutResID) { throw new RuntimeException("Stub!"); }

/**
 * Set the activity content to an explicit view.  This view is placed
 * directly into the activity's view hierarchy.  It can itself be a complex
 * view hierarchy.  When calling this method, the layout parameters of the
 * specified view are ignored.  Both the width and the height of the view are
 * set by default to {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT ViewGroup.LayoutParams#MATCH_PARENT}. To use
 * your own layout parameters, invoke
 * {@link #setContentView(android.view.View,android.view.ViewGroup.LayoutParams)}
 * instead.
 *
 * @param view The desired content to display.
 *
 * @see #setContentView(int)
 * @see #setContentView(android.view.View, android.view.ViewGroup.LayoutParams)
 * @apiSince 1
 */

public void setContentView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Set the activity content to an explicit view.  This view is placed
 * directly into the activity's view hierarchy.  It can itself be a complex
 * view hierarchy.
 *
 * @param view The desired content to display.
 * @param params Layout parameters for the view.
 *
 * @see #setContentView(android.view.View)
 * @see #setContentView(int)
 * @apiSince 1
 */

public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * Add an additional content view to the activity.  Added after any existing
 * ones in the activity -- existing views are NOT removed.
 *
 * @param view The desired content to display.
 * @param params Layout parameters for the view.
 * @apiSince 1
 */

public void addContentView(android.view.View view, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the {@link android.transition.TransitionManager TransitionManager} responsible for default transitions in this window.
 * Requires {@link android.view.Window#FEATURE_CONTENT_TRANSITIONS Window#FEATURE_CONTENT_TRANSITIONS}.
 *
 * <p>This method will return non-null after content has been initialized (e.g. by using
 * {@link #setContentView}) if {@link android.view.Window#FEATURE_CONTENT_TRANSITIONS Window#FEATURE_CONTENT_TRANSITIONS} has been granted.</p>
 *
 * @return This window's content TransitionManager or null if none is set.
 * @apiSince 21
 */

public android.transition.TransitionManager getContentTransitionManager() { throw new RuntimeException("Stub!"); }

/**
 * Set the {@link android.transition.TransitionManager TransitionManager} to use for default transitions in this window.
 * Requires {@link android.view.Window#FEATURE_CONTENT_TRANSITIONS Window#FEATURE_CONTENT_TRANSITIONS}.
 *
 * @param tm The TransitionManager to use for scene changes.
 * @apiSince 21
 */

public void setContentTransitionManager(android.transition.TransitionManager tm) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the {@link android.transition.Scene Scene} representing this window's current content.
 * Requires {@link android.view.Window#FEATURE_CONTENT_TRANSITIONS Window#FEATURE_CONTENT_TRANSITIONS}.
 *
 * <p>This method will return null if the current content is not represented by a Scene.</p>
 *
 * @return Current Scene being shown or null
 * @apiSince 21
 */

public android.transition.Scene getContentScene() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this activity is finished when touched outside its window's
 * bounds.
 * @apiSince 11
 */

public void setFinishOnTouchOutside(boolean finish) { throw new RuntimeException("Stub!"); }

/**
 * Select the default key handling for this activity.  This controls what
 * will happen to key events that are not otherwise handled.  The default
 * mode ({@link #DEFAULT_KEYS_DISABLE}) will simply drop them on the
 * floor. Other modes allow you to launch the dialer
 * ({@link #DEFAULT_KEYS_DIALER}), execute a shortcut in your options
 * menu without requiring the menu key be held down
 * ({@link #DEFAULT_KEYS_SHORTCUT}), or launch a search ({@link #DEFAULT_KEYS_SEARCH_LOCAL}
 * and {@link #DEFAULT_KEYS_SEARCH_GLOBAL}).
 *
 * <p>Note that the mode selected here does not impact the default
 * handling of system keys, such as the "back" and "menu" keys, and your
 * activity and its views always get a first chance to receive and handle
 * all application keys.
 *
 * @param mode The desired default key mode constant.
 *
 * Value is {@link android.app.Activity#DEFAULT_KEYS_DISABLE}, {@link android.app.Activity#DEFAULT_KEYS_DIALER}, {@link android.app.Activity#DEFAULT_KEYS_SHORTCUT}, {@link android.app.Activity#DEFAULT_KEYS_SEARCH_LOCAL}, or {@link android.app.Activity#DEFAULT_KEYS_SEARCH_GLOBAL}
 * @see #onKeyDown
 * @apiSince 1
 */

public final void setDefaultKeyMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Called when a key was pressed down and not handled by any of the views
 * inside of the activity. So, for example, key presses while the cursor
 * is inside a TextView will not trigger the event (unless it is a navigation
 * to another object) because TextView handles its own key presses.
 *
 * <p>If the focused view didn't want this event, this method is called.
 *
 * <p>The default implementation takes care of {@link android.view.KeyEvent#KEYCODE_BACK KeyEvent#KEYCODE_BACK}
 * by calling {@link #onBackPressed()}, though the behavior varies based
 * on the application compatibility mode: for
 * {@link android.os.Build.VERSION_CODES#ECLAIR} or later applications,
 * it will set up the dispatch to call {@link #onKeyUp} where the action
 * will be performed; for earlier applications, it will perform the
 * action immediately in on-down, as those versions of the platform
 * behaved.
 *
 * <p>Other additional default key handling may be performed
 * if configured with {@link #setDefaultKeyMode}.
 *
 * @return Return <code>true</code> to prevent this event from being propagated
 * further, or <code>false</code> to indicate that you have not handled
 * this event and it should continue to be propagated.
 * @see #onKeyUp
 * @see android.view.KeyEvent
 * @apiSince 1
 */

public boolean onKeyDown(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of {@link android.view.KeyEvent.Callback#onKeyLongPress(int,android.view.KeyEvent) KeyEvent.Callback#onKeyLongPress(int, KeyEvent)}: always returns false (doesn't handle
 * the event).
 *
 * To receive this callback, you must return true from onKeyDown for the current
 * event stream.
 *
 * @see KeyEvent.Callback#onKeyLongPress()
 * @see android.view.KeyEvent.Callback#onKeyLongPress(int, KeyEvent)
 * @apiSince 5
 */

public boolean onKeyLongPress(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called when a key was released and not handled by any of the views
 * inside of the activity. So, for example, key presses while the cursor
 * is inside a TextView will not trigger the event (unless it is a navigation
 * to another object) because TextView handles its own key presses.
 *
 * <p>The default implementation handles KEYCODE_BACK to stop the activity
 * and go back.
 *
 * @return Return <code>true</code> to prevent this event from being propagated
 * further, or <code>false</code> to indicate that you have not handled
 * this event and it should continue to be propagated.
 * @see #onKeyDown
 * @see android.view.KeyEvent
 * @apiSince 1
 */

public boolean onKeyUp(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of {@link android.view.KeyEvent.Callback#onKeyMultiple(int,int,android.view.KeyEvent) KeyEvent.Callback#onKeyMultiple(int, int, KeyEvent)}: always returns false (doesn't handle
 * the event).
 * @apiSince 1
 */

public boolean onKeyMultiple(int keyCode, int repeatCount, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called when the activity has detected the user's press of the back
 * key.  The default implementation simply finishes the current activity,
 * but you can override this to do whatever you want.
 * @apiSince 5
 */

public void onBackPressed() { throw new RuntimeException("Stub!"); }

/**
 * Called when a key shortcut event is not handled by any of the views in the Activity.
 * Override this method to implement global key shortcuts for the Activity.
 * Key shortcuts can also be implemented by setting the
 * {@link android.view.MenuItem#setShortcut(char,char) MenuItem#setShortcut(char, char)} property of menu items.
 *
 * @param keyCode The value in event.getKeyCode().
 * @param event Description of the key event.
 * @return True if the key shortcut was handled.
 * @apiSince 11
 */

public boolean onKeyShortcut(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called when a touch screen event was not handled by any of the views
 * under it.  This is most useful to process touch events that happen
 * outside of your window bounds, where there is no view to receive it.
 *
 * @param event The touch screen event being processed.
 *
 * @return Return true if you have consumed the event, false if you haven't.
 * The default implementation always returns false.
 * @apiSince 1
 */

public boolean onTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called when the trackball was moved and not handled by any of the
 * views inside of the activity.  So, for example, if the trackball moves
 * while focus is on a button, you will receive a call here because
 * buttons do not normally do anything with trackball events.  The call
 * here happens <em>before</em> trackball movements are converted to
 * DPAD key events, which then get sent back to the view hierarchy, and
 * will be processed at the point for things like focus navigation.
 *
 * @param event The trackball event being processed.
 *
 * @return Return true if you have consumed the event, false if you haven't.
 * The default implementation always returns false.
 * @apiSince 1
 */

public boolean onTrackballEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called when a generic motion event was not handled by any of the
 * views inside of the activity.
 * <p>
 * Generic motion events describe joystick movements, mouse hovers, track pad
 * touches, scroll wheel movements and other input events.  The
 * {@link android.view.MotionEvent#getSource() MotionEvent#getSource()} of the motion event specifies
 * the class of input that was received.  Implementations of this method
 * must examine the bits in the source before processing the event.
 * The following code example shows how this is done.
 * </p><p>
 * Generic motion events with source class
 * {@link android.view.InputDevice#SOURCE_CLASS_POINTER}
 * are delivered to the view under the pointer.  All other generic motion events are
 * delivered to the focused view.
 * </p><p>
 * See {@link android.view.View#onGenericMotionEvent(android.view.MotionEvent) View#onGenericMotionEvent(MotionEvent)} for an example of how to
 * handle this event.
 * </p>
 *
 * @param event The generic motion event being processed.
 *
 * @return Return true if you have consumed the event, false if you haven't.
 * The default implementation always returns false.
 * @apiSince 12
 */

public boolean onGenericMotionEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called whenever a key, touch, or trackball event is dispatched to the
 * activity.  Implement this method if you wish to know that the user has
 * interacted with the device in some way while your activity is running.
 * This callback and {@link #onUserLeaveHint} are intended to help
 * activities manage status bar notifications intelligently; specifically,
 * for helping activities determine the proper time to cancel a notification.
 *
 * <p>All calls to your activity's {@link #onUserLeaveHint} callback will
 * be accompanied by calls to {@link #onUserInteraction}.  This
 * ensures that your activity will be told of relevant user activity such
 * as pulling down the notification pane and touching an item there.
 *
 * <p>Note that this callback will be invoked for the touch down action
 * that begins a touch gesture, but may not be invoked for the touch-moved
 * and touch-up actions that follow.
 *
 * @see #onUserLeaveHint()
 * @apiSince 3
 */

public void onUserInteraction() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams params) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onContentChanged() { throw new RuntimeException("Stub!"); }

/**
 * Called when the current {@link android.view.Window Window} of the activity gains or loses
 * focus. This is the best indicator of whether this activity is the entity
 * with which the user actively interacts. The default implementation
 * clears the key tracking state, so should always be called.
 *
 * <p>Note that this provides information about global focus state, which
 * is managed independently of activity lifecycle.  As such, while focus
 * changes will generally have some relation to lifecycle changes (an
 * activity that is stopped will not generally get window focus), you
 * should not rely on any particular order between the callbacks here and
 * those in the other lifecycle methods such as {@link #onResume}.
 *
 * <p>As a general rule, however, a foreground activity will have window
 * focus...  unless it has displayed other dialogs or popups that take
 * input focus, in which case the activity itself will not have focus
 * when the other windows have it.  Likewise, the system may display
 * system-level windows (such as the status bar notification panel or
 * a system alert) which will temporarily take window input focus without
 * pausing the foreground activity.
 *
 * <p>Starting with {@link android.os.Build.VERSION_CODES#Q} there can be
 * multiple resumed activities at the same time in multi-window mode, so
 * resumed state does not guarantee window focus even if there are no
 * overlays above.
 *
 * <p>If the intent is to know when an activity is the topmost active, the
 * one the user interacted with last among all activities but not including
 * non-activity windows like dialogs and popups, then
 * {@link #onTopResumedActivityChanged(boolean)} should be used. On platform
 * versions prior to {@link android.os.Build.VERSION_CODES#Q},
 * {@link #onResume} is the best indicator.
 *
 * @param hasFocus Whether the window of this activity has focus.
 *
 * @see #hasWindowFocus()
 * @see #onResume
 * @see android.view.View#onWindowFocusChanged(boolean)
 * @see #onTopResumedActivityChanged(boolean)
 * @apiSince 1
 */

public void onWindowFocusChanged(boolean hasFocus) { throw new RuntimeException("Stub!"); }

/**
 * Called when the main window associated with the activity has been
 * attached to the window manager.
 * See {@link android.view.View#onAttachedToWindow() View#onAttachedToWindow()}
 * for more information.
 * @see android.view.View#onAttachedToWindow
 * @apiSince 5
 */

public void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/**
 * Called when the main window associated with the activity has been
 * detached from the window manager.
 * See {@link android.view.View#onDetachedFromWindow() View#onDetachedFromWindow()}
 * for more information.
 * @see android.view.View#onDetachedFromWindow
 * @apiSince 5
 */

public void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this activity's <em>main</em> window currently has window focus.
 * Note that this is not the same as the view itself having focus.
 *
 * @return True if this activity's main window currently has window focus.
 *
 * @see #onWindowAttributesChanged(android.view.WindowManager.LayoutParams)
 * @apiSince 3
 */

public boolean hasWindowFocus() { throw new RuntimeException("Stub!"); }

/**
 * Called to process key events.  You can override this to intercept all
 * key events before they are dispatched to the window.  Be sure to call
 * this implementation for key events that should be handled normally.
 *
 * @param event The key event.
 *
 * @return boolean Return true if this event was consumed.
 * @apiSince 1
 */

public boolean dispatchKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called to process a key shortcut event.
 * You can override this to intercept all key shortcut events before they are
 * dispatched to the window.  Be sure to call this implementation for key shortcut
 * events that should be handled normally.
 *
 * @param event The key shortcut event.
 * @return True if this event was consumed.
 * @apiSince 11
 */

public boolean dispatchKeyShortcutEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called to process touch screen events.  You can override this to
 * intercept all touch screen events before they are dispatched to the
 * window.  Be sure to call this implementation for touch screen events
 * that should be handled normally.
 *
 * @param ev The touch screen event.
 *
 * @return boolean Return true if this event was consumed.
 * @apiSince 1
 */

public boolean dispatchTouchEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

/**
 * Called to process trackball events.  You can override this to
 * intercept all trackball events before they are dispatched to the
 * window.  Be sure to call this implementation for trackball events
 * that should be handled normally.
 *
 * @param ev The trackball event.
 *
 * @return boolean Return true if this event was consumed.
 * @apiSince 1
 */

public boolean dispatchTrackballEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

/**
 * Called to process generic motion events.  You can override this to
 * intercept all generic motion events before they are dispatched to the
 * window.  Be sure to call this implementation for generic motion events
 * that should be handled normally.
 *
 * @param ev The generic motion event.
 *
 * @return boolean Return true if this event was consumed.
 * @apiSince 12
 */

public boolean dispatchGenericMotionEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of
 * {@link android.view.Window.Callback#onCreatePanelView}
 * for activities. This
 * simply returns null so that all panel sub-windows will have the default
 * menu behavior.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.view.View onCreatePanelView(int featureId) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of
 * {@link android.view.Window.Callback#onCreatePanelMenu}
 * for activities.  This calls through to the new
 * {@link #onCreateOptionsMenu} method for the
 * {@link android.view.Window#FEATURE_OPTIONS_PANEL} panel,
 * so that subclasses of Activity don't need to deal with feature codes.
 
 * @param menu This value must never be {@code null}.
 * @apiSince 1
 */

public boolean onCreatePanelMenu(int featureId, @androidx.annotation.NonNull android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of
 * {@link android.view.Window.Callback#onPreparePanel}
 * for activities.  This
 * calls through to the new {@link #onPrepareOptionsMenu} method for the
 * {@link android.view.Window#FEATURE_OPTIONS_PANEL}
 * panel, so that subclasses of
 * Activity don't need to deal with feature codes.
 
 * @param view This value may be {@code null}.
 
 * @param menu This value must never be {@code null}.
 * @apiSince 1
 */

public boolean onPreparePanel(int featureId, @androidx.annotation.Nullable android.view.View view, @androidx.annotation.NonNull android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @param menu This value must never be {@code null}.
 * @return The default implementation returns true.
 * @apiSince 1
 */

public boolean onMenuOpened(int featureId, @androidx.annotation.NonNull android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of
 * {@link android.view.Window.Callback#onMenuItemSelected}
 * for activities.  This calls through to the new
 * {@link #onOptionsItemSelected} method for the
 * {@link android.view.Window#FEATURE_OPTIONS_PANEL}
 * panel, so that subclasses of
 * Activity don't need to deal with feature codes.
 
 * @param item This value must never be {@code null}.
 * @apiSince 1
 */

public boolean onMenuItemSelected(int featureId, @androidx.annotation.NonNull android.view.MenuItem item) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of
 * {@link android.view.Window.Callback#onPanelClosed(int, Menu)} for
 * activities. This calls through to {@link #onOptionsMenuClosed(android.view.Menu)}
 * method for the {@link android.view.Window#FEATURE_OPTIONS_PANEL} panel,
 * so that subclasses of Activity don't need to deal with feature codes.
 * For context menus ({@link android.view.Window#FEATURE_CONTEXT_MENU Window#FEATURE_CONTEXT_MENU}), the
 * {@link #onContextMenuClosed(android.view.Menu)} will be called.
 
 * @param menu This value must never be {@code null}.
 * @apiSince 1
 */

public void onPanelClosed(int featureId, @androidx.annotation.NonNull android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * Declare that the options menu has changed, so should be recreated.
 * The {@link #onCreateOptionsMenu(android.view.Menu)} method will be called the next
 * time it needs to be displayed.
 * @apiSince 11
 */

public void invalidateOptionsMenu() { throw new RuntimeException("Stub!"); }

/**
 * Initialize the contents of the Activity's standard options menu.  You
 * should place your menu items in to <var>menu</var>.
 *
 * <p>This is only called once, the first time the options menu is
 * displayed.  To update the menu every time it is displayed, see
 * {@link #onPrepareOptionsMenu}.
 *
 * <p>The default implementation populates the menu with standard system
 * menu items.  These are placed in the {@link android.view.Menu#CATEGORY_SYSTEM Menu#CATEGORY_SYSTEM} group so that
 * they will be correctly ordered with application-defined menu items.
 * Deriving classes should always call through to the base implementation.
 *
 * <p>You can safely hold on to <var>menu</var> (and any items created
 * from it), making modifications to it as desired, until the next
 * time onCreateOptionsMenu() is called.
 *
 * <p>When you add items to the menu, you can implement the Activity's
 * {@link #onOptionsItemSelected} method to handle them there.
 *
 * @param menu The options menu in which you place your items.
 *
 * @return You must return true for the menu to be displayed;
 *         if you return false it will not be shown.
 *
 * @see #onPrepareOptionsMenu
 * @see #onOptionsItemSelected
 * @apiSince 1
 */

public boolean onCreateOptionsMenu(android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * Prepare the Screen's standard options menu to be displayed.  This is
 * called right before the menu is shown, every time it is shown.  You can
 * use this method to efficiently enable/disable items or otherwise
 * dynamically modify the contents.
 *
 * <p>The default implementation updates the system menu items based on the
 * activity's state.  Deriving classes should always call through to the
 * base class implementation.
 *
 * @param menu The options menu as last shown or first initialized by
 *             onCreateOptionsMenu().
 *
 * @return You must return true for the menu to be displayed;
 *         if you return false it will not be shown.
 *
 * @see #onCreateOptionsMenu
 * @apiSince 1
 */

public boolean onPrepareOptionsMenu(android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * This hook is called whenever an item in your options menu is selected.
 * The default implementation simply returns false to have the normal
 * processing happen (calling the item's Runnable or sending a message to
 * its Handler as appropriate).  You can use this method for any items
 * for which you would like to do processing without those other
 * facilities.
 *
 * <p>Derived classes should call through to the base class for it to
 * perform the default menu handling.</p>
 *
 * @param item The menu item that was selected.
 *
 * This value must never be {@code null}.
 * @return boolean Return false to allow normal menu processing to
 *         proceed, true to consume it here.
 *
 * @see #onCreateOptionsMenu
 * @apiSince 1
 */

public boolean onOptionsItemSelected(@androidx.annotation.NonNull android.view.MenuItem item) { throw new RuntimeException("Stub!"); }

/**
 * This method is called whenever the user chooses to navigate Up within your application's
 * activity hierarchy from the action bar.
 *
 * <p>If the attribute {@link android.R.attr#parentActivityName parentActivityName}
 * was specified in the manifest for this activity or an activity-alias to it,
 * default Up navigation will be handled automatically. If any activity
 * along the parent chain requires extra Intent arguments, the Activity subclass
 * should override the method {@link #onPrepareNavigateUpTaskStack(android.app.TaskStackBuilder)}
 * to supply those arguments.</p>
 *
 * <p>See <a href="{@docRoot}guide/components/tasks-and-back-stack.html">Tasks and Back Stack</a>
 * from the developer guide and <a href="{@docRoot}design/patterns/navigation.html">Navigation</a>
 * from the design guide for more information about navigating within your app.</p>
 *
 * <p>See the {@link android.app.TaskStackBuilder TaskStackBuilder} class and the Activity methods
 * {@link #getParentActivityIntent()}, {@link #shouldUpRecreateTask(android.content.Intent)}, and
 * {@link #navigateUpTo(android.content.Intent)} for help implementing custom Up navigation.
 * The AppNavigation sample application in the Android SDK is also available for reference.</p>
 *
 * @return true if Up navigation completed successfully and this Activity was finished,
 *         false otherwise.
 * @apiSince 16
 */

public boolean onNavigateUp() { throw new RuntimeException("Stub!"); }

/**
 * This is called when a child activity of this one attempts to navigate up.
 * The default implementation simply calls onNavigateUp() on this activity (the parent).
 *
 * @param child The activity making the call.
 * @apiSince 16
 */

public boolean onNavigateUpFromChild(android.app.Activity child) { throw new RuntimeException("Stub!"); }

/**
 * Define the synthetic task stack that will be generated during Up navigation from
 * a different task.
 *
 * <p>The default implementation of this method adds the parent chain of this activity
 * as specified in the manifest to the supplied {@link android.app.TaskStackBuilder TaskStackBuilder}. Applications
 * may choose to override this method to construct the desired task stack in a different
 * way.</p>
 *
 * <p>This method will be invoked by the default implementation of {@link #onNavigateUp()}
 * if {@link #shouldUpRecreateTask(android.content.Intent)} returns true when supplied with the intent
 * returned by {@link #getParentActivityIntent()}.</p>
 *
 * <p>Applications that wish to supply extra Intent parameters to the parent stack defined
 * by the manifest should override {@link #onPrepareNavigateUpTaskStack(android.app.TaskStackBuilder)}.</p>
 *
 * @param builder An empty TaskStackBuilder - the application should add intents representing
 *                the desired task stack
 * @apiSince 16
 */

public void onCreateNavigateUpTaskStack(android.app.TaskStackBuilder builder) { throw new RuntimeException("Stub!"); }

/**
 * Prepare the synthetic task stack that will be generated during Up navigation
 * from a different task.
 *
 * <p>This method receives the {@link android.app.TaskStackBuilder TaskStackBuilder} with the constructed series of
 * Intents as generated by {@link #onCreateNavigateUpTaskStack(android.app.TaskStackBuilder)}.
 * If any extra data should be added to these intents before launching the new task,
 * the application should override this method and add that data here.</p>
 *
 * @param builder A TaskStackBuilder that has been populated with Intents by
 *                onCreateNavigateUpTaskStack.
 * @apiSince 16
 */

public void onPrepareNavigateUpTaskStack(android.app.TaskStackBuilder builder) { throw new RuntimeException("Stub!"); }

/**
 * This hook is called whenever the options menu is being closed (either by the user canceling
 * the menu with the back/menu button, or when an item is selected).
 *
 * @param menu The options menu as last shown or first initialized by
 *             onCreateOptionsMenu().
 * @apiSince 1
 */

public void onOptionsMenuClosed(android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * Programmatically opens the options menu. If the options menu is already
 * open, this method does nothing.
 * @apiSince 1
 */

public void openOptionsMenu() { throw new RuntimeException("Stub!"); }

/**
 * Progammatically closes the options menu. If the options menu is already
 * closed, this method does nothing.
 * @apiSince 1
 */

public void closeOptionsMenu() { throw new RuntimeException("Stub!"); }

/**
 * Called when a context menu for the {@code view} is about to be shown.
 * Unlike {@link #onCreateOptionsMenu(android.view.Menu)}, this will be called every
 * time the context menu is about to be shown and should be populated for
 * the view (or item inside the view for {@link android.widget.AdapterView AdapterView} subclasses,
 * this can be found in the {@code menuInfo})).
 * <p>
 * Use {@link #onContextItemSelected(android.view.MenuItem)} to know when an
 * item has been selected.
 * <p>
 * It is not safe to hold onto the context menu after this method returns.
 *
 * @apiSince 1
 */

public void onCreateContextMenu(android.view.ContextMenu menu, android.view.View v, android.view.ContextMenu.ContextMenuInfo menuInfo) { throw new RuntimeException("Stub!"); }

/**
 * Registers a context menu to be shown for the given view (multiple views
 * can show the context menu). This method will set the
 * {@link android.view.View.OnCreateContextMenuListener OnCreateContextMenuListener} on the view to this activity, so
 * {@link #onCreateContextMenu(android.view.ContextMenu,android.view.View,android.view.ContextMenu.ContextMenuInfo)} will be
 * called when it is time to show the context menu.
 *
 * @see #unregisterForContextMenu(View)
 * @param view The view that should show a context menu.
 * @apiSince 1
 */

public void registerForContextMenu(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Prevents a context menu to be shown for the given view. This method will remove the
 * {@link android.view.View.OnCreateContextMenuListener OnCreateContextMenuListener} on the view.
 *
 * @see #registerForContextMenu(View)
 * @param view The view that should stop showing a context menu.
 * @apiSince 1
 */

public void unregisterForContextMenu(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Programmatically opens the context menu for a particular {@code view}.
 * The {@code view} should have been added via
 * {@link #registerForContextMenu(android.view.View)}.
 *
 * @param view The view to show the context menu for.
 * @apiSince 1
 */

public void openContextMenu(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Programmatically closes the most recently opened context menu, if showing.
 * @apiSince 3
 */

public void closeContextMenu() { throw new RuntimeException("Stub!"); }

/**
 * This hook is called whenever an item in a context menu is selected. The
 * default implementation simply returns false to have the normal processing
 * happen (calling the item's Runnable or sending a message to its Handler
 * as appropriate). You can use this method for any items for which you
 * would like to do processing without those other facilities.
 * <p>
 * Use {@link android.view.MenuItem#getMenuInfo() MenuItem#getMenuInfo()} to get extra information set by the
 * View that added this menu item.
 * <p>
 * Derived classes should call through to the base class for it to perform
 * the default menu handling.
 *
 * @param item The context menu item that was selected.
 * This value must never be {@code null}.
 * @return boolean Return false to allow normal context menu processing to
 *         proceed, true to consume it here.
 * @apiSince 1
 */

public boolean onContextItemSelected(@androidx.annotation.NonNull android.view.MenuItem item) { throw new RuntimeException("Stub!"); }

/**
 * This hook is called whenever the context menu is being closed (either by
 * the user canceling the menu with the back/menu button, or when an item is
 * selected).
 *
 * @param menu The context menu that is being closed.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void onContextMenuClosed(@androidx.annotation.NonNull android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Old no-arguments version of {@link #onCreateDialog(int,android.os.Bundle)}.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
protected android.app.Dialog onCreateDialog(int id) { throw new RuntimeException("Stub!"); }

/**
 * Callback for creating dialogs that are managed (saved and restored) for you
 * by the activity.  The default implementation calls through to
 * {@link #onCreateDialog(int)} for compatibility.
 *
 * <em>If you are targeting {@link android.os.Build.VERSION_CODES#HONEYCOMB}
 * or later, consider instead using a {@link android.app.DialogFragment DialogFragment} instead.</em>
 *
 * <p>If you use {@link #showDialog(int)}, the activity will call through to
 * this method the first time, and hang onto it thereafter.  Any dialog
 * that is created by this method will automatically be saved and restored
 * for you, including whether it is showing.
 *
 * <p>If you would like the activity to manage saving and restoring dialogs
 * for you, you should override this method and handle any ids that are
 * passed to {@link #showDialog}.
 *
 * <p>If you would like an opportunity to prepare your dialog before it is shown,
 * override {@link #onPrepareDialog(int,android.app.Dialog,android.os.Bundle)}.
 *
 * @param id The id of the dialog.
 * @param args The dialog arguments provided to {@link #showDialog(int,android.os.Bundle)}.
 * @return The dialog.  If you return null, the dialog will not be created.
 *
 * @see #onPrepareDialog(int, Dialog, Bundle)
 * @see #showDialog(int, Bundle)
 * @see #dismissDialog(int)
 * @see #removeDialog(int)
 *
 * @deprecated Use the new {@link android.app.DialogFragment DialogFragment} class with
 * {@link android.app.FragmentManager FragmentManager} instead; this is also
 * available on older platforms through the Android compatibility package.
 * @apiSince 8
 * @deprecatedSince 15
 */

@Deprecated
@androidx.annotation.Nullable
protected android.app.Dialog onCreateDialog(int id, android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Old no-arguments version of
 * {@link #onPrepareDialog(int,android.app.Dialog,android.os.Bundle)}.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
protected void onPrepareDialog(int id, android.app.Dialog dialog) { throw new RuntimeException("Stub!"); }

/**
 * Provides an opportunity to prepare a managed dialog before it is being
 * shown.  The default implementation calls through to
 * {@link #onPrepareDialog(int,android.app.Dialog)} for compatibility.
 *
 * <p>
 * Override this if you need to update a managed dialog based on the state
 * of the application each time it is shown. For example, a time picker
 * dialog might want to be updated with the current time. You should call
 * through to the superclass's implementation. The default implementation
 * will set this Activity as the owner activity on the Dialog.
 *
 * @param id The id of the managed dialog.
 * @param dialog The dialog.
 * @param args The dialog arguments provided to {@link #showDialog(int,android.os.Bundle)}.
 * @see #onCreateDialog(int, Bundle)
 * @see #showDialog(int)
 * @see #dismissDialog(int)
 * @see #removeDialog(int)
 *
 * @deprecated Use the new {@link android.app.DialogFragment DialogFragment} class with
 * {@link android.app.FragmentManager FragmentManager} instead; this is also
 * available on older platforms through the Android compatibility package.
 * @apiSince 8
 * @deprecatedSince 15
 */

@Deprecated
protected void onPrepareDialog(int id, android.app.Dialog dialog, android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Simple version of {@link #showDialog(int,android.os.Bundle)} that does not
 * take any arguments.  Simply calls {@link #showDialog(int,android.os.Bundle)}
 * with null arguments.
 *
 * @deprecated Use the new {@link android.app.DialogFragment DialogFragment} class with
 * {@link android.app.FragmentManager FragmentManager} instead; this is also
 * available on older platforms through the Android compatibility package.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public final void showDialog(int id) { throw new RuntimeException("Stub!"); }

/**
 * Show a dialog managed by this activity.  A call to {@link #onCreateDialog(int,android.os.Bundle)}
 * will be made with the same id the first time this is called for a given
 * id.  From thereafter, the dialog will be automatically saved and restored.
 *
 * <em>If you are targeting {@link android.os.Build.VERSION_CODES#HONEYCOMB}
 * or later, consider instead using a {@link android.app.DialogFragment DialogFragment} instead.</em>
 *
 * <p>Each time a dialog is shown, {@link #onPrepareDialog(int,android.app.Dialog,android.os.Bundle)} will
 * be made to provide an opportunity to do any timely preparation.
 *
 * @param id The id of the managed dialog.
 * @param args Arguments to pass through to the dialog.  These will be saved
 * and restored for you.  Note that if the dialog is already created,
 * {@link #onCreateDialog(int,android.os.Bundle)} will not be called with the new
 * arguments but {@link #onPrepareDialog(int,android.app.Dialog,android.os.Bundle)} will be.
 * If you need to rebuild the dialog, call {@link #removeDialog(int)} first.
 * @return Returns true if the Dialog was created; false is returned if
 * it is not created because {@link #onCreateDialog(int,android.os.Bundle)} returns false.
 *
 * @see android.app.Dialog
 * @see #onCreateDialog(int, Bundle)
 * @see #onPrepareDialog(int, Dialog, Bundle)
 * @see #dismissDialog(int)
 * @see #removeDialog(int)
 *
 * @deprecated Use the new {@link android.app.DialogFragment DialogFragment} class with
 * {@link android.app.FragmentManager FragmentManager} instead; this is also
 * available on older platforms through the Android compatibility package.
 * @apiSince 8
 * @deprecatedSince 15
 */

@Deprecated
public final boolean showDialog(int id, android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Dismiss a dialog that was previously shown via {@link #showDialog(int)}.
 *
 * @param id The id of the managed dialog.
 *
 * @throws java.lang.IllegalArgumentException if the id was not previously shown via
 *   {@link #showDialog(int)}.
 *
 * @see #onCreateDialog(int, Bundle)
 * @see #onPrepareDialog(int, Dialog, Bundle)
 * @see #showDialog(int)
 * @see #removeDialog(int)
 *
 * @deprecated Use the new {@link android.app.DialogFragment DialogFragment} class with
 * {@link android.app.FragmentManager FragmentManager} instead; this is also
 * available on older platforms through the Android compatibility package.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public final void dismissDialog(int id) { throw new RuntimeException("Stub!"); }

/**
 * Removes any internal references to a dialog managed by this Activity.
 * If the dialog is showing, it will dismiss it as part of the clean up.
 *
 * <p>This can be useful if you know that you will never show a dialog again and
 * want to avoid the overhead of saving and restoring it in the future.
 *
 * <p>As of {@link android.os.Build.VERSION_CODES#GINGERBREAD}, this function
 * will not throw an exception if you try to remove an ID that does not
 * currently have an associated dialog.</p>
 *
 * @param id The id of the managed dialog.
 *
 * @see #onCreateDialog(int, Bundle)
 * @see #onPrepareDialog(int, Dialog, Bundle)
 * @see #showDialog(int)
 * @see #dismissDialog(int)
 *
 * @deprecated Use the new {@link android.app.DialogFragment DialogFragment} class with
 * {@link android.app.FragmentManager FragmentManager} instead; this is also
 * available on older platforms through the Android compatibility package.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public final void removeDialog(int id) { throw new RuntimeException("Stub!"); }

/**
 * This hook is called when the user signals the desire to start a search.
 *
 * <p>You can use this function as a simple way to launch the search UI, in response to a
 * menu item, search button, or other widgets within your activity. Unless overidden,
 * calling this function is the same as calling
 * {@link #startSearch startSearch(null,false,null,false)}, which launches
 * search for the current activity as specified in its manifest, see {@link android.app.SearchManager SearchManager}.
 *
 * <p>You can override this function to force global search, e.g. in response to a dedicated
 * search key, or to block search entirely (by simply returning false).
 *
 * <p>Note: when running in a {@link android.content.res.Configuration#UI_MODE_TYPE_TELEVISION Configuration#UI_MODE_TYPE_TELEVISION} or
 * {@link android.content.res.Configuration#UI_MODE_TYPE_WATCH Configuration#UI_MODE_TYPE_WATCH}, the default implementation changes to simply
 * return false and you must supply your own custom implementation if you want to support
 * search.
 *
 * @param searchEvent The {@link android.view.SearchEvent SearchEvent} that signaled this search.
 * This value may be {@code null}.
 * @return Returns {@code true} if search launched, and {@code false} if the activity does
 * not respond to search.  The default implementation always returns {@code true}, except
 * when in {@link android.content.res.Configuration#UI_MODE_TYPE_TELEVISION Configuration#UI_MODE_TYPE_TELEVISION} mode where it returns false.
 *
 * @see android.app.SearchManager
 * @apiSince 23
 */

public boolean onSearchRequested(@androidx.annotation.Nullable android.view.SearchEvent searchEvent) { throw new RuntimeException("Stub!"); }

/**
 * @see #onSearchRequested(SearchEvent)
 * @apiSince 1
 */

public boolean onSearchRequested() { throw new RuntimeException("Stub!"); }

/**
 * During the onSearchRequested() callbacks, this function will return the
 * {@link android.view.SearchEvent SearchEvent} that triggered the callback, if it exists.
 *
 * @return SearchEvent The SearchEvent that triggered the {@link
 *                    #onSearchRequested} callback.
 * @apiSince 23
 */

public final android.view.SearchEvent getSearchEvent() { throw new RuntimeException("Stub!"); }

/**
 * This hook is called to launch the search UI.
 *
 * <p>It is typically called from onSearchRequested(), either directly from
 * Activity.onSearchRequested() or from an overridden version in any given
 * Activity.  If your goal is simply to activate search, it is preferred to call
 * onSearchRequested(), which may have been overridden elsewhere in your Activity.  If your goal
 * is to inject specific data such as context data, it is preferred to <i>override</i>
 * onSearchRequested(), so that any callers to it will benefit from the override.
 *
 * <p>Note: when running in a {@link android.content.res.Configuration#UI_MODE_TYPE_WATCH Configuration#UI_MODE_TYPE_WATCH}, use of this API is
 * not supported.
 *
 * @param initialQuery Any non-null non-empty string will be inserted as
 * pre-entered text in the search query box.
 * This value may be {@code null}.
 * @param selectInitialQuery If true, the initial query will be preselected, which means that
 * any further typing will replace it.  This is useful for cases where an entire pre-formed
 * query is being inserted.  If false, the selection point will be placed at the end of the
 * inserted query.  This is useful when the inserted query is text that the user entered,
 * and the user would expect to be able to keep typing.  <i>This parameter is only meaningful
 * if initialQuery is a non-empty string.</i>
 * @param appSearchData An application can insert application-specific
 * context here, in order to improve quality or specificity of its own
 * searches.  This data will be returned with SEARCH intent(s).  Null if
 * no extra data is required.
 * This value may be {@code null}.
 * @param globalSearch If false, this will only launch the search that has been specifically
 * defined by the application (which is usually defined as a local search).  If no default
 * search is defined in the current application or activity, global search will be launched.
 * If true, this will always launch a platform-global (e.g. web-based) search instead.
 *
 * @see android.app.SearchManager
 * @see #onSearchRequested
 * @apiSince 1
 */

public void startSearch(@androidx.annotation.Nullable java.lang.String initialQuery, boolean selectInitialQuery, @androidx.annotation.Nullable android.os.Bundle appSearchData, boolean globalSearch) { throw new RuntimeException("Stub!"); }

/**
 * Similar to {@link #startSearch}, but actually fires off the search query after invoking
 * the search dialog.  Made available for testing purposes.
 *
 * @param query The query to trigger.  If empty, the request will be ignored.
 * @param appSearchData An application can insert application-specific
 * context here, in order to improve quality or specificity of its own
 * searches.  This data will be returned with SEARCH intent(s).  Null if
 * no extra data is required.
 
 * This value may be {@code null}.
 * @apiSince 5
 */

public void triggerSearch(java.lang.String query, @androidx.annotation.Nullable android.os.Bundle appSearchData) { throw new RuntimeException("Stub!"); }

/**
 * Request that key events come to this activity. Use this if your
 * activity has no views with focus, but the activity still wants
 * a chance to process key events.
 *
 * @see android.view.Window#takeKeyEvents
 * @apiSince 1
 */

public void takeKeyEvents(boolean get) { throw new RuntimeException("Stub!"); }

/**
 * Enable extended window features.  This is a convenience for calling
 * {@link android.view.Window#requestFeature getWindow().requestFeature()}.
 *
 * @param featureId The desired feature as defined in
 *                  {@link android.view.Window}.
 * @return Returns true if the requested feature is supported and now
 *         enabled.
 *
 * @see android.view.Window#requestFeature
 * @apiSince 1
 */

public final boolean requestWindowFeature(int featureId) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for calling
 * {@link android.view.Window#setFeatureDrawableResource}.
 * @apiSince 1
 */

public final void setFeatureDrawableResource(int featureId, int resId) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for calling
 * {@link android.view.Window#setFeatureDrawableUri}.
 * @apiSince 1
 */

public final void setFeatureDrawableUri(int featureId, android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for calling
 * {@link android.view.Window#setFeatureDrawable(int, Drawable)}.
 * @apiSince 1
 */

public final void setFeatureDrawable(int featureId, android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for calling
 * {@link android.view.Window#setFeatureDrawableAlpha}.
 * @apiSince 1
 */

public final void setFeatureDrawableAlpha(int featureId, int alpha) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for calling
 * {@link android.view.Window#getLayoutInflater}.
 
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.view.LayoutInflater getLayoutInflater() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.view.MenuInflater MenuInflater} with this context.
 
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.view.MenuInflater getMenuInflater() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setTheme(int resid) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onApplyThemeResource(android.content.res.Resources.Theme theme, int resid, boolean first) { throw new RuntimeException("Stub!"); }

/**
 * Requests permissions to be granted to this application. These permissions
 * must be requested in your manifest, they should not be granted to your app,
 * and they should have protection level {@link
 * android.content.pm.PermissionInfo#PROTECTION_DANGEROUS dangerous}, regardless
 * whether they are declared by the platform or a third-party app.
 * <p>
 * Normal permissions {@link android.content.pm.PermissionInfo#PROTECTION_NORMAL}
 * are granted at install time if requested in the manifest. Signature permissions
 * {@link android.content.pm.PermissionInfo#PROTECTION_SIGNATURE} are granted at
 * install time if requested in the manifest and the signature of your app matches
 * the signature of the app declaring the permissions.
 * </p>
 * <p>
 * If your app does not have the requested permissions the user will be presented
 * with UI for accepting them. After the user has accepted or rejected the
 * requested permissions you will receive a callback on {@link
 * #onRequestPermissionsResult(int,java.lang.String[],int[])} reporting whether the
 * permissions were granted or not.
 * </p>
 * <p>
 * Note that requesting a permission does not guarantee it will be granted and
 * your app should be able to run without having this permission.
 * </p>
 * <p>
 * This method may start an activity allowing the user to choose which permissions
 * to grant and which to reject. Hence, you should be prepared that your activity
 * may be paused and resumed. Further, granting some permissions may require
 * a restart of you application. In such a case, the system will recreate the
 * activity stack before delivering the result to {@link
 * #onRequestPermissionsResult(int,java.lang.String[],int[])}.
 * </p>
 * <p>
 * When checking whether you have a permission you should use {@link
 * #checkSelfPermission(java.lang.String)}.
 * </p>
 * <p>
 * Calling this API for permissions already granted to your app would show UI
 * to the user to decide whether the app can still hold these permissions. This
 * can be useful if the way your app uses data guarded by the permissions
 * changes significantly.
 * </p>
 * <p>
 * You cannot request a permission if your activity sets {@link
 * android.R.styleable#AndroidManifestActivity_noHistory noHistory} to
 * <code>true</code> because in this case the activity would not receive
 * result callbacks including {@link #onRequestPermissionsResult(int,java.lang.String[],int[])}.
 * </p>
 * <p>
 * The <a href="https://github.com/googlesamples/android-RuntimePermissions">
 * RuntimePermissions</a> sample app demonstrates how to use this method to
 * request permissions at run time.
 * </p>
 *
 * @param permissions The requested permissions. Must me non-null and not empty.
 * This value must never be {@code null}.
 * @param requestCode Application specific request code to match with a result
 *    reported to {@link #onRequestPermissionsResult(int,java.lang.String[],int[])}.
 *    Should be >= 0.
 *
 * @throws java.lang.IllegalArgumentException if requestCode is negative.
 *
 * @see #onRequestPermissionsResult(int, String[], int[])
 * @see #checkSelfPermission(String)
 * @see #shouldShowRequestPermissionRationale(String)
 * @apiSince 23
 */

public final void requestPermissions(@androidx.annotation.NonNull java.lang.String[] permissions, int requestCode) { throw new RuntimeException("Stub!"); }

/**
 * Callback for the result from requesting permissions. This method
 * is invoked for every call on {@link #requestPermissions(java.lang.String[],int)}.
 * <p>
 * <strong>Note:</strong> It is possible that the permissions request interaction
 * with the user is interrupted. In this case you will receive empty permissions
 * and results arrays which should be treated as a cancellation.
 * </p>
 *
 * @param requestCode The request code passed in {@link #requestPermissions(java.lang.String[],int)}.
 * @param permissions The requested permissions. Never null.
 * This value must never be {@code null}.
 * @param grantResults The grant results for the corresponding permissions
 *     which is either {@link android.content.pm.PackageManager#PERMISSION_GRANTED}
 *     or {@link android.content.pm.PackageManager#PERMISSION_DENIED}. Never null.
 *
 * This value must never be {@code null}.
 * @see #requestPermissions(String[], int)
 * @apiSince 23
 */

public void onRequestPermissionsResult(int requestCode, @androidx.annotation.NonNull java.lang.String[] permissions, @androidx.annotation.NonNull int[] grantResults) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether you should show UI with rationale for requesting a permission.
 * You should do this only if you do not have the permission and the context in
 * which the permission is requested does not clearly communicate to the user
 * what would be the benefit from granting this permission.
 * <p>
 * For example, if you write a camera app, requesting the camera permission
 * would be expected by the user and no rationale for why it is requested is
 * needed. If however, the app needs location for tagging photos then a non-tech
 * savvy user may wonder how location is related to taking photos. In this case
 * you may choose to show UI with rationale of requesting this permission.
 * </p>
 *
 * @param permission A permission your app wants to request.
 * This value must never be {@code null}.
 * @return Whether you can show permission rationale UI.
 *
 * @see #checkSelfPermission(String)
 * @see #requestPermissions(String[], int)
 * @see #onRequestPermissionsResult(int, String[], int[])
 * @apiSince 23
 */

public boolean shouldShowRequestPermissionRationale(@androidx.annotation.NonNull java.lang.String permission) { throw new RuntimeException("Stub!"); }

/**
 * Same as calling {@link #startActivityForResult(android.content.Intent,int,android.os.Bundle)}
 * with no options.
 *
 * @param intent The intent to start.
 * @param requestCode If >= 0, this code will be returned in
 *                    onActivityResult() when the activity exits.
 *
 * @throws android.content.ActivityNotFoundException
 *
 * @see #startActivity
 * @apiSince 1
 */

public void startActivityForResult(android.content.Intent intent, int requestCode) { throw new RuntimeException("Stub!"); }

/**
 * Launch an activity for which you would like a result when it finished.
 * When this activity exits, your
 * onActivityResult() method will be called with the given requestCode.
 * Using a negative requestCode is the same as calling
 * {@link #startActivity} (the activity is not launched as a sub-activity).
 *
 * <p>Note that this method should only be used with Intent protocols
 * that are defined to return a result.  In other protocols (such as
 * {@link android.content.Intent#ACTION_MAIN Intent#ACTION_MAIN} or {@link android.content.Intent#ACTION_VIEW Intent#ACTION_VIEW}), you may
 * not get the result when you expect.  For example, if the activity you
 * are launching uses {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK Intent#FLAG_ACTIVITY_NEW_TASK}, it will not
 * run in your task and thus you will immediately receive a cancel result.
 *
 * <p>As a special case, if you call startActivityForResult() with a requestCode
 * >= 0 during the initial onCreate(Bundle savedInstanceState)/onResume() of your
 * activity, then your window will not be displayed until a result is
 * returned back from the started activity.  This is to avoid visible
 * flickering when redirecting to another activity.
 *
 * <p>This method throws {@link android.content.ActivityNotFoundException}
 * if there was no Activity found to run the given Intent.
 *
 * @param intent The intent to start.
 * @param requestCode If >= 0, this code will be returned in
 *                    onActivityResult() when the activity exits.
 * @param options Additional options for how the Activity should be started.
 * See {@link android.content.Context#startActivity(Intent, Bundle)}
 * Context.startActivity(Intent, Bundle)} for more details.
 *
 * This value may be {@code null}.
 * @throws android.content.ActivityNotFoundException
 *
 * @see #startActivity
 * @apiSince 16
 */

public void startActivityForResult(android.content.Intent intent, int requestCode, @androidx.annotation.Nullable android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether there are any activity transitions currently running on this
 * activity. A return value of {@code true} can mean that either an enter or
 * exit transition is running, including whether the background of the activity
 * is animating as a part of that transition.
 *
 * @return true if a transition is currently running on this activity, false otherwise.
 * @apiSince 26
 */

public boolean isActivityTransitionRunning() { throw new RuntimeException("Stub!"); }

/**
 * Same as calling {@link #startIntentSenderForResult(android.content.IntentSender,int,android.content.Intent,int,int,int,android.os.Bundle)} with no options.
 *
 * @param intent The IntentSender to launch.
 * @param requestCode If >= 0, this code will be returned in
 *                    onActivityResult() when the activity exits.
 * @param fillInIntent If non-null, this will be provided as the
 * intent parameter to {@link android.content.IntentSender#sendIntent IntentSender#sendIntent}.
 * This value may be {@code null}.
 * @param flagsMask Intent flags in the original IntentSender that you
 * would like to change.
 * @param flagsValues Desired values for any bits set in
 * <var>flagsMask</var>
 * @param extraFlags Always set to 0.
 * @apiSince 5
 */

public void startIntentSenderForResult(android.content.IntentSender intent, int requestCode, @androidx.annotation.Nullable android.content.Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws android.content.IntentSender.SendIntentException { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #startActivityForResult(android.content.Intent,int)}, but allowing you
 * to use a IntentSender to describe the activity to be started.  If
 * the IntentSender is for an activity, that activity will be started
 * as if you had called the regular {@link #startActivityForResult(android.content.Intent,int)}
 * here; otherwise, its associated action will be executed (such as
 * sending a broadcast) as if you had called
 * {@link android.content.IntentSender#sendIntent IntentSender#sendIntent} on it.
 *
 * @param intent The IntentSender to launch.
 * @param requestCode If >= 0, this code will be returned in
 *                    onActivityResult() when the activity exits.
 * @param fillInIntent If non-null, this will be provided as the
 * intent parameter to {@link android.content.IntentSender#sendIntent IntentSender#sendIntent}.
 * This value may be {@code null}.
 * @param flagsMask Intent flags in the original IntentSender that you
 * would like to change.
 * @param flagsValues Desired values for any bits set in
 * <var>flagsMask</var>
 * @param extraFlags Always set to 0.
 * @param options Additional options for how the Activity should be started.
 * See {@link android.content.Context#startActivity(Intent, Bundle)}
 * Context.startActivity(Intent, Bundle)} for more details.  If options
 * have also been supplied by the IntentSender, options given here will
 * override any that conflict with those given by the IntentSender.
 * @apiSince 16
 */

public void startIntentSenderForResult(android.content.IntentSender intent, int requestCode, @androidx.annotation.Nullable android.content.Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, android.os.Bundle options) throws android.content.IntentSender.SendIntentException { throw new RuntimeException("Stub!"); }

/**
 * Same as {@link #startActivity(android.content.Intent,android.os.Bundle)} with no options
 * specified.
 *
 * @param intent The intent to start.
 *
 * @throws android.content.ActivityNotFoundException
 *
 * @see #startActivity(Intent, Bundle)
 * @see #startActivityForResult
 * @apiSince 1
 */

public void startActivity(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Launch a new activity.  You will not receive any information about when
 * the activity exits.  This implementation overrides the base version,
 * providing information about
 * the activity performing the launch.  Because of this additional
 * information, the {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK Intent#FLAG_ACTIVITY_NEW_TASK} launch flag is not
 * required; if not specified, the new activity will be added to the
 * task of the caller.
 *
 * <p>This method throws {@link android.content.ActivityNotFoundException}
 * if there was no Activity found to run the given Intent.
 *
 * @param intent The intent to start.
 * @param options Additional options for how the Activity should be started.
 * See {@link android.content.Context#startActivity(Intent, Bundle)}
 * Context.startActivity(Intent, Bundle)} for more details.
 *
 * This value may be {@code null}.
 * @throws android.content.ActivityNotFoundException
 *
 * @see #startActivity(Intent)
 * @see #startActivityForResult
 * @apiSince 16
 */

public void startActivity(android.content.Intent intent, @androidx.annotation.Nullable android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Same as {@link #startActivities(android.content.Intent[],android.os.Bundle)} with no options
 * specified.
 *
 * @param intents The intents to start.
 *
 * @throws android.content.ActivityNotFoundException
 *
 * @see #startActivities(Intent[], Bundle)
 * @see #startActivityForResult
 * @apiSince 11
 */

public void startActivities(android.content.Intent[] intents) { throw new RuntimeException("Stub!"); }

/**
 * Launch a new activity.  You will not receive any information about when
 * the activity exits.  This implementation overrides the base version,
 * providing information about
 * the activity performing the launch.  Because of this additional
 * information, the {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK Intent#FLAG_ACTIVITY_NEW_TASK} launch flag is not
 * required; if not specified, the new activity will be added to the
 * task of the caller.
 *
 * <p>This method throws {@link android.content.ActivityNotFoundException}
 * if there was no Activity found to run the given Intent.
 *
 * @param intents The intents to start.
 * @param options Additional options for how the Activity should be started.
 * See {@link android.content.Context#startActivity(Intent, Bundle)}
 * Context.startActivity(Intent, Bundle)} for more details.
 *
 * This value may be {@code null}.
 * @throws android.content.ActivityNotFoundException
 *
 * @see #startActivities(Intent[])
 * @see #startActivityForResult
 * @apiSince 16
 */

public void startActivities(android.content.Intent[] intents, @androidx.annotation.Nullable android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Same as calling {@link #startIntentSender(android.content.IntentSender,android.content.Intent,int,int,int,android.os.Bundle)}
 * with no options.
 *
 * @param intent The IntentSender to launch.
 * @param fillInIntent If non-null, this will be provided as the
 * intent parameter to {@link android.content.IntentSender#sendIntent IntentSender#sendIntent}.
 * This value may be {@code null}.
 * @param flagsMask Intent flags in the original IntentSender that you
 * would like to change.
 * @param flagsValues Desired values for any bits set in
 * <var>flagsMask</var>
 * @param extraFlags Always set to 0.
 * @apiSince 5
 */

public void startIntentSender(android.content.IntentSender intent, @androidx.annotation.Nullable android.content.Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws android.content.IntentSender.SendIntentException { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #startActivity(android.content.Intent,android.os.Bundle)}, but taking a IntentSender
 * to start; see
 * {@link #startIntentSenderForResult(android.content.IntentSender,int,android.content.Intent,int,int,int,android.os.Bundle)}
 * for more information.
 *
 * @param intent The IntentSender to launch.
 * @param fillInIntent If non-null, this will be provided as the
 * intent parameter to {@link android.content.IntentSender#sendIntent IntentSender#sendIntent}.
 * This value may be {@code null}.
 * @param flagsMask Intent flags in the original IntentSender that you
 * would like to change.
 * @param flagsValues Desired values for any bits set in
 * <var>flagsMask</var>
 * @param extraFlags Always set to 0.
 * @param options Additional options for how the Activity should be started.
 * See {@link android.content.Context#startActivity(Intent, Bundle)}
 * Context.startActivity(Intent, Bundle)} for more details.  If options
 * have also been supplied by the IntentSender, options given here will
 * override any that conflict with those given by the IntentSender.
 * @apiSince 16
 */

public void startIntentSender(android.content.IntentSender intent, @androidx.annotation.Nullable android.content.Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, android.os.Bundle options) throws android.content.IntentSender.SendIntentException { throw new RuntimeException("Stub!"); }

/**
 * Same as calling {@link #startActivityIfNeeded(android.content.Intent,int,android.os.Bundle)}
 * with no options.
 *
 * @param intent The intent to start.
 * This value must never be {@code null}.
 * @param requestCode If >= 0, this code will be returned in
 *         onActivityResult() when the activity exits, as described in
 *         {@link #startActivityForResult}.
 *
 * @return If a new activity was launched then true is returned; otherwise
 *         false is returned and you must handle the Intent yourself.
 *
 * @see #startActivity
 * @see #startActivityForResult
 * @apiSince 1
 */

public boolean startActivityIfNeeded(@androidx.annotation.NonNull android.content.Intent intent, int requestCode) { throw new RuntimeException("Stub!"); }

/**
 * A special variation to launch an activity only if a new activity
 * instance is needed to handle the given Intent.  In other words, this is
 * just like {@link #startActivityForResult(android.content.Intent,int)} except: if you are
 * using the {@link android.content.Intent#FLAG_ACTIVITY_SINGLE_TOP Intent#FLAG_ACTIVITY_SINGLE_TOP} flag, or
 * singleTask or singleTop
 * {@link android.R.styleable#AndroidManifestActivity_launchMode launchMode},
 * and the activity
 * that handles <var>intent</var> is the same as your currently running
 * activity, then a new instance is not needed.  In this case, instead of
 * the normal behavior of calling {@link #onNewIntent} this function will
 * return and you can handle the Intent yourself.
 *
 * <p>This function can only be called from a top-level activity; if it is
 * called from a child activity, a runtime exception will be thrown.
 *
 * @param intent The intent to start.
 * This value must never be {@code null}.
 * @param requestCode If >= 0, this code will be returned in
 *         onActivityResult() when the activity exits, as described in
 *         {@link #startActivityForResult}.
 * @param options Additional options for how the Activity should be started.
 * See {@link android.content.Context#startActivity(Intent, Bundle)}
 * Context.startActivity(Intent, Bundle)} for more details.
 *
 * This value may be {@code null}.
 * @return If a new activity was launched then true is returned; otherwise
 *         false is returned and you must handle the Intent yourself.
 *
 * @see #startActivity
 * @see #startActivityForResult
 * @apiSince 16
 */

public boolean startActivityIfNeeded(@androidx.annotation.NonNull android.content.Intent intent, int requestCode, @androidx.annotation.Nullable android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Same as calling {@link #startNextMatchingActivity(android.content.Intent,android.os.Bundle)} with
 * no options.
 *
 * @param intent The intent to dispatch to the next activity.  For
 * correct behavior, this must be the same as the Intent that started
 * your own activity; the only changes you can make are to the extras
 * inside of it.
 *
 * This value must never be {@code null}.
 * @return Returns a boolean indicating whether there was another Activity
 * to start: true if there was a next activity to start, false if there
 * wasn't.  In general, if true is returned you will then want to call
 * finish() on yourself.
 * @apiSince 1
 */

public boolean startNextMatchingActivity(@androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Special version of starting an activity, for use when you are replacing
 * other activity components.  You can use this to hand the Intent off
 * to the next Activity that can handle it.  You typically call this in
 * {@link #onCreate} with the Intent returned by {@link #getIntent}.
 *
 * @param intent The intent to dispatch to the next activity.  For
 * correct behavior, this must be the same as the Intent that started
 * your own activity; the only changes you can make are to the extras
 * inside of it.
 * This value must never be {@code null}.
 * @param options Additional options for how the Activity should be started.
 * See {@link android.content.Context#startActivity(Intent, Bundle)}
 * Context.startActivity(Intent, Bundle)} for more details.
 *
 * This value may be {@code null}.
 * @return Returns a boolean indicating whether there was another Activity
 * to start: true if there was a next activity to start, false if there
 * wasn't.  In general, if true is returned you will then want to call
 * finish() on yourself.
 * @apiSince 16
 */

public boolean startNextMatchingActivity(@androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.Nullable android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Same as calling {@link #startActivityFromChild(android.app.Activity,android.content.Intent,int,android.os.Bundle)}
 * with no options.
 *
 * @param child The activity making the call.
 * This value must never be {@code null}.
 * @param intent The intent to start.
 * @param requestCode Reply request code.  < 0 if reply is not requested.
 *
 * @throws android.content.ActivityNotFoundException
 *
 * @see #startActivity
 * @see #startActivityForResult
 * @apiSince 1
 */

public void startActivityFromChild(@androidx.annotation.NonNull android.app.Activity child, android.content.Intent intent, int requestCode) { throw new RuntimeException("Stub!"); }

/**
 * This is called when a child activity of this one calls its
 * {@link #startActivity} or {@link #startActivityForResult} method.
 *
 * <p>This method throws {@link android.content.ActivityNotFoundException}
 * if there was no Activity found to run the given Intent.
 *
 * @param child The activity making the call.
 * This value must never be {@code null}.
 * @param intent The intent to start.
 * @param requestCode Reply request code.  < 0 if reply is not requested.
 * @param options Additional options for how the Activity should be started.
 * See {@link android.content.Context#startActivity(Intent, Bundle)}
 * Context.startActivity(Intent, Bundle)} for more details.
 *
 * This value may be {@code null}.
 * @throws android.content.ActivityNotFoundException
 *
 * @see #startActivity
 * @see #startActivityForResult
 * @apiSince 16
 */

public void startActivityFromChild(@androidx.annotation.NonNull android.app.Activity child, android.content.Intent intent, int requestCode, @androidx.annotation.Nullable android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Same as calling {@link #startActivityFromFragment(android.app.Fragment,android.content.Intent,int,android.os.Bundle)}
 * with no options.
 *
 * @param fragment The fragment making the call.
 * This value must never be {@code null}.
 * @param intent The intent to start.
 * @param requestCode Reply request code.  < 0 if reply is not requested.
 *
 * @throws android.content.ActivityNotFoundException
 *
 * @see Fragment#startActivity
 * @see Fragment#startActivityForResult
 *
 * @deprecated Use {@link android.support.v4.app.FragmentActivity#startActivityFromFragment(
 * android.support.v4.app.Fragment,Intent,int)}
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void startActivityFromFragment(@androidx.annotation.NonNull android.app.Fragment fragment, android.content.Intent intent, int requestCode) { throw new RuntimeException("Stub!"); }

/**
 * This is called when a Fragment in this activity calls its
 * {@link android.app.Fragment#startActivity Fragment#startActivity} or {@link android.app.Fragment#startActivityForResult Fragment#startActivityForResult}
 * method.
 *
 * <p>This method throws {@link android.content.ActivityNotFoundException}
 * if there was no Activity found to run the given Intent.
 *
 * @param fragment The fragment making the call.
 * This value must never be {@code null}.
 * @param intent The intent to start.
 * @param requestCode Reply request code.  < 0 if reply is not requested.
 * @param options Additional options for how the Activity should be started.
 * See {@link android.content.Context#startActivity(Intent, Bundle)}
 * Context.startActivity(Intent, Bundle)} for more details.
 *
 * This value may be {@code null}.
 * @throws android.content.ActivityNotFoundException
 *
 * @see Fragment#startActivity
 * @see Fragment#startActivityForResult
 *
 * @deprecated Use {@link android.support.v4.app.FragmentActivity#startActivityFromFragment(
 * android.support.v4.app.Fragment,Intent,int,Bundle)}
 * @apiSince 16
 * @deprecatedSince 28
 */

@Deprecated
public void startActivityFromFragment(@androidx.annotation.NonNull android.app.Fragment fragment, android.content.Intent intent, int requestCode, @androidx.annotation.Nullable android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Same as calling {@link #startIntentSenderFromChild(android.app.Activity,android.content.IntentSender,int,android.content.Intent,int,int,int,android.os.Bundle)} with no options.
 * @apiSince 5
 */

public void startIntentSenderFromChild(android.app.Activity child, android.content.IntentSender intent, int requestCode, android.content.Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws android.content.IntentSender.SendIntentException { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #startActivityFromChild(android.app.Activity,android.content.Intent,int)}, but
 * taking a IntentSender; see
 * {@link #startIntentSenderForResult(android.content.IntentSender,int,android.content.Intent,int,int,int)}
 * for more information.
 
 * @param options This value may be {@code null}.
 * @apiSince 16
 */

public void startIntentSenderFromChild(android.app.Activity child, android.content.IntentSender intent, int requestCode, android.content.Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @androidx.annotation.Nullable android.os.Bundle options) throws android.content.IntentSender.SendIntentException { throw new RuntimeException("Stub!"); }

/**
 * Call immediately after one of the flavors of {@link #startActivity(android.content.Intent)}
 * or {@link #finish} to specify an explicit transition animation to
 * perform next.
 *
 * <p>As of {@link android.os.Build.VERSION_CODES#JELLY_BEAN} an alternative
 * to using this with starting activities is to supply the desired animation
 * information through a {@link android.app.ActivityOptions ActivityOptions} bundle to
 * {@link #startActivity(android.content.Intent,android.os.Bundle)} or a related function.  This allows
 * you to specify a custom animation even when starting an activity from
 * outside the context of the current top activity.
 *
 * @param enterAnim A resource ID of the animation resource to use for
 * the incoming activity.  Use 0 for no animation.
 * @param exitAnim A resource ID of the animation resource to use for
 * the outgoing activity.  Use 0 for no animation.
 * @apiSince 5
 */

public void overridePendingTransition(int enterAnim, int exitAnim) { throw new RuntimeException("Stub!"); }

/**
 * Call this to set the result that your activity will return to its
 * caller.
 *
 * @param resultCode The result code to propagate back to the originating
 *                   activity, often RESULT_CANCELED or RESULT_OK
 *
 * @see #RESULT_CANCELED
 * @see #RESULT_OK
 * @see #RESULT_FIRST_USER
 * @see #setResult(int, Intent)
 * @apiSince 1
 */

public final void setResult(int resultCode) { throw new RuntimeException("Stub!"); }

/**
 * Call this to set the result that your activity will return to its
 * caller.
 *
 * <p>As of {@link android.os.Build.VERSION_CODES#GINGERBREAD}, the Intent
 * you supply here can have {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION Intent#FLAG_GRANT_READ_URI_PERMISSION} and/or {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION Intent#FLAG_GRANT_WRITE_URI_PERMISSION} set.  This will grant the
 * Activity receiving the result access to the specific URIs in the Intent.
 * Access will remain until the Activity has finished (it will remain across the hosting
 * process being killed and other temporary destruction) and will be added
 * to any existing set of URI permissions it already holds.
 *
 * @param resultCode The result code to propagate back to the originating
 *                   activity, often RESULT_CANCELED or RESULT_OK
 * @param data The data to propagate back to the originating activity.
 *
 * @see #RESULT_CANCELED
 * @see #RESULT_OK
 * @see #RESULT_FIRST_USER
 * @see #setResult(int)
 * @apiSince 1
 */

public final void setResult(int resultCode, android.content.Intent data) { throw new RuntimeException("Stub!"); }

/**
 * Return information about who launched this activity.  If the launching Intent
 * contains an {@link android.content.Intent#EXTRA_REFERRER Intent.EXTRA_REFERRER},
 * that will be returned as-is; otherwise, if known, an
 * {@link android.content.Intent#URI_ANDROID_APP_SCHEME Intent#URI_ANDROID_APP_SCHEME} referrer URI containing the
 * package name that started the Intent will be returned.  This may return null if no
 * referrer can be identified -- it is neither explicitly specified, nor is it known which
 * application package was involved.
 *
 * <p>If called while inside the handling of {@link #onNewIntent}, this function will
 * return the referrer that submitted that new intent to the activity.  Otherwise, it
 * always returns the referrer of the original Intent.</p>
 *
 * <p>Note that this is <em>not</em> a security feature -- you can not trust the
 * referrer information, applications can spoof it.</p>
 * @apiSince 22
 */

@androidx.annotation.Nullable
public android.net.Uri getReferrer() { throw new RuntimeException("Stub!"); }

/**
 * Override to generate the desired referrer for the content currently being shown
 * by the app.  The default implementation returns null, meaning the referrer will simply
 * be the android-app: of the package name of this activity.  Return a non-null Uri to
 * have that supplied as the {@link android.content.Intent#EXTRA_REFERRER Intent#EXTRA_REFERRER} of any activities started from it.
 * @apiSince 23
 */

public android.net.Uri onProvideReferrer() { throw new RuntimeException("Stub!"); }

/**
 * Return the name of the package that invoked this activity.  This is who
 * the data in {@link #setResult setResult()} will be sent to.  You can
 * use this information to validate that the recipient is allowed to
 * receive the data.
 *
 * <p class="note">Note: if the calling activity is not expecting a result (that is it
 * did not use the {@link #startActivityForResult}
 * form that includes a request code), then the calling package will be
 * null.</p>
 *
 * <p class="note">Note: prior to {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2},
 * the result from this method was unstable.  If the process hosting the calling
 * package was no longer running, it would return null instead of the proper package
 * name.  You can use {@link #getCallingActivity()} and retrieve the package name
 * from that instead.</p>
 *
 * @return The package of the activity that will receive your
 *         reply, or null if none.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String getCallingPackage() { throw new RuntimeException("Stub!"); }

/**
 * Return the name of the activity that invoked this activity.  This is
 * who the data in {@link #setResult setResult()} will be sent to.  You
 * can use this information to validate that the recipient is allowed to
 * receive the data.
 *
 * <p class="note">Note: if the calling activity is not expecting a result (that is it
 * did not use the {@link #startActivityForResult}
 * form that includes a request code), then the calling package will be
 * null.
 *
 * @return The ComponentName of the activity that will receive your
 *         reply, or null if none.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.content.ComponentName getCallingActivity() { throw new RuntimeException("Stub!"); }

/**
 * Control whether this activity's main window is visible.  This is intended
 * only for the special case of an activity that is not going to show a
 * UI itself, but can't just finish prior to onResume() because it needs
 * to wait for a service binding or such.  Setting this to false allows
 * you to prevent your UI from being shown during that time.
 *
 * <p>The default value for this is taken from the
 * {@link android.R.attr#windowNoDisplay} attribute of the activity's theme.
 * @apiSince 3
 */

public void setVisible(boolean visible) { throw new RuntimeException("Stub!"); }

/**
 * Check to see whether this activity is in the process of finishing,
 * either because you called {@link #finish} on it or someone else
 * has requested that it finished.  This is often used in
 * {@link #onPause} to determine whether the activity is simply pausing or
 * completely finishing.
 *
 * @return If the activity is finishing, returns true; else returns false.
 *
 * @see #finish
 * @apiSince 1
 */

public boolean isFinishing() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the final {@link #onDestroy()} call has been made
 * on the Activity, so this instance is now dead.
 * @apiSince 17
 */

public boolean isDestroyed() { throw new RuntimeException("Stub!"); }

/**
 * Check to see whether this activity is in the process of being destroyed in order to be
 * recreated with a new configuration. This is often used in
 * {@link #onStop} to determine whether the state needs to be cleaned up or will be passed
 * on to the next instance of the activity via {@link #onRetainNonConfigurationInstance()}.
 *
 * @return If the activity is being torn down in order to be recreated with a new configuration,
 * returns true; else returns false.
 * @apiSince 11
 */

public boolean isChangingConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * Cause this Activity to be recreated with a new instance.  This results
 * in essentially the same flow as when the Activity is created due to
 * a configuration change -- the current instance will go through its
 * lifecycle to {@link #onDestroy} and a new instance then created after it.
 * @apiSince 11
 */

public void recreate() { throw new RuntimeException("Stub!"); }

/**
 * Call this when your activity is done and should be closed.  The
 * ActivityResult is propagated back to whoever launched you via
 * onActivityResult().
 * @apiSince 1
 */

public void finish() { throw new RuntimeException("Stub!"); }

/**
 * Finish this activity as well as all activities immediately below it
 * in the current task that have the same affinity.  This is typically
 * used when an application can be launched on to another task (such as
 * from an ACTION_VIEW of a content type it understands) and the user
 * has used the up navigation to switch out of the current task and in
 * to its own task.  In this case, if the user has navigated down into
 * any other activities of the second application, all of those should
 * be removed from the original task as part of the task switch.
 *
 * <p>Note that this finish does <em>not</em> allow you to deliver results
 * to the previous activity, and an exception will be thrown if you are trying
 * to do so.</p>
 * @apiSince 16
 */

public void finishAffinity() { throw new RuntimeException("Stub!"); }

/**
 * This is called when a child activity of this one calls its
 * {@link #finish} method.  The default implementation simply calls
 * finish() on this activity (the parent), finishing the entire group.
 *
 * @param child The activity making the call.
 *
 * @see #finish
 * @apiSince 1
 */

public void finishFromChild(android.app.Activity child) { throw new RuntimeException("Stub!"); }

/**
 * Reverses the Activity Scene entry Transition and triggers the calling Activity
 * to reverse its exit Transition. When the exit Transition completes,
 * {@link #finish()} is called. If no entry Transition was used, finish() is called
 * immediately and the Activity exit Transition is run.
 * @see android.app.ActivityOptions#makeSceneTransitionAnimation(Activity, android.util.Pair[])
 * @apiSince 21
 */

public void finishAfterTransition() { throw new RuntimeException("Stub!"); }

/**
 * Force finish another activity that you had previously started with
 * {@link #startActivityForResult}.
 *
 * @param requestCode The request code of the activity that you had
 *                    given to startActivityForResult().  If there are multiple
 *                    activities started with this request code, they
 *                    will all be finished.
 * @apiSince 1
 */

public void finishActivity(int requestCode) { throw new RuntimeException("Stub!"); }

/**
 * This is called when a child activity of this one calls its
 * finishActivity().
 *
 * @param child The activity making the call.
 * This value must never be {@code null}.
 * @param requestCode Request code that had been used to start the
 *                    activity.
 * @apiSince 1
 */

public void finishActivityFromChild(@androidx.annotation.NonNull android.app.Activity child, int requestCode) { throw new RuntimeException("Stub!"); }

/**
 * Call this when your activity is done and should be closed and the task should be completely
 * removed as a part of finishing the root activity of the task.
 * @apiSince 21
 */

public void finishAndRemoveTask() { throw new RuntimeException("Stub!"); }

/**
 * Ask that the local app instance of this activity be released to free up its memory.
 * This is asking for the activity to be destroyed, but does <b>not</b> finish the activity --
 * a new instance of the activity will later be re-created if needed due to the user
 * navigating back to it.
 *
 * @return Returns true if the activity was in a state that it has started the process
 * of destroying its current instance; returns false if for any reason this could not
 * be done: it is currently visible to the user, it is already being destroyed, it is
 * being finished, it hasn't yet saved its state, etc.
 * @apiSince 21
 */

public boolean releaseInstance() { throw new RuntimeException("Stub!"); }

/**
 * Called when an activity you launched exits, giving you the requestCode
 * you started it with, the resultCode it returned, and any additional
 * data from it.  The <var>resultCode</var> will be
 * {@link #RESULT_CANCELED} if the activity explicitly returned that,
 * didn't return any result, or crashed during its operation.
 *
 * <p>You will receive this call immediately before onResume() when your
 * activity is re-starting.
 *
 * <p>This method is never invoked if your activity sets
 * {@link android.R.styleable#AndroidManifestActivity_noHistory noHistory} to
 * <code>true</code>.
 *
 * @param requestCode The integer request code originally supplied to
 *                    startActivityForResult(), allowing you to identify who this
 *                    result came from.
 * @param resultCode The integer result code returned by the child activity
 *                   through its setResult().
 * @param data An Intent, which can return result data to the caller
 *               (various data can be attached to Intent "extras").
 *
 * @see #startActivityForResult
 * @see #createPendingResult
 * @see #setResult(int)
 * @apiSince 1
 */

protected void onActivityResult(int requestCode, int resultCode, android.content.Intent data) { throw new RuntimeException("Stub!"); }

/**
 * Called when an activity you launched with an activity transition exposes this
 * Activity through a returning activity transition, giving you the resultCode
 * and any additional data from it. This method will only be called if the activity
 * set a result code other than {@link #RESULT_CANCELED} and it supports activity
 * transitions with {@link android.view.Window#FEATURE_ACTIVITY_TRANSITIONS Window#FEATURE_ACTIVITY_TRANSITIONS}.
 *
 * <p>The purpose of this function is to let the called Activity send a hint about
 * its state so that this underlying Activity can prepare to be exposed. A call to
 * this method does not guarantee that the called Activity has or will be exiting soon.
 * It only indicates that it will expose this Activity's Window and it has
 * some data to pass to prepare it.</p>
 *
 * @param resultCode The integer result code returned by the child activity
 *                   through its setResult().
 * @param data An Intent, which can return result data to the caller
 *               (various data can be attached to Intent "extras").
 * @apiSince 21
 */

public void onActivityReenter(int resultCode, android.content.Intent data) { throw new RuntimeException("Stub!"); }

/**
 * Create a new PendingIntent object which you can hand to others
 * for them to use to send result data back to your
 * {@link #onActivityResult} callback.  The created object will be either
 * one-shot (becoming invalid after a result is sent back) or multiple
 * (allowing any number of results to be sent through it).
 *
 * @param requestCode Private request code for the sender that will be
 * associated with the result data when it is returned.  The sender can not
 * modify this value, allowing you to identify incoming results.
 * @param data Default data to supply in the result, which may be modified
 * by the sender.
 * This value must never be {@code null}.
 * @param flags May be {@link android.app.PendingIntent#FLAG_ONE_SHOT PendingIntent#FLAG_ONE_SHOT},
 * {@link android.app.PendingIntent#FLAG_NO_CREATE PendingIntent#FLAG_NO_CREATE},
 * {@link android.app.PendingIntent#FLAG_CANCEL_CURRENT PendingIntent#FLAG_CANCEL_CURRENT},
 * {@link android.app.PendingIntent#FLAG_UPDATE_CURRENT PendingIntent#FLAG_UPDATE_CURRENT},
 * or any of the flags as supported by
 * {@link android.content.Intent#fillIn Intent#fillIn} to control which unspecified parts
 * of the intent that can be supplied when the actual send happens.
 *
 * Value is either <code>0</code> or a combination of {@link android.app.PendingIntent#FLAG_ONE_SHOT}, {@link android.app.PendingIntent#FLAG_NO_CREATE}, {@link android.app.PendingIntent#FLAG_CANCEL_CURRENT}, {@link android.app.PendingIntent#FLAG_UPDATE_CURRENT}, {@link android.app.PendingIntent#FLAG_IMMUTABLE}, {@link android.content.Intent#FILL_IN_ACTION}, {@link android.content.Intent#FILL_IN_DATA}, {@link android.content.Intent#FILL_IN_CATEGORIES}, {@link android.content.Intent#FILL_IN_COMPONENT}, {@link android.content.Intent#FILL_IN_PACKAGE}, {@link android.content.Intent#FILL_IN_SOURCE_BOUNDS}, {@link android.content.Intent#FILL_IN_SELECTOR}, and {@link android.content.Intent#FILL_IN_CLIP_DATA}
 * @return Returns an existing or new PendingIntent matching the given
 * parameters.  May return null only if
 * {@link android.app.PendingIntent#FLAG_NO_CREATE PendingIntent#FLAG_NO_CREATE} has been
 * supplied.
 *
 * @see android.app.PendingIntent
 * @apiSince 1
 */

public android.app.PendingIntent createPendingResult(int requestCode, @androidx.annotation.NonNull android.content.Intent data, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Change the desired orientation of this activity.  If the activity
 * is currently in the foreground or otherwise impacting the screen
 * orientation, the screen will immediately be changed (possibly causing
 * the activity to be restarted). Otherwise, this will be used the next
 * time the activity is visible.
 *
 * @param requestedOrientation An orientation constant as used in
 * {@link android.content.pm.ActivityInfo#screenOrientation ActivityInfo#screenOrientation}.
 
 * Value is android.content.pm.ActivityInfo.SCREEN_ORIENTATION_UNSET, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_UNSPECIFIED}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_LANDSCAPE}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_PORTRAIT}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_USER}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_BEHIND}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_SENSOR}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_NOSENSOR}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_SENSOR_LANDSCAPE}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_SENSOR_PORTRAIT}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_REVERSE_LANDSCAPE}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_REVERSE_PORTRAIT}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_FULL_SENSOR}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_USER_LANDSCAPE}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_USER_PORTRAIT}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_FULL_USER}, or {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_LOCKED}
 * @apiSince 1
 */

public void setRequestedOrientation(int requestedOrientation) { throw new RuntimeException("Stub!"); }

/**
 * Return the current requested orientation of the activity.  This will
 * either be the orientation requested in its component's manifest, or
 * the last requested orientation given to
 * {@link #setRequestedOrientation(int)}.
 *
 * @return Returns an orientation constant as used in
 * {@link android.content.pm.ActivityInfo#screenOrientation ActivityInfo#screenOrientation}.
 
 * Value is android.content.pm.ActivityInfo.SCREEN_ORIENTATION_UNSET, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_UNSPECIFIED}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_LANDSCAPE}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_PORTRAIT}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_USER}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_BEHIND}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_SENSOR}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_NOSENSOR}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_SENSOR_LANDSCAPE}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_SENSOR_PORTRAIT}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_REVERSE_LANDSCAPE}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_REVERSE_PORTRAIT}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_FULL_SENSOR}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_USER_LANDSCAPE}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_USER_PORTRAIT}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_FULL_USER}, or {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_LOCKED}
 * @apiSince 1
 */

public int getRequestedOrientation() { throw new RuntimeException("Stub!"); }

/**
 * Return the identifier of the task this activity is in.  This identifier
 * will remain the same for the lifetime of the activity.
 *
 * @return Task identifier, an opaque integer.
 * @apiSince 1
 */

public int getTaskId() { throw new RuntimeException("Stub!"); }

/**
 * Return whether this activity is the root of a task.  The root is the
 * first activity in a task.
 *
 * @return True if this is the root activity, else false.
 * @apiSince 1
 */

public boolean isTaskRoot() { throw new RuntimeException("Stub!"); }

/**
 * Move the task containing this activity to the back of the activity
 * stack.  The activity's order within the task is unchanged.
 *
 * @param nonRoot If false then this only works if the activity is the root
 *                of a task; if true it will work for any activity in
 *                a task.
 *
 * @return If the task was moved (or it was already at the
 *         back) true is returned, else false.
 * @apiSince 1
 */

public boolean moveTaskToBack(boolean nonRoot) { throw new RuntimeException("Stub!"); }

/**
 * Returns class name for this activity with the package prefix removed.
 * This is the default name used to read and write settings.
 *
 * @return The local class name.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getLocalClassName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the complete component name of this activity.
 *
 * @return Returns the complete component name for this activity
 * @apiSince 1
 */

public android.content.ComponentName getComponentName() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a {@link android.content.SharedPreferences SharedPreferences} object for accessing preferences
 * that are private to this activity.  This simply calls the underlying
 * {@link #getSharedPreferences(java.lang.String,int)} method by passing in this activity's
 * class name as the preferences name.
 *
 * @param mode Operating mode.  Use {@link #MODE_PRIVATE} for the default
 *             operation.
 *
 * Value is either <code>0</code> or a combination of {@link android.content.Context#MODE_PRIVATE}, {@link android.content.Context#MODE_WORLD_READABLE}, {@link android.content.Context#MODE_WORLD_WRITEABLE}, and {@link android.content.Context#MODE_MULTI_PROCESS}
 * @return Returns the single SharedPreferences instance that can be used
 *         to retrieve and modify the preference values.
 * @apiSince 1
 */

public android.content.SharedPreferences getPreferences(int mode) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param name Value is {@link android.content.Context#POWER_SERVICE}, {@link android.content.Context#WINDOW_SERVICE}, {@link android.content.Context#LAYOUT_INFLATER_SERVICE}, {@link android.content.Context#ACCOUNT_SERVICE}, {@link android.content.Context#ACTIVITY_SERVICE}, {@link android.content.Context#ALARM_SERVICE}, {@link android.content.Context#NOTIFICATION_SERVICE}, {@link android.content.Context#ACCESSIBILITY_SERVICE}, {@link android.content.Context#CAPTIONING_SERVICE}, {@link android.content.Context#KEYGUARD_SERVICE}, {@link android.content.Context#LOCATION_SERVICE}, {@link android.content.Context#SEARCH_SERVICE}, {@link android.content.Context#SENSOR_SERVICE}, android.content.Context.SENSOR_PRIVACY_SERVICE, {@link android.content.Context#STORAGE_SERVICE}, {@link android.content.Context#STORAGE_STATS_SERVICE}, {@link android.content.Context#WALLPAPER_SERVICE}, android.content.Context.TIME_ZONE_RULES_MANAGER_SERVICE, {@link android.content.Context#VIBRATOR_SERVICE}, {@link android.content.Context#CONNECTIVITY_SERVICE}, {@link android.content.Context#IPSEC_SERVICE}, android.content.Context.TEST_NETWORK_SERVICE, {@link android.content.Context#NETWORK_STATS_SERVICE}, {@link android.content.Context#WIFI_SERVICE}, {@link android.content.Context#WIFI_AWARE_SERVICE}, {@link android.content.Context#WIFI_P2P_SERVICE}, android.content.Context.WIFI_SCANNING_SERVICE, {@link android.content.Context#WIFI_RTT_RANGING_SERVICE}, {@link android.content.Context#NSD_SERVICE}, {@link android.content.Context#AUDIO_SERVICE}, {@link android.content.Context#FINGERPRINT_SERVICE}, {@link android.content.Context#BIOMETRIC_SERVICE}, {@link android.content.Context#MEDIA_ROUTER_SERVICE}, {@link android.content.Context#TELEPHONY_SERVICE}, {@link android.content.Context#TELEPHONY_SUBSCRIPTION_SERVICE}, {@link android.content.Context#CARRIER_CONFIG_SERVICE}, {@link android.content.Context#EUICC_SERVICE}, {@link android.content.Context#TELECOM_SERVICE}, {@link android.content.Context#CLIPBOARD_SERVICE}, {@link android.content.Context#INPUT_METHOD_SERVICE}, {@link android.content.Context#TEXT_SERVICES_MANAGER_SERVICE}, {@link android.content.Context#TEXT_CLASSIFICATION_SERVICE}, {@link android.content.Context#APPWIDGET_SERVICE}, android.content.Context.ROLLBACK_SERVICE, {@link android.content.Context#DROPBOX_SERVICE}, {@link android.content.Context#DEVICE_POLICY_SERVICE}, {@link android.content.Context#UI_MODE_SERVICE}, {@link android.content.Context#DOWNLOAD_SERVICE}, {@link android.content.Context#NFC_SERVICE}, {@link android.content.Context#BLUETOOTH_SERVICE}, {@link android.content.Context#USB_SERVICE}, {@link android.content.Context#LAUNCHER_APPS_SERVICE}, {@link android.content.Context#INPUT_SERVICE}, {@link android.content.Context#DISPLAY_SERVICE}, {@link android.content.Context#USER_SERVICE}, {@link android.content.Context#RESTRICTIONS_SERVICE}, {@link android.content.Context#APP_OPS_SERVICE}, {@link android.content.Context#ROLE_SERVICE}, {@link android.content.Context#CAMERA_SERVICE}, {@link android.content.Context#PRINT_SERVICE}, {@link android.content.Context#CONSUMER_IR_SERVICE}, {@link android.content.Context#TV_INPUT_SERVICE}, {@link android.content.Context#USAGE_STATS_SERVICE}, {@link android.content.Context#MEDIA_SESSION_SERVICE}, {@link android.content.Context#BATTERY_SERVICE}, {@link android.content.Context#JOB_SCHEDULER_SERVICE}, {@link android.content.Context#MEDIA_PROJECTION_SERVICE}, {@link android.content.Context#MIDI_SERVICE}, android.content.Context.RADIO_SERVICE, {@link android.content.Context#HARDWARE_PROPERTIES_SERVICE}, {@link android.content.Context#SHORTCUT_SERVICE}, {@link android.content.Context#SYSTEM_HEALTH_SERVICE}, {@link android.content.Context#COMPANION_DEVICE_SERVICE}, {@link android.content.Context#CROSS_PROFILE_APPS_SERVICE}, or android.content.Context.PERMISSION_SERVICE
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public java.lang.Object getSystemService(@androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Change the title associated with this activity.  If this is a
 * top-level activity, the title for its window will change.  If it
 * is an embedded activity, the parent can do whatever it wants
 * with it.
 * @apiSince 1
 */

public void setTitle(java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Change the title associated with this activity.  If this is a
 * top-level activity, the title for its window will change.  If it
 * is an embedded activity, the parent can do whatever it wants
 * with it.
 * @apiSince 1
 */

public void setTitle(int titleId) { throw new RuntimeException("Stub!"); }

/**
 * Change the color of the title associated with this activity.
 * <p>
 * This method is deprecated starting in API Level 11 and replaced by action
 * bar styles. For information on styling the Action Bar, read the <a
 * href="{@docRoot} guide/topics/ui/actionbar.html">Action Bar</a> developer
 * guide.
 *
 * @deprecated Use action bar styles instead.
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void setTitleColor(int textColor) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final java.lang.CharSequence getTitle() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final int getTitleColor() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onTitleChanged(java.lang.CharSequence title, int color) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onChildTitleChanged(android.app.Activity childActivity, java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Sets information describing the task with this activity for presentation inside the Recents
 * System UI. When {@link android.app.ActivityManager#getRecentTasks ActivityManager#getRecentTasks} is called, the activities of each task
 * are traversed in order from the topmost activity to the bottommost. The traversal continues
 * for each property until a suitable value is found. For each task the taskDescription will be
 * returned in {@link android.app.ActivityManager.TaskDescription}.
 *
 * @see android.app.ActivityManager#getRecentTasks
 * @see android.app.ActivityManager.TaskDescription
 *
 * @param taskDescription The TaskDescription properties that describe the task with this activity
 * @apiSince 21
 */

public void setTaskDescription(android.app.ActivityManager.TaskDescription taskDescription) { throw new RuntimeException("Stub!"); }

/**
 * Sets the visibility of the progress bar in the title.
 * <p>
 * In order for the progress bar to be shown, the feature must be requested
 * via {@link #requestWindowFeature(int)}.
 *
 * @param visible Whether to show the progress bars in the title.
 * @deprecated No longer supported starting in API 21.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public final void setProgressBarVisibility(boolean visible) { throw new RuntimeException("Stub!"); }

/**
 * Sets the visibility of the indeterminate progress bar in the title.
 * <p>
 * In order for the progress bar to be shown, the feature must be requested
 * via {@link #requestWindowFeature(int)}.
 *
 * @param visible Whether to show the progress bars in the title.
 * @deprecated No longer supported starting in API 21.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public final void setProgressBarIndeterminateVisibility(boolean visible) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the horizontal progress bar in the title should be indeterminate (the circular
 * is always indeterminate).
 * <p>
 * In order for the progress bar to be shown, the feature must be requested
 * via {@link #requestWindowFeature(int)}.
 *
 * @param indeterminate Whether the horizontal progress bar should be indeterminate.
 * @deprecated No longer supported starting in API 21.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public final void setProgressBarIndeterminate(boolean indeterminate) { throw new RuntimeException("Stub!"); }

/**
 * Sets the progress for the progress bars in the title.
 * <p>
 * In order for the progress bar to be shown, the feature must be requested
 * via {@link #requestWindowFeature(int)}.
 *
 * @param progress The progress for the progress bar. Valid ranges are from
 *            0 to 10000 (both inclusive). If 10000 is given, the progress
 *            bar will be completely filled and will fade out.
 * @deprecated No longer supported starting in API 21.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public final void setProgress(int progress) { throw new RuntimeException("Stub!"); }

/**
 * Sets the secondary progress for the progress bar in the title. This
 * progress is drawn between the primary progress (set via
 * {@link #setProgress(int)} and the background. It can be ideal for media
 * scenarios such as showing the buffering progress while the default
 * progress shows the play progress.
 * <p>
 * In order for the progress bar to be shown, the feature must be requested
 * via {@link #requestWindowFeature(int)}.
 *
 * @param secondaryProgress The secondary progress for the progress bar. Valid ranges are from
 *            0 to 10000 (both inclusive).
 * @deprecated No longer supported starting in API 21.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public final void setSecondaryProgress(int secondaryProgress) { throw new RuntimeException("Stub!"); }

/**
 * Suggests an audio stream whose volume should be changed by the hardware
 * volume controls.
 * <p>
 * The suggested audio stream will be tied to the window of this Activity.
 * Volume requests which are received while the Activity is in the
 * foreground will affect this stream.
 * <p>
 * It is not guaranteed that the hardware volume controls will always change
 * this stream's volume (for example, if a call is in progress, its stream's
 * volume may be changed instead). To reset back to the default, use
 * {@link android.media.AudioManager#USE_DEFAULT_STREAM_TYPE AudioManager#USE_DEFAULT_STREAM_TYPE}.
 *
 * @param streamType The type of the audio stream whose volume should be
 *            changed by the hardware volume controls.
 * @apiSince 1
 */

public final void setVolumeControlStream(int streamType) { throw new RuntimeException("Stub!"); }

/**
 * Gets the suggested audio stream whose volume should be changed by the
 * hardware volume controls.
 *
 * @return The suggested audio stream type whose volume should be changed by
 *         the hardware volume controls.
 * @see #setVolumeControlStream(int)
 * @apiSince 1
 */

public final int getVolumeControlStream() { throw new RuntimeException("Stub!"); }

/**
 * Sets a {@link android.media.session.MediaController MediaController} to send media keys and volume changes to.
 * <p>
 * The controller will be tied to the window of this Activity. Media key and
 * volume events which are received while the Activity is in the foreground
 * will be forwarded to the controller and used to invoke transport controls
 * or adjust the volume. This may be used instead of or in addition to
 * {@link #setVolumeControlStream} to affect a specific session instead of a
 * specific stream.
 * <p>
 * It is not guaranteed that the hardware volume controls will always change
 * this session's volume (for example, if a call is in progress, its
 * stream's volume may be changed instead). To reset back to the default use
 * null as the controller.
 *
 * @param controller The controller for the session which should receive
 *            media keys and volume changes.
 * @apiSince 21
 */

public final void setMediaController(android.media.session.MediaController controller) { throw new RuntimeException("Stub!"); }

/**
 * Gets the controller which should be receiving media key and volume events
 * while this activity is in the foreground.
 *
 * @return The controller which should receive events.
 * @see #setMediaController(android.media.session.MediaController)
 * @apiSince 21
 */

public final android.media.session.MediaController getMediaController() { throw new RuntimeException("Stub!"); }

/**
 * Runs the specified action on the UI thread. If the current thread is the UI
 * thread, then the action is executed immediately. If the current thread is
 * not the UI thread, the action is posted to the event queue of the UI thread.
 *
 * @param action the action to run on the UI thread
 * @apiSince 1
 */

public final void runOnUiThread(java.lang.Runnable action) { throw new RuntimeException("Stub!"); }

/**
 * Standard implementation of
 * {@link android.view.LayoutInflater.Factory#onCreateView} used when
 * inflating with the LayoutInflater returned by {@link #getSystemService}.
 * This implementation does nothing and is for
 * pre-{@link android.os.Build.VERSION_CODES#HONEYCOMB} apps.  Newer apps
 * should use {@link #onCreateView(android.view.View,java.lang.String,android.content.Context,android.util.AttributeSet)}.
 *
 * @see android.view.LayoutInflater#createView
 * @see android.view.Window#getLayoutInflater
 
 * @param name This value must never be {@code null}.
 * @param context This value must never be {@code null}.
 * @param attrs This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.view.View onCreateView(@androidx.annotation.NonNull java.lang.String name, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Standard implementation of
 * {@link android.view.LayoutInflater.Factory2#onCreateView(View, String, Context, AttributeSet)}
 * used when inflating with the LayoutInflater returned by {@link #getSystemService}.
 * This implementation handles <fragment> tags to embed fragments inside
 * of the activity.
 *
 * @see android.view.LayoutInflater#createView
 * @see android.view.Window#getLayoutInflater
 
 * @param parent This value may be {@code null}.
 * @param name This value must never be {@code null}.
 * @param context This value must never be {@code null}.
 * @param attrs This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.Nullable
public android.view.View onCreateView(@androidx.annotation.Nullable android.view.View parent, @androidx.annotation.NonNull java.lang.String name, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Print the Activity's state into the given stream.  This gets invoked if
 * you run "adb shell dumpsys activity &lt;activity_component_name&gt;".
 *
 * @param prefix Desired prefix to prepend at each line of output.
 * This value must never be {@code null}.
 * @param fd The raw file descriptor that the dump is being sent to.
 * This value may be {@code null}.
 * @param writer The PrintWriter to which you should dump your state.  This will be
 * closed for you after you return.
 * This value must never be {@code null}.
 * @param args additional arguments to the dump request.
 
 * This value may be {@code null}.
 * @apiSince 11
 */

public void dump(@androidx.annotation.NonNull java.lang.String prefix, @androidx.annotation.Nullable java.io.FileDescriptor fd, @androidx.annotation.NonNull java.io.PrintWriter writer, @androidx.annotation.Nullable java.lang.String[] args) { throw new RuntimeException("Stub!"); }

/**
 * Bit indicating that this activity is "immersive" and should not be
 * interrupted by notifications if possible.
 *
 * This value is initially set by the manifest property
 * <code>android:immersive</code> but may be changed at runtime by
 * {@link #setImmersive}.
 *
 * @see #setImmersive(boolean)
 * @see android.content.pm.ActivityInfo#FLAG_IMMERSIVE
 * @apiSince 18
 */

public boolean isImmersive() { throw new RuntimeException("Stub!"); }

/**
 * Activities that want to remain visible behind a translucent activity above them must call
 * this method anytime between the start of {@link #onResume()} and the return from
 * {@link #onPause()}. If this call is successful then the activity will remain visible after
 * {@link #onPause()} is called, and is allowed to continue playing media in the background.
 *
 * <p>The actions of this call are reset each time that this activity is brought to the
 * front. That is, every time {@link #onResume()} is called the activity will be assumed
 * to not have requested visible behind. Therefore, if you want this activity to continue to
 * be visible in the background you must call this method again.
 *
 * <p>Only fullscreen opaque activities may make this call. I.e. this call is a nop
 * for dialog and translucent activities.
 *
 * <p>Under all circumstances, the activity must stop playing and release resources prior to or
 * within a call to {@link #onVisibleBehindCanceled()} or if this call returns false.
 *
 * <p>False will be returned any time this method is called between the return of onPause and
 *      the next call to onResume.
 *
 * @deprecated This method's functionality is no longer supported as of
 *             {@link android.os.Build.VERSION_CODES#O} and will be removed in a future release.
 *
 * @param visible true to notify the system that the activity wishes to be visible behind other
 *                translucent activities, false to indicate otherwise. Resources must be
 *                released when passing false to this method.
 *
 * @return the resulting visibiity state. If true the activity will remain visible beyond
 *      {@link #onPause()} if the next activity is translucent or not fullscreen. If false
 *      then the activity may not count on being visible behind other translucent activities,
 *      and must stop any media playback and release resources.
 *      Returning false may occur in lieu of a call to {@link #onVisibleBehindCanceled()} so
 *      the return value must be checked.
 *
 * @see #onVisibleBehindCanceled()
 * @apiSince 21
 * @deprecatedSince 26
 */

@Deprecated
public boolean requestVisibleBehind(boolean visible) { throw new RuntimeException("Stub!"); }

/**
 * Called when a translucent activity over this activity is becoming opaque or another
 * activity is being launched. Activities that override this method must call
 * <code>super.onVisibleBehindCanceled()</code> or a SuperNotCalledException will be thrown.
 *
 * <p>When this method is called the activity has 500 msec to release any resources it may be
 * using while visible in the background.
 * If the activity has not returned from this method in 500 msec the system will destroy
 * the activity and kill the process in order to recover the resources for another
 * process. Otherwise {@link #onStop()} will be called following return.
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @see #requestVisibleBehind(boolean)
 *
 * @deprecated This method's functionality is no longer supported as of
 * {@link android.os.Build.VERSION_CODES#O} and will be removed in a future release.
 * @apiSince 21
 * @deprecatedSince 26
 */

@Deprecated
public void onVisibleBehindCanceled() { throw new RuntimeException("Stub!"); }

/**
 * Activities cannot draw during the period that their windows are animating in. In order
 * to know when it is safe to begin drawing they can override this method which will be
 * called when the entering animation has completed.
 * @apiSince 21
 */

public void onEnterAnimationComplete() { throw new RuntimeException("Stub!"); }

/**
 * Adjust the current immersive mode setting.
 *
 * Note that changing this value will have no effect on the activity's
 * {@link android.content.pm.ActivityInfo} structure; that is, if
 * <code>android:immersive</code> is set to <code>true</code>
 * in the application's manifest entry for this activity, the {@link
 * android.content.pm.ActivityInfo#flags ActivityInfo.flags} member will
 * always have its {@link android.content.pm.ActivityInfo#FLAG_IMMERSIVE
 * FLAG_IMMERSIVE} bit set.
 *
 * @see #isImmersive()
 * @see android.content.pm.ActivityInfo#FLAG_IMMERSIVE
 * @apiSince 18
 */

public void setImmersive(boolean i) { throw new RuntimeException("Stub!"); }

/**
 * Enable or disable virtual reality (VR) mode for this Activity.
 *
 * <p>VR mode is a hint to Android system to switch to a mode optimized for VR applications
 * while this Activity has user focus.</p>
 *
 * <p>It is recommended that applications additionally declare
 * {@link android.R.attr#enableVrMode} in their manifest to allow for smooth activity
 * transitions when switching between VR activities.</p>
 *
 * <p>If the requested {@link android.service.vr.VrListenerService} component is not available,
 * VR mode will not be started.  Developers can handle this case as follows:</p>
 *
 * <pre>
 * String servicePackage = "com.whatever.app";
 * String serviceClass = "com.whatever.app.MyVrListenerService";
 *
 * // Name of the component of the VrListenerService to start.
 * ComponentName serviceComponent = new ComponentName(servicePackage, serviceClass);
 *
 * try {
 *    setVrModeEnabled(true, myComponentName);
 * } catch (PackageManager.NameNotFoundException e) {
 *        List&lt;ApplicationInfo> installed = getPackageManager().getInstalledApplications(0);
 *        boolean isInstalled = false;
 *        for (ApplicationInfo app : installed) {
 *            if (app.packageName.equals(servicePackage)) {
 *                isInstalled = true;
 *                break;
 *            }
 *        }
 *        if (isInstalled) {
 *            // Package is installed, but not enabled in Settings.  Let user enable it.
 *            startActivity(new Intent(Settings.ACTION_VR_LISTENER_SETTINGS));
 *        } else {
 *            // Package is not installed.  Send an intent to download this.
 *            sentIntentToLaunchAppStore(servicePackage);
 *        }
 * }
 * </pre>
 *
 * @param enabled {@code true} to enable this mode.
 * @param requestedComponent the name of the component to use as a
 *        {@link android.service.vr.VrListenerService} while VR mode is enabled.
 *
 * This value must never be {@code null}.
 * @throws android.content.pm.PackageManager.NameNotFoundException if the given component
 *    to run as a {@link android.service.vr.VrListenerService} is not installed, or has
 *    not been enabled in user settings.
 *
 * @see android.content.pm.PackageManager#FEATURE_VR_MODE_HIGH_PERFORMANCE
 * @see android.service.vr.VrListenerService
 * @see android.provider.Settings#ACTION_VR_LISTENER_SETTINGS
 * @see android.R.attr#enableVrMode
 * @apiSince 24
 */

public void setVrModeEnabled(boolean enabled, @androidx.annotation.NonNull android.content.ComponentName requestedComponent) throws android.content.pm.PackageManager.NameNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Start an action mode of the default type {@link android.view.ActionMode#TYPE_PRIMARY ActionMode#TYPE_PRIMARY}.
 *
 * @param callback Callback that will manage lifecycle events for this action mode
 * @return The ActionMode that was started, or null if it was canceled
 *
 * @see android.view.ActionMode
 * @apiSince 11
 */

@androidx.annotation.Nullable
public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Start an action mode of the given type.
 *
 * @param callback Callback that will manage lifecycle events for this action mode
 * @param type One of {@link android.view.ActionMode#TYPE_PRIMARY ActionMode#TYPE_PRIMARY} or {@link android.view.ActionMode#TYPE_FLOATING ActionMode#TYPE_FLOATING}.
 * @return The ActionMode that was started, or null if it was canceled
 *
 * @see android.view.ActionMode
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback, int type) { throw new RuntimeException("Stub!"); }

/**
 * Give the Activity a chance to control the UI for an action mode requested
 * by the system.
 *
 * <p>Note: If you are looking for a notification callback that an action mode
 * has been started for this activity, see {@link #onActionModeStarted(android.view.ActionMode)}.</p>
 *
 * @param callback The callback that should control the new action mode
 * @return The new action mode, or <code>null</code> if the activity does not want to
 *         provide special handling for this action mode. (It will be handled by the system.)
 * @apiSince 11
 */

@androidx.annotation.Nullable
public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @return This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int type) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the Activity that an action mode has been started.
 * Activity subclasses overriding this method should call the superclass implementation.
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @param mode The new action mode.
 * @apiSince 11
 */

public void onActionModeStarted(android.view.ActionMode mode) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the activity that an action mode has finished.
 * Activity subclasses overriding this method should call the superclass implementation.
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @param mode The action mode that just finished.
 * @apiSince 11
 */

public void onActionModeFinished(android.view.ActionMode mode) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the app should recreate the task when navigating 'up' from this activity
 * by using targetIntent.
 *
 * <p>If this method returns false the app can trivially call
 * {@link #navigateUpTo(android.content.Intent)} using the same parameters to correctly perform
 * up navigation. If this method returns false, the app should synthesize a new task stack
 * by using {@link android.app.TaskStackBuilder TaskStackBuilder} or another similar mechanism to perform up navigation.</p>
 *
 * @param targetIntent An intent representing the target destination for up navigation
 * @return true if navigating up should recreate a new task stack, false if the same task
 *         should be used for the destination
 * @apiSince 16
 */

public boolean shouldUpRecreateTask(android.content.Intent targetIntent) { throw new RuntimeException("Stub!"); }

/**
 * Navigate from this activity to the activity specified by upIntent, finishing this activity
 * in the process. If the activity indicated by upIntent already exists in the task's history,
 * this activity and all others before the indicated activity in the history stack will be
 * finished.
 *
 * <p>If the indicated activity does not appear in the history stack, this will finish
 * each activity in this task until the root activity of the task is reached, resulting in
 * an "in-app home" behavior. This can be useful in apps with a complex navigation hierarchy
 * when an activity may be reached by a path not passing through a canonical parent
 * activity.</p>
 *
 * <p>This method should be used when performing up navigation from within the same task
 * as the destination. If up navigation should cross tasks in some cases, see
 * {@link #shouldUpRecreateTask(android.content.Intent)}.</p>
 *
 * @param upIntent An intent representing the target destination for up navigation
 *
 * @return true if up navigation successfully reached the activity indicated by upIntent and
 *         upIntent was delivered to it. false if an instance of the indicated activity could
 *         not be found and this activity was simply finished normally.
 * @apiSince 16
 */

public boolean navigateUpTo(android.content.Intent upIntent) { throw new RuntimeException("Stub!"); }

/**
 * This is called when a child activity of this one calls its
 * {@link #navigateUpTo} method.  The default implementation simply calls
 * navigateUpTo(upIntent) on this activity (the parent).
 *
 * @param child The activity making the call.
 * @param upIntent An intent representing the target destination for up navigation
 *
 * @return true if up navigation successfully reached the activity indicated by upIntent and
 *         upIntent was delivered to it. false if an instance of the indicated activity could
 *         not be found and this activity was simply finished normally.
 * @apiSince 16
 */

public boolean navigateUpToFromChild(android.app.Activity child, android.content.Intent upIntent) { throw new RuntimeException("Stub!"); }

/**
 * Obtain an {@link android.content.Intent Intent} that will launch an explicit target activity specified by
 * this activity's logical parent. The logical parent is named in the application's manifest
 * by the {@link android.R.attr#parentActivityName parentActivityName} attribute.
 * Activity subclasses may override this method to modify the Intent returned by
 * super.getParentActivityIntent() or to implement a different mechanism of retrieving
 * the parent intent entirely.
 *
 * @return a new Intent targeting the defined parent of this activity or null if
 *         there is no valid parent.
 * @apiSince 16
 */

@androidx.annotation.Nullable
public android.content.Intent getParentActivityIntent() { throw new RuntimeException("Stub!"); }

/**
 * When {@link android.app.ActivityOptions#makeSceneTransitionAnimation(Activity,
 * android.view.View, String)} was used to start an Activity, <var>callback</var>
 * will be called to handle shared elements on the <i>launched</i> Activity. This requires
 * {@link android.view.Window#FEATURE_ACTIVITY_TRANSITIONS Window#FEATURE_ACTIVITY_TRANSITIONS}.
 *
 * @param callback Used to manipulate shared element transitions on the launched Activity.
 * @apiSince 21
 */

public void setEnterSharedElementCallback(android.app.SharedElementCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * When {@link android.app.ActivityOptions#makeSceneTransitionAnimation(Activity,
 * android.view.View, String)} was used to start an Activity, <var>callback</var>
 * will be called to handle shared elements on the <i>launching</i> Activity. Most
 * calls will only come when returning from the started Activity.
 * This requires {@link android.view.Window#FEATURE_ACTIVITY_TRANSITIONS Window#FEATURE_ACTIVITY_TRANSITIONS}.
 *
 * @param callback Used to manipulate shared element transitions on the launching Activity.
 * @apiSince 21
 */

public void setExitSharedElementCallback(android.app.SharedElementCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Postpone the entering activity transition when Activity was started with
 * {@link android.app.ActivityOptions#makeSceneTransitionAnimation(Activity,
 * android.util.Pair[])}.
 * <p>This method gives the Activity the ability to delay starting the entering and
 * shared element transitions until all data is loaded. Until then, the Activity won't
 * draw into its window, leaving the window transparent. This may also cause the
 * returning animation to be delayed until data is ready. This method should be
 * called in {@link #onCreate(android.os.Bundle)} or in
 * {@link #onActivityReenter(int,android.content.Intent)}.
 * {@link #startPostponedEnterTransition()} must be called to allow the Activity to
 * start the transitions. If the Activity did not use
 * {@link android.app.ActivityOptions#makeSceneTransitionAnimation(Activity,
 * android.util.Pair[])}, then this method does nothing.</p>
 * @apiSince 21
 */

public void postponeEnterTransition() { throw new RuntimeException("Stub!"); }

/**
 * Begin postponed transitions after {@link #postponeEnterTransition()} was called.
 * If postponeEnterTransition() was called, you must call startPostponedEnterTransition()
 * to have your Activity start drawing.
 * @apiSince 21
 */

public void startPostponedEnterTransition() { throw new RuntimeException("Stub!"); }

/**
 * Create {@link android.view.DragAndDropPermissions DragAndDropPermissions} object bound to this activity and controlling the
 * access permissions for content URIs associated with the {@link android.view.DragEvent DragEvent}.
 * @param event Drag event
 * @return The {@link android.view.DragAndDropPermissions DragAndDropPermissions} object used to control access to the content URIs.
 * Null if no content URIs are associated with the event or if permissions could not be granted.
 * @apiSince 24
 */

public android.view.DragAndDropPermissions requestDragAndDropPermissions(android.view.DragEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Request to put this activity in a mode where the user is locked to a restricted set of
 * applications.
 *
 * <p>If {@link android.app.admin.DevicePolicyManager#isLockTaskPermitted(java.lang.String) DevicePolicyManager#isLockTaskPermitted(String)} returns {@code true}
 * for this component, the current task will be launched directly into LockTask mode. Only apps
 * whitelisted by {@link android.app.admin.DevicePolicyManager#setLockTaskPackages(android.content.ComponentName,java.lang.String[]) DevicePolicyManager#setLockTaskPackages(ComponentName, String[])} can
 * be launched while LockTask mode is active. The user will not be able to leave this mode
 * until this activity calls {@link #stopLockTask()}. Calling this method while the device is
 * already in LockTask mode has no effect.
 *
 * <p>Otherwise, the current task will be launched into screen pinning mode. In this case, the
 * system will prompt the user with a dialog requesting permission to use this mode.
 * The user can exit at any time through instructions shown on the request dialog. Calling
 * {@link #stopLockTask()} will also terminate this mode.
 *
 * <p><strong>Note:</strong> this method can only be called when the activity is foreground.
 * That is, between {@link #onResume()} and {@link #onPause()}.
 *
 * @see #stopLockTask()
 * @see android.R.attr#lockTaskMode
 * @apiSince 21
 */

public void startLockTask() { throw new RuntimeException("Stub!"); }

/**
 * Stop the current task from being locked.
 *
 * <p>Called to end the LockTask or screen pinning mode started by {@link #startLockTask()}.
 * This can only be called by activities that have called {@link #startLockTask()} previously.
 *
 * <p><strong>Note:</strong> If the device is in LockTask mode that is not initially started
 * by this activity, then calling this method will not terminate the LockTask mode, but only
 * finish its own task. The device will remain in LockTask mode, until the activity which
 * started the LockTask mode calls this method, or until its whitelist authorization is revoked
 * by {@link android.app.admin.DevicePolicyManager#setLockTaskPackages(android.content.ComponentName,java.lang.String[]) DevicePolicyManager#setLockTaskPackages(ComponentName, String[])}.
 *
 * @see #startLockTask()
 * @see android.R.attr#lockTaskMode
 * @see android.app.ActivityManager#getLockTaskModeState()
 * @apiSince 21
 */

public void stopLockTask() { throw new RuntimeException("Stub!"); }

/**
 * Shows the user the system defined message for telling the user how to exit
 * lock task mode. The task containing this activity must be in lock task mode at the time
 * of this call for the message to be displayed.
 * @apiSince 23
 */

public void showLockTaskEscapeMessage() { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether an {@link android.app.Activity Activity} should be shown on top of the lock screen whenever
 * the lockscreen is up and the activity is resumed. Normally an activity will be transitioned
 * to the stopped state if it is started while the lockscreen is up, but with this flag set the
 * activity will remain in the resumed state visible on-top of the lock screen. This value can
 * be set as a manifest attribute using {@link android.R.attr#showWhenLocked}.
 *
 * @param showWhenLocked {@code true} to show the {@link android.app.Activity Activity} on top of the lock screen;
 *                                   {@code false} otherwise.
 * @see #setTurnScreenOn(boolean)
 * @see android.R.attr#turnScreenOn
 * @see android.R.attr#showWhenLocked
 * @apiSince 27
 */

public void setShowWhenLocked(boolean showWhenLocked) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether this {@link android.app.Activity Activity} should be shown on top of the lock screen whenever
 * the lockscreen is up and this activity has another activity behind it with the showWhenLock
 * attribute set. That is, this activity is only visible on the lock screen if there is another
 * activity with the showWhenLock attribute visible at the same time on the lock screen. A use
 * case for this is permission dialogs, that should only be visible on the lock screen if their
 * requesting activity is also visible. This value can be set as a manifest attribute using
 * android.R.attr#inheritShowWhenLocked.
 *
 * @param inheritShowWhenLocked {@code true} to show the {@link android.app.Activity Activity} on top of the lock
 *                              screen when this activity has another activity behind it with
 *                              the showWhenLock attribute set; {@code false} otherwise.
 * @see #setShowWhenLocked(boolean)
 * @see android.R.attr#inheritShowWhenLocked
 * @apiSince 29
 */

public void setInheritShowWhenLocked(boolean inheritShowWhenLocked) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether the screen should be turned on when the {@link android.app.Activity Activity} is resumed.
 * Normally an activity will be transitioned to the stopped state if it is started while the
 * screen if off, but with this flag set the activity will cause the screen to turn on if the
 * activity will be visible and resumed due to the screen coming on. The screen will not be
 * turned on if the activity won't be visible after the screen is turned on. This flag is
 * normally used in conjunction with the {@link android.R.attr#showWhenLocked} flag to make sure
 * the activity is visible after the screen is turned on when the lockscreen is up. In addition,
 * if this flag is set and the activity calls {@link android.app.KeyguardManager#requestDismissKeyguard(android.app.Activity,android.app.KeyguardManager.KeyguardDismissCallback) KeyguardManager#requestDismissKeyguard(Activity, KeyguardManager.KeyguardDismissCallback)}
 * the screen will turn on.
 *
 * @param turnScreenOn {@code true} to turn on the screen; {@code false} otherwise.
 *
 * @see #setShowWhenLocked(boolean)
 * @see android.R.attr#turnScreenOn
 * @see android.R.attr#showWhenLocked
 * @apiSince 27
 */

public void setTurnScreenOn(boolean turnScreenOn) { throw new RuntimeException("Stub!"); }

/**
 * Use with {@link #setDefaultKeyMode} to launch the dialer during default
 * key handling.
 *
 * @see #setDefaultKeyMode
 * @apiSince 1
 */

public static final int DEFAULT_KEYS_DIALER = 1; // 0x1

/**
 * Use with {@link #setDefaultKeyMode} to turn off default handling of
 * keys.
 *
 * @see #setDefaultKeyMode
 * @apiSince 1
 */

public static final int DEFAULT_KEYS_DISABLE = 0; // 0x0

/**
 * Use with {@link #setDefaultKeyMode} to specify that unhandled keystrokes
 * will start a global search (typically web search, but some platforms may define alternate
 * methods for global search)
 *
 * <p>See {@link android.app.SearchManager android.app.SearchManager} for more details.
 *
 * @see #setDefaultKeyMode
 * @apiSince 1
 */

public static final int DEFAULT_KEYS_SEARCH_GLOBAL = 4; // 0x4

/**
 * Use with {@link #setDefaultKeyMode} to specify that unhandled keystrokes
 * will start an application-defined search.  (If the application or activity does not
 * actually define a search, the keys will be ignored.)
 *
 * <p>See {@link android.app.SearchManager android.app.SearchManager} for more details.
 *
 * @see #setDefaultKeyMode
 * @apiSince 1
 */

public static final int DEFAULT_KEYS_SEARCH_LOCAL = 3; // 0x3

/**
 * Use with {@link #setDefaultKeyMode} to execute a menu shortcut in
 * default key handling.
 *
 * <p>That is, the user does not need to hold down the menu key to execute menu shortcuts.
 *
 * @see #setDefaultKeyMode
 * @apiSince 1
 */

public static final int DEFAULT_KEYS_SHORTCUT = 2; // 0x2

/** @apiSince 1 */

protected static final int[] FOCUSED_STATE_SET;
static { FOCUSED_STATE_SET = new int[0]; }

/**
 * Standard activity result: operation canceled.
 * @apiSince 1
 */

public static final int RESULT_CANCELED = 0; // 0x0

/**
 * Start of user-defined activity results.
 * @apiSince 1
 */

public static final int RESULT_FIRST_USER = 1; // 0x1

/**
 * Standard activity result: operation succeeded.
 * @apiSince 1
 */

public static final int RESULT_OK = -1; // 0xffffffff
}

