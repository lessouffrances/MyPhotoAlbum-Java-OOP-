package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.awt.Color;
import transformations.ColorChangeTransformation;
import transformations.ITransformation;
import transformations.MoveTransformation;
import transformations.ResizeTransformation;
import shapes.IShape;
import shapes.Shape2D;
import shapes.Rectangle;
import shapes.Oval;

/**
 * This is the test suite for ITransformation interface and its concrete classes.
 * It provides a 100% on the interface and all the concrete classes.
 */
class ITransformationTest {
    IShape rectangle1 = new shapes.Rectangle("",10, 20, 100, 200, Color.RED);
    IShape oval1 = new Oval("",50, 60, 30, 40, Color.BLUE);
    Shape2D rectangle2 = new Rectangle("",30, 40, 150, 250, Color.GREEN);
    Shape2D oval2 = new Oval("",70, 80, 35, 45, Color.YELLOW);

    /**
     * This is the test for bad creations for class ColorChangeTransformation.
     */
    @Test
    void badColorChangeTransformationCreation() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ITransformation colorTrans1 = new ColorChangeTransformation(-1, 120, 0);
            ITransformation colorTrans2 = new ColorChangeTransformation(150, -1, 0);
            ColorChangeTransformation colorTrans3 = new ColorChangeTransformation(12, 35, -1);
        });
    }

    /**
     * This is the test for bad creations for class ResizeTransformation.
     */
    @Test
    void badResizeTransformationCreation() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ITransformation sizeTrans1 = new ResizeTransformation(0, 100);
            ResizeTransformation sizeTrans2 = new ResizeTransformation(200, 0);
            ITransformation sizeTrans3 = new ResizeTransformation(-100, 100);
            ResizeTransformation sizeTrans4 = new ResizeTransformation(200, -200);
        });
    }

    /**
     * This is the test case for apply() method,
     * which in class ColorChangeTransformation.
     */
    @Test
    void applyColorChangeTransformation() {
        ITransformation colorTrans1 = new ColorChangeTransformation(150, 120, 0);
        ColorChangeTransformation colorTrans2 = new ColorChangeTransformation(12, 35, 245);

        colorTrans1.apply(rectangle1);
        assertEquals(new Color(150, 120, 0), rectangle1.getColor());

        colorTrans2.apply(rectangle1);
        assertEquals(new Color(12, 35, 245), rectangle1.getColor());

        colorTrans1.apply(oval1);
        assertEquals(new Color(150, 120, 0), oval1.getColor());

        colorTrans2.apply(oval2);
        assertEquals(new Color(12, 35, 245), oval2.getColor());
    }

    /**
     * This is the test case for apply() method,
     * which in class MoveTransformation.
     */
    @Test
    void applyMoveTransformation() {
        ITransformation moveTrans1 = new MoveTransformation(10, -10);
        MoveTransformation moveTrans2 = new MoveTransformation(0, 0);

        moveTrans1.apply(rectangle1);
        assertEquals(20, rectangle1.getX());
        assertEquals(10, rectangle1.getY());

        moveTrans2.apply(rectangle1);
        assertEquals(20, rectangle1.getX());
        assertEquals(10, rectangle1.getY());

        moveTrans1.apply(rectangle2);
        assertEquals(40, rectangle2.getX());
        assertEquals(30, rectangle2.getY());

        moveTrans2.apply(rectangle2);
        assertEquals(40, rectangle2.getX());
        assertEquals(30, rectangle2.getY());

        moveTrans1.apply(oval1);
        assertEquals(60, oval1.getX());
        assertEquals(50, oval1.getY());

        moveTrans2.apply(oval1);
        assertEquals(60, oval1.getX());
        assertEquals(50, oval1.getY());

        moveTrans1.apply(oval2);
        assertEquals(80, oval2.getX());
        assertEquals(70, oval2.getY());

        moveTrans2.apply(oval2);
        assertEquals(80, oval2.getX());
        assertEquals(70, oval2.getY());
    }

    /**
     * This is the test case for apply() method,
     * which in class ResizeTransformation.
     */
    @Test
    void applyResizeTransformation() {
        ITransformation sizeTrans1 = new ResizeTransformation(100, 100);
        ResizeTransformation sizeTrans2 = new ResizeTransformation(200, 200);

        sizeTrans1.apply(rectangle1);
        assertEquals(100, rectangle1.getDimensionX());
        assertEquals(100, rectangle1.getDimensionY());

        sizeTrans2.apply(rectangle1);
        assertEquals(200, rectangle1.getDimensionX());
        assertEquals(200, rectangle1.getDimensionY());

        sizeTrans1.apply(rectangle2);
        assertEquals(100, rectangle2.getDimensionX());
        assertEquals(100, rectangle2.getDimensionY());

        sizeTrans2.apply(rectangle2);
        assertEquals(200, rectangle2.getDimensionX());
        assertEquals(200, rectangle2.getDimensionY());

        sizeTrans1.apply(oval1);
        assertEquals(100, oval1.getDimensionX());
        assertEquals(100, oval1.getDimensionY());

        sizeTrans2.apply(oval1);
        assertEquals(200, oval1.getDimensionX());
        assertEquals(200, oval1.getDimensionY());

        sizeTrans1.apply(oval2);
        assertEquals(100, oval2.getDimensionX());
        assertEquals(100, oval2.getDimensionY());

        sizeTrans2.apply(oval2);
        assertEquals(200, oval2.getDimensionX());
        assertEquals(200, oval2.getDimensionY());
    }
}