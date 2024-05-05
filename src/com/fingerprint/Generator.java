package com.fingerprint;

public class Generator {

    public static String drawPrint(final int size, final Style style){
        if (size < 2)
            return style.TB.getSymbol();

        final Brick[][] matrix = new Brick[size][size];

        setInsights(matrix, style);

        final StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++)
                sb.append(matrix[i][j] != null? matrix[i][j].getSymbol():" ");
            result.append(sb).append("\n");
            sb = new StringBuilder();
        }
        return result.toString();
    }

    private static void setInsights(Brick[][] matrix, Style style) {

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){

                final Boolean top;  //check if top element has bottom connection
                if (i - 1 < 0){
                    top = false;
                } else if (matrix[i - 1][j] == null) {
                    top = null;
                } else {
                    top = (matrix[i - 1][j].getCode() & 0b0010) > 0;
                }

                final Boolean right; //check if right element has left connection
                if (j + 1 == matrix.length) {
                    right = false;
                } else if (matrix[i][j + 1] == null) {
                    right = null;
                } else {
                    right = (matrix[i][j + 1].getCode() & 0b0001) > 0;
                }

                final Boolean bottom; //check if bot element has top connection
                if (i + 1 == matrix.length) {
                    bottom = false;
                } else if (matrix[i + 1][j] == null) {
                    bottom = null;
                } else {
                    bottom = (matrix[i + 1][j].getCode() & 0b1000) > 0;
                }

                final Boolean left; //check if right element has left connection
                if (j - 1 < 0) {
                    left = false;
                } else if (matrix[i][j - 1] == null) {
                    left = null;
                } else {
                    left = (matrix[i][j - 1].getCode() & 0b0100) > 0;
                }

                matrix[i][j] = style.getRandomBrickByFilter(top, right, bottom, left);
            }
        }
    }
}
