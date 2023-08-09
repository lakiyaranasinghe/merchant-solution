package com.db.controller;

import com.db.lib.SignalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("signals")
public class SingalController {
    private final SignalHandler signalHandler;

    @Autowired
    public SingalController(SignalHandler signalHandler) {
        this.signalHandler = signalHandler;
    }

    @PostMapping("{id}")
    public void processSignal(@PathVariable int id){
        this.signalHandler.handleSignal(id);
    }
}
