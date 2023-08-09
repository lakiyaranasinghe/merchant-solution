package com.db.model;

/*
 The SignalAlgoType enum represent the base types of algorithms that can be performed

    GENERIC - methods without parameters
    PARAM - methods with param1 and param2

    this class can be extended to more types based on future algorithms provided in com.db.lib.Algo;
 */
public enum SignalAlgoType {
    GENERIC, PARAM
}
