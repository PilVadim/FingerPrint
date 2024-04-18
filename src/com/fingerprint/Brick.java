package com.fingerprint;

public class Brick {
    private final byte code;
    private final String symbol;

    public byte getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    public Brick(byte code, String symbol) {
        this.code = code;
        this.symbol = symbol;
    }
}
