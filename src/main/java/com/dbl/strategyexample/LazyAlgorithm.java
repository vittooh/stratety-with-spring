package com.dbl.strategyexample;

import org.springframework.stereotype.Service;

@Service
public class LazyAlgorithm  extends Algorithm{
    @Override
    void run() {
        System.out.println("I'm lazy algo ");
    }

    @Override
    AlgTypes myType() {
        return AlgTypes.LAZY_ALG;
    }
}
