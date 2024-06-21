package transformations;

import shapes.IShape;

/**
 * The ResizeTransformation class represents a transformation
 * that resizes a shape to a specified width and height.
 */
public class ResizeTransformation implements ITransformation {
  private int newDimensionX, newDimensionY;

  /**
   * This is the constructor for class MoveTransformation.
   * @param newDimensionX is the new dimensionX of the shape.
   * @param newDimensionY is the new dimensionY of the shape.
   */
  public ResizeTransformation(int newDimensionX, int newDimensionY) {
    if (newDimensionX <= 0 || newDimensionY <= 0) {
      throw new IllegalArgumentException("Input cannot be 0 or negative!");
    }
    this.newDimensionX = newDimensionX;
    this.newDimensionY = newDimensionY;
  }

  /**
   * This is the apply() method.
   * This method belongs to this class for applying the transformation in the constructor.
   * @param shape is the shape that this transformation is applied on.
   */
  @Override
  public void apply(IShape shape) {
    shape.resize(newDimensionX, newDimensionY);
  }
}
