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


package android.view;

import android.os.Parcel;
import android.content.ClipData;
import android.content.ClipDescription;

/**
 * Represents an event that is sent out by the system at various times during a drag and drop
 * operation. It is a data structure that contains several important pieces of data about
 * the operation and the underlying data.
 * <p>
 *  View objects that receive a DragEvent call {@link #getAction()}, which returns
 *  an action type that indicates the state of the drag and drop operation. This allows a View
 *  object to react to a change in state by changing its appearance or performing other actions.
 *  For example, a View can react to the {@link #ACTION_DRAG_ENTERED} action type by
 *  by changing one or more colors in its displayed image.
 * </p>
 * <p>
 *  During a drag and drop operation, the system displays an image that the user drags. This image
 *  is called a drag shadow. Several action types reflect the position of the drag shadow relative
 *  to the View receiving the event.
 * </p>
 * <p>
 *  Most methods return valid data only for certain event actions. This is summarized in the
 *  following table. Each possible {@link #getAction()} value is listed in the first column. The
 *  other columns indicate which method or methods return valid data for that getAction() value:
 * </p>
 * <table>
 *  <tr>
 *      <th scope="col">getAction() Value</th>
 *      <th scope="col">getClipDescription()</th>
 *      <th scope="col">getLocalState()</th>
 *      <th scope="col">getX()</th>
 *      <th scope="col">getY()</th>
 *      <th scope="col">getClipData()</th>
 *      <th scope="col">getResult()</th>
 *  </tr>
 *  <tr>
 *      <td>ACTION_DRAG_STARTED</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *  </tr>
 *  <tr>
 *      <td>ACTION_DRAG_ENTERED</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *  </tr>
 *  <tr>
 *      <td>ACTION_DRAG_LOCATION</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *  </tr>
 *  <tr>
 *      <td>ACTION_DRAG_EXITED</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *  </tr>
 *  <tr>
 *      <td>ACTION_DROP</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *  </tr>
 *  <tr>
 *      <td>ACTION_DRAG_ENDED</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *      <td style="text-align: center;">X</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *      <td style="text-align: center;">&nbsp;</td>
 *      <td style="text-align: center;">X</td>
 *  </tr>
 * </table>
 * <p>
 *  The {@link android.view.DragEvent#getAction()},
 *  {@link android.view.DragEvent#getLocalState()}
 *  {@link android.view.DragEvent#describeContents()},
 *  {@link android.view.DragEvent#writeToParcel(Parcel,int)}, and
 *  {@link android.view.DragEvent#toString()} methods always return valid data.
 * </p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For a guide to implementing drag and drop features, read the
 * <a href="{@docRoot}guide/topics/ui/drag-drop.html">Drag and Drop</a> developer guide.</p>
 * </div>
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DragEvent implements android.os.Parcelable {

private DragEvent() { throw new RuntimeException("Stub!"); }

/**
 * Inspect the action value of this event.
 * @return One of the following action constants, in the order in which they usually occur
 * during a drag and drop operation:
 * <ul>
 *  <li>{@link #ACTION_DRAG_STARTED}</li>
 *  <li>{@link #ACTION_DRAG_ENTERED}</li>
 *  <li>{@link #ACTION_DRAG_LOCATION}</li>
 *  <li>{@link #ACTION_DROP}</li>
 *  <li>{@link #ACTION_DRAG_EXITED}</li>
 *  <li>{@link #ACTION_DRAG_ENDED}</li>
 * </ul>
 * @apiSince 11
 */

public int getAction() { throw new RuntimeException("Stub!"); }

/**
 * Gets the X coordinate of the drag point. The value is only valid if the event action is
 * {@link #ACTION_DRAG_STARTED}, {@link #ACTION_DRAG_LOCATION} or {@link #ACTION_DROP}.
 * @return The current drag point's X coordinate
 * @apiSince 11
 */

public float getX() { throw new RuntimeException("Stub!"); }

/**
 * Gets the Y coordinate of the drag point. The value is only valid if the event action is
 * {@link #ACTION_DRAG_STARTED}, {@link #ACTION_DRAG_LOCATION} or {@link #ACTION_DROP}.
 * @return The current drag point's Y coordinate
 * @apiSince 11
 */

