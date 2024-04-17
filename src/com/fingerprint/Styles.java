package com.fingerprint;

public class Styles {
    //1111 TRBL
    public final static Style LINES;
    public final static Style DOUBLE_LINES;
    public final static Style ROUND_LINES;
    static {
        LINES = new Style(
            "─", // RL 0101
            "│", // TB 1010
            "┐", // BL 0011
            "└", // TR 1100
            "┌", // BR 0110
            "┘"  // TL 1001
        );

        DOUBLE_LINES = new Style(
                "═",
                "║",
                "╗",
                "╚",
                "╔",
                "╝"
        );

        ROUND_LINES = new Style(
                "─",
                "│",
                "╮",
                "╰",
                "╭",
                "╯"
        );
    }
}
