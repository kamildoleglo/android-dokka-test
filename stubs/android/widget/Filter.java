/*
 * Copyright (C) 2007 The Android Open Source Project
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
 * <p>A filter constrains data with a filtering pattern.</p>
 *
 * <p>Filters are usually created by {@link android.widget.Filterable}
 * classes.</p>
 *
 * <p>Filtering operations performed by calling {@link #filter(java.lang.CharSequence)} or
 * {@link #filter(java.lang.CharSequence,android.widget.Filter.FilterListener)} are
 * performed asynchronously. When these methods are called, a filtering request
 * is posted in a request queue and processed later. Any call to one of these
 * methods will cancel any previous non-executed filtering request.</p>
 *
 * @see android.widget.Filterable
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Filter {

/**
 * <p>Creates a new asynchronous filter.</p>
 * @apiSince 1
 */

public Filter() { throw new RuntimeException("Stub!"); }

/**
 * <p>Starts an asynchronous filtering operation. Calling this method
 * cancels all previous non-executed filtering requests and posts a new
 * filtering request that will be executed later.</p>
 *
 * @param constraint the constraint used to filter the data
 *
 * @see #filter(CharSequence, android.widget.Filter.FilterListener)
 * @apiSince 1
 */

public final void filter(java.lang.CharSequence constraint) { throw new RuntimeException("Stub!"); }

/**
 * <p>Starts an asynchronous filtering operation. Calling this method
 * cancels all previous non-executed filtering requests and posts a new
 * filtering request that will be executed later.</p>
 *
 * <p>Upon completion, the listener is notified.</p>
 *
 * @param constraint the constraint used to filter the data
 * @param listener a listener notified upon completion of the operation
 *
 * @see #filter(CharSequence)
 * @see #performFiltering(CharSequence)
 * @see #publishResults(CharSequence, android.widget.Filter.FilterResults)
 * @apiSince 1
 */

public final void filter(java.lang.CharSequence constraint, android.widget.Filter.FilterListener listener) { throw new RuntimeException("Stub!"); }

/**
 * <p>Invoked in a worker thread to filter the data according to the
 * constraint. Subclasses must implement this method to perform the
 * filtering operation. Results computed by the filtering operation
 * must be returned as a {@link android.widget.Filter.FilterResults} that
 * will then be published in the UI thread through
 * {@link #publishResults(java.lang.CharSequence,android.widget.Filter.FilterResults)}.</p>
 *
 * <p><strong>Contract:</strong> When the constraint is null, the original
 * data must be restored.</p>
 *
 * @param constraint the constraint used to filter the data
 * @return the results of the filtering operation
 *
 * @see #filter(CharSequence, android.widget.Filter.FilterListener)
 * @see #publishResults(CharSequence, android.widget.Filter.FilterResults)
 * @see android.widget.Filter.FilterResults
 * @apiSince 1
 */

protected abstract android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence constraint);

/**
 * <p>Invoked in the UI thread to publish the filtering results in the
 * user interface. Subclasses must implement this method to display the
 * results computed in {@link #performFiltering}.</p>
 *
 * @param constraint the constraint used to filter the data
 * @param results the results of the filtering operation
 *
 * @see #filter(CharSequence, android.widget.Filter.FilterListener)
 * @see #performFiltering(CharSequence)
 * @see android.widget.Filter.FilterResults
 * @apiSince 1
 */

protected abstract void publishResults(java.lang.CharSequence constraint, android.widget.Filter.FilterResults results);

/**
 * <p>Converts a value from the filtered set into a CharSequence. Subclasses
 * should override this method to convert their results. The default
 * implementation returns an empty String for null values or the default
 * String representation of the value.</p>
 *
 * @param resultValue the value to convert to a CharSequence
 * @return a CharSequence representing the value
 * @apiSince 1
 */

public java.lang.CharSequence convertResultToString(java.lang.Object resultValue) { throw new RuntimeException("Stub!"); }
/**
 * <p>Listener used to receive a notification upon completion of a filtering
 * operation.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface FilterListener {

/**
 * <p>Notifies the end of a filtering operation.</p>
 *
 * @param count the number of values computed by the filter
 * @apiSince 1
 */

public void onFilterComplete(int count);
}

/**
 * <p>Holds the results of a filtering operation. The results are the values
 * computed by the filtering operation and the number of these values.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static class FilterResults {

/** @apiSince 1 */

public FilterResults() { throw new RuntimeException("Stub!"); }

/**
 * <p>Contains the number of values computed by the filtering
 * operation.</p>
 * @apiSince 1
 */

public int count;

/**
 * <p>Contains all the values computed by the filtering operation.</p>
 * @apiSince 1
 */

public java.lang.Object values;
}

}

