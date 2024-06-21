package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import album.PhotoAlbum;
import album.Snapshot;
import shapes.IShape;
import shapes.Oval;
import shapes.Shape2D;
import shapes.Rectangle;
import soliddesign.IFactory;
import soliddesign.ShapeFactory;
import transformations.ColorChangeTransformation;
import transformations.ITransformation;
import transformations.MoveTransformation;
import transformations.ResizeTransformation;

/**
 * This is the test suite for class PhotoAlbum.
 */
class PhotoAlbumTest {

    // setup
    private IFactory myFactory;
    private PhotoAlbum myAlbum;
    IShape rectangle1 = new shapes.Rectangle("",10, 20, 100, 200, Color.RED);
    IShape oval1 = new Oval("",50, 60, 30, 40, Color.BLUE);
    Shape2D rectangle2 = new Rectangle("",30, 40, 150, 250, Color.GREEN);
    Shape2D oval2 = new Oval("",70, 80, 35, 45, Color.YELLOW);

    /**
     * This setUp() method adds items and prepare for the test suite.
     */
    @BeforeEach
    void setUp() {
        myAlbum = new PhotoAlbum();
        myFactory = new ShapeFactory();
        IShape clientRectangle = myFactory.create("recTangle");
        IShape clientOval = myFactory.create("OvAl");

        myAlbum.addShape(rectangle1);
        myAlbum.addShape(rectangle2);
        myAlbum.addShape(oval1);
        myAlbum.addShape(oval2);
        myAlbum.addShape(clientRectangle);
        myAlbum.addShape(clientOval);
    }

    /**
     * This is the test case for addShape() method.
     */
    @Test
    void addShape() {
        assertEquals(6, myAlbum.getNumberOfShapes());
        IShape rectangle3 = new shapes.Rectangle("",80, 40, 50, 70, Color.BLUE);
        IShape oval3 = new Oval("",80, 20, 10, 10, Color.YELLOW);
        myAlbum.addShape(rectangle3);
        myAlbum.addShape(oval3);
        assertEquals(8, myAlbum.getNumberOfShapes());
    }

    /**
     * This is the test case for removeShape() method.
     */
    @Test
    void removeShape() {
        assertEquals(6, myAlbum.getNumberOfShapes());
        myAlbum.removeShape(rectangle1);
        assertEquals(5, myAlbum.getNumberOfShapes());
        myAlbum.removeShape(rectangle2);
        assertEquals(4, myAlbum.getNumberOfShapes());
        myAlbum.removeShape(oval1);
        assertEquals(3, myAlbum.getNumberOfShapes());
        myAlbum.removeShape(oval2);
        assertEquals(2, myAlbum.getNumberOfShapes());
    }

    /**
     * This is the test case for getNumberOfShapes() method.
     */
    @Test
    void getNumberOfShapes() {
        assertEquals(6, myAlbum.getNumberOfShapes());

        IShape rectangle3 = new shapes.Rectangle("",80, 40, 50, 70, Color.BLUE);
        myAlbum.addShape(rectangle3);
        assertEquals(7, myAlbum.getNumberOfShapes());

        IShape oval3 = new Oval("",80, 20, 10, 10, Color.YELLOW);
        myAlbum.addShape(oval3);
        assertEquals(8, myAlbum.getNumberOfShapes());
    }

    /**
     * This is the test case for getNumberOfSnapshot() method.
     */
    @Test
    void getNumberOfSnapshot() {
        myAlbum.takeSnapshot();
        assertEquals(1, myAlbum.getNumberOfSnapshots());

        IShape rectangle3 = new shapes.Rectangle("",80, 40, 50, 70, Color.BLUE);
        myAlbum.addShape(rectangle3);
        myAlbum.takeSnapshot();
        assertEquals(2, myAlbum.getNumberOfSnapshots());

        IShape oval3 = new Oval("",80, 20, 10, 10, Color.YELLOW);
        myAlbum.addShape(oval3);
        myAlbum.takeSnapshot();
        assertEquals(3, myAlbum.getNumberOfSnapshots());
    }

    /**
     * This is the test case for getSnapshotsByDate() method.
     */
    @Test
    void getSnapshotsByDate() {
        IShape whatever = new Rectangle("",0, 0, 10, 20, Color.RED);
        myAlbum.addShape(whatever);
        myAlbum.takeSnapshot();
        String todayDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        List<Snapshot> snapshots = myAlbum.getSnapshotsByDate(todayDate);
        assertEquals(1, snapshots.size());
    }

