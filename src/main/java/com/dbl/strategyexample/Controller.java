package com.dbl.strategyexample;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/v1/example")
@RestController
public class Controller {

    private final HashMap<String, Algorithm> algsMapped;

    public Controller(@Autowired List<Algorithm> algs) {
        this.algsMapped = new HashMap<>();
        algs.forEach(it -> {
            System.out.println(it.myType());
        });
        for (AlgTypes algTypes : AlgTypes.values()) {
            algsMapped.put(algTypes.name(),
                    algs.stream().
                            filter(it -> it.myType().equals(algTypes))
                            .findFirst().get()
            );
        }
    }

    @PutMapping("/{alg}")
    public void runAlg(@PathVariable("alg") String alg) {
        Algorithm algorithm = algsMapped.get(alg.toUpperCase());
        algorithm.run();
    }
}
