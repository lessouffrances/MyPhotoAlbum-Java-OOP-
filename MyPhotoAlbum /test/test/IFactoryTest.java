package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import soliddesign.ShapeFactory;
import shapes.IShape;
import shapes.Rectangle;
import shapes.Oval;
import shapes.Triangle;

/**
 * This is the test suite for IFactory interface and its concrete classes.
 */
class IFactoryTest {
    // setup
    private ShapeFactory shapeFactory = new ShapeFactory();

    /**
     * This is the test case for creating a rectangle.
     */
    @Test
    void testCreateRectangle() {
        IShape rectangle = shapeFactory.create("Rectangle");
        assertNotNull(rectangle);
        assertTrue(rectangle instanceof Rectangle);
    }

    /**
     * This is the test case for creating an oval.
     */
    @Test
    void testCreateOval() {
        IShape oval = shapeFactory.create("Oval");
        assertNotNull(oval);
        assertTrue(oval instanceof Oval);
    }

    /**
     * This is the test case for creating a triangle.
     */
    @Test
    void testCreateTriangle() {
        IShape triangle = shapeFactory.create("Triangle");
        assertNotNull(triangle);
        assertTrue(triangle instanceof Triangle);
    }

    /**
     * This is the test for creating an invalid shape.
     */
    @Test
    void testCreateInvalidShape() {
        IShape invalidShape = shapeFactory.create("InvalidShape");
        assertNull(invalidShape);
    }
}
