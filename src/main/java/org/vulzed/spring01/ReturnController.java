package org.vulzed.spring01;

import java.util.concurrent.atomic.AtomicLong;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/return")
    public Response returnResponse(@RequestParam(value="name", defaultValue="World") String name) {
        return new Response(counter.incrementAndGet(),
                            String.format(TEMPLATE, name));
    }
}
