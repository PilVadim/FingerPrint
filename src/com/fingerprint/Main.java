package com.fingerprint;

import java.util.*;

import static com.fingerprint.Generator.drawPrint;
import static com.fingerprint.Styles.*;

public class Main {

    private static String CURRENT_STYLE = "LINES";
    private static Style L_STYLE = LINES;
    private final static Set<String> EXIT_COMMANDS;

    static {
        EXIT_COMMANDS = new HashSet<>();
        EXIT_COMMANDS.add("exit");
        EXIT_COMMANDS.add("quit");
        EXIT_COMMANDS.add("e");
        EXIT_COMMANDS.add("q");
    }

    private final static Set<String> STYLES_COMMANDS;

    static {
        STYLES_COMMANDS = new HashSet<>();
        STYLES_COMMANDS.add("l");
        STYLES_COMMANDS.add("line");
        STYLES_COMMANDS.add("d");
        STYLES_COMMANDS.add("double");
        STYLES_COMMANDS.add("r");
        STYLES_COMMANDS.add("round");
    }

    public static void main(String[] args) {
        System.out.println("Set size:");
        Scanner sc = new Scanner(System.in);

        while (true){
            String command = sc.nextLine();

            if (EXIT_COMMANDS.contains(command.toLowerCase()))
                System.exit(0);

            if (STYLES_COMMANDS.contains(command.toLowerCase())){
                changeStyle(command.toLowerCase());
                continue;
            }

            try{
                final int size = Integer.parseInt(command);
                System.out.println( drawPrint(size, L_STYLE) );
            } catch (Exception ex){
                System.out.println(ex.getMessage());
                ex.printStackTrace();
                System.out.println("Not a number or command\n" +
                                    "- put integer to generate fingerprint:\n" +
                                    "- put command to set style:\n");
                STYLES_COMMANDS.forEach(System.out::println);
                System.out.println("- put command to close app:");
                EXIT_COMMANDS.forEach(System.out::println);
            }
        }
    }

    private static void changeStyle(final String style) {
        switch (style){
            case "l":
            case "lines":
                L_STYLE = LINES; CURRENT_STYLE = "LINES"; break;
            case "d":
            case "double":
                L_STYLE = DOUBLE_LINES; CURRENT_STYLE = "DOUBLE_LINES"; break;
            case "r":
            case "round":
                L_STYLE = ROUND_LINES; CURRENT_STYLE = "ROUND_LINES"; break;
        }
        System.out.println("Current style is : " + CURRENT_STYLE);
    }

}