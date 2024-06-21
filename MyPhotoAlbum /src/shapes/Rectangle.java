package shapes;

import java.awt.Color;

/**
 * This is the class Rectangle,
 * one of the Child classes of class Shape2D.
 */
public class Rectangle extends Shape2D {

    /**
     * This is the constructor for class Rectangle.
     * @param x          is the X coordinate of the shape.
     * @param y          is the y coordinate of the shape.
     * @param dimensionX is the dimensionX of the shape.
     * @param dimensionY is the dimensionY of the shape.
     * @param color  is the color of the shape.
     */
    public Rectangle(String name,int x, int y, int dimensionX, int dimensionY, Color color) {
        super(name,x, y, dimensionX, dimensionY, color);
    }

    /**
     * This is the default constructor for class Rectangle.
     */
    public Rectangle() {
        super();
    }

    /**
     * This is the getDescription() method.
     * @return the description of the underlying shape.
     */
    @Override
    public String getDescription() {
        return String.format("Name: R\nType: rectangle\nMin corner: (%.1f,%.1f), "
                        + "Width: %.1f, Height: %.1f, Color: (%.1f,%.1f,%.1f)"
                , (float) x, (float) y, (float) dimensionX
                , (float) dimensionY, (float) color.getRed() / 255
                , (float) color.getGreen() / 255, (float) color.getBlue() / 255);
    }

    /**
     * This is the clone() method.
     * @return a deep copy of the rectangle instance.
     */
    @Override
    public IShape clone() {
        return new Rectangle(name, x, y, dimensionX, dimensionY, color);
    }
}
