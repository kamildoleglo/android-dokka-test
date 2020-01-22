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


package android.media;

import android.widget.VideoView;
import android.net.Uri;
import android.content.Context;
import java.io.IOException;
import java.io.FileDescriptor;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.graphics.SurfaceTexture;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.CookieHandler;
import java.net.URL;
import android.content.res.AssetFileDescriptor;
import android.os.Handler;
import android.os.PowerManager;
import java.util.Set;
import android.os.PersistableBundle;
import java.util.UUID;
import java.io.File;

/**
 * MediaPlayer class can be used to control playback
 * of audio/video files and streams. An example on how to use the methods in
 * this class can be found in {@link android.widget.VideoView}.
 *
 * <p>Topics covered here are:
 * <ol>
 * <li><a href="#StateDiagram">State Diagram</a>
 * <li><a href="#Valid_and_Invalid_States">Valid and Invalid States</a>
 * <li><a href="#Permissions">Permissions</a>
 * <li><a href="#Callbacks">Register informational and error callbacks</a>
 * </ol>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about how to use MediaPlayer, read the
 * <a href="{@docRoot}guide/topics/media/mediaplayer.html">Media Playback</a> developer guide.</p>
 * </div>
 *
 * <a name="StateDiagram"></a>
 * <h3>State Diagram</h3>
 *
 * <p>Playback control of audio/video files and streams is managed as a state
 * machine. The following diagram shows the life cycle and the states of a
 * MediaPlayer object driven by the supported playback control operations.
 * The ovals represent the states a MediaPlayer object may reside
 * in. The arcs represent the playback control operations that drive the object
 * state transition. There are two types of arcs. The arcs with a single arrow
 * head represent synchronous method calls, while those with
 * a double arrow head represent asynchronous method calls.</p>
 *
 * <p><img src="../../../images/mediaplayer_state_diagram.gif"
 *         alt="MediaPlayer State diagram"
 *         border="0" /></p>
 *
 * <p>From this state diagram, one can see that a MediaPlayer object has the
 *    following states:</p>
 * <ul>
 *     <li>When a MediaPlayer object is just created using <code>new</code> or
 *         after {@link #reset()} is called, it is in the <em>Idle</em> state; and after
 *         {@link #release()} is called, it is in the <em>End</em> state. Between these
 *         two states is the life cycle of the MediaPlayer object.
 *         <ul>
 *         <li>There is a subtle but important difference between a newly constructed
 *         MediaPlayer object and the MediaPlayer object after {@link #reset()}
 *         is called. It is a programming error to invoke methods such
 *         as {@link #getCurrentPosition()},
 *         {@link #getDuration()}, {@link #getVideoHeight()},
 *         {@link #getVideoWidth()}, {@link #setAudioAttributes(android.media.AudioAttributes)},
 *         {@link #setLooping(boolean)},
 *         {@link #setVolume(float,float)}, {@link #pause()}, {@link #start()},
 *         {@link #stop()}, {@link #seekTo(long,int)}, {@link #prepare()} or
 *         {@link #prepareAsync()} in the <em>Idle</em> state for both cases. If any of these
 *         methods is called right after a MediaPlayer object is constructed,
 *         the user supplied callback method OnErrorListener.onError() won't be
 *         called by the internal player engine and the object state remains
 *         unchanged; but if these methods are called right after {@link #reset()},
 *         the user supplied callback method OnErrorListener.onError() will be
 *         invoked by the internal player engine and the object will be
 *         transfered to the <em>Error</em> state. </li>
 *         <li>It is also recommended that once
 *         a MediaPlayer object is no longer being used, call {@link #release()} immediately
 *         so that resources used by the internal player engine associated with the
 *         MediaPlayer object can be released immediately. Resource may include
 *         singleton resources such as hardware acceleration components and
 *         failure to call {@link #release()} may cause subsequent instances of
 *         MediaPlayer objects to fallback to software implementations or fail
 *         altogether. Once the MediaPlayer
 *         object is in the <em>End</em> state, it can no longer be used and
 *         there is no way to bring it back to any other state. </li>
 *         <li>Furthermore,
 *         the MediaPlayer objects created using <code>new</code> is in the
 *         <em>Idle</em> state, while those created with one
 *         of the overloaded convenient <code>create</code> methods are <em>NOT</em>
 *         in the <em>Idle</em> state. In fact, the objects are in the <em>Prepared</em>
 *         state if the creation using <code>create</code> method is successful.
 *         </li>
 *         </ul>
 *         </li>
 *     <li>In general, some playback control operation may fail due to various
 *         reasons, such as unsupported audio/video format, poorly interleaved
 *         audio/video, resolution too high, streaming timeout, and the like.
 *         Thus, error reporting and recovery is an important concern under
 *         these circumstances. Sometimes, due to programming errors, invoking a playback
 *         control operation in an invalid state may also occur. Under all these
 *         error conditions, the internal player engine invokes a user supplied
 *         OnErrorListener.onError() method if an OnErrorListener has been
 *         registered beforehand via
 *         {@link #setOnErrorListener(android.media.MediaPlayer.OnErrorListener)}.
 *         <ul>
 *         <li>It is important to note that once an error occurs, the
 *         MediaPlayer object enters the <em>Error</em> state (except as noted
 *         above), even if an error listener has not been registered by the application.</li>
 *         <li>In order to reuse a MediaPlayer object that is in the <em>
 *         Error</em> state and recover from the error,
 *         {@link #reset()} can be called to restore the object to its <em>Idle</em>
 *         state.</li>
 *         <li>It is good programming practice to have your application
 *         register a OnErrorListener to look out for error notifications from
 *         the internal player engine.</li>
 *         <li>IllegalStateException is
 *         thrown to prevent programming errors such as calling {@link #prepare()},
 *         {@link #prepareAsync()}, or one of the overloaded <code>setDataSource
 *         </code> methods in an invalid state. </li>
 *         </ul>
 *         </li>
 *     <li>Calling
 *         {@link #setDataSource(java.io.FileDescriptor)}, or
 *         {@link #setDataSource(java.lang.String)}, or
 *         {@link #setDataSource(android.content.Context,android.net.Uri)}, or
 *         {@link #setDataSource(java.io.FileDescriptor,long,long)}, or
 *         {@link #setDataSource(android.media.MediaDataSource)} transfers a
 *         MediaPlayer object in the <em>Idle</em> state to the
 *         <em>Initialized</em> state.
 *         <ul>
 *         <li>An IllegalStateException is thrown if
 *         setDataSource() is called in any other state.</li>
 *         <li>It is good programming
 *         practice to always look out for <code>IllegalArgumentException</code>
 *         and <code>IOException</code> that may be thrown from the overloaded
 *         <code>setDataSource</code> methods.</li>
 *         </ul>
 *         </li>
 *     <li>A MediaPlayer object must first enter the <em>Prepared</em> state
 *         before playback can be started.
 *         <ul>
 *         <li>There are two ways (synchronous vs.
 *         asynchronous) that the <em>Prepared</em> state can be reached:
 *         either a call to {@link #prepare()} (synchronous) which
 *         transfers the object to the <em>Prepared</em> state once the method call
 *         returns, or a call to {@link #prepareAsync()} (asynchronous) which
 *         first transfers the object to the <em>Preparing</em> state after the
 *         call returns (which occurs almost right away) while the internal
 *         player engine continues working on the rest of preparation work
 *         until the preparation work completes. When the preparation completes or when {@link #prepare()} call returns,
 *         the internal player engine then calls a user supplied callback method,
 *         onPrepared() of the OnPreparedListener interface, if an
 *         OnPreparedListener is registered beforehand via {@link
 *         #setOnPreparedListener(android.media.MediaPlayer.OnPreparedListener)}.</li>
 *         <li>It is important to note that
 *         the <em>Preparing</em> state is a transient state, and the behavior
 *         of calling any method with side effect while a MediaPlayer object is
 *         in the <em>Preparing</em> state is undefined.</li>
 *         <li>An IllegalStateException is
 *         thrown if {@link #prepare()} or {@link #prepareAsync()} is called in
 *         any other state.</li>
 *         <li>While in the <em>Prepared</em> state, properties
 *         such as audio/sound volume, screenOnWhilePlaying, looping can be
 *         adjusted by invoking the corresponding set methods.</li>
 *         </ul>
 *         </li>
 *     <li>To start the playback, {@link #start()} must be called. After
 *         {@link #start()} returns successfully, the MediaPlayer object is in the
 *         <em>Started</em> state. {@link #isPlaying()} can be called to test
 *         whether the MediaPlayer object is in the <em>Started</em> state.
 *         <ul>
 *         <li>While in the <em>Started</em> state, the internal player engine calls
 *         a user supplied OnBufferingUpdateListener.onBufferingUpdate() callback
 *         method if a OnBufferingUpdateListener has been registered beforehand
 *         via {@link #setOnBufferingUpdateListener(android.media.MediaPlayer.OnBufferingUpdateListener)}.
 *         This callback allows applications to keep track of the buffering status
 *         while streaming audio/video.</li>
 *         <li>Calling {@link #start()} has not effect
 *         on a MediaPlayer object that is already in the <em>Started</em> state.</li>
 *         </ul>
 *         </li>
 *     <li>Playback can be paused and stopped, and the current playback position
 *         can be adjusted. Playback can be paused via {@link #pause()}. When the call to
 *         {@link #pause()} returns, the MediaPlayer object enters the
 *         <em>Paused</em> state. Note that the transition from the <em>Started</em>
 *         state to the <em>Paused</em> state and vice versa happens
 *         asynchronously in the player engine. It may take some time before
 *         the state is updated in calls to {@link #isPlaying()}, and it can be
 *         a number of seconds in the case of streamed content.
 *         <ul>
 *         <li>Calling {@link #start()} to resume playback for a paused
 *         MediaPlayer object, and the resumed playback
 *         position is the same as where it was paused. When the call to
 *         {@link #start()} returns, the paused MediaPlayer object goes back to
 *         the <em>Started</em> state.</li>
 *         <li>Calling {@link #pause()} has no effect on
 *         a MediaPlayer object that is already in the <em>Paused</em> state.</li>
 *         </ul>
 *         </li>
 *     <li>Calling  {@link #stop()} stops playback and causes a
 *         MediaPlayer in the <em>Started</em>, <em>Paused</em>, <em>Prepared
 *         </em> or <em>PlaybackCompleted</em> state to enter the
 *         <em>Stopped</em> state.
 *         <ul>
 *         <li>Once in the <em>Stopped</em> state, playback cannot be started
 *         until {@link #prepare()} or {@link #prepareAsync()} are called to set
 *         the MediaPlayer object to the <em>Prepared</em> state again.</li>
 *         <li>Calling {@link #stop()} has no effect on a MediaPlayer
 *         object that is already in the <em>Stopped</em> state.</li>
 *         </ul>
 *         </li>
 *     <li>The playback position can be adjusted with a call to
 *         {@link #seekTo(long,int)}.
 *         <ul>
 *         <li>Although the asynchronuous {@link #seekTo(long,int)}
 *         call returns right away, the actual seek operation may take a while to
 *         finish, especially for audio/video being streamed. When the actual
 *         seek operation completes, the internal player engine calls a user
 *         supplied OnSeekComplete.onSeekComplete() if an OnSeekCompleteListener
 *         has been registered beforehand via
 *         {@link #setOnSeekCompleteListener(android.media.MediaPlayer.OnSeekCompleteListener)}.</li>
 *         <li>Please
 *         note that {@link #seekTo(long,int)} can also be called in the other states,
 *         such as <em>Prepared</em>, <em>Paused</em> and <em>PlaybackCompleted
 *         </em> state. When {@link #seekTo(long,int)} is called in those states,
 *         one video frame will be displayed if the stream has video and the requested
 *         position is valid.
 *         </li>
 *         <li>Furthermore, the actual current playback position
 *         can be retrieved with a call to {@link #getCurrentPosition()}, which
 *         is helpful for applications such as a Music player that need to keep
 *         track of the playback progress.</li>
 *         </ul>
 *         </li>
 *     <li>When the playback reaches the end of stream, the playback completes.
 *         <ul>
 *         <li>If the looping mode was being set to <var>true</var>with
 *         {@link #setLooping(boolean)}, the MediaPlayer object shall remain in
 *         the <em>Started</em> state.</li>
 *         <li>If the looping mode was set to <var>false
 *         </var>, the player engine calls a user supplied callback method,
 *         OnCompletion.onCompletion(), if a OnCompletionListener is registered
 *         beforehand via {@link #setOnCompletionListener(android.media.MediaPlayer.OnCompletionListener)}.
 *         The invoke of the callback signals that the object is now in the <em>
 *         PlaybackCompleted</em> state.</li>
 *         <li>While in the <em>PlaybackCompleted</em>
 *         state, calling {@link #start()} can restart the playback from the
 *         beginning of the audio/video source.</li>
 * </ul>
 *
 *
 * <a name="Valid_and_Invalid_States"></a>
 * <h3>Valid and invalid states</h3>
 *
 * <table border="0" cellspacing="0" cellpadding="0">
 * <tr><td>Method Name </p></td>
 *     <td>Valid States </p></td>
 *     <td>Invalid States </p></td>
 *     <td>Comments </p></td></tr>
 * <tr><td>attachAuxEffect </p></td>
 *     <td>{Initialized, Prepared, Started, Paused, Stopped, PlaybackCompleted} </p></td>
 *     <td>{Idle, Error} </p></td>
 *     <td>This method must be called after setDataSource.
 *     Calling it does not change the object state. </p></td></tr>
 * <tr><td>getAudioSessionId </p></td>
 *     <td>any </p></td>
 *     <td>{} </p></td>
 *     <td>This method can be called in any state and calling it does not change
 *         the object state. </p></td></tr>
 * <tr><td>getCurrentPosition </p></td>
 *     <td>{Idle, Initialized, Prepared, Started, Paused, Stopped,
 *         PlaybackCompleted} </p></td>
 *     <td>{Error}</p></td>
 *     <td>Successful invoke of this method in a valid state does not change the
 *         state. Calling this method in an invalid state transfers the object
 *         to the <em>Error</em> state. </p></td></tr>
 * <tr><td>getDuration </p></td>
 *     <td>{Prepared, Started, Paused, Stopped, PlaybackCompleted} </p></td>
 *     <td>{Idle, Initialized, Error} </p></td>
 *     <td>Successful invoke of this method in a valid state does not change the
 *         state. Calling this method in an invalid state transfers the object
 *         to the <em>Error</em> state. </p></td></tr>
 * <tr><td>getVideoHeight </p></td>
 *     <td>{Idle, Initialized, Prepared, Started, Paused, Stopped,
 *         PlaybackCompleted}</p></td>
 *     <td>{Error}</p></td>
 *     <td>Successful invoke of this method in a valid state does not change the
 *         state. Calling this method in an invalid state transfers the object
 *         to the <em>Error</em> state.  </p></td></tr>
 * <tr><td>getVideoWidth </p></td>
 *     <td>{Idle, Initialized, Prepared, Started, Paused, Stopped,
 *         PlaybackCompleted}</p></td>
 *     <td>{Error}</p></td>
 *     <td>Successful invoke of this method in a valid state does not change
 *         the state. Calling this method in an invalid state transfers the
 *         object to the <em>Error</em> state. </p></td></tr>
 * <tr><td>isPlaying </p></td>
 *     <td>{Idle, Initialized, Prepared, Started, Paused, Stopped,
 *          PlaybackCompleted}</p></td>
 *     <td>{Error}</p></td>
 *     <td>Successful invoke of this method in a valid state does not change
 *         the state. Calling this method in an invalid state transfers the
 *         object to the <em>Error</em> state. </p></td></tr>
 * <tr><td>pause </p></td>
 *     <td>{Started, Paused, PlaybackCompleted}</p></td>
 *     <td>{Idle, Initialized, Prepared, Stopped, Error}</p></td>
 *     <td>Successful invoke of this method in a valid state transfers the
 *         object to the <em>Paused</em> state. Calling this method in an
 *         invalid state transfers the object to the <em>Error</em> state.</p></td></tr>
 * <tr><td>prepare </p></td>
 *     <td>{Initialized, Stopped} </p></td>
 *     <td>{Idle, Prepared, Started, Paused, PlaybackCompleted, Error} </p></td>
 *     <td>Successful invoke of this method in a valid state transfers the
 *         object to the <em>Prepared</em> state. Calling this method in an
 *         invalid state throws an IllegalStateException.</p></td></tr>
 * <tr><td>prepareAsync </p></td>
 *     <td>{Initialized, Stopped} </p></td>
 *     <td>{Idle, Prepared, Started, Paused, PlaybackCompleted, Error} </p></td>
 *     <td>Successful invoke of this method in a valid state transfers the
 *         object to the <em>Preparing</em> state. Calling this method in an
 *         invalid state throws an IllegalStateException.</p></td></tr>
 * <tr><td>release </p></td>
 *     <td>any </p></td>
 *     <td>{} </p></td>
 *     <td>After {@link #release()}, the object is no longer available. </p></td></tr>
 * <tr><td>reset </p></td>
 *     <td>{Idle, Initialized, Prepared, Started, Paused, Stopped,
 *         PlaybackCompleted, Error}</p></td>
 *     <td>{}</p></td>
 *     <td>After {@link #reset()}, the object is like being just created.</p></td></tr>
 * <tr><td>seekTo </p></td>
 *     <td>{Prepared, Started, Paused, PlaybackCompleted} </p></td>
 *     <td>{Idle, Initialized, Stopped, Error}</p></td>
 *     <td>Successful invoke of this method in a valid state does not change
 *         the state. Calling this method in an invalid state transfers the
 *         object to the <em>Error</em> state. </p></td></tr>
 * <tr><td>setAudioAttributes </p></td>
 *     <td>{Idle, Initialized, Stopped, Prepared, Started, Paused,
 *          PlaybackCompleted}</p></td>
 *     <td>{Error}</p></td>
 *     <td>Successful invoke of this method does not change the state. In order for the
 *         target audio attributes type to become effective, this method must be called before
 *         prepare() or prepareAsync().</p></td></tr>
 * <tr><td>setAudioSessionId </p></td>
 *     <td>{Idle} </p></td>
 *     <td>{Initialized, Prepared, Started, Paused, Stopped, PlaybackCompleted,
 *          Error} </p></td>
 *     <td>This method must be called in idle state as the audio session ID must be known before
 *         calling setDataSource. Calling it does not change the object state. </p></td></tr>
 * <tr><td>setAudioStreamType (deprecated)</p></td>
 *     <td>{Idle, Initialized, Stopped, Prepared, Started, Paused,
 *          PlaybackCompleted}</p></td>
 *     <td>{Error}</p></td>
 *     <td>Successful invoke of this method does not change the state. In order for the
 *         target audio stream type to become effective, this method must be called before
 *         prepare() or prepareAsync().</p></td></tr>
 * <tr><td>setAuxEffectSendLevel </p></td>
 *     <td>any</p></td>
 *     <td>{} </p></td>
 *     <td>Calling this method does not change the object state. </p></td></tr>
 * <tr><td>setDataSource </p></td>
 *     <td>{Idle} </p></td>
 *     <td>{Initialized, Prepared, Started, Paused, Stopped, PlaybackCompleted,
 *          Error} </p></td>
 *     <td>Successful invoke of this method in a valid state transfers the
 *         object to the <em>Initialized</em> state. Calling this method in an
 *         invalid state throws an IllegalStateException.</p></td></tr>
 * <tr><td>setDisplay </p></td>
 *     <td>any </p></td>
 *     <td>{} </p></td>
 *     <td>This method can be called in any state and calling it does not change
 *         the object state. </p></td></tr>
 * <tr><td>setSurface </p></td>
 *     <td>any </p></td>
 *     <td>{} </p></td>
 *     <td>This method can be called in any state and calling it does not change
 *         the object state. </p></td></tr>
 * <tr><td>setVideoScalingMode </p></td>
 *     <td>{Initialized, Prepared, Started, Paused, Stopped, PlaybackCompleted} </p></td>
 *     <td>{Idle, Error}</p></td>
 *     <td>Successful invoke of this method does not change the state.</p></td></tr>
 * <tr><td>setLooping </p></td>
 *     <td>{Idle, Initialized, Stopped, Prepared, Started, Paused,
 *         PlaybackCompleted}</p></td>
 *     <td>{Error}</p></td>
 *     <td>Successful invoke of this method in a valid state does not change
 *         the state. Calling this method in an
 *         invalid state transfers the object to the <em>Error</em> state.</p></td></tr>
 * <tr><td>isLooping </p></td>
 *     <td>any </p></td>
 *     <td>{} </p></td>
 *     <td>This method can be called in any state and calling it does not change
 *         the object state. </p></td></tr>
 * <tr><td>setOnBufferingUpdateListener </p></td>
 *     <td>any </p></td>
 *     <td>{} </p></td>
 *     <td>This method can be called in any state and calling it does not change
 *         the object state. </p></td></tr>
 * <tr><td>setOnCompletionListener </p></td>
 *     <td>any </p></td>
 *     <td>{} </p></td>
 *     <td>This method can be called in any state and calling it does not change
 *         the object state. </p></td></tr>
 * <tr><td>setOnErrorListener </p></td>
 *     <td>any </p></td>
 *     <td>{} </p></td>
 *     <td>This method can be called in any state and calling it does not change
 *         the object state. </p></td></tr>
 * <tr><td>setOnPreparedListener </p></td>
 *     <td>any </p></td>
 *     <td>{} </p></td>
 *     <td>This method can be called in any state and calling it does not change
 *         the object state. </p></td></tr>
 * <tr><td>setOnSeekCompleteListener </p></td>
 *     <td>any </p></td>
 *     <td>{} </p></td>
 *     <td>This method can be called in any state and calling it does not change
 *         the object state. </p></td></tr>
 * <tr><td>setPlaybackParams</p></td>
 *     <td>{Initialized, Prepared, Started, Paused, PlaybackCompleted, Error}</p></td>
 *     <td>{Idle, Stopped} </p></td>
 *     <td>This method will change state in some cases, depending on when it's called.
 *         </p></td></tr>
 * <tr><td>setScreenOnWhilePlaying</></td>
 *     <td>any </p></td>
 *     <td>{} </p></td>
 *     <td>This method can be called in any state and calling it does not change
 *         the object state.  </p></td></tr>
 * <tr><td>setVolume </p></td>
 *     <td>{Idle, Initialized, Stopped, Prepared, Started, Paused,
 *          PlaybackCompleted}</p></td>
 *     <td>{Error}</p></td>
 *     <td>Successful invoke of this method does not change the state.
 * <tr><td>setWakeMode </p></td>
 *     <td>any </p></td>
 *     <td>{} </p></td>
 *     <td>This method can be called in any state and calling it does not change
 *         the object state.</p></td></tr>
 * <tr><td>start </p></td>
 *     <td>{Prepared, Started, Paused, PlaybackCompleted}</p></td>
 *     <td>{Idle, Initialized, Stopped, Error}</p></td>
 *     <td>Successful invoke of this method in a valid state transfers the
 *         object to the <em>Started</em> state. Calling this method in an
 *         invalid state transfers the object to the <em>Error</em> state.</p></td></tr>
 * <tr><td>stop </p></td>
 *     <td>{Prepared, Started, Stopped, Paused, PlaybackCompleted}</p></td>
 *     <td>{Idle, Initialized, Error}</p></td>
 *     <td>Successful invoke of this method in a valid state transfers the
 *         object to the <em>Stopped</em> state. Calling this method in an
 *         invalid state transfers the object to the <em>Error</em> state.</p></td></tr>
 * <tr><td>getTrackInfo </p></td>
 *     <td>{Prepared, Started, Stopped, Paused, PlaybackCompleted}</p></td>
 *     <td>{Idle, Initialized, Error}</p></td>
 *     <td>Successful invoke of this method does not change the state.</p></td></tr>
 * <tr><td>addTimedTextSource </p></td>
 *     <td>{Prepared, Started, Stopped, Paused, PlaybackCompleted}</p></td>
 *     <td>{Idle, Initialized, Error}</p></td>
 *     <td>Successful invoke of this method does not change the state.</p></td></tr>
 * <tr><td>selectTrack </p></td>
 *     <td>{Prepared, Started, Stopped, Paused, PlaybackCompleted}</p></td>
 *     <td>{Idle, Initialized, Error}</p></td>
 *     <td>Successful invoke of this method does not change the state.</p></td></tr>
 * <tr><td>deselectTrack </p></td>
 *     <td>{Prepared, Started, Stopped, Paused, PlaybackCompleted}</p></td>
 *     <td>{Idle, Initialized, Error}</p></td>
 *     <td>Successful invoke of this method does not change the state.</p></td></tr>
 *
 * </table>
 *
 * <a name="Permissions"></a>
 * <h3>Permissions</h3>
 * <p>One may need to declare a corresponding WAKE_LOCK permission {@link
 * android.R.styleable#AndroidManifestUsesPermission &lt;uses-permission&gt;}
 * element.
 *
 * <p>This class requires the {@link android.Manifest.permission#INTERNET} permission
 * when used with network-based content.
 *
 * <a name="Callbacks"></a>
 * <h3>Callbacks</h3>
 * <p>Applications may want to register for informational and error
 * events in order to be informed of some internal state update and
 * possible runtime errors during playback or streaming. Registration for
 * these events is done by properly setting the appropriate listeners (via calls
 * to
 * {@link #setOnPreparedListener(android.media.MediaPlayer.OnPreparedListener)}setOnPreparedListener,
 * {@link #setOnVideoSizeChangedListener(android.media.MediaPlayer.OnVideoSizeChangedListener)}setOnVideoSizeChangedListener,
 * {@link #setOnSeekCompleteListener(android.media.MediaPlayer.OnSeekCompleteListener)}setOnSeekCompleteListener,
 * {@link #setOnCompletionListener(android.media.MediaPlayer.OnCompletionListener)}setOnCompletionListener,
 * {@link #setOnBufferingUpdateListener(android.media.MediaPlayer.OnBufferingUpdateListener)}setOnBufferingUpdateListener,
 * {@link #setOnInfoListener(android.media.MediaPlayer.OnInfoListener)}setOnInfoListener,
 * {@link #setOnErrorListener(android.media.MediaPlayer.OnErrorListener)}setOnErrorListener, etc).
 * In order to receive the respective callback
 * associated with these listeners, applications are required to create
 * MediaPlayer objects on a thread with its own Looper running (main UI
 * thread by default has a Looper running).
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MediaPlayer implements android.media.VolumeAutomation, android.media.AudioRouting {

/**
 * Default constructor. Consider using one of the create() methods for
 * synchronously instantiating a MediaPlayer from a Uri or resource.
 * <p>When done with the MediaPlayer, you should call  {@link #release()},
 * to free the resources. If not released, too many MediaPlayer instances may
 * result in an exception.</p>
 * @apiSince 1
 */

