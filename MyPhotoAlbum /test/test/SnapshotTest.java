package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import album.PhotoAlbum;
import album.Snapshot;
import shapes.IShape;
import shapes.Shape2D;
import shapes.Oval;
import shapes.Rectangle;

/**
 * This is the test suite for class Snapshot.
 * It provides a 100% test coverage on class Snapshot.
 */
class SnapshotTest {

    // setup
    private PhotoAlbum myAlbum;
    IShape rectangle1 = new shapes.Rectangle("",10, 20, 100, 200, Color.RED);
    IShape oval1 = new Oval("",50, 60, 30, 40, Color.BLUE);
    Shape2D rectangle2 = new Rectangle("",30, 40, 150, 250, Color.GREEN);
    Shape2D oval2 = new Oval("",70, 80, 35, 45, Color.YELLOW);
    List<IShape> shapes = Arrays.asList(rectangle1, rectangle2, oval1, oval2);
    Snapshot mySnapshot = new Snapshot(shapes,"");

    /**
     * This setUp() method adds items to the list and prepare for the test.
     */
    @BeforeEach
    void setUp() {
        myAlbum = new PhotoAlbum();
        myAlbum.addShape(rectangle1);
        myAlbum.addShape(rectangle2);
        myAlbum.addShape(oval1);
        myAlbum.addShape(oval2);
    }

    /**
     * This is the test case for creation.
     */
    @Test
    public void testSnapshotCreation() {
        List<IShape> shapes = Arrays.asList(rectangle1, rectangle2, oval1, oval2);
        Snapshot mySnapshot = new Snapshot(shapes,"");
    }

    /**
     * This is the test case for getShapes().
     */
    @Test
    public void getShapes(){
        List<IShape> shapes = Arrays.asList(rectangle1, rectangle2, oval1, oval2);
        Snapshot mySnapshot = new Snapshot(shapes,"");
        List<IShape> shapes1 = mySnapshot.getShapes();
        assertEquals(shapes1.size(),4);
    }

    /**
     * This is the test case for getDescription().
     */
    @Test
    public void getDescription() {
        List<IShape> shapes = Arrays.asList(rectangle1, rectangle2, oval1, oval2);
        Snapshot mySnapshot = new Snapshot(shapes,"description");
        assertEquals(mySnapshot.getDescription(),"description");
    }

    /**
     * This is the test case for getTimestamp() method.
     */
    @Test
    void getTimestamp() {
        LocalDateTime timestamp = mySnapshot.getTimestamp();
        assertTrue(timestamp.isBefore(LocalDateTime.now().plusSeconds(1))
                && timestamp.isAfter(LocalDateTime.now().minusSeconds(1)));
    }

    /**
     * This is the test case for getTimestampString() method.
     */
    @Test
    void getTimestampString() {
        String timestampString = mySnapshot.getTimestampString();
        assertEquals(mySnapshot.getTimestamp().toString(), timestampString);
    }

    /**
     * This is the test case for toString() method.
     */
    @Test
    void ToString() {
        String snapshotString = mySnapshot.toString();
        assertTrue(snapshotString.contains("Snapshot ID:"));
        assertTrue(snapshotString.contains("Timestamp:"));
        assertTrue(snapshotString.contains("Description:"));
        assertTrue(snapshotString.contains("Shape Information:"));

        for (IShape shape : shapes) {
            assertTrue(snapshotString.contains(shape.getDescription()));
        }
    }
}
