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


package android.app;

import java.io.PrintWriter;
import android.view.LayoutInflater;
import android.content.Intent;
import android.os.Bundle;
import android.content.IntentSender;
import android.content.Context;

/**
 * Integration points with the Fragment host.
 * <p>
 * Fragments may be hosted by any object; such as an {@link android.app.Activity Activity}. In order to
 * host fragments, implement {@link android.app.FragmentHostCallback FragmentHostCallback}, overriding the methods
 * applicable to the host.
 *
 * @deprecated Use the <a href="{@docRoot}tools/extras/support-library.html">Support Library</a>
 *      {@link android.support.v4.app.FragmentHostCallback}
 * @apiSince 23
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class FragmentHostCallback<E> extends android.app.FragmentContainer {

/** @apiSince 23 */

@Deprecated
public FragmentHostCallback(android.content.Context context, android.os.Handler handler, int windowAnimations) { throw new RuntimeException("Stub!"); }

/**
 * Print internal state into the given stream.
 *
 * @param prefix Desired prefix to prepend at each line of output.
 * @param fd The raw file descriptor that the dump is being sent to.
 * @param writer The PrintWriter to which you should dump your state. This will be closed
 *                  for you after you return.
 * @param args additional arguments to the dump request.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void onDump(java.lang.String prefix, java.io.FileDescriptor fd, java.io.PrintWriter writer, java.lang.String[] args) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the fragment's state needs to be saved.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public boolean onShouldSaveFragmentState(android.app.Fragment fragment) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link android.view.LayoutInflater LayoutInflater}.
 * See {@link android.app.Activity#getLayoutInflater() Activity#getLayoutInflater()}.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public android.view.LayoutInflater onGetLayoutInflater() { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the FragmentManager's LayoutInflaterFactory should be used.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public boolean onUseFragmentManagerInflaterFactory() { throw new RuntimeException("Stub!"); }

/**
 * Return the object that's currently hosting the fragment. If a {@link android.app.Fragment Fragment}
 * is hosted by a {@link android.app.Activity Activity}, the object returned here should be the same
 * object returned from {@link android.app.Fragment#getActivity() Fragment#getActivity()}.
 
 * @return This value may be {@code null}.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.Nullable
public abstract E onGetHost();

/**
 * Invalidates the activity's options menu.
 * See {@link android.app.Activity#invalidateOptionsMenu() Activity#invalidateOptionsMenu()}
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void onInvalidateOptionsMenu() { throw new RuntimeException("Stub!"); }

/**
 * Starts a new {@link android.app.Activity Activity} from the given fragment.
 * See {@link android.app.Activity#startActivityForResult(android.content.Intent,int) Activity#startActivityForResult(Intent, int)}.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void onStartActivityFromFragment(android.app.Fragment fragment, android.content.Intent intent, int requestCode, android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Starts a new {@link android.content.IntentSender IntentSender} from the given fragment.
 * See {@link android.app.Activity#startIntentSender(android.content.IntentSender,android.content.Intent,int,int,int,android.os.Bundle) Activity#startIntentSender(IntentSender, Intent, int, int, int, Bundle)}.
 
 * @param fillInIntent This value may be {@code null}.
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated
public void onStartIntentSenderFromFragment(android.app.Fragment fragment, android.content.IntentSender intent, int requestCode, @androidx.annotation.Nullable android.content.Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, android.os.Bundle options) throws android.content.IntentSender.SendIntentException { throw new RuntimeException("Stub!"); }

/**
 * Requests permissions from the given fragment.
 * See {@link android.app.Activity#requestPermissions(java.lang.String[],int) Activity#requestPermissions(String[], int)}
 
 * @param fragment This value must never be {@code null}.
 
 * @param permissions This value must never be {@code null}.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void onRequestPermissionsFromFragment(@androidx.annotation.NonNull android.app.Fragment fragment, @androidx.annotation.NonNull java.lang.String[] permissions, int requestCode) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if there are window animations.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public boolean onHasWindowAnimations() { throw new RuntimeException("Stub!"); }

/**
 * Return the window animations.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public int onGetWindowAnimations() { throw new RuntimeException("Stub!"); }

/**
 * Called when a {@link android.app.Fragment Fragment} is being attached to this host, immediately
 * after the call to its {@link android.app.Fragment#onAttach(android.content.Context) Fragment#onAttach(Context)} method and before
 * {@link android.app.Fragment#onCreate(android.os.Bundle) Fragment#onCreate(Bundle)}.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void onAttachFragment(android.app.Fragment fragment) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value may be {@code null}.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.Nullable
public <T extends android.view.View> T onFindViewById(int id) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public boolean onHasView() { throw new RuntimeException("Stub!"); }
}

