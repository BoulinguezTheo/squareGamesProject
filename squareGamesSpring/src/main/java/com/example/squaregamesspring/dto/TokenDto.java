package com.example.squaregamesspring.dto;

import com.example.squaregamesspring.controller.CellPosition;

import java.util.UUID;

public class TokenDto {
    private String ownerId;
    private String name;
    private CellPosition position;

    public TokenDto() {}

    public TokenDto(String pOwnerId, String pName, CellPosition pPosition){
        this.ownerId = pOwnerId;
        this.name = pName;
        this.position = pPosition;
    }

    public TokenDto(String pOwnerId, String pName){
        this.ownerId = pOwnerId;
        this.name = pName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String pOwnerID){
        this.ownerId = pOwnerID;
    }

    public String getName() {
        return name;
    }

    public CellPosition getPosition() {
        return position;
    }
}
