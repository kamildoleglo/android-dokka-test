/*
 * Copyright 2018 The Android Open Source Project
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


package android.security;


/**
 * Class used for displaying confirmation prompts.
 *
 * <p>Confirmation prompts are prompts shown to the user to confirm a given text and are
 * implemented in a way that a positive response indicates with high confidence that the user has
 * seen the given text, even if the Android framework (including the kernel) was
 * compromised. Implementing confirmation prompts with these guarantees requires dedicated
 * hardware-support and may not always be available.
 *
 * <p>Confirmation prompts are typically used with an external entitity - the <i>Relying Party</i> -
 * in the following way. The setup steps are as follows:
 * <ul>
 * <li> Before first use, the application generates a key-pair with the
 * {@link android.security.keystore.KeyGenParameterSpec.Builder#setUserConfirmationRequired
 * CONFIRMATION tag} set. Device attestation,
 * e.g. {@link java.security.KeyStore#getCertificateChain getCertificateChain()}, is used to
 * generate a certificate chain that includes the public key (<code>Kpub</code> in the following)
 * of the newly generated key.
 * <li> The application sends <code>Kpub</code> and the certificate chain resulting from device
 * attestation to the <i>Relying Party</i>.
 * <li> The <i>Relying Party</i> validates the certificate chain which involves checking the root
 * certificate is what is expected (e.g. a certificate from Google), each certificate signs the
 * next one in the chain, ending with <code>Kpub</code>, and that the attestation certificate
 * asserts that <code>Kpub</code> has the
 * {@link android.security.keystore.KeyGenParameterSpec.Builder#setUserConfirmationRequired
 * CONFIRMATION tag} set.
 * Additionally the relying party stores <code>Kpub</code> and associates it with the device
 * it was received from.
 * </ul>
 *
 * <p>The <i>Relying Party</i> is typically an external device (for example connected via
 * Bluetooth) or application server.
 *
 * <p>Before executing a transaction which requires a high assurance of user content, the
 * application does the following:
 * <ul>
 * <li> The application gets a cryptographic nonce from the <i>Relying Party</i> and passes this as
 * the <code>extraData</code> (via the Builder helper class) to the
 * {@link #presentPrompt presentPrompt()} method. The <i>Relying Party</i> stores the nonce locally
 * since it'll use it in a later step.
 * <li> If the user approves the prompt a <i>Confirmation Response</i> is returned in the
 * {@link android.security.ConfirmationCallback#onConfirmed ConfirmationCallback#onConfirmed} callback as the
 * <code>dataThatWasConfirmed</code> parameter. This blob contains the text that was shown to the
 * user, the <code>extraData</code> parameter, and possibly other data.
 * <li> The application signs the <i>Confirmation Response</i> with the previously created key and
 * sends the blob and the signature to the <i>Relying Party</i>.
 * <li> The <i>Relying Party</i> checks that the signature was made with <code>Kpub</code> and then
 * extracts <code>promptText</code> matches what is expected and <code>extraData</code> matches the
 * previously created nonce. If all checks passes, the transaction is executed.
 * </ul>
 *
 * <p>A common way of implementing the "<code>promptText</code> is what is expected" check in the
 * last bullet, is to have the <i>Relying Party</i> generate <code>promptText</code> and store it
 * along the nonce in the <code>extraData</code> blob.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ConfirmationPrompt {

private ConfirmationPrompt() { throw new RuntimeException("Stub!"); }

/**
 * Requests a confirmation prompt to be presented to the user.
 *
 * When the prompt is no longer being presented, one of the methods in
 * {@link android.security.ConfirmationCallback ConfirmationCallback} is called on the supplied callback object.
 *
 * Confirmation prompts may not be available when accessibility services are running so this
 * may fail with a {@link android.security.ConfirmationNotAvailableException ConfirmationNotAvailableException} exception even if
 * {@link #isSupported} returns {@code true}.
 *
 * @param executor the executor identifying the thread that will receive the callback.
 * This value must never be {@code null}.
 * @param callback the callback to use when the prompt is done showing.
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the prompt text is too long or malfomed.
 * @throws android.security.ConfirmationAlreadyPresentingException if another prompt is being presented.
 * @throws android.security.ConfirmationNotAvailableException if confirmation prompts are not supported.
 * @apiSince 28
 */

public void presentPrompt(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.security.ConfirmationCallback callback) throws android.security.ConfirmationAlreadyPresentingException, android.security.ConfirmationNotAvailableException { throw new RuntimeException("Stub!"); }

/**
 * Cancels a prompt currently being displayed.
 *
 * On success, the
 * {@link android.security.ConfirmationCallback#onCanceled ConfirmationCallback#onCanceled} method on
 * the supplied callback object will be called asynchronously.
 *
 * @throws java.lang.IllegalStateException if no prompt is currently being presented.
 * @apiSince 28
 */

public void cancelPrompt() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the device supports confirmation prompts.
 *
 * @param context the application context.
 * @return true if confirmation prompts are supported by the device.
 * @apiSince 28
 */

public static boolean isSupported(android.content.Context context) { throw new RuntimeException("Stub!"); }
/**
 * A builder that collects arguments, to be shown on the system-provided confirmation prompt.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a builder for the confirmation prompt.
 *
 * @param context the application context
 * @apiSince 28
 */

public Builder(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Sets the prompt text for the prompt.
 *
 * @param promptText the text to present in the prompt.
 * @return the builder.
 * @apiSince 28
 */

public android.security.ConfirmationPrompt.Builder setPromptText(java.lang.CharSequence promptText) { throw new RuntimeException("Stub!"); }

/**
 * Sets the extra data for the prompt.
 *
 * @param extraData data to include in the response data.
 * @return the builder.
 * @apiSince 28
 */

public android.security.ConfirmationPrompt.Builder setExtraData(byte[] extraData) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.security.ConfirmationPrompt ConfirmationPrompt} with the arguments supplied to this builder.
 *
 * @return a {@link android.security.ConfirmationPrompt ConfirmationPrompt}
 * @throws java.lang.IllegalArgumentException if any of the required fields are not set.
 * @apiSince 28
 */

public android.security.ConfirmationPrompt build() { throw new RuntimeException("Stub!"); }
}

}

