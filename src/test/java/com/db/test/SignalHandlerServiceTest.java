package com.db.test;

import com.db.client.JiraClient;
import com.db.lib.SignalHandler;
import com.db.model.SignalSpec;
import com.db.service.SignalHandlerImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SignalHandlerServiceTest {
    private SignalHandler signalHandler;

    @Mock
    private JiraClient jiraClient = mock(JiraClient.class);
    @BeforeAll
    public void setUp(){
        signalHandler = new SignalHandlerImpl(jiraClient);
        when(jiraClient.fetchSignalSpecs()).thenReturn(generateSampleSignals());
    }
    @Test
    public void shouldAcceptSignal(){
        signalHandler.handleSignal(1);
    }

    private List<SignalSpec> generateSampleSignals(){
        List<SignalSpec> signalSpecList = new ArrayList<>();
        return signalSpecList;
    }
}
