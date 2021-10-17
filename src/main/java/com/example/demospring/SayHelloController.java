package com.example.demospring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SayHelloController {

    private static final String TEMPLATE = "Hello World, Meet, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/sayHello")
    public SayHello sayHello(@RequestParam(value = "nick", defaultValue = "nick") String nick) {
        return new SayHello(counter.incrementAndGet(), String.format(TEMPLATE, nick));
    }

     @GetMapping("/sayNamaste")
    public SayNamaste sayNamaste(@RequestParam(value = "person", defaultValue = "person") String person) {
        return new SayNamaste(counter.incrementAndGet(), String.format(TEMPLATE, person));
    }

    @GetMapping("/sayKonnichiwa")
    public SayKonnichiwa sayKonnichiwa(@RequestParam(value = "name", defaultValue = "name") String name) {
        return new SayKonnichiwa(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }

}