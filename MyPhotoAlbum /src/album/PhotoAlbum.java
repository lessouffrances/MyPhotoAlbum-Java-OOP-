package album;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import transformations.ITransformation;
import shapes.IShape;

/**
 * The PhotoAlbum class manages a list of shapes and snapshots,
 * and it can take snapshots of the current state of shapes.
 * All these methods belong to this class are of an "album" level.
 */
public class PhotoAlbum implements IPhotoAlbum {
    private List<IShape> shapes = new ArrayList<>();
    private List<Snapshot> snapshots = new ArrayList<>();

    /**
     * This is the addShape() method.
     * @param shape is the newly-added shape.
     */
    public void addShape(IShape shape) {
        shapes.add(shape);
    }

    /**
     * This is the removeShape() method.
     * @param shape is the recently-removed shape.
     */
    public void removeShape(IShape shape) {
        if (shapes.contains(shape)) {
            shapes.remove(shape);
        }
    }

    /**
     * This is the getSnapshotsByDate() method.
     * This method belongs to this class is of an "album" level.
     * @param dateString is the date information that required for retrieval.
     * @return the list of snapshots taken on the passed-in date.
     */
    public List<Snapshot> getSnapshotsByDate(String dateString) {
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);

        return snapshots.stream()
                .filter(snapshot -> snapshot.getTimestamp().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

    /**
     * This is the applyTransformation() method.
     * This method belongs to this class is of an "album" level.
     * @param transformation is the transformation to be applied.
     * @param selectedShapes are the shapes selected to receive the passed-in transformation.
     */
    public void applyTransformation(ITransformation transformation, List<IShape> selectedShapes) {
        for (IShape shape : selectedShapes) {
            transformation.apply(shape);
        }
    }

    /**
     * This is the takeSnapshot() method.
     * This method belongs to this class is of an "album" level.
     */
    public void takeSnapshot() {
        List<IShape> currentShapes = new ArrayList<>(shapes);
        snapshots.add(new Snapshot(currentShapes,""));
    }

    /**
     * This is the takeSnapshot() useful version.
     * Takes a snapshot of the current state of shapes and adds it to the snapshots list.
     * This method creates a deep copy of each shape in the shapes list and adds them to a new list.
     * Then it creates a new Snapshot object with the copied shapes and the provided description,
     * and adds it to the snapshots list.
     * @param description a description of the snapshot
     */
    public void takeSnapshot(String description) {
        List<IShape> currentShapes = new ArrayList<>();
        for(IShape shape : shapes){
            currentShapes.add(shape.clone());
        }
        snapshots.add(new Snapshot(currentShapes,description));
    }

    /**
     * This is the resetSnapshots() method
     * This method belongs to this class is of an "album" level.
     */
    public void resetSnapshots() {
        snapshots.clear();
    }

    /**
     * This is the getNumberOfShapes() method.
     * This method belongs to this class is of an "album" level.
     * @return the number of shapes.
     */
    public int getNumberOfShapes() {
        return shapes.size();
    }

    /**
     * This is the getNumberOfSnapshots() method.
     * This method belongs to this class is of an "album" level.
     * @return the number of snapshots taken.
     */
    public int getNumberOfSnapshots() {
        return snapshots.size();
    }

    /**
     * This is the getSnapshotTimestamps() method.
     * This method belongs to this class is of an "album" level.
     * @return a string of timestamps of snapshots taken.
     */
    public String getSnapshotTimestamps() {
        StringBuilder sb = new StringBuilder();

        sb.append("List of snapshots taken before reset: [");
        for (int i = 0; i < snapshots.size(); i++) {
            sb.append(snapshots.get(i).getTimestampString());
            if (i < snapshots.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * This is the renderSnapshot() method.
     * @return the string representation of the snapshots.
     */
    public String renderSnapshot() {
        StringBuilder sb = new StringBuilder();
        sb.append(getSnapshotTimestamps()).append("\n\n");
        sb.append("Printing Snapshots\n");
        for (Snapshot snapshot : snapshots) {
            sb.append(snapshot).append("\n");
        }
        return sb.toString();
    }

    /**
     * This is the renderPhotoAlbum() method.
     * @return the string representation of the photo album.
     */
    public String renderPhotoAlbum() {
        StringBuilder sb = new StringBuilder();
        for (IShape shape : shapes) {
            sb.append(shape.getDescription()).append("\n\n");
        }
        return sb.toString();
    }

    /**
     * This is the getShapeByName() method.
     * @param name is the name of the shape.
     * @return a list of the shapes that have this name.
     */
    public List<IShape> getShapesByName(String name) {
        List<IShape> selectedShapes = new ArrayList<>();
        for (IShape shape : shapes) {
            if (shape.getName().equals(name)) {
                selectedShapes.add(shape);
            }
        }
        return selectedShapes;
    }

    /**
     * This is the getSnapshots() method.
     * It allows external entities to get access to the snapshots.
     * Returns the list of snapshots.
     * @return the list of snapshots.
     */
    public List<Snapshot> getSnapshots(){
        return snapshots;
    }
}
