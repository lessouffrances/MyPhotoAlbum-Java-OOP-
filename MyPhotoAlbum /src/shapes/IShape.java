package shapes;

import java.awt.Color;

/**
 * This is the IShape interface,
 * it provides contract that each Shape2D class has to adhere to.
 */
public interface IShape {

    /**
     * This is the move() method.
     * @param deltaX is the change in X coordinate of the underlying shape,
     * @param deltaY is the change in Y coordinate of the underlying shape.
     */
    void move(int deltaX, int deltaY);

    /**
     * This is the changeColor() method.
     * It changes the color of the shape by setting the RGB.
     * @param red   is the degree of red in RGB.
     * @param green is the degree of red in RGB.
     * @param blue  is the degree of red in RGB.
     */
    void changeColor(int red, int green, int blue);

    /**
     * This is the resize() method.
     * It resizes the shape by inputting new scales.
     * @param newX is the new dimensionX.
     * @param newY is the new dimensionY.
     */
    void resize(int newX, int newY);

    /**
     * This is the getX() method.
     * @return the X coordinate of the shape.
     */
    int getX();

    /**
     * This is the getY() method.
     * @return the Y coordinate of the shape.
     */
    int getY();

    /**
     * This is the getDimensionX() method.
     * @return the dimensionX of the shape.
     */
    int getDimensionX();

    /**
     * This is the getDimensionY() method.
     * @return the dimensionY of the shape.
     */
    int getDimensionY();

    /**
     * This is the getColor() method.
     * @return the color of the shape.
     */
    Color getColor();

    /**
     * This is the getDescription() method.
     * @return the description of the underlying shape.
     */
    String getDescription();

    /**
     * This is the getName() method.
     * @return the name of the shape
     */
    String getName();

    /**
     * This is the clone() method.
     * @return a deep copy of the shape.
     */
    IShape clone();
}
