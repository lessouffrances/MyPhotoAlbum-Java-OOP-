package album;

import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import shapes.IShape;

/**
 * The Snapshot class represents a snapshot of the shapes' state
 * and provides a toString method to render the snapshot as a string.
 * All methods belong to this class are about Snapshot.
 */
public class Snapshot implements ISnapshot {
    private String description;
    private List<IShape> shapes;
    private LocalDateTime timestamp;

    /**
     * This is the constructor for the class Snapshot.
     * @param shapes is the shapes exist when the snapshot is taken.
     * @param description is the description attached to the snapshot.
     */
    public Snapshot(List<IShape> shapes, String description) {
        this.description = description;
        this.shapes = shapes;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * This is the getTimestamp() method.
     * @return the timestamp.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * This is the getTimestampString() method.
     * @return the string representation of timestamp.
     */
    public String getTimestampString() {
        return timestamp.toString();
    }

    /**
     * This is the toString() method.
     * It is used in class Main to print out information.
     * @return the string representation of snapshot.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Snapshot ID: ").append(timestamp.toString()).append("\n");
        sb.append("Timestamp: ").append(timestamp.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))).append("\n");
        sb.append("Description: \n"); // you can add a specific description if needed
        sb.append("Shape Information:\n");

        for (IShape shape : shapes) {
            sb.append(shape.getDescription()).append("\n");
        }
        return sb.toString();
    }

    /**
     * This is the getShapes() method.
     * @return the list of shapes
     */
    public List<IShape> getShapes(){
        return shapes;
    }

    /**
     * This is the getDescription() method.
     * @return the description of the snapshot
     */
    public String getDescription(){
        return description;
    }
}
