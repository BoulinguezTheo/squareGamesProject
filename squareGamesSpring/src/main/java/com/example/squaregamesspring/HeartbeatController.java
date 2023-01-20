package com.example.squaregamesspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
public class HeartbeatController {
    @Autowired
    private HeartbeatSensor sensor;
    @Autowired
    private GameCatalog catalog;

    @GetMapping("/heartbeat")
    public int getHeartbeat() {
        return sensor.get();
    }
    @GetMapping("/heart")
    public String testString(){
        return sensor.getString();
    }

//    @GetMapping("/games")
//    public Collection<String> getCatalogGames(){
//        return catalog.getGameIdentifiers();
//    }
}
