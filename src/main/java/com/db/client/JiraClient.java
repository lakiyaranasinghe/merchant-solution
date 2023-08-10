package com.db.client;

import com.db.model.SignalAlgoDetail;
import com.db.model.SignalAlgoType;
import com.db.model.SignalSpec;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 JiraClient class represent the implementation of fetching the new Signal related information from JIRA and modifying it
 according to the domain objects

 **This layer can be cached to avoid frequent JIRA API Calls
 */
@Service
public class JiraClient {
    public List<SignalSpec> fetchSignalSpecs(){
        /*
        JIRA API Integration to fetch new signal list and parse it to match the objects
        */
        List<String> ticketList = this.fetchJiraTickets();
        return this.parseTicketList(ticketList);
        /*Start Setting Sample Data*/
    }

    //Fetch Tickets from JIRA
    List<String> fetchJiraTickets(){
        return Collections.singletonList("Ticket List");
    }

    //Parse Tickets to Domain SignalSpec Object
    List<SignalSpec> parseTicketList(List<String> ticketList){
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

        signalSpecList.add(signal1);
        return signalSpecList;
    }
}
