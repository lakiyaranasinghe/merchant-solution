package com.db.client;

import com.db.model.SignalAlgoDetail;
import com.db.model.SignalAlgoType;
import com.db.model.SignalSpec;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JiraClient {
    public List<SignalSpec> fetchSignalSpecs(){
        /* JIRA API Integration to fetch signal list and parse it to match the objects */
        List<SignalSpec> signalSpecList = new ArrayList<>();

        /*Start Setting Sample Data*/
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

        signalSpecList.add(signal1);
        return signalSpecList;
    }
}
