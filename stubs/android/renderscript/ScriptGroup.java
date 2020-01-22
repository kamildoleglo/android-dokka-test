/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.renderscript;


/**
 * A group of kernels that are executed
 * together with one execution call as if they were a single kernel
 * <p>
 * In addition to kernels, a script group may contain invocable functions as well.
 * A script group may take inputs and generate outputs, which are consumed and
 * produced by its member kernels.
 * Inside a script group, outputs from one kernel can be passed to another kernel as inputs.
 * The API disallows cyclic dependencies among kernels in a script group,
 * effectively making it a directed acyclic graph (DAG) of kernels.
 * <p>
 * Grouping kernels together allows for more efficient execution. For example,
 * runtime and compiler optimization can be applied to reduce computation and
 * communication overhead, and to make better use of the CPU and the GPU.
 * * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ScriptGroup extends android.renderscript.BaseObj {

ScriptGroup() { throw new RuntimeException("Stub!"); }

/**
 * Executes a script group
 *
 * @param inputs Values for inputs to the script group, in the order as the
 *        inputs are added via {@link android.renderscript.ScriptGroup.Builder2#addInput Builder2#addInput}.
 * @return Outputs of the script group as an array of objects, in the order
 *         as futures are passed to {@link android.renderscript.ScriptGroup.Builder2#create Builder2#create}.
 * @apiSince 23
 */

public java.lang.Object[] execute(java.lang.Object... inputs) { throw new RuntimeException("Stub!"); }

/**
 * Sets an input of the ScriptGroup. This specifies an
 * Allocation to be used for kernels that require an input
 * Allocation provided from outside of the ScriptGroup.
 *
 * @deprecated Set arguments to {@link #execute(java.lang.Object...)} instead.
 *
 * @param s The ID of the kernel where the allocation should be
 *          connected.
 * @param a The allocation to connect.
 * @apiSince 17
 * @deprecatedSince 23
 */

@Deprecated
public void setInput(android.renderscript.Script.KernelID s, android.renderscript.Allocation a) { throw new RuntimeException("Stub!"); }

/**
 * Sets an output of the ScriptGroup. This specifies an
 * Allocation to be used for the kernels that require an output
 * Allocation visible after the ScriptGroup is executed.
 *
 * @deprecated Use return value of {@link #execute(java.lang.Object...)} instead.
 *
 * @param s The ID of the kernel where the allocation should be
 *          connected.
 * @param a The allocation to connect.
 * @apiSince 17
 * @deprecatedSince 23
 */

@Deprecated
public void setOutput(android.renderscript.Script.KernelID s, android.renderscript.Allocation a) { throw new RuntimeException("Stub!"); }

/**
 * Execute the ScriptGroup.  This will run all the kernels in
 * the ScriptGroup.  No internal connection results will be visible
 * after execution of the ScriptGroup.
 *
 * @deprecated Use {@link #execute} instead.
 *
 * @apiSince 17
 * @deprecatedSince 23
 */

@Deprecated
public void execute() { throw new RuntimeException("Stub!"); }

/**
 * Destroy this ScriptGroup and all Closures in it
 * @apiSince 17
 */

public void destroy() { throw new RuntimeException("Stub!"); }
/**
 * Represents a binding of a value to a global variable in a
 * kernel or invocable function. Used in closure creation.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Binding {

/**
 * Returns a Binding object that binds value to field
 *
 * @param field the Script.FieldID of the global variable
 * @param value the value
 * @apiSince 23
 */

public Binding(android.renderscript.Script.FieldID field, java.lang.Object value) { throw new RuntimeException("Stub!"); }
}