    /**
     * This is the test case for applyTransformation() method.
     * This is specially for color.
     */
    @Test
    void applyColorTransformation() {
        // Change to green
        ITransformation colorTrans = new ColorChangeTransformation(0, 255, 0);
        List<IShape> myShapes = new ArrayList<>();
        myShapes.add(rectangle2);
        myShapes.add(oval2);

        myAlbum.applyTransformation(colorTrans, myShapes);

        // the color of the selected shapes are changed
        assertEquals(new Color(0, 255, 0), rectangle2.getColor());
        assertEquals(new Color(0, 255, 0), oval2.getColor());

        // the color of remaining shapes unchanged.
        assertEquals(new Color(255, 0, 0), rectangle1.getColor());
        assertEquals(new Color(0, 0, 255), oval1.getColor());
    }

    /**
     * This is the test case for applyTransformation() method.
     * This is specially for resize.
     */
    @Test
    void applySizeTransformation() {
        // set new size
        ITransformation sizeTrans1 = new ResizeTransformation(100, 100);
        List<IShape> myShapes = new ArrayList<>();
        myShapes.add(rectangle2);
        myShapes.add(oval2);

        myAlbum.applyTransformation(sizeTrans1, myShapes);

        // the size of the selected shapes are changed
        assertEquals(100, rectangle2.getDimensionX());
        assertEquals(100, rectangle2.getDimensionY());
        assertEquals(100, oval2.getDimensionX());
        assertEquals(100, oval2.getDimensionY());

        // the size of remaining shapes unchanged.
        assertEquals(100, rectangle1.getDimensionX());
        assertEquals(200, rectangle1.getDimensionY());
        assertEquals(30, oval1.getDimensionX());
        assertEquals(40, oval1.getDimensionY());
    }

    /**
     * This is the test case for applyTransformation() method.
     * This is specially for move.
     */
    @Test
    void applyMoveTransformation() {
        // move to new location
        ITransformation moveTrans1 = new MoveTransformation(10, -10);
        List<IShape> myShapes = new ArrayList<>();
        myShapes.add(rectangle2);
        myShapes.add(oval2);

        myAlbum.applyTransformation(moveTrans1, myShapes);

        // the size of the selected shapes are changed
        assertEquals(40, rectangle2.getX());
        assertEquals(30, rectangle2.getY());
        assertEquals(80, oval2.getX());
        assertEquals(70, oval2.getY());

        // the size of remaining shapes unchanged.
        assertEquals(10, rectangle1.getX());
        assertEquals(20, rectangle1.getY());
        assertEquals(50, oval1.getX());
        assertEquals(60, oval1.getY());
    }

    /**
     * This is the test case for takeSnapshot() method.
     */
    @Test
    void takeSnapshot() {
        myAlbum.takeSnapshot();
        assertEquals(1, myAlbum.getNumberOfSnapshots());

        IShape rectangle3 = new shapes.Rectangle("",80, 40, 50, 70, Color.BLUE);
        myAlbum.addShape(rectangle3);
        myAlbum.takeSnapshot();
        assertEquals(2, myAlbum.getNumberOfSnapshots());

        IShape oval3 = new Oval("",80, 20, 10, 10, Color.YELLOW);
        myAlbum.addShape(oval3);
        myAlbum.takeSnapshot();
        assertEquals(3, myAlbum.getNumberOfSnapshots());
    }

    /**
     * This is the test case for takeSnapshot(String description) method.
     */
    @Test
    void takeSnapshotWithDescription(){
        myAlbum.takeSnapshot("some description");
        assertEquals(1, myAlbum.getNumberOfSnapshots());
        Snapshot snapshot=myAlbum.getSnapshots().get(0);
        assertEquals(snapshot.getDescription(),"some description");
    }

    /**
     * This is the test case for getShapesByName(String name) method.
     */
    @Test
    void getShapesByName(){
        IShape rectangle1 = new shapes.Rectangle("name1",10, 20, 100, 200, Color.RED);
        PhotoAlbum myAlbum = new PhotoAlbum();
        myAlbum.addShape(rectangle1);
        IShape rectangle2 = myAlbum.getShapesByName("name1").get(0);
        assertEquals(rectangle2.getName(),"name1");
    }

