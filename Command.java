package com.company;

public class Command {

    private String shape;
    private Point[] coordinates;
    private Point center;
    private int radius;
    private String colour;
    private String fill;

    public Command(String shape, Point[] coordinates, String colour, String fill) {
        this.shape = shape;
        this.coordinates = coordinates;
        this.colour = colour;
        this.fill = fill;
    }

    public Command(String shape, Point center, int radius, String colour, String fill) {
        this.shape = shape;
        this.center = center;
        this.radius = radius;
        this.colour = colour;
        this.fill = fill;
    }

    public String getShape() {
        return shape;
    }

    public Point[] getCoordinates() {
        return coordinates;
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public String getColour() {
        return colour;
    }

    public String getFill() {
        return fill;
    }
}
