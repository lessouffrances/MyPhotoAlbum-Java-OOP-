package transformations;

import shapes.IShape;

/**
 * This is the Transformation interface.
 */
public interface ITransformation {

  /**
   * This is the apply() method.
   * @param shape is the shape that this transformation is applied on.
   */
  void apply(IShape shape);
}
