package soliddesign;

import shapes.IShape;
import shapes.Rectangle;
import shapes.Oval;
import shapes.Triangle;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * This is the ShapeFactory class.
 * It implements the IFactory interface,
 * creating multiple objects of multiple shapes.
 */
public class ShapeFactory implements IFactory {
    private Map<String, Supplier> creators;

    /**
     * This is the constructor for ShapeFactory class.
     * It pulls the stuff in.
     */
    public ShapeFactory() {
        this.creators = new HashMap<>();
        this.creators.put("RECTANGLE", Rectangle::new);
        this.creators.put("OVAL", Oval::new);
        this.creators.put("TRIANGLE", Triangle::new);
        // etc.
    }

    /**
     * This is the create() method.
     *
     * @param product is the product that client needs.
     * @return the product instance.
     * This method belongs to the class for it creates the shape object from the constructor.
     */
    @Override
    public IShape create(String product) {
        Supplier creationMethod = this.creators.get(product.toUpperCase());
        if (creationMethod == null) {
            return null;
        }
        return (IShape) creationMethod.get();
    }
}
