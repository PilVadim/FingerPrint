package com.fingerprint;

import java.util.*;

public class Style {

    private final List<Brick> bricks = new ArrayList<>();
    private final Map<String, List<Brick>> buffer = new HashMap<>();

    private final static Random rnd = new Random();
    //1111 TRBL
    public final Brick LR; // RL 0101
    public final Brick TB; // TB 1010
    public final Brick LB; // BL 0011
    public final Brick TR; // TR 1100
    public final Brick BR; // BR 0110
    public final Brick LT; // TL 1001
    public final Brick EMPTY; // 0000

    public Style(final String LR,
                 final String TB,
                 final String LB,
                 final String TR,
                 final String BR,
                 final String LT) {

        this.LR = new Brick((byte) 0b0101, LR);
        this.TB = new Brick((byte) 0b1010, TB);
        this.BR = new Brick((byte) 0b0110, BR);
        this.LB = new Brick((byte) 0b0011, LB);
        this.TR = new Brick((byte) 0b1100, TR);
        this.LT = new Brick((byte) 0b1001, LT);
        this.EMPTY = new Brick((byte) 0b0000, " ");
        //TRBL - top right bottom left - connections
        bricks.add(this.LR);
        bricks.add(this.TB);
        bricks.add(this.BR);
        bricks.add(this.LB);
        bricks.add(this.TR);
        bricks.add(this.LT);
    }

    public Brick getRandomBrickByFilter(final Boolean top,
                                        final Boolean right,
                                        final Boolean bottom,
                                        final Boolean left){
        byte filter = getFilter(top, right, bottom, left);
        byte revFilter = getReverseFilter(top, right, bottom, left);

        final List<Brick> bricks = getElementsByFilter(filter, revFilter);
        if (bricks.isEmpty())
            return EMPTY;
        else
            return bricks.get(rnd.nextInt(bricks.size()));
    }

    private List<Brick> getElementsByFilter(final Byte filter,
                                            final Byte revFilter){

        final String bufferKey = filter + "_" + revFilter;
        if (buffer.containsKey(bufferKey))
            return buffer.get(bufferKey);

        final List<Brick> result = new ArrayList<>();
        for (final Brick b : bricks)
            if ( (filter == 0 || ((b.getCode() & filter) == filter))
                    && (revFilter == 0 || ((b.getCode() & revFilter) == 0)))
                result.add(b);

        buffer.put(bufferKey, result);
        return result;

    }

    private byte getFilter(final Boolean top,
                           final Boolean right,
                           final Boolean bottom,
                           final Boolean left){
        byte filter = 0b0000;
        if (top != null && top) filter |= 0b1000;
        if (right != null && right) filter |= 0b0100;
        if (bottom != null && bottom) filter |= 0b0010;
        if (left != null && left) filter |= 0b0001;
        return filter;
    }

    private byte getReverseFilter(final Boolean top,
                                  final Boolean right,
                                  final Boolean bottom,
                                  final Boolean left){
        byte filter = 0b0000;
        if (top != null && ! top) filter |= 0b1000;
        if (right != null && ! right) filter |= 0b0100;
        if (bottom != null && ! bottom) filter |= 0b0010;
        if (left != null && ! left) filter |= 0b0001;
        return filter;
    }

}
