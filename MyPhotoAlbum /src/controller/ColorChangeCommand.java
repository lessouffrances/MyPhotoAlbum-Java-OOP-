package controller;

import album.PhotoAlbum;
import shapes.IShape;
import transformations.ColorChangeTransformation;
import transformations.ITransformation;
import java.util.List;

/**
 * This is the ColorChangeCommand class.
 * It is one of the child classes of BaseCommand.
 */
public class ColorChangeCommand extends BaseCommand {

    /**
     * This is the constructor for ColorChangeCommand class.
     * @param album is the photo album.
     * @param words are the actual tokenized input.
     * @param line is the line being processed.
     */
    public ColorChangeCommand(PhotoAlbum album, String[] words, String line) {
        super(album, words, line);
    }

    /**
     * This is the execute() method.
     * Just as the way ColorTransformation is defined,
     * It will apply the ColorTransformation to the selected shapes.
     */
    @Override
    public void execute() {
        String shapeName = words[1];
        int r = Integer.parseInt(words[2]);
        int g = Integer.parseInt(words[3]);
        int b = Integer.parseInt(words[4]);
        List<IShape> selectedShapes = album.getShapesByName(shapeName);
        ITransformation transformation = new ColorChangeTransformation(r, g, b);
        album.applyTransformation(transformation, selectedShapes);
    }
}