    /**
     * This is the test case for getSnapshots() method.
     */
    @Test
    void getShapes(){
        myAlbum.takeSnapshot("some description");
        List<Snapshot> snapshots = myAlbum.getSnapshots();
        assertEquals(1,snapshots.size());
        Snapshot snapshot=snapshots.get(0);
        assertEquals(snapshot.getDescription(),"some description");
    }

    /**
     * This is the test case for resetSnapshot() method.
     */
    @Test
    void resetSnapshot() {
        myAlbum.takeSnapshot();
        assertEquals(1, myAlbum.getNumberOfSnapshots());

        IShape rectangle3 = new shapes.Rectangle("",80, 40, 50, 70, Color.BLUE);
        myAlbum.addShape(rectangle3);
        myAlbum.takeSnapshot();
        assertEquals(2, myAlbum.getNumberOfSnapshots());

        IShape oval3 = new Oval("",80, 20, 10, 10, Color.YELLOW);
        myAlbum.addShape(oval3);
        myAlbum.takeSnapshot();
        assertEquals(3, myAlbum.getNumberOfSnapshots());

        myAlbum.resetSnapshots();
        assertEquals(0, myAlbum.getNumberOfSnapshots());
    }

    /**
     * This is the test case for renderPhotoAlbum() method.
     */
    @Test
    void renderPhotoAlbum() {
        assertEquals("Name: R\n"
                        + "Type: rectangle\n"
                        + "Min corner: (10.0,20.0), Width: 100.0, Height: 200.0, Color: (1.0,0.0,0.0)\n"
                        + "\n" + "Name: R\n" + "Type: rectangle\n"
                        + "Min corner: (30.0,40.0), Width: 150.0, Height: 250.0, Color: (0.0,1.0,0.0)\n"
                        + "\n" + "Name: O\n" + "Type: oval\n"
                        + "Center: (50.0,60.0), X radius: 30.0, Y radius: 40.0, Color: (0.0,0.0,1.0)\n"
                        + "\n" + "Name: O\n" + "Type: oval\n"
                        + "Center: (70.0,80.0), X radius: 35.0, Y radius: 45.0, Color: (1.0,1.0,0.0)\n"
                        + "\n" + "Name: R\n" + "Type: rectangle\n"
                        + "Min corner: (0.0,0.0), Width: 50.0, Height: 50.0, Color: (1.0,0.0,0.0)\n" +
                        "\n" + "Name: O\n" + "Type: oval\n"
                        + "Center: (0.0,0.0), X radius: 50.0, Y radius: 50.0, Color: (1.0,0.0,0.0)\n" +
                        "\n"
                , myAlbum.renderPhotoAlbum());
    }

    /**
     * This is the test case for getSnapshotTimestamps() method.
     * This is specially for empty snapshots.
     */
    @Test
    void getSnapshotTimestamps_empty() {
        assertTrue(myAlbum.getSnapshotTimestamps()
                .contains("List of snapshots taken before reset: []"));
    }

    /**
     * This is the test case for getSnapshotTimestamps() method.
     * This is specially for non-empty snapshots.
     */
    @Test
    void getSnapshotTimestamps_non_empty() {
        String timestamps = myAlbum.getSnapshotTimestamps();
        assertTrue(timestamps.startsWith("List of snapshots taken before reset: [")
                && timestamps.endsWith("]"));
    }

    /**
     * This is the test case for renderSnapshot() method.
     * This is specially for empty snapshots.
     */
    @Test
    void renderSnapshot_empty() {
        String renderedSnapshot = myAlbum.renderSnapshot();
        assertTrue(renderedSnapshot.contains("List of snapshots taken before reset: []"));
        assertTrue(renderedSnapshot.contains("Printing Snapshots"));
    }

    /**
     * This is the test case for renderSnapshot() method.
     * This is specially for non-empty snapshots.
     */
    @Test
    void renderSnapshot_non_empty() {
        myAlbum.takeSnapshot();
        String renderedSnapshot = myAlbum.renderSnapshot();
        assertTrue(renderedSnapshot.contains("List of snapshots taken before reset: ["));
        assertTrue(renderedSnapshot.contains("Printing Snapshots"));
        assertTrue(renderedSnapshot.contains(rectangle1.getDescription())
                && renderedSnapshot.contains(rectangle2.getDescription()));
    }
}
