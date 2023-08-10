package com.db.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 The SignalAlgoDetail represent an individual algorithmic operations that is attached to a signal
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class SignalAlgoDetail {

    @Id
    @GeneratedValue
    private Long id;
    public SignalAlgoDetail(String operation, SignalAlgoType signalAlgoType) {
        this.operation = operation;
        this.signalAlgoType = signalAlgoType;
    }
    //operation - name of the algorithmic operation
    private String operation;

    //signalAlgoType - type of the algorithm based on SignalAlgoType enum
    private SignalAlgoType signalAlgoType;
    private int param1;
    private int param2;
}
