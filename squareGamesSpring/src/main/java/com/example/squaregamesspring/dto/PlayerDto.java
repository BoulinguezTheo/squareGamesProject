package com.example.squaregamesspring.dto;

import java.util.UUID;

public class PlayerDto {
    private UUID playerId;

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }


}
