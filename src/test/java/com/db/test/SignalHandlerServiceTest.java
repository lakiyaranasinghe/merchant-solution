package com.db.test;

import com.db.client.JiraClient;
import com.db.lib.SignalHandler;
import com.db.model.algo.AlgoGeneric;
import com.db.model.algo.AlgoParameterized;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class SignalHandlerServiceTest {
    @InjectMocks
    private SignalHandler signalHandler;

    @Mock
    private JiraClient jiraClient;

    @InjectMocks
    private Map<String, AlgoGeneric> algoGenericMap;

    @InjectMocks
    private Map<String, AlgoParameterized> algoParameterizedMap;

    @Test
    public void shouldPerformAlgorithmWhenSignalGiven(){

    }
}
