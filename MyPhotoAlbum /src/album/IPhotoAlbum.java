package album;

import shapes.IShape;
import java.util.List;
import transformations.ITransformation;

/**
 * The PhotoAlbum interface manages a list of shapes and snapshots,
 * and it can take snapshots of the current state of shapes.
 * All these methods belong to this class are of an "album" level.
 */
public interface IPhotoAlbum {

  /**
   * This is the addShape() method.
   * @param shape is the newly-added shape.
   */
  void addShape(IShape shape);

  /**
   * This is the removeShape() method.
   * @param shape is the recently-removed shape.
   */
  void removeShape(IShape shape);

  /**
   * This is the getSnapshotsByDate() method.
   * This method belongs to this class is of an "album" level.
   * @param dateString is the date information that required for retrieval.
   * @return the list of snapshots taken on the passed-in date.
   */
  List<Snapshot> getSnapshotsByDate(String dateString);

  /**
   * This is the applyTransformation() method.
   * This method belongs to this class is of an "album" level.
   * @param transformation is the transformation to be applied.
   * @param selectedShapes are the shapes selected to receive the passed-in transformation.
   */
  void applyTransformation(ITransformation transformation, List<IShape> selectedShapes);

  /**
   * This is the takeSnapshot() method.
   * This method belongs to this class is of an "album" level.
   */
  void takeSnapshot();

  /**
   * This is the takeSnapshot() useful version (deep copy).
   * This method belongs to this class is of an "album" level.
   */
  void takeSnapshot(String description);

  /**
   * This is the resetSnapshots() method
   * This method belongs to this class is of an "album" level.
   */
  void resetSnapshots();

  /**
   * This is the getNumberOfShapes() method.
   * This method belongs to this class is of an "album" level.
   * @return the number of shapes.
   */
  int getNumberOfShapes();

  /**
   * This is the getNumberOfSnapshots() method.
   * This method belongs to this class is of an "album" level.
   * @return the number of snapshots taken.
   */
  int getNumberOfSnapshots();

  /**
   * This is the getSnapshotTimestamps() method.
   * This method belongs to this class is of an "album" level.
   * @return a string of timestamps of snapshots taken.
   */
  String getSnapshotTimestamps();

  /**
   * This is the renderSnapshot() method.
   * @return the string representation of the snapshots.
   */
  String renderSnapshot();

  /**
   * This is the renderPhotoAlbum() method.
   * @return the string representation of the photo album.
   */
  String renderPhotoAlbum();

  /**
   * This is the getShapeByName() method.
   * @param name is the name of the shape.
   * @return a list of the shapes that have this name.
   */
  List<IShape> getShapesByName(String name);

  /**
   * This is the getSnapshots() method.
   * It allows external entities to get access to the snapshots.
   * Returns the list of snapshots.
   * @return the list of snapshots.
   */
  public List<Snapshot> getSnapshots();
}