/**
 * Helper class to build a ScriptGroup. A ScriptGroup is
 * created in two steps.
 * <p>
 * First, all kernels to be used by the ScriptGroup should be added.
 * <p>
 * Second, add connections between kernels. There are two types
 * of connections: kernel to kernel and kernel to field.
 * Kernel to kernel allows a kernel's output to be passed to
 * another kernel as input. Kernel to field allows the output of
 * one kernel to be bound as a script global. Kernel to kernel is
 * higher performance and should be used where possible.
 * <p>
 * A ScriptGroup must contain a single directed acyclic graph (DAG); it
 * cannot contain cycles. Currently, all kernels used in a ScriptGroup
 * must come from different Script objects. Additionally, all kernels
 * in a ScriptGroup must have at least one input, output, or internal
 * connection.
 * <p>
 * Once all connections are made, a call to {@link #create} will
 * return the ScriptGroup object.
 *
 * @deprecated Use {@link android.renderscript.ScriptGroup.Builder2 Builder2} instead.
 *
 * @apiSince 17
 * @deprecatedSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class Builder {

/**
 * Create a Builder for generating a ScriptGroup.
 *
 *
 * @param rs The RenderScript context.
 * @apiSince 17
 */

@Deprecated
public Builder(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * Adds a Kernel to the group.
 *
 *
 * @param k The kernel to add.
 *
 * @return Builder Returns this.
 * @apiSince 17
 * @deprecatedSince 23
 */

@Deprecated
public android.renderscript.ScriptGroup.Builder addKernel(android.renderscript.Script.KernelID k) { throw new RuntimeException("Stub!"); }

/**
 * Adds a connection to the group.
 *
 *
 * @param t The type of the connection. This is used to
 *          determine the kernel launch sizes on the source side
 *          of this connection.
 * @param from The source for the connection.
 * @param to The destination of the connection.
 *
 * @return Builder Returns this
 * @apiSince 17
 * @deprecatedSince 23
 */

@Deprecated
public android.renderscript.ScriptGroup.Builder addConnection(android.renderscript.Type t, android.renderscript.Script.KernelID from, android.renderscript.Script.FieldID to) { throw new RuntimeException("Stub!"); }

/**
 * Adds a connection to the group.
 *
 *
 * @param t The type of the connection. This is used to
 *          determine the kernel launch sizes for both sides of
 *          this connection.
 * @param from The source for the connection.
 * @param to The destination of the connection.
 *
 * @return Builder Returns this
 * @apiSince 17
 * @deprecatedSince 23
 */

@Deprecated
public android.renderscript.ScriptGroup.Builder addConnection(android.renderscript.Type t, android.renderscript.Script.KernelID from, android.renderscript.Script.KernelID to) { throw new RuntimeException("Stub!"); }

/**
 * Creates the Script group.
 *
 *
 * @return ScriptGroup The new ScriptGroup
 * @apiSince 17
 * @deprecatedSince 23
 */

@Deprecated
public android.renderscript.ScriptGroup create() { throw new RuntimeException("Stub!"); }
}

/**
 * The builder class for creating script groups
 * <p>
 * A script group is created using closures (see class {@link android.renderscript.ScriptGroup.Closure Closure}).
 * A closure is a function call to a kernel or
 * invocable function. Each function argument or global variable accessed inside
 * the function is bound to 1) a known value, 2) a script group input
 * (see class {@link android.renderscript.ScriptGroup.Input Input}), or 3) a
 * future (see class {@link android.renderscript.ScriptGroup.Future Future}).
 * A future is the output of a closure, either the return value of the
 * function or a global variable written by that function.
 * <p>
 * Closures are created using the {@link #addKernel} or {@link #addInvoke}
 * methods.
 * When a closure is created, futures from previously created closures
 * can be used as its inputs.
 * External script group inputs can be used as inputs to individual closures as well.
 * An external script group input is created using the {@link #addInput} method.
 * A script group is created by a call to the {@link #create} method, which
 * accepts an array of futures as the outputs for the script group.
 * <p>
 * Closures in a script group can be evaluated in any order as long as the
 * following conditions are met:
 * 1) a closure must be evaluated before any other closures that take its
 * futures as inputs;
 * 2) all closures added before an invoke closure must be evaluated
 * before it;
 * and 3) all closures added after an invoke closure must be evaluated after
 * it.
 * As a special case, the order that the closures are added is a legal
 * evaluation order. However, other evaluation orders are possible, including
 * concurrently evaluating independent closures.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder2 {

/**
 * Returns a Builder object
 *
 * @param rs the RenderScript context
 * @apiSince 23
 */

