package controller;

import album.PhotoAlbum;
import shapes.IShape;
import transformations.ITransformation;
import transformations.ResizeTransformation;
import java.util.List;

/**
 * This is the ResizeCommand class.
 * It is one of the child classes of BaseCommand.
 */
public class ResizeCommand extends BaseCommand {

    /**
     * This is the constructor for ResizeCommand class.
     * @param album is the photo album.
     * @param words are the actual tokenized input.
     * @param line is the line being processed.
     */
    public ResizeCommand(PhotoAlbum album, String[] words, String line) {
        super(album, words, line);
    }

    /**
     * This is the execute() method.
     * Just as the way ResizeTransformation is defined,
     * It will apply the ResizeTransformation to the selected shapes.
     */
    @Override
    public void execute() {
        String shapeName = words[1];
        int newDimensionX = Integer.parseInt(words[2]);
        int newDimensionY = Integer.parseInt(words[3]);
        List<IShape> selectedShapes = album.getShapesByName(shapeName);
        ITransformation transformation = new ResizeTransformation(newDimensionX, newDimensionY);
        album.applyTransformation(transformation, selectedShapes);
    }
}
