/*
 * Copyright (C) 2011 The Android Open Source Project
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
 * The KeyChainAliasCallback is the callback for {@link android.security.KeyChain#choosePrivateKeyAlias KeyChain#choosePrivateKeyAlias}.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface KeyChainAliasCallback {

/**
 * Called with the alias of the certificate chosen by the user, or
 * null if no value was chosen.
 
 * @param alias This value may be {@code null}.
 * @apiSince 14
 */

public void alias(@androidx.annotation.Nullable java.lang.String alias);
}

