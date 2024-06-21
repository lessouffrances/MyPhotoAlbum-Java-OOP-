package controller;

import album.PhotoAlbum;
import shapes.IShape;
import shapes.Oval;
import shapes.Rectangle;
import java.awt.Color;

/**
 * This is the ShapeCommand class.
 * It is one of the child classes of BaseCommand.
 */
public class ShapeCommand extends BaseCommand {

    /**
     * This is the constructor for ShapeCommand class.
     * @param album is the photo album.
     * @param words are the actual tokenized input.
     * @param line is the line being processed.
     */
    public ShapeCommand(PhotoAlbum album, String[] words, String line){
        super(album, words, line);
    }

    /**
     * This is the execute() method.
     * It parses the goal in details from the inputs, then create and add the shapes as required.
     */
    @Override
    public void execute() {
        String name = words[1];
        String type = words[2];
        int x = Integer.parseInt(words[3]);
        int y = Integer.parseInt(words[4]);
        int dimensionX = Integer.parseInt(words[5]);
        int dimensionY = Integer.parseInt(words[6]);
        int r = Integer.parseInt(words[7]);
        int g = Integer.parseInt(words[8]);
        int b = Integer.parseInt(words[9]);
        IShape shape = null;

        if (type.equalsIgnoreCase("rectangle")){
            shape = new Rectangle(name, x, y, dimensionX, dimensionY, new Color(r, g, b));
        }
        else if(type.equalsIgnoreCase("oval")){
            shape = new Oval(name, x, y, dimensionX, dimensionY, new Color(r, g, b));
        }
        album.addShape(shape);
    }
}