public Builder2(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * Adds a script group input
 *
 * @return a script group input, which can be used as an argument or a value to
 *     a global variable for creating closures
 * @apiSince 23
 */

public android.renderscript.ScriptGroup.Input addInput() { throw new RuntimeException("Stub!"); }

/**
 * Adds a closure for a kernel
 *
 * @param k Kernel ID for the kernel function
 * @param argsAndBindings arguments followed by bindings for global variables
 * @return a closure
 * @apiSince 23
 */

public android.renderscript.ScriptGroup.Closure addKernel(android.renderscript.Script.KernelID k, android.renderscript.Type returnType, java.lang.Object... argsAndBindings) { throw new RuntimeException("Stub!"); }

/**
 * Adds a closure for an invocable function
 *
 * @param invoke Invoke ID for the invocable function
 * @param argsAndBindings arguments followed by bindings for global variables
 * @return a closure
 * @apiSince 23
 */

public android.renderscript.ScriptGroup.Closure addInvoke(android.renderscript.Script.InvokeID invoke, java.lang.Object... argsAndBindings) { throw new RuntimeException("Stub!"); }

/**
 * Creates a script group
 *
 * @param name name for the script group. Legal names can only contain letters, digits,
 *        '-', or '_'. The name can be no longer than 100 characters.
 *        Try to use unique names, to avoid name conflicts and reduce
 *        the cost of group creation.
 * @param outputs futures intended as outputs of the script group
 * @return a script group
 * @apiSince 23
 */

public android.renderscript.ScriptGroup create(java.lang.String name, android.renderscript.ScriptGroup.Future... outputs) { throw new RuntimeException("Stub!"); }
}

/**
 * An opaque class for closures
 * <p>
 * A closure represents a function call to a kernel or invocable function,
 * combined with arguments and values for global variables. A closure is
 * created using the {@link android.renderscript.ScriptGroup.Builder2#addKernel} or
 * {@link android.renderscript.ScriptGroup.Builder2#addInvoke}
 * method.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Closure extends android.renderscript.BaseObj {

Closure() { throw new RuntimeException("Stub!"); }

/**
 * Destroys this Closure and the Allocation for its return value
 * @apiSince 23
 */

public void destroy() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Returns the future for the return value
 *
 * @return a future
 * @apiSince 23
 */

public android.renderscript.ScriptGroup.Future getReturn() { throw new RuntimeException("Stub!"); }

/**
 * Returns the future for a global variable
 *
 * @param field the field ID for the global variable
 * @return a future
 * @apiSince 23
 */

public android.renderscript.ScriptGroup.Future getGlobal(android.renderscript.Script.FieldID field) { throw new RuntimeException("Stub!"); }
}

/**
 * An opaque class for futures
 * <p>
 * A future represents an output of a closure, either the return value of
 * the function, or the value of a global variable written by the function.
 * A future is created by calling the {@link android.renderscript.ScriptGroup.Closure#getReturn Closure#getReturn}  or
 * {@link android.renderscript.ScriptGroup.Closure#getGlobal Closure#getGlobal} method.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Future {

Future() { throw new RuntimeException("Stub!"); }
}

/**
 * An opaque class for script group inputs
 * <p>
 * Created by calling the {@link android.renderscript.ScriptGroup.Builder2#addInput Builder2#addInput} method. The value
 * is assigned in {@link android.renderscript.ScriptGroup#execute(java.lang.Object...) ScriptGroup#execute(Object...)} method as
 * one of its arguments. Arguments to the execute method should be in
 * the same order as intputs are added using the addInput method.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Input {

Input() { throw new RuntimeException("Stub!"); }
}

}

