package com.company;

public class Rectangle implements IShape{

    private Point point1;
    private Point point2;
    private String colour;
    private String fill;

    public Rectangle(Point point1, Point point2, String colour, String fill) {
        this.point1 = point1;
        this.point2 = point2;
        this.colour = colour;
        this.fill = fill;
    }

    public void draw() {
        Draw.commandsToRun.add(new Command("rectangle", new Point[]{point1, point2}, colour, fill));
    }
}