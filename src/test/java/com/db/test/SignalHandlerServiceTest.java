package com.db.test;

import com.db.lib.SignalHandler;
import com.db.model.algo.AlgoGeneric;
import com.db.model.algo.AlgoParameterized;
import com.db.service.SignalHandlerImpl;
import com.db.service.SignalSpecService;
import com.db.service.SignalSpecServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SignalHandlerServiceTest extends TestResource{
    private SignalHandler signalHandler;
    @Mock
    private SignalSpecService signalSpecService = mock(SignalSpecServiceImpl.class);

    //Test the System.out.println generated by the Algo Lib
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeAll
    public void setupTemplate(){
        Map<String, AlgoGeneric> algoGenericMap = fetchGenericSignalTemplate();
        Map<String, AlgoParameterized> algoParameterizedMap = fetchParameterizedSignalTemplate();

        signalHandler = new SignalHandlerImpl(signalSpecService, algoGenericMap, algoParameterizedMap);
        when(signalSpecService.fetchSignalById(1L)).thenReturn(fetchSampleSignal(1L));
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void shouldAcceptSignal(){
        signalHandler.handleSignal(1);
    }

    @Test
    public void shouldPrintCorrectAlgoStepsWhenSignalGiven(){
        signalHandler.handleSignal(1);
        assertThat(outputStreamCaptor.toString().trim(), startsWith("setUp"));
        assertThat(outputStreamCaptor.toString().trim(), containsString("setAlgoParam1,60"));
        assertThat(outputStreamCaptor.toString().trim(), containsString("performCalc"));
        assertThat(outputStreamCaptor.toString().trim(), endsWith("submitToMarket"));
    }
}
