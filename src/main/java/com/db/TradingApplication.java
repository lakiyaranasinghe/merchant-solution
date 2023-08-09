package com.db;

import com.db.model.algo.AlgoGeneric;
import com.db.model.algo.AlgoParameterized;
import com.db.model.algo.impl.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class TradingApplication {
    public static void main(String[] args) {
        SpringApplication.run(TradingApplication.class, args);
    }

    @Bean
    public Map<String, AlgoGeneric> genericAlgoTemplate(){
        Map<String, AlgoGeneric> algoGenericMap = new HashMap<>();
        algoGenericMap.put("do", new AlgoDo());
        algoGenericMap.put("cancel", new AlgoCancel());
        algoGenericMap.put("reverse", new AlgoReverse());
        algoGenericMap.put("submitMarket", new AlgoSubmit());
        algoGenericMap.put("performCalculation", new AlgoCalculate());
        algoGenericMap.put("setup", new AlgoSetup());
        return algoGenericMap;
    }

    @Bean
    public Map<String, AlgoParameterized> parameterizedAlgoTemplate(){
        Map<String, AlgoParameterized> algoParameterizedMap = new HashMap<>();
        algoParameterizedMap.put("setParam", new AlgoParam());
        return algoParameterizedMap;
    }
}
