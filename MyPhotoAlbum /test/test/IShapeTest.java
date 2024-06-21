package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import java.awt.Color;
import org.junit.jupiter.api.Test;
import shapes.IShape;
import shapes.Oval;
import shapes.Triangle;
import shapes.Rectangle;
import shapes.Shape2D;

/**
 * This is the test suite for IShape interface and its concrete classes.
 * It provides a 100% on the interface and all the concrete classes.
 */
class IShapeTest {
    //setup
    IShape rectangle1 = new shapes.Rectangle("",10, 20, 100, 200, Color.red);
    IShape oval1 = new Oval("",50, 60, 30, 40, Color.BLUE);
    Shape2D rectangle2 = new Rectangle("",30, 40, 150, 250, Color.GREEN);
    Shape2D oval2 = new Oval("",70, 80, 35, 45, Color.YELLOW);
    IShape triangle1 = new Triangle("",10, 20, 25, 200, Color.GREEN);
    IShape triangle2 = new Triangle("",50, 60, 30, 30, Color.BLUE);

    /**
     * This is the test case for bad creations.
     */
    @org.junit.jupiter.api.Test
    void badCreations() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Shape2D rectangle1 = new shapes.Rectangle("",10, 20, 0, 200, Color.RED);
            Shape2D oval1 = new Oval("",50, 60, 30, 0, Color.BLUE);
            Shape2D rectangle2 = new Rectangle("",30, 40, -150, 250, Color.GREEN);
            Shape2D oval2 = new Oval("",70, 80, 35, -45, Color.YELLOW);
            IShape triangle1 = new Triangle("",10, 20, 25, 200, null);
            IShape triangle2 = new Triangle("",50, 60, 30, 30, null);
        });
    }

    /**
     * This is the test case for default creations.
     */
    @org.junit.jupiter.api.Test
    void defaultCreations() {
        Shape2D defaultRectangle = new Rectangle();
        Shape2D defaultOval = new Oval();
        Shape2D defaultTriangle = new Triangle();
    }

    /**
     * This is the test case for bad changeColor().
     */
    @org.junit.jupiter.api.Test
    void badChangeColor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rectangle1.changeColor(-1, 0, 0);
            oval1.changeColor(0, -1, 255);
            triangle1.changeColor(245, 36, -1);
        });
    }

    /**
     * This is the test case clone().
     */
    @Test
    void testClone(){
        IShape rectangle = rectangle1.clone();
        rectangle1.resize(10,20);
        assertEquals(rectangle.getDimensionX(),100);
        assertEquals(rectangle.getDimensionY(),200);
        assertEquals(rectangle1.getDimensionX(),10);
        assertEquals(rectangle1.getDimensionY(),20);
    }

    /**
     * This is the test case for bad resize().
     */
    @org.junit.jupiter.api.Test
    void badResize() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rectangle1.resize(0, 0);
            oval1.resize(-1, 0);
            triangle1.resize(-32, -99);
        });
    }

    /**
     * This is the test case for move() method.
     */
    @org.junit.jupiter.api.Test
    void move() {
        // for rectangles
        rectangle1.move(20, -20);
        assertEquals(30, rectangle1.getX());
        assertEquals(0, rectangle1.getY());

        rectangle2.move(25, -25);
        assertEquals(55, rectangle2.getX());
        assertEquals(15, rectangle2.getY());

        // ovals
        oval1.move(20, -10);
        assertEquals(70, oval1.getX());
        assertEquals(50, oval1.getY());

        oval2.move(-35, 10);
        assertEquals(35, oval2.getX());
        assertEquals(90, oval2.getY());

        // for triangles
        triangle1.move(20, -10);
        assertEquals(30, triangle1.getX());
        assertEquals(10, triangle1.getY());

        triangle2.move(-35, 10);
        assertEquals(15, triangle2.getX());
        assertEquals(70, triangle2.getY());
    }

    /**
     * This is the test case for changeColor() method.
     */
    @org.junit.jupiter.api.Test
    void changeColor() {
        // for rectangles
        rectangle1.changeColor(0, 255, 0);
        assertEquals(Color.GREEN, rectangle1.getColor());

        rectangle2.changeColor(255, 0, 0);
        assertEquals(Color.RED, rectangle2.getColor());

        // for ovals
        oval1.changeColor(255, 0, 0);
        assertEquals(Color.RED, oval1.getColor());

        oval2.changeColor(255, 0, 0);
        assertEquals(Color.RED, oval2.getColor());

        // for triangles
        triangle1.changeColor(255, 0, 0);
        assertEquals(Color.RED, triangle1.getColor());

        triangle2.changeColor(255, 0, 0);
        assertEquals(Color.RED, triangle2.getColor());
    }

    /**
     * This is the test case for resize() method.
     */
    @org.junit.jupiter.api.Test
    void resize() {
        // for rectangles
        rectangle1.resize(100, 200);
        assertEquals(100, rectangle1.getDimensionX());
        assertEquals(200, rectangle1.getDimensionY());

        rectangle2.resize(100, 200);
        assertEquals(100, rectangle1.getDimensionX());
        assertEquals(200, rectangle1.getDimensionY());

        // for ovals
        oval1.resize(20, 25);
        assertEquals(20, oval1.getDimensionX());
        assertEquals(25, oval1.getDimensionY());

        oval2.resize(50, 60);
        assertEquals(50, oval2.getDimensionX());
        assertEquals(60, oval2.getDimensionY());

        // for triangles
        triangle1.resize(20, 25);
        assertEquals(20, triangle1.getDimensionX());
        assertEquals(25, triangle1.getDimensionY());

        triangle2.resize(50, 60);
        assertEquals(50, triangle2.getDimensionX());
        assertEquals(60, triangle2.getDimensionY());
    }

    /**
     * This is the test case for getDescription() method.
     */
    @org.junit.jupiter.api.Test
    void getDescription() {
        // for rectangles
        assertEquals("Name: R\n"
                        + "Type: rectangle\n"
                        + "Min corner: (10.0,20.0), Width: 100.0, Height: 200.0, Color: (1.0,0.0,0.0)"
                , rectangle1.getDescription());

        assertEquals("Name: R\n"
                        + "Type: rectangle\n"
                        + "Min corner: (30.0,40.0), Width: 150.0, Height: 250.0, Color: (0.0,1.0,0.0)"
                , rectangle2.getDescription());

        // for ovals
        assertEquals("Name: O\n"
                        + "Type: oval\n"
                        + "Center: (50.0,60.0), X radius: 30.0, Y radius: 40.0, Color: (0.0,0.0,1.0)"
                , oval1.getDescription());

        assertEquals("Name: O\n"
                        + "Type: oval\n"
                        + "Center: (70.0,80.0), X radius: 35.0, Y radius: 45.0, Color: (1.0,1.0,0.0)"
                , oval2.getDescription());

        // for triangles
        assertEquals("Name: T\n"
                        + "Type: triangle\n"
                        + "Vertex: (10,20), Base: 25, Height: 200, Color: (0.0,1.0,0.0)"
                , triangle1.getDescription());

        assertEquals("Name: T\n"
                        + "Type: triangle\n"
                        + "Vertex: (50,60), Base: 30, Height: 30, Color: (0.0,0.0,1.0)"
                , triangle2.getDescription());
    }
}
