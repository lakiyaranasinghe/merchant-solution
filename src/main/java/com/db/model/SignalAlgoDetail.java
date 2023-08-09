package com.db.model;

/*
 The SignalAlgoDetail represent an individual algorithmic operations that is attached to a signal
 */
public class SignalAlgoDetail {
    public SignalAlgoDetail(String operation, SignalAlgoType signalAlgoType) {
        this.operation = operation;
        this.signalAlgoType = signalAlgoType;
    }

    //operation - name of the algorithmic operation
    private final String operation;

    //signalAlgoType - type of the algorithm based on SignalAlgoType enum
    private final SignalAlgoType signalAlgoType;
    private int param1;
    private int param2;

    public String getOperation() {
        return operation;
    }

    public SignalAlgoType getSignalAlgoType() {
        return signalAlgoType;
    }

    public int getParam1() {
        return param1;
    }

    public void setParam1(int param1) {
        this.param1 = param1;
    }

    public int getParam2() {
        return param2;
    }

    public void setParam2(int param2) {
        this.param2 = param2;
    }
}
