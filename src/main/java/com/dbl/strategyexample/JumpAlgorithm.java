package com.dbl.strategyexample;

import org.springframework.stereotype.Service;

@Service
public class JumpAlgorithm extends Algorithm {
    @Override
    public void run() {
        System.out.println("I'm jumping a algorithm");
    }

    @Override
    AlgTypes myType() {
        return AlgTypes.JUMP_ALG;
    }
}
