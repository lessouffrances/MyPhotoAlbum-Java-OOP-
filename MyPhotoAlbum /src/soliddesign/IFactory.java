package soliddesign;

import shapes.IShape;

/**
 * This is the IFactory interface.
 */
public interface IFactory {
    /**
     * This is the create() method.
     *
     * @param product is the product that the client asks for.
     * @return an object of the passed-in shape.
     */
    IShape create(String product);
}
