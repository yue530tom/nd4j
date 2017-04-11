package org.nd4j.linalg.api.blas.impl;

import org.nd4j.linalg.api.blas.Lapack;
import org.nd4j.linalg.api.ndarray.INDArray;

/**
 * @author Audrey Loeffel
 */
public abstract class SparseBaseLapack implements Lapack {
    @Override
    public INDArray getrf(INDArray A) {
        return null;
    }

    @Override
    public void geqrf(INDArray A, INDArray R) {

    }

    @Override
    public void potrf(INDArray A, boolean lower) {

    }

    @Override
    public void gesvd(INDArray A, INDArray S, INDArray U, INDArray VT) {

    }

    @Override
    public INDArray getPFactor(int M, INDArray ipiv) {
        return null;
    }

    @Override
    public INDArray getLFactor(INDArray A) {
        return null;
    }

    @Override
    public INDArray getUFactor(INDArray A) {
        return null;
    }

    @Override
    public void getri(int N, INDArray A, int lda, int[] IPIV, INDArray WORK, int lwork, int INFO) {

    }
}
