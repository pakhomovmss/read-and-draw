package com.company;

public class Triangle implements IShape{
    private Point point1;
    private Point point2;
    private Point point3;
    private String colour;
    private String fill;

    public Triangle(Point point1, Point point2, Point point3, String colour, String fill) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.colour = colour;
        this.fill = fill;
    }

    public void draw() {
        Draw.commandsToRun.add(new Command("triangle", new Point[]{point1, point2, point3}, colour, fill));
    }
}