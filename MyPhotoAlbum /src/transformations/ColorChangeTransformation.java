package transformations;

import shapes.IShape;

/**
 * The ColorChangeTransformation class represents a transformation
 * that changes the color of a shape to a specified color.
 */
public class ColorChangeTransformation implements ITransformation {
  private int red;
  private int green;
  private int blue;

  /**
   * This is the constructor for class ColorChangeTransformation.
   * @param red is the degree for Red in RGB.
   * @param green is the degree for Green in RGB.
   * @param blue is the degree for Blue in RGB.
   */
  public ColorChangeTransformation(int red, int green, int blue) {
    if (red < 0 || green < 0 || blue < 0) {
      throw new IllegalArgumentException("Input number should in range [0, 255]!");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * This is the apply() method.
   * This method belongs to this class for applying the transformation in the constructor.
   * @param shape is the shape that this transformation is applied on.
   */
  @Override
  public void apply(IShape shape) {
    shape.changeColor(red, green, blue);
  }
}
