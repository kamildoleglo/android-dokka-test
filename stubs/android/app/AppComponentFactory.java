/*
 * Copyright (C) 2017 The Android Open Source Project
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
import android.content.ContentProvider;

/**
 * Interface used to control the instantiation of manifest elements.
 *
 * @see #instantiateApplication
 * @see #instantiateActivity
 * @see #instantiateClassLoader
 * @see #instantiateService
 * @see #instantiateReceiver
 * @see #instantiateProvider
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AppComponentFactory {

public AppComponentFactory() { throw new RuntimeException("Stub!"); }

/**
 * Selects the class loader which will be used by the platform to instantiate app components.
 * <p>
 * The default implementation of this method returns the {@code cl} parameter unchanged.
 * Applications can override this method to set up a custom class loader or a custom class
 * loader hierarchy and return it to the platform.
 * <p>
 * The method is a hook invoked before any application components are instantiated or the
 * application Context is initialized. It is intended to allow the application's classes to
 * be loaded from a different source than the base/split APK(s).
 * <p>
 * The default class loader {@code cl} is created by the platform and used to load the
 * application's base or split APK(s). Its parent is typically the boot class loader, unless
 * running under instrumentation. Its classname is configurable using the
 * {@link android.R.attr#classLoader} manifest attribute.
 *
 * @param cl        The default class loader created by the platform.
 * This value must never be {@code null}.
 * @param aInfo     Information about the application being loaded.
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.ClassLoader instantiateClassLoader(@androidx.annotation.NonNull java.lang.ClassLoader cl, @androidx.annotation.NonNull android.content.pm.ApplicationInfo aInfo) { throw new RuntimeException("Stub!"); }

/**
 * Allows application to override the creation of the application object. This can be used to
 * perform things such as dependency injection or class loader changes to these
 * classes.
 * <p>
 * This method is only intended to provide a hook for instantiation. It does not provide
 * earlier access to the Application object. The returned object will not be initialized
 * as a Context yet and should not be used to interact with other android APIs.
 *
 * @param cl        The default classloader to use for instantiation.
 * This value must never be {@code null}.
 * @param className The class to be instantiated.
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.app.Application instantiateApplication(@androidx.annotation.NonNull java.lang.ClassLoader cl, @androidx.annotation.NonNull java.lang.String className) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }

/**
 * Allows application to override the creation of activities. This can be used to
 * perform things such as dependency injection or class loader changes to these
 * classes.
 * <p>
 * This method is only intended to provide a hook for instantiation. It does not provide
 * earlier access to the Activity object. The returned object will not be initialized
 * as a Context yet and should not be used to interact with other android APIs.
 *
 * @param cl        The default classloader to use for instantiation.
 * This value must never be {@code null}.
 * @param className The class to be instantiated.
 * This value must never be {@code null}.
 * @param intent    Intent creating the class.
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.app.Activity instantiateActivity(@androidx.annotation.NonNull java.lang.ClassLoader cl, @androidx.annotation.NonNull java.lang.String className, @androidx.annotation.Nullable android.content.Intent intent) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }

/**
 * Allows application to override the creation of receivers. This can be used to
 * perform things such as dependency injection or class loader changes to these
 * classes.
 *
 * @param cl        The default classloader to use for instantiation.
 * This value must never be {@code null}.
 * @param className The class to be instantiated.
 * This value must never be {@code null}.
 * @param intent    Intent creating the class.
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.content.BroadcastReceiver instantiateReceiver(@androidx.annotation.NonNull java.lang.ClassLoader cl, @androidx.annotation.NonNull java.lang.String className, @androidx.annotation.Nullable android.content.Intent intent) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }

/**
 * Allows application to override the creation of services. This can be used to
 * perform things such as dependency injection or class loader changes to these
 * classes.
 * <p>
 * This method is only intended to provide a hook for instantiation. It does not provide
 * earlier access to the Service object. The returned object will not be initialized
 * as a Context yet and should not be used to interact with other android APIs.
 *
 * @param cl        The default classloader to use for instantiation.
 * This value must never be {@code null}.
 * @param className The class to be instantiated.
 * This value must never be {@code null}.
 * @param intent    Intent creating the class.
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.app.Service instantiateService(@androidx.annotation.NonNull java.lang.ClassLoader cl, @androidx.annotation.NonNull java.lang.String className, @androidx.annotation.Nullable android.content.Intent intent) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }

/**
 * Allows application to override the creation of providers. This can be used to
 * perform things such as dependency injection or class loader changes to these
 * classes.
 * <p>
 * This method is only intended to provide a hook for instantiation. It does not provide
 * earlier access to the ContentProvider object. The returned object will not be initialized
 * with a Context yet and should not be used to interact with other android APIs.
 *
 * @param cl        The default classloader to use for instantiation.
 * This value must never be {@code null}.
 * @param className The class to be instantiated.
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.content.ContentProvider instantiateProvider(@androidx.annotation.NonNull java.lang.ClassLoader cl, @androidx.annotation.NonNull java.lang.String className) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }
}

