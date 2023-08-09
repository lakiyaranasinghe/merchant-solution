package com.db.service;

import com.db.client.JiraClient;
import com.db.lib.SignalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignalHandlerImpl implements SignalHandler {
    private final JiraClient jiraClient;

    @Autowired
    public SignalHandlerImpl(JiraClient jiraClient) {
        this.jiraClient = jiraClient;
    }

    @Override
    public void handleSignal(int signal) {

    }
}
