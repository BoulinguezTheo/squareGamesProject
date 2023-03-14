package com.example.squaregamesspring.controller;

public record CellPosition(Integer x, Integer y) {
    public Integer getx() {
        return x;
    }
    public Integer gety() {
        return y;
    }
}
