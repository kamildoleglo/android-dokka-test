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


package android.graphics;


/** @apiSince 29 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum BlendMode {
/**
 * {@usesMathJax}
 *
 * <p>
 *  <img src="{@docRoot}reference/android/images/graphics/blendmode_CLEAR.png" />
 *  <figcaption>Destination pixels covered by the source are cleared to 0.</figcaption>
 * </p>
 * <p>\(\alpha_{out} = 0\)</p>
 * <p>\(C_{out} = 0\)</p>
 * @apiSince 29
 */

CLEAR,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_SRC.png" />
 *     <figcaption>The source pixels replace the destination pixels.</figcaption>
 * </p>
 * <p>\(\alpha_{out} = \alpha_{src}\)</p>
 * <p>\(C_{out} = C_{src}\)</p>
 * @apiSince 29
 */

SRC,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_DST.png" />
 *     <figcaption>The source pixels are discarded, leaving the destination intact.</figcaption>
 * </p>
 * <p>\(\alpha_{out} = \alpha_{dst}\)</p>
 * <p>\(C_{out} = C_{dst}\)</p>
 * @apiSince 29
 */

DST,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_SRC_OVER.png" />
 *     <figcaption>The source pixels are drawn over the destination pixels.</figcaption>
 * </p>
 * <p>\(\alpha_{out} = \alpha_{src} + (1 - \alpha_{src}) * \alpha_{dst}\)</p>
 * <p>\(C_{out} = C_{src} + (1 - \alpha_{src}) * C_{dst}\)</p>
 * @apiSince 29
 */

SRC_OVER,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_DST_OVER.png" />
 *     <figcaption>The source pixels are drawn behind the destination pixels.</figcaption>
 * </p>
 * <p>\(\alpha_{out} = \alpha_{dst} + (1 - \alpha_{dst}) * \alpha_{src}\)</p>
 * <p>\(C_{out} = C_{dst} + (1 - \alpha_{dst}) * C_{src}\)</p>
 * @apiSince 29
 */

DST_OVER,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_SRC_IN.png" />
 *     <figcaption>Keeps the source pixels that cover the destination pixels,
 *     discards the remaining source and destination pixels.</figcaption>
 * </p>
 * <p>\(\alpha_{out} = \alpha_{src} * \alpha_{dst}\)</p>
 * <p>\(C_{out} = C_{src} * \alpha_{dst}\)</p>
 * @apiSince 29
 */

SRC_IN,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_DST_IN.png" />
 *     <figcaption>Keeps the destination pixels that cover source pixels,
 *     discards the remaining source and destination pixels.</figcaption>
 * </p>
 * <p>\(\alpha_{out} = \alpha_{src} * \alpha_{dst}\)</p>
 * <p>\(C_{out} = C_{dst} * \alpha_{src}\)</p>
 * @apiSince 29
 */

DST_IN,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_SRC_OUT.png" />
 *     <figcaption>Keeps the source pixels that do not cover destination pixels.
 *     Discards source pixels that cover destination pixels. Discards all
 *     destination pixels.</figcaption>
 * </p>
 * <p>\(\alpha_{out} = (1 - \alpha_{dst}) * \alpha_{src}\)</p>
 * <p>\(C_{out} = (1 - \alpha_{dst}) * C_{src}\)</p>
 * @apiSince 29
 */

SRC_OUT,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_DST_OUT.png" />
 *     <figcaption>Keeps the destination pixels that are not covered by source pixels.
 *     Discards destination pixels that are covered by source pixels. Discards all
 *     source pixels.</figcaption>
 * </p>
 * <p>\(\alpha_{out} = (1 - \alpha_{src}) * \alpha_{dst}\)</p>
 * <p>\(C_{out} = (1 - \alpha_{src}) * C_{dst}\)</p>
 * @apiSince 29
 */

