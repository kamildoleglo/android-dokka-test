/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.widget;


/**
 * The {@code ZoomControls} class displays a simple set of controls used for zooming and
 * provides callbacks to register for events.
 * @deprecated This functionality and UI is better handled with custom views and layouts
 * rather than a dedicated zoom-control widget
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class ZoomControls extends android.widget.LinearLayout {

/** @apiSince 1 */

@Deprecated
public ZoomControls(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public ZoomControls(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setOnZoomInClickListener(android.view.View.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setOnZoomOutClickListener(android.view.View.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setZoomSpeed(long speed) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean onTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void show() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void hide() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setIsZoomInEnabled(boolean isEnabled) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setIsZoomOutEnabled(boolean isEnabled) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean hasFocus() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 23
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
}

