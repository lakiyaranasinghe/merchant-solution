package com.db.model.algo.impl;

import com.db.lib.Algo;
import com.db.model.algo.AlgoParameterized;

public class AlgoParam extends Algo implements AlgoParameterized {
    @Override
    public void perform(int a, int b) {
        setAlgoParam(a, b);
    }
}
