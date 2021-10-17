package com.example.demospring;

public class SayKonnichiwa {

    private final long id;
    private final String content;

    public SayKonnichiwa(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}