public float getY() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.content.ClipData} object sent to the system as part of the call
 * to
 * {@link android.view.View#startDragAndDrop(ClipData,View.DragShadowBuilder,Object,int)
 * startDragAndDrop()}.
 * This method only returns valid data if the event action is {@link #ACTION_DROP}.
 * @return The ClipData sent to the system by startDragAndDrop().
 * @apiSince 11
 */

public android.content.ClipData getClipData() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.content.ClipDescription} object contained in the
 * {@link android.content.ClipData} object sent to the system as part of the call to
 * {@link android.view.View#startDragAndDrop(ClipData,View.DragShadowBuilder,Object,int)
 * startDragAndDrop()}.
 * The drag handler or listener for a View can use the metadata in this object to decide if the
 * View can accept the dragged View object's data.
 * <p>
 * This method returns valid data for all event actions except for {@link #ACTION_DRAG_ENDED}.
 * @return The ClipDescription that was part of the ClipData sent to the system by
 *     startDragAndDrop().
 * @apiSince 11
 */

public android.content.ClipDescription getClipDescription() { throw new RuntimeException("Stub!"); }

/**
 * Returns the local state object sent to the system as part of the call to
 * {@link android.view.View#startDragAndDrop(ClipData,View.DragShadowBuilder,Object,int)
 * startDragAndDrop()}.
 * The object is intended to provide local information about the drag and drop operation. For
 * example, it can indicate whether the drag and drop operation is a copy or a move.
 * <p>
 * The local state is available only to views in the activity which has started the drag
 * operation. In all other activities this method will return null
 * </p>
 * <p>
 *  This method returns valid data for all event actions.
 * </p>
 * @return The local state object sent to the system by startDragAndDrop().
 * @apiSince 11
 */

public java.lang.Object getLocalState() { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Returns an indication of the result of the drag and drop operation.
 * This method only returns valid data if the action type is {@link #ACTION_DRAG_ENDED}.
 * The return value depends on what happens after the user releases the drag shadow.
 * </p>
 * <p>
 * If the user releases the drag shadow on a View that can accept a drop, the system sends an
 * {@link #ACTION_DROP} event to the View object's drag event listener. If the listener
 * returns {@code true}, then getResult() will return {@code true}.
 * If the listener returns {@code false}, then getResult() returns {@code false}.
 * </p>
 * <p>
 * Notice that getResult() also returns {@code false} if no {@link #ACTION_DROP} is sent. This
 * happens, for example, when the user releases the drag shadow over an area outside of the
 * application. In this case, the system sends out {@link #ACTION_DRAG_ENDED} for the current
 * operation, but never sends out {@link #ACTION_DROP}.
 * </p>
 * @return {@code true} if a drag event listener returned {@code true} in response to
 * {@link #ACTION_DROP}. If the system did not send {@link #ACTION_DROP} before
 * {@link #ACTION_DRAG_ENDED}, or if the listener returned {@code false} in response to
 * {@link #ACTION_DROP}, then {@code false} is returned.
 * @apiSince 11
 */

public boolean getResult() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string containing a concise, human-readable representation of this DragEvent
 * object.
 * @return A string representation of the DragEvent object.
 * @apiSince 11
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns information about the {@link android.os.Parcel} representation of this DragEvent
 * object.
 * @return Information about the {@link android.os.Parcel} representation.
 * @apiSince 11
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.os.Parcel} object from this DragEvent object.
 * @param dest A {@link android.os.Parcel} object in which to put the DragEvent object.
 * @param flags Flags to store in the Parcel.
 * @apiSince 11
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Action constant returned by {@link #getAction()}:  Signals to a View that the drag and drop
 * operation has concluded.  A View that changed its appearance during the operation should
 * return to its usual drawing state in response to this event.
 * <p>
 *  All views with listeners that returned boolean <code>true</code> for the ACTION_DRAG_STARTED
 *  event will receive the ACTION_DRAG_ENDED event even if they are not currently visible when
 *  the drag ends. Views removed during the drag operation won't receive the ACTION_DRAG_ENDED
 *  event.
 * </p>
 * <p>
 *  The View object can call {@link #getResult()} to see the result of the operation.
 *  If a View returned {@code true} in response to {@link #ACTION_DROP}, then
 *  getResult() returns {@code true}, otherwise it returns {@code false}.
 * </p>
 * @see #ACTION_DRAG_STARTED
 * @see #getResult()
 * @apiSince 11
 */

public static final int ACTION_DRAG_ENDED = 4; // 0x4

/**
 * Action constant returned by {@link #getAction()}: Signals to a View that the drag point has
 * entered the bounding box of the View.
 * <p>
 *  If the View can accept a drop, it can react to ACTION_DRAG_ENTERED
 *  by changing its appearance in a way that tells the user that the View is the current
 *  drop target.
 * </p>
 * The system stops sending ACTION_DRAG_LOCATION events to a View once the user moves the
 * drag shadow out of the View object's bounding box or into a descendant view that can accept
 * the data. If the user moves the drag shadow back into the View object's bounding box or out
 * of a descendant view that can accept the data, the View receives an ACTION_DRAG_ENTERED again
 * before receiving any more ACTION_DRAG_LOCATION events.
 * </p>
 * @see #ACTION_DRAG_ENTERED
 * @see #ACTION_DRAG_LOCATION
 * @apiSince 11
 */

public static final int ACTION_DRAG_ENTERED = 5; // 0x5

/**
 * Action constant returned by {@link #getAction()}: Signals that the user has moved the
 * drag shadow out of the bounding box of the View or into a descendant view that can accept
 * the data.
 * The View can react by changing its appearance in a way that tells the user that
 * View is no longer the immediate drop target.
 * <p>
 *  After the system sends an ACTION_DRAG_EXITED event to the View, the View receives no more
 *  ACTION_DRAG_LOCATION events until the user drags the drag shadow back over the View.
 * </p>
 *
 * @apiSince 11
 */

public static final int ACTION_DRAG_EXITED = 6; // 0x6

/**
 * Action constant returned by {@link #getAction()}: Sent to a View after
 * {@link #ACTION_DRAG_ENTERED} while the drag shadow is still within the View object's bounding
 * box, but not within a descendant view that can accept the data. The {@link #getX()} and
 * {@link #getY()} methods supply
 * the X and Y position of of the drag point within the View object's bounding box.
 * <p>
 * A View receives an {@link #ACTION_DRAG_ENTERED} event before receiving any
 * ACTION_DRAG_LOCATION events.
 * </p>
 * <p>
 * The system stops sending ACTION_DRAG_LOCATION events to a View once the user moves the
 * drag shadow out of the View object's bounding box or into a descendant view that can accept
 * the data. If the user moves the drag shadow back into the View object's bounding box or out
 * of a descendant view that can accept the data, the View receives an ACTION_DRAG_ENTERED again
 * before receiving any more ACTION_DRAG_LOCATION events.
 * </p>
 * @see #ACTION_DRAG_ENTERED
 * @see #getX()
 * @see #getY()
 * @apiSince 11
 */

public static final int ACTION_DRAG_LOCATION = 2; // 0x2

/**
 * Action constant returned by {@link #getAction()}: Signals the start of a
 * drag and drop operation. The View should return {@code true} from its
 * {@link android.view.View#onDragEvent(android.view.DragEvent) View#onDragEvent(DragEvent)} handler method or
 * {@link android.view.View.OnDragListener#onDrag(android.view.View,android.view.DragEvent) View.OnDragListener#onDrag(View,DragEvent)} listener
 * if it can accept a drop. The onDragEvent() or onDrag() methods usually inspect the metadata
 * from {@link #getClipDescription()} to determine if they can accept the data contained in
 * this drag. For an operation that doesn't represent data transfer, these methods may
 * perform other actions to determine whether or not the View should accept the data.
 * If the View wants to indicate that it is a valid drop target, it can also react by
 * changing its appearance.
 * <p>
 *  Views added or becoming visible for the first time during a drag operation receive this
 *  event when they are added or becoming visible.
 * </p>
 * <p>
 *  A View only receives further drag events for the drag operation if it returns {@code true}
 *  in response to ACTION_DRAG_STARTED.
 * </p>
 * @see #ACTION_DRAG_ENDED
 * @see #getX()
 * @see #getY()
 * @apiSince 11
 */

public static final int ACTION_DRAG_STARTED = 1; // 0x1

/**
 * Action constant returned by {@link #getAction()}: Signals to a View that the user
 * has released the drag shadow, and the drag point is within the bounding box of the View and
 * not within a descendant view that can accept the data.
 * The View should retrieve the data from the DragEvent by calling {@link #getClipData()}.
 * The methods {@link #getX()} and {@link #getY()} return the X and Y position of the drop point
 * within the View object's bounding box.
 * <p>
 * The View should return {@code true} from its {@link android.view.View#onDragEvent(android.view.DragEvent) View#onDragEvent(DragEvent)}
 * handler or {@link android.view.View.OnDragListener#onDrag(android.view.View,android.view.DragEvent) View.OnDragListener#onDrag(View,DragEvent)}
 * listener if it accepted the drop, and {@code false} if it ignored the drop.
 * </p>
 * <p>
 * The View can also react to this action by changing its appearance.
 * </p>
 * @see #getClipData()
 * @see #getX()
 * @see #getY()
 * @apiSince 11
 */

public static final int ACTION_DROP = 3; // 0x3

/**
 * A container for creating a DragEvent from a Parcel.
 * @apiSince 11
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.DragEvent> CREATOR;
static { CREATOR = null; }
}

