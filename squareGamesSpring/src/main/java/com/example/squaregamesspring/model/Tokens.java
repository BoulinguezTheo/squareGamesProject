package com.example.squaregamesspring.model;

import java.util.Collection;

public class Tokens {
    public String name;
    private Collection remainingTokens;
    private Collection removedTokens;

    public Tokens(Collection pRemainingTokens, Collection pRemovedTokens){
        this.remainingTokens = pRemainingTokens;
        this.removedTokens = pRemovedTokens;
    }
}
