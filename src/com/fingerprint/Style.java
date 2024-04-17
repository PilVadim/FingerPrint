package com.fingerprint;

import java.util.Random;

public class Style {

    private final static Random rnd = new Random();
    //1111 TRBL
    public final String LR; // RL 0101
    public final String TB; // TB 1010
    public final String LB; // BL 0011
    public final String TR; // TR 1100
    public final String BR; // BR 0110
    public final String LT; // TL 1001

    private final String[] ALL = new String[6];
    private final String[] LEFT = new String[3];
    private final String[] TOP = new String[3];
    private final String[] RIGHT = new String[3];
    private final String[] BOTTOM = new String[3];


    public Style(final String LR,
                 final String TB,
                 final String LB,
                 final String TR,
                 final String BR,
                 final String LT) {

        this.LR = LR;
        this.TB = TB;
        this.BR = BR;
        this.LB = LB;
        this.TR = TR;
        this.LT = LT;

        ALL[0] = LR;
        ALL[1] = TB;
        ALL[2] = LB;
        ALL[3] = TR;
        ALL[4] = BR;
        ALL[5] = LT;

        LEFT[0] = TB;
        LEFT[1] = TR;
        LEFT[2] = BR;

        RIGHT[0] = TB;
        RIGHT[1] = LB;
        RIGHT[2] = LT;

        TOP[0] = LR;
        TOP[1] = LB;
        TOP[2] = BR;

        BOTTOM[0] = LR;
        BOTTOM[1] = TR;
        BOTTOM[2] = LT;
    }

    public String getFromALL(){
        return ALL[rnd.nextInt(6)];
    }
    public String getFromLEFT(){
        return LEFT[rnd.nextInt(3)];
    }
    public String getFromTOP(){
        return TOP[rnd.nextInt(3)];
    }
    public String getFromRIGHT(){
        return RIGHT[rnd.nextInt(3)];
    }
    public String getFromBOTTOM(){
        return BOTTOM[rnd.nextInt(3)];
    }

}