DST_OUT,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_SRC_ATOP.png" />
 *     <figcaption>Discards the source pixels that do not cover destination pixels.
 *     Draws remaining source pixels over destination pixels.</figcaption>
 * </p>
 * <p>\(\alpha_{out} = \alpha_{dst}\)</p>
 * <p>\(C_{out} = \alpha_{dst} * C_{src} + (1 - \alpha_{src}) * C_{dst}\)</p>
 * @apiSince 29
 */

SRC_ATOP,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_DST_ATOP.png" />
 *     <figcaption>Discards the destination pixels that are not covered by source pixels.
 *     Draws remaining destination pixels over source pixels.</figcaption>
 * </p>
 * <p>\(\alpha_{out} = \alpha_{src}\)</p>
 * <p>\(C_{out} = \alpha_{src} * C_{dst} + (1 - \alpha_{dst}) * C_{src}\)</p>
 * @apiSince 29
 */

DST_ATOP,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_XOR.png" />
 *     <figcaption>Discards the source and destination pixels where source pixels
 *     cover destination pixels. Draws remaining source pixels.</figcaption>
 * </p>
 * <p>
 *     \(\alpha_{out} = (1 - \alpha_{dst}) * \alpha_{src} + (1 - \alpha_{src}) * \alpha_{dst}\)
 * </p>
 * <p>\(C_{out} = (1 - \alpha_{dst}) * C_{src} + (1 - \alpha_{src}) * C_{dst}\)</p>
 * @apiSince 29
 */

XOR,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_PLUS.png" />
 *     <figcaption>Adds the source pixels to the destination pixels and saturates
 *     the result.</figcaption>
 * </p>
 * <p>\(\alpha_{out} = max(0, min(\alpha_{src} + \alpha_{dst}, 1))\)</p>
 * <p>\(C_{out} = max(0, min(C_{src} + C_{dst}, 1))\)</p>
 * @apiSince 29
 */

PLUS,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_MODULATE.png" />
 *     <figcaption>Multiplies the source and destination pixels.</figcaption>
 * </p>
 * <p>\(\alpha_{out} = \alpha_{src} * \alpha_{dst}\)</p>
 * <p>\(C_{out} = C_{src} * C_{dst}\)</p>
 *
 * @apiSince 29
 */

MODULATE,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_SCREEN.png" />
 *     <figcaption>
 *         Adds the source and destination pixels, then subtracts the
 *         source pixels multiplied by the destination.
 *     </figcaption>
 * </p>
 * <p>\(\alpha_{out} = \alpha_{src} + \alpha_{dst} - \alpha_{src} * \alpha_{dst}\)</p>
 * <p>\(C_{out} = C_{src} + C_{dst} - C_{src} * C_{dst}\)</p>
 * @apiSince 29
 */

SCREEN,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_OVERLAY.png" />
 *     <figcaption>
 *         Multiplies or screens the source and destination depending on the
 *         destination color.
 *     </figcaption>
 * </p>
 * <p>\(\alpha_{out} = \alpha_{src} + \alpha_{dst} - \alpha_{src} * \alpha_{dst}\)</p>
 * <p>\(\begin{equation}
 * C_{out} = \begin{cases} 2 * C_{src} * C_{dst} & 2 * C_{dst} \lt \alpha_{dst} \\
 * \alpha_{src} * \alpha_{dst} - 2 (\alpha_{dst} - C_{src}) (\alpha_{src} - C_{dst}) &
 * otherwise \end{cases}
 * \end{equation}\)</p>
 * @apiSince 29
 */

OVERLAY,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_DARKEN.png" />
 *     <figcaption>
 *         Retains the smallest component of the source and
 *         destination pixels.
 *     </figcaption>
 * </p>
 * <p>\(\alpha_{out} = \alpha_{src} + \alpha_{dst} - \alpha_{src} * \alpha_{dst}\)</p>
 * <p>
 *     \(C_{out} =
 *     (1 - \alpha_{dst}) * C_{src} + (1 - \alpha_{src}) * C_{dst} + min(C_{src}, C_{dst})\)
 * </p>
 * @apiSince 29
 */

