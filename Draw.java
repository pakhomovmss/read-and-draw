package com.company;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Draw extends JFrame {

    public static ArrayList<Command> commandsToRun = new ArrayList<>();

    public Draw() {
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Read And Draw");
    }

    public void paint(Graphics g) {

        for (Command com : commandsToRun) {
            switch(com.getShape()) {

                case "line":
                {
                    try {
                        g.setColor(matchColour(com));
                        g.drawLine(com.getCoordinates()[0].getX(), com.getCoordinates()[0].getY(), com.getCoordinates()[1].getX(), com.getCoordinates()[1].getY());
                    }

                    catch (NullPointerException e) {

                    }

                    break;
                }

                case "circle":
                {
                    try {
                        g.setColor(matchFill(com));
                        g.fillOval(com.getCenter().getX(), com.getCenter().getY(), com.getRadius(), com.getRadius());
                        g.setColor(matchColour(com));
                    }

                    catch(Exception e) {

                    }

                    g.drawOval(com.getCenter().getX(), com.getCenter().getY(), com.getRadius(), com.getRadius());
                    break;
                }

                case "triangle":
                {
                    try {
                        Graphics2D g2d = (Graphics2D) g;

                        g2d.setColor(matchFill(com));

                        g2d.fillPolygon(new int[] {com.getCoordinates()[0].getX(), com.getCoordinates()[1].getX(), com.getCoordinates()[2].getX()},
                                new int[] {com.getCoordinates()[0].getY(), com.getCoordinates()[1].getY(), com.getCoordinates()[2].getY()}, 3);

                        g.setColor(matchColour(com));

                        g.drawLine(com.getCoordinates()[0].getX(), com.getCoordinates()[0].getY(), com.getCoordinates()[1].getX(), com.getCoordinates()[1].getY());
                        g.drawLine(com.getCoordinates()[2].getX(), com.getCoordinates()[2].getY(), com.getCoordinates()[1].getX(), com.getCoordinates()[1].getY());
                        g.drawLine(com.getCoordinates()[0].getX(), com.getCoordinates()[0].getY(), com.getCoordinates()[2].getX(), com.getCoordinates()[2].getY());

                    }

                    catch (NullPointerException e) {

                    }

                    break;
                }

                case "rectangle":
                {
                    try {
                        g.setColor(matchFill(com));
                        g.fillRect(com.getCoordinates()[0].getX(), com.getCoordinates()[0].getY(),
                                Math.abs(com.getCoordinates()[1].getX() - com.getCoordinates()[0].getX()),
                                Math.abs(com.getCoordinates()[1].getY() - com.getCoordinates()[0].getY()));

                        g.setColor(matchColour(com));

                        g.drawRect(com.getCoordinates()[0].getX(), com.getCoordinates()[0].getY(),
                                Math.abs(com.getCoordinates()[1].getX() - com.getCoordinates()[0].getX()),
                                Math.abs(com.getCoordinates()[1].getY() - com.getCoordinates()[0].getY()));
                    }

                    catch(NullPointerException e) {

                    }

                    break;
                }
            }
        }
    }

    private Color matchColour(Command command) {
        switch(command.getColour()) {

            case "black":
            {
                return Color.black;
            }

            case "blue":
            {
                return Color.blue;
            }

            case "green":
            {
                return Color.green;
            }

            case "red":
            {
                return Color.red;
            }

            case "purple":
            {
                return Color.magenta;
            }

            case "orange":
            {
                return Color.orange;
            }

            case "yellow":
            {
                return Color.yellow;
            }

            case "gray":
            {
                return Color.gray;
            }

            case "pink":
            {
                return Color.pink;
            }

            default:
                return Color.black;
        }
    }

    private Color matchFill(Command command) {
        switch(command.getFill()) {

            case "black":
            {
                return Color.black;
            }

            case "blue":
            {
                return Color.blue;
            }

            case "green":
            {
                return Color.green;
            }

            case "red":
            {
                return Color.red;
            }

            case "purple":
            {
                return Color.magenta;
            }

            case "orange":
            {
                return Color.orange;
            }

            case "yellow":
            {
                return Color.yellow;
            }

            case "gray":
            {
                return Color.gray;
            }

            case "pink":
            {
                return Color.pink;
            }

            default:
                return Color.white;
        }
    }
}
