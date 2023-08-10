package com.db.service;

import com.db.lib.SignalHandler;
import com.db.model.SignalAlgoDetail;
import com.db.model.SignalAlgoType;
import com.db.model.SignalSpec;
import com.db.model.algo.AlgoGeneric;
import com.db.model.algo.AlgoParameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SignalHandlerImpl implements SignalHandler {
    private final SignalSpecService signalSpecService;
    private final Map<String, AlgoGeneric> algoGenericMap;
    private final Map<String, AlgoParameterized> algoParameterizedMap;

    @Autowired
    public SignalHandlerImpl(SignalSpecService signalSpecService,
                             Map<String, AlgoGeneric> algoGenericMap,
                             Map<String, AlgoParameterized> algoParameterizedMap) {
        this.signalSpecService = signalSpecService;
        this.algoGenericMap = algoGenericMap;
        this.algoParameterizedMap = algoParameterizedMap;
    }

    @Override
    public void handleSignal(int signal) {
        SignalSpec signalSpec = signalSpecService.fetchSignalById((long)signal);
        performAlgo(signalSpec);
    }

    //Perform the algorithm method based on type and operation
    private void performAlgo(SignalSpec signalSpec) {
        for (SignalAlgoDetail signalAlgoDetail : signalSpec.getAlgoDetailList()) {
            if (signalAlgoDetail.getSignalAlgoType().equals(SignalAlgoType.GENERIC)) {
                AlgoGeneric algoGeneric = algoGenericMap.get(signalAlgoDetail.getOperation());
                algoGeneric.perform();
            } else if (signalAlgoDetail.getSignalAlgoType().equals(SignalAlgoType.PARAM)) {
                AlgoParameterized algoParameterized = algoParameterizedMap.get(signalAlgoDetail.getOperation());
                algoParameterized.perform(signalAlgoDetail.getParam1(), signalAlgoDetail.getParam2());
            }
        }
    }
}