DARKEN,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_LIGHTEN.png" />
 *     <figcaption>Retains the largest component of the source and
 *     destination pixel.</figcaption>
 * </p>
 * <p>\(\alpha_{out} = \alpha_{src} + \alpha_{dst} - \alpha_{src} * \alpha_{dst}\)</p>
 * <p>
 *     \(C_{out} =
 *      (1 - \alpha_{dst}) * C_{src} + (1 - \alpha_{src}) * C_{dst} + max(C_{src}, C_{dst})\)
 * </p>
 * @apiSince 29
 */

LIGHTEN,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_COLOR_DODGE.png" />
 *     <figcaption>Makes destination brighter to reflect source.</figcaption>
 * </p>
 * <p>
 *     \(\alpha_{out} = \alpha_{src} + \alpha_{dst} - \alpha_{src} * \alpha_{dst}\)
 * </p>
 * <p>
 *      \begin{equation}
 *      C_{out} =
 *      \begin{cases}
 *          C_{src} * (1 - \alpha_{dst}) & C_{dst} = 0 \\
 *          C_{src} + \alpha_{dst}*(1 - \alpha_{src}) & C_{src} = \alpha_{src} \\
 *          \alpha_{src} * min(\alpha_{dst}, C_{dst} * \alpha_{src}/(\alpha_{src} - C_{src}))
 *              + C_{src} *(1 - \alpha_{dst} + \alpha_{dst}*(1 - \alpha_{src}) & otherwise
 *      \end{cases}
 *      \end{equation}
 * </p>
 * @apiSince 29
 */

COLOR_DODGE,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_COLOR_BURN.png" />
 *     <figcaption>Makes destination darker to reflect source.</figcaption>
 * </p>
 * <p>
 *     \(\alpha_{out} = \alpha_{src} + \alpha_{dst} - \alpha_{src} * \alpha_{dst}\)
 * </p>
 * <p>
 *     \begin{equation}
 *     C_{out} =
 *     \begin{cases}
 *         C_{dst} + C_{src}*(1 - \alpha_{dst}) & C_{dst} = \alpha_{dst} \\
 *         \alpha_{dst}*(1 - \alpha_{src}) & C_{src} = 0 \\
 *         \alpha_{src}*(\alpha_{dst} - min(\alpha_{dst}, (\alpha_{dst}
 *         - C_{dst})*\alpha_{src}/C_{src}))
 *         + C_{src} * (1 - \alpha_{dst}) + \alpha_{dst}*(1-\alpha_{src}) & otherwise
 *     \end{cases}
 *     \end{equation}
 * </p>
 * @apiSince 29
 */

COLOR_BURN,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_HARD_LIGHT.png" />
 *     <figcaption>Makes destination lighter or darker, depending on source.</figcaption>
 * </p>
 * <p>
 *     \(\alpha_{out} = \alpha_{src} + \alpha_{dst} - \alpha_{src} * \alpha_{dst}\)
 * </p>
 * <p>
 *     \begin{equation}
 *      C_{out} =
 *      \begin{cases}
 *           2*C_{src}*C_{dst} & C_{src}*(1-\alpha_{dst}) + C_{dst}*(1-\alpha_{src}) + 2*C_{src}
 *              \leq \alpha_{src} \\
 *           \alpha_{src}*\alpha_{dst}- 2*(\alpha_{dst} - C_{dst})*(\alpha_{src} - C_{src})
 *              & otherwise
 *      \end{cases}
 *      \end{equation}
 * </p>
 * @apiSince 29
 */

HARD_LIGHT,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_SOFT_LIGHT.png" />
 *     <figcaption>Makes destination lighter or darker, depending on source.</figcaption>
 * </p>
 * <p>
 *     Where
 *       \begin{equation}
 *       m =
 *          \begin{cases}
 *              C_{dst} / \alpha_{dst} & \alpha_{dst} \gt 0 \\
 *              0 & otherwise
 *          \end{cases}
 *       \end{equation}
 * </p>
 * <p>
 *       \begin{equation}
 *       g =
 *          \begin{cases}
 *              (16 * m * m + 4 * m) * (m - 1) + 7 * m & 4 * C_{dst} \leq \alpha_{dst} \\
 *              \sqrt m - m & otherwise
 *          \end{cases}
 *       \end{equation}
 * </p>
 * <p>
 *       \begin{equation}
 *       f =
 *          \begin{cases}
 *              C_{dst} * (\alpha_{src} + (2 * C_{src} - \alpha_{src}) * (1 - m))
 *                  & 2 * C_{src} \leq \alpha_{src} \\
 *              C_{dst} * \alpha_{src} + \alpha_{dst} * (2 * C_{src} - \alpha_{src}) * g
 *                  & otherwise
 *          \end{cases}
 *       \end{equation}
 * </p>
 * <p>
 *       \begin{equation}
 *          \alpha_{out} = \alpha_{src} + \alpha_{dst} - \alpha_{src} * \alpha_{dst}
 *       \end{equation}
 *       \begin{equation}
 *          C_{out} = C_{src} / \alpha_{dst} + C_{dst} / \alpha_{src} + f
 *       \end{equation}
 * </p>
 * @apiSince 29
 */

SOFT_LIGHT,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_DIFFERENCE.png" />
 *     <figcaption>Subtracts darker from lighter with higher contrast.</figcaption>
 * </p>
 * <p>
 *     \begin{equation}
 *          \alpha_{out} = \alpha_{src} + \alpha_{dst} - \alpha_{src} * \alpha_{dst}
 *     \end{equation}
 * </p>
 * <p>
 *     \begin{equation}
 *           C_{out} = C_{src} + C_{dst} - 2 * min(C_{src}
 *                       * \alpha_{dst}, C_{dst} * \alpha_{src})
 *     \end{equation}
 * </p>
 * @apiSince 29
 */

DIFFERENCE,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_DIFFERENCE.png" />
 *     <figcaption>Subtracts darker from lighter with lower contrast.</figcaption>
 * </p>
 * <p>
 *     \begin{equation}
 *          \alpha_{out} = \alpha_{src} + \alpha_{dst} - \alpha_{src} * \alpha_{dst}
 *     \end{equation}
 * </p>
 * <p>
 *     \begin{equation}
 *          C_{out} = C_{src} + C_{dst} - 2 * C_{src} * C_{dst}
 *     \end{equation}
 * </p>
 * @apiSince 29
 */

EXCLUSION,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_MODULATE.png" />
 *     <figcaption>Multiplies the source and destination pixels.</figcaption>
 * </p>
 * <p>\(\alpha_{out} = \alpha_{src} + \alpha_{dst} - \alpha_{src} * \alpha_{dst}\)</p>
 * <p>\(C_{out} =
 *      C_{src} * (1 - \alpha_{dst}) + C_{dst} * (1 - \alpha_{src}) + (C_{src} * C_{dst})\)
 * </p>
 * @apiSince 29
 */

MULTIPLY,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_HUE.png" />
 *     <figcaption>
 *         Replaces hue of destination with hue of source, leaving saturation
 *         and luminosity unchanged.
 *     </figcaption>
 * </p>
 * @apiSince 29
 */

HUE,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_SATURATION.png" />
 *     <figcaption>
 *          Replaces saturation of destination saturation hue of source, leaving hue and
 *          luminosity unchanged.
 *     </figcaption>
 * </p>
 * @apiSince 29
 */

SATURATION,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_COLOR.png" />
 *     <figcaption>
 *          Replaces hue and saturation of destination with hue and saturation of source,
 *          leaving luminosity unchanged.
 *     </figcaption>
 * </p>
 * @apiSince 29
 */

COLOR,
/**
 * {@usesMathJax}
 *
 * <p>
 *     <img src="{@docRoot}reference/android/images/graphics/blendmode_LUMINOSITY.png" />
 *     <figcaption>
 *          Replaces luminosity of destination with luminosity of source, leaving hue and
 *          saturation unchanged.
 *     </figcaption>
 * </p>
 * @apiSince 29
 */

LUMINOSITY;
}

