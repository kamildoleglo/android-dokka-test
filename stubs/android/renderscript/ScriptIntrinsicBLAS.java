/*
 * Copyright (C) 2015 The Android Open Source Project
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
 *
 * ScriptIntrinsicBLAS class provides high performance RenderScript APIs to BLAS.
 *
 * The BLAS (Basic Linear Algebra Subprograms) are routines that provide standard
 * building blocks for performing basic vector and matrix operations.
 *
 * For detailed description of BLAS, please refer to http://www.netlib.org/blas/
 *
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ScriptIntrinsicBLAS extends android.renderscript.ScriptIntrinsic {

private ScriptIntrinsicBLAS() { throw new RuntimeException("Stub!"); }

/**
 * Create an intrinsic to access BLAS subroutines.
 *
 * @param rs The RenderScript context
 * @return ScriptIntrinsicBLAS
 * @apiSince 23
 */

public static android.renderscript.ScriptIntrinsicBLAS create(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * SGEMV performs one of the matrix-vector operations
 * y := alpha*A*x + beta*y   or   y := alpha*A**T*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/db/d58/sgemv_8f.html
 *
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void SGEMV(int TransA, float alpha, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX, float beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * DGEMV performs one of the matrix-vector operations
 * y := alpha*A*x + beta*y   or   y := alpha*A**T*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/dc/da8/dgemv_8f.html
 *
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void DGEMV(int TransA, double alpha, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX, double beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * CGEMV performs one of the matrix-vector operations
 * y := alpha*A*x + beta*y   or   y := alpha*A**T*x + beta*y   or   y := alpha*A**H*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/d4/d8a/cgemv_8f.html
 *
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void CGEMV(int TransA, android.renderscript.Float2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX, android.renderscript.Float2 beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * ZGEMV performs one of the matrix-vector operations
 * y := alpha*A*x + beta*y   or   y := alpha*A**T*x + beta*y   or   y := alpha*A**H*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/db/d40/zgemv_8f.html
 *
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void ZGEMV(int TransA, android.renderscript.Double2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX, android.renderscript.Double2 beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * SGBMV performs one of the matrix-vector operations
 * y := alpha*A*x + beta*y   or   y := alpha*A**T*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/d6/d46/sgbmv_8f.html
 *
 * Note: For a M*N matrix, the input Allocation should also be of size M*N (dimY = M, dimX = N),
 *       but only the region M*(KL+KU+1) will be referenced. The following subroutine can is an
 *       example showing how to convert the original matrix 'a' to row-based band matrix 'b'.
 *           for i in range(0, m):
 *              for j in range(max(0, i-kl), min(i+ku+1, n)):
 *                  b[i, j-i+kl] = a[i, j]
 *
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param KL The number of sub-diagonals of the matrix A.
 * @param KU The number of super-diagonals of the matrix A.
 * @param alpha The scalar alpha.
 * @param A The input allocation contains the band matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void SGBMV(int TransA, int KL, int KU, float alpha, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX, float beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * DGBMV performs one of the matrix-vector operations
 * y := alpha*A*x + beta*y   or   y := alpha*A**T*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/d2/d3f/dgbmv_8f.html
 *
 * Note: For a M*N matrix, the input Allocation should also be of size M*N (dimY = M, dimX = N),
 *       but only the region M*(KL+KU+1) will be referenced. The following subroutine can is an
 *       example showing how to convert the original matrix 'a' to row-based band matrix 'b'.
 *           for i in range(0, m):
 *              for j in range(max(0, i-kl), min(i+ku+1, n)):
 *                  b[i, j-i+kl] = a[i, j]
 *
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param KL The number of sub-diagonals of the matrix A.
 * @param KU The number of super-diagonals of the matrix A.
 * @param alpha The scalar alpha.
 * @param A The input allocation contains the band matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void DGBMV(int TransA, int KL, int KU, double alpha, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX, double beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * CGBMV performs one of the matrix-vector operations
 * y := alpha*A*x + beta*y   or   y := alpha*A**T*x + beta*y   or   y := alpha*A**H*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/d0/d75/cgbmv_8f.html
 *
 * Note: For a M*N matrix, the input Allocation should also be of size M*N (dimY = M, dimX = N),
 *       but only the region M*(KL+KU+1) will be referenced. The following subroutine can is an
 *       example showing how to convert the original matrix 'a' to row-based band matrix 'b'.
 *           for i in range(0, m):
 *              for j in range(max(0, i-kl), min(i+ku+1, n)):
 *                  b[i, j-i+kl] = a[i, j]
 *
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param KL The number of sub-diagonals of the matrix A.
 * @param KU The number of super-diagonals of the matrix A.
 * @param alpha The scalar alpha.
 * @param A The input allocation contains the band matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void CGBMV(int TransA, int KL, int KU, android.renderscript.Float2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX, android.renderscript.Float2 beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * ZGBMV performs one of the matrix-vector operations
 * y := alpha*A*x + beta*y   or   y := alpha*A**T*x + beta*y   or   y := alpha*A**H*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/d9/d46/zgbmv_8f.html
 *
 * Note: For a M*N matrix, the input Allocation should also be of size M*N (dimY = M, dimX = N),
 *       but only the region M*(KL+KU+1) will be referenced. The following subroutine can is an
 *       example showing how to convert the original matrix 'a' to row-based band matrix 'b'.
 *           for i in range(0, m):
 *              for j in range(max(0, i-kl), min(i+ku+1, n)):
 *                  b[i, j-i+kl] = a[i, j]
 *
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param KL The number of sub-diagonals of the matrix A.
 * @param KU The number of super-diagonals of the matrix A.
 * @param alpha The scalar alpha.
 * @param A The input allocation contains the band matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void ZGBMV(int TransA, int KL, int KU, android.renderscript.Double2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX, android.renderscript.Double2 beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * STRMV performs one of the matrix-vector operations
 * x := A*x   or   x := A**T*x
 *
 * Details: http://www.netlib.org/lapack/explore-html/de/d45/strmv_8f.html
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void STRMV(int Uplo, int TransA, int Diag, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * DTRMV performs one of the matrix-vector operations
 * x := A*x   or   x := A**T*x
 *
 * Details: http://www.netlib.org/lapack/explore-html/dc/d7e/dtrmv_8f.html
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void DTRMV(int Uplo, int TransA, int Diag, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * CTRMV performs one of the matrix-vector operations
 * x := A*x   or   x := A**T*x   or   x := A**H*x
 *
 * Details: http://www.netlib.org/lapack/explore-html/df/d78/ctrmv_8f.html
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void CTRMV(int Uplo, int TransA, int Diag, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * ZTRMV performs one of the matrix-vector operations
 * x := A*x   or   x := A**T*x   or   x := A**H*x
 *
 * Details: http://www.netlib.org/lapack/explore-html/d0/dd1/ztrmv_8f.html
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void ZTRMV(int Uplo, int TransA, int Diag, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * STBMV performs one of the matrix-vector operations
 * x := A*x   or   x := A**T*x
 *
 * Details: http://www.netlib.org/lapack/explore-html/d6/d7d/stbmv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should also be of size N*N (dimY = N, dimX = N),
 *       but only the region N*(K+1) will be referenced. The following subroutine can is an
 *       example showing how to convert a UPPER trianglar matrix 'a' to row-based band matrix 'b'.
 *           for i in range(0, n):
 *              for j in range(i, min(i+k+1, n)):
 *                  b[i, j-i] = a[i, j]
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param K The number of off-diagonals of the matrix A
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void STBMV(int Uplo, int TransA, int Diag, int K, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * DTBMV performs one of the matrix-vector operations
 * x := A*x   or   x := A**T*x
 *
 * Details: http://www.netlib.org/lapack/explore-html/df/d29/dtbmv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should also be of size N*N (dimY = N, dimX = N),
 *       but only the region N*(K+1) will be referenced. The following subroutine can is an
 *       example showing how to convert a UPPER trianglar matrix 'a' to row-based band matrix 'b'.
 *           for i in range(0, n):
 *              for j in range(i, min(i+k+1, n)):
 *                  b[i, j-i] = a[i, j]
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param K The number of off-diagonals of the matrix A
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void DTBMV(int Uplo, int TransA, int Diag, int K, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * CTBMV performs one of the matrix-vector operations
 * x := A*x   or   x := A**T*x   or   x := A**H*x
 *
 * Details: http://www.netlib.org/lapack/explore-html/d3/dcd/ctbmv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should also be of size N*N (dimY = N, dimX = N),
 *       but only the region N*(K+1) will be referenced. The following subroutine can is an
 *       example showing how to convert a UPPER trianglar matrix 'a' to row-based band matrix 'b'.
 *           for i in range(0, n):
 *              for j in range(i, min(i+k+1, n)):
 *                  b[i, j-i] = a[i, j]
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param K The number of off-diagonals of the matrix A
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void CTBMV(int Uplo, int TransA, int Diag, int K, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * ZTBMV performs one of the matrix-vector operations
 * x := A*x   or   x := A**T*x   or   x := A**H*x
 *
 * Details: http://www.netlib.org/lapack/explore-html/d3/d39/ztbmv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should also be of size N*N (dimY = N, dimX = N),
 *       but only the region N*(K+1) will be referenced. The following subroutine can is an
 *       example showing how to convert a UPPER trianglar matrix 'a' to row-based band matrix 'b'.
 *           for i in range(0, n):
 *              for j in range(i, min(i+k+1, n)):
 *                  b[i, j-i] = a[i, j]
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param K The number of off-diagonals of the matrix A
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void ZTBMV(int Uplo, int TransA, int Diag, int K, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * STPMV performs one of the matrix-vector operations
 * x := A*x   or   x := A**T*x
 *
 * Details: http://www.netlib.org/lapack/explore-html/db/db1/stpmv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param Ap The input allocation contains packed matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void STPMV(int Uplo, int TransA, int Diag, android.renderscript.Allocation Ap, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * DTPMV performs one of the matrix-vector operations
 * x := A*x   or   x := A**T*x
 *
 * Details: http://www.netlib.org/lapack/explore-html/dc/dcd/dtpmv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param Ap The input allocation contains packed matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void DTPMV(int Uplo, int TransA, int Diag, android.renderscript.Allocation Ap, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * CTPMV performs one of the matrix-vector operations
 * x := A*x   or   x := A**T*x   or   x := A**H*x
 *
 * Details: http://www.netlib.org/lapack/explore-html/d4/dbb/ctpmv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param Ap The input allocation contains packed matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void CTPMV(int Uplo, int TransA, int Diag, android.renderscript.Allocation Ap, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * ZTPMV performs one of the matrix-vector operations
 * x := A*x   or   x := A**T*x   or   x := A**H*x
 *
 * Details: http://www.netlib.org/lapack/explore-html/d2/d9e/ztpmv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param Ap The input allocation contains packed matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void ZTPMV(int Uplo, int TransA, int Diag, android.renderscript.Allocation Ap, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * STRSV solves one of the systems of equations
 * A*x = b   or   A**T*x = b
 *
 * Details: http://www.netlib.org/lapack/explore-html/d0/d2a/strsv_8f.html
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void STRSV(int Uplo, int TransA, int Diag, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * DTRSV solves one of the systems of equations
 * A*x = b   or   A**T*x = b
 *
 * Details: http://www.netlib.org/lapack/explore-html/d6/d96/dtrsv_8f.html
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void DTRSV(int Uplo, int TransA, int Diag, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * CTRSV solves one of the systems of equations
 * A*x = b   or   A**T*x = b   or   A**H*x = b
 *
 * Details: http://www.netlib.org/lapack/explore-html/d4/dc8/ctrsv_8f.html
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void CTRSV(int Uplo, int TransA, int Diag, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * ZTRSV solves one of the systems of equations
 * A*x = b   or   A**T*x = b   or   A**H*x = b
 *
 * Details: http://www.netlib.org/lapack/explore-html/d1/d2f/ztrsv_8f.html
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void ZTRSV(int Uplo, int TransA, int Diag, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * STBSV solves one of the systems of equations
 * A*x = b   or   A**T*x = b
 *
 * Details: http://www.netlib.org/lapack/explore-html/d0/d1f/stbsv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should also be of size N*N (dimY = N, dimX = N),
 *       but only the region N*(K+1) will be referenced. The following subroutine can is an
 *       example showing how to convert a UPPER trianglar matrix 'a' to row-based band matrix 'b'.
 *           for i in range(0, n):
 *              for j in range(i, min(i+k+1, n)):
 *                  b[i, j-i] = a[i, j]
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param K The number of off-diagonals of the matrix A
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void STBSV(int Uplo, int TransA, int Diag, int K, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * DTBSV solves one of the systems of equations
 * A*x = b   or   A**T*x = b
 *
 * Details: http://www.netlib.org/lapack/explore-html/d4/dcf/dtbsv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should also be of size N*N (dimY = N, dimX = N),
 *       but only the region N*(K+1) will be referenced. The following subroutine can is an
 *       example showing how to convert a UPPER trianglar matrix 'a' to row-based band matrix 'b'.
 *           for i in range(0, n):
 *              for j in range(i, min(i+k+1, n)):
 *                  b[i, j-i] = a[i, j]
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param K The number of off-diagonals of the matrix A
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void DTBSV(int Uplo, int TransA, int Diag, int K, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * CTBSV solves one of the systems of equations
 * A*x = b   or   A**T*x = b   or   A**H*x = b
 *
 * Details: http://www.netlib.org/lapack/explore-html/d9/d5f/ctbsv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should also be of size N*N (dimY = N, dimX = N),
 *       but only the region N*(K+1) will be referenced. The following subroutine can is an
 *       example showing how to convert a UPPER trianglar matrix 'a' to row-based band matrix 'b'.
 *           for i in range(0, n):
 *              for j in range(i, min(i+k+1, n)):
 *                  b[i, j-i] = a[i, j]
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param K The number of off-diagonals of the matrix A
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void CTBSV(int Uplo, int TransA, int Diag, int K, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * ZTBSV solves one of the systems of equations
 * A*x = b   or   A**T*x = b   or   A**H*x = b
 *
 * Details: http://www.netlib.org/lapack/explore-html/d4/d5a/ztbsv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should also be of size N*N (dimY = N, dimX = N),
 *       but only the region N*(K+1) will be referenced. The following subroutine can is an
 *       example showing how to convert a UPPER trianglar matrix 'a' to row-based band matrix 'b'.
 *           for i in range(0, n):
 *              for j in range(i, min(i+k+1, n)):
 *                  b[i, j-i] = a[i, j]
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param K The number of off-diagonals of the matrix A
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void ZTBSV(int Uplo, int TransA, int Diag, int K, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * STPSV solves one of the systems of equations
 * A*x = b   or   A**T*x = b
 *
 * Details: http://www.netlib.org/lapack/explore-html/d0/d7c/stpsv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param Ap The input allocation contains packed matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void STPSV(int Uplo, int TransA, int Diag, android.renderscript.Allocation Ap, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * DTPSV solves one of the systems of equations
 * A*x = b   or   A**T*x = b
 *
 * Details: http://www.netlib.org/lapack/explore-html/d9/d84/dtpsv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param Ap The input allocation contains packed matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void DTPSV(int Uplo, int TransA, int Diag, android.renderscript.Allocation Ap, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * CTPSV solves one of the systems of equations
 * A*x = b   or   A**T*x = b   or   A**H*x = b
 *
 * Details: http://www.netlib.org/lapack/explore-html/d8/d56/ctpsv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param Ap The input allocation contains packed matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void CTPSV(int Uplo, int TransA, int Diag, android.renderscript.Allocation Ap, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * ZTPSV solves one of the systems of equations
 * A*x = b   or   A**T*x = b   or   A**H*x = b
 *
 * Details: http://www.netlib.org/lapack/explore-html/da/d57/ztpsv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the matrix is an upper or lower triangular matrix.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param Ap The input allocation contains packed matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @apiSince 23
 */

public void ZTPSV(int Uplo, int TransA, int Diag, android.renderscript.Allocation Ap, android.renderscript.Allocation X, int incX) { throw new RuntimeException("Stub!"); }

/**
 * SSYMV performs the matrix-vector operation
 * y := alpha*A*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/d2/d94/ssymv_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void SSYMV(int Uplo, float alpha, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX, float beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * SSBMV performs the matrix-vector operation
 * y := alpha*A*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/d3/da1/ssbmv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should also be of size N*N (dimY = N, dimX = N),
 *       but only the region N*(K+1) will be referenced. The following subroutine can is an
 *       example showing how to convert a UPPER trianglar matrix 'a' to row-based band matrix 'b'.
 *           for i in range(0, n):
 *              for j in range(i, min(i+k+1, n)):
 *                  b[i, j-i] = a[i, j]
 *
 * @param Uplo Specifies whether the upper or lower triangular part of the band matrix A is being supplied.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param K The number of off-diagonals of the matrix A
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void SSBMV(int Uplo, int K, float alpha, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX, float beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * SSPMV performs the matrix-vector operation
 * y := alpha*A*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/d8/d68/sspmv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the upper or lower triangular part of the matrix A is supplied in packed form.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param Ap The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void SSPMV(int Uplo, float alpha, android.renderscript.Allocation Ap, android.renderscript.Allocation X, int incX, float beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * SGER performs the rank 1 operation
 * A := alpha*x*y**T + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/db/d5c/sger_8f.html
 *
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @apiSince 23
 */

public void SGER(float alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Y, int incY, android.renderscript.Allocation A) { throw new RuntimeException("Stub!"); }

/**
 * SSYR performs the rank 1 operation
 * A := alpha*x*x**T + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/d6/dac/ssyr_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @apiSince 23
 */

public void SSYR(int Uplo, float alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation A) { throw new RuntimeException("Stub!"); }

/**
 * SSPR performs the rank 1 operation
 * A := alpha*x*x**T + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/d2/d9b/sspr_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be supplied in the packed form.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Ap The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @apiSince 23
 */

public void SSPR(int Uplo, float alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Ap) { throw new RuntimeException("Stub!"); }

/**
 * SSYR2 performs the symmetric rank 2 operation
 * A := alpha*x*y**T + alpha*y*x**T + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/db/d99/ssyr2_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @apiSince 23
 */

public void SSYR2(int Uplo, float alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Y, int incY, android.renderscript.Allocation A) { throw new RuntimeException("Stub!"); }

/**
 * SSPR2 performs the symmetric rank 2 operation
 * A := alpha*x*y**T + alpha*y*x**T + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/db/d3e/sspr2_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be supplied in the packed form.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @param Ap The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @apiSince 23
 */

public void SSPR2(int Uplo, float alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Y, int incY, android.renderscript.Allocation Ap) { throw new RuntimeException("Stub!"); }

/**
 * DSYMV performs the matrix-vector operation
 * y := alpha*A*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/d8/dbe/dsymv_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void DSYMV(int Uplo, double alpha, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX, double beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * DSBMV performs the matrix-vector operation
 * y := alpha*A*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/d8/d1e/dsbmv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should also be of size N*N (dimY = N, dimX = N),
 *       but only the region N*(K+1) will be referenced. The following subroutine can is an
 *       example showing how to convert a UPPER trianglar matrix 'a' to row-based band matrix 'b'.
 *           for i in range(0, n):
 *              for j in range(i, min(i+k+1, n)):
 *                  b[i, j-i] = a[i, j]
 *
 * @param Uplo Specifies whether the upper or lower triangular part of the band matrix A is being supplied.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param K The number of off-diagonals of the matrix A
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void DSBMV(int Uplo, int K, double alpha, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX, double beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * DSPMV performs the matrix-vector operation
 * y := alpha*A*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/d4/d85/dspmv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the upper or lower triangular part of the matrix A is supplied in packed form.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param Ap The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void DSPMV(int Uplo, double alpha, android.renderscript.Allocation Ap, android.renderscript.Allocation X, int incX, double beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * DGER performs the rank 1 operation
 * A := alpha*x*y**T + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/dc/da8/dger_8f.html
 *
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @apiSince 23
 */

public void DGER(double alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Y, int incY, android.renderscript.Allocation A) { throw new RuntimeException("Stub!"); }

/**
 * DSYR performs the rank 1 operation
 * A := alpha*x*x**T + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/d3/d60/dsyr_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @apiSince 23
 */

public void DSYR(int Uplo, double alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation A) { throw new RuntimeException("Stub!"); }

/**
 * DSPR performs the rank 1 operation
 * A := alpha*x*x**T + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/dd/dba/dspr_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be supplied in the packed form.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Ap The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @apiSince 23
 */

public void DSPR(int Uplo, double alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Ap) { throw new RuntimeException("Stub!"); }

/**
 * DSYR2 performs the symmetric rank 2 operation
 * A := alpha*x*y**T + alpha*y*x**T + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/de/d41/dsyr2_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @apiSince 23
 */

public void DSYR2(int Uplo, double alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Y, int incY, android.renderscript.Allocation A) { throw new RuntimeException("Stub!"); }

/**
 * DSPR2 performs the symmetric rank 2 operation
 * A := alpha*x*y**T + alpha*y*x**T + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/dd/d9e/dspr2_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be supplied in the packed form.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @param Ap The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @apiSince 23
 */

public void DSPR2(int Uplo, double alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Y, int incY, android.renderscript.Allocation Ap) { throw new RuntimeException("Stub!"); }

/**
 * CHEMV performs the matrix-vector operation
 * y := alpha*A*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/d7/d51/chemv_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void CHEMV(int Uplo, android.renderscript.Float2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX, android.renderscript.Float2 beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * CHBMV performs the matrix-vector operation
 * y := alpha*A*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/db/dc2/chbmv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should also be of size N*N (dimY = N, dimX = N),
 *       but only the region N*(K+1) will be referenced. The following subroutine can is an
 *       example showing how to convert a UPPER trianglar matrix 'a' to row-based band matrix 'b'.
 *           for i in range(0, n):
 *              for j in range(i, min(i+k+1, n)):
 *                  b[i, j-i] = a[i, j]
 *
 * @param Uplo Specifies whether the upper or lower triangular part of the band matrix A is being supplied.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param K The number of off-diagonals of the matrix A
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void CHBMV(int Uplo, int K, android.renderscript.Float2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX, android.renderscript.Float2 beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * CHPMV performs the matrix-vector operation
 * y := alpha*A*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/d2/d06/chpmv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the upper or lower triangular part of the matrix A is supplied in packed form.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param Ap The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void CHPMV(int Uplo, android.renderscript.Float2 alpha, android.renderscript.Allocation Ap, android.renderscript.Allocation X, int incX, android.renderscript.Float2 beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * CGERU performs the rank 1 operation
 * A := alpha*x*y**T + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/db/d5f/cgeru_8f.html
 *
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @apiSince 23
 */

public void CGERU(android.renderscript.Float2 alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Y, int incY, android.renderscript.Allocation A) { throw new RuntimeException("Stub!"); }

/**
 * CGERC performs the rank 1 operation
 * A := alpha*x*y**H + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/dd/d84/cgerc_8f.html
 *
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @apiSince 23
 */

public void CGERC(android.renderscript.Float2 alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Y, int incY, android.renderscript.Allocation A) { throw new RuntimeException("Stub!"); }

/**
 * CHER performs the rank 1 operation
 * A := alpha*x*x**H + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/d3/d6d/cher_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @apiSince 23
 */

public void CHER(int Uplo, float alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation A) { throw new RuntimeException("Stub!"); }

/**
 * CHPR performs the rank 1 operation
 * A := alpha*x*x**H + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/db/dcd/chpr_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be supplied in the packed form.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Ap The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @apiSince 23
 */

public void CHPR(int Uplo, float alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Ap) { throw new RuntimeException("Stub!"); }

/**
 * CHER2 performs the symmetric rank 2 operation
 * A := alpha*x*y**H + alpha*y*x**H + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/db/d87/cher2_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @apiSince 23
 */

public void CHER2(int Uplo, android.renderscript.Float2 alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Y, int incY, android.renderscript.Allocation A) { throw new RuntimeException("Stub!"); }

/**
 * CHPR2 performs the symmetric rank 2 operation
 * A := alpha*x*y**H + alpha*y*x**H + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/d6/d44/chpr2_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be supplied in the packed form.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @param Ap The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @apiSince 23
 */

public void CHPR2(int Uplo, android.renderscript.Float2 alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Y, int incY, android.renderscript.Allocation Ap) { throw new RuntimeException("Stub!"); }

/**
 * ZHEMV performs the matrix-vector operation
 * y := alpha*A*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/d0/ddd/zhemv_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void ZHEMV(int Uplo, android.renderscript.Double2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX, android.renderscript.Double2 beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * ZHBMV performs the matrix-vector operation
 * y := alpha*A*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/d3/d1a/zhbmv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should also be of size N*N (dimY = N, dimX = N),
 *       but only the region N*(K+1) will be referenced. The following subroutine can is an
 *       example showing how to convert a UPPER trianglar matrix 'a' to row-based band matrix 'b'.
 *           for i in range(0, n):
 *              for j in range(i, min(i+k+1, n)):
 *                  b[i, j-i] = a[i, j]
 *
 * @param Uplo Specifies whether the upper or lower triangular part of the band matrix A is being supplied.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param K The number of off-diagonals of the matrix A
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void ZHBMV(int Uplo, int K, android.renderscript.Double2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation X, int incX, android.renderscript.Double2 beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * ZHPMV performs the matrix-vector operation
 * y := alpha*A*x + beta*y
 *
 * Details: http://www.netlib.org/lapack/explore-html/d0/d60/zhpmv_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the upper or lower triangular part of the matrix A is supplied in packed form.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param Ap The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param beta The scalar beta.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @apiSince 23
 */

public void ZHPMV(int Uplo, android.renderscript.Double2 alpha, android.renderscript.Allocation Ap, android.renderscript.Allocation X, int incX, android.renderscript.Double2 beta, android.renderscript.Allocation Y, int incY) { throw new RuntimeException("Stub!"); }

/**
 * ZGERU performs the rank 1 operation
 * A := alpha*x*y**T + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/d7/d12/zgeru_8f.html
 *
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @apiSince 23
 */

public void ZGERU(android.renderscript.Double2 alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Y, int incY, android.renderscript.Allocation A) { throw new RuntimeException("Stub!"); }

/**
 * ZGERC performs the rank 1 operation
 * A := alpha*x*y**H + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/d3/dad/zgerc_8f.html
 *
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @apiSince 23
 */

public void ZGERC(android.renderscript.Double2 alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Y, int incY, android.renderscript.Allocation A) { throw new RuntimeException("Stub!"); }

/**
 * ZHER performs the rank 1 operation
 * A := alpha*x*x**H + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/de/d0e/zher_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @apiSince 23
 */

public void ZHER(int Uplo, double alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation A) { throw new RuntimeException("Stub!"); }

/**
 * ZHPR performs the rank 1 operation
 * A := alpha*x*x**H + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/de/de1/zhpr_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be supplied in the packed form.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Ap The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @apiSince 23
 */

public void ZHPR(int Uplo, double alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Ap) { throw new RuntimeException("Stub!"); }

/**
 * ZHER2 performs the symmetric rank 2 operation
 * A := alpha*x*y**H + alpha*y*x**H + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/da/d8a/zher2_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @apiSince 23
 */

public void ZHER2(int Uplo, android.renderscript.Double2 alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Y, int incY, android.renderscript.Allocation A) { throw new RuntimeException("Stub!"); }

/**
 * ZHPR2 performs the symmetric rank 2 operation
 * A := alpha*x*y**H + alpha*y*x**H + A
 *
 * Details: http://www.netlib.org/lapack/explore-html/d5/d52/zhpr2_8f.html
 *
 * Note: For a N*N matrix, the input Allocation should be a 1D allocation of size dimX = N*(N+1)/2,
 *       The following subroutine can is an example showing how to convert a UPPER trianglar matrix
 *       'a' to packed matrix 'b'.
 *           k = 0
 *           for i in range(0, n):
 *              for j in range(i, n):
 *                  b[k++] = a[i, j]
 *
 * @param Uplo Specifies whether the upper or lower triangular part is to be supplied in the packed form.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param X The input allocation contains vector x, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incX The increment for the elements of vector x, must be larger than zero.
 * @param Y The input allocation contains vector y, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param incY The increment for the elements of vector y, must be larger than zero.
 * @param Ap The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @apiSince 23
 */

public void ZHPR2(int Uplo, android.renderscript.Double2 alpha, android.renderscript.Allocation X, int incX, android.renderscript.Allocation Y, int incY, android.renderscript.Allocation Ap) { throw new RuntimeException("Stub!"); }

/**
 * SGEMM performs one of the matrix-matrix operations
 * C := alpha*op(A)*op(B) + beta*C   where op(X) is one of op(X) = X  or  op(X) = X**T
 *
 * Details: http://www.netlib.org/lapack/explore-html/d4/de2/sgemm_8f.html
 *
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param TransB The type of transpose applied to matrix B.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @apiSince 23
 */

public void SGEMM(int TransA, int TransB, float alpha, android.renderscript.Allocation A, android.renderscript.Allocation B, float beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * DGEMM performs one of the matrix-matrix operations
 * C := alpha*op(A)*op(B) + beta*C   where op(X) is one of op(X) = X  or  op(X) = X**T
 *
 * Details: http://www.netlib.org/lapack/explore-html/d7/d2b/dgemm_8f.html
 *
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param TransB The type of transpose applied to matrix B.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @apiSince 23
 */

public void DGEMM(int TransA, int TransB, double alpha, android.renderscript.Allocation A, android.renderscript.Allocation B, double beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * CGEMM performs one of the matrix-matrix operations
 * C := alpha*op(A)*op(B) + beta*C   where op(X) is one of op(X) = X  or  op(X) = X**T  or  op(X) = X**H
 *
 * Details: http://www.netlib.org/lapack/explore-html/d6/d5b/cgemm_8f.html
 *
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param TransB The type of transpose applied to matrix B.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @apiSince 23
 */

public void CGEMM(int TransA, int TransB, android.renderscript.Float2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation B, android.renderscript.Float2 beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * ZGEMM performs one of the matrix-matrix operations
 * C := alpha*op(A)*op(B) + beta*C   where op(X) is one of op(X) = X  or  op(X) = X**T  or  op(X) = X**H
 *
 * Details: http://www.netlib.org/lapack/explore-html/d7/d76/zgemm_8f.html
 *
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param TransB The type of transpose applied to matrix B.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @apiSince 23
 */

public void ZGEMM(int TransA, int TransB, android.renderscript.Double2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation B, android.renderscript.Double2 beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * SSYMM performs one of the matrix-matrix operations
 * C := alpha*A*B + beta*C   or   C := alpha*B*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/d7/d42/ssymm_8f.html
 *
 * @param Side Specifies whether the symmetric matrix A appears on the left or right.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#LEFT}, or {@link android.renderscript.ScriptIntrinsicBLAS#RIGHT}
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @apiSince 23
 */

public void SSYMM(int Side, int Uplo, float alpha, android.renderscript.Allocation A, android.renderscript.Allocation B, float beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * DSYMM performs one of the matrix-matrix operations
 * C := alpha*A*B + beta*C   or   C := alpha*B*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/d8/db0/dsymm_8f.html
 *
 * @param Side Specifies whether the symmetric matrix A appears on the left or right.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#LEFT}, or {@link android.renderscript.ScriptIntrinsicBLAS#RIGHT}
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @apiSince 23
 */

public void DSYMM(int Side, int Uplo, double alpha, android.renderscript.Allocation A, android.renderscript.Allocation B, double beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * CSYMM performs one of the matrix-matrix operations
 * C := alpha*A*B + beta*C   or   C := alpha*B*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/db/d59/csymm_8f.html
 *
 * @param Side Specifies whether the symmetric matrix A appears on the left or right.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#LEFT}, or {@link android.renderscript.ScriptIntrinsicBLAS#RIGHT}
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @apiSince 23
 */

public void CSYMM(int Side, int Uplo, android.renderscript.Float2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation B, android.renderscript.Float2 beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * ZSYMM performs one of the matrix-matrix operations
 * C := alpha*A*B + beta*C   or   C := alpha*B*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/df/d51/zsymm_8f.html
 *
 * @param Side Specifies whether the symmetric matrix A appears on the left or right.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#LEFT}, or {@link android.renderscript.ScriptIntrinsicBLAS#RIGHT}
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @apiSince 23
 */

public void ZSYMM(int Side, int Uplo, android.renderscript.Double2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation B, android.renderscript.Double2 beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * SSYRK performs one of the symmetric rank k operations
 * C := alpha*A*A**T + beta*C   or   C := alpha*A**T*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/d0/d40/ssyrk_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part of C is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param Trans The type of transpose applied to the operation.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @apiSince 23
 */

public void SSYRK(int Uplo, int Trans, float alpha, android.renderscript.Allocation A, float beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * DSYRK performs one of the symmetric rank k operations
 * C := alpha*A*A**T + beta*C   or   C := alpha*A**T*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/dc/d05/dsyrk_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part of C is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param Trans The type of transpose applied to the operation.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @apiSince 23
 */

public void DSYRK(int Uplo, int Trans, double alpha, android.renderscript.Allocation A, double beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * CSYRK performs one of the symmetric rank k operations
 * C := alpha*A*A**T + beta*C   or   C := alpha*A**T*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/d3/d6a/csyrk_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part of C is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param Trans The type of transpose applied to the operation.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @apiSince 23
 */

public void CSYRK(int Uplo, int Trans, android.renderscript.Float2 alpha, android.renderscript.Allocation A, android.renderscript.Float2 beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * ZSYRK performs one of the symmetric rank k operations
 * C := alpha*A*A**T + beta*C   or   C := alpha*A**T*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/de/d54/zsyrk_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part of C is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param Trans The type of transpose applied to the operation.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @apiSince 23
 */

public void ZSYRK(int Uplo, int Trans, android.renderscript.Double2 alpha, android.renderscript.Allocation A, android.renderscript.Double2 beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * SSYR2K performs one of the symmetric rank 2k operations
 * C := alpha*A*B**T + alpha*B*A**T + beta*C   or   C := alpha*A**T*B + alpha*B**T*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/df/d3d/ssyr2k_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part of C is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param Trans The type of transpose applied to the operation.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @apiSince 23
 */

public void SSYR2K(int Uplo, int Trans, float alpha, android.renderscript.Allocation A, android.renderscript.Allocation B, float beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * DSYR2K performs one of the symmetric rank 2k operations
 * C := alpha*A*B**T + alpha*B*A**T + beta*C   or   C := alpha*A**T*B + alpha*B**T*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/d1/dec/dsyr2k_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part of C is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param Trans The type of transpose applied to the operation.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @apiSince 23
 */

public void DSYR2K(int Uplo, int Trans, double alpha, android.renderscript.Allocation A, android.renderscript.Allocation B, double beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * CSYR2K performs one of the symmetric rank 2k operations
 * C := alpha*A*B**T + alpha*B*A**T + beta*C   or   C := alpha*A**T*B + alpha*B**T*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/de/d7e/csyr2k_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part of C is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param Trans The type of transpose applied to the operation.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @apiSince 23
 */

public void CSYR2K(int Uplo, int Trans, android.renderscript.Float2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation B, android.renderscript.Float2 beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * ZSYR2K performs one of the symmetric rank 2k operations
 * C := alpha*A*B**T + alpha*B*A**T + beta*C   or   C := alpha*A**T*B + alpha*B**T*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/df/d20/zsyr2k_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part of C is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param Trans The type of transpose applied to the operation.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @apiSince 23
 */

public void ZSYR2K(int Uplo, int Trans, android.renderscript.Double2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation B, android.renderscript.Double2 beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * STRMM performs one of the matrix-matrix operations
 * B := alpha*op(A)*B   or   B := alpha*B*op(A)
 * op(A) is one of  op(A) = A  or  op(A) = A**T
 *
 * Details: http://www.netlib.org/lapack/explore-html/df/d01/strmm_8f.html
 *
 * @param Side Specifies whether the symmetric matrix A appears on the left or right.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#LEFT}, or {@link android.renderscript.ScriptIntrinsicBLAS#RIGHT}
 * @param Uplo Specifies whether matrix A is upper or lower triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @apiSince 23
 */

public void STRMM(int Side, int Uplo, int TransA, int Diag, float alpha, android.renderscript.Allocation A, android.renderscript.Allocation B) { throw new RuntimeException("Stub!"); }

/**
 * DTRMM performs one of the matrix-matrix operations
 * B := alpha*op(A)*B   or   B := alpha*B*op(A)
 * op(A) is one of  op(A) = A  or  op(A) = A**T
 *
 * Details: http://www.netlib.org/lapack/explore-html/dd/d19/dtrmm_8f.html
 *
 * @param Side Specifies whether the symmetric matrix A appears on the left or right.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#LEFT}, or {@link android.renderscript.ScriptIntrinsicBLAS#RIGHT}
 * @param Uplo Specifies whether matrix A is upper or lower triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @apiSince 23
 */

public void DTRMM(int Side, int Uplo, int TransA, int Diag, double alpha, android.renderscript.Allocation A, android.renderscript.Allocation B) { throw new RuntimeException("Stub!"); }

/**
 * CTRMM performs one of the matrix-matrix operations
 * B := alpha*op(A)*B   or   B := alpha*B*op(A)
 * op(A) is one of  op(A) = A  or  op(A) = A**T  or  op(A) = A**H
 *
 * Details: http://www.netlib.org/lapack/explore-html/d4/d9b/ctrmm_8f.html
 *
 * @param Side Specifies whether the symmetric matrix A appears on the left or right.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#LEFT}, or {@link android.renderscript.ScriptIntrinsicBLAS#RIGHT}
 * @param Uplo Specifies whether matrix A is upper or lower triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @apiSince 23
 */

public void CTRMM(int Side, int Uplo, int TransA, int Diag, android.renderscript.Float2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation B) { throw new RuntimeException("Stub!"); }

/**
 * ZTRMM performs one of the matrix-matrix operations
 * B := alpha*op(A)*B   or   B := alpha*B*op(A)
 * op(A) is one of  op(A) = A  or  op(A) = A**T  or  op(A) = A**H
 *
 * Details: http://www.netlib.org/lapack/explore-html/d8/de1/ztrmm_8f.html
 *
 * @param Side Specifies whether the symmetric matrix A appears on the left or right.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#LEFT}, or {@link android.renderscript.ScriptIntrinsicBLAS#RIGHT}
 * @param Uplo Specifies whether matrix A is upper or lower triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @apiSince 23
 */

public void ZTRMM(int Side, int Uplo, int TransA, int Diag, android.renderscript.Double2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation B) { throw new RuntimeException("Stub!"); }

/**
 * STRSM solves one of the matrix equations
 * op(A)*X := alpha*B   or   X*op(A) := alpha*B
 * op(A) is one of  op(A) = A  or  op(A) = A**T
 *
 * Details: http://www.netlib.org/lapack/explore-html/d2/d8b/strsm_8f.html
 *
 * @param Side Specifies whether the symmetric matrix A appears on the left or right.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#LEFT}, or {@link android.renderscript.ScriptIntrinsicBLAS#RIGHT}
 * @param Uplo Specifies whether matrix A is upper or lower triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F32 Element#F32}.
 * @apiSince 23
 */

public void STRSM(int Side, int Uplo, int TransA, int Diag, float alpha, android.renderscript.Allocation A, android.renderscript.Allocation B) { throw new RuntimeException("Stub!"); }

/**
 * DTRSM solves one of the matrix equations
 * op(A)*X := alpha*B   or   X*op(A) := alpha*B
 * op(A) is one of  op(A) = A  or  op(A) = A**T
 *
 * Details: http://www.netlib.org/lapack/explore-html/de/da7/dtrsm_8f.html
 *
 * @param Side Specifies whether the symmetric matrix A appears on the left or right.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#LEFT}, or {@link android.renderscript.ScriptIntrinsicBLAS#RIGHT}
 * @param Uplo Specifies whether matrix A is upper or lower triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F64 Element#F64}.
 * @apiSince 23
 */

public void DTRSM(int Side, int Uplo, int TransA, int Diag, double alpha, android.renderscript.Allocation A, android.renderscript.Allocation B) { throw new RuntimeException("Stub!"); }

/**
 * CTRSM solves one of the matrix equations
 * op(A)*X := alpha*B   or   X*op(A) := alpha*B
 * op(A) is one of  op(A) = A  or  op(A) = A**T  or  op(A) = A**H
 *
 * Details: http://www.netlib.org/lapack/explore-html/de/d30/ctrsm_8f.html
 *
 * @param Side Specifies whether the symmetric matrix A appears on the left or right.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#LEFT}, or {@link android.renderscript.ScriptIntrinsicBLAS#RIGHT}
 * @param Uplo Specifies whether matrix A is upper or lower triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @apiSince 23
 */

public void CTRSM(int Side, int Uplo, int TransA, int Diag, android.renderscript.Float2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation B) { throw new RuntimeException("Stub!"); }

/**
 * ZTRSM solves one of the matrix equations
 * op(A)*X := alpha*B   or   X*op(A) := alpha*B
 * op(A) is one of  op(A) = A  or  op(A) = A**T  or  op(A) = A**H
 *
 * Details: http://www.netlib.org/lapack/explore-html/d1/d39/ztrsm_8f.html
 *
 * @param Side Specifies whether the symmetric matrix A appears on the left or right.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#LEFT}, or {@link android.renderscript.ScriptIntrinsicBLAS#RIGHT}
 * @param Uplo Specifies whether matrix A is upper or lower triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param TransA The type of transpose applied to matrix A.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param Diag Specifies whether or not A is unit triangular.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NON_UNIT}, or {@link android.renderscript.ScriptIntrinsicBLAS#UNIT}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @apiSince 23
 */

public void ZTRSM(int Side, int Uplo, int TransA, int Diag, android.renderscript.Double2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation B) { throw new RuntimeException("Stub!"); }

/**
 * CHEMM performs one of the matrix-matrix operations
 * C := alpha*A*B + beta*C   or   C := alpha*B*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/d3/d66/chemm_8f.html
 *
 * @param Side Specifies whether the symmetric matrix A appears on the left or right.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#LEFT}, or {@link android.renderscript.ScriptIntrinsicBLAS#RIGHT}
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @apiSince 23
 */

public void CHEMM(int Side, int Uplo, android.renderscript.Float2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation B, android.renderscript.Float2 beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * ZHEMM performs one of the matrix-matrix operations
 * C := alpha*A*B + beta*C   or   C := alpha*B*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/d6/d3e/zhemm_8f.html
 *
 * @param Side Specifies whether the symmetric matrix A appears on the left or right.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#LEFT}, or {@link android.renderscript.ScriptIntrinsicBLAS#RIGHT}
 * @param Uplo Specifies whether the upper or lower triangular part is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @apiSince 23
 */

public void ZHEMM(int Side, int Uplo, android.renderscript.Double2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation B, android.renderscript.Double2 beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * CHERK performs one of the hermitian rank k operations
 * C := alpha*A*A**H + beta*C   or   C := alpha*A**H*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/d8/d52/cherk_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part of C is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param Trans The type of transpose applied to the operation.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @apiSince 23
 */

public void CHERK(int Uplo, int Trans, float alpha, android.renderscript.Allocation A, float beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * ZHERK performs one of the hermitian rank k operations
 * C := alpha*A*A**H + beta*C   or   C := alpha*A**H*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/d1/db1/zherk_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part of C is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param Trans The type of transpose applied to the operation.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @apiSince 23
 */

public void ZHERK(int Uplo, int Trans, double alpha, android.renderscript.Allocation A, double beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * CHER2K performs one of the hermitian rank 2k operations
 * C := alpha*A*B**H + conjg( alpha )*B*A**H + beta*C   or   C := alpha*A**H*B + conjg( alpha )*B**H*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/d1/d82/cher2k_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part of C is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param Trans The type of transpose applied to the operation.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F32_2 Element#F32_2}.
 * @apiSince 23
 */

public void CHER2K(int Uplo, int Trans, android.renderscript.Float2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation B, float beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * ZHER2K performs one of the hermitian rank 2k operations
 * C := alpha*A*B**H + conjg( alpha )*B*A**H + beta*C   or   C := alpha*A**H*B + conjg( alpha )*B**H*A + beta*C
 *
 * Details: http://www.netlib.org/lapack/explore-html/d7/dfa/zher2k_8f.html
 *
 * @param Uplo Specifies whether the upper or lower triangular part of C is to be referenced.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#UPPER}, or {@link android.renderscript.ScriptIntrinsicBLAS#LOWER}
 * @param Trans The type of transpose applied to the operation.
 * Value is {@link android.renderscript.ScriptIntrinsicBLAS#NO_TRANSPOSE}, {@link android.renderscript.ScriptIntrinsicBLAS#TRANSPOSE}, or {@link android.renderscript.ScriptIntrinsicBLAS#CONJ_TRANSPOSE}
 * @param alpha The scalar alpha.
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @param beta The scalar beta.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#F64_2 Element#F64_2}.
 * @apiSince 23
 */

public void ZHER2K(int Uplo, int Trans, android.renderscript.Double2 alpha, android.renderscript.Allocation A, android.renderscript.Allocation B, double beta, android.renderscript.Allocation C) { throw new RuntimeException("Stub!"); }

/**
 * 8-bit GEMM-like operation for neural networks: C = A * Transpose(B)
 * Calculations are done in 1.10.21 fixed-point format for the final output,
 * just before there's a shift down to drop the fractional parts. The output
 * values are gated to 0 to 255 to fit in a byte, but the 10-bit format
 * gives some headroom to avoid wrapping around on small overflows.
 *
 * @param A The input allocation contains matrix A, supported elements type {@link android.renderscript.Element#U8 Element#U8}.
 * @param a_offset The offset for all values in matrix A, e.g A[i,j] = A[i,j] - a_offset. Value should be from 0 to 255.
 * @param B The input allocation contains matrix B, supported elements type {@link android.renderscript.Element#U8 Element#U8}.
 * @param b_offset The offset for all values in matrix B, e.g B[i,j] = B[i,j] - b_offset. Value should be from 0 to 255.
 * @param C The input allocation contains matrix C, supported elements type {@link android.renderscript.Element#U8 Element#U8}.
 * @param c_offset The offset for all values in matrix C.
 * @param c_mult The multiplier for all values in matrix C, e.g C[i,j] = (C[i,j] + c_offset) * c_mult.
 *     * @apiSince 23
 */

public void BNNM(android.renderscript.Allocation A, int a_offset, android.renderscript.Allocation B, int b_offset, android.renderscript.Allocation C, int c_offset, int c_mult) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public static final int CONJ_TRANSPOSE = 113; // 0x71

/** @apiSince 23 */

public static final int LEFT = 141; // 0x8d

/** @apiSince 23 */

public static final int LOWER = 122; // 0x7a

/** @apiSince 23 */

public static final int NON_UNIT = 131; // 0x83

/** @apiSince 23 */

public static final int NO_TRANSPOSE = 111; // 0x6f

/** @apiSince 23 */

public static final int RIGHT = 142; // 0x8e

/** @apiSince 23 */

public static final int TRANSPOSE = 112; // 0x70

/** @apiSince 23 */

public static final int UNIT = 132; // 0x84

/** @apiSince 23 */

public static final int UPPER = 121; // 0x79
}

