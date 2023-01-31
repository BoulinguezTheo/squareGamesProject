package com.example.squaregamesspring.dto;

public class MoveTokenDto {

    private Integer oldX = null;
    private Integer oldY = null;
    private int newX;
    private int newY;

    public Integer getOldX() {
        return oldX;
    }

    public Integer getOldY() {
        return oldY;
    }

    public int getNewX() {
        return newX;
    }

    public int getNewY() {
        return newY;
    }

    public void setOldX(int oldX) {
        this.oldX = oldX;
    }

    public void setOldY(int oldY) {
        this.oldY = oldY;
    }

    public void setNewX(int newX) {
        this.newX = newX;
    }

    public void setNewY(int newY) {
        this.newY = newY;
    }


}
