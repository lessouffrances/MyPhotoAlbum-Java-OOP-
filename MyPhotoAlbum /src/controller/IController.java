package controller;

import album.Snapshot;

/**
 * This is the IController interface.
 * It coordinates the commands from the input file and the photo album containing snapshots and shapes.
 */
public interface IController {

  /**
   * This is the getWidth() method.
   * @return is the width of the designated area.
   */
  int getWidth();

  /**
   * This is the getHeight() method.
   * @return is the height of the designated area.
   */
  int getHeight();

  /**
   * This is the hasNextSnapshot() method.
   * @return true if there are snapshots; otherwise false.
   */
  boolean hasNextSnapshot();

  /**
   * This is the nextSnapshot() method.
   * It serves as a pointer-like device for snapshots.
   */
  void nextSnapshot();

  /**
   * This is the hasPreviousSnapshot() method.
   * @return true if it has; otherwise, false.
   */
  boolean hasPreviousSnapshot();

  /**
   * This is the previousSnapshot() method.
   * It serves as a pointer-like device for snapshots.
   */
  void previousSnapshot();

  /**
   * This is the getCurrentSnapshot() method.
   * @return the current snapshot.
   */
  Snapshot getCurrentSnapshot();

  /**
   * This is the getSnapshotByIndex() method.
   * @param index is the index intended to get.
   * @return the Snapshot located at the index.
   */
  Snapshot getSnapshotByIndex(int index);

  /**
   * This is the getAllSnapshotTimestamps() method.
   * @return all the timestamps in a list of Strings.
   */
  String[] getAllSnapshotTimestamps();
}
