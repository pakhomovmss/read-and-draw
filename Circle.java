package com.company;

public class Circle implements IShape{

    private int radius;
    private Point center;
    private String colour;
    private String fill;

    public Circle(Point center, int radius, String colour, String fill) {
        this.center = center;
        this.radius = radius;
        this.colour = colour;
        this.fill = fill;
    }

    public void draw() {
        Draw.commandsToRun.add(new Command("circle", center, radius, colour, fill));
    }
}