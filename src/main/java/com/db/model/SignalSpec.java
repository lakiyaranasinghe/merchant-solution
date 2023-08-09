package com.db.model;

import java.util.List;

/*
 The SignalSpec class represent an individual signal and it's operations
 */
public class SignalSpec {
    public SignalSpec(Long signalId) {
        this.signalId = signalId;
    }

    //The Signal identifier
    private final Long signalId;

    //Operations to be performed for the signal
    private List<SignalAlgoDetail> algoDetailList;

    public Long getSignalId() {
        return signalId;
    }

    public List<SignalAlgoDetail> getAlgoDetailList() {
        return algoDetailList;
    }

    public void setAlgoDetailList(List<SignalAlgoDetail> algoDetailList) {
        this.algoDetailList = algoDetailList;
    }
}
