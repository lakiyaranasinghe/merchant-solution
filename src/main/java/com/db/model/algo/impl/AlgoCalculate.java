package com.db.model.algo.impl;

import com.db.lib.Algo;
import com.db.model.algo.AlgoGeneric;

public class AlgoCalculate extends Algo implements AlgoGeneric {
    @Override
    public void perform() {
        performCalc();
    }
}
