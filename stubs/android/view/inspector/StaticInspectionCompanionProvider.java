/*
 * Copyright 2019 The Android Open Source Project
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


package android.view.inspector;


/**
 * An inspection companion provider that finds companions as inner classes or generated code.
 *
 * @see android.processor.view.inspector.PlatformInspectableProcessor
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StaticInspectionCompanionProvider implements android.view.inspector.InspectionCompanionProvider {

public StaticInspectionCompanionProvider() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param cls This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public <T> android.view.inspector.InspectionCompanion<T> provide(@androidx.annotation.NonNull java.lang.Class<T> cls) { throw new RuntimeException("Stub!"); }
}

