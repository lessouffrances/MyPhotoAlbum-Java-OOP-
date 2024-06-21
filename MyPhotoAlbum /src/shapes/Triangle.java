package shapes;

import java.awt.Color;

/**
 * This is the class Triangle,
 * one of the Child classes of class Shape2D.
 */
public class Triangle extends Shape2D {

    /**
     * This is the constructor for class Triangle.
     * @param x          is the X coordinate of the shape.
     * @param y          is the y coordinate of the shape.
     * @param dimensionX is the dimensionX of the shape.
     * @param dimensionY is the dimensionY of the shape.
     * @param color  is the color of the shape.
     */
    public Triangle(String name,int x, int y, int dimensionX, int dimensionY, Color color) {
        super(name,x, y, dimensionX, dimensionY, color);
    }

    /**
     * This is the default constructor for class Triangle.
     */
    public Triangle() {
        super();
    }

    /**
     * This is the getDescription() method.
     * @return the description of the underlying shape.
     */
    @Override
    public String getDescription() {
        return String.format("Name: T\nType: triangle\nVertex: (%d,%d), "
                        + "Base: %d, Height: %d, Color: (%.1f,%.1f,%.1f)"
                , x, y, dimensionX, dimensionY
                , (float) color.getRed() / 255, (float) color.getGreen() / 255
                , (float) color.getBlue() / 255);
    }

    /**
     * This is the clone() method.
     * @return a deep copy of the triangle instance.
     */
    @Override
    public IShape clone() {
        return new Triangle(name, x, y, dimensionX, dimensionY, color);
    }
}
