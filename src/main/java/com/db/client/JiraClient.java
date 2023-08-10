package com.db.client;

import com.db.model.SignalSpec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/*
 JiraClient class represent the implementation of fetching the new Signal related information from JIRA and modifying it
 according to the domain objects

 **This layer can be cached to avoid frequent JIRA API Calls
 */
@Service
public class JiraClient {
    @Value("classpath:data.json")
    private Resource resourceFile;
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
        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        List<SignalSpec> signalSpecList;
        try {
            file = resourceFile.getFile();
            signalSpecList = objectMapper.readValue(file, new TypeReference<>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return signalSpecList;
    }
}
