package com.db.service;

import com.db.client.JiraClient;
import com.db.exceptions.SignalNotFoundException;
import com.db.model.SignalSpec;
import com.db.repository.SignalSpecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SignalSpecServiceImpl implements SignalSpecService{
    private final SignalSpecRepository signalSpecRepository;
    private final JiraClient jiraClient;

    @Autowired
    public SignalSpecServiceImpl(SignalSpecRepository signalSpecRepository, JiraClient jiraClient) {
        this.signalSpecRepository = signalSpecRepository;
        this.jiraClient = jiraClient;
    }

    @Override
    public SignalSpec fetchSignalById(Long signalId){
        Optional<SignalSpec> optionalSignalSpec = this.signalSpecRepository.findBySignalId(signalId);
        if(optionalSignalSpec.isPresent()){
            return optionalSignalSpec.get();
        }
        else{
            List<SignalSpec> newSignalSpecList = this.jiraClient.fetchSignalSpecs();
            this.signalSpecRepository.saveAll(newSignalSpecList);
            Optional<SignalSpec> optionalNewSignalSpec = newSignalSpecList.stream()
                    .filter(i -> i.getSignalId().equals(signalId)).findFirst();

            if(optionalNewSignalSpec.isPresent()){
                return optionalNewSignalSpec.get();
            }
            else{
                throw new SignalNotFoundException();
            }
        }
    }
}
