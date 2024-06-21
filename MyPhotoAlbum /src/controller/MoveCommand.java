package controller;

import album.PhotoAlbum;
import shapes.IShape;
import transformations.ITransformation;
import transformations.MoveTransformation;
import java.util.List;

/**
 * This is the MoveCommand class.
 * It is one of the child classes of BaseCommand.
 */
public class MoveCommand extends BaseCommand {

    /**
     * This is the constructor for MoveCommand class.
     * @param album is the photo album.
     * @param words are the actual tokenized input.
     * @param line is the line being processed.
     */
    public MoveCommand(PhotoAlbum album, String[] words, String line) {
        super(album, words, line);
    }

    /**
     * This is the execute() method.
     * Just as the way MoveTransformation is defined,
     * It will apply the MoveTransformation to the selected shapes.
     */
    @Override
    public void execute() {
        String shapeName = words[1];
        List<IShape> selectedShapes = album.getShapesByName(shapeName);
        int x = selectedShapes.get(0).getX();
        int y = selectedShapes.get(0).getY();
        int newX = Integer.parseInt(words[2]);
        int newY = Integer.parseInt(words[3]);
        ITransformation transformation = new MoveTransformation(newX - x,newY - y);
        album.applyTransformation(transformation,selectedShapes);
    }
}
