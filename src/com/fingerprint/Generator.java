package com.fingerprint;

public class Generator {

    public static String drawPrint(final int size, final Style style){
        if (size < 2)
            return style.TB;

        final StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        final int lastIndex = size - 1;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++)

                if (i == 0)
                    if (j == 0)
                        sb.append(style.BR);
                    else if (j == lastIndex)
                        sb.append(style.LB);
                    else
                        sb.append(style.getFromTOP());
                else if (i == lastIndex)
                    if (j == 0)
                        sb.append(style.TR);
                    else if (j == lastIndex)
                        sb.append(style.LT);
                    else
                        sb.append(style.getFromBOTTOM());
                else if (j == 0)
                    sb.append(style.getFromLEFT());
                else if (j == lastIndex)
                    sb.append(style.getFromRIGHT());
                else
                    sb.append(style.getFromALL());

            result.append(sb).append("\n");
            sb = new StringBuilder();
        }
        return result.toString();
    }

}
