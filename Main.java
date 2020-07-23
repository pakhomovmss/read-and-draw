package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String path = "E:\\Temp\\check.txt";

        CommandRecognition cr = new CommandRecognition();
        cr.readCommands(path);

        ArrayList<String> listOfCommands = cr.getCurrentCommands();

        for (String command : listOfCommands) {
            cr.commandRecognition(command);
        }

        Draw window = new Draw();
    }
}