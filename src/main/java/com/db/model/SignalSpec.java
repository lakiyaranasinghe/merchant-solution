package com.db.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/*
 The SignalSpec class represent an individual signal and it's operations
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
public class SignalSpec {
    @Id
    @GeneratedValue
    private Long id;
    public SignalSpec(Long signalId) {
        this.signalId = signalId;
    }

    //The Signal identifier
    private Long signalId;

    @OneToMany(cascade = CascadeType.ALL)
    //Operations to be performed for the signal
    private List<SignalAlgoDetail> algoDetailList;
}
