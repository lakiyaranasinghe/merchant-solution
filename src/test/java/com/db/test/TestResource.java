package com.db.test;

import com.db.model.SignalAlgoDetail;
import com.db.model.SignalAlgoType;
import com.db.model.SignalSpec;
import com.db.model.algo.AlgoGeneric;
import com.db.model.algo.AlgoParameterized;
import com.db.model.algo.impl.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestResource {
    public SignalSpec fetchSampleSignal(Long id){
        SignalSpec signal1 = new SignalSpec(id);
        List<SignalAlgoDetail> signalAlgoDetailList = new ArrayList<>();
        SignalAlgoDetail signalAlgoDetail1 = new SignalAlgoDetail("setup", SignalAlgoType.GENERIC);
        SignalAlgoDetail signalAlgoDetail2 = new SignalAlgoDetail("setParam", SignalAlgoType.PARAM);
        signalAlgoDetail2.setParam1(1);
        signalAlgoDetail2.setParam2(60);

        SignalAlgoDetail signalAlgoDetail3 = new SignalAlgoDetail("performCalculation", SignalAlgoType.GENERIC);
        SignalAlgoDetail signalAlgoDetail4 = new SignalAlgoDetail("submitMarket", SignalAlgoType.GENERIC);
        signalAlgoDetailList.add(signalAlgoDetail1);
        signalAlgoDetailList.add(signalAlgoDetail2);
        signalAlgoDetailList.add(signalAlgoDetail3);
        signalAlgoDetailList.add(signalAlgoDetail4);
        signal1.setAlgoDetailList(signalAlgoDetailList);

        return signal1;
    }

    public Map<String, AlgoGeneric> fetchGenericSignalTemplate(){
        Map<String, AlgoGeneric> algoGenericMap = new HashMap<>();
        algoGenericMap.put("do", new AlgoDo());
        algoGenericMap.put("cancel", new AlgoCancel());
        algoGenericMap.put("reverse", new AlgoReverse());
        algoGenericMap.put("submitMarket", new AlgoSubmit());
        algoGenericMap.put("performCalculation", new AlgoCalculate());
        algoGenericMap.put("setup", new AlgoSetup());
        return algoGenericMap;
    }

    public Map<String, AlgoParameterized> fetchParameterizedSignalTemplate(){
        Map<String, AlgoParameterized> algoParameterizedMap = new HashMap<>();
        algoParameterizedMap.put("setParam", new AlgoParam());
        return algoParameterizedMap;
    }

    public List<SignalSpec> fetchSampleSignals(){
        List<SignalSpec> signalSpecList = new ArrayList<>();

        SignalSpec signal1 = new SignalSpec(1L);
        List<SignalAlgoDetail> signalAlgoDetailList = new ArrayList<>();
        SignalAlgoDetail signalAlgoDetail1 = new SignalAlgoDetail("setup", SignalAlgoType.GENERIC);
        SignalAlgoDetail signalAlgoDetail2 = new SignalAlgoDetail("setParam", SignalAlgoType.PARAM);
        signalAlgoDetail2.setParam1(1);
        signalAlgoDetail2.setParam2(60);

        SignalAlgoDetail signalAlgoDetail3 = new SignalAlgoDetail("performCalculation", SignalAlgoType.GENERIC);
        SignalAlgoDetail signalAlgoDetail4 = new SignalAlgoDetail("submitMarket", SignalAlgoType.GENERIC);
        signalAlgoDetailList.add(signalAlgoDetail1);
        signalAlgoDetailList.add(signalAlgoDetail2);
        signalAlgoDetailList.add(signalAlgoDetail3);
        signalAlgoDetailList.add(signalAlgoDetail4);
        signal1.setAlgoDetailList(signalAlgoDetailList);

        SignalSpec signal2 = new SignalSpec(2L);
        List<SignalAlgoDetail> signal2AlgoDetailList = new ArrayList<>();
        SignalAlgoDetail signal2AlgoDetail1 = new SignalAlgoDetail("reverse", SignalAlgoType.GENERIC);
        SignalAlgoDetail signal2AlgoDetail2 = new SignalAlgoDetail("setParam", SignalAlgoType.PARAM);
        signal2AlgoDetail2.setParam1(1);
        signal2AlgoDetail2.setParam2(60);

        SignalAlgoDetail signal2AlgoDetail3 = new SignalAlgoDetail("submitMarket", SignalAlgoType.GENERIC);
        signalAlgoDetailList.add(signal2AlgoDetail1);
        signalAlgoDetailList.add(signal2AlgoDetail2);
        signalAlgoDetailList.add(signal2AlgoDetail3);

        signal2.setAlgoDetailList(signal2AlgoDetailList);

        signalSpecList.add(signal1);
        signalSpecList.add(signal2);
        return signalSpecList;
    }
}
