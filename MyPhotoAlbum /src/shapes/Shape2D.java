package shapes;

import java.awt.Color;

/**
 * This is the class Shape2D,
 * it serves as the Parent class for the concrete shape classes.
 */
public abstract class Shape2D implements IShape {

    protected String name;
    protected int x, y, dimensionX, dimensionY;
    protected Color color;

    /**
     * This is the constructor for class Shape2D.
     * @param name is the name of the shape.
     * @param x is the X coordinate of the shape.
     * @param y is the y coordinate of the shape.
     * @param dimensionX is the dimensionX of the shape.
     * @param dimensionY is the dimensionY of the shape.
     * @param color  is the color of the shape.
     */
    public Shape2D(String name, int x, int y, int dimensionX, int dimensionY, Color color) {
        this.name = name;

        if (dimensionX <= 0 || dimensionY <= 0 || color == null) {
            throw new IllegalArgumentException("Invalid input for dimensions or color!");
        } else {
            this.x = x;
            this.y = y;
            this.dimensionX = dimensionX;
            this.dimensionY = dimensionY;
            this.color = color;
        }
    }

    /**
     * This is the default constructor for class Shape2D.
     */
    public Shape2D() {
        this.x = 0;
        this.y = 0;
        this.dimensionX = 50;
        this.dimensionY = 50;
        this.color = Color.RED;
    }

    /**
     * This is the move() method.
     * @param deltaX is the change in X coordinate of the underlying shape,
     * @param deltaY is the change in Y coordinate of the underlying shape.
     */
    @Override
    public void move(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    /**
     * This is the changeColor() method.
     * It changes the color of the shape by setting the RGB.
     * @param red   is the degree of red in RGB.
     * @param green is the degree of red in RGB.
     * @param blue  is the degree of red in RGB.
     */
    @Override
    public void changeColor(int red, int green, int blue) {
        if (red < 0 || green < 0 || blue < 0) {
            throw new IllegalArgumentException("Input number should in range [0, 255]!");
        } else {
            this.color = new Color(red, green, blue);
        }
    }

    /**
     * This is the resize() method.
     * It resizes the shape by inputting new scales.
     * @param newX is the new dimensionX.
     * @param newY is the new dimensionY.
     */
    @Override
    public void resize(int newX, int newY) {
        if (newX <= 0 || newY <= 0) {
            throw new IllegalArgumentException("Invalid input for dimensions!");
        }
        this.dimensionX = newX;
        this.dimensionY = newY;
    }

    /**
     * This is the getX() method.
     * @return the X coordinate of the shape.
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * This is the getY() method.
     * @return the Y coordinate of the shape.
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * This is the getDimensionX() method.
     * @return the dimensionX of the shape.
     */
    @Override
    public int getDimensionX() {
        return this.dimensionX;
    }

    /**
     * This is the getDimensionY() method.
     * @return the dimensionY of the shape.
     */
    @Override
    public int getDimensionY() {
        return this.dimensionY;
    }

    /**
     * This is the getColor() method.
     * @return the color of the shape.
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * This is the getDescription() abstract method.
     * @return the description of the underlying shape.
     */
    @Override
    public abstract String getDescription();

    /**
     * This is the getName() method.
     * @return the name of the shape
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * This is the clone() abstract method.
     * @return a deep copy of the shape.
     */
    @Override
    public abstract IShape clone();
}
