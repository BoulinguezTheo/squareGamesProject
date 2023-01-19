package com.example.squaregamesspring;

import org.springframework.stereotype.Service;

@Service
public class RandomHeartbeat implements HeartbeatSensor{
    @Override
    public int get() {
        return 200;
    }
    @Override
    public boolean displayTest(){
        System.out.println("test coucou");
        return false;
    }
    @Override
    public String getString(){
        return "coucou";
    }
}
