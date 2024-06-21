package transformations;

import shapes.IShape;

/**
 * The MoveTransformation class represents a transformation
 * that moves a shape by a specified delta in the X and Y directions.
 */
public class MoveTransformation implements ITransformation {
  private int deltaX, deltaY;

  /**
   * This is the constructor for class MoveTransformation.
   * @param deltaX is the change in coordinate X.
   * @param deltaY is the change in coordinate Y.
   */
  public MoveTransformation(int deltaX, int deltaY) {
    this.deltaX = deltaX;
    this.deltaY = deltaY;
  }

  /**
   * This is the apply() method.
   * This method belongs to this class for applying the transformation in the constructor.
   * @param shape is the shape that this transformation is applied on.
   */
  @Override
  public void apply(IShape shape) {
    shape.move(deltaX, deltaY);
  }
}
