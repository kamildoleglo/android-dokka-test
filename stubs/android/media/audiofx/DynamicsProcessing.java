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


package android.media.audiofx;

import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.audiofx.AudioEffect;

/**
 * DynamicsProcessing is an audio effect for equalizing and changing dynamic range properties of the
 * sound. It is composed of multiple stages including equalization, multi-band compression and
 * limiter.
 * <p>The number of bands and active stages is configurable, and most parameters can be controlled
 * in realtime, such as gains, attack/release times, thresholds, etc.
 * <p>The effect is instantiated and controlled by channels. Each channel has the same basic
 * architecture, but all of their parameters are independent from other channels.
 * <p>The basic channel configuration is:
 * <pre>
 *
 *    Channel 0          Channel 1       ....       Channel N-1
 *      Input              Input                       Input
 *        |                  |                           |
 *   +----v----+        +----v----+                 +----v----+
 *   |inputGain|        |inputGain|                 |inputGain|
 *   +---------+        +---------+                 +---------+
 *        |                  |                           |
 *  +-----v-----+      +-----v-----+               +-----v-----+
 *  |   PreEQ   |      |   PreEQ   |               |   PreEQ   |
 *  +-----------+      +-----------+               +-----------+
 *        |                  |                           |
 *  +-----v-----+      +-----v-----+               +-----v-----+
 *  |    MBC    |      |    MBC    |               |    MBC    |
 *  +-----------+      +-----------+               +-----------+
 *        |                  |                           |
 *  +-----v-----+      +-----v-----+               +-----v-----+
 *  |  PostEQ   |      |  PostEQ   |               |  PostEQ   |
 *  +-----------+      +-----------+               +-----------+
 *        |                  |                           |
 *  +-----v-----+      +-----v-----+               +-----v-----+
 *  |  Limiter  |      |  Limiter  |               |  Limiter  |
 *  +-----------+      +-----------+               +-----------+
 *        |                  |                           |
 *     Output             Output                      Output
 * </pre>
 *
 * <p>Where the stages are:
 * inputGain: input gain factor in decibels (dB). 0 dB means no change in level.
 * PreEQ:  Multi-band Equalizer.
 * MBC:    Multi-band Compressor
 * PostEQ: Multi-band Equalizer
 * Limiter: Single band compressor/limiter.
 *
 * <p>An application creates a DynamicsProcessing object to instantiate and control this audio
 * effect in the audio framework. A DynamicsProcessor.Config and DynamicsProcessor.Config.Builder
 * are available to help configure the multiple stages and each band parameters if desired.
 * <p>See each stage documentation for further details.
 * <p>If no Config is specified during creation, a default configuration is chosen.
 * <p>To attach the DynamicsProcessing to a particular AudioTrack or MediaPlayer,
 * specify the audio session ID of this AudioTrack or MediaPlayer when constructing the effect
 * (see {@link android.media.AudioTrack#getAudioSessionId() AudioTrack#getAudioSessionId()} and {@link android.media.MediaPlayer#getAudioSessionId() MediaPlayer#getAudioSessionId()}).
 *
 * <p>To attach the DynamicsProcessing to a particular AudioTrack or MediaPlayer, specify the audio
 * session ID of this AudioTrack or MediaPlayer when constructing the DynamicsProcessing.
 * <p>See {@link android.media.MediaPlayer#getAudioSessionId()} for details on audio sessions.
 * <p>See {@link android.media.audiofx.AudioEffect} class for more details on controlling audio
 * effects.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DynamicsProcessing extends android.media.audiofx.AudioEffect {

/**
 * Class constructor.
 * @param audioSession system-wide unique audio session identifier. The DynamicsProcessing
 * will be attached to the MediaPlayer or AudioTrack in the same audio session.
 * @apiSince 28
 */

public DynamicsProcessing(int audioSession) { throw new RuntimeException("Stub!"); }

/**
 * Class constructor for the DynamicsProcessing audio effect
 * @param priority the priority level requested by the application for controlling the
 * DynamicsProcessing engine. As the same engine can be shared by several applications,
 * this parameter indicates how much the requesting application needs control of effect
 * parameters. The normal priority is 0, above normal is a positive number, below normal a
 * negative number.
 * @param audioSession system-wide unique audio session identifier. The DynamicsProcessing
 * will be attached to the MediaPlayer or AudioTrack in the same audio session.
 * @param cfg Config object used to setup the audio effect, including bands per stage, and
 * specific parameters for each stage/band. Use
 * {@link android.media.audiofx.DynamicsProcessing.Config.Builder} to create a
 * Config object that suits your needs. A null cfg parameter will create and use a default
 * configuration for the effect
 
 * This value may be {@code null}.
 * @apiSince 28
 */

public DynamicsProcessing(int priority, int audioSession, @androidx.annotation.Nullable android.media.audiofx.DynamicsProcessing.Config cfg) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Config object used to setup this effect.
 * @return Config Current Config object used to setup this DynamicsProcessing effect.
 * @apiSince 28
 */

