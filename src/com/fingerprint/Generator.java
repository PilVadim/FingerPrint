package com.fingerprint;

public class Generator {

    public static String drawPrint(final int size, final Style style){
        if (size < 2)
            return style.TB.getSymbol();

        final Brick[][] matrix = new Brick[size][size];
        final int lastId = size - 1;

        setBorders(matrix, style);
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

    private static void setBorders(final Brick[][] matrix, final Style style){

        final int lastId = matrix.length - 1;
        //set corners
        matrix[0][0] = style.BR;
        matrix[0][lastId] = style.LB;
        matrix[lastId][0] = style.TR;
        matrix[lastId][lastId] = style.LT;

        //set top line
        for (int i = 1; i < lastId; i++){
            final Boolean top = false;//1111 TRBL
            final Boolean right;
            if (i == lastId - 1)
                right = true;
            else
                right = null;

            final Boolean bottom = null;
            final Boolean left = (matrix[0][i - 1].getCode() & 0b0100) > 0; //check if left element has right connection

            matrix[0][i] = style.getRandomBrickByFilter(top, right, bottom, left);
        }

        //set bottom line
        for (int i = 1; i < lastId; i++){
            final Boolean top = null;//1111 TRBL
            final Boolean right;
            if (i == lastId - 1)
                right = true;
            else
                right = null;

            final Boolean bottom = false;
            final Boolean left = (matrix[lastId][i - 1].getCode() & 0b0100) > 0; //check if left element has right connection

            matrix[lastId][i] = style.getRandomBrickByFilter(top, right, bottom, left);
        }

        //set left line
        for (int i = 1; i < lastId; i++){
            final Boolean top = (matrix[i - 1][0].getCode() & 0b0010) > 0; //check if top element has bottom connection

            final Boolean right = null;

            final Boolean bottom;
            if (i == lastId - 1)
                bottom = true;
            else
                bottom = null;

            final Boolean left = false;

            matrix[i][0] = style.getRandomBrickByFilter(top, right, bottom, left);
        }

        //set right line
        for (int i = 1; i < lastId; i++){
            final Boolean top = (matrix[i - 1][lastId].getCode() & 0b0010) > 0; //check if top element has bottom connection

            final Boolean right = false;

            final Boolean bottom;
            if (i == lastId - 1)
                bottom = true;
            else
                bottom = null;

            final Boolean left = null;

            matrix[i][lastId] = style.getRandomBrickByFilter(top, right, bottom, left);
        }
    }

    private static void setInsights(Brick[][] matrix, Style style) {

        final int lastId = matrix.length - 1;
        for (int i = 1; i < lastId; i++){
            for (int j = 1; j < lastId; j++){
                final Boolean top = matrix[i - 1][j] == null ? null : (matrix[i - 1][j].getCode() & 0b0010) > 0; //check if top element has bottom connection
                final Boolean right = matrix[i][j + 1] == null ? null : (matrix[i][j + 1].getCode() & 0b0001) > 0; //check if right element has left connection
                final Boolean bottom = matrix[i + 1][j] == null ? null : (matrix[i + 1][j].getCode() & 0b1000) > 0; //check if bot element has top connection
                final Boolean left = matrix[i][j - 1] == null ? null : (matrix[i][j - 1].getCode() & 0b0100) > 0; //check if right element has left connection

                matrix[i][j] = style.getRandomBrickByFilter(top, right, bottom, left);
            }
        }
    }

}
