package album;

import shapes.IShape;
import java.util.List;
import java.time.LocalDateTime;

/**
 * The Snapshot interface represents a snapshot of the shapes' state
 * and provides a toString method to render the snapshot as a string.
 * All methods belong to this class are about Snapshot.
 */
public interface ISnapshot {

  /**
   * This is the getTimestamp() method.
   * @return the timestamp.
   */
  LocalDateTime getTimestamp();

  /**
   * This is the getTimestampString() method.
   * @return the string representation of timestamp.
   */
  String getTimestampString();

  /**
   * This is the toString() method.
   * It is used in class Main to print out information.
   * @return the string representation of snapshot.
   */
  String toString(); // inherited from Object class

  /**
   * This is the getShapes() method.
   * @return the list of shapes
   */
  List<IShape> getShapes();

  /**
   * This is the getDescription() method.
   * @return the description of the snapshot
   */
  String getDescription();
}
