package com.db.test;

import com.db.client.JiraClient;
import com.db.exceptions.SignalNotFoundException;
import com.db.model.SignalSpec;
import com.db.repository.SignalSpecRepository;
import com.db.service.SignalSpecServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SignalSpecServiceTest extends TestResource{
    @Mock
    private SignalSpecRepository signalSpecRepository;
    @Mock
    private JiraClient jiraClient = mock(JiraClient.class);
    private SignalSpecServiceImpl signalSpecService;

    @BeforeEach
    void setUp(){
        signalSpecService = new SignalSpecServiceImpl(signalSpecRepository, jiraClient);
    }

    @Test
    public void shouldReturnSignalWhenAvailableInDatabase(){
        SignalSpec signalSpec = fetchSampleSignal(1L);
        when(signalSpecRepository.findBySignalId(1L)).thenReturn(Optional.of(signalSpec));

        SignalSpec dbSignalSpec = this.signalSpecService.fetchSignalById(1L);
        assertNotNull(dbSignalSpec);
        assertEquals(dbSignalSpec.getSignalId(), 1L);
    }

    @Test
    public void shouldReturnSignalWhenFromJiraWhenNotAvailableInDatabase(){
        List<SignalSpec> signalSpecList = fetchSampleSignals();
        when(jiraClient.fetchSignalSpecs()).thenReturn(signalSpecList);

        SignalSpec dbSignalSpec = this.signalSpecService.fetchSignalById(1L);
        assertNotNull(dbSignalSpec);
        assertEquals(dbSignalSpec.getSignalId(), 1L);
    }

    @Test
    public void shouldThrowExceptionWhenSignalIdFound(){
        Throwable thrown = assertThrows(SignalNotFoundException.class, () -> signalSpecService.fetchSignalById(3L));
        assertThat(thrown, instanceOf(SignalNotFoundException.class));
    }

    @AfterEach
    public void cleanUp(){
        Mockito.reset(signalSpecRepository, jiraClient);
    }
}
