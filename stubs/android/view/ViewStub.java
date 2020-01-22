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


package android.view;


/**
 * A ViewStub is an invisible, zero-sized View that can be used to lazily inflate
 * layout resources at runtime.
 *
 * When a ViewStub is made visible, or when {@link #inflate()}  is invoked, the layout resource
 * is inflated. The ViewStub then replaces itself in its parent with the inflated View or Views.
 * Therefore, the ViewStub exists in the view hierarchy until {@link #setVisibility(int)} or
 * {@link #inflate()} is invoked.
 *
 * The inflated View is added to the ViewStub's parent with the ViewStub's layout
 * parameters. Similarly, you can define/override the inflate View's id by using the
 * ViewStub's inflatedId property. For instance:
 *
 * <pre>
 *     &lt;ViewStub android:id="@+id/stub"
 *               android:inflatedId="@+id/subTree"
 *               android:layout="@layout/mySubTree"
 *               android:layout_width="120dip"
 *               android:layout_height="40dip" /&gt;
 * </pre>
 *
 * The ViewStub thus defined can be found using the id "stub." After inflation of
 * the layout resource "mySubTree," the ViewStub is removed from its parent. The
 * View created by inflating the layout resource "mySubTree" can be found using the
 * id "subTree," specified by the inflatedId property. The inflated View is finally
 * assigned a width of 120dip and a height of 40dip.
 *
 * The preferred way to perform the inflation of the layout resource is the following:
 *
 * <pre>
 *     ViewStub stub = findViewById(R.id.stub);
 *     View inflated = stub.inflate();
 * </pre>
 *
 * When {@link #inflate()} is invoked, the ViewStub is replaced by the inflated View
 * and the inflated View is returned. This lets applications get a reference to the
 * inflated View without executing an extra findViewById().
 *
 * @attr ref android.R.styleable#ViewStub_inflatedId
 * @attr ref android.R.styleable#ViewStub_layout
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@android.widget.RemoteViews.RemoteView
public final class ViewStub extends android.view.View {

/** @apiSince 1 */

public ViewStub(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new ViewStub with the specified layout resource.
 *
 * @param context The application's environment.
 * @param layoutResource The reference to a layout resource that will be inflated.
 * @apiSince 1
 */

public ViewStub(android.content.Context context, int layoutResource) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ViewStub(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ViewStub(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public ViewStub(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Returns the id taken by the inflated view. If the inflated id is
 * {@link android.view.View#NO_ID View#NO_ID}, the inflated view keeps its original id.
 *
 * @return A positive integer used to identify the inflated view or
 *         {@link #NO_ID} if the inflated view should keep its id.
 *
 * @see #setInflatedId(int)
 * @attr ref android.R.styleable#ViewStub_inflatedId
 * @apiSince 1
 */

public int getInflatedId() { throw new RuntimeException("Stub!"); }

/**
 * Defines the id taken by the inflated view. If the inflated id is
 * {@link android.view.View#NO_ID View#NO_ID}, the inflated view keeps its original id.
 *
 * @param inflatedId A positive integer used to identify the inflated view or
 *                   {@link #NO_ID} if the inflated view should keep its id.
 *
 * @see #getInflatedId()
 * @attr ref android.R.styleable#ViewStub_inflatedId
 * @apiSince 1
 */

public void setInflatedId(int inflatedId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the layout resource that will be used by {@link #setVisibility(int)} or
 * {@link #inflate()} to replace this StubbedView
 * in its parent by another view.
 *
 * @return The layout resource identifier used to inflate the new View.
 *
 * @see #setLayoutResource(int)
 * @see #setVisibility(int)
 * @see #inflate()
 * @attr ref android.R.styleable#ViewStub_layout
 * @apiSince 1
 */

public int getLayoutResource() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the layout resource to inflate when this StubbedView becomes visible or invisible
 * or when {@link #inflate()} is invoked. The View created by inflating the layout resource is
 * used to replace this StubbedView in its parent.
 *
 * @param layoutResource A valid layout resource identifier (different from 0.)
 *
 * @see #getLayoutResource()
 * @see #setVisibility(int)
 * @see #inflate()
 * @attr ref android.R.styleable#ViewStub_layout
 * @apiSince 1
 */

public void setLayoutResource(int layoutResource) { throw new RuntimeException("Stub!"); }

/**
 * Set {@link android.view.LayoutInflater LayoutInflater} to use in {@link #inflate()}, or {@code null}
 * to use the default.
 * @apiSince 16
 */

public void setLayoutInflater(android.view.LayoutInflater inflater) { throw new RuntimeException("Stub!"); }

/**
 * Get current {@link android.view.LayoutInflater LayoutInflater} used in {@link #inflate()}.
 * @apiSince 16
 */

public android.view.LayoutInflater getLayoutInflater() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void dispatchDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * When visibility is set to {@link #VISIBLE} or {@link #INVISIBLE},
 * {@link #inflate()} is invoked and this StubbedView is replaced in its parent
 * by the inflated layout resource. After that calls to this function are passed
 * through to the inflated view.
 *
 * @param visibility One of {@link #VISIBLE}, {@link #INVISIBLE}, or {@link #GONE}.
 *
 * @see #inflate()
 * @apiSince 1
 */

public void setVisibility(int visibility) { throw new RuntimeException("Stub!"); }

/**
 * Inflates the layout resource identified by {@link #getLayoutResource()}
 * and replaces this StubbedView in its parent by the inflated layout resource.
 *
 * @return The inflated layout resource.
 *
 * @apiSince 1
 */

public android.view.View inflate() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the inflate listener to be notified after this ViewStub successfully
 * inflated its layout resource.
 *
 * @param inflateListener The OnInflateListener to notify of successful inflation.
 *
 * @see android.view.ViewStub.OnInflateListener
 * @apiSince 1
 */

public void setOnInflateListener(android.view.ViewStub.OnInflateListener inflateListener) { throw new RuntimeException("Stub!"); }
/**
 * Listener used to receive a notification after a ViewStub has successfully
 * inflated its layout resource.
 *
 * @see android.view.ViewStub#setOnInflateListener(android.view.ViewStub.OnInflateListener)
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnInflateListener {

/**
 * Invoked after a ViewStub successfully inflated its layout resource.
 * This method is invoked after the inflated view was added to the
 * hierarchy but before the layout pass.
 *
 * @param stub The ViewStub that initiated the inflation.
 * @param inflated The inflated View.
 * @apiSince 1
 */

public void onInflate(android.view.ViewStub stub, android.view.View inflated);
}

}