public MediaPlayer() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.view.SurfaceHolder SurfaceHolder} to use for displaying the video
 * portion of the media.
 *
 * Either a surface holder or surface must be set if a display or video sink
 * is needed.  Not calling this method or {@link #setSurface(android.view.Surface)}
 * when playing back a video will result in only the audio track being played.
 * A null surface holder or surface will result in only the audio track being
 * played.
 *
 * @param sh the SurfaceHolder to use for video display
 * @throws java.lang.IllegalStateException if the internal player engine has not been
 * initialized or has been released.
 * @apiSince 1
 */

public void setDisplay(android.view.SurfaceHolder sh) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.view.Surface Surface} to be used as the sink for the video portion of
 * the media. This is similar to {@link #setDisplay(android.view.SurfaceHolder)}, but
 * does not support {@link #setScreenOnWhilePlaying(boolean)}.  Setting a
 * Surface will un-set any Surface or SurfaceHolder that was previously set.
 * A null surface will result in only the audio track being played.
 *
 * If the Surface sends frames to a {@link android.graphics.SurfaceTexture SurfaceTexture}, the timestamps
 * returned from {@link android.graphics.SurfaceTexture#getTimestamp() SurfaceTexture#getTimestamp()} will have an
 * unspecified zero point.  These timestamps cannot be directly compared
 * between different media sources, different instances of the same media
 * source, or multiple runs of the same program.  The timestamp is normally
 * monotonically increasing and is unaffected by time-of-day adjustments,
 * but it is reset when the position is set.
 *
 * @param surface The {@link android.view.Surface Surface} to be used for the video portion of
 * the media.
 * @throws java.lang.IllegalStateException if the internal player engine has not been
 * initialized or has been released.
 * @apiSince 14
 */

public void setSurface(android.view.Surface surface) { throw new RuntimeException("Stub!"); }

/**
 * Sets video scaling mode. To make the target video scaling mode
 * effective during playback, this method must be called after
 * data source is set. If not called, the default video
 * scaling mode is {@link #VIDEO_SCALING_MODE_SCALE_TO_FIT}.
 *
 * <p> The supported video scaling modes are:
 * <ul>
 * <li> {@link #VIDEO_SCALING_MODE_SCALE_TO_FIT}
 * <li> {@link #VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING}
 * </ul>
 *
 * @param mode target video scaling mode. Must be one of the supported
 * video scaling modes; otherwise, IllegalArgumentException will be thrown.
 *
 * @see android.media.MediaPlayer#VIDEO_SCALING_MODE_SCALE_TO_FIT
 * @see android.media.MediaPlayer#VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
 * @apiSince 16
 */

public void setVideoScalingMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to create a MediaPlayer for a given Uri.
 * On success, {@link #prepare()} will already have been called and must not be called again.
 * <p>When done with the MediaPlayer, you should call  {@link #release()},
 * to free the resources. If not released, too many MediaPlayer instances will
 * result in an exception.</p>
 * <p>Note that since {@link #prepare()} is called automatically in this method,
 * you cannot change the audio
 * session ID (see {@link #setAudioSessionId(int)}) or audio attributes
 * (see {@link #setAudioAttributes(android.media.AudioAttributes)} of the new MediaPlayer.</p>
 *
 * @param context the Context to use
 * @param uri the Uri from which to get the datasource
 * @return a MediaPlayer object, or null if creation failed
 * @apiSince 1
 */

public static android.media.MediaPlayer create(android.content.Context context, android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to create a MediaPlayer for a given Uri.
 * On success, {@link #prepare()} will already have been called and must not be called again.
 * <p>When done with the MediaPlayer, you should call  {@link #release()},
 * to free the resources. If not released, too many MediaPlayer instances will
 * result in an exception.</p>
 * <p>Note that since {@link #prepare()} is called automatically in this method,
 * you cannot change the audio
 * session ID (see {@link #setAudioSessionId(int)}) or audio attributes
 * (see {@link #setAudioAttributes(android.media.AudioAttributes)} of the new MediaPlayer.</p>
 *
 * @param context the Context to use
 * @param uri the Uri from which to get the datasource
 * @param holder the SurfaceHolder to use for displaying the video
 * @return a MediaPlayer object, or null if creation failed
 * @apiSince 1
 */

public static android.media.MediaPlayer create(android.content.Context context, android.net.Uri uri, android.view.SurfaceHolder holder) { throw new RuntimeException("Stub!"); }

/**
 * Same factory method as {@link #create(android.content.Context,android.net.Uri,android.view.SurfaceHolder)} but that lets you specify
 * the audio attributes and session ID to be used by the new MediaPlayer instance.
 * @param context the Context to use
 * @param uri the Uri from which to get the datasource
 * @param holder the SurfaceHolder to use for displaying the video, may be null.
 * @param audioAttributes the {@link android.media.AudioAttributes AudioAttributes} to be used by the media player.
 * @param audioSessionId the audio session ID to be used by the media player,
 *     see {@link android.media.AudioManager#generateAudioSessionId() AudioManager#generateAudioSessionId()} to obtain a new session.
 * @return a MediaPlayer object, or null if creation failed
 * @apiSince 21
 */

public static android.media.MediaPlayer create(android.content.Context context, android.net.Uri uri, android.view.SurfaceHolder holder, android.media.AudioAttributes audioAttributes, int audioSessionId) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to create a MediaPlayer for a given resource id.
 * On success, {@link #prepare()} will already have been called and must not be called again.
 * <p>When done with the MediaPlayer, you should call  {@link #release()},
 * to free the resources. If not released, too many MediaPlayer instances will
 * result in an exception.</p>
 * <p>Note that since {@link #prepare()} is called automatically in this method,
 * you cannot change the audio
 * session ID (see {@link #setAudioSessionId(int)}) or audio attributes
 * (see {@link #setAudioAttributes(android.media.AudioAttributes)} of the new MediaPlayer.</p>
 *
 * @param context the Context to use
 * @param resid the raw resource id (<var>R.raw.&lt;something></var>) for
 *              the resource to use as the datasource
 * @return a MediaPlayer object, or null if creation failed
 * @apiSince 1
 */

public static android.media.MediaPlayer create(android.content.Context context, int resid) { throw new RuntimeException("Stub!"); }

/**
 * Same factory method as {@link #create(android.content.Context,int)} but that lets you specify the audio
 * attributes and session ID to be used by the new MediaPlayer instance.
 * @param context the Context to use
 * @param resid the raw resource id (<var>R.raw.&lt;something></var>) for
 *              the resource to use as the datasource
 * @param audioAttributes the {@link android.media.AudioAttributes AudioAttributes} to be used by the media player.
 * @param audioSessionId the audio session ID to be used by the media player,
 *     see {@link android.media.AudioManager#generateAudioSessionId() AudioManager#generateAudioSessionId()} to obtain a new session.
 * @return a MediaPlayer object, or null if creation failed
 * @apiSince 21
 */

public static android.media.MediaPlayer create(android.content.Context context, int resid, android.media.AudioAttributes audioAttributes, int audioSessionId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source as a content Uri.
 *
 * @param context the Context to use when resolving the Uri
 * This value must never be {@code null}.
 * @param uri the Content URI of the data you want to play
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if it is called in an invalid state
 * @apiSince 1
 */

public void setDataSource(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.net.Uri uri) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source as a content Uri.
 *
 * To provide cookies for the subsequent HTTP requests, you can install your own default cookie
 * handler and use other variants of setDataSource APIs instead. Alternatively, you can use
 * this API to pass the cookies as a list of HttpCookie. If the app has not installed
 * a CookieHandler already, this API creates a CookieManager and populates its CookieStore with
 * the provided cookies. If the app has installed its own handler already, this API requires the
 * handler to be of CookieManager type such that the API can update the manager’s CookieStore.
 *
 * <p><strong>Note</strong> that the cross domain redirection is allowed by default,
 * but that can be changed with key/value pairs through the headers parameter with
 * "android-allow-cross-domain-redirect" as the key and "0" or "1" as the value to
 * disallow or allow cross domain redirection.
 *
 * @param context the Context to use when resolving the Uri
 * This value must never be {@code null}.
 * @param uri the Content URI of the data you want to play
 * This value must never be {@code null}.
 * @param headers the headers to be sent together with the request for the data
 *                The headers must not include cookies. Instead, use the cookies param.
 * This value may be {@code null}.
 * @param cookies the cookies to be sent together with the request
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if cookies are provided and the installed handler is not
 *                                  a CookieManager
 * @throws java.lang.IllegalStateException    if it is called in an invalid state
 * @throws java.lang.NullPointerException     if context or uri is null
 * @throws java.io.IOException              if uri has a file scheme and an I/O error occurs
 * @apiSince 26
 */

public void setDataSource(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> headers, @androidx.annotation.Nullable java.util.List<java.net.HttpCookie> cookies) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source as a content Uri.
 *
 * <p><strong>Note</strong> that the cross domain redirection is allowed by default,
 * but that can be changed with key/value pairs through the headers parameter with
 * "android-allow-cross-domain-redirect" as the key and "0" or "1" as the value to
 * disallow or allow cross domain redirection.
 *
 * @param context the Context to use when resolving the Uri
 * This value must never be {@code null}.
 * @param uri the Content URI of the data you want to play
 * This value must never be {@code null}.
 * @param headers the headers to be sent together with the request for the data
 * This value may be {@code null}.
 * @throws java.lang.IllegalStateException if it is called in an invalid state
 * @apiSince 14
 */

public void setDataSource(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> headers) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source (file-path or http/rtsp URL) to use.
 *
 * <p>When <code>path</code> refers to a local file, the file may actually be opened by a
 * process other than the calling application.  This implies that the pathname
 * should be an absolute path (as any other process runs with unspecified current working
 * directory), and that the pathname should reference a world-readable file.
 * As an alternative, the application could first open the file for reading,
 * and then use the file descriptor form {@link #setDataSource(java.io.FileDescriptor)}.
 *
 * @param path the path of the file, or the http/rtsp URL of the stream you want to play
 * @throws java.lang.IllegalStateException if it is called in an invalid state
 * @apiSince 1
 */

public void setDataSource(java.lang.String path) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source (AssetFileDescriptor) to use. It is the caller's
 * responsibility to close the file descriptor. It is safe to do so as soon
 * as this call returns.
 *
 * @param afd the AssetFileDescriptor for the file you want to play
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if it is called in an invalid state
 * @throws java.lang.IllegalArgumentException if afd is not a valid AssetFileDescriptor
 * @throws java.io.IOException if afd can not be read
 * @apiSince 24
 */

public void setDataSource(@androidx.annotation.NonNull android.content.res.AssetFileDescriptor afd) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source (FileDescriptor) to use. It is the caller's responsibility
 * to close the file descriptor. It is safe to do so as soon as this call returns.
 *
 * @param fd the FileDescriptor for the file you want to play
 * @throws java.lang.IllegalStateException if it is called in an invalid state
 * @throws java.lang.IllegalArgumentException if fd is not a valid FileDescriptor
 * @throws java.io.IOException if fd can not be read
 * @apiSince 1
 */

public void setDataSource(java.io.FileDescriptor fd) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source (FileDescriptor) to use.  The FileDescriptor must be
 * seekable (N.B. a LocalSocket is not seekable). It is the caller's responsibility
 * to close the file descriptor. It is safe to do so as soon as this call returns.
 *
 * @param fd the FileDescriptor for the file you want to play
 * @param offset the offset into the file where the data to be played starts, in bytes
 * @param length the length in bytes of the data to be played
 * @throws java.lang.IllegalStateException if it is called in an invalid state
 * @throws java.lang.IllegalArgumentException if fd is not a valid FileDescriptor
 * @throws java.io.IOException if fd can not be read
 * @apiSince 1
 */

public void setDataSource(java.io.FileDescriptor fd, long offset, long length) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source (MediaDataSource) to use.
 *
 * @param dataSource the MediaDataSource for the media you want to play
 * @throws java.lang.IllegalStateException if it is called in an invalid state
 * @throws java.lang.IllegalArgumentException if dataSource is not a valid MediaDataSource
 * @apiSince 23
 */

public void setDataSource(android.media.MediaDataSource dataSource) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Prepares the player for playback, synchronously.
 *
 * After setting the datasource and the display surface, you need to either
 * call prepare() or prepareAsync(). For files, it is OK to call prepare(),
 * which blocks until MediaPlayer is ready for playback.
 *
 * @throws java.lang.IllegalStateException if it is called in an invalid state
 * @apiSince 1
 */

public void prepare() throws java.io.IOException, java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Prepares the player for playback, asynchronously.
 *
 * After setting the datasource and the display surface, you need to either
 * call prepare() or prepareAsync(). For streams, you should call prepareAsync(),
 * which returns immediately, rather than blocking until enough data has been
 * buffered.
 *
 * @throws java.lang.IllegalStateException if it is called in an invalid state
 * @apiSince 1
 */

public native void prepareAsync() throws java.lang.IllegalStateException;

/**
 * Starts or resumes playback. If playback had previously been paused,
 * playback will continue from where it was paused. If playback had
 * been stopped, or never started before, playback will start at the
 * beginning.
 *
 * @throws java.lang.IllegalStateException if it is called in an invalid state
 * @apiSince 1
 */

public void start() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Stops playback after playback has been started or paused.
 *
 * @throws java.lang.IllegalStateException if the internal player engine has not been
 * initialized.
 * @apiSince 1
 */

public void stop() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Pauses playback. Call start() to resume.
 *
 * @throws java.lang.IllegalStateException if the internal player engine has not been
 * initialized.
 * @apiSince 1
 */

public void pause() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param configuration This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.media.VolumeShaper createVolumeShaper(@androidx.annotation.NonNull android.media.VolumeShaper.Configuration configuration) { throw new RuntimeException("Stub!"); }

/**
 * Specifies an audio device (via an {@link android.media.AudioDeviceInfo AudioDeviceInfo} object) to route
 * the output from this MediaPlayer.
 * @param deviceInfo The {@link android.media.AudioDeviceInfo AudioDeviceInfo} specifying the audio sink or source.
 *  If deviceInfo is null, default routing is restored.
 * @return true if succesful, false if the specified {@link android.media.AudioDeviceInfo AudioDeviceInfo} is non-null and
 * does not correspond to a valid audio device.
 * @apiSince 28
 */

public boolean setPreferredDevice(android.media.AudioDeviceInfo deviceInfo) { throw new RuntimeException("Stub!"); }

/**
 * Returns the selected output specified by {@link #setPreferredDevice}. Note that this
 * is not guaranteed to correspond to the actual device being used for playback.
 * @apiSince 28
 */

public android.media.AudioDeviceInfo getPreferredDevice() { throw new RuntimeException("Stub!"); }

/**
 * Returns an {@link android.media.AudioDeviceInfo AudioDeviceInfo} identifying the current routing of this MediaPlayer
 * Note: The query is only valid if the MediaPlayer is currently playing.
 * If the player is not playing, the returned device can be null or correspond to previously
 * selected device when the player was last active.
 * @apiSince 28
 */

public android.media.AudioDeviceInfo getRoutedDevice() { throw new RuntimeException("Stub!"); }

/**
 * Adds an {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} to receive notifications of routing
 * changes on this MediaPlayer.
 * @param listener The {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} interface to receive
 * notifications of rerouting events.
 * @param handler  Specifies the {@link android.os.Handler Handler} object for the thread on which to execute
 * the callback. If <code>null</code>, the handler on the main looper will be used.
 * @apiSince 28
 */

public void addOnRoutingChangedListener(android.media.AudioRouting.OnRoutingChangedListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Removes an {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} which has been previously added
 * to receive rerouting notifications.
 * @param listener The previously added {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} interface
 * to remove.
 * @apiSince 28
 */

public void removeOnRoutingChangedListener(android.media.AudioRouting.OnRoutingChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set the low-level power management behavior for this MediaPlayer.  This
 * can be used when the MediaPlayer is not playing through a SurfaceHolder
 * set with {@link #setDisplay(android.view.SurfaceHolder)} and thus can use the
 * high-level {@link #setScreenOnWhilePlaying(boolean)} feature.
 *
 * <p>This function has the MediaPlayer access the low-level power manager
 * service to control the device's power usage while playing is occurring.
 * The parameter is a combination of {@link android.os.PowerManager} wake flags.
 * Use of this method requires {@link android.Manifest.permission#WAKE_LOCK}
 * permission.
 * By default, no attempt is made to keep the device awake during playback.
 *
 * @param context the Context to use
 * @param mode    the power/wake mode to set
 * @see android.os.PowerManager
 * @apiSince 1
 */

public void setWakeMode(android.content.Context context, int mode) { throw new RuntimeException("Stub!"); }

/**
 * Control whether we should use the attached SurfaceHolder to keep the
 * screen on while video playback is occurring.  This is the preferred
 * method over {@link #setWakeMode} where possible, since it doesn't
 * require that the application have permission for low-level wake lock
 * access.
 *
 * @param screenOn Supply true to keep the screen on, false to allow it
 * to turn off.
 * @apiSince 1
 */

public void setScreenOnWhilePlaying(boolean screenOn) { throw new RuntimeException("Stub!"); }

/**
 * Returns the width of the video.
 *
 * @return the width of the video, or 0 if there is no video,
 * no display surface was set, or the width has not been determined
 * yet. The OnVideoSizeChangedListener can be registered via
 * {@link #setOnVideoSizeChangedListener(android.media.MediaPlayer.OnVideoSizeChangedListener)}
 * to provide a notification when the width is available.
 * @apiSince 1
 */

public native int getVideoWidth();

/**
 * Returns the height of the video.
 *
 * @return the height of the video, or 0 if there is no video,
 * no display surface was set, or the height has not been determined
 * yet. The OnVideoSizeChangedListener can be registered via
 * {@link #setOnVideoSizeChangedListener(android.media.MediaPlayer.OnVideoSizeChangedListener)}
 * to provide a notification when the height is available.
 * @apiSince 1
 */

public native int getVideoHeight();

/**
 * Return Metrics data about the current player.
 *
 * @return a {@link android.os.PersistableBundle PersistableBundle} containing the set of attributes and values
 * available for the media being handled by this instance of MediaPlayer
 * The attributes are descibed in {@link android.media.MediaPlayer.MetricsConstants MetricsConstants}.
 *
 *  Additional vendor-specific fields may also be present in
 *  the return value.
 * @apiSince 26
 */

public android.os.PersistableBundle getMetrics() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the MediaPlayer is playing.
 *
 * @return true if currently playing, false otherwise
 * @throws java.lang.IllegalStateException if the internal player engine has not been
 * initialized or has been released.
 * @apiSince 1
 */

public native boolean isPlaying();

/**
 * Sets playback rate using {@link android.media.PlaybackParams PlaybackParams}. The object sets its internal
 * PlaybackParams to the input, except that the object remembers previous speed
 * when input speed is zero. This allows the object to resume at previous speed
 * when start() is called. Calling it before the object is prepared does not change
 * the object state. After the object is prepared, calling it with zero speed is
 * equivalent to calling pause(). After the object is prepared, calling it with
 * non-zero speed is equivalent to calling start().
 *
 * @param params the playback params.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if the internal player engine has not been
 * initialized or has been released.
 * @throws java.lang.IllegalArgumentException if params is not supported.
 * @apiSince 23
 */

public native void setPlaybackParams(@androidx.annotation.NonNull android.media.PlaybackParams params);

/**
 * Gets the playback params, containing the current playback rate.
 *
 * @return the playback params.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException if the internal player engine has not been
 * initialized.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public native android.media.PlaybackParams getPlaybackParams();

/**
 * Sets A/V sync mode.
 *
 * @param params the A/V sync params to apply
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if the internal player engine has not been
 * initialized.
 * @throws java.lang.IllegalArgumentException if params are not supported.
 * @apiSince 23
 */

public native void setSyncParams(@androidx.annotation.NonNull android.media.SyncParams params);

/**
 * Gets the A/V sync mode.
 *
 * @return the A/V sync params
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException if the internal player engine has not been
 * initialized.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public native android.media.SyncParams getSyncParams();

/**
 * Moves the media to specified time position by considering the given mode.
 * <p>
 * When seekTo is finished, the user will be notified via OnSeekComplete supplied by the user.
 * There is at most one active seekTo processed at any time. If there is a to-be-completed
 * seekTo, new seekTo requests will be queued in such a way that only the last request
 * is kept. When current seekTo is completed, the queued request will be processed if
 * that request is different from just-finished seekTo operation, i.e., the requested
 * position or mode is different.
 *
 * @param msec the offset in milliseconds from the start to seek to.
 * When seeking to the given time position, there is no guarantee that the data source
 * has a frame located at the position. When this happens, a frame nearby will be rendered.
 * If msec is negative, time position zero will be used.
 * If msec is larger than duration, duration will be used.
 * @param mode the mode indicating where exactly to seek to.
 * Use {@link #SEEK_PREVIOUS_SYNC} if one wants to seek to a sync frame
 * that has a timestamp earlier than or the same as msec. Use
 * {@link #SEEK_NEXT_SYNC} if one wants to seek to a sync frame
 * that has a timestamp later than or the same as msec. Use
 * {@link #SEEK_CLOSEST_SYNC} if one wants to seek to a sync frame
 * that has a timestamp closest to or the same as msec. Use
 * {@link #SEEK_CLOSEST} if one wants to seek to a frame that may
 * or may not be a sync frame but is closest to or the same as msec.
 * {@link #SEEK_CLOSEST} often has larger performance overhead compared
 * to the other options if there is no sync frame located at msec.
 * Value is {@link android.media.MediaPlayer#SEEK_PREVIOUS_SYNC}, {@link android.media.MediaPlayer#SEEK_NEXT_SYNC}, {@link android.media.MediaPlayer#SEEK_CLOSEST_SYNC}, or {@link android.media.MediaPlayer#SEEK_CLOSEST}
 * @throws java.lang.IllegalStateException if the internal player engine has not been
 * initialized
 * @throws java.lang.IllegalArgumentException if the mode is invalid.
 * @apiSince 26
 */

public void seekTo(long msec, int mode) { throw new RuntimeException("Stub!"); }

/**
 * Seeks to specified time position.
 * Same as {@link #seekTo(long,int)} with {@code mode = SEEK_PREVIOUS_SYNC}.
 *
 * @param msec the offset in milliseconds from the start to seek to
 * @throws java.lang.IllegalStateException if the internal player engine has not been
 * initialized
 * @apiSince 1
 */

public void seekTo(int msec) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Get current playback position as a {@link android.media.MediaTimestamp MediaTimestamp}.
 * <p>
 * The MediaTimestamp represents how the media time correlates to the system time in
 * a linear fashion using an anchor and a clock rate. During regular playback, the media
 * time moves fairly constantly (though the anchor frame may be rebased to a current
 * system time, the linear correlation stays steady). Therefore, this method does not
 * need to be called often.
 * <p>
 * To help users get current playback position, this method always anchors the timestamp
 * to the current {@link java.lang.System#nanoTime System#nanoTime}, so
 * {@link android.media.MediaTimestamp#getAnchorMediaTimeUs MediaTimestamp#getAnchorMediaTimeUs} can be used as current playback position.
 *
 * @return a MediaTimestamp object if a timestamp is available, or {@code null} if no timestamp
 *         is available, e.g. because the media player has not been initialized.
 *
 * @see android.media.MediaTimestamp
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.media.MediaTimestamp getTimestamp() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current playback position.
 *
 * @return the current position in milliseconds
 * @apiSince 1
 */

public native int getCurrentPosition();

/**
 * Gets the duration of the file.
 *
 * @return the duration in milliseconds, if no duration is available
 *         (for example, if streaming live content), -1 is returned.
 * @apiSince 1
 */

public native int getDuration();

/**
 * Set the MediaPlayer to start when this MediaPlayer finishes playback
 * (i.e. reaches the end of the stream).
 * The media framework will attempt to transition from this player to
 * the next as seamlessly as possible. The next player can be set at
 * any time before completion, but shall be after setDataSource has been
 * called successfully. The next player must be prepared by the
 * app, and the application should not call start() on it.
 * The next MediaPlayer must be different from 'this'. An exception
 * will be thrown if next == this.
 * The application may call setNextMediaPlayer(null) to indicate no
 * next player should be started at the end of playback.
 * If the current player is looping, it will keep looping and the next
 * player will not be started.
 *
 * @param next the player to start after this one completes playback.
 *
 * @apiSince 16
 */

public native void setNextMediaPlayer(android.media.MediaPlayer next);

/**
 * Releases resources associated with this MediaPlayer object.
 * It is considered good practice to call this method when you're
 * done using the MediaPlayer. In particular, whenever an Activity
 * of an application is paused (its onPause() method is called),
 * or stopped (its onStop() method is called), this method should be
 * invoked to release the MediaPlayer object, unless the application
 * has a special need to keep the object around. In addition to
 * unnecessary resources (such as memory and instances of codecs)
 * being held, failure to call this method immediately if a
 * MediaPlayer object is no longer needed may also lead to
 * continuous battery consumption for mobile devices, and playback
 * failure for other applications if no multiple instances of the
 * same codec are supported on a device. Even if multiple instances
 * of the same codec are supported, some performance degradation
 * may be expected when unnecessary multiple instances are used
 * at the same time.
 * @apiSince 1
 */

public void release() { throw new RuntimeException("Stub!"); }

/**
 * Resets the MediaPlayer to its uninitialized state. After calling
 * this method, you will have to initialize it again by setting the
 * data source and calling prepare().
 * @apiSince 1
 */

public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Sets the audio stream type for this MediaPlayer. See {@link android.media.AudioManager AudioManager}
 * for a list of stream types. Must call this method before prepare() or
 * prepareAsync() in order for the target stream type to become effective
 * thereafter.
 *
 * @param streamtype the audio stream type
 * @deprecated use {@link #setAudioAttributes(android.media.AudioAttributes)}
 * @see android.media.AudioManager
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public void setAudioStreamType(int streamtype) { throw new RuntimeException("Stub!"); }

/**
 * Sets the audio attributes for this MediaPlayer.
 * See {@link android.media.AudioAttributes AudioAttributes} for how to build and configure an instance of this class.
 * You must call this method before {@link #prepare()} or {@link #prepareAsync()} in order
 * for the audio attributes to become effective thereafter.
 * @param attributes a non-null set of audio attributes
 * @apiSince 21
 */

public void setAudioAttributes(android.media.AudioAttributes attributes) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the player to be looping or non-looping.
 *
 * @param looping whether to loop or not
 * @apiSince 1
 */

public native void setLooping(boolean looping);

/**
 * Checks whether the MediaPlayer is looping or non-looping.
 *
 * @return true if the MediaPlayer is currently looping, false otherwise
 * @apiSince 3
 */

public native boolean isLooping();

/**
 * Sets the volume on this player.
 * This API is recommended for balancing the output of audio streams
 * within an application. Unless you are writing an application to
 * control user settings, this API should be used in preference to
 * {@link android.media.AudioManager#setStreamVolume(int,int,int) AudioManager#setStreamVolume(int, int, int)} which sets the volume of ALL streams of
 * a particular type. Note that the passed volume values are raw scalars in range 0.0 to 1.0.
 * UI controls should be scaled logarithmically.
 *
 * @param leftVolume left volume scalar
 * @param rightVolume right volume scalar
 * @apiSince 1
 */

public void setVolume(float leftVolume, float rightVolume) { throw new RuntimeException("Stub!"); }

/**
 * Sets the audio session ID.
 *
 * @param sessionId the audio session ID.
 * The audio session ID is a system wide unique identifier for the audio stream played by
 * this MediaPlayer instance.
 * The primary use of the audio session ID  is to associate audio effects to a particular
 * instance of MediaPlayer: if an audio session ID is provided when creating an audio effect,
 * this effect will be applied only to the audio content of media players within the same
 * audio session and not to the output mix.
 * When created, a MediaPlayer instance automatically generates its own audio session ID.
 * However, it is possible to force this player to be part of an already existing audio session
 * by calling this method.
 * This method must be called before one of the overloaded <code> setDataSource </code> methods.
 * @throws java.lang.IllegalStateException if it is called in an invalid state
 * @apiSince 9
 */

public native void setAudioSessionId(int sessionId) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException;

/**
 * Returns the audio session ID.
 *
 * @return the audio session ID. {@see #setAudioSessionId(int)}
 * Note that the audio session ID is 0 only if a problem occured when the MediaPlayer was contructed.
 * @apiSince 9
 */

public native int getAudioSessionId();

/**
 * Attaches an auxiliary effect to the player. A typical auxiliary effect is a reverberation
 * effect which can be applied on any sound source that directs a certain amount of its
 * energy to this effect. This amount is defined by setAuxEffectSendLevel().
 * See {@link #setAuxEffectSendLevel(float)}.
 * <p>After creating an auxiliary effect (e.g.
 * {@link android.media.audiofx.EnvironmentalReverb}), retrieve its ID with
 * {@link android.media.audiofx.AudioEffect#getId()} and use it when calling this method
 * to attach the player to the effect.
 * <p>To detach the effect from the player, call this method with a null effect id.
 * <p>This method must be called after one of the overloaded <code> setDataSource </code>
 * methods.
 * @param effectId system wide unique id of the effect to attach
 * @apiSince 9
 */

public native void attachAuxEffect(int effectId);

/**
 * Sets the send level of the player to the attached auxiliary effect.
 * See {@link #attachAuxEffect(int)}. The level value range is 0 to 1.0.
 * <p>By default the send level is 0, so even if an effect is attached to the player
 * this method must be called for the effect to be applied.
 * <p>Note that the passed level value is a raw scalar. UI controls should be scaled
 * logarithmically: the gain applied by audio framework ranges from -72dB to 0dB,
 * so an appropriate conversion from linear UI input x to level is:
 * x == 0 -> level = 0
 * 0 < x <= R -> level = 10^(72*(x-R)/20/R)
 * @param level send level scalar
 * @apiSince 9
 */

public void setAuxEffectSendLevel(float level) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of track information.
 *
 * @return Array of track info. The total number of tracks is the array length.
 * Must be called again if an external timed text source has been added after any of the
 * addTimedTextSource methods are called.
 * @throws java.lang.IllegalStateException if it is called in an invalid state.
 * @apiSince 16
 */

public android.media.MediaPlayer.TrackInfo[] getTrackInfo() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Adds an external timed text source file.
 *
 * Currently supported format is SubRip with the file extension .srt, case insensitive.
 * Note that a single external timed text source may contain multiple tracks in it.
 * One can find the total number of available tracks using {@link #getTrackInfo()} to see what
 * additional tracks become available after this method call.
 *
 * @param path The file path of external timed text source file.
 * @param mimeType The mime type of the file. Must be one of the mime types listed above.
 * @throws java.io.IOException if the file cannot be accessed or is corrupted.
 * @throws java.lang.IllegalArgumentException if the mimeType is not supported.
 * @throws java.lang.IllegalStateException if called in an invalid state.
 * @apiSince 16
 */

public void addTimedTextSource(java.lang.String path, java.lang.String mimeType) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Adds an external timed text source file (Uri).
 *
 * Currently supported format is SubRip with the file extension .srt, case insensitive.
 * Note that a single external timed text source may contain multiple tracks in it.
 * One can find the total number of available tracks using {@link #getTrackInfo()} to see what
 * additional tracks become available after this method call.
 *
 * @param context the Context to use when resolving the Uri
 * @param uri the Content URI of the data you want to play
 * @param mimeType The mime type of the file. Must be one of the mime types listed above.
 * @throws java.io.IOException if the file cannot be accessed or is corrupted.
 * @throws java.lang.IllegalArgumentException if the mimeType is not supported.
 * @throws java.lang.IllegalStateException if called in an invalid state.
 * @apiSince 16
 */

public void addTimedTextSource(android.content.Context context, android.net.Uri uri, java.lang.String mimeType) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Adds an external timed text source file (FileDescriptor).
 *
 * It is the caller's responsibility to close the file descriptor.
 * It is safe to do so as soon as this call returns.
 *
 * Currently supported format is SubRip. Note that a single external timed text source may
 * contain multiple tracks in it. One can find the total number of available tracks
 * using {@link #getTrackInfo()} to see what additional tracks become available
 * after this method call.
 *
 * @param fd the FileDescriptor for the file you want to play
 * @param mimeType The mime type of the file. Must be one of the mime types listed above.
 * @throws java.lang.IllegalArgumentException if the mimeType is not supported.
 * @throws java.lang.IllegalStateException if called in an invalid state.
 * @apiSince 16
 */

public void addTimedTextSource(java.io.FileDescriptor fd, java.lang.String mimeType) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Adds an external timed text file (FileDescriptor).
 *
 * It is the caller's responsibility to close the file descriptor.
 * It is safe to do so as soon as this call returns.
 *
 * Currently supported format is SubRip. Note that a single external timed text source may
 * contain multiple tracks in it. One can find the total number of available tracks
 * using {@link #getTrackInfo()} to see what additional tracks become available
 * after this method call.
 *
 * @param fd the FileDescriptor for the file you want to play
 * @param offset the offset into the file where the data to be played starts, in bytes
 * @param length the length in bytes of the data to be played
 * @param mime The mime type of the file. Must be one of the mime types listed above.
 * @throws java.lang.IllegalArgumentException if the mimeType is not supported.
 * @throws java.lang.IllegalStateException if called in an invalid state.
 * @apiSince 16
 */

public void addTimedTextSource(java.io.FileDescriptor fd, long offset, long length, java.lang.String mime) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Returns the index of the audio, video, or subtitle track currently selected for playback,
 * The return value is an index into the array returned by {@link #getTrackInfo()}, and can
 * be used in calls to {@link #selectTrack(int)} or {@link #deselectTrack(int)}.
 *
 * @param trackType should be one of {@link android.media.MediaPlayer.TrackInfo#MEDIA_TRACK_TYPE_VIDEO TrackInfo#MEDIA_TRACK_TYPE_VIDEO},
 * {@link android.media.MediaPlayer.TrackInfo#MEDIA_TRACK_TYPE_AUDIO TrackInfo#MEDIA_TRACK_TYPE_AUDIO}, or
 * {@link android.media.MediaPlayer.TrackInfo#MEDIA_TRACK_TYPE_SUBTITLE TrackInfo#MEDIA_TRACK_TYPE_SUBTITLE}
 * @return index of the audio, video, or subtitle track currently selected for playback;
 * a negative integer is returned when there is no selected track for {@code trackType} or
 * when {@code trackType} is not one of audio, video, or subtitle.
 * @throws java.lang.IllegalStateException if called after {@link #release()}
 *
 * @see #getTrackInfo()
 * @see #selectTrack(int)
 * @see #deselectTrack(int)
 * @apiSince 21
 */

public int getSelectedTrack(int trackType) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Selects a track.
 * <p>
 * If a MediaPlayer is in invalid state, it throws an IllegalStateException exception.
 * If a MediaPlayer is in <em>Started</em> state, the selected track is presented immediately.
 * If a MediaPlayer is not in Started state, it just marks the track to be played.
 * </p>
 * <p>
 * In any valid state, if it is called multiple times on the same type of track (ie. Video,
 * Audio, Timed Text), the most recent one will be chosen.
 * </p>
 * <p>
 * The first audio and video tracks are selected by default if available, even though
 * this method is not called. However, no timed text track will be selected until
 * this function is called.
 * </p>
 * <p>
 * Currently, only timed text, subtitle or audio tracks can be selected via this method.
 * In addition, the support for selecting an audio track at runtime is pretty limited
 * in that an audio track can only be selected in the <em>Prepared</em> state.
 * </p>
 * @param index the index of the track to be selected. The valid range of the index
 * is 0..total number of track - 1. The total number of tracks as well as the type of
 * each individual track can be found by calling {@link #getTrackInfo()} method.
 * @throws java.lang.IllegalStateException if called in an invalid state.
 *
 * @see android.media.MediaPlayer#getTrackInfo
 * @apiSince 16
 */

public void selectTrack(int index) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Deselect a track.
 * <p>
 * Currently, the track must be a timed text track and no audio or video tracks can be
 * deselected. If the timed text track identified by index has not been
 * selected before, it throws an exception.
 * </p>
 * @param index the index of the track to be deselected. The valid range of the index
 * is 0..total number of tracks - 1. The total number of tracks as well as the type of
 * each individual track can be found by calling {@link #getTrackInfo()} method.
 * @throws java.lang.IllegalStateException if called in an invalid state.
 *
 * @see android.media.MediaPlayer#getTrackInfo
 * @apiSince 16
 */

public void deselectTrack(int index) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the media source is ready
 * for playback.
 *
 * @param listener the callback that will be run
 * @apiSince 1
 */

public void setOnPreparedListener(android.media.MediaPlayer.OnPreparedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the end of a media source
 * has been reached during playback.
 *
 * @param listener the callback that will be run
 * @apiSince 1
 */

public void setOnCompletionListener(android.media.MediaPlayer.OnCompletionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the status of a network
 * stream's buffer has changed.
 *
 * @param listener the callback that will be run.
 * @apiSince 1
 */

public void setOnBufferingUpdateListener(android.media.MediaPlayer.OnBufferingUpdateListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when a seek operation has been
 * completed.
 *
 * @param listener the callback that will be run
 * @apiSince 1
 */

public void setOnSeekCompleteListener(android.media.MediaPlayer.OnSeekCompleteListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the video size is
 * known or updated.
 *
 * @param listener the callback that will be run
 * @apiSince 3
 */

public void setOnVideoSizeChangedListener(android.media.MediaPlayer.OnVideoSizeChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when a timed text is available
 * for display.
 *
 * @param listener the callback that will be run
 * @apiSince 16
 */

public void setOnTimedTextListener(android.media.MediaPlayer.OnTimedTextListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to be invoked when a subtitle track has new data available.
 * The subtitle data comes from a subtitle track previously selected with
 * {@link #selectTrack(int)}. Use {@link #getTrackInfo()} to determine which tracks are
 * subtitles (of type {@link android.media.MediaPlayer.TrackInfo#MEDIA_TRACK_TYPE_SUBTITLE TrackInfo#MEDIA_TRACK_TYPE_SUBTITLE}), Subtitle track encodings
 * can be determined by {@link android.media.MediaPlayer.TrackInfo#getFormat() TrackInfo#getFormat()}).<br>
 * See {@link android.media.SubtitleData SubtitleData} for an example of querying subtitle encoding.
 * @param listener the listener called when new data is available
 * This value must never be {@code null}.
 * @param handler the {@link android.os.Handler Handler} that receives the listener events
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void setOnSubtitleDataListener(@androidx.annotation.NonNull android.media.MediaPlayer.OnSubtitleDataListener listener, @androidx.annotation.NonNull android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to be invoked when a subtitle track has new data available.
 * The subtitle data comes from a subtitle track previously selected with
 * {@link #selectTrack(int)}. Use {@link #getTrackInfo()} to determine which tracks are
 * subtitles (of type {@link android.media.MediaPlayer.TrackInfo#MEDIA_TRACK_TYPE_SUBTITLE TrackInfo#MEDIA_TRACK_TYPE_SUBTITLE}), Subtitle track encodings
 * can be determined by {@link android.media.MediaPlayer.TrackInfo#getFormat() TrackInfo#getFormat()}).<br>
 * See {@link android.media.SubtitleData SubtitleData} for an example of querying subtitle encoding.<br>
 * The listener will be called on the same thread as the one in which the MediaPlayer was
 * created.
 * @param listener the listener called when new data is available
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void setOnSubtitleDataListener(@androidx.annotation.NonNull android.media.MediaPlayer.OnSubtitleDataListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Clears the listener previously set with
 * {@link #setOnSubtitleDataListener(android.media.MediaPlayer.OnSubtitleDataListener)} or
 * {@link #setOnSubtitleDataListener(android.media.MediaPlayer.OnSubtitleDataListener,android.os.Handler)}.
 * @apiSince 28
 */

public void clearOnSubtitleDataListener() { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to be invoked when a media time discontinuity is encountered.
 * @param listener the listener called after a discontinuity
 * This value must never be {@code null}.
 * @param handler the {@link android.os.Handler Handler} that receives the listener events
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void setOnMediaTimeDiscontinuityListener(@androidx.annotation.NonNull android.media.MediaPlayer.OnMediaTimeDiscontinuityListener listener, @androidx.annotation.NonNull android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to be invoked when a media time discontinuity is encountered.
 * The listener will be called on the same thread as the one in which the MediaPlayer was
 * created.
 * @param listener the listener called after a discontinuity
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void setOnMediaTimeDiscontinuityListener(@androidx.annotation.NonNull android.media.MediaPlayer.OnMediaTimeDiscontinuityListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Clears the listener previously set with
 * {@link #setOnMediaTimeDiscontinuityListener(android.media.MediaPlayer.OnMediaTimeDiscontinuityListener)}
 * or {@link #setOnMediaTimeDiscontinuityListener(android.media.MediaPlayer.OnMediaTimeDiscontinuityListener,android.os.Handler)}
 * @apiSince 28
 */

public void clearOnMediaTimeDiscontinuityListener() { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when a selected track has timed metadata available.
 * <p>
 * Currently only HTTP live streaming data URI's embedded with timed ID3 tags generates
 * {@link android.media.TimedMetaData TimedMetaData}.
 *
 * @see android.media.MediaPlayer#selectTrack(int)
 * @see android.media.MediaPlayer.OnTimedMetaDataAvailableListener
 * @see android.media.TimedMetaData
 *
 * @param listener the callback that will be run
 * @apiSince 23
 */

public void setOnTimedMetaDataAvailableListener(android.media.MediaPlayer.OnTimedMetaDataAvailableListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when an error has happened
 * during an asynchronous operation.
 *
 * @param listener the callback that will be run
 * @apiSince 1
 */

public void setOnErrorListener(android.media.MediaPlayer.OnErrorListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when an info/warning is available.
 *
 * @param listener the callback that will be run
 * @apiSince 3
 */

public void setOnInfoListener(android.media.MediaPlayer.OnInfoListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked for configuration of the DRM object before
 * the session is created.
 * The callback will be invoked synchronously during the execution
 * of {@link #prepareDrm(java.util.UUID)}.
 *
 * @param listener the callback that will be run
 * @apiSince 26
 */

public void setOnDrmConfigHelper(android.media.MediaPlayer.OnDrmConfigHelper listener) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the DRM info is
 * known.
 *
 * @param listener the callback that will be run
 * @apiSince 26
 */

public void setOnDrmInfoListener(android.media.MediaPlayer.OnDrmInfoListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the DRM info is
 * known.
 *
 * @param listener the callback that will be run
 * @apiSince 26
 */

public void setOnDrmInfoListener(android.media.MediaPlayer.OnDrmInfoListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the DRM object is prepared.
 *
 * @param listener the callback that will be run
 * @apiSince 26
 */

public void setOnDrmPreparedListener(android.media.MediaPlayer.OnDrmPreparedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the DRM object is prepared.
 *
 * @param listener the callback that will be run
 * @param handler the Handler that will receive the callback
 * @apiSince 26
 */

public void setOnDrmPreparedListener(android.media.MediaPlayer.OnDrmPreparedListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the DRM Info associated with the current source
 *
 * @throws java.lang.IllegalStateException if called before prepare()
 * @apiSince 26
 */

public android.media.MediaPlayer.DrmInfo getDrmInfo() { throw new RuntimeException("Stub!"); }

/**
 * Prepares the DRM for the current source
 * <p>
 * If {@code OnDrmConfigHelper} is registered, it will be called during
 * preparation to allow configuration of the DRM properties before opening the
 * DRM session. Note that the callback is called synchronously in the thread that called
 * {@code prepareDrm}. It should be used only for a series of {@code getDrmPropertyString}
 * and {@code setDrmPropertyString} calls and refrain from any lengthy operation.
 * <p>
 * If the device has not been provisioned before, this call also provisions the device
 * which involves accessing the provisioning server and can take a variable time to
 * complete depending on the network connectivity.
 * If {@code OnDrmPreparedListener} is registered, prepareDrm() runs in non-blocking
 * mode by launching the provisioning in the background and returning. The listener
 * will be called when provisioning and preparation has finished. If a
 * {@code OnDrmPreparedListener} is not registered, prepareDrm() waits till provisioning
 * and preparation has finished, i.e., runs in blocking mode.
 * <p>
 * If {@code OnDrmPreparedListener} is registered, it is called to indicate the DRM
 * session being ready. The application should not make any assumption about its call
 * sequence (e.g., before or after prepareDrm returns), or the thread context that will
 * execute the listener (unless the listener is registered with a handler thread).
 * <p>
 *
 * @param uuid The UUID of the crypto scheme. If not known beforehand, it can be retrieved
 * from the source through {@code getDrmInfo} or registering a {@code onDrmInfoListener}.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException              if called before prepare(), or the DRM was
 *                                            prepared already
 * @throws android.media.UnsupportedSchemeException         if the crypto scheme is not supported
 * @throws android.media.ResourceBusyException              if required DRM resources are in use
 * @throws android.media.MediaPlayer.ProvisioningNetworkErrorException  if provisioning is required but failed due to a
 *                                            network error
 * @throws android.media.MediaPlayer.ProvisioningServerErrorException   if provisioning is required but failed due to
 *                                            the request denied by the provisioning server
 * @apiSince 26
 */

public void prepareDrm(@androidx.annotation.NonNull java.util.UUID uuid) throws android.media.MediaPlayer.ProvisioningNetworkErrorException, android.media.MediaPlayer.ProvisioningServerErrorException, android.media.ResourceBusyException, android.media.UnsupportedSchemeException { throw new RuntimeException("Stub!"); }

/**
 * Releases the DRM session
 * <p>
 * The player has to have an active DRM session and be in stopped, or prepared
 * state before this call is made.
 * A {@code reset()} call will release the DRM session implicitly.
 *
 * @throws android.media.MediaPlayer.NoDrmSchemeException if there is no active DRM session to release
 * @apiSince 26
 */

public void releaseDrm() throws android.media.MediaPlayer.NoDrmSchemeException { throw new RuntimeException("Stub!"); }

/**
 * A key request/response exchange occurs between the app and a license server
 * to obtain or release keys used to decrypt encrypted content.
 * <p>
 * getKeyRequest() is used to obtain an opaque key request byte array that is
 * delivered to the license server.  The opaque key request byte array is returned
 * in KeyRequest.data.  The recommended URL to deliver the key request to is
 * returned in KeyRequest.defaultUrl.
 * <p>
 * After the app has received the key request response from the server,
 * it should deliver to the response to the DRM engine plugin using the method
 * {@link #provideKeyResponse}.
 *
 * @param keySetId is the key-set identifier of the offline keys being released when keyType is
 * {@link android.media.MediaDrm#KEY_TYPE_RELEASE MediaDrm#KEY_TYPE_RELEASE}. It should be set to null for other key requests, when
 * keyType is {@link android.media.MediaDrm#KEY_TYPE_STREAMING MediaDrm#KEY_TYPE_STREAMING} or {@link android.media.MediaDrm#KEY_TYPE_OFFLINE MediaDrm#KEY_TYPE_OFFLINE}.
 *
 * This value may be {@code null}.
 * @param initData is the container-specific initialization data when the keyType is
 * {@link android.media.MediaDrm#KEY_TYPE_STREAMING MediaDrm#KEY_TYPE_STREAMING} or {@link android.media.MediaDrm#KEY_TYPE_OFFLINE MediaDrm#KEY_TYPE_OFFLINE}. Its meaning is
 * interpreted based on the mime type provided in the mimeType parameter.  It could
 * contain, for example, the content ID, key ID or other data obtained from the content
 * metadata that is required in generating the key request.
 * When the keyType is {@link android.media.MediaDrm#KEY_TYPE_RELEASE MediaDrm#KEY_TYPE_RELEASE}, it should be set to null.
 *
 * This value may be {@code null}.
 * @param mimeType identifies the mime type of the content
 *
 * This value may be {@code null}.
 * @param keyType specifies the type of the request. The request may be to acquire
 * keys for streaming, {@link android.media.MediaDrm#KEY_TYPE_STREAMING MediaDrm#KEY_TYPE_STREAMING}, or for offline content
 * {@link android.media.MediaDrm#KEY_TYPE_OFFLINE MediaDrm#KEY_TYPE_OFFLINE}, or to release previously acquired
 * keys ({@link android.media.MediaDrm#KEY_TYPE_RELEASE MediaDrm#KEY_TYPE_RELEASE}), which are identified by a keySetId.
 *
 * Value is {@link android.media.MediaDrm#KEY_TYPE_STREAMING}, {@link android.media.MediaDrm#KEY_TYPE_OFFLINE}, or {@link android.media.MediaDrm#KEY_TYPE_RELEASE}
 * @param optionalParameters are included in the key request message to
 * allow a client application to provide additional message parameters to the server.
 * This may be {@code null} if no additional parameters are to be sent.
 *
 * This value may be {@code null}.
 * @throws android.media.MediaPlayer.NoDrmSchemeException if there is no active DRM session
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.media.MediaDrm.KeyRequest getKeyRequest(@androidx.annotation.Nullable byte[] keySetId, @androidx.annotation.Nullable byte[] initData, @androidx.annotation.Nullable java.lang.String mimeType, int keyType, @androidx.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> optionalParameters) throws android.media.MediaPlayer.NoDrmSchemeException { throw new RuntimeException("Stub!"); }

/**
 * A key response is received from the license server by the app, then it is
 * provided to the DRM engine plugin using provideKeyResponse. When the
 * response is for an offline key request, a key-set identifier is returned that
 * can be used to later restore the keys to a new session with the method
 * {@ link # restoreKeys}.
 * When the response is for a streaming or release request, null is returned.
 *
 * @param keySetId When the response is for a release request, keySetId identifies
 * the saved key associated with the release request (i.e., the same keySetId
 * passed to the earlier {@ link # getKeyRequest} call. It MUST be null when the
 * response is for either streaming or offline key requests.
 *
 * @param response the byte array response from the server
 *
 * @throws NoDrmSchemeException if there is no active DRM session
 * @throws DeniedByServerException if the response indicates that the
 * server rejected the request
 
 * @param keySetId This value may be {@code null}.
 
 * @param response This value must never be {@code null}.
 * @apiSince 26
 */

public byte[] provideKeyResponse(@androidx.annotation.Nullable byte[] keySetId, @androidx.annotation.NonNull byte[] response) throws android.media.DeniedByServerException, android.media.MediaPlayer.NoDrmSchemeException { throw new RuntimeException("Stub!"); }

/**
 * Restore persisted offline keys into a new session.  keySetId identifies the
 * keys to load, obtained from a prior call to {@link #provideKeyResponse}.
 *
 * @param keySetId identifies the saved key set to restore
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void restoreKeys(@androidx.annotation.NonNull byte[] keySetId) throws android.media.MediaPlayer.NoDrmSchemeException { throw new RuntimeException("Stub!"); }

/**
 * Read a DRM engine plugin String property value, given the property name string.
 * <p>
 * @param propertyName the property name
 *
 * Standard fields names are:
 * {@link android.media.MediaDrm#PROPERTY_VENDOR MediaDrm#PROPERTY_VENDOR}, {@link android.media.MediaDrm#PROPERTY_VERSION MediaDrm#PROPERTY_VERSION},
 * {@link android.media.MediaDrm#PROPERTY_DESCRIPTION MediaDrm#PROPERTY_DESCRIPTION}, {@link android.media.MediaDrm#PROPERTY_ALGORITHMS MediaDrm#PROPERTY_ALGORITHMS}
 
 * This value must never be {@code null}.
 * Value is {@link android.media.MediaDrm#PROPERTY_VENDOR}, {@link android.media.MediaDrm#PROPERTY_VERSION}, {@link android.media.MediaDrm#PROPERTY_DESCRIPTION}, or {@link android.media.MediaDrm#PROPERTY_ALGORITHMS}
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.lang.String getDrmPropertyString(@androidx.annotation.NonNull java.lang.String propertyName) throws android.media.MediaPlayer.NoDrmSchemeException { throw new RuntimeException("Stub!"); }

/**
 * Set a DRM engine plugin String property value.
 * <p>
 * @param propertyName the property name
 * This value must never be {@code null}.
 * Value is {@link android.media.MediaDrm#PROPERTY_VENDOR}, {@link android.media.MediaDrm#PROPERTY_VERSION}, {@link android.media.MediaDrm#PROPERTY_DESCRIPTION}, or {@link android.media.MediaDrm#PROPERTY_ALGORITHMS}
 * @param value the property value
 *
 * Standard fields names are:
 * {@link android.media.MediaDrm#PROPERTY_VENDOR MediaDrm#PROPERTY_VENDOR}, {@link android.media.MediaDrm#PROPERTY_VERSION MediaDrm#PROPERTY_VERSION},
 * {@link android.media.MediaDrm#PROPERTY_DESCRIPTION MediaDrm#PROPERTY_DESCRIPTION}, {@link android.media.MediaDrm#PROPERTY_ALGORITHMS MediaDrm#PROPERTY_ALGORITHMS}
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void setDrmPropertyString(@androidx.annotation.NonNull java.lang.String propertyName, @androidx.annotation.NonNull java.lang.String value) throws android.media.MediaPlayer.NoDrmSchemeException { throw new RuntimeException("Stub!"); }

/**
 * File or network related operation errors.
 * @apiSince 17
 */

public static final int MEDIA_ERROR_IO = -1004; // 0xfffffc14

/**
 * Bitstream is not conforming to the related coding standard or file spec.
 * @apiSince 17
 */

public static final int MEDIA_ERROR_MALFORMED = -1007; // 0xfffffc11

/** The video is streamed and its container is not valid for progressive
 * playback i.e the video's index (e.g moov atom) is not at the start of the
 * file.
 * @see android.media.MediaPlayer.OnErrorListener
 * @apiSince 3
 */

public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200; // 0xc8

/** Media server died. In this case, the application must release the
 * MediaPlayer object and instantiate a new one.
 * @see android.media.MediaPlayer.OnErrorListener
 * @apiSince 1
 */

public static final int MEDIA_ERROR_SERVER_DIED = 100; // 0x64

/**
 * Some operation takes too long to complete, usually more than 3-5 seconds.
 * @apiSince 17
 */

public static final int MEDIA_ERROR_TIMED_OUT = -110; // 0xffffff92

/** Unspecified media player error.
 * @see android.media.MediaPlayer.OnErrorListener
 * @apiSince 1
 */

public static final int MEDIA_ERROR_UNKNOWN = 1; // 0x1

/** Bitstream is conforming to the related coding standard or file spec, but
 * the media framework does not support the feature.     * @apiSince 17
 */

public static final int MEDIA_ERROR_UNSUPPORTED = -1010; // 0xfffffc0e

/** Informs that audio is not playing. Note that playback of the video
 * is not interrupted.
 * @see android.media.MediaPlayer.OnInfoListener
 * @apiSince 26
 */

public static final int MEDIA_INFO_AUDIO_NOT_PLAYING = 804; // 0x324

/** Bad interleaving means that a media has been improperly interleaved or
 * not interleaved at all, e.g has all the video samples first then all the
 * audio ones. Video is playing but a lot of disk seeks may be happening.
 * @see android.media.MediaPlayer.OnInfoListener
 * @apiSince 3
 */

public static final int MEDIA_INFO_BAD_INTERLEAVING = 800; // 0x320

/** MediaPlayer is resuming playback after filling buffers.
 * @see android.media.MediaPlayer.OnInfoListener
 * @apiSince 9
 */

public static final int MEDIA_INFO_BUFFERING_END = 702; // 0x2be

/** MediaPlayer is temporarily pausing playback internally in order to
 * buffer more data.
 * @see android.media.MediaPlayer.OnInfoListener
 * @apiSince 9
 */

public static final int MEDIA_INFO_BUFFERING_START = 701; // 0x2bd

/** A new set of metadata is available.
 * @see android.media.MediaPlayer.OnInfoListener
 * @apiSince 5
 */

public static final int MEDIA_INFO_METADATA_UPDATE = 802; // 0x322

/** The media cannot be seeked (e.g live stream)
 * @see android.media.MediaPlayer.OnInfoListener
 * @apiSince 3
 */

public static final int MEDIA_INFO_NOT_SEEKABLE = 801; // 0x321

/** The player was started because it was used as the next player for another
 * player, which just completed playback.
 * @see android.media.MediaPlayer#setNextMediaPlayer(MediaPlayer)
 * @see android.media.MediaPlayer.OnInfoListener
 * @apiSince 28
 */

public static final int MEDIA_INFO_STARTED_AS_NEXT = 2; // 0x2

/** Reading the subtitle track takes too long.
 * @see android.media.MediaPlayer.OnInfoListener
 * @apiSince 19
 */

public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902; // 0x386

/** Unspecified media player info.
 * @see android.media.MediaPlayer.OnInfoListener
 * @apiSince 3
 */

public static final int MEDIA_INFO_UNKNOWN = 1; // 0x1

/** Subtitle track was not supported by the media framework.
 * @see android.media.MediaPlayer.OnInfoListener
 * @apiSince 19
 */

public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901; // 0x385

/** Informs that video is not playing. Note that playback of the audio
 * is not interrupted.
 * @see android.media.MediaPlayer.OnInfoListener
 * @apiSince 26
 */

public static final int MEDIA_INFO_VIDEO_NOT_PLAYING = 805; // 0x325

/** The player just pushed the very first video frame for rendering.
 * @see android.media.MediaPlayer.OnInfoListener
 * @apiSince 17
 */

public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3; // 0x3

/** The video is too complex for the decoder: it can't decode frames fast
 *  enough. Possibly only the audio plays fine at this stage.
 * @see android.media.MediaPlayer.OnInfoListener
 * @apiSince 3
 */

public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700; // 0x2bc

/**
 * MIME type for SubRip (SRT) container. Used in addTimedTextSource APIs.
 * @deprecated use {@link android.media.MediaFormat#MIMETYPE_TEXT_SUBRIP MediaFormat#MIMETYPE_TEXT_SUBRIP}
 * @apiSince 16
 * @deprecatedSince 28
 */

@Deprecated public static final java.lang.String MEDIA_MIMETYPE_TEXT_SUBRIP = "application/x-subrip";

/**
 * The DRM preparation has failed .
 * @apiSince 26
 */

public static final int PREPARE_DRM_STATUS_PREPARATION_ERROR = 3; // 0x3

/**
 * The device required DRM provisioning but couldn't reach the provisioning server.
 * @apiSince 26
 */

public static final int PREPARE_DRM_STATUS_PROVISIONING_NETWORK_ERROR = 1; // 0x1

/**
 * The device required DRM provisioning but the provisioning server denied the request.
 * @apiSince 26
 */

public static final int PREPARE_DRM_STATUS_PROVISIONING_SERVER_ERROR = 2; // 0x2

/**
 * The status codes for {@link android.media.MediaPlayer.OnDrmPreparedListener#onDrmPrepared OnDrmPreparedListener#onDrmPrepared} listener.
 * <p>
 *
 * DRM preparation has succeeded.
 * @apiSince 26
 */

public static final int PREPARE_DRM_STATUS_SUCCESS = 0; // 0x0

/**
 * This mode is used with {@link #seekTo(long,int)} to move media position to
 * a frame (not necessarily a key frame) associated with a data source that
 * is located closest to or at the given time.
 *
 * @see #seekTo(long, int)
 * @apiSince 26
 */

public static final int SEEK_CLOSEST = 3; // 0x3

/**
 * This mode is used with {@link #seekTo(long,int)} to move media position to
 * a sync (or key) frame associated with a data source that is located
 * closest to (in time) or at the given time.
 *
 * @see #seekTo(long, int)
 * @apiSince 26
 */

public static final int SEEK_CLOSEST_SYNC = 2; // 0x2

/**
 * This mode is used with {@link #seekTo(long,int)} to move media position to
 * a sync (or key) frame associated with a data source that is located
 * right after or at the given time.
 *
 * @see #seekTo(long, int)
 * @apiSince 26
 */

public static final int SEEK_NEXT_SYNC = 1; // 0x1

/**
 * This mode is used with {@link #seekTo(long,int)} to move media position to
 * a sync (or key) frame associated with a data source that is located
 * right before or at the given time.
 *
 * @see #seekTo(long, int)
 * @apiSince 26
 */

public static final int SEEK_PREVIOUS_SYNC = 0; // 0x0

/**
 * Specifies a video scaling mode. The content is stretched to the
 * surface rendering area. When the surface has the same aspect ratio
 * as the content, the aspect ratio of the content is maintained;
 * otherwise, the aspect ratio of the content is not maintained when video
 * is being rendered. Unlike {@link #VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING},
 * there is no content cropping with this video scaling mode.
 * @apiSince 16
 */

public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1; // 0x1

/**
 * Specifies a video scaling mode. The content is scaled, maintaining
 * its aspect ratio. The whole surface area is always used. When the
 * aspect ratio of the content is the same as the surface, no content
 * is cropped; otherwise, content is cropped to fit the surface.
 * @apiSince 16
 */

public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2; // 0x2
/**
 * Encapsulates the DRM properties of the source.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class DrmInfo {

private DrmInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the PSSH info of the data source for each supported DRM scheme.
 * @apiSince 26
 */

public java.util.Map<java.util.UUID,byte[]> getPssh() { throw new RuntimeException("Stub!"); }

/**
 * Returns the intersection of the data source and the device DRM schemes.
 * It effectively identifies the subset of the source's DRM schemes which
 * are supported by the device too.
 * @apiSince 26
 */

public java.util.UUID[] getSupportedSchemes() { throw new RuntimeException("Stub!"); }
}

/** @apiSince 26 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class MetricsConstants {

private MetricsConstants() { throw new RuntimeException("Stub!"); }

/**
 * Key to extract the codec being used to decode the audio track
 * from the {@link android.media.MediaPlayer#getMetrics MediaPlayer#getMetrics} return value.
 * The value is a String.
 * @apiSince 26
 */

public static final java.lang.String CODEC_AUDIO = "android.media.mediaplayer.audio.codec";

/**
 * Key to extract the codec being used to decode the video track
 * from the {@link android.media.MediaPlayer#getMetrics MediaPlayer#getMetrics} return value.
 * The value is a String.
 * @apiSince 26
 */

public static final java.lang.String CODEC_VIDEO = "android.media.mediaplayer.video.codec";

/**
 * Key to extract the duration (in milliseconds) of the
 * media being played
 * from the {@link android.media.MediaPlayer#getMetrics MediaPlayer#getMetrics} return value.
 * The value is a long.
 * @apiSince 26
 */

public static final java.lang.String DURATION = "android.media.mediaplayer.durationMs";

/**
 * Key to extract the count of errors encountered while
 * playing the media
 * from the {@link android.media.MediaPlayer#getMetrics MediaPlayer#getMetrics} return value.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String ERRORS = "android.media.mediaplayer.err";

/**
 * Key to extract an (optional) error code detected while
 * playing the media
 * from the {@link android.media.MediaPlayer#getMetrics MediaPlayer#getMetrics} return value.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String ERROR_CODE = "android.media.mediaplayer.errcode";

/**
 * Key to extract the count of video frames played
 * from the {@link android.media.MediaPlayer#getMetrics MediaPlayer#getMetrics} return value.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String FRAMES = "android.media.mediaplayer.frames";

/**
 * Key to extract the count of video frames dropped
 * from the {@link android.media.MediaPlayer#getMetrics MediaPlayer#getMetrics} return value.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String FRAMES_DROPPED = "android.media.mediaplayer.dropped";

/**
 * Key to extract the height (in pixels) of the video track
 * from the {@link android.media.MediaPlayer#getMetrics MediaPlayer#getMetrics} return value.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String HEIGHT = "android.media.mediaplayer.height";

/**
 * Key to extract the MIME type of the audio track
 * from the {@link android.media.MediaPlayer#getMetrics MediaPlayer#getMetrics} return value.
 * The value is a String.
 * @apiSince 26
 */

public static final java.lang.String MIME_TYPE_AUDIO = "android.media.mediaplayer.audio.mime";

/**
 * Key to extract the MIME type of the video track
 * from the {@link android.media.MediaPlayer#getMetrics MediaPlayer#getMetrics} return value.
 * The value is a String.
 * @apiSince 26
 */

public static final java.lang.String MIME_TYPE_VIDEO = "android.media.mediaplayer.video.mime";

/**
 * Key to extract the playing time (in milliseconds) of the
 * media being played
 * from the {@link android.media.MediaPlayer#getMetrics MediaPlayer#getMetrics} return value.
 * The value is a long.
 * @apiSince 26
 */

public static final java.lang.String PLAYING = "android.media.mediaplayer.playingMs";

/**
 * Key to extract the width (in pixels) of the video track
 * from the {@link android.media.MediaPlayer#getMetrics MediaPlayer#getMetrics} return value.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String WIDTH = "android.media.mediaplayer.width";
}

/**
 * Thrown when a DRM method is called before preparing a DRM scheme through prepareDrm().
 * Extends MediaDrm.MediaDrmException
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class NoDrmSchemeException extends android.media.MediaDrmException {

/** @apiSince 26 */

public NoDrmSchemeException(java.lang.String detailMessage) { super(null); throw new RuntimeException("Stub!"); }
}

/**
 * Interface definition of a callback to be invoked indicating buffering
 * status of a media resource being streamed over the network.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnBufferingUpdateListener {

/**
 * Called to update status in buffering a media stream received through
 * progressive HTTP download. The received buffering percentage
 * indicates how much of the content has been buffered or played.
 * For example a buffering update of 80 percent when half the content
 * has already been played indicates that the next 30 percent of the
 * content to play has been buffered.
 *
 * @param mp      the MediaPlayer the update pertains to
 * @param percent the percentage (0-100) of the content
 *                that has been buffered or played thus far
 * @apiSince 1
 */

public void onBufferingUpdate(android.media.MediaPlayer mp, int percent);
}

/**
 * Interface definition for a callback to be invoked when playback of
 * a media source has completed.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnCompletionListener {

/**
 * Called when the end of a media source is reached during playback.
 *
 * @param mp the MediaPlayer that reached the end of the file
 * @apiSince 1
 */

public void onCompletion(android.media.MediaPlayer mp);
}

/**
 * Interface definition of a callback to be invoked when the app
 * can do DRM configuration (get/set properties) before the session
 * is opened. This facilitates configuration of the properties, like
 * 'securityLevel', which has to be set after DRM scheme creation but
 * before the DRM session is opened.
 *
 * The only allowed DRM calls in this listener are {@code getDrmPropertyString}
 * and {@code setDrmPropertyString}.
 *
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDrmConfigHelper {

/**
 * Called to give the app the opportunity to configure DRM before the session is created
 *
 * @param mp the {@code MediaPlayer} associated with this callback
 * @apiSince 26
 */

public void onDrmConfig(android.media.MediaPlayer mp);
}

/**
 * Interface definition of a callback to be invoked when the
 * DRM info becomes available
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDrmInfoListener {

/**
 * Called to indicate DRM info is available
 *
 * @param mp the {@code MediaPlayer} associated with this callback
 * @param drmInfo DRM info of the source including PSSH, and subset
 *                of crypto schemes supported by this device
 * @apiSince 26
 */

public void onDrmInfo(android.media.MediaPlayer mp, android.media.MediaPlayer.DrmInfo drmInfo);
}

/**
 * Interface definition of a callback to notify the app when the
 * DRM is ready for key request/response
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDrmPreparedListener {

/**
 * Called to notify the app that prepareDrm is finished and ready for key request/response
 *
 * @param mp the {@code MediaPlayer} associated with this callback
 * @param status the result of DRM preparation which can be
 * {@link #PREPARE_DRM_STATUS_SUCCESS},
 * {@link #PREPARE_DRM_STATUS_PROVISIONING_NETWORK_ERROR},
 * {@link #PREPARE_DRM_STATUS_PROVISIONING_SERVER_ERROR}, or
 * {@link #PREPARE_DRM_STATUS_PREPARATION_ERROR}.
 
 * Value is {@link android.media.MediaPlayer#PREPARE_DRM_STATUS_SUCCESS}, {@link android.media.MediaPlayer#PREPARE_DRM_STATUS_PROVISIONING_NETWORK_ERROR}, {@link android.media.MediaPlayer#PREPARE_DRM_STATUS_PROVISIONING_SERVER_ERROR}, or {@link android.media.MediaPlayer#PREPARE_DRM_STATUS_PREPARATION_ERROR}
 * @apiSince 26
 */

public void onDrmPrepared(android.media.MediaPlayer mp, int status);
}

/**
 * Interface definition of a callback to be invoked when there
 * has been an error during an asynchronous operation (other errors
 * will throw exceptions at method call time).
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnErrorListener {

/**
 * Called to indicate an error.
 *
 * @param mp      the MediaPlayer the error pertains to
 * @param what    the type of error that has occurred:
 * <ul>
 * <li>{@link #MEDIA_ERROR_UNKNOWN}
 * <li>{@link #MEDIA_ERROR_SERVER_DIED}
 * </ul>
 * @param extra an extra code, specific to the error. Typically
 * implementation dependent.
 * <ul>
 * <li>{@link #MEDIA_ERROR_IO}
 * <li>{@link #MEDIA_ERROR_MALFORMED}
 * <li>{@link #MEDIA_ERROR_UNSUPPORTED}
 * <li>{@link #MEDIA_ERROR_TIMED_OUT}
 * <li><code>MEDIA_ERROR_SYSTEM (-2147483648)</code> - low-level system error.
 * </ul>
 * @return True if the method handled the error, false if it didn't.
 * Returning false, or not having an OnErrorListener at all, will
 * cause the OnCompletionListener to be called.
 * @apiSince 1
 */

public boolean onError(android.media.MediaPlayer mp, int what, int extra);
}

/**
 * Interface definition of a callback to be invoked to communicate some
 * info and/or warning about the media or its playback.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnInfoListener {

/**
 * Called to indicate an info or a warning.
 *
 * @param mp      the MediaPlayer the info pertains to.
 * @param what    the type of info or warning.
 * <ul>
 * <li>{@link #MEDIA_INFO_UNKNOWN}
 * <li>{@link #MEDIA_INFO_VIDEO_TRACK_LAGGING}
 * <li>{@link #MEDIA_INFO_VIDEO_RENDERING_START}
 * <li>{@link #MEDIA_INFO_BUFFERING_START}
 * <li>{@link #MEDIA_INFO_BUFFERING_END}
 * <li><code>MEDIA_INFO_NETWORK_BANDWIDTH (703)</code> -
 *     bandwidth information is available (as <code>extra</code> kbps)
 * <li>{@link #MEDIA_INFO_BAD_INTERLEAVING}
 * <li>{@link #MEDIA_INFO_NOT_SEEKABLE}
 * <li>{@link #MEDIA_INFO_METADATA_UPDATE}
 * <li>{@link #MEDIA_INFO_UNSUPPORTED_SUBTITLE}
 * <li>{@link #MEDIA_INFO_SUBTITLE_TIMED_OUT}
 * </ul>
 * @param extra an extra code, specific to the info. Typically
 * implementation dependent.
 * @return True if the method handled the info, false if it didn't.
 * Returning false, or not having an OnInfoListener at all, will
 * cause the info to be discarded.
 * @apiSince 3
 */

public boolean onInfo(android.media.MediaPlayer mp, int what, int extra);
}

/**
 * Interface definition of a callback to be invoked when discontinuity in the normal progression
 * of the media time is detected.
 * The "normal progression" of media time is defined as the expected increase of the playback
 * position when playing media, relative to the playback speed (for instance every second, media
 * time increases by two seconds when playing at 2x).<br>
 * Discontinuities are encountered in the following cases:
 * <ul>
 * <li>when the player is starved for data and cannot play anymore</li>
 * <li>when the player encounters a playback error</li>
 * <li>when the a seek operation starts, and when it's completed</li>
 * <li>when the playback speed changes</li>
 * <li>when the playback state changes</li>
 * <li>when the player is reset</li>
 * </ul>
 * See the
 * {@link android.media.MediaPlayer#setOnMediaTimeDiscontinuityListener(android.media.MediaPlayer.OnMediaTimeDiscontinuityListener,android.os.Handler) MediaPlayer#setOnMediaTimeDiscontinuityListener(OnMediaTimeDiscontinuityListener, Handler)}
 * method to set a listener for these events.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnMediaTimeDiscontinuityListener {

/**
 * Called to indicate a time discontinuity has occured.
 * @param mp the MediaPlayer for which the discontinuity has occured.
 * This value must never be {@code null}.
 * @param mts the timestamp that correlates media time, system time and clock rate,
 *     or {@link android.media.MediaTimestamp#TIMESTAMP_UNKNOWN MediaTimestamp#TIMESTAMP_UNKNOWN} in an error case.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void onMediaTimeDiscontinuity(@androidx.annotation.NonNull android.media.MediaPlayer mp, @androidx.annotation.NonNull android.media.MediaTimestamp mts);
}

/**
 * Interface definition for a callback to be invoked when the media
 * source is ready for playback.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnPreparedListener {

/**
 * Called when the media file is ready for playback.
 *
 * @param mp the MediaPlayer that is ready for playback
 * @apiSince 1
 */

public void onPrepared(android.media.MediaPlayer mp);
}

/**
 * Interface definition of a callback to be invoked indicating
 * the completion of a seek operation.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnSeekCompleteListener {

/**
 * Called to indicate the completion of a seek operation.
 *
 * @param mp the MediaPlayer that issued the seek operation
 * @apiSince 1
 */

public void onSeekComplete(android.media.MediaPlayer mp);
}

/**
 * Interface definition of a callback to be invoked when a player subtitle track has new
 * subtitle data available.
 * See the {@link android.media.MediaPlayer#setOnSubtitleDataListener(android.media.MediaPlayer.OnSubtitleDataListener,android.os.Handler) MediaPlayer#setOnSubtitleDataListener(OnSubtitleDataListener, Handler)}
 * method for the description of which track will report data through this listener.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnSubtitleDataListener {

/**
 * Method called when new subtitle data is available
 * @param mp the player that reports the new subtitle data
 * This value must never be {@code null}.
 * @param data the subtitle data
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void onSubtitleData(@androidx.annotation.NonNull android.media.MediaPlayer mp, @androidx.annotation.NonNull android.media.SubtitleData data);
}

/**
 * Interface definition of a callback to be invoked when a
 * track has timed metadata available.
 *
 * @see android.media.MediaPlayer#setOnTimedMetaDataAvailableListener(OnTimedMetaDataAvailableListener)
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnTimedMetaDataAvailableListener {

/**
 * Called to indicate avaliable timed metadata
 * <p>
 * This method will be called as timed metadata is extracted from the media,
 * in the same order as it occurs in the media. The timing of this event is
 * not controlled by the associated timestamp.
 *
 * @param mp             the MediaPlayer associated with this callback
 * @param data           the timed metadata sample associated with this event
 * @apiSince 23
 */

public void onTimedMetaDataAvailable(android.media.MediaPlayer mp, android.media.TimedMetaData data);
}

/**
 * Interface definition of a callback to be invoked when a
 * timed text is available for display.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnTimedTextListener {

/**
 * Called to indicate an avaliable timed text
 *
 * @param mp             the MediaPlayer associated with this callback
 * @param text           the timed text sample which contains the text
 *                       needed to be displayed and the display format.
 * @apiSince 16
 */

public void onTimedText(android.media.MediaPlayer mp, android.media.TimedText text);
}

/**
 * Interface definition of a callback to be invoked when the
 * video size is first known or updated
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnVideoSizeChangedListener {

/**
 * Called to indicate the video size
 *
 * The video size (width and height) could be 0 if there was no video,
 * no display surface was set, or the value was not determined yet.
 *
 * @param mp        the MediaPlayer associated with this callback
 * @param width     the width of the video
 * @param height    the height of the video
 * @apiSince 3
 */

public void onVideoSizeChanged(android.media.MediaPlayer mp, int width, int height);
}

/**
 * Thrown when the device requires DRM provisioning but the provisioning attempt has
 * failed due to a network error (Internet reachability, timeout, etc.).
 * Extends MediaDrm.MediaDrmException
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class ProvisioningNetworkErrorException extends android.media.MediaDrmException {

/** @apiSince 26 */

public ProvisioningNetworkErrorException(java.lang.String detailMessage) { super(null); throw new RuntimeException("Stub!"); }
}

/**
 * Thrown when the device requires DRM provisioning but the provisioning attempt has
 * failed due to the provisioning server denying the request.
 * Extends MediaDrm.MediaDrmException
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class ProvisioningServerErrorException extends android.media.MediaDrmException {

/** @apiSince 26 */

public ProvisioningServerErrorException(java.lang.String detailMessage) { super(null); throw new RuntimeException("Stub!"); }
}

/**
 * Class for MediaPlayer to return each audio/video/subtitle track's metadata.
 *
 * @see android.media.MediaPlayer#getTrackInfo
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class TrackInfo implements android.os.Parcelable {

TrackInfo() { throw new RuntimeException("Stub!"); }

/**
 * Gets the track type.
 * @return TrackType which indicates if the track is video, audio, timed text.
 
 * Value is {@link android.media.MediaPlayer.TrackInfo#MEDIA_TRACK_TYPE_UNKNOWN}, {@link android.media.MediaPlayer.TrackInfo#MEDIA_TRACK_TYPE_VIDEO}, {@link android.media.MediaPlayer.TrackInfo#MEDIA_TRACK_TYPE_AUDIO}, {@link android.media.MediaPlayer.TrackInfo#MEDIA_TRACK_TYPE_TIMEDTEXT}, {@link android.media.MediaPlayer.TrackInfo#MEDIA_TRACK_TYPE_SUBTITLE}, or {@link android.media.MediaPlayer.TrackInfo#MEDIA_TRACK_TYPE_METADATA}
 * @apiSince 16
 */

public int getTrackType() { throw new RuntimeException("Stub!"); }

/**
 * Gets the language code of the track.
 * @return a language code in either way of ISO-639-1 or ISO-639-2.
 * When the language is unknown or could not be determined,
 * ISO-639-2 language code, "und", is returned.
 * @apiSince 16
 */

public java.lang.String getLanguage() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.media.MediaFormat MediaFormat} of the track.  If the format is
 * unknown or could not be determined, null is returned.
 * @apiSince 19
 */

public android.media.MediaFormat getFormat() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 16
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 16
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public static final int MEDIA_TRACK_TYPE_AUDIO = 2; // 0x2

/** @apiSince 23 */

public static final int MEDIA_TRACK_TYPE_METADATA = 5; // 0x5

/** @apiSince 21 */

public static final int MEDIA_TRACK_TYPE_SUBTITLE = 4; // 0x4

/** @apiSince 16 */

public static final int MEDIA_TRACK_TYPE_TIMEDTEXT = 3; // 0x3

/** @apiSince 16 */

public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0; // 0x0

/** @apiSince 16 */

public static final int MEDIA_TRACK_TYPE_VIDEO = 1; // 0x1
}

}