public android.media.audiofx.DynamicsProcessing.Config getConfig() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Channel getChannelByChannelIndex(int channelIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setChannelTo(int channelIndex, android.media.audiofx.DynamicsProcessing.Channel channel) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setAllChannelsTo(android.media.audiofx.DynamicsProcessing.Channel channel) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public float getInputGainByChannelIndex(int channelIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setInputGainbyChannel(int channelIndex, float inputGain) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setInputGainAllChannelsTo(float inputGain) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Eq getPreEqByChannelIndex(int channelIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setPreEqByChannelIndex(int channelIndex, android.media.audiofx.DynamicsProcessing.Eq preEq) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setPreEqAllChannelsTo(android.media.audiofx.DynamicsProcessing.Eq preEq) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.EqBand getPreEqBandByChannelIndex(int channelIndex, int band) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setPreEqBandByChannelIndex(int channelIndex, int band, android.media.audiofx.DynamicsProcessing.EqBand preEqBand) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setPreEqBandAllChannelsTo(int band, android.media.audiofx.DynamicsProcessing.EqBand preEqBand) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Mbc getMbcByChannelIndex(int channelIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setMbcByChannelIndex(int channelIndex, android.media.audiofx.DynamicsProcessing.Mbc mbc) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setMbcAllChannelsTo(android.media.audiofx.DynamicsProcessing.Mbc mbc) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.MbcBand getMbcBandByChannelIndex(int channelIndex, int band) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setMbcBandByChannelIndex(int channelIndex, int band, android.media.audiofx.DynamicsProcessing.MbcBand mbcBand) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setMbcBandAllChannelsTo(int band, android.media.audiofx.DynamicsProcessing.MbcBand mbcBand) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Eq getPostEqByChannelIndex(int channelIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setPostEqByChannelIndex(int channelIndex, android.media.audiofx.DynamicsProcessing.Eq postEq) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setPostEqAllChannelsTo(android.media.audiofx.DynamicsProcessing.Eq postEq) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.EqBand getPostEqBandByChannelIndex(int channelIndex, int band) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setPostEqBandByChannelIndex(int channelIndex, int band, android.media.audiofx.DynamicsProcessing.EqBand postEqBand) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setPostEqBandAllChannelsTo(int band, android.media.audiofx.DynamicsProcessing.EqBand postEqBand) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Limiter getLimiterByChannelIndex(int channelIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setLimiterByChannelIndex(int channelIndex, android.media.audiofx.DynamicsProcessing.Limiter limiter) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setLimiterAllChannelsTo(android.media.audiofx.DynamicsProcessing.Limiter limiter) { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of channels in the effect engine
 * @return number of channels currently in use by the effect engine
 * @apiSince 28
 */

public int getChannelCount() { throw new RuntimeException("Stub!"); }

/**
 * Index of variant that favors frequency resolution. Frequency domain based implementation.
 * @apiSince 28
 */

public static final int VARIANT_FAVOR_FREQUENCY_RESOLUTION = 0; // 0x0

/**
 * Index of variant that favors time resolution resolution. Time domain based implementation.
 * @apiSince 28
 */

public static final int VARIANT_FAVOR_TIME_RESOLUTION = 1; // 0x1
/**
 * Base class for bands
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class BandBase {

/**
 * Class constructor for BandBase
 * @param enabled true if this band is currently used to process sound. When false,
 * the band is effectively muted and sound set to zero.
 * @param cutoffFrequency topmost frequency number (in Hz) this band will process. The
 * effective bandwidth for the band is then computed using this and the previous band
 * topmost frequency (or 0 Hz for band number 0). Frequencies are expected to increase with
 * band number, thus band 0 cutoffFrequency <= band 1 cutoffFrequency, and so on.
 * @apiSince 28
 */

public BandBase(boolean enabled, float cutoffFrequency) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * returns enabled state of the band
 * @return true if bands is enabled for processing, false otherwise
 * @apiSince 28
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * sets enabled state of the band
 * @param enabled true for enabled, false otherwise
 * @apiSince 28
 */

public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * gets cutoffFrequency for this band in Hertz (Hz)
 * @return cutoffFrequency for this band in Hertz (Hz)
 * @apiSince 28
 */

public float getCutoffFrequency() { throw new RuntimeException("Stub!"); }

/**
 * sets topmost frequency number (in Hz) this band will process. The
 * effective bandwidth for the band is then computed using this and the previous band
 * topmost frequency (or 0 Hz for band number 0). Frequencies are expected to increase with
 * band number, thus band 0 cutoffFrequency <= band 1 cutoffFrequency, and so on.
 * @param frequency
 * @apiSince 28
 */

public void setCutoffFrequency(float frequency) { throw new RuntimeException("Stub!"); }
}

/**
 * Base class for stages that hold bands
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class BandStage extends android.media.audiofx.DynamicsProcessing.Stage {

/**
 * Class constructor for BandStage
 * @param inUse true if this stage is set to be used. False otherwise. Stages that are not
 * set "inUse" at initialization time are not available to be used at any time.
 * @param enabled true if this stage is currently used to process sound. When disabled,
 * the stage is bypassed and the sound is copied unaltered from input to output.
 * @param bandCount number of bands this stage will handle. If stage is not inUse, bandcount
 * is set to 0
 * @apiSince 28
 */

public BandStage(boolean inUse, boolean enabled, int bandCount) { super(false, false); throw new RuntimeException("Stub!"); }

/**
 * gets number of bands held in this stage
 * @return number of bands held in this stage
 * @apiSince 28
 */

public int getBandCount() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

/**
 * Class for Channel configuration parameters. It is composed of multiple stages, which can be
 * used/enabled independently. Stages not used or disabled will be bypassed and the sound would
 * be unaffected by them.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Channel {

/**
 * Class constructor for Channel configuration.
 * @param inputGain value in decibels (dB) of level change applied to the audio before
 * processing. A value of 0 dB means no change.
 * @param preEqInUse true if PreEq stage will be used, false otherwise. This can't be
 * changed later.
 * @param preEqBandCount number of bands for PreEq stage. This can't be changed later.
 * @param mbcInUse true if Mbc stage will be used, false otherwise. This can't be changed
 * later.
 * @param mbcBandCount number of bands for Mbc stage. This can't be changed later.
 * @param postEqInUse true if PostEq stage will be used, false otherwise. This can't be
 * changed later.
 * @param postEqBandCount number of bands for PostEq stage. This can't be changed later.
 * @param limiterInUse true if Limiter stage will be used, false otherwise. This can't be
 * changed later.
 * @apiSince 28
 */

public Channel(float inputGain, boolean preEqInUse, int preEqBandCount, boolean mbcInUse, int mbcBandCount, boolean postEqInUse, int postEqBandCount, boolean limiterInUse) { throw new RuntimeException("Stub!"); }

/**
 * Class constructor for Channel configuration
 * @param cfg copy constructor
 * @apiSince 28
 */

public Channel(android.media.audiofx.DynamicsProcessing.Channel cfg) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Gets inputGain value in decibels (dB). 0 dB means no change;
 * @return gain value in decibels (dB)
 * @apiSince 28
 */

public float getInputGain() { throw new RuntimeException("Stub!"); }

/**
 * Sets inputGain value in decibels (dB). 0 dB means no change;
 * @param inputGain desired gain value in decibels (dB)
 * @apiSince 28
 */

public void setInputGain(float inputGain) { throw new RuntimeException("Stub!"); }

/**
 * Gets PreEq configuration stage
 * @return PreEq configuration stage
 * @apiSince 28
 */

public android.media.audiofx.DynamicsProcessing.Eq getPreEq() { throw new RuntimeException("Stub!"); }

/**
 * Sets PreEq configuration stage. New PreEq stage must have the same number of bands than
 * original PreEq stage.
 * @param preEq configuration
 * @apiSince 28
 */

public void setPreEq(android.media.audiofx.DynamicsProcessing.Eq preEq) { throw new RuntimeException("Stub!"); }

/**
 * Gets EqBand for PreEq stage for given band index.
 * @param band index of band of interest from PreEq stage
 * @return EqBand configuration
 * @apiSince 28
 */

public android.media.audiofx.DynamicsProcessing.EqBand getPreEqBand(int band) { throw new RuntimeException("Stub!"); }

/**
 * Sets EqBand for PreEq stage for given band index
 * @param band index of band of interest from PreEq stage
 * @param preEqBand configuration to be set.
 * @apiSince 28
 */

public void setPreEqBand(int band, android.media.audiofx.DynamicsProcessing.EqBand preEqBand) { throw new RuntimeException("Stub!"); }

/**
 * Gets Mbc configuration stage
 * @return Mbc configuration stage
 * @apiSince 28
 */

public android.media.audiofx.DynamicsProcessing.Mbc getMbc() { throw new RuntimeException("Stub!"); }

/**
 * Sets Mbc configuration stage. New Mbc stage must have the same number of bands than
 * original Mbc stage.
 * @param mbc
 * @apiSince 28
 */

public void setMbc(android.media.audiofx.DynamicsProcessing.Mbc mbc) { throw new RuntimeException("Stub!"); }

/**
 * Gets MbcBand configuration for Mbc stage, for given band index.
 * @param band index of band of interest from Mbc stage
 * @return MbcBand configuration
 * @apiSince 28
 */

public android.media.audiofx.DynamicsProcessing.MbcBand getMbcBand(int band) { throw new RuntimeException("Stub!"); }

/**
 * Sets MbcBand for Mbc stage for given band index
 * @param band index of band of interest from Mbc Stage
 * @param mbcBand configuration to be set
 * @apiSince 28
 */

public void setMbcBand(int band, android.media.audiofx.DynamicsProcessing.MbcBand mbcBand) { throw new RuntimeException("Stub!"); }

/**
 * Gets PostEq configuration stage
 * @return PostEq configuration stage
 * @apiSince 28
 */

public android.media.audiofx.DynamicsProcessing.Eq getPostEq() { throw new RuntimeException("Stub!"); }

/**
 * Sets PostEq configuration stage. New PostEq stage must have the same number of bands than
 * original PostEq stage.
 * @param postEq configuration
 * @apiSince 28
 */

public void setPostEq(android.media.audiofx.DynamicsProcessing.Eq postEq) { throw new RuntimeException("Stub!"); }

/**
 * Gets EqBand for PostEq stage for given band index.
 * @param band index of band of interest from PostEq stage
 * @return EqBand configuration
 * @apiSince 28
 */

public android.media.audiofx.DynamicsProcessing.EqBand getPostEqBand(int band) { throw new RuntimeException("Stub!"); }

/**
 * Sets EqBand for PostEq stage for given band index
 * @param band index of band of interest from PostEq stage
 * @param postEqBand configuration to be set.
 * @apiSince 28
 */

public void setPostEqBand(int band, android.media.audiofx.DynamicsProcessing.EqBand postEqBand) { throw new RuntimeException("Stub!"); }

/**
 * Gets Limiter configuration stage
 * @return Limiter configuration stage
 * @apiSince 28
 */

public android.media.audiofx.DynamicsProcessing.Limiter getLimiter() { throw new RuntimeException("Stub!"); }

/**
 * Sets Limiter configuration stage.
 * @param limiter configuration stage.
 * @apiSince 28
 */

public void setLimiter(android.media.audiofx.DynamicsProcessing.Limiter limiter) { throw new RuntimeException("Stub!"); }
}

/**
 * Class for Config object, used by DynamicsProcessing to configure and update the audio effect.
 * use Builder to instantiate objects of this type.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Config {

Config() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Gets variant for effect engine See {@link #VARIANT_FAVOR_FREQUENCY_RESOLUTION} and
 * {@link #VARIANT_FAVOR_TIME_RESOLUTION}.
 * @return variant of effect engine
 * @apiSince 28
 */

public int getVariant() { throw new RuntimeException("Stub!"); }

/**
 * Gets preferred frame duration in milliseconds (ms).
 * @return preferred frame duration in milliseconds (ms)
 * @apiSince 28
 */

public float getPreferredFrameDuration() { throw new RuntimeException("Stub!"); }

/**
 * Gets if preEq stage is in use
 * @return true if preEq stage is in use;
 * @apiSince 28
 */

public boolean isPreEqInUse() { throw new RuntimeException("Stub!"); }

/**
 * Gets number of bands configured for the PreEq stage.
 * @return number of bands configured for the PreEq stage.
 * @apiSince 28
 */

public int getPreEqBandCount() { throw new RuntimeException("Stub!"); }

/**
 * Gets if Mbc stage is in use
 * @return true if Mbc stage is in use;
 * @apiSince 28
 */

public boolean isMbcInUse() { throw new RuntimeException("Stub!"); }

/**
 * Gets number of bands configured for the Mbc stage.
 * @return number of bands configured for the Mbc stage.
 * @apiSince 28
 */

public int getMbcBandCount() { throw new RuntimeException("Stub!"); }

/**
 * Gets if PostEq stage is in use
 * @return true if PostEq stage is in use;
 * @apiSince 28
 */

public boolean isPostEqInUse() { throw new RuntimeException("Stub!"); }

/**
 * Gets number of bands configured for the PostEq stage.
 * @return number of bands configured for the PostEq stage.
 * @apiSince 28
 */

public int getPostEqBandCount() { throw new RuntimeException("Stub!"); }

/**
 * Gets if Limiter stage is in use
 * @return true if Limiter stage is in use;
 * @apiSince 28
 */

public boolean isLimiterInUse() { throw new RuntimeException("Stub!"); }

/**
 * Gets the Channel configuration object by using the channel index
 * @param channelIndex of desired Channel object
 * @return Channel configuration object
 * @apiSince 28
 */

public android.media.audiofx.DynamicsProcessing.Channel getChannelByChannelIndex(int channelIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sets the chosen Channel object in the selected channelIndex
 * Note that all the stages should have the same number of bands than the existing Channel
 * object.
 * @param channelIndex index of channel to be replaced
 * @param channel Channel configuration object to be set
 * @apiSince 28
 */

public void setChannelTo(int channelIndex, android.media.audiofx.DynamicsProcessing.Channel channel) { throw new RuntimeException("Stub!"); }

/**
 * Sets ALL channels to the chosen Channel object. Note that all the stages should have the
 * same number of bands than the existing ones.
 * @param channel Channel configuration object to be set.
 * @apiSince 28
 */

public void setAllChannelsTo(android.media.audiofx.DynamicsProcessing.Channel channel) { throw new RuntimeException("Stub!"); }

/**
 * Gets inputGain value in decibels (dB) for channel indicated by channelIndex
 * @param channelIndex index of channel of interest
 * @return inputGain value in decibels (dB). 0 dB means no change.
 * @apiSince 28
 */

public float getInputGainByChannelIndex(int channelIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sets the inputGain value in decibels (dB) for the channel indicated by channelIndex.
 * @param channelIndex index of channel of interest
 * @param inputGain desired value in decibels (dB).
 * @apiSince 28
 */

public void setInputGainByChannelIndex(int channelIndex, float inputGain) { throw new RuntimeException("Stub!"); }

/**
 * Sets the inputGain value in decibels (dB) for ALL channels
 * @param inputGain desired value in decibels (dB)
 * @apiSince 28
 */

public void setInputGainAllChannelsTo(float inputGain) { throw new RuntimeException("Stub!"); }

/**
 * Gets PreEq stage from channel indicated by channelIndex
 * @param channelIndex index of channel of interest
 * @return PreEq stage configuration object
 * @apiSince 28
 */

public android.media.audiofx.DynamicsProcessing.Eq getPreEqByChannelIndex(int channelIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sets the PreEq stage configuration for the channel indicated by channelIndex. Note that
 * new preEq stage must have the same number of bands than original preEq stage
 * @param channelIndex index of channel to be set
 * @param preEq desired PreEq configuration to be set
 * @apiSince 28
 */

public void setPreEqByChannelIndex(int channelIndex, android.media.audiofx.DynamicsProcessing.Eq preEq) { throw new RuntimeException("Stub!"); }

/**
 * Sets the PreEq stage configuration for ALL channels. Note that new preEq stage must have
 * the same number of bands than original preEq stages.
 * @param preEq desired PreEq configuration to be set
 * @apiSince 28
 */

public void setPreEqAllChannelsTo(android.media.audiofx.DynamicsProcessing.Eq preEq) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.EqBand getPreEqBandByChannelIndex(int channelIndex, int band) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setPreEqBandByChannelIndex(int channelIndex, int band, android.media.audiofx.DynamicsProcessing.EqBand preEqBand) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setPreEqBandAllChannelsTo(int band, android.media.audiofx.DynamicsProcessing.EqBand preEqBand) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Mbc getMbcByChannelIndex(int channelIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setMbcByChannelIndex(int channelIndex, android.media.audiofx.DynamicsProcessing.Mbc mbc) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setMbcAllChannelsTo(android.media.audiofx.DynamicsProcessing.Mbc mbc) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.MbcBand getMbcBandByChannelIndex(int channelIndex, int band) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setMbcBandByChannelIndex(int channelIndex, int band, android.media.audiofx.DynamicsProcessing.MbcBand mbcBand) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setMbcBandAllChannelsTo(int band, android.media.audiofx.DynamicsProcessing.MbcBand mbcBand) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Eq getPostEqByChannelIndex(int channelIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setPostEqByChannelIndex(int channelIndex, android.media.audiofx.DynamicsProcessing.Eq postEq) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setPostEqAllChannelsTo(android.media.audiofx.DynamicsProcessing.Eq postEq) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.EqBand getPostEqBandByChannelIndex(int channelIndex, int band) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setPostEqBandByChannelIndex(int channelIndex, int band, android.media.audiofx.DynamicsProcessing.EqBand postEqBand) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setPostEqBandAllChannelsTo(int band, android.media.audiofx.DynamicsProcessing.EqBand postEqBand) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Limiter getLimiterByChannelIndex(int channelIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setLimiterByChannelIndex(int channelIndex, android.media.audiofx.DynamicsProcessing.Limiter limiter) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setLimiterAllChannelsTo(android.media.audiofx.DynamicsProcessing.Limiter limiter) { throw new RuntimeException("Stub!"); }
/** @apiSince 28 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/** @apiSince 28 */

public Builder(int variant, int channelCount, boolean preEqInUse, int preEqBandCount, boolean mbcInUse, int mbcBandCount, boolean postEqInUse, int postEqBandCount, boolean limiterInUse) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Config.Builder setPreferredFrameDuration(float frameDuration) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Config.Builder setInputGainByChannelIndex(int channelIndex, float inputGain) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Config.Builder setInputGainAllChannelsTo(float inputGain) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Config.Builder setChannelTo(int channelIndex, android.media.audiofx.DynamicsProcessing.Channel channel) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Config.Builder setAllChannelsTo(android.media.audiofx.DynamicsProcessing.Channel channel) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Config.Builder setPreEqByChannelIndex(int channelIndex, android.media.audiofx.DynamicsProcessing.Eq preEq) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Config.Builder setPreEqAllChannelsTo(android.media.audiofx.DynamicsProcessing.Eq preEq) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Config.Builder setMbcByChannelIndex(int channelIndex, android.media.audiofx.DynamicsProcessing.Mbc mbc) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Config.Builder setMbcAllChannelsTo(android.media.audiofx.DynamicsProcessing.Mbc mbc) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Config.Builder setPostEqByChannelIndex(int channelIndex, android.media.audiofx.DynamicsProcessing.Eq postEq) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Config.Builder setPostEqAllChannelsTo(android.media.audiofx.DynamicsProcessing.Eq postEq) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Config.Builder setLimiterByChannelIndex(int channelIndex, android.media.audiofx.DynamicsProcessing.Limiter limiter) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Config.Builder setLimiterAllChannelsTo(android.media.audiofx.DynamicsProcessing.Limiter limiter) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.media.audiofx.DynamicsProcessing.Config build() { throw new RuntimeException("Stub!"); }
}

}

/**
 * Class for Equalizer stage
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Eq extends android.media.audiofx.DynamicsProcessing.BandStage {

/**
 * Class constructor for Equalizer (Eq) stage
 * @param inUse true if Eq stage will be used, false otherwise.
 * @param enabled true if Eq stage is enabled/disabled. This can be changed while effect is
 * running
 * @param bandCount number of bands for this Equalizer stage. Can't be changed while effect
 * is running
 * @apiSince 28
 */

public Eq(boolean inUse, boolean enabled, int bandCount) { super(false, false, 0); throw new RuntimeException("Stub!"); }

/**
 * Class constructor for Eq stage
 * @param cfg copy constructor
 * @apiSince 28
 */

public Eq(android.media.audiofx.DynamicsProcessing.Eq cfg) { super(false, false, 0); throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Sets EqBand object for given band index
 * @param band index of band to be modified
 * @param bandCfg EqBand object.
 * @apiSince 28
 */

public void setBand(int band, android.media.audiofx.DynamicsProcessing.EqBand bandCfg) { throw new RuntimeException("Stub!"); }

/**
 * Gets EqBand object for band of interest.
 * @param band index of band of interest
 * @return EqBand Object
 * @apiSince 28
 */

public android.media.audiofx.DynamicsProcessing.EqBand getBand(int band) { throw new RuntimeException("Stub!"); }
}

/**
 * Class for Equalizer Bands
 * Equalizer bands have three controllable parameters: enabled/disabled, cutoffFrequency and
 * gain
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class EqBand extends android.media.audiofx.DynamicsProcessing.BandBase {

/**
 * Class constructor for EqBand
 * @param enabled true if this band is currently used to process sound. When false,
 * the band is effectively muted and sound set to zero.
 * @param cutoffFrequency topmost frequency number (in Hz) this band will process. The
 * effective bandwidth for the band is then computed using this and the previous band
 * topmost frequency (or 0 Hz for band number 0). Frequencies are expected to increase with
 * band number, thus band 0 cutoffFrequency <= band 1 cutoffFrequency, and so on.
 * @param gain of equalizer band in decibels (dB). A gain of 0 dB means no change in level.
 * @apiSince 28
 */

public EqBand(boolean enabled, float cutoffFrequency, float gain) { super(false, (float)0); throw new RuntimeException("Stub!"); }

/**
 * Class constructor for EqBand
 * @param cfg copy constructor
 * @apiSince 28
 */

public EqBand(android.media.audiofx.DynamicsProcessing.EqBand cfg) { super(false, (float)0); throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * gets current gain of band in decibels (dB)
 * @return current gain of band in decibels (dB)
 * @apiSince 28
 */

public float getGain() { throw new RuntimeException("Stub!"); }

/**
 * sets current gain of band in decibels (dB)
 * @param gain desired in decibels (db)
 * @apiSince 28
 */

public void setGain(float gain) { throw new RuntimeException("Stub!"); }
}

/**
 * Class for Limiter Stage
 * Limiter is a single band compressor at the end of the processing chain, commonly used to
 * protect the signal from overloading and distortion. Limiters have multiple controllable
 * parameters: enabled/disabled, linkGroup, attackTime, releaseTime, ratio, threshold, and
 * postGain.
 * <p>Limiters can be linked in groups across multiple channels. Linked limiters will trigger
 * the same limiting if any of the linked limiters starts compressing.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Limiter extends android.media.audiofx.DynamicsProcessing.Stage {

/**
 * Class constructor for Limiter Stage
 * @param inUse true if MBC stage will be used, false otherwise.
 * @param enabled true if MBC stage is enabled/disabled. This can be changed while effect
 * is running
 * @param linkGroup index of group assigned to this Limiter. Only limiters that share the
 * same linkGroup index will react together.
 * @param attackTime Attack Time for limiter compressor in milliseconds (ms)
 * @param releaseTime Release Time for limiter compressor in milliseconds (ms)
 * @param ratio Limiter Compressor ratio (N:1) (input:output)
 * @param threshold Limiter Compressor threshold measured in decibels (dB) from 0 dB Full
 * Scale (dBFS).
 * @param postGain Gain applied to the signal AFTER compression.
 * @apiSince 28
 */

public Limiter(boolean inUse, boolean enabled, int linkGroup, float attackTime, float releaseTime, float ratio, float threshold, float postGain) { super(false, false); throw new RuntimeException("Stub!"); }

/**
 * Class Constructor for Limiter
 * @param cfg copy constructor
 * @apiSince 28
 */

public Limiter(android.media.audiofx.DynamicsProcessing.Limiter cfg) { super(false, false); throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Gets the linkGroup index for this Limiter Stage. Only limiters that share the same
 * linkGroup index will react together.
 * @return linkGroup index.
 * @apiSince 28
 */

public int getLinkGroup() { throw new RuntimeException("Stub!"); }

/**
 * Sets the linkGroup index for this limiter Stage.
 * @param linkGroup desired linkGroup index
 * @apiSince 28
 */

public void setLinkGroup(int linkGroup) { throw new RuntimeException("Stub!"); }

/**
 * gets attack time for limiter compressor in milliseconds (ms)
 * @return attack time for limiter compressor in milliseconds (ms)
 * @apiSince 28
 */

public float getAttackTime() { throw new RuntimeException("Stub!"); }

/**
 * sets attack time for limiter compressor in milliseconds (ms)
 * @param attackTime desired for limiter compressor in milliseconds (ms)
 * @apiSince 28
 */

public void setAttackTime(float attackTime) { throw new RuntimeException("Stub!"); }

/**
 * gets release time for limiter compressor in milliseconds (ms)
 * @return release time for limiter compressor in milliseconds (ms)
 * @apiSince 28
 */

public float getReleaseTime() { throw new RuntimeException("Stub!"); }

/**
 * sets release time for limiter compressor in milliseconds (ms)
 * @param releaseTime desired for limiter compressor in milliseconds (ms)
 * @apiSince 28
 */

public void setReleaseTime(float releaseTime) { throw new RuntimeException("Stub!"); }

/**
 * gets the limiter compressor ratio (N:1)
 * @return limiter compressor ratio (N:1)
 * @apiSince 28
 */

public float getRatio() { throw new RuntimeException("Stub!"); }

/**
 * sets limiter compressor ratio (N:1)
 * @param ratio desired for the limiter compressor (N:1)
 * @apiSince 28
 */

public void setRatio(float ratio) { throw new RuntimeException("Stub!"); }

/**
 * gets the limiter compressor threshold measured in decibels (dB) from 0 dB Full Scale
 * (dBFS). Thresholds are negative. A threshold of 0 dB means no limiting will take place.
 * @return limiter compressor threshold in decibels (dB)
 * @apiSince 28
 */

public float getThreshold() { throw new RuntimeException("Stub!"); }

/**
 * sets the limiter compressor threshold measured in decibels (dB) from 0 dB Full Scale
 * (dBFS). Thresholds are negative. A threshold of 0 dB means no limiting will take place.
 * @param threshold desired for limiter compressor in decibels(dB)
 * @apiSince 28
 */

public void setThreshold(float threshold) { throw new RuntimeException("Stub!"); }

/**
 * gets the gain applied to the signal AFTER limiting. Measured in decibels (dB) where 0
 * dB means no level change
 * @return postGain value in decibels (dB)
 * @apiSince 28
 */

public float getPostGain() { throw new RuntimeException("Stub!"); }

/**
 * sets the gain to be applied to the siganl AFTER the limiter. Measured in decibels
 * (dB), where 0 dB means no level change.
 * @param postGain desired value in decibels (dB)
 * @apiSince 28
 */

public void setPostGain(float postGain) { throw new RuntimeException("Stub!"); }
}

/**
 * Class for Multi-Band Compressor (MBC) stage
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Mbc extends android.media.audiofx.DynamicsProcessing.BandStage {

/**
 * Constructor for Multi-Band Compressor (MBC) stage
 * @param inUse true if MBC stage will be used, false otherwise.
 * @param enabled true if MBC stage is enabled/disabled. This can be changed while effect
 * is running
 * @param bandCount number of bands for this MBC stage. Can't be changed while effect is
 * running
 * @apiSince 28
 */

public Mbc(boolean inUse, boolean enabled, int bandCount) { super(false, false, 0); throw new RuntimeException("Stub!"); }

/**
 * Class constructor for MBC stage
 * @param cfg copy constructor
 * @apiSince 28
 */

public Mbc(android.media.audiofx.DynamicsProcessing.Mbc cfg) { super(false, false, 0); throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Sets MbcBand object for given band index
 * @param band index of band to be modified
 * @param bandCfg MbcBand object.
 * @apiSince 28
 */

public void setBand(int band, android.media.audiofx.DynamicsProcessing.MbcBand bandCfg) { throw new RuntimeException("Stub!"); }

/**
 * Gets MbcBand object for band of interest.
 * @param band index of band of interest
 * @return MbcBand Object
 * @apiSince 28
 */

public android.media.audiofx.DynamicsProcessing.MbcBand getBand(int band) { throw new RuntimeException("Stub!"); }
}

/**
 * Class for Multi-Band compressor bands
 * MBC bands have multiple controllable parameters: enabled/disabled, cutoffFrequency,
 * attackTime, releaseTime, ratio, threshold, kneeWidth, noiseGateThreshold, expanderRatio,
 * preGain and postGain.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class MbcBand extends android.media.audiofx.DynamicsProcessing.BandBase {

/**
 * Class constructor for MbcBand
 * @param enabled true if this band is currently used to process sound. When false,
 * the band is effectively muted and sound set to zero.
 * @param cutoffFrequency topmost frequency number (in Hz) this band will process. The
 * effective bandwidth for the band is then computed using this and the previous band
 * topmost frequency (or 0 Hz for band number 0). Frequencies are expected to increase with
 * band number, thus band 0 cutoffFrequency <= band 1 cutoffFrequency, and so on.
 * @param attackTime Attack Time for compressor in milliseconds (ms)
 * @param releaseTime Release Time for compressor in milliseconds (ms)
 * @param ratio Compressor ratio (N:1) (input:output)
 * @param threshold Compressor threshold measured in decibels (dB) from 0 dB Full Scale
 * (dBFS).
 * @param kneeWidth Width in decibels (dB) around compressor threshold point.
 * @param noiseGateThreshold Noise gate threshold in decibels (dB) from 0 dB Full Scale
 * (dBFS).
 * @param expanderRatio Expander ratio (1:N) (input:output) for signals below the Noise Gate
 * Threshold.
 * @param preGain Gain applied to the signal BEFORE the compression.
 * @param postGain Gain applied to the signal AFTER compression.
 * @apiSince 28
 */

public MbcBand(boolean enabled, float cutoffFrequency, float attackTime, float releaseTime, float ratio, float threshold, float kneeWidth, float noiseGateThreshold, float expanderRatio, float preGain, float postGain) { super(false, (float)0); throw new RuntimeException("Stub!"); }

/**
 * Class constructor for MbcBand
 * @param cfg copy constructor
 * @apiSince 28
 */

public MbcBand(android.media.audiofx.DynamicsProcessing.MbcBand cfg) { super(false, (float)0); throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * gets attack time for compressor in milliseconds (ms)
 * @return attack time for compressor in milliseconds (ms)
 * @apiSince 28
 */

public float getAttackTime() { throw new RuntimeException("Stub!"); }

/**
 * sets attack time for compressor in milliseconds (ms)
 * @param attackTime desired for compressor in milliseconds (ms)
 * @apiSince 28
 */

public void setAttackTime(float attackTime) { throw new RuntimeException("Stub!"); }

/**
 * gets release time for compressor in milliseconds (ms)
 * @return release time for compressor in milliseconds (ms)
 * @apiSince 28
 */

public float getReleaseTime() { throw new RuntimeException("Stub!"); }

/**
 * sets release time for compressor in milliseconds (ms)
 * @param releaseTime desired for compressor in milliseconds (ms)
 * @apiSince 28
 */

public void setReleaseTime(float releaseTime) { throw new RuntimeException("Stub!"); }

/**
 * gets the compressor ratio (N:1)
 * @return compressor ratio (N:1)
 * @apiSince 28
 */

public float getRatio() { throw new RuntimeException("Stub!"); }

/**
 * sets compressor ratio (N:1)
 * @param ratio desired for the compressor (N:1)
 * @apiSince 28
 */

public void setRatio(float ratio) { throw new RuntimeException("Stub!"); }

/**
 * gets the compressor threshold measured in decibels (dB) from 0 dB Full Scale (dBFS).
 * Thresholds are negative. A threshold of 0 dB means no compression will take place.
 * @return compressor threshold in decibels (dB)
 * @apiSince 28
 */

public float getThreshold() { throw new RuntimeException("Stub!"); }

/**
 * sets the compressor threshold measured in decibels (dB) from 0 dB Full Scale (dBFS).
 * Thresholds are negative. A threshold of 0 dB means no compression will take place.
 * @param threshold desired for compressor in decibels(dB)
 * @apiSince 28
 */

public void setThreshold(float threshold) { throw new RuntimeException("Stub!"); }

/**
 * get Knee Width in decibels (dB) around compressor threshold point. Widths are always
 * positive, with higher values representing a wider area of transition from the linear zone
 * to the compression zone. A knee of 0 dB means a more abrupt transition.
 * @return Knee Width in decibels (dB)
 * @apiSince 28
 */

public float getKneeWidth() { throw new RuntimeException("Stub!"); }

/**
 * sets knee width in decibels (dB). See
 * {@link android.media.audiofx.DynamicsProcessing.MbcBand#getKneeWidth} for more
 * information.
 * @param kneeWidth desired in decibels (dB)
 * @apiSince 28
 */

public void setKneeWidth(float kneeWidth) { throw new RuntimeException("Stub!"); }

/**
 * gets the noise gate threshold in decibels (dB) from 0 dB Full Scale (dBFS). Noise gate
 * thresholds are negative. Signals below this level will be expanded according the
 * expanderRatio parameter. A Noise Gate Threshold of -75 dB means very quiet signals might
 * be effectively removed from the signal.
 * @return Noise Gate Threshold in decibels (dB)
 * @apiSince 28
 */

public float getNoiseGateThreshold() { throw new RuntimeException("Stub!"); }

/**
 * sets noise gate threshod in decibels (dB). See
 * {@link android.media.audiofx.DynamicsProcessing.MbcBand#getNoiseGateThreshold} for more
 * information.
 * @param noiseGateThreshold desired in decibels (dB)
 * @apiSince 28
 */

public void setNoiseGateThreshold(float noiseGateThreshold) { throw new RuntimeException("Stub!"); }

/**
 * gets Expander ratio (1:N) for signals below the Noise Gate Threshold.
 * @return Expander ratio (1:N)
 * @apiSince 28
 */

public float getExpanderRatio() { throw new RuntimeException("Stub!"); }

/**
 * sets Expander ratio (1:N) for signals below the Noise Gate Threshold.
 * @param expanderRatio desired expander ratio (1:N)
 * @apiSince 28
 */

public void setExpanderRatio(float expanderRatio) { throw new RuntimeException("Stub!"); }

/**
 * gets the gain applied to the signal BEFORE the compression. Measured in decibels (dB)
 * where 0 dB means no level change.
 * @return preGain value in decibels (dB)
 * @apiSince 28
 */

public float getPreGain() { throw new RuntimeException("Stub!"); }

/**
 * sets the gain to be applied to the signal BEFORE the compression, measured in decibels
 * (dB), where 0 dB means no level change.
 * @param preGain desired in decibels (dB)
 * @apiSince 28
 */

public void setPreGain(float preGain) { throw new RuntimeException("Stub!"); }

/**
 * gets the gain applied to the signal AFTER compression. Measured in decibels (dB) where 0
 * dB means no level change
 * @return postGain value in decibels (dB)
 * @apiSince 28
 */

public float getPostGain() { throw new RuntimeException("Stub!"); }

/**
 * sets the gain to be applied to the siganl AFTER the compression. Measured in decibels
 * (dB), where 0 dB means no level change.
 * @param postGain desired value in decibels (dB)
 * @apiSince 28
 */

public void setPostGain(float postGain) { throw new RuntimeException("Stub!"); }
}

/**
 * base class for the different stages.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Stage {

/**
 * Class constructor for stage
 * @param inUse true if this stage is set to be used. False otherwise. Stages that are not
 * set "inUse" at initialization time are not available to be used at any time.
 * @param enabled true if this stage is currently used to process sound. When disabled,
 * the stage is bypassed and the sound is copied unaltered from input to output.
 * @apiSince 28
 */

public Stage(boolean inUse, boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * returns enabled state of the stage
 * @return true if stage is enabled for processing, false otherwise
 * @apiSince 28
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * sets enabled state of the stage
 * @param enabled true for enabled, false otherwise
 * @apiSince 28
 */

public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * returns inUse state of the stage.
 * @return inUse state of the stage. True if this stage is currently used to process sound.
 * When false, the stage is bypassed and the sound is copied unaltered from input to output.
 * @apiSince 28
 */

public boolean isInUse() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

}

