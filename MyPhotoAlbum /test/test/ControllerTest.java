package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import controller.Controller;
import org.junit.jupiter.api.Test;
import album.Snapshot;
import shapes.IShape;
import shapes.Rectangle;
import java.util.List;

/**
 * This is the test suite for controller in this MVC architect.
 */
class ControllerTest {

    // set up a controller for testing purpose
    Controller controller = new Controller("buildings.txt",800,800);

    /**
     * This is the test case for getWidth() method.
     */
    @Test
    void getWidth() {
        assertEquals(controller.getWidth(),800);
    }

    /**
     * This is the test case for getHeight() method.
     */
    @Test
    void getHeight() {
        assertEquals(controller.getHeight(),800);
    }

    /**
     * This is the test case for hasNextSnapshot() method.
     * It tests the both sides of hasNextSnapshots() method.
     */
    @Test
    void hasNextSnapshot() {
        for (int i = 0; i < 3; i++) {
            assertTrue(controller.hasNextSnapshot());
            controller.nextSnapshot();
        }
        assertFalse(controller.hasNextSnapshot());
    }

    /**
     * This is the test case for hasPreviousSnapshot() method.
     * State change included.
     */
    @Test
    void hasPreviousSnapshot() {
        assertFalse(controller.hasPreviousSnapshot());
        controller.nextSnapshot();
        controller.nextSnapshot();
        assertTrue(controller.hasPreviousSnapshot());
    }

    /**
     * This is the test case for getCurrentSnapshot() method.
     */
    @Test
    void getCurrentSnapshot() {
        controller.nextSnapshot();
        Snapshot snapshot = controller.getCurrentSnapshot();
        List<IShape> shapes = snapshot.getShapes();
        assertEquals(9, shapes.size());

        for (IShape shape : shapes){
            assertTrue(shape instanceof Rectangle);
        }
    }

    /**
     * This is the test case for getSnapshotByIndex() method.
     */
    @Test
    void getSnapshotByIndex() {
        Snapshot snapshot = controller.getSnapshotByIndex(0);
        List<IShape> shapes = snapshot.getShapes();
        assertEquals(9, shapes.size());

        for (IShape shape : shapes) {
            assertTrue(shape instanceof Rectangle);
        }
    }

    /**
     * This is the test case for getAllSnapshotTimestamps() method.
     */
    @Test
    void getAllSnapshotTimestamps() {
        String[] timestamps = controller.getAllSnapshotTimestamps();
        assertEquals(3, timestamps.length);
    }
}
