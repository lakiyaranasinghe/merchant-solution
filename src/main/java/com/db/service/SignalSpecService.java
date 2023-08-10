package com.db.service;

import com.db.model.SignalSpec;

public interface SignalSpecService {
    SignalSpec fetchSignalById(Long signalId);
}
