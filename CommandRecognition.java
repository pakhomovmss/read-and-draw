package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CommandRecognition {

    private ArrayList<String> currentCommands = new ArrayList<String>();
    private static int commandCounter = 0;

    public static int getCommandCounter() {
        return commandCounter;
    }

    public void readCommands(String path) {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            int lineCounter = 0;

            String line = reader.readLine();

            while (line != null) {

                if (lineCounter > 0) {
                    currentCommands.add(line);
                }

                line = reader.readLine();
                lineCounter++;
            }
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getCurrentCommands() {
        return currentCommands;
    }

    private String deleteExtraSpacesAfterSemicolons(String command) {

        StringBuilder com = new StringBuilder(command);

        for (int sym = 0; sym < command.length(); ++sym) {

            if (command.charAt(sym) == ';') {
                int item = sym + 1;

                while((item < command.length()) && (command.charAt(item) == ' ')) {
                    com.setCharAt(item, '.');
                    item++;
                }
            }
        }

        command = com.toString();
        command = command.replace(".", "");

        return command;
    }

    public String[] getKeyWords(String command) {
        //ArrayList<String> keyWords = new ArrayList<>();
        command = deleteExtraSpacesAfterSemicolons(command);
        command = command.toLowerCase();

        return command.split(" ");
    }

    public void commandRecognition(String command) {

        commandCounter++;

        String[] keyWords = getKeyWords(command);

        if (keyWords[1].equals("line") && keyWords[3].equals("coordinates")) {

            coordinateShapeDrawingHandler(keyWords, 4);
        }

        else if (keyWords[1].equals("circle") && keyWords[3].equals("center") && keyWords[5].equals("radius")) {
            try {
                int[] center = Arrays.stream(keyWords[4].split(";")).mapToInt(Integer::parseInt).toArray();
                int radius = 10;

                try {
                    radius = Integer.parseInt(keyWords[6]);
                }

                catch (Exception e) {
                    System.out.println("Shit!");

                }

                if (center.length == 2) {
                    Circle circle = new Circle(new Point(center[0], center[1]), radius,
                            findColourOrFill(keyWords,"colour", "black"),
                            findColourOrFill(keyWords, "fill", "none"));

                    circle.draw();
                }
            }

            catch(Exception e) {
                System.out.println("Shit!!!");
            }
        }

        else if (keyWords[1].equals("triangle") && keyWords[3].equals("coordinates")) {
            coordinateShapeDrawingHandler(keyWords, 6);
        }

        else if (keyWords[1].equals("rectangle") && keyWords[3].equals("coordinates")) {
            coordinateShapeDrawingHandler(keyWords, 4);
        }

    }

    private void coordinateShapeDrawingHandler(String[] keyWords, int coordsLength) {
        try {

            int[] coords = Arrays.stream(keyWords[4].split(";")).mapToInt(Integer::parseInt).toArray();

            if (coords.length != coordsLength) {
                System.out.println("Invalid coordinates!");
            }

            else {
                switch (keyWords[1]) {

                    case "line":
                    {
                        Line line = new Line(new Point(coords[0], coords[1]), new Point(coords[2], coords[3]),
                                findColourOrFill(keyWords,"colour", "black"),
                                findColourOrFill(keyWords, "fill", "none"));

                        line.draw();
                        break;
                    }

                    case "triangle":
                    {
                        Triangle triangle = new Triangle(new Point(coords[0], coords[1]),
                                new Point(coords[2], coords[3]), new Point(coords[4], coords[5]),
                                findColourOrFill(keyWords,"colour", "black"),
                                findColourOrFill(keyWords, "fill", "none"));

                        triangle.draw();
                        break;
                    }

                    case "rectangle":
                    {
                        Rectangle rectangle = new Rectangle(new Point(coords[0], coords[1]), new Point(coords[2], coords[3]),
                                findColourOrFill(keyWords,"colour", "black"),
                                findColourOrFill(keyWords, "fill", "none"));
                        rectangle.draw();
                        break;
                    }
                }
            }
        }

        catch (Exception e) {

        }
    }

    private String findColourOrFill(String[] keyWords, String findKeyWord, String defaultParameter) {
        int index = 0;
        int findKeyWordIndex = -2;

        for (String keyWord : keyWords) {

            if (keyWord.equals(findKeyWord)) {
                findKeyWordIndex = index;
                break;
            }

            index++;
        }

        if ((findKeyWordIndex + 1 < keyWords.length) && (findKeyWordIndex + 1 > 0)) {
            return keyWords[findKeyWordIndex + 1];
        }

        return defaultParameter;
    }
}