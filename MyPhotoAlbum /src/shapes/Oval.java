package shapes;

import java.awt.Color;

/**
 * This is the class Oval,
 * one of the Child classes of class Shape2D.
 */
public class Oval extends Shape2D {

    /**
     * This is the constructor for class Oval.
     * @param x          is the X coordinate of the shape.
     * @param y          is the y coordinate of the shape.
     * @param dimensionX is the dimensionX of the shape.
     * @param dimensionY is the dimensionY of the shape.
     * @param color  is the colorEnum that the shape can set color from.
     */
    public Oval(String name,int x, int y, int dimensionX, int dimensionY, Color color) {
        super(name,x, y, dimensionX, dimensionY, color);
    }

    /**
     * This is the default constructor for class Oval.
     */
    public Oval() {
        super();
    }

    /**
     * This is the getDescription() method.
     * @return the description of the underlying shape.
     */
    @Override
    public String getDescription() {
        return String.format("Name: O\nType: oval\nCenter: (%.1f,%.1f)"
                        + ", X radius: %.1f, Y radius: %.1f, Color: (%.1f,%.1f,%.1f)"
                , (float) x, (float) y, (float) dimensionX
                , (float) dimensionY, (float) color.getRed() / 255
                , (float) color.getGreen() / 255, (float) color.getBlue() / 255);
    }

    /**
     * This is the clone() method.
     * @return a deep copy of the oval instance.
     */
    @Override
    public IShape clone() {
        return new Oval(name, x, y, dimensionX, dimensionY, color);
    }
}
