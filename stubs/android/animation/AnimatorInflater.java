/*
 * Copyright (C) 2010 The Android Open Source Project
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

package android.animation;

import org.xmlpull.v1.XmlPullParser;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;

/**
 * This class is used to instantiate animator XML files into Animator objects.
 * <p>
 * For performance reasons, inflation relies heavily on pre-processing of
 * XML files that is done at build time. Therefore, it is not currently possible
 * to use this inflater with an XmlPullParser over a plain XML file at runtime;
 * it only works with an XmlPullParser returned from a compiled resource (R.
 * <em>something</em> file.)
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AnimatorInflater {

public AnimatorInflater() { throw new RuntimeException("Stub!"); }

/**
 * Loads an {@link android.animation.Animator Animator} object from a resource
 *
 * @param context Application context used to access resources
 * @param id The resource id of the animation to load
 * @return The animator object reference by the specified id
 * @throws android.content.res.Resources.NotFoundException when the animation cannot be loaded
 * @apiSince 11
 */

public static android.animation.Animator loadAnimator(android.content.Context context, int id) throws android.content.res.Resources.NotFoundException { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public static android.animation.StateListAnimator loadStateListAnimator(android.content.Context context, int id) throws android.content.res.Resources.NotFoundException { throw new RuntimeException("Stub!"); }
}

